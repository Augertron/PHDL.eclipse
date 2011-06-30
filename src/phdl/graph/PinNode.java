package phdl.graph;

public class PinNode extends Node {
	
	private Attributable parent;
	private String pinName;
	
	/**
	 * Default Constructor.
	 * 
	 * @param instance the Parent InstanceNode to set
	 */
	public PinNode(Attributable parent) {
		setParent(parent);
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
	
	
}
