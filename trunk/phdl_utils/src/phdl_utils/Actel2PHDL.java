package phdl_utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.Ostermiller.util.CSVParser;

/**
 * This Comparator class is used to compare vector pins that have numeric indexes inclosed in <>
 * brackets. In other words std_logic_vectors.
 */
class ActelSigCompare implements Comparator<Object> {
	public int compare(Object o1, Object o2) {
		String i1 = (String) o1;
		String i2 = (String) o2;
		Pattern IndexPat = Pattern.compile("\\[[0-9]+\\]");
		Matcher IndexPatMatcher_o1 = IndexPat.matcher(i1);
		Matcher IndexPatMatcher_o2 = IndexPat.matcher(i2);
		// If it is a vector signal extract the vector indexes and compare them.
		if ((IndexPatMatcher_o1.find()) && (IndexPatMatcher_o2.find())) {
			Integer Index_o1 = Integer.parseInt(i1.substring(IndexPatMatcher_o1.start() + 1,
				IndexPatMatcher_o1.end() - 1));
			Integer Index_o2 = Integer.parseInt(i2.substring(IndexPatMatcher_o2.start() + 1,
				IndexPatMatcher_o2.end() - 1));
			return -Index_o1.compareTo(Index_o2);
		} else {
			return -i1.compareTo(i2);
		}
	}
}


/**
 * This program reads a Comma Separated Value, csv, file created from the Actel 
 * I/O Attribute Editor.
 * The output from this program is a PHDL device declaration and instantiation template for 
 * use in printed circuit HDL designs.
 * 
 * @author pedro
 */
public class Actel2PHDL {
	
	// to save typing create a new object to use in place of System.out
	PrintStream o = System.out;

	/**
	 * This little function returns the integer value of the index of a vector signal name.
	 * 
	 * @param SigString
	 * @return
	 */
	public static Integer getIndex(String SigString) {
		Pattern IndexPat = Pattern.compile("\\[[0-9]+\\]");
		Matcher IndexPatMatcher_o1 = IndexPat.matcher(SigString);
		if ((IndexPatMatcher_o1.find())) {
			return Integer.parseInt(SigString.substring(IndexPatMatcher_o1.start() + 1,
				IndexPatMatcher_o1.end() - 1));
		} else {
			return (999);
		}

	}

