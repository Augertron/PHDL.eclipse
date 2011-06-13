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

/**
 * Represents an abstract phdl exception.
 * 
 * @author Richard Black and Brad Riching
 */
public abstract class PhdlException extends Exception {

	/**
	 * The Serial Version UID for this class
	 */
	private static final long serialVersionUID = 2732014517645210176L;

	public PhdlException() {
		super();
	}

	public PhdlException(String message, Throwable cause) {
		super(message, cause);
	}

	public PhdlException(String message) {
		super(message);
	}

	public PhdlException(Throwable cause) {
		super(cause);
	}

	/**
	 * Throw a PhdlRuntimeException based on this exception's message.
	 */
	public void toRuntime() {
		throw new PhdlRuntimeException(getMessage());
	}
}
