package phdl;

/**
 * A unit test driver
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 */

public class TestDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean success = true;
		System.out.println("***Testing PHDLPin***");
		success &= PHDLPin.unitTest();
		System.out.println("***Testing PHDLNet***");
		success &= PHDLNet.unitTest();
		System.out.println("\n***Testing Complete***");
		if (success) {
			System.out.println("***All Tests Successful***");
		}
		else {
			System.out.println("***Some Tests Failed***");
		}
	}

}
