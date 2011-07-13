package utils.csv2phdl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
class SigCompare implements Comparator {
	public int compare(Object o1, Object o2) {
		String i1 = (String) o1;
		String i2 = (String) o2;
		Pattern IndexPat = Pattern.compile("<[0-9]+>");
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
 * This program reads Xilinx Comma Separated Value, csv, files and generates customized component
 * declaration and instantiation templates for use in printed circuit HDL designs.
 * 
 * @author pedro
 */
public class Main {

	/**
	 * This little function returns the integer value of the index of a vector signal name.
	 * 
	 * @param SigString
	 * @return
	 */
	public static Integer getIndex(String SigString) {
		Pattern IndexPat = Pattern.compile("<[0-9]+>");
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
	public static void PrintDeclaration(TreeMap SigHash, TreeMap PowHash, TreeMap UnusedHash,
		String PartNum, String Package, String FileRoot) {

		System.out.println("\n// Part declaration extracted from Xilinx " + FileRoot + "_pad.csv");
		System.out.println("device " + FileRoot + " is");
		System.out.println("    refprefix = \"U\";");
		System.out.println("    pkg_type = \"" + Package + "\";");
		System.out.println("    mfgr = \"XILINX\";");
		System.out.println("    partNumber = \"" + PartNum + "\";");
		System.out.println("begin");
		System.out.println("    // User I/O pins.");
		Iterator it = SigHash.keySet().iterator();
		while (it.hasNext()) {
			Object KeyString = it.next();
			int vectorSize = ((TreeMap) SigHash.get(KeyString)).size();
			if (vectorSize == 1) {
				System.out.print("    pin  " + ((String) KeyString) + "    \"");
			} else {
				Integer firstIndex = getIndex((String) ((TreeMap) SigHash.get(KeyString))
					.firstKey());
				Integer lastIndex = getIndex((String) ((TreeMap) SigHash.get(KeyString)).lastKey());
				System.out.print("    pin" + "[" + firstIndex + ":" + lastIndex + "] "
					+ ((String) KeyString) + " \"");
			}
			Iterator innerIt = ((TreeMap) SigHash.get(KeyString)).keySet().iterator();
			while (innerIt.hasNext()) {
				Object innerKeyString = innerIt.next();
				System.out
					.print(((String[]) ((TreeMap) SigHash.get(KeyString)).get(innerKeyString))[0]);
				// System.out.print(((String)innerKeyString));
				if (innerIt.hasNext())
					System.out.print(",");
			}
			System.out.println("\";");
		}

		System.out.println("\n    // Power and dedicated FPGA pins.");
		it = PowHash.keySet().iterator();
		while (it.hasNext()) {
			Object KeyString = it.next();
			int vectorSize = ((TreeMap) PowHash.get(KeyString)).size();
			if (vectorSize == 1) {
				System.out.print("    pin  " + ((String) KeyString) + "    \"");
			} else {
				Integer firstIndex = vectorSize - 1;
				Integer lastIndex = 0;
				System.out.print("    pin" + "[" + firstIndex + ":" + lastIndex + "] "
					+ ((String) KeyString) + " \"");
			}
			// System.out.print(((String)KeyString) + "   " +
			// ((TreeMap)PowHash.get(KeyString)).size() + " \"" );
			Iterator innerIt = ((TreeMap) PowHash.get(KeyString)).keySet().iterator();
			while (innerIt.hasNext()) {
				Object innerKeyString = innerIt.next();
				System.out.print(((String) innerKeyString));
				if (innerIt.hasNext())
					System.out.print(",");
			}
			System.out.println("\";");
		}

		System.out.println("\n    // UNUSED I/O pins.");
		it = UnusedHash.keySet().iterator();
		while (it.hasNext()) {
			Object KeyString = it.next();
			System.out.print("    pin  " + ((String) KeyString) + "   \"");
			Iterator innerIt = ((TreeMap) UnusedHash.get(KeyString)).keySet().iterator();
			while (innerIt.hasNext()) {
				Object innerKeyString = innerIt.next();
				System.out.print(((String[]) ((TreeMap) UnusedHash.get(KeyString))
					.get(innerKeyString))[0]);
				if (innerIt.hasNext())
					System.out.print(",");
			}
			System.out.println("\";");
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
	public static void PrintInstantiation(TreeMap SigHash, TreeMap PowHash, TreeMap UnusedHash) {
		// / This procedure outputs an instantiation template.
		// / Paste it into your board design and edit the attached signal names.

		System.out.println("\n// Signal pins from FPGA design.");
		Iterator it = SigHash.keySet().iterator();
		while (it.hasNext()) {
			Object KeyString = it.next();
			System.out.println(((String) KeyString) + "  => " + ((String) KeyString));
		}

		System.out.println("\n// Power and dedicated FPGA pins.");
		it = PowHash.keySet().iterator();
		while (it.hasNext()) {
			Object KeyString = it.next();
			int size = ((TreeMap) PowHash.get(KeyString)).size();
			if (size == 1) {
				System.out.println(((String) KeyString) + "  => " + ((String) KeyString));
			} else {
				System.out.println(((String) KeyString) + "  => (others=>" + ((String) KeyString)
					+ ")");
			}
		}

		System.out.println("\n// UNUSED I/O pins.");
		it = UnusedHash.keySet().iterator();
		while (it.hasNext()) {
			Object KeyString = it.next();
			System.out.println(((String) KeyString) + "  => open");
		}
	}

	private static String readFile(String file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		StringBuilder stringBuilder = new StringBuilder();
		String ls = System.getProperty("line.separator");
		while ((line = reader.readLine()) != null) {
			stringBuilder.append(line);
			stringBuilder.append(ls);
		}
		return stringBuilder.toString();
	}

	/**
	 * Main() parses the input CSV file and generates the component declaration and instantiation
	 * template.
	 * 
	 * First the entire CSV table is read into an array of strings using
	 * com.Ostermiller.util.CSVParser. Columns 0 through 15 are defined as follows. Pin
	 * Number,Signal Name, Pin Usage,Pin Name,Direction,IO Standard,IO Bank Number,Drive (mA),Slew
	 * Rate,Termination,IOB Delay,Voltage,Constraint,IO Register,Signal Integrity
	 * 
	 * Then let's find all the unique signal identifiers. We need a little logic to decide what to
	 * do with the signal. If there is a non-null string in column 1 then the signal comes from the
	 * compiled FPGA design. Vector signals from the compiled design should be combined into a
	 * single HDL component pin. Next we can look for "UNUSED" in column 4. Unused pins could be
	 * left off the component definition or just appended to the bottom of the file for convenience.
	 * For now we append. Otherwise, we should look to see if it is a power or ground pin by looking
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
		FileReader fr = new FileReader(args[0]);
		CSVParser PinoutTable = new CSVParser(fr);
		PinoutTable.setCommentStart("#");
		PinoutTable.setEscapes("nrtf", "\n\r\t\f");

		String CSVStringArray[][] = PinoutTable.getAllValues();

		TreeMap SigHash = new TreeMap();
		TreeMap PowHash = new TreeMap();
		TreeMap UnusedHash = new TreeMap();
		String SigName = "junk";
		String RootName;
		Pattern IndexPat = Pattern.compile("<[0-9]+>");
		Matcher IndexPatMatcher = IndexPat.matcher(SigName);
		int pin_count = 0;
		TreeMap PinHash;
		for (int r = 0; r < CSVStringArray.length; r++) {
			if ((CSVStringArray[r][0] != "") && (!CSVStringArray[r][0].contains("Pin Number"))) { // If
																									// valid
																									// pin.
				pin_count++;
				if (CSVStringArray[r][1] != "") { // if this pin has a signal name.
					SigName = CSVStringArray[r][1];
					IndexPatMatcher.reset(SigName);
					if (IndexPatMatcher.find()) { // This pin is part of a std_logic_vector.
						RootName = SigName.substring(0, IndexPatMatcher.start());
						if (SigHash.containsKey(RootName)) {
							((TreeMap) SigHash.get(RootName)).put(CSVStringArray[r][1],
								CSVStringArray[r]);
						} else {
							PinHash = new TreeMap(new SigCompare());
							PinHash.put(CSVStringArray[r][1], CSVStringArray[r]);
							SigHash.put(RootName, PinHash);
						}
					} else { // Not part of a std_logic_vector so just add to hashtable.
						PinHash = new TreeMap();
						PinHash.put(CSVStringArray[r][1], CSVStringArray[r]);
						SigHash.put(CSVStringArray[r][1], PinHash);
					}
				} else { // This pin does not have a signal name (power or dedicated pin).
					if (!CSVStringArray[r][4].contains("UNUSED")) { // If not an unused pin.
						RootName = CSVStringArray[r][3];
						if (PowHash.containsKey(RootName)) {
							((TreeMap) PowHash.get(RootName)).put(CSVStringArray[r][0],
								CSVStringArray[r]);
						} else {
							PinHash = new TreeMap();
							PinHash.put(CSVStringArray[r][0], CSVStringArray[r]);
							PowHash.put(RootName, PinHash);
						}
					} else { // If pin is an UNUSED i/o pin.
						RootName = CSVStringArray[r][3];
						PinHash = new TreeMap();
						PinHash.put(RootName, CSVStringArray[r]);
						UnusedHash.put(RootName, PinHash);
					}

				}
			}
		}

		// Lets scan the csv file for the PART TYPE, SPEED GRADE and PACKAGE.
		String WholeFileString = readFile(args[0]);
		Pattern PartNumPat = Pattern.compile("(#PART TYPE:([ ]+)([0-9a-zA-Z]+))");
		Matcher PartNumMatcher = PartNumPat.matcher(WholeFileString);
		String PART_NUMBER;
		if (PartNumMatcher.find()) {
			PART_NUMBER = PartNumMatcher.group(3);
			System.out.println("//PART TYPE = " + PART_NUMBER);
		} else {
			PART_NUMBER = "pn_not_found:";
			System.out.println("//PART TYPE: not found");
		}

		PartNumPat = Pattern.compile("(#SPEED GRADE:([ ]+)([-0-9a-zA-Z-]+))");
		PartNumMatcher = PartNumPat.matcher(WholeFileString);
		String SPEED_GRADE;
		if (PartNumMatcher.find()) {
			SPEED_GRADE = PartNumMatcher.group(3);
			System.out.println("//SPEED GRADE = " + SPEED_GRADE);
		} else {
			SPEED_GRADE = "speed_grade_not_found:";
			System.out.println("//SPEED GRADE: not found");
		}

		PartNumPat = Pattern.compile("(#PACKAGE:([ ]+)([-0-9a-zA-Z-]+))");
		PartNumMatcher = PartNumPat.matcher(WholeFileString);
		String PACKAGE;
		if (PartNumMatcher.find()) {
			PACKAGE = PartNumMatcher.group(3);
			System.out.println("//PACKAGE = " + PACKAGE);
		} else {
			PACKAGE = "package_not_found";
			System.out.println("//PACKAGE: not found");
		}

		PartNumPat = Pattern.compile("(#OUTPUT FILE:([ ]+)([-_.0-9a-zA-Z-]+))");
		PartNumMatcher = PartNumPat.matcher(WholeFileString);
		String InputFile;
		String FileRoot = "junk";
		if (PartNumMatcher.find()) {
			InputFile = PartNumMatcher.group(3);
			System.out.println("//INPUT FILE = " + InputFile);
			PartNumPat = Pattern.compile("_pad.csv");
			IndexPatMatcher = PartNumPat.matcher(InputFile);
			if (IndexPatMatcher.find()) {
				FileRoot = InputFile.substring(0, IndexPatMatcher.start());
			} else {
				FileRoot = InputFile;
			}
			System.out.println("//Root Filename = " + FileRoot);
		} else {
			InputFile = "input_file_not_found";
			System.out.println("INPUT FILE: not found");
		}

		String FullPartNum = PART_NUMBER + SPEED_GRADE + PACKAGE;
		System.out.println("//Full Part Number = " + FullPartNum);

		// OK, now we have all the data organized into a hash table of hash tables.
		// These functions walk through the data and print the output file.

		PrintDeclaration(SigHash, PowHash, UnusedHash, FullPartNum, PACKAGE, FileRoot);
		// PrintInstantiation(SigHash, PowHash, UnusedHash);

		System.out.println("//total pins found = " + pin_count);

	}

}
