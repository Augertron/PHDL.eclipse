package phdl.parser;

public abstract class ArrayDeclaration extends Declaration {

	protected int msb;
	protected int lsb;
	
	public int getMSB() {
		return msb;
	}
	
	public int getLSB() {
		return lsb;
	}
	
	public void setMSB(int msb) {
		this.msb = msb;
	}
	
	public void setLSB(int lsb) {
		this.lsb = lsb;
	}
	
}
