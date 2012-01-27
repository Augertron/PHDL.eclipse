/*
 * Copyright (C) 2011 Brigham Young University This program is free software: you can redistribute
 * it and/or modify it under the terms of the GNU General Public License as published by the Free
 * Software Foundation, version 3. This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received
 * a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package phdl.generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import phdl.graph.Connection;
import phdl.graph.Design;
import phdl.graph.DesignUnit;
import phdl.graph.Device;
import phdl.graph.HierarchyUnit;
import phdl.graph.Instance;
import phdl.graph.Net;
import phdl.graph.Pin;
import phdl.graph.SubInstance;

/**
 * A class that generates a NetList (.asc) for use in PADS.
 * 
 * @author Brad Riching and Richard Black
 * @version 0.1
 */
public class NetListGenerator {

	private Design design;
	private Map<String, Instance> refMap;
	private Map<Net, List<Pin>> netlist;
	private String contents;

	/**
	 * Default constructor.
	 * 
	 * Takes a design and a map of the reference designators and generates the NetList.
	 * 
	 * @param design
	 *            the DesignNode where all the net information is stored.
	 * @param refMap
	 *            the map of Reference Designators needed to generated the NetList.
	 * 
	 * @see Design
	 * @see RefDesGenerator
	 */
	public NetListGenerator(Design design, Map<String, Instance> refMap) {
		this.design = design;
		this.refMap = refMap;
		netlist = new TreeMap<Net, List<Pin>>();
		generate();
	}
	
	/**
	 * generate
	 * 
	 * Generates the netlist and a string representation of it
	 * and stores it into global variables.
	 */
	private void generate() {
		StringBuilder sb = new StringBuilder();
		clear_visited(design);
		
		sb.append(generate_header() + "\n\n");
		sb.append(generate_parts() + "\n");
		sb.append(generate_connections());
		sb.append("\n*END*");
		
		contents = sb.toString();
	}
	
	/**
	 * clear_visited
	 * 
	 * Recursively iterates through and sets all Net's visited
	 * boolean variable to unvisited.
	 *  
	 * @param des	The HierarchyUnit whose Nets will be set
	 * 				to unvisited.
	 */
	private void clear_visited(HierarchyUnit des) {
		des.clearVisited();
		for (SubInstance s : des.getSubInstances()) {
			clear_visited(s);
		}
	}
	
	/**
	 * generate_header
	 * 
	 * Generates the header of the asc netlist file.
	 * 
	 * @return	a string representation of the header in a PADS
	 * 			netlist
	 */
	private String generate_header() {
		StringBuilder header = new StringBuilder();
		header.append("!PADS-POWERPCB-V9.0-MILS! NETLIST FILE FROM PADS LOGIC V9.3");
		return header.toString();
	}
	
	/**
	 * generate_parts
	 * 
	 * Generates the list of parts used on the board in for the
	 * asc netlist file.
	 * 
	 * @return	a string representation of the part list for a 
	 * 			PADS netlist 
	 */
	private String generate_parts() {
		StringBuilder devices = new StringBuilder();
		devices.append("*PART*\n");
		for (String s : refMap.keySet()) {
			Instance i = refMap.get(s);
			devices.append(s);
			devices.append(" " + i.getDevice().getName().toUpperCase() + "@" + i.getPackage() + "\n");
		}
		return devices.toString();
	}
	
	/**
	 * generate_connections
	 * 
	 * Generates the list of nets and the pins associated
	 * connected to them for the asc netlist file.
	 * 
	 * @return	a string representation of the nets and pins
	 * 			for a PADS netlist
	 */
	private String generate_connections() {
		StringBuilder connections = new StringBuilder();
		connections.append("*CONNECTION*\n");
		
		retrieve_netlist(design);
		for (Net n : netlist.keySet()) {
			connections.append(generate_net_header(n));
			connections.append(generate_pin_list(n));
		}
		return connections.toString();
	}
	
	private String generate_net_header(Net n) {
		StringBuilder sb = new StringBuilder();
		sb.append("*SIGNAL* " + n.getName().toUpperCase());
		if (n.hasIndex()) {
			sb.append("[" + n.getIndex() + "]");
		}
		sb.append("\n");
		return sb.toString();
	}
	
