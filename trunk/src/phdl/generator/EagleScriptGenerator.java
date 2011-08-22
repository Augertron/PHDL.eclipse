package phdl.generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import phdl.graph.AttributeNode;
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
	private StringBuilder sb;
	private List<Node> signals;

	// board grid constraints
	private double xSpacing = 0.25;
	private double ySpacing = 0.5;
	private int xMax = 30;
	private int yMax = 30;

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
		this.sb = new StringBuilder();
		this.signals = new ArrayList<Node>();
		generate();
	}

	private void generate() {

		sb.append("# Auto-generated EAGLE PCB script from: " + design.getFileName() + "\n");
		sb.append("SET UNDO_LOG OFF;\n");
		sb.append("GRID INCH;\n");
		sb.append("CHANGE DISPLAY OFF;\n");
		sb.append("CHANGE SIZE 0.25;\n");

		// If the design has not been previously compiled, it is the initial
		// build.
		if (!xmlExists) {
			sb.append("# Initial Build.\n\n");
			// sort the instances into their groups
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

			// grid placement coordinates
			double x = 0;
			double y = 2;

			// place each group on its own line, each line at one inch
			// increments
			sb.append("# Added parts #\n\n");
			sb.append("CHANGE LAYER 20; #the layer that group text will appear\n");
			for (String g : groupMap.keySet()) {
				// generate a label for the group and place it 4 inches to the
				// left of each group
				sb.append("TEXT '" + g + "' (" + -4 + " " + y + ");\n");

				ArrayList<InstanceNode> group = groupMap.get(g);
				for (InstanceNode i : group) {

					addInstance(i, x, y);
					setValue(i);
					x += xSpacing;

					// set the special instance name and device name attributes
					sb.append("ATTRIBUTE " + i.getRefDes() + " INST_NAME '" + i.getName() + "';\n");
					sb.append("ATTRIBUTE " + i.getRefDes() + " DEV_NAME '"
						+ i.getDevice().getName() + "';\n");

					// add all the attributes except "values"
					for (AttributeNode a : i.getAttributes()) {
						if (!a.getName().equals("VALUE"))
							attribute(a);
					}

					// increment y and reset x if too close to edge board space
					if (x > xMax) {
						x = 0;
						y += ySpacing;
					}
				}
				// reset x for every group
				x = 0;

				// reset y if too close to edge of board space, otherwise
				// increment for every group
				if (y > yMax)
					y = 0;
				else
					y += ySpacing;
			}

			sb.append("\n# SIGNALS #\n\n");

			// assign all the nets
			for (NetNode n : design.getNets()) {

				// ignore the open net
				if (n.getName().equals("open"))
					continue;

				signal((NetNode) n);
			}
		} else {
			// the design has been previously compiled, and is an iterative or
			// successive build.
			sb.append("# Successive Build.\n\n");
			float y = -1;

			// Added Elements
			sb.append("# Added elements #\n\n");
			for (Node n : desComp.getAllAdditions()) {
				switch (n.getType()) {
				case INSTANCE:
					// add the instance and set its value
					addInstance((InstanceNode) n, 0, y);
					setValue((InstanceNode) n);

					// add all of it's attributes
					for (AttributeNode a : ((InstanceNode) n).getAttributes()) {
						// the value attribute is handled with the setValue
						// special case
						if (!a.getName().equals("VALUE"))
							attribute(a);
					}

					// connect all of its nets
					for (PinNode p : ((InstanceNode) n).getPins()) {
						String refDes = ((InstanceNode) p.getParent()).getRefDes();
						String name = p.getNet().getName().toUpperCase();
						sb.append("SIGNAL " + name + " " + refDes + " " + p.getPinName() + ";\n");
					}

					// keep adding instances below the origin
					y -= ySpacing;
					break;

				case NET:
					// ignore the open net
					if (n.getName().equals("OPEN"))
						continue;

					signal((NetNode) n);
					break;

				case ATTRIBUTE:
					if (n.getName().equals("VALUE"))
						setValue((InstanceNode) ((AttributeNode) n).getParent());
					else
						attribute((AttributeNode) n);

				case PIN:
					break;

				default:
					break;
				}
				sb.append("\n");
			}

			// Modified Elements
			sb.append("\n# Modified elements #\n\n");

			List<Node> news = desComp.getAllModifyNews();
			List<Node> olds = desComp.getAllModifyOlds();
			for (int i = 0; i < news.size(); i++) {
				switch (news.get(i).getType()) {
				case ATTRIBUTE:
					if (news.get(i).getName().equals("VALUE"))
						setValue((InstanceNode) ((AttributeNode) news.get(i)).getParent());
					else if (news.get(i).getName().equals("PKG_TYPE"))
						replacePackage((AttributeNode) news.get(i));
					else
						attribute((AttributeNode) news.get(i));
					break;

				case PIN:
					// rip-up and ratsnest the signal the old pin was attached to
					// sb.append("RIPUP " + ((PinNode) olds.get(i)).getNet().getName() + ";\n");
					sb.append("RATSNEST;\n");
					// delete the signal from all pins on using a custom EAGLE ULP
					// sb.append("RUN del-signal " + ((PinNode) olds.get(i)).getNet().getName()
					// + ";\n");
					// store the signal to add after processing all removes
					signals.add(news.get(i));
					break;
				default:
					break;
				}
			}
			for (Node n : signals) {
				signal(((PinNode) n).getNet());
			}

			// Deleted Elements
			sb.append("\n# Deleted elements #\n\n");
			for (Node n : desComp.getAllRemovals()) {
				switch (n.getType()) {
				case INSTANCE:
					delete((InstanceNode) n);

					break;
				default:
					break;
				}
				sb.append("\n");
			}
		}
		sb.append("SET UNDO_LOG ON;\n");
		sb.append("RATSNEST;\n\n");
		sb.append("# End Script #\n");
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

	private void setValue(InstanceNode i) {
		AttributeNode a = i.getAttribute("VALUE");
		if (a != null) {
			sb.append("VALUE " + i.getRefDes() + " " + a.getValue() + ";\n");
		}
	}

	private void addInstance(InstanceNode i, double x, double y) {
		// find the instance's library attribute
		String lib = "";
		if (i.getAttribute("LIBNAME") != null) {
			lib = i.getAttribute("LIBNAME").getValue();
			sb.append("ADD " + i.getFootprint() + "@" + lib + " '" + i.getRefDes() + "' (" + x
				+ " " + y + ");\n");
		} else
			System.err.println("ERROR: libName attribute undeclared: " + i.getName());

	}

	private void attribute(AttributeNode a) {
		String refDes = ((InstanceNode) ((AttributeNode) a).getParent()).getRefDes();
		sb.append("ATTRIBUTE " + refDes + " " + a.getName() + " '" + a.getValue() + "';\n");
	}

	private void delete(InstanceNode i) {
		sb.append("DELETE " + i.getRefDes() + ";\n");
	}

	private void signal(NetNode n) {
		sb.append("SIGNAL " + n.getName().toUpperCase());
		for (PinNode p : n.getPinNodes()) {
			String refDes = ((InstanceNode) p.getParent()).getRefDes();
			sb.append(" " + refDes + " " + p.getPinName());
		}
		sb.append(";\n");
	}

	private void replacePackage(AttributeNode a) {
		String refDes = ((InstanceNode) ((AttributeNode) a).getParent()).getRefDes();
		String lib = ((InstanceNode) ((AttributeNode) a).getParent()).getAttribute("LIBNAME")
			.getValue();
		sb.append("REPLACE " + refDes + " '" + a.getValue() + "@" + lib + "';\n");
	}
}
