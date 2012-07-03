/*
 * Copyright (C) 2011 Brigham Young University This program is free software: you can redistribute
 * it and/or modify it under the terms of the GNU General Public License as published by the Free
 * Software Foundation, version 3. This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received
 * a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package edu.byu.ee.phdl.elaboration;

// import phdl.TestDriver;

/**
 * A class that represents a net in PHDL.
 * 
 * @author Brad Riching and Richard Black
 * @version 0.1
 */
public class ElaboratedNet extends ElaboratedConnection {

	/**
	 * Default Constructor.
	 * 
	 * @param d the DesignNode that is the parent of this net
	 */
	public ElaboratedNet(ElaboratedDesignUnit design) {
		super(design);
	}

	public ElaboratedNet(ElaboratedDesignUnit parent, ElaboratedNet oldNet) {
		super(parent, oldNet);
	}

	public ElaboratedNet(ElaboratedDesignUnit design, String name) {
		super(design, name);
	}

	@Override
	/**
	 * Type accessor method.
	 * 
	 * @return NodeType.NET
	 */
	public NodeType getNodeType() {
		return NodeType.NET;
	}

	// /**
	// * Unit Test Code Author: Richard Black Date: January 6, 2012
	// *
	// * WARNING: This test code assumes that certain methods work in other objects. Common
	// * occurrences of this are "equals," "compare," and "toString."
	// *
	// * Legend # Proper Behavior X Improper Behavior ? Untested
	// *
	// * Member Variables private boolean visited;
	// *
	// * Methods # public Net(Design design); ? public Net(Design design, String name); # public
	// * boolean isVisited(); # public void setVisited(boolean visited); ? public Net
	// * getUnvisitedNet();
	// */
	// public static boolean unitTest() {
	// boolean success = true;
	// int testNum = 0;
	//
	// /**
	// * Test 1 public Net(Design design); parent = null
	// */
	// testNum++;
	// Net testNet1 = new Net(null);
	// if (testNet1.isVisited() != false) {
	// success &= TestDriver.displayError(testNum, "public Net(Design design)",
	// "visited should be false");
	// }
	//
	// /**
	// * Test 2 public Net(Design design); parent = empty design
	// */
	// testNum++;
	// Design parentDesign2 = new Design();
	// parentDesign2.name = "parent_design_2";
	// Net testNet2 = new Net(parentDesign2);
	//
	// /**
	// * Test 3 public boolean isVisited(); visited = false, then true
	// */
	// testNum++;
	// if (testNet2.isVisited()) {
	// success &= TestDriver.displayError(testNum, "public Net(Design design)",
	// "initially, the net should not be marked visited");
	// }
	// testNet2.setVisited(true);
	// if (!testNet2.isVisited()) {
	// success &= TestDriver
	// .displayError(testNum, "public Net(Design design)", "the net should be marked visited");
	// }
	//
	// /**
	// * Test 4 public NodeType getNodeType();
	// */
	// testNum++;
	// if (testNet2.getNodeType() != NodeType.NET) {
	// success &= TestDriver.displayError(testNum, "public NodeType getNodeType()",
	// "incorrect node type",
	// NodeType.NET.toString(), testNet2.getNodeType().toString());
	// }
	//
	// /**
	// * Test 5 public boolean equals()
	// */
	// testNum++;
	// Design top = new Design();
	//
	// SubInstance outer1 = new SubInstance(top, "outer");
	// outer1.setIndex(1);
	// SubInstance inner1 = new SubInstance(outer1, "inner");
	// Net net11 = new Net(inner1);
	// net11.setName("net1");
	// inner1.addConnection(net11);
	// outer1.addSubInst(inner1);
	//
	// SubInstance outer2 = new SubInstance(top, "outer");
	// outer2.setIndex(2);
	// SubInstance inner2 = new SubInstance(outer2, "inner");
	// Net net12 = new Net(inner2);
	// net12.setName("net1");
	// inner2.addConnection(net12);
	// outer2.addSubInst(inner2);
	//
	// if (net11.equals(net12)) {
	// success &= TestDriver.displayError(testNum, "public boolean equals()", "Incorrect value",
	// "true", "false");
	// }
	//
	// return success;
	// }

}
