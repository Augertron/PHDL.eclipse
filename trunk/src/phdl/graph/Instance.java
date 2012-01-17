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

	private final List<Pin> pins;
	private DesignUnit parent;
	private Device device;
	private String refDes;
	private String refPrefix;
	private String pkg;
	private String groupName;
	private int index = -1;;

	/**
	 * Default Constructor.
	 * 
	 * @param parent
	 *            the parent DesignUnit for this instance
	 * @see Design
	 * @see Device
	 * @see Pin
	 */
	public Instance(DesignUnit parent) {
		super();
		this.parent = parent;
		this.pins = new ArrayList<Pin>();
		this.refDes = null;
		this.refPrefix = null;
		this.pkg = null;
		this.groupName = null;
	}

	/**
	 * Copy Constructor from a Device
	 * @param parent 
	 * 		the parent DesignUnit for this instance
	 * @param old 
	 * 		the Device that this instance is based off of
	 * @param name 
	 * 		the name of this instance
	 */
	public Instance(DesignUnit parent, Device old, String name) {
		super(old);
		this.pins = new ArrayList<Pin>();
		this.parent = parent;
		this.name = name;
		setDevice(old);
		for (Pin p : old.getPins())
			this.pins.add(new Pin(this, p));
	}

	/**
	 * Copy Constructor from another Instance
	 * @param parent
	 * 		the parent DesignUnit for this instance
	 * @param old
	 * 		the instance that this instance is based off of
	 */
	public Instance(DesignUnit parent, Instance old) {
		super(old);
		this.pins = new ArrayList<Pin>();
		this.parent = parent;
		this.name = old.getName();
		this.index = old.getIndex();
		this.pkg = old.getPackage();
		this.groupName = old.getGroupName();
		setDevice(old.getDevice());
		for (Pin p : old.getPins())
			this.pins.add(new Pin(this, p));
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

	@Override
	public boolean equals(Object o) {
		return this.name.equals(((Instance) o).getName())
			&& this.index == ((Instance) o).getIndex();
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
	 * Returns a list of PinNodes with the same name as the name passed in. Valid names are an exact
	 * match (suffix length is zero), or those that are suffixed by an array index (the start of
	 * which is marked by an open parentheses character.)
	 * 
	 * @param pinName
	 * @return The list of pin nodes with the same name as pinName.
	 */
	public List<Pin> getAllPins(String name) {
		List<Pin> allPins = new ArrayList<Pin>();
		for (Pin p : pins)
			if (p.getName().equals(name))
				allPins.add(p);
		return allPins;
	}

	/**
	 * Device accessor method.
	 * 
	 * @return the DeviceNode
	 */
	public Device getDevice() {
		return device;
	}

	public String getGroupName() {
		return groupName;
	}

	public int getIndex() {
		return index;
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

	/**
	 * Package accessor method.
	 * 
	 * @return the package attribute
	 */
	public String getPackage() {
		return pkg;
	}

	/**
	 * Design accessor method.
	 * 
	 * @return the DesignNode attached to this Device
	 */
	public DesignUnit getParent() {
		return parent;
	}

	/**
	 * Single pin accessor method.
	 * 
	 * @param name
	 *            the name of the pin
	 * @return the PinNode with that name
	 */
	public Pin getPin(String name) {
		for (Pin p : pins)
			if (p.getName().equals(name))
				return p;
		return null;
	}

	public Pin getPin(String name, int index) {
		for (Pin p : pins)
			if (p.getName().equals(name) && p.getIndex() == index)
				return p;
		return null;
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
	 * RefDes accessor method.
	 * 
	 * @return the refDes
	 */
	public String getRefDes() {
		return refDes;
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
	 * Checks to see if there are any pins in the Instance.
	 * 
	 * @return true, if there are pins false, otherwise
	 */
	public boolean hasPins() {
		return (!pins.isEmpty());
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

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * Package mutator method.
	 * 
	 * @param footprint
	 *            the new package attribute
	 */
	public void setPackage(String pkg) {
		this.pkg = pkg;
	}

	/**
	 * Design mutator method.
	 * 
	 * @param parent
	 *            the new DesignNode
	 */
	public void setParent(Design parent) {
		this.parent = parent;
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
	 * RefPrefix mutator method.
	 * 
	 * @param refPrefix
	 *            the new refPrefix
	 */
	public void setRefPrefix(String refPrefix) {
		this.refPrefix = refPrefix;
	}

	@Override
	/**
	 * Generic toString method.
	 * 
	 * @return			a string representation
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		String fieldFmtStr = "  %-8s%2s%-26.26s\n";
		String attrFmtStr = "  %4d%2s%-16.16s%2s%-24.24s%2s%-4s\n";
		String pinFmtStr = "  %4d%2s%-8.8s%2s%-16.16s%2s%-20.20s\n";

		String idx = (getIndex() == -1) ? "" : ("(" + getIndex() + ")");
		sb.append(String.format(fieldFmtStr, "Name:", "", getName() + idx));
		sb.append(String.format(fieldFmtStr, "Parent:", "", getParent().getName()));
		sb.append("\n");

		if (!getAttributes().isEmpty()) {
			sb.append("  Attr        Name                 Value            o/w?  \n");
			sb.append("  ----  ----------------  ------------------------  ----  \n");
			int attrCount = 1;
			for (Attribute a : getAttributes()) {
				sb.append(String.format(attrFmtStr, attrCount, "  ", a.getName(), "  ", a
					.getValue().equals("") ? "(empty)" : a.getValue(), "  ",
					a.isOverwritten() ? "yes" : "no"));
				attrCount++;
			}
		}
		sb.append("\n");

		if (!getPins().isEmpty()) {
			sb.append("  Pin     Type          Name             Connection       \n");
			sb.append("  ----  --------  ----------------  --------------------  \n");
			int pinCount = 1;
			for (Pin p : getPins()) {
				String index = (p.getIndex() != -1 ? ("[" + p.getIndex() + "]") : "");
				String connection = "";
				if (p.hasConnection()) {
					connection = p.getConnection().getNodeType() + ": "
						+ p.getConnection().getName();
					if (p.getConnection().getIndex() != -1)
						connection += "[" + p.getConnection().getIndex() + "]";
				} else if (p.isOpen())
					connection += "OPEN";
				else
					connection += "(not assigned)";
				sb.append(String.format(pinFmtStr, pinCount, "  ", p.getPinType(), "  ",
					p.getName() + index, "  ", connection));
				pinCount++;
			}
			sb.append("\n");

			if (!getInfo().equals("")) {
				int lineLength = 60;
				sb.append("  Info\n");
				sb.append("  ----\n");
				String info = getInfo();
				String[] infos = info.split("\\s+");
				StringBuilder line = new StringBuilder();
				line.append("  ");
				for (int j = 0; j < infos.length; j++) {
					if (line.length() < lineLength) {
						line.append(infos[j] + " ");
						if (j == infos.length - 1)
							sb.append(line.toString() + "\n");
					} else {
						j--;
						sb.append(line.toString() + "\n");
						line.setLength(0);
						line.append("  ");
					}
				}
				sb.append("\n");
			}
		}
		return sb.toString();
	}
}
