package edu.byu.ee.phdl.tests

import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.InjectWith
import edu.byu.ee.phdl.PhdlInjectorProvider
import org.eclipse.xtext.generator.IGenerator
import com.google.inject.Inject
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.generator.InMemoryFileSystemAccess
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.generator.IFileSystemAccess
import edu.byu.ee.phdl.phdl.PhdlModel
import com.google.inject.Provider
import org.eclipse.emf.ecore.resource.ResourceSet
import java.util.LinkedHashSet
import org.eclipse.emf.ecore.resource.Resource
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.apache.log4j.Logger
import org.eclipselabs.xtext.utils.unittesting.XtextTest
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import java.io.File

import static org.junit.Assert.*

@InjectWith(typeof(PhdlInjectorProvider))
@RunWith(typeof(XtextRunner2))
class TestGenerator extends XtextTest {
	
	@Inject IGenerator underTest
	@Inject ParseHelper<PhdlModel> parseHelper
	
	val separator = java::io::File::separator
	private static Logger LOGGER = Logger::getLogger(typeof(XtextTest));
	
	@Test
	def void test1() {
		LOGGER.info("testing method " + this.getClass().getSimpleName() + "." + new Throwable().stackTrace.get(0).methodName)
		var model = parseHelper.parse(readFile("resources/TestGenerator/test1/source.phdl"))
		var fsa = new InMemoryFileSystemAccess()
		underTest.doGenerate(model.eResource, fsa)
		testOutputFileNames(fsa, getOutputPath("top"))
		testOutputFiles(fsa, "resources/TestGenerator/test1/golden", getOutputPath("top"))
	}
	
	def void testOutputFileNames(InMemoryFileSystemAccess fsa, String path) {
		assertEquals(5, fsa.files.size)
		assertTrue(fsa.files.containsKey(IFileSystemAccess::DEFAULT_OUTPUT + path + ".asc"))
		assertTrue(fsa.files.containsKey(IFileSystemAccess::DEFAULT_OUTPUT + path + ".bom"))
		assertTrue(fsa.files.containsKey(IFileSystemAccess::DEFAULT_OUTPUT + path + ".lsi"))
		assertTrue(fsa.files.containsKey(IFileSystemAccess::DEFAULT_OUTPUT + path + ".rdm"))
		assertTrue(fsa.files.containsKey(IFileSystemAccess::DEFAULT_OUTPUT + path + ".scr"))
	}
	
	def void testOutputFiles(InMemoryFileSystemAccess fsa, String expected, String actual) {
		assertEquals(readFile(expected + ".asc"), fsa.files.get(IFileSystemAccess::DEFAULT_OUTPUT + actual + ".asc").toString)
	}
	
	def String getOutputPath(String designName) {
		return designName + separator + designName
	}
	
	def String readFile(String fileName) {
		var sb = new StringBuilder();
		try {
		    var br = new BufferedReader(new FileReader(fileName));
		    var String str;
		    while ((str = br.readLine()) != null) {
		        sb.append(str + "\n")
		    }
		    br.close();
		    return sb.subSequence(0, sb.length-1).toString
		} catch (IOException e) {
		}
	}
}
