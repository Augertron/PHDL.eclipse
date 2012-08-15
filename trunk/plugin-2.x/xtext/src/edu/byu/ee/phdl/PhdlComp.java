package edu.byu.ee.phdl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.Logger;
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

public class PhdlComp {

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

	private static String usage = "java -jar phdlcomp.jar";
	private static String version = "PHDL Compiler v2.1, ";
	private static String release = "August 15, 2012 release";

	private final static Logger logger = Logger.getLogger(PhdlComp.class);

	private static Options options;
	private static CommandLine commandLine;

	public static CommandLine getCommandLine() {
		return commandLine;
	}

	public static void main(String[] args) {
		System.out.println(version + release);
		Options options = setupOptions();
		parseArgs(options, args);

		try {
			Injector injector = new PhdlStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
			PhdlComp compileInstance = injector.getInstance(PhdlComp.class);
			compileInstance.compile();
		} catch (Exception e) {
			System.err.println("Unexpected error.");
			e.printStackTrace();
		}
	}

	private static void parseArgs(Options options, String[] args) {

		// parse the command line arguments
		CommandLineParser parser = new GnuParser();
		HelpFormatter formatter = new HelpFormatter();
		try {
			commandLine = parser.parse(options, args);
		} catch (ParseException e) {
			formatter.printHelp(usage, options, true);
		}

		// detect improper usage and display help
		if (args.length == 0 || commandLine.hasOption("help")) {
			formatter.printHelp(usage, options, true);
			System.exit(1);
		}
	}

	@SuppressWarnings("static-access")
	private static Options setupOptions() {
		options = new Options();
		options.addOption("h", "help", false, "print this message");
		options.addOption("q", "quiet", false, "be extra quiet reporting errors and warnings");
		options.addOption("v", "verbose", false, "be extra verbose reporting errors and warnings");
		options.addOption("p", "pads", false, "generate PADS netlist output");
		options.addOption("e", "eagle", false, "generate EAGLE script output");
		options.addOption("o", "osmond", false, "generate Osmond netlist output");
		options.addOption("a", "all", false, "generate all netlist output formats");
		options.addOption(OptionBuilder.withArgName("directory").hasArg()
				.withDescription("directory containing PHDL source files").create("src"));
		options.addOption(OptionBuilder.withArgName("directory").hasArg()
				.withDescription("directory to output generated files").create("gen"));
		options.addOption(OptionBuilder.withArgName("design_name").hasArg()
				.withDescription("specify top-level design name").create("top"));
		options.addOption(OptionBuilder.withArgName("key=value").hasArgs(2).withValueSeparator()
				.withDescription("specify arbitrary key-value pairs (beta)").create("pair"));
		return options;
	}

	private void compile() throws IOException {

		String srcFolder = commandLine.hasOption("src") ? commandLine.getOptionValue("src") : "src";
		String genFolder = commandLine.hasOption("gen") ? commandLine.getOptionValue("gen") : srcFolder + "-gen";
		fileAccess.setOutputPath(genFolder);

		// load the resources into a resource set
		ResourceSet set = resourceSetProvider.get();
		Set<Resource> resources = new LinkedHashSet<Resource>();
		List<String> srcFiles = getSourceFiles(srcFolder);
		if (srcFiles.isEmpty()) {
			logger.error("source folder contains no PHDL files.");
			System.exit(1);
		}

		for (String fileName : srcFiles) {
			Resource resource = set.getResource(URI.createFileURI(fileName), true);
			resources.add(resource);
		}

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

	}

	private List<String> getSourceFiles(String folderName) throws IOException {
		List<String> sourceFiles = new ArrayList<String>();
		File folder = new File(folderName);
		for (String item : folder.list()) {
			File f = new File(folder.getAbsolutePath() + File.separator + item);
			String relativePath = folderName + File.separator + item;
			if (isModelFile(f)) {
				sourceFiles.add(relativePath);
			} else if (f.isDirectory()) {
				sourceFiles.addAll(getSourceFiles(relativePath));
			}
		}
		return sourceFiles;
	}

	private boolean isModelFile(File f) {
		return f.isFile() && f.getName().endsWith("." + fileExtension);
	}
}
