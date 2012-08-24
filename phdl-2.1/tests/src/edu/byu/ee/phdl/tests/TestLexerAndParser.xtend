package edu.byu.ee.phdl.tests

import org.eclipse.xtext.junit4.InjectWith
import org.junit.runner.RunWith
import org.junit.Test

import static org.junit.Assert.*
import org.eclipselabs.xtext.utils.unittesting.XtextTest
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import edu.byu.ee.phdl.PhdlInjectorProvider
import org.apache.log4j.Logger

@InjectWith(typeof(PhdlInjectorProvider))
@RunWith(typeof(XtextRunner2))
class TestLexerAndParser extends XtextTest {
	
	private static Logger LOGGER = Logger::getLogger(typeof(XtextTest));
	
	@Test
	def void test_ID() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "." + new Throwable().stackTrace.get(0).methodName)
		// valid identifiers
		testTerminal("a", "ID")
		testTerminal("aBc", "ID")
		testTerminal("aBc123", "ID")
		testTerminal("_aBc123_", "ID")
		
		// invalid identifiers
		testNotTerminal("1", "ID")
		testNotTerminal("123abc", "ID")	
		testNotTerminal("abc-123", "ID")
		testNotTerminal("#abc", "ID")
		testNotTerminal("$abc", "ID")
	}
	
	@Test
	def void test_INT() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "." + new Throwable().stackTrace.get(0).methodName)
		// valid integers
		testTerminal("0", "INT")
		testTerminal("9", "INT")
		testTerminal("100000", "INT")
		
		// invalid integers
		testNotTerminal("01", "INT")
		testNotTerminal("000001", "INT")
		testNotTerminal("-1", "INT")
		testNotTerminal("0.01", "INT")
		testNotTerminal("3.5", "INT")
	}
	
	@Test
	def void test_PINNUM() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "." + new Throwable().stackTrace.get(0).methodName)
		// valid pinnums
		testTerminal("123aBc", "PINNUM")
		testTerminal("+5V", "PINNUM")
		testTerminal("-5V", "PINNUM")
		testTerminal("@R0603", "PINNUM")
		testTerminal("$PAD", "PINNUM")
		testTerminal("!ENABLE", "PINNUM")
		
		// invalid pinnums
		testNotTerminal("%", "PINNUM")
		testNotTerminal("#", "PINNUM")
	}
	
	@Test
	def void test_STRING() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "." + new Throwable().stackTrace.get(0).methodName)
		testTerminal("'This is a string'", "STRING")
		testTerminal("'This is a string with \" a double quote inside'", "STRING")
		testTerminal("\"This is a string with ' a single quote inside \"", "STRING")
		testNotTerminal("'\\This is not a valid \\string'", "STRING")
	}
	
	@Test
	def void test_ML_COMMENT() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "." + new Throwable().stackTrace.get(0).methodName)
		testTerminal("/* This \\r\\n is a multi-line \\r\\n comment */", "ML_COMMENT")
		testTerminal("/** Does it work for Javadoc? */", "ML_COMMENT")
		testNotTerminal("/* Unclosed comment!!!", "ML_COMMENT")
	}
	
	@Test
	def void test_SL_COMMENT() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "." + new Throwable().stackTrace.get(0).methodName)
		testTerminal("// This is a single line comment", "SL_COMMENT")
		testNotTerminal("This is not a comment.", "SL_COMMENT")
	}
	
	@Test
	def void test_PhdlID() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "." + new Throwable().stackTrace.get(0).methodName)
		testParserRule("1", "PhdlID")
		testParserRule("a", "PhdlID")
		testParserRule("a1", "PhdlID")
		testParserRule("1a", "PhdlID")
		testParserRule("+5V", "PhdlID")
		testParserRule("-VSS", "PhdlID")
		testParserRule("$NET", "PhdlID")
		testParserRule("!ENABLE", "PhdlID")
		testParserRule("CS/EN", "PhdlID")
	}
	
	@Test
	def void test_QualifiedName() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "." + new Throwable().stackTrace.get(0).methodName)
		testParserRule("abc123.123abc", "QualifiedName")
	}
	
	@Test
	def void QualifiedNameWithWildCard() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "." + new Throwable().stackTrace.get(0).methodName)
		testParserRule("abc123.*", "QualifiedNameWithWildCard")
	}
	
	@Test
	def void test_keywords() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "." + new Throwable().stackTrace.get(0).methodName)
		// general keywords
		testKeyword("this")
		testKeyword("open")
		testKeyword("combine")
		testKeyword("newattr")
		testKeyword("attr")
		testKeyword("subinst")
		testKeyword("inst")
		testKeyword("of")
		testKeyword("net")
		testKeyword("port")
		testKeyword("design")
		testKeyword("subdesign")
		testKeyword("info")
		testKeyword("device")
		testKeyword("import")
		testKeyword("package")
		// pin type keywords
		testKeyword("pin")
		testKeyword("inpin")
		testKeyword("outpin")
		testKeyword("iopin")
		testKeyword("pwrpin")
		testKeyword("suppin")
		testKeyword("ocpin")
		testKeyword("oepin")
		testKeyword("tripin")
		testKeyword("passpin")
		testKeyword("ncpin")
		// puncuation keywords
		testKeyword(".")
		testKeyword(";")
		testKeyword("*")
		testKeyword("{")
		testKeyword("}")
		testKeyword("(")
		testKeyword(")")
		testKeyword("[")
		testKeyword("]")
		testKeyword("<")
		testKeyword(">")
		testKeyword(":")
		testKeyword(",")
		testKeyword("&")
		testKeyword("=")
	}
	
	@Test
	def void test_Qualifier() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "." + new Throwable().stackTrace.get(0).methodName)
		testParserRule("this(0).", "Qualifier")
		testParserRule("this(1).", "Qualifier")
		testParserRuleErrors("this(a).", "Qualifier")
	}

	@Test
	def void test_Array() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "." + new Throwable().stackTrace.get(0).methodName)
		testParserRule("(1:0)", "Array")
		testParserRuleErrors("[1:0]", "Array")
		testParserRuleErrors("(a:b)", "Array")
	}
	
	@Test
	def void test_Vector() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "." + new Throwable().stackTrace.get(0).methodName)
		testParserRule("[1:0]", "Vector")
		testParserRuleErrors("(1:0)", "Vector")
		testParserRuleErrors("[a:b]", "Vector")
	}
	
	@Test
	def void test_Slices() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "." + new Throwable().stackTrace.get(0).methodName)
		testParserRule("[1:0]", "Slices")
		testParserRule("[3,2,1,0]", "Slices")
		testParserRule("[1]", "Slices")
	}
	
	@Test
	def void test_Indices() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "." + new Throwable().stackTrace.get(0).methodName)
		testParserRule("(1:0)", "Indices")
		testParserRule("(3,2,1,0)", "Indices")
		testParserRule("(1)", "Indices")
	}
}