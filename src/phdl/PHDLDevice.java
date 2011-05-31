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
 * A class that represents a device definition on a PCB.
 * 
 * Stores a name, a set of attributes, and a set of pins
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 */

public class PHDLDevice {
	/**
	 * the name of the device
	 */
	private String name;
	/**
	 * the set of attributes
	 * @see PHDLAttribute
	 */
	private HashSet<PHDLAttribute> attributes;
	/**
	 * the set of pins
	 * @see PHDLPin
	 */
	private HashSet<PHDLPin> pins;

	/**
	 * Default Constructor.
	 * 
	 * Sets the name, creates an empty attribute set
	 * and creates an empty pin set
	 * 
	 * @param name the name of the device
	 */
	public PHDLDevice(String name) {
		this.name = name;
		attributes = new HashSet<PHDLAttribute>();
		pins = new HashSet<PHDLPin>();
	}
	
	/**
	 * Checks to see if there is a "refPrefix" attribute.
	 * 
	 * Iterates through the attribute set until an attribute
	 * with the name "refPrefix" is found
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
	 * @return 	the value for the "refPrefix" attribute,
	 * 			null when it isn't found
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
	 * @return 	true if there is a "refDes" attribute
	 * 			false otherwise
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
	 * @return	the value of the "refDes" attribute if it exists,
	 * 			null otherwise
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
	 * Returns the name of the device.
	 * 
	 * Device name accessor method
	 * 
	 * @return the name of the device
	 */
	public String getName() {
		return name;
	}

	/**
	 * Changes the name of the device.
	 * 
	 * Device name mutator method
	 * 
	 * @param name the new name of the device
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the attributes of the device.
	 * 
	 * Device attributes accessor method
	 * 
	 * @return a HashSet of PHDLAttributes
	 */
	public HashSet<PHDLAttribute> getAttributes() {
		return attributes;
	}

	/**
	 * Adds an attribute to the device.
	 * 
	 * Device attribute addition method
	 * 
	 * @param a the new PHDLAttribute to add
	 */
	public void addAttribute(PHDLAttribute a) {
		attributes.add(a);
	}

	/**
	 * Returns the pins of the device.
	 * 
	 * Device pins accessor method
	 * 
	 * @return a HashSet of PHDLPins associated with the device
	 */
	public HashSet<PHDLPin> getPins() {
		return pins;
	}

