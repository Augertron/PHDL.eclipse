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

package phdl.graph;

import phdl.TestDriver;

/**
 * A class that represents a Pin in PHDL.
 * 
 * @author Brad Riching and Richard Black
 * @version 0.1
 * 
 * Date of Last Code Review:	
 */
public class Pin extends Node {

	private Attributable parent;
	private String pinMapping;
	private Net net;
	private PinType pinType;
	private int index;

	/**
	 * Default Constructor.
	 * 
	 * @param instance
	 *            the Parent InstanceNode to set
	 * @see Attributable
	 * @see Net
	 */
	public Pin(Attributable parent) {
		setParent(parent);
		this.pinMapping = "";
		this.net = null;
		setIndex(-1);
	}

	/**
	 * Copy Constructor.
	 * 
	 * @param old
	 *            the old PinNode to copy
	 * @param parent
	 *            the parent of the PinNode
	 */
	public Pin(Pin old, Attributable parent) {
		this.parent = parent;
		this.pinMapping = old.getPinMapping();
		this.net = old.getNet();
		this.name = old.getName();
		this.line = old.getLine();
		this.pos = old.getPosition();
		this.fileName = old.getFileName();
		this.index = old.getIndex();
		this.pinType = old.getPinType();
	}

	@Override
	public boolean equals(Object o) {
		return name.equals(((Pin) o).getName()) && index == ((Pin) o).getIndex();
	}

	public int getIndex() {
		return index;
	}

	/**
	 * Net accessor method.
	 * 
	 * @return the NetNode attached to the Pin
	 */
	public Net getNet() {
		return net;
	}

	@Override
	/**
	 * Type accessor method.
	 * 
	 * @return NodeType.PIN
	 */
	public NodeType getNodeType() {
		return NodeType.PIN;
	}

	/**
	 * ParentNode accessor method.
	 * 
	 * @return the attributable parent node
	 */
	public Attributable getParent() {
		return parent;
	}

	/**
	 * PinName accessor method.
	 * 
	 * @return the pinName
	 */
	public String getPinMapping() {
		return pinMapping;
	}

	public PinType getPinType() {
		return pinType;
	}

	/**
	 * Checks to see if the PinNode has a NetNode.
	 * 
	 * @return true, if there is a NetNode false, otherwise
	 */
	public boolean hasNet() {
		return (net != null);
	}

	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * Net mutator method.
	 * 
	 * @param net
	 *            the new NetNode
	 */
	public void setNet(Net net) {
		this.net = net;
	}

	/**
	 * ParentNode mutator method.
	 * 
	 * @param parent
	 *            the new attributable parent node
	 */
	public void setParent(Attributable parent) {
		this.parent = parent;
	}

	/**
	 * PinName mutator method.
	 * 
	 * @param pinName
	 *            the new pinName
	 */
	public void setPinMapping(String pinMapping) {
		this.pinMapping = pinMapping;
	}

	public void setPinType(PinType type) {
		this.pinType = type;
	}

	@Override
	/**
	 * Generic toString method.
	 * 
	 * @return			a string representation
	 */
	public String toString() {
		return getNodeType() + ": " + getPinType() + " " + name
				+ ((index == -1) ? ("") : ("[" + index + "]")) + "={" + pinMapping + "}";
	}
	
