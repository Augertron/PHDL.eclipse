/*
    Copyright (C) 2011  Brigham Young University

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, version 3.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package phdl.graph;

import java.util.Set;
import java.util.TreeSet;

/**
 * An abstract class that describes nodes that have attributes.
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 * @see Node
 * 
 */
public abstract class Attributable extends Node {

	protected Set<Attribute> attributes;

	/**
	 * Default Constructor.
	 * 
	 * Initializes the attributes set
	 */
	public Attributable() {
		this.attributes = new TreeSet<Attribute>();
	}

	/**
	 * Attribute set accessor method.
	 * 
	 * @return the set of AttributeNodes
	 */
	public Set<Attribute> getAttributes() {
		return attributes;
	}

	/**
	 * Attribute addition method.
	 * 
	 * @param a
	 *            the AttributeNode to add to the set
	 * @return true if the AttributeNode wasn't already in the set, false otherwise
	 */
	public boolean addAttribute(Attribute a) {
		return attributes.add(a);
	}

	/**
	 * Single AttributeNode accessor method.
	 * 
	 * @param s
	 *            the name of the attribute
	 * @return the AttributeNode with that name
	 */
	public Attribute getAttribute(String name) {
		for (Attribute a : attributes) {
			if (a.getName().equals(name))
				return a;
		}
		return null;
	}

}
