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

import phdl.exception.InvalidTopDesignException;

/**
 * A class that represents parsed phdl designs containing a set of design
 * declarations
 * 
 * @author Richard Black and Brad Riching
 * 
 */
public class ParsedDesigns {

	/**
	 * The parsed designs set of design declarations
	 */
	protected HashSet<DesignDeclaration> designDecls;

	/**
	 * Default constructor
	 */
	public ParsedDesigns() {
		this.designDecls = new HashSet<DesignDeclaration>();
	}

	/**
	 * Gets this parsed design's set of design declarations
	 * 
	 * @return This parsed design's set of design declarations
	 */
	public HashSet<DesignDeclaration> getDesignDecls() {
		return designDecls;
	}

	/**
	 * Adds a design declaration to this parsed design
	 * 
	 * @param designDecl
	 *            the design declaration to add
	 * @return true if the design declaration was added successfully
	 */
	public boolean addDesignDecl(DesignDeclaration designDecl) {
		boolean added = designDecls.add(designDecl);
		return added;
	}

	/**
	 * A method to find the top level design in the parsed designs.
	 * 
	 * @return A reference to the top level design declaration
	 * @throws InvalidTopDesignException
	 */
	public DesignDeclaration getTopDesign() throws InvalidTopDesignException {
		boolean topFound = false;
		DesignDeclaration topDesign = null;
		for (DesignDeclaration d : designDecls) {
			if (d.getPortDecls().isEmpty()) {
				if (topFound) {
					throw new InvalidTopDesignException(d,
							"multiple top level designs found:");
				}
				topFound = true;
				topDesign = d;
			}
		}
		if (!topFound)
			throw new InvalidTopDesignException("no top level design exists.");
		return topDesign;
	}
}
