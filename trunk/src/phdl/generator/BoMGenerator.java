package phdl.generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import phdl.graph.AttributeNode;
import phdl.graph.DesignNode;
import phdl.graph.InstanceNode;

public class BoMGenerator {
	
	private DesignNode design;
	List<List<String>> database;
	private String bom;
	
	public BoMGenerator(DesignNode design) {
		this.design = design;
		generate();
		generateString();
	}
	
	private void generate() {
		database = new ArrayList<List<String>>();
		
		List<String> headers = new ArrayList<String>();
		headers.add("Device Name");
		
		// Populate Headers
		for (InstanceNode i : design.getInstances()) {
			for (AttributeNode a : i.getAttributes()) {
				if (!headers.contains(a.getName())) {
					headers.add(a.getName());
				}
			}
		}
		
		database.add(headers);
		// Add devices
		for (InstanceNode i : design.getInstances()) {
			List<String> newRow = new ArrayList<String>();
			newRow.add(i.getDevice().getName());
			for (int j = 1; j < headers.size(); j++) {
				for (AttributeNode a : i.getAttributes()) {
					if (a.getName().equals(headers.get(j))) {
						newRow.add(a.getValue());
						break;
					}
				}
			}
			database.add(newRow);
		}
	}
	
	private void generateString() {
		bom = "PHDL Generated Bill of Materials\n";
		for (int i = 0; i < database.size(); i++) {
			for (int j = 0; j < database.get(i).size(); j++) {
				bom += database.get(i).get(j);
				if (j+1 != database.get(i).size()) {
					bom += ",";
				}
			}
			bom += "\n";
		}
	}
	
	public String getBoMString() {
		return bom;
	}
	
	public void outputToFile(String fileName) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
			out.write(bom);
			out.close();
		} catch (IOException e) {
			System.err.println("File Reading Error - filename may be corrupt");
			System.exit(1);
		}
	}
	
}
