package edu.byu.ee.phdl.netlist;

import java.util.SortedSet;
import java.util.TreeSet;

import edu.byu.ee.phdl.elaboration.EConnection;
import edu.byu.ee.phdl.elaboration.EDesign;
import edu.byu.ee.phdl.elaboration.EInstance;
import edu.byu.ee.phdl.elaboration.EPin;

public class PhdlNetlist {

	private String name;

	private SortedSet<PhdlPart> parts;
	private SortedSet<PhdlNet> nets;

	// private Map<String, Pair<String, String>> parts;
	// private Map<String, List<Pair<String, String>>> nets;

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
		for (String s : design.getRefMap().keySet()) {
			PhdlPart part = new PhdlPart();
			part.setName(s);
			part.setFootprint(design.getRefMap().get(s).getFootprint());
			part.setLibrary(design.getRefMap().get(s).getLibrary());
			addPart(part);
		}
		for (EConnection c : design.getNetlist()) {
			PhdlNet net = new PhdlNet();
			net.setName(c.getName());
			for (EPin p : c.getPins()) {
				PhdlPin pin = new PhdlPin();
				pin.setPartName(((EInstance) p.getParent()).getRefDes());
				pin.setPinName(p.getPinMapping());
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

	// public String getPartFootprint(String partName) {
	// return parts.get(partName).getFirst();
	// }
	//
	// public String getPartLibrary(String partName) {
	// return parts.get(partName).getSecond();
	// }
	//
	// public Set<String> getPartNames() {
	// return parts.keySet();
	// }
	//
	// public Map<String, Pair<String, String>> getParts() {
	// return parts;
	// }

}
