package phdl.graph;

import java.util.HashSet;
import java.util.Set;

/*
 * TODO test the supernet algorithm again, since the
 * NetNode got an essentially complete overhaul.
 */
public class NetNode extends Attributable {

	private Set<NetNode> nets;
	private Set<PinNode> pins;
	private DesignNode design;
	
	/**
	 * Default Constructor.
	 * 
	 * @param d the DesignNode that is the parent of this net
	 */
	public NetNode(DesignNode d) {
		setDesign(d);
		nets = new HashSet<NetNode>();
		pins = new HashSet<PinNode>();
	}
	
	/**
	 * Pins accessor method.
	 * 
	 * This method is particularly helpful when generating
	 * a netlist.
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
	 * This method is particularly helpful when using the
	 * supernet alogorithm.
	 * 
	 * @return the set of NetNodes attached to this net
	 */
	public Set<NetNode> getNetNodes() {
		return nets;
	}
	
	/**
	 * Checks to see if any nets are attached to this net.
	 * 
	 * @return 	true, if there are nets attached,
	 * 			false, if there aren't
	 */
	public boolean hasNets() {
		return (!nets.isEmpty());
	}
	
	/**
	 * Removes a net connection from this net.
	 * 
	 * @param n the net to remove
	 */
	public void removeNet(NetNode n) {
		for (NetNode p : this.getNetNodes()) {
			if (p.equals(n)) {
				nets.remove(p);
			}
		}
	}
	
	/**
	 * NetNode addition method.
	 * 
	 * @param n the new NetNode to add
	 * @return	true, if the NetNode isn't already connected
	 * 			false, otherwise
	 */
	public boolean addNet(NetNode n) {
		return (!nets.add(n));
	}
	
	/**
	 * Merges two nets into a single one.
	 * 
	 * @param n the NetNode to merge with
	 * @return	true, if thet NetNode is connected to this one
	 * 			false, otherwise
	 */
	public boolean mergeNet(NetNode n) {
		for (NetNode m : this.getNetNodes()) {
			if (m.equals(n)) {
				for (NetNode a : m.getNetNodes()) {
					addNet(a);
					((NetNode)a).removeNet(m);
				}
				for (PinNode p : m.getPinNodes()) {
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
	
	/**
	 * The supernet algorithm.
	 * 
	 * This iterates through the set of nets and merges them
	 * with the current one.
	 */
	public void superNet() {
		while (!getNetNodes().isEmpty()) {
			for (NetNode n : getNetNodes()) {
				this.mergeNet(n);
			}
		}
	}

	@Override
	public NodeType getType() {
		return NodeType.NET;
	}

	/**
	 * Debugging method to print the netgraph.
	 * 
	 * @param cur the current net being printed
	 * @param nodes a set of all nets already processed
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
	 * @param design the new DesignNode
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
}
