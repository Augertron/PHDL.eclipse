package phdl_utils;

//import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.Ostermiller.util.CSVParser;

//This Comparator class is used to compare vector pins that have numeric indexes appended to the end.
//Comparison is done so that sorts work like sig0, sig1, sig2, ..., sig9, sig10, sig11, ...
class CsvSigCompare implements Comparator<Object> {
	public int compare(Object o1, Object o2) {
		String i1 = (String) o1;
		String i2 = (String) o2;
		Pattern IndexPat = Pattern.compile("[0-9]+$"); // This regular expression matches a number on the end!
		Matcher IndexPatMatcher_o1 = IndexPat.matcher(i1);
		Matcher IndexPatMatcher_o2 = IndexPat.matcher(i2);
		// If it is a vector signal extract the vector indexes and compare them.
		if ((IndexPatMatcher_o1.find()) && (IndexPatMatcher_o2.find())) {
			Integer Index_o1 = Integer.parseInt(i1.substring(IndexPatMatcher_o1.start(),IndexPatMatcher_o1.end()));
			Integer Index_o2 = Integer.parseInt(i2.substring(IndexPatMatcher_o2.start(),IndexPatMatcher_o2.end()));
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
public class CSV2PHDL {

	/**
	 * This little function returns the integer value of the index of a vector signal name.
	 * 
	 * @param SigString
	 * @return
	 */
	public static Integer getIndex(String SigString) {
		Pattern IndexPat = Pattern.compile("[0-9]+$");
		Matcher IndexPatMatcher_o1 = IndexPat.matcher(SigString);
		if ((IndexPatMatcher_o1.find())) {
			return Integer.parseInt(SigString.substring(IndexPatMatcher_o1.start(),IndexPatMatcher_o1.end()));
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
		//TreeMap<String, TreeMap<String, String[]>> UnusedHash, 
		String PartNum, 
		String Package,
		String FileRoot) {

//		TreeMap<String, String[]> PinHash;
		System.out.println("\n// Device declaration extracted from Xilinx " + FileRoot);
		System.out.println("device " + FileRoot + " {");
		System.out.println("\tattr refPrefix = \"U\";");
		System.out.println("\tattr pkg_type = \"" + Package + "\";");
		System.out.println("\tattr mfgr = \"mfgr_name\";");
		System.out.println("\tattr partNumber = \"" + PartNum + "\";");
		System.out.println("\tattr pinCount = \"9999\"; // Edit this to the correct number of pins for error checking.\n");
		System.out.println("\t// User I/O pins.");
		Iterator<String> it = SigHash.keySet().iterator();
		while (it.hasNext()) {
			Object KeyString = it.next();
			int vectorSize = ((TreeMap<String, String[]>) SigHash.get(KeyString)).size();
			if (vectorSize == 1) {
				System.out.print("\tpin  " + ((String) KeyString) + " = {");
			} else {
//				PinHash = new TreeMap<String, String[]>(new CsvSigCompare());
//				PinHash = SigHash.get(KeyString);
//				String firstIndexString = PinHash.firstKey();
//				String  lastIndexString = PinHash.lastKey();
				Integer firstIndex = getIndex((String) ((TreeMap<String, String[]>) SigHash.get(KeyString)).firstKey());
				Integer lastIndex  = getIndex((String) ((TreeMap<String, String[]>) SigHash.get(KeyString)).lastKey());
				System.out.print("\tpin" + "[" + firstIndex + ":" + lastIndex + "] " + ((String) KeyString) + " = {");
			}
			Iterator<String> innerIt = ((TreeMap<String, String[]>) SigHash.get(KeyString)).keySet().iterator();
			while (innerIt.hasNext()) {
				Object innerKeyString = innerIt.next();
				System.out.print(((String[]) ((TreeMap<String, String[]>) SigHash.get(KeyString)).get(innerKeyString))[0]);
				if (innerIt.hasNext()) System.out.print(",");
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
		
		System.out.println("};");
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
			TreeMap<String, TreeMap<String, String[]>> PowHash/*, 
			TreeMap<String, TreeMap<String, String[]>> UnusedHash*/) {
		// / This procedure outputs an instantiation template.
		// / Paste it into your board design and edit the attached signal names.

		System.out.println("\n// Signal pins from FPGA design.");
		System.out.println("\n// Paste this into your instantiation to save typing.");
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

		//System.out.println("\n// UNUSED I/O pins.");
		//it = UnusedHash.keySet().iterator();
		//while (it.hasNext()) {
		//	Object KeyString = it.next();
		//	System.out.println(((String) KeyString) + " = open;");
		//}
	}

//	private static String readFile(String file) throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader(file));
//		String line = null;
//		StringBuilder stringBuilder = new StringBuilder();
//		String ls = System.getProperty("line.separator");
//		while ((line = reader.readLine()) != null) {
//			stringBuilder.append(line);
//			stringBuilder.append(ls);
//		}
//		return stringBuilder.toString();
//	}
	
	// Usage string for help directions
	static private String usage = "\nPHDL Utils\n\n"
		+ "\tjava phdl_utils.CSV2PHDL <filename.csv>\n"
		+ "\tConverts a Comma Separated Value file to a PHDL device declaration.\n\tOutput goes to standard out.\n"
		+ "\tColumn 0 = Pin Number, Column 1 = Signal Name.\n"
		+ "\tRepeated signal names are converted into bus pins.\n"
		+ "\tSignal names that end in a number are converted into bus pins.\n\n"
		+ "\tYou will probably want to run this program something like this.\n"
		+ "\t\t\"java phdl_utils.CSV2PHDL filename.csv > filename.phdl\"\n"
		+ "\tthen edit filename.phdl to cut and paste the output into your design.\n" ;

	/**
	 * Main() parses the input CSV file and generates the component declaration and instantiation
	 * template.
	 * 
	 * First the entire CSV table is read into an array of strings using com.Ostermiller.util.CSVParser. 
	 * Column 0 = Pin Number, Column 1 = Signal Name
	 * 
	 * Then let's find all the unique signal identifiers. We need a little logic to decide what to
	 * do with the signal.  Vector signals from the compiled design should be combined into a
	 * single HDL component pin and go into SigHash. Repeated signal names like GND and VCC go into PowHash.
	 * 
	 * This program works by building an informal AST by constructing hash tables of hash tables.
	 * The top hash tables, SigHash and PowHash use the name of the component pin as the key. The
	 * value that goes into SigHash is another hash table that contains the list of physical fpga
	 * pins that make up the HDL component pin. The physical pins within a vector pin must be sorted
	 * using a special hash sort so that they are in the correct order, ie: pin [15:0] DQ = {AJ7, Y14, K17, ...
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
		
		FileReader fr = new FileReader(args[0]);
		CSVParser PinoutTable = new CSVParser(fr);
		PinoutTable.setCommentStart("#");
		PinoutTable.setEscapes("nrtf", "\n\r\t\f");

		String CSVStringArray[][] = PinoutTable.getAllValues();

		TreeMap<String, TreeMap<String, String[]>> SigHash = new TreeMap<String, TreeMap<String, String[]>>();
		TreeMap<String, TreeMap<String, String[]>> PowHash = new TreeMap<String, TreeMap<String, String[]>>();
		TreeMap<String, TreeMap<String, String[]>> RepHash = new TreeMap<String, TreeMap<String, String[]>>();
		TreeMap<String, TreeMap<String, String[]>> TemHash = new TreeMap<String, TreeMap<String, String[]>>();
		String SigName = "junk";
		String RootName;
		TreeMap<String, String[]> PinHash;
		// first we have to go through and find all the repeated signal names so we can handle them specially.
		for (int r = 0; r < CSVStringArray.length; r++) {
			SigName = CSVStringArray[r][1];
			RootName = SigName;
			if (!TemHash.containsKey(RootName)) {
				PinHash = new TreeMap<String, String[]>(new CsvSigCompare());
				PinHash.put(CSVStringArray[r][1], CSVStringArray[r]);
				TemHash.put(RootName, PinHash);
			    PinHash = null;
			}else{ // signal name is repeated.
				PinHash = new TreeMap<String, String[]>(new CsvSigCompare());
				PinHash.put(CSVStringArray[r][1], CSVStringArray[r]);
				RepHash.put(RootName, PinHash);
			    PinHash = null;
			}
		}
		
		// Now TempHash contains all the repeated signal names so we know to put them into PowHash when we see them.
		Pattern IndexPat = Pattern.compile("[0-9]+$");
		Matcher IndexPatMatcher = IndexPat.matcher(SigName);
		int pin_count = 0;
		for (int r = 0; r < CSVStringArray.length; r++) {
			pin_count++;
			SigName = CSVStringArray[r][1];
			IndexPatMatcher.reset(SigName);
			if (!RepHash.containsKey(SigName)) { // If not a repeated signal put it in SigHash.
				if (IndexPatMatcher.find()) { // This pin is part of a std_logic_vector.
					RootName = SigName.substring(0, IndexPatMatcher.start());
					if (SigHash.containsKey(RootName)) {
						((TreeMap<String, String[]>) SigHash.get(RootName)).put(CSVStringArray[r][1],CSVStringArray[r]);
					} else {
						PinHash = new TreeMap<String, String[]>(new CsvSigCompare());
						PinHash.put(CSVStringArray[r][1], CSVStringArray[r]);
						SigHash.put(RootName, PinHash);
						PinHash = null;
					}
				} else { // Not part of a std_logic_vector				
					PinHash = new TreeMap<String, String[]>();
					PinHash.put(CSVStringArray[r][1], CSVStringArray[r]);
					SigHash.put(CSVStringArray[r][1], PinHash);
					PinHash = null;
				}
			}else{ // Put it in PowHash.
				RootName = SigName;
				String pinNumString = CSVStringArray[r][0];
				if (PowHash.containsKey(RootName)) {
					PinHash = (TreeMap<String, String[]>) PowHash.get(RootName);
					((TreeMap<String, String[]>) PowHash.get(RootName)).put(CSVStringArray[r][0],CSVStringArray[r]);
					PinHash = (TreeMap<String, String[]>) PowHash.get(RootName);
					PinHash = (TreeMap<String, String[]>) PowHash.get(RootName);
				} else {
//					PinHash = new TreeMap<String, String[]>(new CsvSigCompare());
					PinHash = new TreeMap<String, String[]>();
					PinHash.put(CSVStringArray[r][0], CSVStringArray[r]);
					PowHash.put(RootName, PinHash);
					PinHash = null;
				}				
			}
		}

		String FullPartNum = "part_number";
		String PACKAGE = "package_type";
		String FileRoot = args[0];

		// OK, now we have all the data organized into a hash table of hash tables.
		// These functions walk through the data and print the output file.

		PrintDeclaration(SigHash, PowHash, /*UnusedHash,*/ FullPartNum, PACKAGE, FileRoot);
		PrintInstantiation(SigHash, PowHash/*, UnusedHash*/);

		System.out.println("\n//Total pins found = " + pin_count);

	}

}
