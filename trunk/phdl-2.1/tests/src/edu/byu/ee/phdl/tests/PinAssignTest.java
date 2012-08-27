package edu.byu.ee.phdl.tests;

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
		assertConstraints(issues.inLine(14).sizeIs(1).allOfThemContain("Invalid msb."));
		assertConstraints(issues.inLine(19).sizeIs(1).allOfThemContain("Invalid lsb."));
		assertConstraints(issues.inLine(24).sizeIs(1).allOfThemContain("Invalid index."));
		assertConstraints(issues.inLine(30).sizeIs(1).allOfThemContain("Qualifier not allowed."));
	}

	@Test
	public void testPinAssignPinRefs() {
		ignoreFormattingDifferences();
		testFile(getClass().getSimpleName() + "/testPinAssignPinRefs.phdl");
		assertConstraints(issues.inLine(21).sizeIs(1).allOfThemContain("Invalid msb."));
		assertConstraints(issues.inLine(26).sizeIs(1).allOfThemContain("Invalid lsb."));
		assertConstraints(issues.inLine(31).sizeIs(1).allOfThemContain("Invalid index."));
		assertConstraints(issues.inLine(36).sizeIs(1).allOfThemContain("Array not declared."));
	}

	@Test
	public void testPinAssignUnassigned() {
		ignoreFormattingDifferences();
		testFile(getClass().getSimpleName() + "/testPinAssignUnassigned.phdl");
		assertConstraints(issues.inLine(21).sizeIs(1).allOfThemContain("Unassigned pin 'test1.a'."));
		assertConstraints(issues.inLine(26).sizeIs(1).allOfThemContain("Unassigned pin 'test2.b[4]'."));
		assertConstraints(issues.inLine(31).sizeIs(1).allOfThemContain("Unassigned pin 'test3(1).a'."));
		assertConstraints(issues.inLine(36).sizeIs(1).allOfThemContain("Unassigned pin 'test4(2).a'."));
		assertConstraints(issues.inLine(41).sizeIs(7).oneOfThemContains("Unassigned pin 'test5(4).b[4]'.")
				.oneOfThemContains("Unassigned pin 'test5(4).b[3]'.")
				.oneOfThemContains("Unassigned pin 'test5(4).b[2]'.")
				.oneOfThemContains("Unassigned pin 'test5(4).b[1]'.")
				.oneOfThemContains("Unassigned pin 'test5(4).b[3]'.")
				.oneOfThemContains("Unassigned pin 'test5(3).b[3]'.")
				.oneOfThemContains("Unassigned pin 'test5(1).b[3]'."));
		assertConstraints(issues.inLine(46).sizeIs(7).oneOfThemContains("Unassigned pin 'test6(3).b[4]'.")
				.oneOfThemContains("Unassigned pin 'test6(3).b[3]'.")
				.oneOfThemContains("Unassigned pin 'test6(3).b[2]'.")
				.oneOfThemContains("Unassigned pin 'test6(3).b[1]'.")
				.oneOfThemContains("Unassigned pin 'test6(4).b[4]'.")
				.oneOfThemContains("Unassigned pin 'test6(1).b[4]'.")
				.oneOfThemContains("Unassigned pin 'test6(2).b[4]'."));
		assertConstraints(issues.inLine(51).sizeIs(16).oneOfThemContains("Unassigned pin 'test7(4).b[4]'.")
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
				.oneOfThemContains("Unassigned pin 'test7(1).b[1]'."));
	}

	@Test
	public void testPinAssignWidths() {
		ignoreFormattingDifferences();
		testFile(getClass().getSimpleName() + "/testPinAssignWidths.phdl");
		assertConstraints(issues.inLine(22).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=1, right=2."));
		assertConstraints(issues.inLine(27).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=1, right=4."));
		assertConstraints(issues.inLine(32).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=1."));
		assertConstraints(issues.inLine(37).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=3."));
		assertConstraints(issues.inLine(42).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=1, right=2."));
		assertConstraints(issues.inLine(47).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=1, right=4."));
		assertConstraints(issues.inLine(52).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=1."));
		assertConstraints(issues.inLine(57).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=3."));
		assertConstraints(issues.inLine(62).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=1."));
		assertConstraints(issues.inLine(67).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=3."));
		assertConstraints(issues.inLine(72).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=16, right=1."));
		assertConstraints(issues.inLine(77).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=16, right=4."));
		assertConstraints(issues.inLine(82).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=1."));
		assertConstraints(issues.inLine(87).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=4."));
		assertConstraints(issues.inLine(92).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=16, right=1."));
		assertConstraints(issues.inLine(97).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=16, right=3."));
	}

}