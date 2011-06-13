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
 * A class that represents a net in phdl.
 * 
 * @author Richard Black and Brad Riching
 * 
 */
public class Net extends Indexable {

	/**
	 * Default constructor
	 */
	public Net() {
		super();
	}

	/**
	 * Returns a formatted string representation of the net
	 */
	@Override
	public String toString() {
		return "Net" + getLocString() + ": " + name + getWidthString();
	}
}
