/*
 * Copyright (C) 2011 Brigham Young University This program is free software: you can redistribute
 * it and/or modify it under the terms of the GNU General Public License as published by the Free
 * Software Foundation, version 3. This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received
 * a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package edu.byu.ee.phdl.generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import edu.byu.ee.phdl.elaboration.EDesign;
import edu.byu.ee.phdl.elaboration.EHierarchyUnit;
import edu.byu.ee.phdl.elaboration.EInstance;
import edu.byu.ee.phdl.elaboration.ESubInstance;

/**
 * A class that generates a Reference Designator mapping and file.
 * 
 * @author Brad Riching and Richard Black
 * @version 0.1
 * 
 */
public class RefDesGenerator {

	private static final Logger logger = Logger.getLogger(RefDesGenerator.class);
	private final Map<String, EInstance> refMap;
	private final boolean flag;
	private final int max_index = 100000;

	/**
	 * Default Constructor.
	 * 
	 * Takes an EDesign and generates the Reference Designator mapping.
	 * 
	 * @param design
	 *            the DesignNode that contains the InstanceNode information.
	 * 
	 * @see EDesign
	 */
	public RefDesGenerator(EDesign design) {
		this.refMap = new TreeMap<String, EInstance>();
		this.flag = false;
		generate_pass_1(design);
		generate_pass_2(design);
	}

	public RefDesGenerator(EDesign design, boolean flag) {
		this.refMap = new TreeMap<String, EInstance>();
		this.flag = flag;
		generate_pass_1(design);
		generate_pass_2(design);
	}

	public String getContents() {
		StringBuilder sb = new StringBuilder();
		Set<String> refs = refMap.keySet();
		for (String s : refs) {
			sb.append(refMap.get(s).getRefDes() + ",");
			sb.append(refMap.get(s).getHierarchyPrefix() + refMap.get(s).getNameIndex() + "\n");
		}
		return sb.toString();
	}

	/**
	 * Returns the RefDes mapping.
	 * 
	 * @return a map with RefDes as the key and InstanceNode as the value
	 * @see EInstance
	 * 
	 */
	public Map<String, EInstance> getRefMap() {
		return refMap;
	}

	/**
	 * Generates a .csv file containing all the Reference Designator mappings.
	 * 
	 * @param fileName
	 *            the name of the file to be written
	 */
	public void outputToFile(String fileName) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
			out.write(getContents());
			out.close();
		} catch (IOException e) {
			logger.fatal("unable to write file: " + fileName);
			System.exit(1);
		}
		logger.info("wrote file: " + fileName);
	}

	private void add_to_map(EInstance i) {
		if (!refMap.keySet().contains(i.getRefDes())) {
			refMap.put(i.getRefDes(), i);
		} else {
			logger.error("duplicate REFDES value '" + i.getRefDes() + "' in EInstances '" + i.getNameIndex()
					+ "' and '" + refMap.get(i.getRefDes()).getNameIndex() + "'");
		}
	}

	private void generate_pass_1(EHierarchyUnit unit) {
		if (unit instanceof ESubInstance) {
			ESubInstance sdes = (ESubInstance) unit;
			String prefix = "";
			if (sdes.getRefPrefix() != null) {
				prefix = sdes.getRefPrefix();
			}
			if (sdes.getParent() instanceof ESubInstance) {
				ESubInstance sparent = (ESubInstance) sdes.getParent();
				prefix = sparent.getRefPrefix() + prefix;
			}
			if (sdes.hasIndex() && !prefix.trim().equals("")) {
				prefix = prefix + sdes.getIndex();
			}
			if (!prefix.trim().equals("")) {
				sdes.setRefPrefix(prefix + "/");
			} else {
				logger.warn("missing refprefix attribute on subinstance '" + sdes.getHierarchyName() + "'");
				sdes.setRefPrefix("");
			}
		}

		map_constrained(unit);
		for (ESubInstance s : unit.getSubInstances()) {
			generate_pass_1(s);
		}
	}

	private void generate_pass_2(EHierarchyUnit des) {
		for (ESubInstance s : des.getSubInstances()) {
			generate_pass_2(s);
		}
		map_unconstrained(des);
	}

	private String generate_reference(EInstance inst) {
		String str = "";
		int i;
		int max = flag ? 5 * max_index : max_index;

		for (i = 1; i < max; i++) {
			str = inst.getRefPrefix() + i;
			if (!refMap.keySet().contains(str)) {
				break;
			}
		}

		if (i >= max) {
			if (!flag) {
				logger.error("Maximum REFDES index reached: " + max);
				// System.out.println("Maximum RefDes index reached: " + max);
				// System.out.println("  To run with 5x the maximum, use -m on the command line");
			} else {
				// System.out.println("Maximum RefDes index reached: " + max);
				// System.out.println("  No possible way to increase the cap on indices");
			}
		}

		return str;
	}

	private void map_constrained(EHierarchyUnit des) {
		String prefix = "";
		for (EInstance i : des.getInstances()) {
			if (i.hasRefDes()) {
				if (des instanceof ESubInstance) {
					prefix = ((ESubInstance) des).getRefPrefix();
				}
				String ref = prefix + i.getRefDes();
				i.setRefDes(ref);
				add_to_map(i);
			}
		}
	}

	private void map_unconstrained(EHierarchyUnit des) {
		for (EInstance i : des.getInstances()) {
			if (!i.hasRefDes()) {
				if (des instanceof ESubInstance) {
					String prefix = ((ESubInstance) des).getRefPrefix();
					i.setRefPrefix(prefix + i.getRefPrefix());
					// System.out.println("New Prefix: " + i.getRefPrefix());
				}
				String ref = generate_reference(i);
				i.setRefDes(ref);
				add_to_map(i);
			}
		}
	}
}
