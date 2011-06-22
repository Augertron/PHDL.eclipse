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

/**
 * A class that represents an instance declaration in phdl. An instance
 * declaration (of a device) has a set of attributes, and pin assignments.
 * 
 * @author Richard Black and Brad Riching
 */
public class InstanceDeclaration extends ReferenceDeclaration {

	/**
	 * The instance's set of attribute assignments
	 */
	protected HashSet<AttributeAssignment> attrAssigns;
	/**
	 * The instance's set of pin assignments
	 */
	protected HashSet<PinAssignment> pinAssigs;

	/**
	 * Default constructor
	 */
	public InstanceDeclaration() {
		super();
		this.attrAssigns = new HashSet<AttributeAssignment>();
		this.pinAssigs = new HashSet<PinAssignment>();
	}

	/**
	 * Gets the instance's set of attribute assignments
	 * 
	 * @return The instance's set of attribute assignments
	 */
	public HashSet<AttributeAssignment> getAttributeAssignments() {
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
	public boolean addAttributeAssignment(AttributeAssignment a) {
		boolean added = attrAssigns.add(a);
		return added;
	}

	/**
	 * Get's the instance's set of pin assignments
	 * 
	 * @return The instance's set of pin assignments
	 */
	public HashSet<PinAssignment> getPinAssignments() {
		return pinAssigs;
	}

	/**
	 * Adds a pin assignment to the instance's set of pin assignments
	 * 
	 * @param p
	 *            The pin assignment to add
	 * @return True if the pin assignment was added successfully
	 */
	public boolean addPinAssignment(PinAssignment p) {
		boolean added = pinAssigs.add(p);
		return added;
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
		return name.equals(((InstanceDeclaration) o).getName())
				&& msb == ((InstanceDeclaration) o).getMsb()
				&& lsb == ((InstanceDeclaration) o).getLsb();
	}

	/**
	 * Returns a formatted string representation of the instance declaration
	 */
	@Override
	public String toString() {
		String header = "InstanceDecl " + getLineString() + " " + name + ":"
				+ getRefName() + "\n";
		String attributes = "";
		String pins = "";

		// loop through all attribute assignments
		for (AttributeAssignment a : attrAssigns)
			attributes += "\t\t" + a.toString();

		// loop through all pin assignments
		for (PinAssignment p : pinAssigs)
			pins += "\t\t" + p.toString();

		return header + attributes + pins;
	}
}
