/*
    Copyright (C) 2011  Brigham Young University

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, version 3.

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
grammar Phdl2;

options {
	language = Java;
	output = AST;
	ASTLabelType = CommonTree;
	backtrack = true;
}

tokens {
	// single character definitions
	SEMICOLON = ';';
	COLON = ':';
	COMMA = ',';
	PERIOD = '.';
	EQUALS = '=';
	LPAREN = '(';
	RPAREN = ')';
	LBRACKET = '[';
	RBRACKET = ']';
	LBRACE = '{';
	RBRACE = '}';
	LANGLE = '<';
	RANGLE = '>';
	AMPERSAND = '&';
	DBLQUOTE = '"';
	
	// case insensitive keywords
	DESIGN;
	DEVICE;
	SUBDESIGN;
	INST;
	SUBINST;
	GROUP;
	THIS;
	OF;
	NET;
	ATTR;
	NEWATTR;
	BEGIN;
	END;
	COMBINE;
	INCLUDE;
	
	// pin types
	PIN;
	INPIN;
	OUTPIN;
	IOPIN;
	PWRPIN;
	SUPPIN;
	
	// imaginary tree nodes
	WIDTH_DECL;
	WIDTH_DECL;
	DEVICE_DECL;
	ATTR_DECL;
	PIN_DECL;
	PIN_LIST;
	PIN_TYPE;
}

@header {
/*
    Copyright (C) 2011  Brigham Young University

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, version 3.

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

sourceText
	:	(deviceDecl)+
	;

deviceDecl
	:	DEVICE IDENT LBRACE (attrDecl | pinDecl)* RBRACE -> ^(DEVICE_DECL IDENT attrDecl* pinDecl*)
	;
	
attrDecl
	:	ATTR IDENT EQUALS STRING SEMICOLON -> ^(ATTR_DECL IDENT STRING)
	;

pinDecl
	:	pinType widthDecl? IDENT EQUALS pinList SEMICOLON -> ^(PIN_DECL IDENT widthDecl? pinList pinType)
	;

pinType
	:	PIN		-> ^(PIN_TYPE PIN)
	|	INPIN	-> ^(PIN_TYPE INPIN)
	|	OUTPIN	-> ^(PIN_TYPE OUTPIN)
	|	IOPIN	-> ^(PIN_TYPE IOPIN)
	|	PWRPIN	-> ^(PIN_TYPE PWRPIN)
	|	SUPPIN	-> ^(PIN_TYPE SUPPIN)
	;

widthDecl
	:	LBRACKET INT (COLON INT)? RBRACKET -> ^(WIDTH_DECL INT+)
	;

pinList
	: 	LBRACE IDENT (COMMA IDENT)* RBRACE -> ^(PIN_LIST IDENT+)
	;
	
/*------------------------------------------------------------------------------------------------------ 
 * Lexer Rules
 *------------------------------------------------------------------------------------------------------*/

// keywords
DESIGN: D E S I G N;
DEVICE: D E V I C E;
SUBDESIGN: S U B D E S I G N;
INST: I N S T;
SUBINST: S U B I N S T;
GROUP: G R O U P;
THIS: T H I S;
OF: O F;
NET: N E T;
ATTR: A T T R;
NEWATTR: N E W A T T R;
BEGIN: B E G I N;
END: E N D;
COMBINE: C O M B I N E;
INCLUDE: I N C L U D E;

// pin type keywords
PIN: P I N;
INPIN: I N P I N;
OUTPIN: O U T P I N;
IOPIN: I O P I N;
PWRPIN: P W R P I N;
SUPPIN: S U P P I N;

fragment DIGIT : ('0'..'9') ;
fragment CHAR : ('a'..'z') | ('A'..'Z') | ('0'..'9') | '_' | '+' | '-' | '$' | '/' ;

INT: DIGIT+;
IDENT: CHAR+; 

/**
 * A string has its wrapping quotes removed
 */
STRING
	: 	DBLQUOTE 				{StringBuilder sb = new StringBuilder();}
		(	'/' DBLQUOTE 		{sb.appendCodePoint('"');}
		|	c = ~(DBLQUOTE)	
								{	if (c!=' ' && c!='\t' && c!='\n' && c!='\r' && c!='\f' && c!='\u001D')
										sb.appendCodePoint(c);
								}
		)*
		DBLQUOTE 
		{setText(sb.toString());}
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
INCLUDE_DECL
	: 	INCLUDE (WHITESPACE)? fileName=STRING ';'
		{	
			String name = fileName.getText();
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

// the alphabet for case-insensitive lexer keywords
fragment A:('a'|'A');
fragment B:('b'|'B');
fragment C:('c'|'C');
fragment D:('d'|'D');
fragment E:('e'|'E');
fragment F:('f'|'F');
fragment G:('g'|'G');
fragment H:('h'|'H');
fragment I:('i'|'I');
fragment J:('j'|'J');
fragment K:('k'|'K');
fragment L:('l'|'L');
fragment M:('m'|'M');
fragment N:('n'|'N');
fragment O:('o'|'O');
fragment P:('p'|'P');
fragment Q:('q'|'Q');
fragment R:('r'|'R');
fragment S:('s'|'S');
fragment T:('t'|'T');
fragment U:('u'|'U');
fragment V:('v'|'V');
fragment W:('w'|'W');
fragment X:('x'|'X');
fragment Y:('y'|'Y');
fragment Z:('z'|'Z');
