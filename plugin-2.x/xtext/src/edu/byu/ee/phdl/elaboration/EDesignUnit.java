package edu.byu.ee.phdl.elaboration;

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

public abstract class EDesignUnit extends Node {
	protected List<EConnection> connections;
	protected int index = -1;
	protected List<EInstance> instances;
	protected List<ESubInstance> subInsts;

	/**
	 * Default Constructor.
	 * 
	 * Initializes all sets and lists of ports, sub instances, instances, and nets.
	 * 
	 * @see EPort
	 * @see EInstance
	 * @see ENet
	 * @see ESubInstance
	 */
	public EDesignUnit() {
		super();
		instances = new ArrayList<EInstance>();
		subInsts = new ArrayList<ESubInstance>();
		connections = new ArrayList<EConnection>();
	}

	/**
	 * 
	 * @param newCon
	 * @return true, if the connection wasn't already in the list and was added successfully false,
	 *         otherwise
	 */
	public boolean addConnection(EConnection newCon) {
		if (!connections.contains(newCon)) {
			return connections.add(newCon);
		}
		return false;
	}

	/**
	 * 
	 * @param newInst
	 * @return true, if the instance wasn't already in the list and was added successfully false,
	 *         otherwise
	 */
	public boolean addInstance(EInstance newInst) {
		if (!instances.contains(newInst)) {
			return instances.add(newInst);
		}
		return false;
	}

	/**
	 * 
	 * @param newSub
	 * @return true, if the sub instance wasn't already in the list and was added successfully
	 *         false, otherwise
	 */
	public boolean addSubInst(ESubInstance newSub) {
		if (!subInsts.contains(newSub))
			return subInsts.add(newSub);
		return false;
	}

	public void clearVisited() {
		for (EConnection c : connections)
			c.setVisited(false);
	}

