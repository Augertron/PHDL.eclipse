/*
    Copyright (C) 2011  BYU Configurable Computing Lab

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package phdl.graph;

/**
 * A class that represents an attribute.
 * 
 * @author Brad Riching and Richard Black
 * @version 0.1
 *
 */
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

	/**
	 * Copy Constructor.
	 * 
	 * @param old the old AttributeNode to copy
	 * @param parent the parent of the current node
	 */
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
	/**
	 * Type accessor method.
	 * 
	 * Returns the type of the Node as "ATTRIBUTE"
	 * 
	 * @return NodeType.ATTRIBUTE
	 * @see NodeType
	 */
	public NodeType getType() {
		return NodeType.ATTRIBUTE;
	}

	@Override
	/**
	 * String generation method.
	 * 
	 * Returns a string representation of the Attribute Node.
	 * 
	 * @return the string representation
	 */
	public String toString() {
		return super.toString() + " = " + value;
	}

	@Override
	/**
	 * Name mutatior method.
	 * 
	 * Sets the name of the attribute by first making it
	 * all upper case.
	 * 
	 * @param the new name of the attribute
	 */
	public void setName(String name) {
		this.name = name.toUpperCase();
	}

	@Override
	/**
	 * A method that initializes an AttributeNode with
	 * essential information.
	 * 
	 * @param name		the name of the AttributeNode
	 * @param line		the line of the attribute
	 * @param pos		the position of the attribute
	 * @param fileName	the filename where the attribute was found
	 */
	public void initNode(String name, int line, int pos, String fileName) {
		this.name = name.toUpperCase();
		this.line = line;
		this.pos = pos;
		this.fileName = fileName;
	}

	/**
	 * Changes the attribute value and checks to see if
	 * it's already been changed once.
	 * 
	 * @param value the new attribute value
	 * @return	true if the attribute hasn't been overwritten
	 * 				before
	 * 			false if it has
	 */
	public boolean overwrite(String value) {
		this.value = value;
		if (!overwritten) {
			overwritten = true;
			return true;
		}
		return false;
	}
}
