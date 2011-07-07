package phdl.graph;

public abstract class Node implements Comparable {

	/**
	 * The name of the node
	 */
	protected String name;
	protected int line;
	protected int pos;
	protected String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getName() {
		return name;
	}

	public int getLine() {
		return line;
	}

	public int getPosition() {
		return pos;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public void setPosition(int pos) {
		this.pos = pos;
	}

	public abstract NodeType getType();

	@Override
	public boolean equals(Object o) {
		return name.equals(((Node) o).getName());
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public String toString() {
		return getType().toString() + " " + name;
	}

	@Deprecated
	public void initNode(String name, int line, int pos, String fileName) {
		this.name = name;
		this.line = line;
		this.pos = pos;
		this.fileName = fileName;
	}

	public void setLocation(int line, int pos, String fileName) {
		this.line = line;
		this.pos = pos;
		this.fileName = fileName;
	}

	@Override
	public int compareTo(Object o) {
		return this.name.compareTo(((Node) o).getName());
	}
}
