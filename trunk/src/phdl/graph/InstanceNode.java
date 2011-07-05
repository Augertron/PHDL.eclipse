package phdl.graph;

import java.util.Set;
import java.util.HashSet;

public class InstanceNode extends Attributable {

	private Set<PinNode> pins;
	private DesignNode design;
	private DeviceNode device;
	private String refDes;
	private String refPrefix;

	/**
	 * Default Constructor.
	 * 
	 * @param design the parent DesignNode for this instance
	 */
	public InstanceNode(DesignNode design) {
		setDesign(design);
		pins = new HashSet<PinNode>();
		setDevice(null);
		refDes = null;
		refPrefix = null;
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

	/**
	 * 
	 * @return
	 */
	public String getRefDes() {
		return refDes;
	}

	/**
	 * 
	 * @param refDes
	 */
	public void setRefDes(String refDes) {
		this.refDes = refDes;
	}

	/**
	 * 
	 * @return
	 */
	public String getRefPrefix() {
		return refPrefix;
	}

	/**
	 * 
	 * @param refPrefix
	 */
	public void setRefPrefix(String refPrefix) {
		this.refPrefix = refPrefix;
	}
	
	/**
	 * 
	 * @param device
	 */
	public void setDevice(DeviceNode device) {
		this.device = device;
		this.device.addInstance(this);		
	}

	/**
	 * 
	 * @return
	 */
	public DeviceNode getDevice() {
		return device;
	}

	@Override
	public NodeType getType() {
		return NodeType.INSTANCE;
	}

}
