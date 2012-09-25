package edu.byu.ee.phdl.xtext.tests;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2;
import org.eclipselabs.xtext.utils.unittesting.XtextTest;
import org.junit.Test;
import org.junit.runner.RunWith;

import edu.byu.ee.phdl.PhdlInjectorProvider;

@InjectWith(PhdlInjectorProvider.class)
@RunWith(XtextRunner2.class)
public class DeviceTest extends XtextTest {

	@Test
	public void testPhysicalPins() {
		ignoreFormattingDifferences();
		testFile(getClass().getSimpleName() + "/testPhysicalPins.phdl");
		assertConstraints(issues.nOfThemContain(6, "Duplicate physical pin name."));
		assertConstraints(issues.errorsOnly().sizeIs(6));
	}

	@Test
	public void testPincountAttr() {
		ignoreFormattingDifferences();
		testFile(getClass().getSimpleName() + "/testPincountAttr.phdl");
		assertConstraints(issues.oneOfThemContains("Expected 3 declared pins, found 4."));
		assertConstraints(issues.oneOfThemContains("PINCOUNT attribute must be an integer."));
		assertConstraints(issues.errorsOnly().sizeIs(2));
	}

	@Test
	public void testPinDecls() {
		ignoreFormattingDifferences();
		testFile(getClass().getSimpleName() + "/testInvalidPinDecl.phdl");
		assertConstraints(issues.errorsOnly().oneOfThemContains("Pin declaration width mismatch.  Left=1, right=2."));
		assertConstraints(issues.errorsOnly().oneOfThemContains("Pin declaration width mismatch.  Left=2, right=1."));
		assertConstraints(issues.errorsOnly().sizeIs(2));
	}

	@Test
	public void testRefprefixAttr() {
		ignoreFormattingDifferences();
		testFile(getClass().getSimpleName() + "/testRefprefixAttr.phdl");
		assertConstraints(issues.allOfThemContain("Only uppercase REFPREFIX value recommended."));
		assertConstraints(issues.warningsOnly().sizeIs(1));
	}

	@Test
	public void testReqAttrs() {
		ignoreFormattingDifferences();
		testFile(getClass().getSimpleName() + "/testReqAttrs.phdl");
		assertConstraints(issues.oneOfThemContains("Required attribute 'REFPREFIX' missing."));
		assertConstraints(issues.oneOfThemContains("Required attribute 'LIBRARY' missing."));
		assertConstraints(issues.oneOfThemContains("Required attribute 'FOOTPRINT' missing."));
		assertConstraints(issues.errorsOnly().sizeIs(3));
	}

	@Test
	public void testUppercaseAttrs() {
		ignoreFormattingDifferences();
		testFile(getClass().getSimpleName() + "/testUppercaseAttrs.phdl");
		assertConstraints(issues.allOfThemContain("Only uppercase attribute names are recommended"));
		assertConstraints(issues.warningsOnly().sizeIs(6));
	}

	@Test
	public void testValidDevices() {
		ignoreFormattingDifferences();
		testFile(getClass().getSimpleName() + "/testValidDevice.phdl");
		assertConstraints(issues.sizeIs(0));
	}
}