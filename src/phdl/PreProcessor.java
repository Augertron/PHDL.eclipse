package phdl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PreProcessor {

	private String filename;
	
	public PreProcessor(String filename) {
		this.filename = filename;
	}
	
	public void preProcess() {
		String outputContents = extractFileContents(filename);
		while (outputContents.contains("use \"")) {
			String nextFileName = extractFileName(outputContents);
			System.out.println("importing " + nextFileName);
			outputContents = outputContents.replaceFirst("use \"" + nextFileName + "\";", "");
			String nextFileContents = extractFileContents(nextFileName);
			outputContents = appendFileContents(outputContents, nextFileContents, nextFileName);
		}
		writeNewFile(outputContents);
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
	
	private boolean writeNewFile(String output) {
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
