package edu.byu.ee.phdl.elaboration;


public class ESubDesign extends EDesignUnit {

	private String refPrefix;

	public ESubDesign() {
		super();
	}

	public ESubDesign(String name) {
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