	/**
	 * This procedure prints the component declaration. Use an include statement to use this file in
	 * your design.
	 * 
	 * @param SigHash
	 * @param PowHash
	 * @param UnusedHash
	 */
	public static void PrintDeclaration(TreeMap<String, TreeMap<String, String[]>> SigHash,
		TreeMap<String, TreeMap<String, String[]>> PowHash,
		TreeMap<String, TreeMap<String, String[]>> UnusedHash, String inputfile) {

		System.out.println("\n// Device declaration extracted from Xilinx " + inputfile + "_pad.csv");
		System.out.println("device Actel_FPGA is");
		System.out.println("\tattr refPrefix = \"U\";");
		System.out.println("\tattr pkg_type = \"Package\";");
		System.out.println("\tattr mfgr = \"Actel\";");
		System.out.println("\tattr partNumber = \"PartNum\";\n");
		System.out.println("\t// User I/O pins.");
		Iterator<String> it = SigHash.keySet().iterator();
		while (it.hasNext()) {
			Object KeyString = it.next();
			int vectorSize = ((TreeMap<String, String[]>) SigHash.get(KeyString)).size();
			if (vectorSize == 1) {
				System.out.print("\tpin  " + ((String) KeyString) + " = {");
			} else {
				Integer firstIndex = getIndex((String) ((TreeMap<String, String[]>) SigHash.get(KeyString)).firstKey());
				Integer lastIndex = getIndex((String) ((TreeMap<String, String[]>) SigHash.get(KeyString)).lastKey());
				System.out.print("\tpin" + "[" + firstIndex + ":" + lastIndex + "] " + ((String) KeyString) + " = {");
			}
			Iterator<String> innerIt = ((TreeMap<String, String[]>) SigHash.get(KeyString)).keySet().iterator();
			while (innerIt.hasNext()) {
				Object innerKeyString = innerIt.next();
				System.out
					.print(((String[]) ((TreeMap<String, String[]>) SigHash.get(KeyString)).get(innerKeyString))[0]);
				if (innerIt.hasNext())
					System.out.print(",");
			}
			System.out.println("};");
		}

		System.out.println("\n\t// Power and dedicated FPGA pins.");
		it = PowHash.keySet().iterator();
		while (it.hasNext()) {
			Object KeyString = it.next();
			int vectorSize = ((TreeMap<String, String[]>) PowHash.get(KeyString)).size();
			if (vectorSize == 1) {
				System.out.print("\tpin  " + ((String) KeyString) + " = {");
			} else {
				Integer firstIndex = vectorSize - 1;
				Integer lastIndex = 0;
				System.out.print("\tpin" + "[" + firstIndex + ":" + lastIndex + "] "
					+ ((String) KeyString) + " = {");
			}
			Iterator<String> innerIt = ((TreeMap<String, String[]>) PowHash.get(KeyString)).keySet().iterator();
			while (innerIt.hasNext()) {
				Object innerKeyString = innerIt.next();
				System.out.print(((String) innerKeyString));
				if (innerIt.hasNext())
					System.out.print(",");
			}
			System.out.println("};");
		}

		System.out.println("\n\t// UNUSED I/O pins.");
		it = UnusedHash.keySet().iterator();
		while (it.hasNext()) {
			Object KeyString = it.next();
			System.out.print("\tpin  " + ((String) KeyString) + " = {");
			Iterator<String> innerIt = ((TreeMap<String, String[]>) UnusedHash.get(KeyString)).keySet().iterator();
			while (innerIt.hasNext()) {
				Object innerKeyString = innerIt.next();
				System.out.print(((String[]) ((TreeMap<String, String[]>) UnusedHash.get(KeyString))
					.get(innerKeyString))[0]);
				if (innerIt.hasNext())
					System.out.print(",");
			}
			System.out.println("};");
		}
		System.out.println("end;");
	}

