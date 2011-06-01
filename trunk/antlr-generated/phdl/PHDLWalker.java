// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\work\\phdl\\src\\phdl\\PHDLWalker.g 2011-05-31 16:01:03

  package phdl;
  import phdl.PHDLDesign;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class PHDLWalker extends TreeParser {
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


        public PHDLWalker(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public PHDLWalker(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PHDLWalker.tokenNames; }
    public String getGrammarFileName() { return "C:\\work\\phdl\\src\\phdl\\PHDLWalker.g"; }


      private PHDLDesign design;



    // $ANTLR start "sourceText"
    // C:\\work\\phdl\\src\\phdl\\PHDLWalker.g:18:1: sourceText returns [PHDLDesign design] : design ;
    public final PHDLDesign sourceText() throws RecognitionException {
        PHDLDesign design = null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDLWalker.g:19:2: ( design )
            // C:\\work\\phdl\\src\\phdl\\PHDLWalker.g:19:4: design
            {
            pushFollow(FOLLOW_design_in_sourceText61);
            design();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return design;
    }
    // $ANTLR end "sourceText"


    // $ANTLR start "design"
    // C:\\work\\phdl\\src\\phdl\\PHDLWalker.g:22:1: design : ^( 'design' IDENT ( deviceDecl )* ) ;
    public final void design() throws RecognitionException {
        CommonTree IDENT1=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDLWalker.g:23:2: ( ^( 'design' IDENT ( deviceDecl )* ) )
            // C:\\work\\phdl\\src\\phdl\\PHDLWalker.g:23:4: ^( 'design' IDENT ( deviceDecl )* )
            {
            match(input,13,FOLLOW_13_in_design75); 

            match(input, Token.DOWN, null); 
            IDENT1=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_design77); 
            // C:\\work\\phdl\\src\\phdl\\PHDLWalker.g:23:21: ( deviceDecl )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==19) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\PHDLWalker.g:23:22: deviceDecl
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_design80);
            	    deviceDecl();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match(input, Token.UP, null); 
            design = new PHDLDesign((IDENT1!=null?IDENT1.getText():null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "design"


    // $ANTLR start "deviceDecl"
    // C:\\work\\phdl\\src\\phdl\\PHDLWalker.g:26:1: deviceDecl : ^( 'device' IDENT ( attrDecl[device] )* 'begin' ) ;
    public final void deviceDecl() throws RecognitionException {
        CommonTree IDENT2=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDLWalker.g:27:2: ( ^( 'device' IDENT ( attrDecl[device] )* 'begin' ) )
            // C:\\work\\phdl\\src\\phdl\\PHDLWalker.g:27:4: ^( 'device' IDENT ( attrDecl[device] )* 'begin' )
            {
            match(input,19,FOLLOW_19_in_deviceDecl98); 

            match(input, Token.DOWN, null); 
            IDENT2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl100); 
            PHDLDevice device = new PHDLDevice((IDENT2!=null?IDENT2.getText():null));
            // C:\\work\\phdl\\src\\phdl\\PHDLWalker.g:28:3: ( attrDecl[device] )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==22) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\PHDLWalker.g:28:3: attrDecl[device]
            	    {
            	    pushFollow(FOLLOW_attrDecl_in_deviceDecl109);
            	    attrDecl(device);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match(input,15,FOLLOW_15_in_deviceDecl115); 

            match(input, Token.UP, null); 
            design.addDevice(device);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "deviceDecl"


    // $ANTLR start "attrDecl"
    // C:\\work\\phdl\\src\\phdl\\PHDLWalker.g:39:1: attrDecl[PHDLDevice device] : ^( '=' name= IDENT value= STRING_LITERAL ) ;
    public final void attrDecl(PHDLDevice device) throws RecognitionException {
        CommonTree name=null;
        CommonTree value=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\PHDLWalker.g:40:2: ( ^( '=' name= IDENT value= STRING_LITERAL ) )
            // C:\\work\\phdl\\src\\phdl\\PHDLWalker.g:40:4: ^( '=' name= IDENT value= STRING_LITERAL )
            {
            match(input,22,FOLLOW_22_in_attrDecl146); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attrDecl150); 
            value=(CommonTree)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_attrDecl154); 

            match(input, Token.UP, null); 
            PHDLAttribute a = new PHDLAttribute((name!=null?name.getText():null), (value!=null?value.getText():null));
            device.addAttribute(a);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "attrDecl"

    // Delegated rules


 

    public static final BitSet FOLLOW_design_in_sourceText61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_design75 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_design77 = new BitSet(new long[]{0x0000000000080008L});
    public static final BitSet FOLLOW_deviceDecl_in_design80 = new BitSet(new long[]{0x0000000000080008L});
    public static final BitSet FOLLOW_19_in_deviceDecl98 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl100 = new BitSet(new long[]{0x0000000000408000L});
    public static final BitSet FOLLOW_attrDecl_in_deviceDecl109 = new BitSet(new long[]{0x0000000000408000L});
    public static final BitSet FOLLOW_15_in_deviceDecl115 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_22_in_attrDecl146 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_attrDecl150 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_attrDecl154 = new BitSet(new long[]{0x0000000000000008L});

}