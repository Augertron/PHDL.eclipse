package edu.byu.ee.phdl.xtext.tests;

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
		assertConstraints(issues.inLine(6).allOfThemContain("Array not declared.").sizeIs(1));
		assertConstraints(issues.inLine(9).allOfThemContain("Invalid msb.").sizeIs(1));
		assertConstraints(issues.inLine(12).allOfThemContain("Invalid lsb.").sizeIs(1));
		assertConstraints(issues.inLine(15).allOfThemContain("Invalid index.").sizeIs(1));

	}

	@Test
	public void testConnectionAssignWidths() {
		ignoreFormattingDifferences();
		testFile(getClass().getSimpleName() + "/testConnectionAssignWidths.phdl");
		assertConstraints(issues.inLine(6).allOfThemContain("Assignment width mismatch.  Left=1, right=2.").sizeIs(1));
		assertConstraints(issues.inLine(9).allOfThemContain("Assignment width mismatch.  Left=1, right=4.").sizeIs(1));
		assertConstraints(issues.inLine(12).allOfThemContain("Assignment width mismatch.  Left=1, right=3.").sizeIs(1));
		assertConstraints(issues.inLine(15).allOfThemContain("Assignment width mismatch.  Left=1, right=8.").sizeIs(1));
		assertConstraints(issues.inLine(18).allOfThemContain("Assignment width mismatch.  Left=4, right=1.").sizeIs(1));
		assertConstraints(issues.inLine(21).allOfThemContain("Assignment width mismatch.  Left=4, right=2.").sizeIs(1));
		assertConstraints(issues.inLine(24).allOfThemContain("Assignment width mismatch.  Left=4, right=3.").sizeIs(1));
		assertConstraints(issues.inLine(27).allOfThemContain("Assignment width mismatch.  Left=4, right=8.").sizeIs(1));
	}
}