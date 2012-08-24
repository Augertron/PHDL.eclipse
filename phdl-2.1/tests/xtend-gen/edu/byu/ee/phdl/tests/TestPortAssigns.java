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
public class TestPortAssigns extends XtextTest {
  @Test
  public void test_port_assign_invalid_qualifiers() {
    this.ignoreFormattingDifferences();
    this.testFile("TestPortAssigns/test_port_assign_qualifiers.phdl");
    FluentIssueCollection _inLine = this.issues.inLine(11);
    FluentIssueCollection _sizeIs = _inLine.sizeIs(1);
    FluentIssueCollection _allOfThemContain = _sizeIs.allOfThemContain("Invalid msb.");
    this.assertConstraints(_allOfThemContain);
    FluentIssueCollection _inLine_1 = this.issues.inLine(16);
    FluentIssueCollection _sizeIs_1 = _inLine_1.sizeIs(1);
    FluentIssueCollection _allOfThemContain_1 = _sizeIs_1.allOfThemContain("Invalid lsb.");
    this.assertConstraints(_allOfThemContain_1);
    FluentIssueCollection _inLine_2 = this.issues.inLine(21);
    FluentIssueCollection _sizeIs_2 = _inLine_2.sizeIs(1);
    FluentIssueCollection _allOfThemContain_2 = _sizeIs_2.allOfThemContain("Invalid index.");
    this.assertConstraints(_allOfThemContain_2);
    FluentIssueCollection _inLine_3 = this.issues.inLine(27);
    FluentIssueCollection _sizeIs_3 = _inLine_3.sizeIs(1);
    FluentIssueCollection _allOfThemContain_3 = _sizeIs_3.allOfThemContain("Qualifier not allowed.");
    this.assertConstraints(_allOfThemContain_3);
  }
  
  @Test
  public void test_port_assign_port_refs() {
    this.ignoreFormattingDifferences();
    this.testFile("TestPortAssigns/test_port_assign_port_refs.phdl");
    FluentIssueCollection _inLine = this.issues.inLine(15);
    FluentIssueCollection _sizeIs = _inLine.sizeIs(1);
    FluentIssueCollection _allOfThemContain = _sizeIs.allOfThemContain("Invalid msb.");
    this.assertConstraints(_allOfThemContain);
    FluentIssueCollection _inLine_1 = this.issues.inLine(20);
    FluentIssueCollection _sizeIs_1 = _inLine_1.sizeIs(1);
    FluentIssueCollection _allOfThemContain_1 = _sizeIs_1.allOfThemContain("Invalid lsb.");
    this.assertConstraints(_allOfThemContain_1);
    FluentIssueCollection _inLine_2 = this.issues.inLine(25);
    FluentIssueCollection _sizeIs_2 = _inLine_2.sizeIs(1);
    FluentIssueCollection _allOfThemContain_2 = _sizeIs_2.allOfThemContain("Invalid index.");
    this.assertConstraints(_allOfThemContain_2);
    FluentIssueCollection _inLine_3 = this.issues.inLine(30);
    FluentIssueCollection _sizeIs_3 = _inLine_3.sizeIs(1);
    FluentIssueCollection _allOfThemContain_3 = _sizeIs_3.allOfThemContain("Array not declared.");
    this.assertConstraints(_allOfThemContain_3);
  }
  
