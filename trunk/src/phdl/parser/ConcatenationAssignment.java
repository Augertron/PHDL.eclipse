package phdl.parser;

import java.util.LinkedList;

public abstract class ConcatenationAssignment extends Assignment {

	protected LinkedList<Net> nets;

	public LinkedList<Net> getNets() {
		return nets;
	}

	public void addNet(Net net) {
		nets.add(net);
	}
}
