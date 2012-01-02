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
import java.util.ArrayList;
import java.util.List;

import phdl.graph.Design;
import phdl.graph.Instance;

public class InfoGenerator {

	String info;
	Design design;
	
	public InfoGenerator(Design design) {
		this.design = design;
		StringBuilder sb = new StringBuilder();
		sb.append("Design " + design.getName() + " Info\n" + design.getInfo() + "\n\n");
		List<String> visited = new ArrayList<String>();
		for (Instance i : design.getInstances()) {
			if (!visited.contains(i.getInfo())) {
				visited.add(i.getInfo());
				int pos = i.getName().indexOf('(');
				if (pos == -1) pos = i.getName().length(); 
				sb.append("\nInstance " + i.getName().substring(0,pos) + " Info\n" + i.getInfo() + "\n");
			}
		}
		info = sb.toString();
	}
	
	public String getInfo() {
		return info;
	}
	
	/**
	 * Generates a .info file containing all the info structures
	 * 
	 * @param fileName
	 *            the name of the file to be written
	 */
	public void outputToFile(String fileName) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
			out.write(info);
			out.close();
		} catch (IOException e) {
			System.err.println("File Reading Error - filename may be corrupt");
			System.exit(1);
		}
		System.out.println("Wrote info file: " + design.getName() + ".info");
	}
	
}
