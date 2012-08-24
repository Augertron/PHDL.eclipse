package edu.byu.ee.phdl.translate;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.Logger;

import com.thoughtworks.xstream.XStream;

import edu.byu.ee.phdl.netlist.PhdlNetlist;
import edu.byu.ee.phdl.utils.ExtensionCodes;
import edu.byu.ee.phdl.utils.PhdlUtils;

public class Console {

	private final static Logger logger = Logger.getLogger(Console.class);

	private static String usage = "java -jar phdltran.jar";
	private static String version = "PHDL translator v2.1, ";
	private static String release = "August 25, 2012 release.  ";

	private static CommandLine commandLine;

	public static void main(String[] args) {
		parseArgs(setupOptions(), args);

		logger.info(version + release);

		String translatorClassName = commandLine.hasOption("tool") ? commandLine.getOptionValue("tool")
				: "edu.byu.ee.phdl.translate.DefaultTranslator";
		try {
			logger.info("using translator class: " + translatorClassName);
			Class<?> clazz = Class.forName(translatorClassName);
			DefaultTranslator translator = (DefaultTranslator) clazz.newInstance();
			Console console = new Console(translator);
			console.run();

		} catch (ClassNotFoundException e) {
			logger.error(e + ", translator class must be present on class path.");
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
		options.addOption(OptionBuilder
				.withArgName("class_name")
				.hasArg()
				.withDescription(
						"fully qualified class name extending DefaultTranslator for generating arbitrarily formatted netlists for a particular layout tool.")
				.create("tool"));
		options.addOption(OptionBuilder
				.withArgName("file_name")
				.hasArg()
				.withDescription(
						"PHDL netlist source directory or file name with *.xml extension.  If not specified, the translator will attempt to translate all *.xml files in the current directory.")
				.create("src"));
		options.addOption(OptionBuilder
				.withArgName("file_name")
				.hasArg()
				.withDescription(
						"Output file name (with or without extension). If not specified, output name(s) will be constructed from the *.xml netlist file name.")
				.create("gen"));
		return options;
	}

	private final DefaultTranslator translator;
	private final Map<String, PhdlNetlist> netlists;

	public Console(DefaultTranslator translator) {
		if (translator == null) {
			throw new IllegalArgumentException("translator cannot be null.");
		}
		this.translator = translator;
		this.netlists = new HashMap<String, PhdlNetlist>();
	}

	private String extractDesignName(String fileName) {
		String str = fileName.substring(fileName.lastIndexOf(File.separator) + 1, fileName.lastIndexOf("."));
		return str;
	}

	private void getAllNetlistFiles(String directory) {
		File folder = new File(directory);
		logger.info("using directory: " + folder.getAbsolutePath());
		File[] files = folder.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile() && files[i].getName().toLowerCase().endsWith(ExtensionCodes.XML_EXT)) {
				logger.info("translating source file: " + files[i].getName());
				String xml = PhdlUtils.readStringFromFile(files[i].getAbsolutePath());
				if (xml == null) {
					logger.error("unable to read file: " + files[i].getAbsolutePath());
					System.exit(1);
				}
				XStream xstream = new XStream();
				PhdlUtils.setAliasesForPhdlNetlist(xstream);
				try {
					PhdlNetlist netlist = (PhdlNetlist) xstream.fromXML(xml);
					netlists.put(extractDesignName(files[i].getAbsolutePath()), netlist);
				} catch (Exception e) {
					logger.warn("skipping invalid PHDL netlist file: " + files[i].getAbsolutePath());
				}
			}
		}
	}

	private void getNetlistFile(String srcFile) {
		File file = new File(srcFile);
		logger.info("translating source file: " + file.getName());
		String xml = PhdlUtils.readStringFromFile(file.getAbsolutePath());
		if (xml == null) {
			logger.error("unable to read file: " + file.getAbsolutePath());
			System.exit(1);
		}

		XStream xstream = new XStream();
		PhdlUtils.setAliasesForPhdlNetlist(xstream);
		Object obj = xstream.fromXML(xml);
		if (obj instanceof PhdlNetlist) {
			PhdlNetlist netlist = (PhdlNetlist) obj;
			netlists.put(extractDesignName(file.getAbsolutePath()), netlist);
		}
	}

	private void run() {
		logger.info("translation started...");

		String src = commandLine.hasOption("src") ? commandLine.getOptionValue("src") : ".";
		File file = new File(src);
		if (!file.exists()) {
			logger.error("source does not exist: " + file.getAbsolutePath());
			System.exit(1);
		}

		if (file.getAbsolutePath().toLowerCase().endsWith(ExtensionCodes.XML_EXT)) {
			getNetlistFile(file.getAbsolutePath());
		} else {
			getAllNetlistFiles(file.getAbsolutePath());
		}

		if (netlists.isEmpty()) {
			logger.error("no PHDL netlists found, exiting.");
			System.exit(1);
		}

		String gen;
		if (file.isDirectory()) {
			gen = commandLine.hasOption("gen") ? commandLine.getOptionValue("gen") : file.getAbsolutePath();
		} else {
			gen = new File(".").getAbsolutePath();
		}
		File genFolder = new File(gen);
		if (!genFolder.isDirectory()) {
			logger.error("invalid output folder specified: " + genFolder.getAbsolutePath());
			System.exit(1);
		}

		for (String netlist : netlists.keySet()) {
			String fileName = genFolder.getAbsolutePath().toString() + File.separator + netlist
					+ translator.getFileExtension();

			if (!PhdlUtils.writeStringToFile(fileName, translator.translate(netlists.get(netlist)))) {
				logger.error("failed to generate file: " + fileName);
			}
		}
	}
}