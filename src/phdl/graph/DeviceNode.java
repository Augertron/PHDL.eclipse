package phdl.graph;

import java.util.Set;
import java.util.HashSet;

public class DeviceNode extends Attributable {

	private Set<PinNode> pins;
	private Set<InstanceNode> instances;
	private DesignNode design;
	
	/**
	 * Default Constructor.
	 * 
	 * @param design the parent DesignNode for this Device
	 */
	public DeviceNode(DesignNode design) {
		setDesign(design);
		pins = new HashSet<PinNode>();
		instances = new HashSet<InstanceNode>();
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
	public Set<PinNode> getPins() {
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

}
