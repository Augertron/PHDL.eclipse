/*
 * Copyright (C) 2011 BYU Configurable Computing Lab
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */

package phdl.preprocessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A class that performs a similar operation to that of
 * the C-preprocessor.
 * 
 * The class takes a file name and extracts its contents. It
 * then appends any imported file contents and then writes a new
 * file titled after the original source.
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 *
 */

public class PreProcessor {

	private String filename;
	
	public PreProcessor(String filename) {
		this.filename = filename;
	}
	
	public String preProcess() {
		String outputContents = extractFileContents(filename);
		while (outputContents.contains("use \"")) {
			String nextFileName = extractFileName(outputContents);
			System.out.println("importing " + nextFileName);
			outputContents = outputContents.replaceFirst("use \"" + nextFileName + "\";", "");
			String nextFileContents = extractFileContents(nextFileName);
			outputContents = appendFileContents(outputContents, nextFileContents, nextFileName);
		}
		return outputContents;
	}
	
	private String extractFileName(String fileContents) {
		int pos = fileContents.indexOf("use \"");
		int end = fileContents.indexOf(";", pos);
		String subString = fileContents.substring(pos, end);
		System.out.println(pos + "," + end + "\t" + subString);
		
		int qstart = subString.indexOf("\"");
		int qend = subString.indexOf("\"", qstart+1);
		String fileName = subString.substring(qstart+1, qend);
		System.out.println(qstart + "," + qend + "\t" + fileName);
		
		return fileName;
	}
	
	private String appendFileContents(String output, String nextFile, String nextFileName) {
		output += "\n\\\\ **** Appending " + nextFileName + " **** \\\\ \n";
		output = output.concat(nextFile);
		output += "\n\\\\ **** End of appending " + nextFileName + " **** \\\\ \n"; 
		return output;
	}
	
	public String extractFileContents(String nextFile) {
		String output = "";
		try {
			BufferedReader in = new BufferedReader(new FileReader(nextFile));
			String str;
			while ((str = in.readLine()) != null) {
				output += (str + "\n");
			}
			in.close();
		}
		catch (IOException e) {
			System.err.println("Problem in reading from file");
			return "Failure to read from " + nextFile;
		}
		return output;
	}
	
	public boolean writeNewFile(String output) {
		String outFileName = filename.replace(".phdl", ".pp");
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(outFileName));
			out.write(output);
			out.close();
		}
		catch (IOException e) {
			System.err.println("Problem in writing to a file");
			return false;
		}
		return true;
	}

	public static boolean unitTest() {
		PreProcessor myPP = new PreProcessor("a.phdl");
		myPP.preProcess();
		return true;
	}
}
