package edu.byu.ee.phdl.tests

import org.eclipse.xtext.junit4.InjectWith
import org.junit.runner.RunWith
import org.junit.Test

import static org.junit.Assert.*
import org.eclipselabs.xtext.utils.unittesting.XtextTest
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import edu.byu.ee.phdl.PhdlInjectorProvider

@InjectWith(typeof(PhdlInjectorProvider))
@RunWith(typeof(XtextRunner2))
class TestDevices extends XtextTest {
	
	@Test
	def void test_device_duplicate() {
		testFile("TestDevices/devices.phdl")
		assertConstraints(
			issues.errorsOnly()
			.nOfThemContain(2, "Duplicate DeviceElement '1' in Device 'mydevice")
			.nOfThemContain(2, "Duplicate physical pin name.")
		)
	}
}