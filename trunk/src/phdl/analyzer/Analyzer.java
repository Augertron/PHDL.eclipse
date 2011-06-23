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

package phdl.analyzer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import phdl.PhdlComp;
import phdl.exception.InvalidWidthException;
import phdl.parser.AttributeAssignment;
import phdl.parser.AttributeDeclaration;
import phdl.parser.DesignDeclaration;
import phdl.parser.DeviceDeclaration;
import phdl.parser.InstanceDeclaration;
import phdl.parser.Parsable;
import phdl.parser.PinAssignment;
import phdl.parser.PinDeclaration;

public class Analyzer {

	/**
	 * A list of errors to accumulate during the analyzer process
	 */
	private Set<String> errors;
	private ArrayList<DesignDeclaration> designs;

	private DesignHierarchy dh;
	private Set<Device> devices;
	private Set<Instance> instances;
	private Set<NetNode> nets;
	private Graph netgraph;

	/**
	 * Default constructor
	 * 
	 * @param dh
	 *            The design hierarchy to analyze
	 */
	public Analyzer(DesignHierarchy dh) {
		this.dh = dh;
		this.errors = new HashSet<String>();
	}

	/**
	 * The main analyzer method is called on the analyzer object created from
	 * the design hierarchy.
	 * 
	 * It then builds a graph for each design node in the hierarchy from all of
	 * the pin, port, and net assignments.
	 */
	public void Analyze() {
		for (DesignNode d : dh.getBFSNodes()) {

			checkDeviceDecls(d.getDesignDeclaration());
			checkInstanceDecls(d.getDesignDeclaration());
			checkNetAssigns(d.getDesignDeclaration());

			// TODO if errors by this point, throw exception

			// TODO make a new graph out of all pin, port and net assignments
			// and assign to design node

			try {
				d.createInitialNetGraph();
			} catch (InvalidWidthException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private void checkDeviceDecls(DesignDeclaration des) {
		// obtain required attributes that all device declarations must have
		String[] reqAttr = PhdlComp.reqAttr;

		for (DeviceDeclaration dev : des.getDeviceDecls()) {

			// check that each required attribute is declared in each device
			for (int i = 0; i < reqAttr.length; i++) {
				if (dev.findAttrDecl(reqAttr[i]) == null) {
					String message = "required " + reqAttr[i].toLowerCase()
							+ " attribute missing";
					addError(dev, message);
				}
			}

			// check all attributes and pins are declared correctly
			checkAttrDecls(dev);
			checkPinDecls(dev);
		}
	}

	private void checkAttrDecls(DeviceDeclaration d) {

		for (AttributeDeclaration a : d.getAttributeDecls()) {

			// check that attribute refPrefix value only contains letters
			if (a.getName().equals("REFPREFIX")) {
				if (!a.getValue().matches("^[A-Z]+$")) {
					addError(a, "invalid refprefix declaration");
				}
			}
		}
	}

	private void checkPinDecls(DeviceDeclaration d) {

		for (PinDeclaration p : d.getPinDecls()) {
			if (!p.pinMap()) {
				addError(p, "invalid pin number list");
			}
		}
	}

	private void checkInstanceDecls(DesignDeclaration design) {

		// Set of names to check for duplicates
		Set<String> names = new HashSet<String>();

		for (InstanceDeclaration i : design.getInstanceDecls()) {

			DeviceDeclaration d = design.findDevDecl(i.getRefName());
			if (d == null) {
				addError(i, "instance references undeclared device");
			} else {
				// the instance references a device - check for duplicates
				if (i.isUpArray()) {
					for (int j = i.getMsb(); j <= i.getLsb(); j++) {
						if (!names.add(i.getName() + j))
							addError(i, "duplicate instance declaration");
					}
				} else if (i.isDownArray()) {
					for (int j = i.getMsb(); j >= i.getLsb(); j--) {
						if (!names.add(i.getName() + j))
							addError(i, "duplicate instance declaration");
					}
				} else {
					if (!names.add(i.getName())) {
						addError(i, "duplicate instance declaration");
					}
				}
				// check all attributes and pins are assigned correctly
				checkAttrAssigns(i, d);
				checkPinAssigns(i, d);
			}
		}
	}

	private void checkAttrAssigns(InstanceDeclaration i, DeviceDeclaration d) {

		// Sets of names and values to easily check for duplicates
		Set<String> names = new HashSet<String>();
		Set<String> values = new HashSet<String>();

		for (AttributeAssignment a : i.getAttributeAssignments()) {

			// convert the array to an index if the array is "one-wide"
			a.toIndex();

			if (a.getName().equals("REFDES")) {
				// for all REFDES attribute assignments
				if (!values.add(a.getValue()))
					addError(a, "duplicate refdes constraint");

				if (a.getWidth() != 1)
					addError(a, "invalid attribute width");

				// check refDes constraint starts with refPrefix
				AttributeDeclaration ad = d.findAttrDecl("REFPREFIX");
				if (ad != null) {
					String r = ad.getValue();
					if (!a.getValue().toUpperCase().startsWith(r.toUpperCase()))
						addError(a, "refdes begins with incorrect refprefix");
				}
			} else {
				// for all attribute assignments other than REFDES
				// check if defined in the attribute declaration
				if (d.findAttrDecl(a.getName()) == null)
					addError(a, "instance references undeclared attribute");
			}

			// update global attributes with instance array information
			if (i.isArrayed()) {
				if (!a.isArrayed() && !a.isIndexed()) {
					a.setMsb(i.getMsb());
					a.setLsb(i.getLsb());
				}
			}

			// check attribute array bounds or index against instance bounds
			if (a.isArrayed()) {
				if (!i.isValidArray(a.getMsb(), a.getLsb()))
					addError(a, "attribute array outside instance bounds");
			} else if (a.isIndexed()) {
				if (!i.isValidIndex(a.getIndex()))
					addError(a, "attribute index outside instance bounds");
			}

			// check for duplicate attribute assignments
			if (i.isArrayed()) {
				// inside arrayed instances
				if (a.isUpArray()) {
					for (int j = a.getMsb(); j <= a.getLsb(); j++) {
						if (!names.add(a.getName() + j))
							addError(a, "duplicate attribute assignment");
					}
				} else if (a.isDownArray()) {
					for (int j = a.getMsb(); j >= a.getLsb(); j--) {
						if (!names.add(a.getName() + j))
							addError(a, "duplicate attribute assignment");
					}
				} else if (a.isIndexed()) {
					if (!names.add(a.getName() + a.getIndex()))
						addError(a, "duplicate attribute assignment");
				} else {
					if (!names.add(a.getName())) {
						addError(a, "duplicate attribute assignment");
					}
				}
			} else {
				// inside non-arrayed instances
				if (!names.add(a.getName())) {
					addError(a, "duplicate attribute assignment");
				}
			}
		}
	}

	private void checkPinAssigns(InstanceDeclaration i, DeviceDeclaration d) {
		// check that all pins are present in the device declaration

		Set<String> names = new HashSet<String>();

		for (PinAssignment p : i.getPinAssignments()) {

			p.toIndex();

			if (d.findPinDecl(p.getName()) == null) {
				addError(p, "instance references undeclared pin");
			}

			// update global pins with instance array information
			if (i.isArrayed()) {
				if (!p.isArrayed() && !p.isIndexed()) {
					p.setMsb(i.getMsb());
					p.setLsb(i.getLsb());
				}
			}

			// check pin array bounds or index against instance bounds
			if (p.isArrayed()) {
				if (!i.isValidArray(p.getMsb(), p.getLsb()))
					addError(p, "pin array outside instance bounds");
			} else if (p.isIndexed()) {
				if (!i.isValidIndex(p.getIndex()))
					addError(p, "pin index outside instance bounds");
			}

			// check for duplicate attribute assignments
			if (i.isArrayed()) {
				// inside arrayed instances
				if (p.isUpArray()) {
					for (int j = p.getMsb(); j <= p.getLsb(); j++) {
						if (!names.add(p.getName() + j))
							addError(p, "duplicate pin assignment");
					}
				} else if (p.isDownArray()) {
					for (int j = p.getMsb(); j >= p.getLsb(); j--) {
						if (!names.add(p.getName() + j))
							addError(p, "duplicate pin assignment");
					}
				} else if (p.isIndexed()) {
					if (!names.add(p.getName() + p.getIndex()))
						addError(p, "duplicate pin assignment");
				} else {
					if (!names.add(p.getName())) {
						addError(p, "duplicate pin assignment");
					}
				}
			} else {
				// inside non-arrayed instances
				if (!names.add(p.getName())) {
					addError(p, "duplicate pin assignment");
				}
			}

		}

		// TODO check for missing pin assignments
		// for (PinDeclaration p : d.getPinDecls()) {
		// if (i.isArrayed()) {
		// if (i.isUpArray()) {
		// for (int j = p.getMsb(); j <= p.getLsb(); j++) {
		// String pin = p.getName() + j;
		// if (!names.contains(pin)) {
		// String msg = "unassigned pin " + pin;
		// addError(i, msg);
		// }
		// }
		// } else if (i.isDownArray()) {
		// for (int j = p.getMsb(); j >= p.getLsb(); j--) {
		// String pin = p.getName() + j;
		// if (!names.contains(pin)) {
		// String msg = "unassigned pin " + pin;
		// addError(i, msg);
		// }
		// }
		// }
		// } else {
		//
		// }
		// }

		// TODO check all concatenations

	}

	private void checkNetAssigns(DesignDeclaration d) {
		// TODO Auto-generated method stub

	}

	public Set<String> getErrors() {
		return errors;
	}

	public void addError(Parsable p, String msg) {
		errors.add(p.getFileName() + " line " + p.getLineString() + " " + msg
				+ ": " + p.getName());
	}

}
