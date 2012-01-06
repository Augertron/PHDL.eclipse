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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import phdl.TestDriver;

/**
 * A class that represents a net in PHDL.
 * 
 * @author Brad Riching and Richard Black
 * @version 0.1
 */
public class Net extends Attributable {

	private Set<Net> nets;
	private List<Pin> pins;
	private Design design;
	private int index;
	private boolean visited = false;

	/**
	 * Default Constructor.
	 * 
	 * @param d
	 *            the DesignNode that is the parent of this net
	 */
	public Net(Design design) {
		super();
		pins = new ArrayList<Pin>();
		nets = new TreeSet<Net>();
		this.design = design;
		this.index = -1;
	}

	/**
	 * Helper acccessor method for a Depth First Search.
	 * 
	 * @return true, if this Node has been visited false, otherwise
	 */
	public boolean isVisited() {
		return visited;
	}

	/**
	 * Helper mutator method for a Depth First Search.
	 * 
	 * @param visited
	 *            the new value of visited
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	/**
	 * Pins accessor method.
	 * 
	 * This method is particularly helpful when generating a netlist.
	 * 
	 * @return the set of PinNodes attached to this net
	 */
	public List<Pin> getPinNodes() {
		return pins;
	}

	/**
	 * Pin addition method.
	 * 
	 * @param p
	 *            the new PinNode
	 * @return true, if the pin wasn't in the List false, otherwise
	 */
	public boolean addPin(Pin p) {
		if (p != null) {
			return (!pins.add(p));
		}
		return false;
		
	}

	/**
	 * Nets accessor method.
	 * 
	 * This method is particularly helpful when using the supernet alogorithm.
	 * 
	 * @return the set of NetNodes attached to this net
	 */
	public Set<Net> getNetNodes() {
		return nets;
	}

	/**
	 * Checks to see if any nets are attached to this net.
	 * 
	 * @return true, if there are nets attached, false, if there aren't
	 */
	public boolean hasNets() {
		return (!nets.isEmpty());
	}

	/**
	 * Removes a net connection from this net.
	 * 
	 * @param n
	 *            the net to remove
	 */
	public void removeNet(Net n) {
		nets.remove(n);
	}

