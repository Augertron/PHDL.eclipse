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

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * A class that represents a netlist.
 * 
 * Extends a HashSet to simplify the use of the data structure
 * 
 * @author Richard Black and Brad Riching
 * 
 */

@SuppressWarnings("serial")
public class PHDLNetList extends HashMap<PHDLNet, HashSet<PHDLPin>> {

	/**
	 * Puts all the pins in another netlist into this netlist.
	 * 
	 * Netlist mass pin addition method
	 * 
	 * @param nl
	 *            a PHDLNetList
	 */
	public void addAllPins(PHDLNetList nl) {
		Set<PHDLNet> netSet = nl.keySet();
		for (PHDLNet a : netSet) {
			if (this.containsKey(a)) {
				this.get(a).addAll(nl.get(a));
			} else {
				this.put(a, new HashSet<PHDLPin>());
				this.get(a).addAll(nl.get(a));
			}
		}
	}

	/**
	 * Adds a pin to the netlist.
	 * 
	 * Netlist addition method
	 * 
	 * @param net
	 *            the net associated with the pin
	 * @param pin
	 *            the pin to be added
	 */
	public boolean addPin(PHDLNet net, PHDLPin pin) {
		if (this.containsKey(net)) {
			return this.get(net).add(pin);
		} else {
			this.put(net, new HashSet<PHDLPin>());
			return this.get(net).add(pin);
		}
	}

	/**
	 * Returns a set of pins associated with a specific net.
	 * 
	 * Netlist pins accessor method
	 * 
	 * @param net
	 *            the net associated with the pins
	 * @return a HashSet of PHDLPins
	 */
	public HashSet<PHDLPin> getPins(PHDLNet net) {
		return this.get(net);
	}

	/**
	 * Removes a pin from the netlist.
	 * 
	 * Netlist pin removal method
	 * 
	 * @param net
	 *            the net associated with the pin
	 * @param pin
	 *            the pin to be removed
	 * @return true if the pin was removed false, otherwise
	 */
	public boolean removePin(PHDLNet net, PHDLPin pin) {
		HashSet<PHDLPin> pinSet = this.get(net);
		if (pinSet != null) {
			return pinSet.remove(pin);
		}
		return false;
	}

	/**
	 * Removes a net from the netlist.
	 * 
	 * Netlist net removal method
	 * 
	 * @param net
	 *            the net to remove from the netlist
	 * @return true if the net was in the netlist false, otherwise
	 */
	public boolean removeNet(PHDLNet net) {
		return (this.remove(net) != null);
	}

