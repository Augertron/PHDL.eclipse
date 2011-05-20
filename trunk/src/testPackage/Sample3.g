grammar Sample3;

options {
  language = Java;
}

@header {
  package testPackage;
  import testPackage.evaluators.*;
}

@lexer::header {
  package testPackage;
}

evaluator returns [Evaluator e]
	:	expression EOF {$e = $expression.e;}
	;
// expressions

term returns [Evaluator e]
	:	IDENT {$e = new IntEvaluator(0);}
	|	'(' expression ')' {$e = $expression.e;}
	|	INTEGER {$e = new IntEvaluator(Integer.parseInt($INTEGER.text));}
	;
	
unary returns [Evaluator e]
	:	{boolean positive = true;}
		('+' | '-' {positive = !positive;})* term
		{$e = positive? $term.e : new NegationEvaluator($e);}
	;
	
mult returns [Evaluator e]
	:	op1=unary 			{$e = $op1.e;}
		(	'*' op2=unary 	{$e = new MultEvaluator($e, $op2.e);}
		|	'/' unary		{$e = new DivideEvaluator($e, $op2.e);}
		| 	'mod' unary		{$e = new ModEvaluator($e, $op2.e);}
		)*
	;
	
	
expression returns [Evaluator e]
	:	op1=mult			{$e = $op1.e; }
		(	'+' op2=mult	{$e = new PlusEvaluator($e, $op2.e);}
		| 	'-'	op2=mult	{$e = new MinusEvaluator($e, $op2.e);}
		)*
	;

MULTILINE_COMMENT : '/*' .* '*/' {$channel = HIDDEN;};

STRING_LITERAL 
	: 	'"' 
		{StringBuilder b = new StringBuilder(); }
		(	'"' '"' 				{b.appendCodePoint('"');}
		|	c = ~('"'|'\r'|'\n')	{b.appendCodePoint(c);}
		)*
		'"' 
		{setText(b.toString());}
	;
	
CHAR_LITERAL
	:	'\'' . '\'' {setText(getText().substring(1,2));}
	;

fragment LETTER : ('a'..'z') | ('A'..'Z') ;
fragment DIGIT : '0'..'9' ;
INTEGER : DIGIT+;
IDENT : LETTER ( LETTER | DIGIT )*;
WS : (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;};
COMMENT : '//' .* ('\n' | '\r') {$channel = HIDDEN;};

