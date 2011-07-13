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
	Map<String, InstanceNode> refMap;
	String contents;

	public NetListGenerator(DesignNode design, Map<String, InstanceNode> refMap) {
		this.design = design;
		this.refMap = refMap;
		generate();
	}

	private void generate() {
		contents = "!PADS-POWERPCB-V9.0-MILS! NETLIST FILE FROM PADS LOGIC V9.3 \n\n";
		contents += "*PART*\n";

		for (String s : refMap.keySet()) {
			InstanceNode i = refMap.get(s);
			contents += s;
			contents += " " + i.getDevice().getName().toUpperCase() + "@" + i.getFootprint() + "\n";
		}
		contents += "*CONNNECTION*\n";

		for (NetNode n : design.getNets()) {

			if (n.getName().equals("open"))
				continue;

			contents += "*SIGNAL* " + n.getName().toUpperCase() + "\n";

			for (int i = 0; i < n.getPinNodes().size() - 1; i++) {

				PinNode pin1 = n.getPinNodes().get(i);
				PinNode pin2 = n.getPinNodes().get(i + 1);

				String ref1 = ((InstanceNode) pin1.getParent()).getRefDes();
				String ref2 = (((InstanceNode) pin2.getParent()).getRefDes());
				String name1 = pin1.getPinName();
				String name2 = pin2.getPinName();

				contents += " ";
				contents += refMap.get(ref1).getRefDes();
				contents += ".";
				contents += name1;
				contents += " ";
				contents += refMap.get(ref2).getRefDes();
				contents += ".";
				contents += name2;
				contents += "\n";
			}
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
