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
class TestConcatenations extends XtextTest {
	
	@Test
	def void test_concatenations() {
		ignoreFormattingDifferences()
		testFile("TestConcatenations/test_concatenations.phdl")
		
		// concatenations
		assertConstraints(issues.inLine(22).sizeIs(1).allOfThemContain("Invalid msb."))
		assertConstraints(issues.inLine(27).sizeIs(1).allOfThemContain("Invalid lsb."))
		assertConstraints(issues.inLine(32).sizeIs(1).allOfThemContain("Invalid slice."))
		assertConstraints(issues.inLine(37).sizeIs(1).allOfThemContain("Array not declared."))
		
		// test concatenation replications
		assertConstraints(issues.inLine(42).sizeIs(1).allOfThemContain("Array not declared."))
		assertConstraints(issues.inLine(47).sizeIs(1).allOfThemContain("Cannot replicate vector."))		
		assertConstraints(issues.inLine(52).sizeIs(1).oneOfThemContains("Invalid msb."))
		assertConstraints(issues.inLine(52).sizeIs(1).oneOfThemContains("Invalid lsb."))
		assertConstraints(issues.inLine(57).sizeIs(1).allOfThemContain("Cannot replicate slices."))
		assertConstraints(issues.inLine(62).sizeIs(1).allOfThemContain("Invalid index."))
		assertConstraints(issues.inLine(67).sizeIs(1).allOfThemContain("Cannot replicate implicit vector."))
		
		// test open keyword works
		assertConstraints(issues.inLine(71).sizeIs(0))
	}
	
}