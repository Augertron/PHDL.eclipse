package edu.byu.ee.phdl.tests;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2;
import org.eclipselabs.xtext.utils.unittesting.XtextTest;
import org.junit.Test;
import org.junit.runner.RunWith;

import edu.byu.ee.phdl.PhdlInjectorProvider;

@InjectWith(PhdlInjectorProvider.class)
@RunWith(XtextRunner2.class)
public class PortAssignTest extends XtextTest {

	@Test
	public void testPortAssignInvalidQualifiers() {
		ignoreFormattingDifferences();
		testFile(getClass().getSimpleName() + "/testPortAssignInvalidQualifiers.phdl");
		assertConstraints(issues.inLine(11).sizeIs(1).allOfThemContain("Invalid msb."));
		assertConstraints(issues.inLine(16).sizeIs(1).allOfThemContain("Invalid lsb."));
		assertConstraints(issues.inLine(21).sizeIs(1).allOfThemContain("Invalid index."));
		assertConstraints(issues.inLine(27).sizeIs(1).allOfThemContain("Qualifier not allowed."));
	}

	@Test
	public void testPortAssignPortRefs() {
		ignoreFormattingDifferences();
		testFile(getClass().getSimpleName() + "/testPortAssignPortRefs.phdl");
		assertConstraints(issues.inLine(15).sizeIs(1).allOfThemContain("Invalid msb."));
		assertConstraints(issues.inLine(20).sizeIs(1).allOfThemContain("Invalid lsb."));
		assertConstraints(issues.inLine(25).sizeIs(1).allOfThemContain("Invalid index."));
		assertConstraints(issues.inLine(30).sizeIs(1).allOfThemContain("Array not declared."));
	}

	@Test
	public void testPortAssignUnassigned() {
		ignoreFormattingDifferences();
		testFile(getClass().getSimpleName() + "/testPortAssignUnassigned.phdl");
		assertConstraints(issues.inLine(15).sizeIs(1).allOfThemContain("Unassigned port 'test1.a'."));
		assertConstraints(issues.inLine(20).sizeIs(1).allOfThemContain("Unassigned port 'test2.b[4]'."));
		assertConstraints(issues.inLine(25).sizeIs(1).allOfThemContain("Unassigned port 'test3(1).a'."));
		assertConstraints(issues.inLine(30).sizeIs(1).allOfThemContain("Unassigned port 'test4(2).a'."));
		assertConstraints(issues.inLine(35).sizeIs(7).oneOfThemContains("Unassigned port 'test5(4).b[4]'.")
				.oneOfThemContains("Unassigned port 'test5(4).b[3]'.")
				.oneOfThemContains("Unassigned port 'test5(4).b[2]'.")
				.oneOfThemContains("Unassigned port 'test5(4).b[1]'.")
				.oneOfThemContains("Unassigned port 'test5(4).b[3]'.")
				.oneOfThemContains("Unassigned port 'test5(3).b[3]'.")
				.oneOfThemContains("Unassigned port 'test5(1).b[3]'."));
		assertConstraints(issues.inLine(40).sizeIs(7).oneOfThemContains("Unassigned port 'test6(3).b[4]'.")
				.oneOfThemContains("Unassigned port 'test6(3).b[3]'.")
				.oneOfThemContains("Unassigned port 'test6(3).b[2]'.")
				.oneOfThemContains("Unassigned port 'test6(3).b[1]'.")
				.oneOfThemContains("Unassigned port 'test6(4).b[4]'.")
				.oneOfThemContains("Unassigned port 'test6(1).b[4]'.")
				.oneOfThemContains("Unassigned port 'test6(2).b[4]'."));
		assertConstraints(issues.inLine(45).sizeIs(16).oneOfThemContains("Unassigned port 'test7(4).b[4]'.")
				.oneOfThemContains("Unassigned port 'test7(4).b[3]'.")
				.oneOfThemContains("Unassigned port 'test7(4).b[2]'.")
				.oneOfThemContains("Unassigned port 'test7(4).b[1]'.")
				.oneOfThemContains("Unassigned port 'test7(3).b[4]'.")
				.oneOfThemContains("Unassigned port 'test7(3).b[3]'.")
				.oneOfThemContains("Unassigned port 'test7(3).b[2]'.")
				.oneOfThemContains("Unassigned port 'test7(3).b[1]'.")
				.oneOfThemContains("Unassigned port 'test7(2).b[4]'.")
				.oneOfThemContains("Unassigned port 'test7(2).b[3]'.")
				.oneOfThemContains("Unassigned port 'test7(2).b[2]'.")
				.oneOfThemContains("Unassigned port 'test7(2).b[1]'.")
				.oneOfThemContains("Unassigned port 'test7(1).b[4]'.")
				.oneOfThemContains("Unassigned port 'test7(1).b[3]'.")
				.oneOfThemContains("Unassigned port 'test7(1).b[2]'.")
				.oneOfThemContains("Unassigned port 'test7(1).b[1]'."));

	}

	@Test
	public void testPortAssignWidths() {
		ignoreFormattingDifferences();
		testFile(getClass().getSimpleName() + "/testPortAssignWidths.phdl");
		assertConstraints(issues.inLine(16).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=1, right=2."));
		assertConstraints(issues.inLine(21).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=1, right=4."));
		assertConstraints(issues.inLine(26).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=1."));
		assertConstraints(issues.inLine(31).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=3."));
		assertConstraints(issues.inLine(36).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=1, right=2."));
		assertConstraints(issues.inLine(41).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=1, right=4."));
		assertConstraints(issues.inLine(46).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=1."));
		assertConstraints(issues.inLine(51).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=3."));
		assertConstraints(issues.inLine(56).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=1."));
		assertConstraints(issues.inLine(61).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=3."));
		assertConstraints(issues.inLine(66).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=16, right=1."));
		assertConstraints(issues.inLine(71).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=16, right=4."));
		assertConstraints(issues.inLine(76).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=1."));
		assertConstraints(issues.inLine(81).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=4, right=4."));
		assertConstraints(issues.inLine(86).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=16, right=1."));
		assertConstraints(issues.inLine(91).sizeIs(1).allOfThemContain("Assignment width mismatch.  Left=16, right=3."));
	}
}