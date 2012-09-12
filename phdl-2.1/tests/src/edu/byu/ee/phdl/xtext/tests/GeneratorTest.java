package edu.byu.ee.phdl.xtext.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2;
import org.eclipselabs.xtext.utils.unittesting.XtextTest;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

import edu.byu.ee.phdl.PhdlInjectorProvider;
import edu.byu.ee.phdl.phdl.PhdlModel;
import edu.byu.ee.phdl.utils.ExtensionCodes;
import edu.byu.ee.phdl.utils.PhdlUtils;

@InjectWith(PhdlInjectorProvider.class)
@RunWith(XtextRunner2.class)
public class GeneratorTest extends XtextTest {

	@Inject
	IGenerator underTest;
	@Inject
	ParseHelper<PhdlModel> parseHelper;

	private static Logger logger = Logger.getLogger(GeneratorTest.class);

	String path = "resources/" + getClass().getSimpleName() + "/";
	String msgpfx = "testing generator with test-case: ";

	@Test
	public void testHierarchy1() {
		try {
			String methodName = new Throwable().getStackTrace()[0].getMethodName();
			logger.info(msgpfx + this.getClass().getSimpleName() + "." + methodName);
			String testDir = path + methodName + "/";
			PhdlModel model = parseHelper.parse(PhdlUtils
					.readStringFromFile(testDir + "test" + ExtensionCodes.PHDL_EXT));
			InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
			underTest.doGenerate(model.eResource(), fsa);
			testOutputFileNames(fsa, "top");
			testOutputFiles(fsa, testDir + "golden", "top");
		} catch (Exception e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	@Test
	public void testHierarchy2() {
		try {
			String methodName = new Throwable().getStackTrace()[0].getMethodName();
			logger.info(msgpfx + this.getClass().getSimpleName() + "." + methodName);
			String testDir = path + methodName + "/";
			PhdlModel model = parseHelper.parse(PhdlUtils
					.readStringFromFile(testDir + "test" + ExtensionCodes.PHDL_EXT));
			InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
			underTest.doGenerate(model.eResource(), fsa);
			testOutputFileNames(fsa, "top");
			testOutputFiles(fsa, testDir + "golden", "top");
		} catch (Exception e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	@Test
	public void testRefDes1() {
		try {
			String methodName = new Throwable().getStackTrace()[0].getMethodName();
			logger.info(msgpfx + this.getClass().getSimpleName() + "." + methodName);
			String testDir = path + methodName + "/";
			PhdlModel model = parseHelper.parse(PhdlUtils
					.readStringFromFile(testDir + "test" + ExtensionCodes.PHDL_EXT));
			InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
			underTest.doGenerate(model.eResource(), fsa);
			testOutputFileNames(fsa, "top");
			testOutputFiles(fsa, testDir + "golden", "top");
		} catch (Exception e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	@Test
	public void testRefDes2() {
		try {
			String methodName = new Throwable().getStackTrace()[0].getMethodName();
			logger.info(msgpfx + this.getClass().getSimpleName() + "." + methodName);
			String testDir = path + methodName + "/";
			PhdlModel model = parseHelper.parse(PhdlUtils
					.readStringFromFile(testDir + "test" + ExtensionCodes.PHDL_EXT));
			InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
			underTest.doGenerate(model.eResource(), fsa);
			testOutputFileNames(fsa, "top");
			testOutputFiles(fsa, testDir + "golden", "top");
		} catch (Exception e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	private void testOutputFileNames(InMemoryFileSystemAccess fsa, String path) {
		assertEquals(6, fsa.getFiles().size());
		assertTrue(fsa.getFiles().containsKey(IFileSystemAccess.DEFAULT_OUTPUT + path + ExtensionCodes.PADS_EXT));
		assertTrue(fsa.getFiles().containsKey(IFileSystemAccess.DEFAULT_OUTPUT + path + ExtensionCodes.BOM_EXT));
		assertTrue(fsa.getFiles().containsKey(IFileSystemAccess.DEFAULT_OUTPUT + path + ExtensionCodes.INFO_EXT));
		assertTrue(fsa.getFiles().containsKey(IFileSystemAccess.DEFAULT_OUTPUT + path + ExtensionCodes.REFDES_EXT));
		assertTrue(fsa.getFiles().containsKey(IFileSystemAccess.DEFAULT_OUTPUT + path + ExtensionCodes.EAGLE_EXT));
		assertTrue(fsa.getFiles().containsKey(IFileSystemAccess.DEFAULT_OUTPUT + path + ExtensionCodes.NET_EXT));
	}

	private void testOutputFiles(InMemoryFileSystemAccess fsa, String expected, String actual) {
		assertEquals(PhdlUtils.readStringFromFile(expected + ExtensionCodes.PADS_EXT),
				fsa.getFiles().get(IFileSystemAccess.DEFAULT_OUTPUT + actual + ExtensionCodes.PADS_EXT).toString());
		assertEquals(PhdlUtils.readStringFromFile(expected + ExtensionCodes.BOM_EXT),
				fsa.getFiles().get(IFileSystemAccess.DEFAULT_OUTPUT + actual + ExtensionCodes.BOM_EXT).toString());
		assertEquals(PhdlUtils.readStringFromFile(expected + ExtensionCodes.INFO_EXT),
				fsa.getFiles().get(IFileSystemAccess.DEFAULT_OUTPUT + actual + ExtensionCodes.INFO_EXT).toString());
		assertEquals(PhdlUtils.readStringFromFile(expected + ExtensionCodes.REFDES_EXT),
				fsa.getFiles().get(IFileSystemAccess.DEFAULT_OUTPUT + actual + ExtensionCodes.REFDES_EXT).toString());
		assertEquals(PhdlUtils.readStringFromFile(expected + ExtensionCodes.EAGLE_EXT),
				fsa.getFiles().get(IFileSystemAccess.DEFAULT_OUTPUT + actual + ExtensionCodes.EAGLE_EXT).toString());
		assertEquals(PhdlUtils.readStringFromFile(expected + ExtensionCodes.NET_EXT),
				fsa.getFiles().get(IFileSystemAccess.DEFAULT_OUTPUT + actual + ExtensionCodes.NET_EXT).toString());

	}
}
