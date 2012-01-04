/*
 * Copyright (C) 2011 Brigham Young University This program is free software: you can redistribute
 * it and/or modify it under the terms of the GNU General Public License as published by the Free
 * Software Foundation, version 3. This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received
 * a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package phdl;

import java.util.ArrayList;
import java.util.List;

import phdl.graph.Design;
import phdl.graph.Device;

/**
 * A wrapper class which contains the main entry point of the phdl compiler.
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 * 
 */
public class Compile {

	/**
	 * The main entry point of the phdl Compiler. It accepts *.phdl source files as arguments and
	 * generates a net list for layout tools, and a bill of material for procurement.
	 */
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		Switches sw = new Switches();
		List<String> fileNames = new ArrayList<String>();

		if (args.length == 0) {
			System.out.println(cfg.getUsage());
			System.exit(1);
		}
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-w"))
				sw.setSupWarn(true);
			else if (args[i].equals("-d"))
				sw.setDumpEn(true);
			else if (args[i].equals("-v"))
				sw.setVerbose(true);
			else if (args[i].equals("-e"))
				sw.setEagle(true);
			else if (args[i].equals("-c")) {
				sw.setClean(true);
			} else if (args[i].equals("?")) {
				System.out.println(cfg.getUsage());
				System.exit(1);
			} else {
				fileNames.add(args[i]);
			}
		}

		for (String fileName : fileNames) {
			Parser p = new Parser(sw);
			for (int i = 0; i < cfg.getReqAttr().length; i++)
				p.addRequiredAttribute(cfg.getReqAttr()[i]);
			p.parse(fileName);
			for (Device d : p.getDevices())
				System.out.print(d.toString());
			for (Design d : p.getDesigns())
				d.printDesign();
		}

	}

}