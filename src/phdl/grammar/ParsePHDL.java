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
import java.io.File;
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
import org.antlr.stringtemplate.StringTemplate;

import phdl.TestDriver;
import phdl.graph.Attributable;
import phdl.graph.Design;
import phdl.graph.DesignUnit;
import phdl.graph.Device;
import phdl.graph.PinType;
import phdl.graph.SubDesign;

import com.martiansoftware.jsap.JSAPResult;

public class ParsePHDL {

	private final JSAPResult cfg;
	private final Set<Device> devices;
	private final Set<SubDesign> subDesigns;
	private Design topDesign;
	private final List<String> errors;
	private final List<String> warnings;
	private final Set<String> includeNames;

	public ParsePHDL(JSAPResult cfg) {
		this.cfg = cfg;
		this.devices = new HashSet<Device>();
		this.subDesigns = new HashSet<SubDesign>();
		this.errors = new ArrayList<String>();
		this.warnings = new ArrayList<String>();
		this.includeNames = new HashSet<String>();
	}

	public Set<Device> getDevices() {
		return devices;
	}

	public Set<SubDesign> getSubDesigns() {
		return subDesigns;
	}

	public Design getTopDesign() {
		return topDesign;
	}

	public void parse() {

		String[] fileNames = cfg.getStringArray("fileName");
		for (int i = 0; i < fileNames.length; i++) {

			// make a new character stream based on the filename
			CharStream cs = null;
			try {
				cs = new ANTLRFileStream(fileNames[i]);
			} catch (IOException e) {
				System.err.println("Source file not found: " + fileNames[i]);
				System.exit(1);
			}

			// set up the lexer and parser and accumulate included names from the lexer
			PhdlLexer l = new PhdlLexer();
			l.setIncludeNames(includeNames);
			l.setCharStream(cs);
			PhdlParser p = new PhdlParser(new CommonTokenStream(l));
			includeNames.addAll(l.getIncludeNames());

			try {
				CommonTree tree = (CommonTree) p.sourceText().getTree();
				CommonTreeNodeStream ns = new CommonTreeNodeStream(tree);
				ns.setTokenStream(p.getTokenStream());

				// accumulate any errors in the parser
				for (String error : p.getErrors())
					errors.add(error);

				if (cfg.getBoolean("ast")) {
					// convert the AST to a dotty formatted string for debug
					DOTTreeGenerator dtg = new DOTTreeGenerator();
					StringTemplate st = dtg.toDOT(tree);
					String astFileName = "ast\\" + fileNames[i] + "_ast.dot";
					File file = new File(astFileName);
					if (!file.getParentFile().isDirectory())
						file.getParentFile().mkdir();
					toFile(astFileName, st.toString());
				}

				// bail out if there are errors at this point
				printErrors();

				// set up the ast grammar
				PhdlAST ast = new PhdlAST(ns);
				ast.setDevices(devices);
				ast.setSubDesigns(subDesigns);
				ast.setTopDesign(topDesign);
				ast.sourceText();
				topDesign = ast.getTopDesign();

				// accumulate the errors and warnings
				errors.addAll(ast.getErrors());
				warnings.addAll(ast.getWarnings());
				printErrors();

			} catch (Exception e) {
				e.printStackTrace();
				errors.add("ERROR: " + e.getStackTrace());
				// print out any parsing errors, and do not continue on.
				printErrors();
			}

			// print out all warnings if suppress warnings is enabled
			if (!cfg.getBoolean("suppress"))
				printWarnings();
		}

		if (cfg.getBoolean("report")) {
			for (Device d : devices)
				System.out.print(d.toString().replace("\n", "\n  "));
			if (topDesign != null)
				System.out.print(topDesign.toString().replace("\n", "\n  "));
			for (SubDesign s : subDesigns)
				System.out.print(s.toString().replace("\n", "\n  "));
		}
		if (cfg.getBoolean("dot")) {
			topDesign.toDot();
			for (SubDesign s : subDesigns)
				s.toDot();
		}

		// print out the hierarchy
		topDesign.printHierarchy();
	}

