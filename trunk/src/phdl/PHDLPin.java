/*
    Copyright (C) 2011  BYU Configurable Computing Lab

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package phdl;

import java.util.HashMap;

/**
 * A class that represents a pin on a PC board.
 * 
 * A pin that is embodied by a name and a type
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 */
public class PHDLPin {
	/**
	 * the line number where the pin appears in the source text
	 */
	private int line = 0;
	/**
	 * the lsb if the pin is an array. -1 indicates it is not.
	 */
	private int lsb = -1;
	/**
	 * the msb if the pin is an array. -1 indicates it is not.
	 */
	private int msb = -1;
	/**
	 * the name of the pin
	 */
	private String name;
	/**
	 * the pin number
	 */
	private int number = 0;
	/**
	 * the string of a list of pin numbers
	 */
	private String pinList;
	/**
	 * the mapping of the pin array to footprint pin numbers
	 */
	private HashMap<Integer, Integer> pinMap;
	/**
	 * the position number where the pin appears in the source text
	 */
	private int pos = 0;
	/**
	 * the type of the pin
	 * 
	 * @see PHDLPinType
	 */
	private PHDLPinType type;

	/**
	 * Fourth Constructor.
	 * 
	 * @param type
	 *            the type of the pin
	 */
	public PHDLPin(PHDLPinType type) {
		this.type = type;
		this.pinMap = new HashMap<Integer, Integer>();
	}

	/**
	 * Second Constructor.
	 * 
	 * Defaults the pin type to PHDLPinType.PIN
	 * 
	 * @param name
	 *            the name of the pin
	 * 
	 */
	public PHDLPin(String name) {
		this.name = name;
		this.type = PHDLPinType.PIN;
	}

	/**
	 * Default Constructor.
	 * 
	 * Defaults the pin type to PHDLPinType.PIN
	 * 
	 * @param name
	 *            the name of the pin
	 * @param number
	 *            the pin number
	 */
	public PHDLPin(String name, int number) {
		this.name = name;
		this.type = PHDLPinType.PIN;
		this.number = number;
	}

	/**
	 * Third Constructor.
	 * 
	 * Allows for the instantiation of the name and type
	 * 
	 * @param name
	 *            the name of the pin
	 * @param type
	 *            the type of the pin
	 * @param number
	 *            the pin number
	 */
	public PHDLPin(String name, PHDLPinType type, int number) {
		this.name = name;
		this.type = type;
		this.number = number;
	}

	@Override
	public boolean equals(Object o) {
		PHDLPin p = (PHDLPin) o;
		if (p.getName().equals(name) && p.getType() == type
				&& p.getNumber() == number) {
			return true;
		}
		return false;
	}

	public int getLine() {
		return line;
	}

	public String getLocation() {
		return "[" + line + ":" + pos + "]";
	}

	public int getLSB() {
		return lsb;
	}

	public int getMSB() {
		return msb;
	}

	/**
	 * Returns the name of the pin.
	 * 
	 * Pin name accessor method
	 * 
	 * @return a string representation of the pin name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the number of the pin.
	 * 
	 * Pin number accessor method
	 * 
	 * @return the pin number
	 */
	public int getNumber() {
		return number;
	}

	public String getPinList() {
		return pinList;
	}

	public int getPos() {
		return pos;
	}

	/**
	 * Returns the pin type of the pin.
	 * 
	 * Pin type accessor method
	 * 
	 * @return the pin type
	 */
	public PHDLPinType getType() {
		return type;
	}

	@Override
	/**
	 * Creates a hash code for use in hash data structures.
	 * 
	 * hashCode method to make attributes compatible with hashMaps
	 * and hashSets
	 * 
	 * @return	an integer representing a hash code
	 */
	public int hashCode() {
		return name.hashCode();
	}

	public void makePinMap() {
		// break apart the pin list into integers by splitting on
		// all whitespace, commas, and semicolons
		String[] pinStrings = pinList.split("[\\s,;]");
		int[] pinInts = new int[pinStrings.length];
		for (int i = 0; i < pinStrings.length; i++)
			pinInts[i] = Integer.parseInt(pinStrings[i]);

		// assume the pin has a width of one but modify it if both msb and lsb
		// have been declared
		int width = 1;
		if (msb != -1 && lsb != -1)
			width = Math.abs(msb - lsb) + 1;

		// check that the available width of the pin name is the same as the
		// number of pins in the comma-separated pin list
		if (width != pinStrings.length) {
			// we may want to eventually throw an exception here
			System.out.println("Incorrect pin-list width: " + toString());
			return;
		}

		// perform the mapping based on the direction of the array declaration
		if (msb < lsb) {
			for (int i = msb; i < msb + width; i++)
				pinMap.put(i, pinInts[i - msb]);
		} else if (msb > lsb) {
			for (int i = msb; i > lsb + width; i++)
				pinMap.put(i, pinInts[i - msb]);

			// the case of a single pin and number
		} else if (msb == lsb) {
			pinMap.put(0, pinInts[0]);
		}
	}

	public void setLine(int line) {
		this.line = line;
	}

	public void setLSB(int lsb) {
		this.lsb = lsb;
	}

	public void setMSB(int msb) {
		this.msb = msb;
	}

	/**
	 * Changes the name of the pin.
	 * 
	 * Pin name mutator method
	 * 
	 * @param name
	 *            the new name of the pin
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Changes the pin number.
	 * 
	 * Pin number mutator method
	 * 
	 * @param number
	 *            the new pin number
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	public void setPinList(String pinList) {
		this.pinList = pinList;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	/**
	 * Changes the pin type of the pin.
	 * 
	 * Pin type mutator method
	 * 
	 * @param type
	 *            the new pin type
	 */
	public void setType(PHDLPinType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		String width = ": ";
		if (msb > -1 && lsb > -1)
			width = "[" + msb + ":" + lsb + "]: ";
		return "PHDLPin" + getLocation() + ": " + type.toString() + width
				+ name + " {" + pinList + "}\n";
	}

