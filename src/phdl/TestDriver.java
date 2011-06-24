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
		/*
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
		*/
		
		// success &= PHDLPreProcessor.unitTest();
		//success &= phdl.analyzer.DesignHierarchy.unitTest();
		//success &= phdl.preprocessor.Extractor.unitTest();
		
		success &= phdl.analyzer.NetNode.unitTest();

		System.out.println("\n***Testing Complete***");
		if (success) {
			System.out.println("***All Tests Successful***");
		} else {
			System.out.println("***Some Tests Failed***");
		}
	}

	public static void err(String fun, String expected, String actual) {
		System.out.println("Error in " + fun);
		System.out.println("\tExpected: " + expected);
		System.out.println("\tActual: " + actual);
	}

}
