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
import java.util.Map;

/**
 * A class that represents an elaborated design in PHDL.
 * 
 * @author Brad Riching and Richard Black
 * @version 2.1
 */
public class EDesign extends EHierarchyUnit {

	private final List<EConnection> netlist;
	private Map<String, EInstance> refMap = null;

	public EDesign() {
		super();
		netlist = new ArrayList<EConnection>();
	}

	public EDesign(String name) {
		super();
		this.name = name;
		netlist = new ArrayList<EConnection>();
	}

	/**
	 * 
	 * @param newCon
	 * @return true, if the connection wasn't already in the list and was added
	 *         successfully false, otherwise
	 */
	@Override
	public boolean addConnection(EConnection newCon) {
		if (!connections.contains(newCon) && newCon instanceof ENet)
			return connections.add(newCon);
		return false;
	}

	@Override
	public String getNameIndex() {
		return this.name;
	}

	public List<EConnection> getNetlist() {
		return netlist;
	}

	@Override
	public NodeType getNodeType() {
		return NodeType.DESIGN;
	}

	public Map<String, EInstance> getRefMap() {
		return refMap;
	}

	public void makeNetlist() {
		for (EConnection c : connections) {
			if (c.isFlat()) {
				netlist.add(c);
			}
		}
		for (ESubInstance s : subInsts) {
			s.appendToNetlist(netlist);
		}
	}

	@Override
	public void setConnections(List<EConnection> connections) {
		connections = new ArrayList<EConnection>();
		for (EConnection c : connections) {
			if (c instanceof ENet) {
				connections.add(c);
			}
		}
	}

	public void setRefMap(Map<String, EInstance> refMap) {
		this.refMap = refMap;
	}

}
