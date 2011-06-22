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
 * An abstract class that represents all elements in phdl that can be indexed.
 * Indexing an element may be accomplished by referencing an array of bits of
 * the element (msb and lsb) or by an individual bit (index) within the code.
 * All of these values are initialized to -1 to indicate they are not used by
 * default. Using an msb and lsb is mutually exclusive from using an index (they
 * may not be used simultaneously.)
 * 
 * @author Richard Black and Brad Riching
 * 
 */
public abstract class Indexable extends Parsable {

	/**
	 * The msb of the indexable object
	 */
	protected int msb = -1;
	/**
	 * The lsb of the indexable object
	 */
	protected int lsb = -1;
	/**
	 * The index of the indexable object
	 */
	protected int index = -1;

	/**
	 * Gets the msb of the indexable object
	 * 
	 * @return The msb of the indexable object
	 */
	public int getMsb() {
		return msb;
	}

	/**
	 * Sets the msb of the indexable object
	 * 
	 * @param msb
	 *            The msb of the indexable object
	 */
	public void setMsb(int msb) {
		this.msb = msb;
	}

	/**
	 * Gets the lsb of the indexable object
	 * 
	 * @return the lsb of the indexable object
	 */
	public int getLsb() {
		return lsb;
	}

	/**
	 * Sets the lsb of the indexable object
	 * 
	 * @param lsb
	 *            The lsb of the indexable object
	 */
	public void setLsb(int lsb) {
		this.lsb = lsb;
	}

	/**
	 * Gets the index of the indexable object
	 * 
	 * @return The index of the indexable object
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Sets the index of the indexable object
	 * 
	 * @param index
	 *            The index of the indexable object
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * Returns a string representation of the indexable object's width
	 */
	public String getWidthString() {
		String array = "";
		if (msb > -1 && lsb > -1)
			array = "[" + msb + ":" + lsb + "]";
		else if (index > -1)
			array = "(" + index + ")";
		return array;
	}

	public boolean hasArray() {
		if (msb > -1 && lsb > -1)
			return true;
		else
			return false;
	}

	public boolean hasIndex() {
		if (index > -1)
			return true;
		else
			return false;
	}

	public int getWidth() {
		if (msb > -1 && lsb > -1)
			return Math.abs(msb - lsb);
		else
			return 1;
	}

	/**
	 * Method to tell whether the index passed in falls within the bounds of the
	 * msb and lsb.
	 * 
	 * @return True if it is a valid index, false otherwise
	 */
	public boolean isValidIndex(int index) {
		if (msb > lsb)
			return (msb >= index && index >= lsb) ? true : false;
		if (msb < lsb)
			return (msb <= index && index <= lsb) ? true : false;
		else
			return (msb == index && index == lsb) ? true : false;
	}

	public boolean isDownArray() {
		return (msb > lsb) ? true : false;
	}

	public boolean isUpArray() {
		return (msb < lsb) ? true : false;
	}

	/**
	 * Converts an array declared with equal msb and lsb to an index with that
	 * value. Sets msb and lsb to -1, as if they never existed in the source.
	 */
	public void toIndex() {
		if (hasArray() && (msb == lsb)) {
			index = msb;
			msb = -1;
			lsb = -1;
		}
	}
}
