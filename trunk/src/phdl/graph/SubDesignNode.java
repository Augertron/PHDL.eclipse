package phdl.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SubDesignNode extends Node {

	private DesignNode referenceDesign;
	private DesignNode parentDesign;
	private String refPrefix;
	private Set<PortNode> ports;
	private Set<DeviceNode> devices;
	private List<InstanceNode> instances;
	private List<NetNode> nets;
	private Set<SubDesignNode> subDesigns;

	public SubDesignNode(DesignNode parentDesign) {
		setParentDesign(parentDesign);
		referenceDesign = null;
		refPrefix = null;
		ports = new TreeSet<PortNode>();
		devices = new TreeSet<DeviceNode>();
		instances = new ArrayList<InstanceNode>();
		nets = new ArrayList<NetNode>();
		subDesigns = new TreeSet<SubDesignNode>();
		info = "";
	}

	public DesignNode getReferenceDesign() {
		return referenceDesign;
	}

	public void setReferenceDesign(DesignNode referenceDesign) {
		this.referenceDesign = referenceDesign;
	}

	public DesignNode getParentDesign() {
		return parentDesign;
	}

	public void setParentDesign(DesignNode parentDesign) {
		this.parentDesign = parentDesign;
	}

	public String getRefPrefix() {
		return refPrefix;
	}

	public void setRefPrefix(String refPrefix) {
		this.refPrefix = refPrefix;
	}

	public Set<PortNode> getPorts() {
		return ports;
	}

	public void setPorts(Set<PortNode> ports) {
		this.ports = ports;
	}

	public boolean addPort(PortNode p) {
		return ports.add(p);
	}

	public Set<DeviceNode> getDevices() {
		return devices;
	}

	public void setDevices(Set<DeviceNode> devices) {
		this.devices = devices;
	}

	public boolean addDevice(DeviceNode d) {
		return devices.add(d);
	}

	public List<InstanceNode> getInstances() {
		return instances;
	}

	public void setInstances(List<InstanceNode> instances) {
		this.instances = instances;
	}

	public boolean addInstance(InstanceNode i) {
		return instances.add(i);
	}

	public List<NetNode> getNets() {
		return nets;
	}

	public void setNets(List<NetNode> nets) {
		this.nets = nets;
	}

	public boolean addNet(NetNode n) {
		return nets.add(n);
	}

	public Set<SubDesignNode> getSubDesigns() {
		return subDesigns;
	}

	public void setSubDesigns(Set<SubDesignNode> subDesigns) {
		this.subDesigns = subDesigns;
	}

	public boolean addSubDesign(SubDesignNode s) {
		return subDesigns.add(s);
	}

	@Override
	public NodeType getType() {
		return NodeType.SUBDESIGN;
	}

	public void addSubDesign(DesignNode sd) {
		// TODO Auto-generated method stub

	}
}
