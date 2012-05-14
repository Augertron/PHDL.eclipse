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
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import phdl.graph.Connection;
import phdl.graph.Design;
import phdl.graph.Device;
import phdl.graph.HierarchyUnit;
import phdl.graph.Instance;
import phdl.graph.Net;
import phdl.graph.Pin;
import phdl.graph.Port;
import phdl.graph.SubInstance;

/**
 * A class that generates a NetList (.asc) for use in PADS.
 * 
 * @author Brad Riching and Richard Black
 * @version 0.1
 */
public class NetListGenerator {

	private final Design design;
	private final Map<String, Instance> refMap;
	private final Map<Net, List<Pin>> netlist;
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
	 * generate
	 * 
	 * Generates the netlist and a string representation of it
	 * and stores it into global variables.
	 */
	private void generate() {
		System.out.println("Generating NetList\n");
		StringBuilder sb = new StringBuilder();
		clear_visited(design);

		sb.append(generate_header() + "\n\n");
		sb.append(generate_parts() + "\n");
		sb.append(generate_connections());
		sb.append("\n*END*");

		contents = sb.toString();
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
	 * generate_net_header
	 * 
	 * Generates the header for a net in a design for the
	 * asc netlist file.
	 * 
	 * @param n	the net whose header is to be generatedd
	 * @return	a string representation of the header
	 */
	private String generate_net_header(Net n) {
		StringBuilder sb = new StringBuilder();
		sb.append("*SIGNAL* " + n.getHierarchyName().toUpperCase());
		sb.append("\n");
		return sb.toString();
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
			devices.append(s + " " + i.getLibrary().toUpperCase() + "@" + i.getPackage() + "\n");
		}
		return devices.toString();
	}

