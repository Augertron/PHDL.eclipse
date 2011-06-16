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

/**
 * A class that represents a design declaration in phdl. In addition to
 * inherited fields, a design has a set of port declarations, a set of device
 * declarations, a set of net declarations, a set of instance declarations, a
 * set of sub declarations and a set of net assignments.
 * 
 * @author Richard Black and Brad Riching
 * 
 */
public class DesignDeclaration extends Declarable {

	/**
	 * The design declaration's set of port declarations
	 */
	protected HashSet<PortDeclaration> portDecls;
	/**
	 * The design declaration's set of device declarations
	 */
	protected HashSet<DeviceDeclaration> deviceDecls;
	/**
	 * The design declaration's set of net declarations
	 */
	protected HashSet<NetDeclaration> netDecls;
	/**
	 * The design declaration's set of instance declarations
	 */
	protected HashSet<InstanceDeclaration> instDecls;
	/**
	 * The design declaration's set of sub-design declarations
	 */
	protected HashSet<SubDesignDeclaration> subDecls;
	/**
	 * The design declaration's set of net assignments
	 */
	protected HashSet<NetAssignment> netAssigns;

	/**
	 * Default constructor
	 */
	public DesignDeclaration() {
		super();
		this.portDecls = new HashSet<PortDeclaration>();
		this.deviceDecls = new HashSet<DeviceDeclaration>();
		this.netDecls = new HashSet<NetDeclaration>();
		this.instDecls = new HashSet<InstanceDeclaration>();
		this.subDecls = new HashSet<SubDesignDeclaration>();
		this.netAssigns = new HashSet<NetAssignment>();
	}

	/**
	 * Gets this design declaration's set of port declarations
	 * 
	 * @return This design declaration's set of port declarations
	 */
	public HashSet<PortDeclaration> getPortDecls() {
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
	public boolean addPortDecl(PortDeclaration portDecl) {
		boolean added = portDecls.add(portDecl);
		return added;
	}

	/**
	 * Gets this design declaration's set of device declarations
	 * 
	 * @return This design declaration's set of device declarations
	 */
	public HashSet<DeviceDeclaration> getDeviceDecls() {
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
	public boolean addDeviceDecl(DeviceDeclaration devDecl) {
		boolean added = deviceDecls.add(devDecl);
		return added;
	}

	/**
	 * Gets this design declaration's set of net declarations
	 * 
	 * @return This design declaration's set of net declarations
	 */
	public HashSet<NetDeclaration> getNetDecls() {
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
	public boolean addNetDecl(NetDeclaration netDecl) {
		boolean added = netDecls.add(netDecl);
		return added;
	}

	/**
	 * Gets this design declaration's set of instance declarations
	 * 
	 * @return This design declaration's set of instance declarations
	 */
	public HashSet<InstanceDeclaration> getInstanceDecls() {
		return instDecls;
	}

	/**
	 * Adds an instance declaration to this design's set of of instance
	 * declarations
	 * 
	 * @param instanceDecl
	 *            The instance declaration to add
	 * 
	 * @return true if the instance declaration was added successfully
	 */
	public boolean addInstanceDecl(InstanceDeclaration instanceDecl) {
		boolean added = instDecls.add(instanceDecl);
		return added;
	}

	/**
	 * Gets this design declaration's set of sub-design declarations
	 * 
	 * @return This design declaration's set of sub-design declarations
	 */
	public HashSet<SubDesignDeclaration> getSubDesignDecls() {
		return subDecls;
	}

	/**
	 * Adds a sub-design declaration to this design's set of sub-design
	 * declarations
	 * 
	 * @param subDesignDecl
	 *            The sub-design declaration to add
	 * 
	 * @return true if the sub-design was added successfully
	 */
	public boolean addSubDesignDecl(SubDesignDeclaration subDesignDecl) {
		boolean added = subDecls.add(subDesignDecl);
		return added;
	}

	/**
	 * Gets this design declaration's set of net assignments
	 * 
	 * @return This design declaration's set of net assignments
	 */
	public HashSet<NetAssignment> getNetAssignments() {
		return netAssigns;
	}

	/**
	 * Adds a net assignment declaration to this design's set of net assignment
	 * declarations
	 * 
	 * @param netAssignment
	 *            The net assignment declaration to add
	 * 
	 * @return true if the net assignment was added successfully
	 */
	public boolean addNetAssignment(NetAssignment netAssignment) {
		boolean added = netAssigns.add(netAssignment);
		return added;
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
		return name.equals(((DesignDeclaration) o).getName());
	}

	/**
	 * Returns a formatted string representation of the design declaration
	 */
	@Override
	public String toString() {
		String sourceFile = "---------------------------------------- "
				+ getFileName()
				+ " -----------------------------------------\n";
		String header = "DesignDecl " + getLineString() + " : " + name + "\n";
		String ports = "";
		String devices = "";
		String nets = "";
		String instances = "";
		String subs = "";
		String assigns = "";

		// loop over all port declarations
		for (PortDeclaration p : portDecls)
			ports += "\t" + p.toString();

		// loop over all device declarations
		for (DeviceDeclaration d : deviceDecls)
			devices += "\t" + d.toString();

		// loop over all net declarations
		for (NetDeclaration n : netDecls)
			nets += "\t" + n.toString();

		// loop over all instance declarations
		for (InstanceDeclaration i : instDecls)
			instances += "\t" + i.toString();

		// loop over all sub-design declarations
		for (SubDesignDeclaration s : subDecls)
			subs += "\t" + s.toString();

		// loop over all net assignments
		for (NetAssignment n : netAssigns)
			assigns += "\t" + n.toString();

		return sourceFile + header + ports + devices + nets + instances + subs
				+ assigns;
	}
}
