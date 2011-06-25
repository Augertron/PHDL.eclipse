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
 * A class that represents a net declaration in phdl. In addition to the
 * inherited fields, a net declaration has a set of net-attributes.
 * 
 * @author Richard Black and Brad Riching
 * 
 */
public class NetDecl extends ArrayDecl {

	/**
	 * The net's set of attributes
	 */
	protected HashSet<String> attributes;

	/**
	 * Default constructor
	 */
	public NetDecl() {
		super();
		this.attributes = new HashSet<String>();
	}

	/**
	 * Gets the net's set of attributes
	 * 
	 * @return The net's set of attributes
	 */
	public HashSet<String> getAttributes() {
		return attributes;
	}

	/**
	 * Adds an attribute to the net's set of attributes
	 * 
	 * @param a
	 *            The attribute to add
	 * @return True if the attribute was added successfully
	 */
	public boolean addAttribute(String a) {
		boolean added = this.attributes.add(a);
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
		return name.equals(((NetDecl) o).getName())
				&& msb == ((NetDecl) o).getMsb()
				&& lsb == ((NetDecl) o).getLsb();
	}

	/**
	 * Returns a formatted string representation of the net declaration
	 */
	@Override
	public String toString() {
		String netString = "";

		for (String n : attributes) {
			netString += n + " ";
		}
		netString += "\n";

		return "NetDecl " + getLocation() + " : " + name + getWidthString()
				+ ": " + netString;
	}
}
