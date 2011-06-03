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

import java.util.HashSet;

/**
 * A class that models a device instance on a PCB.
 * 
 * A device instance that contains an instance name, the name of the device it
 * is modeled after
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 * 
 */
public class PHDLInstance {
	/**
	 * Name of the device instance
	 */
	private String instName;
	/**
	 * Device the instance is based off of
	 */
	private PHDLDevice device;
	/**
	 * The device instance's attributes
	 */
	private HashSet<PHDLAttribute> attributes;
	/**
	 * The device instance netlist
	 */
	private PHDLNetList netlist;

	/**
	 * Default Constructor.
	 * 
	 * Initializes attribute set and netlist, sets instance name, and device
	 * 
	 * @param instName
	 *            the name of the device instance
	 * @param device
	 *            the device the instances is based on
	 */
	public PHDLInstance(String instName, PHDLDevice device) {
		this.instName = instName;
		this.device = device;
		if (this.device != null) {
			attributes = device.getAttributes();
		} else {
			attributes = new HashSet<PHDLAttribute>();
		}
		netlist = new PHDLNetList();
	}

	/**
	 * Returns the name of the device instance.
	 * 
	 * Device instance name accessor method
	 * 
	 * @return the name of the device instance
	 */
	public String getInstName() {
		return instName;
	}

	/**
	 * Changes the name of the device instance.
	 * 
	 * Device instance name mutator method
	 * 
	 * @param instName
	 *            the new device instance name
	 */
	public void setInstName(String instName) {
		this.instName = instName;
	}

	/**
	 * Configures the instance to be based on a device definition.
	 * 
	 * @param device
	 *            the device to model the instance after
	 */
	public void configure(PHDLDevice device) {
		this.device = device;
		attributes = device.getAttributes();
		netlist = new PHDLNetList();
	}

	/**
	 * Checks to see if there is a device the instance is based on.
	 * 
	 * If the device reference is null, then it is not configured
	 * 
	 * @return true if there is a device the instance is based on, false if the
	 *         device is null.
	 */
	public boolean isConfigured() {
		if (device == null) {
			return false;
		}
		return true;
	}

	/**
	 * Checks to see if all pins are assigned to a net if necessary.
	 * 
	 * @return true if the netlist has all the necessary pins false otherwise
	 */
	// public boolean netListComplete() {
	// HashSet<PHDLPinVector> fullSet = new HashSet<PHDLPinVector>();
	// Collection<HashSet<PHDLPinVector>> col = netlist.values();
	// for (HashSet<PHDLPinVector> s : col) {
	// fullSet.addAll(s);
	// }
	// for (PHDLPinVector p : device.getPins()) {
	// if (!fullSet.contains(p) && p.getType() != PHDLPinType.OPEN) {
	// return false;
	// }
	// }
	// return true;
	// }

	/**
	 * Returns the name of the device being used as a template.
	 * 
	 * Device name accessor method
	 * 
	 * @return the name of the device being used
	 */
	public String getDeviceName() {
		return device.getName();
	}

	/**
	 * Changes the name of the device being used.
	 * 
	 * Device name mutator method
	 * 
	 * @param deviceName
	 *            the name of the device being used
	 */
	public void setDeviceName(String deviceName) {
		device.setName(deviceName);
	}

