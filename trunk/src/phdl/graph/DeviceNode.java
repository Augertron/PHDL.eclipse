package phdl.graph;

import java.util.Set;
import java.util.HashSet;

public class DeviceNode extends Attributable {

	private Set<PinNode> pins;
	private InstanceNode instance;
	private DesignNode design;
	
	/**
	 * Default Constructor.
	 * 
	 * @param design the parent DesignNode for this Device
	 */
	public DeviceNode(DesignNode design) {
		setDesign(design);
		pins = new HashSet<PinNode>();
		instance = null;
	}
	
	/**
	 * 
	 * @return
	 */
	public InstanceNode getInstance() {
		return instance;
	}

	/**
	 * 
	 * @param instance
	 */
	public void setInstance(InstanceNode instance) {
		this.instance = instance;
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
