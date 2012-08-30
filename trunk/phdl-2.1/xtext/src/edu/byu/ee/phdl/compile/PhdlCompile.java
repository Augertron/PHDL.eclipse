package edu.byu.ee.phdl.compile;

import java.io.File;
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

import edu.byu.ee.phdl.PhdlStandaloneSetupGenerated;

public class PhdlCompile {

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
	private static String release = "August 15, 2012 release.  ";

	private final static Logger logger = Logger.getLogger(PhdlCompile.class);

	private static CommandLine commandLine;

	public static CommandLine getCommandLine() {
		return commandLine;
	}

	public static void main(String[] args) {
		logger.info(version + release);
		parseArgs(setupOptions(), args);

		try {
			Injector injector = new PhdlStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
			PhdlCompile consoleInstance = injector.getInstance(PhdlCompile.class);
			consoleInstance.run();
		} catch (Exception e) {
			logger.error("unexpected error.");
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
			System.exit(1);
		}

		// detect improper usage and display help
		if (args.length == 0 || commandLine.hasOption("help")) {
			formatter.printHelp(usage, options, true);
			System.exit(1);
		}

		if (commandLine.hasOption("quiet") && commandLine.hasOption("verbose")) {
			logger.error("options: -quiet and -verbose may not be used simultaneously.");
			System.exit(1);
		}
	}

	@SuppressWarnings("static-access")
	private static Options setupOptions() {
		Options options = new Options();
		options.addOption("?", "help", false, "print this message");
		options.addOption("q", "quiet", false, "supress reporting of warnings");
		options.addOption("v", "verbose", false, "report any extra information");
		options.addOption("p", "pads", false, "generate PADS netlist output");
		options.addOption("e", "eagle", false, "generate EAGLE script output");
		options.addOption("x", "xml", false, "generate XML netlist output");
		options.addOption("a", "all", false, "generate all netlist output formats");
		options.addOption("h", "hierarchy", false, "display design hierarchy");
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

	private void run() {
		logger.info("compilation started.");

		// obtain src and gen folders from the command-line if present
		String srcFolder = commandLine.hasOption("src") ? commandLine.getOptionValue("src") : "src";
		String genFolder = commandLine.hasOption("gen") ? commandLine.getOptionValue("gen") : srcFolder + "-gen";
		fileAccess.setOutputPath(genFolder);

		// check that src directory exists
		if (!new File(srcFolder).exists()) {
			logger.error("directory " + srcFolder + " does not exist.");
			System.exit(1);
		}

		// work with only the top design if specified
		if (commandLine.hasOption("top"))
			logger.info("working with specified design: " + commandLine.getOptionValue("top"));
		else
			logger.info("working with all top-level designs in source directory.");

		// check source files are present
		List<String> srcFiles = getSourceFiles(srcFolder);
		if (srcFiles.isEmpty()) {
			logger.error("source folder contains no PHDL files.");
			System.exit(1);
		}

		// load the resources into a resource set
		Set<Resource> resources = new LinkedHashSet<Resource>();
		ResourceSet set = resourceSetProvider.get();
		for (String fileName : srcFiles) {
			Resource resource = set.getResource(URI.createFileURI(fileName), true);
			resources.add(resource);
		}

		int numErrors = 0;
		for (Resource resource : resources) {
			// validate the resource
			List<Issue> issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);

			// check for errors
			for (Issue issue : issues) {
				if (issue.getSeverity().equals(Severity.ERROR))
					numErrors++;
			}

			if (numErrors > 0) {
				// display errors (most significant problems) first
				for (Issue issue : issues) {
					if (issue.getSeverity().equals(Severity.ERROR))
						logger.error(issue.toString());
				}
				// display warnings only if the -quiet option is not set
				if (!commandLine.hasOption("quiet")) {
					for (Issue issue : issues) {
						if (issue.getSeverity().equals(Severity.WARNING))
							logger.warn(issue.toString());
					}
				}
				// display info only if the -verbose option is set
				if (commandLine.hasOption("verbose")) {
					for (Issue issue : issues) {
						if (issue.getSeverity().equals(Severity.INFO))
							logger.info(issue.toString());
					}
				}
				// exit abnormally since compilation cannot proceed with errors
				// in source code
				System.exit(1);
			}

			// report warnings and info depending on command-line options
			for (Issue issue : issues) {
				if (issue.getSeverity().equals(Severity.WARNING) && !commandLine.hasOption("quiet"))
					logger.warn(issue.toString());
				if (issue.getSeverity().equals(Severity.INFO) && commandLine.hasOption("verbose"))
					logger.info(issue.toString());
			}
		}

		// perform the actual generation
		for (Resource resource : resources) {
			generator.doGenerate(resource, fileAccess);
		}
		logger.info("compilation complete.");
	}

	private List<String> getSourceFiles(String directory) {
		List<String> sourceFiles = new ArrayList<String>();
		File folder = new File(directory);
		for (String item : folder.list()) {
			File f = new File(folder.getAbsolutePath() + File.separator + item);
			String relativePath = directory + File.separator + item;
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
