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

public class DesignDeclaration extends Declaration {

	protected HashSet<PortDeclaration> portDecls;
	protected HashSet<DeviceDeclaration> deviceDecls;
	protected HashSet<NetDeclaration> netDecls;
	protected HashSet<InstanceDeclaration> instDecls;
	protected HashSet<SubDesignDeclaration> subDecls;
	protected HashSet<NetAssignment> netAssigns;

	public DesignDeclaration() {
		super();
		this.portDecls = new HashSet<PortDeclaration>();
		this.deviceDecls = new HashSet<DeviceDeclaration>();
		this.netDecls = new HashSet<NetDeclaration>();
		this.instDecls = new HashSet<InstanceDeclaration>();
		this.subDecls = new HashSet<SubDesignDeclaration>();
		this.netAssigns = new HashSet<NetAssignment>();
	}

	public HashSet<PortDeclaration> getPortDecls() {
		return portDecls;
	}

	public void addPortDecl(PortDeclaration portDecl) {
		portDecls.add(portDecl);
	}

	public HashSet<DeviceDeclaration> getDeviceDecls() {
		return deviceDecls;
	}

	public void addDeviceDecl(DeviceDeclaration devDecl) {
		deviceDecls.add(devDecl);
	}

	public HashSet<NetDeclaration> getNetDecls() {
		return netDecls;
	}

	public void addNetDecl(NetDeclaration netDecl) {
		netDecls.add(netDecl);
	}

	public HashSet<InstanceDeclaration> getInstanceDecls() {
		return instDecls;
	}

	public void addInstanceDecl(InstanceDeclaration instanceDecl) {
		instDecls.add(instanceDecl);
	}

	public HashSet<SubDesignDeclaration> getSubDesignDecls() {
		return subDecls;
	}

	public void addSubDesignDecl(SubDesignDeclaration subDesignDecl) {
		subDecls.add(subDesignDecl);
	}

	public HashSet<NetAssignment> getNetAssignments() {
		return netAssigns;
	}

	public void addNetAssignment(NetAssignment netAssignment) {
		netAssigns.add(netAssignment);
	}

	@Override
	public String toString() {
		String header = "DesignDecl" + getLocation() + ": " + name + "\n";
		String ports = "";
		String devices = "";
		String nets = "";
		String instances = "";
		String subs = "";
		String assigns = "";

		for (PortDeclaration p : portDecls)
			ports += "\t" + p.toString();

		for (DeviceDeclaration d : deviceDecls)
			devices += "\t" + d.toString();

		for (NetDeclaration n : netDecls)
			nets += "\t" + n.toString();

		for (InstanceDeclaration i : instDecls)
			instances += "\t" + i.toString();

		for (SubDesignDeclaration s : subDecls)
			subs += "\t" + s.toString();

		for (NetAssignment n : netAssigns)
			assigns += "\t" + n.toString();

		return header + ports + devices + nets + instances + subs + assigns;
	}
}
