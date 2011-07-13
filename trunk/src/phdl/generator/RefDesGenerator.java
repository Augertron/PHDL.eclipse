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

	private Map<String, InstanceNode> refMap = new TreeMap<String, InstanceNode>();
	private DesignNode design;

	public RefDesGenerator(DesignNode design) {
		this.design = design;
		generate();
	}

	private void generate() {

		Set<InstanceNode> softInsts = new TreeSet<InstanceNode>();
		for (InstanceNode i : design.getInstances()) {
			if (i.getRefDes() != null) {
				refMap.put(i.getRefDes(), i);
			} else {
				softInsts.add(i);
			}
		}
		// generate refDes's for those that aren't already constrained
		for (InstanceNode i : softInsts) {
			String refprefix = i.getRefPrefix();
			int j = 1;
			while (refMap.containsKey(refprefix + j)) {
				j++;
			}
			String refDes = refprefix + j;
			refMap.put(refDes, i);
			i.setRefDes(refDes);
		}
	}

	public Map<String, InstanceNode> getRefMap() {
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
		Set<String> refs = refMap.keySet();
		for (String s : refs) {
			myString += refMap.get(s).getName();
			myString += ",";
			myString += refMap.get(s).getRefDes();
			myString += "\n";
		}
		return myString;
	}
}
