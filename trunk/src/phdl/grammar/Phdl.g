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


	package phdl.grammar;
	import java.util.TreeSet;
	import java.util.Set;
}

@lexer::header {
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

	package phdl.grammar;
}

@lexer::members {

	/**
	 * Class to enable pushing a character stream onto a stack
	 */
	class SaveStruct {
		public CharStream input;
		public int marker;
		
		/**
		 * The constructor
		 */
		SaveStruct(CharStream input) {
			this.input = input;
			this.marker = input.mark();
		}
	}
	
	/**
	 * The stack of saved character streams
	 */
	Stack<SaveStruct> includes = new Stack<SaveStruct>();
	
	/**
	 * Overridden nextToken method to accomodate the saved character stream states, and how to handle the tokens
	 * entering and leaving an included file.
	 */
	@Override
	public Token nextToken() {
		Token token = super.nextToken();		
		
		if (token.getType() == Token.EOF && !includes.empty()) {
			// EOF and a non-empty stack.  Pop a stream, set to it, 
			// and rewind to its saved marker
			SaveStruct ss = includes.pop();
			setCharStream(ss.input);
			input.rewind(ss.marker);
			
			// used to handle exits from nested includes.
			// it only matters when the 'include' token is the last in the previous stream.
			// using super, lexer crashes, returning EOF token.
			token = this.nextToken();
		}
		
		// skip the first token after switching on another input.
		if (((CommonToken) token).getStartIndex() < 0)
			token = this.nextToken();
			
		return token;
	}
}

@parser::members {

	/**
	 * The list of errors retrived after parsing to report
	 */
	private List<String> errors = new ArrayList<String>();

	/**
	 * Overriding this method allows the parser to bail out on the first unexpected token.  The unexpected token
	 * is reported in the usual format.
	 */
	@Override
	public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
		String hdr = getErrorHeader(e);
		String msg = getErrorMessage(e, tokenNames);
		errors.add(hdr + " unexpected token: " + e.token.getText());
	}

	/**
	 * Accessor method for retrieving the accumulated errors if they exist.
	 */
	public List<String> getErrors() {
		return errors;
	}
}

/*------------------------------------------------------------------------------------------------------ 
 * Parser Rules
 *------------------------------------------------------------------------------------------------------*/

/** 
 * A PHDL file begins with one or more designDecls
 * (design delcarations) followed by the end of the file.
 */
sourceText
	:	designDecl+ EOF
	;

/** 
 * A design declaration consists of the keyword "design" followed by the design name and the keyword "is."
 * Before the "begin" keyword, device and net declarations as well as info structures are placed in any
 * order.  After the "begin" keyword, device instances and net assignments are placed in any order.  The
 * body of the design declaration is terminated with the keyword "end" followed by an optional "design"
 * keyword or the name of the design and finally a semicolon.
 */
designDecl
	:	'design'^ IDENT 'is'! 
		(deviceDecl | netDecl | infoStruct)*
		'begin'
		(instanceDecl | netAssignment | groupStruct)*
		'end'! 'design'!? IDENT? SEMICOLON!
	;

/** 
 * A device declaration consists of the keyword "device" followed by the device name, and the keyword "is."
 * Attribute and pin declarations may coexist anywhere in the body of the device declaration.  The device
 * declaration is terminated with the "end" keyword followed by a semicolon.   Between the keyword "end" and the semicolon you can optionally
 * include the keyword "device" and/or the name specified originally as the device name.
 */	
deviceDecl
	:	'device'^ IDENT 'is'!
		( attributeDecl | pinDecl )*
		'end'! 'device'!? IDENT? SEMICOLON!
	;

/**
 * An attribute declaration begins with the keyword "attr" followed by the attribute name, 
 * an equal sign, and a string.  It then terminates in a semicolon.
 */	
attributeDecl
	:	'attr'^ IDENT EQUALS! STRING SEMICOLON!
	;

/**
 * A pin declaration consists of the pin type, an optional list of slices, and the name of the pin.
 * An equal sign comes next followed by a list of pin names and a semicolon.
 */
pinDecl
	:	type^ sliceDecl? IDENT EQUALS! pinList SEMICOLON!
	;

