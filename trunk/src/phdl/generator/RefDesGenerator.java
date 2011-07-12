package phdl.generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import phdl.graph.DesignNode;
import phdl.graph.InstanceNode;

public class RefDesGenerator {
	
	private Map<InstanceNode, String> refMap = new TreeMap<InstanceNode, String>();
	private DesignNode design;
	
	public RefDesGenerator(DesignNode design) {
		this.design = design;
		generate();
	}
	
	private void generate() {
		Set<InstanceNode> softInsts = new TreeSet<InstanceNode>();
		for (InstanceNode i : design.getInstances()) {
			if (i.getRefDes() != null) {
				refMap.put(i, i.getRefDes());
			} else {
				softInsts.add(i);
			}
		}
		for (InstanceNode i : softInsts) {
			String refPrefix = i.getRefPrefix();
			int j = 1;
			while (refMap.containsValue(refPrefix + j)) {
				j++;
			}
			refMap.put(i, refPrefix + j);
		}
	}
	
	public Map<InstanceNode, String> getRefMap() {
		return refMap;
	}
	
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
	
	public String toString() {
		String myString = "";
		Set<InstanceNode> instNames = refMap.keySet();
		for (InstanceNode i : instNames) {
			myString += i.getName();
			myString += ",";
			myString += refMap.get(i);
			myString += "\n";
		}
		return myString;
	}
}
