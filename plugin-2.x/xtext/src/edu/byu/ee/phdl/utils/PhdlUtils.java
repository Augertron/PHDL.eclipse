package edu.byu.ee.phdl.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.util.Pair;

import com.thoughtworks.xstream.XStream;

import edu.byu.ee.phdl.elaboration.EDesign;
import edu.byu.ee.phdl.netlist.PhdlNetlist;
import edu.byu.ee.phdl.phdl.Indices;

public class PhdlUtils {
	public static void configureAliases(XStream xstream) {
		xstream.alias("netlist", PhdlNetlist.class);
		xstream.alias("pair", Pair.class);
		// xstream.alias("attr", EAttribute.class);
		// xstream.alias("design", EDesign.class);
		// xstream.alias("device", EDevice.class);
		// xstream.alias("inst", EInstance.class);
		// xstream.alias("net", ENet.class);
		// xstream.alias("pin", EPin.class);
		// xstream.alias("type", EPinType.class);
		// xstream.alias("port", EPort.class);
		// xstream.alias("subdesign", ESubDesign.class);
		// xstream.alias("subinst", ESubInstance.class);
	}

	public static String fileToString(String fileName) {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		try {
			try {
				br = new BufferedReader(new FileReader(fileName));
				String line = "";
				while ((line = br.readLine()) != null) {
					sb.append(line);
					sb.append("\n");
				}
			} finally {
				br.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return sb.toString();
	}

	public static EDesign getDesignFromSerialFile(String designName) {
		EDesign design = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(designName
					+ ".ser")));
			try {
				Object obj = ois.readObject();
				if (obj instanceof EDesign) {
					design = (EDesign) obj;
				}
			} finally {
				ois.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return design;
	}

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

	public static String getStringFromFile(String fileName) {
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
		}
		return sb.toString();
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

	public static boolean saveDesignToSerialFile(EDesign design) {
		boolean success = false;
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(
					design.getName() + ".ser")));
			try {
				oos.writeObject(design);
				success = true;
			} finally {
				oos.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
}
