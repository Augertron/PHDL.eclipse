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
		System.out.println(name);
		this.name = name;
		this.parent = parent;
		this.subDesign = subDesign;

		for (SubInstance s : subDesign.subInsts) {
			SubInstance inst = new SubInstance(this, s.getSubDesign(), s.getName());
			inst.setIndex(s.getIndex());
			inst.setLine(s.getLine());
			inst.setPosition(s.getPosition());
			inst.setFileName(s.getFileName());
			inst.setInfo(s.getInfo());
			if (!this.subInsts.add(inst))
				System.out.println("duplicate subinstance");
		}

		// make copies of all instances
		for (int i = 0; i < subDesign.instances.size(); i++) {
			Instance newInst = new Instance(this, subDesign.instances.get(i));
			System.out.print(newInst);
			if (!this.instances.add(newInst))
				System.out.println("duplicate instance");
		}

		// make new ports and nets
		for (int i = 0; i < subDesign.connections.size(); i++) {
			Connection c = subDesign.connections.get(i);
			System.out.print(c);
			if (c instanceof Port) {
				Port newPort = new Port(this, (Port) c);
				if (!this.connections.add(newPort))
					System.out.print("duplicate port");
			} else if (c instanceof Net) {
				Net newNet = new Net(this, (Net) c);
				if (!this.connections.add(newNet))
					System.out.print("duplicate net");
			}
		}

		// reconstruct all net and port connectivity
		for (int i = 0; i < subDesign.connections.size(); i++) {
			for (Connection c : subDesign.connections.get(i).getConnections()) {
				int index = subDesign.connections.indexOf(c);
				//System.out.println(c);
				if (index > 0)
					this.connections.get(i).addConnection(this.connections.get(index));
			}
		}

		// reconstruct all of the pin connectivity
		for (int i = 0; i < subDesign.instances.size(); i++) {
			for (int p = 0; p < subDesign.instances.get(i).getPins().size(); p++) {
				//System.out.println(subDesign.instances.get(i).getPins().get(p));
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
		return super.equals(((SubInstance) o).getName())
			&& this.index == ((SubInstance) o).getIndex();
	}

	public int getIndex() {
		return index;
	}

	@Override
	public List<Net> getNets() {
		List<Net> nets = new ArrayList<Net>();
		for (Connection c : connections) {
			if (c instanceof Net)
				nets.add((Net) c);
		}
		return nets;
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
