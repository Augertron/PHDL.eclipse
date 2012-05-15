/*
    Copyright (C) 2011  Brigham Young University

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, version 3.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package phdl.generator;

import java.io.File;

import phdl.graph.Design;

/**
 * A wrapper class that creates all the generator classes.
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 */
public class Generator {

	private final RefDesGenerator refDesGen;
	private final NetListGenerator netListGen;
	private final EagleGenerator eagleScriptGen;
	private final BoMGenerator bomGen;
	private XMLGenerator xmlGen;
	private final Design design;
	private final InfoGenerator infoGen;

	//private XMLtoDesignGenerator xmlDesGen;
	//private DesignComparator desComp;

	/**
	 * Default Constructor.
	 * 
	 * Creates all the generator classes and passes them a DesignNode
	 * 
	 * @param design
	 *            the DesignNode to be processed
	 * @see Design
	 * @see RefDesGenerator
	 * @see BoMGenerator
	 * @see NetListGenerator
	 */
	public Generator(Design design) {
		this.design = design;
		this.refDesGen = new RefDesGenerator(design);
		this.bomGen = new BoMGenerator(design);
		this.netListGen = new NetListGenerator(design, refDesGen.getRefMap());
		this.infoGen = new InfoGenerator(design);
		eagleScriptGen = new EagleGenerator(design, refDesGen.getRefMap());

	}

	public void generate() {
		makeDirectory(DirectoryCodes.REF_DES_MAPPING);
		refDesGen.outputToFile(DirectoryCodes.REF_DES_MAPPING + design.getName() + ".csv");
		makeDirectory(DirectoryCodes.BILL_OF_MATERIAL);
		bomGen.outputToFile(DirectoryCodes.BILL_OF_MATERIAL + design.getName() + ".csv");
		makeDirectory(DirectoryCodes.PADS_NETLIST);
		netListGen.outputToFile(DirectoryCodes.PADS_NETLIST + design.getName() + ".asc");
		makeDirectory(DirectoryCodes.EAGLE_SCRIPT);
		eagleScriptGen.outputToFile(DirectoryCodes.EAGLE_SCRIPT + design.getName() + ".scr");
		makeDirectory(DirectoryCodes.LAYOUT_SUPPLEMENTARY_INFO);
		infoGen.outputToFile(DirectoryCodes.LAYOUT_SUPPLEMENTARY_INFO + design.getName() + ".lsi");
	}

	private void makeDirectory(String directory) {
		File file = new File(directory);
		if (!file.isDirectory())
			file.mkdir();
	}
}