	public void printErrors() {
		if (!errors.isEmpty()) {
			System.out.println();
			for (String s : errors)
				System.out.println("ERROR: " + s);
			// only bail out if verbose mode is not set
			if (!cfg.getBoolean("verbose"))
				System.exit(1);
		}
	}

	public void printWarnings() {
		if (!warnings.isEmpty()) {
			System.out.println();
			for (String s : warnings)
				System.out.println("WARNING: " + s);
		}
	}

	public void toFile(String fileName, String fileData) {
		BufferedWriter dotty = null;
		try {
			dotty = new BufferedWriter(new FileWriter(fileName));
			dotty.write(fileData);
			dotty.close();
		} catch (IOException e) {
			System.out.println("Prolem writing file " + fileName);
			System.exit(1);
		}
		System.out.println("  -- Generated: " + fileName);
	}

	@SuppressWarnings("unchecked")
	private static Object getRuleObject(int rule, String test, Object[] params) {
		PhdlLexer lexer = new PhdlLexer();
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		PhdlParser parser = new PhdlParser(tokenStream);

		CharStream cs = new ANTLRStringStream(test);
		lexer.setCharStream(cs);

		PhdlAST ast;
		Object object_return = null;
		try {
			switch (rule) {
			case PhdlAST.DEVICE_DECL:
				ast = new PhdlAST(new CommonTreeNodeStream(parser.deviceDecl().getTree()));
				ast.deviceDecl();
				object_return = ast.getDevices();
				break;
			case PhdlAST.ATTR_DECL:
				ast = new PhdlAST(new CommonTreeNodeStream(parser.attrDecl().getTree()));
				ast.attrDecl((List<Attributable>) params[0]);
				object_return = params[0];
				break;
			case PhdlAST.PIN_DECL:
				ast = new PhdlAST(new CommonTreeNodeStream(parser.pinDecl().getTree()));
				ast.pinDecl((Device) params[0]);
				object_return = params[0];
				break;
			case PhdlAST.DESIGN_DECL:
				ast = new PhdlAST(new CommonTreeNodeStream(parser.designDecl().getTree()));
				ast.designDecl();
				object_return = ast.getTopDesign();
				break;
			case PhdlAST.SUBDESIGN_DECL:
				ast = new PhdlAST(new CommonTreeNodeStream(parser.designDecl().getTree()));
				ast.designDecl();
				object_return = ast.getSubDesigns();
				break;
			case PhdlAST.GROUP_DECL:
				ast = new PhdlAST(new CommonTreeNodeStream(parser.groupDecl().getTree()));
				ast.groupDecl((DesignUnit) params[0]);
				object_return = params[0];
				break;
			case PhdlAST.PORT_DECL:
				ast = new PhdlAST(new CommonTreeNodeStream(parser.connectDecl().getTree()));
				ast.portDecl((DesignUnit) params[0]);
				object_return = params[0];
				break;
			case PhdlAST.NET_DECL:
				ast = new PhdlAST(new CommonTreeNodeStream(parser.connectDecl().getTree()));
				ast.netDecl((DesignUnit) params[0]);
				object_return = params[0];
				break;
			case PhdlAST.INST_DECL:
				ast = new PhdlAST(new CommonTreeNodeStream(parser.instDecl().getTree()));
				ast.instDecl((DesignUnit) params[0], (String) params[1]);
				object_return = params[0];
				break;
			case PhdlAST.ATTR_ASSIGN:
				ast = new PhdlAST(new CommonTreeNodeStream(parser.attrAssign().getTree()));
				ast.attrAssign((DesignUnit) params[0], (String) params[1]);
				object_return = params[0];
				break;
			case PhdlAST.PIN_ASSIGN:
				ast = new PhdlAST(new CommonTreeNodeStream(parser.pinAssign().getTree()));
				ast.pinAssign((DesignUnit) params[0], (String) params[1]);
				object_return = params[0];
				break;
			case PhdlAST.SUBINST_DECL:
				ast = new PhdlAST(new CommonTreeNodeStream(parser.designDecl().getTree()));
				ast.subInstDecl((DesignUnit) params[0]);
				object_return = params[0];
				break;
			case PhdlAST.SUBATTR_ASSIGN:
				ast = new PhdlAST(new CommonTreeNodeStream(parser.connectDecl().getTree()));
				ast.portDecl((DesignUnit) params[0]);
				object_return = params[0];
				break;
			case PhdlAST.PORT_ASSIGN:
				ast = new PhdlAST(new CommonTreeNodeStream(parser.portAssign().getTree()));
				ast.portAssign((DesignUnit) params[0], (String) params[1]);
				object_return = params[0];
				break;
			case PhdlAST.CONNECT_ASSIGN:
				ast = new PhdlAST(new CommonTreeNodeStream(parser.connectAssign().getTree()));
				ast.connectAssign((DesignUnit) params[0]);
				object_return = params[0];
				break;
			case PhdlAST.CONCAT_LIST:
			case PhdlAST.CONCAT_REPL:
			case PhdlAST.CONCAT_OPEN:
				ast = new PhdlAST(new CommonTreeNodeStream(parser.concat().getTree()));
				object_return = ast.concat((DesignUnit) params[0]);
				break;
			case PhdlAST.OPERAND:
				ast = new PhdlAST(new CommonTreeNodeStream(parser.operand().getTree()));
				object_return = ast.operand();
				break;
			case PhdlAST.NAME:
				ast = new PhdlAST(new CommonTreeNodeStream(parser.name().getTree()));
				object_return = ast.name();
				break;
			case PhdlAST.BOUNDS:
			case PhdlAST.INDICES:
				ast = new PhdlAST(new CommonTreeNodeStream(parser.index().getTree()));
				object_return = ast.index();
				break;
			case PhdlAST.WIDTH:
				ast = new PhdlAST(new CommonTreeNodeStream(parser.width().getTree()));
				object_return = ast.width();
				break;
			case PhdlAST.PIN_LIST:
				ast = new PhdlAST(new CommonTreeNodeStream(parser.pinList().getTree()));
				object_return = ast.pinList();
				break;
			case PhdlAST.PIN_TYPE:
				ast = new PhdlAST(new CommonTreeNodeStream(parser.pinType().getTree()));
				object_return = ast.pinType();
				break;
			case PhdlAST.INFO_DECL:
				ast = new PhdlAST(new CommonTreeNodeStream(parser.infoDecl().getTree()));
				object_return = ast.infoDecl();
				break;
			default:
				System.err.println("Invalid Rule to Test");
			}
		} catch (RecognitionException e) {
			e.printStackTrace();
			return null;
		}
		return object_return;
	}

