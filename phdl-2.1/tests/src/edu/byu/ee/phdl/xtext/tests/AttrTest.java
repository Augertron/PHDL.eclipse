package edu.byu.ee.phdl.xtext.tests;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2;
import org.eclipselabs.xtext.utils.unittesting.XtextTest;
import org.junit.Test;
import org.junit.runner.RunWith;

import edu.byu.ee.phdl.PhdlInjectorProvider;

@InjectWith(PhdlInjectorProvider.class)
@RunWith(XtextRunner2.class)
public class AttrTest extends XtextTest {

	@Test
	public void testAttrs() {
		ignoreFormattingDifferences();
		testFile(getClass().getSimpleName() + "/testAttrs.phdl");

		// Test Single Instance Reference to a declared Attribute
		assertConstraints(issues.inLine(17).sizeIs(0));

		// Test Arrayed Instance Reference to a declared Attribute
		assertConstraints(issues.inLine(24).sizeIs(0));
		assertConstraints(issues.inLine(25).sizeIs(0));
		assertConstraints(issues.inLine(26).sizeIs(0));
		assertConstraints(issues.inLine(27).sizeIs(0));
		assertConstraints(issues.inLine(28).sizeIs(0));

		// Test Single Instance Reference to a not declared Attribute
		assertConstraints(issues.inLine(47).allOfThemContain("Couldn't resolve reference to Attr 'REFDES'.").sizeIs(1));

		// Test Arrayed Instance Reference to a declared Attribute
		assertConstraints(issues.inLine(54).allOfThemContain("Couldn't resolve reference to Attr 'REFDES'.").sizeIs(1));
		assertConstraints(issues.inLine(55).allOfThemContain("Couldn't resolve reference to Attr 'REFDES'.").sizeIs(1));
		assertConstraints(issues.inLine(56).allOfThemContain("Couldn't resolve reference to Attr 'REFDES'.").sizeIs(1));
		assertConstraints(issues.inLine(57).allOfThemContain("Couldn't resolve reference to Attr 'REFDES'.").sizeIs(1));
		assertConstraints(issues.inLine(58).allOfThemContain("Couldn't resolve reference to Attr 'REFDES'.").sizeIs(1));

		// Declare attr in instance
		assertConstraints(issues.inLine(66).sizeIs(0));
		assertConstraints(issues.inLine(67).sizeIs(0));

		// Declare attr in instance array
		assertConstraints(issues.inLine(74).sizeIs(0));
		assertConstraints(issues.inLine(75).sizeIs(0));
		assertConstraints(issues.inLine(76).sizeIs(0));
		assertConstraints(issues.inLine(77).sizeIs(0));
		assertConstraints(issues.inLine(78).sizeIs(0));
		assertConstraints(issues.inLine(79).sizeIs(0));
	}
}
