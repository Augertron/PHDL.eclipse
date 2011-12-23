// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g 2011-12-23 16:28:52

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

public class Phdl2Lexer extends Lexer {
    public static final int EOF=-1;
    public static final int SEMICOLON=4;
    public static final int COLON=5;
    public static final int COMMA=6;
    public static final int PERIOD=7;
    public static final int EQUALS=8;
    public static final int LPAREN=9;
    public static final int RPAREN=10;
    public static final int LBRACKET=11;
    public static final int RBRACKET=12;
    public static final int LBRACE=13;
    public static final int RBRACE=14;
    public static final int LANGLE=15;
    public static final int RANGLE=16;
    public static final int AMPERSAND=17;
    public static final int DBLQUOTE=18;
    public static final int DESIGN=19;
    public static final int DEVICE=20;
    public static final int SUBDESIGN=21;
    public static final int INST=22;
    public static final int SUBINST=23;
    public static final int GROUP=24;
    public static final int THIS=25;
    public static final int OF=26;
    public static final int NET=27;
    public static final int ATTR=28;
    public static final int NEWATTR=29;
    public static final int BEGIN=30;
    public static final int END=31;
    public static final int COMBINE=32;
    public static final int INCLUDE=33;
    public static final int PIN=34;
    public static final int INPIN=35;
    public static final int OUTPIN=36;
    public static final int IOPIN=37;
    public static final int PWRPIN=38;
    public static final int SUPPIN=39;
    public static final int WIDTH_DECL=40;
    public static final int DEVICE_DECL=41;
    public static final int ATTR_DECL=42;
    public static final int PIN_DECL=43;
    public static final int PIN_LIST=44;
    public static final int PIN_TYPE=45;
    public static final int IDENT=46;
    public static final int STRING=47;
    public static final int INT=48;
    public static final int D=49;
    public static final int E=50;
    public static final int S=51;
    public static final int I=52;
    public static final int G=53;
    public static final int N=54;
    public static final int V=55;
    public static final int C=56;
    public static final int U=57;
    public static final int B=58;
    public static final int T=59;
    public static final int R=60;
    public static final int O=61;
    public static final int P=62;
    public static final int H=63;
    public static final int F=64;
    public static final int A=65;
    public static final int W=66;
    public static final int M=67;
    public static final int L=68;
    public static final int DIGIT=69;
    public static final int CHAR=70;
    public static final int WHITESPACE=71;
    public static final int LINE_COMMENT=72;
    public static final int MULTILINE_COMMENT=73;
    public static final int INCLUDE_DECL=74;
    public static final int J=75;
    public static final int K=76;
    public static final int Q=77;
    public static final int X=78;
    public static final int Y=79;
    public static final int Z=80;


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

