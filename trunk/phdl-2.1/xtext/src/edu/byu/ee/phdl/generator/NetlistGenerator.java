package edu.byu.ee.phdl.generator;

import edu.byu.ee.phdl.elaboration.EConnection;
import edu.byu.ee.phdl.elaboration.EDesign;
import edu.byu.ee.phdl.elaboration.EInstance;
import edu.byu.ee.phdl.elaboration.EPin;
import edu.byu.ee.phdl.netlist.PhdlNet;
import edu.byu.ee.phdl.netlist.PhdlNetlist;
import edu.byu.ee.phdl.netlist.PhdlPart;
import edu.byu.ee.phdl.netlist.PhdlPin;

public class NetlistGenerator {

	private PhdlNetlist netlist;

	public NetlistGenerator(EDesign design) {
		this.netlist = new PhdlNetlist(design.getName());
		generate(design);
	}

	public PhdlNetlist getNetlist() {
		return netlist;
	}

	private void generate(EDesign design) {
		for (String name : design.getRefMap().keySet()) {
			PhdlPart part = new PhdlPart(name);
			part.setFootprint(design.getRefMap().get(name).getFootprint());
			part.setLibrary(design.getRefMap().get(name).getLibrary());
			netlist.addPart(part);
		}
		for (EConnection c : design.getNetlist()) {
			PhdlNet net = new PhdlNet();
			net.setName(c.getName());
			for (EPin p : c.getPins()) {
				PhdlPin pin = new PhdlPin(((EInstance) p.getParent()).getRefDes(), p.getPinMapping());
				net.addPin(pin);
			}
			netlist.addNet(net);
		}
	}
}
