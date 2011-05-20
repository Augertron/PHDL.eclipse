package testPackage;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

public class TestExpr {

	public static void main(String[] args) throws RecognitionException {
		CharStream stream = new ANTLRStringStream(
				"x=3\ny=2\nz=x*2+y*5\n3+z*7\n");
		ExprLexer lexer = new ExprLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ExprParser parser = new ExprParser(tokenStream);
		parser.prog();
		System.out.println("ok");
	}
}
