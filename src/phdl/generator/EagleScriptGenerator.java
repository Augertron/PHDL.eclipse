package phdl.generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import phdl.graph.DesignNode;
import phdl.graph.InstanceNode;
import phdl.graph.NetNode;
import phdl.graph.PinNode;

public class EagleScriptGenerator {
	private DesignNode design;
	private Map<String, InstanceNode> refMap;
	private String contents;
	private TreeMap<String, ArrayList<InstanceNode>> groupMap;

	/**
	 * Default constructor.
	 * 
	 * Takes a design and a map of the reference designators and generates the Eagle script.
	 * 
	 * @param design
	 *            the DesignNode where all the net information is stored.
	 * @param refMap
	 *            the map of Reference Designators needed to generated the Eagle script.
	 * 
	 * @see DesignNode
	 * @see RefDesGenerator
	 */
	public EagleScriptGenerator(DesignNode design, Map<String, InstanceNode> refMap) {
		this.design = design;
		this.refMap = refMap;
		this.groupMap = new TreeMap<String, ArrayList<InstanceNode>>();
		generate();
	}

	private void generate() {

		for (InstanceNode i : design.getInstances()) {
			if (i.getGroupName() != null) {
				if (groupMap.containsKey(i.getGroupName())) {
					groupMap.get(i.getGroupName()).add(i);
				} else {
					ArrayList<InstanceNode> l = new ArrayList<InstanceNode>();
					l.add(i);
					groupMap.put(i.getGroupName(), l);
				}
			} else {
				if (groupMap.containsKey("")) {
					groupMap.get("").add(i);
				} else {
					ArrayList<InstanceNode> l = new ArrayList<InstanceNode>();
					l.add(i);
					groupMap.put("", l);
				}
			}
		}

		float x = 0;
		float y = 0;
		StringBuilder sb = new StringBuilder();

		sb.append("# Auto Generated EAGLE PCB script from: " + design.getFileName() + "\n\n");
		sb.append("SET UNDO_LOG OFF;\n");
		sb.append("GRID INCH\n");
		sb.append("CHANGE LAYER tValues\n");
		sb.append("CHANGE SIZE 0.25\n\n");
		sb.append("# Added parts #\n\n");

		for (String g : groupMap.keySet()) {
			sb.append("TEXT '" + g + "' (" + -4 + " " + y + ");\n");
			ArrayList<InstanceNode> group = groupMap.get(g);
			String values = "";
			for (InstanceNode i : group) {
				String eagleLib = "";
				if (i.getAttribute("libName") != null)
					eagleLib = i.getAttribute("libName").getValue();
				else
					System.out.println("ERROR: libName attribute undeclared: " + i.getName());
				sb.append("ADD " + i.getFootprint() + "@" + eagleLib + " '" + i.getRefDes() + "' ("
					+ x + " " + y + ");\n");
				x += 0.5;
				values += i.getRefDes() + " '" + i.getName() + "' ";
			}
			x = 0;
			y += 1;
			sb.append("VALUE " + values + ";\n");
		}

		sb.append("\n# SIGNALS #\n\n");

		// assign all the nets
		for (NetNode n : design.getNets()) {

			// ignore the open net
			if (n.getName().equals("open"))
				continue;

			sb.append("SIGNAL " + n.getName().toUpperCase() + " ");
			for (PinNode p : n.getPinNodes()) {
				sb.append(refMap.get(((InstanceNode) p.getParent()).getRefDes()).getRefDes() + " "
					+ p.getPinName() + " ");
			}
			sb.append("\n");
		}
		sb.append("\nSET UNDO_LOG ON;\nRATSNEST;\n\n # End Script #\n");

		contents = sb.toString();
	}

	/**
	 * Returns the eagleScript string.
	 * 
	 * @return a string representation of the eagleScript
	 */
	public String getContents() {
		return contents;
	}

	/**
	 * Generates an .asc file representation of the eagleScript.
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
		System.out.println("Wrote Eagle script file: " + fileName);
	}

}
