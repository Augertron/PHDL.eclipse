package phdl.analyzer;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import phdl.PhdlComp;
import phdl.parser.AttrAssign;
import phdl.parser.AttrDecl;
import phdl.parser.DesignDecl;
import phdl.parser.DeviceDecl;
import phdl.parser.InstDecl;
import phdl.parser.Parsable;
import phdl.parser.PinAssign;
import phdl.parser.PinDecl;

public class BradAnalyzer {

	private Set<String> errors;
	private Set<String> warnings;
	private DesignDecl design;

	public BradAnalyzer(DesignDecl design) {
		this.design = design;
		this.errors = new HashSet<String>();
		this.warnings = new HashSet<String>();
	}

	public void Analyze() {

		processDeviceDecls(design);
		processNetDecls(design);
		processInstDecls(design);
		// processNetAssigns(d.getDesignDeclaration());

		// TODO if errors by this point, throw exception

		// TODO make a new graph out of all pin, port and net assignments
		// and assign to design node

		// d.createInitialNetGraph();

	}

	private void processDeviceDecls(DesignDecl des) {
		// required attributes are stored in the compiler
		String[] reqAttrs = PhdlComp.reqAttr;

		for (DeviceDecl d : des.getDeviceDecls()) {
			// check all required attributes are declared in each device
			for (int i = 0; i < reqAttrs.length; i++) {
				if (d.findAttrDecl(reqAttrs[i]) == null) {
					String message = "required " + reqAttrs[i].toLowerCase()
							+ " attribute missing";
					addError(d, message);
				}
			}

			// check all attributes are declared correctly
			for (AttrDecl a : d.getAttrDecls()) {

				// check that attribute refPrefix value only contains letters
				if (a.getName().equals("REFPREFIX")) {
					if (!a.getValue().matches("^[A-Z]+$"))
						addError(a, "invalid refprefix declaration");
				}
			}

			Set<String> pinNumbers = new HashSet<String>();
			// check all pins numbers are declared independently
			for (PinDecl p : d.getPinDecls()) {
				for (Integer i : p.getPinMap().keySet()) {
					if (!pinNumbers.add(p.getPinMap().get(i)))
						addError(p, "duplicate pin list number");
				}
			}
		}
	}

	private void processNetDecls(DesignDecl d) {
		// we may need to eventually do something in here
	}

	private void processInstDecls(DesignDecl design) {

		// Set of names to check for duplicates
		Set<String> names = new HashSet<String>();

		for (InstDecl i : design.getInstDecls()) {

			DeviceDecl d = design.findDevDecl(i.getRefName());
			if (d == null) {
				addError(i, "instance references undeclared device");
			} else {
				// check for duplicates
				if (i.isArrayed()) {
					for (Integer j : i.getIndices()) {
						if (!names.add(i.getName() + "%" + j))
							addError(i, "duplicate instance declaration");
					}
				} else {
					if (!names.add(i.getName())) {
						addError(i, "duplicate instance declaration");
					}
				}
				// check all attributes and pins are assigned correctly
				processAttrAssigns(i, d);
				processPinAssigns(i, d);
			}
		}
	}

	private void processAttrAssigns(InstDecl i, DeviceDecl d) {

		// Sets of names and refDesValues to check for duplicates
		Set<String> names = new HashSet<String>();
		Set<String> refDesValues = new HashSet<String>();

		for (AttrAssign a : i.getAttrAssigns()) {

			// check attribute array against instance bounds
			if (a.getIndices().size() != 0) {
				for (Integer s : a.getIndices()) {
					if (!i.isValidIndex(s))
						addError(a, "array reference outside instance bounds");
					// add the attribute name to the set with slice appended
					if (!names.add(a.getName() + s))
						addError(a, "duplicate attribute assignment");
				}
			} else {
				// the attribute applies across the entire instance width
				if (i.isArrayed()) {
					a.setArrayString(i.getMsb() + ":" + i.getLsb());
					a.makeIndices();
					for (Integer s : a.getIndices()) {
						if (!names.add(a.getName() + s)) {
							addError(a, "duplicate attribute assignment");
						}
					}
					// the attribute and instance array are singular
				} else {
					if (!names.add(a.getName())) {
						addError(a, "duplicate attribute assignment");
					}
				}
			}

			if (a.getName().equals("REFDES")) {
				// for all REFDES attribute assignments
				if (!refDesValues.add(a.getValue()))
					addError(a, "duplicate refdes constraint");

				if (a.getArrayWidth() != 1)
					addError(a,
							"refdes cannot be assigned to multiple instances");

				AttrDecl ad = d.findAttrDecl("REFPREFIX");
				if (ad != null) {
					String refDes = a.getValue();
					String refPrefix = ad.getValue();
					// check refDes constraint starts with refPrefix
					if (!refDes.startsWith(refPrefix))
						addError(a, "invalid refdes constraint");
				}
			} else {
				// check for any undeclared attributes
				if (d.findAttrDecl(a.getName()) == null)
					addError(a, "attribute undeclared in referenced device");
			}
		}
	}

