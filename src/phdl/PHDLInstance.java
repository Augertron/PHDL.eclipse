package phdl;

import java.util.HashSet;

public class PHDLInstance {
	// How about having a PHDLDevice object here?
	// That would contain the deviceName, attributes, and pins
	private String instName;
	private PHDLDevice device;
	//private String deviceName;
	//private HashSet<PHDLAttribute> attributes;
	//private HashSet<PHDLPin> pins;

	/*
	public PHDLInstance(String instName, String deviceName) {
		this.instName = instName;
		this.deviceName = deviceName;
		attributes = new HashSet<PHDLAttribute>();
		pins = new HashSet<PHDLPin>();
	}
	*/

	public PHDLInstance(String instName, PHDLDevice device) {
		this.instName = instName;
		this.device = device;
	}
	
	public String getInstName() {
		return instName;
	}

	public void setInstName(String instName) {
		this.instName = instName;
	}
	
	public PHDLDevice getDevice() {
		return this.device;
	}
	
	public void setPHDLDevice(PHDLDevice newDevice) {
		this.device = newDevice;
	}

	public String getDeviceName() {
		return device.getName();
	}

	public void setDeviceName(String deviceName) {
		device.setName(deviceName);
	}

	public HashSet<PHDLAttribute> getAttributes() {
		return device.getAttributes();
	}

	public void addAttribute(PHDLAttribute a) {
		device.addAttribute(a);
	}

	public HashSet<PHDLPin> getPins() {
		return device.getPins();
	}

	public void addPin(PHDLPin p) {
		device.addPin(p);
	}
	
	public int hashCode() {
		return instName.hashCode();
	}

}
