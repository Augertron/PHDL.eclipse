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
 * A tree grammar that walks the AST produced by PhdlParser.  It operates on a stream of 
 * tree nodes of the form (parent child1 child2 ... childN) where each node may be the
 * root of another subtree.  Call the sourceText()rule on the walker object to generate
 * a set of design nodes.  Retrieve the design nodes and any compilation errors and warnings 
 * by calling getDesignNodes(), getErrors() and getWarnings() respectively.  Optionally,
 * before calling the sourceText() rule, pass in a set of required attributes with the 
 * setRequiredAttributes(String[]) method.
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
	package phdl.grammar;
	import phdl.PhdlComp;
	import java.util.TreeSet;
	import java.util.Set;
	import java.util.HashSet;
	import java.util.SortedSet;
	import java.util.List;
	import java.util.ArrayList;
	import phdl.graph.*;
}

@members {

	/**
	 * The set of required attributes
	 */
	private Set<String> reqAttrs = new HashSet<String>();
	/**
	 * The sorted set of errors
	 */
	private SortedSet<String> errors = new TreeSet<String>();
	/**
	 * The set of processed design nodes
	 */
	private Set<DesignNode> designNodes = new HashSet<DesignNode>();
	
	/**
	 * Sets to check for duplicates whild processing everything
	 */
	private Set<String> attrDecls = new HashSet<String>();
	private Set<String> pinDecls = new HashSet<String>();
	private Set<String> netDecls = new HashSet<String>();
	private Set<String> instanceDecls = new HashSet<String>();
	private Set<String> attrAssigns = new HashSet<String>();
	private Set<String> pinAssigns = new HashSet<String>();
	
	/**
	 * Called to obtain the errors if any exist after walking and processing the tree
	 */
	public SortedSet<String> getErrors() {
		return errors;
	}
	
	/**
	 * Used from within the walker to add an error found while processing the tree
	 */
	private void addError(Node n, String message) {
		errors.add(n.getFileName() + " line " + n.getLine() + ":" 
				+ n.getPosition() + " " + message + ": " + n.getName());
	}
	
	/**
	 * Called to obtain the set of design nodes after the walker has finished processing the tree
	 */
	public Set<DesignNode> getDesignNodes() {
		return designNodes;
	}
	
	/**
	 * Called on the walker object to pass in a set of required attributes
	 */
	public void setRequiredAttributes(String[] attributes) {
		for(int i = 0; i < attributes.length; i ++) {
			reqAttrs.add(attributes[i]);
		}
	}
	
	/**
	 * Necessary to properly report AST errors without bailing out of the whole application
	 */
	@Override
    public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
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
 * The sourceText rule looks for zero or more design units in the AST.  When there is only one design unit
 * to be analyzed, the design rule below may be directly called on the AST.  After calling this rule on the 
 * PhdlWalker object, call the getDesignNodes() method to retrieve a set of design nodes that the sourceText
 * rule has produced.
 */
sourceText
	:	designDecl*
	;

/**
 * The designDecl rule may be called on the PhdlWalker AST object as long as there is only one design unit
 * contained inside.  After calling this rule, call the getDesignNodes() method to retrieve a set of design
 * nodes that the walker has produced.  (Only one design node will exist in the set if calling this rule
 * instead of the sourceText rule.)
 *
 * This rule performs the following functions:
 * 1. Make a new design node based on the identifier and log its location.
 * 2. Clear the appropriate sets which are used to check for duplicate objects within a design.
 * 3. Using the deviceDecl, netDecl and instDecl rules, process and add all objects to the design.
 * 4. Report any errors from duplicate design declarations.
 */
designDecl
	:	^('design' name=IDENT
		
			//==================== JAVA BEGIN =======================
			{	// make a new design based on the identifier and log its location
				DesignNode des = new DesignNode();
				des.setName($name.text);
				des.setLocation($name.line, $name.pos, input.getSourceName());
				
				// clear these sets each time a design is processed
				netDecls.clear();
				instanceDecls.clear();
			}
			//===================== JAVA END ========================
		
		(deviceDecl[des] | netDecl[des])* 'begin' (instDecl[des])*)
		
			//==================== JAVA BEGIN =======================
			{	// add the design node and report if there are duplicates
				if(!designNodes.add(des))
					addError(des, "duplicate design unit");
			}
			//===================== JAVA END ========================
	;

/**
 * The deviceDecl rule is called by the design rule.  It makes new device nodes for every device declaration
 * found in the design declaration.
 *
 * This rule performs the following functions:
 * 1. Make a new device node with the given name and log its location.
 * 2. Clear the appropriate sets which are used to check for duplicate declared attributes and pins.
 * 3. Using the attibuteDecl and pinDecl rules, process and add all declared attributes and pins to the device.
 * 4. Report any missing attributes present in the required attributes set
 * 5. Report any errors from duplicate device declarations
 */	
deviceDecl[DesignNode des]
	:	^('device' name=IDENT
				
			//==================== JAVA BEGIN =======================
			{	// make a new device based on the identifier and log its location
				DeviceNode dev = new DeviceNode(des);
				dev.setName($name.text);
				dev.setLocation($name.line, $name.pos, input.getSourceName());
				
				// clear these sets each time a device is processed
				attrDecls.clear();
				pinDecls.clear();
			}
			//===================== JAVA END ========================
			
		(attributeDecl[dev] | pinDecl[dev])*)
		
			//==================== JAVA BEGIN =======================
			{	// report any missing required attributes
				for(String s : reqAttrs) {
					s = s.toUpperCase();
					if(dev.getAttribute(s)==null)
						errors.add(input.getSourceName() + " line " + $name.line + ":" 
							+ $name.pos + " required attribute \"" + s + "\" missing in device: " + $name.text);
				}
				
				// attempt to add the device declaration and report duplicates
				if(!des.addDevice(dev))
					addError(dev, "Duplicate device declaration");
			}
			//===================== JAVA END ========================
	;

/**
 * The attributeDecl rule is called by the deviceDecl rule and works with an attributable object, which in this
 * case is the device node.  It makes new attribute nodes for every attribute declaration it finds in the device
 * declaration.  All attribute names and values are interpreted and processed as uppercase strings.
 *
 * This rule performs the following functions:
 * 1. Make a new attribute node with the device as its parent, and log its location.
 * 2. Set its value, and add the node to the device.
 * 3. Report any errors with duplicates
 */
attributeDecl[Attributable dev]
	:	^('attr' name=IDENT value=STRING_LITERAL)
	
			//==================== JAVA BEGIN =======================
	    	{	// make a new attribute node, assign its parent, and log its location
	    		AttributeNode a  = new AttributeNode(dev);
	    		a.setName($name.text);
				a.setValue($value.text);
	    		a.setLocation($name.line, $name.pos, input.getSourceName());
				dev.addAttribute(a);
				
				// report any duplicate attribute declarations
				if(!attrDecls.add($name.text.toUpperCase()))
					addError(a, "duplicate attribute declaration");
			}
			//===================== JAVA END ========================
    ;

/**
 * The pinDecl rule is called by the deviceDecl rule and works with a device node.  It makes new pin nodes
 * based on the size of the slice list as specified in the source.  Slices allow the phdl user to abstract
 * away the arbitrary pin numbers into a vector.  The number of slices must correspond with the number of 
 * pins, and they are always associated left to right.  A slice list declared as [3:0] with a pin
 * list declared as {1,2,3,4} in the following pin declaration:
 *
 * pin a[3:0] = {1,2,3,4};
 *  
 * would map a[3] to pin 1, a[2] to pin 2, a[1] to pin 3 and a[0] to pin 4.  If the slice list is omitted,
 * the pin is assumed to be one bit wide, and consequently the pin list must contain only one pin to associate.
 *
 * This rule performs the following functions:
 * 1. Compare the slice list and pin list sizes, accounting for the possibly of no slice list.
 * 2. Make pin nodes appending the slice bit if applicable, with the device as the parent, and log its location.
 * 3. Report all errors from duplicates and invalid pin lists.
 */
pinDecl[DeviceNode dev]
	:	^('pin' 
	
			//==================== JAVA BEGIN =======================
			{ 	// sets to keep track of the slice and pin lists
				List<Integer> sList = new ArrayList<Integer>(); 
				List<String> pList = new ArrayList<String>();
			}
			//===================== JAVA END ========================
		
		name=IDENT sliceList[sList]? pinList[pList])
		
			//==================== JAVA BEGIN =======================
			{	// list sizes should only differ if there is no slice list, and the pin list has a size of 1
				if (sList.size() != pList.size()) {
					if (sList.size() == 0 && pList.size() != 1)
						errors.add(input.getSourceName() + " line " + $name.line + ":" 
							+ $name.pos + " invalid pin list: " + $name.text);				
					if (sList.size() != 0)
						errors.add(input.getSourceName() + " line " + $name.line + ":" 
							+ $name.pos + " invalid pin list: " + $name.text);
				}
				
				// make new pin nodes for all slices by appending the slice reference in brackets to the name
	        	for (int i = 0; i < sList.size(); i++) {
	        		PinNode newPin = new PinNode(dev);
	        		newPin.setName($name.text + "[" + sList.get(i) + "]");
					newPin.setLocation($name.line, $name.pos, input.getSourceName());
	        		
	        		// accessing an invalid pin list may cause an exception
	        		try{
						newPin.setPinName(pList.get(i));
					} catch (IndexOutOfBoundsException e) {
						errors.add(input.getSourceName() + " line " + $name.line + ":" 
							+ $name.pos + " invalid pin list: " + $name.text);
					}
					
					// report any duplicate pin declarations
					if (!dev.addPin(newPin))
	            		addError(newPin, "duplicate pin declaration");
				}
				
				// otherwise make a new pin node directly from the name
				if (sList.isEmpty()) {
					PinNode newPin = new PinNode(dev);
					newPin.setName($name.text);
					newPin.setLocation($name.line, $name.pos, input.getSourceName());
					
					// accessing an invalid pin list may cause an exception
					try{
						newPin.setPinName(pList.get(0));
					} catch (IndexOutOfBoundsException e) {
						errors.add(input.getSourceName() + " line " + $name.line + ":" 
							+ $name.pos + " invalid pin list: " + $name.text);
					}
					
					// report any duplicate pin declarations
					if (!dev.addPin(newPin))
	            		addError(newPin, "duplicate pin declaration");
				}
				
				// check for overall duplicates based solely on the name
				if (!pinDecls.add($name.text))
					errors.add(input.getSourceName() + " line " + $name.line + ":" 
							+ $name.pos + " duplicate pin declaration: " + $name.text);
			}
			//===================== JAVA END ========================
	;

/**
 * The netDecl rule is called by designDecl and uses a design node to add net nodes to it.  
 */	
netDecl[DesignNode des]
	:	^('net'
	
			//==================== JAVA BEGIN =======================
			{	// housekeeping
				List<Integer> slices = new ArrayList<Integer>();
				NetNode n = new NetNode(null);
				attrDecls.clear();
			}
			//===================== JAVA END ========================
			
		sliceList[slices]? name=IDENT attributeDecl[n]* )
		
			//==================== JAVA BEGIN =======================
			{	// make net nodes based on the slice list
				for (int i = 0; i < slices.size(); i++) {
					NetNode newNode = new NetNode(des);
					newNode.setName($name.text + "[" + slices.get(i) + "]");
					newNode.setLocation($name.line, $name.pos, input.getSourceName());
					for (AttributeNode a : n.getAttributes()) {
						AttributeNode newA = new AttributeNode(newNode);
						newA.setName(a.getName());
						newA.setLocation(a.getLine(), a.getPosition(), a.getFileName());
						newA.setValue(a.getValue());
						newNode.addAttribute(newA);
					}
					
					// check for duplicate net declarations
					if(!des.addNet(newNode)) {
						addError(newNode, "duplicate net declaration");
					}
				}
				
				// otherwise, make a net node based solely on the name	
				if (slices.isEmpty()) {
					NetNode newNode = new NetNode(des);
					newNode.setName($name.text);
					newNode.setLocation($name.line, $name.pos, input.getSourceName());
					for (AttributeNode a : n.getAttributes()) {
							AttributeNode newA = new AttributeNode(newNode);
							newA.setName(a.getName());
							newA.setValue(a.getValue());
							newA.setLocation(a.getLine(), a.getPosition(), a.getFileName());
							newNode.addAttribute(newA);
					}
					
					// check for duplicate net declarations
					if(!des.addNet(newNode)) {
						addError(newNode, "duplicate net declaration");
					}
				}
				
				// check for overall duplicates based solely on the name
				if (!netDecls.add($name.text))
					errors.add(input.getSourceName() + " line " + $name.line + ":" 
						+ $name.pos + " duplicate net declaration: " + $name.text);
			}
			//===================== JAVA END ========================
	;
	
instDecl[DesignNode des]
	:	{	// sets of all the instance nodes and indices list which they cover
			Set<InstanceNode> instNodes = new HashSet<InstanceNode>();
			List<Integer> indices = new ArrayList<Integer>();
		}
		
		// the instance declaration subtree structure
		^('inst' instName=IDENT devName=IDENT arrayList[indices]?
		
			{	// make as many instance nodes as there are indices
				for (int j = 0; j < indices.size(); j++) {
				
					InstanceNode i = new InstanceNode(des);
					i.setName($instName.text + "(" + indices.get(j) + ")");
					i.setLocation($instName.line, $instName.pos, input.getSourceName());
					
					// find the corresponding device declaration
					DeviceNode dev = des.getDevice($devName.text);
					if (dev != null) {
						i.setDevice(dev);
						// add all of the attributes and pins from the device definition
						for (AttributeNode a: dev.getAttributes())
							i.addAttribute(new AttributeNode(a, i));
						for (PinNode pn: dev.getPins())
							i.addPin(pn);
					} else
						addError(i, "instance references undeclared device");
					
					instNodes.add(i);
				}
				
				// otherwise make only one instance node based on the instName
				if (indices.isEmpty()) {
					InstanceNode i = new InstanceNode(des);
					i.setName($instName.text);
					i.setLocation($instName.line, $instName.pos, input.getSourceName());
					
					// find the corresponding device declaration
					DeviceNode dev = des.getDevice($devName.text);
					if (dev != null) {
						i.setDevice(dev);
						// add all of the attributes and pins from the device definition
						for (AttributeNode a: dev.getAttributes())
							i.addAttribute(new AttributeNode(a, i));
						for (PinNode pn: dev.getPins())
							i.addPin(pn);
					} else
						addError(i, "instance references undeclared device");
							
					instNodes.add(i);
				}
			}
		
			{	// check for duplicates
				for (InstanceNode i : instNodes) {
					if(!des.addInstance(i))
						addError(i, "duplicate instance declaration");
				}
				
				// check for overall duplicates based solely on the instName
				if (!instanceDecls.add($instName.text))
					errors.add(input.getSourceName() + " line " + $instName.line + ":" 
						+ $instName.pos + " duplicate instance declaration: " + $instName.text);
			}

		// assign attributes and pins
		(attrAssign[des, $instName.text] | pinAssign[des, $instName.text])* )
	;

attrAssign[DesignNode des, String instName]
	:	{	// flag for a new attribute and a list of indices the attribute covers
			boolean newAttr = false;
			List<Integer> indices = new ArrayList<Integer>();
		}
		
		// the attribute assignment subtree structure
		^(EQUALS ('newattr' {newAttr = true;} )? instanceQualifier[instName, indices]? name=IDENT value=STRING_LITERAL)
		
		{	// for every index
			for(int i = 0; i < indices.size(); i++) {
				InstanceNode inst = des.getInstance(instName + "(" + indices.get(i) + ")");
				if(inst!=null){
					AttributeNode a = inst.getAttribute($name.text);
					if (a!=null) {
						a.setValue($value.text);
					} else {
						if(newAttr) {
							AttributeNode newA = new AttributeNode(inst);
							newA.setName($name.text);
							newA.setValue($value.text);
							newA.setLocation($name.line, $name.pos, input.getSourceName());
							inst.addAttribute(newA);
						} else {
							errors.add(input.getSourceName() + " line " + $name.line + ":" 
								+ $name.pos + " instance references undeclared attribute: " + $name.text);
						}
					}
				} else {
					errors.add(input.getSourceName() + " line " + $name.line + ":" 
								+ $name.pos + " instance name is undeclared: " + instName + "(" + indices.get(i) + ")");
				}
			}
			// if a global attribute
			if (indices.isEmpty()) {
				for (InstanceNode inst : des.getAllInstances(instName)) {
					AttributeNode a = inst.getAttribute($name.text);
					if (a!=null) {
						a.setValue($value.text);
					} else {
						if(newAttr) {
							AttributeNode newA = new AttributeNode(inst);
							newA.setName($name.text);
							newA.setValue($value.text);
							newA.setLocation($name.line, $name.pos, input.getSourceName());
							inst.addAttribute(newA);
						} else {
							errors.add(input.getSourceName() + " line " + $name.line + ":" 
								+ $name.pos + " instance references undeclared attribute: " + instName);
						}
					}
				}
			}
		}
	;
	
pinAssign[DesignNode des, String instName]	
	:	{	List<Integer> indices = new ArrayList<Integer>();
			List<Integer> bits = new ArrayList<Integer>();
			List<String> concats = new ArrayList<String>();
	
		}
		^(EQUALS instanceQualifier[instName, indices]? name=IDENT sliceList[bits]? concatenation[concats, bits.size()])
		{	if(indices.isEmpty() && bits.isEmpty()) {
				for(InstanceNode i : des.getAllInstances(instName)) {
					List<PinNode> pins = i.getAllPins($name.text);
					for(int j = 0 ; j < pins.size(); j++) {
						pins.get(j).setNet(des.getNet(concats.get(j)));
						des.getNet(concats.get(j)).addPin(pins.get(j));
					}
				}
			}
		}
	;
	
concatenation[List<String> concats, int vectorWidth]
	:	(	{List<Integer> slices = new ArrayList<Integer>();}
			(first=IDENT sliceList[slices]?
				{	if (slices.isEmpty()) {
						concats.add($first.text);
					} else {
						for(int i = 0 ; i < slices.size(); i++) {
							concats.add($first.text + "[" + slices.get(i) + "]");
						}
					}
				}
			(next=IDENT 				{slices.clear();}
			
			sliceList[slices]?
				{	if (slices.isEmpty()) {
						concats.add($next.text);
					} else {
						for(int i = 0 ; i < slices.size(); i++) {
							concats.add($next.text + "[" + slices.get(i) + "]");
						}
					}
				}
			)* )

		|	(LANGLE global=IDENT )
				{	for(int i = 0; i < vectorWidth; i++)
						concats.add("<>" + $global.text);
				}
		|	('open')	{concats.add("open");}
		)
	;

/**
 * Instance qualifier looks for a subtree with a period as its parent.
 */
instanceQualifier[String instName, List<Integer> indices]
	:	^(PERIOD name=IDENT arrayList[indices]?)
	
	    {	// check that the instance qualifier matches
	    	if (!instName.equals($name.text)) {
	    		errors.add(input.getSourceName() + " line " + $name.line + ":" 
						+ $name.pos + " invalid instance qualifier: " + $name.text);
	    	}
	    }
	;

arrayList[List<Integer> indices]
	:	^(COMMA LPAREN
		start=INTEGER				{indices.add(Integer.parseInt($start.text));}
      	(	next=INTEGER			{indices.add(Integer.parseInt($next.text));}
      	)*
      	)
	| 	^(COLON	LPAREN start=INTEGER end=INTEGER		
			{	int begin = Integer.parseInt($start.text);
				int finish = Integer.parseInt($end.text);
			
				if (begin <= finish) {	
        			for (int i = begin; i <= finish; i++) {
          				indices.add(i);
        			}
      			}
      			else {
        			for (int i = begin; i >= finish; i--) {
           				indices.add(i);
        			}
      			}
			}
		)
	|	(LPAREN single=INTEGER 	{indices.add(Integer.parseInt($single.text));}		)
 	;

sliceList[List<Integer> slices]
	:	// comma-separated list subtree structure
		^(COMMA LBRACKET start=INTEGER  	{slices.add(Integer.parseInt($start.text));}
      	(next=INTEGER						{slices.add(Integer.parseInt($next.text));}		)*
      	)
      	
	|	// colon-separated vector subtree structure
		^(COLON LBRACKET start=INTEGER end=INTEGER		
			{	int begin = Integer.parseInt($start.text);
				int finish = Integer.parseInt($end.text);
			
				if (begin <= finish) {	
					// increment for up slice lists
        			for (int i = begin; i <= finish; i++)
          				slices.add(i);
      			} else {
      				// decrement for down slice lists
        			for (int i = begin; i >= finish; i--)
           				slices.add(i);
      			}
			}
		)

 	;

pinList[List<String> pList]
	:	// maintain a set of pins to check for duplicates in the pin list
		{Set<String> pins = new HashSet<String>();}
	
		// adds the first pin in the pin list
		first= (PIN | INTEGER | IDENT)	
			{	if(!pins.add($first.text))
					errors.add(input.getSourceName() + " line " + $first.line + ":" 
						+ $first.pos + " duplicate found in pin list");
				pList.add($first.text);
			}
		
		// adds subsequent pins in the pin list	
     	(next= (PIN | INTEGER | IDENT)		
     		{	if(!pins.add($next.text))
					errors.add(input.getSourceName() + " line " + $first.line + ":" 
						+ $first.pos + " duplicate found in pin list");
				pList.add($next.text);
			}		
     	)*
 	;