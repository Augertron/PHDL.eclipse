package phdl.analyzer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import phdl.exception.PhdlException;
import phdl.parser.DesignDeclaration;
import phdl.parser.ParsedDesigns;
import phdl.parser.PortAssignment;

public class Analyzer {

	private DesignHierarchy dh;
	private Set<Device> devices;
	private Set<Instance> instances;
	private Set<Net> nets;
	private NetGraph netgraph;
	
	public Analyzer(ParsedDesigns pd) throws PhdlException {
		dh = new DesignHierarchy(pd.getTopDesign());
		dh.makeHierarchy(pd);
		ArrayList<DesignDeclaration> designs = dh.getBF();
		Set<NetGraph> netgraphs = new HashSet<NetGraph>();
		for (DesignDeclaration d : designs) {
			netgraphs.add(makeNetGraph(d));
		}
	}
	
	private NetGraph makeNetGraph(DesignDeclaration d) {
		Set<PortAssignment> ports = dh.getPorts(d);
		
		return null;
	}
	
	private Set<Port> convertPortAssignments(PortAssignment pa) {
		Set<Port> ports = new HashSet<Port>();
		int lsb = pa.getLsb();
		int msb = pa.getMsb();
		int index = pa.getIndex();
		if (index != -1) {
			ports.add(new Port(pa.getName(), pa.getLine(), pa.getPos()));
			pa.getNets();
		}
		else if (lsb < msb) {
			
		}
		
		return ports;
	}
	
}
