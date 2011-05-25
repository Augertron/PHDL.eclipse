package phdl;

/**
 * A class that represents a pin on a PC board
 * 
 * A pin that is embodied by a name and a type
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 */
public class PHDLPin {
	/**
	 * the name of the pin
	 */
	private String name;
	/**
	 * the type of the pin
	 * @see PHDLPinType
	 */
	private PHDLPinType type;
	/**
	 * the pin number
	 */
	private int number;

	/**
	 * Default Constructor
	 *
	 * Defaults the pin type to PHDLPinType.PIN
	 *
	 * @param name the name of the pin
	 * @param number the pin number
	 */
	public PHDLPin(String name, int number) {
		this.name = name;
		this.type = PHDLPinType.PIN;
		this.number = number;
	}
	
	/**
	 * Secondary Constructor
	 * 
	 * Allows for the instantiation of the name and type
	 * 
	 * @param name	the name of the pin
	 * @param type	the type of the pin
	 * @param number the pin number
	 */
	public PHDLPin(String name, PHDLPinType type, int number) {
		this.name = name;
		this.type = type;
		this.number = number;
	}

	/**
	 * Returns the name of the pin
	 * 
	 * Pin name accessor method
	 * 
	 * @return	a string representation of the pin name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Changes the name of the pin
	 * 
	 * Pin name mutator method
	 * 
	 * @param name	the new name of the pin
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the pin type of the pin
	 * 
	 * Pin type accessor method
	 * 
	 * @return	the pin type
	 */
	public PHDLPinType getType() {
		return type;
	}
	
	/**
	 * Changes the pin type of the pin
	 * 
	 * Pin type mutator method
	 * 
	 * @param type	the new pin type
	 */
	public void setType(PHDLPinType type) {
		this.type = type;
	}
	
	/**
	 * Returns the number of the pin
	 * 
	 * Pin number accessor method
	 * 
	 * @return the pin number
	 */
	public int getNumber() {
		return number;
	}
	
	/**
	 * Changes the pin number
	 * 
	 * Pin number mutator method
	 * 
	 * @param number the new pin number
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	/**
	 * Creates a hash code for use in hash data structures
	 * 
	 * hashCode method to make attributes compatible with hashMaps
	 * and hashSets
	 * 
	 * @return	an integer representing a hash code
	 */
	public int hashCode() {
		return name.hashCode();
	}
	
