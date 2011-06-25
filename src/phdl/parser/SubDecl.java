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
import java.util.Set;

/**
 * A class that represents a sub-design declaration in phdl. A sub-design
 * declaration (of a design) has a set of ports.
 * 
 * @author Richard Black and Brad Riching
 * 
 */
public class SubDecl extends RefDecl {

	/**
	 * The sub-design's set of port assignments
	 */
	public Set<PortAssign> portAssigns;

	/**
	 * The sub-design's set of attribute assignments
	 */
	public Set<SubAttrAssign> attrAssigns;

	/**
	 * Default constructor
	 */
	public SubDecl() {
		super();
		this.portAssigns = new HashSet<PortAssign>();
		this.attrAssigns = new HashSet<SubAttrAssign>();
	}

	/**
	 * Gets the sub-design's set of port assignments
	 * 
	 * @return The sub-design's set of port assignments
	 */
	public Set<PortAssign> getPortAssigns() {
		return portAssigns;
	}

	/**
	 * Adds a port assignment to the sub-design's set of port assignments
	 * 
	 * @param p
	 *            The port assignment to add
	 * @return True if the port assignment was added successfully
	 */
	public boolean addPortAssign(PortAssign p) {
		return portAssigns.add(p);
	}

	public boolean addSubAttrAssign(SubAttrAssign a) {
		return attrAssigns.add(a);
	}

	public Set<SubAttrAssign> getSubAttrAssigns() {
		return attrAssigns;
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
		return name.equals(((SubDecl) o).getName())
				&& msb == ((SubDecl) o).getMsb()
				&& lsb == ((SubDecl) o).getLsb();
	}

	/**
	 * Returns a formatted string representation of the sub-design declaration
	 */
	@Override
	public String toString() {
		String header = "SubDesignDecl " + getLocation() + " " + name + ":"
				+ getRefName() + "\n";

		String attrs = "";
		String ports = "";

		for (SubAttrAssign s : attrAssigns)
			attrs += "\t\t" + s.toString();

		for (PortAssign p : portAssigns)
			ports += "\t\t" + p.toString();

		return header + attrs + ports;
	}
}
