package phdl;

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import phdl.PHDLParser.sourceText_return;

public class PHDLTest {

	public static void main(String[] args) throws RecognitionException {

		CharStream stream;
		try {
			stream = new ANTLRFileStream(args[0]);
			PHDLLexer lexer = new PHDLLexer(stream);
			TokenStream tokenStream = new CommonTokenStream(lexer);
			PHDLParser parser = new PHDLParser(tokenStream);
			sourceText_return sourceText = parser.sourceText();
			System.out.println(sourceText.tree.toStringTree());
			System.out.println("ok");
		} catch (IOException e) {
			System.out.println("Problem reading file:" + args[0]);
		}
	}
}