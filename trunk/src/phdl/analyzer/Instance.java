package phdl.analyzer;

public class Instance {

	private String refDes;
	private String refPrefix;

	public Instance(String name, int line, int pos) {
		// super(name, line, pos);
	}

	public String getRefDes() {
		return refDes;
	}

	public void setRefDes(String refDes) {
		this.refDes = refDes;
	}

	public String getRefPrefix() {
		return refPrefix;
	}

	public void setRefPrefix(String refPrefix) {
		this.refPrefix = refPrefix;
	}

}
