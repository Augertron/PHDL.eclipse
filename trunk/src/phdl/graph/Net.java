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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * A class that represents a net in PHDL.
 * 
 * @author Brad Riching and Richard Black
 * @version 0.1
 */
public class Net extends Attributable {

	private Set<Net> nets;
	private List<Pin> pins;
	private Design design;
	private int index;
	private boolean visited = false;

	/**
	 * Default Constructor.
	 * 
	 * @param d
	 *            the DesignNode that is the parent of this net
	 */
	public Net(Design design) {
		super();
		pins = new ArrayList<Pin>();
		nets = new TreeSet<Net>();
		this.design = design;
		this.index = -1;
	}

	/**
	 * Helper acccessor method for a Depth First Search.
	 * 
	 * @return true, if this Node has been visited false, otherwise
	 */
	public boolean isVisited() {
		return visited;
	}

	/**
	 * Helper mutator method for a Depth First Search.
	 * 
	 * @param visited
	 *            the new value of visited
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	/**
	 * Pins accessor method.
	 * 
	 * This method is particularly helpful when generating a netlist.
	 * 
	 * @return the set of PinNodes attached to this net
	 */
	public List<Pin> getPinNodes() {
		return pins;
	}

	/**
	 * Pin addition method.
	 * 
	 * @param p
	 *            the new PinNode
	 * @return true, if the pin wasn't in the List false, otherwise
	 */
	public boolean addPin(Pin p) {
		return (!pins.add(p));
	}

	/**
	 * Nets accessor method.
	 * 
	 * This method is particularly helpful when using the supernet alogorithm.
	 * 
	 * @return the set of NetNodes attached to this net
	 */
	public Set<Net> getNetNodes() {
		return nets;
	}

	/**
	 * Checks to see if any nets are attached to this net.
	 * 
	 * @return true, if there are nets attached, false, if there aren't
	 */
	public boolean hasNets() {
		return (!nets.isEmpty());
	}

	/**
	 * Removes a net connection from this net.
	 * 
	 * @param n
	 *            the net to remove
	 */
	public void removeNet(Net n) {
		nets.remove(n);
	}

	/**
	 * NetNode addition method.
	 * 
	 * @param n
	 *            the new NetNode to add
	 * @return true, if the NetNode isn't already connected, false otherwise
	 */
	public boolean addNet(Net n) {
		return (!nets.add(n));
	}

	/**
	 * Merges two nets into a single one.
	 * 
	 * @param n
	 *            the NetNode to merge with
	 * @return true, if that NetNode is connected to this one, false otherwise
	 */
	public boolean mergeNet(Net n) {
		for (Net m : this.getNetNodes()) {
			if (m.equals(n)) {
				for (Net a : m.getNetNodes()) {
					addNet(a);
					((Net) a).removeNet(m);
				}
				for (Pin p : m.getPinNodes()) {
					addPin(p);
				}
				nets.remove(m);
				nets.remove(this);
				name = name + "$" + m.getName();
				return true;
			}
		}
		return false;
	}

	@Override
	/**
	 * Type accessor method.
	 * 
	 * @return NodeType.NET
	 */
	public NodeType getNodeType() {
		return NodeType.NET;
	}

	/**
	 * Parent DesignNode mutator method.
	 * 
	 * @param design
	 *            the new DesignNode
	 */
	public void setDesign(Design design) {
		this.design = design;
	}

	/**
	 * Parent DesignNode accessor method.
	 * 
	 * @return the NetNode's parent DesignNode
	 */
	public Design getDesign() {
		return design;
	}

	@Override
	/**
	 * Generic toString method.
	 * 
	 * @return a string representation of the NetNode
	 */
	public String toString() {
		String netString = super.toString() + ((index == -1) ? ("") : ("[" + index + "]")) + " $ ";
		for (Net n : nets) {
			netString += n.getName() + ((n.getIndex() == -1) ? ("") : ("[" + n.getIndex() + "]"))
					+ " $ ";
		}
		netString = netString.substring(0, netString.length() - 3);
		for (Attribute a : attributes) {
			netString += "\n\t\t" + a.toString();
		}
		return netString;
	}

	/**
	 * Returns the index of the current Net, assuming that it has an array reference.
	 * 
	 * @return the index of the Net
	 */
	public int getIndex() {
		int start = getName().indexOf('[');
		int end = getName().indexOf(']');

		if (start == -1 || end == -1) {
			return -1;
		}

		String index = getName().substring(start + 1, end);
		return Integer.parseInt(index);
	}

	/**
	 * Helper method for superNet algorithm.
	 * 
	 * Iterates through all nets attached to this NetNode and returns the first one that is
	 * unvisited.
	 * 
	 * @return the first NetNode that is unvisited, null if there aren't any
	 */
	public Net getUnvisitedNet() {
		for (Net n : nets) {
			if (!n.isVisited())
				return n;
		}
		return null;
	}

	@Override
	public void setName(String name) {
		this.name = name.toUpperCase();
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public boolean equals(Object o) {
		return this.name.equals(((Net) o).getName()) && this.index == ((Net) o).getIndex();
	}
}
