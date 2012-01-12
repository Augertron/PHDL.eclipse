package phdl.graph;

public class SubDesign extends DesignUnit {

	private String refPrefix;

	public SubDesign() {
		super();
	}
	
	public SubDesign(String name) {
		super();
		this.name = name;
	}

	@Override
	public NodeType getNodeType() {
		return NodeType.SUBDESIGN;
	}

	public String getRefPrefix() {
		return refPrefix;
	}

	public void setRefPrefix(String refPrefix) {
		this.refPrefix = refPrefix;
	}
}
