package phdl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.SortedSet;
import java.util.HashSet;
import java.util.HashMap;

public class RefDesGenerator {
	
	private SortedSet<csvEntry> myCSV;
	
	public RefDesGenerator(PHDLDesign design) {
		HashSet<PHDLInstance> instances = design.getInstances();
		HashMap<String, Integer> refDesCounter = new HashMap<String, Integer>();
		resolveHardRefDes(instances, refDesCounter);
		for (PHDLInstance i : instances) {
			analyzeDevice(i.getDevice(), refDesCounter, i.getInstName());
		}
	}

	private void resolveHardRefDes(HashSet<PHDLInstance> instances,
			   					   HashMap<String, Integer> refDesCounter) {
		for (PHDLInstance i : instances) {
			PHDLDevice d = i.getDevice();
			if (d.hasRefDesAttr()) {
				String des = d.getRefDesAttr();
				if (!myCSV.add(new csvEntry(i.getInstName(), des))) {
					System.err.println("The mandated reference designator "
										+ des
										+ " for "
										+ i.getInstName()
										+ " has already been mandated by another device.");
					System.exit(1);
				}
			}
		}
	}
	
	
	private void analyzeDevice(PHDLDevice d, HashMap<String, Integer> refDesCounter,
							   String instName) {
		if (d.hasRefDesPrefix() && !d.hasRefDesAttr()) {
			String prefix = d.getRefDesPrefix();
			int newCnt = 0;
			if (refDesCounter.containsKey(prefix)) {
				newCnt = refDesCounter.get(prefix);
			}
			String newRefDes;
			do {
				newRefDes = prefix + (++newCnt);
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
		csvEntry[] csvArray = (csvEntry[])myCSV.toArray();
		for (int i = 0; i < myCSV.size(); i++) {
			myString += csvArray[i].toString();
			myString += "\n";
		}
		return myString;
	}
	
	public static boolean unitTest() {
		boolean success = true;
		
		return success;
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
		public int compareTo(Object other) {
			return this.toString().compareTo(((csvEntry)other).toString());
		}
	}
	
}
