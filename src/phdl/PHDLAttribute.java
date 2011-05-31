/*
    Copyright (C) 2011  BYU Configurable Computing Lab

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package phdl;

/**
 *	A class that stores a name and value.
 *
 *	For example the line of code: 'tolerance = "5%";'
 *  would translate to name = "tolerance" and value = "5%"
 *  
 *  @author		Richard Black and Brad Riching
 *  @version	0.1
 */
public class PHDLAttribute {
	/**
	 *	Contains the attribute's name 
	 */
	private String name;
	/**
	 *	Contains the attribute's value 
	 */
	private String value;

	/**
	 *	Default Constructor.
	 *
	 *	Sets the name and value of the attribute
	 *
	 *	@param name	the name of the new attribute
	 *	@param name the value of the new attribute
	 */
	public PHDLAttribute(String name, String value) {
		this.name = name;
		this.value = value;
	}

	/**
	 * Returns the name of the attribute.
	 * 
	 * Attribute name accessor method
	 * 
	 * @return 	a string representation of the attribute's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the attribute.
	 * 
	 * Attribute name mutator method
	 * 
	 * @param name	the new name of attribute
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the value of the attribute.
	 * 
	 * Attribute value accessor method
	 * 
	 * @return	a string representation of the current
	 * 			value of the attribute
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Changes the current value of the attribute.
	 * 
	 * Attribute value mutator method
	 * 
	 * @param value	the new value of the attribute
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	/**
	 * Creates a hash code for use in hash data structures.
	 * 
	 * hashCode method to make attributes compatible with hashMaps
	 * and hashSets
	 * 
	 * @return	an integer representing a hash code
	 */
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		PHDLAttribute a = (PHDLAttribute)o;
		return (a.getName().equals(name) && a.getValue().equals(value));
	}
	
	public static boolean unitTest() {
		/* 
		 * Methods Tested
		 *********************
		 * getName			X
		 * getValue			X
		 * setName			X
		 * setValue			X
		 */
		boolean success = true;
		PHDLAttribute attr1 = new PHDLAttribute("name1", "value1");
		if (!attr1.getName().equals("name1")) {
			success = false;
			TestDriver.err("getName()", "name1", attr1.getName());
		}
		if (!attr1.getValue().equals("value1")) {
			success = false;
			TestDriver.err("getValue()", "value1", attr1.getValue());
		}
		attr1.setName("newName");
		attr1.setValue("newValue");
		if (!attr1.getName().equals("newName")) {
			success = false;
			TestDriver.err("setName()", "newName", attr1.getName());
		}
		if (!attr1.getValue().equals("newValue")) {
			success = false;
			TestDriver.err("setValue()", "newValue", attr1.getValue());
		}
		return success;
	}

}
