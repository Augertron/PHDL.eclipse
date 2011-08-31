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
import java.util.Map;

import phdl.graph.DesignNode;
import phdl.graph.InstanceNode;
import phdl.graph.NetNode;
import phdl.graph.PinNode;

/**
 * A class that generates a NetList (.asc) for use in PADS.
 * 
 * @author Brad Riching and Richard Black
 * @version 0.1
 */
public class NetListGenerator {

	private DesignNode design;
	private Map<String, InstanceNode> refMap;
	private String contents;

	/**
	 * Default constructor.
	 * 
	 * Takes a design and a map of the reference designators and generates the
	 * NetList.
	 * 
	 * @param design
	 *            the DesignNode where all the net information is stored.
	 * @param refMap
	 *            the map of Reference Designators needed to generated the
	 *            NetList.
	 * 
	 * @see DesignNode
	 * @see RefDesGenerator
	 */
	public NetListGenerator(DesignNode design, Map<String, InstanceNode> refMap) {
		this.design = design;
		this.refMap = refMap;
		generate();
	}

	private void generate() {
		StringBuilder sb = new StringBuilder();
		sb.append("!PADS-POWERPCB-V9.0-MILS! NETLIST FILE FROM PADS LOGIC V9.3 \n\n");
		sb.append("*PART*\n");

		for (String s : refMap.keySet()) {
			InstanceNode i = refMap.get(s);
			sb.append(s);
			sb.append(" " + i.getDevice().getName().toUpperCase() + "@"
					+ i.getFootprint() + "\n");
		}
		sb.append("*CONNECTION*\n");

		for (NetNode n : design.getNets()) {

			if (n.getName().equals("OPEN"))
				continue;

			sb.append("*SIGNAL* " + n.getName().toUpperCase() + "\n");

			for (int i = 0; i < n.getPinNodes().size() - 1; i++) {

				PinNode pin1 = n.getPinNodes().get(i);
				PinNode pin2 = n.getPinNodes().get(i + 1);

				String ref1 = ((InstanceNode) pin1.getParent()).getRefDes();
				String ref2 = ((InstanceNode) pin2.getParent()).getRefDes();
				String name1 = pin1.getPinName();
				String name2 = pin2.getPinName();

				sb.append(" " + refMap.get(ref1).getRefDes() + "." + name1);
				sb.append(" " + refMap.get(ref2).getRefDes() + "." + name2
						+ "\n");
			}
		}
		sb.append("\n*END*");
		contents = sb.toString();
	}

	/**
	 * Returns the NetList string.
	 * 
	 * @return a string representation of the NetList
	 */
	public String getContents() {
		return contents;
	}

	/**
	 * Generates an .asc file representation of the NetList.
	 * 
	 * @param fileName
	 *            the name of the file to write to
	 */
	public void outputToFile(String fileName) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
			out.write(contents);
			out.close();
		} catch (IOException e) {
			System.err.println("File Reading Error - filename may be corrupt");
			System.exit(1);
		}
		System.out.println("Wrote netlist file: " + design.getName() + ".asc");
	}

}
