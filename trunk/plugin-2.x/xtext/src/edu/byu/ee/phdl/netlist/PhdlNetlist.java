package edu.byu.ee.phdl.netlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import edu.byu.ee.phdl.elaboration.EConnection;
import edu.byu.ee.phdl.elaboration.EDesign;
import edu.byu.ee.phdl.elaboration.EInstance;
import edu.byu.ee.phdl.elaboration.EPin;

public class PhdlNetlist {

	private Map<String, Pair<String, String>> parts;
	private Map<String, List<Pair<String, String>>> nets;

	public PhdlNetlist(EDesign design) {
		this.parts = new HashMap<String, Pair<String, String>>();
		this.nets = new HashMap<String, List<Pair<String, String>>>();
		buildNetlist(design);
	}

	private void buildNetlist(EDesign design) {
		for (String s : design.getRefMap().keySet()) {
			String footprint = design.getRefMap().get(s).getFootprint();
			String library = design.getRefMap().get(s).getLibrary();
			Pair<String, String> partData = Tuples.create(footprint, library);
			parts.put(s, partData);
		}
		for (EConnection c : design.getNetlist()) {
			List<Pair<String, String>> pins = new ArrayList<Pair<String, String>>();
			for (EPin p : c.getPins()) {
				String partName = ((EInstance) p.getParent()).getRefDes();
				String pinName = p.getPinMapping();
				Pair<String, String> pinData = Tuples.create(partName, pinName);
				pins.add(pinData);
			}
			nets.put(c.getNameIndex(), pins);
		}
	}

	public Map<String, List<Pair<String, String>>> getNets() {
		return nets;
	}

	public Map<String, Pair<String, String>> getParts() {
		return parts;
	}

}
