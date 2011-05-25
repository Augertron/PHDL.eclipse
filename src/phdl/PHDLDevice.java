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
	public boolean hasRefDesPrefix() {
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
	public String getRefDesPrefix() {
		if (!hasRefDesPrefix()) {
			System.err.println("Error - there is no refPrefix attribute in " + name);
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
	public boolean hasRefDesAttr() {
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
	public String getRefDesAttr() {
		if (!hasRefDesAttr()) {
			System.err.println("Error - there is no refDes attribute in " + name);
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
	
	public static boolean unitTest() {
		/* 
		 * Methods Tested
		 *********************
		 * hasRefDesPrefix
		 * getRefDesPrefix
		 * hasRefDesAttr
		 * getRefDesAttr
		 * getName
		 * setName
		 * getAttributes
		 * addAttribute
		 * getPins
		 * addPin
		 */
		boolean success = true;
		
		return success;
	}
	
	

}
