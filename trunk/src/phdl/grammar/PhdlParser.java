// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g 2011-07-28 12:27:55

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "SEMICOLON", "EQUALS", "STRING", "COMMA", "PERIOD", "AMPERSAND", "LEFTANGLE", "RIGHTANGLE", "LEFTBRACE", "INTEGER", "RIGHTBRACE", "LEFTBRACKET", "COLON", "RIGHTBRACKET", "LEFTPAREN", "RIGHTPAREN", "CHAR", "DIGIT", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "INCLUDE", "'design'", "'is'", "'begin'", "'end'", "'device'", "'attr'", "'pin'", "'net'", "'inst'", "'of'", "'info'", "'newattr'", "'this'", "'open'"
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
    public static final int T__40=40;
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
    public String getGrammarFileName() { return "C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g"; }



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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:159:1: sourceText : ( designDecl )+ EOF ;
    public final PhdlParser.sourceText_return sourceText() throws RecognitionException {
        PhdlParser.sourceText_return retval = new PhdlParser.sourceText_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF2=null;
        PhdlParser.designDecl_return designDecl1 = null;


        CommonTree EOF2_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:164:2: ( ( designDecl )+ EOF )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:164:4: ( designDecl )+ EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:164:4: ( designDecl )+
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
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:164:4: designDecl
            	    {
            	    pushFollow(FOLLOW_designDecl_in_sourceText79);
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

            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_sourceText82); 
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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:167:1: designDecl : 'design' IDENT 'is' ( deviceDecl | netDecl | infoStruct )* 'begin' ( instanceDecl | netAssignment )* 'end' ( 'design' )? ( IDENT )? SEMICOLON ;
    public final PhdlParser.designDecl_return designDecl() throws RecognitionException {
        PhdlParser.designDecl_return retval = new PhdlParser.designDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal3=null;
        Token IDENT4=null;
        Token string_literal5=null;
        Token string_literal9=null;
        Token string_literal12=null;
        Token string_literal13=null;
        Token IDENT14=null;
        Token SEMICOLON15=null;
        PhdlParser.deviceDecl_return deviceDecl6 = null;

        PhdlParser.netDecl_return netDecl7 = null;

        PhdlParser.infoStruct_return infoStruct8 = null;

        PhdlParser.instanceDecl_return instanceDecl10 = null;

        PhdlParser.netAssignment_return netAssignment11 = null;


        CommonTree string_literal3_tree=null;
        CommonTree IDENT4_tree=null;
        CommonTree string_literal5_tree=null;
        CommonTree string_literal9_tree=null;
        CommonTree string_literal12_tree=null;
        CommonTree string_literal13_tree=null;
        CommonTree IDENT14_tree=null;
        CommonTree SEMICOLON15_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:175:2: ( 'design' IDENT 'is' ( deviceDecl | netDecl | infoStruct )* 'begin' ( instanceDecl | netAssignment )* 'end' ( 'design' )? ( IDENT )? SEMICOLON )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:175:4: 'design' IDENT 'is' ( deviceDecl | netDecl | infoStruct )* 'begin' ( instanceDecl | netAssignment )* 'end' ( 'design' )? ( IDENT )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal3=(Token)match(input,27,FOLLOW_27_in_designDecl95); 
            string_literal3_tree = (CommonTree)adaptor.create(string_literal3);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal3_tree, root_0);

            IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_designDecl98); 
            IDENT4_tree = (CommonTree)adaptor.create(IDENT4);
            adaptor.addChild(root_0, IDENT4_tree);

            string_literal5=(Token)match(input,28,FOLLOW_28_in_designDecl100); 
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:176:3: ( deviceDecl | netDecl | infoStruct )*
            loop2:
            do {
                int alt2=4;
                switch ( input.LA(1) ) {
                case 31:
                    {
                    alt2=1;
                    }
                    break;
                case 34:
                    {
                    alt2=2;
                    }
                    break;
                case 37:
                    {
                    alt2=3;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:176:4: deviceDecl
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_designDecl107);
            	    deviceDecl6=deviceDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, deviceDecl6.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:176:17: netDecl
            	    {
            	    pushFollow(FOLLOW_netDecl_in_designDecl111);
            	    netDecl7=netDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netDecl7.getTree());

            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:176:27: infoStruct
            	    {
            	    pushFollow(FOLLOW_infoStruct_in_designDecl115);
            	    infoStruct8=infoStruct();

            	    state._fsp--;

            	    adaptor.addChild(root_0, infoStruct8.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            string_literal9=(Token)match(input,29,FOLLOW_29_in_designDecl121); 
            string_literal9_tree = (CommonTree)adaptor.create(string_literal9);
            adaptor.addChild(root_0, string_literal9_tree);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:178:3: ( instanceDecl | netAssignment )*
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
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:178:4: instanceDecl
            	    {
            	    pushFollow(FOLLOW_instanceDecl_in_designDecl126);
            	    instanceDecl10=instanceDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, instanceDecl10.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:178:19: netAssignment
            	    {
            	    pushFollow(FOLLOW_netAssignment_in_designDecl130);
            	    netAssignment11=netAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netAssignment11.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            string_literal12=(Token)match(input,30,FOLLOW_30_in_designDecl136); 
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:179:18: ( 'design' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==27) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:179:18: 'design'
                    {
                    string_literal13=(Token)match(input,27,FOLLOW_27_in_designDecl139); 

                    }
                    break;

            }

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:179:21: ( IDENT )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==IDENT) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:179:21: IDENT
                    {
                    IDENT14=(Token)match(input,IDENT,FOLLOW_IDENT_in_designDecl143); 
                    IDENT14_tree = (CommonTree)adaptor.create(IDENT14);
                    adaptor.addChild(root_0, IDENT14_tree);


                    }
                    break;

            }

            SEMICOLON15=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_designDecl146); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:182:1: deviceDecl : 'device' IDENT 'is' ( attributeDecl | pinDecl )* 'end' ( 'device' )? ( IDENT )? SEMICOLON ;
    public final PhdlParser.deviceDecl_return deviceDecl() throws RecognitionException {
        PhdlParser.deviceDecl_return retval = new PhdlParser.deviceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal16=null;
        Token IDENT17=null;
        Token string_literal18=null;
        Token string_literal21=null;
        Token string_literal22=null;
        Token IDENT23=null;
        Token SEMICOLON24=null;
        PhdlParser.attributeDecl_return attributeDecl19 = null;

        PhdlParser.pinDecl_return pinDecl20 = null;


        CommonTree string_literal16_tree=null;
        CommonTree IDENT17_tree=null;
        CommonTree string_literal18_tree=null;
        CommonTree string_literal21_tree=null;
        CommonTree string_literal22_tree=null;
        CommonTree IDENT23_tree=null;
        CommonTree SEMICOLON24_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:189:2: ( 'device' IDENT 'is' ( attributeDecl | pinDecl )* 'end' ( 'device' )? ( IDENT )? SEMICOLON )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:189:4: 'device' IDENT 'is' ( attributeDecl | pinDecl )* 'end' ( 'device' )? ( IDENT )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal16=(Token)match(input,31,FOLLOW_31_in_deviceDecl161); 
            string_literal16_tree = (CommonTree)adaptor.create(string_literal16);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal16_tree, root_0);

            IDENT17=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl164); 
            IDENT17_tree = (CommonTree)adaptor.create(IDENT17);
            adaptor.addChild(root_0, IDENT17_tree);

            string_literal18=(Token)match(input,28,FOLLOW_28_in_deviceDecl166); 
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:190:3: ( attributeDecl | pinDecl )*
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
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:190:5: attributeDecl
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_deviceDecl173);
            	    attributeDecl19=attributeDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeDecl19.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:190:21: pinDecl
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl177);
            	    pinDecl20=pinDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinDecl20.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            string_literal21=(Token)match(input,30,FOLLOW_30_in_deviceDecl184); 
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:191:18: ( 'device' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==31) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:191:18: 'device'
                    {
                    string_literal22=(Token)match(input,31,FOLLOW_31_in_deviceDecl187); 

                    }
                    break;

            }

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:191:21: ( IDENT )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==IDENT) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:191:21: IDENT
                    {
                    IDENT23=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl191); 
                    IDENT23_tree = (CommonTree)adaptor.create(IDENT23);
                    adaptor.addChild(root_0, IDENT23_tree);


                    }
                    break;

            }

            SEMICOLON24=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_deviceDecl194); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:194:1: attributeDecl : 'attr' IDENT EQUALS STRING SEMICOLON ;
    public final PhdlParser.attributeDecl_return attributeDecl() throws RecognitionException {
        PhdlParser.attributeDecl_return retval = new PhdlParser.attributeDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal25=null;
        Token IDENT26=null;
        Token EQUALS27=null;
        Token STRING28=null;
        Token SEMICOLON29=null;

        CommonTree string_literal25_tree=null;
        CommonTree IDENT26_tree=null;
        CommonTree EQUALS27_tree=null;
        CommonTree STRING28_tree=null;
        CommonTree SEMICOLON29_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:199:2: ( 'attr' IDENT EQUALS STRING SEMICOLON )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:199:4: 'attr' IDENT EQUALS STRING SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal25=(Token)match(input,32,FOLLOW_32_in_attributeDecl209); 
            string_literal25_tree = (CommonTree)adaptor.create(string_literal25);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal25_tree, root_0);

            IDENT26=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeDecl212); 
            IDENT26_tree = (CommonTree)adaptor.create(IDENT26);
            adaptor.addChild(root_0, IDENT26_tree);

            EQUALS27=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeDecl214); 
            STRING28=(Token)match(input,STRING,FOLLOW_STRING_in_attributeDecl217); 
            STRING28_tree = (CommonTree)adaptor.create(STRING28);
            adaptor.addChild(root_0, STRING28_tree);

            SEMICOLON29=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeDecl219); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:202:1: pinDecl : type ( sliceDecl )? IDENT EQUALS pinList SEMICOLON ;
    public final PhdlParser.pinDecl_return pinDecl() throws RecognitionException {
        PhdlParser.pinDecl_return retval = new PhdlParser.pinDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT32=null;
        Token EQUALS33=null;
        Token SEMICOLON35=null;
        PhdlParser.type_return type30 = null;

        PhdlParser.sliceDecl_return sliceDecl31 = null;

        PhdlParser.pinList_return pinList34 = null;


        CommonTree IDENT32_tree=null;
        CommonTree EQUALS33_tree=null;
        CommonTree SEMICOLON35_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:207:2: ( type ( sliceDecl )? IDENT EQUALS pinList SEMICOLON )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:207:4: type ( sliceDecl )? IDENT EQUALS pinList SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_type_in_pinDecl233);
            type30=type();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(type30.getTree(), root_0);
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:207:10: ( sliceDecl )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==LEFTBRACKET) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:207:10: sliceDecl
                    {
                    pushFollow(FOLLOW_sliceDecl_in_pinDecl236);
                    sliceDecl31=sliceDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceDecl31.getTree());

                    }
                    break;

            }

            IDENT32=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinDecl239); 
            IDENT32_tree = (CommonTree)adaptor.create(IDENT32);
            adaptor.addChild(root_0, IDENT32_tree);

            EQUALS33=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinDecl241); 
            pushFollow(FOLLOW_pinList_in_pinDecl244);
            pinList34=pinList();

            state._fsp--;

            adaptor.addChild(root_0, pinList34.getTree());
            SEMICOLON35=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinDecl246); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:210:1: type : 'pin' ;
    public final PhdlParser.type_return type() throws RecognitionException {
        PhdlParser.type_return retval = new PhdlParser.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal36=null;

        CommonTree string_literal36_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:214:2: ( 'pin' )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:214:4: 'pin'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal36=(Token)match(input,33,FOLLOW_33_in_type261); 
            string_literal36_tree = (CommonTree)adaptor.create(string_literal36);
            adaptor.addChild(root_0, string_literal36_tree);


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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:217:1: netDecl : 'net' ( sliceDecl )? IDENT ( COMMA IDENT )* ( netAttributes )? SEMICOLON ;
    public final PhdlParser.netDecl_return netDecl() throws RecognitionException {
        PhdlParser.netDecl_return retval = new PhdlParser.netDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal37=null;
        Token IDENT39=null;
        Token COMMA40=null;
        Token IDENT41=null;
        Token SEMICOLON43=null;
        PhdlParser.sliceDecl_return sliceDecl38 = null;

        PhdlParser.netAttributes_return netAttributes42 = null;


        CommonTree string_literal37_tree=null;
        CommonTree IDENT39_tree=null;
        CommonTree COMMA40_tree=null;
        CommonTree IDENT41_tree=null;
        CommonTree SEMICOLON43_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:222:2: ( 'net' ( sliceDecl )? IDENT ( COMMA IDENT )* ( netAttributes )? SEMICOLON )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:222:4: 'net' ( sliceDecl )? IDENT ( COMMA IDENT )* ( netAttributes )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal37=(Token)match(input,34,FOLLOW_34_in_netDecl274); 
            string_literal37_tree = (CommonTree)adaptor.create(string_literal37);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal37_tree, root_0);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:222:11: ( sliceDecl )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==LEFTBRACKET) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:222:11: sliceDecl
                    {
                    pushFollow(FOLLOW_sliceDecl_in_netDecl277);
                    sliceDecl38=sliceDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceDecl38.getTree());

                    }
                    break;

            }

            IDENT39=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl280); 
            IDENT39_tree = (CommonTree)adaptor.create(IDENT39);
            adaptor.addChild(root_0, IDENT39_tree);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:222:28: ( COMMA IDENT )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==COMMA) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:222:29: COMMA IDENT
            	    {
            	    COMMA40=(Token)match(input,COMMA,FOLLOW_COMMA_in_netDecl283); 
            	    COMMA40_tree = (CommonTree)adaptor.create(COMMA40);
            	    adaptor.addChild(root_0, COMMA40_tree);

            	    IDENT41=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl285); 
            	    IDENT41_tree = (CommonTree)adaptor.create(IDENT41);
            	    adaptor.addChild(root_0, IDENT41_tree);


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:222:43: ( netAttributes )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==28) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:222:43: netAttributes
                    {
                    pushFollow(FOLLOW_netAttributes_in_netDecl289);
                    netAttributes42=netAttributes();

                    state._fsp--;

                    adaptor.addChild(root_0, netAttributes42.getTree());

                    }
                    break;

            }

            SEMICOLON43=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netDecl292); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:225:1: netAttributes : 'is' ( attributeDecl )* 'end' ;
    public final PhdlParser.netAttributes_return netAttributes() throws RecognitionException {
        PhdlParser.netAttributes_return retval = new PhdlParser.netAttributes_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal44=null;
        Token string_literal46=null;
        PhdlParser.attributeDecl_return attributeDecl45 = null;


        CommonTree string_literal44_tree=null;
        CommonTree string_literal46_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:231:2: ( 'is' ( attributeDecl )* 'end' )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:231:4: 'is' ( attributeDecl )* 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal44=(Token)match(input,28,FOLLOW_28_in_netAttributes307); 
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:231:10: ( attributeDecl )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==32) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:231:10: attributeDecl
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_netAttributes310);
            	    attributeDecl45=attributeDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeDecl45.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            string_literal46=(Token)match(input,30,FOLLOW_30_in_netAttributes313); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:234:1: instanceDecl : 'inst' ( arrayDecl )? IDENT 'of' IDENT 'is' ( attributeAssignment | pinAssignment | infoStruct )* 'end' ( 'inst' )? ( IDENT )? SEMICOLON ;
    public final PhdlParser.instanceDecl_return instanceDecl() throws RecognitionException {
        PhdlParser.instanceDecl_return retval = new PhdlParser.instanceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal47=null;
        Token IDENT49=null;
        Token string_literal50=null;
        Token IDENT51=null;
        Token string_literal52=null;
        Token string_literal56=null;
        Token string_literal57=null;
        Token IDENT58=null;
        Token SEMICOLON59=null;
        PhdlParser.arrayDecl_return arrayDecl48 = null;

        PhdlParser.attributeAssignment_return attributeAssignment53 = null;

        PhdlParser.pinAssignment_return pinAssignment54 = null;

        PhdlParser.infoStruct_return infoStruct55 = null;


        CommonTree string_literal47_tree=null;
        CommonTree IDENT49_tree=null;
        CommonTree string_literal50_tree=null;
        CommonTree IDENT51_tree=null;
        CommonTree string_literal52_tree=null;
        CommonTree string_literal56_tree=null;
        CommonTree string_literal57_tree=null;
        CommonTree IDENT58_tree=null;
        CommonTree SEMICOLON59_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:243:2: ( 'inst' ( arrayDecl )? IDENT 'of' IDENT 'is' ( attributeAssignment | pinAssignment | infoStruct )* 'end' ( 'inst' )? ( IDENT )? SEMICOLON )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:243:4: 'inst' ( arrayDecl )? IDENT 'of' IDENT 'is' ( attributeAssignment | pinAssignment | infoStruct )* 'end' ( 'inst' )? ( IDENT )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal47=(Token)match(input,35,FOLLOW_35_in_instanceDecl327); 
            string_literal47_tree = (CommonTree)adaptor.create(string_literal47);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal47_tree, root_0);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:243:12: ( arrayDecl )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==LEFTPAREN) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:243:12: arrayDecl
                    {
                    pushFollow(FOLLOW_arrayDecl_in_instanceDecl330);
                    arrayDecl48=arrayDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayDecl48.getTree());

                    }
                    break;

            }

            IDENT49=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceDecl333); 
            IDENT49_tree = (CommonTree)adaptor.create(IDENT49);
            adaptor.addChild(root_0, IDENT49_tree);

            string_literal50=(Token)match(input,36,FOLLOW_36_in_instanceDecl335); 
            IDENT51=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceDecl338); 
            IDENT51_tree = (CommonTree)adaptor.create(IDENT51);
            adaptor.addChild(root_0, IDENT51_tree);

            string_literal52=(Token)match(input,28,FOLLOW_28_in_instanceDecl340); 
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:244:3: ( attributeAssignment | pinAssignment | infoStruct )*
            loop15:
            do {
                int alt15=4;
                alt15 = dfa15.predict(input);
                switch (alt15) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:244:4: attributeAssignment
            	    {
            	    pushFollow(FOLLOW_attributeAssignment_in_instanceDecl346);
            	    attributeAssignment53=attributeAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeAssignment53.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:244:26: pinAssignment
            	    {
            	    pushFollow(FOLLOW_pinAssignment_in_instanceDecl350);
            	    pinAssignment54=pinAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinAssignment54.getTree());

            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:244:42: infoStruct
            	    {
            	    pushFollow(FOLLOW_infoStruct_in_instanceDecl354);
            	    infoStruct55=infoStruct();

            	    state._fsp--;

            	    adaptor.addChild(root_0, infoStruct55.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            string_literal56=(Token)match(input,30,FOLLOW_30_in_instanceDecl360); 
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:245:16: ( 'inst' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==35) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:245:16: 'inst'
                    {
                    string_literal57=(Token)match(input,35,FOLLOW_35_in_instanceDecl363); 

                    }
                    break;

            }

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:245:19: ( IDENT )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==IDENT) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:245:19: IDENT
                    {
                    IDENT58=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceDecl367); 
                    IDENT58_tree = (CommonTree)adaptor.create(IDENT58);
                    adaptor.addChild(root_0, IDENT58_tree);


                    }
                    break;

            }

            SEMICOLON59=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_instanceDecl370); 

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

    public static class infoStruct_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "infoStruct"
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:248:1: infoStruct : 'info' '{' STRING '}' SEMICOLON ;
    public final PhdlParser.infoStruct_return infoStruct() throws RecognitionException {
        PhdlParser.infoStruct_return retval = new PhdlParser.infoStruct_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal60=null;
        Token char_literal61=null;
        Token STRING62=null;
        Token char_literal63=null;
        Token SEMICOLON64=null;

        CommonTree string_literal60_tree=null;
        CommonTree char_literal61_tree=null;
        CommonTree STRING62_tree=null;
        CommonTree char_literal63_tree=null;
        CommonTree SEMICOLON64_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:253:3: ( 'info' '{' STRING '}' SEMICOLON )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:253:5: 'info' '{' STRING '}' SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal60=(Token)match(input,37,FOLLOW_37_in_infoStruct385); 
            string_literal60_tree = (CommonTree)adaptor.create(string_literal60);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal60_tree, root_0);

            char_literal61=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_infoStruct388); 
            STRING62=(Token)match(input,STRING,FOLLOW_STRING_in_infoStruct391); 
            STRING62_tree = (CommonTree)adaptor.create(STRING62);
            adaptor.addChild(root_0, STRING62_tree);

            char_literal63=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_infoStruct393); 
            SEMICOLON64=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_infoStruct396); 

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
    // $ANTLR end "infoStruct"

    public static class attributeAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributeAssignment"
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:256:1: attributeAssignment : ( 'newattr' )? ( instanceQualifier )? IDENT EQUALS STRING SEMICOLON ;
    public final PhdlParser.attributeAssignment_return attributeAssignment() throws RecognitionException {
        PhdlParser.attributeAssignment_return retval = new PhdlParser.attributeAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal65=null;
        Token IDENT67=null;
        Token EQUALS68=null;
        Token STRING69=null;
        Token SEMICOLON70=null;
        PhdlParser.instanceQualifier_return instanceQualifier66 = null;


        CommonTree string_literal65_tree=null;
        CommonTree IDENT67_tree=null;
        CommonTree EQUALS68_tree=null;
        CommonTree STRING69_tree=null;
        CommonTree SEMICOLON70_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:267:2: ( ( 'newattr' )? ( instanceQualifier )? IDENT EQUALS STRING SEMICOLON )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:267:5: ( 'newattr' )? ( instanceQualifier )? IDENT EQUALS STRING SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:267:5: ( 'newattr' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==38) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:267:6: 'newattr'
                    {
                    string_literal65=(Token)match(input,38,FOLLOW_38_in_attributeAssignment413); 
                    string_literal65_tree = (CommonTree)adaptor.create(string_literal65);
                    adaptor.addChild(root_0, string_literal65_tree);


                    }
                    break;

            }

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:267:18: ( instanceQualifier )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==IDENT) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==PERIOD||LA19_1==LEFTPAREN) ) {
                    alt19=1;
                }
            }
            else if ( (LA19_0==39) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:267:18: instanceQualifier
                    {
                    pushFollow(FOLLOW_instanceQualifier_in_attributeAssignment417);
                    instanceQualifier66=instanceQualifier();

                    state._fsp--;

                    adaptor.addChild(root_0, instanceQualifier66.getTree());

                    }
                    break;

            }

            IDENT67=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeAssignment420); 
            IDENT67_tree = (CommonTree)adaptor.create(IDENT67);
            adaptor.addChild(root_0, IDENT67_tree);

            EQUALS68=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeAssignment422); 
            EQUALS68_tree = (CommonTree)adaptor.create(EQUALS68);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS68_tree, root_0);

            STRING69=(Token)match(input,STRING,FOLLOW_STRING_in_attributeAssignment425); 
            STRING69_tree = (CommonTree)adaptor.create(STRING69);
            adaptor.addChild(root_0, STRING69_tree);

            SEMICOLON70=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeAssignment427); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:270:1: instanceQualifier : ( IDENT | 'this' ) ( arrayList )? PERIOD ;
    public final PhdlParser.instanceQualifier_return instanceQualifier() throws RecognitionException {
        PhdlParser.instanceQualifier_return retval = new PhdlParser.instanceQualifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set71=null;
        Token PERIOD73=null;
        PhdlParser.arrayList_return arrayList72 = null;


        CommonTree set71_tree=null;
        CommonTree PERIOD73_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:278:2: ( ( IDENT | 'this' ) ( arrayList )? PERIOD )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:278:4: ( IDENT | 'this' ) ( arrayList )? PERIOD
            {
            root_0 = (CommonTree)adaptor.nil();

            set71=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||input.LA(1)==39 ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set71));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:278:21: ( arrayList )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==LEFTPAREN) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:278:21: arrayList
                    {
                    pushFollow(FOLLOW_arrayList_in_instanceQualifier450);
                    arrayList72=arrayList();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayList72.getTree());

                    }
                    break;

            }

            PERIOD73=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_instanceQualifier453); 
            PERIOD73_tree = (CommonTree)adaptor.create(PERIOD73);
            root_0 = (CommonTree)adaptor.becomeRoot(PERIOD73_tree, root_0);


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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:281:1: pinAssignment : ( instanceQualifier )? IDENT ( sliceList )? EQUALS concatenation SEMICOLON ;
    public final PhdlParser.pinAssignment_return pinAssignment() throws RecognitionException {
        PhdlParser.pinAssignment_return retval = new PhdlParser.pinAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT75=null;
        Token EQUALS77=null;
        Token SEMICOLON79=null;
        PhdlParser.instanceQualifier_return instanceQualifier74 = null;

        PhdlParser.sliceList_return sliceList76 = null;

        PhdlParser.concatenation_return concatenation78 = null;


        CommonTree IDENT75_tree=null;
        CommonTree EQUALS77_tree=null;
        CommonTree SEMICOLON79_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:289:2: ( ( instanceQualifier )? IDENT ( sliceList )? EQUALS concatenation SEMICOLON )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:289:4: ( instanceQualifier )? IDENT ( sliceList )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:289:4: ( instanceQualifier )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==IDENT) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==PERIOD||LA21_1==LEFTPAREN) ) {
                    alt21=1;
                }
            }
            else if ( (LA21_0==39) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:289:4: instanceQualifier
                    {
                    pushFollow(FOLLOW_instanceQualifier_in_pinAssignment469);
                    instanceQualifier74=instanceQualifier();

                    state._fsp--;

                    adaptor.addChild(root_0, instanceQualifier74.getTree());

                    }
                    break;

            }

            IDENT75=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinAssignment472); 
            IDENT75_tree = (CommonTree)adaptor.create(IDENT75);
            adaptor.addChild(root_0, IDENT75_tree);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:289:29: ( sliceList )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==LEFTBRACKET) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:289:29: sliceList
                    {
                    pushFollow(FOLLOW_sliceList_in_pinAssignment474);
                    sliceList76=sliceList();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceList76.getTree());

                    }
                    break;

            }

            EQUALS77=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinAssignment477); 
            EQUALS77_tree = (CommonTree)adaptor.create(EQUALS77);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS77_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_pinAssignment480);
            concatenation78=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation78.getTree());
            SEMICOLON79=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinAssignment482); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:292:1: netAssignment : IDENT ( sliceList )? EQUALS concatenation SEMICOLON ;
    public final PhdlParser.netAssignment_return netAssignment() throws RecognitionException {
        PhdlParser.netAssignment_return retval = new PhdlParser.netAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT80=null;
        Token EQUALS82=null;
        Token SEMICOLON84=null;
        PhdlParser.sliceList_return sliceList81 = null;

        PhdlParser.concatenation_return concatenation83 = null;


        CommonTree IDENT80_tree=null;
        CommonTree EQUALS82_tree=null;
        CommonTree SEMICOLON84_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:297:2: ( IDENT ( sliceList )? EQUALS concatenation SEMICOLON )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:297:4: IDENT ( sliceList )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT80=(Token)match(input,IDENT,FOLLOW_IDENT_in_netAssignment496); 
            IDENT80_tree = (CommonTree)adaptor.create(IDENT80);
            adaptor.addChild(root_0, IDENT80_tree);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:297:10: ( sliceList )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==LEFTBRACKET) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:297:10: sliceList
                    {
                    pushFollow(FOLLOW_sliceList_in_netAssignment498);
                    sliceList81=sliceList();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceList81.getTree());

                    }
                    break;

            }

            EQUALS82=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_netAssignment501); 
            EQUALS82_tree = (CommonTree)adaptor.create(EQUALS82);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS82_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_netAssignment504);
            concatenation83=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation83.getTree());
            SEMICOLON84=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netAssignment506); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:300:1: concatenation : ( ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* ) | ( LEFTANGLE IDENT ( sliceList )? RIGHTANGLE ) | 'open' );
    public final PhdlParser.concatenation_return concatenation() throws RecognitionException {
        PhdlParser.concatenation_return retval = new PhdlParser.concatenation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT85=null;
        Token AMPERSAND87=null;
        Token IDENT88=null;
        Token LEFTANGLE90=null;
        Token IDENT91=null;
        Token RIGHTANGLE93=null;
        Token string_literal94=null;
        PhdlParser.sliceList_return sliceList86 = null;

        PhdlParser.sliceList_return sliceList89 = null;

        PhdlParser.sliceList_return sliceList92 = null;


        CommonTree IDENT85_tree=null;
        CommonTree AMPERSAND87_tree=null;
        CommonTree IDENT88_tree=null;
        CommonTree LEFTANGLE90_tree=null;
        CommonTree IDENT91_tree=null;
        CommonTree RIGHTANGLE93_tree=null;
        CommonTree string_literal94_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:306:2: ( ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* ) | ( LEFTANGLE IDENT ( sliceList )? RIGHTANGLE ) | 'open' )
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
            case 40:
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
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:306:4: ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:306:4: ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* )
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:306:5: ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )*
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:306:5: ( IDENT ( sliceList )? )
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:306:6: IDENT ( sliceList )?
                    {
                    IDENT85=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation523); 
                    IDENT85_tree = (CommonTree)adaptor.create(IDENT85);
                    adaptor.addChild(root_0, IDENT85_tree);

                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:306:12: ( sliceList )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==LEFTBRACKET) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:306:12: sliceList
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation525);
                            sliceList86=sliceList();

                            state._fsp--;

                            adaptor.addChild(root_0, sliceList86.getTree());

                            }
                            break;

                    }


                    }

                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:306:24: ( AMPERSAND IDENT ( sliceList )? )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==AMPERSAND) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:306:25: AMPERSAND IDENT ( sliceList )?
                    	    {
                    	    AMPERSAND87=(Token)match(input,AMPERSAND,FOLLOW_AMPERSAND_in_concatenation530); 
                    	    IDENT88=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation533); 
                    	    IDENT88_tree = (CommonTree)adaptor.create(IDENT88);
                    	    adaptor.addChild(root_0, IDENT88_tree);

                    	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:306:42: ( sliceList )?
                    	    int alt25=2;
                    	    int LA25_0 = input.LA(1);

                    	    if ( (LA25_0==LEFTBRACKET) ) {
                    	        alt25=1;
                    	    }
                    	    switch (alt25) {
                    	        case 1 :
                    	            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:306:42: sliceList
                    	            {
                    	            pushFollow(FOLLOW_sliceList_in_concatenation535);
                    	            sliceList89=sliceList();

                    	            state._fsp--;

                    	            adaptor.addChild(root_0, sliceList89.getTree());

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
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:307:4: ( LEFTANGLE IDENT ( sliceList )? RIGHTANGLE )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:307:4: ( LEFTANGLE IDENT ( sliceList )? RIGHTANGLE )
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:307:5: LEFTANGLE IDENT ( sliceList )? RIGHTANGLE
                    {
                    LEFTANGLE90=(Token)match(input,LEFTANGLE,FOLLOW_LEFTANGLE_in_concatenation547); 
                    LEFTANGLE90_tree = (CommonTree)adaptor.create(LEFTANGLE90);
                    adaptor.addChild(root_0, LEFTANGLE90_tree);

                    IDENT91=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation549); 
                    IDENT91_tree = (CommonTree)adaptor.create(IDENT91);
                    adaptor.addChild(root_0, IDENT91_tree);

                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:307:21: ( sliceList )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==LEFTBRACKET) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:307:21: sliceList
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation551);
                            sliceList92=sliceList();

                            state._fsp--;

                            adaptor.addChild(root_0, sliceList92.getTree());

                            }
                            break;

                    }

                    RIGHTANGLE93=(Token)match(input,RIGHTANGLE,FOLLOW_RIGHTANGLE_in_concatenation554); 

                    }


                    }
                    break;
                case 3 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:308:5: 'open'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal94=(Token)match(input,40,FOLLOW_40_in_concatenation562); 
                    string_literal94_tree = (CommonTree)adaptor.create(string_literal94);
                    adaptor.addChild(root_0, string_literal94_tree);


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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:311:1: pinList : LEFTBRACE ( IDENT | INTEGER ) ( COMMA ( IDENT | INTEGER ) )* RIGHTBRACE ;
    public final PhdlParser.pinList_return pinList() throws RecognitionException {
        PhdlParser.pinList_return retval = new PhdlParser.pinList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTBRACE95=null;
        Token set96=null;
        Token COMMA97=null;
        Token set98=null;
        Token RIGHTBRACE99=null;

        CommonTree LEFTBRACE95_tree=null;
        CommonTree set96_tree=null;
        CommonTree COMMA97_tree=null;
        CommonTree set98_tree=null;
        CommonTree RIGHTBRACE99_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:316:2: ( LEFTBRACE ( IDENT | INTEGER ) ( COMMA ( IDENT | INTEGER ) )* RIGHTBRACE )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:316:5: LEFTBRACE ( IDENT | INTEGER ) ( COMMA ( IDENT | INTEGER ) )* RIGHTBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACE95=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_pinList577); 
            set96=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||input.LA(1)==INTEGER ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set96));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:316:34: ( COMMA ( IDENT | INTEGER ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==COMMA) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:316:35: COMMA ( IDENT | INTEGER )
            	    {
            	    COMMA97=(Token)match(input,COMMA,FOLLOW_COMMA_in_pinList589); 
            	    set98=(Token)input.LT(1);
            	    if ( input.LA(1)==IDENT||input.LA(1)==INTEGER ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (CommonTree)adaptor.create(set98));
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

            RIGHTBRACE99=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_pinList602); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:319:1: sliceList : LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTBRACKET ;
    public final PhdlParser.sliceList_return sliceList() throws RecognitionException {
        PhdlParser.sliceList_return retval = new PhdlParser.sliceList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTBRACKET100=null;
        Token INTEGER101=null;
        Token COLON102=null;
        Token INTEGER103=null;
        Token COMMA104=null;
        Token INTEGER105=null;
        Token COMMA106=null;
        Token INTEGER107=null;
        Token RIGHTBRACKET108=null;

        CommonTree LEFTBRACKET100_tree=null;
        CommonTree INTEGER101_tree=null;
        CommonTree COLON102_tree=null;
        CommonTree INTEGER103_tree=null;
        CommonTree COMMA104_tree=null;
        CommonTree INTEGER105_tree=null;
        CommonTree COMMA106_tree=null;
        CommonTree INTEGER107_tree=null;
        CommonTree RIGHTBRACKET108_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:325:2: ( LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTBRACKET )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:325:5: LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTBRACKET
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACKET100=(Token)match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList618); 
            LEFTBRACKET100_tree = (CommonTree)adaptor.create(LEFTBRACKET100);
            adaptor.addChild(root_0, LEFTBRACKET100_tree);

            INTEGER101=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList620); 
            INTEGER101_tree = (CommonTree)adaptor.create(INTEGER101);
            adaptor.addChild(root_0, INTEGER101_tree);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:325:25: ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? )
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
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:325:26: ( COLON INTEGER )
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:325:26: ( COLON INTEGER )
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:325:27: COLON INTEGER
                    {
                    COLON102=(Token)match(input,COLON,FOLLOW_COLON_in_sliceList624); 
                    COLON102_tree = (CommonTree)adaptor.create(COLON102);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON102_tree, root_0);

                    INTEGER103=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList627); 
                    INTEGER103_tree = (CommonTree)adaptor.create(INTEGER103);
                    adaptor.addChild(root_0, INTEGER103_tree);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:325:45: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:325:45: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==COMMA) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:325:46: COMMA INTEGER ( COMMA INTEGER )*
                            {
                            COMMA104=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceList633); 
                            COMMA104_tree = (CommonTree)adaptor.create(COMMA104);
                            root_0 = (CommonTree)adaptor.becomeRoot(COMMA104_tree, root_0);

                            INTEGER105=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList636); 
                            INTEGER105_tree = (CommonTree)adaptor.create(INTEGER105);
                            adaptor.addChild(root_0, INTEGER105_tree);

                            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:325:61: ( COMMA INTEGER )*
                            loop30:
                            do {
                                int alt30=2;
                                int LA30_0 = input.LA(1);

                                if ( (LA30_0==COMMA) ) {
                                    alt30=1;
                                }


                                switch (alt30) {
                            	case 1 :
                            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:325:62: COMMA INTEGER
                            	    {
                            	    COMMA106=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceList639); 
                            	    INTEGER107=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList642); 
                            	    INTEGER107_tree = (CommonTree)adaptor.create(INTEGER107);
                            	    adaptor.addChild(root_0, INTEGER107_tree);


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

            RIGHTBRACKET108=(Token)match(input,RIGHTBRACKET,FOLLOW_RIGHTBRACKET_in_sliceList649); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:328:1: sliceDecl : LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RIGHTBRACKET ;
    public final PhdlParser.sliceDecl_return sliceDecl() throws RecognitionException {
        PhdlParser.sliceDecl_return retval = new PhdlParser.sliceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTBRACKET109=null;
        Token INTEGER110=null;
        Token COLON111=null;
        Token INTEGER112=null;
        Token COMMA113=null;
        Token INTEGER114=null;
        Token RIGHTBRACKET115=null;

        CommonTree LEFTBRACKET109_tree=null;
        CommonTree INTEGER110_tree=null;
        CommonTree COLON111_tree=null;
        CommonTree INTEGER112_tree=null;
        CommonTree COMMA113_tree=null;
        CommonTree INTEGER114_tree=null;
        CommonTree RIGHTBRACKET115_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:333:2: ( LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RIGHTBRACKET )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:333:4: LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RIGHTBRACKET
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACKET109=(Token)match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceDecl663); 
            LEFTBRACKET109_tree = (CommonTree)adaptor.create(LEFTBRACKET109);
            adaptor.addChild(root_0, LEFTBRACKET109_tree);

            INTEGER110=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl665); 
            INTEGER110_tree = (CommonTree)adaptor.create(INTEGER110);
            adaptor.addChild(root_0, INTEGER110_tree);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:333:24: ( ( COLON INTEGER ) | ( COMMA INTEGER )+ )
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
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:333:25: ( COLON INTEGER )
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:333:25: ( COLON INTEGER )
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:333:26: COLON INTEGER
                    {
                    COLON111=(Token)match(input,COLON,FOLLOW_COLON_in_sliceDecl669); 
                    COLON111_tree = (CommonTree)adaptor.create(COLON111);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON111_tree, root_0);

                    INTEGER112=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl672); 
                    INTEGER112_tree = (CommonTree)adaptor.create(INTEGER112);
                    adaptor.addChild(root_0, INTEGER112_tree);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:333:44: ( COMMA INTEGER )+
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:333:44: ( COMMA INTEGER )+
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
                    	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:333:45: COMMA INTEGER
                    	    {
                    	    COMMA113=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceDecl678); 
                    	    COMMA113_tree = (CommonTree)adaptor.create(COMMA113);
                    	    root_0 = (CommonTree)adaptor.becomeRoot(COMMA113_tree, root_0);

                    	    INTEGER114=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl681); 
                    	    INTEGER114_tree = (CommonTree)adaptor.create(INTEGER114);
                    	    adaptor.addChild(root_0, INTEGER114_tree);


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

            RIGHTBRACKET115=(Token)match(input,RIGHTBRACKET,FOLLOW_RIGHTBRACKET_in_sliceDecl686); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:336:1: arrayList : LEFTPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTPAREN ;
    public final PhdlParser.arrayList_return arrayList() throws RecognitionException {
        PhdlParser.arrayList_return retval = new PhdlParser.arrayList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTPAREN116=null;
        Token INTEGER117=null;
        Token COLON118=null;
        Token INTEGER119=null;
        Token COMMA120=null;
        Token INTEGER121=null;
        Token COMMA122=null;
        Token INTEGER123=null;
        Token RIGHTPAREN124=null;

        CommonTree LEFTPAREN116_tree=null;
        CommonTree INTEGER117_tree=null;
        CommonTree COLON118_tree=null;
        CommonTree INTEGER119_tree=null;
        CommonTree COMMA120_tree=null;
        CommonTree INTEGER121_tree=null;
        CommonTree COMMA122_tree=null;
        CommonTree INTEGER123_tree=null;
        CommonTree RIGHTPAREN124_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:341:2: ( LEFTPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTPAREN )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:341:5: LEFTPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTPAREN116=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList702); 
            LEFTPAREN116_tree = (CommonTree)adaptor.create(LEFTPAREN116);
            adaptor.addChild(root_0, LEFTPAREN116_tree);

            INTEGER117=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList704); 
            INTEGER117_tree = (CommonTree)adaptor.create(INTEGER117);
            adaptor.addChild(root_0, INTEGER117_tree);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:341:23: ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? )
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
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:341:24: ( COLON INTEGER )
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:341:24: ( COLON INTEGER )
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:341:25: COLON INTEGER
                    {
                    COLON118=(Token)match(input,COLON,FOLLOW_COLON_in_arrayList708); 
                    COLON118_tree = (CommonTree)adaptor.create(COLON118);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON118_tree, root_0);

                    INTEGER119=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList711); 
                    INTEGER119_tree = (CommonTree)adaptor.create(INTEGER119);
                    adaptor.addChild(root_0, INTEGER119_tree);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:341:43: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:341:43: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==COMMA) ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:341:44: COMMA INTEGER ( COMMA INTEGER )*
                            {
                            COMMA120=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayList717); 
                            COMMA120_tree = (CommonTree)adaptor.create(COMMA120);
                            root_0 = (CommonTree)adaptor.becomeRoot(COMMA120_tree, root_0);

                            INTEGER121=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList720); 
                            INTEGER121_tree = (CommonTree)adaptor.create(INTEGER121);
                            adaptor.addChild(root_0, INTEGER121_tree);

                            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:341:59: ( COMMA INTEGER )*
                            loop35:
                            do {
                                int alt35=2;
                                int LA35_0 = input.LA(1);

                                if ( (LA35_0==COMMA) ) {
                                    alt35=1;
                                }


                                switch (alt35) {
                            	case 1 :
                            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:341:60: COMMA INTEGER
                            	    {
                            	    COMMA122=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayList723); 
                            	    INTEGER123=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList726); 
                            	    INTEGER123_tree = (CommonTree)adaptor.create(INTEGER123);
                            	    adaptor.addChild(root_0, INTEGER123_tree);


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

            RIGHTPAREN124=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_arrayList733); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:344:1: arrayDecl : LEFTPAREN INTEGER COLON INTEGER RIGHTPAREN ;
    public final PhdlParser.arrayDecl_return arrayDecl() throws RecognitionException {
        PhdlParser.arrayDecl_return retval = new PhdlParser.arrayDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTPAREN125=null;
        Token INTEGER126=null;
        Token COLON127=null;
        Token INTEGER128=null;
        Token RIGHTPAREN129=null;

        CommonTree LEFTPAREN125_tree=null;
        CommonTree INTEGER126_tree=null;
        CommonTree COLON127_tree=null;
        CommonTree INTEGER128_tree=null;
        CommonTree RIGHTPAREN129_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:349:2: ( LEFTPAREN INTEGER COLON INTEGER RIGHTPAREN )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:349:4: LEFTPAREN INTEGER COLON INTEGER RIGHTPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTPAREN125=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayDecl747); 
            LEFTPAREN125_tree = (CommonTree)adaptor.create(LEFTPAREN125);
            adaptor.addChild(root_0, LEFTPAREN125_tree);

            INTEGER126=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayDecl749); 
            INTEGER126_tree = (CommonTree)adaptor.create(INTEGER126);
            adaptor.addChild(root_0, INTEGER126_tree);

            COLON127=(Token)match(input,COLON,FOLLOW_COLON_in_arrayDecl751); 
            COLON127_tree = (CommonTree)adaptor.create(COLON127);
            root_0 = (CommonTree)adaptor.becomeRoot(COLON127_tree, root_0);

            INTEGER128=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayDecl754); 
            INTEGER128_tree = (CommonTree)adaptor.create(INTEGER128);
            adaptor.addChild(root_0, INTEGER128_tree);

            RIGHTPAREN129=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_arrayDecl756); 

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
        "\23\uffff";
    static final String DFA15_eofS =
        "\23\uffff";
    static final String DFA15_minS =
        "\1\4\2\uffff\1\6\1\11\1\uffff\1\4\1\16\1\4\1\uffff\1\10\1\6\2\16"+
        "\1\11\1\24\1\10\1\16\1\10";
    static final String DFA15_maxS =
        "\1\47\2\uffff\2\23\1\uffff\1\50\1\16\1\4\1\uffff\1\24\1\20\2\16"+
        "\1\11\2\24\1\16\1\24";
    static final String DFA15_acceptS =
        "\1\uffff\1\4\1\1\2\uffff\1\3\3\uffff\1\2\11\uffff";
    static final String DFA15_specialS =
        "\23\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\3\31\uffff\1\1\6\uffff\1\5\1\2\1\4",
            "",
            "",
            "\1\6\2\uffff\1\10\6\uffff\1\11\2\uffff\1\7",
            "\1\10\11\uffff\1\7",
            "",
            "\1\11\2\uffff\1\2\3\uffff\1\11\34\uffff\1\11",
            "\1\12",
            "\1\13",
            "",
            "\1\15\10\uffff\1\14\2\uffff\1\16",
            "\1\6\11\uffff\1\11",
            "\1\17",
            "\1\20",
            "\1\10",
            "\1\16",
            "\1\21\13\uffff\1\16",
            "\1\22",
            "\1\21\13\uffff\1\16"
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
            return "()* loopback of 244:3: ( attributeAssignment | pinAssignment | infoStruct )*";
        }
    }
 

    public static final BitSet FOLLOW_designDecl_in_sourceText79 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_EOF_in_sourceText82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_designDecl95 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_designDecl98 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_designDecl100 = new BitSet(new long[]{0x00000024A0000000L});
    public static final BitSet FOLLOW_deviceDecl_in_designDecl107 = new BitSet(new long[]{0x00000024A0000000L});
    public static final BitSet FOLLOW_netDecl_in_designDecl111 = new BitSet(new long[]{0x00000024A0000000L});
    public static final BitSet FOLLOW_infoStruct_in_designDecl115 = new BitSet(new long[]{0x00000024A0000000L});
    public static final BitSet FOLLOW_29_in_designDecl121 = new BitSet(new long[]{0x0000000840000010L});
    public static final BitSet FOLLOW_instanceDecl_in_designDecl126 = new BitSet(new long[]{0x0000000840000010L});
    public static final BitSet FOLLOW_netAssignment_in_designDecl130 = new BitSet(new long[]{0x0000000840000010L});
    public static final BitSet FOLLOW_30_in_designDecl136 = new BitSet(new long[]{0x0000000008000030L});
    public static final BitSet FOLLOW_27_in_designDecl139 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_IDENT_in_designDecl143 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_designDecl146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_deviceDecl161 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl164 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_deviceDecl166 = new BitSet(new long[]{0x0000000340000000L});
    public static final BitSet FOLLOW_attributeDecl_in_deviceDecl173 = new BitSet(new long[]{0x0000000340000000L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl177 = new BitSet(new long[]{0x0000000340000000L});
    public static final BitSet FOLLOW_30_in_deviceDecl184 = new BitSet(new long[]{0x0000000080000030L});
    public static final BitSet FOLLOW_31_in_deviceDecl187 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl191 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_deviceDecl194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_attributeDecl209 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attributeDecl212 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_attributeDecl214 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_in_attributeDecl217 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeDecl219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_pinDecl233 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_sliceDecl_in_pinDecl236 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl239 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_pinDecl241 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_pinList_in_pinDecl244 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinDecl246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_type261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_netDecl274 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_sliceDecl_in_netDecl277 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl280 = new BitSet(new long[]{0x0000000010000120L});
    public static final BitSet FOLLOW_COMMA_in_netDecl283 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl285 = new BitSet(new long[]{0x0000000010000120L});
    public static final BitSet FOLLOW_netAttributes_in_netDecl289 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_netDecl292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_netAttributes307 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_attributeDecl_in_netAttributes310 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_30_in_netAttributes313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_instanceDecl327 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_arrayDecl_in_instanceDecl330 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instanceDecl333 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_instanceDecl335 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instanceDecl338 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_instanceDecl340 = new BitSet(new long[]{0x000000E4C0000010L});
    public static final BitSet FOLLOW_attributeAssignment_in_instanceDecl346 = new BitSet(new long[]{0x000000E4C0000010L});
    public static final BitSet FOLLOW_pinAssignment_in_instanceDecl350 = new BitSet(new long[]{0x000000E4C0000010L});
    public static final BitSet FOLLOW_infoStruct_in_instanceDecl354 = new BitSet(new long[]{0x000000E4C0000010L});
    public static final BitSet FOLLOW_30_in_instanceDecl360 = new BitSet(new long[]{0x0000000800000030L});
    public static final BitSet FOLLOW_35_in_instanceDecl363 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_IDENT_in_instanceDecl367 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_instanceDecl370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_infoStruct385 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LEFTBRACE_in_infoStruct388 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_in_infoStruct391 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_infoStruct393 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_infoStruct396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_attributeAssignment413 = new BitSet(new long[]{0x0000008000000010L});
    public static final BitSet FOLLOW_instanceQualifier_in_attributeAssignment417 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attributeAssignment420 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_attributeAssignment422 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_in_attributeAssignment425 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeAssignment427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_instanceQualifier442 = new BitSet(new long[]{0x0000000000080200L});
    public static final BitSet FOLLOW_arrayList_in_instanceQualifier450 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_PERIOD_in_instanceQualifier453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instanceQualifier_in_pinAssignment469 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinAssignment472 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_sliceList_in_pinAssignment474 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssignment477 = new BitSet(new long[]{0x0000010000000810L});
    public static final BitSet FOLLOW_concatenation_in_pinAssignment480 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinAssignment482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_netAssignment496 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_sliceList_in_netAssignment498 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_netAssignment501 = new BitSet(new long[]{0x0000010000000810L});
    public static final BitSet FOLLOW_concatenation_in_netAssignment504 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_netAssignment506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_concatenation523 = new BitSet(new long[]{0x0000000000010402L});
    public static final BitSet FOLLOW_sliceList_in_concatenation525 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_AMPERSAND_in_concatenation530 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation533 = new BitSet(new long[]{0x0000000000010402L});
    public static final BitSet FOLLOW_sliceList_in_concatenation535 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_LEFTANGLE_in_concatenation547 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation549 = new BitSet(new long[]{0x0000000000011000L});
    public static final BitSet FOLLOW_sliceList_in_concatenation551 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RIGHTANGLE_in_concatenation554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_concatenation562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACE_in_pinList577 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_set_in_pinList580 = new BitSet(new long[]{0x0000000000008100L});
    public static final BitSet FOLLOW_COMMA_in_pinList589 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_set_in_pinList592 = new BitSet(new long[]{0x0000000000008100L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_pinList602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList618 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList620 = new BitSet(new long[]{0x0000000000060100L});
    public static final BitSet FOLLOW_COLON_in_sliceList624 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList627 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_sliceList633 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList636 = new BitSet(new long[]{0x0000000000040100L});
    public static final BitSet FOLLOW_COMMA_in_sliceList639 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList642 = new BitSet(new long[]{0x0000000000040100L});
    public static final BitSet FOLLOW_RIGHTBRACKET_in_sliceList649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceDecl663 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl665 = new BitSet(new long[]{0x0000000000020100L});
    public static final BitSet FOLLOW_COLON_in_sliceDecl669 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl672 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_sliceDecl678 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl681 = new BitSet(new long[]{0x0000000000040100L});
    public static final BitSet FOLLOW_RIGHTBRACKET_in_sliceDecl686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList702 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList704 = new BitSet(new long[]{0x0000000000120100L});
    public static final BitSet FOLLOW_COLON_in_arrayList708 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList711 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_arrayList717 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList720 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_COMMA_in_arrayList723 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList726 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_RIGHTPAREN_in_arrayList733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayDecl747 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayDecl749 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_arrayDecl751 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayDecl754 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RIGHTPAREN_in_arrayDecl756 = new BitSet(new long[]{0x0000000000000002L});

}