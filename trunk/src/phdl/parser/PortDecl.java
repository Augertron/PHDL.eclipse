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
 * A class that represents a port declaration in phdl. In addition to inherited
 * fields, a port declaration has a type.
 * 
 * @author Richard Black and Brad Riching
 */
public class PortDecl extends Sliced {

	/**
	 * The type of the port assignment
	 */
	protected Type type;

	/**
	 * Default constructor
	 * 
	 * @param type
	 *            The type of the port assignment
	 */
	public PortDecl(Type type) {
		super();
		this.type = type;
	}

	/**
	 * Gets the port assignment's type
	 * 
	 * @return The port assignment's type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * Sets the port assignment's type
	 * 
	 * @param type
	 */
	public void setType(Type type) {
		this.type = type;
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
		return name.equals(((PortDecl) o).getName());

	}

	/**
	 * Returns a formatted string representation of the port declaration
	 */
	@Override
	public String toString() {
		return "PortDecl " + getLocation() + " : " + type.toString() + " "
				+ name + "\n";
	}

}
