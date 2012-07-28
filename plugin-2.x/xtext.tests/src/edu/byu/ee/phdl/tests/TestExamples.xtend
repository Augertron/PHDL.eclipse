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
		ignoreFormattingDifferences()
		var dir = "TestExamples/fmc_module/"
		testFile(dir + "top.phdl", dir + "balun.phdl", dir + "transceiver.phdl", dir + "clock.phdl", dir + "devices.phdl")
		assertConstraints(issues.sizeIs(0))
	}
	
	@Test
	def void test_voice_modulator() {
		ignoreFormattingDifferences()
		var dir = "TestExamples/voice_modulator/"
		testFile(dir + "vm_design.phdl", dir + "vm_amp.phdl", dir + "vm_modulator.phdl", dir + "vm_devices.phdl")
		assertConstraints(issues.sizeIs(0))
	}
	
	@Test
	def void test_seven_segment() {
		ignoreFormattingDifferences()
		var dir = "TestExamples/seven_segment/"
		testFile(dir + "ss_Control.phdl", dir + "ss_Devices.phdl")
		assertConstraints(issues.sizeIs(0))
	}
	
	@Test
	def void test_ptzlanc() {
		ignoreFormattingDifferences()
		var dir = "TestExamples/ptzlanc/"
		testFile(dir + "ptzlanc.phdl", dir + "ic.phdl", dir + "connector.phdl", dir + "pinheader.phdl", dir + "rcl.phdl", dir + "switches.phdl", dir + "discrete.phdl")
		assertConstraints(issues.sizeIs(0))
	}
	
	@Test
	def void test_atlys() {
		ignoreFormattingDifferences()
		var dir = "TestExamples/atlys/"
		testFile(dir + "top.phdl", dir + "s6_devices.phdl")
		assertConstraints(issues.nOfThemContain(2, "Ports may not be open."))
		assertConstraints(issues.errorsOnly().sizeIs(2))
	}
}