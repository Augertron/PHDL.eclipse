package phdl.graph;

public class PortNode extends Node {

	/**
	 * Port nodes can only connect to one net
	 */
	private NetNode net;

	public PortNode() {

	}

	public NetNode getNet() {
		return net;
	}

	public void setNet(NetNode net) {
		this.net = net;
	}

	@Override
	public NodeType getType() {
		return NodeType.PORT;
	}

}
