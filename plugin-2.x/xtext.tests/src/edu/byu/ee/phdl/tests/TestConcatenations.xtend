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
		for (issue : issues) println(issue.message)
		assertConstraints(issues.inLine(22).sizeIs(1).allOfThemContain("Invalid msb."))
		assertConstraints(issues.inLine(27).sizeIs(1).allOfThemContain("Invalid lsb."))
		assertConstraints(issues.inLine(32).sizeIs(1).allOfThemContain("Invalid slice."))
		assertConstraints(issues.inLine(37).sizeIs(1).allOfThemContain("Array not declared."))
	}
	
}