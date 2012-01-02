package phdl;

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

	public String[] getReqAttr() {
		return reqAttr;
	}

	public String getUsage() {
		return usage;
	}

	public String getVersion() {
		return version;
	}
}
