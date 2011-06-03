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
grammar PHDL;

options {
  language = Java;
  output=AST;
  ASTLabelType=CommonTree;
}

@header {
  package phdl;
}

@lexer::header {
  package phdl;
}

/*------------------------------------------------------------------------------------------------------ 
 * Parser Rules
 *------------------------------------------------------------------------------------------------------*/

/** The source text contains a design
 */
sourceText
	:	designDecl EOF
	;	

/** A design contains all relevant information about the PCB design.  Between the keywords
 * "design" and "is" resides the design name.  Before the "begin" keyword, devices and nets are declared in
 * any order.  Following the "begin" keyword, instantiations are located.  The design is terminated with 
 * the "end" keyword and a semicolon.
 */
designDecl
	:	//promote the keyword "design" to the root of the subtree, and ignore the keyword "is"
		'design'^ IDENT 'is'! 
		//zero or more device or net declarations may follow
		(deviceDecl | netDecl)*
		'begin'
		instantiations
		'end'! SEMI!
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
		pinVectorDecl*
		'end'! SEMI!
	;
	
attributeDecl
	:	//promote the "=" sign to the root of the subtree, and ignor the semicolon
		IDENT EQUALS^ STRING_LITERAL SEMI!
	;
	
pinVectorDecl
	:	IDENT width? IDENT EQUALS^ STRING_LITERAL SEMI!
	;

/** A net declaration contains information about a net used in the design.  Nets are declared with the
 * "net" keyword, followed by an optional width, followed by a comma separated list of net names. (Nets
 * may be declared in quantity using this notation.)  Following the comma separated list, an optional 
 * comma separated list of net attributes may be appended using the colon separator.  Finally the net 
 * declaration is terminated in a semicolon.
 */	
netDecl
	:	'net'^ (width)? (IDENT COMMA!)* IDENT (COLON (STRING_LITERAL COMMA!)* STRING_LITERAL)? SEMI!
	;
	
width
	:	'['! INT ':'! INT ']'!
	;
	
instantiations
	:	(instance | subSch | netAssignment)*
	;
	
instance
	:	'inst' IDENT ':' IDENT (width)? 'is'
		//attributeList
		'begin'
		pinAssignment*
		'end' ';'
	;
	
subSch
	:	'subSch' IDENT ':' IDENT (width)? 'is'
		//attributeList
		'begin'
		pinAssignment*
		'end' ';'
	;
	
pinAssignment
	:	IDENT (width)? EQUALS ((IDENT (width)?) | 'open') SEMI!
	;
	
netAssignment
	:	IDENT (width)? EQUALS IDENT (width)? SEMI!
	;

/*------------------------------------------------------------------------------------------------------ 
 * Lexer Rules
 *------------------------------------------------------------------------------------------------------*/
 
//single character definitions
fragment CHAR : ('a'..'z') | ('A'..'Z') | '_' | '+' | '-';
fragment DIGIT : '0'..'9' ;
SEMI: ';';
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


