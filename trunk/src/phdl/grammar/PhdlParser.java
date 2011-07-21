// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g 2011-07-21 15:53:47

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "SEMICOLON", "EQUALS", "STRING", "COMMA", "PERIOD", "AMPERSAND", "LEFTANGLE", "RIGHTANGLE", "LEFTBRACE", "INTEGER", "RIGHTBRACE", "LEFTBRACKET", "COLON", "RIGHTBRACKET", "LEFTPAREN", "RIGHTPAREN", "CHAR", "DIGIT", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "INCLUDE", "'design'", "'is'", "'begin'", "'end'", "'device'", "'attr'", "'pin'", "'net'", "'inst'", "'of'", "'newattr'", "'this'", "'open'"
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
    public static final int COMMA=8;
    public static final int PERIOD=9;
    public static final int AMPERSAND=10;
    public static final int LEFTANGLE=11;
    public static final int RIGHTANGLE=12;
    public static final int LEFTBRACE=13;
    public static final int INTEGER=14;
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:162:1: sourceText : ( designDecl )+ EOF ;
    public final PhdlParser.sourceText_return sourceText() throws RecognitionException {
        PhdlParser.sourceText_return retval = new PhdlParser.sourceText_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF2=null;
        PhdlParser.designDecl_return designDecl1 = null;


        CommonTree EOF2_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:167:2: ( ( designDecl )+ EOF )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:167:4: ( designDecl )+ EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:167:4: ( designDecl )+
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:167:4: designDecl
            	    {
            	    pushFollow(FOLLOW_designDecl_in_sourceText82);
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

            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_sourceText85); 
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:170:1: designDecl : 'design' IDENT 'is' ( deviceDecl | netDecl )* 'begin' ( instanceDecl | netAssignment )* 'end' ( 'design' )? ( IDENT )? SEMICOLON ;
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:178:2: ( 'design' IDENT 'is' ( deviceDecl | netDecl )* 'begin' ( instanceDecl | netAssignment )* 'end' ( 'design' )? ( IDENT )? SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:178:4: 'design' IDENT 'is' ( deviceDecl | netDecl )* 'begin' ( instanceDecl | netAssignment )* 'end' ( 'design' )? ( IDENT )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal3=(Token)match(input,27,FOLLOW_27_in_designDecl98); 
            string_literal3_tree = (CommonTree)adaptor.create(string_literal3);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal3_tree, root_0);

            IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_designDecl101); 
            IDENT4_tree = (CommonTree)adaptor.create(IDENT4);
            adaptor.addChild(root_0, IDENT4_tree);

            string_literal5=(Token)match(input,28,FOLLOW_28_in_designDecl103); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:179:3: ( deviceDecl | netDecl )*
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:179:4: deviceDecl
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_designDecl110);
            	    deviceDecl6=deviceDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, deviceDecl6.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:179:17: netDecl
            	    {
            	    pushFollow(FOLLOW_netDecl_in_designDecl114);
            	    netDecl7=netDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netDecl7.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            string_literal8=(Token)match(input,29,FOLLOW_29_in_designDecl120); 
            string_literal8_tree = (CommonTree)adaptor.create(string_literal8);
            adaptor.addChild(root_0, string_literal8_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:181:3: ( instanceDecl | netAssignment )*
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:181:4: instanceDecl
            	    {
            	    pushFollow(FOLLOW_instanceDecl_in_designDecl125);
            	    instanceDecl9=instanceDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, instanceDecl9.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:181:19: netAssignment
            	    {
            	    pushFollow(FOLLOW_netAssignment_in_designDecl129);
            	    netAssignment10=netAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netAssignment10.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            string_literal11=(Token)match(input,30,FOLLOW_30_in_designDecl135); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:182:18: ( 'design' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==27) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:182:18: 'design'
                    {
                    string_literal12=(Token)match(input,27,FOLLOW_27_in_designDecl138); 

                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:182:21: ( IDENT )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==IDENT) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:182:21: IDENT
                    {
                    IDENT13=(Token)match(input,IDENT,FOLLOW_IDENT_in_designDecl142); 
                    IDENT13_tree = (CommonTree)adaptor.create(IDENT13);
                    adaptor.addChild(root_0, IDENT13_tree);


                    }
                    break;

            }

            SEMICOLON14=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_designDecl145); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:185:1: deviceDecl : 'device' IDENT 'is' ( attributeDecl | pinDecl )* 'end' ( 'device' )? ( IDENT )? SEMICOLON ;
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:192:2: ( 'device' IDENT 'is' ( attributeDecl | pinDecl )* 'end' ( 'device' )? ( IDENT )? SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:192:4: 'device' IDENT 'is' ( attributeDecl | pinDecl )* 'end' ( 'device' )? ( IDENT )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal15=(Token)match(input,31,FOLLOW_31_in_deviceDecl160); 
            string_literal15_tree = (CommonTree)adaptor.create(string_literal15);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal15_tree, root_0);

            IDENT16=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl163); 
            IDENT16_tree = (CommonTree)adaptor.create(IDENT16);
            adaptor.addChild(root_0, IDENT16_tree);

            string_literal17=(Token)match(input,28,FOLLOW_28_in_deviceDecl165); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:193:3: ( attributeDecl | pinDecl )*
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:193:5: attributeDecl
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_deviceDecl172);
            	    attributeDecl18=attributeDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeDecl18.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:193:21: pinDecl
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl176);
            	    pinDecl19=pinDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinDecl19.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            string_literal20=(Token)match(input,30,FOLLOW_30_in_deviceDecl183); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:194:18: ( 'device' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==31) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:194:18: 'device'
                    {
                    string_literal21=(Token)match(input,31,FOLLOW_31_in_deviceDecl186); 

                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:194:21: ( IDENT )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==IDENT) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:194:21: IDENT
                    {
                    IDENT22=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl190); 
                    IDENT22_tree = (CommonTree)adaptor.create(IDENT22);
                    adaptor.addChild(root_0, IDENT22_tree);


                    }
                    break;

            }

            SEMICOLON23=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_deviceDecl193); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:197:1: attributeDecl : 'attr' IDENT EQUALS STRING SEMICOLON ;
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:202:2: ( 'attr' IDENT EQUALS STRING SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:202:4: 'attr' IDENT EQUALS STRING SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal24=(Token)match(input,32,FOLLOW_32_in_attributeDecl208); 
            string_literal24_tree = (CommonTree)adaptor.create(string_literal24);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal24_tree, root_0);

            IDENT25=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeDecl211); 
            IDENT25_tree = (CommonTree)adaptor.create(IDENT25);
            adaptor.addChild(root_0, IDENT25_tree);

            EQUALS26=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeDecl213); 
            STRING27=(Token)match(input,STRING,FOLLOW_STRING_in_attributeDecl216); 
            STRING27_tree = (CommonTree)adaptor.create(STRING27);
            adaptor.addChild(root_0, STRING27_tree);

            SEMICOLON28=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeDecl218); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:205:1: pinDecl : type ( sliceDecl )? IDENT EQUALS pinList SEMICOLON ;
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:210:2: ( type ( sliceDecl )? IDENT EQUALS pinList SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:210:4: type ( sliceDecl )? IDENT EQUALS pinList SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_type_in_pinDecl232);
            type29=type();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(type29.getTree(), root_0);
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:210:10: ( sliceDecl )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==LEFTBRACKET) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:210:10: sliceDecl
                    {
                    pushFollow(FOLLOW_sliceDecl_in_pinDecl235);
                    sliceDecl30=sliceDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceDecl30.getTree());

                    }
                    break;

            }

            IDENT31=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinDecl238); 
            IDENT31_tree = (CommonTree)adaptor.create(IDENT31);
            adaptor.addChild(root_0, IDENT31_tree);

            EQUALS32=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinDecl240); 
            pushFollow(FOLLOW_pinList_in_pinDecl243);
            pinList33=pinList();

            state._fsp--;

            adaptor.addChild(root_0, pinList33.getTree());
            SEMICOLON34=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinDecl245); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:213:1: type : 'pin' ;
    public final PhdlParser.type_return type() throws RecognitionException {
        PhdlParser.type_return retval = new PhdlParser.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal35=null;

        CommonTree string_literal35_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:217:2: ( 'pin' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:217:4: 'pin'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal35=(Token)match(input,33,FOLLOW_33_in_type260); 
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:220:1: netDecl : 'net' ( sliceDecl )? IDENT ( COMMA IDENT )* ( netAttributes )? SEMICOLON ;
    public final PhdlParser.netDecl_return netDecl() throws RecognitionException {
        PhdlParser.netDecl_return retval = new PhdlParser.netDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal36=null;
        Token IDENT38=null;
        Token COMMA39=null;
        Token IDENT40=null;
        Token SEMICOLON42=null;
        PhdlParser.sliceDecl_return sliceDecl37 = null;

        PhdlParser.netAttributes_return netAttributes41 = null;


        CommonTree string_literal36_tree=null;
        CommonTree IDENT38_tree=null;
        CommonTree COMMA39_tree=null;
        CommonTree IDENT40_tree=null;
        CommonTree SEMICOLON42_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:225:2: ( 'net' ( sliceDecl )? IDENT ( COMMA IDENT )* ( netAttributes )? SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:225:4: 'net' ( sliceDecl )? IDENT ( COMMA IDENT )* ( netAttributes )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal36=(Token)match(input,34,FOLLOW_34_in_netDecl273); 
            string_literal36_tree = (CommonTree)adaptor.create(string_literal36);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal36_tree, root_0);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:225:11: ( sliceDecl )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==LEFTBRACKET) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:225:11: sliceDecl
                    {
                    pushFollow(FOLLOW_sliceDecl_in_netDecl276);
                    sliceDecl37=sliceDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceDecl37.getTree());

                    }
                    break;

            }

            IDENT38=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl279); 
            IDENT38_tree = (CommonTree)adaptor.create(IDENT38);
            adaptor.addChild(root_0, IDENT38_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:225:28: ( COMMA IDENT )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==COMMA) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:225:29: COMMA IDENT
            	    {
            	    COMMA39=(Token)match(input,COMMA,FOLLOW_COMMA_in_netDecl282); 
            	    COMMA39_tree = (CommonTree)adaptor.create(COMMA39);
            	    adaptor.addChild(root_0, COMMA39_tree);

            	    IDENT40=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl284); 
            	    IDENT40_tree = (CommonTree)adaptor.create(IDENT40);
            	    adaptor.addChild(root_0, IDENT40_tree);


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:225:43: ( netAttributes )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==28) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:225:43: netAttributes
                    {
                    pushFollow(FOLLOW_netAttributes_in_netDecl288);
                    netAttributes41=netAttributes();

                    state._fsp--;

                    adaptor.addChild(root_0, netAttributes41.getTree());

                    }
                    break;

            }

            SEMICOLON42=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netDecl291); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:228:1: netAttributes : 'is' ( attributeDecl )* 'end' ;
    public final PhdlParser.netAttributes_return netAttributes() throws RecognitionException {
        PhdlParser.netAttributes_return retval = new PhdlParser.netAttributes_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal43=null;
        Token string_literal45=null;
        PhdlParser.attributeDecl_return attributeDecl44 = null;


        CommonTree string_literal43_tree=null;
        CommonTree string_literal45_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:234:2: ( 'is' ( attributeDecl )* 'end' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:234:4: 'is' ( attributeDecl )* 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal43=(Token)match(input,28,FOLLOW_28_in_netAttributes306); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:234:10: ( attributeDecl )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==32) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:234:10: attributeDecl
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_netAttributes309);
            	    attributeDecl44=attributeDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeDecl44.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            string_literal45=(Token)match(input,30,FOLLOW_30_in_netAttributes312); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:237:1: instanceDecl : 'inst' ( arrayDecl )? IDENT 'of' IDENT 'is' ( attributeAssignment | pinAssignment )* 'end' ( 'inst' )? ( IDENT )? SEMICOLON ;
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:245:2: ( 'inst' ( arrayDecl )? IDENT 'of' IDENT 'is' ( attributeAssignment | pinAssignment )* 'end' ( 'inst' )? ( IDENT )? SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:245:4: 'inst' ( arrayDecl )? IDENT 'of' IDENT 'is' ( attributeAssignment | pinAssignment )* 'end' ( 'inst' )? ( IDENT )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal46=(Token)match(input,35,FOLLOW_35_in_instanceDecl326); 
            string_literal46_tree = (CommonTree)adaptor.create(string_literal46);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal46_tree, root_0);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:245:12: ( arrayDecl )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==LEFTPAREN) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:245:12: arrayDecl
                    {
                    pushFollow(FOLLOW_arrayDecl_in_instanceDecl329);
                    arrayDecl47=arrayDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayDecl47.getTree());

                    }
                    break;

            }

            IDENT48=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceDecl332); 
            IDENT48_tree = (CommonTree)adaptor.create(IDENT48);
            adaptor.addChild(root_0, IDENT48_tree);

            string_literal49=(Token)match(input,36,FOLLOW_36_in_instanceDecl334); 
            IDENT50=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceDecl337); 
            IDENT50_tree = (CommonTree)adaptor.create(IDENT50);
            adaptor.addChild(root_0, IDENT50_tree);

            string_literal51=(Token)match(input,28,FOLLOW_28_in_instanceDecl339); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:246:3: ( attributeAssignment | pinAssignment )*
            loop15:
            do {
                int alt15=3;
                alt15 = dfa15.predict(input);
                switch (alt15) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:246:4: attributeAssignment
            	    {
            	    pushFollow(FOLLOW_attributeAssignment_in_instanceDecl345);
            	    attributeAssignment52=attributeAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeAssignment52.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:246:26: pinAssignment
            	    {
            	    pushFollow(FOLLOW_pinAssignment_in_instanceDecl349);
            	    pinAssignment53=pinAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinAssignment53.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            string_literal54=(Token)match(input,30,FOLLOW_30_in_instanceDecl355); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:247:16: ( 'inst' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==35) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:247:16: 'inst'
                    {
                    string_literal55=(Token)match(input,35,FOLLOW_35_in_instanceDecl358); 

                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:247:19: ( IDENT )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==IDENT) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:247:19: IDENT
                    {
                    IDENT56=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceDecl362); 
                    IDENT56_tree = (CommonTree)adaptor.create(IDENT56);
                    adaptor.addChild(root_0, IDENT56_tree);


                    }
                    break;

            }

            SEMICOLON57=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_instanceDecl365); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:250:1: attributeAssignment : ( 'newattr' )? ( instanceQualifier )? IDENT EQUALS STRING SEMICOLON ;
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:261:2: ( ( 'newattr' )? ( instanceQualifier )? IDENT EQUALS STRING SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:261:5: ( 'newattr' )? ( instanceQualifier )? IDENT EQUALS STRING SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:261:5: ( 'newattr' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==37) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:261:6: 'newattr'
                    {
                    string_literal58=(Token)match(input,37,FOLLOW_37_in_attributeAssignment381); 
                    string_literal58_tree = (CommonTree)adaptor.create(string_literal58);
                    adaptor.addChild(root_0, string_literal58_tree);


                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:261:18: ( instanceQualifier )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==IDENT) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==PERIOD||LA19_1==LEFTPAREN) ) {
                    alt19=1;
                }
            }
            else if ( (LA19_0==38) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:261:18: instanceQualifier
                    {
                    pushFollow(FOLLOW_instanceQualifier_in_attributeAssignment385);
                    instanceQualifier59=instanceQualifier();

                    state._fsp--;

                    adaptor.addChild(root_0, instanceQualifier59.getTree());

                    }
                    break;

            }

            IDENT60=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeAssignment388); 
            IDENT60_tree = (CommonTree)adaptor.create(IDENT60);
            adaptor.addChild(root_0, IDENT60_tree);

            EQUALS61=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeAssignment390); 
            EQUALS61_tree = (CommonTree)adaptor.create(EQUALS61);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS61_tree, root_0);

            STRING62=(Token)match(input,STRING,FOLLOW_STRING_in_attributeAssignment393); 
            STRING62_tree = (CommonTree)adaptor.create(STRING62);
            adaptor.addChild(root_0, STRING62_tree);

            SEMICOLON63=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeAssignment395); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:264:1: instanceQualifier : ( IDENT | 'this' ) ( arrayList )? PERIOD ;
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:272:2: ( ( IDENT | 'this' ) ( arrayList )? PERIOD )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:272:4: ( IDENT | 'this' ) ( arrayList )? PERIOD
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

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:272:21: ( arrayList )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==LEFTPAREN) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:272:21: arrayList
                    {
                    pushFollow(FOLLOW_arrayList_in_instanceQualifier418);
                    arrayList65=arrayList();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayList65.getTree());

                    }
                    break;

            }

            PERIOD66=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_instanceQualifier421); 
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:275:1: pinAssignment : ( instanceQualifier )? IDENT ( sliceList )? EQUALS concatenation SEMICOLON ;
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:283:2: ( ( instanceQualifier )? IDENT ( sliceList )? EQUALS concatenation SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:283:4: ( instanceQualifier )? IDENT ( sliceList )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:283:4: ( instanceQualifier )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==IDENT) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==PERIOD||LA21_1==LEFTPAREN) ) {
                    alt21=1;
                }
            }
            else if ( (LA21_0==38) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:283:4: instanceQualifier
                    {
                    pushFollow(FOLLOW_instanceQualifier_in_pinAssignment437);
                    instanceQualifier67=instanceQualifier();

                    state._fsp--;

                    adaptor.addChild(root_0, instanceQualifier67.getTree());

                    }
                    break;

            }

            IDENT68=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinAssignment440); 
            IDENT68_tree = (CommonTree)adaptor.create(IDENT68);
            adaptor.addChild(root_0, IDENT68_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:283:29: ( sliceList )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==LEFTBRACKET) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:283:29: sliceList
                    {
                    pushFollow(FOLLOW_sliceList_in_pinAssignment442);
                    sliceList69=sliceList();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceList69.getTree());

                    }
                    break;

            }

            EQUALS70=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinAssignment445); 
            EQUALS70_tree = (CommonTree)adaptor.create(EQUALS70);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS70_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_pinAssignment448);
            concatenation71=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation71.getTree());
            SEMICOLON72=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinAssignment450); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:286:1: netAssignment : IDENT ( sliceList )? EQUALS concatenation SEMICOLON ;
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:291:2: ( IDENT ( sliceList )? EQUALS concatenation SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:291:4: IDENT ( sliceList )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT73=(Token)match(input,IDENT,FOLLOW_IDENT_in_netAssignment464); 
            IDENT73_tree = (CommonTree)adaptor.create(IDENT73);
            adaptor.addChild(root_0, IDENT73_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:291:10: ( sliceList )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==LEFTBRACKET) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:291:10: sliceList
                    {
                    pushFollow(FOLLOW_sliceList_in_netAssignment466);
                    sliceList74=sliceList();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceList74.getTree());

                    }
                    break;

            }

            EQUALS75=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_netAssignment469); 
            EQUALS75_tree = (CommonTree)adaptor.create(EQUALS75);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS75_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_netAssignment472);
            concatenation76=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation76.getTree());
            SEMICOLON77=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netAssignment474); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:294:1: concatenation : ( ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* ) | ( LEFTANGLE IDENT ( sliceList )? RIGHTANGLE ) | 'open' );
    public final PhdlParser.concatenation_return concatenation() throws RecognitionException {
        PhdlParser.concatenation_return retval = new PhdlParser.concatenation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT78=null;
        Token AMPERSAND80=null;
        Token IDENT81=null;
        Token LEFTANGLE83=null;
        Token IDENT84=null;
        Token RIGHTANGLE86=null;
        Token string_literal87=null;
        PhdlParser.sliceList_return sliceList79 = null;

        PhdlParser.sliceList_return sliceList82 = null;

        PhdlParser.sliceList_return sliceList85 = null;


        CommonTree IDENT78_tree=null;
        CommonTree AMPERSAND80_tree=null;
        CommonTree IDENT81_tree=null;
        CommonTree LEFTANGLE83_tree=null;
        CommonTree IDENT84_tree=null;
        CommonTree RIGHTANGLE86_tree=null;
        CommonTree string_literal87_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:300:2: ( ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* ) | ( LEFTANGLE IDENT ( sliceList )? RIGHTANGLE ) | 'open' )
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:300:4: ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:300:4: ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:300:5: ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )*
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:300:5: ( IDENT ( sliceList )? )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:300:6: IDENT ( sliceList )?
                    {
                    IDENT78=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation491); 
                    IDENT78_tree = (CommonTree)adaptor.create(IDENT78);
                    adaptor.addChild(root_0, IDENT78_tree);

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:300:12: ( sliceList )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==LEFTBRACKET) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:300:12: sliceList
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation493);
                            sliceList79=sliceList();

                            state._fsp--;

                            adaptor.addChild(root_0, sliceList79.getTree());

                            }
                            break;

                    }


                    }

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:300:24: ( AMPERSAND IDENT ( sliceList )? )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==AMPERSAND) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:300:25: AMPERSAND IDENT ( sliceList )?
                    	    {
                    	    AMPERSAND80=(Token)match(input,AMPERSAND,FOLLOW_AMPERSAND_in_concatenation498); 
                    	    IDENT81=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation501); 
                    	    IDENT81_tree = (CommonTree)adaptor.create(IDENT81);
                    	    adaptor.addChild(root_0, IDENT81_tree);

                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:300:42: ( sliceList )?
                    	    int alt25=2;
                    	    int LA25_0 = input.LA(1);

                    	    if ( (LA25_0==LEFTBRACKET) ) {
                    	        alt25=1;
                    	    }
                    	    switch (alt25) {
                    	        case 1 :
                    	            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:300:42: sliceList
                    	            {
                    	            pushFollow(FOLLOW_sliceList_in_concatenation503);
                    	            sliceList82=sliceList();

                    	            state._fsp--;

                    	            adaptor.addChild(root_0, sliceList82.getTree());

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:301:4: ( LEFTANGLE IDENT ( sliceList )? RIGHTANGLE )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:301:4: ( LEFTANGLE IDENT ( sliceList )? RIGHTANGLE )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:301:5: LEFTANGLE IDENT ( sliceList )? RIGHTANGLE
                    {
                    LEFTANGLE83=(Token)match(input,LEFTANGLE,FOLLOW_LEFTANGLE_in_concatenation515); 
                    LEFTANGLE83_tree = (CommonTree)adaptor.create(LEFTANGLE83);
                    adaptor.addChild(root_0, LEFTANGLE83_tree);

                    IDENT84=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation517); 
                    IDENT84_tree = (CommonTree)adaptor.create(IDENT84);
                    adaptor.addChild(root_0, IDENT84_tree);

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:301:21: ( sliceList )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==LEFTBRACKET) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:301:21: sliceList
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation519);
                            sliceList85=sliceList();

                            state._fsp--;

                            adaptor.addChild(root_0, sliceList85.getTree());

                            }
                            break;

                    }

                    RIGHTANGLE86=(Token)match(input,RIGHTANGLE,FOLLOW_RIGHTANGLE_in_concatenation522); 

                    }


                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:302:5: 'open'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal87=(Token)match(input,39,FOLLOW_39_in_concatenation530); 
                    string_literal87_tree = (CommonTree)adaptor.create(string_literal87);
                    adaptor.addChild(root_0, string_literal87_tree);


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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:305:1: pinList : LEFTBRACE ( IDENT | INTEGER ) ( COMMA ( IDENT | INTEGER ) )* RIGHTBRACE ;
    public final PhdlParser.pinList_return pinList() throws RecognitionException {
        PhdlParser.pinList_return retval = new PhdlParser.pinList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTBRACE88=null;
        Token set89=null;
        Token COMMA90=null;
        Token set91=null;
        Token RIGHTBRACE92=null;

        CommonTree LEFTBRACE88_tree=null;
        CommonTree set89_tree=null;
        CommonTree COMMA90_tree=null;
        CommonTree set91_tree=null;
        CommonTree RIGHTBRACE92_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:310:2: ( LEFTBRACE ( IDENT | INTEGER ) ( COMMA ( IDENT | INTEGER ) )* RIGHTBRACE )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:310:5: LEFTBRACE ( IDENT | INTEGER ) ( COMMA ( IDENT | INTEGER ) )* RIGHTBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACE88=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_pinList545); 
            set89=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||input.LA(1)==INTEGER ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set89));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:310:34: ( COMMA ( IDENT | INTEGER ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==COMMA) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:310:35: COMMA ( IDENT | INTEGER )
            	    {
            	    COMMA90=(Token)match(input,COMMA,FOLLOW_COMMA_in_pinList557); 
            	    set91=(Token)input.LT(1);
            	    if ( input.LA(1)==IDENT||input.LA(1)==INTEGER ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (CommonTree)adaptor.create(set91));
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

            RIGHTBRACE92=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_pinList570); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:313:1: sliceList : LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTBRACKET ;
    public final PhdlParser.sliceList_return sliceList() throws RecognitionException {
        PhdlParser.sliceList_return retval = new PhdlParser.sliceList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTBRACKET93=null;
        Token INTEGER94=null;
        Token COLON95=null;
        Token INTEGER96=null;
        Token COMMA97=null;
        Token INTEGER98=null;
        Token COMMA99=null;
        Token INTEGER100=null;
        Token RIGHTBRACKET101=null;

        CommonTree LEFTBRACKET93_tree=null;
        CommonTree INTEGER94_tree=null;
        CommonTree COLON95_tree=null;
        CommonTree INTEGER96_tree=null;
        CommonTree COMMA97_tree=null;
        CommonTree INTEGER98_tree=null;
        CommonTree COMMA99_tree=null;
        CommonTree INTEGER100_tree=null;
        CommonTree RIGHTBRACKET101_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:319:2: ( LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTBRACKET )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:319:5: LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTBRACKET
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACKET93=(Token)match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList586); 
            LEFTBRACKET93_tree = (CommonTree)adaptor.create(LEFTBRACKET93);
            adaptor.addChild(root_0, LEFTBRACKET93_tree);

            INTEGER94=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList588); 
            INTEGER94_tree = (CommonTree)adaptor.create(INTEGER94);
            adaptor.addChild(root_0, INTEGER94_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:319:25: ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? )
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:319:26: ( COLON INTEGER )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:319:26: ( COLON INTEGER )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:319:27: COLON INTEGER
                    {
                    COLON95=(Token)match(input,COLON,FOLLOW_COLON_in_sliceList592); 
                    COLON95_tree = (CommonTree)adaptor.create(COLON95);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON95_tree, root_0);

                    INTEGER96=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList595); 
                    INTEGER96_tree = (CommonTree)adaptor.create(INTEGER96);
                    adaptor.addChild(root_0, INTEGER96_tree);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:319:45: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:319:45: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==COMMA) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:319:46: COMMA INTEGER ( COMMA INTEGER )*
                            {
                            COMMA97=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceList601); 
                            COMMA97_tree = (CommonTree)adaptor.create(COMMA97);
                            root_0 = (CommonTree)adaptor.becomeRoot(COMMA97_tree, root_0);

                            INTEGER98=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList604); 
                            INTEGER98_tree = (CommonTree)adaptor.create(INTEGER98);
                            adaptor.addChild(root_0, INTEGER98_tree);

                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:319:61: ( COMMA INTEGER )*
                            loop30:
                            do {
                                int alt30=2;
                                int LA30_0 = input.LA(1);

                                if ( (LA30_0==COMMA) ) {
                                    alt30=1;
                                }


                                switch (alt30) {
                            	case 1 :
                            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:319:62: COMMA INTEGER
                            	    {
                            	    COMMA99=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceList607); 
                            	    INTEGER100=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList610); 
                            	    INTEGER100_tree = (CommonTree)adaptor.create(INTEGER100);
                            	    adaptor.addChild(root_0, INTEGER100_tree);


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

            RIGHTBRACKET101=(Token)match(input,RIGHTBRACKET,FOLLOW_RIGHTBRACKET_in_sliceList617); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:322:1: sliceDecl : LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RIGHTBRACKET ;
    public final PhdlParser.sliceDecl_return sliceDecl() throws RecognitionException {
        PhdlParser.sliceDecl_return retval = new PhdlParser.sliceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTBRACKET102=null;
        Token INTEGER103=null;
        Token COLON104=null;
        Token INTEGER105=null;
        Token COMMA106=null;
        Token INTEGER107=null;
        Token RIGHTBRACKET108=null;

        CommonTree LEFTBRACKET102_tree=null;
        CommonTree INTEGER103_tree=null;
        CommonTree COLON104_tree=null;
        CommonTree INTEGER105_tree=null;
        CommonTree COMMA106_tree=null;
        CommonTree INTEGER107_tree=null;
        CommonTree RIGHTBRACKET108_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:327:2: ( LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RIGHTBRACKET )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:327:4: LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RIGHTBRACKET
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACKET102=(Token)match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceDecl631); 
            LEFTBRACKET102_tree = (CommonTree)adaptor.create(LEFTBRACKET102);
            adaptor.addChild(root_0, LEFTBRACKET102_tree);

            INTEGER103=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl633); 
            INTEGER103_tree = (CommonTree)adaptor.create(INTEGER103);
            adaptor.addChild(root_0, INTEGER103_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:327:24: ( ( COLON INTEGER ) | ( COMMA INTEGER )+ )
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:327:25: ( COLON INTEGER )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:327:25: ( COLON INTEGER )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:327:26: COLON INTEGER
                    {
                    COLON104=(Token)match(input,COLON,FOLLOW_COLON_in_sliceDecl637); 
                    COLON104_tree = (CommonTree)adaptor.create(COLON104);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON104_tree, root_0);

                    INTEGER105=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl640); 
                    INTEGER105_tree = (CommonTree)adaptor.create(INTEGER105);
                    adaptor.addChild(root_0, INTEGER105_tree);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:327:44: ( COMMA INTEGER )+
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:327:44: ( COMMA INTEGER )+
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
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:327:45: COMMA INTEGER
                    	    {
                    	    COMMA106=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceDecl646); 
                    	    COMMA106_tree = (CommonTree)adaptor.create(COMMA106);
                    	    root_0 = (CommonTree)adaptor.becomeRoot(COMMA106_tree, root_0);

                    	    INTEGER107=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl649); 
                    	    INTEGER107_tree = (CommonTree)adaptor.create(INTEGER107);
                    	    adaptor.addChild(root_0, INTEGER107_tree);


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

            RIGHTBRACKET108=(Token)match(input,RIGHTBRACKET,FOLLOW_RIGHTBRACKET_in_sliceDecl654); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:330:1: arrayList : LEFTPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTPAREN ;
    public final PhdlParser.arrayList_return arrayList() throws RecognitionException {
        PhdlParser.arrayList_return retval = new PhdlParser.arrayList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTPAREN109=null;
        Token INTEGER110=null;
        Token COLON111=null;
        Token INTEGER112=null;
        Token COMMA113=null;
        Token INTEGER114=null;
        Token COMMA115=null;
        Token INTEGER116=null;
        Token RIGHTPAREN117=null;

        CommonTree LEFTPAREN109_tree=null;
        CommonTree INTEGER110_tree=null;
        CommonTree COLON111_tree=null;
        CommonTree INTEGER112_tree=null;
        CommonTree COMMA113_tree=null;
        CommonTree INTEGER114_tree=null;
        CommonTree COMMA115_tree=null;
        CommonTree INTEGER116_tree=null;
        CommonTree RIGHTPAREN117_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:335:2: ( LEFTPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTPAREN )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:335:5: LEFTPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTPAREN109=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList670); 
            LEFTPAREN109_tree = (CommonTree)adaptor.create(LEFTPAREN109);
            adaptor.addChild(root_0, LEFTPAREN109_tree);

            INTEGER110=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList672); 
            INTEGER110_tree = (CommonTree)adaptor.create(INTEGER110);
            adaptor.addChild(root_0, INTEGER110_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:335:23: ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? )
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:335:24: ( COLON INTEGER )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:335:24: ( COLON INTEGER )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:335:25: COLON INTEGER
                    {
                    COLON111=(Token)match(input,COLON,FOLLOW_COLON_in_arrayList676); 
                    COLON111_tree = (CommonTree)adaptor.create(COLON111);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON111_tree, root_0);

                    INTEGER112=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList679); 
                    INTEGER112_tree = (CommonTree)adaptor.create(INTEGER112);
                    adaptor.addChild(root_0, INTEGER112_tree);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:335:43: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:335:43: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==COMMA) ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:335:44: COMMA INTEGER ( COMMA INTEGER )*
                            {
                            COMMA113=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayList685); 
                            COMMA113_tree = (CommonTree)adaptor.create(COMMA113);
                            root_0 = (CommonTree)adaptor.becomeRoot(COMMA113_tree, root_0);

                            INTEGER114=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList688); 
                            INTEGER114_tree = (CommonTree)adaptor.create(INTEGER114);
                            adaptor.addChild(root_0, INTEGER114_tree);

                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:335:59: ( COMMA INTEGER )*
                            loop35:
                            do {
                                int alt35=2;
                                int LA35_0 = input.LA(1);

                                if ( (LA35_0==COMMA) ) {
                                    alt35=1;
                                }


                                switch (alt35) {
                            	case 1 :
                            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:335:60: COMMA INTEGER
                            	    {
                            	    COMMA115=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayList691); 
                            	    INTEGER116=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList694); 
                            	    INTEGER116_tree = (CommonTree)adaptor.create(INTEGER116);
                            	    adaptor.addChild(root_0, INTEGER116_tree);


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

            RIGHTPAREN117=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_arrayList701); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:338:1: arrayDecl : LEFTPAREN INTEGER COLON INTEGER RIGHTPAREN ;
    public final PhdlParser.arrayDecl_return arrayDecl() throws RecognitionException {
        PhdlParser.arrayDecl_return retval = new PhdlParser.arrayDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTPAREN118=null;
        Token INTEGER119=null;
        Token COLON120=null;
        Token INTEGER121=null;
        Token RIGHTPAREN122=null;

        CommonTree LEFTPAREN118_tree=null;
        CommonTree INTEGER119_tree=null;
        CommonTree COLON120_tree=null;
        CommonTree INTEGER121_tree=null;
        CommonTree RIGHTPAREN122_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:343:2: ( LEFTPAREN INTEGER COLON INTEGER RIGHTPAREN )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:343:4: LEFTPAREN INTEGER COLON INTEGER RIGHTPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTPAREN118=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayDecl715); 
            LEFTPAREN118_tree = (CommonTree)adaptor.create(LEFTPAREN118);
            adaptor.addChild(root_0, LEFTPAREN118_tree);

            INTEGER119=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayDecl717); 
            INTEGER119_tree = (CommonTree)adaptor.create(INTEGER119);
            adaptor.addChild(root_0, INTEGER119_tree);

            COLON120=(Token)match(input,COLON,FOLLOW_COLON_in_arrayDecl719); 
            COLON120_tree = (CommonTree)adaptor.create(COLON120);
            root_0 = (CommonTree)adaptor.becomeRoot(COLON120_tree, root_0);

            INTEGER121=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayDecl722); 
            INTEGER121_tree = (CommonTree)adaptor.create(INTEGER121);
            adaptor.addChild(root_0, INTEGER121_tree);

            RIGHTPAREN122=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_arrayDecl724); 

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


    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA15_eotS =
        "\22\uffff";
    static final String DFA15_eofS =
        "\22\uffff";
    static final String DFA15_minS =
        "\1\4\2\uffff\1\6\1\11\1\4\1\16\1\4\1\uffff\1\10\1\6\2\16\1\11\1"+
        "\24\1\10\1\16\1\10";
    static final String DFA15_maxS =
        "\1\46\2\uffff\2\23\1\47\1\16\1\4\1\uffff\1\24\1\20\2\16\1\11\2"+
        "\24\1\16\1\24";
    static final String DFA15_acceptS =
        "\1\uffff\1\3\1\1\5\uffff\1\2\11\uffff";
    static final String DFA15_specialS =
        "\22\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\3\31\uffff\1\1\6\uffff\1\2\1\4",
            "",
            "",
            "\1\5\2\uffff\1\7\6\uffff\1\10\2\uffff\1\6",
            "\1\7\11\uffff\1\6",
            "\1\10\2\uffff\1\2\3\uffff\1\10\33\uffff\1\10",
            "\1\11",
            "\1\12",
            "",
            "\1\14\10\uffff\1\13\2\uffff\1\15",
            "\1\5\11\uffff\1\10",
            "\1\16",
            "\1\17",
            "\1\7",
            "\1\15",
            "\1\20\13\uffff\1\15",
            "\1\21",
            "\1\20\13\uffff\1\15"
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "()* loopback of 246:3: ( attributeAssignment | pinAssignment )*";
        }
    }
 

    public static final BitSet FOLLOW_designDecl_in_sourceText82 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_EOF_in_sourceText85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_designDecl98 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_designDecl101 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_designDecl103 = new BitSet(new long[]{0x00000004A0000000L});
    public static final BitSet FOLLOW_deviceDecl_in_designDecl110 = new BitSet(new long[]{0x00000004A0000000L});
    public static final BitSet FOLLOW_netDecl_in_designDecl114 = new BitSet(new long[]{0x00000004A0000000L});
    public static final BitSet FOLLOW_29_in_designDecl120 = new BitSet(new long[]{0x0000000840000010L});
    public static final BitSet FOLLOW_instanceDecl_in_designDecl125 = new BitSet(new long[]{0x0000000840000010L});
    public static final BitSet FOLLOW_netAssignment_in_designDecl129 = new BitSet(new long[]{0x0000000840000010L});
    public static final BitSet FOLLOW_30_in_designDecl135 = new BitSet(new long[]{0x0000000008000030L});
    public static final BitSet FOLLOW_27_in_designDecl138 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_IDENT_in_designDecl142 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_designDecl145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_deviceDecl160 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl163 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_deviceDecl165 = new BitSet(new long[]{0x0000000340000000L});
    public static final BitSet FOLLOW_attributeDecl_in_deviceDecl172 = new BitSet(new long[]{0x0000000340000000L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl176 = new BitSet(new long[]{0x0000000340000000L});
    public static final BitSet FOLLOW_30_in_deviceDecl183 = new BitSet(new long[]{0x0000000080000030L});
    public static final BitSet FOLLOW_31_in_deviceDecl186 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl190 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_deviceDecl193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_attributeDecl208 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attributeDecl211 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_attributeDecl213 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_in_attributeDecl216 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeDecl218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_pinDecl232 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_sliceDecl_in_pinDecl235 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl238 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_pinDecl240 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_pinList_in_pinDecl243 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinDecl245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_type260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_netDecl273 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_sliceDecl_in_netDecl276 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl279 = new BitSet(new long[]{0x0000000010000120L});
    public static final BitSet FOLLOW_COMMA_in_netDecl282 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl284 = new BitSet(new long[]{0x0000000010000120L});
    public static final BitSet FOLLOW_netAttributes_in_netDecl288 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_netDecl291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_netAttributes306 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_attributeDecl_in_netAttributes309 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_30_in_netAttributes312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_instanceDecl326 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_arrayDecl_in_instanceDecl329 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instanceDecl332 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_instanceDecl334 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instanceDecl337 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_instanceDecl339 = new BitSet(new long[]{0x0000006040000010L});
    public static final BitSet FOLLOW_attributeAssignment_in_instanceDecl345 = new BitSet(new long[]{0x0000006040000010L});
    public static final BitSet FOLLOW_pinAssignment_in_instanceDecl349 = new BitSet(new long[]{0x0000006040000010L});
    public static final BitSet FOLLOW_30_in_instanceDecl355 = new BitSet(new long[]{0x0000000800000030L});
    public static final BitSet FOLLOW_35_in_instanceDecl358 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_IDENT_in_instanceDecl362 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_instanceDecl365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_attributeAssignment381 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_instanceQualifier_in_attributeAssignment385 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attributeAssignment388 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_attributeAssignment390 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_in_attributeAssignment393 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeAssignment395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_instanceQualifier410 = new BitSet(new long[]{0x0000000000080200L});
    public static final BitSet FOLLOW_arrayList_in_instanceQualifier418 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_PERIOD_in_instanceQualifier421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instanceQualifier_in_pinAssignment437 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinAssignment440 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_sliceList_in_pinAssignment442 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssignment445 = new BitSet(new long[]{0x0000008000000810L});
    public static final BitSet FOLLOW_concatenation_in_pinAssignment448 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinAssignment450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_netAssignment464 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_sliceList_in_netAssignment466 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_netAssignment469 = new BitSet(new long[]{0x0000008000000810L});
    public static final BitSet FOLLOW_concatenation_in_netAssignment472 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_netAssignment474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_concatenation491 = new BitSet(new long[]{0x0000000000010402L});
    public static final BitSet FOLLOW_sliceList_in_concatenation493 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_AMPERSAND_in_concatenation498 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation501 = new BitSet(new long[]{0x0000000000010402L});
    public static final BitSet FOLLOW_sliceList_in_concatenation503 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_LEFTANGLE_in_concatenation515 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation517 = new BitSet(new long[]{0x0000000000011000L});
    public static final BitSet FOLLOW_sliceList_in_concatenation519 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RIGHTANGLE_in_concatenation522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_concatenation530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACE_in_pinList545 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_set_in_pinList548 = new BitSet(new long[]{0x0000000000008100L});
    public static final BitSet FOLLOW_COMMA_in_pinList557 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_set_in_pinList560 = new BitSet(new long[]{0x0000000000008100L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_pinList570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList586 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList588 = new BitSet(new long[]{0x0000000000060100L});
    public static final BitSet FOLLOW_COLON_in_sliceList592 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList595 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_sliceList601 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList604 = new BitSet(new long[]{0x0000000000040100L});
    public static final BitSet FOLLOW_COMMA_in_sliceList607 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList610 = new BitSet(new long[]{0x0000000000040100L});
    public static final BitSet FOLLOW_RIGHTBRACKET_in_sliceList617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceDecl631 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl633 = new BitSet(new long[]{0x0000000000020100L});
    public static final BitSet FOLLOW_COLON_in_sliceDecl637 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl640 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_sliceDecl646 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl649 = new BitSet(new long[]{0x0000000000040100L});
    public static final BitSet FOLLOW_RIGHTBRACKET_in_sliceDecl654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList670 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList672 = new BitSet(new long[]{0x0000000000120100L});
    public static final BitSet FOLLOW_COLON_in_arrayList676 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList679 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_arrayList685 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList688 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_COMMA_in_arrayList691 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList694 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_RIGHTPAREN_in_arrayList701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayDecl715 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayDecl717 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_arrayDecl719 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayDecl722 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RIGHTPAREN_in_arrayDecl724 = new BitSet(new long[]{0x0000000000000002L});

}