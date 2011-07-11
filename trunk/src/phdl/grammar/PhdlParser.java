// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g 2011-07-10 19:11:38

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
    public String getGrammarFileName() { return "C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g"; }



    	private Set<String> errors = new TreeSet<String>();

    //	@Override
    //	public void displayRecognitionError(String[] tokenNames,
    //			RecognitionException e) {
    //		String hdr = getErrorHeader(e);
    //		String msg = getErrorMessage(e, tokenNames);
    //		errors.add(hdr + " " + msg);
    //	}

    	public Set<String> getErrors() {
    		return errors;
    	}


    public static class sourceText_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sourceText"
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:65:1: sourceText : ( designDecl )* EOF ;
    public final PhdlParser.sourceText_return sourceText() throws RecognitionException {
        PhdlParser.sourceText_return retval = new PhdlParser.sourceText_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF2=null;
        PhdlParser.designDecl_return designDecl1 = null;


        CommonTree EOF2_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:69:2: ( ( designDecl )* EOF )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:69:4: ( designDecl )* EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:69:4: ( designDecl )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==27) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:69:4: designDecl
            	    {
            	    pushFollow(FOLLOW_designDecl_in_sourceText68);
            	    designDecl1=designDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, designDecl1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_sourceText71); 
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:75:1: designDecl : 'design' IDENT 'is' ( deviceDecl | netDecl )* 'begin' ( instanceDecl | netAssignment )* 'end' ( 'design' )? SEMICOLON ;
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
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:82:2: ( 'design' IDENT 'is' ( deviceDecl | netDecl )* 'begin' ( instanceDecl | netAssignment )* 'end' ( 'design' )? SEMICOLON )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:82:4: 'design' IDENT 'is' ( deviceDecl | netDecl )* 'begin' ( instanceDecl | netAssignment )* 'end' ( 'design' )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal3=(Token)match(input,27,FOLLOW_27_in_designDecl87); 
            string_literal3_tree = (CommonTree)adaptor.create(string_literal3);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal3_tree, root_0);

            IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_designDecl90); 
            IDENT4_tree = (CommonTree)adaptor.create(IDENT4);
            adaptor.addChild(root_0, IDENT4_tree);

            string_literal5=(Token)match(input,28,FOLLOW_28_in_designDecl92); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:83:3: ( deviceDecl | netDecl )*
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
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:83:4: deviceDecl
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_designDecl99);
            	    deviceDecl6=deviceDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, deviceDecl6.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:83:17: netDecl
            	    {
            	    pushFollow(FOLLOW_netDecl_in_designDecl103);
            	    netDecl7=netDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netDecl7.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            string_literal8=(Token)match(input,29,FOLLOW_29_in_designDecl109); 
            string_literal8_tree = (CommonTree)adaptor.create(string_literal8);
            adaptor.addChild(root_0, string_literal8_tree);

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:85:3: ( instanceDecl | netAssignment )*
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
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:85:4: instanceDecl
            	    {
            	    pushFollow(FOLLOW_instanceDecl_in_designDecl114);
            	    instanceDecl9=instanceDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, instanceDecl9.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:85:19: netAssignment
            	    {
            	    pushFollow(FOLLOW_netAssignment_in_designDecl118);
            	    netAssignment10=netAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netAssignment10.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            string_literal11=(Token)match(input,30,FOLLOW_30_in_designDecl124); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:86:18: ( 'design' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==27) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:86:18: 'design'
                    {
                    string_literal12=(Token)match(input,27,FOLLOW_27_in_designDecl127); 

                    }
                    break;

            }

            SEMICOLON13=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_designDecl131); 

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:89:1: deviceDecl : 'device' IDENT 'is' ( attributeDecl | pinDecl )* 'end' ( 'device' )? SEMICOLON ;
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
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:95:2: ( 'device' IDENT 'is' ( attributeDecl | pinDecl )* 'end' ( 'device' )? SEMICOLON )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:95:4: 'device' IDENT 'is' ( attributeDecl | pinDecl )* 'end' ( 'device' )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal14=(Token)match(input,31,FOLLOW_31_in_deviceDecl146); 
            string_literal14_tree = (CommonTree)adaptor.create(string_literal14);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal14_tree, root_0);

            IDENT15=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl149); 
            IDENT15_tree = (CommonTree)adaptor.create(IDENT15);
            adaptor.addChild(root_0, IDENT15_tree);

            string_literal16=(Token)match(input,28,FOLLOW_28_in_deviceDecl151); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:96:3: ( attributeDecl | pinDecl )*
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
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:96:5: attributeDecl
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_deviceDecl158);
            	    attributeDecl17=attributeDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeDecl17.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:96:21: pinDecl
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl162);
            	    pinDecl18=pinDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinDecl18.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            string_literal19=(Token)match(input,30,FOLLOW_30_in_deviceDecl169); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:97:18: ( 'device' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==31) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:97:18: 'device'
                    {
                    string_literal20=(Token)match(input,31,FOLLOW_31_in_deviceDecl172); 

                    }
                    break;

            }

            SEMICOLON21=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_deviceDecl176); 

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:100:1: attributeDecl : 'attr' IDENT EQUALS STRING SEMICOLON ;
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
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:105:2: ( 'attr' IDENT EQUALS STRING SEMICOLON )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:105:4: 'attr' IDENT EQUALS STRING SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal22=(Token)match(input,32,FOLLOW_32_in_attributeDecl191); 
            string_literal22_tree = (CommonTree)adaptor.create(string_literal22);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal22_tree, root_0);

            IDENT23=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeDecl194); 
            IDENT23_tree = (CommonTree)adaptor.create(IDENT23);
            adaptor.addChild(root_0, IDENT23_tree);

            EQUALS24=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeDecl196); 
            STRING25=(Token)match(input,STRING,FOLLOW_STRING_in_attributeDecl199); 
            STRING25_tree = (CommonTree)adaptor.create(STRING25);
            adaptor.addChild(root_0, STRING25_tree);

            SEMICOLON26=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeDecl201); 

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:108:1: pinDecl : type ( sliceDecl )? IDENT EQUALS pinList SEMICOLON ;
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
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:114:2: ( type ( sliceDecl )? IDENT EQUALS pinList SEMICOLON )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:114:4: type ( sliceDecl )? IDENT EQUALS pinList SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_type_in_pinDecl215);
            type27=type();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(type27.getTree(), root_0);
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:114:10: ( sliceDecl )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==LEFTBRACKET) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:114:10: sliceDecl
                    {
                    pushFollow(FOLLOW_sliceDecl_in_pinDecl218);
                    sliceDecl28=sliceDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceDecl28.getTree());

                    }
                    break;

            }

            IDENT29=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinDecl221); 
            IDENT29_tree = (CommonTree)adaptor.create(IDENT29);
            adaptor.addChild(root_0, IDENT29_tree);

            EQUALS30=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinDecl223); 
            pushFollow(FOLLOW_pinList_in_pinDecl226);
            pinList31=pinList();

            state._fsp--;

            adaptor.addChild(root_0, pinList31.getTree());
            SEMICOLON32=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinDecl228); 

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:117:1: type : 'pin' ;
    public final PhdlParser.type_return type() throws RecognitionException {
        PhdlParser.type_return retval = new PhdlParser.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal33=null;

        CommonTree string_literal33_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:121:2: ( 'pin' )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:121:4: 'pin'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal33=(Token)match(input,33,FOLLOW_33_in_type243); 
            string_literal33_tree = (CommonTree)adaptor.create(string_literal33);
            adaptor.addChild(root_0, string_literal33_tree);


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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:124:1: netDecl : 'net' ( sliceDecl )? IDENT ( netAttributes )? SEMICOLON ;
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
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:129:2: ( 'net' ( sliceDecl )? IDENT ( netAttributes )? SEMICOLON )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:129:4: 'net' ( sliceDecl )? IDENT ( netAttributes )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal34=(Token)match(input,34,FOLLOW_34_in_netDecl257); 
            string_literal34_tree = (CommonTree)adaptor.create(string_literal34);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal34_tree, root_0);

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:129:11: ( sliceDecl )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==LEFTBRACKET) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:129:11: sliceDecl
                    {
                    pushFollow(FOLLOW_sliceDecl_in_netDecl260);
                    sliceDecl35=sliceDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceDecl35.getTree());

                    }
                    break;

            }

            IDENT36=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl263); 
            IDENT36_tree = (CommonTree)adaptor.create(IDENT36);
            adaptor.addChild(root_0, IDENT36_tree);

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:129:28: ( netAttributes )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==28) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:129:28: netAttributes
                    {
                    pushFollow(FOLLOW_netAttributes_in_netDecl265);
                    netAttributes37=netAttributes();

                    state._fsp--;

                    adaptor.addChild(root_0, netAttributes37.getTree());

                    }
                    break;

            }

            SEMICOLON38=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netDecl268); 

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:132:1: netAttributes : 'is' ( attributeDecl )* 'end' ( 'net' )? ;
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
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:137:2: ( 'is' ( attributeDecl )* 'end' ( 'net' )? )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:137:4: 'is' ( attributeDecl )* 'end' ( 'net' )?
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal39=(Token)match(input,28,FOLLOW_28_in_netAttributes284); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:137:10: ( attributeDecl )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==32) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:137:10: attributeDecl
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_netAttributes287);
            	    attributeDecl40=attributeDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeDecl40.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            string_literal41=(Token)match(input,30,FOLLOW_30_in_netAttributes290); 
            string_literal41_tree = (CommonTree)adaptor.create(string_literal41);
            adaptor.addChild(root_0, string_literal41_tree);

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:137:36: ( 'net' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==34) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:137:36: 'net'
                    {
                    string_literal42=(Token)match(input,34,FOLLOW_34_in_netAttributes292); 

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:140:1: instanceDecl : 'inst' ( arrayDecl )? IDENT 'of' IDENT 'is' ( attributeAssignment | pinAssignment )* 'end' ( 'inst' )? SEMICOLON ;
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
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:146:2: ( 'inst' ( arrayDecl )? IDENT 'of' IDENT 'is' ( attributeAssignment | pinAssignment )* 'end' ( 'inst' )? SEMICOLON )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:146:4: 'inst' ( arrayDecl )? IDENT 'of' IDENT 'is' ( attributeAssignment | pinAssignment )* 'end' ( 'inst' )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal43=(Token)match(input,35,FOLLOW_35_in_instanceDecl307); 
            string_literal43_tree = (CommonTree)adaptor.create(string_literal43);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal43_tree, root_0);

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:146:12: ( arrayDecl )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==LEFTPAREN) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:146:12: arrayDecl
                    {
                    pushFollow(FOLLOW_arrayDecl_in_instanceDecl310);
                    arrayDecl44=arrayDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayDecl44.getTree());

                    }
                    break;

            }

            IDENT45=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceDecl313); 
            IDENT45_tree = (CommonTree)adaptor.create(IDENT45);
            adaptor.addChild(root_0, IDENT45_tree);

            string_literal46=(Token)match(input,36,FOLLOW_36_in_instanceDecl315); 
            IDENT47=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceDecl318); 
            IDENT47_tree = (CommonTree)adaptor.create(IDENT47);
            adaptor.addChild(root_0, IDENT47_tree);

            string_literal48=(Token)match(input,28,FOLLOW_28_in_instanceDecl320); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:147:3: ( attributeAssignment | pinAssignment )*
            loop13:
            do {
                int alt13=3;
                alt13 = dfa13.predict(input);
                switch (alt13) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:147:4: attributeAssignment
            	    {
            	    pushFollow(FOLLOW_attributeAssignment_in_instanceDecl326);
            	    attributeAssignment49=attributeAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeAssignment49.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:147:26: pinAssignment
            	    {
            	    pushFollow(FOLLOW_pinAssignment_in_instanceDecl330);
            	    pinAssignment50=pinAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinAssignment50.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            string_literal51=(Token)match(input,30,FOLLOW_30_in_instanceDecl336); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:148:16: ( 'inst' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==35) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:148:16: 'inst'
                    {
                    string_literal52=(Token)match(input,35,FOLLOW_35_in_instanceDecl339); 

                    }
                    break;

            }

            SEMICOLON53=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_instanceDecl343); 

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:151:1: attributeAssignment : ( 'newattr' )? ( instanceQualifier )? IDENT EQUALS STRING SEMICOLON ;
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
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:157:2: ( ( 'newattr' )? ( instanceQualifier )? IDENT EQUALS STRING SEMICOLON )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:157:5: ( 'newattr' )? ( instanceQualifier )? IDENT EQUALS STRING SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:157:5: ( 'newattr' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==37) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:157:6: 'newattr'
                    {
                    string_literal54=(Token)match(input,37,FOLLOW_37_in_attributeAssignment359); 
                    string_literal54_tree = (CommonTree)adaptor.create(string_literal54);
                    adaptor.addChild(root_0, string_literal54_tree);


                    }
                    break;

            }

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:157:18: ( instanceQualifier )?
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
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:157:18: instanceQualifier
                    {
                    pushFollow(FOLLOW_instanceQualifier_in_attributeAssignment363);
                    instanceQualifier55=instanceQualifier();

                    state._fsp--;

                    adaptor.addChild(root_0, instanceQualifier55.getTree());

                    }
                    break;

            }

            IDENT56=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeAssignment366); 
            IDENT56_tree = (CommonTree)adaptor.create(IDENT56);
            adaptor.addChild(root_0, IDENT56_tree);

            EQUALS57=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeAssignment368); 
            EQUALS57_tree = (CommonTree)adaptor.create(EQUALS57);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS57_tree, root_0);

            STRING58=(Token)match(input,STRING,FOLLOW_STRING_in_attributeAssignment371); 
            STRING58_tree = (CommonTree)adaptor.create(STRING58);
            adaptor.addChild(root_0, STRING58_tree);

            SEMICOLON59=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeAssignment373); 

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:160:1: instanceQualifier : IDENT ( arrayList )? PERIOD ;
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
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:165:2: ( IDENT ( arrayList )? PERIOD )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:165:4: IDENT ( arrayList )? PERIOD
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT60=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceQualifier388); 
            IDENT60_tree = (CommonTree)adaptor.create(IDENT60);
            adaptor.addChild(root_0, IDENT60_tree);

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:165:10: ( arrayList )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==LEFTPAREN) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:165:10: arrayList
                    {
                    pushFollow(FOLLOW_arrayList_in_instanceQualifier390);
                    arrayList61=arrayList();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayList61.getTree());

                    }
                    break;

            }

            PERIOD62=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_instanceQualifier393); 
            PERIOD62_tree = (CommonTree)adaptor.create(PERIOD62);
            root_0 = (CommonTree)adaptor.becomeRoot(PERIOD62_tree, root_0);


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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:168:1: pinAssignment : ( instanceQualifier )? IDENT ( sliceList )? EQUALS concatenation SEMICOLON ;
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
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:173:2: ( ( instanceQualifier )? IDENT ( sliceList )? EQUALS concatenation SEMICOLON )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:173:4: ( instanceQualifier )? IDENT ( sliceList )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:173:4: ( instanceQualifier )?
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
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:173:4: instanceQualifier
                    {
                    pushFollow(FOLLOW_instanceQualifier_in_pinAssignment409);
                    instanceQualifier63=instanceQualifier();

                    state._fsp--;

                    adaptor.addChild(root_0, instanceQualifier63.getTree());

                    }
                    break;

            }

            IDENT64=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinAssignment412); 
            IDENT64_tree = (CommonTree)adaptor.create(IDENT64);
            adaptor.addChild(root_0, IDENT64_tree);

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:173:29: ( sliceList )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==LEFTBRACKET) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:173:29: sliceList
                    {
                    pushFollow(FOLLOW_sliceList_in_pinAssignment414);
                    sliceList65=sliceList();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceList65.getTree());

                    }
                    break;

            }

            EQUALS66=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinAssignment417); 
            EQUALS66_tree = (CommonTree)adaptor.create(EQUALS66);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS66_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_pinAssignment420);
            concatenation67=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation67.getTree());
            SEMICOLON68=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinAssignment422); 

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:176:1: netAssignment : IDENT ( sliceList )? EQUALS concatenation SEMICOLON ;
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
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:180:2: ( IDENT ( sliceList )? EQUALS concatenation SEMICOLON )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:180:4: IDENT ( sliceList )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT69=(Token)match(input,IDENT,FOLLOW_IDENT_in_netAssignment436); 
            IDENT69_tree = (CommonTree)adaptor.create(IDENT69);
            adaptor.addChild(root_0, IDENT69_tree);

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:180:10: ( sliceList )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==LEFTBRACKET) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:180:10: sliceList
                    {
                    pushFollow(FOLLOW_sliceList_in_netAssignment438);
                    sliceList70=sliceList();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceList70.getTree());

                    }
                    break;

            }

            EQUALS71=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_netAssignment441); 
            EQUALS71_tree = (CommonTree)adaptor.create(EQUALS71);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS71_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_netAssignment444);
            concatenation72=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation72.getTree());
            SEMICOLON73=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netAssignment446); 

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:183:1: concatenation : ( ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* ) | LEFTANGLE IDENT RIGHTANGLE | 'open' );
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
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:189:2: ( ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* ) | LEFTANGLE IDENT RIGHTANGLE | 'open' )
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
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:189:4: ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:189:4: ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:189:5: ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )*
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:189:5: ( IDENT ( sliceList )? )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:189:6: IDENT ( sliceList )?
                    {
                    IDENT74=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation462); 
                    IDENT74_tree = (CommonTree)adaptor.create(IDENT74);
                    adaptor.addChild(root_0, IDENT74_tree);

                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:189:12: ( sliceList )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==LEFTBRACKET) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:189:12: sliceList
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation464);
                            sliceList75=sliceList();

                            state._fsp--;

                            adaptor.addChild(root_0, sliceList75.getTree());

                            }
                            break;

                    }


                    }

                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:189:24: ( AMPERSAND IDENT ( sliceList )? )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==AMPERSAND) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:189:25: AMPERSAND IDENT ( sliceList )?
                    	    {
                    	    AMPERSAND76=(Token)match(input,AMPERSAND,FOLLOW_AMPERSAND_in_concatenation469); 
                    	    IDENT77=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation472); 
                    	    IDENT77_tree = (CommonTree)adaptor.create(IDENT77);
                    	    adaptor.addChild(root_0, IDENT77_tree);

                    	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:189:42: ( sliceList )?
                    	    int alt22=2;
                    	    int LA22_0 = input.LA(1);

                    	    if ( (LA22_0==LEFTBRACKET) ) {
                    	        alt22=1;
                    	    }
                    	    switch (alt22) {
                    	        case 1 :
                    	            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:189:42: sliceList
                    	            {
                    	            pushFollow(FOLLOW_sliceList_in_concatenation474);
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
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:190:4: LEFTANGLE IDENT RIGHTANGLE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    LEFTANGLE79=(Token)match(input,LEFTANGLE,FOLLOW_LEFTANGLE_in_concatenation485); 
                    LEFTANGLE79_tree = (CommonTree)adaptor.create(LEFTANGLE79);
                    adaptor.addChild(root_0, LEFTANGLE79_tree);

                    IDENT80=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation487); 
                    IDENT80_tree = (CommonTree)adaptor.create(IDENT80);
                    adaptor.addChild(root_0, IDENT80_tree);

                    RIGHTANGLE81=(Token)match(input,RIGHTANGLE,FOLLOW_RIGHTANGLE_in_concatenation489); 

                    }
                    break;
                case 3 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:191:5: 'open'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal82=(Token)match(input,38,FOLLOW_38_in_concatenation496); 
                    string_literal82_tree = (CommonTree)adaptor.create(string_literal82);
                    adaptor.addChild(root_0, string_literal82_tree);


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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:194:1: pinList : LEFTBRACE ( IDENT | PIN | INTEGER ) ( COMMA ( IDENT | PIN | INTEGER ) )* RIGHTBRACE ;
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
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:199:2: ( LEFTBRACE ( IDENT | PIN | INTEGER ) ( COMMA ( IDENT | PIN | INTEGER ) )* RIGHTBRACE )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:199:5: LEFTBRACE ( IDENT | PIN | INTEGER ) ( COMMA ( IDENT | PIN | INTEGER ) )* RIGHTBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACE83=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_pinList511); 
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

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:199:40: ( COMMA ( IDENT | PIN | INTEGER ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==COMMA) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:199:41: COMMA ( IDENT | PIN | INTEGER )
            	    {
            	    COMMA85=(Token)match(input,COMMA,FOLLOW_COMMA_in_pinList527); 
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

            RIGHTBRACE87=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_pinList544); 

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:202:1: sliceList : LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTBRACKET ;
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
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:207:2: ( LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTBRACKET )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:207:5: LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTBRACKET
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACKET88=(Token)match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList560); 
            LEFTBRACKET88_tree = (CommonTree)adaptor.create(LEFTBRACKET88);
            adaptor.addChild(root_0, LEFTBRACKET88_tree);

            INTEGER89=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList562); 
            INTEGER89_tree = (CommonTree)adaptor.create(INTEGER89);
            adaptor.addChild(root_0, INTEGER89_tree);

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:207:25: ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? )
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
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:207:26: ( COLON INTEGER )
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:207:26: ( COLON INTEGER )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:207:27: COLON INTEGER
                    {
                    COLON90=(Token)match(input,COLON,FOLLOW_COLON_in_sliceList566); 
                    COLON90_tree = (CommonTree)adaptor.create(COLON90);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON90_tree, root_0);

                    INTEGER91=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList569); 
                    INTEGER91_tree = (CommonTree)adaptor.create(INTEGER91);
                    adaptor.addChild(root_0, INTEGER91_tree);


                    }


                    }
                    break;
                case 2 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:207:45: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:207:45: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==COMMA) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:207:46: COMMA INTEGER ( COMMA INTEGER )*
                            {
                            COMMA92=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceList575); 
                            COMMA92_tree = (CommonTree)adaptor.create(COMMA92);
                            root_0 = (CommonTree)adaptor.becomeRoot(COMMA92_tree, root_0);

                            INTEGER93=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList578); 
                            INTEGER93_tree = (CommonTree)adaptor.create(INTEGER93);
                            adaptor.addChild(root_0, INTEGER93_tree);

                            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:207:61: ( COMMA INTEGER )*
                            loop26:
                            do {
                                int alt26=2;
                                int LA26_0 = input.LA(1);

                                if ( (LA26_0==COMMA) ) {
                                    alt26=1;
                                }


                                switch (alt26) {
                            	case 1 :
                            	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:207:62: COMMA INTEGER
                            	    {
                            	    COMMA94=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceList581); 
                            	    INTEGER95=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList584); 
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

            RIGHTBRACKET96=(Token)match(input,RIGHTBRACKET,FOLLOW_RIGHTBRACKET_in_sliceList591); 

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:210:1: sliceDecl : LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RIGHTBRACKET ;
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
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:214:2: ( LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RIGHTBRACKET )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:214:4: LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RIGHTBRACKET
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACKET97=(Token)match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceDecl605); 
            LEFTBRACKET97_tree = (CommonTree)adaptor.create(LEFTBRACKET97);
            adaptor.addChild(root_0, LEFTBRACKET97_tree);

            INTEGER98=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl607); 
            INTEGER98_tree = (CommonTree)adaptor.create(INTEGER98);
            adaptor.addChild(root_0, INTEGER98_tree);

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:214:24: ( ( COLON INTEGER ) | ( COMMA INTEGER )+ )
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
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:214:25: ( COLON INTEGER )
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:214:25: ( COLON INTEGER )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:214:26: COLON INTEGER
                    {
                    COLON99=(Token)match(input,COLON,FOLLOW_COLON_in_sliceDecl611); 
                    COLON99_tree = (CommonTree)adaptor.create(COLON99);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON99_tree, root_0);

                    INTEGER100=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl614); 
                    INTEGER100_tree = (CommonTree)adaptor.create(INTEGER100);
                    adaptor.addChild(root_0, INTEGER100_tree);


                    }


                    }
                    break;
                case 2 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:214:44: ( COMMA INTEGER )+
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:214:44: ( COMMA INTEGER )+
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
                    	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:214:45: COMMA INTEGER
                    	    {
                    	    COMMA101=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceDecl620); 
                    	    COMMA101_tree = (CommonTree)adaptor.create(COMMA101);
                    	    root_0 = (CommonTree)adaptor.becomeRoot(COMMA101_tree, root_0);

                    	    INTEGER102=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl623); 
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

            RIGHTBRACKET103=(Token)match(input,RIGHTBRACKET,FOLLOW_RIGHTBRACKET_in_sliceDecl628); 

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:217:1: arrayList : LEFTPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTPAREN ;
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
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:222:2: ( LEFTPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTPAREN )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:222:5: LEFTPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTPAREN104=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList644); 
            LEFTPAREN104_tree = (CommonTree)adaptor.create(LEFTPAREN104);
            adaptor.addChild(root_0, LEFTPAREN104_tree);

            INTEGER105=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList646); 
            INTEGER105_tree = (CommonTree)adaptor.create(INTEGER105);
            adaptor.addChild(root_0, INTEGER105_tree);

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:222:23: ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? )
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
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:222:24: ( COLON INTEGER )
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:222:24: ( COLON INTEGER )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:222:25: COLON INTEGER
                    {
                    COLON106=(Token)match(input,COLON,FOLLOW_COLON_in_arrayList650); 
                    COLON106_tree = (CommonTree)adaptor.create(COLON106);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON106_tree, root_0);

                    INTEGER107=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList653); 
                    INTEGER107_tree = (CommonTree)adaptor.create(INTEGER107);
                    adaptor.addChild(root_0, INTEGER107_tree);


                    }


                    }
                    break;
                case 2 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:222:43: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:222:43: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==COMMA) ) {
                        alt32=1;
                    }
                    switch (alt32) {
                        case 1 :
                            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:222:44: COMMA INTEGER ( COMMA INTEGER )*
                            {
                            COMMA108=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayList659); 
                            COMMA108_tree = (CommonTree)adaptor.create(COMMA108);
                            root_0 = (CommonTree)adaptor.becomeRoot(COMMA108_tree, root_0);

                            INTEGER109=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList662); 
                            INTEGER109_tree = (CommonTree)adaptor.create(INTEGER109);
                            adaptor.addChild(root_0, INTEGER109_tree);

                            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:222:59: ( COMMA INTEGER )*
                            loop31:
                            do {
                                int alt31=2;
                                int LA31_0 = input.LA(1);

                                if ( (LA31_0==COMMA) ) {
                                    alt31=1;
                                }


                                switch (alt31) {
                            	case 1 :
                            	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:222:60: COMMA INTEGER
                            	    {
                            	    COMMA110=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayList665); 
                            	    INTEGER111=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList668); 
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

            RIGHTPAREN112=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_arrayList675); 

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:225:1: arrayDecl : LEFTPAREN INTEGER COLON INTEGER RIGHTPAREN ;
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
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:229:2: ( LEFTPAREN INTEGER COLON INTEGER RIGHTPAREN )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:229:4: LEFTPAREN INTEGER COLON INTEGER RIGHTPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTPAREN113=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayDecl689); 
            LEFTPAREN113_tree = (CommonTree)adaptor.create(LEFTPAREN113);
            adaptor.addChild(root_0, LEFTPAREN113_tree);

            INTEGER114=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayDecl691); 
            INTEGER114_tree = (CommonTree)adaptor.create(INTEGER114);
            adaptor.addChild(root_0, INTEGER114_tree);

            COLON115=(Token)match(input,COLON,FOLLOW_COLON_in_arrayDecl693); 
            COLON115_tree = (CommonTree)adaptor.create(COLON115);
            root_0 = (CommonTree)adaptor.becomeRoot(COLON115_tree, root_0);

            INTEGER116=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayDecl696); 
            INTEGER116_tree = (CommonTree)adaptor.create(INTEGER116);
            adaptor.addChild(root_0, INTEGER116_tree);

            RIGHTPAREN117=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_arrayDecl698); 

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
            return "()* loopback of 147:3: ( attributeAssignment | pinAssignment )*";
        }
    }
 

    public static final BitSet FOLLOW_designDecl_in_sourceText68 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_EOF_in_sourceText71 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_designDecl87 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_designDecl90 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_designDecl92 = new BitSet(new long[]{0x00000004A0000000L});
    public static final BitSet FOLLOW_deviceDecl_in_designDecl99 = new BitSet(new long[]{0x00000004A0000000L});
    public static final BitSet FOLLOW_netDecl_in_designDecl103 = new BitSet(new long[]{0x00000004A0000000L});
    public static final BitSet FOLLOW_29_in_designDecl109 = new BitSet(new long[]{0x0000000840000010L});
    public static final BitSet FOLLOW_instanceDecl_in_designDecl114 = new BitSet(new long[]{0x0000000840000010L});
    public static final BitSet FOLLOW_netAssignment_in_designDecl118 = new BitSet(new long[]{0x0000000840000010L});
    public static final BitSet FOLLOW_30_in_designDecl124 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_27_in_designDecl127 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_designDecl131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_deviceDecl146 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl149 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_deviceDecl151 = new BitSet(new long[]{0x0000000340000000L});
    public static final BitSet FOLLOW_attributeDecl_in_deviceDecl158 = new BitSet(new long[]{0x0000000340000000L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl162 = new BitSet(new long[]{0x0000000340000000L});
    public static final BitSet FOLLOW_30_in_deviceDecl169 = new BitSet(new long[]{0x0000000080000020L});
    public static final BitSet FOLLOW_31_in_deviceDecl172 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_deviceDecl176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_attributeDecl191 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attributeDecl194 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_attributeDecl196 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_in_attributeDecl199 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeDecl201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_pinDecl215 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_sliceDecl_in_pinDecl218 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl221 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_pinDecl223 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_pinList_in_pinDecl226 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinDecl228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_type243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_netDecl257 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_sliceDecl_in_netDecl260 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl263 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_netAttributes_in_netDecl265 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_netDecl268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_netAttributes284 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_attributeDecl_in_netAttributes287 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_30_in_netAttributes290 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_netAttributes292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_instanceDecl307 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_arrayDecl_in_instanceDecl310 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instanceDecl313 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_instanceDecl315 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instanceDecl318 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_instanceDecl320 = new BitSet(new long[]{0x0000002040000010L});
    public static final BitSet FOLLOW_attributeAssignment_in_instanceDecl326 = new BitSet(new long[]{0x0000002040000010L});
    public static final BitSet FOLLOW_pinAssignment_in_instanceDecl330 = new BitSet(new long[]{0x0000002040000010L});
    public static final BitSet FOLLOW_30_in_instanceDecl336 = new BitSet(new long[]{0x0000000800000020L});
    public static final BitSet FOLLOW_35_in_instanceDecl339 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_instanceDecl343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_attributeAssignment359 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_instanceQualifier_in_attributeAssignment363 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attributeAssignment366 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_attributeAssignment368 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_in_attributeAssignment371 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeAssignment373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_instanceQualifier388 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_arrayList_in_instanceQualifier390 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_PERIOD_in_instanceQualifier393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instanceQualifier_in_pinAssignment409 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinAssignment412 = new BitSet(new long[]{0x0000000000020040L});
    public static final BitSet FOLLOW_sliceList_in_pinAssignment414 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssignment417 = new BitSet(new long[]{0x0000004000000410L});
    public static final BitSet FOLLOW_concatenation_in_pinAssignment420 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinAssignment422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_netAssignment436 = new BitSet(new long[]{0x0000000000020040L});
    public static final BitSet FOLLOW_sliceList_in_netAssignment438 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_netAssignment441 = new BitSet(new long[]{0x0000004000000410L});
    public static final BitSet FOLLOW_concatenation_in_netAssignment444 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_netAssignment446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_concatenation462 = new BitSet(new long[]{0x0000000000020202L});
    public static final BitSet FOLLOW_sliceList_in_concatenation464 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_AMPERSAND_in_concatenation469 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation472 = new BitSet(new long[]{0x0000000000020202L});
    public static final BitSet FOLLOW_sliceList_in_concatenation474 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_LEFTANGLE_in_concatenation485 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation487 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RIGHTANGLE_in_concatenation489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_concatenation496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACE_in_pinList511 = new BitSet(new long[]{0x0000000000006010L});
    public static final BitSet FOLLOW_set_in_pinList514 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_COMMA_in_pinList527 = new BitSet(new long[]{0x0000000000006010L});
    public static final BitSet FOLLOW_set_in_pinList530 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_pinList544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList560 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList562 = new BitSet(new long[]{0x00000000000C8000L});
    public static final BitSet FOLLOW_COLON_in_sliceList566 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList569 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_COMMA_in_sliceList575 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList578 = new BitSet(new long[]{0x0000000000088000L});
    public static final BitSet FOLLOW_COMMA_in_sliceList581 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList584 = new BitSet(new long[]{0x0000000000088000L});
    public static final BitSet FOLLOW_RIGHTBRACKET_in_sliceList591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceDecl605 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl607 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_COLON_in_sliceDecl611 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl614 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_COMMA_in_sliceDecl620 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl623 = new BitSet(new long[]{0x0000000000088000L});
    public static final BitSet FOLLOW_RIGHTBRACKET_in_sliceDecl628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList644 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList646 = new BitSet(new long[]{0x0000000000248000L});
    public static final BitSet FOLLOW_COLON_in_arrayList650 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList653 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_COMMA_in_arrayList659 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList662 = new BitSet(new long[]{0x0000000000208000L});
    public static final BitSet FOLLOW_COMMA_in_arrayList665 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList668 = new BitSet(new long[]{0x0000000000208000L});
    public static final BitSet FOLLOW_RIGHTPAREN_in_arrayList675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayDecl689 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayDecl691 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_COLON_in_arrayDecl693 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayDecl696 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_RIGHTPAREN_in_arrayDecl698 = new BitSet(new long[]{0x0000000000000002L});

}