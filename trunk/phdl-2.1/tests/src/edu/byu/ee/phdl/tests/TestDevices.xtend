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
class TestDevices extends XtextTest {
	
	@Test
	def void test_physical_pin() {
		testFile("TestDevices/test_physical_pin.phdl")
		assertConstraints(issues.nOfThemContain(6,"Duplicate physical pin name."))
		assertConstraints(issues.errorsOnly().sizeIs(6))
	}
	
	@Test
	def void test_pin_decls() {
		testFile("TestDevices/test_invalid_pin_decl.phdl")
		assertConstraints(issues.errorsOnly().oneOfThemContains("Pin declaration width mismatch.  Left=1, right=2."))
		assertConstraints(issues.errorsOnly().oneOfThemContains("Pin declaration width mismatch.  Left=2, right=1."))
		assertConstraints(issues.errorsOnly().sizeIs(2))
	}
	
	@Test
	def void test_req_attrs() {
		testFile("TestDevices/test_req_attrs.phdl")
		assertConstraints(issues.oneOfThemContains("Required attribute 'REFPREFIX' missing."))
		assertConstraints(issues.oneOfThemContains("Required attribute 'LIBRARY' missing."))
		assertConstraints(issues.oneOfThemContains("Required attribute 'FOOTPRINT' missing."))
		assertConstraints(issues.errorsOnly().sizeIs(3))
	}
	
	@Test
	def void test_refprefix_attr() {
		testFile("TestDevices/test_refprefix_attr.phdl")
		assertConstraints(issues.allOfThemContain("Only uppercase REFPREFIX value recommended."))
		assertConstraints(issues.warningsOnly().sizeIs(1))
	}
	
	@Test
	def void test_pincount_attr() {
		testFile("TestDevices/test_pincount_attr.phdl")
		assertConstraints(issues.oneOfThemContains("Expected 3 declared pins, found 4."))
		assertConstraints(issues.oneOfThemContains("PINCOUNT attribute must be an integer."))
		assertConstraints(issues.errorsOnly().sizeIs(2))
	}
	
	@Test
	def void test_uppercase_attrs() {
		testFile("TestDevices/test_uppercase_attrs.phdl")
		assertConstraints(issues.allOfThemContain("Only uppercase attribute names are recommended"))
		assertConstraints(issues.warningsOnly().sizeIs(6))
	}
	
	@Test
	def void test_valid_device() {
		testFile("TestDevices/test_valid_device.phdl")
		assertConstraints(issues.sizeIs(0))
	}
}