/**
 * A type is a keyword that indicates the type of a pin.
 */	
type
	:	'pin'
	;

/** 
 * A net declaration consists of the "net" keyword followed by an optional list of slices, the name
 * of the net, followed by an optional set of attributes, and terminated with a semicolon.
 */
netDecl
	:	'net'^ sliceDecl? IDENT (COMMA IDENT)* netAttributes? SEMICOLON!
	;

/**
 * Net attributes consist of the keyword "is" followed by zero or more attribute declarations followed
 * by the keyword "end", "end net", or "end" followed by the name of the net.  Lastly, a semicolon
 * terminates.
 */	
netAttributes
	:	'is'! attributeDecl* 'end'!
	;

/**
 * A device instance begins with the keyword "inst" followed by an optional array
 * specification, the instance name, the keyword "of", the device name from which
 * it is being instanced, and the keyword "is."  The body of the device instance
 * contains attribute and pin assignments as well as info structures placed in any
 * order.  An optional "inst" or the instance name may be placed between the "end"
 * and the semicolon.
 */
instanceDecl
	:	'inst'^ arrayDecl? IDENT 'of'! IDENT 'is'!
		(attributeAssignment | pinAssignment | infoStruct)*
		'end'! 'inst'!? IDENT? SEMICOLON!
	;

/**
 * An info struct consists of the keyword 'info' followed by freeform text surrounded by
 * curly braces.
 */
infoStruct
	: 	'info'^ 'is'! STRING SEMICOLON!
	;
  
groupStruct
	: 	'group'^ STRING 'is'! (instanceDecl | netAssignment)* 'end'! 'group'!? STRING? SEMICOLON!
	;

/**
 * An attribute assignment consists of a string assigned to an attribute name with the optional newattr
 * keyword and instance qualifier.  The newattr keyword signals to the compiler that the user is declaring
 * a new attribute for an instanced device beyond the scope of the device declaration.  Note that you only need
 * to provide an instanceQualifier when the instance is an array of instances and you only want to make the
 * assignment to some of the instances' attributes.  In this case, you would use
 * an instance qualifier to state which instance's attribute is being assigned to.  If you leave off the instance
 * qualifier you are implying that all instances in this construct will be assigned the new attribute value.
 * An example would be 'tolerance = "5%"' (all instances in this construct get this value). 
 */
attributeAssignment
	:	('newattr')? instanceQualifier? IDENT EQUALS^ STRING SEMICOLON!
	;
	
/**
 * An instance qualifier begins with the label of the instance (or the keyword "this" as a shorthand), 
 * followed by an optional array list
 * and mandatory period.  Examples would be: 'this.tolerance = "5%"' (all instances in this construct get this value), 
 * 'this(2).tolerance = "5%"' (only instance 2 gets this value), or 'this(1, 4, 6).tolerance = "5%"' (only instances 1, 4, and 6
 * get this value).
 */
instanceQualifier
	:	(IDENT | 'this') arrayList? PERIOD^  
	;

/**
 * In pin assignment, a concatenation of nets may be assigned to a pin name with optional slice list, 
 * prefaced by an optional instance qualifier.  As with attribute assignments, the instance qualifier is only required
 * when the instance is an array and only some of the instances are to be assigned.  If all are to be assigned, then it can be
 * omitted as in 'a = gnd' (tie all 'a' pins of all instances in this instantiation to ground).  The slice list allows you
 * to specify the various bits of a multi-bit wire as in 'a[3] = gnd', 'a[5:2] = vcc', or 'a[2, 6, 9] = -vcc'. 
 */
pinAssignment
	:	instanceQualifier? IDENT sliceList? EQUALS^ concatenation SEMICOLON!
	;

/**
 * A net assignment consists of an identifier followed by an optional list of slices, an
 * equal sign, a concatenation of nets, and a semicolon.
 */
netAssignment
	:	IDENT sliceList? EQUALS^ concatenation SEMICOLON!
	;

/**
 * There are three forms of concatenation: (1) one or more nets (with optional slice lists) separated by ampersands or (2) 
 * a single bit net surrounded in angle brackets to replicate the net across the width it is being assigned to, or (3)
 * or the keyword "open" to specify that the net is unconnected to anything.  Examples: 'a & b', 'a[3:0] & b[0:3]', '<gnd>'.
 */
