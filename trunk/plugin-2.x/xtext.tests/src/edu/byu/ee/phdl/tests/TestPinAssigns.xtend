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
class TestPinAssigns extends XtextTest {
	
	@Test
	def void test_invalid_qualifier_msb() {
		ignoreFormattingDifferences()
		testFile("TestPinAssigns/test_pin_assign_qualifier_msb.phdl")
		assertConstraints(issues.oneOfThemContains("Invalid msb.").sizeIs(1))
	}
	
	@Test
	def void test_invalid_qualifier_lsb() {
		ignoreFormattingDifferences()
		testFile("TestPinAssigns/test_pin_assign_qualifier_lsb.phdl")
		assertConstraints(issues.oneOfThemContains("Invalid lsb.").sizeIs(1))
	}
	
	@Test
	def void test_invalid_qualifier_index() {
		ignoreFormattingDifferences()
		testFile("TestPinAssigns/test_pin_assign_qualifier_index.phdl")
		assertConstraints(issues.oneOfThemContains("Invalid index.").sizeIs(1))
	}
	
	@Test
	def void test_qualifier_not_allowed() {
		ignoreFormattingDifferences()
		testFile("TestPinAssigns/test_pin_assign_qualifier_not_allowed.phdl")
		assertConstraints(issues.oneOfThemContains("Qualifier not allowed.").sizeIs(1))
	}
	
	@Test
	def void test_pin_assign_array_not_declared() {
		ignoreFormattingDifferences()
		testFile("TestPinAssigns/test_pin_assign_array_not_declared.phdl")
		assertConstraints(issues.oneOfThemContains("Array not declared.").sizeIs(1))
	}
	
	@Test
	def void test_pin_assign_msb() {
		ignoreFormattingDifferences()
		testFile("TestPinAssigns/test_pin_assign_msb.phdl")
		assertConstraints(issues.oneOfThemContains("Invalid msb.").sizeIs(1))
	}
	
	@Test
	def void test_pin_assign_lsb() {
		ignoreFormattingDifferences()
		testFile("TestPinAssigns/test_pin_assign_lsb.phdl")
		assertConstraints(issues.oneOfThemContains("Invalid lsb.").sizeIs(1))
	}
	
	@Test
	def void test_pin_assign_index() {
		ignoreFormattingDifferences()
		testFile("TestPinAssigns/test_pin_assign_index.phdl")
		assertConstraints(issues.oneOfThemContains("Invalid index.").sizeIs(1))
	}
	
	@Test
	def void test_pin_assign_width() {
		ignoreFormattingDifferences()
		testFile("TestPinAssigns/test_pin_assign_width.phdl")
		assertConstraints(issues.inLine(14).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=2, right=1."))
		assertConstraints(issues.inLine(15).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=2, right=1."))
		assertConstraints(issues.inLine(16).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=1, right=2."))
		assertConstraints(issues.inLine(17).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=3, right=1."))
		assertConstraints(issues.inLine(22).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=3."))
		assertConstraints(issues.inLine(26).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=1."))
		assertConstraints(issues.inLine(28).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=8, right=1."))
		assertConstraints(issues.inLine(32).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=2, right=1."))
		assertConstraints(issues.inLine(33).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=2, right=1."))
		assertConstraints(issues.inLine(34).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=1, right=2."))
		assertConstraints(issues.inLine(35).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=3, right=1."))
		assertConstraints(issues.inLine(36).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=2, right=1."))
		assertConstraints(issues.inLine(37).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=2, right=1."))
		assertConstraints(issues.inLine(38).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=1, right=2."))
		assertConstraints(issues.inLine(39).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=3, right=1."))
		assertConstraints(issues.inLine(43).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=8, right=1."))
		assertConstraints(issues.inLine(44).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=8, right=1."))
		
	}
	
	
}