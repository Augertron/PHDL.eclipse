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

	/** The set of required attributes */
	private Set<String> reqAttrs = new HashSet<String>();
	/** The list of errors */
	private List<String> errors = new ArrayList<String>();
	/** The list of warnings */
	private List<String> warnings = new ArrayList<String>();
	/** * The set of processed design nodes  */
	private Set<Design> designs = new HashSet<Design>();
	/** The set of all Devices is global to the project build */
	private Set<Device> devices = new HashSet<Device>();
	/** Sets to check for duplicates while processing everything */
	private Set<String> pinNames = new HashSet<String>();
	private Set<String> netNames = new HashSet<String>();
	private Set<String> instNames = new HashSet<String>();
	
	private Set<SubDesign> subDesigns = new HashSet<SubDesign>();
	
	public Design getDesign(String name) {
		for (Design d : designs) {
			if (d.getName().equals(name))
				return d;
		}
		return null;
	}
	
	public Set<Device> getDevices() {
		return devices;
	}
	
	public void setDevices(Set<Device> devices) {
		this.devices = devices;
	}
		
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
	public Set<Design> getDesigns() {
		return designs;
	}
	
	/**
	 * Called on the walker object to pass in a set of required attributes
	 */
	public void setRequiredAttributes(Set<String> reqAttrs) {
		this.reqAttrs.addAll(reqAttrs);
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
	:	^(DEVICE_DECL devName=IDENT 
	
		{	// make a new device node
			Device dev = new Device($devName.text);
			dev.setLocation($devName.line, $devName.pos, 
					devName.getToken().getInputStream().getSourceName());
			// check for duplicate device declarations
			if (!devices.add(dev)) 
				addError($devName, "Duplicate device declaration");
			
			// clear these sets each time a device is processed
			pinNames.clear();
		}
	
		(attrDecl[dev] | pinDecl[dev])* )
		
		{	// report any missing required attributes
			for (String s : reqAttrs) {
				s = s.toUpperCase();
				if (dev.getAttribute(s) == null)
					addError($devName, "required attribute \"" + s + "\" missing in device");
			}
		}
	;
	
attrDecl[Attributable parent]
	:	^(ATTR_DECL attrName=IDENT attrValue=STRING)
	
		{	// make a new attribute node, assign its parent, and log its location
	   		Attribute a  = new Attribute(parent);
	   		a.setName($attrName.text);
			a.setValue($attrValue.text);
	   		a.setLocation($attrName.line, $attrName.pos, 
	   			attrName.getToken().getInputStream().getSourceName());
	   			
	   		// check for duplicate attributes while adding
			if (!parent.addAttribute(a))
				addError($attrName, "duplicate attribute declaration");
				
			// check if the attribute is a refprefix attribute
			if (a.getName().equals("REFPREFIX")) {
				// check to see if refPrefix begins with a letter
				if (!Pattern.compile("^[A-Z]").matcher(a.getValue()).find())
					addError($attrName, "invalid refPrefix in device");
			}			
		}
	;
	
pinDecl[Device dev]
	:	{boolean hasWidth = false;}
		
		^(PIN_DECL pinName=IDENT pinType (widthDecl {hasWidth = true;})? pinList)
		
		{	// make a single pin if there is no width
			if (!hasWidth || $widthDecl.width == 1) {
				if ($pinList.list.size() != 1)
					addError($pinName, "invalid pin list");
				Pin p = new Pin(dev);
				p.setName($pinName.text);
				p.setPinType($pinType.type);
				p.setLocation($pinName.line, $pinName.pos, 
					pinName.getToken().getInputStream().getSourceName());
				if (hasWidth) p.setIndex($widthDecl.msb);
				// accessing the pinlist may throw an exception
				try {
					p.setPinNumber($pinList.list.get(0));
				} catch (IndexOutOfBoundsException e) {
					addError($pinName, "invalid pin list");
				}
				// report any duplicate pin declarations
				if (!dev.addPin(p))
	           		addError($pinName, "duplicate pin declaration");
			} else {
				// make an array of pins based on the width parameters
				if ($widthDecl.width != $pinList.list.size())
					addError($pinName, "invalid pin list");
				if ($widthDecl.downto) {
					// make array of pins for msb > lsb
					for (int i = $widthDecl.msb; i >= $widthDecl.lsb; i--) {
						Pin p = new Pin(dev);
						p.setName($pinName.text);
						p.setPinType($pinType.type);
						p.setLocation($pinName.line, $pinName.pos,
							pinName.getToken().getInputStream().getSourceName());
						p.setIndex(i);
						// accessing the pinlist may throw an exception
						try {
							p.setPinNumber($pinList.list.get($widthDecl.msb - i));
						} catch (IndexOutOfBoundsException e) {
							addError($pinName, "invalid pin list");
						}
						// report any duplicate pin declarations
						if (!dev.addPin(p))
			           		addError($pinName, "duplicate pin declaration");
					}
				} else {
					// make array of pins for msb < lsb
					for (int i = $widthDecl.msb; i <= $widthDecl.lsb; i++) {
						Pin p = new Pin(dev);
						p.setName($pinName.text);
						p.setPinType($pinType.type);
						p.setLocation($pinName.line, $pinName.pos,
							pinName.getToken().getInputStream().getSourceName());
						p.setIndex(i);
						// accessing the pinlist may throw an exception
						try {
							p.setPinNumber($pinList.list.get(i));
						} catch (IndexOutOfBoundsException e) {
							addError($pinName, "invalid pin list");
						}
						// report any duplicate pin declarations
						if (!dev.addPin(p))
			           		addError($pinName, "duplicate pin declaration");
					}
				}
				// check for overall duplicates based solely on the name
				if (!pinNames.add($pinName.text))
					addError($pinName, "duplicate pin declaration");
			}
		}
	;
	
widthDecl returns [int msb, int lsb, int width, boolean downto]
	:	^(WIDTH_DECL hi=INT lo=INT)
		{	$msb = Integer.parseInt($hi.text);
			$lsb = Integer.parseInt($lo.text);
			$width = Math.abs($msb - $lsb) + 1;
			$downto = ($msb > $lsb)? true: false;
		}
	;

pinList returns [List<String> list]
@init{list = new ArrayList<String>();}
	:	^(PIN_LIST
	(	num1=INT	{$list.add($num1.text);}
	|	num2=IDENT	{$list.add($num2.text);}
	|	num3=PINNUM	{$list.add($num3.text);})+
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
