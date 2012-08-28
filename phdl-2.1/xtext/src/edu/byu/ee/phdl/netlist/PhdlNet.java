package edu.byu.ee.phdl.netlist;

import java.util.ArrayList;
import java.util.List;

public class PhdlNet implements Comparable<Object> {

	private String name;
	private final List<PhdlPin> pins;

	public PhdlNet() {
		this.pins = new ArrayList<PhdlPin>();
	}

	public boolean addPin(PhdlPin pin) {
		return pins.add(pin);
	}

	@Override
	public int compareTo(Object o) {
		return this.name.compareTo(((PhdlNet) o).getName());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhdlNet other = (PhdlNet) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public List<PhdlPin> getPins() {
		return pins;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + getName() + ", " + getPins().size() + " pins.";
	}

}
