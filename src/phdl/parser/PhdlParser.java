// $ANTLR 3.3 Nov 30, 2010 12:50:56 /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g 2011-07-05 11:45:40

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "SEMICOLON", "EQUALS", "STRING_LITERAL", "INT", "CHAR", "DIGIT", "COLON", "COMMA", "PERIOD", "LBRACKET", "RBRACKET", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "'design'", "'is'", "'begin'", "'end'", "'device'", "'attr'", "'pin'", "'net'", "'inst'", "'new'", "'&'", "'<'", "'>'", "'open'", "'{'", "'}'", "'('", "')'"
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
    public static final int IDENT=4;
    public static final int SEMICOLON=5;
    public static final int EQUALS=6;
    public static final int STRING_LITERAL=7;
    public static final int INT=8;
    public static final int CHAR=9;
    public static final int DIGIT=10;
    public static final int COLON=11;
    public static final int COMMA=12;
    public static final int PERIOD=13;
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
    public String getGrammarFileName() { return "/Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g"; }



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
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:65:1: sourceText : designDecl EOF ;
    public final PhdlParser.sourceText_return sourceText() throws RecognitionException {
        PhdlParser.sourceText_return retval = new PhdlParser.sourceText_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF2=null;
        PhdlParser.designDecl_return designDecl1 = null;


        CommonTree EOF2_tree=null;

        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:68:2: ( designDecl EOF )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:68:4: designDecl EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_designDecl_in_sourceText68);
            designDecl1=designDecl();

            state._fsp--;

            adaptor.addChild(root_0, designDecl1.getTree());
            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_sourceText70); 
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
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:71:1: designDecl : 'design' IDENT 'is' ( deviceDecl | netDecl )* 'begin' ( deviceInstance | netAssignment )* 'end' SEMICOLON ;
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
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:77:2: ( 'design' IDENT 'is' ( deviceDecl | netDecl )* 'begin' ( deviceInstance | netAssignment )* 'end' SEMICOLON )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:78:3: 'design' IDENT 'is' ( deviceDecl | netDecl )* 'begin' ( deviceInstance | netAssignment )* 'end' SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal3=(Token)match(input,19,FOLLOW_19_in_designDecl86); 
            string_literal3_tree = (CommonTree)adaptor.create(string_literal3);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal3_tree, root_0);

            IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_designDecl89); 
            IDENT4_tree = (CommonTree)adaptor.create(IDENT4);
            adaptor.addChild(root_0, IDENT4_tree);

            string_literal5=(Token)match(input,20,FOLLOW_20_in_designDecl91); 
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:81:3: ( deviceDecl | netDecl )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==23) ) {
                    alt1=1;
                }
                else if ( (LA1_0==26) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:81:4: deviceDecl
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_designDecl104);
            	    deviceDecl6=deviceDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, deviceDecl6.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:81:17: netDecl
            	    {
            	    pushFollow(FOLLOW_netDecl_in_designDecl108);
            	    netDecl7=netDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netDecl7.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            string_literal8=(Token)match(input,21,FOLLOW_21_in_designDecl117); 
            string_literal8_tree = (CommonTree)adaptor.create(string_literal8);
            adaptor.addChild(root_0, string_literal8_tree);

            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:86:3: ( deviceInstance | netAssignment )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==27) ) {
                    alt2=1;
                }
                else if ( (LA2_0==IDENT) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:86:4: deviceInstance
            	    {
            	    pushFollow(FOLLOW_deviceInstance_in_designDecl128);
            	    deviceInstance9=deviceInstance();

            	    state._fsp--;

            	    adaptor.addChild(root_0, deviceInstance9.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:86:21: netAssignment
            	    {
            	    pushFollow(FOLLOW_netAssignment_in_designDecl132);
            	    netAssignment10=netAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netAssignment10.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            string_literal11=(Token)match(input,22,FOLLOW_22_in_designDecl141); 
            SEMICOLON12=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_designDecl144); 

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
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:91:1: deviceDecl : 'device' IDENT 'is' ( attributeDecl | pinDecl )* 'end' SEMICOLON ;
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
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:97:2: ( 'device' IDENT 'is' ( attributeDecl | pinDecl )* 'end' SEMICOLON )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:97:4: 'device' IDENT 'is' ( attributeDecl | pinDecl )* 'end' SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal13=(Token)match(input,23,FOLLOW_23_in_deviceDecl159); 
            string_literal13_tree = (CommonTree)adaptor.create(string_literal13);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal13_tree, root_0);

            IDENT14=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl162); 
            IDENT14_tree = (CommonTree)adaptor.create(IDENT14);
            adaptor.addChild(root_0, IDENT14_tree);

            string_literal15=(Token)match(input,20,FOLLOW_20_in_deviceDecl164); 
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:98:3: ( attributeDecl | pinDecl )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==24) ) {
                    alt3=1;
                }
                else if ( (LA3_0==25) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:98:5: attributeDecl
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_deviceDecl171);
            	    attributeDecl16=attributeDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeDecl16.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:98:21: pinDecl
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl175);
            	    pinDecl17=pinDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinDecl17.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            string_literal18=(Token)match(input,22,FOLLOW_22_in_deviceDecl182); 
            SEMICOLON19=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_deviceDecl185); 

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
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:102:1: attributeDecl : 'attr' IDENT EQUALS STRING_LITERAL SEMICOLON ;
    public final PhdlParser.attributeDecl_return attributeDecl() throws RecognitionException {
        PhdlParser.attributeDecl_return retval = new PhdlParser.attributeDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal20=null;
        Token IDENT21=null;
        Token EQUALS22=null;
        Token STRING_LITERAL23=null;
        Token SEMICOLON24=null;

        CommonTree string_literal20_tree=null;
        CommonTree IDENT21_tree=null;
        CommonTree EQUALS22_tree=null;
        CommonTree STRING_LITERAL23_tree=null;
        CommonTree SEMICOLON24_tree=null;

        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:103:2: ( 'attr' IDENT EQUALS STRING_LITERAL SEMICOLON )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:104:3: 'attr' IDENT EQUALS STRING_LITERAL SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal20=(Token)match(input,24,FOLLOW_24_in_attributeDecl201); 
            string_literal20_tree = (CommonTree)adaptor.create(string_literal20);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal20_tree, root_0);

            IDENT21=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeDecl204); 
            IDENT21_tree = (CommonTree)adaptor.create(IDENT21);
            adaptor.addChild(root_0, IDENT21_tree);

            EQUALS22=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeDecl206); 
            STRING_LITERAL23=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_attributeDecl209); 
            STRING_LITERAL23_tree = (CommonTree)adaptor.create(STRING_LITERAL23);
            adaptor.addChild(root_0, STRING_LITERAL23_tree);

            SEMICOLON24=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeDecl211); 

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
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:107:1: pinDecl : type ( sliceList )? IDENT EQUALS pinList SEMICOLON ;
    public final PhdlParser.pinDecl_return pinDecl() throws RecognitionException {
        PhdlParser.pinDecl_return retval = new PhdlParser.pinDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT27=null;
        Token EQUALS28=null;
        Token SEMICOLON30=null;
        PhdlParser.type_return type25 = null;

        PhdlParser.sliceList_return sliceList26 = null;

        PhdlParser.pinList_return pinList29 = null;


        CommonTree IDENT27_tree=null;
        CommonTree EQUALS28_tree=null;
        CommonTree SEMICOLON30_tree=null;

        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:108:2: ( type ( sliceList )? IDENT EQUALS pinList SEMICOLON )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:109:3: type ( sliceList )? IDENT EQUALS pinList SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_type_in_pinDecl227);
            type25=type();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(type25.getTree(), root_0);
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:109:9: ( sliceList )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==LBRACKET) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:109:9: sliceList
                    {
                    pushFollow(FOLLOW_sliceList_in_pinDecl230);
                    sliceList26=sliceList();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceList26.getTree());

                    }
                    break;

            }

            IDENT27=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinDecl233); 
            IDENT27_tree = (CommonTree)adaptor.create(IDENT27);
            adaptor.addChild(root_0, IDENT27_tree);

            EQUALS28=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinDecl235); 
            pushFollow(FOLLOW_pinList_in_pinDecl238);
            pinList29=pinList();

            state._fsp--;

            adaptor.addChild(root_0, pinList29.getTree());
            SEMICOLON30=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinDecl240); 

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
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:112:1: type : 'pin' ;
    public final PhdlParser.type_return type() throws RecognitionException {
        PhdlParser.type_return retval = new PhdlParser.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal31=null;

        CommonTree string_literal31_tree=null;

        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:117:2: ( 'pin' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:117:4: 'pin'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal31=(Token)match(input,25,FOLLOW_25_in_type255); 
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
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:126:1: netDecl : 'net' ( sliceList )? IDENT ( netAttributes )? SEMICOLON ;
    public final PhdlParser.netDecl_return netDecl() throws RecognitionException {
        PhdlParser.netDecl_return retval = new PhdlParser.netDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal32=null;
        Token IDENT34=null;
        Token SEMICOLON36=null;
        PhdlParser.sliceList_return sliceList33 = null;

        PhdlParser.netAttributes_return netAttributes35 = null;


        CommonTree string_literal32_tree=null;
        CommonTree IDENT34_tree=null;
        CommonTree SEMICOLON36_tree=null;

        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:135:2: ( 'net' ( sliceList )? IDENT ( netAttributes )? SEMICOLON )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:135:4: 'net' ( sliceList )? IDENT ( netAttributes )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal32=(Token)match(input,26,FOLLOW_26_in_netDecl277); 
            string_literal32_tree = (CommonTree)adaptor.create(string_literal32);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal32_tree, root_0);

            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:135:11: ( sliceList )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==LBRACKET) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:135:11: sliceList
                    {
                    pushFollow(FOLLOW_sliceList_in_netDecl280);
                    sliceList33=sliceList();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceList33.getTree());

                    }
                    break;

            }

            IDENT34=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl283); 
            IDENT34_tree = (CommonTree)adaptor.create(IDENT34);
            adaptor.addChild(root_0, IDENT34_tree);

            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:135:28: ( netAttributes )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==20) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:135:28: netAttributes
                    {
                    pushFollow(FOLLOW_netAttributes_in_netDecl285);
                    netAttributes35=netAttributes();

                    state._fsp--;

                    adaptor.addChild(root_0, netAttributes35.getTree());

                    }
                    break;

            }

            SEMICOLON36=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netDecl288); 

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
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:139:1: netAttributes : 'is' ( attributeDecl )* 'end' ;
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
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:140:2: ( 'is' ( attributeDecl )* 'end' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:140:4: 'is' ( attributeDecl )* 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal37=(Token)match(input,20,FOLLOW_20_in_netAttributes304); 
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:140:10: ( attributeDecl )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==24) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:140:10: attributeDecl
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_netAttributes307);
            	    attributeDecl38=attributeDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeDecl38.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            string_literal39=(Token)match(input,22,FOLLOW_22_in_netAttributes310); 

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

    public static class deviceInstance_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "deviceInstance"
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:143:1: deviceInstance : 'inst' IDENT ':' IDENT ( arrayList )? 'is' ( attributeAssignment | pinAssignment )* 'end' ';' ;
    public final PhdlParser.deviceInstance_return deviceInstance() throws RecognitionException {
        PhdlParser.deviceInstance_return retval = new PhdlParser.deviceInstance_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal40=null;
        Token IDENT41=null;
        Token char_literal42=null;
        Token IDENT43=null;
        Token string_literal45=null;
        Token string_literal48=null;
        Token char_literal49=null;
        PhdlParser.arrayList_return arrayList44 = null;

        PhdlParser.attributeAssignment_return attributeAssignment46 = null;

        PhdlParser.pinAssignment_return pinAssignment47 = null;


        CommonTree string_literal40_tree=null;
        CommonTree IDENT41_tree=null;
        CommonTree char_literal42_tree=null;
        CommonTree IDENT43_tree=null;
        CommonTree string_literal45_tree=null;
        CommonTree string_literal48_tree=null;
        CommonTree char_literal49_tree=null;

        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:144:2: ( 'inst' IDENT ':' IDENT ( arrayList )? 'is' ( attributeAssignment | pinAssignment )* 'end' ';' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:144:4: 'inst' IDENT ':' IDENT ( arrayList )? 'is' ( attributeAssignment | pinAssignment )* 'end' ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal40=(Token)match(input,27,FOLLOW_27_in_deviceInstance323); 
            string_literal40_tree = (CommonTree)adaptor.create(string_literal40);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal40_tree, root_0);

            IDENT41=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceInstance326); 
            IDENT41_tree = (CommonTree)adaptor.create(IDENT41);
            adaptor.addChild(root_0, IDENT41_tree);

            char_literal42=(Token)match(input,COLON,FOLLOW_COLON_in_deviceInstance328); 
            IDENT43=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceInstance331); 
            IDENT43_tree = (CommonTree)adaptor.create(IDENT43);
            adaptor.addChild(root_0, IDENT43_tree);

            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:144:29: ( arrayList )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==35) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:144:29: arrayList
                    {
                    pushFollow(FOLLOW_arrayList_in_deviceInstance333);
                    arrayList44=arrayList();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayList44.getTree());

                    }
                    break;

            }

            string_literal45=(Token)match(input,20,FOLLOW_20_in_deviceInstance336); 
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:145:3: ( attributeAssignment | pinAssignment )*
            loop9:
            do {
                int alt9=3;
                alt9 = dfa9.predict(input);
                switch (alt9) {
            	case 1 :
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:145:5: attributeAssignment
            	    {
            	    pushFollow(FOLLOW_attributeAssignment_in_deviceInstance343);
            	    attributeAssignment46=attributeAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeAssignment46.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:145:27: pinAssignment
            	    {
            	    pushFollow(FOLLOW_pinAssignment_in_deviceInstance347);
            	    pinAssignment47=pinAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinAssignment47.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            string_literal48=(Token)match(input,22,FOLLOW_22_in_deviceInstance354); 
            char_literal49=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_deviceInstance357); 

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
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:149:1: attributeAssignment : ( 'new' 'attr' )? ( instanceQualifier )? IDENT EQUALS STRING_LITERAL SEMICOLON ;
    public final PhdlParser.attributeAssignment_return attributeAssignment() throws RecognitionException {
        PhdlParser.attributeAssignment_return retval = new PhdlParser.attributeAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal50=null;
        Token string_literal51=null;
        Token IDENT53=null;
        Token EQUALS54=null;
        Token STRING_LITERAL55=null;
        Token SEMICOLON56=null;
        PhdlParser.instanceQualifier_return instanceQualifier52 = null;


        CommonTree string_literal50_tree=null;
        CommonTree string_literal51_tree=null;
        CommonTree IDENT53_tree=null;
        CommonTree EQUALS54_tree=null;
        CommonTree STRING_LITERAL55_tree=null;
        CommonTree SEMICOLON56_tree=null;

        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:150:2: ( ( 'new' 'attr' )? ( instanceQualifier )? IDENT EQUALS STRING_LITERAL SEMICOLON )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:150:5: ( 'new' 'attr' )? ( instanceQualifier )? IDENT EQUALS STRING_LITERAL SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:150:5: ( 'new' 'attr' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==28) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:150:6: 'new' 'attr'
                    {
                    string_literal50=(Token)match(input,28,FOLLOW_28_in_attributeAssignment371); 
                    string_literal50_tree = (CommonTree)adaptor.create(string_literal50);
                    adaptor.addChild(root_0, string_literal50_tree);

                    string_literal51=(Token)match(input,24,FOLLOW_24_in_attributeAssignment373); 

                    }
                    break;

            }

            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:150:22: ( instanceQualifier )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==IDENT) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==PERIOD||LA11_1==35) ) {
                    alt11=1;
                }
            }
            switch (alt11) {
                case 1 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:150:22: instanceQualifier
                    {
                    pushFollow(FOLLOW_instanceQualifier_in_attributeAssignment378);
                    instanceQualifier52=instanceQualifier();

                    state._fsp--;

                    adaptor.addChild(root_0, instanceQualifier52.getTree());

                    }
                    break;

            }

            IDENT53=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeAssignment381); 
            IDENT53_tree = (CommonTree)adaptor.create(IDENT53);
            adaptor.addChild(root_0, IDENT53_tree);

            EQUALS54=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeAssignment383); 
            EQUALS54_tree = (CommonTree)adaptor.create(EQUALS54);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS54_tree, root_0);

            STRING_LITERAL55=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_attributeAssignment386); 
            STRING_LITERAL55_tree = (CommonTree)adaptor.create(STRING_LITERAL55);
            adaptor.addChild(root_0, STRING_LITERAL55_tree);

            SEMICOLON56=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeAssignment388); 

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
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:153:1: instanceQualifier : ( IDENT '.' | IDENT arrayList '.' );
    public final PhdlParser.instanceQualifier_return instanceQualifier() throws RecognitionException {
        PhdlParser.instanceQualifier_return retval = new PhdlParser.instanceQualifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT57=null;
        Token char_literal58=null;
        Token IDENT59=null;
        Token char_literal61=null;
        PhdlParser.arrayList_return arrayList60 = null;


        CommonTree IDENT57_tree=null;
        CommonTree char_literal58_tree=null;
        CommonTree IDENT59_tree=null;
        CommonTree char_literal61_tree=null;

        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:154:2: ( IDENT '.' | IDENT arrayList '.' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==IDENT) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==PERIOD) ) {
                    alt12=1;
                }
                else if ( (LA12_1==35) ) {
                    alt12=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:154:4: IDENT '.'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    IDENT57=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceQualifier401); 
                    IDENT57_tree = (CommonTree)adaptor.create(IDENT57);
                    adaptor.addChild(root_0, IDENT57_tree);

                    char_literal58=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_instanceQualifier403); 
                    char_literal58_tree = (CommonTree)adaptor.create(char_literal58);
                    root_0 = (CommonTree)adaptor.becomeRoot(char_literal58_tree, root_0);


                    }
                    break;
                case 2 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:155:4: IDENT arrayList '.'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    IDENT59=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceQualifier411); 
                    IDENT59_tree = (CommonTree)adaptor.create(IDENT59);
                    adaptor.addChild(root_0, IDENT59_tree);

                    pushFollow(FOLLOW_arrayList_in_instanceQualifier413);
                    arrayList60=arrayList();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayList60.getTree());
                    char_literal61=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_instanceQualifier415); 
                    char_literal61_tree = (CommonTree)adaptor.create(char_literal61);
                    root_0 = (CommonTree)adaptor.becomeRoot(char_literal61_tree, root_0);


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
    // $ANTLR end "instanceQualifier"

    public static class pinAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pinAssignment"
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:158:1: pinAssignment : ( instanceQualifier )? IDENT ( sliceList )? EQUALS concatenation SEMICOLON ;
    public final PhdlParser.pinAssignment_return pinAssignment() throws RecognitionException {
        PhdlParser.pinAssignment_return retval = new PhdlParser.pinAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT63=null;
        Token EQUALS65=null;
        Token SEMICOLON67=null;
        PhdlParser.instanceQualifier_return instanceQualifier62 = null;

        PhdlParser.sliceList_return sliceList64 = null;

        PhdlParser.concatenation_return concatenation66 = null;


        CommonTree IDENT63_tree=null;
        CommonTree EQUALS65_tree=null;
        CommonTree SEMICOLON67_tree=null;

        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:159:2: ( ( instanceQualifier )? IDENT ( sliceList )? EQUALS concatenation SEMICOLON )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:159:4: ( instanceQualifier )? IDENT ( sliceList )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:159:4: ( instanceQualifier )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==IDENT) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==PERIOD||LA13_1==35) ) {
                    alt13=1;
                }
            }
            switch (alt13) {
                case 1 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:159:4: instanceQualifier
                    {
                    pushFollow(FOLLOW_instanceQualifier_in_pinAssignment428);
                    instanceQualifier62=instanceQualifier();

                    state._fsp--;

                    adaptor.addChild(root_0, instanceQualifier62.getTree());

                    }
                    break;

            }

            IDENT63=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinAssignment431); 
            IDENT63_tree = (CommonTree)adaptor.create(IDENT63);
            adaptor.addChild(root_0, IDENT63_tree);

            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:159:29: ( sliceList )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==LBRACKET) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:159:29: sliceList
                    {
                    pushFollow(FOLLOW_sliceList_in_pinAssignment433);
                    sliceList64=sliceList();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceList64.getTree());

                    }
                    break;

            }

            EQUALS65=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinAssignment436); 
            EQUALS65_tree = (CommonTree)adaptor.create(EQUALS65);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS65_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_pinAssignment439);
            concatenation66=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation66.getTree());
            SEMICOLON67=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinAssignment441); 

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
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:162:1: netAssignment : IDENT ( sliceList )? EQUALS concatenation SEMICOLON ;
    public final PhdlParser.netAssignment_return netAssignment() throws RecognitionException {
        PhdlParser.netAssignment_return retval = new PhdlParser.netAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT68=null;
        Token EQUALS70=null;
        Token SEMICOLON72=null;
        PhdlParser.sliceList_return sliceList69 = null;

        PhdlParser.concatenation_return concatenation71 = null;


        CommonTree IDENT68_tree=null;
        CommonTree EQUALS70_tree=null;
        CommonTree SEMICOLON72_tree=null;

        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:163:2: ( IDENT ( sliceList )? EQUALS concatenation SEMICOLON )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:163:4: IDENT ( sliceList )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT68=(Token)match(input,IDENT,FOLLOW_IDENT_in_netAssignment454); 
            IDENT68_tree = (CommonTree)adaptor.create(IDENT68);
            adaptor.addChild(root_0, IDENT68_tree);

            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:163:10: ( sliceList )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==LBRACKET) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:163:10: sliceList
                    {
                    pushFollow(FOLLOW_sliceList_in_netAssignment456);
                    sliceList69=sliceList();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceList69.getTree());

                    }
                    break;

            }

            EQUALS70=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_netAssignment459); 
            EQUALS70_tree = (CommonTree)adaptor.create(EQUALS70);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS70_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_netAssignment462);
            concatenation71=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation71.getTree());
            SEMICOLON72=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netAssignment464); 

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
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:166:1: concatenation : ( ( ( IDENT ( sliceList )? ) ( '&' IDENT ( sliceList )? )* ) | '<' IDENT '>' | 'open' );
    public final PhdlParser.concatenation_return concatenation() throws RecognitionException {
        PhdlParser.concatenation_return retval = new PhdlParser.concatenation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT73=null;
        Token char_literal75=null;
        Token IDENT76=null;
        Token char_literal78=null;
        Token IDENT79=null;
        Token char_literal80=null;
        Token string_literal81=null;
        PhdlParser.sliceList_return sliceList74 = null;

        PhdlParser.sliceList_return sliceList77 = null;


        CommonTree IDENT73_tree=null;
        CommonTree char_literal75_tree=null;
        CommonTree IDENT76_tree=null;
        CommonTree char_literal78_tree=null;
        CommonTree IDENT79_tree=null;
        CommonTree char_literal80_tree=null;
        CommonTree string_literal81_tree=null;

        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:167:2: ( ( ( IDENT ( sliceList )? ) ( '&' IDENT ( sliceList )? )* ) | '<' IDENT '>' | 'open' )
            int alt19=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt19=1;
                }
                break;
            case 30:
                {
                alt19=2;
                }
                break;
            case 32:
                {
                alt19=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:167:4: ( ( IDENT ( sliceList )? ) ( '&' IDENT ( sliceList )? )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:167:4: ( ( IDENT ( sliceList )? ) ( '&' IDENT ( sliceList )? )* )
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:167:5: ( IDENT ( sliceList )? ) ( '&' IDENT ( sliceList )? )*
                    {
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:167:5: ( IDENT ( sliceList )? )
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:167:6: IDENT ( sliceList )?
                    {
                    IDENT73=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation479); 
                    IDENT73_tree = (CommonTree)adaptor.create(IDENT73);
                    adaptor.addChild(root_0, IDENT73_tree);

                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:167:12: ( sliceList )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==LBRACKET) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:167:12: sliceList
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation481);
                            sliceList74=sliceList();

                            state._fsp--;

                            adaptor.addChild(root_0, sliceList74.getTree());

                            }
                            break;

                    }


                    }

                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:167:24: ( '&' IDENT ( sliceList )? )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==29) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:167:25: '&' IDENT ( sliceList )?
                    	    {
                    	    char_literal75=(Token)match(input,29,FOLLOW_29_in_concatenation486); 
                    	    IDENT76=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation489); 
                    	    IDENT76_tree = (CommonTree)adaptor.create(IDENT76);
                    	    adaptor.addChild(root_0, IDENT76_tree);

                    	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:167:36: ( sliceList )?
                    	    int alt17=2;
                    	    int LA17_0 = input.LA(1);

                    	    if ( (LA17_0==LBRACKET) ) {
                    	        alt17=1;
                    	    }
                    	    switch (alt17) {
                    	        case 1 :
                    	            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:167:36: sliceList
                    	            {
                    	            pushFollow(FOLLOW_sliceList_in_concatenation491);
                    	            sliceList77=sliceList();

                    	            state._fsp--;

                    	            adaptor.addChild(root_0, sliceList77.getTree());

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:168:4: '<' IDENT '>'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal78=(Token)match(input,30,FOLLOW_30_in_concatenation502); 
                    char_literal78_tree = (CommonTree)adaptor.create(char_literal78);
                    adaptor.addChild(root_0, char_literal78_tree);

                    IDENT79=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation504); 
                    IDENT79_tree = (CommonTree)adaptor.create(IDENT79);
                    adaptor.addChild(root_0, IDENT79_tree);

                    char_literal80=(Token)match(input,31,FOLLOW_31_in_concatenation506); 
                    char_literal80_tree = (CommonTree)adaptor.create(char_literal80);
                    adaptor.addChild(root_0, char_literal80_tree);


                    }
                    break;
                case 3 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:169:5: 'open'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal81=(Token)match(input,32,FOLLOW_32_in_concatenation512); 

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
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:173:1: pinList : '{' IDENT ( ',' IDENT )* '}' ;
    public final PhdlParser.pinList_return pinList() throws RecognitionException {
        PhdlParser.pinList_return retval = new PhdlParser.pinList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal82=null;
        Token IDENT83=null;
        Token char_literal84=null;
        Token IDENT85=null;
        Token char_literal86=null;

        CommonTree char_literal82_tree=null;
        CommonTree IDENT83_tree=null;
        CommonTree char_literal84_tree=null;
        CommonTree IDENT85_tree=null;
        CommonTree char_literal86_tree=null;

        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:196:2: ( '{' IDENT ( ',' IDENT )* '}' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:196:4: '{' IDENT ( ',' IDENT )* '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal82=(Token)match(input,33,FOLLOW_33_in_pinList530); 
            char_literal82_tree = (CommonTree)adaptor.create(char_literal82);
            adaptor.addChild(root_0, char_literal82_tree);

            IDENT83=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinList532); 
            IDENT83_tree = (CommonTree)adaptor.create(IDENT83);
            adaptor.addChild(root_0, IDENT83_tree);

            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:196:14: ( ',' IDENT )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==COMMA) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:196:15: ',' IDENT
            	    {
            	    char_literal84=(Token)match(input,COMMA,FOLLOW_COMMA_in_pinList535); 
            	    char_literal84_tree = (CommonTree)adaptor.create(char_literal84);
            	    adaptor.addChild(root_0, char_literal84_tree);

            	    IDENT85=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinList537); 
            	    IDENT85_tree = (CommonTree)adaptor.create(IDENT85);
            	    adaptor.addChild(root_0, IDENT85_tree);


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            char_literal86=(Token)match(input,34,FOLLOW_34_in_pinList541); 
            char_literal86_tree = (CommonTree)adaptor.create(char_literal86);
            adaptor.addChild(root_0, char_literal86_tree);


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
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:199:1: sliceList : '[' INT ( | ':' INT | ( ',' INT )* ) ']' ;
    public final PhdlParser.sliceList_return sliceList() throws RecognitionException {
        PhdlParser.sliceList_return retval = new PhdlParser.sliceList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal87=null;
        Token INT88=null;
        Token char_literal89=null;
        Token INT90=null;
        Token char_literal91=null;
        Token INT92=null;
        Token char_literal93=null;

        CommonTree char_literal87_tree=null;
        CommonTree INT88_tree=null;
        CommonTree char_literal89_tree=null;
        CommonTree INT90_tree=null;
        CommonTree char_literal91_tree=null;
        CommonTree INT92_tree=null;
        CommonTree char_literal93_tree=null;

        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:200:2: ( '[' INT ( | ':' INT | ( ',' INT )* ) ']' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:200:4: '[' INT ( | ':' INT | ( ',' INT )* ) ']'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal87=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_sliceList553); 
            char_literal87_tree = (CommonTree)adaptor.create(char_literal87);
            adaptor.addChild(root_0, char_literal87_tree);

            INT88=(Token)match(input,INT,FOLLOW_INT_in_sliceList555); 
            INT88_tree = (CommonTree)adaptor.create(INT88);
            adaptor.addChild(root_0, INT88_tree);

            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:201:2: ( | ':' INT | ( ',' INT )* )
            int alt22=3;
            switch ( input.LA(1) ) {
            case RBRACKET:
                {
                alt22=1;
                }
                break;
            case COLON:
                {
                alt22=2;
                }
                break;
            case COMMA:
                {
                alt22=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:202:2: 
                    {
                    }
                    break;
                case 2 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:202:4: ':' INT
                    {
                    char_literal89=(Token)match(input,COLON,FOLLOW_COLON_in_sliceList563); 
                    char_literal89_tree = (CommonTree)adaptor.create(char_literal89);
                    root_0 = (CommonTree)adaptor.becomeRoot(char_literal89_tree, root_0);

                    INT90=(Token)match(input,INT,FOLLOW_INT_in_sliceList566); 
                    INT90_tree = (CommonTree)adaptor.create(INT90);
                    adaptor.addChild(root_0, INT90_tree);


                    }
                    break;
                case 3 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:203:4: ( ',' INT )*
                    {
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:203:4: ( ',' INT )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==COMMA) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:203:5: ',' INT
                    	    {
                    	    char_literal91=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceList572); 
                    	    char_literal91_tree = (CommonTree)adaptor.create(char_literal91);
                    	    root_0 = (CommonTree)adaptor.becomeRoot(char_literal91_tree, root_0);

                    	    INT92=(Token)match(input,INT,FOLLOW_INT_in_sliceList575); 
                    	    INT92_tree = (CommonTree)adaptor.create(INT92);
                    	    adaptor.addChild(root_0, INT92_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal93=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_sliceList584); 
            char_literal93_tree = (CommonTree)adaptor.create(char_literal93);
            adaptor.addChild(root_0, char_literal93_tree);


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

    public static class arrayList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arrayList"
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:208:1: arrayList : '(' ( | INT ':' INT | INT ( ',' INT )* ) ')' ;
    public final PhdlParser.arrayList_return arrayList() throws RecognitionException {
        PhdlParser.arrayList_return retval = new PhdlParser.arrayList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal94=null;
        Token INT95=null;
        Token char_literal96=null;
        Token INT97=null;
        Token INT98=null;
        Token char_literal99=null;
        Token INT100=null;
        Token char_literal101=null;

        CommonTree char_literal94_tree=null;
        CommonTree INT95_tree=null;
        CommonTree char_literal96_tree=null;
        CommonTree INT97_tree=null;
        CommonTree INT98_tree=null;
        CommonTree char_literal99_tree=null;
        CommonTree INT100_tree=null;
        CommonTree char_literal101_tree=null;

        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:209:2: ( '(' ( | INT ':' INT | INT ( ',' INT )* ) ')' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:209:4: '(' ( | INT ':' INT | INT ( ',' INT )* ) ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal94=(Token)match(input,35,FOLLOW_35_in_arrayList596); 
            char_literal94_tree = (CommonTree)adaptor.create(char_literal94);
            adaptor.addChild(root_0, char_literal94_tree);

            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:210:2: ( | INT ':' INT | INT ( ',' INT )* )
            int alt24=3;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==36) ) {
                alt24=1;
            }
            else if ( (LA24_0==INT) ) {
                int LA24_2 = input.LA(2);

                if ( (LA24_2==COLON) ) {
                    alt24=2;
                }
                else if ( (LA24_2==COMMA||LA24_2==36) ) {
                    alt24=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:211:2: 
                    {
                    }
                    break;
                case 2 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:211:4: INT ':' INT
                    {
                    INT95=(Token)match(input,INT,FOLLOW_INT_in_arrayList605); 
                    INT95_tree = (CommonTree)adaptor.create(INT95);
                    adaptor.addChild(root_0, INT95_tree);

                    char_literal96=(Token)match(input,COLON,FOLLOW_COLON_in_arrayList607); 
                    char_literal96_tree = (CommonTree)adaptor.create(char_literal96);
                    root_0 = (CommonTree)adaptor.becomeRoot(char_literal96_tree, root_0);

                    INT97=(Token)match(input,INT,FOLLOW_INT_in_arrayList610); 
                    INT97_tree = (CommonTree)adaptor.create(INT97);
                    adaptor.addChild(root_0, INT97_tree);


                    }
                    break;
                case 3 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:212:4: INT ( ',' INT )*
                    {
                    INT98=(Token)match(input,INT,FOLLOW_INT_in_arrayList615); 
                    INT98_tree = (CommonTree)adaptor.create(INT98);
                    adaptor.addChild(root_0, INT98_tree);

                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:212:8: ( ',' INT )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==COMMA) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:212:9: ',' INT
                    	    {
                    	    char_literal99=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayList618); 
                    	    char_literal99_tree = (CommonTree)adaptor.create(char_literal99);
                    	    root_0 = (CommonTree)adaptor.becomeRoot(char_literal99_tree, root_0);

                    	    INT100=(Token)match(input,INT,FOLLOW_INT_in_arrayList621); 
                    	    INT100_tree = (CommonTree)adaptor.create(INT100);
                    	    adaptor.addChild(root_0, INT100_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal101=(Token)match(input,36,FOLLOW_36_in_arrayList630); 
            char_literal101_tree = (CommonTree)adaptor.create(char_literal101);
            adaptor.addChild(root_0, char_literal101_tree);


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

    // Delegated rules


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\20\uffff";
    static final String DFA9_eofS =
        "\20\uffff";
    static final String DFA9_minS =
        "\1\4\2\uffff\1\6\2\4\1\10\1\uffff\1\6\1\15\1\13\1\4\2\10\1\44\1"+
        "\14";
    static final String DFA9_maxS =
        "\1\34\2\uffff\1\43\1\4\1\40\1\44\1\uffff\1\16\1\15\1\44\1\4\2\10"+
        "\2\44";
    static final String DFA9_acceptS =
        "\1\uffff\1\3\1\1\4\uffff\1\2\10\uffff";
    static final String DFA9_specialS =
        "\20\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\3\21\uffff\1\1\5\uffff\1\2",
            "",
            "",
            "\1\5\6\uffff\1\4\1\7\24\uffff\1\6",
            "\1\10",
            "\1\7\2\uffff\1\2\26\uffff\1\7\1\uffff\1\7",
            "\1\12\33\uffff\1\11",
            "",
            "\1\5\7\uffff\1\7",
            "\1\13",
            "\1\14\1\15\27\uffff\1\11",
            "\1\10",
            "\1\16",
            "\1\17",
            "\1\11",
            "\1\15\27\uffff\1\11"
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "()* loopback of 145:3: ( attributeAssignment | pinAssignment )*";
        }
    }
 

    public static final BitSet FOLLOW_designDecl_in_sourceText68 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_sourceText70 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_designDecl86 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_designDecl89 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_designDecl91 = new BitSet(new long[]{0x0000000004A00000L});
    public static final BitSet FOLLOW_deviceDecl_in_designDecl104 = new BitSet(new long[]{0x0000000004A00000L});
    public static final BitSet FOLLOW_netDecl_in_designDecl108 = new BitSet(new long[]{0x0000000004A00000L});
    public static final BitSet FOLLOW_21_in_designDecl117 = new BitSet(new long[]{0x0000000008400010L});
    public static final BitSet FOLLOW_deviceInstance_in_designDecl128 = new BitSet(new long[]{0x0000000008400010L});
    public static final BitSet FOLLOW_netAssignment_in_designDecl132 = new BitSet(new long[]{0x0000000008400010L});
    public static final BitSet FOLLOW_22_in_designDecl141 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_designDecl144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_deviceDecl159 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl162 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_deviceDecl164 = new BitSet(new long[]{0x0000000003400000L});
    public static final BitSet FOLLOW_attributeDecl_in_deviceDecl171 = new BitSet(new long[]{0x0000000003400000L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl175 = new BitSet(new long[]{0x0000000003400000L});
    public static final BitSet FOLLOW_22_in_deviceDecl182 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_deviceDecl185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_attributeDecl201 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attributeDecl204 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_attributeDecl206 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_attributeDecl209 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeDecl211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_pinDecl227 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_sliceList_in_pinDecl230 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl233 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_pinDecl235 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_pinList_in_pinDecl238 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinDecl240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_type255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_netDecl277 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_sliceList_in_netDecl280 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl283 = new BitSet(new long[]{0x0000000000100020L});
    public static final BitSet FOLLOW_netAttributes_in_netDecl285 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_netDecl288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_netAttributes304 = new BitSet(new long[]{0x0000000001400000L});
    public static final BitSet FOLLOW_attributeDecl_in_netAttributes307 = new BitSet(new long[]{0x0000000001400000L});
    public static final BitSet FOLLOW_22_in_netAttributes310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_deviceInstance323 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceInstance326 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_deviceInstance328 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceInstance331 = new BitSet(new long[]{0x0000000800100000L});
    public static final BitSet FOLLOW_arrayList_in_deviceInstance333 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_deviceInstance336 = new BitSet(new long[]{0x0000000010400010L});
    public static final BitSet FOLLOW_attributeAssignment_in_deviceInstance343 = new BitSet(new long[]{0x0000000010400010L});
    public static final BitSet FOLLOW_pinAssignment_in_deviceInstance347 = new BitSet(new long[]{0x0000000010400010L});
    public static final BitSet FOLLOW_22_in_deviceInstance354 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_deviceInstance357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_attributeAssignment371 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_attributeAssignment373 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_instanceQualifier_in_attributeAssignment378 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attributeAssignment381 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_attributeAssignment383 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_attributeAssignment386 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeAssignment388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_instanceQualifier401 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_PERIOD_in_instanceQualifier403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_instanceQualifier411 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_arrayList_in_instanceQualifier413 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_PERIOD_in_instanceQualifier415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instanceQualifier_in_pinAssignment428 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinAssignment431 = new BitSet(new long[]{0x0000000000004040L});
    public static final BitSet FOLLOW_sliceList_in_pinAssignment433 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssignment436 = new BitSet(new long[]{0x0000000140000010L});
    public static final BitSet FOLLOW_concatenation_in_pinAssignment439 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinAssignment441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_netAssignment454 = new BitSet(new long[]{0x0000000000004040L});
    public static final BitSet FOLLOW_sliceList_in_netAssignment456 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_netAssignment459 = new BitSet(new long[]{0x0000000140000010L});
    public static final BitSet FOLLOW_concatenation_in_netAssignment462 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_netAssignment464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_concatenation479 = new BitSet(new long[]{0x0000000020004002L});
    public static final BitSet FOLLOW_sliceList_in_concatenation481 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_concatenation486 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation489 = new BitSet(new long[]{0x0000000020004002L});
    public static final BitSet FOLLOW_sliceList_in_concatenation491 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_30_in_concatenation502 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation504 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_concatenation506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_concatenation512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_pinList530 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinList532 = new BitSet(new long[]{0x0000000400001000L});
    public static final BitSet FOLLOW_COMMA_in_pinList535 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinList537 = new BitSet(new long[]{0x0000000400001000L});
    public static final BitSet FOLLOW_34_in_pinList541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_sliceList553 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_INT_in_sliceList555 = new BitSet(new long[]{0x0000000000009800L});
    public static final BitSet FOLLOW_COLON_in_sliceList563 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_INT_in_sliceList566 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_COMMA_in_sliceList572 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_INT_in_sliceList575 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_RBRACKET_in_sliceList584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_arrayList596 = new BitSet(new long[]{0x0000001000000100L});
    public static final BitSet FOLLOW_INT_in_arrayList605 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_arrayList607 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_INT_in_arrayList610 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_INT_in_arrayList615 = new BitSet(new long[]{0x0000001000001000L});
    public static final BitSet FOLLOW_COMMA_in_arrayList618 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_INT_in_arrayList621 = new BitSet(new long[]{0x0000001000001000L});
    public static final BitSet FOLLOW_36_in_arrayList630 = new BitSet(new long[]{0x0000000000000002L});

}