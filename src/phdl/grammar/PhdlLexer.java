// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g 2011-07-11 09:40:18

	package phdl.grammar;
	import phdl.exception.PhdlRuntimeException;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class PhdlLexer extends Lexer {
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
    public static final int IDENT=4;
    public static final int SEMICOLON=5;
    public static final int EQUALS=6;
    public static final int STRING=7;
    public static final int PERIOD=8;
    public static final int AMPERSAND=9;
    public static final int LEFTANGLE=10;
    public static final int RIGHTANGLE=11;
    public static final int LEFTBRACE=12;
    public static final int PIN=13;
    public static final int INTEGER=14;
    public static final int COMMA=15;
    public static final int RIGHTBRACE=16;
    public static final int LEFTBRACKET=17;
    public static final int COLON=18;
    public static final int RIGHTBRACKET=19;
    public static final int LEFTPAREN=20;
    public static final int RIGHTPAREN=21;
    public static final int CHAR=22;
    public static final int DIGIT=23;
    public static final int WHITESPACE=24;
    public static final int LINE_COMMENT=25;
    public static final int MULTILINE_COMMENT=26;

    // delegates
    // delegators

    public PhdlLexer() {;} 
    public PhdlLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public PhdlLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g"; }

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:12:7: ( 'design' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:12:9: 'design'
            {
            match("design"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:13:7: ( 'is' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:13:9: 'is'
            {
            match("is"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:14:7: ( 'begin' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:14:9: 'begin'
            {
            match("begin"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:15:7: ( 'end' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:15:9: 'end'
            {
            match("end"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:16:7: ( 'device' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:16:9: 'device'
            {
            match("device"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:17:7: ( 'attr' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:17:9: 'attr'
            {
            match("attr"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:18:7: ( 'pin' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:18:9: 'pin'
            {
            match("pin"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:19:7: ( 'net' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:19:9: 'net'
            {
            match("net"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:20:7: ( 'inst' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:20:9: 'inst'
            {
            match("inst"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:21:7: ( 'of' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:21:9: 'of'
            {
            match("of"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:22:7: ( 'newattr' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:22:9: 'newattr'
            {
            match("newattr"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:23:7: ( 'open' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:23:9: 'open'
            {
            match("open"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:246:10: ( ';' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:246:12: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMICOLON"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:247:6: ( ':' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:247:8: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:248:6: ( ',' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:248:8: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "PERIOD"
    public final void mPERIOD() throws RecognitionException {
        try {
            int _type = PERIOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:249:7: ( '.' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:249:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PERIOD"

    // $ANTLR start "EQUALS"
    public final void mEQUALS() throws RecognitionException {
        try {
            int _type = EQUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:250:7: ( '=' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:250:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUALS"

    // $ANTLR start "LEFTPAREN"
    public final void mLEFTPAREN() throws RecognitionException {
        try {
            int _type = LEFTPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:251:10: ( '(' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:251:12: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LEFTPAREN"

    // $ANTLR start "RIGHTPAREN"
    public final void mRIGHTPAREN() throws RecognitionException {
        try {
            int _type = RIGHTPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:252:11: ( ')' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:252:13: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RIGHTPAREN"

    // $ANTLR start "LEFTBRACKET"
    public final void mLEFTBRACKET() throws RecognitionException {
        try {
            int _type = LEFTBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:253:12: ( '[' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:253:14: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LEFTBRACKET"

    // $ANTLR start "RIGHTBRACKET"
    public final void mRIGHTBRACKET() throws RecognitionException {
        try {
            int _type = RIGHTBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:254:13: ( ']' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:254:15: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RIGHTBRACKET"

    // $ANTLR start "LEFTBRACE"
    public final void mLEFTBRACE() throws RecognitionException {
        try {
            int _type = LEFTBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:255:10: ( '{' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:255:12: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LEFTBRACE"

    // $ANTLR start "RIGHTBRACE"
    public final void mRIGHTBRACE() throws RecognitionException {
        try {
            int _type = RIGHTBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:256:11: ( '}' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:256:13: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RIGHTBRACE"

    // $ANTLR start "LEFTANGLE"
    public final void mLEFTANGLE() throws RecognitionException {
        try {
            int _type = LEFTANGLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:257:10: ( '<' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:257:12: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LEFTANGLE"

    // $ANTLR start "RIGHTANGLE"
    public final void mRIGHTANGLE() throws RecognitionException {
        try {
            int _type = RIGHTANGLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:258:11: ( '>' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:258:13: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RIGHTANGLE"

    // $ANTLR start "AMPERSAND"
    public final void mAMPERSAND() throws RecognitionException {
        try {
            int _type = AMPERSAND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:259:10: ( '&' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:259:12: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AMPERSAND"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:265:15: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' | '+' | '-' | '$' )
            int alt1=6;
            switch ( input.LA(1) ) {
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                alt1=1;
                }
                break;
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
                {
                alt1=2;
                }
                break;
            case '_':
                {
                alt1=3;
                }
                break;
            case '+':
                {
                alt1=4;
                }
                break;
            case '-':
                {
                alt1=5;
                }
                break;
            case '$':
                {
                alt1=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:265:17: ( 'a' .. 'z' )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:265:17: ( 'a' .. 'z' )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:265:18: 'a' .. 'z'
                    {
                    matchRange('a','z'); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:265:30: ( 'A' .. 'Z' )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:265:30: ( 'A' .. 'Z' )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:265:31: 'A' .. 'Z'
                    {
                    matchRange('A','Z'); 

                    }


                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:265:43: '_'
                    {
                    match('_'); 

                    }
                    break;
                case 4 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:265:49: '+'
                    {
                    match('+'); 

                    }
                    break;
                case 5 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:265:55: '-'
                    {
                    match('-'); 

                    }
                    break;
                case 6 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:265:61: '$'
                    {
                    match('$'); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "CHAR"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:270:16: ( ( '0' .. '9' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:270:18: ( '0' .. '9' )
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:270:18: ( '0' .. '9' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:270:19: '0' .. '9'
            {
            matchRange('0','9'); 

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:275:9: ( ( DIGIT )+ )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:275:11: ( DIGIT )+
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:275:11: ( DIGIT )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:275:11: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            int c;

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:281:2: ( '\"' (c=~ ( '\"' | '\\n' | '\\r' ) )* '\"' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:281:5: '\"' (c=~ ( '\"' | '\\n' | '\\r' ) )* '\"'
            {
            match('\"'); 
            StringBuilder sb = new StringBuilder();
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:282:3: (c=~ ( '\"' | '\\n' | '\\r' ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='\f')||(LA3_0>='\u000E' && LA3_0<='!')||(LA3_0>='#' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:282:5: c=~ ( '\"' | '\\n' | '\\r' )
            	    {
            	    c= input.LA(1);
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}

            	    sb.appendCodePoint(c);

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match('\"'); 
            setText(sb.toString());

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:291:2: ( CHAR ( CHAR | DIGIT )* )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:291:5: CHAR ( CHAR | DIGIT )*
            {
            mCHAR(); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:291:10: ( CHAR | DIGIT )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='$'||LA4_0=='+'||LA4_0=='-'||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }
                else if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:291:11: CHAR
            	    {
            	    mCHAR(); 

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:291:18: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "PIN"
    public final void mPIN() throws RecognitionException {
        try {
            int _type = PIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:298:2: ( ( CHAR | DIGIT )+ )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:298:4: ( CHAR | DIGIT )+
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:298:4: ( CHAR | DIGIT )+
            int cnt5=0;
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='$'||LA5_0=='+'||LA5_0=='-'||(LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')) ) {
                    alt5=1;
                }
                else if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:298:5: CHAR
            	    {
            	    mCHAR(); 

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:298:12: DIGIT
            	    {
            	    mDIGIT(); 

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
    // $ANTLR end "PIN"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:305:2: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' | '\\u001D' )+ )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:305:4: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' | '\\u001D' )+
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:305:4: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' | '\\u001D' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\t' && LA6_0<='\n')||(LA6_0>='\f' && LA6_0<='\r')||LA6_0=='\u001D'||LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)=='\u001D'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "LINE_COMMENT"
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:312:2: ( '//' ( . )* ( '\\n' | '\\r' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:312:4: '//' ( . )* ( '\\n' | '\\r' )
            {
            match("//"); 

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:312:9: ( . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\n'||LA7_0=='\r') ) {
                    alt7=2;
                }
                else if ( ((LA7_0>='\u0000' && LA7_0<='\t')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:312:9: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LINE_COMMENT"

    // $ANTLR start "MULTILINE_COMMENT"
    public final void mMULTILINE_COMMENT() throws RecognitionException {
        try {
            int _type = MULTILINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:319:2: ( '/*' ( . )* '*/' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:319:4: '/*' ( . )* '*/'
            {
            match("/*"); 

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:319:9: ( . )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='*') ) {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1=='/') ) {
                        alt8=2;
                    }
                    else if ( ((LA8_1>='\u0000' && LA8_1<='.')||(LA8_1>='0' && LA8_1<='\uFFFF')) ) {
                        alt8=1;
                    }


                }
                else if ( ((LA8_0>='\u0000' && LA8_0<=')')||(LA8_0>='+' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:319:9: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match("*/"); 

            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MULTILINE_COMMENT"

    public void mTokens() throws RecognitionException {
        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:8: ( T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | SEMICOLON | COLON | COMMA | PERIOD | EQUALS | LEFTPAREN | RIGHTPAREN | LEFTBRACKET | RIGHTBRACKET | LEFTBRACE | RIGHTBRACE | LEFTANGLE | RIGHTANGLE | AMPERSAND | INTEGER | STRING | IDENT | PIN | WHITESPACE | LINE_COMMENT | MULTILINE_COMMENT )
        int alt9=33;
        alt9 = dfa9.predict(input);
        switch (alt9) {
            case 1 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:10: T__27
                {
                mT__27(); 

                }
                break;
            case 2 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:16: T__28
                {
                mT__28(); 

                }
                break;
            case 3 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:22: T__29
                {
                mT__29(); 

                }
                break;
            case 4 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:28: T__30
                {
                mT__30(); 

                }
                break;
            case 5 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:34: T__31
                {
                mT__31(); 

                }
                break;
            case 6 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:40: T__32
                {
                mT__32(); 

                }
                break;
            case 7 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:46: T__33
                {
                mT__33(); 

                }
                break;
            case 8 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:52: T__34
                {
                mT__34(); 

                }
                break;
            case 9 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:58: T__35
                {
                mT__35(); 

                }
                break;
            case 10 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:64: T__36
                {
                mT__36(); 

                }
                break;
            case 11 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:70: T__37
                {
                mT__37(); 

                }
                break;
            case 12 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:76: T__38
                {
                mT__38(); 

                }
                break;
            case 13 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:82: SEMICOLON
                {
                mSEMICOLON(); 

                }
                break;
            case 14 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:92: COLON
                {
                mCOLON(); 

                }
                break;
            case 15 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:98: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 16 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:104: PERIOD
                {
                mPERIOD(); 

                }
                break;
            case 17 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:111: EQUALS
                {
                mEQUALS(); 

                }
                break;
            case 18 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:118: LEFTPAREN
                {
                mLEFTPAREN(); 

                }
                break;
            case 19 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:128: RIGHTPAREN
                {
                mRIGHTPAREN(); 

                }
                break;
            case 20 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:139: LEFTBRACKET
                {
                mLEFTBRACKET(); 

                }
                break;
            case 21 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:151: RIGHTBRACKET
                {
                mRIGHTBRACKET(); 

                }
                break;
            case 22 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:164: LEFTBRACE
                {
                mLEFTBRACE(); 

                }
                break;
            case 23 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:174: RIGHTBRACE
                {
                mRIGHTBRACE(); 

                }
                break;
            case 24 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:185: LEFTANGLE
                {
                mLEFTANGLE(); 

                }
                break;
            case 25 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:195: RIGHTANGLE
                {
                mRIGHTANGLE(); 

                }
                break;
            case 26 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:206: AMPERSAND
                {
                mAMPERSAND(); 

                }
                break;
            case 27 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:216: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 28 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:224: STRING
                {
                mSTRING(); 

                }
                break;
            case 29 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:231: IDENT
                {
                mIDENT(); 

                }
                break;
            case 30 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:237: PIN
                {
                mPIN(); 

                }
                break;
            case 31 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:241: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 32 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:252: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;
            case 33 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:265: MULTILINE_COMMENT
                {
                mMULTILINE_COMMENT(); 

                }
                break;

        }

    }


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\1\uffff\10\42\16\uffff\1\63\1\uffff\6\42\2\uffff\1\42\1\uffff"+
        "\7\42\1\71\6\42\1\101\1\42\4\uffff\2\42\1\uffff\2\42\1\107\1\42"+
        "\1\111\1\112\1\42\1\uffff\3\42\1\117\1\42\1\uffff\1\121\2\uffff"+
        "\1\42\1\123\2\42\1\uffff\1\126\1\uffff\1\42\1\uffff\1\130\1\131"+
        "\1\uffff\1\42\2\uffff\1\133\1\uffff";
    static final String DFA9_eofS =
        "\134\uffff";
    static final String DFA9_minS =
        "\1\11\10\44\16\uffff\1\44\1\uffff\6\44\1\uffff\1\52\1\44\1\uffff"+
        "\20\44\4\uffff\2\44\1\uffff\7\44\1\uffff\5\44\1\uffff\1\44\2\uffff"+
        "\4\44\1\uffff\1\44\1\uffff\1\44\1\uffff\2\44\1\uffff\1\44\2\uffff"+
        "\1\44\1\uffff";
    static final String DFA9_maxS =
        "\1\175\10\172\16\uffff\1\172\1\uffff\6\172\1\uffff\1\57\1\172\1"+
        "\uffff\20\172\4\uffff\2\172\1\uffff\7\172\1\uffff\5\172\1\uffff"+
        "\1\172\2\uffff\4\172\1\uffff\1\172\1\uffff\1\172\1\uffff\2\172\1"+
        "\uffff\1\172\2\uffff\1\172\1\uffff";
    static final String DFA9_acceptS =
        "\11\uffff\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27"+
        "\1\30\1\31\1\32\1\uffff\1\34\6\uffff\1\37\2\uffff\1\35\20\uffff"+
        "\1\33\1\36\1\40\1\41\2\uffff\1\2\7\uffff\1\12\5\uffff\1\4\1\uffff"+
        "\1\7\1\10\4\uffff\1\11\1\uffff\1\6\1\uffff\1\14\2\uffff\1\3\1\uffff"+
        "\1\1\1\5\1\uffff\1\13";
    static final String DFA9_specialS =
        "\134\uffff}>";
    static final String[] DFA9_transitionS = {
            "\2\37\1\uffff\2\37\17\uffff\1\37\2\uffff\1\37\1\uffff\1\30"+
            "\1\uffff\1\36\1\uffff\1\26\1\uffff\1\16\1\17\1\uffff\1\34\1"+
            "\13\1\35\1\14\1\40\12\27\1\12\1\11\1\24\1\15\1\25\2\uffff\32"+
            "\32\1\20\1\uffff\1\21\1\uffff\1\33\1\uffff\1\5\1\3\1\31\1\1"+
            "\1\4\3\31\1\2\4\31\1\7\1\10\1\6\12\31\1\22\1\uffff\1\23",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\4\43\1\41\25\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\15\43\1\53\4\43\1\52\7\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\4\43\1\54\25\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\15\43\1\55\14\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\23\43\1\56\6\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\10\43\1\57\21\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\4\43\1\60\25\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\5\43\1\61\11\43\1\62\12\43",
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
            "\1\64\6\uffff\1\64\1\uffff\1\64\2\uffff\12\27\7\uffff\32\64"+
            "\4\uffff\1\64\1\uffff\32\64",
            "",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\32\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\32\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\32\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\32\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\32\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\32\43",
            "",
            "\1\66\4\uffff\1\65",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\22\43\1\67\2\43\1\70\4\43",
            "",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\32\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\32\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\32\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\32\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\32\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\32\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\32\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\32\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\22\43\1\72\7\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\6\43\1\73\23\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\3\43\1\74\26\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\23\43\1\75\6\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\15\43\1\76\14\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\23\43\1\77\2\43\1\100\3\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\32\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\4\43\1\102\25\43",
            "",
            "",
            "",
            "",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\10\43\1\103\21\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\10\43\1\104\21\43",
            "",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\23\43\1\105\6\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\10\43\1\106\21\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\32\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\21\43\1\110\10\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\32\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\32\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\1\113\31\43",
            "",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\15\43\1\114\14\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\6\43\1\115\23\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\2\43\1\116\27\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\32\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\15\43\1\120\14\43",
            "",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\32\43",
            "",
            "",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\23\43\1\122\6\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\32\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\15\43\1\124\14\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\4\43\1\125\25\43",
            "",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\32\43",
            "",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\23\43\1\127\6\43",
            "",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\32\43",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\32\43",
            "",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\21\43\1\132\10\43",
            "",
            "",
            "\1\50\6\uffff\1\46\1\uffff\1\47\2\uffff\12\51\7\uffff\32\44"+
            "\4\uffff\1\45\1\uffff\32\43",
            ""
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
            return "1:1: Tokens : ( T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | SEMICOLON | COLON | COMMA | PERIOD | EQUALS | LEFTPAREN | RIGHTPAREN | LEFTBRACKET | RIGHTBRACKET | LEFTBRACE | RIGHTBRACE | LEFTANGLE | RIGHTANGLE | AMPERSAND | INTEGER | STRING | IDENT | PIN | WHITESPACE | LINE_COMMENT | MULTILINE_COMMENT );";
        }
    }
 

}