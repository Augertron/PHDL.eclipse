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
 * A class that represents an exception thrown when a device attribute list is
 * missing a required reference prefix in the phdl source code.
 * 
 * @author Richard Black and Brad Riching
 */
public class MissingRefPrefixException extends SyntaxException {

	/**
	 * The Serial Version UID for this class
	 */
	private static final long serialVersionUID = -5744387465105547028L;

	/**
	 * Default constructor
	 * 
	 * @param e
	 *            The element in the source text that caused the exception
	 */
	public MissingRefPrefixException(Parsable e) {
		super(e.getLineString() + " Missing reference prefix detected: "
				+ e.getName());
	}

	/**
	 * Secondary constructor
	 * 
	 * @param s
	 *            The name of the object that caused the exception
	 */
	public MissingRefPrefixException(String s) {
		super("Missing reference prefix detected: " + s);
	}
}
