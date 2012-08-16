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

import com.google.inject.Inject;

import edu.byu.ee.phdl.elaboration.EDesign;
import edu.byu.ee.phdl.elaboration.PhdlElaborator;
import edu.byu.ee.phdl.erc.ElectricalRuleChecker;
import edu.byu.ee.phdl.phdl.Design;
import edu.byu.ee.phdl.phdl.Package;
import edu.byu.ee.phdl.phdl.PhdlModel;

public class PhdlGeneratorImpl implements IGenerator {

	private static Logger logger = Logger.getLogger(PhdlGeneratorImpl.class);

	@Inject
	PhdlElaborator elaborator;

	private final CommandLine commandLine = edu.byu.ee.phdl.standalone.PhdlCompiler.getCommandLine();

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

		// elaborate the design
		EDesign eDesign = elaborator.elaborate(design);

		// perform the electrical rule check
		new ElectricalRuleChecker(eDesign);

		// generate reference designators

		generateRefDes(fsa, name, design);
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
				PADSGenerator netListGen = new PADSGenerator(eDesign, refDesGen.getRefMap());
				fsa.generateFile(name + ExtensionCodes.PADS_EXT, netListGen.getContents());
				logger.debug("generated ASC (PADS Netlist): " + name);
			}

			if (commandLine.hasOption("all") || commandLine.hasOption("eagle")) {
				EagleGenerator eagleGen = new EagleGenerator(eDesign, refDesGen.getRefMap());
				fsa.generateFile(name + ExtensionCodes.EAGLE_EXT, eagleGen.getContents());
				logger.debug("generated SCR (EAGLE Script): " + name);
			}
			if (commandLine.hasOption("hierarchy"))
				logger.info(eDesign.displayHierarchy());
		} else {
			PADSGenerator netListGen = new PADSGenerator(eDesign, refDesGen.getRefMap());
			fsa.generateFile(name + ExtensionCodes.PADS_EXT, netListGen.getContents());
			logger.debug("generated ASC (PADS Netlist): " + name);

			EagleGenerator eagleGen = new EagleGenerator(eDesign, refDesGen.getRefMap());
			fsa.generateFile(name + ExtensionCodes.EAGLE_EXT, eagleGen.getContents());
			logger.debug("generated SCR (EAGLE Script): " + name);

			logger.info(eDesign.displayHierarchy());
		}

		// logger.info("Finished generating output: " + name);
	}

	private void generateRefDes(IFileSystemAccess fsa, String name, Design design) {
		// TODO Auto-generated method stub

	}
}
