/*
    Copyright (C) 2011  Brigham Young University

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, version 3.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package phdl.graph;

import java.util.Set;

/**
 * This class will represent a Port in PHDL.
 * 
 * This has yet to be implemented.
 * 
 * @author Brad Riching and Richard Black
 * @version 0.l
 *
 */
public class Port extends Connection {

	private Connection assignment;

	public Port(DesignUnit design) {
		super(design);
	}

	public Port(DesignUnit parent, Port oldPort) {
		super(parent, oldPort);
	}

	public Port(DesignUnit design, String name) {
		super(design, name);
	}

	@Override
	public boolean addAttribute(Attribute a) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Attribute getAttribute(String name) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Attribute> getAttributes() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Connection getter method.
	 * 
	 * @return the NetNode attached to the Pin
	 */
	public Connection getAssignment() {
		return assignment;
	}

	@Override
	/**
	 * Type accessor method.
	 * 
	 * @return NodeType.PORT
	 */
	public NodeType getNodeType() {
		return NodeType.PORT;
	}

	/**
	 * Checks to see if the Port has a Connection.
	 * 
	 * @return true, if there is a Connection false, otherwise
	 */
	public boolean hasAssignment() {
		return (assignment != null);
	}

	public void setAssignment(Connection assignment) {
		this.assignment = assignment;
	}
}
