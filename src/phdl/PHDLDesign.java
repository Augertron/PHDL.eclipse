package phdl;

import java.util.HashSet;

public class PHDLDesign {
	private String name;
	private HashSet<PHDLDevice> devices;
	private HashSet<PHDLNet> nets;
	private HashSet<PHDLInstance> instances;

	public PHDLDesign() {
		this.devices = new HashSet<PHDLDevice>();
		this.nets = new HashSet<PHDLNet>();
		this.instances = new HashSet<PHDLInstance>();
	}

	public PHDLDesign(String name) {
		this.name = name;
		this.devices = new HashSet<PHDLDevice>();
		this.nets = new HashSet<PHDLNet>();
		this.instances = new HashSet<PHDLInstance>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashSet<PHDLDevice> getDevices() {
		return devices;
	}

	public void addDevice(PHDLDevice d) {
		devices.add(d);
	}

	public HashSet<PHDLNet> getNets() {
		return nets;
	}

	public void addNet(PHDLNet n) {
		nets.add(n);
	}

	public HashSet<PHDLInstance> getInstances() {
		return instances;
	}

	public void addInstance(PHDLInstance i) {
		instances.add(i);
	}

}
