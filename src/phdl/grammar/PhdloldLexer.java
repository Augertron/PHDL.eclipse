// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g 2012-01-06 22:48:25

/*
    Copyright (C) 2011  BYU Configurable Computing Lab

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

	package phdl.grammar;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class PhdloldLexer extends Lexer {
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


    	/**
    	 * Class to enable pushing a character stream onto a stack
    	 */
    	class SaveStruct {
    		public CharStream input;
    		public int marker;
    		
    		/**
    		 * The constructor
    		 */
    		SaveStruct(CharStream input) {
    			this.input = input;
    			this.marker = input.mark();
    		}
    	}
    	
    	/**
    	 * The stack of saved character streams
    	 */
    	Stack<SaveStruct> includes = new Stack<SaveStruct>();
    	
    	/**
    	 * Overridden nextToken method to accomodate the saved character stream states, and how to handle the tokens
    	 * entering and leaving an included file.
    	 */
    	@Override
    	public Token nextToken() {
    		Token token = super.nextToken();		
    		
    		if (token.getType() == Token.EOF && !includes.empty()) {
    			// EOF and a non-empty stack.  Pop a stream, set to it, 
    			// and rewind to its saved marker
    			SaveStruct ss = includes.pop();
    			setCharStream(ss.input);
    			input.rewind(ss.marker);
    			
    			// used to handle exits from nested includes.
    			// it only matters when the 'include' token is the last in the previous stream.
    			// using super, lexer crashes, returning EOF token.
    			token = this.nextToken();
    		}
    		
    		// skip the first token after switching on another input.
    		if (((CommonToken) token).getStartIndex() < 0)
    			token = this.nextToken();
    			
    		return token;
    	}


    // delegates
    // delegators

    public PhdloldLexer() {;} 
    public PhdloldLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public PhdloldLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g"; }

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:79:7: ( 'design' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:79:9: 'design'
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:80:7: ( 'port' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:80:9: 'port'
            {
            match("port"); 


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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:81:7: ( 'device' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:81:9: 'device'
            {
            match("device"); 


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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:82:7: ( 'attr' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:82:9: 'attr'
            {
            match("attr"); 


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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:83:7: ( 'pin' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:83:9: 'pin'
            {
            match("pin"); 


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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:84:7: ( 'net' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:84:9: 'net'
            {
            match("net"); 


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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:85:7: ( 'inst' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:85:9: 'inst'
            {
            match("inst"); 


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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:86:7: ( 'of' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:86:9: 'of'
            {
            match("of"); 


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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:87:7: ( 'sub' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:87:9: 'sub'
            {
            match("sub"); 


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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:88:7: ( 'combine' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:88:9: 'combine'
            {
            match("combine"); 


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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:89:7: ( 'newattr' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:89:9: 'newattr'
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:90:7: ( 'this' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:90:9: 'this'
            {
            match("this"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:91:7: ( 'info' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:91:9: 'info'
            {
            match("info"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:92:7: ( 'group' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:92:9: 'group'
            {
            match("group"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:93:7: ( 'open' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:93:9: 'open'
            {
            match("open"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:414:10: ( ';' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:414:12: ';'
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:415:6: ( ':' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:415:8: ':'
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:416:6: ( ',' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:416:8: ','
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:417:7: ( '.' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:417:9: '.'
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:418:7: ( '=' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:418:9: '='
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:419:10: ( '(' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:419:12: '('
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:420:11: ( ')' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:420:13: ')'
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:421:12: ( '[' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:421:14: '['
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:422:13: ( ']' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:422:15: ']'
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:423:10: ( '{' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:423:12: '{'
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:424:11: ( '}' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:424:13: '}'
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:425:10: ( '<' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:425:12: '<'
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:426:11: ( '>' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:426:13: '>'
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:427:10: ( '&' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:427:12: '&'
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:433:15: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' | '+' | '-' | '$' | '/' )
            int alt1=7;
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
            case '/':
                {
                alt1=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:433:17: ( 'a' .. 'z' )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:433:17: ( 'a' .. 'z' )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:433:18: 'a' .. 'z'
                    {
                    matchRange('a','z'); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:433:30: ( 'A' .. 'Z' )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:433:30: ( 'A' .. 'Z' )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:433:31: 'A' .. 'Z'
                    {
                    matchRange('A','Z'); 

                    }


                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:433:43: '_'
                    {
                    match('_'); 

                    }
                    break;
                case 4 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:433:49: '+'
                    {
                    match('+'); 

                    }
                    break;
                case 5 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:433:55: '-'
                    {
                    match('-'); 

                    }
                    break;
                case 6 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:433:61: '$'
                    {
                    match('$'); 

                    }
                    break;
                case 7 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:433:67: '/'
                    {
                    match('/'); 

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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:438:16: ( ( '0' .. '9' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:438:18: ( '0' .. '9' )
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:438:18: ( '0' .. '9' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:438:19: '0' .. '9'
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:443:9: ( ( DIGIT )+ )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:443:11: ( DIGIT )+
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:443:11: ( DIGIT )+
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:443:11: DIGIT
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

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:449:2: ( '\"' ( '/' '\"' | c=~ ( '\"' ) )* '\"' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:449:5: '\"' ( '/' '\"' | c=~ ( '\"' ) )* '\"'
            {
            match('\"'); 
            StringBuilder sb = new StringBuilder();
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:451:3: ( '/' '\"' | c=~ ( '\"' ) )*
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:451:5: '/' '\"'
            	    {
            	    match('/'); 
            	    match('\"'); 
            	    sb.appendCodePoint('"');

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:452:5: c=~ ( '\"' )
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
    // $ANTLR end "STRING"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:465:2: ( ( CHAR | DIGIT )+ )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:465:5: ( CHAR | DIGIT )+
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:465:5: ( CHAR | DIGIT )+
            int cnt4=0;
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='$'||LA4_0=='+'||LA4_0=='-'||LA4_0=='/'||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }
                else if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:465:6: CHAR
            	    {
            	    mCHAR(); 

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:465:13: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:472:2: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' | '\\u001D' )+ )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:472:4: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' | '\\u001D' )+
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:472:4: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' | '\\u001D' )+
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:480:2: ( '//' ( . )* ( '\\n' | '\\r' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:480:4: '//' ( . )* ( '\\n' | '\\r' )
            {
            match("//"); 

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:480:9: ( . )*
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:480:9: .
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:488:2: ( '/*' ( . )* '*/' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:488:4: '/*' ( . )* '*/'
            {
            match("/*"); 

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:488:9: ( . )*
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:488:9: .
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

    // $ANTLR start "INCLUDE"
    public final void mINCLUDE() throws RecognitionException {
        try {
            int _type = INCLUDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken fileName=null;

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:498:2: ( 'include' ( WHITESPACE )? fileName= STRING ';' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:498:5: 'include' ( WHITESPACE )? fileName= STRING ';'
            {
            match("include"); 

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:498:15: ( WHITESPACE )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>='\t' && LA8_0<='\n')||(LA8_0>='\f' && LA8_0<='\r')||LA8_0=='\u001D'||LA8_0==' ') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:498:16: WHITESPACE
                    {
                    mWHITESPACE(); 

                    }
                    break;

            }

            int fileNameStart529 = getCharIndex();
            int fileNameStartLine529 = getLine();
            int fileNameStartCharPos529 = getCharPositionInLine();
            mSTRING(); 
            fileName = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, fileNameStart529, getCharIndex()-1);
            fileName.setLine(fileNameStartLine529);
            fileName.setCharPositionInLine(fileNameStartCharPos529);
            match(';'); 
            	String name = fileName.getText();
            				name = name.substring(1,name.length()-1);
            				try {
            					// save the character stream by pushing it onto the stack
            					SaveStruct ss = new SaveStruct(input);
            					includes.push(ss);

            					// make a new ANTLRFileStream and switch to it
            					setCharStream(new ANTLRFileStream(name));
            					reset();

            				} catch(Exception fnf) { 
            					// exit if the file cannot be found
            					System.out.println(input.getSourceName() + " " + fileName.getLine() 
            						+ ":" + fileName.getCharPositionInLine() + " " + 
            						"Include file not found: " + fileName.getText()); 
            					System.exit(1);
            				}
            			

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INCLUDE"

    public void mTokens() throws RecognitionException {
        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:8: ( T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | SEMICOLON | COLON | COMMA | PERIOD | EQUALS | LEFTPAREN | RIGHTPAREN | LEFTBRACKET | RIGHTBRACKET | LEFTBRACE | RIGHTBRACE | LEFTANGLE | RIGHTANGLE | AMPERSAND | INTEGER | STRING | IDENT | WHITESPACE | LINE_COMMENT | MULTILINE_COMMENT | INCLUDE )
        int alt9=36;
        alt9 = dfa9.predict(input);
        switch (alt9) {
            case 1 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:10: T__27
                {
                mT__27(); 

                }
                break;
            case 2 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:16: T__28
                {
                mT__28(); 

                }
                break;
            case 3 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:22: T__29
                {
                mT__29(); 

                }
                break;
            case 4 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:28: T__30
                {
                mT__30(); 

                }
                break;
            case 5 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:34: T__31
                {
                mT__31(); 

                }
                break;
            case 6 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:40: T__32
                {
                mT__32(); 

                }
                break;
            case 7 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:46: T__33
                {
                mT__33(); 

                }
                break;
            case 8 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:52: T__34
                {
                mT__34(); 

                }
                break;
            case 9 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:58: T__35
                {
                mT__35(); 

                }
                break;
            case 10 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:64: T__36
                {
                mT__36(); 

                }
                break;
            case 11 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:70: T__37
                {
                mT__37(); 

                }
                break;
            case 12 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:76: T__38
                {
                mT__38(); 

                }
                break;
            case 13 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:82: T__39
                {
                mT__39(); 

                }
                break;
            case 14 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:88: T__40
                {
                mT__40(); 

                }
                break;
            case 15 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:94: T__41
                {
                mT__41(); 

                }
                break;
            case 16 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:100: SEMICOLON
                {
                mSEMICOLON(); 

                }
                break;
            case 17 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:110: COLON
                {
                mCOLON(); 

                }
                break;
            case 18 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:116: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 19 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:122: PERIOD
                {
                mPERIOD(); 

                }
                break;
            case 20 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:129: EQUALS
                {
                mEQUALS(); 

                }
                break;
            case 21 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:136: LEFTPAREN
                {
                mLEFTPAREN(); 

                }
                break;
            case 22 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:146: RIGHTPAREN
                {
                mRIGHTPAREN(); 

                }
                break;
            case 23 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:157: LEFTBRACKET
                {
                mLEFTBRACKET(); 

                }
                break;
            case 24 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:169: RIGHTBRACKET
                {
                mRIGHTBRACKET(); 

                }
                break;
            case 25 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:182: LEFTBRACE
                {
                mLEFTBRACE(); 

                }
                break;
            case 26 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:192: RIGHTBRACE
                {
                mRIGHTBRACE(); 

                }
                break;
            case 27 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:203: LEFTANGLE
                {
                mLEFTANGLE(); 

                }
                break;
            case 28 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:213: RIGHTANGLE
                {
                mRIGHTANGLE(); 

                }
                break;
            case 29 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:224: AMPERSAND
                {
                mAMPERSAND(); 

                }
                break;
            case 30 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:234: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 31 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:242: STRING
                {
                mSTRING(); 

                }
                break;
            case 32 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:249: IDENT
                {
                mIDENT(); 

                }
                break;
            case 33 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:255: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 34 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:266: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;
            case 35 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:279: MULTILINE_COMMENT
                {
                mMULTILINE_COMMENT(); 

                }
                break;
            case 36 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdlold.g:1:297: INCLUDE
                {
                mINCLUDE(); 

                }
                break;

        }

    }


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\1\uffff\12\33\16\uffff\1\52\2\uffff\1\33\1\uffff\6\33\1\67\5\33"+
        "\1\uffff\1\33\1\uffff\3\33\1\111\1\33\1\113\4\33\1\uffff\1\33\1"+
        "\121\3\33\1\uffff\12\33\1\127\1\uffff\1\130\1\uffff\1\33\1\132\1"+
        "\133\1\33\1\135\1\uffff\1\33\1\137\3\33\2\uffff\1\33\2\uffff\1\33"+
        "\1\uffff\1\33\1\uffff\1\146\1\147\1\150\3\33\3\uffff\1\154\1\33"+
        "\1\156\3\uffff";
    static final String DFA9_eofS =
        "\157\uffff";
    static final String DFA9_minS =
        "\1\11\1\145\1\151\1\164\1\145\1\156\1\146\1\165\1\157\1\150\1\162"+
        "\16\uffff\1\44\2\uffff\1\52\1\uffff\1\163\1\162\1\156\2\164\1\143"+
        "\1\44\1\145\1\142\1\155\1\151\1\157\1\uffff\1\0\1\uffff\2\151\1"+
        "\164\1\44\1\162\1\44\1\141\1\164\1\157\1\154\1\uffff\1\156\1\44"+
        "\1\142\1\163\1\165\1\uffff\10\0\1\147\1\143\1\44\1\uffff\1\44\1"+
        "\uffff\1\164\2\44\1\165\1\44\1\uffff\1\151\1\44\1\160\1\156\1\145"+
        "\2\uffff\1\164\2\uffff\1\144\1\uffff\1\156\1\uffff\3\44\1\162\2"+
        "\145\3\uffff\1\44\1\11\1\44\3\uffff";
    static final String DFA9_maxS =
        "\1\175\1\145\1\157\1\164\1\145\1\156\1\160\1\165\1\157\1\150\1"+
        "\162\16\uffff\1\172\2\uffff\1\57\1\uffff\1\166\1\162\1\156\1\164"+
        "\1\167\1\163\1\172\1\145\1\142\1\155\1\151\1\157\1\uffff\1\uffff"+
        "\1\uffff\2\151\1\164\1\172\1\162\1\172\1\141\1\164\1\157\1\154\1"+
        "\uffff\1\156\1\172\1\142\1\163\1\165\1\uffff\10\uffff\1\147\1\143"+
        "\1\172\1\uffff\1\172\1\uffff\1\164\2\172\1\165\1\172\1\uffff\1\151"+
        "\1\172\1\160\1\156\1\145\2\uffff\1\164\2\uffff\1\144\1\uffff\1\156"+
        "\1\uffff\3\172\1\162\2\145\3\uffff\1\172\1\42\1\172\3\uffff";
    static final String DFA9_acceptS =
        "\13\uffff\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32"+
        "\1\33\1\34\1\35\1\uffff\1\37\1\40\1\uffff\1\41\14\uffff\1\36\1\uffff"+
        "\1\43\12\uffff\1\10\5\uffff\1\42\13\uffff\1\5\1\uffff\1\6\5\uffff"+
        "\1\11\5\uffff\1\2\1\4\1\uffff\1\7\1\15\1\uffff\1\17\1\uffff\1\14"+
        "\6\uffff\1\16\1\1\1\3\3\uffff\1\13\1\44\1\12";
    static final String DFA9_specialS =
        "\53\uffff\1\3\22\uffff\1\0\1\1\1\2\1\6\1\5\1\10\1\7\1\4\51\uffff}>";
    static final String[] DFA9_transitionS = {
            "\2\35\1\uffff\2\35\17\uffff\1\35\2\uffff\1\35\1\uffff\1\32"+
            "\1\uffff\1\33\1\uffff\1\30\1\uffff\1\20\1\21\1\uffff\1\33\1"+
            "\15\1\33\1\16\1\34\12\31\1\14\1\13\1\26\1\17\1\27\2\uffff\32"+
            "\33\1\22\1\uffff\1\23\1\uffff\1\33\1\uffff\1\3\1\33\1\10\1\1"+
            "\2\33\1\12\1\33\1\5\4\33\1\4\1\6\1\2\2\33\1\7\1\11\6\33\1\24"+
            "\1\uffff\1\25",
            "\1\36",
            "\1\40\5\uffff\1\37",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\44\11\uffff\1\45",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
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
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\1\33\12\31\7\uffff"+
            "\32\33\4\uffff\1\33\1\uffff\32\33",
            "",
            "",
            "\1\54\4\uffff\1\53",
            "",
            "\1\55\2\uffff\1\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62\2\uffff\1\63",
            "\1\66\2\uffff\1\65\14\uffff\1\64",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "",
            "\44\75\1\103\6\75\1\101\1\75\1\102\1\75\1\104\12\105\7\75"+
            "\32\77\4\75\1\100\1\75\32\76\uff85\75",
            "",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "\1\112",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "",
            "\1\120",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "\1\122",
            "\1\123",
            "\1\124",
            "",
            "\44\75\1\103\6\75\1\101\1\75\1\102\1\75\1\104\12\105\7\75"+
            "\32\77\4\75\1\100\1\75\32\76\uff85\75",
            "\44\75\1\103\6\75\1\101\1\75\1\102\1\75\1\104\12\105\7\75"+
            "\32\77\4\75\1\100\1\75\32\76\uff85\75",
            "\44\75\1\103\6\75\1\101\1\75\1\102\1\75\1\104\12\105\7\75"+
            "\32\77\4\75\1\100\1\75\32\76\uff85\75",
            "\44\75\1\103\6\75\1\101\1\75\1\102\1\75\1\104\12\105\7\75"+
            "\32\77\4\75\1\100\1\75\32\76\uff85\75",
            "\44\75\1\103\6\75\1\101\1\75\1\102\1\75\1\104\12\105\7\75"+
            "\32\77\4\75\1\100\1\75\32\76\uff85\75",
            "\44\75\1\103\6\75\1\101\1\75\1\102\1\75\1\104\12\105\7\75"+
            "\32\77\4\75\1\100\1\75\32\76\uff85\75",
            "\44\75\1\103\6\75\1\101\1\75\1\102\1\75\1\104\12\105\7\75"+
            "\32\77\4\75\1\100\1\75\32\76\uff85\75",
            "\44\75\1\103\6\75\1\101\1\75\1\102\1\75\1\104\12\105\7\75"+
            "\32\77\4\75\1\100\1\75\32\76\uff85\75",
            "\1\125",
            "\1\126",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "",
            "\1\131",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "\1\134",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "",
            "\1\136",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "\1\140",
            "\1\141",
            "\1\142",
            "",
            "",
            "\1\143",
            "",
            "",
            "\1\144",
            "",
            "\1\145",
            "",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "\1\151",
            "\1\152",
            "\1\153",
            "",
            "",
            "",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "\2\155\1\uffff\2\155\17\uffff\1\155\2\uffff\1\155\1\uffff"+
            "\1\155",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "",
            "",
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
            return "1:1: Tokens : ( T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | SEMICOLON | COLON | COMMA | PERIOD | EQUALS | LEFTPAREN | RIGHTPAREN | LEFTBRACKET | RIGHTBRACKET | LEFTBRACE | RIGHTBRACE | LEFTANGLE | RIGHTANGLE | AMPERSAND | INTEGER | STRING | IDENT | WHITESPACE | LINE_COMMENT | MULTILINE_COMMENT | INCLUDE );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA9_62 = input.LA(1);

                        s = -1;
                        if ( ((LA9_62>='\u0000' && LA9_62<='#')||(LA9_62>='%' && LA9_62<='*')||LA9_62==','||LA9_62=='.'||(LA9_62>=':' && LA9_62<='@')||(LA9_62>='[' && LA9_62<='^')||LA9_62=='`'||(LA9_62>='{' && LA9_62<='\uFFFF')) ) {s = 61;}

                        else if ( ((LA9_62>='a' && LA9_62<='z')) ) {s = 62;}

                        else if ( ((LA9_62>='A' && LA9_62<='Z')) ) {s = 63;}

                        else if ( (LA9_62=='_') ) {s = 64;}

                        else if ( (LA9_62=='+') ) {s = 65;}

                        else if ( (LA9_62=='-') ) {s = 66;}

                        else if ( (LA9_62=='$') ) {s = 67;}

                        else if ( (LA9_62=='/') ) {s = 68;}

                        else if ( ((LA9_62>='0' && LA9_62<='9')) ) {s = 69;}

                        else s = 27;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA9_63 = input.LA(1);

                        s = -1;
                        if ( ((LA9_63>='\u0000' && LA9_63<='#')||(LA9_63>='%' && LA9_63<='*')||LA9_63==','||LA9_63=='.'||(LA9_63>=':' && LA9_63<='@')||(LA9_63>='[' && LA9_63<='^')||LA9_63=='`'||(LA9_63>='{' && LA9_63<='\uFFFF')) ) {s = 61;}

                        else if ( ((LA9_63>='a' && LA9_63<='z')) ) {s = 62;}

                        else if ( ((LA9_63>='A' && LA9_63<='Z')) ) {s = 63;}

                        else if ( (LA9_63=='_') ) {s = 64;}

                        else if ( (LA9_63=='+') ) {s = 65;}

                        else if ( (LA9_63=='-') ) {s = 66;}

                        else if ( (LA9_63=='$') ) {s = 67;}

                        else if ( (LA9_63=='/') ) {s = 68;}

                        else if ( ((LA9_63>='0' && LA9_63<='9')) ) {s = 69;}

                        else s = 27;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA9_64 = input.LA(1);

                        s = -1;
                        if ( ((LA9_64>='\u0000' && LA9_64<='#')||(LA9_64>='%' && LA9_64<='*')||LA9_64==','||LA9_64=='.'||(LA9_64>=':' && LA9_64<='@')||(LA9_64>='[' && LA9_64<='^')||LA9_64=='`'||(LA9_64>='{' && LA9_64<='\uFFFF')) ) {s = 61;}

                        else if ( ((LA9_64>='a' && LA9_64<='z')) ) {s = 62;}

                        else if ( ((LA9_64>='A' && LA9_64<='Z')) ) {s = 63;}

                        else if ( (LA9_64=='_') ) {s = 64;}

                        else if ( (LA9_64=='+') ) {s = 65;}

                        else if ( (LA9_64=='-') ) {s = 66;}

                        else if ( (LA9_64=='$') ) {s = 67;}

                        else if ( (LA9_64=='/') ) {s = 68;}

                        else if ( ((LA9_64>='0' && LA9_64<='9')) ) {s = 69;}

                        else s = 27;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA9_43 = input.LA(1);

                        s = -1;
                        if ( ((LA9_43>='\u0000' && LA9_43<='#')||(LA9_43>='%' && LA9_43<='*')||LA9_43==','||LA9_43=='.'||(LA9_43>=':' && LA9_43<='@')||(LA9_43>='[' && LA9_43<='^')||LA9_43=='`'||(LA9_43>='{' && LA9_43<='\uFFFF')) ) {s = 61;}

                        else if ( ((LA9_43>='a' && LA9_43<='z')) ) {s = 62;}

                        else if ( ((LA9_43>='A' && LA9_43<='Z')) ) {s = 63;}

                        else if ( (LA9_43=='_') ) {s = 64;}

                        else if ( (LA9_43=='+') ) {s = 65;}

                        else if ( (LA9_43=='-') ) {s = 66;}

                        else if ( (LA9_43=='$') ) {s = 67;}

                        else if ( (LA9_43=='/') ) {s = 68;}

                        else if ( ((LA9_43>='0' && LA9_43<='9')) ) {s = 69;}

                        else s = 27;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA9_69 = input.LA(1);

                        s = -1;
                        if ( ((LA9_69>='\u0000' && LA9_69<='#')||(LA9_69>='%' && LA9_69<='*')||LA9_69==','||LA9_69=='.'||(LA9_69>=':' && LA9_69<='@')||(LA9_69>='[' && LA9_69<='^')||LA9_69=='`'||(LA9_69>='{' && LA9_69<='\uFFFF')) ) {s = 61;}

                        else if ( ((LA9_69>='a' && LA9_69<='z')) ) {s = 62;}

                        else if ( ((LA9_69>='A' && LA9_69<='Z')) ) {s = 63;}

                        else if ( (LA9_69=='_') ) {s = 64;}

                        else if ( (LA9_69=='+') ) {s = 65;}

                        else if ( (LA9_69=='-') ) {s = 66;}

                        else if ( (LA9_69=='$') ) {s = 67;}

                        else if ( (LA9_69=='/') ) {s = 68;}

                        else if ( ((LA9_69>='0' && LA9_69<='9')) ) {s = 69;}

                        else s = 27;

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA9_66 = input.LA(1);

                        s = -1;
                        if ( ((LA9_66>='\u0000' && LA9_66<='#')||(LA9_66>='%' && LA9_66<='*')||LA9_66==','||LA9_66=='.'||(LA9_66>=':' && LA9_66<='@')||(LA9_66>='[' && LA9_66<='^')||LA9_66=='`'||(LA9_66>='{' && LA9_66<='\uFFFF')) ) {s = 61;}

                        else if ( ((LA9_66>='a' && LA9_66<='z')) ) {s = 62;}

                        else if ( ((LA9_66>='A' && LA9_66<='Z')) ) {s = 63;}

                        else if ( (LA9_66=='_') ) {s = 64;}

                        else if ( (LA9_66=='+') ) {s = 65;}

                        else if ( (LA9_66=='-') ) {s = 66;}

                        else if ( (LA9_66=='$') ) {s = 67;}

                        else if ( (LA9_66=='/') ) {s = 68;}

                        else if ( ((LA9_66>='0' && LA9_66<='9')) ) {s = 69;}

                        else s = 27;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA9_65 = input.LA(1);

                        s = -1;
                        if ( ((LA9_65>='\u0000' && LA9_65<='#')||(LA9_65>='%' && LA9_65<='*')||LA9_65==','||LA9_65=='.'||(LA9_65>=':' && LA9_65<='@')||(LA9_65>='[' && LA9_65<='^')||LA9_65=='`'||(LA9_65>='{' && LA9_65<='\uFFFF')) ) {s = 61;}

                        else if ( ((LA9_65>='a' && LA9_65<='z')) ) {s = 62;}

                        else if ( ((LA9_65>='A' && LA9_65<='Z')) ) {s = 63;}

                        else if ( (LA9_65=='_') ) {s = 64;}

                        else if ( (LA9_65=='+') ) {s = 65;}

                        else if ( (LA9_65=='-') ) {s = 66;}

                        else if ( (LA9_65=='$') ) {s = 67;}

                        else if ( (LA9_65=='/') ) {s = 68;}

                        else if ( ((LA9_65>='0' && LA9_65<='9')) ) {s = 69;}

                        else s = 27;

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA9_68 = input.LA(1);

                        s = -1;
                        if ( ((LA9_68>='\u0000' && LA9_68<='#')||(LA9_68>='%' && LA9_68<='*')||LA9_68==','||LA9_68=='.'||(LA9_68>=':' && LA9_68<='@')||(LA9_68>='[' && LA9_68<='^')||LA9_68=='`'||(LA9_68>='{' && LA9_68<='\uFFFF')) ) {s = 61;}

                        else if ( ((LA9_68>='a' && LA9_68<='z')) ) {s = 62;}

                        else if ( ((LA9_68>='A' && LA9_68<='Z')) ) {s = 63;}

                        else if ( (LA9_68=='_') ) {s = 64;}

                        else if ( (LA9_68=='+') ) {s = 65;}

                        else if ( (LA9_68=='-') ) {s = 66;}

                        else if ( (LA9_68=='$') ) {s = 67;}

                        else if ( (LA9_68=='/') ) {s = 68;}

                        else if ( ((LA9_68>='0' && LA9_68<='9')) ) {s = 69;}

                        else s = 27;

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA9_67 = input.LA(1);

                        s = -1;
                        if ( ((LA9_67>='\u0000' && LA9_67<='#')||(LA9_67>='%' && LA9_67<='*')||LA9_67==','||LA9_67=='.'||(LA9_67>=':' && LA9_67<='@')||(LA9_67>='[' && LA9_67<='^')||LA9_67=='`'||(LA9_67>='{' && LA9_67<='\uFFFF')) ) {s = 61;}

                        else if ( ((LA9_67>='a' && LA9_67<='z')) ) {s = 62;}

                        else if ( ((LA9_67>='A' && LA9_67<='Z')) ) {s = 63;}

                        else if ( (LA9_67=='_') ) {s = 64;}

                        else if ( (LA9_67=='+') ) {s = 65;}

                        else if ( (LA9_67=='-') ) {s = 66;}

                        else if ( (LA9_67=='$') ) {s = 67;}

                        else if ( (LA9_67=='/') ) {s = 68;}

                        else if ( ((LA9_67>='0' && LA9_67<='9')) ) {s = 69;}

                        else s = 27;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 9, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}