package edu.byu.ee.phdl.xtext.tests;

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
		assertConstraints(issues.inLine(11).allOfThemContain("Invalid msb.").sizeIs(1));
		assertConstraints(issues.inLine(16).allOfThemContain("Invalid lsb.").sizeIs(1));
		assertConstraints(issues.inLine(21).allOfThemContain("Invalid index.").sizeIs(1));
		assertConstraints(issues.inLine(27).allOfThemContain("Qualifier not allowed.").sizeIs(1));
	}

	@Test
	public void testPortAssignPortRefs() {
		ignoreFormattingDifferences();
		testFile(getClass().getSimpleName() + "/testPortAssignPortRefs.phdl");
		assertConstraints(issues.inLine(15).allOfThemContain("Invalid msb.").sizeIs(1));
		assertConstraints(issues.inLine(20).allOfThemContain("Invalid lsb.").sizeIs(1));
		assertConstraints(issues.inLine(25).allOfThemContain("Invalid index.").sizeIs(1));
		assertConstraints(issues.inLine(30).allOfThemContain("Array not declared.").sizeIs(1));
	}

	@Test
	public void testPortAssignUnassigned() {
		ignoreFormattingDifferences();
		testFile(getClass().getSimpleName() + "/testPortAssignUnassigned.phdl");
		assertConstraints(issues.inLine(15).allOfThemContain("Unassigned port 'test1.a'.").sizeIs(1));
		assertConstraints(issues.inLine(20).allOfThemContain("Unassigned port 'test2.b[4]'.").sizeIs(1));
		assertConstraints(issues.inLine(25).allOfThemContain("Unassigned port 'test3(1).a'.").sizeIs(1));
		assertConstraints(issues.inLine(30).allOfThemContain("Unassigned port 'test4(2).a'.").sizeIs(1));
		assertConstraints(issues.inLine(35).oneOfThemContains("Unassigned port 'test5(4).b[4]'.")
				.oneOfThemContains("Unassigned port 'test5(4).b[3]'.")
				.oneOfThemContains("Unassigned port 'test5(4).b[2]'.")
				.oneOfThemContains("Unassigned port 'test5(4).b[1]'.")
				.oneOfThemContains("Unassigned port 'test5(4).b[3]'.")
				.oneOfThemContains("Unassigned port 'test5(3).b[3]'.")
				.oneOfThemContains("Unassigned port 'test5(1).b[3]'.").sizeIs(7));
		assertConstraints(issues.inLine(40).oneOfThemContains("Unassigned port 'test6(3).b[4]'.")
				.oneOfThemContains("Unassigned port 'test6(3).b[3]'.")
				.oneOfThemContains("Unassigned port 'test6(3).b[2]'.")
				.oneOfThemContains("Unassigned port 'test6(3).b[1]'.")
				.oneOfThemContains("Unassigned port 'test6(4).b[4]'.")
				.oneOfThemContains("Unassigned port 'test6(1).b[4]'.")
				.oneOfThemContains("Unassigned port 'test6(2).b[4]'.").sizeIs(7));
		assertConstraints(issues.inLine(45).oneOfThemContains("Unassigned port 'test7(4).b[4]'.")
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
				.oneOfThemContains("Unassigned port 'test7(1).b[1]'.").sizeIs(16));

	}

	@Test
	public void testPortAssignWidths() {
		ignoreFormattingDifferences();
		testFile(getClass().getSimpleName() + "/testPortAssignWidths.phdl");
		assertConstraints(issues.inLine(16).allOfThemContain("Assignment width mismatch.  Left=1, right=2.").sizeIs(1));
		assertConstraints(issues.inLine(21).allOfThemContain("Assignment width mismatch.  Left=1, right=4.").sizeIs(1));
		assertConstraints(issues.inLine(26).allOfThemContain("Assignment width mismatch.  Left=4, right=1.").sizeIs(1));
		assertConstraints(issues.inLine(31).allOfThemContain("Assignment width mismatch.  Left=4, right=3.").sizeIs(1));
		assertConstraints(issues.inLine(36).allOfThemContain("Assignment width mismatch.  Left=1, right=2.").sizeIs(1));
		assertConstraints(issues.inLine(41).allOfThemContain("Assignment width mismatch.  Left=1, right=4.").sizeIs(1));
		assertConstraints(issues.inLine(46).allOfThemContain("Assignment width mismatch.  Left=4, right=1.").sizeIs(1));
		assertConstraints(issues.inLine(51).allOfThemContain("Assignment width mismatch.  Left=4, right=3.").sizeIs(1));
		assertConstraints(issues.inLine(56).allOfThemContain("Assignment width mismatch.  Left=4, right=1.").sizeIs(1));
		assertConstraints(issues.inLine(61).allOfThemContain("Assignment width mismatch.  Left=4, right=3.").sizeIs(1));
		assertConstraints(issues.inLine(66).allOfThemContain("Assignment width mismatch.  Left=16, right=1.").sizeIs(1));
		assertConstraints(issues.inLine(71).allOfThemContain("Assignment width mismatch.  Left=16, right=4.").sizeIs(1));
		assertConstraints(issues.inLine(76).allOfThemContain("Assignment width mismatch.  Left=4, right=1.").sizeIs(1));
		assertConstraints(issues.inLine(81).allOfThemContain("Assignment width mismatch.  Left=4, right=3.").sizeIs(1));
		assertConstraints(issues.inLine(86).allOfThemContain("Assignment width mismatch.  Left=16, right=1.").sizeIs(1));
		assertConstraints(issues.inLine(91).allOfThemContain("Assignment width mismatch.  Left=16, right=3.").sizeIs(1));
	}
}