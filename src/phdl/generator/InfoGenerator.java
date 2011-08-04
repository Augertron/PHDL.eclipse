package phdl.generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import phdl.graph.DesignNode;
import phdl.graph.InstanceNode;

public class InfoGenerator {

	String info;
	
	public InfoGenerator(DesignNode design) {
		StringBuilder sb = new StringBuilder();
		sb.append("Design " + design.getName() + " Info\n" + design.getInfo() + "\n\n");
		List<String> visited = new ArrayList<String>();
		for (InstanceNode i : design.getInstances()) {
			if (!visited.contains(i.getInfo())) {
				visited.add(i.getInfo());
				int pos = i.getName().indexOf('(');
				if (pos == -1) pos = i.getName().length(); 
				sb.append("\nInstance " + i.getName().substring(0,pos) + " Info\n" + i.getInfo() + "\n");
			}
		}
		info = sb.toString();
	}
	
	public String getInfo() {
		return info;
	}
	
	/**
	 * Generates a .info file containing all the info structures
	 * 
	 * @param fileName
	 *            the name of the file to be written
	 */
	public void outputToFile(String fileName) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
			out.write(info);
			out.close();
		} catch (IOException e) {
			System.err.println("File Reading Error - filename may be corrupt");
			System.exit(1);
		}
		System.out.println("Wrote info file: " + fileName);
	}
	
}
