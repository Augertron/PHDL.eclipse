package edu.byu.ee.phdl.translate;

import org.apache.log4j.Logger;

import edu.byu.ee.phdl.elaboration.EDesign;
import edu.byu.ee.phdl.utils.ExtensionCodes;

public class DefaultTranslator {

	private final Logger logger = Logger.getLogger(DefaultTranslator.class);

	private String fileExtension = ExtensionCodes.DEFAULT_EXT;

	public void setFileExtension(String extension) {
		this.fileExtension = extension;
	}

	public boolean translate(EDesign design) {
		System.out.println(this.getClass().getName());
		return true;
	}

}
