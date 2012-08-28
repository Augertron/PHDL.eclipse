package edu.byu.ee.phdl.netlist;

public class PhdlPart implements Comparable<Object> {

	private String name;
	private String footprint;
	private String library;

	@Override
	public int compareTo(Object o) {
		return this.name.compareTo(((PhdlPart) o).getName());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhdlPart other = (PhdlPart) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String getFootprint() {
		return footprint;
	}

	public String getLibrary() {
		return library;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	public void setFootprint(String footprint) {
		this.footprint = footprint;
	}

	public void setLibrary(String library) {
		this.library = library;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + getName() + ", " + getFootprint() + "@" + getLibrary();
	}

}
