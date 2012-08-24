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
public class TestDevices extends XtextTest {
  @Test
  public void test_physical_pin() {
    this.testFile("TestDevices/test_physical_pin.phdl");
    FluentIssueCollection _nOfThemContain = this.issues.nOfThemContain(6, "Duplicate physical pin name.");
    this.assertConstraints(_nOfThemContain);
    FluentIssueCollection _errorsOnly = this.issues.errorsOnly();
    FluentIssueCollection _sizeIs = _errorsOnly.sizeIs(6);
    this.assertConstraints(_sizeIs);
  }
  
  @Test
  public void test_pin_decls() {
    this.testFile("TestDevices/test_invalid_pin_decl.phdl");
    FluentIssueCollection _errorsOnly = this.issues.errorsOnly();
    FluentIssueCollection _oneOfThemContains = _errorsOnly.oneOfThemContains("Pin declaration width mismatch.  Left=1, right=2.");
    this.assertConstraints(_oneOfThemContains);
    FluentIssueCollection _errorsOnly_1 = this.issues.errorsOnly();
    FluentIssueCollection _oneOfThemContains_1 = _errorsOnly_1.oneOfThemContains("Pin declaration width mismatch.  Left=2, right=1.");
    this.assertConstraints(_oneOfThemContains_1);
    FluentIssueCollection _errorsOnly_2 = this.issues.errorsOnly();
    FluentIssueCollection _sizeIs = _errorsOnly_2.sizeIs(2);
    this.assertConstraints(_sizeIs);
  }
  
  @Test
  public void test_req_attrs() {
    this.testFile("TestDevices/test_req_attrs.phdl");
    FluentIssueCollection _oneOfThemContains = this.issues.oneOfThemContains("Required attribute \'REFPREFIX\' missing.");
    this.assertConstraints(_oneOfThemContains);
    FluentIssueCollection _oneOfThemContains_1 = this.issues.oneOfThemContains("Required attribute \'LIBRARY\' missing.");
    this.assertConstraints(_oneOfThemContains_1);
    FluentIssueCollection _oneOfThemContains_2 = this.issues.oneOfThemContains("Required attribute \'FOOTPRINT\' missing.");
    this.assertConstraints(_oneOfThemContains_2);
    FluentIssueCollection _errorsOnly = this.issues.errorsOnly();
    FluentIssueCollection _sizeIs = _errorsOnly.sizeIs(3);
    this.assertConstraints(_sizeIs);
  }
  
  @Test
  public void test_refprefix_attr() {
    this.testFile("TestDevices/test_refprefix_attr.phdl");
    FluentIssueCollection _allOfThemContain = this.issues.allOfThemContain("Only uppercase REFPREFIX value recommended.");
    this.assertConstraints(_allOfThemContain);
    FluentIssueCollection _warningsOnly = this.issues.warningsOnly();
    FluentIssueCollection _sizeIs = _warningsOnly.sizeIs(1);
    this.assertConstraints(_sizeIs);
  }
  
  @Test
  public void test_pincount_attr() {
    this.testFile("TestDevices/test_pincount_attr.phdl");
    FluentIssueCollection _oneOfThemContains = this.issues.oneOfThemContains("Expected 3 declared pins, found 4.");
    this.assertConstraints(_oneOfThemContains);
    FluentIssueCollection _oneOfThemContains_1 = this.issues.oneOfThemContains("PINCOUNT attribute must be an integer.");
    this.assertConstraints(_oneOfThemContains_1);
    FluentIssueCollection _errorsOnly = this.issues.errorsOnly();
    FluentIssueCollection _sizeIs = _errorsOnly.sizeIs(2);
    this.assertConstraints(_sizeIs);
  }
  
  @Test
  public void test_uppercase_attrs() {
    this.testFile("TestDevices/test_uppercase_attrs.phdl");
    FluentIssueCollection _allOfThemContain = this.issues.allOfThemContain("Only uppercase attribute names are recommended");
    this.assertConstraints(_allOfThemContain);
    FluentIssueCollection _warningsOnly = this.issues.warningsOnly();
    FluentIssueCollection _sizeIs = _warningsOnly.sizeIs(6);
    this.assertConstraints(_sizeIs);
  }
  
  @Test
  public void test_valid_device() {
    this.testFile("TestDevices/test_valid_device.phdl");
    FluentIssueCollection _sizeIs = this.issues.sizeIs(0);
    this.assertConstraints(_sizeIs);
  }
}