	/**
	 * This procedure prints out a component instantiation template for the convenience of the PHDL
	 * board designer. Paste the instantiation template into your PHDL code and wire it up by
	 * editing the actuals.
	 * 
	 * @param SigHash
	 *            This is the hash table of hash tables that holds the signal pins derived from the
	 *            FPGA design.
	 * @param PowHash
	 *            This is the hash table of hash tables that holds the power and dedicated pins of
	 *            the FPGA.
	 * @param UnusedHash
	 *            This is the hash table of hash tables that holds the unused I/O pins of the FPGA.
	 */
	public static void PrintInstantiation(
			TreeMap<String, TreeMap<String, String[]>> SigHash, 
			TreeMap<String, TreeMap<String, String[]>> PowHash, 
			TreeMap<String, TreeMap<String, String[]>> UnusedHash) {
		// / This procedure outputs an instantiation template.
		// / Paste it into your board design and edit the attached signal names.

		System.out.println("\n// Signal pins from FPGA design.");
		Iterator<String> it = SigHash.keySet().iterator();
		while (it.hasNext()) {
			Object KeyString = it.next();
			System.out.println(((String) KeyString) + " = " + ((String) KeyString) + ";");
		}

		System.out.println("\n// Power and dedicated FPGA pins.");
		it = PowHash.keySet().iterator();
		while (it.hasNext()) {
			Object KeyString = it.next();
			int size = ((TreeMap<String, String[]>) PowHash.get(KeyString)).size();
			if (size == 1) {
				System.out.println(((String) KeyString) + " = " + ((String) KeyString) + ";");
			} else {
				System.out.println(((String) KeyString) + " = " + ((String) KeyString) + ";");
			}
		}

		System.out.println("\n// UNUSED I/O pins.");
		it = UnusedHash.keySet().iterator();
		while (it.hasNext()) {
			Object KeyString = it.next();
			System.out.println(((String) KeyString) + " = open;");
		}
	}

	
	// Usage string for help directions
static private String usage = "\nPHDL Compiler v0.1.\n\n"
                + " * Copyright (C) 2011 BYU Configurable Computing Lab This program is free software: you can\r\n"
                + " * redistribute it and/or modify it under the terms of the GNU General Public License as published\r\n"
                + " * by the Free Software Foundation, either version 3 of the License, or (at your option) any later\r\n"
                + " * version. This program is distributed in the hope that it will be useful, but WITHOUT ANY\r\n"
                + " * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR\r\n"
                + " * PURPOSE. See the GNU General Public License for more details. You should have received a copy of\r\n"
                + " * the GNU General Public License along with this program. If not, see\r\n"
                + " * <http://www.gnu.org/licenses/>.\n\n" + "" + "Usage:\n\n"
        		+ "\tjava phdl_utils.Actel2PHDL <filename.csv>\n\n"
                + "\t<filename.csv>"
                + "\t is an Actel Comma Separated Value file. Output goes to standard out.\n"
                + "\tYou will probably want to run this program something like this.\n"
                + "\t\t\"java phdl_utils.Actel2PHDL pinoutfile.csv > outfile.txt\"\n"
                + "\tthen edit outfile.txt to cut and paste the output into your design.\n\n"
                + "\tThe Actel (MicroSemi) toolchain does not generate a pinout file by default.\n"
                + "\tTo create an Actel CSV pinout report you must open Actel's Designer program\n"
                + "\ton your design then select \"I/O Attribute Editor\".  From within that program\n"
                + "\tselect the \"Package Pins\" tab. That gives you a spreadsheet view of all the pins\n"
                + "\ton the part. Cut and paste all the data from that spreadsheet into a\n"
                + "\tMicrosoft Excel spreadsheet and then save the file in .csv format.\n\n"
                + "\tThis author has requested that MicroSemi add .csv pinout report generation to\n"
                + "\tthe reports menu of Designer.\n";


