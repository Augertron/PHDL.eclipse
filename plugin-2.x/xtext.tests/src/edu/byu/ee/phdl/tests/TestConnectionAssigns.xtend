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
class TestConnectionAssigns extends XtextTest {
	
	@Test
	def void test_connection_assign_refs() {
		ignoreFormattingDifferences()
		testFile("TestConnectionAssigns/test_connection_assign_refs.phdl")
		assertConstraints(issues.inLine(6).sizeIs(1).allOfThemContain("Array not declared."))
		assertConstraints(issues.inLine(9).sizeIs(1).allOfThemContain("Invalid msb."))
		assertConstraints(issues.inLine(12).sizeIs(1).allOfThemContain("Invalid lsb."))
		assertConstraints(issues.inLine(15).sizeIs(1).allOfThemContain("Invalid index."))
		
	}
	
	@Test
	def void test_connection_assign_widths() {
		ignoreFormattingDifferences()
		testFile("TestCOnnectionAssigns/test_connection_assign_widths.phdl")
		assertConstraints(issues.inLine(6).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=1, right=2."))
		assertConstraints(issues.inLine(9).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=1, right=4."))
		assertConstraints(issues.inLine(12).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=1, right=3."))
		assertConstraints(issues.inLine(15).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=1, right=8."))
		assertConstraints(issues.inLine(18).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=1."))
		assertConstraints(issues.inLine(21).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=2."))
		assertConstraints(issues.inLine(24).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=3."))
		assertConstraints(issues.inLine(27).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=8."))
	}
}