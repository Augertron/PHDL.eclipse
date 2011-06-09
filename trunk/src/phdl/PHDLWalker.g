/*
    Copyright (C) 2011  BYU Configurable Computing Lab

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * A tree grammar that walks a the output of the PHDL parser.  It operates on a stream of 
 * tree nodes of the form (parent child1 child2 ... childN) where each node may be the
 * root of another subtree.
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 */
tree grammar PHDLWalker;

options {
	language = Java;
	tokenVocab = PHDL;
	ASTLabelType = CommonTree;
}

@header {
	package phdl;
	import phdl.PHDLDesign;
	import java.util.HashSet;
}

@members {
	// the set of designs to populate and return by parsing the source text
	private HashSet<PHDLDesign> designs = new HashSet<PHDLDesign>();
}

/** The Source Text rule returns the design units with all data structures populated and processed
*/
sourceText returns [HashSet<PHDLDesign> d]
	:	design*
		// assign the designs to return
		{d = designs;}
	;

/** Looks for the keyword "design" as the parent of a subtree, and makes a new design named
 * from the first child in the subtree.  Succeeding children in the subtree before the "begin"
 * keyword are either device or net declarations.  The line number and position of the design
 * declaration are also used in the constructor to report future compilation errors.
 */	
design
	:	^('design' IDENT	
		{	
			PHDLDesign design = new PHDLDesign($IDENT.text);
			design.setLine($IDENT.line);
			design.setPos($IDENT.pos);
		}
			
		portDecl[design]*
			
		// add device and net declarations to the design
		(deviceDecl[design] | netDecl[design])*
		
		// the begin token separates declarations from instances and assignments
		'begin'
		
		// add all instances subDesigns and netAssignments to the design
		(instance[design] | subDesign[design] | netAssignment[design])*
		)
		
		{designs.add(design);}
	;
	
portDecl[PHDLDesign design]
	:	^('pin' {PHDLPort pin = new PHDLPort(PHDLPinType.PIN);} addPort[design, pin])
	|	^('in' {PHDLPort in = new PHDLPort(PHDLPinType.IN);} addPort[design, in])
	|	^('out' {PHDLPort out = new PHDLPort(PHDLPinType.OUT);} addPort[design, out])
	|	^('inout' {PHDLPort inout = new PHDLPort(PHDLPinType.INOUT);} addPort[design, inout])
	|	^('passive' {PHDLPort passive = new PHDLPort(PHDLPinType.PASSIVE);} addPort[design, passive])
	|	^('supply' {PHDLPort supply = new PHDLPort(PHDLPinType.SUPPLY);} addPort[design, supply])
	|	^('power' {PHDLPort power = new PHDLPort(PHDLPinType.POWER);} addPort[design, power])
	;
	
addPort[PHDLDesign design, PHDLPort port]
	:	(msb=INT lsb=INT)? name=IDENT
		{	
			port.setMsb($msb!=null?Integer.parseInt($msb.text):-1);
			port.setLsb($lsb!=null?Integer.parseInt($lsb.text):-1);
			port.setLine($name.line);
			port.setPos($name.pos);
			port.setName($name.text);
		}
		{design.addPort(port);}
	;

/** Looks for the keyword "device" as the parent of a subtree, and makes a new device named
 * from the first child in the subtree.  Succeeding children in the subtree before the "begin"
 * keyword are attribute declarations.  Children after the "begin" keyword are pin declarations.  
 * The line number and position of the device are also used in the constructor to report future 
 * compilation errors.
 */	
deviceDecl[PHDLDesign design]
	:	^('device' IDENT 
	
			// make a new device based on the identifier and log its location 				
			{
				PHDLDevice device = new PHDLDevice($IDENT.text, $IDENT.line, $IDENT.pos);
			}
			
		// add all of the attribute declarations to the device
		attributeDecl[device]*
		
		// the begin token separates attribute declarations from pin declarations
		'begin'
		
		// add all of the pin declarations to the device
		pinDecl[device]* 
		
		)
		
		// add the device to the design and return
		{design.addDevice(device);}
	;