	/**
	 * generate_pin_list
	 * 
	 * Generates the list of pins attached to a net in a
	 * design for the asc netlist file.
	 * 
	 * @param n	the net whose pins will be in the list
	 * @return	a string representation of the pin list
	 */
	private String generate_pin_list(Net n) {
		StringBuilder sb = new StringBuilder();
		List<Pin> pins = netlist.get(n);
		if (pins != null) {
			for (int i = 0; i < pins.size() - 1; i++) {
				Pin pin1 = pins.get(i);
				Pin pin2 = pins.get(i + 1);

				String ref1 = ((Instance) pin1.getParent()).getRefDes();
				String ref2 = ((Instance) pin2.getParent()).getRefDes();

				sb.append(" " + ref1 + "." + pin1.getPinMapping());
				sb.append(" " + ref2 + "." + pin2.getPinMapping());
				sb.append("\n");
			}
		}
		return sb.toString();
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
		System.out.println("  -- Generated: \\" + fileName);
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
			if (single_netlist != null && !single_netlist.isEmpty()) {
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
		List<Pin> pinlist = new ArrayList<Pin>();
		if (!c.isVisited()) {
			pinlist.addAll(c.getPins());
			c.setVisited(true);
			for (Connection next : c.getConnections()) {
				pinlist.addAll(retrieve_pins(next));
			}
		}
		return pinlist;
	}

	/**
	 * unitTest
	 * 
	 * Unit testing code.
	 * 
	 * @return	a boolean indicating if the tests were successful
	 */
	public static boolean unitTest() {
		boolean success = true;

		/**
		 * Test 1
		 * 	No Hierarchy and no arrayed instances/nets/pins
		 */
		{
			Design design = new Design("test1");
			{
				Instance inst1 = new Instance(design);
				{
					Device dev1 = new Device("Device1");
					inst1.setDevice(dev1);
					inst1.setRefDes("A1");
					inst1.setName("Inst1");
					inst1.setPackage("package1");
					inst1.setLibrary("library1");
					Pin pin = new Pin(inst1);
					{
						pin.setName("Pin1");
						pin.setPinMapping("1");
					}
					inst1.addPin(pin);
				}
				design.addInstance(inst1);

				Instance inst2 = new Instance(design);
				{
					Device dev2 = new Device("Device2");
					inst2.setDevice(dev2);
					inst2.setRefDes("B1");
					inst2.setName("Inst2");
					inst2.setPackage("package2");
					inst2.setLibrary("library2");
					Pin pin = new Pin(inst2);
					{
						pin.setName("Pin2");
						pin.setPinMapping("2");
					}
					inst2.addPin(pin);
				}
				design.addInstance(inst2);

				Net net1 = new Net(design);
				{
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
			Design design = new Design("test2");
			{
				Instance inst1 = new Instance(design);
				{
					Device dev = new Device("Device1");
					inst1.setDevice(dev);
					inst1.setRefDes("A1");
					inst1.setName("Inst1");
					inst1.setPackage("package1");
					inst1.setLibrary("library1");

					Pin a = new Pin(inst1);
					{
						a.setName("a");
						a.setPinMapping("1");
					}
					inst1.addPin(a);

					Pin d = new Pin(inst1);
					{
						d.setName("d");
						d.setPinMapping("2");
					}
					inst1.addPin(d);
				}
				design.addInstance(inst1);

				Instance inst2 = new Instance(design);
				{
					Device dev = new Device("Device2");
					inst2.setDevice(dev);
					inst2.setRefDes("B1");
					inst2.setName("Inst2");
					inst2.setPackage("package2");
					inst2.setLibrary("library2");

					Pin b = new Pin(inst2);
					{
						b.setName("b");
						b.setPinMapping("2");
					}
					inst2.addPin(b);

					Pin[] e = new Pin[2];
					for (int i = 0; i < 2; i++) {
						e[i] = new Pin(inst2);
						{
							e[i].setName("e");
							e[i].setIndex(i + 1);
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
					inst3[i] = new Instance(design);
					{
						inst3[i].setName("inst3");
						inst3[i].setIndex(i + 1);
						inst3[i].setDevice(dev);
						inst3[i].setRefDes("C" + (i + 1));
						inst3[i].setPackage("package3");
						inst3[i].setLibrary("library3");
					}

					for (int j = 0; j < 3; j++) {
						c[i][j] = new Pin(inst3[i]);
						c[i][j].setName("c");
						c[i][j].setIndex(j + 1);
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

				Net net2 = new Net(design);
				{
					net2.setName("Net2");
					net2.addPin(inst1.getPin("d"));
					net2.addPin(inst3[0].getPin("c", 1));
					net2.addPin(inst3[0].getPin("c", 2));
					net2.addPin(inst3[0].getPin("c", 3));
				}
				design.addConnection(net2);

				Net[] net1 = new Net[3];
				{
					for (int i = 0; i < 3; i++) {
						net1[i] = new Net(design);
						{
							net1[i].setName("Net1");
							net1[i].setIndex(3 - i);
						}
					}
					net1[0].addPin(inst1.getPin("a"));
					net1[0].addPin(inst2.getPin("b"));
					net1[0].addPin(inst3[1].getPin("c", 1));

					net1[1].addPin(inst2.getPin("e", 1));
					net1[1].addPin(inst3[1].getPin("c", 2));

					net1[2].addPin(inst2.getPin("e", 2));
					net1[2].addPin(inst3[1].getPin("c", 3));
				}
				design.addConnection(net1[0]);
				design.addConnection(net1[1]);
				design.addConnection(net1[2]);
			}
			RefDesGenerator refGen = new RefDesGenerator(design);
			NetListGenerator netGen = new NetListGenerator(design, refGen.getRefMap());
			netGen.outputToFile("TestsOutput/NetListOutput/" + design.getName() + ".asc");
		}

		/**
		 * Test 3
		 *  No hierarchy, with arrayed instances/pins/nets
		 *  Intermittent nets
		 */
		{
			Design design = new Design("test3");
			{
				Instance inst1 = new Instance(design);
				{
					Device dev = new Device("Device1");
					inst1.setDevice(dev);
					inst1.setRefDes("A1");
					inst1.setName("Inst1");
					inst1.setLibrary("library1");
					inst1.setPackage("package1");

					Pin a = new Pin(inst1);
					{
						a.setName("a");
						a.setPinMapping("1");
					}
					inst1.addPin(a);

					Pin d = new Pin(inst1);
					{
						d.setName("d");
						d.setPinMapping("2");
					}
					inst1.addPin(d);
				}
				design.addInstance(inst1);

				Instance inst2 = new Instance(design);
				{
					Device dev = new Device("Device2");
					inst2.setDevice(dev);
					inst2.setRefDes("B1");
					inst2.setName("Inst2");
					inst2.setPackage("package2");
					inst2.setLibrary("library2");

					Pin b = new Pin(inst2);
					{
						b.setName("b");
						b.setPinMapping("2");
					}
					inst2.addPin(b);

					Pin[] e = new Pin[2];
					for (int i = 0; i < 2; i++) {
						e[i] = new Pin(inst2);
						{
							e[i].setName("e");
							e[i].setIndex(i + 1);
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
					inst3[i] = new Instance(design);
					{
						inst3[i].setName("inst3");
						inst3[i].setIndex(i + 1);
						inst3[i].setDevice(dev);
						inst3[i].setRefDes("C" + (i + 1));
						inst3[i].setPackage("package3");
						inst3[i].setLibrary("library3");
					}

					for (int j = 0; j < 3; j++) {
						c[i][j] = new Pin(inst3[i]);
						c[i][j].setName("c");
						c[i][j].setIndex(j + 1);
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

				Net net2 = new Net(design);
				{
					net2.setName("Net2");
					net2.addPin(inst1.getPin("d"));
					net2.addPin(inst3[0].getPin("c", 1));
					net2.addPin(inst3[0].getPin("c", 2));
					net2.addPin(inst3[0].getPin("c", 3));
				}

				Net net3 = new Net(design);
				{
					net3.setName("Net3");
					net3.addPin(inst2.getPin("e", 2));
				}

				Net net4 = new Net(design);
				{
					net4.setName("Net4");
					net4.addPin(inst3[1].getPin("c", 2));
				}

				Net[] net1 = new Net[3];
				{
					for (int i = 0; i < 3; i++) {
						net1[i] = new Net(design);
						{
							net1[i].setName("Net1");
							net1[i].setIndex(3 - i);
						}
					}
					net1[0].addPin(inst1.getPin("a"));
					net1[0].addPin(inst2.getPin("b"));
					net1[0].addPin(inst3[1].getPin("c", 1));

					net1[1].addPin(inst2.getPin("e", 1));

					net1[2].addPin(inst3[1].getPin("c", 3));
				}

				net4.addConnection(net1[1]);
				net1[1].addConnection(net4);

				net3.addConnection(net1[2]);
				net1[2].addConnection(net3);

				design.addConnection(net1[0]);
				design.addConnection(net1[1]);
				design.addConnection(net1[2]);
				design.addConnection(net2);
				design.addConnection(net3);
				design.addConnection(net4);

			}
			RefDesGenerator refGen = new RefDesGenerator(design);
			NetListGenerator netGen = new NetListGenerator(design, refGen.getRefMap());
			netGen.outputToFile("TestsOutput/NetListOutput/" + design.getName() + ".asc");
		}
		/**
		 * Test 4
		 *	Netlist with single layer of hiearchy
		 */
		{
			Design design = new Design("test4");
			SubInstance subinst1 = new SubInstance(design, "SubInst1");
			{
				Instance inst1 = new Instance(subinst1);
				{
					Device dev = new Device("dev3");
					inst1.setDevice(dev);
					inst1.setName("SubInst1.Inst1");
					inst1.setRefDes("C1");
					inst1.setPackage("pkg3");
					inst1.setLibrary("lib3");

					Pin f = new Pin(inst1);
					{
						f.setName("f");
						f.setPinMapping("1");
					}
					inst1.addPin(f);

					Pin g = new Pin(inst1);
					{
						g.setName("g");
						g.setPinMapping("2");
					}
					inst1.addPin(g);
				}
				subinst1.addInstance(inst1);

				Instance[] inst2 = new Instance[3];
				Pin[][] e = new Pin[3][2];
				{
					for (int i = 0; i < 3; i++) {
						inst2[i] = new Instance(subinst1);
						{
							Device dev = new Device("dev4");
							inst2[i].setDevice(dev);
							inst2[i].setName("SubInst1.Inst2");
							inst2[i].setIndex(3 - i);
							inst2[i].setPackage("pkg4");
							inst2[i].setLibrary("lib4");
							inst2[i].setRefDes("D" + (3 - i));
						}
						for (int j = 0; j < 2; j++) {
							e[i][j] = new Pin(inst2[i]);
							{
								e[i][j].setName("e");
								e[i][j].setIndex(j + 1);
								e[i][j].setPinMapping("" + (j + 1));
							}
							inst2[i].addPin(e[i][j]);
						}
						subinst1.addInstance(inst2[i]);
					}
				}

				Port[] p1 = new Port[3];
				{
					for (int i = 0; i < 3; i++) {
						p1[i] = new Port(subinst1);
						p1[i].setName("p1");
						p1[i].setIndex(i + 1);
					}
				}

				Port p2 = new Port(subinst1);
				{
					p2.setName("p2");
				}

				Port p3 = new Port(subinst1);
				{
					p3.setName("p3");
				}

				Net net1 = new Net(subinst1);
				{
					net1.setName("net1");
					net1.addPin(inst1.getPin("g"));
					net1.addPin(inst2[0].getPin("e", 1));
				}

				Net net2 = new Net(subinst1);
				{
					net2.setName("net2");
					net2.addPin(inst2[1].getPin("e", 2));
					net2.addPin(inst2[2].getPin("e", 1));
					net2.addConnection(p1[2]);
					net2.addConnection(p2);
				}

				p1[0].addPin(inst1.getPin("f"));
				p1[1].addPin(inst2[0].getPin("e", 2));
				p1[1].addPin(inst2[1].getPin("e", 1));
				p1[2].addConnection(net2);
				p2.addConnection(net2);
				p3.addPin(inst2[2].getPin("e", 2));

				subinst1.addConnection(p1[0]);
				subinst1.addConnection(p1[1]);
				subinst1.addConnection(p1[2]);
				subinst1.addConnection(p2);
				subinst1.addConnection(net2);
				subinst1.addConnection(p3);
				subinst1.addConnection(net1);
			}

			{
				design.addSubInst(subinst1);

				Instance[] inst1 = new Instance[4];
				Pin[][] a = new Pin[4][2];
				{
					for (int i = 0; i < 4; i++) {
						inst1[i] = new Instance(design);
						{
							Device dev = new Device("dev1");
							inst1[i].setName("Inst1");
							inst1[i].setIndex(i + 1);
							inst1[i].setRefDes("A" + (i + 1));
							inst1[i].setDevice(dev);
							inst1[i].setPackage("pkg1");
							inst1[i].setLibrary("lib1");

							for (int j = 0; j < 2; j++) {
								a[i][j] = new Pin(inst1[i]);
								{
									a[i][j].setName("a");
									a[i][j].setIndex(j + 1);
									a[i][j].setPinMapping("" + (j + 1));
								}
								inst1[i].addPin(a[i][j]);
							}

							Pin b = new Pin(inst1[i]);
							{
								b.setName("b");
								b.setPinMapping("3");
							}
							inst1[i].addPin(b);
							design.addInstance(inst1[i]);
						}
					}
				}

				Instance inst2 = new Instance(design);
				{
					Device dev = new Device("dev2");
					inst2.setName("Inst2");
					inst2.setRefDes("B1");
					inst2.setPackage("pkg2");
					inst2.setLibrary("lib2");
					inst2.setDevice(dev);

					Pin c = new Pin(inst2);
					{
						c.setName("c");
						c.setPinMapping("1");
					}
					inst2.addPin(c);

					Pin[] d = new Pin[2];
					for (int i = 0; i < 2; i++) {
						d[i] = new Pin(inst2);
						{
							d[i].setName("d");
							d[i].setIndex(2 - i);
							d[i].setPinMapping("" + (i + 2));
						}
						inst2.addPin(d[i]);
					}
				}
				design.addInstance(inst2);

				Net net1 = new Net(design);
				{
					net1.setName("net1");
					net1.addPin(inst1[3].getPin("b"));
					net1.addPin(inst1[2].getPin("b"));
					net1.addPin(inst1[1].getPin("b"));
					net1.addPin(inst1[0].getPin("b"));
					net1.addPin(inst2.getPin("c"));
				}
				design.addConnection(net1);

				Net[] net2 = new Net[2];
				for (int i = 0; i < 2; i++) {
					net2[i] = new Net(design);
					{
						net2[i].setName("net2");
						net2[i].setIndex(i + 1);
					}
				}
				net2[0].addPin(inst2.getPin("d", 2));
				net2[0].addConnection(subinst1.getPort("p1", 3));
				net2[0].addConnection(subinst1.getPort("p2", -1));
				net2[1].addPin(inst2.getPin("d", 1));
				net2[1].addConnection(subinst1.getPort("p3", -1));
				design.addConnection(net2[0]);
				design.addConnection(net2[1]);

				Net net3 = new Net(design);
				{
					net3.setName("net3");
					net3.addPin(inst1[0].getPin("a", 2));
					net3.addPin(inst1[1].getPin("a", 2));
					net3.addPin(inst1[2].getPin("a", 2));
					net3.addPin(inst1[3].getPin("a", 2));
					net3.addConnection(subinst1.getPort("p1", 2));
				}
				design.addConnection(net3);

				Net net4 = new Net(design);
				{
					net4.setName("net4");
					net4.addPin(inst1[0].getPin("a", 1));
					net4.addPin(inst1[1].getPin("a", 1));
					net4.addPin(inst1[2].getPin("a", 1));
					net4.addPin(inst1[3].getPin("a", 1));
					net4.addConnection(subinst1.getPort("p1", 1));
				}
				design.addConnection(net4);

			}
			RefDesGenerator refGen = new RefDesGenerator(design);
			NetListGenerator netGen = new NetListGenerator(design, refGen.getRefMap());
			netGen.outputToFile("TestsOutput/NetListOutput/" + design.getName() + ".asc");
		}

		/**
		 * Test 5
		 * 	Netlist with two layers of hierarchy
		 */
		{
			Design design = new Design("test5");
			{
				Instance inst4 = new Instance(design); {
					inst4.setDevice(new Device("dev4"));
					inst4.setRefDes("C1");
					inst4.setName("inst4");
					inst4.setPackage("package4");
					inst4.setLibrary("library4");
					
					Pin g = new Pin(inst4); {
						g.setName("g");
						g.setPinMapping("1");
					}
					inst4.addPin(g);
					
					Pin h = new Pin(inst4); {
						h.setName("h");
						h.setPinMapping("2");
					}
					inst4.addPin(h);
				}
				
				SubInstance[] subInst2 = new SubInstance[2];
				for (int i = 0; i < 2; i++) {
					subInst2[i] = new SubInstance(design, "SubInst2(" + i + ")");
					{
						subInst2[i].setIndex(i);
						subInst2[i].setRefPrefix("Z");
						Instance inst3 = new Instance(design); {
							inst3.setDevice(new Device("dev3"));
							inst3.setRefDes("B1");
							inst3.setName("subInst2.inst3");
							inst3.setPackage("package1_1");
							inst3.setLibrary("library1_1");
							
							Pin e = new Pin(inst3); {
								e.setName("e");
								e.setPinMapping("1");
							}
							inst3.addPin(e);
							
							Pin f = new Pin(inst3); {
								f.setName("f");
								f.setPinMapping("2");
							}
							inst3.addPin(f);
						}
						
						SubInstance subInst1 = new SubInstance(subInst2[i], "SubInst2(" + i + ")_SubInst1");
						{
							subInst1.setRefPrefix("Y");
							Instance inst1 = new Instance(subInst1); {
								inst1.setDevice(new Device("dev1"));
								inst1.setRefDes("A1");
								inst1.setName("subInst11.inst1");
								inst1.setPackage("package11_1");
								inst1.setLibrary("library11_1");
								
								Pin a = new Pin(inst1); {
									a.setName("a");
									a.setPinMapping("1");
								}
								inst1.addPin(a);
								
								Pin b = new Pin(inst1); {
									b.setName("b");
									b.setPinMapping("2");
								}
								inst1.addPin(b);
							}
							
							Instance inst2 = new Instance(subInst1); {
								inst2.setDevice(new Device("dev2"));
								inst2.setRefDes("A2");
								inst2.setName("subInst11.inst2");
								inst2.setPackage("package11_2");
								inst2.setLibrary("library11_2");
								
								Pin c = new Pin(inst2); {
									c.setName("c");
									c.setPinMapping("1");
								}
								inst2.addPin(c);
								
								Pin d = new Pin(inst2); {
									d.setName("d");
									d.setPinMapping("2");
								}
								inst2.addPin(d);
							}
							
							Port pa = new Port(subInst1); {
								pa.setName("pa");
								pa.addPin(inst1.getPin("b"));
							}
							subInst1.addConnection(pa);
							
							Port pb = new Port(subInst1); {
								pb.setName("pb");
								pb.addPin(inst2.getPin("d"));
							}
							subInst1.addConnection(pb);
							
							Net net1 = new Net(subInst1); {
								net1.setName("net1");
								net1.addPin(inst1.getPin("a"));
								net1.addPin(inst2.getPin("c"));
							}
							subInst1.addConnection(net1);
							
							subInst1.addInstance(inst1);
							subInst1.addInstance(inst2);
						}
						
						Port pc = new Port(subInst2[i]); {
							pc.setName("pc");
							pc.addPin(inst3.getPin("e"));
						}
						subInst2[i].addConnection(pc);
						//System.out.println(pc);
						
						Port pd = new Port(subInst2[i]); {
							pd.setName("pd");
							pd.addConnection(subInst1.getPort("pb", -1));
						}
						subInst2[i].addConnection(pd);
						
						Net net1 = new Net(subInst2[i]); {
							net1.setName("net1");
							net1.addPin(inst3.getPin("f"));
							net1.addConnection(subInst1.getPort("pa", -1));
						}
						subInst2[i].addConnection(net1);
						
						subInst2[i].addSubInst(subInst1);
						subInst2[i].addInstance(inst3);
					}
				}
				
				Net net1 = new Net(design); {
					net1.setName("net1");
					net1.addPin(inst4.getPin("g"));
					net1.addConnection(subInst2[0].getPort("pc", -1));
					net1.addConnection(subInst2[1].getPort("pc", -1));
				}
				
				System.out.println(net1);
				System.out.println(subInst2[0].getPort("pc", -1));
				System.out.println(subInst2[0].getPort("pd", -1));
				
				subInst2[0].getPort("pc", -1).addConnection(net1);
				subInst2[1].getPort("pc", -1).addConnection(net1);
				
				Net net2 = new Net(design); {
					net2.setName("net2");
					net2.addPin(inst4.getPin("h"));
					net2.addConnection(subInst2[0].getPort("pd", -1));
					net2.addConnection(subInst2[1].getPort("pd", -1));
				}
				subInst2[0].getPort("pd", -1).addConnection(net2);
				subInst2[1].getPort("pd", -1).addConnection(net2);
				
				design.addConnection(net1);
				design.addConnection(net2);
				design.addInstance(inst4);
				design.addSubInst(subInst2[0]);
				design.addSubInst(subInst2[1]);
			}
			
			RefDesGenerator refGen = new RefDesGenerator(design);
			NetListGenerator netGen = new NetListGenerator(design, refGen.getRefMap());
			netGen.outputToFile("TestsOutput/NetListOutput/" + design.getName() + ".asc");
		}
		

		return success;
	}

}
