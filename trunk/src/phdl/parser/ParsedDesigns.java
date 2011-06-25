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

import java.util.HashSet;

import phdl.exception.InvalidDesignException;

/**
 * A class that represents set of design declarations as parsed from all phdl
 * sources
 * 
 * @author Richard Black and Brad Riching
 * @see DesignDecl
 */
public class ParsedDesigns {

	/**
	 * The parsed designs set of design declarations
	 */
	protected HashSet<DesignDecl> designDecls;

	/**
	 * Default constructor
	 */
	public ParsedDesigns() {
		this.designDecls = new HashSet<DesignDecl>();
	}

	/**
	 * Gets this parsed design's set of design declarations
	 * 
	 * @return This parsed design's set of design declarations
	 */
	public HashSet<DesignDecl> getDesignDecls() {
		return designDecls;
	}

	/**
	 * Adds a design declaration to this parsed design.
	 * 
	 * @param designDecl
	 *            the design declaration to add
	 * @return true if the design declaration was added successfully
	 */
	public boolean addDesignDecl(DesignDecl designDecl) {
		boolean added = designDecls.add(designDecl);
		return added;
	}

	/**
	 * Returns a design representation of a subdesign.
	 * 
	 * @param s
	 *            the subdesign that maps to a design
	 * @return the design associated with the subdesign null if the design was
	 *         not found
	 */
	public DesignDecl getDesign(SubDecl s) {
		for (DesignDecl d : designDecls) {
			if (d.getName().equals(s.getRefName())) {
				return d;
			}
		}
		return null;
	}

	/**
	 * A method to find the top level design in the parsed designs.
	 * 
	 * @return A reference to the top level design declaration
	 * @throws InvalidDesignException
	 */
	public DesignDecl getTopDesign() throws InvalidDesignException {
		boolean topFound = false;
		DesignDecl topDesign = null;
		for (DesignDecl d : designDecls) {
			if (d.getPortDecls().isEmpty()) {
				if (topFound) {
					throw new InvalidDesignException(d,
							"multiple top level designs found:");
				}
				topFound = true;
				topDesign = d;
			}
		}
		if (!topFound)
			throw new InvalidDesignException("no top level design found.");
		return topDesign;
	}
}