/** Looks for the keyword "net" as the parent of a subtree, and makes a new net named from the 
 * first child in the subtree.  Succeeding children in the subtree define the other properties
 * of the net.  Optional attributes are added if they exist after a colon.
 */
netDecl[PHDLDesign design]
	:	^('net' (msb=INT lsb=INT)? name=IDENT
	
		// make a new net with the above information
		{
			PHDLNet n = new PHDLNet($name.text); 
			n.setMsb($msb!=null?Integer.parseInt($msb.text):-1);
			n.setLsb($lsb!=null?Integer.parseInt($lsb.text):-1);
			n.setLine($name.line);
			n.setPos($name.pos);
				
		}

		// add any net attributes after a colon
		(COLON netAttribute[n]+)?)
		
		// add the net to the design
		{design.addNet(n);}
	;

/** Helper method for netDecl.  Adds attributes after the colon if they exist in the tree.
 */	
netAttribute[PHDLNet net]
	:	IDENT						{net.addAttribute($IDENT.text);}
	;

/** Looks for an "=" as the root of a subtree, and creates a new attribute based on the 
 * name and value of the children.
 */
attributeDecl[PHDLDevice d]
	:	^(EQUALS name=IDENT value=STRING_LITERAL) 
		{PHDLAttribute a = new PHDLAttribute($name.text, $value.text, $name.line, $name.pos);}
		{d.addAttribute(a);}
	;

/** Looks for the keywords below as the root of a subtree, and creates the appropriate type of pin in 
 * the data structure by switching on that keyword.  Uses the helper rule addPin to populate the 
 * pin with values.
 */	
pinDecl[PHDLDevice device]
	:	^('pin' {PHDLPin pin = new PHDLPin(PHDLPinType.PIN);} addPin[device, pin])
	|	^('in' {PHDLPin in = new PHDLPin(PHDLPinType.IN);} addPin[device, in])
	|	^('out' {PHDLPin out = new PHDLPin(PHDLPinType.OUT);} addPin[device, out])
	|	^('inout' {PHDLPin inout = new PHDLPin(PHDLPinType.INOUT);} addPin[device, inout])
	|	^('passive' {PHDLPin passive = new PHDLPin(PHDLPinType.PASSIVE);} addPin[device, passive])
	|	^('supply' {PHDLPin supply = new PHDLPin(PHDLPinType.SUPPLY);} addPin[device, supply])
	|	^('power' {PHDLPin power = new PHDLPin(PHDLPinType.POWER);} addPin[device, power])
	;
	
/** The helper rule for pinDecl.  It sets all the fields of the pin as they are found after
 * each of the keywords above.  The MSB and LSB are set to zero if they are not present.
 */
addPin[PHDLDevice device, PHDLPin pin]
	:	(msb=INT lsb=INT)? name=IDENT pinList=STRING_LITERAL
		{	
			pin.setMSB($msb!=null?Integer.parseInt($msb.text):-1);
			pin.setLSB($lsb!=null?Integer.parseInt($lsb.text):-1);
			pin.setLine($name.line);
			pin.setPos($name.pos);
			pin.setName($name.text);
			pin.setPinList($pinList.text);
			pin.makePinMap();
		}
		{device.addPin(pin);}
	;	

/** Looks for the keyword "inst" as the root of a subtree, and creates a new instance based on the
 * succeding children in the subtree.  Attribute and pin assignments are added with their own rules.
 */	
instance[PHDLDesign d]
	:	^('inst' instName=IDENT devName=IDENT (msb=INT lsb=INT)?
		
		// make a new instance to pass to attributeAssignment and pinAssignment
		{	
			PHDLInstance i = new PHDLInstance($instName.text, $devName.text,
				$msb!=null?Integer.parseInt($msb.text):-1,
				$lsb!=null?Integer.parseInt($lsb.text):-1, 
				$instName.line, $instName.pos);
		}
				
		attributeAssignment[i]*
		'begin'
		pinAssignment[i]*
		)
		{d.addInstance(i);}
	;

/**	Looks for an "=" sign as the parent of a subtree.  Succeding values consist of left values
 * and right values, with optional widths or indices.  A width is used to specify an array of values
 * assigned, while an index is used to reference a particular value in an array.  Creates a new
 * attribute assignment data structure based on these parameters.
 */
