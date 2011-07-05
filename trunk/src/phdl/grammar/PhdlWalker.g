/*
    Copyright (C) 2011  BYU Configurable Computing Lab

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * A tree grammar that walks a the output of the PHDL parser.  It operates on a stream of 
 * tree nodes of the form (parent child1 child2 ... childN) where each node may be the
 * root of another subtree.
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 */
tree grammar PhdlWalker;

options {
	language = Java;
	tokenVocab = Phdl;
	ASTLabelType = CommonTree;
}

@header {
	package phdl.graph;
	import java.util.TreeSet;
	import java.util.SortedSet;
	import java.util.List;
	import java.util.ArrayList;
	import phdl.graph.*;
}

@members {

  private String code = "";

	private SortedSet<String> errors = new TreeSet<String>();
	
	@Override
    public void displayRecognitionError(String[] tokenNames,
                                        RecognitionException e) {
        String hdr = getErrorHeader(e);
        String msg = getErrorMessage(e, tokenNames);
        errors.add(input.getSourceName() + hdr + " " + msg);
    }
    
//    @Override
//    protected Object recoverFromMismatchedToken(IntStream input,
//                                            int ttype,
//                                            BitSet follow)
//    throws RecognitionException
//	{   
//    	throw new MismatchedTokenException(ttype, input);
//	}  
}

/** 
 * The Source Text rule returns the design units with all data structures populated and processed
 */
sourceText[DesignNode d] returns [DesignNode dn]
	:	
		design[d]
		{dn = d;}
		EOF
	;

/** 
 * Looks for the keyword "design" as the parent of a subtree, and makes a new design named
 * from the first child in the subtree.  Succeeding children in the subtree before the "begin"
 * keyword are either device or net declarations.  The line number and position of the design
 * declaration are also used in the constructor to report future compilation errors.
 */	
design[DesignNode d]
	:	^('design' name=IDENT
		
		// create a new design declaration and set appropriate fields
		{	d.setupDesign(name);
		  d.setName($name.text);
			d.setLine($name.line);
			d.setPos($name.pos);
			d.setFileName(input.getSourceName());
		}
		
		// String building for debugging
		{ code += "DESIGN" + $name.text + "[" + $name.line + ":" + $name.pos + "]\n"; }
			
		// device and net declarations
		(deviceDecl[d] | netDecl[d])*
		
		// seperates declarations from instances
		'begin'
		
		// add all instances subDesigns and netAssignments to the design
		(instDecl[d] | netAssign[d])*
		)
	;

/** Looks for the keyword "device" as the parent of a subtree, and makes a new device named
 * from the first child in the subtree.  Succeeding children in the subtree before the "begin"
 * keyword are attribute declarations.  Children after the "begin" keyword are pin declarations.  
 * The line number and position of the device are also used in the constructor to report future 
 * compilation errors.
 */	
deviceDecl[DesignNode d]
	:	^('device' name=IDENT
	
			// make a new device based on the identifier and log its location 				
			{	DeviceNode dev = d.setupDevice(name);
			  DeviceNode dev = new DeviceNode(d);
				dev.setName($name.text);
				dev.setLine($name.line);
				dev.setPos($name.pos);
				dev.setFileName(input.getSourceName());
			}
			
			// String building for debugging
      { code += "\tDEVICE " + $name.text + "[" + $name.line + ":" + $name.pos + "]\n"; }
			
			// add all of the attribute declarations to the device
			(
			  (
			    { AttributeNode a  = new AttributeNode(dev); } 
			    attributeDecl[a]
			    { dev.addAttribute(a); }
			  )
	    |
			  (
			    { PinNode p = new PinNode(dev); }
			    pinDecl[p]
			    { dev.addPin(p); }
			  )
			)*
		
		)
		
		// attempt to add the device declaration
		{	if(!d.addDeviceDecl(dev)) {
				System.err.println(dev.getName() + " " + dev.getLine() + ":" + dev.getPosition() + " - duplicate device declaration");
				System.exit(1);
			}
		}
	;

/** Looks for the keyword "net" as the parent of a subtree, and makes a new net named from the 
 * first child in the subtree.  Succeeding children in the subtree define the other properties
 * of the net.  Optional attributes are added if they follow an "is" keyword.
 */
