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
	
	public Device getDevice(String name) {
		for (Device d : devices) {
			if (d.getName().equals(name))
				return d;
		}
		return null;
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
	
	private void setLocation(Node n, CommonTree ct) {
		n.setLocation(ct.getLine(), ct.getCharPositionInLine(), 
			ct.getToken().getInputStream().getSourceName());
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
	:	(deviceDecl | designDecl)+
	;
	
deviceDecl
	:	^(DEVICE_DECL devName=IDENT 
	
		{	// make a new device node
			Device dev = new Device($devName.text);
			setLocation(dev, $devName);
			// check for duplicate device declarations
			if (!devices.add(dev)) 
				addError($devName, "Duplicate device declaration");
			
			// create a list with only one device
			List<Attributable> devs = new ArrayList<Attributable>();
			devs.add(dev);
			
			// clear these sets each time a device is processed
			pinNames.clear();
		}
	
		infoDecl* attrDecl[devs]* pinDecl[dev]* )
		
		{	// report any missing required attributes
			for (String s : reqAttrs) {
				if (dev.getAttribute(s) == null)
					addError($devName, "required attribute \"" + s + "\" missing in device");
			}
		}
	;
	
attrDecl[List<Attributable> parents]
	:	^(ATTR_DECL attrName=IDENT attrValue=STRING)
	
		{	for (Attributable parent : parents) {
				// make a new attribute node, assign its parent, and log its location
		   		Attribute a  = new Attribute(parent);
		   		a.setName($attrName.text);
				a.setValue($attrValue.text);
				setLocation(a, $attrName);
		   			
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
				setLocation(p, $pinName);
				if (hasWidth) p.setIndex($widthDecl.msb);
				// accessing the pinlist may throw an exception
				try {
					p.setPinMapping($pinList.list.get(0));
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
						setLocation(p, $pinName);
						p.setIndex(i);
						// accessing the pinlist may throw an exception
						try {
							p.setPinMapping($pinList.list.get($widthDecl.msb - i));
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
						setLocation(p, $pinName);
						p.setIndex(i);
						// accessing the pinlist may throw an exception
						try {
							p.setPinMapping($pinList.list.get(i));
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
	
designDecl
	:	^(DESIGN_DECL desName=IDENT
		{	// make a new design based on the identifier and log its location
			Design des = new Design();
			des.setName($desName.text);
			setLocation(des, $desName);
			
			netNames.clear();
			instNames.clear();
			designs.add(des);
		}
	(	infoDecl
	|	netDecl[des]
	|	instDecl[des, null]
	)*)
	;
	
netDecl[Design des]
	:	^(NET_DECL 
		{	boolean hasWidth = false;
			List<Attributable> nets = new ArrayList<Attributable>();
		}
	
		(widthDecl {hasWidth = true;})? (netName=IDENT
		
			{	// make new nets for each name
				if (!hasWidth || $widthDecl.width == 1) {
					Net n = new Net(des);
					n.setName($netName.text);
					setLocation(n, $netName);
					if (hasWidth)
						n.setIndex($widthDecl.msb);
					if (!des.addNet(n) || !netNames.add($netName.text)) 
						addError($netName, "duplicate net declaration");
					nets.add(n);
				} else if ($widthDecl.downto) {
					for (int i = $widthDecl.msb; i >= $widthDecl.lsb; i--) {
						Net n = new Net(des);
						n.setName($netName.text);
						setLocation(n, $netName);
						n.setIndex(i);
						if (!des.addNet(n) || !netNames.add($netName.text + i)) 
							addError($netName, "duplicate net declaration");
						nets.add(n);
					}
				} else {
					for (int i = $widthDecl.msb; i <= $widthDecl.lsb; i++) {
						Net n = new Net(des);
						n.setName($netName.text);
						setLocation(n, $netName);
						n.setIndex(i);
						if (!des.addNet(n) || !netNames.add($netName.text + i)) 
							addError($netName, "duplicate net declaration");
						nets.add(n);
					}
				}
			}
		)*

		attrDecl[nets]*)
	;
	
instDecl[Design des, String groupName]
	:	{boolean hasWidth = false;}
		^(INST_DECL (widthDecl {hasWidth = true;})? instName=IDENT devName=IDENT 
		
		{	Device dev = getDevice($devName.text);
			if (dev == null)
				bailOut($instName, "instance references undeclared device");
			if (!hasWidth || $widthDecl.width == 1) {
				Instance i = new Instance(des);
				i.setName($instName.text);
				i.setDevice(dev);
				setLocation(i, $instName);
				i.setGroupName(groupName);
				if (hasWidth)
					i.setIndex($widthDecl.msb);
				// copy all of the attribute and pin nodes from the device
				for (Attribute a: dev.getAttributes())
					i.addAttribute(new Attribute(a, i));
				for (Pin p: dev.getPins())
					i.addPin(new Pin(p, i));
				// check for duplicates
				if (!des.addInstance(i) || !instNames.add($instName.text))
					addError($instName, "duplicate instance declaration");
			} else if ($widthDecl.downto) {
				for (int j = $widthDecl.msb; j >= $widthDecl.lsb; j--) {
					Instance i = new Instance(des);
					i.setName($instName.text);
					i.setDevice(dev);
					setLocation(i, $instName);
					i.setGroupName(groupName);
					i.setIndex(j);
					// copy all of the attribute and pin nodes from the device
					for (Attribute a: dev.getAttributes())
						i.addAttribute(new Attribute(a, i));
					for (Pin p: dev.getPins())
						i.addPin(new Pin(p, i));
					// check for duplicates
					if (!des.addInstance(i) || !instNames.add($instName.text + j))
						addError($instName, "duplicate instance declaration");
				}
			} else {
				for (int j = $widthDecl.msb; j <= $widthDecl.lsb; j++) {
					Instance i = new Instance(des);
					i.setName($instName.text);
					i.setDevice(dev);
					setLocation(i, $instName);
					i.setGroupName(groupName);
					i.setIndex(j);
					// copy all of the attribute and pin nodes from the device
					for (Attribute a: dev.getAttributes())
						i.addAttribute(new Attribute(a, i));
					for (Pin p: dev.getPins())
						i.addPin(new Pin(p, i));
					// check for duplicates
					if (!des.addInstance(i) || !instNames.add($instName.text + j))
						addError($instName, "duplicate instance declaration");
				}
			}
		}
	
		infoDecl* attrAssign[des, $instName.text]*)
	;
	
attrAssign[Design des, String instName]
@init{boolean newAttr = false;}
	:	^(ATTR_ASSIGN (NEWATTR {newAttr = true;})? listDecl? name=IDENT value=STRING)
	;
	
listDecl returns [List<Integer> indices, int msb, int lsb, boolean isArray]
@init{$indices = new ArrayList<Integer>();}
	:	^(LIST_ARRAY hi=INT lo=INT)
		{	$msb = Integer.parseInt($hi.text);
			$lsb = Integer.parseInt($lo.text);
			$isArray = true;
		}
	|	^(LIST_SLICE (index=INT {$indices.add(Integer.parseInt($index.text));})+ 
	)
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
@init{$list = new ArrayList<String>();}
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
	
infoDecl returns [String value]
	: 	^(INFO_DECL (st=STRING {value += $st.text;})+)
	;