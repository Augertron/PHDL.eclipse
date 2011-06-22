package phdl.analyzer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import phdl.exception.InvalidWidthException;
import phdl.parser.ConcatenationAssignment;
import phdl.parser.DesignDeclaration;
import phdl.parser.DeviceDeclaration;
import phdl.parser.InstanceDeclaration;
import phdl.parser.Net;
import phdl.parser.NetAssignment;
import phdl.parser.NetDeclaration;
import phdl.parser.PinAssignment;
import phdl.parser.PinDeclaration;
import phdl.parser.PortAssignment;
import phdl.parser.PortDeclaration;

public class DesignNode {

	/**
	 * The design node's reference to its design declaration
	 */
	private DesignDeclaration design;
	/**
	 * The design node's first child
	 */
	private DesignNode firstChild;
	/**
	 * The design node's next sibling
	 */
	private DesignNode nextSibling;
	/**
	 * The design node's set of port assignments
	 */
	private Set<PortAssignment> ports;
	/**
	 * The design node's graph of pins, nets and ports
	 */
	private Graph graph;

	public DesignNode() {
		design = null;
		firstChild = null;
		nextSibling = null;
		ports = null;
		graph = null;
	}

	public DesignNode(DesignDeclaration design) {
		this.design = design;
		firstChild = null;
		nextSibling = null;
		ports = null;
		graph = null;
	}

	public DesignNode(DesignDeclaration design, Set<PortAssignment> ports) {
		this.design = design;
		this.ports = ports;
		firstChild = null;
		nextSibling = null;
		graph = null;
	}

	public boolean hasPorts() {
		return (ports != null);
	}

	public boolean hasChild() {
		return (firstChild != null);
	}

	public boolean hasNextSibling() {
		return (nextSibling != null);
	}

	public DesignNode getFirstChild() {
		return firstChild;
	}

	public DesignNode getNextSibling() {
		return nextSibling;
	}

	public Set<PortAssignment> getPorts() {
		return ports;
	}

	public DesignDeclaration getDesignDeclaration() {
		return design;
	}

	public void setFirstChild(DesignNode child) {
		this.firstChild = child;
	}

	public void setDesignDeclaration(DesignDeclaration design) {
		this.design = design;
	}

	public void addChild(DesignNode child) {
		if (firstChild == null) {
			firstChild = child;
		} else {
			DesignNode nextChild = firstChild;
			while (nextChild.getNextSibling() != null) {
				nextChild = nextChild.getNextSibling();
			}
			nextChild.nextSibling = child;
		}
		child.nextSibling = null;
	}

	public boolean equals(DesignNode other) {
		return design.equals(other.getDesignDeclaration());
	}

	@Override
	public String toString() {
		return design.getName();
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}
	
	public void createInitialNetGraph() throws InvalidWidthException {
		graph = new Graph();
		Set<NetDeclaration> nets = design.getNetDecls();
		createNetNodes(nets);

		Set<NetAssignment> na = design.getNetAssignments();
		for (NetAssignment a : na) {
			ArrayList<String> lvals = new ArrayList<String>();
			ArrayList<String> rvals = new ArrayList<String>();
			lvals = assignLVals(lvals, a);
			rvals = assignRVals(rvals, a.getNets());
			if (lvals.size() != rvals.size()) {
				throw new InvalidWidthException(a);
			}
			linkNets(lvals, rvals);
		}
		addPins();
		addPorts();
	}
	
	private void createNetNodes(Set<NetDeclaration> nets) {
		for (NetDeclaration n : nets) {
			if (n.getWidth() != 1) {
				int min = getMin(n.getMsb(), n.getLsb());
				int max = getMax(n.getMsb(), n.getLsb());
				for (int i = min; i <= max; i++) {
					NetNode newNet = new NetNode();
					newNet.setName(n.getName() + "_" + i);
					graph.addNetNode(newNet);
				}	
			}
			else {
				NetNode newNet = new NetNode();
				newNet.setName(n.getName());
				graph.addNetNode(newNet);
			}
		}
	}
	
