package phdl.generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import phdl.graph.Connection;
import phdl.graph.Design;
import phdl.graph.HierarchyUnit;
import phdl.graph.Instance;
import phdl.graph.Net;
import phdl.graph.Pin;
import phdl.graph.SubInstance;

public class EagleGenerator {

	// board grid constraints
	private final double xSpacing = 0.25;
	private final double ySpacing = 0.5;
	private final double xMax = 30;
	private final double yMax = 30;
	private double x;
	private double y;

	private final Design design;
	private final Map<String, Instance> refMap;
	private final Map<Net, List<Pin>> netlist;
	private String contents;

	public EagleGenerator(Design design, Map<String, Instance> refMap) {
		this.design = design;
		this.refMap = refMap;
		netlist = new TreeMap<Net, List<Pin>>();
		generate();
	}

	private void clear_visited(HierarchyUnit des) {
		des.clearVisited();
		for (SubInstance s : des.getSubInstances()) {
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
		for (Net n : netlist.keySet()) {
			connections.append("SIGNAL '" + n.getHierarchyName().toUpperCase() + "'");
			connections.append(generate_pin_list(n));
		}
		return connections.toString();
	}

	private String generate_parts() {
		StringBuilder devices = new StringBuilder();
		devices.append("# PARTS #\n");
		for (String s : refMap.keySet()) {
			Instance i = refMap.get(s);
			devices.append("ADD " + i.getPackage() + "@" + i.getLibrary().toUpperCase() + " '" + s + "' (" + getX()
				+ " " + getY() + ");\n");
		}
		return devices.toString();
	}

	private String generate_pin_list(Net n) {
		StringBuilder sb = new StringBuilder();
		List<Pin> pins = netlist.get(n);

		for (Pin p : netlist.get(n))
			sb.append(" " + ((Instance) p.getParent()).getRefDes() + " " + p.getPinMapping());

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
		System.out.println("  -- Generated: " + DirectoryCodes.SEPARATOR + fileName);
	}

	private void retrieve_netlist(HierarchyUnit des) {
		for (Net n : des.getNets()) {
			List<Pin> single_netlist = retrieve_pins(n);
			if (single_netlist != null && !single_netlist.isEmpty()) {
				netlist.put(n, single_netlist);
			}
		}
		for (SubInstance s : des.getSubInstances()) {
			retrieve_netlist(s);
		}
	}

	private List<Pin> retrieve_pins(Connection c) {
		List<Pin> pinlist = new ArrayList<Pin>();
		if (!c.isVisited()) {
			pinlist.addAll(c.getPins());
			c.setVisited(true);
			for (Connection next : c.getConnections()) {
				pinlist.addAll(retrieve_pins(next));
			}
		}
		return pinlist;
	}
}
