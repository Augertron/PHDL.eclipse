/*
    Copyright (C) 2011  Brigham Young University

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, version 3.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package phdl.graph;

/**
 * A class that represents a Pin in PHDL.
 * 
 * @author Brad Riching and Richard Black
 * @version 0.1
 */
public class Pin extends Node {

	private Attributable parent;
	private String pinNumber;
	private Net net;
	private PinType pinType;
	private int index;

	/**
	 * Default Constructor.
	 * 
	 * @param instance
	 *            the Parent InstanceNode to set
	 * @see Attributable
	 * @see Net
	 */
	public Pin(Attributable parent) {
		setParent(parent);
		pinNumber = "";
		net = null;
		setIndex(-1);
	}

	/**
	 * Copy Constructor.
	 * 
	 * @param old
	 *            the old PinNode to copy
	 * @param parent
	 *            the parent of the PinNode
	 */
	public Pin(Pin old, Attributable parent) {
		this.parent = parent;
		this.pinNumber = old.getPinNumber();
		this.net = old.getNet();
		this.name = old.getName();
		this.line = old.getLine();
		this.pos = old.getPosition();
		this.fileName = old.getFileName();
		this.index = old.getIndex();
		this.pinType = old.getPinType();
	}

	@Override
	public boolean equals(Object o) {
		return name.equals(((Pin) o).getName()) && index == ((Pin) o).getIndex();
	}

	public int getIndex() {
		return index;
	}

	/**
	 * Net accessor method.
	 * 
	 * @return the NetNode attached to the Pin
	 */
	public Net getNet() {
		return net;
	}

	@Override
	/**
	 * Type accessor method.
	 * 
	 * @return NodeType.PIN
	 */
	public NodeType getNodeType() {
		return NodeType.PIN;
	}

	/**
	 * ParentNode accessor method.
	 * 
	 * @return the attributable parent node
	 */
	public Attributable getParent() {
		return parent;
	}

	/**
	 * PinName accessor method.
	 * 
	 * @return the pinName
	 */
	public String getPinNumber() {
		return pinNumber;
	}

	public PinType getPinType() {
		return pinType;
	}

	/**
	 * Checks to see if the PinNode has a NetNode.
	 * 
	 * @return true, if there is a NetNode false, otherwise
	 */
	public boolean hasNet() {
		return (net != null);
	}

	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * Net mutator method.
	 * 
	 * @param net
	 *            the new NetNode
	 */
	public void setNet(Net net) {
		this.net = net;
	}

	/**
	 * ParentNode mutator method.
	 * 
	 * @param parent
	 *            the new attributable parent node
	 */
	public void setParent(Attributable parent) {
		this.parent = parent;
	}

	/**
	 * PinName mutator method.
	 * 
	 * @param pinName
	 *            the new pinName
	 */
	public void setPinNumber(String pinName) {
		this.pinNumber = pinName;
	}

	public void setPinType(PinType type) {
		this.pinType = type;
	}

	@Override
	/**
	 * Generic toString method.
	 * 
	 * @return			a string representation
	 */
	public String toString() {
		return getNodeType() + ": " + getPinType() + " " + name
				+ ((index == -1) ? ("") : ("[" + index + "]")) + "={" + pinNumber + "}";
	}
}
