package phdl;

import java.util.HashSet;

/**
 * A class that models a design schematic for a PCB
 * 
 * A top module class that contains the design name,
 * a set of devices on the board, a set of device
 * instances, and a set of nets
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 */
public class PHDLDesign {
	/**
	 * The name of the design
	 */
	private String name;
	/**
	 * A set of the devices
	 */
	private HashSet<PHDLDevice> devices;
	/**
	 * A set of the nets
	 */
	private HashSet<PHDLNet> nets;
	/**
	 * A set of the device instances
	 */
	private HashSet<PHDLInstance> instances;

	/**
	 * Default Constructor
	 * 
	 * Initializes the sets and sets the design name
	 * to "default"
	 */
	public PHDLDesign() {
		this.name = "default";
		this.devices = new HashSet<PHDLDevice>();
		this.nets = new HashSet<PHDLNet>();
		this.instances = new HashSet<PHDLInstance>();
	}

	/**
	 * Secondary Constructor
	 * 
	 * Initializes the sets and sets the design name
	 * to the paramater "name"
	 * 
	 * @param name the name of the design
	 */
	public PHDLDesign(String name) {
		this.name = name;
		this.devices = new HashSet<PHDLDevice>();
		this.nets = new HashSet<PHDLNet>();
		this.instances = new HashSet<PHDLInstance>();
	}

	/**
	 * Returns the name of the design
	 * 
	 * Design name accessor method
	 * 
	 * @return the name of the design
	 */
	public String getName() {
		return name;
	}

	/**
	 * Changes the name of the design
	 * 
	 * Design name mutator method
	 * 
	 * @param name the new name of the design
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the devices on the board
	 * 
	 * Design devices accessor method
	 * 
	 * @return a HashSet of PHDLDevices
	 */
	public HashSet<PHDLDevice> getDevices() {
		return devices;
	}

	/**
	 * Adds a device to the board
	 * 
	 * Design device addition method
	 * 
	 * @param d a new PHDLDevice
	 */
	public void addDevice(PHDLDevice d) {
		devices.add(d);
	}

	/**
	 * Returns the nets on the board
	 * 
	 * Design nets accessor method
	 * 
	 * @return a HashSet of PHDLNets
	 */
	public HashSet<PHDLNet> getNets() {
		return nets;
	}

	/**
	 * Adds a new net to the board
	 * 
	 * Design net addition method
	 * 
	 * @param n a new PHDLNet
	 */
	public void addNet(PHDLNet n) {
		nets.add(n);
	}

	/**
	 * Returns the device instances on the board
	 * 
	 * Design device instances accessor method
	 * 
	 * @return a HashSet of PHDLInstances
	 */
	public HashSet<PHDLInstance> getInstances() {
		return instances;
	}

	/**
	 * Adds a new device instance to the PCB
	 * 
	 * Design device instance addition method
	 * 
	 * @param i a new PHDLInstance
	 */
	public void addInstance(PHDLInstance i) {
		instances.add(i);
	}
	
	/**
	 * Still to be implemented.  It will collect all
	 * of the netlists from device instances and mash them
	 * together
	 */
	public PHDLNetList generateNetList() {
		return null;
	}

}
