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
		+ " * <http://www.gnu.org/licenses/>.\n\n" + "" + "Usage:\n\n" + "\t<*.phdl> <*.phdl> ... [-w][-d][-v]\n\n"
		+ "\tOne or more design phdl files followed by optional switches.\n" + "\t-w\tsupress warnings\n"
		+ "\t-d\tenable dotty file dump for graph viewing\n"
		+ "\t-v\tenable verbose error reporting (will not bail out simple parse errors)\n"
		+ "\t-e\toutput script for EAGLE PCB\n\n";

	private final String version = "PHDL Compiler v2.0 Java v1.6 ANTLR v3.2 Feb 01 2012";

	private final String[] reqAttr = { "REFPREFIX", "PACKAGE", "LIBRARY" };

	private boolean supWarn;
	private boolean ast;
	private boolean verbose;
	private boolean eagle;
	private boolean clean;
	private boolean report;
	private boolean dot;
	private final List<String> fileNames;

	public Configuration(String[] args) {
		this.fileNames = new ArrayList<String>();
		if (args.length == 0) {
			System.out.println(getUsage());
			System.exit(1);
		}

		// sort out the compiler switches
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-w"))
				setSupWarn(true);
			else if (args[i].equals("-a"))
				setAst(true);
			else if (args[i].equals("-v"))
				setVerbose(true);
			else if (args[i].equals("-e"))
				setEagle(true);
			else if (args[i].equals("-c"))
				setClean(true);
			else if (args[i].equals("-r"))
				setReport(true);
			else if (args[i].equals("-d"))
				setDot(true);
			else if (args[i].equals("?") || args[i].equals("-help")) {
				System.out.println(getUsage());
				System.exit(1);
			} else {
				if (args[i].startsWith("-")) {
					System.out.println("Invalid compiler switch: " + args[i] + "\n");
					System.exit(1);
				} else
					fileNames.add(args[i]);
			}
		}
	}

	public List<String> getFileNames() {
		return fileNames;
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

	public boolean isAst() {
		return ast;
	}

	public boolean isClean() {
		return clean;
	}

	public boolean isDot() {
		return dot;
	}

	public boolean isEagle() {
		return eagle;
	}

	public boolean isReport() {
		return report;
	}

	public boolean isSupWarn() {
		return supWarn;
	}

	public boolean isVerbose() {
		return verbose;
	}

	public void setAst(boolean ast) {
		this.ast = ast;
	}

	public void setClean(boolean clean) {
		this.clean = clean;
	}

	public void setDot(boolean dot) {
		this.dot = dot;
	}

	public void setEagle(boolean eagle) {
		this.eagle = eagle;
	}

	public void setReport(boolean report) {
		this.report = report;
	}

	public void setSupWarn(boolean supWarn) {
		this.supWarn = supWarn;
	}

	public void setVerbose(boolean verbose) {
		this.verbose = verbose;
	}

}
