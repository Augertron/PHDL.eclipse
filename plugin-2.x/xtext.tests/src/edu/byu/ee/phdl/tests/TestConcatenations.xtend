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
	def void test_pin_assign_concats() {
		ignoreFormattingDifferences()
		testFile("TestConcatenations/test_concatenations.phdl")
		assertConstraints(issues.oneOfThemContains("Array not declared."))
		assertConstraints(issues.errorsOnly().sizeIs(1))
		for (issue : issues) {
			println(issue.message)
		}
	}
	
}