	/**
	 * unitTest
	 * Currently this is only testing for correct behavior with correct input.
	 * Incorrect inputs need to be tested.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static boolean unitTest() {
		boolean success = true;
		Object object_return;
		int testNum = 0;
		/**
		 * Test 1
		 * PinType
		 */
		testNum++;
		object_return = getRuleObject(PhdlAST.PIN_TYPE, "PIN", null);
		if ((PinType) object_return != PinType.PIN) {
			success &= TestDriver.displayError(testNum, "PinType", "Incorrect pin type", "PIN",
				object_return.toString());
		}

		object_return = getRuleObject(PhdlAST.PIN_TYPE, "INPIN", null);
		if ((PinType) object_return != PinType.INPIN) {
			success &= TestDriver.displayError(testNum, "PinType", "Incorrect pin type", "INPIN",
				object_return.toString());
		}

		object_return = getRuleObject(PhdlAST.PIN_TYPE, "OUTPIN", null);
		if ((PinType) object_return != PinType.OUTPIN) {
			success &= TestDriver.displayError(testNum, "PinType", "Incorrect pin type", "OUTPIN",
				object_return.toString());
		}

		object_return = getRuleObject(PhdlAST.PIN_TYPE, "IOPIN", null);
		if ((PinType) object_return != PinType.IOPIN) {
			success &= TestDriver.displayError(testNum, "PinType", "Incorrect pin type", "IOPIN",
				object_return.toString());
		}

