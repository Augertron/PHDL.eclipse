// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\work\\phdl\\src\\phdl\\PHDL.g 2011-05-31 16:01:02

  package phdl;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class PHDLLexer extends Lexer {
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

    public PHDLLexer() {;} 
    public PHDLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public PHDLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\work\\phdl\\src\\phdl\\PHDL.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:11:7: ( 'design' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:11:9: 'design'
            {
            match("design"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:12:7: ( 'is' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:12:9: 'is'
            {
            match("is"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:13:7: ( 'begin' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:13:9: 'begin'
            {
            match("begin"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:14:7: ( 'end' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:14:9: 'end'
            {
            match("end"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:15:7: ( ';' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:15:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:16:7: ( 'configuration' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:16:9: 'configuration'
            {
            match("configuration"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:17:7: ( 'device' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:17:9: 'device'
            {
            match("device"); 


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
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:18:7: ( 'net' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:18:9: 'net'
            {
            match("net"); 


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
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:19:7: ( ':' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:19:9: ':'
            {
            match(':'); 

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
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:20:7: ( '=' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:20:9: '='
            {
            match('='); 

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
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:21:7: ( '[' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:21:9: '['
            {
            match('['); 

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
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:22:7: ( ']' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:22:9: ']'
            {
            match(']'); 

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
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:23:7: ( 'inst' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:23:9: 'inst'
            {
            match("inst"); 


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
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:24:7: ( 'subSch' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:24:9: 'subSch'
            {
            match("subSch"); 


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
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:25:7: ( 'in' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:25:9: 'in'
            {
            match("in"); 


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
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:26:7: ( 'out' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:26:9: 'out'
            {
            match("out"); 


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
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:27:7: ( 'inout' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:27:9: 'inout'
            {
            match("inout"); 


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
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:28:7: ( 'pass' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:28:9: 'pass'
            {
            match("pass"); 


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
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:29:7: ( 'sup' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:29:9: 'sup'
            {
            match("sup"); 


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
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:30:7: ( 'pwr' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:30:9: 'pwr'
            {
            match("pwr"); 


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
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:31:7: ( 'open' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:31:9: 'open'
            {
            match("open"); 


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
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:32:7: ( 'pin' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:32:9: 'pin'
            {
            match("pin"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:198:15: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' | '-' | '+' | '%' | '.' | '$' | '*' )
            int alt1=9;
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
            case '-':
                {
                alt1=4;
                }
                break;
            case '+':
                {
                alt1=5;
                }
                break;
            case '%':
                {
                alt1=6;
                }
                break;
            case '.':
                {
                alt1=7;
                }
                break;
            case '$':
                {
                alt1=8;
                }
                break;
            case '*':
                {
                alt1=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\PHDL.g:198:17: ( 'a' .. 'z' )
                    {
                    // C:\\work\\phdl\\src\\phdl\\PHDL.g:198:17: ( 'a' .. 'z' )
                    // C:\\work\\phdl\\src\\phdl\\PHDL.g:198:18: 'a' .. 'z'
                    {
                    matchRange('a','z'); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\work\\phdl\\src\\phdl\\PHDL.g:198:30: ( 'A' .. 'Z' )
                    {
                    // C:\\work\\phdl\\src\\phdl\\PHDL.g:198:30: ( 'A' .. 'Z' )
                    // C:\\work\\phdl\\src\\phdl\\PHDL.g:198:31: 'A' .. 'Z'
                    {
                    matchRange('A','Z'); 

                    }


                    }
                    break;
                case 3 :
                    // C:\\work\\phdl\\src\\phdl\\PHDL.g:198:43: '_'
                    {
                    match('_'); 

                    }
                    break;
                case 4 :
                    // C:\\work\\phdl\\src\\phdl\\PHDL.g:198:49: '-'
                    {
                    match('-'); 

                    }
                    break;
                case 5 :
                    // C:\\work\\phdl\\src\\phdl\\PHDL.g:198:55: '+'
                    {
                    match('+'); 

                    }
                    break;
                case 6 :
                    // C:\\work\\phdl\\src\\phdl\\PHDL.g:198:61: '%'
                    {
                    match('%'); 

                    }
                    break;
                case 7 :
                    // C:\\work\\phdl\\src\\phdl\\PHDL.g:198:67: '.'
                    {
                    match('.'); 

                    }
                    break;
                case 8 :
                    // C:\\work\\phdl\\src\\phdl\\PHDL.g:198:73: '$'
                    {
                    match('$'); 

                    }
                    break;
                case 9 :
                    // C:\\work\\phdl\\src\\phdl\\PHDL.g:198:79: '*'
                    {
                    match('*'); 

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
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:200:16: ( '0' .. '9' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:200:18: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:202:16: ( ',' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:202:18: ','
            {
            match(','); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:204:5: ( ( DIGIT )+ )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:204:7: ( DIGIT )+
            {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:204:7: ( DIGIT )+
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
            	    // C:\\work\\phdl\\src\\phdl\\PHDL.g:204:7: DIGIT
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

            // C:\\work\\phdl\\src\\phdl\\PHDL.g:207:2: ( '\"' ( '/' '\"' | c=~ ( '\"' | '\\r' | '\\n' ) )* '\"' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:207:5: '\"' ( '/' '\"' | c=~ ( '\"' | '\\r' | '\\n' ) )* '\"'
            {
            match('\"'); 
            StringBuilder sb = new StringBuilder();
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:209:3: ( '/' '\"' | c=~ ( '\"' | '\\r' | '\\n' ) )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='/') ) {
                    int LA3_2 = input.LA(2);

                    if ( (LA3_2=='\"') ) {
                        int LA3_4 = input.LA(3);

                        if ( ((LA3_4>='\u0000' && LA3_4<='\t')||(LA3_4>='\u000B' && LA3_4<='\f')||(LA3_4>='\u000E' && LA3_4<='\uFFFF')) ) {
                            alt3=1;
                        }

                        else {
                            alt3=2;
                        }

                    }
                    else if ( ((LA3_2>='\u0000' && LA3_2<='\t')||(LA3_2>='\u000B' && LA3_2<='\f')||(LA3_2>='\u000E' && LA3_2<='!')||(LA3_2>='#' && LA3_2<='\uFFFF')) ) {
                        alt3=2;
                    }


                }
                else if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='\f')||(LA3_0>='\u000E' && LA3_0<='!')||(LA3_0>='#' && LA3_0<='.')||(LA3_0>='0' && LA3_0<='\uFFFF')) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\PHDL.g:209:5: '/' '\"'
            	    {
            	    match('/'); 
            	    match('\"'); 
            	    sb.appendCodePoint('"');

            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\phdl\\src\\phdl\\PHDL.g:210:5: c=~ ( '\"' | '\\r' | '\\n' )
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
    // $ANTLR end "STRING_LITERAL"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:217:2: ( CHAR ( CHAR | DIGIT )* )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:217:4: CHAR ( CHAR | DIGIT )*
            {
            mCHAR(); 
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:217:9: ( CHAR | DIGIT )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='$' && LA4_0<='%')||(LA4_0>='*' && LA4_0<='+')||(LA4_0>='-' && LA4_0<='.')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }
                else if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\PHDL.g:217:11: CHAR
            	    {
            	    mCHAR(); 

            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\phdl\\src\\phdl\\PHDL.g:217:18: DIGIT
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
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:221:2: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' | '\\u001D' )+ )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:221:4: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' | '\\u001D' )+
            {
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:221:4: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' | '\\u001D' )+
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
            	    // C:\\work\\phdl\\src\\phdl\\PHDL.g:
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
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:225:2: ( '//' ( . )* ( '\\n' | '\\r' ) )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:225:4: '//' ( . )* ( '\\n' | '\\r' )
            {
            match("//"); 

            // C:\\work\\phdl\\src\\phdl\\PHDL.g:225:9: ( . )*
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
            	    // C:\\work\\phdl\\src\\phdl\\PHDL.g:225:9: .
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
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:229:2: ( '/*' ( . )* '*/' )
            // C:\\work\\phdl\\src\\phdl\\PHDL.g:229:4: '/*' ( . )* '*/'
            {
            match("/*"); 

            // C:\\work\\phdl\\src\\phdl\\PHDL.g:229:9: ( . )*
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
            	    // C:\\work\\phdl\\src\\phdl\\PHDL.g:229:9: .
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
        // C:\\work\\phdl\\src\\phdl\\PHDL.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | INT | STRING_LITERAL | IDENT | WHITESPACE | LINE_COMMENT | MULTILINE_COMMENT )
        int alt8=28;
        alt8 = dfa8.predict(input);
        switch (alt8) {
            case 1 :
                // C:\\work\\phdl\\src\\phdl\\PHDL.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // C:\\work\\phdl\\src\\phdl\\PHDL.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // C:\\work\\phdl\\src\\phdl\\PHDL.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // C:\\work\\phdl\\src\\phdl\\PHDL.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // C:\\work\\phdl\\src\\phdl\\PHDL.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // C:\\work\\phdl\\src\\phdl\\PHDL.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // C:\\work\\phdl\\src\\phdl\\PHDL.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // C:\\work\\phdl\\src\\phdl\\PHDL.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // C:\\work\\phdl\\src\\phdl\\PHDL.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // C:\\work\\phdl\\src\\phdl\\PHDL.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // C:\\work\\phdl\\src\\phdl\\PHDL.g:1:70: T__23
                {
                mT__23(); 

                }
                break;
            case 12 :
                // C:\\work\\phdl\\src\\phdl\\PHDL.g:1:76: T__24
                {
                mT__24(); 

                }
                break;
            case 13 :
                // C:\\work\\phdl\\src\\phdl\\PHDL.g:1:82: T__25
                {
                mT__25(); 

                }
                break;
            case 14 :
                // C:\\work\\phdl\\src\\phdl\\PHDL.g:1:88: T__26
                {
                mT__26(); 

                }
                break;
            case 15 :
                // C:\\work\\phdl\\src\\phdl\\PHDL.g:1:94: T__27
                {
                mT__27(); 

                }
                break;
            case 16 :
                // C:\\work\\phdl\\src\\phdl\\PHDL.g:1:100: T__28
                {
                mT__28(); 

                }
                break;
            case 17 :
                // C:\\work\\phdl\\src\\phdl\\PHDL.g:1:106: T__29
                {
                mT__29(); 

                }
                break;
            case 18 :
                // C:\\work\\phdl\\src\\phdl\\PHDL.g:1:112: T__30
                {
                mT__30(); 

                }
                break;
            case 19 :
                // C:\\work\\phdl\\src\\phdl\\PHDL.g:1:118: T__31
                {
                mT__31(); 

                }
                break;
            case 20 :
                // C:\\work\\phdl\\src\\phdl\\PHDL.g:1:124: T__32
                {
                mT__32(); 

                }
                break;
            case 21 :
                // C:\\work\\phdl\\src\\phdl\\PHDL.g:1:130: T__33
                {
                mT__33(); 

                }
                break;
            case 22 :
                // C:\\work\\phdl\\src\\phdl\\PHDL.g:1:136: T__34
                {
                mT__34(); 

                }
                break;
            case 23 :
                // C:\\work\\phdl\\src\\phdl\\PHDL.g:1:142: INT
                {
                mINT(); 

                }
                break;
            case 24 :
                // C:\\work\\phdl\\src\\phdl\\PHDL.g:1:146: STRING_LITERAL
                {
                mSTRING_LITERAL(); 

                }
                break;
            case 25 :
                // C:\\work\\phdl\\src\\phdl\\PHDL.g:1:161: IDENT
                {
                mIDENT(); 

                }
                break;
            case 26 :
                // C:\\work\\phdl\\src\\phdl\\PHDL.g:1:167: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 27 :
                // C:\\work\\phdl\\src\\phdl\\PHDL.g:1:178: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;
            case 28 :
                // C:\\work\\phdl\\src\\phdl\\PHDL.g:1:191: MULTILINE_COMMENT
                {
                mMULTILINE_COMMENT(); 

                }
                break;

        }

    }


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\1\uffff\4\21\1\uffff\2\21\4\uffff\3\21\5\uffff\1\21\1\45\1\50"+
        "\12\21\2\uffff\2\21\1\uffff\2\21\1\uffff\1\21\1\71\1\21\1\73\1\21"+
        "\1\75\1\76\2\21\1\101\1\102\2\21\1\105\2\21\1\uffff\1\21\1\uffff"+
        "\1\21\2\uffff\1\112\1\113\2\uffff\2\21\1\uffff\1\116\1\117\2\21"+
        "\2\uffff\1\122\1\123\2\uffff\1\21\1\125\2\uffff\1\21\1\uffff\5\21"+
        "\1\134\1\uffff";
    static final String DFA8_eofS =
        "\135\uffff";
    static final String DFA8_minS =
        "\1\11\1\145\1\156\1\145\1\156\1\uffff\1\157\1\145\4\uffff\1\165"+
        "\1\160\1\141\4\uffff\1\52\1\163\2\44\1\147\1\144\1\156\1\164\1\142"+
        "\1\164\1\145\1\163\1\162\1\156\2\uffff\2\151\1\uffff\1\164\1\165"+
        "\1\uffff\1\151\1\44\1\146\1\44\1\123\2\44\1\156\1\163\2\44\1\147"+
        "\1\143\1\44\1\164\1\156\1\uffff\1\151\1\uffff\1\143\2\uffff\2\44"+
        "\2\uffff\1\156\1\145\1\uffff\2\44\1\147\1\150\2\uffff\2\44\2\uffff"+
        "\1\165\1\44\2\uffff\1\162\1\uffff\1\141\1\164\1\151\1\157\1\156"+
        "\1\44\1\uffff";
    static final String DFA8_maxS =
        "\1\172\1\145\1\163\1\145\1\156\1\uffff\1\157\1\145\4\uffff\2\165"+
        "\1\167\4\uffff\1\57\1\166\2\172\1\147\1\144\1\156\1\164\1\160\1"+
        "\164\1\145\1\163\1\162\1\156\2\uffff\2\151\1\uffff\1\164\1\165\1"+
        "\uffff\1\151\1\172\1\146\1\172\1\123\2\172\1\156\1\163\2\172\1\147"+
        "\1\143\1\172\1\164\1\156\1\uffff\1\151\1\uffff\1\143\2\uffff\2\172"+
        "\2\uffff\1\156\1\145\1\uffff\2\172\1\147\1\150\2\uffff\2\172\2\uffff"+
        "\1\165\1\172\2\uffff\1\162\1\uffff\1\141\1\164\1\151\1\157\1\156"+
        "\1\172\1\uffff";
    static final String DFA8_acceptS =
        "\5\uffff\1\5\2\uffff\1\11\1\12\1\13\1\14\3\uffff\1\27\1\30\1\31"+
        "\1\32\16\uffff\1\33\1\34\2\uffff\1\2\2\uffff\1\17\20\uffff\1\4\1"+
        "\uffff\1\10\1\uffff\1\23\1\20\2\uffff\1\24\1\26\2\uffff\1\15\4\uffff"+
        "\1\25\1\22\2\uffff\1\21\1\3\2\uffff\1\1\1\7\1\uffff\1\16\6\uffff"+
        "\1\6";
    static final String DFA8_specialS =
        "\135\uffff}>";
    static final String[] DFA8_transitionS = {
            "\2\22\1\uffff\2\22\17\uffff\1\22\2\uffff\1\22\1\uffff\1\20"+
            "\1\uffff\2\21\4\uffff\2\21\1\uffff\2\21\1\23\12\17\1\10\1\5"+
            "\1\uffff\1\11\3\uffff\32\21\1\12\1\uffff\1\13\1\uffff\1\21\1"+
            "\uffff\1\21\1\3\1\6\1\1\1\4\3\21\1\2\4\21\1\7\1\15\1\16\2\21"+
            "\1\14\7\21",
            "\1\24",
            "\1\26\4\uffff\1\25",
            "\1\27",
            "\1\30",
            "",
            "\1\31",
            "\1\32",
            "",
            "",
            "",
            "",
            "\1\33",
            "\1\35\4\uffff\1\34",
            "\1\36\7\uffff\1\40\15\uffff\1\37",
            "",
            "",
            "",
            "",
            "\1\42\4\uffff\1\41",
            "\1\43\2\uffff\1\44",
            "\2\21\4\uffff\2\21\1\uffff\2\21\1\uffff\12\21\7\uffff\32\21"+
            "\4\uffff\1\21\1\uffff\32\21",
            "\2\21\4\uffff\2\21\1\uffff\2\21\1\uffff\12\21\7\uffff\32\21"+
            "\4\uffff\1\21\1\uffff\16\21\1\47\3\21\1\46\7\21",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55\15\uffff\1\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "",
            "",
            "\1\64",
            "\1\65",
            "",
            "\1\66",
            "\1\67",
            "",
            "\1\70",
            "\2\21\4\uffff\2\21\1\uffff\2\21\1\uffff\12\21\7\uffff\32\21"+
            "\4\uffff\1\21\1\uffff\32\21",
            "\1\72",
            "\2\21\4\uffff\2\21\1\uffff\2\21\1\uffff\12\21\7\uffff\32\21"+
            "\4\uffff\1\21\1\uffff\32\21",
            "\1\74",
            "\2\21\4\uffff\2\21\1\uffff\2\21\1\uffff\12\21\7\uffff\32\21"+
            "\4\uffff\1\21\1\uffff\32\21",
            "\2\21\4\uffff\2\21\1\uffff\2\21\1\uffff\12\21\7\uffff\32\21"+
            "\4\uffff\1\21\1\uffff\32\21",
            "\1\77",
            "\1\100",
            "\2\21\4\uffff\2\21\1\uffff\2\21\1\uffff\12\21\7\uffff\32\21"+
            "\4\uffff\1\21\1\uffff\32\21",
            "\2\21\4\uffff\2\21\1\uffff\2\21\1\uffff\12\21\7\uffff\32\21"+
            "\4\uffff\1\21\1\uffff\32\21",
            "\1\103",
            "\1\104",
            "\2\21\4\uffff\2\21\1\uffff\2\21\1\uffff\12\21\7\uffff\32\21"+
            "\4\uffff\1\21\1\uffff\32\21",
            "\1\106",
            "\1\107",
            "",
            "\1\110",
            "",
            "\1\111",
            "",
            "",
            "\2\21\4\uffff\2\21\1\uffff\2\21\1\uffff\12\21\7\uffff\32\21"+
            "\4\uffff\1\21\1\uffff\32\21",
            "\2\21\4\uffff\2\21\1\uffff\2\21\1\uffff\12\21\7\uffff\32\21"+
            "\4\uffff\1\21\1\uffff\32\21",
            "",
            "",
            "\1\114",
            "\1\115",
            "",
            "\2\21\4\uffff\2\21\1\uffff\2\21\1\uffff\12\21\7\uffff\32\21"+
            "\4\uffff\1\21\1\uffff\32\21",
            "\2\21\4\uffff\2\21\1\uffff\2\21\1\uffff\12\21\7\uffff\32\21"+
            "\4\uffff\1\21\1\uffff\32\21",
            "\1\120",
            "\1\121",
            "",
            "",
            "\2\21\4\uffff\2\21\1\uffff\2\21\1\uffff\12\21\7\uffff\32\21"+
            "\4\uffff\1\21\1\uffff\32\21",
            "\2\21\4\uffff\2\21\1\uffff\2\21\1\uffff\12\21\7\uffff\32\21"+
            "\4\uffff\1\21\1\uffff\32\21",
            "",
            "",
            "\1\124",
            "\2\21\4\uffff\2\21\1\uffff\2\21\1\uffff\12\21\7\uffff\32\21"+
            "\4\uffff\1\21\1\uffff\32\21",
            "",
            "",
            "\1\126",
            "",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\2\21\4\uffff\2\21\1\uffff\2\21\1\uffff\12\21\7\uffff\32\21"+
            "\4\uffff\1\21\1\uffff\32\21",
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
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | INT | STRING_LITERAL | IDENT | WHITESPACE | LINE_COMMENT | MULTILINE_COMMENT );";
        }
    }
 

}