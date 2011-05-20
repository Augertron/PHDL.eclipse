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
