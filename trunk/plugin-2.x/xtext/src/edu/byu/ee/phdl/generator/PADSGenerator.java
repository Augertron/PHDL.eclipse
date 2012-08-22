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

import java.util.List;
import java.util.Map;

import edu.byu.ee.phdl.elaboration.EConnection;
import edu.byu.ee.phdl.elaboration.EDesign;
import edu.byu.ee.phdl.elaboration.EInstance;
import edu.byu.ee.phdl.elaboration.EPin;

/**
 * A class that generates a NetList (.asc) for use in PADS.
 * 
 * @author Brad Riching and Richard Black
 * @version 0.1
 */
public class PADSGenerator {

	private final EDesign design;
	private final Map<String, EInstance> refMap;
	private String contents;

	public PADSGenerator(EDesign design) {
		this.design = design;
		this.refMap = design.getRefMap();
		generate();
	}

	private void generate() {
		StringBuilder sb = new StringBuilder();
		sb.append(generateHeader() + "\n\n");
		sb.append(generateParts() + "\n");
		sb.append(generateConnections());
		sb.append("\n*END*\n");
		contents = sb.toString();
	}

	private String generateConnectionHeader(EConnection n) {
		StringBuilder sb = new StringBuilder();
		sb.append("*SIGNAL* ");
		sb.append(n.getHierarchyName());
		sb.append("\n");
		return sb.toString();
	}

	private String generateConnections() {
		StringBuilder connections = new StringBuilder();
		connections.append("*CONNECTION*\n");

		for (EConnection n : design.getNetlist()) {
			connections.append(generateConnectionHeader(n));
			connections.append(generatePinList(n));
		}
		return connections.toString();
	}

	private String generateHeader() {
		StringBuilder header = new StringBuilder();
		header.append("!PADS-POWERPCB-V9.0-MILS! NETLIST FILE FROM PADS LOGIC V9.3");
		return header.toString();
	}

	private String generateParts() {
		StringBuilder devices = new StringBuilder();
		devices.append("*PART*\n");
		for (String s : refMap.keySet()) {
			EInstance i = refMap.get(s);
			devices.append(s);
			devices.append(" ");
			devices.append(i.getLibrary());
			devices.append("@");
			devices.append(i.getFootprint());
			devices.append("\n");
		}
		return devices.toString();
	}

	private String generatePinList(EConnection c) {
		StringBuilder sb = new StringBuilder();
		List<EPin> pins = c.getPins();
		if (pins != null) {
			for (int i = 0; i < pins.size() - 1; i++) {
				// PADS netlists are staggered in pairs, like line-segments
				EPin pin1 = pins.get(i);
				EPin pin2 = pins.get(i + 1);

				String ref1 = ((EInstance) pin1.getParent()).getRefDes();
				String ref2 = ((EInstance) pin2.getParent()).getRefDes();

				sb.append(" ");
				sb.append(ref1);
				sb.append(".");
				sb.append(pin1.getPinMapping());
				sb.append(" ");
				sb.append(ref2);
				sb.append(".");
				sb.append(pin2.getPinMapping());
				sb.append("\n");
			}
		}
		return sb.toString();
	}

	public String getContents() {
		return contents;
	}
}
