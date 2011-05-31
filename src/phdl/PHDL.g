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
	:
		design
		EOF
	;	

/** A design contains all relevant information about the PCB design.  Between the keywords
 * "design" and "is" resides the design name.  Before the "begin" keyword, devices and nets are declared in
 * any order.  Following the "begin" keyword, instantiations are located.  The design is terminated with 
 * the "end" keyword and a semicolon.
 */
design
	:	'design'^ IDENT 'is'!
		//configuration?
		(deviceDecl | netDecl)*
		'begin'
		instantiations
		'end'! ';'!
	;
	
/** Not yet implemented. 
 */
configuration
	:	'configuration'^ cfgName 'is'!
		((cfgAttr ','!)* cfgAttr)+
		'end'! ';'!
	;

/** Not yet implemented. 
 */	
cfgName
	:	IDENT
	;

/** Not yet implemented. 
 */	
cfgAttr
	:	IDENT
	;

/** A device declaration contains information about a deviced used in the design.  The device name is 
 * placed between the keywords "device" and "is".  Before the "begin" keyword, attributes to the device
 * are declared.  After the "begin" keyword, pins are declared.  The device declaration is terminated
 * with the "end" keyword and a semicolon.
 */	
deviceDecl
	:	'device'^ deviceName 'is'!
		attrDecl
		'begin'
		pinDecl
		'end'! ';'!
	;

/** A net declaration contains information about a net used in the design.  Nets are declared with the
 * "net" keyword, followed by an optional width, followed by a comma separated list of net names. (Nets
 * may be declared in quantity using this notation.)  Following the comma separated list, an optional 
 * comma separated list of net attributes may be appended using the colon separator.  Finally the net 
 * declaration is terminated in a semicolon.
 */	
netDecl
	:	'net' (width)? (netName ',')* netName (':' (netAttr ',')* netAttr)? ';'
	;

	
netAttr
	:	STRING_LITERAL
	;
	
attrDecl
	:	attrAssignment*
	;

pinDecl
	:	((type width? (pinName ',')* pinName)+ '='! pinNumberList ';'!)*
	;
	
pinNumberList
	:	STRING_LITERAL
	;
	
width
	:	'['! msb (':'! lsb)? ']'!
	;
	
element
	:	INT
	;
	
msb
	: 	INT
	;
	
lsb
	:	INT
	;
	
netName
	:	IDENT
	;

	
instantiations
	:	(instance | subSch | netAssignment)*
	;
	
instance
	:	'inst' instanceName ':' deviceName (width)? 'is'
		(attrAssignment)*
		'begin'
		(pinAssignment)*
		'end' ';'
	;
	
subSch
	:	'subSch' subSchInstanceName ':' subSchName (width)? 'is'
		(attrAssignment)*
		'begin'
		(pinAssignment)*
		'end' ';'
	;
	
subSchInstanceName
	:	IDENT
	;

subSchName
	:	IDENT
	;

instanceName
	:	IDENT
	;
	
deviceName
	:	IDENT
	;

pinName
	:	IDENT
	;
	
type
	:	'in'
	|	'out'
	|	'inout'
	|	'pass'
	|	'sup'
	|	'pwr'
	|	'open'
	|	'pin'
	;
	
pinAssignment
	:	pinName (width)? '='! ((netName (width)?) | 'open') ';'!
	;
	
netAssignment
	:	netName (width)? '='! netName (width)? ';'!
	;
	
attrAssignment
	:	attrName (width)? '='^ attrValue ';'!
	;
	
attrName
	:	IDENT
	;
	
attrValue
	:	STRING_LITERAL
	;

/*------------------------------------------------------------------------------------------------------ 
 * Lexer Rules
 *------------------------------------------------------------------------------------------------------*/
fragment CHAR : ('a'..'z') | ('A'..'Z') | '_' | '-' | '+' | '%' | '.' | '$' | '*';

fragment DIGIT : '0'..'9' ;

fragment COMMA : ',' ;

INT : DIGIT+;

STRING_LITERAL 
	: 	'"' 
		{StringBuilder sb = new StringBuilder();}
		(	'/' '"' 				{sb.appendCodePoint('"');}
		|	c = ~('"'|'\r'|'\n')	{sb.appendCodePoint(c);}
		)*
		'"' 
		{setText(sb.toString());}
	;

IDENT 
	: CHAR ( CHAR | DIGIT )*
	;

WHITESPACE 
	: (' ' | '\t' | '\n' | '\r' | '\f' | '\u001D')+ {$channel = HIDDEN;}
	;
	
LINE_COMMENT 
	: '//' .* ('\n' | '\r' ) {$channel = HIDDEN;}
	;
	
MULTILINE_COMMENT 
	: '/*' .* '*/' {$channel = HIDDEN;}
	;
