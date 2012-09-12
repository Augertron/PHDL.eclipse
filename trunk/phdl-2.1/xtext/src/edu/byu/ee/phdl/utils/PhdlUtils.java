package edu.byu.ee.phdl.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

import edu.byu.ee.phdl.netlist.PhdlNet;
import edu.byu.ee.phdl.netlist.PhdlNetlist;
import edu.byu.ee.phdl.netlist.PhdlPart;
import edu.byu.ee.phdl.netlist.PhdlPin;
import edu.byu.ee.phdl.phdl.Indices;

public class PhdlUtils {

	public static List<Integer> getIndices(Indices i) {
		List<Integer> indices = new ArrayList<Integer>();
		if (i.isArray()) {
			return getIndices(i.getMsb(), i.getLsb());
		} else {
			for (Integer index : i.getIndices())
				indices.add(index);
			return indices;
		}
	}

	public static List<Integer> getIndices(int msb, int lsb) {
		List<Integer> indices = new ArrayList<Integer>();
		if (msb == lsb) {
			indices.add(msb);
			return indices;
		}
		if (msb < lsb)
			for (int i = msb; i <= lsb; i++)
				indices.add(i);
		else if (msb > lsb)
			for (int i = msb; i >= lsb; i--)
				indices.add(i);
		return indices;
	}

	public static boolean isValidIndex(int msb, int lsb, int index) {
		if (msb > lsb) {
			return (msb >= index && index >= lsb);
		} else if (msb < lsb) {
			return (msb <= index && index <= lsb);
		} else {
			return index == msb;
		}
	}

	public static String readStringFromFile(String fileName) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		try {
			br = new BufferedReader(new FileReader(fileName));
			try {
				String s;
				while ((s = br.readLine()) != null) {
					sb.append(s);
					sb.append("\n");
				}
			} finally {
				br.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
		return sb.toString();
	}

	public static void setAliasesForPhdlNetlist(XStream xstream) {
		xstream.alias("netlist", PhdlNetlist.class);
		xstream.alias("part", PhdlPart.class);
		xstream.alias("net", PhdlNet.class);
		xstream.alias("pin", PhdlPin.class);
	}

	public static boolean writeStringToFile(String fileName, String content) {
		boolean success = false;
		BufferedWriter br = null;
		try {
			br = new BufferedWriter(new FileWriter(fileName));
			try {
				br.write(content);
				success = true;
			} finally {
				br.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
}
