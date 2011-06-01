// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\work\\phdl\\src\\phdl\\PHDL.g 2011-05-31 16:01:01

  package phdl;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class PHDLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "STRING_LITERAL", "INT", "CHAR", "DIGIT", "COMMA", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "'design'", "'is'", "'begin'", "'end'", "';'", "'configuration'", "'device'", "'net'", "':'", "'='", "'['", "']'", "'inst'", "'subSch'", "'in'", "'out'", "'inout'", "'pass'", "'sup'", "'pwr'", "'open'", "'pin'"
    };
    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
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
    public static final int IDENT=4;
    public static final int STRING_LITERAL=5;
    public static final int INT=6;
    public static final int CHAR=7;
    public static final int DIGIT=8;
    public static final int COMMA=9;
    public static final int WHITESPACE=10;
    public static final int LINE_COMMENT=11;
    public static final int MULTILINE_COMMENT=12;

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
    public String getGrammarFileName() { return "C:\\work\\phdl\\src\\phdl\\PHDL.g"; }


    public static class sourceText_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sourceText"
    // C:\\work\\phdl\\src\\phdl\\PHDL.g:21:1: sourceText : design EOF ;
    public final PHDLParser.sourceText_return sourceText() throws RecognitionException {
        PHDLParser.sourceText_return retval = new PHDLParser.sourceText_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF2=null;
        PHDLParser.design_return design1 = null;


        CommonTree EOF2_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:24:2: ( design EOF )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:25:3: design EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_design_in_sourceText61);
            design1=design();

            state._fsp--;

            adaptor.addChild(root_0, design1.getTree());
            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_sourceText65); 
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

    public static class design_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "design"
    // C:\\work\\phdl\\src\\phdl\\PHDL.g:29:1: design : 'design' IDENT 'is' ( deviceDecl | netDecl )* 'begin' instantiations 'end' ';' ;
    public final PHDLParser.design_return design() throws RecognitionException {
        PHDLParser.design_return retval = new PHDLParser.design_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal3=null;
        Token IDENT4=null;
        Token string_literal5=null;
        Token string_literal8=null;
        Token string_literal10=null;
        Token char_literal11=null;
        PHDLParser.deviceDecl_return deviceDecl6 = null;

        PHDLParser.netDecl_return netDecl7 = null;

        PHDLParser.instantiations_return instantiations9 = null;


        CommonTree string_literal3_tree=null;
        CommonTree IDENT4_tree=null;
        CommonTree string_literal5_tree=null;
        CommonTree string_literal8_tree=null;
        CommonTree string_literal10_tree=null;
        CommonTree char_literal11_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:35:2: ( 'design' IDENT 'is' ( deviceDecl | netDecl )* 'begin' instantiations 'end' ';' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:35:4: 'design' IDENT 'is' ( deviceDecl | netDecl )* 'begin' instantiations 'end' ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal3=(Token)match(input,13,FOLLOW_13_in_design79); 
            string_literal3_tree = (CommonTree)adaptor.create(string_literal3);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal3_tree, root_0);

            IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_design82); 
            IDENT4_tree = (CommonTree)adaptor.create(IDENT4);
            adaptor.addChild(root_0, IDENT4_tree);

            string_literal5=(Token)match(input,14,FOLLOW_14_in_design84); 
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:37:3: ( deviceDecl | netDecl )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==19) ) {
                    alt1=1;
                }
                else if ( (LA1_0==20) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\PHDL.g:37:4: deviceDecl
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_design93);
            	    deviceDecl6=deviceDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, deviceDecl6.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\phdl\\src\\phdl\\PHDL.g:37:17: netDecl
            	    {
            	    pushFollow(FOLLOW_netDecl_in_design97);
            	    netDecl7=netDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netDecl7.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            string_literal8=(Token)match(input,15,FOLLOW_15_in_design103); 
            string_literal8_tree = (CommonTree)adaptor.create(string_literal8);
            adaptor.addChild(root_0, string_literal8_tree);

            pushFollow(FOLLOW_instantiations_in_design107);
            instantiations9=instantiations();

            state._fsp--;

            adaptor.addChild(root_0, instantiations9.getTree());
            string_literal10=(Token)match(input,16,FOLLOW_16_in_design111); 
            char_literal11=(Token)match(input,17,FOLLOW_17_in_design114); 

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
    // $ANTLR end "design"

    public static class configuration_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "configuration"
    // C:\\work\\phdl\\src\\phdl\\PHDL.g:43:1: configuration : 'configuration' cfgName 'is' ( ( cfgAttr ',' )* cfgAttr )+ 'end' ';' ;
    public final PHDLParser.configuration_return configuration() throws RecognitionException {
        PHDLParser.configuration_return retval = new PHDLParser.configuration_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal12=null;
        Token string_literal14=null;
        Token char_literal16=null;
        Token string_literal18=null;
        Token char_literal19=null;
        PHDLParser.cfgName_return cfgName13 = null;

        PHDLParser.cfgAttr_return cfgAttr15 = null;

        PHDLParser.cfgAttr_return cfgAttr17 = null;


        CommonTree string_literal12_tree=null;
        CommonTree string_literal14_tree=null;
        CommonTree char_literal16_tree=null;
        CommonTree string_literal18_tree=null;
        CommonTree char_literal19_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:46:2: ( 'configuration' cfgName 'is' ( ( cfgAttr ',' )* cfgAttr )+ 'end' ';' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:46:4: 'configuration' cfgName 'is' ( ( cfgAttr ',' )* cfgAttr )+ 'end' ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal12=(Token)match(input,18,FOLLOW_18_in_configuration129); 
            string_literal12_tree = (CommonTree)adaptor.create(string_literal12);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal12_tree, root_0);

            pushFollow(FOLLOW_cfgName_in_configuration132);
            cfgName13=cfgName();

            state._fsp--;

            adaptor.addChild(root_0, cfgName13.getTree());
            string_literal14=(Token)match(input,14,FOLLOW_14_in_configuration134); 
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:47:3: ( ( cfgAttr ',' )* cfgAttr )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==IDENT) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\PHDL.g:47:4: ( cfgAttr ',' )* cfgAttr
            	    {
            	    // C:\\work\\phdl\\src\\phdl\\PHDL.g:47:4: ( cfgAttr ',' )*
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( (LA2_0==IDENT) ) {
            	            int LA2_1 = input.LA(2);

            	            if ( (LA2_1==COMMA) ) {
            	                alt2=1;
            	            }


            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // C:\\work\\phdl\\src\\phdl\\PHDL.g:47:5: cfgAttr ','
            	    	    {
            	    	    pushFollow(FOLLOW_cfgAttr_in_configuration141);
            	    	    cfgAttr15=cfgAttr();

            	    	    state._fsp--;

            	    	    adaptor.addChild(root_0, cfgAttr15.getTree());
            	    	    char_literal16=(Token)match(input,COMMA,FOLLOW_COMMA_in_configuration143); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop2;
            	        }
            	    } while (true);

            	    pushFollow(FOLLOW_cfgAttr_in_configuration148);
            	    cfgAttr17=cfgAttr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, cfgAttr17.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            string_literal18=(Token)match(input,16,FOLLOW_16_in_configuration154); 
            char_literal19=(Token)match(input,17,FOLLOW_17_in_configuration157); 

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
    // $ANTLR end "configuration"

    public static class cfgName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "cfgName"
    // C:\\work\\phdl\\src\\phdl\\PHDL.g:51:1: cfgName : IDENT ;
    public final PHDLParser.cfgName_return cfgName() throws RecognitionException {
        PHDLParser.cfgName_return retval = new PHDLParser.cfgName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT20=null;

        CommonTree IDENT20_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:54:2: ( IDENT )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:54:4: IDENT
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT20=(Token)match(input,IDENT,FOLLOW_IDENT_in_cfgName172); 
            IDENT20_tree = (CommonTree)adaptor.create(IDENT20);
            adaptor.addChild(root_0, IDENT20_tree);


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
    // $ANTLR end "cfgName"

    public static class cfgAttr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "cfgAttr"
    // C:\\work\\phdl\\src\\phdl\\PHDL.g:57:1: cfgAttr : IDENT ;
    public final PHDLParser.cfgAttr_return cfgAttr() throws RecognitionException {
        PHDLParser.cfgAttr_return retval = new PHDLParser.cfgAttr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT21=null;

        CommonTree IDENT21_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:60:2: ( IDENT )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:60:4: IDENT
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT21=(Token)match(input,IDENT,FOLLOW_IDENT_in_cfgAttr186); 
            IDENT21_tree = (CommonTree)adaptor.create(IDENT21);
            adaptor.addChild(root_0, IDENT21_tree);


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
    // $ANTLR end "cfgAttr"

    public static class deviceDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "deviceDecl"
    // C:\\work\\phdl\\src\\phdl\\PHDL.g:63:1: deviceDecl : 'device' deviceName 'is' attrDecl 'begin' pinDecl 'end' ';' ;
    public final PHDLParser.deviceDecl_return deviceDecl() throws RecognitionException {
        PHDLParser.deviceDecl_return retval = new PHDLParser.deviceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal22=null;
        Token string_literal24=null;
        Token string_literal26=null;
        Token string_literal28=null;
        Token char_literal29=null;
        PHDLParser.deviceName_return deviceName23 = null;

        PHDLParser.attrDecl_return attrDecl25 = null;

        PHDLParser.pinDecl_return pinDecl27 = null;


        CommonTree string_literal22_tree=null;
        CommonTree string_literal24_tree=null;
        CommonTree string_literal26_tree=null;
        CommonTree string_literal28_tree=null;
        CommonTree char_literal29_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:69:2: ( 'device' deviceName 'is' attrDecl 'begin' pinDecl 'end' ';' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:69:4: 'device' deviceName 'is' attrDecl 'begin' pinDecl 'end' ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal22=(Token)match(input,19,FOLLOW_19_in_deviceDecl200); 
            string_literal22_tree = (CommonTree)adaptor.create(string_literal22);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal22_tree, root_0);

            pushFollow(FOLLOW_deviceName_in_deviceDecl203);
            deviceName23=deviceName();

            state._fsp--;

            adaptor.addChild(root_0, deviceName23.getTree());
            string_literal24=(Token)match(input,14,FOLLOW_14_in_deviceDecl205); 
            pushFollow(FOLLOW_attrDecl_in_deviceDecl210);
            attrDecl25=attrDecl();

            state._fsp--;

            adaptor.addChild(root_0, attrDecl25.getTree());
            string_literal26=(Token)match(input,15,FOLLOW_15_in_deviceDecl214); 
            string_literal26_tree = (CommonTree)adaptor.create(string_literal26);
            adaptor.addChild(root_0, string_literal26_tree);

            pushFollow(FOLLOW_pinDecl_in_deviceDecl218);
            pinDecl27=pinDecl();

            state._fsp--;

            adaptor.addChild(root_0, pinDecl27.getTree());
            string_literal28=(Token)match(input,16,FOLLOW_16_in_deviceDecl222); 
            char_literal29=(Token)match(input,17,FOLLOW_17_in_deviceDecl225); 

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

    public static class netDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "netDecl"
    // C:\\work\\phdl\\src\\phdl\\PHDL.g:76:1: netDecl : 'net' ( width )? ( netName ',' )* netName ( ':' ( netAttr ',' )* netAttr )? ';' ;
    public final PHDLParser.netDecl_return netDecl() throws RecognitionException {
        PHDLParser.netDecl_return retval = new PHDLParser.netDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal30=null;
        Token char_literal33=null;
        Token char_literal35=null;
        Token char_literal37=null;
        Token char_literal39=null;
        PHDLParser.width_return width31 = null;

        PHDLParser.netName_return netName32 = null;

        PHDLParser.netName_return netName34 = null;

        PHDLParser.netAttr_return netAttr36 = null;

        PHDLParser.netAttr_return netAttr38 = null;


        CommonTree string_literal30_tree=null;
        CommonTree char_literal33_tree=null;
        CommonTree char_literal35_tree=null;
        CommonTree char_literal37_tree=null;
        CommonTree char_literal39_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:83:2: ( 'net' ( width )? ( netName ',' )* netName ( ':' ( netAttr ',' )* netAttr )? ';' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:83:4: 'net' ( width )? ( netName ',' )* netName ( ':' ( netAttr ',' )* netAttr )? ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal30=(Token)match(input,20,FOLLOW_20_in_netDecl240); 
            string_literal30_tree = (CommonTree)adaptor.create(string_literal30);
            adaptor.addChild(root_0, string_literal30_tree);

            // C:\\work\\phdl\\src\\phdl\\PHDL.g:83:10: ( width )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==23) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\PHDL.g:83:11: width
                    {
                    pushFollow(FOLLOW_width_in_netDecl243);
                    width31=width();

                    state._fsp--;

                    adaptor.addChild(root_0, width31.getTree());

                    }
                    break;

            }

            // C:\\work\\phdl\\src\\phdl\\PHDL.g:83:19: ( netName ',' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==IDENT) ) {
                    int LA5_1 = input.LA(2);

                    if ( (LA5_1==COMMA) ) {
                        alt5=1;
                    }


                }


                switch (alt5) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\PHDL.g:83:20: netName ','
            	    {
            	    pushFollow(FOLLOW_netName_in_netDecl248);
            	    netName32=netName();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netName32.getTree());
            	    char_literal33=(Token)match(input,COMMA,FOLLOW_COMMA_in_netDecl250); 
            	    char_literal33_tree = (CommonTree)adaptor.create(char_literal33);
            	    adaptor.addChild(root_0, char_literal33_tree);


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            pushFollow(FOLLOW_netName_in_netDecl254);
            netName34=netName();

            state._fsp--;

            adaptor.addChild(root_0, netName34.getTree());
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:83:42: ( ':' ( netAttr ',' )* netAttr )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\PHDL.g:83:43: ':' ( netAttr ',' )* netAttr
                    {
                    char_literal35=(Token)match(input,21,FOLLOW_21_in_netDecl257); 
                    char_literal35_tree = (CommonTree)adaptor.create(char_literal35);
                    adaptor.addChild(root_0, char_literal35_tree);

                    // C:\\work\\phdl\\src\\phdl\\PHDL.g:83:47: ( netAttr ',' )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==STRING_LITERAL) ) {
                            int LA6_1 = input.LA(2);

                            if ( (LA6_1==COMMA) ) {
                                alt6=1;
                            }


                        }


                        switch (alt6) {
                    	case 1 :
                    	    // C:\\work\\phdl\\src\\phdl\\PHDL.g:83:48: netAttr ','
                    	    {
                    	    pushFollow(FOLLOW_netAttr_in_netDecl260);
                    	    netAttr36=netAttr();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, netAttr36.getTree());
                    	    char_literal37=(Token)match(input,COMMA,FOLLOW_COMMA_in_netDecl262); 
                    	    char_literal37_tree = (CommonTree)adaptor.create(char_literal37);
                    	    adaptor.addChild(root_0, char_literal37_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    pushFollow(FOLLOW_netAttr_in_netDecl266);
                    netAttr38=netAttr();

                    state._fsp--;

                    adaptor.addChild(root_0, netAttr38.getTree());

                    }
                    break;

            }

            char_literal39=(Token)match(input,17,FOLLOW_17_in_netDecl270); 
            char_literal39_tree = (CommonTree)adaptor.create(char_literal39);
            adaptor.addChild(root_0, char_literal39_tree);


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

    public static class netAttr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "netAttr"
    // C:\\work\\phdl\\src\\phdl\\PHDL.g:87:1: netAttr : STRING_LITERAL ;
    public final PHDLParser.netAttr_return netAttr() throws RecognitionException {
        PHDLParser.netAttr_return retval = new PHDLParser.netAttr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token STRING_LITERAL40=null;

        CommonTree STRING_LITERAL40_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:88:2: ( STRING_LITERAL )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:88:4: STRING_LITERAL
            {
            root_0 = (CommonTree)adaptor.nil();

            STRING_LITERAL40=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_netAttr283); 
            STRING_LITERAL40_tree = (CommonTree)adaptor.create(STRING_LITERAL40);
            adaptor.addChild(root_0, STRING_LITERAL40_tree);


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
    // $ANTLR end "netAttr"

    public static class attrDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attrDecl"
    // C:\\work\\phdl\\src\\phdl\\PHDL.g:91:1: attrDecl : ( attrAssignment )* ;
    public final PHDLParser.attrDecl_return attrDecl() throws RecognitionException {
        PHDLParser.attrDecl_return retval = new PHDLParser.attrDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        PHDLParser.attrAssignment_return attrAssignment41 = null;



        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:92:2: ( ( attrAssignment )* )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:92:4: ( attrAssignment )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\work\\phdl\\src\\phdl\\PHDL.g:92:4: ( attrAssignment )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==IDENT) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\PHDL.g:92:4: attrAssignment
            	    {
            	    pushFollow(FOLLOW_attrAssignment_in_attrDecl295);
            	    attrAssignment41=attrAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attrAssignment41.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
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
    // $ANTLR end "attrDecl"

    public static class pinDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pinDecl"
    // C:\\work\\phdl\\src\\phdl\\PHDL.g:95:1: pinDecl : ( ( type ( width )? ( pinName ',' )* pinName )+ '=' pinNumberList ';' )* ;
    public final PHDLParser.pinDecl_return pinDecl() throws RecognitionException {
        PHDLParser.pinDecl_return retval = new PHDLParser.pinDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal45=null;
        Token char_literal47=null;
        Token char_literal49=null;
        PHDLParser.type_return type42 = null;

        PHDLParser.width_return width43 = null;

        PHDLParser.pinName_return pinName44 = null;

        PHDLParser.pinName_return pinName46 = null;

        PHDLParser.pinNumberList_return pinNumberList48 = null;


        CommonTree char_literal45_tree=null;
        CommonTree char_literal47_tree=null;
        CommonTree char_literal49_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:96:2: ( ( ( type ( width )? ( pinName ',' )* pinName )+ '=' pinNumberList ';' )* )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:96:4: ( ( type ( width )? ( pinName ',' )* pinName )+ '=' pinNumberList ';' )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\work\\phdl\\src\\phdl\\PHDL.g:96:4: ( ( type ( width )? ( pinName ',' )* pinName )+ '=' pinNumberList ';' )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=27 && LA12_0<=34)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\PHDL.g:96:5: ( type ( width )? ( pinName ',' )* pinName )+ '=' pinNumberList ';'
            	    {
            	    // C:\\work\\phdl\\src\\phdl\\PHDL.g:96:5: ( type ( width )? ( pinName ',' )* pinName )+
            	    int cnt11=0;
            	    loop11:
            	    do {
            	        int alt11=2;
            	        int LA11_0 = input.LA(1);

            	        if ( ((LA11_0>=27 && LA11_0<=34)) ) {
            	            alt11=1;
            	        }


            	        switch (alt11) {
            	    	case 1 :
            	    	    // C:\\work\\phdl\\src\\phdl\\PHDL.g:96:6: type ( width )? ( pinName ',' )* pinName
            	    	    {
            	    	    pushFollow(FOLLOW_type_in_pinDecl309);
            	    	    type42=type();

            	    	    state._fsp--;

            	    	    adaptor.addChild(root_0, type42.getTree());
            	    	    // C:\\work\\phdl\\src\\phdl\\PHDL.g:96:11: ( width )?
            	    	    int alt9=2;
            	    	    int LA9_0 = input.LA(1);

            	    	    if ( (LA9_0==23) ) {
            	    	        alt9=1;
            	    	    }
            	    	    switch (alt9) {
            	    	        case 1 :
            	    	            // C:\\work\\phdl\\src\\phdl\\PHDL.g:96:11: width
            	    	            {
            	    	            pushFollow(FOLLOW_width_in_pinDecl311);
            	    	            width43=width();

            	    	            state._fsp--;

            	    	            adaptor.addChild(root_0, width43.getTree());

            	    	            }
            	    	            break;

            	    	    }

            	    	    // C:\\work\\phdl\\src\\phdl\\PHDL.g:96:18: ( pinName ',' )*
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
            	    	    	    // C:\\work\\phdl\\src\\phdl\\PHDL.g:96:19: pinName ','
            	    	    	    {
            	    	    	    pushFollow(FOLLOW_pinName_in_pinDecl315);
            	    	    	    pinName44=pinName();

            	    	    	    state._fsp--;

            	    	    	    adaptor.addChild(root_0, pinName44.getTree());
            	    	    	    char_literal45=(Token)match(input,COMMA,FOLLOW_COMMA_in_pinDecl317); 
            	    	    	    char_literal45_tree = (CommonTree)adaptor.create(char_literal45);
            	    	    	    adaptor.addChild(root_0, char_literal45_tree);


            	    	    	    }
            	    	    	    break;

            	    	    	default :
            	    	    	    break loop10;
            	    	        }
            	    	    } while (true);

            	    	    pushFollow(FOLLOW_pinName_in_pinDecl321);
            	    	    pinName46=pinName();

            	    	    state._fsp--;

            	    	    adaptor.addChild(root_0, pinName46.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt11 >= 1 ) break loop11;
            	                EarlyExitException eee =
            	                    new EarlyExitException(11, input);
            	                throw eee;
            	        }
            	        cnt11++;
            	    } while (true);

            	    char_literal47=(Token)match(input,22,FOLLOW_22_in_pinDecl325); 
            	    pushFollow(FOLLOW_pinNumberList_in_pinDecl328);
            	    pinNumberList48=pinNumberList();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinNumberList48.getTree());
            	    char_literal49=(Token)match(input,17,FOLLOW_17_in_pinDecl330); 

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
    // $ANTLR end "pinDecl"

    public static class pinNumberList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pinNumberList"
    // C:\\work\\phdl\\src\\phdl\\PHDL.g:99:1: pinNumberList : STRING_LITERAL ;
    public final PHDLParser.pinNumberList_return pinNumberList() throws RecognitionException {
        PHDLParser.pinNumberList_return retval = new PHDLParser.pinNumberList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token STRING_LITERAL50=null;

        CommonTree STRING_LITERAL50_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:100:2: ( STRING_LITERAL )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:100:4: STRING_LITERAL
            {
            root_0 = (CommonTree)adaptor.nil();

            STRING_LITERAL50=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_pinNumberList345); 
            STRING_LITERAL50_tree = (CommonTree)adaptor.create(STRING_LITERAL50);
            adaptor.addChild(root_0, STRING_LITERAL50_tree);


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
    // $ANTLR end "pinNumberList"

    public static class width_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "width"
    // C:\\work\\phdl\\src\\phdl\\PHDL.g:103:1: width : '[' msb ( ':' lsb )? ']' ;
    public final PHDLParser.width_return width() throws RecognitionException {
        PHDLParser.width_return retval = new PHDLParser.width_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal51=null;
        Token char_literal53=null;
        Token char_literal55=null;
        PHDLParser.msb_return msb52 = null;

        PHDLParser.lsb_return lsb54 = null;


        CommonTree char_literal51_tree=null;
        CommonTree char_literal53_tree=null;
        CommonTree char_literal55_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:104:2: ( '[' msb ( ':' lsb )? ']' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:104:4: '[' msb ( ':' lsb )? ']'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal51=(Token)match(input,23,FOLLOW_23_in_width357); 
            pushFollow(FOLLOW_msb_in_width360);
            msb52=msb();

            state._fsp--;

            adaptor.addChild(root_0, msb52.getTree());
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:104:13: ( ':' lsb )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==21) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\PHDL.g:104:14: ':' lsb
                    {
                    char_literal53=(Token)match(input,21,FOLLOW_21_in_width363); 
                    pushFollow(FOLLOW_lsb_in_width366);
                    lsb54=lsb();

                    state._fsp--;

                    adaptor.addChild(root_0, lsb54.getTree());

                    }
                    break;

            }

            char_literal55=(Token)match(input,24,FOLLOW_24_in_width370); 

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

    public static class element_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "element"
    // C:\\work\\phdl\\src\\phdl\\PHDL.g:107:1: element : INT ;
    public final PHDLParser.element_return element() throws RecognitionException {
        PHDLParser.element_return retval = new PHDLParser.element_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INT56=null;

        CommonTree INT56_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:108:2: ( INT )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:108:4: INT
            {
            root_0 = (CommonTree)adaptor.nil();

            INT56=(Token)match(input,INT,FOLLOW_INT_in_element383); 
            INT56_tree = (CommonTree)adaptor.create(INT56);
            adaptor.addChild(root_0, INT56_tree);


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
    // $ANTLR end "element"

    public static class msb_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "msb"
    // C:\\work\\phdl\\src\\phdl\\PHDL.g:111:1: msb : INT ;
    public final PHDLParser.msb_return msb() throws RecognitionException {
        PHDLParser.msb_return retval = new PHDLParser.msb_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INT57=null;

        CommonTree INT57_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:112:2: ( INT )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:112:5: INT
            {
            root_0 = (CommonTree)adaptor.nil();

            INT57=(Token)match(input,INT,FOLLOW_INT_in_msb396); 
            INT57_tree = (CommonTree)adaptor.create(INT57);
            adaptor.addChild(root_0, INT57_tree);


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
    // $ANTLR end "msb"

    public static class lsb_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "lsb"
    // C:\\work\\phdl\\src\\phdl\\PHDL.g:115:1: lsb : INT ;
    public final PHDLParser.lsb_return lsb() throws RecognitionException {
        PHDLParser.lsb_return retval = new PHDLParser.lsb_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INT58=null;

        CommonTree INT58_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:116:2: ( INT )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:116:4: INT
            {
            root_0 = (CommonTree)adaptor.nil();

            INT58=(Token)match(input,INT,FOLLOW_INT_in_lsb408); 
            INT58_tree = (CommonTree)adaptor.create(INT58);
            adaptor.addChild(root_0, INT58_tree);


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
    // $ANTLR end "lsb"

    public static class netName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "netName"
    // C:\\work\\phdl\\src\\phdl\\PHDL.g:119:1: netName : IDENT ;
    public final PHDLParser.netName_return netName() throws RecognitionException {
        PHDLParser.netName_return retval = new PHDLParser.netName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT59=null;

        CommonTree IDENT59_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:120:2: ( IDENT )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:120:4: IDENT
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT59=(Token)match(input,IDENT,FOLLOW_IDENT_in_netName420); 
            IDENT59_tree = (CommonTree)adaptor.create(IDENT59);
            adaptor.addChild(root_0, IDENT59_tree);


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
    // $ANTLR end "netName"

    public static class instantiations_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "instantiations"
    // C:\\work\\phdl\\src\\phdl\\PHDL.g:124:1: instantiations : ( instance | subSch | netAssignment )* ;
    public final PHDLParser.instantiations_return instantiations() throws RecognitionException {
        PHDLParser.instantiations_return retval = new PHDLParser.instantiations_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        PHDLParser.instance_return instance60 = null;

        PHDLParser.subSch_return subSch61 = null;

        PHDLParser.netAssignment_return netAssignment62 = null;



        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:125:2: ( ( instance | subSch | netAssignment )* )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:125:4: ( instance | subSch | netAssignment )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\work\\phdl\\src\\phdl\\PHDL.g:125:4: ( instance | subSch | netAssignment )*
            loop14:
            do {
                int alt14=4;
                switch ( input.LA(1) ) {
                case 25:
                    {
                    alt14=1;
                    }
                    break;
                case 26:
                    {
                    alt14=2;
                    }
                    break;
                case IDENT:
                    {
                    alt14=3;
                    }
                    break;

                }

                switch (alt14) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\PHDL.g:125:5: instance
            	    {
            	    pushFollow(FOLLOW_instance_in_instantiations434);
            	    instance60=instance();

            	    state._fsp--;

            	    adaptor.addChild(root_0, instance60.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\phdl\\src\\phdl\\PHDL.g:125:16: subSch
            	    {
            	    pushFollow(FOLLOW_subSch_in_instantiations438);
            	    subSch61=subSch();

            	    state._fsp--;

            	    adaptor.addChild(root_0, subSch61.getTree());

            	    }
            	    break;
            	case 3 :
            	    // C:\\work\\phdl\\src\\phdl\\PHDL.g:125:25: netAssignment
            	    {
            	    pushFollow(FOLLOW_netAssignment_in_instantiations442);
            	    netAssignment62=netAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netAssignment62.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
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
    // $ANTLR end "instantiations"

    public static class instance_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "instance"
    // C:\\work\\phdl\\src\\phdl\\PHDL.g:128:1: instance : 'inst' instanceName ':' deviceName ( width )? 'is' ( attrAssignment )* 'begin' ( pinAssignment )* 'end' ';' ;
    public final PHDLParser.instance_return instance() throws RecognitionException {
        PHDLParser.instance_return retval = new PHDLParser.instance_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal63=null;
        Token char_literal65=null;
        Token string_literal68=null;
        Token string_literal70=null;
        Token string_literal72=null;
        Token char_literal73=null;
        PHDLParser.instanceName_return instanceName64 = null;

        PHDLParser.deviceName_return deviceName66 = null;

        PHDLParser.width_return width67 = null;

        PHDLParser.attrAssignment_return attrAssignment69 = null;

        PHDLParser.pinAssignment_return pinAssignment71 = null;


        CommonTree string_literal63_tree=null;
        CommonTree char_literal65_tree=null;
        CommonTree string_literal68_tree=null;
        CommonTree string_literal70_tree=null;
        CommonTree string_literal72_tree=null;
        CommonTree char_literal73_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:129:2: ( 'inst' instanceName ':' deviceName ( width )? 'is' ( attrAssignment )* 'begin' ( pinAssignment )* 'end' ';' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:129:4: 'inst' instanceName ':' deviceName ( width )? 'is' ( attrAssignment )* 'begin' ( pinAssignment )* 'end' ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal63=(Token)match(input,25,FOLLOW_25_in_instance456); 
            string_literal63_tree = (CommonTree)adaptor.create(string_literal63);
            adaptor.addChild(root_0, string_literal63_tree);

            pushFollow(FOLLOW_instanceName_in_instance458);
            instanceName64=instanceName();

            state._fsp--;

            adaptor.addChild(root_0, instanceName64.getTree());
            char_literal65=(Token)match(input,21,FOLLOW_21_in_instance460); 
            char_literal65_tree = (CommonTree)adaptor.create(char_literal65);
            adaptor.addChild(root_0, char_literal65_tree);

            pushFollow(FOLLOW_deviceName_in_instance462);
            deviceName66=deviceName();

            state._fsp--;

            adaptor.addChild(root_0, deviceName66.getTree());
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:129:39: ( width )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==23) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\PHDL.g:129:40: width
                    {
                    pushFollow(FOLLOW_width_in_instance465);
                    width67=width();

                    state._fsp--;

                    adaptor.addChild(root_0, width67.getTree());

                    }
                    break;

            }

            string_literal68=(Token)match(input,14,FOLLOW_14_in_instance469); 
            string_literal68_tree = (CommonTree)adaptor.create(string_literal68);
            adaptor.addChild(root_0, string_literal68_tree);

            // C:\\work\\phdl\\src\\phdl\\PHDL.g:130:3: ( attrAssignment )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==IDENT) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\PHDL.g:130:4: attrAssignment
            	    {
            	    pushFollow(FOLLOW_attrAssignment_in_instance474);
            	    attrAssignment69=attrAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attrAssignment69.getTree());

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            string_literal70=(Token)match(input,15,FOLLOW_15_in_instance480); 
            string_literal70_tree = (CommonTree)adaptor.create(string_literal70);
            adaptor.addChild(root_0, string_literal70_tree);

            // C:\\work\\phdl\\src\\phdl\\PHDL.g:132:3: ( pinAssignment )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==IDENT) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\PHDL.g:132:4: pinAssignment
            	    {
            	    pushFollow(FOLLOW_pinAssignment_in_instance485);
            	    pinAssignment71=pinAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinAssignment71.getTree());

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            string_literal72=(Token)match(input,16,FOLLOW_16_in_instance491); 
            string_literal72_tree = (CommonTree)adaptor.create(string_literal72);
            adaptor.addChild(root_0, string_literal72_tree);

            char_literal73=(Token)match(input,17,FOLLOW_17_in_instance493); 
            char_literal73_tree = (CommonTree)adaptor.create(char_literal73);
            adaptor.addChild(root_0, char_literal73_tree);


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
    // $ANTLR end "instance"

    public static class subSch_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subSch"
    // C:\\work\\phdl\\src\\phdl\\PHDL.g:136:1: subSch : 'subSch' subSchInstanceName ':' subSchName ( width )? 'is' ( attrAssignment )* 'begin' ( pinAssignment )* 'end' ';' ;
    public final PHDLParser.subSch_return subSch() throws RecognitionException {
        PHDLParser.subSch_return retval = new PHDLParser.subSch_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal74=null;
        Token char_literal76=null;
        Token string_literal79=null;
        Token string_literal81=null;
        Token string_literal83=null;
        Token char_literal84=null;
        PHDLParser.subSchInstanceName_return subSchInstanceName75 = null;

        PHDLParser.subSchName_return subSchName77 = null;

        PHDLParser.width_return width78 = null;

        PHDLParser.attrAssignment_return attrAssignment80 = null;

        PHDLParser.pinAssignment_return pinAssignment82 = null;


        CommonTree string_literal74_tree=null;
        CommonTree char_literal76_tree=null;
        CommonTree string_literal79_tree=null;
        CommonTree string_literal81_tree=null;
        CommonTree string_literal83_tree=null;
        CommonTree char_literal84_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:137:2: ( 'subSch' subSchInstanceName ':' subSchName ( width )? 'is' ( attrAssignment )* 'begin' ( pinAssignment )* 'end' ';' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:137:4: 'subSch' subSchInstanceName ':' subSchName ( width )? 'is' ( attrAssignment )* 'begin' ( pinAssignment )* 'end' ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal74=(Token)match(input,26,FOLLOW_26_in_subSch505); 
            string_literal74_tree = (CommonTree)adaptor.create(string_literal74);
            adaptor.addChild(root_0, string_literal74_tree);

            pushFollow(FOLLOW_subSchInstanceName_in_subSch507);
            subSchInstanceName75=subSchInstanceName();

            state._fsp--;

            adaptor.addChild(root_0, subSchInstanceName75.getTree());
            char_literal76=(Token)match(input,21,FOLLOW_21_in_subSch509); 
            char_literal76_tree = (CommonTree)adaptor.create(char_literal76);
            adaptor.addChild(root_0, char_literal76_tree);

            pushFollow(FOLLOW_subSchName_in_subSch511);
            subSchName77=subSchName();

            state._fsp--;

            adaptor.addChild(root_0, subSchName77.getTree());
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:137:47: ( width )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==23) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\PHDL.g:137:48: width
                    {
                    pushFollow(FOLLOW_width_in_subSch514);
                    width78=width();

                    state._fsp--;

                    adaptor.addChild(root_0, width78.getTree());

                    }
                    break;

            }

            string_literal79=(Token)match(input,14,FOLLOW_14_in_subSch518); 
            string_literal79_tree = (CommonTree)adaptor.create(string_literal79);
            adaptor.addChild(root_0, string_literal79_tree);

            // C:\\work\\phdl\\src\\phdl\\PHDL.g:138:3: ( attrAssignment )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==IDENT) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\PHDL.g:138:4: attrAssignment
            	    {
            	    pushFollow(FOLLOW_attrAssignment_in_subSch523);
            	    attrAssignment80=attrAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attrAssignment80.getTree());

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            string_literal81=(Token)match(input,15,FOLLOW_15_in_subSch529); 
            string_literal81_tree = (CommonTree)adaptor.create(string_literal81);
            adaptor.addChild(root_0, string_literal81_tree);

            // C:\\work\\phdl\\src\\phdl\\PHDL.g:140:3: ( pinAssignment )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==IDENT) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\PHDL.g:140:4: pinAssignment
            	    {
            	    pushFollow(FOLLOW_pinAssignment_in_subSch534);
            	    pinAssignment82=pinAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinAssignment82.getTree());

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            string_literal83=(Token)match(input,16,FOLLOW_16_in_subSch540); 
            string_literal83_tree = (CommonTree)adaptor.create(string_literal83);
            adaptor.addChild(root_0, string_literal83_tree);

            char_literal84=(Token)match(input,17,FOLLOW_17_in_subSch542); 
            char_literal84_tree = (CommonTree)adaptor.create(char_literal84);
            adaptor.addChild(root_0, char_literal84_tree);


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
    // $ANTLR end "subSch"

    public static class subSchInstanceName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subSchInstanceName"
    // C:\\work\\phdl\\src\\phdl\\PHDL.g:144:1: subSchInstanceName : IDENT ;
    public final PHDLParser.subSchInstanceName_return subSchInstanceName() throws RecognitionException {
        PHDLParser.subSchInstanceName_return retval = new PHDLParser.subSchInstanceName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT85=null;

        CommonTree IDENT85_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:145:2: ( IDENT )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:145:4: IDENT
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT85=(Token)match(input,IDENT,FOLLOW_IDENT_in_subSchInstanceName554); 
            IDENT85_tree = (CommonTree)adaptor.create(IDENT85);
            adaptor.addChild(root_0, IDENT85_tree);


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
    // $ANTLR end "subSchInstanceName"

    public static class subSchName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subSchName"
    // C:\\work\\phdl\\src\\phdl\\PHDL.g:148:1: subSchName : IDENT ;
    public final PHDLParser.subSchName_return subSchName() throws RecognitionException {
        PHDLParser.subSchName_return retval = new PHDLParser.subSchName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT86=null;

        CommonTree IDENT86_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:149:2: ( IDENT )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:149:4: IDENT
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT86=(Token)match(input,IDENT,FOLLOW_IDENT_in_subSchName565); 
            IDENT86_tree = (CommonTree)adaptor.create(IDENT86);
            adaptor.addChild(root_0, IDENT86_tree);


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
    // $ANTLR end "subSchName"

    public static class instanceName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "instanceName"
    // C:\\work\\phdl\\src\\phdl\\PHDL.g:152:1: instanceName : IDENT ;
    public final PHDLParser.instanceName_return instanceName() throws RecognitionException {
        PHDLParser.instanceName_return retval = new PHDLParser.instanceName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT87=null;

        CommonTree IDENT87_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:153:2: ( IDENT )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:153:4: IDENT
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT87=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceName576); 
            IDENT87_tree = (CommonTree)adaptor.create(IDENT87);
            adaptor.addChild(root_0, IDENT87_tree);


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
    // $ANTLR end "instanceName"

    public static class deviceName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "deviceName"
    // C:\\work\\phdl\\src\\phdl\\PHDL.g:156:1: deviceName : IDENT ;
    public final PHDLParser.deviceName_return deviceName() throws RecognitionException {
        PHDLParser.deviceName_return retval = new PHDLParser.deviceName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT88=null;

        CommonTree IDENT88_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:157:2: ( IDENT )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:157:4: IDENT
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT88=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceName588); 
            IDENT88_tree = (CommonTree)adaptor.create(IDENT88);
            adaptor.addChild(root_0, IDENT88_tree);


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
    // $ANTLR end "deviceName"

    public static class pinName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pinName"
    // C:\\work\\phdl\\src\\phdl\\PHDL.g:160:1: pinName : IDENT ;
    public final PHDLParser.pinName_return pinName() throws RecognitionException {
        PHDLParser.pinName_return retval = new PHDLParser.pinName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT89=null;

        CommonTree IDENT89_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:161:2: ( IDENT )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:161:4: IDENT
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT89=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinName599); 
            IDENT89_tree = (CommonTree)adaptor.create(IDENT89);
            adaptor.addChild(root_0, IDENT89_tree);


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
    // $ANTLR end "pinName"

    public static class type_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type"
    // C:\\work\\phdl\\src\\phdl\\PHDL.g:164:1: type : ( 'in' | 'out' | 'inout' | 'pass' | 'sup' | 'pwr' | 'open' | 'pin' );
    public final PHDLParser.type_return type() throws RecognitionException {
        PHDLParser.type_return retval = new PHDLParser.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set90=null;

        CommonTree set90_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:165:2: ( 'in' | 'out' | 'inout' | 'pass' | 'sup' | 'pwr' | 'open' | 'pin' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set90=(Token)input.LT(1);
            if ( (input.LA(1)>=27 && input.LA(1)<=34) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set90));
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

    public static class pinAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pinAssignment"
    // C:\\work\\phdl\\src\\phdl\\PHDL.g:175:1: pinAssignment : pinName ( width )? '=' ( ( netName ( width )? ) | 'open' ) ';' ;
    public final PHDLParser.pinAssignment_return pinAssignment() throws RecognitionException {
        PHDLParser.pinAssignment_return retval = new PHDLParser.pinAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal93=null;
        Token string_literal96=null;
        Token char_literal97=null;
        PHDLParser.pinName_return pinName91 = null;

        PHDLParser.width_return width92 = null;

        PHDLParser.netName_return netName94 = null;

        PHDLParser.width_return width95 = null;


        CommonTree char_literal93_tree=null;
        CommonTree string_literal96_tree=null;
        CommonTree char_literal97_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:176:2: ( pinName ( width )? '=' ( ( netName ( width )? ) | 'open' ) ';' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:176:4: pinName ( width )? '=' ( ( netName ( width )? ) | 'open' ) ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_pinName_in_pinAssignment658);
            pinName91=pinName();

            state._fsp--;

            adaptor.addChild(root_0, pinName91.getTree());
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:176:12: ( width )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==23) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\PHDL.g:176:13: width
                    {
                    pushFollow(FOLLOW_width_in_pinAssignment661);
                    width92=width();

                    state._fsp--;

                    adaptor.addChild(root_0, width92.getTree());

                    }
                    break;

            }

            char_literal93=(Token)match(input,22,FOLLOW_22_in_pinAssignment665); 
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:176:26: ( ( netName ( width )? ) | 'open' )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==IDENT) ) {
                alt23=1;
            }
            else if ( (LA23_0==33) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\PHDL.g:176:27: ( netName ( width )? )
                    {
                    // C:\\work\\phdl\\src\\phdl\\PHDL.g:176:27: ( netName ( width )? )
                    // C:\\work\\phdl\\src\\phdl\\PHDL.g:176:28: netName ( width )?
                    {
                    pushFollow(FOLLOW_netName_in_pinAssignment670);
                    netName94=netName();

                    state._fsp--;

                    adaptor.addChild(root_0, netName94.getTree());
                    // C:\\work\\phdl\\src\\phdl\\PHDL.g:176:36: ( width )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==23) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // C:\\work\\phdl\\src\\phdl\\PHDL.g:176:37: width
                            {
                            pushFollow(FOLLOW_width_in_pinAssignment673);
                            width95=width();

                            state._fsp--;

                            adaptor.addChild(root_0, width95.getTree());

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // C:\\work\\phdl\\src\\phdl\\PHDL.g:176:48: 'open'
                    {
                    string_literal96=(Token)match(input,33,FOLLOW_33_in_pinAssignment680); 
                    string_literal96_tree = (CommonTree)adaptor.create(string_literal96);
                    adaptor.addChild(root_0, string_literal96_tree);


                    }
                    break;

            }

            char_literal97=(Token)match(input,17,FOLLOW_17_in_pinAssignment683); 

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
    // C:\\work\\phdl\\src\\phdl\\PHDL.g:179:1: netAssignment : netName ( width )? '=' netName ( width )? ';' ;
    public final PHDLParser.netAssignment_return netAssignment() throws RecognitionException {
        PHDLParser.netAssignment_return retval = new PHDLParser.netAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal100=null;
        Token char_literal103=null;
        PHDLParser.netName_return netName98 = null;

        PHDLParser.width_return width99 = null;

        PHDLParser.netName_return netName101 = null;

        PHDLParser.width_return width102 = null;


        CommonTree char_literal100_tree=null;
        CommonTree char_literal103_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:180:2: ( netName ( width )? '=' netName ( width )? ';' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:180:4: netName ( width )? '=' netName ( width )? ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_netName_in_netAssignment696);
            netName98=netName();

            state._fsp--;

            adaptor.addChild(root_0, netName98.getTree());
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:180:12: ( width )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==23) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\PHDL.g:180:13: width
                    {
                    pushFollow(FOLLOW_width_in_netAssignment699);
                    width99=width();

                    state._fsp--;

                    adaptor.addChild(root_0, width99.getTree());

                    }
                    break;

            }

            char_literal100=(Token)match(input,22,FOLLOW_22_in_netAssignment703); 
            pushFollow(FOLLOW_netName_in_netAssignment706);
            netName101=netName();

            state._fsp--;

            adaptor.addChild(root_0, netName101.getTree());
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:180:34: ( width )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==23) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\PHDL.g:180:35: width
                    {
                    pushFollow(FOLLOW_width_in_netAssignment709);
                    width102=width();

                    state._fsp--;

                    adaptor.addChild(root_0, width102.getTree());

                    }
                    break;

            }

            char_literal103=(Token)match(input,17,FOLLOW_17_in_netAssignment713); 

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

    public static class attrAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attrAssignment"
    // C:\\work\\phdl\\src\\phdl\\PHDL.g:183:1: attrAssignment : attrName ( width )? '=' attrValue ';' ;
    public final PHDLParser.attrAssignment_return attrAssignment() throws RecognitionException {
        PHDLParser.attrAssignment_return retval = new PHDLParser.attrAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal106=null;
        Token char_literal108=null;
        PHDLParser.attrName_return attrName104 = null;

        PHDLParser.width_return width105 = null;

        PHDLParser.attrValue_return attrValue107 = null;


        CommonTree char_literal106_tree=null;
        CommonTree char_literal108_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:184:2: ( attrName ( width )? '=' attrValue ';' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:184:4: attrName ( width )? '=' attrValue ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_attrName_in_attrAssignment726);
            attrName104=attrName();

            state._fsp--;

            adaptor.addChild(root_0, attrName104.getTree());
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:184:13: ( width )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==23) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\PHDL.g:184:14: width
                    {
                    pushFollow(FOLLOW_width_in_attrAssignment729);
                    width105=width();

                    state._fsp--;

                    adaptor.addChild(root_0, width105.getTree());

                    }
                    break;

            }

            char_literal106=(Token)match(input,22,FOLLOW_22_in_attrAssignment733); 
            char_literal106_tree = (CommonTree)adaptor.create(char_literal106);
            root_0 = (CommonTree)adaptor.becomeRoot(char_literal106_tree, root_0);

            pushFollow(FOLLOW_attrValue_in_attrAssignment736);
            attrValue107=attrValue();

            state._fsp--;

            adaptor.addChild(root_0, attrValue107.getTree());
            char_literal108=(Token)match(input,17,FOLLOW_17_in_attrAssignment738); 

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
    // $ANTLR end "attrAssignment"

    public static class attrName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attrName"
    // C:\\work\\phdl\\src\\phdl\\PHDL.g:187:1: attrName : IDENT ;
    public final PHDLParser.attrName_return attrName() throws RecognitionException {
        PHDLParser.attrName_return retval = new PHDLParser.attrName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT109=null;

        CommonTree IDENT109_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:188:2: ( IDENT )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:188:4: IDENT
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT109=(Token)match(input,IDENT,FOLLOW_IDENT_in_attrName751); 
            IDENT109_tree = (CommonTree)adaptor.create(IDENT109);
            adaptor.addChild(root_0, IDENT109_tree);


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
    // $ANTLR end "attrName"

    public static class attrValue_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attrValue"
    // C:\\work\\phdl\\src\\phdl\\PHDL.g:191:1: attrValue : STRING_LITERAL ;
    public final PHDLParser.attrValue_return attrValue() throws RecognitionException {
        PHDLParser.attrValue_return retval = new PHDLParser.attrValue_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token STRING_LITERAL110=null;

        CommonTree STRING_LITERAL110_tree=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:192:2: ( STRING_LITERAL )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:192:4: STRING_LITERAL
            {
            root_0 = (CommonTree)adaptor.nil();

            STRING_LITERAL110=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_attrValue763); 
            STRING_LITERAL110_tree = (CommonTree)adaptor.create(STRING_LITERAL110);
            adaptor.addChild(root_0, STRING_LITERAL110_tree);


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
    // $ANTLR end "attrValue"

    // Delegated rules


 

    public static final BitSet FOLLOW_design_in_sourceText61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_sourceText65 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_design79 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_design82 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_design84 = new BitSet(new long[]{0x0000000000188000L});
    public static final BitSet FOLLOW_deviceDecl_in_design93 = new BitSet(new long[]{0x0000000000188000L});
    public static final BitSet FOLLOW_netDecl_in_design97 = new BitSet(new long[]{0x0000000000188000L});
    public static final BitSet FOLLOW_15_in_design103 = new BitSet(new long[]{0x0000000006010010L});
    public static final BitSet FOLLOW_instantiations_in_design107 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_design111 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_design114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_configuration129 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_cfgName_in_configuration132 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_configuration134 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_cfgAttr_in_configuration141 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COMMA_in_configuration143 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_cfgAttr_in_configuration148 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_16_in_configuration154 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_configuration157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_cfgName172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_cfgAttr186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_deviceDecl200 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_deviceName_in_deviceDecl203 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_deviceDecl205 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_attrDecl_in_deviceDecl210 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_deviceDecl214 = new BitSet(new long[]{0x00000007F8010000L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl218 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_deviceDecl222 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_deviceDecl225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_netDecl240 = new BitSet(new long[]{0x0000000006800010L});
    public static final BitSet FOLLOW_width_in_netDecl243 = new BitSet(new long[]{0x0000000006000010L});
    public static final BitSet FOLLOW_netName_in_netDecl248 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COMMA_in_netDecl250 = new BitSet(new long[]{0x0000000006000010L});
    public static final BitSet FOLLOW_netName_in_netDecl254 = new BitSet(new long[]{0x0000000000220000L});
    public static final BitSet FOLLOW_21_in_netDecl257 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_netAttr_in_netDecl260 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COMMA_in_netDecl262 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_netAttr_in_netDecl266 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_netDecl270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_netAttr283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attrAssignment_in_attrDecl295 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_type_in_pinDecl309 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_width_in_pinDecl311 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_pinName_in_pinDecl315 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COMMA_in_pinDecl317 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_pinName_in_pinDecl321 = new BitSet(new long[]{0x00000007F8400000L});
    public static final BitSet FOLLOW_22_in_pinDecl325 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_pinNumberList_in_pinDecl328 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_pinDecl330 = new BitSet(new long[]{0x00000007F8000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_pinNumberList345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_width357 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_msb_in_width360 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_21_in_width363 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_lsb_in_width366 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_width370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_element383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_msb396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_lsb408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_netName420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instance_in_instantiations434 = new BitSet(new long[]{0x0000000006000012L});
    public static final BitSet FOLLOW_subSch_in_instantiations438 = new BitSet(new long[]{0x0000000006000012L});
    public static final BitSet FOLLOW_netAssignment_in_instantiations442 = new BitSet(new long[]{0x0000000006000012L});
    public static final BitSet FOLLOW_25_in_instance456 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_instanceName_in_instance458 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_instance460 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_deviceName_in_instance462 = new BitSet(new long[]{0x0000000000804000L});
    public static final BitSet FOLLOW_width_in_instance465 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_instance469 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_attrAssignment_in_instance474 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_15_in_instance480 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_pinAssignment_in_instance485 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_16_in_instance491 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_instance493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_subSch505 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_subSchInstanceName_in_subSch507 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_subSch509 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_subSchName_in_subSch511 = new BitSet(new long[]{0x0000000000804000L});
    public static final BitSet FOLLOW_width_in_subSch514 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_subSch518 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_attrAssignment_in_subSch523 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_15_in_subSch529 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_pinAssignment_in_subSch534 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_16_in_subSch540 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_subSch542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_subSchInstanceName554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_subSchName565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_instanceName576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_deviceName588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_pinName599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pinName_in_pinAssignment658 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_width_in_pinAssignment661 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_pinAssignment665 = new BitSet(new long[]{0x0000000206000010L});
    public static final BitSet FOLLOW_netName_in_pinAssignment670 = new BitSet(new long[]{0x0000000000820000L});
    public static final BitSet FOLLOW_width_in_pinAssignment673 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_33_in_pinAssignment680 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_pinAssignment683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_netName_in_netAssignment696 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_width_in_netAssignment699 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_netAssignment703 = new BitSet(new long[]{0x0000000006000010L});
    public static final BitSet FOLLOW_netName_in_netAssignment706 = new BitSet(new long[]{0x0000000000820000L});
    public static final BitSet FOLLOW_width_in_netAssignment709 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_netAssignment713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attrName_in_attrAssignment726 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_width_in_attrAssignment729 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_attrAssignment733 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_attrValue_in_attrAssignment736 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_attrAssignment738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_attrName751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_attrValue763 = new BitSet(new long[]{0x0000000000000002L});

}