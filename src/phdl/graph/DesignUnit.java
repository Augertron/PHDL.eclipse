package phdl.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class DesignUnit extends Node {
	protected List<Instance> instances;
	protected List<SubInstance> subInsts;
	protected List<Connection> connections;

	/**
	 * Default Constructor.
	 * 
	 * Initializes all sets and lists of ports, sub instances, instances, and nets.
	 * 
	 * @see Port
	 * @see Instance
	 * @see Net
	 * @see SubInstance
	 */
	public DesignUnit() {
		super();
		instances = new ArrayList<Instance>();
		subInsts = new ArrayList<SubInstance>();
		connections = new ArrayList<Connection>();
	}

	/**
	 * 
	 * @param newCon
	 * @return	true, if the connection wasn't already in the list and was added successfully
	 * 			false, otherwise
	 */
	public boolean addConnection(Connection newCon) {
		if (!connections.contains(newCon)) {
			return connections.add(newCon);
		}
		return false;
	}

	/**
	 * 
	 * @param newInst
	 * @return	true, if the instance wasn't already in the list and was added successfully
	 * 			false, otherwise
	 */
	public boolean addInstance(Instance newInst) {
		if (!instances.contains(newInst)) {
			return instances.add(newInst);
		}
		return false;
	}

	/**
	 * 
	 * @param newSub
	 * @return	true, if the sub instance wasn't already in the list and was added successfully
	 * 			false, otherwise
	 */
	public boolean addSubInst(SubInstance newSub) {
		if (!subInsts.contains(newSub))
			return subInsts.add(newSub);
		return false;
	}

	@Override
	/**
	 * Checks to see if the current DesignNode is equal to
	 * another.
	 * 
	 * @param o	the DesignNode being compared against
	 * @return 	true, if the designs are equals
	 * 			false, otherwise
	 */
	public boolean equals(Object o) {
		return name.equals(((DesignUnit) o).getName());
	}

	public List<Port> getAllPorts(String name) {
		List<Port> allPorts = new ArrayList<Port>();
		for (Connection c : connections) {
			if (c instanceof Port) {
				if (c.getName().equals(name))
					allPorts.add((Port) c);
			}
		}
		return allPorts;
	}

	public Connection getConnection(String name, int index) {
		for (Connection c : connections) {
			if (c.getName().equals(name) && c.getIndex() == index)
				return c;
		}
		return null;
	}

	public List<Connection> getConnections() {
		return connections;
	}

	public List<Connection> getConnectionsByName(String name) {
		List<Connection> allCons = new ArrayList<Connection>();
		for (Connection c : connections) {
			if (c.getName().equals(name.toUpperCase()))
				allCons.add(c);
		}
		return allCons;
	}

	/**
	 * Finds and return an InstanceNode that has a certain name.
	 * If the Instance Node has an index, the function returns null.
	 * 
	 * @param name
	 * @return
	 */
	public Instance getInstance(String name) {
		return getInstance(name, -1);
	}

	/**
	 * Finds and returns an InstanceNode that has a certain name and index.
	 * 
	 * @param name
	 *            the name of the InstanceNode
	 * @return the InstanceNode with the instance name
	 */
	public Instance getInstance(String name, int index) {
		for (Instance i : instances) {
			if (i.getName().equals(name) && i.getIndex() == index)
				return i;
		}
		return null;
	}

	public List<Instance> getInstances() {
		return instances;
	}

	/**
	 * Finds all InstanceNodes with the same name and returns a
	 * list of them.
	 * 
	 * @param instName	the base name of the Instance
	 * @return a List of InstanceNodes with the same name
	 */
	public List<Instance> getInstancesByName(String instName) {
		List<Instance> insts = new ArrayList<Instance>();
		for (Instance i : instances) {
			if (i.getName().equals(instName))
				insts.add(i);
		}
		return insts;
	}

	/**
	 * Finds and returns a Net that has a certain name.
	 * 
	 * @param name
	 *            the name of the NetNode
	 * @return the NetNode with the net name
	 */
	public Net getNet(String name, int index) {
		for (Connection c : connections) {
			if (c instanceof Net) {
				Net n = (Net) c;
				if (n.getName().equals(name.toUpperCase()) && n.getIndex() == index)
					return n;
			}
		}
		return null;
	}

	public List<Net> getNets() {
		List<Net> nets = new ArrayList<Net>();
		for (Connection c : connections) {
			if (c instanceof phdl.graph.Net) {
				nets.add((Net) c);
			}
		}
		return nets;
	}

	/**
	 * Finds all NetNodes with the same name and returns a list of them.
	 * 
	 * @param netName	the base name of the Net
	 * @return a List of NetNodes with the same name
	 */
	public List<Net> getNetsByName(String netName) {
		List<Net> allNets = new ArrayList<Net>();
		for (Connection c : connections) {
			if (!(c instanceof phdl.graph.Net))
				continue;
			Net n = (Net) c;
			if (n.getName().equals(netName.toUpperCase()))
				allNets.add(n);
		}
		return allNets;
	}

	/**
	 * Finds and returns a Port that has a certain name.
	 * 
	 * @param name
	 *            the name of the NetNode
	 * @return the NetNode with the net name
	 */
	public Port getPort(String name, int index) {
		for (Connection c : connections) {
			if (c instanceof phdl.graph.Port) {
				Port p = (Port) c;
				if (p.getName().equals(name.toUpperCase()) && p.getIndex() == index)
					return p;
			}
		}
		return null;
	}

	public List<Port> getPortsByName(String portName) {
		List<Port> allPorts = new ArrayList<Port>();
		for (Connection c : connections) {
			if (!(c instanceof Port))
				continue;
			Port p = (Port) c;
			if (p.getName().equals(portName.toUpperCase()))
				allPorts.add(p);
		}
		return allPorts;
	}

	public SubInstance getSubInstance(String name, int index) {
		for (SubInstance s : subInsts) {
			if (s.getName().equals(name) && s.getIndex() == index)
				return s;
		}
		return null;
	}

	public List<SubInstance> getSubInstances() {
		return subInsts;
	}

	public List<SubInstance> getSubInstancesByName(String instName) {
		List<SubInstance> insts = new ArrayList<SubInstance>();
		for (SubInstance s : subInsts) {
			if (s.getName().equals(instName))
				insts.add(s);
		}
		return insts;
	}

	/**
	 * Checks to see if a particular device is instanced in the design.
	 * 
	 * @param dev
	 *            the device to check
	 * @return true, if there exists an instance that references the device false, otherwise
	 */
	public boolean isDeviceInstanced(Device dev) {
		for (Instance i : instances) {
			if (i.getDevice().equals(dev))
				return true;
		}
		return false;
	}

	/**
	 * Merges the names of the current net with the names of all neighbors by using a depth-first
	 * search.
	 * 
	 * @param neighbor2
	 * @return net with merged name from all unvisited neighbor's names
	 */
	private Net merge(Connection neighbor2) {

		Set<Net> removes = new HashSet<Net>();

		// set the current node as visited
		((Net) neighbor2).setVisited(true);

		// visit and process all of its neighbors
		for (Connection neighbor : neighbor2.getConnections()) {
			if (!((Net) neighbor).isVisited()) {

				neighbor = merge(neighbor);

				// append the name of its neighbor
				//Deprecated: current.setName(current.getName() + "$" + neighbor.getName());
				removes.add((Net) neighbor);

				// grab all of its neighbors pins
				for (Pin p : neighbor.getPins()) {
					neighbor2.addPin(p);
					p.setConnection(neighbor2);
				}

			}
		}

		// remove all current's connections to neighbors
		for (Net r : removes)
			neighbor2.removeConnection(r);

		// propagate the merged net back up the call-stack
		return (Net) neighbor2;
	}

	public void setConnections(List<Connection> connections) {
		this.connections = connections;
	}

	public void setInstances(List<Instance> instances) {
		this.instances = instances;
	}

	public void setSubInstances(List<SubInstance> subInsts) {
		this.subInsts = subInsts;
	}

	/**
	 * Merges all net-net connections.
	 */
	public void superNet2() {
		// any net that is set as visited will be deleted
		Set<Net> deletes = new HashSet<Net>();

		// go through all nets in the design
		for (Connection c : connections) {
			if (!(c instanceof phdl.graph.Net)) {
				continue;
			}
			Net n = (Net) c;
			if (!n.isVisited()) {
				// call the merge routine on any unvisited net
				n = merge(n);
				// make sure merged net isn't deleted.
				n.setVisited(false);
			}
		}

		// gather up all the nets to be deleted from the design
		for (Connection c : connections) {
			if (!(c instanceof phdl.graph.Net)) {
				continue;
			}
			Net n = (Net) c;
			if (n.isVisited())
				deletes.add(n);
		}

		// delete these nets from the design
		for (Net n : deletes)
			connections.remove(n);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		String fieldFmtStr = "  %-8s%2s%-26.26s\n";
		String connFmtStr = "    %4d%2s%-8.8s%2s%-16.16s\n";
		String instFmtStr = "    %4d%1s%-16.16s%1s%-12.12s%1s%-16.16s%1s%-16.16s\n";
		String subFmtStr = "    %4d%1s%-16.16s%1s%-16.16s%1s%-24.24s\n";
		String instIndent = "    ";
		String connIndent = "    ";

		String idx = "";
		if (this instanceof SubInstance)
			idx = (((SubInstance) this).getIndex() == -1) ? "" : ("("
				+ ((SubInstance) this).getIndex() + ")");
		sb.append(String.format(fieldFmtStr, "Name:", "", getName() + idx));
		sb.append("\n");

		if (!connections.isEmpty() || !instances.isEmpty() || !subInsts.isEmpty())
			sb.append("  Summary:\n\n");

		if (!connections.isEmpty()) {
			sb.append("    Conn    Type          Name      \n");
			sb.append("    ----  --------  ---------------- \n");
			int connCount = 1;
			for (Connection c : connections) {
				String index = c.getIndex() != -1 ? ("[" + c.getIndex() + "]") : "";
				sb.append(String.format(connFmtStr, connCount, " ", c.getNodeType(), " ",
					c.getName() + index));
				connCount++;
			}
			sb.append("\n");
		}

		if (!instances.isEmpty()) {
			sb.append("    Inst       Name          Device         Parent           Group        \n");
			sb.append("    ---- ---------------- ------------ ---------------- ----------------  \n");
			int instCount = 1;
			for (Instance i : instances) {
				sb.append(String.format(instFmtStr, instCount, "", i.getName()
					+ (i.getIndex() == -1 ? "" : ("(" + i.getIndex() + ")")), "", i.getDevice()
					.getName(), "", i.getParent().getName(), " ", i.getGroupName()));
				instCount++;
			}
			sb.append("\n");
		}

		if (!subInsts.isEmpty()) {
			sb.append("    Sub        Name          SubDesign             Location          \n");
			sb.append("    ---- ---------------- ---------------- ------------------------  \n");
			int subCount = 1;
			for (SubInstance s : subInsts) {
				String index = s.getIndex() != -1 ? ("(" + s.getIndex() + ")") : "";
				sb.append(String.format(subFmtStr, subCount, "", s.getName() + index, "", s
					.getSubDesign().getName(), "",
					s.getFileName() + ", " + s.getLine() + ":" + s.getPosition()));
			}
			sb.append("\n");
		}

		if (!connections.isEmpty() || !instances.isEmpty())
			sb.append("  Details:\n");

		if (!instances.isEmpty()) {
			for (Instance i : instances) {
				sb.append(i.toString().replace("\n", "\n" + instIndent));
			}
			sb.append("\n");
		}

		if (!connections.isEmpty()) {
			for (Connection c : connections) {
				sb.append(c.toString().replace("\n", "\n" + connIndent));
			}
			sb.append("\n");
		}

		if (!subInsts.isEmpty()) {
			String nameFmtStr = "    %-8s%2s%-26.26s\n";
			for (SubInstance s : subInsts) {
				sb.append("\n  ======================================================================\n"
					+ "  " + s.getNodeType() + "\n\n");
				sb.append(String.format(nameFmtStr, "File:", "", getFileName() + ", " + getLine()
					+ ":" + getPosition()));
				String index = s.getIndex() != -1 ? ("(" + s.getIndex() + ")") : "";
				sb.append(String.format(nameFmtStr, "Name: ", "", s.getName() + index));
				String pidx = "";
				if (s.getParent() instanceof SubInstance)
					pidx = (((SubInstance) s.getParent()).getIndex() != -1) ? ("("
						+ ((SubInstance) s.getParent()).getIndex() + ")") : "";
				sb.append(String.format(nameFmtStr, "Parent: ", "", s.getParent().getName() + pidx));
				sb.append("\n");

				List<Port> ports = s.getPorts();
				if (ports.size() > 0) {
					for (Port p : ports) {
						sb.append(p.toString().replace("\n", "\n    "));
					}
				}

			}
			sb.append("\n");
		}

		return sb.toString();
	}
}
