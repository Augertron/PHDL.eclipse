package phdl.generator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import phdl.graph.AttributeNode;
import phdl.graph.DesignNode;
import phdl.graph.DeviceNode;
import phdl.graph.InstanceNode;
import phdl.graph.NetNode;
import phdl.graph.PinNode;

public class DesignGraphGenerator {

	private List<DesignNode> designs = new LinkedList<DesignNode>();
	
	public DesignGraphGenerator(String fileName) {
		try {
		    BufferedReader in = new BufferedReader(new FileReader(fileName));
		    String line;
		    String xml = "";
		    while ((line = in.readLine()) != null) {
		        xml += line + "\n";
		    }
		    in.close();
		    process(xml);
		} catch (IOException e) {
			System.err.println("File Reading Error - File may not exist or be open in another program.");
			System.exit(1);
		}
	}
	
	
	private void process(String xml) {
		DesignNode curDesign = null;
		DeviceNode curDevice = null;
		AttributeNode curAttr = null;
		PinNode curPin = null;
		NetNode curNet = null;
		InstanceNode curInst = null;
		
		int pos = 0;
		LinkedList<String> stack = new LinkedList<String>();
		while (pos < xml.length() + 1) {
			String remaining = xml.substring(pos);
			if (remaining.startsWith("<")) {
				 if (remaining.charAt(1) == '/') {
					 int endangle = remaining.indexOf('>');
					 String object = remaining.substring(2, endangle);
					 String stackObj = stack.removeFirst();
					 if (!object.equals(stackObj)) {
						 System.err.println("Unbalanced Tag! - Attempting to close " + object + " but the next tag to be closed was " + stackObj);
						 System.exit(1);
					 }
				 }
				 else {
					 int endangle = remaining.indexOf('>');
					 String object = remaining.substring(1, endangle);
					 stack.addFirst(object);
					 if (object.equals("design")) {
						 curDesign = new DesignNode();
					 }
					 if (object.equals("device")) {
						 curDevice = new DeviceNode(curDesign);
					 }
					 if (object.equals("attribute")) {
						 if (curDevice != null) {
							 curAttr = new AttributeNode(curDevice);
						 }
						 else if (curNet != null) {
							 curAttr = new AttributeNode(curNet);
						 }
						 else if (curInst != null) {
							 curAttr = new AttributeNode(curInst);
						 }
						 else {
							 System.err.println("Invalid attribute placement");
							 System.exit(1);
						 }
					 }
					 if (object.equals("pin")) {
						 if (curDevice != null) {
							 curPin = new PinNode(curDevice);
						 }
						 else if (curInst != null) {
							 curPin = new PinNode(curInst);
						 }
						 else {
							 System.err.println("Invalid pin placement");
							 System.exit(1);
						 }
					 }
					 if (object.equals("net")) {
						 if (curPin != null) {
							 curInst.getPin(curPin.getName());
							 curPin.getName();
						 }
						 else if (curDesign != null) {
							 curNet = new NetNode(curDesign);
						 }
					 }
					 
				 }
			}
		}
	}
}
