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

	public class Change {
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

		public ChangeType getType() {
			return type;
		}

		public Node getNode() {
			return node1;
		}

		public Node getOld() {
			return node1;
		}

		public Node getNew() {
			return node2;
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
		ADD, REMOVE, MODIFY
	}

	public List<Change> getAllChanges() {
		return changes;
	}

	public List<Node> getAllAdditions() {
		List<Node> adds = new LinkedList<Node>();
		for (Change c : changes) {
			if (c.type == ChangeType.ADD) {
				adds.add(c.node1);
			}
		}
		return adds;
	}

	public List<Node> getAllRemovals() {
		List<Node> removes = new LinkedList<Node>();
		for (Change c : changes) {
			if (c.type == ChangeType.REMOVE) {
				removes.add(c.node1);
			}
		}
		return removes;
	}

	public List<Change> getAllModifications() {
		List<Change> mods = new LinkedList<Change>();
		for (Change c : changes) {
			if (c.type == ChangeType.MODIFY) {
				mods.add(c);
			}
		}
		return mods;
	}

	public List<Node> getAllModifyOlds() {
		List<Node> olds = new LinkedList<Node>();
		for (Change c : changes) {
			if (c.type == ChangeType.MODIFY) {
				olds.add(c.node1);
			}
		}
		return olds;
	}

	public List<Node> getAllModifyNews() {
		List<Node> news = new LinkedList<Node>();
		for (Change c : changes) {
			if (c.type == ChangeType.MODIFY) {
				news.add(c.node2);
			}
		}
		return news;
	}

	public void printChanges() {
		if (changes.isEmpty()) {
			System.out.println("*******NO CHANGES MADE******");
		} else {
			System.out.println("********CHANGES MADE********");
			for (Change c : changes)
				System.out.println(c);
		}
	}

	public List<Change> compareDesign(DesignNode older, DesignNode newer) {
		changes = new LinkedList<Change>();
		
		List<AttributeNode> oldAttr = new LinkedList<AttributeNode>();
		List<PinNode> oldPins = new LinkedList<PinNode>();
	
		List<AttributeNode> newAttr = new LinkedList<AttributeNode>();
		List<PinNode> newPins = new LinkedList<PinNode>();

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
			} else {
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
			} else {
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
			} else {
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
			} else { // Pin Nets
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
