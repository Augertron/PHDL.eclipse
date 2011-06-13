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
public class NetDeclaration extends ArrayDeclaration {

	/**
	 * The net's set of attributes
	 */
	protected HashSet<String> attributes;

	/**
	 * Default constructor
	 */
	public NetDeclaration() {
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
	 */
	public void addAttribute(String a) {
		this.attributes.add(a);
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

		return "NetDecl" + getLocString() + ": " + name + getWidthString()
				+ ": " + netString;
	}
}
