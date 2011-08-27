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

	package phdl.grammar;
	import java.util.TreeSet;
	import java.util.Set;
	import java.util.HashSet;
	import java.util.SortedSet;
	import java.util.List;
	import java.util.ArrayList;
	import java.util.regex.Pattern;
	import phdl.graph.*;
}

@members {

	/**
	 * The set of required attributes
	 */
	private Set<String> reqAttrs = new HashSet<String>();
	/**
	 * The list of errors
	 */
	private List<String> errors = new ArrayList<String>();
	/**
	 * The list of warnings
	 */
	private List<String> warnings = new ArrayList<String>();
	/**
	 * The set of processed design nodes
	 */
	private Set<DesignNode> designNodes = new HashSet<DesignNode>();
	
	/**
	 * Sets to check for duplicates while processing everything
	 */
	private Set<String> attrDecls = new HashSet<String>();
	private Set<String> pinDecls = new HashSet<String>();
	private Set<String> netDecls = new HashSet<String>();
	private Set<String> instanceDecls = new HashSet<String>();
	
	/**
	 * Called to obtain the errors if any exist after walking and processing the tree
	 */
	public List<String> getErrors() {
		return errors;
	}
	
	/**
	 * Called to obtain the warnings if any exist after walking and processing the tree
	 */
	public List<String> getWarnings() {
		return warnings;
	}
	
	/**
	 * Adds an error from a Node object
	 */
	private void addError(Node n, String message) {
		String error = n.getFileName() + " line " + n.getLine() + ":" + n.getPosition() + " "
			+ message + ": " + n.getName();
		if (!errors.contains(error))
			errors.add(error);
	}

	/**
	 * Adds an error from a CommonTree object
	 */
	private void addError(CommonTree ct, String message) {
		String error = ct.getToken().getInputStream().getSourceName() + " line " + ct.getLine()
			+ ":" + ct.getCharPositionInLine() + " " + message + ": " + ct.getText();
		if (!errors.contains(error))
			errors.add(error);
	}

	/**
	 * Reports an error from a Node object exits
	 */
	private void bailOut(Node n, String message) {
		System.out.println("ERROR: " + n.getFileName() + " line " + n.getLine() + ":"
			+ n.getPosition() + " " + message + ": " + n.getName());
		System.exit(1);
	}

	/**
	 * Reports an error from a CommonTree object and exits
	 */
	private void bailOut(CommonTree ct, String message) {
		System.out.println("ERROR: " + ct.getToken().getInputStream().getSourceName() + " line "
				+ ct.getLine() + ":" + ct.getCharPositionInLine() + " " + message + ": "
				+ ct.getText());
		System.exit(1);
	}

	/**
	 * Adds a warning from a Node object
	 */
	private void addWarning(Node n, String message) {
		String warning = n.getFileName() + " line " + n.getLine() + ":" + n.getPosition() + " "
			+ message + ": " + n.getName();
		if (!warnings.contains(warning))
			warnings.add(warning);
	}

	/**
	 * Adds a warning from a CommonTree object
	 */
	private void addWarning(CommonTree ct, String message) {
		String warning = ct.getToken().getInputStream().getSourceName() + " line " + ct.getLine()
			+ ":" + ct.getCharPositionInLine() + " " + message + ": " + ct.getText();
		if (!warnings.contains(warning))
			warnings.add(warning);
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
	 * Helper method for the pinAssignment rule.  Given a list of slices, concats, an instance node, and a pinNode
	 * it assigns all relevant pins to their respective net.
	 */
	private void assignPins(int start, List<Integer> slices, List<NetNode> concats, InstanceNode inst, CommonTree pinNode, boolean combine) {
		if (start == -1) {
			// Non-arrayed instance
			assignNonArrayed(slices, concats, inst, pinNode);
		}
		else {
			// Arrayed instance
			if (combine)
			 assignArrayedCombine(start, slices, concats, inst, pinNode);
			else
			 assignArrayedEach(slices, concats, inst, pinNode);
		}
	}
	
	/**
	 * Helper method for assignPins for arrayed instances
	 */
	private void assignArrayedCombine(int start, List<Integer> slices, List<NetNode> concats, InstanceNode inst, CommonTree pinNode) {
		String pinName = pinNode.getText();
		if (slices.isEmpty()) {	// Single-bit lval
			// Grab one net from concats
			PinNode p = inst.getPin(pinName);
			setConcatToPin(p, concats.get(start), pinNode);
		} else {	// Multi-bit lval
			for (int i = 0; i < slices.size(); i++) {
				PinNode p = inst.getPin(pinName + "[" + slices.get(i) + "]");
				setConcatToPin(p, concats.get(i + start), pinNode);
			}
		}
	}
	
	/**
   * Helper method for assignPins for arrayed instances
   */
  private void assignArrayedEach(List<Integer> slices, List<NetNode> concats, InstanceNode inst, CommonTree pinNode) {
    String pinName = pinNode.getText();
    if (slices.isEmpty()) { // Single-bit lval
      // Grab one net from concats
      PinNode p = inst.getPin(pinName);
      setConcatToPin(p, concats.get(0), pinNode);
    } else {  // Multi-bit lval
      for (int i = 0; i < slices.size(); i++) {
        PinNode p = inst.getPin(pinName + "[" + slices.get(i) + "]");
        setConcatToPin(p, concats.get(i), pinNode);
      }
    }
  }
	
	/**
	 * forms the link between a pin node and net node in the design.
	 */
	private void setConcatToPin(PinNode p, NetNode n, CommonTree pinNode) {
		if (p != null) {
			if (p.hasNet()) {
				addWarning(p, "pin " + p.getIndex() + " already assigned");
			}
			p.setNet(n);
			if (n != null) {
				n.addPin(p);
			}
		}
		else {
			addError(pinNode, "pin undelcared in device");
		}
	}
	
	/**
	 * Helper method for assignPins for non-arrayed instances
	 */
	private void assignNonArrayed(List<Integer> slices, List<NetNode> concats, InstanceNode inst, CommonTree pinNode) {
		String pinName = pinNode.getText();
		if (slices.isEmpty()) {	// Single-bit lval
			if (concats.size() == 1) {	// Single-bit rval
				setConcatToPin(inst.getPin(pinName), concats.get(0), pinNode);
			} else {	// Multi-bit rval, ERROR
				bailOut(pinNode, "invalid assignment, left size is " 
						+ slices.size() + " right size is " + concats.size());
			}
		} else {	// Multi-bit lval
			if (concats.size() == slices.size()) {	// Verify same length
				for (int i = 0; i < concats.size(); i++) {
					PinNode p = inst.getPin(pinName + "[" + slices.get(i) + "]");
					setConcatToPin(p, concats.get(i), pinNode);
				}
			} else {	// Invalid length, ERROR
				bailOut(pinNode, "invalid assignment, left size is " 
						+ slices.size() + " right size is " + concats.size());
			}
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
    
    @Override
    protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow)
    		throws RecognitionException
	{   
    	throw new MismatchedTokenException(ttype, input);
	}  
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
	:	^('design' desName=IDENT
		
			//==================== JAVA BLOCK BEGIN =======================
			{	// make a new design based on the identifier and log its location
				DesignNode des = new DesignNode();
				des.setName($desName.text);
				des.setLocation($desName.line, $desName.pos, 
					desName.getToken().getInputStream().getSourceName());
				
				// clear these sets each time a design is processed
				netDecls.clear();
				instanceDecls.clear();
			}
			//===================== JAVA BLOCK END ========================
		{String info = "";}
		(deviceDecl[des] | netDecl[des] | infoStruct {des.appendInfo($infoStruct.value);})* 'begin' 
		(instDecl[des, null] | netAssign[des] | groupStruct[des])* (endName=IDENT)? )
		
			//==================== JAVA BLOCK BEGIN =======================
			{	// check the optional trailing label on the design to see if it maches
				if (endName != null) {
					if (!$desName.text.equals($endName.text))
						addError($endName, "design name " + $desName.text + " does not match");
				}
			
				// add the design node and report if there are duplicates
				if(!designNodes.add(des))
					addError(des, "duplicate design unit");
					
				// report any unused device declarations
				for (DeviceNode dev : des.getDevices()) {
					if (!des.isDeviceInstanced(dev))
						addWarning(dev, "unused device declaration");
				}
				
				Set<String> refDesSet = new HashSet<String>();
				
				// report any dangling pins in all instances
				for (InstanceNode i : des.getInstances()) {
					for (PinNode p : i.getPins()) {
						if (!p.hasNet())
							addError(i, "dangling pin " + p.getName() + " in instance");
					}
				}
				
			}
			//===================== JAVA BLOCK END ========================
	;

infoStruct returns [String value]
	: 	^('info' string=STRING {value = $string.text;})
	;
  
groupStruct[DesignNode des]
	:	^('group' groupName=STRING (instDecl[des, $groupName.text] | netAssign[des])* (endName=STRING)? )
	
		//==================== JAVA BLOCK BEGIN =======================
		{	if (endName != null) {
				if (!$groupName.text.equals($endName.text))
					addError($endName, "group name " + $groupName.text + " does not match");
			}
		}
		//===================== JAVA BLOCK END ========================
	;

/**
 * The deviceDecl rule is called by the design rule.  It makes new device nodes for every device declaration
 * found in the design declaration.
 *
 * This rule performs the following functions:
 * 1. Make a new device node with the given name and log its location.
 * 2. Clear the appropriate sets which are used to check for duplicate attribute and pin declarations.
 * 3. Using the attibuteDecl and pinDecl rules, process and add all declared attributes and pins to the device.
 * 4. Report any missing attributes present in the required attributes set
 * 5. Report any errors from duplicate device declarations
 */	
deviceDecl[DesignNode des]
	:	^('device' devName=IDENT
				
			//==================== JAVA BLOCK BEGIN =======================
			{	// make a new device based on the identifier and log its location
				DeviceNode dev = new DeviceNode(des);
				dev.setName($devName.text);
				dev.setLocation($devName.line, $devName.pos, 
					devName.getToken().getInputStream().getSourceName());
					
				List<Attributable> devices = new ArrayList<Attributable>();
				devices.add(dev);
				
				// clear these sets each time a device is processed
				attrDecls.clear();
				pinDecls.clear();
			}
			//===================== JAVA BLOCK END ========================
			
		(attributeDecl[devices] | pinDecl[dev])* endName=IDENT?)
		
			//==================== JAVA BLOCK BEGIN =======================
			{	// check the optional trailing label on the device to see if it maches
				if (endName != null) {
					if (!$devName.text.equals($endName.text))
						addError($endName, "device name " + $devName.text + " does not match");
				}
			
				// report any missing required attributes
				for(String s : reqAttrs) {
					s = s.toUpperCase();
					if(dev.getAttribute(s)==null)
						addError($devName, "required attribute \"" + s + "\" missing in device");
				}
				
				// attempt to add the device declaration and report duplicates
				if(!des.addDevice(dev))
					addError(dev, "Duplicate device declaration");
			}
			//===================== JAVA BLOCK END ========================
	;

/**
 * The attributeDecl rule is called by the deviceDecl and netDecl rule and works with an attributable object, 
 * which in this case is the device node.  It makes new attribute nodes for every attribute declaration it 
 * finds in the device declaration.  All attribute names and values are interpreted and processed as 
 * uppercase strings.
 *
 * This rule performs the following functions:
 * 1. Make a new attribute node with the device as its parent, and log its location.
 * 2. Set its value, and add the node to the device.
 * 3. Report any errors with duplicates
 */
attributeDecl[List<Attributable> parents]
	:	^('attr' attrName=IDENT attrValue=STRING)
	
			//==================== JAVA BLOCK BEGIN =======================
	    	{	for (Attributable parent : parents) {
		    		// make a new attribute node, assign its parent, and log its location
		    		AttributeNode a  = new AttributeNode(parent);
		    		a.setName($attrName.text);
					a.setValue($attrValue.text);
		    		a.setLocation($attrName.line, $attrName.pos, 
		    			attrName.getToken().getInputStream().getSourceName());
					parent.addAttribute(a);
				}
				// report any duplicate attribute declarations
				if (!attrDecls.add($attrName.text.toUpperCase()))
					addError($attrName, "duplicate attribute declaration");
						
				// check if the attribute is a refprefix attribute
				if ($attrName.text.equals("REFPREFIX")) {
					// check to see if refPrefix begins with a letter
					if (!Pattern.compile("^[A-Z]").matcher($attrValue.text).find())
						addError($attrName, "invalid refPrefix in device");
				}
			}
			//===================== JAVA BLOCK END ========================
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
 * 2. Make pin nodes appending the slice bit if applicable, with the device as the parent, and log their location.
 * 3. Report all errors from duplicates and invalid pin lists.
 */
pinDecl[DeviceNode dev]
	:	^('pin'
	
			//==================== JAVA BLOCK BEGIN =======================
			{ 	// sets to keep track of the slice and pin lists
				List<Integer> sList = new ArrayList<Integer>(); 
				List<String> pList = new ArrayList<String>();
			}
			//===================== JAVA BLOCK END ========================
		
		sliceList[sList]? pinName=IDENT pinList[pList])
		
			//==================== JAVA BLOCK BEGIN =======================
			{	// list sizes should only differ if there is no slice list, and the pin list has a size of 1
				if (sList.size() != pList.size()) {
					if (sList.size() == 0 && pList.size() != 1)
						addError($pinName, "invalid pin list");
					if (sList.size() != 0)
						addError($pinName, "invalid pin list");
				}
				
				// make new pin nodes for all slices by appending the slice reference in brackets to the name
	        	for (int i = 0; i < sList.size(); i++) {
	        		PinNode newPin = new PinNode(dev);
	        		newPin.setName($pinName.text + "[" + sList.get(i) + "]");
					newPin.setLocation($pinName.line, $pinName.pos, 
						pinName.getToken().getInputStream().getSourceName());
	        		
	        		// accessing an invalid pin list may cause an exception
	        		try{
						newPin.setPinName(pList.get(i));
					} catch (IndexOutOfBoundsException e) {
						addError($pinName, "invalid pin list");
					}
					
					// report any duplicate pin declarations
					if (!dev.addPin(newPin))
	            		addError(newPin, "duplicate pin declaration");
				}
				
				// otherwise make a new pin node directly from the name
				if (sList.isEmpty()) {
					PinNode newPin = new PinNode(dev);
					newPin.setName($pinName.text);
					newPin.setLocation($pinName.line, $pinName.pos, 
						pinName.getToken().getInputStream().getSourceName());
					
					// accessing an invalid pin list may cause an exception
					try{
						newPin.setPinName(pList.get(0));
					} catch (IndexOutOfBoundsException e) {
						addError($pinName, "invalid pin list");
					}
					
					// report any duplicate pin declarations
					if (!dev.addPin(newPin))
	            		addError(newPin, "duplicate pin declaration");
				}
				
				// check for overall duplicates based solely on the name
				if (!pinDecls.add($pinName.text))
					addError($pinName, "duplicate pin declaration");
			}
			//===================== JAVA BLOCK END ========================
	;

 /**
 * The netDecl rule is called by designDecl and works with a design node.  It makes new net nodes
 * based on the size of the slice list as specified in the source.  
 *
 * This rule performs the following functions:
 * 1. Make net nodes appending the slice bit if applicable, with the design as the parent, and log their location.
 * 2. Report all errors from duplicates.
 */
netDecl[DesignNode des]
	:	^('net'
	
			//==================== JAVA BLOCK BEGIN =======================
			{	List<Integer> slices = new ArrayList<Integer>();
				List<Attributable> netNodes = new ArrayList<Attributable>();
				attrDecls.clear();
			}
			//===================== JAVA BLOCK END ========================
			
		sliceList[slices]? 
		
		firstName=IDENT 			
			
			//==================== JAVA BLOCK BEGIN =======================
			{	for (int i = 0; i < slices.size(); i++) {
					NetNode newNet = new NetNode(des);
					newNet.setName($firstName.text + "[" + slices.get(i) + "]");
					newNet.setLocation($firstName.line, $firstName.pos, 
						firstName.getToken().getInputStream().getSourceName());
					netNodes.add(newNet);
				}
				
				if (slices.isEmpty()) {
					NetNode newNet = new NetNode(des);
					newNet.setName($firstName.text);
					newNet.setLocation($firstName.line, $firstName.pos, 
						firstName.getToken().getInputStream().getSourceName());
					netNodes.add(newNet);
				}
			
			}
			//===================== JAVA BLOCK END ========================
			
		(COMMA nextName=IDENT		
		
			//==================== JAVA BLOCK BEGIN =======================
			{	for (int i = 0; i < slices.size(); i++) {
					NetNode newNet = new NetNode(des);
					newNet.setName($nextName.text + "[" + slices.get(i) + "]");
					newNet.setLocation($nextName.line, $nextName.pos, 
						nextName.getToken().getInputStream().getSourceName());
					netNodes.add(newNet);
				}
				
				if (slices.isEmpty()) {
					NetNode newNet = new NetNode(des);
					newNet.setName($nextName.text);
					newNet.setLocation($nextName.line, $nextName.pos, 
						nextName.getToken().getInputStream().getSourceName());
					netNodes.add(newNet);
				}
			
			}
			//===================== JAVA BLOCK END ========================
		)*
		
		attributeDecl[netNodes]* endName=IDENT?)
		
			//==================== JAVA BLOCK BEGIN =======================
			{	for (Attributable n : netNodes) {
			
					// check for duplicate net declarations
					if(!des.addNet((NetNode) n))
						addError(n, "duplicate net declaration");
					
					// check for overall duplicates based solely on the name of the net
					if (!netDecls.add(n.getName()))
						addError(n, "duplicate net declaration");
				}
			}
			//===================== JAVA BLOCK END ========================
	;

 /**
 * The instDecl rule is called by designDecl and works with a design node.  It makes new instance nodes
 * based on the size of the array list as specified in the source.  
 *
 * This rule performs the following functions:
 * 1. Make instance nodes with the design as their parent, and log their location.
 * 2. Add all attribute nodes to each instance which are defined in the corresponding device declaration.
 * 3. Add all pin nodes to each instance which are defined in the corresponding device declaration
 * 3. Report all errors from duplicates.
 */
instDecl[DesignNode des, String groupName]
	:	^('inst'
	
			//==================== JAVA BLOCK BEGIN =======================
			{	// Set of instance nodes to check for duplicates
				List<InstanceNode> instNodes = new ArrayList<InstanceNode>();
				// List of indices to be derived from the arrayList
				List<Integer> indices = new ArrayList<Integer>();
			}
			//===================== JAVA BLOCK END ========================
		
		arrayList[indices]? instName=IDENT devName=IDENT
		
			//==================== JAVA BLOCK BEGIN =======================
			{	// make as many instance nodes as there are indices
				for (int j = 0; j < indices.size(); j++) {
				
					InstanceNode i = new InstanceNode(des);
					i.setName($instName.text + "(" + indices.get(j) + ")");
					i.setLocation($instName.line, $instName.pos, 
						instName.getToken().getInputStream().getSourceName());
					i.setGroupName(groupName);
					
					// find the corresponding device declaration
					DeviceNode dev = des.getDevice($devName.text);
					if (dev != null) {
						i.setDevice(dev);
						// copy all of the attribute and pin nodes from the device definition
						for (AttributeNode a: dev.getAttributes()) {
							i.addAttribute(new AttributeNode(a, i));
						}
						for (PinNode pn: dev.getPins())
							i.addPin(new PinNode(pn, i));
						instNodes.add(i);
					} else
						bailOut(i, "instance references undeclared device");
					
				}
				
				// otherwise make only one instance node based on the instName
				if (indices.isEmpty()) {
					InstanceNode i = new InstanceNode(des);
					i.setName($instName.text);
					i.setLocation($instName.line, $instName.pos, 
						instName.getToken().getInputStream().getSourceName());
					i.setGroupName(groupName);
					
					// find the corresponding device declaration
					DeviceNode dev = des.getDevice($devName.text);
					if (dev != null) {
						i.setDevice(dev);
						// add all of the attribute and pin nodes from the device definition
						for (AttributeNode a: dev.getAttributes())
							i.addAttribute(new AttributeNode(a, i));
						for (PinNode pn: dev.getPins())
							i.addPin(new PinNode(pn, i));
						instNodes.add(i);
					} else
						bailOut(i, "instance references undeclared device");
							
				}
			
				// check for duplicates
				for (InstanceNode i : instNodes) {
					if(!des.addInstance(i))
						addError(i, "duplicate instance declaration");
				}
				
				// check for overall duplicates based solely on the instName
				if (!instanceDecls.add($instName.text))
					addError($instName, "duplicate instance declaration");
			}
			//===================== JAVA BLOCK END ========================
		{String info = "";}
		(attrAssign[des, $instName.text] | pinAssign[des, $instName.text] | infoStruct {info += $infoStruct.value + "\n";})* endName=IDENT?)
		
			//==================== JAVA BLOCK BEGIN =======================
			{	// check the optional trailing label on the design to see if it maches
				if (endName != null) {
					if (!$instName.text.equals($endName.text))
						addError($endName, "inst name " + $instName.text + " does not match");
				}
				
				// obtain the device which the instance references
				DeviceNode dev = des.getDevice($devName.text);
				String refPrefix = null;
				if (dev != null) {
					// obtain the reference prefix defined in the device
					for (AttributeNode a : dev.getAttributes()) {
						if (a.getName().equals("REFPREFIX"))
							refPrefix = a.getValue();
					}
				}
				
				// assign the reference prefix and designator if it exists
				for (InstanceNode i : des.getAllInstances($instName.text)) {
					i.appendInfo(info);
					for (AttributeNode a : i.getAttributes()) {
						if (a.getName().equals("REFPREFIX"))
							i.setRefPrefix(a.getValue());
						if (a.getName().equals("PKG_TYPE"))
							i.setFootprint(a.getValue());
						if (a.getName().equals("REFDES"))
							i.setRefDes(a.getValue());
					}
				}
			}
			//===================== JAVA BLOCK END ========================
	;
	
/**
 * The attrAssign rule is called by instDecl and works with a design node and instance name.  
 * If new attributes have been defined and assigned (by the keyword "newattr"), create new
 * attribute nodes and assign them to the instances they cover as defined by the indices in their 
 * qualifying array (if it exists).  If a qualifying array does not exist, create as many attribute
 * nodes as the number of indexed instances in which the attribute assignment resides across all
 * possible instances (globally). 
 *
 * If attributes are not new, overwrite the old values with the new value for all indices in their
 * qualifying array, or across all instances if no qualifying array is defined (globally).
 *
 * This rule performs the following functions:
 * 1. Make new attribute nodes and assign them to the instance (by index, or globally)
 * 2. Overwrite existing attributes if they are not declared with "newattr" (by index, or globally)
 * 3. Report all errors from duplicates, and warnings for overwriting when it already exists
 */
attrAssign[DesignNode des, String instName]
	:	^(EQUALS 
	
			//==================== JAVA BLOCK BEGIN =======================
			{	// flag for a new attribute and a list of indices the attribute assignment applies to
				boolean newAttr = false;
				List<Integer> indices = new ArrayList<Integer>();
			}
			//===================== JAVA BLOCK END ========================
		
		('newattr' {newAttr = true;} )?
		(attributeQualifier[instName, indices, des] | arrayIndices[instName, indices, des])
		attrName=IDENT attrValue=STRING)
		
			//==================== JAVA BLOCK BEGIN =======================
			{	// for every index in the instance qualifier array list
				for(int i = 0; i < indices.size(); i++) {
					// find the instance node in the design with the right index
					InstanceNode inst = des.getInstance(instName + "(" + indices.get(i) + ")");
					if(inst!=null){
						// find its attribute by the attribute name
						AttributeNode a = inst.getAttribute($attrName.text);
						if (a!=null) {
							// check if the attribute is a refprefix attribute
							if (a.getName().equals("REFPREFIX")) {
								// check to see if refPrefix begins with a letter
								if (!Pattern.compile("^[A-Z]").matcher($attrValue.text).find())
									bailOut($attrValue, "invalid refPrefix value");
							}
							if (newAttr)
								addWarning($attrName, "new attribute already declared in device");
							// overwrite the attribute value
							if (!a.overwrite($attrValue.text))
								addWarning($attrName, "atribute already overwritten");
						} else {
							if (newAttr) {
								// make a new attribute if explicitly asked to do so
								AttributeNode newA = new AttributeNode(inst);
								newA.setName($attrName.text);
								newA.setValue($attrValue.text);
								newA.setLocation($attrName.line, $attrName.pos, 
									attrName.getToken().getInputStream().getSourceName());
								inst.addAttribute(newA);
							} else {
								// report that the attribute is undeclared
								addError($attrName, "attribute undeclared in device");
							}
						}
					} else {
						// the instance node does not exist
						addError($attrName, instName + "(" + indices.get(i) + ")" + 
							" attribute undeclared");
					}
				}
				// if the instance is not arrayed
				if (indices.isEmpty()) {
					// for every instance node with this instance name
					for (InstanceNode inst : des.getAllInstances(instName)) {
						// find its attribute by the attribute name
						AttributeNode a = inst.getAttribute($attrName.text);
						if (a!=null) {
							// check if the attribute is a refprefix attribute
							if (a.getName().equals("REFPREFIX")) {
								// check to see if refPrefix begins with a letter
								if (!Pattern.compile("^[A-Z]").matcher($attrValue.text).find())
									bailOut($attrValue, "invalid refPrefix value");
							}
							if (newAttr)
								addWarning($attrName, "new attribute already declared in device");
							// overwrite the attribute value
							if(!a.overwrite($attrValue.text))
								addWarning($attrName, "atribute already overwritten");
						} else {							
							// the attribute doesn't exist
							if (newAttr) {
								// make a new attribute if explicitly asked to do so
								AttributeNode newA = new AttributeNode(inst);
								newA.setName($attrName.text);
								newA.setValue($attrValue.text);
								newA.setLocation($attrName.line, $attrName.pos, 
									attrName.getToken().getInputStream().getSourceName());
								inst.addAttribute(newA);
							} else {
								// report that the attribute is undeclared
								addError($attrName, instName + " attribute undeclared");
							}
						}
					}
				}
			}
			//===================== JAVA BLOCK END ========================
	;

pinAssign[DesignNode des, String instName]	
	:	^(EQUALS 
	
			//==================== JAVA BLOCK BEGIN =======================
			{	List<Integer> indices = new ArrayList<Integer>();
				List<Integer> slices = new ArrayList<Integer>();
				List<NetNode> concats = new ArrayList<NetNode>();
			}
			//===================== JAVA BLOCK END ========================
			
      {boolean combine = false;}
		  (pinQualifier[instName, indices, des] {combine = $pinQualifier.combine;} | arrayIndices[instName, indices, des]) 
		  pinName=IDENT (sliceList[slices] | pinSlices[slices, $pinName.text, des, instName])
		
			{	int assignWidth = 0;
				if (slices.size() == 0 && indices.size() != 0) {assignWidth = indices.size();}
				if (slices.size() != 0 && indices.size() == 0) {assignWidth = slices.size();}
				if (slices.size() != 0 && indices.size() != 0 && combine) {assignWidth = indices.size() * slices.size();}
				if (slices.size() != 0 && indices.size() != 0 && !combine) {assignWidth = slices.size();}
			} 
		
		concatenation[concats, assignWidth, des])
		
			//==================== JAVA BLOCK BEGIN =======================
			{	  
				if (indices.size() != 0 && slices.size() != 0) {
					if (indices.size() * slices.size() != concats.size() && combine) {
						// Arrayed and Sliced
						bailOut($pinName, "Invalid assignment width, left = " + indices.size() * slices.size() + ", right = " + concats.size());
					}
					else if (slices.size() != concats.size() && !combine) {
						bailOut($pinName, "Invalid assignment width, left = " + slices.size() + ", right = " + concats.size());
					}
				}
				else if (slices.size() != 0) {
					if (slices.size() != concats.size()) {
						// Not Arrayed and Sliced
						bailOut($pinName, "Invalid assignment width, left = " + slices.size() + ", right = " + concats.size());
					}
				}
				else if (indices.size() != 0) {
					// Arrayed and Not Sliced
					if (concats.size() != 1 && !combine) {
						bailOut($pinName, "Invalid assignment width, left = " + 1 + ", right = " + concats.size());
					}
					else if (combine && concats.size() != indices.size()) {
						bailOut($pinName, "Invalid assignment width, left = " + indices.size() + ", right = " + concats.size());
					}
				}
			
				// for all the indices in the array list
				for (int j = 0; j < indices.size(); j++) {
					// for all isntances with this pinName
					for (InstanceNode inst : des.getAllInstances(instName)) {
						// assign pins for only those whose index is in the list of indices
						if(inst.getIndex() == indices.get(j)) {
							int start;
							if (slices.size() == 0) {
								start = j;
							} else {
								start = j * slices.size();
							}
							assignPins(start, slices, concats, inst, $pinName, combine);
						}
					}
				}
				if (indices.isEmpty()) {
					InstanceNode inst = des.getInstance(instName);
					assignPins(-1,slices, concats, inst, $pinName, combine);
				}
				
			}
			//===================== JAVA BLOCK END ========================
	;
	
netAssign[DesignNode des]
	:	^(EQUALS
	
			//==================== JAVA BLOCK BEGIN =======================
			{	List<Integer> slices = new ArrayList<Integer>();
				List<NetNode> concats = new ArrayList<NetNode>();
			}
			//===================== JAVA BLOCK END ========================
		
		netName=IDENT (sliceList[slices] | netSlices[slices, $netName.text, des])
		concatenation[concats, slices.size(), des])
		
			//==================== JAVA BLOCK BEGIN =======================
			{	if (concats.contains(des.getNet("open"))) {
					bailOut($netName, "cannot assign open to a net");
				}
				if (slices.isEmpty()) {
					if (concats.size() == 1) {
						NetNode n = des.getNet($netName.text);
						if (n != null) {
							n.addNet(concats.get(0));
							concats.get(0).addNet(n);
						} else {
							addError($netName, "net undeclared in design");
						}
					} else {
						bailOut($netName, "invalid assignment, left width is " 
								+ slices.size() + " right width is " + concats.size());
					}
				} else {
					if (concats.size() == slices.size()) {
						for (int i = 0; i < concats.size(); i++) {
							NetNode n = des.getNet($netName.text + "[" + slices.get(i) + "]");
							if (n != null) { 
								n.addNet(concats.get(i));
								concats.get(i).addNet(n);
							} else {
								addError($netName, "net undeclared in design");
							}
						}
					} else {
						bailOut($netName, "invalid assignment, left width is " 
								+ slices.size() + " right width is " + concats.size());
					}
				}
			}
			//===================== JAVA BLOCK END ========================
		
	;
	
/**
 * 
 */
concatenation[List<NetNode> concats, int assignWidth, DesignNode des]
	:		// a blank list of slices to populate with the sliceList rule
			{List<Integer> slices = new ArrayList<Integer>();}	
	
		((first=IDENT (sliceList[slices] | concatSlices[slices, $first.text, des])
			
			//==================== JAVA BLOCK BEGIN =======================
			{	if(slices.size()==0) {
					NetNode n = des.getNet($first.text);
					if (n != null) {
						concats.add(n);
					} else {
						bailOut($first, "undeclared net");
					}
				}
			
				for (int i = 0; i < slices.size(); i++) {
					List<NetNode> nets = des.getAllNets($first.text);
					if (!nets.isEmpty()) {
						for (NetNode n : nets) {
							if (n.getIndex() == slices.get(i))
								concats.add(n);
						}
					} else {
						bailOut($first, "undeclared net");
					}
				}
			}
			//===================== JAVA BLOCK END ========================
				
		(next=IDENT 				
			
			{slices.clear();} // slices needs to be cleared before processing additional nets
			
		(sliceList[slices] | concatSlices[slices, $next.text, des])
		
			//==================== JAVA BLOCK BEGIN =======================
			{	if(slices.size()==0) {
					NetNode n = des.getNet($next.text);
					if (n != null) {
						concats.add(n);
					} else {
						bailOut($next, "undeclared net");
					}
				}
				
				for (int i = 0; i < slices.size(); i++) {
					List<NetNode> nets = des.getAllNets($next.text);
					if (!nets.isEmpty()) {
						for (NetNode n : des.getAllNets($next.text)) {
							if (n.getIndex() == slices.get(i))
								concats.add(n);
						}
					} else {
						bailOut($next, "undeclared net");
					}
				}
			}
			//===================== JAVA BLOCK END ========================
			
		)* ) | (LEFTANGLE global=IDENT (sliceList[slices] | concatSlices[slices, $global.text, des]) )
		
			//==================== JAVA BLOCK BEGIN =======================
			{	if (assignWidth==0) assignWidth++;
				if (slices.size()==1) {
					NetNode n = des.getNet($global.text + "[" + slices.get(0) + "]");
					if (n != null) {
						for (int i = 0; i < assignWidth; i++)
							concats.add(n);
					} else {
						bailOut($global, "undeclared net");
					}
				} else if(slices.isEmpty()) {
					NetNode n = des.getNet($global.text);
					if (n != null) {
						for (int i = 0; i < assignWidth; i++)
							concats.add(n);
					} else {
						bailOut($global, "undeclared net");
					}
				} else {
					bailOut($global, "assignment cannot replicate a net vector");
				}
			}
			//===================== JAVA BLOCK END ========================
				
		|	('open')
			
			//==================== JAVA BLOCK BEGIN =======================
			{	if (assignWidth==0)
					assignWidth++;
				
				NetNode n = des.getNet("open");
				if (n == null) {
					n = new NetNode(des);
					n.setName("open");
					n.setLocation(-1,-1, null);
					des.addNet(n);
				}
				
				for	(int i = 0; i < assignWidth; i++)
					concats.add(n);

			}
			//===================== JAVA BLOCK END ========================	
		)	
	;

/**
 * The attributeQualifier rule accepts the instance name that the qualifier resides in, an empty list of 
 * indices that will be populated, and a pointer to the design.  The attributeQualifier rule determines 
 * which instances the attribute assignment applies.
 *
 * This rule performs the following functions:
 * 1. Call the arrayList rule (if one exists) to populate the list of indices, or
 * 2. Call the arrayIndices rule to populate the list of all available indices.
 */
attributeQualifier[String instName, List<Integer> indices, DesignNode des]
	:	^(PERIOD 'each' (arrayList[indices] | arrayIndices[instName, indices, des]) )	
	;
	
/**
 * The pinQualifier rule accepts the instance name that the qualifier resides in, and empty list of indices
 * that will be populated, and a pointer to the design.  The pinQualifier rule determines which instances
 * the pin assignment applies.
 *
 * This rule performs the following functions:
 */
pinQualifier[String instName, List<Integer> indices, DesignNode des] returns [boolean combine]
	:	{$combine = false;}	
		^(PERIOD ('each' | 'combine' {$combine = true;}) 
		(arrayList[indices] | arrayIndices[instName, indices, des]))
	;

/**
 * The arrayIndices rule adds all indices from the set of instances in the design with instName as a name.  This
 * rule is executed by default when the user does not specifiy an attribute or pin qualifier before the assignment.
 */
arrayIndices[String instName, List<Integer> indices, DesignNode des]
	:	{indices.addAll(des.getAllIndices(instName));}
	;

/**
 * The pinSlices rule adds all indices from the set of pins in the instance to the list of slices to return.
 */
pinSlices[List<Integer> slices, String pinName, DesignNode des, String instName] 
	:	{	InstanceNode inst = des.getAllInstances(instName).get(0);
			List<Integer> pins = inst.getAllIndices(pinName);
			slices.addAll(pins);
		}
	;
	
netSlices[List<Integer> slices, String netName, DesignNode des]
	:	{	List<Integer> nets = des.getAllNetIndices(netName);
			slices.addAll(nets);
		}
	;
	
concatSlices[List<Integer> slices, String netName, DesignNode des]
	:	{slices.addAll(des.getAllNetIndices(netName));}
	;

/**
 * The arrayList rule accepts an empty list of integers as its argument to populate with all
 * of the indices inside the subtree.  The array subtree may have either a comma or colon as the parent
 * or may be a flat list beginning with a left parentheses (in the case of a single index).
 *
 * This rule performs the following functions:
 * 1. For recursive subtrees with a comma as the parent, add the values in order to the list
 * 2. For subtrees with a colon as the parent, add all integers in order from the first to last child to the list.
 * 3. For flat subtrees (single index) add the single integer to the list.
 */
arrayList[List<Integer> indices]
	:	// the case of a comma seperated array list
		^(COMMA LEFTPAREN first=INTEGER		{indices.add(Integer.parseInt($first.text));}
      	(next=INTEGER						{indices.add(Integer.parseInt($next.text));}		)*)
      	
      	// the case of a colon seperated array list
	| 	^(COLON	LEFTPAREN first=INTEGER last=INTEGER
			
			//==================== JAVA BLOCK BEGIN =======================
			{	int msb = Integer.parseInt($first.text);
				int lsb = Integer.parseInt($last.text);
				if (msb <= lsb) {	
        			for (int i = msb; i <= lsb; i++)
          				indices.add(i);
      			}
      			else {
        			for (int i = msb; i >= lsb; i--) 
        				indices.add(i);
      			}
			}
			//===================== JAVA BLOCK END ========================
		)
		
		// the case of a single index
	|	(LEFTPAREN single=INTEGER 	{indices.add(Integer.parseInt($single.text));}				)
 	;

/**
 * The sliceList rule accepts an empty list of integers as its argument to populate with all
 * of the slices inside the subtree.  The slice subtree may have either a comma or colon as the parent
 * or may be a flat list beginning with a left bracket (in the case of a single bit slice).
 *
 * This rule performs the following functions:
 * 1. For recursive subtrees with a comma as the parent, add the values in order to the list
 * 2. For subtrees with a colon as the parent, add all integers in order from the first to last child to the list.
 * 3. For flat subtrees (single bit slice) add the single integer to the list.
 */
sliceList[List<Integer> slices]
	:	// the case of a comma seperated slice list
		^(COMMA LEFTBRACKET first=INTEGER  	{slices.add(Integer.parseInt($first.text));}
      	(next=INTEGER						{slices.add(Integer.parseInt($next.text));}			)*)
      	
      	// the case of a colon seperated slice list
	|	^(COLON LEFTBRACKET first=INTEGER last=INTEGER
		
			//==================== JAVA BLOCK BEGIN =======================		
			{	int msb = Integer.parseInt($first.text);
				int lsb = Integer.parseInt($last.text);
			
				if (msb <= lsb) {	
					// increment for up slice lists
        			for (int i = msb; i <= lsb; i++)
          				slices.add(i);
      			} else {
      				// decrement for down slice lists
        			for (int i = msb; i >= lsb; i--)
           				slices.add(i);
      			}
			}
			//===================== JAVA BLOCK END ========================
		)
		
		// the case of a single bit slice
	|	(LEFTBRACKET single=INTEGER 	{slices.add(Integer.parseInt($single.text));}			)
 	;


/**
 * The pinList rule accepts an empty list of strings as its argument to populate with all
 * of the pin numbers inside a pin list subtree.  It populates the list in left to right
 * order, as the pin list appears in the source text.  A pin list in the source text is
 * defined by a comma-separated list enclosed in braces.
 *
 * This rule performs the following functions:
 * 1. Adds each pin number in the tree to the list of strings passed in.
 * 2. Checks for duplicate pin numbers in the tree with a set
 */
pinList[List<String> pList]
	:	first= (INTEGER | IDENT)

			//==================== JAVA BLOCK BEGIN =======================	
			{	// maintain a set of pin numbers to check for duplicates in the pin list
				Set<String> pins = new HashSet<String>();
				if (!pins.add($first.text))
					addError($first, "duplicate pin number in pin list");
				pList.add($first.text);
			}
			//===================== JAVA BLOCK END ========================
		
     	(next= (INTEGER | IDENT)	
     	
     		//==================== JAVA BLOCK BEGIN =======================	
     		{	if (!pins.add($next.text))
					addError($next, "duplicate pin number in pin list");
				pList.add($next.text);
			}
			//===================== JAVA BLOCK END ========================	
				
     	)*
 	;