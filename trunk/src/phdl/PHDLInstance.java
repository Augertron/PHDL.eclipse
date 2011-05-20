package phdl;

import java.util.HashSet;

public class PHDLInstance {
	private String instName;
	private String deviceName;
	private HashSet<PHDLAttribute> attributes;
	private HashSet<PHDLPin> pins;

	public PHDLInstance(String instName, String deviceName) {
		this.instName = instName;
		this.deviceName = deviceName;
		attributes = new HashSet<PHDLAttribute>();
		pins = new HashSet<PHDLPin>();
	}

	public String getInstName() {
		return instName;
	}

	public void setInstName(String instName) {
		this.instName = instName;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public HashSet<PHDLAttribute> getAttributes() {
		return attributes;
	}

	public void addAttribute(PHDLAttribute a) {
		attributes.add(a);
	}

	public HashSet<PHDLPin> getPins() {
		return pins;
	}

	public void addPin(PHDLPin p) {
		pins.add(p);
	}

}