	private void linkNets(ArrayList<String> lvals, ArrayList<String> rvals) {
		for (int i = 0; i < lvals.size(); i++) {
			NetNode l = graph.getNet(lvals.get(i));
			if (l == null) {
				// net never declared
			}
			NetNode r = graph.getNet(rvals.get(i));
			if (r == null) {
				// net never declared
			}
			l.addNode(r);
			r.addNode(l);
		}
	}
	
	private ArrayList<String> assignLVals(ArrayList<String> lvals, ConcatenationAssignment a) {
		if (a.getIndex() != -1) {
			lvals.add(a.getName() + "_" + a.getIndex());
		} else if (a.getMsb() > a.getLsb()) {
			for (int i = a.getMsb(); i > a.getLsb(); i--) {
				lvals.add(a.getName() + "_" + i);
			}
		}
		else {
			for (int i = a.getMsb(); i < a.getLsb(); i++) {
				lvals.add(a.getName() + "_" + i);
			}
		}
		return lvals;
	}
	
	private ArrayList<String> assignRVals(ArrayList<String> rvals, List<Net> a) {
		for (int j = 0; j < a.size(); j++) {
			Net n = a.get(j);
			if (n.getIndex() != -1) {
				rvals.add(n.getName() + "_" + n.getIndex());
			} else if (n.getMsb() > n.getLsb()) {
				for (int i = n.getMsb(); i > n.getLsb(); i--) {
					rvals.add(n.getName() + "_" + i);
				}
			}
			else {
				for (int i = n.getMsb(); i < n.getLsb(); i++) {
					rvals.add(n.getName() + "_" + i);
				}
			}
		}
		return rvals;
	}
	
	private void addPins() throws InvalidWidthException {
		Set<PinNode> pins = createPinNodes();
		for (InstanceDeclaration i : design.getInstanceDecls()) {
			for (PinAssignment p : i.getPinAssignments()) {
				ArrayList<String> lvals = new ArrayList<String>();
				ArrayList<String> rvals = new ArrayList<String>();
				lvals = assignLVals(lvals, p);
				rvals = assignRVals(rvals, p.getNets());
				if (lvals.size() != rvals.size()) {
					throw new InvalidWidthException(p);
				}
				linkPins(lvals, rvals, pins);
			}
		}
	}
	
	private void linkPins(ArrayList<String> lvals, ArrayList<String> rvals, Set<PinNode> pins) {
		for (int i = 0; i < lvals.size(); i++) {
			NetNode n = graph.getNet(rvals.get(i));
			if (n == null) {
				// net not declared
			}
			for (PinNode p : pins) {
				if (p.getName().equals(lvals.get(i))) {
					n.addNode(p);
					p.setNet(n);
					break;
				}
			}
		}
	}
	
	private Set<PinNode> createPinNodes() {
		Set<PinNode> pins = new HashSet<PinNode>();
		for (DeviceDeclaration d : design.getDeviceDecls()) {
			for (PinDeclaration p : d.getPinDecls()) {
				if (p.getWidth() != 1) {
					int min = getMin(p.getMsb(), p.getLsb());
					int max = getMax(p.getMsb(), p.getLsb());
					for (int i = min; i <= max; i++) {
						PinNode newNode = new PinNode();
						newNode.setName(p.getName() + "_" + i);
						pins.add(newNode);
					}
				}
				else {
					PinNode newNode = new PinNode();
					newNode.setName(p.getName());
					pins.add(newNode);
				}
			}
		}
		return pins;
	}
	
	private void addPorts() {
		Set<PortNode> p = createPortNodes();
		
	}
	
	private Set<PortNode> createPortNodes() {
		Set<PortNode> p = new HashSet<PortNode>();
		for (PortDeclaration d : design.getPortDecls()) {
			if (d.getWidth() != 1) {
				int min = getMin(d.getMsb(), d.getLsb());
				int max = getMax(d.getMsb(), d.getLsb());
				for (int i = min; i <= max; i++) {
					PortNode newNode = new PortNode();
					newNode.setName(d.getName() + "_" + i);
					p.add(newNode);
				}
			}
			else {
				PortNode newNode = new PortNode();
				newNode.setName(d.getName());
				p.add(newNode);
			}
		}
		
		return p;
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
}
