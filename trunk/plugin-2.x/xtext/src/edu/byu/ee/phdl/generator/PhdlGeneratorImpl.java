package edu.byu.ee.phdl.generator;

import org.apache.commons.cli.CommandLine;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

import com.thoughtworks.xstream.XStream;

import edu.byu.ee.phdl.elaboration.EDesign;
import edu.byu.ee.phdl.elaboration.PhdlElaborator;
import edu.byu.ee.phdl.erc.ElectricalRuleChecker;
import edu.byu.ee.phdl.netlist.PhdlNetlist;
import edu.byu.ee.phdl.phdl.Design;
import edu.byu.ee.phdl.phdl.Package;
import edu.byu.ee.phdl.phdl.PhdlModel;
import edu.byu.ee.phdl.utils.ExtensionCodes;
import edu.byu.ee.phdl.utils.PhdlUtils;

public class PhdlGeneratorImpl implements IGenerator {

	private static Logger logger = Logger.getLogger(PhdlGeneratorImpl.class);

	private final CommandLine commandLine = edu.byu.ee.phdl.compile.Compile.getCommandLine();

	@Override
	public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {

		// Iterable<EObject> iterable1 = IteratorExtensions.<EObject>
		// toIterable(resource.getAllContents());
		Iterable<PhdlModel> phdlModelFilter = IterableExtensions.<PhdlModel> filter(
				IteratorExtensions.<EObject> toIterable(resource.getAllContents()), PhdlModel.class);
		for (final PhdlModel m : phdlModelFilter) {
			EList<Design> designs = m.getDesigns();
			for (final Design design : designs) {
				if (design.isDesign()) {
					if (commandLine != null) {
						if (commandLine.hasOption("top")) {
							if (commandLine.getOptionValue("top").equals(design.getName())) {
								generate(fsa, design.getName(), design);
							}
						} else {
							generate(fsa, design.getName(), design);
						}
					} else {
						generate(fsa, design.getName(), design);
					}
				}
			}
		}

		// Iterable<EObject> iterable2 = IteratorExtensions.<EObject>
		// toIterable(resource.getAllContents());
		Iterable<Package> packageFilter = IterableExtensions.<Package> filter(
				IteratorExtensions.<EObject> toIterable(resource.getAllContents()), Package.class);
		for (final Package p : packageFilter) {
			EList<Design> designs = p.getDesigns();
			for (final Design design : designs) {
				if (design.isDesign()) {
					if (commandLine != null) {
						if (commandLine.hasOption("top")) {
							if (commandLine.getOptionValue("top").equals(design.getName())) {
								generate(fsa, p.getName() + "_" + design.getName(), design);
							}
						} else {
							generate(fsa, p.getName() + "_" + design.getName(), design);
						}
					} else {
						generate(fsa, p.getName() + "_" + design.getName(), design);
					}
				}
			}
		}
	}

	public void generate(IFileSystemAccess fsa, String name, Design design) {

		PhdlElaborator elaborator = new PhdlElaborator();
		EDesign eDesign = elaborator.elaborate(design);

		new ElectricalRuleChecker(eDesign);

		RefDesGenerator refDesGen = new RefDesGenerator(eDesign);
		String refDesFileName = name + ExtensionCodes.REFDES_EXT;
		fsa.generateFile(refDesFileName, refDesGen.getContents());
		logger.info("generated RDM (REFDES-Mapping): " + refDesFileName);

		BoMGenerator bomGen = new BoMGenerator(eDesign);
		String bomFileName = name + ExtensionCodes.BOM_EXT;
		fsa.generateFile(bomFileName, bomGen.getContents());
		logger.info("generated BOM (Bill of Material): " + bomFileName);

		InfoGenerator infoGen = new InfoGenerator(eDesign);
		String infoFileName = name + ExtensionCodes.INFO_EXT;
		fsa.generateFile(infoFileName, infoGen.getContents());
		logger.info("generated LSI (Layout Supplimentary Information): " + infoFileName);

		if (commandLine != null) {
			if (commandLine.hasOption("all") || commandLine.hasOption("pads")) {
				PADSGenerator padsGen = new PADSGenerator(eDesign);
				fsa.generateFile(name + ExtensionCodes.PADS_EXT, padsGen.getContents());
				logger.debug("generated ASC (PADS netlist): " + name);
			}

			if (commandLine.hasOption("all") || commandLine.hasOption("eagle")) {
				EagleGenerator eagleGen = new EagleGenerator(eDesign);
				fsa.generateFile(name + ExtensionCodes.EAGLE_EXT, eagleGen.getContents());
				logger.debug("generated SCR (EAGLE script): " + name);
			}

			if (commandLine.hasOption("all") || commandLine.hasOption("xml")) {
				PhdlNetlist netlist = new PhdlNetlist(eDesign);
				XStream xstream = new XStream();
				PhdlUtils.setAliasesForPhdlNetlist(xstream);
				String xmlFileName = name + ExtensionCodes.NET_EXT;
				fsa.generateFile(xmlFileName, xstream.toXML(netlist) + "\n");
				logger.info("generated XML (For use with netlist translator): " + xmlFileName);
			}

			if (commandLine.hasOption("hierarchy"))
				logger.info(eDesign.displayHierarchy());
		} else {
			PADSGenerator padsGen = new PADSGenerator(eDesign);
			fsa.generateFile(name + ExtensionCodes.PADS_EXT, padsGen.getContents());
			logger.debug("generated ASC (PADS netlist): " + name);

			EagleGenerator eagleGen = new EagleGenerator(eDesign);
			fsa.generateFile(name + ExtensionCodes.EAGLE_EXT, eagleGen.getContents());
			logger.debug("generated SCR (EAGLE script): " + name);

			PhdlNetlist netlist = new PhdlNetlist(eDesign);
			XStream xstream = new XStream();
			PhdlUtils.setAliasesForPhdlNetlist(xstream);
			String xmlFileName = name + ExtensionCodes.NET_EXT;
			fsa.generateFile(xmlFileName, xstream.toXML(netlist) + "\n");
			logger.info("generated XML (For use with netlist translator): " + xmlFileName);

			logger.info(eDesign.displayHierarchy());
		}

	}
}
