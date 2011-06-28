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

/**
 * An abstract class that represents all reference declarations in phdl. In
 * addition to the inherited fields, a reference declaration also has a
 * reference name, binding it to its referenced device or sub design.
 * 
 * @author Richard Black and Brad Riching
 * 
 */
public abstract class RefDecl extends Arrayed {

	/**
	 * The reference declaration reference name
	 */
	protected String refName;

	/**
	 * Gets the reference declaration's reference name
	 * 
	 * @return The reference declaration's reference name
	 */
	public String getRefName() {
		return refName;
	}

	/**
	 * Sets the reference declaration's reference name
	 * 
	 * @param refName
	 *            The reference declaration's reference name
	 */
	public void setRefName(String refName) {
		this.refName = refName;
	}
}
