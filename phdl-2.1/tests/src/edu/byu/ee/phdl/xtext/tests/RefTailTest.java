package edu.byu.ee.phdl.xtext.tests;

import java.io.File;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2;
import org.eclipselabs.xtext.utils.unittesting.XtextTest;
import org.junit.Test;
import org.junit.runner.RunWith;

import edu.byu.ee.phdl.PhdlInjectorProvider;

@InjectWith(PhdlInjectorProvider.class)
@RunWith(XtextRunner2.class)
public class RefTailTest extends XtextTest {

	private static String sep = File.separator;

	@Test
	public void testRefTails() {
		ignoreFormattingDifferences();
		testFile(getClass().getSimpleName() + sep + new Throwable().getStackTrace()[0].getMethodName() + ".phdl");

		// Correct SubInst Ref
		assertConstraints(issues.inLine(49).sizeIs(0));
		assertConstraints(issues.inLine(50).sizeIs(0));
		assertConstraints(issues.inLine(51).sizeIs(0));
		assertConstraints(issues.inLine(52).sizeIs(0));

		assertConstraints(issues.inLine(54).sizeIs(0));
		assertConstraints(issues.inLine(55).sizeIs(0));
		assertConstraints(issues.inLine(56).sizeIs(0));
		assertConstraints(issues.inLine(57).sizeIs(0));

		// Invalid Attribute Name
		assertConstraints(issues.inLine(62).oneOfThemContains("Invalid attribute name.").sizeIs(2));
		assertConstraints(issues.inLine(63).allOfThemContain("Invalid attribute name.").sizeIs(1));
		assertConstraints(issues.inLine(64).allOfThemContain("Invalid attribute name.").sizeIs(1));
		assertConstraints(issues.inLine(65).allOfThemContain("Invalid attribute name.").sizeIs(1));
		assertConstraints(issues.inLine(66).allOfThemContain("Invalid attribute name.").sizeIs(1));
		assertConstraints(issues.inLine(67).allOfThemContain("Invalid attribute name.").sizeIs(1));
		assertConstraints(issues.inLine(68).allOfThemContain("Invalid attribute name.").sizeIs(1));

		// //////////////////////
		// RefTail (Inst) Tests
		// //////////////////////
		assertConstraints(issues.inLine(74).sizeIs(0));
		assertConstraints(issues.inLine(75).sizeIs(0));
		assertConstraints(issues.inLine(76).sizeIs(0));
		assertConstraints(issues.inLine(77).sizeIs(0));

		// Invalid MSB
		assertConstraints(issues.inLine(80).sizeIs(0));
		assertConstraints(issues.inLine(81).allOfThemContain("Invalid msb.").sizeIs(1));
		assertConstraints(issues.inLine(82).sizeIs(0));
		assertConstraints(issues.inLine(83).allOfThemContain("Invalid msb.").sizeIs(1));

		// Invalid MSB
		assertConstraints(issues.inLine(86).sizeIs(0));
		assertConstraints(issues.inLine(87).allOfThemContain("Invalid lsb.").sizeIs(1));
		assertConstraints(issues.inLine(88).sizeIs(0));
		assertConstraints(issues.inLine(89).allOfThemContain("Invalid lsb.").sizeIs(1));

		// Invalid Index Error
		assertConstraints(issues.inLine(92).sizeIs(0));
		assertConstraints(issues.inLine(93).sizeIs(0));
		assertConstraints(issues.inLine(94).allOfThemContain("Invalid index.").sizeIs(1));
		assertConstraints(issues.inLine(95).allOfThemContain("Invalid index.").sizeIs(1));
		assertConstraints(issues.inLine(96).allOfThemContain("Invalid index.").sizeIs(1));
		assertConstraints(issues.inLine(97).allOfThemContain("Invalid index.").sizeIs(1));
		assertConstraints(issues.inLine(98).allOfThemContain("Invalid index.").sizeIs(1));
		assertConstraints(issues.inLine(99).allOfThemContain("Invalid index.").sizeIs(1));
		assertConstraints(issues.inLine(100).allOfThemContain("Invalid index.").sizeIs(1));
		assertConstraints(issues.inLine(101).allOfThemContain("Invalid index.").sizeIs(1));
		assertConstraints(issues.inLine(102).allOfThemContain("Invalid index.").sizeIs(2));

		// Indices Not Allowed Error
		assertConstraints(issues.inLine(105).allOfThemContain("Indices not allowed.").sizeIs(1));
		assertConstraints(issues.inLine(106).allOfThemContain("Indices not allowed.").sizeIs(1));

		// ////////////////////////
		// RefTail (SubInst) Tests
		// ////////////////////////
		assertConstraints(issues.inLine(112).sizeIs(0));
		assertConstraints(issues.inLine(113).sizeIs(0));
		assertConstraints(issues.inLine(114).sizeIs(0));

		assertConstraints(issues.inLine(117).sizeIs(0));
		assertConstraints(issues.inLine(118).sizeIs(0));
		assertConstraints(issues.inLine(119).sizeIs(0));

		// Invalid MSB
		assertConstraints(issues.inLine(123).sizeIs(0));
		assertConstraints(issues.inLine(124).allOfThemContain("Invalid msb.").sizeIs(1));
		assertConstraints(issues.inLine(125).sizeIs(0));
		assertConstraints(issues.inLine(126).allOfThemContain("Invalid msb.").sizeIs(1));

		// Invalid MSB
		assertConstraints(issues.inLine(129).sizeIs(0));
		assertConstraints(issues.inLine(130).allOfThemContain("Invalid lsb.").sizeIs(1));
		assertConstraints(issues.inLine(131).sizeIs(0));
		assertConstraints(issues.inLine(132).allOfThemContain("Invalid lsb.").sizeIs(1));

		// Invalid Index Error
		assertConstraints(issues.inLine(135).sizeIs(0));
		assertConstraints(issues.inLine(136).sizeIs(0));
		assertConstraints(issues.inLine(137).allOfThemContain("Invalid index.").sizeIs(1));
		assertConstraints(issues.inLine(138).allOfThemContain("Invalid index.").sizeIs(1));
		assertConstraints(issues.inLine(139).allOfThemContain("Invalid index.").sizeIs(1));
		assertConstraints(issues.inLine(140).allOfThemContain("Invalid index.").sizeIs(1));
		assertConstraints(issues.inLine(141).allOfThemContain("Invalid index.").sizeIs(1));
		assertConstraints(issues.inLine(142).allOfThemContain("Invalid index.").sizeIs(1));
		assertConstraints(issues.inLine(143).allOfThemContain("Invalid index.").sizeIs(1));
		assertConstraints(issues.inLine(144).allOfThemContain("Invalid index.").sizeIs(1));
		assertConstraints(issues.inLine(145).allOfThemContain("Invalid index.").sizeIs(2));

		// Indices Not Allowed Error
		assertConstraints(issues.inLine(148).allOfThemContain("Indices not allowed.").sizeIs(1));
		assertConstraints(issues.inLine(149).allOfThemContain("Indices not allowed.").sizeIs(1));

		// //////////////////////////////////////////
		// Test Attribute Indices Not Allowed Error
		// //////////////////////////////////////////
		assertConstraints(issues.inLine(154).allOfThemContain("Indices not allowed.").sizeIs(1));
		assertConstraints(issues.inLine(155).allOfThemContain("Indices not allowed.").sizeIs(1));
		assertConstraints(issues.inLine(156).allOfThemContain("Indices not allowed.").sizeIs(1));

	}
}