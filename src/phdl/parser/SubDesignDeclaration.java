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
public class SubDesignDeclaration extends InstanceDeclarations {

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
	 */
	public void addPortAssignment(PortAssignment p) {
		portAssigns.add(p);
	}

	/**
	 * Returns a formatted string representation of the sub-design declaration
	 */
	@Override
	public String toString() {
		String header = "SubDesignDecl" + getLocString() + ": " + name + "\n";
		String ports = "";

		for (PortAssignment p : portAssigns)
			ports += "\t\t" + p.toString();

		return header + ports;
	}
}
