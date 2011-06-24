// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g 2011-06-24 14:06:21

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "SEMICOLON", "EQUALS", "STRING_LITERAL", "NUMBER_LIST", "COMMA", "COLON", "INT", "CHAR", "DIGIT", "LBRACKET", "RBRACKET", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "'design'", "'is'", "'begin'", "'end'", "'port'", "'device'", "'pin'", "'in'", "'out'", "'inout'", "'passive'", "'supply'", "'power'", "'open'", "'net'", "'('", "')'", "'inst'", "'sub'", "'&'"
    };
    public static final int EOF=-1;
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
    public static final int T__38=38;
    public static final int IDENT=4;
    public static final int SEMICOLON=5;
    public static final int EQUALS=6;
    public static final int STRING_LITERAL=7;
    public static final int NUMBER_LIST=8;
    public static final int COMMA=9;
    public static final int COLON=10;
    public static final int INT=11;
    public static final int CHAR=12;
    public static final int DIGIT=13;
    public static final int LBRACKET=14;
    public static final int RBRACKET=15;
    public static final int WHITESPACE=16;
    public static final int LINE_COMMENT=17;
    public static final int MULTILINE_COMMENT=18;

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

                if ( (LA1_0==19) ) {
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

            string_literal3=(Token)match(input,19,FOLLOW_19_in_designDecl88); 
            string_literal3_tree = (CommonTree)adaptor.create(string_literal3);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal3_tree, root_0);

            IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_designDecl91); 
            IDENT4_tree = (CommonTree)adaptor.create(IDENT4);
            adaptor.addChild(root_0, IDENT4_tree);

            string_literal5=(Token)match(input,20,FOLLOW_20_in_designDecl93); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:81:3: ( portDecl | deviceDecl | netDecl )*
            loop2:
            do {
                int alt2=4;
                switch ( input.LA(1) ) {
                case 23:
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

            string_literal9=(Token)match(input,21,FOLLOW_21_in_designDecl123); 
            string_literal9_tree = (CommonTree)adaptor.create(string_literal9);
            adaptor.addChild(root_0, string_literal9_tree);

            pushFollow(FOLLOW_instances_in_designDecl133);
            instances10=instances();

            state._fsp--;

            adaptor.addChild(root_0, instances10.getTree());
            string_literal11=(Token)match(input,22,FOLLOW_22_in_designDecl137); 
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:90:1: portDecl : 'port' type ( width )? IDENT SEMICOLON ;
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:91:2: ( 'port' type ( width )? IDENT SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:91:4: 'port' type ( width )? IDENT SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal13=(Token)match(input,23,FOLLOW_23_in_portDecl152); 
            pushFollow(FOLLOW_type_in_portDecl155);
            type14=type();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(type14.getTree(), root_0);
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:91:18: ( width )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==LBRACKET) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:91:18: width
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:94:1: deviceDecl : 'device' IDENT 'is' ( attributeDecl )* 'begin' ( pinDecl )* 'end' SEMICOLON ;
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:100:2: ( 'device' IDENT 'is' ( attributeDecl )* 'begin' ( pinDecl )* 'end' SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:100:4: 'device' IDENT 'is' ( attributeDecl )* 'begin' ( pinDecl )* 'end' SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal18=(Token)match(input,24,FOLLOW_24_in_deviceDecl178); 
            string_literal18_tree = (CommonTree)adaptor.create(string_literal18);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal18_tree, root_0);

            IDENT19=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl181); 
            IDENT19_tree = (CommonTree)adaptor.create(IDENT19);
            adaptor.addChild(root_0, IDENT19_tree);

            string_literal20=(Token)match(input,20,FOLLOW_20_in_deviceDecl183); 
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

            string_literal22=(Token)match(input,21,FOLLOW_21_in_deviceDecl193); 
            string_literal22_tree = (CommonTree)adaptor.create(string_literal22);
            adaptor.addChild(root_0, string_literal22_tree);

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

            string_literal24=(Token)match(input,22,FOLLOW_22_in_deviceDecl202); 
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:107:1: attributeDecl : IDENT EQUALS STRING_LITERAL SEMICOLON ;
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:108:2: ( IDENT EQUALS STRING_LITERAL SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:109:3: IDENT EQUALS STRING_LITERAL SEMICOLON
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:112:1: pinDecl : type ( width )? IDENT EQUALS NUMBER_LIST SEMICOLON ;
    public final PhdlParser.pinDecl_return pinDecl() throws RecognitionException {
        PhdlParser.pinDecl_return retval = new PhdlParser.pinDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT32=null;
        Token EQUALS33=null;
        Token NUMBER_LIST34=null;
        Token SEMICOLON35=null;
        PhdlParser.type_return type30 = null;

        PhdlParser.width_return width31 = null;


        CommonTree IDENT32_tree=null;
        CommonTree EQUALS33_tree=null;
        CommonTree NUMBER_LIST34_tree=null;
        CommonTree SEMICOLON35_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:113:2: ( type ( width )? IDENT EQUALS NUMBER_LIST SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:114:3: type ( width )? IDENT EQUALS NUMBER_LIST SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_type_in_pinDecl244);
            type30=type();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(type30.getTree(), root_0);
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:114:9: ( width )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==LBRACKET) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:114:9: width
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
            NUMBER_LIST34=(Token)match(input,NUMBER_LIST,FOLLOW_NUMBER_LIST_in_pinDecl255); 
            NUMBER_LIST34_tree = (CommonTree)adaptor.create(NUMBER_LIST34);
            adaptor.addChild(root_0, NUMBER_LIST34_tree);

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:117:1: type : ( 'pin' | 'in' | 'out' | 'inout' | 'passive' | 'supply' | 'power' | 'open' );
    public final PhdlParser.type_return type() throws RecognitionException {
        PhdlParser.type_return retval = new PhdlParser.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set36=null;

        CommonTree set36_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:118:2: ( 'pin' | 'in' | 'out' | 'inout' | 'passive' | 'supply' | 'power' | 'open' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set36=(Token)input.LT(1);
            if ( (input.LA(1)>=25 && input.LA(1)<=32) ) {
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:128:1: netDecl : 'net' ( width )? ( IDENT COMMA )* IDENT ( COLON ( IDENT COMMA )* IDENT )? SEMICOLON ;
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:135:2: ( 'net' ( width )? ( IDENT COMMA )* IDENT ( COLON ( IDENT COMMA )* IDENT )? SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:135:4: 'net' ( width )? ( IDENT COMMA )* IDENT ( COLON ( IDENT COMMA )* IDENT )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal37=(Token)match(input,33,FOLLOW_33_in_netDecl319); 
            string_literal37_tree = (CommonTree)adaptor.create(string_literal37);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal37_tree, root_0);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:135:11: ( width )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==LBRACKET) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:135:12: width
                    {
                    pushFollow(FOLLOW_width_in_netDecl323);
                    width38=width();

                    state._fsp--;

                    adaptor.addChild(root_0, width38.getTree());

                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:135:20: ( IDENT COMMA )*
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:135:21: IDENT COMMA
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

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:135:42: ( COLON ( IDENT COMMA )* IDENT )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==COLON) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:135:43: COLON ( IDENT COMMA )* IDENT
                    {
                    COLON42=(Token)match(input,COLON,FOLLOW_COLON_in_netDecl338); 
                    COLON42_tree = (CommonTree)adaptor.create(COLON42);
                    adaptor.addChild(root_0, COLON42_tree);

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:135:49: ( IDENT COMMA )*
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
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:135:50: IDENT COMMA
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:138:1: width : '[' INT ':' INT ']' ;
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:141:2: ( '[' INT ':' INT ']' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:141:4: '[' INT ':' INT ']'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal47=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_width367); 
            INT48=(Token)match(input,INT,FOLLOW_INT_in_width370); 
            INT48_tree = (CommonTree)adaptor.create(INT48);
            adaptor.addChild(root_0, INT48_tree);

            char_literal49=(Token)match(input,COLON,FOLLOW_COLON_in_width372); 
            char_literal49_tree = (CommonTree)adaptor.create(char_literal49);
            adaptor.addChild(root_0, char_literal49_tree);

            INT50=(Token)match(input,INT,FOLLOW_INT_in_width374); 
            INT50_tree = (CommonTree)adaptor.create(INT50);
            adaptor.addChild(root_0, INT50_tree);

            char_literal51=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_width376); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:144:1: slice : '(' INT ')' ;
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:147:2: ( '(' INT ')' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:147:4: '(' INT ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal52=(Token)match(input,34,FOLLOW_34_in_slice392); 
            INT53=(Token)match(input,INT,FOLLOW_INT_in_slice395); 
            INT53_tree = (CommonTree)adaptor.create(INT53);
            adaptor.addChild(root_0, INT53_tree);

            char_literal54=(Token)match(input,35,FOLLOW_35_in_slice397); 

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

    public static class specifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "specifier"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:150:1: specifier : ( width | slice | NUMBER_LIST ) ;
    public final PhdlParser.specifier_return specifier() throws RecognitionException {
        PhdlParser.specifier_return retval = new PhdlParser.specifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NUMBER_LIST57=null;
        PhdlParser.width_return width55 = null;

        PhdlParser.slice_return slice56 = null;


        CommonTree NUMBER_LIST57_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:151:2: ( ( width | slice | NUMBER_LIST ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:151:4: ( width | slice | NUMBER_LIST )
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:151:4: ( width | slice | NUMBER_LIST )
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:151:5: width
                    {
                    pushFollow(FOLLOW_width_in_specifier411);
                    width55=width();

                    state._fsp--;

                    adaptor.addChild(root_0, width55.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:151:13: slice
                    {
                    pushFollow(FOLLOW_slice_in_specifier415);
                    slice56=slice();

                    state._fsp--;

                    adaptor.addChild(root_0, slice56.getTree());

                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:151:21: NUMBER_LIST
                    {
                    NUMBER_LIST57=(Token)match(input,NUMBER_LIST,FOLLOW_NUMBER_LIST_in_specifier419); 
                    NUMBER_LIST57_tree = (CommonTree)adaptor.create(NUMBER_LIST57);
                    adaptor.addChild(root_0, NUMBER_LIST57_tree);


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
    // $ANTLR end "specifier"

    public static class instances_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "instances"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:154:1: instances : ( deviceInstance | subDesignInstance | netAssignment )* ;
    public final PhdlParser.instances_return instances() throws RecognitionException {
        PhdlParser.instances_return retval = new PhdlParser.instances_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        PhdlParser.deviceInstance_return deviceInstance58 = null;

        PhdlParser.subDesignInstance_return subDesignInstance59 = null;

        PhdlParser.netAssignment_return netAssignment60 = null;



        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:155:2: ( ( deviceInstance | subDesignInstance | netAssignment )* )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:155:4: ( deviceInstance | subDesignInstance | netAssignment )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:155:4: ( deviceInstance | subDesignInstance | netAssignment )*
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:155:5: deviceInstance
            	    {
            	    pushFollow(FOLLOW_deviceInstance_in_instances433);
            	    deviceInstance58=deviceInstance();

            	    state._fsp--;

            	    adaptor.addChild(root_0, deviceInstance58.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:155:22: subDesignInstance
            	    {
            	    pushFollow(FOLLOW_subDesignInstance_in_instances437);
            	    subDesignInstance59=subDesignInstance();

            	    state._fsp--;

            	    adaptor.addChild(root_0, subDesignInstance59.getTree());

            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:155:42: netAssignment
            	    {
            	    pushFollow(FOLLOW_netAssignment_in_instances441);
            	    netAssignment60=netAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netAssignment60.getTree());

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:158:1: deviceInstance : 'inst' IDENT ':' IDENT ( width )? 'is' ( attributeAssignment )* 'begin' ( pinAssignment )* 'end' ';' ;
    public final PhdlParser.deviceInstance_return deviceInstance() throws RecognitionException {
        PhdlParser.deviceInstance_return retval = new PhdlParser.deviceInstance_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal61=null;
        Token IDENT62=null;
        Token char_literal63=null;
        Token IDENT64=null;
        Token string_literal66=null;
        Token string_literal68=null;
        Token string_literal70=null;
        Token char_literal71=null;
        PhdlParser.width_return width65 = null;

        PhdlParser.attributeAssignment_return attributeAssignment67 = null;

        PhdlParser.pinAssignment_return pinAssignment69 = null;


        CommonTree string_literal61_tree=null;
        CommonTree IDENT62_tree=null;
        CommonTree char_literal63_tree=null;
        CommonTree IDENT64_tree=null;
        CommonTree string_literal66_tree=null;
        CommonTree string_literal68_tree=null;
        CommonTree string_literal70_tree=null;
        CommonTree char_literal71_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:159:2: ( 'inst' IDENT ':' IDENT ( width )? 'is' ( attributeAssignment )* 'begin' ( pinAssignment )* 'end' ';' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:159:4: 'inst' IDENT ':' IDENT ( width )? 'is' ( attributeAssignment )* 'begin' ( pinAssignment )* 'end' ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal61=(Token)match(input,36,FOLLOW_36_in_deviceInstance455); 
            string_literal61_tree = (CommonTree)adaptor.create(string_literal61);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal61_tree, root_0);

            IDENT62=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceInstance458); 
            IDENT62_tree = (CommonTree)adaptor.create(IDENT62);
            adaptor.addChild(root_0, IDENT62_tree);

            char_literal63=(Token)match(input,COLON,FOLLOW_COLON_in_deviceInstance460); 
            IDENT64=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceInstance463); 
            IDENT64_tree = (CommonTree)adaptor.create(IDENT64);
            adaptor.addChild(root_0, IDENT64_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:159:29: ( width )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==LBRACKET) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:159:30: width
                    {
                    pushFollow(FOLLOW_width_in_deviceInstance466);
                    width65=width();

                    state._fsp--;

                    adaptor.addChild(root_0, width65.getTree());

                    }
                    break;

            }

            string_literal66=(Token)match(input,20,FOLLOW_20_in_deviceInstance470); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:160:3: ( attributeAssignment )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==IDENT) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:160:3: attributeAssignment
            	    {
            	    pushFollow(FOLLOW_attributeAssignment_in_deviceInstance475);
            	    attributeAssignment67=attributeAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeAssignment67.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            string_literal68=(Token)match(input,21,FOLLOW_21_in_deviceInstance480); 
            string_literal68_tree = (CommonTree)adaptor.create(string_literal68);
            adaptor.addChild(root_0, string_literal68_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:162:3: ( pinAssignment )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==IDENT) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:162:3: pinAssignment
            	    {
            	    pushFollow(FOLLOW_pinAssignment_in_deviceInstance484);
            	    pinAssignment69=pinAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinAssignment69.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            string_literal70=(Token)match(input,22,FOLLOW_22_in_deviceInstance489); 
            char_literal71=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_deviceInstance492); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:166:1: subDesignInstance : 'sub' IDENT ':' IDENT ( width )? 'is' ( portAssignment )* 'end' ';' ;
    public final PhdlParser.subDesignInstance_return subDesignInstance() throws RecognitionException {
        PhdlParser.subDesignInstance_return retval = new PhdlParser.subDesignInstance_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal72=null;
        Token IDENT73=null;
        Token char_literal74=null;
        Token IDENT75=null;
        Token string_literal77=null;
        Token string_literal79=null;
        Token char_literal80=null;
        PhdlParser.width_return width76 = null;

        PhdlParser.portAssignment_return portAssignment78 = null;


        CommonTree string_literal72_tree=null;
        CommonTree IDENT73_tree=null;
        CommonTree char_literal74_tree=null;
        CommonTree IDENT75_tree=null;
        CommonTree string_literal77_tree=null;
        CommonTree string_literal79_tree=null;
        CommonTree char_literal80_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:167:2: ( 'sub' IDENT ':' IDENT ( width )? 'is' ( portAssignment )* 'end' ';' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:167:4: 'sub' IDENT ':' IDENT ( width )? 'is' ( portAssignment )* 'end' ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal72=(Token)match(input,37,FOLLOW_37_in_subDesignInstance505); 
            string_literal72_tree = (CommonTree)adaptor.create(string_literal72);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal72_tree, root_0);

            IDENT73=(Token)match(input,IDENT,FOLLOW_IDENT_in_subDesignInstance508); 
            IDENT73_tree = (CommonTree)adaptor.create(IDENT73);
            adaptor.addChild(root_0, IDENT73_tree);

            char_literal74=(Token)match(input,COLON,FOLLOW_COLON_in_subDesignInstance510); 
            IDENT75=(Token)match(input,IDENT,FOLLOW_IDENT_in_subDesignInstance513); 
            IDENT75_tree = (CommonTree)adaptor.create(IDENT75);
            adaptor.addChild(root_0, IDENT75_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:167:28: ( width )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==LBRACKET) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:167:29: width
                    {
                    pushFollow(FOLLOW_width_in_subDesignInstance516);
                    width76=width();

                    state._fsp--;

                    adaptor.addChild(root_0, width76.getTree());

                    }
                    break;

            }

            string_literal77=(Token)match(input,20,FOLLOW_20_in_subDesignInstance520); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:168:3: ( portAssignment )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==IDENT) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:168:3: portAssignment
            	    {
            	    pushFollow(FOLLOW_portAssignment_in_subDesignInstance525);
            	    portAssignment78=portAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, portAssignment78.getTree());

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            string_literal79=(Token)match(input,22,FOLLOW_22_in_subDesignInstance530); 
            char_literal80=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_subDesignInstance533); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:172:1: attributeAssignment : IDENT ( specifier )? EQUALS STRING_LITERAL SEMICOLON ;
    public final PhdlParser.attributeAssignment_return attributeAssignment() throws RecognitionException {
        PhdlParser.attributeAssignment_return retval = new PhdlParser.attributeAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT81=null;
        Token EQUALS83=null;
        Token STRING_LITERAL84=null;
        Token SEMICOLON85=null;
        PhdlParser.specifier_return specifier82 = null;


        CommonTree IDENT81_tree=null;
        CommonTree EQUALS83_tree=null;
        CommonTree STRING_LITERAL84_tree=null;
        CommonTree SEMICOLON85_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:173:2: ( IDENT ( specifier )? EQUALS STRING_LITERAL SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:173:4: IDENT ( specifier )? EQUALS STRING_LITERAL SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT81=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeAssignment546); 
            IDENT81_tree = (CommonTree)adaptor.create(IDENT81);
            adaptor.addChild(root_0, IDENT81_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:173:10: ( specifier )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==NUMBER_LIST||LA18_0==LBRACKET||LA18_0==34) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:173:10: specifier
                    {
                    pushFollow(FOLLOW_specifier_in_attributeAssignment548);
                    specifier82=specifier();

                    state._fsp--;

                    adaptor.addChild(root_0, specifier82.getTree());

                    }
                    break;

            }

            EQUALS83=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeAssignment551); 
            EQUALS83_tree = (CommonTree)adaptor.create(EQUALS83);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS83_tree, root_0);

            STRING_LITERAL84=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_attributeAssignment554); 
            STRING_LITERAL84_tree = (CommonTree)adaptor.create(STRING_LITERAL84);
            adaptor.addChild(root_0, STRING_LITERAL84_tree);

            SEMICOLON85=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeAssignment556); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:176:1: pinAssignment : IDENT ( specifier ( specifier )? )? EQUALS concatenation SEMICOLON ;
    public final PhdlParser.pinAssignment_return pinAssignment() throws RecognitionException {
        PhdlParser.pinAssignment_return retval = new PhdlParser.pinAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT86=null;
        Token EQUALS89=null;
        Token SEMICOLON91=null;
        PhdlParser.specifier_return specifier87 = null;

        PhdlParser.specifier_return specifier88 = null;

        PhdlParser.concatenation_return concatenation90 = null;


        CommonTree IDENT86_tree=null;
        CommonTree EQUALS89_tree=null;
        CommonTree SEMICOLON91_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:177:2: ( IDENT ( specifier ( specifier )? )? EQUALS concatenation SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:177:4: IDENT ( specifier ( specifier )? )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT86=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinAssignment569); 
            IDENT86_tree = (CommonTree)adaptor.create(IDENT86);
            adaptor.addChild(root_0, IDENT86_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:177:10: ( specifier ( specifier )? )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==NUMBER_LIST||LA20_0==LBRACKET||LA20_0==34) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:177:11: specifier ( specifier )?
                    {
                    pushFollow(FOLLOW_specifier_in_pinAssignment572);
                    specifier87=specifier();

                    state._fsp--;

                    adaptor.addChild(root_0, specifier87.getTree());
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:177:21: ( specifier )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==NUMBER_LIST||LA19_0==LBRACKET||LA19_0==34) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:177:21: specifier
                            {
                            pushFollow(FOLLOW_specifier_in_pinAssignment574);
                            specifier88=specifier();

                            state._fsp--;

                            adaptor.addChild(root_0, specifier88.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }

            EQUALS89=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinAssignment579); 
            EQUALS89_tree = (CommonTree)adaptor.create(EQUALS89);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS89_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_pinAssignment582);
            concatenation90=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation90.getTree());
            SEMICOLON91=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinAssignment584); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:180:1: portAssignment : IDENT ( specifier ( specifier )? )? EQUALS concatenation SEMICOLON ;
    public final PhdlParser.portAssignment_return portAssignment() throws RecognitionException {
        PhdlParser.portAssignment_return retval = new PhdlParser.portAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT92=null;
        Token EQUALS95=null;
        Token SEMICOLON97=null;
        PhdlParser.specifier_return specifier93 = null;

        PhdlParser.specifier_return specifier94 = null;

        PhdlParser.concatenation_return concatenation96 = null;


        CommonTree IDENT92_tree=null;
        CommonTree EQUALS95_tree=null;
        CommonTree SEMICOLON97_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:181:2: ( IDENT ( specifier ( specifier )? )? EQUALS concatenation SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:181:4: IDENT ( specifier ( specifier )? )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT92=(Token)match(input,IDENT,FOLLOW_IDENT_in_portAssignment597); 
            IDENT92_tree = (CommonTree)adaptor.create(IDENT92);
            adaptor.addChild(root_0, IDENT92_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:181:10: ( specifier ( specifier )? )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==NUMBER_LIST||LA22_0==LBRACKET||LA22_0==34) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:181:11: specifier ( specifier )?
                    {
                    pushFollow(FOLLOW_specifier_in_portAssignment600);
                    specifier93=specifier();

                    state._fsp--;

                    adaptor.addChild(root_0, specifier93.getTree());
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:181:21: ( specifier )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==NUMBER_LIST||LA21_0==LBRACKET||LA21_0==34) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:181:21: specifier
                            {
                            pushFollow(FOLLOW_specifier_in_portAssignment602);
                            specifier94=specifier();

                            state._fsp--;

                            adaptor.addChild(root_0, specifier94.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }

            EQUALS95=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_portAssignment607); 
            EQUALS95_tree = (CommonTree)adaptor.create(EQUALS95);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS95_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_portAssignment610);
            concatenation96=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation96.getTree());
            SEMICOLON97=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_portAssignment612); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:184:1: netAssignment : IDENT ( specifier )? EQUALS concatenation SEMICOLON ;
    public final PhdlParser.netAssignment_return netAssignment() throws RecognitionException {
        PhdlParser.netAssignment_return retval = new PhdlParser.netAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT98=null;
        Token EQUALS100=null;
        Token SEMICOLON102=null;
        PhdlParser.specifier_return specifier99 = null;

        PhdlParser.concatenation_return concatenation101 = null;


        CommonTree IDENT98_tree=null;
        CommonTree EQUALS100_tree=null;
        CommonTree SEMICOLON102_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:185:2: ( IDENT ( specifier )? EQUALS concatenation SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:185:4: IDENT ( specifier )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT98=(Token)match(input,IDENT,FOLLOW_IDENT_in_netAssignment625); 
            IDENT98_tree = (CommonTree)adaptor.create(IDENT98);
            adaptor.addChild(root_0, IDENT98_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:185:10: ( specifier )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==NUMBER_LIST||LA23_0==LBRACKET||LA23_0==34) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:185:10: specifier
                    {
                    pushFollow(FOLLOW_specifier_in_netAssignment627);
                    specifier99=specifier();

                    state._fsp--;

                    adaptor.addChild(root_0, specifier99.getTree());

                    }
                    break;

            }

            EQUALS100=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_netAssignment630); 
            EQUALS100_tree = (CommonTree)adaptor.create(EQUALS100);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS100_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_netAssignment633);
            concatenation101=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation101.getTree());
            SEMICOLON102=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netAssignment635); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:188:1: concatenation : ( ( ( IDENT ( specifier )? ) ( '&' IDENT ( specifier )? )* ) | 'open' );
    public final PhdlParser.concatenation_return concatenation() throws RecognitionException {
        PhdlParser.concatenation_return retval = new PhdlParser.concatenation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT103=null;
        Token char_literal105=null;
        Token IDENT106=null;
        Token string_literal108=null;
        PhdlParser.specifier_return specifier104 = null;

        PhdlParser.specifier_return specifier107 = null;


        CommonTree IDENT103_tree=null;
        CommonTree char_literal105_tree=null;
        CommonTree IDENT106_tree=null;
        CommonTree string_literal108_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:189:2: ( ( ( IDENT ( specifier )? ) ( '&' IDENT ( specifier )? )* ) | 'open' )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==IDENT) ) {
                alt27=1;
            }
            else if ( (LA27_0==32) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:189:4: ( ( IDENT ( specifier )? ) ( '&' IDENT ( specifier )? )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:189:4: ( ( IDENT ( specifier )? ) ( '&' IDENT ( specifier )? )* )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:189:5: ( IDENT ( specifier )? ) ( '&' IDENT ( specifier )? )*
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:189:5: ( IDENT ( specifier )? )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:189:6: IDENT ( specifier )?
                    {
                    IDENT103=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation650); 
                    IDENT103_tree = (CommonTree)adaptor.create(IDENT103);
                    adaptor.addChild(root_0, IDENT103_tree);

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:189:12: ( specifier )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==NUMBER_LIST||LA24_0==LBRACKET||LA24_0==34) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:189:12: specifier
                            {
                            pushFollow(FOLLOW_specifier_in_concatenation652);
                            specifier104=specifier();

                            state._fsp--;

                            adaptor.addChild(root_0, specifier104.getTree());

                            }
                            break;

                    }


                    }

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:189:24: ( '&' IDENT ( specifier )? )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==38) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:189:25: '&' IDENT ( specifier )?
                    	    {
                    	    char_literal105=(Token)match(input,38,FOLLOW_38_in_concatenation657); 
                    	    IDENT106=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation660); 
                    	    IDENT106_tree = (CommonTree)adaptor.create(IDENT106);
                    	    adaptor.addChild(root_0, IDENT106_tree);

                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:189:36: ( specifier )?
                    	    int alt25=2;
                    	    int LA25_0 = input.LA(1);

                    	    if ( (LA25_0==NUMBER_LIST||LA25_0==LBRACKET||LA25_0==34) ) {
                    	        alt25=1;
                    	    }
                    	    switch (alt25) {
                    	        case 1 :
                    	            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:189:36: specifier
                    	            {
                    	            pushFollow(FOLLOW_specifier_in_concatenation662);
                    	            specifier107=specifier();

                    	            state._fsp--;

                    	            adaptor.addChild(root_0, specifier107.getTree());

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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:189:53: 'open'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal108=(Token)match(input,32,FOLLOW_32_in_concatenation671); 

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


 

    public static final BitSet FOLLOW_designDecl_in_sourceText68 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_EOF_in_sourceText71 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_designDecl88 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_designDecl91 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_designDecl93 = new BitSet(new long[]{0x0000000201A00000L});
    public static final BitSet FOLLOW_portDecl_in_designDecl106 = new BitSet(new long[]{0x0000000201A00000L});
    public static final BitSet FOLLOW_deviceDecl_in_designDecl110 = new BitSet(new long[]{0x0000000201A00000L});
    public static final BitSet FOLLOW_netDecl_in_designDecl114 = new BitSet(new long[]{0x0000000201A00000L});
    public static final BitSet FOLLOW_21_in_designDecl123 = new BitSet(new long[]{0x0000003000400010L});
    public static final BitSet FOLLOW_instances_in_designDecl133 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_designDecl137 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_designDecl140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_portDecl152 = new BitSet(new long[]{0x00000001FE000000L});
    public static final BitSet FOLLOW_type_in_portDecl155 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_width_in_portDecl158 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_portDecl161 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_portDecl163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_deviceDecl178 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl181 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_deviceDecl183 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_attributeDecl_in_deviceDecl188 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_21_in_deviceDecl193 = new BitSet(new long[]{0x00000001FE400000L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl197 = new BitSet(new long[]{0x00000001FE400000L});
    public static final BitSet FOLLOW_22_in_deviceDecl202 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_deviceDecl205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_attributeDecl221 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_attributeDecl223 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_attributeDecl226 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeDecl228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_pinDecl244 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_width_in_pinDecl247 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl250 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_pinDecl252 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_NUMBER_LIST_in_pinDecl255 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinDecl257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_netDecl319 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_width_in_netDecl323 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl328 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COMMA_in_netDecl330 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl335 = new BitSet(new long[]{0x0000000000000420L});
    public static final BitSet FOLLOW_COLON_in_netDecl338 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl341 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COMMA_in_netDecl343 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl348 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_netDecl352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_width367 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_width370 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_width372 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_width374 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RBRACKET_in_width376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_slice392 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_slice395 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_slice397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_width_in_specifier411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_slice_in_specifier415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_LIST_in_specifier419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deviceInstance_in_instances433 = new BitSet(new long[]{0x0000003000000012L});
    public static final BitSet FOLLOW_subDesignInstance_in_instances437 = new BitSet(new long[]{0x0000003000000012L});
    public static final BitSet FOLLOW_netAssignment_in_instances441 = new BitSet(new long[]{0x0000003000000012L});
    public static final BitSet FOLLOW_36_in_deviceInstance455 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceInstance458 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_deviceInstance460 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceInstance463 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_width_in_deviceInstance466 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_deviceInstance470 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_attributeAssignment_in_deviceInstance475 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_21_in_deviceInstance480 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_pinAssignment_in_deviceInstance484 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_22_in_deviceInstance489 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_deviceInstance492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_subDesignInstance505 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_subDesignInstance508 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_subDesignInstance510 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_subDesignInstance513 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_width_in_subDesignInstance516 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_subDesignInstance520 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_portAssignment_in_subDesignInstance525 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_22_in_subDesignInstance530 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_subDesignInstance533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_attributeAssignment546 = new BitSet(new long[]{0x0000000400004140L});
    public static final BitSet FOLLOW_specifier_in_attributeAssignment548 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_attributeAssignment551 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_attributeAssignment554 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeAssignment556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_pinAssignment569 = new BitSet(new long[]{0x0000000400004140L});
    public static final BitSet FOLLOW_specifier_in_pinAssignment572 = new BitSet(new long[]{0x0000000400004140L});
    public static final BitSet FOLLOW_specifier_in_pinAssignment574 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssignment579 = new BitSet(new long[]{0x0000000100000010L});
    public static final BitSet FOLLOW_concatenation_in_pinAssignment582 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinAssignment584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_portAssignment597 = new BitSet(new long[]{0x0000000400004140L});
    public static final BitSet FOLLOW_specifier_in_portAssignment600 = new BitSet(new long[]{0x0000000400004140L});
    public static final BitSet FOLLOW_specifier_in_portAssignment602 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_portAssignment607 = new BitSet(new long[]{0x0000000100000010L});
    public static final BitSet FOLLOW_concatenation_in_portAssignment610 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_portAssignment612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_netAssignment625 = new BitSet(new long[]{0x0000000400004140L});
    public static final BitSet FOLLOW_specifier_in_netAssignment627 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_netAssignment630 = new BitSet(new long[]{0x0000000100000010L});
    public static final BitSet FOLLOW_concatenation_in_netAssignment633 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_netAssignment635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_concatenation650 = new BitSet(new long[]{0x0000004400004102L});
    public static final BitSet FOLLOW_specifier_in_concatenation652 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_concatenation657 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation660 = new BitSet(new long[]{0x0000004400004102L});
    public static final BitSet FOLLOW_specifier_in_concatenation662 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_32_in_concatenation671 = new BitSet(new long[]{0x0000000000000002L});

}