/*
 * Copyright (C) 2011 Brigham Young University This program is free software: you can redistribute
 * it and/or modify it under the terms of the GNU General Public License as published by the Free
 * Software Foundation, version 3. This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received
 * a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package edu.byu.ee.phdl.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import edu.byu.ee.phdl.elaboration.EConnection;
import edu.byu.ee.phdl.elaboration.EDesign;
import edu.byu.ee.phdl.elaboration.EDevice;
import edu.byu.ee.phdl.elaboration.EHierarchyUnit;
import edu.byu.ee.phdl.elaboration.EInstance;
import edu.byu.ee.phdl.elaboration.ENet;
import edu.byu.ee.phdl.elaboration.EPin;
import edu.byu.ee.phdl.elaboration.EPort;
import edu.byu.ee.phdl.elaboration.ESubInstance;

/**
 * A class that generates a NetList (.asc) for use in PADS.
 * 
 * @author Brad Riching and Richard Black
 * @version 0.1
 */
public class NetListGenerator {

	private final EDesign design;

	private final Map<String, EInstance> refMap;
	private final Map<ENet, List<EPin>> netlist;
	private String contents;

	/**
	 * Default constructor.
	 * 
	 * Takes a design and a map of the reference designators and generates the NetList.
	 * 
	 * @param design the DesignNode where all the net information is stored.
	 * @param refMap the map of Reference Designators needed to generated the NetList.
	 * 
	 * @see EDesign
	 * @see RefDesGenerator
	 */
	public NetListGenerator(EDesign design, Map<String, EInstance> refMap) {
		this.design = design;
		this.refMap = refMap;
		netlist = new TreeMap<ENet, List<EPin>>();
		generate();
	}

	/**
	 * clear_visited
	 * 
	 * Recursively iterates through and sets all ElaboratedNet's visited boolean variable to
	 * unvisited.
	 * 
	 * @param des The ElaboratedHierarchyUnit whose Nets will be set to unvisited.
	 */
	private void clear_visited(EHierarchyUnit des) {
		des.clearVisited();
		for (ESubInstance s : des.getSubInstances()) {
			clear_visited(s);
		}
	}

