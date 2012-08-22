package edu.byu.ee.phdl.generator;

import java.util.List;
import java.util.Map;

import edu.byu.ee.phdl.elaboration.EConnection;
import edu.byu.ee.phdl.elaboration.EDesign;
import edu.byu.ee.phdl.elaboration.EHierarchyUnit;
import edu.byu.ee.phdl.elaboration.EInstance;
import edu.byu.ee.phdl.elaboration.EPin;
import edu.byu.ee.phdl.elaboration.ESubInstance;

public class EagleGenerator {

	// board grid constraints
	private final double xSpacing = 0.25;
	private final double ySpacing = 0.5;
	private final double xMax = 30;
	// private final double yMax = 30;
	private double x;
	private double y;

	private final EDesign design;
	private final Map<String, EInstance> refMap;
	private String contents;

	public EagleGenerator(EDesign design) {
		this.design = design;
		this.refMap = design.getRefMap();
		generate();
	}

	private void clear_visited(EHierarchyUnit des) {
		des.clearVisited();
		for (ESubInstance s : des.getSubInstances()) {
			clear_visited(s);
		}
	}

	private void generate() {
		StringBuilder sb = new StringBuilder();
		clear_visited(design);

		sb.append(generateHeader() + "\n");
		sb.append(generateParts() + "\n");
		sb.append(generateConnections());

		contents = sb.toString();
	}

	private String generateConnections() {
		StringBuilder connections = new StringBuilder();
		connections.append("# SIGNALS #\n");

		for (EConnection c : design.getNetlist()) {
			connections.append("SIGNAL '" + c.getHierarchyName() + "'");
			connections.append(generatePinList(c));
		}
		return connections.toString();
	}

	private String generateHeader() {
		StringBuilder header = new StringBuilder();
		header.append("# Auto-generated EAGLE PCB script from: " + design.getFileName() + "\n");
		header.append("SET UNDO_LOG OFF;\n");
		header.append("GRID INCH;\n");
		header.append("CHANGE DISPLAY OFF;\n");
		header.append("CHANGE SIZE 0.25;\n");
		return header.toString();
	}

	private String generateParts() {
		StringBuilder devices = new StringBuilder();
		devices.append("# PARTS #\n");
		for (String s : refMap.keySet()) {
			EInstance i = refMap.get(s);
			devices.append("ADD " + i.getFootprint() + "@" + i.getLibrary() + " '" + s + "' (" + getX() + " " + getY()
					+ ");\n");
		}
		return devices.toString();
	}

	private String generatePinList(EConnection c) {
		StringBuilder sb = new StringBuilder();
		List<EPin> pins = c.getPins();
		if (pins != null) {
			for (EPin p : pins)
				sb.append(" " + ((EInstance) p.getParent()).getRefDes() + " " + p.getPinMapping());
		}
		sb.append(";\n");
		return sb.toString();
	}

	public String getContents() {
		return contents;
	}

	private double getX() {
		x += xSpacing;
		if (x > xMax) {
			x = 0;
			y += ySpacing;
		}
		return x;
	}

	private double getY() {
		return y;
	}
}
