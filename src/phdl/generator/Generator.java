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

	RefDesGenerator refDesGen;
	NetListGenerator netListGen;
	EagleScriptGenerator eagleScriptGen;
	BoMGenerator bomGen;
	XMLGenerator xmlGen;
	XMLtoDesignGenerator xmlDesGen;
	DesignComparator desComp;
	Design design;
	InfoGenerator infoGen;

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
		refDesGen = new RefDesGenerator(design);
		bomGen = new BoMGenerator(design);
		netListGen = new NetListGenerator(design, refDesGen.getRefMap());
		infoGen = new InfoGenerator(design);
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

	/**
	 * Generates a Bill of Materials file based on the name of the DesignNode.
	 * 
	 * @see BoMGenerator
	 */
	public void generateBoM() {
		makeDirectory("bom\\");
		bomGen.outputToFile("bom\\" + design.getName() + ".csv");
	}

	/**
	 * Generates an Eagle script file based on the name of the DesignNode.
	 * 
	 * @see EagleScriptGenerator
	 */
	public void generateEagleScript() {
		makeDirectory("scr\\");
		eagleScriptGen.outputToFile("scr\\" + design.getName() + ".scr");
	}

	/**
	 * Generates an Info file based on the info structures in the DesignNode.
	 * 
	 * @see InfoGenerator
	 */
	public void generateInfo() {
		infoGen.outputToFile(design.getName() + ".info");
	}

	/**
	 * Generates a Netlist file based on the name of the DesignNode.
	 * 
	 * @see NetListGenerator
	 */
	public void generateNetList() {
		makeDirectory("asc\\");
		netListGen.outputToFile("asc\\" + design.getName() + ".asc");
	}

	/**
	 * Generates a Reference Designator file based on the name of the DesignNode.
	 * 
	 * @see RefDesGenerator
	 */
	public void generateRefDes() {
		makeDirectory("csv\\");
		refDesGen.outputToFile("csv\\" + design.getName() + ".csv");
	}

	/**
	 * Generates a Netlist file based on the name of the DesignNode.
	 * 
	 * @see XMLGenerator
	 */
	public void generateXML() {
		makeDirectory("xml\\");
		xmlGen.outputToFile("xml\\" + design.getName() + ".xml");
	}

	private void makeDirectory(String directory) {
		File file = new File(directory);
		if (!file.isDirectory())
			file.mkdir();
	}
}