	/**
	 * NetNode addition method.
	 * 
	 * @param n
	 *            the new NetNode to add
	 * @return true, if the NetNode isn't already connected, false otherwise
	 */
	public boolean addNet(Net n) {
		if (n != null) {
			return nets.add(n);
		}
		return false;
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

	/**
	 * Parent DesignNode mutator method.
	 * 
	 * @param design
	 *            the new DesignNode
	 */
	public void setDesign(Design design) {
		this.design = design;
	}

	/**
	 * Parent DesignNode accessor method.
	 * 
	 * @return the NetNode's parent DesignNode
	 */
	public Design getDesign() {
		return design;
	}

	@Override
	/**
	 * Generic toString method.
	 * 
	 * @return a string representation of the NetNode
	 */
	public String toString() {
		String netString = super.toString() + ((index == -1) ? ("") : ("[" + index + "]")) + " $ ";
		for (Net n : nets) {
			netString += n.getName() + ((n.getIndex() == -1) ? ("") : ("[" + n.getIndex() + "]"))
					+ " $ ";
		}
		netString = netString.substring(0, netString.length() - 3);
		for (Attribute a : attributes) {
			netString += "\n\t\t" + a.toString();
		}
		return netString;
	}

	/**
	 * Returns the index of the current Net, assuming that it has an array reference.
	 * 
	 * @return the index of the Net
	 */
	public int getIndex() {
		int start = getName().indexOf('[');
		int end = getName().indexOf(']');

		if (start == -1 || end == -1) {
			return -1;
		}

		String index = getName().substring(start + 1, end);
		return Integer.parseInt(index);
	}

	/**
	 * Helper method for superNet algorithm.
	 * 
	 * Iterates through all nets attached to this NetNode and returns the first one that is
	 * unvisited.
	 * 
	 * @return the first NetNode that is unvisited, null if there aren't any
	 */
	public Net getUnvisitedNet() {
		for (Net n : nets) {
			if (!n.isVisited())
				return n;
		}
		return null;
	}

	@Override
	public void setName(String name) {
		this.name = name.toUpperCase();
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public boolean equals(Object o) {
		return this.name.equals(((Net) o).getName()) && this.index == ((Net) o).getIndex();
	}
	
	
	/**
	 * Unit Test Code
	 * Author:	Richard Black
	 * Date:	January 6, 2012
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
	 * 		private Set<Net> nets;
	 * 		private List<Pin> pins;
	 * 		private Design design;
	 * 		private int index;
	 * 		private boolean visited;
	 * 
	 * 	Methods
	 * 		#	public Net(Design design);
	 * 		#	public boolean isVisited();
	 * 		#	public void setVisited(boolean visited);
	 * 		#	public List<Pin> getPinNodes();
	 * 		#	public boolean addPin(Pin p);
	 * 		#	public Set<Net> getNetNodes();
	 * 		#	public boolean hasNets();
	 * 		#	public void removeNet(Net n);
	 * 		#	public boolean addNet(Net n);
	 * 		#	public NodeType getNodeType();
	 * 		#	public Design getDesign();
	 * 		?	public void setDesign(Design design);
	 * 		?	public int getIndex();
	 * 		?	public void setIndex(int index);
	 * 		?	public Net getUnvisitedNet();
	 * 		?	public void setName(String name);
	 * 		?	public String toString();
	 * 		?	public boolean equals(Object o);
	 */
	public static boolean unitTest() {
		boolean success = true;
		int testNum = 0;
		
		/**
		 * Test 1
		 * 	public Net(Design design);
		 * 		parent = null;
		 */
		testNum++;
		Net testNet1 = new Net(null);
		if (testNet1.nets == null) {
			success = TestDriver.displayError(testNum, "public Net(Design design)", "nets should be initialized");
		}
		else if (!testNet1.nets.isEmpty()) {
			success = TestDriver.displayError(testNum, "public Net(Design design)", "nets should be an empty set");
		}
		if (testNet1.pins == null) {
			success = TestDriver.displayError(testNum, "public Net(Design design)", "pins should be initialized");
		}
		else if (!testNet1.pins.isEmpty()) {
			success = TestDriver.displayError(testNum, "public Net(Design design)", "pins should be an empty set");
		}
		if (testNet1.design != null) {
			success = TestDriver.displayError(testNum, "public Net(Design design)", "design should be null", "null", testNet1.design.toString());
		}
		if (testNet1.index != -1) {
			success = TestDriver.displayError(testNum, "public Net(Design design)", "index incorrect", "-1", testNet1.index + "");
		}
		if (testNet1.visited != false) {
			success = TestDriver.displayError(testNum, "public Net(Design design)", "visited should be false");
		}
		
		/**
		 * Test 2
		 * 	public Net(Design design);
		 * 		parent = empty design
		 */
		testNum++;
		Design parentDesign2 = new Design();
		parentDesign2.name = "parent_design_2";
		Net testNet2 = new Net(parentDesign2);
		if (!testNet2.design.equals(parentDesign2)) {
			success = TestDriver.displayError(testNum, "public Net(Design design)", "parent design incorrect", parentDesign2.toString(), testNet1.design.toString());
		}
		
		/**
		 * Test 3
		 * 	public boolean isVisited();
		 * 		visited = false, then true
		 */
		testNum++;
		if (testNet2.isVisited()) {
			success = TestDriver.displayError(testNum, "public Net(Design design)", "initially, the net should not be marked visited");
		}
		testNet2.visited = true;
		if (!testNet2.isVisited()) {
			success = TestDriver.displayError(testNum, "public Net(Design design)", "the net should be marked visited");
		}
		
		/**
		 * Test 4
		 * 	public List<Pin> getPinNodes();
		 * 		empty, then a couple
		 */
		testNum++;
		if (testNet2.getPinNodes() == null) {
			success = TestDriver.displayError(testNum, "public List<Pin> getPinNodes()", "list of pins should not be null");
		}
		else if (!testNet2.getPinNodes().isEmpty()) {
			success = TestDriver.displayError(testNum, "public List<Pin> getPinNodes()", "list of pins should be empty");
		}
		Pin testPin2a = new Pin(null); testPin2a.name = "test_pin_2_a";
		Pin testPin2b = new Pin(null); testPin2b.name = "test_pin_2_b";
		testNet2.pins.add(testPin2a);
		testNet2.pins.add(testPin2b);
		
		if (testNet2.getPinNodes().isEmpty()) {
			success = TestDriver.displayError(testNum, "public List<Pin> getPinNodes()", "list of pins should not be empty");
		}
		else if (testNet2.getPinNodes().size() != 2) {
			success = TestDriver.displayError(testNum, "public List<Pin> getPinNodes()", "incorrect size", "2", testNet2.getPinNodes().size() + "");
		}
		else if (!testNet2.getPinNodes().contains(testPin2a)) {
			success = TestDriver.displayError(testNum, "public List<Pin> getPinNodes()", "list does not contain testPin2a");
		}
		else if (!testNet2.getPinNodes().contains(testPin2b)) {
			success = TestDriver.displayError(testNum, "public List<Pin> getPinNodes()", "list does not contain testPin2b");
		}
		else {
			if (!testNet2.getPinNodes().get(0).equals(testPin2a)) {
				success = TestDriver.displayError(testNum, "public List<Pin> getPinNodes()", "wrong pin at index 0", testPin2a.toString(), testNet2.getPinNodes().get(0).toString());				
			}
			if (!testNet2.getPinNodes().get(1).equals(testPin2b)) {
				success = TestDriver.displayError(testNum, "public List<Pin> getPinNodes()", "wrong pin at index 1", testPin2b.toString(), testNet2.getPinNodes().get(1).toString());
			}
		}
		
		/**
		 * Test 5
		 * 	public boolean addPin(Pin p);
		 * 		add empty pin, null
		 */
		testNum++;
		Net testNet3 = new Net(null);
		Pin testPin3a = new Pin(null); testPin3a.name = "test_pin_3_a";
		Pin testPin3b = new Pin(null); testPin3b.name = "test_pin_3_b";
		testNet3.addPin(testPin3a);
		if (!testNet3.getPinNodes().contains(testPin3a)) {
			success = TestDriver.displayError(testNum, "public boolean addPin()", "list does not contain testPin3a");
		}
		if (testNet3.getPinNodes().size() != 1) {
			success = TestDriver.displayError(testNum, "public boolean addPin()", "incorrect size", "1", testNet3.getPinNodes().size() + "");
		}
		if (!testNet3.getPinNodes().get(0).equals(testPin3a) && testNet3.getPinNodes().get(0) != null) {
			success = TestDriver.displayError(testNum, "public boolean addPin()", "incorrect index for pin", testPin3a.toString(), testNet3.getPinNodes().get(0).toString());
		}
		
		testNet3.addPin(null);
		if (testNet3.getPinNodes().size() != 1) {
			success = TestDriver.displayError(testNum, "public boolean addPin()", "size should not change after adding null", "1", testNet3.getPinNodes().size() + "");
		}
		if (!testNet3.getPinNodes().get(0).equals(testPin3a) && testNet3.getPinNodes().get(0) != null) {
			success = TestDriver.displayError(testNum, "public boolean addPin()", "incorrect index for pin after adding null", testPin3a.toString(), testNet3.getPinNodes().get(0).toString());
		}
		
		/**
		 * Test 6
		 * 	public Set<Net> getNetNodes();
		 * 		empty, then a couple empty nets
		 */
		testNum++;
		if (testNet3.getNetNodes() == null) {
			success = TestDriver.displayError(testNum, "public Set<Net> getNetNodes()", "nets should not be null");
		}
		else {
			if (!testNet3.getNetNodes().isEmpty()) {
				success = TestDriver.displayError(testNum, "public Set<Net> getNetNodes()", "nets should not be null");
			}
		}
		
		Net testNet3a = new Net(null); testNet3a.name = "test_net_3_a";
		Net testNet3b = new Net(null); testNet3b.name = "test_net_3_b";
		testNet3.nets.add(testNet3a);
		testNet3.nets.add(testNet3b);
		if (testNet3.getNetNodes() == null) {
			success = TestDriver.displayError(testNum, "public Set<Net> getNetNodes()", "nets should not be null after addition");
		}
		else if (testNet3.getNetNodes().isEmpty()) {
			success = TestDriver.displayError(testNum, "public Set<Net> getNetNodes()", "nets should not be null");
		}
		else if (testNet3.getNetNodes().size() != 2) {
			success = TestDriver.displayError(testNum, "public Set<Net> getNetNodes()", "size incorrect", "2", testNet3.getNetNodes().size() + "");
		}
		else if (!testNet3.getNetNodes().contains(testNet3a)) {
			success = TestDriver.displayError(testNum, "public Set<Net> getNetNodes()", "nets don't contain testNet3a");
		}
		else if (!testNet3.getNetNodes().contains(testNet3b)) {
			success = TestDriver.displayError(testNum, "public Set<Net> getNetNodes()", "nets don't contain testNet3b");
		}

		/**
		 * Test 7
		 * 	public boolean hasNets();
		 */
		testNum++;
		if (testNet3.hasNets() == false) {
			success = TestDriver.displayError(testNum, "public boolean hasNets()", "nets are not empty");
		}
		Net testNet4 = new Net(null);
		if (testNet4.hasNets() == true) {
			success = TestDriver.displayError(testNum, "public boolean hasNets()", "nets are empty upon initialization");
		}
		
		/**
		 * Test 8
		 * 	public void removeNet(Net n);
		 */
		testNum++;
		testNet3.removeNet(testNet3a);
		if (testNet3.getNetNodes().isEmpty()) {
			success = TestDriver.displayError(testNum, "public void removeNet(Net n)", "after removing 1 of 2 nets, the set became empty");
		}
		else if (testNet3.getNetNodes().size() != 1) {
			success = TestDriver.displayError(testNum, "public void removeNet(Net n)", "size incorrect", "1", testNet3.getNetNodes().size() + "");
		}
		else if (!testNet3.getNetNodes().contains(testNet3b)) {
			success = TestDriver.displayError(testNum, "public void removeNet(Net n)", "doesn't contain testNet3b when testNet3a was removed");
		}
		else if (testNet3.getNetNodes().contains(testNet3a)) {
			success = TestDriver.displayError(testNum, "public void removeNet(Net n)", "contains testNet3a when testNet3a was removed");
		}
		
		testNet3.removeNet(testNet3b);
		if (!testNet3.getNetNodes().isEmpty()) {
			success = TestDriver.displayError(testNum, "public void removeNet(Net n)", "after removing 1 of 2 nets, the set became empty");
		}
		
		/**
		 * Test 9
		 * 	public boolean addNet(Net n);
		 */
		testNum++;
		if (testNet3.addNet(testNet3a) == false) {
			success = TestDriver.displayError(testNum, "public boolean addNet(Net n)", "adding a unique net should return true");
		}
		if (testNet3.getNetNodes().isEmpty()) {
			success = TestDriver.displayError(testNum, "public boolean addNet(Net n)", "after adding a net, the set was empty");
		}
		else if (testNet3.getNetNodes().size() != 1) {
			success = TestDriver.displayError(testNum, "public boolean addNet(Net n)", "incorrect size", "1", testNet3.getNetNodes().size() + "");
		}
		else if (!testNet3.getNetNodes().contains(testNet3a)) {
			success = TestDriver.displayError(testNum, "public boolean addNet(Net n)", "nets didn't contain testNet3a");
		}
		
		if (testNet3.addNet(testNet3a) == true) {
			success = TestDriver.displayError(testNum, "public boolean addNet(Net n)", "adding a duplicate net should return false");
		}
		
		if (testNet3.addNet(testNet3b) == false) {
			success = TestDriver.displayError(testNum, "public boolean addNet(Net n)", "adding another unique net should return true");
		}
		if (testNet3.getNetNodes().size() != 2) {
			success = TestDriver.displayError(testNum, "public boolean addNet(Net n)", "incorrect size", "2", testNet3.getNetNodes().size() + "");
		}
		else if (!testNet3.getNetNodes().contains(testNet3a)) {
			success = TestDriver.displayError(testNum, "public boolean addNet(Net n)", "nets didn't contain testNet3a after adding another net");
		}
		else if (!testNet3.getNetNodes().contains(testNet3b)) {
			success = TestDriver.displayError(testNum, "public boolean addNet(Net n)", "nets didn't contain testNet3b");
		}
		
		
		/**
		 * Test 10
		 * 	 public NodeType getNodeType();
		 */
		testNum++;
		if (testNet3.getNodeType() != NodeType.NET) {
			success = TestDriver.displayError(testNum, "public NodeType getNodeType()", "incorrect node type", NodeType.NET.toString(), testNet3.getNodeType().toString());
		}
		
		/**
		 * Test 11
		 * 	public Design getDesign();
		 */
		testNum++;
		if (testNet3.getDesign() != null) {
			success = TestDriver.displayError(testNum, "public Design getDesign()", "wrong design parent, null case", "null", testNet3.getDesign().toString());
		}
		Design parentDesign3 = new Design();
		parentDesign3.name = "parent_design_3";
		testNet3.design = parentDesign3;
		if (testNet3.getDesign() == null) {
			success = TestDriver.displayError(testNum, "public Design getDesign()", "shouldn't return null");
		}
		else if (!testNet3.getDesign().equals(parentDesign3)) {
			success = TestDriver.displayError(testNum, "public Design getDesign()", "wrong design parent", parentDesign3.toString(), testNet3.getDesign().toString());
		}
		
		return success;
	}
	
}
