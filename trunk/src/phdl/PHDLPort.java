package phdl;

public class PHDLPort {
	private String name;
	private PHDLPinType type;
	private int msb;
	private int lsb;
	private int index;
	private int line;
	private int pos;

	public PHDLPort(String name, PHDLPinType type, int msb, int lsb, int index,
			int line, int pos) {
		this.name = name;
		this.type = type;
		this.msb = msb;
		this.lsb = lsb;
		this.index = index;
		this.line = line;
		this.pos = pos;
	}

	public PHDLPort(PHDLPinType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public PHDLPinType getType() {
		return type;
	}

	public int getMsb() {
		return msb;
	}

	public int getLsb() {
		return lsb;
	}

	public int getIndex() {
		return index;
	}

	public int getLine() {
		return line;
	}

	public int getPos() {
		return pos;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(PHDLPinType type) {
		this.type = type;
	}

	public void setMsb(int msb) {
		this.msb = msb;
	}

	public void setLsb(int lsb) {
		this.lsb = lsb;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public String getLocation() {
		return "[" + line + ":" + pos + "]";
	}

	@Override
	public String toString() {
		String width = ": ";
		if (msb > -1 && lsb > -1)
			width = "[" + msb + ":" + lsb + "]: ";
		return "PHDLPort" + getLocation() + ": " + type.toString() + width
				+ name + "\n";

	}
}
