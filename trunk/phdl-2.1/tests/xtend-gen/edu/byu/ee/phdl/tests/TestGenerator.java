package edu.byu.ee.phdl.tests;

import com.google.inject.Inject;
import edu.byu.ee.phdl.PhdlInjectorProvider;
import edu.byu.ee.phdl.phdl.PhdlModel;
import edu.byu.ee.phdl.utils.ExtensionCodes;
import edu.byu.ee.phdl.utils.PhdlUtils;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2;
import org.eclipselabs.xtext.utils.unittesting.XtextTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(value = PhdlInjectorProvider.class)
@RunWith(value = XtextRunner2.class)
@SuppressWarnings("all")
public class TestGenerator extends XtextTest {
  @Inject
  private IGenerator underTest;
  
  @Inject
  private ParseHelper<PhdlModel> parseHelper;
  
  private static Logger logger = new Function0<Logger>() {
    public Logger apply() {
      Logger _logger = Logger.getLogger(TestGenerator.class);
      return _logger;
    }
  }.apply();
  
  private String path = new Function0<String>() {
    public String apply() {
      Class<? extends Object> _class = TestGenerator.this.getClass();
      String _simpleName = _class.getSimpleName();
      String _plus = ("resources/" + _simpleName);
      String _plus_1 = (_plus + "/");
      return _plus_1;
    }
  }.apply();
  
  private String msgpfx = "testing generator with test-case: ";
  
