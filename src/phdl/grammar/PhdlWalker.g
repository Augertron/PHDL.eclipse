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
	package phdl.parser;
	import java.util.TreeSet;
	import java.util.SortedSet;
}

@members {

	private SortedSet<String> errors = new TreeSet<String>();
	
	@Override
    public void displayRecognitionError(String[] tokenNames,
                                        RecognitionException e) {
        String hdr = getErrorHeader(e);
        String msg = getErrorMessage(e, tokenNames);
        errors.add(input.getSourceName() + hdr + " " + msg);
    }
    
    public SortedSet<String> getErrors() {
        return errors;
    }
    
    public void addError(Parsable p, String msg) {
    	errors.add(input.getSourceName() + " line " + p.getLineString() + " " + msg
				+ ": " + p.getName());
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
sourceText[ParsedDesigns pd] returns [ParsedDesigns designs]
	:	
		design[pd]*
		{designs = pd;}
	;

/** 
 * Looks for the keyword "design" as the parent of a subtree, and makes a new design named
 * from the first child in the subtree.  Succeeding children in the subtree before the "begin"
 * keyword are either device or net declarations.  The line number and position of the design
 * declaration are also used in the constructor to report future compilation errors.
 */	
design[ParsedDesigns pd]
	:	^('design' IDENT
		
		// create a new design declaration and set appropriate fields
		{	DesignDeclaration d = new DesignDeclaration();
			d.setName($IDENT.text);
			d.setLine($IDENT.line);
			d.setPos($IDENT.pos);
			d.setFileName(input.getSourceName());
		}
			
		// add any kind of declaration
		(portDecl[d] | deviceDecl[d] | netDecl[d])*
		
		// seperates declarations from instances
		'begin'
		
		// add all instances subDesigns and netAssignments to the design
		(instance[d] | subDesign[d] | netAssignment[d])*
		)
		
		{	if(!pd.addDesignDecl(d)) 
				addError(d, "duplicate design declaration");
		}
	;

/**
 * The port declaration rule looks for the keyword types that are shown below, and creates 
 * a new port declaration based on that type.  It then calls the addPort method to finish
 * setting all appropriate fields of the port declaration.
 */
portDecl[DesignDeclaration d]
	:	^('pin' {PortDeclaration pin = new PortDeclaration(Type.PIN);} addPort[d, pin])
	|	^('in' {PortDeclaration in = new PortDeclaration(Type.IN);} addPort[d, in])
	|	^('out' {PortDeclaration out = new PortDeclaration(Type.OUT);} addPort[d, out])
	|	^('inout' {PortDeclaration inout = new PortDeclaration(Type.INOUT);} addPort[d, inout])
	|	^('passive' {PortDeclaration passive = new PortDeclaration(Type.PASSIVE);} addPort[d, passive])
	|	^('supply' {PortDeclaration supply = new PortDeclaration(Type.SUPPLY);} addPort[d, supply])
	|	^('power' {PortDeclaration power = new PortDeclaration(Type.POWER);} addPort[d, power])
	;

/**
 * The add port rule finishes setting all the appropriate fields of the port declaration
 * and adds the port to the design declaration.
 */	
addPort[DesignDeclaration d, PortDeclaration p]
	:	(msb=INT lsb=INT)? name=IDENT
		{	
			p.setName($name.text);
			p.setLine($name.line);
			p.setPos($name.pos);
			p.setMsb($msb!=null?Integer.parseInt($msb.text):-1);
			p.setLsb($lsb!=null?Integer.parseInt($lsb.text):-1);
			p.setFileName(input.getSourceName());
			
			if(!d.addPortDecl(p)) 
				addError(p, "duplicate port declaration");
		}
	;

/** Looks for the keyword "device" as the parent of a subtree, and makes a new device named
 * from the first child in the subtree.  Succeeding children in the subtree before the "begin"
 * keyword are attribute declarations.  Children after the "begin" keyword are pin declarations.  
 * The line number and position of the device are also used in the constructor to report future 
 * compilation errors.
 */	
deviceDecl[DesignDeclaration d]
	:	^('device' name=IDENT 
	
			// make a new device based on the identifier and log its location 				
			{	DeviceDeclaration dev = new DeviceDeclaration();
				dev.setName($name.text);
				dev.setLine($name.line);
				dev.setPos($name.pos);
				dev.setFileName(input.getSourceName());
			}
			
		// add all of the attribute declarations to the device
		attributeDecl[dev]*
		
		// the begin token separates attribute declarations from pin declarations
		'begin'
		
		// add all of the pin declarations to the device
		pinDecl[dev]* 
		
		)
		
		// attempt to add the device declaration
		{	if(!d.addDeviceDecl(dev)) 
				addError(dev, "duplicate device declaration");
		}
	;

/** Looks for the keyword "net" as the parent of a subtree, and makes a new net named from the 
 * first child in the subtree.  Succeeding children in the subtree define the other properties
 * of the net.  Optional attributes are added if they exist after a colon.
 */
netDecl[DesignDeclaration d]
	:	^('net' (msb=INT lsb=INT)? name=IDENT
	
		// make a new net with the above information
		{	NetDeclaration n = new NetDeclaration(); 
			n.setName($name.text);
			n.setLine($name.line);
			n.setPos($name.pos);
			n.setMsb($msb!=null?Integer.parseInt($msb.text):-1);
			n.setLsb($lsb!=null?Integer.parseInt($lsb.text):-1);
			n.setFileName(input.getSourceName());
		}

		// add any optional net attributes after a colon
		(COLON netAttribute[n]+)?
		)
		
		// add the net to the design
		{	if(!d.addNetDecl(n)) 
				addError(n, "duplicate net declaration");
		}
	;

/** Helper method for netDecl.  Adds attributes after the colon if they exist in the tree.
 */	
netAttribute[NetDeclaration n]
	:	IDENT
	
		// attempt to add the net attribute						
		{	if(!n.addAttribute($IDENT.text)) 
				addError(n, "duplicate net attribute");
		}
	;

/** Looks for an "=" as the root of a subtree, and creates a new attribute based on the 
 * name and value of the children.
 */
attributeDecl[DeviceDeclaration d]
	:	^(EQUALS name=IDENT value=STRING_LITERAL) 
	
		// make a new attribute declaration with the above information
		{	AttributeDeclaration a = new AttributeDeclaration();
			a.setName($name.text);
			a.setLine($name.line);
			a.setPos($name.pos);
			a.setValue($value.text);
			a.setFileName(input.getSourceName());
			
			if(!d.addAttributeDecl(a)) 
				addError(a, "duplicate attribute declaration");
		}
	;

/** Looks for the keywords below as the root of a subtree, and creates the appropriate type of pin in 
 * the data structure by switching on that keyword.  Uses the helper rule addPin to populate the 
 * pin with values.
 */	
pinDecl[DeviceDeclaration d]
	:	^('pin' {PinDeclaration pin = new PinDeclaration(Type.PIN);} addPin[d, pin])
	|	^('in' {PinDeclaration in = new PinDeclaration(Type.IN);} addPin[d, in])
	|	^('out' {PinDeclaration out = new PinDeclaration(Type.OUT);} addPin[d, out])
	|	^('inout' {PinDeclaration inout = new PinDeclaration(Type.INOUT);} addPin[d, inout])
	|	^('passive' {PinDeclaration passive = new PinDeclaration(Type.PASSIVE);} addPin[d, passive])
	|	^('supply' {PinDeclaration supply = new PinDeclaration(Type.SUPPLY);} addPin[d, supply])
	|	^('power' {PinDeclaration power = new PinDeclaration(Type.POWER);} addPin[d, power])
	;
	
/** The helper rule for pinDecl.  It sets all the fields of the pin as they are found after
 * each of the keywords above.  The MSB and LSB are set to zero if they are not present.
 */
addPin[DeviceDeclaration d, PinDeclaration p]
	:	(msb=INT lsb=INT)? name=IDENT pinList=STRING_LITERAL
		{	
			p.setName($name.text);
			p.setLine($name.line);
			p.setPos($name.pos);
			p.setMsb($msb!=null?Integer.parseInt($msb.text):-1);
			p.setLsb($lsb!=null?Integer.parseInt($lsb.text):-1);
			p.setPinList($pinList.text);
			p.setFileName(input.getSourceName());
			
			if(!d.addPinDecl(p)) 
				addError(p, "duplicate pin declaration");
		}
	;	

/** Looks for the keyword "inst" as the root of a subtree, and creates a new instance based on the
 * succeding children in the subtree.  Attribute and pin assignments are added with their own rules.
 */	
instance[DesignDeclaration d]
	:	^('inst' name=IDENT refName=IDENT (msb=INT lsb=INT)?
		
		// make a new instance to pass to attributeAssignment and pinAssignment
		{	
			InstanceDeclaration i = new InstanceDeclaration();
				i.setName($name.text);
				i.setLine($name.line);
				i.setPos($name.pos);
				i.setMsb($msb!=null?Integer.parseInt($msb.text):-1);
				i.setLsb($lsb!=null?Integer.parseInt($lsb.text):-1);
				i.setRefName($refName.text);
				i.setFileName(input.getSourceName());
		}
				
		attributeAssignment[i]*
		'begin'
		pinAssignment[i]*
		)
		{	if(!d.addInstanceDecl(i)) 
				addError(i, "duplicate instance declaration");
		}
	;

/**	Looks for an "=" sign as the parent of a subtree.  Succeding values consist of left values
 * and right values, with optional widths or indices.  A width is used to specify an array of values
 * assigned, while an index is used to reference a particular value in an array.  Creates a new
 * attribute assignment data structure based on these parameters.
 */
attributeAssignment[InstanceDeclaration i]
	:	^(EQUALS name=IDENT ((msb=INT lsb=INT) | (index=INT))? value=STRING_LITERAL )
		
		// make a new attribute assignment, assign all values, and add it to the instance
		{	AttributeAssignment a = new AttributeAssignment();
			a.setName($name.text);
			a.setLine($name.line);
			a.setPos($name.pos);
			a.setMsb($msb!=null?Integer.parseInt($msb.text):-1);
			a.setLsb($lsb!=null?Integer.parseInt($lsb.text):-1);
			a.setIndex($index!=null?Integer.parseInt($index.text):-1);
			a.setValue($value.text);
			a.setFileName(input.getSourceName());
			
			if(!i.addAttributeAssignment(a)) 
				addError(a, "duplicate attribute assignment");
		}
	;


/**	Looks for an "=" sign as the parent of a subtree.  
 */	
pinAssignment[InstanceDeclaration i]
	:	^(EQUALS name=IDENT 
		((instMsb=INT instLsb=INT) | (instIndex=INT))?
		(COLON ((msb=INT lsb=INT) | (index=INT)))?
	
		// make a new pin assignment
		{
			PinAssignment p = new PinAssignment();
			p.setName($name.text);
			p.setLine($name.line);
			p.setPos($name.pos);
			p.setInstMsb($instMsb!=null?Integer.parseInt($instMsb.text):-1);
			p.setInstLsb($instLsb!=null?Integer.parseInt($instLsb.text):-1);
			p.setInstIndex($instIndex!=null?Integer.parseInt($instIndex.text):-1);
			p.setMsb($msb!=null?Integer.parseInt($msb.text):-1);
			p.setLsb($lsb!=null?Integer.parseInt($lsb.text):-1);
			p.setIndex($index!=null?Integer.parseInt($index.text):-1);
			p.setFileName(input.getSourceName());
		}
	
		concatenatePin[p]*
		)
		{	if(!i.addPinAssignment(p)) 
				addError(p, "duplicate pin assignment");
		}
	;
	
concatenatePin[PinAssignment pa]
	:	(name=IDENT ((msb=INT lsb=INT) | (index=INT))?)
		{
			Net n = new Net();
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
	
subDesign[DesignDeclaration d]
	:	^('sub' name=IDENT refName=IDENT (msb=INT lsb=INT)?
		
		// make a new instance to pass to attributeAssignment and pinAssignment
		{	
			SubDesignDeclaration s = new SubDesignDeclaration();
			s.setName($name.text);
			s.setLine($name.line);
			s.setPos($name.pos);
			s.setMsb($msb!=null?Integer.parseInt($msb.text):-1);
			s.setLsb($lsb!=null?Integer.parseInt($lsb.text):-1);
			s.setRefName($refName.text);
			s.setFileName(input.getSourceName());
		}

		portAssignment[s]*
		)
		{	if(!d.addSubDesignDecl(s)) 
				addError(s, "duplicate sub-design declaration");
		}
	;

/**	Looks for an "=" sign as the parent of a subtree.  
 */	
netAssignment[DesignDeclaration d]
	:	^(EQUALS name=IDENT ((msb=INT lsb=INT) | (index=INT))?
		
		// make a new net assignment
		{
			NetAssignment n = new NetAssignment(); 
			n.setName($name.text);
			n.setLine($name.line);
			n.setPos($name.pos);
			n.setMsb($msb!=null?Integer.parseInt($msb.text):-1);
			n.setLsb($lsb!=null?Integer.parseInt($lsb.text):-1);
			n.setIndex($index!=null?Integer.parseInt($index.text):-1);
			n.setFileName(input.getSourceName());
		}
		
		concatenateNet[n]*
		)
		{	if(!d.addNetAssignment(n)) 
				addError(n, "duplicate net assignment");
		}
	;
	
concatenateNet[NetAssignment na]
	:	(name=IDENT ((msb=INT lsb=INT) | (index=INT))?)
		{
			Net n = new Net();
			n.setName($name.text);
			n.setLine($name.line);
			n.setPos($name.pos);
			n.setMsb($msb!=null?Integer.parseInt($msb.text):-1);
			n.setLsb($lsb!=null?Integer.parseInt($lsb.text):-1);
			n.setIndex($index!=null?Integer.parseInt($index.text):-1);
			n.setFileName(input.getSourceName());
			na.addNet(n);
		}
	;
	
portAssignment[SubDesignDeclaration s]
	:	^(EQUALS name=IDENT 
		((instMsb=INT instLsb=INT) | (instIndex=INT))?
		(COLON ((msb=INT lsb=INT) | (index=INT)))?
	
		// make a new port assignment
		{
			PortAssignment p = new PortAssignment(); 
			p.setName($name.text);
			p.setLine($name.line);
			p.setPos($name.pos);
			p.setInstMsb($instMsb!=null?Integer.parseInt($instMsb.text):-1);
			p.setInstLsb($instLsb!=null?Integer.parseInt($instLsb.text):-1);
			p.setInstIndex($instIndex!=null?Integer.parseInt($instIndex.text):-1);
			p.setMsb($msb!=null?Integer.parseInt($msb.text):-1);
			p.setLsb($lsb!=null?Integer.parseInt($lsb.text):-1);
			p.setIndex($index!=null?Integer.parseInt($index.text):-1);
			p.setFileName(input.getSourceName());
		}
	
		concatenatePort[p]*
		)
		{	if(!s.addPortAssignment(p)) 
				addError(p, "duplicate port assignment");
		}
	;

concatenatePort[PortAssignment pa]
	:	(name=IDENT ((msb=INT lsb=INT) | (index=INT))?)
		{
			Net n = new Net();
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
