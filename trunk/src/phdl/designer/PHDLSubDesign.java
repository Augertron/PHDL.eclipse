package phdl.designer;

import java.util.HashSet;
import java.util.Iterator;

public class PHDLSubDesign {

	private String instanceName;
	private String designName;
	private HashSet<PHDLAssignment> portAssignments;
	private int msb;
	private int lsb;
	private int line;
	private int pos;

	public PHDLSubDesign(String instanceName, String designName, int msb,
			int lsb, int line, int pos) {
		this.instanceName = instanceName;
		this.designName = designName;
		this.msb = msb;
		this.lsb = lsb;
		this.line = line;
		this.pos = pos;
		this.portAssignments = new HashSet<PHDLAssignment>();
	}

	public int getMsb() {
		return msb;
	}

	public int getLsb() {
		return lsb;
	}

	public int getLine() {
		return line;
	}

	public int getPos() {
		return pos;
	}

	public void setMsb(int msb) {
		this.msb = msb;
	}

	public void setLsb(int lsb) {
		this.lsb = lsb;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public String getInstanceName() {
		return instanceName;
	}

	public String getDesignName() {
		return designName;
	}

	public HashSet<PHDLAssignment> getPortAssignments() {
		return portAssignments;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public void setDesignName(String designName) {
		this.designName = designName;
	}

	public void addPortAssignment(PHDLAssignment a) {
		portAssignments.add(a);
	}

	@Override
	public String toString() {

		String instanceString = "PHDLInstance[" + line + ":" + pos + "]: "
				+ instanceName + ": " + designName + " [" + msb + ":" + lsb
				+ "]\n";

		String portsString = "";

		Iterator<PHDLAssignment> aIterator = portAssignments.iterator();
		while (aIterator.hasNext())
			portsString += "\t\tPHDLPortAssignment"
					+ aIterator.next().toString();

		return instanceString + portsString;
	}
}