	/**
	 * generate
	 * 
	 * Generates the netlist and a string representation of it and stores it into global variables.
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
	 * generate_connections
	 * 
	 * Generates the list of nets and the pins associated connected to them for the asc netlist
	 * file.
	 * 
	 * @return a string representation of the nets and pins for a PADS netlist
	 */
	private String generate_connections() {
		StringBuilder connections = new StringBuilder();
		connections.append("*CONNECTION*\n");

		retrieve_netlist(design);
		for (ENet n : netlist.keySet()) {
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
	 * @return a string representation of the header in a PADS netlist
	 */
	private String generate_header() {
		StringBuilder header = new StringBuilder();
		header.append("!PADS-POWERPCB-V9.0-MILS! NETLIST FILE FROM PADS LOGIC V9.3");
		return header.toString();
	}

	/**
	 * generate_net_header
	 * 
	 * Generates the header for a net in a design for the asc netlist file.
	 * 
	 * @param n the net whose header is to be generatedd
	 * @return a string representation of the header
	 */
	private String generate_net_header(ENet n) {
		StringBuilder sb = new StringBuilder();
		sb.append("*SIGNAL* " + n.getHierarchyName().toUpperCase());
		sb.append("\n");
		return sb.toString();
	}

	/**
	 * generate_parts
	 * 
	 * Generates the list of parts used on the board in for the asc netlist file.
	 * 
	 * @return a string representation of the part list for a PADS netlist
	 */
	private String generate_parts() {
		StringBuilder devices = new StringBuilder();
		devices.append("*PART*\n");
		for (String s : refMap.keySet()) {
			EInstance i = refMap.get(s);
			devices.append(s + " ");
			devices.append(i.getLibrary());
			devices.append("@" + i.getFootprint() + "\n");
		}
		return devices.toString();
	}

	/**
	 * generate_pin_list
	 * 
	 * Generates the list of pins attached to a net in a design for the asc netlist file.
	 * 
	 * @param n the net whose pins will be in the list
	 * @return a string representation of the pin list
	 */
	private String generate_pin_list(ENet n) {
		StringBuilder sb = new StringBuilder();
		List<EPin> pins = netlist.get(n);
		if (pins != null) {
			for (int i = 0; i < pins.size() - 1; i++) {
				EPin pin1 = pins.get(i);
				EPin pin2 = pins.get(i + 1);

				String ref1 = ((EInstance) pin1.getParent()).getRefDes();
				String ref2 = ((EInstance) pin2.getParent()).getRefDes();

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
	 * @param fileName the name of the file to write to
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
		System.out.println("  -- Generated: " + File.separator + fileName);
	}

	/**
	 * retrieve_netlist
	 * 
	 * Collects recursively all the nets and pins found in the entire design and inserts them into
	 * the global netlist map.
	 * 
	 * @param des The ElaboratedHierarchyUnit in which to search for nets and pins
	 */
	private void retrieve_netlist(EHierarchyUnit des) {
		for (ENet n : des.getNets()) {
			List<EPin> single_netlist = retrieve_pins(n);
			if (single_netlist != null && !single_netlist.isEmpty()) {
				netlist.put(n, single_netlist);
			}
		}
		for (ESubInstance s : des.getSubInstances()) {
			retrieve_netlist(s);
		}
	}

	/**
	 * retrieve_pins
	 * 
	 * Recursively collects all the pins connected to a ElaboratedConnection.
	 * 
	 * @param c The ElaboratedConnection whose pins are to be collected
	 * @return A list of all the pins found on the connection
	 */
	private List<EPin> retrieve_pins(EConnection c) {
		List<EPin> pinlist = new ArrayList<EPin>();
		if (!c.isVisited()) {
			pinlist.addAll(c.getPins());
			c.setVisited(true);
			for (EConnection next : c.getConnections()) {
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
	 * @return a boolean indicating if the tests were successful
	 */
	public static boolean unitTest() {
		boolean success = true;

		/**
		 * Test 1 No Hierarchy and no arrayed instances/nets/pins
		 */
		{
			EDesign design = new EDesign("test1");
			{
				EInstance inst1 = new EInstance(design);
				{
					EDevice dev1 = new EDevice("Device1");
					inst1.setDevice(dev1);
					inst1.setRefDes("A1");
					inst1.setName("Inst1");
					inst1.setFootprint("package1");
					inst1.setLibrary("library1");
					EPin pin = new EPin(inst1);
					{
						pin.setName("Pin1");
						pin.setPinMapping("1");
					}
					inst1.addPin(pin);
				}
				design.addInstance(inst1);

				EInstance inst2 = new EInstance(design);
				{
					EDevice dev2 = new EDevice("Device2");
					inst2.setDevice(dev2);
					inst2.setRefDes("B1");
					inst2.setName("Inst2");
					inst2.setFootprint("package2");
					inst2.setLibrary("library2");
					EPin pin = new EPin(inst2);
					{
						pin.setName("Pin2");
						pin.setPinMapping("2");
					}
					inst2.addPin(pin);
				}
				design.addInstance(inst2);

				ENet net1 = new ENet(design);
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
		 * Test 2 No hierarchy, with arrayed instances/pins/nets
		 */
		{
			EDesign design = new EDesign("test2");
			{
				EInstance inst1 = new EInstance(design);
				{
					EDevice dev = new EDevice("Device1");
					inst1.setDevice(dev);
					inst1.setRefDes("A1");
					inst1.setName("Inst1");
					inst1.setFootprint("package1");
					inst1.setLibrary("library1");

					EPin a = new EPin(inst1);
					{
						a.setName("a");
						a.setPinMapping("1");
					}
					inst1.addPin(a);

					EPin d = new EPin(inst1);
					{
						d.setName("d");
						d.setPinMapping("2");
					}
					inst1.addPin(d);
				}
				design.addInstance(inst1);

				EInstance inst2 = new EInstance(design);
				{
					EDevice dev = new EDevice("Device2");
					inst2.setDevice(dev);
					inst2.setRefDes("B1");
					inst2.setName("Inst2");
					inst2.setFootprint("package2");
					inst2.setLibrary("library2");

					EPin b = new EPin(inst2);
					{
						b.setName("b");
						b.setPinMapping("2");
					}
					inst2.addPin(b);

					EPin[] e = new EPin[2];
					for (int i = 0; i < 2; i++) {
						e[i] = new EPin(inst2);
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

				EInstance[] inst3 = new EInstance[2];
				EPin[][] c = new EPin[2][3];
				EDevice dev = new EDevice("Device3");
				for (int i = 0; i < 2; i++) {
					inst3[i] = new EInstance(design);
					{
						inst3[i].setName("inst3");
						inst3[i].setIndex(i + 1);
						inst3[i].setDevice(dev);
						inst3[i].setRefDes("C" + (i + 1));
						inst3[i].setFootprint("package3");
						inst3[i].setLibrary("library3");
					}

					for (int j = 0; j < 3; j++) {
						c[i][j] = new EPin(inst3[i]);
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

				ENet net2 = new ENet(design);
				{
					net2.setName("Net2");
					net2.addPin(inst1.getPin("d"));
					net2.addPin(inst3[0].getPin("c", 1));
					net2.addPin(inst3[0].getPin("c", 2));
					net2.addPin(inst3[0].getPin("c", 3));
				}
				design.addConnection(net2);

				ENet[] net1 = new ENet[3];
				{
					for (int i = 0; i < 3; i++) {
						net1[i] = new ENet(design);
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
		 * Test 3 No hierarchy, with arrayed instances/pins/nets Intermittent nets
		 */
		{
			EDesign design = new EDesign("test3");
			{
				EInstance inst1 = new EInstance(design);
				{
					EDevice dev = new EDevice("Device1");
					inst1.setDevice(dev);
					inst1.setRefDes("A1");
					inst1.setName("Inst1");
					inst1.setLibrary("library1");
					inst1.setFootprint("package1");

					EPin a = new EPin(inst1);
					{
						a.setName("a");
						a.setPinMapping("1");
					}
					inst1.addPin(a);

					EPin d = new EPin(inst1);
					{
						d.setName("d");
						d.setPinMapping("2");
					}
					inst1.addPin(d);
				}
				design.addInstance(inst1);

				EInstance inst2 = new EInstance(design);
				{
					EDevice dev = new EDevice("Device2");
					inst2.setDevice(dev);
					inst2.setRefDes("B1");
					inst2.setName("Inst2");
					inst2.setFootprint("package2");
					inst2.setLibrary("library2");

					EPin b = new EPin(inst2);
					{
						b.setName("b");
						b.setPinMapping("2");
					}
					inst2.addPin(b);

					EPin[] e = new EPin[2];
					for (int i = 0; i < 2; i++) {
						e[i] = new EPin(inst2);
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

				EInstance[] inst3 = new EInstance[2];
				EPin[][] c = new EPin[2][3];
				EDevice dev = new EDevice("Device3");
				for (int i = 0; i < 2; i++) {
					inst3[i] = new EInstance(design);
					{
						inst3[i].setName("inst3");
						inst3[i].setIndex(i + 1);
						inst3[i].setDevice(dev);
						inst3[i].setRefDes("C" + (i + 1));
						inst3[i].setFootprint("package3");
						inst3[i].setLibrary("library3");
					}

					for (int j = 0; j < 3; j++) {
						c[i][j] = new EPin(inst3[i]);
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

				ENet net2 = new ENet(design);
				{
					net2.setName("Net2");
					net2.addPin(inst1.getPin("d"));
					net2.addPin(inst3[0].getPin("c", 1));
					net2.addPin(inst3[0].getPin("c", 2));
					net2.addPin(inst3[0].getPin("c", 3));
				}

				ENet net3 = new ENet(design);
				{
					net3.setName("Net3");
					net3.addPin(inst2.getPin("e", 2));
				}

				ENet net4 = new ENet(design);
				{
					net4.setName("Net4");
					net4.addPin(inst3[1].getPin("c", 2));
				}

				ENet[] net1 = new ENet[3];
				{
					for (int i = 0; i < 3; i++) {
						net1[i] = new ENet(design);
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
		 * Test 4 Netlist with single layer of hierarchy
		 */
		{
			EDesign design = new EDesign("test4");
			ESubInstance subinst1 = new ESubInstance(design, "SubInst1");
			{
				EInstance inst1 = new EInstance(subinst1);
				{
					EDevice dev = new EDevice("dev3");
					inst1.setDevice(dev);
					inst1.setName("SubInst1.Inst1");
					inst1.setRefDes("C1");
					inst1.setFootprint("pkg3");
					inst1.setLibrary("lib3");

					EPin f = new EPin(inst1);
					{
						f.setName("f");
						f.setPinMapping("1");
					}
					inst1.addPin(f);

					EPin g = new EPin(inst1);
					{
						g.setName("g");
						g.setPinMapping("2");
					}
					inst1.addPin(g);
				}
				subinst1.addInstance(inst1);

				EInstance[] inst2 = new EInstance[3];
				EPin[][] e = new EPin[3][2];
				{
					for (int i = 0; i < 3; i++) {
						inst2[i] = new EInstance(subinst1);
						{
							EDevice dev = new EDevice("dev4");
							inst2[i].setDevice(dev);
							inst2[i].setName("SubInst1.Inst2");
							inst2[i].setIndex(3 - i);
							inst2[i].setFootprint("pkg4");
							inst2[i].setLibrary("lib4");
							inst2[i].setRefDes("D" + (3 - i));
						}
						for (int j = 0; j < 2; j++) {
							e[i][j] = new EPin(inst2[i]);
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

				EPort[] p1 = new EPort[3];
				{
					for (int i = 0; i < 3; i++) {
						p1[i] = new EPort(subinst1);
						p1[i].setName("p1");
						p1[i].setIndex(i + 1);
					}
				}

				EPort p2 = new EPort(subinst1);
				{
					p2.setName("p2");
				}

				EPort p3 = new EPort(subinst1);
				{
					p3.setName("p3");
				}

				ENet net1 = new ENet(subinst1);
				{
					net1.setName("net1");
					net1.addPin(inst1.getPin("g"));
					net1.addPin(inst2[0].getPin("e", 1));
				}

				ENet net2 = new ENet(subinst1);
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

				EInstance[] inst1 = new EInstance[4];
				EPin[][] a = new EPin[4][2];
				{
					for (int i = 0; i < 4; i++) {
						inst1[i] = new EInstance(design);
						{
							EDevice dev = new EDevice("dev1");
							inst1[i].setName("Inst1");
							inst1[i].setIndex(i + 1);
							inst1[i].setRefDes("A" + (i + 1));
							inst1[i].setDevice(dev);
							inst1[i].setFootprint("pkg1");
							inst1[i].setLibrary("lib1");

							for (int j = 0; j < 2; j++) {
								a[i][j] = new EPin(inst1[i]);
								{
									a[i][j].setName("a");
									a[i][j].setIndex(j + 1);
									a[i][j].setPinMapping("" + (j + 1));
								}
								inst1[i].addPin(a[i][j]);
							}

							EPin b = new EPin(inst1[i]);
							{
								b.setName("b");
								b.setPinMapping("3");
							}
							inst1[i].addPin(b);
							design.addInstance(inst1[i]);
						}
					}
				}

				EInstance inst2 = new EInstance(design);
				{
					EDevice dev = new EDevice("dev2");
					inst2.setName("Inst2");
					inst2.setRefDes("B1");
					inst2.setFootprint("pkg2");
					inst2.setLibrary("lib2");
					inst2.setDevice(dev);

					EPin c = new EPin(inst2);
					{
						c.setName("c");
						c.setPinMapping("1");
					}
					inst2.addPin(c);

					EPin[] d = new EPin[2];
					for (int i = 0; i < 2; i++) {
						d[i] = new EPin(inst2);
						{
							d[i].setName("d");
							d[i].setIndex(2 - i);
							d[i].setPinMapping("" + (i + 2));
						}
						inst2.addPin(d[i]);
					}
				}
				design.addInstance(inst2);

				ENet net1 = new ENet(design);
				{
					net1.setName("net1");
					net1.addPin(inst1[3].getPin("b"));
					net1.addPin(inst1[2].getPin("b"));
					net1.addPin(inst1[1].getPin("b"));
					net1.addPin(inst1[0].getPin("b"));
					net1.addPin(inst2.getPin("c"));
				}
				design.addConnection(net1);

				ENet[] net2 = new ENet[2];
				for (int i = 0; i < 2; i++) {
					net2[i] = new ENet(design);
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

				ENet net3 = new ENet(design);
				{
					net3.setName("net3");
					net3.addPin(inst1[0].getPin("a", 2));
					net3.addPin(inst1[1].getPin("a", 2));
					net3.addPin(inst1[2].getPin("a", 2));
					net3.addPin(inst1[3].getPin("a", 2));
					net3.addConnection(subinst1.getPort("p1", 2));
				}
				design.addConnection(net3);

				ENet net4 = new ENet(design);
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
		 * Test 5 Netlist with two layers of hierarchy
		 */
		{
			EDesign design = new EDesign("test5");
			{
				EInstance inst4 = new EInstance(design);
				{
					inst4.setDevice(new EDevice("dev4"));
					inst4.setRefDes("C1");
					inst4.setName("inst4");
					inst4.setFootprint("package4");
					inst4.setLibrary("library4");

					EPin g = new EPin(inst4);
					{
						g.setName("g");
						g.setPinMapping("1");
					}
					inst4.addPin(g);

					EPin h = new EPin(inst4);
					{
						h.setName("h");
						h.setPinMapping("2");
					}
					inst4.addPin(h);
				}

				ESubInstance[] subInst2 = new ESubInstance[2];
				for (int i = 0; i < 2; i++) {
					subInst2[i] = new ESubInstance(design, "SubInst2(" + i + ")");
					{
						subInst2[i].setIndex(i);
						subInst2[i].setRefPrefix("Z");
						EInstance inst3 = new EInstance(design);
						{
							inst3.setDevice(new EDevice("dev3"));
							inst3.setRefDes("B1");
							inst3.setName("subInst2.inst3");
							inst3.setFootprint("package1_1");
							inst3.setLibrary("library1_1");

							EPin e = new EPin(inst3);
							{
								e.setName("e");
								e.setPinMapping("1");
							}
							inst3.addPin(e);

							EPin f = new EPin(inst3);
							{
								f.setName("f");
								f.setPinMapping("2");
							}
							inst3.addPin(f);
						}

						ESubInstance subInst1 = new ESubInstance(subInst2[i], "SubInst2(" + i
							+ ")_SubInst1");
						{
							subInst1.setRefPrefix("Y");
							EInstance inst1 = new EInstance(subInst1);
							{
								inst1.setDevice(new EDevice("dev1"));
								inst1.setRefDes("A1");
								inst1.setName("subInst11.inst1");
								inst1.setFootprint("package11_1");
								inst1.setLibrary("library11_1");

								EPin a = new EPin(inst1);
								{
									a.setName("a");
									a.setPinMapping("1");
								}
								inst1.addPin(a);

								EPin b = new EPin(inst1);
								{
									b.setName("b");
									b.setPinMapping("2");
								}
								inst1.addPin(b);
							}

							EInstance inst2 = new EInstance(subInst1);
							{
								inst2.setDevice(new EDevice("dev2"));
								inst2.setRefDes("A2");
								inst2.setName("subInst11.inst2");
								inst2.setFootprint("package11_2");
								inst2.setLibrary("library11_2");

								EPin c = new EPin(inst2);
								{
									c.setName("c");
									c.setPinMapping("1");
								}
								inst2.addPin(c);

								EPin d = new EPin(inst2);
								{
									d.setName("d");
									d.setPinMapping("2");
								}
								inst2.addPin(d);
							}

							EPort pa = new EPort(subInst1);
							{
								pa.setName("pa");
								pa.addPin(inst1.getPin("b"));
							}
							subInst1.addConnection(pa);

							EPort pb = new EPort(subInst1);
							{
								pb.setName("pb");
								pb.addPin(inst2.getPin("d"));
							}
							subInst1.addConnection(pb);

							ENet net1 = new ENet(subInst1);
							{
								net1.setName("net1");
								net1.addPin(inst1.getPin("a"));
								net1.addPin(inst2.getPin("c"));
							}
							subInst1.addConnection(net1);

							subInst1.addInstance(inst1);
							subInst1.addInstance(inst2);
						}

						EPort pc = new EPort(subInst2[i]);
						{
							pc.setName("pc");
							pc.addPin(inst3.getPin("e"));
						}
						subInst2[i].addConnection(pc);
						// System.out.println(pc);

						EPort pd = new EPort(subInst2[i]);
						{
							pd.setName("pd");
							pd.addConnection(subInst1.getPort("pb", -1));
						}
						subInst2[i].addConnection(pd);

						ENet net1 = new ENet(subInst2[i]);
						{
							net1.setName("net1");
							net1.addPin(inst3.getPin("f"));
							net1.addConnection(subInst1.getPort("pa", -1));
						}
						subInst2[i].addConnection(net1);

						subInst2[i].addSubInst(subInst1);
						subInst2[i].addInstance(inst3);
					}
				}

				ENet net1 = new ENet(design);
				{
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

				ENet net2 = new ENet(design);
				{
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