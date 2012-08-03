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
	def void test_pin_assign_invalid_qualifiers() {
		ignoreFormattingDifferences()
		testFile("TestPinAssigns/test_pin_assign_qualifiers.phdl")
		assertConstraints(issues.inLine(14).sizeIs(1).allOfThemContain("Invalid msb."))
		assertConstraints(issues.inLine(19).sizeIs(1).allOfThemContain("Invalid lsb."))
		assertConstraints(issues.inLine(24).sizeIs(1).allOfThemContain("Invalid index."))
		assertConstraints(issues.inLine(30).sizeIs(1).allOfThemContain("Qualifier not allowed."))
	}
	
	@Test
	def void test_pin_assign_pin_refs() {
		ignoreFormattingDifferences()
		testFile("TestPinAssigns/test_pin_assign_pin_refs.phdl")
		assertConstraints(issues.inLine(21).sizeIs(1).allOfThemContain("Invalid msb."))
		assertConstraints(issues.inLine(26).sizeIs(1).allOfThemContain("Invalid lsb."))
		assertConstraints(issues.inLine(31).sizeIs(1).allOfThemContain("Invalid index."))
		assertConstraints(issues.inLine(36).sizeIs(1).allOfThemContain("Array not declared."))
	}
	
	@Test
	def void test_pin_assign_widths() {
		ignoreFormattingDifferences()
		testFile("TestPinAssigns/test_pin_assign_widths.phdl")
		assertConstraints(issues.inLine(22).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=1, right=2."))
		assertConstraints(issues.inLine(27).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=1, right=4."))
		assertConstraints(issues.inLine(32).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=1."))
		assertConstraints(issues.inLine(37).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=3."))
		assertConstraints(issues.inLine(42).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=1, right=2."))
		assertConstraints(issues.inLine(47).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=1, right=4."))
		assertConstraints(issues.inLine(52).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=1."))
		assertConstraints(issues.inLine(57).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=3."))
		assertConstraints(issues.inLine(62).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=1."))
		assertConstraints(issues.inLine(67).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=3."))
		assertConstraints(issues.inLine(72).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=16, right=1."))
		assertConstraints(issues.inLine(77).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=16, right=4."))
		assertConstraints(issues.inLine(82).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=1."))
		assertConstraints(issues.inLine(87).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=4."))
		assertConstraints(issues.inLine(92).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=16, right=1."))
		assertConstraints(issues.inLine(97).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=16, right=3."))
	}
}