	public static boolean unitTest() {
		/*
		 * Methods Tested******************** getName X getType X getNumber X
		 * setName X setType X setNumber X
		 */
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
			TestDriver.err("getName()", "PinPin1", actualN);
		}
		if (actualT != PHDLPinType.PIN) {
			success = false;
			TestDriver.err("getType()", PHDLPinType.PIN.name(), actualT.name());
		}
		if (actualP != 1) {
			success = false;
			TestDriver.err("getNumber()", ((Integer) 1).toString(),
					((Integer) actualP).toString());
		}

		actualN = pin2.getName();
		actualT = pin2.getType();
		actualP = pin2.getNumber();
		if (!actualN.equals("PassivePin2")) {
			success = false;
			TestDriver.err("getName()", "PassivePin2", actualN);
		}
		if (actualT != PHDLPinType.PASSIVE) {
			success = false;
			TestDriver.err("getType()", PHDLPinType.PASSIVE.name(),
					actualT.name());
		}
		if (actualP != 2) {
			success = false;
			TestDriver.err("getNumber()", ((Integer) 2).toString(),
					((Integer) actualP).toString());
		}

		actualN = pin3.getName();
		actualT = pin3.getType();
		actualP = pin3.getNumber();
		if (!actualN.equals("OpenPin3")) {
			success = false;
			TestDriver.err("getName()", "OpenPin3", actualN);
		}
		if (actualT != PHDLPinType.OPEN) {
			success = false;
			TestDriver
					.err("getType()", PHDLPinType.OPEN.name(), actualT.name());
		}
		if (actualP != 3) {
			success = false;
			TestDriver.err("getNumber()", ((Integer) 3).toString(),
					((Integer) actualP).toString());
		}

		actualN = pin4.getName();
		actualT = pin4.getType();
		actualP = pin4.getNumber();
		if (!actualN.equals("InPin4")) {
			success = false;
			TestDriver.err("getName()", "InPin4", actualN);
		}
		if (actualT != PHDLPinType.IN) {
			success = false;
			TestDriver.err("getType()", PHDLPinType.IN.name(), actualT.name());
		}
		if (actualP != 4) {
			success = false;
			TestDriver.err("getNumber()", ((Integer) 4).toString(),
					((Integer) actualP).toString());
		}

		actualN = pin5.getName();
		actualT = pin5.getType();
		actualP = pin5.getNumber();
		if (!actualN.equals("OutPin5")) {
			success = false;
			TestDriver.err("getName()", "OutPin5", actualN);
		}
		if (actualT != PHDLPinType.OUT) {
			success = false;
			TestDriver.err("getType()", PHDLPinType.OUT.name(), actualT.name());
		}
		if (actualP != 5) {
			success = false;
			TestDriver.err("getNumber()", ((Integer) 5).toString(),
					((Integer) actualP).toString());
		}

		actualN = pin6.getName();
		actualT = pin6.getType();
		actualP = pin6.getNumber();
		if (!actualN.equals("InoutPin6")) {
			success = false;
			TestDriver.err("getName()", "InoutPin6", actualN);
		}
		if (actualT != PHDLPinType.INOUT) {
			success = false;
			TestDriver.err("getType()", PHDLPinType.INOUT.name(),
					actualT.name());
		}
		if (actualP != 6) {
			success = false;
			TestDriver.err("getNumber()", ((Integer) 6).toString(),
					((Integer) actualP).toString());
		}

		actualN = pin7.getName();
		actualT = pin7.getType();
		actualP = pin7.getNumber();
		if (!actualN.equals("PowerPin7")) {
			success = false;
			TestDriver.err("getName()", "PowerPin7", actualN);
		}
		if (actualT != PHDLPinType.POWER) {
			success = false;
			TestDriver.err("getType()", PHDLPinType.POWER.name(),
					actualT.name());
		}
		if (actualP != 7) {
			success = false;
			TestDriver.err("getNumber()", ((Integer) 7).toString(),
					((Integer) actualP).toString());
		}

		actualN = pin8.getName();
		actualT = pin8.getType();
		actualP = pin8.getNumber();
		if (!actualN.equals("SupplyPin8")) {
			success = false;
			TestDriver.err("getName()", "SupplyPin8", actualN);
		}
		if (actualT != PHDLPinType.SUPPLY) {
			success = false;
			TestDriver.err("getType()", PHDLPinType.SUPPLY.name(),
					actualT.name());
		}
		if (actualP != 8) {
			success = false;
			TestDriver.err("getNumber()", ((Integer) 8).toString(),
					((Integer) actualP).toString());
		}

		PHDLPin newPin = new PHDLPin("changePin1", 3);
		newPin.setName("I've been changed");
		newPin.setType(PHDLPinType.PASSIVE);
		newPin.setNumber(9);
		if (!newPin.getName().equals("I've been changed")) {
			success = false;
			TestDriver.err("setName()", "I've been changed", newPin.getName());
		}
		if (newPin.getType() != PHDLPinType.PASSIVE) {
			success = false;
			TestDriver.err("setType()", PHDLPinType.PASSIVE.name(), newPin
					.getType().name());
		}
		if (newPin.getNumber() != 9) {
			success = false;
			TestDriver.err("setNumber()", ((Integer) 9).toString(),
					((Integer) newPin.getNumber()).toString());
		}

		return success;
	}
}
