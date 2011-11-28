/*
    Copyright (C) 2011  Brigham Young University

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, version 3.

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
	private PinNode pin;

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
	
	/**
	 * PinNode accessor method
	 * 
	 * @return		the PinNode connected to this port
	 */
	public PinNode getPin() {
		return pin;
	}
	
	/**
	 * PinNode mutator method
	 * 
	 * @param pin	the new PinNode to connect to this port
	 */
	public void setPin(PinNode pin) {
		this.pin = pin;
	}
	
	/**
	 * Checks to see if the port is connected to a pin
	 * 
	 * @return	true, if the port is connected to a pin
	 * 			false, otherwise
	 */
	public boolean isPinConnected() {
		return (pin!=null);
	}
	
	/**
	 * Checks to see if the port is connected to a net
	 * 
	 * @return	true, if the port is connected to a net
	 * 			false, otherwise
	 */
	public boolean isNetConnected() {
		return (net!=null);
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
