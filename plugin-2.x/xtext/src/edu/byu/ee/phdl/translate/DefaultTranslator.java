package edu.byu.ee.phdl.translate;

import edu.byu.ee.phdl.netlist.PhdlNet;
import edu.byu.ee.phdl.netlist.PhdlNetlist;
import edu.byu.ee.phdl.netlist.PhdlPart;
import edu.byu.ee.phdl.netlist.PhdlPin;
import edu.byu.ee.phdl.utils.ExtensionCodes;

public class DefaultTranslator {

	private String fileExtension = ExtensionCodes.DEFAULT_EXT;

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String extension) {
		this.fileExtension = extension;
	}

	public String translate(PhdlNetlist netlist) {
		StringBuilder sb = new StringBuilder();
		sb.append(translateHeader());
		sb.append(translateParts(netlist));
		sb.append(translateNets(netlist));
		return sb.toString();
	}

	public String translateHeader() {
		String header = "/**** Generated from PHDL Translator (DefaultTranslator) ****/ \n";
		return header;
	}

	public String translateNet(PhdlNet net) {
		StringBuilder sb = new StringBuilder();
		sb.append("signal '" + net.getName() + "'\n  { ");
		for (PhdlPin pin : net.getPins()) {
			sb.append(pin.getPartName() + "." + pin.getPinName() + " ");
		}
		sb.append("}\n");
		return sb.toString();
	}

	public String translateNets(PhdlNetlist netlist) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n/**** Signals ****/\n");
		for (PhdlNet net : netlist.getNets()) {
			sb.append(translateNet(net));
		}
		return sb.toString();
	}

	public String translatePart(PhdlPart part) {
		return "part " + part.getName() + " {" + part.getFootprint() + ", " + part.getLibrary() + "}\n";
	}

	public String translateParts(PhdlNetlist netlist) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n/**** Parts ****/\n");
		for (PhdlPart part : netlist.getParts()) {
			sb.append(translatePart(part));
		}
		return sb.toString();
	}

}
