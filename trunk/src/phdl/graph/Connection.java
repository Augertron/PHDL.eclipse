package phdl.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public abstract class Connection extends Attributable {

	private Set<Connection> cons;
	private List<Pin> pins;
	private DesignUnit parent;
	private int index;
	
	public Connection(DesignUnit parent) {
		pins = new ArrayList<Pin>();
		cons = new TreeSet<Connection>();
		this.parent = parent;
		this.name = null;
		this.index = -1;
	}
	
	public Connection(DesignUnit parent, String name) {
		pins = new ArrayList<Pin>();
		cons = new TreeSet<Connection>();
		this.parent = parent;
		this.name = name;
		this.index = -1;
	}
	
	/**
	 * Pins accessor method.
	 * 
	 * This method is particularly helpful when generating a netlist.
	 * 
	 * @return the set of PinNodes attached to this net
	 */
	public List<Pin> getPins() {
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
		if (p != null)
			return (!pins.add(p));
		return false;

	}

	/**
	 * Nets accessor method.
	 * 
	 * This method is particularly helpful when using the supernet alogorithm.
	 * 
	 * @return the set of NetNodes attached to this net
	 */
	public Set<Connection> getConnections() {
		return cons;
	}

	/**
	 * Checks to see if any nets are attached to this net.
	 * 
	 * @return true, if there are nets attached, false, if there aren't
	 */
	public boolean hasConnections() {
		return (!cons.isEmpty());
	}

	/**
	 * Removes a net connection from this net.
	 * 
	 * @param n
	 *            the net to remove
	 */
	public void removeConnection(Net n) {
		cons.remove(n);
	}

	/**
	 * NetNode addition method.
	 * 
	 * @param n
	 *            the new NetNode to add
	 * @return true, if the NetNode isn't already connected, false otherwise
	 */
	public boolean addConnection(Connection c) {
		if (c != null)
			return cons.add(c);
		return false;
	}
	
	/**
	 * Parent DesignNode mutator method.
	 * 
	 * @param parent
	 *            the new DesignNode
	 */
	public void setParent(DesignUnit parent) {
		this.parent = parent;
	}

	/**
	 * Parent DesignNode accessor method.
	 * 
	 * @return the NetNode's parent DesignNode
	 */
	public DesignUnit getParent() {
		return parent;
	}
	
	@Override
	/**
	 * Generic toString method.
	 * 
	 * @return a string representation of the NetNode
	 */
	public String toString() {
		String conString = super.toString() + ((index == -1) ? ("") : ("[" + index + "]")) + " $ ";
		
		for (Connection c : cons) {
			conString += c.getName() + ((c.getIndex() == -1) ? ("") : ("[" + c.getIndex() + "]"))
					+ " $ ";
		}
		conString = conString.substring(0, conString.length() - 3);
		
		for (Attribute a : attributes) {
			conString += "\n\t\t" + a.toString();
		}
		return conString;
	}


	/**
	 * Returns the index of the current Net, assuming that it has an array reference.
	 * 
	 * @return the index of the Net
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Helper method for superNet algorithm.
	 * 
	 * Iterates through all nets attached to this NetNode and returns the first one that is
	 * unvisited.
	 * 
	 * @return the first NetNode that is unvisited, null if there aren't any
	 */
	public Connection getUnvisitedConnection() {
		for (Connection c : cons) {
			if (!((Net) c).isVisited())
				return c;
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
		return this.getName().equals(((Connection) o).getName())
			&& this.getParent().equals(((Connection) o).getParent())
			&& this.getIndex() == ((Connection) o).getIndex();
	}
}