netDecl[DesignNode d]
	:	^('net'
	   { code += "\tNET"; }
	   { List<Integer> slices = new ArrayList<Integer>(); }
	   sliceList[slices]?
	   name=IDENT
		{ code += $name.text; }
		{ List<AttributeNode> attrs = new ArrayList<AttributeNodes>(); }
		(
		  { AttributeNode a = new AttributeNode(null); }
		  attributeDecl[a]
		  { attrs.add(a); }
		)*
		
		{   List<NetNode> nodes = new ArrayList<NetNode>();
        for (Integer i : slices) {
          NetNode newNode = new NetNode(d);
          newNode.setName($name.text + "[" + i + "]");
          newNode.setLine($name.line);
          newNode.setPos($name.pos);
          newNode.setFileName(input.getSourceName());
          for (a : attrs) {
            a.setParent(newNode);
            newNode.addAttribute(a);
          }
          nodes.add(newNode);
        }
    }
		)
		// add the net to the design
		{	for (NetNode n : nodes) {
		    if(!d.addNetNode(n)) {
		      System.err.println(n.getName() + " " + n.getLine() + ":" + n.getPosition() + " - duplicate net declaration");
          System.exit(1);
        }
			}
		}
	;
	
attributeDecl[AttributeNode a]
  :
    ^('attr'
      name = IDENT
      value = STRING_LITERAL
      { code += "\t\tATTR" + $name.text + "[" + $name.line + ":" + $name.pos + "] = " + $value.text; }
      {
        a.setName($name.text);
        a.setValue($value.text);
      }
    )
  ;
	
sliceList[List<Integer> slices]
  :^( (',' | ':')
  '['
  start = INT
  (
    end = INT
    {
      if (start <= end) {
        for (int i = start; i <= end; i++) {
          slices.add(i);
        }
      }
      else {
        for (int i = start; i >= end; i--) {
           slices.add(i);
        }
      }
    }
    { code += "[" + start + ":" + end + "]"; }
  | 
    { code += "[" + start; }

    {slices.add(Integer.parseInt($start.text));}
      (
      next = INT
      { code += "," + $next.text; }
      {slices.add(Integer.parseInt($next.text));}
    )*
    { code += "]"; }
  )
  ']'
  )
  ;

/** Looks for the keywords below as the root of a subtree, and creates the appropriate type of pin in 
 * the data structure by switching on that keyword.  Uses the helper rule addPinDecl to populate the 
 * pin with values.
 */	
pinDecl[DeviceNode d]
	:	^('pin' {code += "\t\tPIN";}{PinNode pin = new PinNode(d);} addPinDecl[d])
//	|	^('in' {PinDecl in = new PinDecl(Type.IN);} addPinDecl[d, in])
//	|	^('out' {PinDecl out = new PinDecl(Type.OUT);} addPinDecl[d, out])
//	|	^('inout' {PinDecl inout = new PinDecl(Type.INOUT);} addPinDecl[d, inout])
//	|	^('passive' {PinDecl passive = new PinDecl(Type.PASSIVE);} addPinDecl[d, passive])
//	|	^('supply' {PinDecl supply = new PinDecl(Type.SUPPLY);} addPinDecl[d, supply])
//	|	^('power' {PinDecl power = new PinDecl(Type.POWER);} addPinDecl[d, power])
	;
	
/** The helper rule for pinDecl.  It sets all the fields of the pin as they are found after
 * each of the keywords above.  The MSB and LSB are set to zero if they are not present.
 */
addPinDecl[DeviceNode d]
	:	 { List<Integer> slices = new ArrayList<Integer>(); }
     
     sliceList[slices]?
     name=IDENT
     
     { code += $name.text + "[" + $name.line + ":" + $name.pos + "]"; }
     { List<String> pList = new ArrayList<String>(); }
     
     pinList[pList]?
    
    {   if (slices.size() != pList.size()) {
          System.err.println($name.text + " " + $name.line + ":" + $name.pos +
                              " - invalid pin mapping; size of bit vector: "
                              + slices.size() + ", size of pin list: "
                              + pList.size());
          System.exit(1);
        }
        List<PinNode> pins = new ArrayList<PinNode>();
        for (Integer i : slices) {
          PinNode newPin = new PinNode(d);
          newPin.setName($name.text + "[" + i + "]");
          newPin.setLine($name.line);
          newPin.setPos($name.pos);
          newPin.setFileName(input.getSourceName());
          newPin.setPinName(pList.get(i));
          if (!d.addPinNode(newPin)) {
            System.err.println(newPin.getName() + " " + newPin.getLine() + ":" + newPin.getPosition()
                                + " - duplicate pin declaration");
            System.exit(1);
          }
        }
      }
	;
	
