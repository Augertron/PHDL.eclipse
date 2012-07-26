package edu.byu.ee.phdl.tests

import org.eclipse.xtext.junit4.InjectWith
import org.junit.runner.RunWith
import org.junit.Test

import static org.junit.Assert.*
import org.eclipselabs.xtext.utils.unittesting.XtextTest
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import edu.byu.ee.phdl.PhdlInjectorProvider

@InjectWith(typeof(PhdlInjectorProvider))
@RunWith(typeof(XtextRunner2))
class TestExamples extends XtextTest {
	
	@Test
	def void test_fmc_module() {
		ignoreFormattingDifferences();
		var dir = "TestExamples/fmc_module/"
		testFile(dir + "devices.phdl", dir + "balun.phdl", dir + "clock.phdl", dir + "transceiver.phdl", dir + "top.phdl")
	}
	
	@Test
	def void test_hierarchy() {
		
	}
}