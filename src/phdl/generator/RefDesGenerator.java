/*
 * Copyright (C) 2011 Brigham Young University This program is free software: you can redistribute
 * it and/or modify it under the terms of the GNU General Public License as published by the Free
 * Software Foundation, version 3. This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received
 * a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package phdl.generator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import phdl.graph.Design;
import phdl.graph.DesignUnit;
import phdl.graph.HierarchyUnit;
import phdl.graph.Instance;
import phdl.graph.SubInstance;

/**
 * A class that generates a Reference Designator mapping and file.
 * 
 * @author Brad Riching and Richard Black
 * @version 0.1
 * 
 */
public class RefDesGenerator {

	private Map<String, Instance> refMap = new TreeMap<String, Instance>();
	private Design design;
	private boolean flag;
	private final int max_index = 100000;

	/**
	 * Default Constructor.
	 * 
	 * Takes a DesignNode and generates the Reference Designator mapping.
	 * 
	 * @param design
	 *            the DesignNode that contains the InstanceNode information.
	 * 
	 * @see Design
	 */
	public RefDesGenerator(Design design) {
		this.flag = false;
		this.design = design;
		generate_pass_1(design);
		generate_pass_2(design);
	}
	
	public RefDesGenerator(Design design, boolean flag) {
		this.flag = flag;
		this.design = design;
		generate_pass_1(design);
		generate_pass_2(design);
	}
	
	private void generate_pass_1(HierarchyUnit des) {
		if (des instanceof SubInstance) {
			SubInstance sdes = (SubInstance)des;
			String prefix = "";
			if (sdes.getRefPrefix() != null) {
				prefix = sdes.getRefPrefix();
			}
			if (sdes.getParent() instanceof SubInstance) {
				SubInstance sparent = (SubInstance)sdes.getParent();
				prefix = sparent.getRefPrefix() + prefix;
			}
			if (sdes.hasIndex()) {
				prefix = prefix + sdes.getIndex();
			}
			if (!prefix.equals("")) {
				sdes.setRefPrefix(prefix + ".");
			}
			else {
				sdes.setRefPrefix("");
			}
		}
		
		map_constrained(des);
		for (SubInstance s : des.getSubInstances()) {
			generate_pass_1(s);
		}
	}
	
	private void generate_pass_2(HierarchyUnit des) {
		for (SubInstance s : des.getSubInstances()) {
			generate_pass_2(s);
		}
		map_unconstrained(des);
	}
	
	private void map_constrained(HierarchyUnit des) {
		String prefix = "";
		for (Instance i : des.getInstances()) {
			if (i.hasRefDes()) {
				if (des instanceof SubInstance) {
					prefix = ((SubInstance)des).getRefPrefix();
				}
				String ref = prefix + i.getRefDes();
				System.out.println("Reference Constrained: " + ref);
				i.setRefDes(ref);
				add_to_map(i);
			}
		}
	}
	
	private void map_unconstrained(HierarchyUnit des) {
		for (Instance i : des.getInstances()) {
			if (!i.hasRefDes()) {
				if (des instanceof SubInstance) {
					String prefix = ((SubInstance)des).getRefPrefix();
					i.setRefPrefix(prefix + i.getRefPrefix());
				}
				String ref = generate_reference(i);
				System.out.println("Reference Generated: " + ref);
				i.setRefDes(ref);
				add_to_map(i);
			}
			else {
				System.out.println("Instance " + i.getName() + " already had a refDes");
			}
		}
	}
	
	private void add_to_map(Instance i) {
		if (!refMap.keySet().contains(i.getRefDes())) {
			refMap.put(i.getRefDes(), i);
		} else {
			System.out.println("Duplicate RefDes detected in RefDesGenerator.");
			System.out.println("  In Instance " + i);
			System.out.println("  And in Instance " + refMap.get(i.getRefDes()));
		}
	}
	
	private String generate_reference(Instance inst) {
		String str = "";
		int i;
		int max = flag ? 5*max_index : max_index;
		
		for (i = 1; i < max; i++) {
			str = inst.getRefPrefix() + i;
			if (!refMap.keySet().contains(str)) {
				break;
			}
		}
		
		if (i >= max) {
			if (!flag) {
				System.out.println("Maximum RefDes index reached: " + max);
				System.out.println("  To run with 5x the maximum, use -m on the command line");
			}
			else {
				System.out.println("Maximum RefDes index reached: " + max);
				System.out.println("  No possible way to increase the cap on indices");
			}
		}
		
		return str;
	}

