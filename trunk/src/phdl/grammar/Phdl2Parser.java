// $ANTLR 3.3 Nov 30, 2010 12:50:56 /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g 2012-01-04 12:06:21

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
public class Phdl2Parser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SEMICOLON", "COLON", "COMMA", "PERIOD", "EQUALS", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "LANGLE", "RANGLE", "AMPERSAND", "DBLQUOTE", "DESIGN", "DEVICE", "SUBDESIGN", "INST", "SUBINST", "GROUP", "THIS", "OF", "NET", "ATTR", "NEWATTR", "BEGIN", "END", "COMBINE", "INCLUDE", "INFO", "PIN", "INPIN", "OUTPIN", "IOPIN", "PWRPIN", "SUPPIN", "WIDTH_DECL", "ARRAY_DECL", "DEVICE_DECL", "ATTR_DECL", "PIN_DECL", "PIN_LIST", "PIN_TYPE", "INFO_DECL", "NET_DECL", "NAME_DECL", "DESIGN_DECL", "INST_DECL", "ATTR_ASSIGN", "ATTR_QUAL", "PIN_ASSIGN", "LIST_ARRAY", "LIST_SLICE", "IDENT", "STRING", "INT", "PINNUM", "D", "E", "S", "I", "G", "N", "V", "C", "U", "B", "T", "R", "O", "P", "H", "F", "A", "W", "M", "L", "CHAR", "DIGIT", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "INCLUDE_DECL", "J", "K", "Q", "X", "Y", "Z"
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
    public static final int PIN=35;
    public static final int INPIN=36;
    public static final int OUTPIN=37;
    public static final int IOPIN=38;
    public static final int PWRPIN=39;
    public static final int SUPPIN=40;
    public static final int WIDTH_DECL=41;
    public static final int ARRAY_DECL=42;
    public static final int DEVICE_DECL=43;
    public static final int ATTR_DECL=44;
    public static final int PIN_DECL=45;
    public static final int PIN_LIST=46;
    public static final int PIN_TYPE=47;
    public static final int INFO_DECL=48;
    public static final int NET_DECL=49;
    public static final int NAME_DECL=50;
    public static final int DESIGN_DECL=51;
    public static final int INST_DECL=52;
    public static final int ATTR_ASSIGN=53;
    public static final int ATTR_QUAL=54;
    public static final int PIN_ASSIGN=55;
    public static final int LIST_ARRAY=56;
    public static final int LIST_SLICE=57;
    public static final int IDENT=58;
    public static final int STRING=59;
    public static final int INT=60;
    public static final int PINNUM=61;
    public static final int D=62;
    public static final int E=63;
    public static final int S=64;
    public static final int I=65;
    public static final int G=66;
    public static final int N=67;
    public static final int V=68;
    public static final int C=69;
    public static final int U=70;
    public static final int B=71;
    public static final int T=72;
    public static final int R=73;
    public static final int O=74;
    public static final int P=75;
    public static final int H=76;
    public static final int F=77;
    public static final int A=78;
    public static final int W=79;
    public static final int M=80;
    public static final int L=81;
    public static final int CHAR=82;
    public static final int DIGIT=83;
    public static final int WHITESPACE=84;
    public static final int LINE_COMMENT=85;
    public static final int MULTILINE_COMMENT=86;
    public static final int INCLUDE_DECL=87;
    public static final int J=88;
    public static final int K=89;
    public static final int Q=90;
    public static final int X=91;
    public static final int Y=92;
    public static final int Z=93;

    // delegates
    // delegators


        public Phdl2Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public Phdl2Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return Phdl2Parser.tokenNames; }
    public String getGrammarFileName() { return "/fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g"; }



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


    public static class sourceText_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sourceText"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:229:1: sourceText : ( deviceDecl | designDecl )+ ;
    public final Phdl2Parser.sourceText_return sourceText() throws RecognitionException {
        Phdl2Parser.sourceText_return retval = new Phdl2Parser.sourceText_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Phdl2Parser.deviceDecl_return deviceDecl1 = null;

        Phdl2Parser.designDecl_return designDecl2 = null;



        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:230:2: ( ( deviceDecl | designDecl )+ )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:230:4: ( deviceDecl | designDecl )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:230:4: ( deviceDecl | designDecl )+
            int cnt1=0;
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==DEVICE) ) {
                    alt1=1;
                }
                else if ( (LA1_0==DESIGN) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:230:5: deviceDecl
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_sourceText385);
            	    deviceDecl1=deviceDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, deviceDecl1.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:230:18: designDecl
            	    {
            	    pushFollow(FOLLOW_designDecl_in_sourceText389);
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:233:1: deviceDecl : DEVICE IDENT LBRACE ( infoDecl | attrDecl | pinDecl )* RBRACE -> ^( DEVICE_DECL IDENT ( infoDecl )* ( attrDecl )* ( pinDecl )* ) ;
    public final Phdl2Parser.deviceDecl_return deviceDecl() throws RecognitionException {
        Phdl2Parser.deviceDecl_return retval = new Phdl2Parser.deviceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DEVICE3=null;
        Token IDENT4=null;
        Token LBRACE5=null;
        Token RBRACE9=null;
        Phdl2Parser.infoDecl_return infoDecl6 = null;

        Phdl2Parser.attrDecl_return attrDecl7 = null;

        Phdl2Parser.pinDecl_return pinDecl8 = null;


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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:234:2: ( DEVICE IDENT LBRACE ( infoDecl | attrDecl | pinDecl )* RBRACE -> ^( DEVICE_DECL IDENT ( infoDecl )* ( attrDecl )* ( pinDecl )* ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:234:4: DEVICE IDENT LBRACE ( infoDecl | attrDecl | pinDecl )* RBRACE
            {
            DEVICE3=(Token)match(input,DEVICE,FOLLOW_DEVICE_in_deviceDecl402); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DEVICE.add(DEVICE3);

            IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl404); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT4);

            LBRACE5=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_deviceDecl406); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE5);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:234:24: ( infoDecl | attrDecl | pinDecl )*
            loop2:
            do {
                int alt2=4;
                switch ( input.LA(1) ) {
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
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:234:25: infoDecl
            	    {
            	    pushFollow(FOLLOW_infoDecl_in_deviceDecl409);
            	    infoDecl6=infoDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_infoDecl.add(infoDecl6.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:234:36: attrDecl
            	    {
            	    pushFollow(FOLLOW_attrDecl_in_deviceDecl413);
            	    attrDecl7=attrDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_attrDecl.add(attrDecl7.getTree());

            	    }
            	    break;
            	case 3 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:234:47: pinDecl
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl417);
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

            RBRACE9=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_deviceDecl421); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE9);



            // AST REWRITE
            // elements: infoDecl, attrDecl, pinDecl, IDENT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 235:3: -> ^( DEVICE_DECL IDENT ( infoDecl )* ( attrDecl )* ( pinDecl )* )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:235:6: ^( DEVICE_DECL IDENT ( infoDecl )* ( attrDecl )* ( pinDecl )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DEVICE_DECL, "DEVICE_DECL"), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:235:26: ( infoDecl )*
                while ( stream_infoDecl.hasNext() ) {
                    adaptor.addChild(root_1, stream_infoDecl.nextTree());

                }
                stream_infoDecl.reset();
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:235:36: ( attrDecl )*
                while ( stream_attrDecl.hasNext() ) {
                    adaptor.addChild(root_1, stream_attrDecl.nextTree());

                }
                stream_attrDecl.reset();
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:235:46: ( pinDecl )*
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:238:1: attrDecl : ATTR IDENT EQUALS STRING SEMICOLON -> ^( ATTR_DECL IDENT STRING ) ;
    public final Phdl2Parser.attrDecl_return attrDecl() throws RecognitionException {
        Phdl2Parser.attrDecl_return retval = new Phdl2Parser.attrDecl_return();
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:239:2: ( ATTR IDENT EQUALS STRING SEMICOLON -> ^( ATTR_DECL IDENT STRING ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:239:4: ATTR IDENT EQUALS STRING SEMICOLON
            {
            ATTR10=(Token)match(input,ATTR,FOLLOW_ATTR_in_attrDecl453); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ATTR.add(ATTR10);

            IDENT11=(Token)match(input,IDENT,FOLLOW_IDENT_in_attrDecl455); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT11);

            EQUALS12=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attrDecl457); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS12);

            STRING13=(Token)match(input,STRING,FOLLOW_STRING_in_attrDecl459); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(STRING13);

            SEMICOLON14=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attrDecl461); if (state.failed) return retval; 
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
            // 239:39: -> ^( ATTR_DECL IDENT STRING )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:239:42: ^( ATTR_DECL IDENT STRING )
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:242:1: pinDecl : pinType ( LBRACKET widthDecl RBRACKET )? IDENT EQUALS pinList SEMICOLON -> ^( PIN_DECL IDENT pinType ( widthDecl )? pinList ) ;
    public final Phdl2Parser.pinDecl_return pinDecl() throws RecognitionException {
        Phdl2Parser.pinDecl_return retval = new Phdl2Parser.pinDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACKET16=null;
        Token RBRACKET18=null;
        Token IDENT19=null;
        Token EQUALS20=null;
        Token SEMICOLON22=null;
        Phdl2Parser.pinType_return pinType15 = null;

        Phdl2Parser.widthDecl_return widthDecl17 = null;

        Phdl2Parser.pinList_return pinList21 = null;


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
        RewriteRuleSubtreeStream stream_pinList=new RewriteRuleSubtreeStream(adaptor,"rule pinList");
        RewriteRuleSubtreeStream stream_pinType=new RewriteRuleSubtreeStream(adaptor,"rule pinType");
        RewriteRuleSubtreeStream stream_widthDecl=new RewriteRuleSubtreeStream(adaptor,"rule widthDecl");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:243:2: ( pinType ( LBRACKET widthDecl RBRACKET )? IDENT EQUALS pinList SEMICOLON -> ^( PIN_DECL IDENT pinType ( widthDecl )? pinList ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:243:4: pinType ( LBRACKET widthDecl RBRACKET )? IDENT EQUALS pinList SEMICOLON
            {
            pushFollow(FOLLOW_pinType_in_pinDecl482);
            pinType15=pinType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_pinType.add(pinType15.getTree());
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:243:12: ( LBRACKET widthDecl RBRACKET )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==LBRACKET) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:243:13: LBRACKET widthDecl RBRACKET
                    {
                    LBRACKET16=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_pinDecl485); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET16);

                    pushFollow(FOLLOW_widthDecl_in_pinDecl487);
                    widthDecl17=widthDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_widthDecl.add(widthDecl17.getTree());
                    RBRACKET18=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_pinDecl489); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET18);


                    }
                    break;

            }

            IDENT19=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinDecl493); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT19);

            EQUALS20=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinDecl495); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS20);

            pushFollow(FOLLOW_pinList_in_pinDecl497);
            pinList21=pinList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_pinList.add(pinList21.getTree());
            SEMICOLON22=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinDecl499); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON22);



            // AST REWRITE
            // elements: pinType, pinList, IDENT, widthDecl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 244:3: -> ^( PIN_DECL IDENT pinType ( widthDecl )? pinList )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:244:6: ^( PIN_DECL IDENT pinType ( widthDecl )? pinList )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PIN_DECL, "PIN_DECL"), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                adaptor.addChild(root_1, stream_pinType.nextTree());
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:244:31: ( widthDecl )?
                if ( stream_widthDecl.hasNext() ) {
                    adaptor.addChild(root_1, stream_widthDecl.nextTree());

                }
                stream_widthDecl.reset();
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

    public static class pinType_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pinType"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:247:1: pinType : ( PIN -> ^( PIN_TYPE PIN ) | INPIN -> ^( PIN_TYPE INPIN ) | OUTPIN -> ^( PIN_TYPE OUTPIN ) | IOPIN -> ^( PIN_TYPE IOPIN ) | PWRPIN -> ^( PIN_TYPE PWRPIN ) | SUPPIN -> ^( PIN_TYPE SUPPIN ) ) ;
    public final Phdl2Parser.pinType_return pinType() throws RecognitionException {
        Phdl2Parser.pinType_return retval = new Phdl2Parser.pinType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PIN23=null;
        Token INPIN24=null;
        Token OUTPIN25=null;
        Token IOPIN26=null;
        Token PWRPIN27=null;
        Token SUPPIN28=null;

        CommonTree PIN23_tree=null;
        CommonTree INPIN24_tree=null;
        CommonTree OUTPIN25_tree=null;
        CommonTree IOPIN26_tree=null;
        CommonTree PWRPIN27_tree=null;
        CommonTree SUPPIN28_tree=null;
        RewriteRuleTokenStream stream_INPIN=new RewriteRuleTokenStream(adaptor,"token INPIN");
        RewriteRuleTokenStream stream_SUPPIN=new RewriteRuleTokenStream(adaptor,"token SUPPIN");
        RewriteRuleTokenStream stream_IOPIN=new RewriteRuleTokenStream(adaptor,"token IOPIN");
        RewriteRuleTokenStream stream_OUTPIN=new RewriteRuleTokenStream(adaptor,"token OUTPIN");
        RewriteRuleTokenStream stream_PIN=new RewriteRuleTokenStream(adaptor,"token PIN");
        RewriteRuleTokenStream stream_PWRPIN=new RewriteRuleTokenStream(adaptor,"token PWRPIN");

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:248:2: ( ( PIN -> ^( PIN_TYPE PIN ) | INPIN -> ^( PIN_TYPE INPIN ) | OUTPIN -> ^( PIN_TYPE OUTPIN ) | IOPIN -> ^( PIN_TYPE IOPIN ) | PWRPIN -> ^( PIN_TYPE PWRPIN ) | SUPPIN -> ^( PIN_TYPE SUPPIN ) ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:248:4: ( PIN -> ^( PIN_TYPE PIN ) | INPIN -> ^( PIN_TYPE INPIN ) | OUTPIN -> ^( PIN_TYPE OUTPIN ) | IOPIN -> ^( PIN_TYPE IOPIN ) | PWRPIN -> ^( PIN_TYPE PWRPIN ) | SUPPIN -> ^( PIN_TYPE SUPPIN ) )
            {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:248:4: ( PIN -> ^( PIN_TYPE PIN ) | INPIN -> ^( PIN_TYPE INPIN ) | OUTPIN -> ^( PIN_TYPE OUTPIN ) | IOPIN -> ^( PIN_TYPE IOPIN ) | PWRPIN -> ^( PIN_TYPE PWRPIN ) | SUPPIN -> ^( PIN_TYPE SUPPIN ) )
            int alt4=6;
            switch ( input.LA(1) ) {
            case PIN:
                {
                alt4=1;
                }
                break;
            case INPIN:
                {
                alt4=2;
                }
                break;
            case OUTPIN:
                {
                alt4=3;
                }
                break;
            case IOPIN:
                {
                alt4=4;
                }
                break;
            case PWRPIN:
                {
                alt4=5;
                }
                break;
            case SUPPIN:
                {
                alt4=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:248:5: PIN
                    {
                    PIN23=(Token)match(input,PIN,FOLLOW_PIN_in_pinType529); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PIN.add(PIN23);



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
                    // 248:9: -> ^( PIN_TYPE PIN )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:248:12: ^( PIN_TYPE PIN )
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
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:249:4: INPIN
                    {
                    INPIN24=(Token)match(input,INPIN,FOLLOW_INPIN_in_pinType542); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INPIN.add(INPIN24);



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
                    // 249:10: -> ^( PIN_TYPE INPIN )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:249:13: ^( PIN_TYPE INPIN )
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
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:250:4: OUTPIN
                    {
                    OUTPIN25=(Token)match(input,OUTPIN,FOLLOW_OUTPIN_in_pinType555); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OUTPIN.add(OUTPIN25);



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
                    // 250:11: -> ^( PIN_TYPE OUTPIN )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:250:14: ^( PIN_TYPE OUTPIN )
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
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:251:4: IOPIN
                    {
                    IOPIN26=(Token)match(input,IOPIN,FOLLOW_IOPIN_in_pinType568); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IOPIN.add(IOPIN26);



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
                    // 251:10: -> ^( PIN_TYPE IOPIN )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:251:13: ^( PIN_TYPE IOPIN )
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
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:252:4: PWRPIN
                    {
                    PWRPIN27=(Token)match(input,PWRPIN,FOLLOW_PWRPIN_in_pinType581); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PWRPIN.add(PWRPIN27);



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
                    // 252:11: -> ^( PIN_TYPE PWRPIN )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:252:14: ^( PIN_TYPE PWRPIN )
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
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:253:4: SUPPIN
                    {
                    SUPPIN28=(Token)match(input,SUPPIN,FOLLOW_SUPPIN_in_pinType594); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SUPPIN.add(SUPPIN28);



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
                    // 253:11: -> ^( PIN_TYPE SUPPIN )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:253:14: ^( PIN_TYPE SUPPIN )
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

    public static class widthDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "widthDecl"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:256:1: widthDecl : INT COLON INT -> ^( WIDTH_DECL INT INT ) ;
    public final Phdl2Parser.widthDecl_return widthDecl() throws RecognitionException {
        Phdl2Parser.widthDecl_return retval = new Phdl2Parser.widthDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INT29=null;
        Token COLON30=null;
        Token INT31=null;

        CommonTree INT29_tree=null;
        CommonTree COLON30_tree=null;
        CommonTree INT31_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:257:2: ( INT COLON INT -> ^( WIDTH_DECL INT INT ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:257:4: INT COLON INT
            {
            INT29=(Token)match(input,INT,FOLLOW_INT_in_widthDecl614); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INT.add(INT29);

            COLON30=(Token)match(input,COLON,FOLLOW_COLON_in_widthDecl616); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON30);

            INT31=(Token)match(input,INT,FOLLOW_INT_in_widthDecl618); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INT.add(INT31);



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
            // 257:18: -> ^( WIDTH_DECL INT INT )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:257:21: ^( WIDTH_DECL INT INT )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(WIDTH_DECL, "WIDTH_DECL"), root_1);

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
    // $ANTLR end "widthDecl"

    public static class pinList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pinList"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:260:1: pinList : LBRACE pinNumber ( COMMA pinNumber )* RBRACE -> ^( PIN_LIST ( pinNumber )+ ) ;
    public final Phdl2Parser.pinList_return pinList() throws RecognitionException {
        Phdl2Parser.pinList_return retval = new Phdl2Parser.pinList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACE32=null;
        Token COMMA34=null;
        Token RBRACE36=null;
        Phdl2Parser.pinNumber_return pinNumber33 = null;

        Phdl2Parser.pinNumber_return pinNumber35 = null;


        CommonTree LBRACE32_tree=null;
        CommonTree COMMA34_tree=null;
        CommonTree RBRACE36_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_pinNumber=new RewriteRuleSubtreeStream(adaptor,"rule pinNumber");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:261:2: ( LBRACE pinNumber ( COMMA pinNumber )* RBRACE -> ^( PIN_LIST ( pinNumber )+ ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:261:5: LBRACE pinNumber ( COMMA pinNumber )* RBRACE
            {
            LBRACE32=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_pinList640); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE32);

            pushFollow(FOLLOW_pinNumber_in_pinList642);
            pinNumber33=pinNumber();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_pinNumber.add(pinNumber33.getTree());
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:261:22: ( COMMA pinNumber )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==COMMA) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:261:23: COMMA pinNumber
            	    {
            	    COMMA34=(Token)match(input,COMMA,FOLLOW_COMMA_in_pinList645); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA34);

            	    pushFollow(FOLLOW_pinNumber_in_pinList647);
            	    pinNumber35=pinNumber();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_pinNumber.add(pinNumber35.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            RBRACE36=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_pinList651); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE36);



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
            // 261:48: -> ^( PIN_LIST ( pinNumber )+ )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:261:51: ^( PIN_LIST ( pinNumber )+ )
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:264:1: pinNumber : ( IDENT | INT | PINNUM );
    public final Phdl2Parser.pinNumber_return pinNumber() throws RecognitionException {
        Phdl2Parser.pinNumber_return retval = new Phdl2Parser.pinNumber_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set37=null;

        CommonTree set37_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:265:2: ( IDENT | INT | PINNUM )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set37=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||(input.LA(1)>=INT && input.LA(1)<=PINNUM) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set37));
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

    public static class designDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "designDecl"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:268:1: designDecl : DESIGN IDENT LBRACE ( designBody )* RBRACE -> ^( DESIGN_DECL IDENT ( designBody )* ) ;
    public final Phdl2Parser.designDecl_return designDecl() throws RecognitionException {
        Phdl2Parser.designDecl_return retval = new Phdl2Parser.designDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DESIGN38=null;
        Token IDENT39=null;
        Token LBRACE40=null;
        Token RBRACE42=null;
        Phdl2Parser.designBody_return designBody41 = null;


        CommonTree DESIGN38_tree=null;
        CommonTree IDENT39_tree=null;
        CommonTree LBRACE40_tree=null;
        CommonTree RBRACE42_tree=null;
        RewriteRuleTokenStream stream_DESIGN=new RewriteRuleTokenStream(adaptor,"token DESIGN");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_designBody=new RewriteRuleSubtreeStream(adaptor,"rule designBody");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:269:2: ( DESIGN IDENT LBRACE ( designBody )* RBRACE -> ^( DESIGN_DECL IDENT ( designBody )* ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:269:4: DESIGN IDENT LBRACE ( designBody )* RBRACE
            {
            DESIGN38=(Token)match(input,DESIGN,FOLLOW_DESIGN_in_designDecl692); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DESIGN.add(DESIGN38);

            IDENT39=(Token)match(input,IDENT,FOLLOW_IDENT_in_designDecl694); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT39);

            LBRACE40=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_designDecl696); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE40);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:269:24: ( designBody )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==INST||LA6_0==NET||LA6_0==INFO) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:0:0: designBody
            	    {
            	    pushFollow(FOLLOW_designBody_in_designDecl698);
            	    designBody41=designBody();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_designBody.add(designBody41.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            RBRACE42=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_designDecl701); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE42);



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
            // 269:43: -> ^( DESIGN_DECL IDENT ( designBody )* )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:269:46: ^( DESIGN_DECL IDENT ( designBody )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DESIGN_DECL, "DESIGN_DECL"), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:269:66: ( designBody )*
                while ( stream_designBody.hasNext() ) {
                    adaptor.addChild(root_1, stream_designBody.nextTree());

                }
                stream_designBody.reset();

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
    // $ANTLR end "designDecl"

    public static class designBody_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "designBody"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:272:1: designBody : ( infoDecl | netDecl | instDecl );
    public final Phdl2Parser.designBody_return designBody() throws RecognitionException {
        Phdl2Parser.designBody_return retval = new Phdl2Parser.designBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Phdl2Parser.infoDecl_return infoDecl43 = null;

        Phdl2Parser.netDecl_return netDecl44 = null;

        Phdl2Parser.instDecl_return instDecl45 = null;



        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:273:2: ( infoDecl | netDecl | instDecl )
            int alt7=3;
            switch ( input.LA(1) ) {
            case INFO:
                {
                alt7=1;
                }
                break;
            case NET:
                {
                alt7=2;
                }
                break;
            case INST:
                {
                alt7=3;
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
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:273:4: infoDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_infoDecl_in_designBody724);
                    infoDecl43=infoDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, infoDecl43.getTree());

                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:274:4: netDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_netDecl_in_designBody729);
                    netDecl44=netDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, netDecl44.getTree());

                    }
                    break;
                case 3 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:275:4: instDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_instDecl_in_designBody734);
                    instDecl45=instDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, instDecl45.getTree());

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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:278:1: infoDecl : INFO LBRACE ( STRING )+ RBRACE -> ^( INFO_DECL ( STRING )+ ) ;
    public final Phdl2Parser.infoDecl_return infoDecl() throws RecognitionException {
        Phdl2Parser.infoDecl_return retval = new Phdl2Parser.infoDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INFO46=null;
        Token LBRACE47=null;
        Token STRING48=null;
        Token RBRACE49=null;

        CommonTree INFO46_tree=null;
        CommonTree LBRACE47_tree=null;
        CommonTree STRING48_tree=null;
        CommonTree RBRACE49_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_INFO=new RewriteRuleTokenStream(adaptor,"token INFO");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:279:2: ( INFO LBRACE ( STRING )+ RBRACE -> ^( INFO_DECL ( STRING )+ ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:279:4: INFO LBRACE ( STRING )+ RBRACE
            {
            INFO46=(Token)match(input,INFO,FOLLOW_INFO_in_infoDecl746); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INFO.add(INFO46);

            LBRACE47=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_infoDecl748); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE47);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:279:16: ( STRING )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==STRING) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:0:0: STRING
            	    {
            	    STRING48=(Token)match(input,STRING,FOLLOW_STRING_in_infoDecl750); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_STRING.add(STRING48);


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

            RBRACE49=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_infoDecl753); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE49);



            // AST REWRITE
            // elements: STRING
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 279:31: -> ^( INFO_DECL ( STRING )+ )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:279:34: ^( INFO_DECL ( STRING )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INFO_DECL, "INFO_DECL"), root_1);

                if ( !(stream_STRING.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_STRING.hasNext() ) {
                    adaptor.addChild(root_1, stream_STRING.nextNode());

                }
                stream_STRING.reset();

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

    public static class netDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "netDecl"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:282:1: netDecl : NET LBRACKET ( widthDecl )? RBRACKET IDENT ( COMMA IDENT )+ ( ( LBRACE ( attrDecl )* RBRACE ) | SEMICOLON ) -> ^( NET_DECL ( widthDecl )? ( IDENT )+ ( attrDecl )* ) ;
    public final Phdl2Parser.netDecl_return netDecl() throws RecognitionException {
        Phdl2Parser.netDecl_return retval = new Phdl2Parser.netDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NET50=null;
        Token LBRACKET51=null;
        Token RBRACKET53=null;
        Token IDENT54=null;
        Token COMMA55=null;
        Token IDENT56=null;
        Token LBRACE57=null;
        Token RBRACE59=null;
        Token SEMICOLON60=null;
        Phdl2Parser.widthDecl_return widthDecl52 = null;

        Phdl2Parser.attrDecl_return attrDecl58 = null;


        CommonTree NET50_tree=null;
        CommonTree LBRACKET51_tree=null;
        CommonTree RBRACKET53_tree=null;
        CommonTree IDENT54_tree=null;
        CommonTree COMMA55_tree=null;
        CommonTree IDENT56_tree=null;
        CommonTree LBRACE57_tree=null;
        CommonTree RBRACE59_tree=null;
        CommonTree SEMICOLON60_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_NET=new RewriteRuleTokenStream(adaptor,"token NET");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_attrDecl=new RewriteRuleSubtreeStream(adaptor,"rule attrDecl");
        RewriteRuleSubtreeStream stream_widthDecl=new RewriteRuleSubtreeStream(adaptor,"rule widthDecl");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:283:2: ( NET LBRACKET ( widthDecl )? RBRACKET IDENT ( COMMA IDENT )+ ( ( LBRACE ( attrDecl )* RBRACE ) | SEMICOLON ) -> ^( NET_DECL ( widthDecl )? ( IDENT )+ ( attrDecl )* ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:283:4: NET LBRACKET ( widthDecl )? RBRACKET IDENT ( COMMA IDENT )+ ( ( LBRACE ( attrDecl )* RBRACE ) | SEMICOLON )
            {
            NET50=(Token)match(input,NET,FOLLOW_NET_in_netDecl774); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NET.add(NET50);

            LBRACKET51=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_netDecl776); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET51);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:283:17: ( widthDecl )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==INT) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:0:0: widthDecl
                    {
                    pushFollow(FOLLOW_widthDecl_in_netDecl778);
                    widthDecl52=widthDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_widthDecl.add(widthDecl52.getTree());

                    }
                    break;

            }

            RBRACKET53=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_netDecl781); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET53);

            IDENT54=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl783); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT54);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:283:43: ( COMMA IDENT )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==COMMA) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:283:44: COMMA IDENT
            	    {
            	    COMMA55=(Token)match(input,COMMA,FOLLOW_COMMA_in_netDecl786); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA55);

            	    IDENT56=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl788); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_IDENT.add(IDENT56);


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:283:58: ( ( LBRACE ( attrDecl )* RBRACE ) | SEMICOLON )
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
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:283:59: ( LBRACE ( attrDecl )* RBRACE )
                    {
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:283:59: ( LBRACE ( attrDecl )* RBRACE )
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:283:60: LBRACE ( attrDecl )* RBRACE
                    {
                    LBRACE57=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_netDecl794); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE57);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:283:67: ( attrDecl )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==ATTR) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:0:0: attrDecl
                    	    {
                    	    pushFollow(FOLLOW_attrDecl_in_netDecl796);
                    	    attrDecl58=attrDecl();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_attrDecl.add(attrDecl58.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    RBRACE59=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_netDecl799); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE59);


                    }


                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:283:87: SEMICOLON
                    {
                    SEMICOLON60=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netDecl804); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON60);


                    }
                    break;

            }



            // AST REWRITE
            // elements: IDENT, attrDecl, widthDecl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 284:3: -> ^( NET_DECL ( widthDecl )? ( IDENT )+ ( attrDecl )* )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:284:6: ^( NET_DECL ( widthDecl )? ( IDENT )+ ( attrDecl )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NET_DECL, "NET_DECL"), root_1);

                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:284:17: ( widthDecl )?
                if ( stream_widthDecl.hasNext() ) {
                    adaptor.addChild(root_1, stream_widthDecl.nextTree());

                }
                stream_widthDecl.reset();
                if ( !(stream_IDENT.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_IDENT.hasNext() ) {
                    adaptor.addChild(root_1, stream_IDENT.nextNode());

                }
                stream_IDENT.reset();
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:284:35: ( attrDecl )*
                while ( stream_attrDecl.hasNext() ) {
                    adaptor.addChild(root_1, stream_attrDecl.nextTree());

                }
                stream_attrDecl.reset();

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
    // $ANTLR end "netDecl"

    public static class instDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "instDecl"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:287:1: instDecl : INST ( LPAREN widthDecl RPAREN )? IDENT OF IDENT LBRACE ( infoDecl | attrAssign )* RBRACE -> ^( INST_DECL ( widthDecl )? IDENT IDENT ( infoDecl )* ( attrAssign )* ) ;
    public final Phdl2Parser.instDecl_return instDecl() throws RecognitionException {
        Phdl2Parser.instDecl_return retval = new Phdl2Parser.instDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INST61=null;
        Token LPAREN62=null;
        Token RPAREN64=null;
        Token IDENT65=null;
        Token OF66=null;
        Token IDENT67=null;
        Token LBRACE68=null;
        Token RBRACE71=null;
        Phdl2Parser.widthDecl_return widthDecl63 = null;

        Phdl2Parser.infoDecl_return infoDecl69 = null;

        Phdl2Parser.attrAssign_return attrAssign70 = null;


        CommonTree INST61_tree=null;
        CommonTree LPAREN62_tree=null;
        CommonTree RPAREN64_tree=null;
        CommonTree IDENT65_tree=null;
        CommonTree OF66_tree=null;
        CommonTree IDENT67_tree=null;
        CommonTree LBRACE68_tree=null;
        CommonTree RBRACE71_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_OF=new RewriteRuleTokenStream(adaptor,"token OF");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleTokenStream stream_INST=new RewriteRuleTokenStream(adaptor,"token INST");
        RewriteRuleSubtreeStream stream_infoDecl=new RewriteRuleSubtreeStream(adaptor,"rule infoDecl");
        RewriteRuleSubtreeStream stream_widthDecl=new RewriteRuleSubtreeStream(adaptor,"rule widthDecl");
        RewriteRuleSubtreeStream stream_attrAssign=new RewriteRuleSubtreeStream(adaptor,"rule attrAssign");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:288:2: ( INST ( LPAREN widthDecl RPAREN )? IDENT OF IDENT LBRACE ( infoDecl | attrAssign )* RBRACE -> ^( INST_DECL ( widthDecl )? IDENT IDENT ( infoDecl )* ( attrAssign )* ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:288:4: INST ( LPAREN widthDecl RPAREN )? IDENT OF IDENT LBRACE ( infoDecl | attrAssign )* RBRACE
            {
            INST61=(Token)match(input,INST,FOLLOW_INST_in_instDecl835); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INST.add(INST61);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:288:9: ( LPAREN widthDecl RPAREN )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==LPAREN) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:288:10: LPAREN widthDecl RPAREN
                    {
                    LPAREN62=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_instDecl838); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN62);

                    pushFollow(FOLLOW_widthDecl_in_instDecl840);
                    widthDecl63=widthDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_widthDecl.add(widthDecl63.getTree());
                    RPAREN64=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_instDecl842); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN64);


                    }
                    break;

            }

            IDENT65=(Token)match(input,IDENT,FOLLOW_IDENT_in_instDecl846); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT65);

            OF66=(Token)match(input,OF,FOLLOW_OF_in_instDecl848); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_OF.add(OF66);

            IDENT67=(Token)match(input,IDENT,FOLLOW_IDENT_in_instDecl850); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT67);

            LBRACE68=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_instDecl852); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE68);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:288:58: ( infoDecl | attrAssign )*
            loop14:
            do {
                int alt14=3;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==INFO) ) {
                    alt14=1;
                }
                else if ( (LA14_0==THIS||LA14_0==NEWATTR||LA14_0==IDENT) ) {
                    alt14=2;
                }


                switch (alt14) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:288:59: infoDecl
            	    {
            	    pushFollow(FOLLOW_infoDecl_in_instDecl855);
            	    infoDecl69=infoDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_infoDecl.add(infoDecl69.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:288:70: attrAssign
            	    {
            	    pushFollow(FOLLOW_attrAssign_in_instDecl859);
            	    attrAssign70=attrAssign();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_attrAssign.add(attrAssign70.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            RBRACE71=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_instDecl863); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE71);



            // AST REWRITE
            // elements: attrAssign, IDENT, IDENT, infoDecl, widthDecl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 289:3: -> ^( INST_DECL ( widthDecl )? IDENT IDENT ( infoDecl )* ( attrAssign )* )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:289:6: ^( INST_DECL ( widthDecl )? IDENT IDENT ( infoDecl )* ( attrAssign )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INST_DECL, "INST_DECL"), root_1);

                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:289:18: ( widthDecl )?
                if ( stream_widthDecl.hasNext() ) {
                    adaptor.addChild(root_1, stream_widthDecl.nextTree());

                }
                stream_widthDecl.reset();
                adaptor.addChild(root_1, stream_IDENT.nextNode());
                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:289:41: ( infoDecl )*
                while ( stream_infoDecl.hasNext() ) {
                    adaptor.addChild(root_1, stream_infoDecl.nextTree());

                }
                stream_infoDecl.reset();
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:289:51: ( attrAssign )*
                while ( stream_attrAssign.hasNext() ) {
                    adaptor.addChild(root_1, stream_attrAssign.nextTree());

                }
                stream_attrAssign.reset();

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
    // $ANTLR end "instDecl"

    public static class attrAssign_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attrAssign"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:292:1: attrAssign : ( NEWATTR )? ( attrQual )? IDENT EQUALS STRING SEMICOLON -> ^( ATTR_ASSIGN ( NEWATTR )? ( attrQual )? IDENT STRING ) ;
    public final Phdl2Parser.attrAssign_return attrAssign() throws RecognitionException {
        Phdl2Parser.attrAssign_return retval = new Phdl2Parser.attrAssign_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NEWATTR72=null;
        Token IDENT74=null;
        Token EQUALS75=null;
        Token STRING76=null;
        Token SEMICOLON77=null;
        Phdl2Parser.attrQual_return attrQual73 = null;


        CommonTree NEWATTR72_tree=null;
        CommonTree IDENT74_tree=null;
        CommonTree EQUALS75_tree=null;
        CommonTree STRING76_tree=null;
        CommonTree SEMICOLON77_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_NEWATTR=new RewriteRuleTokenStream(adaptor,"token NEWATTR");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_attrQual=new RewriteRuleSubtreeStream(adaptor,"rule attrQual");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:293:2: ( ( NEWATTR )? ( attrQual )? IDENT EQUALS STRING SEMICOLON -> ^( ATTR_ASSIGN ( NEWATTR )? ( attrQual )? IDENT STRING ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:293:4: ( NEWATTR )? ( attrQual )? IDENT EQUALS STRING SEMICOLON
            {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:293:4: ( NEWATTR )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==NEWATTR) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:0:0: NEWATTR
                    {
                    NEWATTR72=(Token)match(input,NEWATTR,FOLLOW_NEWATTR_in_attrAssign896); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NEWATTR.add(NEWATTR72);


                    }
                    break;

            }

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:293:13: ( attrQual )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==THIS) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:0:0: attrQual
                    {
                    pushFollow(FOLLOW_attrQual_in_attrAssign899);
                    attrQual73=attrQual();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_attrQual.add(attrQual73.getTree());

                    }
                    break;

            }

            IDENT74=(Token)match(input,IDENT,FOLLOW_IDENT_in_attrAssign902); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT74);

            EQUALS75=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attrAssign904); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS75);

            STRING76=(Token)match(input,STRING,FOLLOW_STRING_in_attrAssign906); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(STRING76);

            SEMICOLON77=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attrAssign908); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON77);



            // AST REWRITE
            // elements: STRING, NEWATTR, attrQual, IDENT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 294:3: -> ^( ATTR_ASSIGN ( NEWATTR )? ( attrQual )? IDENT STRING )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:294:6: ^( ATTR_ASSIGN ( NEWATTR )? ( attrQual )? IDENT STRING )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ATTR_ASSIGN, "ATTR_ASSIGN"), root_1);

                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:294:20: ( NEWATTR )?
                if ( stream_NEWATTR.hasNext() ) {
                    adaptor.addChild(root_1, stream_NEWATTR.nextNode());

                }
                stream_NEWATTR.reset();
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:294:29: ( attrQual )?
                if ( stream_attrQual.hasNext() ) {
                    adaptor.addChild(root_1, stream_attrQual.nextTree());

                }
                stream_attrQual.reset();
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

    public static class attrQual_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attrQual"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:297:1: attrQual : THIS arrayList PERIOD -> ^( arrayList ) ;
    public final Phdl2Parser.attrQual_return attrQual() throws RecognitionException {
        Phdl2Parser.attrQual_return retval = new Phdl2Parser.attrQual_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token THIS78=null;
        Token PERIOD80=null;
        Phdl2Parser.arrayList_return arrayList79 = null;


        CommonTree THIS78_tree=null;
        CommonTree PERIOD80_tree=null;
        RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
        RewriteRuleTokenStream stream_THIS=new RewriteRuleTokenStream(adaptor,"token THIS");
        RewriteRuleSubtreeStream stream_arrayList=new RewriteRuleSubtreeStream(adaptor,"rule arrayList");
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:298:2: ( THIS arrayList PERIOD -> ^( arrayList ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:298:4: THIS arrayList PERIOD
            {
            THIS78=(Token)match(input,THIS,FOLLOW_THIS_in_attrQual938); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_THIS.add(THIS78);

            pushFollow(FOLLOW_arrayList_in_attrQual940);
            arrayList79=arrayList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_arrayList.add(arrayList79.getTree());
            PERIOD80=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_attrQual942); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD80);



            // AST REWRITE
            // elements: arrayList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 298:26: -> ^( arrayList )
            {
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:298:29: ^( arrayList )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_arrayList.nextNode(), root_1);

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
    // $ANTLR end "attrQual"

    public static class arrayList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arrayList"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:301:1: arrayList : LPAREN listDecl RPAREN ;
    public final Phdl2Parser.arrayList_return arrayList() throws RecognitionException {
        Phdl2Parser.arrayList_return retval = new Phdl2Parser.arrayList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LPAREN81=null;
        Token RPAREN83=null;
        Phdl2Parser.listDecl_return listDecl82 = null;


        CommonTree LPAREN81_tree=null;
        CommonTree RPAREN83_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:302:2: ( LPAREN listDecl RPAREN )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:302:5: LPAREN listDecl RPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            LPAREN81=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_arrayList961); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LPAREN81_tree = (CommonTree)adaptor.create(LPAREN81);
            adaptor.addChild(root_0, LPAREN81_tree);
            }
            pushFollow(FOLLOW_listDecl_in_arrayList963);
            listDecl82=listDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, listDecl82.getTree());
            RPAREN83=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_arrayList965); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RPAREN83_tree = (CommonTree)adaptor.create(RPAREN83);
            adaptor.addChild(root_0, RPAREN83_tree);
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
    // $ANTLR end "arrayList"

    public static class sliceList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sliceList"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:305:1: sliceList : LBRACKET listDecl RBRACKET ;
    public final Phdl2Parser.sliceList_return sliceList() throws RecognitionException {
        Phdl2Parser.sliceList_return retval = new Phdl2Parser.sliceList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACKET84=null;
        Token RBRACKET86=null;
        Phdl2Parser.listDecl_return listDecl85 = null;


        CommonTree LBRACKET84_tree=null;
        CommonTree RBRACKET86_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:306:2: ( LBRACKET listDecl RBRACKET )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:306:4: LBRACKET listDecl RBRACKET
            {
            root_0 = (CommonTree)adaptor.nil();

            LBRACKET84=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_sliceList977); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LBRACKET84_tree = (CommonTree)adaptor.create(LBRACKET84);
            adaptor.addChild(root_0, LBRACKET84_tree);
            }
            pushFollow(FOLLOW_listDecl_in_sliceList979);
            listDecl85=listDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, listDecl85.getTree());
            RBRACKET86=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_sliceList981); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RBRACKET86_tree = (CommonTree)adaptor.create(RBRACKET86);
            adaptor.addChild(root_0, RBRACKET86_tree);
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
    // $ANTLR end "sliceList"

    public static class listDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "listDecl"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:309:1: listDecl : ( INT COLON INT -> ^( LIST_ARRAY INT INT ) | INT ( COMMA INT ( COMMA INT )* )? -> ^( LIST_SLICE ( INT )+ ) );
    public final Phdl2Parser.listDecl_return listDecl() throws RecognitionException {
        Phdl2Parser.listDecl_return retval = new Phdl2Parser.listDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INT87=null;
        Token COLON88=null;
        Token INT89=null;
        Token INT90=null;
        Token COMMA91=null;
        Token INT92=null;
        Token COMMA93=null;
        Token INT94=null;

        CommonTree INT87_tree=null;
        CommonTree COLON88_tree=null;
        CommonTree INT89_tree=null;
        CommonTree INT90_tree=null;
        CommonTree COMMA91_tree=null;
        CommonTree INT92_tree=null;
        CommonTree COMMA93_tree=null;
        CommonTree INT94_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:310:2: ( INT COLON INT -> ^( LIST_ARRAY INT INT ) | INT ( COMMA INT ( COMMA INT )* )? -> ^( LIST_SLICE ( INT )+ ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==INT) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==COLON) ) {
                    alt19=1;
                }
                else if ( (LA19_1==COMMA||LA19_1==RPAREN||LA19_1==RBRACKET) ) {
                    alt19=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:310:4: INT COLON INT
                    {
                    INT87=(Token)match(input,INT,FOLLOW_INT_in_listDecl993); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT87);

                    COLON88=(Token)match(input,COLON,FOLLOW_COLON_in_listDecl995); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON88);

                    INT89=(Token)match(input,INT,FOLLOW_INT_in_listDecl997); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT89);



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
                    // 310:22: -> ^( LIST_ARRAY INT INT )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:310:25: ^( LIST_ARRAY INT INT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST_ARRAY, "LIST_ARRAY"), root_1);

                        adaptor.addChild(root_1, stream_INT.nextNode());
                        adaptor.addChild(root_1, stream_INT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:311:5: INT ( COMMA INT ( COMMA INT )* )?
                    {
                    INT90=(Token)match(input,INT,FOLLOW_INT_in_listDecl1017); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT90);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:311:9: ( COMMA INT ( COMMA INT )* )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==COMMA) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:311:10: COMMA INT ( COMMA INT )*
                            {
                            COMMA91=(Token)match(input,COMMA,FOLLOW_COMMA_in_listDecl1020); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_COMMA.add(COMMA91);

                            INT92=(Token)match(input,INT,FOLLOW_INT_in_listDecl1022); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_INT.add(INT92);

                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:311:20: ( COMMA INT )*
                            loop17:
                            do {
                                int alt17=2;
                                int LA17_0 = input.LA(1);

                                if ( (LA17_0==COMMA) ) {
                                    alt17=1;
                                }


                                switch (alt17) {
                            	case 1 :
                            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:311:21: COMMA INT
                            	    {
                            	    COMMA93=(Token)match(input,COMMA,FOLLOW_COMMA_in_listDecl1025); if (state.failed) return retval; 
                            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA93);

                            	    INT94=(Token)match(input,INT,FOLLOW_INT_in_listDecl1027); if (state.failed) return retval; 
                            	    if ( state.backtracking==0 ) stream_INT.add(INT94);


                            	    }
                            	    break;

                            	default :
                            	    break loop17;
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
                    // 311:35: -> ^( LIST_SLICE ( INT )+ )
                    {
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:311:38: ^( LIST_SLICE ( INT )+ )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST_SLICE, "LIST_SLICE"), root_1);

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
    // $ANTLR end "listDecl"

    // Delegated rules


 

    public static final BitSet FOLLOW_deviceDecl_in_sourceText385 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_designDecl_in_sourceText389 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_DEVICE_in_deviceDecl402 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl404 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACE_in_deviceDecl406 = new BitSet(new long[]{0x000001FC10004000L});
    public static final BitSet FOLLOW_infoDecl_in_deviceDecl409 = new BitSet(new long[]{0x000001FC10004000L});
    public static final BitSet FOLLOW_attrDecl_in_deviceDecl413 = new BitSet(new long[]{0x000001FC10004000L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl417 = new BitSet(new long[]{0x000001FC10004000L});
    public static final BitSet FOLLOW_RBRACE_in_deviceDecl421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ATTR_in_attrDecl453 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_IDENT_in_attrDecl455 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_attrDecl457 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_STRING_in_attrDecl459 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SEMICOLON_in_attrDecl461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pinType_in_pinDecl482 = new BitSet(new long[]{0x0400000000000800L});
    public static final BitSet FOLLOW_LBRACKET_in_pinDecl485 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_widthDecl_in_pinDecl487 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RBRACKET_in_pinDecl489 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl493 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_pinDecl495 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_pinList_in_pinDecl497 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinDecl499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PIN_in_pinType529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INPIN_in_pinType542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPIN_in_pinType555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IOPIN_in_pinType568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PWRPIN_in_pinType581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUPPIN_in_pinType594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_widthDecl614 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_COLON_in_widthDecl616 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_INT_in_widthDecl618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_pinList640 = new BitSet(new long[]{0x3400000000000000L});
    public static final BitSet FOLLOW_pinNumber_in_pinList642 = new BitSet(new long[]{0x0000000000004040L});
    public static final BitSet FOLLOW_COMMA_in_pinList645 = new BitSet(new long[]{0x3400000000000000L});
    public static final BitSet FOLLOW_pinNumber_in_pinList647 = new BitSet(new long[]{0x0000000000004040L});
    public static final BitSet FOLLOW_RBRACE_in_pinList651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_pinNumber0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESIGN_in_designDecl692 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_IDENT_in_designDecl694 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACE_in_designDecl696 = new BitSet(new long[]{0x0000000408404000L});
    public static final BitSet FOLLOW_designBody_in_designDecl698 = new BitSet(new long[]{0x0000000408404000L});
    public static final BitSet FOLLOW_RBRACE_in_designDecl701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_infoDecl_in_designBody724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_netDecl_in_designBody729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instDecl_in_designBody734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INFO_in_infoDecl746 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACE_in_infoDecl748 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_STRING_in_infoDecl750 = new BitSet(new long[]{0x0800000000004000L});
    public static final BitSet FOLLOW_RBRACE_in_infoDecl753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NET_in_netDecl774 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LBRACKET_in_netDecl776 = new BitSet(new long[]{0x1000000000001000L});
    public static final BitSet FOLLOW_widthDecl_in_netDecl778 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RBRACKET_in_netDecl781 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_IDENT_in_netDecl783 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_COMMA_in_netDecl786 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_IDENT_in_netDecl788 = new BitSet(new long[]{0x0000000000002050L});
    public static final BitSet FOLLOW_LBRACE_in_netDecl794 = new BitSet(new long[]{0x0000000010004000L});
    public static final BitSet FOLLOW_attrDecl_in_netDecl796 = new BitSet(new long[]{0x0000000010004000L});
    public static final BitSet FOLLOW_RBRACE_in_netDecl799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_netDecl804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INST_in_instDecl835 = new BitSet(new long[]{0x0400000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_instDecl838 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_widthDecl_in_instDecl840 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_instDecl842 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_IDENT_in_instDecl846 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_OF_in_instDecl848 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_IDENT_in_instDecl850 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACE_in_instDecl852 = new BitSet(new long[]{0x0400000422004000L});
    public static final BitSet FOLLOW_infoDecl_in_instDecl855 = new BitSet(new long[]{0x0400000422004000L});
    public static final BitSet FOLLOW_attrAssign_in_instDecl859 = new BitSet(new long[]{0x0400000422004000L});
    public static final BitSet FOLLOW_RBRACE_in_instDecl863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWATTR_in_attrAssign896 = new BitSet(new long[]{0x0400000002000000L});
    public static final BitSet FOLLOW_attrQual_in_attrAssign899 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_IDENT_in_attrAssign902 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_attrAssign904 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_STRING_in_attrAssign906 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SEMICOLON_in_attrAssign908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THIS_in_attrQual938 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_arrayList_in_attrQual940 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PERIOD_in_attrQual942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_arrayList961 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_listDecl_in_arrayList963 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_arrayList965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_sliceList977 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_listDecl_in_sliceList979 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RBRACKET_in_sliceList981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_listDecl993 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_COLON_in_listDecl995 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_INT_in_listDecl997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_listDecl1017 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_COMMA_in_listDecl1020 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_INT_in_listDecl1022 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_COMMA_in_listDecl1025 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_INT_in_listDecl1027 = new BitSet(new long[]{0x0000000000000042L});

}