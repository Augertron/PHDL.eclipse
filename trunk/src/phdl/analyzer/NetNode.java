package phdl.analyzer;

import java.util.HashSet;
import java.util.Set;

import phdl.TestDriver;

public class NetNode extends Node {

	/**
	 * Net nodes can connect to any other type of node in any quantity
	 */
	private Set<Node> nodes;

	public NetNode() {
		nodes = new HashSet<Node>();
	}

	public void addNode(Node node) {
		nodes.add(node);
		if (node.getType() == NodeType.NET) {
			if (!((NetNode)node).getNetNodes().contains(this))
				((NetNode)node).addNode(this);
		}
		else if (node.getType() == NodeType.PIN) {
			((PinNode)node).setNet(this);
		}
		else {
			((PortNode)node).setNet(this);
		}
	}

	public Set<Node> getAllNodes() {
		return nodes;
	}
	
	public Set<PinNode> getPinNodes() {
		Set<PinNode> pins = new HashSet<PinNode>();
		for (Node n : nodes) {
			if (n.getType() == NodeType.PIN) {
				pins.add((PinNode)n);
			}
		}
		return pins;
	}
	
	public Set<PortNode> getPortNodes() {
		Set<PortNode> ports = new HashSet<PortNode>();
		for (Node n : nodes) {
			if (n.getType() == NodeType.PORT) {
				ports.add((PortNode)n);
			}
		}
		return ports;
	}
	
	public Set<NetNode> getNetNodes() {
		Set<NetNode> nets = new HashSet<NetNode>();
		for (Node n : nodes) {
			if (n.getType() == NodeType.NET) {
				nets.add((NetNode)n);
			}
		}
		return nets;
	}
	
	public boolean connectedTo(Node n) {
		return (nodes.contains(n));
	}
	
	public boolean connectedToNet() {
		for (Node n : nodes) {
			if (n.getType() == NodeType.NET) {
				return true;
			}
		}
		return false;
	}
	
	public void removeNet(NetNode n) {
		for (NetNode p : this.getNetNodes()) {
			if (p.equals(n)) {
				nodes.remove(p);
			}
		}
	}
	
	public boolean mergeNet(NetNode n) {
		for (NetNode m : this.getNetNodes()) {
			if (m.equals(n)) {
				for (Node a : m.getAllNodes()) {
					addNode(a);
					if (a.getType() == NodeType.NET) {
						((NetNode)a).removeNet(m);
					}
				}
				nodes.remove(m);
				nodes.remove(this);
				name = name + "$" + m.getName();
				return true;
			}
		}
		return false;
	}
	
	public void superNet() {
		while (!getNetNodes().isEmpty()) {
			for (NetNode n : getNetNodes()) {
				this.mergeNet(n);
			}
		}
	}

	@Override
	public NodeType getType() {
		return NodeType.NET;
	}

	private static void printGraph(NetNode cur, Set<NetNode> nodes) {
		if (!nodes.contains(cur)) {
			nodes.add(cur);
			System.out.println(cur.toString());
			for (PinNode n : cur.getPinNodes()) {
				System.out.println("\t" + n.toString());
			}
			for (PortNode p : cur.getPortNodes()) {
				System.out.println("\t" + p.toString());
			}
			for (NetNode n : cur.getNetNodes()) {
				System.out.println("\t" + n.toString());
			}
			for (NetNode n : cur.getNetNodes()) {
				printGraph(n, nodes);
			}
		}
		
	}
	
