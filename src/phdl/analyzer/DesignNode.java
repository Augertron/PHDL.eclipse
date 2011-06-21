package phdl.analyzer;

import java.util.Set;

import phdl.parser.DesignDeclaration;
import phdl.parser.PortAssignment;

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
	}

	public DesignNode(DesignDeclaration design) {
		this.design = design;
		firstChild = null;
		nextSibling = null;
		ports = null;
	}

	public DesignNode(DesignDeclaration design, Set<PortAssignment> ports) {
		this.design = design;
		this.ports = ports;
		firstChild = null;
		nextSibling = null;
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
}
