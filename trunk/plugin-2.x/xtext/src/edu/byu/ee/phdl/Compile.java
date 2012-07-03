package edu.byu.ee.phdl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.google.inject.name.Named;

public class Compile {

	@Inject
	private Provider<ResourceSet> resourceSetProvider;

	@Inject
	private IResourceValidator validator;

	@Inject
	private IGenerator generator;

	@Inject
	private JavaIoFileSystemAccess fileAccess;

	@Inject
	@Named(Constants.FILE_EXTENSIONS)
	private String fileExtension;

	private List<String> getSourceFiles(String folderName) throws IOException {
		List<String> result = new ArrayList<String>();
		File folder = new File(folderName);
		for (String item : folder.list()) {
			File f = new File(folder.getAbsolutePath() + File.separator + item);
			String relativePath = folderName + File.separator + item;
			if (isModelFile(f)) {
				result.add(relativePath);
			} else if (f.isDirectory()) {
				result.addAll(getSourceFiles(relativePath));
			}
		}
		return result;
	}

	private boolean isModelFile(File f) {
		return f.isFile() && f.getName().endsWith("." + fileExtension);
	}

	private void run(String folderName) throws IOException {
		// load the resource
		ResourceSet set = resourceSetProvider.get();
		Set<Resource> resources = new LinkedHashSet<Resource>();
		for (String fileName : getSourceFiles(folderName)) {
			Resource resource = set.getResource(URI.createFileURI(fileName), true);
			resources.add(resource);
		}

		// configure and start the generator
		fileAccess.setOutputPath(folderName + "-gen");

		int numErrors = 0;
		for (Resource resource : resources) {
			// validate the resource
			List<Issue> issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
			for (Issue issue : issues) {
				if (issue.getSeverity().equals(Severity.ERROR))
					numErrors++;
			}

			if (numErrors != 0) {
				for (Issue issue : issues) {
					if (issue.getSeverity().equals(Severity.ERROR))
						System.out.println(issue);
				}
				for (Issue issue : issues) {
					if (issue.getSeverity().equals(Severity.WARNING))
						System.out.println(issue);
				}
				System.exit(-1);
			}
			for (Issue issue : issues) {
				System.out.println(issue);
			}
		}

		for (Resource resource : resources) {
			generator.doGenerate(resource, fileAccess);
		}

		System.out.println("Code generation finished.");
	}

	public static void main(String[] args) {
		parseArgs(args);
		try {
			Injector injector = new PhdlStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
			Compile compileInstance = injector.getInstance(Compile.class);
			compileInstance.run(args[0]);

		} catch (Exception e) {
			System.err.println("Unexpected error");
			e.printStackTrace();
		}
	}

	private static void parseArgs(String[] args) {
		// jsap = new JSAP();
		//
		// // directory containing phdl source files
		// FlaggedOption optDirectory = new FlaggedOption("directory");
		// optDirectory.setStringParser(JSAP.STRING_PARSER);
		// optDirectory.setShortFlag('d');
		// optDirectory.setLongFlag("dir");
		// optDirectory.setHelp("Directory where phdl source files are located");
		// jsap.registerParameter(optDirectory);
		//
		// // source files
		// UnflaggedOption optFileName = new UnflaggedOption("fileName");
		// optFileName.setStringParser(JSAP.STRING_PARSER);
		// optFileName.setGreedy(true);
		// optFileName.setHelp("PHDL source file name.");
		// jsap.registerParameter(optFileName);

		if (args.length != 2) {
			System.err.println("Please enter the name of the source folder.");
			System.exit(-1);
		} else {
			File folder = new File(args[0]);
			if (!(folder.exists() && folder.isDirectory())) {
				System.err.println("Source folder " + folder.getAbsolutePath() + " not found");
				System.exit(-1);
			}
		}
	}

}
