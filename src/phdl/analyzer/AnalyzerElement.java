package phdl.analyzer;

public abstract class AnalyzerElement {

	protected String name;
	protected int line;
	protected int pos;
	
	public AnalyzerElement(String name, int line, int pos) {
		this.name = name;
		this.line = line;
		this.pos = pos;
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
	
}
