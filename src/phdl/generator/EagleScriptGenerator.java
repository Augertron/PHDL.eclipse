package phdl.generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

import phdl.graph.DesignNode;
import phdl.graph.InstanceNode;
import phdl.graph.NetNode;
import phdl.graph.Node;
import phdl.graph.PinNode;

public class EagleScriptGenerator {
	private DesignNode design;
	private String contents;
	private TreeMap<String, ArrayList<InstanceNode>> groupMap;
	private DesignComparator desComp;
	private boolean xmlExists;

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
	public EagleScriptGenerator(DesignNode design, DesignComparator desComp, boolean xmlExists) {
		this.design = design;
		this.groupMap = new TreeMap<String, ArrayList<InstanceNode>>();
		this.desComp = desComp;
		this.xmlExists = xmlExists;
		generate();
	}

	private void generate() {

		if (!xmlExists) {
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

			sb.append("# Auto-generated EAGLE PCB script from: " + design.getFileName() + "\n");
			sb.append("# Initial build.\n\n");
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
						System.err.println("ERROR: libName attribute undeclared: " + i.getName());
					sb.append("ADD " + i.getFootprint() + "@" + eagleLib + " '" + i.getRefDes()
						+ "' (" + x + " " + y + ");\n");
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
					sb.append(((InstanceNode) p.getParent()).getRefDes() + " " + p.getPinName()
						+ " ");
				}
				sb.append("\n");
			}
			sb.append("\nSET UNDO_LOG ON;\nRATSNEST;\n\n# End Script #\n");
			contents = sb.toString();

		} else {
			float y = -1;
			StringBuilder sb = new StringBuilder();
			sb.append("# Auto Generated EAGLE PCB script from: " + design.getFileName() + "\n");
			sb.append("# Successive Build.");
			sb.append("SET UNDO_LOG OFF;\n\n");
			sb.append("# Added elements #\n\n");

			for (Node n : desComp.getAllAdditions()) {
				switch (n.getType()) {
				case INSTANCE:
					String eagleLib = "";
					if (((InstanceNode) n).getAttribute("libName") != null)
						eagleLib = ((InstanceNode) n).getAttribute("libName").getValue();
					else
						System.err.println("ERROR: libName attribute undeclared: " + n.getName());

					sb.append("ADD " + ((InstanceNode) n).getFootprint() + "@" + eagleLib + " '"
						+ ((InstanceNode) n).getRefDes() + "' (" + 0 + " " + y + ");\n");
					sb.append("VALUE " + ((InstanceNode) n).getRefDes() + " "
						+ ((InstanceNode) n).getName() + ";\n");

					for (PinNode p : ((InstanceNode) n).getPins())
						sb.append("SIGNAL " + p.getNet().getName().toUpperCase() + " "
							+ ((InstanceNode) p.getParent()).getRefDes() + " " + p.getPinName()
							+ ";\n");

					y -= 0.05;
					break;
				case NET:
					// ignore the open net
					if (n.getName().equals("open"))
						continue;

					sb.append("SIGNAL " + n.getName().toUpperCase() + " ");
					for (PinNode p : ((NetNode) n).getPinNodes()) {
						sb.append(((InstanceNode) p.getParent()).getRefDes() + " " + p.getPinName()
							+ " ");
					}
					sb.append("\n");
					break;

				default:
					break;
				}
				sb.append("\n");
			}

			sb.append("\n# Modified elements #\n\n");

			sb.append("\n# Removed elements #\n\n");
			sb.append("\nSET UNDO_LOG ON;\nRATSNEST;\n\n# End Script #\n");
			contents = sb.toString();
		}
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
