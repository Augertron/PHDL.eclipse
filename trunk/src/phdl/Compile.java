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

package phdl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.DOTTreeGenerator;
import org.antlr.runtime.tree.Tree;
import org.antlr.stringtemplate.StringTemplate;

import phdl.generator.Generator;
import phdl.grammar.PhdlLexer;
import phdl.grammar.PhdlParser;
import phdl.grammar.PhdlWalker;
import phdl.graph.DesignNode;
import phdl.graph.NetNode;
import phdl.graph.Node;

/**
 * A wrapper class which contains the main entry point of the phdl compiler.
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 * 
 */
public class Compile {

	/**
	 * An array of attributes that every device declaration is required to have
	 */
	static String[] reqAttr = { "REFPREFIX", "PKG_TYPE", };

	/**
	 * A list of errors generated
	 */
	static List<String> errors = new ArrayList<String>();

	/**
	 * A list of warnings generated
	 */
	static List<String> warnings = new ArrayList<String>();

	/**
	 * Usage string for help directions
	 */
	static private String usage = "\nPHDL Compiler v0.1.\n\n"
		+ " * Copyright (C) 2011 BYU Configurable Computing Lab This program is free software: you can\r\n"
		+ " * redistribute it and/or modify it under the terms of the GNU General Public License as published\r\n"
		+ " * by the Free Software Foundation, either version 3 of the License, or (at your option) any later\r\n"
		+ " * version. This program is distributed in the hope that it will be useful, but WITHOUT ANY\r\n"
		+ " * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR\r\n"
		+ " * PURPOSE. See the GNU General Public License for more details. You should have received a copy of\r\n"
		+ " * the GNU General Public License along with this program. If not, see\r\n"
		+ " * <http://www.gnu.org/licenses/>.\n\n" + "" + "Usage:\n\n"
		+ "\t<*.phdl> <*.phdl> ... [-w][-d][-v]\n\n"
		+ "\tOne or more design phdl files followed by optional switches.\n"
		+ "\t-w\tsupress warnings\n" + "\t-d\tenable dotty file dump for graph viewing\n"
		+ "\t-v\tenable verbose error reporting (will not bail out simple parse errors)\n"
		+ "\t-e\toutput script for EAGLE PCB\n\n";

	/**
	 * Suppress warnings flag
	 */
	static boolean supWarn = false;
	/**
	 * Dotty dump enable flag
	 */
	static boolean dumpEn = false;
	/**
	 * Verbose error messages flag
	 */
	static boolean verbose = false;
	/**
	 * Eagle output enable flag
	 */
	static boolean eagle = false;
	/**
	 * Remove all generated files before compiling
	 */
	static boolean clean = false;

