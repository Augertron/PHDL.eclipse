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
 * A class that represents a device declaration in phdl. In addition to
 * inherited fields, a device declaration has set of attribute declarations and
 * a set of pin declarations.
 * 
 * @author Richard Black and Brad Riching
 * 
 */
public class DeviceDeclaration extends Declarable {

	/**
	 * The device declaration's set of attribute declarations
	 */
	protected HashSet<AttributeDeclaration> attributeDecls;

	/**
	 * the device declaration's set of pin declarations
	 */
	protected HashSet<PinDeclaration> pinDecls;

	/**
	 * Default constructor
	 */
	public DeviceDeclaration() {
		super();
		this.attributeDecls = new HashSet<AttributeDeclaration>();
		this.pinDecls = new HashSet<PinDeclaration>();
	}

	/**
	 * Gets this device declaration's set of attribute declarations
	 * 
	 * @return This device declaration's set of attribute declarations
	 */
	public HashSet<AttributeDeclaration> getAttributeDecls() {
		return attributeDecls;
	}

	/**
	 * Adds an attribute declaration to this device declaration's set of
	 * attribute declarations
	 * 
	 * @param a
	 *            The attribute declaration to add
	 */
	public void addAttributeDecl(AttributeDeclaration a) {
		attributeDecls.add(a);
	}

	/**
	 * Gets this device declaration's set of pin declarations
	 * 
	 * @return This device declaration's set of pin declarations
	 */
	public HashSet<PinDeclaration> getPinDecls() {
		return pinDecls;
	}

	/**
	 * Adds a pin declaration to this device declaration's set of pin
	 * declarations
	 * 
	 * @param p
	 *            The pin declaration to add
	 */
	public void addPinDecl(PinDeclaration p) {
		pinDecls.add(p);
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
		return name.equals(((DeviceDeclaration) o).getName());
	}

	/**
	 * Returns a formatted string representation of the device declaration
	 */
	@Override
	public String toString() {
		String header = "DeviceDecl" + getLocString() + ": " + name + "\n";
		String attributes = "";
		String pins = "";

		// loop through all attribute declarations
		for (AttributeDeclaration a : attributeDecls)
			attributes += "\t\t" + a.toString();

		// loop through all pin declarations
		for (PinDeclaration p : pinDecls)
			pins += "\t\t" + p.toString();

		return header + attributes + pins;
	}

}