pinList[List<String> pList]
  :
    ^(
      '{'
      value = IDENT
      { code += " = \"" + $value.text; }
      { pList.add($value.text); }
     (','
       next = IDENT
       { pList.add($next.text); }
       { code += ", " + $next.text; }
     )*
      '}'
      { code += "\"";}
     )
  ;

/** Looks for the keyword "inst" as the root of a subtree, and creates a new instDecl based on the
 * succeding children in the subtree.  Attribute and pin assignments are added with their own rules.
 */	
instDecl[DesignNode d]
	:	^('inst' name=IDENT refName=IDENT 
	
	   { List<Integer> indices = new ArrayList<Integer>(); }
	   { code += "\tINSTANCE " + $name.text + "[" + $name.line + ":" + $name.pos + "]"; }
	   
	   arrayList[indices]?
	   
		{	
		  for (Integer i : indices) {
		    InstanceNode n = new InstanceNode(d);
		    n.setName($name.text + "(" + i + ")");
		    n.setLine($name.line);
		    n.setPosition($name.pos);
		    for (DeviceNode dn : d.getDevices()) {
		      if (dn.getName().equals($name.text)) {
		        n.setDevice(dn);
		        for (PinNode p : dn.getPins()) {
		          PinNode newP = new PinNode(n);
		          newP.setName(p.getName());
		          n.addPin(newP);
		        }
		        for (AttributeNode a : dn.getAttribute()) {
		          AttributeNode newA = new AttributeNode(n);
		          newA.setName(a.getName());
		          n.addAttribute(newA);
		        }
		        break;
		      }
		    }
		  }
		}
		  ( attrAssign[n, indices] |	pinAssign[n, indices] )*
		
		)
		
		{	if(!d.addInstance(n)) {
		    System.err.println(i.getName() + " " + i.getLine() + ":" + i.getPosition()
                                + " - duplicate instance declaration");
        System.exit(1);
			}
		}
	;

arrayList[List<Integer> indices]
	 : ^((':' | ',')
	   '('
		    (
		      first = INT last = INT
		      { code += "[" + $first.text + ":" + $last.text + "]"; }
		      {
		        int start = Integer.parseInt($first.text);
		        int end = Integer.parseInt($last.text);
		        if (start < end) {
		          for (int i = start; i <= end; i++) {
		            indices.add(i);
		          }
		        }
		        else {
		          for (int i = start; i >= end; i--) {
		             indices.add(i);
		          }
		        }
		      }
		    | first = INT
		      { code += "[" + $first.text; }
		      { indices.add(Integer.parseInt($first.text)); }
		      (
		        next = INT
		        { code += "," + $next.text; }
		        { indices.add(Integer.parseInt($next.text)); }
		      )*
		      { code += "]"; }
		    )
		  ')'
		  )
  ;

/**	Looks for an "=" sign as the parent of a subtree.  Succeding values consist of left values
 * and right values, with optional widths or indices.  A width is used to specify an array of values
 * assigned, while an index is used to reference a particular value in an array.  Creates a new
 * attribute assignment data structure based on these parameters.
 */