	/**
	 * Checks to see if there is a "refPrefix" attribute.
	 * 
	 * Iterates through the attribute set until an attribute with the name
	 * "refPrefix" is found
	 * 
	 * @return true if "refPrefix" is an attribute, false otherwise
	 */
	public boolean hasRefPrefix() {
		for (PHDLAttribute a : attributes) {
			if (a.getName().equals("refPrefix") && a.getValue() != "") {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the value for the "refPrefix" attribute.
	 * 
	 * @return the value for the "refPrefix" attribute, null when it isn't found
	 */
	public String getRefPrefix() {
		if (!hasRefPrefix()) {
			return null;
		}
		for (PHDLAttribute a : attributes) {
			if (a.getName().equals("refPrefix")) {
				return a.getValue();
			}
		}
		return null;
	}

	/**
	 * Checks to see if there is a "refDes" attribute.
	 * 
	 * @return true if there is a "refDes" attribute false otherwise
	 */
	public boolean hasRefDes() {
		for (PHDLAttribute a : attributes) {
			if (a.getName().equals("refDes") && a.getValue() != "") {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the value of the "refDes" attribute.
	 * 
	 * @return the value of the "refDes" attribute if it exists, null otherwise
	 */
	public String getRefDes() {
		if (!hasRefDes()) {
			return null;
		}
		for (PHDLAttribute a : attributes) {
			if (a.getName().equals("refDes")) {
				return a.getValue();
			}
		}
		return null;
	}

	/**
	 * Returns the device instance attributes.
	 * 
	 * Device instance attributes accessor method
	 * 
	 * @return a HashSet of PHDLAttributes
	 */
	public HashSet<PHDLAttribute> getAttributes() {
		return attributes;
	}

	/**
	 * Adds a new attribute.
	 * 
	 * Device instance attributes addition method
	 * 
	 * @param a
	 *            the new PHDLAttribute
	 */
	public void addAttribute(PHDLAttribute a) {
		attributes.add(a);
	}

	/**
	 * Changes an attribute's value.
	 * 
	 * Attribute value mutator method
	 * 
	 * @param name
	 *            the name of the attribute to be modified
	 * @param value
	 *            the new value of the attribute
	 * @return true if the attribute was changed, false if the attribute doesn't
	 *         exist
	 */
	public boolean changeAttribute(String name, String value) {
		for (PHDLAttribute a : attributes) {
			if (a.getName().equals(name)) {
				a.setValue(value);
				return true;
			}
		}
		return false;
	}

	/**
	 * Changes an attribute's value.
	 * 
	 * Attribute value mutator method
	 * 
	 * @param attr
	 *            the PHDLAttribute that will be modified
	 * @param value
	 *            the new value of the attribute
	 * @return true if the attribute was changed, false if the attribute doesn't
	 *         exist
	 */
	public boolean changeAttribute(PHDLAttribute attr, String value) {
		return changeAttribute(attr.getName(), value);
	}

	/**
	 * Returns a reference to the device.
	 * 
	 * Device accessor method
	 * 
	 * @return the device being used as a mold
	 * 
	 */
	public PHDLDevice getDevice() {
		return this.device;
	}

	/**
	 * Returns the device pins.
	 * 
	 * Device pins accessor method
	 * 
	 * @return a HashSet of PHDLPins
	 */
	public HashSet<PHDLPinVector> getDevicePins() {
		return device.getPins();
	}

	/**
	 * Adds a new pin to the device.
	 * 
	 * Device pin addition method
	 * 
	 * @param p
	 *            the new PHDLPin
	 */
	public void addDevicePin(PHDLPinVector p) {
		device.addPinVector(p);
	}

	/**
	 * Adds a new pin to the device netlist.
	 * 
	 * Device netlist addition method
	 * 
	 * @param net
	 *            the net to add the pin to
	 * @param pin
	 *            the pin to add
	 * @return true if the add was successful false if it was already there
	 */
	public boolean addPin(PHDLNet net, PHDLPinVector pin) {
		return netlist.addPin(net, pin);
	}

	/**
	 * Return the netlist for the device.
	 * 
	 * Device netlist accessor method
	 * 
	 * @return a PHDLNetlist
	 */
	public PHDLNetList getNetList() {
		return netlist;
	}

	/**
	 * Creates a hash code for use in hash data structures.
	 * 
	 * hashCode method to make attributes compatible with hashMaps and hashSets
	 * 
	 * @return an integer representing a hash code
	 */
	public int hashCode() {
		return instName.hashCode();
	}

	public boolean equals(Object o) {
		PHDLInstance i = (PHDLInstance) o;
		return this.instName.equals(i.getInstName());
	}

	public String toString() {
		String ret = instName + " : " + device.getName() + "\n"
				+ netlist.toString();
		return ret;
	}

	// public static boolean unitTest() {
	// /*
	// * Methods Tested
	// *********************
	// * getInstName X
	// * setInstName X
	// * isConfigured X
	// * configure X
	// * getDeviceName X
	// * setDeviceName X
	// * getAttributes X
	// * addAttribute X
	// * changeAttribute(1) X
	// * changeAttribute(2) X
	// * getDevicePins X
	// * addDevicePin X
	// * addPin X
	// * getNetList X
	// * netListComplete X
	// */
	// boolean success = true;
	//
	// PHDLInstance inst1 = new PHDLInstance("inst1", null);
	// if (!inst1.getInstName().equals("inst1")) {
	// success = false;
	// TestDriver.err("getInstName()", "inst1", inst1.getInstName());
	// }
	// inst1.setInstName("rename");
	// if (!inst1.getInstName().equals("rename")) {
	// success = false;
	// TestDriver.err("setInstName()", "rename", inst1.getInstName());
	// }
	//
	// if (inst1.isConfigured()) {
	// success = false;
	// TestDriver.err("isConfigured()", "shouldn't be configured",
	// "is configured");
	// }
	// PHDLInstance inst2 = new PHDLInstance("inst2", new PHDLDevice("dev1"));
	// if (!inst2.isConfigured()) {
	// success = false;
	// TestDriver.err("isConfigured()", "should be configured",
	// "isn't configured");
	// }
	//
	// inst1.configure(new PHDLDevice("dev2"));
	// if (!inst1.isConfigured()) {
	// success = false;
	// TestDriver.err("configure()", "should be configured",
	// "isn't configured");
	// }
	// if (!inst1.attributes.isEmpty()) {
	// success = false;
	// TestDriver.err("configure()", "configured without attributes",
	// "otherwise");
	// }
	//
	// PHDLDevice dev3 = new PHDLDevice("dev3");
	// dev3.addAttribute(new PHDLAttribute("attr1", "val1"));
	// dev3.addAttribute(new PHDLAttribute("attr2", "val2"));
	// inst2.configure(dev3);
	// if (!inst2.isConfigured()) {
	// success = false;
	// TestDriver.err("configure()", "configured with attributes",
	// "not configured");
	// }
	// if (inst2.attributes.size() != 2) {
	// success = false;
	// TestDriver.err("configure()", "configured with 2 attributes", "has size "
	// + inst1.getAttributes().size());
	// }
	// if (!inst2.netlist.isEmpty()) {
	// success = false;
	// TestDriver.err("configure()", "configured -> empty netlist",
	// "non-empty netlist");
	// }
	// if (!inst2.device.equals(dev3)) {
	// success = false;
	// TestDriver.err("configure()", "configured with device \"dev3\"",
	// "not \"dev3\"");
	// }
	//
	// if (!inst2.getDeviceName().equals("dev3")) {
	// success = false;
	// TestDriver.err("getDeviceName()", "dev3", inst2.getDeviceName());
	// }
	//
	// inst2.setDeviceName("rename");
	// if (!inst2.getDeviceName().equals("rename")) {
	// success = false;
	// TestDriver.err("setDeviceName()", "rename", inst2.getDeviceName());
	// }
	// if (!inst2.device.getName().equals("rename")) {
	// success = false;
	// TestDriver.err("setDeviceName()", "rename", inst2.device.getName());
	// }
	//
	// HashSet<PHDLAttribute> attrs = inst2.getAttributes();
	// if (attrs.size() != 2) {
	// success = false;
	// TestDriver.err("getAttributes()", "size of 2", "size of " +
	// attrs.size());
	// }
	//
	// inst1.addAttribute(new PHDLAttribute("attr3", "val3"));
	// inst1.addAttribute(new PHDLAttribute("attr4", "val4"));
	// attrs = inst1.getAttributes();
	// if (attrs.size() != 2) {
	// success = false;
	// TestDriver.err("addAttribute()", "size of 2", "size of " + attrs.size());
	// }
	// if (!attrs.contains(new PHDLAttribute("attr3", "val3"))) {
	// success = false;
	// TestDriver.err("addAttribute()", "contains \"attr3\"", "doesn't");
	// }
	// if (!attrs.contains(new PHDLAttribute("attr4", "val4"))) {
	// success = false;
	// TestDriver.err("addAttribute()", "contains \"attr4\"", "doesn't");
	// }
	//
	// inst1.changeAttribute("attr3", "newval3");
	// if (!inst1.getAttributes().contains(new
	// PHDLAttribute("attr3","newval3"))) {
	// success = false;
	// TestDriver.err("changeAttribute(1)", "contains modified \"attr3\"",
	// "doesn't");
	// }
	//
	// inst1.changeAttribute(new PHDLAttribute("attr4", "val4"), "newval4");
	// if (!inst1.getAttributes().contains(new
	// PHDLAttribute("attr4","newval4"))) {
	// success = false;
	// TestDriver.err("changeAttribute(2)", "contains modified \"attr4\"",
	// "doesn't");
	// }
	//
	// dev3.addPin(new PHDLPinVector("pin1", 1));
	// dev3.addPin(new PHDLPinVector("pin2", 2));
	// dev3.addPin(new PHDLPinVector("pin3", 3));
	// PHDLInstance inst4 = new PHDLInstance("inst4", dev3);
	// HashSet<PHDLPinVector> pins = inst4.getDevicePins();
	// if (pins.size() != 3) {
	// success = false;
	// TestDriver.err("getDevicePins()", "size of 3", "size of " + pins.size());
	// }
	// if (!pins.contains(new PHDLPinVector("pin1", 1))) {
	// success = false;
	// TestDriver.err("getDevicePins()", "contains \"pin1\"", "does not");
	// }
	// if (!pins.contains(new PHDLPinVector("pin2", 2))) {
	// success = false;
	// TestDriver.err("getDevicePins()", "contains \"pin2\"", "does not");
	// }
	// if (!pins.contains(new PHDLPinVector("pin3", 3))) {
	// success = false;
	// TestDriver.err("getDevicePins()", "contains \"pin3\"", "does not");
	// }
	//
	// inst4.addDevicePin(new PHDLPinVector("pin4", 4));
	// pins = inst4.getDevicePins();
	// if (pins.size() != 4) {
	// success = false;
	// TestDriver.err("addDevicePin()", "size of 4", "size of " + pins.size());
	// }
	// if (!pins.contains(new PHDLPinVector("pin4", 4))) {
	// success = false;
	// TestDriver.err("addDevicePin()", "contains \"pin4\"", "does not");
	// }
	//
	// for (PHDLPinVector p : pins) {
	// inst4.addPin(new PHDLNet("net1"), p);
	// }
	// PHDLNetList netlist = inst4.netlist;
	// for (PHDLPinVector p : pins) {
	// if (!netlist.containsPin(p)) {
	// success = false;
	// TestDriver.err("addPin()", "to contain " + p.toString(), "did not");
	// }
	// }
	//
	//
	// if (!netlist.equals(inst4.getNetList())) {
	// success = false;
	// TestDriver.err("getNetList()", "equal netlists", "non-equal");
	// }
	// inst4.addPin(new PHDLNet("net2"), new PHDLPinVector("pin5", 5));
	// if (!netlist.equals(inst4.getNetList())) {
	// success = false;
	// TestDriver.err("getNetList()", "equal netlists", "non-equal");
	// }
	//
	//
	// PHDLDevice dev5 = new PHDLDevice("dev5");
	// dev5.addPin(new PHDLPinVector("pin51", 1));
	// dev5.addPin(new PHDLPinVector("pin52", 2));
	// dev5.addPin(new PHDLPinVector("pin53", 3));
	// dev5.addPin(new PHDLPinVector("pin54", 4));
	//
	// PHDLInstance inst5 = new PHDLInstance("inst5", dev5);
	// PHDLNet net5 = new PHDLNet("net5");
	// inst5.addPin(net5, new PHDLPinVector("pin51", 1));
	// inst5.addPin(net5, new PHDLPinVector("pin52", 2));
	// inst5.addPin(net5, new PHDLPinVector("pin53", 3));
	//
	// if (inst5.netListComplete()) {
	// success = false;
	// TestDriver.err("netListComplete()", "doesn't have \"pin54\"",
	// "says netlist is complete");
	// }
	// inst5.addPin(net5, new PHDLPinVector("pin54", 4));
	// if (!inst5.netListComplete()) {
	// success = false;
	// TestDriver.err("netListComplete()", "is a complete netlist",
	// "says netlist is incomplete");
	// }
	//
	// return success;
	// }

}
