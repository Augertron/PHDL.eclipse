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
import edu.byu.ee.phdl.generator.ExtensionCodes

import static org.junit.Assert.*


@InjectWith(typeof(PhdlInjectorProvider))
@RunWith(typeof(XtextRunner2))
class TestGenerator extends XtextTest {
	
	@Inject IGenerator underTest
	@Inject ParseHelper<PhdlModel> parseHelper
	
	//val separator = java::io::File::separator
	private static Logger LOGGER = Logger::getLogger(typeof(XtextTest));
	
	var path = "resources/" + getClass().getSimpleName() + "/"
	
	@Test
	def void test1() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "." + new Throwable().stackTrace.get(0).methodName)
		var testDir = path + "test1/"
		var model = parseHelper.parse(FileToString::readFile(testDir + "test" + ExtensionCodes::PHDL_EXT))
		var fsa = new InMemoryFileSystemAccess()
		underTest.doGenerate(model.eResource, fsa)
		testOutputFileNames(fsa, "top")
		testOutputFiles(fsa, testDir + "golden", "top")
	}
	
	@Test
	def void test2() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "." + new Throwable().stackTrace.get(0).methodName)
		var testDir = path + "test2/"
		var model = parseHelper.parse(FileToString::readFile(testDir + "test" + ExtensionCodes::PHDL_EXT))
		var fsa = new InMemoryFileSystemAccess()
		underTest.doGenerate(model.eResource, fsa)
		testOutputFileNames(fsa, "top")
		testOutputFiles(fsa, testDir + "golden", "top")
	}
	
	def void testOutputFileNames(InMemoryFileSystemAccess fsa, String path) {
		assertEquals(5, fsa.files.size)
		assertTrue(fsa.files.containsKey(IFileSystemAccess::DEFAULT_OUTPUT + path + ExtensionCodes::PADS_EXT))
		assertTrue(fsa.files.containsKey(IFileSystemAccess::DEFAULT_OUTPUT + path + ExtensionCodes::BOM_EXT))
		assertTrue(fsa.files.containsKey(IFileSystemAccess::DEFAULT_OUTPUT + path + ExtensionCodes::INFO_EXT))
		assertTrue(fsa.files.containsKey(IFileSystemAccess::DEFAULT_OUTPUT + path + ExtensionCodes::REFDES_EXT))
		assertTrue(fsa.files.containsKey(IFileSystemAccess::DEFAULT_OUTPUT + path + ExtensionCodes::EAGLE_EXT))
	}
	
	def void testOutputFiles(InMemoryFileSystemAccess fsa, String expected, String actual) {
		assertEquals(FileToString::readFile(expected + ExtensionCodes::PADS_EXT), fsa.files.get(IFileSystemAccess::DEFAULT_OUTPUT + actual + ExtensionCodes::PADS_EXT).toString)
		assertEquals(FileToString::readFile(expected + ExtensionCodes::BOM_EXT), fsa.files.get(IFileSystemAccess::DEFAULT_OUTPUT + actual + ExtensionCodes::BOM_EXT).toString)
		assertEquals(FileToString::readFile(expected + ExtensionCodes::INFO_EXT), fsa.files.get(IFileSystemAccess::DEFAULT_OUTPUT + actual + ExtensionCodes::INFO_EXT).toString)
		assertEquals(FileToString::readFile(expected + ExtensionCodes::REFDES_EXT), fsa.files.get(IFileSystemAccess::DEFAULT_OUTPUT + actual + ExtensionCodes::REFDES_EXT).toString)
		assertEquals(FileToString::readFile(expected + ExtensionCodes::EAGLE_EXT), fsa.files.get(IFileSystemAccess::DEFAULT_OUTPUT + actual + ExtensionCodes::EAGLE_EXT).toString)
	}
}
