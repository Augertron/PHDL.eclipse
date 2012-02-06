// $ANTLR 3.3 Nov 30, 2010 12:50:56 /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g 2012-02-06 13:01:51

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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

/**
 * A grammar to lex and parse a PHDL source file.
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 */
public class PhdlParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SEMICOLON", "COLON", "COMMA", "PERIOD", "EQUALS", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "LANGLE", "RANGLE", "AMPERSAND", "DBLQUOTE", "DESIGN", "DEVICE", "SUBDESIGN", "INST", "SUBINST", "GROUP", "THIS", "OF", "NET", "ATTR", "NEWATTR", "BEGIN", "END", "COMBINE", "INCLUDE", "INFO", "PORT", "OPEN", "PIN", "INPIN", "OUTPIN", "IOPIN", "PWRPIN", "SUPPIN", "DEVICE_DECL", "DESIGN_DECL", "SUBDESIGN_DECL", "ATTR_DECL", "PIN_DECL", "PORT_DECL", "NET_DECL", "INST_DECL", "SUBINST_DECL", "GROUP_DECL", "INFO_DECL", "ATTR_ASSIGN", "SUBATTR_ASSIGN", "PIN_ASSIGN", "PORT_ASSIGN", "CONNECT_ASSIGN", "CONCAT_LIST", "CONCAT_REPL", "CONCAT_OPEN", "WIDTH", "PIN_LIST", "PIN_TYPE", "BOUNDS", "INDICES", "OPERAND", "NAME", "IDENT", "STRING", "INT", "PINNUM", "D", "E", "S", "I", "G", "N", "V", "C", "U", "B", "T", "R", "O", "P", "H", "F", "A", "W", "M", "L", "J", "K", "Q", "X", "Y", "Z", "CHAR", "DIGIT", "ESC", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "INCLUDE_DECL"
    };
    public static final int EOF=-1;
    public static final int SEMICOLON=4;
    public static final int COLON=5;
    public static final int COMMA=6;
    public static final int PERIOD=7;
    public static final int EQUALS=8;
    public static final int LPAREN=9;
    public static final int RPAREN=10;
    public static final int LBRACKET=11;
    public static final int RBRACKET=12;
    public static final int LBRACE=13;
    public static final int RBRACE=14;
    public static final int LANGLE=15;
    public static final int RANGLE=16;
    public static final int AMPERSAND=17;
    public static final int DBLQUOTE=18;
    public static final int DESIGN=19;
    public static final int DEVICE=20;
    public static final int SUBDESIGN=21;
    public static final int INST=22;
    public static final int SUBINST=23;
    public static final int GROUP=24;
    public static final int THIS=25;
    public static final int OF=26;
    public static final int NET=27;
    public static final int ATTR=28;
    public static final int NEWATTR=29;
    public static final int BEGIN=30;
    public static final int END=31;
    public static final int COMBINE=32;
    public static final int INCLUDE=33;
    public static final int INFO=34;
    public static final int PORT=35;
    public static final int OPEN=36;
    public static final int PIN=37;
    public static final int INPIN=38;
    public static final int OUTPIN=39;
    public static final int IOPIN=40;
    public static final int PWRPIN=41;
    public static final int SUPPIN=42;
    public static final int DEVICE_DECL=43;
    public static final int DESIGN_DECL=44;
    public static final int SUBDESIGN_DECL=45;
    public static final int ATTR_DECL=46;
    public static final int PIN_DECL=47;
    public static final int PORT_DECL=48;
    public static final int NET_DECL=49;
    public static final int INST_DECL=50;
    public static final int SUBINST_DECL=51;
    public static final int GROUP_DECL=52;
    public static final int INFO_DECL=53;
    public static final int ATTR_ASSIGN=54;
    public static final int SUBATTR_ASSIGN=55;
    public static final int PIN_ASSIGN=56;
    public static final int PORT_ASSIGN=57;
    public static final int CONNECT_ASSIGN=58;
    public static final int CONCAT_LIST=59;
    public static final int CONCAT_REPL=60;
    public static final int CONCAT_OPEN=61;
    public static final int WIDTH=62;
    public static final int PIN_LIST=63;
    public static final int PIN_TYPE=64;
    public static final int BOUNDS=65;
    public static final int INDICES=66;
    public static final int OPERAND=67;
    public static final int NAME=68;
    public static final int IDENT=69;
    public static final int STRING=70;
    public static final int INT=71;
    public static final int PINNUM=72;
    public static final int D=73;
    public static final int E=74;
    public static final int S=75;
    public static final int I=76;
    public static final int G=77;
    public static final int N=78;
    public static final int V=79;
    public static final int C=80;
    public static final int U=81;
    public static final int B=82;
    public static final int T=83;
    public static final int R=84;
    public static final int O=85;
    public static final int P=86;
    public static final int H=87;
    public static final int F=88;
    public static final int A=89;
    public static final int W=90;
    public static final int M=91;
    public static final int L=92;
    public static final int J=93;
    public static final int K=94;
    public static final int Q=95;
    public static final int X=96;
    public static final int Y=97;
    public static final int Z=98;
    public static final int CHAR=99;
    public static final int DIGIT=100;
    public static final int ESC=101;
    public static final int WHITESPACE=102;
    public static final int LINE_COMMENT=103;
    public static final int MULTILINE_COMMENT=104;
    public static final int INCLUDE_DECL=105;

    // delegates
    // delegators


        public PhdlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PhdlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return PhdlParser.tokenNames; }
    public String getGrammarFileName() { return "/fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g"; }



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


    public static class sourceText_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sourceText"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:253:1: sourceText : ( deviceDecl | designDecl )+ EOF ;
    public final PhdlParser.sourceText_return sourceText() throws RecognitionException {
        PhdlParser.sourceText_return retval = new PhdlParser.sourceText_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF3=null;
        PhdlParser.deviceDecl_return deviceDecl1 = null;

        PhdlParser.designDecl_return designDecl2 = null;


        CommonTree EOF3_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:259:2: ( ( deviceDecl | designDecl )+ EOF )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:259:4: ( deviceDecl | designDecl )+ EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:259:4: ( deviceDecl | designDecl )+
            int cnt1=0;
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==DEVICE) ) {
                    alt1=1;
                }
                else if ( (LA1_0==DESIGN||LA1_0==SUBDESIGN) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:259:5: deviceDecl
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_sourceText443);
            	    deviceDecl1=deviceDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, deviceDecl1.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:259:18: designDecl
            	    {
            	    pushFollow(FOLLOW_designDecl_in_sourceText447);
            	    designDecl2=designDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, designDecl2.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_sourceText451); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EOF3_tree = (CommonTree)adaptor.create(EOF3);
            adaptor.addChild(root_0, EOF3_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sourceText"

    public static class deviceDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "deviceDecl"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:262:1: deviceDecl : DEVICE IDENT LBRACE ( infoDecl | attrDecl | pinDecl )* RBRACE -> ^( DEVICE_DECL IDENT ( infoDecl )* ( attrDecl )* ( pinDecl )* ) ;
    public final PhdlParser.deviceDecl_return deviceDecl() throws RecognitionException {
        PhdlParser.deviceDecl_return retval = new PhdlParser.deviceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DEVICE4=null;
        Token IDENT5=null;
        Token LBRACE6=null;
        Token RBRACE10=null;
        PhdlParser.infoDecl_return infoDecl7 = null;

        PhdlParser.attrDecl_return attrDecl8 = null;

        PhdlParser.pinDecl_return pinDecl9 = null;


        CommonTree DEVICE4_tree=null;
        CommonTree IDENT5_tree=null;
        CommonTree LBRACE6_tree=null;
        CommonTree RBRACE10_tree=null;
        RewriteRuleTokenStream stream_DEVICE=new RewriteRuleTokenStream(adaptor,"token DEVICE");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_pinDecl=new RewriteRuleSubtreeStream(adaptor,"rule pinDecl");
        RewriteRuleSubtreeStream stream_attrDecl=new RewriteRuleSubtreeStream(adaptor,"rule attrDecl");
        RewriteRuleSubtreeStream stream_infoDecl=new RewriteRuleSubtreeStream(adaptor,"rule infoDecl");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:269:2: ( DEVICE IDENT LBRACE ( infoDecl | attrDecl | pinDecl )* RBRACE -> ^( DEVICE_DECL IDENT ( infoDecl )* ( attrDecl )* ( pinDecl )* ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:269:4: DEVICE IDENT LBRACE ( infoDecl | attrDecl | pinDecl )* RBRACE
            {
            DEVICE4=(Token)match(input,DEVICE,FOLLOW_DEVICE_in_deviceDecl464); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DEVICE.add(DEVICE4);

            IDENT5=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl466); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT5);

            LBRACE6=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_deviceDecl468); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE6);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:269:24: ( infoDecl | attrDecl | pinDecl )*
            loop2:
            do {
                int alt2=4;
                switch ( input.LA(1) ) {
                case THIS:
                case INFO:
                    {
                    alt2=1;
                    }
                    break;
                case ATTR:
                    {
                    alt2=2;
                    }
                    break;
                case PIN:
                case INPIN:
                case OUTPIN:
                case IOPIN:
                case PWRPIN:
                case SUPPIN:
                    {
                    alt2=3;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:269:25: infoDecl
            	    {
            	    pushFollow(FOLLOW_infoDecl_in_deviceDecl471);
            	    infoDecl7=infoDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_infoDecl.add(infoDecl7.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:269:36: attrDecl
            	    {
            	    pushFollow(FOLLOW_attrDecl_in_deviceDecl475);
            	    attrDecl8=attrDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_attrDecl.add(attrDecl8.getTree());

            	    }
            	    break;
            	case 3 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:269:47: pinDecl
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl479);
            	    pinDecl9=pinDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_pinDecl.add(pinDecl9.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            RBRACE10=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_deviceDecl483); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE10);



            // AST REWRITE
            // elements: pinDecl, IDENT, attrDecl, infoDecl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 270:3: -> ^( DEVICE_DECL IDENT ( infoDecl )* ( attrDecl )* ( pinDecl )* )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:270:6: ^( DEVICE_DECL IDENT ( infoDecl )* ( attrDecl )* ( pinDecl )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DEVICE_DECL, "DEVICE_DECL"), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:270:26: ( infoDecl )*
                while ( stream_infoDecl.hasNext() ) {
                    adaptor.addChild(root_1, stream_infoDecl.nextTree());

                }
                stream_infoDecl.reset();
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:270:36: ( attrDecl )*
                while ( stream_attrDecl.hasNext() ) {
                    adaptor.addChild(root_1, stream_attrDecl.nextTree());

                }
                stream_attrDecl.reset();
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:270:46: ( pinDecl )*
                while ( stream_pinDecl.hasNext() ) {
                    adaptor.addChild(root_1, stream_pinDecl.nextTree());

                }
                stream_pinDecl.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "deviceDecl"

    public static class attrDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attrDecl"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:273:1: attrDecl : ATTR IDENT EQUALS STRING SEMICOLON -> ^( ATTR_DECL IDENT STRING ) ;
    public final PhdlParser.attrDecl_return attrDecl() throws RecognitionException {
        PhdlParser.attrDecl_return retval = new PhdlParser.attrDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ATTR11=null;
        Token IDENT12=null;
        Token EQUALS13=null;
        Token STRING14=null;
        Token SEMICOLON15=null;

        CommonTree ATTR11_tree=null;
        CommonTree IDENT12_tree=null;
        CommonTree EQUALS13_tree=null;
        CommonTree STRING14_tree=null;
        CommonTree SEMICOLON15_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_ATTR=new RewriteRuleTokenStream(adaptor,"token ATTR");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:280:2: ( ATTR IDENT EQUALS STRING SEMICOLON -> ^( ATTR_DECL IDENT STRING ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:280:4: ATTR IDENT EQUALS STRING SEMICOLON
            {
            ATTR11=(Token)match(input,ATTR,FOLLOW_ATTR_in_attrDecl517); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ATTR.add(ATTR11);

            IDENT12=(Token)match(input,IDENT,FOLLOW_IDENT_in_attrDecl519); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT12);

            EQUALS13=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attrDecl521); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS13);

            STRING14=(Token)match(input,STRING,FOLLOW_STRING_in_attrDecl523); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(STRING14);

            SEMICOLON15=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attrDecl525); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON15);



            // AST REWRITE
            // elements: STRING, IDENT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 280:39: -> ^( ATTR_DECL IDENT STRING )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:280:42: ^( ATTR_DECL IDENT STRING )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ATTR_DECL, "ATTR_DECL"), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                adaptor.addChild(root_1, stream_STRING.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attrDecl"

    public static class pinDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pinDecl"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:283:1: pinDecl : pinType ( LBRACKET width RBRACKET )? IDENT EQUALS pinList SEMICOLON -> ^( PIN_DECL IDENT pinType ( width )? pinList ) ;
    public final PhdlParser.pinDecl_return pinDecl() throws RecognitionException {
        PhdlParser.pinDecl_return retval = new PhdlParser.pinDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACKET17=null;
        Token RBRACKET19=null;
        Token IDENT20=null;
        Token EQUALS21=null;
        Token SEMICOLON23=null;
        PhdlParser.pinType_return pinType16 = null;

        PhdlParser.width_return width18 = null;

        PhdlParser.pinList_return pinList22 = null;


        CommonTree LBRACKET17_tree=null;
        CommonTree RBRACKET19_tree=null;
        CommonTree IDENT20_tree=null;
        CommonTree EQUALS21_tree=null;
        CommonTree SEMICOLON23_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleSubtreeStream stream_width=new RewriteRuleSubtreeStream(adaptor,"rule width");
        RewriteRuleSubtreeStream stream_pinList=new RewriteRuleSubtreeStream(adaptor,"rule pinList");
        RewriteRuleSubtreeStream stream_pinType=new RewriteRuleSubtreeStream(adaptor,"rule pinType");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:290:2: ( pinType ( LBRACKET width RBRACKET )? IDENT EQUALS pinList SEMICOLON -> ^( PIN_DECL IDENT pinType ( width )? pinList ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:290:4: pinType ( LBRACKET width RBRACKET )? IDENT EQUALS pinList SEMICOLON
            {
            pushFollow(FOLLOW_pinType_in_pinDecl548);
            pinType16=pinType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_pinType.add(pinType16.getTree());
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:290:12: ( LBRACKET width RBRACKET )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==LBRACKET) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:290:13: LBRACKET width RBRACKET
                    {
                    LBRACKET17=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_pinDecl551); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET17);

                    pushFollow(FOLLOW_width_in_pinDecl553);
                    width18=width();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_width.add(width18.getTree());
                    RBRACKET19=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_pinDecl555); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET19);


                    }
                    break;

            }

            IDENT20=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinDecl559); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT20);

            EQUALS21=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinDecl561); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS21);

            pushFollow(FOLLOW_pinList_in_pinDecl563);
            pinList22=pinList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_pinList.add(pinList22.getTree());
            SEMICOLON23=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinDecl565); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON23);



            // AST REWRITE
            // elements: pinType, pinList, width, IDENT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 291:3: -> ^( PIN_DECL IDENT pinType ( width )? pinList )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:291:6: ^( PIN_DECL IDENT pinType ( width )? pinList )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PIN_DECL, "PIN_DECL"), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                adaptor.addChild(root_1, stream_pinType.nextTree());
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:291:31: ( width )?
                if ( stream_width.hasNext() ) {
                    adaptor.addChild(root_1, stream_width.nextTree());

                }
                stream_width.reset();
                adaptor.addChild(root_1, stream_pinList.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "pinDecl"

    public static class designDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "designDecl"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:294:1: designDecl : ( DESIGN IDENT LBRACE ( designBody )* RBRACE -> ^( DESIGN_DECL IDENT ( designBody )* ) | SUBDESIGN IDENT LBRACE ( designBody )* RBRACE -> ^( SUBDESIGN_DECL IDENT ( designBody )* ) );
    public final PhdlParser.designDecl_return designDecl() throws RecognitionException {
        PhdlParser.designDecl_return retval = new PhdlParser.designDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DESIGN24=null;
        Token IDENT25=null;
        Token LBRACE26=null;
        Token RBRACE28=null;
        Token SUBDESIGN29=null;
        Token IDENT30=null;
        Token LBRACE31=null;
        Token RBRACE33=null;
        PhdlParser.designBody_return designBody27 = null;

        PhdlParser.designBody_return designBody32 = null;


        CommonTree DESIGN24_tree=null;
        CommonTree IDENT25_tree=null;
        CommonTree LBRACE26_tree=null;
        CommonTree RBRACE28_tree=null;
        CommonTree SUBDESIGN29_tree=null;
        CommonTree IDENT30_tree=null;
        CommonTree LBRACE31_tree=null;
        CommonTree RBRACE33_tree=null;
        RewriteRuleTokenStream stream_DESIGN=new RewriteRuleTokenStream(adaptor,"token DESIGN");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_SUBDESIGN=new RewriteRuleTokenStream(adaptor,"token SUBDESIGN");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_designBody=new RewriteRuleSubtreeStream(adaptor,"rule designBody");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:301:2: ( DESIGN IDENT LBRACE ( designBody )* RBRACE -> ^( DESIGN_DECL IDENT ( designBody )* ) | SUBDESIGN IDENT LBRACE ( designBody )* RBRACE -> ^( SUBDESIGN_DECL IDENT ( designBody )* ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==DESIGN) ) {
                alt6=1;
            }
            else if ( (LA6_0==SUBDESIGN) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:301:4: DESIGN IDENT LBRACE ( designBody )* RBRACE
                    {
                    DESIGN24=(Token)match(input,DESIGN,FOLLOW_DESIGN_in_designDecl597); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DESIGN.add(DESIGN24);

                    IDENT25=(Token)match(input,IDENT,FOLLOW_IDENT_in_designDecl599); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT25);

                    LBRACE26=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_designDecl601); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE26);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:301:24: ( designBody )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>=INST && LA4_0<=THIS)||LA4_0==NET||(LA4_0>=INFO && LA4_0<=PORT)||LA4_0==IDENT) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:0:0: designBody
                    	    {
                    	    pushFollow(FOLLOW_designBody_in_designDecl603);
                    	    designBody27=designBody();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_designBody.add(designBody27.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    RBRACE28=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_designDecl606); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE28);



                    // AST REWRITE
                    // elements: IDENT, designBody
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 301:43: -> ^( DESIGN_DECL IDENT ( designBody )* )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:301:46: ^( DESIGN_DECL IDENT ( designBody )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DESIGN_DECL, "DESIGN_DECL"), root_1);

                        adaptor.addChild(root_1, stream_IDENT.nextNode());
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:301:66: ( designBody )*
                        while ( stream_designBody.hasNext() ) {
                            adaptor.addChild(root_1, stream_designBody.nextTree());

                        }
                        stream_designBody.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:302:4: SUBDESIGN IDENT LBRACE ( designBody )* RBRACE
                    {
                    SUBDESIGN29=(Token)match(input,SUBDESIGN,FOLLOW_SUBDESIGN_in_designDecl622); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SUBDESIGN.add(SUBDESIGN29);

                    IDENT30=(Token)match(input,IDENT,FOLLOW_IDENT_in_designDecl624); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT30);

                    LBRACE31=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_designDecl626); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE31);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:302:27: ( designBody )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>=INST && LA5_0<=THIS)||LA5_0==NET||(LA5_0>=INFO && LA5_0<=PORT)||LA5_0==IDENT) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:0:0: designBody
                    	    {
                    	    pushFollow(FOLLOW_designBody_in_designDecl628);
                    	    designBody32=designBody();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_designBody.add(designBody32.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    RBRACE33=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_designDecl631); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE33);



                    // AST REWRITE
                    // elements: designBody, IDENT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 302:46: -> ^( SUBDESIGN_DECL IDENT ( designBody )* )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:302:49: ^( SUBDESIGN_DECL IDENT ( designBody )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SUBDESIGN_DECL, "SUBDESIGN_DECL"), root_1);

                        adaptor.addChild(root_1, stream_IDENT.nextNode());
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:302:72: ( designBody )*
                        while ( stream_designBody.hasNext() ) {
                            adaptor.addChild(root_1, stream_designBody.nextTree());

                        }
                        stream_designBody.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "designDecl"

    public static class designBody_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "designBody"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:305:1: designBody : ( infoDecl | connectDecl | instDecl | connectAssign | groupDecl );
    public final PhdlParser.designBody_return designBody() throws RecognitionException {
        PhdlParser.designBody_return retval = new PhdlParser.designBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        PhdlParser.infoDecl_return infoDecl34 = null;

        PhdlParser.connectDecl_return connectDecl35 = null;

        PhdlParser.instDecl_return instDecl36 = null;

        PhdlParser.connectAssign_return connectAssign37 = null;

        PhdlParser.groupDecl_return groupDecl38 = null;



        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:311:2: ( infoDecl | connectDecl | instDecl | connectAssign | groupDecl )
            int alt7=5;
            switch ( input.LA(1) ) {
            case THIS:
            case INFO:
                {
                alt7=1;
                }
                break;
            case NET:
            case PORT:
                {
                alt7=2;
                }
                break;
            case INST:
            case SUBINST:
                {
                alt7=3;
                }
                break;
            case IDENT:
                {
                alt7=4;
                }
                break;
            case GROUP:
                {
                alt7=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:311:4: infoDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_infoDecl_in_designBody656);
                    infoDecl34=infoDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, infoDecl34.getTree());

                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:312:4: connectDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_connectDecl_in_designBody661);
                    connectDecl35=connectDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, connectDecl35.getTree());

                    }
                    break;
                case 3 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:313:4: instDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_instDecl_in_designBody666);
                    instDecl36=instDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, instDecl36.getTree());

                    }
                    break;
                case 4 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:314:4: connectAssign
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_connectAssign_in_designBody671);
                    connectAssign37=connectAssign();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, connectAssign37.getTree());

                    }
                    break;
                case 5 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:315:4: groupDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_groupDecl_in_designBody676);
                    groupDecl38=groupDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, groupDecl38.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "designBody"

    public static class infoDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "infoDecl"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:318:1: infoDecl : ( qualifier )? INFO LBRACE STRING RBRACE -> ^( INFO_DECL ( qualifier )? STRING ) ;
    public final PhdlParser.infoDecl_return infoDecl() throws RecognitionException {
        PhdlParser.infoDecl_return retval = new PhdlParser.infoDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INFO40=null;
        Token LBRACE41=null;
        Token STRING42=null;
        Token RBRACE43=null;
        PhdlParser.qualifier_return qualifier39 = null;


        CommonTree INFO40_tree=null;
        CommonTree LBRACE41_tree=null;
        CommonTree STRING42_tree=null;
        CommonTree RBRACE43_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_INFO=new RewriteRuleTokenStream(adaptor,"token INFO");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_qualifier=new RewriteRuleSubtreeStream(adaptor,"rule qualifier");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:325:2: ( ( qualifier )? INFO LBRACE STRING RBRACE -> ^( INFO_DECL ( qualifier )? STRING ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:325:4: ( qualifier )? INFO LBRACE STRING RBRACE
            {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:325:4: ( qualifier )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==THIS) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:0:0: qualifier
                    {
                    pushFollow(FOLLOW_qualifier_in_infoDecl689);
                    qualifier39=qualifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_qualifier.add(qualifier39.getTree());

                    }
                    break;

            }

            INFO40=(Token)match(input,INFO,FOLLOW_INFO_in_infoDecl692); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INFO.add(INFO40);

            LBRACE41=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_infoDecl694); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE41);

            STRING42=(Token)match(input,STRING,FOLLOW_STRING_in_infoDecl696); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(STRING42);

            RBRACE43=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_infoDecl698); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE43);



            // AST REWRITE
            // elements: STRING, qualifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 325:41: -> ^( INFO_DECL ( qualifier )? STRING )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:325:44: ^( INFO_DECL ( qualifier )? STRING )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INFO_DECL, "INFO_DECL"), root_1);

                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:325:56: ( qualifier )?
                if ( stream_qualifier.hasNext() ) {
                    adaptor.addChild(root_1, stream_qualifier.nextTree());

                }
                stream_qualifier.reset();
                adaptor.addChild(root_1, stream_STRING.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "infoDecl"

    public static class connectDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "connectDecl"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:328:1: connectDecl : ( NET ( LBRACKET width RBRACKET )? IDENT ( COMMA IDENT )* ( ( LBRACE ( attrDecl )* RBRACE ) | SEMICOLON ) -> ^( NET_DECL ( width )? ( IDENT )+ ( attrDecl )* ) | PORT ( LBRACKET width RBRACKET )? IDENT ( COMMA IDENT )* SEMICOLON -> ^( PORT_DECL ( width )? ( IDENT )+ ) );
    public final PhdlParser.connectDecl_return connectDecl() throws RecognitionException {
        PhdlParser.connectDecl_return retval = new PhdlParser.connectDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NET44=null;
        Token LBRACKET45=null;
        Token RBRACKET47=null;
        Token IDENT48=null;
        Token COMMA49=null;
        Token IDENT50=null;
        Token LBRACE51=null;
        Token RBRACE53=null;
        Token SEMICOLON54=null;
        Token PORT55=null;
        Token LBRACKET56=null;
        Token RBRACKET58=null;
        Token IDENT59=null;
        Token COMMA60=null;
        Token IDENT61=null;
        Token SEMICOLON62=null;
        PhdlParser.width_return width46 = null;

        PhdlParser.attrDecl_return attrDecl52 = null;

        PhdlParser.width_return width57 = null;


        CommonTree NET44_tree=null;
        CommonTree LBRACKET45_tree=null;
        CommonTree RBRACKET47_tree=null;
        CommonTree IDENT48_tree=null;
        CommonTree COMMA49_tree=null;
        CommonTree IDENT50_tree=null;
        CommonTree LBRACE51_tree=null;
        CommonTree RBRACE53_tree=null;
        CommonTree SEMICOLON54_tree=null;
        CommonTree PORT55_tree=null;
        CommonTree LBRACKET56_tree=null;
        CommonTree RBRACKET58_tree=null;
        CommonTree IDENT59_tree=null;
        CommonTree COMMA60_tree=null;
        CommonTree IDENT61_tree=null;
        CommonTree SEMICOLON62_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_PORT=new RewriteRuleTokenStream(adaptor,"token PORT");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_NET=new RewriteRuleTokenStream(adaptor,"token NET");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_width=new RewriteRuleSubtreeStream(adaptor,"rule width");
        RewriteRuleSubtreeStream stream_attrDecl=new RewriteRuleSubtreeStream(adaptor,"rule attrDecl");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:332:2: ( NET ( LBRACKET width RBRACKET )? IDENT ( COMMA IDENT )* ( ( LBRACE ( attrDecl )* RBRACE ) | SEMICOLON ) -> ^( NET_DECL ( width )? ( IDENT )+ ( attrDecl )* ) | PORT ( LBRACKET width RBRACKET )? IDENT ( COMMA IDENT )* SEMICOLON -> ^( PORT_DECL ( width )? ( IDENT )+ ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==NET) ) {
                alt15=1;
            }
            else if ( (LA15_0==PORT) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:332:4: NET ( LBRACKET width RBRACKET )? IDENT ( COMMA IDENT )* ( ( LBRACE ( attrDecl )* RBRACE ) | SEMICOLON )
                    {
                    NET44=(Token)match(input,NET,FOLLOW_NET_in_connectDecl722); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NET.add(NET44);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:332:8: ( LBRACKET width RBRACKET )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==LBRACKET) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:332:9: LBRACKET width RBRACKET
                            {
                            LBRACKET45=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_connectDecl725); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET45);

                            pushFollow(FOLLOW_width_in_connectDecl727);
                            width46=width();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_width.add(width46.getTree());
                            RBRACKET47=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_connectDecl729); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET47);


                            }
                            break;

                    }

                    IDENT48=(Token)match(input,IDENT,FOLLOW_IDENT_in_connectDecl733); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT48);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:332:41: ( COMMA IDENT )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==COMMA) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:332:42: COMMA IDENT
                    	    {
                    	    COMMA49=(Token)match(input,COMMA,FOLLOW_COMMA_in_connectDecl736); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA49);

                    	    IDENT50=(Token)match(input,IDENT,FOLLOW_IDENT_in_connectDecl738); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_IDENT.add(IDENT50);


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:332:56: ( ( LBRACE ( attrDecl )* RBRACE ) | SEMICOLON )
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==LBRACE) ) {
                        alt12=1;
                    }
                    else if ( (LA12_0==SEMICOLON) ) {
                        alt12=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 0, input);

                        throw nvae;
                    }
                    switch (alt12) {
                        case 1 :
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:332:57: ( LBRACE ( attrDecl )* RBRACE )
                            {
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:332:57: ( LBRACE ( attrDecl )* RBRACE )
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:332:58: LBRACE ( attrDecl )* RBRACE
                            {
                            LBRACE51=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_connectDecl744); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE51);

                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:332:65: ( attrDecl )*
                            loop11:
                            do {
                                int alt11=2;
                                int LA11_0 = input.LA(1);

                                if ( (LA11_0==ATTR) ) {
                                    alt11=1;
                                }


                                switch (alt11) {
                            	case 1 :
                            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:0:0: attrDecl
                            	    {
                            	    pushFollow(FOLLOW_attrDecl_in_connectDecl746);
                            	    attrDecl52=attrDecl();

                            	    state._fsp--;
                            	    if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) stream_attrDecl.add(attrDecl52.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop11;
                                }
                            } while (true);

                            RBRACE53=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_connectDecl749); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE53);


                            }


                            }
                            break;
                        case 2 :
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:332:85: SEMICOLON
                            {
                            SEMICOLON54=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_connectDecl754); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON54);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: attrDecl, width, IDENT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 333:3: -> ^( NET_DECL ( width )? ( IDENT )+ ( attrDecl )* )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:333:6: ^( NET_DECL ( width )? ( IDENT )+ ( attrDecl )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NET_DECL, "NET_DECL"), root_1);

                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:333:17: ( width )?
                        if ( stream_width.hasNext() ) {
                            adaptor.addChild(root_1, stream_width.nextTree());

                        }
                        stream_width.reset();
                        if ( !(stream_IDENT.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_IDENT.hasNext() ) {
                            adaptor.addChild(root_1, stream_IDENT.nextNode());

                        }
                        stream_IDENT.reset();
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:333:31: ( attrDecl )*
                        while ( stream_attrDecl.hasNext() ) {
                            adaptor.addChild(root_1, stream_attrDecl.nextTree());

                        }
                        stream_attrDecl.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:335:4: PORT ( LBRACKET width RBRACKET )? IDENT ( COMMA IDENT )* SEMICOLON
                    {
                    PORT55=(Token)match(input,PORT,FOLLOW_PORT_in_connectDecl781); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PORT.add(PORT55);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:335:9: ( LBRACKET width RBRACKET )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==LBRACKET) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:335:10: LBRACKET width RBRACKET
                            {
                            LBRACKET56=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_connectDecl784); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET56);

                            pushFollow(FOLLOW_width_in_connectDecl786);
                            width57=width();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_width.add(width57.getTree());
                            RBRACKET58=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_connectDecl788); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET58);


                            }
                            break;

                    }

                    IDENT59=(Token)match(input,IDENT,FOLLOW_IDENT_in_connectDecl792); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT59);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:335:42: ( COMMA IDENT )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==COMMA) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:335:43: COMMA IDENT
                    	    {
                    	    COMMA60=(Token)match(input,COMMA,FOLLOW_COMMA_in_connectDecl795); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA60);

                    	    IDENT61=(Token)match(input,IDENT,FOLLOW_IDENT_in_connectDecl797); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_IDENT.add(IDENT61);


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    SEMICOLON62=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_connectDecl801); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON62);



                    // AST REWRITE
                    // elements: IDENT, width
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 336:3: -> ^( PORT_DECL ( width )? ( IDENT )+ )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:336:6: ^( PORT_DECL ( width )? ( IDENT )+ )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PORT_DECL, "PORT_DECL"), root_1);

                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:336:18: ( width )?
                        if ( stream_width.hasNext() ) {
                            adaptor.addChild(root_1, stream_width.nextTree());

                        }
                        stream_width.reset();
                        if ( !(stream_IDENT.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_IDENT.hasNext() ) {
                            adaptor.addChild(root_1, stream_IDENT.nextNode());

                        }
                        stream_IDENT.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "connectDecl"

    public static class instDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "instDecl"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:339:1: instDecl : ( INST ( LPAREN width RPAREN )? IDENT OF IDENT LBRACE ( infoDecl | attrAssign | pinAssign )* RBRACE -> ^( INST_DECL ( width )? IDENT IDENT ( infoDecl )* ( attrAssign )* ( pinAssign )* ) | SUBINST ( LPAREN width RPAREN )? IDENT ( STRING )? OF IDENT LBRACE ( infoDecl | subAttrAssign | portAssign )* RBRACE -> ^( SUBINST_DECL ( width )? IDENT ( STRING )? IDENT ( infoDecl )* ( subAttrAssign )* ( portAssign )* ) );
    public final PhdlParser.instDecl_return instDecl() throws RecognitionException {
        PhdlParser.instDecl_return retval = new PhdlParser.instDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INST63=null;
        Token LPAREN64=null;
        Token RPAREN66=null;
        Token IDENT67=null;
        Token OF68=null;
        Token IDENT69=null;
        Token LBRACE70=null;
        Token RBRACE74=null;
        Token SUBINST75=null;
        Token LPAREN76=null;
        Token RPAREN78=null;
        Token IDENT79=null;
        Token STRING80=null;
        Token OF81=null;
        Token IDENT82=null;
        Token LBRACE83=null;
        Token RBRACE87=null;
        PhdlParser.width_return width65 = null;

        PhdlParser.infoDecl_return infoDecl71 = null;

        PhdlParser.attrAssign_return attrAssign72 = null;

        PhdlParser.pinAssign_return pinAssign73 = null;

        PhdlParser.width_return width77 = null;

        PhdlParser.infoDecl_return infoDecl84 = null;

        PhdlParser.subAttrAssign_return subAttrAssign85 = null;

        PhdlParser.portAssign_return portAssign86 = null;


        CommonTree INST63_tree=null;
        CommonTree LPAREN64_tree=null;
        CommonTree RPAREN66_tree=null;
        CommonTree IDENT67_tree=null;
        CommonTree OF68_tree=null;
        CommonTree IDENT69_tree=null;
        CommonTree LBRACE70_tree=null;
        CommonTree RBRACE74_tree=null;
        CommonTree SUBINST75_tree=null;
        CommonTree LPAREN76_tree=null;
        CommonTree RPAREN78_tree=null;
        CommonTree IDENT79_tree=null;
        CommonTree STRING80_tree=null;
        CommonTree OF81_tree=null;
        CommonTree IDENT82_tree=null;
        CommonTree LBRACE83_tree=null;
        CommonTree RBRACE87_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_SUBINST=new RewriteRuleTokenStream(adaptor,"token SUBINST");
        RewriteRuleTokenStream stream_OF=new RewriteRuleTokenStream(adaptor,"token OF");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleTokenStream stream_INST=new RewriteRuleTokenStream(adaptor,"token INST");
        RewriteRuleSubtreeStream stream_width=new RewriteRuleSubtreeStream(adaptor,"rule width");
        RewriteRuleSubtreeStream stream_subAttrAssign=new RewriteRuleSubtreeStream(adaptor,"rule subAttrAssign");
        RewriteRuleSubtreeStream stream_infoDecl=new RewriteRuleSubtreeStream(adaptor,"rule infoDecl");
        RewriteRuleSubtreeStream stream_portAssign=new RewriteRuleSubtreeStream(adaptor,"rule portAssign");
        RewriteRuleSubtreeStream stream_attrAssign=new RewriteRuleSubtreeStream(adaptor,"rule attrAssign");
        RewriteRuleSubtreeStream stream_pinAssign=new RewriteRuleSubtreeStream(adaptor,"rule pinAssign");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:350:2: ( INST ( LPAREN width RPAREN )? IDENT OF IDENT LBRACE ( infoDecl | attrAssign | pinAssign )* RBRACE -> ^( INST_DECL ( width )? IDENT IDENT ( infoDecl )* ( attrAssign )* ( pinAssign )* ) | SUBINST ( LPAREN width RPAREN )? IDENT ( STRING )? OF IDENT LBRACE ( infoDecl | subAttrAssign | portAssign )* RBRACE -> ^( SUBINST_DECL ( width )? IDENT ( STRING )? IDENT ( infoDecl )* ( subAttrAssign )* ( portAssign )* ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==INST) ) {
                alt21=1;
            }
            else if ( (LA21_0==SUBINST) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:350:4: INST ( LPAREN width RPAREN )? IDENT OF IDENT LBRACE ( infoDecl | attrAssign | pinAssign )* RBRACE
                    {
                    INST63=(Token)match(input,INST,FOLLOW_INST_in_instDecl829); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INST.add(INST63);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:350:9: ( LPAREN width RPAREN )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==LPAREN) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:350:10: LPAREN width RPAREN
                            {
                            LPAREN64=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_instDecl832); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN64);

                            pushFollow(FOLLOW_width_in_instDecl834);
                            width65=width();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_width.add(width65.getTree());
                            RPAREN66=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_instDecl836); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN66);


                            }
                            break;

                    }

                    IDENT67=(Token)match(input,IDENT,FOLLOW_IDENT_in_instDecl840); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT67);

                    OF68=(Token)match(input,OF,FOLLOW_OF_in_instDecl842); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OF.add(OF68);

                    IDENT69=(Token)match(input,IDENT,FOLLOW_IDENT_in_instDecl844); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT69);

                    LBRACE70=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_instDecl846); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE70);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:350:54: ( infoDecl | attrAssign | pinAssign )*
                    loop17:
                    do {
                        int alt17=4;
                        alt17 = dfa17.predict(input);
                        switch (alt17) {
                    	case 1 :
                    	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:350:55: infoDecl
                    	    {
                    	    pushFollow(FOLLOW_infoDecl_in_instDecl849);
                    	    infoDecl71=infoDecl();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_infoDecl.add(infoDecl71.getTree());

                    	    }
                    	    break;
                    	case 2 :
                    	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:350:66: attrAssign
                    	    {
                    	    pushFollow(FOLLOW_attrAssign_in_instDecl853);
                    	    attrAssign72=attrAssign();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_attrAssign.add(attrAssign72.getTree());

                    	    }
                    	    break;
                    	case 3 :
                    	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:350:79: pinAssign
                    	    {
                    	    pushFollow(FOLLOW_pinAssign_in_instDecl857);
                    	    pinAssign73=pinAssign();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_pinAssign.add(pinAssign73.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    RBRACE74=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_instDecl861); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE74);



                    // AST REWRITE
                    // elements: IDENT, IDENT, pinAssign, attrAssign, width, infoDecl
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 351:3: -> ^( INST_DECL ( width )? IDENT IDENT ( infoDecl )* ( attrAssign )* ( pinAssign )* )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:351:6: ^( INST_DECL ( width )? IDENT IDENT ( infoDecl )* ( attrAssign )* ( pinAssign )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INST_DECL, "INST_DECL"), root_1);

                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:351:18: ( width )?
                        if ( stream_width.hasNext() ) {
                            adaptor.addChild(root_1, stream_width.nextTree());

                        }
                        stream_width.reset();
                        adaptor.addChild(root_1, stream_IDENT.nextNode());
                        adaptor.addChild(root_1, stream_IDENT.nextNode());
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:351:37: ( infoDecl )*
                        while ( stream_infoDecl.hasNext() ) {
                            adaptor.addChild(root_1, stream_infoDecl.nextTree());

                        }
                        stream_infoDecl.reset();
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:351:47: ( attrAssign )*
                        while ( stream_attrAssign.hasNext() ) {
                            adaptor.addChild(root_1, stream_attrAssign.nextTree());

                        }
                        stream_attrAssign.reset();
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:351:59: ( pinAssign )*
                        while ( stream_pinAssign.hasNext() ) {
                            adaptor.addChild(root_1, stream_pinAssign.nextTree());

                        }
                        stream_pinAssign.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:353:4: SUBINST ( LPAREN width RPAREN )? IDENT ( STRING )? OF IDENT LBRACE ( infoDecl | subAttrAssign | portAssign )* RBRACE
                    {
                    SUBINST75=(Token)match(input,SUBINST,FOLLOW_SUBINST_in_instDecl893); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SUBINST.add(SUBINST75);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:353:12: ( LPAREN width RPAREN )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==LPAREN) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:353:13: LPAREN width RPAREN
                            {
                            LPAREN76=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_instDecl896); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN76);

                            pushFollow(FOLLOW_width_in_instDecl898);
                            width77=width();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_width.add(width77.getTree());
                            RPAREN78=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_instDecl900); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN78);


                            }
                            break;

                    }

                    IDENT79=(Token)match(input,IDENT,FOLLOW_IDENT_in_instDecl904); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT79);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:353:41: ( STRING )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==STRING) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:0:0: STRING
                            {
                            STRING80=(Token)match(input,STRING,FOLLOW_STRING_in_instDecl906); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_STRING.add(STRING80);


                            }
                            break;

                    }

                    OF81=(Token)match(input,OF,FOLLOW_OF_in_instDecl909); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OF.add(OF81);

                    IDENT82=(Token)match(input,IDENT,FOLLOW_IDENT_in_instDecl911); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT82);

                    LBRACE83=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_instDecl913); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE83);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:353:65: ( infoDecl | subAttrAssign | portAssign )*
                    loop20:
                    do {
                        int alt20=4;
                        alt20 = dfa20.predict(input);
                        switch (alt20) {
                    	case 1 :
                    	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:353:66: infoDecl
                    	    {
                    	    pushFollow(FOLLOW_infoDecl_in_instDecl916);
                    	    infoDecl84=infoDecl();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_infoDecl.add(infoDecl84.getTree());

                    	    }
                    	    break;
                    	case 2 :
                    	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:353:77: subAttrAssign
                    	    {
                    	    pushFollow(FOLLOW_subAttrAssign_in_instDecl920);
                    	    subAttrAssign85=subAttrAssign();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_subAttrAssign.add(subAttrAssign85.getTree());

                    	    }
                    	    break;
                    	case 3 :
                    	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:353:93: portAssign
                    	    {
                    	    pushFollow(FOLLOW_portAssign_in_instDecl924);
                    	    portAssign86=portAssign();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_portAssign.add(portAssign86.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    RBRACE87=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_instDecl928); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE87);



                    // AST REWRITE
                    // elements: width, subAttrAssign, portAssign, IDENT, infoDecl, IDENT, STRING
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 354:3: -> ^( SUBINST_DECL ( width )? IDENT ( STRING )? IDENT ( infoDecl )* ( subAttrAssign )* ( portAssign )* )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:354:6: ^( SUBINST_DECL ( width )? IDENT ( STRING )? IDENT ( infoDecl )* ( subAttrAssign )* ( portAssign )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SUBINST_DECL, "SUBINST_DECL"), root_1);

                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:354:21: ( width )?
                        if ( stream_width.hasNext() ) {
                            adaptor.addChild(root_1, stream_width.nextTree());

                        }
                        stream_width.reset();
                        adaptor.addChild(root_1, stream_IDENT.nextNode());
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:354:34: ( STRING )?
                        if ( stream_STRING.hasNext() ) {
                            adaptor.addChild(root_1, stream_STRING.nextNode());

                        }
                        stream_STRING.reset();
                        adaptor.addChild(root_1, stream_IDENT.nextNode());
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:354:48: ( infoDecl )*
                        while ( stream_infoDecl.hasNext() ) {
                            adaptor.addChild(root_1, stream_infoDecl.nextTree());

                        }
                        stream_infoDecl.reset();
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:354:58: ( subAttrAssign )*
                        while ( stream_subAttrAssign.hasNext() ) {
                            adaptor.addChild(root_1, stream_subAttrAssign.nextTree());

                        }
                        stream_subAttrAssign.reset();
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:354:73: ( portAssign )*
                        while ( stream_portAssign.hasNext() ) {
                            adaptor.addChild(root_1, stream_portAssign.nextTree());

                        }
                        stream_portAssign.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "instDecl"

    public static class attrAssign_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attrAssign"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:357:1: attrAssign : ( NEWATTR )? ( qualifier )? IDENT EQUALS STRING SEMICOLON -> ^( ATTR_ASSIGN ( NEWATTR )? ( qualifier )? IDENT STRING ) ;
    public final PhdlParser.attrAssign_return attrAssign() throws RecognitionException {
        PhdlParser.attrAssign_return retval = new PhdlParser.attrAssign_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NEWATTR88=null;
        Token IDENT90=null;
        Token EQUALS91=null;
        Token STRING92=null;
        Token SEMICOLON93=null;
        PhdlParser.qualifier_return qualifier89 = null;


        CommonTree NEWATTR88_tree=null;
        CommonTree IDENT90_tree=null;
        CommonTree EQUALS91_tree=null;
        CommonTree STRING92_tree=null;
        CommonTree SEMICOLON93_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_NEWATTR=new RewriteRuleTokenStream(adaptor,"token NEWATTR");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_qualifier=new RewriteRuleSubtreeStream(adaptor,"rule qualifier");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:365:2: ( ( NEWATTR )? ( qualifier )? IDENT EQUALS STRING SEMICOLON -> ^( ATTR_ASSIGN ( NEWATTR )? ( qualifier )? IDENT STRING ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:365:4: ( NEWATTR )? ( qualifier )? IDENT EQUALS STRING SEMICOLON
            {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:365:4: ( NEWATTR )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==NEWATTR) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:0:0: NEWATTR
                    {
                    NEWATTR88=(Token)match(input,NEWATTR,FOLLOW_NEWATTR_in_attrAssign968); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NEWATTR.add(NEWATTR88);


                    }
                    break;

            }

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:365:13: ( qualifier )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==THIS) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:0:0: qualifier
                    {
                    pushFollow(FOLLOW_qualifier_in_attrAssign971);
                    qualifier89=qualifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_qualifier.add(qualifier89.getTree());

                    }
                    break;

            }

            IDENT90=(Token)match(input,IDENT,FOLLOW_IDENT_in_attrAssign974); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT90);

            EQUALS91=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attrAssign976); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS91);

            STRING92=(Token)match(input,STRING,FOLLOW_STRING_in_attrAssign978); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(STRING92);

            SEMICOLON93=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attrAssign980); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON93);



            // AST REWRITE
            // elements: NEWATTR, IDENT, qualifier, STRING
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 366:3: -> ^( ATTR_ASSIGN ( NEWATTR )? ( qualifier )? IDENT STRING )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:366:6: ^( ATTR_ASSIGN ( NEWATTR )? ( qualifier )? IDENT STRING )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ATTR_ASSIGN, "ATTR_ASSIGN"), root_1);

                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:366:20: ( NEWATTR )?
                if ( stream_NEWATTR.hasNext() ) {
                    adaptor.addChild(root_1, stream_NEWATTR.nextNode());

                }
                stream_NEWATTR.reset();
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:366:29: ( qualifier )?
                if ( stream_qualifier.hasNext() ) {
                    adaptor.addChild(root_1, stream_qualifier.nextTree());

                }
                stream_qualifier.reset();
                adaptor.addChild(root_1, stream_IDENT.nextNode());
                adaptor.addChild(root_1, stream_STRING.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attrAssign"

    public static class subAttrAssign_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subAttrAssign"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:369:1: subAttrAssign : ( NEWATTR )? ( qualifier )? ( name PERIOD )+ IDENT EQUALS STRING SEMICOLON -> ^( SUBATTR_ASSIGN ( NEWATTR )? ( qualifier )? ( name )+ IDENT STRING ) ;
    public final PhdlParser.subAttrAssign_return subAttrAssign() throws RecognitionException {
        PhdlParser.subAttrAssign_return retval = new PhdlParser.subAttrAssign_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NEWATTR94=null;
        Token PERIOD97=null;
        Token IDENT98=null;
        Token EQUALS99=null;
        Token STRING100=null;
        Token SEMICOLON101=null;
        PhdlParser.qualifier_return qualifier95 = null;

        PhdlParser.name_return name96 = null;


        CommonTree NEWATTR94_tree=null;
        CommonTree PERIOD97_tree=null;
        CommonTree IDENT98_tree=null;
        CommonTree EQUALS99_tree=null;
        CommonTree STRING100_tree=null;
        CommonTree SEMICOLON101_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_NEWATTR=new RewriteRuleTokenStream(adaptor,"token NEWATTR");
        RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_name=new RewriteRuleSubtreeStream(adaptor,"rule name");
        RewriteRuleSubtreeStream stream_qualifier=new RewriteRuleSubtreeStream(adaptor,"rule qualifier");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:377:2: ( ( NEWATTR )? ( qualifier )? ( name PERIOD )+ IDENT EQUALS STRING SEMICOLON -> ^( SUBATTR_ASSIGN ( NEWATTR )? ( qualifier )? ( name )+ IDENT STRING ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:377:4: ( NEWATTR )? ( qualifier )? ( name PERIOD )+ IDENT EQUALS STRING SEMICOLON
            {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:377:4: ( NEWATTR )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==NEWATTR) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:0:0: NEWATTR
                    {
                    NEWATTR94=(Token)match(input,NEWATTR,FOLLOW_NEWATTR_in_subAttrAssign1013); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NEWATTR.add(NEWATTR94);


                    }
                    break;

            }

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:377:13: ( qualifier )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==THIS) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:0:0: qualifier
                    {
                    pushFollow(FOLLOW_qualifier_in_subAttrAssign1016);
                    qualifier95=qualifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_qualifier.add(qualifier95.getTree());

                    }
                    break;

            }

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:377:24: ( name PERIOD )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==IDENT) ) {
                    int LA26_1 = input.LA(2);

                    if ( (LA26_1==PERIOD||LA26_1==LPAREN) ) {
                        alt26=1;
                    }


                }


                switch (alt26) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:377:25: name PERIOD
            	    {
            	    pushFollow(FOLLOW_name_in_subAttrAssign1020);
            	    name96=name();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_name.add(name96.getTree());
            	    PERIOD97=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_subAttrAssign1022); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD97);


            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);

            IDENT98=(Token)match(input,IDENT,FOLLOW_IDENT_in_subAttrAssign1026); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT98);

            EQUALS99=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_subAttrAssign1028); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS99);

            STRING100=(Token)match(input,STRING,FOLLOW_STRING_in_subAttrAssign1030); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(STRING100);

            SEMICOLON101=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_subAttrAssign1032); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON101);



            // AST REWRITE
            // elements: IDENT, qualifier, NEWATTR, STRING, name
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 378:3: -> ^( SUBATTR_ASSIGN ( NEWATTR )? ( qualifier )? ( name )+ IDENT STRING )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:378:6: ^( SUBATTR_ASSIGN ( NEWATTR )? ( qualifier )? ( name )+ IDENT STRING )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SUBATTR_ASSIGN, "SUBATTR_ASSIGN"), root_1);

                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:378:23: ( NEWATTR )?
                if ( stream_NEWATTR.hasNext() ) {
                    adaptor.addChild(root_1, stream_NEWATTR.nextNode());

                }
                stream_NEWATTR.reset();
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:378:32: ( qualifier )?
                if ( stream_qualifier.hasNext() ) {
                    adaptor.addChild(root_1, stream_qualifier.nextTree());

                }
                stream_qualifier.reset();
                if ( !(stream_name.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_name.hasNext() ) {
                    adaptor.addChild(root_1, stream_name.nextTree());

                }
                stream_name.reset();
                adaptor.addChild(root_1, stream_IDENT.nextNode());
                adaptor.addChild(root_1, stream_STRING.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "subAttrAssign"

    public static class pinAssign_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pinAssign"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:381:1: pinAssign : ( ( COMBINE LPAREN ( qualifier )? operand RPAREN ) | ( ( qualifier )? operand ) ) EQUALS concat SEMICOLON -> ^( PIN_ASSIGN ( COMBINE )? ( qualifier )? operand concat ) ;
    public final PhdlParser.pinAssign_return pinAssign() throws RecognitionException {
        PhdlParser.pinAssign_return retval = new PhdlParser.pinAssign_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMBINE102=null;
        Token LPAREN103=null;
        Token RPAREN106=null;
        Token EQUALS109=null;
        Token SEMICOLON111=null;
        PhdlParser.qualifier_return qualifier104 = null;

        PhdlParser.operand_return operand105 = null;

        PhdlParser.qualifier_return qualifier107 = null;

        PhdlParser.operand_return operand108 = null;

        PhdlParser.concat_return concat110 = null;


        CommonTree COMBINE102_tree=null;
        CommonTree LPAREN103_tree=null;
        CommonTree RPAREN106_tree=null;
        CommonTree EQUALS109_tree=null;
        CommonTree SEMICOLON111_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_COMBINE=new RewriteRuleTokenStream(adaptor,"token COMBINE");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_qualifier=new RewriteRuleSubtreeStream(adaptor,"rule qualifier");
        RewriteRuleSubtreeStream stream_operand=new RewriteRuleSubtreeStream(adaptor,"rule operand");
        RewriteRuleSubtreeStream stream_concat=new RewriteRuleSubtreeStream(adaptor,"rule concat");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:382:2: ( ( ( COMBINE LPAREN ( qualifier )? operand RPAREN ) | ( ( qualifier )? operand ) ) EQUALS concat SEMICOLON -> ^( PIN_ASSIGN ( COMBINE )? ( qualifier )? operand concat ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:382:4: ( ( COMBINE LPAREN ( qualifier )? operand RPAREN ) | ( ( qualifier )? operand ) ) EQUALS concat SEMICOLON
            {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:382:4: ( ( COMBINE LPAREN ( qualifier )? operand RPAREN ) | ( ( qualifier )? operand ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==COMBINE) ) {
                alt29=1;
            }
            else if ( (LA29_0==THIS||LA29_0==IDENT) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:382:5: ( COMBINE LPAREN ( qualifier )? operand RPAREN )
                    {
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:382:5: ( COMBINE LPAREN ( qualifier )? operand RPAREN )
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:382:6: COMBINE LPAREN ( qualifier )? operand RPAREN
                    {
                    COMBINE102=(Token)match(input,COMBINE,FOLLOW_COMBINE_in_pinAssign1066); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COMBINE.add(COMBINE102);

                    LPAREN103=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_pinAssign1068); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN103);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:382:21: ( qualifier )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==THIS) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:0:0: qualifier
                            {
                            pushFollow(FOLLOW_qualifier_in_pinAssign1070);
                            qualifier104=qualifier();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_qualifier.add(qualifier104.getTree());

                            }
                            break;

                    }

                    pushFollow(FOLLOW_operand_in_pinAssign1073);
                    operand105=operand();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_operand.add(operand105.getTree());
                    RPAREN106=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_pinAssign1075); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN106);


                    }


                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:382:50: ( ( qualifier )? operand )
                    {
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:382:50: ( ( qualifier )? operand )
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:382:51: ( qualifier )? operand
                    {
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:382:51: ( qualifier )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==THIS) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:0:0: qualifier
                            {
                            pushFollow(FOLLOW_qualifier_in_pinAssign1081);
                            qualifier107=qualifier();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_qualifier.add(qualifier107.getTree());

                            }
                            break;

                    }

                    pushFollow(FOLLOW_operand_in_pinAssign1084);
                    operand108=operand();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_operand.add(operand108.getTree());

                    }


                    }
                    break;

            }

            EQUALS109=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinAssign1088); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS109);

            pushFollow(FOLLOW_concat_in_pinAssign1090);
            concat110=concat();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_concat.add(concat110.getTree());
            SEMICOLON111=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinAssign1092); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON111);



            // AST REWRITE
            // elements: operand, concat, qualifier, COMBINE
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 383:3: -> ^( PIN_ASSIGN ( COMBINE )? ( qualifier )? operand concat )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:383:6: ^( PIN_ASSIGN ( COMBINE )? ( qualifier )? operand concat )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PIN_ASSIGN, "PIN_ASSIGN"), root_1);

                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:383:19: ( COMBINE )?
                if ( stream_COMBINE.hasNext() ) {
                    adaptor.addChild(root_1, stream_COMBINE.nextNode());

                }
                stream_COMBINE.reset();
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:383:28: ( qualifier )?
                if ( stream_qualifier.hasNext() ) {
                    adaptor.addChild(root_1, stream_qualifier.nextTree());

                }
                stream_qualifier.reset();
                adaptor.addChild(root_1, stream_operand.nextTree());
                adaptor.addChild(root_1, stream_concat.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "pinAssign"

    public static class portAssign_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "portAssign"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:386:1: portAssign : ( ( COMBINE LPAREN ( qualifier )? operand RPAREN ) | ( ( qualifier )? operand ) ) EQUALS concat SEMICOLON -> ^( PORT_ASSIGN ( COMBINE )? ( qualifier )? operand concat ) ;
    public final PhdlParser.portAssign_return portAssign() throws RecognitionException {
        PhdlParser.portAssign_return retval = new PhdlParser.portAssign_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMBINE112=null;
        Token LPAREN113=null;
        Token RPAREN116=null;
        Token EQUALS119=null;
        Token SEMICOLON121=null;
        PhdlParser.qualifier_return qualifier114 = null;

        PhdlParser.operand_return operand115 = null;

        PhdlParser.qualifier_return qualifier117 = null;

        PhdlParser.operand_return operand118 = null;

        PhdlParser.concat_return concat120 = null;


        CommonTree COMBINE112_tree=null;
        CommonTree LPAREN113_tree=null;
        CommonTree RPAREN116_tree=null;
        CommonTree EQUALS119_tree=null;
        CommonTree SEMICOLON121_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_COMBINE=new RewriteRuleTokenStream(adaptor,"token COMBINE");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_qualifier=new RewriteRuleSubtreeStream(adaptor,"rule qualifier");
        RewriteRuleSubtreeStream stream_operand=new RewriteRuleSubtreeStream(adaptor,"rule operand");
        RewriteRuleSubtreeStream stream_concat=new RewriteRuleSubtreeStream(adaptor,"rule concat");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:387:2: ( ( ( COMBINE LPAREN ( qualifier )? operand RPAREN ) | ( ( qualifier )? operand ) ) EQUALS concat SEMICOLON -> ^( PORT_ASSIGN ( COMBINE )? ( qualifier )? operand concat ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:387:4: ( ( COMBINE LPAREN ( qualifier )? operand RPAREN ) | ( ( qualifier )? operand ) ) EQUALS concat SEMICOLON
            {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:387:4: ( ( COMBINE LPAREN ( qualifier )? operand RPAREN ) | ( ( qualifier )? operand ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==COMBINE) ) {
                alt32=1;
            }
            else if ( (LA32_0==THIS||LA32_0==IDENT) ) {
                alt32=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:387:5: ( COMBINE LPAREN ( qualifier )? operand RPAREN )
                    {
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:387:5: ( COMBINE LPAREN ( qualifier )? operand RPAREN )
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:387:6: COMBINE LPAREN ( qualifier )? operand RPAREN
                    {
                    COMBINE112=(Token)match(input,COMBINE,FOLLOW_COMBINE_in_portAssign1125); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COMBINE.add(COMBINE112);

                    LPAREN113=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_portAssign1127); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN113);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:387:21: ( qualifier )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==THIS) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:0:0: qualifier
                            {
                            pushFollow(FOLLOW_qualifier_in_portAssign1129);
                            qualifier114=qualifier();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_qualifier.add(qualifier114.getTree());

                            }
                            break;

                    }

                    pushFollow(FOLLOW_operand_in_portAssign1132);
                    operand115=operand();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_operand.add(operand115.getTree());
                    RPAREN116=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_portAssign1134); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN116);


                    }


                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:387:50: ( ( qualifier )? operand )
                    {
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:387:50: ( ( qualifier )? operand )
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:387:51: ( qualifier )? operand
                    {
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:387:51: ( qualifier )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==THIS) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:0:0: qualifier
                            {
                            pushFollow(FOLLOW_qualifier_in_portAssign1140);
                            qualifier117=qualifier();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_qualifier.add(qualifier117.getTree());

                            }
                            break;

                    }

                    pushFollow(FOLLOW_operand_in_portAssign1143);
                    operand118=operand();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_operand.add(operand118.getTree());

                    }


                    }
                    break;

            }

            EQUALS119=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_portAssign1147); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS119);

            pushFollow(FOLLOW_concat_in_portAssign1149);
            concat120=concat();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_concat.add(concat120.getTree());
            SEMICOLON121=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_portAssign1151); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON121);



            // AST REWRITE
            // elements: concat, COMBINE, operand, qualifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 388:3: -> ^( PORT_ASSIGN ( COMBINE )? ( qualifier )? operand concat )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:388:6: ^( PORT_ASSIGN ( COMBINE )? ( qualifier )? operand concat )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PORT_ASSIGN, "PORT_ASSIGN"), root_1);

                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:388:20: ( COMBINE )?
                if ( stream_COMBINE.hasNext() ) {
                    adaptor.addChild(root_1, stream_COMBINE.nextNode());

                }
                stream_COMBINE.reset();
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:388:29: ( qualifier )?
                if ( stream_qualifier.hasNext() ) {
                    adaptor.addChild(root_1, stream_qualifier.nextTree());

                }
                stream_qualifier.reset();
                adaptor.addChild(root_1, stream_operand.nextTree());
                adaptor.addChild(root_1, stream_concat.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "portAssign"

    public static class connectAssign_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "connectAssign"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:391:1: connectAssign : operand EQUALS concat SEMICOLON -> ^( CONNECT_ASSIGN operand concat ) ;
    public final PhdlParser.connectAssign_return connectAssign() throws RecognitionException {
        PhdlParser.connectAssign_return retval = new PhdlParser.connectAssign_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQUALS123=null;
        Token SEMICOLON125=null;
        PhdlParser.operand_return operand122 = null;

        PhdlParser.concat_return concat124 = null;


        CommonTree EQUALS123_tree=null;
        CommonTree SEMICOLON125_tree=null;
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleSubtreeStream stream_operand=new RewriteRuleSubtreeStream(adaptor,"rule operand");
        RewriteRuleSubtreeStream stream_concat=new RewriteRuleSubtreeStream(adaptor,"rule concat");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:397:2: ( operand EQUALS concat SEMICOLON -> ^( CONNECT_ASSIGN operand concat ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:397:4: operand EQUALS concat SEMICOLON
            {
            pushFollow(FOLLOW_operand_in_connectAssign1184);
            operand122=operand();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_operand.add(operand122.getTree());
            EQUALS123=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_connectAssign1186); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS123);

            pushFollow(FOLLOW_concat_in_connectAssign1188);
            concat124=concat();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_concat.add(concat124.getTree());
            SEMICOLON125=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_connectAssign1190); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON125);



            // AST REWRITE
            // elements: concat, operand
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 397:36: -> ^( CONNECT_ASSIGN operand concat )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:397:39: ^( CONNECT_ASSIGN operand concat )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONNECT_ASSIGN, "CONNECT_ASSIGN"), root_1);

                adaptor.addChild(root_1, stream_operand.nextTree());
                adaptor.addChild(root_1, stream_concat.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "connectAssign"

    public static class groupDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "groupDecl"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:400:1: groupDecl : GROUP STRING LBRACE ( groupBody )* RBRACE -> ^( GROUP_DECL STRING ( groupBody )* ) ;
    public final PhdlParser.groupDecl_return groupDecl() throws RecognitionException {
        PhdlParser.groupDecl_return retval = new PhdlParser.groupDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token GROUP126=null;
        Token STRING127=null;
        Token LBRACE128=null;
        Token RBRACE130=null;
        PhdlParser.groupBody_return groupBody129 = null;


        CommonTree GROUP126_tree=null;
        CommonTree STRING127_tree=null;
        CommonTree LBRACE128_tree=null;
        CommonTree RBRACE130_tree=null;
        RewriteRuleTokenStream stream_GROUP=new RewriteRuleTokenStream(adaptor,"token GROUP");
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_groupBody=new RewriteRuleSubtreeStream(adaptor,"rule groupBody");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:407:2: ( GROUP STRING LBRACE ( groupBody )* RBRACE -> ^( GROUP_DECL STRING ( groupBody )* ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:407:5: GROUP STRING LBRACE ( groupBody )* RBRACE
            {
            GROUP126=(Token)match(input,GROUP,FOLLOW_GROUP_in_groupDecl1215); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_GROUP.add(GROUP126);

            STRING127=(Token)match(input,STRING,FOLLOW_STRING_in_groupDecl1217); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(STRING127);

            LBRACE128=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_groupDecl1219); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE128);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:407:25: ( groupBody )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=INST && LA33_0<=SUBINST)||LA33_0==THIS||LA33_0==NET||(LA33_0>=INFO && LA33_0<=PORT)||LA33_0==IDENT) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:0:0: groupBody
            	    {
            	    pushFollow(FOLLOW_groupBody_in_groupDecl1221);
            	    groupBody129=groupBody();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_groupBody.add(groupBody129.getTree());

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            RBRACE130=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_groupDecl1224); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE130);



            // AST REWRITE
            // elements: STRING, groupBody
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 407:43: -> ^( GROUP_DECL STRING ( groupBody )* )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:407:46: ^( GROUP_DECL STRING ( groupBody )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(GROUP_DECL, "GROUP_DECL"), root_1);

                adaptor.addChild(root_1, stream_STRING.nextNode());
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:407:66: ( groupBody )*
                while ( stream_groupBody.hasNext() ) {
                    adaptor.addChild(root_1, stream_groupBody.nextTree());

                }
                stream_groupBody.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "groupDecl"

    public static class groupBody_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "groupBody"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:410:1: groupBody : ( infoDecl | connectDecl | instDecl | connectAssign );
    public final PhdlParser.groupBody_return groupBody() throws RecognitionException {
        PhdlParser.groupBody_return retval = new PhdlParser.groupBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        PhdlParser.infoDecl_return infoDecl131 = null;

        PhdlParser.connectDecl_return connectDecl132 = null;

        PhdlParser.instDecl_return instDecl133 = null;

        PhdlParser.connectAssign_return connectAssign134 = null;



        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:416:2: ( infoDecl | connectDecl | instDecl | connectAssign )
            int alt34=4;
            switch ( input.LA(1) ) {
            case THIS:
            case INFO:
                {
                alt34=1;
                }
                break;
            case NET:
            case PORT:
                {
                alt34=2;
                }
                break;
            case INST:
            case SUBINST:
                {
                alt34=3;
                }
                break;
            case IDENT:
                {
                alt34=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:416:4: infoDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_infoDecl_in_groupBody1249);
                    infoDecl131=infoDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, infoDecl131.getTree());

                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:417:4: connectDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_connectDecl_in_groupBody1254);
                    connectDecl132=connectDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, connectDecl132.getTree());

                    }
                    break;
                case 3 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:418:4: instDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_instDecl_in_groupBody1259);
                    instDecl133=instDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, instDecl133.getTree());

                    }
                    break;
                case 4 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:419:4: connectAssign
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_connectAssign_in_groupBody1264);
                    connectAssign134=connectAssign();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, connectAssign134.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "groupBody"

    public static class width_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "width"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:422:1: width : INT COLON INT -> ^( WIDTH INT INT ) ;
    public final PhdlParser.width_return width() throws RecognitionException {
        PhdlParser.width_return retval = new PhdlParser.width_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INT135=null;
        Token COLON136=null;
        Token INT137=null;

        CommonTree INT135_tree=null;
        CommonTree COLON136_tree=null;
        CommonTree INT137_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:429:2: ( INT COLON INT -> ^( WIDTH INT INT ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:429:4: INT COLON INT
            {
            INT135=(Token)match(input,INT,FOLLOW_INT_in_width1277); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INT.add(INT135);

            COLON136=(Token)match(input,COLON,FOLLOW_COLON_in_width1279); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON136);

            INT137=(Token)match(input,INT,FOLLOW_INT_in_width1281); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INT.add(INT137);



            // AST REWRITE
            // elements: INT, INT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 429:18: -> ^( WIDTH INT INT )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:429:21: ^( WIDTH INT INT )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(WIDTH, "WIDTH"), root_1);

                adaptor.addChild(root_1, stream_INT.nextNode());
                adaptor.addChild(root_1, stream_INT.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "width"

    public static class pinType_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pinType"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:433:1: pinType : ( PIN -> ^( PIN_TYPE PIN ) | INPIN -> ^( PIN_TYPE INPIN ) | OUTPIN -> ^( PIN_TYPE OUTPIN ) | IOPIN -> ^( PIN_TYPE IOPIN ) | PWRPIN -> ^( PIN_TYPE PWRPIN ) | SUPPIN -> ^( PIN_TYPE SUPPIN ) ) ;
    public final PhdlParser.pinType_return pinType() throws RecognitionException {
        PhdlParser.pinType_return retval = new PhdlParser.pinType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PIN138=null;
        Token INPIN139=null;
        Token OUTPIN140=null;
        Token IOPIN141=null;
        Token PWRPIN142=null;
        Token SUPPIN143=null;

        CommonTree PIN138_tree=null;
        CommonTree INPIN139_tree=null;
        CommonTree OUTPIN140_tree=null;
        CommonTree IOPIN141_tree=null;
        CommonTree PWRPIN142_tree=null;
        CommonTree SUPPIN143_tree=null;
        RewriteRuleTokenStream stream_INPIN=new RewriteRuleTokenStream(adaptor,"token INPIN");
        RewriteRuleTokenStream stream_SUPPIN=new RewriteRuleTokenStream(adaptor,"token SUPPIN");
        RewriteRuleTokenStream stream_IOPIN=new RewriteRuleTokenStream(adaptor,"token IOPIN");
        RewriteRuleTokenStream stream_OUTPIN=new RewriteRuleTokenStream(adaptor,"token OUTPIN");
        RewriteRuleTokenStream stream_PIN=new RewriteRuleTokenStream(adaptor,"token PIN");
        RewriteRuleTokenStream stream_PWRPIN=new RewriteRuleTokenStream(adaptor,"token PWRPIN");

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:438:2: ( ( PIN -> ^( PIN_TYPE PIN ) | INPIN -> ^( PIN_TYPE INPIN ) | OUTPIN -> ^( PIN_TYPE OUTPIN ) | IOPIN -> ^( PIN_TYPE IOPIN ) | PWRPIN -> ^( PIN_TYPE PWRPIN ) | SUPPIN -> ^( PIN_TYPE SUPPIN ) ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:438:4: ( PIN -> ^( PIN_TYPE PIN ) | INPIN -> ^( PIN_TYPE INPIN ) | OUTPIN -> ^( PIN_TYPE OUTPIN ) | IOPIN -> ^( PIN_TYPE IOPIN ) | PWRPIN -> ^( PIN_TYPE PWRPIN ) | SUPPIN -> ^( PIN_TYPE SUPPIN ) )
            {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:438:4: ( PIN -> ^( PIN_TYPE PIN ) | INPIN -> ^( PIN_TYPE INPIN ) | OUTPIN -> ^( PIN_TYPE OUTPIN ) | IOPIN -> ^( PIN_TYPE IOPIN ) | PWRPIN -> ^( PIN_TYPE PWRPIN ) | SUPPIN -> ^( PIN_TYPE SUPPIN ) )
            int alt35=6;
            switch ( input.LA(1) ) {
            case PIN:
                {
                alt35=1;
                }
                break;
            case INPIN:
                {
                alt35=2;
                }
                break;
            case OUTPIN:
                {
                alt35=3;
                }
                break;
            case IOPIN:
                {
                alt35=4;
                }
                break;
            case PWRPIN:
                {
                alt35=5;
                }
                break;
            case SUPPIN:
                {
                alt35=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:438:5: PIN
                    {
                    PIN138=(Token)match(input,PIN,FOLLOW_PIN_in_pinType1307); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PIN.add(PIN138);



                    // AST REWRITE
                    // elements: PIN
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 438:9: -> ^( PIN_TYPE PIN )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:438:12: ^( PIN_TYPE PIN )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PIN_TYPE, "PIN_TYPE"), root_1);

                        adaptor.addChild(root_1, stream_PIN.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:439:4: INPIN
                    {
                    INPIN139=(Token)match(input,INPIN,FOLLOW_INPIN_in_pinType1320); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INPIN.add(INPIN139);



                    // AST REWRITE
                    // elements: INPIN
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 439:10: -> ^( PIN_TYPE INPIN )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:439:13: ^( PIN_TYPE INPIN )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PIN_TYPE, "PIN_TYPE"), root_1);

                        adaptor.addChild(root_1, stream_INPIN.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:440:4: OUTPIN
                    {
                    OUTPIN140=(Token)match(input,OUTPIN,FOLLOW_OUTPIN_in_pinType1333); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OUTPIN.add(OUTPIN140);



                    // AST REWRITE
                    // elements: OUTPIN
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 440:11: -> ^( PIN_TYPE OUTPIN )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:440:14: ^( PIN_TYPE OUTPIN )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PIN_TYPE, "PIN_TYPE"), root_1);

                        adaptor.addChild(root_1, stream_OUTPIN.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:441:4: IOPIN
                    {
                    IOPIN141=(Token)match(input,IOPIN,FOLLOW_IOPIN_in_pinType1346); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IOPIN.add(IOPIN141);



                    // AST REWRITE
                    // elements: IOPIN
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 441:10: -> ^( PIN_TYPE IOPIN )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:441:13: ^( PIN_TYPE IOPIN )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PIN_TYPE, "PIN_TYPE"), root_1);

                        adaptor.addChild(root_1, stream_IOPIN.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:442:4: PWRPIN
                    {
                    PWRPIN142=(Token)match(input,PWRPIN,FOLLOW_PWRPIN_in_pinType1359); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PWRPIN.add(PWRPIN142);



                    // AST REWRITE
                    // elements: PWRPIN
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 442:11: -> ^( PIN_TYPE PWRPIN )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:442:14: ^( PIN_TYPE PWRPIN )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PIN_TYPE, "PIN_TYPE"), root_1);

                        adaptor.addChild(root_1, stream_PWRPIN.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:443:4: SUPPIN
                    {
                    SUPPIN143=(Token)match(input,SUPPIN,FOLLOW_SUPPIN_in_pinType1372); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SUPPIN.add(SUPPIN143);



                    // AST REWRITE
                    // elements: SUPPIN
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 443:11: -> ^( PIN_TYPE SUPPIN )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:443:14: ^( PIN_TYPE SUPPIN )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PIN_TYPE, "PIN_TYPE"), root_1);

                        adaptor.addChild(root_1, stream_SUPPIN.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "pinType"

    public static class pinList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pinList"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:446:1: pinList : LBRACE pinNumber ( COMMA pinNumber )* RBRACE -> ^( PIN_LIST ( pinNumber )+ ) ;
    public final PhdlParser.pinList_return pinList() throws RecognitionException {
        PhdlParser.pinList_return retval = new PhdlParser.pinList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACE144=null;
        Token COMMA146=null;
        Token RBRACE148=null;
        PhdlParser.pinNumber_return pinNumber145 = null;

        PhdlParser.pinNumber_return pinNumber147 = null;


        CommonTree LBRACE144_tree=null;
        CommonTree COMMA146_tree=null;
        CommonTree RBRACE148_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_pinNumber=new RewriteRuleSubtreeStream(adaptor,"rule pinNumber");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:451:2: ( LBRACE pinNumber ( COMMA pinNumber )* RBRACE -> ^( PIN_LIST ( pinNumber )+ ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:451:5: LBRACE pinNumber ( COMMA pinNumber )* RBRACE
            {
            LBRACE144=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_pinList1395); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE144);

            pushFollow(FOLLOW_pinNumber_in_pinList1397);
            pinNumber145=pinNumber();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_pinNumber.add(pinNumber145.getTree());
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:451:22: ( COMMA pinNumber )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==COMMA) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:451:23: COMMA pinNumber
            	    {
            	    COMMA146=(Token)match(input,COMMA,FOLLOW_COMMA_in_pinList1400); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA146);

            	    pushFollow(FOLLOW_pinNumber_in_pinList1402);
            	    pinNumber147=pinNumber();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_pinNumber.add(pinNumber147.getTree());

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            RBRACE148=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_pinList1406); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE148);



            // AST REWRITE
            // elements: pinNumber
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 451:48: -> ^( PIN_LIST ( pinNumber )+ )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:451:51: ^( PIN_LIST ( pinNumber )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PIN_LIST, "PIN_LIST"), root_1);

                if ( !(stream_pinNumber.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_pinNumber.hasNext() ) {
                    adaptor.addChild(root_1, stream_pinNumber.nextTree());

                }
                stream_pinNumber.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "pinList"

    public static class pinNumber_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pinNumber"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:454:1: pinNumber : ( IDENT | INT | PINNUM );
    public final PhdlParser.pinNumber_return pinNumber() throws RecognitionException {
        PhdlParser.pinNumber_return retval = new PhdlParser.pinNumber_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set149=null;

        CommonTree set149_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:460:2: ( IDENT | INT | PINNUM )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set149=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||(input.LA(1)>=INT && input.LA(1)<=PINNUM) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set149));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "pinNumber"

    public static class qualifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "qualifier"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:463:1: qualifier : THIS ( LPAREN index RPAREN )? PERIOD -> ^( THIS ( index )? ) ;
    public final PhdlParser.qualifier_return qualifier() throws RecognitionException {
        PhdlParser.qualifier_return retval = new PhdlParser.qualifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token THIS150=null;
        Token LPAREN151=null;
        Token RPAREN153=null;
        Token PERIOD154=null;
        PhdlParser.index_return index152 = null;


        CommonTree THIS150_tree=null;
        CommonTree LPAREN151_tree=null;
        CommonTree RPAREN153_tree=null;
        CommonTree PERIOD154_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_THIS=new RewriteRuleTokenStream(adaptor,"token THIS");
        RewriteRuleSubtreeStream stream_index=new RewriteRuleSubtreeStream(adaptor,"rule index");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:469:2: ( THIS ( LPAREN index RPAREN )? PERIOD -> ^( THIS ( index )? ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:469:4: THIS ( LPAREN index RPAREN )? PERIOD
            {
            THIS150=(Token)match(input,THIS,FOLLOW_THIS_in_qualifier1451); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_THIS.add(THIS150);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:469:9: ( LPAREN index RPAREN )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==LPAREN) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:469:10: LPAREN index RPAREN
                    {
                    LPAREN151=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_qualifier1454); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN151);

                    pushFollow(FOLLOW_index_in_qualifier1456);
                    index152=index();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_index.add(index152.getTree());
                    RPAREN153=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_qualifier1458); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN153);


                    }
                    break;

            }

            PERIOD154=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_qualifier1462); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD154);



            // AST REWRITE
            // elements: index, THIS
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 469:39: -> ^( THIS ( index )? )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:469:42: ^( THIS ( index )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_THIS.nextNode(), root_1);

                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:469:49: ( index )?
                if ( stream_index.hasNext() ) {
                    adaptor.addChild(root_1, stream_index.nextTree());

                }
                stream_index.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "qualifier"

    public static class index_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "index"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:472:1: index : ( INT COLON INT -> ^( BOUNDS INT INT ) | INT ( COMMA INT ( COMMA INT )* )? -> ^( INDICES ( INT )+ ) );
    public final PhdlParser.index_return index() throws RecognitionException {
        PhdlParser.index_return retval = new PhdlParser.index_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INT155=null;
        Token COLON156=null;
        Token INT157=null;
        Token INT158=null;
        Token COMMA159=null;
        Token INT160=null;
        Token COMMA161=null;
        Token INT162=null;

        CommonTree INT155_tree=null;
        CommonTree COLON156_tree=null;
        CommonTree INT157_tree=null;
        CommonTree INT158_tree=null;
        CommonTree COMMA159_tree=null;
        CommonTree INT160_tree=null;
        CommonTree COMMA161_tree=null;
        CommonTree INT162_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:479:2: ( INT COLON INT -> ^( BOUNDS INT INT ) | INT ( COMMA INT ( COMMA INT )* )? -> ^( INDICES ( INT )+ ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==INT) ) {
                int LA40_1 = input.LA(2);

                if ( (LA40_1==COLON) ) {
                    alt40=1;
                }
                else if ( (LA40_1==COMMA||LA40_1==RPAREN||LA40_1==RBRACKET) ) {
                    alt40=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:479:4: INT COLON INT
                    {
                    INT155=(Token)match(input,INT,FOLLOW_INT_in_index1485); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT155);

                    COLON156=(Token)match(input,COLON,FOLLOW_COLON_in_index1487); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON156);

                    INT157=(Token)match(input,INT,FOLLOW_INT_in_index1489); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT157);



                    // AST REWRITE
                    // elements: INT, INT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 479:22: -> ^( BOUNDS INT INT )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:479:25: ^( BOUNDS INT INT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BOUNDS, "BOUNDS"), root_1);

                        adaptor.addChild(root_1, stream_INT.nextNode());
                        adaptor.addChild(root_1, stream_INT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:480:5: INT ( COMMA INT ( COMMA INT )* )?
                    {
                    INT158=(Token)match(input,INT,FOLLOW_INT_in_index1509); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT158);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:480:9: ( COMMA INT ( COMMA INT )* )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==COMMA) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:480:10: COMMA INT ( COMMA INT )*
                            {
                            COMMA159=(Token)match(input,COMMA,FOLLOW_COMMA_in_index1512); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_COMMA.add(COMMA159);

                            INT160=(Token)match(input,INT,FOLLOW_INT_in_index1514); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_INT.add(INT160);

                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:480:20: ( COMMA INT )*
                            loop38:
                            do {
                                int alt38=2;
                                int LA38_0 = input.LA(1);

                                if ( (LA38_0==COMMA) ) {
                                    alt38=1;
                                }


                                switch (alt38) {
                            	case 1 :
                            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:480:21: COMMA INT
                            	    {
                            	    COMMA161=(Token)match(input,COMMA,FOLLOW_COMMA_in_index1517); if (state.failed) return retval; 
                            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA161);

                            	    INT162=(Token)match(input,INT,FOLLOW_INT_in_index1519); if (state.failed) return retval; 
                            	    if ( state.backtracking==0 ) stream_INT.add(INT162);


                            	    }
                            	    break;

                            	default :
                            	    break loop38;
                                }
                            } while (true);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: INT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 480:35: -> ^( INDICES ( INT )+ )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:480:38: ^( INDICES ( INT )+ )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INDICES, "INDICES"), root_1);

                        if ( !(stream_INT.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_INT.hasNext() ) {
                            adaptor.addChild(root_1, stream_INT.nextNode());

                        }
                        stream_INT.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "index"

    public static class concat_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "concat"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:483:1: concat : ( operand ( AMPERSAND operand )* -> ^( CONCAT_LIST ( operand )+ ) | LANGLE operand RANGLE -> ^( CONCAT_REPL operand ) | OPEN -> ^( CONCAT_OPEN ) );
    public final PhdlParser.concat_return concat() throws RecognitionException {
        PhdlParser.concat_return retval = new PhdlParser.concat_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AMPERSAND164=null;
        Token LANGLE166=null;
        Token RANGLE168=null;
        Token OPEN169=null;
        PhdlParser.operand_return operand163 = null;

        PhdlParser.operand_return operand165 = null;

        PhdlParser.operand_return operand167 = null;


        CommonTree AMPERSAND164_tree=null;
        CommonTree LANGLE166_tree=null;
        CommonTree RANGLE168_tree=null;
        CommonTree OPEN169_tree=null;
        RewriteRuleTokenStream stream_OPEN=new RewriteRuleTokenStream(adaptor,"token OPEN");
        RewriteRuleTokenStream stream_AMPERSAND=new RewriteRuleTokenStream(adaptor,"token AMPERSAND");
        RewriteRuleTokenStream stream_RANGLE=new RewriteRuleTokenStream(adaptor,"token RANGLE");
        RewriteRuleTokenStream stream_LANGLE=new RewriteRuleTokenStream(adaptor,"token LANGLE");
        RewriteRuleSubtreeStream stream_operand=new RewriteRuleSubtreeStream(adaptor,"rule operand");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:490:2: ( operand ( AMPERSAND operand )* -> ^( CONCAT_LIST ( operand )+ ) | LANGLE operand RANGLE -> ^( CONCAT_REPL operand ) | OPEN -> ^( CONCAT_OPEN ) )
            int alt42=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt42=1;
                }
                break;
            case LANGLE:
                {
                alt42=2;
                }
                break;
            case OPEN:
                {
                alt42=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:490:4: operand ( AMPERSAND operand )*
                    {
                    pushFollow(FOLLOW_operand_in_concat1546);
                    operand163=operand();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_operand.add(operand163.getTree());
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:490:12: ( AMPERSAND operand )*
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==AMPERSAND) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:490:13: AMPERSAND operand
                    	    {
                    	    AMPERSAND164=(Token)match(input,AMPERSAND,FOLLOW_AMPERSAND_in_concat1549); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_AMPERSAND.add(AMPERSAND164);

                    	    pushFollow(FOLLOW_operand_in_concat1551);
                    	    operand165=operand();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_operand.add(operand165.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop41;
                        }
                    } while (true);



                    // AST REWRITE
                    // elements: operand
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 490:34: -> ^( CONCAT_LIST ( operand )+ )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:490:37: ^( CONCAT_LIST ( operand )+ )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONCAT_LIST, "CONCAT_LIST"), root_1);

                        if ( !(stream_operand.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_operand.hasNext() ) {
                            adaptor.addChild(root_1, stream_operand.nextTree());

                        }
                        stream_operand.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:491:4: LANGLE operand RANGLE
                    {
                    LANGLE166=(Token)match(input,LANGLE,FOLLOW_LANGLE_in_concat1569); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LANGLE.add(LANGLE166);

                    pushFollow(FOLLOW_operand_in_concat1571);
                    operand167=operand();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_operand.add(operand167.getTree());
                    RANGLE168=(Token)match(input,RANGLE,FOLLOW_RANGLE_in_concat1573); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RANGLE.add(RANGLE168);



                    // AST REWRITE
                    // elements: operand
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 491:28: -> ^( CONCAT_REPL operand )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:491:31: ^( CONCAT_REPL operand )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONCAT_REPL, "CONCAT_REPL"), root_1);

                        adaptor.addChild(root_1, stream_operand.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:492:5: OPEN
                    {
                    OPEN169=(Token)match(input,OPEN,FOLLOW_OPEN_in_concat1589); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN.add(OPEN169);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 492:16: -> ^( CONCAT_OPEN )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:492:19: ^( CONCAT_OPEN )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONCAT_OPEN, "CONCAT_OPEN"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "concat"

    public static class operand_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "operand"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:495:1: operand : IDENT ( LBRACKET index RBRACKET )? -> ^( OPERAND IDENT ( index )? ) ;
    public final PhdlParser.operand_return operand() throws RecognitionException {
        PhdlParser.operand_return retval = new PhdlParser.operand_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT170=null;
        Token LBRACKET171=null;
        Token RBRACKET173=null;
        PhdlParser.index_return index172 = null;


        CommonTree IDENT170_tree=null;
        CommonTree LBRACKET171_tree=null;
        CommonTree RBRACKET173_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleSubtreeStream stream_index=new RewriteRuleSubtreeStream(adaptor,"rule index");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:501:2: ( IDENT ( LBRACKET index RBRACKET )? -> ^( OPERAND IDENT ( index )? ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:501:4: IDENT ( LBRACKET index RBRACKET )?
            {
            IDENT170=(Token)match(input,IDENT,FOLLOW_IDENT_in_operand1614); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT170);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:501:10: ( LBRACKET index RBRACKET )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==LBRACKET) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:501:11: LBRACKET index RBRACKET
                    {
                    LBRACKET171=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_operand1617); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET171);

                    pushFollow(FOLLOW_index_in_operand1619);
                    index172=index();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_index.add(index172.getTree());
                    RBRACKET173=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_operand1621); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET173);


                    }
                    break;

            }



            // AST REWRITE
            // elements: IDENT, index
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 501:37: -> ^( OPERAND IDENT ( index )? )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:501:40: ^( OPERAND IDENT ( index )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPERAND, "OPERAND"), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:501:56: ( index )?
                if ( stream_index.hasNext() ) {
                    adaptor.addChild(root_1, stream_index.nextTree());

                }
                stream_index.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "operand"

    public static class name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "name"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:504:1: name : IDENT ( LPAREN index RPAREN )? -> ^( NAME IDENT ( index )? ) ;
    public final PhdlParser.name_return name() throws RecognitionException {
        PhdlParser.name_return retval = new PhdlParser.name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT174=null;
        Token LPAREN175=null;
        Token RPAREN177=null;
        PhdlParser.index_return index176 = null;


        CommonTree IDENT174_tree=null;
        CommonTree LPAREN175_tree=null;
        CommonTree RPAREN177_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_index=new RewriteRuleSubtreeStream(adaptor,"rule index");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:510:2: ( IDENT ( LPAREN index RPAREN )? -> ^( NAME IDENT ( index )? ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:510:4: IDENT ( LPAREN index RPAREN )?
            {
            IDENT174=(Token)match(input,IDENT,FOLLOW_IDENT_in_name1648); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT174);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:510:10: ( LPAREN index RPAREN )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==LPAREN) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:510:11: LPAREN index RPAREN
                    {
                    LPAREN175=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_name1651); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN175);

                    pushFollow(FOLLOW_index_in_name1653);
                    index176=index();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_index.add(index176.getTree());
                    RPAREN177=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_name1655); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN177);


                    }
                    break;

            }



            // AST REWRITE
            // elements: IDENT, index
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 510:33: -> ^( NAME IDENT ( index )? )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:510:36: ^( NAME IDENT ( index )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAME, "NAME"), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:510:49: ( index )?
                if ( stream_index.hasNext() ) {
                    adaptor.addChild(root_1, stream_index.nextTree());

                }
                stream_index.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "name"

    // Delegated rules


    protected DFA17 dfa17 = new DFA17(this);
    protected DFA20 dfa20 = new DFA20(this);
    static final String DFA17_eotS =
        "\22\uffff";
    static final String DFA17_eofS =
        "\22\uffff";
    static final String DFA17_minS =
        "\1\16\1\uffff\1\7\2\uffff\1\10\1\uffff\1\107\1\42\1\17\1\5\2\107"+
        "\1\7\1\12\1\6\1\107\1\6";
    static final String DFA17_maxS =
        "\1\105\1\uffff\1\11\2\uffff\1\13\1\uffff\1\107\1\105\1\106\1\12"+
        "\2\107\1\7\2\12\1\107\1\12";
    static final String DFA17_acceptS =
        "\1\uffff\1\4\1\uffff\1\1\1\2\1\uffff\1\3\13\uffff";
    static final String DFA17_specialS =
        "\22\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\1\12\uffff\1\2\3\uffff\1\4\2\uffff\1\6\1\uffff\1\3\42\uffff"+
            "\1\5",
            "",
            "\1\10\1\uffff\1\7",
            "",
            "",
            "\1\11\2\uffff\1\6",
            "",
            "\1\12",
            "\1\3\42\uffff\1\5",
            "\1\6\24\uffff\1\6\40\uffff\1\6\1\4",
            "\1\13\1\14\3\uffff\1\15",
            "\1\16",
            "\1\17",
            "\1\10",
            "\1\15",
            "\1\20\3\uffff\1\15",
            "\1\21",
            "\1\20\3\uffff\1\15"
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "()* loopback of 350:54: ( infoDecl | attrAssign | pinAssign )*";
        }
    }
    static final String DFA20_eotS =
        "\21\uffff";
    static final String DFA20_eofS =
        "\21\uffff";
    static final String DFA20_minS =
        "\1\16\1\uffff\1\7\2\uffff\1\7\1\uffff\1\107\1\42\1\5\2\107\1\7\1"+
        "\12\1\6\1\107\1\6";
    static final String DFA20_maxS =
        "\1\105\1\uffff\1\11\2\uffff\1\13\1\uffff\1\107\1\105\1\12\2\107"+
        "\1\7\2\12\1\107\1\12";
    static final String DFA20_acceptS =
        "\1\uffff\1\4\1\uffff\1\1\1\2\1\uffff\1\3\12\uffff";
    static final String DFA20_specialS =
        "\21\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\1\12\uffff\1\2\3\uffff\1\4\2\uffff\1\6\1\uffff\1\3\42\uffff"+
            "\1\5",
            "",
            "\1\10\1\uffff\1\7",
            "",
            "",
            "\1\4\1\6\1\4\1\uffff\1\6",
            "",
            "\1\11",
            "\1\3\42\uffff\1\5",
            "\1\12\1\13\3\uffff\1\14",
            "\1\15",
            "\1\16",
            "\1\10",
            "\1\14",
            "\1\17\3\uffff\1\14",
            "\1\20",
            "\1\17\3\uffff\1\14"
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "()* loopback of 353:65: ( infoDecl | subAttrAssign | portAssign )*";
        }
    }
 

    public static final BitSet FOLLOW_deviceDecl_in_sourceText443 = new BitSet(new long[]{0x0000000000380000L});
    public static final BitSet FOLLOW_designDecl_in_sourceText447 = new BitSet(new long[]{0x0000000000380000L});
    public static final BitSet FOLLOW_EOF_in_sourceText451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEVICE_in_deviceDecl464 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl466 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACE_in_deviceDecl468 = new BitSet(new long[]{0x000007E412004000L});
    public static final BitSet FOLLOW_infoDecl_in_deviceDecl471 = new BitSet(new long[]{0x000007E412004000L});
    public static final BitSet FOLLOW_attrDecl_in_deviceDecl475 = new BitSet(new long[]{0x000007E412004000L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl479 = new BitSet(new long[]{0x000007E412004000L});
    public static final BitSet FOLLOW_RBRACE_in_deviceDecl483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ATTR_in_attrDecl517 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_attrDecl519 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_attrDecl521 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_STRING_in_attrDecl523 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SEMICOLON_in_attrDecl525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pinType_in_pinDecl548 = new BitSet(new long[]{0x0000000000000800L,0x0000000000000020L});
    public static final BitSet FOLLOW_LBRACKET_in_pinDecl551 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_width_in_pinDecl553 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RBRACKET_in_pinDecl555 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl559 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_pinDecl561 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_pinList_in_pinDecl563 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinDecl565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESIGN_in_designDecl597 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_designDecl599 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACE_in_designDecl601 = new BitSet(new long[]{0x0000000C0BC04000L,0x0000000000000020L});
    public static final BitSet FOLLOW_designBody_in_designDecl603 = new BitSet(new long[]{0x0000000C0BC04000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RBRACE_in_designDecl606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUBDESIGN_in_designDecl622 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_designDecl624 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACE_in_designDecl626 = new BitSet(new long[]{0x0000000C0BC04000L,0x0000000000000020L});
    public static final BitSet FOLLOW_designBody_in_designDecl628 = new BitSet(new long[]{0x0000000C0BC04000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RBRACE_in_designDecl631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_infoDecl_in_designBody656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_connectDecl_in_designBody661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instDecl_in_designBody666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_connectAssign_in_designBody671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_groupDecl_in_designBody676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifier_in_infoDecl689 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_INFO_in_infoDecl692 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACE_in_infoDecl694 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_STRING_in_infoDecl696 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACE_in_infoDecl698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NET_in_connectDecl722 = new BitSet(new long[]{0x0000000000000800L,0x0000000000000020L});
    public static final BitSet FOLLOW_LBRACKET_in_connectDecl725 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_width_in_connectDecl727 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RBRACKET_in_connectDecl729 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_connectDecl733 = new BitSet(new long[]{0x0000000000002050L});
    public static final BitSet FOLLOW_COMMA_in_connectDecl736 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_connectDecl738 = new BitSet(new long[]{0x0000000000002050L});
    public static final BitSet FOLLOW_LBRACE_in_connectDecl744 = new BitSet(new long[]{0x0000000010004000L});
    public static final BitSet FOLLOW_attrDecl_in_connectDecl746 = new BitSet(new long[]{0x0000000010004000L});
    public static final BitSet FOLLOW_RBRACE_in_connectDecl749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_connectDecl754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PORT_in_connectDecl781 = new BitSet(new long[]{0x0000000000000800L,0x0000000000000020L});
    public static final BitSet FOLLOW_LBRACKET_in_connectDecl784 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_width_in_connectDecl786 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RBRACKET_in_connectDecl788 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_connectDecl792 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_COMMA_in_connectDecl795 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_connectDecl797 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_SEMICOLON_in_connectDecl801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INST_in_instDecl829 = new BitSet(new long[]{0x0000000000000200L,0x0000000000000020L});
    public static final BitSet FOLLOW_LPAREN_in_instDecl832 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_width_in_instDecl834 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_instDecl836 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_instDecl840 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_OF_in_instDecl842 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_instDecl844 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACE_in_instDecl846 = new BitSet(new long[]{0x0000000522004000L,0x0000000000000020L});
    public static final BitSet FOLLOW_infoDecl_in_instDecl849 = new BitSet(new long[]{0x0000000522004000L,0x0000000000000020L});
    public static final BitSet FOLLOW_attrAssign_in_instDecl853 = new BitSet(new long[]{0x0000000522004000L,0x0000000000000020L});
    public static final BitSet FOLLOW_pinAssign_in_instDecl857 = new BitSet(new long[]{0x0000000522004000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RBRACE_in_instDecl861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUBINST_in_instDecl893 = new BitSet(new long[]{0x0000000000000200L,0x0000000000000020L});
    public static final BitSet FOLLOW_LPAREN_in_instDecl896 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_width_in_instDecl898 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_instDecl900 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_instDecl904 = new BitSet(new long[]{0x0000000004000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_STRING_in_instDecl906 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_OF_in_instDecl909 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_instDecl911 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACE_in_instDecl913 = new BitSet(new long[]{0x0000000522004000L,0x0000000000000020L});
    public static final BitSet FOLLOW_infoDecl_in_instDecl916 = new BitSet(new long[]{0x0000000522004000L,0x0000000000000020L});
    public static final BitSet FOLLOW_subAttrAssign_in_instDecl920 = new BitSet(new long[]{0x0000000522004000L,0x0000000000000020L});
    public static final BitSet FOLLOW_portAssign_in_instDecl924 = new BitSet(new long[]{0x0000000522004000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RBRACE_in_instDecl928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWATTR_in_attrAssign968 = new BitSet(new long[]{0x0000000002000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_qualifier_in_attrAssign971 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_attrAssign974 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_attrAssign976 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_STRING_in_attrAssign978 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SEMICOLON_in_attrAssign980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWATTR_in_subAttrAssign1013 = new BitSet(new long[]{0x0000000022000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_qualifier_in_subAttrAssign1016 = new BitSet(new long[]{0x0000000022000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_name_in_subAttrAssign1020 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PERIOD_in_subAttrAssign1022 = new BitSet(new long[]{0x0000000022000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_subAttrAssign1026 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_subAttrAssign1028 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_STRING_in_subAttrAssign1030 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SEMICOLON_in_subAttrAssign1032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMBINE_in_pinAssign1066 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_pinAssign1068 = new BitSet(new long[]{0x0000000002000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_qualifier_in_pinAssign1070 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_operand_in_pinAssign1073 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_pinAssign1075 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_qualifier_in_pinAssign1081 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_operand_in_pinAssign1084 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssign1088 = new BitSet(new long[]{0x0000001000008000L,0x0000000000000020L});
    public static final BitSet FOLLOW_concat_in_pinAssign1090 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinAssign1092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMBINE_in_portAssign1125 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_portAssign1127 = new BitSet(new long[]{0x0000000002000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_qualifier_in_portAssign1129 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_operand_in_portAssign1132 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_portAssign1134 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_qualifier_in_portAssign1140 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_operand_in_portAssign1143 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_portAssign1147 = new BitSet(new long[]{0x0000001000008000L,0x0000000000000020L});
    public static final BitSet FOLLOW_concat_in_portAssign1149 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SEMICOLON_in_portAssign1151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operand_in_connectAssign1184 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_connectAssign1186 = new BitSet(new long[]{0x0000001000008000L,0x0000000000000020L});
    public static final BitSet FOLLOW_concat_in_connectAssign1188 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SEMICOLON_in_connectAssign1190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_groupDecl1215 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_STRING_in_groupDecl1217 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACE_in_groupDecl1219 = new BitSet(new long[]{0x0000000C0AC04000L,0x0000000000000020L});
    public static final BitSet FOLLOW_groupBody_in_groupDecl1221 = new BitSet(new long[]{0x0000000C0AC04000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RBRACE_in_groupDecl1224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_infoDecl_in_groupBody1249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_connectDecl_in_groupBody1254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instDecl_in_groupBody1259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_connectAssign_in_groupBody1264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_width1277 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_COLON_in_width1279 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_INT_in_width1281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PIN_in_pinType1307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INPIN_in_pinType1320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPIN_in_pinType1333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IOPIN_in_pinType1346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PWRPIN_in_pinType1359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUPPIN_in_pinType1372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_pinList1395 = new BitSet(new long[]{0x0000000000000000L,0x00000000000001A0L});
    public static final BitSet FOLLOW_pinNumber_in_pinList1397 = new BitSet(new long[]{0x0000000000004040L});
    public static final BitSet FOLLOW_COMMA_in_pinList1400 = new BitSet(new long[]{0x0000000000000000L,0x00000000000001A0L});
    public static final BitSet FOLLOW_pinNumber_in_pinList1402 = new BitSet(new long[]{0x0000000000004040L});
    public static final BitSet FOLLOW_RBRACE_in_pinList1406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_pinNumber0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THIS_in_qualifier1451 = new BitSet(new long[]{0x0000000000000280L});
    public static final BitSet FOLLOW_LPAREN_in_qualifier1454 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_index_in_qualifier1456 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_qualifier1458 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PERIOD_in_qualifier1462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_index1485 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_COLON_in_index1487 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_INT_in_index1489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_index1509 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_COMMA_in_index1512 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_INT_in_index1514 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_COMMA_in_index1517 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_INT_in_index1519 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_operand_in_concat1546 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_AMPERSAND_in_concat1549 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_operand_in_concat1551 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_LANGLE_in_concat1569 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_operand_in_concat1571 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RANGLE_in_concat1573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_in_concat1589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_operand1614 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_LBRACKET_in_operand1617 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_index_in_operand1619 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RBRACKET_in_operand1621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_name1648 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_LPAREN_in_name1651 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_index_in_name1653 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_name1655 = new BitSet(new long[]{0x0000000000000002L});

}