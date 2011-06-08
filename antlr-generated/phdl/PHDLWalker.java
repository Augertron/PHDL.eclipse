// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g 2011-06-08 17:32:26

	package phdl;
	import phdl.PHDLDesign;
	import java.util.HashSet;


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
public class PHDLWalker extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "SEMI", "EQUALS", "STRING_LITERAL", "COMMA", "COLON", "INT", "CHAR", "DIGIT", "LBRACKET", "RBRACKET", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "'design'", "'is'", "'begin'", "'end'", "'port'", "'device'", "'pin'", "'in'", "'out'", "'inout'", "'passive'", "'supply'", "'power'", "'open'", "'net'", "'('", "')'", "'inst'", "'sub'", "'&'"
    };
    public static final int EOF=-1;
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
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int IDENT=4;
    public static final int SEMI=5;
    public static final int EQUALS=6;
    public static final int STRING_LITERAL=7;
    public static final int COMMA=8;
    public static final int COLON=9;
    public static final int INT=10;
    public static final int CHAR=11;
    public static final int DIGIT=12;
    public static final int LBRACKET=13;
    public static final int RBRACKET=14;
    public static final int WHITESPACE=15;
    public static final int LINE_COMMENT=16;
    public static final int MULTILINE_COMMENT=17;

    // delegates
    // delegators


        public PHDLWalker(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public PHDLWalker(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PHDLWalker.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g"; }


    	// the set of designs to populate and return by parsing the source text
    	private HashSet<PHDLDesign> designs = new HashSet<PHDLDesign>();



    // $ANTLR start "sourceText"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:45:1: sourceText returns [HashSet<PHDLDesign> d] : ( design )* ;
    public final HashSet<PHDLDesign> sourceText() throws RecognitionException {
        HashSet<PHDLDesign> d = null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:48:2: ( ( design )* )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:48:4: ( design )*
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:48:4: ( design )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==18) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:48:4: design
            	    {
            	    pushFollow(FOLLOW_design_in_sourceText65);
            	    design();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            d = designs;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return d;
    }
    // $ANTLR end "sourceText"


    // $ANTLR start "design"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:53:1: design : ^( 'design' IDENT ( portDecl[design] )* ( deviceDecl[design] | netDecl[design] )* 'begin' ( instance[design] | subDesign[design] | netAssignment[design] )* ) ;
    public final void design() throws RecognitionException {
        CommonTree IDENT1=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:59:2: ( ^( 'design' IDENT ( portDecl[design] )* ( deviceDecl[design] | netDecl[design] )* 'begin' ( instance[design] | subDesign[design] | netAssignment[design] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:59:4: ^( 'design' IDENT ( portDecl[design] )* ( deviceDecl[design] | netDecl[design] )* 'begin' ( instance[design] | subDesign[design] | netAssignment[design] )* )
            {
            match(input,18,FOLLOW_18_in_design88); 

            match(input, Token.DOWN, null); 
            IDENT1=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_design90); 

            				PHDLDesign design = new PHDLDesign((IDENT1!=null?IDENT1.getText():null), (IDENT1!=null?IDENT1.getLine():0), (IDENT1!=null?IDENT1.getCharPositionInLine():0));
            			
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:66:3: ( portDecl[design] )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=24 && LA2_0<=30)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:66:3: portDecl[design]
            	    {
            	    pushFollow(FOLLOW_portDecl_in_design109);
            	    portDecl(design);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:69:3: ( deviceDecl[design] | netDecl[design] )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==23) ) {
                    alt3=1;
                }
                else if ( (LA3_0==32) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:69:4: deviceDecl[design]
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_design123);
            	    deviceDecl(design);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:69:25: netDecl[design]
            	    {
            	    pushFollow(FOLLOW_netDecl_in_design128);
            	    netDecl(design);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match(input,20,FOLLOW_20_in_design141); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:75:3: ( instance[design] | subDesign[design] | netAssignment[design] )*
            loop4:
            do {
                int alt4=4;
                switch ( input.LA(1) ) {
                case 35:
                    {
                    alt4=1;
                    }
                    break;
                case 36:
                    {
                    alt4=2;
                    }
                    break;
                case EQUALS:
                    {
                    alt4=3;
                    }
                    break;

                }

                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:75:4: instance[design]
            	    {
            	    pushFollow(FOLLOW_instance_in_design152);
            	    instance(design);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:75:23: subDesign[design]
            	    {
            	    pushFollow(FOLLOW_subDesign_in_design157);
            	    subDesign(design);

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:75:43: netAssignment[design]
            	    {
            	    pushFollow(FOLLOW_netAssignment_in_design162);
            	    netAssignment(design);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            match(input, Token.UP, null); 

            			designs.add(design);
            		

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:83:1: portDecl[PHDLDesign design] : ( ^( 'pin' addPort[design, pin] ) | ^( 'in' addPort[design, in] ) | ^( 'out' addPort[design, out] ) | ^( 'inout' addPort[design, inout] ) | ^( 'passive' addPort[design, passive] ) | ^( 'supply' addPort[design, supply] ) | ^( 'power' addPort[design, power] ) );
    public final void portDecl(PHDLDesign design) throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:84:2: ( ^( 'pin' addPort[design, pin] ) | ^( 'in' addPort[design, in] ) | ^( 'out' addPort[design, out] ) | ^( 'inout' addPort[design, inout] ) | ^( 'passive' addPort[design, passive] ) | ^( 'supply' addPort[design, supply] ) | ^( 'power' addPort[design, power] ) )
            int alt5=7;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt5=1;
                }
                break;
            case 25:
                {
                alt5=2;
                }
                break;
            case 26:
                {
                alt5=3;
                }
                break;
            case 27:
                {
                alt5=4;
                }
                break;
            case 28:
                {
                alt5=5;
                }
                break;
            case 29:
                {
                alt5=6;
                }
                break;
            case 30:
                {
                alt5=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:84:4: ^( 'pin' addPort[design, pin] )
                    {
                    match(input,24,FOLLOW_24_in_portDecl190); 

                    PHDLPort pin = new PHDLPort(PHDLPinType.PIN);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPort_in_portDecl194);
                    addPort(design, pin);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:85:4: ^( 'in' addPort[design, in] )
                    {
                    match(input,25,FOLLOW_25_in_portDecl202); 

                    PHDLPort in = new PHDLPort(PHDLPinType.IN);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPort_in_portDecl206);
                    addPort(design, in);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:86:4: ^( 'out' addPort[design, out] )
                    {
                    match(input,26,FOLLOW_26_in_portDecl214); 

                    PHDLPort out = new PHDLPort(PHDLPinType.OUT);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPort_in_portDecl218);
                    addPort(design, out);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:87:4: ^( 'inout' addPort[design, inout] )
                    {
                    match(input,27,FOLLOW_27_in_portDecl226); 

                    PHDLPort inout = new PHDLPort(PHDLPinType.INOUT);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPort_in_portDecl230);
                    addPort(design, inout);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:88:4: ^( 'passive' addPort[design, passive] )
                    {
                    match(input,28,FOLLOW_28_in_portDecl238); 

                    PHDLPort passive = new PHDLPort(PHDLPinType.PASSIVE);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPort_in_portDecl242);
                    addPort(design, passive);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:89:4: ^( 'supply' addPort[design, supply] )
                    {
                    match(input,29,FOLLOW_29_in_portDecl250); 

                    PHDLPort supply = new PHDLPort(PHDLPinType.SUPPLY);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPort_in_portDecl254);
                    addPort(design, supply);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 7 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:90:4: ^( 'power' addPort[design, power] )
                    {
                    match(input,30,FOLLOW_30_in_portDecl262); 

                    PHDLPort power = new PHDLPort(PHDLPinType.POWER);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPort_in_portDecl266);
                    addPort(design, power);

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:93:1: addPort[PHDLDesign design, PHDLPort port] : (msb= INT lsb= INT )? name= IDENT ;
    public final void addPort(PHDLDesign design, PHDLPort port) throws RecognitionException {
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree name=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:94:2: ( (msb= INT lsb= INT )? name= IDENT )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:94:4: (msb= INT lsb= INT )? name= IDENT
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:94:4: (msb= INT lsb= INT )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==INT) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:94:5: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_addPort284); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_addPort288); 

                    }
                    break;

            }

            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_addPort294); 
            	
            			port.setMsb(msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1);
            			port.setLsb(lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1);
            			port.setLine((name!=null?name.getLine():0));
            			port.setPos((name!=null?name.getCharPositionInLine():0));
            			port.setName((name!=null?name.getText():null));
            		
            design.addPort(port);

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:105:1: deviceDecl[PHDLDesign design] : ^( 'device' IDENT ( attributeDecl[device] )* 'begin' ( pinDecl[device] )* ) ;
    public final void deviceDecl(PHDLDesign design) throws RecognitionException {
        CommonTree IDENT2=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:112:2: ( ^( 'device' IDENT ( attributeDecl[device] )* 'begin' ( pinDecl[device] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:112:4: ^( 'device' IDENT ( attributeDecl[device] )* 'begin' ( pinDecl[device] )* )
            {
            match(input,23,FOLLOW_23_in_deviceDecl318); 

            match(input, Token.DOWN, null); 
            IDENT2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl320); 

            				PHDLDevice device = new PHDLDevice((IDENT2!=null?IDENT2.getText():null), (IDENT2!=null?IDENT2.getLine():0), (IDENT2!=null?IDENT2.getCharPositionInLine():0));
            			
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:120:3: ( attributeDecl[device] )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==EQUALS) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:120:3: attributeDecl[device]
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_deviceDecl343);
            	    attributeDecl(device);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match(input,20,FOLLOW_20_in_deviceDecl355); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:126:3: ( pinDecl[device] )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=24 && LA8_0<=30)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:126:3: pinDecl[device]
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl365);
            	    pinDecl(device);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            match(input, Token.UP, null); 
            design.addDevice(device);

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:134:1: netDecl[PHDLDesign design] : ^( 'net' (msb= INT lsb= INT )? name= IDENT ( COLON ( netAttribute[n] )+ )? ) ;
    public final void netDecl(PHDLDesign design) throws RecognitionException {
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree name=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:139:2: ( ^( 'net' (msb= INT lsb= INT )? name= IDENT ( COLON ( netAttribute[n] )+ )? ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:139:4: ^( 'net' (msb= INT lsb= INT )? name= IDENT ( COLON ( netAttribute[n] )+ )? )
            {
            match(input,32,FOLLOW_32_in_netDecl400); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:139:12: (msb= INT lsb= INT )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==INT) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:139:13: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_netDecl405); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_netDecl409); 

                    }
                    break;

            }

            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netDecl415); 

            			PHDLNet n = new PHDLNet((name!=null?name.getText():null), 
            				msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):0, 
            				lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):0,
            				(name!=null?name.getLine():0), (name!=null?name.getCharPositionInLine():0));
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:150:3: ( COLON ( netAttribute[n] )+ )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==COLON) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:150:4: COLON ( netAttribute[n] )+
                    {
                    match(input,COLON,FOLLOW_COLON_in_netDecl433); 
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:150:10: ( netAttribute[n] )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==IDENT) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:150:10: netAttribute[n]
                    	    {
                    	    pushFollow(FOLLOW_netAttribute_in_netDecl435);
                    	    netAttribute(n);

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt10 >= 1 ) break loop10;
                                EarlyExitException eee =
                                    new EarlyExitException(10, input);
                                throw eee;
                        }
                        cnt10++;
                    } while (true);


                    }
                    break;

            }


            match(input, Token.UP, null); 
            design.addNet(n);

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


    // $ANTLR start "netAttribute"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:156:1: netAttribute[PHDLNet net] : IDENT ;
    public final void netAttribute(PHDLNet net) throws RecognitionException {
        CommonTree IDENT3=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:159:2: ( IDENT )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:159:4: IDENT
            {
            IDENT3=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netAttribute465); 
            net.addAttribute((IDENT3!=null?IDENT3.getText():null));

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
    // $ANTLR end "netAttribute"


    // $ANTLR start "attributeDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:162:1: attributeDecl[PHDLDevice d] : ^( EQUALS name= IDENT value= STRING_LITERAL ) ;
    public final void attributeDecl(PHDLDevice d) throws RecognitionException {
        CommonTree name=null;
        CommonTree value=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:166:2: ( ^( EQUALS name= IDENT value= STRING_LITERAL ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:166:4: ^( EQUALS name= IDENT value= STRING_LITERAL )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_attributeDecl487); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attributeDecl491); 
            value=(CommonTree)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_attributeDecl495); 

            match(input, Token.UP, null); 
            PHDLAttribute a = new PHDLAttribute((name!=null?name.getText():null), (value!=null?value.getText():null), (name!=null?name.getLine():0), (name!=null?name.getCharPositionInLine():0));
            d.addAttribute(a);

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
    // $ANTLR end "attributeDecl"


    // $ANTLR start "pinDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:171:1: pinDecl[PHDLDevice device] : ( ^( 'pin' addPin[device, pin] ) | ^( 'in' addPin[device, in] ) | ^( 'out' addPin[device, out] ) | ^( 'inout' addPin[device, inout] ) | ^( 'passive' addPin[device, passive] ) | ^( 'supply' addPin[device, supply] ) | ^( 'power' addPin[device, power] ) );
    public final void pinDecl(PHDLDevice device) throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:176:2: ( ^( 'pin' addPin[device, pin] ) | ^( 'in' addPin[device, in] ) | ^( 'out' addPin[device, out] ) | ^( 'inout' addPin[device, inout] ) | ^( 'passive' addPin[device, passive] ) | ^( 'supply' addPin[device, supply] ) | ^( 'power' addPin[device, power] ) )
            int alt12=7;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt12=1;
                }
                break;
            case 25:
                {
                alt12=2;
                }
                break;
            case 26:
                {
                alt12=3;
                }
                break;
            case 27:
                {
                alt12=4;
                }
                break;
            case 28:
                {
                alt12=5;
                }
                break;
            case 29:
                {
                alt12=6;
                }
                break;
            case 30:
                {
                alt12=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:176:4: ^( 'pin' addPin[device, pin] )
                    {
                    match(input,24,FOLLOW_24_in_pinDecl521); 

                    PHDLPin pin = new PHDLPin(PHDLPinType.PIN);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPin_in_pinDecl525);
                    addPin(device, pin);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:177:4: ^( 'in' addPin[device, in] )
                    {
                    match(input,25,FOLLOW_25_in_pinDecl533); 

                    PHDLPin in = new PHDLPin(PHDLPinType.IN);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPin_in_pinDecl537);
                    addPin(device, in);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:178:4: ^( 'out' addPin[device, out] )
                    {
                    match(input,26,FOLLOW_26_in_pinDecl545); 

                    PHDLPin out = new PHDLPin(PHDLPinType.OUT);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPin_in_pinDecl549);
                    addPin(device, out);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:179:4: ^( 'inout' addPin[device, inout] )
                    {
                    match(input,27,FOLLOW_27_in_pinDecl557); 

                    PHDLPin inout = new PHDLPin(PHDLPinType.INOUT);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPin_in_pinDecl561);
                    addPin(device, inout);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:180:4: ^( 'passive' addPin[device, passive] )
                    {
                    match(input,28,FOLLOW_28_in_pinDecl569); 

                    PHDLPin passive = new PHDLPin(PHDLPinType.PASSIVE);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPin_in_pinDecl573);
                    addPin(device, passive);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:181:4: ^( 'supply' addPin[device, supply] )
                    {
                    match(input,29,FOLLOW_29_in_pinDecl581); 

                    PHDLPin supply = new PHDLPin(PHDLPinType.SUPPLY);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPin_in_pinDecl585);
                    addPin(device, supply);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 7 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:182:4: ^( 'power' addPin[device, power] )
                    {
                    match(input,30,FOLLOW_30_in_pinDecl593); 

                    PHDLPin power = new PHDLPin(PHDLPinType.POWER);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPin_in_pinDecl597);
                    addPin(device, power);

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


    // $ANTLR start "addPin"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:185:1: addPin[PHDLDevice device, PHDLPin pin] : (msb= INT lsb= INT )? name= IDENT pinList= STRING_LITERAL ;
    public final void addPin(PHDLDevice device, PHDLPin pin) throws RecognitionException {
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree name=null;
        CommonTree pinList=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:189:2: ( (msb= INT lsb= INT )? name= IDENT pinList= STRING_LITERAL )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:189:4: (msb= INT lsb= INT )? name= IDENT pinList= STRING_LITERAL
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:189:4: (msb= INT lsb= INT )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==INT) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:189:5: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_addPin617); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_addPin621); 

                    }
                    break;

            }

            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_addPin627); 
            pinList=(CommonTree)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_addPin631); 
            	
            			pin.setMSB(msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1);
            			pin.setLSB(lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1);
            			pin.setLine((name!=null?name.getLine():0));
            			pin.setPos((name!=null?name.getCharPositionInLine():0));
            			pin.setName((name!=null?name.getText():null));
            			pin.setPinList((pinList!=null?pinList.getText():null));
            			pin.makePinMap();
            		
            device.addPin(pin);

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
    // $ANTLR end "addPin"


    // $ANTLR start "instance"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:202:1: instance[PHDLDesign d] : ^( 'inst' instName= IDENT devName= IDENT (msb= INT lsb= INT )? ( attributeAssignment[i] )* 'begin' ( pinAssignment[i] )* ) ;
    public final void instance(PHDLDesign d) throws RecognitionException {
        CommonTree instName=null;
        CommonTree devName=null;
        CommonTree msb=null;
        CommonTree lsb=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:206:2: ( ^( 'inst' instName= IDENT devName= IDENT (msb= INT lsb= INT )? ( attributeAssignment[i] )* 'begin' ( pinAssignment[i] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:206:4: ^( 'inst' instName= IDENT devName= IDENT (msb= INT lsb= INT )? ( attributeAssignment[i] )* 'begin' ( pinAssignment[i] )* )
            {
            match(input,35,FOLLOW_35_in_instance656); 

            match(input, Token.DOWN, null); 
            instName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instance660); 
            devName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instance664); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:206:42: (msb= INT lsb= INT )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==INT) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:206:43: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_instance669); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_instance673); 

                    }
                    break;

            }

            	
            			PHDLInstance i = new PHDLInstance((instName!=null?instName.getText():null), (devName!=null?devName.getText():null),
            				msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1,
            				lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1, 
            				(instName!=null?instName.getLine():0), (instName!=null?instName.getCharPositionInLine():0));
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:216:3: ( attributeAssignment[i] )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==EQUALS) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:216:3: attributeAssignment[i]
            	    {
            	    pushFollow(FOLLOW_attributeAssignment_in_instance694);
            	    attributeAssignment(i);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            match(input,20,FOLLOW_20_in_instance700); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:218:3: ( pinAssignment[i] )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==EQUALS) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:218:3: pinAssignment[i]
            	    {
            	    pushFollow(FOLLOW_pinAssignment_in_instance704);
            	    pinAssignment(i);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            match(input, Token.UP, null); 
            d.addInstance(i);

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


    // $ANTLR start "attributeAssignment"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:223:1: attributeAssignment[PHDLInstance i] : ^( EQUALS lValue= IDENT ( (lmsb= INT llsb= INT ) | (lindex= INT ) )? rValue= STRING_LITERAL ) ;
    public final void attributeAssignment(PHDLInstance i) throws RecognitionException {
        CommonTree lValue=null;
        CommonTree lmsb=null;
        CommonTree llsb=null;
        CommonTree lindex=null;
        CommonTree rValue=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:229:2: ( ^( EQUALS lValue= IDENT ( (lmsb= INT llsb= INT ) | (lindex= INT ) )? rValue= STRING_LITERAL ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:229:4: ^( EQUALS lValue= IDENT ( (lmsb= INT llsb= INT ) | (lindex= INT ) )? rValue= STRING_LITERAL )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_attributeAssignment729); 

            match(input, Token.DOWN, null); 
            lValue=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attributeAssignment733); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:229:26: ( (lmsb= INT llsb= INT ) | (lindex= INT ) )?
            int alt17=3;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==INT) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==INT) ) {
                    alt17=1;
                }
                else if ( (LA17_1==STRING_LITERAL) ) {
                    alt17=2;
                }
            }
            switch (alt17) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:229:27: (lmsb= INT llsb= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:229:27: (lmsb= INT llsb= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:229:28: lmsb= INT llsb= INT
                    {
                    lmsb=(CommonTree)match(input,INT,FOLLOW_INT_in_attributeAssignment739); 
                    llsb=(CommonTree)match(input,INT,FOLLOW_INT_in_attributeAssignment743); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:229:49: (lindex= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:229:49: (lindex= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:229:50: lindex= INT
                    {
                    lindex=(CommonTree)match(input,INT,FOLLOW_INT_in_attributeAssignment751); 

                    }


                    }
                    break;

            }

            rValue=(CommonTree)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_attributeAssignment760); 

            match(input, Token.UP, null); 

            			PHDLAssignment a = new PHDLAssignment(
            				(lValue!=null?lValue.getText():null), (rValue!=null?rValue.getText():null), 
            				lmsb!=null?Integer.parseInt((lmsb!=null?lmsb.getText():null)):-1,
            				llsb!=null?Integer.parseInt((llsb!=null?llsb.getText():null)):-1,
            				lindex!=null?Integer.parseInt((lindex!=null?lindex.getText():null)):-1,
            				-1,-1,-1,(lValue!=null?lValue.getLine():0), (lValue!=null?lValue.getCharPositionInLine():0));
            			
            			i.addAttributeAssignment(a);
            		

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
    // $ANTLR end "attributeAssignment"


    // $ANTLR start "pinAssignment"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:246:1: pinAssignment[PHDLInstance i] : ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ( concatenate[a] )+ ) ;
    public final void pinAssignment(PHDLInstance i) throws RecognitionException {
        CommonTree name=null;
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree index=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:249:2: ( ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ( concatenate[a] )+ ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:249:4: ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ( concatenate[a] )+ )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_pinAssignment789); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinAssignment793); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:249:24: ( (msb= INT lsb= INT ) | (index= INT ) )?
            int alt18=3;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==INT) ) {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==INT) ) {
                    alt18=1;
                }
                else if ( (LA18_1==IDENT) ) {
                    alt18=2;
                }
            }
            switch (alt18) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:249:25: (msb= INT lsb= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:249:25: (msb= INT lsb= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:249:26: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_pinAssignment799); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_pinAssignment803); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:249:45: (index= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:249:45: (index= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:249:46: index= INT
                    {
                    index=(CommonTree)match(input,INT,FOLLOW_INT_in_pinAssignment811); 

                    }


                    }
                    break;

            }


            			PHDLAssignment a = new PHDLAssignment(
            				(name!=null?name.getText():null), 
            				msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1,
            				lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1,
            				index!=null?Integer.parseInt((index!=null?index.getText():null)):-1,
            				(name!=null?name.getLine():0), (name!=null?name.getCharPositionInLine():0));
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:261:3: ( concatenate[a] )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==IDENT) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:261:3: concatenate[a]
            	    {
            	    pushFollow(FOLLOW_concatenate_in_pinAssignment829);
            	    concatenate(a);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);


            match(input, Token.UP, null); 
            i.addPinAssignment(a);

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
    // $ANTLR end "pinAssignment"


    // $ANTLR start "subDesign"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:266:1: subDesign[PHDLDesign d] : ^( 'sub' instName= IDENT desName= IDENT (msb= INT lsb= INT )? ( portAssignment[s] )* ) ;
    public final void subDesign(PHDLDesign d) throws RecognitionException {
        CommonTree instName=null;
        CommonTree desName=null;
        CommonTree msb=null;
        CommonTree lsb=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:267:2: ( ^( 'sub' instName= IDENT desName= IDENT (msb= INT lsb= INT )? ( portAssignment[s] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:267:4: ^( 'sub' instName= IDENT desName= IDENT (msb= INT lsb= INT )? ( portAssignment[s] )* )
            {
            match(input,36,FOLLOW_36_in_subDesign853); 

            match(input, Token.DOWN, null); 
            instName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_subDesign857); 
            desName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_subDesign861); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:267:41: (msb= INT lsb= INT )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==INT) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:267:42: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_subDesign866); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_subDesign870); 

                    }
                    break;

            }

            	
            			PHDLSubDesign s = new PHDLSubDesign((instName!=null?instName.getText():null), (desName!=null?desName.getText():null),
            				msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1,
            				lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1, 
            				(instName!=null?instName.getLine():0), (instName!=null?instName.getCharPositionInLine():0));
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:277:3: ( portAssignment[s] )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==EQUALS) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:277:3: portAssignment[s]
            	    {
            	    pushFollow(FOLLOW_portAssignment_in_subDesign887);
            	    portAssignment(s);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            match(input, Token.UP, null); 
            d.addSubDesign(s);

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


    // $ANTLR start "netAssignment"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:282:1: netAssignment[PHDLDesign d] : ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ( concatenate[a] )+ ) ;
    public final void netAssignment(PHDLDesign d) throws RecognitionException {
        CommonTree name=null;
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree index=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:285:2: ( ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ( concatenate[a] )+ ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:285:4: ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ( concatenate[a] )+ )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_netAssignment913); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netAssignment917); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:285:24: ( (msb= INT lsb= INT ) | (index= INT ) )?
            int alt22=3;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==INT) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==INT) ) {
                    alt22=1;
                }
                else if ( (LA22_1==IDENT) ) {
                    alt22=2;
                }
            }
            switch (alt22) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:285:25: (msb= INT lsb= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:285:25: (msb= INT lsb= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:285:26: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_netAssignment923); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_netAssignment927); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:285:45: (index= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:285:45: (index= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:285:46: index= INT
                    {
                    index=(CommonTree)match(input,INT,FOLLOW_INT_in_netAssignment935); 

                    }


                    }
                    break;

            }


            			PHDLAssignment a = new PHDLAssignment(
            				(name!=null?name.getText():null), 
            				msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1,
            				lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1,
            				index!=null?Integer.parseInt((index!=null?index.getText():null)):-1,
            				(name!=null?name.getLine():0), (name!=null?name.getCharPositionInLine():0));
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:296:3: ( concatenate[a] )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==IDENT) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:296:3: concatenate[a]
            	    {
            	    pushFollow(FOLLOW_concatenate_in_netAssignment952);
            	    concatenate(a);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt23 >= 1 ) break loop23;
                        EarlyExitException eee =
                            new EarlyExitException(23, input);
                        throw eee;
                }
                cnt23++;
            } while (true);


            match(input, Token.UP, null); 
            d.addNetAssignment(a);

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
    // $ANTLR end "netAssignment"


    // $ANTLR start "portAssignment"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:301:1: portAssignment[PHDLSubDesign s] : ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ( concatenate[a] )+ ) ;
    public final void portAssignment(PHDLSubDesign s) throws RecognitionException {
        CommonTree name=null;
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree index=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:302:2: ( ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ( concatenate[a] )+ ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:302:4: ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ( concatenate[a] )+ )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_portAssignment976); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_portAssignment980); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:302:24: ( (msb= INT lsb= INT ) | (index= INT ) )?
            int alt24=3;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==INT) ) {
                int LA24_1 = input.LA(2);

                if ( (LA24_1==INT) ) {
                    alt24=1;
                }
                else if ( (LA24_1==IDENT) ) {
                    alt24=2;
                }
            }
            switch (alt24) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:302:25: (msb= INT lsb= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:302:25: (msb= INT lsb= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:302:26: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_portAssignment986); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_portAssignment990); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:302:45: (index= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:302:45: (index= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:302:46: index= INT
                    {
                    index=(CommonTree)match(input,INT,FOLLOW_INT_in_portAssignment998); 

                    }


                    }
                    break;

            }


            			PHDLAssignment a = new PHDLAssignment(
            				(name!=null?name.getText():null), 
            				msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1,
            				lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1,
            				index!=null?Integer.parseInt((index!=null?index.getText():null)):-1,
            				(name!=null?name.getLine():0), (name!=null?name.getCharPositionInLine():0));
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:314:3: ( concatenate[a] )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==IDENT) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:314:3: concatenate[a]
            	    {
            	    pushFollow(FOLLOW_concatenate_in_portAssignment1016);
            	    concatenate(a);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
            } while (true);


            match(input, Token.UP, null); 
            s.addPortAssignment(a);

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


    // $ANTLR start "concatenate"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:319:1: concatenate[PHDLAssignment a] : (name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ) ;
    public final void concatenate(PHDLAssignment a) throws RecognitionException {
        CommonTree name=null;
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree index=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:320:2: ( (name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:320:4: (name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? )
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:320:4: (name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:320:5: name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )?
            {
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenate1041); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:320:16: ( (msb= INT lsb= INT ) | (index= INT ) )?
            int alt26=3;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==INT) ) {
                int LA26_1 = input.LA(2);

                if ( (LA26_1==INT) ) {
                    alt26=1;
                }
                else if ( ((LA26_1>=UP && LA26_1<=IDENT)) ) {
                    alt26=2;
                }
            }
            switch (alt26) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:320:17: (msb= INT lsb= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:320:17: (msb= INT lsb= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:320:18: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_concatenate1047); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_concatenate1051); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:320:37: (index= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:320:37: (index= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\PHDLWalker.g:320:38: index= INT
                    {
                    index=(CommonTree)match(input,INT,FOLLOW_INT_in_concatenate1059); 

                    }


                    }
                    break;

            }


            }


            			PHDLNet n = new PHDLNet((name!=null?name.getText():null), 
            				msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1,
            				lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1,
            				index!=null?Integer.parseInt((index!=null?index.getText():null)):-1,
            				(name!=null?name.getLine():0), (name!=null?name.getCharPositionInLine():0));
            			a.addRightValue(n);
            		

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
    // $ANTLR end "concatenate"

    // Delegated rules


 

    public static final BitSet FOLLOW_design_in_sourceText65 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_design88 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_design90 = new BitSet(new long[]{0x000000017F900000L});
    public static final BitSet FOLLOW_portDecl_in_design109 = new BitSet(new long[]{0x000000017F900000L});
    public static final BitSet FOLLOW_deviceDecl_in_design123 = new BitSet(new long[]{0x0000000100900000L});
    public static final BitSet FOLLOW_netDecl_in_design128 = new BitSet(new long[]{0x0000000100900000L});
    public static final BitSet FOLLOW_20_in_design141 = new BitSet(new long[]{0x0000001800000048L});
    public static final BitSet FOLLOW_instance_in_design152 = new BitSet(new long[]{0x0000001800000048L});
    public static final BitSet FOLLOW_subDesign_in_design157 = new BitSet(new long[]{0x0000001800000048L});
    public static final BitSet FOLLOW_netAssignment_in_design162 = new BitSet(new long[]{0x0000001800000048L});
    public static final BitSet FOLLOW_24_in_portDecl190 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPort_in_portDecl194 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_25_in_portDecl202 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPort_in_portDecl206 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_26_in_portDecl214 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPort_in_portDecl218 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_27_in_portDecl226 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPort_in_portDecl230 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_28_in_portDecl238 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPort_in_portDecl242 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_29_in_portDecl250 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPort_in_portDecl254 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_30_in_portDecl262 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPort_in_portDecl266 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INT_in_addPort284 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_addPort288 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_addPort294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_deviceDecl318 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl320 = new BitSet(new long[]{0x0000000000100040L});
    public static final BitSet FOLLOW_attributeDecl_in_deviceDecl343 = new BitSet(new long[]{0x0000000000100040L});
    public static final BitSet FOLLOW_20_in_deviceDecl355 = new BitSet(new long[]{0x000000007F000008L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl365 = new BitSet(new long[]{0x000000007F000008L});
    public static final BitSet FOLLOW_32_in_netDecl400 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_netDecl405 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_netDecl409 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl415 = new BitSet(new long[]{0x0000000000000208L});
    public static final BitSet FOLLOW_COLON_in_netDecl433 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_netAttribute_in_netDecl435 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_IDENT_in_netAttribute465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUALS_in_attributeDecl487 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_attributeDecl491 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_attributeDecl495 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_24_in_pinDecl521 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPin_in_pinDecl525 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_25_in_pinDecl533 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPin_in_pinDecl537 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_26_in_pinDecl545 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPin_in_pinDecl549 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_27_in_pinDecl557 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPin_in_pinDecl561 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_28_in_pinDecl569 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPin_in_pinDecl573 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_29_in_pinDecl581 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPin_in_pinDecl585 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_30_in_pinDecl593 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPin_in_pinDecl597 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INT_in_addPin617 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_addPin621 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_addPin627 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_addPin631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_instance656 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_instance660 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instance664 = new BitSet(new long[]{0x0000000000100440L});
    public static final BitSet FOLLOW_INT_in_instance669 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_instance673 = new BitSet(new long[]{0x0000000000100040L});
    public static final BitSet FOLLOW_attributeAssignment_in_instance694 = new BitSet(new long[]{0x0000000000100040L});
    public static final BitSet FOLLOW_20_in_instance700 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_pinAssignment_in_instance704 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_EQUALS_in_attributeAssignment729 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_attributeAssignment733 = new BitSet(new long[]{0x0000000000000480L});
    public static final BitSet FOLLOW_INT_in_attributeAssignment739 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_attributeAssignment743 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_INT_in_attributeAssignment751 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_attributeAssignment760 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssignment789 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_pinAssignment793 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_INT_in_pinAssignment799 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_pinAssignment803 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_INT_in_pinAssignment811 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_concatenate_in_pinAssignment829 = new BitSet(new long[]{0x0000000000000418L});
    public static final BitSet FOLLOW_36_in_subDesign853 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_subDesign857 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_subDesign861 = new BitSet(new long[]{0x0000000000000448L});
    public static final BitSet FOLLOW_INT_in_subDesign866 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_subDesign870 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_portAssignment_in_subDesign887 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_EQUALS_in_netAssignment913 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_netAssignment917 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_INT_in_netAssignment923 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_netAssignment927 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_INT_in_netAssignment935 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_concatenate_in_netAssignment952 = new BitSet(new long[]{0x0000000000000418L});
    public static final BitSet FOLLOW_EQUALS_in_portAssignment976 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_portAssignment980 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_INT_in_portAssignment986 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_portAssignment990 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_INT_in_portAssignment998 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_concatenate_in_portAssignment1016 = new BitSet(new long[]{0x0000000000000418L});
    public static final BitSet FOLLOW_IDENT_in_concatenate1041 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_INT_in_concatenate1047 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_concatenate1051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_concatenate1059 = new BitSet(new long[]{0x0000000000000002L});

}