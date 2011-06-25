// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g 2011-06-25 11:05:19

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "SEMICOLON", "EQUALS", "STRING_LITERAL", "NUMBER_LIST", "COMMA", "COLON", "INT", "PERIOD", "CHAR", "DIGIT", "LBRACKET", "RBRACKET", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "'design'", "'is'", "'begin'", "'end'", "'device'", "'pin'", "'in'", "'out'", "'inout'", "'passive'", "'supply'", "'power'", "'open'", "'net'", "'('", "')'", "'inst'", "'sub'", "'&'"
    };
    public static final int EOF=-1;
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
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int IDENT=4;
    public static final int SEMICOLON=5;
    public static final int EQUALS=6;
    public static final int STRING_LITERAL=7;
    public static final int NUMBER_LIST=8;
    public static final int COMMA=9;
    public static final int COLON=10;
    public static final int INT=11;
    public static final int PERIOD=12;
    public static final int CHAR=13;
    public static final int DIGIT=14;
    public static final int LBRACKET=15;
    public static final int RBRACKET=16;
    public static final int WHITESPACE=17;
    public static final int LINE_COMMENT=18;
    public static final int MULTILINE_COMMENT=19;

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

                if ( (LA1_0==20) ) {
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:80:1: design[ParsedDesigns pd] : ^( 'design' IDENT ( portDecl[d] | deviceDecl[d] | netDecl[d] )* 'begin' ( instance[d] | subDesign[d] | netAssign[d] )* ) ;
    public final void design(ParsedDesigns pd) throws RecognitionException {
        CommonTree IDENT1=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:87:2: ( ^( 'design' IDENT ( portDecl[d] | deviceDecl[d] | netDecl[d] )* 'begin' ( instance[d] | subDesign[d] | netAssign[d] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:87:4: ^( 'design' IDENT ( portDecl[d] | deviceDecl[d] | netDecl[d] )* 'begin' ( instance[d] | subDesign[d] | netAssign[d] )* )
            {
            match(input,20,FOLLOW_20_in_design91); 

            match(input, Token.DOWN, null); 
            IDENT1=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_design93); 
            	DesignDecl d = new DesignDecl();
            			d.setName((IDENT1!=null?IDENT1.getText():null));
            			d.setLine((IDENT1!=null?IDENT1.getLine():0));
            			d.setPos((IDENT1!=null?IDENT1.getCharPositionInLine():0));
            			d.setFileName(input.getSourceName());
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:98:3: ( portDecl[d] | deviceDecl[d] | netDecl[d] )*
            loop2:
            do {
                int alt2=4;
                switch ( input.LA(1) ) {
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                    {
                    alt2=1;
                    }
                    break;
                case 24:
                    {
                    alt2=2;
                    }
                    break;
                case 33:
                    {
                    alt2=3;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:98:4: portDecl[d]
            	    {
            	    pushFollow(FOLLOW_portDecl_in_design115);
            	    portDecl(d);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:98:18: deviceDecl[d]
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_design120);
            	    deviceDecl(d);

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:98:34: netDecl[d]
            	    {
            	    pushFollow(FOLLOW_netDecl_in_design125);
            	    netDecl(d);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match(input,22,FOLLOW_22_in_design138); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:104:3: ( instance[d] | subDesign[d] | netAssign[d] )*
            loop3:
            do {
                int alt3=4;
                switch ( input.LA(1) ) {
                case 36:
                    {
                    alt3=1;
                    }
                    break;
                case 37:
                    {
                    alt3=2;
                    }
                    break;
                case EQUALS:
                    {
                    alt3=3;
                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:104:4: instance[d]
            	    {
            	    pushFollow(FOLLOW_instance_in_design149);
            	    instance(d);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:104:18: subDesign[d]
            	    {
            	    pushFollow(FOLLOW_subDesign_in_design154);
            	    subDesign(d);

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:104:33: netAssign[d]
            	    {
            	    pushFollow(FOLLOW_netAssign_in_design159);
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


    // $ANTLR start "portDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:112:1: portDecl[DesignDecl d] : ( ^( 'pin' addPort[d, pin] ) | ^( 'in' addPort[d, in] ) | ^( 'out' addPort[d, out] ) | ^( 'inout' addPort[d, inout] ) | ^( 'passive' addPort[d, passive] ) | ^( 'supply' addPort[d, supply] ) | ^( 'power' addPort[d, power] ) );
    public final void portDecl(DesignDecl d) throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:118:2: ( ^( 'pin' addPort[d, pin] ) | ^( 'in' addPort[d, in] ) | ^( 'out' addPort[d, out] ) | ^( 'inout' addPort[d, inout] ) | ^( 'passive' addPort[d, passive] ) | ^( 'supply' addPort[d, supply] ) | ^( 'power' addPort[d, power] ) )
            int alt4=7;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt4=1;
                }
                break;
            case 26:
                {
                alt4=2;
                }
                break;
            case 27:
                {
                alt4=3;
                }
                break;
            case 28:
                {
                alt4=4;
                }
                break;
            case 29:
                {
                alt4=5;
                }
                break;
            case 30:
                {
                alt4=6;
                }
                break;
            case 31:
                {
                alt4=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:118:4: ^( 'pin' addPort[d, pin] )
                    {
                    match(input,25,FOLLOW_25_in_portDecl188); 

                    PortDecl pin = new PortDecl(Type.PIN);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPort_in_portDecl192);
                    addPort(d, pin);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:119:4: ^( 'in' addPort[d, in] )
                    {
                    match(input,26,FOLLOW_26_in_portDecl200); 

                    PortDecl in = new PortDecl(Type.IN);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPort_in_portDecl204);
                    addPort(d, in);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:120:4: ^( 'out' addPort[d, out] )
                    {
                    match(input,27,FOLLOW_27_in_portDecl212); 

                    PortDecl out = new PortDecl(Type.OUT);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPort_in_portDecl216);
                    addPort(d, out);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:121:4: ^( 'inout' addPort[d, inout] )
                    {
                    match(input,28,FOLLOW_28_in_portDecl224); 

                    PortDecl inout = new PortDecl(Type.INOUT);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPort_in_portDecl228);
                    addPort(d, inout);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:122:4: ^( 'passive' addPort[d, passive] )
                    {
                    match(input,29,FOLLOW_29_in_portDecl236); 

                    PortDecl passive = new PortDecl(Type.PASSIVE);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPort_in_portDecl240);
                    addPort(d, passive);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:123:4: ^( 'supply' addPort[d, supply] )
                    {
                    match(input,30,FOLLOW_30_in_portDecl248); 

                    PortDecl supply = new PortDecl(Type.SUPPLY);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPort_in_portDecl252);
                    addPort(d, supply);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 7 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:124:4: ^( 'power' addPort[d, power] )
                    {
                    match(input,31,FOLLOW_31_in_portDecl260); 

                    PortDecl power = new PortDecl(Type.POWER);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPort_in_portDecl264);
                    addPort(d, power);

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
    // $ANTLR end "portDecl"


    // $ANTLR start "addPort"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:127:1: addPort[DesignDecl d, PortDecl p] : (msb= INT COLON lsb= INT )? name= IDENT ;
    public final void addPort(DesignDecl d, PortDecl p) throws RecognitionException {
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree name=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:132:2: ( (msb= INT COLON lsb= INT )? name= IDENT )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:132:4: (msb= INT COLON lsb= INT )? name= IDENT
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:132:4: (msb= INT COLON lsb= INT )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==INT) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:132:5: msb= INT COLON lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_addPort284); 
                    match(input,COLON,FOLLOW_COLON_in_addPort286); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_addPort290); 

                    }
                    break;

            }

            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_addPort296); 
            	
            			p.setName((name!=null?name.getText():null));
            			p.setLine((name!=null?name.getLine():0));
            			p.setPos((name!=null?name.getCharPositionInLine():0));
            			p.setMsb(msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1);
            			p.setLsb(lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1);
            			p.setFileName(input.getSourceName());
            			
            			if(!d.addPortDecl(p)) 
            				addError(p, "duplicate port declaration");
            		

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
    // $ANTLR end "addPort"


    // $ANTLR start "deviceDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:146:1: deviceDecl[DesignDecl d] : ^( 'device' name= IDENT ( attrDecl[dev] )* 'begin' ( pinDecl[dev] )* ) ;
    public final void deviceDecl(DesignDecl d) throws RecognitionException {
        CommonTree name=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:153:2: ( ^( 'device' name= IDENT ( attrDecl[dev] )* 'begin' ( pinDecl[dev] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:153:4: ^( 'device' name= IDENT ( attrDecl[dev] )* 'begin' ( pinDecl[dev] )* )
            {
            match(input,24,FOLLOW_24_in_deviceDecl316); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl320); 
            	DeviceDecl dev = new DeviceDecl();
            				dev.setName((name!=null?name.getText():null));
            				dev.setLine((name!=null?name.getLine():0));
            				dev.setPos((name!=null?name.getCharPositionInLine():0));
            				dev.setFileName(input.getSourceName());
            			
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:164:3: ( attrDecl[dev] )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==EQUALS) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:164:3: attrDecl[dev]
            	    {
            	    pushFollow(FOLLOW_attrDecl_in_deviceDecl343);
            	    attrDecl(dev);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match(input,22,FOLLOW_22_in_deviceDecl355); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:170:3: ( pinDecl[dev] )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=25 && LA7_0<=31)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:170:3: pinDecl[dev]
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl365);
            	    pinDecl(dev);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:180:1: netDecl[DesignDecl d] : ^( 'net' (msb= INT COLON lsb= INT )? name= IDENT ( COLON ( netAttr[n] )+ )? ) ;
    public final void netDecl(DesignDecl d) throws RecognitionException {
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree name=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:185:2: ( ^( 'net' (msb= INT COLON lsb= INT )? name= IDENT ( COLON ( netAttr[n] )+ )? ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:185:4: ^( 'net' (msb= INT COLON lsb= INT )? name= IDENT ( COLON ( netAttr[n] )+ )? )
            {
            match(input,33,FOLLOW_33_in_netDecl400); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:185:12: (msb= INT COLON lsb= INT )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==INT) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:185:13: msb= INT COLON lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_netDecl405); 
                    match(input,COLON,FOLLOW_COLON_in_netDecl407); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_netDecl411); 

                    }
                    break;

            }

            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netDecl417); 
            	NetDecl n = new NetDecl(); 
            			n.setName((name!=null?name.getText():null));
            			n.setLine((name!=null?name.getLine():0));
            			n.setPos((name!=null?name.getCharPositionInLine():0));
            			n.setMsb(msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1);
            			n.setLsb(lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1);
            			n.setFileName(input.getSourceName());
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:198:3: ( COLON ( netAttr[n] )+ )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==COLON) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:198:4: COLON ( netAttr[n] )+
                    {
                    match(input,COLON,FOLLOW_COLON_in_netDecl435); 
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:198:10: ( netAttr[n] )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==IDENT) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:198:10: netAttr[n]
                    	    {
                    	    pushFollow(FOLLOW_netAttr_in_netDecl437);
                    	    netAttr(n);

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:207:1: netAttr[NetDecl n] : IDENT ;
    public final void netAttr(NetDecl n) throws RecognitionException {
        CommonTree IDENT2=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:210:2: ( IDENT )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:210:4: IDENT
            {
            IDENT2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netAttr470); 
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:218:1: attrDecl[DeviceDecl d] : ^( EQUALS name= IDENT value= STRING_LITERAL ) ;
    public final void attrDecl(DeviceDecl d) throws RecognitionException {
        CommonTree name=null;
        CommonTree value=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:222:2: ( ^( EQUALS name= IDENT value= STRING_LITERAL ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:222:4: ^( EQUALS name= IDENT value= STRING_LITERAL )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_attrDecl494); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attrDecl498); 
            value=(CommonTree)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_attrDecl502); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:237:1: pinDecl[DeviceDecl d] : ( ^( 'pin' addPinDecl[d, pin] ) | ^( 'in' addPinDecl[d, in] ) | ^( 'out' addPinDecl[d, out] ) | ^( 'inout' addPinDecl[d, inout] ) | ^( 'passive' addPinDecl[d, passive] ) | ^( 'supply' addPinDecl[d, supply] ) | ^( 'power' addPinDecl[d, power] ) );
    public final void pinDecl(DeviceDecl d) throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:242:2: ( ^( 'pin' addPinDecl[d, pin] ) | ^( 'in' addPinDecl[d, in] ) | ^( 'out' addPinDecl[d, out] ) | ^( 'inout' addPinDecl[d, inout] ) | ^( 'passive' addPinDecl[d, passive] ) | ^( 'supply' addPinDecl[d, supply] ) | ^( 'power' addPinDecl[d, power] ) )
            int alt11=7;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt11=1;
                }
                break;
            case 26:
                {
                alt11=2;
                }
                break;
            case 27:
                {
                alt11=3;
                }
                break;
            case 28:
                {
                alt11=4;
                }
                break;
            case 29:
                {
                alt11=5;
                }
                break;
            case 30:
                {
                alt11=6;
                }
                break;
            case 31:
                {
                alt11=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:242:4: ^( 'pin' addPinDecl[d, pin] )
                    {
                    match(input,25,FOLLOW_25_in_pinDecl529); 

                    PinDecl pin = new PinDecl(Type.PIN);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPinDecl_in_pinDecl533);
                    addPinDecl(d, pin);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:243:4: ^( 'in' addPinDecl[d, in] )
                    {
                    match(input,26,FOLLOW_26_in_pinDecl541); 

                    PinDecl in = new PinDecl(Type.IN);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPinDecl_in_pinDecl545);
                    addPinDecl(d, in);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:244:4: ^( 'out' addPinDecl[d, out] )
                    {
                    match(input,27,FOLLOW_27_in_pinDecl553); 

                    PinDecl out = new PinDecl(Type.OUT);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPinDecl_in_pinDecl557);
                    addPinDecl(d, out);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:245:4: ^( 'inout' addPinDecl[d, inout] )
                    {
                    match(input,28,FOLLOW_28_in_pinDecl565); 

                    PinDecl inout = new PinDecl(Type.INOUT);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPinDecl_in_pinDecl569);
                    addPinDecl(d, inout);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:246:4: ^( 'passive' addPinDecl[d, passive] )
                    {
                    match(input,29,FOLLOW_29_in_pinDecl577); 

                    PinDecl passive = new PinDecl(Type.PASSIVE);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPinDecl_in_pinDecl581);
                    addPinDecl(d, passive);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:247:4: ^( 'supply' addPinDecl[d, supply] )
                    {
                    match(input,30,FOLLOW_30_in_pinDecl589); 

                    PinDecl supply = new PinDecl(Type.SUPPLY);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPinDecl_in_pinDecl593);
                    addPinDecl(d, supply);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 7 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:248:4: ^( 'power' addPinDecl[d, power] )
                    {
                    match(input,31,FOLLOW_31_in_pinDecl601); 

                    PinDecl power = new PinDecl(Type.POWER);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPinDecl_in_pinDecl605);
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:251:1: addPinDecl[DeviceDecl d, PinDecl p] : (msb= INT COLON lsb= INT )? name= IDENT pinList= NUMBER_LIST ;
    public final void addPinDecl(DeviceDecl d, PinDecl p) throws RecognitionException {
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree name=null;
        CommonTree pinList=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:255:2: ( (msb= INT COLON lsb= INT )? name= IDENT pinList= NUMBER_LIST )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:255:4: (msb= INT COLON lsb= INT )? name= IDENT pinList= NUMBER_LIST
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:255:4: (msb= INT COLON lsb= INT )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==INT) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:255:5: msb= INT COLON lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_addPinDecl625); 
                    match(input,COLON,FOLLOW_COLON_in_addPinDecl627); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_addPinDecl631); 

                    }
                    break;

            }

            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_addPinDecl637); 
            pinList=(CommonTree)match(input,NUMBER_LIST,FOLLOW_NUMBER_LIST_in_addPinDecl641); 
            	
            			p.setName((name!=null?name.getText():null));
            			p.setLine((name!=null?name.getLine():0));
            			p.setPos((name!=null?name.getCharPositionInLine():0));
            			p.setMsb(msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1);
            			p.setLsb(lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1);
            			p.setPinList((pinList!=null?pinList.getText():null));
            			p.setFileName(input.getSourceName());
            			
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


    // $ANTLR start "instance"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:270:1: instance[DesignDecl d] : ^( 'inst' name= IDENT refName= IDENT (msb= INT COLON lsb= INT )? ( attrAssign[i] )* 'begin' ( pinAssign[i] )* ) ;
    public final void instance(DesignDecl d) throws RecognitionException {
        CommonTree name=null;
        CommonTree refName=null;
        CommonTree msb=null;
        CommonTree lsb=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:274:2: ( ^( 'inst' name= IDENT refName= IDENT (msb= INT COLON lsb= INT )? ( attrAssign[i] )* 'begin' ( pinAssign[i] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:274:4: ^( 'inst' name= IDENT refName= IDENT (msb= INT COLON lsb= INT )? ( attrAssign[i] )* 'begin' ( pinAssign[i] )* )
            {
            match(input,36,FOLLOW_36_in_instance662); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instance666); 
            refName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instance670); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:274:38: (msb= INT COLON lsb= INT )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==INT) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:274:39: msb= INT COLON lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_instance675); 
                    match(input,COLON,FOLLOW_COLON_in_instance677); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_instance681); 

                    }
                    break;

            }

            	
            			InstDecl i = new InstDecl();
            				i.setName((name!=null?name.getText():null));
            				i.setLine((name!=null?name.getLine():0));
            				i.setPos((name!=null?name.getCharPositionInLine():0));
            				i.setMsb(msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1);
            				i.setLsb(lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1);
            				i.setRefName((refName!=null?refName.getText():null));
            				i.setFileName(input.getSourceName());
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:288:3: ( attrAssign[i] )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==EQUALS) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:288:3: attrAssign[i]
            	    {
            	    pushFollow(FOLLOW_attrAssign_in_instance702);
            	    attrAssign(i);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            match(input,22,FOLLOW_22_in_instance708); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:290:3: ( pinAssign[i] )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==EQUALS) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:290:3: pinAssign[i]
            	    {
            	    pushFollow(FOLLOW_pinAssign_in_instance712);
            	    pinAssign(i);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // $ANTLR end "instance"


    // $ANTLR start "attrAssign"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:297:1: attrAssign[InstDecl i] : ^( EQUALS name= IDENT ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )? value= STRING_LITERAL ) ;
    public final void attrAssign(InstDecl i) throws RecognitionException {
        CommonTree name=null;
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree index=null;
        CommonTree indices=null;
        CommonTree value=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:303:2: ( ^( EQUALS name= IDENT ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )? value= STRING_LITERAL ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:303:4: ^( EQUALS name= IDENT ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )? value= STRING_LITERAL )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_attrAssign737); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attrAssign741); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:304:3: ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )?
            int alt16=4;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==INT) ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==COLON) ) {
                    alt16=1;
                }
                else if ( (LA16_1==STRING_LITERAL) ) {
                    alt16=2;
                }
            }
            else if ( (LA16_0==NUMBER_LIST) ) {
                alt16=3;
            }
            switch (alt16) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:304:4: (msb= INT COLON lsb= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:304:4: (msb= INT COLON lsb= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:304:5: msb= INT COLON lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_attrAssign750); 
                    match(input,COLON,FOLLOW_COLON_in_attrAssign752); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_attrAssign756); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:304:30: (index= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:304:30: (index= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:304:31: index= INT
                    {
                    index=(CommonTree)match(input,INT,FOLLOW_INT_in_attrAssign764); 

                    }


                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:304:44: indices= NUMBER_LIST
                    {
                    indices=(CommonTree)match(input,NUMBER_LIST,FOLLOW_NUMBER_LIST_in_attrAssign771); 

                    }
                    break;

            }

            value=(CommonTree)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_attrAssign780); 

            match(input, Token.UP, null); 
            	AttrAssign a = new AttrAssign();
            			a.setName((name!=null?name.getText():null));
            			a.setLine((name!=null?name.getLine():0));
            			a.setPos((name!=null?name.getCharPositionInLine():0));
            			a.setMsb(msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1);
            			a.setLsb(lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1);
            			a.setIndex(index!=null?Integer.parseInt((index!=null?index.getText():null)):-1);
            			a.setIndices((indices!=null?indices.getText():null));
            			a.setValue((value!=null?value.getText():null));
            			a.setFileName(input.getSourceName());
            			
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:325:1: pinAssign[InstDecl i] : ^( EQUALS name= IDENT ( ( (instMsb= INT COLON instLsb= INT ) | (instIndex= INT | instIndices= NUMBER_LIST ) ) ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )? )? ( concatPin[p] )* ) ;
    public final void pinAssign(InstDecl i) throws RecognitionException {
        CommonTree name=null;
        CommonTree instMsb=null;
        CommonTree instLsb=null;
        CommonTree instIndex=null;
        CommonTree instIndices=null;
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree index=null;
        CommonTree indices=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:329:2: ( ^( EQUALS name= IDENT ( ( (instMsb= INT COLON instLsb= INT ) | (instIndex= INT | instIndices= NUMBER_LIST ) ) ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )? )? ( concatPin[p] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:329:4: ^( EQUALS name= IDENT ( ( (instMsb= INT COLON instLsb= INT ) | (instIndex= INT | instIndices= NUMBER_LIST ) ) ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )? )? ( concatPin[p] )* )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_pinAssign809); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinAssign813); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:330:3: ( ( (instMsb= INT COLON instLsb= INT ) | (instIndex= INT | instIndices= NUMBER_LIST ) ) ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )? )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==NUMBER_LIST||LA20_0==INT) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:330:4: ( (instMsb= INT COLON instLsb= INT ) | (instIndex= INT | instIndices= NUMBER_LIST ) ) ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )?
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:330:4: ( (instMsb= INT COLON instLsb= INT ) | (instIndex= INT | instIndices= NUMBER_LIST ) )
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==INT) ) {
                        int LA18_1 = input.LA(2);

                        if ( (LA18_1==COLON) ) {
                            alt18=1;
                        }
                        else if ( ((LA18_1>=UP && LA18_1<=IDENT)||LA18_1==NUMBER_LIST||LA18_1==INT) ) {
                            alt18=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 18, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA18_0==NUMBER_LIST) ) {
                        alt18=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 0, input);

                        throw nvae;
                    }
                    switch (alt18) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:330:5: (instMsb= INT COLON instLsb= INT )
                            {
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:330:5: (instMsb= INT COLON instLsb= INT )
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:330:6: instMsb= INT COLON instLsb= INT
                            {
                            instMsb=(CommonTree)match(input,INT,FOLLOW_INT_in_pinAssign823); 
                            match(input,COLON,FOLLOW_COLON_in_pinAssign825); 
                            instLsb=(CommonTree)match(input,INT,FOLLOW_INT_in_pinAssign829); 

                            }


                            }
                            break;
                        case 2 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:330:39: (instIndex= INT | instIndices= NUMBER_LIST )
                            {
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:330:39: (instIndex= INT | instIndices= NUMBER_LIST )
                            int alt17=2;
                            int LA17_0 = input.LA(1);

                            if ( (LA17_0==INT) ) {
                                alt17=1;
                            }
                            else if ( (LA17_0==NUMBER_LIST) ) {
                                alt17=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 17, 0, input);

                                throw nvae;
                            }
                            switch (alt17) {
                                case 1 :
                                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:330:40: instIndex= INT
                                    {
                                    instIndex=(CommonTree)match(input,INT,FOLLOW_INT_in_pinAssign837); 

                                    }
                                    break;
                                case 2 :
                                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:330:56: instIndices= NUMBER_LIST
                                    {
                                    instIndices=(CommonTree)match(input,NUMBER_LIST,FOLLOW_NUMBER_LIST_in_pinAssign843); 

                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:331:3: ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )?
                    int alt19=4;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==INT) ) {
                        int LA19_1 = input.LA(2);

                        if ( (LA19_1==COLON) ) {
                            alt19=1;
                        }
                        else if ( ((LA19_1>=UP && LA19_1<=IDENT)) ) {
                            alt19=2;
                        }
                    }
                    else if ( (LA19_0==NUMBER_LIST) ) {
                        alt19=3;
                    }
                    switch (alt19) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:331:4: (msb= INT COLON lsb= INT )
                            {
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:331:4: (msb= INT COLON lsb= INT )
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:331:5: msb= INT COLON lsb= INT
                            {
                            msb=(CommonTree)match(input,INT,FOLLOW_INT_in_pinAssign853); 
                            match(input,COLON,FOLLOW_COLON_in_pinAssign855); 
                            lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_pinAssign859); 

                            }


                            }
                            break;
                        case 2 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:331:30: (index= INT )
                            {
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:331:30: (index= INT )
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:331:31: index= INT
                            {
                            index=(CommonTree)match(input,INT,FOLLOW_INT_in_pinAssign867); 

                            }


                            }
                            break;
                        case 3 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:331:44: indices= NUMBER_LIST
                            {
                            indices=(CommonTree)match(input,NUMBER_LIST,FOLLOW_NUMBER_LIST_in_pinAssign874); 

                            }
                            break;

                    }


                    }
                    break;

            }


            			PinAssign p = new PinAssign();
            			p.setName((name!=null?name.getText():null));
            			p.setLine((name!=null?name.getLine():0));
            			p.setPos((name!=null?name.getCharPositionInLine():0));
            			p.setInstMsb(instMsb!=null?Integer.parseInt((instMsb!=null?instMsb.getText():null)):-1);
            			p.setInstLsb(instLsb!=null?Integer.parseInt((instLsb!=null?instLsb.getText():null)):-1);
            			p.setInstIndex(instIndex!=null?Integer.parseInt((instIndex!=null?instIndex.getText():null)):-1);
            			p.setInstIndices((instIndices!=null?instIndices.getText():null));
            			p.setMsb(msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1);
            			p.setLsb(lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1);
            			p.setIndex(index!=null?Integer.parseInt((index!=null?index.getText():null)):-1);
            			p.setIndices((indices!=null?indices.getText():null));
            			p.setFileName(input.getSourceName());
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:350:3: ( concatPin[p] )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==IDENT) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:350:3: concatPin[p]
            	    {
            	    pushFollow(FOLLOW_concatPin_in_pinAssign893);
            	    concatPin(p);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:357:1: concatPin[PinAssign pa] : (name= IDENT ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )? ) ;
    public final void concatPin(PinAssign pa) throws RecognitionException {
        CommonTree name=null;
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree index=null;
        CommonTree indices=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:361:2: ( (name= IDENT ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )? ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:361:4: (name= IDENT ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )? )
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:361:4: (name= IDENT ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )? )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:361:5: name= IDENT ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )?
            {
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatPin921); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:361:16: ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )?
            int alt22=4;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==INT) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==COLON) ) {
                    alt22=1;
                }
                else if ( ((LA22_1>=UP && LA22_1<=IDENT)) ) {
                    alt22=2;
                }
            }
            else if ( (LA22_0==NUMBER_LIST) ) {
                alt22=3;
            }
            switch (alt22) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:361:17: (msb= INT COLON lsb= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:361:17: (msb= INT COLON lsb= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:361:18: msb= INT COLON lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_concatPin927); 
                    match(input,COLON,FOLLOW_COLON_in_concatPin929); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_concatPin933); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:361:43: (index= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:361:43: (index= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:361:44: index= INT
                    {
                    index=(CommonTree)match(input,INT,FOLLOW_INT_in_concatPin941); 

                    }


                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:361:57: indices= NUMBER_LIST
                    {
                    indices=(CommonTree)match(input,NUMBER_LIST,FOLLOW_NUMBER_LIST_in_concatPin948); 

                    }
                    break;

            }


            }


            			Net n = new Net();
            			n.setName((name!=null?name.getText():null));
            			n.setLine((name!=null?name.getLine():0));
            			n.setPos((name!=null?name.getCharPositionInLine():0));
            			n.setMsb(msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1);
            			n.setLsb(lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1);
            			n.setIndex(index!=null?Integer.parseInt((index!=null?index.getText():null)):-1);
            			n.setIndices((indices!=null?indices.getText():null));
            			n.setFileName(input.getSourceName());
            			pa.addNet(n);
            		

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


    // $ANTLR start "subDesign"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:376:1: subDesign[DesignDecl d] : ^( 'sub' name= IDENT refName= IDENT (msb= INT COLON lsb= INT )? ( subAttrAssign[s] )* 'begin' ( portAssignment[s] )* ) ;
    public final void subDesign(DesignDecl d) throws RecognitionException {
        CommonTree name=null;
        CommonTree refName=null;
        CommonTree msb=null;
        CommonTree lsb=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:380:2: ( ^( 'sub' name= IDENT refName= IDENT (msb= INT COLON lsb= INT )? ( subAttrAssign[s] )* 'begin' ( portAssignment[s] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:380:4: ^( 'sub' name= IDENT refName= IDENT (msb= INT COLON lsb= INT )? ( subAttrAssign[s] )* 'begin' ( portAssignment[s] )* )
            {
            match(input,37,FOLLOW_37_in_subDesign971); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_subDesign975); 
            refName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_subDesign979); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:380:37: (msb= INT COLON lsb= INT )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==INT) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:380:38: msb= INT COLON lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_subDesign984); 
                    match(input,COLON,FOLLOW_COLON_in_subDesign986); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_subDesign990); 

                    }
                    break;

            }

            	
            			SubDecl s = new SubDecl();
            			s.setName((name!=null?name.getText():null));
            			s.setLine((name!=null?name.getLine():0));
            			s.setPos((name!=null?name.getCharPositionInLine():0));
            			s.setMsb(msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1);
            			s.setLsb(lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1);
            			s.setRefName((refName!=null?refName.getText():null));
            			s.setFileName(input.getSourceName());
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:393:3: ( subAttrAssign[s] )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==IDENT) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:393:3: subAttrAssign[s]
            	    {
            	    pushFollow(FOLLOW_subAttrAssign_in_subDesign1006);
            	    subAttrAssign(s);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            match(input,22,FOLLOW_22_in_subDesign1012); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:395:3: ( portAssignment[s] )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==EQUALS) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:395:3: portAssignment[s]
            	    {
            	    pushFollow(FOLLOW_portAssignment_in_subDesign1016);
            	    portAssignment(s);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            match(input, Token.UP, null); 
            	if(!d.addSubDecl(s)) 
            				addError(s, "duplicate sub-design declaration");
            		

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
    // $ANTLR end "subDesign"


    // $ANTLR start "subAttrAssign"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:402:1: subAttrAssign[SubDecl s] : ^(instName= IDENT name= IDENT ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )? value= STRING_LITERAL ) ;
    public final void subAttrAssign(SubDecl s) throws RecognitionException {
        CommonTree instName=null;
        CommonTree name=null;
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree index=null;
        CommonTree indices=null;
        CommonTree value=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:409:2: ( ^(instName= IDENT name= IDENT ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )? value= STRING_LITERAL ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:409:4: ^(instName= IDENT name= IDENT ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )? value= STRING_LITERAL )
            {
            instName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_subAttrAssign1044); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_subAttrAssign1048); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:410:3: ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )?
            int alt26=4;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==INT) ) {
                int LA26_1 = input.LA(2);

                if ( (LA26_1==COLON) ) {
                    alt26=1;
                }
                else if ( (LA26_1==STRING_LITERAL) ) {
                    alt26=2;
                }
            }
            else if ( (LA26_0==NUMBER_LIST) ) {
                alt26=3;
            }
            switch (alt26) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:410:4: (msb= INT COLON lsb= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:410:4: (msb= INT COLON lsb= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:410:5: msb= INT COLON lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_subAttrAssign1057); 
                    match(input,COLON,FOLLOW_COLON_in_subAttrAssign1059); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_subAttrAssign1063); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:410:30: (index= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:410:30: (index= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:410:31: index= INT
                    {
                    index=(CommonTree)match(input,INT,FOLLOW_INT_in_subAttrAssign1071); 

                    }


                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:410:44: indices= NUMBER_LIST
                    {
                    indices=(CommonTree)match(input,NUMBER_LIST,FOLLOW_NUMBER_LIST_in_subAttrAssign1078); 

                    }
                    break;

            }

            value=(CommonTree)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_subAttrAssign1087); 

            match(input, Token.UP, null); 
            	SubAttrAssign a = new SubAttrAssign();
            			a.setInstName((instName!=null?instName.getText():null));
            			a.setName((name!=null?name.getText():null));
            			a.setLine((name!=null?name.getLine():0));
            			a.setPos((name!=null?name.getCharPositionInLine():0));
            			a.setMsb(msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1);
            			a.setLsb(lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1);
            			a.setIndex(index!=null?Integer.parseInt((index!=null?index.getText():null)):-1);
            			a.setIndices((indices!=null?indices.getText():null));
            			a.setValue((value!=null?value.getText():null));
            			a.setFileName(input.getSourceName());
            			
            			if(!s.addSubAttrAssign(a)) 
            				addError(a, "duplicate sub-design attribute assignment");
            		

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
    // $ANTLR end "subAttrAssign"


    // $ANTLR start "netAssign"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:433:1: netAssign[DesignDecl d] : ^( EQUALS name= IDENT ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )? ( concatNet[n] )* ) ;
    public final void netAssign(DesignDecl d) throws RecognitionException {
        CommonTree name=null;
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree index=null;
        CommonTree indices=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:437:2: ( ^( EQUALS name= IDENT ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )? ( concatNet[n] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:437:4: ^( EQUALS name= IDENT ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )? ( concatNet[n] )* )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_netAssign1118); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netAssign1122); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:437:24: ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )?
            int alt27=4;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==INT) ) {
                int LA27_1 = input.LA(2);

                if ( (LA27_1==COLON) ) {
                    alt27=1;
                }
                else if ( ((LA27_1>=UP && LA27_1<=IDENT)) ) {
                    alt27=2;
                }
            }
            else if ( (LA27_0==NUMBER_LIST) ) {
                alt27=3;
            }
            switch (alt27) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:437:25: (msb= INT COLON lsb= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:437:25: (msb= INT COLON lsb= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:437:26: msb= INT COLON lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_netAssign1128); 
                    match(input,COLON,FOLLOW_COLON_in_netAssign1130); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_netAssign1134); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:437:51: (index= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:437:51: (index= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:437:52: index= INT
                    {
                    index=(CommonTree)match(input,INT,FOLLOW_INT_in_netAssign1142); 

                    }


                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:437:65: indices= NUMBER_LIST
                    {
                    indices=(CommonTree)match(input,NUMBER_LIST,FOLLOW_NUMBER_LIST_in_netAssign1149); 

                    }
                    break;

            }

            	NetAssign n = new NetAssign(); 
            			n.setName((name!=null?name.getText():null));
            			n.setLine((name!=null?name.getLine():0));
            			n.setPos((name!=null?name.getCharPositionInLine():0));
            			n.setMsb(msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1);
            			n.setLsb(lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1);
            			n.setIndex(index!=null?Integer.parseInt((index!=null?index.getText():null)):-1);
            			n.setIndices((indices!=null?indices.getText():null));
            			n.setFileName(input.getSourceName());
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:451:3: ( concatNet[n] )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==IDENT) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:451:3: concatNet[n]
            	    {
            	    pushFollow(FOLLOW_concatNet_in_netAssign1168);
            	    concatNet(n);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:458:1: concatNet[NetAssign na] : (name= IDENT ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )? ) ;
    public final void concatNet(NetAssign na) throws RecognitionException {
        CommonTree name=null;
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree index=null;
        CommonTree indices=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:462:2: ( (name= IDENT ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )? ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:462:4: (name= IDENT ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )? )
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:462:4: (name= IDENT ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )? )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:462:5: name= IDENT ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )?
            {
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatNet1196); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:462:16: ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )?
            int alt29=4;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==INT) ) {
                int LA29_1 = input.LA(2);

                if ( (LA29_1==COLON) ) {
                    alt29=1;
                }
                else if ( ((LA29_1>=UP && LA29_1<=IDENT)) ) {
                    alt29=2;
                }
            }
            else if ( (LA29_0==NUMBER_LIST) ) {
                alt29=3;
            }
            switch (alt29) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:462:17: (msb= INT COLON lsb= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:462:17: (msb= INT COLON lsb= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:462:18: msb= INT COLON lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_concatNet1202); 
                    match(input,COLON,FOLLOW_COLON_in_concatNet1204); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_concatNet1208); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:462:43: (index= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:462:43: (index= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:462:44: index= INT
                    {
                    index=(CommonTree)match(input,INT,FOLLOW_INT_in_concatNet1216); 

                    }


                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:462:57: indices= NUMBER_LIST
                    {
                    indices=(CommonTree)match(input,NUMBER_LIST,FOLLOW_NUMBER_LIST_in_concatNet1223); 

                    }
                    break;

            }


            }

            	Net n = new Net();
            			n.setName((name!=null?name.getText():null));
            			n.setLine((name!=null?name.getLine():0));
            			n.setPos((name!=null?name.getCharPositionInLine():0));
            			n.setMsb(msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1);
            			n.setLsb(lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1);
            			n.setIndex(index!=null?Integer.parseInt((index!=null?index.getText():null)):-1);
            			n.setIndices((indices!=null?indices.getText():null));
            			n.setFileName(input.getSourceName());
            			na.addNet(n);
            		

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


    // $ANTLR start "portAssignment"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:478:1: portAssignment[SubDecl s] : ^( EQUALS name= IDENT ( ( (instMsb= INT COLON instLsb= INT ) | (instIndex= INT ) | instIndices= NUMBER_LIST ) ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )? )? ( concatPort[p] )* ) ;
    public final void portAssignment(SubDecl s) throws RecognitionException {
        CommonTree name=null;
        CommonTree instMsb=null;
        CommonTree instLsb=null;
        CommonTree instIndex=null;
        CommonTree instIndices=null;
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree index=null;
        CommonTree indices=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:482:2: ( ^( EQUALS name= IDENT ( ( (instMsb= INT COLON instLsb= INT ) | (instIndex= INT ) | instIndices= NUMBER_LIST ) ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )? )? ( concatPort[p] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:482:4: ^( EQUALS name= IDENT ( ( (instMsb= INT COLON instLsb= INT ) | (instIndex= INT ) | instIndices= NUMBER_LIST ) ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )? )? ( concatPort[p] )* )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_portAssignment1252); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_portAssignment1256); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:483:3: ( ( (instMsb= INT COLON instLsb= INT ) | (instIndex= INT ) | instIndices= NUMBER_LIST ) ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )? )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==NUMBER_LIST||LA32_0==INT) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:483:4: ( (instMsb= INT COLON instLsb= INT ) | (instIndex= INT ) | instIndices= NUMBER_LIST ) ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )?
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:483:4: ( (instMsb= INT COLON instLsb= INT ) | (instIndex= INT ) | instIndices= NUMBER_LIST )
                    int alt30=3;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==INT) ) {
                        int LA30_1 = input.LA(2);

                        if ( (LA30_1==COLON) ) {
                            alt30=1;
                        }
                        else if ( ((LA30_1>=UP && LA30_1<=IDENT)||LA30_1==NUMBER_LIST||LA30_1==INT) ) {
                            alt30=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 30, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA30_0==NUMBER_LIST) ) {
                        alt30=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 30, 0, input);

                        throw nvae;
                    }
                    switch (alt30) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:483:5: (instMsb= INT COLON instLsb= INT )
                            {
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:483:5: (instMsb= INT COLON instLsb= INT )
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:483:6: instMsb= INT COLON instLsb= INT
                            {
                            instMsb=(CommonTree)match(input,INT,FOLLOW_INT_in_portAssignment1266); 
                            match(input,COLON,FOLLOW_COLON_in_portAssignment1268); 
                            instLsb=(CommonTree)match(input,INT,FOLLOW_INT_in_portAssignment1272); 

                            }


                            }
                            break;
                        case 2 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:483:39: (instIndex= INT )
                            {
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:483:39: (instIndex= INT )
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:483:40: instIndex= INT
                            {
                            instIndex=(CommonTree)match(input,INT,FOLLOW_INT_in_portAssignment1280); 

                            }


                            }
                            break;
                        case 3 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:483:57: instIndices= NUMBER_LIST
                            {
                            instIndices=(CommonTree)match(input,NUMBER_LIST,FOLLOW_NUMBER_LIST_in_portAssignment1287); 

                            }
                            break;

                    }

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:484:3: ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )?
                    int alt31=4;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==INT) ) {
                        int LA31_1 = input.LA(2);

                        if ( (LA31_1==COLON) ) {
                            alt31=1;
                        }
                        else if ( ((LA31_1>=UP && LA31_1<=IDENT)) ) {
                            alt31=2;
                        }
                    }
                    else if ( (LA31_0==NUMBER_LIST) ) {
                        alt31=3;
                    }
                    switch (alt31) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:484:4: (msb= INT COLON lsb= INT )
                            {
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:484:4: (msb= INT COLON lsb= INT )
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:484:5: msb= INT COLON lsb= INT
                            {
                            msb=(CommonTree)match(input,INT,FOLLOW_INT_in_portAssignment1296); 
                            match(input,COLON,FOLLOW_COLON_in_portAssignment1298); 
                            lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_portAssignment1302); 

                            }


                            }
                            break;
                        case 2 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:484:30: (index= INT )
                            {
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:484:30: (index= INT )
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:484:31: index= INT
                            {
                            index=(CommonTree)match(input,INT,FOLLOW_INT_in_portAssignment1310); 

                            }


                            }
                            break;
                        case 3 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:484:44: indices= NUMBER_LIST
                            {
                            indices=(CommonTree)match(input,NUMBER_LIST,FOLLOW_NUMBER_LIST_in_portAssignment1317); 

                            }
                            break;

                    }


                    }
                    break;

            }

            	PortAssign p = new PortAssign(); 
            			p.setName((name!=null?name.getText():null));
            			p.setLine((name!=null?name.getLine():0));
            			p.setPos((name!=null?name.getCharPositionInLine():0));
            			p.setInstMsb(instMsb!=null?Integer.parseInt((instMsb!=null?instMsb.getText():null)):-1);
            			p.setInstLsb(instLsb!=null?Integer.parseInt((instLsb!=null?instLsb.getText():null)):-1);
            			p.setInstIndex(instIndex!=null?Integer.parseInt((instIndex!=null?instIndex.getText():null)):-1);
            			p.setInstIndices((instIndices!=null?instIndices.getText():null));
            			p.setMsb(msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1);
            			p.setLsb(lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1);
            			p.setIndex(index!=null?Integer.parseInt((index!=null?index.getText():null)):-1);
            			p.setIndices((indices!=null?indices.getText():null));
            			p.setFileName(input.getSourceName());
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:502:3: ( concatPort[p] )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==IDENT) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:502:3: concatPort[p]
            	    {
            	    pushFollow(FOLLOW_concatPort_in_portAssignment1336);
            	    concatPort(p);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            match(input, Token.UP, null); 
            	if(!s.addPortAssign(p)) 
            				addError(p, "duplicate port assignment");
            		

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
    // $ANTLR end "portAssignment"


    // $ANTLR start "concatPort"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:509:1: concatPort[PortAssign pa] : (name= IDENT ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )? ) ;
    public final void concatPort(PortAssign pa) throws RecognitionException {
        CommonTree name=null;
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree index=null;
        CommonTree indices=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:513:2: ( (name= IDENT ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )? ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:513:4: (name= IDENT ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )? )
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:513:4: (name= IDENT ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )? )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:513:5: name= IDENT ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )?
            {
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatPort1364); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:513:16: ( (msb= INT COLON lsb= INT ) | (index= INT ) | indices= NUMBER_LIST )?
            int alt34=4;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==INT) ) {
                int LA34_1 = input.LA(2);

                if ( (LA34_1==COLON) ) {
                    alt34=1;
                }
                else if ( ((LA34_1>=UP && LA34_1<=IDENT)) ) {
                    alt34=2;
                }
            }
            else if ( (LA34_0==NUMBER_LIST) ) {
                alt34=3;
            }
            switch (alt34) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:513:17: (msb= INT COLON lsb= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:513:17: (msb= INT COLON lsb= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:513:18: msb= INT COLON lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_concatPort1370); 
                    match(input,COLON,FOLLOW_COLON_in_concatPort1372); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_concatPort1376); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:513:43: (index= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:513:43: (index= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:513:44: index= INT
                    {
                    index=(CommonTree)match(input,INT,FOLLOW_INT_in_concatPort1384); 

                    }


                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:513:57: indices= NUMBER_LIST
                    {
                    indices=(CommonTree)match(input,NUMBER_LIST,FOLLOW_NUMBER_LIST_in_concatPort1391); 

                    }
                    break;

            }


            }

            	Net n = new Net();
            			n.setName((name!=null?name.getText():null));
            			n.setLine((name!=null?name.getLine():0));
            			n.setPos((name!=null?name.getCharPositionInLine():0));
            			n.setMsb(msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1);
            			n.setLsb(lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1);
            			n.setIndex(index!=null?Integer.parseInt((index!=null?index.getText():null)):-1);
            			n.setFileName(input.getSourceName());
            			pa.addNet(n);
            		

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
    // $ANTLR end "concatPort"

    // Delegated rules


 

    public static final BitSet FOLLOW_design_in_sourceText69 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_design91 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_design93 = new BitSet(new long[]{0x00000002FF400000L});
    public static final BitSet FOLLOW_portDecl_in_design115 = new BitSet(new long[]{0x00000002FF400000L});
    public static final BitSet FOLLOW_deviceDecl_in_design120 = new BitSet(new long[]{0x00000002FF400000L});
    public static final BitSet FOLLOW_netDecl_in_design125 = new BitSet(new long[]{0x00000002FF400000L});
    public static final BitSet FOLLOW_22_in_design138 = new BitSet(new long[]{0x0000003000000048L});
    public static final BitSet FOLLOW_instance_in_design149 = new BitSet(new long[]{0x0000003000000048L});
    public static final BitSet FOLLOW_subDesign_in_design154 = new BitSet(new long[]{0x0000003000000048L});
    public static final BitSet FOLLOW_netAssign_in_design159 = new BitSet(new long[]{0x0000003000000048L});
    public static final BitSet FOLLOW_25_in_portDecl188 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPort_in_portDecl192 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_26_in_portDecl200 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPort_in_portDecl204 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_27_in_portDecl212 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPort_in_portDecl216 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_28_in_portDecl224 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPort_in_portDecl228 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_29_in_portDecl236 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPort_in_portDecl240 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_30_in_portDecl248 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPort_in_portDecl252 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_31_in_portDecl260 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPort_in_portDecl264 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INT_in_addPort284 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_addPort286 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_addPort290 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_addPort296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_deviceDecl316 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl320 = new BitSet(new long[]{0x0000000000400040L});
    public static final BitSet FOLLOW_attrDecl_in_deviceDecl343 = new BitSet(new long[]{0x0000000000400040L});
    public static final BitSet FOLLOW_22_in_deviceDecl355 = new BitSet(new long[]{0x00000000FE000008L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl365 = new BitSet(new long[]{0x00000000FE000008L});
    public static final BitSet FOLLOW_33_in_netDecl400 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_netDecl405 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_netDecl407 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_netDecl411 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl417 = new BitSet(new long[]{0x0000000000000408L});
    public static final BitSet FOLLOW_COLON_in_netDecl435 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_netAttr_in_netDecl437 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_IDENT_in_netAttr470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUALS_in_attrDecl494 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_attrDecl498 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_attrDecl502 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_25_in_pinDecl529 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPinDecl_in_pinDecl533 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_26_in_pinDecl541 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPinDecl_in_pinDecl545 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_27_in_pinDecl553 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPinDecl_in_pinDecl557 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_28_in_pinDecl565 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPinDecl_in_pinDecl569 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_29_in_pinDecl577 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPinDecl_in_pinDecl581 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_30_in_pinDecl589 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPinDecl_in_pinDecl593 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_31_in_pinDecl601 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPinDecl_in_pinDecl605 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INT_in_addPinDecl625 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_addPinDecl627 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_addPinDecl631 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_addPinDecl637 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_NUMBER_LIST_in_addPinDecl641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_instance662 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_instance666 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instance670 = new BitSet(new long[]{0x0000000000400840L});
    public static final BitSet FOLLOW_INT_in_instance675 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_instance677 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_instance681 = new BitSet(new long[]{0x0000000000400040L});
    public static final BitSet FOLLOW_attrAssign_in_instance702 = new BitSet(new long[]{0x0000000000400040L});
    public static final BitSet FOLLOW_22_in_instance708 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_pinAssign_in_instance712 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_EQUALS_in_attrAssign737 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_attrAssign741 = new BitSet(new long[]{0x0000000000000980L});
    public static final BitSet FOLLOW_INT_in_attrAssign750 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_attrAssign752 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_attrAssign756 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_INT_in_attrAssign764 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NUMBER_LIST_in_attrAssign771 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_attrAssign780 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssign809 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_pinAssign813 = new BitSet(new long[]{0x0000000000000918L});
    public static final BitSet FOLLOW_INT_in_pinAssign823 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_pinAssign825 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_pinAssign829 = new BitSet(new long[]{0x0000000000000918L});
    public static final BitSet FOLLOW_INT_in_pinAssign837 = new BitSet(new long[]{0x0000000000000918L});
    public static final BitSet FOLLOW_NUMBER_LIST_in_pinAssign843 = new BitSet(new long[]{0x0000000000000918L});
    public static final BitSet FOLLOW_INT_in_pinAssign853 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_pinAssign855 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_pinAssign859 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_INT_in_pinAssign867 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_NUMBER_LIST_in_pinAssign874 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_concatPin_in_pinAssign893 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_IDENT_in_concatPin921 = new BitSet(new long[]{0x0000000000000902L});
    public static final BitSet FOLLOW_INT_in_concatPin927 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_concatPin929 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_concatPin933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_concatPin941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_LIST_in_concatPin948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_subDesign971 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_subDesign975 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_subDesign979 = new BitSet(new long[]{0x0000000000400810L});
    public static final BitSet FOLLOW_INT_in_subDesign984 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_subDesign986 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_subDesign990 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_subAttrAssign_in_subDesign1006 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_22_in_subDesign1012 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_portAssignment_in_subDesign1016 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_IDENT_in_subAttrAssign1044 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_subAttrAssign1048 = new BitSet(new long[]{0x0000000000000980L});
    public static final BitSet FOLLOW_INT_in_subAttrAssign1057 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_subAttrAssign1059 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_subAttrAssign1063 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_INT_in_subAttrAssign1071 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NUMBER_LIST_in_subAttrAssign1078 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_subAttrAssign1087 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUALS_in_netAssign1118 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_netAssign1122 = new BitSet(new long[]{0x0000000000000918L});
    public static final BitSet FOLLOW_INT_in_netAssign1128 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_netAssign1130 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_netAssign1134 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_INT_in_netAssign1142 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_NUMBER_LIST_in_netAssign1149 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_concatNet_in_netAssign1168 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_IDENT_in_concatNet1196 = new BitSet(new long[]{0x0000000000000902L});
    public static final BitSet FOLLOW_INT_in_concatNet1202 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_concatNet1204 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_concatNet1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_concatNet1216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_LIST_in_concatNet1223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUALS_in_portAssignment1252 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_portAssignment1256 = new BitSet(new long[]{0x0000000000000918L});
    public static final BitSet FOLLOW_INT_in_portAssignment1266 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_portAssignment1268 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_portAssignment1272 = new BitSet(new long[]{0x0000000000000918L});
    public static final BitSet FOLLOW_INT_in_portAssignment1280 = new BitSet(new long[]{0x0000000000000918L});
    public static final BitSet FOLLOW_NUMBER_LIST_in_portAssignment1287 = new BitSet(new long[]{0x0000000000000918L});
    public static final BitSet FOLLOW_INT_in_portAssignment1296 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_portAssignment1298 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_portAssignment1302 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_INT_in_portAssignment1310 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_NUMBER_LIST_in_portAssignment1317 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_concatPort_in_portAssignment1336 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_IDENT_in_concatPort1364 = new BitSet(new long[]{0x0000000000000902L});
    public static final BitSet FOLLOW_INT_in_concatPort1370 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_concatPort1372 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_concatPort1376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_concatPort1384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_LIST_in_concatPort1391 = new BitSet(new long[]{0x0000000000000002L});

}