		object_return = getRuleObject(PhdlAST.PIN_TYPE, "PWRPIN", null);
		if ((PinType) object_return != PinType.PWRPIN) {
			success &= TestDriver.displayError(testNum, "PinType", "Incorrect pin type", "PWRPIN",
				object_return.toString());
		}

		object_return = getRuleObject(PhdlAST.PIN_TYPE, "SUPPIN", null);
		if ((PinType) object_return != PinType.SUPPIN) {
			success &= TestDriver.displayError(testNum, "PinType", "Incorrect pin type", "SUPPIN",
				object_return.toString());
		}

		/**
		 * Test 2
		 * PinList
		 */
		testNum++;
		object_return = getRuleObject(PhdlAST.PIN_LIST, "{3a,8b,1003,abc}", null);
		List<String> expected2 = new ArrayList<String>();
		expected2.add("3a");
		expected2.add("8b");
		expected2.add("1003");
		expected2.add("abc");
		List<String> actual2 = (List<String>) object_return;
		if (!TestDriver.isEqual(actual2, expected2)) {
			success &= TestDriver.displayError(testNum, "pinList", "Incorrect List",
				TestDriver.collToString(expected2), TestDriver.collToString(actual2));
		} else if (!TestDriver.sameOrdering(actual2, expected2)) {
			success &= TestDriver.displayError(testNum, "pinList", "Incorrect Ordering",
				TestDriver.collToString(expected2), TestDriver.collToString(actual2));
		}

		/**
		 * Test 3
		 * width
		 */
		testNum++;
		object_return = getRuleObject(PhdlAST.WIDTH, "3:5", null);
		List<Integer> expected3 = new ArrayList<Integer>();
		expected3.add(3);
		expected3.add(4);
		expected3.add(5);
		List<Integer> actual3 = (List<Integer>) object_return;
		if (!TestDriver.isEqual(actual3, expected3)) {
			success &= TestDriver.displayError(testNum, "width", "Incorrect List", TestDriver.collToString(expected3),
				TestDriver.collToString(actual3));
		} else if (!TestDriver.sameOrdering(actual3, expected3)) {
			success &= TestDriver.displayError(testNum, "width", "Incorrect Ordering",
				TestDriver.collToString(expected3), TestDriver.collToString(actual3));
		}

		object_return = getRuleObject(PhdlAST.WIDTH, "9:3", null);
		actual3 = (List<Integer>) object_return;
		expected3.clear();
		expected3.add(9);
		expected3.add(8);
		expected3.add(7);
		expected3.add(6);
		expected3.add(5);
		expected3.add(4);
		expected3.add(3);
		if (!TestDriver.isEqual(actual3, expected3)) {
			success &= TestDriver.displayError(testNum, "width", "Incorrect List", TestDriver.collToString(expected3),
				TestDriver.collToString(actual3));
		} else if (!TestDriver.sameOrdering(actual3, expected3)) {
			success &= TestDriver.displayError(testNum, "width", "Incorrect Ordering",
				TestDriver.collToString(expected3), TestDriver.collToString(actual3));
		}

		/**
		 * Test 4
		 * index
		 */
		testNum++;
		object_return = getRuleObject(PhdlAST.BOUNDS, "6:3", null);
		List<Integer> actual4 = (List<Integer>) object_return;
		List<Integer> expected4 = new ArrayList<Integer>();
		expected4.add(6);
		expected4.add(5);
		expected4.add(4);
		expected4.add(3);
		if (!TestDriver.isEqual(actual4, expected4)) {
			success &= TestDriver.displayError(testNum, "index", "Incorrect List", TestDriver.collToString(expected4),
				TestDriver.collToString(actual4));
		} else if (!TestDriver.sameOrdering(actual4, expected4)) {
			success &= TestDriver.displayError(testNum, "index", "Incorrect Ordering",
				TestDriver.collToString(expected4), TestDriver.collToString(actual4));
		}