	private void processPinAssigns(InstDecl i, DeviceDecl d) {

		// set of pin names to check for duplicates
		SortedSet<String> names = new TreeSet<String>();
		SortedSet<String> assignedPins = new TreeSet<String>();
		SortedSet<String> declaredPins = new TreeSet<String>();

		for (PinAssign p : i.getPinAssigns()) {

			// check for any undeclared pins
			if (d.findPinDecl(p.getName()) == null) {
				addError(p, "pin undeclared in referenced device");
			}

			// check pin arrays against instance bounds
			if (p.getIndices().size() != 0) {
				for (Integer s : p.getIndices()) {
					if (!i.isValidIndex(s))
						addError(p, "array reference outside instance bounds");
					// add the attribute name to the set with slice appended
					if (!names.add(p.getName() + s))
						addError(p, "duplicate pin assignment");
				}
			} else {
				// the pin assignment applies across the entire instance width
				if (i.isArrayed()) {
					p.setArrayString(i.getMsb() + ":" + i.getLsb());
					p.makeIndices();
					for (Integer s : p.getIndices()) {
						if (!names.add(p.getName() + s)) {
							addError(p, "duplicate pin assignment");
						}
					}
					// the pin and instance array are singular
				} else {
					if (p.isSliced()) {
						for (Integer s : p.getBits()) {
							if (!names.add(p.getName() + s))
								addError(p, "duplicate pin assignment");
						}
					} else {
						if (!names.add(p.getName()))
							addError(p, "duplicate pin assignment");
					}
				}
			}

			// TODO check for valid pin slices

			if (i.isArrayed()) {
				if (p.isReferenced()) {
					if (p.isSliced()) {
						// arrayed, referenced, and sliced
						for (Integer x : p.getIndices()) {
							for (Integer y : p.getBits())
								assignedPins.add(p.getName() + "(" + x + ")["
										+ y + "]");
						}
					} else {
						if (d.findPinDecl(p.getName()).isSliced()) {
							// arrayed, referenced, not sliced
							for (Integer x : p.getIndices()) {
								for (Integer y : d.findPinDecl(p.getName())
										.getBits())
									assignedPins.add(p.getName() + "(" + x
											+ ")[" + y + "]");
							}
						} else {
							for (Integer x : p.getIndices())
								assignedPins.add(p.getName() + "(" + x + ")");
						}
					}
				} else {
					if (p.isSliced()) {
						// arrayed, not referenced, sliced
						for (Integer x : i.getIndices()) {
							for (Integer y : p.getBits())
								assignedPins.add(p.getName() + "(" + x + ")["
										+ y + "]");
						}
					} else {
						// arrayed, not referenced, not sliced
						if (d.findPinDecl(p.getName()).isSliced()) {
							for (Integer x : i.getIndices()) {
								for (Integer y : d.findPinDecl(p.getName())
										.getBits())
									assignedPins.add(p.getName() + "(" + x
											+ ")[" + y + "]");
							}
						} else {
							for (Integer x : i.getIndices()) {
								assignedPins.add(p.getName() + "(" + x + ")");
							}
						}
					}
				}

			} else {
				if (p.isReferenced()) {
					// not arrayed but referenced
					addError(p,
							"arrayed pin assignment invalid for singular instance");
				} else {
					if (p.isSliced()) {
						// not arrayed, not referenced, sliced
						for (Integer y : p.getBits())
							assignedPins.add(p.getName() + "[" + y + "]");
					} else {
						// not arrayed, not referenced, not sliced
						if (d.findPinDecl(p.getName()).isSliced()) {
							for (Integer y : d.findPinDecl(p.getName())
									.getBits()) {
								assignedPins.add(p.getName() + "[" + y + "]");
							}
						} else {
							assignedPins.add(p.getName());
						}
					}
				}
			}

			// TODO check all concatenations

		}

		System.out.println(i.getName());
		// for debugging
		for (String s : assignedPins) {
			System.out.println(s);
		}
		System.out.println();

		// build the set of all possible instanced pins
		for (PinDecl pd : d.getPinDecls()) {
			if (i.isArrayed()) {
				if (pd.isSliced()) {
					for (Integer x : i.getIndices()) {
						for (Integer y : pd.getBits())
							declaredPins.add(pd.getName() + "(" + x + ")[" + y
									+ "]");
					}
				} else {
					for (Integer x : i.getIndices()) {
						declaredPins.add(pd.getName() + "(" + x + ")");
					}
				}

			} else {
				if (pd.isSliced()) {
					for (Integer y : pd.getBits()) {
						declaredPins.add(pd.getName() + "[" + y + "]");
					}
				} else {
					declaredPins.add(pd.getName());
				}

			}
		}

		// for debugging
		for (String s : declaredPins) {
			System.out.println(s);
		}
		System.out.println();

		// subtract the assigned pins set from the declared pins set
		for (String s : assignedPins) {
			declaredPins.remove(s);
		}

		// notify which pins are dangling
		if (!declaredPins.isEmpty()) {
			for (String s : declaredPins) {
				addError(i, "pin " + s + " is dangling");
			}
		}

	}

	private void processNetAssigns(DesignDecl d) {
		// TODO Auto-generated method stub

	}

	public Set<String> getErrors() {
		return errors;
	}

	public void addError(Parsable p, String msg) {
		errors.add(p.getFileName() + " line " + p.getLocation() + " " + msg
				+ ": " + p.getName());
	}

	public Set<String> getWarnings() {
		return warnings;
	}

	public void AddWarning(Parsable p, String msg) {
		warnings.add(p.getFileName() + " line " + p.getLocation() + " " + msg
				+ ": " + p.getName());
	}
}
