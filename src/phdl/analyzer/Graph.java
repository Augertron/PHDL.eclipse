package phdl.analyzer;

import java.util.Set;
import java.util.HashSet;

public class Graph {

	Set<NetNode> netNodes;

	public Graph() {
		this.netNodes = new HashSet<NetNode>();
	}

	public boolean addNetNode(NetNode net) {
		boolean added = netNodes.add(net);
		return added;
	}

	public Set<NetNode> getNetNodes() {
		return netNodes;
	}
	
	public NetNode getNet(String name) {
		for (NetNode n : netNodes) {
			if (n.getName().equals(name)) {
				return n;
			}
		}
		return null;
	}

}
