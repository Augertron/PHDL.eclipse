import edu.byu.ee.phdl.netlist.PhdlNet;
import edu.byu.ee.phdl.netlist.PhdlNetlist;
import edu.byu.ee.phdl.netlist.PhdlPart;
import edu.byu.ee.phdl.netlist.PhdlPin;
import edu.byu.ee.phdl.translate.DefaultTranslator;

public class OsmondTranslator extends DefaultTranslator {

	public OsmondTranslator() {
		fileExtension = ".osm";
	}

	@Override
	protected String translateHeader() {
		String header = "";
		return header;
	}

	@Override
	protected String translateNet(PhdlNet net) {
		StringBuilder sb = new StringBuilder();
		sb.append("Signal \"" + net.getName() + "\"\n  { ");
		for (PhdlPin pin : net.getPins()) {
			sb.append(pin.getPartName() + "-" + pin.getPinName() + " ");
		}
		sb.append("}\n");
		return sb.toString();
	}

	@Override
	protected String translateNets(PhdlNetlist netlist) {
		StringBuilder sb = new StringBuilder();
		for (PhdlNet net : netlist.getNets()) {
			sb.append(translateNet(net));
		}
		return sb.toString();
	}

	@Override
	protected String translatePart(PhdlPart part) {
		return "Part " + part.getFootprint() + " { Name \"" + part.getName() + "\" }\n";
	}

	@Override
	protected String translateParts(PhdlNetlist netlist) {
		StringBuilder sb = new StringBuilder();
		for (PhdlPart part : netlist.getParts()) {
			sb.append(translatePart(part));
		}
		return sb.toString();
	}
}
