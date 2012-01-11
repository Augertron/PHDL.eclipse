package phdl.graph;

public class SubInstance extends HierarchyUnit {
	
	private String refPrefix;
	private SubDesign subDesign;
	private int index;

	public SubInstance(DesignUnit old) {
		super(old);
		refPrefix = null;
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

	public SubDesign getDesign() {
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
}
