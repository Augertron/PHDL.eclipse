/*
 * Copyright (C) 2011 Brigham Young University This program is free software: you can redistribute
 * it and/or modify it under the terms of the GNU General Public License as published by the Free
 * Software Foundation, version 3. This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received
 * a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package phdl.graph;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class that represents a design in PHDL.
 * 
 * @author Brad Riching and Richard Black
 * @version 0.1
 */
public class Design extends HierarchyUnit {

	private List<Net> nets;

	@Override
	/**
	 * Type accessor method.
	 * 
	 * @return NodeType.DESIGN
	 */
	public NodeType getNodeType() {
		return NodeType.DESIGN;
	}
	
	/**
	 * 
	 * @param newCon
	 * @return	true, if the connection wasn't already in the list and was added successfully
	 * 			false, otherwise
	 */
	@Override
	public boolean addConnection(Connection newCon) {
		if (!connections.contains(newCon) && newCon instanceof phdl.graph.Net) {
			return connections.add(newCon);
		}
		return false;
	}
	
	@Override
	public void setConnections(List<Connection> connections) {
		connections = new ArrayList<Connection>();
		for (Connection c : connections) {
			if (c instanceof phdl.graph.Net) {
				connections.add(c);
			}
		}
	}

	/**
	 * Generates a .dot file that represents the complete graph.
	 * 
	 * @param fileName
	 *            the name of the file being written
	 */
	public void dottyDump(String fileName) {
		BufferedWriter dotty = null;

		int netRef = 0;
		int pinRef = 0;
		Map<Integer, Net> netMap = new HashMap<Integer, Net>();
		Map<Integer, Pin> pinMap = new HashMap<Integer, Pin>();

		String format = "ordering=out;\r\n"
			+ "	ranksep=.4;\r\n"
			+ "	bgcolor=\"lightgrey\"; node [fixedsize=false, fontsize=12, fontname=\"Helvetica-bold\", fontcolor=\"blue\"\r\n"
			+ "		width=.25, height=.25, color=\"black\", fillcolor=\"white\", style=\"filled, solid, bold\"];\r\n"
			+ "	edge [arrowsize=.5, color=\"black\", style=\"bold\"]";

		try {
			dotty = new BufferedWriter(new FileWriter(fileName));
		} catch (IOException e) {
			System.out.println("Problem creating file: " + fileName);
			System.exit(1);
		}
		try {
			dotty.write("digraph {\n\n");
			dotty.write(format);

			for (Net n : nets) {
				dotty.write("  n" + netRef + " [label=\"" + n.getName() + "\"];\n");
				netMap.put(netRef, n);
				netRef++;
			}
			for (Instance i : instances) {
				for (Pin p : i.getPins()) {
					dotty.write("  p" + pinRef + " [label=\"" + i.getName() + "." + p.getName()
						+ "\"];\n");
					pinMap.put(pinRef, p);
					pinRef++;
				}
			}

			for (int k = 0; k < netMap.keySet().size(); k++) {
				for (Net n : netMap.get(k).getNetNodes()) {
					for (Integer i : netMap.keySet()) {
						if (netMap.get(i).getName().equals(n.getName())) {
							dotty.write("  n" + k + " -> " + "n" + i + ";\n");
						}
					}
				}
			}

			for (Integer i : pinMap.keySet()) {
				for (Integer j : netMap.keySet()) {
					Net n = pinMap.get(i).getNet();
					if (n != null) {
						if (netMap.get(j).getName().equals(n.getName())) {
							dotty.write("  p" + i + " -> " + "n" + j + ";\n");
						}
					}
				}
			}

			dotty.write("}\n");
			dotty.close();
		} catch (IOException e) {
			System.out.println("Prolem writing dotty file.");
			System.exit(1);
		}
		System.out.println("Wrote file: " + fileName);
	}

}
