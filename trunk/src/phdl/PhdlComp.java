/*
    Copyright (C) 2011  BYU Configurable Computing Lab

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package phdl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.SortedSet;
import java.util.TreeSet;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.DOTTreeGenerator;
import org.antlr.runtime.tree.Tree;
import org.antlr.stringtemplate.StringTemplate;

import phdl.grammar.PhdlLexer;
import phdl.grammar.PhdlParser;
import phdl.grammar.PhdlParser.sourceText_return;
import phdl.grammar.PhdlWalker;
import phdl.graph.DesignNode;

/**
 * A wrapper class which contains the main entry point of the phdl compiler.
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 * 
 */
public class PhdlComp {

	/**
	 * An array of attributes that every device declaration is required to have
	 */
	static String[] reqAttr = { "REFPREFIX", "NAME", "VALUE" };

	static SortedSet<String> errors = new TreeSet<String>();
	static SortedSet<String> warnings = new TreeSet<String>();

	/**
	 * The main entry point of the phdl Compiler. It accepts *.phdl source files
	 * as arguments and generates a netlist for layout tools.
	 */
	public static void main(String[] args) {

		sourceText_return sourceTree = null;

		// repeat for each source file passed in as an argument
		for (int i = 0; i < args.length; i++) {

			System.out.println("Compiling..." + args[i]);
			// 1. attempt to make a character stream from the source file
			CharStream cs = null;
			try {
				cs = new ANTLRFileStream(args[i]);
			} catch (IOException e) {
				System.err.println("Problem reading file: " + args[0]);
				System.exit(1);
			}

			// 2. lex this character stream and make a stream of tokens. Attempt
			// to parse the stream of tokens to a tree and accumulate errors.
			PhdlLexer l = new PhdlLexer(cs);
			TokenStream ts = new CommonTokenStream(l);
			PhdlParser p = new PhdlParser(ts);
			try {
				sourceTree = p.sourceText();
				for (String error : p.getErrors())
					errors.add(error);

			} catch (RecognitionException e) {
				errors.add(e.getMessage());
			}

			// print out all errors if there were any, and exit abnormally
			if (printErrors()) {
				System.exit(1);
			}

			// 3. convert this tree of tokens to a node stream and set the token
			// stream reference to the parser's token stream
			CommonTreeNodeStream ns = new CommonTreeNodeStream(
					sourceTree.getTree());
			ns.setTokenStream(p.getTokenStream());

			// 4. walk the stream of nodes and attempt to obtain a set of all
			// designs and add any errors if they exist
			PhdlWalker walker = new PhdlWalker(ns);
			walker.setRequiredAttributes(reqAttr);
			try {
				walker.sourceText();
				errors.addAll(walker.getErrors());
				warnings.addAll(walker.getWarnings());
			} catch (RecognitionException e) {
				errors.add(e.getMessage());
			}
			// print out all errors if there were any, and exit abnormally
			if (printErrors()) {
				printWarnings();
				System.exit(1);
			}
			// otherwise, just print warnings
			printWarnings();

			// print out the design
			for (DesignNode d : walker.getDesignNodes()) {
				d.printDesignNode();
			}

			// 5. convert the AST to a dotty formatted string
			DOTTreeGenerator tg = new DOTTreeGenerator();
			StringTemplate st = tg.toDOT((Tree) sourceTree.getTree());
			String fileName = args[i].replace(".phdl", "");
			fileName += "_AST.dot";
			dumpToFile(fileName, st.toString());

		} // end for loop on all source files

		// print out all errors if there were any, and exit abnormally
		// if (printErrors()) {
		// System.exit(1);
		// }

		System.out.println("...done.");
	}

	static boolean printErrors() {
		if (!errors.isEmpty()) {
			for (String s : errors) {
				System.out.println("ERROR: " + s);
			}
			return true;
		}
		return false;
	}

	static boolean printWarnings() {
		if (!warnings.isEmpty()) {
			for (String s : warnings) {
				System.out.println("WARNING: " + s);
			}
			return true;
		}
		return false;
	}

	static void dumpToFile(String fileName, String fileData) {
		BufferedWriter dotty = null;
		try {
			dotty = new BufferedWriter(new FileWriter(fileName));
		} catch (IOException e) {
			System.out.println("Problem creating file: " + fileName);
			System.exit(1);
		}
		try {
			dotty.write(fileData);
			dotty.close();
		} catch (IOException e) {
			System.out.println("Prolem writing dotty file.");
			System.exit(1);
		}
		System.out.println("Wrote file: " + fileName);
	}
}