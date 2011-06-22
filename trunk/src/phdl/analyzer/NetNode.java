package phdl.analyzer;

import java.util.HashSet;
import java.util.Set;

public class NetNode extends Node {

	/**
	 * Net nodes can connect to any other type of node in any quantity
	 */
	private Set<Node> nodes;

	public NetNode() {
		nodes = new HashSet<Node>();
	}

	public void addNode(Node node) {
		nodes.add(node);
	}

	public Set<Node> getAllNodes() {
		return nodes;
	}
	
	public Set<PinNode> getPinNodes() {
		Set<PinNode> pins = new HashSet<PinNode>();
		for (Node n : nodes) {
			if (n.getType() == NodeType.PIN) {
				pins.add((PinNode)n);
			}
		}
		return pins;
	}
	
	public Set<PortNode> getPortNodes() {
		Set<PortNode> ports = new HashSet<PortNode>();
		for (Node n : nodes) {
			if (n.getType() == NodeType.PORT) {
				ports.add((PortNode)n);
			}
		}
		return ports;
	}
	
	public Set<NetNode> getNetNodes() {
		Set<NetNode> nets = new HashSet<NetNode>();
		for (Node n : nodes) {
			if (n.getType() == NodeType.NET) {
				nets.add((NetNode)n);
			}
		}
		return nets;
	}
	
	public boolean connectedTo(Node n) {
		return (nodes.contains(n));
	}
	
	public boolean connectedToNet() {
		for (Node n : nodes) {
			if (n.getType() == NodeType.NET) {
				return true;
			}
		}
		return false;
	}
	
	public boolean mergeNet(NetNode n) {
		if (connectedTo(n)) {
			for (Node m : nodes) {
				if (m.equals(n)) {
					for (Node a : n.getAllNodes()) {
						nodes.add(a);
					}
					name = name + "$" + m.getName();
					nodes.remove(m);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public NodeType getType() {
		return NodeType.NET;
	}

}
