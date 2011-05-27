package phdl;

import java.util.HashSet;

/**
 * A class that models a design schematic for a PCB.
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
	 * Default Constructor.
	 * 
	 * Initializes the sets and sets the design name
	 * to "default"
	 */
	public PHDLDesign() {
		this.name = "untitled";
		this.devices = new HashSet<PHDLDevice>();
		this.nets = new HashSet<PHDLNet>();
		this.instances = new HashSet<PHDLInstance>();
	}

	/**
	 * Secondary Constructor.
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
	 * Returns the name of the design.
	 * 
	 * Design name accessor method
	 * 
	 * @return the name of the design
	 */
	public String getName() {
		return name;
	}

	/**
	 * Changes the name of the design.
	 * 
	 * Design name mutator method
	 * 
	 * @param name the new name of the design
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the devices on the board.
	 * 
	 * Design devices accessor method
	 * 
	 * @return a HashSet of PHDLDevices
	 */
	public HashSet<PHDLDevice> getDevices() {
		return devices;
	}

	/**
	 * Adds a device to the board.
	 * 
	 * Design device addition method
	 * 
	 * @param d a new PHDLDevice
	 */
	public void addDevice(PHDLDevice d) {
		devices.add(d);
	}

	/**
	 * Returns the nets on the board.
	 * 
	 * Design nets accessor method
	 * 
	 * @return a HashSet of PHDLNets
	 */
	public HashSet<PHDLNet> getNets() {
		return nets;
	}

	/**
	 * Adds a new net to the board.
	 * 
	 * Design net addition method
	 * 
	 * @param n a new PHDLNet
	 */
	public void addNet(PHDLNet n) {
		nets.add(n);
	}

	/**
	 * Returns the device instances on the board.
	 * 
	 * Design device instances accessor method
	 * 
	 * @return a HashSet of PHDLInstances
	 */
	public HashSet<PHDLInstance> getInstances() {
		return instances;
	}

	/**
	 * Adds a new device instance to the PCB.
	 * 
	 * Design device instance addition method
	 * 
	 * @param i a new PHDLInstance
	 */
	public void addInstance(PHDLInstance i) {
		instances.add(i);
	}
	
	/**
	 * Still to be implemented.
	 * It will collect all of the netlists from
	 * device instances and mash them together
	 */
	public PHDLNetList generateNetList() {
		HashSet<PHDLInstance> insts = getInstances();
		PHDLNetList fullNetList = new PHDLNetList();
		for (PHDLInstance i : insts) {
			PHDLNetList nl = i.getNetList();
			fullNetList.addAllPins(nl);
		}
		return fullNetList;
	}
	
	/**
	 * Still to be implemented.
	 * It will compile a complete netlist and check
	 * the pins to make sure that, i.e. no two outputs
	 * are immediately tied together.
	 * @return 	true if DRC passes,
	 * 			false, otherwise
	 */
	public boolean isValidDRC() {
		return true;
	}
	
	public static boolean unitTest() {
		/* 
		 * Methods Tested
		 *********************
		 * getName			X
		 * setName			X
		 * getDevices		X
		 * addDevice		X
		 * getNets			X
		 * addNet			X
		 * getInstances		X
		 * addInstance		X
		 * generateNetList	
		 * isValidDRC		
		 */
		boolean success = true;
		
		PHDLDesign des1 = new PHDLDesign();
		if (!des1.name.equals("untitled")) {
			success = false;
			TestDriver.err("Constructor", "name = untitled", "name = " + des1.name);
		}
		PHDLDesign des2 = new PHDLDesign("name");
		if (!des2.name.equals("name")) {
			success = false;
			TestDriver.err("Constructor", "name = name", "name = " + des2.name);
		}
		if (!des1.getDevices().isEmpty()) {
			success = false;
			TestDriver.err("Constructor", "empty device set", "non-empty");
		}
		
		if (!des1.getName().equals("untitled")) {
			success = false;
			TestDriver.err("getName())", "untitled", des1.getName());
		}
		if (!des2.getName().equals("name")) {
			success = false;
			TestDriver.err("getName())", "name", des2.getName());
		}
		
		des1.setName("titled");
		des2.setName("brad");
		if (!des1.getName().equals("titled")) {
			success = false;
			TestDriver.err("setName()", "titled", des1.getName());
		}
		if (!des2.getName().equals("brad")) {
			success = false;
			TestDriver.err("setName()", "brad", des2.getName());
		}

		des1.devices.add(new PHDLDevice("dev11"));
		des1.devices.add(new PHDLDevice("dev12"));
		des1.devices.add(new PHDLDevice("dev13"));
		if (des1.getDevices().size() != 3) {
			success = false;
			TestDriver.err("getDevices()", "size of 3", "size of " + des1.getDevices().size());
		}
		if (!des1.getDevices().contains(new PHDLDevice("dev11"))) {
			success = false;
			TestDriver.err("getDevices()", "contains \"dev11\"", "does not");
		}
		if (!des1.getDevices().contains(new PHDLDevice("dev12"))) {
			success = false;
			TestDriver.err("getDevices()", "contains \"dev12\"", "does not");
		}
		if (!des1.getDevices().contains(new PHDLDevice("dev13"))) {
			success = false;
			TestDriver.err("getDevices()", "contains \"dev13\"", "does not");
		}
		
		des2.addDevice(new PHDLDevice("dev21"));
		des2.addDevice(new PHDLDevice("dev22"));
		des2.addDevice(new PHDLDevice("dev23"));
		if (des2.getDevices().size() != 3) {
			success = false;
			TestDriver.err("addDevice()", "size of 3", "size of " + des2.getDevices().size());
		}
		if (!des2.getDevices().contains(new PHDLDevice("dev21"))) {
			success = false;
			TestDriver.err("addDevice()", "contains \"dev21\"", "does not");
		}
		if (!des2.getDevices().contains(new PHDLDevice("dev22"))) {
			success = false;
			TestDriver.err("addDevice()", "contains \"dev22\"", "does not");
		}
		if (!des2.getDevices().contains(new PHDLDevice("dev23"))) {
			success = false;
			TestDriver.err("addDevice()", "contains \"dev23\"", "does not");
		}
		
		if (!des1.getNets().isEmpty()) {
			success = false;
			TestDriver.err("getNets()", "is empty", "is not empty");
		}
		des1.nets.add(new PHDLNet("net1"));
		des1.nets.add(new PHDLNet("net2"));
		des1.nets.add(new PHDLNet("net3"));
		if (des1.getNets().size() != 3) {
			success = false;
			TestDriver.err("getNets()", "size of 3", "size of " + des1.getNets().size());
		}
		if (!des1.getNets().contains(new PHDLNet("net1"))) {
			success = false;
			TestDriver.err("getNets()", "contains \"net1\"", "does not");
		}
		if (!des1.getNets().contains(new PHDLNet("net2"))) {
			success = false;
			TestDriver.err("getNets()", "contains \"net2\"", "does not");
		}
		if (!des1.getNets().contains(new PHDLNet("net3"))) {
			success = false;
			TestDriver.err("getNets()", "contains \"net3\"", "does not");
		}
		
		des2.addNet(new PHDLNet("net1"));
		des2.addNet(new PHDLNet("net2"));
		des2.addNet(new PHDLNet("net3"));
		if (des2.getNets().size() != 3) {
			success = false;
			TestDriver.err("addNet()", "size of 3", "size of " + des2.getNets().size());
		}
		if (!des2.getNets().contains(new PHDLNet("net1"))) {
			success = false;
			TestDriver.err("addNet()", "contains \"net1\"", "does not");
		}
		if (!des2.getNets().contains(new PHDLNet("net2"))) {
			success = false;
			TestDriver.err("addNet()", "contains \"net2\"", "does not");
		}
		if (!des2.getNets().contains(new PHDLNet("net3"))) {
			success = false;
			TestDriver.err("addNet()", "contains \"net3\"", "does not");
		}
		
		des1.instances.add(new PHDLInstance("inst1", new PHDLDevice("dev1")));
		des1.instances.add(new PHDLInstance("inst2", new PHDLDevice("dev2")));
		des1.instances.add(new PHDLInstance("inst3", new PHDLDevice("dev3")));
		if (des1.getInstances().size() != 3) {
			success = false;
			TestDriver.err("getInstances()", "size of 3", "size of " + des1.getInstances().size());
		}
		if (!des1.getInstances().contains(new PHDLInstance("inst1", new PHDLDevice("dev1")))) {
			success = false;
			TestDriver.err("getInstances()", "contains \"inst1\"", "does not");
		}
		if (!des1.getInstances().contains(new PHDLInstance("inst2", new PHDLDevice("dev2")))) {
			success = false;
			TestDriver.err("getInstances()", "contains \"inst2\"", "does not");
		}
		if (!des1.getInstances().contains(new PHDLInstance("inst3", new PHDLDevice("dev3")))) {
			success = false;
			TestDriver.err("getInstances()", "contains \"inst3\"", "does not");
		}
		
		des2.addInstance(new PHDLInstance("inst1", new PHDLDevice("dev1")));
		des2.addInstance(new PHDLInstance("inst2", new PHDLDevice("dev2")));
		des2.addInstance(new PHDLInstance("inst3", new PHDLDevice("dev3")));
		if (des2.getInstances().size() != 3) {
			success = false;
			TestDriver.err("getInstances()", "size of 3", "size of " + des2.getInstances().size());
		}
		if (!des2.getInstances().contains(new PHDLInstance("inst1", new PHDLDevice("dev1")))) {
			success = false;
			TestDriver.err("getInstances()", "contains \"inst1\"", "does not");
		}
		if (!des2.getInstances().contains(new PHDLInstance("inst2", new PHDLDevice("dev2")))) {
			success = false;
			TestDriver.err("getInstances()", "contains \"inst2\"", "does not");
		}
		if (!des2.getInstances().contains(new PHDLInstance("inst3", new PHDLDevice("dev3")))) {
			success = false;
			TestDriver.err("getInstances()", "contains \"inst3\"", "does not");
		}
		
		HashSet<PHDLInstance> insts = des1.getInstances();
		PHDLNet[] nets = {new PHDLNet("net1"), new PHDLNet("net2"), new PHDLNet("net1")};
		PHDLPin[] pins = {new PHDLPin("pin11",1), new PHDLPin("pin23", 3), new PHDLPin("pin15", 5)};
		int j = 0;
		for (PHDLInstance i : insts) {
			i.addPin(nets[j], pins[j]);
			j++;
		}
		/*
		 * net1 : pin11, pin15
		 * net2 : pin23
		 */
		PHDLNetList gnl = des1.generateNetList();
		PHDLNetList mynl = new PHDLNetList();
		mynl.addPin(new PHDLNet("net1"), new PHDLPin("pin11",1));
		mynl.addPin(new PHDLNet("net2"), new PHDLPin("pin23",3));
		if (gnl.equals(mynl)) {
			success = false;
			TestDriver.err("generateNetList()", "mynl is smaller than gnl", "they are equal");
		}
		
		mynl.addPin(new PHDLNet("net1"), new PHDLPin("pin15",5));
		if (!gnl.equals(mynl)) {
			success = false;
			TestDriver.err("generateNetList()", "netlists should be equal", "netlists are not equal");
		}
		
		mynl.addPin(new PHDLNet("net1"), new PHDLPin("pin12",2));
		if (gnl.equals(mynl)) {
			success = false;
			TestDriver.err("generateNetList()", "mynl is larger than gnl", "they are equal");
		}
		
		return success;
	}

}
