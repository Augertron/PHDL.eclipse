package phdl.generator;

import java.util.LinkedList;
import java.util.List;

import phdl.graph.AttributeNode;
import phdl.graph.DesignNode;
import phdl.graph.DeviceNode;
import phdl.graph.InstanceNode;
import phdl.graph.NetNode;
import phdl.graph.Node;
import phdl.graph.PinNode;

public class DesignComparator {

	private List<Change> changes;
	
	private class Change {
		ChangeType type;
		Node node1;
		Node node2;
		
		Change(ChangeType type, Node node) {
			this.type = type;
			this.node1 = node;
		}
		
		Change(ChangeType type, Node older, Node newer) {
			if (!type.equals(ChangeType.MODIFY)) {
				System.err.println("A change with two nodes requires the change to be a MODIFY");
				System.exit(1);
			}
			this.type = type;
			this.node1 = older;
			this.node2 = newer;
		}
		
		@Override
		public String toString() {
			if (type.equals(ChangeType.MODIFY)) {
				return type.toString() + " " + node1.toString() + " " + node2.toString();
			}
			return type.toString() + " " + node1.toString();
		}
	}
	
	private enum ChangeType {
		ADD,
		REMOVE,
		MODIFY
	}
	
	public void printChanges() {
		for (Change c : changes) {
			System.out.println(c);
		}
	}
	
	public List<Change> compareDesign(DesignNode older, DesignNode newer) {
		changes = new LinkedList<Change>();
		
		// ************************************
		// Check for changes in Devices
		// ************************************
		List<AttributeNode> oldAttr = new LinkedList<AttributeNode>();
		List<PinNode> oldPins = new LinkedList<PinNode>();
		for (DeviceNode d : older.getDevices()) {
			// Device Name
			if (!newer.getDevices().contains(d)) {
				changes.add(new Change(ChangeType.REMOVE, d));
			}
			// Attributes
			oldAttr.addAll(d.getAttributes());
			// Pins
			oldPins.addAll(d.getPins());
		}
		
		List<AttributeNode> newAttr = new LinkedList<AttributeNode>();
		List<PinNode> newPins = new LinkedList<PinNode>();
		for (DeviceNode d : newer.getDevices()) {
			if (!older.getDevices().contains(d)) {
				changes.add(new Change(ChangeType.ADD, d));
			}
			// Attributes
			newAttr.addAll(d.getAttributes());
			// Pins
			newPins.addAll(d.getPins());
		}
		
		/************************************
		 * Check for changes in Device Attributes
		 ************************************/
		for (AttributeNode a : oldAttr) {
			if (!newAttr.contains(a)) {
				changes.add(new Change(ChangeType.REMOVE, a));
			}
			else {
				for (AttributeNode b : newAttr) {
					if (b.equals(a) && b.getParent().equals(a.getParent())) {
						if (!b.getValue().equals(a.getValue())) {
							changes.add(new Change(ChangeType.MODIFY, a, b));
						}
					}
				}
			}
		}
		for (AttributeNode a : newAttr) {
			if (!oldAttr.contains(a)) {
				changes.add(new Change(ChangeType.ADD, a));
			}
		}
		
		/************************************
		 * Check for changes in Device Pins
		 ************************************/
		// Pin Names
		for (PinNode p : newPins) {
			// Pin Names
			if (!oldPins.contains(p)) {
				changes.add(new Change(ChangeType.ADD, p));
			}
			else { // Pin Numbers
				for (PinNode o : oldPins) {
					if (o.equals(p) && o.getParent().equals(p.getParent())) {
						if (!o.getPinName().equals(p.getPinName())) {
							changes.add(new Change(ChangeType.MODIFY, o, p));
						}
					}
				}
			}
		}
		for (PinNode p : oldPins) {
			// Pin Names
			if (!newPins.contains(p)) {
				changes.add(new Change(ChangeType.REMOVE, p));
			}
		}

		// ************************************
		// Check for changes in Net Names
		// ************************************
		oldAttr.clear();
		newAttr.clear();
		for (NetNode n : older.getNets()) {
			if (!newer.getNets().contains(n)) {
				changes.add(new Change(ChangeType.REMOVE, n));
			}
			oldAttr.addAll(n.getAttributes());
		}
		for (NetNode n : newer.getNets()) {
			if (!older.getNets().contains(n)) {
				changes.add(new Change(ChangeType.ADD, n));
			}
			newAttr.addAll(n.getAttributes());
		}
		
		// Net Attributes
		for (AttributeNode a : oldAttr) {
			if (!newAttr.contains(a)) {
				changes.add(new Change(ChangeType.REMOVE, a));
			}
			else {
				for (AttributeNode b : newAttr) {
					if (b.equals(a) && b.getParent().equals(a.getParent())) {
						if (!b.getValue().equals(a.getValue())) {
							changes.add(new Change(ChangeType.MODIFY, a, b));
						}
					}
				}
			}
		}
		for (AttributeNode a : newAttr) {
			if (!oldAttr.contains(a)) {
				changes.add(new Change(ChangeType.ADD, a));
			}
		}
		
		// ************************************
		// Check for changes in Instance Names
		// ************************************
		oldAttr.clear();
		oldPins.clear();
		newAttr.clear();
		newPins.clear();
		for (InstanceNode i : older.getInstances()) {
			if (!newer.getInstances().contains(i)) {
				changes.add(new Change(ChangeType.REMOVE, i));
			}
			else {
				for (InstanceNode j : newer.getInstances()) {
					if (j.equals(i)) {
						if (!j.getDevice().equals(i.getDevice())) {
							changes.add(new Change(ChangeType.MODIFY, i, j));
						}
					}
				}
			}
			// Attributes
			oldAttr.addAll(i.getAttributes());
			// Pins
			oldPins.addAll(i.getPins());
		}
		for (InstanceNode i : newer.getInstances()) {
			if (!older.getInstances().contains(i)) {
				changes.add(new Change(ChangeType.ADD, i));	
			}
			// Attributes
			newAttr.addAll(i.getAttributes());
			// Pins
			newPins.addAll(i.getPins());
		}

		// Net Attributes
		for (AttributeNode a : oldAttr) {
			if (!newAttr.contains(a)) {
				changes.add(new Change(ChangeType.REMOVE, a));
			}
			else {
				for (AttributeNode b : newAttr) {
					if (b.equals(a) && b.getParent().equals(a.getParent())) {
						if (!b.getValue().equals(a.getValue())) {
							changes.add(new Change(ChangeType.MODIFY, a, b));
						}
					}
				}
			}
		}
		for (AttributeNode a : newAttr) {
			if (!oldAttr.contains(a)) {
				changes.add(new Change(ChangeType.ADD, a));
			}
		}
		
		// Pin Nets
		for (PinNode p : newPins) {
			// Pin Names
			if (!oldPins.contains(p)) {
				changes.add(new Change(ChangeType.ADD, p));
			}
			else { // Pin Nets
				for (PinNode o : oldPins) {
					if (o.equals(p) && o.getParent().equals(p.getParent())) {
						if (!o.getNet().equals(p.getNet())) {
							changes.add(new Change(ChangeType.MODIFY, o, p));
							break;
						}
					}
				}
			}
		}
		for (PinNode p : oldPins) {
			// Pin Names
			if (!newPins.contains(p)) {
				changes.add(new Change(ChangeType.REMOVE, p));
			}
		}
		
		return changes;
	}
	
}
