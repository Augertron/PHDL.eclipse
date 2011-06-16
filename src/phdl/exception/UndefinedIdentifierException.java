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

import phdl.parser.Element;

/**
 * A class which represents an exception thrown when an undefined identifier
 * exists in the source phdl code.
 * 
 * @author Richard Black and Brad Riching
 */
public class UndefinedIdentifierException extends SyntaxException {

	/**
	 * The Serial Version UID for this class
	 */
	private static final long serialVersionUID = 9016528926582719439L;

	/**
	 * Default constructor
	 * 
	 * @param e
	 *            The element in the source text that caused the exception
	 */
	public UndefinedIdentifierException(Element e) {
		super(e.getLineString() + " Undefined identifer detected: "
				+ e.getName());
	}

	/**
	 * Secondary constructor
	 * 
	 * @param n
	 *            The name of the object that caused the exception
	 */
	public UndefinedIdentifierException(String n) {
		super("Undefined identifier detected: " + n);
	}
}
