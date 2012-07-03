package edu.byu.ee.phdl.elaboration;

public class ElaboratedSubDesign extends ElaboratedDesignUnit {

	private String refPrefix;

	public ElaboratedSubDesign() {
		super();
	}
	
	public ElaboratedSubDesign(String name) {
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