	public static boolean unitTest() {
		boolean success = true;
		PHDLPin pin1 = new PHDLPin("PinPin1", 1);
		PHDLPin pin2 = new PHDLPin("PassivePin2", PHDLPinType.PASSIVE, 2);
		PHDLPin pin3 = new PHDLPin("OpenPin3", PHDLPinType.OPEN, 3);
		PHDLPin pin4 = new PHDLPin("InPin4", PHDLPinType.IN, 4);
		PHDLPin pin5 = new PHDLPin("OutPin5", PHDLPinType.OUT, 5);
		PHDLPin pin6 = new PHDLPin("InoutPin6", PHDLPinType.INOUT, 6);
		PHDLPin pin7 = new PHDLPin("PowerPin7", PHDLPinType.POWER, 7);
		PHDLPin pin8 = new PHDLPin("SupplyPin8", PHDLPinType.SUPPLY, 8);
		
		String actualN = pin1.getName();
		PHDLPinType actualT = pin1.getType();
		int actualP = pin1.getNumber();
		if (!actualN.equals("PinPin1")) {
			success = false;
			err("getName()", "PinPin1", actualN);
		}
		if (actualT != PHDLPinType.PIN) {
			success = false;
			err("getType()", PHDLPinType.PIN.name(), actualT.name());
		}
		if (actualP != 1) {
			success = false;
			err("getNumber()", ((Integer)1).toString(), ((Integer)actualP).toString());
		}
		
		actualN = pin2.getName();
		actualT = pin2.getType();
		actualP = pin2.getNumber();
		if (!actualN.equals("PassivePin2")) {
			success = false;
			err("getName()", "PassivePin2", actualN);
		}
		if (actualT != PHDLPinType.PASSIVE) {
			success = false;
			err("getType()", PHDLPinType.PASSIVE.name(), actualT.name());
		}
		if (actualP != 2) {
			success = false;
			err("getNumber()", ((Integer)2).toString(), ((Integer)actualP).toString());
		}
		
		actualN = pin3.getName();
		actualT = pin3.getType();
		actualP = pin3.getNumber();
		if (!actualN.equals("OpenPin3")) {
			success = false;
			err("getName()", "OpenPin3", actualN);
		}
		if (actualT != PHDLPinType.OPEN) {
			success = false;
			err("getType()", PHDLPinType.OPEN.name(), actualT.name());
		}
		if (actualP != 3) {
			success = false;
			err("getNumber()", ((Integer)3).toString(), ((Integer)actualP).toString());
		}
		
		
		actualN = pin4.getName();
		actualT = pin4.getType();
		actualP = pin4.getNumber();
		if (!actualN.equals("InPin4")) {
			success = false;
			err("getName()", "InPin4", actualN);
		}
		if (actualT != PHDLPinType.IN) {
			success = false;
			err("getType()", PHDLPinType.IN.name(), actualT.name());
		}
		if (actualP != 4) {
			success = false;
			err("getNumber()", ((Integer)4).toString(), ((Integer)actualP).toString());
		}
		
		
		actualN = pin5.getName();
		actualT = pin5.getType();
		actualP = pin5.getNumber();
		if (!actualN.equals("OutPin5")) {
			success = false;
			err("getName()", "OutPin5", actualN);
		}
		if (actualT != PHDLPinType.OUT) {
			success = false;
			err("getType()", PHDLPinType.OUT.name(), actualT.name());
		}
		if (actualP != 5) {
			success = false;
			err("getNumber()", ((Integer)5).toString(), ((Integer)actualP).toString());
		}
		
		
		actualN = pin6.getName();
		actualT = pin6.getType();
		actualP = pin6.getNumber();
		if (!actualN.equals("InoutPin6")) {
			success = false;
			err("getName()", "InoutPin6", actualN);
		}
		if (actualT != PHDLPinType.INOUT) {
			success = false;
			err("getType()", PHDLPinType.INOUT.name(), actualT.name());
		}
		if (actualP != 6) {
			success = false;
			err("getNumber()", ((Integer)6).toString(), ((Integer)actualP).toString());
		}
		
		
		actualN = pin7.getName();
		actualT = pin7.getType();
		actualP = pin7.getNumber();
		if (!actualN.equals("PowerPin7")) {
			success = false;
			err("getName()", "PowerPin7", actualN);
		}
		if (actualT != PHDLPinType.POWER) {
			success = false;
			err("getType()", PHDLPinType.POWER.name(), actualT.name());
		}
		if (actualP != 7) {
			success = false;
			err("getNumber()", ((Integer)7).toString(), ((Integer)actualP).toString());
		}

		
		actualN = pin8.getName();
		actualT = pin8.getType();
		actualP = pin8.getNumber();
		if (!actualN.equals("SupplyPin8")) {
			success = false;
			err("getName()", "SupplyPin8", actualN);
		}
		if (actualT != PHDLPinType.SUPPLY) {
			success = false;
			err("getType()", PHDLPinType.SUPPLY.name(), actualT.name());
		}
		if (actualP != 8) {
			success = false;
			err("getNumber()", ((Integer)8).toString(), ((Integer)actualP).toString());
		}
		
		PHDLPin newPin = new PHDLPin("changePin1", 3);
		newPin.setName("I've been changed");
		newPin.setType(PHDLPinType.PASSIVE);
		newPin.setNumber(9);
		if (!newPin.getName().equals("I've been changed")) {
			success = false;
			err("setName()", "I've been changed", newPin.getName());
		}
		if (newPin.getType() != PHDLPinType.PASSIVE) {
			success = false;
			err("setType()", PHDLPinType.PASSIVE.name(), newPin.getType().name());
		}
		if (newPin.getNumber() != 9) {
			success = false;
			err("setNumber()", ((Integer)9).toString(), ((Integer)newPin.getNumber()).toString());
		}
		
		return success;
	}
	
	private static void err(String fun, String expected, String actual) {
		System.out.println("Error in " + fun);
		System.out.println("\tExpected:" + expected);
		System.out.println("\tActual: + actual");
	}

}
