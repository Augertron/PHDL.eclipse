package edu.byu.ee.phdl.utils;

import java.util.ArrayList;
import java.util.List;

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

}
