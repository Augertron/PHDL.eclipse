package phdl.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class DesignUnit extends Node {
	protected List<Instance> instances;
	protected List<Net> nets;
	protected List<SubInstance> subInsts;
	protected List<Port> ports;
	
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
		instances = new ArrayList<Instance>();
		nets = new ArrayList<Net>();
		info = "";
		subInsts = new ArrayList<SubInstance>();
		ports = new ArrayList<Port>();
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
		this.instances = new ArrayList<Instance>();
		this.nets = new ArrayList<Net>();
		this.subInsts = new ArrayList<SubInstance>();
		this.ports = new ArrayList<Port>();
		
		this.instances.addAll(old.instances);
		this.nets.addAll(old.nets);
		this.info = old.info;
		this.subInsts.addAll(old.subInsts);
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

	public List<Net> getNets() {
		return nets;
	}

	public void setNets(List<Net> nets) {
		this.nets = nets;
	}
	
	/**
	 * 
	 * @param newNet
	 * @return	true, if the net wasn't already in the list and was added successfully
	 * 			false, otherwise
	 */
	public boolean addNet(Net newNet) {
		if (!nets.contains(newNet)) {
			return nets.add(newNet);
		}
		return false;
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
		if (!subInsts.contains(newSub)) {
			return subInsts.add(newSub);
		}
		return false;
	}

	public List<Port> getPorts() {
		return ports;
	}

	public void setPorts(List<Port> ports) {
		this.ports = ports;
	}
	
	/**
	 * 
	 * @param newPort
	 * @return	true, if the port wasn't already in the list and was added successfully
	 * 			false, otherwise
	 */
	public boolean addPort(Port newPort) {
		if (!ports.contains(newPort)) {
			return ports.add(newPort);
		}
		return false;
	}
	
	/**
	 * Finds and returns a NetNode that has a certain name.
	 * 
	 * @param name
	 *            the name of the NetNode
	 * @return the NetNode with the net name
	 */
	public Net getNet(String name, int index) {
		for (Net n : nets) {
			if (n.getName().equals(name.toUpperCase()) && n.getIndex() == index)
				return n;
		}
		return null;
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

	/**
	 * Finds all NetNodes with the same name and returns a list of them.
	 * 
	 * @param netName	the base name of the Net
	 * @return a List of NetNodes with the same name
	 */
	public List<Net> getAllNetsByName(String netName) {
		List<Net> allNets = new ArrayList<Net>();
		for (Net n : nets) {
			if (n.getName().equals(netName.toUpperCase())) {
				allNets.add(n);
			}
		}
		return allNets;
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
		if (getNodeType() != NodeType.DESIGN) {
			for (Port p : getPorts()) {
				System.out.println("\t" + p.toString());
			}
		}
		for (Net n : getNets()) {
			System.out.println("\t" + n.toString());
		}
		for (Instance i : getInstances()) {
			System.out.println("\t" + i.toString());
			for (Attribute a : i.getAttributes())
				System.out.println("\t\t" + a.toString());
			for (Pin p : i.getPins()) {
				if (p.getNet() != null)
					System.out.println("\t\t" + p.toString() + " <= " + p.getNet().toString());
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
			if (n.isVisited())
				deletes.add(n);
		}

		// delete these nets from the design
		for (Net n : deletes)
			nets.remove(n);
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
				//Deprecated: current.setName(current.getName() + "$" + neighbor.getName());
				removes.add(neighbor);

				// grab all of its neighbors pins
				for (Pin p : neighbor.getPinNodes()) {
					current.addPin(p);
					p.setNet(current);
				}

			}
		}

		// remove all current's connections to neighbors
		for (Net r : removes)
			current.removeNet(r);

		// propagate the merged net back up the call-stack
		return current;
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
	
	
	
}
