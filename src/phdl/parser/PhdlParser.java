// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g 2011-06-23 20:07:20

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "SEMICOLON", "EQUALS", "STRING_LITERAL", "COMMA", "COLON", "INT", "CHAR", "DIGIT", "LBRACKET", "RBRACKET", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "'design'", "'is'", "'begin'", "'end'", "'port'", "'device'", "'pin'", "'in'", "'out'", "'inout'", "'passive'", "'supply'", "'power'", "'open'", "'net'", "'('", "')'", "'inst'", "'sub'", "'&'"
    };
    public static final int EOF=-1;
    public static final int T__18=18;
    public static final int T__19=19;
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
    public static final int IDENT=4;
    public static final int SEMICOLON=5;
    public static final int EQUALS=6;
    public static final int STRING_LITERAL=7;
    public static final int COMMA=8;
    public static final int COLON=9;
    public static final int INT=10;
    public static final int CHAR=11;
    public static final int DIGIT=12;
    public static final int LBRACKET=13;
    public static final int RBRACKET=14;
    public static final int WHITESPACE=15;
    public static final int LINE_COMMENT=16;
    public static final int MULTILINE_COMMENT=17;

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:65:1: sourceText : ( designDecl )* EOF ;
    public final PhdlParser.sourceText_return sourceText() throws RecognitionException {
        PhdlParser.sourceText_return retval = new PhdlParser.sourceText_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF2=null;
        PhdlParser.designDecl_return designDecl1 = null;


        CommonTree EOF2_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:68:2: ( ( designDecl )* EOF )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:68:4: ( designDecl )* EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:68:4: ( designDecl )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==18) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:68:4: designDecl
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:71:1: designDecl : 'design' IDENT 'is' ( portDecl | deviceDecl | netDecl )* 'begin' instances 'end' SEMICOLON ;
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
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:77:2: ( 'design' IDENT 'is' ( portDecl | deviceDecl | netDecl )* 'begin' instances 'end' SEMICOLON )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:78:3: 'design' IDENT 'is' ( portDecl | deviceDecl | netDecl )* 'begin' instances 'end' SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal3=(Token)match(input,18,FOLLOW_18_in_designDecl88); 
            string_literal3_tree = (CommonTree)adaptor.create(string_literal3);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal3_tree, root_0);

            IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_designDecl91); 
            IDENT4_tree = (CommonTree)adaptor.create(IDENT4);
            adaptor.addChild(root_0, IDENT4_tree);

            string_literal5=(Token)match(input,19,FOLLOW_19_in_designDecl93); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:81:3: ( portDecl | deviceDecl | netDecl )*
            loop2:
            do {
                int alt2=4;
                switch ( input.LA(1) ) {
                case 22:
                    {
                    alt2=1;
                    }
                    break;
                case 23:
                    {
                    alt2=2;
                    }
                    break;
                case 32:
                    {
                    alt2=3;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:81:4: portDecl
            	    {
            	    pushFollow(FOLLOW_portDecl_in_designDecl106);
            	    portDecl6=portDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, portDecl6.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:81:15: deviceDecl
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_designDecl110);
            	    deviceDecl7=deviceDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, deviceDecl7.getTree());

            	    }
            	    break;
            	case 3 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:81:28: netDecl
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

            string_literal9=(Token)match(input,20,FOLLOW_20_in_designDecl123); 
            string_literal9_tree = (CommonTree)adaptor.create(string_literal9);
            adaptor.addChild(root_0, string_literal9_tree);

            pushFollow(FOLLOW_instances_in_designDecl133);
            instances10=instances();

            state._fsp--;

            adaptor.addChild(root_0, instances10.getTree());
            string_literal11=(Token)match(input,21,FOLLOW_21_in_designDecl137); 
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:90:1: portDecl : 'port' type ( width )? IDENT SEMICOLON ;
    public final PhdlParser.portDecl_return portDecl() throws RecognitionException {
        PhdlParser.portDecl_return retval = new PhdlParser.portDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal13=null;
        Token IDENT16=null;
        Token SEMICOLON17=null;
        PhdlParser.type_return type14 = null;

        PhdlParser.width_return width15 = null;


        CommonTree string_literal13_tree=null;
        CommonTree IDENT16_tree=null;
        CommonTree SEMICOLON17_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:91:2: ( 'port' type ( width )? IDENT SEMICOLON )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:91:4: 'port' type ( width )? IDENT SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal13=(Token)match(input,22,FOLLOW_22_in_portDecl152); 
            pushFollow(FOLLOW_type_in_portDecl155);
            type14=type();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(type14.getTree(), root_0);
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:91:18: ( width )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==LBRACKET) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:91:18: width
                    {
                    pushFollow(FOLLOW_width_in_portDecl158);
                    width15=width();

                    state._fsp--;

                    adaptor.addChild(root_0, width15.getTree());

                    }
                    break;

            }

            IDENT16=(Token)match(input,IDENT,FOLLOW_IDENT_in_portDecl161); 
            IDENT16_tree = (CommonTree)adaptor.create(IDENT16);
            adaptor.addChild(root_0, IDENT16_tree);

            SEMICOLON17=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_portDecl163); 

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:94:1: deviceDecl : 'device' IDENT 'is' ( attributeDecl )* 'begin' ( pinDecl )* 'end' SEMICOLON ;
    public final PhdlParser.deviceDecl_return deviceDecl() throws RecognitionException {
        PhdlParser.deviceDecl_return retval = new PhdlParser.deviceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal18=null;
        Token IDENT19=null;
        Token string_literal20=null;
        Token string_literal22=null;
        Token string_literal24=null;
        Token SEMICOLON25=null;
        PhdlParser.attributeDecl_return attributeDecl21 = null;

        PhdlParser.pinDecl_return pinDecl23 = null;


        CommonTree string_literal18_tree=null;
        CommonTree IDENT19_tree=null;
        CommonTree string_literal20_tree=null;
        CommonTree string_literal22_tree=null;
        CommonTree string_literal24_tree=null;
        CommonTree SEMICOLON25_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:100:2: ( 'device' IDENT 'is' ( attributeDecl )* 'begin' ( pinDecl )* 'end' SEMICOLON )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:100:4: 'device' IDENT 'is' ( attributeDecl )* 'begin' ( pinDecl )* 'end' SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal18=(Token)match(input,23,FOLLOW_23_in_deviceDecl178); 
            string_literal18_tree = (CommonTree)adaptor.create(string_literal18);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal18_tree, root_0);

            IDENT19=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl181); 
            IDENT19_tree = (CommonTree)adaptor.create(IDENT19);
            adaptor.addChild(root_0, IDENT19_tree);

            string_literal20=(Token)match(input,19,FOLLOW_19_in_deviceDecl183); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:101:3: ( attributeDecl )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==IDENT) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:101:3: attributeDecl
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_deviceDecl188);
            	    attributeDecl21=attributeDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeDecl21.getTree());

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            string_literal22=(Token)match(input,20,FOLLOW_20_in_deviceDecl193); 
            string_literal22_tree = (CommonTree)adaptor.create(string_literal22);
            adaptor.addChild(root_0, string_literal22_tree);

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:103:3: ( pinDecl )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=24 && LA5_0<=31)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:103:3: pinDecl
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl197);
            	    pinDecl23=pinDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinDecl23.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            string_literal24=(Token)match(input,21,FOLLOW_21_in_deviceDecl202); 
            SEMICOLON25=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_deviceDecl205); 

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:107:1: attributeDecl : IDENT EQUALS STRING_LITERAL SEMICOLON ;
    public final PhdlParser.attributeDecl_return attributeDecl() throws RecognitionException {
        PhdlParser.attributeDecl_return retval = new PhdlParser.attributeDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT26=null;
        Token EQUALS27=null;
        Token STRING_LITERAL28=null;
        Token SEMICOLON29=null;

        CommonTree IDENT26_tree=null;
        CommonTree EQUALS27_tree=null;
        CommonTree STRING_LITERAL28_tree=null;
        CommonTree SEMICOLON29_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:108:2: ( IDENT EQUALS STRING_LITERAL SEMICOLON )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:109:3: IDENT EQUALS STRING_LITERAL SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT26=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeDecl221); 
            IDENT26_tree = (CommonTree)adaptor.create(IDENT26);
            adaptor.addChild(root_0, IDENT26_tree);

            EQUALS27=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeDecl223); 
            EQUALS27_tree = (CommonTree)adaptor.create(EQUALS27);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS27_tree, root_0);

            STRING_LITERAL28=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_attributeDecl226); 
            STRING_LITERAL28_tree = (CommonTree)adaptor.create(STRING_LITERAL28);
            adaptor.addChild(root_0, STRING_LITERAL28_tree);

            SEMICOLON29=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeDecl228); 

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:112:1: pinDecl : type ( width )? IDENT EQUALS STRING_LITERAL SEMICOLON ;
    public final PhdlParser.pinDecl_return pinDecl() throws RecognitionException {
        PhdlParser.pinDecl_return retval = new PhdlParser.pinDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT32=null;
        Token EQUALS33=null;
        Token STRING_LITERAL34=null;
        Token SEMICOLON35=null;
        PhdlParser.type_return type30 = null;

        PhdlParser.width_return width31 = null;


        CommonTree IDENT32_tree=null;
        CommonTree EQUALS33_tree=null;
        CommonTree STRING_LITERAL34_tree=null;
        CommonTree SEMICOLON35_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:113:2: ( type ( width )? IDENT EQUALS STRING_LITERAL SEMICOLON )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:114:3: type ( width )? IDENT EQUALS STRING_LITERAL SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_type_in_pinDecl244);
            type30=type();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(type30.getTree(), root_0);
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:114:9: ( width )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==LBRACKET) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:114:9: width
                    {
                    pushFollow(FOLLOW_width_in_pinDecl247);
                    width31=width();

                    state._fsp--;

                    adaptor.addChild(root_0, width31.getTree());

                    }
                    break;

            }

            IDENT32=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinDecl250); 
            IDENT32_tree = (CommonTree)adaptor.create(IDENT32);
            adaptor.addChild(root_0, IDENT32_tree);

            EQUALS33=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinDecl252); 
            STRING_LITERAL34=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_pinDecl255); 
            STRING_LITERAL34_tree = (CommonTree)adaptor.create(STRING_LITERAL34);
            adaptor.addChild(root_0, STRING_LITERAL34_tree);

            SEMICOLON35=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinDecl257); 

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:117:1: type : ( 'pin' | 'in' | 'out' | 'inout' | 'passive' | 'supply' | 'power' | 'open' );
    public final PhdlParser.type_return type() throws RecognitionException {
        PhdlParser.type_return retval = new PhdlParser.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set36=null;

        CommonTree set36_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:118:2: ( 'pin' | 'in' | 'out' | 'inout' | 'passive' | 'supply' | 'power' | 'open' )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set36=(Token)input.LT(1);
            if ( (input.LA(1)>=24 && input.LA(1)<=31) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set36));
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:128:1: netDecl : 'net' ( width )? ( IDENT COMMA )* IDENT ( COLON ( IDENT COMMA )* IDENT )? SEMICOLON ;
    public final PhdlParser.netDecl_return netDecl() throws RecognitionException {
        PhdlParser.netDecl_return retval = new PhdlParser.netDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal37=null;
        Token IDENT39=null;
        Token COMMA40=null;
        Token IDENT41=null;
        Token COLON42=null;
        Token IDENT43=null;
        Token COMMA44=null;
        Token IDENT45=null;
        Token SEMICOLON46=null;
        PhdlParser.width_return width38 = null;


        CommonTree string_literal37_tree=null;
        CommonTree IDENT39_tree=null;
        CommonTree COMMA40_tree=null;
        CommonTree IDENT41_tree=null;
        CommonTree COLON42_tree=null;
        CommonTree IDENT43_tree=null;
        CommonTree COMMA44_tree=null;
        CommonTree IDENT45_tree=null;
        CommonTree SEMICOLON46_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:135:2: ( 'net' ( width )? ( IDENT COMMA )* IDENT ( COLON ( IDENT COMMA )* IDENT )? SEMICOLON )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:135:4: 'net' ( width )? ( IDENT COMMA )* IDENT ( COLON ( IDENT COMMA )* IDENT )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal37=(Token)match(input,32,FOLLOW_32_in_netDecl319); 
            string_literal37_tree = (CommonTree)adaptor.create(string_literal37);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal37_tree, root_0);

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:135:11: ( width )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==LBRACKET) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:135:12: width
                    {
                    pushFollow(FOLLOW_width_in_netDecl323);
                    width38=width();

                    state._fsp--;

                    adaptor.addChild(root_0, width38.getTree());

                    }
                    break;

            }

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:135:20: ( IDENT COMMA )*
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
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:135:21: IDENT COMMA
            	    {
            	    IDENT39=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl328); 
            	    IDENT39_tree = (CommonTree)adaptor.create(IDENT39);
            	    adaptor.addChild(root_0, IDENT39_tree);

            	    COMMA40=(Token)match(input,COMMA,FOLLOW_COMMA_in_netDecl330); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            IDENT41=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl335); 
            IDENT41_tree = (CommonTree)adaptor.create(IDENT41);
            adaptor.addChild(root_0, IDENT41_tree);

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:135:42: ( COLON ( IDENT COMMA )* IDENT )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==COLON) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:135:43: COLON ( IDENT COMMA )* IDENT
                    {
                    COLON42=(Token)match(input,COLON,FOLLOW_COLON_in_netDecl338); 
                    COLON42_tree = (CommonTree)adaptor.create(COLON42);
                    adaptor.addChild(root_0, COLON42_tree);

                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:135:49: ( IDENT COMMA )*
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
                    	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:135:50: IDENT COMMA
                    	    {
                    	    IDENT43=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl341); 
                    	    IDENT43_tree = (CommonTree)adaptor.create(IDENT43);
                    	    adaptor.addChild(root_0, IDENT43_tree);

                    	    COMMA44=(Token)match(input,COMMA,FOLLOW_COMMA_in_netDecl343); 

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    IDENT45=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl348); 
                    IDENT45_tree = (CommonTree)adaptor.create(IDENT45);
                    adaptor.addChild(root_0, IDENT45_tree);


                    }
                    break;

            }

            SEMICOLON46=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netDecl352); 

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

    public static class width_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "width"
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:138:1: width : '[' INT ':' INT ']' ;
    public final PhdlParser.width_return width() throws RecognitionException {
        PhdlParser.width_return retval = new PhdlParser.width_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal47=null;
        Token INT48=null;
        Token char_literal49=null;
        Token INT50=null;
        Token char_literal51=null;

        CommonTree char_literal47_tree=null;
        CommonTree INT48_tree=null;
        CommonTree char_literal49_tree=null;
        CommonTree INT50_tree=null;
        CommonTree char_literal51_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:141:2: ( '[' INT ':' INT ']' )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:141:4: '[' INT ':' INT ']'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal47=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_width367); 
            INT48=(Token)match(input,INT,FOLLOW_INT_in_width370); 
            INT48_tree = (CommonTree)adaptor.create(INT48);
            adaptor.addChild(root_0, INT48_tree);

            char_literal49=(Token)match(input,COLON,FOLLOW_COLON_in_width372); 
            INT50=(Token)match(input,INT,FOLLOW_INT_in_width375); 
            INT50_tree = (CommonTree)adaptor.create(INT50);
            adaptor.addChild(root_0, INT50_tree);

            char_literal51=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_width377); 

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
    // $ANTLR end "width"

    public static class slice_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "slice"
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:144:1: slice : '(' INT ')' ;
    public final PhdlParser.slice_return slice() throws RecognitionException {
        PhdlParser.slice_return retval = new PhdlParser.slice_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal52=null;
        Token INT53=null;
        Token char_literal54=null;

        CommonTree char_literal52_tree=null;
        CommonTree INT53_tree=null;
        CommonTree char_literal54_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:147:2: ( '(' INT ')' )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:147:4: '(' INT ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal52=(Token)match(input,33,FOLLOW_33_in_slice393); 
            INT53=(Token)match(input,INT,FOLLOW_INT_in_slice396); 
            INT53_tree = (CommonTree)adaptor.create(INT53);
            adaptor.addChild(root_0, INT53_tree);

            char_literal54=(Token)match(input,34,FOLLOW_34_in_slice398); 

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:150:1: instances : ( deviceInstance | subDesignInstance | netAssignment )* ;
    public final PhdlParser.instances_return instances() throws RecognitionException {
        PhdlParser.instances_return retval = new PhdlParser.instances_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        PhdlParser.deviceInstance_return deviceInstance55 = null;

        PhdlParser.subDesignInstance_return subDesignInstance56 = null;

        PhdlParser.netAssignment_return netAssignment57 = null;



        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:151:2: ( ( deviceInstance | subDesignInstance | netAssignment )* )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:151:4: ( deviceInstance | subDesignInstance | netAssignment )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:151:4: ( deviceInstance | subDesignInstance | netAssignment )*
            loop11:
            do {
                int alt11=4;
                switch ( input.LA(1) ) {
                case 35:
                    {
                    alt11=1;
                    }
                    break;
                case 36:
                    {
                    alt11=2;
                    }
                    break;
                case IDENT:
                    {
                    alt11=3;
                    }
                    break;

                }

                switch (alt11) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:151:5: deviceInstance
            	    {
            	    pushFollow(FOLLOW_deviceInstance_in_instances412);
            	    deviceInstance55=deviceInstance();

            	    state._fsp--;

            	    adaptor.addChild(root_0, deviceInstance55.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:151:22: subDesignInstance
            	    {
            	    pushFollow(FOLLOW_subDesignInstance_in_instances416);
            	    subDesignInstance56=subDesignInstance();

            	    state._fsp--;

            	    adaptor.addChild(root_0, subDesignInstance56.getTree());

            	    }
            	    break;
            	case 3 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:151:42: netAssignment
            	    {
            	    pushFollow(FOLLOW_netAssignment_in_instances420);
            	    netAssignment57=netAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netAssignment57.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:154:1: deviceInstance : 'inst' IDENT ':' IDENT ( width )? 'is' ( attributeAssignment )* 'begin' ( pinAssignment )* 'end' ';' ;
    public final PhdlParser.deviceInstance_return deviceInstance() throws RecognitionException {
        PhdlParser.deviceInstance_return retval = new PhdlParser.deviceInstance_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal58=null;
        Token IDENT59=null;
        Token char_literal60=null;
        Token IDENT61=null;
        Token string_literal63=null;
        Token string_literal65=null;
        Token string_literal67=null;
        Token char_literal68=null;
        PhdlParser.width_return width62 = null;

        PhdlParser.attributeAssignment_return attributeAssignment64 = null;

        PhdlParser.pinAssignment_return pinAssignment66 = null;


        CommonTree string_literal58_tree=null;
        CommonTree IDENT59_tree=null;
        CommonTree char_literal60_tree=null;
        CommonTree IDENT61_tree=null;
        CommonTree string_literal63_tree=null;
        CommonTree string_literal65_tree=null;
        CommonTree string_literal67_tree=null;
        CommonTree char_literal68_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:155:2: ( 'inst' IDENT ':' IDENT ( width )? 'is' ( attributeAssignment )* 'begin' ( pinAssignment )* 'end' ';' )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:155:4: 'inst' IDENT ':' IDENT ( width )? 'is' ( attributeAssignment )* 'begin' ( pinAssignment )* 'end' ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal58=(Token)match(input,35,FOLLOW_35_in_deviceInstance434); 
            string_literal58_tree = (CommonTree)adaptor.create(string_literal58);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal58_tree, root_0);

            IDENT59=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceInstance437); 
            IDENT59_tree = (CommonTree)adaptor.create(IDENT59);
            adaptor.addChild(root_0, IDENT59_tree);

            char_literal60=(Token)match(input,COLON,FOLLOW_COLON_in_deviceInstance439); 
            IDENT61=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceInstance442); 
            IDENT61_tree = (CommonTree)adaptor.create(IDENT61);
            adaptor.addChild(root_0, IDENT61_tree);

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:155:29: ( width )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==LBRACKET) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:155:30: width
                    {
                    pushFollow(FOLLOW_width_in_deviceInstance445);
                    width62=width();

                    state._fsp--;

                    adaptor.addChild(root_0, width62.getTree());

                    }
                    break;

            }

            string_literal63=(Token)match(input,19,FOLLOW_19_in_deviceInstance449); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:156:3: ( attributeAssignment )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==IDENT) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:156:3: attributeAssignment
            	    {
            	    pushFollow(FOLLOW_attributeAssignment_in_deviceInstance454);
            	    attributeAssignment64=attributeAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeAssignment64.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            string_literal65=(Token)match(input,20,FOLLOW_20_in_deviceInstance459); 
            string_literal65_tree = (CommonTree)adaptor.create(string_literal65);
            adaptor.addChild(root_0, string_literal65_tree);

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:158:3: ( pinAssignment )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==IDENT) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:158:3: pinAssignment
            	    {
            	    pushFollow(FOLLOW_pinAssignment_in_deviceInstance463);
            	    pinAssignment66=pinAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinAssignment66.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            string_literal67=(Token)match(input,21,FOLLOW_21_in_deviceInstance468); 
            char_literal68=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_deviceInstance471); 

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:162:1: subDesignInstance : 'sub' IDENT ':' IDENT ( width )? 'is' ( portAssignment )* 'end' ';' ;
    public final PhdlParser.subDesignInstance_return subDesignInstance() throws RecognitionException {
        PhdlParser.subDesignInstance_return retval = new PhdlParser.subDesignInstance_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal69=null;
        Token IDENT70=null;
        Token char_literal71=null;
        Token IDENT72=null;
        Token string_literal74=null;
        Token string_literal76=null;
        Token char_literal77=null;
        PhdlParser.width_return width73 = null;

        PhdlParser.portAssignment_return portAssignment75 = null;


        CommonTree string_literal69_tree=null;
        CommonTree IDENT70_tree=null;
        CommonTree char_literal71_tree=null;
        CommonTree IDENT72_tree=null;
        CommonTree string_literal74_tree=null;
        CommonTree string_literal76_tree=null;
        CommonTree char_literal77_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:163:2: ( 'sub' IDENT ':' IDENT ( width )? 'is' ( portAssignment )* 'end' ';' )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:163:4: 'sub' IDENT ':' IDENT ( width )? 'is' ( portAssignment )* 'end' ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal69=(Token)match(input,36,FOLLOW_36_in_subDesignInstance484); 
            string_literal69_tree = (CommonTree)adaptor.create(string_literal69);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal69_tree, root_0);

            IDENT70=(Token)match(input,IDENT,FOLLOW_IDENT_in_subDesignInstance487); 
            IDENT70_tree = (CommonTree)adaptor.create(IDENT70);
            adaptor.addChild(root_0, IDENT70_tree);

            char_literal71=(Token)match(input,COLON,FOLLOW_COLON_in_subDesignInstance489); 
            IDENT72=(Token)match(input,IDENT,FOLLOW_IDENT_in_subDesignInstance492); 
            IDENT72_tree = (CommonTree)adaptor.create(IDENT72);
            adaptor.addChild(root_0, IDENT72_tree);

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:163:28: ( width )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==LBRACKET) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:163:29: width
                    {
                    pushFollow(FOLLOW_width_in_subDesignInstance495);
                    width73=width();

                    state._fsp--;

                    adaptor.addChild(root_0, width73.getTree());

                    }
                    break;

            }

            string_literal74=(Token)match(input,19,FOLLOW_19_in_subDesignInstance499); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:164:3: ( portAssignment )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==IDENT) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:164:3: portAssignment
            	    {
            	    pushFollow(FOLLOW_portAssignment_in_subDesignInstance504);
            	    portAssignment75=portAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, portAssignment75.getTree());

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            string_literal76=(Token)match(input,21,FOLLOW_21_in_subDesignInstance509); 
            char_literal77=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_subDesignInstance512); 

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

    public static class attributeAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributeAssignment"
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:168:1: attributeAssignment : IDENT ( width | slice )? EQUALS STRING_LITERAL SEMICOLON ;
    public final PhdlParser.attributeAssignment_return attributeAssignment() throws RecognitionException {
        PhdlParser.attributeAssignment_return retval = new PhdlParser.attributeAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT78=null;
        Token EQUALS81=null;
        Token STRING_LITERAL82=null;
        Token SEMICOLON83=null;
        PhdlParser.width_return width79 = null;

        PhdlParser.slice_return slice80 = null;


        CommonTree IDENT78_tree=null;
        CommonTree EQUALS81_tree=null;
        CommonTree STRING_LITERAL82_tree=null;
        CommonTree SEMICOLON83_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:169:2: ( IDENT ( width | slice )? EQUALS STRING_LITERAL SEMICOLON )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:169:4: IDENT ( width | slice )? EQUALS STRING_LITERAL SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT78=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeAssignment525); 
            IDENT78_tree = (CommonTree)adaptor.create(IDENT78);
            adaptor.addChild(root_0, IDENT78_tree);

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:169:10: ( width | slice )?
            int alt17=3;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==LBRACKET) ) {
                alt17=1;
            }
            else if ( (LA17_0==33) ) {
                alt17=2;
            }
            switch (alt17) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:169:11: width
                    {
                    pushFollow(FOLLOW_width_in_attributeAssignment528);
                    width79=width();

                    state._fsp--;

                    adaptor.addChild(root_0, width79.getTree());

                    }
                    break;
                case 2 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:169:19: slice
                    {
                    pushFollow(FOLLOW_slice_in_attributeAssignment532);
                    slice80=slice();

                    state._fsp--;

                    adaptor.addChild(root_0, slice80.getTree());

                    }
                    break;

            }

            EQUALS81=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeAssignment536); 
            EQUALS81_tree = (CommonTree)adaptor.create(EQUALS81);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS81_tree, root_0);

            STRING_LITERAL82=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_attributeAssignment539); 
            STRING_LITERAL82_tree = (CommonTree)adaptor.create(STRING_LITERAL82);
            adaptor.addChild(root_0, STRING_LITERAL82_tree);

            SEMICOLON83=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeAssignment541); 

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:172:1: pinAssignment : IDENT ( width | slice )? ( COLON ( width | slice ) )? EQUALS concatenation SEMICOLON ;
    public final PhdlParser.pinAssignment_return pinAssignment() throws RecognitionException {
        PhdlParser.pinAssignment_return retval = new PhdlParser.pinAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT84=null;
        Token COLON87=null;
        Token EQUALS90=null;
        Token SEMICOLON92=null;
        PhdlParser.width_return width85 = null;

        PhdlParser.slice_return slice86 = null;

        PhdlParser.width_return width88 = null;

        PhdlParser.slice_return slice89 = null;

        PhdlParser.concatenation_return concatenation91 = null;


        CommonTree IDENT84_tree=null;
        CommonTree COLON87_tree=null;
        CommonTree EQUALS90_tree=null;
        CommonTree SEMICOLON92_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:173:2: ( IDENT ( width | slice )? ( COLON ( width | slice ) )? EQUALS concatenation SEMICOLON )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:173:4: IDENT ( width | slice )? ( COLON ( width | slice ) )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT84=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinAssignment554); 
            IDENT84_tree = (CommonTree)adaptor.create(IDENT84);
            adaptor.addChild(root_0, IDENT84_tree);

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:173:10: ( width | slice )?
            int alt18=3;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==LBRACKET) ) {
                alt18=1;
            }
            else if ( (LA18_0==33) ) {
                alt18=2;
            }
            switch (alt18) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:173:11: width
                    {
                    pushFollow(FOLLOW_width_in_pinAssignment557);
                    width85=width();

                    state._fsp--;

                    adaptor.addChild(root_0, width85.getTree());

                    }
                    break;
                case 2 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:173:19: slice
                    {
                    pushFollow(FOLLOW_slice_in_pinAssignment561);
                    slice86=slice();

                    state._fsp--;

                    adaptor.addChild(root_0, slice86.getTree());

                    }
                    break;

            }

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:173:27: ( COLON ( width | slice ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==COLON) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:173:28: COLON ( width | slice )
                    {
                    COLON87=(Token)match(input,COLON,FOLLOW_COLON_in_pinAssignment566); 
                    COLON87_tree = (CommonTree)adaptor.create(COLON87);
                    adaptor.addChild(root_0, COLON87_tree);

                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:173:34: ( width | slice )
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==LBRACKET) ) {
                        alt19=1;
                    }
                    else if ( (LA19_0==33) ) {
                        alt19=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 0, input);

                        throw nvae;
                    }
                    switch (alt19) {
                        case 1 :
                            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:173:35: width
                            {
                            pushFollow(FOLLOW_width_in_pinAssignment569);
                            width88=width();

                            state._fsp--;

                            adaptor.addChild(root_0, width88.getTree());

                            }
                            break;
                        case 2 :
                            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:173:43: slice
                            {
                            pushFollow(FOLLOW_slice_in_pinAssignment573);
                            slice89=slice();

                            state._fsp--;

                            adaptor.addChild(root_0, slice89.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }

            EQUALS90=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinAssignment578); 
            EQUALS90_tree = (CommonTree)adaptor.create(EQUALS90);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS90_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_pinAssignment581);
            concatenation91=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation91.getTree());
            SEMICOLON92=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinAssignment583); 

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:176:1: portAssignment : IDENT ( width | slice )? ( COLON ( width | slice ) )? EQUALS concatenation SEMICOLON ;
    public final PhdlParser.portAssignment_return portAssignment() throws RecognitionException {
        PhdlParser.portAssignment_return retval = new PhdlParser.portAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT93=null;
        Token COLON96=null;
        Token EQUALS99=null;
        Token SEMICOLON101=null;
        PhdlParser.width_return width94 = null;

        PhdlParser.slice_return slice95 = null;

        PhdlParser.width_return width97 = null;

        PhdlParser.slice_return slice98 = null;

        PhdlParser.concatenation_return concatenation100 = null;


        CommonTree IDENT93_tree=null;
        CommonTree COLON96_tree=null;
        CommonTree EQUALS99_tree=null;
        CommonTree SEMICOLON101_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:177:2: ( IDENT ( width | slice )? ( COLON ( width | slice ) )? EQUALS concatenation SEMICOLON )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:177:4: IDENT ( width | slice )? ( COLON ( width | slice ) )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT93=(Token)match(input,IDENT,FOLLOW_IDENT_in_portAssignment596); 
            IDENT93_tree = (CommonTree)adaptor.create(IDENT93);
            adaptor.addChild(root_0, IDENT93_tree);

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:177:10: ( width | slice )?
            int alt21=3;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==LBRACKET) ) {
                alt21=1;
            }
            else if ( (LA21_0==33) ) {
                alt21=2;
            }
            switch (alt21) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:177:11: width
                    {
                    pushFollow(FOLLOW_width_in_portAssignment599);
                    width94=width();

                    state._fsp--;

                    adaptor.addChild(root_0, width94.getTree());

                    }
                    break;
                case 2 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:177:19: slice
                    {
                    pushFollow(FOLLOW_slice_in_portAssignment603);
                    slice95=slice();

                    state._fsp--;

                    adaptor.addChild(root_0, slice95.getTree());

                    }
                    break;

            }

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:177:27: ( COLON ( width | slice ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==COLON) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:177:28: COLON ( width | slice )
                    {
                    COLON96=(Token)match(input,COLON,FOLLOW_COLON_in_portAssignment608); 
                    COLON96_tree = (CommonTree)adaptor.create(COLON96);
                    adaptor.addChild(root_0, COLON96_tree);

                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:177:34: ( width | slice )
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==LBRACKET) ) {
                        alt22=1;
                    }
                    else if ( (LA22_0==33) ) {
                        alt22=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 0, input);

                        throw nvae;
                    }
                    switch (alt22) {
                        case 1 :
                            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:177:35: width
                            {
                            pushFollow(FOLLOW_width_in_portAssignment611);
                            width97=width();

                            state._fsp--;

                            adaptor.addChild(root_0, width97.getTree());

                            }
                            break;
                        case 2 :
                            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:177:43: slice
                            {
                            pushFollow(FOLLOW_slice_in_portAssignment615);
                            slice98=slice();

                            state._fsp--;

                            adaptor.addChild(root_0, slice98.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }

            EQUALS99=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_portAssignment620); 
            EQUALS99_tree = (CommonTree)adaptor.create(EQUALS99);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS99_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_portAssignment623);
            concatenation100=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation100.getTree());
            SEMICOLON101=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_portAssignment625); 

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:180:1: netAssignment : IDENT ( width | slice )? EQUALS concatenation SEMICOLON ;
    public final PhdlParser.netAssignment_return netAssignment() throws RecognitionException {
        PhdlParser.netAssignment_return retval = new PhdlParser.netAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT102=null;
        Token EQUALS105=null;
        Token SEMICOLON107=null;
        PhdlParser.width_return width103 = null;

        PhdlParser.slice_return slice104 = null;

        PhdlParser.concatenation_return concatenation106 = null;


        CommonTree IDENT102_tree=null;
        CommonTree EQUALS105_tree=null;
        CommonTree SEMICOLON107_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:181:2: ( IDENT ( width | slice )? EQUALS concatenation SEMICOLON )
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:181:4: IDENT ( width | slice )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT102=(Token)match(input,IDENT,FOLLOW_IDENT_in_netAssignment638); 
            IDENT102_tree = (CommonTree)adaptor.create(IDENT102);
            adaptor.addChild(root_0, IDENT102_tree);

            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:181:10: ( width | slice )?
            int alt24=3;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==LBRACKET) ) {
                alt24=1;
            }
            else if ( (LA24_0==33) ) {
                alt24=2;
            }
            switch (alt24) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:181:11: width
                    {
                    pushFollow(FOLLOW_width_in_netAssignment641);
                    width103=width();

                    state._fsp--;

                    adaptor.addChild(root_0, width103.getTree());

                    }
                    break;
                case 2 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:181:19: slice
                    {
                    pushFollow(FOLLOW_slice_in_netAssignment645);
                    slice104=slice();

                    state._fsp--;

                    adaptor.addChild(root_0, slice104.getTree());

                    }
                    break;

            }

            EQUALS105=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_netAssignment649); 
            EQUALS105_tree = (CommonTree)adaptor.create(EQUALS105);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS105_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_netAssignment652);
            concatenation106=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation106.getTree());
            SEMICOLON107=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netAssignment654); 

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:184:1: concatenation : ( ( ( IDENT ( width | slice )? ) ( '&' IDENT ( width | slice )? )* ) | 'open' );
    public final PhdlParser.concatenation_return concatenation() throws RecognitionException {
        PhdlParser.concatenation_return retval = new PhdlParser.concatenation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT108=null;
        Token char_literal111=null;
        Token IDENT112=null;
        Token string_literal115=null;
        PhdlParser.width_return width109 = null;

        PhdlParser.slice_return slice110 = null;

        PhdlParser.width_return width113 = null;

        PhdlParser.slice_return slice114 = null;


        CommonTree IDENT108_tree=null;
        CommonTree char_literal111_tree=null;
        CommonTree IDENT112_tree=null;
        CommonTree string_literal115_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:185:2: ( ( ( IDENT ( width | slice )? ) ( '&' IDENT ( width | slice )? )* ) | 'open' )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==IDENT) ) {
                alt28=1;
            }
            else if ( (LA28_0==31) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:185:4: ( ( IDENT ( width | slice )? ) ( '&' IDENT ( width | slice )? )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:185:4: ( ( IDENT ( width | slice )? ) ( '&' IDENT ( width | slice )? )* )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:185:5: ( IDENT ( width | slice )? ) ( '&' IDENT ( width | slice )? )*
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:185:5: ( IDENT ( width | slice )? )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:185:6: IDENT ( width | slice )?
                    {
                    IDENT108=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation669); 
                    IDENT108_tree = (CommonTree)adaptor.create(IDENT108);
                    adaptor.addChild(root_0, IDENT108_tree);

                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:185:12: ( width | slice )?
                    int alt25=3;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==LBRACKET) ) {
                        alt25=1;
                    }
                    else if ( (LA25_0==33) ) {
                        alt25=2;
                    }
                    switch (alt25) {
                        case 1 :
                            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:185:13: width
                            {
                            pushFollow(FOLLOW_width_in_concatenation672);
                            width109=width();

                            state._fsp--;

                            adaptor.addChild(root_0, width109.getTree());

                            }
                            break;
                        case 2 :
                            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:185:21: slice
                            {
                            pushFollow(FOLLOW_slice_in_concatenation676);
                            slice110=slice();

                            state._fsp--;

                            adaptor.addChild(root_0, slice110.getTree());

                            }
                            break;

                    }


                    }

                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:185:30: ( '&' IDENT ( width | slice )? )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==37) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:185:31: '&' IDENT ( width | slice )?
                    	    {
                    	    char_literal111=(Token)match(input,37,FOLLOW_37_in_concatenation682); 
                    	    IDENT112=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation685); 
                    	    IDENT112_tree = (CommonTree)adaptor.create(IDENT112);
                    	    adaptor.addChild(root_0, IDENT112_tree);

                    	    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:185:42: ( width | slice )?
                    	    int alt26=3;
                    	    int LA26_0 = input.LA(1);

                    	    if ( (LA26_0==LBRACKET) ) {
                    	        alt26=1;
                    	    }
                    	    else if ( (LA26_0==33) ) {
                    	        alt26=2;
                    	    }
                    	    switch (alt26) {
                    	        case 1 :
                    	            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:185:43: width
                    	            {
                    	            pushFollow(FOLLOW_width_in_concatenation688);
                    	            width113=width();

                    	            state._fsp--;

                    	            adaptor.addChild(root_0, width113.getTree());

                    	            }
                    	            break;
                    	        case 2 :
                    	            // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:185:51: slice
                    	            {
                    	            pushFollow(FOLLOW_slice_in_concatenation692);
                    	            slice114=slice();

                    	            state._fsp--;

                    	            adaptor.addChild(root_0, slice114.getTree());

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\Phdl.g:185:65: 'open'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal115=(Token)match(input,31,FOLLOW_31_in_concatenation702); 

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


 

    public static final BitSet FOLLOW_designDecl_in_sourceText68 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_EOF_in_sourceText71 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_designDecl88 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_designDecl91 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_designDecl93 = new BitSet(new long[]{0x0000000100D00000L});
    public static final BitSet FOLLOW_portDecl_in_designDecl106 = new BitSet(new long[]{0x0000000100D00000L});
    public static final BitSet FOLLOW_deviceDecl_in_designDecl110 = new BitSet(new long[]{0x0000000100D00000L});
    public static final BitSet FOLLOW_netDecl_in_designDecl114 = new BitSet(new long[]{0x0000000100D00000L});
    public static final BitSet FOLLOW_20_in_designDecl123 = new BitSet(new long[]{0x0000001800200010L});
    public static final BitSet FOLLOW_instances_in_designDecl133 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_designDecl137 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_designDecl140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_portDecl152 = new BitSet(new long[]{0x00000000FF000000L});
    public static final BitSet FOLLOW_type_in_portDecl155 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_width_in_portDecl158 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_portDecl161 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_portDecl163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_deviceDecl178 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl181 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_deviceDecl183 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_attributeDecl_in_deviceDecl188 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_20_in_deviceDecl193 = new BitSet(new long[]{0x00000000FF200000L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl197 = new BitSet(new long[]{0x00000000FF200000L});
    public static final BitSet FOLLOW_21_in_deviceDecl202 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_deviceDecl205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_attributeDecl221 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_attributeDecl223 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_attributeDecl226 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeDecl228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_pinDecl244 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_width_in_pinDecl247 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl250 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_pinDecl252 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_pinDecl255 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinDecl257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_netDecl319 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_width_in_netDecl323 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl328 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_COMMA_in_netDecl330 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl335 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_COLON_in_netDecl338 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl341 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_COMMA_in_netDecl343 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl348 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_netDecl352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_width367 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_width370 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COLON_in_width372 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_width375 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACKET_in_width377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_slice393 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_slice396 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_slice398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deviceInstance_in_instances412 = new BitSet(new long[]{0x0000001800000012L});
    public static final BitSet FOLLOW_subDesignInstance_in_instances416 = new BitSet(new long[]{0x0000001800000012L});
    public static final BitSet FOLLOW_netAssignment_in_instances420 = new BitSet(new long[]{0x0000001800000012L});
    public static final BitSet FOLLOW_35_in_deviceInstance434 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceInstance437 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COLON_in_deviceInstance439 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceInstance442 = new BitSet(new long[]{0x0000000000082000L});
    public static final BitSet FOLLOW_width_in_deviceInstance445 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_deviceInstance449 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_attributeAssignment_in_deviceInstance454 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_20_in_deviceInstance459 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_pinAssignment_in_deviceInstance463 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_21_in_deviceInstance468 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_deviceInstance471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_subDesignInstance484 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_subDesignInstance487 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COLON_in_subDesignInstance489 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_subDesignInstance492 = new BitSet(new long[]{0x0000000000082000L});
    public static final BitSet FOLLOW_width_in_subDesignInstance495 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_subDesignInstance499 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_portAssignment_in_subDesignInstance504 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_21_in_subDesignInstance509 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_subDesignInstance512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_attributeAssignment525 = new BitSet(new long[]{0x0000000200002040L});
    public static final BitSet FOLLOW_width_in_attributeAssignment528 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_slice_in_attributeAssignment532 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_attributeAssignment536 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_attributeAssignment539 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeAssignment541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_pinAssignment554 = new BitSet(new long[]{0x0000000200002240L});
    public static final BitSet FOLLOW_width_in_pinAssignment557 = new BitSet(new long[]{0x0000000000000240L});
    public static final BitSet FOLLOW_slice_in_pinAssignment561 = new BitSet(new long[]{0x0000000000000240L});
    public static final BitSet FOLLOW_COLON_in_pinAssignment566 = new BitSet(new long[]{0x0000000200002000L});
    public static final BitSet FOLLOW_width_in_pinAssignment569 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_slice_in_pinAssignment573 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssignment578 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_concatenation_in_pinAssignment581 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinAssignment583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_portAssignment596 = new BitSet(new long[]{0x0000000200002240L});
    public static final BitSet FOLLOW_width_in_portAssignment599 = new BitSet(new long[]{0x0000000000000240L});
    public static final BitSet FOLLOW_slice_in_portAssignment603 = new BitSet(new long[]{0x0000000000000240L});
    public static final BitSet FOLLOW_COLON_in_portAssignment608 = new BitSet(new long[]{0x0000000200002000L});
    public static final BitSet FOLLOW_width_in_portAssignment611 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_slice_in_portAssignment615 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_portAssignment620 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_concatenation_in_portAssignment623 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_portAssignment625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_netAssignment638 = new BitSet(new long[]{0x0000000200002040L});
    public static final BitSet FOLLOW_width_in_netAssignment641 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_slice_in_netAssignment645 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_netAssignment649 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_concatenation_in_netAssignment652 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_netAssignment654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_concatenation669 = new BitSet(new long[]{0x0000002200002002L});
    public static final BitSet FOLLOW_width_in_concatenation672 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_slice_in_concatenation676 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_concatenation682 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation685 = new BitSet(new long[]{0x0000002200002002L});
    public static final BitSet FOLLOW_width_in_concatenation688 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_slice_in_concatenation692 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_31_in_concatenation702 = new BitSet(new long[]{0x0000000000000002L});

}