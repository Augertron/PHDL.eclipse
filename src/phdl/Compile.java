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

import com.martiansoftware.jsap.FlaggedOption;
import com.martiansoftware.jsap.JSAP;
import com.martiansoftware.jsap.JSAPException;
import com.martiansoftware.jsap.JSAPResult;
import com.martiansoftware.jsap.Switch;
import com.martiansoftware.jsap.UnflaggedOption;

/**
 * A wrapper class which contains the main entry point of the phdl compiler.
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 * 
 */
public class Compile {

	static String version = "PHDL Compiler v2.0 Java v1.6 ANTLR v3.2 Feb 01 2012";

	/**
	 * The main entry point of the phdl Compiler. It accepts *.phdl source files as arguments and
	 * generates a net list for layout tools, and a bill of material for procurement.
	 * @throws JSAPException 
	 */
	public static void main(String[] args) throws JSAPException {
		long stt = System.currentTimeMillis();

		//Configuration cfg = new Configuration(args);

		System.out.println(version);
		JSAP jsap = new JSAP();

		// top design flag and source file
		FlaggedOption opt1 = new FlaggedOption("topFileName");
		opt1.setStringParser(JSAP.STRING_PARSER);
		opt1.setShortFlag('t');
		opt1.setLongFlag("top");
		opt1.setHelp("PHDL top level design file name.");
		jsap.registerParameter(opt1);

		// source files
		UnflaggedOption opt2 = new UnflaggedOption("fileName");
		opt2.setStringParser(JSAP.STRING_PARSER);
		opt2.setGreedy(true);
		opt2.setHelp("PHDL source file name.");
		jsap.registerParameter(opt2);

		// verbose flag
		Switch sw1 = new Switch("verbose");
		sw1.setShortFlag('v');
		sw1.setLongFlag("verbose");
		sw1.setHelp("Requests verbose output.");
		jsap.registerParameter(sw1);

		// generate dot output flag
		Switch sw2 = new Switch("dot");
		sw2.setShortFlag('d');
		sw2.setLongFlag("dot");
		sw2.setHelp("Generates a DOT graphical hierarchy of the design in the /dot folder.");
		jsap.registerParameter(sw2);

		// suppress warnings flag
		Switch sw3 = new Switch("suppress");
		sw3.setShortFlag('s');
		sw3.setLongFlag("suppress");
		sw3.setHelp("Suppress all warnings from the compiler.");
		jsap.registerParameter(sw3);

		// generate EAGLE script flag
		Switch sw4 = new Switch("eagle");
		sw4.setShortFlag('e');
		sw4.setLongFlag("eagle");
		sw4.setHelp("Generate an EAGLE script file.");
		jsap.registerParameter(sw4);

		// report design hierarchy on the command line flag
		Switch sw5 = new Switch("report");
		sw5.setShortFlag('r');
		sw5.setLongFlag("report");
		sw5.setHelp("Report design hierarchy on the command line.");
		jsap.registerParameter(sw5);

		// clean flag (remove all generated files and folders)
		Switch sw6 = new Switch("clean");
		sw6.setShortFlag('c');
		sw6.setLongFlag("clean");
		sw6.setHelp("Clean (remove) all generated files and folders.");
		jsap.registerParameter(sw6);

		// generate AST output from parser (for debug only)
		Switch sw7 = new Switch("ast");
		sw7.setShortFlag('a');
		sw7.setLongFlag("ast");
		sw7.setHelp("Generates a DOT graphical ast of all source files in the /ast folder");
		jsap.registerParameter(sw7);

		JSAPResult config = jsap.parse(args);

		if (!config.success()) {
			System.err.println();
			for (@SuppressWarnings("rawtypes")
			java.util.Iterator errs = config.getErrorMessageIterator(); errs.hasNext();) {
				System.err.println("ERROR: " + errs.next());
			}
			System.err.println();
			System.err.println("Usage: java " + Compile.class.getName());
			System.err.println();
			System.err.println(jsap.getHelp());
			System.exit(1);
		}

		// clean up everything if the clean flag is set
		if (config.getBoolean("clean")) {

		}

		// call the parser, and obtain all of the design units
		ParsePHDL p = new ParsePHDL(config);
		p.parse();

		long end = System.currentTimeMillis();
		System.out.println("  -- Elapsed: " + (end - stt) + " ms.");
	}
}