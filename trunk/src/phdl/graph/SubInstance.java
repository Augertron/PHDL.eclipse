package phdl.graph;

import java.util.ArrayList;
import java.util.List;

public class SubInstance extends HierarchyUnit {

	private String refPrefix;
	private SubDesign subDesign;
	private int index = -1;
	private DesignUnit parent;

	/**
	 * Hierarchical constructor
	 * @param parent
	 * @param subDesign
	 * @param name
	 */
	public SubInstance(DesignUnit parent, SubDesign subDesign, String name) {
		super();
		this.name = name;
		this.parent = parent;
		this.subDesign = subDesign;

		// recursive constructor to instance each nested referenced SubDesign
		for (SubInstance s : subDesign.subInsts) {
			SubInstance newSubInst = new SubInstance(this, s.getSubDesign(), s.getName());
			newSubInst.setIndex(s.getIndex());
			newSubInst.setLine(s.getLine());
			newSubInst.setPosition(s.getPosition());
			newSubInst.setFileName(s.getFileName());
			newSubInst.setInfo(s.getInfo());
			this.subInsts.add(newSubInst);
		}

		// make copies of all instances
		for (int i = 0; i < subDesign.instances.size(); i++) {
			Instance newInst = new Instance(this, subDesign.instances.get(i));
			this.instances.add(newInst);
		}

		// make new ports and nets
		for (int i = 0; i < subDesign.connections.size(); i++) {
			Connection c = subDesign.connections.get(i);
			if (c instanceof Port)
				this.connections.add(new Port(this, (Port) c));
			else if (c instanceof Net)
				this.connections.add(new Net(this, (Net) c));
		}

		// reconstruct all of the connection connectivity
		for (int i = 0; i < subDesign.connections.size(); i++) {
			for (Connection c : subDesign.connections.get(i).getConnections()) {
				int index = subDesign.connections.indexOf(c);
				this.connections.get(i).addConnection(this.connections.get(index));
			}
		}

		// reconstruct all of the pin connectivity
		for (int i = 0; i < subDesign.instances.size(); i++) {
			for (int p = 0; p < subDesign.instances.get(i).getPins().size(); p++) {
				//System.out.println(subDesign.instances.get(i).getPins().get(p).toString());
				if (subDesign.instances.get(i).getPins().get(p).hasConnection()) {
					Connection subC = subDesign.instances.get(i).getPins().get(p).getConnection();
					int index = subDesign.connections.indexOf(subC);
					this.instances.get(i).getPins().get(p)
						.setConnection(this.connections.get(index));
					this.connections.get(index).addPin(this.instances.get(i).getPins().get(p));
				}
			}
		}
	}

	@Override
	public boolean equals(Object o) {
		return super.equals(o) && this.index == ((SubInstance) o).getIndex();
	}

	public int getIndex() {
		return index;
	}

	@Override
	public NodeType getNodeType() {
		return NodeType.SUBINSTANCE;
	}

	public DesignUnit getParent() {
		return parent;
	}

	public List<Port> getPorts() {
		List<Port> ports = new ArrayList<Port>();
		for (Connection c : connections) {
			if (c instanceof Port)
				ports.add((Port) c);
		}
		return ports;
	}

	public String getRefPrefix() {
		return refPrefix;
	}

	public SubDesign getSubDesign() {
		return subDesign;
	}

	public void setDesign(SubDesign design) {
		this.subDesign = design;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setParent(DesignUnit parent) {
		this.parent = parent;
	}

	public void setRefPrefix(String refPrefix) {
		this.refPrefix = refPrefix;
	}
}
