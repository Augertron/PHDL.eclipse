package edu.byu.ee.phdl.netlist;

import java.util.SortedSet;
import java.util.TreeSet;

import edu.byu.ee.phdl.elaboration.EConnection;
import edu.byu.ee.phdl.elaboration.EDesign;
import edu.byu.ee.phdl.elaboration.EInstance;
import edu.byu.ee.phdl.elaboration.EPin;

public class PhdlNetlist {

	private final String name;

	private final SortedSet<PhdlPart> parts;
	private final SortedSet<PhdlNet> nets;

	public PhdlNetlist(EDesign design) {
		this.name = design.getName();
		this.parts = new TreeSet<PhdlPart>();
		this.nets = new TreeSet<PhdlNet>();
		buildNetlist(design);
	}

	public boolean addNet(PhdlNet net) {
		return nets.add(net);
	}

	public boolean addPart(PhdlPart part) {
		return parts.add(part);
	}

	private void buildNetlist(EDesign design) {
		for (String name : design.getRefMap().keySet()) {
			PhdlPart part = new PhdlPart(name);
			part.setFootprint(design.getRefMap().get(name).getFootprint());
			part.setLibrary(design.getRefMap().get(name).getLibrary());
			addPart(part);
		}
		for (EConnection c : design.getNetlist()) {
			PhdlNet net = new PhdlNet();
			net.setName(c.getName());
			for (EPin p : c.getPins()) {
				PhdlPin pin = new PhdlPin(((EInstance) p.getParent()).getRefDes(), p.getPinMapping());
				net.addPin(pin);
			}
			addNet(net);
		}
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
