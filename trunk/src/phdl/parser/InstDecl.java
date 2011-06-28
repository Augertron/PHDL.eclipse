/*
 * Copyright (C) 2011 BYU Configurable Computing Lab
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */

package phdl.parser;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * A class that represents an instance declaration in phdl. An instance
 * declaration (of a device) has a set of attributes, and pin assignments.
 * 
 * @author Richard Black and Brad Riching
 */
public class InstDecl extends RefDecl {

	/**
	 * The instance's set of attribute assignments
	 */
	protected Set<AttrAssign> attrAssigns;
	/**
	 * The instance's set of pin assignments
	 */
	protected Set<PinAssign> pinAssigs;

	/**
	 * Default constructor
	 */
	public InstDecl() {
		super();
		this.attrAssigns = new HashSet<AttrAssign>();
		this.pinAssigs = new HashSet<PinAssign>();
		this.indices = new LinkedList<Integer>();
	}

	/**
	 * Gets the instance's set of attribute assignments
	 * 
	 * @return The instance's set of attribute assignments
	 */
	public Set<AttrAssign> getAttrAssigns() {
		return attrAssigns;
	}

	/**
	 * Adds an attribute assignment to the instance's set of attribute
	 * assignments
	 * 
	 * @param a
	 *            The attribute assignment to add
	 * @return True if the attribute assignment was added successfully
	 */
	public boolean addAttrAssign(AttrAssign a) {
		return attrAssigns.add(a);
	}

	/**
	 * Get's the instance's set of pin assignments
	 * 
	 * @return The instance's set of pin assignments
	 */
	public Set<PinAssign> getPinAssigns() {
		return pinAssigs;
	}

	/**
	 * Adds a pin assignment to the instance's set of pin assignments
	 * 
	 * @param p
	 *            The pin assignment to add
	 * @return True if the pin assignment was added successfully
	 */
	public boolean addPinAssign(PinAssign p) {
		return pinAssigs.add(p);
	}

	/**
	 * Defines overridden hashCode method
	 */
	@Override
	public int hashCode() {
		return name.hashCode();
	}

	/**
	 * Defines overridden equals method
	 */
	@Override
	public boolean equals(Object o) {
		return name.equals(((InstDecl) o).getName());
	}

	/**
	 * Returns a formatted string representation of the instance declaration
	 */
	@Override
	public String toString() {
		String header = "InstanceDecl " + getLocation() + " " + name + ":"
				+ getRefName() + getArrayString() + "\n";
		String attributes = "";
		String pins = "";

		// loop through all attribute assignments
		for (AttrAssign a : attrAssigns)
			attributes += "\t\t" + a.toString();

		// loop through all pin assignments
		for (PinAssign p : pinAssigs)
			pins += "\t\t" + p.toString();

		return header + attributes + pins;
	}

}