  @Test
  public void test_port_assign_widths() {
    this.ignoreFormattingDifferences();
    this.testFile("TestPortAssigns/test_port_assign_widths.phdl");
    FluentIssueCollection _inLine = this.issues.inLine(16);
    FluentIssueCollection _sizeIs = _inLine.sizeIs(1);
    FluentIssueCollection _allOfThemContain = _sizeIs.allOfThemContain("Assignment width mismatch.  Left=1, right=2.");
    this.assertConstraints(_allOfThemContain);
    FluentIssueCollection _inLine_1 = this.issues.inLine(21);
    FluentIssueCollection _sizeIs_1 = _inLine_1.sizeIs(1);
    FluentIssueCollection _allOfThemContain_1 = _sizeIs_1.allOfThemContain("Assignment width mismatch.  Left=1, right=4.");
    this.assertConstraints(_allOfThemContain_1);
    FluentIssueCollection _inLine_2 = this.issues.inLine(26);
    FluentIssueCollection _sizeIs_2 = _inLine_2.sizeIs(1);
    FluentIssueCollection _allOfThemContain_2 = _sizeIs_2.allOfThemContain("Assignment width mismatch.  Left=4, right=1.");
    this.assertConstraints(_allOfThemContain_2);
    FluentIssueCollection _inLine_3 = this.issues.inLine(31);
    FluentIssueCollection _sizeIs_3 = _inLine_3.sizeIs(1);
    FluentIssueCollection _allOfThemContain_3 = _sizeIs_3.allOfThemContain("Assignment width mismatch.  Left=4, right=3.");
    this.assertConstraints(_allOfThemContain_3);
    FluentIssueCollection _inLine_4 = this.issues.inLine(36);
    FluentIssueCollection _sizeIs_4 = _inLine_4.sizeIs(1);
    FluentIssueCollection _allOfThemContain_4 = _sizeIs_4.allOfThemContain("Assignment width mismatch.  Left=1, right=2.");
    this.assertConstraints(_allOfThemContain_4);
    FluentIssueCollection _inLine_5 = this.issues.inLine(41);
    FluentIssueCollection _sizeIs_5 = _inLine_5.sizeIs(1);
    FluentIssueCollection _allOfThemContain_5 = _sizeIs_5.allOfThemContain("Assignment width mismatch.  Left=1, right=4.");
    this.assertConstraints(_allOfThemContain_5);
    FluentIssueCollection _inLine_6 = this.issues.inLine(46);
    FluentIssueCollection _sizeIs_6 = _inLine_6.sizeIs(1);
    FluentIssueCollection _allOfThemContain_6 = _sizeIs_6.allOfThemContain("Assignment width mismatch.  Left=4, right=1.");
    this.assertConstraints(_allOfThemContain_6);
    FluentIssueCollection _inLine_7 = this.issues.inLine(51);
    FluentIssueCollection _sizeIs_7 = _inLine_7.sizeIs(1);
    FluentIssueCollection _allOfThemContain_7 = _sizeIs_7.allOfThemContain("Assignment width mismatch.  Left=4, right=3.");
    this.assertConstraints(_allOfThemContain_7);
    FluentIssueCollection _inLine_8 = this.issues.inLine(56);
    FluentIssueCollection _sizeIs_8 = _inLine_8.sizeIs(1);
    FluentIssueCollection _allOfThemContain_8 = _sizeIs_8.allOfThemContain("Assignment width mismatch.  Left=4, right=1.");
    this.assertConstraints(_allOfThemContain_8);
    FluentIssueCollection _inLine_9 = this.issues.inLine(61);
    FluentIssueCollection _sizeIs_9 = _inLine_9.sizeIs(1);
    FluentIssueCollection _allOfThemContain_9 = _sizeIs_9.allOfThemContain("Assignment width mismatch.  Left=4, right=3.");
    this.assertConstraints(_allOfThemContain_9);
    FluentIssueCollection _inLine_10 = this.issues.inLine(66);
    FluentIssueCollection _sizeIs_10 = _inLine_10.sizeIs(1);
    FluentIssueCollection _allOfThemContain_10 = _sizeIs_10.allOfThemContain("Assignment width mismatch.  Left=16, right=1.");
    this.assertConstraints(_allOfThemContain_10);
    FluentIssueCollection _inLine_11 = this.issues.inLine(71);
    FluentIssueCollection _sizeIs_11 = _inLine_11.sizeIs(1);
    FluentIssueCollection _allOfThemContain_11 = _sizeIs_11.allOfThemContain("Assignment width mismatch.  Left=16, right=4.");
    this.assertConstraints(_allOfThemContain_11);
    FluentIssueCollection _inLine_12 = this.issues.inLine(76);
    FluentIssueCollection _sizeIs_12 = _inLine_12.sizeIs(1);
    FluentIssueCollection _allOfThemContain_12 = _sizeIs_12.allOfThemContain("Assignment width mismatch.  Left=4, right=1.");
    this.assertConstraints(_allOfThemContain_12);
    FluentIssueCollection _inLine_13 = this.issues.inLine(81);
    FluentIssueCollection _sizeIs_13 = _inLine_13.sizeIs(1);
    FluentIssueCollection _allOfThemContain_13 = _sizeIs_13.allOfThemContain("Assignment width mismatch.  Left=4, right=4.");
    this.assertConstraints(_allOfThemContain_13);
    FluentIssueCollection _inLine_14 = this.issues.inLine(86);
    FluentIssueCollection _sizeIs_14 = _inLine_14.sizeIs(1);
    FluentIssueCollection _allOfThemContain_14 = _sizeIs_14.allOfThemContain("Assignment width mismatch.  Left=16, right=1.");
    this.assertConstraints(_allOfThemContain_14);
    FluentIssueCollection _inLine_15 = this.issues.inLine(91);
    FluentIssueCollection _sizeIs_15 = _inLine_15.sizeIs(1);
    FluentIssueCollection _allOfThemContain_15 = _sizeIs_15.allOfThemContain("Assignment width mismatch.  Left=16, right=3.");
    this.assertConstraints(_allOfThemContain_15);
  }
  
