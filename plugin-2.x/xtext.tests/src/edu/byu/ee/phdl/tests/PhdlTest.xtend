package edu.byu.ee.phdl.tests

import org.eclipse.xtext.junit4.InjectWith
import org.junit.runner.RunWith
import com.google.inject.Inject
import org.eclipse.xtext.junit4.util.ParseHelper
import edu.byu.ee.phdl.phdl.PhdlModel
import org.junit.Test

import static org.junit.Assert.*
import org.eclipselabs.xtext.utils.unittesting.XtextTest
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import edu.byu.ee.phdl.PhdlInjectorProvider

@InjectWith(typeof(PhdlInjectorProvider))
@RunWith(typeof(XtextRunner2))
class PhdlTest extends XtextTest {
	@Inject
	ParseHelper<PhdlModel> parser
	
	@Test
	def void test_ID() {
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
		// valid integers
		testTerminal("0", "INT")
		testTerminal("9", "INT")
		testTerminal("100000", "INT")
		
		// invalid integers
		testNotTerminal("01", "INT")
		testNotTerminal("000001", "INT")
		testNotTerminal("-1", "INT")
		testNotTerminal("0.01", "INT")
	}
	
	@Test
	def void test_PINNUM() {
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
		testTerminal("'This is a string'", "STRING")
		testTerminal("'This is a string with \" a double quote inside'", "STRING")
		testTerminal("\"This is a string with ' a single quote inside \"", "STRING")
		testNotTerminal("'\\This is not a valid \\string'", "STRING")
	}
	
	@Test
	def void test_ML_COMMENT() {
		testTerminal("/* This \\r\\n is a multi-line \\r\\n comment */", "ML_COMMENT")
		testTerminal("/** Does it work for Javadoc? */", "ML_COMMENT")
		testNotTerminal("/* Unclosed comment!!!", "ML_COMMENT")
	}
	
	@Test
	def void test_SL_COMMENT() {
		testTerminal("// This is a single line comment", "SL_COMMENT")
		testNotTerminal("This is not a comment.", "SL_COMMENT")
	}
	
	@Test
	def void test_PhdlID() {
		testParserRule("1", "PhdlID")
		testParserRule("a", "PhdlID")
		testParserRule("a1", "PhdlID")
		testParserRule("1a", "PhdlID")
		testParserRule("+5V", "PhdlID")
		testParserRule("-VSS", "PhdlID")
		testParserRule("$NET", "PhdlID")
		testParserRule("!ENABLE", "PhdlID")
	}
	
	@Test
	def void test_QualifiedName() {
		testParserRule("abc123.123abc", "QualifiedName")
	}
	
	@Test
	def void QualifiedNameWithWildCard() {
		testParserRule("abc123.*", "QualifiedNameWithWildCard")
	}
	
	@Test
	def void test_keywords() {
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
		testParserRule("this(0).", "Qualifier")
		testParserRule("this(1).", "Qualifier")
		testParserRuleErrors("this(a).", "Qualifier")
	}

	@Test
	def void test_Array() {
		testParserRule("(3:0)", "Array")
		testParserRuleErrors("[3:0]", "Array")
		testParserRuleErrors("(a:b)", "Array")
	}
	
	@Test
	def void test_Vector() {
		testParserRule("[3:0]", "Vector")
		testParserRuleErrors("(3:0)", "Vector")
		testParserRuleErrors("[a:b]", "Vector")
	}
	
	@Test
	def void test_Slices() {
		testParserRule("[3:0]", "Slices")
		testParserRule("[3,2,1,0]", "Slices")
		testParserRule("[3]", "Slices")
	}
	
	@Test
	def void test_Indices() {
		testParserRule("(3:0)", "Indices")
		testParserRule("(3,2,1,0)", "Indices")
		testParserRule("(3)", "Indices")
	}
	
//	@Test
//	def void parsePhdlModel() {
//		val model = parser.parse('''
//			device resistor {
//				attr name1 = "value";
//				attr name1 = "value";
//			}
//			'''			
//		)
//		val resource = model.eResource
//		println(resource.errors.get(0).message)
//		assertTrue(resource.errors.get(0).message.equals("Duplicate attribute declaration 'name1'"));
//	}
}