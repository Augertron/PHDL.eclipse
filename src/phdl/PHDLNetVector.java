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

import java.util.HashSet;

/**
 * A class that represents a net on a PC board.
 * 
 * Stores a net name and a set of optional tags with additional information
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 */
public class PHDLNetVector {
	/**
	 * the names of the nets in the vector.
	 */
	private HashSet<String> names;
	/**
	 * optional attributes that provide additional information about the nets
	 */
	private HashSet<String> attributes;

	private int msb;
	private int lsb;
	private int line;
	private int pos;

	/**
	 * Default Constructor.
	 * 
	 * Sets the net name and instantiates a new HashSet for the tags
	 * 
	 * @param name
	 *            the name of the net
	 */
	public PHDLNetVector(int msb, int lsb) {
		names = new HashSet<String>();
		attributes = new HashSet<String>();
		this.msb = msb;
		this.lsb = lsb;
	}

	/**
	 * Returns the names in the net.
	 * 
	 * Net name accessor method
	 * 
	 * @return A HashSet representation of the names
	 */
	public HashSet<String> getNames() {
		return names;
	}

	/**
	 * Returns a HashSet of the net tags.
	 * 
	 * Tags accessor method
	 * 
	 * @return A HashSet representation of the tags
	 */
	public HashSet<String> getTags() {
		return attributes;
	}

	/**
	 * Adds a new name to the net.
	 * 
	 * Net name adder method
	 * 
	 * @param newName
	 *            a new name to be added to the HashSet
	 */
	public void addName(String newName) {
		names.add(newName);
	}

	/**
	 * Adds a new tag to the net.
	 * 
	 * Net tag adder method
	 * 
	 * @param newTag
	 *            a new tag to be added to the HashSet
	 */
	public void addAttribute(String newTag) {
		attributes.add(newTag);
	}

	public void setLine(int line) {
		this.line = line;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public int getLine() {
		return line;
	}

	public int getPos() {
		return pos;
	}

	public int getMSB() {
		return msb;
	}

	public int getLSB() {
		return lsb;
	}

	@Override
	/**
	 * Creates a hash code for use in hash data structures.
	 * 
	 * hashCode method to make attributes compatible with hashMaps
	 * and hashSets.
	 * 
	 * @return	an integer representing a hash code
	 */
	public int hashCode() {
		return names.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		PHDLNetVector n = (PHDLNetVector) o;
		return names.equals(n.getNames());
	}

	@Override
	public String toString() {
		return "NetVector[" + line + ":" + pos + "]: [" + msb + ":" + lsb
				+ "] " + names.toString() + "\n";
	}
}
