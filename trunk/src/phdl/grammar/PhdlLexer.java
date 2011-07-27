// $ANTLR 3.3 Nov 30, 2010 12:50:56 /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g 2011-07-27 09:52:00

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
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int IDENT=4;
    public static final int SEMICOLON=5;
    public static final int EQUALS=6;
    public static final int STRING=7;
    public static final int COMMA=8;
    public static final int PERIOD=9;
    public static final int AMPERSAND=10;
    public static final int LEFTANGLE=11;
    public static final int RIGHTANGLE=12;
    public static final int LEFTBRACE=13;
    public static final int INTEGER=14;
    public static final int RIGHTBRACE=15;
    public static final int LEFTBRACKET=16;
    public static final int COLON=17;
    public static final int RIGHTBRACKET=18;
    public static final int LEFTPAREN=19;
    public static final int RIGHTPAREN=20;
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

    public PhdlLexer() {;} 
    public PhdlLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public PhdlLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g"; }

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:79:7: ( 'design' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:79:9: 'design'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:80:7: ( 'is' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:80:9: 'is'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:81:7: ( 'begin' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:81:9: 'begin'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:82:7: ( 'end' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:82:9: 'end'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:83:7: ( 'device' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:83:9: 'device'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:84:7: ( 'attr' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:84:9: 'attr'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:85:7: ( 'pin' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:85:9: 'pin'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:86:7: ( 'net' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:86:9: 'net'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:87:7: ( 'inst' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:87:9: 'inst'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:88:7: ( 'of' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:88:9: 'of'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:89:7: ( 'newattr' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:89:9: 'newattr'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:90:7: ( 'each' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:90:9: 'each'
            {
            match("each"); 


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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:91:7: ( 'this' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:91:9: 'this'
            {
            match("this"); 


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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:92:7: ( 'open' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:92:9: 'open'
            {
            match("open"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:353:10: ( ';' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:353:12: ';'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:354:6: ( ':' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:354:8: ':'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:355:6: ( ',' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:355:8: ','
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:356:7: ( '.' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:356:9: '.'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:357:7: ( '=' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:357:9: '='
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:358:10: ( '(' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:358:12: '('
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:359:11: ( ')' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:359:13: ')'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:360:12: ( '[' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:360:14: '['
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:361:13: ( ']' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:361:15: ']'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:362:10: ( '{' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:362:12: '{'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:363:11: ( '}' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:363:13: '}'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:364:10: ( '<' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:364:12: '<'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:365:11: ( '>' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:365:13: '>'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:366:10: ( '&' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:366:12: '&'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:372:15: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' | '+' | '-' | '$' | '/' )
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
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:372:17: ( 'a' .. 'z' )
                    {
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:372:17: ( 'a' .. 'z' )
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:372:18: 'a' .. 'z'
                    {
                    matchRange('a','z'); 

                    }


                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:372:30: ( 'A' .. 'Z' )
                    {
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:372:30: ( 'A' .. 'Z' )
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:372:31: 'A' .. 'Z'
                    {
                    matchRange('A','Z'); 

                    }


                    }
                    break;
                case 3 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:372:43: '_'
                    {
                    match('_'); 

                    }
                    break;
                case 4 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:372:49: '+'
                    {
                    match('+'); 

                    }
                    break;
                case 5 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:372:55: '-'
                    {
                    match('-'); 

                    }
                    break;
                case 6 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:372:61: '$'
                    {
                    match('$'); 

                    }
                    break;
                case 7 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:372:67: '/'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:377:16: ( ( '0' .. '9' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:377:18: ( '0' .. '9' )
            {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:377:18: ( '0' .. '9' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:377:19: '0' .. '9'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:382:9: ( ( DIGIT )+ )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:382:11: ( DIGIT )+
            {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:382:11: ( DIGIT )+
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
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:382:11: DIGIT
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

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:388:2: ( '\"' (c=~ ( '\"' | '\\n' | '\\r' ) )* '\"' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:388:5: '\"' (c=~ ( '\"' | '\\n' | '\\r' ) )* '\"'
            {
            match('\"'); 
            StringBuilder sb = new StringBuilder();
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:389:3: (c=~ ( '\"' | '\\n' | '\\r' ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='\f')||(LA3_0>='\u000E' && LA3_0<='!')||(LA3_0>='#' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:389:5: c=~ ( '\"' | '\\n' | '\\r' )
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:398:2: ( ( CHAR | DIGIT )+ )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:398:5: ( CHAR | DIGIT )+
            {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:398:5: ( CHAR | DIGIT )+
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
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:398:6: CHAR
            	    {
            	    mCHAR(); 

            	    }
            	    break;
            	case 2 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:398:13: DIGIT
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:405:2: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' | '\\u001D' )+ )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:405:4: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' | '\\u001D' )+
            {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:405:4: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' | '\\u001D' )+
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
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:413:2: ( '//' ( . )* ( '\\n' | '\\r' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:413:4: '//' ( . )* ( '\\n' | '\\r' )
            {
            match("//"); 

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:413:9: ( . )*
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
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:413:9: .
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:421:2: ( '/*' ( . )* '*/' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:421:4: '/*' ( . )* '*/'
            {
            match("/*"); 

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:421:9: ( . )*
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
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:421:9: .
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

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:431:2: ( 'include' ( WHITESPACE )? fileName= STRING ';' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:431:5: 'include' ( WHITESPACE )? fileName= STRING ';'
            {
            match("include"); 

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:431:15: ( WHITESPACE )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>='\t' && LA8_0<='\n')||(LA8_0>='\f' && LA8_0<='\r')||LA8_0=='\u001D'||LA8_0==' ') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:431:16: WHITESPACE
                    {
                    mWHITESPACE(); 

                    }
                    break;

            }

            int fileNameStart520 = getCharIndex();
            int fileNameStartLine520 = getLine();
            int fileNameStartCharPos520 = getCharPositionInLine();
            mSTRING(); 
            fileName = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, fileNameStart520, getCharIndex()-1);
            fileName.setLine(fileNameStartLine520);
            fileName.setCharPositionInLine(fileNameStartCharPos520);
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
        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:8: ( T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | SEMICOLON | COLON | COMMA | PERIOD | EQUALS | LEFTPAREN | RIGHTPAREN | LEFTBRACKET | RIGHTBRACKET | LEFTBRACE | RIGHTBRACE | LEFTANGLE | RIGHTANGLE | AMPERSAND | INTEGER | STRING | IDENT | WHITESPACE | LINE_COMMENT | MULTILINE_COMMENT | INCLUDE )
        int alt9=35;
        alt9 = dfa9.predict(input);
        switch (alt9) {
            case 1 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:10: T__27
                {
                mT__27(); 

                }
                break;
            case 2 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:16: T__28
                {
                mT__28(); 

                }
                break;
            case 3 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:22: T__29
                {
                mT__29(); 

                }
                break;
            case 4 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:28: T__30
                {
                mT__30(); 

                }
                break;
            case 5 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:34: T__31
                {
                mT__31(); 

                }
                break;
            case 6 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:40: T__32
                {
                mT__32(); 

                }
                break;
            case 7 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:46: T__33
                {
                mT__33(); 

                }
                break;
            case 8 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:52: T__34
                {
                mT__34(); 

                }
                break;
            case 9 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:58: T__35
                {
                mT__35(); 

                }
                break;
            case 10 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:64: T__36
                {
                mT__36(); 

                }
                break;
            case 11 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:70: T__37
                {
                mT__37(); 

                }
                break;
            case 12 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:76: T__38
                {
                mT__38(); 

                }
                break;
            case 13 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:82: T__39
                {
                mT__39(); 

                }
                break;
            case 14 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:88: T__40
                {
                mT__40(); 

                }
                break;
            case 15 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:94: SEMICOLON
                {
                mSEMICOLON(); 

                }
                break;
            case 16 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:104: COLON
                {
                mCOLON(); 

                }
                break;
            case 17 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:110: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 18 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:116: PERIOD
                {
                mPERIOD(); 

                }
                break;
            case 19 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:123: EQUALS
                {
                mEQUALS(); 

                }
                break;
            case 20 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:130: LEFTPAREN
                {
                mLEFTPAREN(); 

                }
                break;
            case 21 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:140: RIGHTPAREN
                {
                mRIGHTPAREN(); 

                }
                break;
            case 22 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:151: LEFTBRACKET
                {
                mLEFTBRACKET(); 

                }
                break;
            case 23 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:163: RIGHTBRACKET
                {
                mRIGHTBRACKET(); 

                }
                break;
            case 24 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:176: LEFTBRACE
                {
                mLEFTBRACE(); 

                }
                break;
            case 25 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:186: RIGHTBRACE
                {
                mRIGHTBRACE(); 

                }
                break;
            case 26 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:197: LEFTANGLE
                {
                mLEFTANGLE(); 

                }
                break;
            case 27 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:207: RIGHTANGLE
                {
                mRIGHTANGLE(); 

                }
                break;
            case 28 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:218: AMPERSAND
                {
                mAMPERSAND(); 

                }
                break;
            case 29 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:228: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 30 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:236: STRING
                {
                mSTRING(); 

                }
                break;
            case 31 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:243: IDENT
                {
                mIDENT(); 

                }
                break;
            case 32 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:249: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 33 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:260: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;
            case 34 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:273: MULTILINE_COMMENT
                {
                mMULTILINE_COMMENT(); 

                }
                break;
            case 35 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:291: INCLUDE
                {
                mINCLUDE(); 

                }
                break;

        }

    }


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\1\uffff\11\32\16\uffff\1\51\2\uffff\1\32\1\uffff\1\32\1\56\7\32"+
        "\1\70\2\32\1\uffff\1\32\1\uffff\2\32\1\uffff\3\32\1\111\2\32\1\114"+
        "\1\115\1\32\1\uffff\2\32\1\uffff\12\32\1\123\2\32\1\uffff\1\126"+
        "\1\127\2\uffff\1\32\1\131\1\132\2\32\1\uffff\1\32\1\136\2\uffff"+
        "\1\32\2\uffff\1\140\1\141\1\32\1\uffff\1\32\2\uffff\1\32\1\145\2"+
        "\uffff";
    static final String DFA9_eofS =
        "\146\uffff";
    static final String DFA9_minS =
        "\1\11\1\145\1\156\1\145\1\141\1\164\1\151\1\145\1\146\1\150\16\uffff"+
        "\1\44\2\uffff\1\52\1\uffff\1\163\1\44\1\143\1\147\1\144\1\143\1"+
        "\164\1\156\1\164\1\44\1\145\1\151\1\uffff\1\0\1\uffff\2\151\1\uffff"+
        "\1\164\1\154\1\151\1\44\1\150\1\162\2\44\1\141\1\uffff\1\156\1\163"+
        "\1\uffff\10\0\1\147\1\143\1\44\1\165\1\156\1\uffff\2\44\2\uffff"+
        "\1\164\2\44\1\156\1\145\1\uffff\1\144\1\44\2\uffff\1\164\2\uffff"+
        "\2\44\1\145\1\uffff\1\162\2\uffff\1\11\1\44\2\uffff";
    static final String DFA9_maxS =
        "\1\175\1\145\1\163\1\145\1\156\1\164\1\151\1\145\1\160\1\150\16"+
        "\uffff\1\172\2\uffff\1\57\1\uffff\1\166\1\172\1\163\1\147\1\144"+
        "\1\143\1\164\1\156\1\167\1\172\1\145\1\151\1\uffff\1\uffff\1\uffff"+
        "\2\151\1\uffff\1\164\1\154\1\151\1\172\1\150\1\162\2\172\1\141\1"+
        "\uffff\1\156\1\163\1\uffff\10\uffff\1\147\1\143\1\172\1\165\1\156"+
        "\1\uffff\2\172\2\uffff\1\164\2\172\1\156\1\145\1\uffff\1\144\1\172"+
        "\2\uffff\1\164\2\uffff\2\172\1\145\1\uffff\1\162\2\uffff\1\42\1"+
        "\172\2\uffff";
    static final String DFA9_acceptS =
        "\12\uffff\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31"+
        "\1\32\1\33\1\34\1\uffff\1\36\1\37\1\uffff\1\40\14\uffff\1\35\1\uffff"+
        "\1\42\2\uffff\1\2\11\uffff\1\12\2\uffff\1\41\15\uffff\1\4\2\uffff"+
        "\1\7\1\10\5\uffff\1\11\2\uffff\1\14\1\6\1\uffff\1\16\1\15\3\uffff"+
        "\1\3\1\uffff\1\1\1\5\2\uffff\1\43\1\13";
    static final String DFA9_specialS =
        "\52\uffff\1\10\21\uffff\1\5\1\6\1\1\1\0\1\3\1\2\1\4\1\7\42\uffff}>";
    static final String[] DFA9_transitionS = {
            "\2\34\1\uffff\2\34\17\uffff\1\34\2\uffff\1\34\1\uffff\1\31\1"+
            "\uffff\1\32\1\uffff\1\27\1\uffff\1\17\1\20\1\uffff\1\32\1\14"+
            "\1\32\1\15\1\33\12\30\1\13\1\12\1\25\1\16\1\26\2\uffff\32\32"+
            "\1\21\1\uffff\1\22\1\uffff\1\32\1\uffff\1\5\1\3\1\32\1\1\1\4"+
            "\3\32\1\2\4\32\1\7\1\10\1\6\3\32\1\11\6\32\1\23\1\uffff\1\24",
            "\1\35",
            "\1\37\4\uffff\1\36",
            "\1\40",
            "\1\42\14\uffff\1\41",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46\11\uffff\1\47",
            "\1\50",
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
            "\1\32\6\uffff\1\32\1\uffff\1\32\1\uffff\1\32\12\30\7\uffff"+
            "\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "",
            "\1\53\4\uffff\1\52",
            "",
            "\1\54\2\uffff\1\55",
            "\1\32\6\uffff\1\32\1\uffff\1\32\1\uffff\13\32\7\uffff\32\32"+
            "\4\uffff\1\32\1\uffff\32\32",
            "\1\60\17\uffff\1\57",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66\2\uffff\1\67",
            "\1\32\6\uffff\1\32\1\uffff\1\32\1\uffff\13\32\7\uffff\32\32"+
            "\4\uffff\1\32\1\uffff\32\32",
            "\1\71",
            "\1\72",
            "",
            "\44\73\1\101\6\73\1\77\1\73\1\100\1\73\1\102\12\103\7\73\32"+
            "\75\4\73\1\76\1\73\32\74\uff85\73",
            "",
            "\1\104",
            "\1\105",
            "",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\32\6\uffff\1\32\1\uffff\1\32\1\uffff\13\32\7\uffff\32\32"+
            "\4\uffff\1\32\1\uffff\32\32",
            "\1\112",
            "\1\113",
            "\1\32\6\uffff\1\32\1\uffff\1\32\1\uffff\13\32\7\uffff\32\32"+
            "\4\uffff\1\32\1\uffff\32\32",
            "\1\32\6\uffff\1\32\1\uffff\1\32\1\uffff\13\32\7\uffff\32\32"+
            "\4\uffff\1\32\1\uffff\32\32",
            "\1\116",
            "",
            "\1\117",
            "\1\120",
            "",
            "\44\73\1\101\6\73\1\77\1\73\1\100\1\73\1\102\12\103\7\73\32"+
            "\75\4\73\1\76\1\73\32\74\uff85\73",
            "\44\73\1\101\6\73\1\77\1\73\1\100\1\73\1\102\12\103\7\73\32"+
            "\75\4\73\1\76\1\73\32\74\uff85\73",
            "\44\73\1\101\6\73\1\77\1\73\1\100\1\73\1\102\12\103\7\73\32"+
            "\75\4\73\1\76\1\73\32\74\uff85\73",
            "\44\73\1\101\6\73\1\77\1\73\1\100\1\73\1\102\12\103\7\73\32"+
            "\75\4\73\1\76\1\73\32\74\uff85\73",
            "\44\73\1\101\6\73\1\77\1\73\1\100\1\73\1\102\12\103\7\73\32"+
            "\75\4\73\1\76\1\73\32\74\uff85\73",
            "\44\73\1\101\6\73\1\77\1\73\1\100\1\73\1\102\12\103\7\73\32"+
            "\75\4\73\1\76\1\73\32\74\uff85\73",
            "\44\73\1\101\6\73\1\77\1\73\1\100\1\73\1\102\12\103\7\73\32"+
            "\75\4\73\1\76\1\73\32\74\uff85\73",
            "\44\73\1\101\6\73\1\77\1\73\1\100\1\73\1\102\12\103\7\73\32"+
            "\75\4\73\1\76\1\73\32\74\uff85\73",
            "\1\121",
            "\1\122",
            "\1\32\6\uffff\1\32\1\uffff\1\32\1\uffff\13\32\7\uffff\32\32"+
            "\4\uffff\1\32\1\uffff\32\32",
            "\1\124",
            "\1\125",
            "",
            "\1\32\6\uffff\1\32\1\uffff\1\32\1\uffff\13\32\7\uffff\32\32"+
            "\4\uffff\1\32\1\uffff\32\32",
            "\1\32\6\uffff\1\32\1\uffff\1\32\1\uffff\13\32\7\uffff\32\32"+
            "\4\uffff\1\32\1\uffff\32\32",
            "",
            "",
            "\1\130",
            "\1\32\6\uffff\1\32\1\uffff\1\32\1\uffff\13\32\7\uffff\32\32"+
            "\4\uffff\1\32\1\uffff\32\32",
            "\1\32\6\uffff\1\32\1\uffff\1\32\1\uffff\13\32\7\uffff\32\32"+
            "\4\uffff\1\32\1\uffff\32\32",
            "\1\133",
            "\1\134",
            "",
            "\1\135",
            "\1\32\6\uffff\1\32\1\uffff\1\32\1\uffff\13\32\7\uffff\32\32"+
            "\4\uffff\1\32\1\uffff\32\32",
            "",
            "",
            "\1\137",
            "",
            "",
            "\1\32\6\uffff\1\32\1\uffff\1\32\1\uffff\13\32\7\uffff\32\32"+
            "\4\uffff\1\32\1\uffff\32\32",
            "\1\32\6\uffff\1\32\1\uffff\1\32\1\uffff\13\32\7\uffff\32\32"+
            "\4\uffff\1\32\1\uffff\32\32",
            "\1\142",
            "",
            "\1\143",
            "",
            "",
            "\2\144\1\uffff\2\144\17\uffff\1\144\2\uffff\1\144\1\uffff\1"+
            "\144",
            "\1\32\6\uffff\1\32\1\uffff\1\32\1\uffff\13\32\7\uffff\32\32"+
            "\4\uffff\1\32\1\uffff\32\32",
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
            return "1:1: Tokens : ( T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | SEMICOLON | COLON | COMMA | PERIOD | EQUALS | LEFTPAREN | RIGHTPAREN | LEFTBRACKET | RIGHTBRACKET | LEFTBRACE | RIGHTBRACE | LEFTANGLE | RIGHTANGLE | AMPERSAND | INTEGER | STRING | IDENT | WHITESPACE | LINE_COMMENT | MULTILINE_COMMENT | INCLUDE );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA9_63 = input.LA(1);

                        s = -1;
                        if ( ((LA9_63>='\u0000' && LA9_63<='#')||(LA9_63>='%' && LA9_63<='*')||LA9_63==','||LA9_63=='.'||(LA9_63>=':' && LA9_63<='@')||(LA9_63>='[' && LA9_63<='^')||LA9_63=='`'||(LA9_63>='{' && LA9_63<='\uFFFF')) ) {s = 59;}

                        else if ( ((LA9_63>='a' && LA9_63<='z')) ) {s = 60;}

                        else if ( ((LA9_63>='A' && LA9_63<='Z')) ) {s = 61;}

                        else if ( (LA9_63=='_') ) {s = 62;}

                        else if ( (LA9_63=='+') ) {s = 63;}

                        else if ( (LA9_63=='-') ) {s = 64;}

                        else if ( (LA9_63=='$') ) {s = 65;}

                        else if ( (LA9_63=='/') ) {s = 66;}

                        else if ( ((LA9_63>='0' && LA9_63<='9')) ) {s = 67;}

                        else s = 26;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA9_62 = input.LA(1);

                        s = -1;
                        if ( ((LA9_62>='\u0000' && LA9_62<='#')||(LA9_62>='%' && LA9_62<='*')||LA9_62==','||LA9_62=='.'||(LA9_62>=':' && LA9_62<='@')||(LA9_62>='[' && LA9_62<='^')||LA9_62=='`'||(LA9_62>='{' && LA9_62<='\uFFFF')) ) {s = 59;}

                        else if ( ((LA9_62>='a' && LA9_62<='z')) ) {s = 60;}

                        else if ( ((LA9_62>='A' && LA9_62<='Z')) ) {s = 61;}

                        else if ( (LA9_62=='_') ) {s = 62;}

                        else if ( (LA9_62=='+') ) {s = 63;}

                        else if ( (LA9_62=='-') ) {s = 64;}

                        else if ( (LA9_62=='$') ) {s = 65;}

                        else if ( (LA9_62=='/') ) {s = 66;}

                        else if ( ((LA9_62>='0' && LA9_62<='9')) ) {s = 67;}

                        else s = 26;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA9_65 = input.LA(1);

                        s = -1;
                        if ( ((LA9_65>='\u0000' && LA9_65<='#')||(LA9_65>='%' && LA9_65<='*')||LA9_65==','||LA9_65=='.'||(LA9_65>=':' && LA9_65<='@')||(LA9_65>='[' && LA9_65<='^')||LA9_65=='`'||(LA9_65>='{' && LA9_65<='\uFFFF')) ) {s = 59;}

                        else if ( ((LA9_65>='a' && LA9_65<='z')) ) {s = 60;}

                        else if ( ((LA9_65>='A' && LA9_65<='Z')) ) {s = 61;}

                        else if ( (LA9_65=='_') ) {s = 62;}

                        else if ( (LA9_65=='+') ) {s = 63;}

                        else if ( (LA9_65=='-') ) {s = 64;}

                        else if ( (LA9_65=='$') ) {s = 65;}

                        else if ( (LA9_65=='/') ) {s = 66;}

                        else if ( ((LA9_65>='0' && LA9_65<='9')) ) {s = 67;}

                        else s = 26;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA9_64 = input.LA(1);

                        s = -1;
                        if ( ((LA9_64>='\u0000' && LA9_64<='#')||(LA9_64>='%' && LA9_64<='*')||LA9_64==','||LA9_64=='.'||(LA9_64>=':' && LA9_64<='@')||(LA9_64>='[' && LA9_64<='^')||LA9_64=='`'||(LA9_64>='{' && LA9_64<='\uFFFF')) ) {s = 59;}

                        else if ( ((LA9_64>='a' && LA9_64<='z')) ) {s = 60;}

                        else if ( ((LA9_64>='A' && LA9_64<='Z')) ) {s = 61;}

                        else if ( (LA9_64=='_') ) {s = 62;}

                        else if ( (LA9_64=='+') ) {s = 63;}

                        else if ( (LA9_64=='-') ) {s = 64;}

                        else if ( (LA9_64=='$') ) {s = 65;}

                        else if ( (LA9_64=='/') ) {s = 66;}

                        else if ( ((LA9_64>='0' && LA9_64<='9')) ) {s = 67;}

                        else s = 26;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA9_66 = input.LA(1);

                        s = -1;
                        if ( ((LA9_66>='\u0000' && LA9_66<='#')||(LA9_66>='%' && LA9_66<='*')||LA9_66==','||LA9_66=='.'||(LA9_66>=':' && LA9_66<='@')||(LA9_66>='[' && LA9_66<='^')||LA9_66=='`'||(LA9_66>='{' && LA9_66<='\uFFFF')) ) {s = 59;}

                        else if ( ((LA9_66>='a' && LA9_66<='z')) ) {s = 60;}

                        else if ( ((LA9_66>='A' && LA9_66<='Z')) ) {s = 61;}

                        else if ( (LA9_66=='_') ) {s = 62;}

                        else if ( (LA9_66=='+') ) {s = 63;}

                        else if ( (LA9_66=='-') ) {s = 64;}

                        else if ( (LA9_66=='$') ) {s = 65;}

                        else if ( (LA9_66=='/') ) {s = 66;}

                        else if ( ((LA9_66>='0' && LA9_66<='9')) ) {s = 67;}

                        else s = 26;

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA9_60 = input.LA(1);

                        s = -1;
                        if ( ((LA9_60>='\u0000' && LA9_60<='#')||(LA9_60>='%' && LA9_60<='*')||LA9_60==','||LA9_60=='.'||(LA9_60>=':' && LA9_60<='@')||(LA9_60>='[' && LA9_60<='^')||LA9_60=='`'||(LA9_60>='{' && LA9_60<='\uFFFF')) ) {s = 59;}

                        else if ( ((LA9_60>='a' && LA9_60<='z')) ) {s = 60;}

                        else if ( ((LA9_60>='A' && LA9_60<='Z')) ) {s = 61;}

                        else if ( (LA9_60=='_') ) {s = 62;}

                        else if ( (LA9_60=='+') ) {s = 63;}

                        else if ( (LA9_60=='-') ) {s = 64;}

                        else if ( (LA9_60=='$') ) {s = 65;}

                        else if ( (LA9_60=='/') ) {s = 66;}

                        else if ( ((LA9_60>='0' && LA9_60<='9')) ) {s = 67;}

                        else s = 26;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA9_61 = input.LA(1);

                        s = -1;
                        if ( ((LA9_61>='\u0000' && LA9_61<='#')||(LA9_61>='%' && LA9_61<='*')||LA9_61==','||LA9_61=='.'||(LA9_61>=':' && LA9_61<='@')||(LA9_61>='[' && LA9_61<='^')||LA9_61=='`'||(LA9_61>='{' && LA9_61<='\uFFFF')) ) {s = 59;}

                        else if ( ((LA9_61>='a' && LA9_61<='z')) ) {s = 60;}

                        else if ( ((LA9_61>='A' && LA9_61<='Z')) ) {s = 61;}

                        else if ( (LA9_61=='_') ) {s = 62;}

                        else if ( (LA9_61=='+') ) {s = 63;}

                        else if ( (LA9_61=='-') ) {s = 64;}

                        else if ( (LA9_61=='$') ) {s = 65;}

                        else if ( (LA9_61=='/') ) {s = 66;}

                        else if ( ((LA9_61>='0' && LA9_61<='9')) ) {s = 67;}

                        else s = 26;

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA9_67 = input.LA(1);

                        s = -1;
                        if ( ((LA9_67>='\u0000' && LA9_67<='#')||(LA9_67>='%' && LA9_67<='*')||LA9_67==','||LA9_67=='.'||(LA9_67>=':' && LA9_67<='@')||(LA9_67>='[' && LA9_67<='^')||LA9_67=='`'||(LA9_67>='{' && LA9_67<='\uFFFF')) ) {s = 59;}

                        else if ( ((LA9_67>='a' && LA9_67<='z')) ) {s = 60;}

                        else if ( ((LA9_67>='A' && LA9_67<='Z')) ) {s = 61;}

                        else if ( (LA9_67=='_') ) {s = 62;}

                        else if ( (LA9_67=='+') ) {s = 63;}

                        else if ( (LA9_67=='-') ) {s = 64;}

                        else if ( (LA9_67=='$') ) {s = 65;}

                        else if ( (LA9_67=='/') ) {s = 66;}

                        else if ( ((LA9_67>='0' && LA9_67<='9')) ) {s = 67;}

                        else s = 26;

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA9_42 = input.LA(1);

                        s = -1;
                        if ( ((LA9_42>='\u0000' && LA9_42<='#')||(LA9_42>='%' && LA9_42<='*')||LA9_42==','||LA9_42=='.'||(LA9_42>=':' && LA9_42<='@')||(LA9_42>='[' && LA9_42<='^')||LA9_42=='`'||(LA9_42>='{' && LA9_42<='\uFFFF')) ) {s = 59;}

                        else if ( ((LA9_42>='a' && LA9_42<='z')) ) {s = 60;}

                        else if ( ((LA9_42>='A' && LA9_42<='Z')) ) {s = 61;}

                        else if ( (LA9_42=='_') ) {s = 62;}

                        else if ( (LA9_42=='+') ) {s = 63;}

                        else if ( (LA9_42=='-') ) {s = 64;}

                        else if ( (LA9_42=='$') ) {s = 65;}

                        else if ( (LA9_42=='/') ) {s = 66;}

                        else if ( ((LA9_42>='0' && LA9_42<='9')) ) {s = 67;}

                        else s = 26;

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