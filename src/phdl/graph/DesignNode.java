package phdl.graph;

import java.util.HashSet;
import java.util.Set;

public class DesignNode extends Node {

	private Set<PortNode> ports;
	private Set<DeviceNode> devices;
	private Set<InstanceNode> instances;
	private Set<NetNode> nets;
	
	/**
	 * 
	 */
	public DesignNode() {
		ports = new HashSet<PortNode>();
		devices = new HashSet<DeviceNode>();
		instances = new HashSet<InstanceNode>();
		nets = new HashSet<NetNode>();
	}
	
	/**
	 * 
	 * @return
	 */
	public Set<DeviceNode> getDevices() {
		return devices;
	}
	
	/**
	 * 
	 * @param d
	 * @return
	 */
	public boolean addDevice(DeviceNode d) {
		return devices.add(d);
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean hasDevices() {
		return (!devices.isEmpty());
	}

	/**
	 * 
	 * @return
	 */
	public Set<InstanceNode> getInstances() {
		return instances;
	}
	
	/**
	 * 
	 * @param i
	 * @return
	 */
	public boolean addInstance(InstanceNode i) {
		return instances.add(i);
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean hasInstances() {
		return (!instances.isEmpty());
	}

	/**
	 * 
	 * @return
	 */
	public Set<NetNode> getNets() {
		return nets;
	}
	
	/**
	 * 
	 * @param n
	 * @return
	 */
	public boolean addNet(NetNode n) {
		return nets.add(n);
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean hasNets() {
		return (!nets.isEmpty());
	}

	/**
	 * 
	 * @return
	 */
	public boolean hasPorts() {
		return (!ports.isEmpty());
	}

	/**
	 * 
	 * @return
	 */
	public Set<PortNode> getPorts() {
		return ports;
	}
	
	/**
	 * 
	 * @param p
	 * @return
	 */
	public boolean addPort(PortNode p) {
		return (ports.add(p));
	}

	/**
	 * 
	 */
	public boolean equals(Object other) {
		return name.equals(((DesignNode)other).getName());
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public NodeType getType() {
		return NodeType.DESIGN;
	}
	
}
