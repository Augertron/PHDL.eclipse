package testPackage;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

public class Test2 {

	public static void main(String[] args) throws RecognitionException {
		CharStream stream = new ANTLRStringStream("5+4");
		Sample2Lexer lexer = new Sample2Lexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		Sample2Parser parser = new Sample2Parser(tokenStream);
		int result = parser.evaluator();
		System.out.println("ok - result is " + result);
	}
}
