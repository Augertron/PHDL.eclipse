package edu.byu.ee.phdl.translate;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.apache.log4j.Logger;

import com.thoughtworks.xstream.XStream;

import edu.byu.ee.phdl.netlist.PhdlNetlist;
import edu.byu.ee.phdl.utils.ExtensionCodes;
import edu.byu.ee.phdl.utils.PhdlUtils;

public class PhdlTranslate {

	private final static Logger logger = Logger.getLogger(PhdlTranslate.class);

	private static String usage = "java -jar phdltran.jar";
	private static String version = "PHDL translator v2.1, ";
	private static String release = "August 27, 2012 release.  ";

	private static CommandLine commandLine;

	@SuppressWarnings("static-access")
	private static Options createOptions() {
		Options options = new Options();
		options.addOption("?", "help", false, "print this message.");
		options.addOption("o", "overwrite", false, "overwrite files silently.");
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

	private static DefaultTranslator createTranslator() {
		String translatorClassName = commandLine.hasOption("tool") ? commandLine.getOptionValue("tool")
				: "edu.byu.ee.phdl.translate.DefaultTranslator";
		try {
			logger.info("using translator class: " + translatorClassName);
			Class<?> clazz = Class.forName(translatorClassName);
			return (DefaultTranslator) clazz.newInstance();
		} catch (ClassNotFoundException e) {
			logger.error(e + ", translator class must be present on class path.");
			System.exit(1);

		} catch (InstantiationException e) {
			logger.error(e + ", translator class must be concrete.");
			System.exit(1);

		} catch (IllegalAccessException e) {
			logger.error(e + ", translator class must have a no-arg constructor.");
			System.exit(1);
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(version + release + "\n");
		parseArgs(createOptions(), args);
		DefaultTranslator translator = createTranslator();
		PhdlTranslate console = new PhdlTranslate(translator);
		console.run();
	}

	private static void parseArgs(Options options, String[] args) {
		CommandLineParser parser = new PosixParser();
		HelpFormatter formatter = new HelpFormatter();
		try {
			commandLine = parser.parse(options, args);
		} catch (ParseException e) {
			logger.error("problem parsing command line.  " + e.getMessage() + "\n");
			formatter.printHelp(usage, options, true);
			System.exit(1);
		}
		if (commandLine.hasOption("help")) {
			formatter.printHelp(usage, options, true);
			System.exit(1);
		}
	}

	private static String readLine() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		try {
			input = br.readLine();
		} catch (IOException e) {
			logger.error("problem reading command line");
			System.exit(1);
		}
		return input;
	}

	private final DefaultTranslator translator;

	private final Map<String, PhdlNetlist> netlists;

	public PhdlTranslate(DefaultTranslator translator) {
		if (translator == null) {
			throw new IllegalArgumentException("translator cannot be null.");
		}
		this.translator = translator;
		this.netlists = new HashMap<String, PhdlNetlist>();
	}

	private String extractDesignName(String fileName) {
		return fileName.substring(fileName.lastIndexOf(File.separator) + 1, fileName.lastIndexOf("."));
	}

	private void generateFile(String fileName, String netlist, boolean overwrite) {
		if (PhdlUtils.writeStringToFile(fileName, translator.translate(netlists.get(netlist)))) {
			logger.info((overwrite ? "overwrote" : "wrote") + " file " + fileName);
		} else {
			logger.error("failed to generate file: " + fileName);
		}
	}

	private void generateOutput(File genFolder) {
		boolean owAll = commandLine.hasOption("overwrite") ? true : false;
		for (String netlist : netlists.keySet()) {
			String fileName = genFolder.getAbsolutePath().toString() + File.separator + netlist
					+ translator.getFileExtension();

			File genFile = new File(fileName);

			if (genFile.exists()) {
				if (owAll) {
					generateFile(fileName, netlist, true);
				} else {
					logger.warn("file " + fileName + " exists.  overwrite?  (yes/no/all)");
					String overwrite = readLine();
					if (overwrite.equals("all"))
						owAll = true;
					if (overwrite.equals("yes") || owAll)
						generateFile(fileName, netlist, true);
					else if (overwrite.equals("no"))
						continue;
					else
						logger.warn("unrecognized input: " + overwrite + ", exiting.");
				}
			} else {
				generateFile(fileName, netlist, false);
			}
		}
	}

	private void getFile(String srcFile) {
		File file = new File(srcFile);
		logger.info("reading source file: " + file.getName());
		String xml = PhdlUtils.readStringFromFile(file.getAbsolutePath());
		if (xml == null) {
			logger.error("problem reading file: " + file.getAbsolutePath());
			System.exit(1);
		}

		XStream xstream = new XStream();
		PhdlUtils.setAliasesForPhdlNetlist(xstream);
		Object obj = xstream.fromXML(xml);
		try {
			PhdlNetlist netlist = (PhdlNetlist) obj;
			netlists.put(extractDesignName(file.getAbsolutePath()), netlist);
		} catch (Exception e) {
			logger.error("invalid PHDL netlist file: " + file.getAbsolutePath());
		}
	}

	private void getFiles(String directory) {
		File folder = new File(directory);
		logger.info("using directory: " + folder.getAbsolutePath());
		File[] files = folder.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile() && files[i].getName().toLowerCase().endsWith(ExtensionCodes.NET_EXT)) {
				logger.info("reading source file: " + files[i].getName());
				String xml = PhdlUtils.readStringFromFile(files[i].getAbsolutePath());
				if (xml == null) {
					logger.error("problem reading file: " + files[i].getAbsolutePath());
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

	private File getGenFolder(File srcFolder) {
		// determine the output folder
		String gen;
		if (srcFolder.isDirectory()) {
			gen = commandLine.hasOption("gen") ? commandLine.getOptionValue("gen") : srcFolder.getAbsolutePath();
		} else {
			gen = new File(".").getAbsolutePath();
		}

		// user intervention required to create the folder if it doesn't exist
		File genFolder = new File(gen);
		if (!genFolder.isDirectory()) {
			logger.warn("invalid output directory specified: " + genFolder.getAbsolutePath());
			System.out.println("create directory? (yes/no)");
			if (readLine().equals("yes")) {
				genFolder.mkdir();
				logger.info("created output directory: " + genFolder.getAbsolutePath());
			}
		}
		return genFolder;
	}

	private File getSourceFolder() {
		// obtain the resource file or folder name
		String src = commandLine.hasOption("src") ? commandLine.getOptionValue("src") : ".";
		File fileOrFolder = new File(src);
		if (!fileOrFolder.exists()) {
			logger.error("resource does not exist: " + fileOrFolder.getAbsolutePath());
			System.exit(1);
		}

		// use all netlist files if a directory is specified
		if (fileOrFolder.isDirectory()) {
			getFiles(fileOrFolder.getAbsolutePath());
		} else if (fileOrFolder.getAbsolutePath().toLowerCase().endsWith(ExtensionCodes.NET_EXT)) {
			getFile(fileOrFolder.getAbsolutePath());
		}

		// report an error if no resources were found
		if (netlists.isEmpty()) {
			logger.error("no PHDL netlists found, exiting.");
			System.exit(1);
		}
		return fileOrFolder;
	}

	private void run() {
		logger.info("translation started...");
		File srcFolder = getSourceFolder();
		File genFolder = getGenFolder(srcFolder);
		generateOutput(genFolder);
		logger.info("translation completed.");
	}
}