	/**
	 * The main entry point of the phdl Compiler. It accepts *.phdl source files as arguments and
	 * generates a net list for layout tools, and a bill of material for procurement.
	 */
	public static void main(String[] args) {

		// print out the help if the program is being used incorrectly
		if (args.length == 0) {
			System.out.println(usage);
			System.exit(1);
		}

		// set all of the compiler switches from command line
		for (int i = 0; i < args.length; i++) {
			// suppress warnings
			if (args[i].equals("-w"))
				supWarn = true;
			// turn on dump mode
			if (args[i].equals("-d"))
				dumpEn = true;
			// turn on verbose mode
			if (args[i].equals("-v"))
				verbose = true;
			// turn on eagle mode
			if (args[i].equals("-e"))
				eagle = true;
			// cleanup the generated files
			if (args[i].equals("-c"))
				clean = true;
			if (args[i].equals("?")) {
				System.out.println(usage);
				System.exit(1);
			}
		}

		// Repeat for each source file passed in as an argument
		for (int i = 0; i < args.length; i++) {

			// ignore the compiler switches
			if (args[i].startsWith("-"))
				continue;

			String fileName = args[i].replace(".phdl", "");
			System.out.println("Compiling..." + args[i]);

			// remove generated files first
			if (clean) {
				ArrayList<File> deletes = new ArrayList<File>();
				File xml = new File(fileName + ".xml");
				File csv = new File(fileName + ".csv");
				File bom = new File(fileName + ".bom");
				File asc = new File(fileName + ".asc");
				deletes.add(xml);
				deletes.add(csv);
				deletes.add(bom);
				deletes.add(asc);

				for (File f : deletes) {
					if (f.exists() && f.canWrite()) {
						if (!f.delete())
							System.err.println("Clean operation failed to delete: " + f.getName());
					} else {
						System.err.println("Clean operation failed to delete: " + f.getName());
					}
				}
			}

			// 1. Attempt to make a character stream from the source file and bail out if there is a
			// problem with the source file
			CharStream cs = null;
			try {
				cs = new ANTLRFileStream(args[i]);
			} catch (IOException e) {
				System.err.println("Source file not found: " + args[0]);
				System.exit(1);
			}

			// 2. LEX this character stream and make a stream of tokens. Attempt to parse the stream
			// of tokens to a tree. Bail out of the compiler if there are any parser errors.
			PhdlLexer l = new PhdlLexer(cs);
			TokenStream ts = new CommonTokenStream(l);
			PhdlParser p = new PhdlParser(ts);
			try {
				Object tree = p.sourceText().getTree();
				CommonTreeNodeStream ns = new CommonTreeNodeStream(tree);
				ns.setTokenStream(p.getTokenStream());
				for (String error : p.getErrors())
					errors.add(error);

				if (dumpEn) {
					// convert the AST to a dotty formatted string for graph viewing
					DOTTreeGenerator tg = new DOTTreeGenerator();
					StringTemplate st = tg.toDOT((Tree) tree);
					String astFileName = fileName + "_ast.dot";
					dumpToFile(astFileName, st.toString());
				}

				// bail out of there are errors
				printErrors();

				// 3. walk the stream of nodes and attempt to obtain a set of all designs
				PhdlWalker walker = new PhdlWalker(ns);
				walker.setRequiredAttributes(reqAttr);
				walker.sourceText();
				errors.addAll(walker.getErrors());
				warnings.addAll(walker.getWarnings());

				// print out all errors if there were any, and exit abnormally
				printErrors();

				/*
				 * if (dumpEn) { // output a dotty graph before merging nodes for (DesignNode d :
				 * walker.getDesignNodes()) { String graphFileName = fileName + "_graph.dot";
				 * d.dottyDump(graphFileName); // d.printDesignNode(); } }
				 */

				// call the superNet algorithm on all nets in each design node
				for (DesignNode d : walker.getDesignNodes()) {
					d.superNet2();
					// report any floating nets
					for (NetNode n : d.getNets()) {
						if ((n.getPinNodes().size() < 2) && (!n.getName().equals("open")))
							addWarning(n, "floating net");
					}

					Generator gen = new Generator(d, eagle);

					gen.generateRefDes();
					gen.generateBoM();
					gen.generateNetList();
					if (eagle)
						gen.generateEagleScript();
					gen.generateInfo();
				}

				if (dumpEn) {
					// output a dotty graph after merging all nodes
					for (DesignNode d : walker.getDesignNodes()) {
						String graphFileName = fileName + "_graph_merged.dot";
						d.dottyDump(graphFileName);
						d.printDesignNode();
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				errors.add("ERROR: " + e.getStackTrace());
				// print out any parsing errors, and do not continue on.
				printErrors();
			}

			// print out all warnings if they exist.
			if (!supWarn)
				printWarnings();

			System.out.println("Compile successful: " + args[i]);
		} // end for loop on all source files
	}

	static void printErrors() {
		if (!errors.isEmpty()) {
			for (String s : errors)
				System.out.println("ERROR: " + s);
			// only bail out if verbose mode is not set
			if (!verbose)
				System.exit(1);
		}
	}

	static boolean printWarnings() {
		if (!warnings.isEmpty()) {
			for (String s : warnings)
				System.out.println("WARNING: " + s);
			return true;
		}
		return false;
	}

	static void dumpToFile(String fileName, String fileData) {
		BufferedWriter dotty = null;
		try {
			dotty = new BufferedWriter(new FileWriter(fileName));
			dotty.write(fileData);
			dotty.close();
		} catch (IOException e) {
			System.out.println("Prolem writing dotty file.");
			System.exit(1);
		}
		System.out.println("Wrote file: " + fileName);
	}

	/**
	 * Adds a warning from a Node object
	 */
	static void addWarning(Node n, String message) {
		warnings.add(n.getFileName() + " line " + n.getLine() + ":" + n.getPosition() + " "
			+ message + ": " + n.getName());
	}
}