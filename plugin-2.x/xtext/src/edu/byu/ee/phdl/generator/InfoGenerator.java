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

import org.apache.log4j.Logger;

import edu.byu.ee.phdl.elaboration.EDesign;
import edu.byu.ee.phdl.elaboration.EHierarchyUnit;
import edu.byu.ee.phdl.elaboration.EInstance;
import edu.byu.ee.phdl.elaboration.ENet;
import edu.byu.ee.phdl.elaboration.ESubInstance;

public class InfoGenerator {

	private final String info;
	private static final Logger logger = Logger.getLogger(InfoGenerator.class);

	public InfoGenerator(EDesign design) {
		StringBuilder sb = new StringBuilder();
		sb.append("Layout Supplementary Information\n");
		sb.append("--------------------------------\n\n");

		sb.append(appendDesignInfo(design, 1));
		info = sb.toString();
	}

	private StringBuilder appendDesignInfo(EHierarchyUnit des, int tabs_cnt) {
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

		for (ENet net : des.getNets()) {
			sb_des.append(appendNetInfo(net, tabs_cnt + 1) + "\n");
		}
		for (EInstance inst : des.getInstances()) {
			sb_des.append(appendInstanceInfo(inst, tabs_cnt + 1) + "\n");
		}
		for (ESubInstance sinst : des.getSubInstances()) {
			sb_des.append(appendDesignInfo(sinst, tabs_cnt + 1) + "\n");
		}

		sb_des.append(sb_tabs);
		sb_des.append(buffer);
		return sb_des;
	}

	private StringBuilder appendInstanceInfo(EInstance inst, int tabs_cnt) {
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

	private StringBuilder appendNetInfo(ENet net, int tabs_cnt) {
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

	public String getContents() {
		return info;
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
