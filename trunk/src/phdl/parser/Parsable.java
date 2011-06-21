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
 * An abstract class that represents all parsable elements of the parsed phdl.
 * Every parsed element has a name, a line number, a position, and a fileName
 * field corresponding to where it appears in which source phdl file.
 * 
 * @author Richard Black and Brad Riching
 */
public abstract class Parsable {

	/**
	 * The name of the element
	 */
	protected String name;
	/**
	 * The line number of the element in the source file
	 */
	protected int line;
	/**
	 * The position of the element in the source file
	 */
	protected int pos;
	/**
	 * The source file from where the element came from
	 */
	protected String fileName;

	/**
	 * Gets the name of the element
	 * 
	 * @return The name of the element
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the element
	 * 
	 * @param name
	 *            The name of the element
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the line number of the element
	 * 
	 * @return The line number of the element
	 */
	public int getLine() {
		return line;
	}

	/**
	 * Sets the line number of the element
	 * 
	 * @param line
	 *            The line number of the element
	 */
	public void setLine(int line) {
		this.line = line;
	}

	/**
	 * Gets the position of the element
	 * 
	 * @return The position of the element
	 */
	public int getPos() {
		return pos;
	}

	/**
	 * Sets the position of the element
	 * 
	 * @param pos
	 *            The position of the element
	 */
	public void setPos(int pos) {
		this.pos = pos;
	}

	/**
	 * Gets the file name of the element
	 * 
	 * @return The file name of the element
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Sets the file name of the element
	 * 
	 * @param fileName
	 *            The file name of the element
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Gets a string representation of the location of the element
	 * 
	 * @return A string representation of the line and position of the element
	 */
	public String getLineString() {
		return line + ":" + pos;
	}

}
