// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g 2012-01-02 15:28:40

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SEMICOLON", "COLON", "COMMA", "PERIOD", "EQUALS", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "LANGLE", "RANGLE", "AMPERSAND", "DBLQUOTE", "DESIGN", "DEVICE", "SUBDESIGN", "INST", "SUBINST", "GROUP", "THIS", "OF", "NET", "ATTR", "NEWATTR", "BEGIN", "END", "COMBINE", "INCLUDE", "PIN", "INPIN", "OUTPIN", "IOPIN", "PWRPIN", "SUPPIN", "WIDTH_DECL", "DEVICE_DECL", "ATTR_DECL", "PIN_DECL", "PIN_LIST", "PIN_TYPE", "IDENT", "STRING", "INT", "PINNUM", "D", "E", "S", "I", "G", "N", "V", "C", "U", "B", "T", "R", "O", "P", "H", "F", "A", "W", "M", "L", "CHAR", "DIGIT", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "INCLUDE_DECL", "J", "K", "Q", "X", "Y", "Z"
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
    public static final int PIN=34;
    public static final int INPIN=35;
    public static final int OUTPIN=36;
    public static final int IOPIN=37;
    public static final int PWRPIN=38;
    public static final int SUPPIN=39;
    public static final int WIDTH_DECL=40;
    public static final int DEVICE_DECL=41;
    public static final int ATTR_DECL=42;
    public static final int PIN_DECL=43;
    public static final int PIN_LIST=44;
    public static final int PIN_TYPE=45;
    public static final int IDENT=46;
    public static final int STRING=47;
    public static final int INT=48;
    public static final int PINNUM=49;
    public static final int D=50;
    public static final int E=51;
    public static final int S=52;
    public static final int I=53;
    public static final int G=54;
    public static final int N=55;
    public static final int V=56;
    public static final int C=57;
    public static final int U=58;
    public static final int B=59;
    public static final int T=60;
    public static final int R=61;
    public static final int O=62;
    public static final int P=63;
    public static final int H=64;
    public static final int F=65;
    public static final int A=66;
    public static final int W=67;
    public static final int M=68;
    public static final int L=69;
    public static final int CHAR=70;
    public static final int DIGIT=71;
    public static final int WHITESPACE=72;
    public static final int LINE_COMMENT=73;
    public static final int MULTILINE_COMMENT=74;
    public static final int INCLUDE_DECL=75;
    public static final int J=76;
    public static final int K=77;
    public static final int Q=78;
    public static final int X=79;
    public static final int Y=80;
    public static final int Z=81;

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
    public String getGrammarFileName() { return "C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g"; }



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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:217:1: sourceText : ( deviceDecl )+ ;
    public final Phdl2Parser.sourceText_return sourceText() throws RecognitionException {
        Phdl2Parser.sourceText_return retval = new Phdl2Parser.sourceText_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Phdl2Parser.deviceDecl_return deviceDecl1 = null;



        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:218:2: ( ( deviceDecl )+ )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:218:4: ( deviceDecl )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:218:4: ( deviceDecl )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==DEVICE) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:218:5: deviceDecl
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_sourceText337);
            	    deviceDecl1=deviceDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, deviceDecl1.getTree());

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:221:1: deviceDecl : DEVICE IDENT LBRACE ( attrDecl | pinDecl )* RBRACE -> ^( DEVICE_DECL IDENT ( attrDecl )* ( pinDecl )* ) ;
    public final Phdl2Parser.deviceDecl_return deviceDecl() throws RecognitionException {
        Phdl2Parser.deviceDecl_return retval = new Phdl2Parser.deviceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DEVICE2=null;
        Token IDENT3=null;
        Token LBRACE4=null;
        Token RBRACE7=null;
        Phdl2Parser.attrDecl_return attrDecl5 = null;

        Phdl2Parser.pinDecl_return pinDecl6 = null;


        CommonTree DEVICE2_tree=null;
        CommonTree IDENT3_tree=null;
        CommonTree LBRACE4_tree=null;
        CommonTree RBRACE7_tree=null;
        RewriteRuleTokenStream stream_DEVICE=new RewriteRuleTokenStream(adaptor,"token DEVICE");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_pinDecl=new RewriteRuleSubtreeStream(adaptor,"rule pinDecl");
        RewriteRuleSubtreeStream stream_attrDecl=new RewriteRuleSubtreeStream(adaptor,"rule attrDecl");
        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:222:2: ( DEVICE IDENT LBRACE ( attrDecl | pinDecl )* RBRACE -> ^( DEVICE_DECL IDENT ( attrDecl )* ( pinDecl )* ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:222:4: DEVICE IDENT LBRACE ( attrDecl | pinDecl )* RBRACE
            {
            DEVICE2=(Token)match(input,DEVICE,FOLLOW_DEVICE_in_deviceDecl350); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DEVICE.add(DEVICE2);

            IDENT3=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl352); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT3);

            LBRACE4=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_deviceDecl354); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE4);

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:222:24: ( attrDecl | pinDecl )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==ATTR) ) {
                    alt2=1;
                }
                else if ( ((LA2_0>=PIN && LA2_0<=SUPPIN)) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:222:25: attrDecl
            	    {
            	    pushFollow(FOLLOW_attrDecl_in_deviceDecl357);
            	    attrDecl5=attrDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_attrDecl.add(attrDecl5.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:222:36: pinDecl
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl361);
            	    pinDecl6=pinDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_pinDecl.add(pinDecl6.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            RBRACE7=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_deviceDecl365); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE7);



            // AST REWRITE
            // elements: pinDecl, IDENT, attrDecl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 222:53: -> ^( DEVICE_DECL IDENT ( attrDecl )* ( pinDecl )* )
            {
                // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:222:56: ^( DEVICE_DECL IDENT ( attrDecl )* ( pinDecl )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DEVICE_DECL, "DEVICE_DECL"), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:222:76: ( attrDecl )*
                while ( stream_attrDecl.hasNext() ) {
                    adaptor.addChild(root_1, stream_attrDecl.nextTree());

                }
                stream_attrDecl.reset();
                // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:222:86: ( pinDecl )*
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:225:1: attrDecl : ATTR IDENT EQUALS STRING SEMICOLON -> ^( ATTR_DECL IDENT STRING ) ;
    public final Phdl2Parser.attrDecl_return attrDecl() throws RecognitionException {
        Phdl2Parser.attrDecl_return retval = new Phdl2Parser.attrDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ATTR8=null;
        Token IDENT9=null;
        Token EQUALS10=null;
        Token STRING11=null;
        Token SEMICOLON12=null;

        CommonTree ATTR8_tree=null;
        CommonTree IDENT9_tree=null;
        CommonTree EQUALS10_tree=null;
        CommonTree STRING11_tree=null;
        CommonTree SEMICOLON12_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_ATTR=new RewriteRuleTokenStream(adaptor,"token ATTR");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:226:2: ( ATTR IDENT EQUALS STRING SEMICOLON -> ^( ATTR_DECL IDENT STRING ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:226:4: ATTR IDENT EQUALS STRING SEMICOLON
            {
            ATTR8=(Token)match(input,ATTR,FOLLOW_ATTR_in_attrDecl391); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ATTR.add(ATTR8);

            IDENT9=(Token)match(input,IDENT,FOLLOW_IDENT_in_attrDecl393); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT9);

            EQUALS10=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attrDecl395); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS10);

            STRING11=(Token)match(input,STRING,FOLLOW_STRING_in_attrDecl397); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(STRING11);

            SEMICOLON12=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attrDecl399); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON12);



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
            // 226:39: -> ^( ATTR_DECL IDENT STRING )
            {
                // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:226:42: ^( ATTR_DECL IDENT STRING )
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:229:1: pinDecl : pinType ( widthDecl )? IDENT EQUALS pinList SEMICOLON -> ^( PIN_DECL IDENT pinType ( widthDecl )? pinList ) ;
    public final Phdl2Parser.pinDecl_return pinDecl() throws RecognitionException {
        Phdl2Parser.pinDecl_return retval = new Phdl2Parser.pinDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT15=null;
        Token EQUALS16=null;
        Token SEMICOLON18=null;
        Phdl2Parser.pinType_return pinType13 = null;

        Phdl2Parser.widthDecl_return widthDecl14 = null;

        Phdl2Parser.pinList_return pinList17 = null;


        CommonTree IDENT15_tree=null;
        CommonTree EQUALS16_tree=null;
        CommonTree SEMICOLON18_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleSubtreeStream stream_pinList=new RewriteRuleSubtreeStream(adaptor,"rule pinList");
        RewriteRuleSubtreeStream stream_pinType=new RewriteRuleSubtreeStream(adaptor,"rule pinType");
        RewriteRuleSubtreeStream stream_widthDecl=new RewriteRuleSubtreeStream(adaptor,"rule widthDecl");
        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:230:2: ( pinType ( widthDecl )? IDENT EQUALS pinList SEMICOLON -> ^( PIN_DECL IDENT pinType ( widthDecl )? pinList ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:230:4: pinType ( widthDecl )? IDENT EQUALS pinList SEMICOLON
            {
            pushFollow(FOLLOW_pinType_in_pinDecl420);
            pinType13=pinType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_pinType.add(pinType13.getTree());
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:230:12: ( widthDecl )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==LBRACKET) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:0:0: widthDecl
                    {
                    pushFollow(FOLLOW_widthDecl_in_pinDecl422);
                    widthDecl14=widthDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_widthDecl.add(widthDecl14.getTree());

                    }
                    break;

            }

            IDENT15=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinDecl425); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT15);

            EQUALS16=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinDecl427); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS16);

            pushFollow(FOLLOW_pinList_in_pinDecl429);
            pinList17=pinList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_pinList.add(pinList17.getTree());
            SEMICOLON18=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinDecl431); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON18);



            // AST REWRITE
            // elements: IDENT, widthDecl, pinList, pinType
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 230:54: -> ^( PIN_DECL IDENT pinType ( widthDecl )? pinList )
            {
                // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:230:57: ^( PIN_DECL IDENT pinType ( widthDecl )? pinList )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PIN_DECL, "PIN_DECL"), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                adaptor.addChild(root_1, stream_pinType.nextTree());
                // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:230:82: ( widthDecl )?
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:233:1: pinType : ( PIN -> ^( PIN_TYPE PIN ) | INPIN -> ^( PIN_TYPE INPIN ) | OUTPIN -> ^( PIN_TYPE OUTPIN ) | IOPIN -> ^( PIN_TYPE IOPIN ) | PWRPIN -> ^( PIN_TYPE PWRPIN ) | SUPPIN -> ^( PIN_TYPE SUPPIN ) ) ;
    public final Phdl2Parser.pinType_return pinType() throws RecognitionException {
        Phdl2Parser.pinType_return retval = new Phdl2Parser.pinType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PIN19=null;
        Token INPIN20=null;
        Token OUTPIN21=null;
        Token IOPIN22=null;
        Token PWRPIN23=null;
        Token SUPPIN24=null;

        CommonTree PIN19_tree=null;
        CommonTree INPIN20_tree=null;
        CommonTree OUTPIN21_tree=null;
        CommonTree IOPIN22_tree=null;
        CommonTree PWRPIN23_tree=null;
        CommonTree SUPPIN24_tree=null;
        RewriteRuleTokenStream stream_INPIN=new RewriteRuleTokenStream(adaptor,"token INPIN");
        RewriteRuleTokenStream stream_SUPPIN=new RewriteRuleTokenStream(adaptor,"token SUPPIN");
        RewriteRuleTokenStream stream_IOPIN=new RewriteRuleTokenStream(adaptor,"token IOPIN");
        RewriteRuleTokenStream stream_OUTPIN=new RewriteRuleTokenStream(adaptor,"token OUTPIN");
        RewriteRuleTokenStream stream_PIN=new RewriteRuleTokenStream(adaptor,"token PIN");
        RewriteRuleTokenStream stream_PWRPIN=new RewriteRuleTokenStream(adaptor,"token PWRPIN");

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:234:2: ( ( PIN -> ^( PIN_TYPE PIN ) | INPIN -> ^( PIN_TYPE INPIN ) | OUTPIN -> ^( PIN_TYPE OUTPIN ) | IOPIN -> ^( PIN_TYPE IOPIN ) | PWRPIN -> ^( PIN_TYPE PWRPIN ) | SUPPIN -> ^( PIN_TYPE SUPPIN ) ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:234:4: ( PIN -> ^( PIN_TYPE PIN ) | INPIN -> ^( PIN_TYPE INPIN ) | OUTPIN -> ^( PIN_TYPE OUTPIN ) | IOPIN -> ^( PIN_TYPE IOPIN ) | PWRPIN -> ^( PIN_TYPE PWRPIN ) | SUPPIN -> ^( PIN_TYPE SUPPIN ) )
            {
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:234:4: ( PIN -> ^( PIN_TYPE PIN ) | INPIN -> ^( PIN_TYPE INPIN ) | OUTPIN -> ^( PIN_TYPE OUTPIN ) | IOPIN -> ^( PIN_TYPE IOPIN ) | PWRPIN -> ^( PIN_TYPE PWRPIN ) | SUPPIN -> ^( PIN_TYPE SUPPIN ) )
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
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:234:5: PIN
                    {
                    PIN19=(Token)match(input,PIN,FOLLOW_PIN_in_pinType458); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PIN.add(PIN19);



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
                    // 234:9: -> ^( PIN_TYPE PIN )
                    {
                        // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:234:12: ^( PIN_TYPE PIN )
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
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:235:4: INPIN
                    {
                    INPIN20=(Token)match(input,INPIN,FOLLOW_INPIN_in_pinType471); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INPIN.add(INPIN20);



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
                    // 235:10: -> ^( PIN_TYPE INPIN )
                    {
                        // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:235:13: ^( PIN_TYPE INPIN )
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
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:236:4: OUTPIN
                    {
                    OUTPIN21=(Token)match(input,OUTPIN,FOLLOW_OUTPIN_in_pinType484); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OUTPIN.add(OUTPIN21);



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
                    // 236:11: -> ^( PIN_TYPE OUTPIN )
                    {
                        // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:236:14: ^( PIN_TYPE OUTPIN )
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
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:237:4: IOPIN
                    {
                    IOPIN22=(Token)match(input,IOPIN,FOLLOW_IOPIN_in_pinType497); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IOPIN.add(IOPIN22);



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
                    // 237:10: -> ^( PIN_TYPE IOPIN )
                    {
                        // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:237:13: ^( PIN_TYPE IOPIN )
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
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:238:4: PWRPIN
                    {
                    PWRPIN23=(Token)match(input,PWRPIN,FOLLOW_PWRPIN_in_pinType510); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PWRPIN.add(PWRPIN23);



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
                    // 238:11: -> ^( PIN_TYPE PWRPIN )
                    {
                        // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:238:14: ^( PIN_TYPE PWRPIN )
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
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:239:4: SUPPIN
                    {
                    SUPPIN24=(Token)match(input,SUPPIN,FOLLOW_SUPPIN_in_pinType523); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SUPPIN.add(SUPPIN24);



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
                    // 239:11: -> ^( PIN_TYPE SUPPIN )
                    {
                        // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:239:14: ^( PIN_TYPE SUPPIN )
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:242:1: widthDecl : LBRACKET INT ( COLON INT )? RBRACKET -> ^( WIDTH_DECL ( INT )+ ) ;
    public final Phdl2Parser.widthDecl_return widthDecl() throws RecognitionException {
        Phdl2Parser.widthDecl_return retval = new Phdl2Parser.widthDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACKET25=null;
        Token INT26=null;
        Token COLON27=null;
        Token INT28=null;
        Token RBRACKET29=null;

        CommonTree LBRACKET25_tree=null;
        CommonTree INT26_tree=null;
        CommonTree COLON27_tree=null;
        CommonTree INT28_tree=null;
        CommonTree RBRACKET29_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:243:2: ( LBRACKET INT ( COLON INT )? RBRACKET -> ^( WIDTH_DECL ( INT )+ ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:243:4: LBRACKET INT ( COLON INT )? RBRACKET
            {
            LBRACKET25=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_widthDecl543); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET25);

            INT26=(Token)match(input,INT,FOLLOW_INT_in_widthDecl545); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INT.add(INT26);

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:243:17: ( COLON INT )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==COLON) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:243:18: COLON INT
                    {
                    COLON27=(Token)match(input,COLON,FOLLOW_COLON_in_widthDecl548); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON27);

                    INT28=(Token)match(input,INT,FOLLOW_INT_in_widthDecl550); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT28);


                    }
                    break;

            }

            RBRACKET29=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_widthDecl554); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET29);



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
            // 243:39: -> ^( WIDTH_DECL ( INT )+ )
            {
                // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:243:42: ^( WIDTH_DECL ( INT )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(WIDTH_DECL, "WIDTH_DECL"), root_1);

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:246:1: pinList : LBRACE pinNumber ( COMMA pinNumber )* RBRACE -> ^( PIN_LIST ( pinNumber )+ ) ;
    public final Phdl2Parser.pinList_return pinList() throws RecognitionException {
        Phdl2Parser.pinList_return retval = new Phdl2Parser.pinList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACE30=null;
        Token COMMA32=null;
        Token RBRACE34=null;
        Phdl2Parser.pinNumber_return pinNumber31 = null;

        Phdl2Parser.pinNumber_return pinNumber33 = null;


        CommonTree LBRACE30_tree=null;
        CommonTree COMMA32_tree=null;
        CommonTree RBRACE34_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_pinNumber=new RewriteRuleSubtreeStream(adaptor,"rule pinNumber");
        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:247:2: ( LBRACE pinNumber ( COMMA pinNumber )* RBRACE -> ^( PIN_LIST ( pinNumber )+ ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:247:5: LBRACE pinNumber ( COMMA pinNumber )* RBRACE
            {
            LBRACE30=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_pinList575); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE30);

            pushFollow(FOLLOW_pinNumber_in_pinList577);
            pinNumber31=pinNumber();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_pinNumber.add(pinNumber31.getTree());
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:247:22: ( COMMA pinNumber )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==COMMA) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:247:23: COMMA pinNumber
            	    {
            	    COMMA32=(Token)match(input,COMMA,FOLLOW_COMMA_in_pinList580); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA32);

            	    pushFollow(FOLLOW_pinNumber_in_pinList582);
            	    pinNumber33=pinNumber();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_pinNumber.add(pinNumber33.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            RBRACE34=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_pinList586); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE34);



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
            // 247:48: -> ^( PIN_LIST ( pinNumber )+ )
            {
                // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:247:51: ^( PIN_LIST ( pinNumber )+ )
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:250:1: pinNumber : ( IDENT | INT | PINNUM );
    public final Phdl2Parser.pinNumber_return pinNumber() throws RecognitionException {
        Phdl2Parser.pinNumber_return retval = new Phdl2Parser.pinNumber_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set35=null;

        CommonTree set35_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:251:2: ( IDENT | INT | PINNUM )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl2.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set35=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||(input.LA(1)>=INT && input.LA(1)<=PINNUM) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set35));
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

    // Delegated rules


 

    public static final BitSet FOLLOW_deviceDecl_in_sourceText337 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_DEVICE_in_deviceDecl350 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl352 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACE_in_deviceDecl354 = new BitSet(new long[]{0x000000FC10004000L});
    public static final BitSet FOLLOW_attrDecl_in_deviceDecl357 = new BitSet(new long[]{0x000000FC10004000L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl361 = new BitSet(new long[]{0x000000FC10004000L});
    public static final BitSet FOLLOW_RBRACE_in_deviceDecl365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ATTR_in_attrDecl391 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_IDENT_in_attrDecl393 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_attrDecl395 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_STRING_in_attrDecl397 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SEMICOLON_in_attrDecl399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pinType_in_pinDecl420 = new BitSet(new long[]{0x0000400000000800L});
    public static final BitSet FOLLOW_widthDecl_in_pinDecl422 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl425 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_pinDecl427 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_pinList_in_pinDecl429 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinDecl431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PIN_in_pinType458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INPIN_in_pinType471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPIN_in_pinType484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IOPIN_in_pinType497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PWRPIN_in_pinType510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUPPIN_in_pinType523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_widthDecl543 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_INT_in_widthDecl545 = new BitSet(new long[]{0x0000000000001020L});
    public static final BitSet FOLLOW_COLON_in_widthDecl548 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_INT_in_widthDecl550 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RBRACKET_in_widthDecl554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_pinList575 = new BitSet(new long[]{0x0003400000000000L});
    public static final BitSet FOLLOW_pinNumber_in_pinList577 = new BitSet(new long[]{0x0000000000004040L});
    public static final BitSet FOLLOW_COMMA_in_pinList580 = new BitSet(new long[]{0x0003400000000000L});
    public static final BitSet FOLLOW_pinNumber_in_pinList582 = new BitSet(new long[]{0x0000000000004040L});
    public static final BitSet FOLLOW_RBRACE_in_pinList586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_pinNumber0 = new BitSet(new long[]{0x0000000000000002L});

}