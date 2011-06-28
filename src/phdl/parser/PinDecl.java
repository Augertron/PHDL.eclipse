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
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * A class that represents a pin declaration in phdl. In addition to inherited
 * fields, a pin declaration has a type, and a string containing a pin list.
 * 
 * @author Richard Black and Brad Riching
 */
public class PinDecl extends Sliced {

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
	protected Map<Integer, String> pinMap;

	/**
	 * Default constructor
	 * 
	 * @param type
	 */
	public PinDecl(Type type) {
		super();
		this.type = type;
		this.pinMap = new HashMap<Integer, String>();
		this.bits = new LinkedList<Integer>();
	}

	public PinDecl() {
		super();
		this.pinMap = new HashMap<Integer, String>();
		this.bits = new LinkedList<Integer>();
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
	 * Sets the pin assignment's pin list
	 * 
	 * @param pinList
	 *            The pin assignment's pin list
	 */
	public void setPinList(String pinList) {
		this.pinList = pinList;
	}

	public Map<Integer, String> getPinMap() {
		return pinMap;
	}

	/**
	 * 
	 * @param i
	 *            The index of the pin declaration
	 * @return The pin number contained in the pin map corresponding to that
	 *         index if it exists, otherwise null.
	 */
	public String getPinNumber(int i) {
		if (pinMap.containsKey(i)) {
			return pinMap.get(i);
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
		return name.equals(((PinDecl) o).getName());
	}

	/**
	 * Returns a formatted string representation of the pin declaration
	 */
	@Override
	public String toString() {
		String sPinMap = "";
		if (pinMap.keySet().size() > 1) {
			for (Integer i : pinMap.keySet()) {
				sPinMap += name + "[" + i + "]." + pinMap.get(i) + ", ";
			}
			// remove the last comma in the string
			sPinMap = sPinMap.substring(0, sPinMap.length() - 2);
		} else {
			for (Integer i : pinMap.keySet()) {
				sPinMap += name + "." + pinMap.get(i);
			}
		}

		String sliced = "";
		if (isVector())
			sliced += " (vector)";
		if (isBit())
			sliced += " (bit)";
		if (isArbitrary())
			sliced += " (arbitrary)";
		if (!isSliced())
			sliced += " (not sliced)";

		return "PinDecl " + getLocation() + " : " + type.toString() + " {"
				+ sPinMap + "}" + sliced + "\n";
	}

	/**
	 * Creates a mapping from the pin name to the pin number according to the
	 * pin's msb, lsb, index, and pinList information.
	 * 
	 * @return True if the mapping was completed successfully, false otherwise
	 */
	public boolean makePinMap() {
		pinMap.clear();
		String[] pinNumbers = pinList.split("[,\\s]");

		// check pin name width against number of pins in list
		if (getBitWidth() != pinNumbers.length) {
			return false;
		}

		Set<String> numberSet = new HashSet<String>();
		// add pin numbers to a set to check for duplicates
		for (int i = 0; i < pinNumbers.length; i++) {
			if (!numberSet.add(pinNumbers[i]))
				return false;
		}

		if (bits.size() > 0) {
			for (int i = 0; i < pinNumbers.length; i++) {
				pinMap.put(bits.get(i), pinNumbers[i]);
			}
		} else {
			pinMap.put(0, pinNumbers[0]);
		}

		// indicates a successful pin mapping
		return true;
	}

}
