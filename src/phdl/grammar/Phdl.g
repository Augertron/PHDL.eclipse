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
 * A grammar to lex and parse a PHDL source file.
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 */
grammar Phdl;

options {
	language = Java;
	output=AST;
	ASTLabelType=CommonTree;
}

@header {
	package phdl.parser;
	import java.util.TreeSet;
	import java.util.Set;
}

@lexer::header {
	package phdl.parser;
	import phdl.exception.PhdlRuntimeException;
}

@members {

	private Set<String> errors = new TreeSet<String>();

	@Override
	public void displayRecognitionError(String[] tokenNames,
			RecognitionException e) {
		String hdr = getErrorHeader(e);
		String msg = getErrorMessage(e, tokenNames);
		errors.add(hdr + " " + msg);
	}

	public Set<String> getErrors() {
		return errors;
	}
}


/*------------------------------------------------------------------------------------------------------ 
 * Parser Rules
 *------------------------------------------------------------------------------------------------------*/

/** The source text contains a design
 */
sourceText
	:	designDecl* EOF
	;	

/** A design contains all relevant information about the PCB design.  Between the keywords
 * "design" and "is" resides the design name.  Before the "begin" keyword, devices and nets are declared in
 * any order.  Following the "begin" keyword, instantiations are located.  The design is terminated with 
 * the "end" keyword and a semicolon.
 */
designDecl
	:	// promote the keyword "design" to the root of the subtree, and ignore the keyword "is"
		'design'^ IDENT 'is'! 
		
		// any kind of declaration may follow
		(deviceDecl | netDecl)*
		
		'begin'
		
		// all of the instantiated devices, net assignments
		(deviceInstance | netAssignment)*
		
		'end'! SEMICOLON!
	;

/** A device declaration contains information about a deviced used in the design.  The device name is 
 * placed between the keywords "device" and "is".  Before the "begin" keyword, attributes to the device
 * are declared.  After the "begin" keyword, pins are declared.  The device declaration is terminated
 * with the "end" keyword and a semicolon.
 */	
deviceDecl
	:	'device'^ IDENT 'is'!
		( attributeDecl | pinDecl )*
		'end'! SEMICOLON!
	;
	
attributeDecl
	:	//promote the "=" sign to the root of the subtree, and ignore the semicolon
		'attr'^ IDENT EQUALS! STRING_LITERAL SEMICOLON!
	;
	
pinDecl
	:	//promote the type to the root of the subtree, and ignore the equals and semicolon
		type^ sliceList? IDENT EQUALS! pinList SEMICOLON!
	;

/**
 * There are a few types associated with pin and port declarations.  If no types in the design
 * are preferred, use the "pin" type for everything.
 */	
type
	:	'pin'
//	|	'in'
//	|	'out'
//	|	'inout'
//	|	'passive'
//	|	'supply'
//	|	'power'
	;

/** 
 * A net declaration contains information about a net used in the design.  Nets are declared with the
 * "net" keyword, followed by an optional array, followed by a comma separated list of net names. (Nets
 * may be declared in quantity using this notation.)  Following the comma separated list, an optional 
 * comma separated list of net attributes may be appended using the colon separator.  Finally the net 
 * declaration is terminated in a semicolon.
 */	
 // have this look more like a devicedecl
netDecl
	:	'net'^ sliceList? IDENT netAttributes? SEMICOLON! 
	//(COLON IDENT (COMMA! IDENT)*)? SEMICOLON!
	;
	
netAttributes
	:	'is'! attributeDecl* 'end'!
	;
	
deviceInstance
	:	'inst'^ IDENT ':'! IDENT arrayList? 'is'!
		attributeAssignment*
		'begin'
		pinAssignment*
		'end'! ';'!
	;

attributeAssignment
	:  instanceQualifier? IDENT EQUALS^ STRING_LITERAL SEMICOLON!
	;
	
instanceQualifier
	:	IDENT '.'^  
	| IDENT arrayList '.'^
	;
	
pinAssignment
	:	instanceQualifier? IDENT sliceList? EQUALS^ concatenation SEMICOLON!
	;
	
netAssignment
	:	IDENT sliceList? EQUALS^ concatenation SEMICOLON!
	;
	
concatenation
	:	((IDENT sliceList?) ('&'! IDENT sliceList?)* ) 
	|	'<' IDENT '>'
	| 	'open'!
	;
	

/** Not yet supported
subDesignInstance
	:	'sub'^ IDENT ':'! IDENT (array)? 'is'!
		subAttributeAssignment*
		'begin'
		portAssignment*
		'end'! ';'!
	;
	
subAttributeAssignment
	:	IDENT^ PERIOD! IDENT slice? EQUALS! STRING_LITERAL SEMICOLON!
	;
	
portAssignment
	:	IDENT (slice slice?)? EQUALS^ concatenation SEMICOLON!
	;
	
portDecl
	:   type^ array? IDENT SEMICOLON!
	;
*/
	
pinList
	: '{' IDENT (',' IDENT)* '}'
	;
	
sliceList
	: '[' 
	(
	| INT ':'^ INT
	|	INT (','^ INT)* 
	)
	']'
	;
	
arrayList
	: '(' 
	(
	| INT ':'^ INT
	|	INT (','^ INT)* 
	)
	')'
	;
	

/*------------------------------------------------------------------------------------------------------ 
 * Lexer Rules
 *------------------------------------------------------------------------------------------------------*/
 
//single character definitions
fragment CHAR : ('a'..'z') | ('A'..'Z') | '_' | '+' | '-' | '$';
fragment DIGIT : '0'..'9' ;
SEMICOLON: ';';
COLON: ':';
COMMA: ',';
PERIOD: '.';
EQUALS: '=';
LBRACKET: '[';
RBRACKET: ']';

// an integer is one or more digits
INT : DIGIT+;

// s string literal has its wrapping quotes removed
STRING_LITERAL
	: 	'"' 
		{StringBuilder sb = new StringBuilder();}
		(	'/' '"' 				{sb.appendCodePoint('"');}
		|	c = ~('"')	
			{	if (c!=' ' && c!='\t' && c!='\n' && c!='\r' && c!='\f' && c!='\u001D')
					sb.appendCodePoint(c);
			}
		)*
		'"' 
		{setText(sb.toString());}
	;

// identifiers may not begin with a digit
IDENT 
	: CHAR ( CHAR | DIGIT )*
	;

// whitespace can be a space, tab, newline, carriage return, form feed
WHITESPACE 
	: (' ' | '\t' | '\n' | '\r' | '\f' | '\u001D')+ {$channel = HIDDEN;}
	;

// line comments begin with the double slash
LINE_COMMENT 
	: '//' .* ('\n' | '\r' ) {$channel = HIDDEN;}
	;

// multiline comments begin with /* and end with the */ terminator
MULTILINE_COMMENT 
	: '/*' .* '*/' {$channel = HIDDEN;}
	;


