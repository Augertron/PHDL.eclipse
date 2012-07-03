package edu.byu.ee.phdl.ui.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPhdlLexer extends Lexer {
    public static final int RULE_ID=46;
    public static final int KEYWORD_19=22;
    public static final int KEYWORD_17=28;
    public static final int KEYWORD_18=29;
    public static final int KEYWORD_15=45;
    public static final int KEYWORD_16=30;
    public static final int KEYWORD_13=43;
    public static final int KEYWORD_14=44;
    public static final int KEYWORD_11=41;
    public static final int EOF=-1;
    public static final int KEYWORD_12=42;
    public static final int KEYWORD_10=40;
    public static final int KEYWORD_6=36;
    public static final int KEYWORD_7=37;
    public static final int KEYWORD_8=38;
    public static final int KEYWORD_9=39;
    public static final int KEYWORD_28=20;
    public static final int KEYWORD_29=21;
    public static final int RULE_INT=47;
    public static final int KEYWORD_24=27;
    public static final int KEYWORD_25=17;
    public static final int KEYWORD_26=18;
    public static final int KEYWORD_27=19;
    public static final int KEYWORD_20=23;
    public static final int KEYWORD_21=24;
    public static final int KEYWORD_22=25;
    public static final int KEYWORD_23=26;
    public static final int KEYWORD_30=10;
    public static final int KEYWORD_1=31;
    public static final int KEYWORD_34=14;
    public static final int KEYWORD_5=35;
    public static final int KEYWORD_33=13;
    public static final int KEYWORD_4=34;
    public static final int KEYWORD_32=12;
    public static final int KEYWORD_3=33;
    public static final int KEYWORD_31=11;
    public static final int KEYWORD_2=32;
    public static final int KEYWORD_38=6;
    public static final int RULE_SL_COMMENT=51;
    public static final int KEYWORD_37=5;
    public static final int KEYWORD_36=16;
    public static final int KEYWORD_35=15;
    public static final int RULE_ML_COMMENT=50;
    public static final int KEYWORD_39=7;
    public static final int RULE_STRING=49;
    public static final int KEYWORD_41=9;
    public static final int RULE_PINNUM=48;
    public static final int KEYWORD_40=8;
    public static final int KEYWORD_42=4;
    public static final int RULE_WS=52;

    // delegates
    // delegators

    public InternalPhdlLexer() {;} 
    public InternalPhdlLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalPhdlLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g"; }

    // $ANTLR start "KEYWORD_42"
    public final void mKEYWORD_42() throws RecognitionException {
        try {
            int _type = KEYWORD_42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:19:12: ( 'subdesign' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:19:14: 'subdesign'
            {
            match("subdesign"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_42"

    // $ANTLR start "KEYWORD_37"
    public final void mKEYWORD_37() throws RecognitionException {
        try {
            int _type = KEYWORD_37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:21:12: ( 'combine' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:21:14: 'combine'
            {
            match("combine"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_37"

    // $ANTLR start "KEYWORD_38"
    public final void mKEYWORD_38() throws RecognitionException {
        try {
            int _type = KEYWORD_38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:23:12: ( 'newattr' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:23:14: 'newattr'
            {
            match("newattr"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_38"

    // $ANTLR start "KEYWORD_39"
    public final void mKEYWORD_39() throws RecognitionException {
        try {
            int _type = KEYWORD_39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:25:12: ( 'package' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:25:14: 'package'
            {
            match("package"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_39"

    // $ANTLR start "KEYWORD_40"
    public final void mKEYWORD_40() throws RecognitionException {
        try {
            int _type = KEYWORD_40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:27:12: ( 'passpin' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:27:14: 'passpin'
            {
            match("passpin"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_40"

    // $ANTLR start "KEYWORD_41"
    public final void mKEYWORD_41() throws RecognitionException {
        try {
            int _type = KEYWORD_41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:29:12: ( 'subinst' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:29:14: 'subinst'
            {
            match("subinst"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_41"

    // $ANTLR start "KEYWORD_30"
    public final void mKEYWORD_30() throws RecognitionException {
        try {
            int _type = KEYWORD_30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:31:12: ( 'design' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:31:14: 'design'
            {
            match("design"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_30"

    // $ANTLR start "KEYWORD_31"
    public final void mKEYWORD_31() throws RecognitionException {
        try {
            int _type = KEYWORD_31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:33:12: ( 'device' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:33:14: 'device'
            {
            match("device"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_31"

    // $ANTLR start "KEYWORD_32"
    public final void mKEYWORD_32() throws RecognitionException {
        try {
            int _type = KEYWORD_32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:35:12: ( 'import' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:35:14: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_32"

    // $ANTLR start "KEYWORD_33"
    public final void mKEYWORD_33() throws RecognitionException {
        try {
            int _type = KEYWORD_33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:37:12: ( 'outpin' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:37:14: 'outpin'
            {
            match("outpin"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_33"

    // $ANTLR start "KEYWORD_34"
    public final void mKEYWORD_34() throws RecognitionException {
        try {
            int _type = KEYWORD_34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:39:12: ( 'pwrpin' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:39:14: 'pwrpin'
            {
            match("pwrpin"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_34"

    // $ANTLR start "KEYWORD_35"
    public final void mKEYWORD_35() throws RecognitionException {
        try {
            int _type = KEYWORD_35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:41:12: ( 'suppin' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:41:14: 'suppin'
            {
            match("suppin"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_35"

    // $ANTLR start "KEYWORD_36"
    public final void mKEYWORD_36() throws RecognitionException {
        try {
            int _type = KEYWORD_36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:43:12: ( 'tripin' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:43:14: 'tripin'
            {
            match("tripin"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_36"

    // $ANTLR start "KEYWORD_25"
    public final void mKEYWORD_25() throws RecognitionException {
        try {
            int _type = KEYWORD_25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:45:12: ( 'inpin' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:45:14: 'inpin'
            {
            match("inpin"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_25"

    // $ANTLR start "KEYWORD_26"
    public final void mKEYWORD_26() throws RecognitionException {
        try {
            int _type = KEYWORD_26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:47:12: ( 'iopin' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:47:14: 'iopin'
            {
            match("iopin"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_26"

    // $ANTLR start "KEYWORD_27"
    public final void mKEYWORD_27() throws RecognitionException {
        try {
            int _type = KEYWORD_27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:49:12: ( 'ncpin' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:49:14: 'ncpin'
            {
            match("ncpin"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_27"

    // $ANTLR start "KEYWORD_28"
    public final void mKEYWORD_28() throws RecognitionException {
        try {
            int _type = KEYWORD_28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:51:12: ( 'ocpin' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:51:14: 'ocpin'
            {
            match("ocpin"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_28"

    // $ANTLR start "KEYWORD_29"
    public final void mKEYWORD_29() throws RecognitionException {
        try {
            int _type = KEYWORD_29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:53:12: ( 'oepin' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:53:14: 'oepin'
            {
            match("oepin"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_29"

    // $ANTLR start "KEYWORD_19"
    public final void mKEYWORD_19() throws RecognitionException {
        try {
            int _type = KEYWORD_19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:55:12: ( 'attr' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:55:14: 'attr'
            {
            match("attr"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_19"

    // $ANTLR start "KEYWORD_20"
    public final void mKEYWORD_20() throws RecognitionException {
        try {
            int _type = KEYWORD_20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:57:12: ( 'info' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:57:14: 'info'
            {
            match("info"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_20"

    // $ANTLR start "KEYWORD_21"
    public final void mKEYWORD_21() throws RecognitionException {
        try {
            int _type = KEYWORD_21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:59:12: ( 'inst' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:59:14: 'inst'
            {
            match("inst"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_21"

    // $ANTLR start "KEYWORD_22"
    public final void mKEYWORD_22() throws RecognitionException {
        try {
            int _type = KEYWORD_22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:61:12: ( 'open' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:61:14: 'open'
            {
            match("open"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_22"

    // $ANTLR start "KEYWORD_23"
    public final void mKEYWORD_23() throws RecognitionException {
        try {
            int _type = KEYWORD_23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:63:12: ( 'port' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:63:14: 'port'
            {
            match("port"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_23"

    // $ANTLR start "KEYWORD_24"
    public final void mKEYWORD_24() throws RecognitionException {
        try {
            int _type = KEYWORD_24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:65:12: ( 'this' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:65:14: 'this'
            {
            match("this"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_24"

    // $ANTLR start "KEYWORD_17"
    public final void mKEYWORD_17() throws RecognitionException {
        try {
            int _type = KEYWORD_17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:67:12: ( 'net' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:67:14: 'net'
            {
            match("net"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_17"

    // $ANTLR start "KEYWORD_18"
    public final void mKEYWORD_18() throws RecognitionException {
        try {
            int _type = KEYWORD_18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:69:12: ( 'pin' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:69:14: 'pin'
            {
            match("pin"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_18"

    // $ANTLR start "KEYWORD_16"
    public final void mKEYWORD_16() throws RecognitionException {
        try {
            int _type = KEYWORD_16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:71:12: ( 'of' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:71:14: 'of'
            {
            match("of"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_16"

    // $ANTLR start "KEYWORD_1"
    public final void mKEYWORD_1() throws RecognitionException {
        try {
            int _type = KEYWORD_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:73:11: ( '&' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:73:13: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_1"

    // $ANTLR start "KEYWORD_2"
    public final void mKEYWORD_2() throws RecognitionException {
        try {
            int _type = KEYWORD_2;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:75:11: ( '(' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:75:13: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_2"

    // $ANTLR start "KEYWORD_3"
    public final void mKEYWORD_3() throws RecognitionException {
        try {
            int _type = KEYWORD_3;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:77:11: ( ')' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:77:13: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_3"

    // $ANTLR start "KEYWORD_4"
    public final void mKEYWORD_4() throws RecognitionException {
        try {
            int _type = KEYWORD_4;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:79:11: ( '*' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:79:13: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_4"

    // $ANTLR start "KEYWORD_5"
    public final void mKEYWORD_5() throws RecognitionException {
        try {
            int _type = KEYWORD_5;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:81:11: ( ',' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:81:13: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_5"

    // $ANTLR start "KEYWORD_6"
    public final void mKEYWORD_6() throws RecognitionException {
        try {
            int _type = KEYWORD_6;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:83:11: ( '.' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:83:13: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_6"

    // $ANTLR start "KEYWORD_7"
    public final void mKEYWORD_7() throws RecognitionException {
        try {
            int _type = KEYWORD_7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:85:11: ( ':' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:85:13: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_7"

    // $ANTLR start "KEYWORD_8"
    public final void mKEYWORD_8() throws RecognitionException {
        try {
            int _type = KEYWORD_8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:87:11: ( ';' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:87:13: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_8"

    // $ANTLR start "KEYWORD_9"
    public final void mKEYWORD_9() throws RecognitionException {
        try {
            int _type = KEYWORD_9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:89:11: ( '<' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:89:13: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_9"

    // $ANTLR start "KEYWORD_10"
    public final void mKEYWORD_10() throws RecognitionException {
        try {
            int _type = KEYWORD_10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:91:12: ( '=' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:91:14: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_10"

    // $ANTLR start "KEYWORD_11"
    public final void mKEYWORD_11() throws RecognitionException {
        try {
            int _type = KEYWORD_11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:93:12: ( '>' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:93:14: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_11"

    // $ANTLR start "KEYWORD_12"
    public final void mKEYWORD_12() throws RecognitionException {
        try {
            int _type = KEYWORD_12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:95:12: ( '[' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:95:14: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_12"

    // $ANTLR start "KEYWORD_13"
    public final void mKEYWORD_13() throws RecognitionException {
        try {
            int _type = KEYWORD_13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:97:12: ( ']' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:97:14: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_13"

    // $ANTLR start "KEYWORD_14"
    public final void mKEYWORD_14() throws RecognitionException {
        try {
            int _type = KEYWORD_14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:99:12: ( '{' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:99:14: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_14"

    // $ANTLR start "KEYWORD_15"
    public final void mKEYWORD_15() throws RecognitionException {
        try {
            int _type = KEYWORD_15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:101:12: ( '}' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:101:14: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_15"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:105:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:105:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:105:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:105:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:105:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:107:10: ( ( '0' .. '9' | '1' .. '9' ( '0' .. '9' )+ ) )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:107:12: ( '0' .. '9' | '1' .. '9' ( '0' .. '9' )+ )
            {
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:107:12: ( '0' .. '9' | '1' .. '9' ( '0' .. '9' )+ )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>='1' && LA4_0<='9')) ) {
                int LA4_1 = input.LA(2);

                if ( ((LA4_1>='0' && LA4_1<='9')) ) {
                    alt4=2;
                }
                else {
                    alt4=1;}
            }
            else if ( (LA4_0=='0') ) {
                alt4=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:107:13: '0' .. '9'
                    {
                    matchRange('0','9'); 

                    }
                    break;
                case 2 :
                    // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:107:22: '1' .. '9' ( '0' .. '9' )+
                    {
                    matchRange('1','9'); 
                    // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:107:31: ( '0' .. '9' )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:107:32: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

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


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_PINNUM"
    public final void mRULE_PINNUM() throws RecognitionException {
        try {
            int _type = RULE_PINNUM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:109:13: ( ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '+' | '-' | '$' | '/' | '@' )+ )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:109:15: ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '+' | '-' | '$' | '/' | '@' )+
            {
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:109:15: ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '+' | '-' | '$' | '/' | '@' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='$'||LA5_0=='+'||LA5_0=='-'||(LA5_0>='/' && LA5_0<='9')||(LA5_0>='@' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:
            	    {
            	    if ( input.LA(1)=='$'||input.LA(1)=='+'||input.LA(1)=='-'||(input.LA(1)>='/' && input.LA(1)<='9')||(input.LA(1)>='@' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_PINNUM"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:111:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:111:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:111:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\"') ) {
                alt8=1;
            }
            else if ( (LA8_0=='\'') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:111:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:111:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop6:
                    do {
                        int alt6=3;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0=='\\') ) {
                            alt6=1;
                        }
                        else if ( ((LA6_0>='\u0000' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFF')) ) {
                            alt6=2;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:111:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:111:66: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:111:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:111:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop7:
                    do {
                        int alt7=3;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='\\') ) {
                            alt7=1;
                        }
                        else if ( ((LA7_0>='\u0000' && LA7_0<='&')||(LA7_0>='(' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFF')) ) {
                            alt7=2;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:111:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:111:137: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:113:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:113:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:113:24: ( options {greedy=false; } : . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='*') ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1=='/') ) {
                        alt9=2;
                    }
                    else if ( ((LA9_1>='\u0000' && LA9_1<='.')||(LA9_1>='0' && LA9_1<='\uFFFF')) ) {
                        alt9=1;
                    }


                }
                else if ( ((LA9_0>='\u0000' && LA9_0<=')')||(LA9_0>='+' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:113:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:115:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:115:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:115:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:115:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:115:40: ( ( '\\r' )? '\\n' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\n'||LA12_0=='\r') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:115:41: ( '\\r' )? '\\n'
                    {
                    // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:115:41: ( '\\r' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='\r') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:115:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:117:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:117:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:117:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    public void mTokens() throws RecognitionException {
        // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:8: ( KEYWORD_42 | KEYWORD_37 | KEYWORD_38 | KEYWORD_39 | KEYWORD_40 | KEYWORD_41 | KEYWORD_30 | KEYWORD_31 | KEYWORD_32 | KEYWORD_33 | KEYWORD_34 | KEYWORD_35 | KEYWORD_36 | KEYWORD_25 | KEYWORD_26 | KEYWORD_27 | KEYWORD_28 | KEYWORD_29 | KEYWORD_19 | KEYWORD_20 | KEYWORD_21 | KEYWORD_22 | KEYWORD_23 | KEYWORD_24 | KEYWORD_17 | KEYWORD_18 | KEYWORD_16 | KEYWORD_1 | KEYWORD_2 | KEYWORD_3 | KEYWORD_4 | KEYWORD_5 | KEYWORD_6 | KEYWORD_7 | KEYWORD_8 | KEYWORD_9 | KEYWORD_10 | KEYWORD_11 | KEYWORD_12 | KEYWORD_13 | KEYWORD_14 | KEYWORD_15 | RULE_ID | RULE_INT | RULE_PINNUM | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS )
        int alt14=49;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:10: KEYWORD_42
                {
                mKEYWORD_42(); 

                }
                break;
            case 2 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:21: KEYWORD_37
                {
                mKEYWORD_37(); 

                }
                break;
            case 3 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:32: KEYWORD_38
                {
                mKEYWORD_38(); 

                }
                break;
            case 4 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:43: KEYWORD_39
                {
                mKEYWORD_39(); 

                }
                break;
            case 5 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:54: KEYWORD_40
                {
                mKEYWORD_40(); 

                }
                break;
            case 6 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:65: KEYWORD_41
                {
                mKEYWORD_41(); 

                }
                break;
            case 7 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:76: KEYWORD_30
                {
                mKEYWORD_30(); 

                }
                break;
            case 8 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:87: KEYWORD_31
                {
                mKEYWORD_31(); 

                }
                break;
            case 9 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:98: KEYWORD_32
                {
                mKEYWORD_32(); 

                }
                break;
            case 10 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:109: KEYWORD_33
                {
                mKEYWORD_33(); 

                }
                break;
            case 11 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:120: KEYWORD_34
                {
                mKEYWORD_34(); 

                }
                break;
            case 12 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:131: KEYWORD_35
                {
                mKEYWORD_35(); 

                }
                break;
            case 13 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:142: KEYWORD_36
                {
                mKEYWORD_36(); 

                }
                break;
            case 14 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:153: KEYWORD_25
                {
                mKEYWORD_25(); 

                }
                break;
            case 15 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:164: KEYWORD_26
                {
                mKEYWORD_26(); 

                }
                break;
            case 16 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:175: KEYWORD_27
                {
                mKEYWORD_27(); 

                }
                break;
            case 17 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:186: KEYWORD_28
                {
                mKEYWORD_28(); 

                }
                break;
            case 18 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:197: KEYWORD_29
                {
                mKEYWORD_29(); 

                }
                break;
            case 19 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:208: KEYWORD_19
                {
                mKEYWORD_19(); 

                }
                break;
            case 20 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:219: KEYWORD_20
                {
                mKEYWORD_20(); 

                }
                break;
            case 21 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:230: KEYWORD_21
                {
                mKEYWORD_21(); 

                }
                break;
            case 22 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:241: KEYWORD_22
                {
                mKEYWORD_22(); 

                }
                break;
            case 23 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:252: KEYWORD_23
                {
                mKEYWORD_23(); 

                }
                break;
            case 24 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:263: KEYWORD_24
                {
                mKEYWORD_24(); 

                }
                break;
            case 25 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:274: KEYWORD_17
                {
                mKEYWORD_17(); 

                }
                break;
            case 26 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:285: KEYWORD_18
                {
                mKEYWORD_18(); 

                }
                break;
            case 27 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:296: KEYWORD_16
                {
                mKEYWORD_16(); 

                }
                break;
            case 28 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:307: KEYWORD_1
                {
                mKEYWORD_1(); 

                }
                break;
            case 29 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:317: KEYWORD_2
                {
                mKEYWORD_2(); 

                }
                break;
            case 30 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:327: KEYWORD_3
                {
                mKEYWORD_3(); 

                }
                break;
            case 31 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:337: KEYWORD_4
                {
                mKEYWORD_4(); 

                }
                break;
            case 32 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:347: KEYWORD_5
                {
                mKEYWORD_5(); 

                }
                break;
            case 33 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:357: KEYWORD_6
                {
                mKEYWORD_6(); 

                }
                break;
            case 34 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:367: KEYWORD_7
                {
                mKEYWORD_7(); 

                }
                break;
            case 35 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:377: KEYWORD_8
                {
                mKEYWORD_8(); 

                }
                break;
            case 36 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:387: KEYWORD_9
                {
                mKEYWORD_9(); 

                }
                break;
            case 37 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:397: KEYWORD_10
                {
                mKEYWORD_10(); 

                }
                break;
            case 38 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:408: KEYWORD_11
                {
                mKEYWORD_11(); 

                }
                break;
            case 39 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:419: KEYWORD_12
                {
                mKEYWORD_12(); 

                }
                break;
            case 40 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:430: KEYWORD_13
                {
                mKEYWORD_13(); 

                }
                break;
            case 41 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:441: KEYWORD_14
                {
                mKEYWORD_14(); 

                }
                break;
            case 42 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:452: KEYWORD_15
                {
                mKEYWORD_15(); 

                }
                break;
            case 43 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:463: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 44 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:471: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 45 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:480: RULE_PINNUM
                {
                mRULE_PINNUM(); 

                }
                break;
            case 46 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:492: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 47 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:504: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 48 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:520: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 49 :
                // ../edu.byu.ee.phdl.xtext.ui/src-gen/edu/byu/ee/phdl/ui/contentassist/antlr/lexer/InternalPhdlLexer.g:1:536: RULE_WS
                {
                mRULE_WS(); 

                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\1\uffff\11\31\20\uffff\1\31\2\66\1\37\3\uffff\21\31\1\120\3\31"+
        "\1\uffff\1\66\1\uffff\1\37\4\31\1\133\5\31\1\141\13\31\1\uffff\3"+
        "\31\1\37\1\uffff\5\31\1\uffff\4\31\1\171\1\uffff\4\31\1\176\1\177"+
        "\4\31\1\u0084\1\31\1\u0086\1\u0087\5\31\1\u008d\3\31\1\uffff\3\31"+
        "\1\u0094\2\uffff\1\u0095\1\31\1\u0097\1\u0098\1\uffff\1\31\2\uffff"+
        "\2\31\1\u009c\2\31\1\uffff\2\31\1\u00a1\1\u00a2\1\u00a3\1\u00a4"+
        "\2\uffff\1\u00a5\2\uffff\1\u00a6\1\31\1\u00a8\1\uffff\1\u00a9\1"+
        "\u00aa\1\u00ab\1\u00ac\6\uffff\1\31\5\uffff\1\u00ae\1\uffff";
    static final String DFA14_eofS =
        "\u00af\uffff";
    static final String DFA14_minS =
        "\1\11\11\44\20\uffff\3\44\1\52\3\uffff\25\44\1\uffff\1\44\1\uffff"+
        "\1\0\26\44\1\uffff\3\44\1\0\1\uffff\5\44\1\uffff\5\44\1\uffff\27"+
        "\44\1\uffff\4\44\2\uffff\4\44\1\uffff\1\44\2\uffff\5\44\1\uffff"+
        "\6\44\2\uffff\1\44\2\uffff\3\44\1\uffff\4\44\6\uffff\1\44\5\uffff"+
        "\1\44\1\uffff";
    static final String DFA14_maxS =
        "\1\175\11\172\20\uffff\3\172\1\57\3\uffff\25\172\1\uffff\1\172"+
        "\1\uffff\1\uffff\26\172\1\uffff\3\172\1\uffff\1\uffff\5\172\1\uffff"+
        "\5\172\1\uffff\27\172\1\uffff\4\172\2\uffff\4\172\1\uffff\1\172"+
        "\2\uffff\5\172\1\uffff\6\172\2\uffff\1\172\2\uffff\3\172\1\uffff"+
        "\4\172\6\uffff\1\172\5\uffff\1\172\1\uffff";
    static final String DFA14_acceptS =
        "\12\uffff\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46"+
        "\1\47\1\50\1\51\1\52\1\53\4\uffff\1\56\1\55\1\61\25\uffff\1\54\1"+
        "\uffff\1\57\27\uffff\1\33\4\uffff\1\60\5\uffff\1\31\5\uffff\1\32"+
        "\27\uffff\1\27\4\uffff\1\24\1\25\4\uffff\1\26\1\uffff\1\30\1\23"+
        "\5\uffff\1\20\6\uffff\1\16\1\17\1\uffff\1\21\1\22\3\uffff\1\14\4"+
        "\uffff\1\13\1\7\1\10\1\11\1\12\1\15\1\uffff\1\6\1\2\1\3\1\4\1\5"+
        "\1\uffff\1\1";
    static final String DFA14_specialS =
        "\71\uffff\1\1\32\uffff\1\0\132\uffff}>";
    static final String[] DFA14_transitionS = {
            "\2\40\2\uffff\1\40\22\uffff\1\40\1\uffff\1\36\1\uffff\1\37"+
            "\1\uffff\1\12\1\36\1\13\1\14\1\15\1\37\1\16\1\37\1\17\1\35\1"+
            "\34\11\33\1\20\1\21\1\22\1\23\1\24\1\uffff\1\37\32\32\1\25\1"+
            "\uffff\1\26\1\31\1\32\1\uffff\1\11\1\32\1\2\1\5\4\32\1\6\4\32"+
            "\1\3\1\7\1\4\2\32\1\1\1\10\6\32\1\27\1\uffff\1\30",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\24\42\1\41\5\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\16\42\1\43\13\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\2\42\1\45\1\42\1\44\25\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\1\46\7\42\1\51\5\42\1\50\7"+
            "\42\1\47\3\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\4\42\1\52\25\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\14\42\1\53\1\54\1\55\13\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\2\42\1\57\1\42\1\60\1\62\11"+
            "\42\1\61\4\42\1\56\5\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\7\42\1\64\11\42\1\63\10\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\23\42\1\65\6\42",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\67\6\uffff"+
            "\33\37\4\uffff\1\37\1\uffff\32\37",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\13\37\6\uffff\33\37"+
            "\4\uffff\1\37\1\uffff\32\37",
            "\1\70\4\uffff\1\71",
            "",
            "",
            "",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\1\42\1\72\15\42\1\73\12\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\14\42\1\74\15\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\23\42\1\76\2\42\1\75\3\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\17\42\1\77\12\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\2\42\1\100\17\42\1\101\7\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\21\42\1\102\10\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\21\42\1\103\10\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\15\42\1\104\14\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\22\42\1\105\2\42\1\106\4\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\17\42\1\107\12\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\5\42\1\111\11\42\1\110\2\42"+
            "\1\112\7\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\17\42\1\113\12\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\23\42\1\114\6\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\17\42\1\115\12\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\17\42\1\116\12\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\4\42\1\117\25\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\10\42\1\121\21\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\10\42\1\122\21\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\23\42\1\123\6\42",
            "",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\67\6\uffff"+
            "\33\37\4\uffff\1\37\1\uffff\32\37",
            "",
            "\44\125\1\124\6\125\1\124\1\125\1\124\1\125\13\124\6\125\33"+
            "\124\4\125\1\124\1\125\32\124\uff85\125",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\3\42\1\126\4\42\1\127\21\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\17\42\1\130\12\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\1\42\1\131\30\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\1\132\31\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\10\42\1\134\21\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\12\42\1\135\17\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\22\42\1\136\7\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\17\42\1\137\12\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\23\42\1\140\6\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\10\42\1\142\21\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\10\42\1\143\21\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\16\42\1\144\13\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\10\42\1\145\21\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\16\42\1\146\13\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\23\42\1\147\6\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\10\42\1\150\21\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\17\42\1\151\12\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\10\42\1\152\21\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\10\42\1\153\21\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\15\42\1\154\14\42",
            "",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\17\42\1\155\12\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\22\42\1\156\7\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\21\42\1\157\10\42",
            "\44\125\1\124\6\125\1\124\1\125\1\124\1\125\13\124\6\125\33"+
            "\124\4\125\1\124\1\125\32\124\uff85\125",
            "",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\4\42\1\160\25\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\15\42\1\161\14\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\10\42\1\162\21\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\10\42\1\163\21\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\23\42\1\164\6\42",
            "",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\15\42\1\165\14\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\1\166\31\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\17\42\1\167\12\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\10\42\1\170\21\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\6\42\1\172\23\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\2\42\1\173\27\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\21\42\1\174\10\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\15\42\1\175\14\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\15\42\1\u0080\14\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\10\42\1\u0081\21\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\15\42\1\u0082\14\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\15\42\1\u0083\14\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\10\42\1\u0085\21\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\22\42\1\u0088\7\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\22\42\1\u0089\7\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\15\42\1\u008a\14\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\15\42\1\u008b\14\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\23\42\1\u008c\6\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\6\42\1\u008e\23\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\10\42\1\u008f\21\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\15\42\1\u0090\14\42",
            "",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\15\42\1\u0091\14\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\4\42\1\u0092\25\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\23\42\1\u0093\6\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\15\42\1\u0096\14\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\15\42\1\u0099\14\42",
            "",
            "",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\10\42\1\u009a\21\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\23\42\1\u009b\6\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\4\42\1\u009d\25\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\21\42\1\u009e\10\42",
            "",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\4\42\1\u009f\25\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\15\42\1\u00a0\14\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\6\42\1\u00a7\23\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\15\42\1\u00ad\14\42",
            "",
            "",
            "",
            "",
            "",
            "\1\37\6\uffff\1\37\1\uffff\1\37\1\uffff\1\37\12\42\6\uffff"+
            "\1\37\32\42\4\uffff\1\42\1\uffff\32\42",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( KEYWORD_42 | KEYWORD_37 | KEYWORD_38 | KEYWORD_39 | KEYWORD_40 | KEYWORD_41 | KEYWORD_30 | KEYWORD_31 | KEYWORD_32 | KEYWORD_33 | KEYWORD_34 | KEYWORD_35 | KEYWORD_36 | KEYWORD_25 | KEYWORD_26 | KEYWORD_27 | KEYWORD_28 | KEYWORD_29 | KEYWORD_19 | KEYWORD_20 | KEYWORD_21 | KEYWORD_22 | KEYWORD_23 | KEYWORD_24 | KEYWORD_17 | KEYWORD_18 | KEYWORD_16 | KEYWORD_1 | KEYWORD_2 | KEYWORD_3 | KEYWORD_4 | KEYWORD_5 | KEYWORD_6 | KEYWORD_7 | KEYWORD_8 | KEYWORD_9 | KEYWORD_10 | KEYWORD_11 | KEYWORD_12 | KEYWORD_13 | KEYWORD_14 | KEYWORD_15 | RULE_ID | RULE_INT | RULE_PINNUM | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_84 = input.LA(1);

                        s = -1;
                        if ( ((LA14_84>='\u0000' && LA14_84<='#')||(LA14_84>='%' && LA14_84<='*')||LA14_84==','||LA14_84=='.'||(LA14_84>=':' && LA14_84<='?')||(LA14_84>='[' && LA14_84<='^')||LA14_84=='`'||(LA14_84>='{' && LA14_84<='\uFFFF')) ) {s = 85;}

                        else if ( (LA14_84=='$'||LA14_84=='+'||LA14_84=='-'||(LA14_84>='/' && LA14_84<='9')||(LA14_84>='@' && LA14_84<='Z')||LA14_84=='_'||(LA14_84>='a' && LA14_84<='z')) ) {s = 84;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_57 = input.LA(1);

                        s = -1;
                        if ( (LA14_57=='$'||LA14_57=='+'||LA14_57=='-'||(LA14_57>='/' && LA14_57<='9')||(LA14_57>='@' && LA14_57<='Z')||LA14_57=='_'||(LA14_57>='a' && LA14_57<='z')) ) {s = 84;}

                        else if ( ((LA14_57>='\u0000' && LA14_57<='#')||(LA14_57>='%' && LA14_57<='*')||LA14_57==','||LA14_57=='.'||(LA14_57>=':' && LA14_57<='?')||(LA14_57>='[' && LA14_57<='^')||LA14_57=='`'||(LA14_57>='{' && LA14_57<='\uFFFF')) ) {s = 85;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}