  @Test
  public void test_hierarchy1() {
    try {
      Throwable _throwable = new Throwable();
      StackTraceElement[] _stackTrace = _throwable.getStackTrace();
      StackTraceElement _get = ((List<StackTraceElement>)Conversions.doWrapArray(_stackTrace)).get(0);
      String methodName = _get.getMethodName();
      Class<? extends Object> _class = this.getClass();
      String _simpleName = _class.getSimpleName();
      String _plus = (this.msgpfx + _simpleName);
      String _plus_1 = (_plus + ".");
      String _plus_2 = (_plus_1 + methodName);
      TestGenerator.logger.info(_plus_2);
      String _plus_3 = (this.path + methodName);
      String testDir = (_plus_3 + "/");
      String _plus_4 = (testDir + "test");
      String _plus_5 = (_plus_4 + ExtensionCodes.PHDL_EXT);
      String _fileToString = PhdlUtils.fileToString(_plus_5);
      PhdlModel model = this.parseHelper.parse(_fileToString);
      InMemoryFileSystemAccess _inMemoryFileSystemAccess = new InMemoryFileSystemAccess();
      InMemoryFileSystemAccess fsa = _inMemoryFileSystemAccess;
      Resource _eResource = model.eResource();
      this.underTest.doGenerate(_eResource, fsa);
      this.testOutputFileNames(fsa, "top");
      String _plus_6 = (testDir + "golden");
      this.testOutputFiles(fsa, _plus_6, "top");
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_hierarchy2() {
    try {
      Throwable _throwable = new Throwable();
      StackTraceElement[] _stackTrace = _throwable.getStackTrace();
      StackTraceElement _get = ((List<StackTraceElement>)Conversions.doWrapArray(_stackTrace)).get(0);
      String methodName = _get.getMethodName();
      Class<? extends Object> _class = this.getClass();
      String _simpleName = _class.getSimpleName();
      String _plus = (this.msgpfx + _simpleName);
      String _plus_1 = (_plus + ".");
      String _plus_2 = (_plus_1 + methodName);
      TestGenerator.logger.info(_plus_2);
      String _plus_3 = (this.path + methodName);
      String testDir = (_plus_3 + "/");
      String _plus_4 = (testDir + "test");
      String _plus_5 = (_plus_4 + ExtensionCodes.PHDL_EXT);
      String _fileToString = PhdlUtils.fileToString(_plus_5);
      PhdlModel model = this.parseHelper.parse(_fileToString);
      InMemoryFileSystemAccess _inMemoryFileSystemAccess = new InMemoryFileSystemAccess();
      InMemoryFileSystemAccess fsa = _inMemoryFileSystemAccess;
      Resource _eResource = model.eResource();
      this.underTest.doGenerate(_eResource, fsa);
      this.testOutputFileNames(fsa, "top");
      String _plus_6 = (testDir + "golden");
      this.testOutputFiles(fsa, _plus_6, "top");
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_refDes1() {
    try {
      Throwable _throwable = new Throwable();
      StackTraceElement[] _stackTrace = _throwable.getStackTrace();
      StackTraceElement _get = ((List<StackTraceElement>)Conversions.doWrapArray(_stackTrace)).get(0);
      String methodName = _get.getMethodName();
      Class<? extends Object> _class = this.getClass();
      String _simpleName = _class.getSimpleName();
      String _plus = (this.msgpfx + _simpleName);
      String _plus_1 = (_plus + ".");
      String _plus_2 = (_plus_1 + methodName);
      TestGenerator.logger.info(_plus_2);
      String _plus_3 = (this.path + methodName);
      String testDir = (_plus_3 + "/");
      String _plus_4 = (testDir + "test");
      String _plus_5 = (_plus_4 + ExtensionCodes.PHDL_EXT);
      String _fileToString = PhdlUtils.fileToString(_plus_5);
      PhdlModel model = this.parseHelper.parse(_fileToString);
      InMemoryFileSystemAccess _inMemoryFileSystemAccess = new InMemoryFileSystemAccess();
      InMemoryFileSystemAccess fsa = _inMemoryFileSystemAccess;
      Resource _eResource = model.eResource();
      this.underTest.doGenerate(_eResource, fsa);
      this.testOutputFileNames(fsa, "top");
      String _plus_6 = (testDir + "golden");
      this.testOutputFiles(fsa, _plus_6, "top");
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_refDes2() {
    try {
      Throwable _throwable = new Throwable();
      StackTraceElement[] _stackTrace = _throwable.getStackTrace();
      StackTraceElement _get = ((List<StackTraceElement>)Conversions.doWrapArray(_stackTrace)).get(0);
      String methodName = _get.getMethodName();
      Class<? extends Object> _class = this.getClass();
      String _simpleName = _class.getSimpleName();
      String _plus = (this.msgpfx + _simpleName);
      String _plus_1 = (_plus + ".");
      String _plus_2 = (_plus_1 + methodName);
      TestGenerator.logger.info(_plus_2);
      String _plus_3 = (this.path + methodName);
      String testDir = (_plus_3 + "/");
      String _plus_4 = (testDir + "test");
      String _plus_5 = (_plus_4 + ExtensionCodes.PHDL_EXT);
      String _fileToString = PhdlUtils.fileToString(_plus_5);
      PhdlModel model = this.parseHelper.parse(_fileToString);
      InMemoryFileSystemAccess _inMemoryFileSystemAccess = new InMemoryFileSystemAccess();
      InMemoryFileSystemAccess fsa = _inMemoryFileSystemAccess;
      Resource _eResource = model.eResource();
      this.underTest.doGenerate(_eResource, fsa);
      this.testOutputFileNames(fsa, "top");
      String _plus_6 = (testDir + "golden");
      this.testOutputFiles(fsa, _plus_6, "top");
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void testOutputFileNames(final InMemoryFileSystemAccess fsa, final String path) {
    Map<String,CharSequence> _files = fsa.getFiles();
    int _size = _files.size();
    Assert.assertEquals(6, _size);
    Map<String,CharSequence> _files_1 = fsa.getFiles();
    String _plus = (IFileSystemAccess.DEFAULT_OUTPUT + path);
    String _plus_1 = (_plus + ExtensionCodes.PADS_EXT);
    boolean _containsKey = _files_1.containsKey(_plus_1);
    Assert.assertTrue(_containsKey);
    Map<String,CharSequence> _files_2 = fsa.getFiles();
    String _plus_2 = (IFileSystemAccess.DEFAULT_OUTPUT + path);
    String _plus_3 = (_plus_2 + ExtensionCodes.BOM_EXT);
    boolean _containsKey_1 = _files_2.containsKey(_plus_3);
    Assert.assertTrue(_containsKey_1);
    Map<String,CharSequence> _files_3 = fsa.getFiles();
    String _plus_4 = (IFileSystemAccess.DEFAULT_OUTPUT + path);
    String _plus_5 = (_plus_4 + ExtensionCodes.INFO_EXT);
    boolean _containsKey_2 = _files_3.containsKey(_plus_5);
    Assert.assertTrue(_containsKey_2);
    Map<String,CharSequence> _files_4 = fsa.getFiles();
    String _plus_6 = (IFileSystemAccess.DEFAULT_OUTPUT + path);
    String _plus_7 = (_plus_6 + ExtensionCodes.REFDES_EXT);
    boolean _containsKey_3 = _files_4.containsKey(_plus_7);
    Assert.assertTrue(_containsKey_3);
    Map<String,CharSequence> _files_5 = fsa.getFiles();
    String _plus_8 = (IFileSystemAccess.DEFAULT_OUTPUT + path);
    String _plus_9 = (_plus_8 + ExtensionCodes.EAGLE_EXT);
    boolean _containsKey_4 = _files_5.containsKey(_plus_9);
    Assert.assertTrue(_containsKey_4);
    Map<String,CharSequence> _files_6 = fsa.getFiles();
    String _plus_10 = (IFileSystemAccess.DEFAULT_OUTPUT + path);
    String _plus_11 = (_plus_10 + ExtensionCodes.NET_EXT);
    boolean _containsKey_5 = _files_6.containsKey(_plus_11);
    Assert.assertTrue(_containsKey_5);
  }
  
  public void testOutputFiles(final InMemoryFileSystemAccess fsa, final String expected, final String actual) {
    String _plus = (expected + ExtensionCodes.PADS_EXT);
    String _fileToString = PhdlUtils.fileToString(_plus);
    Map<String,CharSequence> _files = fsa.getFiles();
    String _plus_1 = (IFileSystemAccess.DEFAULT_OUTPUT + actual);
    String _plus_2 = (_plus_1 + ExtensionCodes.PADS_EXT);
    CharSequence _get = _files.get(_plus_2);
    String _string = _get.toString();
    Assert.assertEquals(_fileToString, _string);
    String _plus_3 = (expected + ExtensionCodes.BOM_EXT);
    String _fileToString_1 = PhdlUtils.fileToString(_plus_3);
    Map<String,CharSequence> _files_1 = fsa.getFiles();
    String _plus_4 = (IFileSystemAccess.DEFAULT_OUTPUT + actual);
    String _plus_5 = (_plus_4 + ExtensionCodes.BOM_EXT);
    CharSequence _get_1 = _files_1.get(_plus_5);
    String _string_1 = _get_1.toString();
    Assert.assertEquals(_fileToString_1, _string_1);
    String _plus_6 = (expected + ExtensionCodes.INFO_EXT);
    String _fileToString_2 = PhdlUtils.fileToString(_plus_6);
    Map<String,CharSequence> _files_2 = fsa.getFiles();
    String _plus_7 = (IFileSystemAccess.DEFAULT_OUTPUT + actual);
    String _plus_8 = (_plus_7 + ExtensionCodes.INFO_EXT);
    CharSequence _get_2 = _files_2.get(_plus_8);
    String _string_2 = _get_2.toString();
    Assert.assertEquals(_fileToString_2, _string_2);
    String _plus_9 = (expected + ExtensionCodes.REFDES_EXT);
    String _fileToString_3 = PhdlUtils.fileToString(_plus_9);
    Map<String,CharSequence> _files_3 = fsa.getFiles();
    String _plus_10 = (IFileSystemAccess.DEFAULT_OUTPUT + actual);
    String _plus_11 = (_plus_10 + ExtensionCodes.REFDES_EXT);
    CharSequence _get_3 = _files_3.get(_plus_11);
    String _string_3 = _get_3.toString();
    Assert.assertEquals(_fileToString_3, _string_3);
    String _plus_12 = (expected + ExtensionCodes.EAGLE_EXT);
    String _fileToString_4 = PhdlUtils.fileToString(_plus_12);
    Map<String,CharSequence> _files_4 = fsa.getFiles();
    String _plus_13 = (IFileSystemAccess.DEFAULT_OUTPUT + actual);
    String _plus_14 = (_plus_13 + ExtensionCodes.EAGLE_EXT);
    CharSequence _get_4 = _files_4.get(_plus_14);
    String _string_4 = _get_4.toString();
    Assert.assertEquals(_fileToString_4, _string_4);
    String _plus_15 = (expected + ExtensionCodes.NET_EXT);
    String _fileToString_5 = PhdlUtils.fileToString(_plus_15);
    Map<String,CharSequence> _files_5 = fsa.getFiles();
    String _plus_16 = (IFileSystemAccess.DEFAULT_OUTPUT + actual);
    String _plus_17 = (_plus_16 + ExtensionCodes.NET_EXT);
    CharSequence _get_5 = _files_5.get(_plus_17);
    String _string_5 = _get_5.toString();
    Assert.assertEquals(_fileToString_5, _string_5);
  }
}
