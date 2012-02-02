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
tree grammar PhdlAST;

options {
	language = Java;
	tokenVocab = Phdl;
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
	
	/** The set of all Devices is global to the project build */
	private Set<Device> devices;
	
	/** The top level design */
	private	Design topDesign;
	
	/** The set of subDesigns */
	private Set<SubDesign> subDesigns;
	
	/** Sets to check for duplicates while processing everything */
	private Set<String> pinNames = new HashSet<String>();
	
	/** port and net names */
	private Set<String> conNames = new HashSet<String>();
	
	/** A set of any instanced names (instance or subdesign names) */
	private Set<String> instNames = new HashSet<String>();
	
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
	
	public Design getTopDesign() {
		return topDesign;
	}
	
	public void setTopDesign(Design topDesign) {
		this.topDesign = topDesign;
	}
	
	public Set<SubDesign> getSubDesigns() {
		return subDesigns;
	}
	
	public void setSubDesigns(Set<SubDesign> subDesigns) {
		this.subDesigns = subDesigns;
	}
	
	public SubDesign getSubDesign(String name) {
		for (SubDesign s : subDesigns) {
			if (s.getName().equals(name))
				return s;
		}
		return null;
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
	
	private void setLocation(Node n, CommonTree ct) {
		n.setLocation(ct.getLine(), ct.getCharPositionInLine(), 
			ct.getToken().getInputStream().getSourceName());
	}
	
	private void subInstAttr(SubInstance subInst, Stack<name_return> names, CommonTree attrName, CommonTree attrValue, boolean newAttr) {
		
		// the current name to reference either subinstances' or instances' attributes
		name_return currName = names.pop();
		
		//System.out.println(currName.id.getText() + " " + attrName.getText() + " " + attrValue.getText());
		
		List<SubInstance> subInsts = new ArrayList<SubInstance>();
		List<Instance> insts = new ArrayList<Instance>();
		
		// gather all relevant subinstances or instances
		if (currName.indices == null) {
			subInsts.addAll(subInst.getSubInstancesByName(currName.id.getText()));
			insts.addAll(subInst.getInstancesByName(currName.id.getText()));
		} else {
			for (Integer i : currName.indices) {
				SubInstance s = subInst.getSubInstance(currName.id.getText(), i);
				if (s != null)
					subInsts.add(s);
				else {
					Instance inst = subInst.getInstance(currName.id.getText(), i);
					if (inst != null)
						insts.add(inst);
					else
						bailOut(currName.id, "invalid subinstance or instance reference");
				}
			}
		}
			
		// if both lists turn up empty, the current name does not reference a subinstance or instance
		if (subInsts.isEmpty() && insts.isEmpty())
			bailOut(currName.id, "subinstance or instance name does not exist in " + subInst.getName());
		
		// if the stack is empty, assign the attribute
		if (names.isEmpty()) {
			//System.out.println("the stack is empty:" + insts.size());
			for (Instance i : insts) {
				Attribute a = i.getAttribute(attrName.getText());
				if (a != null) {
					if (newAttr)
						addError(attrName, "new attribute already declared");
					if (!a.overwrite(attrValue.getText()))
						addWarning(attrName, "attribute already overwritten");
					setLocation(a, attrName);
					//System.out.println(((Instance) a.getParent()).getParent().getName());
				} else if (newAttr) {
					Attribute newA = new Attribute(i, attrName.getText(), attrValue.getText());
					setLocation(newA, attrName);
					i.addAttribute(newA);
				} else
					addError(attrName, "undeclared attribute");
				//System.out.print(i.getParent());
			}
		// otherwise go down a level of hierarchy to find the attribute to assign
		} else {
			if (subInsts.isEmpty())
				bailOut(names.peek().id, "subinstance or instance name does not exist in " + subInst.getName());
			for (SubInstance s : subInsts) {
				//System.out.println("going down to: " + s.getNameIndex());
				subInstAttr(s, names, attrName, attrValue, newAttr);
				//System.out.println("coming up to: " + subInst.getNameIndex());
			}
		}
		
		names.push(currName);
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
	
		{	Device dev = new Device($devName.text);
			setLocation(dev, $devName);
			if (!devices.add(dev)) 
				addError($devName, "Duplicate device declaration");
			
			// create a list with only one device
			List<Attributable> devs = new ArrayList<Attributable>();
			devs.add(dev);
			
			// clear the set of pin names that check for duplicates
			pinNames.clear();
		}
	
		(infoDecl 	{dev.appendInfo($infoDecl.info.getText());})* 
		
		attrDecl[devs]* 
		
		{	// report any missing required attributes
			for(String s : reqAttrs) {
				s = s.toUpperCase();
				if(dev.getAttribute(s)==null)
					addError($devName, "required attribute \"" + s + "\" missing in device");
			}
		}
		
		pinDecl[dev]* 
		
		)
	;
	
attrDecl[List<Attributable> parents]
	:	^(ATTR_DECL attrName=IDENT attrValue=STRING)
	
		{	for (Attributable p : parents) {
				// make a new attribute node
		   		Attribute a  = new Attribute(p, $attrName.text, $attrValue.text);
				setLocation(a, $attrName);
		   			
		   		// check for duplicate attributes while adding
				if (!p.addAttribute(a))
					addError($attrName, "duplicate attribute declaration");
					
				// check if the attribute is a refprefix attribute
				if (a.getName().equals("REFPREFIX")) {
					// check to see if refPrefix begins with a letter
					if (!Pattern.compile("^[A-Z,a-z]").matcher(a.getValue()).find())
						addError($attrName, "invalid refPrefix in device");
				}
			}	
		}
	;
	
pinDecl[Device dev]
	:	^(PIN_DECL pinName=IDENT pinType width? pinList)
		
		{	// make a single pin if there is no width
			if ($width.indices == null || $width.indices.size() == 1) {
				if ($pinList.list.size() != 1)
					addError($pinName, "invalid pin list");
				Pin p = new Pin(dev, $pinName.text, $pinType.type);
				setLocation(p, $pinName);
				if ($width.indices != null) 
					p.setIndex($width.indices.get(0));
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
				if ($width.indices.size() != $pinList.list.size())
					addError($pinName, "invalid pin list");
				for (int i = 0; i < $width.indices.size(); i++) {
					Pin p = new Pin(dev, $pinName.text, $pinType.type);
					setLocation(p, $pinName);
					p.setIndex($width.indices.get(i));
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

				// check for overall duplicates based solely on the name
				if (!pinNames.add($pinName.text))
					addError($pinName, "duplicate pin declaration");
			}
		}
	;
	
designDecl
	:	^((desKeyword=DESIGN_DECL | SUBDESIGN_DECL) (desName=IDENT
	
		{	// make a new design based on the identifier and log its location
			DesignUnit des;
			if ($desKeyword != null) {
				des = new Design($desName.text);
				if (topDesign == null)
					topDesign = (Design) des;
				else
					bailOut($desName, "top level design already declared");
			} else {
				des = new SubDesign($desName.text);
				if (!subDesigns.add((SubDesign) des))
					bailOut($desName, "duplicate subdesign declaration");
			}

			System.out.println("  -- Compiling: " + $desName.text);
			setLocation(des, $desName);							
				
			// sets check for duplicate names within the scope of a design.
			conNames.clear();
			instNames.clear();
		}
		
	(	groupDecl[des]
	|	portDecl[des] 
	|	netDecl[des]
	|	instDecl[des, null]
	|	subInstDecl[des]
	|	connectAssign[des]
	|	(infoDecl			{des.appendInfo($infoDecl.info.getText());})
	)*))
	;
	
groupDecl[DesignUnit des]
	:	^(GROUP_DECL groupName=STRING
	(	portDecl[des]
	|	netDecl[des]
	|	instDecl[des, $groupName.text]
	|	connectAssign[des]
	|	(infoDecl			{des.appendInfo($infoDecl.info.getText());})
	)*)
	;
	
portDecl[DesignUnit subDes]
	:	^(PORT_DECL width? (portName=IDENT
	
			{	// verify the port is not in a design
				if (subDes instanceof Design)
					bailOut($portName, "ports are only allowed in subdesigns");
				if ($width.indices == null || $width.indices.size() == 1) {
					Port p = new Port(subDes, $portName.text);
					setLocation(p, $portName);
					if ($width.indices != null)
						p.setIndex($width.indices.get(0));
					if(!subDes.addConnection(p))
						addError($portName, "duplicate port declaration");
				} else {
					for (int i = 0; i < $width.indices.size(); i++) {
						Port p = new Port(subDes, $portName.text);
						setLocation(p, $portName);
						p.setIndex($width.indices.get(i));
						if (!subDes.addConnection(p))
							addError($portName, "duplicate port declaration");
					}
				}
				// check for duplicates based soley on the name of the port
				if (!conNames.add($portName.text))
					addError($portName, "duplicate port declaration");
			}
		)*)
	;
	
netDecl[DesignUnit des]
@init{List<Attributable> nets = new ArrayList<Attributable>();}
	:	^(NET_DECL width? (netName=IDENT
		
			{	if ($width.indices == null || $width.indices.size() == 1) {
					Net n = new Net(des, $netName.text);
					setLocation(n, $netName);
					if ($width.indices != null)
						n.setIndex($width.indices.get(0));
					if (!des.addConnection(n)) 
						addError($netName, "duplicate net declaration");
					nets.add(n);
				} else {
					for (int i = 0; i < $width.indices.size(); i++) {
						Net n = new Net(des, $netName.text);
						setLocation(n, $netName);
						n.setIndex($width.indices.get(i));
						if (!des.addConnection(n))
							addError($netName, "duplicate net declaration");
						nets.add(n);
					}
				}	
					
				// check for duplicates based soley on the name of the net
				if (!conNames.add($netName.text))
					addError($netName, "duplicate net declaration");
			}
		)*
		
		attrDecl[nets]*)
	;
	
instDecl[DesignUnit des, String groupName]
	:	^(INST_DECL width? instName=IDENT devName=IDENT 
		
		{	Device dev = getDevice($devName.text);
			if (dev == null)
				bailOut($instName, "instance references undeclared device");
			if ($width.indices == null || $width.indices.size() == 1) {
				Instance i = new Instance(des, dev, $instName.text);
				setLocation(i, $instName);
				i.setGroupName(groupName);
				i.setInfo(dev.getInfo());
				if ($width.indices != null)
					i.setIndex($width.indices.get(0));
				// check for duplicates
				if (!des.addInstance(i))
					addError($instName, "duplicate instance declaration");
			
			} else {
				for (int j = 0; j < $width.indices.size(); j ++) {
					Instance i = new Instance(des, dev, $instName.text);
					setLocation(i, $instName);
					i.setGroupName(groupName);
					i.setInfo(dev.getInfo());
					i.setIndex($width.indices.get(j));
					// check for duplicates
					if (!des.addInstance(i))
						addError($instName, "duplicate instance declaration");
				}
			} 
		}
		
		(infoDecl 
			{	List<Instance> insts = des.getInstancesByName($instName.text);
				if ($infoDecl.indices == null) {
					for (Instance i : insts)
						i.appendInfo(" " + $infoDecl.info.getText());
				} else {
					// for all the indices in the array list declaration
					for (Integer index : $infoDecl.indices) {
						// search for the instance with this index
						Instance i = null;
						for (Instance inst : insts)
							if (index == inst.getIndex()) 
								i = inst;
						
						if (i != null) {
							i.appendInfo(" " + $infoDecl.info.getText());
						// the instance referenced by the index doesn't exist
						} else
							addWarning($infoDecl.info, "instance index (" + index + ") does not exist");
					}
				}
			}
		)*
		
			{	// check for duplicates based solely on the raw instance name
				if (!instNames.add($instName.text))
					addError($instName, "duplicate instance name exists in design unit");
			}
		
		attrAssign[des, $instName.text]* pinAssign[des, $instName.text]*
		
			{	// assign the refprefix, refdes, package, and library if it exists
				for (Instance i : des.getInstancesByName($instName.text)) {
					for (Attribute a : i.getAttributes()) {
						if (a.getName().equals("REFPREFIX"))
							i.setRefPrefix(a.getValue());
						else if (a.getName().equals("REFDES"))
							i.setRefDes(a.getValue());
						else if (a.getName().equals("PACKAGE"))
							i.setPackage(a.getValue());
						else if (a.getName().equals("LIBRARY"))
							i.setLibrary(a.getValue());
					}
				}
			}
		)
	;
	
attrAssign[DesignUnit des, String instName]
@init{boolean newAttr = false;}
	:	^(ATTR_ASSIGN (NEWATTR {newAttr = true;})? qualifier? attrName=IDENT attrValue=STRING)
		
		{	// a list of all candidate instances from the design
			List<Instance> insts = new ArrayList<Instance>();
			if ($qualifier.indices == null)
				insts.addAll(des.getInstancesByName(instName));
			else {
				for (Integer i : $qualifier.indices) {
					Instance inst = des.getInstance(instName, i);
					if (inst == null)
						bailOut($qualifier.name, "invalid instance qualifier index (" + i + ")");
					else
						insts.add(inst);
				}
			}
			
			for (Instance i : insts) {
				Attribute a = i.getAttribute($attrName.text);
				if (a != null) {
					if (newAttr)
						addError($attrName, "new attribute already declared");
					if (!a.overwrite($attrValue.text))
						addWarning($attrName, "attribute already overwritten");
					setLocation(a, $attrName);
				} else if (newAttr) {
					Attribute newA = new Attribute(i, $attrName.text, $attrValue.text);
					setLocation(newA, $attrName);
					i.addAttribute(newA);
				} else
					addError($attrName, "undeclared attribute");
			}
		}
	;
	
pinAssign[DesignUnit des, String instName]
@init{boolean isCombined = false;}
	:	^(PIN_ASSIGN (COMBINE {isCombined = true;})? qualifier? operand concat[des])
		{	// gather the relevant instances in a list
			List<Instance> insts = new ArrayList<Instance>();
			if ($qualifier.indices == null)
				insts.addAll(des.getInstancesByName(instName));
			else {
				for (Integer i : $qualifier.indices) {
					Instance inst = des.getInstance(instName, i);
					if (inst == null)
						bailOut($qualifier.name, "invalid instance qualifier index (" + i + ")");
					else
						insts.add(inst);
				}
			}
			
			// list of pins to assign connections to
			List<Pin> pins = new ArrayList<Pin>();
			
			if (isCombined) {
				if ($operand.indices == null) {
					// get all possible instances
					for (Instance inst : insts)
						pins.addAll(inst.getAllPins($operand.id.getText()));
					if (pins.size() == 0)
						bailOut($operand.id, "undeclared pin");
				} else {
					// get only those instances with the indices in the list
					for (Instance inst : insts) {
						for (Integer i : $operand.indices) {
							Pin p = inst.getPin($operand.id.getText(), i);
							if (p == null)
								bailOut($operand.id, "undeclared pin or invalid pin index [" + i + "]");
							else
								pins.add(p);
						}
					}
				}

				for (int i = 0; i < pins.size(); i++) {
				
					// check to see if the pin is already assigned
					if (pins.get(i).isAssigned()) {
						String index = (pins.get(i).hasIndex())?("index [" + pins.get(i).getIndex() + "]"):("pin");
						bailOut($operand.id, index + " is already assigned");
					} else if (pins.get(i).isOpen()) {
						String index = (pins.get(i).hasIndex())?("index [" + pins.get(i).getIndex() + "]"):("pin");
						bailOut($operand.id, index + " is already open");
						
					// assign the pin based on the flags
					} else if ($concat.isReplicated) {
						pins.get(i).setAssignment($concat.cons.get(0));
						$concat.cons.get(0).addPin(pins.get(i));
					} else if ($concat.isOpen) {
						pins.get(i).setOpen(true);
					} else {
						// check for width mismatch
						if (pins.size() != $concat.cons.size()) {
							bailOut($operand.id, "pin assignment left size [" + pins.size() + 
								"] does not match right size [" + $concat.cons.size() + "]");
						} else {
							pins.get(i).setAssignment($concat.cons.get(i));
							$concat.cons.get(i).addPin(pins.get(i));
						}
					}
				}
				
			// assignment is not a combine operation
			} else {
				for (Instance inst : insts) {
					if ($operand.indices == null) {
						pins.addAll(inst.getAllPins($operand.id.getText()));
						if (pins.size() == 0)
							bailOut($operand.id, "undeclared pin");
					} else {
						for (Integer i : $operand.indices) {
							Pin p = inst.getPin($operand.id.getText(), i);
							if (p == null)
								bailOut($operand.id, "undeclared pin or invalid pin index [" + i + "]");
							else
								pins.add(p);
						}
					}
					
					for (int i = 0; i < pins.size(); i++) {
					
						// check to see if the pin is already assigned
						if (pins.get(i).isAssigned()) {
							String index = (pins.get(i).hasIndex())?("index [" + pins.get(i).getIndex() + "]"):("pin");
							bailOut($operand.id, index + " is already assigned");
						} else if (pins.get(i).isOpen()) {
							String index = (pins.get(i).hasIndex())?("index [" + pins.get(i).getIndex() + "]"):("pin");
							bailOut($operand.id, index + " is already open");
							
						// assign the pin based on the flags
						} else if ($concat.isReplicated) {
							pins.get(i).setAssignment($concat.cons.get(0));
							$concat.cons.get(0).addPin(pins.get(i));
						} else if ($concat.isOpen) {
							pins.get(i).setOpen(true);
						} else {
							// check for width mismatch
							if (pins.size() != $concat.cons.size()) {
								bailOut($operand.id, "pin assignment left size [" + pins.size() + 
									"] does not match right size [" + $concat.cons.size() + "]");
							} else {
								pins.get(i).setAssignment($concat.cons.get(i));
								$concat.cons.get(i).addPin(pins.get(i));
							}
						}
					}
					// clear the list in preparation for the next instance's pins
					pins.clear();
				}
			}
		}
	;
	
subInstDecl[DesignUnit des]
	:	^(SUBINST_DECL width? instName=IDENT refPrefix=STRING? desName=IDENT

		{	SubDesign subDes = getSubDesign($desName.text);
			if (subDes == null)
				bailOut($instName, "subdesign " + $desName.text + " is undeclared");
			if ($width.indices == null || $width.indices.size() == 1) {
				SubInstance s = new SubInstance(des, subDes, $instName.text);
				setLocation(s, $instName);
				s.setRefPrefix($refPrefix.text);
				if ($width.indices != null)
					s.setIndex($width.indices.get(0));
				
				// check for duplicates
				if (!des.addSubInst(s))
					addError($instName, "duplicate subdesign instance declaration");
			
			} else {
				for (int i = 0; i < $width.indices.size(); i++) {
					SubInstance s = new SubInstance(des, subDes, $instName.text);
					setLocation(s, $instName);
					s.setRefPrefix($refPrefix.text);
					s.setIndex($width.indices.get(i));
					// check for duplicates
					if (!des.addSubInst(s))
						addError($instName, "duplicate subdesign instance declaration");
				}
			} 
		}
	
		(infoDecl
			{	List<SubInstance> subs = des.getSubInstances();
				if ($infoDecl.indices == null) {
					for (SubInstance s : subs)
						s.appendInfo($infoDecl.info.getText());
				} else {
					// iterate over the indices in the array list declaration
					for (Integer index : $infoDecl.indices) {
						// search for the instance with this index
						SubInstance s = null;
						for (SubInstance sub : subs)
							if (index == sub.getIndex()) 
								s = sub;
						
						if (s != null) {
							s.appendInfo($infoDecl.info.getText());
						// the instance referenced by the index doesn't exist
						} else
							addWarning($infoDecl.info, "subdesign instance index (" + index + 
								") does not exist for information declaration");
					}
				}
			}
		)* 
		
		{	// check for duplicates based solely on the raw instance name
			if (!instNames.add($instName.text))
				addError($instName, "duplicate instance name exists in design unit");
		}
	
		subAttrAssign[des, $instName]* 
		portAssign[des, $instName.text]*)
	;
	
subAttrAssign[DesignUnit des, CommonTree subInstName]
@init{
	boolean newAttr = false;
	List<name_return> ids = new ArrayList<name_return>();
}
	:	^(SUBATTR_ASSIGN (NEWATTR {newAttr = true;})? qualifier? (id=name {ids.add(id);})+ attrName=IDENT attrValue=STRING)
		{	Stack<name_return> names = new Stack<name_return>();
			for (int i = ids.size()-1; i >= 0; i--)
				names.push(ids.get(i));
		
			// gather the relevant subdesign instances in a list
			List<SubInstance> subInsts = new ArrayList<SubInstance>();
			if ($qualifier.indices == null) {
				for (SubInstance subInst : des.getSubInstancesByName(subInstName.getText()))
					subInsts.add(subInst);
			} else {
				for (Integer i : $qualifier.indices) {
					SubInstance subInst = des.getSubInstance(subInstName.getText(), i);
					if (subInst == null)
						bailOut($qualifier.name, "invalid subinstance qualifier index (" + i + ")");
					else
						subInsts.add(subInst);
				}
			}
			
			// call the recursive SubInstance attribute routine on each SubInstance
			for (SubInstance subInst : subInsts)
				subInstAttr(subInst, names, $attrName, $attrValue, newAttr);
		}
	; 	
	
portAssign[DesignUnit des, String subInstName]
@init{boolean isCombined = false;}
	:	^(PORT_ASSIGN (COMBINE {isCombined = true;})? qualifier? operand concat[des])
		
		{	// gather the relevant subdesign instances in a list
			List<SubInstance> subInsts = new ArrayList<SubInstance>();
			if ($qualifier.indices == null)
				subInsts.addAll(des.getSubInstancesByName(subInstName));
			else {
				for (Integer i : $qualifier.indices) {
					SubInstance subInst = des.getSubInstance(subInstName, i);
					if (subInst == null)
						bailOut($operand.id, "invalid instance qualifier index (" + i + ")");
					else
						subInsts.add(subInst);
				}
			}
			
			// list of ports to assign connections to
			List<Port> ports = new ArrayList<Port>();
			
			
			if (isCombined) {
				if ($operand.indices == null) {
					// get all possible instances
					for (SubInstance s : subInsts)
						ports.addAll(s.getAllPorts($operand.id.getText()));
					if (ports.size() == 0)
						bailOut($operand.id, "undeclared port");
				} else {
					// get only those instances with the indices in the list
					for (SubInstance s : subInsts) {
						for (Integer i : $operand.indices) {
							Port p = s.getPort($operand.id.getText(), i);
							if (p == null)
								bailOut($operand.id, "undeclared port or invalid port index [" + i + "]");
							else
								ports.add(p);
						}
					}
				}
				for (int i = 0; i < ports.size(); i++) {
					
					// remap the port location
					setLocation(ports.get(i), $operand.id);
					
					// check to see if the pin is already assigned
					if (ports.get(i).isAssigned()) {
						String index = (ports.get(i).hasIndex())?("index [" + ports.get(i).getIndex() + "]"):("port");
						bailOut($operand.id, index + " is already assigned");
					}
					
					// assign the port based on the flags
					if ($concat.isReplicated) {
						ports.get(i).setAssignment($concat.cons.get(0));
						$concat.cons.get(0).addConnection(ports.get(i));
					} else if ($concat.isOpen) {
						addWarning($operand.id, "open port will isolate design hierarchy");
					} else {
						// check for width mismatch
						if (ports.size() != $concat.cons.size()) {
							bailOut($operand.id, "port assignment left size [" + ports.size() + 
								"] does not match right size [" + $concat.cons.size() + "]");
						} else {
							ports.get(i).setAssignment($concat.cons.get(i));
							$concat.cons.get(i).addConnection(ports.get(i));
						}
					}
				}
			} else {
				for (SubInstance s : subInsts) {
					if ($operand.indices == null) {
						ports.addAll(s.getAllPorts($operand.id.getText()));
						if (ports.size() == 0)
							bailOut($operand.id, "undeclared port");
					} else {
						for (Integer i : $operand.indices) {
							Port p = s.getPort($operand.id.getText(), i);
							if (p == null)
								bailOut($operand.id, "undeclared port or invalid port index [" + i + "]");
							else
								ports.add(p);
						}
					}
					
					for (int i = 0; i < ports.size(); i++) {
						// remap the port location
						setLocation(ports.get(i), $operand.id);
						
						// check to see if the pin is already assigned
						if (ports.get(i).isAssigned()) {
							String index = (ports.get(i).hasIndex())?("index [" + ports.get(i).getIndex() + "]"):("port");
							bailOut($operand.id, index + " is already assigned");
						}
					
						// assign the port based on the flags
						if ($concat.isReplicated) {
							ports.get(i).setAssignment($concat.cons.get(0));
							$concat.cons.get(0).addConnection(ports.get(i));
						} else if ($concat.isOpen) {
							addWarning($operand.id, "open port will isolate design hierarchy");
						} else {
							// check for width mismatch
							if (ports.size() != $concat.cons.size()) {
								bailOut($operand.id, "port assignment left size [" + ports.size() + 
									"] does not match right size [" + $concat.cons.size() + "]");
							} else {
								ports.get(i).setAssignment($concat.cons.get(i));
								$concat.cons.get(i).addConnection(ports.get(i));
							}
						}
					}

					// clear the list in preparation for the next instance's ports
					ports.clear();
				}
			}
		}
	;
	
connectAssign[DesignUnit des]
	:	^(CONNECT_ASSIGN operand concat[des])
		
		{	if ($concat.isOpen)
				bailOut($operand.id, "connections cannot be open");
				
			// a list of connections on the left hand side
			List<Connection> cons = new ArrayList<Connection>();
			if ($operand.indices == null) {
				cons.addAll(des.getConnectionsByName($operand.id.getText()));
			} else {
				for (Integer i : $operand.indices) {
					Connection c = des.getConnection($operand.id.getText(), i);
					if (c == null)
						bailOut($operand.id, "undeclared connection or invalid index (" + i + ")");
					else
						cons.add(c);
				}
			}
			
			// check for assignment width mismatch
			if (cons.size() != $concat.cons.size()) {
				bailOut($operand.id, "assignment left size [" + cons.size() + 
					"] does not match right size [" + $concat.cons.size() + "]");
			}
			
			for (int i = 0; i < cons.size(); i++) {
				if ($concat.isReplicated) {
					cons.get(i).addConnection($concat.cons.get(0));
					$concat.cons.get(0).addConnection(cons.get(i));
				} else {
					cons.get(i).addConnection($concat.cons.get(i));
					$concat.cons.get(i).addConnection(cons.get(i));
				}
			}
		}
	;

/**
 * The concat rule looks for one of three subtree root nodes in the AST: CONCAT_LIST, CONCAT_REPL, and CONCAT_OPEN.  
 * The rule operates on a design object, and returns a list of nets in the design.  The returned list of nets preserves
 * the order that the nets are aligned on the right-hand side of any assignment operation.  Flags are set indicating the special
 * cases of a single replicated net, or an open pin or port assignment.  If the CONCAT_LIST option is taken, the rule will
 * return a list of nets corresponding to all nets on the right-hand side of the assignment.  If the CONCAT_REPL option is
 * taken, the rule will return a list with only one net inside, and set the replicated flag.  If the CONCAT_OPEN option is 
 * taken, the returned list is empty and the open flag is set.
 */	
concat[DesignUnit des] returns [List<Connection> cons, boolean isReplicated, boolean isOpen]
@init{$cons = new ArrayList<Connection>();}

	:	^(CONCAT_LIST (operand
	
			{	// for each operand, if no indices were specified, return all relevant connections from the design
				if ($operand.indices == null) {
					List<Connection> connects = des.getConnectionsByName($operand.id.getText());
					if (connects.size() == 0)
						bailOut($operand.id, "undeclared connection");
					$cons.addAll(connects);
				
				// otherwise, only return connections with matching indices
				} else {
					for (int i = 0; i < $operand.indices.size(); i++) {
						Connection c = des.getConnection($operand.id.getText(), $operand.indices.get(i));
						if (c == null) {
							if (des.getConnectionsByName($operand.id.getText()).size() > 0)
								bailOut($operand.id, "invalid connection index [" + $operand.indices.get(i) + "]");
							else
								bailOut($operand.id, "undeclared connection");
						} else
							$cons.add(c);
					}
				}
			}
		)*)

	|	^(CONCAT_REPL operand
	
			{	$isReplicated = true;
				
				// if no indices were specified, return the relevant connection from the design
				if ($operand.indices == null) {
					List<Connection> cons = des.getConnectionsByName($operand.id.getText());
					if (cons.size() == 0)
						bailOut($operand.id, "undeclared connection");
					if (cons.size() > 1)
						bailOut($operand.id, "assignment cannot replicate a an arrayed connection");
					$cons.add(cons.get(0));
					
				// otherwise, return the connection with the matching index
				} else {
					if ($operand.indices.size() != 1)
						bailOut($operand.id, "assignment cannot replicate an arrayed connection");
					Connection c = des.getConnection($operand.id.getText(), $operand.indices.get(0));
					if (c == null) {
						if (des.getConnectionsByName($operand.id.getText()).size() > 0)
							bailOut($operand.id, "invalid connection slice [" + $operand.indices.get(0) + "]");
						else	
							bailOut($operand.id, "undeclared connection");
					} else
						$cons.add(c);
				}
			}
		)
		
	|	^(CONCAT_OPEN {$isOpen = true;})
	;

/**
 * The operand rule looks for a subtree rooted in an OPERAND node with descendents id, and index.
 */
operand returns [CommonTree id, List<Integer> indices]
	:	^(OPERAND val=IDENT {$id = $val;} (index {$indices = $index.indices;})?)
	;

/**
 * The name rule looks for a subtree rooted in an NAME node with descendents id, and index.
 */
name returns [CommonTree id, List<Integer> indices]
	:	^(NAME val=IDENT {$id = $val;} (index {$indices = $index.indices;})?)
	;

qualifier returns [List<Integer> indices, CommonTree name]
	:	^(keyword=THIS index?)
		{	$name = $keyword;
			$indices = $index.indices;
		}
	;

/**
 * The index rule looks for a subtree rooted in either a BOUNDS or INDICES node.  It returns a list
 * populated with all appropriate indices either specified by a mininum and maximum value (the bounds)
 * or the original individual indices in the same order that they exist in the tree.
 */
index returns [List<Integer> indices]
@init{$indices = new ArrayList<Integer>();}
	:	^(BOUNDS hi=INT lo=INT)
			{	int msb = Integer.parseInt($hi.text);
				int lsb = Integer.parseInt($lo.text);
				if (msb < lsb)
					for (int i = msb; i <= lsb; i++)
						$indices.add(i);
				else
					for (int i = msb; i >= lsb; i--)
						$indices.add(i);
			}
	|	^(INDICES (idx=INT 
			{	if ($indices.contains(Integer.parseInt($idx.text)))
					bailOut($idx, "duplicate index");
				else
					$indices.add(Integer.parseInt($idx.text));
			}
		)+)
	;
	
width returns [List<Integer> indices]
@init{$indices = new ArrayList<Integer>();}
	:	^(WIDTH hi=INT lo=INT)
		{	int msb = Integer.parseInt($hi.text);
			int lsb = Integer.parseInt($lo.text);
			if (msb < lsb)
				for (int i = msb; i <= lsb; i++)
					$indices.add(i);
			else
				for (int i = msb; i >= lsb; i--)
					$indices.add(i);
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
	
infoDecl returns [CommonTree name, CommonTree info, List<Integer> indices]
	: 	^(INFO_DECL qualifier? 	
		{	
			$indices = $qualifier.indices;
			$name = $qualifier.name;
		}
		(string=STRING 				{$info = $string;})+)
	;
	