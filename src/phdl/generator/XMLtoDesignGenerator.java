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

public class XMLtoDesignGenerator {

	private DesignNode design = new DesignNode();
	
	public XMLtoDesignGenerator(String fileName) {
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
	
	public DesignNode getDesign() {
		return design;
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
					 if (stackObj.equals("design")) {
						 design = curDesign;
						 curDesign = null;
					 }
					 else if (stackObj.equals("device")) {
						 curDesign.addDevice(curDevice);
						 curDevice = null;
					 }
					 else if (stackObj.equals("attribute")) {
						 if (curDevice != null) {
							 curDevice.addAttribute(curAttr);
						 }
						 else if (curNet != null) {
							 curNet.addAttribute(curAttr);
						 }
						 else if (curInst != null) {
							 curInst.addAttribute(curAttr);
						 }
						 curAttr = null;
					 }
					 else if (stackObj.equals("pin")) {
						 if (curDevice != null) {
							 curDevice.addPin(curPin);
						 }
						 curPin = null;
					 }
					 else if (stackObj.equals("netname")) {
						 curPin = null;
					 }
					 else if (stackObj.equals("net")) {
						 curDesign.addNet(curNet);
						 curNet = null;
					 }
					 else if (stackObj.equals("instance")) {
						 curDesign.addInstance(curInst);
						 curInst = null;
					 }
					 pos += endangle;
				 }
				 else {
					 int endangle = remaining.indexOf('>');
					 String object = remaining.substring(1, endangle);
					 pos += endangle;
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
					 if (object.equals("instance")) {
						 curInst = new InstanceNode(curDesign);
					 }
					 if (object.equals("refDes")) {
						 String top = stack.get(1);
						 int nextangle = remaining.indexOf('<', endangle);
						 String ref = remaining.substring(endangle+1, nextangle);
						 if (top.equals("instance")) {
							 curInst.setRefDes(ref);
						 }
					 }
					 if (object.equals("pin")) {
						 if (curDevice != null) {
							 curPin = new PinNode(curDevice);
						 }
						 else {
							 System.err.println("Invalid pin placement");
							 System.exit(1);
						 }
					 }
					 if (object.equals("pinname")) {
						 int nextangle = remaining.indexOf('<', endangle);
						 String name = remaining.substring(endangle+1, nextangle);
						 if (curInst != null) {
							 for (PinNode p : curInst.getDevice().getPins()) {
								 if (p.getName().equals(name)) {
									 curPin = new PinNode(p, curInst);
									 break;
								 }
							 }
						 }
						 else {
							 System.err.println("Invalid pinname placement");
						 }
					 }
					 if (object.equals("net")) {
						 if (curDesign != null) {
							 curNet = new NetNode(curDesign);
						 }
						 else {
							 System.err.println("Invalid net placement");
							 System.exit(1);
						 }
					 }
					 if (object.equals("name")) {
						 String top = stack.get(1);
						 int nextangle = remaining.indexOf('<', endangle);
						 String name = remaining.substring(endangle+1, nextangle);
						 if (top.equals("design")) {
							 curDesign.setName(name);
						 }
						 else if (top.equals("device")) {
							 curDevice.setName(name);
						 }
						 else if (top.equals("attribute")) {
							 curAttr.setName(name);
						 }
						 else if (top.equals("pin")) {
							 curPin.setName(name);
						 }
						 else if (top.equals("net")) {
							 curNet.setName(name);
						 }
						 else if (top.equals("instance")) {
							 curInst.setName(name);
						 }
						 else {
							 System.err.println("Invalid name placement.");
							 System.exit(1);
						 }
					 }
					 if (object.equals("value")) {
						 String top = stack.get(1);
						 int nextangle = remaining.indexOf('<', endangle);
						 String value = remaining.substring(endangle+1, nextangle);
						 if (top.equals("attribute")) {
							 curAttr.setValue(value);
						 }
						 else {
							 System.err.println("Invalid value placement.");
							 System.exit(1);
						 }
					 }
					 if (object.equals("number")) {
						 String top = stack.get(1);
						 int nextangle = remaining.indexOf('<', endangle);
						 String number = remaining.substring(endangle+1, nextangle);
						 if (top.equals("pin")) {
							 curPin.setPinName(number);
						 }
						 else {
							 System.err.println("Invalid number placement.");
							 System.exit(1);
						 }
					 }
					 if (object.equals("device_name")) {
						 String top = stack.get(1);
						 int nextangle = remaining.indexOf('<', endangle);
						 String name = remaining.substring(endangle+1, nextangle);
						 if (top.equals("instance")) {
							 curInst.setDevice(curDesign.getDevice(name));
						 }
						 else {
							 System.err.println("Invalid device name placement.");
							 System.exit(1);
						 }
					 }
					 if (object.equals("netname")) {
						 String top = stack.get(1);
						 int nextangle = remaining.indexOf('<', endangle);
						 String name = remaining.substring(endangle+1, nextangle);
						 if (top.equals("instance")) {
							 curPin.setNet(curDesign.getNet(name));
							 curInst.addPin(curPin);
						 }
						 else {
							 System.err.println("Invalid net name placement.");
							 System.exit(1);
						 }
					 }
				 }
			}
			else {
				pos++;
			}
		}
	}
}
