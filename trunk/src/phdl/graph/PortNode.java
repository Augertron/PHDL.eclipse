/*
    Copyright (C) 2011  BYU Configurable Computing Lab

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package phdl.graph;

/**
 * This class will represent a Port in PHDL.
 * 
 * This has yet to be implemented.
 * 
 * @author Brad Riching and Richard Black
 * @version 0.l
 *
 */
public class PortNode extends Node {
	
	private NetNode net;

	/**
	 * Default Constructor.
	 */
	public PortNode() {

	}

	/**
	 * NetNode accessor method.
	 * 
	 * @return		the NetNode connected to this port
	 */
	public NetNode getNet() {
		return net;
	}

	/**
	 * NetNode mutator method.
	 * 
	 * @param net	the new NetNode to connect to this port
	 */
	public void setNet(NetNode net) {
		this.net = net;
	}

	@Override
	/**
	 * Type accessor method.
	 * 
	 * @return NodeType.PORT
	 */
	public NodeType getType() {
		return NodeType.PORT;
	}

}
