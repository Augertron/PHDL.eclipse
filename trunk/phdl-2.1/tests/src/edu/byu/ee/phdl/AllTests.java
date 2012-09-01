package edu.byu.ee.phdl;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import edu.byu.ee.phdl.netlist.tests.AllNetlistTests;
import edu.byu.ee.phdl.xtext.tests.AllXtextTests;

@RunWith(Suite.class)
@Suite.SuiteClasses(value = { AllXtextTests.class, AllNetlistTests.class })
public class AllTests {

}
