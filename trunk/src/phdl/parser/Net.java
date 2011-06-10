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

public class Net extends Element {

	protected String name;
	protected int msb = -1;
	protected int lsb = -1;
	protected int index = -1;

	public String getName() {
		return name;
	}

	public int getMsb() {
		return msb;
	}

	public int getLsb() {
		return lsb;
	}

	public int getIndex() {
		return index;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMsb(int msb) {
		this.msb = msb;
	}

	public void setLsb(int lsb) {
		this.lsb = lsb;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Net(String name) {
		this.name = name;
	}
}
