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
 * A tree grammar that walks a PHDL parse tree.
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
}

@members {
  private PHDLDesign design = null;
}

/** The Source Text rule returns the design with all the data structures completed
*/
sourceText returns [PHDLDesign d]
	:	design
		//assign the design to return
		{d = design;}
	;

/** Looks for the keyword "design" as the parent of a subtree, and makes a new design named
 * from the first child in the subtree.  Succeeding children in the subtree before the "begin"
 * keyword are either device or net declarations.  The line number and position of the design
 * declaration are also used in the constructor to report future compilation errors.
 */	
design
	:	^('design' IDENT
			// make a new design based on the identifier and log its position			
			{design = new PHDLDesign($IDENT.text, $IDENT.line, $IDENT.pos);}
		//add device and net declarations to the design
		(deviceDecl[design] | netVectorDecl[design])*
		'begin'
		)
	;

/** Looks for the keyword "device" as the parent of a subtree, and makes a new device named
 * from the first child in the subtree.  Succeeding children in the subtree before the "begin"
 * keyword are attribute declarations.  Children after the "begin" keyword are pin vector
 * declarations.  The line number and position of the device are also used in the constructor
 * to report future compilation errors.
 */	
deviceDecl[PHDLDesign design]
	:	^('device' IDENT 
			// make a new device based on the identifier and log its location 				
			{PHDLDevice device = new PHDLDevice($IDENT.text, $IDENT.line, $IDENT.pos);}
		//add all of the attribute declarations to the device
		attributeDecl[device]*
		//look for the begin keyword
		'begin'
		//add all of the pin vector declarations to the device
		pinVectorDecl[device]*
		)
		// finally add the device to the design and return
		{design.addDevice(device);}
	;
	
netVectorDecl[PHDLDesign design]
	:	^('net' 
		(msb=INT lsb=INT)? 
			{PHDLNetVector nv = new PHDLNetVector(
				$msb!=null?Integer.parseInt($msb.text):0, 
				$lsb!=null?Integer.parseInt($lsb.text):0);}
		netVectorNames[nv]+
		(COLON netVectorAttributes[nv]+)?
		)
		{design.addNetVector(nv);}
	;

attributeDecl[PHDLDevice device]
	:	^(EQUALS name=IDENT value=STRING_LITERAL) 
		{PHDLAttribute a = new PHDLAttribute($name.text, $value.text, $name.line, $name.pos);}
		{device.addAttribute(a);}
	;
	
pinVectorDecl[PHDLDevice device]
	:	^(EQUALS type=IDENT (msb=INT lsb=INT)? name=IDENT pinList=STRING_LITERAL)
		{PHDLPinVector pv = new PHDLPinVector($name.text, $type.text,
			$msb!=null?Integer.parseInt($msb.text):0, 
			$lsb!=null?Integer.parseInt($lsb.text):0, 
			$pinList.text, $name.line, $name.pos);}
		{device.addPinVector(pv);}
	;
	
netVectorNames[PHDLNetVector nv]
	:	IDENT 						{nv.addName($IDENT.text);}
	;
	
netVectorAttributes[PHDLNetVector nv]
	:	IDENT						{nv.addAttribute($IDENT.text);}
	;	
