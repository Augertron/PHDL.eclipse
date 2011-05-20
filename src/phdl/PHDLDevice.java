package phdl;

import java.util.HashSet;

public class PHDLDevice {
	private String name;
	private HashSet<PHDLAttribute> attributes;
	private HashSet<PHDLPin> pins;

	public PHDLDevice(String name) {
		this.name = name;
		attributes = new HashSet<PHDLAttribute>();
		pins = new HashSet<PHDLPin>();
	}
	
	public boolean hasRefDesPrefix() {
		for (PHDLAttribute a : attributes) {
			if (a.getName().equals("refPrefix") && a.getValue() != "") {
				return true;
			}
		}
		return false;
	}
	
	public String getRefDesPrefix() {
		if (!hasRefDesPrefix()) {
			System.err.println("Error - there is no refPrefix attribute in " + name);
			return null;
		}
		for (PHDLAttribute a : attributes) {
			if (a.getName().equals("refPrefix")) {
				return a.getValue();
			}
		}
	}
	
	public boolean hasRefDesAttr() {
		for (PHDLAttribute a : attributes) {
			if (a.getName().equals("refDes") && a.getValue() != "" {
				return true;
			}
		}
		return false;
	}
	
	public String getRefDesAttr() {
		if (!hasRefDesAttr()) {
			System.err.println("Error - there is no refDes attribute in " + name);
			return null;
		}
		for (PHDLAttribute a : attributes) {
			if (a.getName().equals("refDes")) {
				return a.getValue();
			}
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}

}
