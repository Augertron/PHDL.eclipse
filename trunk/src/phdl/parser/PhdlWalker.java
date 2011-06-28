// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g 2011-06-28 13:58:44

	package phdl.parser;
	import java.util.TreeSet;
	import java.util.SortedSet;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/**
 * A tree grammar that walks a the output of the PHDL parser.  It operates on a stream of 
 * tree nodes of the form (parent child1 child2 ... childN) where each node may be the
 * root of another subtree.
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 */
public class PhdlWalker extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "SEMICOLON", "EQUALS", "STRING_LITERAL", "SLICE_LIST", "PIN_LIST", "COLON", "COMMA", "ARRAY_LIST", "CHAR", "DIGIT", "PERIOD", "LBRACKET", "RBRACKET", "INT", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "'design'", "'is'", "'begin'", "'end'", "'device'", "'pin'", "'in'", "'out'", "'inout'", "'passive'", "'supply'", "'power'", "'net'", "'inst'", "'&'", "'<'", "'>'", "'open'"
    };
    public static final int EOF=-1;
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
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int IDENT=4;
    public static final int SEMICOLON=5;
    public static final int EQUALS=6;
    public static final int STRING_LITERAL=7;
    public static final int SLICE_LIST=8;
    public static final int PIN_LIST=9;
    public static final int COLON=10;
    public static final int COMMA=11;
    public static final int ARRAY_LIST=12;
    public static final int CHAR=13;
    public static final int DIGIT=14;
    public static final int PERIOD=15;
    public static final int LBRACKET=16;
    public static final int RBRACKET=17;
    public static final int INT=18;
    public static final int WHITESPACE=19;
    public static final int LINE_COMMENT=20;
    public static final int MULTILINE_COMMENT=21;

    // delegates
    // delegators


        public PhdlWalker(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public PhdlWalker(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PhdlWalker.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g"; }



    	private SortedSet<String> errors = new TreeSet<String>();
    	
    	@Override
        public void displayRecognitionError(String[] tokenNames,
                                            RecognitionException e) {
            String hdr = getErrorHeader(e);
            String msg = getErrorMessage(e, tokenNames);
            errors.add(input.getSourceName() + hdr + " " + msg);
        }
        
        public SortedSet<String> getErrors() {
            return errors;
        }
        
        public void addError(Parsable p, String msg) {
        	errors.add(input.getSourceName() + " line " + p.getLocation() + " " + msg
    				+ ": " + p.getName());
        }
        
    //    @Override
    //    protected Object recoverFromMismatchedToken(IntStream input,
    //                                            int ttype,
    //                                            BitSet follow)
    //    throws RecognitionException
    //	{   
    //    	throw new MismatchedTokenException(ttype, input);
    //	}  



    // $ANTLR start "sourceText"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:71:1: sourceText[ParsedDesigns pd] returns [ParsedDesigns designs] : ( design[pd] )* ;
    public final ParsedDesigns sourceText(ParsedDesigns pd) throws RecognitionException {
        ParsedDesigns designs = null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:75:2: ( ( design[pd] )* )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:76:3: ( design[pd] )*
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:76:3: ( design[pd] )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==22) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:76:3: design[pd]
            	    {
            	    pushFollow(FOLLOW_design_in_sourceText69);
            	    design(pd);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            designs = pd;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return designs;
    }
    // $ANTLR end "sourceText"


    // $ANTLR start "design"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:80:1: design[ParsedDesigns pd] : ^( 'design' IDENT ( deviceDecl[d] | netDecl[d] )* 'begin' ( instDecl[d] | netAssign[d] )* ) ;
    public final void design(ParsedDesigns pd) throws RecognitionException {
        CommonTree IDENT1=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:87:2: ( ^( 'design' IDENT ( deviceDecl[d] | netDecl[d] )* 'begin' ( instDecl[d] | netAssign[d] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:87:4: ^( 'design' IDENT ( deviceDecl[d] | netDecl[d] )* 'begin' ( instDecl[d] | netAssign[d] )* )
            {
            match(input,22,FOLLOW_22_in_design91); 

            match(input, Token.DOWN, null); 
            IDENT1=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_design93); 
            	DesignDecl d = new DesignDecl();
            			d.setName((IDENT1!=null?IDENT1.getText():null));
            			d.setLine((IDENT1!=null?IDENT1.getLine():0));
            			d.setPos((IDENT1!=null?IDENT1.getCharPositionInLine():0));
            			d.setFileName(input.getSourceName());
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:98:3: ( deviceDecl[d] | netDecl[d] )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==26) ) {
                    alt2=1;
                }
                else if ( (LA2_0==34) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:98:4: deviceDecl[d]
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_design115);
            	    deviceDecl(d);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:98:20: netDecl[d]
            	    {
            	    pushFollow(FOLLOW_netDecl_in_design120);
            	    netDecl(d);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match(input,24,FOLLOW_24_in_design133); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:104:3: ( instDecl[d] | netAssign[d] )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==35) ) {
                    alt3=1;
                }
                else if ( (LA3_0==EQUALS) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:104:4: instDecl[d]
            	    {
            	    pushFollow(FOLLOW_instDecl_in_design144);
            	    instDecl(d);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:104:18: netAssign[d]
            	    {
            	    pushFollow(FOLLOW_netAssign_in_design149);
            	    netAssign(d);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            match(input, Token.UP, null); 
            	if(!pd.addDesignDecl(d)) 
            				addError(d, "duplicate design declaration");
            		

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:112:1: deviceDecl[DesignDecl d] : ^( 'device' name= IDENT ( attrDecl[dev] )* 'begin' ( pinDecl[dev] )* ) ;
    public final void deviceDecl(DesignDecl d) throws RecognitionException {
        CommonTree name=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:119:2: ( ^( 'device' name= IDENT ( attrDecl[dev] )* 'begin' ( pinDecl[dev] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:119:4: ^( 'device' name= IDENT ( attrDecl[dev] )* 'begin' ( pinDecl[dev] )* )
            {
            match(input,26,FOLLOW_26_in_deviceDecl179); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl183); 
            	DeviceDecl dev = new DeviceDecl();
            				dev.setName((name!=null?name.getText():null));
            				dev.setLine((name!=null?name.getLine():0));
            				dev.setPos((name!=null?name.getCharPositionInLine():0));
            				dev.setFileName(input.getSourceName());
            			
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:130:3: ( attrDecl[dev] )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==EQUALS) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:130:3: attrDecl[dev]
            	    {
            	    pushFollow(FOLLOW_attrDecl_in_deviceDecl206);
            	    attrDecl(dev);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match(input,24,FOLLOW_24_in_deviceDecl218); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:136:3: ( pinDecl[dev] )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=27 && LA5_0<=33)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:136:3: pinDecl[dev]
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl228);
            	    pinDecl(dev);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            match(input, Token.UP, null); 
            	if(!d.addDeviceDecl(dev)) 
            				addError(dev, "duplicate device declaration");
            		

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


    // $ANTLR start "netDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:146:1: netDecl[DesignDecl d] : ^( 'net' (slice= SLICE_LIST )? name= IDENT ( COLON ( netAttr[n] )+ )? ) ;
    public final void netDecl(DesignDecl d) throws RecognitionException {
        CommonTree slice=null;
        CommonTree name=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:151:2: ( ^( 'net' (slice= SLICE_LIST )? name= IDENT ( COLON ( netAttr[n] )+ )? ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:151:4: ^( 'net' (slice= SLICE_LIST )? name= IDENT ( COLON ( netAttr[n] )+ )? )
            {
            match(input,34,FOLLOW_34_in_netDecl263); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:151:12: (slice= SLICE_LIST )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==SLICE_LIST) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:151:13: slice= SLICE_LIST
                    {
                    slice=(CommonTree)match(input,SLICE_LIST,FOLLOW_SLICE_LIST_in_netDecl268); 

                    }
                    break;

            }

            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netDecl274); 
            	NetDecl n = new NetDecl(); 
            			n.setName((name!=null?name.getText():null));
            			n.setLine((name!=null?name.getLine():0));
            			n.setPos((name!=null?name.getCharPositionInLine():0));
            			n.setSliceString((slice!=null?slice.getText():null));
            			n.setFileName(input.getSourceName());
            			
            			if(!n.makeBits())
            				addError(n, "invalid net declaration array");
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:165:3: ( COLON ( netAttr[n] )+ )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==COLON) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:165:4: COLON ( netAttr[n] )+
                    {
                    match(input,COLON,FOLLOW_COLON_in_netDecl291); 
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:165:10: ( netAttr[n] )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==IDENT) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:165:10: netAttr[n]
                    	    {
                    	    pushFollow(FOLLOW_netAttr_in_netDecl293);
                    	    netAttr(n);

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);


                    }
                    break;

            }


            match(input, Token.UP, null); 
            	if(!d.addNetDecl(n)) 
            				addError(n, "duplicate net declaration");
            		

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
    // $ANTLR end "netDecl"


    // $ANTLR start "netAttr"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:173:1: netAttr[NetDecl n] : IDENT ;
    public final void netAttr(NetDecl n) throws RecognitionException {
        CommonTree IDENT2=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:176:2: ( IDENT )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:176:4: IDENT
            {
            IDENT2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netAttr323); 
            	if(!n.addAttribute((IDENT2!=null?IDENT2.getText():null))) 
            				addError(n, "duplicate net attribute");
            		

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
    // $ANTLR end "netAttr"


    // $ANTLR start "attrDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:184:1: attrDecl[DeviceDecl d] : ^( EQUALS name= IDENT value= STRING_LITERAL ) ;
    public final void attrDecl(DeviceDecl d) throws RecognitionException {
        CommonTree name=null;
        CommonTree value=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:188:2: ( ^( EQUALS name= IDENT value= STRING_LITERAL ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:188:4: ^( EQUALS name= IDENT value= STRING_LITERAL )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_attrDecl347); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attrDecl351); 
            value=(CommonTree)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_attrDecl355); 

            match(input, Token.UP, null); 
            	AttrDecl a = new AttrDecl();
            			a.setName((name!=null?name.getText():null));
            			a.setLine((name!=null?name.getLine():0));
            			a.setPos((name!=null?name.getCharPositionInLine():0));
            			a.setValue((value!=null?value.getText():null));
            			a.setFileName(input.getSourceName());
            			
            			if(!d.addAttrDecl(a)) 
            				addError(a, "duplicate attribute declaration");
            		

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


    // $ANTLR start "pinDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:203:1: pinDecl[DeviceDecl d] : ( ^( 'pin' addPinDecl[d, pin] ) | ^( 'in' addPinDecl[d, in] ) | ^( 'out' addPinDecl[d, out] ) | ^( 'inout' addPinDecl[d, inout] ) | ^( 'passive' addPinDecl[d, passive] ) | ^( 'supply' addPinDecl[d, supply] ) | ^( 'power' addPinDecl[d, power] ) );
    public final void pinDecl(DeviceDecl d) throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:208:2: ( ^( 'pin' addPinDecl[d, pin] ) | ^( 'in' addPinDecl[d, in] ) | ^( 'out' addPinDecl[d, out] ) | ^( 'inout' addPinDecl[d, inout] ) | ^( 'passive' addPinDecl[d, passive] ) | ^( 'supply' addPinDecl[d, supply] ) | ^( 'power' addPinDecl[d, power] ) )
            int alt9=7;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt9=1;
                }
                break;
            case 28:
                {
                alt9=2;
                }
                break;
            case 29:
                {
                alt9=3;
                }
                break;
            case 30:
                {
                alt9=4;
                }
                break;
            case 31:
                {
                alt9=5;
                }
                break;
            case 32:
                {
                alt9=6;
                }
                break;
            case 33:
                {
                alt9=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:208:4: ^( 'pin' addPinDecl[d, pin] )
                    {
                    match(input,27,FOLLOW_27_in_pinDecl382); 

                    PinDecl pin = new PinDecl(Type.PIN);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPinDecl_in_pinDecl386);
                    addPinDecl(d, pin);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:209:4: ^( 'in' addPinDecl[d, in] )
                    {
                    match(input,28,FOLLOW_28_in_pinDecl394); 

                    PinDecl in = new PinDecl(Type.IN);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPinDecl_in_pinDecl398);
                    addPinDecl(d, in);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:210:4: ^( 'out' addPinDecl[d, out] )
                    {
                    match(input,29,FOLLOW_29_in_pinDecl406); 

                    PinDecl out = new PinDecl(Type.OUT);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPinDecl_in_pinDecl410);
                    addPinDecl(d, out);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:211:4: ^( 'inout' addPinDecl[d, inout] )
                    {
                    match(input,30,FOLLOW_30_in_pinDecl418); 

                    PinDecl inout = new PinDecl(Type.INOUT);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPinDecl_in_pinDecl422);
                    addPinDecl(d, inout);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:212:4: ^( 'passive' addPinDecl[d, passive] )
                    {
                    match(input,31,FOLLOW_31_in_pinDecl430); 

                    PinDecl passive = new PinDecl(Type.PASSIVE);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPinDecl_in_pinDecl434);
                    addPinDecl(d, passive);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:213:4: ^( 'supply' addPinDecl[d, supply] )
                    {
                    match(input,32,FOLLOW_32_in_pinDecl442); 

                    PinDecl supply = new PinDecl(Type.SUPPLY);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPinDecl_in_pinDecl446);
                    addPinDecl(d, supply);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 7 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:214:4: ^( 'power' addPinDecl[d, power] )
                    {
                    match(input,33,FOLLOW_33_in_pinDecl454); 

                    PinDecl power = new PinDecl(Type.POWER);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPinDecl_in_pinDecl458);
                    addPinDecl(d, power);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;

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
    // $ANTLR end "pinDecl"


    // $ANTLR start "addPinDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:217:1: addPinDecl[DeviceDecl d, PinDecl p] : (slice= SLICE_LIST )? name= IDENT pins= PIN_LIST ;
    public final void addPinDecl(DeviceDecl d, PinDecl p) throws RecognitionException {
        CommonTree slice=null;
        CommonTree name=null;
        CommonTree pins=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:221:2: ( (slice= SLICE_LIST )? name= IDENT pins= PIN_LIST )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:221:4: (slice= SLICE_LIST )? name= IDENT pins= PIN_LIST
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:221:4: (slice= SLICE_LIST )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==SLICE_LIST) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:221:5: slice= SLICE_LIST
                    {
                    slice=(CommonTree)match(input,SLICE_LIST,FOLLOW_SLICE_LIST_in_addPinDecl478); 

                    }
                    break;

            }

            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_addPinDecl484); 
            pins=(CommonTree)match(input,PIN_LIST,FOLLOW_PIN_LIST_in_addPinDecl488); 
            	
            			p.setName((name!=null?name.getText():null));
            			p.setLine((name!=null?name.getLine():0));
            			p.setPos((name!=null?name.getCharPositionInLine():0));
            			p.setSliceString((slice!=null?slice.getText():null));
            			p.setPinList((pins!=null?pins.getText():null));
            			p.setFileName(input.getSourceName());
            			
            			if(!p.makeBits())
            				addError(p, "invalid pin declaration slice");
            				
            			if(!p.makePinMap())
            				addError(p, "invalid pin declaration pin list");
            			
            			if(!d.addPinDecl(p)) 
            				addError(p, "duplicate pin declaration");
            		

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
    // $ANTLR end "addPinDecl"


    // $ANTLR start "instDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:241:1: instDecl[DesignDecl d] : ^( 'inst' name= IDENT refName= IDENT (array= ARRAY_LIST )? ( attrAssign[i] )* 'begin' ( pinAssign[i] )* ) ;
    public final void instDecl(DesignDecl d) throws RecognitionException {
        CommonTree name=null;
        CommonTree refName=null;
        CommonTree array=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:245:2: ( ^( 'inst' name= IDENT refName= IDENT (array= ARRAY_LIST )? ( attrAssign[i] )* 'begin' ( pinAssign[i] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:245:4: ^( 'inst' name= IDENT refName= IDENT (array= ARRAY_LIST )? ( attrAssign[i] )* 'begin' ( pinAssign[i] )* )
            {
            match(input,35,FOLLOW_35_in_instDecl509); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl513); 
            refName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl517); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:245:38: (array= ARRAY_LIST )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==ARRAY_LIST) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:245:39: array= ARRAY_LIST
                    {
                    array=(CommonTree)match(input,ARRAY_LIST,FOLLOW_ARRAY_LIST_in_instDecl522); 

                    }
                    break;

            }

            	
            			InstDecl i = new InstDecl();
            				i.setName((name!=null?name.getText():null));
            				i.setLine((name!=null?name.getLine():0));
            				i.setPos((name!=null?name.getCharPositionInLine():0));
            				i.setArrayString((array!=null?array.getText():null));
            				i.setRefName((refName!=null?refName.getText():null));
            				i.setFileName(input.getSourceName());
            				
            				if (!i.makeIndices())
            					addError(i, "invalid instance declaration array");
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:261:3: ( attrAssign[i] )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==EQUALS) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:261:3: attrAssign[i]
            	    {
            	    pushFollow(FOLLOW_attrAssign_in_instDecl543);
            	    attrAssign(i);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            match(input,24,FOLLOW_24_in_instDecl549); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:263:3: ( pinAssign[i] )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==EQUALS) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:263:3: pinAssign[i]
            	    {
            	    pushFollow(FOLLOW_pinAssign_in_instDecl553);
            	    pinAssign(i);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            match(input, Token.UP, null); 
            	if(!d.addInstDecl(i)) 
            				addError(i, "duplicate instance declaration");
            		

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
    // $ANTLR end "instDecl"


    // $ANTLR start "attrAssign"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:270:1: attrAssign[InstDecl i] : ^( EQUALS name= IDENT (array= ARRAY_LIST )? value= STRING_LITERAL ) ;
    public final void attrAssign(InstDecl i) throws RecognitionException {
        CommonTree name=null;
        CommonTree array=null;
        CommonTree value=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:276:2: ( ^( EQUALS name= IDENT (array= ARRAY_LIST )? value= STRING_LITERAL ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:276:4: ^( EQUALS name= IDENT (array= ARRAY_LIST )? value= STRING_LITERAL )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_attrAssign578); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attrAssign582); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:276:24: (array= ARRAY_LIST )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==ARRAY_LIST) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:276:25: array= ARRAY_LIST
                    {
                    array=(CommonTree)match(input,ARRAY_LIST,FOLLOW_ARRAY_LIST_in_attrAssign587); 

                    }
                    break;

            }

            value=(CommonTree)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_attrAssign593); 

            match(input, Token.UP, null); 
            	AttrAssign a = new AttrAssign();
            			a.setName((name!=null?name.getText():null));
            			a.setLine((name!=null?name.getLine():0));
            			a.setPos((name!=null?name.getCharPositionInLine():0));
            			a.setArrayString((array!=null?array.getText():null));
            			a.setValue((value!=null?value.getText():null));
            			a.setFileName(input.getSourceName());
            			
            			if(!a.makeIndices())
            				addError(a, "invalid attribute assignment array");
            			
            			if(!i.addAttrAssign(a)) 
            				addError(a, "duplicate attribute assignment");
            		

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
    // $ANTLR end "attrAssign"


    // $ANTLR start "pinAssign"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:295:1: pinAssign[InstDecl i] : ^( EQUALS name= IDENT (array= ARRAY_LIST )? (slice= SLICE_LIST )? ( concatPin[p] )* ) ;
    public final void pinAssign(InstDecl i) throws RecognitionException {
        CommonTree name=null;
        CommonTree array=null;
        CommonTree slice=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:299:2: ( ^( EQUALS name= IDENT (array= ARRAY_LIST )? (slice= SLICE_LIST )? ( concatPin[p] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:299:4: ^( EQUALS name= IDENT (array= ARRAY_LIST )? (slice= SLICE_LIST )? ( concatPin[p] )* )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_pinAssign621); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinAssign625); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:299:24: (array= ARRAY_LIST )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==ARRAY_LIST) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:299:25: array= ARRAY_LIST
                    {
                    array=(CommonTree)match(input,ARRAY_LIST,FOLLOW_ARRAY_LIST_in_pinAssign630); 

                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:299:44: (slice= SLICE_LIST )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==SLICE_LIST) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:299:45: slice= SLICE_LIST
                    {
                    slice=(CommonTree)match(input,SLICE_LIST,FOLLOW_SLICE_LIST_in_pinAssign637); 

                    }
                    break;

            }


            			PinAssign p = new PinAssign();
            			p.setName((name!=null?name.getText():null));
            			p.setLine((name!=null?name.getLine():0));
            			p.setPos((name!=null?name.getCharPositionInLine():0));
            			p.setArrayString((array!=null?array.getText():null));
            			p.setSliceString((slice!=null?slice.getText():null));
            			p.setFileName(input.getSourceName());
            			
            			if(!p.makeIndices())
            				addError(p, "invalid array format");
            			if(!p.makeBits())
            				addError(p, "invalid slice format");
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:317:3: ( concatPin[p] )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==IDENT) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:317:3: concatPin[p]
            	    {
            	    pushFollow(FOLLOW_concatPin_in_pinAssign654);
            	    concatPin(p);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            match(input, Token.UP, null); 
            	if(!i.addPinAssign(p)) 
            				addError(p, "duplicate pin assignment");
            		

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
    // $ANTLR end "pinAssign"


    // $ANTLR start "concatPin"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:324:1: concatPin[PinAssign pa] : (name= IDENT (slice= SLICE_LIST )? ) ;
    public final void concatPin(PinAssign pa) throws RecognitionException {
        CommonTree name=null;
        CommonTree slice=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:328:2: ( (name= IDENT (slice= SLICE_LIST )? ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:328:4: (name= IDENT (slice= SLICE_LIST )? )
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:328:4: (name= IDENT (slice= SLICE_LIST )? )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:328:5: name= IDENT (slice= SLICE_LIST )?
            {
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatPin682); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:328:16: (slice= SLICE_LIST )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==SLICE_LIST) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:328:17: slice= SLICE_LIST
                    {
                    slice=(CommonTree)match(input,SLICE_LIST,FOLLOW_SLICE_LIST_in_concatPin687); 

                    }
                    break;

            }


            }


            			Net n = new Net();
            			n.setName((name!=null?name.getText():null));
            			n.setLine((name!=null?name.getLine():0));
            			n.setPos((name!=null?name.getCharPositionInLine():0));
            			n.setSliceString((slice!=null?slice.getText():null));
            			n.setFileName(input.getSourceName());
            			pa.addNet(n);
            			
            			if(!n.makeBits())
            				addError(n, "invalid slice format");
            		

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
    // $ANTLR end "concatPin"


    // $ANTLR start "netAssign"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:343:1: netAssign[DesignDecl d] : ^( EQUALS name= IDENT (slice= SLICE_LIST )? ( concatNet[n] )* ) ;
    public final void netAssign(DesignDecl d) throws RecognitionException {
        CommonTree name=null;
        CommonTree slice=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:347:2: ( ^( EQUALS name= IDENT (slice= SLICE_LIST )? ( concatNet[n] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:347:4: ^( EQUALS name= IDENT (slice= SLICE_LIST )? ( concatNet[n] )* )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_netAssign710); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netAssign714); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:347:24: (slice= SLICE_LIST )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==SLICE_LIST) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:347:25: slice= SLICE_LIST
                    {
                    slice=(CommonTree)match(input,SLICE_LIST,FOLLOW_SLICE_LIST_in_netAssign719); 

                    }
                    break;

            }

            	NetAssign n = new NetAssign(); 
            			n.setName((name!=null?name.getText():null));
            			n.setLine((name!=null?name.getLine():0));
            			n.setPos((name!=null?name.getCharPositionInLine():0));
            			n.setSliceString((slice!=null?slice.getText():null));
            			n.setFileName(input.getSourceName());
            			
            			if(!n.makeBits())
            				addError(n, "invalid slice format");
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:361:3: ( concatNet[n] )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==IDENT) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:361:3: concatNet[n]
            	    {
            	    pushFollow(FOLLOW_concatNet_in_netAssign738);
            	    concatNet(n);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            match(input, Token.UP, null); 
            	if(!d.addNetAssign(n)) 
            				addError(n, "duplicate net assignment");
            		

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
    // $ANTLR end "netAssign"


    // $ANTLR start "concatNet"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:368:1: concatNet[NetAssign na] : (name= IDENT (slice= SLICE_LIST )? ) ;
    public final void concatNet(NetAssign na) throws RecognitionException {
        CommonTree name=null;
        CommonTree slice=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:372:2: ( (name= IDENT (slice= SLICE_LIST )? ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:372:4: (name= IDENT (slice= SLICE_LIST )? )
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:372:4: (name= IDENT (slice= SLICE_LIST )? )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:372:5: name= IDENT (slice= SLICE_LIST )?
            {
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatNet766); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:372:16: (slice= SLICE_LIST )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==SLICE_LIST) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:372:17: slice= SLICE_LIST
                    {
                    slice=(CommonTree)match(input,SLICE_LIST,FOLLOW_SLICE_LIST_in_concatNet771); 

                    }
                    break;

            }


            }

            	Net n = new Net();
            			n.setName((name!=null?name.getText():null));
            			n.setLine((name!=null?name.getLine():0));
            			n.setPos((name!=null?name.getCharPositionInLine():0));
            			n.setSliceString((slice!=null?slice.getText():null));
            			n.setFileName(input.getSourceName());
            			na.addNet(n);
            			
            			if(!n.makeBits())
            				addError(n, "invalid slice format");
            		

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
    // $ANTLR end "concatNet"

    // Delegated rules


 

    public static final BitSet FOLLOW_design_in_sourceText69 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_design91 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_design93 = new BitSet(new long[]{0x0000000405000000L});
    public static final BitSet FOLLOW_deviceDecl_in_design115 = new BitSet(new long[]{0x0000000405000000L});
    public static final BitSet FOLLOW_netDecl_in_design120 = new BitSet(new long[]{0x0000000405000000L});
    public static final BitSet FOLLOW_24_in_design133 = new BitSet(new long[]{0x0000000800000048L});
    public static final BitSet FOLLOW_instDecl_in_design144 = new BitSet(new long[]{0x0000000800000048L});
    public static final BitSet FOLLOW_netAssign_in_design149 = new BitSet(new long[]{0x0000000800000048L});
    public static final BitSet FOLLOW_26_in_deviceDecl179 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl183 = new BitSet(new long[]{0x0000000001000040L});
    public static final BitSet FOLLOW_attrDecl_in_deviceDecl206 = new BitSet(new long[]{0x0000000001000040L});
    public static final BitSet FOLLOW_24_in_deviceDecl218 = new BitSet(new long[]{0x00000003F8000008L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl228 = new BitSet(new long[]{0x00000003F8000008L});
    public static final BitSet FOLLOW_34_in_netDecl263 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SLICE_LIST_in_netDecl268 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl274 = new BitSet(new long[]{0x0000000000000408L});
    public static final BitSet FOLLOW_COLON_in_netDecl291 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_netAttr_in_netDecl293 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_IDENT_in_netAttr323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUALS_in_attrDecl347 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_attrDecl351 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_attrDecl355 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_27_in_pinDecl382 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPinDecl_in_pinDecl386 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_28_in_pinDecl394 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPinDecl_in_pinDecl398 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_29_in_pinDecl406 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPinDecl_in_pinDecl410 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_30_in_pinDecl418 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPinDecl_in_pinDecl422 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_31_in_pinDecl430 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPinDecl_in_pinDecl434 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_32_in_pinDecl442 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPinDecl_in_pinDecl446 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_33_in_pinDecl454 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPinDecl_in_pinDecl458 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SLICE_LIST_in_addPinDecl478 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_addPinDecl484 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_PIN_LIST_in_addPinDecl488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_instDecl509 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_instDecl513 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instDecl517 = new BitSet(new long[]{0x0000000001001040L});
    public static final BitSet FOLLOW_ARRAY_LIST_in_instDecl522 = new BitSet(new long[]{0x0000000001000040L});
    public static final BitSet FOLLOW_attrAssign_in_instDecl543 = new BitSet(new long[]{0x0000000001000040L});
    public static final BitSet FOLLOW_24_in_instDecl549 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_pinAssign_in_instDecl553 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_EQUALS_in_attrAssign578 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_attrAssign582 = new BitSet(new long[]{0x0000000000001080L});
    public static final BitSet FOLLOW_ARRAY_LIST_in_attrAssign587 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_attrAssign593 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssign621 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_pinAssign625 = new BitSet(new long[]{0x0000000000001118L});
    public static final BitSet FOLLOW_ARRAY_LIST_in_pinAssign630 = new BitSet(new long[]{0x0000000000000118L});
    public static final BitSet FOLLOW_SLICE_LIST_in_pinAssign637 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_concatPin_in_pinAssign654 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_IDENT_in_concatPin682 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_SLICE_LIST_in_concatPin687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUALS_in_netAssign710 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_netAssign714 = new BitSet(new long[]{0x0000000000000118L});
    public static final BitSet FOLLOW_SLICE_LIST_in_netAssign719 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_concatNet_in_netAssign738 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_IDENT_in_concatNet766 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_SLICE_LIST_in_concatNet771 = new BitSet(new long[]{0x0000000000000002L});

}