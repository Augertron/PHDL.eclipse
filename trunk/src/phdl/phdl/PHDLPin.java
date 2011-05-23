package phdl;

public class PHDLPin {
	private String name;
	private PHDLNet net;

	public PHDLPin(String name) {
		this.name = name;
		net = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PHDLNet getNet() {
		return net;
	}

	public void setNet(PHDLNet net) {
		this.net = net;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}

}
