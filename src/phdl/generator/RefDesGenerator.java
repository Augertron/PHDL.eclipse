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

package phdl.generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import phdl.graph.DesignNode;
import phdl.graph.InstanceNode;

/**
 * A class that generates a Reference Designator mapping and
 * file.
 * 
 * @author Brad Riching and Richard Black
 * @version 0.1
 * 
 */
public class RefDesGenerator {

	private Map<String, InstanceNode> refMap = new TreeMap<String, InstanceNode>();
	private DesignNode design;

	/**
	 * Default Constructor.
	 * 
	 * Takes a DesignNode and generates the Reference Designator mapping.
	 * 
	 * @param design the DesignNode that contains the InstanceNode
	 * 			information.
	 * 
	 * @see DesignNode
	 */
	public RefDesGenerator(DesignNode design) {
		this.design = design;
		generate();
	}

	private void generate() {

		Set<InstanceNode> needsRefDes = new TreeSet<InstanceNode>();
		for (InstanceNode i : design.getInstances()) {
			if (i.getRefDes() != null && !i.getRefDes().equals("")) {
				refMap.put(i.getRefDes(), i);
			} else {
				// collect the instances that need a refDes assigned
				needsRefDes.add(i);
			}
		}
		// generate refDes's for those that need it
		for (InstanceNode i : needsRefDes) {

			String refprefix = i.getRefPrefix();
			int j = 1;
			while (refMap.containsKey(refprefix + j)) {
				j++;
			}
			String refDes = refprefix + j;
			refMap.put(refDes, i);
			i.setRefDes(refDes);
		}
	}

	/**
	 * Returns the RefDes mapping.
	 * 
	 * @return a map with RefDes as the key and InstanceNode as
	 * 			the value
	 * @see InstanceNode
	 * 
	 */
	public Map<String, InstanceNode> getRefMap() {
		return refMap;
	}

	/**
	 * Generates a .csv file containing all the Reference
	 * Designator mappings.
	 * 
	 * @param fileName the name of the file to be written
	 */
	public void outputToFile(String fileName) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
			out.write(toString());
			out.close();
		} catch (IOException e) {
			System.err.println("File Reading Error - filename may be corrupt");
			System.exit(1);
		}
	}

	@Override
	public String toString() {
		String myString = "";
		Set<String> refs = refMap.keySet();
		for (String s : refs) {
			myString += refMap.get(s).getRefDes();
			myString += ",";
			myString += refMap.get(s).getName();
			myString += "\n";
		}
		return myString;
	}
}