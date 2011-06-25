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

public class SubAttrAssign extends AttrAssign {

	protected String instName;

	public SubAttrAssign() {
		super();
	}

	public String getInstName() {
		return instName;
	}

	public void setInstName(String instName) {
		this.instName = instName;
	}

	/**
	 * Defines overridden equals method
	 */
	@Override
	public boolean equals(Object o) {
		return name.equals(((SubAttrAssign) o).getName())
				&& msb == ((SubAttrAssign) o).getMsb()
				&& lsb == ((SubAttrAssign) o).getLsb()
				&& index == ((SubAttrAssign) o).getIndex()
				&& indices.equals(((SubAttrAssign) o).getIndices())
				&& instName.equals(((SubAttrAssign) o).getInstName());
	}

	/**
	 * Returns a formatted string representation of the attribute assignment
	 */
	@Override
	public String toString() {
		return "SubAttrAssign " + getLocation() + " : " + instName + "." + name
				+ getSlicesString() + " = " + value + "\n";
	}
}
