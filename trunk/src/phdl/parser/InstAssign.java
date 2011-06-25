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

public abstract class InstAssign extends ConcatAssign {

	protected int instMsb = -1;
	protected int instLsb = -1;
	protected int instIndex = -1;
	protected String instIndices = null;

	public int getInstMsb() {
		return instMsb;
	}

	public void setInstMsb(int instMsb) {
		this.instMsb = instMsb;
	}

	public int getInstLsb() {
		return instLsb;
	}

	public void setInstLsb(int instLsb) {
		this.instLsb = instLsb;
	}

	public int getInstIndex() {
		return instIndex;
	}

	public void setInstIndex(int instIndex) {
		this.instIndex = instIndex;
	}

	public String getInstIndices() {
		return instIndices;
	}

	public void setInstIndices(String instIndices) {
		this.instIndices = instIndices;
	}
}
