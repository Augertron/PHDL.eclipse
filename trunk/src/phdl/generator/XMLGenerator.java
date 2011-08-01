package phdl.generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import phdl.graph.AttributeNode;
import phdl.graph.DesignNode;
import phdl.graph.DeviceNode;
import phdl.graph.InstanceNode;
import phdl.graph.NetNode;
import phdl.graph.PinNode;

public class XMLGenerator {

	private DesignNode design;
	private String xml;
	
	public XMLGenerator(DesignNode design) {
		this.design = design;
		generate();
	}
	
	private void generate() {
		xml = "<design>";
		for (DeviceNode d : design.getDevices()) {
			xml += "\n\t<device>";
			xml += "\n\t\t<name>" + d.getName() + "</name>";
			for (AttributeNode a : d.getAttributes()) {
				xml += "\n\t\t<attribute>";
				xml += "\n\t\t\t<name>" + a.getName() + "</name>";
				xml += "\n\t\t\t<value>" + a.getValue() + "</value>";
				xml += "\n\t\t</attribute>";
			}
			for (PinNode p : d.getPins()) {
				xml += "\n\t\t<pin>";
				xml += "\n\t\t\t<name>" + p.getName() + "</name>";
				xml += "\n\t\t\t<number>" + p.getPinName() + "</number>";
				xml += "\n\t\t</pin>";
			}
			xml += "\n\t</device>";
		}
		for (NetNode n : design.getNets()) {
			xml += "\n\t<net>";
			xml += "\n\t\t<name>" + n.getName() + "</name>";
			for (AttributeNode a : n.getAttributes()) {
				xml += "\n\t\t<attribute>";
				xml += "\n\t\t\t<name>" + a.getName() + "</name>";
				xml += "\n\t\t\t<value>" + a.getValue() + "</value>";
				xml += "\n\t\t</attribute>";
			}
			xml += "\n\t</net>";
		}
		for (InstanceNode i : design.getInstances()) {
			xml += "\n\t<instance>";
			xml += "\n\t\t<name>" + i.getName() + "</name>";
			xml += "\n\t\t<device name>" + i.getDevice().getName() + "</device name>";
			for (AttributeNode a : i.getAttributes()) {
				xml += "\n\t\t<attribute>";
				xml += "\n\t\t\t<name>" + a.getName() + "</name>";
				xml += "\n\t\t\t<value>" + a.getValue() + "</value>";
				xml += "\n\t\t</attribute>"; 
			}
			for (PinNode p : i.getPins()) {
				xml += "\n\t\t<pin>";
				xml += "\n\t\t\t<name>" + p.getName() + "</name>";
				xml += "\n\t\t\t<net>" + p.getNet().getName() + "</net>";
				xml += "\n\t\t</pin>";
			}
			xml += "\n\t</instance>";
		}
		xml += "\n</device>";
	}
	
	/**
	 * Generates a .xml file containing all the design data
	 * 
	 * @param fileName the name of the file to be written
	 */
	public void outputToFile(String fileName) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
			out.write(toString());
			out.close();
		} catch (IOException e) {
			System.err.println("File Reading Error - filename may be corrupt");
			System.exit(1);
		}
	}
	
	@Override
	public String toString() {
		return xml;
	}
}
