package phdl.parser;

import java.util.LinkedList;

/**
 * An abstract class that represents a concatenation assignment in phdl. In
 * addition to inherited fields, a concatenation assignment has a list of nets
 * to be concatenated.
 * 
 * @author Richard Black and Brad Riching
 * 
 */
public abstract class ConcatenationAssignment extends Assignment {

	/**
	 * This concatenation assignment's list of nets
	 */
	protected LinkedList<Net> nets;

	/**
	 * Gets this concatenation assignment's list of nets
	 * 
	 * @return This concatenation assignment's list of nets
	 */
	public LinkedList<Net> getNets() {
		return nets;
	}

	/**
	 * Adds a net to this concatenation assignment's list of nets
	 * 
	 * @param net
	 *            The net to add
	 */
	public void addNet(Net net) {
		nets.add(net);
	}
}
