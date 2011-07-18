/*
 * Copyright (C) 2011 BYU Configurable Computing Lab This program is free software: you can
 * redistribute it and/or modify it under the terms of the GNU General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or (at your option) any later
 * version. This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * PURPOSE. See the GNU General Public License for more details. You should have received a copy of
 * the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package phdl.generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import phdl.graph.AttributeNode;
import phdl.graph.DesignNode;
import phdl.graph.InstanceNode;

/**
 * Bill of Materials Generator.
 * 
 * This class takes a design and sorts all of its instances attributes into a readable comma-
 * seperated file.
 * 
 * @author Brad Riching and Richard Black
 * @version 0.1
 */
public class BoMGenerator {

	private DesignNode design;
	List<List<String>> database;
	private String bom;

	/**
	 * Default Constructor.
	 * 
	 * Takes a DesignNode, generates the table of attributes, and creates a string representation of
	 * the table.
	 * 
	 * @param design
	 *            the DesignNode that contains all of the attribute information.
	 * @see DesignNode
	 */
	public BoMGenerator(DesignNode design) {
		this.design = design;
		generate();
		generateString();
	}

	private void generate() {
		database = new ArrayList<List<String>>();

		List<String> headers = new ArrayList<String>();
		headers.add("Device Name");

		// Populate Headers
		for (InstanceNode i : design.getInstances()) {
			for (AttributeNode a : i.getAttributes()) {
				if (!headers.contains(a.getName())) {
					headers.add(a.getName());
				}
			}
		}

		database.add(headers);
		// Add devices
		for (InstanceNode i : design.getInstances()) {
			List<String> newRow = new ArrayList<String>();
			newRow.add(i.getDevice().getName());
			for (int j = 1; j < headers.size(); j++) {
				AttributeNode dummy = new AttributeNode(null);
				dummy.setName(headers.get(j));
				if (!i.getAttributes().contains(dummy)) {
					newRow.add("");
					continue;
				}
				for (AttributeNode a : i.getAttributes()) {
					if (a.getName().equals(headers.get(j))) {
						newRow.add(a.getValue());
						break;
					}
				}
			}
			database.add(newRow);
		}
	}

	private void generateString() {
		bom = "PHDL Generated Bill of Materials\n";
		for (int i = 0; i < database.size(); i++) {
			for (int j = 0; j < database.get(i).size(); j++) {
				bom += database.get(i).get(j);
				if (j + 1 != database.get(i).size()) {
					bom += ",";
				}
			}
			bom += "\n";
		}
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
	 * Produces a .bom file which contains the comma-separated table of attributes.
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
			System.err.println("File Reading Error - filename may be corrupt");
			System.exit(1);
		}
		System.out.println("Wrote BoM file: " + fileName);
	}

}
