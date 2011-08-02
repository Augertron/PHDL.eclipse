package phdl.generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import phdl.graph.DesignNode;
import phdl.graph.InstanceNode;
import phdl.graph.NetNode;
import phdl.graph.PinNode;

public class EagleScriptGenerator {
	private DesignNode design;
	private Map<String, InstanceNode> refMap;
	private String contents;

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
		generate();
	}

	private void generate() {
		float x = 0;
		float y = 0;
		StringBuilder sb = new StringBuilder();

		sb.append("# Auto Generated EAGLE PCB script from: " + design.getFileName() + "\n\n");
		sb.append("SET UNDO_LOG OFF;\n\n");

		sb.append("# Added parts #\n\n");

		// place the parts in an arbitrary grid pattern on an empty board
		for (String refDes : refMap.keySet()) {
			InstanceNode i = refMap.get(refDes);
			String eagleLib = "";

			if (i.getAttribute("eagleLib") != null) {
				eagleLib = i.getAttribute("eagleLib").getValue();
			} else {
				System.out.println("ERROR: Eagle library attribute undeclared: " + i.getName());
			}

			sb.append("ADD " + i.getFootprint() + "@" + eagleLib + " '" + refDes + "' (" + x + " "
				+ y + ");\n");
			x += 0.5;
			if (x > 10) {
				x = 0;
				y += 0.5;
			}
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
