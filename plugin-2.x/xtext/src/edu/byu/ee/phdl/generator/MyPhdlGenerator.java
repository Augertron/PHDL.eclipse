package edu.byu.ee.phdl.generator;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

import com.google.inject.Inject;

import edu.byu.ee.phdl.elaboration.EDesign;
import edu.byu.ee.phdl.elaboration.PhdlElaborator;
import edu.byu.ee.phdl.phdl.Design;
import edu.byu.ee.phdl.phdl.Package;
import edu.byu.ee.phdl.phdl.PhdlModel;

public class MyPhdlGenerator implements IGenerator {

	private static Logger logger = Logger.getLogger(MyPhdlGenerator.class);

	@Inject
	PhdlElaborator elaborator;

	@Override
	public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {
		TreeIterator<EObject> allContents1 = resource.getAllContents();
		Iterable<EObject> iterable1 = IteratorExtensions.<EObject> toIterable(allContents1);
		Iterable<PhdlModel> phdlModelFilter = IterableExtensions.<PhdlModel> filter(iterable1, PhdlModel.class);
		for (final PhdlModel m : phdlModelFilter) {
			EList<Design> designs = m.getDesigns();
			for (final Design design : designs) {
				if (design.isDesign())
					generate(fsa, design.getName(), design);
			}
		}

		TreeIterator<EObject> allContents2 = resource.getAllContents();
		Iterable<EObject> iterable2 = IteratorExtensions.<EObject> toIterable(allContents2);
		Iterable<Package> packageFilter = IterableExtensions.<Package> filter(iterable2, Package.class);
		for (final Package p : packageFilter) {
			EList<Design> designs = p.getDesigns();
			for (final Design design : designs) {
				if (design.isDesign())
					generate(fsa, p.getName() + "_" + design.getName(), design);
			}
		}
	}

	public void generate(IFileSystemAccess fsa, String fileName, Design design) {

		EDesign eDesign = elaborator.elaborate(design);
		logger.info("elaborated: " + fileName);

		RefDesGenerator refDesGen = new RefDesGenerator(eDesign);
		fsa.generateFile(fileName + ExtensionCodes.REFDES_EXT, refDesGen.getContents());
		logger.debug("generated reference designators: " + fileName);

		BoMGenerator bomGen = new BoMGenerator(eDesign);
		fsa.generateFile(fileName + ExtensionCodes.BOM_EXT, bomGen.getContents());
		logger.debug("generated bill of material: " + fileName);

		InfoGenerator infoGen = new InfoGenerator(eDesign);
		fsa.generateFile(fileName + ExtensionCodes.INFO_EXT, infoGen.getContents());
		logger.debug("generated layout supplimentary information:" + fileName);

		NetListGenerator netListGen = new NetListGenerator(eDesign, refDesGen.getRefMap());
		fsa.generateFile(fileName + ExtensionCodes.PADS_EXT, netListGen.getContents());
		logger.debug("generated netlist: " + fileName);

		EagleGenerator eagleGen = new EagleGenerator(eDesign, refDesGen.getRefMap());
		fsa.generateFile(fileName + ExtensionCodes.EAGLE_EXT, eagleGen.getContents());
		logger.debug("generated EAGLE script: " + fileName);

		logger.info("generated output: " + fileName);
	}
}
