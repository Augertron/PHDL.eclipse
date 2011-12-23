/*
    Copyright (C) 2011  Brigham Young University

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, version 3.

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
tree grammar PhdlWalker2;

options {
	language = Java;
	tokenVocab = Phdl2;
	ASTLabelType = CommonTree;
}

@header {
/*
    Copyright (C) 2011  Brigham Young University

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, version 3.

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
	
	public DesignNode getDesignNode(String name) {
		for (DesignNode d : designNodes) {
			if (d.getName().equals(name))
				return d;
		}
		return null;
	}
	
	/**
	 * The set of all Devices is global to the project build
	 */
	private Set<DeviceNode> devices = new HashSet<DeviceNode>();
	
	public Set<DeviceNode> getDevices() {
		return devices;
	}
	
	public void setDevices(Set<DeviceNode> devices) {
		this.devices = devices;
	}
	
	private Set<SubDesignNode> designs = new HashSet<SubDesignNode>();
	
	/**
	 * Sets to check for duplicates while processing everything
	 */
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
	 * Reports an error from a Node object and exits
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

sourceText
	:	(deviceDecl)+
	;
	
deviceDecl
	:	^(DEVICE_DECL devName=ID 
	
		{	// make a new device node
			DeviceNode dev = new DeviceNode($devName.text);
			dev.setLocation($devName.line, $devName.pos, 
					devName.getToken().getInputStream().getSourceName());
					
			if (!devices.add(dev)) 
				addError(dev, "Duplicate device declaration");
			
			// clear these sets each time a device is processed
			pinDecls.clear();
		}
	
		attrDecl[dev]* 
		
		{	// report any missing required attributes
			for (String s : reqAttrs) {
				s = s.toUpperCase();
				if (dev.getAttribute(s) == null)
					addError($devName, "required attribute \"" + s + "\" missing in device");
			}
		}
		
		pinDecl[dev]*)
	;
	
attrDecl[Attributable parent]
	:	^(ATTR_DECL attrName=IDENT attrValue=STRING)
	
		{	// make a new attribute node, assign its parent, and log its location
	   		AttributeNode a  = new AttributeNode(parent);
	   		a.setName($attrName.text);
			a.setValue($attrValue.text);
	   		a.setLocation($attrName.line, $attrName.pos, 
	   			attrName.getToken().getInputStream().getSourceName());
	   			
	   		// check for duplicate attributes while adding
			if (!parent.addAttribute(a));
				addError($attrName, "duplicate attribute declaration");
				
			// check if the attribute is a refprefix attribute
			if ($attrName.text.equals("REFPREFIX")) {
				// check to see if refPrefix begins with a letter
				if (!Pattern.compile("^[A-Z]").matcher($attrValue.text).find())
					addError($attrName, "invalid refPrefix in device");
			}			
		}
	;
	
pinDecl[DeviceNode dev]
	:	{List<String> pList = new ArrayList<String>();}
		{boolean width = false;}
		
		^(PIN_DECL pinName=IDENT (widthDecl? {width = true;})
		
		pinList[pList] pinType)
	;
	
widthDecl returns [int msb, int lsb]
	:	^(WIDTH_DECL val1=INT val2=INT)
		{	$msb = Integer.parseInt($val1.text);
			$lsb = Integer.parseInt($val2.text);
		}
	;

pinList[List<String> pList]
	:	^(PIN_LIST
	(	num1=INT	{pList.add($num1.text);}
	|	num2=IDENT	{pList.add($num2.text);})+
	)
	;
	
pinType returns [PinType type]
	:	^(PIN_TYPE 
	(	PIN 	{$type = PinType.PIN;}
	|	INPIN	{$type = PinType.INPIN;}
	|	OUTPIN	{$type = PinType.OUTPIN;}
	|	IOPIN	{$type = PinType.IOPIN;}
	|	PWRPIN	{$type = PinType.PWRPIN;}
	|	SUPPIN	{$type = PinType.SUPPIN;}))
	;
