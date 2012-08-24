/*
 * Copyright (C) 2011 Brigham Young University This program is free software: you can redistribute
 * it and/or modify it under the terms of the GNU General Public License as published by the Free
 * Software Foundation, version 3. This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received
 * a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package edu.byu.ee.phdl.elaboration;

/**
 * An abstract class that represents every data object in PHDL.
 * 
 * @author Brad Riching and Richard Black
 * @version 0.1
 */
public abstract class Node implements Comparable<Object> {

	protected String name = "";
	protected int line = 0;
	protected int pos = 0;
	protected String fileName = "";
	protected String info = "";

	public Node() {
		this.name = "";
		this.line = 0;
		this.pos = 0;
		this.fileName = "";
		this.info = "";
	}

	public Node(Node old) {
		this.name = old.name;
		this.line = old.line;
		this.pos = old.pos;
		this.fileName = old.fileName;
		this.info = old.info;
	}

	public void appendInfo(String info) {
		this.info += info;
	}

	/**
	 * A method that compares the current node with another.
	 * 
	 * @param o the Node to compare to
	 * @return 0, if they are equal, -1, if the current Node is less than the other 1, if the
	 *         current Node is greater than the other
	 */
	@Override
	public int compareTo(Object o) {
		return this.name.compareTo(((Node) o).getName());
	}

	/**
	 * Checks to see if the Node is equal to another.
	 * 
	 * @param o the Node to compare to
	 * @return true, if they are equal false, otherwise
	 */
	@Override
	public boolean equals(Object o) {
		return name.equals(((Node) o).getName());
	}

	/**
	 * FileName accessor method.
	 * 
	 * @return the file name where the node's data was found
	 */
	public String getFileName() {
		return fileName;
	}

	public String getInfo() {
		return info;
	}

	/**
	 * Line number accessor method.
	 * 
	 * @return the line number of the node
	 */
	public int getLine() {
		return line;
	}

	/**
	 * Name accessor method.
	 * 
	 * @return the name of the node
	 */
	public String getName() {
		return name;
	}

	/**
	 * Node type accessor method.
	 * 
	 * @return an ennumerated type that describes the Node
	 */
	public abstract NodeType getNodeType();

	/**
	 * Position accessor method.
	 * 
	 * @return the position of the node
	 */
	public int getPosition() {
		return pos;
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

	/**
	 * FileName mutator method.
	 * 
	 * @param fileName the new file name
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	/**
	 * Line number mutator method.
	 * 
	 * @param line the new line number
	 */
	public void setLine(int line) {
		this.line = line;
	}

	/**
	 * Initializes a Node with basic location information.
	 * 
	 * @param line the line number of the node
	 * @param pos the position of the node
	 * @param fileName the fileName for the node
	 */
	public void setLocation(int line, int pos, String fileName) {
		this.line = line;
		this.pos = pos;
		this.fileName = fileName;
	}

	/**
	 * Name mutator method.
	 * 
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Position mutator method.
	 * 
	 * @param pos the new position
	 */
	public void setPosition(int pos) {
		this.pos = pos;
	}

	@Override
	/**
	 * A generic toString method.
	 * 
	 * @return 			a string representation of the Node
	 */
	public String toString() {
		String fieldFmtStr = "  %-8s%2s%-26.26s\n";
		StringBuilder sb = new StringBuilder();
		sb.append("\n======================================================================\n" + getNodeType() + "\n\n");
		sb.append(String.format(fieldFmtStr, "File:", "", getFileName() + ", " + getLine() + ":" + getPosition()));
		return sb.toString();
	}
}