	/*
	 * getType
	 * addNode
	 * getNetNodes
	 * getPinNodes
	 * getPortNodes
	 * 
	 */
	public static boolean unitTest() {
		boolean success = true;
		Node net = new NetNode();
		net.setName("net");
		Node pin = new PinNode();
		pin.setName("pin");
		Node port = new PortNode();
		port.setName("port");
		if (net.getType() != NodeType.NET) {
			TestDriver.err("getType()", "type = NET" , "type = " + net.getType().toString());
			success = false;
		}
		if (pin.getType() != NodeType.PIN) {
			TestDriver.err("getType()", "type = PIN" , "type = " + pin.getType().toString());
			success = false;
		}
		if (port.getType() != NodeType.PORT) {
			TestDriver.err("getType()", "type = PORT" , "type = " + port.getType().toString());
			success = false;
		}
		
		NetNode N = new NetNode();
		N.setName("main");
		N.addNode(net);
		N.addNode(pin);
		N.addNode(port);
		
		if (!((NetNode)net).getAllNodes().contains(N)) {
			TestDriver.err("addNode()", "net -> N", "doesn't");
			success = false;
		}
		if (!((PinNode)pin).getNet().equals(N)) {
			TestDriver.err("addNode()", "pin -> N", "doesn't");
			success = false;
		}
		if (!((PortNode)port).getNet().equals(N)) {
			TestDriver.err("addNode()", "port -> N", "doesn't");
			success = false;
		}
		
		if (N.getAllNodes().size() != 3) {
			TestDriver.err("addNode()", "size = 3", "size = " + N.getAllNodes().size());
			success = false;
		}
		if (!N.getAllNodes().contains(net)) {
			TestDriver.err("addNode()", "net", "false");
			success = false;
		}
		if (!N.getAllNodes().contains(pin)) {
			TestDriver.err("addNode()", "pin", "false");
			success = false;
		}
		if (!N.getAllNodes().contains(port)) {
			TestDriver.err("addNode()", "port", "false");
			success = false;
		}
		
		if (N.getNetNodes().size() != 1) {
			TestDriver.err("getNetNodes()", "size = 1", "size = " + N.getNetNodes().size());
			success = false;
		}
		if (!N.getNetNodes().contains(net)) {
			TestDriver.err("getNetNodes()", "contains net", "doesn't");
			success = false;
		}
		
		if (N.getPinNodes().size() != 1) {
			TestDriver.err("getPinNodes()", "size = 1", "size = " + N.getPinNodes().size());
			success = false;
		}
		if (!N.getPinNodes().contains(pin)) {
			TestDriver.err("getPinNodes()", "contains pin", "doesn't");
			success = false;
		}
		
		if (N.getPortNodes().size() != 1) {
			TestDriver.err("getPortNodes()", "size = 1", "size = " + N.getPortNodes().size());
			success = false;
		}
		if (!N.getPortNodes().contains(port)) {
			TestDriver.err("getPortNodes()", "contains port", "doesn't");
			success = false;
		}
		
		Node pin2 = new PinNode();
		pin2.setName("pin2");
		Node net2 = new NetNode();
		net2.setName("net2");
		Node pin3 = new PinNode();
		pin3.setName("pin3");
		
		((NetNode)net2).addNode(pin3);
		((NetNode)net).addNode(pin2);
		((NetNode)net).addNode(net2);
		
		N.mergeNet((NetNode)net);
		
		if (!N.getName().equals("main$net")) {
			TestDriver.err("mergeNet()", "name = main$Net", "name = " + N.getName());
			success = false;
		}
		if (N.getAllNodes().size() != 4) {
			TestDriver.err("mergeNet()", "#nodes = 4", "#nodes = " + N.getAllNodes().size());
			success = false;
		}
		if (!N.getAllNodes().contains(net2)) {
			TestDriver.err("mergeNet()", "contain net2", "doesn't");
			success = false;
		}
		if (N.getAllNodes().contains(net)) {
			TestDriver.err("mergeNet()", "not contain net", "does");
			success = false;
		}
		if (!((NetNode)net2).getNetNodes().contains(N)) {
			TestDriver.err("mergeNet()", "net2 -> N", "doesn't");
			success = false;
		}
		if (((NetNode)net2).getNetNodes().contains(net)) {
			TestDriver.err("mergeNet()", "net2 -/> net", "does");
			success = false;
		}
		
		N.mergeNet((NetNode)net2);
		if (!N.getName().equals("main$net$net2")) {
			TestDriver.err("mergeNet()", "name = main$Net$net2", "name = " + N.getName());
			success = false;
		}
		if (N.getAllNodes().size() != 4) {
			TestDriver.err("mergeNet()", "#nodes = 4", "#nodes = " + N.getAllNodes().size());
			success = false;
		}
		if (!N.getAllNodes().contains(pin)) {
			TestDriver.err("mergeNet()", "contain pin", "doesn't");
			success = false;
		}
		if (!N.getAllNodes().contains(pin2)) {
			TestDriver.err("mergeNet()", "contain pin2", "doesn't");
			success = false;
		}
		if (!N.getAllNodes().contains(pin3)) {
			TestDriver.err("mergeNet()", "contain pin3", "doesn't");
			success = false;
		}
		if (!N.getAllNodes().contains(port)) {
			TestDriver.err("mergeNet()", "contain port", "doesn't");
			success = false;
		}
		
		if (!((PinNode)pin).getNet().equals(N)) {
			TestDriver.err("mergeNet()", "pin->N", "doesn't");
			success = false;
		}
		if (!((PinNode)pin2).getNet().equals(N)) {
			TestDriver.err("mergeNet()", "pin2->N", "doesn't");
			success = false;
		}
		if (!((PinNode)pin3).getNet().equals(N)) {
			TestDriver.err("mergeNet()", "pin3->N", "doesn't");
			success = false;
		}
		if (!((PortNode)port).getNet().equals(N)) {
			TestDriver.err("mergeNet()", "port->N", "doesn't");
			success = false;
		}
		
		if (N.getAllNodes().contains(net)) {
			TestDriver.err("mergeNet()", "not contain net", "does");
			success = false;
		}
		if (N.getAllNodes().contains(net2)) {
			TestDriver.err("mergeNet()", "not contain net2", "does");
			success = false;
		}
		
		
		// Much more complex graph
		// All NetNodes
		NetNode N1 = new NetNode();
		N1.setName("N1");
		NetNode N2 = new NetNode();
		N2.setName("N2");
		NetNode N3 = new NetNode();
		N3.setName("N3");
		NetNode N4 = new NetNode();
		N4.setName("N4");
		NetNode N5 = new NetNode();
		N5.setName("N5");
		NetNode N6 = new NetNode();
		N6.setName("N6");
		NetNode N7 = new NetNode();
		N7.setName("N7");
		// All PinNodes
		PinNode P1 = new PinNode();
		P1.setName("P1");		
		PinNode P2 = new PinNode();
		P2.setName("P2");
		PinNode P3 = new PinNode();
		P3.setName("P3");
		PinNode P4 = new PinNode();
		P4.setName("P4");
		PinNode P5 = new PinNode();
		P5.setName("P5");
		// All PortNodes
		PortNode PT1 = new PortNode();
		PT1.setName("PT1");
		PortNode PT2 = new PortNode();
		PT2.setName("PT2");
		PortNode PT3 = new PortNode();
		PT3.setName("PT3");
		
		N1.addNode(N2);
		N1.addNode(N3);
		N1.addNode(N4);
		N1.addNode(N4);
		N1.addNode(N5);
		N2.addNode(P1);
		N2.addNode(P2);
		N3.addNode(PT3);
		N3.addNode(N5);
		N5.addNode(P5);
		N5.addNode(PT2);
		N5.addNode(N3);
		N4.addNode(P3);
		N4.addNode(PT1);
		N4.addNode(N6);
		N6.addNode(N7);
		N7.addNode(P4);
		
		N1.superNet();		
		
		if (!N1.getNetNodes().isEmpty()) {
			TestDriver.err("superNet()", "no net nodes left", N1.getNetNodes().size() + " remaining nodes");
			success = false;
		}
		if (!N1.getPinNodes().contains(P1)) {
			TestDriver.err("superNet()", "P1 connected", "not");
			success = false;
		}
		if (!N1.getPinNodes().contains(P2)) {
			TestDriver.err("superNet()", "P2 connected", "not");
			success = false;
		}
		if (!N1.getPinNodes().contains(P3)) {
			TestDriver.err("superNet()", "P3 connected", "not");
			success = false;
		}
		if (!N1.getPinNodes().contains(P4)) {
			TestDriver.err("superNet()", "P4 connected", "not");
			success = false;
		}
		if (!N1.getPinNodes().contains(P5)) {
			TestDriver.err("superNet()", "P5 connected", "not");
			success = false;
		}
		
		if (!N1.getPortNodes().contains(PT1)) {
			TestDriver.err("superNet()", "PT1 connected", "not");
			success = false;
		}
		if (!N1.getPortNodes().contains(PT2)) {
			TestDriver.err("superNet()", "PT2 connected", "not");
			success = false;
		}
		if (!N1.getPortNodes().contains(PT3)) {
			TestDriver.err("superNet()", "PT3 connected", "not");
			success = false;
		}
		if (N1.getAllNodes().size() != 8) {
			TestDriver.err("superNet()", "8 nodes attached", N1.getAllNodes().size() + " attached");
			success = false;
		}
		
		return success;
	}
}