	/**
	 * Main() parses the input CSV file and generates the component declaration and instantiation
	 * template.
	 * 
	 * First the entire CSV table is read into an array of strings using
	 * com.Ostermiller.util.CSVParser. Starting with column 0, columns are defined as follows: 
	 * Pin Number, Signal Name, I/O Primitive Type, Actel Specific Pin Name, Pin-Lock Status, 
	 * User Reserved Status, Actel Dedicated Indication, I/O Bank, I/O Standard, Output Drive Strength,
	 * Slew Rate, Pullup Resistor, ...
	 * 
	 * Then let's find all the unique signal identifiers. We need a little logic to decide what to
	 * do with the signal. If there is a non-null string not equal to "--" in column 1 then the signal comes from the
	 * compiled FPGA design. Vector signals from the compiled design should be combined into a
	 * single HDL component pin. 
	 * 
	 * Next we can look for unused I/O pins. Unused pins have column 1 blank in the Actel csv. Unused pins could be
	 * left off the component definition or just appended to the bottom of the file for convenience.
	 * For now we append.
	 * 
	 * Now we can find all the unbonded pins by looking "Not Bonded" in column3. We will append them to the 
	 * device declaration like we did with the unused I/O pins.
	 * 
	 * If neither a signal pin nor unused i/o pin, we should look to see if it is a power or ground pin by looking
	 * in column 3. Power and grounds can be found in column 3 and need to be grouped, ie we want
	 * pin [83:0] GND, pin [5:0] VCCO_3, ...
	 * 
	 * This program works by building an informal AST by constructing a hash tables of hash tables.
	 * The top hash tables, SigHash and PowHash use the name of the component pin as the key. The
	 * value that goes into SigHash is another hash table that contains the list of physical fpga
	 * pins that make up the HDL component pin. The physical pins within a vector pin must be sorted
	 * using a special hash sort so that they are in the correct order, ie: pin [15:0] DQ
	 * "AJ7, Y14, K17, ..."
	 * 
	 * @param args
	 *            arg[0] is the input filename.
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {

		// print out the help if the program is being used incorrectly
		if (args.length != 1) {
			System.out.println(usage);
			System.exit(1);
		}
		// Read the csv file into an array of text strings.
		FileReader fr = new FileReader(args[0]);
		CSVParser PinoutTable = new CSVParser(fr);
		PinoutTable.setCommentStart("#");
		PinoutTable.setEscapes("nrtf", "\n\r\t\f");
		String CSVStringArray[][] = PinoutTable.getAllValues();
		
        //  Create the hash tables we need.
		TreeMap<String, TreeMap<String, String[]>> SigHash    = new TreeMap<String, TreeMap<String, String[]>>();
		TreeMap<String, TreeMap<String, String[]>> PowHash    = new TreeMap<String, TreeMap<String, String[]>>();
		TreeMap<String, TreeMap<String, String[]>> UnusedHash = new TreeMap<String, TreeMap<String, String[]>>();
		
		String SigName = "junk";
		String RootName;
		Pattern IndexPat = Pattern.compile("\\[[0-9]+\\]");
		Matcher IndexPatMatcher = IndexPat.matcher(SigName);
		int pin_count = 0;
		TreeMap<String, String[]> PinHash;
		for (int r = 0; r < CSVStringArray.length; r++) {
			pin_count++;
			if ((CSVStringArray[r][1] != "") && (!CSVStringArray[r][1].contains("--"))){ // if this pin has a signal name.
				SigName = CSVStringArray[r][1];
				IndexPatMatcher.reset(SigName);
				if (IndexPatMatcher.find()) { // This pin is part of a std_logic_vector.
					RootName = SigName.substring(0, IndexPatMatcher.start());
					if (SigHash.containsKey(RootName)) { // If std_logic_vector root name already in SigHash
						//System.out.println("r=" + r + ", signal=" + CSVStringArray[r][1]);
						(SigHash.get(RootName)).put(CSVStringArray[r][1], CSVStringArray[r]);
					} else {
						PinHash = new TreeMap<String, String[]>(new ActelSigCompare());
						PinHash.put(CSVStringArray[r][1], CSVStringArray[r]);
						SigHash.put(RootName, PinHash);
					}
				} else { // Not part of a std_logic_vector so just add to hashtable.
					PinHash = new TreeMap<String, String[]>();
					PinHash.put(CSVStringArray[r][1], CSVStringArray[r]);
					SigHash.put(CSVStringArray[r][1], PinHash);
				}
			} else { // This pin does not have a signal name.
				if (CSVStringArray[r][1].contains("--")) { // If not an unused pin.
					RootName = CSVStringArray[r][3];
					if (PowHash.containsKey(RootName)) {
						(PowHash.get(RootName)).put(CSVStringArray[r][0], CSVStringArray[r]);
					} else {
						PinHash = new TreeMap<String, String[]>();
						PinHash.put(CSVStringArray[r][0], CSVStringArray[r]);
						PowHash.put(RootName, PinHash);
					}
				} else { // If pin is an UNUSED i/o pin.
					RootName = CSVStringArray[r][3];
					PinHash = new TreeMap<String, String[]>();
					PinHash.put(RootName, CSVStringArray[r]);
					UnusedHash.put(RootName, PinHash);
				}
			}
		}


		// OK, now we have all the data organized into a hash table of hash tables.
		// These functions walk through the data and print the output file.

		PrintDeclaration(SigHash, PowHash, UnusedHash, args[0]);
		PrintInstantiation(SigHash, PowHash, UnusedHash);

		System.out.println("\n//Total pins found = " + pin_count);

	}

}
