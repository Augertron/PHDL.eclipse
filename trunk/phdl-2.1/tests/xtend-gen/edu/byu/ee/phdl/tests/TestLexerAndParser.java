package edu.byu.ee.phdl.tests;

import edu.byu.ee.phdl.PhdlInjectorProvider;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2;
import org.eclipselabs.xtext.utils.unittesting.XtextTest;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(value = PhdlInjectorProvider.class)
@RunWith(value = XtextRunner2.class)
@SuppressWarnings("all")
public class TestLexerAndParser extends XtextTest {
  private static Logger LOGGER = new Function0<Logger>() {
    public Logger apply() {
      Logger _logger = Logger.getLogger(XtextTest.class);
      return _logger;
    }
  }.apply();
  
  @Test
  public void test_ID() {
    Class<? extends Object> _class = this.getClass();
    String _simpleName = _class.getSimpleName();
    String _plus = ("testing method " + _simpleName);
    String _plus_1 = (_plus + ".");
    Throwable _throwable = new Throwable();
    StackTraceElement[] _stackTrace = _throwable.getStackTrace();
    StackTraceElement _get = ((List<StackTraceElement>)Conversions.doWrapArray(_stackTrace)).get(0);
    String _methodName = _get.getMethodName();
    String _plus_2 = (_plus_1 + _methodName);
    TestLexerAndParser.LOGGER.info(_plus_2);
    this.testTerminal("a", "ID");
    this.testTerminal("aBc", "ID");
    this.testTerminal("aBc123", "ID");
    this.testTerminal("_aBc123_", "ID");
    this.testNotTerminal("1", "ID");
    this.testNotTerminal("123abc", "ID");
    this.testNotTerminal("abc-123", "ID");
    this.testNotTerminal("#abc", "ID");
    this.testNotTerminal("$abc", "ID");
  }
  
  @Test
  public void test_INT() {
    Class<? extends Object> _class = this.getClass();
    String _simpleName = _class.getSimpleName();
    String _plus = ("testing method " + _simpleName);
    String _plus_1 = (_plus + ".");
    Throwable _throwable = new Throwable();
    StackTraceElement[] _stackTrace = _throwable.getStackTrace();
    StackTraceElement _get = ((List<StackTraceElement>)Conversions.doWrapArray(_stackTrace)).get(0);
    String _methodName = _get.getMethodName();
    String _plus_2 = (_plus_1 + _methodName);
    TestLexerAndParser.LOGGER.info(_plus_2);
    this.testTerminal("0", "INT");
    this.testTerminal("9", "INT");
    this.testTerminal("100000", "INT");
    this.testNotTerminal("01", "INT");
    this.testNotTerminal("000001", "INT");
    this.testNotTerminal("-1", "INT");
    this.testNotTerminal("0.01", "INT");
    this.testNotTerminal("3.5", "INT");
  }
  
  @Test
  public void test_PINNUM() {
    Class<? extends Object> _class = this.getClass();
    String _simpleName = _class.getSimpleName();
    String _plus = ("testing method " + _simpleName);
    String _plus_1 = (_plus + ".");
    Throwable _throwable = new Throwable();
    StackTraceElement[] _stackTrace = _throwable.getStackTrace();
    StackTraceElement _get = ((List<StackTraceElement>)Conversions.doWrapArray(_stackTrace)).get(0);
    String _methodName = _get.getMethodName();
    String _plus_2 = (_plus_1 + _methodName);
    TestLexerAndParser.LOGGER.info(_plus_2);
    this.testTerminal("123aBc", "PINNUM");
    this.testTerminal("+5V", "PINNUM");
    this.testTerminal("-5V", "PINNUM");
    this.testTerminal("@R0603", "PINNUM");
    this.testTerminal("$PAD", "PINNUM");
    this.testTerminal("!ENABLE", "PINNUM");
    this.testNotTerminal("%", "PINNUM");
    this.testNotTerminal("#", "PINNUM");
  }
  
  @Test
  public void test_STRING() {
    Class<? extends Object> _class = this.getClass();
    String _simpleName = _class.getSimpleName();
    String _plus = ("testing method " + _simpleName);
    String _plus_1 = (_plus + ".");
    Throwable _throwable = new Throwable();
    StackTraceElement[] _stackTrace = _throwable.getStackTrace();
    StackTraceElement _get = ((List<StackTraceElement>)Conversions.doWrapArray(_stackTrace)).get(0);
    String _methodName = _get.getMethodName();
    String _plus_2 = (_plus_1 + _methodName);
    TestLexerAndParser.LOGGER.info(_plus_2);
    this.testTerminal("\'This is a string\'", "STRING");
    this.testTerminal("\'This is a string with \" a double quote inside\'", "STRING");
    this.testTerminal("\"This is a string with \' a single quote inside \"", "STRING");
    this.testNotTerminal("\'\\This is not a valid \\string\'", "STRING");
  }
  
