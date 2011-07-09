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

/**
 * A class that represents an attribute declaration in phdl. In addition to
 * inherited fields, an attribute assignment has a value.
 * 
 * @author Richard Black and Brad Riching
 */
public class AttrDecl extends Parsable {

	/**
	 * The attribute's value
	 */
	protected String value;

	/**
	 * Default constructor
	 */
	public AttrDecl() {
		super();
	}

	/**
	 * Gets the attribute's value
	 * 
	 * @return The attribute's value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the attribute's value
	 * 
	 * @param value
	 *            The attribute's value
	 */
	public void setValue(String value) {
		this.value = value.toUpperCase();
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
		return name.equals(((AttrDecl) o).getName());
	}

	/**
	 * Returns a formatted string representation of the attribute declaration
	 */
	@Override
	public String toString() {
		return "AttrDecl " + getLocation() + " : " + name + " = " + value
				+ "\n";
	}

	/**
	 * Attribute names must all be upper-case
	 */
	@Override
	public void setName(String name) {
		this.name = name.toUpperCase();
	}
}