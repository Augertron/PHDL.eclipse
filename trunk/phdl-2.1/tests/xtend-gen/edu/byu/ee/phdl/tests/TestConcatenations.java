package edu.byu.ee.phdl.tests;

import edu.byu.ee.phdl.PhdlInjectorProvider;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipselabs.xtext.utils.unittesting.FluentIssueCollection;
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2;
import org.eclipselabs.xtext.utils.unittesting.XtextTest;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(value = PhdlInjectorProvider.class)
@RunWith(value = XtextRunner2.class)
@SuppressWarnings("all")
public class TestConcatenations extends XtextTest {
  @Test
  public void test_concatenations() {
    this.ignoreFormattingDifferences();
    this.testFile("TestConcatenations/test_concatenations.phdl");
    FluentIssueCollection _inLine = this.issues.inLine(22);
    FluentIssueCollection _sizeIs = _inLine.sizeIs(1);
    FluentIssueCollection _allOfThemContain = _sizeIs.allOfThemContain("Invalid msb.");
    this.assertConstraints(_allOfThemContain);
    FluentIssueCollection _inLine_1 = this.issues.inLine(27);
    FluentIssueCollection _sizeIs_1 = _inLine_1.sizeIs(1);
    FluentIssueCollection _allOfThemContain_1 = _sizeIs_1.allOfThemContain("Invalid lsb.");
    this.assertConstraints(_allOfThemContain_1);
    FluentIssueCollection _inLine_2 = this.issues.inLine(32);
    FluentIssueCollection _sizeIs_2 = _inLine_2.sizeIs(1);
    FluentIssueCollection _allOfThemContain_2 = _sizeIs_2.allOfThemContain("Invalid slice.");
    this.assertConstraints(_allOfThemContain_2);
    FluentIssueCollection _inLine_3 = this.issues.inLine(37);
    FluentIssueCollection _sizeIs_3 = _inLine_3.sizeIs(1);
    FluentIssueCollection _allOfThemContain_3 = _sizeIs_3.allOfThemContain("Array not declared.");
    this.assertConstraints(_allOfThemContain_3);
    FluentIssueCollection _inLine_4 = this.issues.inLine(42);
    FluentIssueCollection _sizeIs_4 = _inLine_4.sizeIs(1);
    FluentIssueCollection _allOfThemContain_4 = _sizeIs_4.allOfThemContain("Array not declared.");
    this.assertConstraints(_allOfThemContain_4);
    FluentIssueCollection _inLine_5 = this.issues.inLine(47);
    FluentIssueCollection _sizeIs_5 = _inLine_5.sizeIs(1);
    FluentIssueCollection _allOfThemContain_5 = _sizeIs_5.allOfThemContain("Cannot replicate vector.");
    this.assertConstraints(_allOfThemContain_5);
    FluentIssueCollection _inLine_6 = this.issues.inLine(52);
    FluentIssueCollection _sizeIs_6 = _inLine_6.sizeIs(1);
    FluentIssueCollection _oneOfThemContains = _sizeIs_6.oneOfThemContains("Invalid msb.");
    this.assertConstraints(_oneOfThemContains);
    FluentIssueCollection _inLine_7 = this.issues.inLine(52);
    FluentIssueCollection _sizeIs_7 = _inLine_7.sizeIs(1);
    FluentIssueCollection _oneOfThemContains_1 = _sizeIs_7.oneOfThemContains("Invalid lsb.");
    this.assertConstraints(_oneOfThemContains_1);
    FluentIssueCollection _inLine_8 = this.issues.inLine(57);
    FluentIssueCollection _sizeIs_8 = _inLine_8.sizeIs(1);
    FluentIssueCollection _allOfThemContain_6 = _sizeIs_8.allOfThemContain("Cannot replicate slices.");
    this.assertConstraints(_allOfThemContain_6);
    FluentIssueCollection _inLine_9 = this.issues.inLine(62);
    FluentIssueCollection _sizeIs_9 = _inLine_9.sizeIs(1);
    FluentIssueCollection _allOfThemContain_7 = _sizeIs_9.allOfThemContain("Invalid index.");
    this.assertConstraints(_allOfThemContain_7);
    FluentIssueCollection _inLine_10 = this.issues.inLine(67);
    FluentIssueCollection _sizeIs_10 = _inLine_10.sizeIs(1);
    FluentIssueCollection _allOfThemContain_8 = _sizeIs_10.allOfThemContain("Cannot replicate implicit vector.");
    this.assertConstraints(_allOfThemContain_8);
    FluentIssueCollection _inLine_11 = this.issues.inLine(71);
    FluentIssueCollection _sizeIs_11 = _inLine_11.sizeIs(0);
    this.assertConstraints(_sizeIs_11);
  }
}
