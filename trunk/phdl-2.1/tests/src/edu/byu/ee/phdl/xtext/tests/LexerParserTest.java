package edu.byu.ee.phdl.xtext.tests;

import org.apache.log4j.Logger;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2;
import org.eclipselabs.xtext.utils.unittesting.XtextTest;
import org.junit.Test;
import org.junit.runner.RunWith;

import edu.byu.ee.phdl.PhdlInjectorProvider;

@InjectWith(PhdlInjectorProvider.class)
@RunWith(XtextRunner2.class)
public class LexerParserTest extends XtextTest {

	private static Logger LOGGER = Logger.getLogger(XtextTest.class);

	@Test
	public void testArray() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "."
				+ new Throwable().getStackTrace()[0].getMethodName());
		testParserRule("(1:0)", "Array");
		testParserRuleErrors("[1:0]", "Array");
		testParserRuleErrors("(a:b)", "Array");
	}

	@Test
	public void testID() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "."
				+ new Throwable().getStackTrace()[0].getMethodName());
		// valid identifiers
		testTerminal("a", "ID");
		testTerminal("aBc", "ID");
		testTerminal("aBc123", "ID");
		testTerminal("_aBc123_", "ID");

		// invalid identifiers
		testNotTerminal("1", "ID");
		testNotTerminal("123abc", "ID");
		testNotTerminal("abc-123", "ID");
		testNotTerminal("#abc", "ID");
		testNotTerminal("$abc", "ID");
	}

	@Test
	public void testIndices() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "."
				+ new Throwable().getStackTrace()[0].getMethodName());
		testParserRule("(1:0)", "Indices");
		testParserRule("(3,2,1,0)", "Indices");
		testParserRule("(1)", "Indices");
	}

	@Test
	public void testINT() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "."
				+ new Throwable().getStackTrace()[0].getMethodName());
		// valid integers
		testTerminal("0", "INT");
		testTerminal("9", "INT");
		testTerminal("100000", "INT");

		// invalid integers
		testNotTerminal("01", "INT");
		testNotTerminal("000001", "INT");
		testNotTerminal("-1", "INT");
		testNotTerminal("0.01", "INT");
		testNotTerminal("3.5", "INT");
	}

	@Test
	public void testKeywords() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "."
				+ new Throwable().getStackTrace()[0].getMethodName());
		// general keywords
		testKeyword("this");
		testKeyword("open");
		testKeyword("combine");
		testKeyword("attr");
		testKeyword("subinst");
		testKeyword("inst");
		testKeyword("of");
		testKeyword("net");
		testKeyword("port");
		testKeyword("design");
		testKeyword("subdesign");
		testKeyword("info");
		testKeyword("device");
		testKeyword("import");
		testKeyword("package");
		// pin type keywords
		testKeyword("pin");
		testKeyword("inpin");
		testKeyword("outpin");
		testKeyword("iopin");
		testKeyword("pwrpin");
		testKeyword("suppin");
		testKeyword("ocpin");
		testKeyword("oepin");
		testKeyword("tripin");
		testKeyword("passpin");
		testKeyword("ncpin");
		// puncuation keywords
		testKeyword(".");
		testKeyword(";");
		testKeyword("*");
		testKeyword("{");
		testKeyword("}");
		testKeyword("(");
		testKeyword(")");
		testKeyword("[");
		testKeyword("]");
		testKeyword("<");
		testKeyword(">");
		testKeyword(":");
		testKeyword(",");
		testKeyword("&");
		testKeyword("=");
	}

	@Test
	public void testML_COMMENT() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "."
				+ new Throwable().getStackTrace()[0].getMethodName());
		testTerminal("/* This \\r\\n is a multi-line \\r\\n comment */", "ML_COMMENT");
		testTerminal("/** Does it work for Javadoc? */", "ML_COMMENT");
		testNotTerminal("/* Unclosed comment!!!", "ML_COMMENT");
	}

	@Test
	public void testPhdlID() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "."
				+ new Throwable().getStackTrace()[0].getMethodName());
		testParserRule("1", "PhdlID");
		testParserRule("a", "PhdlID");
		testParserRule("a1", "PhdlID");
		testParserRule("1a", "PhdlID");
		testParserRule("+5V", "PhdlID");
		testParserRule("-VSS", "PhdlID");
		testParserRule("$NET", "PhdlID");
		testParserRule("!ENABLE", "PhdlID");
		testParserRule("CS/EN", "PhdlID");
	}

	@Test
	public void testPINNUM() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "."
				+ new Throwable().getStackTrace()[0].getMethodName());
		// valid pinnums
		testTerminal("123aBc", "PINNUM");
		testTerminal("+5V", "PINNUM");
		testTerminal("-5V", "PINNUM");
		testTerminal("@R0603", "PINNUM");
		testTerminal("$PAD", "PINNUM");
		testTerminal("!ENABLE", "PINNUM");

		// invalid pinnums
		testNotTerminal("%", "PINNUM");
		testNotTerminal("#", "PINNUM");
	}

	@Test
	public void testQualifiedName() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "."
				+ new Throwable().getStackTrace()[0].getMethodName());
		testParserRule("abc123.123abc", "QualifiedName");
	}

	@Test
	public void testQualifiedNameWithWildcard() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "."
				+ new Throwable().getStackTrace()[0].getMethodName());
		testParserRule("abc123.*", "QualifiedNameWithWildCard");
	}

	@Test
	public void testQualifier() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "."
				+ new Throwable().getStackTrace()[0].getMethodName());
		testParserRule("this(0).", "Qualifier");
		testParserRule("this(1).", "Qualifier");
		testParserRuleErrors("this(a).", "Qualifier");
	}

	@Test
	public void testSL_COMMENT() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "."
				+ new Throwable().getStackTrace()[0].getMethodName());
		testTerminal("// This is a single line comment", "SL_COMMENT");
		testNotTerminal("This is not a comment.", "SL_COMMENT");
	}

	@Test
	public void testSlices() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "."
				+ new Throwable().getStackTrace()[0].getMethodName());
		testParserRule("[1:0]", "Slices");
		testParserRule("[3,2,1,0]", "Slices");
		testParserRule("[1]", "Slices");
	}

	@Test
	public void testSTRING() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "."
				+ new Throwable().getStackTrace()[0].getMethodName());
		testTerminal("'This is a string'", "STRING");
		testTerminal("'This is a string with \" a double quote inside'", "STRING");
		testTerminal("\"This is a string with ' a single quote inside \"", "STRING");
		testNotTerminal("'\\This is not a valid \\string'", "STRING");
	}

	@Test
	public void testVector() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "."
				+ new Throwable().getStackTrace()[0].getMethodName());
		testParserRule("[1:0]", "Vector");
		testParserRuleErrors("(1:0)", "Vector");
		testParserRuleErrors("[a:b]", "Vector");
	}
}