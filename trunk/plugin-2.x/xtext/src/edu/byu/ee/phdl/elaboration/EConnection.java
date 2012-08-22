package edu.byu.ee.phdl.elaboration;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public abstract class EConnection extends Attributable {

	private final Set<EConnection> cons;
	private int index;
	private EDesignUnit parent;
	private final List<EPin> pins;
	private boolean isVisited;
	private boolean isFlat;

	public EConnection(EDesignUnit parent) {
		super();
		pins = new ArrayList<EPin>();
		cons = new TreeSet<EConnection>();
		this.parent = parent;
		this.index = -1;
	}

	public EConnection(EDesignUnit parent, EConnection old) {
		super(old);
		pins = new ArrayList<EPin>();
		cons = new TreeSet<EConnection>();
		this.index = old.getIndex();
		this.parent = parent;
		setName(old.getName());
	}

	public EConnection(EDesignUnit parent, String name) {
		super();
		pins = new ArrayList<EPin>();
		cons = new TreeSet<EConnection>();
		this.index = -1;
		this.parent = parent;
		setName(name);
	}

	public boolean addConnection(EConnection c) {
		if (c != null)
			return cons.add(c);
		return false;
	}

	public boolean addPin(EPin p) {
		if (p != null)
			return (!pins.add(p));
		return false;
	}

	@Override
	public int compareTo(Object o) {
		EConnection c = (EConnection) o;
		int result = -1;
		if (this.equals(c)) {
			result = 0;
		} else {
			result = this.getHierarchyName().compareTo(c.getHierarchyName());
		}
		return result;
	}

	public boolean connectTo(EConnection connection) {
		return (this.addConnection(connection) && connection.addConnection(this));
	}

	@Override
	public boolean equals(Object o) {
		boolean result = this.getName().equals(((EConnection) o).getName())
				&& this.getIndex() == ((EConnection) o).getIndex();

		if (this.getParent() instanceof ESubInstance && ((EConnection) o).getParent() instanceof ESubInstance) {
			result &= ((ESubInstance) this.getParent()).equals(((EConnection) o).getParent());
		} else if (this.getParent() instanceof ESubInstance || ((EConnection) o).getParent() instanceof ESubInstance) {
			result &= false;
		} else {
			result &= this.getParent().equals(((EConnection) o).getParent());
		}
		return result;
	}

	public EConnection getConnectionByName(String name) {
		for (EConnection c : cons) {
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
	public Set<EConnection> getConnections() {
		return cons;
	}

	public String getHierarchyName() {
		StringBuilder sb = new StringBuilder();
		EDesignUnit current = this.parent;
		while (current != null) {
			if (current instanceof ESubInstance) {
				sb.insert(0, current.getNameIndex() + "/");
				current = ((ESubInstance) current).getParent();
			} else
				current = null;
		}
		return sb.append(this.getNameIndex()).toString();
	}

	/**
	 * Returns the index of the current Net, assuming that it has an array
	 * reference.
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
	public EDesignUnit getParent() {
		return parent;
	}

	/**
	 * Pins accessor method.
	 * 
	 * This method is particularly helpful when generating a netlist.
	 * 
	 * @return the set of PinNodes attached to this net
	 */
	public List<EPin> getPins() {
		return pins;
	}

	/**
	 * Helper method for superNet algorithm.
	 * 
	 * Iterates through all nets attached to this NetNode and returns the first
	 * one that is unvisited.
	 * 
	 * @return the first NetNode that is unvisited, null if there aren't any
	 */
	public EConnection getUnvisitedConnection() {
		for (EConnection c : cons) {
			if (!((ENet) c).isVisited())
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

	public boolean isFlat() {
		return isFlat;
	}

	/**
	 * Helper acccessor method for a Depth First Search.
	 * 
	 * @return true, if this Node has been visited false, otherwise
	 */
	public boolean isVisited() {
		return isVisited;
	}

	/**
	 * Removes a net connection from this net.
	 * 
	 * @param n
	 *            the net to remove
	 */
	public void removeConnection(EConnection c) {
		cons.remove(c);
	}

	public void setFlat(boolean isFlat) {
		this.isFlat = isFlat;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Parent DesignNode mutator method.
	 * 
	 * @param parent
	 *            the new DesignNode
	 */
	public void setParent(EDesignUnit parent) {
		this.parent = parent;
	}

	/**
	 * Helper mutator method for a Depth First Search.
	 * 
	 * @param visited
	 *            the new value of visited
	 */
	public void setVisited(boolean visited) {
		this.isVisited = visited;
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
		if (getParent() instanceof ESubInstance) {
			pidx = (((ESubInstance) getParent()).getIndex() != -1) ? ("(" + ((ESubInstance) getParent()).getIndex() + ")")
					: "";
		}
		sb.append(String.format(fieldFmtStr, "Name:", "", getName() + idx));
		sb.append(String.format(fieldFmtStr, "Parent:", "", getParent().getName() + pidx));
		sb.append(String.format(fieldFmtStr, "ID:", "", Integer.toHexString(System.identityHashCode(this))));
		if (this instanceof EPort) {
			EPort p = ((EPort) this);
			// String index = (p.hasIndex() ? ("[" + p.getIndex() + "]") : "");
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
			for (EAttribute a : attributes) {
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
			for (EPin p : pins) {
				String index = p.getIndex() == -1 ? "" : ("[" + p.getIndex() + "]");
				String pindex = "";
				if (p.getParent() instanceof EInstance)
					pindex = (((EInstance) p.getParent()).hasIndex()) ? ("(" + ((EInstance) p.getParent()).getIndex() + ")")
							: ("");
				String dindex = "";
				if (((EInstance) p.getParent()).getParent() instanceof ESubInstance)
					dindex = (((ESubInstance) ((EInstance) p.getParent()).getParent()).getIndex() != -1) ? ("("
							+ ((ESubInstance) ((EInstance) p.getParent()).getParent()).getIndex() + ")") : "";
				sb.append(String.format(pinFmtStr, pinCount, "", p.getPinType(), "", p.getName() + index, "", p
						.getParent().getName() + pindex, "", ((EInstance) p.getParent()).getParent().getName() + dindex));
				pinCount++;
			}
			sb.append("\n");
		}

		if (!cons.isEmpty()) {
			sb.append("  Conn    Type          Name             Parent      \n");
			sb.append("  ----  --------  ----------------  ---------------- \n");
			int connCount = 1;
			for (EConnection c : cons) {
				sb.append(String.format(connFmtStr, connCount, "", c.getNodeType(), "", c.getNameIndex(), "", c
						.getParent().getNameIndex()));
				connCount++;
			}
			sb.append("\n");
		}

		return sb.toString();
	}
}
