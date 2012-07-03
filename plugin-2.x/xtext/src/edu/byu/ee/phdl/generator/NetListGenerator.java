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

import edu.byu.ee.phdl.elaboration.ElaboratedConnection;
import edu.byu.ee.phdl.elaboration.ElaboratedDesign;
import edu.byu.ee.phdl.elaboration.ElaboratedDevice;
import edu.byu.ee.phdl.elaboration.ElaboratedHierarchyUnit;
import edu.byu.ee.phdl.elaboration.ElaboratedInstance;
import edu.byu.ee.phdl.elaboration.ElaboratedNet;
import edu.byu.ee.phdl.elaboration.ElaboratedPin;
import edu.byu.ee.phdl.elaboration.ElaboratedPort;
import edu.byu.ee.phdl.elaboration.ElaboratedSubInstance;

/**
 * A class that generates a NetList (.asc) for use in PADS.
 * 
 * @author Brad Riching and Richard Black
 * @version 0.1
 */
public class NetListGenerator {

	private final ElaboratedDesign design;

	private final Map<String, ElaboratedInstance> refMap;
	private final Map<ElaboratedNet, List<ElaboratedPin>> netlist;
	private String contents;

	/**
	 * Default constructor.
	 * 
	 * Takes a design and a map of the reference designators and generates the NetList.
	 * 
	 * @param design the DesignNode where all the net information is stored.
	 * @param refMap the map of Reference Designators needed to generated the NetList.
	 * 
	 * @see ElaboratedDesign
	 * @see RefDesGenerator
	 */
	public NetListGenerator(ElaboratedDesign design, Map<String, ElaboratedInstance> refMap) {
		this.design = design;
		this.refMap = refMap;
		netlist = new TreeMap<ElaboratedNet, List<ElaboratedPin>>();
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
	private void clear_visited(ElaboratedHierarchyUnit des) {
		des.clearVisited();
		for (ElaboratedSubInstance s : des.getSubInstances()) {
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
		for (ElaboratedNet n : netlist.keySet()) {
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
	private String generate_net_header(ElaboratedNet n) {
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
			ElaboratedInstance i = refMap.get(s);
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
	private String generate_pin_list(ElaboratedNet n) {
		StringBuilder sb = new StringBuilder();
		List<ElaboratedPin> pins = netlist.get(n);
		if (pins != null) {
			for (int i = 0; i < pins.size() - 1; i++) {
				ElaboratedPin pin1 = pins.get(i);
				ElaboratedPin pin2 = pins.get(i + 1);

				String ref1 = ((ElaboratedInstance) pin1.getParent()).getRefDes();
				String ref2 = ((ElaboratedInstance) pin2.getParent()).getRefDes();

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
	private void retrieve_netlist(ElaboratedHierarchyUnit des) {
		for (ElaboratedNet n : des.getNets()) {
			List<ElaboratedPin> single_netlist = retrieve_pins(n);
			if (single_netlist != null && !single_netlist.isEmpty()) {
				netlist.put(n, single_netlist);
			}
		}
		for (ElaboratedSubInstance s : des.getSubInstances()) {
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
	private List<ElaboratedPin> retrieve_pins(ElaboratedConnection c) {
		List<ElaboratedPin> pinlist = new ArrayList<ElaboratedPin>();
		if (!c.isVisited()) {
			pinlist.addAll(c.getPins());
			c.setVisited(true);
			for (ElaboratedConnection next : c.getConnections()) {
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
			ElaboratedDesign design = new ElaboratedDesign("test1");
			{
				ElaboratedInstance inst1 = new ElaboratedInstance(design);
				{
					ElaboratedDevice dev1 = new ElaboratedDevice("Device1");
					inst1.setDevice(dev1);
					inst1.setRefDes("A1");
					inst1.setName("Inst1");
					inst1.setFootprint("package1");
					inst1.setLibrary("library1");
					ElaboratedPin pin = new ElaboratedPin(inst1);
					{
						pin.setName("Pin1");
						pin.setPinMapping("1");
					}
					inst1.addPin(pin);
				}
				design.addInstance(inst1);

				ElaboratedInstance inst2 = new ElaboratedInstance(design);
				{
					ElaboratedDevice dev2 = new ElaboratedDevice("Device2");
					inst2.setDevice(dev2);
					inst2.setRefDes("B1");
					inst2.setName("Inst2");
					inst2.setFootprint("package2");
					inst2.setLibrary("library2");
					ElaboratedPin pin = new ElaboratedPin(inst2);
					{
						pin.setName("Pin2");
						pin.setPinMapping("2");
					}
					inst2.addPin(pin);
				}
				design.addInstance(inst2);

				ElaboratedNet net1 = new ElaboratedNet(design);
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
			ElaboratedDesign design = new ElaboratedDesign("test2");
			{
				ElaboratedInstance inst1 = new ElaboratedInstance(design);
				{
					ElaboratedDevice dev = new ElaboratedDevice("Device1");
					inst1.setDevice(dev);
					inst1.setRefDes("A1");
					inst1.setName("Inst1");
					inst1.setFootprint("package1");
					inst1.setLibrary("library1");

					ElaboratedPin a = new ElaboratedPin(inst1);
					{
						a.setName("a");
						a.setPinMapping("1");
					}
					inst1.addPin(a);

					ElaboratedPin d = new ElaboratedPin(inst1);
					{
						d.setName("d");
						d.setPinMapping("2");
					}
					inst1.addPin(d);
				}
				design.addInstance(inst1);

				ElaboratedInstance inst2 = new ElaboratedInstance(design);
				{
					ElaboratedDevice dev = new ElaboratedDevice("Device2");
					inst2.setDevice(dev);
					inst2.setRefDes("B1");
					inst2.setName("Inst2");
					inst2.setFootprint("package2");
					inst2.setLibrary("library2");

					ElaboratedPin b = new ElaboratedPin(inst2);
					{
						b.setName("b");
						b.setPinMapping("2");
					}
					inst2.addPin(b);

					ElaboratedPin[] e = new ElaboratedPin[2];
					for (int i = 0; i < 2; i++) {
						e[i] = new ElaboratedPin(inst2);
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

				ElaboratedInstance[] inst3 = new ElaboratedInstance[2];
				ElaboratedPin[][] c = new ElaboratedPin[2][3];
				ElaboratedDevice dev = new ElaboratedDevice("Device3");
				for (int i = 0; i < 2; i++) {
					inst3[i] = new ElaboratedInstance(design);
					{
						inst3[i].setName("inst3");
						inst3[i].setIndex(i + 1);
						inst3[i].setDevice(dev);
						inst3[i].setRefDes("C" + (i + 1));
						inst3[i].setFootprint("package3");
						inst3[i].setLibrary("library3");
					}

					for (int j = 0; j < 3; j++) {
						c[i][j] = new ElaboratedPin(inst3[i]);
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

				ElaboratedNet net2 = new ElaboratedNet(design);
				{
					net2.setName("Net2");
					net2.addPin(inst1.getPin("d"));
					net2.addPin(inst3[0].getPin("c", 1));
					net2.addPin(inst3[0].getPin("c", 2));
					net2.addPin(inst3[0].getPin("c", 3));
				}
				design.addConnection(net2);

				ElaboratedNet[] net1 = new ElaboratedNet[3];
				{
					for (int i = 0; i < 3; i++) {
						net1[i] = new ElaboratedNet(design);
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
			ElaboratedDesign design = new ElaboratedDesign("test3");
			{
				ElaboratedInstance inst1 = new ElaboratedInstance(design);
				{
					ElaboratedDevice dev = new ElaboratedDevice("Device1");
					inst1.setDevice(dev);
					inst1.setRefDes("A1");
					inst1.setName("Inst1");
					inst1.setLibrary("library1");
					inst1.setFootprint("package1");

					ElaboratedPin a = new ElaboratedPin(inst1);
					{
						a.setName("a");
						a.setPinMapping("1");
					}
					inst1.addPin(a);

					ElaboratedPin d = new ElaboratedPin(inst1);
					{
						d.setName("d");
						d.setPinMapping("2");
					}
					inst1.addPin(d);
				}
				design.addInstance(inst1);

				ElaboratedInstance inst2 = new ElaboratedInstance(design);
				{
					ElaboratedDevice dev = new ElaboratedDevice("Device2");
					inst2.setDevice(dev);
					inst2.setRefDes("B1");
					inst2.setName("Inst2");
					inst2.setFootprint("package2");
					inst2.setLibrary("library2");

					ElaboratedPin b = new ElaboratedPin(inst2);
					{
						b.setName("b");
						b.setPinMapping("2");
					}
					inst2.addPin(b);

					ElaboratedPin[] e = new ElaboratedPin[2];
					for (int i = 0; i < 2; i++) {
						e[i] = new ElaboratedPin(inst2);
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

				ElaboratedInstance[] inst3 = new ElaboratedInstance[2];
				ElaboratedPin[][] c = new ElaboratedPin[2][3];
				ElaboratedDevice dev = new ElaboratedDevice("Device3");
				for (int i = 0; i < 2; i++) {
					inst3[i] = new ElaboratedInstance(design);
					{
						inst3[i].setName("inst3");
						inst3[i].setIndex(i + 1);
						inst3[i].setDevice(dev);
						inst3[i].setRefDes("C" + (i + 1));
						inst3[i].setFootprint("package3");
						inst3[i].setLibrary("library3");
					}

					for (int j = 0; j < 3; j++) {
						c[i][j] = new ElaboratedPin(inst3[i]);
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

				ElaboratedNet net2 = new ElaboratedNet(design);
				{
					net2.setName("Net2");
					net2.addPin(inst1.getPin("d"));
					net2.addPin(inst3[0].getPin("c", 1));
					net2.addPin(inst3[0].getPin("c", 2));
					net2.addPin(inst3[0].getPin("c", 3));
				}

				ElaboratedNet net3 = new ElaboratedNet(design);
				{
					net3.setName("Net3");
					net3.addPin(inst2.getPin("e", 2));
				}

				ElaboratedNet net4 = new ElaboratedNet(design);
				{
					net4.setName("Net4");
					net4.addPin(inst3[1].getPin("c", 2));
				}

				ElaboratedNet[] net1 = new ElaboratedNet[3];
				{
					for (int i = 0; i < 3; i++) {
						net1[i] = new ElaboratedNet(design);
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
			ElaboratedDesign design = new ElaboratedDesign("test4");
			ElaboratedSubInstance subinst1 = new ElaboratedSubInstance(design, "SubInst1");
			{
				ElaboratedInstance inst1 = new ElaboratedInstance(subinst1);
				{
					ElaboratedDevice dev = new ElaboratedDevice("dev3");
					inst1.setDevice(dev);
					inst1.setName("SubInst1.Inst1");
					inst1.setRefDes("C1");
					inst1.setFootprint("pkg3");
					inst1.setLibrary("lib3");

					ElaboratedPin f = new ElaboratedPin(inst1);
					{
						f.setName("f");
						f.setPinMapping("1");
					}
					inst1.addPin(f);

					ElaboratedPin g = new ElaboratedPin(inst1);
					{
						g.setName("g");
						g.setPinMapping("2");
					}
					inst1.addPin(g);
				}
				subinst1.addInstance(inst1);

				ElaboratedInstance[] inst2 = new ElaboratedInstance[3];
				ElaboratedPin[][] e = new ElaboratedPin[3][2];
				{
					for (int i = 0; i < 3; i++) {
						inst2[i] = new ElaboratedInstance(subinst1);
						{
							ElaboratedDevice dev = new ElaboratedDevice("dev4");
							inst2[i].setDevice(dev);
							inst2[i].setName("SubInst1.Inst2");
							inst2[i].setIndex(3 - i);
							inst2[i].setFootprint("pkg4");
							inst2[i].setLibrary("lib4");
							inst2[i].setRefDes("D" + (3 - i));
						}
						for (int j = 0; j < 2; j++) {
							e[i][j] = new ElaboratedPin(inst2[i]);
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

				ElaboratedPort[] p1 = new ElaboratedPort[3];
				{
					for (int i = 0; i < 3; i++) {
						p1[i] = new ElaboratedPort(subinst1);
						p1[i].setName("p1");
						p1[i].setIndex(i + 1);
					}
				}

				ElaboratedPort p2 = new ElaboratedPort(subinst1);
				{
					p2.setName("p2");
				}

				ElaboratedPort p3 = new ElaboratedPort(subinst1);
				{
					p3.setName("p3");
				}

				ElaboratedNet net1 = new ElaboratedNet(subinst1);
				{
					net1.setName("net1");
					net1.addPin(inst1.getPin("g"));
					net1.addPin(inst2[0].getPin("e", 1));
				}

				ElaboratedNet net2 = new ElaboratedNet(subinst1);
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

				ElaboratedInstance[] inst1 = new ElaboratedInstance[4];
				ElaboratedPin[][] a = new ElaboratedPin[4][2];
				{
					for (int i = 0; i < 4; i++) {
						inst1[i] = new ElaboratedInstance(design);
						{
							ElaboratedDevice dev = new ElaboratedDevice("dev1");
							inst1[i].setName("Inst1");
							inst1[i].setIndex(i + 1);
							inst1[i].setRefDes("A" + (i + 1));
							inst1[i].setDevice(dev);
							inst1[i].setFootprint("pkg1");
							inst1[i].setLibrary("lib1");

							for (int j = 0; j < 2; j++) {
								a[i][j] = new ElaboratedPin(inst1[i]);
								{
									a[i][j].setName("a");
									a[i][j].setIndex(j + 1);
									a[i][j].setPinMapping("" + (j + 1));
								}
								inst1[i].addPin(a[i][j]);
							}

							ElaboratedPin b = new ElaboratedPin(inst1[i]);
							{
								b.setName("b");
								b.setPinMapping("3");
							}
							inst1[i].addPin(b);
							design.addInstance(inst1[i]);
						}
					}
				}

				ElaboratedInstance inst2 = new ElaboratedInstance(design);
				{
					ElaboratedDevice dev = new ElaboratedDevice("dev2");
					inst2.setName("Inst2");
					inst2.setRefDes("B1");
					inst2.setFootprint("pkg2");
					inst2.setLibrary("lib2");
					inst2.setDevice(dev);

					ElaboratedPin c = new ElaboratedPin(inst2);
					{
						c.setName("c");
						c.setPinMapping("1");
					}
					inst2.addPin(c);

					ElaboratedPin[] d = new ElaboratedPin[2];
					for (int i = 0; i < 2; i++) {
						d[i] = new ElaboratedPin(inst2);
						{
							d[i].setName("d");
							d[i].setIndex(2 - i);
							d[i].setPinMapping("" + (i + 2));
						}
						inst2.addPin(d[i]);
					}
				}
				design.addInstance(inst2);

				ElaboratedNet net1 = new ElaboratedNet(design);
				{
					net1.setName("net1");
					net1.addPin(inst1[3].getPin("b"));
					net1.addPin(inst1[2].getPin("b"));
					net1.addPin(inst1[1].getPin("b"));
					net1.addPin(inst1[0].getPin("b"));
					net1.addPin(inst2.getPin("c"));
				}
				design.addConnection(net1);

				ElaboratedNet[] net2 = new ElaboratedNet[2];
				for (int i = 0; i < 2; i++) {
					net2[i] = new ElaboratedNet(design);
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

				ElaboratedNet net3 = new ElaboratedNet(design);
				{
					net3.setName("net3");
					net3.addPin(inst1[0].getPin("a", 2));
					net3.addPin(inst1[1].getPin("a", 2));
					net3.addPin(inst1[2].getPin("a", 2));
					net3.addPin(inst1[3].getPin("a", 2));
					net3.addConnection(subinst1.getPort("p1", 2));
				}
				design.addConnection(net3);

				ElaboratedNet net4 = new ElaboratedNet(design);
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
			ElaboratedDesign design = new ElaboratedDesign("test5");
			{
				ElaboratedInstance inst4 = new ElaboratedInstance(design);
				{
					inst4.setDevice(new ElaboratedDevice("dev4"));
					inst4.setRefDes("C1");
					inst4.setName("inst4");
					inst4.setFootprint("package4");
					inst4.setLibrary("library4");

					ElaboratedPin g = new ElaboratedPin(inst4);
					{
						g.setName("g");
						g.setPinMapping("1");
					}
					inst4.addPin(g);

					ElaboratedPin h = new ElaboratedPin(inst4);
					{
						h.setName("h");
						h.setPinMapping("2");
					}
					inst4.addPin(h);
				}

				ElaboratedSubInstance[] subInst2 = new ElaboratedSubInstance[2];
				for (int i = 0; i < 2; i++) {
					subInst2[i] = new ElaboratedSubInstance(design, "SubInst2(" + i + ")");
					{
						subInst2[i].setIndex(i);
						subInst2[i].setRefPrefix("Z");
						ElaboratedInstance inst3 = new ElaboratedInstance(design);
						{
							inst3.setDevice(new ElaboratedDevice("dev3"));
							inst3.setRefDes("B1");
							inst3.setName("subInst2.inst3");
							inst3.setFootprint("package1_1");
							inst3.setLibrary("library1_1");

							ElaboratedPin e = new ElaboratedPin(inst3);
							{
								e.setName("e");
								e.setPinMapping("1");
							}
							inst3.addPin(e);

							ElaboratedPin f = new ElaboratedPin(inst3);
							{
								f.setName("f");
								f.setPinMapping("2");
							}
							inst3.addPin(f);
						}

						ElaboratedSubInstance subInst1 = new ElaboratedSubInstance(subInst2[i], "SubInst2(" + i
							+ ")_SubInst1");
						{
							subInst1.setRefPrefix("Y");
							ElaboratedInstance inst1 = new ElaboratedInstance(subInst1);
							{
								inst1.setDevice(new ElaboratedDevice("dev1"));
								inst1.setRefDes("A1");
								inst1.setName("subInst11.inst1");
								inst1.setFootprint("package11_1");
								inst1.setLibrary("library11_1");

								ElaboratedPin a = new ElaboratedPin(inst1);
								{
									a.setName("a");
									a.setPinMapping("1");
								}
								inst1.addPin(a);

								ElaboratedPin b = new ElaboratedPin(inst1);
								{
									b.setName("b");
									b.setPinMapping("2");
								}
								inst1.addPin(b);
							}

							ElaboratedInstance inst2 = new ElaboratedInstance(subInst1);
							{
								inst2.setDevice(new ElaboratedDevice("dev2"));
								inst2.setRefDes("A2");
								inst2.setName("subInst11.inst2");
								inst2.setFootprint("package11_2");
								inst2.setLibrary("library11_2");

								ElaboratedPin c = new ElaboratedPin(inst2);
								{
									c.setName("c");
									c.setPinMapping("1");
								}
								inst2.addPin(c);

								ElaboratedPin d = new ElaboratedPin(inst2);
								{
									d.setName("d");
									d.setPinMapping("2");
								}
								inst2.addPin(d);
							}

							ElaboratedPort pa = new ElaboratedPort(subInst1);
							{
								pa.setName("pa");
								pa.addPin(inst1.getPin("b"));
							}
							subInst1.addConnection(pa);

							ElaboratedPort pb = new ElaboratedPort(subInst1);
							{
								pb.setName("pb");
								pb.addPin(inst2.getPin("d"));
							}
							subInst1.addConnection(pb);

							ElaboratedNet net1 = new ElaboratedNet(subInst1);
							{
								net1.setName("net1");
								net1.addPin(inst1.getPin("a"));
								net1.addPin(inst2.getPin("c"));
							}
							subInst1.addConnection(net1);

							subInst1.addInstance(inst1);
							subInst1.addInstance(inst2);
						}

						ElaboratedPort pc = new ElaboratedPort(subInst2[i]);
						{
							pc.setName("pc");
							pc.addPin(inst3.getPin("e"));
						}
						subInst2[i].addConnection(pc);
						// System.out.println(pc);

						ElaboratedPort pd = new ElaboratedPort(subInst2[i]);
						{
							pd.setName("pd");
							pd.addConnection(subInst1.getPort("pb", -1));
						}
						subInst2[i].addConnection(pd);

						ElaboratedNet net1 = new ElaboratedNet(subInst2[i]);
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

				ElaboratedNet net1 = new ElaboratedNet(design);
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

				ElaboratedNet net2 = new ElaboratedNet(design);
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
