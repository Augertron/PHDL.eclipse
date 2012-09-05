package edu.byu.ee.phdl.netlist;

import java.util.SortedSet;
import java.util.TreeSet;

public class PhdlNetlist {

	private final String name;

	private final SortedSet<PhdlPart> parts;
	private final SortedSet<PhdlNet> nets;

	public PhdlNetlist(String name) {
		this.name = name;
		this.parts = new TreeSet<PhdlPart>();
		this.nets = new TreeSet<PhdlNet>();
	}

	public boolean addNet(PhdlNet net) {
		return nets.add(net);
	}

	public boolean addPart(PhdlPart part) {
		return parts.add(part);
	}

	public String getName() {
		return name;
	}

	public SortedSet<PhdlNet> getNets() {
		return nets;
	}

	public SortedSet<PhdlPart> getParts() {
		return parts;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + getName() + ", " + getParts().size() + " parts, " + getNets().size()
				+ " nets.";
	}
}
