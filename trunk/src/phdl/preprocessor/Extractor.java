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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import phdl.TestDriver;

/**
 * Class that serves to extract all filenames that are associated
 * with a design.
 * 
 * Can create a list of file name Strings given a single source
 * file or an array of source files. 
 * 
 * @author Brad Riching and Ricahrd Black
 *
 */
public class Extractor {

	/**
	 * Iterates through an array of file names and extracts the
	 * file names found in them as well as their included files.
	 * 
	 * @param filenames an array of Strings with all the source
	 * files to be parsed
	 * @return a List of all the file names found in the source
	 * file as well as in its included files 
	 */
	public List<String> extract(String[] filenames) {
		ArrayList<String> sourceFiles = new ArrayList<String>();
		for (String s : filenames) {
			sourceFiles.addAll(extract(s));
		}
		return sourceFiles;
	}
	
	/**
	 * Extracts the file names found in a source file
	 * and its included files.
	 * 
	 * @param filename the file name to extract from
	 * @return a List of file names extracted
	 */
	public List<String> extract(String filename) {
		ArrayList<String> sourceFiles = new ArrayList<String>();
		extract(filename, sourceFiles);		
		return sourceFiles;
	}
	
	private List<String> extract(String curFile, ArrayList<String> sourceFiles) {
		sourceFiles.add(curFile);
		String contents = getFileContents(curFile);
		int fromIndex = 0;
		while (contents.indexOf("use \"", fromIndex) != -1) {
			int start = contents.indexOf("use \"", fromIndex);
			int firstQuote = contents.indexOf("\"", start);
			int lastQuote = contents.indexOf("\"", firstQuote+1);
			String nextFile = contents.substring(firstQuote+1, lastQuote);
			fromIndex = lastQuote + 1;
			extract(nextFile, sourceFiles);
		}
		return sourceFiles;
	}
	
	private String getFileContents(String filename) {
		String output = "";
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			String str;
			while ((str = in.readLine()) != null) {
				output += (str + "\n");
			}
			in.close();
		}
		catch (IOException e) {
			System.err.println("Problem in reading from file");
			return "Failure to read from " + filename;
		}
		return output;
	}
	
	public static boolean unitTest() {
		boolean success = true;
		Extractor e = new Extractor();
		List<String> files = e.extract("a.phdl");
		if (!files.contains("a.phdl")) {
			success = false;
			TestDriver.err("extract(String filename)", "a.phdl", "didn't");
		}
		if (!files.contains("b.phdl")) {
			success = false;
			TestDriver.err("extract(String filename)", "b.phdl", "didn't");
		}
		if (!files.contains("c.phdl")) {
			success = false;
			TestDriver.err("extract(String filename)", "c.phdl", "didn't");
		}
		if (!files.contains("d.phdl")) {
			success = false;
			TestDriver.err("extract(String filename)", "d.phdl", "didn't");
		}
		
		String[] files2 = {"a.phdl", "e.phdl", "h.phdl"};
		files = e.extract(files2);
		if (!files.contains("a.phdl")) {
			success = false;
			TestDriver.err("extract(String[] filenames)", "a.phdl", "didn't");
		}
		if (!files.contains("b.phdl")) {
			success = false;
			TestDriver.err("extract(String[] filenames)", "b.phdl", "didn't");
		}
		if (!files.contains("c.phdl")) {
			success = false;
			TestDriver.err("extract(String[] filenames)", "c.phdl", "didn't");
		}
		if (!files.contains("d.phdl")) {
			success = false;
			TestDriver.err("extract(String[] filenames)", "d.phdl", "didn't");
		}
		if (!files.contains("e.phdl")) {
			success = false;
			TestDriver.err("extract(String[] filenames)", "e.phdl", "didn't");
		}
		if (!files.contains("f.phdl")) {
			success = false;
			TestDriver.err("extract(String[] filenames)", "f.phdl", "didn't");
		}
		if (!files.contains("g.phdl")) {
			success = false;
			TestDriver.err("extract(String[] filenames)", "g.phdl", "didn't");
		}
		if (!files.contains("h.phdl")) {
			success = false;
			TestDriver.err("extract(String[] filenames)", "h.phdl", "didn't");
		}
		
		return success;
	}
	
}
