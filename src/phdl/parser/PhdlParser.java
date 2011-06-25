// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g 2011-06-25 11:05:18

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "SEMICOLON", "EQUALS", "STRING_LITERAL", "NUMBER_LIST", "COMMA", "COLON", "INT", "PERIOD", "CHAR", "DIGIT", "LBRACKET", "RBRACKET", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "'design'", "'is'", "'begin'", "'end'", "'device'", "'pin'", "'in'", "'out'", "'inout'", "'passive'", "'supply'", "'power'", "'open'", "'net'", "'('", "')'", "'inst'", "'sub'", "'&'"
    };
    public static final int EOF=-1;
    public static final int T__20=20;
    public static final int T__21=21;
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
    public static final int IDENT=4;
    public static final int SEMICOLON=5;
    public static final int EQUALS=6;
    public static final int STRING_LITERAL=7;
    public static final int NUMBER_LIST=8;
    public static final int COMMA=9;
    public static final int COLON=10;
    public static final int INT=11;
    public static final int PERIOD=12;
    public static final int CHAR=13;
    public static final int DIGIT=14;
    public static final int LBRACKET=15;
    public static final int RBRACKET=16;
    public static final int WHITESPACE=17;
    public static final int LINE_COMMENT=18;
    public static final int MULTILINE_COMMENT=19;

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

                if ( (LA1_0==20) ) {
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:71:1: designDecl : 'design' IDENT 'is' ( portDecl | deviceDecl | netDecl )* 'begin' instances 'end' SEMICOLON ;
    public final PhdlParser.designDecl_return designDecl() throws RecognitionException {
        PhdlParser.designDecl_return retval = new PhdlParser.designDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal3=null;
        Token IDENT4=null;
        Token string_literal5=null;
        Token string_literal9=null;
        Token string_literal11=null;
        Token SEMICOLON12=null;
        PhdlParser.portDecl_return portDecl6 = null;

        PhdlParser.deviceDecl_return deviceDecl7 = null;

        PhdlParser.netDecl_return netDecl8 = null;

        PhdlParser.instances_return instances10 = null;


        CommonTree string_literal3_tree=null;
        CommonTree IDENT4_tree=null;
        CommonTree string_literal5_tree=null;
        CommonTree string_literal9_tree=null;
        CommonTree string_literal11_tree=null;
        CommonTree SEMICOLON12_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:77:2: ( 'design' IDENT 'is' ( portDecl | deviceDecl | netDecl )* 'begin' instances 'end' SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:78:3: 'design' IDENT 'is' ( portDecl | deviceDecl | netDecl )* 'begin' instances 'end' SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal3=(Token)match(input,20,FOLLOW_20_in_designDecl88); 
            string_literal3_tree = (CommonTree)adaptor.create(string_literal3);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal3_tree, root_0);

            IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_designDecl91); 
            IDENT4_tree = (CommonTree)adaptor.create(IDENT4);
            adaptor.addChild(root_0, IDENT4_tree);

            string_literal5=(Token)match(input,21,FOLLOW_21_in_designDecl93); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:81:3: ( portDecl | deviceDecl | netDecl )*
            loop2:
            do {
                int alt2=4;
                switch ( input.LA(1) ) {
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                    {
                    alt2=1;
                    }
                    break;
                case 24:
                    {
                    alt2=2;
                    }
                    break;
                case 33:
                    {
                    alt2=3;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:81:4: portDecl
            	    {
            	    pushFollow(FOLLOW_portDecl_in_designDecl106);
            	    portDecl6=portDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, portDecl6.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:81:15: deviceDecl
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_designDecl110);
            	    deviceDecl7=deviceDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, deviceDecl7.getTree());

            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:81:28: netDecl
            	    {
            	    pushFollow(FOLLOW_netDecl_in_designDecl114);
            	    netDecl8=netDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netDecl8.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            string_literal9=(Token)match(input,22,FOLLOW_22_in_designDecl123); 
            string_literal9_tree = (CommonTree)adaptor.create(string_literal9);
            adaptor.addChild(root_0, string_literal9_tree);

            pushFollow(FOLLOW_instances_in_designDecl133);
            instances10=instances();

            state._fsp--;

            adaptor.addChild(root_0, instances10.getTree());
            string_literal11=(Token)match(input,23,FOLLOW_23_in_designDecl137); 
            SEMICOLON12=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_designDecl140); 

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

    public static class portDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "portDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:90:1: portDecl : type ( array )? IDENT SEMICOLON ;
    public final PhdlParser.portDecl_return portDecl() throws RecognitionException {
        PhdlParser.portDecl_return retval = new PhdlParser.portDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT15=null;
        Token SEMICOLON16=null;
        PhdlParser.type_return type13 = null;

        PhdlParser.array_return array14 = null;


        CommonTree IDENT15_tree=null;
        CommonTree SEMICOLON16_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:91:2: ( type ( array )? IDENT SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:91:6: type ( array )? IDENT SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_type_in_portDecl154);
            type13=type();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(type13.getTree(), root_0);
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:91:12: ( array )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==LBRACKET) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:91:12: array
                    {
                    pushFollow(FOLLOW_array_in_portDecl157);
                    array14=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array14.getTree());

                    }
                    break;

            }

            IDENT15=(Token)match(input,IDENT,FOLLOW_IDENT_in_portDecl160); 
            IDENT15_tree = (CommonTree)adaptor.create(IDENT15);
            adaptor.addChild(root_0, IDENT15_tree);

            SEMICOLON16=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_portDecl162); 

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
    // $ANTLR end "portDecl"

    public static class deviceDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "deviceDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:94:1: deviceDecl : 'device' IDENT 'is' ( attributeDecl )* 'begin' ( pinDecl )* 'end' SEMICOLON ;
    public final PhdlParser.deviceDecl_return deviceDecl() throws RecognitionException {
        PhdlParser.deviceDecl_return retval = new PhdlParser.deviceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal17=null;
        Token IDENT18=null;
        Token string_literal19=null;
        Token string_literal21=null;
        Token string_literal23=null;
        Token SEMICOLON24=null;
        PhdlParser.attributeDecl_return attributeDecl20 = null;

        PhdlParser.pinDecl_return pinDecl22 = null;


        CommonTree string_literal17_tree=null;
        CommonTree IDENT18_tree=null;
        CommonTree string_literal19_tree=null;
        CommonTree string_literal21_tree=null;
        CommonTree string_literal23_tree=null;
        CommonTree SEMICOLON24_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:100:2: ( 'device' IDENT 'is' ( attributeDecl )* 'begin' ( pinDecl )* 'end' SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:100:4: 'device' IDENT 'is' ( attributeDecl )* 'begin' ( pinDecl )* 'end' SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal17=(Token)match(input,24,FOLLOW_24_in_deviceDecl177); 
            string_literal17_tree = (CommonTree)adaptor.create(string_literal17);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal17_tree, root_0);

            IDENT18=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl180); 
            IDENT18_tree = (CommonTree)adaptor.create(IDENT18);
            adaptor.addChild(root_0, IDENT18_tree);

            string_literal19=(Token)match(input,21,FOLLOW_21_in_deviceDecl182); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:101:3: ( attributeDecl )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==IDENT) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:101:3: attributeDecl
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_deviceDecl187);
            	    attributeDecl20=attributeDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeDecl20.getTree());

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            string_literal21=(Token)match(input,22,FOLLOW_22_in_deviceDecl192); 
            string_literal21_tree = (CommonTree)adaptor.create(string_literal21);
            adaptor.addChild(root_0, string_literal21_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:103:3: ( pinDecl )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=25 && LA5_0<=32)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:103:3: pinDecl
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl196);
            	    pinDecl22=pinDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinDecl22.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            string_literal23=(Token)match(input,23,FOLLOW_23_in_deviceDecl201); 
            SEMICOLON24=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_deviceDecl204); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:107:1: attributeDecl : IDENT EQUALS STRING_LITERAL SEMICOLON ;
    public final PhdlParser.attributeDecl_return attributeDecl() throws RecognitionException {
        PhdlParser.attributeDecl_return retval = new PhdlParser.attributeDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT25=null;
        Token EQUALS26=null;
        Token STRING_LITERAL27=null;
        Token SEMICOLON28=null;

        CommonTree IDENT25_tree=null;
        CommonTree EQUALS26_tree=null;
        CommonTree STRING_LITERAL27_tree=null;
        CommonTree SEMICOLON28_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:108:2: ( IDENT EQUALS STRING_LITERAL SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:109:3: IDENT EQUALS STRING_LITERAL SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT25=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeDecl220); 
            IDENT25_tree = (CommonTree)adaptor.create(IDENT25);
            adaptor.addChild(root_0, IDENT25_tree);

            EQUALS26=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeDecl222); 
            EQUALS26_tree = (CommonTree)adaptor.create(EQUALS26);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS26_tree, root_0);

            STRING_LITERAL27=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_attributeDecl225); 
            STRING_LITERAL27_tree = (CommonTree)adaptor.create(STRING_LITERAL27);
            adaptor.addChild(root_0, STRING_LITERAL27_tree);

            SEMICOLON28=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeDecl227); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:112:1: pinDecl : type ( array )? IDENT EQUALS NUMBER_LIST SEMICOLON ;
    public final PhdlParser.pinDecl_return pinDecl() throws RecognitionException {
        PhdlParser.pinDecl_return retval = new PhdlParser.pinDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT31=null;
        Token EQUALS32=null;
        Token NUMBER_LIST33=null;
        Token SEMICOLON34=null;
        PhdlParser.type_return type29 = null;

        PhdlParser.array_return array30 = null;


        CommonTree IDENT31_tree=null;
        CommonTree EQUALS32_tree=null;
        CommonTree NUMBER_LIST33_tree=null;
        CommonTree SEMICOLON34_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:113:2: ( type ( array )? IDENT EQUALS NUMBER_LIST SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:114:3: type ( array )? IDENT EQUALS NUMBER_LIST SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_type_in_pinDecl243);
            type29=type();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(type29.getTree(), root_0);
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:114:9: ( array )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==LBRACKET) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:114:9: array
                    {
                    pushFollow(FOLLOW_array_in_pinDecl246);
                    array30=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array30.getTree());

                    }
                    break;

            }

            IDENT31=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinDecl249); 
            IDENT31_tree = (CommonTree)adaptor.create(IDENT31);
            adaptor.addChild(root_0, IDENT31_tree);

            EQUALS32=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinDecl251); 
            NUMBER_LIST33=(Token)match(input,NUMBER_LIST,FOLLOW_NUMBER_LIST_in_pinDecl254); 
            NUMBER_LIST33_tree = (CommonTree)adaptor.create(NUMBER_LIST33);
            adaptor.addChild(root_0, NUMBER_LIST33_tree);

            SEMICOLON34=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinDecl256); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:117:1: type : ( 'pin' | 'in' | 'out' | 'inout' | 'passive' | 'supply' | 'power' | 'open' );
    public final PhdlParser.type_return type() throws RecognitionException {
        PhdlParser.type_return retval = new PhdlParser.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set35=null;

        CommonTree set35_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:122:2: ( 'pin' | 'in' | 'out' | 'inout' | 'passive' | 'supply' | 'power' | 'open' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set35=(Token)input.LT(1);
            if ( (input.LA(1)>=25 && input.LA(1)<=32) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set35));
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:132:1: netDecl : 'net' ( array )? ( IDENT COMMA )* IDENT ( COLON ( IDENT COMMA )* IDENT )? SEMICOLON ;
    public final PhdlParser.netDecl_return netDecl() throws RecognitionException {
        PhdlParser.netDecl_return retval = new PhdlParser.netDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal36=null;
        Token IDENT38=null;
        Token COMMA39=null;
        Token IDENT40=null;
        Token COLON41=null;
        Token IDENT42=null;
        Token COMMA43=null;
        Token IDENT44=null;
        Token SEMICOLON45=null;
        PhdlParser.array_return array37 = null;


        CommonTree string_literal36_tree=null;
        CommonTree IDENT38_tree=null;
        CommonTree COMMA39_tree=null;
        CommonTree IDENT40_tree=null;
        CommonTree COLON41_tree=null;
        CommonTree IDENT42_tree=null;
        CommonTree COMMA43_tree=null;
        CommonTree IDENT44_tree=null;
        CommonTree SEMICOLON45_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:140:2: ( 'net' ( array )? ( IDENT COMMA )* IDENT ( COLON ( IDENT COMMA )* IDENT )? SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:140:4: 'net' ( array )? ( IDENT COMMA )* IDENT ( COLON ( IDENT COMMA )* IDENT )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal36=(Token)match(input,33,FOLLOW_33_in_netDecl320); 
            string_literal36_tree = (CommonTree)adaptor.create(string_literal36);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal36_tree, root_0);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:140:11: ( array )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==LBRACKET) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:140:12: array
                    {
                    pushFollow(FOLLOW_array_in_netDecl324);
                    array37=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array37.getTree());

                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:140:20: ( IDENT COMMA )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==IDENT) ) {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1==COMMA) ) {
                        alt8=1;
                    }


                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:140:21: IDENT COMMA
            	    {
            	    IDENT38=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl329); 
            	    IDENT38_tree = (CommonTree)adaptor.create(IDENT38);
            	    adaptor.addChild(root_0, IDENT38_tree);

            	    COMMA39=(Token)match(input,COMMA,FOLLOW_COMMA_in_netDecl331); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            IDENT40=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl336); 
            IDENT40_tree = (CommonTree)adaptor.create(IDENT40);
            adaptor.addChild(root_0, IDENT40_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:140:42: ( COLON ( IDENT COMMA )* IDENT )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==COLON) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:140:43: COLON ( IDENT COMMA )* IDENT
                    {
                    COLON41=(Token)match(input,COLON,FOLLOW_COLON_in_netDecl339); 
                    COLON41_tree = (CommonTree)adaptor.create(COLON41);
                    adaptor.addChild(root_0, COLON41_tree);

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:140:49: ( IDENT COMMA )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==IDENT) ) {
                            int LA9_1 = input.LA(2);

                            if ( (LA9_1==COMMA) ) {
                                alt9=1;
                            }


                        }


                        switch (alt9) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:140:50: IDENT COMMA
                    	    {
                    	    IDENT42=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl342); 
                    	    IDENT42_tree = (CommonTree)adaptor.create(IDENT42);
                    	    adaptor.addChild(root_0, IDENT42_tree);

                    	    COMMA43=(Token)match(input,COMMA,FOLLOW_COMMA_in_netDecl344); 

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    IDENT44=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl349); 
                    IDENT44_tree = (CommonTree)adaptor.create(IDENT44);
                    adaptor.addChild(root_0, IDENT44_tree);


                    }
                    break;

            }

            SEMICOLON45=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netDecl353); 

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

    public static class array_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "array"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:143:1: array : '[' INT ':' INT ']' ;
    public final PhdlParser.array_return array() throws RecognitionException {
        PhdlParser.array_return retval = new PhdlParser.array_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal46=null;
        Token INT47=null;
        Token char_literal48=null;
        Token INT49=null;
        Token char_literal50=null;

        CommonTree char_literal46_tree=null;
        CommonTree INT47_tree=null;
        CommonTree char_literal48_tree=null;
        CommonTree INT49_tree=null;
        CommonTree char_literal50_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:147:2: ( '[' INT ':' INT ']' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:147:4: '[' INT ':' INT ']'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal46=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_array368); 
            INT47=(Token)match(input,INT,FOLLOW_INT_in_array371); 
            INT47_tree = (CommonTree)adaptor.create(INT47);
            adaptor.addChild(root_0, INT47_tree);

            char_literal48=(Token)match(input,COLON,FOLLOW_COLON_in_array373); 
            char_literal48_tree = (CommonTree)adaptor.create(char_literal48);
            adaptor.addChild(root_0, char_literal48_tree);

            INT49=(Token)match(input,INT,FOLLOW_INT_in_array375); 
            INT49_tree = (CommonTree)adaptor.create(INT49);
            adaptor.addChild(root_0, INT49_tree);

            char_literal50=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_array377); 

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
    // $ANTLR end "array"

    public static class index_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "index"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:150:1: index : '(' INT ')' ;
    public final PhdlParser.index_return index() throws RecognitionException {
        PhdlParser.index_return retval = new PhdlParser.index_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal51=null;
        Token INT52=null;
        Token char_literal53=null;

        CommonTree char_literal51_tree=null;
        CommonTree INT52_tree=null;
        CommonTree char_literal53_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:154:2: ( '(' INT ')' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:154:4: '(' INT ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal51=(Token)match(input,34,FOLLOW_34_in_index393); 
            INT52=(Token)match(input,INT,FOLLOW_INT_in_index396); 
            INT52_tree = (CommonTree)adaptor.create(INT52);
            adaptor.addChild(root_0, INT52_tree);

            char_literal53=(Token)match(input,35,FOLLOW_35_in_index398); 

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
    // $ANTLR end "index"

    public static class slice_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "slice"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:157:1: slice : ( array | index | NUMBER_LIST ) ;
    public final PhdlParser.slice_return slice() throws RecognitionException {
        PhdlParser.slice_return retval = new PhdlParser.slice_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NUMBER_LIST56=null;
        PhdlParser.array_return array54 = null;

        PhdlParser.index_return index55 = null;


        CommonTree NUMBER_LIST56_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:161:2: ( ( array | index | NUMBER_LIST ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:161:4: ( array | index | NUMBER_LIST )
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:161:4: ( array | index | NUMBER_LIST )
            int alt11=3;
            switch ( input.LA(1) ) {
            case LBRACKET:
                {
                alt11=1;
                }
                break;
            case 34:
                {
                alt11=2;
                }
                break;
            case NUMBER_LIST:
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:161:5: array
                    {
                    pushFollow(FOLLOW_array_in_slice413);
                    array54=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array54.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:161:13: index
                    {
                    pushFollow(FOLLOW_index_in_slice417);
                    index55=index();

                    state._fsp--;

                    adaptor.addChild(root_0, index55.getTree());

                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:161:21: NUMBER_LIST
                    {
                    NUMBER_LIST56=(Token)match(input,NUMBER_LIST,FOLLOW_NUMBER_LIST_in_slice421); 
                    NUMBER_LIST56_tree = (CommonTree)adaptor.create(NUMBER_LIST56);
                    adaptor.addChild(root_0, NUMBER_LIST56_tree);


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
    // $ANTLR end "slice"

    public static class instances_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "instances"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:164:1: instances : ( deviceInstance | subDesignInstance | netAssignment )* ;
    public final PhdlParser.instances_return instances() throws RecognitionException {
        PhdlParser.instances_return retval = new PhdlParser.instances_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        PhdlParser.deviceInstance_return deviceInstance57 = null;

        PhdlParser.subDesignInstance_return subDesignInstance58 = null;

        PhdlParser.netAssignment_return netAssignment59 = null;



        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:165:2: ( ( deviceInstance | subDesignInstance | netAssignment )* )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:165:4: ( deviceInstance | subDesignInstance | netAssignment )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:165:4: ( deviceInstance | subDesignInstance | netAssignment )*
            loop12:
            do {
                int alt12=4;
                switch ( input.LA(1) ) {
                case 36:
                    {
                    alt12=1;
                    }
                    break;
                case 37:
                    {
                    alt12=2;
                    }
                    break;
                case IDENT:
                    {
                    alt12=3;
                    }
                    break;

                }

                switch (alt12) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:165:5: deviceInstance
            	    {
            	    pushFollow(FOLLOW_deviceInstance_in_instances435);
            	    deviceInstance57=deviceInstance();

            	    state._fsp--;

            	    adaptor.addChild(root_0, deviceInstance57.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:165:22: subDesignInstance
            	    {
            	    pushFollow(FOLLOW_subDesignInstance_in_instances439);
            	    subDesignInstance58=subDesignInstance();

            	    state._fsp--;

            	    adaptor.addChild(root_0, subDesignInstance58.getTree());

            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:165:42: netAssignment
            	    {
            	    pushFollow(FOLLOW_netAssignment_in_instances443);
            	    netAssignment59=netAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netAssignment59.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


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
    // $ANTLR end "instances"

    public static class deviceInstance_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "deviceInstance"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:168:1: deviceInstance : 'inst' IDENT ':' IDENT ( array )? 'is' ( attributeAssignment )* 'begin' ( pinAssignment )* 'end' ';' ;
    public final PhdlParser.deviceInstance_return deviceInstance() throws RecognitionException {
        PhdlParser.deviceInstance_return retval = new PhdlParser.deviceInstance_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal60=null;
        Token IDENT61=null;
        Token char_literal62=null;
        Token IDENT63=null;
        Token string_literal65=null;
        Token string_literal67=null;
        Token string_literal69=null;
        Token char_literal70=null;
        PhdlParser.array_return array64 = null;

        PhdlParser.attributeAssignment_return attributeAssignment66 = null;

        PhdlParser.pinAssignment_return pinAssignment68 = null;


        CommonTree string_literal60_tree=null;
        CommonTree IDENT61_tree=null;
        CommonTree char_literal62_tree=null;
        CommonTree IDENT63_tree=null;
        CommonTree string_literal65_tree=null;
        CommonTree string_literal67_tree=null;
        CommonTree string_literal69_tree=null;
        CommonTree char_literal70_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:169:2: ( 'inst' IDENT ':' IDENT ( array )? 'is' ( attributeAssignment )* 'begin' ( pinAssignment )* 'end' ';' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:169:4: 'inst' IDENT ':' IDENT ( array )? 'is' ( attributeAssignment )* 'begin' ( pinAssignment )* 'end' ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal60=(Token)match(input,36,FOLLOW_36_in_deviceInstance457); 
            string_literal60_tree = (CommonTree)adaptor.create(string_literal60);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal60_tree, root_0);

            IDENT61=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceInstance460); 
            IDENT61_tree = (CommonTree)adaptor.create(IDENT61);
            adaptor.addChild(root_0, IDENT61_tree);

            char_literal62=(Token)match(input,COLON,FOLLOW_COLON_in_deviceInstance462); 
            IDENT63=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceInstance465); 
            IDENT63_tree = (CommonTree)adaptor.create(IDENT63);
            adaptor.addChild(root_0, IDENT63_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:169:29: ( array )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==LBRACKET) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:169:30: array
                    {
                    pushFollow(FOLLOW_array_in_deviceInstance468);
                    array64=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array64.getTree());

                    }
                    break;

            }

            string_literal65=(Token)match(input,21,FOLLOW_21_in_deviceInstance472); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:170:3: ( attributeAssignment )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==IDENT) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:170:3: attributeAssignment
            	    {
            	    pushFollow(FOLLOW_attributeAssignment_in_deviceInstance477);
            	    attributeAssignment66=attributeAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeAssignment66.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            string_literal67=(Token)match(input,22,FOLLOW_22_in_deviceInstance482); 
            string_literal67_tree = (CommonTree)adaptor.create(string_literal67);
            adaptor.addChild(root_0, string_literal67_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:172:3: ( pinAssignment )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==IDENT) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:172:3: pinAssignment
            	    {
            	    pushFollow(FOLLOW_pinAssignment_in_deviceInstance486);
            	    pinAssignment68=pinAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinAssignment68.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            string_literal69=(Token)match(input,23,FOLLOW_23_in_deviceInstance491); 
            char_literal70=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_deviceInstance494); 

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

    public static class subDesignInstance_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subDesignInstance"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:176:1: subDesignInstance : 'sub' IDENT ':' IDENT ( array )? 'is' ( subAttributeAssignment )* 'begin' ( portAssignment )* 'end' ';' ;
    public final PhdlParser.subDesignInstance_return subDesignInstance() throws RecognitionException {
        PhdlParser.subDesignInstance_return retval = new PhdlParser.subDesignInstance_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal71=null;
        Token IDENT72=null;
        Token char_literal73=null;
        Token IDENT74=null;
        Token string_literal76=null;
        Token string_literal78=null;
        Token string_literal80=null;
        Token char_literal81=null;
        PhdlParser.array_return array75 = null;

        PhdlParser.subAttributeAssignment_return subAttributeAssignment77 = null;

        PhdlParser.portAssignment_return portAssignment79 = null;


        CommonTree string_literal71_tree=null;
        CommonTree IDENT72_tree=null;
        CommonTree char_literal73_tree=null;
        CommonTree IDENT74_tree=null;
        CommonTree string_literal76_tree=null;
        CommonTree string_literal78_tree=null;
        CommonTree string_literal80_tree=null;
        CommonTree char_literal81_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:177:2: ( 'sub' IDENT ':' IDENT ( array )? 'is' ( subAttributeAssignment )* 'begin' ( portAssignment )* 'end' ';' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:177:4: 'sub' IDENT ':' IDENT ( array )? 'is' ( subAttributeAssignment )* 'begin' ( portAssignment )* 'end' ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal71=(Token)match(input,37,FOLLOW_37_in_subDesignInstance507); 
            string_literal71_tree = (CommonTree)adaptor.create(string_literal71);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal71_tree, root_0);

            IDENT72=(Token)match(input,IDENT,FOLLOW_IDENT_in_subDesignInstance510); 
            IDENT72_tree = (CommonTree)adaptor.create(IDENT72);
            adaptor.addChild(root_0, IDENT72_tree);

            char_literal73=(Token)match(input,COLON,FOLLOW_COLON_in_subDesignInstance512); 
            IDENT74=(Token)match(input,IDENT,FOLLOW_IDENT_in_subDesignInstance515); 
            IDENT74_tree = (CommonTree)adaptor.create(IDENT74);
            adaptor.addChild(root_0, IDENT74_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:177:28: ( array )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==LBRACKET) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:177:29: array
                    {
                    pushFollow(FOLLOW_array_in_subDesignInstance518);
                    array75=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array75.getTree());

                    }
                    break;

            }

            string_literal76=(Token)match(input,21,FOLLOW_21_in_subDesignInstance522); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:178:3: ( subAttributeAssignment )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==IDENT) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:178:3: subAttributeAssignment
            	    {
            	    pushFollow(FOLLOW_subAttributeAssignment_in_subDesignInstance527);
            	    subAttributeAssignment77=subAttributeAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, subAttributeAssignment77.getTree());

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            string_literal78=(Token)match(input,22,FOLLOW_22_in_subDesignInstance532); 
            string_literal78_tree = (CommonTree)adaptor.create(string_literal78);
            adaptor.addChild(root_0, string_literal78_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:180:3: ( portAssignment )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==IDENT) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:180:3: portAssignment
            	    {
            	    pushFollow(FOLLOW_portAssignment_in_subDesignInstance536);
            	    portAssignment79=portAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, portAssignment79.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            string_literal80=(Token)match(input,23,FOLLOW_23_in_subDesignInstance541); 
            char_literal81=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_subDesignInstance544); 

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

    public static class subAttributeAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subAttributeAssignment"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:184:1: subAttributeAssignment : IDENT PERIOD IDENT ( slice )? EQUALS STRING_LITERAL SEMICOLON ;
    public final PhdlParser.subAttributeAssignment_return subAttributeAssignment() throws RecognitionException {
        PhdlParser.subAttributeAssignment_return retval = new PhdlParser.subAttributeAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT82=null;
        Token PERIOD83=null;
        Token IDENT84=null;
        Token EQUALS86=null;
        Token STRING_LITERAL87=null;
        Token SEMICOLON88=null;
        PhdlParser.slice_return slice85 = null;


        CommonTree IDENT82_tree=null;
        CommonTree PERIOD83_tree=null;
        CommonTree IDENT84_tree=null;
        CommonTree EQUALS86_tree=null;
        CommonTree STRING_LITERAL87_tree=null;
        CommonTree SEMICOLON88_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:185:2: ( IDENT PERIOD IDENT ( slice )? EQUALS STRING_LITERAL SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:185:4: IDENT PERIOD IDENT ( slice )? EQUALS STRING_LITERAL SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT82=(Token)match(input,IDENT,FOLLOW_IDENT_in_subAttributeAssignment557); 
            IDENT82_tree = (CommonTree)adaptor.create(IDENT82);
            root_0 = (CommonTree)adaptor.becomeRoot(IDENT82_tree, root_0);

            PERIOD83=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_subAttributeAssignment560); 
            IDENT84=(Token)match(input,IDENT,FOLLOW_IDENT_in_subAttributeAssignment563); 
            IDENT84_tree = (CommonTree)adaptor.create(IDENT84);
            adaptor.addChild(root_0, IDENT84_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:185:25: ( slice )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==NUMBER_LIST||LA19_0==LBRACKET||LA19_0==34) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:185:25: slice
                    {
                    pushFollow(FOLLOW_slice_in_subAttributeAssignment565);
                    slice85=slice();

                    state._fsp--;

                    adaptor.addChild(root_0, slice85.getTree());

                    }
                    break;

            }

            EQUALS86=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_subAttributeAssignment568); 
            STRING_LITERAL87=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_subAttributeAssignment571); 
            STRING_LITERAL87_tree = (CommonTree)adaptor.create(STRING_LITERAL87);
            adaptor.addChild(root_0, STRING_LITERAL87_tree);

            SEMICOLON88=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_subAttributeAssignment573); 

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
    // $ANTLR end "subAttributeAssignment"

    public static class attributeAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributeAssignment"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:188:1: attributeAssignment : IDENT ( slice )? EQUALS STRING_LITERAL SEMICOLON ;
    public final PhdlParser.attributeAssignment_return attributeAssignment() throws RecognitionException {
        PhdlParser.attributeAssignment_return retval = new PhdlParser.attributeAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT89=null;
        Token EQUALS91=null;
        Token STRING_LITERAL92=null;
        Token SEMICOLON93=null;
        PhdlParser.slice_return slice90 = null;


        CommonTree IDENT89_tree=null;
        CommonTree EQUALS91_tree=null;
        CommonTree STRING_LITERAL92_tree=null;
        CommonTree SEMICOLON93_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:189:2: ( IDENT ( slice )? EQUALS STRING_LITERAL SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:189:4: IDENT ( slice )? EQUALS STRING_LITERAL SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT89=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeAssignment586); 
            IDENT89_tree = (CommonTree)adaptor.create(IDENT89);
            adaptor.addChild(root_0, IDENT89_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:189:10: ( slice )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==NUMBER_LIST||LA20_0==LBRACKET||LA20_0==34) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:189:10: slice
                    {
                    pushFollow(FOLLOW_slice_in_attributeAssignment588);
                    slice90=slice();

                    state._fsp--;

                    adaptor.addChild(root_0, slice90.getTree());

                    }
                    break;

            }

            EQUALS91=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeAssignment591); 
            EQUALS91_tree = (CommonTree)adaptor.create(EQUALS91);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS91_tree, root_0);

            STRING_LITERAL92=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_attributeAssignment594); 
            STRING_LITERAL92_tree = (CommonTree)adaptor.create(STRING_LITERAL92);
            adaptor.addChild(root_0, STRING_LITERAL92_tree);

            SEMICOLON93=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeAssignment596); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:192:1: pinAssignment : IDENT ( slice ( slice )? )? EQUALS concatenation SEMICOLON ;
    public final PhdlParser.pinAssignment_return pinAssignment() throws RecognitionException {
        PhdlParser.pinAssignment_return retval = new PhdlParser.pinAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT94=null;
        Token EQUALS97=null;
        Token SEMICOLON99=null;
        PhdlParser.slice_return slice95 = null;

        PhdlParser.slice_return slice96 = null;

        PhdlParser.concatenation_return concatenation98 = null;


        CommonTree IDENT94_tree=null;
        CommonTree EQUALS97_tree=null;
        CommonTree SEMICOLON99_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:193:2: ( IDENT ( slice ( slice )? )? EQUALS concatenation SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:193:4: IDENT ( slice ( slice )? )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT94=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinAssignment609); 
            IDENT94_tree = (CommonTree)adaptor.create(IDENT94);
            adaptor.addChild(root_0, IDENT94_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:193:10: ( slice ( slice )? )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==NUMBER_LIST||LA22_0==LBRACKET||LA22_0==34) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:193:11: slice ( slice )?
                    {
                    pushFollow(FOLLOW_slice_in_pinAssignment612);
                    slice95=slice();

                    state._fsp--;

                    adaptor.addChild(root_0, slice95.getTree());
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:193:17: ( slice )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==NUMBER_LIST||LA21_0==LBRACKET||LA21_0==34) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:193:17: slice
                            {
                            pushFollow(FOLLOW_slice_in_pinAssignment614);
                            slice96=slice();

                            state._fsp--;

                            adaptor.addChild(root_0, slice96.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }

            EQUALS97=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinAssignment619); 
            EQUALS97_tree = (CommonTree)adaptor.create(EQUALS97);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS97_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_pinAssignment622);
            concatenation98=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation98.getTree());
            SEMICOLON99=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinAssignment624); 

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

    public static class portAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "portAssignment"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:196:1: portAssignment : IDENT ( slice ( slice )? )? EQUALS concatenation SEMICOLON ;
    public final PhdlParser.portAssignment_return portAssignment() throws RecognitionException {
        PhdlParser.portAssignment_return retval = new PhdlParser.portAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT100=null;
        Token EQUALS103=null;
        Token SEMICOLON105=null;
        PhdlParser.slice_return slice101 = null;

        PhdlParser.slice_return slice102 = null;

        PhdlParser.concatenation_return concatenation104 = null;


        CommonTree IDENT100_tree=null;
        CommonTree EQUALS103_tree=null;
        CommonTree SEMICOLON105_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:197:2: ( IDENT ( slice ( slice )? )? EQUALS concatenation SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:197:4: IDENT ( slice ( slice )? )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT100=(Token)match(input,IDENT,FOLLOW_IDENT_in_portAssignment637); 
            IDENT100_tree = (CommonTree)adaptor.create(IDENT100);
            adaptor.addChild(root_0, IDENT100_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:197:10: ( slice ( slice )? )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==NUMBER_LIST||LA24_0==LBRACKET||LA24_0==34) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:197:11: slice ( slice )?
                    {
                    pushFollow(FOLLOW_slice_in_portAssignment640);
                    slice101=slice();

                    state._fsp--;

                    adaptor.addChild(root_0, slice101.getTree());
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:197:17: ( slice )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==NUMBER_LIST||LA23_0==LBRACKET||LA23_0==34) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:197:17: slice
                            {
                            pushFollow(FOLLOW_slice_in_portAssignment642);
                            slice102=slice();

                            state._fsp--;

                            adaptor.addChild(root_0, slice102.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }

            EQUALS103=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_portAssignment647); 
            EQUALS103_tree = (CommonTree)adaptor.create(EQUALS103);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS103_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_portAssignment650);
            concatenation104=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation104.getTree());
            SEMICOLON105=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_portAssignment652); 

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

    public static class netAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "netAssignment"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:200:1: netAssignment : IDENT ( slice )? EQUALS concatenation SEMICOLON ;
    public final PhdlParser.netAssignment_return netAssignment() throws RecognitionException {
        PhdlParser.netAssignment_return retval = new PhdlParser.netAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT106=null;
        Token EQUALS108=null;
        Token SEMICOLON110=null;
        PhdlParser.slice_return slice107 = null;

        PhdlParser.concatenation_return concatenation109 = null;


        CommonTree IDENT106_tree=null;
        CommonTree EQUALS108_tree=null;
        CommonTree SEMICOLON110_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:201:2: ( IDENT ( slice )? EQUALS concatenation SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:201:4: IDENT ( slice )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT106=(Token)match(input,IDENT,FOLLOW_IDENT_in_netAssignment665); 
            IDENT106_tree = (CommonTree)adaptor.create(IDENT106);
            adaptor.addChild(root_0, IDENT106_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:201:10: ( slice )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==NUMBER_LIST||LA25_0==LBRACKET||LA25_0==34) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:201:10: slice
                    {
                    pushFollow(FOLLOW_slice_in_netAssignment667);
                    slice107=slice();

                    state._fsp--;

                    adaptor.addChild(root_0, slice107.getTree());

                    }
                    break;

            }

            EQUALS108=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_netAssignment670); 
            EQUALS108_tree = (CommonTree)adaptor.create(EQUALS108);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS108_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_netAssignment673);
            concatenation109=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation109.getTree());
            SEMICOLON110=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netAssignment675); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:204:1: concatenation : ( ( ( IDENT ( slice )? ) ( '&' IDENT ( slice )? )* ) | 'open' );
    public final PhdlParser.concatenation_return concatenation() throws RecognitionException {
        PhdlParser.concatenation_return retval = new PhdlParser.concatenation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT111=null;
        Token char_literal113=null;
        Token IDENT114=null;
        Token string_literal116=null;
        PhdlParser.slice_return slice112 = null;

        PhdlParser.slice_return slice115 = null;


        CommonTree IDENT111_tree=null;
        CommonTree char_literal113_tree=null;
        CommonTree IDENT114_tree=null;
        CommonTree string_literal116_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:205:2: ( ( ( IDENT ( slice )? ) ( '&' IDENT ( slice )? )* ) | 'open' )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==IDENT) ) {
                alt29=1;
            }
            else if ( (LA29_0==32) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:205:4: ( ( IDENT ( slice )? ) ( '&' IDENT ( slice )? )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:205:4: ( ( IDENT ( slice )? ) ( '&' IDENT ( slice )? )* )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:205:5: ( IDENT ( slice )? ) ( '&' IDENT ( slice )? )*
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:205:5: ( IDENT ( slice )? )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:205:6: IDENT ( slice )?
                    {
                    IDENT111=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation690); 
                    IDENT111_tree = (CommonTree)adaptor.create(IDENT111);
                    adaptor.addChild(root_0, IDENT111_tree);

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:205:12: ( slice )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==NUMBER_LIST||LA26_0==LBRACKET||LA26_0==34) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:205:12: slice
                            {
                            pushFollow(FOLLOW_slice_in_concatenation692);
                            slice112=slice();

                            state._fsp--;

                            adaptor.addChild(root_0, slice112.getTree());

                            }
                            break;

                    }


                    }

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:205:20: ( '&' IDENT ( slice )? )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==38) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:205:21: '&' IDENT ( slice )?
                    	    {
                    	    char_literal113=(Token)match(input,38,FOLLOW_38_in_concatenation697); 
                    	    IDENT114=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation700); 
                    	    IDENT114_tree = (CommonTree)adaptor.create(IDENT114);
                    	    adaptor.addChild(root_0, IDENT114_tree);

                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:205:32: ( slice )?
                    	    int alt27=2;
                    	    int LA27_0 = input.LA(1);

                    	    if ( (LA27_0==NUMBER_LIST||LA27_0==LBRACKET||LA27_0==34) ) {
                    	        alt27=1;
                    	    }
                    	    switch (alt27) {
                    	        case 1 :
                    	            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:205:32: slice
                    	            {
                    	            pushFollow(FOLLOW_slice_in_concatenation702);
                    	            slice115=slice();

                    	            state._fsp--;

                    	            adaptor.addChild(root_0, slice115.getTree());

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:205:45: 'open'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal116=(Token)match(input,32,FOLLOW_32_in_concatenation711); 

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


 

    public static final BitSet FOLLOW_designDecl_in_sourceText68 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_EOF_in_sourceText71 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_designDecl88 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_designDecl91 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_designDecl93 = new BitSet(new long[]{0x00000003FF400000L});
    public static final BitSet FOLLOW_portDecl_in_designDecl106 = new BitSet(new long[]{0x00000003FF400000L});
    public static final BitSet FOLLOW_deviceDecl_in_designDecl110 = new BitSet(new long[]{0x00000003FF400000L});
    public static final BitSet FOLLOW_netDecl_in_designDecl114 = new BitSet(new long[]{0x00000003FF400000L});
    public static final BitSet FOLLOW_22_in_designDecl123 = new BitSet(new long[]{0x0000003000800010L});
    public static final BitSet FOLLOW_instances_in_designDecl133 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_designDecl137 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_designDecl140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_portDecl154 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_array_in_portDecl157 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_portDecl160 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_portDecl162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_deviceDecl177 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl180 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_deviceDecl182 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_attributeDecl_in_deviceDecl187 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_22_in_deviceDecl192 = new BitSet(new long[]{0x00000001FE800000L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl196 = new BitSet(new long[]{0x00000001FE800000L});
    public static final BitSet FOLLOW_23_in_deviceDecl201 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_deviceDecl204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_attributeDecl220 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_attributeDecl222 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_attributeDecl225 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeDecl227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_pinDecl243 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_array_in_pinDecl246 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl249 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_pinDecl251 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_NUMBER_LIST_in_pinDecl254 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinDecl256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_netDecl320 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_array_in_netDecl324 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl329 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COMMA_in_netDecl331 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl336 = new BitSet(new long[]{0x0000000000000420L});
    public static final BitSet FOLLOW_COLON_in_netDecl339 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl342 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COMMA_in_netDecl344 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl349 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_netDecl353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_array368 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_array371 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_array373 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_array375 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RBRACKET_in_array377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_index393 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_index396 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_index398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_slice413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_index_in_slice417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_LIST_in_slice421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deviceInstance_in_instances435 = new BitSet(new long[]{0x0000003000000012L});
    public static final BitSet FOLLOW_subDesignInstance_in_instances439 = new BitSet(new long[]{0x0000003000000012L});
    public static final BitSet FOLLOW_netAssignment_in_instances443 = new BitSet(new long[]{0x0000003000000012L});
    public static final BitSet FOLLOW_36_in_deviceInstance457 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceInstance460 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_deviceInstance462 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceInstance465 = new BitSet(new long[]{0x0000000000208000L});
    public static final BitSet FOLLOW_array_in_deviceInstance468 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_deviceInstance472 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_attributeAssignment_in_deviceInstance477 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_22_in_deviceInstance482 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_pinAssignment_in_deviceInstance486 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_23_in_deviceInstance491 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_deviceInstance494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_subDesignInstance507 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_subDesignInstance510 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_subDesignInstance512 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_subDesignInstance515 = new BitSet(new long[]{0x0000000000208000L});
    public static final BitSet FOLLOW_array_in_subDesignInstance518 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_subDesignInstance522 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_subAttributeAssignment_in_subDesignInstance527 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_22_in_subDesignInstance532 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_portAssignment_in_subDesignInstance536 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_23_in_subDesignInstance541 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_subDesignInstance544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_subAttributeAssignment557 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_PERIOD_in_subAttributeAssignment560 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_subAttributeAssignment563 = new BitSet(new long[]{0x0000000400008140L});
    public static final BitSet FOLLOW_slice_in_subAttributeAssignment565 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_subAttributeAssignment568 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_subAttributeAssignment571 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_subAttributeAssignment573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_attributeAssignment586 = new BitSet(new long[]{0x0000000400008140L});
    public static final BitSet FOLLOW_slice_in_attributeAssignment588 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_attributeAssignment591 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_attributeAssignment594 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeAssignment596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_pinAssignment609 = new BitSet(new long[]{0x0000000400008140L});
    public static final BitSet FOLLOW_slice_in_pinAssignment612 = new BitSet(new long[]{0x0000000400008140L});
    public static final BitSet FOLLOW_slice_in_pinAssignment614 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssignment619 = new BitSet(new long[]{0x0000000100000010L});
    public static final BitSet FOLLOW_concatenation_in_pinAssignment622 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinAssignment624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_portAssignment637 = new BitSet(new long[]{0x0000000400008140L});
    public static final BitSet FOLLOW_slice_in_portAssignment640 = new BitSet(new long[]{0x0000000400008140L});
    public static final BitSet FOLLOW_slice_in_portAssignment642 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_portAssignment647 = new BitSet(new long[]{0x0000000100000010L});
    public static final BitSet FOLLOW_concatenation_in_portAssignment650 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_portAssignment652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_netAssignment665 = new BitSet(new long[]{0x0000000400008140L});
    public static final BitSet FOLLOW_slice_in_netAssignment667 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_netAssignment670 = new BitSet(new long[]{0x0000000100000010L});
    public static final BitSet FOLLOW_concatenation_in_netAssignment673 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_netAssignment675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_concatenation690 = new BitSet(new long[]{0x0000004400008102L});
    public static final BitSet FOLLOW_slice_in_concatenation692 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_concatenation697 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation700 = new BitSet(new long[]{0x0000004400008102L});
    public static final BitSet FOLLOW_slice_in_concatenation702 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_32_in_concatenation711 = new BitSet(new long[]{0x0000000000000002L});

}