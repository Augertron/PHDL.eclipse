// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g 2011-08-24 10:37:29

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "SEMICOLON", "EQUALS", "STRING", "COMMA", "PERIOD", "AMPERSAND", "LEFTANGLE", "RIGHTANGLE", "LEFTBRACE", "INTEGER", "RIGHTBRACE", "LEFTBRACKET", "COLON", "RIGHTBRACKET", "LEFTPAREN", "RIGHTPAREN", "CHAR", "DIGIT", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "INCLUDE", "'design'", "'is'", "'begin'", "'end'", "'device'", "'attr'", "'pin'", "'net'", "'inst'", "'of'", "'info'", "'group'", "'newattr'", "'each'", "'combine'", "'open'"
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
    public static final int T__41=41;
    public static final int T__42=42;
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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:167:1: designDecl : 'design' IDENT 'is' ( deviceDecl | netDecl | infoStruct )* 'begin' ( instanceDecl | netAssignment | groupStruct )* 'end' ( 'design' )? ( IDENT )? SEMICOLON ;
    public final PhdlParser.designDecl_return designDecl() throws RecognitionException {
        PhdlParser.designDecl_return retval = new PhdlParser.designDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal3=null;
        Token IDENT4=null;
        Token string_literal5=null;
        Token string_literal9=null;
        Token string_literal13=null;
        Token string_literal14=null;
        Token IDENT15=null;
        Token SEMICOLON16=null;
        PhdlParser.deviceDecl_return deviceDecl6 = null;

        PhdlParser.netDecl_return netDecl7 = null;

        PhdlParser.infoStruct_return infoStruct8 = null;

        PhdlParser.instanceDecl_return instanceDecl10 = null;

        PhdlParser.netAssignment_return netAssignment11 = null;

        PhdlParser.groupStruct_return groupStruct12 = null;


        CommonTree string_literal3_tree=null;
        CommonTree IDENT4_tree=null;
        CommonTree string_literal5_tree=null;
        CommonTree string_literal9_tree=null;
        CommonTree string_literal13_tree=null;
        CommonTree string_literal14_tree=null;
        CommonTree IDENT15_tree=null;
        CommonTree SEMICOLON16_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:175:2: ( 'design' IDENT 'is' ( deviceDecl | netDecl | infoStruct )* 'begin' ( instanceDecl | netAssignment | groupStruct )* 'end' ( 'design' )? ( IDENT )? SEMICOLON )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:175:4: 'design' IDENT 'is' ( deviceDecl | netDecl | infoStruct )* 'begin' ( instanceDecl | netAssignment | groupStruct )* 'end' ( 'design' )? ( IDENT )? SEMICOLON
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

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:178:3: ( instanceDecl | netAssignment | groupStruct )*
            loop3:
            do {
                int alt3=4;
                switch ( input.LA(1) ) {
                case 35:
                    {
                    alt3=1;
                    }
                    break;
                case IDENT:
                    {
                    alt3=2;
                    }
                    break;
                case 38:
                    {
                    alt3=3;
                    }
                    break;

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
            	case 3 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:178:35: groupStruct
            	    {
            	    pushFollow(FOLLOW_groupStruct_in_designDecl134);
            	    groupStruct12=groupStruct();

            	    state._fsp--;

            	    adaptor.addChild(root_0, groupStruct12.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            string_literal13=(Token)match(input,30,FOLLOW_30_in_designDecl140); 
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
                    string_literal14=(Token)match(input,27,FOLLOW_27_in_designDecl143); 

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
                    IDENT15=(Token)match(input,IDENT,FOLLOW_IDENT_in_designDecl147); 
                    IDENT15_tree = (CommonTree)adaptor.create(IDENT15);
                    adaptor.addChild(root_0, IDENT15_tree);


                    }
                    break;

            }

            SEMICOLON16=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_designDecl150); 

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

        Token string_literal17=null;
        Token IDENT18=null;
        Token string_literal19=null;
        Token string_literal22=null;
        Token string_literal23=null;
        Token IDENT24=null;
        Token SEMICOLON25=null;
        PhdlParser.attributeDecl_return attributeDecl20 = null;

        PhdlParser.pinDecl_return pinDecl21 = null;


        CommonTree string_literal17_tree=null;
        CommonTree IDENT18_tree=null;
        CommonTree string_literal19_tree=null;
        CommonTree string_literal22_tree=null;
        CommonTree string_literal23_tree=null;
        CommonTree IDENT24_tree=null;
        CommonTree SEMICOLON25_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:189:2: ( 'device' IDENT 'is' ( attributeDecl | pinDecl )* 'end' ( 'device' )? ( IDENT )? SEMICOLON )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:189:4: 'device' IDENT 'is' ( attributeDecl | pinDecl )* 'end' ( 'device' )? ( IDENT )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal17=(Token)match(input,31,FOLLOW_31_in_deviceDecl165); 
            string_literal17_tree = (CommonTree)adaptor.create(string_literal17);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal17_tree, root_0);

            IDENT18=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl168); 
            IDENT18_tree = (CommonTree)adaptor.create(IDENT18);
            adaptor.addChild(root_0, IDENT18_tree);

            string_literal19=(Token)match(input,28,FOLLOW_28_in_deviceDecl170); 
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
            	    pushFollow(FOLLOW_attributeDecl_in_deviceDecl177);
            	    attributeDecl20=attributeDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeDecl20.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:190:21: pinDecl
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl181);
            	    pinDecl21=pinDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinDecl21.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            string_literal22=(Token)match(input,30,FOLLOW_30_in_deviceDecl188); 
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
                    string_literal23=(Token)match(input,31,FOLLOW_31_in_deviceDecl191); 

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
                    IDENT24=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl195); 
                    IDENT24_tree = (CommonTree)adaptor.create(IDENT24);
                    adaptor.addChild(root_0, IDENT24_tree);


                    }
                    break;

            }

            SEMICOLON25=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_deviceDecl198); 

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

        Token string_literal26=null;
        Token IDENT27=null;
        Token EQUALS28=null;
        Token STRING29=null;
        Token SEMICOLON30=null;

        CommonTree string_literal26_tree=null;
        CommonTree IDENT27_tree=null;
        CommonTree EQUALS28_tree=null;
        CommonTree STRING29_tree=null;
        CommonTree SEMICOLON30_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:199:2: ( 'attr' IDENT EQUALS STRING SEMICOLON )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:199:4: 'attr' IDENT EQUALS STRING SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal26=(Token)match(input,32,FOLLOW_32_in_attributeDecl213); 
            string_literal26_tree = (CommonTree)adaptor.create(string_literal26);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal26_tree, root_0);

            IDENT27=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeDecl216); 
            IDENT27_tree = (CommonTree)adaptor.create(IDENT27);
            adaptor.addChild(root_0, IDENT27_tree);

            EQUALS28=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeDecl218); 
            STRING29=(Token)match(input,STRING,FOLLOW_STRING_in_attributeDecl221); 
            STRING29_tree = (CommonTree)adaptor.create(STRING29);
            adaptor.addChild(root_0, STRING29_tree);

            SEMICOLON30=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeDecl223); 

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

        Token IDENT33=null;
        Token EQUALS34=null;
        Token SEMICOLON36=null;
        PhdlParser.type_return type31 = null;

        PhdlParser.sliceDecl_return sliceDecl32 = null;

        PhdlParser.pinList_return pinList35 = null;


        CommonTree IDENT33_tree=null;
        CommonTree EQUALS34_tree=null;
        CommonTree SEMICOLON36_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:207:2: ( type ( sliceDecl )? IDENT EQUALS pinList SEMICOLON )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:207:4: type ( sliceDecl )? IDENT EQUALS pinList SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_type_in_pinDecl237);
            type31=type();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(type31.getTree(), root_0);
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
                    pushFollow(FOLLOW_sliceDecl_in_pinDecl240);
                    sliceDecl32=sliceDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceDecl32.getTree());

                    }
                    break;

            }

            IDENT33=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinDecl243); 
            IDENT33_tree = (CommonTree)adaptor.create(IDENT33);
            adaptor.addChild(root_0, IDENT33_tree);

            EQUALS34=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinDecl245); 
            pushFollow(FOLLOW_pinList_in_pinDecl248);
            pinList35=pinList();

            state._fsp--;

            adaptor.addChild(root_0, pinList35.getTree());
            SEMICOLON36=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinDecl250); 

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

        Token string_literal37=null;

        CommonTree string_literal37_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:214:2: ( 'pin' )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:214:4: 'pin'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal37=(Token)match(input,33,FOLLOW_33_in_type265); 
            string_literal37_tree = (CommonTree)adaptor.create(string_literal37);
            adaptor.addChild(root_0, string_literal37_tree);


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

        Token string_literal38=null;
        Token IDENT40=null;
        Token COMMA41=null;
        Token IDENT42=null;
        Token SEMICOLON44=null;
        PhdlParser.sliceDecl_return sliceDecl39 = null;

        PhdlParser.netAttributes_return netAttributes43 = null;


        CommonTree string_literal38_tree=null;
        CommonTree IDENT40_tree=null;
        CommonTree COMMA41_tree=null;
        CommonTree IDENT42_tree=null;
        CommonTree SEMICOLON44_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:222:2: ( 'net' ( sliceDecl )? IDENT ( COMMA IDENT )* ( netAttributes )? SEMICOLON )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:222:4: 'net' ( sliceDecl )? IDENT ( COMMA IDENT )* ( netAttributes )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal38=(Token)match(input,34,FOLLOW_34_in_netDecl278); 
            string_literal38_tree = (CommonTree)adaptor.create(string_literal38);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal38_tree, root_0);

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
                    pushFollow(FOLLOW_sliceDecl_in_netDecl281);
                    sliceDecl39=sliceDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceDecl39.getTree());

                    }
                    break;

            }

            IDENT40=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl284); 
            IDENT40_tree = (CommonTree)adaptor.create(IDENT40);
            adaptor.addChild(root_0, IDENT40_tree);

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
            	    COMMA41=(Token)match(input,COMMA,FOLLOW_COMMA_in_netDecl287); 
            	    COMMA41_tree = (CommonTree)adaptor.create(COMMA41);
            	    adaptor.addChild(root_0, COMMA41_tree);

            	    IDENT42=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl289); 
            	    IDENT42_tree = (CommonTree)adaptor.create(IDENT42);
            	    adaptor.addChild(root_0, IDENT42_tree);


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
                    pushFollow(FOLLOW_netAttributes_in_netDecl293);
                    netAttributes43=netAttributes();

                    state._fsp--;

                    adaptor.addChild(root_0, netAttributes43.getTree());

                    }
                    break;

            }

            SEMICOLON44=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netDecl296); 

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

        Token string_literal45=null;
        Token string_literal47=null;
        PhdlParser.attributeDecl_return attributeDecl46 = null;


        CommonTree string_literal45_tree=null;
        CommonTree string_literal47_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:231:2: ( 'is' ( attributeDecl )* 'end' )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:231:4: 'is' ( attributeDecl )* 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal45=(Token)match(input,28,FOLLOW_28_in_netAttributes311); 
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
            	    pushFollow(FOLLOW_attributeDecl_in_netAttributes314);
            	    attributeDecl46=attributeDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeDecl46.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            string_literal47=(Token)match(input,30,FOLLOW_30_in_netAttributes317); 

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

        Token string_literal48=null;
        Token IDENT50=null;
        Token string_literal51=null;
        Token IDENT52=null;
        Token string_literal53=null;
        Token string_literal57=null;
        Token string_literal58=null;
        Token IDENT59=null;
        Token SEMICOLON60=null;
        PhdlParser.arrayDecl_return arrayDecl49 = null;

        PhdlParser.attributeAssignment_return attributeAssignment54 = null;

        PhdlParser.pinAssignment_return pinAssignment55 = null;

        PhdlParser.infoStruct_return infoStruct56 = null;


        CommonTree string_literal48_tree=null;
        CommonTree IDENT50_tree=null;
        CommonTree string_literal51_tree=null;
        CommonTree IDENT52_tree=null;
        CommonTree string_literal53_tree=null;
        CommonTree string_literal57_tree=null;
        CommonTree string_literal58_tree=null;
        CommonTree IDENT59_tree=null;
        CommonTree SEMICOLON60_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:243:2: ( 'inst' ( arrayDecl )? IDENT 'of' IDENT 'is' ( attributeAssignment | pinAssignment | infoStruct )* 'end' ( 'inst' )? ( IDENT )? SEMICOLON )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:243:4: 'inst' ( arrayDecl )? IDENT 'of' IDENT 'is' ( attributeAssignment | pinAssignment | infoStruct )* 'end' ( 'inst' )? ( IDENT )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal48=(Token)match(input,35,FOLLOW_35_in_instanceDecl331); 
            string_literal48_tree = (CommonTree)adaptor.create(string_literal48);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal48_tree, root_0);

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
                    pushFollow(FOLLOW_arrayDecl_in_instanceDecl334);
                    arrayDecl49=arrayDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayDecl49.getTree());

                    }
                    break;

            }

            IDENT50=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceDecl337); 
            IDENT50_tree = (CommonTree)adaptor.create(IDENT50);
            adaptor.addChild(root_0, IDENT50_tree);

            string_literal51=(Token)match(input,36,FOLLOW_36_in_instanceDecl339); 
            IDENT52=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceDecl342); 
            IDENT52_tree = (CommonTree)adaptor.create(IDENT52);
            adaptor.addChild(root_0, IDENT52_tree);

            string_literal53=(Token)match(input,28,FOLLOW_28_in_instanceDecl344); 
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:244:3: ( attributeAssignment | pinAssignment | infoStruct )*
            loop15:
            do {
                int alt15=4;
                alt15 = dfa15.predict(input);
                switch (alt15) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:244:4: attributeAssignment
            	    {
            	    pushFollow(FOLLOW_attributeAssignment_in_instanceDecl350);
            	    attributeAssignment54=attributeAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeAssignment54.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:244:26: pinAssignment
            	    {
            	    pushFollow(FOLLOW_pinAssignment_in_instanceDecl354);
            	    pinAssignment55=pinAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinAssignment55.getTree());

            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:244:42: infoStruct
            	    {
            	    pushFollow(FOLLOW_infoStruct_in_instanceDecl358);
            	    infoStruct56=infoStruct();

            	    state._fsp--;

            	    adaptor.addChild(root_0, infoStruct56.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            string_literal57=(Token)match(input,30,FOLLOW_30_in_instanceDecl364); 
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
                    string_literal58=(Token)match(input,35,FOLLOW_35_in_instanceDecl367); 

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
                    IDENT59=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceDecl371); 
                    IDENT59_tree = (CommonTree)adaptor.create(IDENT59);
                    adaptor.addChild(root_0, IDENT59_tree);


                    }
                    break;

            }

            SEMICOLON60=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_instanceDecl374); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:248:1: infoStruct : 'info' 'is' STRING SEMICOLON ;
    public final PhdlParser.infoStruct_return infoStruct() throws RecognitionException {
        PhdlParser.infoStruct_return retval = new PhdlParser.infoStruct_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal61=null;
        Token string_literal62=null;
        Token STRING63=null;
        Token SEMICOLON64=null;

        CommonTree string_literal61_tree=null;
        CommonTree string_literal62_tree=null;
        CommonTree STRING63_tree=null;
        CommonTree SEMICOLON64_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:253:2: ( 'info' 'is' STRING SEMICOLON )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:253:5: 'info' 'is' STRING SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal61=(Token)match(input,37,FOLLOW_37_in_infoStruct389); 
            string_literal61_tree = (CommonTree)adaptor.create(string_literal61);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal61_tree, root_0);

            string_literal62=(Token)match(input,28,FOLLOW_28_in_infoStruct392); 
            STRING63=(Token)match(input,STRING,FOLLOW_STRING_in_infoStruct395); 
            STRING63_tree = (CommonTree)adaptor.create(STRING63);
            adaptor.addChild(root_0, STRING63_tree);

            SEMICOLON64=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_infoStruct397); 

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

    public static class groupStruct_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "groupStruct"
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:256:1: groupStruct : 'group' STRING 'is' ( instanceDecl | netAssignment )* 'end' ( 'group' )? ( STRING )? SEMICOLON ;
    public final PhdlParser.groupStruct_return groupStruct() throws RecognitionException {
        PhdlParser.groupStruct_return retval = new PhdlParser.groupStruct_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal65=null;
        Token STRING66=null;
        Token string_literal67=null;
        Token string_literal70=null;
        Token string_literal71=null;
        Token STRING72=null;
        Token SEMICOLON73=null;
        PhdlParser.instanceDecl_return instanceDecl68 = null;

        PhdlParser.netAssignment_return netAssignment69 = null;


        CommonTree string_literal65_tree=null;
        CommonTree STRING66_tree=null;
        CommonTree string_literal67_tree=null;
        CommonTree string_literal70_tree=null;
        CommonTree string_literal71_tree=null;
        CommonTree STRING72_tree=null;
        CommonTree SEMICOLON73_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:257:2: ( 'group' STRING 'is' ( instanceDecl | netAssignment )* 'end' ( 'group' )? ( STRING )? SEMICOLON )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:257:5: 'group' STRING 'is' ( instanceDecl | netAssignment )* 'end' ( 'group' )? ( STRING )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal65=(Token)match(input,38,FOLLOW_38_in_groupStruct412); 
            string_literal65_tree = (CommonTree)adaptor.create(string_literal65);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal65_tree, root_0);

            STRING66=(Token)match(input,STRING,FOLLOW_STRING_in_groupStruct415); 
            STRING66_tree = (CommonTree)adaptor.create(STRING66);
            adaptor.addChild(root_0, STRING66_tree);

            string_literal67=(Token)match(input,28,FOLLOW_28_in_groupStruct417); 
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:257:27: ( instanceDecl | netAssignment )*
            loop18:
            do {
                int alt18=3;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==35) ) {
                    alt18=1;
                }
                else if ( (LA18_0==IDENT) ) {
                    alt18=2;
                }


                switch (alt18) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:257:28: instanceDecl
            	    {
            	    pushFollow(FOLLOW_instanceDecl_in_groupStruct421);
            	    instanceDecl68=instanceDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, instanceDecl68.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:257:43: netAssignment
            	    {
            	    pushFollow(FOLLOW_netAssignment_in_groupStruct425);
            	    netAssignment69=netAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netAssignment69.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            string_literal70=(Token)match(input,30,FOLLOW_30_in_groupStruct429); 
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:257:73: ( 'group' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==38) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:257:73: 'group'
                    {
                    string_literal71=(Token)match(input,38,FOLLOW_38_in_groupStruct432); 

                    }
                    break;

            }

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:257:76: ( STRING )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==STRING) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:257:76: STRING
                    {
                    STRING72=(Token)match(input,STRING,FOLLOW_STRING_in_groupStruct436); 
                    STRING72_tree = (CommonTree)adaptor.create(STRING72);
                    adaptor.addChild(root_0, STRING72_tree);


                    }
                    break;

            }

            SEMICOLON73=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_groupStruct439); 

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
    // $ANTLR end "groupStruct"

    public static class attributeAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributeAssignment"
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:260:1: attributeAssignment : ( 'newattr' )? ( attributeQualifier )? IDENT EQUALS STRING SEMICOLON ;
    public final PhdlParser.attributeAssignment_return attributeAssignment() throws RecognitionException {
        PhdlParser.attributeAssignment_return retval = new PhdlParser.attributeAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal74=null;
        Token IDENT76=null;
        Token EQUALS77=null;
        Token STRING78=null;
        Token SEMICOLON79=null;
        PhdlParser.attributeQualifier_return attributeQualifier75 = null;


        CommonTree string_literal74_tree=null;
        CommonTree IDENT76_tree=null;
        CommonTree EQUALS77_tree=null;
        CommonTree STRING78_tree=null;
        CommonTree SEMICOLON79_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:271:2: ( ( 'newattr' )? ( attributeQualifier )? IDENT EQUALS STRING SEMICOLON )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:271:4: ( 'newattr' )? ( attributeQualifier )? IDENT EQUALS STRING SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:271:4: ( 'newattr' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==39) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:271:5: 'newattr'
                    {
                    string_literal74=(Token)match(input,39,FOLLOW_39_in_attributeAssignment454); 
                    string_literal74_tree = (CommonTree)adaptor.create(string_literal74);
                    adaptor.addChild(root_0, string_literal74_tree);


                    }
                    break;

            }

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:271:17: ( attributeQualifier )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==40) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:271:17: attributeQualifier
                    {
                    pushFollow(FOLLOW_attributeQualifier_in_attributeAssignment458);
                    attributeQualifier75=attributeQualifier();

                    state._fsp--;

                    adaptor.addChild(root_0, attributeQualifier75.getTree());

                    }
                    break;

            }

            IDENT76=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeAssignment461); 
            IDENT76_tree = (CommonTree)adaptor.create(IDENT76);
            adaptor.addChild(root_0, IDENT76_tree);

            EQUALS77=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeAssignment463); 
            EQUALS77_tree = (CommonTree)adaptor.create(EQUALS77);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS77_tree, root_0);

            STRING78=(Token)match(input,STRING,FOLLOW_STRING_in_attributeAssignment466); 
            STRING78_tree = (CommonTree)adaptor.create(STRING78);
            adaptor.addChild(root_0, STRING78_tree);

            SEMICOLON79=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeAssignment468); 

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

    public static class attributeQualifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributeQualifier"
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:274:1: attributeQualifier : 'each' ( arrayList )? PERIOD ;
    public final PhdlParser.attributeQualifier_return attributeQualifier() throws RecognitionException {
        PhdlParser.attributeQualifier_return retval = new PhdlParser.attributeQualifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal80=null;
        Token PERIOD82=null;
        PhdlParser.arrayList_return arrayList81 = null;


        CommonTree string_literal80_tree=null;
        CommonTree PERIOD82_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:280:2: ( 'each' ( arrayList )? PERIOD )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:280:4: 'each' ( arrayList )? PERIOD
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal80=(Token)match(input,40,FOLLOW_40_in_attributeQualifier483); 
            string_literal80_tree = (CommonTree)adaptor.create(string_literal80);
            adaptor.addChild(root_0, string_literal80_tree);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:280:11: ( arrayList )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==LEFTPAREN) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:280:11: arrayList
                    {
                    pushFollow(FOLLOW_arrayList_in_attributeQualifier485);
                    arrayList81=arrayList();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayList81.getTree());

                    }
                    break;

            }

            PERIOD82=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_attributeQualifier488); 
            PERIOD82_tree = (CommonTree)adaptor.create(PERIOD82);
            root_0 = (CommonTree)adaptor.becomeRoot(PERIOD82_tree, root_0);


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
    // $ANTLR end "attributeQualifier"

    public static class pinQualifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pinQualifier"
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:283:1: pinQualifier : ( 'each' | 'combine' ) ( arrayList )? PERIOD ;
    public final PhdlParser.pinQualifier_return pinQualifier() throws RecognitionException {
        PhdlParser.pinQualifier_return retval = new PhdlParser.pinQualifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set83=null;
        Token PERIOD85=null;
        PhdlParser.arrayList_return arrayList84 = null;


        CommonTree set83_tree=null;
        CommonTree PERIOD85_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:289:2: ( ( 'each' | 'combine' ) ( arrayList )? PERIOD )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:289:4: ( 'each' | 'combine' ) ( arrayList )? PERIOD
            {
            root_0 = (CommonTree)adaptor.nil();

            set83=(Token)input.LT(1);
            if ( (input.LA(1)>=40 && input.LA(1)<=41) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set83));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:289:25: ( arrayList )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==LEFTPAREN) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:289:25: arrayList
                    {
                    pushFollow(FOLLOW_arrayList_in_pinQualifier512);
                    arrayList84=arrayList();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayList84.getTree());

                    }
                    break;

            }

            PERIOD85=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_pinQualifier515); 
            PERIOD85_tree = (CommonTree)adaptor.create(PERIOD85);
            root_0 = (CommonTree)adaptor.becomeRoot(PERIOD85_tree, root_0);


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
    // $ANTLR end "pinQualifier"

    public static class pinAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pinAssignment"
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:292:1: pinAssignment : ( pinQualifier )? IDENT ( sliceList )? EQUALS concatenation SEMICOLON ;
    public final PhdlParser.pinAssignment_return pinAssignment() throws RecognitionException {
        PhdlParser.pinAssignment_return retval = new PhdlParser.pinAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT87=null;
        Token EQUALS89=null;
        Token SEMICOLON91=null;
        PhdlParser.pinQualifier_return pinQualifier86 = null;

        PhdlParser.sliceList_return sliceList88 = null;

        PhdlParser.concatenation_return concatenation90 = null;


        CommonTree IDENT87_tree=null;
        CommonTree EQUALS89_tree=null;
        CommonTree SEMICOLON91_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:300:2: ( ( pinQualifier )? IDENT ( sliceList )? EQUALS concatenation SEMICOLON )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:300:4: ( pinQualifier )? IDENT ( sliceList )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:300:4: ( pinQualifier )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=40 && LA25_0<=41)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:300:4: pinQualifier
                    {
                    pushFollow(FOLLOW_pinQualifier_in_pinAssignment529);
                    pinQualifier86=pinQualifier();

                    state._fsp--;

                    adaptor.addChild(root_0, pinQualifier86.getTree());

                    }
                    break;

            }

            IDENT87=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinAssignment532); 
            IDENT87_tree = (CommonTree)adaptor.create(IDENT87);
            adaptor.addChild(root_0, IDENT87_tree);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:300:24: ( sliceList )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==LEFTBRACKET) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:300:24: sliceList
                    {
                    pushFollow(FOLLOW_sliceList_in_pinAssignment534);
                    sliceList88=sliceList();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceList88.getTree());

                    }
                    break;

            }

            EQUALS89=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinAssignment537); 
            EQUALS89_tree = (CommonTree)adaptor.create(EQUALS89);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS89_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_pinAssignment540);
            concatenation90=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation90.getTree());
            SEMICOLON91=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinAssignment542); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:303:1: netAssignment : IDENT ( sliceList )? EQUALS concatenation SEMICOLON ;
    public final PhdlParser.netAssignment_return netAssignment() throws RecognitionException {
        PhdlParser.netAssignment_return retval = new PhdlParser.netAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT92=null;
        Token EQUALS94=null;
        Token SEMICOLON96=null;
        PhdlParser.sliceList_return sliceList93 = null;

        PhdlParser.concatenation_return concatenation95 = null;


        CommonTree IDENT92_tree=null;
        CommonTree EQUALS94_tree=null;
        CommonTree SEMICOLON96_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:308:2: ( IDENT ( sliceList )? EQUALS concatenation SEMICOLON )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:308:4: IDENT ( sliceList )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT92=(Token)match(input,IDENT,FOLLOW_IDENT_in_netAssignment556); 
            IDENT92_tree = (CommonTree)adaptor.create(IDENT92);
            adaptor.addChild(root_0, IDENT92_tree);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:308:10: ( sliceList )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==LEFTBRACKET) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:308:10: sliceList
                    {
                    pushFollow(FOLLOW_sliceList_in_netAssignment558);
                    sliceList93=sliceList();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceList93.getTree());

                    }
                    break;

            }

            EQUALS94=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_netAssignment561); 
            EQUALS94_tree = (CommonTree)adaptor.create(EQUALS94);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS94_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_netAssignment564);
            concatenation95=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation95.getTree());
            SEMICOLON96=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netAssignment566); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:311:1: concatenation : ( ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* ) | ( LEFTANGLE IDENT ( sliceList )? RIGHTANGLE ) | 'open' );
    public final PhdlParser.concatenation_return concatenation() throws RecognitionException {
        PhdlParser.concatenation_return retval = new PhdlParser.concatenation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT97=null;
        Token AMPERSAND99=null;
        Token IDENT100=null;
        Token LEFTANGLE102=null;
        Token IDENT103=null;
        Token RIGHTANGLE105=null;
        Token string_literal106=null;
        PhdlParser.sliceList_return sliceList98 = null;

        PhdlParser.sliceList_return sliceList101 = null;

        PhdlParser.sliceList_return sliceList104 = null;


        CommonTree IDENT97_tree=null;
        CommonTree AMPERSAND99_tree=null;
        CommonTree IDENT100_tree=null;
        CommonTree LEFTANGLE102_tree=null;
        CommonTree IDENT103_tree=null;
        CommonTree RIGHTANGLE105_tree=null;
        CommonTree string_literal106_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:317:2: ( ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* ) | ( LEFTANGLE IDENT ( sliceList )? RIGHTANGLE ) | 'open' )
            int alt32=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt32=1;
                }
                break;
            case LEFTANGLE:
                {
                alt32=2;
                }
                break;
            case 42:
                {
                alt32=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:317:4: ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:317:4: ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* )
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:317:5: ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )*
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:317:5: ( IDENT ( sliceList )? )
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:317:6: IDENT ( sliceList )?
                    {
                    IDENT97=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation583); 
                    IDENT97_tree = (CommonTree)adaptor.create(IDENT97);
                    adaptor.addChild(root_0, IDENT97_tree);

                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:317:12: ( sliceList )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==LEFTBRACKET) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:317:12: sliceList
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation585);
                            sliceList98=sliceList();

                            state._fsp--;

                            adaptor.addChild(root_0, sliceList98.getTree());

                            }
                            break;

                    }


                    }

                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:317:24: ( AMPERSAND IDENT ( sliceList )? )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==AMPERSAND) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:317:25: AMPERSAND IDENT ( sliceList )?
                    	    {
                    	    AMPERSAND99=(Token)match(input,AMPERSAND,FOLLOW_AMPERSAND_in_concatenation590); 
                    	    IDENT100=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation593); 
                    	    IDENT100_tree = (CommonTree)adaptor.create(IDENT100);
                    	    adaptor.addChild(root_0, IDENT100_tree);

                    	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:317:42: ( sliceList )?
                    	    int alt29=2;
                    	    int LA29_0 = input.LA(1);

                    	    if ( (LA29_0==LEFTBRACKET) ) {
                    	        alt29=1;
                    	    }
                    	    switch (alt29) {
                    	        case 1 :
                    	            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:317:42: sliceList
                    	            {
                    	            pushFollow(FOLLOW_sliceList_in_concatenation595);
                    	            sliceList101=sliceList();

                    	            state._fsp--;

                    	            adaptor.addChild(root_0, sliceList101.getTree());

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:318:4: ( LEFTANGLE IDENT ( sliceList )? RIGHTANGLE )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:318:4: ( LEFTANGLE IDENT ( sliceList )? RIGHTANGLE )
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:318:5: LEFTANGLE IDENT ( sliceList )? RIGHTANGLE
                    {
                    LEFTANGLE102=(Token)match(input,LEFTANGLE,FOLLOW_LEFTANGLE_in_concatenation607); 
                    LEFTANGLE102_tree = (CommonTree)adaptor.create(LEFTANGLE102);
                    adaptor.addChild(root_0, LEFTANGLE102_tree);

                    IDENT103=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation609); 
                    IDENT103_tree = (CommonTree)adaptor.create(IDENT103);
                    adaptor.addChild(root_0, IDENT103_tree);

                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:318:21: ( sliceList )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==LEFTBRACKET) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:318:21: sliceList
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation611);
                            sliceList104=sliceList();

                            state._fsp--;

                            adaptor.addChild(root_0, sliceList104.getTree());

                            }
                            break;

                    }

                    RIGHTANGLE105=(Token)match(input,RIGHTANGLE,FOLLOW_RIGHTANGLE_in_concatenation614); 

                    }


                    }
                    break;
                case 3 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:319:5: 'open'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal106=(Token)match(input,42,FOLLOW_42_in_concatenation622); 
                    string_literal106_tree = (CommonTree)adaptor.create(string_literal106);
                    adaptor.addChild(root_0, string_literal106_tree);


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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:322:1: pinList : LEFTBRACE ( IDENT | INTEGER ) ( COMMA ( IDENT | INTEGER ) )* RIGHTBRACE ;
    public final PhdlParser.pinList_return pinList() throws RecognitionException {
        PhdlParser.pinList_return retval = new PhdlParser.pinList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTBRACE107=null;
        Token set108=null;
        Token COMMA109=null;
        Token set110=null;
        Token RIGHTBRACE111=null;

        CommonTree LEFTBRACE107_tree=null;
        CommonTree set108_tree=null;
        CommonTree COMMA109_tree=null;
        CommonTree set110_tree=null;
        CommonTree RIGHTBRACE111_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:327:2: ( LEFTBRACE ( IDENT | INTEGER ) ( COMMA ( IDENT | INTEGER ) )* RIGHTBRACE )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:327:5: LEFTBRACE ( IDENT | INTEGER ) ( COMMA ( IDENT | INTEGER ) )* RIGHTBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACE107=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_pinList637); 
            set108=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||input.LA(1)==INTEGER ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set108));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:327:34: ( COMMA ( IDENT | INTEGER ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==COMMA) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:327:35: COMMA ( IDENT | INTEGER )
            	    {
            	    COMMA109=(Token)match(input,COMMA,FOLLOW_COMMA_in_pinList649); 
            	    set110=(Token)input.LT(1);
            	    if ( input.LA(1)==IDENT||input.LA(1)==INTEGER ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (CommonTree)adaptor.create(set110));
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            RIGHTBRACE111=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_pinList662); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:330:1: sliceList : LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTBRACKET ;
    public final PhdlParser.sliceList_return sliceList() throws RecognitionException {
        PhdlParser.sliceList_return retval = new PhdlParser.sliceList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTBRACKET112=null;
        Token INTEGER113=null;
        Token COLON114=null;
        Token INTEGER115=null;
        Token COMMA116=null;
        Token INTEGER117=null;
        Token COMMA118=null;
        Token INTEGER119=null;
        Token RIGHTBRACKET120=null;

        CommonTree LEFTBRACKET112_tree=null;
        CommonTree INTEGER113_tree=null;
        CommonTree COLON114_tree=null;
        CommonTree INTEGER115_tree=null;
        CommonTree COMMA116_tree=null;
        CommonTree INTEGER117_tree=null;
        CommonTree COMMA118_tree=null;
        CommonTree INTEGER119_tree=null;
        CommonTree RIGHTBRACKET120_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:336:2: ( LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTBRACKET )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:336:5: LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTBRACKET
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACKET112=(Token)match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList678); 
            LEFTBRACKET112_tree = (CommonTree)adaptor.create(LEFTBRACKET112);
            adaptor.addChild(root_0, LEFTBRACKET112_tree);

            INTEGER113=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList680); 
            INTEGER113_tree = (CommonTree)adaptor.create(INTEGER113);
            adaptor.addChild(root_0, INTEGER113_tree);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:336:25: ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==COLON) ) {
                alt36=1;
            }
            else if ( (LA36_0==COMMA||LA36_0==RIGHTBRACKET) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:336:26: ( COLON INTEGER )
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:336:26: ( COLON INTEGER )
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:336:27: COLON INTEGER
                    {
                    COLON114=(Token)match(input,COLON,FOLLOW_COLON_in_sliceList684); 
                    COLON114_tree = (CommonTree)adaptor.create(COLON114);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON114_tree, root_0);

                    INTEGER115=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList687); 
                    INTEGER115_tree = (CommonTree)adaptor.create(INTEGER115);
                    adaptor.addChild(root_0, INTEGER115_tree);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:336:45: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:336:45: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==COMMA) ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:336:46: COMMA INTEGER ( COMMA INTEGER )*
                            {
                            COMMA116=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceList693); 
                            COMMA116_tree = (CommonTree)adaptor.create(COMMA116);
                            root_0 = (CommonTree)adaptor.becomeRoot(COMMA116_tree, root_0);

                            INTEGER117=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList696); 
                            INTEGER117_tree = (CommonTree)adaptor.create(INTEGER117);
                            adaptor.addChild(root_0, INTEGER117_tree);

                            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:336:61: ( COMMA INTEGER )*
                            loop34:
                            do {
                                int alt34=2;
                                int LA34_0 = input.LA(1);

                                if ( (LA34_0==COMMA) ) {
                                    alt34=1;
                                }


                                switch (alt34) {
                            	case 1 :
                            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:336:62: COMMA INTEGER
                            	    {
                            	    COMMA118=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceList699); 
                            	    INTEGER119=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList702); 
                            	    INTEGER119_tree = (CommonTree)adaptor.create(INTEGER119);
                            	    adaptor.addChild(root_0, INTEGER119_tree);


                            	    }
                            	    break;

                            	default :
                            	    break loop34;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }

            RIGHTBRACKET120=(Token)match(input,RIGHTBRACKET,FOLLOW_RIGHTBRACKET_in_sliceList709); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:339:1: sliceDecl : LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RIGHTBRACKET ;
    public final PhdlParser.sliceDecl_return sliceDecl() throws RecognitionException {
        PhdlParser.sliceDecl_return retval = new PhdlParser.sliceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTBRACKET121=null;
        Token INTEGER122=null;
        Token COLON123=null;
        Token INTEGER124=null;
        Token COMMA125=null;
        Token INTEGER126=null;
        Token RIGHTBRACKET127=null;

        CommonTree LEFTBRACKET121_tree=null;
        CommonTree INTEGER122_tree=null;
        CommonTree COLON123_tree=null;
        CommonTree INTEGER124_tree=null;
        CommonTree COMMA125_tree=null;
        CommonTree INTEGER126_tree=null;
        CommonTree RIGHTBRACKET127_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:344:2: ( LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RIGHTBRACKET )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:344:4: LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RIGHTBRACKET
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACKET121=(Token)match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceDecl723); 
            LEFTBRACKET121_tree = (CommonTree)adaptor.create(LEFTBRACKET121);
            adaptor.addChild(root_0, LEFTBRACKET121_tree);

            INTEGER122=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl725); 
            INTEGER122_tree = (CommonTree)adaptor.create(INTEGER122);
            adaptor.addChild(root_0, INTEGER122_tree);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:344:24: ( ( COLON INTEGER ) | ( COMMA INTEGER )+ )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==COLON) ) {
                alt38=1;
            }
            else if ( (LA38_0==COMMA) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:344:25: ( COLON INTEGER )
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:344:25: ( COLON INTEGER )
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:344:26: COLON INTEGER
                    {
                    COLON123=(Token)match(input,COLON,FOLLOW_COLON_in_sliceDecl729); 
                    COLON123_tree = (CommonTree)adaptor.create(COLON123);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON123_tree, root_0);

                    INTEGER124=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl732); 
                    INTEGER124_tree = (CommonTree)adaptor.create(INTEGER124);
                    adaptor.addChild(root_0, INTEGER124_tree);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:344:44: ( COMMA INTEGER )+
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:344:44: ( COMMA INTEGER )+
                    int cnt37=0;
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==COMMA) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:344:45: COMMA INTEGER
                    	    {
                    	    COMMA125=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceDecl738); 
                    	    COMMA125_tree = (CommonTree)adaptor.create(COMMA125);
                    	    root_0 = (CommonTree)adaptor.becomeRoot(COMMA125_tree, root_0);

                    	    INTEGER126=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl741); 
                    	    INTEGER126_tree = (CommonTree)adaptor.create(INTEGER126);
                    	    adaptor.addChild(root_0, INTEGER126_tree);


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt37 >= 1 ) break loop37;
                                EarlyExitException eee =
                                    new EarlyExitException(37, input);
                                throw eee;
                        }
                        cnt37++;
                    } while (true);


                    }
                    break;

            }

            RIGHTBRACKET127=(Token)match(input,RIGHTBRACKET,FOLLOW_RIGHTBRACKET_in_sliceDecl746); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:347:1: arrayList : LEFTPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTPAREN ;
    public final PhdlParser.arrayList_return arrayList() throws RecognitionException {
        PhdlParser.arrayList_return retval = new PhdlParser.arrayList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTPAREN128=null;
        Token INTEGER129=null;
        Token COLON130=null;
        Token INTEGER131=null;
        Token COMMA132=null;
        Token INTEGER133=null;
        Token COMMA134=null;
        Token INTEGER135=null;
        Token RIGHTPAREN136=null;

        CommonTree LEFTPAREN128_tree=null;
        CommonTree INTEGER129_tree=null;
        CommonTree COLON130_tree=null;
        CommonTree INTEGER131_tree=null;
        CommonTree COMMA132_tree=null;
        CommonTree INTEGER133_tree=null;
        CommonTree COMMA134_tree=null;
        CommonTree INTEGER135_tree=null;
        CommonTree RIGHTPAREN136_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:352:2: ( LEFTPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTPAREN )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:352:5: LEFTPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTPAREN128=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList762); 
            LEFTPAREN128_tree = (CommonTree)adaptor.create(LEFTPAREN128);
            adaptor.addChild(root_0, LEFTPAREN128_tree);

            INTEGER129=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList764); 
            INTEGER129_tree = (CommonTree)adaptor.create(INTEGER129);
            adaptor.addChild(root_0, INTEGER129_tree);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:352:23: ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==COLON) ) {
                alt41=1;
            }
            else if ( (LA41_0==COMMA||LA41_0==RIGHTPAREN) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:352:24: ( COLON INTEGER )
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:352:24: ( COLON INTEGER )
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:352:25: COLON INTEGER
                    {
                    COLON130=(Token)match(input,COLON,FOLLOW_COLON_in_arrayList768); 
                    COLON130_tree = (CommonTree)adaptor.create(COLON130);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON130_tree, root_0);

                    INTEGER131=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList771); 
                    INTEGER131_tree = (CommonTree)adaptor.create(INTEGER131);
                    adaptor.addChild(root_0, INTEGER131_tree);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:352:43: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:352:43: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==COMMA) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:352:44: COMMA INTEGER ( COMMA INTEGER )*
                            {
                            COMMA132=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayList777); 
                            COMMA132_tree = (CommonTree)adaptor.create(COMMA132);
                            root_0 = (CommonTree)adaptor.becomeRoot(COMMA132_tree, root_0);

                            INTEGER133=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList780); 
                            INTEGER133_tree = (CommonTree)adaptor.create(INTEGER133);
                            adaptor.addChild(root_0, INTEGER133_tree);

                            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:352:59: ( COMMA INTEGER )*
                            loop39:
                            do {
                                int alt39=2;
                                int LA39_0 = input.LA(1);

                                if ( (LA39_0==COMMA) ) {
                                    alt39=1;
                                }


                                switch (alt39) {
                            	case 1 :
                            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:352:60: COMMA INTEGER
                            	    {
                            	    COMMA134=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayList783); 
                            	    INTEGER135=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList786); 
                            	    INTEGER135_tree = (CommonTree)adaptor.create(INTEGER135);
                            	    adaptor.addChild(root_0, INTEGER135_tree);


                            	    }
                            	    break;

                            	default :
                            	    break loop39;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }

            RIGHTPAREN136=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_arrayList793); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:355:1: arrayDecl : LEFTPAREN INTEGER COLON INTEGER RIGHTPAREN ;
    public final PhdlParser.arrayDecl_return arrayDecl() throws RecognitionException {
        PhdlParser.arrayDecl_return retval = new PhdlParser.arrayDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTPAREN137=null;
        Token INTEGER138=null;
        Token COLON139=null;
        Token INTEGER140=null;
        Token RIGHTPAREN141=null;

        CommonTree LEFTPAREN137_tree=null;
        CommonTree INTEGER138_tree=null;
        CommonTree COLON139_tree=null;
        CommonTree INTEGER140_tree=null;
        CommonTree RIGHTPAREN141_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:360:2: ( LEFTPAREN INTEGER COLON INTEGER RIGHTPAREN )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:360:4: LEFTPAREN INTEGER COLON INTEGER RIGHTPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTPAREN137=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayDecl807); 
            LEFTPAREN137_tree = (CommonTree)adaptor.create(LEFTPAREN137);
            adaptor.addChild(root_0, LEFTPAREN137_tree);

            INTEGER138=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayDecl809); 
            INTEGER138_tree = (CommonTree)adaptor.create(INTEGER138);
            adaptor.addChild(root_0, INTEGER138_tree);

            COLON139=(Token)match(input,COLON,FOLLOW_COLON_in_arrayDecl811); 
            COLON139_tree = (CommonTree)adaptor.create(COLON139);
            root_0 = (CommonTree)adaptor.becomeRoot(COLON139_tree, root_0);

            INTEGER140=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayDecl814); 
            INTEGER140_tree = (CommonTree)adaptor.create(INTEGER140);
            adaptor.addChild(root_0, INTEGER140_tree);

            RIGHTPAREN141=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_arrayDecl816); 

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
        "\1\4\2\uffff\1\11\1\6\2\uffff\1\16\2\4\1\10\2\16\1\11\1\24\1\10"+
        "\1\16\1\10";
    static final String DFA15_maxS =
        "\1\51\2\uffff\1\23\1\20\2\uffff\1\16\1\4\1\52\1\24\2\16\1\11\2"+
        "\24\1\16\1\24";
    static final String DFA15_acceptS =
        "\1\uffff\1\4\1\1\2\uffff\1\2\1\3\13\uffff";
    static final String DFA15_specialS =
        "\22\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\4\31\uffff\1\1\6\uffff\1\6\1\uffff\1\2\1\3\1\5",
            "",
            "",
            "\1\10\11\uffff\1\7",
            "\1\11\11\uffff\1\5",
            "",
            "",
            "\1\12",
            "\1\4",
            "\1\5\2\uffff\1\2\3\uffff\1\5\36\uffff\1\5",
            "\1\14\10\uffff\1\13\2\uffff\1\15",
            "\1\16",
            "\1\17",
            "\1\10",
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
    public static final BitSet FOLLOW_29_in_designDecl121 = new BitSet(new long[]{0x0000004840000010L});
    public static final BitSet FOLLOW_instanceDecl_in_designDecl126 = new BitSet(new long[]{0x0000004840000010L});
    public static final BitSet FOLLOW_netAssignment_in_designDecl130 = new BitSet(new long[]{0x0000004840000010L});
    public static final BitSet FOLLOW_groupStruct_in_designDecl134 = new BitSet(new long[]{0x0000004840000010L});
    public static final BitSet FOLLOW_30_in_designDecl140 = new BitSet(new long[]{0x0000000008000030L});
    public static final BitSet FOLLOW_27_in_designDecl143 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_IDENT_in_designDecl147 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_designDecl150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_deviceDecl165 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl168 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_deviceDecl170 = new BitSet(new long[]{0x0000000340000000L});
    public static final BitSet FOLLOW_attributeDecl_in_deviceDecl177 = new BitSet(new long[]{0x0000000340000000L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl181 = new BitSet(new long[]{0x0000000340000000L});
    public static final BitSet FOLLOW_30_in_deviceDecl188 = new BitSet(new long[]{0x0000000080000030L});
    public static final BitSet FOLLOW_31_in_deviceDecl191 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl195 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_deviceDecl198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_attributeDecl213 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attributeDecl216 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_attributeDecl218 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_in_attributeDecl221 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeDecl223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_pinDecl237 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_sliceDecl_in_pinDecl240 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl243 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_pinDecl245 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_pinList_in_pinDecl248 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinDecl250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_type265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_netDecl278 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_sliceDecl_in_netDecl281 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl284 = new BitSet(new long[]{0x0000000010000120L});
    public static final BitSet FOLLOW_COMMA_in_netDecl287 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl289 = new BitSet(new long[]{0x0000000010000120L});
    public static final BitSet FOLLOW_netAttributes_in_netDecl293 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_netDecl296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_netAttributes311 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_attributeDecl_in_netAttributes314 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_30_in_netAttributes317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_instanceDecl331 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_arrayDecl_in_instanceDecl334 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instanceDecl337 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_instanceDecl339 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instanceDecl342 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_instanceDecl344 = new BitSet(new long[]{0x000003A4C0000010L});
    public static final BitSet FOLLOW_attributeAssignment_in_instanceDecl350 = new BitSet(new long[]{0x000003A4C0000010L});
    public static final BitSet FOLLOW_pinAssignment_in_instanceDecl354 = new BitSet(new long[]{0x000003A4C0000010L});
    public static final BitSet FOLLOW_infoStruct_in_instanceDecl358 = new BitSet(new long[]{0x000003A4C0000010L});
    public static final BitSet FOLLOW_30_in_instanceDecl364 = new BitSet(new long[]{0x0000000800000030L});
    public static final BitSet FOLLOW_35_in_instanceDecl367 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_IDENT_in_instanceDecl371 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_instanceDecl374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_infoStruct389 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_infoStruct392 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_in_infoStruct395 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_infoStruct397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_groupStruct412 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_in_groupStruct415 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_groupStruct417 = new BitSet(new long[]{0x0000000840000010L});
    public static final BitSet FOLLOW_instanceDecl_in_groupStruct421 = new BitSet(new long[]{0x0000000840000010L});
    public static final BitSet FOLLOW_netAssignment_in_groupStruct425 = new BitSet(new long[]{0x0000000840000010L});
    public static final BitSet FOLLOW_30_in_groupStruct429 = new BitSet(new long[]{0x00000040000000A0L});
    public static final BitSet FOLLOW_38_in_groupStruct432 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_STRING_in_groupStruct436 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_groupStruct439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_attributeAssignment454 = new BitSet(new long[]{0x0000010000000010L});
    public static final BitSet FOLLOW_attributeQualifier_in_attributeAssignment458 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attributeAssignment461 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_attributeAssignment463 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_in_attributeAssignment466 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeAssignment468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_attributeQualifier483 = new BitSet(new long[]{0x0000000000080200L});
    public static final BitSet FOLLOW_arrayList_in_attributeQualifier485 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_PERIOD_in_attributeQualifier488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_pinQualifier504 = new BitSet(new long[]{0x0000000000080200L});
    public static final BitSet FOLLOW_arrayList_in_pinQualifier512 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_PERIOD_in_pinQualifier515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pinQualifier_in_pinAssignment529 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinAssignment532 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_sliceList_in_pinAssignment534 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssignment537 = new BitSet(new long[]{0x0000040000000810L});
    public static final BitSet FOLLOW_concatenation_in_pinAssignment540 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinAssignment542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_netAssignment556 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_sliceList_in_netAssignment558 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_netAssignment561 = new BitSet(new long[]{0x0000040000000810L});
    public static final BitSet FOLLOW_concatenation_in_netAssignment564 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_netAssignment566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_concatenation583 = new BitSet(new long[]{0x0000000000010402L});
    public static final BitSet FOLLOW_sliceList_in_concatenation585 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_AMPERSAND_in_concatenation590 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation593 = new BitSet(new long[]{0x0000000000010402L});
    public static final BitSet FOLLOW_sliceList_in_concatenation595 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_LEFTANGLE_in_concatenation607 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation609 = new BitSet(new long[]{0x0000000000011000L});
    public static final BitSet FOLLOW_sliceList_in_concatenation611 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RIGHTANGLE_in_concatenation614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_concatenation622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACE_in_pinList637 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_set_in_pinList640 = new BitSet(new long[]{0x0000000000008100L});
    public static final BitSet FOLLOW_COMMA_in_pinList649 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_set_in_pinList652 = new BitSet(new long[]{0x0000000000008100L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_pinList662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList678 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList680 = new BitSet(new long[]{0x0000000000060100L});
    public static final BitSet FOLLOW_COLON_in_sliceList684 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList687 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_sliceList693 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList696 = new BitSet(new long[]{0x0000000000040100L});
    public static final BitSet FOLLOW_COMMA_in_sliceList699 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList702 = new BitSet(new long[]{0x0000000000040100L});
    public static final BitSet FOLLOW_RIGHTBRACKET_in_sliceList709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceDecl723 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl725 = new BitSet(new long[]{0x0000000000020100L});
    public static final BitSet FOLLOW_COLON_in_sliceDecl729 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl732 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_sliceDecl738 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl741 = new BitSet(new long[]{0x0000000000040100L});
    public static final BitSet FOLLOW_RIGHTBRACKET_in_sliceDecl746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList762 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList764 = new BitSet(new long[]{0x0000000000120100L});
    public static final BitSet FOLLOW_COLON_in_arrayList768 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList771 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_arrayList777 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList780 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_COMMA_in_arrayList783 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList786 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_RIGHTPAREN_in_arrayList793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayDecl807 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayDecl809 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_arrayDecl811 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayDecl814 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RIGHTPAREN_in_arrayDecl816 = new BitSet(new long[]{0x0000000000000002L});

}