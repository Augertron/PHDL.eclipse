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

import phdl.parser.AttributeAssignment;
import phdl.parser.DesignDeclaration;
import phdl.parser.DeviceDeclaration;
import phdl.parser.InstanceDeclaration;
import phdl.parser.NetAssignment;
import phdl.parser.NetDeclaration;
import phdl.parser.Parsable;

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

	private void createInitialNetGraph() {
		netgraph = new Graph();
		for (DesignDeclaration d : dh.getBFS()) {
			Set<NetDeclaration> nets = d.getNetDecls();
			createNetNodes(nets);

			Set<NetAssignment> na = d.getNetAssignments();
			for (NetAssignment a : na) {
				ArrayList<String> lvals = new ArrayList<String>();
				ArrayList<String> rvals = new ArrayList<String>();
				if (a.getIndex() != -1) {
					lvals.add(a.getName() + "_" + a.getIndex());
				} else if (a.getMsb() > a.getLsb()) {
					for (int i = a.getMsb(); i > a.getLsb(); i--) {

					}
				}
			}
		}
	}

	private void createNetNodes(Set<NetDeclaration> nets) {
		for (NetDeclaration n : nets) {
			int min = getMin(n.getMsb(), n.getLsb());
			int max = getMax(n.getMsb(), n.getLsb());
			for (int i = min; i <= max; i++) {
				NetNode newNet = new NetNode();
				newNet.setName(n.getName() + "_" + i);
				netgraph.addNetNode(newNet);
			}
		}
	}

	private int getMin(int msb, int lsb) {
		if (msb < lsb) {
			return msb;
		}
		return lsb;
	}

	private int getMax(int msb, int lsb) {
		if (msb < lsb) {
			return lsb;
		}
		return msb;
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

			verifyInstances(d.getDesignDeclaration());
			verifyNets(d.getDesignDeclaration());

			// TODO if errors by this point, throw exception

			// TODO make a new graph out of all pin, port and net assignments
			// and assign to design node
			Graph g = new Graph();
			d.setGraph(g);
		}
	}

	private void verifyInstances(DesignDeclaration design) {
		for (InstanceDeclaration i : design.getInstanceDecls()) {
			DeviceDeclaration d = design.findDevDecl(i.getRefName());
			if (d == null) {
				addError(i, "instance references undeclared device");
			} else {
				verifyAttributes(i, d);
				verifyPins(i, d);
			}
		}
	}

	private void verifyAttributes(InstanceDeclaration i, DeviceDeclaration d) {

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
				String r = d.findAttrDecl("REFPREFIX").getValue();
				if (!a.getValue().toUpperCase().startsWith(r.toUpperCase()))
					addError(a, "refdes begins with invalid refprefix");

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
				if (a.isArrayed()) {
					addError(a, "array invalid for singular instance");
				} else if (a.isIndexed()) {
					addError(a, "index invalid for singular instance");
				}
				if (!names.add(a.getName())) {
					addError(a, "duplicate attribute assignment");
				}
			}
		}
	}

	private void verifyPins(InstanceDeclaration i, DeviceDeclaration dev) {
		// TODO Auto-generated method stub

	}

	private void verifyNets(DesignDeclaration d) {
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
