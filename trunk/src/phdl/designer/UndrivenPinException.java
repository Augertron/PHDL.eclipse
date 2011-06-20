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

package phdl.designer;

public class UndrivenPinException extends PHDLException {

	/**
	 * The Serial Version UID for this class
	 */
	private static final long serialVersionUID = 8096832829702218019L;

	int lineNum;
	String instName;

	public UndrivenPinException() {
		super();
		lineNum = -1;
		instName = null;
	}

	public UndrivenPinException(int lineNum) {
		super();
		this.lineNum = lineNum;
		this.instName = null;
	}

	public UndrivenPinException(int lineNum, String instName) {
		super();
		this.lineNum = lineNum;
		this.instName = instName;
	}

	@Override
	public String getMessage() {
		String myString = "";
		if (lineNum == -1) {
			myString = "A pin is not being driven";
		} else if (instName == null) {
			myString = "Pin on line " + lineNum + " is not being driven";
		} else {
			myString = instName + "'s pin on line " + lineNum
					+ " is not being driven";
		}
		return myString;
	}

	@Override
	public String getExceptionType() {
		return "UndrivenPinException";
	}
}
