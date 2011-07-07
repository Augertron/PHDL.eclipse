package phdl.graph;

import java.util.Set;
import java.util.TreeSet;

public abstract class Attributable extends Node {

	protected Set<AttributeNode> attrs;

	public Attributable() {
		attrs = new TreeSet<AttributeNode>();
	}

	public Set<AttributeNode> getAttributes() {
		return attrs;
	}

	public boolean addAttribute(AttributeNode a) {
		return attrs.add(a);
	}

}
