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
class TestPortAssigns extends XtextTest {
	
	@Test
	def void test_port_assign_invalid_qualifiers() {
		ignoreFormattingDifferences()
		testFile("TestPortAssigns/test_port_assign_qualifiers.phdl")
		assertConstraints(issues.inLine(11).sizeIs(1).allOfThemContain("Invalid msb."))
		assertConstraints(issues.inLine(16).sizeIs(1).allOfThemContain("Invalid lsb."))
		assertConstraints(issues.inLine(21).sizeIs(1).allOfThemContain("Invalid index."))
		assertConstraints(issues.inLine(27).sizeIs(1).allOfThemContain("Qualifier not allowed."))
	}
	
	@Test
	def void test_port_assign_pin_refs() {
		ignoreFormattingDifferences()
		testFile("TestPortAssigns/test_port_assign_pin_refs.phdl")
		assertConstraints(issues.inLine(15).sizeIs(1).allOfThemContain("Invalid msb."))
		assertConstraints(issues.inLine(20).sizeIs(1).allOfThemContain("Invalid lsb."))
		assertConstraints(issues.inLine(25).sizeIs(1).allOfThemContain("Invalid index."))
		assertConstraints(issues.inLine(30).sizeIs(1).allOfThemContain("Array not declared."))
	}
	
	@Test
	def void test_port_assign_widths() {
		ignoreFormattingDifferences()
		testFile("TestPortAssigns/test_port_assign_widths.phdl")
		assertConstraints(issues.inLine(16).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=1, right=2."))
		assertConstraints(issues.inLine(21).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=1, right=4."))
		assertConstraints(issues.inLine(26).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=1."))
		assertConstraints(issues.inLine(31).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=3."))
		assertConstraints(issues.inLine(36).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=1, right=2."))
		assertConstraints(issues.inLine(41).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=1, right=4."))
		assertConstraints(issues.inLine(46).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=1."))
		assertConstraints(issues.inLine(51).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=3."))
		assertConstraints(issues.inLine(56).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=1."))
		assertConstraints(issues.inLine(61).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=3."))
		assertConstraints(issues.inLine(66).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=16, right=1."))
		assertConstraints(issues.inLine(71).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=16, right=4."))
		assertConstraints(issues.inLine(76).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=1."))
		assertConstraints(issues.inLine(81).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=4."))
		assertConstraints(issues.inLine(86).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=16, right=1."))
		assertConstraints(issues.inLine(91).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=16, right=3."))
	}
	
}