	@Override
	public int compareTo(Object o) {
		return this.getNameIndex().compareTo(((EDesignUnit) o).getNameIndex());
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
		boolean result = name.equals(((EDesignUnit) o).getName()) && index == ((EDesignUnit) o).index;
		return result;
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

	public List<EPort> getAllPorts(String name) {
		List<EPort> allPorts = new ArrayList<EPort>();
		for (EConnection c : connections) {
			if (c instanceof EPort) {
				if (c.getName().equals(name.toUpperCase()))
					allPorts.add((EPort) c);
			}
		}
		return allPorts;
	}

	public EConnection getConnection(String name, int index) {
		for (EConnection c : connections) {
			if (c.getName().equals(name.toUpperCase()) && c.getIndex() == index)
				return c;
		}
		return null;
	}

	public List<EConnection> getConnections() {
		return connections;
	}

	public List<EConnection> getConnectionsByName(String name) {
		List<EConnection> allCons = new ArrayList<EConnection>();
		for (EConnection c : connections) {
			if (c.getName().equals(name.toUpperCase()))
				allCons.add(c);
		}
		return allCons;
	}

	public int getIndex() {
		return index;
	}

	/**
	 * Finds and return an InstanceNode that has a certain name. If the Instance Node has an index,
	 * the function returns null.
	 * 
	 * @param name
	 * @return
	 */
	public EInstance getInstance(String name) {
		return getInstance(name, -1);
	}

	/**
	 * Finds and returns an InstanceNode that has a certain name and index.
	 * 
	 * @param name the name of the InstanceNode
	 * @return the InstanceNode with the instance name
	 */
	public EInstance getInstance(String name, int index) {
		for (EInstance i : instances) {
			if (i.getName().equals(name) && i.getIndex() == index)
				return i;
		}
		return null;
	}

	public List<EInstance> getInstances() {
		return instances;
	}

	/**
	 * Finds all InstanceNodes with the same name and returns a list of them.
	 * 
	 * @param instName the base name of the Instance
	 * @return a List of InstanceNodes with the same name
	 */
	public List<EInstance> getInstancesByName(String instName) {
		List<EInstance> insts = new ArrayList<EInstance>();
		for (EInstance i : instances) {
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
	 * @param name the name of the NetNode
	 * @return the NetNode with the net name
	 */
	public ENet getNet(String name, int index) {
		for (EConnection c : connections) {
			if (c instanceof ENet) {
				ENet n = (ENet) c;
				if (n.getName().equals(name.toUpperCase()) && n.getIndex() == index)
					return n;
			}
		}
		return null;
	}

	public List<ENet> getNets() {
		List<ENet> nets = new ArrayList<ENet>();
		for (EConnection c : connections) {
			if (c instanceof edu.byu.ee.phdl.elaboration.ENet) {
				nets.add((ENet) c);
			}
		}
		return nets;
	}

	/**
	 * Finds all NetNodes with the same name and returns a list of them.
	 * 
	 * @param netName the base name of the Net
	 * @return a List of NetNodes with the same name
	 */
	public List<ENet> getNetsByName(String netName) {
		List<ENet> allNets = new ArrayList<ENet>();
		for (EConnection c : connections) {
			if (!(c instanceof edu.byu.ee.phdl.elaboration.ENet))
				continue;
			ENet n = (ENet) c;
			if (n.getName().equals(netName.toUpperCase()))
				allNets.add(n);
		}
		return allNets;
	}

	/**
	 * Finds and returns a Port that has a certain name.
	 * 
	 * @param name the name of the NetNode
	 * @return the NetNode with the net name
	 */
	public EPort getPort(String name, int index) {
		for (EConnection c : connections) {
			if (c instanceof edu.byu.ee.phdl.elaboration.EPort) {
				EPort p = (EPort) c;
				if (p.getName().equals(name.toUpperCase()) && p.getIndex() == index)
					return p;
			}
		}
		return null;
	}

	public List<EPort> getPortsByName(String portName) {
		List<EPort> allPorts = new ArrayList<EPort>();
		for (EConnection c : connections) {
			if (!(c instanceof EPort))
				continue;
			EPort p = (EPort) c;
			if (p.getName().equals(portName.toUpperCase()))
				allPorts.add(p);
		}
		return allPorts;
	}

	public ESubInstance getSubInstance(String name, int index) {
		for (ESubInstance s : subInsts) {
			if (s.getName().equals(name) && s.getIndex() == index)
				return s;
		}
		return null;
	}

	public List<ESubInstance> getSubInstances() {
		return subInsts;
	}

	public List<ESubInstance> getSubInstancesByName(String instName) {
		List<ESubInstance> insts = new ArrayList<ESubInstance>();
		for (ESubInstance s : subInsts) {
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
	 * @param dev the device to check
	 * @return true, if there exists an instance that references the device false, otherwise
	 */
	public boolean isDeviceInstanced(EDevice dev) {
		for (EInstance i : instances) {
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
	private ENet merge(EConnection neighbor2) {

		Set<ENet> removes = new HashSet<ENet>();

		// set the current node as visited
		((ENet) neighbor2).setVisited(true);

		// visit and process all of its neighbors
		for (EConnection neighbor : neighbor2.getConnections()) {
			if (!((ENet) neighbor).isVisited()) {

				neighbor = merge(neighbor);

				// append the name of its neighbor
				// Deprecated: current.setName(current.getName() + "$" + neighbor.getName());
				removes.add((ENet) neighbor);

				// grab all of its neighbors pins
				for (EPin p : neighbor.getPins()) {
					neighbor2.addPin(p);
					p.setAssignment(neighbor2);
				}

			}
		}

		// remove all current's connections to neighbors
		for (ENet r : removes)
			neighbor2.removeConnection(r);

		// propagate the merged net back up the call-stack
		return (ENet) neighbor2;
	}

	public Map<String, List<ENet>> netsToMap() {
		Map<String, List<ENet>> map = new HashMap<String, List<ENet>>();
		for (EConnection c : connections) {
			if (c instanceof ENet) {
				if (!map.keySet().contains(c.getName())) {
					List<ENet> newList = new ArrayList<ENet>();
					newList.add((ENet) c);
					map.put(c.getName(), newList);
				} else
					map.get(c.getName()).add((ENet) c);
			}
		}
		return map;
	}

	public Map<String, List<EPort>> portsToMap() {
		Map<String, List<EPort>> map = new HashMap<String, List<EPort>>();
		for (EConnection c : connections) {
			if (c instanceof EPort) {
				if (!map.keySet().contains(c.getName())) {
					List<EPort> newList = new ArrayList<EPort>();
					newList.add((EPort) c);
					map.put(c.getName(), newList);
				} else
					map.get(c.getName()).add((EPort) c);
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
		for (ESubInstance s : subInsts)
			s.printHierarchyRecursive(numIndents + 1);
	}

	public void setConnections(List<EConnection> connections) {
		this.connections = connections;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setInstances(List<EInstance> instances) {
		this.instances = instances;
	}

	public void setSubInstances(List<ESubInstance> subInsts) {
		this.subInsts = subInsts;
	}

	/**
	 * Merges all net-net connections.
	 */
	public void superNet2() {
		// any net that is set as visited will be deleted
		Set<ENet> deletes = new HashSet<ENet>();

		// go through all nets in the design
		for (EConnection c : connections) {
			if (!(c instanceof edu.byu.ee.phdl.elaboration.ENet)) {
				continue;
			}
			ENet n = (ENet) c;
			if (!n.isVisited()) {
				// call the merge routine on any unvisited net
				n = merge(n);
				// make sure merged net isn't deleted.
				n.setVisited(false);
			}
		}

		// gather up all the nets to be deleted from the design
		for (EConnection c : connections) {
			if (!(c instanceof edu.byu.ee.phdl.elaboration.ENet)) {
				continue;
			}
			ENet n = (ENet) c;
			if (n.isVisited())
				deletes.add(n);
		}

		// delete these nets from the design
		for (ENet n : deletes)
			connections.remove(n);
	}

	/**
	 * Writes a string to file
	 * 
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
	 * @param fileName the name of the file being written
	 */
	public void toPNG() {
		StringBuilder sb = new StringBuilder();

		// Header information
		String name = "";
		if (this instanceof EDesign)
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
		for (ESubInstance i : subInsts) {
			String iName = i.getNameIndex();
			sb.append("\tsubgraph \"cluster_" + iName + "\" {\n");
			sb.append("\t\tstyle=filled;\n");
			sb.append("\t\tcolor=lightgrey;\n");
			sb.append("\t\tlabel=\"SubInstance: " + iName + "\";\n");

			// SubInstance ports
			Map<String, List<EPort>> map = i.portsToMap();
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
					EPort p = map.get(s).get(0);
					sb.append("\t\t\t\tlabel=\"" + s + (p.hasIndex() ? array : "") + "\";\n");
					sb.append("\t\t\t\t\"" + iName + "_" + s);
					sb.append("\" [label=\"<" + p.getIndex() + "> " + p.getIndex() + "\"];\n");
					sb.append("\t\t\t}\n");
				} else {
					sb.append("\t\t\t\tlabel=\"" + s + array + "\";\n");
					sb.append("\t\t\t\t\"" + iName + "_" + s + "\" [label=\"");
					for (EPort p : map.get(s))
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
		for (EInstance i : instances) {
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
			for (EAttribute a : i.getAttributes())
				sb.append(a.getName() + " = " + a.getValue() + "\\n");
			if (!i.getAttributes().isEmpty())
				sb.append("\"];\n\t\t}\n");

			// Instance Pins
			Map<String, List<EPin>> map = i.pinsToMap();
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
					EPin p = map.get(s).get(0);
					sb.append("\t\t\t\tlabel=\"" + s + (p.hasIndex() ? array : "") + "\";\n");
					sb.append("\t\t\t\t\"" + iName + "_" + s);
					sb.append("\" [label=\"<" + p.getIndex() + "> " + p.getPinMapping() + "\"];\n");
					sb.append("\t\t\t}\n");
				} else {
					sb.append("\t\t\t\tlabel=\"" + s + array + "\";\n");
					sb.append("\t\t\t\t\"" + iName + "_" + s + "\" [label=\"");
					for (EPin p : map.get(s))
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
		Map<String, List<ENet>> netMap = this.netsToMap();
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
				ENet n = netMap.get(s).get(0);
				sb.append("\t\t\"" + s + "\"");
				sb.append(" [label=\"<" + n.getIndex() + "> " + n.getIndex() + "\"];\n");
				sb.append("\t}\n");
			} else {
				sb.append("\t\t\"" + s + "\" [label=\"");
				for (ENet n : netMap.get(s))
					sb.append("<" + n.getIndex() + "> " + n.getIndex() + " |");
				sb.delete(sb.length() - 2, sb.length());
				sb.append("\"];\n\t}\n");
			}
		}
		sb.append("\n");

		// Ports
		if (this instanceof ESubInstance || this instanceof ESubDesign) {
			Map<String, List<EPort>> portMap = this.portsToMap();
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
					EPort p = portMap.get(s).get(0);
					sb.append("\t\t\"" + s + "\"");
					sb.append(" [label=\"<" + p.getIndex() + "> " + p.getIndex() + "\"];\n");
					sb.append("\t}\n");
				} else {
					sb.append("\t\t\"" + s + "\" [label=\"");
					for (EPort p : portMap.get(s))
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
			for (EConnection c : connections) {
				// form edges from pins
				for (EPin p : c.getPins()) {
					EInstance i = ((EInstance) p.getParent());
					sb.append("\t\"" + c.getName() + "\":" + c.getIndex() + " -- \"");
					sb.append(i.getNameIndex() + "_" + p.getName() + "\":" + p.getIndex() + ";\n");
				}

				// form edges from other connections
				for (EConnection dest : c.getConnections()) {
					if (!dest.isVisited()) {
						if (dest.getParent() instanceof EDesign) {
							sb.append("\t\"" + c.getName() + "\":" + c.getIndex() + " -- \"");
							sb.append(dest.getName() + "\":" + dest.getIndex() + ";\n");
						}
					}
					if (!(dest instanceof EPort))
						dest.setVisited(true);
				}
				c.setVisited(true);
			}
			clearVisited();
		}

		for (ESubInstance s : subInsts) {
			for (EPort p : s.getPorts()) {
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
		if (this instanceof ESubInstance) {
			ESubInstance current = (ESubInstance) this;
			while (current.getParent() instanceof ESubInstance) {
				path.insert(0, current.getNameIndex() + separator);
				current = (ESubInstance) current.getParent();
			}
			path.insert(0, current.getParent().getName() + separator + current.getNameIndex() + separator);
		} else if (this instanceof EDesign || this instanceof ESubDesign)
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
		for (ESubInstance s : subInsts)
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

		if (this instanceof ESubInstance)
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
			for (EConnection c : connections) {
				sb.append(String.format(connFmtStr, connCount, " ", c.getNodeType(), " ", c.getNameIndex()));
				connCount++;
			}
			sb.append("\n");
		}

		if (!instances.isEmpty()) {
			sb.append("    Inst       Name          Device         Parent           Group        \n");
			sb.append("    ---- ---------------- ------------ ---------------- ----------------  \n");
			int instCount = 1;
			for (EInstance i : instances) {
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
			for (ESubInstance s : subInsts) {
				sb.append(String.format(subFmtStr, subCount, "", s.getNameIndex(), "", s.getSubDesign().getName(), "",
					s.getFileName() + ", " + s.getLine() + ":" + s.getPosition()));
			}
			sb.append("\n");
		}

		if (!connections.isEmpty() || !instances.isEmpty())
			sb.append("  Details:\n");

		if (!connections.isEmpty()) {
			for (EConnection c : connections) {
				sb.append(c.toString().replace("\n", "\n" + connIndent));
			}
			sb.append("\n");
		}

		if (!instances.isEmpty()) {
			for (EInstance i : instances) {
				sb.append(i.toString().replace("\n", "\n" + instIndent));
			}
			sb.append("\n");
		}

		if (!subInsts.isEmpty()) {
			String nameFmtStr = "    %-8s%2s%-26.26s\n";
			for (ESubInstance s : subInsts) {
				sb.append("\n    ======================================================================\n" + "    "
					+ s.getNodeType() + "\n\n");
				sb.append(String
					.format(nameFmtStr, "File:", "", getFileName() + ", " + getLine() + ":" + getPosition()));
				sb.append(String.format(nameFmtStr, "Name: ", "", s.getNameIndex()));
				sb.append(String.format(nameFmtStr, "ID:", "", Integer.toHexString(System.identityHashCode(s))));
				if (s.getParent() instanceof ESubInstance)
					sb.append(String.format(nameFmtStr, "Parent: ", "", s.getParent().getNameIndex()));
				else
					sb.append(String.format(nameFmtStr, "Parent: ", "", s.getParent().getName()));
				sb.append("\n");

				List<EPort> ports = s.getPorts();
				for (EPort p : ports) {
					sb.append(p.toString().replace("\n", "\n      "));
				}
			}
			sb.append("\n");
		}

		return sb.toString();
	}
}
