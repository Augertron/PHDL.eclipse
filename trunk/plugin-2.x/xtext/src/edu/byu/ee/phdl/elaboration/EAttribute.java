/*
 * Copyright (C) 2011 Brigham Young University This program is free software: you can redistribute
 * it and/or modify it under the terms of the GNU General Public License as published by the Free
 * Software Foundation, version 3. This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received
 * a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package edu.byu.ee.phdl.elaboration;

/**
 * A class that represents an attribute.
 * 
 * @author Brad Riching and Richard Black
 * @version 0.1
 * 
 */
public class EAttribute extends Node {

	private Attributable parent;
	private String value = "";;
	private boolean overwritten = false;

	/**
	 * Default Constructor.
	 * 
	 * Sets the parent of the attribute node.
	 * 
	 * @param parent
	 *            the parent of the attribute node
	 */
	public EAttribute(Attributable parent) {
		this.parent = parent;
	}

	/**
	 * Copy Constructor.
	 * 
	 * @param old
	 *            the old AttributeNode to copy
	 * @param parent
	 *            the parent of the current node
	 */
	public EAttribute(Attributable parent, EAttribute old) {
		super(old);
		this.parent = parent;
		this.value = old.value;
		this.overwritten = old.isOverwritten();
		setName(old.getName());
		setLocation(old.getLine(), old.getPosition(), old.getFileName());
	}

	public EAttribute(Attributable parent, String name, String value) {
		this.parent = parent;
		this.name = name.toUpperCase();
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		return this.getName().equals(((EAttribute) o).getName());
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
	public NodeType getNodeType() {
		return NodeType.ATTRIBUTE;
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
	 * Value accessor method
	 * 
	 * @return the value of the attribute
	 */
	public String getValue() {
		return value;
	}

	public boolean isOverwritten() {
		return overwritten;
	}

	/**
	 * Changes the attribute value and checks to see if it's already been changed once.
	 * 
	 * @param value
	 *            the new attribute value
	 * @return true if the attribute hasn't been overwritten before false if it has
	 */
	public boolean overwrite(String value) {
		this.value = value;
		if (overwritten)
			return false;
		overwritten = true;
		return true;
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

	public void setOverwritten(boolean overwritten) {
		this.overwritten = overwritten;
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
		this.value = value;
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
		return getNodeType() + ": parent=" + parent.getName() + ", " + name + "=" + value;
	}

}
