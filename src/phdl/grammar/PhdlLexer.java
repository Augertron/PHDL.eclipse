// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g 2012-03-21 16:59:06

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

public class PhdlLexer extends Lexer {
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
    public static final int PORT=35;
    public static final int OPEN=36;
    public static final int PIN=37;
    public static final int INPIN=38;
    public static final int OUTPIN=39;
    public static final int IOPIN=40;
    public static final int PWRPIN=41;
    public static final int SUPPIN=42;
    public static final int DEVICE_DECL=43;
    public static final int DESIGN_DECL=44;
    public static final int SUBDESIGN_DECL=45;
    public static final int ATTR_DECL=46;
    public static final int PIN_DECL=47;
    public static final int PORT_DECL=48;
    public static final int NET_DECL=49;
    public static final int INST_DECL=50;
    public static final int SUBINST_DECL=51;
    public static final int GROUP_DECL=52;
    public static final int INFO_DECL=53;
    public static final int ATTR_ASSIGN=54;
    public static final int SUBATTR_ASSIGN=55;
    public static final int PIN_ASSIGN=56;
    public static final int PORT_ASSIGN=57;
    public static final int CONNECT_ASSIGN=58;
    public static final int CONCAT_LIST=59;
    public static final int CONCAT_REPL=60;
    public static final int CONCAT_OPEN=61;
    public static final int WIDTH=62;
    public static final int PIN_LIST=63;
    public static final int PIN_TYPE=64;
    public static final int BOUNDS=65;
    public static final int INDICES=66;
    public static final int OPERAND=67;
    public static final int NAME=68;
    public static final int IDENT=69;
    public static final int STRING=70;
    public static final int INT=71;
    public static final int PINNUM=72;
    public static final int A=73;
    public static final int B=74;
    public static final int C=75;
    public static final int D=76;
    public static final int E=77;
    public static final int F=78;
    public static final int G=79;
    public static final int H=80;
    public static final int I=81;
    public static final int J=82;
    public static final int K=83;
    public static final int L=84;
    public static final int M=85;
    public static final int N=86;
    public static final int O=87;
    public static final int P=88;
    public static final int Q=89;
    public static final int R=90;
    public static final int S=91;
    public static final int T=92;
    public static final int U=93;
    public static final int V=94;
    public static final int W=95;
    public static final int X=96;
    public static final int Y=97;
    public static final int Z=98;
    public static final int CHAR=99;
    public static final int DIGIT=100;
    public static final int ESC=101;
    public static final int WHITESPACE=102;
    public static final int LINE_COMMENT=103;
    public static final int MULTILINE_COMMENT=104;
    public static final int INCLUDE_DECL=105;


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
    	
    	private List<String> errors = new ArrayList<String>();
    	
    	/** The stack of saved character streams */
    	private Stack<SaveStruct> includes = new Stack<SaveStruct>();
    	
    	/** The set of included file names to check for duplicate include statements */
    	private Set<String> includeNames = new HashSet<String>();
    	
    	/** getter and setter for above includeNames field */
    	public Set<String> getIncludeNames() {
    		return includeNames;
    	}
    	public void setIncludeNames(Set<String> includeNames) {
    		this.includeNames = includeNames;
    	}
    	
    	private String directory;
    	
    	public void setDirectory(String directory) {
    		this.directory = directory;
    	}
    	
    	public String getDirectory() {
    		return directory;
    	}
    	
