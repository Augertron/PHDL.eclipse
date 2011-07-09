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
	package phdl.grammar;
	import java.util.TreeSet;
	import java.util.Set;
}

@lexer::header {
	package phdl.grammar;
	import phdl.exception.PhdlRuntimeException;
}

@members {

	private Set<String> errors = new TreeSet<String>();

//	@Override
//	public void displayRecognitionError(String[] tokenNames,
//			RecognitionException e) {
//		String hdr = getErrorHeader(e);
//		String msg = getErrorMessage(e, tokenNames);
//		errors.add(hdr + " " + msg);
//	}

	public Set<String> getErrors() {
		return errors;
	}
}


/*------------------------------------------------------------------------------------------------------ 
 * Parser Rules
 *------------------------------------------------------------------------------------------------------*/

/** 
 * The source text contains multiple design units.
 */
sourceText
	:	designDecl* EOF
	;
//	catch [RecognitionException re] {
//		errors.add(re.getMessage());
//	}

/** 
 * A design declaration consists of the keyword "design" followed by the design name, and the keyword "is."
 * Before the "begin" keyword, device and net declarations can coexist in any order.  After the "begin" keyword
 * device instances and net assignments can coexist in any order.  The body of the design declaration is 
 * terminated with the keyword "end" followed by a semicolon.
 */
designDecl
	:	'design'^ IDENT 'is'! 
		(deviceDecl | netDecl)*
		'begin'
		(instanceDecl | netAssignment)*
		'end'! SEMICOLON!
	;

/** 
 * A device declaration consists of the keyword "device" followed by the device name, and the keyword "is."
 * Attribute and pin declarations may coexist anywhere in the body of the device declaration.  The device
 * declaration is terminated with the "end" keyword followed by a semicolon.
 */	
deviceDecl
	:	'device'^ IDENT 'is'!
		( attributeDecl | pinDecl )*
		'end'! SEMICOLON!
	;

/**
 * An attribute declaration begins with the keyword "attr" followed by the attribute name, 
 * and equals sign, and the string it is intialized to, then terminated in a semicolon.
 */	
attributeDecl
	:	'attr'^ IDENT EQUALS! STRING SEMICOLON!
	;

/**
 * A pin declaration consists of the pin type, an optional slice list, and the name of the pin.  A list
 * of pin numbers (which may be strings beginning with numbers) is appended with an equals sign, and
 * terminated with the usual semicolon.
 */
pinDecl
	:	type^ sliceDecl? IDENT EQUALS! pinList SEMICOLON!
	;

/**
 * For now, the only type supported is pin.
 */	
type
	:	'pin'
	;

/** 
 * A net declaration consists of the "net" keyword followed by an optional bit slice list, the name
 * of the net, followed by an optional set of attributes, and terminated with a semicolon.
 */	
netDecl
	:	'net'^ sliceDecl? IDENT netAttributes? SEMICOLON! 
	;

/**
 * Net attributes take on the same form as attribute declarations, however they must be wrapped by 
 * the usual keywords.
 */	
netAttributes
	:	'is'! attributeDecl* 'end'!
	;

/**
 * A device instance begins with the keyword "inst" followed by an instance name, a colon, the device name
 * from which it is being instanced, an optional array list specifier, and the keyword "is."  In the body
 * of the device instance, attribute and pin assignments may coexist.  
 */
instanceDecl
	:	'inst'^ arrayDecl? IDENT 'of'! IDENT 'is'!
		(attributeAssignment | pinAssignment)*
		'end'! SEMICOLON!
	;

/**
 * An attribute assignment consists of a string assigned to an attribute name with the optional newattr
 * keyword and instance qualifier.  The newattr keyword signals to the compiler that the user is declaring
 * a new attribute for an instanced device beyond the scope of the device declaration.
 */
attributeAssignment
	:  ('newattr')? instanceQualifier? IDENT EQUALS^ STRING SEMICOLON!
	;
	
/**
 * An instance qualifier begins with the label of the instance, followed by an optional array list
 * and mandatory period.
 */
instanceQualifier
	:	IDENT arrayList? PERIOD^  
	;

/**
 * A pin assignment, a concatenation may be assigned to a pin name with optional slice list, 
 * prefaced by an optional instance qualifier.
 */
