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

import phdl.grammar.ParsePHDL;
import phdl.graph.Design;
import phdl.graph.Device;
import phdl.graph.SubDesign;

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
		long stt = System.currentTimeMillis();

		Configuration cfg = new Configuration(args);
		System.out.println("\n" + cfg.getVersion() + "\n");

		for (String fileName : cfg.getFileNames()) {
			ParsePHDL p = new ParsePHDL(cfg);
			for (int i = 0; i < cfg.getReqAttr().length; i++)
				p.addRequiredAttribute(cfg.getReqAttr()[i]);
			p.parse(fileName);

			if (cfg.isReport()) {
				for (Device d : p.getDevices())
					System.out.print(d.toString().replace("\n", "\n  "));
				Design d = p.getTopDesign();
				if (d != null) {
					System.out.print(d.toString().replace("\n", "\n  "));
				}
				for (SubDesign s : p.getSubDesigns())
					System.out.print(s.toString().replace("\n", "\n  "));
			}
			if (cfg.isHierarchy())
				p.getTopDesign().toDot();
		}

		long end = System.currentTimeMillis();
		System.out.println("  -- Elapsed: " + (end - stt) + " ms.");

	}
}