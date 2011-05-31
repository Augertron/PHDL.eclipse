package phdl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;

public class RefDesGenerator {
	
	private HashMap<String, String> myCSV;
	
	
	public RefDesGenerator(PHDLDesign design) {
		myCSV = new HashMap<String, String>();
		analyzeDesign(design);
	}
	
	public void analyzeDesign(PHDLDesign design) {
		HashSet<PHDLInstance> instances = design.getInstances();
		for (PHDLInstance i : instances) {
			checkAttributes(i.getInstName(), i);
		}
	}
	
	private void checkAttributes(String name, PHDLInstance i) {
		HashSet<PHDLAttribute> attributes = i.getAttributes();
		if (i.hasRefDes()) {
			for (PHDLAttribute a : attributes) {
				if (a.getName().equals("refDes")) {
					resolveHardRef(name, a);
				}
			}
		}
		else if (i.hasRefPrefix()) {
			for (PHDLAttribute a : attributes) {
				if (a.getName().equals("refPrefix")) {
					resolveSoftRef(name, a);
				}
			}
		}
	}
	
	private void resolveHardRef(String name, PHDLAttribute a) {
		String refDes = a.getValue();
		if (myCSV.containsValue(refDes)) {
			System.err.println("The refDes \"" + refDes + "\" has already been used.  It will be ignored." );
		}
		else {
			myCSV.put(name, refDes);
		}
	}
	
	private void resolveSoftRef(String name, PHDLAttribute a) {
		String refPrefix = a.getValue();
		int cnt = 1;
		while (myCSV.containsValue(refPrefix + cnt)) {
			cnt++;
		}
		myCSV.put(name, refPrefix + cnt);
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
		Set<String> instNames = myCSV.keySet();
		for (String s : instNames) {
			myString += s;
			myString += ",";
			myString += myCSV.get(s);
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
	
}