  @Test
  public void test_ML_COMMENT() {
    Class<? extends Object> _class = this.getClass();
    String _simpleName = _class.getSimpleName();
    String _plus = ("testing method " + _simpleName);
    String _plus_1 = (_plus + ".");
    Throwable _throwable = new Throwable();
    StackTraceElement[] _stackTrace = _throwable.getStackTrace();
    StackTraceElement _get = ((List<StackTraceElement>)Conversions.doWrapArray(_stackTrace)).get(0);
    String _methodName = _get.getMethodName();
    String _plus_2 = (_plus_1 + _methodName);
    TestLexerAndParser.LOGGER.info(_plus_2);
    this.testTerminal("/* This \\r\\n is a multi-line \\r\\n comment */", "ML_COMMENT");
    this.testTerminal("/** Does it work for Javadoc? */", "ML_COMMENT");
    this.testNotTerminal("/* Unclosed comment!!!", "ML_COMMENT");
  }
  
  @Test
  public void test_SL_COMMENT() {
    Class<? extends Object> _class = this.getClass();
    String _simpleName = _class.getSimpleName();
    String _plus = ("testing method " + _simpleName);
    String _plus_1 = (_plus + ".");
    Throwable _throwable = new Throwable();
    StackTraceElement[] _stackTrace = _throwable.getStackTrace();
    StackTraceElement _get = ((List<StackTraceElement>)Conversions.doWrapArray(_stackTrace)).get(0);
    String _methodName = _get.getMethodName();
    String _plus_2 = (_plus_1 + _methodName);
    TestLexerAndParser.LOGGER.info(_plus_2);
    this.testTerminal("// This is a single line comment", "SL_COMMENT");
    this.testNotTerminal("This is not a comment.", "SL_COMMENT");
  }
  
  @Test
  public void test_PhdlID() {
    Class<? extends Object> _class = this.getClass();
    String _simpleName = _class.getSimpleName();
    String _plus = ("testing method " + _simpleName);
    String _plus_1 = (_plus + ".");
    Throwable _throwable = new Throwable();
    StackTraceElement[] _stackTrace = _throwable.getStackTrace();
    StackTraceElement _get = ((List<StackTraceElement>)Conversions.doWrapArray(_stackTrace)).get(0);
    String _methodName = _get.getMethodName();
    String _plus_2 = (_plus_1 + _methodName);
    TestLexerAndParser.LOGGER.info(_plus_2);
    this.testParserRule("1", "PhdlID");
    this.testParserRule("a", "PhdlID");
    this.testParserRule("a1", "PhdlID");
    this.testParserRule("1a", "PhdlID");
    this.testParserRule("+5V", "PhdlID");
    this.testParserRule("-VSS", "PhdlID");
    this.testParserRule("$NET", "PhdlID");
    this.testParserRule("!ENABLE", "PhdlID");
    this.testParserRule("CS/EN", "PhdlID");
  }
  
  @Test
  public void test_QualifiedName() {
    Class<? extends Object> _class = this.getClass();
    String _simpleName = _class.getSimpleName();
    String _plus = ("testing method " + _simpleName);
    String _plus_1 = (_plus + ".");
    Throwable _throwable = new Throwable();
    StackTraceElement[] _stackTrace = _throwable.getStackTrace();
    StackTraceElement _get = ((List<StackTraceElement>)Conversions.doWrapArray(_stackTrace)).get(0);
    String _methodName = _get.getMethodName();
    String _plus_2 = (_plus_1 + _methodName);
    TestLexerAndParser.LOGGER.info(_plus_2);
    this.testParserRule("abc123.123abc", "QualifiedName");
  }
  
  @Test
  public void QualifiedNameWithWildCard() {
    Class<? extends Object> _class = this.getClass();
    String _simpleName = _class.getSimpleName();
    String _plus = ("testing method " + _simpleName);
    String _plus_1 = (_plus + ".");
    Throwable _throwable = new Throwable();
    StackTraceElement[] _stackTrace = _throwable.getStackTrace();
    StackTraceElement _get = ((List<StackTraceElement>)Conversions.doWrapArray(_stackTrace)).get(0);
    String _methodName = _get.getMethodName();
    String _plus_2 = (_plus_1 + _methodName);
    TestLexerAndParser.LOGGER.info(_plus_2);
    this.testParserRule("abc123.*", "QualifiedNameWithWildCard");
  }
  
