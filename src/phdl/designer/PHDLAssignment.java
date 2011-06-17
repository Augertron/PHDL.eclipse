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

package phdl.designer;

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
	 * Constructor used in pin and net assignments
	 * 
	 * 
	 */
	public PHDLAssignment(String leftValue) {
		this.leftValue = leftValue;
		this.rightValues = new ArrayList<PHDLNet>();
	}

	public int getRightIndex() {
		return rightIndex;
	}

	public int getRightLsb() {
		return rightLsb;
	}

	public int getRightMsb() {
		return rightMsb;
	}

	public void setLeftIndex(int leftIndex) {
		this.leftIndex = leftIndex;
	}

	public void setLeftLsb(int leftLsb) {
		this.leftLsb = leftLsb;
	}

	public void setLeftMsb(int leftMsb) {
		this.leftMsb = leftMsb;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public void setRightIndex(int rightIndex) {
		this.rightIndex = rightIndex;
	}

	public void setRightLsb(int rightLsb) {
		this.rightLsb = rightLsb;
	}

	public void setRightMsb(int rightMsb) {
		this.rightMsb = rightMsb;
	}

	/**
	 * Constructor used in an attribute assignment.
	 * 
	 * 
	 */
	public PHDLAssignment(String leftValue, String rightValue) {
		this.leftValue = leftValue;
		this.rightValue = rightValue;
		this.rightValues = new ArrayList<PHDLNet>();
	}

	/**
	 * Adds a right value net to the array list of right values
	 * 
	 * @param net
	 */
	public void addRightValue(PHDLNet net) {
		rightValues.add(net);
	}

	/**
	 * Returns the left index of the assignment.
	 * 
	 * @return leftIndex
	 */
	public int getLeftIndex() {
		return leftIndex;
	}

	/**
	 * Returns the left lsb of the assignment.
	 * 
	 * @return leftLsb
	 */
	public int getLeftLsb() {
		return leftLsb;
	}

	/**
	 * Returns the left msb of the assignment
	 * 
	 * @return lsftMsb
	 */
	public int getLeftMsb() {
		return leftMsb;
	}

	/**
	 * Returns the left value of the assignment
	 * 
	 * @return leftValue
	 */
	public String getLeftValue() {
		return leftValue;
	}

	/**
	 * Returns the line number of the assignment
	 * 
	 * @return line
	 */
	public int getLine() {
		return line;
	}

	/**
	 * Returns a string representation of the location of the assignment in the
	 * source text
	 * 
	 * @return [line:pos] where line and pos are integers
	 */
	public String getLocation() {
		return "[" + line + ":" + pos + "]";
	}

	/**
	 * Returns the position of the assignment
	 * 
	 * @return pos
	 */
	public int getPos() {
		return pos;
	}

	/**
	 * Returns the right value of the assignment.
	 * 
	 * @return rightValue
	 */
	public String getRightValue() {
		return rightValue;
	}

	/**
	 * Returns an array list of all the right values of the assignment
	 * 
	 * @return
	 */
	public ArrayList<PHDLNet> getRightValues() {
		return rightValues;
	}

	@Override
	/**
	 * Returns a string representation of the assignment
	 */
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

		return getLocation() + ": " + leftValue + leftWidth + " =" + rightList
				+ "\n";
	}
}
