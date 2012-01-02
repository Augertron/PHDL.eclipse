/*
 * Copyright (C) 2011 Brigham Young University This program is free software: you can redistribute
 * it and/or modify it under the terms of the GNU General Public License as published by the Free
 * Software Foundation, version 3. This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received
 * a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package phdl.graph;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * A class that represents a design in PHDL.
 * 
 * @author Brad Riching and Richard Black
 * @version 0.1
 */
public class Design extends Node {

	private Set<Device> devices;
	private List<Instance> instances;
	private List<Net> nets;
	private Set<Design> subDesigns;

	/**
	 * Default Constructor.
	 * 
	 * Initializes all sets and lists of ports, devices, instances, and nets.
	 * 
	 * @see Port
	 * @see Device
	 * @see Instance
	 * @see Net
	 */
	public Design() {
		devices = new TreeSet<Device>();
		instances = new ArrayList<Instance>();
		nets = new ArrayList<Net>();
		info = "";
		subDesigns = new TreeSet<Design>();
	}

	/**
	 * SubDesign addition method
	 * 
	 * @param newDesign
	 *            the DesignNode to add to the subDesign
	 * @return true if the subDesign wasn't already in the set false otherwise
	 */
	public boolean addSubDesign(Design newDesign) {
		return subDesigns.add(newDesign);
	}

	/**
	 * SubDesign Set accessor method
	 * 
	 * @return the set of subDesigns
	 */
	public Set<Design> getSubDesigns() {
		return subDesigns;
	}

	/**
	 * Device set accessor method.
	 * 
	 * @return the set of all devices
	 */
	public Set<Device> getDevices() {
		return devices;
	}

	/**
	 * Device set addition method.
	 * 
	 * @param d
	 *            the new DeviceNode to add
	 * @return true, if the device wasn't already in the design false, otherwise
	 */
	public boolean addDevice(Device d) {
		return devices.add(d);
	}

	/**
	 * Checks to see if the design has any devices.
	 * 
	 * @return true, if there devices in the design false, otherwise
	 */
	public boolean hasDevices() {
		return (!devices.isEmpty());
	}

	/**
	 * Instance set accessor method.
	 * 
	 * @return the set of all instances
	 */
	public List<Instance> getInstances() {
		return instances;
	}

	/**
	 * Instance set addition method.
	 * 
	 * @param i
	 *            the new InstanceNode to add
	 * @return true, if the instance isn't already part of the design false, otherwise
	 */
	public boolean addInstance(Instance i) {
		return instances.add(i);
	}

	/**
	 * Checks to see if the design has any instances.
	 * 
	 * @return true, if there are instances false, otherwise
	 */
	public boolean hasInstances() {
		return (!instances.isEmpty());
	}

	/**
	 * Net set accessor method.
	 * 
	 * @return the set of all nets
	 */
	public List<Net> getNets() {
		return nets;
	}

	/**
	 * Net set addition method.
	 * 
	 * @param i
	 *            the new NetNode to add
	 * @return true, if the net isn't already part of the design false, otherwise
	 */
	public boolean addNet(Net n) {
		return nets.add(n);
	}

	/**
	 * Checks to see if the design has any nets.
	 * 
	 * @return true, if there are nets false, otherwise
	 */
	public boolean hasNets() {
		return (!nets.isEmpty());
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
		return name.equals(((Design) o).getName());
	}

	@Override
	/**
	 * Generic toString method.
	 * 
	 * @return a string representation of the DesignNode
	 */
	public String toString() {
		return "DESIGN " + name;
	}

	@Override
	/**
	 * Type accessor method.
	 * 
	 * @return NodeType.DESIGN
	 */
	public NodeType getNodeType() {
		return NodeType.DESIGN;
	}

	/**
	 * Finds and returns a DeviceNode that has a certain name.
	 * 
	 * @param devName
	 *            the name of the DeviceNode
	 * @return the DeviceNode with the device name
	 */
	public Device getDevice(String devName) {
		for (Device d : devices) {
			if (d.getName().equals(devName))
				return d;
		}
		return null;
	}

	/**
	 * Finds and returns a NetNode that has a certain name.
	 * 
	 * @param netName
	 *            the name of the NetNode
	 * @return the NetNode with the net name
	 */
	public Net getNet(String netName) {
		for (Net n : nets) {
			if (n.getName().equals(netName.toUpperCase()))
				return n;
		}
		return null;
	}

