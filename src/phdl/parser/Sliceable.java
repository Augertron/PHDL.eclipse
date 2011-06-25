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

import java.util.List;

/**
 * An abstract class that represents all elements in phdl that can be sliced.
 * Slicing an element consists of referencing an array of bits of the element
 * [msb:lsb], by an individual bit (index), or by a list of indices in braces
 * {1,3,8,...}. All of these values are initialized to -1 to indicate they are
 * not used by default. Using an msb and lsb is mutually exclusive from using an
 * index (they may not be used simultaneously.)
 * 
 * @author Richard Black and Brad Riching
 * 
 */
public abstract class Sliceable extends Parsable {

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
	 * The string of indices from the walker
	 */
	protected String indices = null;

	/**
	 * The ordered list of slices derived from one of the following: [msb:lsb],
	 * or (index), or {indices}.
	 */
	protected List<Integer> slices;

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

	public String getIndices() {
		return indices;
	}

	public void setIndices(String indices) {
		this.indices = indices;
	}

	public List<Integer> getSlices() {
		return slices;
	}

	/**
	 * Depending on whether the object has bits that are represented by an
	 * array, an individual index, or are specified arbitrarily in a comma
	 * separated list, this method creates an ordered list of those referenced
	 * bits.
	 * 
	 * @return False if the specifier list is invalid, True in all other cases.
	 */
	public boolean makeSlices() {

		// just incase there was anything already in there
		slices.clear();

		if (isUpArray()) {
			for (int i = msb; i <= lsb; i++)
				slices.add(i);
		} else if (isDownArray()) {
			for (int i = lsb; i <= msb; i++)
				slices.add(i);
		} else if (isArrayed()) {
			// for the case of [msb:lsb] where msb == lsb
			slices.add(msb);
		} else if (isIndexed()) {
			slices.add(index);
		} else if (isSpecified()) {

			// split number list on whitespace, commas and semicolons
			String[] numbers = indices.split("[;,\\s]");

			if (numbers.length == 0)
				return false;

			// add pin numbers to a set and check for duplicates
			for (int i = 0; i < numbers.length; i++) {
				try {
					slices.add(Integer.parseInt(numbers[i]));
				} catch (NumberFormatException e) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Returns a string representation of the indexable object's slices
	 */
	public String getSlicesString() {
		String array = "";
		if (isArrayed())
			array += "[" + msb + ":" + lsb + "]";
		else if (isIndexed())
			array += "(" + index + ")";
		else if (isSpecified()) {
			array += "{";
			for (Integer i : slices) {
				array += i + ",";
			}
			array = array.substring(0, array.length() - 1);
			array += "}";
		}
		return array;
	}

	public boolean isArrayed() {
		if (msb > -1 && lsb > -1)
			return true;
		else
			return false;
	}

	public boolean isIndexed() {
		if (index > -1)
			return true;
		else
			return false;
	}

	public boolean isSpecified() {
		if (indices == null) {
			return false;
		} else if (indices.length() == 0)
			return false;
		else
			return true;
	}

	public boolean isSliced() {
		return (isArrayed() || isIndexed() || isSpecified());
	}

	public int getWidth() {
		int width = slices.size();
		if (width == 0)
			return 1;
		else
			return width;
	}

	public boolean isDownArray() {
		if (isArrayed()) {
			return (msb > lsb) ? true : false;
		} else
			return false;
	}

	public boolean isUpArray() {
		if (isArrayed()) {
			return (msb < lsb) ? true : false;
		} else
			return false;
	}
}
