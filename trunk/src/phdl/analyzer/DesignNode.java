package phdl.analyzer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import phdl.exception.InvalidWidthException;
import phdl.parser.ConcatAssign;
import phdl.parser.DesignDecl;
import phdl.parser.DeviceDecl;
import phdl.parser.InstDecl;
import phdl.parser.Net;
import phdl.parser.NetAssign;
import phdl.parser.NetDecl;
import phdl.parser.PinAssign;
import phdl.parser.PinDecl;
import phdl.parser.PortAssign;
import phdl.parser.PortDecl;

public class DesignNode {

	/**
	 * The design node's reference to its design declaration
	 */
	private DesignDecl design;
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
	private Set<PortAssign> ports;
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

	public DesignNode(DesignDecl design) {
		this.design = design;
		firstChild = null;
		nextSibling = null;
		ports = null;
		graph = null;
	}

	public DesignNode(DesignDecl design, Set<PortAssign> ports) {
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

	public Set<PortAssign> getPorts() {
		return ports;
	}

	public DesignDecl getDesignDeclaration() {
		return design;
	}

	public void setFirstChild(DesignNode child) {
		this.firstChild = child;
	}

	public void setDesignDeclaration(DesignDecl design) {
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
	
	public void createInitialNetGraph() {
		graph = new Graph();
		Set<NetDecl> nets = design.getNetDecls();
		createNetNodes(nets);

		Set<NetAssign> na = design.getNetAssigns();
		for (NetAssign a : na) {
			ArrayList<String> lvals = new ArrayList<String>();
			ArrayList<String> rvals = new ArrayList<String>();
			lvals = assignLVals(lvals, a);
			rvals = assignRVals(rvals, a.getNets());
			linkNets(lvals, rvals);
		}
	}
	
	private ArrayList<String> assignRVals(ArrayList<String> rvals,
			LinkedList<Net> nets) {
		ArrayList<Integer> slices = new ArrayList<Integer>();
		for (Net n : nets) {
			slices.addAll(n.getSlices());
			for (int i = 0; i < slices.size(); i++) {
				rvals.add(n.getName() + "_" + slices.get(i));
			}
			slices.clear();
		}
		return rvals;
	}

	private ArrayList<String> assignLVals(ArrayList<String> lvals, NetAssign a) {
		for (int i = 0; i < a.getSlices().size(); i++) {
			lvals.add(a.getName() + "_" + a.getSlices().get(i));
		}
		return lvals;
	}
	
	private void createNetNodes(Set<NetDecl> nets) {
		for (NetDecl n : nets) {
			if (n.getWidth() != 1) {
				int min = n.getMsb() > n.getLsb() ? n.getLsb() : n.getMsb();
				int max = n.getMsb() < n.getLsb() ? n.getLsb() : n.getMsb();
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
			NetNode r = graph.getNet(rvals.get(i));
			l.addNode(r);
		}
	}
	
	private Set<PinNode> createPinNodes() {
		Set<PinNode> pins = new HashSet<PinNode>();
		for (DeviceDecl d : design.getDeviceDecls()) {
			for (PinDecl p : d.getPinDecls()) {
				if (p.getWidth() != 1) {
					int min = p.getMsb() > p.getLsb() ? p.getLsb() : p.getMsb();
					int max = p.getMsb() < p.getLsb() ? p.getLsb() : p.getMsb();
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

}
