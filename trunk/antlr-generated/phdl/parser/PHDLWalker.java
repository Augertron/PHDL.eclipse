// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g 2011-06-16 11:59:19

	package phdl.parser;
	import java.util.LinkedList;


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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "SEMICOLON", "EQUALS", "STRING_LITERAL", "COMMA", "COLON", "INT", "CHAR", "DIGIT", "LBRACKET", "RBRACKET", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "'design'", "'is'", "'begin'", "'end'", "'port'", "'device'", "'pin'", "'in'", "'out'", "'inout'", "'passive'", "'supply'", "'power'", "'open'", "'net'", "'('", "')'", "'inst'", "'sub'", "'&'"
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
    public static final int SEMICOLON=5;
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
    public String getGrammarFileName() { return "C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g"; }



    	private LinkedList<String> errors = new LinkedList<String>();
    	
    	@Override
        public void displayRecognitionError(String[] tokenNames,
                                            RecognitionException e) {
            String hdr = getErrorHeader(e);
            String msg = getErrorMessage(e, tokenNames);
            errors.add(input.getSourceName() + hdr + " " + msg);
        }
        
        public List<String> getErrors() {
            return errors;
        }
        
        public void addError(String s) {
        	errors.add(s);
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:69:1: sourceText returns [ParsedDesigns pd] : ( design[pd] )* ;
    public final ParsedDesigns sourceText() throws RecognitionException {
        ParsedDesigns pd = null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:73:2: ( ( design[pd] )* )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:73:4: ( design[pd] )*
            {
            pd = new ParsedDesigns();
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:74:3: ( design[pd] )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==18) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:74:3: design[pd]
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return pd;
    }
    // $ANTLR end "sourceText"


    // $ANTLR start "design"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:77:1: design[ParsedDesigns pd] : ^( 'design' IDENT ( portDecl[d] )* ( deviceDecl[d] | netDecl[d] )* 'begin' ( instance[d] | subDesign[d] | netAssignment[d] )* ) ;
    public final void design(ParsedDesigns pd) throws RecognitionException {
        CommonTree IDENT1=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:84:2: ( ^( 'design' IDENT ( portDecl[d] )* ( deviceDecl[d] | netDecl[d] )* 'begin' ( instance[d] | subDesign[d] | netAssignment[d] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:84:4: ^( 'design' IDENT ( portDecl[d] )* ( deviceDecl[d] | netDecl[d] )* 'begin' ( instance[d] | subDesign[d] | netAssignment[d] )* )
            {
            match(input,18,FOLLOW_18_in_design87); 

            match(input, Token.DOWN, null); 
            IDENT1=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_design89); 
            	DesignDeclaration d = new DesignDeclaration();
            			d.setName((IDENT1!=null?IDENT1.getText():null));
            			d.setLine((IDENT1!=null?IDENT1.getLine():0));
            			d.setPos((IDENT1!=null?IDENT1.getCharPositionInLine():0));
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:94:3: ( portDecl[d] )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=24 && LA2_0<=30)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:94:3: portDecl[d]
            	    {
            	    pushFollow(FOLLOW_portDecl_in_design109);
            	    portDecl(d);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:97:3: ( deviceDecl[d] | netDecl[d] )*
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:97:4: deviceDecl[d]
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_design123);
            	    deviceDecl(d);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:97:20: netDecl[d]
            	    {
            	    pushFollow(FOLLOW_netDecl_in_design128);
            	    netDecl(d);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match(input,20,FOLLOW_20_in_design141); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:103:3: ( instance[d] | subDesign[d] | netAssignment[d] )*
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:103:4: instance[d]
            	    {
            	    pushFollow(FOLLOW_instance_in_design152);
            	    instance(d);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:103:18: subDesign[d]
            	    {
            	    pushFollow(FOLLOW_subDesign_in_design157);
            	    subDesign(d);

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:103:33: netAssignment[d]
            	    {
            	    pushFollow(FOLLOW_netAssignment_in_design162);
            	    netAssignment(d);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            match(input, Token.UP, null); 

            			boolean added = pd.addDesignDecl(d);
            			if(!added) addError(input.getSourceName() + " line " + d.getLineString()
            				+ " in walker: duplicate design declaration found: " + d.getName());
            		

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:113:1: portDecl[DesignDeclaration d] : ( ^( 'pin' addPort[d, pin] ) | ^( 'in' addPort[d, in] ) | ^( 'out' addPort[d, out] ) | ^( 'inout' addPort[d, inout] ) | ^( 'passive' addPort[d, passive] ) | ^( 'supply' addPort[d, supply] ) | ^( 'power' addPort[d, power] ) );
    public final void portDecl(DesignDeclaration d) throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:119:2: ( ^( 'pin' addPort[d, pin] ) | ^( 'in' addPort[d, in] ) | ^( 'out' addPort[d, out] ) | ^( 'inout' addPort[d, inout] ) | ^( 'passive' addPort[d, passive] ) | ^( 'supply' addPort[d, supply] ) | ^( 'power' addPort[d, power] ) )
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:119:4: ^( 'pin' addPort[d, pin] )
                    {
                    match(input,24,FOLLOW_24_in_portDecl191); 

                    PortDeclaration pin = new PortDeclaration(Type.PIN);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPort_in_portDecl195);
                    addPort(d, pin);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:120:4: ^( 'in' addPort[d, in] )
                    {
                    match(input,25,FOLLOW_25_in_portDecl203); 

                    PortDeclaration in = new PortDeclaration(Type.IN);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPort_in_portDecl207);
                    addPort(d, in);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:121:4: ^( 'out' addPort[d, out] )
                    {
                    match(input,26,FOLLOW_26_in_portDecl215); 

                    PortDeclaration out = new PortDeclaration(Type.OUT);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPort_in_portDecl219);
                    addPort(d, out);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:122:4: ^( 'inout' addPort[d, inout] )
                    {
                    match(input,27,FOLLOW_27_in_portDecl227); 

                    PortDeclaration inout = new PortDeclaration(Type.INOUT);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPort_in_portDecl231);
                    addPort(d, inout);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:123:4: ^( 'passive' addPort[d, passive] )
                    {
                    match(input,28,FOLLOW_28_in_portDecl239); 

                    PortDeclaration passive = new PortDeclaration(Type.PASSIVE);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPort_in_portDecl243);
                    addPort(d, passive);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:124:4: ^( 'supply' addPort[d, supply] )
                    {
                    match(input,29,FOLLOW_29_in_portDecl251); 

                    PortDeclaration supply = new PortDeclaration(Type.SUPPLY);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPort_in_portDecl255);
                    addPort(d, supply);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 7 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:125:4: ^( 'power' addPort[d, power] )
                    {
                    match(input,30,FOLLOW_30_in_portDecl263); 

                    PortDeclaration power = new PortDeclaration(Type.POWER);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPort_in_portDecl267);
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:128:1: addPort[DesignDeclaration d, PortDeclaration p] : (msb= INT lsb= INT )? name= IDENT ;
    public final void addPort(DesignDeclaration d, PortDeclaration p) throws RecognitionException {
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree name=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:133:2: ( (msb= INT lsb= INT )? name= IDENT )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:133:4: (msb= INT lsb= INT )? name= IDENT
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:133:4: (msb= INT lsb= INT )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==INT) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:133:5: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_addPort287); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_addPort291); 

                    }
                    break;

            }

            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_addPort297); 
            	
            			p.setName((name!=null?name.getText():null));
            			p.setLine((name!=null?name.getLine():0));
            			p.setPos((name!=null?name.getCharPositionInLine():0));
            			p.setMsb(msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1);
            			p.setLsb(lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1);
            		

            			boolean added = d.addPortDecl(p);
            			if(!added) addError(input.getSourceName() + " line " + p.getLineString()
            				+ " duplicate port declaration found: " + p.getName());
            		

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:148:1: deviceDecl[DesignDeclaration d] : ^( 'device' name= IDENT ( attributeDecl[dev] )* 'begin' ( pinDecl[dev] )* ) ;
    public final void deviceDecl(DesignDeclaration d) throws RecognitionException {
        CommonTree name=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:155:2: ( ^( 'device' name= IDENT ( attributeDecl[dev] )* 'begin' ( pinDecl[dev] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:155:4: ^( 'device' name= IDENT ( attributeDecl[dev] )* 'begin' ( pinDecl[dev] )* )
            {
            match(input,23,FOLLOW_23_in_deviceDecl321); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl325); 

            				DeviceDeclaration dev = new DeviceDeclaration();
            				dev.setName((name!=null?name.getText():null));
            				dev.setLine((name!=null?name.getLine():0));
            				dev.setPos((name!=null?name.getCharPositionInLine():0));
            			
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:166:3: ( attributeDecl[dev] )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==EQUALS) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:166:3: attributeDecl[dev]
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_deviceDecl348);
            	    attributeDecl(dev);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match(input,20,FOLLOW_20_in_deviceDecl360); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:172:3: ( pinDecl[dev] )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=24 && LA8_0<=30)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:172:3: pinDecl[dev]
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl370);
            	    pinDecl(dev);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            match(input, Token.UP, null); 
            	boolean added = d.addDeviceDecl(dev);
            			if(!added) addError(input.getSourceName() + " line " + dev.getLineString()
            				+ " duplicate device declaration found: " + dev.getName());
            		

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:183:1: netDecl[DesignDeclaration d] : ^( 'net' (msb= INT lsb= INT )? name= IDENT ( COLON ( netAttribute[n] )+ )? ) ;
    public final void netDecl(DesignDeclaration d) throws RecognitionException {
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree name=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:188:2: ( ^( 'net' (msb= INT lsb= INT )? name= IDENT ( COLON ( netAttribute[n] )+ )? ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:188:4: ^( 'net' (msb= INT lsb= INT )? name= IDENT ( COLON ( netAttribute[n] )+ )? )
            {
            match(input,32,FOLLOW_32_in_netDecl405); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:188:12: (msb= INT lsb= INT )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==INT) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:188:13: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_netDecl410); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_netDecl414); 

                    }
                    break;

            }

            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netDecl420); 
            	NetDeclaration n = new NetDeclaration(); 
            			n.setName((name!=null?name.getText():null));
            			n.setLine((name!=null?name.getLine():0));
            			n.setPos((name!=null?name.getCharPositionInLine():0));
            			n.setMsb(msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1);
            			n.setLsb(lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1);
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:200:3: ( COLON ( netAttribute[n] )+ )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==COLON) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:200:4: COLON ( netAttribute[n] )+
                    {
                    match(input,COLON,FOLLOW_COLON_in_netDecl438); 
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:200:10: ( netAttribute[n] )+
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
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:200:10: netAttribute[n]
                    	    {
                    	    pushFollow(FOLLOW_netAttribute_in_netDecl440);
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
            	boolean added = d.addNetDecl(n);
            			if(!added) addError(input.getSourceName() + " line " + n.getLineString()
            				+ " duplicate net declaration found: " + n.getName());
            		

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:210:1: netAttribute[NetDeclaration n] : IDENT ;
    public final void netAttribute(NetDeclaration n) throws RecognitionException {
        CommonTree IDENT2=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:213:2: ( IDENT )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:213:4: IDENT
            {
            IDENT2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netAttribute473); 
            	boolean added = n.addAttribute((IDENT2!=null?IDENT2.getText():null));
            			if(!added) addError(input.getSourceName() + " line " + (IDENT2!=null?IDENT2.getLine():0) + ":" + (IDENT2!=null?IDENT2.getCharPositionInLine():0) 
            				+ " duplicate net attribute found: " + (IDENT2!=null?IDENT2.getText():null));
            		

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:220:1: attributeDecl[DeviceDeclaration d] : ^( EQUALS name= IDENT value= STRING_LITERAL ) ;
    public final void attributeDecl(DeviceDeclaration d) throws RecognitionException {
        CommonTree name=null;
        CommonTree value=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:224:2: ( ^( EQUALS name= IDENT value= STRING_LITERAL ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:224:4: ^( EQUALS name= IDENT value= STRING_LITERAL )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_attributeDecl498); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attributeDecl502); 
            value=(CommonTree)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_attributeDecl506); 

            match(input, Token.UP, null); 
            	AttributeDeclaration a = new AttributeDeclaration();
            			a.setName((name!=null?name.getText():null));
            			a.setLine((name!=null?name.getLine():0));
            			a.setPos((name!=null?name.getCharPositionInLine():0));
            			a.setValue((value!=null?value.getText():null));
            			boolean added = d.addAttributeDecl(a);
            			if(!added) addError(input.getSourceName() + " line " + a.getLineString()
            				+ " duplicate attribute declaration found: " + a.getName());
            		

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:236:1: pinDecl[DeviceDeclaration d] : ( ^( 'pin' addPin[d, pin] ) | ^( 'in' addPin[d, in] ) | ^( 'out' addPin[d, out] ) | ^( 'inout' addPin[d, inout] ) | ^( 'passive' addPin[d, passive] ) | ^( 'supply' addPin[d, supply] ) | ^( 'power' addPin[d, power] ) );
    public final void pinDecl(DeviceDeclaration d) throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:241:2: ( ^( 'pin' addPin[d, pin] ) | ^( 'in' addPin[d, in] ) | ^( 'out' addPin[d, out] ) | ^( 'inout' addPin[d, inout] ) | ^( 'passive' addPin[d, passive] ) | ^( 'supply' addPin[d, supply] ) | ^( 'power' addPin[d, power] ) )
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:241:4: ^( 'pin' addPin[d, pin] )
                    {
                    match(input,24,FOLLOW_24_in_pinDecl528); 

                    PinDeclaration pin = new PinDeclaration(Type.PIN);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPin_in_pinDecl532);
                    addPin(d, pin);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:242:4: ^( 'in' addPin[d, in] )
                    {
                    match(input,25,FOLLOW_25_in_pinDecl540); 

                    PinDeclaration in = new PinDeclaration(Type.IN);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPin_in_pinDecl544);
                    addPin(d, in);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:243:4: ^( 'out' addPin[d, out] )
                    {
                    match(input,26,FOLLOW_26_in_pinDecl552); 

                    PinDeclaration out = new PinDeclaration(Type.OUT);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPin_in_pinDecl556);
                    addPin(d, out);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:244:4: ^( 'inout' addPin[d, inout] )
                    {
                    match(input,27,FOLLOW_27_in_pinDecl564); 

                    PinDeclaration inout = new PinDeclaration(Type.INOUT);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPin_in_pinDecl568);
                    addPin(d, inout);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:245:4: ^( 'passive' addPin[d, passive] )
                    {
                    match(input,28,FOLLOW_28_in_pinDecl576); 

                    PinDeclaration passive = new PinDeclaration(Type.PASSIVE);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPin_in_pinDecl580);
                    addPin(d, passive);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:246:4: ^( 'supply' addPin[d, supply] )
                    {
                    match(input,29,FOLLOW_29_in_pinDecl588); 

                    PinDeclaration supply = new PinDeclaration(Type.SUPPLY);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPin_in_pinDecl592);
                    addPin(d, supply);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 7 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:247:4: ^( 'power' addPin[d, power] )
                    {
                    match(input,30,FOLLOW_30_in_pinDecl600); 

                    PinDeclaration power = new PinDeclaration(Type.POWER);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPin_in_pinDecl604);
                    addPin(d, power);

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:250:1: addPin[DeviceDeclaration d, PinDeclaration p] : (msb= INT lsb= INT )? name= IDENT pinList= STRING_LITERAL ;
    public final void addPin(DeviceDeclaration d, PinDeclaration p) throws RecognitionException {
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree name=null;
        CommonTree pinList=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:254:2: ( (msb= INT lsb= INT )? name= IDENT pinList= STRING_LITERAL )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:254:4: (msb= INT lsb= INT )? name= IDENT pinList= STRING_LITERAL
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:254:4: (msb= INT lsb= INT )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==INT) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:254:5: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_addPin624); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_addPin628); 

                    }
                    break;

            }

            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_addPin634); 
            pinList=(CommonTree)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_addPin638); 
            	
            			p.setName((name!=null?name.getText():null));
            			p.setLine((name!=null?name.getLine():0));
            			p.setPos((name!=null?name.getCharPositionInLine():0));
            			p.setMsb(msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1);
            			p.setLsb(lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1);
            			p.setPinList((pinList!=null?pinList.getText():null));
            		
            	boolean added = d.addPinDecl(p);
            			if(!added) addError(input.getSourceName() + " line " + p.getLineString()
            				+ " duplicate pin declaration found: " + p.getName());
            		

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:269:1: instance[DesignDeclaration d] : ^( 'inst' name= IDENT refName= IDENT (msb= INT lsb= INT )? ( attributeAssignment[i] )* 'begin' ( pinAssignment[i] )* ) ;
    public final void instance(DesignDeclaration d) throws RecognitionException {
        CommonTree name=null;
        CommonTree refName=null;
        CommonTree msb=null;
        CommonTree lsb=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:273:2: ( ^( 'inst' name= IDENT refName= IDENT (msb= INT lsb= INT )? ( attributeAssignment[i] )* 'begin' ( pinAssignment[i] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:273:4: ^( 'inst' name= IDENT refName= IDENT (msb= INT lsb= INT )? ( attributeAssignment[i] )* 'begin' ( pinAssignment[i] )* )
            {
            match(input,35,FOLLOW_35_in_instance663); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instance667); 
            refName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instance671); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:273:38: (msb= INT lsb= INT )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==INT) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:273:39: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_instance676); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_instance680); 

                    }
                    break;

            }

            	
            			InstanceDeclaration i = new InstanceDeclaration();
            				i.setName((name!=null?name.getText():null));
            				i.setLine((name!=null?name.getLine():0));
            				i.setPos((name!=null?name.getCharPositionInLine():0));
            				i.setMsb(msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1);
            				i.setLsb(lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1);
            				i.setRefName((refName!=null?refName.getText():null));
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:286:3: ( attributeAssignment[i] )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==EQUALS) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:286:3: attributeAssignment[i]
            	    {
            	    pushFollow(FOLLOW_attributeAssignment_in_instance701);
            	    attributeAssignment(i);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            match(input,20,FOLLOW_20_in_instance707); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:288:3: ( pinAssignment[i] )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==EQUALS) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:288:3: pinAssignment[i]
            	    {
            	    pushFollow(FOLLOW_pinAssignment_in_instance711);
            	    pinAssignment(i);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            match(input, Token.UP, null); 
            	boolean added = d.addInstanceDecl(i);
            			if(!added) addError(input.getSourceName() + " line " + i.getLineString()
            				+ " duplicate instance declaration found: " + i.getName());
            		

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:296:1: attributeAssignment[InstanceDeclaration i] : ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? value= STRING_LITERAL ) ;
    public final void attributeAssignment(InstanceDeclaration i) throws RecognitionException {
        CommonTree name=null;
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree index=null;
        CommonTree value=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:302:2: ( ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? value= STRING_LITERAL ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:302:4: ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? value= STRING_LITERAL )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_attributeAssignment736); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attributeAssignment740); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:302:24: ( (msb= INT lsb= INT ) | (index= INT ) )?
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:302:25: (msb= INT lsb= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:302:25: (msb= INT lsb= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:302:26: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_attributeAssignment746); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_attributeAssignment750); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:302:45: (index= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:302:45: (index= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:302:46: index= INT
                    {
                    index=(CommonTree)match(input,INT,FOLLOW_INT_in_attributeAssignment758); 

                    }


                    }
                    break;

            }

            value=(CommonTree)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_attributeAssignment765); 

            match(input, Token.UP, null); 
            	AttributeAssignment a = new AttributeAssignment();
            			a.setName((name!=null?name.getText():null));
            			a.setLine((name!=null?name.getLine():0));
            			a.setPos((name!=null?name.getCharPositionInLine():0));
            			a.setMsb(msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1);
            			a.setLsb(lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1);
            			a.setIndex(index!=null?Integer.parseInt((index!=null?index.getText():null)):-1);
            			a.setValue((value!=null?value.getText():null));
            			boolean added = i.addAttributeAssignment(a);
            			if(!added) addError(input.getSourceName() + " line " + a.getLineString()
            				+ " duplicate attribute assignment found: " + a.getName());
            		

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:320:1: pinAssignment[InstanceDeclaration i] : ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ( concatenatePin[p] )* ) ;
    public final void pinAssignment(InstanceDeclaration i) throws RecognitionException {
        CommonTree name=null;
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree index=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:323:2: ( ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ( concatenatePin[p] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:323:4: ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ( concatenatePin[p] )* )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_pinAssignment794); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinAssignment798); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:323:24: ( (msb= INT lsb= INT ) | (index= INT ) )?
            int alt18=3;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==INT) ) {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==INT) ) {
                    alt18=1;
                }
                else if ( ((LA18_1>=UP && LA18_1<=IDENT)) ) {
                    alt18=2;
                }
            }
            switch (alt18) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:323:25: (msb= INT lsb= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:323:25: (msb= INT lsb= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:323:26: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_pinAssignment804); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_pinAssignment808); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:323:45: (index= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:323:45: (index= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:323:46: index= INT
                    {
                    index=(CommonTree)match(input,INT,FOLLOW_INT_in_pinAssignment816); 

                    }


                    }
                    break;

            }


            			PinAssignment p = new PinAssignment();
            			p.setName((name!=null?name.getText():null));
            			p.setLine((name!=null?name.getLine():0));
            			p.setPos((name!=null?name.getCharPositionInLine():0));
            			p.setMsb(msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1);
            			p.setLsb(lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1);
            			p.setIndex(index!=null?Integer.parseInt((index!=null?index.getText():null)):-1);
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:336:3: ( concatenatePin[p] )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==IDENT) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:336:3: concatenatePin[p]
            	    {
            	    pushFollow(FOLLOW_concatenatePin_in_pinAssignment834);
            	    concatenatePin(p);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            match(input, Token.UP, null); 
            	boolean added = i.addPinAssignment(p);
            			if(!added) addError(input.getSourceName() + " line " + p.getLineString()
            				+ " duplicate pin assignment found: " + p.getName());
            		

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


    // $ANTLR start "concatenatePin"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:344:1: concatenatePin[PinAssignment p] : (name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ) ;
    public final void concatenatePin(PinAssignment p) throws RecognitionException {
        CommonTree name=null;
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree index=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:345:2: ( (name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:345:4: (name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? )
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:345:4: (name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:345:5: name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )?
            {
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenatePin860); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:345:16: ( (msb= INT lsb= INT ) | (index= INT ) )?
            int alt20=3;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==INT) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==INT) ) {
                    alt20=1;
                }
                else if ( ((LA20_1>=UP && LA20_1<=IDENT)) ) {
                    alt20=2;
                }
            }
            switch (alt20) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:345:17: (msb= INT lsb= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:345:17: (msb= INT lsb= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:345:18: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_concatenatePin866); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_concatenatePin870); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:345:37: (index= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:345:37: (index= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:345:38: index= INT
                    {
                    index=(CommonTree)match(input,INT,FOLLOW_INT_in_concatenatePin878); 

                    }


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
            			p.addNet(n);
            		

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
    // $ANTLR end "concatenatePin"


    // $ANTLR start "subDesign"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:358:1: subDesign[DesignDeclaration d] : ^( 'sub' name= IDENT refName= IDENT (msb= INT lsb= INT )? ( portAssignment[s] )* ) ;
    public final void subDesign(DesignDeclaration d) throws RecognitionException {
        CommonTree name=null;
        CommonTree refName=null;
        CommonTree msb=null;
        CommonTree lsb=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:359:2: ( ^( 'sub' name= IDENT refName= IDENT (msb= INT lsb= INT )? ( portAssignment[s] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:359:4: ^( 'sub' name= IDENT refName= IDENT (msb= INT lsb= INT )? ( portAssignment[s] )* )
            {
            match(input,36,FOLLOW_36_in_subDesign900); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_subDesign904); 
            refName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_subDesign908); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:359:37: (msb= INT lsb= INT )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==INT) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:359:38: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_subDesign913); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_subDesign917); 

                    }
                    break;

            }

            	
            			SubDesignDeclaration s = new SubDesignDeclaration();
            			s.setName((name!=null?name.getText():null));
            			s.setLine((name!=null?name.getLine():0));
            			s.setPos((name!=null?name.getCharPositionInLine():0));
            			s.setMsb(msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1);
            			s.setLsb(lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1);
            			s.setRefName((refName!=null?refName.getText():null));
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:372:3: ( portAssignment[s] )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==EQUALS) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:372:3: portAssignment[s]
            	    {
            	    pushFollow(FOLLOW_portAssignment_in_subDesign934);
            	    portAssignment(s);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            match(input, Token.UP, null); 
            	boolean added = d.addSubDesignDecl(s);
            			if(!added) addError(input.getSourceName() + " line " + s.getLineString()
            				+ " duplicate sub-design declaration found: " + s.getName());
            		

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:380:1: netAssignment[DesignDeclaration d] : ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ( concatenateNet[n] )* ) ;
    public final void netAssignment(DesignDeclaration d) throws RecognitionException {
        CommonTree name=null;
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree index=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:383:2: ( ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ( concatenateNet[n] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:383:4: ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ( concatenateNet[n] )* )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_netAssignment960); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netAssignment964); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:383:24: ( (msb= INT lsb= INT ) | (index= INT ) )?
            int alt23=3;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==INT) ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==INT) ) {
                    alt23=1;
                }
                else if ( ((LA23_1>=UP && LA23_1<=IDENT)) ) {
                    alt23=2;
                }
            }
            switch (alt23) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:383:25: (msb= INT lsb= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:383:25: (msb= INT lsb= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:383:26: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_netAssignment970); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_netAssignment974); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:383:45: (index= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:383:45: (index= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:383:46: index= INT
                    {
                    index=(CommonTree)match(input,INT,FOLLOW_INT_in_netAssignment982); 

                    }


                    }
                    break;

            }


            			NetAssignment n = new NetAssignment(); 
            			n.setName((name!=null?name.getText():null));
            			n.setLine((name!=null?name.getLine():0));
            			n.setPos((name!=null?name.getCharPositionInLine():0));
            			n.setMsb(msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1);
            			n.setLsb(lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1);
            			n.setIndex(index!=null?Integer.parseInt((index!=null?index.getText():null)):-1);
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:396:3: ( concatenateNet[n] )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==IDENT) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:396:3: concatenateNet[n]
            	    {
            	    pushFollow(FOLLOW_concatenateNet_in_netAssignment1002);
            	    concatenateNet(n);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            match(input, Token.UP, null); 
            	boolean added = d.addNetAssignment(n);
            			if(!added) addError(input.getSourceName() + " line " + n.getLineString()
            				+ " duplicate net assignment found: " + n.getName());
            		

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


    // $ANTLR start "concatenateNet"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:404:1: concatenateNet[NetAssignment net] : (name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ) ;
    public final void concatenateNet(NetAssignment net) throws RecognitionException {
        CommonTree name=null;
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree index=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:405:2: ( (name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:405:4: (name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? )
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:405:4: (name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:405:5: name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )?
            {
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenateNet1028); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:405:16: ( (msb= INT lsb= INT ) | (index= INT ) )?
            int alt25=3;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==INT) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==INT) ) {
                    alt25=1;
                }
                else if ( ((LA25_1>=UP && LA25_1<=IDENT)) ) {
                    alt25=2;
                }
            }
            switch (alt25) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:405:17: (msb= INT lsb= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:405:17: (msb= INT lsb= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:405:18: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_concatenateNet1034); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_concatenateNet1038); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:405:37: (index= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:405:37: (index= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:405:38: index= INT
                    {
                    index=(CommonTree)match(input,INT,FOLLOW_INT_in_concatenateNet1046); 

                    }


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
            			net.addNet(n);
            		

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
    // $ANTLR end "concatenateNet"


    // $ANTLR start "portAssignment"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:418:1: portAssignment[SubDesignDeclaration s] : ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ( concatenatePort[p] )* ) ;
    public final void portAssignment(SubDesignDeclaration s) throws RecognitionException {
        CommonTree name=null;
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree index=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:419:2: ( ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ( concatenatePort[p] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:419:4: ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ( concatenatePort[p] )* )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_portAssignment1068); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_portAssignment1072); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:419:24: ( (msb= INT lsb= INT ) | (index= INT ) )?
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:419:25: (msb= INT lsb= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:419:25: (msb= INT lsb= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:419:26: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_portAssignment1078); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_portAssignment1082); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:419:45: (index= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:419:45: (index= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:419:46: index= INT
                    {
                    index=(CommonTree)match(input,INT,FOLLOW_INT_in_portAssignment1090); 

                    }


                    }
                    break;

            }


            			PortAssignment p = new PortAssignment(); 
            			p.setName((name!=null?name.getText():null));
            			p.setLine((name!=null?name.getLine():0));
            			p.setPos((name!=null?name.getCharPositionInLine():0));
            			p.setMsb(msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1);
            			p.setLsb(lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1);
            			p.setIndex(index!=null?Integer.parseInt((index!=null?index.getText():null)):-1);
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:432:3: ( concatenatePort[p] )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==IDENT) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:432:3: concatenatePort[p]
            	    {
            	    pushFollow(FOLLOW_concatenatePort_in_portAssignment1108);
            	    concatenatePort(p);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            match(input, Token.UP, null); 
            	boolean added = s.addPortAssignment(p);
            			if(!added) addError(input.getSourceName() + " line " + p.getLineString()
            				+ " duplicate port assignment found: " + p.getName());
            		

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


    // $ANTLR start "concatenatePort"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:440:1: concatenatePort[PortAssignment p] : (name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ) ;
    public final void concatenatePort(PortAssignment p) throws RecognitionException {
        CommonTree name=null;
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree index=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:441:2: ( (name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:441:4: (name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? )
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:441:4: (name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:441:5: name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )?
            {
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenatePort1133); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:441:16: ( (msb= INT lsb= INT ) | (index= INT ) )?
            int alt28=3;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==INT) ) {
                int LA28_1 = input.LA(2);

                if ( (LA28_1==INT) ) {
                    alt28=1;
                }
                else if ( ((LA28_1>=UP && LA28_1<=IDENT)) ) {
                    alt28=2;
                }
            }
            switch (alt28) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:441:17: (msb= INT lsb= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:441:17: (msb= INT lsb= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:441:18: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_concatenatePort1139); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_concatenatePort1143); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:441:37: (index= INT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:441:37: (index= INT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\parser\\PHDLWalker.g:441:38: index= INT
                    {
                    index=(CommonTree)match(input,INT,FOLLOW_INT_in_concatenatePort1151); 

                    }


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
            			p.addNet(n);
            		

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
    // $ANTLR end "concatenatePort"

    // Delegated rules


 

    public static final BitSet FOLLOW_design_in_sourceText69 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_design87 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_design89 = new BitSet(new long[]{0x000000017F900000L});
    public static final BitSet FOLLOW_portDecl_in_design109 = new BitSet(new long[]{0x000000017F900000L});
    public static final BitSet FOLLOW_deviceDecl_in_design123 = new BitSet(new long[]{0x0000000100900000L});
    public static final BitSet FOLLOW_netDecl_in_design128 = new BitSet(new long[]{0x0000000100900000L});
    public static final BitSet FOLLOW_20_in_design141 = new BitSet(new long[]{0x0000001800000048L});
    public static final BitSet FOLLOW_instance_in_design152 = new BitSet(new long[]{0x0000001800000048L});
    public static final BitSet FOLLOW_subDesign_in_design157 = new BitSet(new long[]{0x0000001800000048L});
    public static final BitSet FOLLOW_netAssignment_in_design162 = new BitSet(new long[]{0x0000001800000048L});
    public static final BitSet FOLLOW_24_in_portDecl191 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPort_in_portDecl195 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_25_in_portDecl203 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPort_in_portDecl207 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_26_in_portDecl215 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPort_in_portDecl219 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_27_in_portDecl227 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPort_in_portDecl231 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_28_in_portDecl239 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPort_in_portDecl243 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_29_in_portDecl251 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPort_in_portDecl255 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_30_in_portDecl263 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPort_in_portDecl267 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INT_in_addPort287 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_addPort291 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_addPort297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_deviceDecl321 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl325 = new BitSet(new long[]{0x0000000000100040L});
    public static final BitSet FOLLOW_attributeDecl_in_deviceDecl348 = new BitSet(new long[]{0x0000000000100040L});
    public static final BitSet FOLLOW_20_in_deviceDecl360 = new BitSet(new long[]{0x000000007F000008L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl370 = new BitSet(new long[]{0x000000007F000008L});
    public static final BitSet FOLLOW_32_in_netDecl405 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_netDecl410 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_netDecl414 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl420 = new BitSet(new long[]{0x0000000000000208L});
    public static final BitSet FOLLOW_COLON_in_netDecl438 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_netAttribute_in_netDecl440 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_IDENT_in_netAttribute473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUALS_in_attributeDecl498 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_attributeDecl502 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_attributeDecl506 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_24_in_pinDecl528 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPin_in_pinDecl532 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_25_in_pinDecl540 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPin_in_pinDecl544 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_26_in_pinDecl552 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPin_in_pinDecl556 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_27_in_pinDecl564 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPin_in_pinDecl568 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_28_in_pinDecl576 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPin_in_pinDecl580 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_29_in_pinDecl588 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPin_in_pinDecl592 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_30_in_pinDecl600 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPin_in_pinDecl604 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INT_in_addPin624 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_addPin628 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_addPin634 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_addPin638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_instance663 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_instance667 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instance671 = new BitSet(new long[]{0x0000000000100440L});
    public static final BitSet FOLLOW_INT_in_instance676 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_instance680 = new BitSet(new long[]{0x0000000000100040L});
    public static final BitSet FOLLOW_attributeAssignment_in_instance701 = new BitSet(new long[]{0x0000000000100040L});
    public static final BitSet FOLLOW_20_in_instance707 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_pinAssignment_in_instance711 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_EQUALS_in_attributeAssignment736 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_attributeAssignment740 = new BitSet(new long[]{0x0000000000000480L});
    public static final BitSet FOLLOW_INT_in_attributeAssignment746 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_attributeAssignment750 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_INT_in_attributeAssignment758 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_attributeAssignment765 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssignment794 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_pinAssignment798 = new BitSet(new long[]{0x0000000000000418L});
    public static final BitSet FOLLOW_INT_in_pinAssignment804 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_pinAssignment808 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_INT_in_pinAssignment816 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_concatenatePin_in_pinAssignment834 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_IDENT_in_concatenatePin860 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_INT_in_concatenatePin866 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_concatenatePin870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_concatenatePin878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_subDesign900 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_subDesign904 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_subDesign908 = new BitSet(new long[]{0x0000000000000448L});
    public static final BitSet FOLLOW_INT_in_subDesign913 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_subDesign917 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_portAssignment_in_subDesign934 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_EQUALS_in_netAssignment960 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_netAssignment964 = new BitSet(new long[]{0x0000000000000418L});
    public static final BitSet FOLLOW_INT_in_netAssignment970 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_netAssignment974 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_INT_in_netAssignment982 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_concatenateNet_in_netAssignment1002 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_IDENT_in_concatenateNet1028 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_INT_in_concatenateNet1034 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_concatenateNet1038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_concatenateNet1046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUALS_in_portAssignment1068 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_portAssignment1072 = new BitSet(new long[]{0x0000000000000418L});
    public static final BitSet FOLLOW_INT_in_portAssignment1078 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_portAssignment1082 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_INT_in_portAssignment1090 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_concatenatePort_in_portAssignment1108 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_IDENT_in_concatenatePort1133 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_INT_in_concatenatePort1139 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_concatenatePort1143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_concatenatePort1151 = new BitSet(new long[]{0x0000000000000002L});

}