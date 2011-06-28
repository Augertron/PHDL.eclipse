// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g 2011-06-28 12:06:12

	package phdl.parser;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "SEMICOLON", "EQUALS", "STRING_LITERAL", "SLICE_LIST", "PIN_LIST", "COLON", "COMMA", "ARRAY_LIST", "CHAR", "DIGIT", "PERIOD", "LBRACKET", "RBRACKET", "INT", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "'design'", "'is'", "'begin'", "'end'", "'device'", "'pin'", "'in'", "'out'", "'inout'", "'passive'", "'supply'", "'power'", "'net'", "'inst'", "'&'", "'<'", "'>'", "'open'"
    };
    public static final int EOF=-1;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
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
    public static final int STRING_LITERAL=7;
    public static final int SLICE_LIST=8;
    public static final int PIN_LIST=9;
    public static final int COLON=10;
    public static final int COMMA=11;
    public static final int ARRAY_LIST=12;
    public static final int CHAR=13;
    public static final int DIGIT=14;
    public static final int PERIOD=15;
    public static final int LBRACKET=16;
    public static final int RBRACKET=17;
    public static final int INT=18;
    public static final int WHITESPACE=19;
    public static final int LINE_COMMENT=20;
    public static final int MULTILINE_COMMENT=21;

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:65:1: sourceText : ( designDecl )* EOF ;
    public final PhdlParser.sourceText_return sourceText() throws RecognitionException {
        PhdlParser.sourceText_return retval = new PhdlParser.sourceText_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF2=null;
        PhdlParser.designDecl_return designDecl1 = null;


        CommonTree EOF2_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:68:2: ( ( designDecl )* EOF )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:68:4: ( designDecl )* EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:68:4: ( designDecl )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==22) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:68:4: designDecl
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:71:1: designDecl : 'design' IDENT 'is' ( deviceDecl | netDecl )* 'begin' ( deviceInstance | netAssignment )* 'end' SEMICOLON ;
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

        PhdlParser.deviceInstance_return deviceInstance9 = null;

        PhdlParser.netAssignment_return netAssignment10 = null;


        CommonTree string_literal3_tree=null;
        CommonTree IDENT4_tree=null;
        CommonTree string_literal5_tree=null;
        CommonTree string_literal8_tree=null;
        CommonTree string_literal11_tree=null;
        CommonTree SEMICOLON12_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:77:2: ( 'design' IDENT 'is' ( deviceDecl | netDecl )* 'begin' ( deviceInstance | netAssignment )* 'end' SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:78:3: 'design' IDENT 'is' ( deviceDecl | netDecl )* 'begin' ( deviceInstance | netAssignment )* 'end' SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal3=(Token)match(input,22,FOLLOW_22_in_designDecl88); 
            string_literal3_tree = (CommonTree)adaptor.create(string_literal3);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal3_tree, root_0);

            IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_designDecl91); 
            IDENT4_tree = (CommonTree)adaptor.create(IDENT4);
            adaptor.addChild(root_0, IDENT4_tree);

            string_literal5=(Token)match(input,23,FOLLOW_23_in_designDecl93); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:81:3: ( deviceDecl | netDecl )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==26) ) {
                    alt2=1;
                }
                else if ( (LA2_0==34) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:81:4: deviceDecl
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_designDecl106);
            	    deviceDecl6=deviceDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, deviceDecl6.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:81:17: netDecl
            	    {
            	    pushFollow(FOLLOW_netDecl_in_designDecl110);
            	    netDecl7=netDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netDecl7.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            string_literal8=(Token)match(input,24,FOLLOW_24_in_designDecl119); 
            string_literal8_tree = (CommonTree)adaptor.create(string_literal8);
            adaptor.addChild(root_0, string_literal8_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:86:3: ( deviceInstance | netAssignment )*
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:86:4: deviceInstance
            	    {
            	    pushFollow(FOLLOW_deviceInstance_in_designDecl130);
            	    deviceInstance9=deviceInstance();

            	    state._fsp--;

            	    adaptor.addChild(root_0, deviceInstance9.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:86:21: netAssignment
            	    {
            	    pushFollow(FOLLOW_netAssignment_in_designDecl134);
            	    netAssignment10=netAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netAssignment10.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            string_literal11=(Token)match(input,25,FOLLOW_25_in_designDecl140); 
            SEMICOLON12=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_designDecl143); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:90:1: deviceDecl : 'device' IDENT 'is' ( attributeDecl )* 'begin' ( pinDecl )* 'end' SEMICOLON ;
    public final PhdlParser.deviceDecl_return deviceDecl() throws RecognitionException {
        PhdlParser.deviceDecl_return retval = new PhdlParser.deviceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal13=null;
        Token IDENT14=null;
        Token string_literal15=null;
        Token string_literal17=null;
        Token string_literal19=null;
        Token SEMICOLON20=null;
        PhdlParser.attributeDecl_return attributeDecl16 = null;

        PhdlParser.pinDecl_return pinDecl18 = null;


        CommonTree string_literal13_tree=null;
        CommonTree IDENT14_tree=null;
        CommonTree string_literal15_tree=null;
        CommonTree string_literal17_tree=null;
        CommonTree string_literal19_tree=null;
        CommonTree SEMICOLON20_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:96:2: ( 'device' IDENT 'is' ( attributeDecl )* 'begin' ( pinDecl )* 'end' SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:96:4: 'device' IDENT 'is' ( attributeDecl )* 'begin' ( pinDecl )* 'end' SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal13=(Token)match(input,26,FOLLOW_26_in_deviceDecl158); 
            string_literal13_tree = (CommonTree)adaptor.create(string_literal13);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal13_tree, root_0);

            IDENT14=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl161); 
            IDENT14_tree = (CommonTree)adaptor.create(IDENT14);
            adaptor.addChild(root_0, IDENT14_tree);

            string_literal15=(Token)match(input,23,FOLLOW_23_in_deviceDecl163); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:97:3: ( attributeDecl )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==IDENT) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:97:3: attributeDecl
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_deviceDecl168);
            	    attributeDecl16=attributeDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeDecl16.getTree());

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            string_literal17=(Token)match(input,24,FOLLOW_24_in_deviceDecl173); 
            string_literal17_tree = (CommonTree)adaptor.create(string_literal17);
            adaptor.addChild(root_0, string_literal17_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:99:3: ( pinDecl )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=27 && LA5_0<=33)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:99:3: pinDecl
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl177);
            	    pinDecl18=pinDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinDecl18.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            string_literal19=(Token)match(input,25,FOLLOW_25_in_deviceDecl182); 
            SEMICOLON20=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_deviceDecl185); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:103:1: attributeDecl : IDENT EQUALS STRING_LITERAL SEMICOLON ;
    public final PhdlParser.attributeDecl_return attributeDecl() throws RecognitionException {
        PhdlParser.attributeDecl_return retval = new PhdlParser.attributeDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT21=null;
        Token EQUALS22=null;
        Token STRING_LITERAL23=null;
        Token SEMICOLON24=null;

        CommonTree IDENT21_tree=null;
        CommonTree EQUALS22_tree=null;
        CommonTree STRING_LITERAL23_tree=null;
        CommonTree SEMICOLON24_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:104:2: ( IDENT EQUALS STRING_LITERAL SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:105:3: IDENT EQUALS STRING_LITERAL SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT21=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeDecl201); 
            IDENT21_tree = (CommonTree)adaptor.create(IDENT21);
            adaptor.addChild(root_0, IDENT21_tree);

            EQUALS22=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeDecl203); 
            EQUALS22_tree = (CommonTree)adaptor.create(EQUALS22);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS22_tree, root_0);

            STRING_LITERAL23=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_attributeDecl206); 
            STRING_LITERAL23_tree = (CommonTree)adaptor.create(STRING_LITERAL23);
            adaptor.addChild(root_0, STRING_LITERAL23_tree);

            SEMICOLON24=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeDecl208); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:108:1: pinDecl : type ( SLICE_LIST )? IDENT EQUALS PIN_LIST SEMICOLON ;
    public final PhdlParser.pinDecl_return pinDecl() throws RecognitionException {
        PhdlParser.pinDecl_return retval = new PhdlParser.pinDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SLICE_LIST26=null;
        Token IDENT27=null;
        Token EQUALS28=null;
        Token PIN_LIST29=null;
        Token SEMICOLON30=null;
        PhdlParser.type_return type25 = null;


        CommonTree SLICE_LIST26_tree=null;
        CommonTree IDENT27_tree=null;
        CommonTree EQUALS28_tree=null;
        CommonTree PIN_LIST29_tree=null;
        CommonTree SEMICOLON30_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:109:2: ( type ( SLICE_LIST )? IDENT EQUALS PIN_LIST SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:110:3: type ( SLICE_LIST )? IDENT EQUALS PIN_LIST SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_type_in_pinDecl224);
            type25=type();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(type25.getTree(), root_0);
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:110:9: ( SLICE_LIST )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==SLICE_LIST) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:110:9: SLICE_LIST
                    {
                    SLICE_LIST26=(Token)match(input,SLICE_LIST,FOLLOW_SLICE_LIST_in_pinDecl227); 
                    SLICE_LIST26_tree = (CommonTree)adaptor.create(SLICE_LIST26);
                    adaptor.addChild(root_0, SLICE_LIST26_tree);


                    }
                    break;

            }

            IDENT27=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinDecl230); 
            IDENT27_tree = (CommonTree)adaptor.create(IDENT27);
            adaptor.addChild(root_0, IDENT27_tree);

            EQUALS28=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinDecl232); 
            PIN_LIST29=(Token)match(input,PIN_LIST,FOLLOW_PIN_LIST_in_pinDecl235); 
            PIN_LIST29_tree = (CommonTree)adaptor.create(PIN_LIST29);
            adaptor.addChild(root_0, PIN_LIST29_tree);

            SEMICOLON30=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinDecl237); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:113:1: type : ( 'pin' | 'in' | 'out' | 'inout' | 'passive' | 'supply' | 'power' );
    public final PhdlParser.type_return type() throws RecognitionException {
        PhdlParser.type_return retval = new PhdlParser.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set31=null;

        CommonTree set31_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:118:2: ( 'pin' | 'in' | 'out' | 'inout' | 'passive' | 'supply' | 'power' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set31=(Token)input.LT(1);
            if ( (input.LA(1)>=27 && input.LA(1)<=33) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set31));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "type"

    public static class netDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "netDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:127:1: netDecl : 'net' ( SLICE_LIST )? IDENT ( COLON IDENT ( COMMA IDENT )* )? SEMICOLON ;
    public final PhdlParser.netDecl_return netDecl() throws RecognitionException {
        PhdlParser.netDecl_return retval = new PhdlParser.netDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal32=null;
        Token SLICE_LIST33=null;
        Token IDENT34=null;
        Token COLON35=null;
        Token IDENT36=null;
        Token COMMA37=null;
        Token IDENT38=null;
        Token SEMICOLON39=null;

        CommonTree string_literal32_tree=null;
        CommonTree SLICE_LIST33_tree=null;
        CommonTree IDENT34_tree=null;
        CommonTree COLON35_tree=null;
        CommonTree IDENT36_tree=null;
        CommonTree COMMA37_tree=null;
        CommonTree IDENT38_tree=null;
        CommonTree SEMICOLON39_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:135:2: ( 'net' ( SLICE_LIST )? IDENT ( COLON IDENT ( COMMA IDENT )* )? SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:135:4: 'net' ( SLICE_LIST )? IDENT ( COLON IDENT ( COMMA IDENT )* )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal32=(Token)match(input,34,FOLLOW_34_in_netDecl296); 
            string_literal32_tree = (CommonTree)adaptor.create(string_literal32);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal32_tree, root_0);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:135:11: ( SLICE_LIST )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==SLICE_LIST) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:135:11: SLICE_LIST
                    {
                    SLICE_LIST33=(Token)match(input,SLICE_LIST,FOLLOW_SLICE_LIST_in_netDecl299); 
                    SLICE_LIST33_tree = (CommonTree)adaptor.create(SLICE_LIST33);
                    adaptor.addChild(root_0, SLICE_LIST33_tree);


                    }
                    break;

            }

            IDENT34=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl302); 
            IDENT34_tree = (CommonTree)adaptor.create(IDENT34);
            adaptor.addChild(root_0, IDENT34_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:135:29: ( COLON IDENT ( COMMA IDENT )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==COLON) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:135:30: COLON IDENT ( COMMA IDENT )*
                    {
                    COLON35=(Token)match(input,COLON,FOLLOW_COLON_in_netDecl305); 
                    COLON35_tree = (CommonTree)adaptor.create(COLON35);
                    adaptor.addChild(root_0, COLON35_tree);

                    IDENT36=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl307); 
                    IDENT36_tree = (CommonTree)adaptor.create(IDENT36);
                    adaptor.addChild(root_0, IDENT36_tree);

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:135:42: ( COMMA IDENT )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==COMMA) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:135:43: COMMA IDENT
                    	    {
                    	    COMMA37=(Token)match(input,COMMA,FOLLOW_COMMA_in_netDecl310); 
                    	    IDENT38=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl313); 
                    	    IDENT38_tree = (CommonTree)adaptor.create(IDENT38);
                    	    adaptor.addChild(root_0, IDENT38_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }

            SEMICOLON39=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netDecl319); 

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

    public static class deviceInstance_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "deviceInstance"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:138:1: deviceInstance : 'inst' IDENT ':' IDENT ( ARRAY_LIST )? 'is' ( attributeAssignment )* 'begin' ( pinAssignment )* 'end' ';' ;
    public final PhdlParser.deviceInstance_return deviceInstance() throws RecognitionException {
        PhdlParser.deviceInstance_return retval = new PhdlParser.deviceInstance_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal40=null;
        Token IDENT41=null;
        Token char_literal42=null;
        Token IDENT43=null;
        Token ARRAY_LIST44=null;
        Token string_literal45=null;
        Token string_literal47=null;
        Token string_literal49=null;
        Token char_literal50=null;
        PhdlParser.attributeAssignment_return attributeAssignment46 = null;

        PhdlParser.pinAssignment_return pinAssignment48 = null;


        CommonTree string_literal40_tree=null;
        CommonTree IDENT41_tree=null;
        CommonTree char_literal42_tree=null;
        CommonTree IDENT43_tree=null;
        CommonTree ARRAY_LIST44_tree=null;
        CommonTree string_literal45_tree=null;
        CommonTree string_literal47_tree=null;
        CommonTree string_literal49_tree=null;
        CommonTree char_literal50_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:139:2: ( 'inst' IDENT ':' IDENT ( ARRAY_LIST )? 'is' ( attributeAssignment )* 'begin' ( pinAssignment )* 'end' ';' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:139:4: 'inst' IDENT ':' IDENT ( ARRAY_LIST )? 'is' ( attributeAssignment )* 'begin' ( pinAssignment )* 'end' ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal40=(Token)match(input,35,FOLLOW_35_in_deviceInstance332); 
            string_literal40_tree = (CommonTree)adaptor.create(string_literal40);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal40_tree, root_0);

            IDENT41=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceInstance335); 
            IDENT41_tree = (CommonTree)adaptor.create(IDENT41);
            adaptor.addChild(root_0, IDENT41_tree);

            char_literal42=(Token)match(input,COLON,FOLLOW_COLON_in_deviceInstance337); 
            IDENT43=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceInstance340); 
            IDENT43_tree = (CommonTree)adaptor.create(IDENT43);
            adaptor.addChild(root_0, IDENT43_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:139:29: ( ARRAY_LIST )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==ARRAY_LIST) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:139:29: ARRAY_LIST
                    {
                    ARRAY_LIST44=(Token)match(input,ARRAY_LIST,FOLLOW_ARRAY_LIST_in_deviceInstance342); 
                    ARRAY_LIST44_tree = (CommonTree)adaptor.create(ARRAY_LIST44);
                    adaptor.addChild(root_0, ARRAY_LIST44_tree);


                    }
                    break;

            }

            string_literal45=(Token)match(input,23,FOLLOW_23_in_deviceInstance345); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:140:3: ( attributeAssignment )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==IDENT) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:140:3: attributeAssignment
            	    {
            	    pushFollow(FOLLOW_attributeAssignment_in_deviceInstance350);
            	    attributeAssignment46=attributeAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeAssignment46.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            string_literal47=(Token)match(input,24,FOLLOW_24_in_deviceInstance355); 
            string_literal47_tree = (CommonTree)adaptor.create(string_literal47);
            adaptor.addChild(root_0, string_literal47_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:142:3: ( pinAssignment )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==IDENT) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:142:3: pinAssignment
            	    {
            	    pushFollow(FOLLOW_pinAssignment_in_deviceInstance359);
            	    pinAssignment48=pinAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinAssignment48.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            string_literal49=(Token)match(input,25,FOLLOW_25_in_deviceInstance364); 
            char_literal50=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_deviceInstance367); 

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
    // $ANTLR end "deviceInstance"

    public static class attributeAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributeAssignment"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:146:1: attributeAssignment : IDENT ( ARRAY_LIST )? EQUALS STRING_LITERAL SEMICOLON ;
    public final PhdlParser.attributeAssignment_return attributeAssignment() throws RecognitionException {
        PhdlParser.attributeAssignment_return retval = new PhdlParser.attributeAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT51=null;
        Token ARRAY_LIST52=null;
        Token EQUALS53=null;
        Token STRING_LITERAL54=null;
        Token SEMICOLON55=null;

        CommonTree IDENT51_tree=null;
        CommonTree ARRAY_LIST52_tree=null;
        CommonTree EQUALS53_tree=null;
        CommonTree STRING_LITERAL54_tree=null;
        CommonTree SEMICOLON55_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:147:2: ( IDENT ( ARRAY_LIST )? EQUALS STRING_LITERAL SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:147:4: IDENT ( ARRAY_LIST )? EQUALS STRING_LITERAL SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT51=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeAssignment379); 
            IDENT51_tree = (CommonTree)adaptor.create(IDENT51);
            adaptor.addChild(root_0, IDENT51_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:147:10: ( ARRAY_LIST )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==ARRAY_LIST) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:147:10: ARRAY_LIST
                    {
                    ARRAY_LIST52=(Token)match(input,ARRAY_LIST,FOLLOW_ARRAY_LIST_in_attributeAssignment381); 
                    ARRAY_LIST52_tree = (CommonTree)adaptor.create(ARRAY_LIST52);
                    adaptor.addChild(root_0, ARRAY_LIST52_tree);


                    }
                    break;

            }

            EQUALS53=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeAssignment384); 
            EQUALS53_tree = (CommonTree)adaptor.create(EQUALS53);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS53_tree, root_0);

            STRING_LITERAL54=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_attributeAssignment387); 
            STRING_LITERAL54_tree = (CommonTree)adaptor.create(STRING_LITERAL54);
            adaptor.addChild(root_0, STRING_LITERAL54_tree);

            SEMICOLON55=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeAssignment389); 

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

    public static class pinAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pinAssignment"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:150:1: pinAssignment : IDENT ( ARRAY_LIST )? ( SLICE_LIST )? EQUALS concatenation SEMICOLON ;
    public final PhdlParser.pinAssignment_return pinAssignment() throws RecognitionException {
        PhdlParser.pinAssignment_return retval = new PhdlParser.pinAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT56=null;
        Token ARRAY_LIST57=null;
        Token SLICE_LIST58=null;
        Token EQUALS59=null;
        Token SEMICOLON61=null;
        PhdlParser.concatenation_return concatenation60 = null;


        CommonTree IDENT56_tree=null;
        CommonTree ARRAY_LIST57_tree=null;
        CommonTree SLICE_LIST58_tree=null;
        CommonTree EQUALS59_tree=null;
        CommonTree SEMICOLON61_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:151:2: ( IDENT ( ARRAY_LIST )? ( SLICE_LIST )? EQUALS concatenation SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:151:4: IDENT ( ARRAY_LIST )? ( SLICE_LIST )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT56=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinAssignment402); 
            IDENT56_tree = (CommonTree)adaptor.create(IDENT56);
            adaptor.addChild(root_0, IDENT56_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:151:10: ( ARRAY_LIST )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==ARRAY_LIST) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:151:10: ARRAY_LIST
                    {
                    ARRAY_LIST57=(Token)match(input,ARRAY_LIST,FOLLOW_ARRAY_LIST_in_pinAssignment404); 
                    ARRAY_LIST57_tree = (CommonTree)adaptor.create(ARRAY_LIST57);
                    adaptor.addChild(root_0, ARRAY_LIST57_tree);


                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:151:22: ( SLICE_LIST )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==SLICE_LIST) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:151:22: SLICE_LIST
                    {
                    SLICE_LIST58=(Token)match(input,SLICE_LIST,FOLLOW_SLICE_LIST_in_pinAssignment407); 
                    SLICE_LIST58_tree = (CommonTree)adaptor.create(SLICE_LIST58);
                    adaptor.addChild(root_0, SLICE_LIST58_tree);


                    }
                    break;

            }

            EQUALS59=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinAssignment410); 
            EQUALS59_tree = (CommonTree)adaptor.create(EQUALS59);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS59_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_pinAssignment413);
            concatenation60=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation60.getTree());
            SEMICOLON61=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinAssignment415); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:154:1: netAssignment : IDENT ( SLICE_LIST )? EQUALS concatenation SEMICOLON ;
    public final PhdlParser.netAssignment_return netAssignment() throws RecognitionException {
        PhdlParser.netAssignment_return retval = new PhdlParser.netAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT62=null;
        Token SLICE_LIST63=null;
        Token EQUALS64=null;
        Token SEMICOLON66=null;
        PhdlParser.concatenation_return concatenation65 = null;


        CommonTree IDENT62_tree=null;
        CommonTree SLICE_LIST63_tree=null;
        CommonTree EQUALS64_tree=null;
        CommonTree SEMICOLON66_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:155:2: ( IDENT ( SLICE_LIST )? EQUALS concatenation SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:155:4: IDENT ( SLICE_LIST )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT62=(Token)match(input,IDENT,FOLLOW_IDENT_in_netAssignment428); 
            IDENT62_tree = (CommonTree)adaptor.create(IDENT62);
            adaptor.addChild(root_0, IDENT62_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:155:10: ( SLICE_LIST )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==SLICE_LIST) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:155:10: SLICE_LIST
                    {
                    SLICE_LIST63=(Token)match(input,SLICE_LIST,FOLLOW_SLICE_LIST_in_netAssignment430); 
                    SLICE_LIST63_tree = (CommonTree)adaptor.create(SLICE_LIST63);
                    adaptor.addChild(root_0, SLICE_LIST63_tree);


                    }
                    break;

            }

            EQUALS64=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_netAssignment433); 
            EQUALS64_tree = (CommonTree)adaptor.create(EQUALS64);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS64_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_netAssignment436);
            concatenation65=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation65.getTree());
            SEMICOLON66=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netAssignment438); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:158:1: concatenation : ( ( ( IDENT ( SLICE_LIST )? ) ( '&' IDENT ( SLICE_LIST )? )* ) | '<' IDENT '>' | 'open' );
    public final PhdlParser.concatenation_return concatenation() throws RecognitionException {
        PhdlParser.concatenation_return retval = new PhdlParser.concatenation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT67=null;
        Token SLICE_LIST68=null;
        Token char_literal69=null;
        Token IDENT70=null;
        Token SLICE_LIST71=null;
        Token char_literal72=null;
        Token IDENT73=null;
        Token char_literal74=null;
        Token string_literal75=null;

        CommonTree IDENT67_tree=null;
        CommonTree SLICE_LIST68_tree=null;
        CommonTree char_literal69_tree=null;
        CommonTree IDENT70_tree=null;
        CommonTree SLICE_LIST71_tree=null;
        CommonTree char_literal72_tree=null;
        CommonTree IDENT73_tree=null;
        CommonTree char_literal74_tree=null;
        CommonTree string_literal75_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:159:2: ( ( ( IDENT ( SLICE_LIST )? ) ( '&' IDENT ( SLICE_LIST )? )* ) | '<' IDENT '>' | 'open' )
            int alt20=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt20=1;
                }
                break;
            case 37:
                {
                alt20=2;
                }
                break;
            case 39:
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:159:4: ( ( IDENT ( SLICE_LIST )? ) ( '&' IDENT ( SLICE_LIST )? )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:159:4: ( ( IDENT ( SLICE_LIST )? ) ( '&' IDENT ( SLICE_LIST )? )* )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:159:5: ( IDENT ( SLICE_LIST )? ) ( '&' IDENT ( SLICE_LIST )? )*
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:159:5: ( IDENT ( SLICE_LIST )? )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:159:6: IDENT ( SLICE_LIST )?
                    {
                    IDENT67=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation453); 
                    IDENT67_tree = (CommonTree)adaptor.create(IDENT67);
                    adaptor.addChild(root_0, IDENT67_tree);

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:159:12: ( SLICE_LIST )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==SLICE_LIST) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:159:12: SLICE_LIST
                            {
                            SLICE_LIST68=(Token)match(input,SLICE_LIST,FOLLOW_SLICE_LIST_in_concatenation455); 
                            SLICE_LIST68_tree = (CommonTree)adaptor.create(SLICE_LIST68);
                            adaptor.addChild(root_0, SLICE_LIST68_tree);


                            }
                            break;

                    }


                    }

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:159:25: ( '&' IDENT ( SLICE_LIST )? )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==36) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:159:26: '&' IDENT ( SLICE_LIST )?
                    	    {
                    	    char_literal69=(Token)match(input,36,FOLLOW_36_in_concatenation460); 
                    	    IDENT70=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation463); 
                    	    IDENT70_tree = (CommonTree)adaptor.create(IDENT70);
                    	    adaptor.addChild(root_0, IDENT70_tree);

                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:159:37: ( SLICE_LIST )?
                    	    int alt18=2;
                    	    int LA18_0 = input.LA(1);

                    	    if ( (LA18_0==SLICE_LIST) ) {
                    	        alt18=1;
                    	    }
                    	    switch (alt18) {
                    	        case 1 :
                    	            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:159:37: SLICE_LIST
                    	            {
                    	            SLICE_LIST71=(Token)match(input,SLICE_LIST,FOLLOW_SLICE_LIST_in_concatenation465); 
                    	            SLICE_LIST71_tree = (CommonTree)adaptor.create(SLICE_LIST71);
                    	            adaptor.addChild(root_0, SLICE_LIST71_tree);


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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:160:4: '<' IDENT '>'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal72=(Token)match(input,37,FOLLOW_37_in_concatenation476); 
                    char_literal72_tree = (CommonTree)adaptor.create(char_literal72);
                    adaptor.addChild(root_0, char_literal72_tree);

                    IDENT73=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation478); 
                    IDENT73_tree = (CommonTree)adaptor.create(IDENT73);
                    adaptor.addChild(root_0, IDENT73_tree);

                    char_literal74=(Token)match(input,38,FOLLOW_38_in_concatenation480); 
                    char_literal74_tree = (CommonTree)adaptor.create(char_literal74);
                    adaptor.addChild(root_0, char_literal74_tree);


                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:161:5: 'open'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal75=(Token)match(input,39,FOLLOW_39_in_concatenation486); 

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

    // Delegated rules


 

    public static final BitSet FOLLOW_designDecl_in_sourceText68 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_EOF_in_sourceText71 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_designDecl88 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_designDecl91 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_designDecl93 = new BitSet(new long[]{0x0000000405000000L});
    public static final BitSet FOLLOW_deviceDecl_in_designDecl106 = new BitSet(new long[]{0x0000000405000000L});
    public static final BitSet FOLLOW_netDecl_in_designDecl110 = new BitSet(new long[]{0x0000000405000000L});
    public static final BitSet FOLLOW_24_in_designDecl119 = new BitSet(new long[]{0x0000000802000010L});
    public static final BitSet FOLLOW_deviceInstance_in_designDecl130 = new BitSet(new long[]{0x0000000802000010L});
    public static final BitSet FOLLOW_netAssignment_in_designDecl134 = new BitSet(new long[]{0x0000000802000010L});
    public static final BitSet FOLLOW_25_in_designDecl140 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_designDecl143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_deviceDecl158 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl161 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_deviceDecl163 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_attributeDecl_in_deviceDecl168 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_24_in_deviceDecl173 = new BitSet(new long[]{0x00000003FA000000L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl177 = new BitSet(new long[]{0x00000003FA000000L});
    public static final BitSet FOLLOW_25_in_deviceDecl182 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_deviceDecl185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_attributeDecl201 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_attributeDecl203 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_attributeDecl206 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeDecl208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_pinDecl224 = new BitSet(new long[]{0x0000000000000110L});
    public static final BitSet FOLLOW_SLICE_LIST_in_pinDecl227 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl230 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_pinDecl232 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_PIN_LIST_in_pinDecl235 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinDecl237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_netDecl296 = new BitSet(new long[]{0x0000000000000110L});
    public static final BitSet FOLLOW_SLICE_LIST_in_netDecl299 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl302 = new BitSet(new long[]{0x0000000000000420L});
    public static final BitSet FOLLOW_COLON_in_netDecl305 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl307 = new BitSet(new long[]{0x0000000000000820L});
    public static final BitSet FOLLOW_COMMA_in_netDecl310 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl313 = new BitSet(new long[]{0x0000000000000820L});
    public static final BitSet FOLLOW_SEMICOLON_in_netDecl319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_deviceInstance332 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceInstance335 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_deviceInstance337 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceInstance340 = new BitSet(new long[]{0x0000000000801000L});
    public static final BitSet FOLLOW_ARRAY_LIST_in_deviceInstance342 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_deviceInstance345 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_attributeAssignment_in_deviceInstance350 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_24_in_deviceInstance355 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_pinAssignment_in_deviceInstance359 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_25_in_deviceInstance364 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_deviceInstance367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_attributeAssignment379 = new BitSet(new long[]{0x0000000000001040L});
    public static final BitSet FOLLOW_ARRAY_LIST_in_attributeAssignment381 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_attributeAssignment384 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_attributeAssignment387 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeAssignment389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_pinAssignment402 = new BitSet(new long[]{0x0000000000001140L});
    public static final BitSet FOLLOW_ARRAY_LIST_in_pinAssignment404 = new BitSet(new long[]{0x0000000000000140L});
    public static final BitSet FOLLOW_SLICE_LIST_in_pinAssignment407 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssignment410 = new BitSet(new long[]{0x000000A000000010L});
    public static final BitSet FOLLOW_concatenation_in_pinAssignment413 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinAssignment415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_netAssignment428 = new BitSet(new long[]{0x0000000000000140L});
    public static final BitSet FOLLOW_SLICE_LIST_in_netAssignment430 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_netAssignment433 = new BitSet(new long[]{0x000000A000000010L});
    public static final BitSet FOLLOW_concatenation_in_netAssignment436 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_netAssignment438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_concatenation453 = new BitSet(new long[]{0x0000001000000102L});
    public static final BitSet FOLLOW_SLICE_LIST_in_concatenation455 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_concatenation460 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation463 = new BitSet(new long[]{0x0000001000000102L});
    public static final BitSet FOLLOW_SLICE_LIST_in_concatenation465 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_37_in_concatenation476 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation478 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_concatenation480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_concatenation486 = new BitSet(new long[]{0x0000000000000002L});

}