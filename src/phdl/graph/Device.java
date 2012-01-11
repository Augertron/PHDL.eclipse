/*
 * Copyright (C) 2011 Brigham Young University This program is free software: you can redistribute
 * it and/or modify it under the terms of the GNU General Public License as published by the Free
 * Software Foundation, version 3. This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received
 * a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package phdl.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents a device in PHDL.
 * 
 * @author Brad Riching and Richard Black
 * @version 0.1
 */
public class Device extends Attributable {

	private List<Pin> pins;
	private List<Instance> instances;

	/**
	 * Default Constructor.
	 * 
	 * @param design
	 *            the parent DesignNode for this Device
	 * 
	 * @see Design
	 * @see Attribute
	 * @see Pin
	 * @see Instance
	 */
	public Device(Design design) {
		this.info = "";
		this.pins = new ArrayList<Pin>();
		this.instances = new ArrayList<Instance>();
	}

	public Device(String name) {
		this.info = "";
		this.name = name;
		this.pins = new ArrayList<Pin>();
		this.instances = new ArrayList<Instance>();
	}

	/**
	 * Instance Set addition method
	 * 
	 * @param instance
	 *            the InstanceNode to be added
	 * @return true, if the instance isn't already in the set false, otherwise
	 */
	public boolean addInstance(Instance instance) {
		return instances.add(instance);
	}

	/**
	 * Pin addition method.
	 * 
	 * @param p
	 *            the new PinNode
	 * @return true, if the pin wasn't already in the List false, otherwise
	 */
	public boolean addPin(Pin p) {
		return pins.add(p);
	}

	/**
	 * Instance Set accessor method
	 * 
	 * @return the set of all InstanceNodes connected to this device
	 */
	public List<Instance> getInstances() {
		return instances;
	}

	/**
	 * Individual Pin Accessor method.
	 * 
	 * 
	 */
	public Pin getPin(String pinName) {
		for (Pin p : pins) {
			if (p.getName().equals(pinName)) {
				return p;
			}
		}
		return null;
	}

	/**
	 * Pins accessor method.
	 * 
	 * @return a list of PinNodes attached to this Device.
	 */
	public List<Pin> getPins() {
		return pins;
	}

	@Override
	/**
	 * Type accessor method.
	 * 
	 * @return NodeType.DEVICE
	 */
	public NodeType getNodeType() {
		return NodeType.DEVICE;
	}

	/**
	 * Checks to see if the device has any pins attached.
	 * 
	 * @return true, if there are pins false, otherwise
	 */
	public boolean hasPins() {
		return (!pins.isEmpty());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		for (Attribute a : attributes)
			sb.append("\t" + a.toString() + "\n");
		for (Pin p : pins)
			sb.append("\t" + p.toString() + "\n");
		return sb.toString();
	}

	public void printDevice() {
		System.out.println();
		System.out.println("  --------------------------------------------------------");
		System.out.println("  Device: " + getName() + ", file: " + getFileName() + ", line "
			+ getLine() + ":" + getPosition());
		System.out.println();

		if (!attributes.isEmpty()) {
			System.out.println("      Attr        Name                 Value              ");
			System.out.println("      ----  ----------------  -----------------------     ");
			int attrCount = 1;
			for (Attribute a : attributes) {
				System.out.printf("%10d%2s%-16s%2s%-24s\n", attrCount, "  ", a.getName(), "  ", a
					.getValue().equals("") ? "(empty)" : a.getValue());
				attrCount++;
			}
			System.out.println();
		}

		if (!pins.isEmpty()) {
			System.out.println("      Pin    Type          Name          PinNum ");
			System.out.println("      ----  --------  ----------------  --------");
			int pinCount = 1;
			for (Pin p : pins) {
				System.out.printf("%10d%2s%-8s%2s%-16s%2s%-8s\n", pinCount, "  ", p.getPinType(),
					"  ", p.getName() + (p.getIndex() == -1 ? "" : ("[" + p.getIndex() + "]")),
					"  ", p.getPinMapping());
				pinCount++;
			}
			System.out.println();
		}

		if (!instances.isEmpty()) {
			System.out.println("      Inst      Name             Location");
			System.out.println("      ----  ----------------  ------------------");
			int instCount = 1;
			for (Instance i : instances) {
				System.out.printf("%10d%2s%-16s%2s%-22s\n", instCount, "  ",
					i.getName() + ((i.getIndex() == -1) ? "" : ("(" + i.getIndex() + ")")), "  ",
					i.getFileName() + ", " + i.getLine() + ":" + i.getPosition());
				instCount++;
			}
			System.out.println();
		}

		if (!getInfo().equals("")) {
			System.out.println("      Info");
			System.out.println("      ----");
			System.out.println("      " + getInfo());
			System.out.println();
		}

	}
}
