/*
 * Copyright (C) 2011 Brigham Young University
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, version 3.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program. If
 * not, see <http://www.gnu.org/licenses/>.
 */

package edu.byu.ee.phdl.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import edu.byu.ee.phdl.elaboration.ElaboratedDesign;
import edu.byu.ee.phdl.elaboration.ElaboratedHierarchyUnit;
import edu.byu.ee.phdl.elaboration.ElaboratedInstance;
import edu.byu.ee.phdl.elaboration.ElaboratedNet;
import edu.byu.ee.phdl.elaboration.ElaboratedSubInstance;

public class InfoGenerator {

	public static boolean unitTest() {
		boolean success = true;
		ElaboratedDesign testDesign1 = new ElaboratedDesign();
		testDesign1.setName("test1");
		testDesign1.appendInfo("Lorem ipsum dolor sit amet.");

		ElaboratedInstance testInst1 = new ElaboratedInstance(testDesign1);
		testInst1.setName("testInst1");
		testInst1.appendInfo("Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Praesent viverra dolor at risus faucibus in dictum nisl dapibus. "
				+ "Vestibulum vitae tortor non diam consequat venenatis quis sed eros. "
				+ "Donec eget sapien velit, at varius risus. In elementum urna a leo "
				+ "vulputate iaculis. Duis eu lectus orci. Suspendisse potenti. Mauris "
				+ "sollicitudin fringilla sapien, sodales ullamcorper nulla euismod vel. " + "Sed in imperdiet neque.");
		testDesign1.addInstance(testInst1);

		ElaboratedInstance testInst2 = new ElaboratedInstance(testDesign1);
		testInst2.setName("testInst2");
		testInst2.appendInfo("Ut laoreet hendrerit ligula, eu interdum neque tincidunt dapibus. In "
				+ "et turpis at lacus lobortis ultricies. Nam sollicitudin sapien eu nisi "
				+ "facilisis commodo. Nullam ullamcorper gravida sapien, tempor iaculis "
				+ "massa dignissim ac. Nunc iaculis dolor et orci pellentesque at convallis "
				+ "orci porttitor. Ut sit amet magna a magna imperdiet tincidunt id et "
				+ "libero. Nullam id tellus vitae odio convallis ultrices.");
		testDesign1.addInstance(testInst2);

		ElaboratedNet testNet1 = new ElaboratedNet(testDesign1);
		testNet1.setName("testNet1");
		testNet1.appendInfo("Leo pretium. Felis sit. Sed culpa eu neque tellus ipsum adipiscing, "
				+ "pellentesque turpis ac. Tortor sed mattis tortor felis adipiscing, urna mauris "
				+ "mauris, cursus duis, porta condimentum.");
		testDesign1.addConnection(testNet1);

		ElaboratedSubInstance subInst1 = new ElaboratedSubInstance(testDesign1, "subInst1");
		subInst1.appendInfo("Nec dictum nec eget ipsum aenean nulla, lacus nunc diam ipsum "
				+ "vel luctus, vel non amet. Praesent pellentesque quis. Auctor et sed "
				+ "pellentesque libero integer. Donec mauris non urna iaculis ac, dolor "
				+ "taciti blandit sagittis eleifend vel leo. Est gravida lorem, cras praesent "
				+ "vestibulum litora, suscipit magna ligula suspendisse lobortis varius, nulla "
				+ "tempus eaque ipsum lobortis. Vitae feugiat vulputate euismod ac lectus "
				+ "bibendum, id turpis tempor amet, ut et accumsan, a sit morbi magnis vel duis.");
		ElaboratedInstance testInst3 = new ElaboratedInstance(subInst1);
		testInst3.setName("testInst3");
		testInst3.appendInfo("Consectetuer aliquet sollicitudin et, aliquam orci velit mollis "
				+ "suspendisse mus. Tincidunt faucibus natoque. Purus tortor pellentesque amet, sed "
				+ "sit, odio vulputate. Cras repellat malesuada ut posuere, feugiat pellentesque "
				+ "vestibulum risus, arcu pellentesque. Turpis quis neque dictum, aliquam id bibendum "
				+ "vivamus ut aliquam dignissim, ridiculus nec orci interdum donec, in lorem.");
		subInst1.addInstance(testInst3);

		testDesign1.addSubInst(subInst1);

		InfoGenerator infoGen = new InfoGenerator(testDesign1);
		infoGen.outputToFile("TestsOutput/InfoOutput/" + testDesign1.getName() + ".info");

		return success;
	}

	String info;

	ElaboratedDesign design;

