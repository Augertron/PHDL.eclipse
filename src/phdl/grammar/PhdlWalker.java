// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g 2011-07-08 01:58:37

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "SEMICOLON", "EQUALS", "STRING", "PERIOD", "AMPERSAND", "LEFTANGLE", "RIGHTANGLE", "LEFTBRACE", "PIN", "INTEGER", "COMMA", "RIGHTBRACE", "LEFTBRACKET", "COLON", "RIGHTBRACKET", "LEFTPAREN", "RIGHTPAREN", "CHAR", "DIGIT", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "'design'", "'is'", "'begin'", "'end'", "'device'", "'attr'", "'pin'", "'net'", "'inst'", "'of'", "'newattr'", "'open'"
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
    public static final int T__38=38;
    public static final int IDENT=4;
    public static final int SEMICOLON=5;
    public static final int EQUALS=6;
    public static final int STRING=7;
    public static final int PERIOD=8;
    public static final int AMPERSAND=9;
    public static final int LEFTANGLE=10;
    public static final int RIGHTANGLE=11;
    public static final int LEFTBRACE=12;
    public static final int PIN=13;
    public static final int INTEGER=14;
    public static final int COMMA=15;
    public static final int RIGHTBRACE=16;
    public static final int LEFTBRACKET=17;
    public static final int COLON=18;
    public static final int RIGHTBRACKET=19;
    public static final int LEFTPAREN=20;
    public static final int RIGHTPAREN=21;
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
    public String getGrammarFileName() { return "C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g"; }



    	/**
    	 * The set of required attributes
    	 */
    	private Set<String> reqAttrs = new HashSet<String>();
    	/**
    	 * The sorted set of errors
    	 */
    	private SortedSet<String> errors = new TreeSet<String>();
    	private SortedSet<String> warnings = new TreeSet<String>();
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
    	
    	public SortedSet<String> getWarnings() {
    		return warnings;
    	}
    	
    	/**
    	 * Used from within the walker to add an error found while processing the tree
    	 */
    	private void addError(Node n, String message) {
    		errors.add(n.getFileName() + " line " + n.getLine() + ":" 
    				+ n.getPosition() + " " + message + ": " + n.getName());
    	}
    	
    	private void addWarning(Node n, String message) {
    		warnings.add(n.getFileName() + " line " + n.getLine() + ":" 
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:136:1: sourceText : ( designDecl )* ;
    public final void sourceText() throws RecognitionException {
        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:143:2: ( ( designDecl )* )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:143:4: ( designDecl )*
            {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:143:4: ( designDecl )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==27) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:143:4: designDecl
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:146:1: designDecl : ^( 'design' name= IDENT ( deviceDecl[des] | netDecl[des] )* 'begin' ( instDecl[des] )* ) ;
    public final void designDecl() throws RecognitionException {
        CommonTree name=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:159:2: ( ^( 'design' name= IDENT ( deviceDecl[des] | netDecl[des] )* 'begin' ( instDecl[des] )* ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:159:4: ^( 'design' name= IDENT ( deviceDecl[des] | netDecl[des] )* 'begin' ( instDecl[des] )* )
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
            			
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:173:3: ( deviceDecl[des] | netDecl[des] )*
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
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:173:4: deviceDecl[des]
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_designDecl104);
            	    deviceDecl(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:173:22: netDecl[des]
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
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:173:45: ( instDecl[des] )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==35) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:173:46: instDecl[des]
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:183:1: deviceDecl[DesignNode des] : ^( 'device' name= IDENT ( attributeDecl[dev] | pinDecl[dev] )* ) ;
    public final void deviceDecl(DesignNode des) throws RecognitionException {
        CommonTree name=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:195:2: ( ^( 'device' name= IDENT ( attributeDecl[dev] | pinDecl[dev] )* ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:195:4: ^( 'device' name= IDENT ( attributeDecl[dev] | pinDecl[dev] )* )
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
            			
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:209:3: ( attributeDecl[dev] | pinDecl[dev] )*
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
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:209:4: attributeDecl[dev]
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_deviceDecl184);
            	    attributeDecl(dev);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:209:25: pinDecl[dev]
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:227:1: attributeDecl[Attributable dev] : ^( 'attr' name= IDENT value= STRING ) ;
    public final void attributeDecl(Attributable dev) throws RecognitionException {
        CommonTree name=null;
        CommonTree value=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:238:2: ( ^( 'attr' name= IDENT value= STRING ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:238:4: ^( 'attr' name= IDENT value= STRING )
            {
            match(input,32,FOLLOW_32_in_attributeDecl224); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attributeDecl228); 
            value=(CommonTree)match(input,STRING,FOLLOW_STRING_in_attributeDecl232); 

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:255:1: pinDecl[DeviceNode dev] : ^( 'pin' name= IDENT ( sliceList[sList] )? pinList[pList] ) ;
    public final void pinDecl(DeviceNode dev) throws RecognitionException {
        CommonTree name=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:273:2: ( ^( 'pin' name= IDENT ( sliceList[sList] )? pinList[pList] ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:273:4: ^( 'pin' name= IDENT ( sliceList[sList] )? pinList[pList] )
            {
            match(input,33,FOLLOW_33_in_pinDecl269); 

             	// sets to keep track of the slice and pin lists
            				List<Integer> sList = new ArrayList<Integer>(); 
            				List<String> pList = new ArrayList<String>();
            			

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinDecl294); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:282:14: ( sliceList[sList] )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==COMMA||(LA5_0>=LEFTBRACKET && LA5_0<=COLON)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:282:14: sliceList[sList]
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:341:1: netDecl[DesignNode des] : ^( 'net' name= IDENT ( sliceList[slices] )? ( attributeDecl[n] )* ) ;
    public final void netDecl(DesignNode des) throws RecognitionException {
        CommonTree name=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:350:2: ( ^( 'net' name= IDENT ( sliceList[slices] )? ( attributeDecl[n] )* ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:350:4: ^( 'net' name= IDENT ( sliceList[slices] )? ( attributeDecl[n] )* )
            {
            match(input,34,FOLLOW_34_in_netDecl334); 

            	// housekeeping
            				List<Integer> slices = new ArrayList<Integer>();
            				NetNode n = new NetNode(null);
            				attrDecls.clear();
            			

            match(input, Token.DOWN, null); 
            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netDecl359); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:360:14: ( sliceList[slices] )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==COMMA||(LA6_0>=LEFTBRACKET && LA6_0<=COLON)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:360:14: sliceList[slices]
                    {
                    pushFollow(FOLLOW_sliceList_in_netDecl361);
                    sliceList(slices);

                    state._fsp--;


                    }
                    break;

            }

            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:360:33: ( attributeDecl[n] )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==32) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:360:33: attributeDecl[n]
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:409:1: instDecl[DesignNode des] : ^( 'inst' instName= IDENT ( arrayList[indices] )? devName= IDENT ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )* ) ;
    public final void instDecl(DesignNode des) throws RecognitionException {
        CommonTree instName=null;
        CommonTree devName=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:420:2: ( ^( 'inst' instName= IDENT ( arrayList[indices] )? devName= IDENT ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )* ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:420:4: ^( 'inst' instName= IDENT ( arrayList[indices] )? devName= IDENT ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )* )
            {
            match(input,35,FOLLOW_35_in_instDecl401); 

            	// Set of instance nodes to check for duplicates
            				Set<InstanceNode> instNodes = new HashSet<InstanceNode>();
            				// List of indices to be derived from the arrayList
            				List<Integer> indices = new ArrayList<Integer>();
            			

            match(input, Token.DOWN, null); 
            instName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl425); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:430:18: ( arrayList[indices] )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==COMMA||LA8_0==COLON||LA8_0==LEFTPAREN) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:430:18: arrayList[indices]
                    {
                    pushFollow(FOLLOW_arrayList_in_instDecl427);
                    arrayList(indices);

                    state._fsp--;


                    }
                    break;

            }

            devName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl433); 
            	// make as many instance nodes as there are indices
            				for (int j = 0; j < indices.size(); j++) {
            				
            					InstanceNode i = new InstanceNode(des);
            					i.setName((instName!=null?instName.getText():null) + "(" + indices.get(j) + ")");
            					i.setLocation((instName!=null?instName.getLine():0), (instName!=null?instName.getCharPositionInLine():0), input.getSourceName());
            					
            					// find the corresponding device declaration
            					DeviceNode dev = des.getDevice((devName!=null?devName.getText():null));
            					if (dev != null) {
            						i.setDevice(dev);
            						// copy all of the attribute and pin nodes from the device definition
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
            						// add all of the attribute and pin nodes from the device definition
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
            			
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:489:3: ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )*
            loop9:
            do {
                int alt9=3;
                alt9 = dfa9.predict(input);
                switch (alt9) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:489:4: attrAssign[des, $instName.text]
            	    {
            	    pushFollow(FOLLOW_attrAssign_in_instDecl455);
            	    attrAssign(des, (instName!=null?instName.getText():null));

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:489:38: pinAssign[des, $instName.text]
            	    {
            	    pushFollow(FOLLOW_pinAssign_in_instDecl460);
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:492:1: attrAssign[DesignNode des, String instName] : ^( EQUALS ( 'newattr' )? ( instanceQualifier[instName, indices] )? name= IDENT value= STRING ) ;
    public final void attrAssign(DesignNode des, String instName) throws RecognitionException {
        CommonTree name=null;
        CommonTree value=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:509:2: ( ^( EQUALS ( 'newattr' )? ( instanceQualifier[instName, indices] )? name= IDENT value= STRING ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:509:4: ^( EQUALS ( 'newattr' )? ( instanceQualifier[instName, indices] )? name= IDENT value= STRING )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_attrAssign481); 

            	// flag for a new attribute and a list of indices the attribute assignment applies to
            				boolean newAttr = false;
            				List<Integer> indices = new ArrayList<Integer>();
            			

            match(input, Token.DOWN, null); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:518:3: ( 'newattr' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==37) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:518:4: 'newattr'
                    {
                    match(input,37,FOLLOW_37_in_attrAssign505); 
                    newAttr = true;

                    }
                    break;

            }

            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:518:35: ( instanceQualifier[instName, indices] )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==PERIOD) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:518:35: instanceQualifier[instName, indices]
                    {
                    pushFollow(FOLLOW_instanceQualifier_in_attrAssign512);
                    instanceQualifier(instName, indices);

                    state._fsp--;


                    }
                    break;

            }

            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attrAssign521); 
            value=(CommonTree)match(input,STRING,FOLLOW_STRING_in_attrAssign525); 

            match(input, Token.UP, null); 
            	// for every index in the instance qualifier array list
            				for(int i = 0; i < indices.size(); i++) {
            					// find the instance node in the design with the right index
            					InstanceNode inst = des.getInstance(instName + "(" + indices.get(i) + ")");
            					if(inst!=null){
            						// find its attribute by the name
            						AttributeNode a = inst.getAttribute((name!=null?name.getText():null));
            						if (a!=null) {
            							if(newAttr)
            								warnings.add(input.getSourceName() + " line " + (name!=null?name.getLine():0) + ":" 
            									+ (name!=null?name.getCharPositionInLine():0) + " new attribute already declared in device: " 
            									+ (name!=null?name.getText():null));
            							// overwrite the attribute value
            							if(!a.overwrite((value!=null?value.getText():null)))
            								warnings.add(input.getSourceName() + " line " + (name!=null?name.getLine():0) + ":" 
            									+ (name!=null?name.getCharPositionInLine():0) + " attribute already overwritten: " 
            									+ (name!=null?name.getText():null));
            						} else {
            							// the attribute doesn't exist
            							if(newAttr) {
            								// make a new attribute if explicitly asked to do so
            								AttributeNode newA = new AttributeNode(inst);
            								newA.setName((name!=null?name.getText():null));
            								newA.overwrite((value!=null?value.getText():null));
            								newA.setLocation((name!=null?name.getLine():0), (name!=null?name.getCharPositionInLine():0), input.getSourceName());
            								inst.addAttribute(newA);
            							} else {
            								// report that the attribute is undeclared
            								errors.add(input.getSourceName() + " line " + (name!=null?name.getLine():0) + ":" 
            									+ (name!=null?name.getCharPositionInLine():0) + " attribute undeclared in device: " + (name!=null?name.getText():null));
            							}
            						}
            					} else {
            						// the instance node does not exist
            						errors.add(input.getSourceName() + " line " + (name!=null?name.getLine():0) + ":" 
            									+ (name!=null?name.getCharPositionInLine():0) + " instance is undeclared: " 
            									+ instName + "(" + indices.get(i) + ")");
            					}
            				}
            				// if the attribute is global
            				if (indices.isEmpty()) {
            					// for every instance node with this instance name
            					for (InstanceNode inst : des.getAllInstances(instName)) {
            						// find its attribute by the name
            						AttributeNode a = inst.getAttribute((name!=null?name.getText():null));
            						if (a!=null) {
            							if(newAttr)
            								warnings.add(input.getSourceName() + " line " + (name!=null?name.getLine():0) + ":" 
            									+ (name!=null?name.getCharPositionInLine():0) + " new attribute already declared in device: " 
            									+ (name!=null?name.getText():null));
            							// overwrite the attribute value
            							if(!a.overwrite((value!=null?value.getText():null)))
            								warnings.add(input.getSourceName() + " line " + (name!=null?name.getLine():0) + ":" 
            									+ (name!=null?name.getCharPositionInLine():0) + " attribute already overwritten: " 
            									+ (name!=null?name.getText():null));
            						} else {
            							// the attribute doesn't exist
            							if(newAttr) {
            								// make a new attribute if explicitly asked to do so
            								AttributeNode newA = new AttributeNode(inst);
            								newA.setName((name!=null?name.getText():null));
            								newA.overwrite((value!=null?value.getText():null));
            								newA.setLocation((name!=null?name.getLine():0), (name!=null?name.getCharPositionInLine():0), input.getSourceName());
            								inst.addAttribute(newA);
            							} else {
            								// report that the attribute is undeclared
            								errors.add(input.getSourceName() + " line " + (name!=null?name.getLine():0) + ":" 
            									+ (name!=null?name.getCharPositionInLine():0) + " attribute undeclared in device: " + instName);
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:599:1: pinAssign[DesignNode des, String instName] : ^( EQUALS ( instanceQualifier[instName, indices] )? name= IDENT ( sliceList[slices] )? concatenation[concats, slices.size()] ) ;
    public final void pinAssign(DesignNode des, String instName) throws RecognitionException {
        CommonTree name=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:600:2: ( ^( EQUALS ( instanceQualifier[instName, indices] )? name= IDENT ( sliceList[slices] )? concatenation[concats, slices.size()] ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:600:4: ^( EQUALS ( instanceQualifier[instName, indices] )? name= IDENT ( sliceList[slices] )? concatenation[concats, slices.size()] )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_pinAssign557); 

            	List<Integer> indices = new ArrayList<Integer>();
            				List<Integer> slices = new ArrayList<Integer>();
            				List<String> concats = new ArrayList<String>();
            			

            match(input, Token.DOWN, null); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:609:3: ( instanceQualifier[instName, indices] )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==PERIOD) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:609:3: instanceQualifier[instName, indices]
                    {
                    pushFollow(FOLLOW_instanceQualifier_in_pinAssign581);
                    instanceQualifier(instName, indices);

                    state._fsp--;


                    }
                    break;

            }

            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinAssign587); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:609:52: ( sliceList[slices] )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==COMMA||(LA13_0>=LEFTBRACKET && LA13_0<=COLON)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:609:52: sliceList[slices]
                    {
                    pushFollow(FOLLOW_sliceList_in_pinAssign589);
                    sliceList(slices);

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_concatenation_in_pinAssign596);
            concatenation(concats, slices.size());

            state._fsp--;


            match(input, Token.UP, null); 
            	// process assignments that aren't declared as open
            				if (!concats.get(0).equals("open")) {
            					// check for valid concatenation width
            					if (slices.size()==concats.size()) {
            						// process global array and slice lists
            						if(indices.isEmpty() && slices.isEmpty()) {
            							// iterate over all corresponding instances in the design
            							for(InstanceNode i : des.getAllInstances(instName)) {
            								// obtain list of pins inside each instance with this name and iterate over them
            								List<PinNode> pins = i.getAllPins((name!=null?name.getText():null));
            								for(int j = 0 ; j < pins.size(); j++) {
            									// process non-globals
            									if(!concats.get(j).startsWith("<>")) {
            										// set the pin's net to the net in the concatenation list
            										pins.get(j).setNet(des.getNet(concats.get(j)));
            										// set the concatenation net in the design to the pin
            										des.getNet(concats.get(j)).addPin(pins.get(j));
            									} else {
            										// process globals
            									}
            								}
            							}
            						} else if (slices.isEmpty()) {
            							// process global slice list, arbitrary array list
            						} else if (indices.isEmpty()) {
            							// process global array list, arbitrary slice list
            						} else {
            							// process arbitrary array and slice list.
            						}
            					} else {
            						System.out.println(slices.size() + " " + concats.size());
            						errors.add(input.getSourceName() + " line " + (name!=null?name.getLine():0) + ":" 
            								+ (name!=null?name.getCharPositionInLine():0) + " invalid concatenation width: " + (name!=null?name.getText():null));
            					}
            				} else {
            					// process assignments declared as open (use setOpen())
            				}
            				
            				// for every instance, report any dangling pins (no assigned net, and not declared open)
            			

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:656:1: concatenation[List<String> concats, int width] : ( (first= IDENT ( sliceList[slices] )? (next= IDENT ( sliceList[slices] )? )* ) | ( LEFTANGLE global= IDENT ) | ( 'open' ) ) ;
    public final void concatenation(List<String> concats, int width) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;
        CommonTree global=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:660:2: ( ( (first= IDENT ( sliceList[slices] )? (next= IDENT ( sliceList[slices] )? )* ) | ( LEFTANGLE global= IDENT ) | ( 'open' ) ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:661:4: ( (first= IDENT ( sliceList[slices] )? (next= IDENT ( sliceList[slices] )? )* ) | ( LEFTANGLE global= IDENT ) | ( 'open' ) )
            {
            List<Integer> slices = new ArrayList<Integer>();
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:663:3: ( (first= IDENT ( sliceList[slices] )? (next= IDENT ( sliceList[slices] )? )* ) | ( LEFTANGLE global= IDENT ) | ( 'open' ) )
            int alt17=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt17=1;
                }
                break;
            case LEFTANGLE:
                {
                alt17=2;
                }
                break;
            case 38:
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
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:663:4: (first= IDENT ( sliceList[slices] )? (next= IDENT ( sliceList[slices] )? )* )
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:663:4: (first= IDENT ( sliceList[slices] )? (next= IDENT ( sliceList[slices] )? )* )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:663:5: first= IDENT ( sliceList[slices] )? (next= IDENT ( sliceList[slices] )? )*
                    {
                    first=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenation645); 
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:663:17: ( sliceList[slices] )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==COMMA||(LA14_0>=LEFTBRACKET && LA14_0<=COLON)) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:663:17: sliceList[slices]
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation647);
                            sliceList(slices);

                            state._fsp--;


                            }
                            break;

                    }

                    	if (slices.isEmpty()) {
                    					concats.add((first!=null?first.getText():null));
                    				} else {
                    					for(int i = 0 ; i < slices.size(); i++)
                    						concats.add((first!=null?first.getText():null) + "[" + slices.get(i) + "]");
                    				}
                    			
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:675:3: (next= IDENT ( sliceList[slices] )? )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==IDENT) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:675:4: next= IDENT ( sliceList[slices] )?
                    	    {
                    	    next=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenation678); 
                    	    slices.clear();
                    	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:680:3: ( sliceList[slices] )?
                    	    int alt15=2;
                    	    int LA15_0 = input.LA(1);

                    	    if ( (LA15_0==COMMA||(LA15_0>=LEFTBRACKET && LA15_0<=COLON)) ) {
                    	        alt15=1;
                    	    }
                    	    switch (alt15) {
                    	        case 1 :
                    	            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:680:3: sliceList[slices]
                    	            {
                    	            pushFollow(FOLLOW_sliceList_in_concatenation704);
                    	            sliceList(slices);

                    	            state._fsp--;


                    	            }
                    	            break;

                    	    }

                    	    	if (slices.isEmpty()) {
                    	    					concats.add((next!=null?next.getText():null));
                    	    				} else {
                    	    					for(int i = 0 ; i < slices.size(); i++)
                    	    						concats.add((next!=null?next.getText():null) + "[" + slices.get(i) + "]");
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
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:692:10: ( LEFTANGLE global= IDENT )
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:692:10: ( LEFTANGLE global= IDENT )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:692:11: LEFTANGLE global= IDENT
                    {
                    match(input,LEFTANGLE,FOLLOW_LEFTANGLE_in_concatenation738); 
                    global=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenation742); 

                    }

                    	for(int i = 0; i < width; i++)
                    					concats.add("<>" + (global!=null?global.getText():null));
                    			

                    }
                    break;
                case 3 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:700:5: ( 'open' )
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:700:5: ( 'open' )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:700:6: 'open'
                    {
                    match(input,38,FOLLOW_38_in_concatenation772); 

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:704:1: instanceQualifier[String instName, List<Integer> indices] : ^( PERIOD qualName= IDENT ( arrayList[indices] )? ) ;
    public final void instanceQualifier(String instName, List<Integer> indices) throws RecognitionException {
        CommonTree qualName=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:716:2: ( ^( PERIOD qualName= IDENT ( arrayList[indices] )? ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:716:4: ^( PERIOD qualName= IDENT ( arrayList[indices] )? )
            {
            match(input,PERIOD,FOLLOW_PERIOD_in_instanceQualifier795); 

            match(input, Token.DOWN, null); 
            qualName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instanceQualifier799); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:716:28: ( arrayList[indices] )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==COMMA||LA18_0==COLON||LA18_0==LEFTPAREN) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:716:28: arrayList[indices]
                    {
                    pushFollow(FOLLOW_arrayList_in_instanceQualifier801);
                    arrayList(indices);

                    state._fsp--;


                    }
                    break;

            }


            match(input, Token.UP, null); 
            	// check that the instance qualifier matches
            		    	if (!instName.equals((qualName!=null?qualName.getText():null))) {
            		    		errors.add(input.getSourceName() + " line " + (qualName!=null?qualName.getLine():0) + ":" 
            							+ (qualName!=null?qualName.getCharPositionInLine():0) + " invalid instance qualifier: " + (qualName!=null?qualName.getText():null));
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:728:1: arrayList[List<Integer> indices] : ( ^( COMMA LEFTPAREN first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTPAREN first= INTEGER last= INTEGER ) | ( LEFTPAREN single= INTEGER ) );
    public final void arrayList(List<Integer> indices) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;
        CommonTree last=null;
        CommonTree single=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:739:2: ( ^( COMMA LEFTPAREN first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTPAREN first= INTEGER last= INTEGER ) | ( LEFTPAREN single= INTEGER ) )
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
            case LEFTPAREN:
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
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:739:4: ^( COMMA LEFTPAREN first= INTEGER (next= INTEGER )* )
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_arrayList840); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList842); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList846); 
                    indices.add(Integer.parseInt((first!=null?first.getText():null)));
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:740:8: (next= INTEGER )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==INTEGER) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:740:9: next= INTEGER
                    	    {
                    	    next=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList861); 
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
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:742:5: ^( COLON LEFTPAREN first= INTEGER last= INTEGER )
                    {
                    match(input,COLON,FOLLOW_COLON_in_arrayList888); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList890); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList894); 
                    last=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList898); 
                    	int msb = Integer.parseInt((first!=null?first.getText():null));
                    				int lsb = Integer.parseInt((last!=null?last.getText():null));
                    				if (msb <= lsb) {	
                            			for (int i = msb; i <= lsb; i++)
                              				indices.add(i);
                          			}
                          			else {
                            			for (int i = msb; i >= lsb; i--) 
                            				indices.add(i);
                          			}
                    			

                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:759:4: ( LEFTPAREN single= INTEGER )
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:759:4: ( LEFTPAREN single= INTEGER )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:759:5: LEFTPAREN single= INTEGER
                    {
                    match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList928); 
                    single=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList932); 
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:762:1: sliceList[List<Integer> slices] : ( ^( COMMA LEFTBRACKET first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTBRACKET first= INTEGER last= INTEGER ) | ( LEFTBRACKET single= INTEGER ) );
    public final void sliceList(List<Integer> slices) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;
        CommonTree last=null;
        CommonTree single=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:773:2: ( ^( COMMA LEFTBRACKET first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTBRACKET first= INTEGER last= INTEGER ) | ( LEFTBRACKET single= INTEGER ) )
            int alt22=3;
            switch ( input.LA(1) ) {
            case COMMA:
                {
                alt22=1;
                }
                break;
            case COLON:
                {
                alt22=2;
                }
                break;
            case LEFTBRACKET:
                {
                alt22=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:773:4: ^( COMMA LEFTBRACKET first= INTEGER (next= INTEGER )* )
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_sliceList956); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList958); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList962); 
                    slices.add(Integer.parseInt((first!=null?first.getText():null)));
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:774:8: (next= INTEGER )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==INTEGER) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:774:9: next= INTEGER
                    	    {
                    	    next=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList978); 
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
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:776:4: ^( COLON LEFTBRACKET first= INTEGER last= INTEGER )
                    {
                    match(input,COLON,FOLLOW_COLON_in_sliceList1005); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList1007); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1011); 
                    last=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1015); 
                    	int msb = Integer.parseInt((first!=null?first.getText():null));
                    				int lsb = Integer.parseInt((last!=null?last.getText():null));
                    			
                    				if (msb <= lsb) {	
                    					// increment for up slice lists
                            			for (int i = msb; i <= lsb; i++)
                              				slices.add(i);
                          			} else {
                          				// decrement for down slice lists
                            			for (int i = msb; i >= lsb; i--)
                               				slices.add(i);
                          			}
                    			

                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:795:4: ( LEFTBRACKET single= INTEGER )
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:795:4: ( LEFTBRACKET single= INTEGER )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:795:5: LEFTBRACKET single= INTEGER
                    {
                    match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList1044); 
                    single=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1048); 
                    slices.add(Integer.parseInt((single!=null?single.getText():null)));

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
    // $ANTLR end "sliceList"


    // $ANTLR start "pinList"
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:799:1: pinList[List<String> pList] : first= ( PIN | INTEGER | IDENT ) (next= ( PIN | INTEGER | IDENT ) )* ;
    public final void pinList(List<String> pList) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:810:2: (first= ( PIN | INTEGER | IDENT ) (next= ( PIN | INTEGER | IDENT ) )* )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:810:4: first= ( PIN | INTEGER | IDENT ) (next= ( PIN | INTEGER | IDENT ) )*
            {
            first=(CommonTree)input.LT(1);
            if ( input.LA(1)==IDENT||(input.LA(1)>=PIN && input.LA(1)<=INTEGER) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            	// maintain a set of pin numbers to check for duplicates in the pin list
            				Set<String> pins = new HashSet<String>();
            				if(!pins.add((first!=null?first.getText():null)))
            					errors.add(input.getSourceName() + " line " + (first!=null?first.getLine():0) + ":" 
            						+ (first!=null?first.getCharPositionInLine():0) + " duplicate found in pin list");
            				pList.add((first!=null?first.getText():null));
            			
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:822:7: (next= ( PIN | INTEGER | IDENT ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==IDENT||(LA23_0>=PIN && LA23_0<=INTEGER)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:822:8: next= ( PIN | INTEGER | IDENT )
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
        "\1\3\1\uffff\1\2\1\4\1\uffff\1\2\2\4\1\uffff\1\3\2\2\1\16\1\4\2"+
        "\24\1\3\2\16\1\3\1\16\4\3";
    static final String DFA9_maxS =
        "\1\6\1\uffff\1\2\1\45\1\uffff\1\2\1\46\1\4\1\uffff\1\24\2\2\1\16"+
        "\1\4\2\24\1\3\5\16\3\3";
    static final String DFA9_acceptS =
        "\1\uffff\1\3\2\uffff\1\1\3\uffff\1\2\20\uffff";
    static final String DFA9_specialS =
        "\31\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\1\2\uffff\1\2",
            "",
            "\1\3",
            "\1\6\3\uffff\1\5\34\uffff\1\4",
            "",
            "\1\7",
            "\1\10\2\uffff\1\4\2\uffff\1\10\4\uffff\1\10\1\uffff\2\10\23"+
            "\uffff\1\10",
            "\1\11",
            "",
            "\1\15\13\uffff\1\12\2\uffff\1\13\1\uffff\1\14",
            "\1\16",
            "\1\17",
            "\1\20",
            "\1\6",
            "\1\21",
            "\1\22",
            "\1\15",
            "\1\23",
            "\1\24",
            "\1\26\12\uffff\1\25",
            "\1\27",
            "\1\26\12\uffff\1\25",
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
            return "()* loopback of 489:3: ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )*";
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
    public static final BitSet FOLLOW_STRING_in_attributeDecl232 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_33_in_pinDecl269 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl294 = new BitSet(new long[]{0x000000000006E010L});
    public static final BitSet FOLLOW_sliceList_in_pinDecl296 = new BitSet(new long[]{0x000000000006E010L});
    public static final BitSet FOLLOW_pinList_in_pinDecl300 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_34_in_netDecl334 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_netDecl359 = new BitSet(new long[]{0x0000000100068008L});
    public static final BitSet FOLLOW_sliceList_in_netDecl361 = new BitSet(new long[]{0x0000000100000008L});
    public static final BitSet FOLLOW_attributeDecl_in_netDecl365 = new BitSet(new long[]{0x0000000100000008L});
    public static final BitSet FOLLOW_35_in_instDecl401 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_instDecl425 = new BitSet(new long[]{0x0000000000148010L});
    public static final BitSet FOLLOW_arrayList_in_instDecl427 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instDecl433 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_attrAssign_in_instDecl455 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_pinAssign_in_instDecl460 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_EQUALS_in_attrAssign481 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_37_in_attrAssign505 = new BitSet(new long[]{0x0000000000000110L});
    public static final BitSet FOLLOW_instanceQualifier_in_attrAssign512 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attrAssign521 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_in_attrAssign525 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssign557 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_instanceQualifier_in_pinAssign581 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinAssign587 = new BitSet(new long[]{0x0000004000068410L});
    public static final BitSet FOLLOW_sliceList_in_pinAssign589 = new BitSet(new long[]{0x0000004000068410L});
    public static final BitSet FOLLOW_concatenation_in_pinAssign596 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENT_in_concatenation645 = new BitSet(new long[]{0x0000000000068012L});
    public static final BitSet FOLLOW_sliceList_in_concatenation647 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_IDENT_in_concatenation678 = new BitSet(new long[]{0x0000000000068012L});
    public static final BitSet FOLLOW_sliceList_in_concatenation704 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_LEFTANGLE_in_concatenation738 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_concatenation772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_instanceQualifier795 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_instanceQualifier799 = new BitSet(new long[]{0x0000000000148008L});
    public static final BitSet FOLLOW_arrayList_in_instanceQualifier801 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMMA_in_arrayList840 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList842 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList846 = new BitSet(new long[]{0x0000000000004008L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList861 = new BitSet(new long[]{0x0000000000004008L});
    public static final BitSet FOLLOW_COLON_in_arrayList888 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList890 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList894 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList898 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList928 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_sliceList956 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList958 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList962 = new BitSet(new long[]{0x0000000000004008L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList978 = new BitSet(new long[]{0x0000000000004008L});
    public static final BitSet FOLLOW_COLON_in_sliceList1005 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList1007 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1011 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1015 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList1044 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_pinList1074 = new BitSet(new long[]{0x0000000000006012L});
    public static final BitSet FOLLOW_set_in_pinList1113 = new BitSet(new long[]{0x0000000000006012L});

}