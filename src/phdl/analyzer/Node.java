package phdl.analyzer;

import phdl.parser.Parsable;

public abstract class Node {

	/**
	 * The name of the node
	 */
	protected String name;

	// not sure if we need these
	protected int line;
	protected int pos;

	/**
	 * Contains the original reference to the parser element object
	 */
	protected Parsable element;

	public String getName() {
		return name;
	}

	public int getLine() {
		return line;
	}

	public int getPosition() {
		return pos;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public void setPosition(int pos) {
		this.pos = pos;
	}

	public void setElement(Parsable element) {
		this.element = element;
	}

	public Parsable getElement() {
		return element;
	}
	
	public abstract NodeType getType();
	
	@Override
	public boolean equals(Object o) {
		return name.equals(((Node)o).getName());
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
