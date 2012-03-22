/*
 * Copyright (C) 2012 Brigham Young University. This program is free software: you can redistribute
 * it and/or modify it under the terms of the GNU General Public License as published by the Free
 * Software Foundation, version 3. This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received
 * a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package phdl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import phdl.generator.Generator;
import phdl.grammar.ParsePHDL;
import phdl.graph.Device;
import phdl.graph.SubDesign;

import com.martiansoftware.jsap.FlaggedOption;
import com.martiansoftware.jsap.JSAP;
import com.martiansoftware.jsap.JSAPException;
import com.martiansoftware.jsap.JSAPResult;
import com.martiansoftware.jsap.Switch;
import com.martiansoftware.jsap.UnflaggedOption;

/**
 * A class which contains the main entry point of the phdl compiler.
 * 
 * @author Richard Black and Brad Riching
 * @version 2.0
 * 
 */
public class Compile {

	static String license = " Copyright (C) 2012 Brigham Young University. This program is free software: you can redistribute\r\n"
		+ " it and/or modify it under the terms of the GNU General Public License as published by the Free\r\n"
		+ " Software Foundation, version 3. This program is distributed in the hope that it will be useful,\r\n"
		+ " but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A\r\n"
		+ " PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received\r\n"
		+ " a copy of the GNU General Public License along with this program. If not, see\r\n"
		+ " http://www.gnu.org/licenses/.\n";

	static String version = "PHDL Compiler v2.0 Java v1.6 ANTLR v3.2 Feb 01 2012";
	static String[] reqAttrs = { "REFPREFIX", "PACKAGE", "LIBRARY" };

	static final Map<String, String> dirs = new HashMap<String, String>();
	static {
		dirs.put("ReferenceDesignatorMapping", "rdm\\");
		dirs.put("BillOfMaterial", "bom\\");
		dirs.put("PADSNetlist", "asc\\");
		dirs.put("LayoutSupplementaryInformation", "lsi\\");
		dirs.put("EAGLEScript", "scr\\");
	}

	static JSAP jsap;

	private static void cfgJSAP() throws JSAPException {
		// Assists with capturing command-line parameters and constructing usage
		jsap = new JSAP();

		// top design flag and source file
		FlaggedOption optTopFileName = new FlaggedOption("topFileName");
		optTopFileName.setStringParser(JSAP.STRING_PARSER);
		optTopFileName.setShortFlag('t');
		optTopFileName.setLongFlag("top");
		optTopFileName.setHelp("PHDL top level design file name.");
		jsap.registerParameter(optTopFileName);

		// directory containing phdl source files
		FlaggedOption optDirectory = new FlaggedOption("directory");
		optDirectory.setStringParser(JSAP.STRING_PARSER);
		optDirectory.setShortFlag('d');
		optDirectory.setLongFlag("dir");
		optDirectory.setHelp("Directory where phdl source files are located");
		jsap.registerParameter(optDirectory);

		// source files
		UnflaggedOption optFileName = new UnflaggedOption("fileName");
		optFileName.setStringParser(JSAP.STRING_PARSER);
		optFileName.setGreedy(true);
		optFileName.setHelp("PHDL source file name.");
		jsap.registerParameter(optFileName);

		// verbose flag
		Switch swVerbose = new Switch("verbose");
		swVerbose.setShortFlag('v');
		swVerbose.setLongFlag("verbose");
		swVerbose.setHelp("Requests verbose output.");
		jsap.registerParameter(swVerbose);

		// generate hierarcy DOT and PNG output flag
		Switch swDOT = new Switch("png");
		swDOT.setShortFlag('p');
		swDOT.setLongFlag("png");
		swDOT.setHelp("Exports hierarchy PNG pictures using DOT in the /png folder.");
		jsap.registerParameter(swDOT);

		// suppress warnings flag
		Switch swSuppress = new Switch("suppress");
		swSuppress.setShortFlag('s');
		swSuppress.setLongFlag("suppress");
		swSuppress.setHelp("Suppress all warnings from the compiler.");
		jsap.registerParameter(swSuppress);

		// generate EAGLE script flag
		Switch swEagle = new Switch("eagle");
		swEagle.setShortFlag('e');
		swEagle.setLongFlag("eagle");
		swEagle.setHelp("Generate an EAGLE script file.");
		jsap.registerParameter(swEagle);

		// report design hierarchy on the command line flag
		Switch swReport = new Switch("report");
		swReport.setShortFlag('r');
		swReport.setLongFlag("report");
		swReport.setHelp("Report design hierarchy at the command line. (Extremely verbose)");
		jsap.registerParameter(swReport);

		// clean flag (remove all generated files and folders)
		Switch swClean = new Switch("clean");
		swClean.setShortFlag('c');
		swClean.setLongFlag("clean");
		swClean.setHelp("Clean (remove) all generated files and folders.");
		jsap.registerParameter(swClean);

		// generate AST output from parser (for debug only)
		Switch swAST = new Switch("ast");
		swAST.setShortFlag('a');
		swAST.setLongFlag("ast");
		swAST.setHelp("Generates a DOT graphical ast of all source files in the /ast folder.");
		jsap.registerParameter(swAST);

		// help
		Switch swHelp = new Switch("help");
		swHelp.setShortFlag('h');
		swHelp.setLongFlag("help");
		swHelp.setHelp("Display this usage help.");
		jsap.registerParameter(swHelp);
	}

