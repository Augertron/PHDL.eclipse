package phdl.graph;

public class SubDesign extends DesignUnit {

	private String refPrefix;

	public SubDesign() {
		super();
	}
	
	@Override
	public NodeType getNodeType() {
		return NodeType.SUBDESIGN;
	}
}
