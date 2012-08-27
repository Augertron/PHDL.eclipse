package edu.byu.ee.phdl.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(value = { ConcatenationTest.class, ConnectionAssignTest.class, DeviceTest.class,
		PinAssignTest.class, PortAssignTest.class })
public class ValidationTests {

}
