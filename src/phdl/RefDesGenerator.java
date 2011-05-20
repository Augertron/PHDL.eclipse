package phdl;

import java.util.SortedSet;
import java.util.HashSet;
import java.util.HashMap;

public class RefDesGenerator {
	
	private SortedSet<csvEntry> myCSV;
	
	public RefDesGenerator(PHDLDesign design) {
		HashSet<PHDLInstance> instances = design.getInstances();
		HashMap<String, int> refDesCounter = new HashMap<String, int>();
		resolveHardRefDes(instances, refDesCounter);
		for (PHDLInstance i : instances) {
			analyzeDevice(i.getDevice(), refDesCounter, i.getInstName());
		}
	}

	private void resolveHardRefDes(HashSet<PHDLInstance> instances,
			   					   HashMap<String, int> refDesCounter) {
		for (PHDLInstance i : instances) {
			PHDLDevice d = i.getDevice();
			if (d.hasRefDesAttr()) {
				String des = d.getRefDesAttr();
				if (!myCSV.add(new csvEntry(i.getName(), des))) {
					System.err.println("The mandated reference designator "
										+ des
										+ " for "
										+ i.getName()
										+ " has already been mandated by another device.");
					System.exit(1);
				}
			}
		}
	}
	
	
	private void analyzeDevice(PHDLDevice d, HashMap<String, int> refDesCounter,
							   String instName) {
		if (d.hasRefDesPrefix() && !d.hasRefDesAttr()) {
			String prefix = d.getRefDesPrefix();
			int newCnt = 0;
			if (refDesCounter.containsKey(prefix)) {
				newCnt = refDesCounter.get(prefix);
			}
			do {
				String newRefDes = prefix + (++newCnt);
			} while (!myCSV.add(new csvEntry(instName, newRefDes)));
			refDesCounter.put(prefix, newCnt);
		}
	}
	
	
		
	public void generateCSVFile(String filename) {
		String fileContents = toString();
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filename));
			out.write(fileContents);
			out.close();
		} catch (IOException e) {
			System.err.println("File Reading Error - filename may be corrupt");
		}
		
	}
	
	@Override
	public String toString() {
		String myString = "";
		for (int i = 0; i < myCSV.size(); i++) {
			myString += myCSV.get(i).toString();
			myString += "\n";
		}
		return myString;
	}
	
	private class csvEntry implements Comparable {
		private String instName;
		private String refDes;
		
		public csvEntry(String instName, String refDes) {
			this.instName = instName;
			this.refDes = refDes;
		}
		
		public void setRefDes(String refDes) {
			this.refDes = refDes;
		}
		
		public String getRefDes() {
			return refDes;
		}
		
		@Override
		public String toString() {
			return instName + "," + refDes;
		}
		
		@Override
		public int compareTo(csvEntry other) {
			return this.toString().compareTo(other.toString());
		}
	}
	
}
