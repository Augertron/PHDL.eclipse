package edu.byu.ee.phdl.tests;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2;
import org.eclipselabs.xtext.utils.unittesting.XtextTest;
import org.junit.Test;
import org.junit.runner.RunWith;

import edu.byu.ee.phdl.PhdlInjectorProvider;

@InjectWith(PhdlInjectorProvider.class)
@RunWith(XtextRunner2.class)
public class ConnectionAssignTest extends XtextTest {

	@Test
	public void testConnectionAssignRefs() {
		ignoreFormattingDifferences();
		testFile(getClass().getSimpleName() + "/testConnectionAssignRefs.phdl");
		assertConstraints(issues.inLine(6).sizeIs(1).allOfThemContain("Array not declared."));
		assertConstraints(issues.inLine(9).sizeIs(1).allOfThemContain("Invalid msb."));
		assertConstraints(issues.inLine(12).sizeIs(1).allOfThemContain("Invalid lsb."));
		assertConstraints(issues.inLine(15).sizeIs(1).allOfThemContain("Invalid index."));

	}

	@Test
	public void testConnectionAssignWidths() {
		ignoreFormattingDifferences();
		testFile(getClass().getSimpleName() + "/testConnectionAssignWidths.phdl");
		assertConstraints(issues.inLine(6).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=1, right=2."));
		assertConstraints(issues.inLine(9).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=1, right=4."));
		assertConstraints(issues.inLine(12).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=1, right=3."));
		assertConstraints(issues.inLine(15).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=1, right=8."));
		assertConstraints(issues.inLine(18).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=1."));
		assertConstraints(issues.inLine(21).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=2."));
		assertConstraints(issues.inLine(24).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=3."));
		assertConstraints(issues.inLine(27).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=8."));
	}
}