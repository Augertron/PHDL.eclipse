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
	protected HashSet<InstanceDeclaration> instanceDecls;
	protected HashSet<SubDesignDeclaration> subDesignDecls;
	protected HashSet<Assignment> netAssignments;

	public DesignDeclaration() {
		super();
		this.portDecls = new HashSet<PortDeclaration>();
		this.deviceDecls = new HashSet<DeviceDeclaration>();
		this.netDecls = new HashSet<NetDeclaration>();
		this.instanceDecls = new HashSet<InstanceDeclaration>();
		this.subDesignDecls = new HashSet<SubDesignDeclaration>();
		this.netAssignments = new HashSet<Assignment>();
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
		return instanceDecls;
	}

	public void addInstanceDecl(InstanceDeclaration instanceDecl) {
		instanceDecls.add(instanceDecl);
	}

	public HashSet<SubDesignDeclaration> getSubDesignDecls() {
		return subDesignDecls;
	}

	public void addSubDesignDecl(SubDesignDeclaration subDesignDecl) {
		subDesignDecls.add(subDesignDecl);
	}

	public HashSet<Assignment> getNetAssignments() {
		return netAssignments;
	}

	public void addNetAssignment(Assignment netAssignment) {
		netAssignments.add(netAssignment);
	}
}
