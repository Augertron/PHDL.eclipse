package phdl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.HashMap;

public class RefDesGenerator {
	
	private HashSet<csvEntry> myCSV;
	
	public RefDesGenerator(PHDLDesign design) {
		HashSet<PHDLInstance> instances = design.getInstances();
		HashMap<String, Integer> refDesCounter = new HashMap<String, Integer>();
		myCSV = new HashSet<csvEntry>();
		resolveHardRefDes(instances, refDesCounter);
		for (PHDLInstance i : instances) {
			analyzeDevice(i, refDesCounter);
		}
	}

	private void resolveHardRefDes(HashSet<PHDLInstance> instances,
			   					   HashMap<String, Integer> refDesCounter) {
		for (PHDLInstance d : instances) {
			if (d.hasRefDes()) {
				String des = d.getRefDes();
				boolean different = myCSV.add(new csvEntry(d.getInstName(), des)); 
				if (!different) {
					System.err.println("The mandated reference designator "
										+ des
										+ " for "
										+ d.getInstName()
										+ " has already been mandated by another device.");
					System.exit(1);
				}
				else {
					System.out.print(des);
					des = des.replaceAll("[0-9]", " ");
					des = des.trim();
					System.out.println("\t" + des);
					int newCnt = 0;
					if (refDesCounter.containsKey(des)) {
						newCnt = refDesCounter.get(des);
					}
					refDesCounter.put(des, ++newCnt);
				}
			}
		}
	}
	
	private void analyzeDevice(PHDLInstance d, HashMap<String, Integer> refDesCounter) {
		if (d.hasRefPrefix() && !d.hasRefDes()) {
			String prefix = d.getRefPrefix();
			int newCnt = 0;
			if (refDesCounter.containsKey(prefix)) {
				newCnt = refDesCounter.get(prefix);
			}
			String newRefDes;
			do {
				newRefDes = prefix + (++newCnt);
			} while (!myCSV.add(new csvEntry(d.getInstName(), newRefDes)));
			refDesCounter.put(prefix, newCnt);
		}
	}
	
	public boolean generateCSVFile(String filename) {
		String fileContents = toString();
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filename));
			out.write(fileContents);
			out.close();
		} catch (IOException e) {
			System.err.println("File Reading Error - filename may be corrupt");
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		String myString = "";
		Object[] csvArray = myCSV.toArray();
		for (int i = 0; i < myCSV.size(); i++) {
			myString += csvArray[i].toString();
			myString += "\n";
		}
		return myString;
	}
	
	public static boolean unitTest() {
		/*
		 * Methods Tested
		 *********************
		 * Constructor
		 * generateCSVFile
		 */
		boolean success = true;
		PHDLDesign desTest = new PHDLDesign("desTest");
		PHDLInstance inst1 = new PHDLInstance("res1", null);
		inst1.addAttribute(new PHDLAttribute("refPrefix", "R"));	// Will start off as "R1"
																	// But will be overridden to "R2" or "R4"
		PHDLInstance inst2 = new PHDLInstance("cap1", null);
		inst2.addAttribute(new PHDLAttribute("refDes", "C3"));		// Will be "C3"
		
		PHDLInstance inst3 = new PHDLInstance("res2", null);
		inst3.addAttribute(new PHDLAttribute("refDes", "R1"));		// Will be "R1"
		
		PHDLInstance inst4 = new PHDLInstance("ind1", null);
		inst4.addAttribute(new PHDLAttribute("refPrefix", "L"));	// Will be "L1"
		
		PHDLInstance inst5 = new PHDLInstance("opAmp1", null);
		inst5.addAttribute(new PHDLAttribute("refPrefix", "J"));	// Will start off as "J1"
		inst5.addAttribute(new PHDLAttribute("refDes", "J2"));		// But will be overridden to "J2"
		
		PHDLInstance inst6 = new PHDLInstance("res3", null);
		inst6.addAttribute(new PHDLAttribute("refDes", "R3"));		// Will be "R3"
		
		PHDLInstance inst7 = new PHDLInstance("res4", null);
		inst7.addAttribute(new PHDLAttribute("refPrefix", "R"));	// Will be "R2" or "R4"
		
		/* Output
		 *******************
		 *	cap1	C3
		 *	ind1	L1
		 *	opAmp1	J2
		 *	res1	R4 (or R2)
		 *	res2	R1
		 *	res3	R3
		 *	res4	R2 (or R4)
		 ******************* 
		 */
		
		desTest.addInstance(inst1);
		desTest.addInstance(inst2);
		desTest.addInstance(inst3);
		desTest.addInstance(inst4);
		desTest.addInstance(inst5);
		desTest.addInstance(inst6);
		desTest.addInstance(inst7);
		
		RefDesGenerator rdg = new RefDesGenerator(desTest);
		success &= rdg.generateCSVFile("rdgTest.csv");
		
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
