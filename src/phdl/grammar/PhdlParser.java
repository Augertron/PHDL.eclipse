// $ANTLR 3.3 Nov 30, 2010 12:50:56 /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g 2012-01-11 10:26:29

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SEMICOLON", "COLON", "COMMA", "PERIOD", "EQUALS", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "LANGLE", "RANGLE", "AMPERSAND", "DBLQUOTE", "DESIGN", "DEVICE", "SUBDESIGN", "INST", "SUBINST", "GROUP", "THIS", "OF", "NET", "ATTR", "NEWATTR", "BEGIN", "END", "COMBINE", "INCLUDE", "INFO", "PORT", "OPEN", "PIN", "INPIN", "OUTPIN", "IOPIN", "PWRPIN", "SUPPIN", "DEVICE_DECL", "DESIGN_DECL", "SUBDESIGN_DECL", "ATTR_DECL", "PIN_DECL", "PORT_DECL", "NET_DECL", "INST_DECL", "SUBINST_DECL", "GROUP_DECL", "INFO_DECL", "ATTR_ASSIGN", "SUBATTR_ASSIGN", "CONNECT_ASSIGN", "NET_ASSIGN", "CONCAT_LIST", "CONCAT_REPL", "CONCAT_OPEN", "WIDTH", "PIN_LIST", "PIN_TYPE", "BOUNDS", "INDICES", "OPERAND", "NAME", "IDENT", "STRING", "INT", "PINNUM", "D", "E", "S", "I", "G", "N", "V", "C", "U", "B", "T", "R", "O", "P", "H", "F", "A", "W", "M", "L", "J", "K", "Q", "X", "Y", "Z", "CHAR", "DIGIT", "ESC", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "INCLUDE_DECL"
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
    public static final int CONNECT_ASSIGN=56;
    public static final int NET_ASSIGN=57;
    public static final int CONCAT_LIST=58;
    public static final int CONCAT_REPL=59;
    public static final int CONCAT_OPEN=60;
    public static final int WIDTH=61;
    public static final int PIN_LIST=62;
    public static final int PIN_TYPE=63;
    public static final int BOUNDS=64;
    public static final int INDICES=65;
    public static final int OPERAND=66;
    public static final int NAME=67;
    public static final int IDENT=68;
    public static final int STRING=69;
    public static final int INT=70;
    public static final int PINNUM=71;
    public static final int D=72;
    public static final int E=73;
    public static final int S=74;
    public static final int I=75;
    public static final int G=76;
    public static final int N=77;
    public static final int V=78;
    public static final int C=79;
    public static final int U=80;
    public static final int B=81;
    public static final int T=82;
    public static final int R=83;
    public static final int O=84;
    public static final int P=85;
    public static final int H=86;
    public static final int F=87;
    public static final int A=88;
    public static final int W=89;
    public static final int M=90;
    public static final int L=91;
    public static final int J=92;
    public static final int K=93;
    public static final int Q=94;
    public static final int X=95;
    public static final int Y=96;
    public static final int Z=97;
    public static final int CHAR=98;
    public static final int DIGIT=99;
    public static final int ESC=100;
    public static final int WHITESPACE=101;
    public static final int LINE_COMMENT=102;
    public static final int MULTILINE_COMMENT=103;
    public static final int INCLUDE_DECL=104;

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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:242:1: sourceText : ( deviceDecl | designDecl )+ ;
    public final PhdlParser.sourceText_return sourceText() throws RecognitionException {
        PhdlParser.sourceText_return retval = new PhdlParser.sourceText_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        PhdlParser.deviceDecl_return deviceDecl1 = null;

        PhdlParser.designDecl_return designDecl2 = null;



        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:248:2: ( ( deviceDecl | designDecl )+ )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:248:4: ( deviceDecl | designDecl )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:248:4: ( deviceDecl | designDecl )+
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
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:248:5: deviceDecl
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_sourceText439);
            	    deviceDecl1=deviceDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, deviceDecl1.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:248:18: designDecl
            	    {
            	    pushFollow(FOLLOW_designDecl_in_sourceText443);
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:251:1: deviceDecl : DEVICE IDENT LBRACE ( infoDecl | attrDecl | pinDecl )* RBRACE -> ^( DEVICE_DECL IDENT ( infoDecl )* ( attrDecl )* ( pinDecl )* ) ;
    public final PhdlParser.deviceDecl_return deviceDecl() throws RecognitionException {
        PhdlParser.deviceDecl_return retval = new PhdlParser.deviceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DEVICE3=null;
        Token IDENT4=null;
        Token LBRACE5=null;
        Token RBRACE9=null;
        PhdlParser.infoDecl_return infoDecl6 = null;

        PhdlParser.attrDecl_return attrDecl7 = null;

        PhdlParser.pinDecl_return pinDecl8 = null;


        CommonTree DEVICE3_tree=null;
        CommonTree IDENT4_tree=null;
        CommonTree LBRACE5_tree=null;
        CommonTree RBRACE9_tree=null;
        RewriteRuleTokenStream stream_DEVICE=new RewriteRuleTokenStream(adaptor,"token DEVICE");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_pinDecl=new RewriteRuleSubtreeStream(adaptor,"rule pinDecl");
        RewriteRuleSubtreeStream stream_attrDecl=new RewriteRuleSubtreeStream(adaptor,"rule attrDecl");
        RewriteRuleSubtreeStream stream_infoDecl=new RewriteRuleSubtreeStream(adaptor,"rule infoDecl");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:258:2: ( DEVICE IDENT LBRACE ( infoDecl | attrDecl | pinDecl )* RBRACE -> ^( DEVICE_DECL IDENT ( infoDecl )* ( attrDecl )* ( pinDecl )* ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:258:4: DEVICE IDENT LBRACE ( infoDecl | attrDecl | pinDecl )* RBRACE
            {
            DEVICE3=(Token)match(input,DEVICE,FOLLOW_DEVICE_in_deviceDecl458); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DEVICE.add(DEVICE3);

            IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl460); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT4);

            LBRACE5=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_deviceDecl462); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE5);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:258:24: ( infoDecl | attrDecl | pinDecl )*
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
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:258:25: infoDecl
            	    {
            	    pushFollow(FOLLOW_infoDecl_in_deviceDecl465);
            	    infoDecl6=infoDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_infoDecl.add(infoDecl6.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:258:36: attrDecl
            	    {
            	    pushFollow(FOLLOW_attrDecl_in_deviceDecl469);
            	    attrDecl7=attrDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_attrDecl.add(attrDecl7.getTree());

            	    }
            	    break;
            	case 3 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:258:47: pinDecl
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl473);
            	    pinDecl8=pinDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_pinDecl.add(pinDecl8.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            RBRACE9=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_deviceDecl477); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE9);



            // AST REWRITE
            // elements: infoDecl, pinDecl, IDENT, attrDecl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 259:3: -> ^( DEVICE_DECL IDENT ( infoDecl )* ( attrDecl )* ( pinDecl )* )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:259:6: ^( DEVICE_DECL IDENT ( infoDecl )* ( attrDecl )* ( pinDecl )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DEVICE_DECL, "DEVICE_DECL"), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:259:26: ( infoDecl )*
                while ( stream_infoDecl.hasNext() ) {
                    adaptor.addChild(root_1, stream_infoDecl.nextTree());

                }
                stream_infoDecl.reset();
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:259:36: ( attrDecl )*
                while ( stream_attrDecl.hasNext() ) {
                    adaptor.addChild(root_1, stream_attrDecl.nextTree());

                }
                stream_attrDecl.reset();
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:259:46: ( pinDecl )*
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:262:1: attrDecl : ATTR IDENT EQUALS STRING SEMICOLON -> ^( ATTR_DECL IDENT STRING ) ;
    public final PhdlParser.attrDecl_return attrDecl() throws RecognitionException {
        PhdlParser.attrDecl_return retval = new PhdlParser.attrDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ATTR10=null;
        Token IDENT11=null;
        Token EQUALS12=null;
        Token STRING13=null;
        Token SEMICOLON14=null;

        CommonTree ATTR10_tree=null;
        CommonTree IDENT11_tree=null;
        CommonTree EQUALS12_tree=null;
        CommonTree STRING13_tree=null;
        CommonTree SEMICOLON14_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_ATTR=new RewriteRuleTokenStream(adaptor,"token ATTR");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:269:2: ( ATTR IDENT EQUALS STRING SEMICOLON -> ^( ATTR_DECL IDENT STRING ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:269:4: ATTR IDENT EQUALS STRING SEMICOLON
            {
            ATTR10=(Token)match(input,ATTR,FOLLOW_ATTR_in_attrDecl511); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ATTR.add(ATTR10);

            IDENT11=(Token)match(input,IDENT,FOLLOW_IDENT_in_attrDecl513); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT11);

            EQUALS12=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attrDecl515); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS12);

            STRING13=(Token)match(input,STRING,FOLLOW_STRING_in_attrDecl517); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(STRING13);

            SEMICOLON14=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attrDecl519); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON14);



            // AST REWRITE
            // elements: IDENT, STRING
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 269:39: -> ^( ATTR_DECL IDENT STRING )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:269:42: ^( ATTR_DECL IDENT STRING )
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:272:1: pinDecl : pinType ( LBRACKET width RBRACKET )? IDENT EQUALS pinList SEMICOLON -> ^( PIN_DECL IDENT pinType ( width )? pinList ) ;
    public final PhdlParser.pinDecl_return pinDecl() throws RecognitionException {
        PhdlParser.pinDecl_return retval = new PhdlParser.pinDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACKET16=null;
        Token RBRACKET18=null;
        Token IDENT19=null;
        Token EQUALS20=null;
        Token SEMICOLON22=null;
        PhdlParser.pinType_return pinType15 = null;

        PhdlParser.width_return width17 = null;

        PhdlParser.pinList_return pinList21 = null;


        CommonTree LBRACKET16_tree=null;
        CommonTree RBRACKET18_tree=null;
        CommonTree IDENT19_tree=null;
        CommonTree EQUALS20_tree=null;
        CommonTree SEMICOLON22_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleSubtreeStream stream_width=new RewriteRuleSubtreeStream(adaptor,"rule width");
        RewriteRuleSubtreeStream stream_pinList=new RewriteRuleSubtreeStream(adaptor,"rule pinList");
        RewriteRuleSubtreeStream stream_pinType=new RewriteRuleSubtreeStream(adaptor,"rule pinType");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:279:2: ( pinType ( LBRACKET width RBRACKET )? IDENT EQUALS pinList SEMICOLON -> ^( PIN_DECL IDENT pinType ( width )? pinList ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:279:4: pinType ( LBRACKET width RBRACKET )? IDENT EQUALS pinList SEMICOLON
            {
            pushFollow(FOLLOW_pinType_in_pinDecl542);
            pinType15=pinType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_pinType.add(pinType15.getTree());
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:279:12: ( LBRACKET width RBRACKET )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==LBRACKET) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:279:13: LBRACKET width RBRACKET
                    {
                    LBRACKET16=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_pinDecl545); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET16);

                    pushFollow(FOLLOW_width_in_pinDecl547);
                    width17=width();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_width.add(width17.getTree());
                    RBRACKET18=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_pinDecl549); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET18);


                    }
                    break;

            }

            IDENT19=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinDecl553); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT19);

            EQUALS20=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinDecl555); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS20);

            pushFollow(FOLLOW_pinList_in_pinDecl557);
            pinList21=pinList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_pinList.add(pinList21.getTree());
            SEMICOLON22=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinDecl559); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON22);



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
            // 280:3: -> ^( PIN_DECL IDENT pinType ( width )? pinList )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:280:6: ^( PIN_DECL IDENT pinType ( width )? pinList )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PIN_DECL, "PIN_DECL"), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                adaptor.addChild(root_1, stream_pinType.nextTree());
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:280:31: ( width )?
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:283:1: designDecl : ( DESIGN IDENT LBRACE ( designBody )* RBRACE -> ^( DESIGN_DECL IDENT ( designBody )* ) | SUBDESIGN IDENT LBRACE ( designBody )* RBRACE -> ^( SUBDESIGN_DECL IDENT ( designBody )* ) );
    public final PhdlParser.designDecl_return designDecl() throws RecognitionException {
        PhdlParser.designDecl_return retval = new PhdlParser.designDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DESIGN23=null;
        Token IDENT24=null;
        Token LBRACE25=null;
        Token RBRACE27=null;
        Token SUBDESIGN28=null;
        Token IDENT29=null;
        Token LBRACE30=null;
        Token RBRACE32=null;
        PhdlParser.designBody_return designBody26 = null;

        PhdlParser.designBody_return designBody31 = null;


        CommonTree DESIGN23_tree=null;
        CommonTree IDENT24_tree=null;
        CommonTree LBRACE25_tree=null;
        CommonTree RBRACE27_tree=null;
        CommonTree SUBDESIGN28_tree=null;
        CommonTree IDENT29_tree=null;
        CommonTree LBRACE30_tree=null;
        CommonTree RBRACE32_tree=null;
        RewriteRuleTokenStream stream_DESIGN=new RewriteRuleTokenStream(adaptor,"token DESIGN");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_SUBDESIGN=new RewriteRuleTokenStream(adaptor,"token SUBDESIGN");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_designBody=new RewriteRuleSubtreeStream(adaptor,"rule designBody");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:290:2: ( DESIGN IDENT LBRACE ( designBody )* RBRACE -> ^( DESIGN_DECL IDENT ( designBody )* ) | SUBDESIGN IDENT LBRACE ( designBody )* RBRACE -> ^( SUBDESIGN_DECL IDENT ( designBody )* ) )
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
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:290:4: DESIGN IDENT LBRACE ( designBody )* RBRACE
                    {
                    DESIGN23=(Token)match(input,DESIGN,FOLLOW_DESIGN_in_designDecl591); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DESIGN.add(DESIGN23);

                    IDENT24=(Token)match(input,IDENT,FOLLOW_IDENT_in_designDecl593); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT24);

                    LBRACE25=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_designDecl595); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE25);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:290:24: ( designBody )*
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
                    	    pushFollow(FOLLOW_designBody_in_designDecl597);
                    	    designBody26=designBody();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_designBody.add(designBody26.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    RBRACE27=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_designDecl600); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE27);



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
                    // 290:43: -> ^( DESIGN_DECL IDENT ( designBody )* )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:290:46: ^( DESIGN_DECL IDENT ( designBody )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DESIGN_DECL, "DESIGN_DECL"), root_1);

                        adaptor.addChild(root_1, stream_IDENT.nextNode());
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:290:66: ( designBody )*
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
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:291:4: SUBDESIGN IDENT LBRACE ( designBody )* RBRACE
                    {
                    SUBDESIGN28=(Token)match(input,SUBDESIGN,FOLLOW_SUBDESIGN_in_designDecl616); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SUBDESIGN.add(SUBDESIGN28);

                    IDENT29=(Token)match(input,IDENT,FOLLOW_IDENT_in_designDecl618); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT29);

                    LBRACE30=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_designDecl620); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE30);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:291:27: ( designBody )*
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
                    	    pushFollow(FOLLOW_designBody_in_designDecl622);
                    	    designBody31=designBody();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_designBody.add(designBody31.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    RBRACE32=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_designDecl625); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE32);



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
                    // 291:46: -> ^( SUBDESIGN_DECL IDENT ( designBody )* )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:291:49: ^( SUBDESIGN_DECL IDENT ( designBody )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SUBDESIGN_DECL, "SUBDESIGN_DECL"), root_1);

                        adaptor.addChild(root_1, stream_IDENT.nextNode());
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:291:72: ( designBody )*
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:294:1: designBody : ( infoDecl | connectDecl | instDecl | netAssign | groupDecl );
    public final PhdlParser.designBody_return designBody() throws RecognitionException {
        PhdlParser.designBody_return retval = new PhdlParser.designBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        PhdlParser.infoDecl_return infoDecl33 = null;

        PhdlParser.connectDecl_return connectDecl34 = null;

        PhdlParser.instDecl_return instDecl35 = null;

        PhdlParser.netAssign_return netAssign36 = null;

        PhdlParser.groupDecl_return groupDecl37 = null;



        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:300:2: ( infoDecl | connectDecl | instDecl | netAssign | groupDecl )
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
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:300:4: infoDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_infoDecl_in_designBody650);
                    infoDecl33=infoDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, infoDecl33.getTree());

                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:301:4: connectDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_connectDecl_in_designBody655);
                    connectDecl34=connectDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, connectDecl34.getTree());

                    }
                    break;
                case 3 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:302:4: instDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_instDecl_in_designBody660);
                    instDecl35=instDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, instDecl35.getTree());

                    }
                    break;
                case 4 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:303:4: netAssign
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_netAssign_in_designBody665);
                    netAssign36=netAssign();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, netAssign36.getTree());

                    }
                    break;
                case 5 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:304:4: groupDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_groupDecl_in_designBody670);
                    groupDecl37=groupDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, groupDecl37.getTree());

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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:307:1: infoDecl : ( qualifier )? INFO LBRACE STRING RBRACE -> ^( INFO_DECL ( qualifier )? STRING ) ;
    public final PhdlParser.infoDecl_return infoDecl() throws RecognitionException {
        PhdlParser.infoDecl_return retval = new PhdlParser.infoDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INFO39=null;
        Token LBRACE40=null;
        Token STRING41=null;
        Token RBRACE42=null;
        PhdlParser.qualifier_return qualifier38 = null;


        CommonTree INFO39_tree=null;
        CommonTree LBRACE40_tree=null;
        CommonTree STRING41_tree=null;
        CommonTree RBRACE42_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_INFO=new RewriteRuleTokenStream(adaptor,"token INFO");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_qualifier=new RewriteRuleSubtreeStream(adaptor,"rule qualifier");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:314:2: ( ( qualifier )? INFO LBRACE STRING RBRACE -> ^( INFO_DECL ( qualifier )? STRING ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:314:4: ( qualifier )? INFO LBRACE STRING RBRACE
            {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:314:4: ( qualifier )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==THIS) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:0:0: qualifier
                    {
                    pushFollow(FOLLOW_qualifier_in_infoDecl683);
                    qualifier38=qualifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_qualifier.add(qualifier38.getTree());

                    }
                    break;

            }

            INFO39=(Token)match(input,INFO,FOLLOW_INFO_in_infoDecl686); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INFO.add(INFO39);

            LBRACE40=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_infoDecl688); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE40);

            STRING41=(Token)match(input,STRING,FOLLOW_STRING_in_infoDecl690); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(STRING41);

            RBRACE42=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_infoDecl692); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE42);



            // AST REWRITE
            // elements: qualifier, STRING
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 314:41: -> ^( INFO_DECL ( qualifier )? STRING )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:314:44: ^( INFO_DECL ( qualifier )? STRING )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INFO_DECL, "INFO_DECL"), root_1);

                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:314:56: ( qualifier )?
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:317:1: connectDecl : ( NET ( LBRACKET width RBRACKET )? IDENT ( COMMA IDENT )* ( ( LBRACE ( attrDecl )* RBRACE ) | SEMICOLON ) -> ^( NET_DECL ( width )? ( IDENT )+ ( attrDecl )* ) | PORT ( LBRACKET width RBRACKET )? IDENT ( COMMA IDENT )* SEMICOLON -> ^( PORT_DECL ( width )? ( IDENT )+ ) );
    public final PhdlParser.connectDecl_return connectDecl() throws RecognitionException {
        PhdlParser.connectDecl_return retval = new PhdlParser.connectDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NET43=null;
        Token LBRACKET44=null;
        Token RBRACKET46=null;
        Token IDENT47=null;
        Token COMMA48=null;
        Token IDENT49=null;
        Token LBRACE50=null;
        Token RBRACE52=null;
        Token SEMICOLON53=null;
        Token PORT54=null;
        Token LBRACKET55=null;
        Token RBRACKET57=null;
        Token IDENT58=null;
        Token COMMA59=null;
        Token IDENT60=null;
        Token SEMICOLON61=null;
        PhdlParser.width_return width45 = null;

        PhdlParser.attrDecl_return attrDecl51 = null;

        PhdlParser.width_return width56 = null;


        CommonTree NET43_tree=null;
        CommonTree LBRACKET44_tree=null;
        CommonTree RBRACKET46_tree=null;
        CommonTree IDENT47_tree=null;
        CommonTree COMMA48_tree=null;
        CommonTree IDENT49_tree=null;
        CommonTree LBRACE50_tree=null;
        CommonTree RBRACE52_tree=null;
        CommonTree SEMICOLON53_tree=null;
        CommonTree PORT54_tree=null;
        CommonTree LBRACKET55_tree=null;
        CommonTree RBRACKET57_tree=null;
        CommonTree IDENT58_tree=null;
        CommonTree COMMA59_tree=null;
        CommonTree IDENT60_tree=null;
        CommonTree SEMICOLON61_tree=null;
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:321:2: ( NET ( LBRACKET width RBRACKET )? IDENT ( COMMA IDENT )* ( ( LBRACE ( attrDecl )* RBRACE ) | SEMICOLON ) -> ^( NET_DECL ( width )? ( IDENT )+ ( attrDecl )* ) | PORT ( LBRACKET width RBRACKET )? IDENT ( COMMA IDENT )* SEMICOLON -> ^( PORT_DECL ( width )? ( IDENT )+ ) )
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
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:321:4: NET ( LBRACKET width RBRACKET )? IDENT ( COMMA IDENT )* ( ( LBRACE ( attrDecl )* RBRACE ) | SEMICOLON )
                    {
                    NET43=(Token)match(input,NET,FOLLOW_NET_in_connectDecl716); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NET.add(NET43);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:321:8: ( LBRACKET width RBRACKET )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==LBRACKET) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:321:9: LBRACKET width RBRACKET
                            {
                            LBRACKET44=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_connectDecl719); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET44);

                            pushFollow(FOLLOW_width_in_connectDecl721);
                            width45=width();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_width.add(width45.getTree());
                            RBRACKET46=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_connectDecl723); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET46);


                            }
                            break;

                    }

                    IDENT47=(Token)match(input,IDENT,FOLLOW_IDENT_in_connectDecl727); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT47);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:321:41: ( COMMA IDENT )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==COMMA) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:321:42: COMMA IDENT
                    	    {
                    	    COMMA48=(Token)match(input,COMMA,FOLLOW_COMMA_in_connectDecl730); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA48);

                    	    IDENT49=(Token)match(input,IDENT,FOLLOW_IDENT_in_connectDecl732); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_IDENT.add(IDENT49);


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:321:56: ( ( LBRACE ( attrDecl )* RBRACE ) | SEMICOLON )
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
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:321:57: ( LBRACE ( attrDecl )* RBRACE )
                            {
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:321:57: ( LBRACE ( attrDecl )* RBRACE )
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:321:58: LBRACE ( attrDecl )* RBRACE
                            {
                            LBRACE50=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_connectDecl738); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE50);

                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:321:65: ( attrDecl )*
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
                            	    pushFollow(FOLLOW_attrDecl_in_connectDecl740);
                            	    attrDecl51=attrDecl();

                            	    state._fsp--;
                            	    if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) stream_attrDecl.add(attrDecl51.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop11;
                                }
                            } while (true);

                            RBRACE52=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_connectDecl743); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE52);


                            }


                            }
                            break;
                        case 2 :
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:321:85: SEMICOLON
                            {
                            SEMICOLON53=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_connectDecl748); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON53);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: attrDecl, IDENT, width
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 322:3: -> ^( NET_DECL ( width )? ( IDENT )+ ( attrDecl )* )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:322:6: ^( NET_DECL ( width )? ( IDENT )+ ( attrDecl )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NET_DECL, "NET_DECL"), root_1);

                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:322:17: ( width )?
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
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:322:31: ( attrDecl )*
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
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:324:4: PORT ( LBRACKET width RBRACKET )? IDENT ( COMMA IDENT )* SEMICOLON
                    {
                    PORT54=(Token)match(input,PORT,FOLLOW_PORT_in_connectDecl775); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PORT.add(PORT54);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:324:9: ( LBRACKET width RBRACKET )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==LBRACKET) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:324:10: LBRACKET width RBRACKET
                            {
                            LBRACKET55=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_connectDecl778); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET55);

                            pushFollow(FOLLOW_width_in_connectDecl780);
                            width56=width();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_width.add(width56.getTree());
                            RBRACKET57=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_connectDecl782); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET57);


                            }
                            break;

                    }

                    IDENT58=(Token)match(input,IDENT,FOLLOW_IDENT_in_connectDecl786); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT58);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:324:42: ( COMMA IDENT )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==COMMA) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:324:43: COMMA IDENT
                    	    {
                    	    COMMA59=(Token)match(input,COMMA,FOLLOW_COMMA_in_connectDecl789); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA59);

                    	    IDENT60=(Token)match(input,IDENT,FOLLOW_IDENT_in_connectDecl791); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_IDENT.add(IDENT60);


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    SEMICOLON61=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_connectDecl795); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON61);



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
                    // 325:3: -> ^( PORT_DECL ( width )? ( IDENT )+ )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:325:6: ^( PORT_DECL ( width )? ( IDENT )+ )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PORT_DECL, "PORT_DECL"), root_1);

                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:325:18: ( width )?
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:328:1: instDecl : ( INST ( LPAREN width RPAREN )? IDENT OF IDENT LBRACE ( infoDecl | attrAssign | connectAssign )* RBRACE -> ^( INST_DECL ( width )? IDENT IDENT ( infoDecl )* ( attrAssign )* ( connectAssign )* ) | SUBINST ( LPAREN width RPAREN )? IDENT OF IDENT LBRACE ( infoDecl | subAttrAssign | connectAssign )* RBRACE -> ^( SUBINST_DECL ( width )? IDENT IDENT ( infoDecl )* ( subAttrAssign )* ( connectAssign )* ) );
    public final PhdlParser.instDecl_return instDecl() throws RecognitionException {
        PhdlParser.instDecl_return retval = new PhdlParser.instDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INST62=null;
        Token LPAREN63=null;
        Token RPAREN65=null;
        Token IDENT66=null;
        Token OF67=null;
        Token IDENT68=null;
        Token LBRACE69=null;
        Token RBRACE73=null;
        Token SUBINST74=null;
        Token LPAREN75=null;
        Token RPAREN77=null;
        Token IDENT78=null;
        Token OF79=null;
        Token IDENT80=null;
        Token LBRACE81=null;
        Token RBRACE85=null;
        PhdlParser.width_return width64 = null;

        PhdlParser.infoDecl_return infoDecl70 = null;

        PhdlParser.attrAssign_return attrAssign71 = null;

        PhdlParser.connectAssign_return connectAssign72 = null;

        PhdlParser.width_return width76 = null;

        PhdlParser.infoDecl_return infoDecl82 = null;

        PhdlParser.subAttrAssign_return subAttrAssign83 = null;

        PhdlParser.connectAssign_return connectAssign84 = null;


        CommonTree INST62_tree=null;
        CommonTree LPAREN63_tree=null;
        CommonTree RPAREN65_tree=null;
        CommonTree IDENT66_tree=null;
        CommonTree OF67_tree=null;
        CommonTree IDENT68_tree=null;
        CommonTree LBRACE69_tree=null;
        CommonTree RBRACE73_tree=null;
        CommonTree SUBINST74_tree=null;
        CommonTree LPAREN75_tree=null;
        CommonTree RPAREN77_tree=null;
        CommonTree IDENT78_tree=null;
        CommonTree OF79_tree=null;
        CommonTree IDENT80_tree=null;
        CommonTree LBRACE81_tree=null;
        CommonTree RBRACE85_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_SUBINST=new RewriteRuleTokenStream(adaptor,"token SUBINST");
        RewriteRuleTokenStream stream_OF=new RewriteRuleTokenStream(adaptor,"token OF");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleTokenStream stream_INST=new RewriteRuleTokenStream(adaptor,"token INST");
        RewriteRuleSubtreeStream stream_connectAssign=new RewriteRuleSubtreeStream(adaptor,"rule connectAssign");
        RewriteRuleSubtreeStream stream_width=new RewriteRuleSubtreeStream(adaptor,"rule width");
        RewriteRuleSubtreeStream stream_subAttrAssign=new RewriteRuleSubtreeStream(adaptor,"rule subAttrAssign");
        RewriteRuleSubtreeStream stream_infoDecl=new RewriteRuleSubtreeStream(adaptor,"rule infoDecl");
        RewriteRuleSubtreeStream stream_attrAssign=new RewriteRuleSubtreeStream(adaptor,"rule attrAssign");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:339:2: ( INST ( LPAREN width RPAREN )? IDENT OF IDENT LBRACE ( infoDecl | attrAssign | connectAssign )* RBRACE -> ^( INST_DECL ( width )? IDENT IDENT ( infoDecl )* ( attrAssign )* ( connectAssign )* ) | SUBINST ( LPAREN width RPAREN )? IDENT OF IDENT LBRACE ( infoDecl | subAttrAssign | connectAssign )* RBRACE -> ^( SUBINST_DECL ( width )? IDENT IDENT ( infoDecl )* ( subAttrAssign )* ( connectAssign )* ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==INST) ) {
                alt20=1;
            }
            else if ( (LA20_0==SUBINST) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:339:4: INST ( LPAREN width RPAREN )? IDENT OF IDENT LBRACE ( infoDecl | attrAssign | connectAssign )* RBRACE
                    {
                    INST62=(Token)match(input,INST,FOLLOW_INST_in_instDecl823); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INST.add(INST62);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:339:9: ( LPAREN width RPAREN )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==LPAREN) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:339:10: LPAREN width RPAREN
                            {
                            LPAREN63=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_instDecl826); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN63);

                            pushFollow(FOLLOW_width_in_instDecl828);
                            width64=width();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_width.add(width64.getTree());
                            RPAREN65=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_instDecl830); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN65);


                            }
                            break;

                    }

                    IDENT66=(Token)match(input,IDENT,FOLLOW_IDENT_in_instDecl834); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT66);

                    OF67=(Token)match(input,OF,FOLLOW_OF_in_instDecl836); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OF.add(OF67);

                    IDENT68=(Token)match(input,IDENT,FOLLOW_IDENT_in_instDecl838); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT68);

                    LBRACE69=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_instDecl840); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE69);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:339:54: ( infoDecl | attrAssign | connectAssign )*
                    loop17:
                    do {
                        int alt17=4;
                        alt17 = dfa17.predict(input);
                        switch (alt17) {
                    	case 1 :
                    	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:339:55: infoDecl
                    	    {
                    	    pushFollow(FOLLOW_infoDecl_in_instDecl843);
                    	    infoDecl70=infoDecl();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_infoDecl.add(infoDecl70.getTree());

                    	    }
                    	    break;
                    	case 2 :
                    	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:339:66: attrAssign
                    	    {
                    	    pushFollow(FOLLOW_attrAssign_in_instDecl847);
                    	    attrAssign71=attrAssign();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_attrAssign.add(attrAssign71.getTree());

                    	    }
                    	    break;
                    	case 3 :
                    	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:339:79: connectAssign
                    	    {
                    	    pushFollow(FOLLOW_connectAssign_in_instDecl851);
                    	    connectAssign72=connectAssign();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_connectAssign.add(connectAssign72.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    RBRACE73=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_instDecl855); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE73);



                    // AST REWRITE
                    // elements: IDENT, attrAssign, infoDecl, connectAssign, IDENT, width
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 340:3: -> ^( INST_DECL ( width )? IDENT IDENT ( infoDecl )* ( attrAssign )* ( connectAssign )* )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:340:6: ^( INST_DECL ( width )? IDENT IDENT ( infoDecl )* ( attrAssign )* ( connectAssign )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INST_DECL, "INST_DECL"), root_1);

                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:340:18: ( width )?
                        if ( stream_width.hasNext() ) {
                            adaptor.addChild(root_1, stream_width.nextTree());

                        }
                        stream_width.reset();
                        adaptor.addChild(root_1, stream_IDENT.nextNode());
                        adaptor.addChild(root_1, stream_IDENT.nextNode());
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:340:37: ( infoDecl )*
                        while ( stream_infoDecl.hasNext() ) {
                            adaptor.addChild(root_1, stream_infoDecl.nextTree());

                        }
                        stream_infoDecl.reset();
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:340:47: ( attrAssign )*
                        while ( stream_attrAssign.hasNext() ) {
                            adaptor.addChild(root_1, stream_attrAssign.nextTree());

                        }
                        stream_attrAssign.reset();
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:340:59: ( connectAssign )*
                        while ( stream_connectAssign.hasNext() ) {
                            adaptor.addChild(root_1, stream_connectAssign.nextTree());

                        }
                        stream_connectAssign.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:342:4: SUBINST ( LPAREN width RPAREN )? IDENT OF IDENT LBRACE ( infoDecl | subAttrAssign | connectAssign )* RBRACE
                    {
                    SUBINST74=(Token)match(input,SUBINST,FOLLOW_SUBINST_in_instDecl887); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SUBINST.add(SUBINST74);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:342:12: ( LPAREN width RPAREN )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==LPAREN) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:342:13: LPAREN width RPAREN
                            {
                            LPAREN75=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_instDecl890); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN75);

                            pushFollow(FOLLOW_width_in_instDecl892);
                            width76=width();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_width.add(width76.getTree());
                            RPAREN77=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_instDecl894); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN77);


                            }
                            break;

                    }

                    IDENT78=(Token)match(input,IDENT,FOLLOW_IDENT_in_instDecl898); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT78);

                    OF79=(Token)match(input,OF,FOLLOW_OF_in_instDecl900); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OF.add(OF79);

                    IDENT80=(Token)match(input,IDENT,FOLLOW_IDENT_in_instDecl902); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT80);

                    LBRACE81=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_instDecl904); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE81);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:342:57: ( infoDecl | subAttrAssign | connectAssign )*
                    loop19:
                    do {
                        int alt19=4;
                        alt19 = dfa19.predict(input);
                        switch (alt19) {
                    	case 1 :
                    	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:342:58: infoDecl
                    	    {
                    	    pushFollow(FOLLOW_infoDecl_in_instDecl907);
                    	    infoDecl82=infoDecl();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_infoDecl.add(infoDecl82.getTree());

                    	    }
                    	    break;
                    	case 2 :
                    	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:342:69: subAttrAssign
                    	    {
                    	    pushFollow(FOLLOW_subAttrAssign_in_instDecl911);
                    	    subAttrAssign83=subAttrAssign();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_subAttrAssign.add(subAttrAssign83.getTree());

                    	    }
                    	    break;
                    	case 3 :
                    	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:342:85: connectAssign
                    	    {
                    	    pushFollow(FOLLOW_connectAssign_in_instDecl915);
                    	    connectAssign84=connectAssign();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_connectAssign.add(connectAssign84.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    RBRACE85=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_instDecl919); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE85);



                    // AST REWRITE
                    // elements: IDENT, width, connectAssign, subAttrAssign, infoDecl, IDENT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 343:3: -> ^( SUBINST_DECL ( width )? IDENT IDENT ( infoDecl )* ( subAttrAssign )* ( connectAssign )* )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:343:6: ^( SUBINST_DECL ( width )? IDENT IDENT ( infoDecl )* ( subAttrAssign )* ( connectAssign )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SUBINST_DECL, "SUBINST_DECL"), root_1);

                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:343:21: ( width )?
                        if ( stream_width.hasNext() ) {
                            adaptor.addChild(root_1, stream_width.nextTree());

                        }
                        stream_width.reset();
                        adaptor.addChild(root_1, stream_IDENT.nextNode());
                        adaptor.addChild(root_1, stream_IDENT.nextNode());
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:343:40: ( infoDecl )*
                        while ( stream_infoDecl.hasNext() ) {
                            adaptor.addChild(root_1, stream_infoDecl.nextTree());

                        }
                        stream_infoDecl.reset();
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:343:50: ( subAttrAssign )*
                        while ( stream_subAttrAssign.hasNext() ) {
                            adaptor.addChild(root_1, stream_subAttrAssign.nextTree());

                        }
                        stream_subAttrAssign.reset();
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:343:65: ( connectAssign )*
                        while ( stream_connectAssign.hasNext() ) {
                            adaptor.addChild(root_1, stream_connectAssign.nextTree());

                        }
                        stream_connectAssign.reset();

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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:346:1: attrAssign : ( NEWATTR )? ( qualifier )? IDENT EQUALS STRING SEMICOLON -> ^( ATTR_ASSIGN ( NEWATTR )? ( qualifier )? IDENT STRING ) ;
    public final PhdlParser.attrAssign_return attrAssign() throws RecognitionException {
        PhdlParser.attrAssign_return retval = new PhdlParser.attrAssign_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NEWATTR86=null;
        Token IDENT88=null;
        Token EQUALS89=null;
        Token STRING90=null;
        Token SEMICOLON91=null;
        PhdlParser.qualifier_return qualifier87 = null;


        CommonTree NEWATTR86_tree=null;
        CommonTree IDENT88_tree=null;
        CommonTree EQUALS89_tree=null;
        CommonTree STRING90_tree=null;
        CommonTree SEMICOLON91_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_NEWATTR=new RewriteRuleTokenStream(adaptor,"token NEWATTR");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_qualifier=new RewriteRuleSubtreeStream(adaptor,"rule qualifier");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:354:2: ( ( NEWATTR )? ( qualifier )? IDENT EQUALS STRING SEMICOLON -> ^( ATTR_ASSIGN ( NEWATTR )? ( qualifier )? IDENT STRING ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:354:4: ( NEWATTR )? ( qualifier )? IDENT EQUALS STRING SEMICOLON
            {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:354:4: ( NEWATTR )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==NEWATTR) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:0:0: NEWATTR
                    {
                    NEWATTR86=(Token)match(input,NEWATTR,FOLLOW_NEWATTR_in_attrAssign956); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NEWATTR.add(NEWATTR86);


                    }
                    break;

            }

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:354:13: ( qualifier )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==THIS) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:0:0: qualifier
                    {
                    pushFollow(FOLLOW_qualifier_in_attrAssign959);
                    qualifier87=qualifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_qualifier.add(qualifier87.getTree());

                    }
                    break;

            }

            IDENT88=(Token)match(input,IDENT,FOLLOW_IDENT_in_attrAssign962); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT88);

            EQUALS89=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attrAssign964); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS89);

            STRING90=(Token)match(input,STRING,FOLLOW_STRING_in_attrAssign966); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(STRING90);

            SEMICOLON91=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attrAssign968); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON91);



            // AST REWRITE
            // elements: IDENT, STRING, NEWATTR, qualifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 355:3: -> ^( ATTR_ASSIGN ( NEWATTR )? ( qualifier )? IDENT STRING )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:355:6: ^( ATTR_ASSIGN ( NEWATTR )? ( qualifier )? IDENT STRING )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ATTR_ASSIGN, "ATTR_ASSIGN"), root_1);

                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:355:20: ( NEWATTR )?
                if ( stream_NEWATTR.hasNext() ) {
                    adaptor.addChild(root_1, stream_NEWATTR.nextNode());

                }
                stream_NEWATTR.reset();
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:355:29: ( qualifier )?
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:358:1: subAttrAssign : ( NEWATTR )? ( qualifier )? ( name PERIOD )* IDENT EQUALS STRING SEMICOLON -> ^( SUBATTR_ASSIGN ( NEWATTR )? ( qualifier )? ( name )* IDENT STRING ) ;
    public final PhdlParser.subAttrAssign_return subAttrAssign() throws RecognitionException {
        PhdlParser.subAttrAssign_return retval = new PhdlParser.subAttrAssign_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NEWATTR92=null;
        Token PERIOD95=null;
        Token IDENT96=null;
        Token EQUALS97=null;
        Token STRING98=null;
        Token SEMICOLON99=null;
        PhdlParser.qualifier_return qualifier93 = null;

        PhdlParser.name_return name94 = null;


        CommonTree NEWATTR92_tree=null;
        CommonTree PERIOD95_tree=null;
        CommonTree IDENT96_tree=null;
        CommonTree EQUALS97_tree=null;
        CommonTree STRING98_tree=null;
        CommonTree SEMICOLON99_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_NEWATTR=new RewriteRuleTokenStream(adaptor,"token NEWATTR");
        RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_name=new RewriteRuleSubtreeStream(adaptor,"rule name");
        RewriteRuleSubtreeStream stream_qualifier=new RewriteRuleSubtreeStream(adaptor,"rule qualifier");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:366:2: ( ( NEWATTR )? ( qualifier )? ( name PERIOD )* IDENT EQUALS STRING SEMICOLON -> ^( SUBATTR_ASSIGN ( NEWATTR )? ( qualifier )? ( name )* IDENT STRING ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:366:4: ( NEWATTR )? ( qualifier )? ( name PERIOD )* IDENT EQUALS STRING SEMICOLON
            {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:366:4: ( NEWATTR )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==NEWATTR) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:0:0: NEWATTR
                    {
                    NEWATTR92=(Token)match(input,NEWATTR,FOLLOW_NEWATTR_in_subAttrAssign1001); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NEWATTR.add(NEWATTR92);


                    }
                    break;

            }

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:366:13: ( qualifier )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==THIS) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:0:0: qualifier
                    {
                    pushFollow(FOLLOW_qualifier_in_subAttrAssign1004);
                    qualifier93=qualifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_qualifier.add(qualifier93.getTree());

                    }
                    break;

            }

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:366:24: ( name PERIOD )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==IDENT) ) {
                    int LA25_1 = input.LA(2);

                    if ( (LA25_1==PERIOD||LA25_1==LPAREN) ) {
                        alt25=1;
                    }


                }


                switch (alt25) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:366:25: name PERIOD
            	    {
            	    pushFollow(FOLLOW_name_in_subAttrAssign1008);
            	    name94=name();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_name.add(name94.getTree());
            	    PERIOD95=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_subAttrAssign1010); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD95);


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            IDENT96=(Token)match(input,IDENT,FOLLOW_IDENT_in_subAttrAssign1014); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT96);

            EQUALS97=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_subAttrAssign1016); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS97);

            STRING98=(Token)match(input,STRING,FOLLOW_STRING_in_subAttrAssign1018); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(STRING98);

            SEMICOLON99=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_subAttrAssign1020); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON99);



            // AST REWRITE
            // elements: IDENT, STRING, NEWATTR, name, qualifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 367:3: -> ^( SUBATTR_ASSIGN ( NEWATTR )? ( qualifier )? ( name )* IDENT STRING )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:367:6: ^( SUBATTR_ASSIGN ( NEWATTR )? ( qualifier )? ( name )* IDENT STRING )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SUBATTR_ASSIGN, "SUBATTR_ASSIGN"), root_1);

                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:367:23: ( NEWATTR )?
                if ( stream_NEWATTR.hasNext() ) {
                    adaptor.addChild(root_1, stream_NEWATTR.nextNode());

                }
                stream_NEWATTR.reset();
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:367:32: ( qualifier )?
                if ( stream_qualifier.hasNext() ) {
                    adaptor.addChild(root_1, stream_qualifier.nextTree());

                }
                stream_qualifier.reset();
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:367:43: ( name )*
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

    public static class connectAssign_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "connectAssign"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:370:1: connectAssign : ( ( COMBINE LPAREN ( qualifier )? operand RPAREN ) | ( qualifier )? operand ) EQUALS concatenation SEMICOLON -> ^( CONNECT_ASSIGN ( COMBINE )? ( qualifier )? operand concatenation ) ;
    public final PhdlParser.connectAssign_return connectAssign() throws RecognitionException {
        PhdlParser.connectAssign_return retval = new PhdlParser.connectAssign_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMBINE100=null;
        Token LPAREN101=null;
        Token RPAREN104=null;
        Token EQUALS107=null;
        Token SEMICOLON109=null;
        PhdlParser.qualifier_return qualifier102 = null;

        PhdlParser.operand_return operand103 = null;

        PhdlParser.qualifier_return qualifier105 = null;

        PhdlParser.operand_return operand106 = null;

        PhdlParser.concatenation_return concatenation108 = null;


        CommonTree COMBINE100_tree=null;
        CommonTree LPAREN101_tree=null;
        CommonTree RPAREN104_tree=null;
        CommonTree EQUALS107_tree=null;
        CommonTree SEMICOLON109_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_COMBINE=new RewriteRuleTokenStream(adaptor,"token COMBINE");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_qualifier=new RewriteRuleSubtreeStream(adaptor,"rule qualifier");
        RewriteRuleSubtreeStream stream_operand=new RewriteRuleSubtreeStream(adaptor,"rule operand");
        RewriteRuleSubtreeStream stream_concatenation=new RewriteRuleSubtreeStream(adaptor,"rule concatenation");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:371:2: ( ( ( COMBINE LPAREN ( qualifier )? operand RPAREN ) | ( qualifier )? operand ) EQUALS concatenation SEMICOLON -> ^( CONNECT_ASSIGN ( COMBINE )? ( qualifier )? operand concatenation ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:371:4: ( ( COMBINE LPAREN ( qualifier )? operand RPAREN ) | ( qualifier )? operand ) EQUALS concatenation SEMICOLON
            {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:371:4: ( ( COMBINE LPAREN ( qualifier )? operand RPAREN ) | ( qualifier )? operand )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==COMBINE) ) {
                alt28=1;
            }
            else if ( (LA28_0==THIS||LA28_0==IDENT) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:371:5: ( COMBINE LPAREN ( qualifier )? operand RPAREN )
                    {
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:371:5: ( COMBINE LPAREN ( qualifier )? operand RPAREN )
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:371:6: COMBINE LPAREN ( qualifier )? operand RPAREN
                    {
                    COMBINE100=(Token)match(input,COMBINE,FOLLOW_COMBINE_in_connectAssign1054); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COMBINE.add(COMBINE100);

                    LPAREN101=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_connectAssign1056); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN101);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:371:21: ( qualifier )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==THIS) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:0:0: qualifier
                            {
                            pushFollow(FOLLOW_qualifier_in_connectAssign1058);
                            qualifier102=qualifier();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_qualifier.add(qualifier102.getTree());

                            }
                            break;

                    }

                    pushFollow(FOLLOW_operand_in_connectAssign1061);
                    operand103=operand();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_operand.add(operand103.getTree());
                    RPAREN104=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_connectAssign1063); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN104);


                    }


                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:371:50: ( qualifier )? operand
                    {
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:371:50: ( qualifier )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==THIS) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:0:0: qualifier
                            {
                            pushFollow(FOLLOW_qualifier_in_connectAssign1068);
                            qualifier105=qualifier();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_qualifier.add(qualifier105.getTree());

                            }
                            break;

                    }

                    pushFollow(FOLLOW_operand_in_connectAssign1071);
                    operand106=operand();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_operand.add(operand106.getTree());

                    }
                    break;

            }

            EQUALS107=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_connectAssign1074); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS107);

            pushFollow(FOLLOW_concatenation_in_connectAssign1076);
            concatenation108=concatenation();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_concatenation.add(concatenation108.getTree());
            SEMICOLON109=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_connectAssign1078); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON109);



            // AST REWRITE
            // elements: operand, concatenation, qualifier, COMBINE
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 372:3: -> ^( CONNECT_ASSIGN ( COMBINE )? ( qualifier )? operand concatenation )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:372:6: ^( CONNECT_ASSIGN ( COMBINE )? ( qualifier )? operand concatenation )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONNECT_ASSIGN, "CONNECT_ASSIGN"), root_1);

                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:372:23: ( COMBINE )?
                if ( stream_COMBINE.hasNext() ) {
                    adaptor.addChild(root_1, stream_COMBINE.nextNode());

                }
                stream_COMBINE.reset();
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:372:32: ( qualifier )?
                if ( stream_qualifier.hasNext() ) {
                    adaptor.addChild(root_1, stream_qualifier.nextTree());

                }
                stream_qualifier.reset();
                adaptor.addChild(root_1, stream_operand.nextTree());
                adaptor.addChild(root_1, stream_concatenation.nextTree());

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

    public static class netAssign_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "netAssign"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:375:1: netAssign : operand EQUALS concatenation SEMICOLON -> ^( NET_ASSIGN operand concatenation ) ;
    public final PhdlParser.netAssign_return netAssign() throws RecognitionException {
        PhdlParser.netAssign_return retval = new PhdlParser.netAssign_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQUALS111=null;
        Token SEMICOLON113=null;
        PhdlParser.operand_return operand110 = null;

        PhdlParser.concatenation_return concatenation112 = null;


        CommonTree EQUALS111_tree=null;
        CommonTree SEMICOLON113_tree=null;
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleSubtreeStream stream_operand=new RewriteRuleSubtreeStream(adaptor,"rule operand");
        RewriteRuleSubtreeStream stream_concatenation=new RewriteRuleSubtreeStream(adaptor,"rule concatenation");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:381:2: ( operand EQUALS concatenation SEMICOLON -> ^( NET_ASSIGN operand concatenation ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:381:4: operand EQUALS concatenation SEMICOLON
            {
            pushFollow(FOLLOW_operand_in_netAssign1111);
            operand110=operand();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_operand.add(operand110.getTree());
            EQUALS111=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_netAssign1113); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS111);

            pushFollow(FOLLOW_concatenation_in_netAssign1115);
            concatenation112=concatenation();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_concatenation.add(concatenation112.getTree());
            SEMICOLON113=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netAssign1117); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON113);



            // AST REWRITE
            // elements: concatenation, operand
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 381:43: -> ^( NET_ASSIGN operand concatenation )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:381:46: ^( NET_ASSIGN operand concatenation )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NET_ASSIGN, "NET_ASSIGN"), root_1);

                adaptor.addChild(root_1, stream_operand.nextTree());
                adaptor.addChild(root_1, stream_concatenation.nextTree());

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
    // $ANTLR end "netAssign"

    public static class groupDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "groupDecl"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:384:1: groupDecl : GROUP STRING LBRACE ( groupBody )* RBRACE -> ^( GROUP_DECL STRING ( groupBody )* ) ;
    public final PhdlParser.groupDecl_return groupDecl() throws RecognitionException {
        PhdlParser.groupDecl_return retval = new PhdlParser.groupDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token GROUP114=null;
        Token STRING115=null;
        Token LBRACE116=null;
        Token RBRACE118=null;
        PhdlParser.groupBody_return groupBody117 = null;


        CommonTree GROUP114_tree=null;
        CommonTree STRING115_tree=null;
        CommonTree LBRACE116_tree=null;
        CommonTree RBRACE118_tree=null;
        RewriteRuleTokenStream stream_GROUP=new RewriteRuleTokenStream(adaptor,"token GROUP");
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_groupBody=new RewriteRuleSubtreeStream(adaptor,"rule groupBody");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:391:2: ( GROUP STRING LBRACE ( groupBody )* RBRACE -> ^( GROUP_DECL STRING ( groupBody )* ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:391:5: GROUP STRING LBRACE ( groupBody )* RBRACE
            {
            GROUP114=(Token)match(input,GROUP,FOLLOW_GROUP_in_groupDecl1142); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_GROUP.add(GROUP114);

            STRING115=(Token)match(input,STRING,FOLLOW_STRING_in_groupDecl1144); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(STRING115);

            LBRACE116=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_groupDecl1146); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE116);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:391:25: ( groupBody )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=INST && LA29_0<=SUBINST)||LA29_0==THIS||LA29_0==NET||(LA29_0>=INFO && LA29_0<=PORT)||LA29_0==IDENT) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:0:0: groupBody
            	    {
            	    pushFollow(FOLLOW_groupBody_in_groupDecl1148);
            	    groupBody117=groupBody();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_groupBody.add(groupBody117.getTree());

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            RBRACE118=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_groupDecl1151); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE118);



            // AST REWRITE
            // elements: groupBody, STRING
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 391:43: -> ^( GROUP_DECL STRING ( groupBody )* )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:391:46: ^( GROUP_DECL STRING ( groupBody )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(GROUP_DECL, "GROUP_DECL"), root_1);

                adaptor.addChild(root_1, stream_STRING.nextNode());
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:391:66: ( groupBody )*
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:394:1: groupBody : ( infoDecl | connectDecl | instDecl | netAssign );
    public final PhdlParser.groupBody_return groupBody() throws RecognitionException {
        PhdlParser.groupBody_return retval = new PhdlParser.groupBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        PhdlParser.infoDecl_return infoDecl119 = null;

        PhdlParser.connectDecl_return connectDecl120 = null;

        PhdlParser.instDecl_return instDecl121 = null;

        PhdlParser.netAssign_return netAssign122 = null;



        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:400:2: ( infoDecl | connectDecl | instDecl | netAssign )
            int alt30=4;
            switch ( input.LA(1) ) {
            case THIS:
            case INFO:
                {
                alt30=1;
                }
                break;
            case NET:
            case PORT:
                {
                alt30=2;
                }
                break;
            case INST:
            case SUBINST:
                {
                alt30=3;
                }
                break;
            case IDENT:
                {
                alt30=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:400:4: infoDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_infoDecl_in_groupBody1176);
                    infoDecl119=infoDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, infoDecl119.getTree());

                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:401:4: connectDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_connectDecl_in_groupBody1181);
                    connectDecl120=connectDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, connectDecl120.getTree());

                    }
                    break;
                case 3 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:402:4: instDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_instDecl_in_groupBody1186);
                    instDecl121=instDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, instDecl121.getTree());

                    }
                    break;
                case 4 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:403:4: netAssign
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_netAssign_in_groupBody1191);
                    netAssign122=netAssign();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, netAssign122.getTree());

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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:406:1: width : INT COLON INT -> ^( WIDTH INT INT ) ;
    public final PhdlParser.width_return width() throws RecognitionException {
        PhdlParser.width_return retval = new PhdlParser.width_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INT123=null;
        Token COLON124=null;
        Token INT125=null;

        CommonTree INT123_tree=null;
        CommonTree COLON124_tree=null;
        CommonTree INT125_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:413:2: ( INT COLON INT -> ^( WIDTH INT INT ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:413:4: INT COLON INT
            {
            INT123=(Token)match(input,INT,FOLLOW_INT_in_width1204); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INT.add(INT123);

            COLON124=(Token)match(input,COLON,FOLLOW_COLON_in_width1206); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON124);

            INT125=(Token)match(input,INT,FOLLOW_INT_in_width1208); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INT.add(INT125);



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
            // 413:18: -> ^( WIDTH INT INT )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:413:21: ^( WIDTH INT INT )
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:417:1: pinType : ( PIN -> ^( PIN_TYPE PIN ) | INPIN -> ^( PIN_TYPE INPIN ) | OUTPIN -> ^( PIN_TYPE OUTPIN ) | IOPIN -> ^( PIN_TYPE IOPIN ) | PWRPIN -> ^( PIN_TYPE PWRPIN ) | SUPPIN -> ^( PIN_TYPE SUPPIN ) ) ;
    public final PhdlParser.pinType_return pinType() throws RecognitionException {
        PhdlParser.pinType_return retval = new PhdlParser.pinType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PIN126=null;
        Token INPIN127=null;
        Token OUTPIN128=null;
        Token IOPIN129=null;
        Token PWRPIN130=null;
        Token SUPPIN131=null;

        CommonTree PIN126_tree=null;
        CommonTree INPIN127_tree=null;
        CommonTree OUTPIN128_tree=null;
        CommonTree IOPIN129_tree=null;
        CommonTree PWRPIN130_tree=null;
        CommonTree SUPPIN131_tree=null;
        RewriteRuleTokenStream stream_INPIN=new RewriteRuleTokenStream(adaptor,"token INPIN");
        RewriteRuleTokenStream stream_SUPPIN=new RewriteRuleTokenStream(adaptor,"token SUPPIN");
        RewriteRuleTokenStream stream_IOPIN=new RewriteRuleTokenStream(adaptor,"token IOPIN");
        RewriteRuleTokenStream stream_OUTPIN=new RewriteRuleTokenStream(adaptor,"token OUTPIN");
        RewriteRuleTokenStream stream_PIN=new RewriteRuleTokenStream(adaptor,"token PIN");
        RewriteRuleTokenStream stream_PWRPIN=new RewriteRuleTokenStream(adaptor,"token PWRPIN");

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:422:2: ( ( PIN -> ^( PIN_TYPE PIN ) | INPIN -> ^( PIN_TYPE INPIN ) | OUTPIN -> ^( PIN_TYPE OUTPIN ) | IOPIN -> ^( PIN_TYPE IOPIN ) | PWRPIN -> ^( PIN_TYPE PWRPIN ) | SUPPIN -> ^( PIN_TYPE SUPPIN ) ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:422:4: ( PIN -> ^( PIN_TYPE PIN ) | INPIN -> ^( PIN_TYPE INPIN ) | OUTPIN -> ^( PIN_TYPE OUTPIN ) | IOPIN -> ^( PIN_TYPE IOPIN ) | PWRPIN -> ^( PIN_TYPE PWRPIN ) | SUPPIN -> ^( PIN_TYPE SUPPIN ) )
            {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:422:4: ( PIN -> ^( PIN_TYPE PIN ) | INPIN -> ^( PIN_TYPE INPIN ) | OUTPIN -> ^( PIN_TYPE OUTPIN ) | IOPIN -> ^( PIN_TYPE IOPIN ) | PWRPIN -> ^( PIN_TYPE PWRPIN ) | SUPPIN -> ^( PIN_TYPE SUPPIN ) )
            int alt31=6;
            switch ( input.LA(1) ) {
            case PIN:
                {
                alt31=1;
                }
                break;
            case INPIN:
                {
                alt31=2;
                }
                break;
            case OUTPIN:
                {
                alt31=3;
                }
                break;
            case IOPIN:
                {
                alt31=4;
                }
                break;
            case PWRPIN:
                {
                alt31=5;
                }
                break;
            case SUPPIN:
                {
                alt31=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:422:5: PIN
                    {
                    PIN126=(Token)match(input,PIN,FOLLOW_PIN_in_pinType1234); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PIN.add(PIN126);



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
                    // 422:9: -> ^( PIN_TYPE PIN )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:422:12: ^( PIN_TYPE PIN )
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
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:423:4: INPIN
                    {
                    INPIN127=(Token)match(input,INPIN,FOLLOW_INPIN_in_pinType1247); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INPIN.add(INPIN127);



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
                    // 423:10: -> ^( PIN_TYPE INPIN )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:423:13: ^( PIN_TYPE INPIN )
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
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:424:4: OUTPIN
                    {
                    OUTPIN128=(Token)match(input,OUTPIN,FOLLOW_OUTPIN_in_pinType1260); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OUTPIN.add(OUTPIN128);



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
                    // 424:11: -> ^( PIN_TYPE OUTPIN )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:424:14: ^( PIN_TYPE OUTPIN )
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
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:425:4: IOPIN
                    {
                    IOPIN129=(Token)match(input,IOPIN,FOLLOW_IOPIN_in_pinType1273); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IOPIN.add(IOPIN129);



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
                    // 425:10: -> ^( PIN_TYPE IOPIN )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:425:13: ^( PIN_TYPE IOPIN )
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
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:426:4: PWRPIN
                    {
                    PWRPIN130=(Token)match(input,PWRPIN,FOLLOW_PWRPIN_in_pinType1286); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PWRPIN.add(PWRPIN130);



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
                    // 426:11: -> ^( PIN_TYPE PWRPIN )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:426:14: ^( PIN_TYPE PWRPIN )
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
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:427:4: SUPPIN
                    {
                    SUPPIN131=(Token)match(input,SUPPIN,FOLLOW_SUPPIN_in_pinType1299); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SUPPIN.add(SUPPIN131);



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
                    // 427:11: -> ^( PIN_TYPE SUPPIN )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:427:14: ^( PIN_TYPE SUPPIN )
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:430:1: pinList : LBRACE pinNumber ( COMMA pinNumber )* RBRACE -> ^( PIN_LIST ( pinNumber )+ ) ;
    public final PhdlParser.pinList_return pinList() throws RecognitionException {
        PhdlParser.pinList_return retval = new PhdlParser.pinList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACE132=null;
        Token COMMA134=null;
        Token RBRACE136=null;
        PhdlParser.pinNumber_return pinNumber133 = null;

        PhdlParser.pinNumber_return pinNumber135 = null;


        CommonTree LBRACE132_tree=null;
        CommonTree COMMA134_tree=null;
        CommonTree RBRACE136_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_pinNumber=new RewriteRuleSubtreeStream(adaptor,"rule pinNumber");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:435:2: ( LBRACE pinNumber ( COMMA pinNumber )* RBRACE -> ^( PIN_LIST ( pinNumber )+ ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:435:5: LBRACE pinNumber ( COMMA pinNumber )* RBRACE
            {
            LBRACE132=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_pinList1322); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE132);

            pushFollow(FOLLOW_pinNumber_in_pinList1324);
            pinNumber133=pinNumber();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_pinNumber.add(pinNumber133.getTree());
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:435:22: ( COMMA pinNumber )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==COMMA) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:435:23: COMMA pinNumber
            	    {
            	    COMMA134=(Token)match(input,COMMA,FOLLOW_COMMA_in_pinList1327); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA134);

            	    pushFollow(FOLLOW_pinNumber_in_pinList1329);
            	    pinNumber135=pinNumber();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_pinNumber.add(pinNumber135.getTree());

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            RBRACE136=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_pinList1333); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE136);



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
            // 435:48: -> ^( PIN_LIST ( pinNumber )+ )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:435:51: ^( PIN_LIST ( pinNumber )+ )
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:438:1: pinNumber : ( IDENT | INT | PINNUM );
    public final PhdlParser.pinNumber_return pinNumber() throws RecognitionException {
        PhdlParser.pinNumber_return retval = new PhdlParser.pinNumber_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set137=null;

        CommonTree set137_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:444:2: ( IDENT | INT | PINNUM )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set137=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||(input.LA(1)>=INT && input.LA(1)<=PINNUM) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set137));
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:447:1: qualifier : THIS LPAREN index RPAREN PERIOD ;
    public final PhdlParser.qualifier_return qualifier() throws RecognitionException {
        PhdlParser.qualifier_return retval = new PhdlParser.qualifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token THIS138=null;
        Token LPAREN139=null;
        Token RPAREN141=null;
        Token PERIOD142=null;
        PhdlParser.index_return index140 = null;


        CommonTree THIS138_tree=null;
        CommonTree LPAREN139_tree=null;
        CommonTree RPAREN141_tree=null;
        CommonTree PERIOD142_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:453:2: ( THIS LPAREN index RPAREN PERIOD )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:453:4: THIS LPAREN index RPAREN PERIOD
            {
            root_0 = (CommonTree)adaptor.nil();

            THIS138=(Token)match(input,THIS,FOLLOW_THIS_in_qualifier1378); if (state.failed) return retval;
            LPAREN139=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_qualifier1381); if (state.failed) return retval;
            pushFollow(FOLLOW_index_in_qualifier1384);
            index140=index();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, index140.getTree());
            RPAREN141=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_qualifier1386); if (state.failed) return retval;
            PERIOD142=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_qualifier1389); if (state.failed) return retval;

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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:456:1: index : ( INT COLON INT -> ^( BOUNDS INT INT ) | INT ( COMMA INT ( COMMA INT )* )? -> ^( INDICES ( INT )+ ) );
    public final PhdlParser.index_return index() throws RecognitionException {
        PhdlParser.index_return retval = new PhdlParser.index_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INT143=null;
        Token COLON144=null;
        Token INT145=null;
        Token INT146=null;
        Token COMMA147=null;
        Token INT148=null;
        Token COMMA149=null;
        Token INT150=null;

        CommonTree INT143_tree=null;
        CommonTree COLON144_tree=null;
        CommonTree INT145_tree=null;
        CommonTree INT146_tree=null;
        CommonTree COMMA147_tree=null;
        CommonTree INT148_tree=null;
        CommonTree COMMA149_tree=null;
        CommonTree INT150_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:463:2: ( INT COLON INT -> ^( BOUNDS INT INT ) | INT ( COMMA INT ( COMMA INT )* )? -> ^( INDICES ( INT )+ ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==INT) ) {
                int LA35_1 = input.LA(2);

                if ( (LA35_1==COLON) ) {
                    alt35=1;
                }
                else if ( (LA35_1==COMMA||LA35_1==RPAREN||LA35_1==RBRACKET) ) {
                    alt35=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:463:4: INT COLON INT
                    {
                    INT143=(Token)match(input,INT,FOLLOW_INT_in_index1404); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT143);

                    COLON144=(Token)match(input,COLON,FOLLOW_COLON_in_index1406); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON144);

                    INT145=(Token)match(input,INT,FOLLOW_INT_in_index1408); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT145);



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
                    // 463:22: -> ^( BOUNDS INT INT )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:463:25: ^( BOUNDS INT INT )
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
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:464:5: INT ( COMMA INT ( COMMA INT )* )?
                    {
                    INT146=(Token)match(input,INT,FOLLOW_INT_in_index1428); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT146);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:464:9: ( COMMA INT ( COMMA INT )* )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==COMMA) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:464:10: COMMA INT ( COMMA INT )*
                            {
                            COMMA147=(Token)match(input,COMMA,FOLLOW_COMMA_in_index1431); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_COMMA.add(COMMA147);

                            INT148=(Token)match(input,INT,FOLLOW_INT_in_index1433); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_INT.add(INT148);

                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:464:20: ( COMMA INT )*
                            loop33:
                            do {
                                int alt33=2;
                                int LA33_0 = input.LA(1);

                                if ( (LA33_0==COMMA) ) {
                                    alt33=1;
                                }


                                switch (alt33) {
                            	case 1 :
                            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:464:21: COMMA INT
                            	    {
                            	    COMMA149=(Token)match(input,COMMA,FOLLOW_COMMA_in_index1436); if (state.failed) return retval; 
                            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA149);

                            	    INT150=(Token)match(input,INT,FOLLOW_INT_in_index1438); if (state.failed) return retval; 
                            	    if ( state.backtracking==0 ) stream_INT.add(INT150);


                            	    }
                            	    break;

                            	default :
                            	    break loop33;
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
                    // 464:35: -> ^( INDICES ( INT )+ )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:464:38: ^( INDICES ( INT )+ )
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

    public static class concatenation_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "concatenation"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:467:1: concatenation : ( operand ( AMPERSAND operand )* -> ^( CONCAT_LIST ( operand )+ ) | LANGLE operand RANGLE -> ^( CONCAT_REPL operand ) | OPEN -> ^( CONCAT_OPEN ) );
    public final PhdlParser.concatenation_return concatenation() throws RecognitionException {
        PhdlParser.concatenation_return retval = new PhdlParser.concatenation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AMPERSAND152=null;
        Token LANGLE154=null;
        Token RANGLE156=null;
        Token OPEN157=null;
        PhdlParser.operand_return operand151 = null;

        PhdlParser.operand_return operand153 = null;

        PhdlParser.operand_return operand155 = null;


        CommonTree AMPERSAND152_tree=null;
        CommonTree LANGLE154_tree=null;
        CommonTree RANGLE156_tree=null;
        CommonTree OPEN157_tree=null;
        RewriteRuleTokenStream stream_OPEN=new RewriteRuleTokenStream(adaptor,"token OPEN");
        RewriteRuleTokenStream stream_AMPERSAND=new RewriteRuleTokenStream(adaptor,"token AMPERSAND");
        RewriteRuleTokenStream stream_RANGLE=new RewriteRuleTokenStream(adaptor,"token RANGLE");
        RewriteRuleTokenStream stream_LANGLE=new RewriteRuleTokenStream(adaptor,"token LANGLE");
        RewriteRuleSubtreeStream stream_operand=new RewriteRuleSubtreeStream(adaptor,"rule operand");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:474:2: ( operand ( AMPERSAND operand )* -> ^( CONCAT_LIST ( operand )+ ) | LANGLE operand RANGLE -> ^( CONCAT_REPL operand ) | OPEN -> ^( CONCAT_OPEN ) )
            int alt37=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt37=1;
                }
                break;
            case LANGLE:
                {
                alt37=2;
                }
                break;
            case OPEN:
                {
                alt37=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:474:4: operand ( AMPERSAND operand )*
                    {
                    pushFollow(FOLLOW_operand_in_concatenation1465);
                    operand151=operand();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_operand.add(operand151.getTree());
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:474:12: ( AMPERSAND operand )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==AMPERSAND) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:474:13: AMPERSAND operand
                    	    {
                    	    AMPERSAND152=(Token)match(input,AMPERSAND,FOLLOW_AMPERSAND_in_concatenation1468); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_AMPERSAND.add(AMPERSAND152);

                    	    pushFollow(FOLLOW_operand_in_concatenation1470);
                    	    operand153=operand();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_operand.add(operand153.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop36;
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
                    // 474:34: -> ^( CONCAT_LIST ( operand )+ )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:474:37: ^( CONCAT_LIST ( operand )+ )
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
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:475:4: LANGLE operand RANGLE
                    {
                    LANGLE154=(Token)match(input,LANGLE,FOLLOW_LANGLE_in_concatenation1488); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LANGLE.add(LANGLE154);

                    pushFollow(FOLLOW_operand_in_concatenation1490);
                    operand155=operand();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_operand.add(operand155.getTree());
                    RANGLE156=(Token)match(input,RANGLE,FOLLOW_RANGLE_in_concatenation1492); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RANGLE.add(RANGLE156);



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
                    // 475:28: -> ^( CONCAT_REPL operand )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:475:31: ^( CONCAT_REPL operand )
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
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:476:5: OPEN
                    {
                    OPEN157=(Token)match(input,OPEN,FOLLOW_OPEN_in_concatenation1508); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN.add(OPEN157);



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
                    // 476:16: -> ^( CONCAT_OPEN )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:476:19: ^( CONCAT_OPEN )
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
    // $ANTLR end "concatenation"

    public static class operand_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "operand"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:479:1: operand : IDENT ( LBRACKET index RBRACKET )? -> ^( OPERAND IDENT ( index )? ) ;
    public final PhdlParser.operand_return operand() throws RecognitionException {
        PhdlParser.operand_return retval = new PhdlParser.operand_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT158=null;
        Token LBRACKET159=null;
        Token RBRACKET161=null;
        PhdlParser.index_return index160 = null;


        CommonTree IDENT158_tree=null;
        CommonTree LBRACKET159_tree=null;
        CommonTree RBRACKET161_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleSubtreeStream stream_index=new RewriteRuleSubtreeStream(adaptor,"rule index");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:485:2: ( IDENT ( LBRACKET index RBRACKET )? -> ^( OPERAND IDENT ( index )? ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:485:4: IDENT ( LBRACKET index RBRACKET )?
            {
            IDENT158=(Token)match(input,IDENT,FOLLOW_IDENT_in_operand1533); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT158);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:485:10: ( LBRACKET index RBRACKET )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==LBRACKET) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:485:11: LBRACKET index RBRACKET
                    {
                    LBRACKET159=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_operand1536); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET159);

                    pushFollow(FOLLOW_index_in_operand1538);
                    index160=index();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_index.add(index160.getTree());
                    RBRACKET161=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_operand1540); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET161);


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
            // 485:37: -> ^( OPERAND IDENT ( index )? )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:485:40: ^( OPERAND IDENT ( index )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPERAND, "OPERAND"), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:485:56: ( index )?
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:488:1: name : IDENT ( LPAREN index RPAREN )? -> ^( NAME IDENT ( index )? ) ;
    public final PhdlParser.name_return name() throws RecognitionException {
        PhdlParser.name_return retval = new PhdlParser.name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT162=null;
        Token LPAREN163=null;
        Token RPAREN165=null;
        PhdlParser.index_return index164 = null;


        CommonTree IDENT162_tree=null;
        CommonTree LPAREN163_tree=null;
        CommonTree RPAREN165_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_index=new RewriteRuleSubtreeStream(adaptor,"rule index");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:494:2: ( IDENT ( LPAREN index RPAREN )? -> ^( NAME IDENT ( index )? ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:494:4: IDENT ( LPAREN index RPAREN )?
            {
            IDENT162=(Token)match(input,IDENT,FOLLOW_IDENT_in_name1567); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT162);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:494:10: ( LPAREN index RPAREN )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==LPAREN) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:494:11: LPAREN index RPAREN
                    {
                    LPAREN163=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_name1570); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN163);

                    pushFollow(FOLLOW_index_in_name1572);
                    index164=index();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_index.add(index164.getTree());
                    RPAREN165=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_name1574); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN165);


                    }
                    break;

            }



            // AST REWRITE
            // elements: index, IDENT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 494:33: -> ^( NAME IDENT ( index )? )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:494:36: ^( NAME IDENT ( index )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAME, "NAME"), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:494:49: ( index )?
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
    protected DFA19 dfa19 = new DFA19(this);
    static final String DFA17_eotS =
        "\22\uffff";
    static final String DFA17_eofS =
        "\22\uffff";
    static final String DFA17_minS =
        "\1\16\1\uffff\1\11\2\uffff\1\10\1\uffff\1\106\1\17\1\5\2\106\1\7"+
        "\1\12\1\6\1\42\1\106\1\6";
    static final String DFA17_maxS =
        "\1\104\1\uffff\1\11\2\uffff\1\13\1\uffff\1\106\1\105\1\12\2\106"+
        "\1\7\2\12\1\104\1\106\1\12";
    static final String DFA17_acceptS =
        "\1\uffff\1\4\1\uffff\1\1\1\2\1\uffff\1\3\13\uffff";
    static final String DFA17_specialS =
        "\22\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\1\12\uffff\1\2\3\uffff\1\4\2\uffff\1\6\1\uffff\1\3\41\uffff"+
            "\1\5",
            "",
            "\1\7",
            "",
            "",
            "\1\10\2\uffff\1\6",
            "",
            "\1\11",
            "\1\6\24\uffff\1\6\37\uffff\1\6\1\4",
            "\1\12\1\13\3\uffff\1\14",
            "\1\15",
            "\1\16",
            "\1\17",
            "\1\14",
            "\1\20\3\uffff\1\14",
            "\1\3\41\uffff\1\5",
            "\1\21",
            "\1\20\3\uffff\1\14"
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
            return "()* loopback of 339:54: ( infoDecl | attrAssign | connectAssign )*";
        }
    }
    static final String DFA19_eotS =
        "\22\uffff";
    static final String DFA19_eofS =
        "\22\uffff";
    static final String DFA19_minS =
        "\1\16\1\uffff\1\11\2\uffff\1\7\1\uffff\1\106\1\17\1\5\2\106\1\7"+
        "\1\12\1\6\1\42\1\106\1\6";
    static final String DFA19_maxS =
        "\1\104\1\uffff\1\11\2\uffff\1\13\1\uffff\1\106\1\105\1\12\2\106"+
        "\1\7\2\12\1\104\1\106\1\12";
    static final String DFA19_acceptS =
        "\1\uffff\1\4\1\uffff\1\1\1\2\1\uffff\1\3\13\uffff";
    static final String DFA19_specialS =
        "\22\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\1\12\uffff\1\2\3\uffff\1\4\2\uffff\1\6\1\uffff\1\3\41\uffff"+
            "\1\5",
            "",
            "\1\7",
            "",
            "",
            "\1\4\1\10\1\4\1\uffff\1\6",
            "",
            "\1\11",
            "\1\6\24\uffff\1\6\37\uffff\1\6\1\4",
            "\1\12\1\13\3\uffff\1\14",
            "\1\15",
            "\1\16",
            "\1\17",
            "\1\14",
            "\1\20\3\uffff\1\14",
            "\1\3\41\uffff\1\5",
            "\1\21",
            "\1\20\3\uffff\1\14"
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "()* loopback of 342:57: ( infoDecl | subAttrAssign | connectAssign )*";
        }
    }
 

    public static final BitSet FOLLOW_deviceDecl_in_sourceText439 = new BitSet(new long[]{0x0000000000380002L});
    public static final BitSet FOLLOW_designDecl_in_sourceText443 = new BitSet(new long[]{0x0000000000380002L});
    public static final BitSet FOLLOW_DEVICE_in_deviceDecl458 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl460 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACE_in_deviceDecl462 = new BitSet(new long[]{0x000007E412004000L});
    public static final BitSet FOLLOW_infoDecl_in_deviceDecl465 = new BitSet(new long[]{0x000007E412004000L});
    public static final BitSet FOLLOW_attrDecl_in_deviceDecl469 = new BitSet(new long[]{0x000007E412004000L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl473 = new BitSet(new long[]{0x000007E412004000L});
    public static final BitSet FOLLOW_RBRACE_in_deviceDecl477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ATTR_in_attrDecl511 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attrDecl513 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_attrDecl515 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_STRING_in_attrDecl517 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SEMICOLON_in_attrDecl519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pinType_in_pinDecl542 = new BitSet(new long[]{0x0000000000000800L,0x0000000000000010L});
    public static final BitSet FOLLOW_LBRACKET_in_pinDecl545 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_width_in_pinDecl547 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RBRACKET_in_pinDecl549 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl553 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_pinDecl555 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_pinList_in_pinDecl557 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinDecl559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESIGN_in_designDecl591 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_designDecl593 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACE_in_designDecl595 = new BitSet(new long[]{0x0000000C0BC04000L,0x0000000000000010L});
    public static final BitSet FOLLOW_designBody_in_designDecl597 = new BitSet(new long[]{0x0000000C0BC04000L,0x0000000000000010L});
    public static final BitSet FOLLOW_RBRACE_in_designDecl600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUBDESIGN_in_designDecl616 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_designDecl618 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACE_in_designDecl620 = new BitSet(new long[]{0x0000000C0BC04000L,0x0000000000000010L});
    public static final BitSet FOLLOW_designBody_in_designDecl622 = new BitSet(new long[]{0x0000000C0BC04000L,0x0000000000000010L});
    public static final BitSet FOLLOW_RBRACE_in_designDecl625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_infoDecl_in_designBody650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_connectDecl_in_designBody655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instDecl_in_designBody660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_netAssign_in_designBody665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_groupDecl_in_designBody670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifier_in_infoDecl683 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_INFO_in_infoDecl686 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACE_in_infoDecl688 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_STRING_in_infoDecl690 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACE_in_infoDecl692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NET_in_connectDecl716 = new BitSet(new long[]{0x0000000000000800L,0x0000000000000010L});
    public static final BitSet FOLLOW_LBRACKET_in_connectDecl719 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_width_in_connectDecl721 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RBRACKET_in_connectDecl723 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_connectDecl727 = new BitSet(new long[]{0x0000000000002050L});
    public static final BitSet FOLLOW_COMMA_in_connectDecl730 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_connectDecl732 = new BitSet(new long[]{0x0000000000002050L});
    public static final BitSet FOLLOW_LBRACE_in_connectDecl738 = new BitSet(new long[]{0x0000000010004000L});
    public static final BitSet FOLLOW_attrDecl_in_connectDecl740 = new BitSet(new long[]{0x0000000010004000L});
    public static final BitSet FOLLOW_RBRACE_in_connectDecl743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_connectDecl748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PORT_in_connectDecl775 = new BitSet(new long[]{0x0000000000000800L,0x0000000000000010L});
    public static final BitSet FOLLOW_LBRACKET_in_connectDecl778 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_width_in_connectDecl780 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RBRACKET_in_connectDecl782 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_connectDecl786 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_COMMA_in_connectDecl789 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_connectDecl791 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_SEMICOLON_in_connectDecl795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INST_in_instDecl823 = new BitSet(new long[]{0x0000000000000200L,0x0000000000000010L});
    public static final BitSet FOLLOW_LPAREN_in_instDecl826 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_width_in_instDecl828 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_instDecl830 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instDecl834 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_OF_in_instDecl836 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instDecl838 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACE_in_instDecl840 = new BitSet(new long[]{0x0000000522004000L,0x0000000000000010L});
    public static final BitSet FOLLOW_infoDecl_in_instDecl843 = new BitSet(new long[]{0x0000000522004000L,0x0000000000000010L});
    public static final BitSet FOLLOW_attrAssign_in_instDecl847 = new BitSet(new long[]{0x0000000522004000L,0x0000000000000010L});
    public static final BitSet FOLLOW_connectAssign_in_instDecl851 = new BitSet(new long[]{0x0000000522004000L,0x0000000000000010L});
    public static final BitSet FOLLOW_RBRACE_in_instDecl855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUBINST_in_instDecl887 = new BitSet(new long[]{0x0000000000000200L,0x0000000000000010L});
    public static final BitSet FOLLOW_LPAREN_in_instDecl890 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_width_in_instDecl892 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_instDecl894 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instDecl898 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_OF_in_instDecl900 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instDecl902 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACE_in_instDecl904 = new BitSet(new long[]{0x0000000522004000L,0x0000000000000010L});
    public static final BitSet FOLLOW_infoDecl_in_instDecl907 = new BitSet(new long[]{0x0000000522004000L,0x0000000000000010L});
    public static final BitSet FOLLOW_subAttrAssign_in_instDecl911 = new BitSet(new long[]{0x0000000522004000L,0x0000000000000010L});
    public static final BitSet FOLLOW_connectAssign_in_instDecl915 = new BitSet(new long[]{0x0000000522004000L,0x0000000000000010L});
    public static final BitSet FOLLOW_RBRACE_in_instDecl919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWATTR_in_attrAssign956 = new BitSet(new long[]{0x0000000002000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_qualifier_in_attrAssign959 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attrAssign962 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_attrAssign964 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_STRING_in_attrAssign966 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SEMICOLON_in_attrAssign968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWATTR_in_subAttrAssign1001 = new BitSet(new long[]{0x0000000002000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_qualifier_in_subAttrAssign1004 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_name_in_subAttrAssign1008 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PERIOD_in_subAttrAssign1010 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_subAttrAssign1014 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_subAttrAssign1016 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_STRING_in_subAttrAssign1018 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SEMICOLON_in_subAttrAssign1020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMBINE_in_connectAssign1054 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_connectAssign1056 = new BitSet(new long[]{0x0000000002000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_qualifier_in_connectAssign1058 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_operand_in_connectAssign1061 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_connectAssign1063 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_qualifier_in_connectAssign1068 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_operand_in_connectAssign1071 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_connectAssign1074 = new BitSet(new long[]{0x0000001000008000L,0x0000000000000010L});
    public static final BitSet FOLLOW_concatenation_in_connectAssign1076 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SEMICOLON_in_connectAssign1078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operand_in_netAssign1111 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_netAssign1113 = new BitSet(new long[]{0x0000001000008000L,0x0000000000000010L});
    public static final BitSet FOLLOW_concatenation_in_netAssign1115 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SEMICOLON_in_netAssign1117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_groupDecl1142 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_STRING_in_groupDecl1144 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACE_in_groupDecl1146 = new BitSet(new long[]{0x0000000C0AC04000L,0x0000000000000010L});
    public static final BitSet FOLLOW_groupBody_in_groupDecl1148 = new BitSet(new long[]{0x0000000C0AC04000L,0x0000000000000010L});
    public static final BitSet FOLLOW_RBRACE_in_groupDecl1151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_infoDecl_in_groupBody1176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_connectDecl_in_groupBody1181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instDecl_in_groupBody1186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_netAssign_in_groupBody1191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_width1204 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_COLON_in_width1206 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_width1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PIN_in_pinType1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INPIN_in_pinType1247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPIN_in_pinType1260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IOPIN_in_pinType1273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PWRPIN_in_pinType1286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUPPIN_in_pinType1299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_pinList1322 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000D0L});
    public static final BitSet FOLLOW_pinNumber_in_pinList1324 = new BitSet(new long[]{0x0000000000004040L});
    public static final BitSet FOLLOW_COMMA_in_pinList1327 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000D0L});
    public static final BitSet FOLLOW_pinNumber_in_pinList1329 = new BitSet(new long[]{0x0000000000004040L});
    public static final BitSet FOLLOW_RBRACE_in_pinList1333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_pinNumber0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THIS_in_qualifier1378 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_qualifier1381 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_index_in_qualifier1384 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_qualifier1386 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PERIOD_in_qualifier1389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_index1404 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_COLON_in_index1406 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_index1408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_index1428 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_COMMA_in_index1431 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_index1433 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_COMMA_in_index1436 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_index1438 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_operand_in_concatenation1465 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_AMPERSAND_in_concatenation1468 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_operand_in_concatenation1470 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_LANGLE_in_concatenation1488 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_operand_in_concatenation1490 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RANGLE_in_concatenation1492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_in_concatenation1508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_operand1533 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_LBRACKET_in_operand1536 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_index_in_operand1538 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RBRACKET_in_operand1540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_name1567 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_LPAREN_in_name1570 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_index_in_name1572 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_name1574 = new BitSet(new long[]{0x0000000000000002L});

}