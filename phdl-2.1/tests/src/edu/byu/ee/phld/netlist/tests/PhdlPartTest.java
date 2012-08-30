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

import edu.byu.ee.phdl.netlist.PhdlPart;

public class PhdlPartTest {

	private final static Logger logger = Logger.getLogger(PhdlPartTest.class);
	private final String msgpfx = "testing" + getClass().getSimpleName() + ".";

	private static PhdlPart p1;
	private static PhdlPart p2;
	private static PhdlPart p3;
	private static PhdlPart p4;

	@BeforeClass
	public static void setup() {
		p1 = new PhdlPart("same", "footprint1", "library1");
		p2 = new PhdlPart("same", "footprint2", "library2");
		p3 = new PhdlPart("same", "footprint3", "library3");
		p4 = new PhdlPart("different", "footprint4", "library4");
	}

	@AfterClass
	public static void tearDown() {
		p1 = null;
		p2 = null;
		p3 = null;
		p4 = null;
	}

	@Test
	public void testCompareTo() {
		logger.info(msgpfx + new Throwable().getStackTrace()[0].getMethodName());
		assertEquals("not comparable", 0, p1.compareTo(p2));
		assertTrue("not comparable", p1.compareTo(p4) > 0);
		assertTrue("not comaprable", p4.compareTo(p1) < 0);
	}

	@Test
	public void testEquals() {
		logger.info(msgpfx + new Throwable().getStackTrace()[0].getMethodName());
		assertTrue("not reflexive", p1.equals(p1));
		assertTrue("not symmetric", p1.equals(p2) && p2.equals(p1));
		assertTrue("not transitive", p1.equals(p2) && p2.equals(p3) && p1.equals(p3));
		assertFalse("should not be equal", p1.equals(null));
		assertFalse("should not be equal", p1.equals(p4));
	}

	@Test
	public void testFields() {
		logger.info(msgpfx + new Throwable().getStackTrace()[0].getMethodName());
		assertEquals("name is not equal", "same", p1.getName());
		assertEquals("footprint is not equal", "footprint1", p1.getFootprint());
		assertEquals("library is not equal", "library1", p1.getLibrary());
	}

	@Test
	public void testHashcode() {
		logger.info(msgpfx + new Throwable().getStackTrace()[0].getMethodName());
		assertTrue("hashcodes not equal", p1.hashCode() == p2.hashCode());
	}

	@Test
	public void testPartInSet() {
		logger.info(msgpfx + new Throwable().getStackTrace()[0].getMethodName());
		Set<PhdlPart> set = new HashSet<PhdlPart>();
		set.add(p1);
		set.add(p2);
		assertEquals("cannot have two equal parts in a set", 1, set.size());
	}

	@Test
	public void testToString() {
		logger.info(msgpfx + new Throwable().getStackTrace()[0].getMethodName());
		String expected = p1.getClass().getSimpleName() + ": " + p1.getName() + ", " + p1.getFootprint() + "@"
				+ p1.getLibrary();
		assertEquals("toString() method not correct", expected, p1.toString());
	}

}
