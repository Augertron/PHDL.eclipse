tree grammar PHDLWalker;

options {
  language = Java;
  tokenVocab = PHDL;
  ASTLabelType = CommonTree;
}

@header {
  package phdl;
  import phdl.PHDLDesign;
}

@members {
  private PHDLDesign design;
}



sourceText returns [PHDLDesign design]
	:	design 
	;
	
design
	:	^('design' IDENT (deviceDecl | netDecl)*) {design = new PHDLDesign($IDENT.text);}
	;
	
deviceDecl
	:	^('device' IDENT  {PHDLDevice device = new PHDLDevice($IDENT.text);}
		attrDecl[device]*
		'begin'
		//pinDecl[device]*
		)	{design.addDevice(device);}
	;
	
netDecl
	:	^('net' (msb=IDENT ':' lsb=IDENT)?)
	;	

attrDecl[PHDLDevice d]
	:	^('=' name=IDENT value=STRING_LITERAL) 
		{PHDLAttribute a = new PHDLAttribute($name.text, $value.text);}
		{d.addAttribute(a);}
	;
	
