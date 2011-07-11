// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g 2011-07-11 09:40:17

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "SEMICOLON", "EQUALS", "STRING", "PERIOD", "AMPERSAND", "LEFTANGLE", "RIGHTANGLE", "LEFTBRACE", "PIN", "INTEGER", "COMMA", "RIGHTBRACE", "LEFTBRACKET", "COLON", "RIGHTBRACKET", "LEFTPAREN", "RIGHTPAREN", "CHAR", "DIGIT", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "'design'", "'is'", "'begin'", "'end'", "'device'", "'attr'", "'pin'", "'net'", "'inst'", "'of'", "'newattr'", "'open'"
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
    public static final int IDENT=4;
    public static final int SEMICOLON=5;
    public static final int EQUALS=6;
    public static final int STRING=7;
    public static final int PERIOD=8;
    public static final int AMPERSAND=9;
    public static final int LEFTANGLE=10;
    public static final int RIGHTANGLE=11;
    public static final int LEFTBRACE=12;
    public static final int PIN=13;
    public static final int INTEGER=14;
    public static final int COMMA=15;
    public static final int RIGHTBRACE=16;
    public static final int LEFTBRACKET=17;
    public static final int COLON=18;
    public static final int RIGHTBRACKET=19;
    public static final int LEFTPAREN=20;
    public static final int RIGHTPAREN=21;
    public static final int CHAR=22;
    public static final int DIGIT=23;
    public static final int WHITESPACE=24;
    public static final int LINE_COMMENT=25;
    public static final int MULTILINE_COMMENT=26;

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



    	private Set<String> errors = new TreeSet<String>();

    	@Override
    	public void displayRecognitionError(String[] tokenNames,
    			RecognitionException e) {
    		String hdr = getErrorHeader(e);
    		String msg = getErrorMessage(e, tokenNames);
    		errors.add(hdr + " " + msg);
    	}

    	public Set<String> getErrors() {
    		return errors;
    	}


    public static class sourceText_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sourceText"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:72:1: sourceText : ( designDecl )* EOF ;
    public final PhdlParser.sourceText_return sourceText() throws RecognitionException {
        PhdlParser.sourceText_return retval = new PhdlParser.sourceText_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF2=null;
        PhdlParser.designDecl_return designDecl1 = null;


        CommonTree EOF2_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:76:2: ( ( designDecl )* EOF )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:76:4: ( designDecl )* EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:76:4: ( designDecl )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==27) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:76:4: designDecl
            	    {
            	    pushFollow(FOLLOW_designDecl_in_sourceText74);
            	    designDecl1=designDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, designDecl1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_sourceText77); 
            EOF2_tree = (CommonTree)adaptor.create(EOF2);
            adaptor.addChild(root_0, EOF2_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		System.out.println("ERROR: " + e.getMessage());
        		System.exit(1);
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:82:1: designDecl : 'design' IDENT 'is' ( deviceDecl | netDecl )* 'begin' ( instanceDecl | netAssignment )* 'end' ( 'design' )? SEMICOLON ;
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
        Token SEMICOLON13=null;
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
        CommonTree SEMICOLON13_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:89:2: ( 'design' IDENT 'is' ( deviceDecl | netDecl )* 'begin' ( instanceDecl | netAssignment )* 'end' ( 'design' )? SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:89:4: 'design' IDENT 'is' ( deviceDecl | netDecl )* 'begin' ( instanceDecl | netAssignment )* 'end' ( 'design' )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal3=(Token)match(input,27,FOLLOW_27_in_designDecl93); 
            string_literal3_tree = (CommonTree)adaptor.create(string_literal3);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal3_tree, root_0);

            IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_designDecl96); 
            IDENT4_tree = (CommonTree)adaptor.create(IDENT4);
            adaptor.addChild(root_0, IDENT4_tree);

            string_literal5=(Token)match(input,28,FOLLOW_28_in_designDecl98); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:90:3: ( deviceDecl | netDecl )*
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:90:4: deviceDecl
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_designDecl105);
            	    deviceDecl6=deviceDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, deviceDecl6.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:90:17: netDecl
            	    {
            	    pushFollow(FOLLOW_netDecl_in_designDecl109);
            	    netDecl7=netDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netDecl7.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            string_literal8=(Token)match(input,29,FOLLOW_29_in_designDecl115); 
            string_literal8_tree = (CommonTree)adaptor.create(string_literal8);
            adaptor.addChild(root_0, string_literal8_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:92:3: ( instanceDecl | netAssignment )*
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:92:4: instanceDecl
            	    {
            	    pushFollow(FOLLOW_instanceDecl_in_designDecl120);
            	    instanceDecl9=instanceDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, instanceDecl9.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:92:19: netAssignment
            	    {
            	    pushFollow(FOLLOW_netAssignment_in_designDecl124);
            	    netAssignment10=netAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netAssignment10.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            string_literal11=(Token)match(input,30,FOLLOW_30_in_designDecl130); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:93:18: ( 'design' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==27) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:93:18: 'design'
                    {
                    string_literal12=(Token)match(input,27,FOLLOW_27_in_designDecl133); 

                    }
                    break;

            }

            SEMICOLON13=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_designDecl137); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		System.out.println("ERROR: " + e.getMessage());
        		System.exit(1);
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:96:1: deviceDecl : 'device' IDENT 'is' ( attributeDecl | pinDecl )* 'end' ( 'device' )? SEMICOLON ;
    public final PhdlParser.deviceDecl_return deviceDecl() throws RecognitionException {
        PhdlParser.deviceDecl_return retval = new PhdlParser.deviceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal14=null;
        Token IDENT15=null;
        Token string_literal16=null;
        Token string_literal19=null;
        Token string_literal20=null;
        Token SEMICOLON21=null;
        PhdlParser.attributeDecl_return attributeDecl17 = null;

        PhdlParser.pinDecl_return pinDecl18 = null;


        CommonTree string_literal14_tree=null;
        CommonTree IDENT15_tree=null;
        CommonTree string_literal16_tree=null;
        CommonTree string_literal19_tree=null;
        CommonTree string_literal20_tree=null;
        CommonTree SEMICOLON21_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:102:2: ( 'device' IDENT 'is' ( attributeDecl | pinDecl )* 'end' ( 'device' )? SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:102:4: 'device' IDENT 'is' ( attributeDecl | pinDecl )* 'end' ( 'device' )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal14=(Token)match(input,31,FOLLOW_31_in_deviceDecl152); 
            string_literal14_tree = (CommonTree)adaptor.create(string_literal14);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal14_tree, root_0);

            IDENT15=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl155); 
            IDENT15_tree = (CommonTree)adaptor.create(IDENT15);
            adaptor.addChild(root_0, IDENT15_tree);

            string_literal16=(Token)match(input,28,FOLLOW_28_in_deviceDecl157); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:103:3: ( attributeDecl | pinDecl )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==32) ) {
                    alt5=1;
                }
                else if ( (LA5_0==33) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:103:5: attributeDecl
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_deviceDecl164);
            	    attributeDecl17=attributeDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeDecl17.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:103:21: pinDecl
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl168);
            	    pinDecl18=pinDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinDecl18.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            string_literal19=(Token)match(input,30,FOLLOW_30_in_deviceDecl175); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:104:18: ( 'device' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==31) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:104:18: 'device'
                    {
                    string_literal20=(Token)match(input,31,FOLLOW_31_in_deviceDecl178); 

                    }
                    break;

            }

            SEMICOLON21=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_deviceDecl182); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		System.out.println("ERROR: " + e.getMessage());
        		System.exit(1);
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:107:1: attributeDecl : 'attr' IDENT EQUALS STRING SEMICOLON ;
    public final PhdlParser.attributeDecl_return attributeDecl() throws RecognitionException {
        PhdlParser.attributeDecl_return retval = new PhdlParser.attributeDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal22=null;
        Token IDENT23=null;
        Token EQUALS24=null;
        Token STRING25=null;
        Token SEMICOLON26=null;

        CommonTree string_literal22_tree=null;
        CommonTree IDENT23_tree=null;
        CommonTree EQUALS24_tree=null;
        CommonTree STRING25_tree=null;
        CommonTree SEMICOLON26_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:112:2: ( 'attr' IDENT EQUALS STRING SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:112:4: 'attr' IDENT EQUALS STRING SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal22=(Token)match(input,32,FOLLOW_32_in_attributeDecl197); 
            string_literal22_tree = (CommonTree)adaptor.create(string_literal22);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal22_tree, root_0);

            IDENT23=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeDecl200); 
            IDENT23_tree = (CommonTree)adaptor.create(IDENT23);
            adaptor.addChild(root_0, IDENT23_tree);

            EQUALS24=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeDecl202); 
            STRING25=(Token)match(input,STRING,FOLLOW_STRING_in_attributeDecl205); 
            STRING25_tree = (CommonTree)adaptor.create(STRING25);
            adaptor.addChild(root_0, STRING25_tree);

            SEMICOLON26=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeDecl207); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		System.out.println("ERROR: " + e.getMessage());
        		System.exit(1);
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:115:1: pinDecl : type ( sliceDecl )? IDENT EQUALS pinList SEMICOLON ;
    public final PhdlParser.pinDecl_return pinDecl() throws RecognitionException {
        PhdlParser.pinDecl_return retval = new PhdlParser.pinDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT29=null;
        Token EQUALS30=null;
        Token SEMICOLON32=null;
        PhdlParser.type_return type27 = null;

        PhdlParser.sliceDecl_return sliceDecl28 = null;

        PhdlParser.pinList_return pinList31 = null;


        CommonTree IDENT29_tree=null;
        CommonTree EQUALS30_tree=null;
        CommonTree SEMICOLON32_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:121:2: ( type ( sliceDecl )? IDENT EQUALS pinList SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:121:4: type ( sliceDecl )? IDENT EQUALS pinList SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_type_in_pinDecl221);
            type27=type();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(type27.getTree(), root_0);
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:121:10: ( sliceDecl )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==LEFTBRACKET) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:121:10: sliceDecl
                    {
                    pushFollow(FOLLOW_sliceDecl_in_pinDecl224);
                    sliceDecl28=sliceDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceDecl28.getTree());

                    }
                    break;

            }

            IDENT29=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinDecl227); 
            IDENT29_tree = (CommonTree)adaptor.create(IDENT29);
            adaptor.addChild(root_0, IDENT29_tree);

            EQUALS30=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinDecl229); 
            pushFollow(FOLLOW_pinList_in_pinDecl232);
            pinList31=pinList();

            state._fsp--;

            adaptor.addChild(root_0, pinList31.getTree());
            SEMICOLON32=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinDecl234); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		System.out.println("ERROR: " + e.getMessage());
        		System.exit(1);
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:124:1: type : 'pin' ;
    public final PhdlParser.type_return type() throws RecognitionException {
        PhdlParser.type_return retval = new PhdlParser.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal33=null;

        CommonTree string_literal33_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:128:2: ( 'pin' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:128:4: 'pin'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal33=(Token)match(input,33,FOLLOW_33_in_type249); 
            string_literal33_tree = (CommonTree)adaptor.create(string_literal33);
            adaptor.addChild(root_0, string_literal33_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		System.out.println("ERROR: " + e.getMessage());
        		System.exit(1);
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:131:1: netDecl : 'net' ( sliceDecl )? IDENT ( netAttributes )? SEMICOLON ;
    public final PhdlParser.netDecl_return netDecl() throws RecognitionException {
        PhdlParser.netDecl_return retval = new PhdlParser.netDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal34=null;
        Token IDENT36=null;
        Token SEMICOLON38=null;
        PhdlParser.sliceDecl_return sliceDecl35 = null;

        PhdlParser.netAttributes_return netAttributes37 = null;


        CommonTree string_literal34_tree=null;
        CommonTree IDENT36_tree=null;
        CommonTree SEMICOLON38_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:136:2: ( 'net' ( sliceDecl )? IDENT ( netAttributes )? SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:136:4: 'net' ( sliceDecl )? IDENT ( netAttributes )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal34=(Token)match(input,34,FOLLOW_34_in_netDecl263); 
            string_literal34_tree = (CommonTree)adaptor.create(string_literal34);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal34_tree, root_0);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:136:11: ( sliceDecl )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==LEFTBRACKET) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:136:11: sliceDecl
                    {
                    pushFollow(FOLLOW_sliceDecl_in_netDecl266);
                    sliceDecl35=sliceDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceDecl35.getTree());

                    }
                    break;

            }

            IDENT36=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl269); 
            IDENT36_tree = (CommonTree)adaptor.create(IDENT36);
            adaptor.addChild(root_0, IDENT36_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:136:28: ( netAttributes )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==28) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:136:28: netAttributes
                    {
                    pushFollow(FOLLOW_netAttributes_in_netDecl271);
                    netAttributes37=netAttributes();

                    state._fsp--;

                    adaptor.addChild(root_0, netAttributes37.getTree());

                    }
                    break;

            }

            SEMICOLON38=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netDecl274); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		System.out.println("ERROR: " + e.getMessage());
        		System.exit(1);
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:139:1: netAttributes : 'is' ( attributeDecl )* 'end' ( 'net' )? ;
    public final PhdlParser.netAttributes_return netAttributes() throws RecognitionException {
        PhdlParser.netAttributes_return retval = new PhdlParser.netAttributes_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal39=null;
        Token string_literal41=null;
        Token string_literal42=null;
        PhdlParser.attributeDecl_return attributeDecl40 = null;


        CommonTree string_literal39_tree=null;
        CommonTree string_literal41_tree=null;
        CommonTree string_literal42_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:144:2: ( 'is' ( attributeDecl )* 'end' ( 'net' )? )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:144:4: 'is' ( attributeDecl )* 'end' ( 'net' )?
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal39=(Token)match(input,28,FOLLOW_28_in_netAttributes290); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:144:10: ( attributeDecl )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==32) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:144:10: attributeDecl
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_netAttributes293);
            	    attributeDecl40=attributeDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeDecl40.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            string_literal41=(Token)match(input,30,FOLLOW_30_in_netAttributes296); 
            string_literal41_tree = (CommonTree)adaptor.create(string_literal41);
            adaptor.addChild(root_0, string_literal41_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:144:36: ( 'net' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==34) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:144:36: 'net'
                    {
                    string_literal42=(Token)match(input,34,FOLLOW_34_in_netAttributes298); 

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		System.out.println("ERROR: " + e.getMessage());
        		System.exit(1);
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:147:1: instanceDecl : 'inst' ( arrayDecl )? IDENT 'of' IDENT 'is' ( attributeAssignment | pinAssignment )* 'end' ( 'inst' )? SEMICOLON ;
    public final PhdlParser.instanceDecl_return instanceDecl() throws RecognitionException {
        PhdlParser.instanceDecl_return retval = new PhdlParser.instanceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal43=null;
        Token IDENT45=null;
        Token string_literal46=null;
        Token IDENT47=null;
        Token string_literal48=null;
        Token string_literal51=null;
        Token string_literal52=null;
        Token SEMICOLON53=null;
        PhdlParser.arrayDecl_return arrayDecl44 = null;

        PhdlParser.attributeAssignment_return attributeAssignment49 = null;

        PhdlParser.pinAssignment_return pinAssignment50 = null;


        CommonTree string_literal43_tree=null;
        CommonTree IDENT45_tree=null;
        CommonTree string_literal46_tree=null;
        CommonTree IDENT47_tree=null;
        CommonTree string_literal48_tree=null;
        CommonTree string_literal51_tree=null;
        CommonTree string_literal52_tree=null;
        CommonTree SEMICOLON53_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:153:2: ( 'inst' ( arrayDecl )? IDENT 'of' IDENT 'is' ( attributeAssignment | pinAssignment )* 'end' ( 'inst' )? SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:153:4: 'inst' ( arrayDecl )? IDENT 'of' IDENT 'is' ( attributeAssignment | pinAssignment )* 'end' ( 'inst' )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal43=(Token)match(input,35,FOLLOW_35_in_instanceDecl313); 
            string_literal43_tree = (CommonTree)adaptor.create(string_literal43);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal43_tree, root_0);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:153:12: ( arrayDecl )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==LEFTPAREN) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:153:12: arrayDecl
                    {
                    pushFollow(FOLLOW_arrayDecl_in_instanceDecl316);
                    arrayDecl44=arrayDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayDecl44.getTree());

                    }
                    break;

            }

            IDENT45=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceDecl319); 
            IDENT45_tree = (CommonTree)adaptor.create(IDENT45);
            adaptor.addChild(root_0, IDENT45_tree);

            string_literal46=(Token)match(input,36,FOLLOW_36_in_instanceDecl321); 
            IDENT47=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceDecl324); 
            IDENT47_tree = (CommonTree)adaptor.create(IDENT47);
            adaptor.addChild(root_0, IDENT47_tree);

            string_literal48=(Token)match(input,28,FOLLOW_28_in_instanceDecl326); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:154:3: ( attributeAssignment | pinAssignment )*
            loop13:
            do {
                int alt13=3;
                alt13 = dfa13.predict(input);
                switch (alt13) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:154:4: attributeAssignment
            	    {
            	    pushFollow(FOLLOW_attributeAssignment_in_instanceDecl332);
            	    attributeAssignment49=attributeAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeAssignment49.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:154:26: pinAssignment
            	    {
            	    pushFollow(FOLLOW_pinAssignment_in_instanceDecl336);
            	    pinAssignment50=pinAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinAssignment50.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            string_literal51=(Token)match(input,30,FOLLOW_30_in_instanceDecl342); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:155:16: ( 'inst' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==35) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:155:16: 'inst'
                    {
                    string_literal52=(Token)match(input,35,FOLLOW_35_in_instanceDecl345); 

                    }
                    break;

            }

            SEMICOLON53=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_instanceDecl349); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		System.out.println("ERROR: " + e.getMessage());
        		System.exit(1);
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:158:1: attributeAssignment : ( 'newattr' )? ( instanceQualifier )? IDENT EQUALS STRING SEMICOLON ;
    public final PhdlParser.attributeAssignment_return attributeAssignment() throws RecognitionException {
        PhdlParser.attributeAssignment_return retval = new PhdlParser.attributeAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal54=null;
        Token IDENT56=null;
        Token EQUALS57=null;
        Token STRING58=null;
        Token SEMICOLON59=null;
        PhdlParser.instanceQualifier_return instanceQualifier55 = null;


        CommonTree string_literal54_tree=null;
        CommonTree IDENT56_tree=null;
        CommonTree EQUALS57_tree=null;
        CommonTree STRING58_tree=null;
        CommonTree SEMICOLON59_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:164:2: ( ( 'newattr' )? ( instanceQualifier )? IDENT EQUALS STRING SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:164:5: ( 'newattr' )? ( instanceQualifier )? IDENT EQUALS STRING SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:164:5: ( 'newattr' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==37) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:164:6: 'newattr'
                    {
                    string_literal54=(Token)match(input,37,FOLLOW_37_in_attributeAssignment365); 
                    string_literal54_tree = (CommonTree)adaptor.create(string_literal54);
                    adaptor.addChild(root_0, string_literal54_tree);


                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:164:18: ( instanceQualifier )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==IDENT) ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==PERIOD||LA16_1==LEFTPAREN) ) {
                    alt16=1;
                }
            }
            switch (alt16) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:164:18: instanceQualifier
                    {
                    pushFollow(FOLLOW_instanceQualifier_in_attributeAssignment369);
                    instanceQualifier55=instanceQualifier();

                    state._fsp--;

                    adaptor.addChild(root_0, instanceQualifier55.getTree());

                    }
                    break;

            }

            IDENT56=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeAssignment372); 
            IDENT56_tree = (CommonTree)adaptor.create(IDENT56);
            adaptor.addChild(root_0, IDENT56_tree);

            EQUALS57=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeAssignment374); 
            EQUALS57_tree = (CommonTree)adaptor.create(EQUALS57);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS57_tree, root_0);

            STRING58=(Token)match(input,STRING,FOLLOW_STRING_in_attributeAssignment377); 
            STRING58_tree = (CommonTree)adaptor.create(STRING58);
            adaptor.addChild(root_0, STRING58_tree);

            SEMICOLON59=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeAssignment379); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		System.out.println("ERROR: " + e.getMessage());
        		System.exit(1);
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:167:1: instanceQualifier : IDENT ( arrayList )? PERIOD ;
    public final PhdlParser.instanceQualifier_return instanceQualifier() throws RecognitionException {
        PhdlParser.instanceQualifier_return retval = new PhdlParser.instanceQualifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT60=null;
        Token PERIOD62=null;
        PhdlParser.arrayList_return arrayList61 = null;


        CommonTree IDENT60_tree=null;
        CommonTree PERIOD62_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:172:2: ( IDENT ( arrayList )? PERIOD )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:172:4: IDENT ( arrayList )? PERIOD
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT60=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceQualifier394); 
            IDENT60_tree = (CommonTree)adaptor.create(IDENT60);
            adaptor.addChild(root_0, IDENT60_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:172:10: ( arrayList )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==LEFTPAREN) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:172:10: arrayList
                    {
                    pushFollow(FOLLOW_arrayList_in_instanceQualifier396);
                    arrayList61=arrayList();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayList61.getTree());

                    }
                    break;

            }

            PERIOD62=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_instanceQualifier399); 
            PERIOD62_tree = (CommonTree)adaptor.create(PERIOD62);
            root_0 = (CommonTree)adaptor.becomeRoot(PERIOD62_tree, root_0);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		System.out.println("ERROR: " + e.getMessage());
        		System.exit(1);
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:175:1: pinAssignment : ( instanceQualifier )? IDENT ( sliceList )? EQUALS concatenation SEMICOLON ;
    public final PhdlParser.pinAssignment_return pinAssignment() throws RecognitionException {
        PhdlParser.pinAssignment_return retval = new PhdlParser.pinAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT64=null;
        Token EQUALS66=null;
        Token SEMICOLON68=null;
        PhdlParser.instanceQualifier_return instanceQualifier63 = null;

        PhdlParser.sliceList_return sliceList65 = null;

        PhdlParser.concatenation_return concatenation67 = null;


        CommonTree IDENT64_tree=null;
        CommonTree EQUALS66_tree=null;
        CommonTree SEMICOLON68_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:180:2: ( ( instanceQualifier )? IDENT ( sliceList )? EQUALS concatenation SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:180:4: ( instanceQualifier )? IDENT ( sliceList )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:180:4: ( instanceQualifier )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==IDENT) ) {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==PERIOD||LA18_1==LEFTPAREN) ) {
                    alt18=1;
                }
            }
            switch (alt18) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:180:4: instanceQualifier
                    {
                    pushFollow(FOLLOW_instanceQualifier_in_pinAssignment415);
                    instanceQualifier63=instanceQualifier();

                    state._fsp--;

                    adaptor.addChild(root_0, instanceQualifier63.getTree());

                    }
                    break;

            }

            IDENT64=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinAssignment418); 
            IDENT64_tree = (CommonTree)adaptor.create(IDENT64);
            adaptor.addChild(root_0, IDENT64_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:180:29: ( sliceList )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==LEFTBRACKET) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:180:29: sliceList
                    {
                    pushFollow(FOLLOW_sliceList_in_pinAssignment420);
                    sliceList65=sliceList();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceList65.getTree());

                    }
                    break;

            }

            EQUALS66=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinAssignment423); 
            EQUALS66_tree = (CommonTree)adaptor.create(EQUALS66);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS66_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_pinAssignment426);
            concatenation67=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation67.getTree());
            SEMICOLON68=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinAssignment428); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		System.out.println("ERROR: " + e.getMessage());
        		System.exit(1);
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:183:1: netAssignment : IDENT ( sliceList )? EQUALS concatenation SEMICOLON ;
    public final PhdlParser.netAssignment_return netAssignment() throws RecognitionException {
        PhdlParser.netAssignment_return retval = new PhdlParser.netAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT69=null;
        Token EQUALS71=null;
        Token SEMICOLON73=null;
        PhdlParser.sliceList_return sliceList70 = null;

        PhdlParser.concatenation_return concatenation72 = null;


        CommonTree IDENT69_tree=null;
        CommonTree EQUALS71_tree=null;
        CommonTree SEMICOLON73_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:187:2: ( IDENT ( sliceList )? EQUALS concatenation SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:187:4: IDENT ( sliceList )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT69=(Token)match(input,IDENT,FOLLOW_IDENT_in_netAssignment442); 
            IDENT69_tree = (CommonTree)adaptor.create(IDENT69);
            adaptor.addChild(root_0, IDENT69_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:187:10: ( sliceList )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==LEFTBRACKET) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:187:10: sliceList
                    {
                    pushFollow(FOLLOW_sliceList_in_netAssignment444);
                    sliceList70=sliceList();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceList70.getTree());

                    }
                    break;

            }

            EQUALS71=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_netAssignment447); 
            EQUALS71_tree = (CommonTree)adaptor.create(EQUALS71);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS71_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_netAssignment450);
            concatenation72=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation72.getTree());
            SEMICOLON73=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netAssignment452); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		System.out.println("ERROR: " + e.getMessage());
        		System.exit(1);
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:190:1: concatenation : ( ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* ) | LEFTANGLE IDENT RIGHTANGLE | 'open' );
    public final PhdlParser.concatenation_return concatenation() throws RecognitionException {
        PhdlParser.concatenation_return retval = new PhdlParser.concatenation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT74=null;
        Token AMPERSAND76=null;
        Token IDENT77=null;
        Token LEFTANGLE79=null;
        Token IDENT80=null;
        Token RIGHTANGLE81=null;
        Token string_literal82=null;
        PhdlParser.sliceList_return sliceList75 = null;

        PhdlParser.sliceList_return sliceList78 = null;


        CommonTree IDENT74_tree=null;
        CommonTree AMPERSAND76_tree=null;
        CommonTree IDENT77_tree=null;
        CommonTree LEFTANGLE79_tree=null;
        CommonTree IDENT80_tree=null;
        CommonTree RIGHTANGLE81_tree=null;
        CommonTree string_literal82_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:196:2: ( ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* ) | LEFTANGLE IDENT RIGHTANGLE | 'open' )
            int alt24=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt24=1;
                }
                break;
            case LEFTANGLE:
                {
                alt24=2;
                }
                break;
            case 38:
                {
                alt24=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:196:4: ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:196:4: ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:196:5: ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )*
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:196:5: ( IDENT ( sliceList )? )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:196:6: IDENT ( sliceList )?
                    {
                    IDENT74=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation468); 
                    IDENT74_tree = (CommonTree)adaptor.create(IDENT74);
                    adaptor.addChild(root_0, IDENT74_tree);

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:196:12: ( sliceList )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==LEFTBRACKET) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:196:12: sliceList
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation470);
                            sliceList75=sliceList();

                            state._fsp--;

                            adaptor.addChild(root_0, sliceList75.getTree());

                            }
                            break;

                    }


                    }

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:196:24: ( AMPERSAND IDENT ( sliceList )? )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==AMPERSAND) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:196:25: AMPERSAND IDENT ( sliceList )?
                    	    {
                    	    AMPERSAND76=(Token)match(input,AMPERSAND,FOLLOW_AMPERSAND_in_concatenation475); 
                    	    IDENT77=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation478); 
                    	    IDENT77_tree = (CommonTree)adaptor.create(IDENT77);
                    	    adaptor.addChild(root_0, IDENT77_tree);

                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:196:42: ( sliceList )?
                    	    int alt22=2;
                    	    int LA22_0 = input.LA(1);

                    	    if ( (LA22_0==LEFTBRACKET) ) {
                    	        alt22=1;
                    	    }
                    	    switch (alt22) {
                    	        case 1 :
                    	            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:196:42: sliceList
                    	            {
                    	            pushFollow(FOLLOW_sliceList_in_concatenation480);
                    	            sliceList78=sliceList();

                    	            state._fsp--;

                    	            adaptor.addChild(root_0, sliceList78.getTree());

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:197:4: LEFTANGLE IDENT RIGHTANGLE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    LEFTANGLE79=(Token)match(input,LEFTANGLE,FOLLOW_LEFTANGLE_in_concatenation491); 
                    LEFTANGLE79_tree = (CommonTree)adaptor.create(LEFTANGLE79);
                    adaptor.addChild(root_0, LEFTANGLE79_tree);

                    IDENT80=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation493); 
                    IDENT80_tree = (CommonTree)adaptor.create(IDENT80);
                    adaptor.addChild(root_0, IDENT80_tree);

                    RIGHTANGLE81=(Token)match(input,RIGHTANGLE,FOLLOW_RIGHTANGLE_in_concatenation495); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:198:5: 'open'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal82=(Token)match(input,38,FOLLOW_38_in_concatenation502); 
                    string_literal82_tree = (CommonTree)adaptor.create(string_literal82);
                    adaptor.addChild(root_0, string_literal82_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		System.out.println("ERROR: " + e.getMessage());
        		System.exit(1);
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:201:1: pinList : LEFTBRACE ( IDENT | PIN | INTEGER ) ( COMMA ( IDENT | PIN | INTEGER ) )* RIGHTBRACE ;
    public final PhdlParser.pinList_return pinList() throws RecognitionException {
        PhdlParser.pinList_return retval = new PhdlParser.pinList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTBRACE83=null;
        Token set84=null;
        Token COMMA85=null;
        Token set86=null;
        Token RIGHTBRACE87=null;

        CommonTree LEFTBRACE83_tree=null;
        CommonTree set84_tree=null;
        CommonTree COMMA85_tree=null;
        CommonTree set86_tree=null;
        CommonTree RIGHTBRACE87_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:206:2: ( LEFTBRACE ( IDENT | PIN | INTEGER ) ( COMMA ( IDENT | PIN | INTEGER ) )* RIGHTBRACE )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:206:5: LEFTBRACE ( IDENT | PIN | INTEGER ) ( COMMA ( IDENT | PIN | INTEGER ) )* RIGHTBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACE83=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_pinList517); 
            set84=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||(input.LA(1)>=PIN && input.LA(1)<=INTEGER) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set84));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:206:40: ( COMMA ( IDENT | PIN | INTEGER ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==COMMA) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:206:41: COMMA ( IDENT | PIN | INTEGER )
            	    {
            	    COMMA85=(Token)match(input,COMMA,FOLLOW_COMMA_in_pinList533); 
            	    set86=(Token)input.LT(1);
            	    if ( input.LA(1)==IDENT||(input.LA(1)>=PIN && input.LA(1)<=INTEGER) ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (CommonTree)adaptor.create(set86));
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            RIGHTBRACE87=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_pinList550); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		System.out.println("ERROR: " + e.getMessage());
        		System.exit(1);
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:209:1: sliceList : LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTBRACKET ;
    public final PhdlParser.sliceList_return sliceList() throws RecognitionException {
        PhdlParser.sliceList_return retval = new PhdlParser.sliceList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTBRACKET88=null;
        Token INTEGER89=null;
        Token COLON90=null;
        Token INTEGER91=null;
        Token COMMA92=null;
        Token INTEGER93=null;
        Token COMMA94=null;
        Token INTEGER95=null;
        Token RIGHTBRACKET96=null;

        CommonTree LEFTBRACKET88_tree=null;
        CommonTree INTEGER89_tree=null;
        CommonTree COLON90_tree=null;
        CommonTree INTEGER91_tree=null;
        CommonTree COMMA92_tree=null;
        CommonTree INTEGER93_tree=null;
        CommonTree COMMA94_tree=null;
        CommonTree INTEGER95_tree=null;
        CommonTree RIGHTBRACKET96_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:214:2: ( LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTBRACKET )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:214:5: LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTBRACKET
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACKET88=(Token)match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList566); 
            LEFTBRACKET88_tree = (CommonTree)adaptor.create(LEFTBRACKET88);
            adaptor.addChild(root_0, LEFTBRACKET88_tree);

            INTEGER89=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList568); 
            INTEGER89_tree = (CommonTree)adaptor.create(INTEGER89);
            adaptor.addChild(root_0, INTEGER89_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:214:25: ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==COLON) ) {
                alt28=1;
            }
            else if ( (LA28_0==COMMA||LA28_0==RIGHTBRACKET) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:214:26: ( COLON INTEGER )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:214:26: ( COLON INTEGER )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:214:27: COLON INTEGER
                    {
                    COLON90=(Token)match(input,COLON,FOLLOW_COLON_in_sliceList572); 
                    COLON90_tree = (CommonTree)adaptor.create(COLON90);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON90_tree, root_0);

                    INTEGER91=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList575); 
                    INTEGER91_tree = (CommonTree)adaptor.create(INTEGER91);
                    adaptor.addChild(root_0, INTEGER91_tree);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:214:45: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:214:45: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==COMMA) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:214:46: COMMA INTEGER ( COMMA INTEGER )*
                            {
                            COMMA92=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceList581); 
                            COMMA92_tree = (CommonTree)adaptor.create(COMMA92);
                            root_0 = (CommonTree)adaptor.becomeRoot(COMMA92_tree, root_0);

                            INTEGER93=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList584); 
                            INTEGER93_tree = (CommonTree)adaptor.create(INTEGER93);
                            adaptor.addChild(root_0, INTEGER93_tree);

                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:214:61: ( COMMA INTEGER )*
                            loop26:
                            do {
                                int alt26=2;
                                int LA26_0 = input.LA(1);

                                if ( (LA26_0==COMMA) ) {
                                    alt26=1;
                                }


                                switch (alt26) {
                            	case 1 :
                            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:214:62: COMMA INTEGER
                            	    {
                            	    COMMA94=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceList587); 
                            	    INTEGER95=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList590); 
                            	    INTEGER95_tree = (CommonTree)adaptor.create(INTEGER95);
                            	    adaptor.addChild(root_0, INTEGER95_tree);


                            	    }
                            	    break;

                            	default :
                            	    break loop26;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }

            RIGHTBRACKET96=(Token)match(input,RIGHTBRACKET,FOLLOW_RIGHTBRACKET_in_sliceList597); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		System.out.println("ERROR: " + e.getMessage());
        		System.exit(1);
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:217:1: sliceDecl : LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RIGHTBRACKET ;
    public final PhdlParser.sliceDecl_return sliceDecl() throws RecognitionException {
        PhdlParser.sliceDecl_return retval = new PhdlParser.sliceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTBRACKET97=null;
        Token INTEGER98=null;
        Token COLON99=null;
        Token INTEGER100=null;
        Token COMMA101=null;
        Token INTEGER102=null;
        Token RIGHTBRACKET103=null;

        CommonTree LEFTBRACKET97_tree=null;
        CommonTree INTEGER98_tree=null;
        CommonTree COLON99_tree=null;
        CommonTree INTEGER100_tree=null;
        CommonTree COMMA101_tree=null;
        CommonTree INTEGER102_tree=null;
        CommonTree RIGHTBRACKET103_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:221:2: ( LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RIGHTBRACKET )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:221:4: LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RIGHTBRACKET
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACKET97=(Token)match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceDecl611); 
            LEFTBRACKET97_tree = (CommonTree)adaptor.create(LEFTBRACKET97);
            adaptor.addChild(root_0, LEFTBRACKET97_tree);

            INTEGER98=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl613); 
            INTEGER98_tree = (CommonTree)adaptor.create(INTEGER98);
            adaptor.addChild(root_0, INTEGER98_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:221:24: ( ( COLON INTEGER ) | ( COMMA INTEGER )+ )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==COLON) ) {
                alt30=1;
            }
            else if ( (LA30_0==COMMA) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:221:25: ( COLON INTEGER )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:221:25: ( COLON INTEGER )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:221:26: COLON INTEGER
                    {
                    COLON99=(Token)match(input,COLON,FOLLOW_COLON_in_sliceDecl617); 
                    COLON99_tree = (CommonTree)adaptor.create(COLON99);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON99_tree, root_0);

                    INTEGER100=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl620); 
                    INTEGER100_tree = (CommonTree)adaptor.create(INTEGER100);
                    adaptor.addChild(root_0, INTEGER100_tree);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:221:44: ( COMMA INTEGER )+
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:221:44: ( COMMA INTEGER )+
                    int cnt29=0;
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==COMMA) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:221:45: COMMA INTEGER
                    	    {
                    	    COMMA101=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceDecl626); 
                    	    COMMA101_tree = (CommonTree)adaptor.create(COMMA101);
                    	    root_0 = (CommonTree)adaptor.becomeRoot(COMMA101_tree, root_0);

                    	    INTEGER102=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl629); 
                    	    INTEGER102_tree = (CommonTree)adaptor.create(INTEGER102);
                    	    adaptor.addChild(root_0, INTEGER102_tree);


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt29 >= 1 ) break loop29;
                                EarlyExitException eee =
                                    new EarlyExitException(29, input);
                                throw eee;
                        }
                        cnt29++;
                    } while (true);


                    }
                    break;

            }

            RIGHTBRACKET103=(Token)match(input,RIGHTBRACKET,FOLLOW_RIGHTBRACKET_in_sliceDecl634); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		System.out.println("ERROR: " + e.getMessage());
        		System.exit(1);
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:224:1: arrayList : LEFTPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTPAREN ;
    public final PhdlParser.arrayList_return arrayList() throws RecognitionException {
        PhdlParser.arrayList_return retval = new PhdlParser.arrayList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTPAREN104=null;
        Token INTEGER105=null;
        Token COLON106=null;
        Token INTEGER107=null;
        Token COMMA108=null;
        Token INTEGER109=null;
        Token COMMA110=null;
        Token INTEGER111=null;
        Token RIGHTPAREN112=null;

        CommonTree LEFTPAREN104_tree=null;
        CommonTree INTEGER105_tree=null;
        CommonTree COLON106_tree=null;
        CommonTree INTEGER107_tree=null;
        CommonTree COMMA108_tree=null;
        CommonTree INTEGER109_tree=null;
        CommonTree COMMA110_tree=null;
        CommonTree INTEGER111_tree=null;
        CommonTree RIGHTPAREN112_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:229:2: ( LEFTPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTPAREN )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:229:5: LEFTPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTPAREN104=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList650); 
            LEFTPAREN104_tree = (CommonTree)adaptor.create(LEFTPAREN104);
            adaptor.addChild(root_0, LEFTPAREN104_tree);

            INTEGER105=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList652); 
            INTEGER105_tree = (CommonTree)adaptor.create(INTEGER105);
            adaptor.addChild(root_0, INTEGER105_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:229:23: ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==COLON) ) {
                alt33=1;
            }
            else if ( (LA33_0==COMMA||LA33_0==RIGHTPAREN) ) {
                alt33=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:229:24: ( COLON INTEGER )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:229:24: ( COLON INTEGER )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:229:25: COLON INTEGER
                    {
                    COLON106=(Token)match(input,COLON,FOLLOW_COLON_in_arrayList656); 
                    COLON106_tree = (CommonTree)adaptor.create(COLON106);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON106_tree, root_0);

                    INTEGER107=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList659); 
                    INTEGER107_tree = (CommonTree)adaptor.create(INTEGER107);
                    adaptor.addChild(root_0, INTEGER107_tree);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:229:43: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:229:43: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==COMMA) ) {
                        alt32=1;
                    }
                    switch (alt32) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:229:44: COMMA INTEGER ( COMMA INTEGER )*
                            {
                            COMMA108=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayList665); 
                            COMMA108_tree = (CommonTree)adaptor.create(COMMA108);
                            root_0 = (CommonTree)adaptor.becomeRoot(COMMA108_tree, root_0);

                            INTEGER109=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList668); 
                            INTEGER109_tree = (CommonTree)adaptor.create(INTEGER109);
                            adaptor.addChild(root_0, INTEGER109_tree);

                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:229:59: ( COMMA INTEGER )*
                            loop31:
                            do {
                                int alt31=2;
                                int LA31_0 = input.LA(1);

                                if ( (LA31_0==COMMA) ) {
                                    alt31=1;
                                }


                                switch (alt31) {
                            	case 1 :
                            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:229:60: COMMA INTEGER
                            	    {
                            	    COMMA110=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayList671); 
                            	    INTEGER111=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList674); 
                            	    INTEGER111_tree = (CommonTree)adaptor.create(INTEGER111);
                            	    adaptor.addChild(root_0, INTEGER111_tree);


                            	    }
                            	    break;

                            	default :
                            	    break loop31;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }

            RIGHTPAREN112=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_arrayList681); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		System.out.println("ERROR: " + e.getMessage());
        		System.exit(1);
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:232:1: arrayDecl : LEFTPAREN INTEGER COLON INTEGER RIGHTPAREN ;
    public final PhdlParser.arrayDecl_return arrayDecl() throws RecognitionException {
        PhdlParser.arrayDecl_return retval = new PhdlParser.arrayDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTPAREN113=null;
        Token INTEGER114=null;
        Token COLON115=null;
        Token INTEGER116=null;
        Token RIGHTPAREN117=null;

        CommonTree LEFTPAREN113_tree=null;
        CommonTree INTEGER114_tree=null;
        CommonTree COLON115_tree=null;
        CommonTree INTEGER116_tree=null;
        CommonTree RIGHTPAREN117_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:236:2: ( LEFTPAREN INTEGER COLON INTEGER RIGHTPAREN )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:236:4: LEFTPAREN INTEGER COLON INTEGER RIGHTPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTPAREN113=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayDecl695); 
            LEFTPAREN113_tree = (CommonTree)adaptor.create(LEFTPAREN113);
            adaptor.addChild(root_0, LEFTPAREN113_tree);

            INTEGER114=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayDecl697); 
            INTEGER114_tree = (CommonTree)adaptor.create(INTEGER114);
            adaptor.addChild(root_0, INTEGER114_tree);

            COLON115=(Token)match(input,COLON,FOLLOW_COLON_in_arrayDecl699); 
            COLON115_tree = (CommonTree)adaptor.create(COLON115);
            root_0 = (CommonTree)adaptor.becomeRoot(COLON115_tree, root_0);

            INTEGER116=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayDecl702); 
            INTEGER116_tree = (CommonTree)adaptor.create(INTEGER116);
            adaptor.addChild(root_0, INTEGER116_tree);

            RIGHTPAREN117=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_arrayDecl704); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		System.out.println("ERROR: " + e.getMessage());
        		System.exit(1);
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "arrayDecl"

    // Delegated rules


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\21\uffff";
    static final String DFA13_eofS =
        "\21\uffff";
    static final String DFA13_minS =
        "\1\4\2\uffff\1\6\1\4\1\16\1\4\1\uffff\1\17\1\6\2\16\1\10\1\25\1"+
        "\17\1\16\1\17";
    static final String DFA13_maxS =
        "\1\45\2\uffff\1\24\1\46\1\16\1\4\1\uffff\1\25\1\21\2\16\1\10\2"+
        "\25\1\16\1\25";
    static final String DFA13_acceptS =
        "\1\uffff\1\3\1\1\4\uffff\1\2\11\uffff";
    static final String DFA13_specialS =
        "\21\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\3\31\uffff\1\1\6\uffff\1\2",
            "",
            "",
            "\1\4\1\uffff\1\6\10\uffff\1\7\2\uffff\1\5",
            "\1\7\2\uffff\1\2\2\uffff\1\7\33\uffff\1\7",
            "\1\10",
            "\1\11",
            "",
            "\1\13\2\uffff\1\12\2\uffff\1\14",
            "\1\4\12\uffff\1\7",
            "\1\15",
            "\1\16",
            "\1\6",
            "\1\14",
            "\1\17\5\uffff\1\14",
            "\1\20",
            "\1\17\5\uffff\1\14"
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
            return "()* loopback of 154:3: ( attributeAssignment | pinAssignment )*";
        }
    }
 

    public static final BitSet FOLLOW_designDecl_in_sourceText74 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_EOF_in_sourceText77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_designDecl93 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_designDecl96 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_designDecl98 = new BitSet(new long[]{0x00000004A0000000L});
    public static final BitSet FOLLOW_deviceDecl_in_designDecl105 = new BitSet(new long[]{0x00000004A0000000L});
    public static final BitSet FOLLOW_netDecl_in_designDecl109 = new BitSet(new long[]{0x00000004A0000000L});
    public static final BitSet FOLLOW_29_in_designDecl115 = new BitSet(new long[]{0x0000000840000010L});
    public static final BitSet FOLLOW_instanceDecl_in_designDecl120 = new BitSet(new long[]{0x0000000840000010L});
    public static final BitSet FOLLOW_netAssignment_in_designDecl124 = new BitSet(new long[]{0x0000000840000010L});
    public static final BitSet FOLLOW_30_in_designDecl130 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_27_in_designDecl133 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_designDecl137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_deviceDecl152 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl155 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_deviceDecl157 = new BitSet(new long[]{0x0000000340000000L});
    public static final BitSet FOLLOW_attributeDecl_in_deviceDecl164 = new BitSet(new long[]{0x0000000340000000L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl168 = new BitSet(new long[]{0x0000000340000000L});
    public static final BitSet FOLLOW_30_in_deviceDecl175 = new BitSet(new long[]{0x0000000080000020L});
    public static final BitSet FOLLOW_31_in_deviceDecl178 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_deviceDecl182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_attributeDecl197 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attributeDecl200 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_attributeDecl202 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_in_attributeDecl205 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeDecl207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_pinDecl221 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_sliceDecl_in_pinDecl224 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl227 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_pinDecl229 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_pinList_in_pinDecl232 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinDecl234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_type249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_netDecl263 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_sliceDecl_in_netDecl266 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl269 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_netAttributes_in_netDecl271 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_netDecl274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_netAttributes290 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_attributeDecl_in_netAttributes293 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_30_in_netAttributes296 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_netAttributes298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_instanceDecl313 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_arrayDecl_in_instanceDecl316 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instanceDecl319 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_instanceDecl321 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instanceDecl324 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_instanceDecl326 = new BitSet(new long[]{0x0000002040000010L});
    public static final BitSet FOLLOW_attributeAssignment_in_instanceDecl332 = new BitSet(new long[]{0x0000002040000010L});
    public static final BitSet FOLLOW_pinAssignment_in_instanceDecl336 = new BitSet(new long[]{0x0000002040000010L});
    public static final BitSet FOLLOW_30_in_instanceDecl342 = new BitSet(new long[]{0x0000000800000020L});
    public static final BitSet FOLLOW_35_in_instanceDecl345 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_instanceDecl349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_attributeAssignment365 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_instanceQualifier_in_attributeAssignment369 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attributeAssignment372 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_attributeAssignment374 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_in_attributeAssignment377 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeAssignment379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_instanceQualifier394 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_arrayList_in_instanceQualifier396 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_PERIOD_in_instanceQualifier399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instanceQualifier_in_pinAssignment415 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinAssignment418 = new BitSet(new long[]{0x0000000000020040L});
    public static final BitSet FOLLOW_sliceList_in_pinAssignment420 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssignment423 = new BitSet(new long[]{0x0000004000000410L});
    public static final BitSet FOLLOW_concatenation_in_pinAssignment426 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinAssignment428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_netAssignment442 = new BitSet(new long[]{0x0000000000020040L});
    public static final BitSet FOLLOW_sliceList_in_netAssignment444 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_netAssignment447 = new BitSet(new long[]{0x0000004000000410L});
    public static final BitSet FOLLOW_concatenation_in_netAssignment450 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_netAssignment452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_concatenation468 = new BitSet(new long[]{0x0000000000020202L});
    public static final BitSet FOLLOW_sliceList_in_concatenation470 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_AMPERSAND_in_concatenation475 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation478 = new BitSet(new long[]{0x0000000000020202L});
    public static final BitSet FOLLOW_sliceList_in_concatenation480 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_LEFTANGLE_in_concatenation491 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation493 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RIGHTANGLE_in_concatenation495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_concatenation502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACE_in_pinList517 = new BitSet(new long[]{0x0000000000006010L});
    public static final BitSet FOLLOW_set_in_pinList520 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_COMMA_in_pinList533 = new BitSet(new long[]{0x0000000000006010L});
    public static final BitSet FOLLOW_set_in_pinList536 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_pinList550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList566 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList568 = new BitSet(new long[]{0x00000000000C8000L});
    public static final BitSet FOLLOW_COLON_in_sliceList572 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList575 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_COMMA_in_sliceList581 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList584 = new BitSet(new long[]{0x0000000000088000L});
    public static final BitSet FOLLOW_COMMA_in_sliceList587 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList590 = new BitSet(new long[]{0x0000000000088000L});
    public static final BitSet FOLLOW_RIGHTBRACKET_in_sliceList597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceDecl611 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl613 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_COLON_in_sliceDecl617 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl620 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_COMMA_in_sliceDecl626 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl629 = new BitSet(new long[]{0x0000000000088000L});
    public static final BitSet FOLLOW_RIGHTBRACKET_in_sliceDecl634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList650 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList652 = new BitSet(new long[]{0x0000000000248000L});
    public static final BitSet FOLLOW_COLON_in_arrayList656 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList659 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_COMMA_in_arrayList665 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList668 = new BitSet(new long[]{0x0000000000208000L});
    public static final BitSet FOLLOW_COMMA_in_arrayList671 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList674 = new BitSet(new long[]{0x0000000000208000L});
    public static final BitSet FOLLOW_RIGHTPAREN_in_arrayList681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayDecl695 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayDecl697 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_COLON_in_arrayDecl699 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayDecl702 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_RIGHTPAREN_in_arrayDecl704 = new BitSet(new long[]{0x0000000000000002L});

}