package edu.byu.ee.phdl;

import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.junit.validation.ValidatorTester;

import edu.byu.ee.phdl.PhdlStandaloneSetup;
import edu.byu.ee.phdl.validation.PhdlJavaValidator;

public class PhdlValidatorTest extends AbstractXtextTests {
	private ValidatorTester<PhdlJavaValidator> tester;

	@Override
	public void setUp() {
		try {
			with(PhdlStandaloneSetup.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PhdlJavaValidator validator = get(PhdlJavaValidator.class);
		//tester = new ValidatorTester<TestingValidator>(validator);
	}
}
