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

import java.util.LinkedList;

/**
 * A class that represents a net assignment in phdl.
 * 
 * @author Richard Black and Brad Riching
 * 
 */
public class NetAssign extends Concatenated {

	/**
	 * Default constructor
	 */
	public NetAssign() {
		super();
		this.nets = new LinkedList<Net>();
		this.bits = new LinkedList<Integer>();
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
		return name.equals(((NetAssign) o).getName())
				&& bits.equals(((NetAssign) o).getBits());
	}

	/**
	 * Returns a formatted string representation of the net assignment
	 */
	@Override
	public String toString() {
		String netString = "";

		// show concatenations with an ampersand symbol
		if (!nets.isEmpty()) {
			for (Net n : nets)
				netString += n.toString() + " & ";
			// remove the last ampersand from the loop above
			netString = netString.substring(0, netString.length() - 3);

		} else {
			// if there are no nets in the list, the assignment is open.
			netString = "open";
		}

		return "NetAssign " + getLocation() + " : " + name + getBitString()
				+ " <= " + netString + "\n";
	}
}
