package edu.byu.ee.phdl.xtext.tests;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2;
import org.eclipselabs.xtext.utils.unittesting.XtextTest;
import org.junit.Test;
import org.junit.runner.RunWith;

import edu.byu.ee.phdl.PhdlInjectorProvider;

@InjectWith(PhdlInjectorProvider.class)
@RunWith(XtextRunner2.class)
public class ConcatenationTest extends XtextTest {

	@Test
	public void testConcatenations() {
		ignoreFormattingDifferences();
		testFile(getClass().getSimpleName() + "/testConcatenations.phdl");

		// concatenations
		assertConstraints(issues.inLine(22).allOfThemContain("Invalid msb.").sizeIs(1));
		assertConstraints(issues.inLine(27).allOfThemContain("Invalid lsb.").sizeIs(1));
		assertConstraints(issues.inLine(32).allOfThemContain("Invalid slice.").sizeIs(1));
		assertConstraints(issues.inLine(37).allOfThemContain("Array not declared.").sizeIs(1));

		// test concatenation replications
		assertConstraints(issues.inLine(42).allOfThemContain("Array not declared.").sizeIs(1));
		assertConstraints(issues.inLine(47).allOfThemContain("Cannot replicate vector.").sizeIs(1));
		assertConstraints(issues.inLine(52).oneOfThemContains("Invalid msb.").sizeIs(2));
		assertConstraints(issues.inLine(52).oneOfThemContains("Invalid lsb.").sizeIs(2));
		assertConstraints(issues.inLine(57).allOfThemContain("Cannot replicate slices.").sizeIs(1));
		assertConstraints(issues.inLine(62).allOfThemContain("Invalid index.").sizeIs(1));
		assertConstraints(issues.inLine(67).allOfThemContain("Cannot replicate implicit vector.").sizeIs(1));

		// test open keyword works
		assertConstraints(issues.inLine(71).sizeIs(0));
	}

}
