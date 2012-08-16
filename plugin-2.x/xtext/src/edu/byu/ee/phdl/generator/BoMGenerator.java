/*
 * Copyright (C) 2011 Brigham Young University This program is free software: you can redistribute
 * it and/or modify it under the terms of the GNU General Public License as published by the Free
 * Software Foundation, version 3. This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received
 * a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package edu.byu.ee.phdl.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import edu.byu.ee.phdl.elaboration.EAttribute;
import edu.byu.ee.phdl.elaboration.EDesign;
import edu.byu.ee.phdl.elaboration.EHierarchyUnit;
import edu.byu.ee.phdl.elaboration.EInstance;
import edu.byu.ee.phdl.elaboration.ESubInstance;

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

	private final EDesign design;
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
	 * @see EDesign
	 */
	public BoMGenerator(EDesign d) {
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
		sb.append("QUANTITY, NAME, REFDES, LIBRARY, FOOTPRINT");
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

	public String getContents() {
		return bom;
	}

	private void initializeRows(EHierarchyUnit des) {
		for (EInstance i : des.getInstances()) {
			Row newRow = new Row();

			for (int j = 0; j < headers.size(); j++) {
				newRow.entries.add("");
			}

			newRow.name = i.getDevice().getName();
			newRow.refDes = i.getRefDes();
			for (EAttribute a : i.getAttributes()) {
				if (a.getName().equals("FOOTPRINT")) {
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

		for (ESubInstance s : des.getSubInstances()) {
			initializeRows(s);
		}
	}

	private void populateHeaders() {
		excludes = new ArrayList<String>();
		excludes.add("REFPREFIX");
		excludes.add("REFDES");
		excludes.add("FOOTPRINT");
		excludes.add("LIBRARY");

		populateHeaders(design);
	}

	private void populateHeaders(EHierarchyUnit des) {
		for (EInstance i : des.getInstances()) {
			for (EAttribute a : i.getAttributes()) {
				if (!excludes.contains(a.getName()) && !headers.contains(a.getName())) {
					headers.add(a.getName());
				}
			}
		}
		for (ESubInstance s : des.getSubInstances()) {
			populateHeaders(s);
		}
	}
}
