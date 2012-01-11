/*
 * Copyright (C) 2011 Brigham Young University This program is free software: you can redistribute
 * it and/or modify it under the terms of the GNU General Public License as published by the Free
 * Software Foundation, version 3. This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received
 * a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package phdl.grammar;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.DOTTreeGenerator;
import org.antlr.runtime.tree.Tree;
import org.antlr.stringtemplate.StringTemplate;

import phdl.Configuration;
import phdl.grammar.PhdlAST.operand_return;
import phdl.graph.Design;
import phdl.graph.Device;
import phdl.graph.Net;
import phdl.graph.Node;
import phdl.graph.SubDesign;

public class ParsePHDL {

	private Set<Device> devices;
	private Design topDesign;
	private Set<SubDesign> subDesigns;
	private Set<String> reqAttr;
	private List<String> errors;
	private List<String> warnings;
	private Configuration sw;

	public ParsePHDL(Configuration sw) {
		this.devices = new HashSet<Device>();
		this.subDesigns = new HashSet<SubDesign>();
		this.reqAttr = new HashSet<String>();
		this.errors = new ArrayList<String>();
		this.warnings = new ArrayList<String>();
		this.sw = sw;
	}

	public void addRequiredAttribute(String attr) {
		this.reqAttr.add(attr);
	}

	/**
	 * Adds a warning from a Node object
	 */
	private void addWarning(Node n, String message) {
		String index = "";
		if (n instanceof Net)
			index += ((Net) n).getIndex();
		warnings.add(n.getFileName() + " line " + n.getLine() + ":" + n.getPosition() + " "
			+ message + ": " + n.getName() + "[" + index + "]");
	}

	public void dumpToFile(String fileName, String fileData) {
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

	public Design getTopDesign() {
		return topDesign;
	}

	public Set<SubDesign> getSubDesigns() {
		return subDesigns;
	}

	public Set<Device> getDevices() {
		return devices;
	}

	public void parse(String fileName) {
		CharStream cs = null;
		try {
			cs = new ANTLRFileStream(fileName);
		} catch (IOException e) {
			System.err.println("Source file not found: " + fileName);
			System.exit(1);
		}

		PhdlParser p = new PhdlParser(new CommonTokenStream(new PhdlLexer(cs)));
		try {

			CommonTree tree = (CommonTree) p.sourceText().getTree();
			CommonTreeNodeStream ns = new CommonTreeNodeStream(tree);
			ns.setTokenStream(p.getTokenStream());

			for (String error : p.getErrors())
				errors.add(error);

			if (sw.isDumpEn()) {
				// convert the AST to a dotty formatted string for debug
				DOTTreeGenerator dtg = new DOTTreeGenerator();
				StringTemplate st = dtg.toDOT((Tree) tree);
				String astFileName = fileName + "_ast.dot";
				dumpToFile(astFileName, st.toString());
			}

			// bail out if there are errors
			printErrors();

			PhdlAST ast = new PhdlAST(ns);
			ast.sourceText();
			errors.addAll(ast.getErrors());
			warnings.addAll(ast.getWarnings());
			devices.addAll(ast.getDevices());
			topDesign = ast.getTopDesign();
			subDesigns = ast.getSubDesigns();

			// print out all errors if there were any, and exit abnormally
			printErrors();

			// // call the superNet algorithm on all nets in each design node
			// for (Design d : walker.getDesigns()) {
			// d.superNet2();
			// // report any floating nets
			// for (Net n : d.getNets()) {
			// if ((n.getPinNodes().size() < 2) && (!n.getName().equals("OPEN")))
			// addWarning(n, "floating net");
			// }
			//
			// Generator gen = new Generator(d, sw.isEagle());
			//
			// gen.generateRefDes();
			// gen.generateBoM();
			// gen.generateNetList();
			// if (sw.isEagle())
			// gen.generateEagleScript();
			// gen.generateInfo();
			//
			// }
			// if (sw.isDumpEn()) { // output a dotty graph after merging all nodes
			// for (Design d : walker.getDesigns()) {
			// String graphFileName = fileName + "_graph_merged.dot";
			// d.dottyDump(graphFileName);
			// d.printDesignNode();
			// }
			// }
			// if (sw.isVerbose()) {
			// for (Design d : walker.getDesigns()) {
			// d.printDesignNode();
			// }
			// }

		} catch (Exception e) {
			e.printStackTrace();
			errors.add("ERROR: " + e.getStackTrace());
			// print out any parsing errors, and do not continue on.
			printErrors();
		}

		// print out all warnings if they exist.
		if (!sw.isSupWarn())
			printWarnings();

		System.out.println("Parsed file: " + fileName);

	}

	public void printErrors() {
		if (!errors.isEmpty()) {
			for (String s : errors)
				System.out.println("ERROR: " + s);
			// only bail out if verbose mode is not set
			if (!sw.isVerbose())
				System.exit(1);
		}
	}

	public boolean printWarnings() {
		if (!warnings.isEmpty()) {
			for (String s : warnings)
				System.out.println("WARNING: " + s);
			return true;
		}
		return false;
	}

	public void setTopDesign(Design design) {
		this.topDesign = design;
	}

	public void setSubDesigns(Set<SubDesign> subDesigns) {
		this.subDesigns = subDesigns;
	}

	public void setDevices(Set<Device> devices) {
		this.devices = devices;
	}

	public static boolean unitTest() {
		// lots of TODO
		PhdlLexer lexer = new PhdlLexer();
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		PhdlParser parser = new PhdlParser(tokenStream);
		PhdlAST ast;

		CharStream cs = new ANTLRStringStream(" operand [0:3] ");
		lexer.setCharStream(cs);
		try {
			ast = new PhdlAST(new CommonTreeNodeStream(parser.operand().getTree()));
			operand_return oprtn = ast.operand();
			//System.out.println(oprtn.name.getText() + " " + oprtn.indices);

		} catch (RecognitionException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
}
