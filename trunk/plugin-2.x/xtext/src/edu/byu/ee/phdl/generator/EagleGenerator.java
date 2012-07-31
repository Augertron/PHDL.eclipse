package edu.byu.ee.phdl.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import edu.byu.ee.phdl.elaboration.EConnection;
import edu.byu.ee.phdl.elaboration.EDesign;
import edu.byu.ee.phdl.elaboration.EHierarchyUnit;
import edu.byu.ee.phdl.elaboration.EInstance;
import edu.byu.ee.phdl.elaboration.ENet;
import edu.byu.ee.phdl.elaboration.EPin;
import edu.byu.ee.phdl.elaboration.ESubInstance;

public class EagleGenerator {

	// board grid constraints
	private final double xSpacing = 0.25;
	private final double ySpacing = 0.5;
	private final double xMax = 30;
	private final double yMax = 30;
	private double x;
	private double y;

	private final EDesign design;
	private final Map<String, EInstance> refMap;
	private final Map<ENet, List<EPin>> netlist;
	private String contents;

	public EagleGenerator(EDesign design, Map<String, EInstance> refMap) {
		this.design = design;
		this.refMap = refMap;
		netlist = new TreeMap<ENet, List<EPin>>();
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
		sb.append(generate_parts() + "\n");
		sb.append(generate_connections());

		contents = sb.toString();
	}

	private String generate_connections() {
		StringBuilder connections = new StringBuilder();
		connections.append("# SIGNALS #\n");

		retrieve_netlist(design);
		for (ENet n : netlist.keySet()) {
			connections.append("SIGNAL '" + n.getHierarchyName().toUpperCase() + "'");
			connections.append(generate_pin_list(n));
		}
		return connections.toString();
	}

	private String generate_parts() {
		StringBuilder devices = new StringBuilder();
		devices.append("# PARTS #\n");
		for (String s : refMap.keySet()) {
			EInstance i = refMap.get(s);
			devices.append("ADD " + i.getFootprint() + "@" + i.getLibrary() + " '" + s + "' (" + getX() + " " + getY()
				+ ");\n");
		}
		return devices.toString();
	}

	private String generate_pin_list(ENet n) {
		StringBuilder sb = new StringBuilder();
		List<EPin> pins = netlist.get(n);

		for (EPin p : netlist.get(n))
			sb.append(" " + ((EInstance) p.getParent()).getRefDes() + " " + p.getPinMapping());

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

	private void retrieve_netlist(EHierarchyUnit des) {
		for (ENet n : des.getNets()) {
			List<EPin> single_netlist = retrieve_pins(n);
			if (single_netlist != null && !single_netlist.isEmpty()) {
				netlist.put(n, single_netlist);
			}
		}
		for (ESubInstance s : des.getSubInstances()) {
			retrieve_netlist(s);
		}
	}

	private List<EPin> retrieve_pins(EConnection c) {
		List<EPin> pinlist = new ArrayList<EPin>();
		if (!c.isVisited()) {
			pinlist.addAll(c.getPins());
			c.setVisited(true);
			for (EConnection next : c.getConnections()) {
				pinlist.addAll(retrieve_pins(next));
			}
		}
		return pinlist;
	}
}
