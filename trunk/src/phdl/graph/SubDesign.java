package phdl.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SubDesign extends Node {

	private Design referenceDesign;
	private Design parentDesign;
	private String refPrefix;
	private Set<Port> ports;
	private Set<Device> devices;
	private List<Instance> instances;
	private List<Net> nets;
	private Set<SubDesign> subDesigns;

	public SubDesign(Design parentDesign) {
		setParentDesign(parentDesign);
		referenceDesign = null;
		refPrefix = null;
		ports = new TreeSet<Port>();
		devices = new TreeSet<Device>();
		instances = new ArrayList<Instance>();
		nets = new ArrayList<Net>();
		subDesigns = new TreeSet<SubDesign>();
		info = "";
	}

	public Design getReferenceDesign() {
		return referenceDesign;
	}

	public void setReferenceDesign(Design referenceDesign) {
		this.referenceDesign = referenceDesign;
	}

	public Design getParentDesign() {
		return parentDesign;
	}

	public void setParentDesign(Design parentDesign) {
		this.parentDesign = parentDesign;
	}

	public String getRefPrefix() {
		return refPrefix;
	}

	public void setRefPrefix(String refPrefix) {
		this.refPrefix = refPrefix;
	}

	public Set<Port> getPorts() {
		return ports;
	}

	public void setPorts(Set<Port> ports) {
		this.ports = ports;
	}

	public boolean addPort(Port p) {
		return ports.add(p);
	}

	public Set<Device> getDevices() {
		return devices;
	}

	public void setDevices(Set<Device> devices) {
		this.devices = devices;
	}

	public boolean addDevice(Device d) {
		return devices.add(d);
	}

	public List<Instance> getInstances() {
		return instances;
	}

	public void setInstances(List<Instance> instances) {
		this.instances = instances;
	}

	public boolean addInstance(Instance i) {
		return instances.add(i);
	}

	public List<Net> getNets() {
		return nets;
	}

	public void setNets(List<Net> nets) {
		this.nets = nets;
	}

	public boolean addNet(Net n) {
		return nets.add(n);
	}

	public Set<SubDesign> getSubDesigns() {
		return subDesigns;
	}

	public void setSubDesigns(Set<SubDesign> subDesigns) {
		this.subDesigns = subDesigns;
	}

	public boolean addSubDesign(SubDesign s) {
		return subDesigns.add(s);
	}

	@Override
	public NodeType getNodeType() {
		return NodeType.SUBDESIGN;
	}

	public void addSubDesign(Design sd) {
		// TODO Auto-generated method stub

	}
}
