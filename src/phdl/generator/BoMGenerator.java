/*
    Copyright (C) 2011  Brigham Young University

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, version 3.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package phdl.generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import phdl.graph.Attribute;
import phdl.graph.Design;
import phdl.graph.Device;
import phdl.graph.HierarchyUnit;
import phdl.graph.Instance;
import phdl.graph.SubDesign;
import phdl.graph.SubInstance;

/**
 * Bill of Materials Generator.
 * 
 * This class takes a design and sorts all of its instances attributes into a
 * readable comma- seperated file.
 * 
 * @author Brad Riching and Richard Black
 * @version 0.1
 */
public class BoMGenerator {

	private class Row {
		private int quantity;
		private String name;
		private String refDes;
		private String pkg;
		private String lib;
		private final List<String> entries;

		public Row() {
			quantity = 1;
			name = "";
			refDes = "";
			pkg = "";
			lib = "";
			entries = new ArrayList<String>();
		}

		@Override
		public boolean equals(Object o) {
			Row r = (Row) o;
			boolean equal;
			equal = name.equals(r.name);
			equal &= pkg.equals(r.pkg);
			equal &= lib.equals(r.lib);
			for (String s : entries) {
				equal &= r.entries.contains(s);
			}
			for (String s : r.entries) {
				equal &= entries.contains(s);
			}
			return equal;
		}
	}

	private final Design design;
	private final List<Row> rows;
	private final List<String> headers;
	private List<String> excludes;

	private String bom;

	/**
	 * Default Constructor.
	 * 
	 * Takes a DesignNode, generates the table of attributes, and creates a
	 * string representation of the table.
	 * 
	 * @param design
	 *            the DesignNode that contains all of the attribute information.
	 * @see Design
	 */
	public BoMGenerator(Design d) {
		design = d;
		rows = new ArrayList<Row>();
		headers = new ArrayList<String>();
		generate();
		generateString();
	}

	private void consolidateRows() {
		SortedSet<Integer> deletes = new TreeSet<Integer>();
		for (int i = 0; i < rows.size(); i++) {
			if (deletes.contains(i))
				continue;
			for (int j = i + 1; j < rows.size(); j++) {
				if (rows.get(i).equals(rows.get(j))) {
					rows.get(i).quantity++;
					rows.get(i).refDes = rows.get(i).refDes + "; " + rows.get(j).refDes;
					deletes.add(j);
				}
			}
		}
		int i = 0;
		for (Integer d : deletes) {
			rows.remove(d - i);
			i++;
		}
	}

	private void generate() {
		populateHeaders();
		initializeRows(design);
		consolidateRows();
	}

	private void generateString() {
		StringBuilder sb = new StringBuilder();
		sb.append("QUANTITY, NAME, REFDES, LIBRARY, PACKAGE");
		for (int i = 0; i < headers.size(); i++) {
			sb.append(", " + headers.get(i));
		}
		for (Row r : rows) {
			sb.append("\n" + r.quantity + ", " + r.name + ", " + r.refDes + ", " + r.lib + ", " + r.pkg);
			for (int i = 0; i < r.entries.size(); i++) {
				sb.append(", " + r.entries.get(i));
			}
		}
		bom = sb.toString();
	}

	/**
	 * Returns the generated string representation of the Bill of Materials.
	 * 
	 * @return comma-separated string representation of BoM
	 */

	public String getBoMString() {
		return bom;
	}

	private void initializeRows(HierarchyUnit des) {
		for (Instance i : des.getInstances()) {
			Row newRow = new Row();

			for (int j = 0; j < headers.size(); j++) {
				newRow.entries.add("");
			}

			newRow.name = i.getDevice().getName();
			newRow.refDes = i.getRefDes();
			for (Attribute a : i.getAttributes()) {
				if (a.getName().equals("PACKAGE")) {
					newRow.pkg = a.getValue();
				} else if (a.getName().equals("LIBRARY")) {
					newRow.lib = a.getValue();
				} else if (!a.getName().equals("REFPREFIX") && !a.getName().equals("REFDES")) {
					for (int j = 0; j < headers.size(); j++) {
						if (headers.get(j).equals(a.getName())) {
							newRow.entries.set(j, a.getValue());
						}
					}
				}
			}
			rows.add(newRow);
		}
		
		for (SubInstance s : des.getSubInstances()) {
			initializeRows(s);
		}
	}

