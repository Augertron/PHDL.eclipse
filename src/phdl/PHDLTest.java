package phdl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.DOTTreeGenerator;
import org.antlr.stringtemplate.StringTemplate;

import phdl.PHDLParser.sourceText_return;

public class PHDLTest {

	public static void main(String[] args) throws RecognitionException {

		PHDLDesign d = null;
		CharStream stream;
		try {
			stream = new ANTLRFileStream(args[0]);
			PHDLLexer lexer = new PHDLLexer(stream);
			TokenStream tokenStream = new CommonTokenStream(lexer);
			PHDLParser parser = new PHDLParser(tokenStream);
			sourceText_return sourceText = parser.sourceText();
			CommonTreeNodeStream nodeStream = new CommonTreeNodeStream(
					sourceText.tree);
			PHDLWalker walker = new PHDLWalker(nodeStream);
			System.out.println(sourceText.tree.toStringTree());

			DOTTreeGenerator gen = new DOTTreeGenerator();
			StringTemplate st = gen.toDOT(sourceText.tree);
			dottyDump(args[0].replace(".phdl", "") + ".dot", st.toString());
			d = walker.sourceText();
			System.out.println(d.toString());
			System.out.println("ok");
		} catch (IOException e) {
			System.out.println("Problem reading file:" + args[0]);
		}
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