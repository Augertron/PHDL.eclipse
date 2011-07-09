package phdl.graph;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class DesignNode extends Node {

	private Set<PortNode> ports;
	private Set<DeviceNode> devices;
	private List<InstanceNode> instances;
	private List<NetNode> nets;

	public DesignNode() {
		ports = new TreeSet<PortNode>();
		devices = new TreeSet<DeviceNode>();
		instances = new ArrayList<InstanceNode>();
		nets = new ArrayList<NetNode>();
	}

	public Set<DeviceNode> getDevices() {
		return devices;
	}

	public boolean addDevice(DeviceNode d) {
		return devices.add(d);
	}

	public boolean hasDevices() {
		return (!devices.isEmpty());
	}

	public List<InstanceNode> getInstances() {
		return instances;
	}

	public boolean addInstance(InstanceNode i) {
		return instances.add(i);
	}

	public boolean hasInstances() {
		return (!instances.isEmpty());
	}

	public List<NetNode> getNets() {
		return nets;
	}

	public boolean addNet(NetNode n) {
		return nets.add(n);
	}

	public boolean hasNets() {
		return (!nets.isEmpty());
	}

	public boolean hasPorts() {
		return (!ports.isEmpty());
	}

	public Set<PortNode> getPorts() {
		return ports;
	}

	public boolean addPort(PortNode p) {
		return (ports.add(p));
	}

	@Override
	public boolean equals(Object o) {
		return name.equals(((DesignNode) o).getName());
	}

	@Override
	public String toString() {
		return "DESIGN " + name;
	}

	@Override
	public NodeType getType() {
		return NodeType.DESIGN;
	}

	public DeviceNode getDevice(String devName) {
		for (DeviceNode d : devices) {
			if (d.getName().equals(devName))
				return d;
		}
		return null;
	}

	public NetNode getNet(String netName) {
		for (NetNode n : nets) {
			if (n.getName().equals(netName))
				return n;
		}
		return null;
	}

	public InstanceNode getInstance(String instName) {
		for (InstanceNode i : instances) {
			if (i.getName().equals(instName))
				return i;
		}
		return null;
	}

	public List<InstanceNode> getAllInstances(String instName) {
		List<InstanceNode> allInstances = new ArrayList<InstanceNode>();
		for (InstanceNode i : instances) {
			if (i.getName().length() < instName.length())
				continue;
			String prefix = i.getName().substring(0, instName.length());
			if (prefix.equals(instName)) {
				String suffix = i.getName().substring(instName.length());
				if (suffix.length() == 0 || suffix.charAt(0) == '(') {
					allInstances.add(i);
				}
			}
		}
		return allInstances;
	}

	public List<NetNode> getAllNets(String netName) {
		List<NetNode> allNets = new ArrayList<NetNode>();
		for (NetNode n : nets) {
			if (n.getName().length() < netName.length())
				continue;
			String prefix = n.getName().substring(0, netName.length());
			if (prefix.equals(netName)) {
				String suffix = n.getName().substring(netName.length());
				if (suffix.length() == 0 || suffix.charAt(0) == '[') {
					allNets.add(n);
				}
			}
		}
		return allNets;
	}

	public void printDesignNode() {
		System.out.println(toString());
		for (DeviceNode dev : getDevices()) {
			System.out.println("\t" + dev.toString());
			for (AttributeNode a : dev.getAttributes()) {
				System.out.println("\t\t" + a.toString());
			}
			for (PinNode pn : dev.getPins()) {
				System.out.println("\t\t" + pn.toString());
			}
		}
		for (InstanceNode iNode : getInstances()) {
			System.out.println("\t" + iNode.toString());
			for (AttributeNode a : iNode.getAttributes()) {
				System.out.println("\t\t" + a.toString());
			}
			for (PinNode p : iNode.getPins()) {
				if (p.getNet() != null) {
					System.out.println("\t\t" + p.toString() + " <= "
							+ p.getNet().toString());
				} else {
					System.out.println("\t\t" + p.toString());
				}
			}
		}
		for (NetNode n : getNets()) {
			System.out.println("\t" + n.toString());
		}
	}

	public void dottyDump(String fileName) {
		BufferedWriter dotty = null;

		int netRef = 0;
		int pinRef = 0;
		Map<Integer, NetNode> netMap = new HashMap<Integer, NetNode>();
		Map<Integer, PinNode> pinMap = new HashMap<Integer, PinNode>();

		String format = "ordering=out;\r\n"
				+ "	ranksep=.4;\r\n"
				+ "	bgcolor=\"lightgrey\"; node [fixedsize=false, fontsize=12, fontname=\"Helvetica-bold\", fontcolor=\"blue\"\r\n"
				+ "		width=.25, height=.25, color=\"black\", fillcolor=\"white\", style=\"filled, solid, bold\"];\r\n"
				+ "	edge [arrowsize=.5, color=\"black\", style=\"bold\"]";

		try {
			dotty = new BufferedWriter(new FileWriter(fileName));
		} catch (IOException e) {
			System.out.println("Problem creating file: " + fileName);
			System.exit(1);
		}
		try {
			dotty.write("digraph {\n\n");
			dotty.write(format);

			for (NetNode n : nets) {
				dotty.write("  n" + netRef + " [label=\"" + n.getName()
						+ "\"];\n");
				netMap.put(netRef, n);
				netRef++;
			}
			for (InstanceNode i : instances) {
				for (PinNode p : i.getPins()) {
					dotty.write("  p" + pinRef + " [label=\"" + i.getName()
							+ "." + p.getName() + "\"];\n");
					pinMap.put(pinRef, p);
					pinRef++;
				}
			}

			for (int k = 0; k < netMap.keySet().size(); k++) {
				for (NetNode n : netMap.get(k).getNetNodes()) {
					for (Integer i : netMap.keySet()) {
						if (netMap.get(i).getName().equals(n.getName())) {
							dotty.write("  n" + k + " -> " + "n" + i + ";\n");
						}
					}
				}
			}

			for (Integer i : pinMap.keySet()) {
				for (Integer j : netMap.keySet()) {
					if (netMap.get(j).getName()
							.equals(pinMap.get(i).getNet().getName())) {
						dotty.write("  p" + i + " -> " + "n" + j + ";\n");
					}
				}
			}

			dotty.write("}\n");
			dotty.close();
		} catch (IOException e) {
			System.out.println("Prolem writing dotty file.");
			System.exit(1);
		}
		System.out.println("Wrote file: " + fileName);
	}

	public List<Integer> getAllIndices(String instName) {
		List<Integer> allIndices = new ArrayList<Integer>();
		for (InstanceNode i : getAllInstances(instName)) {
			int start = i.getName().indexOf('(');
			int end = i.getName().indexOf(')');
			String index = i.getName().substring(start + 1, end);
			allIndices.add(Integer.parseInt(index));
		}
		return allIndices;
	}

	public List<Integer> getAllNetIndices(String netName) {
		List<Integer> allIndices = new ArrayList<Integer>();
		for (NetNode n : getAllNets(netName)) {
			int start = n.getName().indexOf('[');
			int end = n.getName().indexOf(']');

			if (start != -1 && end != -1) {
				String index = n.getName().substring(start + 1, end);
				allIndices.add(Integer.parseInt(index));
			}

		}
		return allIndices;
	}

	public boolean isDeviceInstanced(DeviceNode dev) {
		System.out.println("testing");
		for (InstanceNode i : instances) {
			if (i.getDevice().equals(dev)) {
				return true;
			}
		}
		return false;
	}

	public void superNet() {
		for (NetNode n : nets) {

		}
	}
}