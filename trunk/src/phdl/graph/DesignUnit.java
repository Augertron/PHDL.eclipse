package phdl.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class DesignUnit extends Node {
	protected List<Instance> instances;
	protected List<SubInstance> subInsts;
	protected List<Connection> connections;
	protected int index = -1;

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

	public void clearVisited() {
		for (Connection c : connections)
			c.setVisited(false);
	}

	@Override
	public int compareTo(Object o) {
		return this.getNameIndex().compareTo(((DesignUnit) o).getNameIndex());
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
		return name.equals(((DesignUnit) o).getName()) && index == ((DesignUnit) o).index;
	}

	public void execSysCommand(String command) {
		String s = null;
		try {
			Process p = Runtime.getRuntime().exec(command);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

			while ((s = stdInput.readLine()) != null) {
				System.out.println(s);
			}

			while ((s = stdError.readLine()) != null) {
				System.out.println(s);
			}

			try {
				p.waitFor();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Port> getAllPorts(String name) {
		List<Port> allPorts = new ArrayList<Port>();
		for (Connection c : connections) {
			if (c instanceof Port) {
				if (c.getName().equals(name.toUpperCase()))
					allPorts.add((Port) c);
			}
		}
		return allPorts;
	}

	public Connection getConnection(String name, int index) {
		for (Connection c : connections) {
			if (c.getName().equals(name.toUpperCase()) && c.getIndex() == index)
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

	public int getIndex() {
		return index;
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

	public String getNameIndex() {
		return this.name + (hasIndex() ? "(" + this.index + ")" : "");
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

	public boolean hasIndex() {
		if (getIndex() == -1)
			return false;
		else
			return true;
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
					p.setAssignment(neighbor2);
				}

			}
		}

		// remove all current's connections to neighbors
		for (Net r : removes)
			neighbor2.removeConnection(r);

		// propagate the merged net back up the call-stack
		return (Net) neighbor2;
	}

	public Map<String, List<Net>> netsToMap() {
		Map<String, List<Net>> map = new HashMap<String, List<Net>>();
		for (Connection c : connections) {
			if (c instanceof Net) {
				if (!map.keySet().contains(c.getName())) {
					List<Net> newList = new ArrayList<Net>();
					newList.add((Net) c);
					map.put(c.getName(), newList);
				} else
					map.get(c.getName()).add((Net) c);
			}
		}
		return map;
	}

	public Map<String, List<Port>> portsToMap() {
		Map<String, List<Port>> map = new HashMap<String, List<Port>>();
		for (Connection c : connections) {
			if (c instanceof Port) {
				if (!map.keySet().contains(c.getName())) {
					List<Port> newList = new ArrayList<Port>();
					newList.add((Port) c);
					map.put(c.getName(), newList);
				} else
					map.get(c.getName()).add((Port) c);
			}
		}
		return map;
	}

	public void printHierarchy() {
		System.out.println("\n  Design hierarchy:");
		printHierarchyRecursive(3);
		System.out.println();
	}

	public void printHierarchyRecursive(int numIndents) {
		String space = "";
		for (int i = 0; i < numIndents; i++)
			space += "  ";
		System.out.println(space + getNameIndex());
		for (SubInstance s : subInsts)
			s.printHierarchyRecursive(numIndents + 1);
	}

	public void setConnections(List<Connection> connections) {
		this.connections = connections;
	}

	public void setIndex(int index) {
		this.index = index;
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

	/**
	 * Writes a string to file
	 * @param fileName
	 * @param fileData
	 */
	public void toFile(String filePathName, String fileData) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(filePathName));
			bw.write(fileData);
			bw.close();
		} catch (IOException e) {
			System.out.println("Prolem writing file: " + filePathName + fileName);
			System.exit(1);
		}
	}

	/**
	 * Recursive routine that generates a DOT formated string of each DesignUnit
	 * 
	 * @param fileName
	 *            the name of the file being written
	 */
	public void toPNG() {
		StringBuilder sb = new StringBuilder();

		// Header information
		String name = "";
		if (this instanceof Design)
			name = this.getName() + " (TOP)";
		else
			name = this.getNameIndex() + " (SUBDESIGN)";
		sb.append("//PHDL Generated Dot file\n//Design unit: " + name + "\n//File: " + this.getFileName() + ", line "
			+ this.getLine() + ":" + this.getPosition() + "\n\n");
		sb.append("graph " + this.getName() + " {\n\n");
		sb.append("\tsplines=false;\n\n");

		// SubInstances
		if (!subInsts.isEmpty())
			sb.append("\t// SubInstances\n");
		for (SubInstance i : subInsts) {
			String iName = i.getNameIndex();
			sb.append("\tsubgraph \"cluster_" + iName + "\" {\n");
			sb.append("\t\tstyle=filled;\n");
			sb.append("\t\tcolor=lightgrey;\n");
			sb.append("\t\tlabel=\"SubInstance: " + iName + "\";\n");

			// SubInstance ports
			Map<String, List<Port>> map = i.portsToMap();
			if (!map.isEmpty()) {
				sb.append("\t\tsubgraph \"cluster_" + iName + "_ports\" {\n");
				sb.append("\t\t\tlabel=\"Ports:\";\n");
				sb.append("\t\t\tnode [shape=record, width=0.25, height=0.25];\n");
			}
			for (String s : map.keySet()) {
				int msb = map.get(s).get(0).getIndex();
				int lsb = map.get(s).get(map.get(s).size() - 1).getIndex();
				String array = (msb == lsb) ? "[" + msb + "]" : "[" + msb + ":" + lsb + "]";
				sb.append("\t\t\tsubgraph \"cluster_" + iName + "_ports_" + s + array + "\" {\n");
				if (map.get(s).size() == 1) {
					Port p = map.get(s).get(0);
					sb.append("\t\t\t\tlabel=\"" + s + (p.hasIndex() ? array : "") + "\";\n");
					sb.append("\t\t\t\t\"" + iName + "_" + s);
					sb.append("\" [label=\"<" + p.getIndex() + "> " + p.getIndex() + "\"];\n");
					sb.append("\t\t\t}\n");
				} else {
					sb.append("\t\t\t\tlabel=\"" + s + array + "\";\n");
					sb.append("\t\t\t\t\"" + iName + "_" + s + "\" [label=\"");
					for (Port p : map.get(s))
						sb.append("<" + p.getIndex() + "> " + p.getIndex() + " |");
					sb.delete(sb.length() - 2, sb.length());
					sb.append("\"];\n\t\t\t}\n");
				}
			}
			if (!map.isEmpty())
				sb.append("\t\t}\n");

			sb.append("\t}\n\n");
		}

		// Instances
		if (!instances.isEmpty())
			sb.append("\t// Instances\n");
		for (Instance i : instances) {
			String iName = i.getNameIndex();
			sb.append("\tsubgraph \"cluster_" + iName + "\" {\n");
			sb.append("\t\tstyle=filled;\n");
			sb.append("\t\tcolor=lightgrey;\n");
			sb.append("\t\tlabel=\"Instance: " + iName + "\";\n");

			// Instance Attributes
			if (!i.getAttributes().isEmpty()) {
				sb.append("\t\tsubgraph \"cluster_" + iName + "_attributes\" {\n");
				sb.append("\t\t\tlabel=\"Attributes:\";\n");
				sb.append("\t\t\tnode [shape=none];\n");
				sb.append("\t\t\t\"" + iName + "_attrs\" [label=\"");
			}
			for (Attribute a : i.getAttributes())
				sb.append(a.getName() + " = " + a.getValue() + "\\n");
			if (!i.getAttributes().isEmpty())
				sb.append("\"];\n\t\t}\n");

			// Instance Pins
			Map<String, List<Pin>> map = i.pinsToMap();
			if (!map.isEmpty()) {
				sb.append("\t\tsubgraph \"cluster_" + iName + "_pins\" {\n");
				sb.append("\t\t\tlabel=\"Pins:\";\n");
				sb.append("\t\t\tnode [shape=record, width=0.25, height=0.25];\n");
			}
			for (String s : map.keySet()) {
				int msb = map.get(s).get(0).getIndex();
				int lsb = map.get(s).get(map.get(s).size() - 1).getIndex();
				String array = (msb == lsb) ? "[" + msb + "]" : "[" + msb + ":" + lsb + "]";
				sb.append("\t\t\tsubgraph \"cluster_" + iName + "_pins_" + s + array + "\" {\n");
				if (map.get(s).size() == 1) {
					Pin p = map.get(s).get(0);
					sb.append("\t\t\t\tlabel=\"" + s + (p.hasIndex() ? array : "") + "\";\n");
					sb.append("\t\t\t\t\"" + iName + "_" + s);
					sb.append("\" [label=\"<" + p.getIndex() + "> " + p.getPinMapping() + "\"];\n");
					sb.append("\t\t\t}\n");
				} else {
					sb.append("\t\t\t\tlabel=\"" + s + array + "\";\n");
					sb.append("\t\t\t\t\"" + iName + "_" + s + "\" [label=\"");
					for (Pin p : map.get(s))
						sb.append("<" + p.getIndex() + "> " + p.getPinMapping() + " |");
					sb.delete(sb.length() - 2, sb.length());
					sb.append("\"];\n\t\t\t}\n");
				}
			}
			if (!map.isEmpty())
				sb.append("\t\t}\n");

			sb.append("\t}\n\n");
		}

		// Nets
		Map<String, List<Net>> netMap = this.netsToMap();
		if (!netMap.isEmpty())
			sb.append("\t// Nets\n");
		for (String s : netMap.keySet()) {
			int msb = netMap.get(s).get(0).getIndex();
			int lsb = netMap.get(s).get(netMap.get(s).size() - 1).getIndex();
			String array = (msb == lsb) ? "[" + msb + "]" : "[" + msb + ":" + lsb + "]";
			sb.append("\tsubgraph \"cluster_nets_" + s + array + "\" {\n");
			sb.append("\t\tstyle=filled;\n");
			sb.append("\t\tcolor=lightgrey;\n");
			sb.append("\t\tnode [shape=record, width=0.25, height=0.25];\n");
			sb.append("\t\tlabel=\"" + s + array + "\";\n");
			if (netMap.get(s).size() == 1) {
				Net n = netMap.get(s).get(0);
				sb.append("\t\t\"" + s + "\"");
				sb.append(" [label=\"<" + n.getIndex() + "> " + n.getIndex() + "\"];\n");
				sb.append("\t}\n");
			} else {
				sb.append("\t\t\"" + s + "\" [label=\"");
				for (Net n : netMap.get(s))
					sb.append("<" + n.getIndex() + "> " + n.getIndex() + " |");
				sb.delete(sb.length() - 2, sb.length());
				sb.append("\"];\n\t}\n");
			}
		}
		sb.append("\n");

		// Ports
		if (this instanceof SubInstance || this instanceof SubDesign) {
			Map<String, List<Port>> portMap = this.portsToMap();
			if (!portMap.isEmpty())
				sb.append("\t// Ports\n");
			for (String s : portMap.keySet()) {
				int msb = portMap.get(s).get(0).getIndex();
				int lsb = portMap.get(s).get(portMap.get(s).size() - 1).getIndex();
				String array = (msb == lsb) ? "[" + msb + "]" : "[" + msb + ":" + lsb + "]";
				sb.append("\tsubgraph \"cluster_nets_" + s + array + "\" {\n");
				sb.append("\t\tstyle=filled;\n");
				sb.append("\t\tcolor=lightgrey;\n");
				sb.append("\t\tnode [shape=record, width=0.25, height=0.25];\n");
				sb.append("\t\tlabel=\"" + s + array + "\";\n");
				if (portMap.get(s).size() == 1) {
					Port p = portMap.get(s).get(0);
					sb.append("\t\t\"" + s + "\"");
					sb.append(" [label=\"<" + p.getIndex() + "> " + p.getIndex() + "\"];\n");
					sb.append("\t}\n");
				} else {
					sb.append("\t\t\"" + s + "\" [label=\"");
					for (Port p : portMap.get(s))
						sb.append("<" + p.getIndex() + "> " + p.getIndex() + " |");
					sb.delete(sb.length() - 2, sb.length());
					sb.append("\"];\n\t}\n");
				}
			}
			sb.append("\n\n");
		}

		// Edges
		if (!connections.isEmpty()) {
			sb.append("\t// Edges\n");
			clearVisited();
			for (Connection c : connections) {
				// form edges from pins
				for (Pin p : c.getPins()) {
					Instance i = ((Instance) p.getParent());
					sb.append("\t\"" + c.getName() + "\":" + c.getIndex() + " -- \"");
					sb.append(i.getNameIndex() + "_" + p.getName() + "\":" + p.getIndex() + ";\n");
				}

				// form edges from other connections
				for (Connection dest : c.getConnections()) {
					if (!dest.isVisited()) {
						if (dest.getParent() instanceof Design) {
							sb.append("\t\"" + c.getName() + "\":" + c.getIndex() + " -- \"");
							sb.append(dest.getName() + "\":" + dest.getIndex() + ";\n");
						}
					}
					if (!(dest instanceof Port))
						dest.setVisited(true);
				}
				c.setVisited(true);
			}
			clearVisited();
		}

		for (SubInstance s : subInsts) {
			for (Port p : s.getPorts()) {
				if (p.isAssigned()) {
					sb.append("\t//edge from port\n");
					sb.append("\t\"" + p.getParent().getNameIndex() + "_" + p.getName() + "\":" + p.getIndex());
					sb.append(" -- \"" + p.getAssignment().getName() + "\":" + p.getAssignment().getIndex() + ";\n");
				}
			}
		}

		sb.append("}\n");

		// build up the path name based on the position in hierarchy
		StringBuilder path = new StringBuilder();
		String separator = System.getProperty("file.separator");
		if (this instanceof SubInstance) {
			SubInstance current = (SubInstance) this;
			while (current.getParent() instanceof SubInstance) {
				path.insert(0, current.getNameIndex() + separator);
				current = (SubInstance) current.getParent();
			}
			path.insert(0, current.getParent().getName() + separator + current.getNameIndex() + separator);
		} else if (this instanceof Design || this instanceof SubDesign)
			path.insert(0, getName() + separator);
		path.insert(0, "png" + separator);

		// attempt to make the directory structure
		File file = new File(path.toString());
		if (!file.isDirectory())
			file.mkdirs();

		// write the dot to file, convert it to a PNG, then delete the dot file.
		String fileName = path.toString() + getNameIndex();
		toFile(fileName + ".dot", sb.toString());
		execSysCommand("dot -Tpng " + fileName + ".dot -o " + fileName + ".png");
		File delFile = new File(fileName + ".dot");
		delFile.delete();
		System.out.println("  -- Generated: " + separator + fileName + ".png");

		// recursively output all SubInstances
		for (SubInstance s : subInsts)
			s.toPNG();
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

		if (this instanceof SubInstance)
			sb.append(String.format(fieldFmtStr, "Name:", "", getNameIndex()));
		else
			sb.append(String.format(fieldFmtStr, "Name:", "", getName()));
		sb.append(String.format(fieldFmtStr, "ID:", "", Integer.toHexString(System.identityHashCode(this))));
		sb.append("\n");

		if (!connections.isEmpty() || !instances.isEmpty() || !subInsts.isEmpty())
			sb.append("  Summary:\n\n");

		if (!connections.isEmpty()) {
			sb.append("    Conn    Type          Name      \n");
			sb.append("    ----  --------  ---------------- \n");
			int connCount = 1;
			for (Connection c : connections) {
				sb.append(String.format(connFmtStr, connCount, " ", c.getNodeType(), " ", c.getNameIndex()));
				connCount++;
			}
			sb.append("\n");
		}

		if (!instances.isEmpty()) {
			sb.append("    Inst       Name          Device         Parent           Group        \n");
			sb.append("    ---- ---------------- ------------ ---------------- ----------------  \n");
			int instCount = 1;
			for (Instance i : instances) {
				sb.append(String.format(instFmtStr, instCount, "", i.getNameIndex(), "", i.getDevice().getName(), "", i
					.getParent().getName(), " ", i.getGroupName()));
				instCount++;
			}
			sb.append("\n");
		}

		if (!subInsts.isEmpty()) {
			sb.append("    Sub        Name          SubDesign             Location          \n");
			sb.append("    ---- ---------------- ---------------- ------------------------  \n");
			int subCount = 1;
			for (SubInstance s : subInsts) {
				sb.append(String.format(subFmtStr, subCount, "", s.getNameIndex(), "", s.getSubDesign().getName(), "",
					s.getFileName() + ", " + s.getLine() + ":" + s.getPosition()));
			}
			sb.append("\n");
		}

		if (!connections.isEmpty() || !instances.isEmpty())
			sb.append("  Details:\n");

		if (!connections.isEmpty()) {
			for (Connection c : connections) {
				sb.append(c.toString().replace("\n", "\n" + connIndent));
			}
			sb.append("\n");
		}

		if (!instances.isEmpty()) {
			for (Instance i : instances) {
				sb.append(i.toString().replace("\n", "\n" + instIndent));
			}
			sb.append("\n");
		}

		if (!subInsts.isEmpty()) {
			String nameFmtStr = "    %-8s%2s%-26.26s\n";
			for (SubInstance s : subInsts) {
				sb.append("\n    ======================================================================\n" + "    "
					+ s.getNodeType() + "\n\n");
				sb.append(String
					.format(nameFmtStr, "File:", "", getFileName() + ", " + getLine() + ":" + getPosition()));
				sb.append(String.format(nameFmtStr, "Name: ", "", s.getNameIndex()));
				sb.append(String.format(nameFmtStr, "ID:", "", Integer.toHexString(System.identityHashCode(s))));
				if (s.getParent() instanceof SubInstance)
					sb.append(String.format(nameFmtStr, "Parent: ", "", s.getParent().getNameIndex()));
				else
					sb.append(String.format(nameFmtStr, "Parent: ", "", s.getParent().getName()));
				sb.append("\n");

				List<Port> ports = s.getPorts();
				for (Port p : ports) {
					sb.append(p.toString().replace("\n", "\n      "));
				}
			}
			sb.append("\n");
		}

		return sb.toString();
	}
}
