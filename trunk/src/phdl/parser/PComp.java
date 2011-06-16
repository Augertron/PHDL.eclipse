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

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.DOTTreeGenerator;
import org.antlr.stringtemplate.StringTemplate;

import phdl.parser.PHDLParser.sourceText_return;

/**
 * The entry point of the phdl Compiler. It accepts a *.phdl source text file as
 * its only argument and produces a design from the ANTLR generated tools. It
 * then prints out the design, and outputs a dotty file representation of the
 * node stream of the abstract syntax tree.
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 * 
 */
public class PComp {

	public static void main(String[] args) {

		LinkedList<String> errors = new LinkedList<String>();

		// the character stream
		CharStream cs = null;

		try {
			// make an ANTLR stream from the file passed in
			cs = new ANTLRFileStream(args[0]);
		} catch (IOException e) {
			System.err.println("Problem reading file: " + args[0]);
			System.exit(1);
		}

		// lex the character stream
		PHDLLexer l = new PHDLLexer(cs);

		// make a stream of tokens with the lexed character stream
		TokenStream ts = new CommonTokenStream(l);

		// parse the stream of tokens from the source text into a tree
		PHDLParser p = new PHDLParser(ts);

		// the sourceText return type is a tree of tokens
		sourceText_return sourceTree = null;
		try {
			// call the sourceText rule in the parser on the parser object
			sourceTree = p.sourceText();

			// check for any parse errors and add them to the list
			if (!p.getErrors().isEmpty()) {
				for (String error : p.getErrors()) {
					errors.add(error);
				}
			}
		} catch (RecognitionException e) {
			errors.add(e.getMessage());
		}

		// convert the tree of tokens to a stream of common tree nodes
		CommonTreeNodeStream ns = new CommonTreeNodeStream(sourceTree.tree);
		ns.setTokenStream(p.getTokenStream());

		// print out the stream of nodes
		// System.out.println("\n" + sourceText.tree.toStringTree() + "\n");

		// walk the stream of nodes
		PHDLWalker walker = new PHDLWalker(ns);
		ParsedDesigns pd = null;

		try {
			// obtain the set of parsed designs
			pd = walker.sourceText();

			for (String error : walker.getErrors()) {
				errors.add(error);
			}
		} catch (RecognitionException e) {
			errors.add(e.getMessage());
		}

		// if there were parse errors, print them all out and exit
		if (!errors.isEmpty()) {
			for (String s : errors) {
				System.out.println(s);
			}
			System.exit(1);
		}

		// print out each design unit as it appears in memory
		for (DesignDeclaration d : pd.getDesignDecls())
			System.out.println(d.toString());

		System.out.println("ok");

		// convert the token tree to a dotty formatted string
		DOTTreeGenerator tg = new DOTTreeGenerator();
		StringTemplate st = tg.toDOT(sourceTree.tree);

		// write the dotty formatted string to file
		dottyDump(args[0].replace(".phdl", ".dot"), st.toString());

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