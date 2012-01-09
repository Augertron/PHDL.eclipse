package phdl.graph;

public class SubInstance extends HierarchyUnit {
	
	private String refPrefix;

	public SubInstance() {
		refPrefix = null;
	}
	
	public String getRefPrefix() {
		return refPrefix;
	}

	public void setRefPrefix(String refPrefix) {
		this.refPrefix = refPrefix;
	}
	
	public NodeType getNodeType() {
		return NodeType.SUBINSTANCE;
	}
	
}
