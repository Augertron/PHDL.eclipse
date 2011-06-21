package phdl.analyzer;

import java.util.HashSet;

public class Graph {

	HashSet<NetNode> netNodes;
	HashSet<PinNode> pinNodes;
	HashSet<PortNode> portNodes;

	public Graph() {
		this.netNodes = new HashSet<NetNode>();
		this.pinNodes = new HashSet<PinNode>();
		this.portNodes = new HashSet<PortNode>();
	}

	public boolean addNetNode(NetNode net) {
		boolean added = netNodes.add(net);
		return added;
	}

	public boolean addPinNode(PinNode pin) {
		boolean added = pinNodes.add(pin);
		return added;
	}

	public boolean addPortNode(PortNode port) {
		boolean added = portNodes.add(port);
		return added;
	}

	public HashSet<NetNode> getNetNodes() {
		return netNodes;
	}

	public HashSet<PinNode> getPinNodes() {
		return pinNodes;
	}

	public HashSet<PortNode> getPortNodes() {
		return portNodes;
	}

}