	private String generate_pin_list(Net n) {
		StringBuilder sb = new StringBuilder();
		List<Pin> pins = netlist.get(n);
		if (pins != null) {
			for (int i = 0; i < pins.size() - 1; i++) {
				Pin pin1 = pins.get(i);
				Pin pin2 = pins.get(i+1);
				
				String ref1 = ((Instance)pin1.getParent()).getRefDes();
				String ref2 = ((Instance)pin2.getParent()).getRefDes();
				
				sb.append(" " + ref1 + "." + pin1.getPinMapping());
				sb.append(" " + ref2 + "." + pin2.getPinMapping());
				sb.append("\n");
			}
		}
		return sb.toString();
	}
	
	/**
	 * retrieve_netlist
	 * 
	 * Collects recursively all the nets and pins found in
	 * the entire design and inserts them into the global
	 * netlist map.
	 * 
	 * @param des	The HierarchyUnit in which to search for
	 * 				nets and pins
	 */
	private void retrieve_netlist(HierarchyUnit des) {
		for (Net n : des.getNets()) {
			List<Pin> single_netlist = retrieve_pins(n);
			if (single_netlist != null) {
				netlist.put(n, single_netlist);
			}
		}
		for (SubInstance s : des.getSubInstances()) {
			retrieve_netlist(s);
		}
	}
	
	/**
	 * retrieve_pins
	 * 
	 * Recursively collects all the pins connected to a
	 * Connection.
	 * 
	 * @param c		The Connection whose pins are to be
	 * 				collected
	 * @return	A list of all the pins found on the connection
	 */
	private List<Pin> retrieve_pins(Connection c) {
		List<Pin> netlist = new ArrayList<Pin>();
		if (!c.isVisited()) {
			netlist.addAll(c.getPins());
			c.setVisited(true);
			return netlist;
		}
		else {
			return null;
		}
	}

	/**
	 * generate_old
	 * 
	 * This is the generate method used for version 1.0
	 */
	private void generate_old() {
		StringBuilder sb = new StringBuilder();
		sb.append("!PADS-POWERPCB-V9.0-MILS! NETLIST FILE FROM PADS LOGIC V9.3 \n\n");
		sb.append("*PART*\n");

		for (String s : refMap.keySet()) {
			Instance i = refMap.get(s);
			sb.append(s);
			sb.append(" " + i.getDevice().getName().toUpperCase() + "@" + i.getPackage() + "\n");
		}
		sb.append("*CONNECTION*\n");

		for (Net n : design.getNets()) {

			if (n.getName().equals("OPEN"))
				continue;

			sb.append("*SIGNAL* " + n.getName().toUpperCase() + "\n");

			for (int i = 0; i < n.getPins().size() - 1; i++) {

				Pin pin1 = n.getPins().get(i);
				Pin pin2 = n.getPins().get(i + 1);

				String ref1 = ((Instance) pin1.getParent()).getRefDes();
				String ref2 = ((Instance) pin2.getParent()).getRefDes();
				String name1 = pin1.getName();
				String name2 = pin2.getName();

				sb.append(" " + refMap.get(ref1).getRefDes() + "." + name1);
				sb.append(" " + refMap.get(ref2).getRefDes() + "." + name2 + "\n");
			}
		}
		sb.append("\n*END*");
		contents = sb.toString();
	}

	/**
	 * Returns the NetList string.
	 * 
	 * @return a string representation of the NetList
	 */
	public String getContents() {
		return contents;
	}

