package edu.byu.ee.phdl;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import edu.byu.ee.phdl.xtext.tests.AllXtextTests;
import edu.byu.ee.phld.netlist.tests.AllNetlistTests;

@RunWith(Suite.class)
@Suite.SuiteClasses(value = { AllXtextTests.class, AllNetlistTests.class })
public class AllTests {

}