    public Phdl2Lexer() {;} 
    public Phdl2Lexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public Phdl2Lexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g"; }

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:79:11: ( ';' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:79:13: ';'
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:80:7: ( ':' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:80:9: ':'
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:81:7: ( ',' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:81:9: ','
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:82:8: ( '.' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:82:10: '.'
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:83:8: ( '=' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:83:10: '='
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

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:84:8: ( '(' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:84:10: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:85:8: ( ')' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:85:10: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "LBRACKET"
    public final void mLBRACKET() throws RecognitionException {
        try {
            int _type = LBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:86:10: ( '[' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:86:12: '['
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:87:10: ( ']' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:87:12: ']'
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

    // $ANTLR start "LBRACE"
    public final void mLBRACE() throws RecognitionException {
        try {
            int _type = LBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:88:8: ( '{' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:88:10: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LBRACE"

    // $ANTLR start "RBRACE"
    public final void mRBRACE() throws RecognitionException {
        try {
            int _type = RBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:89:8: ( '}' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:89:10: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RBRACE"

    // $ANTLR start "LANGLE"
    public final void mLANGLE() throws RecognitionException {
        try {
            int _type = LANGLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:90:8: ( '<' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:90:10: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LANGLE"

    // $ANTLR start "RANGLE"
    public final void mRANGLE() throws RecognitionException {
        try {
            int _type = RANGLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:91:8: ( '>' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:91:10: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RANGLE"

    // $ANTLR start "AMPERSAND"
    public final void mAMPERSAND() throws RecognitionException {
        try {
            int _type = AMPERSAND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:92:11: ( '&' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:92:13: '&'
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

    // $ANTLR start "DBLQUOTE"
    public final void mDBLQUOTE() throws RecognitionException {
        try {
            int _type = DBLQUOTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:93:10: ( '\"' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:93:12: '\"'
            {
            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DBLQUOTE"

    // $ANTLR start "DESIGN"
    public final void mDESIGN() throws RecognitionException {
        try {
            int _type = DESIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:249:7: ( D E S I G N )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:249:9: D E S I G N
            {
            mD(); 
            mE(); 
            mS(); 
            mI(); 
            mG(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DESIGN"

    // $ANTLR start "DEVICE"
    public final void mDEVICE() throws RecognitionException {
        try {
            int _type = DEVICE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:250:7: ( D E V I C E )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:250:9: D E V I C E
            {
            mD(); 
            mE(); 
            mV(); 
            mI(); 
            mC(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEVICE"

    // $ANTLR start "SUBDESIGN"
    public final void mSUBDESIGN() throws RecognitionException {
        try {
            int _type = SUBDESIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:251:10: ( S U B D E S I G N )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:251:12: S U B D E S I G N
            {
            mS(); 
            mU(); 
            mB(); 
            mD(); 
            mE(); 
            mS(); 
            mI(); 
            mG(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUBDESIGN"

    // $ANTLR start "INST"
    public final void mINST() throws RecognitionException {
        try {
            int _type = INST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:252:5: ( I N S T )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:252:7: I N S T
            {
            mI(); 
            mN(); 
            mS(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INST"

    // $ANTLR start "SUBINST"
    public final void mSUBINST() throws RecognitionException {
        try {
            int _type = SUBINST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:253:8: ( S U B I N S T )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:253:10: S U B I N S T
            {
            mS(); 
            mU(); 
            mB(); 
            mI(); 
            mN(); 
            mS(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUBINST"

    // $ANTLR start "GROUP"
    public final void mGROUP() throws RecognitionException {
        try {
            int _type = GROUP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:254:6: ( G R O U P )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:254:8: G R O U P
            {
            mG(); 
            mR(); 
            mO(); 
            mU(); 
            mP(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GROUP"

    // $ANTLR start "THIS"
    public final void mTHIS() throws RecognitionException {
        try {
            int _type = THIS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:255:5: ( T H I S )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:255:7: T H I S
            {
            mT(); 
            mH(); 
            mI(); 
            mS(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "THIS"

    // $ANTLR start "OF"
    public final void mOF() throws RecognitionException {
        try {
            int _type = OF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:256:3: ( O F )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:256:5: O F
            {
            mO(); 
            mF(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OF"

    // $ANTLR start "NET"
    public final void mNET() throws RecognitionException {
        try {
            int _type = NET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:257:4: ( N E T )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:257:6: N E T
            {
            mN(); 
            mE(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NET"

    // $ANTLR start "ATTR"
    public final void mATTR() throws RecognitionException {
        try {
            int _type = ATTR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:258:5: ( A T T R )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:258:7: A T T R
            {
            mA(); 
            mT(); 
            mT(); 
            mR(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ATTR"

    // $ANTLR start "NEWATTR"
    public final void mNEWATTR() throws RecognitionException {
        try {
            int _type = NEWATTR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:259:8: ( N E W A T T R )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:259:10: N E W A T T R
            {
            mN(); 
            mE(); 
            mW(); 
            mA(); 
            mT(); 
            mT(); 
            mR(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEWATTR"

    // $ANTLR start "BEGIN"
    public final void mBEGIN() throws RecognitionException {
        try {
            int _type = BEGIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:260:6: ( B E G I N )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:260:8: B E G I N
            {
            mB(); 
            mE(); 
            mG(); 
            mI(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BEGIN"

    // $ANTLR start "END"
    public final void mEND() throws RecognitionException {
        try {
            int _type = END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:261:4: ( E N D )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:261:6: E N D
            {
            mE(); 
            mN(); 
            mD(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "END"

    // $ANTLR start "COMBINE"
    public final void mCOMBINE() throws RecognitionException {
        try {
            int _type = COMBINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:262:8: ( C O M B I N E )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:262:10: C O M B I N E
            {
            mC(); 
            mO(); 
            mM(); 
            mB(); 
            mI(); 
            mN(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMBINE"

    // $ANTLR start "INCLUDE"
    public final void mINCLUDE() throws RecognitionException {
        try {
            int _type = INCLUDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:263:8: ( I N C L U D E )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:263:10: I N C L U D E
            {
            mI(); 
            mN(); 
            mC(); 
            mL(); 
            mU(); 
            mD(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INCLUDE"

    // $ANTLR start "PIN"
    public final void mPIN() throws RecognitionException {
        try {
            int _type = PIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:266:4: ( P I N )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:266:6: P I N
            {
            mP(); 
            mI(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PIN"

    // $ANTLR start "INPIN"
    public final void mINPIN() throws RecognitionException {
        try {
            int _type = INPIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:267:6: ( I N P I N )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:267:8: I N P I N
            {
            mI(); 
            mN(); 
            mP(); 
            mI(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INPIN"

    // $ANTLR start "OUTPIN"
    public final void mOUTPIN() throws RecognitionException {
        try {
            int _type = OUTPIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:268:7: ( O U T P I N )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:268:9: O U T P I N
            {
            mO(); 
            mU(); 
            mT(); 
            mP(); 
            mI(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OUTPIN"

    // $ANTLR start "IOPIN"
    public final void mIOPIN() throws RecognitionException {
        try {
            int _type = IOPIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:269:6: ( I O P I N )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:269:8: I O P I N
            {
            mI(); 
            mO(); 
            mP(); 
            mI(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IOPIN"

    // $ANTLR start "PWRPIN"
    public final void mPWRPIN() throws RecognitionException {
        try {
            int _type = PWRPIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:270:7: ( P W R P I N )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:270:9: P W R P I N
            {
            mP(); 
            mW(); 
            mR(); 
            mP(); 
            mI(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PWRPIN"

    // $ANTLR start "SUPPIN"
    public final void mSUPPIN() throws RecognitionException {
        try {
            int _type = SUPPIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:271:7: ( S U P P I N )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:271:9: S U P P I N
            {
            mS(); 
            mU(); 
            mP(); 
            mP(); 
            mI(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUPPIN"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:273:16: ( ( '0' .. '9' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:273:18: ( '0' .. '9' )
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:273:18: ( '0' .. '9' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:273:19: '0' .. '9'
            {
            matchRange('0','9'); 

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:274:15: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | ( '0' .. '9' ) | '_' | '+' | '-' | '$' | '/' )
            int alt1=8;
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
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                {
                alt1=3;
                }
                break;
            case '_':
                {
                alt1=4;
                }
                break;
            case '+':
                {
                alt1=5;
                }
                break;
            case '-':
                {
                alt1=6;
                }
                break;
            case '$':
                {
                alt1=7;
                }
                break;
            case '/':
                {
                alt1=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:274:17: ( 'a' .. 'z' )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:274:17: ( 'a' .. 'z' )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:274:18: 'a' .. 'z'
                    {
                    matchRange('a','z'); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:274:30: ( 'A' .. 'Z' )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:274:30: ( 'A' .. 'Z' )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:274:31: 'A' .. 'Z'
                    {
                    matchRange('A','Z'); 

                    }


                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:274:43: ( '0' .. '9' )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:274:43: ( '0' .. '9' )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:274:44: '0' .. '9'
                    {
                    matchRange('0','9'); 

                    }


                    }
                    break;
                case 4 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:274:56: '_'
                    {
                    match('_'); 

                    }
                    break;
                case 5 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:274:62: '+'
                    {
                    match('+'); 

                    }
                    break;
                case 6 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:274:68: '-'
                    {
                    match('-'); 

                    }
                    break;
                case 7 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:274:74: '$'
                    {
                    match('$'); 

                    }
                    break;
                case 8 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:274:80: '/'
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

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:276:4: ( ( DIGIT )+ )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:276:6: ( DIGIT )+
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:276:6: ( DIGIT )+
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:276:6: DIGIT
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

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:277:6: ( ( CHAR )+ )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:277:8: ( CHAR )+
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:277:8: ( CHAR )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='$'||LA3_0=='+'||LA3_0=='-'||(LA3_0>='/' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:277:8: CHAR
            	    {
            	    mCHAR(); 

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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            int c;

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:283:2: ( DBLQUOTE ( '/' DBLQUOTE | c=~ ( DBLQUOTE ) )* DBLQUOTE )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:283:5: DBLQUOTE ( '/' DBLQUOTE | c=~ ( DBLQUOTE ) )* DBLQUOTE
            {
            mDBLQUOTE(); 
            StringBuilder sb = new StringBuilder();
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:284:3: ( '/' DBLQUOTE | c=~ ( DBLQUOTE ) )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='/') ) {
                    int LA4_2 = input.LA(2);

                    if ( (LA4_2=='\"') ) {
                        int LA4_4 = input.LA(3);

                        if ( ((LA4_4>='\u0000' && LA4_4<='\uFFFF')) ) {
                            alt4=1;
                        }

                        else {
                            alt4=2;
                        }

                    }
                    else if ( ((LA4_2>='\u0000' && LA4_2<='!')||(LA4_2>='#' && LA4_2<='\uFFFF')) ) {
                        alt4=2;
                    }


                }
                else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='.')||(LA4_0>='0' && LA4_0<='\uFFFF')) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:284:5: '/' DBLQUOTE
            	    {
            	    match('/'); 
            	    mDBLQUOTE(); 
            	    sb.appendCodePoint('"');

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:285:5: c=~ ( DBLQUOTE )
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
            	    break loop4;
                }
            } while (true);

            mDBLQUOTE(); 
            setText(sb.toString());

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:300:2: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' | '\\u001D' )+ )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:300:4: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' | '\\u001D' )+
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:300:4: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' | '\\u001D' )+
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:308:2: ( '//' ( . )* ( '\\n' | '\\r' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:308:4: '//' ( . )* ( '\\n' | '\\r' )
            {
            match("//"); 

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:308:9: ( . )*
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:308:9: .
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:316:2: ( '/*' ( . )* '*/' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:316:4: '/*' ( . )* '*/'
            {
            match("/*"); 

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:316:9: ( . )*
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:316:9: .
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

    // $ANTLR start "INCLUDE_DECL"
    public final void mINCLUDE_DECL() throws RecognitionException {
        try {
            int _type = INCLUDE_DECL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken fileName=null;

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:326:2: ( INCLUDE ( WHITESPACE )? fileName= STRING ';' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:326:5: INCLUDE ( WHITESPACE )? fileName= STRING ';'
            {
            mINCLUDE(); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:326:13: ( WHITESPACE )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>='\t' && LA8_0<='\n')||(LA8_0>='\f' && LA8_0<='\r')||LA8_0=='\u001D'||LA8_0==' ') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:326:14: WHITESPACE
                    {
                    mWHITESPACE(); 

                    }
                    break;

            }

            int fileNameStart747 = getCharIndex();
            int fileNameStartLine747 = getLine();
            int fileNameStartCharPos747 = getCharPositionInLine();
            mSTRING(); 
            fileName = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, fileNameStart747, getCharIndex()-1);
            fileName.setLine(fileNameStartLine747);
            fileName.setCharPositionInLine(fileNameStartCharPos747);
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
    // $ANTLR end "INCLUDE_DECL"

    // $ANTLR start "A"
    public final void mA() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:350:11: ( ( 'a' | 'A' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:350:12: ( 'a' | 'A' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "A"

    // $ANTLR start "B"
    public final void mB() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:351:11: ( ( 'b' | 'B' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:351:12: ( 'b' | 'B' )
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "B"

    // $ANTLR start "C"
    public final void mC() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:352:11: ( ( 'c' | 'C' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:352:12: ( 'c' | 'C' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "C"

    // $ANTLR start "D"
    public final void mD() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:353:11: ( ( 'd' | 'D' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:353:12: ( 'd' | 'D' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "D"

    // $ANTLR start "E"
    public final void mE() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:354:11: ( ( 'e' | 'E' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:354:12: ( 'e' | 'E' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "E"

    // $ANTLR start "F"
    public final void mF() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:355:11: ( ( 'f' | 'F' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:355:12: ( 'f' | 'F' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "F"

    // $ANTLR start "G"
    public final void mG() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:356:11: ( ( 'g' | 'G' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:356:12: ( 'g' | 'G' )
            {
            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "G"

    // $ANTLR start "H"
    public final void mH() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:357:11: ( ( 'h' | 'H' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:357:12: ( 'h' | 'H' )
            {
            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "H"

    // $ANTLR start "I"
    public final void mI() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:358:11: ( ( 'i' | 'I' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:358:12: ( 'i' | 'I' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "I"

    // $ANTLR start "J"
    public final void mJ() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:359:11: ( ( 'j' | 'J' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:359:12: ( 'j' | 'J' )
            {
            if ( input.LA(1)=='J'||input.LA(1)=='j' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "J"

    // $ANTLR start "K"
    public final void mK() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:360:11: ( ( 'k' | 'K' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:360:12: ( 'k' | 'K' )
            {
            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "K"

    // $ANTLR start "L"
    public final void mL() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:361:11: ( ( 'l' | 'L' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:361:12: ( 'l' | 'L' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "L"

    // $ANTLR start "M"
    public final void mM() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:362:11: ( ( 'm' | 'M' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:362:12: ( 'm' | 'M' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "M"

    // $ANTLR start "N"
    public final void mN() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:363:11: ( ( 'n' | 'N' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:363:12: ( 'n' | 'N' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "N"

    // $ANTLR start "O"
    public final void mO() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:364:11: ( ( 'o' | 'O' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:364:12: ( 'o' | 'O' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "O"

    // $ANTLR start "P"
    public final void mP() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:365:11: ( ( 'p' | 'P' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:365:12: ( 'p' | 'P' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "P"

    // $ANTLR start "Q"
    public final void mQ() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:366:11: ( ( 'q' | 'Q' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:366:12: ( 'q' | 'Q' )
            {
            if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Q"

    // $ANTLR start "R"
    public final void mR() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:367:11: ( ( 'r' | 'R' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:367:12: ( 'r' | 'R' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "R"

    // $ANTLR start "S"
    public final void mS() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:368:11: ( ( 's' | 'S' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:368:12: ( 's' | 'S' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "S"

    // $ANTLR start "T"
    public final void mT() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:369:11: ( ( 't' | 'T' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:369:12: ( 't' | 'T' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "T"

    // $ANTLR start "U"
    public final void mU() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:370:11: ( ( 'u' | 'U' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:370:12: ( 'u' | 'U' )
            {
            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "U"

    // $ANTLR start "V"
    public final void mV() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:371:11: ( ( 'v' | 'V' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:371:12: ( 'v' | 'V' )
            {
            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "V"

    // $ANTLR start "W"
    public final void mW() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:372:11: ( ( 'w' | 'W' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:372:12: ( 'w' | 'W' )
            {
            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "W"

    // $ANTLR start "X"
    public final void mX() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:373:11: ( ( 'x' | 'X' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:373:12: ( 'x' | 'X' )
            {
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "X"

    // $ANTLR start "Y"
    public final void mY() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:374:11: ( ( 'y' | 'Y' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:374:12: ( 'y' | 'Y' )
            {
            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Y"

    // $ANTLR start "Z"
    public final void mZ() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:375:11: ( ( 'z' | 'Z' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:375:12: ( 'z' | 'Z' )
            {
            if ( input.LA(1)=='Z'||input.LA(1)=='z' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Z"

    public void mTokens() throws RecognitionException {
        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:8: ( SEMICOLON | COLON | COMMA | PERIOD | EQUALS | LPAREN | RPAREN | LBRACKET | RBRACKET | LBRACE | RBRACE | LANGLE | RANGLE | AMPERSAND | DBLQUOTE | DESIGN | DEVICE | SUBDESIGN | INST | SUBINST | GROUP | THIS | OF | NET | ATTR | NEWATTR | BEGIN | END | COMBINE | INCLUDE | PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN | INT | IDENT | STRING | WHITESPACE | LINE_COMMENT | MULTILINE_COMMENT | INCLUDE_DECL )
        int alt9=43;
        alt9 = dfa9.predict(input);
        switch (alt9) {
            case 1 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:10: SEMICOLON
                {
                mSEMICOLON(); 

                }
                break;
            case 2 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:20: COLON
                {
                mCOLON(); 

                }
                break;
            case 3 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:26: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 4 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:32: PERIOD
                {
                mPERIOD(); 

                }
                break;
            case 5 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:39: EQUALS
                {
                mEQUALS(); 

                }
                break;
            case 6 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:46: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 7 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:53: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 8 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:60: LBRACKET
                {
                mLBRACKET(); 

                }
                break;
            case 9 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:69: RBRACKET
                {
                mRBRACKET(); 

                }
                break;
            case 10 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:78: LBRACE
                {
                mLBRACE(); 

                }
                break;
            case 11 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:85: RBRACE
                {
                mRBRACE(); 

                }
                break;
            case 12 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:92: LANGLE
                {
                mLANGLE(); 

                }
                break;
            case 13 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:99: RANGLE
                {
                mRANGLE(); 

                }
                break;
            case 14 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:106: AMPERSAND
                {
                mAMPERSAND(); 

                }
                break;
            case 15 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:116: DBLQUOTE
                {
                mDBLQUOTE(); 

                }
                break;
            case 16 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:125: DESIGN
                {
                mDESIGN(); 

                }
                break;
            case 17 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:132: DEVICE
                {
                mDEVICE(); 

                }
                break;
            case 18 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:139: SUBDESIGN
                {
                mSUBDESIGN(); 

                }
                break;
            case 19 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:149: INST
                {
                mINST(); 

                }
                break;
            case 20 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:154: SUBINST
                {
                mSUBINST(); 

                }
                break;
            case 21 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:162: GROUP
                {
                mGROUP(); 

                }
                break;
            case 22 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:168: THIS
                {
                mTHIS(); 

                }
                break;
            case 23 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:173: OF
                {
                mOF(); 

                }
                break;
            case 24 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:176: NET
                {
                mNET(); 

                }
                break;
            case 25 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:180: ATTR
                {
                mATTR(); 

                }
                break;
            case 26 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:185: NEWATTR
                {
                mNEWATTR(); 

                }
                break;
            case 27 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:193: BEGIN
                {
                mBEGIN(); 

                }
                break;
            case 28 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:199: END
                {
                mEND(); 

                }
                break;
            case 29 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:203: COMBINE
                {
                mCOMBINE(); 

                }
                break;
            case 30 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:211: INCLUDE
                {
                mINCLUDE(); 

                }
                break;
            case 31 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:219: PIN
                {
                mPIN(); 

                }
                break;
            case 32 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:223: INPIN
                {
                mINPIN(); 

                }
                break;
            case 33 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:229: OUTPIN
                {
                mOUTPIN(); 

                }
                break;
            case 34 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:236: IOPIN
                {
                mIOPIN(); 

                }
                break;
            case 35 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:242: PWRPIN
                {
                mPWRPIN(); 

                }
                break;
            case 36 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:249: SUPPIN
                {
                mSUPPIN(); 

                }
                break;
            case 37 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:256: INT
                {
                mINT(); 

                }
                break;
            case 38 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:260: IDENT
                {
                mIDENT(); 

                }
                break;
            case 39 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:266: STRING
                {
                mSTRING(); 

                }
                break;
            case 40 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:273: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 41 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:284: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;
            case 42 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:297: MULTILINE_COMMENT
                {
                mMULTILINE_COMMENT(); 

                }
                break;
            case 43 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl2.g:1:315: INCLUDE_DECL
                {
                mINCLUDE_DECL(); 

                }
                break;

        }

    }


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\17\uffff\1\54\14\51\1\114\14\51\1\uffff\1\51\3\uffff\14\51\1\143"+
        "\1\51\1\143\17\51\1\uffff\1\51\1\uffff\24\51\1\uffff\2\51\1\u0097"+
        "\1\51\1\u0097\5\51\2\u009e\2\51\2\u00a1\2\51\1\uffff\22\51\2\u00ae"+
        "\10\51\2\u00b7\2\51\1\uffff\2\51\2\u00bc\2\51\1\uffff\2\51\1\uffff"+
        "\14\51\1\uffff\2\51\2\u00cf\2\u00d0\2\u00d1\1\uffff\4\51\1\uffff"+
        "\2\u00d6\4\51\2\u00db\2\u00dc\4\51\2\u00e1\2\51\3\uffff\2\u00e4"+
        "\2\51\1\uffff\2\51\2\u00e9\2\uffff\2\51\2\u00ec\1\uffff\2\u00ed"+
        "\1\uffff\2\u00ef\2\u00f0\1\uffff\2\51\5\uffff\2\u00f3\1\uffff";
    static final String DFA9_eofS =
        "\u00f4\uffff";
    static final String DFA9_minS =
        "\1\11\16\uffff\1\0\1\105\1\125\1\116\1\122\1\110\1\106\1\105\1"+
        "\124\1\105\1\116\1\117\1\111\1\44\1\105\1\125\1\116\1\122\1\110"+
        "\1\106\1\105\1\124\1\105\1\116\1\117\1\111\1\uffff\1\52\3\uffff"+
        "\2\123\2\102\1\103\1\120\1\103\1\120\2\117\2\111\1\44\1\124\1\44"+
        "\5\124\2\107\2\104\2\115\1\116\1\122\1\116\1\122\1\uffff\1\0\1\uffff"+
        "\4\111\1\104\1\120\1\104\1\120\1\124\1\114\1\111\1\124\1\114\3\111"+
        "\2\125\2\123\1\uffff\2\120\1\44\1\101\1\44\1\101\2\122\2\111\2\44"+
        "\2\102\2\44\2\120\1\uffff\10\0\2\107\2\103\1\105\1\116\1\105\1\116"+
        "\2\111\2\44\2\125\4\116\2\120\2\44\2\111\1\uffff\2\124\2\44\2\116"+
        "\1\uffff\2\111\1\uffff\2\111\2\116\2\105\4\123\2\116\1\uffff\2\104"+
        "\6\44\1\uffff\2\116\2\124\1\uffff\2\44\4\116\4\44\2\111\2\124\2"+
        "\44\2\105\3\uffff\2\44\2\122\1\uffff\2\105\2\44\2\uffff\2\107\2"+
        "\44\1\uffff\2\11\1\uffff\4\44\1\uffff\2\116\5\uffff\2\44\1\uffff";
    static final String DFA9_maxS =
        "\1\175\16\uffff\1\uffff\1\145\1\165\1\157\1\162\1\150\1\165\1\145"+
        "\1\164\1\145\1\156\1\157\1\167\1\172\1\145\1\165\1\157\1\162\1\150"+
        "\1\165\1\145\1\164\1\145\1\156\1\157\1\167\1\uffff\1\57\3\uffff"+
        "\2\166\2\160\1\163\1\160\1\163\1\160\2\157\2\151\1\172\1\164\1\172"+
        "\1\164\2\167\2\164\2\147\2\144\2\155\1\156\1\162\1\156\1\162\1\uffff"+
        "\1\uffff\1\uffff\5\151\1\160\1\151\1\160\1\164\1\154\1\151\1\164"+
        "\1\154\3\151\2\165\2\163\1\uffff\2\160\1\172\1\141\1\172\1\141\2"+
        "\162\2\151\2\172\2\142\2\172\2\160\1\uffff\10\uffff\2\147\2\143"+
        "\1\145\1\156\1\145\1\156\2\151\2\172\2\165\4\156\2\160\2\172\2\151"+
        "\1\uffff\2\164\2\172\2\156\1\uffff\2\151\1\uffff\2\151\2\156\2\145"+
        "\4\163\2\156\1\uffff\2\144\6\172\1\uffff\2\156\2\164\1\uffff\2\172"+
        "\4\156\4\172\2\151\2\164\2\172\2\145\3\uffff\2\172\2\162\1\uffff"+
        "\2\145\2\172\2\uffff\2\147\2\172\1\uffff\2\172\1\uffff\4\172\1\uffff"+
        "\2\156\5\uffff\2\172\1\uffff";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1"+
        "\15\1\16\32\uffff\1\46\1\uffff\1\50\1\17\1\47\36\uffff\1\45\1\uffff"+
        "\1\52\24\uffff\1\27\22\uffff\1\51\40\uffff\1\30\6\uffff\1\34\2\uffff"+
        "\1\37\14\uffff\1\23\10\uffff\1\26\4\uffff\1\31\22\uffff\1\40\1\42"+
        "\1\25\4\uffff\1\33\4\uffff\1\20\1\21\4\uffff\1\44\2\uffff\1\41\4"+
        "\uffff\1\43\2\uffff\1\24\1\36\1\53\1\32\1\35\2\uffff\1\22";
    static final String DFA9_specialS =
        "\17\uffff\1\11\75\uffff\1\0\51\uffff\1\7\1\5\1\6\1\2\1\1\1\4\1"+
        "\3\1\10\165\uffff}>";
    static final String[] DFA9_transitionS = {
            "\2\53\1\uffff\2\53\17\uffff\1\53\2\uffff\1\53\1\uffff\1\17"+
            "\1\uffff\1\51\1\uffff\1\16\1\uffff\1\6\1\7\1\uffff\1\51\1\3"+
            "\1\51\1\4\1\52\12\34\1\2\1\1\1\14\1\5\1\15\2\uffff\1\44\1\45"+
            "\1\47\1\35\1\46\1\51\1\40\1\51\1\37\4\51\1\43\1\42\1\50\2\51"+
            "\1\36\1\41\6\51\1\10\1\uffff\1\11\1\uffff\1\51\1\uffff\1\27"+
            "\1\30\1\32\1\20\1\31\1\51\1\23\1\51\1\22\4\51\1\26\1\25\1\33"+
            "\2\51\1\21\1\24\6\51\1\12\1\uffff\1\13",
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
            "\0\55",
            "\1\57\37\uffff\1\56",
            "\1\61\37\uffff\1\60",
            "\1\64\1\65\36\uffff\1\62\1\63",
            "\1\67\37\uffff\1\66",
            "\1\71\37\uffff\1\70",
            "\1\74\16\uffff\1\75\20\uffff\1\72\16\uffff\1\73",
            "\1\77\37\uffff\1\76",
            "\1\101\37\uffff\1\100",
            "\1\103\37\uffff\1\102",
            "\1\105\37\uffff\1\104",
            "\1\107\37\uffff\1\106",
            "\1\112\15\uffff\1\113\21\uffff\1\110\15\uffff\1\111",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\1\51\12\34\7\uffff"+
            "\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\57\37\uffff\1\56",
            "\1\61\37\uffff\1\60",
            "\1\64\1\65\36\uffff\1\62\1\63",
            "\1\67\37\uffff\1\66",
            "\1\71\37\uffff\1\70",
            "\1\74\16\uffff\1\75\20\uffff\1\72\16\uffff\1\73",
            "\1\77\37\uffff\1\76",
            "\1\101\37\uffff\1\100",
            "\1\103\37\uffff\1\102",
            "\1\105\37\uffff\1\104",
            "\1\107\37\uffff\1\106",
            "\1\112\15\uffff\1\113\21\uffff\1\110\15\uffff\1\111",
            "",
            "\1\116\4\uffff\1\115",
            "",
            "",
            "",
            "\1\121\2\uffff\1\122\34\uffff\1\117\2\uffff\1\120",
            "\1\121\2\uffff\1\122\34\uffff\1\117\2\uffff\1\120",
            "\1\125\15\uffff\1\126\21\uffff\1\123\15\uffff\1\124",
            "\1\125\15\uffff\1\126\21\uffff\1\123\15\uffff\1\124",
            "\1\133\14\uffff\1\134\2\uffff\1\132\17\uffff\1\130\14\uffff"+
            "\1\131\2\uffff\1\127",
            "\1\136\37\uffff\1\135",
            "\1\133\14\uffff\1\134\2\uffff\1\132\17\uffff\1\130\14\uffff"+
            "\1\131\2\uffff\1\127",
            "\1\136\37\uffff\1\135",
            "\1\140\37\uffff\1\137",
            "\1\140\37\uffff\1\137",
            "\1\142\37\uffff\1\141",
            "\1\142\37\uffff\1\141",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\145\37\uffff\1\144",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\145\37\uffff\1\144",
            "\1\150\2\uffff\1\151\34\uffff\1\146\2\uffff\1\147",
            "\1\150\2\uffff\1\151\34\uffff\1\146\2\uffff\1\147",
            "\1\153\37\uffff\1\152",
            "\1\153\37\uffff\1\152",
            "\1\155\37\uffff\1\154",
            "\1\155\37\uffff\1\154",
            "\1\157\37\uffff\1\156",
            "\1\157\37\uffff\1\156",
            "\1\161\37\uffff\1\160",
            "\1\161\37\uffff\1\160",
            "\1\163\37\uffff\1\162",
            "\1\165\37\uffff\1\164",
            "\1\163\37\uffff\1\162",
            "\1\165\37\uffff\1\164",
            "",
            "\44\166\1\175\6\166\1\173\1\166\1\174\1\166\1\176\12\171\7"+
            "\166\32\170\4\166\1\172\1\166\32\167\uff85\166",
            "",
            "\1\u0080\37\uffff\1\177",
            "\1\u0082\37\uffff\1\u0081",
            "\1\u0080\37\uffff\1\177",
            "\1\u0082\37\uffff\1\u0081",
            "\1\u0085\4\uffff\1\u0086\32\uffff\1\u0083\4\uffff\1\u0084",
            "\1\u0088\37\uffff\1\u0087",
            "\1\u0085\4\uffff\1\u0086\32\uffff\1\u0083\4\uffff\1\u0084",
            "\1\u0088\37\uffff\1\u0087",
            "\1\u008a\37\uffff\1\u0089",
            "\1\u008c\37\uffff\1\u008b",
            "\1\u008e\37\uffff\1\u008d",
            "\1\u008a\37\uffff\1\u0089",
            "\1\u008c\37\uffff\1\u008b",
            "\1\u008e\37\uffff\1\u008d",
            "\1\u0090\37\uffff\1\u008f",
            "\1\u0090\37\uffff\1\u008f",
            "\1\u0092\37\uffff\1\u0091",
            "\1\u0092\37\uffff\1\u0091",
            "\1\u0094\37\uffff\1\u0093",
            "\1\u0094\37\uffff\1\u0093",
            "",
            "\1\u0096\37\uffff\1\u0095",
            "\1\u0096\37\uffff\1\u0095",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u0099\37\uffff\1\u0098",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u0099\37\uffff\1\u0098",
            "\1\u009b\37\uffff\1\u009a",
            "\1\u009b\37\uffff\1\u009a",
            "\1\u009d\37\uffff\1\u009c",
            "\1\u009d\37\uffff\1\u009c",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u00a0\37\uffff\1\u009f",
            "\1\u00a0\37\uffff\1\u009f",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u00a3\37\uffff\1\u00a2",
            "\1\u00a3\37\uffff\1\u00a2",
            "",
            "\44\166\1\175\6\166\1\173\1\166\1\174\1\166\1\176\12\171\7"+
            "\166\32\170\4\166\1\172\1\166\32\167\uff85\166",
            "\44\166\1\175\6\166\1\173\1\166\1\174\1\166\1\176\12\171\7"+
            "\166\32\170\4\166\1\172\1\166\32\167\uff85\166",
            "\44\166\1\175\6\166\1\173\1\166\1\174\1\166\1\176\12\171\7"+
            "\166\32\170\4\166\1\172\1\166\32\167\uff85\166",
            "\44\166\1\175\6\166\1\173\1\166\1\174\1\166\1\176\12\171\7"+
            "\166\32\170\4\166\1\172\1\166\32\167\uff85\166",
            "\44\166\1\175\6\166\1\173\1\166\1\174\1\166\1\176\12\171\7"+
            "\166\32\170\4\166\1\172\1\166\32\167\uff85\166",
            "\44\166\1\175\6\166\1\173\1\166\1\174\1\166\1\176\12\171\7"+
            "\166\32\170\4\166\1\172\1\166\32\167\uff85\166",
            "\44\166\1\175\6\166\1\173\1\166\1\174\1\166\1\176\12\171\7"+
            "\166\32\170\4\166\1\172\1\166\32\167\uff85\166",
            "\44\166\1\175\6\166\1\173\1\166\1\174\1\166\1\176\12\171\7"+
            "\166\32\170\4\166\1\172\1\166\32\167\uff85\166",
            "\1\u00a5\37\uffff\1\u00a4",
            "\1\u00a5\37\uffff\1\u00a4",
            "\1\u00a7\37\uffff\1\u00a6",
            "\1\u00a7\37\uffff\1\u00a6",
            "\1\u00a9\37\uffff\1\u00a8",
            "\1\u00ab\37\uffff\1\u00aa",
            "\1\u00a9\37\uffff\1\u00a8",
            "\1\u00ab\37\uffff\1\u00aa",
            "\1\u00ad\37\uffff\1\u00ac",
            "\1\u00ad\37\uffff\1\u00ac",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u00b0\37\uffff\1\u00af",
            "\1\u00b0\37\uffff\1\u00af",
            "\1\u00b2\37\uffff\1\u00b1",
            "\1\u00b2\37\uffff\1\u00b1",
            "\1\u00b4\37\uffff\1\u00b3",
            "\1\u00b4\37\uffff\1\u00b3",
            "\1\u00b6\37\uffff\1\u00b5",
            "\1\u00b6\37\uffff\1\u00b5",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u00b9\37\uffff\1\u00b8",
            "\1\u00b9\37\uffff\1\u00b8",
            "",
            "\1\u00bb\37\uffff\1\u00ba",
            "\1\u00bb\37\uffff\1\u00ba",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u00be\37\uffff\1\u00bd",
            "\1\u00be\37\uffff\1\u00bd",
            "",
            "\1\u00c0\37\uffff\1\u00bf",
            "\1\u00c0\37\uffff\1\u00bf",
            "",
            "\1\u00c2\37\uffff\1\u00c1",
            "\1\u00c2\37\uffff\1\u00c1",
            "\1\u00c4\37\uffff\1\u00c3",
            "\1\u00c4\37\uffff\1\u00c3",
            "\1\u00c6\37\uffff\1\u00c5",
            "\1\u00c6\37\uffff\1\u00c5",
            "\1\u00c8\37\uffff\1\u00c7",
            "\1\u00c8\37\uffff\1\u00c7",
            "\1\u00ca\37\uffff\1\u00c9",
            "\1\u00ca\37\uffff\1\u00c9",
            "\1\u00cc\37\uffff\1\u00cb",
            "\1\u00cc\37\uffff\1\u00cb",
            "",
            "\1\u00ce\37\uffff\1\u00cd",
            "\1\u00ce\37\uffff\1\u00cd",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "",
            "\1\u00d3\37\uffff\1\u00d2",
            "\1\u00d3\37\uffff\1\u00d2",
            "\1\u00d5\37\uffff\1\u00d4",
            "\1\u00d5\37\uffff\1\u00d4",
            "",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u00d8\37\uffff\1\u00d7",
            "\1\u00d8\37\uffff\1\u00d7",
            "\1\u00da\37\uffff\1\u00d9",
            "\1\u00da\37\uffff\1\u00d9",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u00de\37\uffff\1\u00dd",
            "\1\u00de\37\uffff\1\u00dd",
            "\1\u00e0\37\uffff\1\u00df",
            "\1\u00e0\37\uffff\1\u00df",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u00e3\37\uffff\1\u00e2",
            "\1\u00e3\37\uffff\1\u00e2",
            "",
            "",
            "",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u00e6\37\uffff\1\u00e5",
            "\1\u00e6\37\uffff\1\u00e5",
            "",
            "\1\u00e8\37\uffff\1\u00e7",
            "\1\u00e8\37\uffff\1\u00e7",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "",
            "",
            "\1\u00eb\37\uffff\1\u00ea",
            "\1\u00eb\37\uffff\1\u00ea",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "",
            "\2\u00ee\1\uffff\2\u00ee\17\uffff\1\u00ee\2\uffff\1\u00ee"+
            "\1\uffff\1\u00ee\1\uffff\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff"+
            "\13\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\2\u00ee\1\uffff\2\u00ee\17\uffff\1\u00ee\2\uffff\1\u00ee"+
            "\1\uffff\1\u00ee\1\uffff\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff"+
            "\13\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "",
            "\1\u00f2\37\uffff\1\u00f1",
            "\1\u00f2\37\uffff\1\u00f1",
            "",
            "",
            "",
            "",
            "",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
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
            return "1:1: Tokens : ( SEMICOLON | COLON | COMMA | PERIOD | EQUALS | LPAREN | RPAREN | LBRACKET | RBRACKET | LBRACE | RBRACE | LANGLE | RANGLE | AMPERSAND | DBLQUOTE | DESIGN | DEVICE | SUBDESIGN | INST | SUBINST | GROUP | THIS | OF | NET | ATTR | NEWATTR | BEGIN | END | COMBINE | INCLUDE | PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN | INT | IDENT | STRING | WHITESPACE | LINE_COMMENT | MULTILINE_COMMENT | INCLUDE_DECL );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA9_77 = input.LA(1);

                        s = -1;
                        if ( ((LA9_77>='\u0000' && LA9_77<='#')||(LA9_77>='%' && LA9_77<='*')||LA9_77==','||LA9_77=='.'||(LA9_77>=':' && LA9_77<='@')||(LA9_77>='[' && LA9_77<='^')||LA9_77=='`'||(LA9_77>='{' && LA9_77<='\uFFFF')) ) {s = 118;}

                        else if ( ((LA9_77>='a' && LA9_77<='z')) ) {s = 119;}

                        else if ( ((LA9_77>='A' && LA9_77<='Z')) ) {s = 120;}

                        else if ( ((LA9_77>='0' && LA9_77<='9')) ) {s = 121;}

                        else if ( (LA9_77=='_') ) {s = 122;}

                        else if ( (LA9_77=='+') ) {s = 123;}

                        else if ( (LA9_77=='-') ) {s = 124;}

                        else if ( (LA9_77=='$') ) {s = 125;}

                        else if ( (LA9_77=='/') ) {s = 126;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA9_123 = input.LA(1);

                        s = -1;
                        if ( ((LA9_123>='\u0000' && LA9_123<='#')||(LA9_123>='%' && LA9_123<='*')||LA9_123==','||LA9_123=='.'||(LA9_123>=':' && LA9_123<='@')||(LA9_123>='[' && LA9_123<='^')||LA9_123=='`'||(LA9_123>='{' && LA9_123<='\uFFFF')) ) {s = 118;}

                        else if ( ((LA9_123>='a' && LA9_123<='z')) ) {s = 119;}

                        else if ( ((LA9_123>='A' && LA9_123<='Z')) ) {s = 120;}

                        else if ( ((LA9_123>='0' && LA9_123<='9')) ) {s = 121;}

                        else if ( (LA9_123=='_') ) {s = 122;}

                        else if ( (LA9_123=='+') ) {s = 123;}

                        else if ( (LA9_123=='-') ) {s = 124;}

                        else if ( (LA9_123=='$') ) {s = 125;}

                        else if ( (LA9_123=='/') ) {s = 126;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA9_122 = input.LA(1);

                        s = -1;
                        if ( ((LA9_122>='\u0000' && LA9_122<='#')||(LA9_122>='%' && LA9_122<='*')||LA9_122==','||LA9_122=='.'||(LA9_122>=':' && LA9_122<='@')||(LA9_122>='[' && LA9_122<='^')||LA9_122=='`'||(LA9_122>='{' && LA9_122<='\uFFFF')) ) {s = 118;}

                        else if ( ((LA9_122>='a' && LA9_122<='z')) ) {s = 119;}

                        else if ( ((LA9_122>='A' && LA9_122<='Z')) ) {s = 120;}

                        else if ( ((LA9_122>='0' && LA9_122<='9')) ) {s = 121;}

                        else if ( (LA9_122=='_') ) {s = 122;}

                        else if ( (LA9_122=='+') ) {s = 123;}

                        else if ( (LA9_122=='-') ) {s = 124;}

                        else if ( (LA9_122=='$') ) {s = 125;}

                        else if ( (LA9_122=='/') ) {s = 126;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA9_125 = input.LA(1);

                        s = -1;
                        if ( ((LA9_125>='\u0000' && LA9_125<='#')||(LA9_125>='%' && LA9_125<='*')||LA9_125==','||LA9_125=='.'||(LA9_125>=':' && LA9_125<='@')||(LA9_125>='[' && LA9_125<='^')||LA9_125=='`'||(LA9_125>='{' && LA9_125<='\uFFFF')) ) {s = 118;}

                        else if ( ((LA9_125>='a' && LA9_125<='z')) ) {s = 119;}

                        else if ( ((LA9_125>='A' && LA9_125<='Z')) ) {s = 120;}

                        else if ( ((LA9_125>='0' && LA9_125<='9')) ) {s = 121;}

                        else if ( (LA9_125=='_') ) {s = 122;}

                        else if ( (LA9_125=='+') ) {s = 123;}

                        else if ( (LA9_125=='-') ) {s = 124;}

                        else if ( (LA9_125=='$') ) {s = 125;}

                        else if ( (LA9_125=='/') ) {s = 126;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA9_124 = input.LA(1);

                        s = -1;
                        if ( ((LA9_124>='\u0000' && LA9_124<='#')||(LA9_124>='%' && LA9_124<='*')||LA9_124==','||LA9_124=='.'||(LA9_124>=':' && LA9_124<='@')||(LA9_124>='[' && LA9_124<='^')||LA9_124=='`'||(LA9_124>='{' && LA9_124<='\uFFFF')) ) {s = 118;}

                        else if ( ((LA9_124>='a' && LA9_124<='z')) ) {s = 119;}

                        else if ( ((LA9_124>='A' && LA9_124<='Z')) ) {s = 120;}

                        else if ( ((LA9_124>='0' && LA9_124<='9')) ) {s = 121;}

                        else if ( (LA9_124=='_') ) {s = 122;}

                        else if ( (LA9_124=='+') ) {s = 123;}

                        else if ( (LA9_124=='-') ) {s = 124;}

                        else if ( (LA9_124=='$') ) {s = 125;}

                        else if ( (LA9_124=='/') ) {s = 126;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA9_120 = input.LA(1);

                        s = -1;
                        if ( ((LA9_120>='\u0000' && LA9_120<='#')||(LA9_120>='%' && LA9_120<='*')||LA9_120==','||LA9_120=='.'||(LA9_120>=':' && LA9_120<='@')||(LA9_120>='[' && LA9_120<='^')||LA9_120=='`'||(LA9_120>='{' && LA9_120<='\uFFFF')) ) {s = 118;}

                        else if ( ((LA9_120>='a' && LA9_120<='z')) ) {s = 119;}

                        else if ( ((LA9_120>='A' && LA9_120<='Z')) ) {s = 120;}

                        else if ( ((LA9_120>='0' && LA9_120<='9')) ) {s = 121;}

                        else if ( (LA9_120=='_') ) {s = 122;}

                        else if ( (LA9_120=='+') ) {s = 123;}

                        else if ( (LA9_120=='-') ) {s = 124;}

                        else if ( (LA9_120=='$') ) {s = 125;}

                        else if ( (LA9_120=='/') ) {s = 126;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA9_121 = input.LA(1);

                        s = -1;
                        if ( ((LA9_121>='\u0000' && LA9_121<='#')||(LA9_121>='%' && LA9_121<='*')||LA9_121==','||LA9_121=='.'||(LA9_121>=':' && LA9_121<='@')||(LA9_121>='[' && LA9_121<='^')||LA9_121=='`'||(LA9_121>='{' && LA9_121<='\uFFFF')) ) {s = 118;}

                        else if ( ((LA9_121>='a' && LA9_121<='z')) ) {s = 119;}

                        else if ( ((LA9_121>='A' && LA9_121<='Z')) ) {s = 120;}

                        else if ( ((LA9_121>='0' && LA9_121<='9')) ) {s = 121;}

                        else if ( (LA9_121=='_') ) {s = 122;}

                        else if ( (LA9_121=='+') ) {s = 123;}

                        else if ( (LA9_121=='-') ) {s = 124;}

                        else if ( (LA9_121=='$') ) {s = 125;}

                        else if ( (LA9_121=='/') ) {s = 126;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA9_119 = input.LA(1);

                        s = -1;
                        if ( ((LA9_119>='\u0000' && LA9_119<='#')||(LA9_119>='%' && LA9_119<='*')||LA9_119==','||LA9_119=='.'||(LA9_119>=':' && LA9_119<='@')||(LA9_119>='[' && LA9_119<='^')||LA9_119=='`'||(LA9_119>='{' && LA9_119<='\uFFFF')) ) {s = 118;}

                        else if ( ((LA9_119>='a' && LA9_119<='z')) ) {s = 119;}

                        else if ( ((LA9_119>='A' && LA9_119<='Z')) ) {s = 120;}

                        else if ( ((LA9_119>='0' && LA9_119<='9')) ) {s = 121;}

                        else if ( (LA9_119=='_') ) {s = 122;}

                        else if ( (LA9_119=='+') ) {s = 123;}

                        else if ( (LA9_119=='-') ) {s = 124;}

                        else if ( (LA9_119=='$') ) {s = 125;}

                        else if ( (LA9_119=='/') ) {s = 126;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA9_126 = input.LA(1);

                        s = -1;
                        if ( ((LA9_126>='\u0000' && LA9_126<='#')||(LA9_126>='%' && LA9_126<='*')||LA9_126==','||LA9_126=='.'||(LA9_126>=':' && LA9_126<='@')||(LA9_126>='[' && LA9_126<='^')||LA9_126=='`'||(LA9_126>='{' && LA9_126<='\uFFFF')) ) {s = 118;}

                        else if ( ((LA9_126>='a' && LA9_126<='z')) ) {s = 119;}

                        else if ( ((LA9_126>='A' && LA9_126<='Z')) ) {s = 120;}

                        else if ( ((LA9_126>='0' && LA9_126<='9')) ) {s = 121;}

                        else if ( (LA9_126=='_') ) {s = 122;}

                        else if ( (LA9_126=='+') ) {s = 123;}

                        else if ( (LA9_126=='-') ) {s = 124;}

                        else if ( (LA9_126=='$') ) {s = 125;}

                        else if ( (LA9_126=='/') ) {s = 126;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA9_15 = input.LA(1);

                        s = -1;
                        if ( ((LA9_15>='\u0000' && LA9_15<='\uFFFF')) ) {s = 45;}

                        else s = 44;

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