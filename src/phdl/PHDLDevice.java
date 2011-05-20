package phdl;

import java.util.ArrayList;

public class PHDLDevice {
	private String name;
	private ArrayList<PHDLAttribute> attributes;
	private ArrayList<PHDLPin> pins;

	public PHDLDevice(String name) {
		this.name = name;
		attributes = new ArrayList<PHDLAttribute>();
		pins = new ArrayList<PHDLPin>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