	public InfoGenerator(ElaboratedDesign design) {
		this.design = design;
		StringBuilder sb = new StringBuilder();
		sb.append("Layout Supplementary Information\n");
		sb.append("--------------------------------\n\n");

		sb.append(appendDesignInfo(design, 1));
		info = sb.toString();
	}

	public String getContents() {
		return info;
	}

	/**
	 * Generates a .info file containing all the info structures
	 * 
	 * @param fileName the name of the file to be written
	 */
	public void outputToFile(String fileName) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
			out.write(info);
			out.close();
		} catch (IOException e) {
			System.err.println();
			System.err.println("File Reading Error - filename may be corrupt");
			System.exit(1);
		}
		System.out.println("  -- Generated: " + File.separator + fileName);
	}

	private StringBuilder appendDesignInfo(ElaboratedHierarchyUnit des, int tabs_cnt) {
		StringBuilder sb_des = new StringBuilder();

		StringBuilder sb_tabs = new StringBuilder();
		for (int i = 0; i < tabs_cnt; i++) {
			sb_tabs.append("\t");
		}
		sb_des.append(sb_tabs);
		sb_des.append(des.getNodeType().toString() + " " + des.getName() + "\n");

		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < sb_des.length() - 1; i++) {
			buffer.append('-');
		}
		sb_des.append(sb_tabs);
		sb_des.append(buffer);
		sb_des.append("\n");

		if (!des.getInfo().equals("")) {
			sb_des.append(sb_tabs);
			sb_des.append(wordWrap(des.getInfo(), sb_tabs));
			sb_des.append("\n");
		}
		sb_des.append("\n");

		for (ElaboratedNet net : des.getNets()) {
			sb_des.append(appendNetInfo(net, tabs_cnt + 1) + "\n");
		}
		for (ElaboratedInstance inst : des.getInstances()) {
			sb_des.append(appendInstanceInfo(inst, tabs_cnt + 1) + "\n");
		}
		for (ElaboratedSubInstance sinst : des.getSubInstances()) {
			sb_des.append(appendDesignInfo(sinst, tabs_cnt + 1) + "\n");
		}

		sb_des.append(sb_tabs);
		sb_des.append(buffer);
		return sb_des;
	}

	private StringBuilder appendInstanceInfo(ElaboratedInstance inst, int tabs_cnt) {
		int j;
		StringBuilder sb_inst = new StringBuilder();

		StringBuilder sb_tabs = new StringBuilder();
		for (int i = 0; i < tabs_cnt; i++) {
			sb_tabs.append("\t");
		}

		if (!inst.getInfo().trim().equals("")) {
			sb_inst.append(sb_tabs);
			sb_inst.append("INSTANCE " + inst.getName() + "\n");

			String bufferI = "";
			for (j = 0; j < sb_inst.length(); j++) {
				bufferI += "-";
			}
			sb_inst.append(sb_tabs);
			sb_inst.append(bufferI + "\n");

			sb_inst.append(sb_tabs);
			sb_inst.append(wordWrap(inst.getInfo(), sb_tabs) + "\n");

			sb_inst.append(sb_tabs);
			sb_inst.append(bufferI + "\n");
		}
		return sb_inst;
	}

	private StringBuilder appendNetInfo(ElaboratedNet net, int tabs_cnt) {
		int j;
		StringBuilder sb_net = new StringBuilder();

		StringBuilder sb_tabs = new StringBuilder();
		for (int i = 0; i < tabs_cnt; i++) {
			sb_tabs.append("\t");
		}

		if (!net.getInfo().trim().equals("")) {
			sb_net.append(sb_tabs);
			sb_net.append("NET " + net.getName() + "\n");

			String bufferI = "";
			for (j = 0; j < sb_net.length(); j++) {
				bufferI += "-";
			}
			sb_net.append(sb_tabs);
			sb_net.append(bufferI + "\n");

			sb_net.append(sb_tabs);
			sb_net.append(wordWrap(net.getInfo(), sb_tabs) + "\n");

			sb_net.append(sb_tabs);
			sb_net.append(bufferI + "\n");
		}

		return sb_net;
	}

	private StringBuilder wordWrap(String info, StringBuilder sb_tabs) {
		int length = info.length();
		String[] words = info.split(" ");
		int char_count_max = 60;
		int char_count = 0;

		StringBuilder sb_wrap = new StringBuilder();
		for (int i = 0; i < words.length; i++) {
			if (char_count >= char_count_max) {
				char_count = 0;
				sb_wrap.append("\n");
				sb_wrap.append(sb_tabs);
			}
			sb_wrap.append(words[i] + " ");
			char_count += words[i].length() + 1;
		}
		return sb_wrap;
	}
}
