package phdl;

import java.util.HashSet;

/**
 * A class that represents a net on a PC board.
 * 
 * Stores a net name and a set of optional tags with
 * additional information
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 */
public class PHDLNet {
	/**
	 * the name of the net.
	 */
	private String name;
	/**
	 * a set of optional tags that provide additional
	 * information about the net
	 */
	private HashSet<String> tags;
	
	/**
	 * Default Constructor.
	 * 
	 * Sets the net name and instantiates a new HashSet
	 * for the tags
	 * 
	 * @param name	the name of the net
	 */
	public PHDLNet(String name) {
		this.name = name;
		tags = new HashSet<String>();
	}

	/**
	 * Returns the name of the net.
	 * 
	 * Net name accessor method
	 * 
	 * @return	a string representation of the net name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Changes the name of the net.
	 * 
	 * Net name mutator method
	 * 
	 * @param name	the new name of the net
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns a HashSet of the net tags.
	 * 
	 * Tags accessor method
	 * 
	 * @return	A HashSet representation of the tags
	 */
	public HashSet<String> getTags() {
		return tags;
	}
	
	/**
	 * Adds a new tag to the net.
	 * 
	 * Net tag adder method
	 * 
	 * @param newTag a new tag to be added to the HashSet
	 */
	public void addTag(String newTag) {
		tags.add(newTag);
	}
	
	@Override
	/**
	 * Creates a hash code for use in hash data structures.
	 * 
	 * hashCode method to make attributes compatible with hashMaps
	 * and hashSets.
	 * 
	 * @return	an integer representing a hash code
	 */
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		PHDLNet n = (PHDLNet)o;
		return name.equals(n.getName());
	}
	
	public static boolean unitTest() {
		/* 
		 * Methods Tested
		 *********************
		 * getName			X
		 * addTag			X
		 * getTags			X
		 * setName			X
		 */
		boolean success = true;
		PHDLNet net1 = new PHDLNet("noTags");
		if (!net1.getName().equals("noTags")) {
			success = false;
			TestDriver.err("getName()", "noTags", net1.getName());
		}
		if (!net1.getTags().isEmpty()) {
			success = false;
			TestDriver.err("getTags()", "True", "False");
		}
		net1.setName("2Tags");
		if (!net1.getName().equals("2Tags")) {
			success = false;
			TestDriver.err("setName()", "2Tags", net1.getName());
		}
		net1.addTag("tag1");
		net1.addTag("tag2");
		if (!net1.getTags().contains("tag1")) {
			success = false;
			TestDriver.err("getTags()", "Should contain \"tag1\"", "Didn't contain the tag");
		}
		if (!net1.getTags().contains("tag2")) {
			success = false;
			TestDriver.err("getTags()", "Should contain \"tag2\"", "Didn't contain the tag");
		}
		
		return success;
	}
	
	

}