	static void delete(File f) {
		if (f.isDirectory()) {
			for (File c : f.listFiles())
				delete(c);
		}
		f.delete();
	}

	/**
	 * The main entry point of the phdl Compiler.
	 * @throws JSAPException 
	 */
	public static void main(String[] args) throws JSAPException {
		long stt = System.currentTimeMillis();

		// configure the command line argument parser
		cfgJSAP();

		// parse the command arguments and report errors
		JSAPResult cfg = jsap.parse(args);
		if (!cfg.success() || cfg.getBoolean("help")) {
			System.err.println();
			for (@SuppressWarnings("rawtypes")
			java.util.Iterator errs = cfg.getErrorMessageIterator(); errs.hasNext();) {
				System.err.println("ERROR: " + errs.next());
			}
			System.out.println(version + "\n");
			System.out.println(license);
			System.err.println("Usage: java " + Compile.class.getName());
			System.err.println();
			System.err.println(jsap.getHelp());
			System.exit(1);
		}

		System.out.println(version + "\n");

		// clean up everything if the clean flag is set
		if (cfg.getBoolean("clean")) {
			for (String s : dirs.keySet()) {
				delete(new File(dirs.get(s)));
				System.out.println("  -- Cleaned:   \\" + dirs.get(s) + "*.*");
			}
		}

		// call the parser, and obtain all of the design units
		ParsePHDL p = new ParsePHDL(cfg);
		p.parse(reqAttrs);

		// print out the reports if requested
		if (cfg.getBoolean("report")) {
			for (Device d : p.getDevices())
				System.out.print(d.toString().replace("\n", "\n  "));
			if (p.getTopDesign() != null)
				System.out.print(p.getTopDesign().toString().replace("\n", "\n  "));
			for (SubDesign s : p.getSubDesigns())
				System.out.print(s.toString().replace("\n", "\n  "));
		}

		// generate hierarchy png's if requested
		if (cfg.getBoolean("png")) {
			p.getTopDesign().toPNG();
			for (SubDesign s : p.getSubDesigns())
				s.toPNG();
		}

		// only translate the designs if a top level design is present
		if (p.getTopDesign() == null) {
			System.err.println();
			System.err.println("ERROR: no top level design found.");
			System.exit(1);
		}

		// generate output files
		Generator gen = new Generator(p.getTopDesign(), dirs);
		gen.generate();

		// display the hierarchy on the console
		p.getTopDesign().printHierarchy();

		long end = System.currentTimeMillis();
		System.out.println("  -- Elapsed: " + (end - stt) + " ms.");
	}
}