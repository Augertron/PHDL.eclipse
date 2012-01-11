package phdl.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public abstract class Connection extends Attributable {

	private Set<Net> nets;
	private List<Pin> pins;
	private DesignUnit design;
	private int index;
	
	public Connection(DesignUnit design) {
		pins = new ArrayList<Pin>();
		nets = new TreeSet<Net>();
		this.design = design;
		this.name = null;
		this.index = -1;
	}
	
	public Connection(DesignUnit design, String name) {
		pins = new ArrayList<Pin>();
		nets = new TreeSet<Net>();
		this.design = design;
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
		if (n != null)
			return nets.add(n);
		return false;
	}
	
	/**
	 * Parent DesignNode mutator method.
	 * 
	 * @param design
	 *            the new DesignNode
	 */
	public void setDesign(DesignUnit design) {
		this.design = design;
	}

	/**
	 * Parent DesignNode accessor method.
	 * 
	 * @return the NetNode's parent DesignNode
	 */
	public DesignUnit getDesign() {
		return design;
	}
	
	@Override
	/**
	 * Generic toString method.
	 * 
	 * @return a string representation of the NetNode
	 */
	public String toString() {
		String conString = super.toString() + ((index == -1) ? ("") : ("[" + index + "]")) + " $ ";
		
		for (Net n : nets) {
			conString += n.getName() + ((n.getIndex() == -1) ? ("") : ("[" + n.getIndex() + "]")) 
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
}
