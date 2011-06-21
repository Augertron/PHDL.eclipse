package phdl.analyzer;

public class PortNode extends Node {

	/**
	 * Port nodes can only connect to one net
	 */
	private NetNode net;

	public PortNode(String name, int line, int pos) {
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
		return name.equals(((PortNode) o).getName());
	}
}
