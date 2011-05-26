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
		System.out.println("***Testing PHDLAttribute***");
		success &= PHDLNet.unitTest();
		System.out.println("***Testing PHDLNetList***");
		success &= PHDLNetList.unitTest();
		System.out.println("***Testing PHDLDevice***");
		success &= PHDLDevice.unitTest();
		System.out.println("***Testing PHDLInstance***");
		success &= PHDLInstance.unitTest();
		System.out.println("***Testing PHDLDesign***");
		success &= PHDLDesign.unitTest();
		System.out.println("***Testing RefDesGenerator***");
		success &= RefDesGenerator.unitTest();
		
		System.out.println("\n***Testing Complete***");
		if (success) {
			System.out.println("***All Tests Successful***");
		}
		else {
			System.out.println("***Some Tests Failed***");
		}
	}
	
	public static void err(String fun, String expected, String actual) {
		System.out.println("Error in " + fun);
		System.out.println("\tExpected: " + expected);
		System.out.println("\tActual: " + actual);
	}

}
