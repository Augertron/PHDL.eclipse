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
public class Device extends Attributable {

	private List<Pin> pins;
	private Set<Instance> instances;

	/**
	 * Default Constructor.
	 * 
	 * @param design
	 *            the parent DesignNode for this Device
	 * 
	 * @see Design
	 * @see Attribute
	 * @see Pin
	 * @see Instance
	 */
	public Device(Design design) {
		pins = new ArrayList<Pin>();
		instances = new TreeSet<Instance>();
	}

	public Device(String name) {
		this.name = name;
		pins = new ArrayList<Pin>();
		instances = new TreeSet<Instance>();
	}

	/**
	 * Instance Set addition method
	 * 
	 * @param instance
	 *            the InstanceNode to be added
	 * @return true, if the instance isn't already in the set false, otherwise
	 */
	public boolean addInstance(Instance instance) {
		return instances.add(instance);
	}

	/**
	 * Pin addition method.
	 * 
	 * @param p
	 *            the new PinNode
	 * @return true, if the pin wasn't already in the List false, otherwise
	 */
	public boolean addPin(Pin p) {
		return pins.add(p);
	}

	/**
	 * Instance Set accessor method
	 * 
	 * @return the set of all InstanceNodes connected to this device
	 */
	public Set<Instance> getInstances() {
		return instances;
	}

	/**
	 * Individual Pin Accessor method.
	 * 
	 * 
	 */
	public Pin getPin(String pinName) {
		for (Pin p : pins) {
			if (p.getName().equals(pinName)) {
				return p;
			}
		}
		return null;
	}

	/**
	 * Pins accessor method.
	 * 
	 * @return a list of PinNodes attached to this Device.
	 */
	public List<Pin> getPins() {
		return pins;
	}

	@Override
	/**
	 * Type accessor method.
	 * 
	 * @return NodeType.DEVICE
	 */
	public NodeType getNodeType() {
		return NodeType.DEVICE;
	}

	/**
	 * Checks to see if the device has any pins attached.
	 * 
	 * @return true, if there are pins false, otherwise
	 */
	public boolean hasPins() {
		return (!pins.isEmpty());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		for (Attribute a : attributes)
			sb.append("\t" + a.toString() + "\n");
		for (Pin p : pins)
			sb.append("\t" + p.toString() + "\n");
		return sb.toString();
	}
}
