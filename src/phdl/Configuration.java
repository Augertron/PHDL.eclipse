package phdl;

import java.util.ArrayList;
import java.util.List;

public class Configuration {

	private final String usage = "\nPHDL Compiler v0.1.\n\n"
		+ " * Copyright (C) 2011 BYU Configurable Computing Lab This program is free software: you can\r\n"
		+ " * redistribute it and/or modify it under the terms of the GNU General Public License as published\r\n"
		+ " * by the Free Software Foundation, either version 3 of the License, or (at your option) any later\r\n"
		+ " * version. This program is distributed in the hope that it will be useful, but WITHOUT ANY\r\n"
		+ " * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR\r\n"
		+ " * PURPOSE. See the GNU General Public License for more details. You should have received a copy of\r\n"
		+ " * the GNU General Public License along with this program. If not, see\r\n"
		+ " * <http://www.gnu.org/licenses/>.\n\n" + "" + "Usage:\n\n"
		+ "\t<*.phdl> <*.phdl> ... [-w][-d][-v]\n\n"
		+ "\tOne or more design phdl files followed by optional switches.\n"
		+ "\t-w\tsupress warnings\n" + "\t-d\tenable dotty file dump for graph viewing\n"
		+ "\t-v\tenable verbose error reporting (will not bail out simple parse errors)\n"
		+ "\t-e\toutput script for EAGLE PCB\n\n";

	private final String version = "PHDL Version 2.0";

	private final String[] reqAttr = { "REFPREFIX", "PACKAGE", "LIBRARY" };

	private boolean supWarn;
	private boolean dumpEn;
	private boolean verbose;
	private boolean eagle;
	private boolean clean;
	private List<String> fileNames;

	public Configuration(String[] args) {
		this.fileNames = new ArrayList<String>();
		if (args.length == 0) {
			System.out.println(getUsage());
			System.exit(1);
		}

		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-w"))
				setSupWarn(true);
			else if (args[i].equals("-d"))
				setDumpEn(true);
			else if (args[i].equals("-v"))
				setVerbose(true);
			else if (args[i].equals("-e"))
				setEagle(true);
			else if (args[i].equals("-c")) {
				setClean(true);
			} else if (args[i].equals("?") || args[i].equals("-help")) {
				System.out.println(getUsage());
				System.exit(1);
			} else {
				fileNames.add(args[i]);
			}
		}
	}

	public String[] getReqAttr() {
		return reqAttr;
	}

	public String getUsage() {
		return usage;
	}

	public String getVersion() {
		return version;
	}

	public List<String> getFileNames() {
		return fileNames;
	}

	public boolean isClean() {
		return clean;
	}

	public boolean isDumpEn() {
		return dumpEn;
	}

	public boolean isEagle() {
		return eagle;
	}

	public boolean isSupWarn() {
		return supWarn;
	}

	public boolean isVerbose() {
		return verbose;
	}

	public void setClean(boolean clean) {
		this.clean = clean;
	}

	public void setDumpEn(boolean dumpEn) {
		this.dumpEn = dumpEn;
	}

	public void setEagle(boolean eagle) {
		this.eagle = eagle;
	}

	public void setSupWarn(boolean supWarn) {
		this.supWarn = supWarn;
	}

	public void setVerbose(boolean verbose) {
		this.verbose = verbose;
	}

}
