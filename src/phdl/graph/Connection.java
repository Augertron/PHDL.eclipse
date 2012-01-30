package phdl.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public abstract class Connection extends Attributable {

	private final Set<Connection> cons;
	private final List<Pin> pins;
	private DesignUnit parent;
	private int index;
	private boolean visited;

	public Connection(DesignUnit parent) {
		super();
		pins = new ArrayList<Pin>();
		cons = new TreeSet<Connection>();
		this.parent = parent;
		this.index = -1;
	}

	public Connection(DesignUnit parent, Connection old) {
		super(old);
		pins = new ArrayList<Pin>();
		cons = new TreeSet<Connection>();
		this.index = old.getIndex();
		this.parent = parent;
		setName(old.getName());
	}

	public Connection(DesignUnit parent, String name) {
		super();
		pins = new ArrayList<Pin>();
		cons = new TreeSet<Connection>();
		this.index = -1;
		this.parent = parent;
		setName(name);
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

	@Override
	public int compareTo(Object o) {
		Connection c = (Connection) o;
		if (this.equals(c)) {
			return 0;
		}
		if (this.getNameIndex().compareTo(c.getNameIndex()) == 0)
			return this.getParent().compareTo(c.getParent());
		else
			return this.getNameIndex().compareTo(c.getNameIndex());
	}

	@Override
	public boolean equals(Object o) {
		return this.getName().equals(((Connection) o).getName()) && this.getIndex() == ((Connection) o).getIndex()
			&& this.getParent().equals(((Connection) o).getParent());
	}

	public Connection getConnectionByName(String name) {
		for (Connection c : cons) {
			if (c.getName().equals(name)) {
				return c;
			}
		}
		return null;
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
	 * Returns the index of the current Net, assuming that it has an array reference.
	 * 
	 * @return the index of the Net
	 */
	public int getIndex() {
		return index;
	}

	public String getNameIndex() {
		return this.name + (hasIndex() ? "[" + this.index + "]" : "");
	}

	/**
	 * Parent DesignNode accessor method.
	 * 
	 * @return the NetNode's parent DesignNode
	 */
	public DesignUnit getParent() {
		return parent;
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

	/**
	 * Checks to see if any nets are attached to this net.
	 * 
	 * @return true, if there are nets attached, false, if there aren't
	 */
	public boolean hasConnections() {
		return (!cons.isEmpty());
	}

	public boolean hasIndex() {
		if (getIndex() == -1)
			return false;
		else
			return true;
	}

	public boolean hasPins() {
		return !pins.isEmpty();
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
	 * Removes a net connection from this net.
	 * 
	 * @param n
	 *            the net to remove
	 */
	public void removeConnection(Connection c) {
		cons.remove(c);
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public void setName(String name) {
		this.name = name.toUpperCase();
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
	 * Helper mutator method for a Depth First Search.
	 * 
	 * @param visited
	 *            the new value of visited
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	@Override
	/**
	 * Generic toString method.
	 * 
	 * @return a string representation of the NetNode
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		String fieldFmtStr = "  %-8s%2s%-26.26s\n";
		String attrFmtStr = "  %4d%2s%-16.16s%2s%-24.24s\n";
		String pinFmtStr = "  %4d%2s%-8.8s%2s%-16.16s%2s%-16.16s%2s%-16.16s\n";
		String connFmtStr = "  %4d%2s%-8.8s%2s%-16.16s%2s%-16.16s\n";

		String idx = (getIndex() == -1) ? "" : ("[" + getIndex() + "]");
		String pidx = "";
		if (getParent() instanceof SubInstance) {
			pidx = (((SubInstance) getParent()).getIndex() != -1) ? ("(" + ((SubInstance) getParent()).getIndex() + ")")
				: "";
		}
		sb.append(String.format(fieldFmtStr, "Name:", "", getName() + idx));
		sb.append(String.format(fieldFmtStr, "Parent:", "", getParent().getName() + pidx));
		sb.append(String.format(fieldFmtStr, "ID:", "", Integer.toHexString(System.identityHashCode(this))));
		if (this instanceof Port) {
			Port p = ((Port) this);
			String index = (p.hasIndex() ? ("[" + p.getIndex() + "]") : "");
			String connection = "";
			if (p.isAssigned()) {
				connection = p.getAssignment().getNodeType() + ": " + p.getAssignment().getName();
				if (p.getAssignment().hasIndex())
					connection += "[" + p.getAssignment().getIndex() + "]";
			} else
				connection += "(not assigned)";
			sb.append(String.format(fieldFmtStr, "Assign:", "", connection));
		}
		sb.append("\n");

		if (!attributes.isEmpty()) {
			sb.append("  Attr        Name                   Value           \n");
			sb.append("  ----  ----------------  -------------------------- \n");
			int attrCount = 1;
			for (Attribute a : attributes) {
				sb.append(String.format(attrFmtStr, attrCount, "", a.getName(), "", a.getValue().equals("") ? "(empty)"
					: a.getValue()));
				attrCount++;
			}
			sb.append("\n");
		}

		if (!pins.isEmpty()) {
			sb.append("  Pin     Type          Name            Instance           Design    \n");
			sb.append("  ----  --------  ----------------  ----------------  ----------------\n");
			int pinCount = 1;
			for (Pin p : pins) {
				String index = p.getIndex() == -1 ? "" : ("[" + p.getIndex() + "]");
				String pindex = "";
				if (p.getParent() instanceof Instance)
					pindex = (((Instance) p.getParent()).hasIndex()) ? ("(" + ((Instance) p.getParent()).getIndex() + ")")
						: ("");
				String dindex = "";
				if (((Instance) p.getParent()).getParent() instanceof SubInstance)
					dindex = (((SubInstance) ((Instance) p.getParent()).getParent()).getIndex() != -1) ? ("("
						+ ((SubInstance) ((Instance) p.getParent()).getParent()).getIndex() + ")") : "";
				sb.append(String.format(pinFmtStr, pinCount, "", p.getPinType(), "", p.getName() + index, "", p
					.getParent().getName() + pindex, "", ((Instance) p.getParent()).getParent().getName() + dindex));
				pinCount++;
			}
			sb.append("\n");
		}

		if (!cons.isEmpty()) {
			sb.append("  Conn    Type          Name             Parent      \n");
			sb.append("  ----  --------  ----------------  ---------------- \n");
			int connCount = 1;
			for (Connection c : cons) {
				sb.append(String.format(connFmtStr, connCount, "", c.getNodeType(), "", c.getNameIndex(), "", c
					.getParent().getNameIndex()));
				connCount++;
			}
			sb.append("\n");
		}

		return sb.toString();
	}
}
