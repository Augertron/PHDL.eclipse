package phdl.generator;

import phdl.graph.DesignNode;

public class Generator {

	RefDesGenerator refDesGen;
	NetListGenerator netListGen;
	BoMGenerator bomGen;
	
	public Generator(DesignNode design) {
		refDesGen = new RefDesGenerator(design);
		netListGen = new NetListGenerator(design, refDesGen.getRefMap());
		//TODO implement BoMGenerator
		refDesGen.outputToFile(design.getName() + ".csv");
		netListGen.outputToFile(design.getName() + ".asc");
	}
}
