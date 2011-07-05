// $ANTLR 3.3 Nov 30, 2010 12:50:56 /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g 2011-07-05 11:45:41

	package phdl.parser;
	import phdl.exception.PhdlRuntimeException;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class PhdlLexer extends Lexer {
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

    public PhdlLexer() {;} 
    public PhdlLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public PhdlLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g"; }

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:12:7: ( 'design' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:12:9: 'design'
            {
            match("design"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:13:7: ( 'is' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:13:9: 'is'
            {
            match("is"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:14:7: ( 'begin' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:14:9: 'begin'
            {
            match("begin"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:15:7: ( 'end' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:15:9: 'end'
            {
            match("end"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:16:7: ( 'device' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:16:9: 'device'
            {
            match("device"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:17:7: ( 'attr' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:17:9: 'attr'
            {
            match("attr"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:18:7: ( 'pin' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:18:9: 'pin'
            {
            match("pin"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:19:7: ( 'net' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:19:9: 'net'
            {
            match("net"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:20:7: ( 'inst' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:20:9: 'inst'
            {
            match("inst"); 


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
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:21:7: ( 'new' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:21:9: 'new'
            {
            match("new"); 


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
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:22:7: ( '&' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:22:9: '&'
            {
            match('&'); 

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
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:23:7: ( '<' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:23:9: '<'
            {
            match('<'); 

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
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:24:7: ( '>' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:24:9: '>'
            {
            match('>'); 

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
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:25:7: ( 'open' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:25:9: 'open'
            {
            match("open"); 


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
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:26:7: ( '{' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:26:9: '{'
            {
            match('{'); 

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
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:27:7: ( '}' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:27:9: '}'
            {
            match('}'); 

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
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:28:7: ( '(' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:28:9: '('
            {
            match('('); 

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
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:29:7: ( ')' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:29:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:223:15: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' | '+' | '-' | '$' )
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
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:223:17: ( 'a' .. 'z' )
                    {
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:223:17: ( 'a' .. 'z' )
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:223:18: 'a' .. 'z'
                    {
                    matchRange('a','z'); 

                    }


                    }
                    break;
                case 2 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:223:30: ( 'A' .. 'Z' )
                    {
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:223:30: ( 'A' .. 'Z' )
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:223:31: 'A' .. 'Z'
                    {
                    matchRange('A','Z'); 

                    }


                    }
                    break;
                case 3 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:223:43: '_'
                    {
                    match('_'); 

                    }
                    break;
                case 4 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:223:49: '+'
                    {
                    match('+'); 

                    }
                    break;
                case 5 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:223:55: '-'
                    {
                    match('-'); 

                    }
                    break;
                case 6 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:223:61: '$'
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
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:224:16: ( '0' .. '9' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:224:18: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:225:10: ( ';' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:225:12: ';'
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
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:226:6: ( ':' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:226:8: ':'
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
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:227:6: ( ',' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:227:8: ','
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
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:228:7: ( '.' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:228:9: '.'
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
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:229:7: ( '=' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:229:9: '='
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

    // $ANTLR start "LBRACKET"
    public final void mLBRACKET() throws RecognitionException {
        try {
            int _type = LBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:230:9: ( '[' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:230:11: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LBRACKET"

    // $ANTLR start "RBRACKET"
    public final void mRBRACKET() throws RecognitionException {
        try {
            int _type = RBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:231:9: ( ']' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:231:11: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RBRACKET"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:234:5: ( ( DIGIT )+ )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:234:7: ( DIGIT )+
            {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:234:7: ( DIGIT )+
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
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:234:7: DIGIT
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
    // $ANTLR end "INT"

    // $ANTLR start "STRING_LITERAL"
    public final void mSTRING_LITERAL() throws RecognitionException {
        try {
            int _type = STRING_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            int c;

            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:238:2: ( '\"' ( '/' '\"' | c=~ ( '\"' ) )* '\"' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:238:5: '\"' ( '/' '\"' | c=~ ( '\"' ) )* '\"'
            {
            match('\"'); 
            StringBuilder sb = new StringBuilder();
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:240:3: ( '/' '\"' | c=~ ( '\"' ) )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='/') ) {
                    int LA3_2 = input.LA(2);

                    if ( (LA3_2=='\"') ) {
                        int LA3_4 = input.LA(3);

                        if ( ((LA3_4>='\u0000' && LA3_4<='\uFFFF')) ) {
                            alt3=1;
                        }

                        else {
                            alt3=2;
                        }

                    }
                    else if ( ((LA3_2>='\u0000' && LA3_2<='!')||(LA3_2>='#' && LA3_2<='\uFFFF')) ) {
                        alt3=2;
                    }


                }
                else if ( ((LA3_0>='\u0000' && LA3_0<='!')||(LA3_0>='#' && LA3_0<='.')||(LA3_0>='0' && LA3_0<='\uFFFF')) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:240:5: '/' '\"'
            	    {
            	    match('/'); 
            	    match('\"'); 
            	    sb.appendCodePoint('"');

            	    }
            	    break;
            	case 2 :
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:241:5: c=~ ( '\"' )
            	    {
            	    c= input.LA(1);
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}

            	    	if (c!=' ' && c!='\t' && c!='\n' && c!='\r' && c!='\f' && c!='\u001D')
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
    // $ANTLR end "STRING_LITERAL"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:252:2: ( CHAR ( CHAR | DIGIT )* )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:252:4: CHAR ( CHAR | DIGIT )*
            {
            mCHAR(); 
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:252:9: ( CHAR | DIGIT )*
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
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:252:11: CHAR
            	    {
            	    mCHAR(); 

            	    }
            	    break;
            	case 2 :
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:252:18: DIGIT
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

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:257:2: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' | '\\u001D' )+ )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:257:4: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' | '\\u001D' )+
            {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:257:4: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' | '\\u001D' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='\t' && LA5_0<='\n')||(LA5_0>='\f' && LA5_0<='\r')||LA5_0=='\u001D'||LA5_0==' ') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:
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
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
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
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:262:2: ( '//' ( . )* ( '\\n' | '\\r' ) )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:262:4: '//' ( . )* ( '\\n' | '\\r' )
            {
            match("//"); 

            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:262:9: ( . )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\n'||LA6_0=='\r') ) {
                    alt6=2;
                }
                else if ( ((LA6_0>='\u0000' && LA6_0<='\t')||(LA6_0>='\u000B' && LA6_0<='\f')||(LA6_0>='\u000E' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:262:9: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop6;
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
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:267:2: ( '/*' ( . )* '*/' )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:267:4: '/*' ( . )* '*/'
            {
            match("/*"); 

            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:267:9: ( . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='*') ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1=='/') ) {
                        alt7=2;
                    }
                    else if ( ((LA7_1>='\u0000' && LA7_1<='.')||(LA7_1>='0' && LA7_1<='\uFFFF')) ) {
                        alt7=1;
                    }


                }
                else if ( ((LA7_0>='\u0000' && LA7_0<=')')||(LA7_0>='+' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:267:9: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
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
        // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:8: ( T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | SEMICOLON | COLON | COMMA | PERIOD | EQUALS | LBRACKET | RBRACKET | INT | STRING_LITERAL | IDENT | WHITESPACE | LINE_COMMENT | MULTILINE_COMMENT )
        int alt8=31;
        alt8 = dfa8.predict(input);
        switch (alt8) {
            case 1 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:10: T__19
                {
                mT__19(); 

                }
                break;
            case 2 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:16: T__20
                {
                mT__20(); 

                }
                break;
            case 3 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:22: T__21
                {
                mT__21(); 

                }
                break;
            case 4 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:28: T__22
                {
                mT__22(); 

                }
                break;
            case 5 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:34: T__23
                {
                mT__23(); 

                }
                break;
            case 6 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:40: T__24
                {
                mT__24(); 

                }
                break;
            case 7 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:46: T__25
                {
                mT__25(); 

                }
                break;
            case 8 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:52: T__26
                {
                mT__26(); 

                }
                break;
            case 9 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:58: T__27
                {
                mT__27(); 

                }
                break;
            case 10 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:64: T__28
                {
                mT__28(); 

                }
                break;
            case 11 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:70: T__29
                {
                mT__29(); 

                }
                break;
            case 12 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:76: T__30
                {
                mT__30(); 

                }
                break;
            case 13 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:82: T__31
                {
                mT__31(); 

                }
                break;
            case 14 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:88: T__32
                {
                mT__32(); 

                }
                break;
            case 15 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:94: T__33
                {
                mT__33(); 

                }
                break;
            case 16 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:100: T__34
                {
                mT__34(); 

                }
                break;
            case 17 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:106: T__35
                {
                mT__35(); 

                }
                break;
            case 18 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:112: T__36
                {
                mT__36(); 

                }
                break;
            case 19 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:118: SEMICOLON
                {
                mSEMICOLON(); 

                }
                break;
            case 20 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:128: COLON
                {
                mCOLON(); 

                }
                break;
            case 21 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:134: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 22 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:140: PERIOD
                {
                mPERIOD(); 

                }
                break;
            case 23 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:147: EQUALS
                {
                mEQUALS(); 

                }
                break;
            case 24 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:154: LBRACKET
                {
                mLBRACKET(); 

                }
                break;
            case 25 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:163: RBRACKET
                {
                mRBRACKET(); 

                }
                break;
            case 26 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:172: INT
                {
                mINT(); 

                }
                break;
            case 27 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:176: STRING_LITERAL
                {
                mSTRING_LITERAL(); 

                }
                break;
            case 28 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:191: IDENT
                {
                mIDENT(); 

                }
                break;
            case 29 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:197: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 30 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:208: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;
            case 31 :
                // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/Phdl.g:1:221: MULTILINE_COMMENT
                {
                mMULTILINE_COMMENT(); 

                }
                break;

        }

    }


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\1\uffff\7\31\3\uffff\1\31\20\uffff\1\31\1\51\7\31\2\uffff\2\31"+
        "\1\uffff\2\31\1\66\1\31\1\70\1\71\1\72\3\31\1\76\1\31\1\uffff\1"+
        "\100\3\uffff\1\101\2\31\1\uffff\1\104\2\uffff\1\105\1\106\3\uffff";
    static final String DFA8_eofS =
        "\107\uffff";
    static final String DFA8_minS =
        "\1\11\1\145\1\156\1\145\1\156\1\164\1\151\1\145\3\uffff\1\160\17"+
        "\uffff\1\52\1\163\1\44\1\163\1\147\1\144\1\164\1\156\1\164\1\145"+
        "\2\uffff\2\151\1\uffff\1\164\1\151\1\44\1\162\3\44\1\156\1\147\1"+
        "\143\1\44\1\156\1\uffff\1\44\3\uffff\1\44\1\156\1\145\1\uffff\1"+
        "\44\2\uffff\2\44\3\uffff";
    static final String DFA8_maxS =
        "\1\175\1\145\1\163\1\145\1\156\1\164\1\151\1\145\3\uffff\1\160\17"+
        "\uffff\1\57\1\166\1\172\1\163\1\147\1\144\1\164\1\156\1\167\1\145"+
        "\2\uffff\2\151\1\uffff\1\164\1\151\1\172\1\162\3\172\1\156\1\147"+
        "\1\143\1\172\1\156\1\uffff\1\172\3\uffff\1\172\1\156\1\145\1\uffff"+
        "\1\172\2\uffff\2\172\3\uffff";
    static final String DFA8_acceptS =
        "\10\uffff\1\13\1\14\1\15\1\uffff\1\17\1\20\1\21\1\22\1\23\1\24\1"+
        "\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\12\uffff\1\36\1\37\2"+
        "\uffff\1\2\14\uffff\1\4\1\uffff\1\7\1\10\1\12\3\uffff\1\11\1\uffff"+
        "\1\6\1\16\2\uffff\1\3\1\1\1\5";
    static final String DFA8_specialS =
        "\107\uffff}>";
    static final String[] DFA8_transitionS = {
            "\2\32\1\uffff\2\32\17\uffff\1\32\2\uffff\1\32\1\uffff\1\30\1"+
            "\uffff\1\31\1\uffff\1\10\1\uffff\1\16\1\17\1\uffff\1\31\1\22"+
            "\1\31\1\23\1\33\12\27\1\21\1\20\1\11\1\24\1\12\2\uffff\32\31"+
            "\1\25\1\uffff\1\26\1\uffff\1\31\1\uffff\1\5\1\3\1\31\1\1\1\4"+
            "\3\31\1\2\4\31\1\7\1\13\1\6\12\31\1\14\1\uffff\1\15",
            "\1\34",
            "\1\36\4\uffff\1\35",
            "\1\37",
            "\1\40",
            "\1\41",
            "\1\42",
            "\1\43",
            "",
            "",
            "",
            "\1\44",
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
            "\1\46\4\uffff\1\45",
            "\1\47\2\uffff\1\50",
            "\1\31\6\uffff\1\31\1\uffff\1\31\2\uffff\12\31\7\uffff\32\31"+
            "\4\uffff\1\31\1\uffff\32\31",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\57\2\uffff\1\60",
            "\1\61",
            "",
            "",
            "\1\62",
            "\1\63",
            "",
            "\1\64",
            "\1\65",
            "\1\31\6\uffff\1\31\1\uffff\1\31\2\uffff\12\31\7\uffff\32\31"+
            "\4\uffff\1\31\1\uffff\32\31",
            "\1\67",
            "\1\31\6\uffff\1\31\1\uffff\1\31\2\uffff\12\31\7\uffff\32\31"+
            "\4\uffff\1\31\1\uffff\32\31",
            "\1\31\6\uffff\1\31\1\uffff\1\31\2\uffff\12\31\7\uffff\32\31"+
            "\4\uffff\1\31\1\uffff\32\31",
            "\1\31\6\uffff\1\31\1\uffff\1\31\2\uffff\12\31\7\uffff\32\31"+
            "\4\uffff\1\31\1\uffff\32\31",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\31\6\uffff\1\31\1\uffff\1\31\2\uffff\12\31\7\uffff\32\31"+
            "\4\uffff\1\31\1\uffff\32\31",
            "\1\77",
            "",
            "\1\31\6\uffff\1\31\1\uffff\1\31\2\uffff\12\31\7\uffff\32\31"+
            "\4\uffff\1\31\1\uffff\32\31",
            "",
            "",
            "",
            "\1\31\6\uffff\1\31\1\uffff\1\31\2\uffff\12\31\7\uffff\32\31"+
            "\4\uffff\1\31\1\uffff\32\31",
            "\1\102",
            "\1\103",
            "",
            "\1\31\6\uffff\1\31\1\uffff\1\31\2\uffff\12\31\7\uffff\32\31"+
            "\4\uffff\1\31\1\uffff\32\31",
            "",
            "",
            "\1\31\6\uffff\1\31\1\uffff\1\31\2\uffff\12\31\7\uffff\32\31"+
            "\4\uffff\1\31\1\uffff\32\31",
            "\1\31\6\uffff\1\31\1\uffff\1\31\2\uffff\12\31\7\uffff\32\31"+
            "\4\uffff\1\31\1\uffff\32\31",
            "",
            "",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | SEMICOLON | COLON | COMMA | PERIOD | EQUALS | LBRACKET | RBRACKET | INT | STRING_LITERAL | IDENT | WHITESPACE | LINE_COMMENT | MULTILINE_COMMENT );";
        }
    }
 

}