  @Test
  public void test_keywords() {
    Class<? extends Object> _class = this.getClass();
    String _simpleName = _class.getSimpleName();
    String _plus = ("testing method " + _simpleName);
    String _plus_1 = (_plus + ".");
    Throwable _throwable = new Throwable();
    StackTraceElement[] _stackTrace = _throwable.getStackTrace();
    StackTraceElement _get = ((List<StackTraceElement>)Conversions.doWrapArray(_stackTrace)).get(0);
    String _methodName = _get.getMethodName();
    String _plus_2 = (_plus_1 + _methodName);
    TestLexerAndParser.LOGGER.info(_plus_2);
    this.testKeyword("this");
    this.testKeyword("open");
    this.testKeyword("combine");
    this.testKeyword("newattr");
    this.testKeyword("attr");
    this.testKeyword("subinst");
    this.testKeyword("inst");
    this.testKeyword("of");
    this.testKeyword("net");
    this.testKeyword("port");
    this.testKeyword("design");
    this.testKeyword("subdesign");
    this.testKeyword("info");
    this.testKeyword("device");
    this.testKeyword("import");
    this.testKeyword("package");
    this.testKeyword("pin");
    this.testKeyword("inpin");
    this.testKeyword("outpin");
    this.testKeyword("iopin");
    this.testKeyword("pwrpin");
    this.testKeyword("suppin");
    this.testKeyword("ocpin");
    this.testKeyword("oepin");
    this.testKeyword("tripin");
    this.testKeyword("passpin");
    this.testKeyword("ncpin");
    this.testKeyword(".");
    this.testKeyword(";");
    this.testKeyword("*");
    this.testKeyword("{");
    this.testKeyword("}");
    this.testKeyword("(");
    this.testKeyword(")");
    this.testKeyword("[");
    this.testKeyword("]");
    this.testKeyword("<");
    this.testKeyword(">");
    this.testKeyword(":");
    this.testKeyword(",");
    this.testKeyword("&");
    this.testKeyword("=");
  }
  
  @Test
  public void test_Qualifier() {
    Class<? extends Object> _class = this.getClass();
    String _simpleName = _class.getSimpleName();
    String _plus = ("testing method " + _simpleName);
    String _plus_1 = (_plus + ".");
    Throwable _throwable = new Throwable();
    StackTraceElement[] _stackTrace = _throwable.getStackTrace();
    StackTraceElement _get = ((List<StackTraceElement>)Conversions.doWrapArray(_stackTrace)).get(0);
    String _methodName = _get.getMethodName();
    String _plus_2 = (_plus_1 + _methodName);
    TestLexerAndParser.LOGGER.info(_plus_2);
    this.testParserRule("this(0).", "Qualifier");
    this.testParserRule("this(1).", "Qualifier");
    this.testParserRuleErrors("this(a).", "Qualifier");
  }
  
  @Test
  public void test_Array() {
    Class<? extends Object> _class = this.getClass();
    String _simpleName = _class.getSimpleName();
    String _plus = ("testing method " + _simpleName);
    String _plus_1 = (_plus + ".");
    Throwable _throwable = new Throwable();
    StackTraceElement[] _stackTrace = _throwable.getStackTrace();
    StackTraceElement _get = ((List<StackTraceElement>)Conversions.doWrapArray(_stackTrace)).get(0);
    String _methodName = _get.getMethodName();
    String _plus_2 = (_plus_1 + _methodName);
    TestLexerAndParser.LOGGER.info(_plus_2);
    this.testParserRule("(1:0)", "Array");
    this.testParserRuleErrors("[1:0]", "Array");
    this.testParserRuleErrors("(a:b)", "Array");
  }
  
  @Test
  public void test_Vector() {
    Class<? extends Object> _class = this.getClass();
    String _simpleName = _class.getSimpleName();
    String _plus = ("testing method " + _simpleName);
    String _plus_1 = (_plus + ".");
    Throwable _throwable = new Throwable();
    StackTraceElement[] _stackTrace = _throwable.getStackTrace();
    StackTraceElement _get = ((List<StackTraceElement>)Conversions.doWrapArray(_stackTrace)).get(0);
    String _methodName = _get.getMethodName();
    String _plus_2 = (_plus_1 + _methodName);
    TestLexerAndParser.LOGGER.info(_plus_2);
    this.testParserRule("[1:0]", "Vector");
    this.testParserRuleErrors("(1:0)", "Vector");
    this.testParserRuleErrors("[a:b]", "Vector");
  }
  
  @Test
  public void test_Slices() {
    Class<? extends Object> _class = this.getClass();
    String _simpleName = _class.getSimpleName();
    String _plus = ("testing method " + _simpleName);
    String _plus_1 = (_plus + ".");
    Throwable _throwable = new Throwable();
    StackTraceElement[] _stackTrace = _throwable.getStackTrace();
    StackTraceElement _get = ((List<StackTraceElement>)Conversions.doWrapArray(_stackTrace)).get(0);
    String _methodName = _get.getMethodName();
    String _plus_2 = (_plus_1 + _methodName);
    TestLexerAndParser.LOGGER.info(_plus_2);
    this.testParserRule("[1:0]", "Slices");
    this.testParserRule("[3,2,1,0]", "Slices");
    this.testParserRule("[1]", "Slices");
  }
  
  @Test
  public void test_Indices() {
    Class<? extends Object> _class = this.getClass();
    String _simpleName = _class.getSimpleName();
    String _plus = ("testing method " + _simpleName);
    String _plus_1 = (_plus + ".");
    Throwable _throwable = new Throwable();
    StackTraceElement[] _stackTrace = _throwable.getStackTrace();
    StackTraceElement _get = ((List<StackTraceElement>)Conversions.doWrapArray(_stackTrace)).get(0);
    String _methodName = _get.getMethodName();
    String _plus_2 = (_plus_1 + _methodName);
    TestLexerAndParser.LOGGER.info(_plus_2);
    this.testParserRule("(1:0)", "Indices");
    this.testParserRule("(3,2,1,0)", "Indices");
    this.testParserRule("(1)", "Indices");
  }
}
