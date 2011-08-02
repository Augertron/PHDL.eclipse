/*
 * Copyright (C) 2011 BYU Configurable Computing Lab This program is free software: you can
 * redistribute it and/or modify it under the terms of the GNU General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or (at your option) any later
 * version. This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * PURPOSE. See the GNU General Public License for more details. You should have received a copy of
 * the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package phdl.generator;

import phdl.graph.DesignNode;

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
	DesignNode design;

	/**
	 * Default Constructor.
	 * 
	 * Creates all the generator classes and passes them a DesignNode
	 * 
	 * @param design
	 *            the DesignNode to be processed
	 * @see DesignNode
	 * @see RefDesGenerator
	 * @see BoMGenerator
	 * @see NetListGenerator
	 */
	public Generator(DesignNode design, boolean eagle) {
		this.design = design;
		refDesGen = new RefDesGenerator(design);
		bomGen = new BoMGenerator(design);
		netListGen = new NetListGenerator(design, refDesGen.getRefMap());
		xmlGen = new XMLGenerator(design);
		generateXML();
		xmlDesGen = new XMLtoDesignGenerator(design.getName() + ".xml");
		if (eagle)
			eagleScriptGen = new EagleScriptGenerator(design, refDesGen.getRefMap());
	}

	/**
	 * Generates a Reference Designator file based on the name of the DesignNode.
	 * 
	 * @see RefDesGenerator
	 */
	public void generateRefDes() {
		refDesGen.outputToFile(design.getName() + ".csv");
	}

	/**
	 * Generates a Bill of Materials file based on the name of the DesignNode.
	 * 
	 * @see BoMGenerator
	 */
	public void generateBoM() {
		bomGen.outputToFile(design.getName() + ".bom");
	}

	/**
	 * Generates a Netlist file based on the name of the DesignNode.
	 * 
	 * @see NetListGenerator
	 */
	public void generateNetList() {
		netListGen.outputToFile(design.getName() + ".asc");
	}

	/**
	 * Generates an Eagle script file based on the name of the DesignNode.
	 * 
	 * @see EagleScriptGenerator
	 */
	public void generateEagleScript() {
		eagleScriptGen.outputToFile(design.getName() + ".scr");
	}

	/**
	 * Generates a Netlist file based on the name of the DesignNode.
	 * 
	 * @see NetListGenerator
	 */
	public void generateXML() {
		xmlGen.outputToFile(design.getName() + ".xml");
	}
}
