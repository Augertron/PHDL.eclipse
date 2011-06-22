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
 * A class that represents all declarations that take on an array structure. An
 * array is declared with an msb and lsb in the source phdl code.
 * 
 * @author Richard Black and Brad Riching
 */
public abstract class ArrayDeclaration extends Declarable {

	/**
	 * The msb of the array declaration
	 */
	protected int msb = -1;
	/**
	 * The lsb of the array declaration
	 */
	protected int lsb = -1;

	/**
	 * Gets the msb of the array declaration
	 * 
	 * @return The msb of the array declaration
	 */
	public int getMsb() {
		return msb;
	}

	/**
	 * Gets the lsb of the array declaration
	 * 
	 * @return The lsb of the array declaration
	 */
	public int getLsb() {
		return lsb;
	}

	/**
	 * Sets the msb of the array declaration
	 * 
	 * @param msb
	 *            The msb of the array declaration
	 */
	public void setMsb(int msb) {
		this.msb = msb;
	}

	/**
	 * Sets the lsb of the array declaration
	 * 
	 * @param lsb
	 *            The lsb of the array declaration
	 */
	public void setLsb(int lsb) {
		this.lsb = lsb;
	}

	/**
	 * Gets a string representation of the array's width if the msb and lsb have
	 * been set.
	 * 
	 * @return a string representation of the array's width
	 */
	public String getWidthString() {
		if (msb > -1 && lsb > -1)
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

	public int getWidth() {
		if (msb > -1 && lsb > -1)
			return Math.abs(msb - lsb) + 1;
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

	public boolean isValidArray(int high, int low) {
		return isValidIndex(high) && isValidIndex(low);
	}

	public boolean isDownArray() {
		return (msb > lsb) ? true : false;
	}

	public boolean isUpArray() {
		return (msb < lsb) ? true : false;
	}
}
