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
import java.util.HashSet;
import java.util.Iterator;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.DOTTreeGenerator;
import org.antlr.stringtemplate.StringTemplate;

import phdl.PHDLParser.sourceText_return;

/**
 * A class to test the the ANTLR PHDL grammar. It accepts a *.phdl source text
 * file as its only argument and obtains a design from the ANTLR generated
 * tools. It then prints out the design, and outputs a dotty file representation
 * of the node stream of the abstract syntax tree.
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 * 
 */
public class PHDLTest {

	public static void main(String[] args) throws RecognitionException {

		// the parsed design
		HashSet<PHDLDesign> designs = new HashSet<PHDLDesign>();

		// the character stream
		CharStream cs = null;

		try {
			// make an ANTLR stream from the file passed in
			cs = new ANTLRFileStream(args[0]);
		} catch (IOException e) {
			System.out.println("Problem reading file:" + args[0]);
		}

		// lex the character stream
		PHDLLexer l = new PHDLLexer(cs);

		// make a stream of tokens
		TokenStream ts = new CommonTokenStream(l);

		// parse the tokens
		PHDLParser p = new PHDLParser(ts);

		// obtain a tree of the tokens
		sourceText_return sourceTree = p.sourceText();

		// convert the tree to a stream of nodes
		CommonTreeNodeStream ns = new CommonTreeNodeStream(sourceTree.tree);

		// print out the stream of nodes
		// System.out.println("\n" + sourceText.tree.toStringTree() + "\n");

		// traverse the stream of nodes
		PHDLWalker walker = new PHDLWalker(ns);

		// obtain the designs and display them
		designs = walker.sourceText();

		Iterator<PHDLDesign> dIter = designs.iterator();
		while (dIter.hasNext())
			System.out.println(dIter.next().toString());

		System.out.println("ok");

		// convert token tree to a dotty formatted string
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
		}
		try {
			dotty.write(fileData);
			dotty.close();
		} catch (IOException e) {
			System.out.println("Prolem writing dotty file.");
		}
	}
}