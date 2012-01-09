// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g 2012-01-09 01:25:03

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SEMICOLON", "COLON", "COMMA", "PERIOD", "EQUALS", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "LANGLE", "RANGLE", "AMPERSAND", "DBLQUOTE", "DESIGN", "DEVICE", "SUBDESIGN", "INST", "SUBINST", "GROUP", "THIS", "OF", "NET", "ATTR", "NEWATTR", "BEGIN", "END", "COMBINE", "INCLUDE", "INFO", "PORT", "PIN", "INPIN", "OUTPIN", "IOPIN", "PWRPIN", "SUPPIN", "DESIGN_DECL", "DEVICE_DECL", "WIDTH_DECL", "NET_DECL", "GROUP_DECL", "INST_DECL", "ATTR_DECL", "PIN_DECL", "PORT_DECL", "INDEX_DECL", "SUBINST_DECL", "SUBATTR_ASSIGN", "PIN_LIST", "PIN_TYPE", "INFO_DECL", "ATTR_ASSIGN", "PIN_ASSIGN", "NET_ASSIGN", "PORT_ASSIGN", "ATTR_QUAL", "BOUNDS", "INDICES", "OPERAND", "NAME", "CONCAT_LIST", "CONCAT_REPL", "OPEN", "IDENT", "STRING", "INT", "PINNUM", "SUB", "D", "E", "S", "I", "G", "N", "V", "C", "U", "B", "T", "R", "O", "P", "H", "F", "A", "W", "M", "L", "CHAR", "DIGIT", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "INCLUDE_DECL", "J", "K", "Q", "X", "Y", "Z"
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
    public static final int PIN=36;
    public static final int INPIN=37;
    public static final int OUTPIN=38;
    public static final int IOPIN=39;
    public static final int PWRPIN=40;
    public static final int SUPPIN=41;
    public static final int DESIGN_DECL=42;
    public static final int DEVICE_DECL=43;
    public static final int WIDTH_DECL=44;
    public static final int NET_DECL=45;
    public static final int GROUP_DECL=46;
    public static final int INST_DECL=47;
    public static final int ATTR_DECL=48;
    public static final int PIN_DECL=49;
    public static final int PORT_DECL=50;
    public static final int INDEX_DECL=51;
    public static final int SUBINST_DECL=52;
    public static final int SUBATTR_ASSIGN=53;
    public static final int PIN_LIST=54;
    public static final int PIN_TYPE=55;
    public static final int INFO_DECL=56;
    public static final int ATTR_ASSIGN=57;
    public static final int PIN_ASSIGN=58;
    public static final int NET_ASSIGN=59;
    public static final int PORT_ASSIGN=60;
    public static final int ATTR_QUAL=61;
    public static final int BOUNDS=62;
    public static final int INDICES=63;
    public static final int OPERAND=64;
    public static final int NAME=65;
    public static final int CONCAT_LIST=66;
    public static final int CONCAT_REPL=67;
    public static final int OPEN=68;
    public static final int IDENT=69;
    public static final int STRING=70;
    public static final int INT=71;
    public static final int PINNUM=72;
    public static final int SUB=73;
    public static final int D=74;
    public static final int E=75;
    public static final int S=76;
    public static final int I=77;
    public static final int G=78;
    public static final int N=79;
    public static final int V=80;
    public static final int C=81;
    public static final int U=82;
    public static final int B=83;
    public static final int T=84;
    public static final int R=85;
    public static final int O=86;
    public static final int P=87;
    public static final int H=88;
    public static final int F=89;
    public static final int A=90;
    public static final int W=91;
    public static final int M=92;
    public static final int L=93;
    public static final int CHAR=94;
    public static final int DIGIT=95;
    public static final int WHITESPACE=96;
    public static final int LINE_COMMENT=97;
    public static final int MULTILINE_COMMENT=98;
    public static final int INCLUDE_DECL=99;
    public static final int J=100;
    public static final int K=101;
    public static final int Q=102;
    public static final int X=103;
    public static final int Y=104;
    public static final int Z=105;

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
    public String getGrammarFileName() { return "C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g"; }



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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:241:1: sourceText : ( deviceDecl | designDecl )+ ;
    public final PhdlParser.sourceText_return sourceText() throws RecognitionException {
        PhdlParser.sourceText_return retval = new PhdlParser.sourceText_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        PhdlParser.deviceDecl_return deviceDecl1 = null;

        PhdlParser.designDecl_return designDecl2 = null;



        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:242:2: ( ( deviceDecl | designDecl )+ )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:242:4: ( deviceDecl | designDecl )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:242:4: ( deviceDecl | designDecl )+
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:242:5: deviceDecl
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_sourceText437);
            	    deviceDecl1=deviceDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, deviceDecl1.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:242:18: designDecl
            	    {
            	    pushFollow(FOLLOW_designDecl_in_sourceText441);
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:245:1: deviceDecl : DEVICE IDENT LBRACE ( infoDecl | attrDecl | pinDecl )* RBRACE -> ^( DEVICE_DECL IDENT ( infoDecl )* ( attrDecl )* ( pinDecl )* ) ;
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:246:2: ( DEVICE IDENT LBRACE ( infoDecl | attrDecl | pinDecl )* RBRACE -> ^( DEVICE_DECL IDENT ( infoDecl )* ( attrDecl )* ( pinDecl )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:246:4: DEVICE IDENT LBRACE ( infoDecl | attrDecl | pinDecl )* RBRACE
            {
            DEVICE3=(Token)match(input,DEVICE,FOLLOW_DEVICE_in_deviceDecl454); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DEVICE.add(DEVICE3);

            IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl456); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT4);

            LBRACE5=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_deviceDecl458); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE5);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:246:24: ( infoDecl | attrDecl | pinDecl )*
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:246:25: infoDecl
            	    {
            	    pushFollow(FOLLOW_infoDecl_in_deviceDecl461);
            	    infoDecl6=infoDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_infoDecl.add(infoDecl6.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:246:36: attrDecl
            	    {
            	    pushFollow(FOLLOW_attrDecl_in_deviceDecl465);
            	    attrDecl7=attrDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_attrDecl.add(attrDecl7.getTree());

            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:246:47: pinDecl
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl469);
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

            RBRACE9=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_deviceDecl473); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE9);



            // AST REWRITE
            // elements: IDENT, attrDecl, pinDecl, infoDecl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 247:3: -> ^( DEVICE_DECL IDENT ( infoDecl )* ( attrDecl )* ( pinDecl )* )
            {
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:247:6: ^( DEVICE_DECL IDENT ( infoDecl )* ( attrDecl )* ( pinDecl )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DEVICE_DECL, "DEVICE_DECL"), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:247:26: ( infoDecl )*
                while ( stream_infoDecl.hasNext() ) {
                    adaptor.addChild(root_1, stream_infoDecl.nextTree());

                }
                stream_infoDecl.reset();
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:247:36: ( attrDecl )*
                while ( stream_attrDecl.hasNext() ) {
                    adaptor.addChild(root_1, stream_attrDecl.nextTree());

                }
                stream_attrDecl.reset();
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:247:46: ( pinDecl )*
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:250:1: attrDecl : ATTR IDENT EQUALS STRING SEMICOLON -> ^( ATTR_DECL IDENT STRING ) ;
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:251:2: ( ATTR IDENT EQUALS STRING SEMICOLON -> ^( ATTR_DECL IDENT STRING ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:251:4: ATTR IDENT EQUALS STRING SEMICOLON
            {
            ATTR10=(Token)match(input,ATTR,FOLLOW_ATTR_in_attrDecl505); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ATTR.add(ATTR10);

            IDENT11=(Token)match(input,IDENT,FOLLOW_IDENT_in_attrDecl507); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT11);

            EQUALS12=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attrDecl509); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS12);

            STRING13=(Token)match(input,STRING,FOLLOW_STRING_in_attrDecl511); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(STRING13);

            SEMICOLON14=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attrDecl513); if (state.failed) return retval; 
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
            // 251:39: -> ^( ATTR_DECL IDENT STRING )
            {
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:251:42: ^( ATTR_DECL IDENT STRING )
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:254:1: pinDecl : pinType ( LBRACKET widthDecl RBRACKET )? IDENT EQUALS pinList SEMICOLON -> ^( PIN_DECL IDENT pinType ( widthDecl )? pinList ) ;
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

        PhdlParser.widthDecl_return widthDecl17 = null;

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
        RewriteRuleSubtreeStream stream_pinList=new RewriteRuleSubtreeStream(adaptor,"rule pinList");
        RewriteRuleSubtreeStream stream_pinType=new RewriteRuleSubtreeStream(adaptor,"rule pinType");
        RewriteRuleSubtreeStream stream_widthDecl=new RewriteRuleSubtreeStream(adaptor,"rule widthDecl");
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:255:2: ( pinType ( LBRACKET widthDecl RBRACKET )? IDENT EQUALS pinList SEMICOLON -> ^( PIN_DECL IDENT pinType ( widthDecl )? pinList ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:255:4: pinType ( LBRACKET widthDecl RBRACKET )? IDENT EQUALS pinList SEMICOLON
            {
            pushFollow(FOLLOW_pinType_in_pinDecl534);
            pinType15=pinType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_pinType.add(pinType15.getTree());
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:255:12: ( LBRACKET widthDecl RBRACKET )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==LBRACKET) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:255:13: LBRACKET widthDecl RBRACKET
                    {
                    LBRACKET16=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_pinDecl537); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET16);

                    pushFollow(FOLLOW_widthDecl_in_pinDecl539);
                    widthDecl17=widthDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_widthDecl.add(widthDecl17.getTree());
                    RBRACKET18=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_pinDecl541); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET18);


                    }
                    break;

            }

            IDENT19=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinDecl545); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT19);

            EQUALS20=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinDecl547); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS20);

            pushFollow(FOLLOW_pinList_in_pinDecl549);
            pinList21=pinList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_pinList.add(pinList21.getTree());
            SEMICOLON22=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinDecl551); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON22);



            // AST REWRITE
            // elements: IDENT, pinList, widthDecl, pinType
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 256:3: -> ^( PIN_DECL IDENT pinType ( widthDecl )? pinList )
            {
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:256:6: ^( PIN_DECL IDENT pinType ( widthDecl )? pinList )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PIN_DECL, "PIN_DECL"), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                adaptor.addChild(root_1, stream_pinType.nextTree());
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:256:31: ( widthDecl )?
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:259:1: pinType : ( PIN -> ^( PIN_TYPE PIN ) | INPIN -> ^( PIN_TYPE INPIN ) | OUTPIN -> ^( PIN_TYPE OUTPIN ) | IOPIN -> ^( PIN_TYPE IOPIN ) | PWRPIN -> ^( PIN_TYPE PWRPIN ) | SUPPIN -> ^( PIN_TYPE SUPPIN ) ) ;
    public final PhdlParser.pinType_return pinType() throws RecognitionException {
        PhdlParser.pinType_return retval = new PhdlParser.pinType_return();
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:260:2: ( ( PIN -> ^( PIN_TYPE PIN ) | INPIN -> ^( PIN_TYPE INPIN ) | OUTPIN -> ^( PIN_TYPE OUTPIN ) | IOPIN -> ^( PIN_TYPE IOPIN ) | PWRPIN -> ^( PIN_TYPE PWRPIN ) | SUPPIN -> ^( PIN_TYPE SUPPIN ) ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:260:4: ( PIN -> ^( PIN_TYPE PIN ) | INPIN -> ^( PIN_TYPE INPIN ) | OUTPIN -> ^( PIN_TYPE OUTPIN ) | IOPIN -> ^( PIN_TYPE IOPIN ) | PWRPIN -> ^( PIN_TYPE PWRPIN ) | SUPPIN -> ^( PIN_TYPE SUPPIN ) )
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:260:4: ( PIN -> ^( PIN_TYPE PIN ) | INPIN -> ^( PIN_TYPE INPIN ) | OUTPIN -> ^( PIN_TYPE OUTPIN ) | IOPIN -> ^( PIN_TYPE IOPIN ) | PWRPIN -> ^( PIN_TYPE PWRPIN ) | SUPPIN -> ^( PIN_TYPE SUPPIN ) )
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:260:5: PIN
                    {
                    PIN23=(Token)match(input,PIN,FOLLOW_PIN_in_pinType581); if (state.failed) return retval; 
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
                    // 260:9: -> ^( PIN_TYPE PIN )
                    {
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:260:12: ^( PIN_TYPE PIN )
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:261:4: INPIN
                    {
                    INPIN24=(Token)match(input,INPIN,FOLLOW_INPIN_in_pinType594); if (state.failed) return retval; 
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
                    // 261:10: -> ^( PIN_TYPE INPIN )
                    {
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:261:13: ^( PIN_TYPE INPIN )
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:262:4: OUTPIN
                    {
                    OUTPIN25=(Token)match(input,OUTPIN,FOLLOW_OUTPIN_in_pinType607); if (state.failed) return retval; 
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
                    // 262:11: -> ^( PIN_TYPE OUTPIN )
                    {
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:262:14: ^( PIN_TYPE OUTPIN )
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:263:4: IOPIN
                    {
                    IOPIN26=(Token)match(input,IOPIN,FOLLOW_IOPIN_in_pinType620); if (state.failed) return retval; 
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
                    // 263:10: -> ^( PIN_TYPE IOPIN )
                    {
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:263:13: ^( PIN_TYPE IOPIN )
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:264:4: PWRPIN
                    {
                    PWRPIN27=(Token)match(input,PWRPIN,FOLLOW_PWRPIN_in_pinType633); if (state.failed) return retval; 
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
                    // 264:11: -> ^( PIN_TYPE PWRPIN )
                    {
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:264:14: ^( PIN_TYPE PWRPIN )
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:265:4: SUPPIN
                    {
                    SUPPIN28=(Token)match(input,SUPPIN,FOLLOW_SUPPIN_in_pinType646); if (state.failed) return retval; 
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
                    // 265:11: -> ^( PIN_TYPE SUPPIN )
                    {
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:265:14: ^( PIN_TYPE SUPPIN )
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:268:1: widthDecl : INT COLON INT -> ^( WIDTH_DECL INT INT ) ;
    public final PhdlParser.widthDecl_return widthDecl() throws RecognitionException {
        PhdlParser.widthDecl_return retval = new PhdlParser.widthDecl_return();
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:269:2: ( INT COLON INT -> ^( WIDTH_DECL INT INT ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:269:4: INT COLON INT
            {
            INT29=(Token)match(input,INT,FOLLOW_INT_in_widthDecl666); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INT.add(INT29);

            COLON30=(Token)match(input,COLON,FOLLOW_COLON_in_widthDecl668); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON30);

            INT31=(Token)match(input,INT,FOLLOW_INT_in_widthDecl670); if (state.failed) return retval; 
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
            // 269:18: -> ^( WIDTH_DECL INT INT )
            {
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:269:21: ^( WIDTH_DECL INT INT )
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:272:1: pinList : LBRACE pinNumber ( COMMA pinNumber )* RBRACE -> ^( PIN_LIST ( pinNumber )+ ) ;
    public final PhdlParser.pinList_return pinList() throws RecognitionException {
        PhdlParser.pinList_return retval = new PhdlParser.pinList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACE32=null;
        Token COMMA34=null;
        Token RBRACE36=null;
        PhdlParser.pinNumber_return pinNumber33 = null;

        PhdlParser.pinNumber_return pinNumber35 = null;


        CommonTree LBRACE32_tree=null;
        CommonTree COMMA34_tree=null;
        CommonTree RBRACE36_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_pinNumber=new RewriteRuleSubtreeStream(adaptor,"rule pinNumber");
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:273:2: ( LBRACE pinNumber ( COMMA pinNumber )* RBRACE -> ^( PIN_LIST ( pinNumber )+ ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:273:5: LBRACE pinNumber ( COMMA pinNumber )* RBRACE
            {
            LBRACE32=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_pinList692); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE32);

            pushFollow(FOLLOW_pinNumber_in_pinList694);
            pinNumber33=pinNumber();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_pinNumber.add(pinNumber33.getTree());
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:273:22: ( COMMA pinNumber )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==COMMA) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:273:23: COMMA pinNumber
            	    {
            	    COMMA34=(Token)match(input,COMMA,FOLLOW_COMMA_in_pinList697); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA34);

            	    pushFollow(FOLLOW_pinNumber_in_pinList699);
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

            RBRACE36=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_pinList703); if (state.failed) return retval; 
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
            // 273:48: -> ^( PIN_LIST ( pinNumber )+ )
            {
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:273:51: ^( PIN_LIST ( pinNumber )+ )
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:276:1: pinNumber : ( IDENT | INT | PINNUM );
    public final PhdlParser.pinNumber_return pinNumber() throws RecognitionException {
        PhdlParser.pinNumber_return retval = new PhdlParser.pinNumber_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set37=null;

        CommonTree set37_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:277:2: ( IDENT | INT | PINNUM )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:280:1: designDecl : DESIGN IDENT LBRACE ( designBody )* RBRACE -> ^( DESIGN_DECL IDENT ( designBody )* ) ;
    public final PhdlParser.designDecl_return designDecl() throws RecognitionException {
        PhdlParser.designDecl_return retval = new PhdlParser.designDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DESIGN38=null;
        Token IDENT39=null;
        Token LBRACE40=null;
        Token RBRACE42=null;
        PhdlParser.designBody_return designBody41 = null;


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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:281:2: ( DESIGN IDENT LBRACE ( designBody )* RBRACE -> ^( DESIGN_DECL IDENT ( designBody )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:281:4: DESIGN IDENT LBRACE ( designBody )* RBRACE
            {
            DESIGN38=(Token)match(input,DESIGN,FOLLOW_DESIGN_in_designDecl744); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DESIGN.add(DESIGN38);

            IDENT39=(Token)match(input,IDENT,FOLLOW_IDENT_in_designDecl746); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT39);

            LBRACE40=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_designDecl748); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE40);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:281:24: ( designBody )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==INST||LA6_0==GROUP||LA6_0==NET||(LA6_0>=INFO && LA6_0<=PORT)||LA6_0==IDENT||LA6_0==SUB) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:0:0: designBody
            	    {
            	    pushFollow(FOLLOW_designBody_in_designDecl750);
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

            RBRACE42=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_designDecl753); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE42);



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
            // 281:43: -> ^( DESIGN_DECL IDENT ( designBody )* )
            {
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:281:46: ^( DESIGN_DECL IDENT ( designBody )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DESIGN_DECL, "DESIGN_DECL"), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:281:66: ( designBody )*
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:284:1: designBody : ( infoDecl | netDecl | instDecl | netAssign | portDecl | subInstDecl | groupDecl );
    public final PhdlParser.designBody_return designBody() throws RecognitionException {
        PhdlParser.designBody_return retval = new PhdlParser.designBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        PhdlParser.infoDecl_return infoDecl43 = null;

        PhdlParser.netDecl_return netDecl44 = null;

        PhdlParser.instDecl_return instDecl45 = null;

        PhdlParser.netAssign_return netAssign46 = null;

        PhdlParser.portDecl_return portDecl47 = null;

        PhdlParser.subInstDecl_return subInstDecl48 = null;

        PhdlParser.groupDecl_return groupDecl49 = null;



        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:285:2: ( infoDecl | netDecl | instDecl | netAssign | portDecl | subInstDecl | groupDecl )
            int alt7=7;
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
            case IDENT:
                {
                alt7=4;
                }
                break;
            case PORT:
                {
                alt7=5;
                }
                break;
            case SUB:
                {
                alt7=6;
                }
                break;
            case GROUP:
                {
                alt7=7;
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:285:4: infoDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_infoDecl_in_designBody776);
                    infoDecl43=infoDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, infoDecl43.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:286:4: netDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_netDecl_in_designBody781);
                    netDecl44=netDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, netDecl44.getTree());

                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:287:4: instDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_instDecl_in_designBody786);
                    instDecl45=instDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, instDecl45.getTree());

                    }
                    break;
                case 4 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:288:4: netAssign
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_netAssign_in_designBody791);
                    netAssign46=netAssign();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, netAssign46.getTree());

                    }
                    break;
                case 5 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:289:4: portDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_portDecl_in_designBody796);
                    portDecl47=portDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, portDecl47.getTree());

                    }
                    break;
                case 6 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:290:4: subInstDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_subInstDecl_in_designBody801);
                    subInstDecl48=subInstDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, subInstDecl48.getTree());

                    }
                    break;
                case 7 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:291:4: groupDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_groupDecl_in_designBody806);
                    groupDecl49=groupDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, groupDecl49.getTree());

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:294:1: infoDecl : INFO LBRACE ( STRING )+ RBRACE -> ^( INFO_DECL ( STRING )+ ) ;
    public final PhdlParser.infoDecl_return infoDecl() throws RecognitionException {
        PhdlParser.infoDecl_return retval = new PhdlParser.infoDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INFO50=null;
        Token LBRACE51=null;
        Token STRING52=null;
        Token RBRACE53=null;

        CommonTree INFO50_tree=null;
        CommonTree LBRACE51_tree=null;
        CommonTree STRING52_tree=null;
        CommonTree RBRACE53_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_INFO=new RewriteRuleTokenStream(adaptor,"token INFO");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:295:2: ( INFO LBRACE ( STRING )+ RBRACE -> ^( INFO_DECL ( STRING )+ ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:295:4: INFO LBRACE ( STRING )+ RBRACE
            {
            INFO50=(Token)match(input,INFO,FOLLOW_INFO_in_infoDecl818); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INFO.add(INFO50);

            LBRACE51=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_infoDecl820); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE51);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:295:16: ( STRING )+
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:0:0: STRING
            	    {
            	    STRING52=(Token)match(input,STRING,FOLLOW_STRING_in_infoDecl822); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_STRING.add(STRING52);


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

            RBRACE53=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_infoDecl825); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE53);



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
            // 295:31: -> ^( INFO_DECL ( STRING )+ )
            {
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:295:34: ^( INFO_DECL ( STRING )+ )
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:298:1: netDecl : NET ( LBRACKET widthDecl RBRACKET )? IDENT ( COMMA IDENT )* ( ( LBRACE ( attrDecl )* RBRACE ) | SEMICOLON ) -> ^( NET_DECL ( widthDecl )? ( IDENT )+ ( attrDecl )* ) ;
    public final PhdlParser.netDecl_return netDecl() throws RecognitionException {
        PhdlParser.netDecl_return retval = new PhdlParser.netDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NET54=null;
        Token LBRACKET55=null;
        Token RBRACKET57=null;
        Token IDENT58=null;
        Token COMMA59=null;
        Token IDENT60=null;
        Token LBRACE61=null;
        Token RBRACE63=null;
        Token SEMICOLON64=null;
        PhdlParser.widthDecl_return widthDecl56 = null;

        PhdlParser.attrDecl_return attrDecl62 = null;


        CommonTree NET54_tree=null;
        CommonTree LBRACKET55_tree=null;
        CommonTree RBRACKET57_tree=null;
        CommonTree IDENT58_tree=null;
        CommonTree COMMA59_tree=null;
        CommonTree IDENT60_tree=null;
        CommonTree LBRACE61_tree=null;
        CommonTree RBRACE63_tree=null;
        CommonTree SEMICOLON64_tree=null;
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:299:2: ( NET ( LBRACKET widthDecl RBRACKET )? IDENT ( COMMA IDENT )* ( ( LBRACE ( attrDecl )* RBRACE ) | SEMICOLON ) -> ^( NET_DECL ( widthDecl )? ( IDENT )+ ( attrDecl )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:299:4: NET ( LBRACKET widthDecl RBRACKET )? IDENT ( COMMA IDENT )* ( ( LBRACE ( attrDecl )* RBRACE ) | SEMICOLON )
            {
            NET54=(Token)match(input,NET,FOLLOW_NET_in_netDecl846); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NET.add(NET54);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:299:8: ( LBRACKET widthDecl RBRACKET )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==LBRACKET) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:299:9: LBRACKET widthDecl RBRACKET
                    {
                    LBRACKET55=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_netDecl849); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET55);

                    pushFollow(FOLLOW_widthDecl_in_netDecl851);
                    widthDecl56=widthDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_widthDecl.add(widthDecl56.getTree());
                    RBRACKET57=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_netDecl853); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET57);


                    }
                    break;

            }

            IDENT58=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl857); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT58);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:299:45: ( COMMA IDENT )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==COMMA) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:299:46: COMMA IDENT
            	    {
            	    COMMA59=(Token)match(input,COMMA,FOLLOW_COMMA_in_netDecl860); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA59);

            	    IDENT60=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl862); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_IDENT.add(IDENT60);


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:299:60: ( ( LBRACE ( attrDecl )* RBRACE ) | SEMICOLON )
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:299:61: ( LBRACE ( attrDecl )* RBRACE )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:299:61: ( LBRACE ( attrDecl )* RBRACE )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:299:62: LBRACE ( attrDecl )* RBRACE
                    {
                    LBRACE61=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_netDecl868); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE61);

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:299:69: ( attrDecl )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==ATTR) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:0:0: attrDecl
                    	    {
                    	    pushFollow(FOLLOW_attrDecl_in_netDecl870);
                    	    attrDecl62=attrDecl();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_attrDecl.add(attrDecl62.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    RBRACE63=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_netDecl873); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE63);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:299:89: SEMICOLON
                    {
                    SEMICOLON64=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netDecl878); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON64);


                    }
                    break;

            }



            // AST REWRITE
            // elements: IDENT, widthDecl, attrDecl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 300:3: -> ^( NET_DECL ( widthDecl )? ( IDENT )+ ( attrDecl )* )
            {
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:300:6: ^( NET_DECL ( widthDecl )? ( IDENT )+ ( attrDecl )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NET_DECL, "NET_DECL"), root_1);

                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:300:17: ( widthDecl )?
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
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:300:35: ( attrDecl )*
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:303:1: instDecl : INST ( LPAREN widthDecl RPAREN )? IDENT OF IDENT LBRACE ( infoDecl | attrAssign | pinAssign )* RBRACE -> ^( INST_DECL ( widthDecl )? IDENT IDENT ( infoDecl )* ( attrAssign )* ( pinAssign )* ) ;
    public final PhdlParser.instDecl_return instDecl() throws RecognitionException {
        PhdlParser.instDecl_return retval = new PhdlParser.instDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INST65=null;
        Token LPAREN66=null;
        Token RPAREN68=null;
        Token IDENT69=null;
        Token OF70=null;
        Token IDENT71=null;
        Token LBRACE72=null;
        Token RBRACE76=null;
        PhdlParser.widthDecl_return widthDecl67 = null;

        PhdlParser.infoDecl_return infoDecl73 = null;

        PhdlParser.attrAssign_return attrAssign74 = null;

        PhdlParser.pinAssign_return pinAssign75 = null;


        CommonTree INST65_tree=null;
        CommonTree LPAREN66_tree=null;
        CommonTree RPAREN68_tree=null;
        CommonTree IDENT69_tree=null;
        CommonTree OF70_tree=null;
        CommonTree IDENT71_tree=null;
        CommonTree LBRACE72_tree=null;
        CommonTree RBRACE76_tree=null;
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
        RewriteRuleSubtreeStream stream_pinAssign=new RewriteRuleSubtreeStream(adaptor,"rule pinAssign");
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:304:2: ( INST ( LPAREN widthDecl RPAREN )? IDENT OF IDENT LBRACE ( infoDecl | attrAssign | pinAssign )* RBRACE -> ^( INST_DECL ( widthDecl )? IDENT IDENT ( infoDecl )* ( attrAssign )* ( pinAssign )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:304:4: INST ( LPAREN widthDecl RPAREN )? IDENT OF IDENT LBRACE ( infoDecl | attrAssign | pinAssign )* RBRACE
            {
            INST65=(Token)match(input,INST,FOLLOW_INST_in_instDecl909); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INST.add(INST65);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:304:9: ( LPAREN widthDecl RPAREN )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==LPAREN) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:304:10: LPAREN widthDecl RPAREN
                    {
                    LPAREN66=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_instDecl912); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN66);

                    pushFollow(FOLLOW_widthDecl_in_instDecl914);
                    widthDecl67=widthDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_widthDecl.add(widthDecl67.getTree());
                    RPAREN68=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_instDecl916); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN68);


                    }
                    break;

            }

            IDENT69=(Token)match(input,IDENT,FOLLOW_IDENT_in_instDecl920); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT69);

            OF70=(Token)match(input,OF,FOLLOW_OF_in_instDecl922); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_OF.add(OF70);

            IDENT71=(Token)match(input,IDENT,FOLLOW_IDENT_in_instDecl924); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT71);

            LBRACE72=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_instDecl926); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE72);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:304:58: ( infoDecl | attrAssign | pinAssign )*
            loop14:
            do {
                int alt14=4;
                alt14 = dfa14.predict(input);
                switch (alt14) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:304:59: infoDecl
            	    {
            	    pushFollow(FOLLOW_infoDecl_in_instDecl929);
            	    infoDecl73=infoDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_infoDecl.add(infoDecl73.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:304:70: attrAssign
            	    {
            	    pushFollow(FOLLOW_attrAssign_in_instDecl933);
            	    attrAssign74=attrAssign();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_attrAssign.add(attrAssign74.getTree());

            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:304:83: pinAssign
            	    {
            	    pushFollow(FOLLOW_pinAssign_in_instDecl937);
            	    pinAssign75=pinAssign();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_pinAssign.add(pinAssign75.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            RBRACE76=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_instDecl941); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE76);



            // AST REWRITE
            // elements: widthDecl, attrAssign, IDENT, IDENT, pinAssign, infoDecl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 305:3: -> ^( INST_DECL ( widthDecl )? IDENT IDENT ( infoDecl )* ( attrAssign )* ( pinAssign )* )
            {
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:305:6: ^( INST_DECL ( widthDecl )? IDENT IDENT ( infoDecl )* ( attrAssign )* ( pinAssign )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INST_DECL, "INST_DECL"), root_1);

                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:305:18: ( widthDecl )?
                if ( stream_widthDecl.hasNext() ) {
                    adaptor.addChild(root_1, stream_widthDecl.nextTree());

                }
                stream_widthDecl.reset();
                adaptor.addChild(root_1, stream_IDENT.nextNode());
                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:305:41: ( infoDecl )*
                while ( stream_infoDecl.hasNext() ) {
                    adaptor.addChild(root_1, stream_infoDecl.nextTree());

                }
                stream_infoDecl.reset();
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:305:51: ( attrAssign )*
                while ( stream_attrAssign.hasNext() ) {
                    adaptor.addChild(root_1, stream_attrAssign.nextTree());

                }
                stream_attrAssign.reset();
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:305:63: ( pinAssign )*
                while ( stream_pinAssign.hasNext() ) {
                    adaptor.addChild(root_1, stream_pinAssign.nextTree());

                }
                stream_pinAssign.reset();

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:308:1: attrAssign : ( NEWATTR )? ( qualifier )? IDENT EQUALS STRING SEMICOLON -> ^( ATTR_ASSIGN ( NEWATTR )? ( qualifier )? IDENT STRING ) ;
    public final PhdlParser.attrAssign_return attrAssign() throws RecognitionException {
        PhdlParser.attrAssign_return retval = new PhdlParser.attrAssign_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NEWATTR77=null;
        Token IDENT79=null;
        Token EQUALS80=null;
        Token STRING81=null;
        Token SEMICOLON82=null;
        PhdlParser.qualifier_return qualifier78 = null;


        CommonTree NEWATTR77_tree=null;
        CommonTree IDENT79_tree=null;
        CommonTree EQUALS80_tree=null;
        CommonTree STRING81_tree=null;
        CommonTree SEMICOLON82_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_NEWATTR=new RewriteRuleTokenStream(adaptor,"token NEWATTR");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_qualifier=new RewriteRuleSubtreeStream(adaptor,"rule qualifier");
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:309:2: ( ( NEWATTR )? ( qualifier )? IDENT EQUALS STRING SEMICOLON -> ^( ATTR_ASSIGN ( NEWATTR )? ( qualifier )? IDENT STRING ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:309:4: ( NEWATTR )? ( qualifier )? IDENT EQUALS STRING SEMICOLON
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:309:4: ( NEWATTR )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==NEWATTR) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:0:0: NEWATTR
                    {
                    NEWATTR77=(Token)match(input,NEWATTR,FOLLOW_NEWATTR_in_attrAssign977); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NEWATTR.add(NEWATTR77);


                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:309:13: ( qualifier )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==THIS) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:0:0: qualifier
                    {
                    pushFollow(FOLLOW_qualifier_in_attrAssign980);
                    qualifier78=qualifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_qualifier.add(qualifier78.getTree());

                    }
                    break;

            }

            IDENT79=(Token)match(input,IDENT,FOLLOW_IDENT_in_attrAssign983); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT79);

            EQUALS80=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attrAssign985); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS80);

            STRING81=(Token)match(input,STRING,FOLLOW_STRING_in_attrAssign987); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(STRING81);

            SEMICOLON82=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attrAssign989); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON82);



            // AST REWRITE
            // elements: IDENT, qualifier, STRING, NEWATTR
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 310:3: -> ^( ATTR_ASSIGN ( NEWATTR )? ( qualifier )? IDENT STRING )
            {
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:310:6: ^( ATTR_ASSIGN ( NEWATTR )? ( qualifier )? IDENT STRING )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ATTR_ASSIGN, "ATTR_ASSIGN"), root_1);

                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:310:20: ( NEWATTR )?
                if ( stream_NEWATTR.hasNext() ) {
                    adaptor.addChild(root_1, stream_NEWATTR.nextNode());

                }
                stream_NEWATTR.reset();
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:310:29: ( qualifier )?
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

    public static class pinAssign_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pinAssign"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:313:1: pinAssign : ( ( COMBINE LPAREN ( qualifier )? operand RPAREN ) | ( qualifier )? operand ) EQUALS concatenation SEMICOLON -> ^( PIN_ASSIGN ( COMBINE )? ( qualifier )? operand concatenation ) ;
    public final PhdlParser.pinAssign_return pinAssign() throws RecognitionException {
        PhdlParser.pinAssign_return retval = new PhdlParser.pinAssign_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMBINE83=null;
        Token LPAREN84=null;
        Token RPAREN87=null;
        Token EQUALS90=null;
        Token SEMICOLON92=null;
        PhdlParser.qualifier_return qualifier85 = null;

        PhdlParser.operand_return operand86 = null;

        PhdlParser.qualifier_return qualifier88 = null;

        PhdlParser.operand_return operand89 = null;

        PhdlParser.concatenation_return concatenation91 = null;


        CommonTree COMBINE83_tree=null;
        CommonTree LPAREN84_tree=null;
        CommonTree RPAREN87_tree=null;
        CommonTree EQUALS90_tree=null;
        CommonTree SEMICOLON92_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_COMBINE=new RewriteRuleTokenStream(adaptor,"token COMBINE");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_qualifier=new RewriteRuleSubtreeStream(adaptor,"rule qualifier");
        RewriteRuleSubtreeStream stream_operand=new RewriteRuleSubtreeStream(adaptor,"rule operand");
        RewriteRuleSubtreeStream stream_concatenation=new RewriteRuleSubtreeStream(adaptor,"rule concatenation");
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:314:2: ( ( ( COMBINE LPAREN ( qualifier )? operand RPAREN ) | ( qualifier )? operand ) EQUALS concatenation SEMICOLON -> ^( PIN_ASSIGN ( COMBINE )? ( qualifier )? operand concatenation ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:314:4: ( ( COMBINE LPAREN ( qualifier )? operand RPAREN ) | ( qualifier )? operand ) EQUALS concatenation SEMICOLON
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:314:4: ( ( COMBINE LPAREN ( qualifier )? operand RPAREN ) | ( qualifier )? operand )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==COMBINE) ) {
                alt19=1;
            }
            else if ( (LA19_0==THIS||LA19_0==IDENT) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:314:5: ( COMBINE LPAREN ( qualifier )? operand RPAREN )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:314:5: ( COMBINE LPAREN ( qualifier )? operand RPAREN )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:314:6: COMBINE LPAREN ( qualifier )? operand RPAREN
                    {
                    COMBINE83=(Token)match(input,COMBINE,FOLLOW_COMBINE_in_pinAssign1022); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COMBINE.add(COMBINE83);

                    LPAREN84=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_pinAssign1024); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN84);

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:314:21: ( qualifier )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==THIS) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:0:0: qualifier
                            {
                            pushFollow(FOLLOW_qualifier_in_pinAssign1026);
                            qualifier85=qualifier();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_qualifier.add(qualifier85.getTree());

                            }
                            break;

                    }

                    pushFollow(FOLLOW_operand_in_pinAssign1029);
                    operand86=operand();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_operand.add(operand86.getTree());
                    RPAREN87=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_pinAssign1031); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN87);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:314:50: ( qualifier )? operand
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:314:50: ( qualifier )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==THIS) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:0:0: qualifier
                            {
                            pushFollow(FOLLOW_qualifier_in_pinAssign1036);
                            qualifier88=qualifier();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_qualifier.add(qualifier88.getTree());

                            }
                            break;

                    }

                    pushFollow(FOLLOW_operand_in_pinAssign1039);
                    operand89=operand();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_operand.add(operand89.getTree());

                    }
                    break;

            }

            EQUALS90=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinAssign1042); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS90);

            pushFollow(FOLLOW_concatenation_in_pinAssign1044);
            concatenation91=concatenation();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_concatenation.add(concatenation91.getTree());
            SEMICOLON92=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinAssign1046); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON92);



            // AST REWRITE
            // elements: qualifier, concatenation, operand, COMBINE
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 315:3: -> ^( PIN_ASSIGN ( COMBINE )? ( qualifier )? operand concatenation )
            {
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:315:6: ^( PIN_ASSIGN ( COMBINE )? ( qualifier )? operand concatenation )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PIN_ASSIGN, "PIN_ASSIGN"), root_1);

                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:315:19: ( COMBINE )?
                if ( stream_COMBINE.hasNext() ) {
                    adaptor.addChild(root_1, stream_COMBINE.nextNode());

                }
                stream_COMBINE.reset();
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:315:28: ( qualifier )?
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
    // $ANTLR end "pinAssign"

    public static class netAssign_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "netAssign"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:318:1: netAssign : operand EQUALS concatenation SEMICOLON -> ^( NET_ASSIGN operand concatenation ) ;
    public final PhdlParser.netAssign_return netAssign() throws RecognitionException {
        PhdlParser.netAssign_return retval = new PhdlParser.netAssign_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQUALS94=null;
        Token SEMICOLON96=null;
        PhdlParser.operand_return operand93 = null;

        PhdlParser.concatenation_return concatenation95 = null;


        CommonTree EQUALS94_tree=null;
        CommonTree SEMICOLON96_tree=null;
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleSubtreeStream stream_operand=new RewriteRuleSubtreeStream(adaptor,"rule operand");
        RewriteRuleSubtreeStream stream_concatenation=new RewriteRuleSubtreeStream(adaptor,"rule concatenation");
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:319:2: ( operand EQUALS concatenation SEMICOLON -> ^( NET_ASSIGN operand concatenation ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:319:4: operand EQUALS concatenation SEMICOLON
            {
            pushFollow(FOLLOW_operand_in_netAssign1077);
            operand93=operand();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_operand.add(operand93.getTree());
            EQUALS94=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_netAssign1079); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS94);

            pushFollow(FOLLOW_concatenation_in_netAssign1081);
            concatenation95=concatenation();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_concatenation.add(concatenation95.getTree());
            SEMICOLON96=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netAssign1083); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON96);



            // AST REWRITE
            // elements: operand, concatenation
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 319:43: -> ^( NET_ASSIGN operand concatenation )
            {
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:319:46: ^( NET_ASSIGN operand concatenation )
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

    public static class subInstDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subInstDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:322:1: subInstDecl : SUB ( widthDecl )? IDENT OF IDENT LBRACE ( infoDecl | subAttrAssign | portAssign )* RBRACE -> ^( SUBINST_DECL widthDecl IDENT IDENT ( infoDecl )* ( subAttrAssign )* ( portAssign )* ) ;
    public final PhdlParser.subInstDecl_return subInstDecl() throws RecognitionException {
        PhdlParser.subInstDecl_return retval = new PhdlParser.subInstDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SUB97=null;
        Token IDENT99=null;
        Token OF100=null;
        Token IDENT101=null;
        Token LBRACE102=null;
        Token RBRACE106=null;
        PhdlParser.widthDecl_return widthDecl98 = null;

        PhdlParser.infoDecl_return infoDecl103 = null;

        PhdlParser.subAttrAssign_return subAttrAssign104 = null;

        PhdlParser.portAssign_return portAssign105 = null;


        CommonTree SUB97_tree=null;
        CommonTree IDENT99_tree=null;
        CommonTree OF100_tree=null;
        CommonTree IDENT101_tree=null;
        CommonTree LBRACE102_tree=null;
        CommonTree RBRACE106_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_SUB=new RewriteRuleTokenStream(adaptor,"token SUB");
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_OF=new RewriteRuleTokenStream(adaptor,"token OF");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_subAttrAssign=new RewriteRuleSubtreeStream(adaptor,"rule subAttrAssign");
        RewriteRuleSubtreeStream stream_infoDecl=new RewriteRuleSubtreeStream(adaptor,"rule infoDecl");
        RewriteRuleSubtreeStream stream_widthDecl=new RewriteRuleSubtreeStream(adaptor,"rule widthDecl");
        RewriteRuleSubtreeStream stream_portAssign=new RewriteRuleSubtreeStream(adaptor,"rule portAssign");
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:323:2: ( SUB ( widthDecl )? IDENT OF IDENT LBRACE ( infoDecl | subAttrAssign | portAssign )* RBRACE -> ^( SUBINST_DECL widthDecl IDENT IDENT ( infoDecl )* ( subAttrAssign )* ( portAssign )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:323:4: SUB ( widthDecl )? IDENT OF IDENT LBRACE ( infoDecl | subAttrAssign | portAssign )* RBRACE
            {
            SUB97=(Token)match(input,SUB,FOLLOW_SUB_in_subInstDecl1105); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SUB.add(SUB97);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:323:8: ( widthDecl )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==INT) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:0:0: widthDecl
                    {
                    pushFollow(FOLLOW_widthDecl_in_subInstDecl1107);
                    widthDecl98=widthDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_widthDecl.add(widthDecl98.getTree());

                    }
                    break;

            }

            IDENT99=(Token)match(input,IDENT,FOLLOW_IDENT_in_subInstDecl1110); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT99);

            OF100=(Token)match(input,OF,FOLLOW_OF_in_subInstDecl1112); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_OF.add(OF100);

            IDENT101=(Token)match(input,IDENT,FOLLOW_IDENT_in_subInstDecl1114); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT101);

            LBRACE102=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_subInstDecl1116); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE102);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:323:41: ( infoDecl | subAttrAssign | portAssign )*
            loop21:
            do {
                int alt21=4;
                alt21 = dfa21.predict(input);
                switch (alt21) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:323:42: infoDecl
            	    {
            	    pushFollow(FOLLOW_infoDecl_in_subInstDecl1119);
            	    infoDecl103=infoDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_infoDecl.add(infoDecl103.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:323:53: subAttrAssign
            	    {
            	    pushFollow(FOLLOW_subAttrAssign_in_subInstDecl1123);
            	    subAttrAssign104=subAttrAssign();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_subAttrAssign.add(subAttrAssign104.getTree());

            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:323:69: portAssign
            	    {
            	    pushFollow(FOLLOW_portAssign_in_subInstDecl1127);
            	    portAssign105=portAssign();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_portAssign.add(portAssign105.getTree());

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            RBRACE106=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_subInstDecl1131); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE106);



            // AST REWRITE
            // elements: widthDecl, IDENT, IDENT, subAttrAssign, portAssign, infoDecl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 324:3: -> ^( SUBINST_DECL widthDecl IDENT IDENT ( infoDecl )* ( subAttrAssign )* ( portAssign )* )
            {
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:324:6: ^( SUBINST_DECL widthDecl IDENT IDENT ( infoDecl )* ( subAttrAssign )* ( portAssign )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SUBINST_DECL, "SUBINST_DECL"), root_1);

                adaptor.addChild(root_1, stream_widthDecl.nextTree());
                adaptor.addChild(root_1, stream_IDENT.nextNode());
                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:324:43: ( infoDecl )*
                while ( stream_infoDecl.hasNext() ) {
                    adaptor.addChild(root_1, stream_infoDecl.nextTree());

                }
                stream_infoDecl.reset();
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:324:53: ( subAttrAssign )*
                while ( stream_subAttrAssign.hasNext() ) {
                    adaptor.addChild(root_1, stream_subAttrAssign.nextTree());

                }
                stream_subAttrAssign.reset();
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:324:68: ( portAssign )*
                while ( stream_portAssign.hasNext() ) {
                    adaptor.addChild(root_1, stream_portAssign.nextTree());

                }
                stream_portAssign.reset();

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
    // $ANTLR end "subInstDecl"

    public static class subAttrAssign_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subAttrAssign"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:327:1: subAttrAssign : ( NEWATTR )? ( qualifier )? name ( PERIOD name )* EQUALS STRING SEMICOLON -> ^( SUBATTR_ASSIGN ( NEWATTR )? ( qualifier )? ( name )+ STRING ) ;
    public final PhdlParser.subAttrAssign_return subAttrAssign() throws RecognitionException {
        PhdlParser.subAttrAssign_return retval = new PhdlParser.subAttrAssign_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NEWATTR107=null;
        Token PERIOD110=null;
        Token EQUALS112=null;
        Token STRING113=null;
        Token SEMICOLON114=null;
        PhdlParser.qualifier_return qualifier108 = null;

        PhdlParser.name_return name109 = null;

        PhdlParser.name_return name111 = null;


        CommonTree NEWATTR107_tree=null;
        CommonTree PERIOD110_tree=null;
        CommonTree EQUALS112_tree=null;
        CommonTree STRING113_tree=null;
        CommonTree SEMICOLON114_tree=null;
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_NEWATTR=new RewriteRuleTokenStream(adaptor,"token NEWATTR");
        RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_name=new RewriteRuleSubtreeStream(adaptor,"rule name");
        RewriteRuleSubtreeStream stream_qualifier=new RewriteRuleSubtreeStream(adaptor,"rule qualifier");
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:328:2: ( ( NEWATTR )? ( qualifier )? name ( PERIOD name )* EQUALS STRING SEMICOLON -> ^( SUBATTR_ASSIGN ( NEWATTR )? ( qualifier )? ( name )+ STRING ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:328:4: ( NEWATTR )? ( qualifier )? name ( PERIOD name )* EQUALS STRING SEMICOLON
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:328:4: ( NEWATTR )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==NEWATTR) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:0:0: NEWATTR
                    {
                    NEWATTR107=(Token)match(input,NEWATTR,FOLLOW_NEWATTR_in_subAttrAssign1166); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NEWATTR.add(NEWATTR107);


                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:328:13: ( qualifier )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==THIS) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:0:0: qualifier
                    {
                    pushFollow(FOLLOW_qualifier_in_subAttrAssign1169);
                    qualifier108=qualifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_qualifier.add(qualifier108.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_name_in_subAttrAssign1172);
            name109=name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_name.add(name109.getTree());
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:328:29: ( PERIOD name )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==PERIOD) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:328:30: PERIOD name
            	    {
            	    PERIOD110=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_subAttrAssign1175); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD110);

            	    pushFollow(FOLLOW_name_in_subAttrAssign1177);
            	    name111=name();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_name.add(name111.getTree());

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            EQUALS112=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_subAttrAssign1181); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS112);

            STRING113=(Token)match(input,STRING,FOLLOW_STRING_in_subAttrAssign1183); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(STRING113);

            SEMICOLON114=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_subAttrAssign1185); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON114);



            // AST REWRITE
            // elements: NEWATTR, name, qualifier, STRING
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 329:3: -> ^( SUBATTR_ASSIGN ( NEWATTR )? ( qualifier )? ( name )+ STRING )
            {
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:329:6: ^( SUBATTR_ASSIGN ( NEWATTR )? ( qualifier )? ( name )+ STRING )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SUBATTR_ASSIGN, "SUBATTR_ASSIGN"), root_1);

                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:329:23: ( NEWATTR )?
                if ( stream_NEWATTR.hasNext() ) {
                    adaptor.addChild(root_1, stream_NEWATTR.nextNode());

                }
                stream_NEWATTR.reset();
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:329:32: ( qualifier )?
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

    public static class portDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "portDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:332:1: portDecl : PORT ( widthDecl )? IDENT ( COMMA IDENT )* SEMICOLON -> ^( PORT_DECL ( widthDecl )? ( IDENT )+ ) ;
    public final PhdlParser.portDecl_return portDecl() throws RecognitionException {
        PhdlParser.portDecl_return retval = new PhdlParser.portDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PORT115=null;
        Token IDENT117=null;
        Token COMMA118=null;
        Token IDENT119=null;
        Token SEMICOLON120=null;
        PhdlParser.widthDecl_return widthDecl116 = null;


        CommonTree PORT115_tree=null;
        CommonTree IDENT117_tree=null;
        CommonTree COMMA118_tree=null;
        CommonTree IDENT119_tree=null;
        CommonTree SEMICOLON120_tree=null;
        RewriteRuleTokenStream stream_PORT=new RewriteRuleTokenStream(adaptor,"token PORT");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_widthDecl=new RewriteRuleSubtreeStream(adaptor,"rule widthDecl");
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:333:2: ( PORT ( widthDecl )? IDENT ( COMMA IDENT )* SEMICOLON -> ^( PORT_DECL ( widthDecl )? ( IDENT )+ ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:333:4: PORT ( widthDecl )? IDENT ( COMMA IDENT )* SEMICOLON
            {
            PORT115=(Token)match(input,PORT,FOLLOW_PORT_in_portDecl1216); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PORT.add(PORT115);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:333:9: ( widthDecl )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==INT) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:0:0: widthDecl
                    {
                    pushFollow(FOLLOW_widthDecl_in_portDecl1218);
                    widthDecl116=widthDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_widthDecl.add(widthDecl116.getTree());

                    }
                    break;

            }

            IDENT117=(Token)match(input,IDENT,FOLLOW_IDENT_in_portDecl1221); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT117);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:333:26: ( COMMA IDENT )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==COMMA) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:333:27: COMMA IDENT
            	    {
            	    COMMA118=(Token)match(input,COMMA,FOLLOW_COMMA_in_portDecl1224); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA118);

            	    IDENT119=(Token)match(input,IDENT,FOLLOW_IDENT_in_portDecl1226); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_IDENT.add(IDENT119);


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            SEMICOLON120=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_portDecl1230); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON120);



            // AST REWRITE
            // elements: IDENT, widthDecl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 333:51: -> ^( PORT_DECL ( widthDecl )? ( IDENT )+ )
            {
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:333:54: ^( PORT_DECL ( widthDecl )? ( IDENT )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PORT_DECL, "PORT_DECL"), root_1);

                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:333:66: ( widthDecl )?
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
    // $ANTLR end "portDecl"

    public static class portAssign_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "portAssign"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:336:1: portAssign : ( ( COMBINE LPAREN ( qualifier )? operand RPAREN ) | ( qualifier )? operand ) EQUALS concatenation SEMICOLON -> ^( PORT_ASSIGN ( COMBINE )? ( qualifier )? operand concatenation ) ;
    public final PhdlParser.portAssign_return portAssign() throws RecognitionException {
        PhdlParser.portAssign_return retval = new PhdlParser.portAssign_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMBINE121=null;
        Token LPAREN122=null;
        Token RPAREN125=null;
        Token EQUALS128=null;
        Token SEMICOLON130=null;
        PhdlParser.qualifier_return qualifier123 = null;

        PhdlParser.operand_return operand124 = null;

        PhdlParser.qualifier_return qualifier126 = null;

        PhdlParser.operand_return operand127 = null;

        PhdlParser.concatenation_return concatenation129 = null;


        CommonTree COMBINE121_tree=null;
        CommonTree LPAREN122_tree=null;
        CommonTree RPAREN125_tree=null;
        CommonTree EQUALS128_tree=null;
        CommonTree SEMICOLON130_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_COMBINE=new RewriteRuleTokenStream(adaptor,"token COMBINE");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_qualifier=new RewriteRuleSubtreeStream(adaptor,"rule qualifier");
        RewriteRuleSubtreeStream stream_operand=new RewriteRuleSubtreeStream(adaptor,"rule operand");
        RewriteRuleSubtreeStream stream_concatenation=new RewriteRuleSubtreeStream(adaptor,"rule concatenation");
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:337:2: ( ( ( COMBINE LPAREN ( qualifier )? operand RPAREN ) | ( qualifier )? operand ) EQUALS concatenation SEMICOLON -> ^( PORT_ASSIGN ( COMBINE )? ( qualifier )? operand concatenation ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:337:4: ( ( COMBINE LPAREN ( qualifier )? operand RPAREN ) | ( qualifier )? operand ) EQUALS concatenation SEMICOLON
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:337:4: ( ( COMBINE LPAREN ( qualifier )? operand RPAREN ) | ( qualifier )? operand )
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:337:5: ( COMBINE LPAREN ( qualifier )? operand RPAREN )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:337:5: ( COMBINE LPAREN ( qualifier )? operand RPAREN )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:337:6: COMBINE LPAREN ( qualifier )? operand RPAREN
                    {
                    COMBINE121=(Token)match(input,COMBINE,FOLLOW_COMBINE_in_portAssign1256); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COMBINE.add(COMBINE121);

                    LPAREN122=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_portAssign1258); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN122);

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:337:21: ( qualifier )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==THIS) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:0:0: qualifier
                            {
                            pushFollow(FOLLOW_qualifier_in_portAssign1260);
                            qualifier123=qualifier();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_qualifier.add(qualifier123.getTree());

                            }
                            break;

                    }

                    pushFollow(FOLLOW_operand_in_portAssign1263);
                    operand124=operand();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_operand.add(operand124.getTree());
                    RPAREN125=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_portAssign1265); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN125);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:337:50: ( qualifier )? operand
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:337:50: ( qualifier )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==THIS) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:0:0: qualifier
                            {
                            pushFollow(FOLLOW_qualifier_in_portAssign1270);
                            qualifier126=qualifier();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_qualifier.add(qualifier126.getTree());

                            }
                            break;

                    }

                    pushFollow(FOLLOW_operand_in_portAssign1273);
                    operand127=operand();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_operand.add(operand127.getTree());

                    }
                    break;

            }

            EQUALS128=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_portAssign1276); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS128);

            pushFollow(FOLLOW_concatenation_in_portAssign1278);
            concatenation129=concatenation();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_concatenation.add(concatenation129.getTree());
            SEMICOLON130=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_portAssign1280); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON130);



            // AST REWRITE
            // elements: concatenation, qualifier, operand, COMBINE
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 338:3: -> ^( PORT_ASSIGN ( COMBINE )? ( qualifier )? operand concatenation )
            {
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:338:6: ^( PORT_ASSIGN ( COMBINE )? ( qualifier )? operand concatenation )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PORT_ASSIGN, "PORT_ASSIGN"), root_1);

                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:338:20: ( COMBINE )?
                if ( stream_COMBINE.hasNext() ) {
                    adaptor.addChild(root_1, stream_COMBINE.nextNode());

                }
                stream_COMBINE.reset();
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:338:29: ( qualifier )?
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
    // $ANTLR end "portAssign"

    public static class groupDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "groupDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:341:1: groupDecl : GROUP STRING LBRACE ( groupBody )* RBRACE -> ^( GROUP_DECL STRING ( groupBody )* ) ;
    public final PhdlParser.groupDecl_return groupDecl() throws RecognitionException {
        PhdlParser.groupDecl_return retval = new PhdlParser.groupDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token GROUP131=null;
        Token STRING132=null;
        Token LBRACE133=null;
        Token RBRACE135=null;
        PhdlParser.groupBody_return groupBody134 = null;


        CommonTree GROUP131_tree=null;
        CommonTree STRING132_tree=null;
        CommonTree LBRACE133_tree=null;
        CommonTree RBRACE135_tree=null;
        RewriteRuleTokenStream stream_GROUP=new RewriteRuleTokenStream(adaptor,"token GROUP");
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_groupBody=new RewriteRuleSubtreeStream(adaptor,"rule groupBody");
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:342:2: ( GROUP STRING LBRACE ( groupBody )* RBRACE -> ^( GROUP_DECL STRING ( groupBody )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:342:5: GROUP STRING LBRACE ( groupBody )* RBRACE
            {
            GROUP131=(Token)match(input,GROUP,FOLLOW_GROUP_in_groupDecl1311); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_GROUP.add(GROUP131);

            STRING132=(Token)match(input,STRING,FOLLOW_STRING_in_groupDecl1313); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(STRING132);

            LBRACE133=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_groupDecl1315); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE133);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:342:25: ( groupBody )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==INST||LA30_0==NET||(LA30_0>=INFO && LA30_0<=PORT)||LA30_0==IDENT) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:0:0: groupBody
            	    {
            	    pushFollow(FOLLOW_groupBody_in_groupDecl1317);
            	    groupBody134=groupBody();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_groupBody.add(groupBody134.getTree());

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            RBRACE135=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_groupDecl1320); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE135);



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
            // 342:43: -> ^( GROUP_DECL STRING ( groupBody )* )
            {
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:342:46: ^( GROUP_DECL STRING ( groupBody )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(GROUP_DECL, "GROUP_DECL"), root_1);

                adaptor.addChild(root_1, stream_STRING.nextNode());
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:342:66: ( groupBody )*
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:345:1: groupBody : ( infoDecl | netDecl | instDecl | netAssign | portDecl );
    public final PhdlParser.groupBody_return groupBody() throws RecognitionException {
        PhdlParser.groupBody_return retval = new PhdlParser.groupBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        PhdlParser.infoDecl_return infoDecl136 = null;

        PhdlParser.netDecl_return netDecl137 = null;

        PhdlParser.instDecl_return instDecl138 = null;

        PhdlParser.netAssign_return netAssign139 = null;

        PhdlParser.portDecl_return portDecl140 = null;



        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:346:2: ( infoDecl | netDecl | instDecl | netAssign | portDecl )
            int alt31=5;
            switch ( input.LA(1) ) {
            case INFO:
                {
                alt31=1;
                }
                break;
            case NET:
                {
                alt31=2;
                }
                break;
            case INST:
                {
                alt31=3;
                }
                break;
            case IDENT:
                {
                alt31=4;
                }
                break;
            case PORT:
                {
                alt31=5;
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:346:4: infoDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_infoDecl_in_groupBody1343);
                    infoDecl136=infoDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, infoDecl136.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:347:4: netDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_netDecl_in_groupBody1348);
                    netDecl137=netDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, netDecl137.getTree());

                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:348:4: instDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_instDecl_in_groupBody1353);
                    instDecl138=instDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, instDecl138.getTree());

                    }
                    break;
                case 4 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:349:4: netAssign
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_netAssign_in_groupBody1358);
                    netAssign139=netAssign();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, netAssign139.getTree());

                    }
                    break;
                case 5 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:350:4: portDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_portDecl_in_groupBody1363);
                    portDecl140=portDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, portDecl140.getTree());

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

    public static class qualifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "qualifier"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:353:1: qualifier : THIS indices PERIOD ;
    public final PhdlParser.qualifier_return qualifier() throws RecognitionException {
        PhdlParser.qualifier_return retval = new PhdlParser.qualifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token THIS141=null;
        Token PERIOD143=null;
        PhdlParser.indices_return indices142 = null;


        CommonTree THIS141_tree=null;
        CommonTree PERIOD143_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:354:2: ( THIS indices PERIOD )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:354:4: THIS indices PERIOD
            {
            root_0 = (CommonTree)adaptor.nil();

            THIS141=(Token)match(input,THIS,FOLLOW_THIS_in_qualifier1375); if (state.failed) return retval;
            pushFollow(FOLLOW_indices_in_qualifier1378);
            indices142=indices();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, indices142.getTree());
            PERIOD143=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_qualifier1380); if (state.failed) return retval;

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

    public static class indices_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "indices"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:357:1: indices : LPAREN indexDecl RPAREN ;
    public final PhdlParser.indices_return indices() throws RecognitionException {
        PhdlParser.indices_return retval = new PhdlParser.indices_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LPAREN144=null;
        Token RPAREN146=null;
        PhdlParser.indexDecl_return indexDecl145 = null;


        CommonTree LPAREN144_tree=null;
        CommonTree RPAREN146_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:358:2: ( LPAREN indexDecl RPAREN )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:358:5: LPAREN indexDecl RPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            LPAREN144=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_indices1394); if (state.failed) return retval;
            pushFollow(FOLLOW_indexDecl_in_indices1397);
            indexDecl145=indexDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, indexDecl145.getTree());
            RPAREN146=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_indices1399); if (state.failed) return retval;

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
    // $ANTLR end "indices"

    public static class slices_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "slices"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:361:1: slices : LBRACKET indexDecl RBRACKET ;
    public final PhdlParser.slices_return slices() throws RecognitionException {
        PhdlParser.slices_return retval = new PhdlParser.slices_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACKET147=null;
        Token RBRACKET149=null;
        PhdlParser.indexDecl_return indexDecl148 = null;


        CommonTree LBRACKET147_tree=null;
        CommonTree RBRACKET149_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:362:2: ( LBRACKET indexDecl RBRACKET )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:362:4: LBRACKET indexDecl RBRACKET
            {
            root_0 = (CommonTree)adaptor.nil();

            LBRACKET147=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_slices1412); if (state.failed) return retval;
            pushFollow(FOLLOW_indexDecl_in_slices1415);
            indexDecl148=indexDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, indexDecl148.getTree());
            RBRACKET149=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_slices1417); if (state.failed) return retval;

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
    // $ANTLR end "slices"

    public static class indexDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "indexDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:365:1: indexDecl : ( INT COLON INT -> ^( BOUNDS INT INT ) | INT ( COMMA INT ( COMMA INT )* )? -> ^( INDICES ( INT )+ ) );
    public final PhdlParser.indexDecl_return indexDecl() throws RecognitionException {
        PhdlParser.indexDecl_return retval = new PhdlParser.indexDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INT150=null;
        Token COLON151=null;
        Token INT152=null;
        Token INT153=null;
        Token COMMA154=null;
        Token INT155=null;
        Token COMMA156=null;
        Token INT157=null;

        CommonTree INT150_tree=null;
        CommonTree COLON151_tree=null;
        CommonTree INT152_tree=null;
        CommonTree INT153_tree=null;
        CommonTree COMMA154_tree=null;
        CommonTree INT155_tree=null;
        CommonTree COMMA156_tree=null;
        CommonTree INT157_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:366:2: ( INT COLON INT -> ^( BOUNDS INT INT ) | INT ( COMMA INT ( COMMA INT )* )? -> ^( INDICES ( INT )+ ) )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==INT) ) {
                int LA34_1 = input.LA(2);

                if ( (LA34_1==COLON) ) {
                    alt34=1;
                }
                else if ( (LA34_1==COMMA||LA34_1==RPAREN||LA34_1==RBRACKET) ) {
                    alt34=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 34, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:366:4: INT COLON INT
                    {
                    INT150=(Token)match(input,INT,FOLLOW_INT_in_indexDecl1430); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT150);

                    COLON151=(Token)match(input,COLON,FOLLOW_COLON_in_indexDecl1432); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON151);

                    INT152=(Token)match(input,INT,FOLLOW_INT_in_indexDecl1434); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT152);



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
                    // 366:22: -> ^( BOUNDS INT INT )
                    {
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:366:25: ^( BOUNDS INT INT )
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:367:5: INT ( COMMA INT ( COMMA INT )* )?
                    {
                    INT153=(Token)match(input,INT,FOLLOW_INT_in_indexDecl1454); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT153);

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:367:9: ( COMMA INT ( COMMA INT )* )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==COMMA) ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:367:10: COMMA INT ( COMMA INT )*
                            {
                            COMMA154=(Token)match(input,COMMA,FOLLOW_COMMA_in_indexDecl1457); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_COMMA.add(COMMA154);

                            INT155=(Token)match(input,INT,FOLLOW_INT_in_indexDecl1459); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_INT.add(INT155);

                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:367:20: ( COMMA INT )*
                            loop32:
                            do {
                                int alt32=2;
                                int LA32_0 = input.LA(1);

                                if ( (LA32_0==COMMA) ) {
                                    alt32=1;
                                }


                                switch (alt32) {
                            	case 1 :
                            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:367:21: COMMA INT
                            	    {
                            	    COMMA156=(Token)match(input,COMMA,FOLLOW_COMMA_in_indexDecl1462); if (state.failed) return retval; 
                            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA156);

                            	    INT157=(Token)match(input,INT,FOLLOW_INT_in_indexDecl1464); if (state.failed) return retval; 
                            	    if ( state.backtracking==0 ) stream_INT.add(INT157);


                            	    }
                            	    break;

                            	default :
                            	    break loop32;
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
                    // 367:35: -> ^( INDICES ( INT )+ )
                    {
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:367:38: ^( INDICES ( INT )+ )
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
    // $ANTLR end "indexDecl"

    public static class concatenation_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "concatenation"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:370:1: concatenation : ( ( operand ( AMPERSAND operand )* ) -> ^( CONCAT_LIST ( operand )+ ) | ( LANGLE operand RANGLE ) -> ^( CONCAT_REPL operand ) | OPEN );
    public final PhdlParser.concatenation_return concatenation() throws RecognitionException {
        PhdlParser.concatenation_return retval = new PhdlParser.concatenation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AMPERSAND159=null;
        Token LANGLE161=null;
        Token RANGLE163=null;
        Token OPEN164=null;
        PhdlParser.operand_return operand158 = null;

        PhdlParser.operand_return operand160 = null;

        PhdlParser.operand_return operand162 = null;


        CommonTree AMPERSAND159_tree=null;
        CommonTree LANGLE161_tree=null;
        CommonTree RANGLE163_tree=null;
        CommonTree OPEN164_tree=null;
        RewriteRuleTokenStream stream_AMPERSAND=new RewriteRuleTokenStream(adaptor,"token AMPERSAND");
        RewriteRuleTokenStream stream_RANGLE=new RewriteRuleTokenStream(adaptor,"token RANGLE");
        RewriteRuleTokenStream stream_LANGLE=new RewriteRuleTokenStream(adaptor,"token LANGLE");
        RewriteRuleSubtreeStream stream_operand=new RewriteRuleSubtreeStream(adaptor,"rule operand");
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:371:2: ( ( operand ( AMPERSAND operand )* ) -> ^( CONCAT_LIST ( operand )+ ) | ( LANGLE operand RANGLE ) -> ^( CONCAT_REPL operand ) | OPEN )
            int alt36=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt36=1;
                }
                break;
            case LANGLE:
                {
                alt36=2;
                }
                break;
            case OPEN:
                {
                alt36=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:371:4: ( operand ( AMPERSAND operand )* )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:371:4: ( operand ( AMPERSAND operand )* )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:371:5: operand ( AMPERSAND operand )*
                    {
                    pushFollow(FOLLOW_operand_in_concatenation1490);
                    operand158=operand();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_operand.add(operand158.getTree());
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:371:13: ( AMPERSAND operand )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==AMPERSAND) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:371:14: AMPERSAND operand
                    	    {
                    	    AMPERSAND159=(Token)match(input,AMPERSAND,FOLLOW_AMPERSAND_in_concatenation1493); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_AMPERSAND.add(AMPERSAND159);

                    	    pushFollow(FOLLOW_operand_in_concatenation1495);
                    	    operand160=operand();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_operand.add(operand160.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop35;
                        }
                    } while (true);


                    }



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
                    // 371:36: -> ^( CONCAT_LIST ( operand )+ )
                    {
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:371:39: ^( CONCAT_LIST ( operand )+ )
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:372:4: ( LANGLE operand RANGLE )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:372:4: ( LANGLE operand RANGLE )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:372:5: LANGLE operand RANGLE
                    {
                    LANGLE161=(Token)match(input,LANGLE,FOLLOW_LANGLE_in_concatenation1515); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LANGLE.add(LANGLE161);

                    pushFollow(FOLLOW_operand_in_concatenation1517);
                    operand162=operand();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_operand.add(operand162.getTree());
                    RANGLE163=(Token)match(input,RANGLE,FOLLOW_RANGLE_in_concatenation1519); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RANGLE.add(RANGLE163);


                    }



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
                    // 372:30: -> ^( CONCAT_REPL operand )
                    {
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:372:33: ^( CONCAT_REPL operand )
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:373:5: OPEN
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    OPEN164=(Token)match(input,OPEN,FOLLOW_OPEN_in_concatenation1536); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OPEN164_tree = (CommonTree)adaptor.create(OPEN164);
                    adaptor.addChild(root_0, OPEN164_tree);
                    }

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:376:1: operand : IDENT ( slices )? -> ^( OPERAND IDENT ( slices )? ) ;
    public final PhdlParser.operand_return operand() throws RecognitionException {
        PhdlParser.operand_return retval = new PhdlParser.operand_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT165=null;
        PhdlParser.slices_return slices166 = null;


        CommonTree IDENT165_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleSubtreeStream stream_slices=new RewriteRuleSubtreeStream(adaptor,"rule slices");
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:377:2: ( IDENT ( slices )? -> ^( OPERAND IDENT ( slices )? ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:377:4: IDENT ( slices )?
            {
            IDENT165=(Token)match(input,IDENT,FOLLOW_IDENT_in_operand1548); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT165);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:377:10: ( slices )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==LBRACKET) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:0:0: slices
                    {
                    pushFollow(FOLLOW_slices_in_operand1550);
                    slices166=slices();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_slices.add(slices166.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: IDENT, slices
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 377:18: -> ^( OPERAND IDENT ( slices )? )
            {
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:377:21: ^( OPERAND IDENT ( slices )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPERAND, "OPERAND"), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:377:37: ( slices )?
                if ( stream_slices.hasNext() ) {
                    adaptor.addChild(root_1, stream_slices.nextTree());

                }
                stream_slices.reset();

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:380:1: name : IDENT ( indices )? -> ^( NAME IDENT ( indices )? ) ;
    public final PhdlParser.name_return name() throws RecognitionException {
        PhdlParser.name_return retval = new PhdlParser.name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT167=null;
        PhdlParser.indices_return indices168 = null;


        CommonTree IDENT167_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleSubtreeStream stream_indices=new RewriteRuleSubtreeStream(adaptor,"rule indices");
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:381:2: ( IDENT ( indices )? -> ^( NAME IDENT ( indices )? ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:381:4: IDENT ( indices )?
            {
            IDENT167=(Token)match(input,IDENT,FOLLOW_IDENT_in_name1574); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT167);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:381:10: ( indices )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==LPAREN) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:0:0: indices
                    {
                    pushFollow(FOLLOW_indices_in_name1576);
                    indices168=indices();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_indices.add(indices168.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: IDENT, indices
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 381:19: -> ^( NAME IDENT ( indices )? )
            {
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:381:22: ^( NAME IDENT ( indices )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAME, "NAME"), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:381:35: ( indices )?
                if ( stream_indices.hasNext() ) {
                    adaptor.addChild(root_1, stream_indices.nextTree());

                }
                stream_indices.reset();

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


    protected DFA14 dfa14 = new DFA14(this);
    protected DFA21 dfa21 = new DFA21(this);
    static final String DFA14_eotS =
        "\22\uffff";
    static final String DFA14_eofS =
        "\22\uffff";
    static final String DFA14_minS =
        "\1\16\3\uffff\1\11\1\10\1\uffff\1\107\1\17\1\5\2\107\1\7\1\12\1"+
        "\6\1\105\1\107\1\6";
    static final String DFA14_maxS =
        "\1\105\3\uffff\1\11\1\13\1\uffff\1\107\1\106\1\12\2\107\1\7\2\12"+
        "\1\105\1\107\1\12";
    static final String DFA14_acceptS =
        "\1\uffff\1\4\1\1\1\2\2\uffff\1\3\13\uffff";
    static final String DFA14_specialS =
        "\22\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\1\12\uffff\1\4\3\uffff\1\3\2\uffff\1\6\1\uffff\1\2\42\uffff"+
            "\1\5",
            "",
            "",
            "",
            "\1\7",
            "\1\10\2\uffff\1\6",
            "",
            "\1\11",
            "\1\6\64\uffff\2\6\1\3",
            "\1\12\1\13\3\uffff\1\14",
            "\1\15",
            "\1\16",
            "\1\17",
            "\1\14",
            "\1\20\3\uffff\1\14",
            "\1\5",
            "\1\21",
            "\1\20\3\uffff\1\14"
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "()* loopback of 304:58: ( infoDecl | attrAssign | pinAssign )*";
        }
    }
    static final String DFA21_eotS =
        "\22\uffff";
    static final String DFA21_eofS =
        "\22\uffff";
    static final String DFA21_minS =
        "\1\16\3\uffff\1\11\1\7\1\uffff\1\107\1\17\1\5\2\107\1\7\1\12\1"+
        "\6\1\105\1\107\1\6";
    static final String DFA21_maxS =
        "\1\105\3\uffff\1\11\1\13\1\uffff\1\107\1\106\1\12\2\107\1\7\2\12"+
        "\1\105\1\107\1\12";
    static final String DFA21_acceptS =
        "\1\uffff\1\4\1\1\1\2\2\uffff\1\3\13\uffff";
    static final String DFA21_specialS =
        "\22\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\1\12\uffff\1\4\3\uffff\1\3\2\uffff\1\6\1\uffff\1\2\42\uffff"+
            "\1\5",
            "",
            "",
            "",
            "\1\7",
            "\1\3\1\10\1\3\1\uffff\1\6",
            "",
            "\1\11",
            "\1\6\64\uffff\2\6\1\3",
            "\1\12\1\13\3\uffff\1\14",
            "\1\15",
            "\1\16",
            "\1\17",
            "\1\14",
            "\1\20\3\uffff\1\14",
            "\1\5",
            "\1\21",
            "\1\20\3\uffff\1\14"
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "()* loopback of 323:41: ( infoDecl | subAttrAssign | portAssign )*";
        }
    }
 

    public static final BitSet FOLLOW_deviceDecl_in_sourceText437 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_designDecl_in_sourceText441 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_DEVICE_in_deviceDecl454 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl456 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACE_in_deviceDecl458 = new BitSet(new long[]{0x000003F410004000L});
    public static final BitSet FOLLOW_infoDecl_in_deviceDecl461 = new BitSet(new long[]{0x000003F410004000L});
    public static final BitSet FOLLOW_attrDecl_in_deviceDecl465 = new BitSet(new long[]{0x000003F410004000L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl469 = new BitSet(new long[]{0x000003F410004000L});
    public static final BitSet FOLLOW_RBRACE_in_deviceDecl473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ATTR_in_attrDecl505 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_attrDecl507 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_attrDecl509 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_STRING_in_attrDecl511 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SEMICOLON_in_attrDecl513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pinType_in_pinDecl534 = new BitSet(new long[]{0x0000000000000800L,0x0000000000000020L});
    public static final BitSet FOLLOW_LBRACKET_in_pinDecl537 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_widthDecl_in_pinDecl539 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RBRACKET_in_pinDecl541 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl545 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_pinDecl547 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_pinList_in_pinDecl549 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinDecl551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PIN_in_pinType581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INPIN_in_pinType594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPIN_in_pinType607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IOPIN_in_pinType620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PWRPIN_in_pinType633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUPPIN_in_pinType646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_widthDecl666 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_COLON_in_widthDecl668 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_INT_in_widthDecl670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_pinList692 = new BitSet(new long[]{0x0000000000000000L,0x00000000000001A0L});
    public static final BitSet FOLLOW_pinNumber_in_pinList694 = new BitSet(new long[]{0x0000000000004040L});
    public static final BitSet FOLLOW_COMMA_in_pinList697 = new BitSet(new long[]{0x0000000000000000L,0x00000000000001A0L});
    public static final BitSet FOLLOW_pinNumber_in_pinList699 = new BitSet(new long[]{0x0000000000004040L});
    public static final BitSet FOLLOW_RBRACE_in_pinList703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_pinNumber0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESIGN_in_designDecl744 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_designDecl746 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACE_in_designDecl748 = new BitSet(new long[]{0x0000000C09404000L,0x0000000000000220L});
    public static final BitSet FOLLOW_designBody_in_designDecl750 = new BitSet(new long[]{0x0000000C09404000L,0x0000000000000220L});
    public static final BitSet FOLLOW_RBRACE_in_designDecl753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_infoDecl_in_designBody776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_netDecl_in_designBody781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instDecl_in_designBody786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_netAssign_in_designBody791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_portDecl_in_designBody796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subInstDecl_in_designBody801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_groupDecl_in_designBody806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INFO_in_infoDecl818 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACE_in_infoDecl820 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_STRING_in_infoDecl822 = new BitSet(new long[]{0x0000000000004000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RBRACE_in_infoDecl825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NET_in_netDecl846 = new BitSet(new long[]{0x0000000000000800L,0x0000000000000020L});
    public static final BitSet FOLLOW_LBRACKET_in_netDecl849 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_widthDecl_in_netDecl851 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RBRACKET_in_netDecl853 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_netDecl857 = new BitSet(new long[]{0x0000000000002050L});
    public static final BitSet FOLLOW_COMMA_in_netDecl860 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_netDecl862 = new BitSet(new long[]{0x0000000000002050L});
    public static final BitSet FOLLOW_LBRACE_in_netDecl868 = new BitSet(new long[]{0x0000000010004000L});
    public static final BitSet FOLLOW_attrDecl_in_netDecl870 = new BitSet(new long[]{0x0000000010004000L});
    public static final BitSet FOLLOW_RBRACE_in_netDecl873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_netDecl878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INST_in_instDecl909 = new BitSet(new long[]{0x0000000000000200L,0x0000000000000020L});
    public static final BitSet FOLLOW_LPAREN_in_instDecl912 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_widthDecl_in_instDecl914 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_instDecl916 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_instDecl920 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_OF_in_instDecl922 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_instDecl924 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACE_in_instDecl926 = new BitSet(new long[]{0x0000000522004000L,0x0000000000000020L});
    public static final BitSet FOLLOW_infoDecl_in_instDecl929 = new BitSet(new long[]{0x0000000522004000L,0x0000000000000020L});
    public static final BitSet FOLLOW_attrAssign_in_instDecl933 = new BitSet(new long[]{0x0000000522004000L,0x0000000000000020L});
    public static final BitSet FOLLOW_pinAssign_in_instDecl937 = new BitSet(new long[]{0x0000000522004000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RBRACE_in_instDecl941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWATTR_in_attrAssign977 = new BitSet(new long[]{0x0000000002000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_qualifier_in_attrAssign980 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_attrAssign983 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_attrAssign985 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_STRING_in_attrAssign987 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SEMICOLON_in_attrAssign989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMBINE_in_pinAssign1022 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_pinAssign1024 = new BitSet(new long[]{0x0000000002000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_qualifier_in_pinAssign1026 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_operand_in_pinAssign1029 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_pinAssign1031 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_qualifier_in_pinAssign1036 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_operand_in_pinAssign1039 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssign1042 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000030L});
    public static final BitSet FOLLOW_concatenation_in_pinAssign1044 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinAssign1046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operand_in_netAssign1077 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_netAssign1079 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000030L});
    public static final BitSet FOLLOW_concatenation_in_netAssign1081 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SEMICOLON_in_netAssign1083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUB_in_subInstDecl1105 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000A0L});
    public static final BitSet FOLLOW_widthDecl_in_subInstDecl1107 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_subInstDecl1110 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_OF_in_subInstDecl1112 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_subInstDecl1114 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACE_in_subInstDecl1116 = new BitSet(new long[]{0x0000000522004000L,0x0000000000000020L});
    public static final BitSet FOLLOW_infoDecl_in_subInstDecl1119 = new BitSet(new long[]{0x0000000522004000L,0x0000000000000020L});
    public static final BitSet FOLLOW_subAttrAssign_in_subInstDecl1123 = new BitSet(new long[]{0x0000000522004000L,0x0000000000000020L});
    public static final BitSet FOLLOW_portAssign_in_subInstDecl1127 = new BitSet(new long[]{0x0000000522004000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RBRACE_in_subInstDecl1131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWATTR_in_subAttrAssign1166 = new BitSet(new long[]{0x0000000022000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_qualifier_in_subAttrAssign1169 = new BitSet(new long[]{0x0000000022000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_name_in_subAttrAssign1172 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_PERIOD_in_subAttrAssign1175 = new BitSet(new long[]{0x0000000022000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_name_in_subAttrAssign1177 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_EQUALS_in_subAttrAssign1181 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_STRING_in_subAttrAssign1183 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SEMICOLON_in_subAttrAssign1185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PORT_in_portDecl1216 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000A0L});
    public static final BitSet FOLLOW_widthDecl_in_portDecl1218 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_portDecl1221 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_COMMA_in_portDecl1224 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_portDecl1226 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_SEMICOLON_in_portDecl1230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMBINE_in_portAssign1256 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_portAssign1258 = new BitSet(new long[]{0x0000000002000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_qualifier_in_portAssign1260 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_operand_in_portAssign1263 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_portAssign1265 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_qualifier_in_portAssign1270 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_operand_in_portAssign1273 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_portAssign1276 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000030L});
    public static final BitSet FOLLOW_concatenation_in_portAssign1278 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SEMICOLON_in_portAssign1280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_groupDecl1311 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_STRING_in_groupDecl1313 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACE_in_groupDecl1315 = new BitSet(new long[]{0x0000000C08404000L,0x0000000000000020L});
    public static final BitSet FOLLOW_groupBody_in_groupDecl1317 = new BitSet(new long[]{0x0000000C08404000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RBRACE_in_groupDecl1320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_infoDecl_in_groupBody1343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_netDecl_in_groupBody1348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instDecl_in_groupBody1353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_netAssign_in_groupBody1358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_portDecl_in_groupBody1363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THIS_in_qualifier1375 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_indices_in_qualifier1378 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PERIOD_in_qualifier1380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_indices1394 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_indexDecl_in_indices1397 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_indices1399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_slices1412 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_indexDecl_in_slices1415 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RBRACKET_in_slices1417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_indexDecl1430 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_COLON_in_indexDecl1432 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_INT_in_indexDecl1434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_indexDecl1454 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_COMMA_in_indexDecl1457 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_INT_in_indexDecl1459 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_COMMA_in_indexDecl1462 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_INT_in_indexDecl1464 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_operand_in_concatenation1490 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_AMPERSAND_in_concatenation1493 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_operand_in_concatenation1495 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_LANGLE_in_concatenation1515 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_operand_in_concatenation1517 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RANGLE_in_concatenation1519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_in_concatenation1536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_operand1548 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_slices_in_operand1550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_name1574 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_indices_in_name1576 = new BitSet(new long[]{0x0000000000000002L});

}