package phdl.analyzer;

public class Port extends Assignable {

	private Net net;
	
	public Port(String name, int line, int pos) {
		super(name, line, pos);
	}
	
	public Net getNet() {
		return net;
	}
	
	public void setNet(Net net) {
		this.net = net;
	}
	
}