	/**
	 * Finds and returns an InstanceNode that has a certain name.
	 * 
	 * @param instName
	 *            the name of the InstanceNode
	 * @return the InstanceNode with the instance name
	 */
	public Instance getInstance(String instName) {
		for (Instance i : instances) {
			if (i.getName().equals(instName))
				return i;
		}
		return null;
	}

	/**
	 * Finds all InstanceNodes with the same base name (i.e. without any array references) and
	 * returns a list of them.
	 * 
	 * The base name of an instance is the name without any array references. For example,
	 * "my_inst(3)" is an instance name, and "my_inst" is its base name.
	 * 
	 * @param instName
	 *            the base name of the Instance
	 * @return a List of InstanceNodes with the base name
	 */
	public List<Instance> getAllInstances(String instName) {
		List<Instance> allInstances = new ArrayList<Instance>();
		for (Instance i : instances) {
			if (i.getName().length() < instName.length())
				continue;
			String prefix = i.getName().substring(0, instName.length());
			if (prefix.equals(instName)) {
				String suffix = i.getName().substring(instName.length());
				if (suffix.length() == 0 || suffix.charAt(0) == '(') {
					allInstances.add(i);
				}
			}
		}
		return allInstances;
	}

	/**
	 * 
	 */
	public List<Instance> getInst_wo_RefDes() {
		List<Instance> insts = new LinkedList<Instance>();
		for (Instance i : instances) {
			if (i.getRefDes() == null || i.getRefDes().equals(""))
				insts.add(i);
		}
		return insts;
	}

	/**
	 * Finds all NetNodes with the same base name and returns a list of them.
	 * 
	 * The base name of a net is the name without any array references. For example, "my_net(12)" is
	 * a net name, and "my_net" is its base name.
	 * 
	 * @param netName
	 *            the base name of the Net
	 * @return a List of NetNodes with the base name
	 */
	public List<Net> getAllNets(String netName) {
		List<Net> allNets = new ArrayList<Net>();
		for (Net n : nets) {
			if (n.getName().length() < netName.length())
				continue;
			String prefix = n.getName().substring(0, netName.length());
			if (prefix.equals(netName.toUpperCase())) {
				String suffix = n.getName().substring(netName.length());
				if (suffix.length() == 0 || suffix.charAt(0) == '[') {
					allNets.add(n);
				}
			}
		}
		return allNets;
	}

	/**
	 * Goes through all Nodes attached to the DesignNode and prints out a representation of the
	 * connections.
	 */
	public void printDesignNode() {
		System.out.println(toString());
		for (Device dev : getDevices()) {
			System.out.println("\t" + dev.toString());
			for (Attribute a : dev.getAttributes()) {
				System.out.println("\t\t" + a.toString());
			}
			for (Pin pn : dev.getPins()) {
				System.out.println("\t\t" + pn.toString());
			}
		}
		for (Instance iNode : getInstances()) {
			System.out.println("\t" + iNode.toString());
			for (Attribute a : iNode.getAttributes()) {
				System.out.println("\t\t" + a.toString());
			}
			for (Pin p : iNode.getPins()) {
				if (p.getNet() != null) {
					System.out.println("\t\t" + p.toString() + " <= " + p.getNet().toString());
				} else {
					System.out.println("\t\t" + p.toString());
				}
			}
		}
		for (Net n : getNets()) {
			System.out.println("\t" + n.toString());
		}
	}

