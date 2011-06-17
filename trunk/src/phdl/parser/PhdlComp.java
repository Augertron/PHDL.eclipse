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

package phdl.parser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.HashSet;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.DOTTreeGenerator;
import org.antlr.stringtemplate.StringTemplate;

import phdl.exception.InvalidTopDesignException;
import phdl.parser.PHDLParser.sourceText_return;
import phdl.analyzer.DesignHierarchy;

/**
 * The entry point of the phdl Compiler. It accepts *.phdl source files as
 * arguments and generates a netlist for layout tools.
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 * 
 */
public class PhdlComp {

	/**
	 * The list of errors
	 */
	static LinkedList<String> errors = new LinkedList<String>();

	/**
	 * The parsed designs from all source files
	 */
	static ParsedDesigns pd = new ParsedDesigns();

	/**
	 * The sourceText return type is a tree of tokens (used for debugging)
	 */
	static sourceText_return sourceTree = null;

	public static void main(String[] args) {

		// repeat for each source file passed in as an argument
		for (int i = 0; i < args.length; i++) {

			// attempt to make a character stream from the source file
			CharStream cs = null;
			try {
				cs = new ANTLRFileStream(args[i]);
			} catch (IOException e) {
				System.err.println("Problem reading file: " + args[0]);
				System.exit(1);
			}

			// lex this character stream and make a stream of tokens
			PHDLLexer l = new PHDLLexer(cs);
			TokenStream ts = new CommonTokenStream(l);

			// attempt to parse the stream of tokens from source text to a tree
			// and add any parse errors to the list
			PHDLParser p = new PHDLParser(ts);
			try {
				sourceTree = p.sourceText();
				if (!p.getErrors().isEmpty()) {
					for (String error : p.getErrors())
						errors.add(error);
				}
			} catch (RecognitionException e) {
				errors.add(e.getMessage());
			}

			// convert the tree of tokens to a stream of common tree nodes
			CommonTreeNodeStream ns = new CommonTreeNodeStream(sourceTree.tree);
			// set the token stream to the parser's token stream
			ns.setTokenStream(p.getTokenStream());
			// walk the stream of nodes and attempt to obtain a set of all
			// designs and add any errors if they exist
			PHDLWalker walker = new PHDLWalker(ns);
			try {
				pd = walker.sourceText(pd);
				for (String error : walker.getErrors())
					errors.add(error);
			} catch (RecognitionException e) {
				errors.add(e.getMessage());
			}

			// convert the token tree to a dotty formatted string
			DOTTreeGenerator tg = new DOTTreeGenerator();
			StringTemplate st = tg.toDOT(sourceTree.tree);
			dottyDump(args[i].replace(".phdl", ".dot"), st.toString());
		}

		// attempt to find the top level design and add a top level design error
		// if it exists
		DesignDeclaration top = null;
		try {
			top = pd.getTopDesign();
		} catch (InvalidTopDesignException e) {
			errors.add(e.getMessage());
		}

		// System.out.println(top.toString());

		// print out each design unit as it appears in memory
		for (DesignDeclaration d : pd.getDesignDecls())
			System.out.println(d.toString());

		System.out.println("ok");
		
		DesignHierarchy dh = new DesignHierarchy(top);
		makeTree(top, dh, pd);
		System.out.println(dh.toString());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// print out all errors if there were any, and exit abnormally
		if (!errors.isEmpty()) {
			for (String s : errors)
				System.out.println(s);
			System.exit(1);
		}
		
	}

	static void makeTree(DesignDeclaration top, DesignHierarchy dh, ParsedDesigns pd) {
		HashSet<SubDesignDeclaration> subs = top.getSubDesignDecls();
		for (SubDesignDeclaration s : subs) {
			DesignDeclaration child = pd.getDesign(s);
			PhdlComp.treeMaker(top, child, dh, pd);
		}
	}
	
	static void treeMaker(DesignDeclaration parent, DesignDeclaration child, DesignHierarchy dh, ParsedDesigns pd) {
		if (child == null) {
			errors.add(parent.getFileName() + " line " + parent.getLineString() + " design reference missing for subdesign " + parent.getName());
			return;
		}
		dh.addDesign(parent, child);
		HashSet<SubDesignDeclaration> subs = child.getSubDesignDecls();
		for (SubDesignDeclaration s : subs) {
			DesignDeclaration newChild = pd.getDesign(s);
			PhdlComp.treeMaker(child, newChild, dh, pd);
		}
	}

	static void dottyDump(String fileName, String fileData) {
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
	}
}