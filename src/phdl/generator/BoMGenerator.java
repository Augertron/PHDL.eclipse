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

import phdl.graph.AttributeNode;
import phdl.graph.DesignNode;
import phdl.graph.InstanceNode;

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

	private DesignNode design;
	private List<Row> rows;
	private List<String> headers;
	private String bom;

	private class Row {
		private int quantity;
		private String name;
		private String refDes;
		private String pkg_type;
		private List<String> entries;

		public Row() {
			quantity = 1;
			name = "";
			refDes = "";
			pkg_type = "";
			entries = new ArrayList<String>();
		}

		@Override
		public boolean equals(Object o) {
			Row r = (Row) o;
			boolean equal;
			equal = name.equals(r.name);
			equal &= pkg_type.equals(pkg_type);
			for (String s : entries) {
				equal &= r.entries.contains(s);
			}
			for (String s : r.entries) {
				equal &= entries.contains(s);
			}
			return equal;
		}
	}

	/**
	 * Default Constructor.
	 * 
	 * Takes a DesignNode, generates the table of attributes, and creates a
	 * string representation of the table.
	 * 
	 * @param design
	 *            the DesignNode that contains all of the attribute information.
	 * @see DesignNode
	 */
	public BoMGenerator(DesignNode d) {
		design = d;
		rows = new ArrayList<Row>();
		headers = new ArrayList<String>();
		generate();
		generateString();
	}

	private void generate() {
		populateHeaders();
		initializeRows();
		consolidateRows();
	}

	private void populateHeaders() {
		List<String> excludes = new ArrayList<String>();
		excludes.add("REFPREFIX");
		excludes.add("REFDES");
		excludes.add("PKG_TYPE");

		for (InstanceNode i : design.getInstances()) {
			for (AttributeNode a : i.getAttributes()) {
				if (!excludes.contains(a.getName())
						&& !headers.contains(a.getName())) {
					headers.add(a.getName());
				}
			}
		}
	}

	private void initializeRows() {
		for (InstanceNode i : design.getInstances()) {
			Row newRow = new Row();

			for (int j = 0; j < headers.size(); j++) {
				newRow.entries.add("");
			}

			newRow.name = i.getDevice().getName();
			newRow.refDes = i.getRefDes();
			for (AttributeNode a : i.getAttributes()) {
				if (a.getName().equals("PKG_TYPE")) {
					newRow.pkg_type = a.getValue();
				} else if (!a.getName().equals("REFPREFIX")
						&& !a.getName().equals("REFDES")) {
					for (int j = 0; j < headers.size(); j++) {
						if (headers.get(j).equals(a.getName())) {
							newRow.entries.set(j, a.getValue());
						}
					}
				}
			}
			rows.add(newRow);
		}
	}

	private void consolidateRows() {
		SortedSet<Integer> deletes = new TreeSet<Integer>();
		for (int i = 0; i < rows.size(); i++) {
			if (deletes.contains(i))
				continue;
			for (int j = i + 1; j < rows.size(); j++) {
				if (rows.get(i).equals(rows.get(j))) {
					rows.get(i).quantity++;
					rows.get(i).refDes = rows.get(i).refDes + "; "
							+ rows.get(j).refDes;
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

	private void generateString() {
		StringBuilder sb = new StringBuilder();
		// sb.append("Bill of Materials - " + design.getName() + "\n");
		sb.append("QUANTITY, NAME, REFDES, PKG_TYPE");
		for (int i = 0; i < headers.size(); i++) {
			sb.append(", " + headers.get(i));
		}
		for (Row r : rows) {
			sb.append("\n" + r.quantity + ", " + r.name + ", " + r.refDes
					+ ", " + r.pkg_type);
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
			System.err.println("File Writing Error - " + fileName + "\n"
					+ "\tPossible Reasons:\n"
					+ "\t\t*filename may be corrupt\n"
					+ "\t\t*file may currently be open\n");
			System.exit(1);
		}
		System.out.println("Wrote BoM file: " + fileName);
	}

}
