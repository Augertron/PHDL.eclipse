grammar PHDL;

options {
  language = Java;
  output=AST;
  ASTLabelType=CommonTree;
}

tokens {
  DESIGN;
  CONFIGURATION;
}

@header {
  package phdl;
}

@lexer::header {
  package phdl;
}

//rules
sourceText
	:	includeList
		design
	|	library
		EOF
	;	

includeList
	:	('#include'! directiveName! ';'!)*
	;
	
directiveName
	:	STRING_LITERAL
	;

design
	:	desToken^ designName 'is'!
		configuration?
		(deviceDecl | netDecl)*
		'begin'!
		instantiations
		'end'! ';'!
	;
	
desToken
	:	'design' -> DESIGN
	;
	
designName
	:	IDENT
	;

library
	:	'lib' IDENT 'is'
		'end' ';'
	;
	
configuration
	:	cfgToken^ cfgName 'is'!
		((cfgAttr ','!)* cfgAttr)+
		'end'! ';'!
	;
	
cfgToken
	:	'configuration' -> CONFIGURATION
	;
	
cfgName
	:	IDENT
	;
	
cfgAttr
	:	IDENT
	;
	
deviceDecl
	:	'device' deviceName 'is'
		attrDecl
		'begin'
		pinDecl+
		'end' ';'
	;
	
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
	:	(type width? (pinName ',')* pinName)+ '=' pinNumberList ';'
	;
	
pinNumberList
	:	STRING_LITERAL
	;
	
width
	:	'[' msb (':' lsb)? ']'
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
	:	pinName (width)? '=' ((netName (width)?) | 'open') ';'
	;
	
netAssignment
	:	netName (width)? '=' netName (width)? ';'
	;
	
attrAssignment
	:	attrName (width)? '=' attrValue ';'
	;
	
attrName
	:	IDENT
	;
	
attrValue
	:	STRING_LITERAL
	;

//lexer designations
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
