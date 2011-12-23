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
import java.util.Set;
import java.util.TreeSet;

/**
 * A class that represents a device in PHDL.
 * 
 * @author Brad Riching and Richard Black
 * @version 0.1
 */
public class DeviceNode extends Attributable {

	private List<PinNode> pins;
	private Set<InstanceNode> instances;

	/**
	 * Default Constructor.
	 * 
	 * @param design
	 *            the parent DesignNode for this Device
	 * 
	 * @see DesignNode
	 * @see AttributeNode
	 * @see PinNode
	 * @see InstanceNode
	 */
	public DeviceNode(DesignNode design) {
		pins = new ArrayList<PinNode>();
		instances = new TreeSet<InstanceNode>();
	}

	public DeviceNode(String name) {
		this.name = name;
		pins = new ArrayList<PinNode>();
		instances = new TreeSet<InstanceNode>();
	}

	/**
	 * Instance Set accessor method
	 * 
	 * @return the set of all InstanceNodes connected to this device
	 */
	public Set<InstanceNode> getInstances() {
		return instances;
	}

	/**
	 * Instance Set addition method
	 * 
	 * @param instance
	 *            the InstanceNode to be added
	 * @return true, if the instance isn't already in the set false, otherwise
	 */
	public boolean addInstance(InstanceNode instance) {
		return instances.add(instance);
	}

	@Override
	/**
	 * Type accessor method.
	 * 
	 * @return NodeType.DEVICE
	 */
	public NodeType getType() {
		return NodeType.DEVICE;
	}

	/**
	 * Pins accessor method.
	 * 
	 * @return a list of PinNodes attached to this Device.
	 */
	public List<PinNode> getPins() {
		return pins;
	}

	/**
	 * Individual Pin Accessor method.
	 * 
	 * 
	 */
	public PinNode getPin(String pinName) {
		for (PinNode p : pins) {
			if (p.getName().equals(pinName)) {
				return p;
			}
		}
		return null;
	}

	/**
	 * Pin addition method.
	 * 
	 * @param p
	 *            the new PinNode
	 * @return true, if the pin wasn't already in the List false, otherwise
	 */
	public boolean addPin(PinNode p) {
		return pins.add(p);
	}

	/**
	 * Checks to see if the device has any pins attached.
	 * 
	 * @return true, if there are pins false, otherwise
	 */
	public boolean hasPins() {
		return (!pins.isEmpty());
	}

	/**
	 * Single AttributeNode accessor method.
	 * 
	 * @param s
	 *            the name of the attribute
	 * @return the AttributeNode with that name
	 */
	public AttributeNode getAttribute(String s) {
		for (AttributeNode a : attributes) {
			if (a.getName().equals(s))
				return a;
		}
		return null;
	}
}
