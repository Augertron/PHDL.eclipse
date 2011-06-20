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

import java.util.LinkedList;

/**
 * An abstract class that represents a concatenation assignment in phdl. In
 * addition to inherited fields, a concatenation assignment has a list of nets
 * to be concatenated.
 * 
 * @author Richard Black and Brad Riching
 * 
 */
public abstract class ConcatenationAssignment extends Assignable {

	/**
	 * This concatenation assignment's list of nets
	 */
	protected LinkedList<Net> nets;

	/**
	 * Gets this concatenation assignment's list of nets
	 * 
	 * @return This concatenation assignment's list of nets
	 */
	public LinkedList<Net> getNets() {
		return nets;
	}

	/**
	 * Adds a net to this concatenation assignment's list of nets
	 * 
	 * @param net
	 *            The net to add
	 */
	public void addNet(Net net) {
		nets.add(net);
	}
}
