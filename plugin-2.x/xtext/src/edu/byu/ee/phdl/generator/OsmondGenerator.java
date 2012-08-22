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

public class OsmondGenerator {

	private final EDesign design;
	private final Map<String, EInstance> refMap;
	private String contents;

	public OsmondGenerator(EDesign design) {
		this.design = design;
		this.refMap = design.getRefMap();
		generate();
	}

	private void generate() {
		StringBuilder sb = new StringBuilder();
		sb.append(generateParts() + "\n");
		sb.append(generateConnections());
		contents = sb.toString();
	}

	private String generateConnectionHeader(EConnection n) {
		StringBuilder sb = new StringBuilder();
		sb.append("Signal \"" + n.getHierarchyName().toUpperCase() + "\"\n");
		return sb.toString();
	}

	private String generateConnections() {
		StringBuilder connections = new StringBuilder();
		for (EConnection n : design.getNetlist()) {
			connections.append(generateConnectionHeader(n));
			connections.append(generatePinList(n));
		}
		return connections.toString();
	}

	private String generateParts() {
		StringBuilder parts = new StringBuilder();
		for (String s : refMap.keySet()) {
			EInstance i = refMap.get(s);
			parts.append("Part " + i.getFootprint() + " { Name \"");
			parts.append(s + "\" }\n");
		}
		return parts.toString();
	}

	private String generatePinList(EConnection c) {
		StringBuilder sb = new StringBuilder();
		List<EPin> pins = c.getPins();
		if (pins != null) {
			sb.append("{ ");
			for (EPin pin : pins) {
				sb.append(((EInstance) pin.getParent()).getRefDes() + "-" + pin.getPinMapping() + " ");
			}
			sb.append("}\n");
		}
		return sb.toString();
	}

	public String getContents() {
		return contents;
	}
}
