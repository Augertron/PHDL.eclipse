tree grammar Eval;

options {
  language = Java;
  tokenVocab = Expr;
  ASTLabelType = CommonTree;
}

@header {
  package testPackage;
  import java.util.HashMap;
}

@members {
  HashMap<String, Integer> memory = new HashMap<String, Integer>();
}

prog
	:	stat+;
	
stat
	:	expr 			{System.out.println($expr.value);}
	|	^('=' ID expr)	{memory.put($ID.text, new Integer($expr.value));}
	;

expr returns [int value]
	:	^('+' a=expr b=expr) {$value=a+b;}
	|	^('-' a=expr b=expr) {$value=a-b;}
	|	^('*' a=expr b=expr) {$value=a*b;}
	|	ID {
		Integer v = (Integer)memory.get($ID.text);
		if (v != null) $value = v.intValue();
		else System.err.println("undefined variable " + $ID.text); 
		}
	|	INT						{$value = Integer.parseInt($INT.text);}
	;
