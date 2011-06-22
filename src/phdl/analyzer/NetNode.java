package phdl.analyzer;

import java.util.ArrayList;

public class NetNode extends Node {

	/**
	 * Net nodes can connect to any other type of node in any quantity
	 */
	private ArrayList<Node> nodes;

	public NetNode() {
		
	}

	public void addNode(Node node) {
		nodes.add(node);
	}

	public ArrayList<Node> getNodes() {
		return nodes;
	}

	@Override
	public boolean equals(Object o) {
		return name.equals(((NetNode) o).getName());
	}

}