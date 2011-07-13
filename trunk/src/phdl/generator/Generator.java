package phdl.generator;

import phdl.graph.DesignNode;

public class Generator {

	RefDesGenerator refDesGen;
	NetListGenerator netListGen;
	BoMGenerator bomGen;
	DesignNode design;

	public Generator(DesignNode design) {
		this.design = design;
		refDesGen = new RefDesGenerator(design);
		bomGen = new BoMGenerator(design);
		netListGen = new NetListGenerator(design, refDesGen.getRefMap());
	}

	public void generateRefDes() {
		refDesGen.outputToFile(design.getName() + ".csv");
	}

	public void generateBoM() {
		bomGen.outputToFile(design.getName() + ".bom");
	}

	public void generateNetList() {
		netListGen.outputToFile(design.getName() + ".asc");
	}
}
