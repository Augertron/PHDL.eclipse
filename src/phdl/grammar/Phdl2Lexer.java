// $ANTLR 3.3 Nov 30, 2010 12:50:56 /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g 2012-01-04 12:06:22

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
	import java.util.Set;
	import java.util.HashSet;


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
    public static final int INFO=34;
    public static final int PIN=35;
    public static final int INPIN=36;
    public static final int OUTPIN=37;
    public static final int IOPIN=38;
    public static final int PWRPIN=39;
    public static final int SUPPIN=40;
    public static final int WIDTH_DECL=41;
    public static final int ARRAY_DECL=42;
    public static final int DEVICE_DECL=43;
    public static final int ATTR_DECL=44;
    public static final int PIN_DECL=45;
    public static final int PIN_LIST=46;
    public static final int PIN_TYPE=47;
    public static final int INFO_DECL=48;
    public static final int NET_DECL=49;
    public static final int NAME_DECL=50;
    public static final int DESIGN_DECL=51;
    public static final int INST_DECL=52;
    public static final int ATTR_ASSIGN=53;
    public static final int ATTR_QUAL=54;
    public static final int PIN_ASSIGN=55;
    public static final int LIST_ARRAY=56;
    public static final int LIST_SLICE=57;
    public static final int IDENT=58;
    public static final int STRING=59;
    public static final int INT=60;
    public static final int PINNUM=61;
    public static final int D=62;
    public static final int E=63;
    public static final int S=64;
    public static final int I=65;
    public static final int G=66;
    public static final int N=67;
    public static final int V=68;
    public static final int C=69;
    public static final int U=70;
    public static final int B=71;
    public static final int T=72;
    public static final int R=73;
    public static final int O=74;
    public static final int P=75;
    public static final int H=76;
    public static final int F=77;
    public static final int A=78;
    public static final int W=79;
    public static final int M=80;
    public static final int L=81;
    public static final int CHAR=82;
    public static final int DIGIT=83;
    public static final int WHITESPACE=84;
    public static final int LINE_COMMENT=85;
    public static final int MULTILINE_COMMENT=86;
    public static final int INCLUDE_DECL=87;
    public static final int J=88;
    public static final int K=89;
    public static final int Q=90;
    public static final int X=91;
    public static final int Y=92;
    public static final int Z=93;


    	/**
    	 * Class to enable pushing a character stream onto a stack
    	 */
    	class SaveStruct {
    		public CharStream input;
    		public int marker;
    		
    		SaveStruct(CharStream input) {
    			this.input = input;
    			this.marker = input.mark();
    		}
    	}
    	
    	/**
    	 * The stack of saved character streams
    	 */
    	private Stack<SaveStruct> includes = new Stack<SaveStruct>();
    	private Set<String> includeNames = new HashSet<String>();
    	
    	public Set<String> getIncludeNames() {
    		return includeNames;
    	}
    	public void setIncludeNames(Set<String> includeNames) {
    		this.includeNames = includeNames;
    	}
    	
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
    public String getGrammarFileName() { return "/fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g"; }

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:86:11: ( ';' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:86:13: ';'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:87:7: ( ':' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:87:9: ':'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:88:7: ( ',' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:88:9: ','
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:89:8: ( '.' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:89:10: '.'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:90:8: ( '=' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:90:10: '='
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:91:8: ( '(' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:91:10: '('
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:92:8: ( ')' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:92:10: ')'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:93:10: ( '[' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:93:12: '['
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:94:10: ( ']' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:94:12: ']'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:95:8: ( '{' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:95:10: '{'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:96:8: ( '}' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:96:10: '}'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:97:8: ( '<' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:97:10: '<'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:98:8: ( '>' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:98:10: '>'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:99:11: ( '&' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:99:13: '&'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:100:10: ( '\"' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:100:12: '\"'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:320:7: ( D E S I G N )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:320:9: D E S I G N
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:321:7: ( D E V I C E )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:321:9: D E V I C E
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:322:10: ( S U B D E S I G N )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:322:12: S U B D E S I G N
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:323:5: ( I N S T )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:323:7: I N S T
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:324:8: ( S U B I N S T )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:324:10: S U B I N S T
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:325:6: ( G R O U P )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:325:8: G R O U P
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:326:5: ( T H I S )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:326:7: T H I S
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:327:3: ( O F )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:327:5: O F
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:328:4: ( N E T )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:328:6: N E T
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:329:5: ( A T T R )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:329:7: A T T R
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:330:8: ( N E W A T T R )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:330:10: N E W A T T R
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:331:6: ( B E G I N )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:331:8: B E G I N
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:332:4: ( E N D )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:332:6: E N D
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:333:8: ( C O M B I N E )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:333:10: C O M B I N E
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:334:8: ( I N C L U D E )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:334:10: I N C L U D E
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

    // $ANTLR start "INFO"
    public final void mINFO() throws RecognitionException {
        try {
            int _type = INFO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:335:5: ( I N F O )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:335:7: I N F O
            {
            mI(); 
            mN(); 
            mF(); 
            mO(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INFO"

    // $ANTLR start "PIN"
    public final void mPIN() throws RecognitionException {
        try {
            int _type = PIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:338:4: ( P I N )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:338:6: P I N
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:339:6: ( I N P I N )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:339:8: I N P I N
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:340:7: ( O U T P I N )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:340:9: O U T P I N
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:341:6: ( I O P I N )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:341:8: I O P I N
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:342:7: ( P W R P I N )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:342:9: P W R P I N
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:343:7: ( S U P P I N )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:343:9: S U P P I N
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

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:345:15: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' | '+' | '-' | '$' | '/' )
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
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:345:17: ( 'a' .. 'z' )
                    {
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:345:17: ( 'a' .. 'z' )
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:345:18: 'a' .. 'z'
                    {
                    matchRange('a','z'); 

                    }


                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:345:30: ( 'A' .. 'Z' )
                    {
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:345:30: ( 'A' .. 'Z' )
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:345:31: 'A' .. 'Z'
                    {
                    matchRange('A','Z'); 

                    }


                    }
                    break;
                case 3 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:345:43: '_'
                    {
                    match('_'); 

                    }
                    break;
                case 4 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:345:49: '+'
                    {
                    match('+'); 

                    }
                    break;
                case 5 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:345:55: '-'
                    {
                    match('-'); 

                    }
                    break;
                case 6 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:345:61: '$'
                    {
                    match('$'); 

                    }
                    break;
                case 7 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:345:67: '/'
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:346:16: ( ( '0' .. '9' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:346:18: ( '0' .. '9' )
            {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:346:18: ( '0' .. '9' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:346:19: '0' .. '9'
            {
            matchRange('0','9'); 

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:348:4: ( ( DIGIT )+ )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:348:6: ( DIGIT )+
            {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:348:6: ( DIGIT )+
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
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:348:6: DIGIT
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:349:6: ( CHAR ( CHAR | DIGIT )* )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:349:8: CHAR ( CHAR | DIGIT )*
            {
            mCHAR(); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:349:13: ( CHAR | DIGIT )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='$'||LA3_0=='+'||LA3_0=='-'||LA3_0=='/'||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }
                else if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:349:14: CHAR
            	    {
            	    mCHAR(); 

            	    }
            	    break;
            	case 2 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:349:21: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    break loop3;
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

    // $ANTLR start "PINNUM"
    public final void mPINNUM() throws RecognitionException {
        try {
            int _type = PINNUM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:350:7: ( DIGIT ( CHAR )+ )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:350:9: DIGIT ( CHAR )+
            {
            mDIGIT(); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:350:15: ( CHAR )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='$'||LA4_0=='+'||LA4_0=='-'||LA4_0=='/'||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:350:15: CHAR
            	    {
            	    mCHAR(); 

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
    // $ANTLR end "PINNUM"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            int c;

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:356:2: ( DBLQUOTE ( '/' DBLQUOTE | c=~ ( DBLQUOTE ) )* DBLQUOTE )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:356:5: DBLQUOTE ( '/' DBLQUOTE | c=~ ( DBLQUOTE ) )* DBLQUOTE
            {
            mDBLQUOTE(); 
            StringBuilder sb = new StringBuilder();
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:357:3: ( '/' DBLQUOTE | c=~ ( DBLQUOTE ) )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='/') ) {
                    int LA5_2 = input.LA(2);

                    if ( (LA5_2=='\"') ) {
                        int LA5_4 = input.LA(3);

                        if ( ((LA5_4>='\u0000' && LA5_4<='\uFFFF')) ) {
                            alt5=1;
                        }

                        else {
                            alt5=2;
                        }

                    }
                    else if ( ((LA5_2>='\u0000' && LA5_2<='!')||(LA5_2>='#' && LA5_2<='\uFFFF')) ) {
                        alt5=2;
                    }


                }
                else if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='.')||(LA5_0>='0' && LA5_0<='\uFFFF')) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:357:5: '/' DBLQUOTE
            	    {
            	    match('/'); 
            	    mDBLQUOTE(); 
            	    sb.appendCodePoint('"');

            	    }
            	    break;
            	case 2 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:358:5: c=~ ( DBLQUOTE )
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
            	    break loop5;
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:373:2: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' | '\\u001D' )+ )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:373:4: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' | '\\u001D' )+
            {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:373:4: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' | '\\u001D' )+
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
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:381:2: ( '//' ( . )* ( '\\n' | '\\r' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:381:4: '//' ( . )* ( '\\n' | '\\r' )
            {
            match("//"); 

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:381:9: ( . )*
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
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:381:9: .
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:389:2: ( '/*' ( . )* '*/' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:389:4: '/*' ( . )* '*/'
            {
            match("/*"); 

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:389:9: ( . )*
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
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:389:9: .
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

    // $ANTLR start "INCLUDE_DECL"
    public final void mINCLUDE_DECL() throws RecognitionException {
        try {
            int _type = INCLUDE_DECL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken fileName=null;

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:399:2: ( INCLUDE ( WHITESPACE )? fileName= STRING )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:399:5: INCLUDE ( WHITESPACE )? fileName= STRING
            {
            mINCLUDE(); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:399:13: ( WHITESPACE )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>='\t' && LA9_0<='\n')||(LA9_0>='\f' && LA9_0<='\r')||LA9_0=='\u001D'||LA9_0==' ') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:399:14: WHITESPACE
                    {
                    mWHITESPACE(); 

                    }
                    break;

            }

            int fileNameStart770 = getCharIndex();
            int fileNameStartLine770 = getLine();
            int fileNameStartCharPos770 = getCharPositionInLine();
            mSTRING(); 
            fileName = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, fileNameStart770, getCharIndex()-1);
            fileName.setLine(fileNameStartLine770);
            fileName.setCharPositionInLine(fileNameStartCharPos770);
            	
            			String name = fileName.getText();
            			name = name.substring(1,name.length()-1);
            			// check for duplicate include files
            			if (!includeNames.add(name)) {
            				System.out.println("ERROR: " + fileName.getInputStream().getSourceName() + " line " + 
            						fileName.getLine() + ":" + fileName.getCharPositionInLine() + 
            						" duplicate included file.");
                        	System.exit(1);
            			}
            			try {
            				// save the character stream by pushing it onto the stack
            				SaveStruct ss = new SaveStruct(input);
            				includes.push(ss);

            				// make a new ANTLRFileStream and switch to it
            				setCharStream(new ANTLRFileStream(name));
            				reset();

            			} catch (Exception fnf) { 
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:429:11: ( ( 'a' | 'A' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:429:12: ( 'a' | 'A' )
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:430:11: ( ( 'b' | 'B' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:430:12: ( 'b' | 'B' )
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:431:11: ( ( 'c' | 'C' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:431:12: ( 'c' | 'C' )
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:432:11: ( ( 'd' | 'D' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:432:12: ( 'd' | 'D' )
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:433:11: ( ( 'e' | 'E' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:433:12: ( 'e' | 'E' )
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:434:11: ( ( 'f' | 'F' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:434:12: ( 'f' | 'F' )
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:435:11: ( ( 'g' | 'G' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:435:12: ( 'g' | 'G' )
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:436:11: ( ( 'h' | 'H' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:436:12: ( 'h' | 'H' )
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:437:11: ( ( 'i' | 'I' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:437:12: ( 'i' | 'I' )
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:438:11: ( ( 'j' | 'J' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:438:12: ( 'j' | 'J' )
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:439:11: ( ( 'k' | 'K' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:439:12: ( 'k' | 'K' )
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:440:11: ( ( 'l' | 'L' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:440:12: ( 'l' | 'L' )
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:441:11: ( ( 'm' | 'M' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:441:12: ( 'm' | 'M' )
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:442:11: ( ( 'n' | 'N' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:442:12: ( 'n' | 'N' )
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:443:11: ( ( 'o' | 'O' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:443:12: ( 'o' | 'O' )
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:444:11: ( ( 'p' | 'P' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:444:12: ( 'p' | 'P' )
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:445:11: ( ( 'q' | 'Q' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:445:12: ( 'q' | 'Q' )
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:446:11: ( ( 'r' | 'R' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:446:12: ( 'r' | 'R' )
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:447:11: ( ( 's' | 'S' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:447:12: ( 's' | 'S' )
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:448:11: ( ( 't' | 'T' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:448:12: ( 't' | 'T' )
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:449:11: ( ( 'u' | 'U' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:449:12: ( 'u' | 'U' )
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:450:11: ( ( 'v' | 'V' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:450:12: ( 'v' | 'V' )
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:451:11: ( ( 'w' | 'W' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:451:12: ( 'w' | 'W' )
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:452:11: ( ( 'x' | 'X' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:452:12: ( 'x' | 'X' )
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:453:11: ( ( 'y' | 'Y' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:453:12: ( 'y' | 'Y' )
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:454:11: ( ( 'z' | 'Z' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:454:12: ( 'z' | 'Z' )
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
        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:8: ( SEMICOLON | COLON | COMMA | PERIOD | EQUALS | LPAREN | RPAREN | LBRACKET | RBRACKET | LBRACE | RBRACE | LANGLE | RANGLE | AMPERSAND | DBLQUOTE | DESIGN | DEVICE | SUBDESIGN | INST | SUBINST | GROUP | THIS | OF | NET | ATTR | NEWATTR | BEGIN | END | COMBINE | INCLUDE | INFO | PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN | INT | IDENT | PINNUM | STRING | WHITESPACE | LINE_COMMENT | MULTILINE_COMMENT | INCLUDE_DECL )
        int alt10=45;
        alt10 = dfa10.predict(input);
        switch (alt10) {
            case 1 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:10: SEMICOLON
                {
                mSEMICOLON(); 

                }
                break;
            case 2 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:20: COLON
                {
                mCOLON(); 

                }
                break;
            case 3 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:26: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 4 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:32: PERIOD
                {
                mPERIOD(); 

                }
                break;
            case 5 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:39: EQUALS
                {
                mEQUALS(); 

                }
                break;
            case 6 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:46: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 7 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:53: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 8 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:60: LBRACKET
                {
                mLBRACKET(); 

                }
                break;
            case 9 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:69: RBRACKET
                {
                mRBRACKET(); 

                }
                break;
            case 10 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:78: LBRACE
                {
                mLBRACE(); 

                }
                break;
            case 11 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:85: RBRACE
                {
                mRBRACE(); 

                }
                break;
            case 12 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:92: LANGLE
                {
                mLANGLE(); 

                }
                break;
            case 13 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:99: RANGLE
                {
                mRANGLE(); 

                }
                break;
            case 14 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:106: AMPERSAND
                {
                mAMPERSAND(); 

                }
                break;
            case 15 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:116: DBLQUOTE
                {
                mDBLQUOTE(); 

                }
                break;
            case 16 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:125: DESIGN
                {
                mDESIGN(); 

                }
                break;
            case 17 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:132: DEVICE
                {
                mDEVICE(); 

                }
                break;
            case 18 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:139: SUBDESIGN
                {
                mSUBDESIGN(); 

                }
                break;
            case 19 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:149: INST
                {
                mINST(); 

                }
                break;
            case 20 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:154: SUBINST
                {
                mSUBINST(); 

                }
                break;
            case 21 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:162: GROUP
                {
                mGROUP(); 

                }
                break;
            case 22 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:168: THIS
                {
                mTHIS(); 

                }
                break;
            case 23 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:173: OF
                {
                mOF(); 

                }
                break;
            case 24 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:176: NET
                {
                mNET(); 

                }
                break;
            case 25 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:180: ATTR
                {
                mATTR(); 

                }
                break;
            case 26 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:185: NEWATTR
                {
                mNEWATTR(); 

                }
                break;
            case 27 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:193: BEGIN
                {
                mBEGIN(); 

                }
                break;
            case 28 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:199: END
                {
                mEND(); 

                }
                break;
            case 29 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:203: COMBINE
                {
                mCOMBINE(); 

                }
                break;
            case 30 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:211: INCLUDE
                {
                mINCLUDE(); 

                }
                break;
            case 31 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:219: INFO
                {
                mINFO(); 

                }
                break;
            case 32 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:224: PIN
                {
                mPIN(); 

                }
                break;
            case 33 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:228: INPIN
                {
                mINPIN(); 

                }
                break;
            case 34 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:234: OUTPIN
                {
                mOUTPIN(); 

                }
                break;
            case 35 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:241: IOPIN
                {
                mIOPIN(); 

                }
                break;
            case 36 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:247: PWRPIN
                {
                mPWRPIN(); 

                }
                break;
            case 37 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:254: SUPPIN
                {
                mSUPPIN(); 

                }
                break;
            case 38 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:261: INT
                {
                mINT(); 

                }
                break;
            case 39 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:265: IDENT
                {
                mIDENT(); 

                }
                break;
            case 40 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:271: PINNUM
                {
                mPINNUM(); 

                }
                break;
            case 41 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:278: STRING
                {
                mSTRING(); 

                }
                break;
            case 42 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:285: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 43 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:296: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;
            case 44 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:309: MULTILINE_COMMENT
                {
                mMULTILINE_COMMENT(); 

                }
                break;
            case 45 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl2.g:1:327: INCLUDE_DECL
                {
                mINCLUDE_DECL(); 

                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\17\uffff\1\54\14\51\1\114\14\51\1\uffff\1\51\3\uffff\14\51\1\146"+
        "\1\51\1\146\17\51\2\uffff\1\51\1\uffff\26\51\1\uffff\2\51\1\u009c"+
        "\1\51\1\u009c\5\51\2\u00a3\2\51\2\u00a6\2\51\1\uffff\22\51\2\u00b3"+
        "\2\51\2\u00b6\6\51\2\u00bd\2\51\1\uffff\2\51\2\u00c2\2\51\1\uffff"+
        "\2\51\1\uffff\14\51\1\uffff\2\51\1\uffff\2\u00d5\2\u00d6\2\u00d7"+
        "\1\uffff\4\51\1\uffff\2\u00dc\4\51\2\u00e1\2\u00e2\4\51\2\u00e7"+
        "\2\51\3\uffff\2\u00ea\2\51\1\uffff\2\51\2\u00ef\2\uffff\2\51\2\u00f2"+
        "\1\uffff\2\u00f3\1\uffff\2\u00f5\2\u00f6\1\uffff\2\51\5\uffff\2"+
        "\u00f9\1\uffff";
    static final String DFA10_eofS =
        "\u00fa\uffff";
    static final String DFA10_minS =
        "\1\11\16\uffff\1\0\1\105\1\125\1\116\1\122\1\110\1\106\1\105\1\124"+
        "\1\105\1\116\1\117\1\111\1\44\1\105\1\125\1\116\1\122\1\110\1\106"+
        "\1\105\1\124\1\105\1\116\1\117\1\111\1\uffff\1\52\3\uffff\2\123"+
        "\2\102\1\103\1\120\1\103\1\120\2\117\2\111\1\44\1\124\1\44\5\124"+
        "\2\107\2\104\2\115\1\116\1\122\1\116\1\122\2\uffff\1\0\1\uffff\4"+
        "\111\1\104\1\120\1\104\1\120\1\124\1\114\1\117\1\111\1\124\1\114"+
        "\1\117\3\111\2\125\2\123\1\uffff\2\120\1\44\1\101\1\44\1\101\2\122"+
        "\2\111\2\44\2\102\2\44\2\120\1\uffff\10\0\2\107\2\103\1\105\1\116"+
        "\1\105\1\116\2\111\2\44\2\125\2\44\4\116\2\120\2\44\2\111\1\uffff"+
        "\2\124\2\44\2\116\1\uffff\2\111\1\uffff\2\111\2\116\2\105\4\123"+
        "\2\116\1\uffff\2\104\1\uffff\6\44\1\uffff\2\116\2\124\1\uffff\2"+
        "\44\4\116\4\44\2\111\2\124\2\44\2\105\3\uffff\2\44\2\122\1\uffff"+
        "\2\105\2\44\2\uffff\2\107\2\44\1\uffff\2\11\1\uffff\4\44\1\uffff"+
        "\2\116\5\uffff\2\44\1\uffff";
    static final String DFA10_maxS =
        "\1\175\16\uffff\1\uffff\1\145\1\165\1\157\1\162\1\150\1\165\1\145"+
        "\1\164\1\145\1\156\1\157\1\167\1\172\1\145\1\165\1\157\1\162\1\150"+
        "\1\165\1\145\1\164\1\145\1\156\1\157\1\167\1\uffff\1\57\3\uffff"+
        "\2\166\2\160\1\163\1\160\1\163\1\160\2\157\2\151\1\172\1\164\1\172"+
        "\1\164\2\167\2\164\2\147\2\144\2\155\1\156\1\162\1\156\1\162\2\uffff"+
        "\1\uffff\1\uffff\5\151\1\160\1\151\1\160\1\164\1\154\1\157\1\151"+
        "\1\164\1\154\1\157\3\151\2\165\2\163\1\uffff\2\160\1\172\1\141\1"+
        "\172\1\141\2\162\2\151\2\172\2\142\2\172\2\160\1\uffff\10\uffff"+
        "\2\147\2\143\1\145\1\156\1\145\1\156\2\151\2\172\2\165\2\172\4\156"+
        "\2\160\2\172\2\151\1\uffff\2\164\2\172\2\156\1\uffff\2\151\1\uffff"+
        "\2\151\2\156\2\145\4\163\2\156\1\uffff\2\144\1\uffff\6\172\1\uffff"+
        "\2\156\2\164\1\uffff\2\172\4\156\4\172\2\151\2\164\2\172\2\145\3"+
        "\uffff\2\172\2\162\1\uffff\2\145\2\172\2\uffff\2\147\2\172\1\uffff"+
        "\2\172\1\uffff\4\172\1\uffff\2\156\5\uffff\2\172\1\uffff";
    static final String DFA10_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1"+
        "\15\1\16\32\uffff\1\47\1\uffff\1\52\1\17\1\51\36\uffff\1\46\1\50"+
        "\1\uffff\1\54\26\uffff\1\27\22\uffff\1\53\42\uffff\1\30\6\uffff"+
        "\1\34\2\uffff\1\40\14\uffff\1\23\2\uffff\1\37\6\uffff\1\26\4\uffff"+
        "\1\31\22\uffff\1\41\1\43\1\25\4\uffff\1\33\4\uffff\1\20\1\21\4\uffff"+
        "\1\45\2\uffff\1\42\4\uffff\1\44\2\uffff\1\24\1\36\1\55\1\32\1\35"+
        "\2\uffff\1\22";
    static final String DFA10_specialS =
        "\17\uffff\1\0\76\uffff\1\10\53\uffff\1\7\1\6\1\5\1\4\1\3\1\2\1\1"+
        "\1\11\170\uffff}>";
    static final String[] DFA10_transitionS = {
            "\2\53\1\uffff\2\53\17\uffff\1\53\2\uffff\1\53\1\uffff\1\17\1"+
            "\uffff\1\51\1\uffff\1\16\1\uffff\1\6\1\7\1\uffff\1\51\1\3\1"+
            "\51\1\4\1\52\12\34\1\2\1\1\1\14\1\5\1\15\2\uffff\1\44\1\45\1"+
            "\47\1\35\1\46\1\51\1\40\1\51\1\37\4\51\1\43\1\42\1\50\2\51\1"+
            "\36\1\41\6\51\1\10\1\uffff\1\11\1\uffff\1\51\1\uffff\1\27\1"+
            "\30\1\32\1\20\1\31\1\51\1\23\1\51\1\22\4\51\1\26\1\25\1\33\2"+
            "\51\1\21\1\24\6\51\1\12\1\uffff\1\13",
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
            "\1\115\6\uffff\1\115\1\uffff\1\115\1\uffff\1\115\21\uffff\32"+
            "\115\4\uffff\1\115\1\uffff\32\115",
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
            "\1\117\4\uffff\1\116",
            "",
            "",
            "",
            "\1\122\2\uffff\1\123\34\uffff\1\120\2\uffff\1\121",
            "\1\122\2\uffff\1\123\34\uffff\1\120\2\uffff\1\121",
            "\1\126\15\uffff\1\127\21\uffff\1\124\15\uffff\1\125",
            "\1\126\15\uffff\1\127\21\uffff\1\124\15\uffff\1\125",
            "\1\135\2\uffff\1\136\11\uffff\1\137\2\uffff\1\134\17\uffff"+
            "\1\131\2\uffff\1\132\11\uffff\1\133\2\uffff\1\130",
            "\1\141\37\uffff\1\140",
            "\1\135\2\uffff\1\136\11\uffff\1\137\2\uffff\1\134\17\uffff"+
            "\1\131\2\uffff\1\132\11\uffff\1\133\2\uffff\1\130",
            "\1\141\37\uffff\1\140",
            "\1\143\37\uffff\1\142",
            "\1\143\37\uffff\1\142",
            "\1\145\37\uffff\1\144",
            "\1\145\37\uffff\1\144",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\150\37\uffff\1\147",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\150\37\uffff\1\147",
            "\1\153\2\uffff\1\154\34\uffff\1\151\2\uffff\1\152",
            "\1\153\2\uffff\1\154\34\uffff\1\151\2\uffff\1\152",
            "\1\156\37\uffff\1\155",
            "\1\156\37\uffff\1\155",
            "\1\160\37\uffff\1\157",
            "\1\160\37\uffff\1\157",
            "\1\162\37\uffff\1\161",
            "\1\162\37\uffff\1\161",
            "\1\164\37\uffff\1\163",
            "\1\164\37\uffff\1\163",
            "\1\166\37\uffff\1\165",
            "\1\170\37\uffff\1\167",
            "\1\166\37\uffff\1\165",
            "\1\170\37\uffff\1\167",
            "",
            "",
            "\44\171\1\177\6\171\1\175\1\171\1\176\1\171\1\u0080\12\u0081"+
            "\7\171\32\173\4\171\1\174\1\171\32\172\uff85\171",
            "",
            "\1\u0083\37\uffff\1\u0082",
            "\1\u0085\37\uffff\1\u0084",
            "\1\u0083\37\uffff\1\u0082",
            "\1\u0085\37\uffff\1\u0084",
            "\1\u0088\4\uffff\1\u0089\32\uffff\1\u0086\4\uffff\1\u0087",
            "\1\u008b\37\uffff\1\u008a",
            "\1\u0088\4\uffff\1\u0089\32\uffff\1\u0086\4\uffff\1\u0087",
            "\1\u008b\37\uffff\1\u008a",
            "\1\u008d\37\uffff\1\u008c",
            "\1\u008f\37\uffff\1\u008e",
            "\1\u0091\37\uffff\1\u0090",
            "\1\u0093\37\uffff\1\u0092",
            "\1\u008d\37\uffff\1\u008c",
            "\1\u008f\37\uffff\1\u008e",
            "\1\u0091\37\uffff\1\u0090",
            "\1\u0093\37\uffff\1\u0092",
            "\1\u0095\37\uffff\1\u0094",
            "\1\u0095\37\uffff\1\u0094",
            "\1\u0097\37\uffff\1\u0096",
            "\1\u0097\37\uffff\1\u0096",
            "\1\u0099\37\uffff\1\u0098",
            "\1\u0099\37\uffff\1\u0098",
            "",
            "\1\u009b\37\uffff\1\u009a",
            "\1\u009b\37\uffff\1\u009a",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u009e\37\uffff\1\u009d",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u009e\37\uffff\1\u009d",
            "\1\u00a0\37\uffff\1\u009f",
            "\1\u00a0\37\uffff\1\u009f",
            "\1\u00a2\37\uffff\1\u00a1",
            "\1\u00a2\37\uffff\1\u00a1",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u00a5\37\uffff\1\u00a4",
            "\1\u00a5\37\uffff\1\u00a4",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u00a8\37\uffff\1\u00a7",
            "\1\u00a8\37\uffff\1\u00a7",
            "",
            "\44\171\1\177\6\171\1\175\1\171\1\176\1\171\1\u0080\12\u0081"+
            "\7\171\32\173\4\171\1\174\1\171\32\172\uff85\171",
            "\44\171\1\177\6\171\1\175\1\171\1\176\1\171\1\u0080\12\u0081"+
            "\7\171\32\173\4\171\1\174\1\171\32\172\uff85\171",
            "\44\171\1\177\6\171\1\175\1\171\1\176\1\171\1\u0080\12\u0081"+
            "\7\171\32\173\4\171\1\174\1\171\32\172\uff85\171",
            "\44\171\1\177\6\171\1\175\1\171\1\176\1\171\1\u0080\12\u0081"+
            "\7\171\32\173\4\171\1\174\1\171\32\172\uff85\171",
            "\44\171\1\177\6\171\1\175\1\171\1\176\1\171\1\u0080\12\u0081"+
            "\7\171\32\173\4\171\1\174\1\171\32\172\uff85\171",
            "\44\171\1\177\6\171\1\175\1\171\1\176\1\171\1\u0080\12\u0081"+
            "\7\171\32\173\4\171\1\174\1\171\32\172\uff85\171",
            "\44\171\1\177\6\171\1\175\1\171\1\176\1\171\1\u0080\12\u0081"+
            "\7\171\32\173\4\171\1\174\1\171\32\172\uff85\171",
            "\44\171\1\177\6\171\1\175\1\171\1\176\1\171\1\u0080\12\u0081"+
            "\7\171\32\173\4\171\1\174\1\171\32\172\uff85\171",
            "\1\u00aa\37\uffff\1\u00a9",
            "\1\u00aa\37\uffff\1\u00a9",
            "\1\u00ac\37\uffff\1\u00ab",
            "\1\u00ac\37\uffff\1\u00ab",
            "\1\u00ae\37\uffff\1\u00ad",
            "\1\u00b0\37\uffff\1\u00af",
            "\1\u00ae\37\uffff\1\u00ad",
            "\1\u00b0\37\uffff\1\u00af",
            "\1\u00b2\37\uffff\1\u00b1",
            "\1\u00b2\37\uffff\1\u00b1",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u00b5\37\uffff\1\u00b4",
            "\1\u00b5\37\uffff\1\u00b4",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u00b8\37\uffff\1\u00b7",
            "\1\u00b8\37\uffff\1\u00b7",
            "\1\u00ba\37\uffff\1\u00b9",
            "\1\u00ba\37\uffff\1\u00b9",
            "\1\u00bc\37\uffff\1\u00bb",
            "\1\u00bc\37\uffff\1\u00bb",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u00bf\37\uffff\1\u00be",
            "\1\u00bf\37\uffff\1\u00be",
            "",
            "\1\u00c1\37\uffff\1\u00c0",
            "\1\u00c1\37\uffff\1\u00c0",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u00c4\37\uffff\1\u00c3",
            "\1\u00c4\37\uffff\1\u00c3",
            "",
            "\1\u00c6\37\uffff\1\u00c5",
            "\1\u00c6\37\uffff\1\u00c5",
            "",
            "\1\u00c8\37\uffff\1\u00c7",
            "\1\u00c8\37\uffff\1\u00c7",
            "\1\u00ca\37\uffff\1\u00c9",
            "\1\u00ca\37\uffff\1\u00c9",
            "\1\u00cc\37\uffff\1\u00cb",
            "\1\u00cc\37\uffff\1\u00cb",
            "\1\u00ce\37\uffff\1\u00cd",
            "\1\u00ce\37\uffff\1\u00cd",
            "\1\u00d0\37\uffff\1\u00cf",
            "\1\u00d0\37\uffff\1\u00cf",
            "\1\u00d2\37\uffff\1\u00d1",
            "\1\u00d2\37\uffff\1\u00d1",
            "",
            "\1\u00d4\37\uffff\1\u00d3",
            "\1\u00d4\37\uffff\1\u00d3",
            "",
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
            "\1\u00d9\37\uffff\1\u00d8",
            "\1\u00d9\37\uffff\1\u00d8",
            "\1\u00db\37\uffff\1\u00da",
            "\1\u00db\37\uffff\1\u00da",
            "",
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
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u00e4\37\uffff\1\u00e3",
            "\1\u00e4\37\uffff\1\u00e3",
            "\1\u00e6\37\uffff\1\u00e5",
            "\1\u00e6\37\uffff\1\u00e5",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u00e9\37\uffff\1\u00e8",
            "\1\u00e9\37\uffff\1\u00e8",
            "",
            "",
            "",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u00ec\37\uffff\1\u00eb",
            "\1\u00ec\37\uffff\1\u00eb",
            "",
            "\1\u00ee\37\uffff\1\u00ed",
            "\1\u00ee\37\uffff\1\u00ed",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "",
            "",
            "\1\u00f1\37\uffff\1\u00f0",
            "\1\u00f1\37\uffff\1\u00f0",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "",
            "\2\u00f4\1\uffff\2\u00f4\17\uffff\1\u00f4\2\uffff\1\u00f4\1"+
            "\uffff\1\u00f4\1\uffff\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff"+
            "\13\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\2\u00f4\1\uffff\2\u00f4\17\uffff\1\u00f4\2\uffff\1\u00f4\1"+
            "\uffff\1\u00f4\1\uffff\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff"+
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
            "\1\u00f8\37\uffff\1\u00f7",
            "\1\u00f8\37\uffff\1\u00f7",
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

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( SEMICOLON | COLON | COMMA | PERIOD | EQUALS | LPAREN | RPAREN | LBRACKET | RBRACKET | LBRACE | RBRACE | LANGLE | RANGLE | AMPERSAND | DBLQUOTE | DESIGN | DEVICE | SUBDESIGN | INST | SUBINST | GROUP | THIS | OF | NET | ATTR | NEWATTR | BEGIN | END | COMBINE | INCLUDE | INFO | PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN | INT | IDENT | PINNUM | STRING | WHITESPACE | LINE_COMMENT | MULTILINE_COMMENT | INCLUDE_DECL );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA10_15 = input.LA(1);

                        s = -1;
                        if ( ((LA10_15>='\u0000' && LA10_15<='\uFFFF')) ) {s = 45;}

                        else s = 44;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA10_128 = input.LA(1);

                        s = -1;
                        if ( ((LA10_128>='\u0000' && LA10_128<='#')||(LA10_128>='%' && LA10_128<='*')||LA10_128==','||LA10_128=='.'||(LA10_128>=':' && LA10_128<='@')||(LA10_128>='[' && LA10_128<='^')||LA10_128=='`'||(LA10_128>='{' && LA10_128<='\uFFFF')) ) {s = 121;}

                        else if ( ((LA10_128>='a' && LA10_128<='z')) ) {s = 122;}

                        else if ( ((LA10_128>='A' && LA10_128<='Z')) ) {s = 123;}

                        else if ( (LA10_128=='_') ) {s = 124;}

                        else if ( (LA10_128=='+') ) {s = 125;}

                        else if ( (LA10_128=='-') ) {s = 126;}

                        else if ( (LA10_128=='$') ) {s = 127;}

                        else if ( (LA10_128=='/') ) {s = 128;}

                        else if ( ((LA10_128>='0' && LA10_128<='9')) ) {s = 129;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA10_127 = input.LA(1);

                        s = -1;
                        if ( ((LA10_127>='\u0000' && LA10_127<='#')||(LA10_127>='%' && LA10_127<='*')||LA10_127==','||LA10_127=='.'||(LA10_127>=':' && LA10_127<='@')||(LA10_127>='[' && LA10_127<='^')||LA10_127=='`'||(LA10_127>='{' && LA10_127<='\uFFFF')) ) {s = 121;}

                        else if ( ((LA10_127>='a' && LA10_127<='z')) ) {s = 122;}

                        else if ( ((LA10_127>='A' && LA10_127<='Z')) ) {s = 123;}

                        else if ( (LA10_127=='_') ) {s = 124;}

                        else if ( (LA10_127=='+') ) {s = 125;}

                        else if ( (LA10_127=='-') ) {s = 126;}

                        else if ( (LA10_127=='$') ) {s = 127;}

                        else if ( (LA10_127=='/') ) {s = 128;}

                        else if ( ((LA10_127>='0' && LA10_127<='9')) ) {s = 129;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA10_126 = input.LA(1);

                        s = -1;
                        if ( ((LA10_126>='\u0000' && LA10_126<='#')||(LA10_126>='%' && LA10_126<='*')||LA10_126==','||LA10_126=='.'||(LA10_126>=':' && LA10_126<='@')||(LA10_126>='[' && LA10_126<='^')||LA10_126=='`'||(LA10_126>='{' && LA10_126<='\uFFFF')) ) {s = 121;}

                        else if ( ((LA10_126>='a' && LA10_126<='z')) ) {s = 122;}

                        else if ( ((LA10_126>='A' && LA10_126<='Z')) ) {s = 123;}

                        else if ( (LA10_126=='_') ) {s = 124;}

                        else if ( (LA10_126=='+') ) {s = 125;}

                        else if ( (LA10_126=='-') ) {s = 126;}

                        else if ( (LA10_126=='$') ) {s = 127;}

                        else if ( (LA10_126=='/') ) {s = 128;}

                        else if ( ((LA10_126>='0' && LA10_126<='9')) ) {s = 129;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA10_125 = input.LA(1);

                        s = -1;
                        if ( ((LA10_125>='\u0000' && LA10_125<='#')||(LA10_125>='%' && LA10_125<='*')||LA10_125==','||LA10_125=='.'||(LA10_125>=':' && LA10_125<='@')||(LA10_125>='[' && LA10_125<='^')||LA10_125=='`'||(LA10_125>='{' && LA10_125<='\uFFFF')) ) {s = 121;}

                        else if ( ((LA10_125>='a' && LA10_125<='z')) ) {s = 122;}

                        else if ( ((LA10_125>='A' && LA10_125<='Z')) ) {s = 123;}

                        else if ( (LA10_125=='_') ) {s = 124;}

                        else if ( (LA10_125=='+') ) {s = 125;}

                        else if ( (LA10_125=='-') ) {s = 126;}

                        else if ( (LA10_125=='$') ) {s = 127;}

                        else if ( (LA10_125=='/') ) {s = 128;}

                        else if ( ((LA10_125>='0' && LA10_125<='9')) ) {s = 129;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA10_124 = input.LA(1);

                        s = -1;
                        if ( ((LA10_124>='\u0000' && LA10_124<='#')||(LA10_124>='%' && LA10_124<='*')||LA10_124==','||LA10_124=='.'||(LA10_124>=':' && LA10_124<='@')||(LA10_124>='[' && LA10_124<='^')||LA10_124=='`'||(LA10_124>='{' && LA10_124<='\uFFFF')) ) {s = 121;}

                        else if ( ((LA10_124>='a' && LA10_124<='z')) ) {s = 122;}

                        else if ( ((LA10_124>='A' && LA10_124<='Z')) ) {s = 123;}

                        else if ( (LA10_124=='_') ) {s = 124;}

                        else if ( (LA10_124=='+') ) {s = 125;}

                        else if ( (LA10_124=='-') ) {s = 126;}

                        else if ( (LA10_124=='$') ) {s = 127;}

                        else if ( (LA10_124=='/') ) {s = 128;}

                        else if ( ((LA10_124>='0' && LA10_124<='9')) ) {s = 129;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA10_123 = input.LA(1);

                        s = -1;
                        if ( ((LA10_123>='\u0000' && LA10_123<='#')||(LA10_123>='%' && LA10_123<='*')||LA10_123==','||LA10_123=='.'||(LA10_123>=':' && LA10_123<='@')||(LA10_123>='[' && LA10_123<='^')||LA10_123=='`'||(LA10_123>='{' && LA10_123<='\uFFFF')) ) {s = 121;}

                        else if ( ((LA10_123>='a' && LA10_123<='z')) ) {s = 122;}

                        else if ( ((LA10_123>='A' && LA10_123<='Z')) ) {s = 123;}

                        else if ( (LA10_123=='_') ) {s = 124;}

                        else if ( (LA10_123=='+') ) {s = 125;}

                        else if ( (LA10_123=='-') ) {s = 126;}

                        else if ( (LA10_123=='$') ) {s = 127;}

                        else if ( (LA10_123=='/') ) {s = 128;}

                        else if ( ((LA10_123>='0' && LA10_123<='9')) ) {s = 129;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA10_122 = input.LA(1);

                        s = -1;
                        if ( ((LA10_122>='\u0000' && LA10_122<='#')||(LA10_122>='%' && LA10_122<='*')||LA10_122==','||LA10_122=='.'||(LA10_122>=':' && LA10_122<='@')||(LA10_122>='[' && LA10_122<='^')||LA10_122=='`'||(LA10_122>='{' && LA10_122<='\uFFFF')) ) {s = 121;}

                        else if ( ((LA10_122>='a' && LA10_122<='z')) ) {s = 122;}

                        else if ( ((LA10_122>='A' && LA10_122<='Z')) ) {s = 123;}

                        else if ( (LA10_122=='_') ) {s = 124;}

                        else if ( (LA10_122=='+') ) {s = 125;}

                        else if ( (LA10_122=='-') ) {s = 126;}

                        else if ( (LA10_122=='$') ) {s = 127;}

                        else if ( (LA10_122=='/') ) {s = 128;}

                        else if ( ((LA10_122>='0' && LA10_122<='9')) ) {s = 129;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA10_78 = input.LA(1);

                        s = -1;
                        if ( ((LA10_78>='\u0000' && LA10_78<='#')||(LA10_78>='%' && LA10_78<='*')||LA10_78==','||LA10_78=='.'||(LA10_78>=':' && LA10_78<='@')||(LA10_78>='[' && LA10_78<='^')||LA10_78=='`'||(LA10_78>='{' && LA10_78<='\uFFFF')) ) {s = 121;}

                        else if ( ((LA10_78>='a' && LA10_78<='z')) ) {s = 122;}

                        else if ( ((LA10_78>='A' && LA10_78<='Z')) ) {s = 123;}

                        else if ( (LA10_78=='_') ) {s = 124;}

                        else if ( (LA10_78=='+') ) {s = 125;}

                        else if ( (LA10_78=='-') ) {s = 126;}

                        else if ( (LA10_78=='$') ) {s = 127;}

                        else if ( (LA10_78=='/') ) {s = 128;}

                        else if ( ((LA10_78>='0' && LA10_78<='9')) ) {s = 129;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA10_129 = input.LA(1);

                        s = -1;
                        if ( ((LA10_129>='\u0000' && LA10_129<='#')||(LA10_129>='%' && LA10_129<='*')||LA10_129==','||LA10_129=='.'||(LA10_129>=':' && LA10_129<='@')||(LA10_129>='[' && LA10_129<='^')||LA10_129=='`'||(LA10_129>='{' && LA10_129<='\uFFFF')) ) {s = 121;}

                        else if ( ((LA10_129>='a' && LA10_129<='z')) ) {s = 122;}

                        else if ( ((LA10_129>='A' && LA10_129<='Z')) ) {s = 123;}

                        else if ( (LA10_129=='_') ) {s = 124;}

                        else if ( (LA10_129=='+') ) {s = 125;}

                        else if ( (LA10_129=='-') ) {s = 126;}

                        else if ( (LA10_129=='$') ) {s = 127;}

                        else if ( (LA10_129=='/') ) {s = 128;}

                        else if ( ((LA10_129>='0' && LA10_129<='9')) ) {s = 129;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 10, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}