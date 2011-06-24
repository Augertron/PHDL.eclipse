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

public class InstanceAssignment extends ConcatenationAssignment {

	protected int instMsb = -1;
	protected int instLsb = -1;
	protected int instIndex = -1;

	public int getInstMsb() {
		return instMsb;
	}

	public void setInstMsb(int instMsb) {
		this.instMsb = instMsb;
	}

	public int getInstLsb() {
		return instLsb;
	}

	public void setInstLsb(int instLsb) {
		this.instLsb = instLsb;
	}

	public int getInstIndex() {
		return instIndex;
	}

	public void setInstIndex(int instIndex) {
		this.instIndex = instIndex;
	}

	/**
	 * Returns a string representation of the instanced width
	 */
	public String getInstWidthString() {
		String array = "";
		if (instMsb > -1 && instLsb > -1)
			array = "[" + instMsb + ":" + instLsb + "]";
		else if (instIndex > -1)
			array = "(" + instIndex + ")";
		return array;
	}

	public boolean isInstArrayed() {
		if (instMsb > -1 && instLsb > -1)
			return true;
		else
			return false;
	}

	public boolean isInstIndexed() {
		if (instIndex > -1)
			return true;
		else
			return false;
	}

	public int getInstWidth() {
		if (msb > -1 && lsb > -1)
			return Math.abs(msb - lsb) + 1;
		else
			return 1;
	}

	/**
	 * Method to tell whether the index passed in falls within the bounds of the
	 * instMsb and instLsb.
	 * 
	 * @return True if it is a valid index, false otherwise
	 */
	public boolean isInstValidIndex(int index) {
		if (isArrayed()) {
			if (instMsb > instLsb)
				return (instMsb >= index && index >= instLsb) ? true : false;
			if (instMsb < instLsb)
				return (instMsb <= index && index <= instLsb) ? true : false;
			else
				return (instMsb == index && index == instLsb) ? true : false;
		}
		return false;
	}

	public boolean isInstDownArray() {
		return (instMsb > instLsb) ? true : false;
	}

	public boolean isInstUpArray() {
		return (instMsb < instLsb) ? true : false;
	}

	/**
	 * Converts an array declared with equal instMsb and instLsb to an index
	 * with that value. Sets instMsb and instLsb to -1, as if they never existed
	 * in the source. Example: converts [3:3] to (3).
	 */
	public void toInstIndex() {
		if (isArrayed() && (instMsb == instLsb)) {
			instIndex = instMsb;
			instMsb = -1;
			instLsb = -1;
		}
	}
}
