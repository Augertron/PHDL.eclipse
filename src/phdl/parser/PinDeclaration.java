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
 * A class that represents a pin declaration in phdl. In addition to inherited
 * fields, a pin declaration has a type, and a string containing a pin list.
 * 
 * @author Richard Black and Brad Riching
 */
public class PinDeclaration extends ArrayDeclaration {

	/**
	 * The pin declaration's type
	 */
	protected Type type;
	/**
	 * The pin declaration's pin list
	 */
	protected String pinList;

	/**
	 * Default constructor
	 * 
	 * @param type
	 */
	public PinDeclaration(Type type) {
		super();
		this.type = type;
	}

	/**
	 * Gets the pin assignment's type
	 * 
	 * @return The pin assignment's type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * Set's the pin assignment's type
	 * 
	 * @param type
	 *            The pin assignment's type
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * Gets the pin assignment's pin list
	 * 
	 * @return The pin assignment's pin list
	 */
	public String getPinList() {
		return pinList;
	}

	/**
	 * Sets the pin assignment's pin list
	 * 
	 * @param pinList
	 *            The pin assignment's pin list
	 */
	public void setPinList(String pinList) {
		this.pinList = pinList;
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
		return name.equals(((PinDeclaration) o).getName());
	}

	/**
	 * Returns a formatted string representation of the pin declaration
	 */
	@Override
	public String toString() {
		return "PinDecl " + getLineString() + " : " + type.toString()
				+ getWidthString() + " " + name + " {" + pinList + "}" + "\n";
	}

}