attributeAssignment[PHDLInstance i]
	:	^(EQUALS name=IDENT ((msb=INT lsb=INT) | (index=INT))? value=STRING_LITERAL )
		
		// make a new attribute assignment, assign all values, and add it to the instance
		{
			PHDLAssignment a = new PHDLAssignment($name.text, $value.text);
			a.setLeftMsb($msb!=null?Integer.parseInt($msb.text):-1);
			a.setLeftLsb($lsb!=null?Integer.parseInt($lsb.text):-1);
			a.setLeftIndex($index!=null?Integer.parseInt($index.text):-1);
			a.setLine($name.line);
			a.setPos($name.pos);
			i.addAttributeAssignment(a);
		}
	;


/**	Looks for an "=" sign as the parent of a subtree.  
 */	
pinAssignment[PHDLInstance i]
	:	^(EQUALS name=IDENT ((msb=INT lsb=INT) | (index=INT))?
	
		// make a new pin assignment
		{
			PHDLAssignment a = new PHDLAssignment($name.text); 
			a.setLeftMsb($msb!=null?Integer.parseInt($msb.text):-1);
			a.setLeftLsb($lsb!=null?Integer.parseInt($lsb.text):-1);
			a.setLeftIndex($index!=null?Integer.parseInt($index.text):-1);
			a.setLine($name.line);
			a.setPos($name.pos);
		}
	
		concatenate[a]+
		)
		{i.addPinAssignment(a);}
	;
	
subDesign[PHDLDesign d]
	:	^('sub' instName=IDENT desName=IDENT (msb=INT lsb=INT)?
		
		// make a new instance to pass to attributeAssignment and pinAssignment
		{	
			PHDLSubDesign s = new PHDLSubDesign($instName.text, $desName.text,
				$msb!=null?Integer.parseInt($msb.text):-1,
				$lsb!=null?Integer.parseInt($lsb.text):-1, 
				$instName.line, $instName.pos);
		}

		portAssignment[s]*
		)
		{d.addSubDesign(s);}
	;

/**	Looks for an "=" sign as the parent of a subtree.  
 */	
netAssignment[PHDLDesign d]
	:	^(EQUALS name=IDENT ((msb=INT lsb=INT) | (index=INT))?
		
		// make a new pin assignment
		{
			PHDLAssignment a = new PHDLAssignment($name.text); 
			a.setLeftMsb($msb!=null?Integer.parseInt($msb.text):-1);
			a.setLeftLsb($lsb!=null?Integer.parseInt($lsb.text):-1);
			a.setLeftIndex($index!=null?Integer.parseInt($index.text):-1);
			a.setLine($name.line);
			a.setPos($name.pos);
		}
		
		concatenate[a]+
		)
		{d.addNetAssignment(a);}
	;
	
portAssignment[PHDLSubDesign s]
	:	^(EQUALS name=IDENT ((msb=INT lsb=INT) | (index=INT))?
	
		// make a new pin assignment
		{
			PHDLAssignment a = new PHDLAssignment($name.text); 
			a.setLeftMsb($msb!=null?Integer.parseInt($msb.text):-1);
			a.setLeftLsb($lsb!=null?Integer.parseInt($lsb.text):-1);
			a.setLeftIndex($index!=null?Integer.parseInt($index.text):-1);
			a.setLine($name.line);
			a.setPos($name.pos);
		}
	
		concatenate[a]+
		)
		{s.addPortAssignment(a);}
	;

concatenate[PHDLAssignment a]
	:	(name=IDENT ((msb=INT lsb=INT) | (index=INT))?)
		{
			PHDLNet n = new PHDLNet($name.text);
			n.setMsb($msb!=null?Integer.parseInt($msb.text):-1);
			n.setLsb($lsb!=null?Integer.parseInt($lsb.text):-1);
			n.setIndex($index!=null?Integer.parseInt($index.text):-1);
			n.setLine($name.line);
			n.setPos($name.pos);
			a.addRightValue(n);
		}
	;
