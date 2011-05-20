package phdl;

import java.util.ArrayList;

public class PHDLInstance {
	private String instName;
	private String deviceName;
	private ArrayList<PHDLAttribute> attributes;
	private ArrayList<PHDLPin> pins;

	public PHDLInstance(String instName, String deviceName) {
		this.instName = instName;
		this.deviceName = deviceName;
		attributes = new ArrayList<PHDLAttribute>();
		pins = new ArrayList<PHDLPin>();
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

	public ArrayList<PHDLAttribute> getAttributes() {
		return attributes;
	}

	public void addAttribute(PHDLAttribute a) {
		attributes.add(a);
	}

	public ArrayList<PHDLPin> getPins() {
		return pins;
	}

	public void addPin(PHDLPin p) {
		pins.add(p);
	}

}
