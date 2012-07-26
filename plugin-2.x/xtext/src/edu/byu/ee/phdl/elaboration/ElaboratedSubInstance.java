package edu.byu.ee.phdl.elaboration;

import java.util.ArrayList;
import java.util.List;

public class ElaboratedSubInstance extends ElaboratedHierarchyUnit {

	private String refPrefix;
	private ElaboratedSubDesign subDesign;
	private ElaboratedDesignUnit parent;

	public ElaboratedSubInstance(ElaboratedDesignUnit parent, String name) {
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
	public ElaboratedSubInstance(ElaboratedDesignUnit parent, ElaboratedSubDesign subDesign, String name) {
		super();
		this.name = name;
		this.parent = parent;
		this.subDesign = subDesign;
		this.refPrefix = subDesign.getRefPrefix();

		// make copies of all instances
		for (ElaboratedInstance i : subDesign.instances) {
			ElaboratedInstance newInst = new ElaboratedInstance(this, i);
			if (!this.addInstance(newInst))
				System.out.println("duplicate instance");
		}

		// make new ports and nets
		for (int i = 0; i < subDesign.connections.size(); i++) {
			ElaboratedConnection c = subDesign.connections.get(i);
			if (c instanceof ElaboratedPort) {
				ElaboratedPort newPort = new ElaboratedPort(this, (ElaboratedPort) c);
				if (!this.addConnection(newPort))
					System.out.print("duplicate port");
			} else if (c instanceof ElaboratedNet) {
				ElaboratedNet newNet = new ElaboratedNet(this, (ElaboratedNet) c);
				if (!this.addConnection(newNet))
					System.out.print("duplicate net");
			}
		}

		// make new SubInstances
		for (ElaboratedSubInstance s : subDesign.subInsts) {
			ElaboratedSubInstance inst = new ElaboratedSubInstance(this, s);
			inst.setIndex(s.getIndex());
			inst.setLine(s.getLine());
			inst.setPosition(s.getPosition());
			inst.setFileName(s.getFileName());
			inst.setInfo(s.getInfo());
			if (!this.addSubInst(inst))
				System.out.println("duplicate subinstance");
		}

		// reconstruct all net and port connectivity
		for (int i = 0; i < subDesign.connections.size(); i++) {
			for (ElaboratedConnection c : subDesign.connections.get(i).getConnections()) {
				int index = subDesign.connections.indexOf(c);
				if (index != -1)
					this.connections.get(i).addConnection(this.connections.get(index));
				else {
					ElaboratedSubInstance s = this.getSubInstance(c.getParent().getName(), c.getParent().getIndex());
					ElaboratedPort p = s.getPort(c.getName(), c.getIndex());
					p.setAssignment(this.connections.get(i));
				}
			}
		}

		// reconstruct all of the pin connectivity
		for (int i = 0; i < subDesign.instances.size(); i++) {
			for (int p = 0; p < subDesign.instances.get(i).getPins().size(); p++) {
				if (subDesign.instances.get(i).getPins().get(p).isAssigned()) {
					ElaboratedConnection subC = subDesign.instances.get(i).getPins().get(p).getAssignment();
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
	public ElaboratedSubInstance(ElaboratedDesignUnit parent, ElaboratedSubInstance old) {
		super();
		this.name = old.getName();
		this.parent = parent;
		this.subDesign = old.getSubDesign();
		this.refPrefix = old.getRefPrefix();

		// make copies of all instances
		for (ElaboratedInstance i : old.instances) {
			ElaboratedInstance newInst = new ElaboratedInstance(this, i);
			if (!this.addInstance(newInst))
				System.out.println("duplicate instance");
			// clear all of the overwritten flags on attributes
			for (ElaboratedAttribute a : newInst.getAttributes())
				a.setOverwritten(false);
		}

		// make new ports and nets
		for (int i = 0; i < old.connections.size(); i++) {
			ElaboratedConnection c = old.connections.get(i);
			if (c instanceof ElaboratedPort) {
				ElaboratedPort newPort = new ElaboratedPort(this, (ElaboratedPort) c);
				if (!this.addConnection(newPort))
					System.out.print("duplicate port");
			} else if (c instanceof ElaboratedNet) {
				ElaboratedNet newNet = new ElaboratedNet(this, (ElaboratedNet) c);
				if (!this.addConnection(newNet))
					System.out.print("duplicate net");
			}
		}

		// make new SubInstances
		for (ElaboratedSubInstance s : old.subInsts) {
			ElaboratedSubInstance inst = new ElaboratedSubInstance(this, s);
			inst.setIndex(s.getIndex());
			inst.setLine(s.getLine());
			inst.setPosition(s.getPosition());
			inst.setFileName(s.getFileName());
			inst.setInfo(s.getInfo());
			if (!this.addSubInst(inst))
				System.out.println("duplicate subinstance");
		}

		// reconstruct all net and port connectivity
		for (int i = 0; i < old.connections.size(); i++) {
			ElaboratedConnection oldConnection = old.connections.get(i);
			for (ElaboratedConnection c : oldConnection.getConnections()) {
				int index = old.connections.indexOf(c);
				this.connections.get(i).addConnection(this.connections.get(index));
			}
			// reconstruct connections across levels of hierarchy
			if (oldConnection instanceof ElaboratedPort) {
				ElaboratedConnection oldAssign = ((ElaboratedPort) oldConnection).getAssignment();
				int index = old.getParent().connections.indexOf(oldAssign);
				if (index >= 0) {
					ElaboratedConnection newAssign = this.getParent().connections.get(index);
					ElaboratedPort newConnection = (ElaboratedPort) this.connections.get(i);
					newAssign.addConnection(newConnection);
					newConnection.setAssignment(newAssign);
				}
			}

		}

		// reconstruct all of the pin connectivity
		for (int i = 0; i < old.instances.size(); i++) {
			for (int p = 0; p < old.instances.get(i).getPins().size(); p++) {
				if (old.instances.get(i).getPins().get(p).isAssigned()) {
					ElaboratedConnection subC = old.instances.get(i).getPins().get(p).getAssignment();
					int index = old.connections.indexOf(subC);
					this.instances.get(i).getPins().get(p).setAssignment(this.connections.get(index));
					this.connections.get(index).addPin(this.instances.get(i).getPins().get(p));

				}
			}
		}
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ElaboratedSubInstance)) {
			return false;
		}
		boolean result = this.name.equals(((ElaboratedSubInstance) o).getName())
				&& this.getIndex() == ((ElaboratedSubInstance) o).getIndex()
				&& this.parent.equals(((ElaboratedSubInstance) o).getParent());
		return result;
	}
	
	@Override
	public int compareTo(Object o) {
		int result = -1;
		ElaboratedSubInstance other = (ElaboratedSubInstance)o;
		if (this.equals(o)) {
			result = 0;
		}
		else if (!this.getNameIndex().equals(other.getNameIndex())) {
			result = this.getNameIndex().compareTo(other.getNameIndex());
		}
		else {
			this.getParent().compareTo(other.getParent());
		}
		return result;
	}

	public String getHierarchyName() {
		if (parent instanceof ElaboratedSubInstance) {
			return ((ElaboratedSubInstance) parent).getHierarchyName() + "$" + this.getNameIndex();
		} else {
			return this.getNameIndex();
		}
	}

	@Override
	public List<ElaboratedNet> getNets() {
		List<ElaboratedNet> nets = new ArrayList<ElaboratedNet>();
		for (ElaboratedConnection c : connections) {
			if (c instanceof ElaboratedNet)
				nets.add((ElaboratedNet) c);
		}
		return nets;
	}

	@Override
	public NodeType getNodeType() {
		return NodeType.SUBINSTANCE;
	}

	public ElaboratedDesignUnit getParent() {
		return parent;
	}

	public List<ElaboratedPort> getPorts() {
		List<ElaboratedPort> ports = new ArrayList<ElaboratedPort>();
		for (ElaboratedConnection c : connections) {
			if (c instanceof ElaboratedPort)
				ports.add((ElaboratedPort) c);
		}
		return ports;
	}

	public String getRefPrefix() {
		return refPrefix;
	}

	public ElaboratedSubDesign getSubDesign() {
		return subDesign;
	}

	public void setDesign(ElaboratedSubDesign design) {
		this.subDesign = design;
	}

	public void setParent(ElaboratedDesignUnit parent) {
		this.parent = parent;
	}

	public void setRefPrefix(String refPrefix) {
		this.refPrefix = refPrefix;
	}
}
