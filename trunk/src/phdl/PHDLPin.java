package phdl;

public class PHDLPin {
	private String name;
	private int msb;
	private int lsb;
	private PHDLNet net;

	public PHDLPin(String name, int msb, int lsb) {
		this.name = name;
		this.msb = msb;
		this.lsb = lsb;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public PHDLNet getNet() {
		return net;
	}

	public void setNet(PHDLNet net) {
		this.net = net;
	}

}
