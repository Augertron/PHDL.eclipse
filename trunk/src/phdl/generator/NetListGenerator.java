package phdl.generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import phdl.graph.DesignNode;
import phdl.graph.InstanceNode;
import phdl.graph.NetNode;
import phdl.graph.PinNode;

public class NetListGenerator {

	DesignNode design;
	Map<InstanceNode, String> refMap;
	String contents;
	
	public NetListGenerator(DesignNode design, Map<InstanceNode, String> refMap) {
		this.design = design;
		this.refMap = refMap;
		generate();
	}
	
	private void generate() {
		contents = "!PADS-POWERPCB-V3.0-MILS!\n\n";
		contents += "*PART*";
		for (InstanceNode i : refMap.keySet()) {
			contents += refMap.get(i);
			contents += "\t" + "FOOTPRINT\n";
		}
		contents += "\n";
		contents += "*NET*";
		for (NetNode n : design.getNets()) {
			contents += "*SIGNAL* ";
			contents += n.getName().toUpperCase();
			contents += "\n";
			for (PinNode p : n.getPinNodes()) {
				contents += " ";
				contents += refMap.get(((InstanceNode)p.getParent()));
				contents += ".";
				contents += p.getPinName();
			}
			contents += "\n";
		}
		contents += "\n*END*";
	}
	
	public String getContents() {
		return contents;
	}
	
	public void outputToFile(String fileName) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
			out.write(contents);
			out.close();
		} catch (IOException e) {
			System.err.println("File Reading Error - filename may be corrupt");
			System.exit(1);
		}
	}
	
}
