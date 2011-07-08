package phdl.graph;

import java.util.ArrayList;
import java.util.List;

public class InstanceNode extends Attributable {

	private List<PinNode> pins;
	private DesignNode design;
	private DeviceNode device;
	private String refDes;
	private String refPrefix;

	/**
	 * Default Constructor.
	 * 
	 * @param design
	 *            the parent DesignNode for this instance
	 */
	public InstanceNode(DesignNode design) {
		super();
		setDesign(design);
		pins = new ArrayList<PinNode>();
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

	@Override
	public String toString() {
		return super.toString() + " : " + getDevice().getName();
	}

	public AttributeNode getAttribute(String s) {
		for (AttributeNode a : attrs) {
			if (s.toUpperCase().equals(a.getName().toUpperCase())) {
				return a;
			}
		}
		return null;
	}

	/**
	 * Returns a list of PinNodes with the same name as the name passed in.
	 * Valid names are an exact match (suffix length is zero), or those that are
	 * suffixed by an array index (the start of which is marked by an open
	 * parentheses character.)
	 * 
	 * @param pinName
	 * @return The list of pin nodes with the same name as pinName.
	 */
	public List<PinNode> getAllPins(String pinName) {
		List<PinNode> allPins = new ArrayList<PinNode>();
		for (int i = 0; i < pins.size(); i++) {
			// make a new string with the name of the pin node removed, leaving
			// only the suffix if it exists.
			String suffix = pins.get(i).getName().substring(pinName.length());
			if (suffix.length() == 0 || suffix.charAt(0) == '(') {
				allPins.add(pins.get(i));
			}
		}
		return allPins;
	}

	public PinNode getPin(String s) {
		for (PinNode p : pins) {
			if (p.getName().equals(s))
				return p;
		}
		return null;
	}

	@Deprecated
	public boolean overwriteAttribute(String name, String newValue) {
		AttributeNode an = null;
		for (AttributeNode a : attrs) {
			if (a.getName().equals(name)) {
				an = a;
				break;
			}
		}
		if (an != null) {
			attrs.remove(an);
			an.setValue(newValue);
			return attrs.add(an);
		} else
			return false;
	}
}
