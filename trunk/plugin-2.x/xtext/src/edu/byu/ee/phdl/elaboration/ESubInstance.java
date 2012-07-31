package edu.byu.ee.phdl.elaboration;

import java.util.ArrayList;
import java.util.List;

public class ESubInstance extends EHierarchyUnit {

	private String refPrefix;
	private ESubDesign subDesign;
	private EDesignUnit parent;

	public ESubInstance(EDesignUnit parent, String name) {
		super();
		this.name = name;
		this.parent = parent;
		this.subDesign = null;
	}

	/**
	 * Hierarchical constructor called when instancing a subDesign
	 * 
	 * @param parent
	 * @param subDesign
	 * @param name
	 */
	public ESubInstance(EDesignUnit parent, ESubDesign subDesign, String name) {
		super();
		this.name = name;
		this.parent = parent;
		this.subDesign = subDesign;
		this.refPrefix = subDesign.getRefPrefix();

		// make copies of all instances
		for (EInstance i : subDesign.instances) {
			EInstance newInst = new EInstance(this, i);
			if (!this.addInstance(newInst))
				System.out.println("duplicate instance");
		}

		// make new ports and nets
		for (int i = 0; i < subDesign.connections.size(); i++) {
			EConnection c = subDesign.connections.get(i);
			if (c instanceof EPort) {
				EPort newPort = new EPort(this, (EPort) c);
				if (!this.addConnection(newPort))
					System.out.print("duplicate port");
			} else if (c instanceof ENet) {
				ENet newNet = new ENet(this, (ENet) c);
				if (!this.addConnection(newNet))
					System.out.print("duplicate net");
			}
		}

		// make new SubInstances
		for (ESubInstance s : subDesign.subInsts) {
			ESubInstance inst = new ESubInstance(this, s);
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
			for (EConnection c : subDesign.connections.get(i).getConnections()) {
				int index = subDesign.connections.indexOf(c);
				if (index != -1)
					this.connections.get(i).addConnection(this.connections.get(index));
				else {
					ESubInstance s = this.getSubInstance(c.getParent().getName(), c.getParent().getIndex());
					EPort p = s.getPort(c.getName(), c.getIndex());
					p.setAssignment(this.connections.get(i));
				}
			}
		}

		// reconstruct all of the pin connectivity
		for (int i = 0; i < subDesign.instances.size(); i++) {
			for (int p = 0; p < subDesign.instances.get(i).getPins().size(); p++) {
				if (subDesign.instances.get(i).getPins().get(p).isAssigned()) {
					EConnection subC = subDesign.instances.get(i).getPins().get(p).getAssignment();
					int index = subDesign.connections.indexOf(subC);
					this.instances.get(i).getPins().get(p).setAssignment(this.connections.get(index));
					this.connections.get(index).addPin(this.instances.get(i).getPins().get(p));
				}
			}
		}
	}

	/**
	 * SubInstance recursive copy constructor
	 * 
	 * @param parent
	 * @param old
	 */
	public ESubInstance(EDesignUnit parent, ESubInstance old) {
		super();
		this.name = old.getName();
		this.parent = parent;
		this.subDesign = old.getSubDesign();
		this.refPrefix = old.getRefPrefix();

		// make copies of all instances
		for (EInstance i : old.instances) {
			EInstance newInst = new EInstance(this, i);
			if (!this.addInstance(newInst))
				System.out.println("duplicate instance");
			// clear all of the overwritten flags on attributes
			for (EAttribute a : newInst.getAttributes())
				a.setOverwritten(false);
		}

		// make new ports and nets
		for (int i = 0; i < old.connections.size(); i++) {
			EConnection c = old.connections.get(i);
			if (c instanceof EPort) {
				EPort newPort = new EPort(this, (EPort) c);
				if (!this.addConnection(newPort))
					System.out.print("duplicate port");
			} else if (c instanceof ENet) {
				ENet newNet = new ENet(this, (ENet) c);
				if (!this.addConnection(newNet))
					System.out.print("duplicate net");
			}
		}

		// make new SubInstances
		for (ESubInstance s : old.subInsts) {
			ESubInstance inst = new ESubInstance(this, s);
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
			EConnection oldConnection = old.connections.get(i);
			for (EConnection c : oldConnection.getConnections()) {
				int index = old.connections.indexOf(c);
				this.connections.get(i).addConnection(this.connections.get(index));
			}
			// reconstruct connections across levels of hierarchy
			if (oldConnection instanceof EPort) {
				EConnection oldAssign = ((EPort) oldConnection).getAssignment();
				int index = old.getParent().connections.indexOf(oldAssign);
				if (index >= 0) {
					EConnection newAssign = this.getParent().connections.get(index);
					EPort newConnection = (EPort) this.connections.get(i);
					newAssign.addConnection(newConnection);
					newConnection.setAssignment(newAssign);
				}
			}

		}

		// reconstruct all of the pin connectivity
		for (int i = 0; i < old.instances.size(); i++) {
			for (int p = 0; p < old.instances.get(i).getPins().size(); p++) {
				if (old.instances.get(i).getPins().get(p).isAssigned()) {
					EConnection subC = old.instances.get(i).getPins().get(p).getAssignment();
					int index = old.connections.indexOf(subC);
					this.instances.get(i).getPins().get(p).setAssignment(this.connections.get(index));
					this.connections.get(index).addPin(this.instances.get(i).getPins().get(p));

				}
			}
		}
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ESubInstance)) {
			return false;
		}
		boolean result = this.name.equals(((ESubInstance) o).getName())
				&& this.getIndex() == ((ESubInstance) o).getIndex()
				&& this.parent.equals(((ESubInstance) o).getParent());
		return result;
	}

	@Override
	public int compareTo(Object o) {
		int result = -1;
		ESubInstance other = (ESubInstance) o;
		if (this.equals(o)) {
			result = 0;
		} else if (!this.getNameIndex().equals(other.getNameIndex())) {
			result = this.getNameIndex().compareTo(other.getNameIndex());
		} else {
			this.getParent().compareTo(other.getParent());
		}
		return result;
	}

	public String getHierarchyName() {
		StringBuilder sb = new StringBuilder();
		EDesignUnit current = this.parent;
		while (current != null) {
			sb.insert(0, current.getNameIndex() + "/");
			if (current instanceof ESubInstance) {
				current = ((ESubInstance) current).getParent();
			} else
				current = null;
		}
		return sb.append(this.getNameIndex()).toString();
	}

	@Override
	public List<ENet> getNets() {
		List<ENet> nets = new ArrayList<ENet>();
		for (EConnection c : connections) {
			if (c instanceof ENet)
				nets.add((ENet) c);
		}
		return nets;
	}

	@Override
	public NodeType getNodeType() {
		return NodeType.SUBINSTANCE;
	}

	public EDesignUnit getParent() {
		return parent;
	}

	public List<EPort> getPorts() {
		List<EPort> ports = new ArrayList<EPort>();
		for (EConnection c : connections) {
			if (c instanceof EPort)
				ports.add((EPort) c);
		}
		return ports;
	}

	public String getRefPrefix() {
		return refPrefix;
	}

	public ESubDesign getSubDesign() {
		return subDesign;
	}

	public void setDesign(ESubDesign design) {
		this.subDesign = design;
	}

	public void setParent(EDesignUnit parent) {
		this.parent = parent;
	}

	public void setRefPrefix(String refPrefix) {
		this.refPrefix = refPrefix;
	}
}
