package phdl.graph;

public class AttributeNode extends Node {

	private Attributable parent;
	private String value;
	
	/**
	 * Default Constructor.
	 * 
	 * Sets the parent of the attribute node.
	 * 
	 * @param parent the parent of the attribute node
	 */
	public AttributeNode(Attributable parent) {
		setParent(parent);
	}
	
	/**
	 * Parent Node accessor method.
	 * 
	 * @return the parent node
	 */
	public Attributable getParent() {
		return parent;
	}

	/**
	 * Parent Node mutator method.
	 * 
	 * @param parent the new parent node
	 */
	public void setParent(Attributable parent) {
		this.parent = parent;
	}

	/**
	 * Value mutator method.
	 * 
	 * @param value the new value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Value accessor method
	 * 
	 * @return the value of the attribute
	 */
	public String getValue() {
		return value;
	}
	
	@Override
	public NodeType getType() {
		return NodeType.ATTRIBUTE;
	}

}