concatenation 
	:	((IDENT sliceList?) (AMPERSAND! IDENT sliceList?)* ) 
	|	(LEFTANGLE IDENT sliceList? RIGHTANGLE!)
	| 	'open'
	;

/**
 * A pinList is a comma-separated list of pin numbers enclosed in braces.  Each pin number
 * may be 1 or more characters long, and may begin with either a number or letter.  Examples: '{1}', '{2, 6, 9}', '{A1, A3, A7}'.
 */	
pinList
	: 	LEFTBRACE! (IDENT | INTEGER) (COMMA! (IDENT | INTEGER))* RIGHTBRACE!
	;
	
/**
 * A sliceList consists of a square bracket followed by a single integer, two integers
 * separated by a colon, or a comma-separated list of integers.  A right square bracket
 * then follows.  
 */
sliceList
	: 	LEFTBRACKET INTEGER ((COLON^ INTEGER) | (COMMA^ INTEGER (COMMA! INTEGER)*)?) RIGHTBRACKET!
	;

/**
 * A sliceDecl consists of a left square bracket followed by a single integer or two integers
 * separated by a colon.  A right square bracket then follows.
 */
sliceDecl
	:	LEFTBRACKET INTEGER ((COLON^ INTEGER) | (COMMA^ INTEGER)+) RIGHTBRACKET!
	;

/**
 * An arrayList consists of a left parenthesis folowed by  a single integer, two integers
 * separated by a colon, or a comma-separated list of integers.  A right parenthesis follows.
 */	
arrayList
	: 	LEFTPAREN INTEGER ((COLON^ INTEGER) | (COMMA^ INTEGER (COMMA! INTEGER)*)?) RIGHTPAREN!
	;

/**
 * An arrayDecl is a left parenthesis followed by an integer, a colon, another integer, and a
 * right parenthesis.
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
fragment CHAR : ('a'..'z') | ('A'..'Z') | '_' | '+' | '-' | '$' | '/' ;

/**
 * A digit can be any number 0 through 9
 */
fragment DIGIT : ('0'..'9') ;

/**
 * An integer is one or more digits
 */
INTEGER : DIGIT+;

/**
 * A string has its wrapping quotes removed
 */
STRING
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

/**
 * Identifiers may be one or more digits
 */
IDENT 
	: 	(CHAR | DIGIT)+
	;
	
/**
 * All PHDL whitespace is ignored
 */
WHITESPACE
	: (' ' | '\t' | '\n' | '\r' | '\f' | '\u001D')+ {$channel = HIDDEN;}
	;

/**
 * Line comments begin with a double forward slash.  Everything up to and including the new line or carriage
 * return characters are placed on the hidden channel for the parser to ignore.
 */
LINE_COMMENT 
	: '//' .* ('\n' | '\r') {$channel = HIDDEN;}
	;

/**
 * Multi-line comments begin and end with the usual indicators.  Everything up to and including the terminating
 * token is placed on the hidden channel for the parser to ignore.
 */
MULTILINE_COMMENT 
	: '/*' .* '*/' {$channel = HIDDEN;}
	;

/**
 * Include statements push the current character stream onto a stack and set up a new stream based on the
 * file name of the include directive.  When an EOF character is reached inside the included file, that stream
 * is popped off the stack, and the previous one is turned on again allowing for an uninterrupted stream of
 * tokens to pass to the parser.
 */	
INCLUDE
	: 	'include' (WHITESPACE)? fileName=STRING ';'
			{	String name = fileName.getText();
				name = name.substring(1,name.length()-1);
				try {
					// save the character stream by pushing it onto the stack
					SaveStruct ss = new SaveStruct(input);
					includes.push(ss);

					// make a new ANTLRFileStream and switch to it
					setCharStream(new ANTLRFileStream(name));
					reset();

				} catch(Exception fnf) { 
					// exit if the file cannot be found
					System.out.println(input.getSourceName() + " " + fileName.getLine() 
						+ ":" + fileName.getCharPositionInLine() + " " + 
						"Include file not found: " + fileName.getText()); 
					System.exit(1);
				}
			}
	;
