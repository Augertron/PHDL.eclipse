package phdl.generator;

import java.io.File;

public interface DirectoryCodes {
	String SEPARATOR = File.separator;

	String REF_DES_MAPPING = "rdm" + SEPARATOR;

	String BILL_OF_MATERIAL = "bom" + SEPARATOR;

	String PADS_NETLIST = "asc" + SEPARATOR;

	String EAGLE_SCRIPT = "scr" + SEPARATOR;

	String LAYOUT_SUPPLEMENTARY_INFO = "lsi" + SEPARATOR;
}
