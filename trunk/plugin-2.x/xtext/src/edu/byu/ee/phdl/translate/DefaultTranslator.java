package edu.byu.ee.phdl.translate;

import org.apache.log4j.Logger;

import edu.byu.ee.phdl.netlist.PhdlNet;
import edu.byu.ee.phdl.netlist.PhdlNetlist;
import edu.byu.ee.phdl.netlist.PhdlPart;
import edu.byu.ee.phdl.utils.ExtensionCodes;

public class DefaultTranslator {

	private final Logger logger = Logger.getLogger(DefaultTranslator.class);

	private String fileExtension = ExtensionCodes.DEFAULT_EXT;

	public String generateHeader() {

		return null;
	}

	public String generateNet(PhdlNet net) {

		return null;
	}

	public String generatePart(PhdlPart part) {

		return null;
	}

	public void setFileExtension(String extension) {
		this.fileExtension = extension;
	}

	public String translate(PhdlNetlist netlist) {
		StringBuilder sb = new StringBuilder();
		sb.append(generateHeader());

		System.out.println(this.getClass().getName());
		return sb.toString();
	}

}
