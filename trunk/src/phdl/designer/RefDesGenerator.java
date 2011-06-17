/*
    Copyright (C) 2011  BYU Configurable Computing Lab

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package phdl.designer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


/**
 * A class that generates a reference designation for each device instance on a
 * PCB.
 * 
 * Uses a complete design to generate a .csv file with the instance name in the
 * left column and the reference designation in the right column.
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 * 
 */
public class RefDesGenerator {

	private HashMap<String, String> myCSV;

	/**
	 * Default Constructor.
	 * 
	 * Initializes the csv data structure and creates designators based on a
	 * design.
	 * 
	 * @param design
	 *            the design that the reference designators will come from
	 */
	public RefDesGenerator(PHDLDesign design) {
		analyzeDesign(design);
	}

	/**
	 * Analyzes a design to create reference designators.
	 * 
	 * @param design
	 *            the design that the reference designators will come from
	 */
	public void analyzeDesign(PHDLDesign design) {
		myCSV = new HashMap<String, String>();
		HashSet<PHDLInstance> instances = design.getInstances();
		resolveHardRef(instances);
		resolveSoftRef(instances);
	}

	private void resolveHardRef(HashSet<PHDLInstance> instances) {
		for (PHDLInstance i : instances) {
			if (i.hasRefDes()) {
				setHardRef(i);
			}
		}
	}

	private void setHardRef(PHDLInstance i) {
		String name = i.getInstName();
		HashSet<PHDLAttribute> attributes = i.getAttributes();
		for (PHDLAttribute a : attributes) {
			if (a.getName().equals("refDes")) {
				String refDes = a.getValue();
				if (myCSV.containsValue(refDes)) {
					System.err.println("The refDes \"" + refDes
							+ "\" has already been used.  It will be ignored.");
				} else {
					myCSV.put(name, refDes);
				}
			}
		}
	}

	private void resolveSoftRef(HashSet<PHDLInstance> instances) {
		for (PHDLInstance i : instances) {
			if (i.hasRefPrefix() && !i.hasRefDes()) {
				setSoftRef(i);
			}
		}
	}

	private void setSoftRef(PHDLInstance i) {
		String name = i.getInstName();
		HashSet<PHDLAttribute> attributes = i.getAttributes();
		for (PHDLAttribute a : attributes) {
			if (a.getName().equals("refPrefix")) {
				String refPrefix = a.getValue();
				int cnt = 1;
				while (myCSV.containsValue(refPrefix + cnt)) {
					cnt++;
				}
				myCSV.put(name, refPrefix + cnt);
			}
		}
	}

	/**
	 * Outputs a .csv file with all the reference designators for the current
	 * design.
	 * 
	 * @param filename
	 *            the name of the output csv file
	 * @return true if the file was successfully created false otherwise
	 */
	public boolean generateCSVFile(String filename) {
		if (myCSV == null) {
			System.err
					.println("The csv data structure has not been initialized.");
			return false;
		}
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
		 * Methods Tested******************** Constructor generateCSVFile
		 */
		boolean success = true;
		PHDLDesign desTest = new PHDLDesign("desTest");
		PHDLInstance inst1 = new PHDLInstance("res1", null);
		inst1.addAttribute(new PHDLAttribute("refPrefix", "R")); // Will start
																	// off as
																	// "R1"
		// But will be overridden to "R4, R5, R6, R7"
		PHDLInstance inst2 = new PHDLInstance("cap1", null);
		inst2.addAttribute(new PHDLAttribute("refDes", "C3")); // Will be "C3"

		PHDLInstance inst3 = new PHDLInstance("res2", null);
		inst3.addAttribute(new PHDLAttribute("refDes", "R1")); // Will be "R1"

		PHDLInstance inst4 = new PHDLInstance("ind1", null);
		inst4.addAttribute(new PHDLAttribute("refPrefix", "L")); // Will be "L1"

		PHDLInstance inst5 = new PHDLInstance("opAmp1", null);
		inst5.addAttribute(new PHDLAttribute("refPrefix", "J")); // Will start
																	// off as
																	// "J1"
		inst5.addAttribute(new PHDLAttribute("refDes", "J2")); // But will be
																// overridden to
																// "J2"

		PHDLInstance inst6 = new PHDLInstance("res3", null);
		inst6.addAttribute(new PHDLAttribute("refDes", "R3")); // Will be "R3"

		PHDLInstance inst7 = new PHDLInstance("res4", null);
		inst7.addAttribute(new PHDLAttribute("refPrefix", "R")); // "R4, R5, R6, R7"

		PHDLInstance inst8 = new PHDLInstance("res5", null);
		inst8.addAttribute(new PHDLAttribute("refPrefix", "R")); // "R4, R5, R6, R7"

		PHDLInstance inst9 = new PHDLInstance("res6", null);
		inst9.addAttribute(new PHDLAttribute("refPrefix", "R")); // "R4, R5, R6, R7"

		PHDLInstance fail1 = new PHDLInstance("fail1", null); // Will be ignored
		fail1.addAttribute(new PHDLAttribute("refDes", "R1"));

		PHDLInstance inst10 = new PHDLInstance("res7", null);
		inst10.addAttribute(new PHDLAttribute("refDes", "R2")); // Will be "R2"

		/*
		 * Output****************** cap1 C3 ind1 L1 opAmp1 J2 res1 (R4, R5, R6,
		 * R7) res2 R1 res3 R3 res4 (R4, R5, R6, R7) res5 (R4, R5, R6, R7) res6
		 * (R4, R5, R6, R7) res7 R2****************** Make sure that fail1 is
		 * not in the CSV file
		 */

		desTest.addInstance(inst1);
		desTest.addInstance(inst2);
		desTest.addInstance(inst3);
		desTest.addInstance(inst4);
		desTest.addInstance(inst5);
		desTest.addInstance(inst6);
		desTest.addInstance(inst7);
		desTest.addInstance(inst8);
		desTest.addInstance(inst9);
		desTest.addInstance(fail1);
		desTest.addInstance(inst10);

		RefDesGenerator rdg = new RefDesGenerator(desTest);
		success &= rdg.generateCSVFile("rdgTest.csv");

		return success;
	}
}