  @Test
  public void test_port_assign_unassigned() {
    this.ignoreFormattingDifferences();
    this.testFile("TestPortAssigns/test_port_assign_unassigned.phdl");
    FluentIssueCollection _inLine = this.issues.inLine(15);
    FluentIssueCollection _sizeIs = _inLine.sizeIs(1);
    FluentIssueCollection _allOfThemContain = _sizeIs.allOfThemContain("Unassigned port \'test1.a\'.");
    this.assertConstraints(_allOfThemContain);
    FluentIssueCollection _inLine_1 = this.issues.inLine(20);
    FluentIssueCollection _sizeIs_1 = _inLine_1.sizeIs(1);
    FluentIssueCollection _allOfThemContain_1 = _sizeIs_1.allOfThemContain("Unassigned port \'test2.b[4]\'.");
    this.assertConstraints(_allOfThemContain_1);
    FluentIssueCollection _inLine_2 = this.issues.inLine(25);
    FluentIssueCollection _sizeIs_2 = _inLine_2.sizeIs(1);
    FluentIssueCollection _allOfThemContain_2 = _sizeIs_2.allOfThemContain("Unassigned port \'test3(1).a\'.");
    this.assertConstraints(_allOfThemContain_2);
    FluentIssueCollection _inLine_3 = this.issues.inLine(30);
    FluentIssueCollection _sizeIs_3 = _inLine_3.sizeIs(1);
    FluentIssueCollection _allOfThemContain_3 = _sizeIs_3.allOfThemContain("Unassigned port \'test4(2).a\'.");
    this.assertConstraints(_allOfThemContain_3);
    FluentIssueCollection _inLine_4 = this.issues.inLine(35);
    FluentIssueCollection _sizeIs_4 = _inLine_4.sizeIs(7);
    FluentIssueCollection _oneOfThemContains = _sizeIs_4.oneOfThemContains("Unassigned port \'test5(4).b[4]\'.");
    FluentIssueCollection _oneOfThemContains_1 = _oneOfThemContains.oneOfThemContains("Unassigned port \'test5(4).b[3]\'.");
    FluentIssueCollection _oneOfThemContains_2 = _oneOfThemContains_1.oneOfThemContains("Unassigned port \'test5(4).b[2]\'.");
    FluentIssueCollection _oneOfThemContains_3 = _oneOfThemContains_2.oneOfThemContains("Unassigned port \'test5(4).b[1]\'.");
    FluentIssueCollection _oneOfThemContains_4 = _oneOfThemContains_3.oneOfThemContains("Unassigned port \'test5(4).b[3]\'.");
    FluentIssueCollection _oneOfThemContains_5 = _oneOfThemContains_4.oneOfThemContains("Unassigned port \'test5(3).b[3]\'.");
    FluentIssueCollection _oneOfThemContains_6 = _oneOfThemContains_5.oneOfThemContains("Unassigned port \'test5(1).b[3]\'.");
    this.assertConstraints(_oneOfThemContains_6);
    FluentIssueCollection _inLine_5 = this.issues.inLine(40);
    FluentIssueCollection _sizeIs_5 = _inLine_5.sizeIs(7);
    FluentIssueCollection _oneOfThemContains_7 = _sizeIs_5.oneOfThemContains("Unassigned port \'test6(3).b[4]\'.");
    FluentIssueCollection _oneOfThemContains_8 = _oneOfThemContains_7.oneOfThemContains("Unassigned port \'test6(3).b[3]\'.");
    FluentIssueCollection _oneOfThemContains_9 = _oneOfThemContains_8.oneOfThemContains("Unassigned port \'test6(3).b[2]\'.");
    FluentIssueCollection _oneOfThemContains_10 = _oneOfThemContains_9.oneOfThemContains("Unassigned port \'test6(3).b[1]\'.");
    FluentIssueCollection _oneOfThemContains_11 = _oneOfThemContains_10.oneOfThemContains("Unassigned port \'test6(4).b[4]\'.");
    FluentIssueCollection _oneOfThemContains_12 = _oneOfThemContains_11.oneOfThemContains("Unassigned port \'test6(1).b[4]\'.");
    FluentIssueCollection _oneOfThemContains_13 = _oneOfThemContains_12.oneOfThemContains("Unassigned port \'test6(2).b[4]\'.");
    this.assertConstraints(_oneOfThemContains_13);
    FluentIssueCollection _inLine_6 = this.issues.inLine(45);
    FluentIssueCollection _sizeIs_6 = _inLine_6.sizeIs(16);
    FluentIssueCollection _oneOfThemContains_14 = _sizeIs_6.oneOfThemContains("Unassigned port \'test7(4).b[4]\'.");
    FluentIssueCollection _oneOfThemContains_15 = _oneOfThemContains_14.oneOfThemContains("Unassigned port \'test7(4).b[3]\'.");
    FluentIssueCollection _oneOfThemContains_16 = _oneOfThemContains_15.oneOfThemContains("Unassigned port \'test7(4).b[2]\'.");
    FluentIssueCollection _oneOfThemContains_17 = _oneOfThemContains_16.oneOfThemContains("Unassigned port \'test7(4).b[1]\'.");
    FluentIssueCollection _oneOfThemContains_18 = _oneOfThemContains_17.oneOfThemContains("Unassigned port \'test7(3).b[4]\'.");
    FluentIssueCollection _oneOfThemContains_19 = _oneOfThemContains_18.oneOfThemContains("Unassigned port \'test7(3).b[3]\'.");
    FluentIssueCollection _oneOfThemContains_20 = _oneOfThemContains_19.oneOfThemContains("Unassigned port \'test7(3).b[2]\'.");
    FluentIssueCollection _oneOfThemContains_21 = _oneOfThemContains_20.oneOfThemContains("Unassigned port \'test7(3).b[1]\'.");
    FluentIssueCollection _oneOfThemContains_22 = _oneOfThemContains_21.oneOfThemContains("Unassigned port \'test7(2).b[4]\'.");
    FluentIssueCollection _oneOfThemContains_23 = _oneOfThemContains_22.oneOfThemContains("Unassigned port \'test7(2).b[3]\'.");
    FluentIssueCollection _oneOfThemContains_24 = _oneOfThemContains_23.oneOfThemContains("Unassigned port \'test7(2).b[2]\'.");
    FluentIssueCollection _oneOfThemContains_25 = _oneOfThemContains_24.oneOfThemContains("Unassigned port \'test7(2).b[1]\'.");
    FluentIssueCollection _oneOfThemContains_26 = _oneOfThemContains_25.oneOfThemContains("Unassigned port \'test7(1).b[4]\'.");
    FluentIssueCollection _oneOfThemContains_27 = _oneOfThemContains_26.oneOfThemContains("Unassigned port \'test7(1).b[3]\'.");
    FluentIssueCollection _oneOfThemContains_28 = _oneOfThemContains_27.oneOfThemContains("Unassigned port \'test7(1).b[2]\'.");
    FluentIssueCollection _oneOfThemContains_29 = _oneOfThemContains_28.oneOfThemContains("Unassigned port \'test7(1).b[1]\'.");
    this.assertConstraints(_oneOfThemContains_29);
  }
}
