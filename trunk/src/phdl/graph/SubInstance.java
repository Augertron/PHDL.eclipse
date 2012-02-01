package phdl.graph;

import java.util.ArrayList;
import java.util.List;

public class SubInstance extends HierarchyUnit {

	private String refPrefix;
	private SubDesign subDesign;
	private DesignUnit parent;

	public SubInstance(DesignUnit parent, String name) {
		super();
		this.name = name;
		this.parent = parent;
		this.subDesign = null;
	}

	/**
	 * Hierarchical constructor called when instancing a subDesign
	 * @param parent
	 * @param subDesign
	 * @param name
	 */
	public SubInstance(DesignUnit parent, SubDesign subDesign, String name) {
		super();
		this.name = name;
		this.parent = parent;
		this.subDesign = subDesign;
		this.refPrefix = subDesign.getRefPrefix();

		// make new SubInstances
		for (SubInstance s : subDesign.subInsts) {
			SubInstance inst = new SubInstance(this, s);
			inst.setIndex(s.getIndex());
			inst.setLine(s.getLine());
			inst.setPosition(s.getPosition());
			inst.setFileName(s.getFileName());
			inst.setInfo(s.getInfo());
			if (!this.addSubInst(inst))
				System.out.println("duplicate subinstance");
		}

		// make copies of all instances
		for (Instance i : subDesign.instances) {
			Instance newInst = new Instance(this, i);
			if (!this.addInstance(newInst))
				System.out.println("duplicate instance");
		}

		// make new ports and nets
		for (int i = 0; i < subDesign.connections.size(); i++) {
			Connection c = subDesign.connections.get(i);
			if (c instanceof Port) {
				Port newPort = new Port(this, (Port) c);
				if (!this.addConnection(newPort))
					System.out.print("duplicate port");
			} else if (c instanceof Net) {
				Net newNet = new Net(this, (Net) c);
				if (!this.addConnection(newNet))
					System.out.print("duplicate net");
			}
		}

		// reconstruct all net and port connectivity
		for (int i = 0; i < subDesign.connections.size(); i++) {
			for (Connection c : subDesign.connections.get(i).getConnections()) {
				int index = subDesign.connections.indexOf(c);
				if (index != -1)
					this.connections.get(i).addConnection(this.connections.get(index));
				else {
					SubInstance s = this.getSubInstance(c.getParent().getName(), c.getParent().getIndex());
					Port p = s.getPort(c.getName(), c.getIndex());
					p.setAssignment(this.connections.get(i));
				}
			}
		}

		// reconstruct all of the pin connectivity
		for (int i = 0; i < subDesign.instances.size(); i++) {
			for (int p = 0; p < subDesign.instances.get(i).getPins().size(); p++) {
				if (subDesign.instances.get(i).getPins().get(p).isAssigned()) {
					Connection subC = subDesign.instances.get(i).getPins().get(p).getAssignment();
					int index = subDesign.connections.indexOf(subC);
					this.instances.get(i).getPins().get(p).setAssignment(this.connections.get(index));
					this.connections.get(index).addPin(this.instances.get(i).getPins().get(p));
				}
			}
		}
	}

	/**
	 * SubInstance recursive copy constructor
	 * @param parent
	 * @param old
	 */
	public SubInstance(DesignUnit parent, SubInstance old) {
		super();
		this.name = old.getName();
		this.parent = parent;
		this.subDesign = old.getSubDesign();
		this.refPrefix = old.getRefPrefix();

		// make new SubInstances
		for (SubInstance s : old.subInsts) {
			SubInstance inst = new SubInstance(this, s);
			inst.setIndex(s.getIndex());
			inst.setLine(s.getLine());
			inst.setPosition(s.getPosition());
			inst.setFileName(s.getFileName());
			inst.setInfo(s.getInfo());
			if (!this.addSubInst(inst))
				System.out.println("duplicate subinstance");
		}

		// make copies of all instances
		for (Instance i : old.instances) {
			Instance newInst = new Instance(this, i);
			if (!this.addInstance(newInst))
				System.out.println("duplicate instance");
			// clear all of the overwritten flags on attributes
			for (Attribute a : newInst.getAttributes())
				a.setOverwritten(false);
		}

		// make new ports and nets
		for (int i = 0; i < old.connections.size(); i++) {
			Connection c = old.connections.get(i);
			if (c instanceof Port) {
				Port newPort = new Port(this, (Port) c);
				if (!this.addConnection(newPort))
					System.out.print("duplicate port");
			} else if (c instanceof Net) {
				Net newNet = new Net(this, (Net) c);
				if (!this.addConnection(newNet))
					System.out.print("duplicate net");
			}
		}

		// reconstruct all net and port connectivity
		for (int i = 0; i < old.connections.size(); i++) {
			for (Connection c : old.connections.get(i).getConnections()) {
				int index = old.connections.indexOf(c);
				if (index != -1)
					this.connections.get(i).addConnection(this.connections.get(index));
				else {
					SubInstance s = this.getSubInstance(c.getParent().getName(), c.getParent().getIndex());
					Port p = s.getPort(c.getName(), c.getIndex());
					p.setAssignment(this.connections.get(i));
				}
			}
		}

		// reconstruct all of the pin connectivity
		for (int i = 0; i < old.instances.size(); i++) {
			for (int p = 0; p < old.instances.get(i).getPins().size(); p++) {
				if (old.instances.get(i).getPins().get(p).isAssigned()) {
					Connection subC = old.instances.get(i).getPins().get(p).getAssignment();
					int index = old.connections.indexOf(subC);
					this.instances.get(i).getPins().get(p).setAssignment(this.connections.get(index));
					this.connections.get(index).addPin(this.instances.get(i).getPins().get(p));
				}
			}
		}
	}

	@Override
	public boolean equals(Object o) {
		if (!(this.parent instanceof SubInstance)) {
			return false;
		}
		return this.name.equals(((SubInstance) o).getName()) && this.getIndex() == ((SubInstance) o).getIndex()
			&& this.parent.equals(((SubInstance) o).getParent());
	}
	
	public String getHierarchyName() {
		if (parent instanceof SubInstance) {
			return getHierarchyName() + "." + this.getNameIndex();
		}
		else {
			return this.getNameIndex();
		}
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

	public void setParent(DesignUnit parent) {
		this.parent = parent;
	}

	public void setRefPrefix(String refPrefix) {
		this.refPrefix = refPrefix;
	}
}
