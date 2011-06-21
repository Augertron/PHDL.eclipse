package phdl.analyzer;

import java.util.HashSet;

public class Graph {

	HashSet<NetNode> netNodes;

	public Graph() {
		this.netNodes = new HashSet<NetNode>();
	}

	public boolean addNetNode(NetNode net) {
		boolean added = netNodes.add(net);
		return added;
	}

	public HashSet<NetNode> getNetNodes() {
		return netNodes;
	}

}
