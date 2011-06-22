// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g 2011-06-22 00:49:00

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


        public PhdlWalker(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public PhdlWalker(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PhdlWalker.tokenNames; }
    public String getGrammarFileName() { return "C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g"; }



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
        	errors.add(input.getSourceName() + " line " + p.getLineString() + " " + msg
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:71:1: sourceText[ParsedDesigns pd] returns [ParsedDesigns designs] : ( design[pd] )* ;
    public final ParsedDesigns sourceText(ParsedDesigns pd) throws RecognitionException {
        ParsedDesigns designs = null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:75:2: ( ( design[pd] )* )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:76:3: ( design[pd] )*
            {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:76:3: ( design[pd] )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==18) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:76:3: design[pd]
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:80:1: design[ParsedDesigns pd] : ^( 'design' IDENT ( portDecl[d] | deviceDecl[d] | netDecl[d] )* 'begin' ( instance[d] | subDesign[d] | netAssignment[d] )* ) ;
    public final void design(ParsedDesigns pd) throws RecognitionException {
        CommonTree IDENT1=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:87:2: ( ^( 'design' IDENT ( portDecl[d] | deviceDecl[d] | netDecl[d] )* 'begin' ( instance[d] | subDesign[d] | netAssignment[d] )* ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:87:4: ^( 'design' IDENT ( portDecl[d] | deviceDecl[d] | netDecl[d] )* 'begin' ( instance[d] | subDesign[d] | netAssignment[d] )* )
            {
            match(input,18,FOLLOW_18_in_design91); 

            match(input, Token.DOWN, null); 
            IDENT1=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_design93); 
            	DesignDeclaration d = new DesignDeclaration();
            			d.setName((IDENT1!=null?IDENT1.getText():null));
            			d.setLine((IDENT1!=null?IDENT1.getLine():0));
            			d.setPos((IDENT1!=null?IDENT1.getCharPositionInLine():0));
            			d.setFileName(input.getSourceName());
            		
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:98:3: ( portDecl[d] | deviceDecl[d] | netDecl[d] )*
            loop2:
            do {
                int alt2=4;
                switch ( input.LA(1) ) {
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                    {
                    alt2=1;
                    }
                    break;
                case 23:
                    {
                    alt2=2;
                    }
                    break;
                case 32:
                    {
                    alt2=3;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:98:4: portDecl[d]
            	    {
            	    pushFollow(FOLLOW_portDecl_in_design115);
            	    portDecl(d);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:98:18: deviceDecl[d]
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_design120);
            	    deviceDecl(d);

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:98:34: netDecl[d]
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

            match(input,20,FOLLOW_20_in_design138); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:104:3: ( instance[d] | subDesign[d] | netAssignment[d] )*
            loop3:
            do {
                int alt3=4;
                switch ( input.LA(1) ) {
                case 35:
                    {
                    alt3=1;
                    }
                    break;
                case 36:
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
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:104:4: instance[d]
            	    {
            	    pushFollow(FOLLOW_instance_in_design149);
            	    instance(d);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:104:18: subDesign[d]
            	    {
            	    pushFollow(FOLLOW_subDesign_in_design154);
            	    subDesign(d);

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:104:33: netAssignment[d]
            	    {
            	    pushFollow(FOLLOW_netAssignment_in_design159);
            	    netAssignment(d);

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:112:1: portDecl[DesignDeclaration d] : ( ^( 'pin' addPort[d, pin] ) | ^( 'in' addPort[d, in] ) | ^( 'out' addPort[d, out] ) | ^( 'inout' addPort[d, inout] ) | ^( 'passive' addPort[d, passive] ) | ^( 'supply' addPort[d, supply] ) | ^( 'power' addPort[d, power] ) );
    public final void portDecl(DesignDeclaration d) throws RecognitionException {
        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:118:2: ( ^( 'pin' addPort[d, pin] ) | ^( 'in' addPort[d, in] ) | ^( 'out' addPort[d, out] ) | ^( 'inout' addPort[d, inout] ) | ^( 'passive' addPort[d, passive] ) | ^( 'supply' addPort[d, supply] ) | ^( 'power' addPort[d, power] ) )
            int alt4=7;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt4=1;
                }
                break;
            case 25:
                {
                alt4=2;
                }
                break;
            case 26:
                {
                alt4=3;
                }
                break;
            case 27:
                {
                alt4=4;
                }
                break;
            case 28:
                {
                alt4=5;
                }
                break;
            case 29:
                {
                alt4=6;
                }
                break;
            case 30:
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
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:118:4: ^( 'pin' addPort[d, pin] )
                    {
                    match(input,24,FOLLOW_24_in_portDecl188); 

                    PortDeclaration pin = new PortDeclaration(Type.PIN);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPort_in_portDecl192);
                    addPort(d, pin);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:119:4: ^( 'in' addPort[d, in] )
                    {
                    match(input,25,FOLLOW_25_in_portDecl200); 

                    PortDeclaration in = new PortDeclaration(Type.IN);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPort_in_portDecl204);
                    addPort(d, in);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:120:4: ^( 'out' addPort[d, out] )
                    {
                    match(input,26,FOLLOW_26_in_portDecl212); 

                    PortDeclaration out = new PortDeclaration(Type.OUT);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPort_in_portDecl216);
                    addPort(d, out);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:121:4: ^( 'inout' addPort[d, inout] )
                    {
                    match(input,27,FOLLOW_27_in_portDecl224); 

                    PortDeclaration inout = new PortDeclaration(Type.INOUT);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPort_in_portDecl228);
                    addPort(d, inout);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:122:4: ^( 'passive' addPort[d, passive] )
                    {
                    match(input,28,FOLLOW_28_in_portDecl236); 

                    PortDeclaration passive = new PortDeclaration(Type.PASSIVE);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPort_in_portDecl240);
                    addPort(d, passive);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:123:4: ^( 'supply' addPort[d, supply] )
                    {
                    match(input,29,FOLLOW_29_in_portDecl248); 

                    PortDeclaration supply = new PortDeclaration(Type.SUPPLY);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPort_in_portDecl252);
                    addPort(d, supply);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 7 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:124:4: ^( 'power' addPort[d, power] )
                    {
                    match(input,30,FOLLOW_30_in_portDecl260); 

                    PortDeclaration power = new PortDeclaration(Type.POWER);

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:127:1: addPort[DesignDeclaration d, PortDeclaration p] : (msb= INT lsb= INT )? name= IDENT ;
    public final void addPort(DesignDeclaration d, PortDeclaration p) throws RecognitionException {
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree name=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:132:2: ( (msb= INT lsb= INT )? name= IDENT )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:132:4: (msb= INT lsb= INT )? name= IDENT
            {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:132:4: (msb= INT lsb= INT )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==INT) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:132:5: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_addPort284); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_addPort288); 

                    }
                    break;

            }

            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_addPort294); 
            	
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:146:1: deviceDecl[DesignDeclaration d] : ^( 'device' name= IDENT ( attributeDecl[dev] )* 'begin' ( pinDecl[dev] )* ) ;
    public final void deviceDecl(DesignDeclaration d) throws RecognitionException {
        CommonTree name=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:153:2: ( ^( 'device' name= IDENT ( attributeDecl[dev] )* 'begin' ( pinDecl[dev] )* ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:153:4: ^( 'device' name= IDENT ( attributeDecl[dev] )* 'begin' ( pinDecl[dev] )* )
            {
            match(input,23,FOLLOW_23_in_deviceDecl314); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl318); 
            	DeviceDeclaration dev = new DeviceDeclaration();
            				dev.setName((name!=null?name.getText():null));
            				dev.setLine((name!=null?name.getLine():0));
            				dev.setPos((name!=null?name.getCharPositionInLine():0));
            				dev.setFileName(input.getSourceName());
            			
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:164:3: ( attributeDecl[dev] )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==EQUALS) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:164:3: attributeDecl[dev]
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_deviceDecl341);
            	    attributeDecl(dev);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match(input,20,FOLLOW_20_in_deviceDecl353); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:170:3: ( pinDecl[dev] )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=24 && LA7_0<=30)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:170:3: pinDecl[dev]
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl363);
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:180:1: netDecl[DesignDeclaration d] : ^( 'net' (msb= INT lsb= INT )? name= IDENT ( COLON ( netAttribute[n] )+ )? ) ;
    public final void netDecl(DesignDeclaration d) throws RecognitionException {
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree name=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:185:2: ( ^( 'net' (msb= INT lsb= INT )? name= IDENT ( COLON ( netAttribute[n] )+ )? ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:185:4: ^( 'net' (msb= INT lsb= INT )? name= IDENT ( COLON ( netAttribute[n] )+ )? )
            {
            match(input,32,FOLLOW_32_in_netDecl398); 

            match(input, Token.DOWN, null); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:185:12: (msb= INT lsb= INT )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==INT) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:185:13: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_netDecl403); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_netDecl407); 

                    }
                    break;

            }

            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netDecl413); 
            	NetDeclaration n = new NetDeclaration(); 
            			n.setName((name!=null?name.getText():null));
            			n.setLine((name!=null?name.getLine():0));
            			n.setPos((name!=null?name.getCharPositionInLine():0));
            			n.setMsb(msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1);
            			n.setLsb(lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1);
            			n.setFileName(input.getSourceName());
            		
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:198:3: ( COLON ( netAttribute[n] )+ )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==COLON) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:198:4: COLON ( netAttribute[n] )+
                    {
                    match(input,COLON,FOLLOW_COLON_in_netDecl431); 
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:198:10: ( netAttribute[n] )+
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
                    	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:198:10: netAttribute[n]
                    	    {
                    	    pushFollow(FOLLOW_netAttribute_in_netDecl433);
                    	    netAttribute(n);

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


    // $ANTLR start "netAttribute"
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:207:1: netAttribute[NetDeclaration n] : IDENT ;
    public final void netAttribute(NetDeclaration n) throws RecognitionException {
        CommonTree IDENT2=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:210:2: ( IDENT )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:210:4: IDENT
            {
            IDENT2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netAttribute466); 
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
    // $ANTLR end "netAttribute"


    // $ANTLR start "attributeDecl"
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:218:1: attributeDecl[DeviceDeclaration d] : ^( EQUALS name= IDENT value= STRING_LITERAL ) ;
    public final void attributeDecl(DeviceDeclaration d) throws RecognitionException {
        CommonTree name=null;
        CommonTree value=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:222:2: ( ^( EQUALS name= IDENT value= STRING_LITERAL ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:222:4: ^( EQUALS name= IDENT value= STRING_LITERAL )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_attributeDecl490); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attributeDecl494); 
            value=(CommonTree)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_attributeDecl498); 

            match(input, Token.UP, null); 
            	AttributeDeclaration a = new AttributeDeclaration();
            			a.setName((name!=null?name.getText():null));
            			a.setLine((name!=null?name.getLine():0));
            			a.setPos((name!=null?name.getCharPositionInLine():0));
            			a.setValue((value!=null?value.getText():null));
            			a.setFileName(input.getSourceName());
            			
            			if(!d.addAttributeDecl(a)) 
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
    // $ANTLR end "attributeDecl"


    // $ANTLR start "pinDecl"
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:237:1: pinDecl[DeviceDeclaration d] : ( ^( 'pin' addPin[d, pin] ) | ^( 'in' addPin[d, in] ) | ^( 'out' addPin[d, out] ) | ^( 'inout' addPin[d, inout] ) | ^( 'passive' addPin[d, passive] ) | ^( 'supply' addPin[d, supply] ) | ^( 'power' addPin[d, power] ) );
    public final void pinDecl(DeviceDeclaration d) throws RecognitionException {
        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:242:2: ( ^( 'pin' addPin[d, pin] ) | ^( 'in' addPin[d, in] ) | ^( 'out' addPin[d, out] ) | ^( 'inout' addPin[d, inout] ) | ^( 'passive' addPin[d, passive] ) | ^( 'supply' addPin[d, supply] ) | ^( 'power' addPin[d, power] ) )
            int alt11=7;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt11=1;
                }
                break;
            case 25:
                {
                alt11=2;
                }
                break;
            case 26:
                {
                alt11=3;
                }
                break;
            case 27:
                {
                alt11=4;
                }
                break;
            case 28:
                {
                alt11=5;
                }
                break;
            case 29:
                {
                alt11=6;
                }
                break;
            case 30:
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
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:242:4: ^( 'pin' addPin[d, pin] )
                    {
                    match(input,24,FOLLOW_24_in_pinDecl525); 

                    PinDeclaration pin = new PinDeclaration(Type.PIN);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPin_in_pinDecl529);
                    addPin(d, pin);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:243:4: ^( 'in' addPin[d, in] )
                    {
                    match(input,25,FOLLOW_25_in_pinDecl537); 

                    PinDeclaration in = new PinDeclaration(Type.IN);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPin_in_pinDecl541);
                    addPin(d, in);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:244:4: ^( 'out' addPin[d, out] )
                    {
                    match(input,26,FOLLOW_26_in_pinDecl549); 

                    PinDeclaration out = new PinDeclaration(Type.OUT);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPin_in_pinDecl553);
                    addPin(d, out);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:245:4: ^( 'inout' addPin[d, inout] )
                    {
                    match(input,27,FOLLOW_27_in_pinDecl561); 

                    PinDeclaration inout = new PinDeclaration(Type.INOUT);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPin_in_pinDecl565);
                    addPin(d, inout);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:246:4: ^( 'passive' addPin[d, passive] )
                    {
                    match(input,28,FOLLOW_28_in_pinDecl573); 

                    PinDeclaration passive = new PinDeclaration(Type.PASSIVE);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPin_in_pinDecl577);
                    addPin(d, passive);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:247:4: ^( 'supply' addPin[d, supply] )
                    {
                    match(input,29,FOLLOW_29_in_pinDecl585); 

                    PinDeclaration supply = new PinDeclaration(Type.SUPPLY);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPin_in_pinDecl589);
                    addPin(d, supply);

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 7 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:248:4: ^( 'power' addPin[d, power] )
                    {
                    match(input,30,FOLLOW_30_in_pinDecl597); 

                    PinDeclaration power = new PinDeclaration(Type.POWER);

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_addPin_in_pinDecl601);
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:251:1: addPin[DeviceDeclaration d, PinDeclaration p] : (msb= INT lsb= INT )? name= IDENT pinList= STRING_LITERAL ;
    public final void addPin(DeviceDeclaration d, PinDeclaration p) throws RecognitionException {
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree name=null;
        CommonTree pinList=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:255:2: ( (msb= INT lsb= INT )? name= IDENT pinList= STRING_LITERAL )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:255:4: (msb= INT lsb= INT )? name= IDENT pinList= STRING_LITERAL
            {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:255:4: (msb= INT lsb= INT )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==INT) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:255:5: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_addPin621); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_addPin625); 

                    }
                    break;

            }

            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_addPin631); 
            pinList=(CommonTree)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_addPin635); 
            	
            			p.setName((name!=null?name.getText():null));
            			p.setLine((name!=null?name.getLine():0));
            			p.setPos((name!=null?name.getCharPositionInLine():0));
            			p.setMsb(msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1);
            			p.setLsb(lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1);
            			p.setPinList((pinList!=null?pinList.getText():null));
            			p.setFileName(input.getSourceName());
            			
            			if(!p.pinMap()) 
            				addError(p, "invalid pin number list");
            			
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
    // $ANTLR end "addPin"


    // $ANTLR start "instance"
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:273:1: instance[DesignDeclaration d] : ^( 'inst' name= IDENT refName= IDENT (msb= INT lsb= INT )? ( attributeAssignment[i] )* 'begin' ( pinAssignment[i] )* ) ;
    public final void instance(DesignDeclaration d) throws RecognitionException {
        CommonTree name=null;
        CommonTree refName=null;
        CommonTree msb=null;
        CommonTree lsb=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:277:2: ( ^( 'inst' name= IDENT refName= IDENT (msb= INT lsb= INT )? ( attributeAssignment[i] )* 'begin' ( pinAssignment[i] )* ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:277:4: ^( 'inst' name= IDENT refName= IDENT (msb= INT lsb= INT )? ( attributeAssignment[i] )* 'begin' ( pinAssignment[i] )* )
            {
            match(input,35,FOLLOW_35_in_instance656); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instance660); 
            refName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instance664); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:277:38: (msb= INT lsb= INT )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==INT) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:277:39: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_instance669); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_instance673); 

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
            				i.setFileName(input.getSourceName());
            		
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:291:3: ( attributeAssignment[i] )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==EQUALS) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:291:3: attributeAssignment[i]
            	    {
            	    pushFollow(FOLLOW_attributeAssignment_in_instance694);
            	    attributeAssignment(i);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            match(input,20,FOLLOW_20_in_instance700); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:293:3: ( pinAssignment[i] )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==EQUALS) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:293:3: pinAssignment[i]
            	    {
            	    pushFollow(FOLLOW_pinAssignment_in_instance704);
            	    pinAssignment(i);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            match(input, Token.UP, null); 
            	if(!d.addInstanceDecl(i)) 
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


    // $ANTLR start "attributeAssignment"
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:300:1: attributeAssignment[InstanceDeclaration i] : ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? value= STRING_LITERAL ) ;
    public final void attributeAssignment(InstanceDeclaration i) throws RecognitionException {
        CommonTree name=null;
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree index=null;
        CommonTree value=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:306:2: ( ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? value= STRING_LITERAL ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:306:4: ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? value= STRING_LITERAL )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_attributeAssignment729); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attributeAssignment733); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:306:24: ( (msb= INT lsb= INT ) | (index= INT ) )?
            int alt16=3;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==INT) ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==INT) ) {
                    alt16=1;
                }
                else if ( (LA16_1==STRING_LITERAL) ) {
                    alt16=2;
                }
            }
            switch (alt16) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:306:25: (msb= INT lsb= INT )
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:306:25: (msb= INT lsb= INT )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:306:26: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_attributeAssignment739); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_attributeAssignment743); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:306:45: (index= INT )
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:306:45: (index= INT )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:306:46: index= INT
                    {
                    index=(CommonTree)match(input,INT,FOLLOW_INT_in_attributeAssignment751); 

                    }


                    }
                    break;

            }

            value=(CommonTree)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_attributeAssignment758); 

            match(input, Token.UP, null); 
            	AttributeAssignment a = new AttributeAssignment();
            			a.setName((name!=null?name.getText():null));
            			a.setLine((name!=null?name.getLine():0));
            			a.setPos((name!=null?name.getCharPositionInLine():0));
            			a.setMsb(msb!=null?Integer.parseInt((msb!=null?msb.getText():null)):-1);
            			a.setLsb(lsb!=null?Integer.parseInt((lsb!=null?lsb.getText():null)):-1);
            			a.setIndex(index!=null?Integer.parseInt((index!=null?index.getText():null)):-1);
            			a.setValue((value!=null?value.getText():null));
            			a.setFileName(input.getSourceName());
            			
            			if(!i.addAttributeAssignment(a)) 
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
    // $ANTLR end "attributeAssignment"


    // $ANTLR start "pinAssignment"
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:325:1: pinAssignment[InstanceDeclaration i] : ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ( concatenatePin[p] )* ) ;
    public final void pinAssignment(InstanceDeclaration i) throws RecognitionException {
        CommonTree name=null;
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree index=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:328:2: ( ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ( concatenatePin[p] )* ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:328:4: ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ( concatenatePin[p] )* )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_pinAssignment787); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinAssignment791); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:328:24: ( (msb= INT lsb= INT ) | (index= INT ) )?
            int alt17=3;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==INT) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==INT) ) {
                    alt17=1;
                }
                else if ( ((LA17_1>=UP && LA17_1<=IDENT)) ) {
                    alt17=2;
                }
            }
            switch (alt17) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:328:25: (msb= INT lsb= INT )
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:328:25: (msb= INT lsb= INT )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:328:26: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_pinAssignment797); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_pinAssignment801); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:328:45: (index= INT )
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:328:45: (index= INT )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:328:46: index= INT
                    {
                    index=(CommonTree)match(input,INT,FOLLOW_INT_in_pinAssignment809); 

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
            			p.setFileName(input.getSourceName());
            		
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:342:3: ( concatenatePin[p] )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==IDENT) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:342:3: concatenatePin[p]
            	    {
            	    pushFollow(FOLLOW_concatenatePin_in_pinAssignment827);
            	    concatenatePin(p);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            match(input, Token.UP, null); 
            	if(!i.addPinAssignment(p)) 
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
    // $ANTLR end "pinAssignment"


    // $ANTLR start "concatenatePin"
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:349:1: concatenatePin[PinAssignment pa] : (name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ) ;
    public final void concatenatePin(PinAssignment pa) throws RecognitionException {
        CommonTree name=null;
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree index=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:350:2: ( (name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:350:4: (name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? )
            {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:350:4: (name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:350:5: name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )?
            {
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenatePin853); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:350:16: ( (msb= INT lsb= INT ) | (index= INT ) )?
            int alt19=3;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==INT) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==INT) ) {
                    alt19=1;
                }
                else if ( ((LA19_1>=UP && LA19_1<=IDENT)) ) {
                    alt19=2;
                }
            }
            switch (alt19) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:350:17: (msb= INT lsb= INT )
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:350:17: (msb= INT lsb= INT )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:350:18: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_concatenatePin859); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_concatenatePin863); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:350:37: (index= INT )
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:350:37: (index= INT )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:350:38: index= INT
                    {
                    index=(CommonTree)match(input,INT,FOLLOW_INT_in_concatenatePin871); 

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
    // $ANTLR end "concatenatePin"


    // $ANTLR start "subDesign"
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:364:1: subDesign[DesignDeclaration d] : ^( 'sub' name= IDENT refName= IDENT (msb= INT lsb= INT )? ( portAssignment[s] )* ) ;
    public final void subDesign(DesignDeclaration d) throws RecognitionException {
        CommonTree name=null;
        CommonTree refName=null;
        CommonTree msb=null;
        CommonTree lsb=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:365:2: ( ^( 'sub' name= IDENT refName= IDENT (msb= INT lsb= INT )? ( portAssignment[s] )* ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:365:4: ^( 'sub' name= IDENT refName= IDENT (msb= INT lsb= INT )? ( portAssignment[s] )* )
            {
            match(input,36,FOLLOW_36_in_subDesign893); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_subDesign897); 
            refName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_subDesign901); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:365:37: (msb= INT lsb= INT )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==INT) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:365:38: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_subDesign906); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_subDesign910); 

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
            			s.setFileName(input.getSourceName());
            		
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:379:3: ( portAssignment[s] )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==EQUALS) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:379:3: portAssignment[s]
            	    {
            	    pushFollow(FOLLOW_portAssignment_in_subDesign927);
            	    portAssignment(s);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            match(input, Token.UP, null); 
            	if(!d.addSubDesignDecl(s)) 
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


    // $ANTLR start "netAssignment"
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:386:1: netAssignment[DesignDeclaration d] : ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ( concatenateNet[n] )* ) ;
    public final void netAssignment(DesignDeclaration d) throws RecognitionException {
        CommonTree name=null;
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree index=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:389:2: ( ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ( concatenateNet[n] )* ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:389:4: ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ( concatenateNet[n] )* )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_netAssignment953); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netAssignment957); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:389:24: ( (msb= INT lsb= INT ) | (index= INT ) )?
            int alt22=3;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==INT) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==INT) ) {
                    alt22=1;
                }
                else if ( ((LA22_1>=UP && LA22_1<=IDENT)) ) {
                    alt22=2;
                }
            }
            switch (alt22) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:389:25: (msb= INT lsb= INT )
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:389:25: (msb= INT lsb= INT )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:389:26: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_netAssignment963); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_netAssignment967); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:389:45: (index= INT )
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:389:45: (index= INT )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:389:46: index= INT
                    {
                    index=(CommonTree)match(input,INT,FOLLOW_INT_in_netAssignment975); 

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
            			n.setFileName(input.getSourceName());
            		
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:403:3: ( concatenateNet[n] )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==IDENT) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:403:3: concatenateNet[n]
            	    {
            	    pushFollow(FOLLOW_concatenateNet_in_netAssignment995);
            	    concatenateNet(n);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            match(input, Token.UP, null); 
            	if(!d.addNetAssignment(n)) 
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
    // $ANTLR end "netAssignment"


    // $ANTLR start "concatenateNet"
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:410:1: concatenateNet[NetAssignment na] : (name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ) ;
    public final void concatenateNet(NetAssignment na) throws RecognitionException {
        CommonTree name=null;
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree index=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:411:2: ( (name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:411:4: (name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? )
            {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:411:4: (name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:411:5: name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )?
            {
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenateNet1021); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:411:16: ( (msb= INT lsb= INT ) | (index= INT ) )?
            int alt24=3;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==INT) ) {
                int LA24_1 = input.LA(2);

                if ( (LA24_1==INT) ) {
                    alt24=1;
                }
                else if ( ((LA24_1>=UP && LA24_1<=IDENT)) ) {
                    alt24=2;
                }
            }
            switch (alt24) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:411:17: (msb= INT lsb= INT )
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:411:17: (msb= INT lsb= INT )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:411:18: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_concatenateNet1027); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_concatenateNet1031); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:411:37: (index= INT )
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:411:37: (index= INT )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:411:38: index= INT
                    {
                    index=(CommonTree)match(input,INT,FOLLOW_INT_in_concatenateNet1039); 

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
    // $ANTLR end "concatenateNet"


    // $ANTLR start "portAssignment"
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:425:1: portAssignment[SubDesignDeclaration s] : ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ( concatenatePort[p] )* ) ;
    public final void portAssignment(SubDesignDeclaration s) throws RecognitionException {
        CommonTree name=null;
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree index=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:426:2: ( ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ( concatenatePort[p] )* ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:426:4: ^( EQUALS name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ( concatenatePort[p] )* )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_portAssignment1061); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_portAssignment1065); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:426:24: ( (msb= INT lsb= INT ) | (index= INT ) )?
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
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:426:25: (msb= INT lsb= INT )
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:426:25: (msb= INT lsb= INT )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:426:26: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_portAssignment1071); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_portAssignment1075); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:426:45: (index= INT )
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:426:45: (index= INT )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:426:46: index= INT
                    {
                    index=(CommonTree)match(input,INT,FOLLOW_INT_in_portAssignment1083); 

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
            			p.setFileName(input.getSourceName());
            		
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:440:3: ( concatenatePort[p] )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==IDENT) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:440:3: concatenatePort[p]
            	    {
            	    pushFollow(FOLLOW_concatenatePort_in_portAssignment1101);
            	    concatenatePort(p);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            match(input, Token.UP, null); 
            	if(!s.addPortAssignment(p)) 
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


    // $ANTLR start "concatenatePort"
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:447:1: concatenatePort[PortAssignment pa] : (name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ) ;
    public final void concatenatePort(PortAssignment pa) throws RecognitionException {
        CommonTree name=null;
        CommonTree msb=null;
        CommonTree lsb=null;
        CommonTree index=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:448:2: ( (name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:448:4: (name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? )
            {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:448:4: (name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )? )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:448:5: name= IDENT ( (msb= INT lsb= INT ) | (index= INT ) )?
            {
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenatePort1126); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:448:16: ( (msb= INT lsb= INT ) | (index= INT ) )?
            int alt27=3;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==INT) ) {
                int LA27_1 = input.LA(2);

                if ( (LA27_1==INT) ) {
                    alt27=1;
                }
                else if ( ((LA27_1>=UP && LA27_1<=IDENT)) ) {
                    alt27=2;
                }
            }
            switch (alt27) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:448:17: (msb= INT lsb= INT )
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:448:17: (msb= INT lsb= INT )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:448:18: msb= INT lsb= INT
                    {
                    msb=(CommonTree)match(input,INT,FOLLOW_INT_in_concatenatePort1132); 
                    lsb=(CommonTree)match(input,INT,FOLLOW_INT_in_concatenatePort1136); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:448:37: (index= INT )
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:448:37: (index= INT )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:448:38: index= INT
                    {
                    index=(CommonTree)match(input,INT,FOLLOW_INT_in_concatenatePort1144); 

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
    // $ANTLR end "concatenatePort"

    // Delegated rules


 

    public static final BitSet FOLLOW_design_in_sourceText69 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_design91 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_design93 = new BitSet(new long[]{0x000000017F900000L});
    public static final BitSet FOLLOW_portDecl_in_design115 = new BitSet(new long[]{0x000000017F900000L});
    public static final BitSet FOLLOW_deviceDecl_in_design120 = new BitSet(new long[]{0x000000017F900000L});
    public static final BitSet FOLLOW_netDecl_in_design125 = new BitSet(new long[]{0x000000017F900000L});
    public static final BitSet FOLLOW_20_in_design138 = new BitSet(new long[]{0x0000001800000048L});
    public static final BitSet FOLLOW_instance_in_design149 = new BitSet(new long[]{0x0000001800000048L});
    public static final BitSet FOLLOW_subDesign_in_design154 = new BitSet(new long[]{0x0000001800000048L});
    public static final BitSet FOLLOW_netAssignment_in_design159 = new BitSet(new long[]{0x0000001800000048L});
    public static final BitSet FOLLOW_24_in_portDecl188 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPort_in_portDecl192 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_25_in_portDecl200 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPort_in_portDecl204 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_26_in_portDecl212 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPort_in_portDecl216 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_27_in_portDecl224 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPort_in_portDecl228 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_28_in_portDecl236 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPort_in_portDecl240 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_29_in_portDecl248 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPort_in_portDecl252 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_30_in_portDecl260 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPort_in_portDecl264 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INT_in_addPort284 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_addPort288 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_addPort294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_deviceDecl314 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl318 = new BitSet(new long[]{0x0000000000100040L});
    public static final BitSet FOLLOW_attributeDecl_in_deviceDecl341 = new BitSet(new long[]{0x0000000000100040L});
    public static final BitSet FOLLOW_20_in_deviceDecl353 = new BitSet(new long[]{0x000000007F000008L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl363 = new BitSet(new long[]{0x000000007F000008L});
    public static final BitSet FOLLOW_32_in_netDecl398 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_netDecl403 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_netDecl407 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl413 = new BitSet(new long[]{0x0000000000000208L});
    public static final BitSet FOLLOW_COLON_in_netDecl431 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_netAttribute_in_netDecl433 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_IDENT_in_netAttribute466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUALS_in_attributeDecl490 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_attributeDecl494 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_attributeDecl498 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_24_in_pinDecl525 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPin_in_pinDecl529 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_25_in_pinDecl537 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPin_in_pinDecl541 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_26_in_pinDecl549 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPin_in_pinDecl553 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_27_in_pinDecl561 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPin_in_pinDecl565 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_28_in_pinDecl573 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPin_in_pinDecl577 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_29_in_pinDecl585 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPin_in_pinDecl589 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_30_in_pinDecl597 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPin_in_pinDecl601 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INT_in_addPin621 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_addPin625 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_addPin631 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_addPin635 = new BitSet(new long[]{0x0000000000000002L});
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
    public static final BitSet FOLLOW_STRING_LITERAL_in_attributeAssignment758 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssignment787 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_pinAssignment791 = new BitSet(new long[]{0x0000000000000418L});
    public static final BitSet FOLLOW_INT_in_pinAssignment797 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_pinAssignment801 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_INT_in_pinAssignment809 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_concatenatePin_in_pinAssignment827 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_IDENT_in_concatenatePin853 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_INT_in_concatenatePin859 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_concatenatePin863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_concatenatePin871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_subDesign893 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_subDesign897 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_subDesign901 = new BitSet(new long[]{0x0000000000000448L});
    public static final BitSet FOLLOW_INT_in_subDesign906 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_subDesign910 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_portAssignment_in_subDesign927 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_EQUALS_in_netAssignment953 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_netAssignment957 = new BitSet(new long[]{0x0000000000000418L});
    public static final BitSet FOLLOW_INT_in_netAssignment963 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_netAssignment967 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_INT_in_netAssignment975 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_concatenateNet_in_netAssignment995 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_IDENT_in_concatenateNet1021 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_INT_in_concatenateNet1027 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_concatenateNet1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_concatenateNet1039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUALS_in_portAssignment1061 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_portAssignment1065 = new BitSet(new long[]{0x0000000000000418L});
    public static final BitSet FOLLOW_INT_in_portAssignment1071 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_portAssignment1075 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_INT_in_portAssignment1083 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_concatenatePort_in_portAssignment1101 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_IDENT_in_concatenatePort1126 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_INT_in_concatenatePort1132 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_concatenatePort1136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_concatenatePort1144 = new BitSet(new long[]{0x0000000000000002L});

}