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

	private Set<AttributeNode> attributes;
	private List<PinNode> pins;
	private Set<InstanceNode> instances;
	private DesignNode design;

	/**
	 * Default Constructor.
	 * 
	 * @param design	the parent DesignNode for this Device
	 *
	 * @see DesignNode
	 * @see AttributeNode
	 * @see PinNode
	 * @see InstanceNode
	 */
	public DeviceNode(DesignNode design) {
		setDesign(design);
		attributes = new TreeSet<AttributeNode>();
		pins = new ArrayList<PinNode>();
		instances = new TreeSet<InstanceNode>();
	}

	/**
	 * Instance Set accessor method
	 * 
	 * @return 			the set of all InstanceNodes
	 * 					connected to this device
	 */
	public Set<InstanceNode> getInstances() {
		return instances;
	}

	/**
	 * Instance Set addition method
	 * 
	 * @param instance	the InstanceNode to be added
	 * @return 			true, if the instance isn't
	 * 						already in the set
	 * 					false, otherwise
	 */
	public boolean addInstance(InstanceNode instance) {
		return instances.add(instance);
	}

	/**
	 * Design accessor method.
	 * 
	 * @return 			the DesignNode attached to this
	 * 					Device
	 */
	public DesignNode getDesign() {
		return design;
	}

	/**
	 * Design mutator method.
	 * 
	 * @param design	the new DesignNode
	 */
	public void setDesign(DesignNode design) {
		this.design = design;
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
	 * @return			a list of PinNodes attached
	 * 					to this Device.
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
	 * @param p			the new PinNode
	 * @return			true, if the pin wasn't already
	 * 						in the List
	 * 					false, otherwise
	 */
	public boolean addPin(PinNode p) {
		return pins.add(p);
	}

	/**
	 * Checks to see if the device has any pins attached.
	 * 
	 * @return			true, if there are pins
	 * 					false, otherwise
	 */
	public boolean hasPins() {
		return (!pins.isEmpty());
	}

	/**
	 * Attribute addition method.
	 * 
	 * @param a			the new AttributeNode
	 * @return			true, if the attribute wasn't already
	 * 							in the Set
	 * 					false, otherwise
	 */
	public boolean addAttribute(AttributeNode a) {
		return attributes.add(a);
	}

	@Override
	/**
	 * Attribute Set accessor method.
	 * 
	 * @return the Set of all AttributeNodes
	 */
	public Set<AttributeNode> getAttributes() {
		return attributes;
	}

	/**
	 * Single AttributeNode accessor method.
	 * 
	 * @param s			the name of the attribute
	 * @return			the AttributeNode with that name
	 */
	public AttributeNode getAttribute(String s) {
		for (AttributeNode a : attributes) {
			if (a.getName().equals(s))
				return a;
		}
		return null;
	}
}
