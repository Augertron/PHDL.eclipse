package phdl.graph;

public class AttributeNode extends Node {

	private Attributable parent;
	private String value;
	private boolean overwritten = false;

	/**
	 * Default Constructor.
	 * 
	 * Sets the parent of the attribute node.
	 * 
	 * @param parent
	 *            the parent of the attribute node
	 */
	public AttributeNode(Attributable parent) {
		setParent(parent);
	}

	public AttributeNode(AttributeNode old, Attributable parent) {
		setParent(parent);
		setName(old.getName());
		setValue(old.getValue());
		setLocation(old.getLine(), old.getPosition(), old.getFileName());
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
	 * @param parent
	 *            the new parent node
	 */
	public void setParent(Attributable parent) {
		this.parent = parent;
	}

	/**
	 * Value mutator method.
	 * 
	 * @param value
	 *            the new value to set
	 */
	public void setValue(String value) {
		this.value = value.toUpperCase();
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

	@Override
	public String toString() {
		return super.toString() + " = " + value;
	}

	@Override
	public void setName(String name) {
		this.name = name.toUpperCase();
	}

	@Override
	public void initNode(String name, int line, int pos, String fileName) {
		this.name = name.toUpperCase();
		this.line = line;
		this.pos = pos;
		this.fileName = fileName;
	}

	public boolean overwrite(String value) {
		this.value = value;
		if (!overwritten) {
			overwritten = true;
			return true;
		}
		return false;
	}
}