    	public List<String> getErrors() {
    		return errors;
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
    	
    	private void bailOut(CommonToken ct, String message) {
       		System.out.println("ERROR: " + ct.getInputStream().getSourceName() + " line "
       				+ ct.getLine() + ":" + ct.getCharPositionInLine() + " " + message + ": "
       				+ ct.getText());
       		System.exit(1);
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
    public String getGrammarFileName() { return "C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g"; }

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:110:11: ( ';' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:110:13: ';'
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:111:7: ( ':' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:111:9: ':'
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:112:7: ( ',' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:112:9: ','
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:113:8: ( '.' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:113:10: '.'
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:114:8: ( '=' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:114:10: '='
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:115:8: ( '(' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:115:10: '('
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:116:8: ( ')' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:116:10: ')'
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:117:10: ( '[' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:117:12: '['
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:118:10: ( ']' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:118:12: ']'
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:119:8: ( '{' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:119:10: '{'
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:120:8: ( '}' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:120:10: '}'
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:121:8: ( '<' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:121:10: '<'
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:122:8: ( '>' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:122:10: '>'
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:123:11: ( '&' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:123:13: '&'
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:124:10: ( '\"' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:124:12: '\"'
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:532:7: ( 'design' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:532:9: 'design'
            {
            match("design"); 


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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:533:7: ( 'device' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:533:9: 'device'
            {
            match("device"); 


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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:534:10: ( 'subdesign' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:534:12: 'subdesign'
            {
            match("subdesign"); 


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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:535:5: ( 'inst' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:535:7: 'inst'
            {
            match("inst"); 


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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:536:8: ( 'subinst' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:536:10: 'subinst'
            {
            match("subinst"); 


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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:537:6: ( 'group' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:537:8: 'group'
            {
            match("group"); 


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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:538:5: ( 'this' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:538:7: 'this'
            {
            match("this"); 


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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:539:3: ( 'of' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:539:5: 'of'
            {
            match("of"); 


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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:540:4: ( 'net' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:540:6: 'net'
            {
            match("net"); 


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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:541:5: ( 'attr' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:541:7: 'attr'
            {
            match("attr"); 


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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:542:8: ( 'newattr' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:542:10: 'newattr'
            {
            match("newattr"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEWATTR"

    // $ANTLR start "COMBINE"
    public final void mCOMBINE() throws RecognitionException {
        try {
            int _type = COMBINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:543:8: ( 'combine' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:543:10: 'combine'
            {
            match("combine"); 


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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:544:8: ( 'include' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:544:10: 'include'
            {
            match("include"); 


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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:545:5: ( 'info' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:545:7: 'info'
            {
            match("info"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INFO"

    // $ANTLR start "OPEN"
    public final void mOPEN() throws RecognitionException {
        try {
            int _type = OPEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:546:5: ( 'open' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:546:7: 'open'
            {
            match("open"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OPEN"

    // $ANTLR start "PORT"
    public final void mPORT() throws RecognitionException {
        try {
            int _type = PORT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:547:5: ( 'port' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:547:7: 'port'
            {
            match("port"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PORT"

    // $ANTLR start "PIN"
    public final void mPIN() throws RecognitionException {
        try {
            int _type = PIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:550:4: ( 'pin' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:550:6: 'pin'
            {
            match("pin"); 


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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:551:6: ( 'inpin' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:551:8: 'inpin'
            {
            match("inpin"); 


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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:552:7: ( 'outpin' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:552:9: 'outpin'
            {
            match("outpin"); 


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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:553:6: ( 'iopin' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:553:8: 'iopin'
            {
            match("iopin"); 


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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:554:7: ( 'pwrpin' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:554:9: 'pwrpin'
            {
            match("pwrpin"); 


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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:555:7: ( 'suppin' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:555:9: 'suppin'
            {
            match("suppin"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUPPIN"

    // $ANTLR start "A"
    public final void mA() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:558:11: ( ( 'a' | 'A' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:558:12: ( 'a' | 'A' )
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:559:11: ( ( 'b' | 'B' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:559:12: ( 'b' | 'B' )
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:560:11: ( ( 'c' | 'C' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:560:12: ( 'c' | 'C' )
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:561:11: ( ( 'd' | 'D' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:561:12: ( 'd' | 'D' )
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:562:11: ( ( 'e' | 'E' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:562:12: ( 'e' | 'E' )
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:563:11: ( ( 'f' | 'F' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:563:12: ( 'f' | 'F' )
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:564:11: ( ( 'g' | 'G' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:564:12: ( 'g' | 'G' )
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:565:11: ( ( 'h' | 'H' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:565:12: ( 'h' | 'H' )
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:566:11: ( ( 'i' | 'I' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:566:12: ( 'i' | 'I' )
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:567:11: ( ( 'j' | 'J' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:567:12: ( 'j' | 'J' )
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:568:11: ( ( 'k' | 'K' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:568:12: ( 'k' | 'K' )
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:569:11: ( ( 'l' | 'L' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:569:12: ( 'l' | 'L' )
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:570:11: ( ( 'm' | 'M' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:570:12: ( 'm' | 'M' )
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:571:11: ( ( 'n' | 'N' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:571:12: ( 'n' | 'N' )
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:572:11: ( ( 'o' | 'O' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:572:12: ( 'o' | 'O' )
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:573:11: ( ( 'p' | 'P' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:573:12: ( 'p' | 'P' )
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:574:11: ( ( 'q' | 'Q' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:574:12: ( 'q' | 'Q' )
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:575:11: ( ( 'r' | 'R' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:575:12: ( 'r' | 'R' )
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:576:11: ( ( 's' | 'S' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:576:12: ( 's' | 'S' )
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:577:11: ( ( 't' | 'T' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:577:12: ( 't' | 'T' )
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:578:11: ( ( 'u' | 'U' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:578:12: ( 'u' | 'U' )
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:579:11: ( ( 'v' | 'V' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:579:12: ( 'v' | 'V' )
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:580:11: ( ( 'w' | 'W' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:580:12: ( 'w' | 'W' )
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:581:11: ( ( 'x' | 'X' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:581:12: ( 'x' | 'X' )
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:582:11: ( ( 'y' | 'Y' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:582:12: ( 'y' | 'Y' )
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:583:11: ( ( 'z' | 'Z' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:583:12: ( 'z' | 'Z' )
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

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:585:15: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' | '+' | '-' | '$' | '/' )
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:585:17: ( 'a' .. 'z' )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:585:17: ( 'a' .. 'z' )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:585:18: 'a' .. 'z'
                    {
                    matchRange('a','z'); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:585:30: ( 'A' .. 'Z' )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:585:30: ( 'A' .. 'Z' )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:585:31: 'A' .. 'Z'
                    {
                    matchRange('A','Z'); 

                    }


                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:585:43: '_'
                    {
                    match('_'); 

                    }
                    break;
                case 4 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:585:49: '+'
                    {
                    match('+'); 

                    }
                    break;
                case 5 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:585:55: '-'
                    {
                    match('-'); 

                    }
                    break;
                case 6 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:585:61: '$'
                    {
                    match('$'); 

                    }
                    break;
                case 7 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:585:67: '/'
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:586:16: ( ( '0' .. '9' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:586:18: ( '0' .. '9' )
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:586:18: ( '0' .. '9' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:586:19: '0' .. '9'
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:588:4: ( ( DIGIT )+ )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:588:6: ( DIGIT )+
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:588:6: ( DIGIT )+
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:588:6: DIGIT
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:589:6: ( CHAR ( CHAR | DIGIT )* )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:589:8: CHAR ( CHAR | DIGIT )*
            {
            mCHAR(); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:589:13: ( CHAR | DIGIT )*
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:589:14: CHAR
            	    {
            	    mCHAR(); 

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:589:21: DIGIT
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:590:7: ( DIGIT ( CHAR )+ )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:590:9: DIGIT ( CHAR )+
            {
            mDIGIT(); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:590:15: ( CHAR )+
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:590:15: CHAR
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
            CommonToken escaped=null;
            int normal;

            StringBuilder lBuf = new StringBuilder();
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:594:5: ( DBLQUOTE (escaped= ESC | normal=~ ( DBLQUOTE | '\\\\' ) )* DBLQUOTE )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:594:9: DBLQUOTE (escaped= ESC | normal=~ ( DBLQUOTE | '\\\\' ) )* DBLQUOTE
            {
            mDBLQUOTE(); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:595:3: (escaped= ESC | normal=~ ( DBLQUOTE | '\\\\' ) )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\\') ) {
                    alt5=1;
                }
                else if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:595:5: escaped= ESC
            	    {
            	    int escapedStart750 = getCharIndex();
            	    int escapedStartLine750 = getLine();
            	    int escapedStartCharPos750 = getCharPositionInLine();
            	    mESC(); 
            	    escaped = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, escapedStart750, getCharIndex()-1);
            	    escaped.setLine(escapedStartLine750);
            	    escaped.setCharPositionInLine(escapedStartCharPos750);
            	    lBuf.append(escaped.getText());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:596:5: normal=~ ( DBLQUOTE | '\\\\' )
            	    {
            	    normal= input.LA(1);
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}

            	    lBuf.appendCodePoint(normal);

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            mDBLQUOTE(); 
            setText(lBuf.toString());

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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:607:2: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' | '\\u001D' )+ )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:607:4: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' | '\\u001D' )+
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:607:4: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' | '\\u001D' )+
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:615:2: ( '//' (~ ( '\\n' | '\\r' ) )* )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:615:4: '//' (~ ( '\\n' | '\\r' ) )*
            {
            match("//"); 

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:615:9: (~ ( '\\n' | '\\r' ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\u0000' && LA7_0<='\t')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:615:9: ~ ( '\\n' | '\\r' )
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
            	    break loop7;
                }
            } while (true);

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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:623:2: ( '/*' ( . )* '*/' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:623:4: '/*' ( . )* '*/'
            {
            match("/*"); 

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:623:9: ( . )*
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:623:9: .
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

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:637:2: ( INCLUDE ( WHITESPACE )? fileName= STRING )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:637:5: INCLUDE ( WHITESPACE )? fileName= STRING
            {
            mINCLUDE(); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:637:13: ( WHITESPACE )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>='\t' && LA9_0<='\n')||(LA9_0>='\f' && LA9_0<='\r')||LA9_0=='\u001D'||LA9_0==' ') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:637:13: WHITESPACE
                    {
                    mWHITESPACE(); 

                    }
                    break;

            }

            int fileNameStart912 = getCharIndex();
            int fileNameStartLine912 = getLine();
            int fileNameStartCharPos912 = getCharPositionInLine();
            mSTRING(); 
            fileName = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, fileNameStart912, getCharIndex()-1);
            fileName.setLine(fileNameStartLine912);
            fileName.setCharPositionInLine(fileNameStartCharPos912);
            	String name = fileName.getText();
            			name = name.substring(1,name.length()-1);
            			if (directory != null)
            				name = directory + "\\" + name;
            			System.out.println("  -- Including: " + ((directory != null)?("\\" + name):(name)));
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

    // $ANTLR start "ESC"
    public final void mESC() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:670:2: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '/' | '\\\\' ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:670:4: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '/' | '\\\\' )
            {
            match('\\'); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:671:3: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '/' | '\\\\' )
            int alt10=9;
            switch ( input.LA(1) ) {
            case 'n':
                {
                alt10=1;
                }
                break;
            case 'r':
                {
                alt10=2;
                }
                break;
            case 't':
                {
                alt10=3;
                }
                break;
            case 'b':
                {
                alt10=4;
                }
                break;
            case 'f':
                {
                alt10=5;
                }
                break;
            case '\"':
                {
                alt10=6;
                }
                break;
            case '\'':
                {
                alt10=7;
                }
                break;
            case '/':
                {
                alt10=8;
                }
                break;
            case '\\':
                {
                alt10=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:671:5: 'n'
                    {
                    match('n'); 
                    setText("\n");

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:672:5: 'r'
                    {
                    match('r'); 
                    setText("\r");

                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:673:5: 't'
                    {
                    match('t'); 
                    setText("\t");

                    }
                    break;
                case 4 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:674:5: 'b'
                    {
                    match('b'); 
                    setText("\b");

                    }
                    break;
                case 5 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:675:5: 'f'
                    {
                    match('f'); 
                    setText("\f");

                    }
                    break;
                case 6 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:676:5: '\"'
                    {
                    match('\"'); 
                    setText("\"");

                    }
                    break;
                case 7 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:677:5: '\\''
                    {
                    match('\''); 
                    setText("\'");

                    }
                    break;
                case 8 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:678:5: '/'
                    {
                    match('/'); 
                    setText("/");

                    }
                    break;
                case 9 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:679:5: '\\\\'
                    {
                    match('\\'); 
                    setText("\\");

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "ESC"

    public void mTokens() throws RecognitionException {
        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:8: ( SEMICOLON | COLON | COMMA | PERIOD | EQUALS | LPAREN | RPAREN | LBRACKET | RBRACKET | LBRACE | RBRACE | LANGLE | RANGLE | AMPERSAND | DBLQUOTE | DESIGN | DEVICE | SUBDESIGN | INST | SUBINST | GROUP | THIS | OF | NET | ATTR | NEWATTR | COMBINE | INCLUDE | INFO | OPEN | PORT | PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN | INT | IDENT | PINNUM | STRING | WHITESPACE | LINE_COMMENT | MULTILINE_COMMENT | INCLUDE_DECL )
        int alt11=45;
        alt11 = dfa11.predict(input);
        switch (alt11) {
            case 1 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:10: SEMICOLON
                {
                mSEMICOLON(); 

                }
                break;
            case 2 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:20: COLON
                {
                mCOLON(); 

                }
                break;
            case 3 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:26: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 4 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:32: PERIOD
                {
                mPERIOD(); 

                }
                break;
            case 5 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:39: EQUALS
                {
                mEQUALS(); 

                }
                break;
            case 6 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:46: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 7 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:53: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 8 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:60: LBRACKET
                {
                mLBRACKET(); 

                }
                break;
            case 9 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:69: RBRACKET
                {
                mRBRACKET(); 

                }
                break;
            case 10 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:78: LBRACE
                {
                mLBRACE(); 

                }
                break;
            case 11 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:85: RBRACE
                {
                mRBRACE(); 

                }
                break;
            case 12 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:92: LANGLE
                {
                mLANGLE(); 

                }
                break;
            case 13 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:99: RANGLE
                {
                mRANGLE(); 

                }
                break;
            case 14 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:106: AMPERSAND
                {
                mAMPERSAND(); 

                }
                break;
            case 15 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:116: DBLQUOTE
                {
                mDBLQUOTE(); 

                }
                break;
            case 16 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:125: DESIGN
                {
                mDESIGN(); 

                }
                break;
            case 17 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:132: DEVICE
                {
                mDEVICE(); 

                }
                break;
            case 18 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:139: SUBDESIGN
                {
                mSUBDESIGN(); 

                }
                break;
            case 19 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:149: INST
                {
                mINST(); 

                }
                break;
            case 20 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:154: SUBINST
                {
                mSUBINST(); 

                }
                break;
            case 21 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:162: GROUP
                {
                mGROUP(); 

                }
                break;
            case 22 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:168: THIS
                {
                mTHIS(); 

                }
                break;
            case 23 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:173: OF
                {
                mOF(); 

                }
                break;
            case 24 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:176: NET
                {
                mNET(); 

                }
                break;
            case 25 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:180: ATTR
                {
                mATTR(); 

                }
                break;
            case 26 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:185: NEWATTR
                {
                mNEWATTR(); 

                }
                break;
            case 27 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:193: COMBINE
                {
                mCOMBINE(); 

                }
                break;
            case 28 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:201: INCLUDE
                {
                mINCLUDE(); 

                }
                break;
            case 29 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:209: INFO
                {
                mINFO(); 

                }
                break;
            case 30 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:214: OPEN
                {
                mOPEN(); 

                }
                break;
            case 31 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:219: PORT
                {
                mPORT(); 

                }
                break;
            case 32 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:224: PIN
                {
                mPIN(); 

                }
                break;
            case 33 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:228: INPIN
                {
                mINPIN(); 

                }
                break;
            case 34 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:234: OUTPIN
                {
                mOUTPIN(); 

                }
                break;
            case 35 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:241: IOPIN
                {
                mIOPIN(); 

                }
                break;
            case 36 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:247: PWRPIN
                {
                mPWRPIN(); 

                }
                break;
            case 37 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:254: SUPPIN
                {
                mSUPPIN(); 

                }
                break;
            case 38 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:261: INT
                {
                mINT(); 

                }
                break;
            case 39 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:265: IDENT
                {
                mIDENT(); 

                }
                break;
            case 40 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:271: PINNUM
                {
                mPINNUM(); 

                }
                break;
            case 41 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:278: STRING
                {
                mSTRING(); 

                }
                break;
            case 42 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:285: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 43 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:296: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;
            case 44 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:309: MULTILINE_COMMENT
                {
                mMULTILINE_COMMENT(); 

                }
                break;
            case 45 :
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:1:327: INCLUDE_DECL
                {
                mINCLUDE_DECL(); 

                }
                break;

        }

    }


    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA11_eotS =
        "\17\uffff\1\36\12\33\1\57\1\uffff\1\33\3\uffff\6\33\1\76\10\33"+
        "\2\uffff\1\33\1\uffff\13\33\1\uffff\2\33\1\137\4\33\1\144\11\33"+
        "\1\uffff\5\33\1\153\1\33\1\155\3\33\1\161\1\162\1\33\1\uffff\1\33"+
        "\1\165\1\33\1\167\1\uffff\6\33\1\uffff\1\33\1\uffff\1\177\1\u0080"+
        "\1\u0081\2\uffff\2\33\1\uffff\1\33\1\uffff\1\33\1\u0086\1\u0087"+
        "\2\33\1\u008a\1\33\3\uffff\1\u008c\2\33\1\u008f\2\uffff\1\33\1\u0091"+
        "\1\uffff\1\u0092\1\uffff\1\u0094\1\u0095\1\uffff\1\33\5\uffff\1"+
        "\u0097\1\uffff";
    static final String DFA11_eofS =
        "\u0098\uffff";
    static final String DFA11_minS =
        "\1\11\16\uffff\1\0\1\145\1\165\1\156\1\162\1\150\1\146\1\145\1"+
        "\164\1\157\1\151\1\44\1\uffff\1\52\3\uffff\1\163\1\142\1\143\1\160"+
        "\1\157\1\151\1\44\1\145\3\164\1\155\1\162\1\156\1\162\2\uffff\1"+
        "\0\1\uffff\2\151\1\144\1\160\1\164\1\154\1\157\2\151\1\165\1\163"+
        "\1\uffff\1\156\1\160\1\44\1\141\1\162\1\142\1\164\1\44\1\160\10"+
        "\0\1\uffff\1\147\1\143\1\145\1\156\1\151\1\44\1\165\1\44\2\156\1"+
        "\160\2\44\1\151\1\uffff\1\164\1\44\1\151\1\44\1\uffff\1\151\1\156"+
        "\1\145\2\163\1\156\1\uffff\1\144\1\uffff\3\44\2\uffff\1\156\1\164"+
        "\1\uffff\1\156\1\uffff\1\156\2\44\1\151\1\164\1\44\1\145\3\uffff"+
        "\1\44\1\162\1\145\1\44\2\uffff\1\147\1\44\1\uffff\1\11\1\uffff\2"+
        "\44\1\uffff\1\156\5\uffff\1\44\1\uffff";
    static final String DFA11_maxS =
        "\1\175\16\uffff\1\uffff\1\145\1\165\1\157\1\162\1\150\1\165\1\145"+
        "\1\164\1\157\1\167\1\172\1\uffff\1\57\3\uffff\1\166\1\160\1\163"+
        "\1\160\1\157\1\151\1\172\1\145\1\164\1\167\1\164\1\155\1\162\1\156"+
        "\1\162\2\uffff\1\uffff\1\uffff\3\151\1\160\1\164\1\154\1\157\2\151"+
        "\1\165\1\163\1\uffff\1\156\1\160\1\172\1\141\1\162\1\142\1\164\1"+
        "\172\1\160\10\uffff\1\uffff\1\147\1\143\1\145\1\156\1\151\1\172"+
        "\1\165\1\172\2\156\1\160\2\172\1\151\1\uffff\1\164\1\172\1\151\1"+
        "\172\1\uffff\1\151\1\156\1\145\2\163\1\156\1\uffff\1\144\1\uffff"+
        "\3\172\2\uffff\1\156\1\164\1\uffff\1\156\1\uffff\1\156\2\172\1\151"+
        "\1\164\1\172\1\145\3\uffff\1\172\1\162\1\145\1\172\2\uffff\1\147"+
        "\1\172\1\uffff\1\172\1\uffff\2\172\1\uffff\1\156\5\uffff\1\172\1"+
        "\uffff";
    static final String DFA11_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1"+
        "\15\1\16\14\uffff\1\47\1\uffff\1\52\1\17\1\51\17\uffff\1\46\1\50"+
        "\1\uffff\1\54\13\uffff\1\27\21\uffff\1\53\16\uffff\1\30\4\uffff"+
        "\1\40\6\uffff\1\23\1\uffff\1\35\3\uffff\1\26\1\36\2\uffff\1\31\1"+
        "\uffff\1\37\7\uffff\1\41\1\43\1\25\4\uffff\1\20\1\21\2\uffff\1\45"+
        "\1\uffff\1\42\2\uffff\1\44\1\uffff\1\24\1\34\1\55\1\32\1\33\1\uffff"+
        "\1\22";
    static final String DFA11_specialS =
        "\17\uffff\1\11\41\uffff\1\7\26\uffff\1\1\1\2\1\0\1\5\1\6\1\3\1"+
        "\4\1\10\110\uffff}>";
    static final String[] DFA11_transitionS = {
            "\2\35\1\uffff\2\35\17\uffff\1\35\2\uffff\1\35\1\uffff\1\17"+
            "\1\uffff\1\33\1\uffff\1\16\1\uffff\1\6\1\7\1\uffff\1\33\1\3"+
            "\1\33\1\4\1\34\12\32\1\2\1\1\1\14\1\5\1\15\2\uffff\32\33\1\10"+
            "\1\uffff\1\11\1\uffff\1\33\1\uffff\1\27\1\33\1\30\1\20\2\33"+
            "\1\23\1\33\1\22\4\33\1\26\1\25\1\31\2\33\1\21\1\24\6\33\1\12"+
            "\1\uffff\1\13",
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
            "\0\37",
            "\1\40",
            "\1\41",
            "\1\42\1\43",
            "\1\44",
            "\1\45",
            "\1\46\11\uffff\1\47\4\uffff\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\55\5\uffff\1\54\7\uffff\1\56",
            "\1\60\6\uffff\1\60\1\uffff\1\60\1\uffff\1\60\21\uffff\32\60"+
            "\4\uffff\1\60\1\uffff\32\60",
            "",
            "\1\62\4\uffff\1\61",
            "",
            "",
            "",
            "\1\63\2\uffff\1\64",
            "\1\65\15\uffff\1\66",
            "\1\70\2\uffff\1\71\11\uffff\1\72\2\uffff\1\67",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "\1\77",
            "\1\100",
            "\1\101\2\uffff\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "",
            "",
            "\12\120\1\uffff\2\120\1\uffff\26\120\1\115\6\120\1\113\1\120"+
            "\1\114\1\120\1\116\12\117\7\120\32\111\4\120\1\112\1\120\32"+
            "\110\uff85\120",
            "",
            "\1\121",
            "\1\122",
            "\1\123\4\uffff\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "",
            "\1\135",
            "\1\136",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "\1\145",
            "\12\120\1\uffff\2\120\1\uffff\26\120\1\115\6\120\1\113\1\120"+
            "\1\114\1\120\1\116\12\117\7\120\32\111\4\120\1\112\1\120\32"+
            "\110\uff85\120",
            "\12\120\1\uffff\2\120\1\uffff\26\120\1\115\6\120\1\113\1\120"+
            "\1\114\1\120\1\116\12\117\7\120\32\111\4\120\1\112\1\120\32"+
            "\110\uff85\120",
            "\12\120\1\uffff\2\120\1\uffff\26\120\1\115\6\120\1\113\1\120"+
            "\1\114\1\120\1\116\12\117\7\120\32\111\4\120\1\112\1\120\32"+
            "\110\uff85\120",
            "\12\120\1\uffff\2\120\1\uffff\26\120\1\115\6\120\1\113\1\120"+
            "\1\114\1\120\1\116\12\117\7\120\32\111\4\120\1\112\1\120\32"+
            "\110\uff85\120",
            "\12\120\1\uffff\2\120\1\uffff\26\120\1\115\6\120\1\113\1\120"+
            "\1\114\1\120\1\116\12\117\7\120\32\111\4\120\1\112\1\120\32"+
            "\110\uff85\120",
            "\12\120\1\uffff\2\120\1\uffff\26\120\1\115\6\120\1\113\1\120"+
            "\1\114\1\120\1\116\12\117\7\120\32\111\4\120\1\112\1\120\32"+
            "\110\uff85\120",
            "\12\120\1\uffff\2\120\1\uffff\26\120\1\115\6\120\1\113\1\120"+
            "\1\114\1\120\1\116\12\117\7\120\32\111\4\120\1\112\1\120\32"+
            "\110\uff85\120",
            "\12\120\1\uffff\2\120\1\uffff\26\120\1\115\6\120\1\113\1\120"+
            "\1\114\1\120\1\116\12\117\7\120\32\111\4\120\1\112\1\120\32"+
            "\110\uff85\120",
            "",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "\1\154",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "\1\163",
            "",
            "\1\164",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "\1\166",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "",
            "\1\176",
            "",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "",
            "",
            "\1\u0082",
            "\1\u0083",
            "",
            "\1\u0084",
            "",
            "\1\u0085",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "\1\u0088",
            "\1\u0089",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "\1\u008b",
            "",
            "",
            "",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "\1\u008d",
            "\1\u008e",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "",
            "",
            "\1\u0090",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "",
            "\2\u0093\1\uffff\2\u0093\17\uffff\1\u0093\2\uffff\1\u0093"+
            "\1\uffff\1\u0093\1\uffff\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff"+
            "\13\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            "",
            "\1\u0096",
            "",
            "",
            "",
            "",
            "",
            "\1\33\6\uffff\1\33\1\uffff\1\33\1\uffff\13\33\7\uffff\32\33"+
            "\4\uffff\1\33\1\uffff\32\33",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( SEMICOLON | COLON | COMMA | PERIOD | EQUALS | LPAREN | RPAREN | LBRACKET | RBRACKET | LBRACE | RBRACE | LANGLE | RANGLE | AMPERSAND | DBLQUOTE | DESIGN | DEVICE | SUBDESIGN | INST | SUBINST | GROUP | THIS | OF | NET | ATTR | NEWATTR | COMBINE | INCLUDE | INFO | OPEN | PORT | PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN | INT | IDENT | PINNUM | STRING | WHITESPACE | LINE_COMMENT | MULTILINE_COMMENT | INCLUDE_DECL );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA11_74 = input.LA(1);

                        s = -1;
                        if ( ((LA11_74>='a' && LA11_74<='z')) ) {s = 72;}

                        else if ( ((LA11_74>='A' && LA11_74<='Z')) ) {s = 73;}

                        else if ( (LA11_74=='_') ) {s = 74;}

                        else if ( (LA11_74=='+') ) {s = 75;}

                        else if ( (LA11_74=='-') ) {s = 76;}

                        else if ( (LA11_74=='$') ) {s = 77;}

                        else if ( (LA11_74=='/') ) {s = 78;}

                        else if ( ((LA11_74>='0' && LA11_74<='9')) ) {s = 79;}

                        else if ( ((LA11_74>='\u0000' && LA11_74<='\t')||(LA11_74>='\u000B' && LA11_74<='\f')||(LA11_74>='\u000E' && LA11_74<='#')||(LA11_74>='%' && LA11_74<='*')||LA11_74==','||LA11_74=='.'||(LA11_74>=':' && LA11_74<='@')||(LA11_74>='[' && LA11_74<='^')||LA11_74=='`'||(LA11_74>='{' && LA11_74<='\uFFFF')) ) {s = 80;}

                        else s = 27;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA11_72 = input.LA(1);

                        s = -1;
                        if ( ((LA11_72>='a' && LA11_72<='z')) ) {s = 72;}

                        else if ( ((LA11_72>='A' && LA11_72<='Z')) ) {s = 73;}

                        else if ( (LA11_72=='_') ) {s = 74;}

                        else if ( (LA11_72=='+') ) {s = 75;}

                        else if ( (LA11_72=='-') ) {s = 76;}

                        else if ( (LA11_72=='$') ) {s = 77;}

                        else if ( (LA11_72=='/') ) {s = 78;}

                        else if ( ((LA11_72>='0' && LA11_72<='9')) ) {s = 79;}

                        else if ( ((LA11_72>='\u0000' && LA11_72<='\t')||(LA11_72>='\u000B' && LA11_72<='\f')||(LA11_72>='\u000E' && LA11_72<='#')||(LA11_72>='%' && LA11_72<='*')||LA11_72==','||LA11_72=='.'||(LA11_72>=':' && LA11_72<='@')||(LA11_72>='[' && LA11_72<='^')||LA11_72=='`'||(LA11_72>='{' && LA11_72<='\uFFFF')) ) {s = 80;}

                        else s = 27;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA11_73 = input.LA(1);

                        s = -1;
                        if ( ((LA11_73>='a' && LA11_73<='z')) ) {s = 72;}

                        else if ( ((LA11_73>='A' && LA11_73<='Z')) ) {s = 73;}

                        else if ( (LA11_73=='_') ) {s = 74;}

                        else if ( (LA11_73=='+') ) {s = 75;}

                        else if ( (LA11_73=='-') ) {s = 76;}

                        else if ( (LA11_73=='$') ) {s = 77;}

                        else if ( (LA11_73=='/') ) {s = 78;}

                        else if ( ((LA11_73>='0' && LA11_73<='9')) ) {s = 79;}

                        else if ( ((LA11_73>='\u0000' && LA11_73<='\t')||(LA11_73>='\u000B' && LA11_73<='\f')||(LA11_73>='\u000E' && LA11_73<='#')||(LA11_73>='%' && LA11_73<='*')||LA11_73==','||LA11_73=='.'||(LA11_73>=':' && LA11_73<='@')||(LA11_73>='[' && LA11_73<='^')||LA11_73=='`'||(LA11_73>='{' && LA11_73<='\uFFFF')) ) {s = 80;}

                        else s = 27;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA11_77 = input.LA(1);

                        s = -1;
                        if ( ((LA11_77>='a' && LA11_77<='z')) ) {s = 72;}

                        else if ( ((LA11_77>='A' && LA11_77<='Z')) ) {s = 73;}

                        else if ( (LA11_77=='_') ) {s = 74;}

                        else if ( (LA11_77=='+') ) {s = 75;}

                        else if ( (LA11_77=='-') ) {s = 76;}

                        else if ( (LA11_77=='$') ) {s = 77;}

                        else if ( (LA11_77=='/') ) {s = 78;}

                        else if ( ((LA11_77>='0' && LA11_77<='9')) ) {s = 79;}

                        else if ( ((LA11_77>='\u0000' && LA11_77<='\t')||(LA11_77>='\u000B' && LA11_77<='\f')||(LA11_77>='\u000E' && LA11_77<='#')||(LA11_77>='%' && LA11_77<='*')||LA11_77==','||LA11_77=='.'||(LA11_77>=':' && LA11_77<='@')||(LA11_77>='[' && LA11_77<='^')||LA11_77=='`'||(LA11_77>='{' && LA11_77<='\uFFFF')) ) {s = 80;}

                        else s = 27;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA11_78 = input.LA(1);

                        s = -1;
                        if ( ((LA11_78>='a' && LA11_78<='z')) ) {s = 72;}

                        else if ( ((LA11_78>='A' && LA11_78<='Z')) ) {s = 73;}

                        else if ( (LA11_78=='_') ) {s = 74;}

                        else if ( (LA11_78=='+') ) {s = 75;}

                        else if ( (LA11_78=='-') ) {s = 76;}

                        else if ( (LA11_78=='$') ) {s = 77;}

                        else if ( (LA11_78=='/') ) {s = 78;}

                        else if ( ((LA11_78>='0' && LA11_78<='9')) ) {s = 79;}

                        else if ( ((LA11_78>='\u0000' && LA11_78<='\t')||(LA11_78>='\u000B' && LA11_78<='\f')||(LA11_78>='\u000E' && LA11_78<='#')||(LA11_78>='%' && LA11_78<='*')||LA11_78==','||LA11_78=='.'||(LA11_78>=':' && LA11_78<='@')||(LA11_78>='[' && LA11_78<='^')||LA11_78=='`'||(LA11_78>='{' && LA11_78<='\uFFFF')) ) {s = 80;}

                        else s = 27;

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA11_75 = input.LA(1);

                        s = -1;
                        if ( ((LA11_75>='a' && LA11_75<='z')) ) {s = 72;}

                        else if ( ((LA11_75>='A' && LA11_75<='Z')) ) {s = 73;}

                        else if ( (LA11_75=='_') ) {s = 74;}

                        else if ( (LA11_75=='+') ) {s = 75;}

                        else if ( (LA11_75=='-') ) {s = 76;}

                        else if ( (LA11_75=='$') ) {s = 77;}

                        else if ( (LA11_75=='/') ) {s = 78;}

                        else if ( ((LA11_75>='0' && LA11_75<='9')) ) {s = 79;}

                        else if ( ((LA11_75>='\u0000' && LA11_75<='\t')||(LA11_75>='\u000B' && LA11_75<='\f')||(LA11_75>='\u000E' && LA11_75<='#')||(LA11_75>='%' && LA11_75<='*')||LA11_75==','||LA11_75=='.'||(LA11_75>=':' && LA11_75<='@')||(LA11_75>='[' && LA11_75<='^')||LA11_75=='`'||(LA11_75>='{' && LA11_75<='\uFFFF')) ) {s = 80;}

                        else s = 27;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA11_76 = input.LA(1);

                        s = -1;
                        if ( ((LA11_76>='a' && LA11_76<='z')) ) {s = 72;}

                        else if ( ((LA11_76>='A' && LA11_76<='Z')) ) {s = 73;}

                        else if ( (LA11_76=='_') ) {s = 74;}

                        else if ( (LA11_76=='+') ) {s = 75;}

                        else if ( (LA11_76=='-') ) {s = 76;}

                        else if ( (LA11_76=='$') ) {s = 77;}

                        else if ( (LA11_76=='/') ) {s = 78;}

                        else if ( ((LA11_76>='0' && LA11_76<='9')) ) {s = 79;}

                        else if ( ((LA11_76>='\u0000' && LA11_76<='\t')||(LA11_76>='\u000B' && LA11_76<='\f')||(LA11_76>='\u000E' && LA11_76<='#')||(LA11_76>='%' && LA11_76<='*')||LA11_76==','||LA11_76=='.'||(LA11_76>=':' && LA11_76<='@')||(LA11_76>='[' && LA11_76<='^')||LA11_76=='`'||(LA11_76>='{' && LA11_76<='\uFFFF')) ) {s = 80;}

                        else s = 27;

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA11_49 = input.LA(1);

                        s = -1;
                        if ( ((LA11_49>='a' && LA11_49<='z')) ) {s = 72;}

                        else if ( ((LA11_49>='A' && LA11_49<='Z')) ) {s = 73;}

                        else if ( (LA11_49=='_') ) {s = 74;}

                        else if ( (LA11_49=='+') ) {s = 75;}

                        else if ( (LA11_49=='-') ) {s = 76;}

                        else if ( (LA11_49=='$') ) {s = 77;}

                        else if ( (LA11_49=='/') ) {s = 78;}

                        else if ( ((LA11_49>='0' && LA11_49<='9')) ) {s = 79;}

                        else if ( ((LA11_49>='\u0000' && LA11_49<='\t')||(LA11_49>='\u000B' && LA11_49<='\f')||(LA11_49>='\u000E' && LA11_49<='#')||(LA11_49>='%' && LA11_49<='*')||LA11_49==','||LA11_49=='.'||(LA11_49>=':' && LA11_49<='@')||(LA11_49>='[' && LA11_49<='^')||LA11_49=='`'||(LA11_49>='{' && LA11_49<='\uFFFF')) ) {s = 80;}

                        else s = 27;

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA11_79 = input.LA(1);

                        s = -1;
                        if ( ((LA11_79>='a' && LA11_79<='z')) ) {s = 72;}

                        else if ( ((LA11_79>='A' && LA11_79<='Z')) ) {s = 73;}

                        else if ( (LA11_79=='_') ) {s = 74;}

                        else if ( (LA11_79=='+') ) {s = 75;}

                        else if ( (LA11_79=='-') ) {s = 76;}

                        else if ( (LA11_79=='$') ) {s = 77;}

                        else if ( (LA11_79=='/') ) {s = 78;}

                        else if ( ((LA11_79>='0' && LA11_79<='9')) ) {s = 79;}

                        else if ( ((LA11_79>='\u0000' && LA11_79<='\t')||(LA11_79>='\u000B' && LA11_79<='\f')||(LA11_79>='\u000E' && LA11_79<='#')||(LA11_79>='%' && LA11_79<='*')||LA11_79==','||LA11_79=='.'||(LA11_79>=':' && LA11_79<='@')||(LA11_79>='[' && LA11_79<='^')||LA11_79=='`'||(LA11_79>='{' && LA11_79<='\uFFFF')) ) {s = 80;}

                        else s = 27;

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA11_15 = input.LA(1);

                        s = -1;
                        if ( ((LA11_15>='\u0000' && LA11_15<='\uFFFF')) ) {s = 31;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 11, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}