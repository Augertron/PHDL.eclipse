// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g 2011-11-28 09:34:24

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "LEFTBRACE", "RIGHTBRACE", "EQUALS", "STRING", "SEMICOLON", "COMMA", "PERIOD", "AMPERSAND", "LEFTANGLE", "RIGHTANGLE", "INTEGER", "LEFTBRACKET", "COLON", "RIGHTBRACKET", "LEFTPAREN", "RIGHTPAREN", "CHAR", "DIGIT", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "INCLUDE", "'design'", "'device'", "'attr'", "'pin'", "'net'", "'inst'", "'of'", "'info'", "'group'", "'newattr'", "'each'", "'combine'", "'open'"
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
    public static final int LEFTBRACE=5;
    public static final int RIGHTBRACE=6;
    public static final int EQUALS=7;
    public static final int STRING=8;
    public static final int SEMICOLON=9;
    public static final int COMMA=10;
    public static final int PERIOD=11;
    public static final int AMPERSAND=12;
    public static final int LEFTANGLE=13;
    public static final int RIGHTANGLE=14;
    public static final int INTEGER=15;
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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:157:1: sourceText : ( designDecl )+ EOF ;
    public final PhdlParser.sourceText_return sourceText() throws RecognitionException {
        PhdlParser.sourceText_return retval = new PhdlParser.sourceText_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF2=null;
        PhdlParser.designDecl_return designDecl1 = null;


        CommonTree EOF2_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:162:2: ( ( designDecl )+ EOF )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:162:4: ( designDecl )+ EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:162:4: ( designDecl )+
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
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:162:4: designDecl
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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:165:1: designDecl : 'design' IDENT LEFTBRACE ( deviceDecl | netDecl | infoStruct | instanceDecl | netAssignment | groupStruct )* RIGHTBRACE ;
    public final PhdlParser.designDecl_return designDecl() throws RecognitionException {
        PhdlParser.designDecl_return retval = new PhdlParser.designDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal3=null;
        Token IDENT4=null;
        Token LEFTBRACE5=null;
        Token RIGHTBRACE12=null;
        PhdlParser.deviceDecl_return deviceDecl6 = null;

        PhdlParser.netDecl_return netDecl7 = null;

        PhdlParser.infoStruct_return infoStruct8 = null;

        PhdlParser.instanceDecl_return instanceDecl9 = null;

        PhdlParser.netAssignment_return netAssignment10 = null;

        PhdlParser.groupStruct_return groupStruct11 = null;


        CommonTree string_literal3_tree=null;
        CommonTree IDENT4_tree=null;
        CommonTree LEFTBRACE5_tree=null;
        CommonTree RIGHTBRACE12_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:173:2: ( 'design' IDENT LEFTBRACE ( deviceDecl | netDecl | infoStruct | instanceDecl | netAssignment | groupStruct )* RIGHTBRACE )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:173:4: 'design' IDENT LEFTBRACE ( deviceDecl | netDecl | infoStruct | instanceDecl | netAssignment | groupStruct )* RIGHTBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal3=(Token)match(input,27,FOLLOW_27_in_designDecl95); 
            string_literal3_tree = (CommonTree)adaptor.create(string_literal3);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal3_tree, root_0);

            IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_designDecl98); 
            IDENT4_tree = (CommonTree)adaptor.create(IDENT4);
            adaptor.addChild(root_0, IDENT4_tree);

            LEFTBRACE5=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_designDecl100); 
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:174:3: ( deviceDecl | netDecl | infoStruct | instanceDecl | netAssignment | groupStruct )*
            loop2:
            do {
                int alt2=7;
                switch ( input.LA(1) ) {
                case 28:
                    {
                    alt2=1;
                    }
                    break;
                case 31:
                    {
                    alt2=2;
                    }
                    break;
                case 34:
                    {
                    alt2=3;
                    }
                    break;
                case 32:
                    {
                    alt2=4;
                    }
                    break;
                case IDENT:
                    {
                    alt2=5;
                    }
                    break;
                case 35:
                    {
                    alt2=6;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:174:4: deviceDecl
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_designDecl107);
            	    deviceDecl6=deviceDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, deviceDecl6.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:174:17: netDecl
            	    {
            	    pushFollow(FOLLOW_netDecl_in_designDecl111);
            	    netDecl7=netDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netDecl7.getTree());

            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:174:27: infoStruct
            	    {
            	    pushFollow(FOLLOW_infoStruct_in_designDecl115);
            	    infoStruct8=infoStruct();

            	    state._fsp--;

            	    adaptor.addChild(root_0, infoStruct8.getTree());

            	    }
            	    break;
            	case 4 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:174:40: instanceDecl
            	    {
            	    pushFollow(FOLLOW_instanceDecl_in_designDecl119);
            	    instanceDecl9=instanceDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, instanceDecl9.getTree());

            	    }
            	    break;
            	case 5 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:174:55: netAssignment
            	    {
            	    pushFollow(FOLLOW_netAssignment_in_designDecl123);
            	    netAssignment10=netAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netAssignment10.getTree());

            	    }
            	    break;
            	case 6 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:174:71: groupStruct
            	    {
            	    pushFollow(FOLLOW_groupStruct_in_designDecl127);
            	    groupStruct11=groupStruct();

            	    state._fsp--;

            	    adaptor.addChild(root_0, groupStruct11.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            RIGHTBRACE12=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_designDecl133); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:178:1: deviceDecl : 'device' IDENT LEFTBRACE ( attributeDecl | pinDecl )* RIGHTBRACE ;
    public final PhdlParser.deviceDecl_return deviceDecl() throws RecognitionException {
        PhdlParser.deviceDecl_return retval = new PhdlParser.deviceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal13=null;
        Token IDENT14=null;
        Token LEFTBRACE15=null;
        Token RIGHTBRACE18=null;
        PhdlParser.attributeDecl_return attributeDecl16 = null;

        PhdlParser.pinDecl_return pinDecl17 = null;


        CommonTree string_literal13_tree=null;
        CommonTree IDENT14_tree=null;
        CommonTree LEFTBRACE15_tree=null;
        CommonTree RIGHTBRACE18_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:185:2: ( 'device' IDENT LEFTBRACE ( attributeDecl | pinDecl )* RIGHTBRACE )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:185:4: 'device' IDENT LEFTBRACE ( attributeDecl | pinDecl )* RIGHTBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal13=(Token)match(input,28,FOLLOW_28_in_deviceDecl148); 
            string_literal13_tree = (CommonTree)adaptor.create(string_literal13);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal13_tree, root_0);

            IDENT14=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl151); 
            IDENT14_tree = (CommonTree)adaptor.create(IDENT14);
            adaptor.addChild(root_0, IDENT14_tree);

            LEFTBRACE15=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_deviceDecl153); 
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:186:3: ( attributeDecl | pinDecl )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==29) ) {
                    alt3=1;
                }
                else if ( (LA3_0==30) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:186:5: attributeDecl
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_deviceDecl160);
            	    attributeDecl16=attributeDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeDecl16.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:186:21: pinDecl
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl164);
            	    pinDecl17=pinDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinDecl17.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            RIGHTBRACE18=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_deviceDecl171); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:190:1: attributeDecl : 'attr' IDENT EQUALS STRING SEMICOLON ;
    public final PhdlParser.attributeDecl_return attributeDecl() throws RecognitionException {
        PhdlParser.attributeDecl_return retval = new PhdlParser.attributeDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal19=null;
        Token IDENT20=null;
        Token EQUALS21=null;
        Token STRING22=null;
        Token SEMICOLON23=null;

        CommonTree string_literal19_tree=null;
        CommonTree IDENT20_tree=null;
        CommonTree EQUALS21_tree=null;
        CommonTree STRING22_tree=null;
        CommonTree SEMICOLON23_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:195:2: ( 'attr' IDENT EQUALS STRING SEMICOLON )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:195:4: 'attr' IDENT EQUALS STRING SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal19=(Token)match(input,29,FOLLOW_29_in_attributeDecl186); 
            string_literal19_tree = (CommonTree)adaptor.create(string_literal19);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal19_tree, root_0);

            IDENT20=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeDecl189); 
            IDENT20_tree = (CommonTree)adaptor.create(IDENT20);
            adaptor.addChild(root_0, IDENT20_tree);

            EQUALS21=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeDecl191); 
            STRING22=(Token)match(input,STRING,FOLLOW_STRING_in_attributeDecl194); 
            STRING22_tree = (CommonTree)adaptor.create(STRING22);
            adaptor.addChild(root_0, STRING22_tree);

            SEMICOLON23=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeDecl196); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:198:1: pinDecl : type ( sliceDecl )? IDENT EQUALS pinList SEMICOLON ;
    public final PhdlParser.pinDecl_return pinDecl() throws RecognitionException {
        PhdlParser.pinDecl_return retval = new PhdlParser.pinDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT26=null;
        Token EQUALS27=null;
        Token SEMICOLON29=null;
        PhdlParser.type_return type24 = null;

        PhdlParser.sliceDecl_return sliceDecl25 = null;

        PhdlParser.pinList_return pinList28 = null;


        CommonTree IDENT26_tree=null;
        CommonTree EQUALS27_tree=null;
        CommonTree SEMICOLON29_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:203:2: ( type ( sliceDecl )? IDENT EQUALS pinList SEMICOLON )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:203:4: type ( sliceDecl )? IDENT EQUALS pinList SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_type_in_pinDecl210);
            type24=type();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(type24.getTree(), root_0);
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:203:10: ( sliceDecl )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==LEFTBRACKET) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:203:10: sliceDecl
                    {
                    pushFollow(FOLLOW_sliceDecl_in_pinDecl213);
                    sliceDecl25=sliceDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceDecl25.getTree());

                    }
                    break;

            }

            IDENT26=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinDecl216); 
            IDENT26_tree = (CommonTree)adaptor.create(IDENT26);
            adaptor.addChild(root_0, IDENT26_tree);

            EQUALS27=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinDecl218); 
            pushFollow(FOLLOW_pinList_in_pinDecl221);
            pinList28=pinList();

            state._fsp--;

            adaptor.addChild(root_0, pinList28.getTree());
            SEMICOLON29=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinDecl223); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:206:1: type : 'pin' ;
    public final PhdlParser.type_return type() throws RecognitionException {
        PhdlParser.type_return retval = new PhdlParser.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal30=null;

        CommonTree string_literal30_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:210:2: ( 'pin' )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:210:4: 'pin'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal30=(Token)match(input,30,FOLLOW_30_in_type238); 
            string_literal30_tree = (CommonTree)adaptor.create(string_literal30);
            adaptor.addChild(root_0, string_literal30_tree);


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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:213:1: netDecl : 'net' ( sliceDecl )? IDENT ( COMMA IDENT )* ( netAttributes )? SEMICOLON ;
    public final PhdlParser.netDecl_return netDecl() throws RecognitionException {
        PhdlParser.netDecl_return retval = new PhdlParser.netDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal31=null;
        Token IDENT33=null;
        Token COMMA34=null;
        Token IDENT35=null;
        Token SEMICOLON37=null;
        PhdlParser.sliceDecl_return sliceDecl32 = null;

        PhdlParser.netAttributes_return netAttributes36 = null;


        CommonTree string_literal31_tree=null;
        CommonTree IDENT33_tree=null;
        CommonTree COMMA34_tree=null;
        CommonTree IDENT35_tree=null;
        CommonTree SEMICOLON37_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:218:2: ( 'net' ( sliceDecl )? IDENT ( COMMA IDENT )* ( netAttributes )? SEMICOLON )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:218:4: 'net' ( sliceDecl )? IDENT ( COMMA IDENT )* ( netAttributes )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal31=(Token)match(input,31,FOLLOW_31_in_netDecl251); 
            string_literal31_tree = (CommonTree)adaptor.create(string_literal31);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal31_tree, root_0);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:218:11: ( sliceDecl )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==LEFTBRACKET) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:218:11: sliceDecl
                    {
                    pushFollow(FOLLOW_sliceDecl_in_netDecl254);
                    sliceDecl32=sliceDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceDecl32.getTree());

                    }
                    break;

            }

            IDENT33=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl257); 
            IDENT33_tree = (CommonTree)adaptor.create(IDENT33);
            adaptor.addChild(root_0, IDENT33_tree);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:218:28: ( COMMA IDENT )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==COMMA) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:218:29: COMMA IDENT
            	    {
            	    COMMA34=(Token)match(input,COMMA,FOLLOW_COMMA_in_netDecl260); 
            	    COMMA34_tree = (CommonTree)adaptor.create(COMMA34);
            	    adaptor.addChild(root_0, COMMA34_tree);

            	    IDENT35=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl262); 
            	    IDENT35_tree = (CommonTree)adaptor.create(IDENT35);
            	    adaptor.addChild(root_0, IDENT35_tree);


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:218:43: ( netAttributes )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==LEFTBRACE) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:218:43: netAttributes
                    {
                    pushFollow(FOLLOW_netAttributes_in_netDecl266);
                    netAttributes36=netAttributes();

                    state._fsp--;

                    adaptor.addChild(root_0, netAttributes36.getTree());

                    }
                    break;

            }

            SEMICOLON37=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netDecl269); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:221:1: netAttributes : LEFTBRACE ( attributeDecl )* RIGHTBRACE ;
    public final PhdlParser.netAttributes_return netAttributes() throws RecognitionException {
        PhdlParser.netAttributes_return retval = new PhdlParser.netAttributes_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTBRACE38=null;
        Token RIGHTBRACE40=null;
        PhdlParser.attributeDecl_return attributeDecl39 = null;


        CommonTree LEFTBRACE38_tree=null;
        CommonTree RIGHTBRACE40_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:227:2: ( LEFTBRACE ( attributeDecl )* RIGHTBRACE )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:227:4: LEFTBRACE ( attributeDecl )* RIGHTBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACE38=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_netAttributes284); 
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:227:15: ( attributeDecl )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==29) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:227:15: attributeDecl
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_netAttributes287);
            	    attributeDecl39=attributeDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeDecl39.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            RIGHTBRACE40=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_netAttributes290); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:230:1: instanceDecl : 'inst' ( arrayDecl )? IDENT 'of' IDENT LEFTBRACE ( attributeAssignment | pinAssignment | infoStruct )* RIGHTBRACE ;
    public final PhdlParser.instanceDecl_return instanceDecl() throws RecognitionException {
        PhdlParser.instanceDecl_return retval = new PhdlParser.instanceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal41=null;
        Token IDENT43=null;
        Token string_literal44=null;
        Token IDENT45=null;
        Token LEFTBRACE46=null;
        Token RIGHTBRACE50=null;
        PhdlParser.arrayDecl_return arrayDecl42 = null;

        PhdlParser.attributeAssignment_return attributeAssignment47 = null;

        PhdlParser.pinAssignment_return pinAssignment48 = null;

        PhdlParser.infoStruct_return infoStruct49 = null;


        CommonTree string_literal41_tree=null;
        CommonTree IDENT43_tree=null;
        CommonTree string_literal44_tree=null;
        CommonTree IDENT45_tree=null;
        CommonTree LEFTBRACE46_tree=null;
        CommonTree RIGHTBRACE50_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:239:2: ( 'inst' ( arrayDecl )? IDENT 'of' IDENT LEFTBRACE ( attributeAssignment | pinAssignment | infoStruct )* RIGHTBRACE )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:239:4: 'inst' ( arrayDecl )? IDENT 'of' IDENT LEFTBRACE ( attributeAssignment | pinAssignment | infoStruct )* RIGHTBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal41=(Token)match(input,32,FOLLOW_32_in_instanceDecl304); 
            string_literal41_tree = (CommonTree)adaptor.create(string_literal41);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal41_tree, root_0);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:239:12: ( arrayDecl )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==LEFTPAREN) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:239:12: arrayDecl
                    {
                    pushFollow(FOLLOW_arrayDecl_in_instanceDecl307);
                    arrayDecl42=arrayDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayDecl42.getTree());

                    }
                    break;

            }

            IDENT43=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceDecl310); 
            IDENT43_tree = (CommonTree)adaptor.create(IDENT43);
            adaptor.addChild(root_0, IDENT43_tree);

            string_literal44=(Token)match(input,33,FOLLOW_33_in_instanceDecl312); 
            IDENT45=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceDecl315); 
            IDENT45_tree = (CommonTree)adaptor.create(IDENT45);
            adaptor.addChild(root_0, IDENT45_tree);

            LEFTBRACE46=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_instanceDecl317); 
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:240:3: ( attributeAssignment | pinAssignment | infoStruct )*
            loop10:
            do {
                int alt10=4;
                alt10 = dfa10.predict(input);
                switch (alt10) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:240:4: attributeAssignment
            	    {
            	    pushFollow(FOLLOW_attributeAssignment_in_instanceDecl323);
            	    attributeAssignment47=attributeAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeAssignment47.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:240:26: pinAssignment
            	    {
            	    pushFollow(FOLLOW_pinAssignment_in_instanceDecl327);
            	    pinAssignment48=pinAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinAssignment48.getTree());

            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:240:42: infoStruct
            	    {
            	    pushFollow(FOLLOW_infoStruct_in_instanceDecl331);
            	    infoStruct49=infoStruct();

            	    state._fsp--;

            	    adaptor.addChild(root_0, infoStruct49.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            RIGHTBRACE50=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_instanceDecl337); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:244:1: infoStruct : 'info' LEFTBRACE STRING RIGHTBRACE ;
    public final PhdlParser.infoStruct_return infoStruct() throws RecognitionException {
        PhdlParser.infoStruct_return retval = new PhdlParser.infoStruct_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal51=null;
        Token LEFTBRACE52=null;
        Token STRING53=null;
        Token RIGHTBRACE54=null;

        CommonTree string_literal51_tree=null;
        CommonTree LEFTBRACE52_tree=null;
        CommonTree STRING53_tree=null;
        CommonTree RIGHTBRACE54_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:249:2: ( 'info' LEFTBRACE STRING RIGHTBRACE )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:249:5: 'info' LEFTBRACE STRING RIGHTBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal51=(Token)match(input,34,FOLLOW_34_in_infoStruct352); 
            string_literal51_tree = (CommonTree)adaptor.create(string_literal51);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal51_tree, root_0);

            LEFTBRACE52=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_infoStruct355); 
            STRING53=(Token)match(input,STRING,FOLLOW_STRING_in_infoStruct358); 
            STRING53_tree = (CommonTree)adaptor.create(STRING53);
            adaptor.addChild(root_0, STRING53_tree);

            RIGHTBRACE54=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_infoStruct360); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:252:1: groupStruct : 'group' STRING LEFTBRACE ( instanceDecl | netAssignment )* RIGHTBRACE ;
    public final PhdlParser.groupStruct_return groupStruct() throws RecognitionException {
        PhdlParser.groupStruct_return retval = new PhdlParser.groupStruct_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal55=null;
        Token STRING56=null;
        Token LEFTBRACE57=null;
        Token RIGHTBRACE60=null;
        PhdlParser.instanceDecl_return instanceDecl58 = null;

        PhdlParser.netAssignment_return netAssignment59 = null;


        CommonTree string_literal55_tree=null;
        CommonTree STRING56_tree=null;
        CommonTree LEFTBRACE57_tree=null;
        CommonTree RIGHTBRACE60_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:253:2: ( 'group' STRING LEFTBRACE ( instanceDecl | netAssignment )* RIGHTBRACE )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:253:5: 'group' STRING LEFTBRACE ( instanceDecl | netAssignment )* RIGHTBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal55=(Token)match(input,35,FOLLOW_35_in_groupStruct375); 
            string_literal55_tree = (CommonTree)adaptor.create(string_literal55);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal55_tree, root_0);

            STRING56=(Token)match(input,STRING,FOLLOW_STRING_in_groupStruct378); 
            STRING56_tree = (CommonTree)adaptor.create(STRING56);
            adaptor.addChild(root_0, STRING56_tree);

            LEFTBRACE57=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_groupStruct380); 
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:253:32: ( instanceDecl | netAssignment )*
            loop11:
            do {
                int alt11=3;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==32) ) {
                    alt11=1;
                }
                else if ( (LA11_0==IDENT) ) {
                    alt11=2;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:253:33: instanceDecl
            	    {
            	    pushFollow(FOLLOW_instanceDecl_in_groupStruct384);
            	    instanceDecl58=instanceDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, instanceDecl58.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:253:48: netAssignment
            	    {
            	    pushFollow(FOLLOW_netAssignment_in_groupStruct388);
            	    netAssignment59=netAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netAssignment59.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            RIGHTBRACE60=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_groupStruct392); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:256:1: attributeAssignment : ( 'newattr' )? ( attributeQualifier )? IDENT EQUALS STRING SEMICOLON ;
    public final PhdlParser.attributeAssignment_return attributeAssignment() throws RecognitionException {
        PhdlParser.attributeAssignment_return retval = new PhdlParser.attributeAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal61=null;
        Token IDENT63=null;
        Token EQUALS64=null;
        Token STRING65=null;
        Token SEMICOLON66=null;
        PhdlParser.attributeQualifier_return attributeQualifier62 = null;


        CommonTree string_literal61_tree=null;
        CommonTree IDENT63_tree=null;
        CommonTree EQUALS64_tree=null;
        CommonTree STRING65_tree=null;
        CommonTree SEMICOLON66_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:267:2: ( ( 'newattr' )? ( attributeQualifier )? IDENT EQUALS STRING SEMICOLON )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:267:4: ( 'newattr' )? ( attributeQualifier )? IDENT EQUALS STRING SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:267:4: ( 'newattr' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==36) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:267:5: 'newattr'
                    {
                    string_literal61=(Token)match(input,36,FOLLOW_36_in_attributeAssignment407); 
                    string_literal61_tree = (CommonTree)adaptor.create(string_literal61);
                    adaptor.addChild(root_0, string_literal61_tree);


                    }
                    break;

            }

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:267:17: ( attributeQualifier )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==37) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:267:17: attributeQualifier
                    {
                    pushFollow(FOLLOW_attributeQualifier_in_attributeAssignment411);
                    attributeQualifier62=attributeQualifier();

                    state._fsp--;

                    adaptor.addChild(root_0, attributeQualifier62.getTree());

                    }
                    break;

            }

            IDENT63=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeAssignment414); 
            IDENT63_tree = (CommonTree)adaptor.create(IDENT63);
            adaptor.addChild(root_0, IDENT63_tree);

            EQUALS64=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeAssignment416); 
            EQUALS64_tree = (CommonTree)adaptor.create(EQUALS64);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS64_tree, root_0);

            STRING65=(Token)match(input,STRING,FOLLOW_STRING_in_attributeAssignment419); 
            STRING65_tree = (CommonTree)adaptor.create(STRING65);
            adaptor.addChild(root_0, STRING65_tree);

            SEMICOLON66=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeAssignment421); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:270:1: attributeQualifier : 'each' ( arrayList )? PERIOD ;
    public final PhdlParser.attributeQualifier_return attributeQualifier() throws RecognitionException {
        PhdlParser.attributeQualifier_return retval = new PhdlParser.attributeQualifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal67=null;
        Token PERIOD69=null;
        PhdlParser.arrayList_return arrayList68 = null;


        CommonTree string_literal67_tree=null;
        CommonTree PERIOD69_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:276:2: ( 'each' ( arrayList )? PERIOD )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:276:4: 'each' ( arrayList )? PERIOD
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal67=(Token)match(input,37,FOLLOW_37_in_attributeQualifier436); 
            string_literal67_tree = (CommonTree)adaptor.create(string_literal67);
            adaptor.addChild(root_0, string_literal67_tree);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:276:11: ( arrayList )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==LEFTPAREN) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:276:11: arrayList
                    {
                    pushFollow(FOLLOW_arrayList_in_attributeQualifier438);
                    arrayList68=arrayList();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayList68.getTree());

                    }
                    break;

            }

            PERIOD69=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_attributeQualifier441); 
            PERIOD69_tree = (CommonTree)adaptor.create(PERIOD69);
            root_0 = (CommonTree)adaptor.becomeRoot(PERIOD69_tree, root_0);


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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:279:1: pinQualifier : ( 'each' | 'combine' ) ( arrayList )? PERIOD ;
    public final PhdlParser.pinQualifier_return pinQualifier() throws RecognitionException {
        PhdlParser.pinQualifier_return retval = new PhdlParser.pinQualifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set70=null;
        Token PERIOD72=null;
        PhdlParser.arrayList_return arrayList71 = null;


        CommonTree set70_tree=null;
        CommonTree PERIOD72_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:285:2: ( ( 'each' | 'combine' ) ( arrayList )? PERIOD )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:285:4: ( 'each' | 'combine' ) ( arrayList )? PERIOD
            {
            root_0 = (CommonTree)adaptor.nil();

            set70=(Token)input.LT(1);
            if ( (input.LA(1)>=37 && input.LA(1)<=38) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set70));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:285:25: ( arrayList )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==LEFTPAREN) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:285:25: arrayList
                    {
                    pushFollow(FOLLOW_arrayList_in_pinQualifier465);
                    arrayList71=arrayList();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayList71.getTree());

                    }
                    break;

            }

            PERIOD72=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_pinQualifier468); 
            PERIOD72_tree = (CommonTree)adaptor.create(PERIOD72);
            root_0 = (CommonTree)adaptor.becomeRoot(PERIOD72_tree, root_0);


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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:288:1: pinAssignment : ( pinQualifier )? IDENT ( sliceList )? EQUALS concatenation SEMICOLON ;
    public final PhdlParser.pinAssignment_return pinAssignment() throws RecognitionException {
        PhdlParser.pinAssignment_return retval = new PhdlParser.pinAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT74=null;
        Token EQUALS76=null;
        Token SEMICOLON78=null;
        PhdlParser.pinQualifier_return pinQualifier73 = null;

        PhdlParser.sliceList_return sliceList75 = null;

        PhdlParser.concatenation_return concatenation77 = null;


        CommonTree IDENT74_tree=null;
        CommonTree EQUALS76_tree=null;
        CommonTree SEMICOLON78_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:296:2: ( ( pinQualifier )? IDENT ( sliceList )? EQUALS concatenation SEMICOLON )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:296:4: ( pinQualifier )? IDENT ( sliceList )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:296:4: ( pinQualifier )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=37 && LA16_0<=38)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:296:4: pinQualifier
                    {
                    pushFollow(FOLLOW_pinQualifier_in_pinAssignment482);
                    pinQualifier73=pinQualifier();

                    state._fsp--;

                    adaptor.addChild(root_0, pinQualifier73.getTree());

                    }
                    break;

            }

            IDENT74=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinAssignment485); 
            IDENT74_tree = (CommonTree)adaptor.create(IDENT74);
            adaptor.addChild(root_0, IDENT74_tree);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:296:24: ( sliceList )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==LEFTBRACKET) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:296:24: sliceList
                    {
                    pushFollow(FOLLOW_sliceList_in_pinAssignment487);
                    sliceList75=sliceList();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceList75.getTree());

                    }
                    break;

            }

            EQUALS76=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinAssignment490); 
            EQUALS76_tree = (CommonTree)adaptor.create(EQUALS76);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS76_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_pinAssignment493);
            concatenation77=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation77.getTree());
            SEMICOLON78=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinAssignment495); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:299:1: netAssignment : IDENT ( sliceList )? EQUALS concatenation SEMICOLON ;
    public final PhdlParser.netAssignment_return netAssignment() throws RecognitionException {
        PhdlParser.netAssignment_return retval = new PhdlParser.netAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT79=null;
        Token EQUALS81=null;
        Token SEMICOLON83=null;
        PhdlParser.sliceList_return sliceList80 = null;

        PhdlParser.concatenation_return concatenation82 = null;


        CommonTree IDENT79_tree=null;
        CommonTree EQUALS81_tree=null;
        CommonTree SEMICOLON83_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:304:2: ( IDENT ( sliceList )? EQUALS concatenation SEMICOLON )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:304:4: IDENT ( sliceList )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT79=(Token)match(input,IDENT,FOLLOW_IDENT_in_netAssignment509); 
            IDENT79_tree = (CommonTree)adaptor.create(IDENT79);
            adaptor.addChild(root_0, IDENT79_tree);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:304:10: ( sliceList )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==LEFTBRACKET) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:304:10: sliceList
                    {
                    pushFollow(FOLLOW_sliceList_in_netAssignment511);
                    sliceList80=sliceList();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceList80.getTree());

                    }
                    break;

            }

            EQUALS81=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_netAssignment514); 
            EQUALS81_tree = (CommonTree)adaptor.create(EQUALS81);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS81_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_netAssignment517);
            concatenation82=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation82.getTree());
            SEMICOLON83=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netAssignment519); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:307:1: concatenation : ( ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* ) | ( LEFTANGLE IDENT ( sliceList )? RIGHTANGLE ) | 'open' );
    public final PhdlParser.concatenation_return concatenation() throws RecognitionException {
        PhdlParser.concatenation_return retval = new PhdlParser.concatenation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT84=null;
        Token AMPERSAND86=null;
        Token IDENT87=null;
        Token LEFTANGLE89=null;
        Token IDENT90=null;
        Token RIGHTANGLE92=null;
        Token string_literal93=null;
        PhdlParser.sliceList_return sliceList85 = null;

        PhdlParser.sliceList_return sliceList88 = null;

        PhdlParser.sliceList_return sliceList91 = null;


        CommonTree IDENT84_tree=null;
        CommonTree AMPERSAND86_tree=null;
        CommonTree IDENT87_tree=null;
        CommonTree LEFTANGLE89_tree=null;
        CommonTree IDENT90_tree=null;
        CommonTree RIGHTANGLE92_tree=null;
        CommonTree string_literal93_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:313:2: ( ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* ) | ( LEFTANGLE IDENT ( sliceList )? RIGHTANGLE ) | 'open' )
            int alt23=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt23=1;
                }
                break;
            case LEFTANGLE:
                {
                alt23=2;
                }
                break;
            case 39:
                {
                alt23=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:313:4: ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:313:4: ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* )
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:313:5: ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )*
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:313:5: ( IDENT ( sliceList )? )
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:313:6: IDENT ( sliceList )?
                    {
                    IDENT84=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation536); 
                    IDENT84_tree = (CommonTree)adaptor.create(IDENT84);
                    adaptor.addChild(root_0, IDENT84_tree);

                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:313:12: ( sliceList )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==LEFTBRACKET) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:313:12: sliceList
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation538);
                            sliceList85=sliceList();

                            state._fsp--;

                            adaptor.addChild(root_0, sliceList85.getTree());

                            }
                            break;

                    }


                    }

                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:313:24: ( AMPERSAND IDENT ( sliceList )? )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==AMPERSAND) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:313:25: AMPERSAND IDENT ( sliceList )?
                    	    {
                    	    AMPERSAND86=(Token)match(input,AMPERSAND,FOLLOW_AMPERSAND_in_concatenation543); 
                    	    IDENT87=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation546); 
                    	    IDENT87_tree = (CommonTree)adaptor.create(IDENT87);
                    	    adaptor.addChild(root_0, IDENT87_tree);

                    	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:313:42: ( sliceList )?
                    	    int alt20=2;
                    	    int LA20_0 = input.LA(1);

                    	    if ( (LA20_0==LEFTBRACKET) ) {
                    	        alt20=1;
                    	    }
                    	    switch (alt20) {
                    	        case 1 :
                    	            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:313:42: sliceList
                    	            {
                    	            pushFollow(FOLLOW_sliceList_in_concatenation548);
                    	            sliceList88=sliceList();

                    	            state._fsp--;

                    	            adaptor.addChild(root_0, sliceList88.getTree());

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:314:4: ( LEFTANGLE IDENT ( sliceList )? RIGHTANGLE )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:314:4: ( LEFTANGLE IDENT ( sliceList )? RIGHTANGLE )
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:314:5: LEFTANGLE IDENT ( sliceList )? RIGHTANGLE
                    {
                    LEFTANGLE89=(Token)match(input,LEFTANGLE,FOLLOW_LEFTANGLE_in_concatenation560); 
                    LEFTANGLE89_tree = (CommonTree)adaptor.create(LEFTANGLE89);
                    adaptor.addChild(root_0, LEFTANGLE89_tree);

                    IDENT90=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation562); 
                    IDENT90_tree = (CommonTree)adaptor.create(IDENT90);
                    adaptor.addChild(root_0, IDENT90_tree);

                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:314:21: ( sliceList )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==LEFTBRACKET) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:314:21: sliceList
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation564);
                            sliceList91=sliceList();

                            state._fsp--;

                            adaptor.addChild(root_0, sliceList91.getTree());

                            }
                            break;

                    }

                    RIGHTANGLE92=(Token)match(input,RIGHTANGLE,FOLLOW_RIGHTANGLE_in_concatenation567); 

                    }


                    }
                    break;
                case 3 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:315:5: 'open'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal93=(Token)match(input,39,FOLLOW_39_in_concatenation575); 
                    string_literal93_tree = (CommonTree)adaptor.create(string_literal93);
                    adaptor.addChild(root_0, string_literal93_tree);


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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:318:1: pinList : LEFTBRACE ( IDENT | INTEGER ) ( COMMA ( IDENT | INTEGER ) )* RIGHTBRACE ;
    public final PhdlParser.pinList_return pinList() throws RecognitionException {
        PhdlParser.pinList_return retval = new PhdlParser.pinList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTBRACE94=null;
        Token set95=null;
        Token COMMA96=null;
        Token set97=null;
        Token RIGHTBRACE98=null;

        CommonTree LEFTBRACE94_tree=null;
        CommonTree set95_tree=null;
        CommonTree COMMA96_tree=null;
        CommonTree set97_tree=null;
        CommonTree RIGHTBRACE98_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:323:2: ( LEFTBRACE ( IDENT | INTEGER ) ( COMMA ( IDENT | INTEGER ) )* RIGHTBRACE )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:323:5: LEFTBRACE ( IDENT | INTEGER ) ( COMMA ( IDENT | INTEGER ) )* RIGHTBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACE94=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_pinList590); 
            set95=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||input.LA(1)==INTEGER ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set95));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:323:34: ( COMMA ( IDENT | INTEGER ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==COMMA) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:323:35: COMMA ( IDENT | INTEGER )
            	    {
            	    COMMA96=(Token)match(input,COMMA,FOLLOW_COMMA_in_pinList602); 
            	    set97=(Token)input.LT(1);
            	    if ( input.LA(1)==IDENT||input.LA(1)==INTEGER ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (CommonTree)adaptor.create(set97));
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            RIGHTBRACE98=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_pinList615); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:326:1: sliceList : LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTBRACKET ;
    public final PhdlParser.sliceList_return sliceList() throws RecognitionException {
        PhdlParser.sliceList_return retval = new PhdlParser.sliceList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTBRACKET99=null;
        Token INTEGER100=null;
        Token COLON101=null;
        Token INTEGER102=null;
        Token COMMA103=null;
        Token INTEGER104=null;
        Token COMMA105=null;
        Token INTEGER106=null;
        Token RIGHTBRACKET107=null;

        CommonTree LEFTBRACKET99_tree=null;
        CommonTree INTEGER100_tree=null;
        CommonTree COLON101_tree=null;
        CommonTree INTEGER102_tree=null;
        CommonTree COMMA103_tree=null;
        CommonTree INTEGER104_tree=null;
        CommonTree COMMA105_tree=null;
        CommonTree INTEGER106_tree=null;
        CommonTree RIGHTBRACKET107_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:332:2: ( LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTBRACKET )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:332:5: LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTBRACKET
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACKET99=(Token)match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList631); 
            LEFTBRACKET99_tree = (CommonTree)adaptor.create(LEFTBRACKET99);
            adaptor.addChild(root_0, LEFTBRACKET99_tree);

            INTEGER100=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList633); 
            INTEGER100_tree = (CommonTree)adaptor.create(INTEGER100);
            adaptor.addChild(root_0, INTEGER100_tree);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:332:25: ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==COLON) ) {
                alt27=1;
            }
            else if ( (LA27_0==COMMA||LA27_0==RIGHTBRACKET) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:332:26: ( COLON INTEGER )
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:332:26: ( COLON INTEGER )
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:332:27: COLON INTEGER
                    {
                    COLON101=(Token)match(input,COLON,FOLLOW_COLON_in_sliceList637); 
                    COLON101_tree = (CommonTree)adaptor.create(COLON101);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON101_tree, root_0);

                    INTEGER102=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList640); 
                    INTEGER102_tree = (CommonTree)adaptor.create(INTEGER102);
                    adaptor.addChild(root_0, INTEGER102_tree);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:332:45: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:332:45: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==COMMA) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:332:46: COMMA INTEGER ( COMMA INTEGER )*
                            {
                            COMMA103=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceList646); 
                            COMMA103_tree = (CommonTree)adaptor.create(COMMA103);
                            root_0 = (CommonTree)adaptor.becomeRoot(COMMA103_tree, root_0);

                            INTEGER104=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList649); 
                            INTEGER104_tree = (CommonTree)adaptor.create(INTEGER104);
                            adaptor.addChild(root_0, INTEGER104_tree);

                            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:332:61: ( COMMA INTEGER )*
                            loop25:
                            do {
                                int alt25=2;
                                int LA25_0 = input.LA(1);

                                if ( (LA25_0==COMMA) ) {
                                    alt25=1;
                                }


                                switch (alt25) {
                            	case 1 :
                            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:332:62: COMMA INTEGER
                            	    {
                            	    COMMA105=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceList652); 
                            	    INTEGER106=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList655); 
                            	    INTEGER106_tree = (CommonTree)adaptor.create(INTEGER106);
                            	    adaptor.addChild(root_0, INTEGER106_tree);


                            	    }
                            	    break;

                            	default :
                            	    break loop25;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }

            RIGHTBRACKET107=(Token)match(input,RIGHTBRACKET,FOLLOW_RIGHTBRACKET_in_sliceList662); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:335:1: sliceDecl : LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RIGHTBRACKET ;
    public final PhdlParser.sliceDecl_return sliceDecl() throws RecognitionException {
        PhdlParser.sliceDecl_return retval = new PhdlParser.sliceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTBRACKET108=null;
        Token INTEGER109=null;
        Token COLON110=null;
        Token INTEGER111=null;
        Token COMMA112=null;
        Token INTEGER113=null;
        Token RIGHTBRACKET114=null;

        CommonTree LEFTBRACKET108_tree=null;
        CommonTree INTEGER109_tree=null;
        CommonTree COLON110_tree=null;
        CommonTree INTEGER111_tree=null;
        CommonTree COMMA112_tree=null;
        CommonTree INTEGER113_tree=null;
        CommonTree RIGHTBRACKET114_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:340:2: ( LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RIGHTBRACKET )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:340:4: LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RIGHTBRACKET
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACKET108=(Token)match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceDecl676); 
            LEFTBRACKET108_tree = (CommonTree)adaptor.create(LEFTBRACKET108);
            adaptor.addChild(root_0, LEFTBRACKET108_tree);

            INTEGER109=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl678); 
            INTEGER109_tree = (CommonTree)adaptor.create(INTEGER109);
            adaptor.addChild(root_0, INTEGER109_tree);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:340:24: ( ( COLON INTEGER ) | ( COMMA INTEGER )+ )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==COLON) ) {
                alt29=1;
            }
            else if ( (LA29_0==COMMA) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:340:25: ( COLON INTEGER )
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:340:25: ( COLON INTEGER )
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:340:26: COLON INTEGER
                    {
                    COLON110=(Token)match(input,COLON,FOLLOW_COLON_in_sliceDecl682); 
                    COLON110_tree = (CommonTree)adaptor.create(COLON110);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON110_tree, root_0);

                    INTEGER111=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl685); 
                    INTEGER111_tree = (CommonTree)adaptor.create(INTEGER111);
                    adaptor.addChild(root_0, INTEGER111_tree);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:340:44: ( COMMA INTEGER )+
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:340:44: ( COMMA INTEGER )+
                    int cnt28=0;
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==COMMA) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:340:45: COMMA INTEGER
                    	    {
                    	    COMMA112=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceDecl691); 
                    	    COMMA112_tree = (CommonTree)adaptor.create(COMMA112);
                    	    root_0 = (CommonTree)adaptor.becomeRoot(COMMA112_tree, root_0);

                    	    INTEGER113=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl694); 
                    	    INTEGER113_tree = (CommonTree)adaptor.create(INTEGER113);
                    	    adaptor.addChild(root_0, INTEGER113_tree);


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt28 >= 1 ) break loop28;
                                EarlyExitException eee =
                                    new EarlyExitException(28, input);
                                throw eee;
                        }
                        cnt28++;
                    } while (true);


                    }
                    break;

            }

            RIGHTBRACKET114=(Token)match(input,RIGHTBRACKET,FOLLOW_RIGHTBRACKET_in_sliceDecl699); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:343:1: arrayList : LEFTPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTPAREN ;
    public final PhdlParser.arrayList_return arrayList() throws RecognitionException {
        PhdlParser.arrayList_return retval = new PhdlParser.arrayList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTPAREN115=null;
        Token INTEGER116=null;
        Token COLON117=null;
        Token INTEGER118=null;
        Token COMMA119=null;
        Token INTEGER120=null;
        Token COMMA121=null;
        Token INTEGER122=null;
        Token RIGHTPAREN123=null;

        CommonTree LEFTPAREN115_tree=null;
        CommonTree INTEGER116_tree=null;
        CommonTree COLON117_tree=null;
        CommonTree INTEGER118_tree=null;
        CommonTree COMMA119_tree=null;
        CommonTree INTEGER120_tree=null;
        CommonTree COMMA121_tree=null;
        CommonTree INTEGER122_tree=null;
        CommonTree RIGHTPAREN123_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:348:2: ( LEFTPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTPAREN )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:348:5: LEFTPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTPAREN115=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList715); 
            LEFTPAREN115_tree = (CommonTree)adaptor.create(LEFTPAREN115);
            adaptor.addChild(root_0, LEFTPAREN115_tree);

            INTEGER116=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList717); 
            INTEGER116_tree = (CommonTree)adaptor.create(INTEGER116);
            adaptor.addChild(root_0, INTEGER116_tree);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:348:23: ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==COLON) ) {
                alt32=1;
            }
            else if ( (LA32_0==COMMA||LA32_0==RIGHTPAREN) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:348:24: ( COLON INTEGER )
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:348:24: ( COLON INTEGER )
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:348:25: COLON INTEGER
                    {
                    COLON117=(Token)match(input,COLON,FOLLOW_COLON_in_arrayList721); 
                    COLON117_tree = (CommonTree)adaptor.create(COLON117);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON117_tree, root_0);

                    INTEGER118=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList724); 
                    INTEGER118_tree = (CommonTree)adaptor.create(INTEGER118);
                    adaptor.addChild(root_0, INTEGER118_tree);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:348:43: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:348:43: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==COMMA) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:348:44: COMMA INTEGER ( COMMA INTEGER )*
                            {
                            COMMA119=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayList730); 
                            COMMA119_tree = (CommonTree)adaptor.create(COMMA119);
                            root_0 = (CommonTree)adaptor.becomeRoot(COMMA119_tree, root_0);

                            INTEGER120=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList733); 
                            INTEGER120_tree = (CommonTree)adaptor.create(INTEGER120);
                            adaptor.addChild(root_0, INTEGER120_tree);

                            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:348:59: ( COMMA INTEGER )*
                            loop30:
                            do {
                                int alt30=2;
                                int LA30_0 = input.LA(1);

                                if ( (LA30_0==COMMA) ) {
                                    alt30=1;
                                }


                                switch (alt30) {
                            	case 1 :
                            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:348:60: COMMA INTEGER
                            	    {
                            	    COMMA121=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayList736); 
                            	    INTEGER122=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList739); 
                            	    INTEGER122_tree = (CommonTree)adaptor.create(INTEGER122);
                            	    adaptor.addChild(root_0, INTEGER122_tree);


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

            RIGHTPAREN123=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_arrayList746); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:351:1: arrayDecl : LEFTPAREN INTEGER COLON INTEGER RIGHTPAREN ;
    public final PhdlParser.arrayDecl_return arrayDecl() throws RecognitionException {
        PhdlParser.arrayDecl_return retval = new PhdlParser.arrayDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTPAREN124=null;
        Token INTEGER125=null;
        Token COLON126=null;
        Token INTEGER127=null;
        Token RIGHTPAREN128=null;

        CommonTree LEFTPAREN124_tree=null;
        CommonTree INTEGER125_tree=null;
        CommonTree COLON126_tree=null;
        CommonTree INTEGER127_tree=null;
        CommonTree RIGHTPAREN128_tree=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:356:2: ( LEFTPAREN INTEGER COLON INTEGER RIGHTPAREN )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\Phdl.g:356:4: LEFTPAREN INTEGER COLON INTEGER RIGHTPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTPAREN124=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayDecl760); 
            LEFTPAREN124_tree = (CommonTree)adaptor.create(LEFTPAREN124);
            adaptor.addChild(root_0, LEFTPAREN124_tree);

            INTEGER125=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayDecl762); 
            INTEGER125_tree = (CommonTree)adaptor.create(INTEGER125);
            adaptor.addChild(root_0, INTEGER125_tree);

            COLON126=(Token)match(input,COLON,FOLLOW_COLON_in_arrayDecl764); 
            COLON126_tree = (CommonTree)adaptor.create(COLON126);
            root_0 = (CommonTree)adaptor.becomeRoot(COLON126_tree, root_0);

            INTEGER127=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayDecl767); 
            INTEGER127_tree = (CommonTree)adaptor.create(INTEGER127);
            adaptor.addChild(root_0, INTEGER127_tree);

            RIGHTPAREN128=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_arrayDecl769); 

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


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\22\uffff";
    static final String DFA10_eofS =
        "\22\uffff";
    static final String DFA10_minS =
        "\1\4\2\uffff\1\13\1\7\2\uffff\1\17\2\4\1\12\2\17\1\13\1\24\1\12"+
        "\1\17\1\12";
    static final String DFA10_maxS =
        "\1\46\2\uffff\1\23\1\20\2\uffff\1\17\1\4\1\47\1\24\2\17\1\13\2"+
        "\24\1\17\1\24";
    static final String DFA10_acceptS =
        "\1\uffff\1\4\1\1\2\uffff\1\2\1\3\13\uffff";
    static final String DFA10_specialS =
        "\22\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\4\1\uffff\1\1\33\uffff\1\6\1\uffff\1\2\1\3\1\5",
            "",
            "",
            "\1\10\7\uffff\1\7",
            "\1\11\10\uffff\1\5",
            "",
            "",
            "\1\12",
            "\1\4",
            "\1\5\3\uffff\1\2\4\uffff\1\5\31\uffff\1\5",
            "\1\14\6\uffff\1\13\2\uffff\1\15",
            "\1\16",
            "\1\17",
            "\1\10",
            "\1\15",
            "\1\20\11\uffff\1\15",
            "\1\21",
            "\1\20\11\uffff\1\15"
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "()* loopback of 240:3: ( attributeAssignment | pinAssignment | infoStruct )*";
        }
    }
 

    public static final BitSet FOLLOW_designDecl_in_sourceText79 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_EOF_in_sourceText82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_designDecl95 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_designDecl98 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LEFTBRACE_in_designDecl100 = new BitSet(new long[]{0x0000000D90000050L});
    public static final BitSet FOLLOW_deviceDecl_in_designDecl107 = new BitSet(new long[]{0x0000000D90000050L});
    public static final BitSet FOLLOW_netDecl_in_designDecl111 = new BitSet(new long[]{0x0000000D90000050L});
    public static final BitSet FOLLOW_infoStruct_in_designDecl115 = new BitSet(new long[]{0x0000000D90000050L});
    public static final BitSet FOLLOW_instanceDecl_in_designDecl119 = new BitSet(new long[]{0x0000000D90000050L});
    public static final BitSet FOLLOW_netAssignment_in_designDecl123 = new BitSet(new long[]{0x0000000D90000050L});
    public static final BitSet FOLLOW_groupStruct_in_designDecl127 = new BitSet(new long[]{0x0000000D90000050L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_designDecl133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_deviceDecl148 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl151 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LEFTBRACE_in_deviceDecl153 = new BitSet(new long[]{0x0000000060000040L});
    public static final BitSet FOLLOW_attributeDecl_in_deviceDecl160 = new BitSet(new long[]{0x0000000060000040L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl164 = new BitSet(new long[]{0x0000000060000040L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_deviceDecl171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_attributeDecl186 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attributeDecl189 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_EQUALS_in_attributeDecl191 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_STRING_in_attributeDecl194 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeDecl196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_pinDecl210 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_sliceDecl_in_pinDecl213 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl216 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_EQUALS_in_pinDecl218 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_pinList_in_pinDecl221 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinDecl223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_type238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_netDecl251 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_sliceDecl_in_netDecl254 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl257 = new BitSet(new long[]{0x0000000000000620L});
    public static final BitSet FOLLOW_COMMA_in_netDecl260 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl262 = new BitSet(new long[]{0x0000000000000620L});
    public static final BitSet FOLLOW_netAttributes_in_netDecl266 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_SEMICOLON_in_netDecl269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACE_in_netAttributes284 = new BitSet(new long[]{0x0000000020000040L});
    public static final BitSet FOLLOW_attributeDecl_in_netAttributes287 = new BitSet(new long[]{0x0000000020000040L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_netAttributes290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_instanceDecl304 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_arrayDecl_in_instanceDecl307 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instanceDecl310 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_instanceDecl312 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instanceDecl315 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LEFTBRACE_in_instanceDecl317 = new BitSet(new long[]{0x0000007400000050L});
    public static final BitSet FOLLOW_attributeAssignment_in_instanceDecl323 = new BitSet(new long[]{0x0000007400000050L});
    public static final BitSet FOLLOW_pinAssignment_in_instanceDecl327 = new BitSet(new long[]{0x0000007400000050L});
    public static final BitSet FOLLOW_infoStruct_in_instanceDecl331 = new BitSet(new long[]{0x0000007400000050L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_instanceDecl337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_infoStruct352 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LEFTBRACE_in_infoStruct355 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_STRING_in_infoStruct358 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_infoStruct360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_groupStruct375 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_STRING_in_groupStruct378 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LEFTBRACE_in_groupStruct380 = new BitSet(new long[]{0x0000000100000050L});
    public static final BitSet FOLLOW_instanceDecl_in_groupStruct384 = new BitSet(new long[]{0x0000000100000050L});
    public static final BitSet FOLLOW_netAssignment_in_groupStruct388 = new BitSet(new long[]{0x0000000100000050L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_groupStruct392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_attributeAssignment407 = new BitSet(new long[]{0x0000002000000010L});
    public static final BitSet FOLLOW_attributeQualifier_in_attributeAssignment411 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attributeAssignment414 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_EQUALS_in_attributeAssignment416 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_STRING_in_attributeAssignment419 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeAssignment421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_attributeQualifier436 = new BitSet(new long[]{0x0000000000080800L});
    public static final BitSet FOLLOW_arrayList_in_attributeQualifier438 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_PERIOD_in_attributeQualifier441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_pinQualifier457 = new BitSet(new long[]{0x0000000000080800L});
    public static final BitSet FOLLOW_arrayList_in_pinQualifier465 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_PERIOD_in_pinQualifier468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pinQualifier_in_pinAssignment482 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinAssignment485 = new BitSet(new long[]{0x0000000000010080L});
    public static final BitSet FOLLOW_sliceList_in_pinAssignment487 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssignment490 = new BitSet(new long[]{0x0000008000002010L});
    public static final BitSet FOLLOW_concatenation_in_pinAssignment493 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinAssignment495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_netAssignment509 = new BitSet(new long[]{0x0000000000010080L});
    public static final BitSet FOLLOW_sliceList_in_netAssignment511 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_EQUALS_in_netAssignment514 = new BitSet(new long[]{0x0000008000002010L});
    public static final BitSet FOLLOW_concatenation_in_netAssignment517 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_SEMICOLON_in_netAssignment519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_concatenation536 = new BitSet(new long[]{0x0000000000011002L});
    public static final BitSet FOLLOW_sliceList_in_concatenation538 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_AMPERSAND_in_concatenation543 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation546 = new BitSet(new long[]{0x0000000000011002L});
    public static final BitSet FOLLOW_sliceList_in_concatenation548 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_LEFTANGLE_in_concatenation560 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation562 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_sliceList_in_concatenation564 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RIGHTANGLE_in_concatenation567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_concatenation575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACE_in_pinList590 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_set_in_pinList593 = new BitSet(new long[]{0x0000000000000440L});
    public static final BitSet FOLLOW_COMMA_in_pinList602 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_set_in_pinList605 = new BitSet(new long[]{0x0000000000000440L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_pinList615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList631 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList633 = new BitSet(new long[]{0x0000000000060400L});
    public static final BitSet FOLLOW_COLON_in_sliceList637 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList640 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_sliceList646 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList649 = new BitSet(new long[]{0x0000000000040400L});
    public static final BitSet FOLLOW_COMMA_in_sliceList652 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList655 = new BitSet(new long[]{0x0000000000040400L});
    public static final BitSet FOLLOW_RIGHTBRACKET_in_sliceList662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceDecl676 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl678 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COLON_in_sliceDecl682 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl685 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_sliceDecl691 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl694 = new BitSet(new long[]{0x0000000000040400L});
    public static final BitSet FOLLOW_RIGHTBRACKET_in_sliceDecl699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList715 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList717 = new BitSet(new long[]{0x0000000000120400L});
    public static final BitSet FOLLOW_COLON_in_arrayList721 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList724 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_arrayList730 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList733 = new BitSet(new long[]{0x0000000000100400L});
    public static final BitSet FOLLOW_COMMA_in_arrayList736 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList739 = new BitSet(new long[]{0x0000000000100400L});
    public static final BitSet FOLLOW_RIGHTPAREN_in_arrayList746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayDecl760 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayDecl762 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_arrayDecl764 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayDecl767 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RIGHTPAREN_in_arrayDecl769 = new BitSet(new long[]{0x0000000000000002L});

}