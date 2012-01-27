/*
 * Copyright (C) 2011 Brigham Young University This program is free software: you can redistribute
 * it and/or modify it under the terms of the GNU General Public License as published by the Free
 * Software Foundation, version 3. This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received
 * a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package phdl.graph;

import phdl.TestDriver;

/**
 * A class that represents a Pin in PHDL.
 * 
 * @author Brad Riching and Richard Black
 * @version 0.1
 * 
 *          TODO: Add a boolean return to setter methods
 * 
 *          Date of Last Code Review: January 5, 2012 by Richard Black
 */
public class Pin extends Node {

	private Attributable parent;
	private Connection assignment;
	private String pinMapping;
	private PinType pinType;
	private int index;
	private boolean open;

	/**
	 * Default Constructor.
	 * 
	 * @param parent
	 *            the Parent to set
	 * @see Attributable
	 */
	public Pin(Attributable parent) {
		if (parent != null) {
			if (parent.getNodeType() == NodeType.DEVICE || parent.getNodeType() == NodeType.INSTANCE)
				setParent(parent);
		}
		this.pinMapping = null;
		this.assignment = null;
		this.pinType = PinType.PIN;
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
	public Pin(Attributable parent, Pin old) {
		super(old);
		this.parent = parent;
		this.pinMapping = old.getPinMapping();
		this.index = old.getIndex();
		this.pinType = old.getPinType();
		this.open = old.isOpen();
	}

	public Pin(Attributable parent, String name, PinType type) {
		if (parent != null) {
			if (parent.getNodeType() == NodeType.DEVICE || parent.getNodeType() == NodeType.INSTANCE)
				setParent(parent);
		}
		this.name = name;
		this.pinType = type;
		setIndex(-1);
	}

	@Override
	public boolean equals(Object o) {
		return name.equals(((Pin) o).getName()) && index == ((Pin) o).getIndex();
	}

	/**
	 * Assignment getter method
	 * 
	 * @return the connection assigned to this Pin
	 */
	public Connection getAssignment() {
		return assignment;
	}

	public int getIndex() {
		return index;
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
	 * Checks to see if the Pin has a Connection.
	 * 
	 * @return true, if there is a Connection false, otherwise
	 */
	public boolean hasAssignment() {
		return (assignment != null);
	}

	public boolean hasIndex() {
		if (getIndex() == -1)
			return false;
		else
			return true;
	}

	public boolean isOpen() {
		return open;
	}

	/**
	 * Net mutator method.
	 * 
	 * @param net
	 *            the new NetNode
	 */
	public void setAssignment(Connection assignment) {
		if (assignment != null) {
			this.assignment = assignment;
		}
	}

	public void setIndex(int index) {
		if (index < 0) {
			this.index = -1;
		} else {
			this.index = index;
		}
	}

	public void setOpen(boolean isOpen) {
		this.open = isOpen;
	}

	/**
	 * ParentNode mutator method.
	 * 
	 * @param parent
	 *            the new attributable parent node
	 */
	public void setParent(Attributable parent) {
		if (parent != null) {
			if (parent.getNodeType() == NodeType.DEVICE || parent.getNodeType() == NodeType.INSTANCE) {
				this.parent = parent;
			}
		}
	}

	/**
	 * PinName mutator method.
	 * 
	 * @param pinName
	 *            the new pinName
	 */
	public void setPinMapping(String pinMapping) {
		if (pinMapping != null) {
			this.pinMapping = pinMapping;
		}
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
		return getNodeType() + ": " + getPinType() + " " + name + ((index == -1) ? ("") : ("[" + index + "]")) + " = {"
			+ pinMapping + "}";
	}

	/***********************************
	 * Unit Test Code
	 * 	Author: Richard Black
	 * 	Date: January 4, 2012
	 * 
	 * 	WARNING: This test code assumes that certain methods work in other objects. Common
	 * 	occurrences of this are "equals," "compare," and "toString."
	 * 
	 * 	Legend
	 * 	# 	Proper Behavior (as of January 6, 2012)
	 * 	X 	Improper Behavior
	 * 	? 	Untested
	 * 
	 * 	Member Variables
	 * 		Attributable parent
	 * 		String pinMapping
	 * 		Net net
	 * 		PinType pinType
	 * 		int index
	 * 
	 * 	Methods
	 * 		# 	public Pin(Attributable parent);
	 * 		# 	public Pin(Pin old, Attributable parent);
	 * 		#	public boolean equals(Object o);
	 * 		# 	public int getIndex();
	 * 		# 	public Net getNet();
	 * 		# 	public NodeType getNodeType();
	 * 		# 	public Attributable getParent();
	 * 		# 	public String getPinMapping();
	 * 		#	public PinType getPinType();
	 * 		# 	public boolean hasNet();
	 * 		# 	public void setIndex(int index);
	 * 		#	public void setNet(Net net);
	 * 		#	public void setParent(Attributable parent);
	 * 		# 	public void setPinMapping(String pinMapping);
	 * 		# 	public void setPinType(PinType type);
	 * 		# 	public String toString();
	 * 
	 ***********************************/
	public static boolean unitTest() {
		boolean success = true;
		int testNum = 0;
		/**
		 * Test 1
		 * 	public pin(Attributable parent);
		 * 		parent = null
		 */
		testNum++;
		Pin testPin1 = new Pin(null);
		if (testPin1.parent != null) {
			success = TestDriver.displayError(testNum, "public Pin(Attributable parent)",
				"parent member variable should be null", "null", testPin1.parent.toString());
		}
		if (testPin1.pinMapping != null) {
			success = TestDriver.displayError(testNum, "public Pin(Attributable parent)",
				"pinMapping member variable should be null", "null", testPin1.pinMapping.toString());
		}
		if (testPin1.assignment != null) {
			success = TestDriver.displayError(testNum, "public Pin(Attributable parent)",
				"net member variable should be null", "null", testPin1.assignment.toString());
		}
		if (testPin1.pinType != PinType.PIN) {
			success = TestDriver.displayError(testNum, "public Pin(Attributable parent)",
				"pinType member variable should be PIN", "PIN", testPin1.pinType.toString());
		}
		if (testPin1.index != -1) {
			success = TestDriver.displayError(testNum, "public Pin(Attributable parent)",
				"index member variable should be -1", "-1", testPin1.index + "");
		}

		/**
		 * Test 2
		 * 	public pin(Attributable parent);
		 * 		parent = Net object
		 */
		testNum++;
		Net parentNet = new Net(null);
		Pin testPin2 = new Pin(parentNet);
		if (testPin2.parent != null) {
			success = TestDriver.displayError(testNum, "public Pin(Attributable parent)",
				"parent member variable should be null when parameter is an invalid parent");
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
			success = TestDriver.displayError(testNum, "public Pin(Attributable parent)",
				"parent member variable should have same address as parameter");
		}
		if (!testPin3.parent.equals(parentDevice)) {
			success = TestDriver.displayError(testNum, "public Pin(Attributable parent)",
				"parent member variable should be a device with name \"null\"");
		}

		/**
		 * Test 4
		 * 	public Pin(Pin old, Attributable parent);
		 * 		old = testPin3
		 * 		parent = null
		 */
		testNum++;
		Net testNet3 = new Net(null);
		testNet3.name = "test_net_3";
		testPin3.assignment = testNet3;
		testPin3.name = "test_pin_3";
		testPin3.parent = parentDevice;
		Pin copyPin1 = new Pin(parentDevice, testPin3);

		if (copyPin1.parent == null) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)",
				"member variable parent should not be null", "\"null\"", copyPin1.parent.toString());
		}
		if (copyPin1.fileName != testPin3.fileName) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)",
				"member variable filename doesn't match", testPin3.fileName, copyPin1.fileName);
		}
		if (copyPin1.info != testPin3.info) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)",
				"member variable info doesn't match", testPin3.info, copyPin1.info);
		}
		if (copyPin1.line != testPin3.line) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)",
				"member variable line doesn't match", testPin3.line + "", copyPin1.line + "");
		}
		if (copyPin1.name != testPin3.name) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)",
				"member variable name doesn't match", testPin3.name, copyPin1.name);
		}
		if (copyPin1.pos != testPin3.pos) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)",
				"member variable pos doesn't match", testPin3.pos + "", copyPin1.pos + "");
		}
		if (copyPin1.pinMapping != testPin3.pinMapping) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)",
				"member variable pinMapping doesn't match", testPin3.pinMapping, copyPin1.pinMapping);
		}
		if (copyPin1.pinType != testPin3.pinType) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)",
				"member variable pinType doesn't match", testPin3.pinType.toString(), copyPin1.pinType.toString());
		}
		if (copyPin1.index != testPin3.index) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)",
				"member variable index doesn't match", testPin3.index + "", copyPin1.index + "");
		}

		/**
		 * Test 5
		 * 	public Pin(Pin old, Attributable parent);
		 * 		old = copyPin1 modified
		 * 		parent = null
		 */
		testNum++;
		Net tempNet1 = new Net(null);
		tempNet1.name = "temp_net_1";
		copyPin1.fileName = "myfilename.phdl";
		copyPin1.info = "myinfo; isn't that cool?";
		copyPin1.line = 45;
		copyPin1.pos = 21;
		copyPin1.name = "copy_Pin_1";
		copyPin1.assignment = tempNet1;
		copyPin1.pinMapping = "AB";
		copyPin1.pinType = PinType.OUTPIN;
		copyPin1.index = 5;

		Pin copyPin2 = new Pin(null, copyPin1);
		if (copyPin2.fileName != copyPin1.fileName) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)",
				"member variable filename doesn't match", copyPin1.fileName, copyPin2.fileName);
		}
		if (copyPin2.info != copyPin1.info) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)",
				"member variable info doesn't match", copyPin1.info, copyPin2.info);
		}
		if (copyPin2.line != copyPin1.line) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)",
				"member variable line doesn't match", copyPin1.line + "", copyPin2.line + "");
		}
		if (copyPin2.name != copyPin1.name) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)",
				"member variable name doesn't match", copyPin1.name, copyPin2.name);
		}
		if (copyPin2.pos != copyPin1.pos) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)",
				"member variable pos doesn't match", copyPin1.pos + "", copyPin2.pos + "");
		}
		if (copyPin2.pinMapping != copyPin1.pinMapping) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)",
				"member variable pinMapping doesn't match", copyPin1.pinMapping, copyPin2.pinMapping);
		}
		if (copyPin2.pinType != copyPin1.pinType) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)",
				"member variable pinType doesn't match", copyPin1.pinType.toString(), copyPin2.pinType.toString());
		}
		if (copyPin2.index != copyPin1.index) {
			success = TestDriver.displayError(testNum, "public Pin(Pin old, Attributable parent)",
				"member variable index doesn't match", copyPin1.index + "", copyPin2.index + "");
		}

		/**
		 * Test 6
		 * 	public boolean equals(Object o);
		 * 		o = copyPin1, copyPin2
		 */
		testNum++;
		if (!copyPin1.equals(copyPin2)) {
			success = TestDriver.displayError(testNum, "public boolean equals(Object o)",
				"copyPin1 and copyPin2 should be equal");
		}
		if (!copyPin2.equals(copyPin1)) {
			success = TestDriver.displayError(testNum, "public boolean equals(Object o)",
				"copyPin2 and copyPin1 should be equal");
		}

		/**
		 * Test 7 public boolean equals(Object o); o = testPin3
		 */
		testNum++;
		if (copyPin1.equals(testPin3)) {
			success = TestDriver.displayError(testNum, "public boolean equals(Object o)",
				"copyPin1 and testPin3 should not be equal");
		}
		if (testPin3.equals(copyPin1)) {
			success = TestDriver.displayError(testNum, "public boolean equals(Object o)",
				"testPin3 and copyPin1 should not be equal");
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
		testPin4a.assignment = null;
		testPin4a.pinMapping = "ab";
		testPin4a.pinType = PinType.SUPPIN;
		testPin4a.fileName = "my_filename";
		testPin4a.info = "my_info";
		testPin4a.line = 456;
		testPin4a.pos = 123;

		Pin testPin4b = new Pin(null, testPin4a);
		if (!testPin4a.equals(testPin4b)) {
			success = TestDriver.displayError(testNum, "public boolean equals(Object o)",
				"testPin4a and testPin4b should be equal");
		}

		testPin4b.name = "diff_name";
		if (testPin4a.equals(testPin4b)) {
			success = TestDriver.displayError(testNum, "public boolean equals(Object o)",
				"testPin4a and testPin4b should not be equal when names are different");
		}

		testPin4b.name = testPin4a.name;
		testPin4b.index = 3;
		if (testPin4a.equals(testPin4b)) {
			success = TestDriver.displayError(testNum, "public boolean equals(Object o)",
				"testPin4a and testPin4b should not be equal when indices are different");
		}

		testPin4b.index = testPin4a.index;
		testPin4b.pinMapping = "ba";
		if (!testPin4a.equals(testPin4b)) {
			success = TestDriver.displayError(testNum, "public boolean equals(Object o)",
				"testPin4a and testPin4b should be equal when pinMappings are different");
		}

		testPin4b.pinMapping = testPin4a.pinMapping;
		testPin4b.pinType = PinType.INPIN;
		if (!testPin4a.equals(testPin4b)) {
			success = TestDriver.displayError(testNum, "public boolean equals(Object o)",
				"testPin4a and testPin4b should be equal when pinTypes are different");
		}

		testPin4b.pinType = testPin4a.pinType;
		testPin4b.fileName = "other_filename";
		if (!testPin4a.equals(testPin4b)) {
			success = TestDriver.displayError(testNum, "public boolean equals(Object o)",
				"testPin4a and testPin4b should be equal when fileNames are different");
		}

		testPin4b.fileName = testPin4a.fileName;
		testPin4b.info = "other_info";
		if (!testPin4a.equals(testPin4b)) {
			success = TestDriver.displayError(testNum, "public boolean equals(Object o)",
				"testPin4a and testPin4b should be equal when infos are different");
		}

		testPin4b.info = testPin4a.info;
		testPin4b.line = 999;
		if (!testPin4a.equals(testPin4b)) {
			success = TestDriver.displayError(testNum, "public boolean equals(Object o)",
				"testPin4a and testPin4b should be equal when lines are different");
		}

		testPin4b.line = testPin4a.line;
		testPin4b.pos = 777;
		if (!testPin4a.equals(testPin4b)) {
			success = TestDriver.displayError(testNum, "public boolean equals(Object o)",
				"testPin4a and testPin4b should be equal when pos's are different");
		}

		/**
		 * Test 9 public int getIndex();
		 */
		testNum++;
		Pin testPin5 = new Pin(null);
		if (testPin5.getIndex() != -1) {
			success = TestDriver.displayError(testNum, "public int getIndex()",
				"Upon initialization, index should be -1");
		}
		testPin5.index = 4;
		if (testPin5.getIndex() != 4) {
			success = TestDriver.displayError(testNum, "public int getIndex()", "Index incorrect", testPin5.index + "",
				testPin5.getIndex() + "");
		}

		/**
		 * Test 10 public
		 * 	Net getNet();
		 */
		testNum++;
		if (testPin5.getAssignment() != null) {
			success = TestDriver
				.displayError(testNum, "public Net getNet()", "Upon initialization, net should be null");
		}
		Design dummy_des = new Design("dummy");
		Net testNet5 = new Net(dummy_des);
		testNet5.name = "test_net_5";
		testPin5.assignment = testNet5;
		if (!testPin5.getAssignment().equals(testNet5)) {
			success = TestDriver.displayError(testNum, "public Net getNet()", "Net incorrect", testNet5.toString(),
				testPin5.getAssignment().toString());
		}

		/**
		 * Test 11
		 * 	public NodeType getNodeType();
		 */
		testNum++;
		if (testPin5.getNodeType() != NodeType.PIN) {
			success = TestDriver.displayError(testNum, "public NodeType getNodeType()",
				"A Pin should have a nodeType of PIN");
		}

		/**
		 * Test 12
		 * 	public Attributable getParent();
		 */
		testNum++;
		if (testPin5.getParent() != null) {
			success = TestDriver.displayError(testNum, "public NodeType getParent()", "Incorrect parent", "null",
				testPin5.getParent().toString());
		}
		Device parentDevice5 = new Device("parent_device_5");
		testPin5.parent = parentDevice5;
		if (!testPin5.getParent().equals(parentDevice5)) {
			success = TestDriver.displayError(testNum, "public NodeType getParent()", "Incorrect parent",
				parentDevice5.toString(), testPin5.getParent().toString());
		}

		/**
		 * Test 13
		 * 	public String getPinMapping();
		 */
		testNum++;
		if (testPin5.getPinMapping() != null) {
			success = TestDriver.displayError(testNum, "public NodeType getPinMapping()",
				"Upon initialization, pinMapping should be null", "null", testPin5.getPinMapping());
		}
		testPin5.pinMapping = "5ab";
		if (!testPin5.getPinMapping().equals("5ab")) {
			success = TestDriver.displayError(testNum, "public NodeType getPinMapping()", "pinMapping incorrect",
				testPin5.pinMapping, testPin5.getPinMapping());
		}

		/**
		 * Test 14
		 * 	public String getPinMapping();
		 */
		testNum++;
		if (testPin5.getPinType() != PinType.PIN) {
			success = TestDriver.displayError(testNum, "public NodeType getPinType()",
				"Upon initialization, pinType should be PIN", testPin5.pinType.toString(), testPin5.getPinType()
					.toString());
		}
		testPin5.pinType = PinType.PWRPIN;
		if (testPin5.getPinType() != PinType.PWRPIN) {
			success = TestDriver.displayError(testNum, "public NodeType getPinType()",
				"Upon initialization, pinType should be PWRPIN", testPin5.pinType.toString(), testPin5.getPinType()
					.toString());
		}

		/**
		 * Test 15
		 * 	public boolean hasNet();
		 */
		testNum++;
		Pin testPin6 = new Pin(null);
		if (testPin6.hasAssignment()) {
			success = TestDriver.displayError(testNum, "public boolean hasNet()",
				"Upon initialization, there should be no net");
		}
		Net testNet6 = new Net(null);
		testPin6.assignment = testNet6;
		if (!testPin6.hasAssignment()) {
			success = TestDriver.displayError(testNum, "public boolean hasNet()",
				"The Pin has a Net, but hasNet() returned false");
		}

		/**
		 * Test 16
		 * 	public void setIndex(int index);
		 */
		testNum++;
		testPin6.setIndex(14);
		if (testPin6.getIndex() != 14) {
			success = TestDriver.displayError(testNum, "public void setIndex(int index)", "Incorrect index", "14",
				testPin6.getIndex() + "");
		}
		testPin6.setIndex(-1);
		if (testPin6.getIndex() != -1) {
			success = TestDriver.displayError(testNum, "public void setIndex(int index)", "Incorrect index", "-1",
				testPin6.getIndex() + "");
		}
		testPin6.setIndex(-123);
		if (testPin6.getIndex() != -1) {
			success = TestDriver.displayError(testNum, "public void setIndex(int index)",
				"Index should default to -1 if less than 0", "-1", testPin6.getIndex() + "");
		}
		testPin6.setIndex(320584);
		if (testPin6.getIndex() != 320584) {
			success = TestDriver.displayError(testNum, "public void setIndex(int index)",
				"There should be no upper limit on index", "320584", testPin6.getIndex() + "");
		}

		/**
		 * Test 17
		 * 	public void setNet(Net net);
		 */
		testNum++;
		Pin testPin7 = new Pin(null);
		Net testNet7 = new Net(dummy_des);
		testNet7.name = "test_net_7";
		testPin7.setAssignment(testNet7);
		if (!testPin7.getAssignment().equals(testNet7)) {
			success = TestDriver.displayError(testNum, "public void setNet(Net net)", "Incorrect Net",
				testNet7.toString(), testPin7.getAssignment().toString());
		}
		testPin7.setAssignment(null);
		if (testPin7.getAssignment() == null) {
			success = TestDriver.displayError(testNum, "public void setNet(Net net)",
				"Should not be able to assign null via setNet()");
		}

		/**
		 * Test 18
		 * 	public void setParent(Attributable parent);
		 */
		testNum++;
		Device parentDevice7 = new Device("parent_device_7");
		testPin7.setParent(parentDevice7);
		if (!testPin7.getParent().equals(parentDevice7)) {
			success = TestDriver.displayError(testNum, "public void setParent(Attributable parent)",
				"Incorrect Parent", parentDevice7.toString(), testPin7.getParent().toString());
		}
		testPin7.setParent(null);
		if (testPin7.getParent() == null) {
			success = TestDriver.displayError(testNum, "public void setParent(Attributable parent)",
				"Should not be able to assign null via setParent()");
		}

		/**
		 * Test 19
		 * 	public void setPinMapping(String pinMapping);
		 */
		testNum++;
		testPin7.setPinMapping("7xyz");
		if (!testPin7.getPinMapping().equals("7xyz")) {
			success = TestDriver.displayError(testNum, "public void setPinMapping(String pinMapping)",
				"Incorrect PinMapping", "7xyz", testPin7.getPinMapping());
		}
		testPin7.setPinMapping(null);
		if (testPin7.getPinMapping() == null) {
			success = TestDriver.displayError(testNum, "public void setPinMapping(String pinMapping)",
				"Should not be able to assign null via setPinMapping");
		}

		/**
		 * Test 20
		 * 	public void setPinType(PinType type);
		 */
		testNum++;
		testPin7.setPinType(PinType.INPIN);
		if (testPin7.getPinType() != PinType.INPIN) {
			success = TestDriver.displayError(testNum, "public void setPinType(PinType pinType)", "Incorrect PinType",
				PinType.INPIN.toString(), testPin7.getPinType().toString());
		}
		testPin7.setPinType(PinType.IOPIN);
		if (testPin7.getPinType() != PinType.IOPIN) {
			success = TestDriver.displayError(testNum, "public void setPinType(PinType pinType)", "Incorrect PinType",
				PinType.IOPIN.toString(), testPin7.getPinType().toString());
		}
		testPin7.setPinType(PinType.OUTPIN);
		if (testPin7.getPinType() != PinType.OUTPIN) {
			success = TestDriver.displayError(testNum, "public void setPinType(PinType pinType)", "Incorrect PinType",
				PinType.OUTPIN.toString(), testPin7.getPinType().toString());
		}
		testPin7.setPinType(PinType.PWRPIN);
		if (testPin7.getPinType() != PinType.PWRPIN) {
			success = TestDriver.displayError(testNum, "public void setPinType(PinType pinType)", "Incorrect PinType",
				PinType.PWRPIN.toString(), testPin7.getPinType().toString());
		}
		testPin7.setPinType(PinType.SUPPIN);
		if (testPin7.getPinType() != PinType.SUPPIN) {
			success = TestDriver.displayError(testNum, "public void setPinType(PinType pinType)", "Incorrect PinType",
				PinType.SUPPIN.toString(), testPin7.getPinType().toString());
		}
		testPin7.setPinType(PinType.PIN);
		if (testPin7.getPinType() != PinType.PIN) {
			success = TestDriver.displayError(testNum, "public void setPinType(PinType pinType)", "Incorrect PinType",
				PinType.PIN.toString(), testPin7.getPinType().toString());
		}

		/**
		 * Test 21
		 * 	public String toString();
		 */
		testNum++;
		Pin testPin8 = new Pin(null);
		Net testNet8 = new Net(null);
		testNet8.setName("net_test_8");
		testPin8.setName("test_pin_8");
		testPin8.setLine(18);
		testPin8.setPosition(81);
		testPin8.setFileName("8_pin_test.phdl");
		testPin8.setIndex(-1);
		testPin8.setPinMapping("8ijk");
		testPin8.setPinType(PinType.INPIN);
		testPin8.setAssignment(testNet8);
		String testPin8Str = "PIN: INPIN test_pin_8 = {8ijk}";

		if (!testPin8.toString().equals(testPin8Str)) {
			success = TestDriver.displayError(testNum, "public String toString()", "Incorrect Output w/o index", "\n"
				+ testPin8Str, "\n" + testPin8.toString());
		}

		testPin8.setIndex(24);
		testPin8Str = "PIN: INPIN test_pin_8[24] = {8ijk}";
		if (!testPin8.toString().equals(testPin8Str)) {
			success = TestDriver.displayError(testNum, "public String toString()", "Incorrect Output w/ index", "\n"
				+ testPin8Str, "\n" + testPin8.toString());
		}

		return success;
	}

}
