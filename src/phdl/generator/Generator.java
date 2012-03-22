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
import java.util.Map;

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
	private EagleScriptGenerator eagleScriptGen;
	private final BoMGenerator bomGen;
	private XMLGenerator xmlGen;
	private final Design design;
	private final InfoGenerator infoGen;
	private final Map<String, String> dirs;

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
	public Generator(Design design, Map<String, String> dirs) {
		this.design = design;
		this.refDesGen = new RefDesGenerator(design);
		this.bomGen = new BoMGenerator(design);
		this.netListGen = new NetListGenerator(design, refDesGen.getRefMap());
		this.infoGen = new InfoGenerator(design);
		this.dirs = dirs;

		//xmlGen = new XMLGenerator(design);
		//eagleScriptGen = new EagleScriptGenerator(design, desComp);

		/*
		File xml = new File(design.getName() + ".xml");
		boolean xmlExists = xml.exists();
		if (xmlExists) {
			xmlDesGen = new XMLtoDesignGenerator(design.getName() + ".xml");
			desComp = new DesignComparator();
			desComp.compareDesign(xmlDesGen.getDesign(), design);
			desComp.printChanges();
		} else {
			System.out.println("********Initial Build*******");
		}*/

		//generateXML();
	}

	public void generate() {
		for (String s : dirs.keySet()) {
			makeDirectory(dirs.get(s));
		}
		refDesGen.outputToFile(dirs.get("ReferenceDesignatorMapping") + design.getName() + ".csv");
		bomGen.outputToFile(dirs.get("BillOfMaterial") + design.getName() + ".csv");
		netListGen.outputToFile(dirs.get("PADSNetlist") + design.getName() + ".asc");

	}

	private void makeDirectory(String directory) {
		File file = new File(directory);
		if (!file.isDirectory())
			file.mkdir();
	}
}
