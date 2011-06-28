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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class SliceArray extends Concatenated {

	protected int msb = -1;
	protected int lsb = -1;
	protected int index = -1;

	protected String arrayString = null;
	protected List<Integer> indices;

	public void setArrayString(String arrayString) {
		this.arrayString = arrayString;
	}

	public List<Integer> getIndices() {
		return indices;
	}

	public int getMsb() {
		return msb;
	}

	public int getLsb() {
		return lsb;
	}

	/**
	 * Private method to determine if the sliceString conforms to a vector
	 * representation [INT:INT]
	 * 
	 * @return True if the sliceString is a vector
	 */
	private boolean isArrayRegex() {
		Pattern p = Pattern.compile("^(\\d)+:(\\d)+$");
		Matcher m = p.matcher(arrayString);
		if (m.matches())
			return true;
		else
			return false;
	}

	/**
	 * Private method to determine if the sliceString conforms to a bit
	 * representation [INT]
	 * 
	 * @return True if the sliceString is a bit
	 */
	private boolean isIndexRegex() {
		Pattern p = Pattern.compile("^(\\d)+$");
		Matcher m = p.matcher(arrayString);
		if (m.matches())
			return true;
		else
			return false;
	}

	/**
	 * This method is called on any sliced object to form the ordered list of
	 * bits derived from any of the following: vector [INT:INT], bit [INT],
	 * arbitrary [INT,INT,INT,...]
	 * 
	 * @return True if makeBits completed successfully, False if the sliceString
	 *         is invalid
	 */
	public boolean makeIndices() {
		if (arrayString == null)
			return true;

		// remove all the whitespace beforehand
		arrayString = arrayString.replaceAll("[\\s]", "");
		String splits[];
		// check if the string of slices is a vector
		if (isArrayRegex()) {
			splits = arrayString.split(":");
			try {
				msb = Integer.parseInt(splits[0]);
				lsb = Integer.parseInt(splits[1]);
			} catch (NumberFormatException e) {
				return false;
			}

			if (msb < 0 || lsb < 0)
				return false;

			if (msb < lsb) {
				for (int i = msb; i <= lsb; i++)
					indices.add(i);
			} else if (msb > lsb) {
				for (int i = msb; i >= lsb; i--)
					indices.add(i);
			} else {
				indices.add(msb);
			}
			return true;
			// check if the string of slices is a single bit
		} else if (isIndexRegex()) {
			try {
				index = Integer.parseInt(arrayString);
				if (index < 0)
					return false;
				indices.add(index);
			} catch (NumberFormatException e) {
				return false;
			}

			return true;
		} else
			return false;
	}

	public String getWidthString() {
		if (isArrayed())
			return "[" + msb + ":" + lsb + "]";
		else
			return "";
	}

	public boolean isArrayed() {
		if (msb > -1 && lsb > -1)
			return true;
		else
			return false;
	}

	public int getArrayWidth() {
		int width = indices.size();
		if (width == 0)
			return 1;
		else
			return width;
	}

	public String getArrayString() {
		if (indices.size() == 0)
			return "";

		String slices = "(";
		for (Integer i : indices) {
			slices += i + ",";
		}
		slices = slices.substring(0, slices.length() - 1);
		slices += ")";
		return slices;
	}

	/**
	 * Method to tell whether the index passed in falls within the bounds of the
	 * msb and lsb.
	 * 
	 * @return True if it is a valid index, false otherwise
	 */
	public boolean isValidIndex(int index) {
		if (isArrayed()) {
			if (msb > lsb)
				return (msb >= index && index >= lsb) ? true : false;
			if (msb < lsb)
				return (msb <= index && index <= lsb) ? true : false;
			else
				return (msb == index && index == lsb) ? true : false;
		}
		return false;
	}

	public boolean isValidArray(int msb, int lsb) {
		return isValidIndex(msb) && isValidIndex(lsb);
	}

	public boolean isDownArray() {
		if (isArrayed()) {
			return (msb > lsb) ? true : false;
		}
		return false;
	}

	public boolean isUpArray() {
		if (isArrayed()) {
			return (msb < lsb) ? true : false;
		}
		return false;
	}
}