pinAssignment
	:	instanceQualifier? IDENT sliceList? EQUALS^ concatenation SEMICOLON!
	;

/**
 * In a net assignment, a concatenation may be assigned to a net with an optional slice list.
 */
netAssignment
	:	IDENT sliceList? EQUALS^ concatenation SEMICOLON!
	;

/**
 * A concatenation consists of either one or more nets with optional slice lists separated by ampersands, 
 * a single bit-wide net in angle brackets to replicate the net across the width it is being assigned to,
 * or left explicity open.
 */
concatenation
	:	((IDENT sliceList?) (AMPERSAND! IDENT sliceList?)* ) 
	|	LEFTANGLE IDENT RIGHTANGLE!
	| 	'open'
	;

/**
 * A pinList is a comma-separated list of pin numbers enclosed in braces.  Each pin number
 * may be 1 or more characaters long, and may begin with either a number or letter.
 */	
pinList
	: 	LEFTBRACE! (IDENT | PIN | INTEGER) (COMMA! (IDENT | PIN | INTEGER))* RIGHTBRACE!
	;
	
/**
 * A sliceList consists of brackets around a single integer, two integers separated by a colon,
 * or a comma-separated list of integers.
 */
sliceList
	: 	LEFTBRACKET INTEGER ((COLON^ INTEGER) | (COMMA^ INTEGER)*) RIGHTBRACKET!
	;

/**
 * A sliceDecl is simialr to a sliceList except it omits the single bit slice option
 */
sliceDecl
	:	LEFTBRACKET INTEGER ((COLON^ INTEGER) | (COMMA^ INTEGER)+) RIGHTBRACKET!
	;

/**
 * An arrayList consists of a parentheses around a single integer, two integers separated by a colon,
 * or a comma-separated list of integers in parentheses.
 */	
arrayList
	: 	LEFTPAREN INTEGER ((COLON^ INTEGER) | (COMMA^ INTEGER (COMMA! INTEGER)*)?) RIGHTPAREN!
	;

/**
 * An arrayDecl is similar to an arrayList except it only allows a colon separated array.
 */
arrayDecl
	:	LEFTPAREN INTEGER COLON^ INTEGER RIGHTPAREN!
	;

/*------------------------------------------------------------------------------------------------------ 
 * Lexer Rules
 *------------------------------------------------------------------------------------------------------*/
 
/**
 * Single character definitions
 */
SEMICOLON: ';';
COLON: ':';
COMMA: ',';
PERIOD: '.';
EQUALS: '=';
LEFTPAREN: '(';
RIGHTPAREN: ')';
LEFTBRACKET: '[';
RIGHTBRACKET: ']';
LEFTBRACE: '{';
RIGHTBRACE: '}';
LEFTANGLE: '<';
RIGHTANGLE: '>';
AMPERSAND: '&';


/**
 * A character can be uppercase or lowercase letters, and a few others
 */
fragment CHAR : ('a'..'z') | ('A'..'Z') | '_' | '+' | '-' | '$';

/**
 * A digit can be any number 0 through 9
 */
fragment DIGIT : ('0'..'9') ;

/**
 * An integer is one or more digits
 */
INTEGER : DIGIT+;

/**
 * A string has it's wrapping quotes removed
 */
STRING
	: 	'"' 							{StringBuilder sb = new StringBuilder();}
		(	c = ~('"' | '\n' | '\r') 	{sb.appendCodePoint(c);}
		)*
		'"' 							{setText(sb.toString());}
	;

/**
 * Identifiers may not begin with a digit
 */
IDENT 
	: 	CHAR (CHAR | DIGIT)*
	;

/**
 * Pin list numbers may begin with a digit
 */
PIN
	:	(CHAR | DIGIT)+
	;
	
/**
 * Phdl whitespace is ignored
 */
WHITESPACE 
	: (' ' | '\t' | '\n' | '\r' | '\f' | '\u001D')+ {$channel = HIDDEN;}
	;

/**
 * Line comments begin with a double forward slash
 */
LINE_COMMENT 
	: '//' .* ('\n' | '\r') {$channel = HIDDEN;}
	;

/**
 * Multi-line comments begin and end with the usual indicators
 */
MULTILINE_COMMENT 
	: '/*' .* '*/' {$channel = HIDDEN;}
	;

