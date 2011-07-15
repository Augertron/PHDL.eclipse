// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g 2011-07-15 14:42:22

/*
    Copyright (C) 2011  BYU Configurable Computing Lab

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


	package phdl.grammar;
	import java.util.TreeSet;
	import java.util.Set;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

/**
 * A grammar to lex and parse a PHDL source file.
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 */
public class PhdlParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "SEMICOLON", "EQUALS", "STRING", "PERIOD", "AMPERSAND", "LEFTANGLE", "RIGHTANGLE", "LEFTBRACE", "INTEGER", "COMMA", "RIGHTBRACE", "LEFTBRACKET", "COLON", "RIGHTBRACKET", "LEFTPAREN", "RIGHTPAREN", "CHAR", "DIGIT", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "INCLUDE", "'design'", "'is'", "'begin'", "'end'", "'device'", "'attr'", "'pin'", "'net'", "'inst'", "'of'", "'newattr'", "'this'", "'open'"
    };
    public static final int EOF=-1;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int IDENT=4;
    public static final int SEMICOLON=5;
    public static final int EQUALS=6;
    public static final int STRING=7;
    public static final int PERIOD=8;
    public static final int AMPERSAND=9;
    public static final int LEFTANGLE=10;
    public static final int RIGHTANGLE=11;
    public static final int LEFTBRACE=12;
    public static final int INTEGER=13;
    public static final int COMMA=14;
    public static final int RIGHTBRACE=15;
    public static final int LEFTBRACKET=16;
    public static final int COLON=17;
    public static final int RIGHTBRACKET=18;
    public static final int LEFTPAREN=19;
    public static final int RIGHTPAREN=20;
    public static final int CHAR=21;
    public static final int DIGIT=22;
    public static final int WHITESPACE=23;
    public static final int LINE_COMMENT=24;
    public static final int MULTILINE_COMMENT=25;
    public static final int INCLUDE=26;

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



    	private List<String> errors = new ArrayList<String>();

    	@Override
    	public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
    		String hdr = getErrorHeader(e);
    		String msg = getErrorMessage(e, tokenNames);
    		errors.add(hdr + " unexpected token: " + e.token.getText());
    	}

    	public List<String> getErrors() {
    		return errors;
    	}


    public static class sourceText_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sourceText"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:142:1: sourceText : ( designDecl )+ EOF ;
    public final PhdlParser.sourceText_return sourceText() throws RecognitionException {
        PhdlParser.sourceText_return retval = new PhdlParser.sourceText_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF2=null;
        PhdlParser.designDecl_return designDecl1 = null;


        CommonTree EOF2_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:146:2: ( ( designDecl )+ EOF )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:146:4: ( designDecl )+ EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:146:4: ( designDecl )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==27) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:146:4: designDecl
            	    {
            	    pushFollow(FOLLOW_designDecl_in_sourceText91);
            	    designDecl1=designDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, designDecl1.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_sourceText94); 
            EOF2_tree = (CommonTree)adaptor.create(EOF2);
            adaptor.addChild(root_0, EOF2_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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

    public static class designDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "designDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:160:1: designDecl : 'design' IDENT 'is' ( deviceDecl | netDecl )* 'begin' ( instanceDecl | netAssignment )* 'end' ( 'design' )? ( IDENT )? SEMICOLON ;
    public final PhdlParser.designDecl_return designDecl() throws RecognitionException {
        PhdlParser.designDecl_return retval = new PhdlParser.designDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal3=null;
        Token IDENT4=null;
        Token string_literal5=null;
        Token string_literal8=null;
        Token string_literal11=null;
        Token string_literal12=null;
        Token IDENT13=null;
        Token SEMICOLON14=null;
        PhdlParser.deviceDecl_return deviceDecl6 = null;

        PhdlParser.netDecl_return netDecl7 = null;

        PhdlParser.instanceDecl_return instanceDecl9 = null;

        PhdlParser.netAssignment_return netAssignment10 = null;


        CommonTree string_literal3_tree=null;
        CommonTree IDENT4_tree=null;
        CommonTree string_literal5_tree=null;
        CommonTree string_literal8_tree=null;
        CommonTree string_literal11_tree=null;
        CommonTree string_literal12_tree=null;
        CommonTree IDENT13_tree=null;
        CommonTree SEMICOLON14_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:167:2: ( 'design' IDENT 'is' ( deviceDecl | netDecl )* 'begin' ( instanceDecl | netAssignment )* 'end' ( 'design' )? ( IDENT )? SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:167:4: 'design' IDENT 'is' ( deviceDecl | netDecl )* 'begin' ( instanceDecl | netAssignment )* 'end' ( 'design' )? ( IDENT )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal3=(Token)match(input,27,FOLLOW_27_in_designDecl113); 
            string_literal3_tree = (CommonTree)adaptor.create(string_literal3);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal3_tree, root_0);

            IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_designDecl116); 
            IDENT4_tree = (CommonTree)adaptor.create(IDENT4);
            adaptor.addChild(root_0, IDENT4_tree);

            string_literal5=(Token)match(input,28,FOLLOW_28_in_designDecl118); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:168:3: ( deviceDecl | netDecl )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==31) ) {
                    alt2=1;
                }
                else if ( (LA2_0==34) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:168:4: deviceDecl
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_designDecl125);
            	    deviceDecl6=deviceDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, deviceDecl6.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:168:17: netDecl
            	    {
            	    pushFollow(FOLLOW_netDecl_in_designDecl129);
            	    netDecl7=netDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netDecl7.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            string_literal8=(Token)match(input,29,FOLLOW_29_in_designDecl135); 
            string_literal8_tree = (CommonTree)adaptor.create(string_literal8);
            adaptor.addChild(root_0, string_literal8_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:170:3: ( instanceDecl | netAssignment )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==35) ) {
                    alt3=1;
                }
                else if ( (LA3_0==IDENT) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:170:4: instanceDecl
            	    {
            	    pushFollow(FOLLOW_instanceDecl_in_designDecl140);
            	    instanceDecl9=instanceDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, instanceDecl9.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:170:19: netAssignment
            	    {
            	    pushFollow(FOLLOW_netAssignment_in_designDecl144);
            	    netAssignment10=netAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netAssignment10.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            string_literal11=(Token)match(input,30,FOLLOW_30_in_designDecl150); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:171:18: ( 'design' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==27) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:171:18: 'design'
                    {
                    string_literal12=(Token)match(input,27,FOLLOW_27_in_designDecl153); 

                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:171:21: ( IDENT )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==IDENT) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:171:21: IDENT
                    {
                    IDENT13=(Token)match(input,IDENT,FOLLOW_IDENT_in_designDecl157); 
                    IDENT13_tree = (CommonTree)adaptor.create(IDENT13);
                    adaptor.addChild(root_0, IDENT13_tree);


                    }
                    break;

            }

            SEMICOLON14=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_designDecl160); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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

    public static class deviceDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "deviceDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:174:1: deviceDecl : 'device' IDENT 'is' ( attributeDecl | pinDecl )* 'end' ( 'device' )? ( IDENT )? SEMICOLON ;
    public final PhdlParser.deviceDecl_return deviceDecl() throws RecognitionException {
        PhdlParser.deviceDecl_return retval = new PhdlParser.deviceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal15=null;
        Token IDENT16=null;
        Token string_literal17=null;
        Token string_literal20=null;
        Token string_literal21=null;
        Token IDENT22=null;
        Token SEMICOLON23=null;
        PhdlParser.attributeDecl_return attributeDecl18 = null;

        PhdlParser.pinDecl_return pinDecl19 = null;


        CommonTree string_literal15_tree=null;
        CommonTree IDENT16_tree=null;
        CommonTree string_literal17_tree=null;
        CommonTree string_literal20_tree=null;
        CommonTree string_literal21_tree=null;
        CommonTree IDENT22_tree=null;
        CommonTree SEMICOLON23_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:180:2: ( 'device' IDENT 'is' ( attributeDecl | pinDecl )* 'end' ( 'device' )? ( IDENT )? SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:180:4: 'device' IDENT 'is' ( attributeDecl | pinDecl )* 'end' ( 'device' )? ( IDENT )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal15=(Token)match(input,31,FOLLOW_31_in_deviceDecl175); 
            string_literal15_tree = (CommonTree)adaptor.create(string_literal15);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal15_tree, root_0);

            IDENT16=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl178); 
            IDENT16_tree = (CommonTree)adaptor.create(IDENT16);
            adaptor.addChild(root_0, IDENT16_tree);

            string_literal17=(Token)match(input,28,FOLLOW_28_in_deviceDecl180); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:181:3: ( attributeDecl | pinDecl )*
            loop6:
            do {
                int alt6=3;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==32) ) {
                    alt6=1;
                }
                else if ( (LA6_0==33) ) {
                    alt6=2;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:181:5: attributeDecl
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_deviceDecl187);
            	    attributeDecl18=attributeDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeDecl18.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:181:21: pinDecl
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl191);
            	    pinDecl19=pinDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinDecl19.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            string_literal20=(Token)match(input,30,FOLLOW_30_in_deviceDecl198); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:182:18: ( 'device' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==31) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:182:18: 'device'
                    {
                    string_literal21=(Token)match(input,31,FOLLOW_31_in_deviceDecl201); 

                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:182:21: ( IDENT )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==IDENT) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:182:21: IDENT
                    {
                    IDENT22=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl205); 
                    IDENT22_tree = (CommonTree)adaptor.create(IDENT22);
                    adaptor.addChild(root_0, IDENT22_tree);


                    }
                    break;

            }

            SEMICOLON23=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_deviceDecl208); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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

    public static class attributeDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributeDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:185:1: attributeDecl : 'attr' IDENT EQUALS STRING SEMICOLON ;
    public final PhdlParser.attributeDecl_return attributeDecl() throws RecognitionException {
        PhdlParser.attributeDecl_return retval = new PhdlParser.attributeDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal24=null;
        Token IDENT25=null;
        Token EQUALS26=null;
        Token STRING27=null;
        Token SEMICOLON28=null;

        CommonTree string_literal24_tree=null;
        CommonTree IDENT25_tree=null;
        CommonTree EQUALS26_tree=null;
        CommonTree STRING27_tree=null;
        CommonTree SEMICOLON28_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:190:2: ( 'attr' IDENT EQUALS STRING SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:190:4: 'attr' IDENT EQUALS STRING SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal24=(Token)match(input,32,FOLLOW_32_in_attributeDecl223); 
            string_literal24_tree = (CommonTree)adaptor.create(string_literal24);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal24_tree, root_0);

            IDENT25=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeDecl226); 
            IDENT25_tree = (CommonTree)adaptor.create(IDENT25);
            adaptor.addChild(root_0, IDENT25_tree);

            EQUALS26=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeDecl228); 
            STRING27=(Token)match(input,STRING,FOLLOW_STRING_in_attributeDecl231); 
            STRING27_tree = (CommonTree)adaptor.create(STRING27);
            adaptor.addChild(root_0, STRING27_tree);

            SEMICOLON28=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeDecl233); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // $ANTLR end "attributeDecl"

    public static class pinDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pinDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:193:1: pinDecl : type ( sliceDecl )? IDENT EQUALS pinList SEMICOLON ;
    public final PhdlParser.pinDecl_return pinDecl() throws RecognitionException {
        PhdlParser.pinDecl_return retval = new PhdlParser.pinDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT31=null;
        Token EQUALS32=null;
        Token SEMICOLON34=null;
        PhdlParser.type_return type29 = null;

        PhdlParser.sliceDecl_return sliceDecl30 = null;

        PhdlParser.pinList_return pinList33 = null;


        CommonTree IDENT31_tree=null;
        CommonTree EQUALS32_tree=null;
        CommonTree SEMICOLON34_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:199:2: ( type ( sliceDecl )? IDENT EQUALS pinList SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:199:4: type ( sliceDecl )? IDENT EQUALS pinList SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_type_in_pinDecl247);
            type29=type();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(type29.getTree(), root_0);
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:199:10: ( sliceDecl )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==LEFTBRACKET) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:199:10: sliceDecl
                    {
                    pushFollow(FOLLOW_sliceDecl_in_pinDecl250);
                    sliceDecl30=sliceDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceDecl30.getTree());

                    }
                    break;

            }

            IDENT31=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinDecl253); 
            IDENT31_tree = (CommonTree)adaptor.create(IDENT31);
            adaptor.addChild(root_0, IDENT31_tree);

            EQUALS32=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinDecl255); 
            pushFollow(FOLLOW_pinList_in_pinDecl258);
            pinList33=pinList();

            state._fsp--;

            adaptor.addChild(root_0, pinList33.getTree());
            SEMICOLON34=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinDecl260); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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

    public static class type_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:202:1: type : 'pin' ;
    public final PhdlParser.type_return type() throws RecognitionException {
        PhdlParser.type_return retval = new PhdlParser.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal35=null;

        CommonTree string_literal35_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:206:2: ( 'pin' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:206:4: 'pin'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal35=(Token)match(input,33,FOLLOW_33_in_type275); 
            string_literal35_tree = (CommonTree)adaptor.create(string_literal35);
            adaptor.addChild(root_0, string_literal35_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // $ANTLR end "type"

    public static class netDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "netDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:209:1: netDecl : 'net' ( sliceDecl )? IDENT ( netAttributes )? SEMICOLON ;
    public final PhdlParser.netDecl_return netDecl() throws RecognitionException {
        PhdlParser.netDecl_return retval = new PhdlParser.netDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal36=null;
        Token IDENT38=null;
        Token SEMICOLON40=null;
        PhdlParser.sliceDecl_return sliceDecl37 = null;

        PhdlParser.netAttributes_return netAttributes39 = null;


        CommonTree string_literal36_tree=null;
        CommonTree IDENT38_tree=null;
        CommonTree SEMICOLON40_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:214:2: ( 'net' ( sliceDecl )? IDENT ( netAttributes )? SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:214:4: 'net' ( sliceDecl )? IDENT ( netAttributes )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal36=(Token)match(input,34,FOLLOW_34_in_netDecl289); 
            string_literal36_tree = (CommonTree)adaptor.create(string_literal36);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal36_tree, root_0);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:214:11: ( sliceDecl )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==LEFTBRACKET) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:214:11: sliceDecl
                    {
                    pushFollow(FOLLOW_sliceDecl_in_netDecl292);
                    sliceDecl37=sliceDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceDecl37.getTree());

                    }
                    break;

            }

            IDENT38=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl295); 
            IDENT38_tree = (CommonTree)adaptor.create(IDENT38);
            adaptor.addChild(root_0, IDENT38_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:214:28: ( netAttributes )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==28) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:214:28: netAttributes
                    {
                    pushFollow(FOLLOW_netAttributes_in_netDecl297);
                    netAttributes39=netAttributes();

                    state._fsp--;

                    adaptor.addChild(root_0, netAttributes39.getTree());

                    }
                    break;

            }

            SEMICOLON40=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netDecl300); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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

    public static class netAttributes_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "netAttributes"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:217:1: netAttributes : 'is' ( attributeDecl )* 'end' ( 'net' )? ( IDENT )? ;
    public final PhdlParser.netAttributes_return netAttributes() throws RecognitionException {
        PhdlParser.netAttributes_return retval = new PhdlParser.netAttributes_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal41=null;
        Token string_literal43=null;
        Token string_literal44=null;
        Token IDENT45=null;
        PhdlParser.attributeDecl_return attributeDecl42 = null;


        CommonTree string_literal41_tree=null;
        CommonTree string_literal43_tree=null;
        CommonTree string_literal44_tree=null;
        CommonTree IDENT45_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:222:2: ( 'is' ( attributeDecl )* 'end' ( 'net' )? ( IDENT )? )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:222:4: 'is' ( attributeDecl )* 'end' ( 'net' )? ( IDENT )?
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal41=(Token)match(input,28,FOLLOW_28_in_netAttributes316); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:222:10: ( attributeDecl )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==32) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:222:10: attributeDecl
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_netAttributes319);
            	    attributeDecl42=attributeDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeDecl42.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            string_literal43=(Token)match(input,30,FOLLOW_30_in_netAttributes322); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:222:37: ( 'net' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==34) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:222:37: 'net'
                    {
                    string_literal44=(Token)match(input,34,FOLLOW_34_in_netAttributes325); 

                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:222:40: ( IDENT )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==IDENT) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:222:40: IDENT
                    {
                    IDENT45=(Token)match(input,IDENT,FOLLOW_IDENT_in_netAttributes329); 
                    IDENT45_tree = (CommonTree)adaptor.create(IDENT45);
                    adaptor.addChild(root_0, IDENT45_tree);


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // $ANTLR end "netAttributes"

    public static class instanceDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "instanceDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:225:1: instanceDecl : 'inst' ( arrayDecl )? IDENT 'of' IDENT 'is' ( attributeAssignment | pinAssignment )* 'end' ( 'inst' )? ( IDENT )? SEMICOLON ;
    public final PhdlParser.instanceDecl_return instanceDecl() throws RecognitionException {
        PhdlParser.instanceDecl_return retval = new PhdlParser.instanceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal46=null;
        Token IDENT48=null;
        Token string_literal49=null;
        Token IDENT50=null;
        Token string_literal51=null;
        Token string_literal54=null;
        Token string_literal55=null;
        Token IDENT56=null;
        Token SEMICOLON57=null;
        PhdlParser.arrayDecl_return arrayDecl47 = null;

        PhdlParser.attributeAssignment_return attributeAssignment52 = null;

        PhdlParser.pinAssignment_return pinAssignment53 = null;


        CommonTree string_literal46_tree=null;
        CommonTree IDENT48_tree=null;
        CommonTree string_literal49_tree=null;
        CommonTree IDENT50_tree=null;
        CommonTree string_literal51_tree=null;
        CommonTree string_literal54_tree=null;
        CommonTree string_literal55_tree=null;
        CommonTree IDENT56_tree=null;
        CommonTree SEMICOLON57_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:231:2: ( 'inst' ( arrayDecl )? IDENT 'of' IDENT 'is' ( attributeAssignment | pinAssignment )* 'end' ( 'inst' )? ( IDENT )? SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:231:4: 'inst' ( arrayDecl )? IDENT 'of' IDENT 'is' ( attributeAssignment | pinAssignment )* 'end' ( 'inst' )? ( IDENT )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal46=(Token)match(input,35,FOLLOW_35_in_instanceDecl343); 
            string_literal46_tree = (CommonTree)adaptor.create(string_literal46);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal46_tree, root_0);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:231:12: ( arrayDecl )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==LEFTPAREN) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:231:12: arrayDecl
                    {
                    pushFollow(FOLLOW_arrayDecl_in_instanceDecl346);
                    arrayDecl47=arrayDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayDecl47.getTree());

                    }
                    break;

            }

            IDENT48=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceDecl349); 
            IDENT48_tree = (CommonTree)adaptor.create(IDENT48);
            adaptor.addChild(root_0, IDENT48_tree);

            string_literal49=(Token)match(input,36,FOLLOW_36_in_instanceDecl351); 
            IDENT50=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceDecl354); 
            IDENT50_tree = (CommonTree)adaptor.create(IDENT50);
            adaptor.addChild(root_0, IDENT50_tree);

            string_literal51=(Token)match(input,28,FOLLOW_28_in_instanceDecl356); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:232:3: ( attributeAssignment | pinAssignment )*
            loop16:
            do {
                int alt16=3;
                alt16 = dfa16.predict(input);
                switch (alt16) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:232:4: attributeAssignment
            	    {
            	    pushFollow(FOLLOW_attributeAssignment_in_instanceDecl362);
            	    attributeAssignment52=attributeAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeAssignment52.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:232:26: pinAssignment
            	    {
            	    pushFollow(FOLLOW_pinAssignment_in_instanceDecl366);
            	    pinAssignment53=pinAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinAssignment53.getTree());

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            string_literal54=(Token)match(input,30,FOLLOW_30_in_instanceDecl372); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:233:16: ( 'inst' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==35) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:233:16: 'inst'
                    {
                    string_literal55=(Token)match(input,35,FOLLOW_35_in_instanceDecl375); 

                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:233:19: ( IDENT )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==IDENT) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:233:19: IDENT
                    {
                    IDENT56=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceDecl379); 
                    IDENT56_tree = (CommonTree)adaptor.create(IDENT56);
                    adaptor.addChild(root_0, IDENT56_tree);


                    }
                    break;

            }

            SEMICOLON57=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_instanceDecl382); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // $ANTLR end "instanceDecl"

    public static class attributeAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributeAssignment"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:236:1: attributeAssignment : ( 'newattr' )? ( instanceQualifier )? IDENT EQUALS STRING SEMICOLON ;
    public final PhdlParser.attributeAssignment_return attributeAssignment() throws RecognitionException {
        PhdlParser.attributeAssignment_return retval = new PhdlParser.attributeAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal58=null;
        Token IDENT60=null;
        Token EQUALS61=null;
        Token STRING62=null;
        Token SEMICOLON63=null;
        PhdlParser.instanceQualifier_return instanceQualifier59 = null;


        CommonTree string_literal58_tree=null;
        CommonTree IDENT60_tree=null;
        CommonTree EQUALS61_tree=null;
        CommonTree STRING62_tree=null;
        CommonTree SEMICOLON63_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:242:2: ( ( 'newattr' )? ( instanceQualifier )? IDENT EQUALS STRING SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:242:5: ( 'newattr' )? ( instanceQualifier )? IDENT EQUALS STRING SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:242:5: ( 'newattr' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==37) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:242:6: 'newattr'
                    {
                    string_literal58=(Token)match(input,37,FOLLOW_37_in_attributeAssignment398); 
                    string_literal58_tree = (CommonTree)adaptor.create(string_literal58);
                    adaptor.addChild(root_0, string_literal58_tree);


                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:242:18: ( instanceQualifier )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==IDENT) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==PERIOD||LA20_1==LEFTPAREN) ) {
                    alt20=1;
                }
            }
            else if ( (LA20_0==38) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:242:18: instanceQualifier
                    {
                    pushFollow(FOLLOW_instanceQualifier_in_attributeAssignment402);
                    instanceQualifier59=instanceQualifier();

                    state._fsp--;

                    adaptor.addChild(root_0, instanceQualifier59.getTree());

                    }
                    break;

            }

            IDENT60=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeAssignment405); 
            IDENT60_tree = (CommonTree)adaptor.create(IDENT60);
            adaptor.addChild(root_0, IDENT60_tree);

            EQUALS61=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeAssignment407); 
            EQUALS61_tree = (CommonTree)adaptor.create(EQUALS61);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS61_tree, root_0);

            STRING62=(Token)match(input,STRING,FOLLOW_STRING_in_attributeAssignment410); 
            STRING62_tree = (CommonTree)adaptor.create(STRING62);
            adaptor.addChild(root_0, STRING62_tree);

            SEMICOLON63=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeAssignment412); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // $ANTLR end "attributeAssignment"

    public static class instanceQualifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "instanceQualifier"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:245:1: instanceQualifier : ( IDENT | 'this' ) ( arrayList )? PERIOD ;
    public final PhdlParser.instanceQualifier_return instanceQualifier() throws RecognitionException {
        PhdlParser.instanceQualifier_return retval = new PhdlParser.instanceQualifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set64=null;
        Token PERIOD66=null;
        PhdlParser.arrayList_return arrayList65 = null;


        CommonTree set64_tree=null;
        CommonTree PERIOD66_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:250:2: ( ( IDENT | 'this' ) ( arrayList )? PERIOD )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:250:4: ( IDENT | 'this' ) ( arrayList )? PERIOD
            {
            root_0 = (CommonTree)adaptor.nil();

            set64=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||input.LA(1)==38 ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set64));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:250:21: ( arrayList )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==LEFTPAREN) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:250:21: arrayList
                    {
                    pushFollow(FOLLOW_arrayList_in_instanceQualifier435);
                    arrayList65=arrayList();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayList65.getTree());

                    }
                    break;

            }

            PERIOD66=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_instanceQualifier438); 
            PERIOD66_tree = (CommonTree)adaptor.create(PERIOD66);
            root_0 = (CommonTree)adaptor.becomeRoot(PERIOD66_tree, root_0);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // $ANTLR end "instanceQualifier"

    public static class pinAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pinAssignment"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:253:1: pinAssignment : ( instanceQualifier )? IDENT ( sliceList )? EQUALS concatenation SEMICOLON ;
    public final PhdlParser.pinAssignment_return pinAssignment() throws RecognitionException {
        PhdlParser.pinAssignment_return retval = new PhdlParser.pinAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT68=null;
        Token EQUALS70=null;
        Token SEMICOLON72=null;
        PhdlParser.instanceQualifier_return instanceQualifier67 = null;

        PhdlParser.sliceList_return sliceList69 = null;

        PhdlParser.concatenation_return concatenation71 = null;


        CommonTree IDENT68_tree=null;
        CommonTree EQUALS70_tree=null;
        CommonTree SEMICOLON72_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:258:2: ( ( instanceQualifier )? IDENT ( sliceList )? EQUALS concatenation SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:258:4: ( instanceQualifier )? IDENT ( sliceList )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:258:4: ( instanceQualifier )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==IDENT) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==PERIOD||LA22_1==LEFTPAREN) ) {
                    alt22=1;
                }
            }
            else if ( (LA22_0==38) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:258:4: instanceQualifier
                    {
                    pushFollow(FOLLOW_instanceQualifier_in_pinAssignment454);
                    instanceQualifier67=instanceQualifier();

                    state._fsp--;

                    adaptor.addChild(root_0, instanceQualifier67.getTree());

                    }
                    break;

            }

            IDENT68=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinAssignment457); 
            IDENT68_tree = (CommonTree)adaptor.create(IDENT68);
            adaptor.addChild(root_0, IDENT68_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:258:29: ( sliceList )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==LEFTBRACKET) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:258:29: sliceList
                    {
                    pushFollow(FOLLOW_sliceList_in_pinAssignment459);
                    sliceList69=sliceList();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceList69.getTree());

                    }
                    break;

            }

            EQUALS70=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinAssignment462); 
            EQUALS70_tree = (CommonTree)adaptor.create(EQUALS70);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS70_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_pinAssignment465);
            concatenation71=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation71.getTree());
            SEMICOLON72=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinAssignment467); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // $ANTLR end "pinAssignment"

    public static class netAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "netAssignment"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:261:1: netAssignment : IDENT ( sliceList )? EQUALS concatenation SEMICOLON ;
    public final PhdlParser.netAssignment_return netAssignment() throws RecognitionException {
        PhdlParser.netAssignment_return retval = new PhdlParser.netAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT73=null;
        Token EQUALS75=null;
        Token SEMICOLON77=null;
        PhdlParser.sliceList_return sliceList74 = null;

        PhdlParser.concatenation_return concatenation76 = null;


        CommonTree IDENT73_tree=null;
        CommonTree EQUALS75_tree=null;
        CommonTree SEMICOLON77_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:265:2: ( IDENT ( sliceList )? EQUALS concatenation SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:265:4: IDENT ( sliceList )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT73=(Token)match(input,IDENT,FOLLOW_IDENT_in_netAssignment481); 
            IDENT73_tree = (CommonTree)adaptor.create(IDENT73);
            adaptor.addChild(root_0, IDENT73_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:265:10: ( sliceList )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==LEFTBRACKET) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:265:10: sliceList
                    {
                    pushFollow(FOLLOW_sliceList_in_netAssignment483);
                    sliceList74=sliceList();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceList74.getTree());

                    }
                    break;

            }

            EQUALS75=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_netAssignment486); 
            EQUALS75_tree = (CommonTree)adaptor.create(EQUALS75);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS75_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_netAssignment489);
            concatenation76=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation76.getTree());
            SEMICOLON77=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netAssignment491); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // $ANTLR end "netAssignment"

    public static class concatenation_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "concatenation"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:268:1: concatenation : ( ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* ) | LEFTANGLE IDENT RIGHTANGLE | 'open' );
    public final PhdlParser.concatenation_return concatenation() throws RecognitionException {
        PhdlParser.concatenation_return retval = new PhdlParser.concatenation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT78=null;
        Token AMPERSAND80=null;
        Token IDENT81=null;
        Token LEFTANGLE83=null;
        Token IDENT84=null;
        Token RIGHTANGLE85=null;
        Token string_literal86=null;
        PhdlParser.sliceList_return sliceList79 = null;

        PhdlParser.sliceList_return sliceList82 = null;


        CommonTree IDENT78_tree=null;
        CommonTree AMPERSAND80_tree=null;
        CommonTree IDENT81_tree=null;
        CommonTree LEFTANGLE83_tree=null;
        CommonTree IDENT84_tree=null;
        CommonTree RIGHTANGLE85_tree=null;
        CommonTree string_literal86_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:274:2: ( ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* ) | LEFTANGLE IDENT RIGHTANGLE | 'open' )
            int alt28=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt28=1;
                }
                break;
            case LEFTANGLE:
                {
                alt28=2;
                }
                break;
            case 39:
                {
                alt28=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:274:4: ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:274:4: ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:274:5: ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )*
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:274:5: ( IDENT ( sliceList )? )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:274:6: IDENT ( sliceList )?
                    {
                    IDENT78=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation507); 
                    IDENT78_tree = (CommonTree)adaptor.create(IDENT78);
                    adaptor.addChild(root_0, IDENT78_tree);

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:274:12: ( sliceList )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==LEFTBRACKET) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:274:12: sliceList
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation509);
                            sliceList79=sliceList();

                            state._fsp--;

                            adaptor.addChild(root_0, sliceList79.getTree());

                            }
                            break;

                    }


                    }

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:274:24: ( AMPERSAND IDENT ( sliceList )? )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==AMPERSAND) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:274:25: AMPERSAND IDENT ( sliceList )?
                    	    {
                    	    AMPERSAND80=(Token)match(input,AMPERSAND,FOLLOW_AMPERSAND_in_concatenation514); 
                    	    IDENT81=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation517); 
                    	    IDENT81_tree = (CommonTree)adaptor.create(IDENT81);
                    	    adaptor.addChild(root_0, IDENT81_tree);

                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:274:42: ( sliceList )?
                    	    int alt26=2;
                    	    int LA26_0 = input.LA(1);

                    	    if ( (LA26_0==LEFTBRACKET) ) {
                    	        alt26=1;
                    	    }
                    	    switch (alt26) {
                    	        case 1 :
                    	            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:274:42: sliceList
                    	            {
                    	            pushFollow(FOLLOW_sliceList_in_concatenation519);
                    	            sliceList82=sliceList();

                    	            state._fsp--;

                    	            adaptor.addChild(root_0, sliceList82.getTree());

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:275:4: LEFTANGLE IDENT RIGHTANGLE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    LEFTANGLE83=(Token)match(input,LEFTANGLE,FOLLOW_LEFTANGLE_in_concatenation530); 
                    LEFTANGLE83_tree = (CommonTree)adaptor.create(LEFTANGLE83);
                    adaptor.addChild(root_0, LEFTANGLE83_tree);

                    IDENT84=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation532); 
                    IDENT84_tree = (CommonTree)adaptor.create(IDENT84);
                    adaptor.addChild(root_0, IDENT84_tree);

                    RIGHTANGLE85=(Token)match(input,RIGHTANGLE,FOLLOW_RIGHTANGLE_in_concatenation534); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:276:5: 'open'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal86=(Token)match(input,39,FOLLOW_39_in_concatenation541); 
                    string_literal86_tree = (CommonTree)adaptor.create(string_literal86);
                    adaptor.addChild(root_0, string_literal86_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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

    public static class pinList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pinList"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:279:1: pinList : LEFTBRACE ( IDENT | INTEGER ) ( COMMA ( IDENT | INTEGER ) )* RIGHTBRACE ;
    public final PhdlParser.pinList_return pinList() throws RecognitionException {
        PhdlParser.pinList_return retval = new PhdlParser.pinList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTBRACE87=null;
        Token set88=null;
        Token COMMA89=null;
        Token set90=null;
        Token RIGHTBRACE91=null;

        CommonTree LEFTBRACE87_tree=null;
        CommonTree set88_tree=null;
        CommonTree COMMA89_tree=null;
        CommonTree set90_tree=null;
        CommonTree RIGHTBRACE91_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:284:2: ( LEFTBRACE ( IDENT | INTEGER ) ( COMMA ( IDENT | INTEGER ) )* RIGHTBRACE )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:284:5: LEFTBRACE ( IDENT | INTEGER ) ( COMMA ( IDENT | INTEGER ) )* RIGHTBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACE87=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_pinList556); 
            set88=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||input.LA(1)==INTEGER ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set88));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:284:34: ( COMMA ( IDENT | INTEGER ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==COMMA) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:284:35: COMMA ( IDENT | INTEGER )
            	    {
            	    COMMA89=(Token)match(input,COMMA,FOLLOW_COMMA_in_pinList568); 
            	    set90=(Token)input.LT(1);
            	    if ( input.LA(1)==IDENT||input.LA(1)==INTEGER ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (CommonTree)adaptor.create(set90));
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            RIGHTBRACE91=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_pinList581); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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

    public static class sliceList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sliceList"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:287:1: sliceList : LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTBRACKET ;
    public final PhdlParser.sliceList_return sliceList() throws RecognitionException {
        PhdlParser.sliceList_return retval = new PhdlParser.sliceList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTBRACKET92=null;
        Token INTEGER93=null;
        Token COLON94=null;
        Token INTEGER95=null;
        Token COMMA96=null;
        Token INTEGER97=null;
        Token COMMA98=null;
        Token INTEGER99=null;
        Token RIGHTBRACKET100=null;

        CommonTree LEFTBRACKET92_tree=null;
        CommonTree INTEGER93_tree=null;
        CommonTree COLON94_tree=null;
        CommonTree INTEGER95_tree=null;
        CommonTree COMMA96_tree=null;
        CommonTree INTEGER97_tree=null;
        CommonTree COMMA98_tree=null;
        CommonTree INTEGER99_tree=null;
        CommonTree RIGHTBRACKET100_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:292:2: ( LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTBRACKET )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:292:5: LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTBRACKET
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACKET92=(Token)match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList597); 
            LEFTBRACKET92_tree = (CommonTree)adaptor.create(LEFTBRACKET92);
            adaptor.addChild(root_0, LEFTBRACKET92_tree);

            INTEGER93=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList599); 
            INTEGER93_tree = (CommonTree)adaptor.create(INTEGER93);
            adaptor.addChild(root_0, INTEGER93_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:292:25: ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==COLON) ) {
                alt32=1;
            }
            else if ( (LA32_0==COMMA||LA32_0==RIGHTBRACKET) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:292:26: ( COLON INTEGER )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:292:26: ( COLON INTEGER )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:292:27: COLON INTEGER
                    {
                    COLON94=(Token)match(input,COLON,FOLLOW_COLON_in_sliceList603); 
                    COLON94_tree = (CommonTree)adaptor.create(COLON94);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON94_tree, root_0);

                    INTEGER95=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList606); 
                    INTEGER95_tree = (CommonTree)adaptor.create(INTEGER95);
                    adaptor.addChild(root_0, INTEGER95_tree);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:292:45: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:292:45: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==COMMA) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:292:46: COMMA INTEGER ( COMMA INTEGER )*
                            {
                            COMMA96=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceList612); 
                            COMMA96_tree = (CommonTree)adaptor.create(COMMA96);
                            root_0 = (CommonTree)adaptor.becomeRoot(COMMA96_tree, root_0);

                            INTEGER97=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList615); 
                            INTEGER97_tree = (CommonTree)adaptor.create(INTEGER97);
                            adaptor.addChild(root_0, INTEGER97_tree);

                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:292:61: ( COMMA INTEGER )*
                            loop30:
                            do {
                                int alt30=2;
                                int LA30_0 = input.LA(1);

                                if ( (LA30_0==COMMA) ) {
                                    alt30=1;
                                }


                                switch (alt30) {
                            	case 1 :
                            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:292:62: COMMA INTEGER
                            	    {
                            	    COMMA98=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceList618); 
                            	    INTEGER99=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList621); 
                            	    INTEGER99_tree = (CommonTree)adaptor.create(INTEGER99);
                            	    adaptor.addChild(root_0, INTEGER99_tree);


                            	    }
                            	    break;

                            	default :
                            	    break loop30;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }

            RIGHTBRACKET100=(Token)match(input,RIGHTBRACKET,FOLLOW_RIGHTBRACKET_in_sliceList628); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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

    public static class sliceDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sliceDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:295:1: sliceDecl : LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RIGHTBRACKET ;
    public final PhdlParser.sliceDecl_return sliceDecl() throws RecognitionException {
        PhdlParser.sliceDecl_return retval = new PhdlParser.sliceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTBRACKET101=null;
        Token INTEGER102=null;
        Token COLON103=null;
        Token INTEGER104=null;
        Token COMMA105=null;
        Token INTEGER106=null;
        Token RIGHTBRACKET107=null;

        CommonTree LEFTBRACKET101_tree=null;
        CommonTree INTEGER102_tree=null;
        CommonTree COLON103_tree=null;
        CommonTree INTEGER104_tree=null;
        CommonTree COMMA105_tree=null;
        CommonTree INTEGER106_tree=null;
        CommonTree RIGHTBRACKET107_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:299:2: ( LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RIGHTBRACKET )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:299:4: LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RIGHTBRACKET
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACKET101=(Token)match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceDecl642); 
            LEFTBRACKET101_tree = (CommonTree)adaptor.create(LEFTBRACKET101);
            adaptor.addChild(root_0, LEFTBRACKET101_tree);

            INTEGER102=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl644); 
            INTEGER102_tree = (CommonTree)adaptor.create(INTEGER102);
            adaptor.addChild(root_0, INTEGER102_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:299:24: ( ( COLON INTEGER ) | ( COMMA INTEGER )+ )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==COLON) ) {
                alt34=1;
            }
            else if ( (LA34_0==COMMA) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:299:25: ( COLON INTEGER )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:299:25: ( COLON INTEGER )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:299:26: COLON INTEGER
                    {
                    COLON103=(Token)match(input,COLON,FOLLOW_COLON_in_sliceDecl648); 
                    COLON103_tree = (CommonTree)adaptor.create(COLON103);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON103_tree, root_0);

                    INTEGER104=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl651); 
                    INTEGER104_tree = (CommonTree)adaptor.create(INTEGER104);
                    adaptor.addChild(root_0, INTEGER104_tree);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:299:44: ( COMMA INTEGER )+
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:299:44: ( COMMA INTEGER )+
                    int cnt33=0;
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==COMMA) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:299:45: COMMA INTEGER
                    	    {
                    	    COMMA105=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceDecl657); 
                    	    COMMA105_tree = (CommonTree)adaptor.create(COMMA105);
                    	    root_0 = (CommonTree)adaptor.becomeRoot(COMMA105_tree, root_0);

                    	    INTEGER106=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl660); 
                    	    INTEGER106_tree = (CommonTree)adaptor.create(INTEGER106);
                    	    adaptor.addChild(root_0, INTEGER106_tree);


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt33 >= 1 ) break loop33;
                                EarlyExitException eee =
                                    new EarlyExitException(33, input);
                                throw eee;
                        }
                        cnt33++;
                    } while (true);


                    }
                    break;

            }

            RIGHTBRACKET107=(Token)match(input,RIGHTBRACKET,FOLLOW_RIGHTBRACKET_in_sliceDecl665); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // $ANTLR end "sliceDecl"

    public static class arrayList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arrayList"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:302:1: arrayList : LEFTPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTPAREN ;
    public final PhdlParser.arrayList_return arrayList() throws RecognitionException {
        PhdlParser.arrayList_return retval = new PhdlParser.arrayList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTPAREN108=null;
        Token INTEGER109=null;
        Token COLON110=null;
        Token INTEGER111=null;
        Token COMMA112=null;
        Token INTEGER113=null;
        Token COMMA114=null;
        Token INTEGER115=null;
        Token RIGHTPAREN116=null;

        CommonTree LEFTPAREN108_tree=null;
        CommonTree INTEGER109_tree=null;
        CommonTree COLON110_tree=null;
        CommonTree INTEGER111_tree=null;
        CommonTree COMMA112_tree=null;
        CommonTree INTEGER113_tree=null;
        CommonTree COMMA114_tree=null;
        CommonTree INTEGER115_tree=null;
        CommonTree RIGHTPAREN116_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:307:2: ( LEFTPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTPAREN )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:307:5: LEFTPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTPAREN108=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList681); 
            LEFTPAREN108_tree = (CommonTree)adaptor.create(LEFTPAREN108);
            adaptor.addChild(root_0, LEFTPAREN108_tree);

            INTEGER109=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList683); 
            INTEGER109_tree = (CommonTree)adaptor.create(INTEGER109);
            adaptor.addChild(root_0, INTEGER109_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:307:23: ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==COLON) ) {
                alt37=1;
            }
            else if ( (LA37_0==COMMA||LA37_0==RIGHTPAREN) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:307:24: ( COLON INTEGER )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:307:24: ( COLON INTEGER )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:307:25: COLON INTEGER
                    {
                    COLON110=(Token)match(input,COLON,FOLLOW_COLON_in_arrayList687); 
                    COLON110_tree = (CommonTree)adaptor.create(COLON110);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON110_tree, root_0);

                    INTEGER111=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList690); 
                    INTEGER111_tree = (CommonTree)adaptor.create(INTEGER111);
                    adaptor.addChild(root_0, INTEGER111_tree);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:307:43: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:307:43: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==COMMA) ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:307:44: COMMA INTEGER ( COMMA INTEGER )*
                            {
                            COMMA112=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayList696); 
                            COMMA112_tree = (CommonTree)adaptor.create(COMMA112);
                            root_0 = (CommonTree)adaptor.becomeRoot(COMMA112_tree, root_0);

                            INTEGER113=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList699); 
                            INTEGER113_tree = (CommonTree)adaptor.create(INTEGER113);
                            adaptor.addChild(root_0, INTEGER113_tree);

                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:307:59: ( COMMA INTEGER )*
                            loop35:
                            do {
                                int alt35=2;
                                int LA35_0 = input.LA(1);

                                if ( (LA35_0==COMMA) ) {
                                    alt35=1;
                                }


                                switch (alt35) {
                            	case 1 :
                            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:307:60: COMMA INTEGER
                            	    {
                            	    COMMA114=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayList702); 
                            	    INTEGER115=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList705); 
                            	    INTEGER115_tree = (CommonTree)adaptor.create(INTEGER115);
                            	    adaptor.addChild(root_0, INTEGER115_tree);


                            	    }
                            	    break;

                            	default :
                            	    break loop35;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }

            RIGHTPAREN116=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_arrayList712); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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

    public static class arrayDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arrayDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:310:1: arrayDecl : LEFTPAREN INTEGER COLON INTEGER RIGHTPAREN ;
    public final PhdlParser.arrayDecl_return arrayDecl() throws RecognitionException {
        PhdlParser.arrayDecl_return retval = new PhdlParser.arrayDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTPAREN117=null;
        Token INTEGER118=null;
        Token COLON119=null;
        Token INTEGER120=null;
        Token RIGHTPAREN121=null;

        CommonTree LEFTPAREN117_tree=null;
        CommonTree INTEGER118_tree=null;
        CommonTree COLON119_tree=null;
        CommonTree INTEGER120_tree=null;
        CommonTree RIGHTPAREN121_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:314:2: ( LEFTPAREN INTEGER COLON INTEGER RIGHTPAREN )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:314:4: LEFTPAREN INTEGER COLON INTEGER RIGHTPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTPAREN117=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayDecl726); 
            LEFTPAREN117_tree = (CommonTree)adaptor.create(LEFTPAREN117);
            adaptor.addChild(root_0, LEFTPAREN117_tree);

            INTEGER118=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayDecl728); 
            INTEGER118_tree = (CommonTree)adaptor.create(INTEGER118);
            adaptor.addChild(root_0, INTEGER118_tree);

            COLON119=(Token)match(input,COLON,FOLLOW_COLON_in_arrayDecl730); 
            COLON119_tree = (CommonTree)adaptor.create(COLON119);
            root_0 = (CommonTree)adaptor.becomeRoot(COLON119_tree, root_0);

            INTEGER120=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayDecl733); 
            INTEGER120_tree = (CommonTree)adaptor.create(INTEGER120);
            adaptor.addChild(root_0, INTEGER120_tree);

            RIGHTPAREN121=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_arrayDecl735); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // $ANTLR end "arrayDecl"

    // Delegated rules


    protected DFA16 dfa16 = new DFA16(this);
    static final String DFA16_eotS =
        "\22\uffff";
    static final String DFA16_eofS =
        "\22\uffff";
    static final String DFA16_minS =
        "\1\4\2\uffff\1\6\1\10\1\4\1\15\1\4\1\uffff\1\16\1\6\2\15\1\10\1"+
        "\24\1\16\1\15\1\16";
    static final String DFA16_maxS =
        "\1\46\2\uffff\2\23\1\47\1\15\1\4\1\uffff\1\24\1\20\2\15\1\10\2"+
        "\24\1\15\1\24";
    static final String DFA16_acceptS =
        "\1\uffff\1\3\1\1\5\uffff\1\2\11\uffff";
    static final String DFA16_specialS =
        "\22\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\3\31\uffff\1\1\6\uffff\1\2\1\4",
            "",
            "",
            "\1\5\1\uffff\1\7\7\uffff\1\10\2\uffff\1\6",
            "\1\7\12\uffff\1\6",
            "\1\10\2\uffff\1\2\2\uffff\1\10\34\uffff\1\10",
            "\1\11",
            "\1\12",
            "",
            "\1\14\2\uffff\1\13\2\uffff\1\15",
            "\1\5\11\uffff\1\10",
            "\1\16",
            "\1\17",
            "\1\7",
            "\1\15",
            "\1\20\5\uffff\1\15",
            "\1\21",
            "\1\20\5\uffff\1\15"
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "()* loopback of 232:3: ( attributeAssignment | pinAssignment )*";
        }
    }
 

    public static final BitSet FOLLOW_designDecl_in_sourceText91 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_EOF_in_sourceText94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_designDecl113 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_designDecl116 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_designDecl118 = new BitSet(new long[]{0x00000004A0000000L});
    public static final BitSet FOLLOW_deviceDecl_in_designDecl125 = new BitSet(new long[]{0x00000004A0000000L});
    public static final BitSet FOLLOW_netDecl_in_designDecl129 = new BitSet(new long[]{0x00000004A0000000L});
    public static final BitSet FOLLOW_29_in_designDecl135 = new BitSet(new long[]{0x0000000840000010L});
    public static final BitSet FOLLOW_instanceDecl_in_designDecl140 = new BitSet(new long[]{0x0000000840000010L});
    public static final BitSet FOLLOW_netAssignment_in_designDecl144 = new BitSet(new long[]{0x0000000840000010L});
    public static final BitSet FOLLOW_30_in_designDecl150 = new BitSet(new long[]{0x0000000008000030L});
    public static final BitSet FOLLOW_27_in_designDecl153 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_IDENT_in_designDecl157 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_designDecl160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_deviceDecl175 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl178 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_deviceDecl180 = new BitSet(new long[]{0x0000000340000000L});
    public static final BitSet FOLLOW_attributeDecl_in_deviceDecl187 = new BitSet(new long[]{0x0000000340000000L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl191 = new BitSet(new long[]{0x0000000340000000L});
    public static final BitSet FOLLOW_30_in_deviceDecl198 = new BitSet(new long[]{0x0000000080000030L});
    public static final BitSet FOLLOW_31_in_deviceDecl201 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl205 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_deviceDecl208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_attributeDecl223 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attributeDecl226 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_attributeDecl228 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_in_attributeDecl231 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeDecl233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_pinDecl247 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_sliceDecl_in_pinDecl250 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl253 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_pinDecl255 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_pinList_in_pinDecl258 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinDecl260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_type275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_netDecl289 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_sliceDecl_in_netDecl292 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl295 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_netAttributes_in_netDecl297 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_netDecl300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_netAttributes316 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_attributeDecl_in_netAttributes319 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_30_in_netAttributes322 = new BitSet(new long[]{0x0000000400000012L});
    public static final BitSet FOLLOW_34_in_netAttributes325 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_IDENT_in_netAttributes329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_instanceDecl343 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_arrayDecl_in_instanceDecl346 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instanceDecl349 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_instanceDecl351 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instanceDecl354 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_instanceDecl356 = new BitSet(new long[]{0x0000006040000010L});
    public static final BitSet FOLLOW_attributeAssignment_in_instanceDecl362 = new BitSet(new long[]{0x0000006040000010L});
    public static final BitSet FOLLOW_pinAssignment_in_instanceDecl366 = new BitSet(new long[]{0x0000006040000010L});
    public static final BitSet FOLLOW_30_in_instanceDecl372 = new BitSet(new long[]{0x0000000800000030L});
    public static final BitSet FOLLOW_35_in_instanceDecl375 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_IDENT_in_instanceDecl379 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_instanceDecl382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_attributeAssignment398 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_instanceQualifier_in_attributeAssignment402 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attributeAssignment405 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_attributeAssignment407 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_in_attributeAssignment410 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeAssignment412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_instanceQualifier427 = new BitSet(new long[]{0x0000000000080100L});
    public static final BitSet FOLLOW_arrayList_in_instanceQualifier435 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_PERIOD_in_instanceQualifier438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instanceQualifier_in_pinAssignment454 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinAssignment457 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_sliceList_in_pinAssignment459 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssignment462 = new BitSet(new long[]{0x0000008000000410L});
    public static final BitSet FOLLOW_concatenation_in_pinAssignment465 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinAssignment467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_netAssignment481 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_sliceList_in_netAssignment483 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_netAssignment486 = new BitSet(new long[]{0x0000008000000410L});
    public static final BitSet FOLLOW_concatenation_in_netAssignment489 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_netAssignment491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_concatenation507 = new BitSet(new long[]{0x0000000000010202L});
    public static final BitSet FOLLOW_sliceList_in_concatenation509 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_AMPERSAND_in_concatenation514 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation517 = new BitSet(new long[]{0x0000000000010202L});
    public static final BitSet FOLLOW_sliceList_in_concatenation519 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_LEFTANGLE_in_concatenation530 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation532 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RIGHTANGLE_in_concatenation534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_concatenation541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACE_in_pinList556 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_set_in_pinList559 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_COMMA_in_pinList568 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_set_in_pinList571 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_pinList581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList597 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList599 = new BitSet(new long[]{0x0000000000064000L});
    public static final BitSet FOLLOW_COLON_in_sliceList603 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList606 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_sliceList612 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList615 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_COMMA_in_sliceList618 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList621 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_RIGHTBRACKET_in_sliceList628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceDecl642 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl644 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_COLON_in_sliceDecl648 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl651 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_sliceDecl657 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl660 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_RIGHTBRACKET_in_sliceDecl665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList681 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList683 = new BitSet(new long[]{0x0000000000124000L});
    public static final BitSet FOLLOW_COLON_in_arrayList687 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList690 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_arrayList696 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList699 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_COMMA_in_arrayList702 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList705 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_RIGHTPAREN_in_arrayList712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayDecl726 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayDecl728 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_arrayDecl730 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayDecl733 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RIGHTPAREN_in_arrayDecl735 = new BitSet(new long[]{0x0000000000000002L});

}