	/**
	 * Generates a .dot file that represents the complete graph.
	 * 
	 * @param fileName
	 *            the name of the file being written
	 */
	public void dottyDump(String fileName) {
		BufferedWriter dotty = null;

		int netRef = 0;
		int pinRef = 0;
		Map<Integer, Net> netMap = new HashMap<Integer, Net>();
		Map<Integer, Pin> pinMap = new HashMap<Integer, Pin>();

		String format = "ordering=out;\r\n"
			+ "	ranksep=.4;\r\n"
			+ "	bgcolor=\"lightgrey\"; node [fixedsize=false, fontsize=12, fontname=\"Helvetica-bold\", fontcolor=\"blue\"\r\n"
			+ "		width=.25, height=.25, color=\"black\", fillcolor=\"white\", style=\"filled, solid, bold\"];\r\n"
			+ "	edge [arrowsize=.5, color=\"black\", style=\"bold\"]";

		try {
			dotty = new BufferedWriter(new FileWriter(fileName));
		} catch (IOException e) {
			System.out.println("Problem creating file: " + fileName);
			System.exit(1);
		}
		try {
			dotty.write("digraph {\n\n");
			dotty.write(format);

			for (Net n : nets) {
				dotty.write("  n" + netRef + " [label=\"" + n.getName() + "\"];\n");
				netMap.put(netRef, n);
				netRef++;
			}
			for (Instance i : instances) {
				for (Pin p : i.getPins()) {
					dotty.write("  p" + pinRef + " [label=\"" + i.getName() + "." + p.getName()
						+ "\"];\n");
					pinMap.put(pinRef, p);
					pinRef++;
				}
			}

			for (int k = 0; k < netMap.keySet().size(); k++) {
				for (Net n : netMap.get(k).getNetNodes()) {
					for (Integer i : netMap.keySet()) {
						if (netMap.get(i).getName().equals(n.getName())) {
							dotty.write("  n" + k + " -> " + "n" + i + ";\n");
						}
					}
				}
			}

			for (Integer i : pinMap.keySet()) {
				for (Integer j : netMap.keySet()) {
					Net n = pinMap.get(i).getNet();
					if (n != null) {
						if (netMap.get(j).getName().equals(n.getName())) {
							dotty.write("  p" + i + " -> " + "n" + j + ";\n");
						}
					}
				}
			}

			dotty.write("}\n");
			dotty.close();
		} catch (IOException e) {
			System.out.println("Prolem writing dotty file.");
			System.exit(1);
		}
		System.out.println("Wrote file: " + fileName);
	}

	/**
	 * Finds all the InstanceNodes with the same base name and returns a list of their indices.
	 * 
	 * The base name of an instance is the name without any array references. For example,
	 * "my_inst(3)" is an instance name, and "my_inst" is its base name.
	 * 
	 * @param instName
	 *            the base name of the instance
	 * @return a List of integers representing the InstanceNodes' indices
	 */
	public List<Integer> getAllIndices(String instName) {
		List<Integer> allIndices = new ArrayList<Integer>();
		for (Instance i : getAllInstances(instName)) {
			int start = i.getName().indexOf('(');
			int end = i.getName().indexOf(')');
			if (start != -1 && end != -1) {
				String index = i.getName().substring(start + 1, end);
				allIndices.add(Integer.parseInt(index));
			}
		}
		return allIndices;
	}

	/**
	 * Finds all the NetNodes with the same base name and returns a list of their indices.
	 * 
	 * The base name of an net is the name without any array references. For example, "my_net(1)" is
	 * a net name, and "my_net" is its base name.
	 * 
	 * @param netName
	 *            the base name of the net
	 * @return a List of integers representing the NetNodes' indices
	 */
	public List<Integer> getAllNetIndices(String netName) {
		List<Integer> allIndices = new ArrayList<Integer>();
		for (Net n : getAllNets(netName)) {
			int start = n.getName().indexOf('[');
			int end = n.getName().indexOf(']');

			if (start != -1 && end != -1) {
				String index = n.getName().substring(start + 1, end);
				allIndices.add(Integer.parseInt(index));
			}

		}
		return allIndices;
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
			if (i.getDevice().equals(dev)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Merges all net-net connections.
	 */
	public void superNet2() {
		// any net that is set as visited will be deleted
		Set<Net> deletes = new HashSet<Net>();

		// go through all nets in the design
		for (Net n : nets) {
			if (!n.isVisited()) {
				// call the merge routine on any unvisited net
				n = merge(n);
				// make sure merged net isn't deleted.
				n.setVisited(false);
			}
		}

		// gather up all the nets to be deleted from the design
		for (Net n : nets) {
			if (n.isVisited()) {
				deletes.add(n);
			}
		}

		// delete these nets from the design
		for (Net n : deletes) {
			nets.remove(n);
		}
	}

	/**
	 * Merges the names of the current net with the names of all neighbors by using a depth-first
	 * search.
	 * 
	 * @param current
	 * @return net with merged name from all unvisited neighbor's names
	 */
	private Net merge(Net current) {

		Set<Net> removes = new HashSet<Net>();

		// set the current node as visited
		current.setVisited(true);

		// visit and process all of its neighbors
		for (Net neighbor : current.getNetNodes()) {
			if (!neighbor.isVisited()) {

				neighbor = merge(neighbor);

				// append the name of its neighbor
				current.setName(current.getName() + "$" + neighbor.getName());
				removes.add(neighbor);

				// grab all of its neighbors pins
				for (Pin p : neighbor.getPinNodes()) {
					current.addPin(p);
					p.setNet(current);
				}

			}
		}

		// remove all current's connections to neighbors
		for (Net r : removes) {
			current.removeNet(r);
		}

		// propagate the merged net back up the call-stack
		return current;
	}

}
