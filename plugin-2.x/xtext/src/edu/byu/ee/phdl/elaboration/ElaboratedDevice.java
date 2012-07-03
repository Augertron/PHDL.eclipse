/*
 * Copyright (C) 2011 Brigham Young University This program is free software: you can redistribute
 * it and/or modify it under the terms of the GNU General Public License as published by the Free
 * Software Foundation, version 3. This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received
 * a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package edu.byu.ee.phdl.elaboration;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents a device in PHDL.
 * 
 * @author Brad Riching and Richard Black
 * @version 0.1
 */
public class ElaboratedDevice extends Attributable {

	private final List<ElaboratedPin> pins;
	private final List<ElaboratedInstance> instances;

	/**
	 * Default Constructor.
	 * 
	 * @param design
	 *            the parent DesignNode for this Device
	 * 
	 * @see ElaboratedDesign
	 * @see ElaboratedAttribute
	 * @see ElaboratedPin
	 * @see ElaboratedInstance
	 */
	public ElaboratedDevice(ElaboratedDesign design) {
		super();
		this.info = "";
		this.pins = new ArrayList<ElaboratedPin>();
		this.instances = new ArrayList<ElaboratedInstance>();
	}

	public ElaboratedDevice(String name) {
		super();
		this.info = "";
		this.name = name;
		this.pins = new ArrayList<ElaboratedPin>();
		this.instances = new ArrayList<ElaboratedInstance>();
	}

	/**
	 * Instance Set addition method
	 * 
	 * @param instance
	 *            the InstanceNode to be added
	 * @return true, if the instance isn't already in the set false, otherwise
	 */
	public boolean addInstance(ElaboratedInstance instance) {
		return instances.add(instance);
	}

	/**
	 * Pin addition method.
	 * 
	 * @param p
	 *            the new PinNode
	 * @return true, if the pin wasn't already in the List false, otherwise
	 */
	public boolean addPin(ElaboratedPin p) {
		return pins.add(p);
	}

	/**
	 * Instance Set accessor method
	 * 
	 * @return the set of all InstanceNodes connected to this device
	 */
	public List<ElaboratedInstance> getInstances() {
		return instances;
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
	 * Individual Pin Accessor method.
	 * 
	 * 
	 */
	public ElaboratedPin getPin(String pinName) {
		for (ElaboratedPin p : pins) {
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
	public List<ElaboratedPin> getPins() {
		return pins;
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
		sb.append(super.toString());

		String nameFmtStr = "  %-8s%2s%-26.26s\n";
		sb.append(String.format(nameFmtStr, "Name:", "", getName()));
		sb.append("\n");

		String attrFmtStr = "  %4d%2s%-16.16s%2s%-24.24s\n";
		String pinFmtStr = "  %4d%2s%-8.8s%2s%-16.16s%2s%-16.16s\n";
		String instFmtStr = "  %4d%2s%-16.16s%2s%-20.20s%2s%-16.16s\n";

		if (!attributes.isEmpty()) {
			sb.append("  Attr        Name                   Value           \n");
			sb.append("  ----  ----------------  -------------------------- \n");
			int attrCount = 1;
			for (ElaboratedAttribute a : attributes) {
				sb.append(String.format(attrFmtStr, attrCount, "", a.getName(), "", a.getValue()
					.equals("") ? "(empty)" : a.getValue()));
				attrCount++;
			}
			sb.append("\n");
		}

		if (!pins.isEmpty()) {
			sb.append("  Pin     Type          Name             Number      \n");
			sb.append("  ----  --------  ----------------  ---------------- \n");
			int pinCount = 1;
			for (ElaboratedPin p : pins) {
				String index = p.getIndex() == -1 ? "" : ("[" + p.getIndex() + "]");
				sb.append(String.format(pinFmtStr, pinCount, "", p.getPinType(), "", p.getName()
					+ index, "", p.getPinMapping()));
				pinCount++;
			}
			sb.append("\n");
		}

		if (!instances.isEmpty()) {
			sb.append("  Inst        Name              Location             Parent      \n");
			sb.append("  ----  ----------------  --------------------  ---------------- \n");
			int instCount = 1;
			for (ElaboratedInstance i : instances) {
				String index = ((i.getIndex() == -1) ? "" : ("(" + i.getIndex() + ")"));
				String pIndex = "";
				if (i.getParent() instanceof ElaboratedSubInstance) {
					if (((ElaboratedSubInstance) i.getParent()).getIndex() == -1)
						pIndex = "";
					else
						pIndex = ("(" + ((ElaboratedSubInstance) i.getParent()).getIndex() + ")");
				}
				sb.append(String.format(instFmtStr, instCount, "", i.getName() + index, "",
					i.getFileName() + ", " + i.getLine() + ":" + i.getPosition(), "", i.getParent()
						.getName() + pIndex));
				instCount++;
			}
			sb.append("\n");
		}

		if (!getInfo().equals("")) {
			int lineLength = 60;
			sb.append("  Info\n");
			sb.append("  ----\n");
			String info = getInfo();
			String[] infos = info.split("\\s+");
			StringBuilder line = new StringBuilder();
			line.append("  ");
			for (int i = 0; i < infos.length; i++) {
				if (line.length() < lineLength) {
					line.append(infos[i] + " ");
					if (i == infos.length - 1)
						sb.append(line.toString() + "\n");
				} else {
					i--;
					sb.append(line.toString() + "\n");
					line.setLength(0);
					line.append("  ");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
