package phdl.analyzer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import phdl.parser.AttributeAssignment;
import phdl.parser.AttributeDeclaration;
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
	private LinkedList<String> errors;
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
		this.errors = new LinkedList<String>();
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

			// verify all instances have a corresponding device declaration
			validateInstances(d.getDesignDeclaration());

			// verify all net assignments have a corresponding net declaration
			validateNets(d.getDesignDeclaration());

			// make a new graph out of all pin, port and net assignments
			Graph g = new Graph();

			d.setGraph(g);
		}
	}

	private void validateInstances(DesignDeclaration design) {
		for (InstanceDeclaration i : design.getInstanceDecls()) {
			DeviceDeclaration d = design.findDevDecl(i.getRefName());
			if (d == null) {
				addError(i, "undeclared device");
			} else {
				validateAttributes(i, d);
				validatePins(i, d);
			}
		}
	}

	private void validateAttributes(InstanceDeclaration i, DeviceDeclaration d) {

		Set<String> values = new HashSet<String>();
		Set<String> names = new HashSet<String>();

		for (AttributeAssignment a : i.getAttributeAssignments()) {

			// for all attribute assignments other than REFDES
			if (!a.getName().equals("REFDES")) {

				// check if it has been defined in the attribute declaration
				AttributeDeclaration ad = d.findAttrDecl(a.getName());
				if (ad == null)
					addError(a, "undeclared attribute");

			} else {
				// check for duplicate refdes constraints
				if (!values.add(a.getValue()))
					addError(a, "duplicate refdes constraint");

				if (a.getWidth() > 1)
					addError(a, "invalid attribute width");
			}

			// convert the array to an index if the array is one-wide
			a.toIndex();

			// check attribute array bounds or index against instance bounds
			if (a.hasArray()) {
				if (!i.isValidArray(a.getMsb(), a.getLsb()))
					addError(a, "attribute outside range of instance bounds");
			} else if (a.hasIndex())
				if (!i.isValidIndex(a.getIndex()))
					addError(a, "attribute outside range of instance bounds");

			// check for duplicate attribute assignments
			if (a.isUpArray()) {
				System.out.println("Up array " + a.getName());
				for (int j = a.getMsb(); j > a.getLsb(); j++) {
					if (!names.add(a.getName() + j))
						addError(a, "duplicate attribute assignment");
				}
			} else if (a.isDownArray()) {
				System.out.println("Down array: " + a.getName());
				for (int j = a.getMsb(); j < a.getLsb(); j--) {
					if (!names.add(a.getName() + j))
						addError(a, "duplicate attribute assignment");
				}
			} else if (a.hasIndex()) {
				System.out.println("Has index " + a.getName());
				if (!names.add(a.getName() + a.getIndex()))
					addError(a, "duplicate attribute assignment");
			} else {

				if (i.isUpArray()) {
					for (int j = i.getMsb(); j > i.getLsb(); j++) {
						if (!names.add(a.getName() + j))
							addError(a, "duplicate attribute assignment");
					}
				} else if (i.isDownArray()) {
					for (int j = i.getMsb(); j < i.getLsb(); j--) {
						if (!names.add(a.getName() + j))
							addError(a, "duplicate attribute assignment");
					}
				} else {
					if (!names.add(a.getName()))
						addError(a, "duplicate attribute assignment");
				}

			}
		}
		for (String s : names)
			System.out.println(s);
	}

	private void validatePins(InstanceDeclaration i, DeviceDeclaration dev) {
		// TODO Auto-generated method stub

	}

	private void validateNets(DesignDeclaration d) {
		// TODO Auto-generated method stub

	}

	public List<String> getErrors() {
		return errors;
	}

	public void addError(Parsable p, String msg) {
		errors.add(p.getFileName() + " line " + p.getLineString() + " " + msg
				+ ": " + p.getName());
	}

}
