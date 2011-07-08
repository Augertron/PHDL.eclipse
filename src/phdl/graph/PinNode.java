package phdl.graph;

public class PinNode extends Node {

	private Attributable parent;
	private String pinName;
	private NetNode net;

	public NetNode getNet() {
		return net;
	}

	public void setNet(NetNode net) {
		this.net = net;
	}

	public boolean hasNet() {
		if (net != null)
			return true;
		else
			return false;
	}

	/**
	 * Default Constructor.
	 * 
	 * @param instance
	 *            the Parent InstanceNode to set
	 */
	public PinNode(Attributable parent) {
		setParent(parent);
		pinName = "";
		net = null;
	}

	public PinNode(PinNode old, Attributable parent) {
		setParent(parent);
		pinName = old.getPinName();
		net = old.getNet();
		name = old.getName();
		line = old.getLine();
		pos = old.getPosition();
		fileName = old.getFileName();
	}

	/**
	 * 
	 * @return
	 */
	public Attributable getParent() {
		return parent;
	}

	/**
	 * 
	 * @param parent
	 */
	public void setParent(Attributable parent) {
		this.parent = parent;
	}

	/**
	 * 
	 * @param pinName
	 */
	public void setPinName(String pinName) {
		this.pinName = pinName;
	}

	/**
	 * 
	 * @return
	 */
	public String getPinName() {
		return pinName;
	}

	@Override
	public NodeType getType() {
		return NodeType.PIN;
	}

	@Override
	public String toString() {
		return super.toString() + " {" + pinName + "}";
	}
}
