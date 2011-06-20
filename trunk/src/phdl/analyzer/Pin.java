package phdl.analyzer;

public class Pin extends Assignable {
	
	public Pin(String name, int line, int pos) {
		super(name, line, pos);
		// TODO Auto-generated constructor stub
	}

	private Net net;
	
	public Net getNet() {
		return net;
	}
	
	public void setNet(Net net) {
		this.net = net;
	}
}
