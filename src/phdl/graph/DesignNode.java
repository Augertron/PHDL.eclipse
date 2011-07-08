package phdl.graph;

import java.util.Set;
import java.util.TreeSet;

public class DesignNode extends Node {

	private Set<PortNode> ports;
	private Set<DeviceNode> devices;
	private Set<InstanceNode> instances;
	private Set<NetNode> nets;

	public DesignNode() {
		ports = new TreeSet<PortNode>();
		devices = new TreeSet<DeviceNode>();
		instances = new TreeSet<InstanceNode>();
		nets = new TreeSet<NetNode>();
	}

	public Set<DeviceNode> getDevices() {
		return devices;
	}

	public boolean addDevice(DeviceNode d) {
		return devices.add(d);
	}

	public boolean hasDevices() {
		return (!devices.isEmpty());
	}

	public Set<InstanceNode> getInstances() {
		return instances;
	}

	public boolean addInstance(InstanceNode i) {
		return instances.add(i);
	}

	public boolean hasInstances() {
		return (!instances.isEmpty());
	}

	public Set<NetNode> getNets() {
		return nets;
	}

	public boolean addNet(NetNode n) {
		return nets.add(n);
	}

	public boolean hasNets() {
		return (!nets.isEmpty());
	}

	public boolean hasPorts() {
		return (!ports.isEmpty());
	}

	public Set<PortNode> getPorts() {
		return ports;
	}

	public boolean addPort(PortNode p) {
		return (ports.add(p));
	}

	@Override
	public boolean equals(Object o) {
		return name.equals(((DesignNode) o).getName());
	}

	@Override
	public String toString() {
		return "DESIGN " + name;
	}

	@Override
	public NodeType getType() {
		return NodeType.DESIGN;
	}

	public DeviceNode getDevice(String devName) {
		for (DeviceNode d : devices) {
			if (d.getName().equals(devName))
				return d;
		}
		return null;
	}

	public NetNode getNet(String netName) {
		for (NetNode n : nets) {
			if (n.getName().equals(netName))
				return n;
		}
		return null;
	}

	public InstanceNode getInstance(String instName) {
		for (InstanceNode i : instances) {
			if (i.getName().equals(instName))
				return i;
		}
		return null;
	}

	public Set<InstanceNode> getAllInstances(String instName) {
		Set<InstanceNode> allInstances = new TreeSet<InstanceNode>();
		for (InstanceNode i : instances) {
			String suffix = i.getName().substring(instName.length());
			if (suffix.length() == 0 || suffix.charAt(0) == '(') {
				allInstances.add(i);
			}
		}
		return allInstances;
	}

	public void printDesignNode() {
		System.out.println(toString());
		for (DeviceNode dev : getDevices()) {
			System.out.println("\t" + dev.toString());
			for (AttributeNode a : dev.getAttributes()) {
				System.out.println("\t\t" + a.toString());
			}
			for (PinNode pn : dev.getPins()) {
				System.out.println("\t\t" + pn.toString());
			}
		}
		for (NetNode n : getNets()) {
			System.out.println("\t" + n.toString());
		}
		for (InstanceNode iNode : getInstances()) {
			System.out.println("\t" + iNode.toString());
			for (AttributeNode a : iNode.getAttributes()) {
				System.out.println("\t\t" + a.toString());
			}
		}
	}

}