	/**
	 * Generates an .asc file representation of the NetList.
	 * 
	 * @param fileName
	 *            the name of the file to write to
	 */
	public void outputToFile(String fileName) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
			out.write(contents);
			out.close();
		} catch (IOException e) {
			System.err.println("File Reading Error - filename may be corrupt");
			System.exit(1);
		}
		System.out.println("Wrote netlist file: " + design.getName() + ".asc");
	}
	
	public static boolean unitTest() {
		boolean success = true;
		
		/**
		 * Test 1
		 * 	No Hierarchy and no arrayed instances/nets/pins
		 */
		{
			Design design = new Design("test1");
			{
				Instance inst1 = new Instance(design); {
					Device dev1 = new Device("Device1");
					inst1.setDevice(dev1);
					inst1.setRefDes("A1");
					inst1.setName("Inst1");
					inst1.setPackage("package1");
					Pin pin = new Pin(inst1); {
						pin.setName("Pin1");
						pin.setPinMapping("1");
					}
					inst1.addPin(pin);
				}
				design.addInstance(inst1);
				
				Instance inst2 = new Instance(design); {
					Device dev2 = new Device("Device2");
					inst2.setDevice(dev2);
					inst2.setRefDes("B1");
					inst2.setName("Inst2");
					inst2.setPackage("package2");
					Pin pin = new Pin(inst2); {
						pin.setName("Pin2");
						pin.setPinMapping("2");
					}
					inst2.addPin(pin);
				}
				design.addInstance(inst2);
				
				Net net1 = new Net(design); {
					net1.setName("Net1");
					net1.addPin(inst1.getPin("Pin1"));
					net1.addPin(inst2.getPin("Pin2"));
				}
				design.addConnection(net1);
			}
			RefDesGenerator refGen = new RefDesGenerator(design);
			NetListGenerator netGen = new NetListGenerator(design, refGen.getRefMap());
			netGen.outputToFile("TestsOutput/NetListOutput/" + design.getName() + ".asc");
		}
		/**
		 * Test 2
		 *  No hierarchy, with arrayed instances/pins/nets
		 */
		{
			Design design = new Design("test2"); {
				Instance inst1 = new Instance(design); {
					Device dev = new Device("Device1");
					inst1.setDevice(dev);
					inst1.setRefDes("A1");
					inst1.setName("Inst1");
					inst1.setPackage("package1");
					
					Pin a = new Pin(inst1); {
						a.setName("a");
						a.setPinMapping("1");
					}
					inst1.addPin(a);
					
					Pin d = new Pin(inst1); {
						d.setName("d");
						d.setPinMapping("2");
					}
					inst1.addPin(d);
				}
				design.addInstance(inst1);
				
				Instance inst2 = new Instance(design); {
					Device dev = new Device("Device2");
					inst2.setDevice(dev);
					inst2.setRefDes("B1");
					inst2.setName("Inst2");
					inst2.setPackage("package2");
					
					Pin b = new Pin(inst2); {
						b.setName("b");
						b.setPinMapping("2");
					}
					inst2.addPin(b);
					
					Pin[] e = new Pin[2];
					for (int i = 0; i < 2; i++) {
						e[i] = new Pin(inst2); {
							e[i].setName("e");
							e[i].setIndex(i+1);
						}
					}
					e[0].setPinMapping("1");
					e[1].setPinMapping("3");
					inst2.addPin(e[0]);
					inst2.addPin(e[1]);
				}
				design.addInstance(inst2);
				
				Instance[] inst3 = new Instance[2];
				Pin[][] c = new Pin[2][3];
				Device dev = new Device("Device3");
				for (int i = 0; i < 2; i++) {
					inst3[i] = new Instance(design); {
						inst3[i].setName("inst3");
						inst3[i].setIndex(i+1);
						inst3[i].setDevice(dev);
						inst3[i].setRefDes("C" + (i+1));
						inst3[i].setPackage("package3");
					}
					
					for (int j = 0; j < 3; j++) {
						c[i][j] = new Pin(inst3[i]);
						c[i][j].setName("c");
						c[i][j].setIndex(j+1);
					}
					c[i][0].setPinMapping("8");
					c[i][1].setPinMapping("9");
					c[i][2].setPinMapping("10");
					
					inst3[i].addPin(c[i][0]);
					inst3[i].addPin(c[i][1]);
					inst3[i].addPin(c[i][2]);
				}
				design.addInstance(inst3[0]);
				design.addInstance(inst3[1]);
				
				Net net2 = new Net(design); {
					net2.setName("Net2");
					net2.addPin(inst1.getPin("d"));
					net2.addPin(inst3[0].getPin("c", 1));
					net2.addPin(inst3[0].getPin("c", 2));
					net2.addPin(inst3[0].getPin("c", 3));
				}
				design.addConnection(net2);
				
				Net[] net1 = new Net[3]; {
					for (int i = 0; i < 3; i++) {
						net1[i] = new Net(design); {
							net1[i].setName("Net1");
							net1[i].setIndex(3-i);
						}
					}
					net1[0].addPin(inst1.getPin("a"));
					net1[0].addPin(inst2.getPin("b"));
					net1[0].addPin(inst3[1].getPin("c",1));
					
					net1[1].addPin(inst2.getPin("e",1));
					net1[1].addPin(inst3[1].getPin("c",2));
					
					net1[2].addPin(inst2.getPin("e",2));
					net1[2].addPin(inst3[1].getPin("c",3));
				}
				design.addConnection(net1[0]);
				design.addConnection(net1[1]);
				design.addConnection(net1[2]);
			}
			RefDesGenerator refGen = new RefDesGenerator(design);
			NetListGenerator netGen = new NetListGenerator(design, refGen.getRefMap());
			netGen.outputToFile("TestsOutput/NetListOutput/" + design.getName() + ".asc");
		}
		
		return success;
	}

}

