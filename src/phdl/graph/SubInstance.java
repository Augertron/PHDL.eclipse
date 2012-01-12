package phdl.graph;

public class SubInstance extends HierarchyUnit {
	
	private String refPrefix;
	private SubDesign subDesign;
	private int index;
	private DesignUnit parent;

	public SubInstance(SubDesign subDesign, String name) {
		super(subDesign);
		this.refPrefix = null;
		this.name = name;
		this.subDesign = subDesign;
	}
	
	public String getRefPrefix() {
		return refPrefix;
	}

	public void setRefPrefix(String refPrefix) {
		this.refPrefix = refPrefix;
	}
	
	@Override
	public NodeType getNodeType() {
		return NodeType.SUBINSTANCE;
	}

	public SubDesign getSubDesign() {
		return subDesign;
	}

	public void setDesign(SubDesign design) {
		this.subDesign = design;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	@Override
	public boolean equals(Object o) {
		return super.equals(o) && this.index == ((SubInstance) o).getIndex();
	}

	public DesignUnit getParent() {
		return parent;
	}

	public void setParent(DesignUnit parent) {
		this.parent = parent;
	}
}
