package phdl.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DeviceNode extends Attributable {

	private Set<AttributeNode> attributes;
	private List<PinNode> pins;
	private Set<InstanceNode> instances;
	private DesignNode design;

	/**
	 * Default Constructor.
	 * 
	 * @param design
	 *            the parent DesignNode for this Device
	 */
	public DeviceNode(DesignNode design) {
		setDesign(design);
		attributes = new TreeSet<AttributeNode>();
		pins = new ArrayList<PinNode>();
		instances = new TreeSet<InstanceNode>();
	}

	/**
	 * 
	 * @return
	 */
	public Set<InstanceNode> getInstances() {
		return instances;
	}

	/**
	 * 
	 * @param instance
	 */
	public boolean addInstance(InstanceNode instance) {
		return instances.add(instance);
	}

	/**
	 * 
	 * @return
	 */
	public DesignNode getDesign() {
		return design;
	}

	/**
	 * 
	 * @param design
	 */
	public void setDesign(DesignNode design) {
		this.design = design;
	}

	@Override
	public NodeType getType() {
		return NodeType.DEVICE;
	}

	/**
	 * 
	 * @return
	 */
	public List<PinNode> getPins() {
		return pins;
	}

	/**
	 * 
	 * @param p
	 * @return
	 */
	public boolean addPin(PinNode p) {
		return pins.add(p);
	}

	/**
	 * 
	 * @return
	 */
	public boolean hasPins() {
		return (!pins.isEmpty());
	}

	public boolean addAttribute(AttributeNode a) {
		return attributes.add(a);
	}

	@Override
	public Set<AttributeNode> getAttributes() {
		return attributes;
	}

	public AttributeNode getAttribute(String s) {
		for (AttributeNode a : attributes) {
			if (a.getName().equals(s))
				return a;
		}
		return null;
	}
}
