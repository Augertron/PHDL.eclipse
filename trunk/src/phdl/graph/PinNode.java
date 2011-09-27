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
public class PinNode extends Node {

	private Attributable parent;
	private String pinName;
	private NetNode net;

	/**
	 * Default Constructor.
	 * 
	 * @param instance
	 *            the Parent InstanceNode to set
	 * @see Attributable
	 * @see NetNode
	 */
	public PinNode(Attributable parent) {
		setParent(parent);
		pinName = "";
		net = null;
	}

	/**
	 * Copy Constructor.
	 * 
	 * @param old		the old PinNode to copy
	 * @param parent	the parent of the PinNode
	 */
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
	 * Net accessor method.
	 * 
	 * @return			the NetNode attached to the Pin
	 */
	public NetNode getNet() {
		return net;
	}

	/**
	 * Net mutator method.
	 * 
	 * @param net		the new NetNode
	 */
	public void setNet(NetNode net) {
		this.net = net;
	}

	/**
	 * Checks to see if the PinNode has a NetNode.
	 * 
	 * @return			true, if there is a NetNode
	 * 					false, otherwise
	 */
	public boolean hasNet() {
		if (net != null)
			return true;
		else
			return false;
	}

	/**
	 * ParentNode accessor method.
	 * 
	 * @return			the attributable parent node
	 */
	public Attributable getParent() {
		return parent;
	}

	/**
	 * ParentNode mutator method.
	 * 
	 * @param parent	the new attributable parent node
	 */
	public void setParent(Attributable parent) {
		this.parent = parent;
	}

	/**
	 * PinName mutator method.
	 * 
	 * @param pinName	the new pinName
	 */
	public void setPinName(String pinName) {
		this.pinName = pinName;
	}

	/**
	 * PinName accessor method.
	 * 
	 * @return			the pinName
	 */
	public String getPinName() {
		return pinName;
	}

	@Override
	/**
	 * Type accessor method.
	 * 
	 * @return NodeType.PIN
	 */
	public NodeType getType() {
		return NodeType.PIN;
	}

	@Override
	/**
	 * Generic toString method.
	 * 
	 * @return			a string representation
	 */
	public String toString() {
		return super.toString() + " {" + pinName + "}";
	}

	/**
	 * Returns the index of the current Pin, assuming that it
	 * has an array reference.
	 * 
	 * @return			the index of the Pin
	 */
	public int getIndex() {
		int start = getName().indexOf('[');
		int end = getName().indexOf(']');

		if (start == -1 || end == -1) {
			return -1;
		}

		String index = getName().substring(start + 1, end);
		return Integer.parseInt(index);
	}
}
