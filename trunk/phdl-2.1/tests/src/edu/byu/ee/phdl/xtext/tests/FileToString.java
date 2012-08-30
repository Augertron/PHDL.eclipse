package edu.byu.ee.phdl.xtext.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileToString {

	public static String readFile(String fileName) throws IOException {
		File file = new File(fileName);
		if (file.length() > Integer.MAX_VALUE) {
			throw new IOException("file is too large for single read");
		}
		byte[] bytes = new byte[(int) file.length()];
		FileInputStream stream = null;
		try {
			stream = new FileInputStream(file);
			int read = stream.read(bytes);
			if (read != file.length()) {
				throw new IOException("could not read entire file");
			}
		} finally {
			stream.close();
		}
		return new String(bytes).replaceAll("\r", "");
	}

}
