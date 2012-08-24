package edu.byu.ee.phdl.tests

import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.InjectWith
import edu.byu.ee.phdl.PhdlInjectorProvider
import org.eclipse.xtext.generator.IGenerator
import com.google.inject.Inject
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.generator.InMemoryFileSystemAccess
import org.eclipse.xtext.generator.IFileSystemAccess
import edu.byu.ee.phdl.phdl.PhdlModel
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.apache.log4j.Logger
import org.eclipselabs.xtext.utils.unittesting.XtextTest
import edu.byu.ee.phdl.utils.ExtensionCodes
import edu.byu.ee.phdl.utils.PhdlUtils

import static org.junit.Assert.*


@InjectWith(typeof(PhdlInjectorProvider))
@RunWith(typeof(XtextRunner2))
class TestGenerator extends XtextTest {
	
	@Inject IGenerator underTest
	@Inject ParseHelper<PhdlModel> parseHelper
	
	//val separator = java::io::File::separator
	private static Logger logger = Logger::getLogger(typeof(TestGenerator));
	
	var path = "resources/" + getClass().getSimpleName() + "/"
	var msgpfx = "testing generator with test-case: "
	
	@Test
	def void test_hierarchy1() {
		var methodName = new Throwable().stackTrace.get(0).methodName;
		logger.info(msgpfx + this.getClass().getSimpleName() + "." + methodName)
		var testDir = path + methodName + "/"
		var model = parseHelper.parse(PhdlUtils::fileToString(testDir + "test" + ExtensionCodes::PHDL_EXT))
		var fsa = new InMemoryFileSystemAccess()
		underTest.doGenerate(model.eResource, fsa)
		testOutputFileNames(fsa, "top")
		testOutputFiles(fsa, testDir + "golden", "top")
	}
	
	@Test
	def void test_hierarchy2() {
		var methodName = new Throwable().stackTrace.get(0).methodName;
		logger.info(msgpfx + this.getClass().getSimpleName() + "." + methodName)
		var testDir = path + methodName + "/"
		var model = parseHelper.parse(PhdlUtils::fileToString(testDir + "test" + ExtensionCodes::PHDL_EXT))
		var fsa = new InMemoryFileSystemAccess()
		underTest.doGenerate(model.eResource, fsa)
		testOutputFileNames(fsa, "top")
		testOutputFiles(fsa, testDir + "golden", "top")
	}
	
	@Test
	def void test_refDes1() {
		var methodName = new Throwable().stackTrace.get(0).methodName;
		logger.info(msgpfx + this.getClass().getSimpleName() + "." + methodName)
		var testDir = path + methodName + "/"
		var model = parseHelper.parse(PhdlUtils::fileToString(testDir + "test" + ExtensionCodes::PHDL_EXT))
		var fsa = new InMemoryFileSystemAccess()
		underTest.doGenerate(model.eResource, fsa)
		testOutputFileNames(fsa, "top")
		testOutputFiles(fsa, testDir + "golden", "top")
	}
	
	@Test
	def void test_refDes2() {
		var methodName = new Throwable().stackTrace.get(0).methodName;
		logger.info(msgpfx + this.getClass().getSimpleName() + "." + methodName)
		var testDir = path + methodName + "/"
		var model = parseHelper.parse(PhdlUtils::fileToString(testDir + "test" + ExtensionCodes::PHDL_EXT))
		var fsa = new InMemoryFileSystemAccess()
		underTest.doGenerate(model.eResource, fsa)
		testOutputFileNames(fsa, "top")
		testOutputFiles(fsa, testDir + "golden", "top")
	}
	
	def void testOutputFileNames(InMemoryFileSystemAccess fsa, String path) {
		assertEquals(6, fsa.files.size)
		assertTrue(fsa.files.containsKey(IFileSystemAccess::DEFAULT_OUTPUT + path + ExtensionCodes::PADS_EXT))
		assertTrue(fsa.files.containsKey(IFileSystemAccess::DEFAULT_OUTPUT + path + ExtensionCodes::BOM_EXT))
		assertTrue(fsa.files.containsKey(IFileSystemAccess::DEFAULT_OUTPUT + path + ExtensionCodes::INFO_EXT))
		assertTrue(fsa.files.containsKey(IFileSystemAccess::DEFAULT_OUTPUT + path + ExtensionCodes::REFDES_EXT))
		assertTrue(fsa.files.containsKey(IFileSystemAccess::DEFAULT_OUTPUT + path + ExtensionCodes::EAGLE_EXT))
		assertTrue(fsa.files.containsKey(IFileSystemAccess::DEFAULT_OUTPUT + path + ExtensionCodes::XML_EXT))
	}
	
	def void testOutputFiles(InMemoryFileSystemAccess fsa, String expected, String actual) {
		assertEquals(PhdlUtils::fileToString(expected + ExtensionCodes::PADS_EXT), 
			fsa.files.get(IFileSystemAccess::DEFAULT_OUTPUT + actual + ExtensionCodes::PADS_EXT).toString
		)
		assertEquals(PhdlUtils::fileToString(expected + ExtensionCodes::BOM_EXT), 
			fsa.files.get(IFileSystemAccess::DEFAULT_OUTPUT + actual + ExtensionCodes::BOM_EXT).toString
		)
		assertEquals(PhdlUtils::fileToString(expected + ExtensionCodes::INFO_EXT), 
			fsa.files.get(IFileSystemAccess::DEFAULT_OUTPUT + actual + ExtensionCodes::INFO_EXT).toString
		)
		assertEquals(PhdlUtils::fileToString(expected + ExtensionCodes::REFDES_EXT), 
			fsa.files.get(IFileSystemAccess::DEFAULT_OUTPUT + actual + ExtensionCodes::REFDES_EXT).toString
		)
		assertEquals(PhdlUtils::fileToString(expected + ExtensionCodes::EAGLE_EXT), 
			fsa.files.get(IFileSystemAccess::DEFAULT_OUTPUT + actual + ExtensionCodes::EAGLE_EXT).toString
		)
		assertEquals(PhdlUtils::fileToString(expected + ExtensionCodes::XML_EXT), 
			fsa.files.get(IFileSystemAccess::DEFAULT_OUTPUT + actual + ExtensionCodes::XML_EXT).toString
		)
		
	}
}
