package phdl.analyzer;

public class PinNode extends Node {

	/**
	 * Pin Nodes can only connect to one net
	 */
	private NetNode net;

	public PinNode(String name, int line, int pos) {
		this.name = name;
		this.line = line;
		this.pos = pos;
	}

	public NetNode getNet() {
		return net;
	}

	public void setNet(NetNode net) {
		this.net = net;
	}

	@Override
	public boolean equals(Object o) {
		return name.equals(((PinNode) o).getName());
	}
}
