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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import phdl.PhdlComp;
import phdl.parser.AttrAssign;
import phdl.parser.AttrDecl;
import phdl.parser.DesignDecl;
import phdl.parser.DeviceDecl;
import phdl.parser.InstDecl;
import phdl.parser.NetDecl;
import phdl.parser.Parsable;
import phdl.parser.PinAssign;
import phdl.parser.PinDecl;

public class Analyzer {

	/**
	 * A list of errors to accumulate during the analyzer process
	 */
	private Set<String> errors;
	private Set<String> warnings;
	private List<DesignDecl> designs;

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

			processDeviceDecls(d.getDesignDeclaration());
			processNetDecls(d.getDesignDeclaration());
			processInstDecls(d.getDesignDeclaration());
			processNetAssigns(d.getDesignDeclaration());

			// TODO if errors by this point, throw exception

			// TODO make a new graph out of all pin, port and net assignments
			// and assign to design node
			
			 d.createInitialNetGraph();

		}

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
			for (AttrDecl a : d.getAttributeDecls()) {

				// check that attribute refPrefix value only contains letters
				if (a.getName().equals("REFPREFIX")) {
					if (!a.getValue().matches("^[A-Z]+$"))
						addError(a, "invalid refprefix declaration");
				}
			}

			// check that the pins are declared correctly
			for (PinDecl p : d.getPinDecls()) {
				if (!p.makePinMap()) {
					addError(p, "invalid pin number list");
				}
			}
		}
	}

	private void processNetDecls(DesignDecl d) {
		// Set of net names to check for duplicates
		Set<String> names = new HashSet<String>();

		for (NetDecl n : d.getNetDecls()) {
			// check if the name by itself is in there already
			for (String s : names) {
				if (n.getName().equals(s))
					addError(n, "duplicate net declaration");
			}
			// if an upArray, check each indexed version
			if (n.isUpArray()) {
				for (int i = n.getMsb(); i <= n.getLsb(); i++) {
					if (!names.add(n.getName() + i))
						addError(n, "duplicate net declaration");
				}
				// if a downArray, check each indexed version
			} else if (n.isDownArray()) {
				for (int i = n.getLsb(); i <= n.getMsb(); i++) {
					if (!names.add(n.getName() + i))
						addError(n, "duplicate net declaration");
				}
			} else {
				// check if any of the names start with the current name
				for (String s : names) {
					if (s.startsWith(n.getName()))
						addError(n, "duplicate net declaration");
				}
				// check
				if (!names.add(n.getName()))
					addError(n, "duplicate net declaration");
			}
		}

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
				processAttrAssigns(i, d);
				processPinAssigns(i, d);
			}
		}
	}

	private void processAttrAssigns(InstDecl i, DeviceDecl d) {

		// Sets of names and refDesValues to easily check for duplicates
		Set<String> names = new HashSet<String>();
		Set<String> refDesValues = new HashSet<String>();

		for (AttrAssign a : i.getAttrAssigns()) {

			if (!a.makeSlices())
				addError(a, "invalid attribute slice list");

			if (a.getName().equals("REFDES")) {
				// for all REFDES attribute assignments
				if (!refDesValues.add(a.getValue()))
					addError(a, "duplicate refdes constraint");

				if (a.getWidth() != 1)
					addError(a,
							"refdes cannot be assigned to multiple instances");

				AttrDecl ad = d.findAttrDecl("REFPREFIX");
				if (ad != null) {
					String refDes = a.getValue();
					String refPrefix = ad.getValue();
					// check refDes constraint starts with refPrefix
					if (!refDes.startsWith(refPrefix))
						addError(a, "invalid refdes prefix");
					refDes = refDes.substring(refPrefix.length(),
							refDes.length());
					// check refDes constraint ends with an integer after
					// subtracting off the refPrefix
					try {
						Integer.parseInt(refDes);
					} catch (NumberFormatException e) {
						addError(a, "invalid refdes suffix");
					}
				}
			} else {
				// for all attribute assignments other than REFDES
				// check if defined in the attribute declaration
				if (d.findAttrDecl(a.getName()) == null)
					addError(a, "attribute undeclared in referenced device");
			}

			// check attribute slices against instance bounds
			if (a.getSlices().size() != 0) {
				for (Integer s : a.getSlices()) {
					if (!i.isValidIndex(s))
						addError(a, "slice reference outside instance bounds");
					// add the attribute name to the set with slice appended
					if (!names.add(a.getName() + s))
						addError(a, "duplicate attribute assignment");
				}
			} else {
				// the attribute applies across the entire instance width
				if (i.isArrayed()) {
					a.setMsb(i.getMsb());
					a.setLsb(i.getLsb());
					a.makeSlices();
					for (Integer s : a.getSlices()) {
						if (!names.add(a.getName() + s)) {
							addError(a, "duplicate attribute assignment");
						}
					}
				} else {
					if (!names.add(a.getName())) {
						addError(a, "duplicate attribute assignment");
					}
				}
			}
		}
	}

	private void processPinAssigns(InstDecl i, DeviceDecl d) {

		// set of pin names to check for duplicates
		Set<String> names = new HashSet<String>();

		for (PinAssign p : i.getPinAssigns()) {

			if (!p.makeSlices())
				addError(p, "invalid pin slice list");

			// check that all assigned pins are declared
			if (d.findPinDecl(p.getName()) == null) {
				addError(p, "pin undeclared in referenced device");
			}

			// TODO check for missing pin assignments

			// TODO check all concatenations

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