	/**
	 * Returns the RefDes mapping.
	 * 
	 * @return a map with RefDes as the key and InstanceNode as the value
	 * @see Instance
	 * 
	 */
	public Map<String, Instance> getRefMap() {
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
			out.write(toString());
			out.close();
		} catch (IOException e) {
			System.err.println("File Reading Error - filename may be corrupt");
			System.exit(1);
		}
		System.out.println("Wrote csv file: " + design.getName() + ".csv");
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Set<String> refs = refMap.keySet();
		for (String s : refs) {
			sb.append(refMap.get(s).getRefDes() + ",");
			sb.append(refMap.get(s).getName() + "\n");
		}
		return sb.toString();
	}
	
	public static boolean unitTest() {
		boolean success = true;
		
		/**
		 * Test 1
		 *  No hierarchy
		 */
		
		/**
		 * Test 2
		 *  One-level hierarchy
		 */
		
		/**
		 * Test 3
		 *  Multi-level hierarchy
		 */
		
		/**
		 * Test 4
		 *  Multi-level hierarchy
		 *  Some levels w/o RefPrefix
		 */
		Design des4 = new Design("top_design_4");
		{
			Instance inst1 = new Instance(des4);
			inst1.setName("Inst1");
			inst1.setRefDes("R1");
			des4.addInstance(inst1);
			
			Instance inst2 = new Instance(des4);
			inst2.setName("Inst2");
			inst2.setRefDes("C3");
			des4.addInstance(inst2);
			
			Instance inst3 = new Instance(des4);
			inst3.setName("Inst3");
			inst3.setRefDes("R4");
			des4.addInstance(inst3);
			
			Instance[] inst4 = new Instance[4];
			for (int i = 0; i < 4; i++) {
				inst4[i] = new Instance(des4);
				inst4[i].setName("Inst4(" + (i+1) + ")");
				inst4[i].setRefPrefix("C");
				des4.addInstance(inst4[i]);
			}
		
			SubInstance sub1 = new SubInstance(des4, "SubInst1"); {
				Instance sub1_inst1 = new Instance(sub1);
				sub1_inst1.setName("SubInst1.Inst1");
				sub1_inst1.setRefDes("R1");
				sub1.addInstance(sub1_inst1);
				
				Instance sub1_inst2 = new Instance(sub1);
				sub1_inst2.setName("SubInst1.Inst2");
				sub1_inst2.setRefPrefix("C");
				sub1.addInstance(sub1_inst2);
				
				Instance sub1_inst3 = new Instance(sub1);
				sub1_inst3.setName("SubInst1.Inst3");
				sub1_inst3.setRefDes("C3");
				sub1.addInstance(sub1_inst3);
			}
			sub1.setRefPrefix("A");
			des4.addSubInst(sub1);
			
			SubInstance sub2 = new SubInstance(des4, "SubInst2"); {
				Instance sub2_inst1 = new Instance(sub2);
				sub2_inst1.setName("SubInst2.Inst1");
				sub2_inst1.setRefDes("R2");
				sub2.addInstance(sub2_inst1);
				
				Instance[] sub2_inst2 = new Instance[5];
				for (int i = 4; i >= 0; i--) {
					sub2_inst2[i] = new Instance(sub2);
					sub2_inst2[i].setName("SubInst2.Inst2(" + (i+1) + ")");
					sub2_inst2[i].setRefPrefix("R");
					sub2.addInstance(sub2_inst2[i]);
				}
				
				Instance sub2_inst3 = new Instance(sub2);
				sub2_inst3.setName("SubInst2.Inst3");
				sub2_inst3.setRefDes("C5");
				sub2.addInstance(sub2_inst3);
			}
			des4.addSubInst(sub2);
			
			SubInstance sub3 = new SubInstance(des4, "SubInst3"); {
				SubInstance sub4 = new SubInstance(sub3, "SubInst4"); {
					Instance sub3_sub4_inst1 = new Instance(sub4);
					sub3_sub4_inst1.setName("SubInst3.SubInst4.Inst1");
					sub3_sub4_inst1.setRefPrefix("R");
					sub4.addInstance(sub3_sub4_inst1);
					
					Instance sub3_sub4_inst2 = new Instance(sub4);
					sub3_sub4_inst2.setName("SubInst3.SubInst4.Inst2");
					sub3_sub4_inst2.setRefPrefix("C");
					sub4.addInstance(sub3_sub4_inst2);
				}
				sub4.setRefPrefix("C");
				sub3.addSubInst(sub4);
			}
			sub3.setRefPrefix("B");
			des4.addSubInst(sub3);
			
			SubInstance[] sub5 = new SubInstance[3];
			Instance[] sub5_inst1 = new Instance[3];
			Instance[] sub5_inst2 = new Instance[3];
			Instance[] sub5_inst3 = new Instance[3];
			Integer[] index = new Integer[3];
			index[0] = 1;
			index[1] = 4;
			index[2] = 3;
			for (int i = 0; i < 3; i++) {
				sub5[i] = new SubInstance(des4, "SubInst5(" + index[i] + ")"); {
					sub5_inst1[i] = new Instance(sub5[i]);
					sub5_inst1[i].setName("SubInst5(" + index[i] + ").Inst1");
					sub5_inst1[i].setRefPrefix("R");
					sub5[i].addInstance(sub5_inst1[i]);
					
					sub5_inst2[i] = new Instance(sub5[i]);
					sub5_inst2[i].setName("SubInst5(" + index[i] + ").Inst2");
					sub5_inst2[i].setRefPrefix("D");
					sub5[i].addInstance(sub5_inst2[i]);
					
					sub5_inst3[i] = new Instance(sub5[i]);
					sub5_inst3[i].setName("SubInst5(" + index[i] + ").Inst3");
					sub5_inst3[i].setRefDes("R2");
					sub5[i].addInstance(sub5_inst3[i]);
				}
				sub5[i].setIndex(index[i]);
				sub5[i].setRefPrefix("X");
				des4.addSubInst(sub5[i]);
			}
		}
		
		
		
		RefDesGenerator rdGen4 = new RefDesGenerator(des4);
		
		rdGen4.outputToFile("top_design_4.csv");
				
		
		
		return success;
	}
}
