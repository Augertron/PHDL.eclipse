/*
    Copyright (C) 2011  Brigham Young University

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, version 3.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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
		System.out.println("***Testing phdl.graph.Pin***");
		success &= phdl.graph.Pin.unitTest();

		System.out.println("\n***Testing Complete***");
		if (success) {
			System.out.println("***All Tests Successful***");
		} else {
			System.out.println("***Some Tests Failed***");
		}
	}

	public static boolean displayError(int testNum, String fun, String description) {
		System.out.println("Test " + testNum + ": Error in " + fun);
		System.out.println("\t" + description);
		return false;
	}
	
	public static boolean displayError(int testNum, String fun, String description, String expected, String actual) {
		displayError(testNum, fun, description);
		System.out.println("\tExpected: " + expected);
		System.out.println("\tActual: " + actual);
		return false;
	}

}
