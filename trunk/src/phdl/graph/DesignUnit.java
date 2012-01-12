package phdl.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class DesignUnit extends Node {
	protected List<Connection> connections;
	protected List<Instance> instances;
	protected List<SubInstance> subInsts;
	
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
		connections = new ArrayList<Connection>();
		instances = new ArrayList<Instance>();
		subInsts = new ArrayList<SubInstance>();
		info = "";
	}

	/**
	 * Copy Constructor.
	 * 
	 * Initializes all sets and lists of ports, sub instances, instances, and nets
	 * based upon another DesignUnit.
	 * 
	 * @see Port
	 * @see Instance
	 * @see Net
	 * @see SubInstance
	 */
	public DesignUnit(DesignUnit old) {
		this.connections = new ArrayList<Connection>();
		this.instances = new ArrayList<Instance>();
		this.subInsts = new ArrayList<SubInstance>();
		
		this.connections.addAll(old.connections);
		this.instances.addAll(old.instances);
		this.subInsts.addAll(old.subInsts);
		this.info = old.info;
	}
	
	public List<Instance> getInstances() {
		return instances;
	}

	public void setInstances(List<Instance> instances) {
		this.instances = instances;
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

	public List<Connection> getConnections() {
		return connections;
	}

	public void setConnections(List<Connection> connections) {
		this.connections = connections;
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
	
	public Connection getConnection(String name, int index) {
		for (Connection c : connections) {
			if (c.getName().equals(name) && c.getIndex() == index)
				return c;
		}
		return null;
	}

	public List<Net> getNets() {
		List<Net> nets = new ArrayList<Net>();
		for (Connection c : connections) {
			if (c instanceof phdl.graph.Net) {
				nets.add((Net)c);
			}
		}
		return nets;
	}

	public List<SubInstance> getSubInstances() {
		return subInsts;
	}

	public void setSubInstances(List<SubInstance> subInsts) {
		this.subInsts = subInsts;
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
	
	public SubInstance getSubInstance(String name, int index) {
		for (SubInstance s : subInsts) {
			if (s.getName().equals(name) && s.getIndex() == index)
				return s;
		}
		return null;
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

	public List<SubInstance> getSubInstancesByName(String instName) {
		List<SubInstance> insts = new ArrayList<SubInstance>();
		for (SubInstance s : subInsts) {
			if (s.getName().equals(instName))
				insts.add(s);
		}
		return insts;
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
			Net n = (Net)c;
			if (n.getName().equals(netName.toUpperCase()))
				allNets.add(n);
		}
		return allNets;
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

	public List<Connection> getConnectionsByName(String name) {
		List<Connection> allCons = new ArrayList<Connection>();
		for (Connection c : connections) {
			if (c.getName().equals(name.toUpperCase()))
				allCons.add(c);
		}
		return allCons;
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
	 * Goes through all Nodes attached to the DesignUnit and prints
	 * out a representation of the connections.
	 */
	public void printDesign() {
		System.out.println(toString());
		for (Connection c : getConnections()) {
			System.out.println("\t" + c.toString());
		}
		for (Instance i : getInstances()) {
			System.out.println("\t" + i.toString());
			for (Attribute a : i.getAttributes())
				System.out.println("\t\t" + a.toString());
			for (Pin p : i.getPins()) {
				if (p.getConnection() != null)
					System.out.println("\t\t" + p.toString() + " <= " + p.getConnection().toString());
				else if (p.isOpen())
					System.out.println("\t\t" + p.toString() + (p.isOpen() ? " <= OPEN" : ""));
				else
					System.out.println("\t\t" + p.toString());
			}
		}
		for (SubInstance s : getSubInstances()) {
			System.out.println("\t" + s.toString());
		}
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
			Net n = (Net)c;
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
			Net n = (Net)c;
			if (n.isVisited())
				deletes.add(n);
		}

		// delete these nets from the design
		for (Net n : deletes)
			connections.remove(n);
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
	
	
	
}
