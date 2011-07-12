// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g 2011-07-12 10:43:38

	package phdl.grammar;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "SEMICOLON", "EQUALS", "STRING", "PERIOD", "AMPERSAND", "LEFTANGLE", "RIGHTANGLE", "LEFTBRACE", "PIN", "INTEGER", "COMMA", "RIGHTBRACE", "LEFTBRACKET", "COLON", "RIGHTBRACKET", "LEFTPAREN", "RIGHTPAREN", "CHAR", "DIGIT", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "'design'", "'is'", "'begin'", "'end'", "'device'", "'attr'", "'pin'", "'net'", "'inst'", "'of'", "'newattr'", "'this'", "'open'"
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
    public static final int T__39=39;
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
    public String getGrammarFileName() { return "C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g"; }



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
    	 * Sets to check for duplicates while processing everything
    	 */
    	private Set<String> attrDecls = new HashSet<String>();
    	private Set<String> pinDecls = new HashSet<String>();
    	private Set<String> netDecls = new HashSet<String>();
    	private Set<String> instanceDecls = new HashSet<String>();
    	
    	/**
    	 * Called to obtain the errors if any exist after walking and processing the tree
    	 */
    	public SortedSet<String> getErrors() {
    		return errors;
    	}
    	
    	/**
    	 * Called to obtain the warnings if any exist after walking and processing the tree
    	 */
    	public SortedSet<String> getWarnings() {
    		return warnings;
    	}
    	
    	/**
    	 * Adds an error from a Node object
    	 */
    	private void addError(Node n, String message) {
    		errors.add(n.getFileName() + " line " + n.getLine() + ":" 
    				+ n.getPosition() + " " + message + ": " + n.getName());
    	}
    	
    	/**
    	 * Adds an error from a CommonTree object
    	 */
    	private void addError(CommonTree ct, String message) {
    		errors.add(input.getSourceName() + " line " + ct.getLine() + ":" 
    				+ ct.getCharPositionInLine() + " " + message + ": " + ct.getText());
    	}
    	
    	/**
    	 * Reports an error from a Node object exits
    	 */
    	private void reportError(Node n, String message) {
    		System.out.println("ERROR: " + n.getFileName() + " line " + n.getLine() + ":" 
    				+ n.getPosition() + " " + message + ": " + n.getName());
    		System.exit(1);
    	}
    	
    	/**
    	 * Reports an error from a CommonTree object and exits
    	 */
    	private void reportError(CommonTree ct, String message) {
    		System.out.println("ERROR: " + input.getSourceName() + " line " + ct.getLine() + ":" 
    				+ ct.getCharPositionInLine() + " " + message + ": " + ct.getText());
    		System.exit(1);
    	}
    	
    	/**
    	 * Adds a warning from a Node object
    	 */
    	private void addWarning(Node n, String message) {
    		warnings.add(n.getFileName() + " line " + n.getLine() + ":" 
    				+ n.getPosition() + " " + message + ": " + n.getName());
    	}
    	
    	/**
    	 * Adds a warning from a CommonTree object
    	 */
    	private void addWarning(CommonTree ct, String message) {
    		warnings.add(input.getSourceName() + " line " + ct.getLine() + ":" 
    				+ ct.getCharPositionInLine() + " " + message + ": " + ct.getText());
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
    	 * Helper method for the pinAssignment rule.  Given a list of slices, concats, an instance node, and a pinNode
    	 * it assigns all relevant pins to their respective net.
    	 */
    	private void assignPins(List<Integer> slices, List<NetNode> concats, InstanceNode inst, CommonTree pinNode) {
    		String pinName = pinNode.getText();
    		if (slices.isEmpty()) {
    			if (concats.size() == 1) {
    				PinNode p = inst.getPin(pinName);
    				if (p != null) {
    					if (p.hasNet())
    						addWarning(pinNode, "pin " + p.getIndex() + " already assigned");
    					p.setNet(concats.get(0));
    					if (concats.get(0) != null)
    						concats.get(0).addPin(p);
    				} else {
    					addError(pinNode, "pin undeclared in device");
    				}
    			} else {
    				reportError(pinNode, "invalid assignment, left size is " 
    						+ slices.size() + " right size is " + concats.size());
    			}
    		} else {
    			if (concats.size() == slices.size()) {
    				// assign pins
    				for (int i = 0; i < concats.size(); i++) {
    					PinNode p = inst.getPin(pinName + "[" + slices.get(i) + "]");
    					if (p != null) { 
    						if (p.hasNet())
    							addWarning(pinNode, "pin " + p.getIndex() + " already assigned");
    						p.setNet(concats.get(i));
    						if (concats.get(i) != null)
    							concats.get(i).addPin(p);
    					} else {
    						addError(pinNode, "pin undeclared in device");
    					}
    				}
    			} else {
    				reportError(pinNode, "invalid assignment, left size is " 
    						+ slices.size() + " right size is " + concats.size());
    			}
    		}
    	}
    	
    	/**
    	 * Necessary to properly report AST errors without bailing out of the whole application
    	 */
    //	@Override
    //    public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
    //        String hdr = getErrorHeader(e);
    //        String msg = getErrorMessage(e, tokenNames);
    //        errors.add(input.getSourceName() + hdr + " " + msg);
    //    }
        
    //    @Override
    //    protected Object recoverFromMismatchedToken(IntStream input,
    //                                            int ttype,
    //                                            BitSet follow)
    //    throws RecognitionException
    //	{   
    //    	throw new MismatchedTokenException(ttype, input);
    //	}  



    // $ANTLR start "sourceText"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:217:1: sourceText : ( designDecl )* ;
    public final void sourceText() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:224:2: ( ( designDecl )* )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:224:4: ( designDecl )*
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:224:4: ( designDecl )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==27) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:224:4: designDecl
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:227:1: designDecl : ^( 'design' desName= IDENT ( deviceDecl[des] | netDecl[des] )* 'begin' ( instDecl[des] | netAssign[des] )* (endName= IDENT )? ) ;
    public final void designDecl() throws RecognitionException {
        CommonTree desName=null;
        CommonTree endName=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:240:2: ( ^( 'design' desName= IDENT ( deviceDecl[des] | netDecl[des] )* 'begin' ( instDecl[des] | netAssign[des] )* (endName= IDENT )? ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:240:4: ^( 'design' desName= IDENT ( deviceDecl[des] | netDecl[des] )* 'begin' ( instDecl[des] | netAssign[des] )* (endName= IDENT )? )
            {
            match(input,27,FOLLOW_27_in_designDecl76); 

            match(input, Token.DOWN, null); 
            desName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_designDecl80); 
            	// make a new design based on the identifier and log its location
            				DesignNode des = new DesignNode();
            				des.setName((desName!=null?desName.getText():null));
            				des.setLocation((desName!=null?desName.getLine():0), (desName!=null?desName.getCharPositionInLine():0), input.getSourceName());
            				
            				// clear these sets each time a design is processed
            				netDecls.clear();
            				instanceDecls.clear();
            			
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:254:3: ( deviceDecl[des] | netDecl[des] )*
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:254:4: deviceDecl[des]
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_designDecl104);
            	    deviceDecl(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:254:22: netDecl[des]
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:254:45: ( instDecl[des] | netAssign[des] )*
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:254:46: instDecl[des]
            	    {
            	    pushFollow(FOLLOW_instDecl_in_designDecl117);
            	    instDecl(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:254:62: netAssign[des]
            	    {
            	    pushFollow(FOLLOW_netAssign_in_designDecl122);
            	    netAssign(des);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:254:79: (endName= IDENT )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==IDENT) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:254:80: endName= IDENT
                    {
                    endName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_designDecl130); 

                    }
                    break;

            }


            match(input, Token.UP, null); 
            	// check the optional trailing label on the design to see if it maches
            				if (endName != null) {
            					if (!(desName!=null?desName.getText():null).equals((endName!=null?endName.getText():null)))
            						addError(endName, "design name " + (desName!=null?desName.getText():null) + " does not match");
            				}
            			
            				// add the design node and report if there are duplicates
            				if(!designNodes.add(des))
            					addError(des, "duplicate design unit");
            					
            				// report any unused device declarations
            				for (DeviceNode dev : des.getDevices()) {
            					if (!des.isDeviceInstanced(dev))
            						addWarning(dev, "unused device declaration");
            				}
            				
            				Set<String> refDezs = new HashSet<String>();
            				
            				// report any dangling pins in all instances
            				for (InstanceNode i : des.getInstances()) {
            					for (PinNode p : i.getPins()) {
            						if (!p.hasNet())
            							addError(i, "dangling pin " + p.getName() + " in instance");
            					}
            					
            					// report duplicate reference designators
            					
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
    // $ANTLR end "designDecl"


    // $ANTLR start "deviceDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:290:1: deviceDecl[DesignNode des] : ^( 'device' devName= IDENT ( attributeDecl[dev] | pinDecl[dev] )* (endName= IDENT )? ) ;
    public final void deviceDecl(DesignNode des) throws RecognitionException {
        CommonTree devName=null;
        CommonTree endName=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:302:2: ( ^( 'device' devName= IDENT ( attributeDecl[dev] | pinDecl[dev] )* (endName= IDENT )? ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:302:4: ^( 'device' devName= IDENT ( attributeDecl[dev] | pinDecl[dev] )* (endName= IDENT )? )
            {
            match(input,31,FOLLOW_31_in_deviceDecl166); 

            match(input, Token.DOWN, null); 
            devName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl170); 
            	// make a new device based on the identifier and log its location
            				DeviceNode dev = new DeviceNode(des);
            				dev.setName((devName!=null?devName.getText():null));
            				dev.setLocation((devName!=null?devName.getLine():0), (devName!=null?devName.getCharPositionInLine():0), input.getSourceName());
            				
            				// clear these sets each time a device is processed
            				attrDecls.clear();
            				pinDecls.clear();
            			
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:316:3: ( attributeDecl[dev] | pinDecl[dev] )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==32) ) {
                    alt5=1;
                }
                else if ( (LA5_0==33) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:316:4: attributeDecl[dev]
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_deviceDecl197);
            	    attributeDecl(dev);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:316:25: pinDecl[dev]
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl202);
            	    pinDecl(dev);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:316:47: (endName= IDENT )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==IDENT) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:316:47: endName= IDENT
                    {
                    endName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl209); 

                    }
                    break;

            }


            match(input, Token.UP, null); 
            	// check the optional trailing label on the device to see if it maches
            				if (endName != null) {
            					if (!(devName!=null?devName.getText():null).equals((endName!=null?endName.getText():null)))
            						addError(endName, "device name " + (devName!=null?devName.getText():null) + " does not match");
            				}
            			
            				// report any missing required attributes
            				for(String s : reqAttrs) {
            					s = s.toUpperCase();
            					if(dev.getAttribute(s)==null)
            						addError(devName, "required attribute \"" + s + "\" missing in device");
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:339:1: attributeDecl[Attributable dev] : ^( 'attr' attrName= IDENT attrValue= STRING ) ;
    public final void attributeDecl(Attributable dev) throws RecognitionException {
        CommonTree attrName=null;
        CommonTree attrValue=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:350:2: ( ^( 'attr' attrName= IDENT attrValue= STRING ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:350:4: ^( 'attr' attrName= IDENT attrValue= STRING )
            {
            match(input,32,FOLLOW_32_in_attributeDecl242); 

            match(input, Token.DOWN, null); 
            attrName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attributeDecl246); 
            attrValue=(CommonTree)match(input,STRING,FOLLOW_STRING_in_attributeDecl250); 

            match(input, Token.UP, null); 
            	// make a new attribute node, assign its parent, and log its location
            	    		AttributeNode a  = new AttributeNode(dev);
            	    		a.setName((attrName!=null?attrName.getText():null));
            				a.setValue((attrValue!=null?attrValue.getText():null));
            	    		a.setLocation((attrName!=null?attrName.getLine():0), (attrName!=null?attrName.getCharPositionInLine():0), input.getSourceName());
            				dev.addAttribute(a);
            				
            				// report any duplicate attribute declarations
            				if(!attrDecls.add((attrName!=null?attrName.getText():null).toUpperCase()))
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:367:1: pinDecl[DeviceNode dev] : ^( 'pin' ( sliceList[sList] )? pinName= IDENT pinList[pList] ) ;
    public final void pinDecl(DeviceNode dev) throws RecognitionException {
        CommonTree pinName=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:385:2: ( ^( 'pin' ( sliceList[sList] )? pinName= IDENT pinList[pList] ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:385:4: ^( 'pin' ( sliceList[sList] )? pinName= IDENT pinList[pList] )
            {
            match(input,33,FOLLOW_33_in_pinDecl287); 

             	// sets to keep track of the slice and pin lists
            				List<Integer> sList = new ArrayList<Integer>(); 
            				List<String> pList = new ArrayList<String>();
            			

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:394:3: ( sliceList[sList] )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==COMMA||(LA7_0>=LEFTBRACKET && LA7_0<=COLON)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:394:3: sliceList[sList]
                    {
                    pushFollow(FOLLOW_sliceList_in_pinDecl310);
                    sliceList(sList);

                    state._fsp--;


                    }
                    break;

            }

            pinName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinDecl316); 
            pushFollow(FOLLOW_pinList_in_pinDecl318);
            pinList(pList);

            state._fsp--;


            match(input, Token.UP, null); 
            	// list sizes should only differ if there is no slice list, and the pin list has a size of 1
            				if (sList.size() != pList.size()) {
            					if (sList.size() == 0 && pList.size() != 1)
            						addError(pinName, "invalid pin list");
            					if (sList.size() != 0)
            						addError(pinName, "invalid pin list");
            				}
            				
            				// make new pin nodes for all slices by appending the slice reference in brackets to the name
            	        	for (int i = 0; i < sList.size(); i++) {
            	        		PinNode newPin = new PinNode(dev);
            	        		newPin.setName((pinName!=null?pinName.getText():null) + "[" + sList.get(i) + "]");
            					newPin.setLocation((pinName!=null?pinName.getLine():0), (pinName!=null?pinName.getCharPositionInLine():0), input.getSourceName());
            	        		
            	        		// accessing an invalid pin list may cause an exception
            	        		try{
            						newPin.setPinName(pList.get(i));
            					} catch (IndexOutOfBoundsException e) {
            						addError(pinName, "invalid pin list");
            					}
            					
            					// report any duplicate pin declarations
            					if (!dev.addPin(newPin))
            	            		addError(newPin, "duplicate pin declaration");
            				}
            				
            				// otherwise make a new pin node directly from the name
            				if (sList.isEmpty()) {
            					PinNode newPin = new PinNode(dev);
            					newPin.setName((pinName!=null?pinName.getText():null));
            					newPin.setLocation((pinName!=null?pinName.getLine():0), (pinName!=null?pinName.getCharPositionInLine():0), input.getSourceName());
            					
            					// accessing an invalid pin list may cause an exception
            					try{
            						newPin.setPinName(pList.get(0));
            					} catch (IndexOutOfBoundsException e) {
            						addError(pinName, "invalid pin list");
            					}
            					
            					// report any duplicate pin declarations
            					if (!dev.addPin(newPin))
            	            		addError(newPin, "duplicate pin declaration");
            				}
            				
            				// check for overall duplicates based solely on the name
            				if (!pinDecls.add((pinName!=null?pinName.getText():null)))
            					addError(pinName, "duplicate pin declaration");
            			

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:448:1: netDecl[DesignNode des] : ^( 'net' ( sliceList[slices] )? netName= IDENT ( attributeDecl[n] )* (endName= IDENT )? ) ;
    public final void netDecl(DesignNode des) throws RecognitionException {
        CommonTree netName=null;
        CommonTree endName=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:457:2: ( ^( 'net' ( sliceList[slices] )? netName= IDENT ( attributeDecl[n] )* (endName= IDENT )? ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:457:4: ^( 'net' ( sliceList[slices] )? netName= IDENT ( attributeDecl[n] )* (endName= IDENT )? )
            {
            match(input,34,FOLLOW_34_in_netDecl352); 

            	// housekeeping
            				List<Integer> slices = new ArrayList<Integer>();
            				NetNode n = new NetNode(null);
            				attrDecls.clear();
            			

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:467:3: ( sliceList[slices] )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==COMMA||(LA8_0>=LEFTBRACKET && LA8_0<=COLON)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:467:3: sliceList[slices]
                    {
                    pushFollow(FOLLOW_sliceList_in_netDecl375);
                    sliceList(slices);

                    state._fsp--;


                    }
                    break;

            }

            netName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netDecl381); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:467:36: ( attributeDecl[n] )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==32) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:467:36: attributeDecl[n]
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_netDecl383);
            	    attributeDecl(n);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:467:61: (endName= IDENT )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==IDENT) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:467:61: endName= IDENT
                    {
                    endName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netDecl389); 

                    }
                    break;

            }


            match(input, Token.UP, null); 
            	// check the optional trailing label on the net to see if it maches
            				if (endName != null) {
            					if (!(netName!=null?netName.getText():null).equals((endName!=null?endName.getText():null)))
            						addError(endName, "net name " + (netName!=null?netName.getText():null) + " does not match");
            				}
            			
            				// make net nodes based on the slice list
            				for (int i = 0; i < slices.size(); i++) {
            					NetNode newNode = new NetNode(des);
            					newNode.setName((netName!=null?netName.getText():null) + "[" + slices.get(i) + "]");
            					newNode.setLocation((netName!=null?netName.getLine():0), (netName!=null?netName.getCharPositionInLine():0), input.getSourceName());
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
            					newNode.setName((netName!=null?netName.getText():null));
            					newNode.setLocation((netName!=null?netName.getLine():0), (netName!=null?netName.getCharPositionInLine():0), input.getSourceName());
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
            				if (!netDecls.add((netName!=null?netName.getText():null)))
            					addError(netName, "duplicate net declaration");
            			

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:521:1: instDecl[DesignNode des] : ^( 'inst' ( arrayList[indices] )? instName= IDENT devName= IDENT ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )* (endName= IDENT )? ) ;
    public final void instDecl(DesignNode des) throws RecognitionException {
        CommonTree instName=null;
        CommonTree devName=null;
        CommonTree endName=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:532:2: ( ^( 'inst' ( arrayList[indices] )? instName= IDENT devName= IDENT ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )* (endName= IDENT )? ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:532:4: ^( 'inst' ( arrayList[indices] )? instName= IDENT devName= IDENT ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )* (endName= IDENT )? )
            {
            match(input,35,FOLLOW_35_in_instDecl423); 

            	// Set of instance nodes to check for duplicates
            				List<InstanceNode> instNodes = new ArrayList<InstanceNode>();
            				// List of indices to be derived from the arrayList
            				List<Integer> indices = new ArrayList<Integer>();
            			

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:542:3: ( arrayList[indices] )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==COMMA||LA11_0==COLON||LA11_0==LEFTPAREN) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:542:3: arrayList[indices]
                    {
                    pushFollow(FOLLOW_arrayList_in_instDecl445);
                    arrayList(indices);

                    state._fsp--;


                    }
                    break;

            }

            instName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl451); 
            devName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl455); 
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
            							i.addPin(new PinNode(pn, i));
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
            							i.addPin(new PinNode(pn, i));
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
            					addError(instName, "duplicate instance declaration");
            			
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:600:3: ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )*
            loop12:
            do {
                int alt12=3;
                alt12 = dfa12.predict(input);
                switch (alt12) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:600:4: attrAssign[des, $instName.text]
            	    {
            	    pushFollow(FOLLOW_attrAssign_in_instDecl477);
            	    attrAssign(des, (instName!=null?instName.getText():null));

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:600:38: pinAssign[des, $instName.text]
            	    {
            	    pushFollow(FOLLOW_pinAssign_in_instDecl482);
            	    pinAssign(des, (instName!=null?instName.getText():null));

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:600:78: (endName= IDENT )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==IDENT) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:600:78: endName= IDENT
                    {
                    endName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl489); 

                    }
                    break;

            }


            match(input, Token.UP, null); 
            	// check the optional trailing label on the design to see if it maches
            				if (endName != null) {
            					if (!(instName!=null?instName.getText():null).equals((endName!=null?endName.getText():null)))
            						addError(endName, "inst name " + (instName!=null?instName.getText():null) + " does not match");
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


    // $ANTLR start "attrAssign"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:613:1: attrAssign[DesignNode des, String instName] : ^( EQUALS ( 'newattr' )? ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] ) attrName= IDENT attrValue= STRING ) ;
    public final void attrAssign(DesignNode des, String instName) throws RecognitionException {
        CommonTree attrName=null;
        CommonTree attrValue=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:630:2: ( ^( EQUALS ( 'newattr' )? ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] ) attrName= IDENT attrValue= STRING ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:630:4: ^( EQUALS ( 'newattr' )? ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] ) attrName= IDENT attrValue= STRING )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_attrAssign523); 

            	// flag for a new attribute and a list of indices the attribute assignment applies to
            				boolean newAttr = false;
            				List<Integer> indices = new ArrayList<Integer>();
            			

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:639:3: ( 'newattr' )?
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==37) ) {
                    alt14=1;
                }
                switch (alt14) {
                    case 1 :
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:639:4: 'newattr'
                        {
                        match(input,37,FOLLOW_37_in_attrAssign547); 
                        newAttr = true;

                        }
                        break;

                }

                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:640:3: ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] )
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==PERIOD) ) {
                    alt15=1;
                }
                else if ( ((LA15_0>=UP && LA15_0<=IDENT)) ) {
                    alt15=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 0, input);

                    throw nvae;
                }
                switch (alt15) {
                    case 1 :
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:640:4: instanceQualifier[instName, indices, des]
                        {
                        pushFollow(FOLLOW_instanceQualifier_in_attrAssign558);
                        instanceQualifier(instName, indices, des);

                        state._fsp--;


                        }
                        break;
                    case 2 :
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:640:48: arrayIndices[indices, instName, des]
                        {
                        pushFollow(FOLLOW_arrayIndices_in_attrAssign563);
                        arrayIndices(indices, instName, des);

                        state._fsp--;


                        }
                        break;

                }

                attrName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attrAssign571); 
                attrValue=(CommonTree)match(input,STRING,FOLLOW_STRING_in_attrAssign575); 

                match(input, Token.UP, null); 
            }
            	// for every index in the instance qualifier array list
            				for(int i = 0; i < indices.size(); i++) {
            					// find the instance node in the design with the right index
            					InstanceNode inst = des.getInstance(instName + "(" + indices.get(i) + ")");
            					if(inst!=null){
            						// find its attribute by the attribute name
            						AttributeNode a = inst.getAttribute((attrName!=null?attrName.getText():null));
            						if (a!=null) {
            							if(newAttr)
            								addWarning(attrName, "new attribute already declared in device");
            							// overwrite the attribute value
            							if(!a.overwrite((attrValue!=null?attrValue.getText():null)))
            								addWarning(attrName, "atribute already overwritten");
            						} else {
            							// the attribute doesn't exist
            							if(newAttr) {
            								// make a new attribute if explicitly asked to do so
            								AttributeNode newA = new AttributeNode(inst);
            								newA.setName((attrName!=null?attrName.getText():null));
            								newA.overwrite((attrValue!=null?attrValue.getText():null));
            								newA.setLocation((attrName!=null?attrName.getLine():0), (attrName!=null?attrName.getCharPositionInLine():0), input.getSourceName());
            								inst.addAttribute(newA);
            							} else {
            								if ((attrName!=null?attrName.getText():null).toUpperCase().equals("REFDES")) {
            									AttributeNode newA = new AttributeNode(inst);
            									newA.setName((attrName!=null?attrName.getText():null));
            									newA.setValue((attrValue!=null?attrValue.getText():null));
            									newA.setLocation((attrName!=null?attrName.getLine():0), (attrName!=null?attrName.getCharPositionInLine():0), input.getSourceName());
            									inst.addAttribute(newA);
            								} else {
            									// report that the attribute is undeclared
            									addError(attrName, "attribute undeclared in device");
            								}
            							}
            						}
            					} else {
            						// the instance node does not exist
            						addError(attrName, "instance " + instName + "(" + indices.get(i) + ")" + " is undeclared");
            					}
            				}
            				// if the attribute is global
            				if (indices.isEmpty()) {
            					// for every instance node with this instance name
            					for (InstanceNode inst : des.getAllInstances(instName)) {
            						// find its attribute by the attribute name
            						AttributeNode a = inst.getAttribute((attrName!=null?attrName.getText():null));
            						if (a!=null) {
            							if(newAttr)
            								addWarning(attrName, "new attribute already declared in device");
            							// overwrite the attribute value
            							if(!a.overwrite((attrValue!=null?attrValue.getText():null)))
            								addWarning(attrName, "atribute already overwritten");
            						} else {
            							// the attribute doesn't exist
            							if(newAttr) {
            								// make a new attribute if explicitly asked to do so
            								AttributeNode newA = new AttributeNode(inst);
            								newA.setName((attrName!=null?attrName.getText():null));
            								newA.overwrite((attrValue!=null?attrValue.getText():null));
            								newA.setLocation((attrName!=null?attrName.getLine():0), (attrName!=null?attrName.getCharPositionInLine():0), input.getSourceName());
            								inst.addAttribute(newA);
            							} else {
            								// report that the attribute is undeclared
            								addError(attrName, "instance " + instName + " is undeclared");
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:716:1: pinAssign[DesignNode des, String instName] : ^( EQUALS ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] ) pinName= IDENT ( sliceList[slices] | pinSlices[slices, $pinName.text, des, instName] ) concatenation[concats, slices.size(), des] ) ;
    public final void pinAssign(DesignNode des, String instName) throws RecognitionException {
        CommonTree pinName=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:717:2: ( ^( EQUALS ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] ) pinName= IDENT ( sliceList[slices] | pinSlices[slices, $pinName.text, des, instName] ) concatenation[concats, slices.size(), des] ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:717:4: ^( EQUALS ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] ) pinName= IDENT ( sliceList[slices] | pinSlices[slices, $pinName.text, des, instName] ) concatenation[concats, slices.size(), des] )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_pinAssign606); 

            	List<Integer> indices = new ArrayList<Integer>();
            				List<Integer> slices = new ArrayList<Integer>();
            				List<NetNode> concats = new ArrayList<NetNode>();
            			

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:726:3: ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] )
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==PERIOD) ) {
                    alt16=1;
                }
                else if ( ((LA16_0>=UP && LA16_0<=IDENT)) ) {
                    alt16=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 0, input);

                    throw nvae;
                }
                switch (alt16) {
                    case 1 :
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:726:4: instanceQualifier[instName, indices, des]
                        {
                        pushFollow(FOLLOW_instanceQualifier_in_pinAssign631);
                        instanceQualifier(instName, indices, des);

                        state._fsp--;


                        }
                        break;
                    case 2 :
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:726:48: arrayIndices[indices, instName, des]
                        {
                        pushFollow(FOLLOW_arrayIndices_in_pinAssign636);
                        arrayIndices(indices, instName, des);

                        state._fsp--;


                        }
                        break;

                }

                pinName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinAssign645); 
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:727:17: ( sliceList[slices] | pinSlices[slices, $pinName.text, des, instName] )
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==COMMA||(LA17_0>=LEFTBRACKET && LA17_0<=COLON)) ) {
                    alt17=1;
                }
                else if ( (LA17_0==IDENT||LA17_0==LEFTANGLE||LA17_0==39) ) {
                    alt17=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 0, input);

                    throw nvae;
                }
                switch (alt17) {
                    case 1 :
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:727:18: sliceList[slices]
                        {
                        pushFollow(FOLLOW_sliceList_in_pinAssign648);
                        sliceList(slices);

                        state._fsp--;


                        }
                        break;
                    case 2 :
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:727:38: pinSlices[slices, $pinName.text, des, instName]
                        {
                        pushFollow(FOLLOW_pinSlices_in_pinAssign653);
                        pinSlices(slices, (pinName!=null?pinName.getText():null), des, instName);

                        state._fsp--;


                        }
                        break;

                }

                pushFollow(FOLLOW_concatenation_in_pinAssign659);
                concatenation(concats, slices.size(), des);

                state._fsp--;


                match(input, Token.UP, null); 
            }
            	
            				// for all the indices in the array list
            				for (int j = 0; j < indices.size(); j++) {
            					// for all isntances with this pinName
            					for (InstanceNode inst : des.getAllInstances(instName)) {
            						// assign pins for only those whose index is in the list of indices
            						if(inst.getIndex() == indices.get(j))
            							assignPins(slices, concats, inst, pinName);
            					}
            				}
            				if (indices.isEmpty()) {
            					
            					InstanceNode inst = des.getInstance(instName);
            					assignPins(slices, concats, inst, pinName);
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


    // $ANTLR start "netAssign"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:751:1: netAssign[DesignNode des] : ^( EQUALS netName= IDENT ( sliceList[slices] | netSlices[slices, $netName.text, des] ) concatenation[concats, slices.size(), des] ) ;
    public final void netAssign(DesignNode des) throws RecognitionException {
        CommonTree netName=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:752:2: ( ^( EQUALS netName= IDENT ( sliceList[slices] | netSlices[slices, $netName.text, des] ) concatenation[concats, slices.size(), des] ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:752:4: ^( EQUALS netName= IDENT ( sliceList[slices] | netSlices[slices, $netName.text, des] ) concatenation[concats, slices.size(), des] )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_netAssign691); 

            	List<Integer> slices = new ArrayList<Integer>();
            				List<NetNode> concats = new ArrayList<NetNode>();
            			

            match(input, Token.DOWN, null); 
            netName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netAssign715); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:760:17: ( sliceList[slices] | netSlices[slices, $netName.text, des] )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==COMMA||(LA18_0>=LEFTBRACKET && LA18_0<=COLON)) ) {
                alt18=1;
            }
            else if ( (LA18_0==IDENT||LA18_0==LEFTANGLE||LA18_0==39) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:760:18: sliceList[slices]
                    {
                    pushFollow(FOLLOW_sliceList_in_netAssign718);
                    sliceList(slices);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:760:38: netSlices[slices, $netName.text, des]
                    {
                    pushFollow(FOLLOW_netSlices_in_netAssign723);
                    netSlices(slices, (netName!=null?netName.getText():null), des);

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_concatenation_in_netAssign729);
            concatenation(concats, slices.size(), des);

            state._fsp--;


            match(input, Token.UP, null); 
            	if (concats.contains(des.getNet("open"))) {
            					reportError(netName, "cannot assign open to a net");
            				}
            				if (slices.isEmpty()) {
            					if (concats.size() == 1) {
            						NetNode n = des.getNet((netName!=null?netName.getText():null));
            						if (n != null) {
            							n.addNet(concats.get(0));
            							concats.get(0).addNet(n);
            						} else {
            							addError(netName, "net undeclared in design");
            						}
            					} else {
            						reportError(netName, "invalid assignment, left width is " 
            								+ slices.size() + " right width is " + concats.size());
            					}
            				} else {
            					if (concats.size() == slices.size()) {
            						for (int i = 0; i < concats.size(); i++) {
            							NetNode n = des.getNet((netName!=null?netName.getText():null) + "[" + slices.get(i) + "]");
            							if (n != null) { 
            								n.addNet(concats.get(i));
            								concats.get(i).addNet(n);
            							} else {
            								addError(netName, "net undeclared in design");
            							}
            						}
            					} else {
            						reportError(netName, "invalid assignment, left width is " 
            								+ slices.size() + " right width is " + concats.size());
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
    // $ANTLR end "netAssign"


    // $ANTLR start "concatenation"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:801:1: concatenation[List<NetNode> concats, int assignWidth, DesignNode des] : ( (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* ) | ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) ) | ( 'open' ) ) ;
    public final void concatenation(List<NetNode> concats, int assignWidth, DesignNode des) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;
        CommonTree global=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:805:2: ( ( (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* ) | ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) ) | ( 'open' ) ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:806:4: ( (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* ) | ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) ) | ( 'open' ) )
            {
            List<Integer> slices = new ArrayList<Integer>();
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:808:3: ( (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* ) | ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) ) | ( 'open' ) )
            int alt23=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt23=1;
                }
                break;
            case LEFTANGLE:
                {
                alt23=2;
                }
                break;
            case 39:
                {
                alt23=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:808:4: (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:808:4: (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:808:5: first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )*
                    {
                    first=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenation781); 
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:808:17: ( sliceList[slices] | concatSlices[slices, $first.text, des] )
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==COMMA||(LA19_0>=LEFTBRACKET && LA19_0<=COLON)) ) {
                        alt19=1;
                    }
                    else if ( ((LA19_0>=UP && LA19_0<=IDENT)) ) {
                        alt19=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 0, input);

                        throw nvae;
                    }
                    switch (alt19) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:808:18: sliceList[slices]
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation784);
                            sliceList(slices);

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:808:38: concatSlices[slices, $first.text, des]
                            {
                            pushFollow(FOLLOW_concatSlices_in_concatenation789);
                            concatSlices(slices, (first!=null?first.getText():null), des);

                            state._fsp--;


                            }
                            break;

                    }

                    	if(slices.size()==0) {
                    					NetNode n = des.getNet((first!=null?first.getText():null));
                    					if (n != null) {
                    						concats.add(n);
                    					} else {
                    						addError(first, "net undeclared in design");
                    						System.out.println("testing");
                    					}
                    				}
                    			
                    				for (int i = 0; i < slices.size(); i++) {
                    					for (NetNode n : des.getAllNets((first!=null?first.getText():null))) {
                    						if (n.getIndex() == slices.get(i)) {
                    							concats.add(n);
                    						}
                    					}
                    				}

                    			
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:832:3: (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==IDENT) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:832:4: next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] )
                    	    {
                    	    next=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenation820); 
                    	    slices.clear();
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:836:3: ( sliceList[slices] | concatSlices[slices, $next.text, des] )
                    	    int alt20=2;
                    	    int LA20_0 = input.LA(1);

                    	    if ( (LA20_0==COMMA||(LA20_0>=LEFTBRACKET && LA20_0<=COLON)) ) {
                    	        alt20=1;
                    	    }
                    	    else if ( ((LA20_0>=UP && LA20_0<=IDENT)) ) {
                    	        alt20=2;
                    	    }
                    	    else {
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 20, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt20) {
                    	        case 1 :
                    	            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:836:4: sliceList[slices]
                    	            {
                    	            pushFollow(FOLLOW_sliceList_in_concatenation844);
                    	            sliceList(slices);

                    	            state._fsp--;


                    	            }
                    	            break;
                    	        case 2 :
                    	            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:836:24: concatSlices[slices, $next.text, des]
                    	            {
                    	            pushFollow(FOLLOW_concatSlices_in_concatenation849);
                    	            concatSlices(slices, (next!=null?next.getText():null), des);

                    	            state._fsp--;


                    	            }
                    	            break;

                    	    }

                    	    	if(slices.size()==0) {
                    	    					NetNode n = des.getNet((next!=null?next.getText():null));
                    	    					if (n != null) {
                    	    						concats.add(n);
                    	    					} else {
                    	    						addError(next, "undeclared net");
                    	    					}
                    	    				}
                    	    				
                    	    				for (int i = 0; i < slices.size(); i++) {
                    	    					for (NetNode n : des.getAllNets((next!=null?next.getText():null))) {
                    	    						if (n.getIndex() == slices.get(i)) {
                    	    							concats.add(n);
                    	    						}
                    	    					}
                    	    				}
                    	    			

                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:858:10: ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:858:10: ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:858:11: LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] )
                    {
                    match(input,LEFTANGLE,FOLLOW_LEFTANGLE_in_concatenation883); 
                    global=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenation887); 
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:858:34: ( sliceList[slices] | concatSlices[slices, $global.text, des] )
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==COMMA||(LA22_0>=LEFTBRACKET && LA22_0<=COLON)) ) {
                        alt22=1;
                    }
                    else if ( ((LA22_0>=UP && LA22_0<=IDENT)) ) {
                        alt22=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 0, input);

                        throw nvae;
                    }
                    switch (alt22) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:858:35: sliceList[slices]
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation890);
                            sliceList(slices);

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:858:55: concatSlices[slices, $global.text, des]
                            {
                            pushFollow(FOLLOW_concatSlices_in_concatenation895);
                            concatSlices(slices, (global!=null?global.getText():null), des);

                            state._fsp--;


                            }
                            break;

                    }


                    }

                    	if (assignWidth==0) assignWidth++;
                    				if (slices.size()==1) {
                    					NetNode n = des.getNet((global!=null?global.getText():null) + "[" + slices.get(0) + "]");
                    					if (n != null) {
                    						for (int i = 0; i < assignWidth; i++) {
                    							concats.add(n);
                    						}
                    					} else {
                    						addError(global, "undeclared net");
                    					}
                    				} else if(slices.isEmpty()) {
                    					NetNode n = des.getNet((global!=null?global.getText():null));
                    					if (n != null) {
                    						for (int i = 0; i < assignWidth; i++) {
                    							concats.add(n);
                    						}
                    					} else {
                    						addError(global, "undeclared net");
                    					}
                    				} else {
                    					addError(global, "assignment cannot replicate a net vector");
                    				}
                    			

                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:886:5: ( 'open' )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:886:5: ( 'open' )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:886:6: 'open'
                    {
                    match(input,39,FOLLOW_39_in_concatenation927); 

                    }

                    	if (assignWidth==0)
                    					assignWidth++;
                    				
                    				NetNode n = des.getNet("open");
                    				if (n == null) {
                    					n = new NetNode(des);
                    					n.setName("open");
                    					n.setLocation(-1,-1, null);
                    					des.addNet(n);
                    				}
                    				
                    				for	(int i = 0; i < assignWidth; i++)
                    					concats.add(n);

                    			

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:908:1: instanceQualifier[String instName, List<Integer> indices, DesignNode des] : ^( PERIOD (qualName= IDENT | ( 'this' ) ) ( arrayList[indices] | arrayIndices[indices, instName, des] ) ) ;
    public final void instanceQualifier(String instName, List<Integer> indices, DesignNode des) throws RecognitionException {
        CommonTree qualName=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:920:2: ( ^( PERIOD (qualName= IDENT | ( 'this' ) ) ( arrayList[indices] | arrayIndices[indices, instName, des] ) ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:920:4: ^( PERIOD (qualName= IDENT | ( 'this' ) ) ( arrayList[indices] | arrayIndices[indices, instName, des] ) )
            {
            boolean isThis = false;
            match(input,PERIOD,FOLLOW_PERIOD_in_instanceQualifier969); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:921:12: (qualName= IDENT | ( 'this' ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==IDENT) ) {
                alt24=1;
            }
            else if ( (LA24_0==38) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:921:13: qualName= IDENT
                    {
                    qualName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instanceQualifier974); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:921:30: ( 'this' )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:921:30: ( 'this' )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:921:31: 'this'
                    {
                    match(input,38,FOLLOW_38_in_instanceQualifier979); 
                    isThis = true;

                    }


                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:921:57: ( arrayList[indices] | arrayIndices[indices, instName, des] )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==COMMA||LA25_0==COLON||LA25_0==LEFTPAREN) ) {
                alt25=1;
            }
            else if ( ((LA25_0>=UP && LA25_0<=IDENT)) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:921:58: arrayList[indices]
                    {
                    pushFollow(FOLLOW_arrayList_in_instanceQualifier986);
                    arrayList(indices);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:921:79: arrayIndices[indices, instName, des]
                    {
                    pushFollow(FOLLOW_arrayIndices_in_instanceQualifier991);
                    arrayIndices(indices, instName, des);

                    state._fsp--;


                    }
                    break;

            }


            match(input, Token.UP, null); 
            	// check that the instance qualifier matches

            				if (!instName.equals((qualName!=null?qualName.getText():null)) && !isThis) {
            				    addError(qualName, "invalid instance qualifier");
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


    // $ANTLR start "arrayIndices"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:934:1: arrayIndices[List<Integer> indices, String instName, DesignNode des] : ;
    public final void arrayIndices(List<Integer> indices, String instName, DesignNode des) throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:935:2: ()
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:935:4: 
            {
            indices.addAll(des.getAllIndices(instName));

            }

        }
        finally {
        }
        return ;
    }
    // $ANTLR end "arrayIndices"


    // $ANTLR start "pinSlices"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:938:1: pinSlices[List<Integer> slices, String pinName, DesignNode des, String instName] : ;
    public final void pinSlices(List<Integer> slices, String pinName, DesignNode des, String instName) throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:939:2: ()
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:939:4: 
            {
            	InstanceNode inst = des.getAllInstances(instName).get(0);
            			List<Integer> pins = inst.getAllIndices(pinName);
            			slices.addAll(pins);
            		

            }

        }
        finally {
        }
        return ;
    }
    // $ANTLR end "pinSlices"


    // $ANTLR start "netSlices"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:945:1: netSlices[List<Integer> slices, String netName, DesignNode des] : ;
    public final void netSlices(List<Integer> slices, String netName, DesignNode des) throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:946:2: ()
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:946:4: 
            {
            	List<Integer> nets = des.getAllNetIndices(netName);
            			slices.addAll(nets);
            		

            }

        }
        finally {
        }
        return ;
    }
    // $ANTLR end "netSlices"


    // $ANTLR start "concatSlices"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:951:1: concatSlices[List<Integer> slices, String netName, DesignNode des] : ;
    public final void concatSlices(List<Integer> slices, String netName, DesignNode des) throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:952:2: ()
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:952:4: 
            {
            slices.addAll(des.getAllNetIndices(netName));

            }

        }
        finally {
        }
        return ;
    }
    // $ANTLR end "concatSlices"


    // $ANTLR start "arrayList"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:955:1: arrayList[List<Integer> indices] : ( ^( COMMA LEFTPAREN first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTPAREN first= INTEGER last= INTEGER ) | ( LEFTPAREN single= INTEGER ) );
    public final void arrayList(List<Integer> indices) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;
        CommonTree last=null;
        CommonTree single=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:966:2: ( ^( COMMA LEFTPAREN first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTPAREN first= INTEGER last= INTEGER ) | ( LEFTPAREN single= INTEGER ) )
            int alt27=3;
            switch ( input.LA(1) ) {
            case COMMA:
                {
                alt27=1;
                }
                break;
            case COLON:
                {
                alt27=2;
                }
                break;
            case LEFTPAREN:
                {
                alt27=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:967:3: ^( COMMA LEFTPAREN first= INTEGER (next= INTEGER )* )
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_arrayList1087); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList1089); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1093); 
                    indices.add(Integer.parseInt((first!=null?first.getText():null)));
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:968:8: (next= INTEGER )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==INTEGER) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:968:9: next= INTEGER
                    	    {
                    	    next=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1108); 
                    	    indices.add(Integer.parseInt((next!=null?next.getText():null)));

                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:971:5: ^( COLON LEFTPAREN first= INTEGER last= INTEGER )
                    {
                    match(input,COLON,FOLLOW_COLON_in_arrayList1143); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList1145); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1149); 
                    last=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1153); 
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:989:4: ( LEFTPAREN single= INTEGER )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:989:4: ( LEFTPAREN single= INTEGER )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:989:5: LEFTPAREN single= INTEGER
                    {
                    match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList1186); 
                    single=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1190); 
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:992:1: sliceList[List<Integer> slices] : ( ^( COMMA LEFTBRACKET first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTBRACKET first= INTEGER last= INTEGER ) | ( LEFTBRACKET single= INTEGER ) );
    public final void sliceList(List<Integer> slices) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;
        CommonTree last=null;
        CommonTree single=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:1003:2: ( ^( COMMA LEFTBRACKET first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTBRACKET first= INTEGER last= INTEGER ) | ( LEFTBRACKET single= INTEGER ) )
            int alt29=3;
            switch ( input.LA(1) ) {
            case COMMA:
                {
                alt29=1;
                }
                break;
            case COLON:
                {
                alt29=2;
                }
                break;
            case LEFTBRACKET:
                {
                alt29=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:1004:3: ^( COMMA LEFTBRACKET first= INTEGER (next= INTEGER )* )
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_sliceList1217); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList1219); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1223); 
                    slices.add(Integer.parseInt((first!=null?first.getText():null)));
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:1005:8: (next= INTEGER )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==INTEGER) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:1005:9: next= INTEGER
                    	    {
                    	    next=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1239); 
                    	    slices.add(Integer.parseInt((next!=null?next.getText():null)));

                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:1008:4: ^( COLON LEFTBRACKET first= INTEGER last= INTEGER )
                    {
                    match(input,COLON,FOLLOW_COLON_in_sliceList1274); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList1276); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1280); 
                    last=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1284); 
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:1028:4: ( LEFTBRACKET single= INTEGER )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:1028:4: ( LEFTBRACKET single= INTEGER )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:1028:5: LEFTBRACKET single= INTEGER
                    {
                    match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList1316); 
                    single=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1320); 
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:1032:1: pinList[List<String> pList] : first= ( PIN | INTEGER | IDENT ) (next= ( PIN | INTEGER | IDENT ) )* ;
    public final void pinList(List<String> pList) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:1043:2: (first= ( PIN | INTEGER | IDENT ) (next= ( PIN | INTEGER | IDENT ) )* )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:1043:4: first= ( PIN | INTEGER | IDENT ) (next= ( PIN | INTEGER | IDENT ) )*
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
            				if (!pins.add((first!=null?first.getText():null)))
            					addError(first, "duplicate pin number in pin list");
            				pList.add((first!=null?first.getText():null));
            			
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:1054:7: (next= ( PIN | INTEGER | IDENT ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==IDENT||(LA30_0>=PIN && LA30_0<=INTEGER)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:1054:8: next= ( PIN | INTEGER | IDENT )
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

            	    	if (!pins.add((next!=null?next.getText():null)))
            	    					addError(next, "duplicate pin number in pin list");
            	    				pList.add((next!=null?next.getText():null));
            	    			

            	    }
            	    break;

            	default :
            	    break loop30;
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


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\32\uffff";
    static final String DFA12_eofS =
        "\32\uffff";
    static final String DFA12_minS =
        "\1\3\1\uffff\1\2\1\4\1\uffff\1\2\2\4\1\uffff\2\3\2\2\1\16\1\4\2"+
        "\24\1\3\2\16\1\3\1\16\4\3";
    static final String DFA12_maxS =
        "\1\6\1\uffff\1\2\1\45\1\uffff\1\2\1\47\1\46\1\uffff\2\24\2\2\1"+
        "\16\1\4\2\24\1\3\5\16\3\3";
    static final String DFA12_acceptS =
        "\1\uffff\1\3\2\uffff\1\1\3\uffff\1\2\21\uffff";
    static final String DFA12_specialS =
        "\32\uffff}>";
    static final String[] DFA12_transitionS = {
            "\2\1\1\uffff\1\2",
            "",
            "\1\3",
            "\1\6\3\uffff\1\5\34\uffff\1\4",
            "",
            "\1\7",
            "\1\10\2\uffff\1\4\2\uffff\1\10\4\uffff\1\10\1\uffff\2\10\24"+
            "\uffff\1\10",
            "\1\11\41\uffff\1\12",
            "",
            "\1\16\13\uffff\1\13\2\uffff\1\14\1\uffff\1\15",
            "\1\16\13\uffff\1\13\2\uffff\1\14\1\uffff\1\15",
            "\1\17",
            "\1\20",
            "\1\21",
            "\1\6",
            "\1\22",
            "\1\23",
            "\1\16",
            "\1\24",
            "\1\25",
            "\1\27\12\uffff\1\26",
            "\1\30",
            "\1\27\12\uffff\1\26",
            "\1\16",
            "\1\31",
            "\1\16"
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
            return "()* loopback of 600:3: ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )*";
        }
    }
 

    public static final BitSet FOLLOW_designDecl_in_sourceText61 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_designDecl76 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_designDecl80 = new BitSet(new long[]{0x00000004A0000000L});
    public static final BitSet FOLLOW_deviceDecl_in_designDecl104 = new BitSet(new long[]{0x00000004A0000000L});
    public static final BitSet FOLLOW_netDecl_in_designDecl109 = new BitSet(new long[]{0x00000004A0000000L});
    public static final BitSet FOLLOW_29_in_designDecl114 = new BitSet(new long[]{0x0000000800000058L});
    public static final BitSet FOLLOW_instDecl_in_designDecl117 = new BitSet(new long[]{0x0000000800000058L});
    public static final BitSet FOLLOW_netAssign_in_designDecl122 = new BitSet(new long[]{0x0000000800000058L});
    public static final BitSet FOLLOW_IDENT_in_designDecl130 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_31_in_deviceDecl166 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl170 = new BitSet(new long[]{0x0000000300000018L});
    public static final BitSet FOLLOW_attributeDecl_in_deviceDecl197 = new BitSet(new long[]{0x0000000300000018L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl202 = new BitSet(new long[]{0x0000000300000018L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl209 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_32_in_attributeDecl242 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_attributeDecl246 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_in_attributeDecl250 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_33_in_pinDecl287 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_sliceList_in_pinDecl310 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl316 = new BitSet(new long[]{0x0000000000006010L});
    public static final BitSet FOLLOW_pinList_in_pinDecl318 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_34_in_netDecl352 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_sliceList_in_netDecl375 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl381 = new BitSet(new long[]{0x0000000100000018L});
    public static final BitSet FOLLOW_attributeDecl_in_netDecl383 = new BitSet(new long[]{0x0000000100000018L});
    public static final BitSet FOLLOW_IDENT_in_netDecl389 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_35_in_instDecl423 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arrayList_in_instDecl445 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instDecl451 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instDecl455 = new BitSet(new long[]{0x0000000000000058L});
    public static final BitSet FOLLOW_attrAssign_in_instDecl477 = new BitSet(new long[]{0x0000000000000058L});
    public static final BitSet FOLLOW_pinAssign_in_instDecl482 = new BitSet(new long[]{0x0000000000000058L});
    public static final BitSet FOLLOW_IDENT_in_instDecl489 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUALS_in_attrAssign523 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_37_in_attrAssign547 = new BitSet(new long[]{0x0000000000000110L});
    public static final BitSet FOLLOW_instanceQualifier_in_attrAssign558 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_arrayIndices_in_attrAssign563 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attrAssign571 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_in_attrAssign575 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssign606 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_instanceQualifier_in_pinAssign631 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_arrayIndices_in_pinAssign636 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinAssign645 = new BitSet(new long[]{0x0000008000068410L});
    public static final BitSet FOLLOW_sliceList_in_pinAssign648 = new BitSet(new long[]{0x0000008000068410L});
    public static final BitSet FOLLOW_pinSlices_in_pinAssign653 = new BitSet(new long[]{0x0000008000068410L});
    public static final BitSet FOLLOW_concatenation_in_pinAssign659 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUALS_in_netAssign691 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_netAssign715 = new BitSet(new long[]{0x0000008000068410L});
    public static final BitSet FOLLOW_sliceList_in_netAssign718 = new BitSet(new long[]{0x0000008000068410L});
    public static final BitSet FOLLOW_netSlices_in_netAssign723 = new BitSet(new long[]{0x0000008000068410L});
    public static final BitSet FOLLOW_concatenation_in_netAssign729 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENT_in_concatenation781 = new BitSet(new long[]{0x0000000000068010L});
    public static final BitSet FOLLOW_sliceList_in_concatenation784 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_concatSlices_in_concatenation789 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_IDENT_in_concatenation820 = new BitSet(new long[]{0x0000000000068010L});
    public static final BitSet FOLLOW_sliceList_in_concatenation844 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_concatSlices_in_concatenation849 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_LEFTANGLE_in_concatenation883 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation887 = new BitSet(new long[]{0x0000000000068000L});
    public static final BitSet FOLLOW_sliceList_in_concatenation890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_concatSlices_in_concatenation895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_concatenation927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_instanceQualifier969 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_instanceQualifier974 = new BitSet(new long[]{0x0000000000148008L});
    public static final BitSet FOLLOW_38_in_instanceQualifier979 = new BitSet(new long[]{0x0000000000148008L});
    public static final BitSet FOLLOW_arrayList_in_instanceQualifier986 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_arrayIndices_in_instanceQualifier991 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMMA_in_arrayList1087 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList1089 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1093 = new BitSet(new long[]{0x0000000000004008L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1108 = new BitSet(new long[]{0x0000000000004008L});
    public static final BitSet FOLLOW_COLON_in_arrayList1143 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList1145 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1149 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1153 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList1186 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_sliceList1217 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList1219 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1223 = new BitSet(new long[]{0x0000000000004008L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1239 = new BitSet(new long[]{0x0000000000004008L});
    public static final BitSet FOLLOW_COLON_in_sliceList1274 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList1276 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1280 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1284 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList1316 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_pinList1346 = new BitSet(new long[]{0x0000000000006012L});
    public static final BitSet FOLLOW_set_in_pinList1385 = new BitSet(new long[]{0x0000000000006012L});

}