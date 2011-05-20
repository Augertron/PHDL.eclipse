tree grammar PHDLWalker;

options {
  language = Java;
  tokenVocab = PHDL;
  ASTLabelType = CommonTree;
}

@header {
  package phdl;
}

@members {
  private String schName = null;
}

sourceText :;
