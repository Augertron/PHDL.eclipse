package phdl.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
 * TODO test the supernet algorithm again, since the
 * NetNode got an essentially complete overhaul.
 */
public class NetNode extends Attributable {

	private List<NetNode> nets;
	private Set<PinNode> pins;
	private DesignNode design;

	/**
	 * Default Constructor.
	 * 
	 * @param d
	 *            the DesignNode that is the parent of this net
	 */
	public NetNode(DesignNode d) {
		super();
		setDesign(d);
		nets = new ArrayList<NetNode>();
		pins = new TreeSet<PinNode>();
	}

	/**
	 * Pins accessor method.
	 * 
	 * This method is particularly helpful when generating a netlist.
	 * 
	 * @return the set of PinNodes attached to this net
	 */
	public Set<PinNode> getPinNodes() {
		return pins;
	}

	public boolean addPin(PinNode p) {
		return (!pins.add(p));
	}

	/**
	 * Nets accessor method.
	 * 
	 * This method is particularly helpful when using the supernet alogorithm.
	 * 
	 * @return the set of NetNodes attached to this net
	 */
	public List<NetNode> getNetNodes() {
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
	public void removeNet(NetNode n) {
		nets.remove(n);
	}

	/**
	 * NetNode addition method.
	 * 
	 * @param n
	 *            the new NetNode to add
	 * @return true, if the NetNode isn't already connected, false otherwise
	 */
	public boolean addNet(NetNode n) {
		return (!nets.add(n));
	}

	/**
	 * Merges two nets into a single one.
	 * 
	 * @param subNet
	 *            the NetNode to merge with
	 * @return true, if that NetNode is connected to this one, false otherwise
	 */
	public void mergeNet(NetNode subNet) {

		for (NetNode n : subNet.nets) {
			if (!n.equals(this)) {
				this.nets.add(n);
				n.removeNet(subNet);
				n.addNet(this);
			}
		}
		this.removeNet(subNet);

		for (PinNode p : subNet.pins)
			this.addPin(p);

		this.name = this.name + "$" + subNet.name;

	}

	/**
	 * The superNet algorithm.
	 * 
	 * This iterates through the list of nets and merges them with the current
	 * one.
	 */
	public void superNet() {
		while (!this.nets.isEmpty()) {
			this.mergeNet(this.nets.get(0));

		}
	}

	@Override
	public NodeType getType() {
		return NodeType.NET;
	}

	/**
	 * Debugging method to print the netgraph.
	 * 
	 * @param cur
	 *            the current net being printed
	 * @param nodes
	 *            a set of all nets already processed
	 */
	private static void printGraph(NetNode cur, Set<NetNode> nodes) {
		if (!nodes.contains(cur)) {
			nodes.add(cur);
			System.out.println(cur.toString());
			for (PinNode n : cur.getPinNodes()) {
				System.out.println("\t" + n.toString());
			}
			for (NetNode n : cur.getNetNodes()) {
				System.out.println("\t" + n.toString());
			}
			for (NetNode n : cur.getNetNodes()) {
				printGraph(n, nodes);
			}
		}
	}

	/**
	 * Parent DesignNode mutator method.
	 * 
	 * @param design
	 *            the new DesignNode
	 */
	public void setDesign(DesignNode design) {
		this.design = design;
	}

	/**
	 * Parent DesignNode accessor method.
	 * 
	 * @return the NetNode's parent DesignNode
	 */
	public DesignNode getDesign() {
		return design;
	}

	@Override
	public String toString() {
		String myString = super.toString() + " $ ";
		for (NetNode n : nets) {
			myString += n.getName() + " $ ";
		}
		myString = myString.substring(0, myString.length() - 3);
		for (AttributeNode a : attrs) {
			myString += "\n\t\t" + a.toString();
		}
		return myString;
	}

	public int getIndex() {
		int start = getName().indexOf('[');
		int end = getName().indexOf(']');

		if (start == -1 || end == -1) {
			return -1;
		}

		String index = getName().substring(start + 1, end);
		return Integer.parseInt(index);
	}
}
