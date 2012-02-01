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
grammar Phdl;

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
	AMPERSAND = '&';
	
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
	INFO;
	PORT;
	OPEN;
	
	// pin type keywords
	PIN;
	INPIN;
	OUTPIN;
	IOPIN;
	PWRPIN;
	SUPPIN;
	
	// imaginary tree nodes
	DEVICE_DECL;
	DESIGN_DECL;
	SUBDESIGN_DECL;
	ATTR_DECL;
	PIN_DECL;
	PORT_DECL;
	NET_DECL;
	INST_DECL;
	SUBINST_DECL;
	GROUP_DECL;
	INFO_DECL;

	ATTR_ASSIGN;
	SUBATTR_ASSIGN;
	PIN_ASSIGN;
	PORT_ASSIGN;
	CONNECT_ASSIGN;
	
	CONCAT_LIST;
	CONCAT_REPL;
	CONCAT_OPEN;

	WIDTH;
	PIN_LIST;
	PIN_TYPE;
	BOUNDS;
	INDICES;
	OPERAND;
	NAME;
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
	import java.util.Set;
	import java.util.TreeSet;
	import java.util.HashSet;
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
	import java.util.Set;
	import java.util.HashSet;
}

@lexer::members {

	/**
	 * Class to enable pushing a character stream onto a stack
	 */
	class SaveStruct {
		public CharStream input;
		public int marker;
		
		SaveStruct(CharStream input) {
			this.input = input;
			this.marker = input.mark();
		}
	}
	
	/** The stack of saved character streams */
	private Stack<SaveStruct> includes = new Stack<SaveStruct>();
	
	/** The set of included file names to check for duplicate include statements */
	private Set<String> includeNames = new HashSet<String>();
	
	/** getter and setter for above includeNames field */
	public Set<String> getIncludeNames() {
		return includeNames;
	}
	public void setIncludeNames(Set<String> includeNames) {
		this.includeNames = includeNames;
	}
	
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

	/** The list of errors retrived after parsing to report */
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

/*------------------------------------------------------------------------------
 * Parser Rules
 *----------------------------------------------------------------------------*/

/**
 * The sourceText rule is the first rule called on a stream of tokens from
 * the lexer.  Each sourceText token stream must include at least one device
 * or design or subdesign declaration.
 */
sourceText
	:	(deviceDecl | designDecl)+ EOF
	;

/**
 * A device declaration begins with the keyword "device" followed by the device
 * name, a left brace, any number of information, attribute or pin declarations,
 * and finally closed with a right brace.  The subtree is rewritten to include
 * the DEVICE_DECL node as the root.
 */
deviceDecl
	:	DEVICE IDENT LBRACE (infoDecl | attrDecl | pinDecl)* RBRACE 
		-> ^(DEVICE_DECL IDENT infoDecl* attrDecl* pinDecl*)
	;

/**
 * An attribute declaration begins with the keyword "attr" followed by the 
 * attribute name, an equals sign, the attribute value and a semicolon.  The
 * subtree is rewritten with the ATTR_DECL node as the root, with the children
 * name and value.
 */	
attrDecl
	:	ATTR IDENT EQUALS STRING SEMICOLON -> ^(ATTR_DECL IDENT STRING)
	;

/**
 * A pin declaration begins with the pin type subtree, optional width in
 * parentheses, the pin name, an equals sign, the pin list, and terminated with
 * a semicolon.  The subtree is rewritten with PIN_DECL as the root node, with 
 * everything else as children.
 */
pinDecl
	:	pinType (LBRACKET width RBRACKET)? IDENT EQUALS pinList SEMICOLON 
		-> ^(PIN_DECL IDENT pinType width? pinList)
	;

/**
 * A design declaration can begin with either keyword "design" or "subdesign",
 * followed by an identifier, left brace, the design body, and a closing right
 * brace.  Subtrees are constructed with the appropriate root node, either
 * DESIGN_DECL or SUBDESIGN_DECL.  
 */	
designDecl
	:	DESIGN IDENT LBRACE designBody* RBRACE -> ^(DESIGN_DECL IDENT designBody*)
	|	SUBDESIGN IDENT LBRACE designBody* RBRACE -> ^(SUBDESIGN_DECL IDENT designBody*)
	;

/**
 * A design body is a helper rule that allows any of the following rules to
 * remain ordered in the designDecl subtree.  This allows "declare before use"
 * rules to remain in effect.
 */	
designBody
	:	infoDecl
	|	connectDecl
	|	instDecl
	|	connectAssign
	|	groupDecl
	;

/**
 * The infoDecl rule begins with an optional qualifier, the "info" keyword, a
 * left brace, the information string, and ends with a closing right brace.  The
 * subtree is rooted in the INFO_DECL node, with the qualifier and info string
 * as children.
 */
infoDecl
	:	qualifier? INFO LBRACE STRING RBRACE -> ^(INFO_DECL qualifier? STRING)
	;

/**
 * The connectDecl (connection declaration) rule
 */
connectDecl
	:	NET (LBRACKET width RBRACKET)? IDENT (COMMA IDENT)* ((LBRACE attrDecl* RBRACE) | SEMICOLON) 
		-> ^(NET_DECL width? IDENT+ attrDecl*)
		
	|	PORT (LBRACKET width RBRACKET)? IDENT (COMMA IDENT)* SEMICOLON 
		-> ^(PORT_DECL width? IDENT+)
	;

/**
 * The instDecl rule begins with the "inst" keyword, followed by an optional
 * width in parentheses, an identifer signifying the instance name, the
 * keyword "of", an identifier indicating the device name that this instance
 * references, and a left brace.  Any information declaration, attribute
 * assignments, or pin assignments may occur in any order, and the entire
 * instDecl rule is then closed with a right brace.  The subtree is rooted in
 * the INST_DECL node, followed by all relevant information as children in the
 * order shown.
 */
instDecl
	:	INST (LPAREN width RPAREN)? IDENT OF IDENT LBRACE (infoDecl | attrAssign | pinAssign)* RBRACE
		-> ^(INST_DECL width? IDENT IDENT infoDecl* attrAssign* pinAssign*)
		
	|	SUBINST (LPAREN width RPAREN)? IDENT STRING? OF IDENT LBRACE (infoDecl | subAttrAssign | portAssign)* RBRACE
		-> ^(SUBINST_DECL width? IDENT STRING? IDENT infoDecl* subAttrAssign* portAssign*)
	;

/**
 * The attrAssign rule begins with an optional "newattr" keyword, an optional
 * qualifier, an identifier signifying the attribute name, an equals sign, a
 * string signifying the attribute value, and a terminating semicolon.  The 
 * subtree is rooted in the ATTR_ASSIGN node, followed by other relevant
 * information as children.
 */
attrAssign
	:	NEWATTR? qualifier? IDENT EQUALS STRING SEMICOLON 
		-> ^(ATTR_ASSIGN NEWATTR? qualifier? IDENT STRING)
	;
	
/**
 * The subAttrAssign rule begins with an optional "newattr" keyword, followed by
 * an optional qualifier, any number of name-period sequences, an identifier
 * signifying the attribute name, an equals sign, a string containing the 
 * attribute value, and a terminating semicolon.  The subtree is rooted in the
 * SUBATTR_ASSIGN node, with all relevant information as children in the tree.
 */
subAttrAssign
	:	NEWATTR? qualifier? (name PERIOD)+ IDENT EQUALS STRING SEMICOLON
		-> ^(SUBATTR_ASSIGN NEWATTR? qualifier? name+ IDENT STRING)
	;

pinAssign
	:	((COMBINE LPAREN qualifier? operand RPAREN) | qualifier? operand) EQUALS concat SEMICOLON 
		-> ^(PIN_ASSIGN COMBINE? qualifier? operand concat)
	;
	
portAssign
	:	((COMBINE LPAREN qualifier? operand RPAREN) | qualifier? operand) EQUALS concat SEMICOLON 
		-> ^(PORT_ASSIGN COMBINE? qualifier? operand concat)
	;	

/**
 * The connectAssign rule begins with an operand, and equals sign followed by a
 * concat sequence and terminating semicolon.  The subtree is rooted in
 * the NET_ASSIGN node, followed by the operand and concat as children.
 */
connectAssign
	:	operand EQUALS concat SEMICOLON -> ^(CONNECT_ASSIGN operand concat)
	;
	
/**
 * The groupDecl rule looks for the "group" keyword, followed by the group name
 * in the form of a string, a left brace, the group body, and a right closing
 * brace.  The subtree is rooted in the GROUP_DECL node with the string and 
 * group body as children.
 */
groupDecl
	: 	GROUP STRING LBRACE groupBody* RBRACE -> ^(GROUP_DECL STRING groupBody*)
	;
	
/**
 * The groupBody rule is necessary to preserve the order of declared and 
 * instanced items in the groupDecl tree.  Child subtrees follow from each of 
 * the rules below.
 */
groupBody
	:	infoDecl
	|	connectDecl
	|	instDecl
	|	connectAssign
	;

/**
 * The width rule constructs a subtree rooted in the WIDTH node, with
 * two descendents, both integers.  This rule is called anywhere an array of
 * PHDL objects needs to be specified: pinDecl, connectDecl, instDecl,
 * subDesignDecl, and portDecl.
 */
width
	:	INT COLON INT -> ^(WIDTH INT INT)
	;
	

/**
 * The pinType rule forms a subtree with the pin type descending from a root
 * PIN_TYPE node.  This rule is exclusivly called from pinDecl.
 */
pinType
	:	(PIN	-> ^(PIN_TYPE PIN)
	|	INPIN	-> ^(PIN_TYPE INPIN)
	|	OUTPIN	-> ^(PIN_TYPE OUTPIN)
	|	IOPIN	-> ^(PIN_TYPE IOPIN)
	|	PWRPIN	-> ^(PIN_TYPE PWRPIN)
	|	SUPPIN	-> ^(PIN_TYPE SUPPIN))
	;

/**
 * The pinList rule constructs a subtree rooted in the PIN_LIST node, with
 * pinNumbers as descendents.  This rule is exclusively called by pinDecl.
 */
pinList
	: 	LBRACE pinNumber (COMMA pinNumber)* RBRACE -> ^(PIN_LIST pinNumber+)
	;

/**
 * The pinNumber rule allows any combination of numbers and letters to co-
 * exist within a pinList element.  This "helper" rule is necessary to allow
 * distinction between INT and IDENT and still satisfy the lexer rules.
 */	
pinNumber
	:	IDENT | INT | PINNUM
	;

/**
 * The qualifier rule picks up the keyword "this" followed by a list of indices
 * and a period.  Although this rule does not construct a subtree, only the
 * indices are included in the overall tree.
 */	
qualifier
	:	THIS (LPAREN index RPAREN)? PERIOD -> ^(THIS index?)
	;

/**
 * The index rule looks for one of two sequences: two indices separated
 * by a colon, or multiple indices separated by commas.  In each case, a subtree
 * is constructed with the appropriate root node, BOUNDS or INDICES, with the 
 * indices as descendants of the tree.
 */	
index
	:	INT COLON INT					-> ^(BOUNDS INT INT)
	| 	INT (COMMA INT (COMMA INT)*)?	-> ^(INDICES INT+)
	;
	
/**
 * The concat rule looks for three possible scenarios: operands separated
 * by ampersands, one single operand surrounded with angle brackets, or the open
 * keyword.  In each case, a subtree is constructed respectively, with either
 * the CONCAT_LIST, CONCAT_REPL (replicate), or CONCAT_OPEN node as the root.
 */
concat
	:	operand (AMPERSAND operand)* 	-> ^(CONCAT_LIST operand+) 
	|	LANGLE operand RANGLE			-> ^(CONCAT_REPL operand)
	| 	OPEN							-> ^(CONCAT_OPEN)
	;

/**
 * The operand rule looks for an identifier followed by optional indices within 
 * brackets.  The subtree is reconstructed with an OPERAND node, followed by the 
 * identifier and optional indices.
 */
operand
	:	IDENT (LBRACKET index RBRACKET)? -> ^(OPERAND IDENT index?)
	;

/**
 * The name rule looks for an identifier followed by optional indices within 
 * parentheses.  The subtree is reconstructed with an NAME node, followed by the
 * identifier and optional indices.
 */	
name
	:	IDENT (LPAREN index RPAREN)? -> ^(NAME IDENT index?)
	;

	
/*------------------------------------------------------------------------------
 * Lexer Rules
 *----------------------------------------------------------------------------*/

// case insensitive keywords
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
INFO: I N F O;
OPEN: O P E N;
PORT: P O R T;

// case insensitive pin type keywords
PIN: P I N;
INPIN: I N P I N;
OUTPIN: O U T P I N;
IOPIN: I O P I N;
PWRPIN: P W R P I N;
SUPPIN: S U P P I N;

// the case-insensitive alphabet
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

fragment CHAR : ('a'..'z') | ('A'..'Z') | '_' | '+' | '-' | '$' | '/' ;
fragment DIGIT : ('0'..'9') ;

INT: DIGIT+;
IDENT: CHAR (CHAR | DIGIT)*;
PINNUM: DIGIT CHAR+; 

STRING        
@init{StringBuilder lBuf = new StringBuilder();}
    :   DBLQUOTE 
		(	escaped=ESC 			{lBuf.append(escaped.getText());} 
		|	normal=~(DBLQUOTE|'\\')	{lBuf.appendCodePoint(normal);} 
		)* 
		DBLQUOTE     
		{setText(lBuf.toString());}
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
	: '//' ~('\n' | '\r')* {$channel = HIDDEN;}
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
 * file name of the include directive.  When an EOF token is reached inside the included file, that stream
 * is popped off the stack, and the previous one is turned on again allowing for an uninterrupted stream of
 * tokens to pass from the lexer to the parser.
 */	
INCLUDE_DECL
	: 	INCLUDE WHITESPACE? fileName=STRING
		{	String name = fileName.getText();
			name = name.substring(1,name.length()-1);
			System.out.println("  -- Including: " + name);
			// check for duplicate include files
			if (!includeNames.add(name)) {
				System.out.println("ERROR: " + fileName.getInputStream().getSourceName() + " line " + 
						fileName.getLine() + ":" + fileName.getCharPositionInLine() + 
						" duplicate included file.");
            	System.exit(1);
			}
			try {
				// save the character stream by pushing it onto the stack
				SaveStruct ss = new SaveStruct(input);
				includes.push(ss);

				// make a new ANTLRFileStream and switch to it
				setCharStream(new ANTLRFileStream(name));
				reset();

			} catch (Exception fnf) { 
				// exit if the file cannot be found
				System.out.println(input.getSourceName() + " " + fileName.getLine() 
					+ ":" + fileName.getCharPositionInLine() + " " + 
					"Include file not found: " + fileName.getText()); 
				System.exit(1);
			}
		}
	;
	
fragment ESC
	:	'\\'
		(	'n'    {setText("\n");}
		|	'r'    {setText("\r");}
		|	't'    {setText("\t");}
		|	'b'    {setText("\b");}
		|	'f'    {setText("\f");}
		|	'"'    {setText("\"");}
		|	'\''   {setText("\'");}
		|	'/'    {setText("/");}
		|	'\\'   {setText("\\");}
		)
    ;