		object_return = getRuleObject(PhdlAST.INDICES, "8,1", null);
		actual4 = (List<Integer>) object_return;
		expected4.clear();
		expected4.add(8);
		expected4.add(1);
		if (!TestDriver.isEqual(actual4, expected4)) {
			success &= TestDriver.displayError(testNum, "index", "Incorrect List", TestDriver.collToString(expected4),
				TestDriver.collToString(actual4));
		} else if (!TestDriver.sameOrdering(actual4, expected4)) {
			success &= TestDriver.displayError(testNum, "index", "Incorrect Ordering",
				TestDriver.collToString(expected4), TestDriver.collToString(actual4));
		}

		object_return = getRuleObject(PhdlAST.INDICES, "3,1,7,0,5", null);
		actual4 = (List<Integer>) object_return;
		expected4.clear();
		expected4.add(3);
		expected4.add(1);
		expected4.add(7);
		expected4.add(0);
		expected4.add(5);
		if (!TestDriver.isEqual(actual4, expected4)) {
			success &= TestDriver.displayError(testNum, "index", "Incorrect List", TestDriver.collToString(expected4),
				TestDriver.collToString(actual4));
		} else if (!TestDriver.sameOrdering(actual4, expected4)) {
			success &= TestDriver.displayError(testNum, "index", "Incorrect Ordering",
				TestDriver.collToString(expected4), TestDriver.collToString(actual4));
		}

		/*
		 *	Explanation for commented code below
		 *	-------------------------------------
		 *	There is an serious problem with testing atomic parser rules in ANTLR.
		 *	For some reason, there is a NoViableOptionException that is thrown before
		 *	reaching the actual input text.  There is little explanation for this,
		 *	but it is speculated that somehow it is recognizing some extra character
		 *	(possibly EOF) and therefore indicates that the rule cannot find a viable
		 *	path that matches the input.
		 *
		 *	To still test for completeness, we will add extra cases to the rules
		 *	that depend on index that test specifically that single indices are
		 *	acceptable.
		 */
		/*
			object_return = getRuleObject(PhdlAST.INDICES, "3", null);
			actual4 = (List<Integer>)object_return;
			expected4.clear();
			expected4.add(3);
			if (!TestDriver.isEqual(actual4, expected4)) {
				success &= TestDriver.displayError(testNum, "index", "Incorrect List", TestDriver.collToString(expected4), TestDriver.collToString(actual4));
			}
			else if (!TestDriver.sameOrdering(actual4, expected4)) {
				success &= TestDriver.displayError(testNum, "index", "Incorrect Ordering", TestDriver.collToString(expected4), TestDriver.collToString(actual4));
			}
		*/

		/**
		 * Test 5
		 * name
		 */
		/*
		testNum++;
		Object[] object_return_array = (Object[]) getRuleObject(PhdlAST.NAME, "my_name", null);
		CommonTree actual5_1_tree = (CommonTree) object_return_array[0];
		String actual5_1 = actual5_1_tree.getText();
		String expected5_1 = "my_name";
		List<Integer> actual5_2 = (List<Integer>) object_return_array[1];
		List<Integer> expected5_2 = new ArrayList<Integer>();
		//TODO: add list of indices

		if (!TestDriver.isEqual(actual5_2, expected5_2)) {
			success &= TestDriver.displayError(testNum, "width", "Incorrect List",
				TestDriver.collToString(expected5_2), TestDriver.collToString(actual5_2));
		} else if (!TestDriver.sameOrdering(actual5_2, expected5_2)) {
			success &= TestDriver.displayError(testNum, "width", "Incorrect Ordering",
				TestDriver.collToString(expected5_2), TestDriver.collToString(actual5_2));
		}
		*/

		return success;
	}
}
