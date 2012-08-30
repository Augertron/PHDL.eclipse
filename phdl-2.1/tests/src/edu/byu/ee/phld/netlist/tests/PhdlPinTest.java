package edu.byu.ee.phld.netlist.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.byu.ee.phdl.netlist.PhdlPin;

public class PhdlPinTest {

	private final static Logger logger = Logger.getLogger(PhdlPinTest.class);
	private final String msgpfx = "testing" + getClass().getSimpleName() + ".";

	private static PhdlPin p1;
	private static PhdlPin p2;
	private static PhdlPin p3;
	private static PhdlPin p4;
	private static PhdlPin p5;

	@BeforeClass
	public static void setup() {
		p1 = new PhdlPin("samePart", "samePin");
		p2 = new PhdlPin("samePart", "samePin");
		p3 = new PhdlPin("samePart", "samePin");
		p4 = new PhdlPin("samePart", "diffPin");
		p5 = new PhdlPin("diffPart", "diffPin");
	}

	@AfterClass
	public static void tearDown() {
		p1 = null;
		p2 = null;
		p3 = null;
		p4 = null;
		p5 = null;
	}

	@Test
	public void testEquals() {
		logger.info(msgpfx + new Throwable().getStackTrace()[0].getMethodName());
		assertTrue("not reflexive", p1.equals(p1));
		assertTrue("not symmetric", p1.equals(p2) && p2.equals(p1));
		assertTrue("not transitive", p1.equals(p2) && p2.equals(p3) && p1.equals(p3));
		assertFalse("should not be equal", p1.equals(null));
		assertFalse("should not be equal", p1.equals(p4));
		assertFalse("should not be equal", p1.equals(p5));
	}

	@Test
	public void testFields() {
		logger.info(msgpfx + new Throwable().getStackTrace()[0].getMethodName());
		assertEquals("pinName is not equal", "samePin", p1.getPinName());
		assertEquals("partName is not equal", "samePart", p1.getPartName());
	}

	@Test
	public void testHashcode() {
		logger.info(msgpfx + new Throwable().getStackTrace()[0].getMethodName());
		assertTrue("hashcodes not equal", p1.hashCode() == p2.hashCode());
	}

	@Test
	public void testPartInSet() {
		logger.info(msgpfx + new Throwable().getStackTrace()[0].getMethodName());
		Set<PhdlPin> set = new HashSet<PhdlPin>();
		set.add(p1);
		set.add(p2);
		assertEquals("cannot have two equal pins in a set", 1, set.size());
	}

	@Test
	public void testToString() {
		logger.info(msgpfx + new Throwable().getStackTrace()[0].getMethodName());
		String expected = p1.getClass().getSimpleName() + ": " + p1.getPartName() + "." + p1.getPinName();
		assertEquals("toString() method not correct", expected, p1.toString());
	}
}
