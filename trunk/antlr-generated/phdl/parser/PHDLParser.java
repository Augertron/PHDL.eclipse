// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g 2011-06-16 15:56:50

	package phdl.parser;
	import java.util.LinkedList;


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
public class PHDLParser extends Parser {
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


        public PHDLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PHDLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return PHDLParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g"; }



    	private LinkedList<String> errors = new LinkedList<String>();

    	@Override
    	public void displayRecognitionError(String[] tokenNames,
    			RecognitionException e) {
    		String hdr = getErrorHeader(e);
    		String msg = getErrorMessage(e, tokenNames);
    		errors.add(hdr + " " + msg);
    	}

    	public LinkedList<String> getErrors() {
    		return errors;
    	}


    public static class sourceText_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sourceText"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:64:1: sourceText : ( designDecl )* EOF ;
    public final PHDLParser.sourceText_return sourceText() throws RecognitionException {
        PHDLParser.sourceText_return retval = new PHDLParser.sourceText_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF2=null;
        PHDLParser.designDecl_return designDecl1 = null;


        CommonTree EOF2_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:67:2: ( ( designDecl )* EOF )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:67:4: ( designDecl )* EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:67:4: ( designDecl )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==18) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:67:4: designDecl
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:70:1: designDecl : 'design' IDENT 'is' ( portDecl )* ( deviceDecl | netDecl )* 'begin' instances 'end' SEMICOLON ;
    public final PHDLParser.designDecl_return designDecl() throws RecognitionException {
        PHDLParser.designDecl_return retval = new PHDLParser.designDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal3=null;
        Token IDENT4=null;
        Token string_literal5=null;
        Token string_literal9=null;
        Token string_literal11=null;
        Token SEMICOLON12=null;
        PHDLParser.portDecl_return portDecl6 = null;

        PHDLParser.deviceDecl_return deviceDecl7 = null;

        PHDLParser.netDecl_return netDecl8 = null;

        PHDLParser.instances_return instances10 = null;


        CommonTree string_literal3_tree=null;
        CommonTree IDENT4_tree=null;
        CommonTree string_literal5_tree=null;
        CommonTree string_literal9_tree=null;
        CommonTree string_literal11_tree=null;
        CommonTree SEMICOLON12_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:76:2: ( 'design' IDENT 'is' ( portDecl )* ( deviceDecl | netDecl )* 'begin' instances 'end' SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:77:3: 'design' IDENT 'is' ( portDecl )* ( deviceDecl | netDecl )* 'begin' instances 'end' SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal3=(Token)match(input,18,FOLLOW_18_in_designDecl88); 
            string_literal3_tree = (CommonTree)adaptor.create(string_literal3);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal3_tree, root_0);

            IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_designDecl91); 
            IDENT4_tree = (CommonTree)adaptor.create(IDENT4);
            adaptor.addChild(root_0, IDENT4_tree);

