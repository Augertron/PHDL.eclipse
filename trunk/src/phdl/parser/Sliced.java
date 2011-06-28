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

/**
 * An abstract class that represents all elements in phdl that can be sliced.
 * Slicing an element consists of referencing a vector [8:5], an individual bit
 * [2], or a list of slices [1,3,7,...].
 * 
 * @author Richard Black and Brad Riching
 * 
 */
public abstract class Sliced extends Parsable {

	/**
	 * The string of slices from the tree walker
	 */
	protected String sliceString = null;
	/**
	 * The ordered list of bits derived from the string of slices above
	 */
	protected List<Integer> bits;
	/**
	 * Is the sliced object a vector slice?
	 */
	protected boolean vector = false;
	/**
	 * Is the sliced object a bit slice?
	 */
	protected boolean bit = false;
	/**
	 * Is the sliced object arbitrarily sliced?
	 */
	protected boolean arbitrary = false;

	public void setSliceString(String sliceString) {
		this.sliceString = sliceString;
	}

	public List<Integer> getBits() {
		return bits;
	}

	/**
	 * Private method to determine if the sliceString conforms to a vector
	 * representation [INT:INT]
	 * 
	 * @return True if the sliceString is a vector
	 */
	private boolean isVectorRegex() {
		Pattern p = Pattern.compile("^(\\d)+:(\\d)+$");
		Matcher m = p.matcher(sliceString);
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
	private boolean isBitRegex() {
		Pattern p = Pattern.compile("^(\\d)+$");
		Matcher m = p.matcher(sliceString);
		if (m.matches())
			return true;
		else
			return false;
	}

	/**
	 * Private method to determine if the sliceString conforms to an arbitrary
	 * representation [INT,INT,INT,...]
	 * 
	 * @return True if the sliceString is arbitrary
	 */
	private boolean isArbitraryRegex() {
		Pattern p = Pattern.compile("^(\\d+)(,\\d+)*$");
		Matcher m = p.matcher(sliceString);
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
	public boolean makeBits() {
		if (sliceString == null) {
			bits.add(0);
			return true;
		}
		// remove all the whitespace beforehand
		sliceString = sliceString.replaceAll("[\\s]", "");
		String splits[];
		// check if the string of slices is a vector
		if (isVectorRegex()) {
			splits = sliceString.split(":");
			int msb = 0;
			int lsb = 0;
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
					bits.add(i);
			} else if (msb > lsb) {
				for (int i = msb; i >= lsb; i--)
					bits.add(i);
			} else {
				bits.add(msb);
			}
			vector = true;
			return vector;
			// check if the string of slices is a single bit
		} else if (isBitRegex()) {
			try {
				int index = Integer.parseInt(sliceString);
				bits.add(index);
				if (index < 0)
					return false;
			} catch (NumberFormatException e) {
				return false;
			}
			bit = true;
			return bit;
			// check if the string of slices is arbitrarily specified
		} else if (isArbitraryRegex()) {
			splits = sliceString.split(",");
			for (int i = 0; i < splits.length; i++) {
				try {
					bits.add(Integer.parseInt(splits[i]));
				} catch (NumberFormatException e) {
					return false;
				}
			}
			arbitrary = true;
			return arbitrary;
		} else
			return false;
	}

	public int getBitWidth() {
		int width = bits.size();
		if (width == 0)
			return 1;
		else
			return width;
	}

	/**
	 * Returns a string representation of the indexable object's slices
	 */
	public String getBitString() {
		if (bits.size() == 0)
			return "";

		String slices = "[";
		for (Integer i : bits) {
			slices += i + ",";
		}
		slices = slices.substring(0, slices.length() - 1);
		slices += "]";
		return slices;
	}

	public boolean isVector() {
		return vector;
	}

	public boolean isBit() {
		return bit;
	}

	public boolean isArbitrary() {
		return arbitrary;
	}

	public boolean isSliced() {
		return (isVector() || isBit() || isArbitrary());
	}
}
