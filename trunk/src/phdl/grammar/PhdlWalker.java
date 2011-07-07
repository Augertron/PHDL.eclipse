// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g 2011-07-07 16:46:13

	package phdl.grammar;
	import phdl.PhdlComp;
	import java.util.TreeSet;
	import java.util.Set;
	import java.util.HashSet;
	import java.util.SortedSet;
	import java.util.List;
	import java.util.ArrayList;
	import phdl.graph.*;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/**
 * A tree grammar that walks the AST produced by PhdlParser.  It operates on a stream of 
 * tree nodes of the form (parent child1 child2 ... childN) where each node may be the
 * root of another subtree.  Call the sourceText()rule on the walker object to generate
 * a set of design nodes.  Retrieve the design nodes and any compilation errors and warnings 
 * by calling getDesignNodes(), getErrors() and getWarnings() respectively.  Optionally,
 * before calling the sourceText() rule, pass in a set of required attributes with the 
 * setRequiredAttributes(String[]) method.
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 */
public class PhdlWalker extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "SEMICOLON", "EQUALS", "STRING_LITERAL", "COLON", "PERIOD", "AMPERSAND", "LANGLE", "RANGLE", "LBRACE", "PIN", "INTEGER", "COMMA", "RBRACE", "LBRACKET", "RBRACKET", "LPAREN", "RPAREN", "CHAR", "DIGIT", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "'design'", "'is'", "'begin'", "'end'", "'device'", "'attr'", "'pin'", "'net'", "'inst'", "'newattr'", "'open'"
    };
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
    public static final int IDENT=4;
    public static final int SEMICOLON=5;
    public static final int EQUALS=6;
    public static final int STRING_LITERAL=7;
    public static final int COLON=8;
    public static final int PERIOD=9;
    public static final int AMPERSAND=10;
    public static final int LANGLE=11;
    public static final int RANGLE=12;
    public static final int LBRACE=13;
    public static final int PIN=14;
    public static final int INTEGER=15;
    public static final int COMMA=16;
    public static final int RBRACE=17;
    public static final int LBRACKET=18;
    public static final int RBRACKET=19;
    public static final int LPAREN=20;
    public static final int RPAREN=21;
    public static final int CHAR=22;
    public static final int DIGIT=23;
    public static final int WHITESPACE=24;
    public static final int LINE_COMMENT=25;
    public static final int MULTILINE_COMMENT=26;

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



    	/**
    	 * The set of required attributes
    	 */
    	private Set<String> reqAttrs = new HashSet<String>();
    	/**
    	 * The sorted set of errors
    	 */
    	private SortedSet<String> errors = new TreeSet<String>();
    	/**
    	 * The set of processed design nodes
    	 */
    	private Set<DesignNode> designNodes = new HashSet<DesignNode>();
    	
    	/**
    	 * Sets to check for duplicates whild processing everything
    	 */
    	private Set<String> attrDecls = new HashSet<String>();
    	private Set<String> pinDecls = new HashSet<String>();
    	private Set<String> netDecls = new HashSet<String>();
    	private Set<String> instanceDecls = new HashSet<String>();
    	private Set<String> attrAssigns = new HashSet<String>();
    	private Set<String> pinAssigns = new HashSet<String>();
    	
    	/**
    	 * Called to obtain the errors if any exist after walking and processing the tree
    	 */
    	public SortedSet<String> getErrors() {
    		return errors;
    	}
    	
    	/**
    	 * Used from within the walker to add an error found while processing the tree
    	 */
    	private void addError(Node n, String message) {
    		errors.add(n.getFileName() + " line " + n.getLine() + ":" 
    				+ n.getPosition() + " " + message + ": " + n.getName());
    	}
    	
    	/**
    	 * Called to obtain the set of design nodes after the walker has finished processing the tree
    	 */
    	public Set<DesignNode> getDesignNodes() {
    		return designNodes;
    	}
    	
    	/**
    	 * Called on the walker object to pass in a set of required attributes
    	 */
    	public void setRequiredAttributes(String[] attributes) {
    		for(int i = 0; i < attributes.length; i ++) {
    			reqAttrs.add(attributes[i]);
    		}
    	}
    	
    	/**
    	 * Necessary to properly report AST errors without bailing out of the whole application
    	 */
    	@Override
        public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:126:1: sourceText : ( designDecl )* ;
    public final void sourceText() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:133:2: ( ( designDecl )* )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:133:4: ( designDecl )*
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:133:4: ( designDecl )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==27) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:133:4: designDecl
            	    {
            	    pushFollow(FOLLOW_designDecl_in_sourceText61);
            	    designDecl();

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
        return ;
    }
    // $ANTLR end "sourceText"


    // $ANTLR start "designDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:136:1: designDecl : ^( 'design' name= IDENT ( deviceDecl[des] | netDecl[des] )* 'begin' ( instDecl[des] )* ) ;
    public final void designDecl() throws RecognitionException {
        CommonTree name=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:149:2: ( ^( 'design' name= IDENT ( deviceDecl[des] | netDecl[des] )* 'begin' ( instDecl[des] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:149:4: ^( 'design' name= IDENT ( deviceDecl[des] | netDecl[des] )* 'begin' ( instDecl[des] )* )
            {
            match(input,27,FOLLOW_27_in_designDecl76); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_designDecl80); 
            	// make a new design based on the identifier and log its location
            				DesignNode des = new DesignNode();
            				des.setName((name!=null?name.getText():null));
            				des.setLocation((name!=null?name.getLine():0), (name!=null?name.getCharPositionInLine():0), input.getSourceName());
            				
            				// clear these sets each time a design is processed
            				netDecls.clear();
            				instanceDecls.clear();
            			
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:163:3: ( deviceDecl[des] | netDecl[des] )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==31) ) {
                    alt2=1;
                }
                else if ( (LA2_0==34) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:163:4: deviceDecl[des]
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_designDecl104);
            	    deviceDecl(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:163:22: netDecl[des]
            	    {
            	    pushFollow(FOLLOW_netDecl_in_designDecl109);
            	    netDecl(des);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match(input,29,FOLLOW_29_in_designDecl114); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:163:45: ( instDecl[des] )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==35) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:163:46: instDecl[des]
            	    {
            	    pushFollow(FOLLOW_instDecl_in_designDecl117);
            	    instDecl(des);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            match(input, Token.UP, null); 
            	// add the design node and report if there are duplicates
            				if(!designNodes.add(des))
            					addError(des, "duplicate design unit");
            			

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
    // $ANTLR end "designDecl"


    // $ANTLR start "deviceDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:173:1: deviceDecl[DesignNode des] : ^( 'device' name= IDENT ( attributeDecl[dev] | pinDecl[dev] )* ) ;
    public final void deviceDecl(DesignNode des) throws RecognitionException {
        CommonTree name=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:185:2: ( ^( 'device' name= IDENT ( attributeDecl[dev] | pinDecl[dev] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:185:4: ^( 'device' name= IDENT ( attributeDecl[dev] | pinDecl[dev] )* )
            {
            match(input,31,FOLLOW_31_in_deviceDecl153); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl157); 
            	// make a new device based on the identifier and log its location
            				DeviceNode dev = new DeviceNode(des);
            				dev.setName((name!=null?name.getText():null));
            				dev.setLocation((name!=null?name.getLine():0), (name!=null?name.getCharPositionInLine():0), input.getSourceName());
            				
            				// clear these sets each time a device is processed
            				attrDecls.clear();
            				pinDecls.clear();
            			
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:199:3: ( attributeDecl[dev] | pinDecl[dev] )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==32) ) {
                    alt4=1;
                }
                else if ( (LA4_0==33) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:199:4: attributeDecl[dev]
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_deviceDecl184);
            	    attributeDecl(dev);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:199:25: pinDecl[dev]
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl189);
            	    pinDecl(dev);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            match(input, Token.UP, null); 
            	// report any missing required attributes
            				for(String s : reqAttrs) {
            					s = s.toUpperCase();
            					if(dev.getAttribute(s)==null)
            						errors.add(input.getSourceName() + " line " + (name!=null?name.getLine():0) + ":" 
            							+ (name!=null?name.getCharPositionInLine():0) + " required attribute \"" + s + "\" missing in device: " + (name!=null?name.getText():null));
            				}
            				
            				// attempt to add the device declaration and report duplicates
            				if(!des.addDevice(dev))
            					addError(dev, "Duplicate device declaration");
            			

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


    // $ANTLR start "attributeDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:217:1: attributeDecl[Attributable dev] : ^( 'attr' name= IDENT value= STRING_LITERAL ) ;
    public final void attributeDecl(Attributable dev) throws RecognitionException {
        CommonTree name=null;
        CommonTree value=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:228:2: ( ^( 'attr' name= IDENT value= STRING_LITERAL ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:228:4: ^( 'attr' name= IDENT value= STRING_LITERAL )
            {
            match(input,32,FOLLOW_32_in_attributeDecl224); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attributeDecl228); 
            value=(CommonTree)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_attributeDecl232); 

            match(input, Token.UP, null); 
            	// make a new attribute node, assign its parent, and log its location
            	    		AttributeNode a  = new AttributeNode(dev);
            	    		a.setName((name!=null?name.getText():null));
            				a.setValue((value!=null?value.getText():null));
            	    		a.setLocation((name!=null?name.getLine():0), (name!=null?name.getCharPositionInLine():0), input.getSourceName());
            				dev.addAttribute(a);
            				
            				// report any duplicate attribute declarations
            				if(!attrDecls.add((name!=null?name.getText():null).toUpperCase()))
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:245:1: pinDecl[DeviceNode dev] : ^( 'pin' name= IDENT ( sliceList[sList] )? pinList[pList] ) ;
    public final void pinDecl(DeviceNode dev) throws RecognitionException {
        CommonTree name=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:263:2: ( ^( 'pin' name= IDENT ( sliceList[sList] )? pinList[pList] ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:263:4: ^( 'pin' name= IDENT ( sliceList[sList] )? pinList[pList] )
            {
            match(input,33,FOLLOW_33_in_pinDecl269); 

             	// sets to keep track of the slice and pin lists
            				List<Integer> sList = new ArrayList<Integer>(); 
            				List<String> pList = new ArrayList<String>();
            			

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinDecl294); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:272:14: ( sliceList[sList] )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==COLON||LA5_0==COMMA) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:272:14: sliceList[sList]
                    {
                    pushFollow(FOLLOW_sliceList_in_pinDecl296);
                    sliceList(sList);

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_pinList_in_pinDecl300);
            pinList(pList);

            state._fsp--;


            match(input, Token.UP, null); 
            	// list sizes should only differ if there is no slice list, and the pin list has a size of 1
            				if (sList.size() != pList.size()) {
            					if (sList.size() == 0 && pList.size() != 1)
            						errors.add(input.getSourceName() + " line " + (name!=null?name.getLine():0) + ":" 
            							+ (name!=null?name.getCharPositionInLine():0) + " invalid pin list: " + (name!=null?name.getText():null));				
            					if (sList.size() != 0)
            						errors.add(input.getSourceName() + " line " + (name!=null?name.getLine():0) + ":" 
            							+ (name!=null?name.getCharPositionInLine():0) + " invalid pin list: " + (name!=null?name.getText():null));
            				}
            				
            				// make new pin nodes for all slices by appending the slice reference in brackets to the name
            	        	for (int i = 0; i < sList.size(); i++) {
            	        		PinNode newPin = new PinNode(dev);
            	        		newPin.setName((name!=null?name.getText():null) + "[" + sList.get(i) + "]");
            					newPin.setLocation((name!=null?name.getLine():0), (name!=null?name.getCharPositionInLine():0), input.getSourceName());
            	        		
            	        		// accessing an invalid pin list may cause an exception
            	        		try{
            						newPin.setPinName(pList.get(i));
            					} catch (IndexOutOfBoundsException e) {
            						errors.add(input.getSourceName() + " line " + (name!=null?name.getLine():0) + ":" 
            							+ (name!=null?name.getCharPositionInLine():0) + " invalid pin list: " + (name!=null?name.getText():null));
            					}
            					
            					// report any duplicate pin declarations
            					if (!dev.addPin(newPin))
            	            		addError(newPin, "duplicate pin declaration");
            				}
            				
            				// otherwise make a new pin node directly from the name
            				if (sList.isEmpty()) {
            					PinNode newPin = new PinNode(dev);
            					newPin.setName((name!=null?name.getText():null));
            					newPin.setLocation((name!=null?name.getLine():0), (name!=null?name.getCharPositionInLine():0), input.getSourceName());
            					
            					// accessing an invalid pin list may cause an exception
            					try{
            						newPin.setPinName(pList.get(0));
            					} catch (IndexOutOfBoundsException e) {
            						errors.add(input.getSourceName() + " line " + (name!=null?name.getLine():0) + ":" 
            							+ (name!=null?name.getCharPositionInLine():0) + " invalid pin list: " + (name!=null?name.getText():null));
            					}
            					
            					// report any duplicate pin declarations
            					if (!dev.addPin(newPin))
            	            		addError(newPin, "duplicate pin declaration");
            				}
            				
            				// check for overall duplicates based solely on the name
            				if (!pinDecls.add((name!=null?name.getText():null)))
            					errors.add(input.getSourceName() + " line " + (name!=null?name.getLine():0) + ":" 
            							+ (name!=null?name.getCharPositionInLine():0) + " duplicate pin declaration: " + (name!=null?name.getText():null));
            			

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


    // $ANTLR start "netDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:331:1: netDecl[DesignNode des] : ^( 'net' ( sliceList[slices] )? name= IDENT ( attributeDecl[n] )* ) ;
    public final void netDecl(DesignNode des) throws RecognitionException {
        CommonTree name=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:335:2: ( ^( 'net' ( sliceList[slices] )? name= IDENT ( attributeDecl[n] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:335:4: ^( 'net' ( sliceList[slices] )? name= IDENT ( attributeDecl[n] )* )
            {
            match(input,34,FOLLOW_34_in_netDecl334); 

            	// housekeeping
            				List<Integer> slices = new ArrayList<Integer>();
            				NetNode n = new NetNode(null);
            				attrDecls.clear();
            			

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:345:3: ( sliceList[slices] )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==COLON||LA6_0==COMMA) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:345:3: sliceList[slices]
                    {
                    pushFollow(FOLLOW_sliceList_in_netDecl357);
                    sliceList(slices);

                    state._fsp--;


                    }
                    break;

            }

            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netDecl363); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:345:33: ( attributeDecl[n] )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==32) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:345:33: attributeDecl[n]
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_netDecl365);
            	    attributeDecl(n);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            match(input, Token.UP, null); 
            	// make net nodes based on the slice list
            				for (int i = 0; i < slices.size(); i++) {
            					NetNode newNode = new NetNode(des);
            					newNode.setName((name!=null?name.getText():null) + "[" + slices.get(i) + "]");
            					newNode.setLocation((name!=null?name.getLine():0), (name!=null?name.getCharPositionInLine():0), input.getSourceName());
            					for (AttributeNode a : n.getAttributes()) {
            						AttributeNode newA = new AttributeNode(newNode);
            						newA.setName(a.getName());
            						newA.setLocation(a.getLine(), a.getPosition(), a.getFileName());
            						newA.setValue(a.getValue());
            						newNode.addAttribute(newA);
            					}
            					
            					// check for duplicate net declarations
            					if(!des.addNet(newNode)) {
            						addError(newNode, "duplicate net declaration");
            					}
            				}
            				
            				// otherwise, make a net node based solely on the name	
            				if (slices.isEmpty()) {
            					NetNode newNode = new NetNode(des);
            					newNode.setName((name!=null?name.getText():null));
            					newNode.setLocation((name!=null?name.getLine():0), (name!=null?name.getCharPositionInLine():0), input.getSourceName());
            					for (AttributeNode a : n.getAttributes()) {
            							AttributeNode newA = new AttributeNode(newNode);
            							newA.setName(a.getName());
            							newA.setValue(a.getValue());
            							newA.setLocation(a.getLine(), a.getPosition(), a.getFileName());
            							newNode.addAttribute(newA);
            					}
            					
            					// check for duplicate net declarations
            					if(!des.addNet(newNode)) {
            						addError(newNode, "duplicate net declaration");
            					}
            				}
            				
            				// check for overall duplicates based solely on the name
            				if (!netDecls.add((name!=null?name.getText():null)))
            					errors.add(input.getSourceName() + " line " + (name!=null?name.getLine():0) + ":" 
            						+ (name!=null?name.getCharPositionInLine():0) + " duplicate net declaration: " + (name!=null?name.getText():null));
            			

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


    // $ANTLR start "instDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:394:1: instDecl[DesignNode des] : ^( 'inst' instName= IDENT devName= IDENT ( arrayList[indices] )? ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )* ) ;
    public final void instDecl(DesignNode des) throws RecognitionException {
        CommonTree instName=null;
        CommonTree devName=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:395:2: ( ^( 'inst' instName= IDENT devName= IDENT ( arrayList[indices] )? ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:395:4: ^( 'inst' instName= IDENT devName= IDENT ( arrayList[indices] )? ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )* )
            {
            	// sets of all the instance nodes and indices list which they cover
            			Set<InstanceNode> instNodes = new HashSet<InstanceNode>();
            			List<Integer> indices = new ArrayList<Integer>();
            		
            match(input,35,FOLLOW_35_in_instDecl409); 

            match(input, Token.DOWN, null); 
            instName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl413); 
            devName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl417); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:401:41: ( arrayList[indices] )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==COLON||LA8_0==COMMA||LA8_0==LPAREN) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:401:41: arrayList[indices]
                    {
                    pushFollow(FOLLOW_arrayList_in_instDecl419);
                    arrayList(indices);

                    state._fsp--;


                    }
                    break;

            }

            	// make as many instance nodes as there are indices
            				for (int j = 0; j < indices.size(); j++) {
            				
            					InstanceNode i = new InstanceNode(des);
            					i.setName((instName!=null?instName.getText():null) + "(" + indices.get(j) + ")");
            					i.setLocation((instName!=null?instName.getLine():0), (instName!=null?instName.getCharPositionInLine():0), input.getSourceName());
            					
            					// find the corresponding device declaration
            					DeviceNode dev = des.getDevice((devName!=null?devName.getText():null));
            					if (dev != null) {
            						i.setDevice(dev);
            						// add all of the attributes and pins from the device definition
            						for (AttributeNode a: dev.getAttributes())
            							i.addAttribute(new AttributeNode(a, i));
            						for (PinNode pn: dev.getPins())
            							i.addPin(pn);
            					} else
            						addError(i, "instance references undeclared device");
            					
            					instNodes.add(i);
            				}
            				
            				// otherwise make only one instance node based on the instName
            				if (indices.isEmpty()) {
            					InstanceNode i = new InstanceNode(des);
            					i.setName((instName!=null?instName.getText():null));
            					i.setLocation((instName!=null?instName.getLine():0), (instName!=null?instName.getCharPositionInLine():0), input.getSourceName());
            					
            					// find the corresponding device declaration
            					DeviceNode dev = des.getDevice((devName!=null?devName.getText():null));
            					if (dev != null) {
            						i.setDevice(dev);
            						// add all of the attributes and pins from the device definition
            						for (AttributeNode a: dev.getAttributes())
            							i.addAttribute(new AttributeNode(a, i));
            						for (PinNode pn: dev.getPins())
            							i.addPin(pn);
            					} else
            						addError(i, "instance references undeclared device");
            							
            					instNodes.add(i);
            				}
            			
            	// check for duplicates
            				for (InstanceNode i : instNodes) {
            					if(!des.addInstance(i))
            						addError(i, "duplicate instance declaration");
            				}
            				
            				// check for overall duplicates based solely on the instName
            				if (!instanceDecls.add((instName!=null?instName.getText():null)))
            					errors.add(input.getSourceName() + " line " + (instName!=null?instName.getLine():0) + ":" 
            						+ (instName!=null?instName.getCharPositionInLine():0) + " duplicate instance declaration: " + (instName!=null?instName.getText():null));
            			
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:460:3: ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )*
            loop9:
            do {
                int alt9=3;
                alt9 = dfa9.predict(input);
                switch (alt9) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:460:4: attrAssign[des, $instName.text]
            	    {
            	    pushFollow(FOLLOW_attrAssign_in_instDecl446);
            	    attrAssign(des, (instName!=null?instName.getText():null));

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:460:38: pinAssign[des, $instName.text]
            	    {
            	    pushFollow(FOLLOW_pinAssign_in_instDecl451);
            	    pinAssign(des, (instName!=null?instName.getText():null));

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // $ANTLR end "instDecl"


    // $ANTLR start "attrAssign"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:463:1: attrAssign[DesignNode des, String instName] : ^( EQUALS ( 'newattr' )? ( instanceQualifier[instName, indices] )? name= IDENT value= STRING_LITERAL ) ;
    public final void attrAssign(DesignNode des, String instName) throws RecognitionException {
        CommonTree name=null;
        CommonTree value=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:464:2: ( ^( EQUALS ( 'newattr' )? ( instanceQualifier[instName, indices] )? name= IDENT value= STRING_LITERAL ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:464:4: ^( EQUALS ( 'newattr' )? ( instanceQualifier[instName, indices] )? name= IDENT value= STRING_LITERAL )
            {
            	// flag for a new attribute and a list of indices the attribute covers
            			boolean newAttr = false;
            			List<Integer> indices = new ArrayList<Integer>();
            		
            match(input,EQUALS,FOLLOW_EQUALS_in_attrAssign479); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:470:12: ( 'newattr' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==36) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:470:13: 'newattr'
                    {
                    match(input,36,FOLLOW_36_in_attrAssign482); 
                    newAttr = true;

                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:470:44: ( instanceQualifier[instName, indices] )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==PERIOD) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:470:44: instanceQualifier[instName, indices]
                    {
                    pushFollow(FOLLOW_instanceQualifier_in_attrAssign489);
                    instanceQualifier(instName, indices);

                    state._fsp--;


                    }
                    break;

            }

            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attrAssign495); 
            value=(CommonTree)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_attrAssign499); 

            match(input, Token.UP, null); 
            	// for every index
            			for(int i = 0; i < indices.size(); i++) {
            				InstanceNode inst = des.getInstance(instName + "(" + indices.get(i) + ")");
            				if(inst!=null){
            					AttributeNode a = inst.getAttribute((name!=null?name.getText():null));
            					if (a!=null) {
            						a.setValue((value!=null?value.getText():null));
            					} else {
            						if(newAttr) {
            							AttributeNode newA = new AttributeNode(inst);
            							newA.setName((name!=null?name.getText():null));
            							newA.setValue((value!=null?value.getText():null));
            							newA.setLocation((name!=null?name.getLine():0), (name!=null?name.getCharPositionInLine():0), input.getSourceName());
            							inst.addAttribute(newA);
            						} else {
            							errors.add(input.getSourceName() + " line " + (name!=null?name.getLine():0) + ":" 
            								+ (name!=null?name.getCharPositionInLine():0) + " instance references undeclared attribute: " + (name!=null?name.getText():null));
            						}
            					}
            				} else {
            					errors.add(input.getSourceName() + " line " + (name!=null?name.getLine():0) + ":" 
            								+ (name!=null?name.getCharPositionInLine():0) + " instance name is undeclared: " + instName + "(" + indices.get(i) + ")");
            				}
            			}
            			// if a global attribute
            			if (indices.isEmpty()) {
            				for (InstanceNode inst : des.getAllInstances(instName)) {
            					AttributeNode a = inst.getAttribute((name!=null?name.getText():null));
            					if (a!=null) {
            						a.setValue((value!=null?value.getText():null));
            					} else {
            						if(newAttr) {
            							AttributeNode newA = new AttributeNode(inst);
            							newA.setName((name!=null?name.getText():null));
            							newA.setValue((value!=null?value.getText():null));
            							newA.setLocation((name!=null?name.getLine():0), (name!=null?name.getCharPositionInLine():0), input.getSourceName());
            							inst.addAttribute(newA);
            						} else {
            							errors.add(input.getSourceName() + " line " + (name!=null?name.getLine():0) + ":" 
            								+ (name!=null?name.getCharPositionInLine():0) + " instance references undeclared attribute: " + instName);
            						}
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


    // $ANTLR start "pinAssign"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:519:1: pinAssign[DesignNode des, String instName] : ^( EQUALS ( instanceQualifier[instName, indices] )? name= IDENT ( sliceList[bits] )? concatenation[concats, bits.size()] ) ;
    public final void pinAssign(DesignNode des, String instName) throws RecognitionException {
        CommonTree name=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:520:2: ( ^( EQUALS ( instanceQualifier[instName, indices] )? name= IDENT ( sliceList[bits] )? concatenation[concats, bits.size()] ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:520:4: ^( EQUALS ( instanceQualifier[instName, indices] )? name= IDENT ( sliceList[bits] )? concatenation[concats, bits.size()] )
            {
            	List<Integer> indices = new ArrayList<Integer>();
            			List<Integer> bits = new ArrayList<Integer>();
            			List<String> concats = new ArrayList<String>();
            	
            		
            match(input,EQUALS,FOLLOW_EQUALS_in_pinAssign526); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:525:12: ( instanceQualifier[instName, indices] )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==PERIOD) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:525:12: instanceQualifier[instName, indices]
                    {
                    pushFollow(FOLLOW_instanceQualifier_in_pinAssign528);
                    instanceQualifier(instName, indices);

                    state._fsp--;


                    }
                    break;

            }

            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinAssign534); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:525:61: ( sliceList[bits] )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==COLON||LA13_0==COMMA) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:525:61: sliceList[bits]
                    {
                    pushFollow(FOLLOW_sliceList_in_pinAssign536);
                    sliceList(bits);

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_concatenation_in_pinAssign540);
            concatenation(concats, bits.size());

            state._fsp--;


            match(input, Token.UP, null); 
            	if(indices.isEmpty() && bits.isEmpty()) {
            				for(InstanceNode i : des.getAllInstances(instName)) {
            					List<PinNode> pins = i.getAllPins((name!=null?name.getText():null));
            					for(int j = 0 ; j < pins.size(); j++) {
            						pins.get(j).setNet(des.getNet(concats.get(j)));
            						des.getNet(concats.get(j)).addPin(pins.get(j));
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
    // $ANTLR end "pinAssign"


    // $ANTLR start "concatenation"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:538:1: concatenation[List<String> concats, int vectorWidth] : ( (first= IDENT ( sliceList[slices] )? (next= IDENT ( sliceList[slices] )? )* ) | ( LANGLE global= IDENT ) | ( 'open' ) ) ;
    public final void concatenation(List<String> concats, int vectorWidth) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;
        CommonTree global=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:539:2: ( ( (first= IDENT ( sliceList[slices] )? (next= IDENT ( sliceList[slices] )? )* ) | ( LANGLE global= IDENT ) | ( 'open' ) ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:539:4: ( (first= IDENT ( sliceList[slices] )? (next= IDENT ( sliceList[slices] )? )* ) | ( LANGLE global= IDENT ) | ( 'open' ) )
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:539:4: ( (first= IDENT ( sliceList[slices] )? (next= IDENT ( sliceList[slices] )? )* ) | ( LANGLE global= IDENT ) | ( 'open' ) )
            int alt17=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt17=1;
                }
                break;
            case LANGLE:
                {
                alt17=2;
                }
                break;
            case 37:
                {
                alt17=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:539:6: (first= IDENT ( sliceList[slices] )? (next= IDENT ( sliceList[slices] )? )* )
                    {
                    List<Integer> slices = new ArrayList<Integer>();
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:540:4: (first= IDENT ( sliceList[slices] )? (next= IDENT ( sliceList[slices] )? )* )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:540:5: first= IDENT ( sliceList[slices] )? (next= IDENT ( sliceList[slices] )? )*
                    {
                    first=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenation569); 
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:540:17: ( sliceList[slices] )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==COLON||LA14_0==COMMA) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:540:17: sliceList[slices]
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation571);
                            sliceList(slices);

                            state._fsp--;


                            }
                            break;

                    }

                    	if (slices.isEmpty()) {
                    						concats.add((first!=null?first.getText():null));
                    					} else {
                    						for(int i = 0 ; i < slices.size(); i++) {
                    							concats.add((first!=null?first.getText():null) + "[" + slices.get(i) + "]");
                    						}
                    					}
                    				
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:549:4: (next= IDENT ( sliceList[slices] )? )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==IDENT) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:549:5: next= IDENT ( sliceList[slices] )?
                    	    {
                    	    next=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenation587); 
                    	    slices.clear();
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:551:4: ( sliceList[slices] )?
                    	    int alt15=2;
                    	    int LA15_0 = input.LA(1);

                    	    if ( (LA15_0==COLON||LA15_0==COMMA) ) {
                    	        alt15=1;
                    	    }
                    	    switch (alt15) {
                    	        case 1 :
                    	            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:551:4: sliceList[slices]
                    	            {
                    	            pushFollow(FOLLOW_sliceList_in_concatenation602);
                    	            sliceList(slices);

                    	            state._fsp--;


                    	            }
                    	            break;

                    	    }

                    	    	if (slices.isEmpty()) {
                    	    						concats.add((next!=null?next.getText():null));
                    	    					} else {
                    	    						for(int i = 0 ; i < slices.size(); i++) {
                    	    							concats.add((next!=null?next.getText():null) + "[" + slices.get(i) + "]");
                    	    						}
                    	    					}
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:562:5: ( LANGLE global= IDENT )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:562:5: ( LANGLE global= IDENT )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:562:6: LANGLE global= IDENT
                    {
                    match(input,LANGLE,FOLLOW_LANGLE_in_concatenation626); 
                    global=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenation630); 

                    }

                    	for(int i = 0; i < vectorWidth; i++)
                    						concats.add("<>" + (global!=null?global.getText():null));
                    				

                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:566:5: ( 'open' )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:566:5: ( 'open' )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:566:6: 'open'
                    {
                    match(input,37,FOLLOW_37_in_concatenation645); 

                    }

                    concats.add("open");

                    }
                    break;

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
    // $ANTLR end "concatenation"


    // $ANTLR start "instanceQualifier"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:570:1: instanceQualifier[String instName, List<Integer> indices] : ^( PERIOD name= IDENT ( arrayList[indices] )? ) ;
    public final void instanceQualifier(String instName, List<Integer> indices) throws RecognitionException {
        CommonTree name=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:574:2: ( ^( PERIOD name= IDENT ( arrayList[indices] )? ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:574:4: ^( PERIOD name= IDENT ( arrayList[indices] )? )
            {
            match(input,PERIOD,FOLLOW_PERIOD_in_instanceQualifier667); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instanceQualifier671); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:574:24: ( arrayList[indices] )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==COLON||LA18_0==COMMA||LA18_0==LPAREN) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:574:24: arrayList[indices]
                    {
                    pushFollow(FOLLOW_arrayList_in_instanceQualifier673);
                    arrayList(indices);

                    state._fsp--;


                    }
                    break;

            }


            match(input, Token.UP, null); 
            	// check that the instance qualifier matches
            	    	if (!instName.equals((name!=null?name.getText():null))) {
            	    		errors.add(input.getSourceName() + " line " + (name!=null?name.getLine():0) + ":" 
            						+ (name!=null?name.getCharPositionInLine():0) + " invalid instance qualifier: " + (name!=null?name.getText():null));
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


    // $ANTLR start "arrayList"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:584:1: arrayList[List<Integer> indices] : ( ^( COMMA LPAREN start= INTEGER (next= INTEGER )* ) | ^( COLON LPAREN start= INTEGER end= INTEGER ) | ( LPAREN single= INTEGER ) );
    public final void arrayList(List<Integer> indices) throws RecognitionException {
        CommonTree start=null;
        CommonTree next=null;
        CommonTree end=null;
        CommonTree single=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:585:2: ( ^( COMMA LPAREN start= INTEGER (next= INTEGER )* ) | ^( COLON LPAREN start= INTEGER end= INTEGER ) | ( LPAREN single= INTEGER ) )
            int alt20=3;
            switch ( input.LA(1) ) {
            case COMMA:
                {
                alt20=1;
                }
                break;
            case COLON:
                {
                alt20=2;
                }
                break;
            case LPAREN:
                {
                alt20=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:585:4: ^( COMMA LPAREN start= INTEGER (next= INTEGER )* )
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_arrayList698); 

                    match(input, Token.DOWN, null); 
                    match(input,LPAREN,FOLLOW_LPAREN_in_arrayList700); 
                    start=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList706); 
                    indices.add(Integer.parseInt((start!=null?start.getText():null)));
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:587:8: (next= INTEGER )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==INTEGER) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:587:10: next= INTEGER
                    	    {
                    	    next=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList724); 
                    	    indices.add(Integer.parseInt((next!=null?next.getText():null)));

                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:590:5: ^( COLON LPAREN start= INTEGER end= INTEGER )
                    {
                    match(input,COLON,FOLLOW_COLON_in_arrayList754); 

                    match(input, Token.DOWN, null); 
                    match(input,LPAREN,FOLLOW_LPAREN_in_arrayList756); 
                    start=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList760); 
                    end=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList764); 
                    	int begin = Integer.parseInt((start!=null?start.getText():null));
                    				int finish = Integer.parseInt((end!=null?end.getText():null));
                    			
                    				if (begin <= finish) {	
                            			for (int i = begin; i <= finish; i++) {
                              				indices.add(i);
                            			}
                          			}
                          			else {
                            			for (int i = begin; i >= finish; i--) {
                               				indices.add(i);
                            			}
                          			}
                    			

                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:606:4: ( LPAREN single= INTEGER )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:606:4: ( LPAREN single= INTEGER )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:606:5: LPAREN single= INTEGER
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_arrayList781); 
                    single=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList785); 
                    indices.add(Integer.parseInt((single!=null?single.getText():null)));

                    }


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
    // $ANTLR end "arrayList"


    // $ANTLR start "sliceList"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:609:1: sliceList[List<Integer> slices] : ( ^( COMMA LBRACKET start= INTEGER (next= INTEGER )* ) | ^( COLON LBRACKET start= INTEGER end= INTEGER ) );
    public final void sliceList(List<Integer> slices) throws RecognitionException {
        CommonTree start=null;
        CommonTree next=null;
        CommonTree end=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:610:2: ( ^( COMMA LBRACKET start= INTEGER (next= INTEGER )* ) | ^( COLON LBRACKET start= INTEGER end= INTEGER ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==COMMA) ) {
                alt22=1;
            }
            else if ( (LA22_0==COLON) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:611:3: ^( COMMA LBRACKET start= INTEGER (next= INTEGER )* )
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_sliceList808); 

                    match(input, Token.DOWN, null); 
                    match(input,LBRACKET,FOLLOW_LBRACKET_in_sliceList810); 
                    start=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList814); 
                    slices.add(Integer.parseInt((start!=null?start.getText():null)));
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:612:8: (next= INTEGER )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==INTEGER) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:612:9: next= INTEGER
                    	    {
                    	    next=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList830); 
                    	    slices.add(Integer.parseInt((next!=null?next.getText():null)));

                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:616:3: ^( COLON LBRACKET start= INTEGER end= INTEGER )
                    {
                    match(input,COLON,FOLLOW_COLON_in_sliceList867); 

                    match(input, Token.DOWN, null); 
                    match(input,LBRACKET,FOLLOW_LBRACKET_in_sliceList869); 
                    start=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList873); 
                    end=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList877); 
                    	int begin = Integer.parseInt((start!=null?start.getText():null));
                    				int finish = Integer.parseInt((end!=null?end.getText():null));
                    			
                    				if (begin <= finish) {	
                    					// increment for up slice lists
                            			for (int i = begin; i <= finish; i++)
                              				slices.add(i);
                          			} else {
                          				// decrement for down slice lists
                            			for (int i = begin; i >= finish; i--)
                               				slices.add(i);
                          			}
                    			

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
    // $ANTLR end "sliceList"


    // $ANTLR start "pinList"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:634:1: pinList[List<String> pList] : first= ( PIN | INTEGER | IDENT ) (next= ( PIN | INTEGER | IDENT ) )* ;
    public final void pinList(List<String> pList) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:635:2: (first= ( PIN | INTEGER | IDENT ) (next= ( PIN | INTEGER | IDENT ) )* )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:636:3: first= ( PIN | INTEGER | IDENT ) (next= ( PIN | INTEGER | IDENT ) )*
            {
            Set<String> pins = new HashSet<String>();
            first=(CommonTree)input.LT(1);
            if ( input.LA(1)==IDENT||(input.LA(1)>=PIN && input.LA(1)<=INTEGER) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            	if(!pins.add((first!=null?first.getText():null)))
            					errors.add(input.getSourceName() + " line " + (first!=null?first.getLine():0) + ":" 
            						+ (first!=null?first.getCharPositionInLine():0) + " duplicate found in pin list");
            				pList.add((first!=null?first.getText():null));
            			
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:647:7: (next= ( PIN | INTEGER | IDENT ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==IDENT||(LA23_0>=PIN && LA23_0<=INTEGER)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:647:8: next= ( PIN | INTEGER | IDENT )
            	    {
            	    next=(CommonTree)input.LT(1);
            	    if ( input.LA(1)==IDENT||(input.LA(1)>=PIN && input.LA(1)<=INTEGER) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    	if(!pins.add((next!=null?next.getText():null)))
            	    					errors.add(input.getSourceName() + " line " + (first!=null?first.getLine():0) + ":" 
            	    						+ (first!=null?first.getCharPositionInLine():0) + " duplicate found in pin list");
            	    				pList.add((next!=null?next.getText():null));
            	    			

            	    }
            	    break;

            	default :
            	    break loop23;
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
        return ;
    }
    // $ANTLR end "pinList"

    // Delegated rules


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\31\uffff";
    static final String DFA9_eofS =
        "\31\uffff";
    static final String DFA9_minS =
        "\1\3\1\uffff\1\2\1\4\1\uffff\1\2\2\4\1\uffff\1\3\2\2\1\17\1\4\2"+
        "\24\1\3\2\17\1\3\1\17\4\3";
    static final String DFA9_maxS =
        "\1\6\1\uffff\1\2\1\44\1\uffff\1\2\1\45\1\4\1\uffff\1\24\2\2\1\17"+
        "\1\4\2\24\1\3\5\17\3\3";
    static final String DFA9_acceptS =
        "\1\uffff\1\3\2\uffff\1\1\3\uffff\1\2\20\uffff";
    static final String DFA9_specialS =
        "\31\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\1\2\uffff\1\2",
            "",
            "\1\3",
            "\1\6\4\uffff\1\5\32\uffff\1\4",
            "",
            "\1\7",
            "\1\10\2\uffff\1\4\1\10\2\uffff\1\10\4\uffff\1\10\24\uffff"+
            "\1\10",
            "\1\11",
            "",
            "\1\15\4\uffff\1\13\7\uffff\1\12\3\uffff\1\14",
            "\1\16",
            "\1\17",
            "\1\20",
            "\1\6",
            "\1\21",
            "\1\22",
            "\1\15",
            "\1\23",
            "\1\24",
            "\1\26\13\uffff\1\25",
            "\1\27",
            "\1\26\13\uffff\1\25",
            "\1\15",
            "\1\30",
            "\1\15"
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
            return "()* loopback of 460:3: ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )*";
        }
    }
 

    public static final BitSet FOLLOW_designDecl_in_sourceText61 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_designDecl76 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_designDecl80 = new BitSet(new long[]{0x00000004A0000000L});
    public static final BitSet FOLLOW_deviceDecl_in_designDecl104 = new BitSet(new long[]{0x00000004A0000000L});
    public static final BitSet FOLLOW_netDecl_in_designDecl109 = new BitSet(new long[]{0x00000004A0000000L});
    public static final BitSet FOLLOW_29_in_designDecl114 = new BitSet(new long[]{0x0000000800000008L});
    public static final BitSet FOLLOW_instDecl_in_designDecl117 = new BitSet(new long[]{0x0000000800000008L});
    public static final BitSet FOLLOW_31_in_deviceDecl153 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl157 = new BitSet(new long[]{0x0000000300000008L});
    public static final BitSet FOLLOW_attributeDecl_in_deviceDecl184 = new BitSet(new long[]{0x0000000300000008L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl189 = new BitSet(new long[]{0x0000000300000008L});
    public static final BitSet FOLLOW_32_in_attributeDecl224 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_attributeDecl228 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_attributeDecl232 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_33_in_pinDecl269 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl294 = new BitSet(new long[]{0x000000000001C110L});
    public static final BitSet FOLLOW_sliceList_in_pinDecl296 = new BitSet(new long[]{0x000000000001C110L});
    public static final BitSet FOLLOW_pinList_in_pinDecl300 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_34_in_netDecl334 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_sliceList_in_netDecl357 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl363 = new BitSet(new long[]{0x0000000100000008L});
    public static final BitSet FOLLOW_attributeDecl_in_netDecl365 = new BitSet(new long[]{0x0000000100000008L});
    public static final BitSet FOLLOW_35_in_instDecl409 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_instDecl413 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instDecl417 = new BitSet(new long[]{0x0000000000110148L});
    public static final BitSet FOLLOW_arrayList_in_instDecl419 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_attrAssign_in_instDecl446 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_pinAssign_in_instDecl451 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_EQUALS_in_attrAssign479 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_36_in_attrAssign482 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_instanceQualifier_in_attrAssign489 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attrAssign495 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_attrAssign499 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssign526 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_instanceQualifier_in_pinAssign528 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinAssign534 = new BitSet(new long[]{0x0000002000010910L});
    public static final BitSet FOLLOW_sliceList_in_pinAssign536 = new BitSet(new long[]{0x0000002000010910L});
    public static final BitSet FOLLOW_concatenation_in_pinAssign540 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENT_in_concatenation569 = new BitSet(new long[]{0x0000000000010112L});
    public static final BitSet FOLLOW_sliceList_in_concatenation571 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_IDENT_in_concatenation587 = new BitSet(new long[]{0x0000000000010112L});
    public static final BitSet FOLLOW_sliceList_in_concatenation602 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_LANGLE_in_concatenation626 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_concatenation645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_instanceQualifier667 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_instanceQualifier671 = new BitSet(new long[]{0x0000000000110108L});
    public static final BitSet FOLLOW_arrayList_in_instanceQualifier673 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMMA_in_arrayList698 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LPAREN_in_arrayList700 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList706 = new BitSet(new long[]{0x0000000000008008L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList724 = new BitSet(new long[]{0x0000000000008008L});
    public static final BitSet FOLLOW_COLON_in_arrayList754 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LPAREN_in_arrayList756 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList760 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList764 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LPAREN_in_arrayList781 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_sliceList808 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_sliceList810 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList814 = new BitSet(new long[]{0x0000000000008008L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList830 = new BitSet(new long[]{0x0000000000008008L});
    public static final BitSet FOLLOW_COLON_in_sliceList867 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_sliceList869 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList873 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList877 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_pinList917 = new BitSet(new long[]{0x000000000000C012L});
    public static final BitSet FOLLOW_set_in_pinList951 = new BitSet(new long[]{0x000000000000C012L});

}