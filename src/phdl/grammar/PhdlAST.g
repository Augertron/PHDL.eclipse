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
	
	/** The list of errors */
	private List<String> errors = new ArrayList<String>();
	
	/** The list of warnings */
	private List<String> warnings = new ArrayList<String>();
	
	/** The set of all Devices is global to the project build */
	private Set<Device> devices = new HashSet<Device>();
	
	/** The top level design */
	private	Design topDesign;
	
	/** The set of subDesigns */
	private Set<SubDesign> subDesigns = new HashSet<SubDesign>();
	
	/** Sets to check for duplicates while processing everything */
	private Set<String> pinNames = new HashSet<String>();
	private Set<String> netNames = new HashSet<String>();
	private Set<String> portNames = new HashSet<String>();
	
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
	
	public void setTopDesign(Design des) {
		this.topDesign = des;
	}
	
	public Set<SubDesign> getSubDesigns() {
		return subDesigns;
	}
	
	public void setSubDesigns(Set<SubDesign> subDesigns) {
		this.subDesigns = subDesigns;
	}
	
	public SubDesign getSubDesignByName(String name) {
		for (SubDesign s : subDesigns) {
			if (s.getName().equals(name))
				return s;
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
	
		(infoDecl 	{dev.appendInfo($infoDecl.info.getText());})* 
		
		attrDecl[devs]* pinDecl[dev]* )
	;
	
attrDecl[List<Attributable> parents]
	:	^(ATTR_DECL attrName=IDENT attrValue=STRING)
	
		{	for (Attributable parent : parents) {
				// make a new attribute node
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
	:	^(PIN_DECL pinName=IDENT pinType width? pinList)
		
		{	// make a single pin if there is no width
			if ($width.indices == null || $width.indices.size() == 1) {
				if ($pinList.list.size() != 1)
					addError($pinName, "invalid pin list");
				Pin p = new Pin(dev);
				p.setName($pinName.text);
				p.setPinType($pinType.type);
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
					Pin p = new Pin(dev);
					p.setName($pinName.text);
					p.setPinType($pinType.type);
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
			if ($desKeyword != null) 	des = new Design();
			else 							des = new SubDesign();
			des.setName($desName.text);
			setLocation(des, $desName);
			if ($desKeyword != null) {
				if (topDesign == null)		topDesign = (Design) des;
				else						bailOut($desName, "duplicate top level design");
			} else
											subDesigns.add((SubDesign)des);
				
			// sets check for duplicate names within the scope of a design.
			netNames.clear();
			portNames.clear();
			instNames.clear();
		}
		
	(	netDecl[des]
	|	instDecl[des, null]
	|	netAssign[des]
	|	groupDecl[des]
	|	subInstDecl[des]
	|	portDecl[des] 
	|	(infoDecl
			{	// append the info to the design
				if ($infoDecl.indices != null)
					addError($infoDecl.info, "info in design cannot be qualified with an index");
				else
					des.appendInfo($infoDecl.info.getText());
			}
		)
	)*))
	;
	
subInstDecl[DesignUnit des]
	:	^(SUBINST_DECL width? instName=IDENT desName=IDENT 
	
		{	SubDesign subDes = getSubDesignByName($desName.text);
			if (subDes == null)
				bailOut($instName, "subdesign " + $desName.text + " is undeclared");
			if ($width.indices == null || $width.indices.size() == 1) {
				SubInstance s = new SubInstance(subDes);
				s.setName($instName.text);
				s.setDesign(subDes);
				setLocation(s, $instName);
				if ($width.indices != null)
					s.setIndex($width.indices.get(0));
				
				// check for duplicates
				if (!des.addSubInst(s))
					addError($instName, "duplicate subdesign instance declaration");
			
			} else {
				for (int j = 0; j < $width.indices.size(); j ++) {
					SubInstance s = new SubInstance(subDes);
					s.setName($instName.text);
					s.setDesign(subDes);
					setLocation(s, $instName);
					s.setIndex($width.indices.get(j));
	
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
	
		subAttrAssign* portAssign[des, $instName.text]*)
		
		{	// check for duplicates based solely on the raw instance name
			if (!instNames.add($instName.text))
				addError($instName, "duplicate instance name exists in design unit");
		}

	;
	
subAttrAssign
	:	^(SUBATTR_ASSIGN NEWATTR? index? name* IDENT STRING)
	; 	
portAssign[DesignUnit des, String subInstName]
@init{boolean isCombined = false;}
	:	^(CONNECT_ASSIGN (COMBINE {isCombined = true;})? index? operand concatenation[des])
		
		{	// check for duplicate qualifier indices
			Set<Integer> indices = new HashSet<Integer>();
			if ($index.indices != null) {
				for (Integer i : $index.indices)
					if (!indices.add(i))
						bailOut($operand.id, "duplicate instance qualifier index");
			}

			// gather the relevant subdesign instances in a list
			List<SubInstance> subInsts = new ArrayList<SubInstance>();
			if ($index.indices == null) {
				for (SubInstance subInst : des.getSubInstancesByName(subInstName))
					subInsts.add(subInst);
			} else {
				for (Integer i : $index.indices) {
					SubInstance subInst = des.getSubInstance(subInstName, i);
					if (subInst == null)
						bailOut($operand.id, "invalid instance qualifier index (" + i + ")");
					else
						subInsts.add(subInst);
				}
			}
			
			
		}
	;
	
groupDecl[DesignUnit des]
	:	^(GROUP_DECL groupName=STRING 
	(	infoDecl
	|	portDecl[des]
	|	netDecl[des]
	|	instDecl[des, $groupName.text]
	|	netAssign[des]
	)*)
	;
	
portDecl[DesignUnit subDes]
	:	^(PORT_DECL width? (portName=IDENT
		{	if (subDes instanceof Design)
				bailOut($portName, "ports are only allowed in subdesigns");
			if ($width.indices == null || $width.indices.size() == 1) {
				Port p = new Port(subDes);
				p.setName($portName.text);
				setLocation(p, $portName);
				if ($width.indices != null)
					p.setIndex($width.indices.get(0));
				if(!subDes.addPort(p));
					addError($portName, "duplicate port declaration");
			} else {
				for (int i = 0; i < $width.indices.size(); i++) {
					Port p = new Port(subDes);
					p.setName($portName.text);
					p.setIndex($width.indices.get(i));
					if (!subDes.addPort(p))
						addError($portName, "duplicate port declaration");
				}
			}
			// check for duplicates based soley on the name of the port
			if (!portNames.add($portName.text))
				addError($portName, "duplicate port declaration");
		}
		)*)
	;
	
netDecl[DesignUnit des]
@init{List<Attributable> nets = new ArrayList<Attributable>();}
	:	^(NET_DECL width? (netName=IDENT
		
			{	// make new nets for each name
				if ($width.indices == null || $width.indices.size() == 1) {
					Net n = new Net(des);
					n.setName($netName.text);
					setLocation(n, $netName);
					if ($width.indices != null)
						n.setIndex($width.indices.get(0));
					if (!des.addNet(n)) 
						addError($netName, "duplicate net declaration");
					nets.add(n);
				} else {
					for (int i = 0; i < $width.indices.size(); i++) {
						Net n = new Net(des);
						n.setName($netName.text);
						n.setIndex($width.indices.get(i));
						if (!des.addNet(n))
							addError($netName, "duplicate net declaration");
						nets.add(n);
					}
				}	
					
				// check for duplicates based soley on the name of the net
				if (!netNames.add($netName.text))
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
				Instance i = new Instance(des);
				i.setName($instName.text);
				i.setDevice(dev);
				setLocation(i, $instName);
				i.setGroupName(groupName);
				if ($width.indices != null)
					i.setIndex($width.indices.get(0));
				// copy all of the attribute and pin nodes from the device
				for (Attribute a: dev.getAttributes())
					i.addAttribute(new Attribute(a, i));
				for (Pin p: dev.getPins())
					i.addPin(new Pin(p, i));
				// check for duplicates
				if (!des.addInstance(i))
					addError($instName, "duplicate instance declaration");
			
			} else {
				for (int j = 0; j < $width.indices.size(); j ++) {
					Instance i = new Instance(des);
					i.setName($instName.text);
					i.setDevice(dev);
					setLocation(i, $instName);
					i.setGroupName(groupName);
					i.setIndex($width.indices.get(j));
					// copy all of the attribute and pin nodes from the device
					for (Attribute a: dev.getAttributes())
						i.addAttribute(new Attribute(a, i));
					for (Pin p: dev.getPins())
						i.addPin(new Pin(p, i));
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
						i.appendInfo($infoDecl.info.getText());
				} else {
					// iterate over the indices in the array list declaration
					for (Integer index : $infoDecl.indices) {
						// search for the instance with this index
						Instance i = null;
						for (Instance inst : insts)
							if (index == inst.getIndex()) 
								i = inst;
						
						if (i != null) {
							i.appendInfo($infoDecl.info.getText());
						// the instance referenced by the index doesn't exist
						} else
							addWarning($infoDecl.info, "instance index (" + index + ") does not exist");
					}
				}
			}
		)*
		
		attrAssign[des, $instName.text]* pinAssign[des, $instName.text]*)
		
		{	// check for duplicates based solely on the raw instance name
			if (!instNames.add($instName.text))
				addError($instName, "duplicate instance name exists in design unit");
		}
	;
	
attrAssign[DesignUnit des, String instName]
@init{boolean newAttr = false;}
	:	^(ATTR_ASSIGN (NEWATTR {newAttr = true;})? index? attrName=IDENT attrValue=STRING)
		{	
			// a list of all candidate instances from the design
			List<Instance> insts = des.getInstancesByName(instName);
			
			// process all instances (global attribute)
			if ($index.indices == null) {
				for (Instance i : insts) {
					Attribute a = i.getAttribute($attrName.text);
					if (a != null) {
						if (newAttr)
							addError($attrName, "new attribute already declared");
						if (!a.overwrite($attrValue.text))
							addWarning($attrName, "attribute already overwritten");
					} else if (newAttr) {
						Attribute newA = new Attribute(i);
						newA.setName($attrName.text);
						newA.setValue($attrValue.text);
						setLocation(newA, $attrName);
						i.addAttribute(newA);
					} else
						addError($attrName, "undeclared attribute");
				}
			} else {
				// iterate over the indices in the array list declaration
				for (Integer index : $index.indices) {
					// search for the instance with this index
					Instance inst = null;
					for (Instance i : insts)
						if (index == i.getIndex()) 
							inst = i;
					
					if (inst != null) {
						Attribute a = inst.getAttribute($attrName.text);
						if (a != null) {
							if (newAttr)
								addError($attrName, "new attribute already declared");
							if (!a.overwrite($attrValue.text))
								addWarning($attrName, "attribute already overwritten");
						} else if (newAttr) {
							Attribute newA = new Attribute(inst);
							newA.setName($attrName.text);
							newA.setValue($attrValue.text);
							setLocation(newA, $attrName);
							inst.addAttribute(newA);
						} else
							addError($attrName, "undeclared attribute");
					// the instance referenced by the index doesn't exist
					} else
						addError($attrName, "instance index (" + index + ") does not exist for attribute");
				}
			}
		}
	;
	
pinAssign[DesignUnit des, String instName]
@init{boolean isCombined = false;}
	:	^(CONNECT_ASSIGN (COMBINE {isCombined = true;})? index? operand concatenation[des])
		{	
			// check for duplicate qualifier indices
			Set<Integer> indices = new HashSet<Integer>();
			if ($index.indices != null) {
				for (Integer i : $index.indices)
					if (!indices.add(i))
						bailOut($operand.id, "duplicate instance qualifier index");
			}

			// gather the relevant instances in a list
			List<Instance> insts = new ArrayList<Instance>();
			if ($index.indices == null) {
				for (Instance inst : des.getInstancesByName(instName))
					insts.add(inst);
			} else {
				for (Integer i : $index.indices) {
					Instance inst = des.getInstance(instName, i);
					if (inst == null)
						bailOut($operand.id, "invalid instance qualifier index (" + i + ")");
					else
						insts.add(inst);
				}
			}
			
			// list of pins to assign nets to
			List<Pin> pins = new ArrayList<Pin>();
			
			if (isCombined) {
				if ($operand.indices == null) {
					for (Instance inst : insts)
						pins.addAll(inst.getAllPins($operand.id.getText()));
					if (pins.size() == 0)
						bailOut($operand.id, "undeclared pin");
				} else {
					for (Instance inst : insts) {
						for (Integer i : $operand.indices) {
							Pin p = inst.getPin($operand.id.getText(), i);
							if (p == null)
								bailOut($operand.id, "undeclared pin or invalid pin slice [" + i + "]");
							else
								pins.add(p);
						}
					}
				}

				for (int i = 0; i < pins.size(); i++) {
					if (pins.get(i).hasNet()) {
						String index = (pins.get(i).getIndex() == -1)?("pin"):("slice [" + pins.get(i).getIndex() + "] of pin");
						bailOut($operand.id, index + " is already assigned");
					} else if (pins.get(i).isOpen()) {
						String index = (pins.get(i).getIndex() == -1)?("pin"):("slice [" + pins.get(i).getIndex() + "] of pin");
						bailOut($operand.id, index + " is already open");
					} else if ($concatenation.isReplicated) {
						pins.get(i).setNet($concatenation.nets.get(0));
						$concatenation.nets.get(0).addPin(pins.get(i));
					} else if ($concatenation.isOpen) {
						pins.get(i).setOpen(true);
					} else {
						// check for width mismatch
						if (pins.size() != $concatenation.nets.size()) {
							bailOut($operand.id, "pin assignment left size [" + pins.size() + 
								"] does not match right size [" + $concatenation.nets.size() + "]");
						}	
						pins.get(i).setNet($concatenation.nets.get(i));
						$concatenation.nets.get(i).addPin(pins.get(i));
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
								bailOut($operand.id, "undeclared pin or invalid pin slice [" + i + "]");
							else
								pins.add(p);
						}
					}
					
					for (int i = 0; i < pins.size(); i++) {
						if (pins.get(i).hasNet()) {
							String index = (pins.get(i).getIndex() == -1)?("pin"):("slice [" + pins.get(i).getIndex() + "] of pin");
							bailOut($operand.id, index + " is already assigned");
						} else if (pins.get(i).isOpen()) {
							String index = (pins.get(i).getIndex() == -1)?("pin"):("slice [" + pins.get(i).getIndex() + "] of pin");
							bailOut($operand.id, index + " is already open");
						} else if ($concatenation.isReplicated) {
							pins.get(i).setNet($concatenation.nets.get(0));
							$concatenation.nets.get(0).addPin(pins.get(i));
						} else if ($concatenation.isOpen) {
							pins.get(i).setOpen(true);
						} else {
							// check for width mismatch
							if (pins.size() != $concatenation.nets.size()) {
								bailOut($operand.id, "pin assignment left size [" + pins.size() + 
									"] does not match right size [" + $concatenation.nets.size() + "]");
							}	
							pins.get(i).setNet($concatenation.nets.get(i));
							$concatenation.nets.get(i).addPin(pins.get(i));
						}
					}
					// clear the list in preparation for the next instance's pins
					pins.clear();
				}
			}
		}
	;
	
netAssign[DesignUnit des]
	:	^(NET_ASSIGN operand concatenation[des])
		
		{	if ($concatenation.isOpen)
				bailOut($operand.id, "nets cannot be open");
				
			List<Net> nets = new ArrayList<Net>();
			if ($operand.indices == null) {
				nets.addAll(des.getAllNetsByName($operand.id.getText()));
			} else {
				for (Integer i : $operand.indices) {
					Net n = des.getNet($operand.id.getText(), i);
					if (n == null)
						bailOut($operand.id, "undeclared net or invalid net index (" + i + ")");
					else
						nets.add(n);
				}
			}
			
			
			for (int i = 0; i < nets.size(); i++) {
				if ($concatenation.isReplicated) {
					nets.get(i).addNet($concatenation.nets.get(0));
					$concatenation.nets.get(0).addNet(nets.get(i));
				} else {
					// check for assignment width mismatch
					if (nets.size() != $concatenation.nets.size()) {
						bailOut($operand.id, "net assignment left size [" + nets.size() + 
							"] does not match right size [" + $concatenation.nets.size() + "]");
					}
					nets.get(i).addNet($concatenation.nets.get(i));
					$concatenation.nets.get(i).addNet(nets.get(i));
				}
			}
		}
	;

/**
 * The concatenation rule looks for one of three subtree root nodes in the AST: CONCAT_LIST, CONCAT_REPL, and CONCAT_OPEN.  
 * The rule operates on a design object, and returns a list of nets in the design.  The returned list of nets preserves
 * the order that the nets are aligned on the right-hand side of any assignment operation.  Flags are set indicating the special
 * cases of a single replicated net, or an open pin or port assignment.  If the CONCAT_LIST option is taken, the rule will
 * return a list of nets corresponding to all nets on the right-hand side of the assignment.  If the CONCAT_REPL option is
 * taken, the rule will return a list with only one net inside, and set the replicated flag.  If the CONCAT_OPEN option is 
 * taken, the returned list is empty and the open flag is set.
 */	
concatenation[DesignUnit des] returns [List<Net> nets, boolean isReplicated, boolean isOpen]
@init{$nets = new ArrayList<Net>();}

	:	^(CONCAT_LIST (operand
	
			{	// for each operand, if no indices were specified, return all relevant nets from the design
				if ($operand.indices == null) {
					$nets.addAll(des.getAllNetsByName($operand.id.getText()));
				
				// otherwise, only return nets with matching indices
				} else
					for (int i = 0; i < $operand.indices.size(); i++) {
						Net n = des.getNet($operand.id.getText(), $operand.indices.get(i));
						if (n == null) {
							if (des.getAllNetsByName($operand.id.getText()).size() > 0)
								bailOut($operand.id, "invalid net slice [" + $operand.indices.get(i) + "]");
							else
								bailOut($operand.id, "undeclared ned");
						} else
							$nets.add(n);
					}
			}
		)*)

	|	^(CONCAT_REPL operand
	
			{	$isReplicated = true;
				
				// if no indices were specified, return the relevant net from the design
				if ($operand.indices == null) {
					List<Net> nets = des.getAllNetsByName($operand.id.getText());
					if (nets.size() > 1)
						bailOut($operand.id, "assignment cannot replicate a net vector");
					$nets.add(nets.get(0));
					
				// otherwise, return the net with the matching index
				} else {
					if ($operand.indices.size() != 1)
						bailOut($operand.id, "assignment cannot replicate a net vector");
					Net n = des.getNet($operand.id.getText(), $operand.indices.get(0));
					if (n == null) {
						if (des.getAllNetsByName($operand.id.getText()).size() > 0)
							bailOut($operand.id, "invalid net slice [" + $operand.indices.get(0) + "]");
						else	
							bailOut($operand.id, "undeclared net");
					} else
						$nets.add(n);
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
	|	^(INDICES (idx=INT {$indices.add(Integer.parseInt($idx.text));})+)
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
	
infoDecl returns [CommonTree info, List<Integer> indices]
	: 	^(INFO_DECL index? 	{$indices = $index.indices;}
		(st=STRING 			{$info = $st;})+)
	;