attrAssign[InstNode i, List<Integer> instIndices]
	:	//('new' 'attr'!)? instanceQualifier? IDENT EQUALS^ STRING_LITERAL SEMICOLON!
	  ^('='
	   { AttributeNode a; }
	   	('new'
	    	{ a = new AttributeNode(i);
        	List<Integer> indices = new ArrayList<Integer>();	     
	    }	
	  	)? instanceQualifier[i.getName(), indices, instIndices]? name = IDENT value = STRING_LITERAL
	  	)
     {	  		  
	   if (a == null) {
	     for (Integer index : indices) {
	       if (!instIndices.contains(index)) {
	         System.err.println($name.text + " " + $name.line + ":" + $name.getPosition()
	                               + " - index out of bounds, " + index);
           System.exit(1);
	       }
	       for (AttributeNode n : i.getAttributes()) {
	         if (n.getName().equals($name.text + "(" + index + ")") {
	           n.setValue($value.text);
	           break;
	         }
	       }
	     }
	   }
	   else {
	     for (Integer index : indices) {
	       a = new AttributeNode(i);
		     a.setName($name.text + "(" + index + ")");
		     a.setValue($value.text);
		     if (!i.addAttribute(a)) {
		       System.err.println(a.getName() + " " + a.getLine() + ":" + a.getPosition()
	                                + " - duplicate attribute declaration");
	         System.exit(1);
		     }
		   }
	   }
	 }
	;

instanceQualifier[String refName, List<Integer> indices, List<Integer> instIndices]
  : //IDENT '.'^  
    //| IDENT arrayList '.'^
    ^( '.'
    ( name = IDENT { indices.addAll(instIndices); }
    | name = IDENT arrayList[indices])
    )
    {
      if (!refName.equals($name.text)) {
        System.err.println($name.text + " " + $name.line + ":" + $name.pos
                                + " - invalid instance reference");
        System.exit(1);
      }
    }
  ;


/**	
 * Looks for an "=" sign as the parent of a subtree and sets appropriate fields  
 */	
pinAssign[InstNode i, List<Integer> instIndices]
	: // instanceQualifier? IDENT sliceList? EQUALS^ concatenation SEMICOLON!
	  ^('='
	  { List<Integer> indices = new ArrayList<Integer>(); }
	  instanceQualifier[i.getName(), indices, instIndices]?
	  name = IDENT
	  { List<Integer> slices = new ArrayList<Integer>(); }
	  sliceList[slices]?
	  
	  {
	   for (Integer index : indices) {
	     
	     for (Integer slice : slices) {
	       
	     }
	   }
	  }
	  
		concatPin[p]*
		)

		{	if(!i.addPinAssign(p)) 
				addError(p, "duplicate pin assignment");
		}
	;

/**
 * Helper rule for pinAssign.  Adds any nets that exist in the concatenation list.
 */	
concatPin[PinAssign pa]
	:	(name=IDENT (slice=SLICE_LIST)?)
		{
			Net n = new Net();
			n.setName($name.text);
			n.setLine($name.line);
			n.setPos($name.pos);
			n.setSliceString($slice.text);
			n.setFileName(input.getSourceName());
			pa.addNet(n);
			
			if(!n.makeBits())
				addError(n, "invalid slice format");
		}
	;

/**	
 * Looks for an "=" sign as the parent of a subtree and fills in the appropriate fields following.
 */	
netAssign[DesignDecl d]
	:	^(EQUALS name=IDENT (slice=SLICE_LIST)?
		
		// make a new net assignment
		{	NetAssign n = new NetAssign(); 
			n.setName($name.text);
			n.setLine($name.line);
			n.setPos($name.pos);
			n.setSliceString($slice.text);
			n.setFileName(input.getSourceName());
			
			if(!n.makeBits())
				addError(n, "invalid slice format");
		}
		
		concatNet[n]*
		)
		{	if(!d.addNetAssign(n)) 
				addError(n, "duplicate net assignment");
		}
	;

/**
 * Helper rule for netAssign.  Adds any nets that exist in the concatenation list.
 */	
concatNet[NetAssign na]
	:	(name=IDENT (slice=SLICE_LIST)?)
	
		// add a net to the net assignment
		{	Net n = new Net();
			n.setName($name.text);
			n.setLine($name.line);
			n.setPos($name.pos);
			n.setSliceString($slice.text);
			n.setFileName(input.getSourceName());
			na.addNet(n);
			
			if(!n.makeBits())
				addError(n, "invalid slice format");
		}
	;

/* These features associated with sub-designs are not yet implemented
portDecl[DesignDecl d]
	:	^('pin' {PortDecl pin = new PortDecl(Type.PIN);} addPort[d, pin])
	|	^('in' {PortDecl in = new PortDecl(Type.IN);} addPort[d, in])
	|	^('out' {PortDecl out = new PortDecl(Type.OUT);} addPort[d, out])
	|	^('inout' {PortDecl inout = new PortDecl(Type.INOUT);} addPort[d, inout])
	|	^('passive' {PortDecl passive = new PortDecl(Type.PASSIVE);} addPort[d, passive])
	|	^('supply' {PortDecl supply = new PortDecl(Type.SUPPLY);} addPort[d, supply])
	|	^('power' {PortDecl power = new PortDecl(Type.POWER);} addPort[d, power])
	;

addPort[DesignDecl d, PortDecl p]
	:	(array=INDEX_LIST)? name=IDENT
		{	
			p.setName($name.text);
			p.setLine($name.line);
			p.setPos($name.pos);
			p.setArray($array.text);
			p.setFileName(input.getSourceName());
			
			if(!d.addPortDecl(p)) 
				addError(p, "duplicate port declaration");
		}
	;

subDesign[DesignDecl d]
	:	^('sub' name=IDENT refName=IDENT (msb=INT COLON lsb=INT)?
		
		// make a new instDecl to pass to attrAssign and pinAssign
		{	
			SubDecl s = new SubDecl();
			s.setName($name.text);
			s.setLine($name.line);
			s.setPos($name.pos);
			s.setMsb($msb!=null?Integer.parseInt($msb.text):-1);
			s.setLsb($lsb!=null?Integer.parseInt($lsb.text):-1);
			s.setRefName($refName.text);
			s.setFileName(input.getSourceName());
		}
		subAttrAssign[s]*
		'begin'
		portAssignment[s]*
		)
		{	if(!d.addSubDecl(s)) 
				addError(s, "duplicate sub-design declaration");
		}
	;

subAttrAssign[SubDecl s]
	:	^(instName=IDENT name=IDENT 
		((msb=INT COLON lsb=INT) | (index=INT) | indices=NUMBER_LIST)? 
		value=STRING_LITERAL )
		
		// make a new sub-attribute assignment
		{	SubAttrAssign a = new SubAttrAssign();
			a.setInstName($instName.text);
			a.setName($name.text);
			a.setLine($name.line);
			a.setPos($name.pos);
			a.setMsb($msb!=null?Integer.parseInt($msb.text):-1);
			a.setLsb($lsb!=null?Integer.parseInt($lsb.text):-1);
			a.setIndex($index!=null?Integer.parseInt($index.text):-1);
			a.setIndices($indices.text);
			a.setValue($value.text);
			a.setFileName(input.getSourceName());
			
			if(!s.addSubAttrAssign(a)) 
				addError(a, "duplicate sub-design attribute assignment");
		}
	;

portAssignment[SubDecl s]
	:	^(EQUALS name=IDENT 
		(((instMsb=INT COLON instLsb=INT) | (instIndex=INT) | instIndices=NUMBER_LIST)
		((msb=INT COLON lsb=INT) | (index=INT) | indices=NUMBER_LIST)?)?
	
		// make a new port assignment
		{	PortAssign p = new PortAssign(); 
			p.setName($name.text);
			p.setLine($name.line);
			p.setPos($name.pos);
			p.setInstMsb($instMsb!=null?Integer.parseInt($instMsb.text):-1);
			p.setInstLsb($instLsb!=null?Integer.parseInt($instLsb.text):-1);
			p.setInstIndex($instIndex!=null?Integer.parseInt($instIndex.text):-1);
			p.setInstIndices($instIndices.text);
			p.setMsb($msb!=null?Integer.parseInt($msb.text):-1);
			p.setLsb($lsb!=null?Integer.parseInt($lsb.text):-1);
			p.setIndex($index!=null?Integer.parseInt($index.text):-1);
			p.setIndices($indices.text);
			p.setFileName(input.getSourceName());
		}
	
		concatPort[p]*
		)
		{	if(!s.addPortAssign(p)) 
				addError(p, "duplicate port assignment");
		}
	;

concatPort[PortAssign pa]
	:	(name=IDENT ((msb=INT COLON lsb=INT) | (index=INT) | indices=NUMBER_LIST)?)
		{	Net n = new Net();
			n.setName($name.text);
			n.setLine($name.line);
			n.setPos($name.pos);
			n.setMsb($msb!=null?Integer.parseInt($msb.text):-1);
			n.setLsb($lsb!=null?Integer.parseInt($lsb.text):-1);
			n.setIndex($index!=null?Integer.parseInt($index.text):-1);
			n.setFileName(input.getSourceName());
			pa.addNet(n);
		}
	;
	
*/