            string_literal5=(Token)match(input,19,FOLLOW_19_in_designDecl93); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:80:3: ( portDecl )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==22) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:80:3: portDecl
            	    {
            	    pushFollow(FOLLOW_portDecl_in_designDecl105);
            	    portDecl6=portDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, portDecl6.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:83:3: ( deviceDecl | netDecl )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==23) ) {
                    alt3=1;
                }
                else if ( (LA3_0==32) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:83:4: deviceDecl
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_designDecl117);
            	    deviceDecl7=deviceDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, deviceDecl7.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:83:17: netDecl
            	    {
            	    pushFollow(FOLLOW_netDecl_in_designDecl121);
            	    netDecl8=netDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netDecl8.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            string_literal9=(Token)match(input,20,FOLLOW_20_in_designDecl130); 
            string_literal9_tree = (CommonTree)adaptor.create(string_literal9);
            adaptor.addChild(root_0, string_literal9_tree);

            pushFollow(FOLLOW_instances_in_designDecl140);
            instances10=instances();

            state._fsp--;

            adaptor.addChild(root_0, instances10.getTree());
            string_literal11=(Token)match(input,21,FOLLOW_21_in_designDecl144); 
            SEMICOLON12=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_designDecl147); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:92:1: portDecl : 'port' type ( width )? IDENT SEMICOLON ;
    public final PHDLParser.portDecl_return portDecl() throws RecognitionException {
        PHDLParser.portDecl_return retval = new PHDLParser.portDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal13=null;
        Token IDENT16=null;
        Token SEMICOLON17=null;
        PHDLParser.type_return type14 = null;

        PHDLParser.width_return width15 = null;


        CommonTree string_literal13_tree=null;
        CommonTree IDENT16_tree=null;
        CommonTree SEMICOLON17_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:93:2: ( 'port' type ( width )? IDENT SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:93:4: 'port' type ( width )? IDENT SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal13=(Token)match(input,22,FOLLOW_22_in_portDecl159); 
            pushFollow(FOLLOW_type_in_portDecl162);
            type14=type();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(type14.getTree(), root_0);
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:93:18: ( width )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==LBRACKET) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:93:18: width
                    {
                    pushFollow(FOLLOW_width_in_portDecl165);
                    width15=width();

                    state._fsp--;

                    adaptor.addChild(root_0, width15.getTree());

                    }
                    break;

            }

            IDENT16=(Token)match(input,IDENT,FOLLOW_IDENT_in_portDecl168); 
            IDENT16_tree = (CommonTree)adaptor.create(IDENT16);
            adaptor.addChild(root_0, IDENT16_tree);

            SEMICOLON17=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_portDecl170); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:96:1: deviceDecl : 'device' IDENT 'is' ( attributeDecl )* 'begin' ( pinDecl )* 'end' SEMICOLON ;
    public final PHDLParser.deviceDecl_return deviceDecl() throws RecognitionException {
        PHDLParser.deviceDecl_return retval = new PHDLParser.deviceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal18=null;
        Token IDENT19=null;
        Token string_literal20=null;
        Token string_literal22=null;
        Token string_literal24=null;
        Token SEMICOLON25=null;
        PHDLParser.attributeDecl_return attributeDecl21 = null;

        PHDLParser.pinDecl_return pinDecl23 = null;


        CommonTree string_literal18_tree=null;
        CommonTree IDENT19_tree=null;
        CommonTree string_literal20_tree=null;
        CommonTree string_literal22_tree=null;
        CommonTree string_literal24_tree=null;
        CommonTree SEMICOLON25_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:102:2: ( 'device' IDENT 'is' ( attributeDecl )* 'begin' ( pinDecl )* 'end' SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:102:4: 'device' IDENT 'is' ( attributeDecl )* 'begin' ( pinDecl )* 'end' SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal18=(Token)match(input,23,FOLLOW_23_in_deviceDecl185); 
            string_literal18_tree = (CommonTree)adaptor.create(string_literal18);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal18_tree, root_0);

            IDENT19=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl188); 
            IDENT19_tree = (CommonTree)adaptor.create(IDENT19);
            adaptor.addChild(root_0, IDENT19_tree);

            string_literal20=(Token)match(input,19,FOLLOW_19_in_deviceDecl190); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:103:3: ( attributeDecl )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==IDENT) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:103:3: attributeDecl
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_deviceDecl195);
            	    attributeDecl21=attributeDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeDecl21.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            string_literal22=(Token)match(input,20,FOLLOW_20_in_deviceDecl200); 
            string_literal22_tree = (CommonTree)adaptor.create(string_literal22);
            adaptor.addChild(root_0, string_literal22_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:105:3: ( pinDecl )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=24 && LA6_0<=31)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:105:3: pinDecl
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl204);
            	    pinDecl23=pinDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinDecl23.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            string_literal24=(Token)match(input,21,FOLLOW_21_in_deviceDecl209); 
            SEMICOLON25=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_deviceDecl212); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:109:1: attributeDecl : IDENT EQUALS STRING_LITERAL SEMICOLON ;
    public final PHDLParser.attributeDecl_return attributeDecl() throws RecognitionException {
        PHDLParser.attributeDecl_return retval = new PHDLParser.attributeDecl_return();
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:110:2: ( IDENT EQUALS STRING_LITERAL SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:111:3: IDENT EQUALS STRING_LITERAL SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT26=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeDecl228); 
            IDENT26_tree = (CommonTree)adaptor.create(IDENT26);
            adaptor.addChild(root_0, IDENT26_tree);

            EQUALS27=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeDecl230); 
            EQUALS27_tree = (CommonTree)adaptor.create(EQUALS27);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS27_tree, root_0);

            STRING_LITERAL28=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_attributeDecl233); 
            STRING_LITERAL28_tree = (CommonTree)adaptor.create(STRING_LITERAL28);
            adaptor.addChild(root_0, STRING_LITERAL28_tree);

            SEMICOLON29=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeDecl235); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:114:1: pinDecl : type ( width )? IDENT EQUALS STRING_LITERAL SEMICOLON ;
    public final PHDLParser.pinDecl_return pinDecl() throws RecognitionException {
        PHDLParser.pinDecl_return retval = new PHDLParser.pinDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT32=null;
        Token EQUALS33=null;
        Token STRING_LITERAL34=null;
        Token SEMICOLON35=null;
        PHDLParser.type_return type30 = null;

        PHDLParser.width_return width31 = null;


        CommonTree IDENT32_tree=null;
        CommonTree EQUALS33_tree=null;
        CommonTree STRING_LITERAL34_tree=null;
        CommonTree SEMICOLON35_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:115:2: ( type ( width )? IDENT EQUALS STRING_LITERAL SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:116:3: type ( width )? IDENT EQUALS STRING_LITERAL SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_type_in_pinDecl251);
            type30=type();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(type30.getTree(), root_0);
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:116:9: ( width )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==LBRACKET) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:116:9: width
                    {
                    pushFollow(FOLLOW_width_in_pinDecl254);
                    width31=width();

                    state._fsp--;

                    adaptor.addChild(root_0, width31.getTree());

                    }
                    break;

            }

            IDENT32=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinDecl257); 
            IDENT32_tree = (CommonTree)adaptor.create(IDENT32);
            adaptor.addChild(root_0, IDENT32_tree);

            EQUALS33=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinDecl259); 
            STRING_LITERAL34=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_pinDecl262); 
            STRING_LITERAL34_tree = (CommonTree)adaptor.create(STRING_LITERAL34);
            adaptor.addChild(root_0, STRING_LITERAL34_tree);

            SEMICOLON35=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinDecl264); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:119:1: type : ( 'pin' | 'in' | 'out' | 'inout' | 'passive' | 'supply' | 'power' | 'open' );
    public final PHDLParser.type_return type() throws RecognitionException {
        PHDLParser.type_return retval = new PHDLParser.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set36=null;

        CommonTree set36_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:120:2: ( 'pin' | 'in' | 'out' | 'inout' | 'passive' | 'supply' | 'power' | 'open' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:130:1: netDecl : 'net' ( width )? ( IDENT COMMA )* IDENT ( COLON ( IDENT COMMA )* IDENT )? SEMICOLON ;
    public final PHDLParser.netDecl_return netDecl() throws RecognitionException {
        PHDLParser.netDecl_return retval = new PHDLParser.netDecl_return();
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
        PHDLParser.width_return width38 = null;


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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:137:2: ( 'net' ( width )? ( IDENT COMMA )* IDENT ( COLON ( IDENT COMMA )* IDENT )? SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:137:4: 'net' ( width )? ( IDENT COMMA )* IDENT ( COLON ( IDENT COMMA )* IDENT )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal37=(Token)match(input,32,FOLLOW_32_in_netDecl326); 
            string_literal37_tree = (CommonTree)adaptor.create(string_literal37);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal37_tree, root_0);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:137:11: ( width )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==LBRACKET) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:137:12: width
                    {
                    pushFollow(FOLLOW_width_in_netDecl330);
                    width38=width();

                    state._fsp--;

                    adaptor.addChild(root_0, width38.getTree());

                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:137:20: ( IDENT COMMA )*
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:137:21: IDENT COMMA
            	    {
            	    IDENT39=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl335); 
            	    IDENT39_tree = (CommonTree)adaptor.create(IDENT39);
            	    adaptor.addChild(root_0, IDENT39_tree);

            	    COMMA40=(Token)match(input,COMMA,FOLLOW_COMMA_in_netDecl337); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            IDENT41=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl342); 
            IDENT41_tree = (CommonTree)adaptor.create(IDENT41);
            adaptor.addChild(root_0, IDENT41_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:137:42: ( COLON ( IDENT COMMA )* IDENT )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==COLON) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:137:43: COLON ( IDENT COMMA )* IDENT
                    {
                    COLON42=(Token)match(input,COLON,FOLLOW_COLON_in_netDecl345); 
                    COLON42_tree = (CommonTree)adaptor.create(COLON42);
                    adaptor.addChild(root_0, COLON42_tree);

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:137:49: ( IDENT COMMA )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==IDENT) ) {
                            int LA10_1 = input.LA(2);

                            if ( (LA10_1==COMMA) ) {
                                alt10=1;
                            }


                        }


                        switch (alt10) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:137:50: IDENT COMMA
                    	    {
                    	    IDENT43=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl348); 
                    	    IDENT43_tree = (CommonTree)adaptor.create(IDENT43);
                    	    adaptor.addChild(root_0, IDENT43_tree);

                    	    COMMA44=(Token)match(input,COMMA,FOLLOW_COMMA_in_netDecl350); 

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    IDENT45=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl355); 
                    IDENT45_tree = (CommonTree)adaptor.create(IDENT45);
                    adaptor.addChild(root_0, IDENT45_tree);


                    }
                    break;

            }

            SEMICOLON46=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netDecl359); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:140:1: width : '[' INT ':' INT ']' ;
    public final PHDLParser.width_return width() throws RecognitionException {
        PHDLParser.width_return retval = new PHDLParser.width_return();
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:143:2: ( '[' INT ':' INT ']' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:143:4: '[' INT ':' INT ']'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal47=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_width374); 
            INT48=(Token)match(input,INT,FOLLOW_INT_in_width377); 
            INT48_tree = (CommonTree)adaptor.create(INT48);
            adaptor.addChild(root_0, INT48_tree);

            char_literal49=(Token)match(input,COLON,FOLLOW_COLON_in_width379); 
            INT50=(Token)match(input,INT,FOLLOW_INT_in_width382); 
            INT50_tree = (CommonTree)adaptor.create(INT50);
            adaptor.addChild(root_0, INT50_tree);

            char_literal51=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_width384); 

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

    public static class index_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "index"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:146:1: index : '(' INT ')' ;
    public final PHDLParser.index_return index() throws RecognitionException {
        PHDLParser.index_return retval = new PHDLParser.index_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal52=null;
        Token INT53=null;
        Token char_literal54=null;

        CommonTree char_literal52_tree=null;
        CommonTree INT53_tree=null;
        CommonTree char_literal54_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:149:2: ( '(' INT ')' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:149:4: '(' INT ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal52=(Token)match(input,33,FOLLOW_33_in_index400); 
            INT53=(Token)match(input,INT,FOLLOW_INT_in_index403); 
            INT53_tree = (CommonTree)adaptor.create(INT53);
            adaptor.addChild(root_0, INT53_tree);

            char_literal54=(Token)match(input,34,FOLLOW_34_in_index405); 

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

    public static class instances_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "instances"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:152:1: instances : ( deviceInstance | subDesignInstance | netAssignment )* ;
    public final PHDLParser.instances_return instances() throws RecognitionException {
        PHDLParser.instances_return retval = new PHDLParser.instances_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        PHDLParser.deviceInstance_return deviceInstance55 = null;

        PHDLParser.subDesignInstance_return subDesignInstance56 = null;

        PHDLParser.netAssignment_return netAssignment57 = null;



        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:153:2: ( ( deviceInstance | subDesignInstance | netAssignment )* )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:153:4: ( deviceInstance | subDesignInstance | netAssignment )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:153:4: ( deviceInstance | subDesignInstance | netAssignment )*
            loop12:
            do {
                int alt12=4;
                switch ( input.LA(1) ) {
                case 35:
                    {
                    alt12=1;
                    }
                    break;
                case 36:
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:153:5: deviceInstance
            	    {
            	    pushFollow(FOLLOW_deviceInstance_in_instances419);
            	    deviceInstance55=deviceInstance();

            	    state._fsp--;

            	    adaptor.addChild(root_0, deviceInstance55.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:153:22: subDesignInstance
            	    {
            	    pushFollow(FOLLOW_subDesignInstance_in_instances423);
            	    subDesignInstance56=subDesignInstance();

            	    state._fsp--;

            	    adaptor.addChild(root_0, subDesignInstance56.getTree());

            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:153:42: netAssignment
            	    {
            	    pushFollow(FOLLOW_netAssignment_in_instances427);
            	    netAssignment57=netAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netAssignment57.getTree());

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:156:1: deviceInstance : 'inst' IDENT ':' IDENT ( width )? 'is' ( attributeAssignment )* 'begin' ( pinAssignment )* 'end' ';' ;
    public final PHDLParser.deviceInstance_return deviceInstance() throws RecognitionException {
        PHDLParser.deviceInstance_return retval = new PHDLParser.deviceInstance_return();
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
        PHDLParser.width_return width62 = null;

        PHDLParser.attributeAssignment_return attributeAssignment64 = null;

        PHDLParser.pinAssignment_return pinAssignment66 = null;


        CommonTree string_literal58_tree=null;
        CommonTree IDENT59_tree=null;
        CommonTree char_literal60_tree=null;
        CommonTree IDENT61_tree=null;
        CommonTree string_literal63_tree=null;
        CommonTree string_literal65_tree=null;
        CommonTree string_literal67_tree=null;
        CommonTree char_literal68_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:157:2: ( 'inst' IDENT ':' IDENT ( width )? 'is' ( attributeAssignment )* 'begin' ( pinAssignment )* 'end' ';' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:157:4: 'inst' IDENT ':' IDENT ( width )? 'is' ( attributeAssignment )* 'begin' ( pinAssignment )* 'end' ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal58=(Token)match(input,35,FOLLOW_35_in_deviceInstance441); 
            string_literal58_tree = (CommonTree)adaptor.create(string_literal58);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal58_tree, root_0);

            IDENT59=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceInstance444); 
            IDENT59_tree = (CommonTree)adaptor.create(IDENT59);
            adaptor.addChild(root_0, IDENT59_tree);

            char_literal60=(Token)match(input,COLON,FOLLOW_COLON_in_deviceInstance446); 
            IDENT61=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceInstance449); 
            IDENT61_tree = (CommonTree)adaptor.create(IDENT61);
            adaptor.addChild(root_0, IDENT61_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:157:29: ( width )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==LBRACKET) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:157:30: width
                    {
                    pushFollow(FOLLOW_width_in_deviceInstance452);
                    width62=width();

                    state._fsp--;

                    adaptor.addChild(root_0, width62.getTree());

                    }
                    break;

            }

            string_literal63=(Token)match(input,19,FOLLOW_19_in_deviceInstance456); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:158:3: ( attributeAssignment )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==IDENT) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:158:3: attributeAssignment
            	    {
            	    pushFollow(FOLLOW_attributeAssignment_in_deviceInstance461);
            	    attributeAssignment64=attributeAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeAssignment64.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            string_literal65=(Token)match(input,20,FOLLOW_20_in_deviceInstance466); 
            string_literal65_tree = (CommonTree)adaptor.create(string_literal65);
            adaptor.addChild(root_0, string_literal65_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:160:3: ( pinAssignment )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==IDENT) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:160:3: pinAssignment
            	    {
            	    pushFollow(FOLLOW_pinAssignment_in_deviceInstance470);
            	    pinAssignment66=pinAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinAssignment66.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            string_literal67=(Token)match(input,21,FOLLOW_21_in_deviceInstance475); 
            char_literal68=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_deviceInstance478); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:164:1: subDesignInstance : 'sub' IDENT ':' IDENT ( width )? 'is' ( portAssignment )* 'end' ';' ;
    public final PHDLParser.subDesignInstance_return subDesignInstance() throws RecognitionException {
        PHDLParser.subDesignInstance_return retval = new PHDLParser.subDesignInstance_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal69=null;
        Token IDENT70=null;
        Token char_literal71=null;
        Token IDENT72=null;
        Token string_literal74=null;
        Token string_literal76=null;
        Token char_literal77=null;
        PHDLParser.width_return width73 = null;

        PHDLParser.portAssignment_return portAssignment75 = null;


        CommonTree string_literal69_tree=null;
        CommonTree IDENT70_tree=null;
        CommonTree char_literal71_tree=null;
        CommonTree IDENT72_tree=null;
        CommonTree string_literal74_tree=null;
        CommonTree string_literal76_tree=null;
        CommonTree char_literal77_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:165:2: ( 'sub' IDENT ':' IDENT ( width )? 'is' ( portAssignment )* 'end' ';' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:165:4: 'sub' IDENT ':' IDENT ( width )? 'is' ( portAssignment )* 'end' ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal69=(Token)match(input,36,FOLLOW_36_in_subDesignInstance491); 
            string_literal69_tree = (CommonTree)adaptor.create(string_literal69);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal69_tree, root_0);

            IDENT70=(Token)match(input,IDENT,FOLLOW_IDENT_in_subDesignInstance494); 
            IDENT70_tree = (CommonTree)adaptor.create(IDENT70);
            adaptor.addChild(root_0, IDENT70_tree);

            char_literal71=(Token)match(input,COLON,FOLLOW_COLON_in_subDesignInstance496); 
            IDENT72=(Token)match(input,IDENT,FOLLOW_IDENT_in_subDesignInstance499); 
            IDENT72_tree = (CommonTree)adaptor.create(IDENT72);
            adaptor.addChild(root_0, IDENT72_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:165:28: ( width )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==LBRACKET) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:165:29: width
                    {
                    pushFollow(FOLLOW_width_in_subDesignInstance502);
                    width73=width();

                    state._fsp--;

                    adaptor.addChild(root_0, width73.getTree());

                    }
                    break;

            }

            string_literal74=(Token)match(input,19,FOLLOW_19_in_subDesignInstance506); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:166:3: ( portAssignment )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==IDENT) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:166:3: portAssignment
            	    {
            	    pushFollow(FOLLOW_portAssignment_in_subDesignInstance511);
            	    portAssignment75=portAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, portAssignment75.getTree());

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            string_literal76=(Token)match(input,21,FOLLOW_21_in_subDesignInstance516); 
            char_literal77=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_subDesignInstance519); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:170:1: attributeAssignment : IDENT ( width | index )? EQUALS STRING_LITERAL SEMICOLON ;
    public final PHDLParser.attributeAssignment_return attributeAssignment() throws RecognitionException {
        PHDLParser.attributeAssignment_return retval = new PHDLParser.attributeAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT78=null;
        Token EQUALS81=null;
        Token STRING_LITERAL82=null;
        Token SEMICOLON83=null;
        PHDLParser.width_return width79 = null;

        PHDLParser.index_return index80 = null;


        CommonTree IDENT78_tree=null;
        CommonTree EQUALS81_tree=null;
        CommonTree STRING_LITERAL82_tree=null;
        CommonTree SEMICOLON83_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:171:2: ( IDENT ( width | index )? EQUALS STRING_LITERAL SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:171:4: IDENT ( width | index )? EQUALS STRING_LITERAL SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT78=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeAssignment532); 
            IDENT78_tree = (CommonTree)adaptor.create(IDENT78);
            adaptor.addChild(root_0, IDENT78_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:171:10: ( width | index )?
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:171:11: width
                    {
                    pushFollow(FOLLOW_width_in_attributeAssignment535);
                    width79=width();

                    state._fsp--;

                    adaptor.addChild(root_0, width79.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:171:19: index
                    {
                    pushFollow(FOLLOW_index_in_attributeAssignment539);
                    index80=index();

                    state._fsp--;

                    adaptor.addChild(root_0, index80.getTree());

                    }
                    break;

            }

            EQUALS81=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeAssignment543); 
            EQUALS81_tree = (CommonTree)adaptor.create(EQUALS81);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS81_tree, root_0);

            STRING_LITERAL82=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_attributeAssignment546); 
            STRING_LITERAL82_tree = (CommonTree)adaptor.create(STRING_LITERAL82);
            adaptor.addChild(root_0, STRING_LITERAL82_tree);

            SEMICOLON83=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeAssignment548); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:174:1: pinAssignment : IDENT ( width | index )? EQUALS concatenation SEMICOLON ;
    public final PHDLParser.pinAssignment_return pinAssignment() throws RecognitionException {
        PHDLParser.pinAssignment_return retval = new PHDLParser.pinAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT84=null;
        Token EQUALS87=null;
        Token SEMICOLON89=null;
        PHDLParser.width_return width85 = null;

        PHDLParser.index_return index86 = null;

        PHDLParser.concatenation_return concatenation88 = null;


        CommonTree IDENT84_tree=null;
        CommonTree EQUALS87_tree=null;
        CommonTree SEMICOLON89_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:175:2: ( IDENT ( width | index )? EQUALS concatenation SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:175:4: IDENT ( width | index )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT84=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinAssignment561); 
            IDENT84_tree = (CommonTree)adaptor.create(IDENT84);
            adaptor.addChild(root_0, IDENT84_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:175:10: ( width | index )?
            int alt19=3;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==LBRACKET) ) {
                alt19=1;
            }
            else if ( (LA19_0==33) ) {
                alt19=2;
            }
            switch (alt19) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:175:11: width
                    {
                    pushFollow(FOLLOW_width_in_pinAssignment564);
                    width85=width();

                    state._fsp--;

                    adaptor.addChild(root_0, width85.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:175:19: index
                    {
                    pushFollow(FOLLOW_index_in_pinAssignment568);
                    index86=index();

                    state._fsp--;

                    adaptor.addChild(root_0, index86.getTree());

                    }
                    break;

            }

            EQUALS87=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinAssignment572); 
            EQUALS87_tree = (CommonTree)adaptor.create(EQUALS87);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS87_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_pinAssignment575);
            concatenation88=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation88.getTree());
            SEMICOLON89=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinAssignment577); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:178:1: portAssignment : IDENT ( width | index )? EQUALS concatenation SEMICOLON ;
    public final PHDLParser.portAssignment_return portAssignment() throws RecognitionException {
        PHDLParser.portAssignment_return retval = new PHDLParser.portAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT90=null;
        Token EQUALS93=null;
        Token SEMICOLON95=null;
        PHDLParser.width_return width91 = null;

        PHDLParser.index_return index92 = null;

        PHDLParser.concatenation_return concatenation94 = null;


        CommonTree IDENT90_tree=null;
        CommonTree EQUALS93_tree=null;
        CommonTree SEMICOLON95_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:179:2: ( IDENT ( width | index )? EQUALS concatenation SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:179:4: IDENT ( width | index )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT90=(Token)match(input,IDENT,FOLLOW_IDENT_in_portAssignment590); 
            IDENT90_tree = (CommonTree)adaptor.create(IDENT90);
            adaptor.addChild(root_0, IDENT90_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:179:10: ( width | index )?
            int alt20=3;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==LBRACKET) ) {
                alt20=1;
            }
            else if ( (LA20_0==33) ) {
                alt20=2;
            }
            switch (alt20) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:179:11: width
                    {
                    pushFollow(FOLLOW_width_in_portAssignment593);
                    width91=width();

                    state._fsp--;

                    adaptor.addChild(root_0, width91.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:179:19: index
                    {
                    pushFollow(FOLLOW_index_in_portAssignment597);
                    index92=index();

                    state._fsp--;

                    adaptor.addChild(root_0, index92.getTree());

                    }
                    break;

            }

            EQUALS93=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_portAssignment601); 
            EQUALS93_tree = (CommonTree)adaptor.create(EQUALS93);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS93_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_portAssignment604);
            concatenation94=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation94.getTree());
            SEMICOLON95=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_portAssignment606); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:182:1: netAssignment : IDENT ( width | index )? EQUALS concatenation SEMICOLON ;
    public final PHDLParser.netAssignment_return netAssignment() throws RecognitionException {
        PHDLParser.netAssignment_return retval = new PHDLParser.netAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT96=null;
        Token EQUALS99=null;
        Token SEMICOLON101=null;
        PHDLParser.width_return width97 = null;

        PHDLParser.index_return index98 = null;

        PHDLParser.concatenation_return concatenation100 = null;


        CommonTree IDENT96_tree=null;
        CommonTree EQUALS99_tree=null;
        CommonTree SEMICOLON101_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:183:2: ( IDENT ( width | index )? EQUALS concatenation SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:183:4: IDENT ( width | index )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT96=(Token)match(input,IDENT,FOLLOW_IDENT_in_netAssignment619); 
            IDENT96_tree = (CommonTree)adaptor.create(IDENT96);
            adaptor.addChild(root_0, IDENT96_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:183:10: ( width | index )?
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:183:11: width
                    {
                    pushFollow(FOLLOW_width_in_netAssignment622);
                    width97=width();

                    state._fsp--;

                    adaptor.addChild(root_0, width97.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:183:19: index
                    {
                    pushFollow(FOLLOW_index_in_netAssignment626);
                    index98=index();

                    state._fsp--;

                    adaptor.addChild(root_0, index98.getTree());

                    }
                    break;

            }

            EQUALS99=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_netAssignment630); 
            EQUALS99_tree = (CommonTree)adaptor.create(EQUALS99);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS99_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_netAssignment633);
            concatenation100=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation100.getTree());
            SEMICOLON101=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netAssignment635); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:186:1: concatenation : ( ( ( IDENT ( width | index )? ) ( '&' IDENT ( width | index )? )* ) | 'open' );
    public final PHDLParser.concatenation_return concatenation() throws RecognitionException {
        PHDLParser.concatenation_return retval = new PHDLParser.concatenation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT102=null;
        Token char_literal105=null;
        Token IDENT106=null;
        Token string_literal109=null;
        PHDLParser.width_return width103 = null;

        PHDLParser.index_return index104 = null;

        PHDLParser.width_return width107 = null;

        PHDLParser.index_return index108 = null;


        CommonTree IDENT102_tree=null;
        CommonTree char_literal105_tree=null;
        CommonTree IDENT106_tree=null;
        CommonTree string_literal109_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:187:2: ( ( ( IDENT ( width | index )? ) ( '&' IDENT ( width | index )? )* ) | 'open' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==IDENT) ) {
                alt25=1;
            }
            else if ( (LA25_0==31) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:187:4: ( ( IDENT ( width | index )? ) ( '&' IDENT ( width | index )? )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:187:4: ( ( IDENT ( width | index )? ) ( '&' IDENT ( width | index )? )* )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:187:5: ( IDENT ( width | index )? ) ( '&' IDENT ( width | index )? )*
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:187:5: ( IDENT ( width | index )? )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:187:6: IDENT ( width | index )?
                    {
                    IDENT102=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation650); 
                    IDENT102_tree = (CommonTree)adaptor.create(IDENT102);
                    adaptor.addChild(root_0, IDENT102_tree);

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:187:12: ( width | index )?
                    int alt22=3;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==LBRACKET) ) {
                        alt22=1;
                    }
                    else if ( (LA22_0==33) ) {
                        alt22=2;
                    }
                    switch (alt22) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:187:13: width
                            {
                            pushFollow(FOLLOW_width_in_concatenation653);
                            width103=width();

                            state._fsp--;

                            adaptor.addChild(root_0, width103.getTree());

                            }
                            break;
                        case 2 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:187:21: index
                            {
                            pushFollow(FOLLOW_index_in_concatenation657);
                            index104=index();

                            state._fsp--;

                            adaptor.addChild(root_0, index104.getTree());

                            }
                            break;

                    }


                    }

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:187:30: ( '&' IDENT ( width | index )? )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==37) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:187:31: '&' IDENT ( width | index )?
                    	    {
                    	    char_literal105=(Token)match(input,37,FOLLOW_37_in_concatenation663); 
                    	    IDENT106=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation666); 
                    	    IDENT106_tree = (CommonTree)adaptor.create(IDENT106);
                    	    adaptor.addChild(root_0, IDENT106_tree);

                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:187:42: ( width | index )?
                    	    int alt23=3;
                    	    int LA23_0 = input.LA(1);

                    	    if ( (LA23_0==LBRACKET) ) {
                    	        alt23=1;
                    	    }
                    	    else if ( (LA23_0==33) ) {
                    	        alt23=2;
                    	    }
                    	    switch (alt23) {
                    	        case 1 :
                    	            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:187:43: width
                    	            {
                    	            pushFollow(FOLLOW_width_in_concatenation669);
                    	            width107=width();

                    	            state._fsp--;

                    	            adaptor.addChild(root_0, width107.getTree());

                    	            }
                    	            break;
                    	        case 2 :
                    	            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:187:51: index
                    	            {
                    	            pushFollow(FOLLOW_index_in_concatenation673);
                    	            index108=index();

                    	            state._fsp--;

                    	            adaptor.addChild(root_0, index108.getTree());

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDL.g:187:65: 'open'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal109=(Token)match(input,31,FOLLOW_31_in_concatenation683); 

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
    public static final BitSet FOLLOW_portDecl_in_designDecl105 = new BitSet(new long[]{0x0000000100D00000L});
    public static final BitSet FOLLOW_deviceDecl_in_designDecl117 = new BitSet(new long[]{0x0000000100900000L});
    public static final BitSet FOLLOW_netDecl_in_designDecl121 = new BitSet(new long[]{0x0000000100900000L});
    public static final BitSet FOLLOW_20_in_designDecl130 = new BitSet(new long[]{0x0000001800200010L});
    public static final BitSet FOLLOW_instances_in_designDecl140 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_designDecl144 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_designDecl147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_portDecl159 = new BitSet(new long[]{0x00000000FF000000L});
    public static final BitSet FOLLOW_type_in_portDecl162 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_width_in_portDecl165 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_portDecl168 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_portDecl170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_deviceDecl185 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl188 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_deviceDecl190 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_attributeDecl_in_deviceDecl195 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_20_in_deviceDecl200 = new BitSet(new long[]{0x00000000FF200000L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl204 = new BitSet(new long[]{0x00000000FF200000L});
    public static final BitSet FOLLOW_21_in_deviceDecl209 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_deviceDecl212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_attributeDecl228 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_attributeDecl230 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_attributeDecl233 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeDecl235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_pinDecl251 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_width_in_pinDecl254 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl257 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_pinDecl259 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_pinDecl262 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinDecl264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_netDecl326 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_width_in_netDecl330 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl335 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_COMMA_in_netDecl337 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl342 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_COLON_in_netDecl345 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl348 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_COMMA_in_netDecl350 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl355 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_netDecl359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_width374 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_width377 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COLON_in_width379 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_width382 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACKET_in_width384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_index400 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_index403 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_index405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deviceInstance_in_instances419 = new BitSet(new long[]{0x0000001800000012L});
    public static final BitSet FOLLOW_subDesignInstance_in_instances423 = new BitSet(new long[]{0x0000001800000012L});
    public static final BitSet FOLLOW_netAssignment_in_instances427 = new BitSet(new long[]{0x0000001800000012L});
    public static final BitSet FOLLOW_35_in_deviceInstance441 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceInstance444 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COLON_in_deviceInstance446 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceInstance449 = new BitSet(new long[]{0x0000000000082000L});
    public static final BitSet FOLLOW_width_in_deviceInstance452 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_deviceInstance456 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_attributeAssignment_in_deviceInstance461 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_20_in_deviceInstance466 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_pinAssignment_in_deviceInstance470 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_21_in_deviceInstance475 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_deviceInstance478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_subDesignInstance491 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_subDesignInstance494 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COLON_in_subDesignInstance496 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_subDesignInstance499 = new BitSet(new long[]{0x0000000000082000L});
    public static final BitSet FOLLOW_width_in_subDesignInstance502 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_subDesignInstance506 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_portAssignment_in_subDesignInstance511 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_21_in_subDesignInstance516 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_subDesignInstance519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_attributeAssignment532 = new BitSet(new long[]{0x0000000200002040L});
    public static final BitSet FOLLOW_width_in_attributeAssignment535 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_index_in_attributeAssignment539 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_attributeAssignment543 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_attributeAssignment546 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeAssignment548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_pinAssignment561 = new BitSet(new long[]{0x0000000200002040L});
    public static final BitSet FOLLOW_width_in_pinAssignment564 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_index_in_pinAssignment568 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssignment572 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_concatenation_in_pinAssignment575 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinAssignment577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_portAssignment590 = new BitSet(new long[]{0x0000000200002040L});
    public static final BitSet FOLLOW_width_in_portAssignment593 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_index_in_portAssignment597 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_portAssignment601 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_concatenation_in_portAssignment604 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_portAssignment606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_netAssignment619 = new BitSet(new long[]{0x0000000200002040L});
    public static final BitSet FOLLOW_width_in_netAssignment622 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_index_in_netAssignment626 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_netAssignment630 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_concatenation_in_netAssignment633 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_netAssignment635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_concatenation650 = new BitSet(new long[]{0x0000002200002002L});
    public static final BitSet FOLLOW_width_in_concatenation653 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_index_in_concatenation657 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_concatenation663 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation666 = new BitSet(new long[]{0x0000002200002002L});
    public static final BitSet FOLLOW_width_in_concatenation669 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_index_in_concatenation673 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_31_in_concatenation683 = new BitSet(new long[]{0x0000000000000002L});

}