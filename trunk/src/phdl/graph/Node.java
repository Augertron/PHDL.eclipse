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

package phdl.graph;

/**
 * An abstract class that represents every data object in PHDL.
 * 
 * @author Brad Riching and Richard Black
 * @version 0.1
 */
public abstract class Node implements Comparable<Object> {
	
	protected String name;
	protected int line;
	protected int pos;
	protected String fileName;

	/**
	 * FileName accessor method.
	 * 
	 * @return			the file name where the node's data
	 * 					was found
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * FileName mutator method.
	 * 
	 * @param fileName	the new file name
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Name accessor method.
	 * 
	 * @return			the name of the node
	 */
	public String getName() {
		return name;
	}

	/**
	 * Line number accessor method.
	 * 
	 * @return			the line number of the node
	 */
	public int getLine() {
		return line;
	}

	/**
	 * Position accessor method.
	 * 
	 * @return			the position of the node
	 */
	public int getPosition() {
		return pos;
	}

	/**
	 * Name mutator method.
	 * 
	 * @param name		the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Line number mutator method.
	 * 
	 * @param line		the new line number
	 */
	public void setLine(int line) {
		this.line = line;
	}

	/**
	 * Position mutator method.
	 * 
	 * @param pos		the new position
	 */
	public void setPosition(int pos) {
		this.pos = pos;
	}

	/**
	 * Node type accessor method.
	 * 
	 * @return			an ennumerated type that
	 * 					describes the Node
	 */
	public abstract NodeType getType();

	@Override
	/**
	 * Checks to see if the Node is equal to another.
	 * 
	 * @param o			the Node to compare to
	 * @return			true, if they are equal
	 * 					false, otherwise
	 */
	public boolean equals(Object o) {
		return name.equals(((Node) o).getName());
	}

	@Override
	/**
	 * A hash method for use in HashSets.
	 * 
	 * @return 			a hash number for the node
	 */
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	/**
	 * A generic toString method.
	 * 
	 * @return 			a string representation of the Node
	 */
	public String toString() {
		return getType().toString() + " " + name;
	}

	@Deprecated
	public void initNode(String name, int line, int pos, String fileName) {
		this.name = name;
		this.line = line;
		this.pos = pos;
		this.fileName = fileName;
	}

	/**
	 * Initializes a Node with basic location information.
	 * 
	 * @param line		the line number of the node
	 * @param pos		the position of the node
	 * @param fileName	the fileName for the node
	 */
	public void setLocation(int line, int pos, String fileName) {
		this.line = line;
		this.pos = pos;
		this.fileName = fileName;
	}

	@Override
	/**
	 * A method that compares the current node with another.
	 * 
	 * @param o			the Node to compare to
	 * @return			0, if they are equal,
	 * 					-1, if the current Node is less than the other
	 * 					1, if the current Node is greater than the other
	 */
	public int compareTo(Object o) {
		return this.name.compareTo(((Node) o).getName());
	}
}
