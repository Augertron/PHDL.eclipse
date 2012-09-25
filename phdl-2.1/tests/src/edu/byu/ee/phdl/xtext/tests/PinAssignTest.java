package edu.byu.ee.phdl.xtext.tests;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2;
import org.eclipselabs.xtext.utils.unittesting.XtextTest;
import org.junit.Test;
import org.junit.runner.RunWith;

import edu.byu.ee.phdl.PhdlInjectorProvider;

@InjectWith(PhdlInjectorProvider.class)
@RunWith(XtextRunner2.class)
public class PinAssignTest extends XtextTest {

	@Test
	public void testPinAssignInvalidQualifiers() {
		ignoreFormattingDifferences();
		testFile(getClass().getSimpleName() + "/testPinAssignInvalidQualifiers.phdl");
		assertConstraints(issues.inLine(14).allOfThemContain("Invalid msb.").sizeIs(1));
		assertConstraints(issues.inLine(19).allOfThemContain("Invalid lsb.").sizeIs(1));
		assertConstraints(issues.inLine(24).allOfThemContain("Invalid index.").sizeIs(1));
		assertConstraints(issues.inLine(30).allOfThemContain("Qualifier not allowed.").sizeIs(1));
	}

	@Test
	public void testPinAssignPinRefs() {
		ignoreFormattingDifferences();
		testFile(getClass().getSimpleName() + "/testPinAssignPinRefs.phdl");
		assertConstraints(issues.inLine(21).allOfThemContain("Invalid msb.").sizeIs(1));
		assertConstraints(issues.inLine(26).allOfThemContain("Invalid lsb.").sizeIs(1));
		assertConstraints(issues.inLine(31).allOfThemContain("Invalid index.").sizeIs(1));
		assertConstraints(issues.inLine(36).allOfThemContain("Array not declared.").sizeIs(1));
	}

	@Test
	public void testPinAssignUnassigned() {
		ignoreFormattingDifferences();
		testFile(getClass().getSimpleName() + "/testPinAssignUnassigned.phdl");
		assertConstraints(issues.inLine(21).allOfThemContain("Unassigned pin 'test1.a'.").sizeIs(1));
		assertConstraints(issues.inLine(26).allOfThemContain("Unassigned pin 'test2.b[4]'.").sizeIs(1));
		assertConstraints(issues.inLine(31).allOfThemContain("Unassigned pin 'test3(1).a'.").sizeIs(1));
		assertConstraints(issues.inLine(36).allOfThemContain("Unassigned pin 'test4(2).a'.").sizeIs(1));
		assertConstraints(issues.inLine(41).oneOfThemContains("Unassigned pin 'test5(4).b[4]'.")
				.oneOfThemContains("Unassigned pin 'test5(4).b[3]'.")
				.oneOfThemContains("Unassigned pin 'test5(4).b[2]'.")
				.oneOfThemContains("Unassigned pin 'test5(4).b[1]'.")
				.oneOfThemContains("Unassigned pin 'test5(4).b[3]'.")
				.oneOfThemContains("Unassigned pin 'test5(3).b[3]'.")
				.oneOfThemContains("Unassigned pin 'test5(1).b[3]'.").sizeIs(7));
		assertConstraints(issues.inLine(46).oneOfThemContains("Unassigned pin 'test6(3).b[4]'.")
				.oneOfThemContains("Unassigned pin 'test6(3).b[3]'.")
				.oneOfThemContains("Unassigned pin 'test6(3).b[2]'.")
				.oneOfThemContains("Unassigned pin 'test6(3).b[1]'.")
				.oneOfThemContains("Unassigned pin 'test6(4).b[4]'.")
				.oneOfThemContains("Unassigned pin 'test6(1).b[4]'.")
				.oneOfThemContains("Unassigned pin 'test6(2).b[4]'.").sizeIs(7));
		assertConstraints(issues.inLine(51).oneOfThemContains("Unassigned pin 'test7(4).b[4]'.")
				.oneOfThemContains("Unassigned pin 'test7(4).b[3]'.")
				.oneOfThemContains("Unassigned pin 'test7(4).b[2]'.")
				.oneOfThemContains("Unassigned pin 'test7(4).b[1]'.")
				.oneOfThemContains("Unassigned pin 'test7(3).b[4]'.")
				.oneOfThemContains("Unassigned pin 'test7(3).b[3]'.")
				.oneOfThemContains("Unassigned pin 'test7(3).b[2]'.")
				.oneOfThemContains("Unassigned pin 'test7(3).b[1]'.")
				.oneOfThemContains("Unassigned pin 'test7(2).b[4]'.")
				.oneOfThemContains("Unassigned pin 'test7(2).b[3]'.")
				.oneOfThemContains("Unassigned pin 'test7(2).b[2]'.")
				.oneOfThemContains("Unassigned pin 'test7(2).b[1]'.")
				.oneOfThemContains("Unassigned pin 'test7(1).b[4]'.")
				.oneOfThemContains("Unassigned pin 'test7(1).b[3]'.")
				.oneOfThemContains("Unassigned pin 'test7(1).b[2]'.")
				.oneOfThemContains("Unassigned pin 'test7(1).b[1]'.").sizeIs(16));
	}

	@Test
	public void testPinAssignWidths() {
		ignoreFormattingDifferences();
		testFile(getClass().getSimpleName() + "/testPinAssignWidths.phdl");
		assertConstraints(issues.inLine(22).allOfThemContain("Assignment width mismatch.  Left=1, right=2.").sizeIs(1));
		assertConstraints(issues.inLine(27).allOfThemContain("Assignment width mismatch.  Left=1, right=4.").sizeIs(1));
		assertConstraints(issues.inLine(32).allOfThemContain("Assignment width mismatch.  Left=4, right=1.").sizeIs(1));
		assertConstraints(issues.inLine(37).allOfThemContain("Assignment width mismatch.  Left=4, right=3.").sizeIs(1));
		assertConstraints(issues.inLine(42).allOfThemContain("Assignment width mismatch.  Left=1, right=2.").sizeIs(1));
		assertConstraints(issues.inLine(47).allOfThemContain("Assignment width mismatch.  Left=1, right=4.").sizeIs(1));
		assertConstraints(issues.inLine(52).allOfThemContain("Assignment width mismatch.  Left=4, right=1.").sizeIs(1));
		assertConstraints(issues.inLine(57).allOfThemContain("Assignment width mismatch.  Left=4, right=3.").sizeIs(1));
		assertConstraints(issues.inLine(62).allOfThemContain("Assignment width mismatch.  Left=4, right=1.").sizeIs(1));
		assertConstraints(issues.inLine(67).allOfThemContain("Assignment width mismatch.  Left=4, right=3.").sizeIs(1));
		assertConstraints(issues.inLine(72).allOfThemContain("Assignment width mismatch.  Left=16, right=1.").sizeIs(1));
		assertConstraints(issues.inLine(77).allOfThemContain("Assignment width mismatch.  Left=16, right=4.").sizeIs(1));
		assertConstraints(issues.inLine(82).allOfThemContain("Assignment width mismatch.  Left=4, right=1.").sizeIs(1));
		assertConstraints(issues.inLine(87).allOfThemContain("Assignment width mismatch.  Left=4, right=3.").sizeIs(1));
		assertConstraints(issues.inLine(92).allOfThemContain("Assignment width mismatch.  Left=16, right=1.").sizeIs(1));
		assertConstraints(issues.inLine(97).allOfThemContain("Assignment width mismatch.  Left=16, right=3.").sizeIs(1));
	}

}