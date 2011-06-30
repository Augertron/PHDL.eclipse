package phdl.graph;

import java.util.Set;

public abstract class Attributable extends Node {

	protected Set<AttributeNode> attrs;

	/**
	 * 
	 * @return
	 */
	public Set<AttributeNode> getAttributes() {
		return attrs;
	}
	
	/**
	 * 
	 * @param a
	 * @return
	 */
	public boolean addAttribute(AttributeNode a) {
		return attrs.add(a);
	}
	
}
