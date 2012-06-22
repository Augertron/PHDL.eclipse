/*
 * Copyright (C) 2011 Brigham Young University This program is free software: you can redistribute
 * it and/or modify it under the terms of the GNU General Public License as published by the Free
 * Software Foundation, version 3. This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received
 * a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package phdl.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents a design in PHDL.
 * 
 * @author Brad Riching and Richard Black
 * @version 0.1
 */
public class Design extends HierarchyUnit {

	public Design() {
		super();
	}

	public Design(String name) {
		super();
		this.name = name;
	}

	/**
	 * 
	 * @param newCon
	 * @return	true, if the connection wasn't already in the list and was added successfully
	 * 			false, otherwise
	 */
	@Override
	public boolean addConnection(Connection newCon) {
		if (!connections.contains(newCon) && newCon instanceof phdl.graph.Net)
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
	public void setConnections(List<Connection> connections) {
		connections = new ArrayList<Connection>();
		for (Connection c : connections) {
			if (c instanceof phdl.graph.Net) {
				connections.add(c);
			}
		}
	}

}