	/***********************************
	 * Unit Test Code
	 * Author:	Richard Black
	 * Date:	January 4, 2012
	 * 
	 * WARNING:	This test code assumes that certain methods work in other
	 * 			objects.  Common occurrences of this are "equals," "compare,"
	 * 			and "toString."
	 * 
	 * 	Legend
	 * 		#	Proper Behavior
	 * 		X	Improper Behavior
	 * 		?	Untested
	 *  
	 * 	Member Variables
	 * 		?	Attributable	parent
	 * 		?	String			pinMapping
	 * 		?	Net				net
	 * 		?	PinType			pinType
	 * 		?	int				index
	 * 
	 * 	Methods
	 * 		?	public Pin(Attributable parent);
	 * 		?	public Pin(Pin old, Attributable parent);
	 * 		?	public boolean equals(Object o);
	 * 		?	public int getIndex();
	 * 		?	public Net getNet();
	 * 		?	public NodeType getNodeType();
	 * 		?	public Attributable getParent();
	 * 		?	public String getPinMapping();
	 * 		?	public PinType getPinType();
	 * 		?	public boolean hasNet();
	 * 		?	public void setIndex(int index);
	 * 		?	public void setNet(Net net);
	 * 		?	public void setParent(Attributable parent);
	 * 		?	public void setPinMapping(String pinMapping);
	 * 		?	public void setPinType(PinType type);
	 * 		?	public String toString();
	 * 
	 ***********************************/
	public static boolean unitTest() {
		boolean success = true;
		int testNum = 0;
		/**
		 * Test 1
		 * 	public pin(Attributable parent);
		 * 		parent = null;
		 */
		testNum++;
		Pin testPin1 = new Pin(null);
		if (testPin1.parent != null) {
			success = TestDriver.displayError(testNum, "public Pin(Attributable parent)", "parent member variable should be null", "null", testPin1.parent.toString());
		}
		if (testPin1.pinMapping != null) {
			success = TestDriver.displayError(testNum, "public Pin(Attributable parent)", "pinMapping member variable should be null", "null", testPin1.pinMapping.toString());
		}
		if (testPin1.net != null) {
			success = TestDriver.displayError(testNum, "public Pin(Attributable parent)", "net member variable should be null", "null", testPin1.net.toString());
		}
		if (testPin1.pinType != PinType.PIN) {
			success = TestDriver.displayError(testNum, "public Pin(Attributable parent)", "pinType member variable should be PIN", "PIN", testPin1.pinType.toString());
		}
		if (testPin1.index != -1) {
			success = TestDriver.displayError(testNum, "public Pin(Attributable parent)", "index member variable should be -1", "-1", testPin1.index + "");
		}
		
		/**
		 * Test 2
		 * 	public pin(Attributable parent);
		 * 		parent = Net object
		 */
		testNum++;
		Net parentNet = new Net(null);
		Pin testPin2 = new Pin(parentNet);
		if (testPin1.parent != null) {
			success = TestDriver.displayError(testNum, "public Pin(Attributable parent)", "parent member variable should be null when parameter is an invalid parent");
		}
		
		/**
		 * Test 3
		 * 	public pin(Attributable parent);
		 * 		parent = Device object
		 */
		testNum++;
		Device parentDevice = new Device("null");
		Pin testPin3 = new Pin(parentDevice);
		if (testPin3.parent != parentDevice) {
			success = TestDriver.displayError(testNum, "public Pin(Attributable parent)", "parent member variable should have same address as parameter");
		}
		if (!testPin3.parent.equals(parentDevice)) {
			success = TestDriver.displayError(testNum, "public Pin(Attributable parent)", "parent member variable should be a device with name \"null\"");
		}
		
		/**
		 * Test 4
		 * 	public Pin(Pin old, Attributable parent);
		 *  	old = testPin3
		 *  	parent = null
		 */
		testNum++;
		Pin copyPin1 = new Pin(testPin3, null);
		if (copyPin1.parent != null) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)", "member variable parent should be null", "\"null\"", copyPin1.parent.toString());
		}
		if (copyPin1.fileName != testPin3.fileName) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)", "member variable filename doesn't match", testPin3.fileName, copyPin1.fileName);
		}
		if (copyPin1.info != testPin3.info) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)", "member variable info doesn't match", testPin3.info, copyPin1.info);
		}
		if (copyPin1.line != testPin3.line) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)", "member variable line doesn't match", testPin3.line + "", copyPin1.line + "");
		}
		if (copyPin1.name != testPin3.name) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)", "member variable name doesn't match", testPin3.name, copyPin1.name);
		}
		if (copyPin1.pos != testPin3.pos) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)", "member variable pos doesn't match", testPin3.pos + "", copyPin1.pos + "");
		}
		if (!copyPin1.net.equals(testPin3.net)) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)", "member variable net doesn't match", testPin3.net.toString(), copyPin1.net.toString());
		}
		if (copyPin1.pinMapping != testPin3.pinMapping) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)", "member variable pinMapping doesn't match", testPin3.pinMapping, copyPin1.pinMapping);
		}
		if (copyPin1.pinType != testPin3.pinType) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)", "member variable pinType doesn't match", testPin3.pinType.toString(), copyPin1.pinType.toString());
		}
		if (copyPin1.index != testPin3.index) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)", "member variable index doesn't match", testPin3.index + "", copyPin1.index + "");
		}
		
		/**
		 * Test 5
		 * 	public Pin(Pin old, Attributable parent);
		 * 		old = copyPin1 modified
		 * 		parent = null
		 */
		testNum++;
		Net tempNet1 = new Net(null);
		copyPin1.fileName = "myfilename.phdl";
		copyPin1.info = "myinfo; isn't that cool?";
		copyPin1.line = 45;
		copyPin1.pos = 21;
		copyPin1.name = "copy_Pin_1";
		copyPin1.net = tempNet1;
		copyPin1.pinMapping = "AB";
		copyPin1.pinType = PinType.OUTPIN;
		copyPin1.index = 5;
		
		Pin copyPin2 = new Pin(copyPin1, null);
		if (copyPin2.fileName != copyPin1.fileName) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)", "member variable filename doesn't match", copyPin1.fileName, copyPin2.fileName);
		}
		if (copyPin2.info != copyPin1.info) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)", "member variable info doesn't match", copyPin1.info, copyPin2.info);
		}
		if (copyPin2.line != copyPin1.line) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)", "member variable line doesn't match", copyPin1.line + "", copyPin2.line + "");
		}
		if (copyPin2.name != copyPin1.name) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)", "member variable name doesn't match", copyPin1.name, copyPin2.name);
		}
		if (copyPin2.pos != copyPin1.pos) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)", "member variable pos doesn't match", copyPin1.pos + "", copyPin2.pos + "");
		}
		if (!copyPin2.net.equals(copyPin1.net)) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)", "member variable net doesn't match", copyPin1.net.toString(), copyPin2.net.toString());
		}
		if (copyPin2.pinMapping != copyPin1.pinMapping) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)", "member variable pinMapping doesn't match", copyPin1.pinMapping, copyPin2.pinMapping);
		}
		if (copyPin2.pinType != copyPin1.pinType) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)", "member variable pinType doesn't match", copyPin1.pinType.toString(), copyPin2.pinType.toString());
		}
		if (copyPin2.index != copyPin1.index) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)", "member variable index doesn't match", copyPin1.index + "", copyPin2.index + "");
		}
		
		/**
		 * Test 6
		 * 	public boolean equals(Object o);
		 * 		o = copyPin1, copyPin2
		 */
		testNum++;
		if (!copyPin1.equals(copyPin2)) {
			success = TestDriver.displayError(testNum, "public boolean equals(Object o)", "copyPin1 and copyPin2 should be equal");
		}
		if (!copyPin2.equals(copyPin1)) {
			success = TestDriver.displayError(testNum, "public boolean equals(Object o)", "copyPin2 and copyPin1 should be equal");
		}
		
		/**
		 * Test 7
		 * 	public boolean equals(Object o);
		 * 		o = testPin3
		 */
		testNum++;
		if (copyPin1.equals(testPin3)) {
			success = TestDriver.displayError(testNum, "public boolean equals(Object o)", "copyPin1 and testPin3 should not be equal");
		}
		if (testPin3.equals(copyPin1)) {
			success = TestDriver.displayError(testNum, "public boolean equals(Object o)", "testPin3 and copyPin1 should not be equal");
		}
		
		/**
		 * Test 8
		 * 	public boolean equals(Object o);
		 * 		o = testPin4a, testPin4b, gradually modified
		 */
		testNum++;
		Pin testPin4a = new Pin(null);
		testPin4a.name = "same_name";
		testPin4a.index = 4;
		testPin4a.net = null;
		testPin4a.pinMapping = "ab";
		testPin4a.pinType = PinType.SUPPIN;
		testPin4a.fileName = "my_filename";
		testPin4a.info = "my_info";
		testPin4a.line = 456;
		testPin4a.pos = 123;
		
		Pin testPin4b = new Pin(testPin4a, null);
		if (!testPin4a.equals(testPin4b)) {
			success = TestDriver.displayError(testNum, "public boolean equals(Object o)", "testPin4a and testPin4b should be equal");
		}
		
		testPin4b.name = "diff_name";
		if (testPin4a.equals(testPin4b)) {
			success = TestDriver.displayError(testNum, "public boolean equals(Object o)", "testPin4a and testPin4b should not be equal when names are different");
		}
		
		testPin4b.name = testPin4a.name;
		testPin4b.index = 3;
		if (testPin4a.equals(testPin4b)) {
			success = TestDriver.displayError(testNum, "public boolean equals(Object o)", "testPin4a and testPin4b should not be equal when indices are different");
		}
		
		testPin4b.index = testPin4a.index;
		testPin4b.pinMapping = "ba";
		if (testPin4a.equals(testPin4b)) {
			success = TestDriver.displayError(testNum, "public boolean equals(Object o)", "testPin4a and testPin4b should not be equal when pinMappings are different");
		}
		
		testPin4b.pinMapping = testPin4a.pinMapping;
		testPin4b.pinType = PinType.INPIN;
		if (testPin4a.equals(testPin4b)) {
			success = TestDriver.displayError(testNum, "public boolean equals(Object o)", "testPin4a and testPin4b should not be equal when pinTypes are different");
		}
		
		testPin4b.pinType = testPin4a.pinType;
		testPin4b.fileName = "other_filename";
		if (!testPin4a.equals(testPin4b)) {
			success = TestDriver.displayError(testNum, "public boolean equals(Object o)", "testPin4a and testPin4b should be equal when fileNames are different");
		}
		
		testPin4b.fileName = testPin4a.fileName;
		testPin4b.info = "other_info";
		if (!testPin4a.equals(testPin4b)) {
			success = TestDriver.displayError(testNum, "public boolean equals(Object o)", "testPin4a and testPin4b should be equal when infos are different");
		}
		
		testPin4b.info = testPin4a.info;
		testPin4b.line = 999;
		if (!testPin4a.equals(testPin4b)) {
			success = TestDriver.displayError(testNum, "public boolean equals(Object o)", "testPin4a and testPin4b should be equal when lines are different");
		}
		
		testPin4b.line = testPin4a.line;
		testPin4b.pos = 777;
		if (!testPin4a.equals(testPin4b)) {
			success = TestDriver.displayError(testNum, "public boolean equals(Object o)", "testPin4a and testPin4b should be equal when pos's are different");
		}
		
		return success;
	}
	
}