	/**
	 * Checks to see if a particular pin is in the netlist.
	 * 
	 * Netlist pin verification method
	 * 
	 * @param pin
	 *            the pin to check
	 * @return true if the pin is in the netlist false, otherwise
	 */
	public boolean containsPin(PHDLPin pin) {
		Collection<HashSet<PHDLPin>> pinSets = this.values();
		for (HashSet<PHDLPin> s : pinSets) {
			if (s.contains(pin)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks to see if a particular net is in the netlist.
	 * 
	 * Netlist net verification method
	 * 
	 * @param net
	 *            the net to check
	 * @return true if the net is in the netlist false, otherwise
	 */
	public boolean containsNet(PHDLNet net) {
		return this.containsKey(net);
	}

	/**
	 * Checks to see if a particular net doesn't have pins.
	 * 
	 * Netlist net emptiness verification method
	 * 
	 * @param net
	 *            the net to check
	 * @return true if the net has pins false if the net doesn't have pins false
	 *         if the net isn't in the netlist
	 */
	public boolean isNetEmpty(PHDLNet net) {
		HashSet<PHDLPin> pinSet = this.get(net);
		if (pinSet != null) {
			return pinSet.isEmpty();
		}
		return false;
	}

	/**
	 * Returns the number of pins associated with a net.
	 * 
	 * @param net
	 *            the net to be checked
	 * @return the number of pins associated with a net -1 if the net doesn't
	 *         exist
	 */
	public int getNumberPins(PHDLNet net) {
		if (this.get(net) != null)
			return this.get(net).size();
		return -1;
	}

	/**
	 * Returns the number of nets in the netlist.
	 * 
	 * @return the number of nets
	 */
	public int getNumberNets() {
		return this.keySet().size();
	}

	public boolean usesValidNets(HashSet<PHDLNet> nets) {
		Set<PHDLNet> netSet = this.keySet();
		for (PHDLNet n : netSet) {
			if (!nets.contains(n)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean equals(Object o) {
		PHDLNetList nl = (PHDLNetList) o;
		Set<PHDLNet> set1 = nl.keySet();
		Set<PHDLNet> set2 = keySet();
		for (PHDLNet n : set1) {
			if (!set2.contains(n)) {
				return false;
			}
		}
		for (PHDLNet n : set2) {
			if (!set1.contains(n)) {
				return false;
			}
		}
		for (PHDLNet n : set1) {
			if (!this.get(n).equals(nl.get(n))) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		String ret = "";
		for (PHDLNet n : this.keySet()) {
			HashSet<PHDLPin> pins = this.getPins(n);
			for (PHDLPin p : pins) {
				ret += p.toString() + "\n";
			}
		}
		return ret;
	}

	public static boolean unitTest() {
		/*
		 * Methods Tested******************** addAllPins X addPin X getPins X
		 * removePin X removeNet X containsPin X containsNet X getNumberPins X
		 * getNumberNets X isNetEmpty X usesValidNets X equals X
		 */
		boolean success = true;

		PHDLNetList netlist = new PHDLNetList();
		if (!netlist.isEmpty()) {
			success = false;
			TestDriver.err("isEmpty()", "True", "False");
		}
		PHDLNet net1 = new PHDLNet("net1");
		netlist.put(net1, new HashSet<PHDLPin>());
		if (netlist.isEmpty()) {
			success = false;
			TestDriver.err("isEmpty()", "False", "True");
		}

		if (!netlist.isNetEmpty(net1)) {
			success = false;
			TestDriver.err("isNetEmpty()", "True", "False");
		}
		netlist.get(net1).add(new PHDLPin("net1pin1", 1));

		if (netlist.getNumberPins(net1) != 1) {
			success = false;
			TestDriver.err("getNumberNets()", "1",
					"" + netlist.getNumberPins(net1));
		}

		if (netlist.isNetEmpty(net1)) {
			success = false;
			TestDriver.err("isNetEmpty()", "False", "True");
		}
		netlist.get(net1).add(new PHDLPin("net1pin2", 2));

		if (!netlist.containsNet(net1)) {
			success = false;
			TestDriver.err("containsNet()", "to have \"net1\"",
					"did not have it");
		}

		if (!netlist.containsPin(new PHDLPin("net1pin1", 1))) {
			success = false;
			TestDriver.err("containsPin()", "to have \"net1pin1\"",
					"did not have it");
		}
		if (!netlist.containsPin(new PHDLPin("net1pin2", 2))) {
			success = false;
			TestDriver.err("containsPin()", "to have \"net1pin2\"",
					"did not have it");
		}

		if (netlist.getNumberNets() != 1) {
			success = false;
			TestDriver
					.err("getNumberNets()", "1", "" + netlist.getNumberNets());
		}

		if (netlist.getNumberPins(net1) != 2) {
			success = false;
			TestDriver.err("getNumberNets()", "2",
					"" + netlist.getNumberPins(net1));
		}

		HashSet<PHDLPin> myPins = netlist.getPins(net1);
		if (myPins == null) {
			success = false;
			TestDriver.err("getPins()", "a non-null HashSet", "null");
		}
		if (myPins.isEmpty()) {
			success = false;
			TestDriver.err("getPins()", "a non-empty HashSet",
					"an empty HashSet");
		}
		if (!myPins.contains(new PHDLPin("net1pin1", 1))) {
			success = false;
			TestDriver.err("getPins()", "to have \"net1pin1\"",
					" didn't have it");
		}
		if (!myPins.contains(new PHDLPin("net1pin2", 2))) {
			success = false;
			TestDriver.err("getPins()", "to have \"net1pin2\"",
					" didn't have it");
		}
		if (myPins.size() != 2) {
			success = false;
			TestDriver.err("getPins()", "to have only 2 elements", "has "
					+ myPins.size() + " elements");
		}

		PHDLNetList newNetList = new PHDLNetList();
		PHDLNet net2 = new PHDLNet("net2");
		PHDLPin pin21 = new PHDLPin("pin21", 1);
		PHDLPin pin22 = new PHDLPin("pin22", 2);
		newNetList.addPin(net2, pin21);
		if (newNetList.isEmpty()) {
			success = false;
			TestDriver.err("addPin()", "to be non-empty", "was empty");
		}
		if (!newNetList.containsNet(net2)) {
			success = false;
			TestDriver.err("addPin()", "\"net2\" wasn't found", "to be found");
		}
		if (!newNetList.containsPin(pin21)) {
			success = false;
			TestDriver.err("addPin()", "\"pin21\" wasn't found", "to be found");
		}
		if (newNetList.isNetEmpty(net2)) {
			success = false;
			TestDriver.err("addPin()", "to be non-empty", "was empty");
		}
		if (newNetList.getNumberNets() != 1) {
			success = false;
			TestDriver.err("addPin()", "number of nets to be 1", "was"
					+ newNetList.getNumberNets());
		}
		if (newNetList.getNumberPins(net2) != 1) {
			success = false;
			TestDriver.err("addPin()", "number of pins for \"net2\" to be 1",
					"was" + newNetList.getNumberPins(net2));
		}

		newNetList.addPin(net2, pin22);
		if (!newNetList.containsPin(pin22)) {
			success = false;
			TestDriver.err("addPin()", "\"pin22\" wasn't found", "to be found");
		}
		if (newNetList.getNumberNets() != 1) {
			success = false;
			TestDriver.err("addPin()",
					"number of nets to be 1 after second addition", "was"
							+ newNetList.getNumberNets());
		}
		if (newNetList.getNumberPins(net2) != 2) {
			success = false;
			TestDriver.err("addPin()", "number of pins for \"net2\" to be 2",
					"was" + newNetList.getNumberPins(net2));
		}

		newNetList.removePin(net2, pin21);
		if (newNetList.containsPin(pin21)) {
			success = false;
			TestDriver.err("removePin()", "\"pin21\" should have been removed",
					"it wasn't");
		}
		if (newNetList.getNumberPins(net2) != 1) {
			success = false;
			TestDriver.err("removePin()", "should have 1 pin", "had "
					+ newNetList.getNumberPins(net2));
		}
		if (newNetList.isNetEmpty(net2)) {
			success = false;
			TestDriver.err("removePin()", "should not be an empty net",
					"empty net");
		}

		newNetList.removePin(net2, pin22);
		if (newNetList.containsPin(pin22)) {
			success = false;
			TestDriver.err("removePin()", "\"pin22\" should have been removed",
					"it wasn't");
		}
		if (newNetList.getNumberPins(net2) != 0) {
			success = false;
			TestDriver.err("removePin()", "should have 0 pins", "had "
					+ newNetList.getNumberPins(net2));
		}
		if (!newNetList.isNetEmpty(net2)) {
			success = false;
			TestDriver.err("removePin()", "should have an empty net",
					"non-empty");
		}

		newNetList.addPin(net2, pin21);
		newNetList.addPin(net2, pin22);
		newNetList.removeNet(net2);
		if (newNetList.containsNet(net2)) {
			success = false;
			TestDriver.err("removeNet()", "\"net2\" should not be present",
					"it still is");
		}
		if (newNetList.containsPin(pin21) || newNetList.containsPin(pin22)) {
			success = false;
			TestDriver
					.err("removeNet()", "should not contain any pins", "does");
		}
		if (newNetList.getNumberNets() != 0) {
			success = false;
			TestDriver.err("removeNet()", "should not have any nets", "does");
		}
		if (newNetList.getNumberPins(net2) != -1) {
			success = false;
			TestDriver.err("removeNet()", "should say there are -1 pins",
					"says there are " + newNetList.getNumberPins(net2));
		}
		if (!newNetList.isEmpty()) {
			success = false;
			TestDriver.err("removeNet()", "should be empty", "non-empty");
		}

		netlist.clear();
		PHDLNet net3 = new PHDLNet("net3");
		netlist.addPin(net2, pin21);
		netlist.addPin(net3, new PHDLPin("net3pin5", 5));

		newNetList.addPin(net2, pin21);
		newNetList.addPin(net2, pin22);
		newNetList.addPin(net1, new PHDLPin("net1pin2", 2));
		newNetList.addPin(net1, new PHDLPin("net1pin3", 3));

		newNetList.addAllPins(netlist);
		if (!newNetList.containsNet(net1)) {
			success = false;
			TestDriver
					.err("addAllPins()", "should contain \"net1\"", "doesn't");
		}
		if (!newNetList.containsNet(net2)) {
			success = false;
			TestDriver
					.err("addAllPins()", "should contain \"net2\"", "doesn't");
		}
		if (!newNetList.containsNet(net3)) {
			success = false;
			TestDriver
					.err("addAllPins()", "should contain \"net3\"", "doesn't");
		}
		if (newNetList.getNumberNets() != 3) {
			success = false;
			TestDriver.err("addAllPins()", "should have 3 nets", "has "
					+ newNetList.getNumberNets());
		}

		if (!newNetList.containsPin(new PHDLPin("net1pin2", 2))) {
			success = false;
			TestDriver.err("addAllPins()", "should have \"pin12\"", "doesn't");
		}
		if (!newNetList.containsPin(new PHDLPin("net1pin3", 3))) {
			success = false;
			TestDriver.err("addAllPins()", "should have \"pin13\"", "doesn't");
		}
		if (!newNetList.containsPin(new PHDLPin("net3pin5", 5))) {
			success = false;
			TestDriver.err("addAllPins()", "should have \"pin35\"", "doesn't");
		}
		if (!newNetList.containsPin(pin21)) {
			success = false;
			TestDriver.err("addAllPins()", "should have \"pin21\"", "doesn't");
		}
		if (!newNetList.containsPin(pin22)) {
			success = false;
			TestDriver.err("addAllPins()", "should have \"pin22\"", "doesn't");
		}
		if (newNetList.getNumberPins(net1) != 2) {
			success = false;
			TestDriver.err("addAllPins()", "should have 2 pins in \"net1\"",
					"has " + newNetList.getNumberPins(net1));
		}
		if (newNetList.getNumberPins(net2) != 2) {
			success = false;
			TestDriver.err("addAllPins()", "should have 2 pins in \"net2\"",
					"has " + newNetList.getNumberPins(net2));
		}
		if (newNetList.getNumberPins(net3) != 1) {
			success = false;
			TestDriver.err("addAllPins()", "should have 1 pins in \"net3\"",
					"has " + newNetList.getNumberPins(net3));
		}

		HashSet<PHDLNet> validNets = new HashSet<PHDLNet>();
		validNets.add(net1);
		validNets.add(net2);
		if (newNetList.usesValidNets(validNets)) {
			success = false;
			TestDriver.err("usesValidNets()", "is using invalid net \"net3\"",
					"apparently it is");
		}
		validNets.add(net3);
		if (!newNetList.usesValidNets(validNets)) {
			success = false;
			TestDriver
					.err("usesValidNets()",
							"is using only valid nets \"net1,\" \"net2,\" and \"net3\"",
							"apparently it has more");
		}
		validNets.add(new PHDLNet("net4"));
		if (!newNetList.usesValidNets(validNets)) {
			success = false;
			TestDriver
					.err("usesValidNets()",
							"is using only valid nets \"net1,\" \"net2,\" and \"net3.\"",
							"an additional net in the set of valid nets is causing the problem");
		}

		PHDLNetList nl1 = new PHDLNetList();
		PHDLNetList nl2 = new PHDLNetList();
		nl1.addPin(net2, pin21);
		if (nl1.equals(nl2)) {
			success = false;
			TestDriver.err("equals()", "nl2 doesn't have net2, pin21",
					"claims that they are equal");
		}
		nl2.addPin(net2, pin21);
		if (!nl1.equals(nl2)) {
			success = false;
			TestDriver.err("equals()", "same netlists",
					"claims that they are not equal");
		}
		nl2.addPin(net1, pin22);
		if (nl1.equals(nl2)) {
			success = false;
			TestDriver.err("equals()", "nl1 doesn't have net1, pin22",
					"claims that they are equal");
		}

		return success;
	}

}
