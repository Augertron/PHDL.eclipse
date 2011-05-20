package phdl;

public class PHDLNet {
	private String name;
	private PHDLNetType type;
	private int msb;
	private int lsb;

	public PHDLNet(String name) {
		this.name = name;
	}

	public PHDLNet(String name, PHDLNetType type, int msb, int lsb) {
		this.name = name;
		this.type = type;
		this.msb = msb;
		this.lsb = lsb;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PHDLNetType getType() {
		return type;
	}

	public void setType(PHDLNetType type) {
		this.type = type;
	}

	public int getMsb() {
		return msb;
	}

	public void setMsb(int msb) {
		this.msb = msb;
	}

	public int getLsb() {
		return lsb;
	}

	public void setLsb(int lsb) {
		this.lsb = lsb;
	}

	public int getWidth() {
		return msb - lsb + 1;
	}

}
