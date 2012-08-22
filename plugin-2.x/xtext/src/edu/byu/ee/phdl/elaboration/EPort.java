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

package edu.byu.ee.phdl.elaboration;

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
public class EPort extends EConnection {

	private EConnection assignment;

	public EPort(EDesignUnit design) {
		super(design);
	}

	public EPort(EDesignUnit parent, EPort oldPort) {
		super(parent, oldPort);
	}

	public EPort(EDesignUnit design, String name) {
		super(design, name);
	}

	@Override
	public boolean addAttribute(EAttribute a) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Connection getter method.
	 * 
	 * @return the NetNode attached to the Pin
	 */
	public EConnection getAssignment() {
		return assignment;
	}

	@Override
	public EAttribute getAttribute(String name) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<EAttribute> getAttributes() {
		throw new UnsupportedOperationException();
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
	public boolean isAssigned() {
		return (assignment != null);
	}

	public void setAssignment(EConnection assignment) {
		this.assignment = assignment;
	}
}
