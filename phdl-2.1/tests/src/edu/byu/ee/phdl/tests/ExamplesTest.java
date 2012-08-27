package edu.byu.ee.phdl.tests;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2;
import org.eclipselabs.xtext.utils.unittesting.XtextTest;
import org.junit.Test;
import org.junit.runner.RunWith;

import edu.byu.ee.phdl.PhdlInjectorProvider;

@InjectWith(PhdlInjectorProvider.class)
@RunWith(XtextRunner2.class)
public class ExamplesTest extends XtextTest {

	@Test
	public void testAtlys() {
		ignoreFormattingDifferences();
		String dir = getClass().getSimpleName() + "/atlys/";
		testFile(dir + "top.phdl", dir + "s6_devices.phdl");
		assertConstraints(issues.sizeIs(0));
	}

	@Test
	public void testFmcModule() {
		ignoreFormattingDifferences();
		String dir = getClass().getSimpleName() + "/fmc_module/";
		testFile(dir + "top.phdl", dir + "balun.phdl", dir + "transceiver.phdl", dir + "clock.phdl", dir
				+ "devices.phdl");
		assertConstraints(issues.sizeIs(0));
	}

	@Test
	public void testPtzlanc() {
		ignoreFormattingDifferences();
		String dir = getClass().getSimpleName() + "/ptzlanc/";
		testFile(dir + "ptzlanc.phdl", dir + "ic.phdl", dir + "connector.phdl", dir + "pinheader.phdl", dir
				+ "rcl.phdl", dir + "switches.phdl", dir + "discrete.phdl");
		assertConstraints(issues.sizeIs(0));
	}

	@Test
	public void testSevenSegment() {
		ignoreFormattingDifferences();
		String dir = getClass().getSimpleName() + "/seven_segment/";
		testFile(dir + "ss_Control.phdl", dir + "ss_Devices.phdl");
		assertConstraints(issues.sizeIs(0));
	}

	@Test
	public void testVoiceModulator() {
		ignoreFormattingDifferences();
		String dir = getClass().getSimpleName() + "/voice_modulator/";
		testFile(dir + "vm_design.phdl", dir + "vm_amp.phdl", dir + "vm_modulator.phdl", dir + "vm_devices.phdl");
		assertConstraints(issues.sizeIs(0));
	}
}