	/**
	 * Adds a new pin to the device.
	 * 
	 * Device pins addition method
	 * 
	 * @param p the new PHDLPin to add
	 */
	public void addPin(PHDLPin p) {
		pins.add(p);
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
	
	@Override
	public boolean equals(Object o) {
		return name.equals(((PHDLDevice)o).getName());
	}
	
	public static boolean unitTest() {
		/* 
		 * Methods Tested
		 *********************
		 * getName			X
		 * setName			X
		 * getPins			X
		 * addPin			X
		 * getAttributes	X
		 * addAttribute		X
		 * hasRefPrefix		X
		 * getRefPrefix		X
		 * hasRefDes		X
		 * getRefDes		X
		 */
		boolean success = true;
		
		PHDLDevice dev1 = new PHDLDevice("dev1");
		if (!dev1.getName().equals("dev1")) {
			success = false;
			TestDriver.err("getName()", "dev1", dev1.getName());
		}
		
		dev1.setName("devRename");
		if (!dev1.getName().equals("devRename")) {
			success = false;
			TestDriver.err("setName()", "devRename", dev1.getName());
		}
		
		HashSet<PHDLPin> pins = dev1.getPins();
		if (!pins.isEmpty()) {
			success = false;
			TestDriver.err("getPins()", "should be empty", "is empty");
		}
		
		PHDLPin pin1 = new PHDLPin("pin1", 1);
		PHDLPin pin2 = new PHDLPin("pin2", 2);
		dev1.pins.add(pin1);
		dev1.pins.add(pin2);
		
		pins = dev1.getPins();
		if (!pins.contains(pin1)) {
			success = false;
			TestDriver.err("getPins()", "to contain \"pin1\"", "did not");
		}
		if (!pins.contains(pin2)) {
			success = false;
			TestDriver.err("getPins()", "to contain \"pin2\"", "did not");
		}
		dev1.pins.add(pin1);
		if (pins.size() != 2) {
			success = false;
			TestDriver.err("getPins()", "to contain 2 pins", "had " + pins.size());
		}
		
		PHDLPin pin3 = new PHDLPin("pin3", 3);
		PHDLPin pin4 = new PHDLPin("pin4", 4);
		PHDLDevice devP = new PHDLDevice("devP");
		
		devP.addPin(pin3);
		devP.addPin(pin4);
		pins = devP.getPins();
		
		if (!pins.contains(pin3)) {
			success = false;
			TestDriver.err("addPin()", "to contain \"pin3\"", "did not");
		}
		if (!pins.contains(pin4)) {
			success = false;
			TestDriver.err("addPin()", "to contain \"pin4\"", "did not");
		}
		devP.addPin(pin3);
		if (pins.size() != 2) {
			success = false;
			TestDriver.err("addPin()", "to contain 2 pins", "had " + pins.size());
		}
		
		
	
		HashSet<PHDLAttribute> attrs = dev1.getAttributes();
		if (!attrs.isEmpty()) {
			success = false;
			TestDriver.err("getAttributes()", "should be empty", "is empty");
		}
		
		PHDLAttribute attr1 = new PHDLAttribute("attr1", "val1");
		PHDLAttribute attr2 = new PHDLAttribute("attr2", "val2");
		dev1.attributes.add(attr1);
		dev1.attributes.add(attr2);
	
		attrs = dev1.getAttributes();
		if (!attrs.contains(attr1)) {
			success = false;
			TestDriver.err("getAttributes()", "to contain \"attr1\"", "did not");
		}
		if (!attrs.contains(attr2)) {
			success = false;
			TestDriver.err("getAttributes()", "to contain \"attr2\"", "did not");
		}
		dev1.attributes.add(attr1);
		if (attrs.size() != 2) {
			success = false;
			TestDriver.err("getAttributes()", "to contain 2 attributes", "had " + attrs.size());
		}
		
		
		PHDLDevice dev2 = new PHDLDevice("dev2");
		dev2.addAttribute(attr1);
		attrs = dev2.getAttributes();
		if (!attrs.contains(attr1)) {
			success = false;
			TestDriver.err("addAttribute()", "should have \"attr1\"", "did not");
		}
		dev2.addAttribute(attr2);
		if (!attrs.contains(attr2)) {
			success = false;
			TestDriver.err("addAttribute()", "should have \"attr2\"", "did not");
		}
		dev2.addAttribute(attr1);
		if (attrs.size() != 2) {
			success = false;
			TestDriver.err("addAttribute()", "to contain 2 attributes", "had " + attrs.size());
		}
		
		
		if (dev1.hasRefPrefix()) {
			success = false;
			TestDriver.err("hasRefPrefix()", "doesn't contain a ref des prefix", "apparently does");
		}
		dev1.addAttribute(new PHDLAttribute("refPrefix","R"));
		if (!dev1.hasRefPrefix()) {
			success = false;
			TestDriver.err("hasRefPrefix()", "contains a ref des prefix of \"R\"", "it doesn't");
		}
		
		String pre = dev2.getRefPrefix();
		if (pre != null) {
			success = false;
			TestDriver.err("getRefPrefix()", "doesn't have a ref des prefix", "supposedly it does: " + pre);
		}
		pre = dev1.getRefPrefix();
		if (!pre.equals("R")) {
			success = false;
			TestDriver.err("getRefPrefix()", "should have \"R\" as the prefix", "it has " + pre);
		}
		
		dev1.addAttribute(new PHDLAttribute("refDes", "A"));
		if (dev2.hasRefPrefix()) {
			success = false;
			TestDriver.err("hasRefDes()", "doesn't have a ref des", "supposedly it does");
		}
		if (!dev1.hasRefPrefix()) {
			success = false;
			TestDriver.err("hasRefDes()", "does have a ref des", "supposedly it doesn't");
		}
		
		String ref = dev2.getRefDes();
		if (ref != null) {
			success = false;
			TestDriver.err("getRefDes()", "doesn't have a ref des", "supposedly it does: " + ref);
		}
		ref = dev1.getRefDes();
		if (!ref.equals("A")) {
			success = false;
			TestDriver.err("getRefDes()", "should have \"A\" as the reference", "it has " + ref);
		}
		
		return success;
	}
	
	

}
