// $ANTLR 3.3 Nov 30, 2010 12:50:56 /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g 2012-01-04 12:01:23

/*
    Copyright (C) 2011  Brigham Young University

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, version 3.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "LEFTBRACE", "RIGHTBRACE", "SEMICOLON", "EQUALS", "STRING", "COMMA", "LEFTPAREN", "RIGHTPAREN", "PERIOD", "AMPERSAND", "LEFTANGLE", "RIGHTANGLE", "INTEGER", "LEFTBRACKET", "COLON", "RIGHTBRACKET", "CHAR", "DIGIT", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "INCLUDE", "'design'", "'port'", "'device'", "'attr'", "'pin'", "'net'", "'inst'", "'of'", "'sub'", "'combine'", "'newattr'", "'this'", "'info'", "'group'", "'open'"
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
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int IDENT=4;
    public static final int LEFTBRACE=5;
    public static final int RIGHTBRACE=6;
    public static final int SEMICOLON=7;
    public static final int EQUALS=8;
    public static final int STRING=9;
    public static final int COMMA=10;
    public static final int LEFTPAREN=11;
    public static final int RIGHTPAREN=12;
    public static final int PERIOD=13;
    public static final int AMPERSAND=14;
    public static final int LEFTANGLE=15;
    public static final int RIGHTANGLE=16;
    public static final int INTEGER=17;
    public static final int LEFTBRACKET=18;
    public static final int COLON=19;
    public static final int RIGHTBRACKET=20;
    public static final int CHAR=21;
    public static final int DIGIT=22;
    public static final int WHITESPACE=23;
    public static final int LINE_COMMENT=24;
    public static final int MULTILINE_COMMENT=25;
    public static final int INCLUDE=26;

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
    public String getGrammarFileName() { return "/fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g"; }



    	/**
    	 * The list of errors retrived after parsing to report
    	 */
    	private List<String> errors = new ArrayList<String>();

    	/**
    	 * Overriding this method allows the parser to bail out on the first unexpected token.  The unexpected token
    	 * is reported in the usual format.
    	 */
    	@Override
    	public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
    		String hdr = getErrorHeader(e);
    		String msg = getErrorMessage(e, tokenNames);
    		errors.add(hdr + " unexpected token: " + e.token.getText());
    	}

    	/**
    	 * Accessor method for retrieving the accumulated errors if they exist.
    	 */
    	public List<String> getErrors() {
    		return errors;
    	}


    public static class sourceText_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sourceText"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:157:1: sourceText : ( designDecl )+ EOF ;
    public final PhdlParser.sourceText_return sourceText() throws RecognitionException {
        PhdlParser.sourceText_return retval = new PhdlParser.sourceText_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF2=null;
        PhdlParser.designDecl_return designDecl1 = null;


        CommonTree EOF2_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:162:2: ( ( designDecl )+ EOF )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:162:4: ( designDecl )+ EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:162:4: ( designDecl )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==27) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:162:4: designDecl
            	    {
            	    pushFollow(FOLLOW_designDecl_in_sourceText79);
            	    designDecl1=designDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, designDecl1.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_sourceText82); 
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:165:1: designDecl : 'design' IDENT LEFTBRACE ( deviceDecl | netDecl | infoStruct | instanceDecl | netAssignment | groupStruct | subDesignInstance | portDecl )* RIGHTBRACE ;
    public final PhdlParser.designDecl_return designDecl() throws RecognitionException {
        PhdlParser.designDecl_return retval = new PhdlParser.designDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal3=null;
        Token IDENT4=null;
        Token LEFTBRACE5=null;
        Token RIGHTBRACE14=null;
        PhdlParser.deviceDecl_return deviceDecl6 = null;

        PhdlParser.netDecl_return netDecl7 = null;

        PhdlParser.infoStruct_return infoStruct8 = null;

        PhdlParser.instanceDecl_return instanceDecl9 = null;

        PhdlParser.netAssignment_return netAssignment10 = null;

        PhdlParser.groupStruct_return groupStruct11 = null;

        PhdlParser.subDesignInstance_return subDesignInstance12 = null;

        PhdlParser.portDecl_return portDecl13 = null;


        CommonTree string_literal3_tree=null;
        CommonTree IDENT4_tree=null;
        CommonTree LEFTBRACE5_tree=null;
        CommonTree RIGHTBRACE14_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:173:2: ( 'design' IDENT LEFTBRACE ( deviceDecl | netDecl | infoStruct | instanceDecl | netAssignment | groupStruct | subDesignInstance | portDecl )* RIGHTBRACE )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:173:4: 'design' IDENT LEFTBRACE ( deviceDecl | netDecl | infoStruct | instanceDecl | netAssignment | groupStruct | subDesignInstance | portDecl )* RIGHTBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal3=(Token)match(input,27,FOLLOW_27_in_designDecl95); 
            string_literal3_tree = (CommonTree)adaptor.create(string_literal3);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal3_tree, root_0);

            IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_designDecl98); 
            IDENT4_tree = (CommonTree)adaptor.create(IDENT4);
            adaptor.addChild(root_0, IDENT4_tree);

            LEFTBRACE5=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_designDecl100); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:174:3: ( deviceDecl | netDecl | infoStruct | instanceDecl | netAssignment | groupStruct | subDesignInstance | portDecl )*
            loop2:
            do {
                int alt2=9;
                switch ( input.LA(1) ) {
                case 29:
                    {
                    alt2=1;
                    }
                    break;
                case 32:
                    {
                    alt2=2;
                    }
                    break;
                case 39:
                    {
                    alt2=3;
                    }
                    break;
                case 33:
                    {
                    alt2=4;
                    }
                    break;
                case IDENT:
                    {
                    alt2=5;
                    }
                    break;
                case 40:
                    {
                    alt2=6;
                    }
                    break;
                case 35:
                    {
                    alt2=7;
                    }
                    break;
                case 28:
                    {
                    alt2=8;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:174:4: deviceDecl
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_designDecl107);
            	    deviceDecl6=deviceDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, deviceDecl6.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:174:17: netDecl
            	    {
            	    pushFollow(FOLLOW_netDecl_in_designDecl111);
            	    netDecl7=netDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netDecl7.getTree());

            	    }
            	    break;
            	case 3 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:174:27: infoStruct
            	    {
            	    pushFollow(FOLLOW_infoStruct_in_designDecl115);
            	    infoStruct8=infoStruct();

            	    state._fsp--;

            	    adaptor.addChild(root_0, infoStruct8.getTree());

            	    }
            	    break;
            	case 4 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:174:40: instanceDecl
            	    {
            	    pushFollow(FOLLOW_instanceDecl_in_designDecl119);
            	    instanceDecl9=instanceDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, instanceDecl9.getTree());

            	    }
            	    break;
            	case 5 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:174:55: netAssignment
            	    {
            	    pushFollow(FOLLOW_netAssignment_in_designDecl123);
            	    netAssignment10=netAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netAssignment10.getTree());

            	    }
            	    break;
            	case 6 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:174:71: groupStruct
            	    {
            	    pushFollow(FOLLOW_groupStruct_in_designDecl127);
            	    groupStruct11=groupStruct();

            	    state._fsp--;

            	    adaptor.addChild(root_0, groupStruct11.getTree());

            	    }
            	    break;
            	case 7 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:174:85: subDesignInstance
            	    {
            	    pushFollow(FOLLOW_subDesignInstance_in_designDecl131);
            	    subDesignInstance12=subDesignInstance();

            	    state._fsp--;

            	    adaptor.addChild(root_0, subDesignInstance12.getTree());

            	    }
            	    break;
            	case 8 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:174:105: portDecl
            	    {
            	    pushFollow(FOLLOW_portDecl_in_designDecl135);
            	    portDecl13=portDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, portDecl13.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            RIGHTBRACE14=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_designDecl141); 

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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:178:1: portDecl : 'port' ( sliceDecl )? IDENT ( ',' IDENT )* SEMICOLON ;
    public final PhdlParser.portDecl_return portDecl() throws RecognitionException {
        PhdlParser.portDecl_return retval = new PhdlParser.portDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal15=null;
        Token IDENT17=null;
        Token char_literal18=null;
        Token IDENT19=null;
        Token SEMICOLON20=null;
        PhdlParser.sliceDecl_return sliceDecl16 = null;


        CommonTree string_literal15_tree=null;
        CommonTree IDENT17_tree=null;
        CommonTree char_literal18_tree=null;
        CommonTree IDENT19_tree=null;
        CommonTree SEMICOLON20_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:179:2: ( 'port' ( sliceDecl )? IDENT ( ',' IDENT )* SEMICOLON )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:180:3: 'port' ( sliceDecl )? IDENT ( ',' IDENT )* SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal15=(Token)match(input,28,FOLLOW_28_in_portDecl155); 
            string_literal15_tree = (CommonTree)adaptor.create(string_literal15);
            adaptor.addChild(root_0, string_literal15_tree);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:180:10: ( sliceDecl )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==LEFTBRACKET) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:180:10: sliceDecl
                    {
                    pushFollow(FOLLOW_sliceDecl_in_portDecl157);
                    sliceDecl16=sliceDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceDecl16.getTree());

                    }
                    break;

            }

            IDENT17=(Token)match(input,IDENT,FOLLOW_IDENT_in_portDecl160); 
            IDENT17_tree = (CommonTree)adaptor.create(IDENT17);
            adaptor.addChild(root_0, IDENT17_tree);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:180:27: ( ',' IDENT )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==COMMA) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:180:28: ',' IDENT
            	    {
            	    char_literal18=(Token)match(input,COMMA,FOLLOW_COMMA_in_portDecl163); 
            	    char_literal18_tree = (CommonTree)adaptor.create(char_literal18);
            	    adaptor.addChild(root_0, char_literal18_tree);

            	    IDENT19=(Token)match(input,IDENT,FOLLOW_IDENT_in_portDecl165); 
            	    IDENT19_tree = (CommonTree)adaptor.create(IDENT19);
            	    adaptor.addChild(root_0, IDENT19_tree);


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            SEMICOLON20=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_portDecl169); 

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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:183:1: deviceDecl : 'device' IDENT LEFTBRACE ( attributeDecl | pinDecl )* RIGHTBRACE ;
    public final PhdlParser.deviceDecl_return deviceDecl() throws RecognitionException {
        PhdlParser.deviceDecl_return retval = new PhdlParser.deviceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal21=null;
        Token IDENT22=null;
        Token LEFTBRACE23=null;
        Token RIGHTBRACE26=null;
        PhdlParser.attributeDecl_return attributeDecl24 = null;

        PhdlParser.pinDecl_return pinDecl25 = null;


        CommonTree string_literal21_tree=null;
        CommonTree IDENT22_tree=null;
        CommonTree LEFTBRACE23_tree=null;
        CommonTree RIGHTBRACE26_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:190:2: ( 'device' IDENT LEFTBRACE ( attributeDecl | pinDecl )* RIGHTBRACE )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:190:4: 'device' IDENT LEFTBRACE ( attributeDecl | pinDecl )* RIGHTBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal21=(Token)match(input,29,FOLLOW_29_in_deviceDecl184); 
            string_literal21_tree = (CommonTree)adaptor.create(string_literal21);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal21_tree, root_0);

            IDENT22=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl187); 
            IDENT22_tree = (CommonTree)adaptor.create(IDENT22);
            adaptor.addChild(root_0, IDENT22_tree);

            LEFTBRACE23=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_deviceDecl189); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:191:3: ( attributeDecl | pinDecl )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==30) ) {
                    alt5=1;
                }
                else if ( (LA5_0==31) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:191:5: attributeDecl
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_deviceDecl196);
            	    attributeDecl24=attributeDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeDecl24.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:191:21: pinDecl
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl200);
            	    pinDecl25=pinDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinDecl25.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            RIGHTBRACE26=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_deviceDecl207); 

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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:195:1: attributeDecl : 'attr' IDENT EQUALS STRING SEMICOLON ;
    public final PhdlParser.attributeDecl_return attributeDecl() throws RecognitionException {
        PhdlParser.attributeDecl_return retval = new PhdlParser.attributeDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal27=null;
        Token IDENT28=null;
        Token EQUALS29=null;
        Token STRING30=null;
        Token SEMICOLON31=null;

        CommonTree string_literal27_tree=null;
        CommonTree IDENT28_tree=null;
        CommonTree EQUALS29_tree=null;
        CommonTree STRING30_tree=null;
        CommonTree SEMICOLON31_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:200:2: ( 'attr' IDENT EQUALS STRING SEMICOLON )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:200:4: 'attr' IDENT EQUALS STRING SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal27=(Token)match(input,30,FOLLOW_30_in_attributeDecl222); 
            string_literal27_tree = (CommonTree)adaptor.create(string_literal27);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal27_tree, root_0);

            IDENT28=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeDecl225); 
            IDENT28_tree = (CommonTree)adaptor.create(IDENT28);
            adaptor.addChild(root_0, IDENT28_tree);

            EQUALS29=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeDecl227); 
            STRING30=(Token)match(input,STRING,FOLLOW_STRING_in_attributeDecl230); 
            STRING30_tree = (CommonTree)adaptor.create(STRING30);
            adaptor.addChild(root_0, STRING30_tree);

            SEMICOLON31=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeDecl232); 

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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:203:1: pinDecl : type ( sliceDecl )? IDENT EQUALS pinList SEMICOLON ;
    public final PhdlParser.pinDecl_return pinDecl() throws RecognitionException {
        PhdlParser.pinDecl_return retval = new PhdlParser.pinDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT34=null;
        Token EQUALS35=null;
        Token SEMICOLON37=null;
        PhdlParser.type_return type32 = null;

        PhdlParser.sliceDecl_return sliceDecl33 = null;

        PhdlParser.pinList_return pinList36 = null;


        CommonTree IDENT34_tree=null;
        CommonTree EQUALS35_tree=null;
        CommonTree SEMICOLON37_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:208:2: ( type ( sliceDecl )? IDENT EQUALS pinList SEMICOLON )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:208:4: type ( sliceDecl )? IDENT EQUALS pinList SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_type_in_pinDecl246);
            type32=type();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(type32.getTree(), root_0);
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:208:10: ( sliceDecl )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==LEFTBRACKET) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:208:10: sliceDecl
                    {
                    pushFollow(FOLLOW_sliceDecl_in_pinDecl249);
                    sliceDecl33=sliceDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceDecl33.getTree());

                    }
                    break;

            }

            IDENT34=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinDecl252); 
            IDENT34_tree = (CommonTree)adaptor.create(IDENT34);
            adaptor.addChild(root_0, IDENT34_tree);

            EQUALS35=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinDecl254); 
            pushFollow(FOLLOW_pinList_in_pinDecl257);
            pinList36=pinList();

            state._fsp--;

            adaptor.addChild(root_0, pinList36.getTree());
            SEMICOLON37=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinDecl259); 

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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:211:1: type : 'pin' ;
    public final PhdlParser.type_return type() throws RecognitionException {
        PhdlParser.type_return retval = new PhdlParser.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal38=null;

        CommonTree string_literal38_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:215:2: ( 'pin' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:215:4: 'pin'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal38=(Token)match(input,31,FOLLOW_31_in_type274); 
            string_literal38_tree = (CommonTree)adaptor.create(string_literal38);
            adaptor.addChild(root_0, string_literal38_tree);


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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:218:1: netDecl : 'net' ( sliceDecl )? IDENT ( COMMA IDENT )* ( netAttributes | SEMICOLON ) ;
    public final PhdlParser.netDecl_return netDecl() throws RecognitionException {
        PhdlParser.netDecl_return retval = new PhdlParser.netDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal39=null;
        Token IDENT41=null;
        Token COMMA42=null;
        Token IDENT43=null;
        Token SEMICOLON45=null;
        PhdlParser.sliceDecl_return sliceDecl40 = null;

        PhdlParser.netAttributes_return netAttributes44 = null;


        CommonTree string_literal39_tree=null;
        CommonTree IDENT41_tree=null;
        CommonTree COMMA42_tree=null;
        CommonTree IDENT43_tree=null;
        CommonTree SEMICOLON45_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:223:2: ( 'net' ( sliceDecl )? IDENT ( COMMA IDENT )* ( netAttributes | SEMICOLON ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:223:4: 'net' ( sliceDecl )? IDENT ( COMMA IDENT )* ( netAttributes | SEMICOLON )
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal39=(Token)match(input,32,FOLLOW_32_in_netDecl287); 
            string_literal39_tree = (CommonTree)adaptor.create(string_literal39);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal39_tree, root_0);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:223:11: ( sliceDecl )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==LEFTBRACKET) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:223:11: sliceDecl
                    {
                    pushFollow(FOLLOW_sliceDecl_in_netDecl290);
                    sliceDecl40=sliceDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceDecl40.getTree());

                    }
                    break;

            }

            IDENT41=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl293); 
            IDENT41_tree = (CommonTree)adaptor.create(IDENT41);
            adaptor.addChild(root_0, IDENT41_tree);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:223:28: ( COMMA IDENT )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==COMMA) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:223:29: COMMA IDENT
            	    {
            	    COMMA42=(Token)match(input,COMMA,FOLLOW_COMMA_in_netDecl296); 
            	    COMMA42_tree = (CommonTree)adaptor.create(COMMA42);
            	    adaptor.addChild(root_0, COMMA42_tree);

            	    IDENT43=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl298); 
            	    IDENT43_tree = (CommonTree)adaptor.create(IDENT43);
            	    adaptor.addChild(root_0, IDENT43_tree);


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:223:43: ( netAttributes | SEMICOLON )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==LEFTBRACE) ) {
                alt9=1;
            }
            else if ( (LA9_0==SEMICOLON) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:223:44: netAttributes
                    {
                    pushFollow(FOLLOW_netAttributes_in_netDecl303);
                    netAttributes44=netAttributes();

                    state._fsp--;

                    adaptor.addChild(root_0, netAttributes44.getTree());

                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:223:60: SEMICOLON
                    {
                    SEMICOLON45=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netDecl307); 

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
    // $ANTLR end "netDecl"

    public static class netAttributes_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "netAttributes"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:226:1: netAttributes : LEFTBRACE ( attributeDecl )* RIGHTBRACE ;
    public final PhdlParser.netAttributes_return netAttributes() throws RecognitionException {
        PhdlParser.netAttributes_return retval = new PhdlParser.netAttributes_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTBRACE46=null;
        Token RIGHTBRACE48=null;
        PhdlParser.attributeDecl_return attributeDecl47 = null;


        CommonTree LEFTBRACE46_tree=null;
        CommonTree RIGHTBRACE48_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:232:2: ( LEFTBRACE ( attributeDecl )* RIGHTBRACE )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:232:4: LEFTBRACE ( attributeDecl )* RIGHTBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACE46=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_netAttributes323); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:232:15: ( attributeDecl )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==30) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:232:15: attributeDecl
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_netAttributes326);
            	    attributeDecl47=attributeDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeDecl47.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            RIGHTBRACE48=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_netAttributes329); 

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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:235:1: instanceDecl : 'inst' ( arrayDecl )? IDENT 'of' IDENT LEFTBRACE ( attributeAssignment | pinAssignment | infoStruct )* RIGHTBRACE ;
    public final PhdlParser.instanceDecl_return instanceDecl() throws RecognitionException {
        PhdlParser.instanceDecl_return retval = new PhdlParser.instanceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal49=null;
        Token IDENT51=null;
        Token string_literal52=null;
        Token IDENT53=null;
        Token LEFTBRACE54=null;
        Token RIGHTBRACE58=null;
        PhdlParser.arrayDecl_return arrayDecl50 = null;

        PhdlParser.attributeAssignment_return attributeAssignment55 = null;

        PhdlParser.pinAssignment_return pinAssignment56 = null;

        PhdlParser.infoStruct_return infoStruct57 = null;


        CommonTree string_literal49_tree=null;
        CommonTree IDENT51_tree=null;
        CommonTree string_literal52_tree=null;
        CommonTree IDENT53_tree=null;
        CommonTree LEFTBRACE54_tree=null;
        CommonTree RIGHTBRACE58_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:244:2: ( 'inst' ( arrayDecl )? IDENT 'of' IDENT LEFTBRACE ( attributeAssignment | pinAssignment | infoStruct )* RIGHTBRACE )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:244:4: 'inst' ( arrayDecl )? IDENT 'of' IDENT LEFTBRACE ( attributeAssignment | pinAssignment | infoStruct )* RIGHTBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal49=(Token)match(input,33,FOLLOW_33_in_instanceDecl343); 
            string_literal49_tree = (CommonTree)adaptor.create(string_literal49);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal49_tree, root_0);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:244:12: ( arrayDecl )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==LEFTPAREN) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:244:12: arrayDecl
                    {
                    pushFollow(FOLLOW_arrayDecl_in_instanceDecl346);
                    arrayDecl50=arrayDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayDecl50.getTree());

                    }
                    break;

            }

            IDENT51=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceDecl349); 
            IDENT51_tree = (CommonTree)adaptor.create(IDENT51);
            adaptor.addChild(root_0, IDENT51_tree);

            string_literal52=(Token)match(input,34,FOLLOW_34_in_instanceDecl351); 
            IDENT53=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceDecl354); 
            IDENT53_tree = (CommonTree)adaptor.create(IDENT53);
            adaptor.addChild(root_0, IDENT53_tree);

            LEFTBRACE54=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_instanceDecl356); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:245:3: ( attributeAssignment | pinAssignment | infoStruct )*
            loop12:
            do {
                int alt12=4;
                alt12 = dfa12.predict(input);
                switch (alt12) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:245:4: attributeAssignment
            	    {
            	    pushFollow(FOLLOW_attributeAssignment_in_instanceDecl362);
            	    attributeAssignment55=attributeAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeAssignment55.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:245:26: pinAssignment
            	    {
            	    pushFollow(FOLLOW_pinAssignment_in_instanceDecl366);
            	    pinAssignment56=pinAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinAssignment56.getTree());

            	    }
            	    break;
            	case 3 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:245:42: infoStruct
            	    {
            	    pushFollow(FOLLOW_infoStruct_in_instanceDecl370);
            	    infoStruct57=infoStruct();

            	    state._fsp--;

            	    adaptor.addChild(root_0, infoStruct57.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            RIGHTBRACE58=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_instanceDecl376); 

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

    public static class subDesignInstance_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subDesignInstance"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:248:1: subDesignInstance : 'sub' ( arrayDecl )? IDENT 'of' IDENT LEFTBRACE ( subAssignment | infoStruct )* RIGHTBRACE ;
    public final PhdlParser.subDesignInstance_return subDesignInstance() throws RecognitionException {
        PhdlParser.subDesignInstance_return retval = new PhdlParser.subDesignInstance_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal59=null;
        Token IDENT61=null;
        Token string_literal62=null;
        Token IDENT63=null;
        Token LEFTBRACE64=null;
        Token RIGHTBRACE67=null;
        PhdlParser.arrayDecl_return arrayDecl60 = null;

        PhdlParser.subAssignment_return subAssignment65 = null;

        PhdlParser.infoStruct_return infoStruct66 = null;


        CommonTree string_literal59_tree=null;
        CommonTree IDENT61_tree=null;
        CommonTree string_literal62_tree=null;
        CommonTree IDENT63_tree=null;
        CommonTree LEFTBRACE64_tree=null;
        CommonTree RIGHTBRACE67_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:253:3: ( 'sub' ( arrayDecl )? IDENT 'of' IDENT LEFTBRACE ( subAssignment | infoStruct )* RIGHTBRACE )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:253:5: 'sub' ( arrayDecl )? IDENT 'of' IDENT LEFTBRACE ( subAssignment | infoStruct )* RIGHTBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal59=(Token)match(input,35,FOLLOW_35_in_subDesignInstance390); 
            string_literal59_tree = (CommonTree)adaptor.create(string_literal59);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal59_tree, root_0);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:253:12: ( arrayDecl )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==LEFTPAREN) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:253:12: arrayDecl
                    {
                    pushFollow(FOLLOW_arrayDecl_in_subDesignInstance393);
                    arrayDecl60=arrayDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayDecl60.getTree());

                    }
                    break;

            }

            IDENT61=(Token)match(input,IDENT,FOLLOW_IDENT_in_subDesignInstance396); 
            IDENT61_tree = (CommonTree)adaptor.create(IDENT61);
            adaptor.addChild(root_0, IDENT61_tree);

            string_literal62=(Token)match(input,34,FOLLOW_34_in_subDesignInstance398); 
            IDENT63=(Token)match(input,IDENT,FOLLOW_IDENT_in_subDesignInstance401); 
            IDENT63_tree = (CommonTree)adaptor.create(IDENT63);
            adaptor.addChild(root_0, IDENT63_tree);

            LEFTBRACE64=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_subDesignInstance403); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:254:5: ( subAssignment | infoStruct )*
            loop14:
            do {
                int alt14=3;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==IDENT||(LA14_0>=36 && LA14_0<=38)) ) {
                    alt14=1;
                }
                else if ( (LA14_0==39) ) {
                    alt14=2;
                }


                switch (alt14) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:254:6: subAssignment
            	    {
            	    pushFollow(FOLLOW_subAssignment_in_subDesignInstance411);
            	    subAssignment65=subAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, subAssignment65.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:254:22: infoStruct
            	    {
            	    pushFollow(FOLLOW_infoStruct_in_subDesignInstance415);
            	    infoStruct66=infoStruct();

            	    state._fsp--;

            	    adaptor.addChild(root_0, infoStruct66.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            RIGHTBRACE67=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_subDesignInstance423); 

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

    public static class subAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subAssignment"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:258:1: subAssignment : ( portAssignment | subAttrAssignment );
    public final PhdlParser.subAssignment_return subAssignment() throws RecognitionException {
        PhdlParser.subAssignment_return retval = new PhdlParser.subAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        PhdlParser.portAssignment_return portAssignment68 = null;

        PhdlParser.subAttrAssignment_return subAttrAssignment69 = null;



        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:262:3: ( portAssignment | subAttrAssignment )
            int alt15=2;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:262:5: portAssignment
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_portAssignment_in_subAssignment439);
                    portAssignment68=portAssignment();

                    state._fsp--;

                    adaptor.addChild(root_0, portAssignment68.getTree());

                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:263:5: subAttrAssignment
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_subAttrAssignment_in_subAssignment445);
                    subAttrAssignment69=subAttrAssignment();

                    state._fsp--;

                    adaptor.addChild(root_0, subAttrAssignment69.getTree());

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
    // $ANTLR end "subAssignment"

    public static class portAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "portAssignment"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:266:1: portAssignment : ( combineQualifier | pinSpecifier ) EQUALS concatenation SEMICOLON ;
    public final PhdlParser.portAssignment_return portAssignment() throws RecognitionException {
        PhdlParser.portAssignment_return retval = new PhdlParser.portAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQUALS72=null;
        Token SEMICOLON74=null;
        PhdlParser.combineQualifier_return combineQualifier70 = null;

        PhdlParser.pinSpecifier_return pinSpecifier71 = null;

        PhdlParser.concatenation_return concatenation73 = null;


        CommonTree EQUALS72_tree=null;
        CommonTree SEMICOLON74_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:267:3: ( ( combineQualifier | pinSpecifier ) EQUALS concatenation SEMICOLON )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:267:5: ( combineQualifier | pinSpecifier ) EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:267:5: ( combineQualifier | pinSpecifier )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==36) ) {
                alt16=1;
            }
            else if ( (LA16_0==IDENT||LA16_0==38) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:267:6: combineQualifier
                    {
                    pushFollow(FOLLOW_combineQualifier_in_portAssignment461);
                    combineQualifier70=combineQualifier();

                    state._fsp--;

                    adaptor.addChild(root_0, combineQualifier70.getTree());

                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:267:25: pinSpecifier
                    {
                    pushFollow(FOLLOW_pinSpecifier_in_portAssignment465);
                    pinSpecifier71=pinSpecifier();

                    state._fsp--;

                    adaptor.addChild(root_0, pinSpecifier71.getTree());

                    }
                    break;

            }

            EQUALS72=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_portAssignment468); 
            EQUALS72_tree = (CommonTree)adaptor.create(EQUALS72);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS72_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_portAssignment471);
            concatenation73=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation73.getTree());
            SEMICOLON74=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_portAssignment473); 

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

    public static class combineQualifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "combineQualifier"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:270:1: combineQualifier : 'combine' LEFTPAREN pinSpecifier RIGHTPAREN ;
    public final PhdlParser.combineQualifier_return combineQualifier() throws RecognitionException {
        PhdlParser.combineQualifier_return retval = new PhdlParser.combineQualifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal75=null;
        Token LEFTPAREN76=null;
        Token RIGHTPAREN78=null;
        PhdlParser.pinSpecifier_return pinSpecifier77 = null;


        CommonTree string_literal75_tree=null;
        CommonTree LEFTPAREN76_tree=null;
        CommonTree RIGHTPAREN78_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:271:3: ( 'combine' LEFTPAREN pinSpecifier RIGHTPAREN )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:271:5: 'combine' LEFTPAREN pinSpecifier RIGHTPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal75=(Token)match(input,36,FOLLOW_36_in_combineQualifier487); 
            string_literal75_tree = (CommonTree)adaptor.create(string_literal75);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal75_tree, root_0);

            LEFTPAREN76=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_combineQualifier490); 
            pushFollow(FOLLOW_pinSpecifier_in_combineQualifier493);
            pinSpecifier77=pinSpecifier();

            state._fsp--;

            adaptor.addChild(root_0, pinSpecifier77.getTree());
            RIGHTPAREN78=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_combineQualifier495); 

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
    // $ANTLR end "combineQualifier"

    public static class pinSpecifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pinSpecifier"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:274:1: pinSpecifier : ( arrayQualifier )? IDENT ( sliceList )? ;
    public final PhdlParser.pinSpecifier_return pinSpecifier() throws RecognitionException {
        PhdlParser.pinSpecifier_return retval = new PhdlParser.pinSpecifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT80=null;
        PhdlParser.arrayQualifier_return arrayQualifier79 = null;

        PhdlParser.sliceList_return sliceList81 = null;


        CommonTree IDENT80_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:275:3: ( ( arrayQualifier )? IDENT ( sliceList )? )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:275:5: ( arrayQualifier )? IDENT ( sliceList )?
            {
            root_0 = (CommonTree)adaptor.nil();

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:275:5: ( arrayQualifier )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==38) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:275:5: arrayQualifier
                    {
                    pushFollow(FOLLOW_arrayQualifier_in_pinSpecifier511);
                    arrayQualifier79=arrayQualifier();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayQualifier79.getTree());

                    }
                    break;

            }

            IDENT80=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinSpecifier514); 
            IDENT80_tree = (CommonTree)adaptor.create(IDENT80);
            root_0 = (CommonTree)adaptor.becomeRoot(IDENT80_tree, root_0);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:275:28: ( sliceList )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==LEFTBRACKET) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:275:28: sliceList
                    {
                    pushFollow(FOLLOW_sliceList_in_pinSpecifier517);
                    sliceList81=sliceList();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceList81.getTree());

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
    // $ANTLR end "pinSpecifier"

    public static class subAttrAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subAttrAssignment"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:278:1: subAttrAssignment : ( 'newattr' )? ( arrayQualifier )? ( instSpecifier )* IDENT EQUALS STRING SEMICOLON ;
    public final PhdlParser.subAttrAssignment_return subAttrAssignment() throws RecognitionException {
        PhdlParser.subAttrAssignment_return retval = new PhdlParser.subAttrAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal82=null;
        Token IDENT85=null;
        Token EQUALS86=null;
        Token STRING87=null;
        Token SEMICOLON88=null;
        PhdlParser.arrayQualifier_return arrayQualifier83 = null;

        PhdlParser.instSpecifier_return instSpecifier84 = null;


        CommonTree string_literal82_tree=null;
        CommonTree IDENT85_tree=null;
        CommonTree EQUALS86_tree=null;
        CommonTree STRING87_tree=null;
        CommonTree SEMICOLON88_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:279:3: ( ( 'newattr' )? ( arrayQualifier )? ( instSpecifier )* IDENT EQUALS STRING SEMICOLON )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:279:5: ( 'newattr' )? ( arrayQualifier )? ( instSpecifier )* IDENT EQUALS STRING SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:279:5: ( 'newattr' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==37) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:279:5: 'newattr'
                    {
                    string_literal82=(Token)match(input,37,FOLLOW_37_in_subAttrAssignment531); 
                    string_literal82_tree = (CommonTree)adaptor.create(string_literal82);
                    adaptor.addChild(root_0, string_literal82_tree);


                    }
                    break;

            }

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:279:16: ( arrayQualifier )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==38) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:279:16: arrayQualifier
                    {
                    pushFollow(FOLLOW_arrayQualifier_in_subAttrAssignment534);
                    arrayQualifier83=arrayQualifier();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayQualifier83.getTree());

                    }
                    break;

            }

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:279:32: ( instSpecifier )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==IDENT) ) {
                    int LA21_1 = input.LA(2);

                    if ( (LA21_1==LEFTPAREN||LA21_1==PERIOD) ) {
                        alt21=1;
                    }


                }


                switch (alt21) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:279:32: instSpecifier
            	    {
            	    pushFollow(FOLLOW_instSpecifier_in_subAttrAssignment537);
            	    instSpecifier84=instSpecifier();

            	    state._fsp--;

            	    adaptor.addChild(root_0, instSpecifier84.getTree());

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            IDENT85=(Token)match(input,IDENT,FOLLOW_IDENT_in_subAttrAssignment540); 
            IDENT85_tree = (CommonTree)adaptor.create(IDENT85);
            adaptor.addChild(root_0, IDENT85_tree);

            EQUALS86=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_subAttrAssignment542); 
            EQUALS86_tree = (CommonTree)adaptor.create(EQUALS86);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS86_tree, root_0);

            STRING87=(Token)match(input,STRING,FOLLOW_STRING_in_subAttrAssignment545); 
            STRING87_tree = (CommonTree)adaptor.create(STRING87);
            adaptor.addChild(root_0, STRING87_tree);

            SEMICOLON88=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_subAttrAssignment547); 

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
    // $ANTLR end "subAttrAssignment"

    public static class arrayQualifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arrayQualifier"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:282:1: arrayQualifier : 'this' ( arrayList )? PERIOD ;
    public final PhdlParser.arrayQualifier_return arrayQualifier() throws RecognitionException {
        PhdlParser.arrayQualifier_return retval = new PhdlParser.arrayQualifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal89=null;
        Token PERIOD91=null;
        PhdlParser.arrayList_return arrayList90 = null;


        CommonTree string_literal89_tree=null;
        CommonTree PERIOD91_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:283:3: ( 'this' ( arrayList )? PERIOD )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:283:5: 'this' ( arrayList )? PERIOD
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal89=(Token)match(input,38,FOLLOW_38_in_arrayQualifier564); 
            string_literal89_tree = (CommonTree)adaptor.create(string_literal89);
            adaptor.addChild(root_0, string_literal89_tree);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:283:12: ( arrayList )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==LEFTPAREN) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:283:12: arrayList
                    {
                    pushFollow(FOLLOW_arrayList_in_arrayQualifier566);
                    arrayList90=arrayList();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayList90.getTree());

                    }
                    break;

            }

            PERIOD91=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_arrayQualifier569); 
            PERIOD91_tree = (CommonTree)adaptor.create(PERIOD91);
            adaptor.addChild(root_0, PERIOD91_tree);


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
    // $ANTLR end "arrayQualifier"

    public static class instSpecifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "instSpecifier"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:286:1: instSpecifier : IDENT ( arrayList )? PERIOD ;
    public final PhdlParser.instSpecifier_return instSpecifier() throws RecognitionException {
        PhdlParser.instSpecifier_return retval = new PhdlParser.instSpecifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT92=null;
        Token PERIOD94=null;
        PhdlParser.arrayList_return arrayList93 = null;


        CommonTree IDENT92_tree=null;
        CommonTree PERIOD94_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:287:3: ( IDENT ( arrayList )? PERIOD )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:287:5: IDENT ( arrayList )? PERIOD
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT92=(Token)match(input,IDENT,FOLLOW_IDENT_in_instSpecifier582); 
            IDENT92_tree = (CommonTree)adaptor.create(IDENT92);
            adaptor.addChild(root_0, IDENT92_tree);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:287:11: ( arrayList )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==LEFTPAREN) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:287:11: arrayList
                    {
                    pushFollow(FOLLOW_arrayList_in_instSpecifier584);
                    arrayList93=arrayList();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayList93.getTree());

                    }
                    break;

            }

            PERIOD94=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_instSpecifier587); 
            PERIOD94_tree = (CommonTree)adaptor.create(PERIOD94);
            root_0 = (CommonTree)adaptor.becomeRoot(PERIOD94_tree, root_0);


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
    // $ANTLR end "instSpecifier"

    public static class infoStruct_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "infoStruct"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:290:1: infoStruct : 'info' LEFTBRACE STRING RIGHTBRACE ;
    public final PhdlParser.infoStruct_return infoStruct() throws RecognitionException {
        PhdlParser.infoStruct_return retval = new PhdlParser.infoStruct_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal95=null;
        Token LEFTBRACE96=null;
        Token STRING97=null;
        Token RIGHTBRACE98=null;

        CommonTree string_literal95_tree=null;
        CommonTree LEFTBRACE96_tree=null;
        CommonTree STRING97_tree=null;
        CommonTree RIGHTBRACE98_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:295:2: ( 'info' LEFTBRACE STRING RIGHTBRACE )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:295:5: 'info' LEFTBRACE STRING RIGHTBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal95=(Token)match(input,39,FOLLOW_39_in_infoStruct603); 
            string_literal95_tree = (CommonTree)adaptor.create(string_literal95);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal95_tree, root_0);

            LEFTBRACE96=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_infoStruct606); 
            STRING97=(Token)match(input,STRING,FOLLOW_STRING_in_infoStruct609); 
            STRING97_tree = (CommonTree)adaptor.create(STRING97);
            adaptor.addChild(root_0, STRING97_tree);

            RIGHTBRACE98=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_infoStruct611); 

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
    // $ANTLR end "infoStruct"

    public static class groupStruct_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "groupStruct"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:298:1: groupStruct : 'group' STRING LEFTBRACE ( instanceDecl | netAssignment )* RIGHTBRACE ;
    public final PhdlParser.groupStruct_return groupStruct() throws RecognitionException {
        PhdlParser.groupStruct_return retval = new PhdlParser.groupStruct_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal99=null;
        Token STRING100=null;
        Token LEFTBRACE101=null;
        Token RIGHTBRACE104=null;
        PhdlParser.instanceDecl_return instanceDecl102 = null;

        PhdlParser.netAssignment_return netAssignment103 = null;


        CommonTree string_literal99_tree=null;
        CommonTree STRING100_tree=null;
        CommonTree LEFTBRACE101_tree=null;
        CommonTree RIGHTBRACE104_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:299:2: ( 'group' STRING LEFTBRACE ( instanceDecl | netAssignment )* RIGHTBRACE )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:299:5: 'group' STRING LEFTBRACE ( instanceDecl | netAssignment )* RIGHTBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal99=(Token)match(input,40,FOLLOW_40_in_groupStruct626); 
            string_literal99_tree = (CommonTree)adaptor.create(string_literal99);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal99_tree, root_0);

            STRING100=(Token)match(input,STRING,FOLLOW_STRING_in_groupStruct629); 
            STRING100_tree = (CommonTree)adaptor.create(STRING100);
            adaptor.addChild(root_0, STRING100_tree);

            LEFTBRACE101=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_groupStruct631); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:299:32: ( instanceDecl | netAssignment )*
            loop24:
            do {
                int alt24=3;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==33) ) {
                    alt24=1;
                }
                else if ( (LA24_0==IDENT) ) {
                    alt24=2;
                }


                switch (alt24) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:299:33: instanceDecl
            	    {
            	    pushFollow(FOLLOW_instanceDecl_in_groupStruct635);
            	    instanceDecl102=instanceDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, instanceDecl102.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:299:48: netAssignment
            	    {
            	    pushFollow(FOLLOW_netAssignment_in_groupStruct639);
            	    netAssignment103=netAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netAssignment103.getTree());

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            RIGHTBRACE104=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_groupStruct643); 

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
    // $ANTLR end "groupStruct"

    public static class attributeAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributeAssignment"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:302:1: attributeAssignment : ( 'newattr' )? ( attributeQualifier )? IDENT EQUALS STRING SEMICOLON ;
    public final PhdlParser.attributeAssignment_return attributeAssignment() throws RecognitionException {
        PhdlParser.attributeAssignment_return retval = new PhdlParser.attributeAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal105=null;
        Token IDENT107=null;
        Token EQUALS108=null;
        Token STRING109=null;
        Token SEMICOLON110=null;
        PhdlParser.attributeQualifier_return attributeQualifier106 = null;


        CommonTree string_literal105_tree=null;
        CommonTree IDENT107_tree=null;
        CommonTree EQUALS108_tree=null;
        CommonTree STRING109_tree=null;
        CommonTree SEMICOLON110_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:313:2: ( ( 'newattr' )? ( attributeQualifier )? IDENT EQUALS STRING SEMICOLON )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:313:4: ( 'newattr' )? ( attributeQualifier )? IDENT EQUALS STRING SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:313:4: ( 'newattr' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==37) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:313:5: 'newattr'
                    {
                    string_literal105=(Token)match(input,37,FOLLOW_37_in_attributeAssignment658); 
                    string_literal105_tree = (CommonTree)adaptor.create(string_literal105);
                    adaptor.addChild(root_0, string_literal105_tree);


                    }
                    break;

            }

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:313:17: ( attributeQualifier )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==38) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:313:17: attributeQualifier
                    {
                    pushFollow(FOLLOW_attributeQualifier_in_attributeAssignment662);
                    attributeQualifier106=attributeQualifier();

                    state._fsp--;

                    adaptor.addChild(root_0, attributeQualifier106.getTree());

                    }
                    break;

            }

            IDENT107=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeAssignment665); 
            IDENT107_tree = (CommonTree)adaptor.create(IDENT107);
            adaptor.addChild(root_0, IDENT107_tree);

            EQUALS108=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeAssignment667); 
            EQUALS108_tree = (CommonTree)adaptor.create(EQUALS108);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS108_tree, root_0);

            STRING109=(Token)match(input,STRING,FOLLOW_STRING_in_attributeAssignment670); 
            STRING109_tree = (CommonTree)adaptor.create(STRING109);
            adaptor.addChild(root_0, STRING109_tree);

            SEMICOLON110=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeAssignment672); 

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

    public static class attributeQualifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributeQualifier"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:316:1: attributeQualifier : 'this' ( arrayList )? PERIOD ;
    public final PhdlParser.attributeQualifier_return attributeQualifier() throws RecognitionException {
        PhdlParser.attributeQualifier_return retval = new PhdlParser.attributeQualifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal111=null;
        Token PERIOD113=null;
        PhdlParser.arrayList_return arrayList112 = null;


        CommonTree string_literal111_tree=null;
        CommonTree PERIOD113_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:322:2: ( 'this' ( arrayList )? PERIOD )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:322:4: 'this' ( arrayList )? PERIOD
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal111=(Token)match(input,38,FOLLOW_38_in_attributeQualifier687); 
            string_literal111_tree = (CommonTree)adaptor.create(string_literal111);
            adaptor.addChild(root_0, string_literal111_tree);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:322:11: ( arrayList )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==LEFTPAREN) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:322:11: arrayList
                    {
                    pushFollow(FOLLOW_arrayList_in_attributeQualifier689);
                    arrayList112=arrayList();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayList112.getTree());

                    }
                    break;

            }

            PERIOD113=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_attributeQualifier692); 
            PERIOD113_tree = (CommonTree)adaptor.create(PERIOD113);
            root_0 = (CommonTree)adaptor.becomeRoot(PERIOD113_tree, root_0);


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
    // $ANTLR end "attributeQualifier"

    public static class pinAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pinAssignment"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:325:1: pinAssignment : pinDescription EQUALS concatenation SEMICOLON ;
    public final PhdlParser.pinAssignment_return pinAssignment() throws RecognitionException {
        PhdlParser.pinAssignment_return retval = new PhdlParser.pinAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQUALS115=null;
        Token SEMICOLON117=null;
        PhdlParser.pinDescription_return pinDescription114 = null;

        PhdlParser.concatenation_return concatenation116 = null;


        CommonTree EQUALS115_tree=null;
        CommonTree SEMICOLON117_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:333:2: ( pinDescription EQUALS concatenation SEMICOLON )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:333:4: pinDescription EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_pinDescription_in_pinAssignment706);
            pinDescription114=pinDescription();

            state._fsp--;

            adaptor.addChild(root_0, pinDescription114.getTree());
            EQUALS115=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinAssignment708); 
            EQUALS115_tree = (CommonTree)adaptor.create(EQUALS115);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS115_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_pinAssignment711);
            concatenation116=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation116.getTree());
            SEMICOLON117=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinAssignment713); 

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

    public static class pinDescription_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pinDescription"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:336:1: pinDescription : ( pinQualifier | pinSpecifier );
    public final PhdlParser.pinDescription_return pinDescription() throws RecognitionException {
        PhdlParser.pinDescription_return retval = new PhdlParser.pinDescription_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        PhdlParser.pinQualifier_return pinQualifier118 = null;

        PhdlParser.pinSpecifier_return pinSpecifier119 = null;



        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:337:3: ( pinQualifier | pinSpecifier )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==36) ) {
                alt28=1;
            }
            else if ( (LA28_0==IDENT||LA28_0==38) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:337:5: pinQualifier
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_pinQualifier_in_pinDescription726);
                    pinQualifier118=pinQualifier();

                    state._fsp--;

                    adaptor.addChild(root_0, pinQualifier118.getTree());

                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:337:20: pinSpecifier
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_pinSpecifier_in_pinDescription730);
                    pinSpecifier119=pinSpecifier();

                    state._fsp--;

                    adaptor.addChild(root_0, pinSpecifier119.getTree());

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
    // $ANTLR end "pinDescription"

    public static class pinQualifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pinQualifier"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:340:1: pinQualifier : 'combine' LEFTPAREN pinSpecifier RIGHTPAREN ;
    public final PhdlParser.pinQualifier_return pinQualifier() throws RecognitionException {
        PhdlParser.pinQualifier_return retval = new PhdlParser.pinQualifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal120=null;
        Token LEFTPAREN121=null;
        Token RIGHTPAREN123=null;
        PhdlParser.pinSpecifier_return pinSpecifier122 = null;


        CommonTree string_literal120_tree=null;
        CommonTree LEFTPAREN121_tree=null;
        CommonTree RIGHTPAREN123_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:344:3: ( 'combine' LEFTPAREN pinSpecifier RIGHTPAREN )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:344:5: 'combine' LEFTPAREN pinSpecifier RIGHTPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal120=(Token)match(input,36,FOLLOW_36_in_pinQualifier746); 
            string_literal120_tree = (CommonTree)adaptor.create(string_literal120);
            adaptor.addChild(root_0, string_literal120_tree);

            LEFTPAREN121=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_pinQualifier748); 
            pushFollow(FOLLOW_pinSpecifier_in_pinQualifier751);
            pinSpecifier122=pinSpecifier();

            state._fsp--;

            adaptor.addChild(root_0, pinSpecifier122.getTree());
            RIGHTPAREN123=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_pinQualifier753); 

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
    // $ANTLR end "pinQualifier"

    public static class netAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "netAssignment"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:347:1: netAssignment : IDENT ( sliceList )? EQUALS concatenation SEMICOLON ;
    public final PhdlParser.netAssignment_return netAssignment() throws RecognitionException {
        PhdlParser.netAssignment_return retval = new PhdlParser.netAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT124=null;
        Token EQUALS126=null;
        Token SEMICOLON128=null;
        PhdlParser.sliceList_return sliceList125 = null;

        PhdlParser.concatenation_return concatenation127 = null;


        CommonTree IDENT124_tree=null;
        CommonTree EQUALS126_tree=null;
        CommonTree SEMICOLON128_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:352:2: ( IDENT ( sliceList )? EQUALS concatenation SEMICOLON )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:352:4: IDENT ( sliceList )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT124=(Token)match(input,IDENT,FOLLOW_IDENT_in_netAssignment768); 
            IDENT124_tree = (CommonTree)adaptor.create(IDENT124);
            adaptor.addChild(root_0, IDENT124_tree);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:352:10: ( sliceList )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==LEFTBRACKET) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:352:10: sliceList
                    {
                    pushFollow(FOLLOW_sliceList_in_netAssignment770);
                    sliceList125=sliceList();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceList125.getTree());

                    }
                    break;

            }

            EQUALS126=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_netAssignment773); 
            EQUALS126_tree = (CommonTree)adaptor.create(EQUALS126);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS126_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_netAssignment776);
            concatenation127=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation127.getTree());
            SEMICOLON128=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netAssignment778); 

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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:355:1: concatenation : ( ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* ) | ( LEFTANGLE IDENT ( sliceList )? RIGHTANGLE ) | 'open' );
    public final PhdlParser.concatenation_return concatenation() throws RecognitionException {
        PhdlParser.concatenation_return retval = new PhdlParser.concatenation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT129=null;
        Token AMPERSAND131=null;
        Token IDENT132=null;
        Token LEFTANGLE134=null;
        Token IDENT135=null;
        Token RIGHTANGLE137=null;
        Token string_literal138=null;
        PhdlParser.sliceList_return sliceList130 = null;

        PhdlParser.sliceList_return sliceList133 = null;

        PhdlParser.sliceList_return sliceList136 = null;


        CommonTree IDENT129_tree=null;
        CommonTree AMPERSAND131_tree=null;
        CommonTree IDENT132_tree=null;
        CommonTree LEFTANGLE134_tree=null;
        CommonTree IDENT135_tree=null;
        CommonTree RIGHTANGLE137_tree=null;
        CommonTree string_literal138_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:361:2: ( ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* ) | ( LEFTANGLE IDENT ( sliceList )? RIGHTANGLE ) | 'open' )
            int alt34=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt34=1;
                }
                break;
            case LEFTANGLE:
                {
                alt34=2;
                }
                break;
            case 41:
                {
                alt34=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:361:4: ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:361:4: ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* )
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:361:5: ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )*
                    {
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:361:5: ( IDENT ( sliceList )? )
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:361:6: IDENT ( sliceList )?
                    {
                    IDENT129=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation795); 
                    IDENT129_tree = (CommonTree)adaptor.create(IDENT129);
                    adaptor.addChild(root_0, IDENT129_tree);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:361:12: ( sliceList )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==LEFTBRACKET) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:361:12: sliceList
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation797);
                            sliceList130=sliceList();

                            state._fsp--;

                            adaptor.addChild(root_0, sliceList130.getTree());

                            }
                            break;

                    }


                    }

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:361:24: ( AMPERSAND IDENT ( sliceList )? )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==AMPERSAND) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:361:25: AMPERSAND IDENT ( sliceList )?
                    	    {
                    	    AMPERSAND131=(Token)match(input,AMPERSAND,FOLLOW_AMPERSAND_in_concatenation802); 
                    	    IDENT132=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation805); 
                    	    IDENT132_tree = (CommonTree)adaptor.create(IDENT132);
                    	    adaptor.addChild(root_0, IDENT132_tree);

                    	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:361:42: ( sliceList )?
                    	    int alt31=2;
                    	    int LA31_0 = input.LA(1);

                    	    if ( (LA31_0==LEFTBRACKET) ) {
                    	        alt31=1;
                    	    }
                    	    switch (alt31) {
                    	        case 1 :
                    	            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:361:42: sliceList
                    	            {
                    	            pushFollow(FOLLOW_sliceList_in_concatenation807);
                    	            sliceList133=sliceList();

                    	            state._fsp--;

                    	            adaptor.addChild(root_0, sliceList133.getTree());

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:362:4: ( LEFTANGLE IDENT ( sliceList )? RIGHTANGLE )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:362:4: ( LEFTANGLE IDENT ( sliceList )? RIGHTANGLE )
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:362:5: LEFTANGLE IDENT ( sliceList )? RIGHTANGLE
                    {
                    LEFTANGLE134=(Token)match(input,LEFTANGLE,FOLLOW_LEFTANGLE_in_concatenation819); 
                    LEFTANGLE134_tree = (CommonTree)adaptor.create(LEFTANGLE134);
                    adaptor.addChild(root_0, LEFTANGLE134_tree);

                    IDENT135=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation821); 
                    IDENT135_tree = (CommonTree)adaptor.create(IDENT135);
                    adaptor.addChild(root_0, IDENT135_tree);

                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:362:21: ( sliceList )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==LEFTBRACKET) ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:362:21: sliceList
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation823);
                            sliceList136=sliceList();

                            state._fsp--;

                            adaptor.addChild(root_0, sliceList136.getTree());

                            }
                            break;

                    }

                    RIGHTANGLE137=(Token)match(input,RIGHTANGLE,FOLLOW_RIGHTANGLE_in_concatenation826); 

                    }


                    }
                    break;
                case 3 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:363:5: 'open'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal138=(Token)match(input,41,FOLLOW_41_in_concatenation834); 
                    string_literal138_tree = (CommonTree)adaptor.create(string_literal138);
                    adaptor.addChild(root_0, string_literal138_tree);


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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:366:1: pinList : LEFTBRACE ( IDENT | INTEGER ) ( COMMA ( IDENT | INTEGER ) )* RIGHTBRACE ;
    public final PhdlParser.pinList_return pinList() throws RecognitionException {
        PhdlParser.pinList_return retval = new PhdlParser.pinList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTBRACE139=null;
        Token set140=null;
        Token COMMA141=null;
        Token set142=null;
        Token RIGHTBRACE143=null;

        CommonTree LEFTBRACE139_tree=null;
        CommonTree set140_tree=null;
        CommonTree COMMA141_tree=null;
        CommonTree set142_tree=null;
        CommonTree RIGHTBRACE143_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:371:2: ( LEFTBRACE ( IDENT | INTEGER ) ( COMMA ( IDENT | INTEGER ) )* RIGHTBRACE )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:371:5: LEFTBRACE ( IDENT | INTEGER ) ( COMMA ( IDENT | INTEGER ) )* RIGHTBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACE139=(Token)match(input,LEFTBRACE,FOLLOW_LEFTBRACE_in_pinList849); 
            set140=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||input.LA(1)==INTEGER ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set140));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:371:34: ( COMMA ( IDENT | INTEGER ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==COMMA) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:371:35: COMMA ( IDENT | INTEGER )
            	    {
            	    COMMA141=(Token)match(input,COMMA,FOLLOW_COMMA_in_pinList861); 
            	    set142=(Token)input.LT(1);
            	    if ( input.LA(1)==IDENT||input.LA(1)==INTEGER ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (CommonTree)adaptor.create(set142));
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            RIGHTBRACE143=(Token)match(input,RIGHTBRACE,FOLLOW_RIGHTBRACE_in_pinList874); 

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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:374:1: sliceList : LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTBRACKET ;
    public final PhdlParser.sliceList_return sliceList() throws RecognitionException {
        PhdlParser.sliceList_return retval = new PhdlParser.sliceList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTBRACKET144=null;
        Token INTEGER145=null;
        Token COLON146=null;
        Token INTEGER147=null;
        Token COMMA148=null;
        Token INTEGER149=null;
        Token COMMA150=null;
        Token INTEGER151=null;
        Token RIGHTBRACKET152=null;

        CommonTree LEFTBRACKET144_tree=null;
        CommonTree INTEGER145_tree=null;
        CommonTree COLON146_tree=null;
        CommonTree INTEGER147_tree=null;
        CommonTree COMMA148_tree=null;
        CommonTree INTEGER149_tree=null;
        CommonTree COMMA150_tree=null;
        CommonTree INTEGER151_tree=null;
        CommonTree RIGHTBRACKET152_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:380:2: ( LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTBRACKET )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:380:5: LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTBRACKET
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACKET144=(Token)match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList890); 
            LEFTBRACKET144_tree = (CommonTree)adaptor.create(LEFTBRACKET144);
            adaptor.addChild(root_0, LEFTBRACKET144_tree);

            INTEGER145=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList892); 
            INTEGER145_tree = (CommonTree)adaptor.create(INTEGER145);
            adaptor.addChild(root_0, INTEGER145_tree);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:380:25: ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==COLON) ) {
                alt38=1;
            }
            else if ( (LA38_0==COMMA||LA38_0==RIGHTBRACKET) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:380:26: ( COLON INTEGER )
                    {
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:380:26: ( COLON INTEGER )
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:380:27: COLON INTEGER
                    {
                    COLON146=(Token)match(input,COLON,FOLLOW_COLON_in_sliceList896); 
                    COLON146_tree = (CommonTree)adaptor.create(COLON146);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON146_tree, root_0);

                    INTEGER147=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList899); 
                    INTEGER147_tree = (CommonTree)adaptor.create(INTEGER147);
                    adaptor.addChild(root_0, INTEGER147_tree);


                    }


                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:380:45: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    {
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:380:45: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==COMMA) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:380:46: COMMA INTEGER ( COMMA INTEGER )*
                            {
                            COMMA148=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceList905); 
                            COMMA148_tree = (CommonTree)adaptor.create(COMMA148);
                            root_0 = (CommonTree)adaptor.becomeRoot(COMMA148_tree, root_0);

                            INTEGER149=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList908); 
                            INTEGER149_tree = (CommonTree)adaptor.create(INTEGER149);
                            adaptor.addChild(root_0, INTEGER149_tree);

                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:380:61: ( COMMA INTEGER )*
                            loop36:
                            do {
                                int alt36=2;
                                int LA36_0 = input.LA(1);

                                if ( (LA36_0==COMMA) ) {
                                    alt36=1;
                                }


                                switch (alt36) {
                            	case 1 :
                            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:380:62: COMMA INTEGER
                            	    {
                            	    COMMA150=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceList911); 
                            	    INTEGER151=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList914); 
                            	    INTEGER151_tree = (CommonTree)adaptor.create(INTEGER151);
                            	    adaptor.addChild(root_0, INTEGER151_tree);


                            	    }
                            	    break;

                            	default :
                            	    break loop36;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }

            RIGHTBRACKET152=(Token)match(input,RIGHTBRACKET,FOLLOW_RIGHTBRACKET_in_sliceList921); 

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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:383:1: sliceDecl : LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RIGHTBRACKET ;
    public final PhdlParser.sliceDecl_return sliceDecl() throws RecognitionException {
        PhdlParser.sliceDecl_return retval = new PhdlParser.sliceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTBRACKET153=null;
        Token INTEGER154=null;
        Token COLON155=null;
        Token INTEGER156=null;
        Token COMMA157=null;
        Token INTEGER158=null;
        Token RIGHTBRACKET159=null;

        CommonTree LEFTBRACKET153_tree=null;
        CommonTree INTEGER154_tree=null;
        CommonTree COLON155_tree=null;
        CommonTree INTEGER156_tree=null;
        CommonTree COMMA157_tree=null;
        CommonTree INTEGER158_tree=null;
        CommonTree RIGHTBRACKET159_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:388:2: ( LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RIGHTBRACKET )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:388:4: LEFTBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RIGHTBRACKET
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTBRACKET153=(Token)match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceDecl935); 
            LEFTBRACKET153_tree = (CommonTree)adaptor.create(LEFTBRACKET153);
            adaptor.addChild(root_0, LEFTBRACKET153_tree);

            INTEGER154=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl937); 
            INTEGER154_tree = (CommonTree)adaptor.create(INTEGER154);
            adaptor.addChild(root_0, INTEGER154_tree);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:388:24: ( ( COLON INTEGER ) | ( COMMA INTEGER )+ )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==COLON) ) {
                alt40=1;
            }
            else if ( (LA40_0==COMMA) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:388:25: ( COLON INTEGER )
                    {
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:388:25: ( COLON INTEGER )
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:388:26: COLON INTEGER
                    {
                    COLON155=(Token)match(input,COLON,FOLLOW_COLON_in_sliceDecl941); 
                    COLON155_tree = (CommonTree)adaptor.create(COLON155);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON155_tree, root_0);

                    INTEGER156=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl944); 
                    INTEGER156_tree = (CommonTree)adaptor.create(INTEGER156);
                    adaptor.addChild(root_0, INTEGER156_tree);


                    }


                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:388:44: ( COMMA INTEGER )+
                    {
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:388:44: ( COMMA INTEGER )+
                    int cnt39=0;
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==COMMA) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:388:45: COMMA INTEGER
                    	    {
                    	    COMMA157=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceDecl950); 
                    	    COMMA157_tree = (CommonTree)adaptor.create(COMMA157);
                    	    root_0 = (CommonTree)adaptor.becomeRoot(COMMA157_tree, root_0);

                    	    INTEGER158=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl953); 
                    	    INTEGER158_tree = (CommonTree)adaptor.create(INTEGER158);
                    	    adaptor.addChild(root_0, INTEGER158_tree);


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt39 >= 1 ) break loop39;
                                EarlyExitException eee =
                                    new EarlyExitException(39, input);
                                throw eee;
                        }
                        cnt39++;
                    } while (true);


                    }
                    break;

            }

            RIGHTBRACKET159=(Token)match(input,RIGHTBRACKET,FOLLOW_RIGHTBRACKET_in_sliceDecl958); 

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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:391:1: arrayList : LEFTPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTPAREN ;
    public final PhdlParser.arrayList_return arrayList() throws RecognitionException {
        PhdlParser.arrayList_return retval = new PhdlParser.arrayList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTPAREN160=null;
        Token INTEGER161=null;
        Token COLON162=null;
        Token INTEGER163=null;
        Token COMMA164=null;
        Token INTEGER165=null;
        Token COMMA166=null;
        Token INTEGER167=null;
        Token RIGHTPAREN168=null;

        CommonTree LEFTPAREN160_tree=null;
        CommonTree INTEGER161_tree=null;
        CommonTree COLON162_tree=null;
        CommonTree INTEGER163_tree=null;
        CommonTree COMMA164_tree=null;
        CommonTree INTEGER165_tree=null;
        CommonTree COMMA166_tree=null;
        CommonTree INTEGER167_tree=null;
        CommonTree RIGHTPAREN168_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:396:2: ( LEFTPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTPAREN )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:396:5: LEFTPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RIGHTPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTPAREN160=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList974); 
            LEFTPAREN160_tree = (CommonTree)adaptor.create(LEFTPAREN160);
            adaptor.addChild(root_0, LEFTPAREN160_tree);

            INTEGER161=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList976); 
            INTEGER161_tree = (CommonTree)adaptor.create(INTEGER161);
            adaptor.addChild(root_0, INTEGER161_tree);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:396:23: ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==COLON) ) {
                alt43=1;
            }
            else if ( (LA43_0==COMMA||LA43_0==RIGHTPAREN) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:396:24: ( COLON INTEGER )
                    {
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:396:24: ( COLON INTEGER )
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:396:25: COLON INTEGER
                    {
                    COLON162=(Token)match(input,COLON,FOLLOW_COLON_in_arrayList980); 
                    COLON162_tree = (CommonTree)adaptor.create(COLON162);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON162_tree, root_0);

                    INTEGER163=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList983); 
                    INTEGER163_tree = (CommonTree)adaptor.create(INTEGER163);
                    adaptor.addChild(root_0, INTEGER163_tree);


                    }


                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:396:43: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    {
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:396:43: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==COMMA) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:396:44: COMMA INTEGER ( COMMA INTEGER )*
                            {
                            COMMA164=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayList989); 
                            COMMA164_tree = (CommonTree)adaptor.create(COMMA164);
                            root_0 = (CommonTree)adaptor.becomeRoot(COMMA164_tree, root_0);

                            INTEGER165=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList992); 
                            INTEGER165_tree = (CommonTree)adaptor.create(INTEGER165);
                            adaptor.addChild(root_0, INTEGER165_tree);

                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:396:59: ( COMMA INTEGER )*
                            loop41:
                            do {
                                int alt41=2;
                                int LA41_0 = input.LA(1);

                                if ( (LA41_0==COMMA) ) {
                                    alt41=1;
                                }


                                switch (alt41) {
                            	case 1 :
                            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:396:60: COMMA INTEGER
                            	    {
                            	    COMMA166=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayList995); 
                            	    INTEGER167=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList998); 
                            	    INTEGER167_tree = (CommonTree)adaptor.create(INTEGER167);
                            	    adaptor.addChild(root_0, INTEGER167_tree);


                            	    }
                            	    break;

                            	default :
                            	    break loop41;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }

            RIGHTPAREN168=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_arrayList1005); 

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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:399:1: arrayDecl : LEFTPAREN INTEGER COLON INTEGER RIGHTPAREN ;
    public final PhdlParser.arrayDecl_return arrayDecl() throws RecognitionException {
        PhdlParser.arrayDecl_return retval = new PhdlParser.arrayDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFTPAREN169=null;
        Token INTEGER170=null;
        Token COLON171=null;
        Token INTEGER172=null;
        Token RIGHTPAREN173=null;

        CommonTree LEFTPAREN169_tree=null;
        CommonTree INTEGER170_tree=null;
        CommonTree COLON171_tree=null;
        CommonTree INTEGER172_tree=null;
        CommonTree RIGHTPAREN173_tree=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:404:2: ( LEFTPAREN INTEGER COLON INTEGER RIGHTPAREN )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:404:4: LEFTPAREN INTEGER COLON INTEGER RIGHTPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            LEFTPAREN169=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayDecl1019); 
            LEFTPAREN169_tree = (CommonTree)adaptor.create(LEFTPAREN169);
            adaptor.addChild(root_0, LEFTPAREN169_tree);

            INTEGER170=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayDecl1021); 
            INTEGER170_tree = (CommonTree)adaptor.create(INTEGER170);
            adaptor.addChild(root_0, INTEGER170_tree);

            COLON171=(Token)match(input,COLON,FOLLOW_COLON_in_arrayDecl1023); 
            COLON171_tree = (CommonTree)adaptor.create(COLON171);
            root_0 = (CommonTree)adaptor.becomeRoot(COLON171_tree, root_0);

            INTEGER172=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayDecl1026); 
            INTEGER172_tree = (CommonTree)adaptor.create(INTEGER172);
            adaptor.addChild(root_0, INTEGER172_tree);

            RIGHTPAREN173=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_arrayDecl1028); 

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


    protected DFA12 dfa12 = new DFA12(this);
    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA12_eotS =
        "\22\uffff";
    static final String DFA12_eofS =
        "\22\uffff";
    static final String DFA12_minS =
        "\1\4\2\uffff\1\13\1\10\2\uffff\1\21\2\4\1\12\2\21\1\15\1\14\1\12"+
        "\1\21\1\12";
    static final String DFA12_maxS =
        "\1\47\2\uffff\1\15\1\22\2\uffff\1\21\1\4\1\51\1\23\2\21\1\15\2\14"+
        "\1\21\1\14";
    static final String DFA12_acceptS =
        "\1\uffff\1\4\1\1\2\uffff\1\2\1\3\13\uffff";
    static final String DFA12_specialS =
        "\22\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\4\1\uffff\1\1\35\uffff\1\5\1\2\1\3\1\6",
            "",
            "",
            "\1\7\1\uffff\1\10",
            "\1\11\11\uffff\1\5",
            "",
            "",
            "\1\12",
            "\1\4",
            "\1\5\4\uffff\1\2\5\uffff\1\5\31\uffff\1\5",
            "\1\14\1\uffff\1\15\6\uffff\1\13",
            "\1\16",
            "\1\17",
            "\1\10",
            "\1\15",
            "\1\20\1\uffff\1\15",
            "\1\21",
            "\1\20\1\uffff\1\15"
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "()* loopback of 245:3: ( attributeAssignment | pinAssignment | infoStruct )*";
        }
    }
    static final String DFA15_eotS =
        "\20\uffff";
    static final String DFA15_eofS =
        "\20\uffff";
    static final String DFA15_minS =
        "\1\4\1\uffff\1\13\1\10\1\uffff\1\21\2\4\1\12\2\21\1\15\1\14\1\12"+
        "\1\21\1\12";
    static final String DFA15_maxS =
        "\1\46\1\uffff\1\15\1\22\1\uffff\1\21\1\4\1\51\1\23\2\21\1\15\2\14"+
        "\1\21\1\14";
    static final String DFA15_acceptS =
        "\1\uffff\1\1\2\uffff\1\2\13\uffff";
    static final String DFA15_specialS =
        "\20\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\3\37\uffff\1\1\1\4\1\2",
            "",
            "\1\5\1\uffff\1\6",
            "\1\7\2\uffff\1\4\1\uffff\1\4\4\uffff\1\1",
            "",
            "\1\10",
            "\1\3",
            "\1\1\4\uffff\1\4\5\uffff\1\1\31\uffff\1\1",
            "\1\12\1\uffff\1\13\6\uffff\1\11",
            "\1\14",
            "\1\15",
            "\1\6",
            "\1\13",
            "\1\16\1\uffff\1\13",
            "\1\17",
            "\1\16\1\uffff\1\13"
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "258:1: subAssignment : ( portAssignment | subAttrAssignment );";
        }
    }
 

    public static final BitSet FOLLOW_designDecl_in_sourceText79 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_EOF_in_sourceText82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_designDecl95 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_designDecl98 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LEFTBRACE_in_designDecl100 = new BitSet(new long[]{0x0000018B30000050L});
    public static final BitSet FOLLOW_deviceDecl_in_designDecl107 = new BitSet(new long[]{0x0000018B30000050L});
    public static final BitSet FOLLOW_netDecl_in_designDecl111 = new BitSet(new long[]{0x0000018B30000050L});
    public static final BitSet FOLLOW_infoStruct_in_designDecl115 = new BitSet(new long[]{0x0000018B30000050L});
    public static final BitSet FOLLOW_instanceDecl_in_designDecl119 = new BitSet(new long[]{0x0000018B30000050L});
    public static final BitSet FOLLOW_netAssignment_in_designDecl123 = new BitSet(new long[]{0x0000018B30000050L});
    public static final BitSet FOLLOW_groupStruct_in_designDecl127 = new BitSet(new long[]{0x0000018B30000050L});
    public static final BitSet FOLLOW_subDesignInstance_in_designDecl131 = new BitSet(new long[]{0x0000018B30000050L});
    public static final BitSet FOLLOW_portDecl_in_designDecl135 = new BitSet(new long[]{0x0000018B30000050L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_designDecl141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_portDecl155 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_sliceDecl_in_portDecl157 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_portDecl160 = new BitSet(new long[]{0x0000000000000480L});
    public static final BitSet FOLLOW_COMMA_in_portDecl163 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_portDecl165 = new BitSet(new long[]{0x0000000000000480L});
    public static final BitSet FOLLOW_SEMICOLON_in_portDecl169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_deviceDecl184 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl187 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LEFTBRACE_in_deviceDecl189 = new BitSet(new long[]{0x00000000C0000040L});
    public static final BitSet FOLLOW_attributeDecl_in_deviceDecl196 = new BitSet(new long[]{0x00000000C0000040L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl200 = new BitSet(new long[]{0x00000000C0000040L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_deviceDecl207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_attributeDecl222 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attributeDecl225 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_attributeDecl227 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_STRING_in_attributeDecl230 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeDecl232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_pinDecl246 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_sliceDecl_in_pinDecl249 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl252 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_pinDecl254 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_pinList_in_pinDecl257 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinDecl259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_type274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_netDecl287 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_sliceDecl_in_netDecl290 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl293 = new BitSet(new long[]{0x00000000000004A0L});
    public static final BitSet FOLLOW_COMMA_in_netDecl296 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl298 = new BitSet(new long[]{0x00000000000004A0L});
    public static final BitSet FOLLOW_netAttributes_in_netDecl303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_netDecl307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACE_in_netAttributes323 = new BitSet(new long[]{0x0000000040000040L});
    public static final BitSet FOLLOW_attributeDecl_in_netAttributes326 = new BitSet(new long[]{0x0000000040000040L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_netAttributes329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_instanceDecl343 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_arrayDecl_in_instanceDecl346 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instanceDecl349 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_instanceDecl351 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instanceDecl354 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LEFTBRACE_in_instanceDecl356 = new BitSet(new long[]{0x000000F000000050L});
    public static final BitSet FOLLOW_attributeAssignment_in_instanceDecl362 = new BitSet(new long[]{0x000000F000000050L});
    public static final BitSet FOLLOW_pinAssignment_in_instanceDecl366 = new BitSet(new long[]{0x000000F000000050L});
    public static final BitSet FOLLOW_infoStruct_in_instanceDecl370 = new BitSet(new long[]{0x000000F000000050L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_instanceDecl376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_subDesignInstance390 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_arrayDecl_in_subDesignInstance393 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_subDesignInstance396 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_subDesignInstance398 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_subDesignInstance401 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LEFTBRACE_in_subDesignInstance403 = new BitSet(new long[]{0x000000F000000050L});
    public static final BitSet FOLLOW_subAssignment_in_subDesignInstance411 = new BitSet(new long[]{0x000000F000000050L});
    public static final BitSet FOLLOW_infoStruct_in_subDesignInstance415 = new BitSet(new long[]{0x000000F000000050L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_subDesignInstance423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_portAssignment_in_subAssignment439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subAttrAssignment_in_subAssignment445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_combineQualifier_in_portAssignment461 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_pinSpecifier_in_portAssignment465 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_portAssignment468 = new BitSet(new long[]{0x0000020000008010L});
    public static final BitSet FOLLOW_concatenation_in_portAssignment471 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_SEMICOLON_in_portAssignment473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_combineQualifier487 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LEFTPAREN_in_combineQualifier490 = new BitSet(new long[]{0x0000005000000010L});
    public static final BitSet FOLLOW_pinSpecifier_in_combineQualifier493 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RIGHTPAREN_in_combineQualifier495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayQualifier_in_pinSpecifier511 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinSpecifier514 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_sliceList_in_pinSpecifier517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_subAttrAssignment531 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_arrayQualifier_in_subAttrAssignment534 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_instSpecifier_in_subAttrAssignment537 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_subAttrAssignment540 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_subAttrAssignment542 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_STRING_in_subAttrAssignment545 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_SEMICOLON_in_subAttrAssignment547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_arrayQualifier564 = new BitSet(new long[]{0x0000000000002800L});
    public static final BitSet FOLLOW_arrayList_in_arrayQualifier566 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_PERIOD_in_arrayQualifier569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_instSpecifier582 = new BitSet(new long[]{0x0000000000002800L});
    public static final BitSet FOLLOW_arrayList_in_instSpecifier584 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_PERIOD_in_instSpecifier587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_infoStruct603 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LEFTBRACE_in_infoStruct606 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_STRING_in_infoStruct609 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_infoStruct611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_groupStruct626 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_STRING_in_groupStruct629 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LEFTBRACE_in_groupStruct631 = new BitSet(new long[]{0x0000000200000050L});
    public static final BitSet FOLLOW_instanceDecl_in_groupStruct635 = new BitSet(new long[]{0x0000000200000050L});
    public static final BitSet FOLLOW_netAssignment_in_groupStruct639 = new BitSet(new long[]{0x0000000200000050L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_groupStruct643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_attributeAssignment658 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_attributeQualifier_in_attributeAssignment662 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attributeAssignment665 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_attributeAssignment667 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_STRING_in_attributeAssignment670 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeAssignment672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_attributeQualifier687 = new BitSet(new long[]{0x0000000000002800L});
    public static final BitSet FOLLOW_arrayList_in_attributeQualifier689 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_PERIOD_in_attributeQualifier692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pinDescription_in_pinAssignment706 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssignment708 = new BitSet(new long[]{0x0000020000008010L});
    public static final BitSet FOLLOW_concatenation_in_pinAssignment711 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinAssignment713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pinQualifier_in_pinDescription726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pinSpecifier_in_pinDescription730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_pinQualifier746 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LEFTPAREN_in_pinQualifier748 = new BitSet(new long[]{0x0000005000000010L});
    public static final BitSet FOLLOW_pinSpecifier_in_pinQualifier751 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RIGHTPAREN_in_pinQualifier753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_netAssignment768 = new BitSet(new long[]{0x0000000000040100L});
    public static final BitSet FOLLOW_sliceList_in_netAssignment770 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_EQUALS_in_netAssignment773 = new BitSet(new long[]{0x0000020000008010L});
    public static final BitSet FOLLOW_concatenation_in_netAssignment776 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_SEMICOLON_in_netAssignment778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_concatenation795 = new BitSet(new long[]{0x0000000000044002L});
    public static final BitSet FOLLOW_sliceList_in_concatenation797 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_AMPERSAND_in_concatenation802 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation805 = new BitSet(new long[]{0x0000000000044002L});
    public static final BitSet FOLLOW_sliceList_in_concatenation807 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_LEFTANGLE_in_concatenation819 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation821 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_sliceList_in_concatenation823 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RIGHTANGLE_in_concatenation826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_concatenation834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACE_in_pinList849 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_set_in_pinList852 = new BitSet(new long[]{0x0000000000000440L});
    public static final BitSet FOLLOW_COMMA_in_pinList861 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_set_in_pinList864 = new BitSet(new long[]{0x0000000000000440L});
    public static final BitSet FOLLOW_RIGHTBRACE_in_pinList874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList890 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList892 = new BitSet(new long[]{0x0000000000180400L});
    public static final BitSet FOLLOW_COLON_in_sliceList896 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList899 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_sliceList905 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList908 = new BitSet(new long[]{0x0000000000100400L});
    public static final BitSet FOLLOW_COMMA_in_sliceList911 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList914 = new BitSet(new long[]{0x0000000000100400L});
    public static final BitSet FOLLOW_RIGHTBRACKET_in_sliceList921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceDecl935 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl937 = new BitSet(new long[]{0x0000000000080400L});
    public static final BitSet FOLLOW_COLON_in_sliceDecl941 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl944 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_COMMA_in_sliceDecl950 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl953 = new BitSet(new long[]{0x0000000000100400L});
    public static final BitSet FOLLOW_RIGHTBRACKET_in_sliceDecl958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList974 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList976 = new BitSet(new long[]{0x0000000000081400L});
    public static final BitSet FOLLOW_COLON_in_arrayList980 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList983 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_COMMA_in_arrayList989 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList992 = new BitSet(new long[]{0x0000000000001400L});
    public static final BitSet FOLLOW_COMMA_in_arrayList995 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList998 = new BitSet(new long[]{0x0000000000001400L});
    public static final BitSet FOLLOW_RIGHTPAREN_in_arrayList1005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayDecl1019 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayDecl1021 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_COLON_in_arrayDecl1023 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayDecl1026 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RIGHTPAREN_in_arrayDecl1028 = new BitSet(new long[]{0x0000000000000002L});

}