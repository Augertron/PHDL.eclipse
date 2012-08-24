package edu.byu.ee.phdl.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(value = { TestConcatenations.class, TestConnectionAssigns.class, TestDevices.class,
		TestExamples.class, TestGenerator.class, TestLexerAndParser.class, TestPinAssigns.class, TestPortAssigns.class })
public class AllTests {

}
