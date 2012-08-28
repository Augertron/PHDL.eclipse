package edu.byu.ee.phdl.netlist;

public class PhdlPin {

	private String pinName;
	private String partName;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhdlPin other = (PhdlPin) obj;
		if (partName == null) {
			if (other.partName != null)
				return false;
		} else if (!partName.equals(other.partName))
			return false;
		if (pinName == null) {
			if (other.pinName != null)
				return false;
		} else if (!pinName.equals(other.pinName))
			return false;
		return true;
	}

	public String getPartName() {
		return partName;
	}

	public String getPinName() {
		return pinName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((partName == null) ? 0 : partName.hashCode());
		result = prime * result + ((pinName == null) ? 0 : pinName.hashCode());
		return result;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public void setPinName(String pinName) {
		this.pinName = pinName;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + getPartName() + "." + getPinName();
	}

}
