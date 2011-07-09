// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g 2011-07-09 10:01:21

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:65:1: sourceText : ( designDecl )* EOF ;
    public final PhdlParser.sourceText_return sourceText() throws RecognitionException {
        PhdlParser.sourceText_return retval = new PhdlParser.sourceText_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF2=null;
        PhdlParser.designDecl_return designDecl1 = null;


        CommonTree EOF2_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:69:2: ( ( designDecl )* EOF )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:69:4: ( designDecl )* EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:69:4: ( designDecl )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==27) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:69:4: designDecl
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:75:1: designDecl : 'design' IDENT 'is' ( deviceDecl | netDecl )* 'begin' ( instanceDecl | netAssignment )* 'end' SEMICOLON ;
    public final PhdlParser.designDecl_return designDecl() throws RecognitionException {
        PhdlParser.designDecl_return retval = new PhdlParser.designDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal3=null;
        Token IDENT4=null;
        Token string_literal5=null;
        Token string_literal8=null;
        Token string_literal11=null;
        Token SEMICOLON12=null;
        PhdlParser.deviceDecl_return deviceDecl6 = null;

        PhdlParser.netDecl_return netDecl7 = null;

        PhdlParser.instanceDecl_return instanceDecl9 = null;

        PhdlParser.netAssignment_return netAssignment10 = null;


        CommonTree string_literal3_tree=null;
        CommonTree IDENT4_tree=null;
        CommonTree string_literal5_tree=null;
        CommonTree string_literal8_tree=null;
        CommonTree string_literal11_tree=null;
        CommonTree SEMICOLON12_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:82:2: ( 'design' IDENT 'is' ( deviceDecl | netDecl )* 'begin' ( instanceDecl | netAssignment )* 'end' SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:82:4: 'design' IDENT 'is' ( deviceDecl | netDecl )* 'begin' ( instanceDecl | netAssignment )* 'end' SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal3=(Token)match(input,27,FOLLOW_27_in_designDecl87); 
            string_literal3_tree = (CommonTree)adaptor.create(string_literal3);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal3_tree, root_0);

            IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_designDecl90); 
            IDENT4_tree = (CommonTree)adaptor.create(IDENT4);
            adaptor.addChild(root_0, IDENT4_tree);

            string_literal5=(Token)match(input,28,FOLLOW_28_in_designDecl92); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:83:3: ( deviceDecl | netDecl )*
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:83:4: deviceDecl
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_designDecl99);
            	    deviceDecl6=deviceDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, deviceDecl6.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:83:17: netDecl
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

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:85:3: ( instanceDecl | netAssignment )*
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:85:4: instanceDecl
            	    {
            	    pushFollow(FOLLOW_instanceDecl_in_designDecl114);
            	    instanceDecl9=instanceDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, instanceDecl9.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:85:19: netAssignment
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
            SEMICOLON12=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_designDecl127); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:89:1: deviceDecl : 'device' IDENT 'is' ( attributeDecl | pinDecl )* 'end' SEMICOLON ;
    public final PhdlParser.deviceDecl_return deviceDecl() throws RecognitionException {
        PhdlParser.deviceDecl_return retval = new PhdlParser.deviceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal13=null;
        Token IDENT14=null;
        Token string_literal15=null;
        Token string_literal18=null;
        Token SEMICOLON19=null;
        PhdlParser.attributeDecl_return attributeDecl16 = null;

        PhdlParser.pinDecl_return pinDecl17 = null;


        CommonTree string_literal13_tree=null;
        CommonTree IDENT14_tree=null;
        CommonTree string_literal15_tree=null;
        CommonTree string_literal18_tree=null;
        CommonTree SEMICOLON19_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:95:2: ( 'device' IDENT 'is' ( attributeDecl | pinDecl )* 'end' SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:95:4: 'device' IDENT 'is' ( attributeDecl | pinDecl )* 'end' SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal13=(Token)match(input,31,FOLLOW_31_in_deviceDecl142); 
            string_literal13_tree = (CommonTree)adaptor.create(string_literal13);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal13_tree, root_0);

            IDENT14=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl145); 
            IDENT14_tree = (CommonTree)adaptor.create(IDENT14);
            adaptor.addChild(root_0, IDENT14_tree);

            string_literal15=(Token)match(input,28,FOLLOW_28_in_deviceDecl147); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:96:3: ( attributeDecl | pinDecl )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==32) ) {
                    alt4=1;
                }
                else if ( (LA4_0==33) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:96:5: attributeDecl
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_deviceDecl154);
            	    attributeDecl16=attributeDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeDecl16.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:96:21: pinDecl
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl158);
            	    pinDecl17=pinDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinDecl17.getTree());

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            string_literal18=(Token)match(input,30,FOLLOW_30_in_deviceDecl165); 
            SEMICOLON19=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_deviceDecl168); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:100:1: attributeDecl : 'attr' IDENT EQUALS STRING SEMICOLON ;
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:105:2: ( 'attr' IDENT EQUALS STRING SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:105:4: 'attr' IDENT EQUALS STRING SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal20=(Token)match(input,32,FOLLOW_32_in_attributeDecl183); 
            string_literal20_tree = (CommonTree)adaptor.create(string_literal20);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal20_tree, root_0);

            IDENT21=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeDecl186); 
            IDENT21_tree = (CommonTree)adaptor.create(IDENT21);
            adaptor.addChild(root_0, IDENT21_tree);

            EQUALS22=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeDecl188); 
            STRING23=(Token)match(input,STRING,FOLLOW_STRING_in_attributeDecl191); 
            STRING23_tree = (CommonTree)adaptor.create(STRING23);
            adaptor.addChild(root_0, STRING23_tree);

            SEMICOLON24=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeDecl193); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:108:1: pinDecl : type ( sliceDecl )? IDENT EQUALS pinList SEMICOLON ;
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:114:2: ( type ( sliceDecl )? IDENT EQUALS pinList SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:114:4: type ( sliceDecl )? IDENT EQUALS pinList SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_type_in_pinDecl207);
            type25=type();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(type25.getTree(), root_0);
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:114:10: ( sliceDecl )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==LEFTBRACKET) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:114:10: sliceDecl
                    {
                    pushFollow(FOLLOW_sliceDecl_in_pinDecl210);
                    sliceDecl26=sliceDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceDecl26.getTree());

                    }
                    break;

            }

            IDENT27=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinDecl213); 
            IDENT27_tree = (CommonTree)adaptor.create(IDENT27);
            adaptor.addChild(root_0, IDENT27_tree);

            EQUALS28=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinDecl215); 
            pushFollow(FOLLOW_pinList_in_pinDecl218);
            pinList29=pinList();

            state._fsp--;

            adaptor.addChild(root_0, pinList29.getTree());
            SEMICOLON30=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinDecl220); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:117:1: type : 'pin' ;
    public final PhdlParser.type_return type() throws RecognitionException {
        PhdlParser.type_return retval = new PhdlParser.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal31=null;

        CommonTree string_literal31_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:121:2: ( 'pin' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:121:4: 'pin'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal31=(Token)match(input,33,FOLLOW_33_in_type235); 
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:124:1: netDecl : 'net' ( sliceDecl )? IDENT ( netAttributes )? SEMICOLON ;
    public final PhdlParser.netDecl_return netDecl() throws RecognitionException {
        PhdlParser.netDecl_return retval = new PhdlParser.netDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal32=null;
        Token IDENT34=null;
        Token SEMICOLON36=null;
        PhdlParser.sliceDecl_return sliceDecl33 = null;

        PhdlParser.netAttributes_return netAttributes35 = null;


        CommonTree string_literal32_tree=null;
        CommonTree IDENT34_tree=null;
        CommonTree SEMICOLON36_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:129:2: ( 'net' ( sliceDecl )? IDENT ( netAttributes )? SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:129:4: 'net' ( sliceDecl )? IDENT ( netAttributes )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal32=(Token)match(input,34,FOLLOW_34_in_netDecl249); 
            string_literal32_tree = (CommonTree)adaptor.create(string_literal32);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal32_tree, root_0);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:129:11: ( sliceDecl )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==LEFTBRACKET) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:129:11: sliceDecl
                    {
                    pushFollow(FOLLOW_sliceDecl_in_netDecl252);
                    sliceDecl33=sliceDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceDecl33.getTree());

                    }
                    break;

            }

            IDENT34=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl255); 
            IDENT34_tree = (CommonTree)adaptor.create(IDENT34);
            adaptor.addChild(root_0, IDENT34_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:129:28: ( netAttributes )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==28) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:129:28: netAttributes
                    {
                    pushFollow(FOLLOW_netAttributes_in_netDecl257);
                    netAttributes35=netAttributes();

                    state._fsp--;

                    adaptor.addChild(root_0, netAttributes35.getTree());

                    }
                    break;

            }

            SEMICOLON36=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netDecl260); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:132:1: netAttributes : 'is' ( attributeDecl )* 'end' ;
    public final PhdlParser.netAttributes_return netAttributes() throws RecognitionException {
        PhdlParser.netAttributes_return retval = new PhdlParser.netAttributes_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal37=null;
        Token string_literal39=null;
        PhdlParser.attributeDecl_return attributeDecl38 = null;


        CommonTree string_literal37_tree=null;
        CommonTree string_literal39_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:137:2: ( 'is' ( attributeDecl )* 'end' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:137:4: 'is' ( attributeDecl )* 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal37=(Token)match(input,28,FOLLOW_28_in_netAttributes276); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:137:10: ( attributeDecl )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==32) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:137:10: attributeDecl
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_netAttributes279);
            	    attributeDecl38=attributeDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeDecl38.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            string_literal39=(Token)match(input,30,FOLLOW_30_in_netAttributes282); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:140:1: instanceDecl : 'inst' ( arrayDecl )? IDENT 'of' IDENT 'is' ( attributeAssignment | pinAssignment )* 'end' SEMICOLON ;
    public final PhdlParser.instanceDecl_return instanceDecl() throws RecognitionException {
        PhdlParser.instanceDecl_return retval = new PhdlParser.instanceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal40=null;
        Token IDENT42=null;
        Token string_literal43=null;
        Token IDENT44=null;
        Token string_literal45=null;
        Token string_literal48=null;
        Token SEMICOLON49=null;
        PhdlParser.arrayDecl_return arrayDecl41 = null;

        PhdlParser.attributeAssignment_return attributeAssignment46 = null;

        PhdlParser.pinAssignment_return pinAssignment47 = null;


        CommonTree string_literal40_tree=null;
        CommonTree IDENT42_tree=null;
        CommonTree string_literal43_tree=null;
        CommonTree IDENT44_tree=null;
        CommonTree string_literal45_tree=null;
        CommonTree string_literal48_tree=null;
        CommonTree SEMICOLON49_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:146:2: ( 'inst' ( arrayDecl )? IDENT 'of' IDENT 'is' ( attributeAssignment | pinAssignment )* 'end' SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:146:4: 'inst' ( arrayDecl )? IDENT 'of' IDENT 'is' ( attributeAssignment | pinAssignment )* 'end' SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal40=(Token)match(input,35,FOLLOW_35_in_instanceDecl296); 
            string_literal40_tree = (CommonTree)adaptor.create(string_literal40);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal40_tree, root_0);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:146:12: ( arrayDecl )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==LEFTPAREN) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:146:12: arrayDecl
                    {
                    pushFollow(FOLLOW_arrayDecl_in_instanceDecl299);
                    arrayDecl41=arrayDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayDecl41.getTree());

                    }
                    break;

            }

            IDENT42=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceDecl302); 
            IDENT42_tree = (CommonTree)adaptor.create(IDENT42);
            adaptor.addChild(root_0, IDENT42_tree);

            string_literal43=(Token)match(input,36,FOLLOW_36_in_instanceDecl304); 
            IDENT44=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceDecl307); 
            IDENT44_tree = (CommonTree)adaptor.create(IDENT44);
            adaptor.addChild(root_0, IDENT44_tree);

            string_literal45=(Token)match(input,28,FOLLOW_28_in_instanceDecl309); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:147:3: ( attributeAssignment | pinAssignment )*
            loop10:
            do {
                int alt10=3;
                alt10 = dfa10.predict(input);
                switch (alt10) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:147:4: attributeAssignment
            	    {
            	    pushFollow(FOLLOW_attributeAssignment_in_instanceDecl315);
            	    attributeAssignment46=attributeAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeAssignment46.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:147:26: pinAssignment
            	    {
            	    pushFollow(FOLLOW_pinAssignment_in_instanceDecl319);
            	    pinAssignment47=pinAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinAssignment47.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            string_literal48=(Token)match(input,30,FOLLOW_30_in_instanceDecl325); 
            SEMICOLON49=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_instanceDecl328); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:151:1: attributeAssignment : ( 'newattr' )? ( instanceQualifier )? IDENT EQUALS STRING SEMICOLON ;
    public final PhdlParser.attributeAssignment_return attributeAssignment() throws RecognitionException {
        PhdlParser.attributeAssignment_return retval = new PhdlParser.attributeAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal50=null;
        Token IDENT52=null;
        Token EQUALS53=null;
        Token STRING54=null;
        Token SEMICOLON55=null;
        PhdlParser.instanceQualifier_return instanceQualifier51 = null;


        CommonTree string_literal50_tree=null;
        CommonTree IDENT52_tree=null;
        CommonTree EQUALS53_tree=null;
        CommonTree STRING54_tree=null;
        CommonTree SEMICOLON55_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:157:2: ( ( 'newattr' )? ( instanceQualifier )? IDENT EQUALS STRING SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:157:5: ( 'newattr' )? ( instanceQualifier )? IDENT EQUALS STRING SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:157:5: ( 'newattr' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==37) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:157:6: 'newattr'
                    {
                    string_literal50=(Token)match(input,37,FOLLOW_37_in_attributeAssignment344); 
                    string_literal50_tree = (CommonTree)adaptor.create(string_literal50);
                    adaptor.addChild(root_0, string_literal50_tree);


                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:157:18: ( instanceQualifier )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==IDENT) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==PERIOD||LA12_1==LEFTPAREN) ) {
                    alt12=1;
                }
            }
            switch (alt12) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:157:18: instanceQualifier
                    {
                    pushFollow(FOLLOW_instanceQualifier_in_attributeAssignment348);
                    instanceQualifier51=instanceQualifier();

                    state._fsp--;

                    adaptor.addChild(root_0, instanceQualifier51.getTree());

                    }
                    break;

            }

            IDENT52=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeAssignment351); 
            IDENT52_tree = (CommonTree)adaptor.create(IDENT52);
            adaptor.addChild(root_0, IDENT52_tree);

            EQUALS53=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeAssignment353); 
            EQUALS53_tree = (CommonTree)adaptor.create(EQUALS53);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS53_tree, root_0);

            STRING54=(Token)match(input,STRING,FOLLOW_STRING_in_attributeAssignment356); 
            STRING54_tree = (CommonTree)adaptor.create(STRING54);
            adaptor.addChild(root_0, STRING54_tree);

            SEMICOLON55=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeAssignment358); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:160:1: instanceQualifier : IDENT ( arrayList )? PERIOD ;
    public final PhdlParser.instanceQualifier_return instanceQualifier() throws RecognitionException {
        PhdlParser.instanceQualifier_return retval = new PhdlParser.instanceQualifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT56=null;
        Token PERIOD58=null;
        PhdlParser.arrayList_return arrayList57 = null;


        CommonTree IDENT56_tree=null;
        CommonTree PERIOD58_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:165:2: ( IDENT ( arrayList )? PERIOD )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:165:4: IDENT ( arrayList )? PERIOD
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT56=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceQualifier373); 
            IDENT56_tree = (CommonTree)adaptor.create(IDENT56);
            adaptor.addChild(root_0, IDENT56_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:165:10: ( arrayList )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==LEFTPAREN) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:165:10: arrayList
                    {
                    pushFollow(FOLLOW_arrayList_in_instanceQualifier375);
                    arrayList57=arrayList();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayList57.getTree());

                    }
                    break;

            }

            PERIOD58=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_instanceQualifier378); 
            PERIOD58_tree = (CommonTree)adaptor.create(PERIOD58);
            root_0 = (CommonTree)adaptor.becomeRoot(PERIOD58_tree, root_0);


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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:168:1: pinAssignment : ( instanceQualifier )? IDENT ( sliceList )? EQUALS concatenation SEMICOLON ;
    public final PhdlParser.pinAssignment_return pinAssignment() throws RecognitionException {
        PhdlParser.pinAssignment_return retval = new PhdlParser.pinAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT60=null;
        Token EQUALS62=null;
        Token SEMICOLON64=null;
        PhdlParser.instanceQualifier_return instanceQualifier59 = null;

        PhdlParser.sliceList_return sliceList61 = null;

        PhdlParser.concatenation_return concatenation63 = null;


        CommonTree IDENT60_tree=null;
        CommonTree EQUALS62_tree=null;
        CommonTree SEMICOLON64_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:173:2: ( ( instanceQualifier )? IDENT ( sliceList )? EQUALS concatenation SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:173:4: ( instanceQualifier )? IDENT ( sliceList )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:173:4: ( instanceQualifier )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==IDENT) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==PERIOD||LA14_1==LEFTPAREN) ) {
                    alt14=1;
                }
            }
            switch (alt14) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:173:4: instanceQualifier
                    {
                    pushFollow(FOLLOW_instanceQualifier_in_pinAssignment394);
                    instanceQualifier59=instanceQualifier();

                    state._fsp--;

                    adaptor.addChild(root_0, instanceQualifier59.getTree());

                    }
                    break;

            }

            IDENT60=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinAssignment397); 
            IDENT60_tree = (CommonTree)adaptor.create(IDENT60);
            adaptor.addChild(root_0, IDENT60_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:173:29: ( sliceList )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==LEFTBRACKET) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:173:29: sliceList
                    {
                    pushFollow(FOLLOW_sliceList_in_pinAssignment399);
                    sliceList61=sliceList();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceList61.getTree());

                    }
                    break;

            }

            EQUALS62=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinAssignment402); 
            EQUALS62_tree = (CommonTree)adaptor.create(EQUALS62);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS62_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_pinAssignment405);
            concatenation63=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation63.getTree());
            SEMICOLON64=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinAssignment407); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:176:1: netAssignment : IDENT ( sliceList )? EQUALS concatenation SEMICOLON ;
    public final PhdlParser.netAssignment_return netAssignment() throws RecognitionException {
        PhdlParser.netAssignment_return retval = new PhdlParser.netAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT65=null;
        Token EQUALS67=null;
        Token SEMICOLON69=null;
        PhdlParser.sliceList_return sliceList66 = null;

        PhdlParser.concatenation_return concatenation68 = null;


        CommonTree IDENT65_tree=null;
        CommonTree EQUALS67_tree=null;
        CommonTree SEMICOLON69_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:180:2: ( IDENT ( sliceList )? EQUALS concatenation SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:180:4: IDENT ( sliceList )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT65=(Token)match(input,IDENT,FOLLOW_IDENT_in_netAssignment421); 
            IDENT65_tree = (CommonTree)adaptor.create(IDENT65);
            adaptor.addChild(root_0, IDENT65_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:180:10: ( sliceList )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==LEFTBRACKET) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:180:10: sliceList
                    {
                    pushFollow(FOLLOW_sliceList_in_netAssignment423);
                    sliceList66=sliceList();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceList66.getTree());

                    }
                    break;

            }

            EQUALS67=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_netAssignment426); 
            EQUALS67_tree = (CommonTree)adaptor.create(EQUALS67);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS67_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_netAssignment429);
            concatenation68=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation68.getTree());
            SEMICOLON69=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netAssignment431); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:183:1: concatenation : ( ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* ) | LEFTANGLE IDENT RIGHTANGLE | 'open' );
    public final PhdlParser.concatenation_return concatenation() throws RecognitionException {
        PhdlParser.concatenation_return retval = new PhdlParser.concatenation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT70=null;
        Token AMPERSAND72=null;
        Token IDENT73=null;
        Token LEFTANGLE75=null;
        Token IDENT76=null;
        Token RIGHTANGLE77=null;
        Token string_literal78=null;
        PhdlParser.sliceList_return sliceList71 = null;

        PhdlParser.sliceList_return sliceList74 = null;


        CommonTree IDENT70_tree=null;
        CommonTree AMPERSAND72_tree=null;
        CommonTree IDENT73_tree=null;
        CommonTree LEFTANGLE75_tree=null;
        CommonTree IDENT76_tree=null;
        CommonTree RIGHTANGLE77_tree=null;
        CommonTree string_literal78_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:189:2: ( ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* ) | LEFTANGLE IDENT RIGHTANGLE | 'open' )
            int alt20=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt20=1;
                }
                break;
            case LEFTANGLE:
                {
                alt20=2;
                }
                break;
            case 38:
                {
                alt20=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:189:4: ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:189:4: ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:189:5: ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )*
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:189:5: ( IDENT ( sliceList )? )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:189:6: IDENT ( sliceList )?
                    {
                    IDENT70=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation447); 
                    IDENT70_tree = (CommonTree)adaptor.create(IDENT70);
                    adaptor.addChild(root_0, IDENT70_tree);

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:189:12: ( sliceList )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==LEFTBRACKET) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:189:12: sliceList
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation449);
                            sliceList71=sliceList();

                            state._fsp--;

                            adaptor.addChild(root_0, sliceList71.getTree());

                            }
                            break;

                    }


                    }

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:189:24: ( AMPERSAND IDENT ( sliceList )? )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==AMPERSAND) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:189:25: AMPERSAND IDENT ( sliceList )?
                    	    {
                    	    AMPERSAND72=(Token)match(input,AMPERSAND,FOLLOW_AMPERSAND_in_concatenation454); 
                    	    IDENT73=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation457); 
                    	    IDENT73_tree = (CommonTree)adaptor.create(IDENT73);
                    	    adaptor.addChild(root_0, IDENT73_tree);

                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:189:42: ( sliceList )?
                    	    int alt18=2;
                    	    int LA18_0 = input.LA(1);

                    	    if ( (LA18_0==LEFTBRACKET) ) {
                    	        alt18=1;
                    	    }
                    	    switch (alt18) {
                    	        case 1 :
                    	            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:189:42: sliceList
                    	            {
                    	            pushFollow(FOLLOW_sliceList_in_concatenation459);
                    	            sliceList74=sliceList();

                    	            state._fsp--;

                    	            adaptor.addChild(root_0, sliceList74.getTree());

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:190:4: LEFTANGLE IDENT RIGHTANGLE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    LEFTANGLE75=(Token)match(input,LEFTANGLE,FOLLOW_LEFTANGLE_in_concatenation470); 
                    LEFTANGLE75_tree = (CommonTree)adaptor.create(LEFTANGLE75);
                    adaptor.addChild(root_0, LEFTANGLE75_tree);

                    IDENT76=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation472); 
                    IDENT76_tree = (CommonTree)adaptor.create(IDENT76);
                    adaptor.addChild(root_0, IDENT76_tree);

                    RIGHTANGLE77=(Token)match(input,RIGHTANGLE,FOLLOW_RIGHTANGLE_in_concatenation474); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:191:5: 'open'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal78=(Token)match(input,38,FOLLOW_38_in_concatenation481); 
                    string_literal78_tree = (CommonTree)adaptor.create(string_literal78);
                    adaptor.addChild(root_0, string_literal78_tree);


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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:194:1: pinList : LEFTBRACE ( IDENT | PIN | INTEGER ) ( COMMA ( IDENT | PIN | INTEGER ) )* RIGHTBRACE ;
    public final PhdlParser.pinList_return pinList() throws RecognitionException {
        PhdlParser.pinList_return retval = new PhdlParser.pinList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTBRACE79=null;
        Token set80=null;
        Token COMMA81=null;
        Token set82=null;
        Token RIGHTBRACE83=null;

        CommonTree LEFTBRACE79_tree=null;
        CommonTree set80_tree=null;
        CommonTree COMMA81_tree=null;
        CommonTree set82_tree=null;
        CommonTree RIGHTBRACE83_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:199:2: ( LEFTBRACE ( IDENT | PIN | INTEGER ) ( COMMA ( IDENT | PIN | INTEGER ) )* RIGHTBRACE )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:199:5: LEFTBRACE ( IDENT | PIN | INTEGER ) ( COMMA ( IDENT | PIN | INTEGER ) )* RIGHTBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACE79=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_pinList496); 
            set80=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||(input.LA(1)>=PIN && input.LA(1)<=INTEGER) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set80));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:199:40: ( COMMA ( IDENT | PIN | INTEGER ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==COMMA) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:199:41: COMMA ( IDENT | PIN | INTEGER )
            	    {
            	    COMMA81=(Token)match(input,COMMA,FOLLOW_COMMA_in_pinList512); 
            	    set82=(Token)input.LT(1);
            	    if ( input.LA(1)==IDENT||(input.LA(1)>=PIN && input.LA(1)<=INTEGER) ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (CommonTree)adaptor.create(set82));
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            RIGHTBRACE83=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_pinList529); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:202:1: sliceList : LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )* ) RIGHTBRACKET ;
    public final PhdlParser.sliceList_return sliceList() throws RecognitionException {
        PhdlParser.sliceList_return retval = new PhdlParser.sliceList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTBRACKET84=null;
        Token INTEGER85=null;
        Token COLON86=null;
        Token INTEGER87=null;
        Token COMMA88=null;
        Token INTEGER89=null;
        Token RIGHTBRACKET90=null;

        CommonTree LEFTBRACKET84_tree=null;
        CommonTree INTEGER85_tree=null;
        CommonTree COLON86_tree=null;
        CommonTree INTEGER87_tree=null;
        CommonTree COMMA88_tree=null;
        CommonTree INTEGER89_tree=null;
        CommonTree RIGHTBRACKET90_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:207:2: ( LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )* ) RIGHTBRACKET )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:207:5: LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )* ) RIGHTBRACKET
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACKET84=(Token)match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList545); 
            LEFTBRACKET84_tree = (CommonTree)adaptor.create(LEFTBRACKET84);
            adaptor.addChild(root_0, LEFTBRACKET84_tree);

            INTEGER85=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList547); 
            INTEGER85_tree = (CommonTree)adaptor.create(INTEGER85);
            adaptor.addChild(root_0, INTEGER85_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:207:25: ( ( COLON INTEGER ) | ( COMMA INTEGER )* )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==COLON) ) {
                alt23=1;
            }
            else if ( (LA23_0==COMMA||LA23_0==RIGHTBRACKET) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:207:26: ( COLON INTEGER )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:207:26: ( COLON INTEGER )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:207:27: COLON INTEGER
                    {
                    COLON86=(Token)match(input,COLON,FOLLOW_COLON_in_sliceList551); 
                    COLON86_tree = (CommonTree)adaptor.create(COLON86);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON86_tree, root_0);

                    INTEGER87=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList554); 
                    INTEGER87_tree = (CommonTree)adaptor.create(INTEGER87);
                    adaptor.addChild(root_0, INTEGER87_tree);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:207:45: ( COMMA INTEGER )*
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:207:45: ( COMMA INTEGER )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==COMMA) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:207:46: COMMA INTEGER
                    	    {
                    	    COMMA88=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceList560); 
                    	    COMMA88_tree = (CommonTree)adaptor.create(COMMA88);
                    	    root_0 = (CommonTree)adaptor.becomeRoot(COMMA88_tree, root_0);

                    	    INTEGER89=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList563); 
                    	    INTEGER89_tree = (CommonTree)adaptor.create(INTEGER89);
                    	    adaptor.addChild(root_0, INTEGER89_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);


                    }
                    break;

            }

            RIGHTBRACKET90=(Token)match(input,RIGHTBRACKET,FOLLOW_RIGHTBRACKET_in_sliceList568); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:210:1: sliceDecl : LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RIGHTBRACKET ;
    public final PhdlParser.sliceDecl_return sliceDecl() throws RecognitionException {
        PhdlParser.sliceDecl_return retval = new PhdlParser.sliceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTBRACKET91=null;
        Token INTEGER92=null;
        Token COLON93=null;
        Token INTEGER94=null;
        Token COMMA95=null;
        Token INTEGER96=null;
        Token RIGHTBRACKET97=null;

        CommonTree LEFTBRACKET91_tree=null;
        CommonTree INTEGER92_tree=null;
        CommonTree COLON93_tree=null;
        CommonTree INTEGER94_tree=null;
        CommonTree COMMA95_tree=null;
        CommonTree INTEGER96_tree=null;
        CommonTree RIGHTBRACKET97_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:214:2: ( LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RIGHTBRACKET )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:214:4: LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RIGHTBRACKET
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACKET91=(Token)match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceDecl582); 
            LEFTBRACKET91_tree = (CommonTree)adaptor.create(LEFTBRACKET91);
            adaptor.addChild(root_0, LEFTBRACKET91_tree);

            INTEGER92=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl584); 
            INTEGER92_tree = (CommonTree)adaptor.create(INTEGER92);
            adaptor.addChild(root_0, INTEGER92_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:214:24: ( ( COLON INTEGER ) | ( COMMA INTEGER )+ )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==COLON) ) {
                alt25=1;
            }
            else if ( (LA25_0==COMMA) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:214:25: ( COLON INTEGER )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:214:25: ( COLON INTEGER )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:214:26: COLON INTEGER
                    {
                    COLON93=(Token)match(input,COLON,FOLLOW_COLON_in_sliceDecl588); 
                    COLON93_tree = (CommonTree)adaptor.create(COLON93);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON93_tree, root_0);

                    INTEGER94=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl591); 
                    INTEGER94_tree = (CommonTree)adaptor.create(INTEGER94);
                    adaptor.addChild(root_0, INTEGER94_tree);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:214:44: ( COMMA INTEGER )+
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:214:44: ( COMMA INTEGER )+
                    int cnt24=0;
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==COMMA) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:214:45: COMMA INTEGER
                    	    {
                    	    COMMA95=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceDecl597); 
                    	    COMMA95_tree = (CommonTree)adaptor.create(COMMA95);
                    	    root_0 = (CommonTree)adaptor.becomeRoot(COMMA95_tree, root_0);

                    	    INTEGER96=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl600); 
                    	    INTEGER96_tree = (CommonTree)adaptor.create(INTEGER96);
                    	    adaptor.addChild(root_0, INTEGER96_tree);


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt24 >= 1 ) break loop24;
                                EarlyExitException eee =
                                    new EarlyExitException(24, input);
                                throw eee;
                        }
                        cnt24++;
                    } while (true);


                    }
                    break;

            }

            RIGHTBRACKET97=(Token)match(input,RIGHTBRACKET,FOLLOW_RIGHTBRACKET_in_sliceDecl605); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:217:1: arrayList : LEFTPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTPAREN ;
    public final PhdlParser.arrayList_return arrayList() throws RecognitionException {
        PhdlParser.arrayList_return retval = new PhdlParser.arrayList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTPAREN98=null;
        Token INTEGER99=null;
        Token COLON100=null;
        Token INTEGER101=null;
        Token COMMA102=null;
        Token INTEGER103=null;
        Token COMMA104=null;
        Token INTEGER105=null;
        Token RIGHTPAREN106=null;

        CommonTree LEFTPAREN98_tree=null;
        CommonTree INTEGER99_tree=null;
        CommonTree COLON100_tree=null;
        CommonTree INTEGER101_tree=null;
        CommonTree COMMA102_tree=null;
        CommonTree INTEGER103_tree=null;
        CommonTree COMMA104_tree=null;
        CommonTree INTEGER105_tree=null;
        CommonTree RIGHTPAREN106_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:222:2: ( LEFTPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTPAREN )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:222:5: LEFTPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTPAREN98=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList621); 
            LEFTPAREN98_tree = (CommonTree)adaptor.create(LEFTPAREN98);
            adaptor.addChild(root_0, LEFTPAREN98_tree);

            INTEGER99=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList623); 
            INTEGER99_tree = (CommonTree)adaptor.create(INTEGER99);
            adaptor.addChild(root_0, INTEGER99_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:222:23: ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==COLON) ) {
                alt28=1;
            }
            else if ( (LA28_0==COMMA||LA28_0==RIGHTPAREN) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:222:24: ( COLON INTEGER )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:222:24: ( COLON INTEGER )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:222:25: COLON INTEGER
                    {
                    COLON100=(Token)match(input,COLON,FOLLOW_COLON_in_arrayList627); 
                    COLON100_tree = (CommonTree)adaptor.create(COLON100);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON100_tree, root_0);

                    INTEGER101=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList630); 
                    INTEGER101_tree = (CommonTree)adaptor.create(INTEGER101);
                    adaptor.addChild(root_0, INTEGER101_tree);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:222:43: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:222:43: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==COMMA) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:222:44: COMMA INTEGER ( COMMA INTEGER )*
                            {
                            COMMA102=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayList636); 
                            COMMA102_tree = (CommonTree)adaptor.create(COMMA102);
                            root_0 = (CommonTree)adaptor.becomeRoot(COMMA102_tree, root_0);

                            INTEGER103=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList639); 
                            INTEGER103_tree = (CommonTree)adaptor.create(INTEGER103);
                            adaptor.addChild(root_0, INTEGER103_tree);

                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:222:59: ( COMMA INTEGER )*
                            loop26:
                            do {
                                int alt26=2;
                                int LA26_0 = input.LA(1);

                                if ( (LA26_0==COMMA) ) {
                                    alt26=1;
                                }


                                switch (alt26) {
                            	case 1 :
                            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:222:60: COMMA INTEGER
                            	    {
                            	    COMMA104=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayList642); 
                            	    INTEGER105=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList645); 
                            	    INTEGER105_tree = (CommonTree)adaptor.create(INTEGER105);
                            	    adaptor.addChild(root_0, INTEGER105_tree);


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

            RIGHTPAREN106=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_arrayList652); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:225:1: arrayDecl : LEFTPAREN INTEGER COLON INTEGER RIGHTPAREN ;
    public final PhdlParser.arrayDecl_return arrayDecl() throws RecognitionException {
        PhdlParser.arrayDecl_return retval = new PhdlParser.arrayDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTPAREN107=null;
        Token INTEGER108=null;
        Token COLON109=null;
        Token INTEGER110=null;
        Token RIGHTPAREN111=null;

        CommonTree LEFTPAREN107_tree=null;
        CommonTree INTEGER108_tree=null;
        CommonTree COLON109_tree=null;
        CommonTree INTEGER110_tree=null;
        CommonTree RIGHTPAREN111_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:229:2: ( LEFTPAREN INTEGER COLON INTEGER RIGHTPAREN )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:229:4: LEFTPAREN INTEGER COLON INTEGER RIGHTPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTPAREN107=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayDecl666); 
            LEFTPAREN107_tree = (CommonTree)adaptor.create(LEFTPAREN107);
            adaptor.addChild(root_0, LEFTPAREN107_tree);

            INTEGER108=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayDecl668); 
            INTEGER108_tree = (CommonTree)adaptor.create(INTEGER108);
            adaptor.addChild(root_0, INTEGER108_tree);

            COLON109=(Token)match(input,COLON,FOLLOW_COLON_in_arrayDecl670); 
            COLON109_tree = (CommonTree)adaptor.create(COLON109);
            root_0 = (CommonTree)adaptor.becomeRoot(COLON109_tree, root_0);

            INTEGER110=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayDecl673); 
            INTEGER110_tree = (CommonTree)adaptor.create(INTEGER110);
            adaptor.addChild(root_0, INTEGER110_tree);

            RIGHTPAREN111=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_arrayDecl675); 

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
        "\21\uffff";
    static final String DFA10_eofS =
        "\21\uffff";
    static final String DFA10_minS =
        "\1\4\2\uffff\1\6\1\4\1\16\1\4\1\uffff\1\17\1\6\2\16\1\10\1\25\1"+
        "\17\1\16\1\17";
    static final String DFA10_maxS =
        "\1\45\2\uffff\1\24\1\46\1\16\1\4\1\uffff\1\25\1\21\2\16\1\10\2"+
        "\25\1\16\1\25";
    static final String DFA10_acceptS =
        "\1\uffff\1\3\1\1\4\uffff\1\2\11\uffff";
    static final String DFA10_specialS =
        "\21\uffff}>";
    static final String[] DFA10_transitionS = {
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
    public static final BitSet FOLLOW_30_in_designDecl124 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_designDecl127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_deviceDecl142 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl145 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_deviceDecl147 = new BitSet(new long[]{0x0000000340000000L});
    public static final BitSet FOLLOW_attributeDecl_in_deviceDecl154 = new BitSet(new long[]{0x0000000340000000L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl158 = new BitSet(new long[]{0x0000000340000000L});
    public static final BitSet FOLLOW_30_in_deviceDecl165 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_deviceDecl168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_attributeDecl183 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attributeDecl186 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_attributeDecl188 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_in_attributeDecl191 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeDecl193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_pinDecl207 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_sliceDecl_in_pinDecl210 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl213 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_pinDecl215 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_pinList_in_pinDecl218 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinDecl220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_type235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_netDecl249 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_sliceDecl_in_netDecl252 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl255 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_netAttributes_in_netDecl257 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_netDecl260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_netAttributes276 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_attributeDecl_in_netAttributes279 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_30_in_netAttributes282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_instanceDecl296 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_arrayDecl_in_instanceDecl299 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instanceDecl302 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_instanceDecl304 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instanceDecl307 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_instanceDecl309 = new BitSet(new long[]{0x0000002040000010L});
    public static final BitSet FOLLOW_attributeAssignment_in_instanceDecl315 = new BitSet(new long[]{0x0000002040000010L});
    public static final BitSet FOLLOW_pinAssignment_in_instanceDecl319 = new BitSet(new long[]{0x0000002040000010L});
    public static final BitSet FOLLOW_30_in_instanceDecl325 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_instanceDecl328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_attributeAssignment344 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_instanceQualifier_in_attributeAssignment348 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attributeAssignment351 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_attributeAssignment353 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_in_attributeAssignment356 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeAssignment358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_instanceQualifier373 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_arrayList_in_instanceQualifier375 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_PERIOD_in_instanceQualifier378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instanceQualifier_in_pinAssignment394 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinAssignment397 = new BitSet(new long[]{0x0000000000020040L});
    public static final BitSet FOLLOW_sliceList_in_pinAssignment399 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssignment402 = new BitSet(new long[]{0x0000004000000410L});
    public static final BitSet FOLLOW_concatenation_in_pinAssignment405 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinAssignment407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_netAssignment421 = new BitSet(new long[]{0x0000000000020040L});
    public static final BitSet FOLLOW_sliceList_in_netAssignment423 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_netAssignment426 = new BitSet(new long[]{0x0000004000000410L});
    public static final BitSet FOLLOW_concatenation_in_netAssignment429 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_netAssignment431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_concatenation447 = new BitSet(new long[]{0x0000000000020202L});
    public static final BitSet FOLLOW_sliceList_in_concatenation449 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_AMPERSAND_in_concatenation454 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation457 = new BitSet(new long[]{0x0000000000020202L});
    public static final BitSet FOLLOW_sliceList_in_concatenation459 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_LEFTANGLE_in_concatenation470 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation472 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RIGHTANGLE_in_concatenation474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_concatenation481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACE_in_pinList496 = new BitSet(new long[]{0x0000000000006010L});
    public static final BitSet FOLLOW_set_in_pinList499 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_COMMA_in_pinList512 = new BitSet(new long[]{0x0000000000006010L});
    public static final BitSet FOLLOW_set_in_pinList515 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_pinList529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList545 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList547 = new BitSet(new long[]{0x00000000000C8000L});
    public static final BitSet FOLLOW_COLON_in_sliceList551 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList554 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_COMMA_in_sliceList560 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList563 = new BitSet(new long[]{0x0000000000088000L});
    public static final BitSet FOLLOW_RIGHTBRACKET_in_sliceList568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceDecl582 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl584 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_COLON_in_sliceDecl588 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl591 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_COMMA_in_sliceDecl597 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl600 = new BitSet(new long[]{0x0000000000088000L});
    public static final BitSet FOLLOW_RIGHTBRACKET_in_sliceDecl605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList621 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList623 = new BitSet(new long[]{0x0000000000248000L});
    public static final BitSet FOLLOW_COLON_in_arrayList627 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList630 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_COMMA_in_arrayList636 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList639 = new BitSet(new long[]{0x0000000000208000L});
    public static final BitSet FOLLOW_COMMA_in_arrayList642 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList645 = new BitSet(new long[]{0x0000000000208000L});
    public static final BitSet FOLLOW_RIGHTPAREN_in_arrayList652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayDecl666 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayDecl668 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_COLON_in_arrayDecl670 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayDecl673 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_RIGHTPAREN_in_arrayDecl675 = new BitSet(new long[]{0x0000000000000002L});

}