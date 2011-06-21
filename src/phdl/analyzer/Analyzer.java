package phdl.analyzer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import phdl.exception.PhdlException;
import phdl.parser.AttributeAssignment;
import phdl.parser.AttributeDeclaration;
import phdl.parser.DesignDeclaration;
import phdl.parser.DeviceDeclaration;
import phdl.parser.InstanceDeclaration;
import phdl.parser.NetAssignment;
import phdl.parser.NetDeclaration;
import phdl.parser.ParsedDesigns;
import phdl.parser.PinAssignment;
import phdl.parser.PinDeclaration;
import phdl.parser.PortAssignment;

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
				}
				else if (a.getMsb() > a.getLsb()) {
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

	private void validateInstances(DesignDeclaration d) {

		for (InstanceDeclaration i : d.getInstanceDecls()) {

			DeviceDeclaration devDecl = new DeviceDeclaration();
			devDecl.setName(i.getRefName());

			if (!d.getDeviceDecls().contains(devDecl))
				addError(i.getFileName() + " " + i.getLineString()
						+ " instanced device not declared: " + i.getName());

			if (d.getDeviceDecls().contains(devDecl)) {
				for (AttributeAssignment a : i.getAttributeAssignments()) {
					AttributeDeclaration ad = new AttributeDeclaration();
					ad.setName(a.getName());
					if (!devDecl.getAttributeDecls().contains(ad)) {
						addError(a.getFileName()
								+ " "
								+ a.getLineString()
								+ " instanced attribute assignment not declared: "
								+ a.getName());
					}
				}
				for (PinAssignment p : i.getPinAssignments()) {
					PinDeclaration pd = new PinDeclaration();
					pd.setName(p.getName());
					if (!devDecl.getPinDecls().contains(pd)) {
						addError(p.getFileName() + " " + p.getLineString()
								+ " instanced pin assignment not declared: "
								+ p.getName());

					}
				}

			}
		}
	}

	private void validateNets(DesignDeclaration d) {
		// TODO Auto-generated method stub

	}

	public LinkedList<String> getErrors() {
		return errors;
	}

	public void addError(String error) {
		errors.add(error);
	}

}
