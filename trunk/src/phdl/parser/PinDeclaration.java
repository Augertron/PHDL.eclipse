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

import java.util.HashMap;
import java.util.HashSet;

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
	 * The pin declaration's pin index to pin number mapping
	 */
	protected HashMap<Integer, String> indexMap;

	/**
	 * The pin declaration's pin number set to check for duplicates
	 */
	protected HashSet<String> numberSet;

	/**
	 * Default constructor
	 * 
	 * @param type
	 */
	public PinDeclaration(Type type) {
		super();
		this.type = type;
		this.indexMap = new HashMap<Integer, String>();
		this.numberSet = new HashSet<String>();
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
	 * 
	 * @param i
	 *            The index of the pin declaration
	 * @return The pin number contained in the pin map corresponding to that
	 *         index if it exists, otherwise null.
	 */
	public String getPinNumber(int i) {
		if (indexMap.containsKey(i)) {
			return indexMap.get(i);
		} else {
			return null;
		}
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
		String sPinMap = "";
		for (Integer i : indexMap.keySet()) {
			sPinMap += name + "(" + i + ")." + indexMap.get(i) + ", ";
		}
		// remove the last comma in the string
		sPinMap = sPinMap.substring(0, sPinMap.length() - 2);

		return "PinDecl " + getLineString() + " : " + type.toString() + " {"
				+ sPinMap + "}\n";
	}

	/**
	 * Creates a mapping from the pin name to the pin number according to the
	 * pin's msb, lsb, index, and pinList information.
	 * 
	 * @return True if the mapping was completed successfully, false otherwise
	 */
	public boolean pinMap() {
		// break apart the pin list into integers by splitting on
		// all whitespace, commas, and semicolons
		String[] pinNumbers = pinList.split("[\\s,;]");

		// add the pin numbers to a set to check for duplicates
		boolean added;
		for (int i = 0; i < pinNumbers.length; i++) {
			added = false;
			added = numberSet.add(pinNumbers[i]);
			if (!added)
				return false;
		}

		// assume the pin has a width of one but modify it if both msb and lsb
		// have been declared
		int width = 1;
		if (msb != -1 && lsb != -1)
			width = Math.abs(msb - lsb) + 1;

		// check that the available width of the pin name differs from the
		// number of pins in the comma-separated pin list
		if (width != pinNumbers.length) {
			return false;
		}

		// perform the mapping based on the direction of the array declaration
		if (msb < lsb) {
			for (int i = msb; i <= lsb; i++)
				indexMap.put(i, pinNumbers[i - msb]);
		} else if (msb > lsb) {
			for (int i = msb; i >= lsb; i--)
				indexMap.put(i, pinNumbers[msb - i]);

			// the case of a single pin and number
		} else if (msb == lsb) {
			indexMap.put(0, pinNumbers[0]);
		}
		return true;
	}

}
