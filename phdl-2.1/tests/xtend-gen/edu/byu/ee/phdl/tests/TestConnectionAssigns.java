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
public class TestConnectionAssigns extends XtextTest {
  @Test
  public void test_connection_assign_refs() {
    this.ignoreFormattingDifferences();
    this.testFile("TestConnectionAssigns/test_connection_assign_refs.phdl");
    FluentIssueCollection _inLine = this.issues.inLine(6);
    FluentIssueCollection _sizeIs = _inLine.sizeIs(1);
    FluentIssueCollection _allOfThemContain = _sizeIs.allOfThemContain("Array not declared.");
    this.assertConstraints(_allOfThemContain);
    FluentIssueCollection _inLine_1 = this.issues.inLine(9);
    FluentIssueCollection _sizeIs_1 = _inLine_1.sizeIs(1);
    FluentIssueCollection _allOfThemContain_1 = _sizeIs_1.allOfThemContain("Invalid msb.");
    this.assertConstraints(_allOfThemContain_1);
    FluentIssueCollection _inLine_2 = this.issues.inLine(12);
    FluentIssueCollection _sizeIs_2 = _inLine_2.sizeIs(1);
    FluentIssueCollection _allOfThemContain_2 = _sizeIs_2.allOfThemContain("Invalid lsb.");
    this.assertConstraints(_allOfThemContain_2);
    FluentIssueCollection _inLine_3 = this.issues.inLine(15);
    FluentIssueCollection _sizeIs_3 = _inLine_3.sizeIs(1);
    FluentIssueCollection _allOfThemContain_3 = _sizeIs_3.allOfThemContain("Invalid index.");
    this.assertConstraints(_allOfThemContain_3);
  }
  
  @Test
  public void test_connection_assign_widths() {
    this.ignoreFormattingDifferences();
    this.testFile("TestCOnnectionAssigns/test_connection_assign_widths.phdl");
    FluentIssueCollection _inLine = this.issues.inLine(6);
    FluentIssueCollection _sizeIs = _inLine.sizeIs(1);
    FluentIssueCollection _allOfThemContain = _sizeIs.allOfThemContain("Assignment width mismatch.  Left=1, right=2.");
    this.assertConstraints(_allOfThemContain);
    FluentIssueCollection _inLine_1 = this.issues.inLine(9);
    FluentIssueCollection _sizeIs_1 = _inLine_1.sizeIs(1);
    FluentIssueCollection _allOfThemContain_1 = _sizeIs_1.allOfThemContain("Assignment width mismatch.  Left=1, right=4.");
    this.assertConstraints(_allOfThemContain_1);
    FluentIssueCollection _inLine_2 = this.issues.inLine(12);
    FluentIssueCollection _sizeIs_2 = _inLine_2.sizeIs(1);
    FluentIssueCollection _allOfThemContain_2 = _sizeIs_2.allOfThemContain("Assignment width mismatch.  Left=1, right=3.");
    this.assertConstraints(_allOfThemContain_2);
    FluentIssueCollection _inLine_3 = this.issues.inLine(15);
    FluentIssueCollection _sizeIs_3 = _inLine_3.sizeIs(1);
    FluentIssueCollection _allOfThemContain_3 = _sizeIs_3.allOfThemContain("Assignment width mismatch.  Left=1, right=8.");
    this.assertConstraints(_allOfThemContain_3);
    FluentIssueCollection _inLine_4 = this.issues.inLine(18);
    FluentIssueCollection _sizeIs_4 = _inLine_4.sizeIs(1);
    FluentIssueCollection _allOfThemContain_4 = _sizeIs_4.allOfThemContain("Assignment width mismatch.  Left=4, right=1.");
    this.assertConstraints(_allOfThemContain_4);
    FluentIssueCollection _inLine_5 = this.issues.inLine(21);
    FluentIssueCollection _sizeIs_5 = _inLine_5.sizeIs(1);
    FluentIssueCollection _allOfThemContain_5 = _sizeIs_5.allOfThemContain("Assignment width mismatch.  Left=4, right=2.");
    this.assertConstraints(_allOfThemContain_5);
    FluentIssueCollection _inLine_6 = this.issues.inLine(24);
    FluentIssueCollection _sizeIs_6 = _inLine_6.sizeIs(1);
    FluentIssueCollection _allOfThemContain_6 = _sizeIs_6.allOfThemContain("Assignment width mismatch.  Left=4, right=3.");
    this.assertConstraints(_allOfThemContain_6);
    FluentIssueCollection _inLine_7 = this.issues.inLine(27);
    FluentIssueCollection _sizeIs_7 = _inLine_7.sizeIs(1);
    FluentIssueCollection _allOfThemContain_7 = _sizeIs_7.allOfThemContain("Assignment width mismatch.  Left=4, right=8.");
    this.assertConstraints(_allOfThemContain_7);
  }
}
