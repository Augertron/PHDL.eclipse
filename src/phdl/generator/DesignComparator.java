package phdl.generator;

import java.util.LinkedList;
import java.util.List;

import phdl.graph.DesignNode;
import phdl.graph.DeviceNode;
import phdl.graph.InstanceNode;
import phdl.graph.NetNode;
import phdl.graph.Node;

public class DesignComparator {

	private class Change {
		ChangeType type;
		Node node;
		
		Change(ChangeType type, Node node) {
			this.type = type;
			this.node = node;
		}
	}
	
	private enum ChangeType {
		ADD,
		REMOVE,
		MODIFY
	}
	
	public List<Change> compareDesign(DesignNode older, DesignNode newer) {
		List<Change> changes = new LinkedList<Change>();
		for (DeviceNode d : older.getDevices()) {
			if (!newer.getDevices().contains(d)) {
				changes.add(new Change(ChangeType.REMOVE, d));
			}
		}
		for (DeviceNode d : newer.getDevices()) {
			if (!older.getDevices().contains(d)) {
				changes.add(new Change(ChangeType.ADD, d));
			}
		}
		
		for (NetNode n : older.getNets()) {
			if (!newer.getNets().contains(n)) {
				changes.add(new Change(ChangeType.REMOVE, n));
			}
		}
		for (NetNode n : newer.getNets()) {
			if (!older.getNets().contains(n)) {
				changes.add(new Change(ChangeType.ADD, n));
			}
		}
		
		for (InstanceNode i : older.getInstances()) {
			if (!newer.getNets().contains(i)) {
				changes.add(new Change(ChangeType.REMOVE, i));
			}
		}
		for (InstanceNode i : newer.getInstances()) {
			if (!older.getNets().contains(i)) {
				changes.add(new Change(ChangeType.ADD, i));
			}
		}
		
		return changes;
	}
	
}
