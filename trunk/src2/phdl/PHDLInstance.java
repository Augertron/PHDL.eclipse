package phdl;

import java.util.HashSet;
import java.util.HashMap;
import java.util.Collection;

/**
 * A class that models a device instance on a PCB
 * 
 * A device instance that contains an instance name,
 * the name of the device it is modeled after
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
	private HashMap<PHDLNet, HashSet<PHDLPin>> netlist;

	/**
	 * Default Constructor
	 * 
	 * Initializes attribute set and netlist, sets instance name,
	 * and device
	 * 
	 * @param instName the name of the device instance
	 * @param device the device the instances is based on
	 */
	public PHDLInstance(String instName, PHDLDevice device) {
		this.instName = instName;
		this.device = device;
		attributes = device.getAttributes();
		netlist = new HashMap<PHDLNet, HashSet<PHDLPin>>();
	}
	
	/**
	 * Returns the name of the device instance
	 * 
	 * Device instance name accessor method
	 * 
	 * @return the name of the device instance
	 */
	public String getInstName() {
		return instName;
	}

	/**
	 * Changes the name of the device instance
	 * 
	 * Device instance name mutator method
	 * 
	 * @param instName the new device instance name
	 */
	public void setInstName(String instName) {
		this.instName = instName;
	}
	
	/**
	 * Checks to see if there is a device the instance is
	 * based on
	 * 
	 * If the device reference is null, then it is not configured
	 * 
	 * @return  true if there is a device the instance is based on,
	 * 			false if the device is null.
	 */
	public boolean isConfigured() {
		if (device == null) {
			return false;
		}
		return true;
	}
	
	/**
	 * Checks to see if all pins are assigned to a net if necessary
	 * 
	 * @return 	true if the netlist has all the necessary pins
	 * 			false otherwise
	 */
	public boolean netListComplete() {
		HashSet<PHDLPin> fullSet = new HashSet<PHDLPin>();
		Collection<HashSet<PHDLPin>> col = netlist.values();
		for (HashSet<PHDLPin> s : col) {
			fullSet.addAll(s);
		}
		for (PHDLPin p : device.getPins()) {
			if (!fullSet.contains(p)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Returns the name of the device being used as a template
	 * 
	 * Device name accessor method
	 * 
	 * @return the name of the device being used
	 */
	public String getDeviceName() {
		return device.getName();
	}

	/**
	 * Changes the name of the device being used
	 * 
	 * Device name mutator method
	 * 
	 * @param deviceName the name of the device being used
	 */
	public void setDeviceName(String deviceName) {
		device.setName(deviceName);
	}

	/**
	 * Returns the device instance attributes
	 * 
	 * Device instance attributes accessor method
	 * 
	 * @return a HashSet of PHDLAttributes
	 */
	public HashSet<PHDLAttribute> getAttributes() {
		return attributes;
	}

	/**
	 * Adds a new attribute
	 * 
	 * Device instance attributes addition method
	 * 
	 * @param a the new PHDLAttribute
	 */
	public void addAttribute(PHDLAttribute a) {
		attributes.add(a);
	}
	
	/**
	 * Changes an attribute's value
	 * 
	 * Attribute value mutator method
	 * 
	 * @param name the name of the attribute to be modified
	 * @param value the new value of the attribute
	 * @return true if the attribute was changed,
	 * 		   false if the attribute doesn't exist
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
	 * Changes an attribute's value
	 * 
	 * Attribute value mutator method
	 * 
	 * @param attr the PHDLAttribute that will be modified
	 * @param value the new value of the attribute
	 * @return true if the attribute was changed,
	 * 		   false if the attribute doesn't exist
	 */
	public boolean changeAttribute(PHDLAttribute attr, String value) {
		return changeAttribute(attr.getName(), value);
	}

	/**
	 * Returns the device pins
	 * 
	 * Device pins accessor method
	 * 
	 * @return a HashSet of PHDLPins
	 */
	public HashSet<PHDLPin> getDevicePins() {
		return device.getPins();
	}

	/**
	 * Adds a new pin to the device
	 * 
	 * Device pin addition method
	 * 
	 * @param p the new PHDLPin
	 */
	public void addDevicePin(PHDLPin p) {
		device.addPin(p);
	}
	
	/**
	 * Adds a new pin to the device netlist
	 * 
	 * Device netlist addition method
	 * 
	 * @param net the net to add the pin to
	 * @param pin the pin to add
	 * @return 	true if the add was successful
	 * 		   	false if it was already there
	 */
	public boolean addPin(PHDLNet net, PHDLPin pin) {
		if (netlist.containsKey(net)) {
			return netlist.get(net).add(pin);
		}
		else {
			netlist.put(net, new HashSet<PHDLPin>());
			return netlist.get(net).add(pin);
		}
	}
	
	/**
	 * Return the netlist for the device
	 * 
	 * Device netlist accessor method
	 * 
	 * @return a HashMap with PHDLNet keys and a HashSet of
	 * PHDLPins as values
	 */
	public HashMap<PHDLNet, HashSet<PHDLPin>> getNetList() {
		return netlist;
	}
	
	/**
	 * Creates a hash code for use in hash data structures
	 * 
	 * hashCode method to make attributes compatible with hashMaps
	 * and hashSets
	 * 
	 * @return	an integer representing a hash code
	 */
	public int hashCode() {
		return instName.hashCode();
	}

}
