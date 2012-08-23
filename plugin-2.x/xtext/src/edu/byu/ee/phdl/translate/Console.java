package edu.byu.ee.phdl.translate;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.Logger;

import edu.byu.ee.phdl.netlist.PhdlNetlist;

public class Console {

	private final static Logger logger = Logger.getLogger(Console.class);

	private static String usage = "java -jar phdl2.jar";
	private static String version = "PHDL translator v2.1, ";
	private static String release = "August 25, 2012 release.  ";

	private static CommandLine commandLine;

	public static void main(String[] args) {
		logger.info(version + release);
		parseArgs(setupOptions(), args);
		logger.info("starting translation...");

		String translatorClassName = commandLine.hasOption("tool") ? commandLine.getOptionValue("tool")
				: "DefaultTranslator";
		try {
			String fullyQualifiedClassName;
			if (translatorClassName.startsWith("edu.byu.ee.phdl.translate."))
				fullyQualifiedClassName = translatorClassName;
			else
				fullyQualifiedClassName = Console.class.getPackage().getName() + "." + translatorClassName;
			logger.info("using translator class: " + fullyQualifiedClassName);
			Class<?> clazz = Class.forName(fullyQualifiedClassName);
			DefaultTranslator translator = (DefaultTranslator) clazz.newInstance();
			Console console = new Console(translator);
			console.run();
		} catch (ClassNotFoundException e) {
			logger.error(e + ", translator not present on class path.");
		} catch (InstantiationException e) {
			logger.error(e + ", translator class must be concrete.");
		} catch (IllegalAccessException e) {
			logger.error(e + ", translator class must have a no-arg constructor.");
		}

		logger.info("translation complete.");
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
		if (commandLine.hasOption("help")) {
			formatter.printHelp(usage, options, true);
			System.exit(1);
		}
	}

	@SuppressWarnings("static-access")
	private static Options setupOptions() {
		Options options = new Options();
		options.addOption("?", "help", false, "print this message");
		options.addOption("h", "hierarchy", false, "display design hierarchy");
		options.addOption(OptionBuilder.withArgName("design_name").hasArg()
				.withDescription("compiled top level design name").create("top"));
		options.addOption(OptionBuilder.withArgName("class_name").hasArg()
				.withDescription("class<? extends DefaultTranslator> for generating arbitrarily formatted netlists")
				.create("tool"));
		return options;
	}

	private final DefaultTranslator translator;
	private final List<PhdlNetlist> netlists;

	public Console(DefaultTranslator translator) {
		if (translator == null) {
			throw new IllegalArgumentException("translator cannot be null.");
		}
		this.translator = translator;
		this.netlists = new ArrayList<PhdlNetlist>();
	}

	private void run() {
		String topDesignName = commandLine.hasOption("top") ? commandLine.getOptionValue("top") : null;
		if (topDesignName == null) {
			// get all designs with file extension *.xml
		} else {
			logger.info("translating design: " + topDesignName);
			// get only netlist with name equal to topDesignName
		}

		if (netlists.isEmpty()) {
			logger.error("no compiled PHDL designs found.");
			System.exit(1);
		}

		for (PhdlNetlist netlist : netlists) {
			translator.translate(netlist);

		}
	}
}