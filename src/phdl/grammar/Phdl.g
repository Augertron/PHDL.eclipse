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
	import java.util.LinkedList;
}

@lexer::header {
	package phdl.parser;
	import phdl.exception.PhdlRuntimeException;
}

@members {

	private LinkedList<String> errors = new LinkedList<String>();

	@Override
	public void displayRecognitionError(String[] tokenNames,
			RecognitionException e) {
		String hdr = getErrorHeader(e);
		String msg = getErrorMessage(e, tokenNames);
		errors.add(hdr + " " + msg);
	}

	public LinkedList<String> getErrors() {
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
		(portDecl | deviceDecl | netDecl)*
		
		'begin'
		
		// all of the instantiated devices, nets, subdesigns
		instances
		'end'! SEMICOLON!
	;

portDecl
	:	'port'! type^ width? IDENT SEMICOLON!
	;

/** A device declaration contains information about a deviced used in the design.  The device name is 
 * placed between the keywords "device" and "is".  Before the "begin" keyword, attributes to the device
 * are declared.  After the "begin" keyword, pins are declared.  The device declaration is terminated
 * with the "end" keyword and a semicolon.
 */	
deviceDecl
	:	'device'^ IDENT 'is'!
		attributeDecl*
		'begin'
		pinDecl*
		'end'! SEMICOLON!
	;
	
attributeDecl
	:	//promote the "=" sign to the root of the subtree, and ignore the semicolon
		IDENT EQUALS^ STRING_LITERAL SEMICOLON!
	;
	
pinDecl
	:	//promote the type to the root of the subtree, and ignore the equals and semicolon
		type^ width? IDENT EQUALS! STRING_LITERAL SEMICOLON!
	;
	
type
	:	'pin'
	|	'in'
	|	'out'
	|	'inout'
	|	'passive'
	|	'supply'
	|	'power'
	|	'open'
	;

/** A net declaration contains information about a net used in the design.  Nets are declared with the
 * "net" keyword, followed by an optional width, followed by a comma separated list of net names. (Nets
 * may be declared in quantity using this notation.)  Following the comma separated list, an optional 
 * comma separated list of net attributes may be appended using the colon separator.  Finally the net 
 * declaration is terminated in a semicolon.
 */	
netDecl
	:	'net'^ (width)? (IDENT COMMA!)* IDENT (COLON (IDENT COMMA!)* IDENT)? SEMICOLON!
	;

/** A width is an array with MSB and LSB integers separated by a colon inside brackets
 */	
width
	:	'['! INT ':'! INT ']'!
	;

/** An index is an integer inside of parentheses
 */		
index
	:	'('! INT ')'!
	;
	
instances
	:	(deviceInstance | subDesignInstance | netAssignment)*
	;
	
deviceInstance
	:	'inst'^ IDENT ':'! IDENT (width)? 'is'!
		attributeAssignment*
		'begin'
		pinAssignment*
		'end'! ';'!
	;
	
subDesignInstance
	:	'sub'^ IDENT ':'! IDENT (width)? 'is'!
		portAssignment*
		'end'! ';'!
	;
	
attributeAssignment
	:	IDENT (width | index)? EQUALS^ STRING_LITERAL SEMICOLON!
	;
	
pinAssignment
	:	IDENT (width | index)? EQUALS^ concatenation SEMICOLON!
	;
	
portAssignment
	:	IDENT (width | index)? EQUALS^ concatenation SEMICOLON!
	;
	
netAssignment
	:	IDENT (width | index)? EQUALS^ concatenation SEMICOLON!
	;
	
concatenation
	:	((IDENT (width | index)?) ('&'! IDENT (width | index)?)* ) | 'open'!
	;

	
	

/*------------------------------------------------------------------------------------------------------ 
 * Lexer Rules
 *------------------------------------------------------------------------------------------------------*/
 
//single character definitions
fragment CHAR : ('a'..'z') | ('A'..'Z') | '_' | '+' | '-';
fragment DIGIT : '0'..'9' ;
SEMICOLON: ';';
COLON: ':';
COMMA: ',';
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
		|	c = ~('"'|'\r'|'\n')	{sb.appendCodePoint(c);}
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


