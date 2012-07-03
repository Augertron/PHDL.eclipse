package edu.byu.ee.phdl.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import edu.byu.ee.phdl.elaboration.ElaboratedConnection;
import edu.byu.ee.phdl.elaboration.ElaboratedDesign;
import edu.byu.ee.phdl.elaboration.ElaboratedHierarchyUnit;
import edu.byu.ee.phdl.elaboration.ElaboratedInstance;
import edu.byu.ee.phdl.elaboration.ElaboratedNet;
import edu.byu.ee.phdl.elaboration.ElaboratedPin;
import edu.byu.ee.phdl.elaboration.ElaboratedSubInstance;

public class EagleGenerator {

	// board grid constraints
	private final double xSpacing = 0.25;
	private final double ySpacing = 0.5;
	private final double xMax = 30;
	private final double yMax = 30;
	private double x;
	private double y;

	private final ElaboratedDesign design;
	private final Map<String, ElaboratedInstance> refMap;
	private final Map<ElaboratedNet, List<ElaboratedPin>> netlist;
	private String contents;

	public EagleGenerator(ElaboratedDesign design, Map<String, ElaboratedInstance> refMap) {
		this.design = design;
		this.refMap = refMap;
		netlist = new TreeMap<ElaboratedNet, List<ElaboratedPin>>();
		generate();
	}

	private void clear_visited(ElaboratedHierarchyUnit des) {
		des.clearVisited();
		for (ElaboratedSubInstance s : des.getSubInstances()) {
			clear_visited(s);
		}
	}

	private void generate() {
		StringBuilder sb = new StringBuilder();
		clear_visited(design);

		sb.append(generateHeader() + "\n");
		sb.append(generate_parts() + "\n");
		sb.append(generate_connections());

		contents = sb.toString();
	}

	private String generate_connections() {
		StringBuilder connections = new StringBuilder();
		connections.append("# SIGNALS #\n");

		retrieve_netlist(design);
		for (ElaboratedNet n : netlist.keySet()) {
			connections.append("SIGNAL '" + n.getHierarchyName().toUpperCase() + "'");
			connections.append(generate_pin_list(n));
		}
		return connections.toString();
	}

	private String generate_parts() {
		StringBuilder devices = new StringBuilder();
		devices.append("# PARTS #\n");
		for (String s : refMap.keySet()) {
			ElaboratedInstance i = refMap.get(s);
			devices.append("ADD " + i.getFootprint() + "@" + i.getLibrary() + " '" + s + "' (" + getX() + " " + getY()
				+ ");\n");
		}
		return devices.toString();
	}

	private String generate_pin_list(ElaboratedNet n) {
		StringBuilder sb = new StringBuilder();
		List<ElaboratedPin> pins = netlist.get(n);

		for (ElaboratedPin p : netlist.get(n))
			sb.append(" " + ((ElaboratedInstance) p.getParent()).getRefDes() + " " + p.getPinMapping());

		sb.append(";\n");
		return sb.toString();
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

	public void outputToFile(String fileName) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
			out.write(contents);
			out.close();
		} catch (IOException e) {
			System.err.println("File Reading Error - filename may be corrupt");
			System.exit(1);
		}
		System.out.println("  -- Generated: " + File.separator + fileName);
	}

	private void retrieve_netlist(ElaboratedHierarchyUnit des) {
		for (ElaboratedNet n : des.getNets()) {
			List<ElaboratedPin> single_netlist = retrieve_pins(n);
			if (single_netlist != null && !single_netlist.isEmpty()) {
				netlist.put(n, single_netlist);
			}
		}
		for (ElaboratedSubInstance s : des.getSubInstances()) {
			retrieve_netlist(s);
		}
	}

	private List<ElaboratedPin> retrieve_pins(ElaboratedConnection c) {
		List<ElaboratedPin> pinlist = new ArrayList<ElaboratedPin>();
		if (!c.isVisited()) {
			pinlist.addAll(c.getPins());
			c.setVisited(true);
			for (ElaboratedConnection next : c.getConnections()) {
				pinlist.addAll(retrieve_pins(next));
			}
		}
		return pinlist;
	}
}
