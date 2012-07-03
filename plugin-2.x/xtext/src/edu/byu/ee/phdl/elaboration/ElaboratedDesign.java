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

import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents an elaborated design in PHDL.
 * 
 * @author Brad Riching and Richard Black
 * @version 2.1
 */
public class ElaboratedDesign extends ElaboratedHierarchyUnit {

	public ElaboratedDesign() {
		super();
	}

	public ElaboratedDesign(String name) {
		super();
		this.name = name;
	}

	/**
	 * 
	 * @param newCon
	 * @return true, if the connection wasn't already in the list and was added successfully false,
	 *         otherwise
	 */
	@Override
	public boolean addConnection(ElaboratedConnection newCon) {
		if (!connections.contains(newCon) && newCon instanceof edu.byu.ee.phdl.elaboration.ElaboratedNet)
			return connections.add(newCon);
		return false;
	}

	@Override
	public String getNameIndex() {
		return this.name;
	}

	@Override
	/**
	 * Type accessor method.
	 * 
	 * @return NodeType.DESIGN
	 */
	public NodeType getNodeType() {
		return NodeType.DESIGN;
	}

	@Override
	public void setConnections(List<ElaboratedConnection> connections) {
		connections = new ArrayList<ElaboratedConnection>();
		for (ElaboratedConnection c : connections) {
			if (c instanceof edu.byu.ee.phdl.elaboration.ElaboratedNet) {
				connections.add(c);
			}
		}
	}

}