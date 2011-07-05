// $ANTLR 3.3 Nov 30, 2010 12:50:56 /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g 2011-07-05 11:45:42

	package phdl.grammar;
	import java.util.TreeSet;
	import java.util.SortedSet;
	import java.util.List;
	import java.util.ArrayList;
	import phdl.graph.*;


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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "SEMICOLON", "EQUALS", "STRING_LITERAL", "INT", "CHAR", "DIGIT", "COLON", "COMMA", "PERIOD", "LBRACKET", "RBRACKET", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "'design'", "'is'", "'begin'", "'end'", "'device'", "'attr'", "'pin'", "'net'", "'inst'", "'new'", "'&'", "'<'", "'>'", "'open'", "'{'", "'}'", "'('", "')'", "SLICE_LIST", "'='"
    };
    public static final int EOF=-1;
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
    public static final int IDENT=4;
    public static final int SEMICOLON=5;
    public static final int EQUALS=6;
    public static final int STRING_LITERAL=7;
    public static final int INT=8;
    public static final int CHAR=9;
    public static final int DIGIT=10;
    public static final int COLON=11;
    public static final int COMMA=12;
    public static final int PERIOD=13;
    public static final int LBRACKET=14;
    public static final int RBRACKET=15;
    public static final int WHITESPACE=16;
    public static final int LINE_COMMENT=17;
    public static final int MULTILINE_COMMENT=18;
    public static final int T__38=38;
    public static final int SLICE_LIST=37;

    // delegates
    // delegators


        public PhdlWalker(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public PhdlWalker(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PhdlWalker.tokenNames; }
    public String getGrammarFileName() { return "/Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g"; }



      private String code = "";

    	private SortedSet<String> errors = new TreeSet<String>();
    	
    	@Override
        public void displayRecognitionError(String[] tokenNames,
                                            RecognitionException e) {
            String hdr = getErrorHeader(e);
            String msg = getErrorMessage(e, tokenNames);
            errors.add(input.getSourceName() + hdr + " " + msg);
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
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:67:1: sourceText[DesignNode d] returns [DesignNode dn] : design[d] EOF ;
    public final DesignNode sourceText(DesignNode d) throws RecognitionException {
        DesignNode dn = null;

        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:71:2: ( design[d] EOF )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:72:3: design[d] EOF
            {
            pushFollow(FOLLOW_design_in_sourceText69);
            design(d);

            state._fsp--;

            dn = d;
            match(input,EOF,FOLLOW_EOF_in_sourceText78); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return dn;
    }
    // $ANTLR end "sourceText"


    // $ANTLR start "design"
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:77:1: design[DesignNode d] : ^( 'design' name= IDENT ( deviceDecl[d] | netDecl[d] )* 'begin' ( instDecl[d] | netAssign[d] )* ) ;
    public final void design(DesignNode d) throws RecognitionException {
        CommonTree name=null;

        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:84:2: ( ^( 'design' name= IDENT ( deviceDecl[d] | netDecl[d] )* 'begin' ( instDecl[d] | netAssign[d] )* ) )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:84:4: ^( 'design' name= IDENT ( deviceDecl[d] | netDecl[d] )* 'begin' ( instDecl[d] | netAssign[d] )* )
            {
            match(input,19,FOLLOW_19_in_design94); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_design98); 
            	d.setupDesign(name);
            		  d.setName((name!=null?name.getText():null));
            			d.setLine((name!=null?name.getLine():0));
            			d.setPos((name!=null?name.getCharPositionInLine():0));
            			d.setFileName(input.getSourceName());
            		
             code += "DESIGN" + (name!=null?name.getText():null) + "[" + (name!=null?name.getLine():0) + ":" + (name!=null?name.getCharPositionInLine():0) + "]\n"; 
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:98:3: ( deviceDecl[d] | netDecl[d] )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==23) ) {
                    alt1=1;
                }
                else if ( (LA1_0==26) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:98:4: deviceDecl[d]
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_design130);
            	    deviceDecl(d);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:98:20: netDecl[d]
            	    {
            	    pushFollow(FOLLOW_netDecl_in_design135);
            	    netDecl(d);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match(input,21,FOLLOW_21_in_design148); 
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:104:3: ( instDecl[d] | netAssign[d] )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==27) ) {
                    alt2=1;
                }
                else if ( (LA2_0==EQUALS) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:104:4: instDecl[d]
            	    {
            	    pushFollow(FOLLOW_instDecl_in_design159);
            	    instDecl(d);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:104:18: netAssign[d]
            	    {
            	    pushFollow(FOLLOW_netAssign_in_design164);
            	    netAssign(d);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            match(input, Token.UP, null); 

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
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:108:1: deviceDecl[DesignNode d] : ^( 'device' name= IDENT ( ( attributeDecl[a] ) | ( pinDecl[p] ) )* ) ;
    public final void deviceDecl(DesignNode d) throws RecognitionException {
        CommonTree name=null;

        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:115:2: ( ^( 'device' name= IDENT ( ( attributeDecl[a] ) | ( pinDecl[p] ) )* ) )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:115:4: ^( 'device' name= IDENT ( ( attributeDecl[a] ) | ( pinDecl[p] ) )* )
            {
            match(input,23,FOLLOW_23_in_deviceDecl187); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl191); 
            	DeviceNode dev = d.setupDevice(name);
            			  DeviceNode dev = new DeviceNode(d);
            				dev.setName((name!=null?name.getText():null));
            				dev.setLine((name!=null?name.getLine():0));
            				dev.setPos((name!=null?name.getCharPositionInLine():0));
            				dev.setFileName(input.getSourceName());
            			
             code += "\tDEVICE " + (name!=null?name.getText():null) + "[" + (name!=null?name.getLine():0) + ":" + (name!=null?name.getCharPositionInLine():0) + "]\n"; 
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:130:4: ( ( attributeDecl[a] ) | ( pinDecl[p] ) )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==24) ) {
                    alt3=1;
                }
                else if ( (LA3_0==25) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:131:6: ( attributeDecl[a] )
            	    {
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:131:6: ( attributeDecl[a] )
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:132:8: attributeDecl[a]
            	    {
            	     AttributeNode a  = new AttributeNode(dev); 
            	    pushFollow(FOLLOW_attributeDecl_in_deviceDecl257);
            	    attributeDecl(a);

            	    state._fsp--;

            	     dev.addAttribute(a); 

            	    }


            	    }
            	    break;
            	case 2 :
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:137:6: ( pinDecl[p] )
            	    {
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:137:6: ( pinDecl[p] )
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:138:8: pinDecl[p]
            	    {
            	     PinNode p = new PinNode(dev); 
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl306);
            	    pinDecl(p);

            	    state._fsp--;

            	     dev.addPin(p); 

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            match(input, Token.UP, null); 
            	if(!d.addDeviceDecl(dev)) {
            				System.err.println(dev.getName() + " " + dev.getLine() + ":" + dev.getPosition() + " - duplicate device declaration");
            				System.exit(1);
            			}
            		

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
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:154:1: netDecl[DesignNode d] : ^( 'net' ( sliceList[slices] )? name= IDENT ( attributeDecl[a] )* ) ;
    public final void netDecl(DesignNode d) throws RecognitionException {
        CommonTree name=null;

        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:159:2: ( ^( 'net' ( sliceList[slices] )? name= IDENT ( attributeDecl[a] )* ) )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:159:4: ^( 'net' ( sliceList[slices] )? name= IDENT ( attributeDecl[a] )* )
            {
            match(input,26,FOLLOW_26_in_netDecl361); 

             code += "\tNET"; 
             List<Integer> slices = new ArrayList<Integer>(); 

            match(input, Token.DOWN, null); 
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:162:5: ( sliceList[slices] )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=COLON && LA4_0<=COMMA)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:162:5: sliceList[slices]
                    {
                    pushFollow(FOLLOW_sliceList_in_netDecl379);
                    sliceList(slices);

                    state._fsp--;


                    }
                    break;

            }

            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netDecl389); 
             code += (name!=null?name.getText():null); 
             List<AttributeNode> attrs = new ArrayList<AttributeNodes>(); 
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:166:3: ( attributeDecl[a] )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==24) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:167:5: attributeDecl[a]
            	    {
            	     AttributeNode a = new AttributeNode(null); 
            	    pushFollow(FOLLOW_attributeDecl_in_netDecl413);
            	    attributeDecl(a);

            	    state._fsp--;

            	     attrs.add(a); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

               List<NetNode> nodes = new ArrayList<NetNode>();
                    for (Integer i : slices) {
                      NetNode newNode = new NetNode(d);
                      newNode.setName((name!=null?name.getText():null) + "[" + i + "]");
                      newNode.setLine((name!=null?name.getLine():0));
                      newNode.setPos((name!=null?name.getCharPositionInLine():0));
                      newNode.setFileName(input.getSourceName());
                      for (a : attrs) {
                        a.setParent(newNode);
                        newNode.addAttribute(a);
                      }
                      nodes.add(newNode);
                    }
                

            match(input, Token.UP, null); 
            	for (NetNode n : nodes) {
            		    if(!d.addNetNode(n)) {
            		      System.err.println(n.getName() + " " + n.getLine() + ":" + n.getPosition() + " - duplicate net declaration");
                      System.exit(1);
                    }
            			}
            		

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


    // $ANTLR start "attributeDecl"
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:197:1: attributeDecl[AttributeNode a] : ^( 'attr' name= IDENT value= STRING_LITERAL ) ;
    public final void attributeDecl(AttributeNode a) throws RecognitionException {
        CommonTree name=null;
        CommonTree value=null;

        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:198:3: ( ^( 'attr' name= IDENT value= STRING_LITERAL ) )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:199:5: ^( 'attr' name= IDENT value= STRING_LITERAL )
            {
            match(input,24,FOLLOW_24_in_attributeDecl462); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attributeDecl474); 
            value=(CommonTree)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_attributeDecl486); 
             code += "\t\tATTR" + (name!=null?name.getText():null) + "[" + (name!=null?name.getLine():0) + ":" + (name!=null?name.getCharPositionInLine():0) + "] = " + (value!=null?value.getText():null); 

                    a.setName((name!=null?name.getText():null));
                    a.setValue((value!=null?value.getText():null));
                  

            match(input, Token.UP, null); 

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


    // $ANTLR start "sliceList"
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:210:1: sliceList[List<Integer> slices] : ^( ( ',' | ':' ) '[' start= INT (end= INT | (next= INT )* ) ']' ) ;
    public final void sliceList(List<Integer> slices) throws RecognitionException {
        CommonTree start=null;
        CommonTree end=null;
        CommonTree next=null;

        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:211:3: ( ^( ( ',' | ':' ) '[' start= INT (end= INT | (next= INT )* ) ']' ) )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:211:4: ^( ( ',' | ':' ) '[' start= INT (end= INT | (next= INT )* ) ']' )
            {
            if ( (input.LA(1)>=COLON && input.LA(1)<=COMMA) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input, Token.DOWN, null); 
            match(input,LBRACKET,FOLLOW_LBRACKET_in_sliceList534); 
            start=(CommonTree)match(input,INT,FOLLOW_INT_in_sliceList542); 
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:214:3: (end= INT | (next= INT )* )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==INT) ) {
                alt7=1;
            }
            else if ( (LA7_0==RBRACKET) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:215:5: end= INT
                    {
                    end=(CommonTree)match(input,INT,FOLLOW_INT_in_sliceList556); 

                          if (start <= end) {
                            for (int i = start; i <= end; i++) {
                              slices.add(i);
                            }
                          }
                          else {
                            for (int i = start; i >= end; i--) {
                               slices.add(i);
                            }
                          }
                        
                     code += "[" + start + ":" + end + "]"; 

                    }
                    break;
                case 2 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:230:5: (next= INT )*
                    {
                     code += "[" + start; 
                    slices.add(Integer.parseInt((start!=null?start.getText():null)));
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:233:7: (next= INT )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==INT) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:234:7: next= INT
                    	    {
                    	    next=(CommonTree)match(input,INT,FOLLOW_INT_in_sliceList606); 
                    	     code += "," + (next!=null?next.getText():null); 
                    	    slices.add(Integer.parseInt((next!=null?next.getText():null)));

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                     code += "]"; 

                    }
                    break;

            }

            match(input,RBRACKET,FOLLOW_RBRACKET_in_sliceList643); 

            match(input, Token.UP, null); 

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
    // $ANTLR end "sliceList"


    // $ANTLR start "pinDecl"
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:244:1: pinDecl[DeviceNode d] : ^( 'pin' addPinDecl[d] ) ;
    public final void pinDecl(DeviceNode d) throws RecognitionException {
        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:249:2: ( ^( 'pin' addPinDecl[d] ) )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:249:4: ^( 'pin' addPinDecl[d] )
            {
            match(input,25,FOLLOW_25_in_pinDecl664); 

            code += "\t\tPIN";
            PinNode pin = new PinNode(d);

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_addPinDecl_in_pinDecl669);
            addPinDecl(d);

            state._fsp--;


            match(input, Token.UP, null); 

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
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:258:1: addPinDecl[DeviceNode d] : ( sliceList[slices] )? name= IDENT ( pinList[pList] )? ;
    public final void addPinDecl(DeviceNode d) throws RecognitionException {
        CommonTree name=null;

        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:262:2: ( ( sliceList[slices] )? name= IDENT ( pinList[pList] )? )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:262:5: ( sliceList[slices] )? name= IDENT ( pinList[pList] )?
            {
             List<Integer> slices = new ArrayList<Integer>(); 
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:264:6: ( sliceList[slices] )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=COLON && LA8_0<=COMMA)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:264:6: sliceList[slices]
                    {
                    pushFollow(FOLLOW_sliceList_in_addPinDecl706);
                    sliceList(slices);

                    state._fsp--;


                    }
                    break;

            }

            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_addPinDecl717); 
             code += (name!=null?name.getText():null) + "[" + (name!=null?name.getLine():0) + ":" + (name!=null?name.getCharPositionInLine():0) + "]"; 
             List<String> pList = new ArrayList<String>(); 
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:270:6: ( pinList[pList] )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==33) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:270:6: pinList[pList]
                    {
                    pushFollow(FOLLOW_pinList_in_addPinDecl750);
                    pinList(pList);

                    state._fsp--;


                    }
                    break;

            }

               if (slices.size() != pList.size()) {
                      System.err.println((name!=null?name.getText():null) + " " + (name!=null?name.getLine():0) + ":" + (name!=null?name.getCharPositionInLine():0) +
                                          " - invalid pin mapping; size of bit vector: "
                                          + slices.size() + ", size of pin list: "
                                          + pList.size());
                      System.exit(1);
                    }
                    List<PinNode> pins = new ArrayList<PinNode>();
                    for (Integer i : slices) {
                      PinNode newPin = new PinNode(d);
                      newPin.setName((name!=null?name.getText():null) + "[" + i + "]");
                      newPin.setLine((name!=null?name.getLine():0));
                      newPin.setPos((name!=null?name.getCharPositionInLine():0));
                      newPin.setFileName(input.getSourceName());
                      newPin.setPinName(pList.get(i));
                      if (!d.addPinNode(newPin)) {
                        System.err.println(newPin.getName() + " " + newPin.getLine() + ":" + newPin.getPosition()
                                            + " - duplicate pin declaration");
                        System.exit(1);
                      }
                    }
                  

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


    // $ANTLR start "pinList"
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:296:1: pinList[List<String> pList] : ^( '{' value= IDENT ( ',' next= IDENT )* '}' ) ;
    public final void pinList(List<String> pList) throws RecognitionException {
        CommonTree value=null;
        CommonTree next=null;

        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:297:3: ( ^( '{' value= IDENT ( ',' next= IDENT )* '}' ) )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:298:5: ^( '{' value= IDENT ( ',' next= IDENT )* '}' )
            {
            match(input,33,FOLLOW_33_in_pinList789); 

            match(input, Token.DOWN, null); 
            value=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinList801); 
             code += " = \"" + (value!=null?value.getText():null); 
             pList.add((value!=null?value.getText():null)); 
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:303:6: ( ',' next= IDENT )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==COMMA) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:303:7: ',' next= IDENT
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_pinList825); 
            	    next=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinList838); 
            	     pList.add((next!=null?next.getText():null)); 
            	     code += ", " + (next!=null?next.getText():null); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            match(input,34,FOLLOW_34_in_pinList872); 
             code += "\"";

            match(input, Token.UP, null); 

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
    // $ANTLR end "pinList"


    // $ANTLR start "instDecl"
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:313:1: instDecl[DesignNode d] : ^( 'inst' name= IDENT refName= IDENT ( arrayList[indices] )? ( attrAssign[n, indices] | pinAssign[n, indices] )* ) ;
    public final void instDecl(DesignNode d) throws RecognitionException {
        CommonTree name=null;
        CommonTree refName=null;

        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:317:2: ( ^( 'inst' name= IDENT refName= IDENT ( arrayList[indices] )? ( attrAssign[n, indices] | pinAssign[n, indices] )* ) )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:317:4: ^( 'inst' name= IDENT refName= IDENT ( arrayList[indices] )? ( attrAssign[n, indices] | pinAssign[n, indices] )* )
            {
            match(input,27,FOLLOW_27_in_instDecl904); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl908); 
            refName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl912); 
             List<Integer> indices = new ArrayList<Integer>(); 
             code += "\tINSTANCE " + (name!=null?name.getText():null) + "[" + (name!=null?name.getLine():0) + ":" + (name!=null?name.getCharPositionInLine():0) + "]"; 
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:322:5: ( arrayList[indices] )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=COLON && LA11_0<=COMMA)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:322:5: arrayList[indices]
                    {
                    pushFollow(FOLLOW_arrayList_in_instDecl938);
                    arrayList(indices);

                    state._fsp--;


                    }
                    break;

            }

            	
            		  for (Integer i : indices) {
            		    InstanceNode n = new InstanceNode(d);
            		    n.setName((name!=null?name.getText():null) + "(" + i + ")");
            		    n.setLine((name!=null?name.getLine():0));
            		    n.setPosition((name!=null?name.getCharPositionInLine():0));
            		    for (DeviceNode dn : d.getDevices()) {
            		      if (dn.getName().equals((name!=null?name.getText():null))) {
            		        n.setDevice(dn);
            		        for (PinNode p : dn.getPins()) {
            		          PinNode newP = new PinNode(n);
            		          newP.setName(p.getName());
            		          n.addPin(newP);
            		        }
            		        for (AttributeNode a : dn.getAttribute()) {
            		          AttributeNode newA = new AttributeNode(n);
            		          newA.setName(a.getName());
            		          n.addAttribute(newA);
            		        }
            		        break;
            		      }
            		    }
            		  }
            		
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:348:5: ( attrAssign[n, indices] | pinAssign[n, indices] )*
            loop12:
            do {
                int alt12=3;
                alt12 = dfa12.predict(input);
                switch (alt12) {
            	case 1 :
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:348:7: attrAssign[n, indices]
            	    {
            	    pushFollow(FOLLOW_attrAssign_in_instDecl957);
            	    attrAssign(n, indices);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:348:32: pinAssign[n, indices]
            	    {
            	    pushFollow(FOLLOW_pinAssign_in_instDecl962);
            	    pinAssign(n, indices);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            match(input, Token.UP, null); 
            	if(!d.addInstance(n)) {
            		    System.err.println(i.getName() + " " + i.getLine() + ":" + i.getPosition()
                                            + " - duplicate instance declaration");
                    System.exit(1);
            			}
            		

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


    // $ANTLR start "arrayList"
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:360:1: arrayList[List<Integer> indices] : ^( ( ':' | ',' ) '(' (first= INT last= INT | first= INT (next= INT )* ) ')' ) ;
    public final void arrayList(List<Integer> indices) throws RecognitionException {
        CommonTree first=null;
        CommonTree last=null;
        CommonTree next=null;

        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:361:3: ( ^( ( ':' | ',' ) '(' (first= INT last= INT | first= INT (next= INT )* ) ')' ) )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:361:5: ^( ( ':' | ',' ) '(' (first= INT last= INT | first= INT (next= INT )* ) ')' )
            {
            if ( (input.LA(1)>=COLON && input.LA(1)<=COMMA) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input, Token.DOWN, null); 
            match(input,35,FOLLOW_35_in_arrayList1006); 
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:363:7: (first= INT last= INT | first= INT (next= INT )* )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==INT) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==INT) ) {
                    alt14=1;
                }
                else if ( (LA14_1==36) ) {
                    alt14=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:364:9: first= INT last= INT
                    {
                    first=(CommonTree)match(input,INT,FOLLOW_INT_in_arrayList1028); 
                    last=(CommonTree)match(input,INT,FOLLOW_INT_in_arrayList1034); 
                     code += "[" + (first!=null?first.getText():null) + ":" + (last!=null?last.getText():null) + "]"; 

                    		        int start = Integer.parseInt((first!=null?first.getText():null));
                    		        int end = Integer.parseInt((last!=null?last.getText():null));
                    		        if (start < end) {
                    		          for (int i = start; i <= end; i++) {
                    		            indices.add(i);
                    		          }
                    		        }
                    		        else {
                    		          for (int i = start; i >= end; i--) {
                    		             indices.add(i);
                    		          }
                    		        }
                    		      

                    }
                    break;
                case 2 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:380:9: first= INT (next= INT )*
                    {
                    first=(CommonTree)match(input,INT,FOLLOW_INT_in_arrayList1068); 
                     code += "[" + (first!=null?first.getText():null); 
                     indices.add(Integer.parseInt((first!=null?first.getText():null))); 
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:383:9: (next= INT )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==INT) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:384:11: next= INT
                    	    {
                    	    next=(CommonTree)match(input,INT,FOLLOW_INT_in_arrayList1114); 
                    	     code += "," + (next!=null?next.getText():null); 
                    	     indices.add(Integer.parseInt((next!=null?next.getText():null))); 

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                     code += "]"; 

                    }
                    break;

            }

            match(input,36,FOLLOW_36_in_arrayList1173); 

            match(input, Token.UP, null); 

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
    // $ANTLR end "arrayList"


    // $ANTLR start "attrAssign"
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:394:1: attrAssign[InstNode i, List<Integer> instIndices] : ^( '=' ( 'new' )? ( instanceQualifier[i.getName(), indices, instIndices] )? name= IDENT value= STRING_LITERAL ) ;
    public final void attrAssign(InstNode i, List<Integer> instIndices) throws RecognitionException {
        CommonTree name=null;
        CommonTree value=null;

        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:400:2: ( ^( '=' ( 'new' )? ( instanceQualifier[i.getName(), indices, instIndices] )? name= IDENT value= STRING_LITERAL ) )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:401:4: ^( '=' ( 'new' )? ( instanceQualifier[i.getName(), indices, instIndices] )? name= IDENT value= STRING_LITERAL )
            {
            match(input,38,FOLLOW_38_in_attrAssign1199); 

             AttributeNode a; 

            match(input, Token.DOWN, null); 
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:403:6: ( 'new' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==28) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:403:7: 'new'
                    {
                    match(input,28,FOLLOW_28_in_attrAssign1213); 
                     a = new AttributeNode(i);
                            	List<Integer> indices = new ArrayList<Integer>();	     
                    	    

                    }
                    break;

            }

            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:407:8: ( instanceQualifier[i.getName(), indices, instIndices] )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==PERIOD) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:407:8: instanceQualifier[i.getName(), indices, instIndices]
                    {
                    pushFollow(FOLLOW_instanceQualifier_in_attrAssign1231);
                    instanceQualifier(i.getName(), indices, instIndices);

                    state._fsp--;


                    }
                    break;

            }

            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attrAssign1239); 
            value=(CommonTree)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_attrAssign1245); 

            match(input, Token.UP, null); 
            	  		  
            	   if (a == null) {
            	     for (Integer index : indices) {
            	       if (!instIndices.contains(index)) {
            	         System.err.println((name!=null?name.getText():null) + " " + (name!=null?name.getLine():0) + ":" + name.getPosition()
            	                               + " - index out of bounds, " + index);
                       System.exit(1);
            	       }
            	       for (AttributeNode n : i.getAttributes()) {
            	         if (n.getName().equals((name!=null?name.getText():null) + "(" + index + ")") {
            	           n.setValue((value!=null?value.getText():null));
            	           break;
            	         }
            	       }
            	     }
            	   }
            	   else {
            	     for (Integer index : indices) {
            	       a = new AttributeNode(i);
            		     a.setName((name!=null?name.getText():null) + "(" + index + ")");
            		     a.setValue((value!=null?value.getText():null));
            		     if (!i.addAttribute(a)) {
            		       System.err.println(a.getName() + " " + a.getLine() + ":" + a.getPosition()
            	                                + " - duplicate attribute declaration");
            	         System.exit(1);
            		     }
            		   }
            	   }
            	 

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


    // $ANTLR start "instanceQualifier"
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:440:1: instanceQualifier[String refName, List<Integer> indices, List<Integer> instIndices] : ^( '.' (name= IDENT | name= IDENT arrayList[indices] ) ) ;
    public final void instanceQualifier(String refName, List<Integer> indices, List<Integer> instIndices) throws RecognitionException {
        CommonTree name=null;

        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:441:3: ( ^( '.' (name= IDENT | name= IDENT arrayList[indices] ) ) )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:443:5: ^( '.' (name= IDENT | name= IDENT arrayList[indices] ) )
            {
            match(input,PERIOD,FOLLOW_PERIOD_in_instanceQualifier1283); 

            match(input, Token.DOWN, null); 
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:444:5: (name= IDENT | name= IDENT arrayList[indices] )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==IDENT) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==UP) ) {
                    alt17=1;
                }
                else if ( ((LA17_1>=COLON && LA17_1<=COMMA)) ) {
                    alt17=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:444:7: name= IDENT
                    {
                    name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instanceQualifier1295); 
                     indices.addAll(instIndices); 

                    }
                    break;
                case 2 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:445:7: name= IDENT arrayList[indices]
                    {
                    name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instanceQualifier1309); 
                    pushFollow(FOLLOW_arrayList_in_instanceQualifier1311);
                    arrayList(indices);

                    state._fsp--;


                    }
                    break;

            }


            match(input, Token.UP, null); 

                  if (!refName.equals((name!=null?name.getText():null))) {
                    System.err.println((name!=null?name.getText():null) + " " + (name!=null?name.getLine():0) + ":" + (name!=null?name.getCharPositionInLine():0)
                                            + " - invalid instance reference");
                    System.exit(1);
                  }
                

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
    // $ANTLR end "instanceQualifier"


    // $ANTLR start "pinAssign"
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:457:1: pinAssign[InstNode i, List<Integer> instIndices] : ^( '=' ( instanceQualifier[i.getName(), indices, instIndices] )? name= IDENT ( sliceList[slices] )? ( concatPin[p] )* ) ;
    public final void pinAssign(InstNode i, List<Integer> instIndices) throws RecognitionException {
        CommonTree name=null;

        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:461:2: ( ^( '=' ( instanceQualifier[i.getName(), indices, instIndices] )? name= IDENT ( sliceList[slices] )? ( concatPin[p] )* ) )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:462:4: ^( '=' ( instanceQualifier[i.getName(), indices, instIndices] )? name= IDENT ( sliceList[slices] )? ( concatPin[p] )* )
            {
            match(input,38,FOLLOW_38_in_pinAssign1347); 

             List<Integer> indices = new ArrayList<Integer>(); 

            match(input, Token.DOWN, null); 
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:464:4: ( instanceQualifier[i.getName(), indices, instIndices] )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==PERIOD) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:464:4: instanceQualifier[i.getName(), indices, instIndices]
                    {
                    pushFollow(FOLLOW_instanceQualifier_in_pinAssign1357);
                    instanceQualifier(i.getName(), indices, instIndices);

                    state._fsp--;


                    }
                    break;

            }

            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinAssign1368); 
             List<Integer> slices = new ArrayList<Integer>(); 
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:467:4: ( sliceList[slices] )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=COLON && LA19_0<=COMMA)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:467:4: sliceList[slices]
                    {
                    pushFollow(FOLLOW_sliceList_in_pinAssign1378);
                    sliceList(slices);

                    state._fsp--;


                    }
                    break;

            }


            	   for (Integer index : indices) {
            	     
            	     for (Integer slice : slices) {
            	       
            	     }
            	   }
            	  
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:478:3: ( concatPin[p] )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==IDENT) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:478:3: concatPin[p]
            	    {
            	    pushFollow(FOLLOW_concatPin_in_pinAssign1397);
            	    concatPin(p);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
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
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:486:1: concatPin[PinAssign pa] : (name= IDENT (slice= SLICE_LIST )? ) ;
    public final void concatPin(PinAssign pa) throws RecognitionException {
        CommonTree name=null;
        CommonTree slice=null;

        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:490:2: ( (name= IDENT (slice= SLICE_LIST )? ) )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:490:4: (name= IDENT (slice= SLICE_LIST )? )
            {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:490:4: (name= IDENT (slice= SLICE_LIST )? )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:490:5: name= IDENT (slice= SLICE_LIST )?
            {
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatPin1426); 
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:490:16: (slice= SLICE_LIST )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==SLICE_LIST) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:490:17: slice= SLICE_LIST
                    {
                    slice=(CommonTree)match(input,SLICE_LIST,FOLLOW_SLICE_LIST_in_concatPin1431); 

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
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:505:1: netAssign[DesignDecl d] : ^( EQUALS name= IDENT (slice= SLICE_LIST )? ( concatNet[n] )* ) ;
    public final void netAssign(DesignDecl d) throws RecognitionException {
        CommonTree name=null;
        CommonTree slice=null;

        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:509:2: ( ^( EQUALS name= IDENT (slice= SLICE_LIST )? ( concatNet[n] )* ) )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:509:4: ^( EQUALS name= IDENT (slice= SLICE_LIST )? ( concatNet[n] )* )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_netAssign1454); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netAssign1458); 
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:509:24: (slice= SLICE_LIST )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==SLICE_LIST) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:509:25: slice= SLICE_LIST
                    {
                    slice=(CommonTree)match(input,SLICE_LIST,FOLLOW_SLICE_LIST_in_netAssign1463); 

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
            		
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:523:3: ( concatNet[n] )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==IDENT) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:523:3: concatNet[n]
            	    {
            	    pushFollow(FOLLOW_concatNet_in_netAssign1482);
            	    concatNet(n);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
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
    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:530:1: concatNet[NetAssign na] : (name= IDENT (slice= SLICE_LIST )? ) ;
    public final void concatNet(NetAssign na) throws RecognitionException {
        CommonTree name=null;
        CommonTree slice=null;

        try {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:534:2: ( (name= IDENT (slice= SLICE_LIST )? ) )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:534:4: (name= IDENT (slice= SLICE_LIST )? )
            {
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:534:4: (name= IDENT (slice= SLICE_LIST )? )
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:534:5: name= IDENT (slice= SLICE_LIST )?
            {
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatNet1510); 
            // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:534:16: (slice= SLICE_LIST )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==SLICE_LIST) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // /Users/nelson/Documents/workspace/phdl/src/phdl/grammar/PhdlWalker.g:534:17: slice= SLICE_LIST
                    {
                    slice=(CommonTree)match(input,SLICE_LIST,FOLLOW_SLICE_LIST_in_concatNet1515); 

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


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\23\uffff";
    static final String DFA12_eofS =
        "\23\uffff";
    static final String DFA12_minS =
        "\1\3\1\uffff\1\2\1\4\1\uffff\1\2\1\3\1\4\1\uffff\1\3\1\4\1\2\1\43"+
        "\3\10\1\3\1\10\1\3";
    static final String DFA12_maxS =
        "\1\46\1\uffff\1\2\1\34\1\uffff\1\2\1\14\1\4\1\uffff\1\14\1\4\1\2"+
        "\1\43\1\10\2\44\1\3\1\44\1\3";
    static final String DFA12_acceptS =
        "\1\uffff\1\3\2\uffff\1\1\3\uffff\1\2\12\uffff";
    static final String DFA12_specialS =
        "\23\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\1\42\uffff\1\2",
            "",
            "\1\3",
            "\1\6\10\uffff\1\5\16\uffff\1\4",
            "",
            "\1\7",
            "\2\10\2\uffff\1\4\3\uffff\2\10",
            "\1\11",
            "",
            "\1\12\7\uffff\2\13",
            "\1\6",
            "\1\14",
            "\1\15",
            "\1\16",
            "\1\17\33\uffff\1\20",
            "\1\21\33\uffff\1\20",
            "\1\22",
            "\1\21\33\uffff\1\20",
            "\1\12"
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "()* loopback of 348:5: ( attrAssign[n, indices] | pinAssign[n, indices] )*";
        }
    }
 

    public static final BitSet FOLLOW_design_in_sourceText69 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_sourceText78 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_design94 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_design98 = new BitSet(new long[]{0x0000000004A00000L});
    public static final BitSet FOLLOW_deviceDecl_in_design130 = new BitSet(new long[]{0x0000000004A00000L});
    public static final BitSet FOLLOW_netDecl_in_design135 = new BitSet(new long[]{0x0000000004A00000L});
    public static final BitSet FOLLOW_21_in_design148 = new BitSet(new long[]{0x0000000008000048L});
    public static final BitSet FOLLOW_instDecl_in_design159 = new BitSet(new long[]{0x0000000008000048L});
    public static final BitSet FOLLOW_netAssign_in_design164 = new BitSet(new long[]{0x0000000008000048L});
    public static final BitSet FOLLOW_23_in_deviceDecl187 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl191 = new BitSet(new long[]{0x0000000003000008L});
    public static final BitSet FOLLOW_attributeDecl_in_deviceDecl257 = new BitSet(new long[]{0x0000000003000008L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl306 = new BitSet(new long[]{0x0000000003000008L});
    public static final BitSet FOLLOW_26_in_netDecl361 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_sliceList_in_netDecl379 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl389 = new BitSet(new long[]{0x0000000001000008L});
    public static final BitSet FOLLOW_attributeDecl_in_netDecl413 = new BitSet(new long[]{0x0000000001000008L});
    public static final BitSet FOLLOW_24_in_attributeDecl462 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_attributeDecl474 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_attributeDecl486 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_sliceList524 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_sliceList534 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_INT_in_sliceList542 = new BitSet(new long[]{0x0000000000008100L});
    public static final BitSet FOLLOW_INT_in_sliceList556 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INT_in_sliceList606 = new BitSet(new long[]{0x0000000000008100L});
    public static final BitSet FOLLOW_RBRACKET_in_sliceList643 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_25_in_pinDecl664 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_addPinDecl_in_pinDecl669 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_sliceList_in_addPinDecl706 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_addPinDecl717 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_pinList_in_addPinDecl750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_pinList789 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_pinList801 = new BitSet(new long[]{0x0000000400001000L});
    public static final BitSet FOLLOW_COMMA_in_pinList825 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinList838 = new BitSet(new long[]{0x0000000400001000L});
    public static final BitSet FOLLOW_34_in_pinList872 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_27_in_instDecl904 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_instDecl908 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instDecl912 = new BitSet(new long[]{0x0000004000001808L});
    public static final BitSet FOLLOW_arrayList_in_instDecl938 = new BitSet(new long[]{0x0000004000000008L});
    public static final BitSet FOLLOW_attrAssign_in_instDecl957 = new BitSet(new long[]{0x0000004000000008L});
    public static final BitSet FOLLOW_pinAssign_in_instDecl962 = new BitSet(new long[]{0x0000004000000008L});
    public static final BitSet FOLLOW_set_in_arrayList994 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_35_in_arrayList1006 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_INT_in_arrayList1028 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_INT_in_arrayList1034 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_INT_in_arrayList1068 = new BitSet(new long[]{0x0000001000000100L});
    public static final BitSet FOLLOW_INT_in_arrayList1114 = new BitSet(new long[]{0x0000001000000100L});
    public static final BitSet FOLLOW_36_in_arrayList1173 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_38_in_attrAssign1199 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_28_in_attrAssign1213 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_instanceQualifier_in_attrAssign1231 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attrAssign1239 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_attrAssign1245 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERIOD_in_instanceQualifier1283 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_instanceQualifier1295 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENT_in_instanceQualifier1309 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_arrayList_in_instanceQualifier1311 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_38_in_pinAssign1347 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_instanceQualifier_in_pinAssign1357 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinAssign1368 = new BitSet(new long[]{0x0000000000001818L});
    public static final BitSet FOLLOW_sliceList_in_pinAssign1378 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_concatPin_in_pinAssign1397 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_IDENT_in_concatPin1426 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_SLICE_LIST_in_concatPin1431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUALS_in_netAssign1454 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_netAssign1458 = new BitSet(new long[]{0x0000002000000018L});
    public static final BitSet FOLLOW_SLICE_LIST_in_netAssign1463 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_concatNet_in_netAssign1482 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_IDENT_in_concatNet1510 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_SLICE_LIST_in_concatNet1515 = new BitSet(new long[]{0x0000000000000002L});

}