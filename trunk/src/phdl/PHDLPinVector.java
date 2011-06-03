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
 * A class that represents a pin vector of a device.
 * 
 * A pin vector is embodied by a name and a type, an msb, an lsb, and a list of
 * pins
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 */
public class PHDLPinVector {
	/**
	 * the name of the pin vector
	 */
	private String name;
	/**
	 * the type of the pin vector
	 */
	private String type;
	/**
	 * the pin vector msb
	 */
	private int msb;
	/**
	 * the pin vector lsb
	 */
	private int lsb;
	/**
	 * the pin vector pinList
	 */
	private String pinList;
	/**
	 * the line number of the pin vector pinList
	 */
	private int line;
	/**
	 * the column position of the pin vector pinList
	 */
	private int pos;

	/**
	 * Default Constructor.
	 * 
	 * Defaults the pin type to "pin"
	 * 
	 * @param name
	 *            the name of the pin
	 * @param msb
	 *            the pin vector msb
	 * @param lsb
	 *            the pin vector lsb
	 * @param pinList
	 *            the pin vector pinList
	 */
	public PHDLPinVector(String name, int msb, int lsb, String pinList,
			int line, int pos) {
		this.name = name;
		this.type = "pin";
		this.msb = msb;
		this.lsb = lsb;
		this.pinList = pinList;
		this.line = line;
		this.pos = pos;
	}

	/**
	 * Secondary Constructor.
	 * 
	 * Allows for the instantiation of the name and type
	 * 
	 * @param name
	 *            the name of the pin
	 * @param type
	 *            the type of the pin
	 * @param msb
	 *            the pin vector msb
	 * @param lsb
	 *            the pin vector lsb
	 * @param pinList
	 *            the pin vector pinList
	 */
	public PHDLPinVector(String name, String type, int msb, int lsb,
			String pinList, int line, int pos) {
		this.name = name;
		this.type = type;
		this.msb = msb;
		this.lsb = lsb;
		this.pinList = pinList;
		this.line = line;
		this.pos = pos;
	}

	/**
	 * Returns the name of the pin.
	 * 
	 * Pin name accessor method
	 * 
	 * @return a string representation of the pin name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Changes the name of the pin.
	 * 
	 * Pin name mutator method
	 * 
	 * @param name
	 *            the new name of the pin
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the pin type of the pin.
	 * 
	 * Pin type accessor method
	 * 
	 * @return the pin type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Changes the pin type of the pin.
	 * 
	 * Pin type mutator method
	 * 
	 * @param type
	 *            the new pin type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Returns the msb of the pin vector.
	 * 
	 * Pin vector msb accessor method
	 * 
	 * @return the pin vector msb
	 */
	public int getMSB() {
		return msb;
	}

	/**
	 * Changes the pin vector msb.
	 * 
	 * Pin vector msb mutator method
	 * 
	 * @param msb
	 *            the new pin vector msb
	 */
	public void setMSB(int msb) {
		this.msb = msb;
	}

	/**
	 * Returns the lsb of the pin vector.
	 * 
	 * Pin vector lsb accessor method
	 * 
	 * @return the pin vector lsb
	 */
	public int getLSB() {
		return lsb;
	}

	/**
	 * Changes the pin vector lsb.
	 * 
	 * Pin vector lsb mutator method
	 * 
	 * @param lsb
	 *            the new pin vector lsb
	 */
	public void setLSB(int lsb) {
		this.lsb = lsb;
	}

	public int getWidth() {
		return Math.abs(msb - lsb) + 1;
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
	public String toString() {
		return "PinVector[" + line + ":" + pos + "]: " + type + " [" + msb
				+ ":" + lsb + "] " + name + " {" + pinList + "}\n";
	}

	@Override
	public boolean equals(Object o) {
		PHDLPinVector p = (PHDLPinVector) o;
		if (p.getName().equals(name) && p.getType() == type
				&& p.getMSB() == msb && p.getLSB() == lsb) {
			return true;
		}
		return false;
	}

}
