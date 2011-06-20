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

package phdl.designer;

import java.util.HashSet;
import java.util.Iterator;

public class PHDLSubDesign {

	private String instanceName;
	private String designName;
	private HashSet<PHDLAssignment> portAssignments;
	private int msb;
	private int lsb;
	private int line;
	private int pos;

	public PHDLSubDesign(String instanceName, String designName, int msb,
			int lsb, int line, int pos) {
		this.instanceName = instanceName;
		this.designName = designName;
		this.msb = msb;
		this.lsb = lsb;
		this.line = line;
		this.pos = pos;
		this.portAssignments = new HashSet<PHDLAssignment>();
	}

	public int getMsb() {
		return msb;
	}

	public int getLsb() {
		return lsb;
	}

	public int getLine() {
		return line;
	}

	public int getPos() {
		return pos;
	}

	public void setMsb(int msb) {
		this.msb = msb;
	}

	public void setLsb(int lsb) {
		this.lsb = lsb;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public String getInstanceName() {
		return instanceName;
	}

	public String getDesignName() {
		return designName;
	}

	public HashSet<PHDLAssignment> getPortAssignments() {
		return portAssignments;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public void setDesignName(String designName) {
		this.designName = designName;
	}

	public void addPortAssignment(PHDLAssignment a) {
		portAssignments.add(a);
	}

	@Override
	public String toString() {

		String instanceString = "PHDLInstance[" + line + ":" + pos + "]: "
				+ instanceName + ": " + designName + " [" + msb + ":" + lsb
				+ "]\n";

		String portsString = "";

		Iterator<PHDLAssignment> aIterator = portAssignments.iterator();
		while (aIterator.hasNext())
			portsString += "\t\tPHDLPortAssignment"
					+ aIterator.next().toString();

		return instanceString + portsString;
	}
}
