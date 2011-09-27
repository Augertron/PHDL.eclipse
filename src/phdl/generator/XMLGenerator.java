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

package phdl.generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import phdl.graph.AttributeNode;
import phdl.graph.DesignNode;
import phdl.graph.DeviceNode;
import phdl.graph.InstanceNode;
import phdl.graph.NetNode;
import phdl.graph.PinNode;

public class XMLGenerator {

	private DesignNode design;
	private String xml;

	public XMLGenerator(DesignNode design) {
		this.design = design;
		generate();
	}

	private void generate() {
		StringBuilder sb = new StringBuilder();
		sb.append("<design>");
		sb.append("\n\t<name>" + design.getName() + "</name>");
		for (DeviceNode d : design.getDevices()) {
			sb.append("\n\t<device>");
			sb.append("\n\t\t<name>" + d.getName() + "</name>");
			for (AttributeNode a : d.getAttributes()) {
				sb.append("\n\t\t<attribute>");
				sb.append("\n\t\t\t<name>" + a.getName() + "</name>");
				sb.append("\n\t\t\t<value>" + a.getValue() + "</value>");
				sb.append("\n\t\t</attribute>");
			}
			for (PinNode p : d.getPins()) {
				sb.append("\n\t\t<pin>");
				sb.append("\n\t\t\t<name>" + p.getName() + "</name>");
				sb.append("\n\t\t\t<number>" + p.getPinName() + "</number>");
				sb.append("\n\t\t</pin>");
			}
			sb.append("\n\t</device>");
		}
		for (NetNode n : design.getNets()) {
			sb.append("\n\t<net>");
			sb.append("\n\t\t<name>" + n.getName() + "</name>");
			for (AttributeNode a : n.getAttributes()) {
				sb.append("\n\t\t<attribute>");
				sb.append("\n\t\t\t<name>" + a.getName() + "</name>");
				sb.append("\n\t\t\t<value>" + a.getValue() + "</value>");
				sb.append("\n\t\t</attribute>");
			}
			sb.append("\n\t</net>");
		}
		for (InstanceNode i : design.getInstances()) {
			sb.append("\n\t<instance>");
			sb.append("\n\t\t<name>" + i.getName() + "</name>");
			sb.append("\n\t\t<refDes>" + i.getRefDes() + "</refDes>");
			sb.append("\n\t\t<device_name>" + i.getDevice().getName() + "</device_name>");
			for (AttributeNode a : i.getAttributes()) {
				sb.append("\n\t\t<attribute>");
				sb.append("\n\t\t\t<name>" + a.getName() + "</name>");
				sb.append("\n\t\t\t<value>" + a.getValue() + "</value>");
				sb.append("\n\t\t</attribute>");
			}
			for (PinNode p : i.getPins()) {
				sb.append("\n\t\t<instPin>");
				sb.append("\n\t\t\t<name>" + p.getName() + "</name>");
				sb.append("\n\t\t\t<net>" + p.getNet().getName() + "</net>");
				sb.append("\n\t\t</instPin>");
			}
			sb.append("\n\t</instance>");
		}
		sb.append("\n</design>\n");
		xml = sb.toString();
	}

	/**
	 * Generates a .xml file containing all the design data
	 * 
	 * @param fileName
	 *            the name of the file to be written
	 */
	public void outputToFile(String fileName) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
			out.write(toString());
			out.close();
		} catch (IOException e) {
			System.err.println("File Reading Error - filename may be corrupt");
			System.exit(1);
		}
		System.out.println("Wrote xml file: " + design.getName() + ".xml");
	}

	@Override
	public String toString() {
		return xml;
	}
}
