package testPackage;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

public class Test1 {

	public static void main(String[] args) throws RecognitionException {
		CharStream stream = new ANTLRStringStream("program XLSample1 =\r\n"
				+ "	constant one : Integer := 1;\r\n"
				+ "	constant two : Integer := 2;\r\n"
				+ "variable x, y, z : Integer;\r\n" + "begin\r\n"
				+ "	x := (42 + 6)*(7 + 10)-x/y;\r\n" + "	y := 10;\r\n"
				+ "end XLSample1.");
		SampleLexer lexer = new SampleLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		SampleParser parser = new SampleParser(tokenStream);
		parser.program();
		System.out.println("ok");
	}
}
