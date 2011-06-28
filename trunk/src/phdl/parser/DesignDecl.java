/*
 * Copyright (C) 2011 BYU Configurable Computing Lab
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */

package phdl.parser;

import java.util.HashSet;
import java.util.Set;

/**
 * A class that represents a design declaration in phdl. In addition to
 * inherited fields, a design has a set of port declarations, a set of device
 * declarations, a set of net declarations, a set of instance declarations, a
 * set of sub declarations and a set of net assignments.
 * 
 * @author Richard Black and Brad Riching
 * 
 */
public class DesignDecl extends Parsable {

	/**
	 * The design declaration's set of port declarations
	 */
	protected Set<PortDecl> portDecls;
	/**
	 * The design declaration's set of device declarations
	 */
	protected Set<DeviceDecl> deviceDecls;
	/**
	 * The design declaration's set of net declarations
	 */
	protected Set<NetDecl> netDecls;
	/**
	 * The design declaration's set of instance declarations
	 */
	protected Set<InstDecl> instDecls;
	/**
	 * The design declaration's set of sub-design declarations
	 */
	protected Set<SubDecl> subDecls;
	/**
	 * The design declaration's set of net assignments
	 */
	protected HashSet<NetAssign> netAssigns;

	/**
	 * Default constructor
	 */
	public DesignDecl() {
		super();
		this.portDecls = new HashSet<PortDecl>();
		this.deviceDecls = new HashSet<DeviceDecl>();
		this.netDecls = new HashSet<NetDecl>();
		this.instDecls = new HashSet<InstDecl>();
		this.subDecls = new HashSet<SubDecl>();
		this.netAssigns = new HashSet<NetAssign>();
	}

	/**
	 * Gets this design declaration's set of port declarations
	 * 
	 * @return This design declaration's set of port declarations
	 */
	public Set<PortDecl> getPortDecls() {
		return portDecls;
	}

	/**
	 * Adds a port declaration to this design's set of port declarations
	 * 
	 * @param portDecl
	 *            The port declaration to add
	 * 
	 * @return true if the port declaration was added successfully
	 */
	public boolean addPortDecl(PortDecl portDecl) {
		return portDecls.add(portDecl);
	}

	/**
	 * Gets this design declaration's set of device declarations
	 * 
	 * @return This design declaration's set of device declarations
	 */
	public Set<DeviceDecl> getDeviceDecls() {
		return deviceDecls;
	}

	/**
	 * Adds a device declaration to this design's set of device declarations
	 * 
	 * @param devDecl
	 *            The device declaration to add
	 * 
	 * @return true if the device declaration was added successfully
	 */
	public boolean addDeviceDecl(DeviceDecl devDecl) {
		return deviceDecls.add(devDecl);
	}

	/**
	 * Gets this design declaration's set of net declarations
	 * 
	 * @return This design declaration's set of net declarations
	 */
	public Set<NetDecl> getNetDecls() {
		return netDecls;
	}

	/**
	 * Adds a net declaration to this design's set of net declarations
	 * 
	 * @param netDecl
	 *            The net declaration to add
	 * 
	 * @return true if the net declaration was added successfully
	 */
	public boolean addNetDecl(NetDecl netDecl) {
		return netDecls.add(netDecl);
	}

	/**
	 * Gets this design declaration's set of instance declarations
	 * 
	 * @return This design declaration's set of instance declarations
	 */
	public Set<InstDecl> getInstDecls() {
		return instDecls;
	}

	/**
	 * Adds an instance declaration to this design's set of of instance
	 * declarations
	 * 
	 * @param instDecl
	 *            The instance declaration to add
	 * 
	 * @return true if the instance declaration was added successfully
	 */
	public boolean addInstDecl(InstDecl instDecl) {
		return instDecls.add(instDecl);
	}

	/**
	 * Gets this design declaration's set of sub-design declarations
	 * 
	 * @return This design declaration's set of sub-design declarations
	 */
	public Set<SubDecl> getSubDecls() {
		return subDecls;
	}

	/**
	 * Adds a sub-design declaration to this design's set of sub-design
	 * declarations
	 * 
	 * @param subDecl
	 *            The sub-design declaration to add
	 * 
	 * @return true if the sub-design was added successfully
	 */
	public boolean addSubDecl(SubDecl subDecl) {
		return subDecls.add(subDecl);
	}

	/**
	 * Gets this design declaration's set of net assignments
	 * 
	 * @return This design declaration's set of net assignments
	 */
	public Set<NetAssign> getNetAssigns() {
		return netAssigns;
	}

	/**
	 * Adds a net assignment declaration to this design's set of net assignment
	 * declarations
	 * 
	 * @param netAssign
	 *            The net assignment declaration to add
	 * 
	 * @return true if the net assignment was added successfully
	 */
	public boolean addNetAssign(NetAssign netAssign) {
		return netAssigns.add(netAssign);
	}

	/**
	 * Defines overridden hashCode method
	 */
	@Override
	public int hashCode() {
		return name.hashCode();
	}

	/**
	 * Defines overridden equals method
	 */
	@Override
	public boolean equals(Object o) {
		return name.equals(((DesignDecl) o).getName());
	}

	/**
	 * Returns a formatted string representation of the design declaration
	 */
	@Override
	public String toString() {
		String sourceFile = "---------------------------------------- "
				+ getFileName()
				+ " -----------------------------------------\n";
		String header = "DesignDecl " + getLocation() + " : " + name + "\n";
		String ports = "";
		String devices = "";
		String nets = "";
		String instances = "";
		String subs = "";
		String assigns = "";

		// loop over all port declarations
		for (PortDecl p : portDecls)
			ports += "\t" + p.toString();

		// loop over all device declarations
		for (DeviceDecl d : deviceDecls)
			devices += "\t" + d.toString();

		// loop over all net declarations
		for (NetDecl n : netDecls)
			nets += "\t" + n.toString();

		// loop over all instance declarations
		for (InstDecl i : instDecls)
			instances += "\t" + i.toString();

		// loop over all sub-design declarations
		for (SubDecl s : subDecls)
			subs += "\t" + s.toString();

		// loop over all net assignments
		for (NetAssign n : netAssigns)
			assigns += "\t" + n.toString();

		return sourceFile + header + ports + devices + nets + instances + subs
				+ assigns;
	}

	/**
	 * Method to find a particular device declaration based on the name passed
	 * in.
	 * 
	 * @param name
	 *            The name of the device declaration
	 * @return The device declaration with this name, or null if it doesn't
	 *         exist in the set.
	 */
	public DeviceDecl findDevDecl(String name) {
		for (DeviceDecl d : deviceDecls) {
			if (d.getName().equals(name))
				return d;
		}
		return null;
	}

	/**
	 * Method to find a particular net declaration based on the name passed in.
	 * 
	 * @param name
	 *            The name of the net declaration
	 * @return The device declaration with this name, or null if it doesn't
	 *         exist in the set.
	 */
	public NetDecl findNetDecl(String name) {
		for (NetDecl n : netDecls) {
			if (n.getName().equals(name))
				return n;
		}
		return null;
	}

	/**
	 * Method to tell whether a particular instance in the design is declared
	 * 
	 * @param i
	 *            The instance declaration to be checked
	 * @return True if the instance has been declared, false otherwise.
	 */
	public boolean isDeclared(InstDecl i) {
		DeviceDecl d = findDevDecl(i.getRefName());
		if (d != null)
			return true;
		else
			return false;
	}
}
