package phdl.analyzer;

public class PinNode extends Node {

	/**
	 * Pin Nodes can only connect to one net
	 */
	private NetNode net;

	public PinNode() {
		
	}

	public NetNode getNet() {
		return net;
	}

	public void setNet(NetNode net) {
		this.net = net;
	}

	@Override
	public NodeType getType() {
		return NodeType.PIN;
	}
}
