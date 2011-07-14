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
		
		return outputContents;
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

	public static boolean unitTest() {
		PreProcessor myPP = new PreProcessor("a.phdl");
		myPP.preProcess();
		return true;
	}
}
