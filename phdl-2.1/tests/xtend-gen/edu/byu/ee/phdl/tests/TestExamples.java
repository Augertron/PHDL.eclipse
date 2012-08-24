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
public class TestExamples extends XtextTest {
  @Test
  public void test_fmc_module() {
    this.ignoreFormattingDifferences();
    String dir = "TestExamples/fmc_module/";
    String _plus = (dir + "top.phdl");
    String _plus_1 = (dir + "balun.phdl");
    String _plus_2 = (dir + "transceiver.phdl");
    String _plus_3 = (dir + "clock.phdl");
    String _plus_4 = (dir + "devices.phdl");
    this.testFile(_plus, _plus_1, _plus_2, _plus_3, _plus_4);
    FluentIssueCollection _sizeIs = this.issues.sizeIs(0);
    this.assertConstraints(_sizeIs);
  }
  
  @Test
  public void test_voice_modulator() {
    this.ignoreFormattingDifferences();
    String dir = "TestExamples/voice_modulator/";
    String _plus = (dir + "vm_design.phdl");
    String _plus_1 = (dir + "vm_amp.phdl");
    String _plus_2 = (dir + "vm_modulator.phdl");
    String _plus_3 = (dir + "vm_devices.phdl");
    this.testFile(_plus, _plus_1, _plus_2, _plus_3);
    FluentIssueCollection _sizeIs = this.issues.sizeIs(0);
    this.assertConstraints(_sizeIs);
  }
  
  @Test
  public void test_seven_segment() {
    this.ignoreFormattingDifferences();
    String dir = "TestExamples/seven_segment/";
    String _plus = (dir + "ss_Control.phdl");
    String _plus_1 = (dir + "ss_Devices.phdl");
    this.testFile(_plus, _plus_1);
    FluentIssueCollection _sizeIs = this.issues.sizeIs(0);
    this.assertConstraints(_sizeIs);
  }
  
  @Test
  public void test_ptzlanc() {
    this.ignoreFormattingDifferences();
    String dir = "TestExamples/ptzlanc/";
    String _plus = (dir + "ptzlanc.phdl");
    String _plus_1 = (dir + "ic.phdl");
    String _plus_2 = (dir + "connector.phdl");
    String _plus_3 = (dir + "pinheader.phdl");
    String _plus_4 = (dir + "rcl.phdl");
    String _plus_5 = (dir + "switches.phdl");
    String _plus_6 = (dir + "discrete.phdl");
    this.testFile(_plus, _plus_1, _plus_2, _plus_3, _plus_4, _plus_5, _plus_6);
    FluentIssueCollection _sizeIs = this.issues.sizeIs(0);
    this.assertConstraints(_sizeIs);
  }
  
  @Test
  public void test_atlys() {
    this.ignoreFormattingDifferences();
    String dir = "TestExamples/atlys/";
    String _plus = (dir + "top.phdl");
    String _plus_1 = (dir + "s6_devices.phdl");
    this.testFile(_plus, _plus_1);
    FluentIssueCollection _sizeIs = this.issues.sizeIs(0);
    this.assertConstraints(_sizeIs);
  }
}
