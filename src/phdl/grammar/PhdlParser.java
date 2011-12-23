// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g 2011-12-21 23:24:05

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "LEFTBRACE", "RIGHTBRACE", "EQUALS", "STRING", "SEMICOLON", "COMMA", "LEFTPAREN", "RIGHTPAREN", "PERIOD", "AMPERSAND", "LEFTANGLE", "RIGHTANGLE", "INTEGER", "LEFTBRACKET", "COLON", "RIGHTBRACKET", "CHAR", "DIGIT", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "INCLUDE", "'design'", "'device'", "'attr'", "'pin'", "'net'", "'inst'", "'of'", "'sub'", "'combine'", "'newattr'", "'this'", "'info'", "'group'", "'open'"
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
    public static final int LEFTBRACE=5;
    public static final int RIGHTBRACE=6;
    public static final int EQUALS=7;
    public static final int STRING=8;
    public static final int SEMICOLON=9;
    public static final int COMMA=10;
    public static final int LEFTPAREN=11;
    public static final int RIGHTPAREN=12;
    public static final int PERIOD=13;
    public static final int AMPERSAND=14;
    public static final int LEFTANGLE=15;
    public static final int RIGHTANGLE=16;
    public static final int INTEGER=17;
    public static final int LEFTBRACKET=18;
    public static final int COLON=19;
    public static final int RIGHTBRACKET=20;
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:157:1: sourceText : ( designDecl )+ EOF ;
    public final PhdlParser.sourceText_return sourceText() throws RecognitionException {
        PhdlParser.sourceText_return retval = new PhdlParser.sourceText_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF2=null;
        PhdlParser.designDecl_return designDecl1 = null;


        CommonTree EOF2_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:162:2: ( ( designDecl )+ EOF )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:162:4: ( designDecl )+ EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:162:4: ( designDecl )+
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:162:4: designDecl
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:165:1: designDecl : 'design' IDENT LEFTBRACE ( deviceDecl | netDecl | infoStruct | instanceDecl | netAssignment | groupStruct | subDesignInstance )* RIGHTBRACE ;
    public final PhdlParser.designDecl_return designDecl() throws RecognitionException {
        PhdlParser.designDecl_return retval = new PhdlParser.designDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal3=null;
        Token IDENT4=null;
        Token LEFTBRACE5=null;
        Token RIGHTBRACE13=null;
        PhdlParser.deviceDecl_return deviceDecl6 = null;

        PhdlParser.netDecl_return netDecl7 = null;

        PhdlParser.infoStruct_return infoStruct8 = null;

        PhdlParser.instanceDecl_return instanceDecl9 = null;

        PhdlParser.netAssignment_return netAssignment10 = null;

        PhdlParser.groupStruct_return groupStruct11 = null;

        PhdlParser.subDesignInstance_return subDesignInstance12 = null;


        CommonTree string_literal3_tree=null;
        CommonTree IDENT4_tree=null;
        CommonTree LEFTBRACE5_tree=null;
        CommonTree RIGHTBRACE13_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:173:2: ( 'design' IDENT LEFTBRACE ( deviceDecl | netDecl | infoStruct | instanceDecl | netAssignment | groupStruct | subDesignInstance )* RIGHTBRACE )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:173:4: 'design' IDENT LEFTBRACE ( deviceDecl | netDecl | infoStruct | instanceDecl | netAssignment | groupStruct | subDesignInstance )* RIGHTBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal3=(Token)match(input,27,FOLLOW_27_in_designDecl95); 
            string_literal3_tree = (CommonTree)adaptor.create(string_literal3);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal3_tree, root_0);

            IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_designDecl98); 
            IDENT4_tree = (CommonTree)adaptor.create(IDENT4);
            adaptor.addChild(root_0, IDENT4_tree);

            LEFTBRACE5=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_designDecl100); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:174:3: ( deviceDecl | netDecl | infoStruct | instanceDecl | netAssignment | groupStruct | subDesignInstance )*
            loop2:
            do {
                int alt2=8;
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
                case 38:
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
                case 39:
                    {
                    alt2=6;
                    }
                    break;
                case 34:
                    {
                    alt2=7;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:174:4: deviceDecl
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_designDecl107);
            	    deviceDecl6=deviceDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, deviceDecl6.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:174:17: netDecl
            	    {
            	    pushFollow(FOLLOW_netDecl_in_designDecl111);
            	    netDecl7=netDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netDecl7.getTree());

            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:174:27: infoStruct
            	    {
            	    pushFollow(FOLLOW_infoStruct_in_designDecl115);
            	    infoStruct8=infoStruct();

            	    state._fsp--;

            	    adaptor.addChild(root_0, infoStruct8.getTree());

            	    }
            	    break;
            	case 4 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:174:40: instanceDecl
            	    {
            	    pushFollow(FOLLOW_instanceDecl_in_designDecl119);
            	    instanceDecl9=instanceDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, instanceDecl9.getTree());

            	    }
            	    break;
            	case 5 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:174:55: netAssignment
            	    {
            	    pushFollow(FOLLOW_netAssignment_in_designDecl123);
            	    netAssignment10=netAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netAssignment10.getTree());

            	    }
            	    break;
            	case 6 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:174:71: groupStruct
            	    {
            	    pushFollow(FOLLOW_groupStruct_in_designDecl127);
            	    groupStruct11=groupStruct();

            	    state._fsp--;

            	    adaptor.addChild(root_0, groupStruct11.getTree());

            	    }
            	    break;
            	case 7 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:174:85: subDesignInstance
            	    {
            	    pushFollow(FOLLOW_subDesignInstance_in_designDecl131);
            	    subDesignInstance12=subDesignInstance();

            	    state._fsp--;

            	    adaptor.addChild(root_0, subDesignInstance12.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            RIGHTBRACE13=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_designDecl137); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:178:1: deviceDecl : 'device' IDENT LEFTBRACE ( attributeDecl | pinDecl )* RIGHTBRACE ;
    public final PhdlParser.deviceDecl_return deviceDecl() throws RecognitionException {
        PhdlParser.deviceDecl_return retval = new PhdlParser.deviceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal14=null;
        Token IDENT15=null;
        Token LEFTBRACE16=null;
        Token RIGHTBRACE19=null;
        PhdlParser.attributeDecl_return attributeDecl17 = null;

        PhdlParser.pinDecl_return pinDecl18 = null;


        CommonTree string_literal14_tree=null;
        CommonTree IDENT15_tree=null;
        CommonTree LEFTBRACE16_tree=null;
        CommonTree RIGHTBRACE19_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:185:2: ( 'device' IDENT LEFTBRACE ( attributeDecl | pinDecl )* RIGHTBRACE )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:185:4: 'device' IDENT LEFTBRACE ( attributeDecl | pinDecl )* RIGHTBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal14=(Token)match(input,28,FOLLOW_28_in_deviceDecl152); 
            string_literal14_tree = (CommonTree)adaptor.create(string_literal14);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal14_tree, root_0);

            IDENT15=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl155); 
            IDENT15_tree = (CommonTree)adaptor.create(IDENT15);
            adaptor.addChild(root_0, IDENT15_tree);

            LEFTBRACE16=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_deviceDecl157); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:186:3: ( attributeDecl | pinDecl )*
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:186:5: attributeDecl
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_deviceDecl164);
            	    attributeDecl17=attributeDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeDecl17.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:186:21: pinDecl
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl168);
            	    pinDecl18=pinDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinDecl18.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            RIGHTBRACE19=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_deviceDecl175); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:190:1: attributeDecl : 'attr' IDENT EQUALS STRING SEMICOLON ;
    public final PhdlParser.attributeDecl_return attributeDecl() throws RecognitionException {
        PhdlParser.attributeDecl_return retval = new PhdlParser.attributeDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal20=null;
        Token IDENT21=null;
        Token EQUALS22=null;
        Token STRING23=null;
        Token SEMICOLON24=null;

        CommonTree string_literal20_tree=null;
        CommonTree IDENT21_tree=null;
        CommonTree EQUALS22_tree=null;
        CommonTree STRING23_tree=null;
        CommonTree SEMICOLON24_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:195:2: ( 'attr' IDENT EQUALS STRING SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:195:4: 'attr' IDENT EQUALS STRING SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal20=(Token)match(input,29,FOLLOW_29_in_attributeDecl190); 
            string_literal20_tree = (CommonTree)adaptor.create(string_literal20);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal20_tree, root_0);

            IDENT21=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeDecl193); 
            IDENT21_tree = (CommonTree)adaptor.create(IDENT21);
            adaptor.addChild(root_0, IDENT21_tree);

            EQUALS22=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeDecl195); 
            STRING23=(Token)match(input,STRING,FOLLOW_STRING_in_attributeDecl198); 
            STRING23_tree = (CommonTree)adaptor.create(STRING23);
            adaptor.addChild(root_0, STRING23_tree);

            SEMICOLON24=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeDecl200); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:198:1: pinDecl : type ( sliceDecl )? IDENT EQUALS pinList SEMICOLON ;
    public final PhdlParser.pinDecl_return pinDecl() throws RecognitionException {
        PhdlParser.pinDecl_return retval = new PhdlParser.pinDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT27=null;
        Token EQUALS28=null;
        Token SEMICOLON30=null;
        PhdlParser.type_return type25 = null;

        PhdlParser.sliceDecl_return sliceDecl26 = null;

        PhdlParser.pinList_return pinList29 = null;


        CommonTree IDENT27_tree=null;
        CommonTree EQUALS28_tree=null;
        CommonTree SEMICOLON30_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:203:2: ( type ( sliceDecl )? IDENT EQUALS pinList SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:203:4: type ( sliceDecl )? IDENT EQUALS pinList SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_type_in_pinDecl214);
            type25=type();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(type25.getTree(), root_0);
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:203:10: ( sliceDecl )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==LEFTBRACKET) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:203:10: sliceDecl
                    {
                    pushFollow(FOLLOW_sliceDecl_in_pinDecl217);
                    sliceDecl26=sliceDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceDecl26.getTree());

                    }
                    break;

            }

            IDENT27=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinDecl220); 
            IDENT27_tree = (CommonTree)adaptor.create(IDENT27);
            adaptor.addChild(root_0, IDENT27_tree);

            EQUALS28=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinDecl222); 
            pushFollow(FOLLOW_pinList_in_pinDecl225);
            pinList29=pinList();

            state._fsp--;

            adaptor.addChild(root_0, pinList29.getTree());
            SEMICOLON30=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinDecl227); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:206:1: type : 'pin' ;
    public final PhdlParser.type_return type() throws RecognitionException {
        PhdlParser.type_return retval = new PhdlParser.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal31=null;

        CommonTree string_literal31_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:210:2: ( 'pin' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:210:4: 'pin'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal31=(Token)match(input,30,FOLLOW_30_in_type242); 
            string_literal31_tree = (CommonTree)adaptor.create(string_literal31);
            adaptor.addChild(root_0, string_literal31_tree);


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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:213:1: netDecl : 'net' ( sliceDecl )? IDENT ( COMMA IDENT )* ( netAttributes | SEMICOLON ) ;
    public final PhdlParser.netDecl_return netDecl() throws RecognitionException {
        PhdlParser.netDecl_return retval = new PhdlParser.netDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal32=null;
        Token IDENT34=null;
        Token COMMA35=null;
        Token IDENT36=null;
        Token SEMICOLON38=null;
        PhdlParser.sliceDecl_return sliceDecl33 = null;

        PhdlParser.netAttributes_return netAttributes37 = null;


        CommonTree string_literal32_tree=null;
        CommonTree IDENT34_tree=null;
        CommonTree COMMA35_tree=null;
        CommonTree IDENT36_tree=null;
        CommonTree SEMICOLON38_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:218:2: ( 'net' ( sliceDecl )? IDENT ( COMMA IDENT )* ( netAttributes | SEMICOLON ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:218:4: 'net' ( sliceDecl )? IDENT ( COMMA IDENT )* ( netAttributes | SEMICOLON )
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal32=(Token)match(input,31,FOLLOW_31_in_netDecl255); 
            string_literal32_tree = (CommonTree)adaptor.create(string_literal32);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal32_tree, root_0);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:218:11: ( sliceDecl )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==LEFTBRACKET) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:218:11: sliceDecl
                    {
                    pushFollow(FOLLOW_sliceDecl_in_netDecl258);
                    sliceDecl33=sliceDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceDecl33.getTree());

                    }
                    break;

            }

            IDENT34=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl261); 
            IDENT34_tree = (CommonTree)adaptor.create(IDENT34);
            adaptor.addChild(root_0, IDENT34_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:218:28: ( COMMA IDENT )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==COMMA) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:218:29: COMMA IDENT
            	    {
            	    COMMA35=(Token)match(input,COMMA,FOLLOW_COMMA_in_netDecl264); 
            	    COMMA35_tree = (CommonTree)adaptor.create(COMMA35);
            	    adaptor.addChild(root_0, COMMA35_tree);

            	    IDENT36=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl266); 
            	    IDENT36_tree = (CommonTree)adaptor.create(IDENT36);
            	    adaptor.addChild(root_0, IDENT36_tree);


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:218:43: ( netAttributes | SEMICOLON )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==LEFTBRACE) ) {
                alt7=1;
            }
            else if ( (LA7_0==SEMICOLON) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:218:44: netAttributes
                    {
                    pushFollow(FOLLOW_netAttributes_in_netDecl271);
                    netAttributes37=netAttributes();

                    state._fsp--;

                    adaptor.addChild(root_0, netAttributes37.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:218:60: SEMICOLON
                    {
                    SEMICOLON38=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netDecl275); 

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
    // $ANTLR end "netDecl"

    public static class netAttributes_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "netAttributes"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:221:1: netAttributes : LEFTBRACE ( attributeDecl )* RIGHTBRACE ;
    public final PhdlParser.netAttributes_return netAttributes() throws RecognitionException {
        PhdlParser.netAttributes_return retval = new PhdlParser.netAttributes_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTBRACE39=null;
        Token RIGHTBRACE41=null;
        PhdlParser.attributeDecl_return attributeDecl40 = null;


        CommonTree LEFTBRACE39_tree=null;
        CommonTree RIGHTBRACE41_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:227:2: ( LEFTBRACE ( attributeDecl )* RIGHTBRACE )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:227:4: LEFTBRACE ( attributeDecl )* RIGHTBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACE39=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_netAttributes291); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:227:15: ( attributeDecl )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==29) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:227:15: attributeDecl
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_netAttributes294);
            	    attributeDecl40=attributeDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeDecl40.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            RIGHTBRACE41=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_netAttributes297); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:230:1: instanceDecl : 'inst' ( arrayDecl )? IDENT 'of' IDENT LEFTBRACE ( attributeAssignment | pinAssignment | infoStruct )* RIGHTBRACE ;
    public final PhdlParser.instanceDecl_return instanceDecl() throws RecognitionException {
        PhdlParser.instanceDecl_return retval = new PhdlParser.instanceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal42=null;
        Token IDENT44=null;
        Token string_literal45=null;
        Token IDENT46=null;
        Token LEFTBRACE47=null;
        Token RIGHTBRACE51=null;
        PhdlParser.arrayDecl_return arrayDecl43 = null;

        PhdlParser.attributeAssignment_return attributeAssignment48 = null;

        PhdlParser.pinAssignment_return pinAssignment49 = null;

        PhdlParser.infoStruct_return infoStruct50 = null;


        CommonTree string_literal42_tree=null;
        CommonTree IDENT44_tree=null;
        CommonTree string_literal45_tree=null;
        CommonTree IDENT46_tree=null;
        CommonTree LEFTBRACE47_tree=null;
        CommonTree RIGHTBRACE51_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:239:2: ( 'inst' ( arrayDecl )? IDENT 'of' IDENT LEFTBRACE ( attributeAssignment | pinAssignment | infoStruct )* RIGHTBRACE )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:239:4: 'inst' ( arrayDecl )? IDENT 'of' IDENT LEFTBRACE ( attributeAssignment | pinAssignment | infoStruct )* RIGHTBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal42=(Token)match(input,32,FOLLOW_32_in_instanceDecl311); 
            string_literal42_tree = (CommonTree)adaptor.create(string_literal42);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal42_tree, root_0);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:239:12: ( arrayDecl )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==LEFTPAREN) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:239:12: arrayDecl
                    {
                    pushFollow(FOLLOW_arrayDecl_in_instanceDecl314);
                    arrayDecl43=arrayDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayDecl43.getTree());

                    }
                    break;

            }

            IDENT44=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceDecl317); 
            IDENT44_tree = (CommonTree)adaptor.create(IDENT44);
            adaptor.addChild(root_0, IDENT44_tree);

            string_literal45=(Token)match(input,33,FOLLOW_33_in_instanceDecl319); 
            IDENT46=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceDecl322); 
            IDENT46_tree = (CommonTree)adaptor.create(IDENT46);
            adaptor.addChild(root_0, IDENT46_tree);

            LEFTBRACE47=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_instanceDecl324); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:240:3: ( attributeAssignment | pinAssignment | infoStruct )*
            loop10:
            do {
                int alt10=4;
                alt10 = dfa10.predict(input);
                switch (alt10) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:240:4: attributeAssignment
            	    {
            	    pushFollow(FOLLOW_attributeAssignment_in_instanceDecl330);
            	    attributeAssignment48=attributeAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeAssignment48.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:240:26: pinAssignment
            	    {
            	    pushFollow(FOLLOW_pinAssignment_in_instanceDecl334);
            	    pinAssignment49=pinAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinAssignment49.getTree());

            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:240:42: infoStruct
            	    {
            	    pushFollow(FOLLOW_infoStruct_in_instanceDecl338);
            	    infoStruct50=infoStruct();

            	    state._fsp--;

            	    adaptor.addChild(root_0, infoStruct50.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            RIGHTBRACE51=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_instanceDecl344); 

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

    public static class subDesignInstance_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subDesignInstance"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:243:1: subDesignInstance : 'sub' ( arrayDecl )? IDENT 'of' IDENT LEFTBRACE ( subAssignment | infoStruct )* RIGHTBRACE ;
    public final PhdlParser.subDesignInstance_return subDesignInstance() throws RecognitionException {
        PhdlParser.subDesignInstance_return retval = new PhdlParser.subDesignInstance_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal52=null;
        Token IDENT54=null;
        Token string_literal55=null;
        Token IDENT56=null;
        Token LEFTBRACE57=null;
        Token RIGHTBRACE60=null;
        PhdlParser.arrayDecl_return arrayDecl53 = null;

        PhdlParser.subAssignment_return subAssignment58 = null;

        PhdlParser.infoStruct_return infoStruct59 = null;


        CommonTree string_literal52_tree=null;
        CommonTree IDENT54_tree=null;
        CommonTree string_literal55_tree=null;
        CommonTree IDENT56_tree=null;
        CommonTree LEFTBRACE57_tree=null;
        CommonTree RIGHTBRACE60_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:248:3: ( 'sub' ( arrayDecl )? IDENT 'of' IDENT LEFTBRACE ( subAssignment | infoStruct )* RIGHTBRACE )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:248:5: 'sub' ( arrayDecl )? IDENT 'of' IDENT LEFTBRACE ( subAssignment | infoStruct )* RIGHTBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal52=(Token)match(input,34,FOLLOW_34_in_subDesignInstance358); 
            string_literal52_tree = (CommonTree)adaptor.create(string_literal52);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal52_tree, root_0);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:248:12: ( arrayDecl )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==LEFTPAREN) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:248:12: arrayDecl
                    {
                    pushFollow(FOLLOW_arrayDecl_in_subDesignInstance361);
                    arrayDecl53=arrayDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayDecl53.getTree());

                    }
                    break;

            }

            IDENT54=(Token)match(input,IDENT,FOLLOW_IDENT_in_subDesignInstance364); 
            IDENT54_tree = (CommonTree)adaptor.create(IDENT54);
            adaptor.addChild(root_0, IDENT54_tree);

            string_literal55=(Token)match(input,33,FOLLOW_33_in_subDesignInstance366); 
            IDENT56=(Token)match(input,IDENT,FOLLOW_IDENT_in_subDesignInstance369); 
            IDENT56_tree = (CommonTree)adaptor.create(IDENT56);
            adaptor.addChild(root_0, IDENT56_tree);

            LEFTBRACE57=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_subDesignInstance371); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:249:5: ( subAssignment | infoStruct )*
            loop12:
            do {
                int alt12=3;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==IDENT||(LA12_0>=35 && LA12_0<=37)) ) {
                    alt12=1;
                }
                else if ( (LA12_0==38) ) {
                    alt12=2;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:249:6: subAssignment
            	    {
            	    pushFollow(FOLLOW_subAssignment_in_subDesignInstance379);
            	    subAssignment58=subAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, subAssignment58.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:249:22: infoStruct
            	    {
            	    pushFollow(FOLLOW_infoStruct_in_subDesignInstance383);
            	    infoStruct59=infoStruct();

            	    state._fsp--;

            	    adaptor.addChild(root_0, infoStruct59.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            RIGHTBRACE60=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_subDesignInstance391); 

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
    // $ANTLR end "subDesignInstance"

    public static class subAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subAssignment"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:253:1: subAssignment : ( portAssignment | subAttrAssignment );
    public final PhdlParser.subAssignment_return subAssignment() throws RecognitionException {
        PhdlParser.subAssignment_return retval = new PhdlParser.subAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        PhdlParser.portAssignment_return portAssignment61 = null;

        PhdlParser.subAttrAssignment_return subAttrAssignment62 = null;



        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:257:3: ( portAssignment | subAttrAssignment )
            int alt13=2;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:257:5: portAssignment
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_portAssignment_in_subAssignment407);
                    portAssignment61=portAssignment();

                    state._fsp--;

                    adaptor.addChild(root_0, portAssignment61.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:258:5: subAttrAssignment
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_subAttrAssignment_in_subAssignment413);
                    subAttrAssignment62=subAttrAssignment();

                    state._fsp--;

                    adaptor.addChild(root_0, subAttrAssignment62.getTree());

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
    // $ANTLR end "subAssignment"

    public static class portAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "portAssignment"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:261:1: portAssignment : ( combineQualifier | pinSpecifier ) EQUALS concatenation SEMICOLON ;
    public final PhdlParser.portAssignment_return portAssignment() throws RecognitionException {
        PhdlParser.portAssignment_return retval = new PhdlParser.portAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQUALS65=null;
        Token SEMICOLON67=null;
        PhdlParser.combineQualifier_return combineQualifier63 = null;

        PhdlParser.pinSpecifier_return pinSpecifier64 = null;

        PhdlParser.concatenation_return concatenation66 = null;


        CommonTree EQUALS65_tree=null;
        CommonTree SEMICOLON67_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:262:3: ( ( combineQualifier | pinSpecifier ) EQUALS concatenation SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:262:5: ( combineQualifier | pinSpecifier ) EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:262:5: ( combineQualifier | pinSpecifier )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==35) ) {
                alt14=1;
            }
            else if ( (LA14_0==IDENT||LA14_0==37) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:262:6: combineQualifier
                    {
                    pushFollow(FOLLOW_combineQualifier_in_portAssignment429);
                    combineQualifier63=combineQualifier();

                    state._fsp--;

                    adaptor.addChild(root_0, combineQualifier63.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:262:25: pinSpecifier
                    {
                    pushFollow(FOLLOW_pinSpecifier_in_portAssignment433);
                    pinSpecifier64=pinSpecifier();

                    state._fsp--;

                    adaptor.addChild(root_0, pinSpecifier64.getTree());

                    }
                    break;

            }

            EQUALS65=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_portAssignment436); 
            EQUALS65_tree = (CommonTree)adaptor.create(EQUALS65);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS65_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_portAssignment439);
            concatenation66=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation66.getTree());
            SEMICOLON67=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_portAssignment441); 

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
    // $ANTLR end "portAssignment"

    public static class combineQualifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "combineQualifier"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:265:1: combineQualifier : 'combine' LEFTPAREN pinSpecifier RIGHTPAREN ;
    public final PhdlParser.combineQualifier_return combineQualifier() throws RecognitionException {
        PhdlParser.combineQualifier_return retval = new PhdlParser.combineQualifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal68=null;
        Token LEFTPAREN69=null;
        Token RIGHTPAREN71=null;
        PhdlParser.pinSpecifier_return pinSpecifier70 = null;


        CommonTree string_literal68_tree=null;
        CommonTree LEFTPAREN69_tree=null;
        CommonTree RIGHTPAREN71_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:266:3: ( 'combine' LEFTPAREN pinSpecifier RIGHTPAREN )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:266:5: 'combine' LEFTPAREN pinSpecifier RIGHTPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal68=(Token)match(input,35,FOLLOW_35_in_combineQualifier455); 
            string_literal68_tree = (CommonTree)adaptor.create(string_literal68);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal68_tree, root_0);

            LEFTPAREN69=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_combineQualifier458); 
            pushFollow(FOLLOW_pinSpecifier_in_combineQualifier461);
            pinSpecifier70=pinSpecifier();

            state._fsp--;

            adaptor.addChild(root_0, pinSpecifier70.getTree());
            RIGHTPAREN71=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_combineQualifier463); 

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
    // $ANTLR end "combineQualifier"

    public static class pinSpecifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pinSpecifier"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:269:1: pinSpecifier : ( arrayQualifier )? IDENT ( sliceList )? ;
    public final PhdlParser.pinSpecifier_return pinSpecifier() throws RecognitionException {
        PhdlParser.pinSpecifier_return retval = new PhdlParser.pinSpecifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT73=null;
        PhdlParser.arrayQualifier_return arrayQualifier72 = null;

        PhdlParser.sliceList_return sliceList74 = null;


        CommonTree IDENT73_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:270:3: ( ( arrayQualifier )? IDENT ( sliceList )? )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:270:5: ( arrayQualifier )? IDENT ( sliceList )?
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:270:5: ( arrayQualifier )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==37) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:270:5: arrayQualifier
                    {
                    pushFollow(FOLLOW_arrayQualifier_in_pinSpecifier479);
                    arrayQualifier72=arrayQualifier();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayQualifier72.getTree());

                    }
                    break;

            }

            IDENT73=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinSpecifier482); 
            IDENT73_tree = (CommonTree)adaptor.create(IDENT73);
            root_0 = (CommonTree)adaptor.becomeRoot(IDENT73_tree, root_0);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:270:28: ( sliceList )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==LEFTBRACKET) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:270:28: sliceList
                    {
                    pushFollow(FOLLOW_sliceList_in_pinSpecifier485);
                    sliceList74=sliceList();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceList74.getTree());

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
    // $ANTLR end "pinSpecifier"

    public static class subAttrAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subAttrAssignment"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:273:1: subAttrAssignment : ( 'newattr' )? ( arrayQualifier )? ( instSpecifier )* IDENT EQUALS STRING SEMICOLON ;
    public final PhdlParser.subAttrAssignment_return subAttrAssignment() throws RecognitionException {
        PhdlParser.subAttrAssignment_return retval = new PhdlParser.subAttrAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal75=null;
        Token IDENT78=null;
        Token EQUALS79=null;
        Token STRING80=null;
        Token SEMICOLON81=null;
        PhdlParser.arrayQualifier_return arrayQualifier76 = null;

        PhdlParser.instSpecifier_return instSpecifier77 = null;


        CommonTree string_literal75_tree=null;
        CommonTree IDENT78_tree=null;
        CommonTree EQUALS79_tree=null;
        CommonTree STRING80_tree=null;
        CommonTree SEMICOLON81_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:274:3: ( ( 'newattr' )? ( arrayQualifier )? ( instSpecifier )* IDENT EQUALS STRING SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:274:5: ( 'newattr' )? ( arrayQualifier )? ( instSpecifier )* IDENT EQUALS STRING SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:274:5: ( 'newattr' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==36) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:274:5: 'newattr'
                    {
                    string_literal75=(Token)match(input,36,FOLLOW_36_in_subAttrAssignment499); 
                    string_literal75_tree = (CommonTree)adaptor.create(string_literal75);
                    adaptor.addChild(root_0, string_literal75_tree);


                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:274:16: ( arrayQualifier )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==37) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:274:16: arrayQualifier
                    {
                    pushFollow(FOLLOW_arrayQualifier_in_subAttrAssignment502);
                    arrayQualifier76=arrayQualifier();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayQualifier76.getTree());

                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:274:32: ( instSpecifier )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==IDENT) ) {
                    int LA19_1 = input.LA(2);

                    if ( (LA19_1==LEFTPAREN||LA19_1==PERIOD) ) {
                        alt19=1;
                    }


                }


                switch (alt19) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:274:32: instSpecifier
            	    {
            	    pushFollow(FOLLOW_instSpecifier_in_subAttrAssignment505);
            	    instSpecifier77=instSpecifier();

            	    state._fsp--;

            	    adaptor.addChild(root_0, instSpecifier77.getTree());

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            IDENT78=(Token)match(input,IDENT,FOLLOW_IDENT_in_subAttrAssignment508); 
            IDENT78_tree = (CommonTree)adaptor.create(IDENT78);
            adaptor.addChild(root_0, IDENT78_tree);

            EQUALS79=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_subAttrAssignment510); 
            EQUALS79_tree = (CommonTree)adaptor.create(EQUALS79);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS79_tree, root_0);

            STRING80=(Token)match(input,STRING,FOLLOW_STRING_in_subAttrAssignment513); 
            STRING80_tree = (CommonTree)adaptor.create(STRING80);
            adaptor.addChild(root_0, STRING80_tree);

            SEMICOLON81=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_subAttrAssignment515); 

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
    // $ANTLR end "subAttrAssignment"

    public static class arrayQualifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arrayQualifier"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:277:1: arrayQualifier : 'this' ( arrayList )? PERIOD ;
    public final PhdlParser.arrayQualifier_return arrayQualifier() throws RecognitionException {
        PhdlParser.arrayQualifier_return retval = new PhdlParser.arrayQualifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal82=null;
        Token PERIOD84=null;
        PhdlParser.arrayList_return arrayList83 = null;


        CommonTree string_literal82_tree=null;
        CommonTree PERIOD84_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:278:3: ( 'this' ( arrayList )? PERIOD )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:278:5: 'this' ( arrayList )? PERIOD
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal82=(Token)match(input,37,FOLLOW_37_in_arrayQualifier532); 
            string_literal82_tree = (CommonTree)adaptor.create(string_literal82);
            adaptor.addChild(root_0, string_literal82_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:278:12: ( arrayList )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==LEFTPAREN) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:278:12: arrayList
                    {
                    pushFollow(FOLLOW_arrayList_in_arrayQualifier534);
                    arrayList83=arrayList();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayList83.getTree());

                    }
                    break;

            }

            PERIOD84=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_arrayQualifier537); 
            PERIOD84_tree = (CommonTree)adaptor.create(PERIOD84);
            adaptor.addChild(root_0, PERIOD84_tree);


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
    // $ANTLR end "arrayQualifier"

    public static class instSpecifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "instSpecifier"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:281:1: instSpecifier : IDENT ( arrayList )? PERIOD ;
    public final PhdlParser.instSpecifier_return instSpecifier() throws RecognitionException {
        PhdlParser.instSpecifier_return retval = new PhdlParser.instSpecifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT85=null;
        Token PERIOD87=null;
        PhdlParser.arrayList_return arrayList86 = null;


        CommonTree IDENT85_tree=null;
        CommonTree PERIOD87_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:282:3: ( IDENT ( arrayList )? PERIOD )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:282:5: IDENT ( arrayList )? PERIOD
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT85=(Token)match(input,IDENT,FOLLOW_IDENT_in_instSpecifier550); 
            IDENT85_tree = (CommonTree)adaptor.create(IDENT85);
            adaptor.addChild(root_0, IDENT85_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:282:11: ( arrayList )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==LEFTPAREN) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:282:11: arrayList
                    {
                    pushFollow(FOLLOW_arrayList_in_instSpecifier552);
                    arrayList86=arrayList();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayList86.getTree());

                    }
                    break;

            }

            PERIOD87=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_instSpecifier555); 
            PERIOD87_tree = (CommonTree)adaptor.create(PERIOD87);
            root_0 = (CommonTree)adaptor.becomeRoot(PERIOD87_tree, root_0);


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
    // $ANTLR end "instSpecifier"

    public static class infoStruct_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "infoStruct"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:285:1: infoStruct : 'info' LEFTBRACE STRING RIGHTBRACE ;
    public final PhdlParser.infoStruct_return infoStruct() throws RecognitionException {
        PhdlParser.infoStruct_return retval = new PhdlParser.infoStruct_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal88=null;
        Token LEFTBRACE89=null;
        Token STRING90=null;
        Token RIGHTBRACE91=null;

        CommonTree string_literal88_tree=null;
        CommonTree LEFTBRACE89_tree=null;
        CommonTree STRING90_tree=null;
        CommonTree RIGHTBRACE91_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:290:2: ( 'info' LEFTBRACE STRING RIGHTBRACE )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:290:5: 'info' LEFTBRACE STRING RIGHTBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal88=(Token)match(input,38,FOLLOW_38_in_infoStruct571); 
            string_literal88_tree = (CommonTree)adaptor.create(string_literal88);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal88_tree, root_0);

            LEFTBRACE89=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_infoStruct574); 
            STRING90=(Token)match(input,STRING,FOLLOW_STRING_in_infoStruct577); 
            STRING90_tree = (CommonTree)adaptor.create(STRING90);
            adaptor.addChild(root_0, STRING90_tree);

            RIGHTBRACE91=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_infoStruct579); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:293:1: groupStruct : 'group' STRING LEFTBRACE ( instanceDecl | netAssignment )* RIGHTBRACE ;
    public final PhdlParser.groupStruct_return groupStruct() throws RecognitionException {
        PhdlParser.groupStruct_return retval = new PhdlParser.groupStruct_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal92=null;
        Token STRING93=null;
        Token LEFTBRACE94=null;
        Token RIGHTBRACE97=null;
        PhdlParser.instanceDecl_return instanceDecl95 = null;

        PhdlParser.netAssignment_return netAssignment96 = null;


        CommonTree string_literal92_tree=null;
        CommonTree STRING93_tree=null;
        CommonTree LEFTBRACE94_tree=null;
        CommonTree RIGHTBRACE97_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:294:2: ( 'group' STRING LEFTBRACE ( instanceDecl | netAssignment )* RIGHTBRACE )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:294:5: 'group' STRING LEFTBRACE ( instanceDecl | netAssignment )* RIGHTBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal92=(Token)match(input,39,FOLLOW_39_in_groupStruct594); 
            string_literal92_tree = (CommonTree)adaptor.create(string_literal92);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal92_tree, root_0);

            STRING93=(Token)match(input,STRING,FOLLOW_STRING_in_groupStruct597); 
            STRING93_tree = (CommonTree)adaptor.create(STRING93);
            adaptor.addChild(root_0, STRING93_tree);

            LEFTBRACE94=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_groupStruct599); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:294:32: ( instanceDecl | netAssignment )*
            loop22:
            do {
                int alt22=3;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==32) ) {
                    alt22=1;
                }
                else if ( (LA22_0==IDENT) ) {
                    alt22=2;
                }


                switch (alt22) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:294:33: instanceDecl
            	    {
            	    pushFollow(FOLLOW_instanceDecl_in_groupStruct603);
            	    instanceDecl95=instanceDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, instanceDecl95.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:294:48: netAssignment
            	    {
            	    pushFollow(FOLLOW_netAssignment_in_groupStruct607);
            	    netAssignment96=netAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netAssignment96.getTree());

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            RIGHTBRACE97=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_groupStruct611); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:297:1: attributeAssignment : ( 'newattr' )? ( attributeQualifier )? IDENT EQUALS STRING SEMICOLON ;
    public final PhdlParser.attributeAssignment_return attributeAssignment() throws RecognitionException {
        PhdlParser.attributeAssignment_return retval = new PhdlParser.attributeAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal98=null;
        Token IDENT100=null;
        Token EQUALS101=null;
        Token STRING102=null;
        Token SEMICOLON103=null;
        PhdlParser.attributeQualifier_return attributeQualifier99 = null;


        CommonTree string_literal98_tree=null;
        CommonTree IDENT100_tree=null;
        CommonTree EQUALS101_tree=null;
        CommonTree STRING102_tree=null;
        CommonTree SEMICOLON103_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:308:2: ( ( 'newattr' )? ( attributeQualifier )? IDENT EQUALS STRING SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:308:4: ( 'newattr' )? ( attributeQualifier )? IDENT EQUALS STRING SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:308:4: ( 'newattr' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==36) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:308:5: 'newattr'
                    {
                    string_literal98=(Token)match(input,36,FOLLOW_36_in_attributeAssignment626); 
                    string_literal98_tree = (CommonTree)adaptor.create(string_literal98);
                    adaptor.addChild(root_0, string_literal98_tree);


                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:308:17: ( attributeQualifier )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==37) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:308:17: attributeQualifier
                    {
                    pushFollow(FOLLOW_attributeQualifier_in_attributeAssignment630);
                    attributeQualifier99=attributeQualifier();

                    state._fsp--;

                    adaptor.addChild(root_0, attributeQualifier99.getTree());

                    }
                    break;

            }

            IDENT100=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeAssignment633); 
            IDENT100_tree = (CommonTree)adaptor.create(IDENT100);
            adaptor.addChild(root_0, IDENT100_tree);

            EQUALS101=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeAssignment635); 
            EQUALS101_tree = (CommonTree)adaptor.create(EQUALS101);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS101_tree, root_0);

            STRING102=(Token)match(input,STRING,FOLLOW_STRING_in_attributeAssignment638); 
            STRING102_tree = (CommonTree)adaptor.create(STRING102);
            adaptor.addChild(root_0, STRING102_tree);

            SEMICOLON103=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeAssignment640); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:311:1: attributeQualifier : 'this' ( arrayList )? PERIOD ;
    public final PhdlParser.attributeQualifier_return attributeQualifier() throws RecognitionException {
        PhdlParser.attributeQualifier_return retval = new PhdlParser.attributeQualifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal104=null;
        Token PERIOD106=null;
        PhdlParser.arrayList_return arrayList105 = null;


        CommonTree string_literal104_tree=null;
        CommonTree PERIOD106_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:317:2: ( 'this' ( arrayList )? PERIOD )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:317:4: 'this' ( arrayList )? PERIOD
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal104=(Token)match(input,37,FOLLOW_37_in_attributeQualifier655); 
            string_literal104_tree = (CommonTree)adaptor.create(string_literal104);
            adaptor.addChild(root_0, string_literal104_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:317:11: ( arrayList )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==LEFTPAREN) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:317:11: arrayList
                    {
                    pushFollow(FOLLOW_arrayList_in_attributeQualifier657);
                    arrayList105=arrayList();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayList105.getTree());

                    }
                    break;

            }

            PERIOD106=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_attributeQualifier660); 
            PERIOD106_tree = (CommonTree)adaptor.create(PERIOD106);
            root_0 = (CommonTree)adaptor.becomeRoot(PERIOD106_tree, root_0);


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

    public static class pinAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pinAssignment"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:320:1: pinAssignment : pinDescription EQUALS concatenation SEMICOLON ;
    public final PhdlParser.pinAssignment_return pinAssignment() throws RecognitionException {
        PhdlParser.pinAssignment_return retval = new PhdlParser.pinAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQUALS108=null;
        Token SEMICOLON110=null;
        PhdlParser.pinDescription_return pinDescription107 = null;

        PhdlParser.concatenation_return concatenation109 = null;


        CommonTree EQUALS108_tree=null;
        CommonTree SEMICOLON110_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:328:2: ( pinDescription EQUALS concatenation SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:328:4: pinDescription EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_pinDescription_in_pinAssignment674);
            pinDescription107=pinDescription();

            state._fsp--;

            adaptor.addChild(root_0, pinDescription107.getTree());
            EQUALS108=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinAssignment676); 
            EQUALS108_tree = (CommonTree)adaptor.create(EQUALS108);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS108_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_pinAssignment679);
            concatenation109=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation109.getTree());
            SEMICOLON110=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinAssignment681); 

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

    public static class pinDescription_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pinDescription"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:331:1: pinDescription : ( pinQualifier | pinSpecifier );
    public final PhdlParser.pinDescription_return pinDescription() throws RecognitionException {
        PhdlParser.pinDescription_return retval = new PhdlParser.pinDescription_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        PhdlParser.pinQualifier_return pinQualifier111 = null;

        PhdlParser.pinSpecifier_return pinSpecifier112 = null;



        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:332:3: ( pinQualifier | pinSpecifier )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==35) ) {
                alt26=1;
            }
            else if ( (LA26_0==IDENT||LA26_0==37) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:332:5: pinQualifier
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_pinQualifier_in_pinDescription694);
                    pinQualifier111=pinQualifier();

                    state._fsp--;

                    adaptor.addChild(root_0, pinQualifier111.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:332:20: pinSpecifier
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_pinSpecifier_in_pinDescription698);
                    pinSpecifier112=pinSpecifier();

                    state._fsp--;

                    adaptor.addChild(root_0, pinSpecifier112.getTree());

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
    // $ANTLR end "pinDescription"

    public static class pinQualifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pinQualifier"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:335:1: pinQualifier : 'combine' LEFTPAREN pinSpecifier RIGHTPAREN ;
    public final PhdlParser.pinQualifier_return pinQualifier() throws RecognitionException {
        PhdlParser.pinQualifier_return retval = new PhdlParser.pinQualifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal113=null;
        Token LEFTPAREN114=null;
        Token RIGHTPAREN116=null;
        PhdlParser.pinSpecifier_return pinSpecifier115 = null;


        CommonTree string_literal113_tree=null;
        CommonTree LEFTPAREN114_tree=null;
        CommonTree RIGHTPAREN116_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:339:3: ( 'combine' LEFTPAREN pinSpecifier RIGHTPAREN )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:339:5: 'combine' LEFTPAREN pinSpecifier RIGHTPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal113=(Token)match(input,35,FOLLOW_35_in_pinQualifier714); 
            string_literal113_tree = (CommonTree)adaptor.create(string_literal113);
            adaptor.addChild(root_0, string_literal113_tree);

            LEFTPAREN114=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_pinQualifier716); 
            pushFollow(FOLLOW_pinSpecifier_in_pinQualifier719);
            pinSpecifier115=pinSpecifier();

            state._fsp--;

            adaptor.addChild(root_0, pinSpecifier115.getTree());
            RIGHTPAREN116=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_pinQualifier721); 

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

    public static class netAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "netAssignment"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:342:1: netAssignment : IDENT ( sliceList )? EQUALS concatenation SEMICOLON ;
    public final PhdlParser.netAssignment_return netAssignment() throws RecognitionException {
        PhdlParser.netAssignment_return retval = new PhdlParser.netAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT117=null;
        Token EQUALS119=null;
        Token SEMICOLON121=null;
        PhdlParser.sliceList_return sliceList118 = null;

        PhdlParser.concatenation_return concatenation120 = null;


        CommonTree IDENT117_tree=null;
        CommonTree EQUALS119_tree=null;
        CommonTree SEMICOLON121_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:347:2: ( IDENT ( sliceList )? EQUALS concatenation SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:347:4: IDENT ( sliceList )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT117=(Token)match(input,IDENT,FOLLOW_IDENT_in_netAssignment736); 
            IDENT117_tree = (CommonTree)adaptor.create(IDENT117);
            adaptor.addChild(root_0, IDENT117_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:347:10: ( sliceList )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==LEFTBRACKET) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:347:10: sliceList
                    {
                    pushFollow(FOLLOW_sliceList_in_netAssignment738);
                    sliceList118=sliceList();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceList118.getTree());

                    }
                    break;

            }

            EQUALS119=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_netAssignment741); 
            EQUALS119_tree = (CommonTree)adaptor.create(EQUALS119);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS119_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_netAssignment744);
            concatenation120=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation120.getTree());
            SEMICOLON121=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netAssignment746); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:350:1: concatenation : ( ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* ) | ( LEFTANGLE IDENT ( sliceList )? RIGHTANGLE ) | 'open' );
    public final PhdlParser.concatenation_return concatenation() throws RecognitionException {
        PhdlParser.concatenation_return retval = new PhdlParser.concatenation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT122=null;
        Token AMPERSAND124=null;
        Token IDENT125=null;
        Token LEFTANGLE127=null;
        Token IDENT128=null;
        Token RIGHTANGLE130=null;
        Token string_literal131=null;
        PhdlParser.sliceList_return sliceList123 = null;

        PhdlParser.sliceList_return sliceList126 = null;

        PhdlParser.sliceList_return sliceList129 = null;


        CommonTree IDENT122_tree=null;
        CommonTree AMPERSAND124_tree=null;
        CommonTree IDENT125_tree=null;
        CommonTree LEFTANGLE127_tree=null;
        CommonTree IDENT128_tree=null;
        CommonTree RIGHTANGLE130_tree=null;
        CommonTree string_literal131_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:356:2: ( ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* ) | ( LEFTANGLE IDENT ( sliceList )? RIGHTANGLE ) | 'open' )
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
            case 40:
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:356:4: ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:356:4: ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:356:5: ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )*
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:356:5: ( IDENT ( sliceList )? )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:356:6: IDENT ( sliceList )?
                    {
                    IDENT122=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation763); 
                    IDENT122_tree = (CommonTree)adaptor.create(IDENT122);
                    adaptor.addChild(root_0, IDENT122_tree);

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:356:12: ( sliceList )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==LEFTBRACKET) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:356:12: sliceList
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation765);
                            sliceList123=sliceList();

                            state._fsp--;

                            adaptor.addChild(root_0, sliceList123.getTree());

                            }
                            break;

                    }


                    }

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:356:24: ( AMPERSAND IDENT ( sliceList )? )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==AMPERSAND) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:356:25: AMPERSAND IDENT ( sliceList )?
                    	    {
                    	    AMPERSAND124=(Token)match(input,AMPERSAND,FOLLOW_AMPERSAND_in_concatenation770); 
                    	    IDENT125=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation773); 
                    	    IDENT125_tree = (CommonTree)adaptor.create(IDENT125);
                    	    adaptor.addChild(root_0, IDENT125_tree);

                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:356:42: ( sliceList )?
                    	    int alt29=2;
                    	    int LA29_0 = input.LA(1);

                    	    if ( (LA29_0==LEFTBRACKET) ) {
                    	        alt29=1;
                    	    }
                    	    switch (alt29) {
                    	        case 1 :
                    	            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:356:42: sliceList
                    	            {
                    	            pushFollow(FOLLOW_sliceList_in_concatenation775);
                    	            sliceList126=sliceList();

                    	            state._fsp--;

                    	            adaptor.addChild(root_0, sliceList126.getTree());

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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:357:4: ( LEFTANGLE IDENT ( sliceList )? RIGHTANGLE )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:357:4: ( LEFTANGLE IDENT ( sliceList )? RIGHTANGLE )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:357:5: LEFTANGLE IDENT ( sliceList )? RIGHTANGLE
                    {
                    LEFTANGLE127=(Token)match(input,LEFTANGLE,FOLLOW_LEFTANGLE_in_concatenation787); 
                    LEFTANGLE127_tree = (CommonTree)adaptor.create(LEFTANGLE127);
                    adaptor.addChild(root_0, LEFTANGLE127_tree);

                    IDENT128=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation789); 
                    IDENT128_tree = (CommonTree)adaptor.create(IDENT128);
                    adaptor.addChild(root_0, IDENT128_tree);

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:357:21: ( sliceList )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==LEFTBRACKET) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:357:21: sliceList
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation791);
                            sliceList129=sliceList();

                            state._fsp--;

                            adaptor.addChild(root_0, sliceList129.getTree());

                            }
                            break;

                    }

                    RIGHTANGLE130=(Token)match(input,RIGHTANGLE,FOLLOW_RIGHTANGLE_in_concatenation794); 

                    }


                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:358:5: 'open'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal131=(Token)match(input,40,FOLLOW_40_in_concatenation802); 
                    string_literal131_tree = (CommonTree)adaptor.create(string_literal131);
                    adaptor.addChild(root_0, string_literal131_tree);


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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:361:1: pinList : LEFTBRACE ( IDENT | INTEGER ) ( COMMA ( IDENT | INTEGER ) )* RIGHTBRACE ;
    public final PhdlParser.pinList_return pinList() throws RecognitionException {
        PhdlParser.pinList_return retval = new PhdlParser.pinList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTBRACE132=null;
        Token set133=null;
        Token COMMA134=null;
        Token set135=null;
        Token RIGHTBRACE136=null;

        CommonTree LEFTBRACE132_tree=null;
        CommonTree set133_tree=null;
        CommonTree COMMA134_tree=null;
        CommonTree set135_tree=null;
        CommonTree RIGHTBRACE136_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:366:2: ( LEFTBRACE ( IDENT | INTEGER ) ( COMMA ( IDENT | INTEGER ) )* RIGHTBRACE )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:366:5: LEFTBRACE ( IDENT | INTEGER ) ( COMMA ( IDENT | INTEGER ) )* RIGHTBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACE132=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_pinList817); 
            set133=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||input.LA(1)==INTEGER ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set133));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:366:34: ( COMMA ( IDENT | INTEGER ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==COMMA) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:366:35: COMMA ( IDENT | INTEGER )
            	    {
            	    COMMA134=(Token)match(input,COMMA,FOLLOW_COMMA_in_pinList829); 
            	    set135=(Token)input.LT(1);
            	    if ( input.LA(1)==IDENT||input.LA(1)==INTEGER ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (CommonTree)adaptor.create(set135));
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

            RIGHTBRACE136=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_pinList842); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:369:1: sliceList : LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTBRACKET ;
    public final PhdlParser.sliceList_return sliceList() throws RecognitionException {
        PhdlParser.sliceList_return retval = new PhdlParser.sliceList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTBRACKET137=null;
        Token INTEGER138=null;
        Token COLON139=null;
        Token INTEGER140=null;
        Token COMMA141=null;
        Token INTEGER142=null;
        Token COMMA143=null;
        Token INTEGER144=null;
        Token RIGHTBRACKET145=null;

        CommonTree LEFTBRACKET137_tree=null;
        CommonTree INTEGER138_tree=null;
        CommonTree COLON139_tree=null;
        CommonTree INTEGER140_tree=null;
        CommonTree COMMA141_tree=null;
        CommonTree INTEGER142_tree=null;
        CommonTree COMMA143_tree=null;
        CommonTree INTEGER144_tree=null;
        CommonTree RIGHTBRACKET145_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:375:2: ( LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTBRACKET )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:375:5: LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTBRACKET
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACKET137=(Token)match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList858); 
            LEFTBRACKET137_tree = (CommonTree)adaptor.create(LEFTBRACKET137);
            adaptor.addChild(root_0, LEFTBRACKET137_tree);

            INTEGER138=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList860); 
            INTEGER138_tree = (CommonTree)adaptor.create(INTEGER138);
            adaptor.addChild(root_0, INTEGER138_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:375:25: ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? )
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:375:26: ( COLON INTEGER )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:375:26: ( COLON INTEGER )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:375:27: COLON INTEGER
                    {
                    COLON139=(Token)match(input,COLON,FOLLOW_COLON_in_sliceList864); 
                    COLON139_tree = (CommonTree)adaptor.create(COLON139);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON139_tree, root_0);

                    INTEGER140=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList867); 
                    INTEGER140_tree = (CommonTree)adaptor.create(INTEGER140);
                    adaptor.addChild(root_0, INTEGER140_tree);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:375:45: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:375:45: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==COMMA) ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:375:46: COMMA INTEGER ( COMMA INTEGER )*
                            {
                            COMMA141=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceList873); 
                            COMMA141_tree = (CommonTree)adaptor.create(COMMA141);
                            root_0 = (CommonTree)adaptor.becomeRoot(COMMA141_tree, root_0);

                            INTEGER142=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList876); 
                            INTEGER142_tree = (CommonTree)adaptor.create(INTEGER142);
                            adaptor.addChild(root_0, INTEGER142_tree);

                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:375:61: ( COMMA INTEGER )*
                            loop34:
                            do {
                                int alt34=2;
                                int LA34_0 = input.LA(1);

                                if ( (LA34_0==COMMA) ) {
                                    alt34=1;
                                }


                                switch (alt34) {
                            	case 1 :
                            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:375:62: COMMA INTEGER
                            	    {
                            	    COMMA143=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceList879); 
                            	    INTEGER144=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList882); 
                            	    INTEGER144_tree = (CommonTree)adaptor.create(INTEGER144);
                            	    adaptor.addChild(root_0, INTEGER144_tree);


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

            RIGHTBRACKET145=(Token)match(input,RIGHTBRACKET,FOLLOW_RIGHTBRACKET_in_sliceList889); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:378:1: sliceDecl : LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RIGHTBRACKET ;
    public final PhdlParser.sliceDecl_return sliceDecl() throws RecognitionException {
        PhdlParser.sliceDecl_return retval = new PhdlParser.sliceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTBRACKET146=null;
        Token INTEGER147=null;
        Token COLON148=null;
        Token INTEGER149=null;
        Token COMMA150=null;
        Token INTEGER151=null;
        Token RIGHTBRACKET152=null;

        CommonTree LEFTBRACKET146_tree=null;
        CommonTree INTEGER147_tree=null;
        CommonTree COLON148_tree=null;
        CommonTree INTEGER149_tree=null;
        CommonTree COMMA150_tree=null;
        CommonTree INTEGER151_tree=null;
        CommonTree RIGHTBRACKET152_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:383:2: ( LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RIGHTBRACKET )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:383:4: LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RIGHTBRACKET
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACKET146=(Token)match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceDecl903); 
            LEFTBRACKET146_tree = (CommonTree)adaptor.create(LEFTBRACKET146);
            adaptor.addChild(root_0, LEFTBRACKET146_tree);

            INTEGER147=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl905); 
            INTEGER147_tree = (CommonTree)adaptor.create(INTEGER147);
            adaptor.addChild(root_0, INTEGER147_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:383:24: ( ( COLON INTEGER ) | ( COMMA INTEGER )+ )
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:383:25: ( COLON INTEGER )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:383:25: ( COLON INTEGER )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:383:26: COLON INTEGER
                    {
                    COLON148=(Token)match(input,COLON,FOLLOW_COLON_in_sliceDecl909); 
                    COLON148_tree = (CommonTree)adaptor.create(COLON148);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON148_tree, root_0);

                    INTEGER149=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl912); 
                    INTEGER149_tree = (CommonTree)adaptor.create(INTEGER149);
                    adaptor.addChild(root_0, INTEGER149_tree);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:383:44: ( COMMA INTEGER )+
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:383:44: ( COMMA INTEGER )+
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
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:383:45: COMMA INTEGER
                    	    {
                    	    COMMA150=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceDecl918); 
                    	    COMMA150_tree = (CommonTree)adaptor.create(COMMA150);
                    	    root_0 = (CommonTree)adaptor.becomeRoot(COMMA150_tree, root_0);

                    	    INTEGER151=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl921); 
                    	    INTEGER151_tree = (CommonTree)adaptor.create(INTEGER151);
                    	    adaptor.addChild(root_0, INTEGER151_tree);


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

            RIGHTBRACKET152=(Token)match(input,RIGHTBRACKET,FOLLOW_RIGHTBRACKET_in_sliceDecl926); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:386:1: arrayList : LEFTPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTPAREN ;
    public final PhdlParser.arrayList_return arrayList() throws RecognitionException {
        PhdlParser.arrayList_return retval = new PhdlParser.arrayList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTPAREN153=null;
        Token INTEGER154=null;
        Token COLON155=null;
        Token INTEGER156=null;
        Token COMMA157=null;
        Token INTEGER158=null;
        Token COMMA159=null;
        Token INTEGER160=null;
        Token RIGHTPAREN161=null;

        CommonTree LEFTPAREN153_tree=null;
        CommonTree INTEGER154_tree=null;
        CommonTree COLON155_tree=null;
        CommonTree INTEGER156_tree=null;
        CommonTree COMMA157_tree=null;
        CommonTree INTEGER158_tree=null;
        CommonTree COMMA159_tree=null;
        CommonTree INTEGER160_tree=null;
        CommonTree RIGHTPAREN161_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:391:2: ( LEFTPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTPAREN )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:391:5: LEFTPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTPAREN153=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList942); 
            LEFTPAREN153_tree = (CommonTree)adaptor.create(LEFTPAREN153);
            adaptor.addChild(root_0, LEFTPAREN153_tree);

            INTEGER154=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList944); 
            INTEGER154_tree = (CommonTree)adaptor.create(INTEGER154);
            adaptor.addChild(root_0, INTEGER154_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:391:23: ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? )
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:391:24: ( COLON INTEGER )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:391:24: ( COLON INTEGER )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:391:25: COLON INTEGER
                    {
                    COLON155=(Token)match(input,COLON,FOLLOW_COLON_in_arrayList948); 
                    COLON155_tree = (CommonTree)adaptor.create(COLON155);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON155_tree, root_0);

                    INTEGER156=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList951); 
                    INTEGER156_tree = (CommonTree)adaptor.create(INTEGER156);
                    adaptor.addChild(root_0, INTEGER156_tree);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:391:43: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:391:43: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==COMMA) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:391:44: COMMA INTEGER ( COMMA INTEGER )*
                            {
                            COMMA157=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayList957); 
                            COMMA157_tree = (CommonTree)adaptor.create(COMMA157);
                            root_0 = (CommonTree)adaptor.becomeRoot(COMMA157_tree, root_0);

                            INTEGER158=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList960); 
                            INTEGER158_tree = (CommonTree)adaptor.create(INTEGER158);
                            adaptor.addChild(root_0, INTEGER158_tree);

                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:391:59: ( COMMA INTEGER )*
                            loop39:
                            do {
                                int alt39=2;
                                int LA39_0 = input.LA(1);

                                if ( (LA39_0==COMMA) ) {
                                    alt39=1;
                                }


                                switch (alt39) {
                            	case 1 :
                            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:391:60: COMMA INTEGER
                            	    {
                            	    COMMA159=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayList963); 
                            	    INTEGER160=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList966); 
                            	    INTEGER160_tree = (CommonTree)adaptor.create(INTEGER160);
                            	    adaptor.addChild(root_0, INTEGER160_tree);


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

            RIGHTPAREN161=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_arrayList973); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:394:1: arrayDecl : LEFTPAREN INTEGER COLON INTEGER RIGHTPAREN ;
    public final PhdlParser.arrayDecl_return arrayDecl() throws RecognitionException {
        PhdlParser.arrayDecl_return retval = new PhdlParser.arrayDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTPAREN162=null;
        Token INTEGER163=null;
        Token COLON164=null;
        Token INTEGER165=null;
        Token RIGHTPAREN166=null;

        CommonTree LEFTPAREN162_tree=null;
        CommonTree INTEGER163_tree=null;
        CommonTree COLON164_tree=null;
        CommonTree INTEGER165_tree=null;
        CommonTree RIGHTPAREN166_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:399:2: ( LEFTPAREN INTEGER COLON INTEGER RIGHTPAREN )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:399:4: LEFTPAREN INTEGER COLON INTEGER RIGHTPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTPAREN162=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayDecl987); 
            LEFTPAREN162_tree = (CommonTree)adaptor.create(LEFTPAREN162);
            adaptor.addChild(root_0, LEFTPAREN162_tree);

            INTEGER163=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayDecl989); 
            INTEGER163_tree = (CommonTree)adaptor.create(INTEGER163);
            adaptor.addChild(root_0, INTEGER163_tree);

            COLON164=(Token)match(input,COLON,FOLLOW_COLON_in_arrayDecl991); 
            COLON164_tree = (CommonTree)adaptor.create(COLON164);
            root_0 = (CommonTree)adaptor.becomeRoot(COLON164_tree, root_0);

            INTEGER165=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayDecl994); 
            INTEGER165_tree = (CommonTree)adaptor.create(INTEGER165);
            adaptor.addChild(root_0, INTEGER165_tree);

            RIGHTPAREN166=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_arrayDecl996); 

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
    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA10_eotS =
        "\22\uffff";
    static final String DFA10_eofS =
        "\22\uffff";
    static final String DFA10_minS =
        "\1\4\2\uffff\1\13\1\7\2\uffff\1\21\2\4\1\12\2\21\1\15\1\14\1\12"+
        "\1\21\1\12";
    static final String DFA10_maxS =
        "\1\46\2\uffff\1\15\1\22\2\uffff\1\21\1\4\1\50\1\23\2\21\1\15\2"+
        "\14\1\21\1\14";
    static final String DFA10_acceptS =
        "\1\uffff\1\4\1\1\2\uffff\1\2\1\3\13\uffff";
    static final String DFA10_specialS =
        "\22\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\4\1\uffff\1\1\34\uffff\1\5\1\2\1\3\1\6",
            "",
            "",
            "\1\7\1\uffff\1\10",
            "\1\11\12\uffff\1\5",
            "",
            "",
            "\1\12",
            "\1\4",
            "\1\5\3\uffff\1\2\6\uffff\1\5\30\uffff\1\5",
            "\1\14\1\uffff\1\15\6\uffff\1\13",
            "\1\16",
            "\1\17",
            "\1\10",
            "\1\15",
            "\1\20\1\uffff\1\15",
            "\1\21",
            "\1\20\1\uffff\1\15"
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
    static final String DFA13_eotS =
        "\20\uffff";
    static final String DFA13_eofS =
        "\20\uffff";
    static final String DFA13_minS =
        "\1\4\1\uffff\1\13\1\7\1\uffff\1\21\2\4\1\12\2\21\1\15\1\14\1\12"+
        "\1\21\1\12";
    static final String DFA13_maxS =
        "\1\45\1\uffff\1\15\1\22\1\uffff\1\21\1\4\1\50\1\23\2\21\1\15\2"+
        "\14\1\21\1\14";
    static final String DFA13_acceptS =
        "\1\uffff\1\1\2\uffff\1\2\13\uffff";
    static final String DFA13_specialS =
        "\20\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\3\36\uffff\1\1\1\4\1\2",
            "",
            "\1\5\1\uffff\1\6",
            "\1\7\3\uffff\1\4\1\uffff\1\4\4\uffff\1\1",
            "",
            "\1\10",
            "\1\3",
            "\1\1\3\uffff\1\4\6\uffff\1\1\30\uffff\1\1",
            "\1\12\1\uffff\1\13\6\uffff\1\11",
            "\1\14",
            "\1\15",
            "\1\6",
            "\1\13",
            "\1\16\1\uffff\1\13",
            "\1\17",
            "\1\16\1\uffff\1\13"
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "253:1: subAssignment : ( portAssignment | subAttrAssignment );";
        }
    }
 

    public static final BitSet FOLLOW_designDecl_in_sourceText79 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_EOF_in_sourceText82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_designDecl95 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_designDecl98 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LEFTBRACE_in_designDecl100 = new BitSet(new long[]{0x000000C590000050L});
    public static final BitSet FOLLOW_deviceDecl_in_designDecl107 = new BitSet(new long[]{0x000000C590000050L});
    public static final BitSet FOLLOW_netDecl_in_designDecl111 = new BitSet(new long[]{0x000000C590000050L});
    public static final BitSet FOLLOW_infoStruct_in_designDecl115 = new BitSet(new long[]{0x000000C590000050L});
    public static final BitSet FOLLOW_instanceDecl_in_designDecl119 = new BitSet(new long[]{0x000000C590000050L});
    public static final BitSet FOLLOW_netAssignment_in_designDecl123 = new BitSet(new long[]{0x000000C590000050L});
    public static final BitSet FOLLOW_groupStruct_in_designDecl127 = new BitSet(new long[]{0x000000C590000050L});
    public static final BitSet FOLLOW_subDesignInstance_in_designDecl131 = new BitSet(new long[]{0x000000C590000050L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_designDecl137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_deviceDecl152 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl155 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LEFTBRACE_in_deviceDecl157 = new BitSet(new long[]{0x0000000060000040L});
    public static final BitSet FOLLOW_attributeDecl_in_deviceDecl164 = new BitSet(new long[]{0x0000000060000040L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl168 = new BitSet(new long[]{0x0000000060000040L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_deviceDecl175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_attributeDecl190 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attributeDecl193 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_EQUALS_in_attributeDecl195 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_STRING_in_attributeDecl198 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeDecl200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_pinDecl214 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_sliceDecl_in_pinDecl217 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl220 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_EQUALS_in_pinDecl222 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_pinList_in_pinDecl225 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinDecl227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_type242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_netDecl255 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_sliceDecl_in_netDecl258 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl261 = new BitSet(new long[]{0x0000000000000620L});
    public static final BitSet FOLLOW_COMMA_in_netDecl264 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl266 = new BitSet(new long[]{0x0000000000000620L});
    public static final BitSet FOLLOW_netAttributes_in_netDecl271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_netDecl275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACE_in_netAttributes291 = new BitSet(new long[]{0x0000000020000040L});
    public static final BitSet FOLLOW_attributeDecl_in_netAttributes294 = new BitSet(new long[]{0x0000000020000040L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_netAttributes297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_instanceDecl311 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_arrayDecl_in_instanceDecl314 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instanceDecl317 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_instanceDecl319 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instanceDecl322 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LEFTBRACE_in_instanceDecl324 = new BitSet(new long[]{0x0000007800000050L});
    public static final BitSet FOLLOW_attributeAssignment_in_instanceDecl330 = new BitSet(new long[]{0x0000007800000050L});
    public static final BitSet FOLLOW_pinAssignment_in_instanceDecl334 = new BitSet(new long[]{0x0000007800000050L});
    public static final BitSet FOLLOW_infoStruct_in_instanceDecl338 = new BitSet(new long[]{0x0000007800000050L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_instanceDecl344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_subDesignInstance358 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_arrayDecl_in_subDesignInstance361 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_subDesignInstance364 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_subDesignInstance366 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_subDesignInstance369 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LEFTBRACE_in_subDesignInstance371 = new BitSet(new long[]{0x0000007800000050L});
    public static final BitSet FOLLOW_subAssignment_in_subDesignInstance379 = new BitSet(new long[]{0x0000007800000050L});
    public static final BitSet FOLLOW_infoStruct_in_subDesignInstance383 = new BitSet(new long[]{0x0000007800000050L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_subDesignInstance391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_portAssignment_in_subAssignment407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subAttrAssignment_in_subAssignment413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_combineQualifier_in_portAssignment429 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_pinSpecifier_in_portAssignment433 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_EQUALS_in_portAssignment436 = new BitSet(new long[]{0x0000010000008010L});
    public static final BitSet FOLLOW_concatenation_in_portAssignment439 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_SEMICOLON_in_portAssignment441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_combineQualifier455 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LEFTPAREN_in_combineQualifier458 = new BitSet(new long[]{0x0000002800000010L});
    public static final BitSet FOLLOW_pinSpecifier_in_combineQualifier461 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RIGHTPAREN_in_combineQualifier463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayQualifier_in_pinSpecifier479 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinSpecifier482 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_sliceList_in_pinSpecifier485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_subAttrAssignment499 = new BitSet(new long[]{0x0000002000000010L});
    public static final BitSet FOLLOW_arrayQualifier_in_subAttrAssignment502 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_instSpecifier_in_subAttrAssignment505 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_subAttrAssignment508 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_EQUALS_in_subAttrAssignment510 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_STRING_in_subAttrAssignment513 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_SEMICOLON_in_subAttrAssignment515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_arrayQualifier532 = new BitSet(new long[]{0x0000000000002800L});
    public static final BitSet FOLLOW_arrayList_in_arrayQualifier534 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_PERIOD_in_arrayQualifier537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_instSpecifier550 = new BitSet(new long[]{0x0000000000002800L});
    public static final BitSet FOLLOW_arrayList_in_instSpecifier552 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_PERIOD_in_instSpecifier555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_infoStruct571 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LEFTBRACE_in_infoStruct574 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_STRING_in_infoStruct577 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_infoStruct579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_groupStruct594 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_STRING_in_groupStruct597 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LEFTBRACE_in_groupStruct599 = new BitSet(new long[]{0x0000000100000050L});
    public static final BitSet FOLLOW_instanceDecl_in_groupStruct603 = new BitSet(new long[]{0x0000000100000050L});
    public static final BitSet FOLLOW_netAssignment_in_groupStruct607 = new BitSet(new long[]{0x0000000100000050L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_groupStruct611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_attributeAssignment626 = new BitSet(new long[]{0x0000002000000010L});
    public static final BitSet FOLLOW_attributeQualifier_in_attributeAssignment630 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attributeAssignment633 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_EQUALS_in_attributeAssignment635 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_STRING_in_attributeAssignment638 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeAssignment640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_attributeQualifier655 = new BitSet(new long[]{0x0000000000002800L});
    public static final BitSet FOLLOW_arrayList_in_attributeQualifier657 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_PERIOD_in_attributeQualifier660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pinDescription_in_pinAssignment674 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssignment676 = new BitSet(new long[]{0x0000010000008010L});
    public static final BitSet FOLLOW_concatenation_in_pinAssignment679 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinAssignment681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pinQualifier_in_pinDescription694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pinSpecifier_in_pinDescription698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_pinQualifier714 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LEFTPAREN_in_pinQualifier716 = new BitSet(new long[]{0x0000002800000010L});
    public static final BitSet FOLLOW_pinSpecifier_in_pinQualifier719 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RIGHTPAREN_in_pinQualifier721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_netAssignment736 = new BitSet(new long[]{0x0000000000040080L});
    public static final BitSet FOLLOW_sliceList_in_netAssignment738 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_EQUALS_in_netAssignment741 = new BitSet(new long[]{0x0000010000008010L});
    public static final BitSet FOLLOW_concatenation_in_netAssignment744 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_SEMICOLON_in_netAssignment746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_concatenation763 = new BitSet(new long[]{0x0000000000044002L});
    public static final BitSet FOLLOW_sliceList_in_concatenation765 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_AMPERSAND_in_concatenation770 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation773 = new BitSet(new long[]{0x0000000000044002L});
    public static final BitSet FOLLOW_sliceList_in_concatenation775 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_LEFTANGLE_in_concatenation787 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation789 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_sliceList_in_concatenation791 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RIGHTANGLE_in_concatenation794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_concatenation802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACE_in_pinList817 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_set_in_pinList820 = new BitSet(new long[]{0x0000000000000440L});
    public static final BitSet FOLLOW_COMMA_in_pinList829 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_set_in_pinList832 = new BitSet(new long[]{0x0000000000000440L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_pinList842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList858 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList860 = new BitSet(new long[]{0x0000000000180400L});
    public static final BitSet FOLLOW_COLON_in_sliceList864 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList867 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_sliceList873 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList876 = new BitSet(new long[]{0x0000000000100400L});
    public static final BitSet FOLLOW_COMMA_in_sliceList879 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList882 = new BitSet(new long[]{0x0000000000100400L});
    public static final BitSet FOLLOW_RIGHTBRACKET_in_sliceList889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceDecl903 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl905 = new BitSet(new long[]{0x0000000000080400L});
    public static final BitSet FOLLOW_COLON_in_sliceDecl909 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl912 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_sliceDecl918 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl921 = new BitSet(new long[]{0x0000000000100400L});
    public static final BitSet FOLLOW_RIGHTBRACKET_in_sliceDecl926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList942 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList944 = new BitSet(new long[]{0x0000000000081400L});
    public static final BitSet FOLLOW_COLON_in_arrayList948 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList951 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_COMMA_in_arrayList957 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList960 = new BitSet(new long[]{0x0000000000001400L});
    public static final BitSet FOLLOW_COMMA_in_arrayList963 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList966 = new BitSet(new long[]{0x0000000000001400L});
    public static final BitSet FOLLOW_RIGHTPAREN_in_arrayList973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayDecl987 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayDecl989 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_COLON_in_arrayDecl991 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayDecl994 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RIGHTPAREN_in_arrayDecl996 = new BitSet(new long[]{0x0000000000000002L});

}