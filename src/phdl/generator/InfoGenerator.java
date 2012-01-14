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

import phdl.graph.Design;
import phdl.graph.Instance;

public class InfoGenerator {

	String info;
	Design design;

	public InfoGenerator(Design design) {
		int i;
		this.design = design;
		StringBuilder sb_des = new StringBuilder();
		sb_des.append("Design " + design.getName() + "\n");
		//System.out.println(sb_des.length() + "");

		String buffer = "";
		for (i = 0; i < sb_des.length(); i++) {
			buffer += '-';
		}
		sb_des.append(buffer);
		sb_des.append("\n");

		if (!design.getInfo().equals("")) {
			sb_des.append(design.getInfo());
			sb_des.append("\n");
		}
		sb_des.append("\n");

		for (Instance inst : design.getInstances()) {
			int j;
			if (!inst.getInfo().trim().equals("")) {
				StringBuilder sb_inst = new StringBuilder("Instance " + inst.getName() + "\n");

				String bufferI = "";
				for (j = 0; j < sb_inst.length(); j++) {
					bufferI += "-";
				}
				sb_inst.append(bufferI + "\n");

				sb_inst.append(inst.getInfo() + "\n");

				sb_inst.append(bufferI + "\n");
				sb_des.append(sb_inst.toString() + "\n");
			}
		}

		sb_des.append(buffer);

		info = sb_des.toString();
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

	public static boolean unitTest() {
		boolean success = true;
		Design testDesign1 = new Design();
		testDesign1.setName("testDesign1");
		testDesign1.appendInfo("Lorem ipsum dolor sit amet.");

		Instance testInst1 = new Instance(testDesign1);
		testInst1.setName("testInst1");
		testInst1.appendInfo("Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
			+ "Praesent viverra dolor at risus faucibus in dictum nisl dapibus. "
			+ "Vestibulum vitae tortor non diam consequat venenatis quis sed eros. "
			+ "Donec eget sapien velit, at varius risus. In elementum urna a leo"
			+ "vulputate iaculis. Duis eu lectus orci. Suspendisse potenti. Mauris"
			+ "sollicitudin fringilla sapien, sodales ullamcorper nulla euismod vel. "
			+ "Sed in imperdiet neque.");
		testDesign1.addInstance(testInst1);

		Instance testInst2 = new Instance(testDesign1);
		testInst2.setName("testInst2");
		testInst2.appendInfo("Ut laoreet hendrerit ligula, eu interdum neque tincidunt dapibus. In"
			+ "et turpis at lacus lobortis ultricies. Nam sollicitudin sapien eu nisi"
			+ "facilisis commodo. Nullam ullamcorper gravida sapien, tempor iaculis"
			+ "massa dignissim ac. Nunc iaculis dolor et orci pellentesque at convallis"
			+ "orci porttitor. Ut sit amet magna a magna imperdiet tincidunt id et"
			+ "libero. Nullam id tellus vitae odio convallis ultrices.");
		testDesign1.addInstance(testInst2);

		InfoGenerator infoGen = new InfoGenerator(testDesign1);
		infoGen.outputToFile("testinfo1.info");

		return success;
	}
}
