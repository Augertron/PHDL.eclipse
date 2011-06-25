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

package phdl.exception;

import phdl.parser.Parsable;

/**
 * A class which represents an exception thrown when an output pin and supply
 * pin have been detected on the same net in the source phdl code.
 * 
 * @author Richard Black and Brad Riching
 */
public class OutputDrivingSupplyException extends ElectricalRuleCheckException {

	/**
	 * The Serial Version UID for this class
	 */
	private static final long serialVersionUID = 3916483213857947048L;

	/**
	 * Default constructor
	 * 
	 * @param e
	 *            The element in the source text that caused the exception
	 */
	public OutputDrivingSupplyException(Parsable e) {
		super(e.getLocation() + " Output driving supply pin detected: "
				+ e.getName());
	}

	/**
	 * Secondary constructor
	 * 
	 * @param n
	 *            The name of the object that caused the exception
	 */
	public OutputDrivingSupplyException(String n) {
		super("Output driving supply pin detected: " + n);
	}
}
