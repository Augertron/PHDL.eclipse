/*
 * Copyright (C) 2011 Brigham Young University This program is free software: you can redistribute
 * it and/or modify it under the terms of the GNU General Public License as published by the Free
 * Software Foundation, version 3. This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received
 * a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package phdl.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents a device instance in PHDL.
 * 
 * @author Brad Riching and Richard Black
 * @version 0.1
 */
public class Instance extends Attributable {

	private List<Pin> pins;
	private Design design;
	private Device device;
	private String refDes;
	private String refPrefix;
	private String footprint;
	private String groupName;
	private int index;

	/**
	 * Default Constructor.
	 * 
	 * @param design
	 *            the parent DesignNode for this instance
	 * @see Design
	 * @see Device
	 * @see Pin
	 */
	public Instance(Design design) {
		super();
		this.design = design;
		this.pins = new ArrayList<Pin>();
		this.refDes = null;
		this.refPrefix = null;
		this.footprint = null;
		this.info = "";
		this.index = -1;
	}

	/**
	 * Design accessor method.
	 * 
	 * @return the DesignNode attached to this Device
	 */
	public Design getDesign() {
		return design;
	}

	/**
	 * Design mutator method.
	 * 
	 * @param design
	 *            the new DesignNode
	 */
	public void setDesign(Design design) {
		this.design = design;
	}

	/**
	 * Pin List accessor method.
	 * 
	 * @return the List of PinNodes
	 */
	public List<Pin> getPins() {
		return pins;
	}

	/**
	 * Pin List addition method.
	 * 
	 * @param p
	 *            the new PinNode
	 * @return true, if the pin wasn't in the set false, otherwise
	 */
	public boolean addPin(Pin p) {
		return pins.add(p);
	}

	/**
	 * Checks to see if there are any pins in the Instance.
	 * 
	 * @return true, if there are pins false, otherwise
	 */
	public boolean hasPins() {
		return (!pins.isEmpty());
	}

	/**
	 * RefDes accessor method.
	 * 
	 * @return the refDes
	 */
	public String getRefDes() {
		return refDes;
	}

	/**
	 * RefDes mutator method.
	 * 
	 * @param refDes
	 *            the new refDes
	 */
	public void setRefDes(String refDes) {
		this.refDes = refDes;
	}

	/**
	 * RefPrefix accessor method.
	 * 
	 * @return the refPrefix
	 */
	public String getRefPrefix() {
		return refPrefix;
	}

	/**
	 * RefPrefix mutator method.
	 * 
	 * @param refPrefix
	 *            the new refPrefix
	 */
	public void setRefPrefix(String refPrefix) {
		this.refPrefix = refPrefix;
	}

	/**
	 * Device mutator method.
	 * 
	 * @param device
	 *            the new DeviceNode
	 */
	public void setDevice(Device device) {
		this.device = device;
		this.device.addInstance(this);
	}

	/**
	 * Device accessor method.
	 * 
	 * @return the DeviceNode
	 */
	public Device getDevice() {
		return device;
	}

	@Override
	/**
	 * Type accessor method.
	 * 
	 * @return NodeType.INSTANCE
	 */
	public NodeType getNodeType() {
		return NodeType.INSTANCE;
	}

	@Override
	/**
	 * Generic toString method.
	 * 
	 * @return			a string representation
	 */
	public String toString() {
		return super.toString() + " : " + getDevice().getName()
				+ (refDes != null ? (" " + refDes) : "")
				+ (groupName != null ? (" " + groupName) : "");
	}

	/**
	 * Returns a list of PinNodes with the same name as the name passed in. Valid names are an exact
	 * match (suffix length is zero), or those that are suffixed by an array index (the start of
	 * which is marked by an open parentheses character.)
	 * 
	 * @param pinName
	 * @return The list of pin nodes with the same name as pinName.
	 */
	public List<Pin> getAllPins(String pinName) {
		List<Pin> allPins = new ArrayList<Pin>();
		for (int i = 0; i < pins.size(); i++) {
			if (pins.get(i).getName().length() < pinName.length())
				continue;
			String prefix = pins.get(i).getName().substring(0, pinName.length());
			if (prefix.equals(pinName)) {
				String suffix = pins.get(i).getName().substring(pinName.length());
				if (suffix.length() == 0 || suffix.charAt(0) == '[') {
					allPins.add(pins.get(i));
				}
			}
		}
		return allPins;
	}

	/**
	 * Single pin accessor method.
	 * 
	 * @param s
	 *            the name of the pin
	 * @return the PinNode with that name
	 */
	public Pin getPin(String s) {
		for (Pin p : pins) {
			if (p.getName().equals(s))
				return p;
		}
		return null;
	}

	/**
	 * Finds all PinNodes with the pinName as the base name and returns a List of their indices.
	 * 
	 * The base name of a pin is the name without any array references. For example, "my_pin(7)" is
	 * a pin name, and "my_pin" is its base name.
	 * 
	 * @param pinName
	 *            the base name of the pin
	 * @return a List of indices of pins with the base name
	 */
	public List<Integer> getAllIndices(String pinName) {
		List<Integer> allIndices = new ArrayList<Integer>();
		for (Pin p : getAllPins(pinName)) {
			int start = p.getName().indexOf('[');
			int end = p.getName().indexOf(']');
			if (start != -1 && end != -1) {
				String index = p.getName().substring(start + 1, end);
				allIndices.add(Integer.parseInt(index));
			}
		}
		return allIndices;
	}

	/**
	 * Returns the index of the current Instance, assuming that it has an array reference.
	 * 
	 * @return the index of the Instance
	 */
	public int findIndex() {
		int start = getName().indexOf('(');
		int end = getName().indexOf(')');

		if (start == -1 || end == -1) {
			return -1;
		}

		String index = getName().substring(start + 1, end);
		return Integer.parseInt(index);
	}

	/**
	 * Footprint accessor method.
	 * 
	 * @return the footprint attribute
	 */
	public String getFootprint() {
		return footprint;
	}

	/**
	 * Footprint mutator method.
	 * 
	 * @param footprint
	 *            the new footprint attribute
	 */
	public void setFootprint(String footprint) {
		this.footprint = footprint;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	@Override
	public boolean equals(Object o) {
		return this.name.equals(((Instance) o).getName())
				&& this.index == ((Instance) o).getIndex();
	}
}