	/**
	 * Produces a .bom file which contains the comma-separated table of
	 * attributes.
	 * 
	 * @param fileName
	 *            the file name to output the data
	 */
	public void outputToFile(String fileName) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
			out.write(bom);
			out.close();
		} catch (IOException e) {
			System.err.println("File Writing Error - " + fileName + "\n" + "\tPossible Reasons:\n"
				+ "\t\t*filename may be corrupt\n" + "\t\t*file may currently be open\n");
			System.exit(1);
		}
		System.out.println("  -- Generated: \\" + fileName);
	}

	private void populateHeaders() {
		excludes = new ArrayList<String>();
		excludes.add("REFPREFIX");
		excludes.add("REFDES");
		excludes.add("PACKAGE");
		excludes.add("LIBRARY");

		populateHeaders(design);
	}
	
	private void populateHeaders(HierarchyUnit des) {
		for (Instance i : des.getInstances()) {
			for (Attribute a : i.getAttributes()) {
				if (!excludes.contains(a.getName()) && !headers.contains(a.getName())) {
					headers.add(a.getName());
				}
			}
		}
		for (SubInstance s : des.getSubInstances()) {
			populateHeaders(s);
		}
	}
	
	public static boolean unitTest() {
		{
			Design des = new Design();
			Device dev1 = new Device("Dev1");
			Device dev2 = new Device("Dev2");
			Device dev3 = new Device("Dev3");
			Device dev4 = new Device("Dev4");
			Device dev5 = new Device("Dev5");
			
			des.setName("test1"); {
				Instance inst1 = new Instance(des);
				inst1.setName("inst1");
				inst1.setRefDes("R1");
				inst1.addAttribute(new Attribute(inst1, "RefDes", "R1"));
				inst1.addAttribute(new Attribute(inst1, "Package", "pkg1"));
				inst1.addAttribute(new Attribute(inst1, "Library", "lib1"));
				inst1.addAttribute(new Attribute(inst1, "Value", "Bob"));
				inst1.setDevice(dev1);
				
				Instance inst2 = new Instance(des);
				inst2.setName("inst2");
				inst2.setRefDes("R2");
				inst2.addAttribute(new Attribute(inst2, "Package", "pkg1"));
				inst2.addAttribute(new Attribute(inst2, "Library", "lib1"));
				inst2.addAttribute(new Attribute(inst2, "Value", "Jim"));
				inst2.setDevice(dev1);
				
				Instance inst3 = new Instance(des);
				inst3.setName("inst3");
				inst3.setRefDes("C1");
				inst3.addAttribute(new Attribute(inst3, "Package", "pkg2"));
				inst3.addAttribute(new Attribute(inst3, "Library", "lib1"));
				inst3.addAttribute(new Attribute(inst3, "Value", "Kay"));
				inst3.setDevice(dev2);
				
				des.addInstance(inst1);
				des.addInstance(inst2);
				des.addInstance(inst3);
			}
			
			SubDesign subDes1 = new SubDesign();
			subDes1.setName("subDes1");
			
			SubDesign subDes2 = new SubDesign();
			subDes2.setName("subDes2");
			
			SubInstance subInst1 = new SubInstance(des, "subInst1"); {
				subInst1.setDesign(subDes1);
				
				Instance inst2 = new Instance(subInst1);
				inst2.setName("inst2");
				inst2.setRefDes("K2");
				inst2.addAttribute(new Attribute(inst2, "Package", "pkg3"));
				inst2.addAttribute(new Attribute(inst2, "Library", "lib1"));
				inst2.addAttribute(new Attribute(inst2, "Super", "Fred"));
				inst2.addAttribute(new Attribute(inst2, "Home", "Iowa"));
				inst2.setDevice(dev3);
				
				Instance inst3 = new Instance(subInst1);
				inst3.setName("inst3");
				inst3.setRefDes("K2");
				inst3.addAttribute(new Attribute(inst3, "Package", "pkg4"));
				inst3.addAttribute(new Attribute(inst3, "Library", "lib2"));
				inst3.addAttribute(new Attribute(inst3, "sUpEr", "Suzy"));
				inst3.addAttribute(new Attribute(inst3, "Home", "Georgia"));
				inst3.addAttribute(new Attribute(inst3, "Song", "L-O-V-E"));
				inst3.setDevice(dev3);
				
				Instance inst1 = new Instance(subInst1);
				inst1.setName("inst1");
				inst1.setRefDes("J5");
				inst1.addAttribute(new Attribute(inst1, "Package", "pkg4"));
				inst1.addAttribute(new Attribute(inst1, "Library", "lib2"));
				inst1.addAttribute(new Attribute(inst1, "vAlUE", "Sam"));
				inst1.setDevice(dev2);
				
				subInst1.addInstance(inst2);
				subInst1.addInstance(inst3);
				subInst1.addInstance(inst1);
			}
			
			des.addSubInst(subInst1);
			
			SubInstance subInst2_1 = new SubInstance(des, "subInst2_1"); {
				subInst2_1.setDesign(subDes2);
				Instance[] inst1 = new Instance[5];
				for (int i = 0; i < 5; i++) {
					inst1[i] = new Instance(subInst2_1); {
						inst1[i].setName("inst1");
						inst1[i].setRefDes("A1_" + (i+1));
						inst1[i].setIndex(i+1);
						inst1[i].addAttribute(new Attribute(inst1[i], "Package", "pkg2"));
						inst1[i].addAttribute(new Attribute(inst1[i], "Library", "lib3"));
						inst1[i].addAttribute(new Attribute(inst1[i], "Store", "Shopko"));
						inst1[i].setDevice(dev4);
					}
					subInst2_1.addInstance(inst1[i]);
				}
				
				Instance inst2 = new Instance(subInst2_1); {
					inst2.setName("inst2");
					inst2.setRefDes("B1_7");
					inst2.addAttribute(new Attribute(inst2, "Package", "pkg1"));
					inst2.addAttribute(new Attribute(inst2, "liBRary", "lib3"));
					inst2.addAttribute(new Attribute(inst2, "Super", "HKN"));
					inst2.setDevice(dev5);
				}
				subInst2_1.addInstance(inst2);
			}
			
			des.addSubInst(subInst2_1);
			
			SubInstance subInst2_2 = new SubInstance(des, "subInst2_2"); {
				subInst2_2.setDesign(subDes2);
				Instance[] inst1 = new Instance[5];
				for (int i = 0; i < 5; i++) {
					inst1[i] = new Instance(subInst2_2); {
						inst1[i].setName("inst1");
						inst1[i].setRefDes("A2_" + (i+1));
						inst1[i].setIndex(i+1);
						inst1[i].addAttribute(new Attribute(inst1[i], "Package", "pkg2"));
						inst1[i].addAttribute(new Attribute(inst1[i], "Library", "lib3"));
						inst1[i].addAttribute(new Attribute(inst1[i], "Store", "Shopko"));
						inst1[i].setDevice(dev4);
					}
					subInst2_2.addInstance(inst1[i]);
				}
				
				Instance inst2 = new Instance(subInst2_2); {
					inst2.setName("inst2");
					inst2.setRefDes("B2_7");
					inst2.addAttribute(new Attribute(inst2, "Package", "pkg1"));
					inst2.addAttribute(new Attribute(inst2, "liBRary", "lib3"));
					inst2.addAttribute(new Attribute(inst2, "Super", "HKN"));
					inst2.setDevice(dev5);
				}
				subInst2_2.addInstance(inst2);
			}
			des.addSubInst(subInst2_2);
			BoMGenerator bomgen = new BoMGenerator(des);
			bomgen.outputToFile("TestsOutput/BoMOutput/" + des.getName() + ".csv");
		}
		return true;
	}

}



