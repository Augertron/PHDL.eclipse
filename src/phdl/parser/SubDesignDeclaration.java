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
 * A class that represents a sub-design declaration in phdl. A sub-design
 * declaration (of a design) has a set of ports.
 * 
 * @author Richard Black and Brad Riching
 * 
 */
public class SubDesignDeclaration extends ReferenceDeclaration {

	/**
	 * The sub-design's set of port assignments
	 */
	public HashSet<PortAssignment> portAssigns;

	/**
	 * Default constructor
	 */
	public SubDesignDeclaration() {
		super();
		this.portAssigns = new HashSet<PortAssignment>();
	}

	/**
	 * Gets the sub-design's set of port assignments
	 * 
	 * @return The sub-design's set of port assignments
	 */
	public HashSet<PortAssignment> getPortAssignments() {
		return portAssigns;
	}

	/**
	 * Adds a port assignment to the sub-design's set of port assignments
	 * 
	 * @param p
	 *            The port assignment to add
	 * @return True if the port assignment was added successfully
	 */
	public boolean addPortAssignment(PortAssignment p) {
		boolean added = portAssigns.add(p);
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
		return name.equals(((SubDesignDeclaration) o).getName())
				&& msb == ((SubDesignDeclaration) o).getMsb()
				&& lsb == ((SubDesignDeclaration) o).getLsb();
	}

	/**
	 * Returns a formatted string representation of the sub-design declaration
	 */
	@Override
	public String toString() {
		String header = "SubDesignDecl " + getLineString() + " " + name + ":"
				+ getRefName() + "\n";
		String ports = "";

		for (PortAssignment p : portAssigns)
			ports += "\t\t" + p.toString();

		return header + ports;
	}
}
