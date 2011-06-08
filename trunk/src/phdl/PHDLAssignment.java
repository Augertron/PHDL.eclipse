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

import java.util.ArrayList;

/**
 * A class that models an assignment statement in PHDL. All assignments are made
 * after the "begin" keyword in the PHDL file. Attribute and pin assignments are
 * made within instances, and net assignments may occur on their own
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 * 
 */
public class PHDLAssignment {
	/**
	 * Contains the assignment's left index value
	 */
	private int leftIndex = -1;
	/**
	 * Contains the assignment's left lsb value
	 */
	private int leftLsb = -1;
	/**
	 * Contains the assignment's left msb value
	 */
	private int leftMsb = -1;
	/**
	 * Contains the assignment's left value
	 */
	private String leftValue;
	/**
	 * the line number at the start of leftValue
	 */
	private int line = 0;
	/**
	 * the column position at the start of leftValue
	 */
	private int pos = 0;
	/**
	 * Contains the assignment's right index value
	 */
	private int rightIndex = -1;
	/**
	 * Contains the assignment's right lsb value
	 */
	private int rightLsb = -1;
	/**
	 * Contains the assignment's right lsb value
	 */
	private int rightMsb = -1;
	/**
	 * Contains the assignment's right value
	 */
	private String rightValue;

	private ArrayList<PHDLNet> rightValues;

	/**
	 * Constructor used in an attribute assignment.
	 * 
	 * 
	 */
	public PHDLAssignment(String leftValue, String rightValue, int leftMSB,
			int leftLSB, int leftIndex, int rightMSB, int rightLSB,
			int rightIndex, int line, int pos) {
		this.leftValue = leftValue;
		this.leftMsb = leftMSB;
		this.leftLsb = leftLSB;
		this.leftIndex = leftIndex;
		this.rightValue = rightValue;
		this.rightMsb = rightMSB;
		this.rightLsb = rightLSB;
		this.rightIndex = rightIndex;
		this.line = line;
		this.pos = pos;
		this.rightValues = new ArrayList<PHDLNet>();
	}

	/**
	 * Constructor used in pin and net assignments
	 * 
	 * 
	 */
	public PHDLAssignment(String leftValue, int leftMSB, int leftLSB,
			int leftIndex, int line, int pos) {
		this.leftValue = leftValue;
		this.leftMsb = leftMSB;
		this.leftLsb = leftLSB;
		this.leftIndex = leftIndex;
		this.line = line;
		this.pos = pos;
		this.rightValues = new ArrayList<PHDLNet>();
	}

	public String getRightValue() {
		return rightValue;
	}

	public int getLeftIndex() {
		return leftIndex;
	}

	public int getLeftLsb() {
		return leftLsb;
	}

	public int getLeftMsb() {
		return leftMsb;
	}

	public String getLeftValue() {
		return leftValue;
	}

	public int getLine() {
		return line;
	}

	public String getLocation() {
		return "[" + line + ":" + pos + "]";
	}

	public int getPos() {
		return pos;
	}

	public void addRightValue(PHDLNet n) {
		rightValues.add(n);
	}

	public ArrayList<PHDLNet> getRightValues() {
		return rightValues;
	}

	@Override
	public String toString() {

		String leftWidth = "";
		if (leftMsb != -1 && leftLsb != -1) {
			leftWidth = "[" + leftMsb + ":" + leftLsb + "]";
		} else if (leftIndex != -1) {
			leftWidth = "(" + leftIndex + ")";
		} else
			leftWidth = "";

		String rightList = "";
		if (!rightValues.isEmpty()) {
			for (PHDLNet n : rightValues) {

				if (n.getMsb() != -1 && n.getLsb() != -1) {
					rightList += " " + n.getName() + "[" + n.getMsb() + ":"
							+ n.getLsb() + "]";
				} else if (n.getIndex() != -1) {
					rightList += " " + n.getName() + "(" + n.getIndex() + ")";
				} else
					rightList += " " + n.getName();
			}
		} else {
			rightList = " " + rightValue;
			if (rightMsb != -1 && rightLsb != -1) {
				rightList += "[" + rightMsb + ":" + rightLsb + "]";
			} else if (rightIndex != -1) {
				rightList += "(" + rightIndex + ")";
			} else
				rightList += "";
		}
		// return assignmentString + leftValue + leftWidth + " = " + rightValue
		// + rightWidth + "\n";
		return getLocation() + ": " + leftValue + leftWidth + " =" + rightList
				+ "\n";
	}
}
