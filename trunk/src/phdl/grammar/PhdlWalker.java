// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g 2011-07-11 04:35:26

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
    				reportError(pinNode, "invalid assignment width");
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
    				reportError(pinNode, "invalid assignment width");
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:215:1: sourceText : ( designDecl )* ;
    public final void sourceText() throws RecognitionException {
        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:222:2: ( ( designDecl )* )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:222:4: ( designDecl )*
            {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:222:4: ( designDecl )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==27) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:222:4: designDecl
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:225:1: designDecl : ^( 'design' desName= IDENT ( deviceDecl[des] | netDecl[des] )* 'begin' ( instDecl[des] | netAssign[des] )* ) ;
    public final void designDecl() throws RecognitionException {
        CommonTree desName=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:238:2: ( ^( 'design' desName= IDENT ( deviceDecl[des] | netDecl[des] )* 'begin' ( instDecl[des] | netAssign[des] )* ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:238:4: ^( 'design' desName= IDENT ( deviceDecl[des] | netDecl[des] )* 'begin' ( instDecl[des] | netAssign[des] )* )
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
            			
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:252:3: ( deviceDecl[des] | netDecl[des] )*
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
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:252:4: deviceDecl[des]
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_designDecl104);
            	    deviceDecl(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:252:22: netDecl[des]
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
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:252:45: ( instDecl[des] | netAssign[des] )*
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
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:252:46: instDecl[des]
            	    {
            	    pushFollow(FOLLOW_instDecl_in_designDecl117);
            	    instDecl(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:252:62: netAssign[des]
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


            match(input, Token.UP, null); 
            	// add the design node and report if there are duplicates
            				if(!designNodes.add(des))
            					addError(des, "duplicate design unit");
            					
            				// report any unused device declarations
            				for (DeviceNode dev : des.getDevices()) {
            					if (!des.isDeviceInstanced(dev))
            						addWarning(dev, "unused device declaration");
            				}
            				
            				// report any dangling pins in all instances
            				for (InstanceNode i : des.getInstances()) {
            					for (PinNode p : i.getPins()) {
            						if (!p.hasNet())
            							addError(i, "dangling pin " + p.getName() + " in instance");
            					}
            				}
            				
            				// report any floating nets
            				for (NetNode n : des.getNets()) {
            					if ((n.getPinNodes().size() < 1) && (!n.getName().equals("open")))
            						addWarning(n, "floating net");
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:282:1: deviceDecl[DesignNode des] : ^( 'device' devName= IDENT ( attributeDecl[dev] | pinDecl[dev] )* ) ;
    public final void deviceDecl(DesignNode des) throws RecognitionException {
        CommonTree devName=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:294:2: ( ^( 'device' devName= IDENT ( attributeDecl[dev] | pinDecl[dev] )* ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:294:4: ^( 'device' devName= IDENT ( attributeDecl[dev] | pinDecl[dev] )* )
            {
            match(input,31,FOLLOW_31_in_deviceDecl158); 

            match(input, Token.DOWN, null); 
            devName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl162); 
            	// make a new device based on the identifier and log its location
            				DeviceNode dev = new DeviceNode(des);
            				dev.setName((devName!=null?devName.getText():null));
            				dev.setLocation((devName!=null?devName.getLine():0), (devName!=null?devName.getCharPositionInLine():0), input.getSourceName());
            				
            				// clear these sets each time a device is processed
            				attrDecls.clear();
            				pinDecls.clear();
            			
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:308:3: ( attributeDecl[dev] | pinDecl[dev] )*
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
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:308:4: attributeDecl[dev]
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_deviceDecl189);
            	    attributeDecl(dev);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:308:25: pinDecl[dev]
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl194);
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:325:1: attributeDecl[Attributable dev] : ^( 'attr' attrName= IDENT attrValue= STRING ) ;
    public final void attributeDecl(Attributable dev) throws RecognitionException {
        CommonTree attrName=null;
        CommonTree attrValue=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:336:2: ( ^( 'attr' attrName= IDENT attrValue= STRING ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:336:4: ^( 'attr' attrName= IDENT attrValue= STRING )
            {
            match(input,32,FOLLOW_32_in_attributeDecl229); 

            match(input, Token.DOWN, null); 
            attrName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attributeDecl233); 
            attrValue=(CommonTree)match(input,STRING,FOLLOW_STRING_in_attributeDecl237); 

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:353:1: pinDecl[DeviceNode dev] : ^( 'pin' ( sliceList[sList] )? pinName= IDENT pinList[pList] ) ;
    public final void pinDecl(DeviceNode dev) throws RecognitionException {
        CommonTree pinName=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:371:2: ( ^( 'pin' ( sliceList[sList] )? pinName= IDENT pinList[pList] ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:371:4: ^( 'pin' ( sliceList[sList] )? pinName= IDENT pinList[pList] )
            {
            match(input,33,FOLLOW_33_in_pinDecl274); 

             	// sets to keep track of the slice and pin lists
            				List<Integer> sList = new ArrayList<Integer>(); 
            				List<String> pList = new ArrayList<String>();
            			

            match(input, Token.DOWN, null); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:380:3: ( sliceList[sList] )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==COMMA||(LA5_0>=LEFTBRACKET && LA5_0<=COLON)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:380:3: sliceList[sList]
                    {
                    pushFollow(FOLLOW_sliceList_in_pinDecl297);
                    sliceList(sList);

                    state._fsp--;


                    }
                    break;

            }

            pinName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinDecl303); 
            pushFollow(FOLLOW_pinList_in_pinDecl305);
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:434:1: netDecl[DesignNode des] : ^( 'net' ( sliceList[slices] )? netName= IDENT ( attributeDecl[n] )* ) ;
    public final void netDecl(DesignNode des) throws RecognitionException {
        CommonTree netName=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:443:2: ( ^( 'net' ( sliceList[slices] )? netName= IDENT ( attributeDecl[n] )* ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:443:4: ^( 'net' ( sliceList[slices] )? netName= IDENT ( attributeDecl[n] )* )
            {
            match(input,34,FOLLOW_34_in_netDecl339); 

            	// housekeeping
            				List<Integer> slices = new ArrayList<Integer>();
            				NetNode n = new NetNode(null);
            				attrDecls.clear();
            			

            match(input, Token.DOWN, null); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:453:3: ( sliceList[slices] )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==COMMA||(LA6_0>=LEFTBRACKET && LA6_0<=COLON)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:453:3: sliceList[slices]
                    {
                    pushFollow(FOLLOW_sliceList_in_netDecl362);
                    sliceList(slices);

                    state._fsp--;


                    }
                    break;

            }

            netName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netDecl368); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:453:36: ( attributeDecl[n] )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==32) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:453:36: attributeDecl[n]
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_netDecl370);
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:501:1: instDecl[DesignNode des] : ^( 'inst' ( arrayList[indices] )? instName= IDENT devName= IDENT ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )* ) ;
    public final void instDecl(DesignNode des) throws RecognitionException {
        CommonTree instName=null;
        CommonTree devName=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:512:2: ( ^( 'inst' ( arrayList[indices] )? instName= IDENT devName= IDENT ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )* ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:512:4: ^( 'inst' ( arrayList[indices] )? instName= IDENT devName= IDENT ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )* )
            {
            match(input,35,FOLLOW_35_in_instDecl406); 

            	// Set of instance nodes to check for duplicates
            				List<InstanceNode> instNodes = new ArrayList<InstanceNode>();
            				// List of indices to be derived from the arrayList
            				List<Integer> indices = new ArrayList<Integer>();
            			

            match(input, Token.DOWN, null); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:522:3: ( arrayList[indices] )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==COMMA||LA8_0==COLON||LA8_0==LEFTPAREN) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:522:3: arrayList[indices]
                    {
                    pushFollow(FOLLOW_arrayList_in_instDecl428);
                    arrayList(indices);

                    state._fsp--;


                    }
                    break;

            }

            instName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl434); 
            devName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl438); 
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
            			
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:580:3: ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )*
            loop9:
            do {
                int alt9=3;
                alt9 = dfa9.predict(input);
                switch (alt9) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:580:4: attrAssign[des, $instName.text]
            	    {
            	    pushFollow(FOLLOW_attrAssign_in_instDecl460);
            	    attrAssign(des, (instName!=null?instName.getText():null));

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:580:38: pinAssign[des, $instName.text]
            	    {
            	    pushFollow(FOLLOW_pinAssign_in_instDecl465);
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:583:1: attrAssign[DesignNode des, String instName] : ^( EQUALS ( 'newattr' )? ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] ) attrName= IDENT attrValue= STRING ) ;
    public final void attrAssign(DesignNode des, String instName) throws RecognitionException {
        CommonTree attrName=null;
        CommonTree attrValue=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:600:2: ( ^( EQUALS ( 'newattr' )? ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] ) attrName= IDENT attrValue= STRING ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:600:4: ^( EQUALS ( 'newattr' )? ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] ) attrName= IDENT attrValue= STRING )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_attrAssign486); 

            	// flag for a new attribute and a list of indices the attribute assignment applies to
            				boolean newAttr = false;
            				List<Integer> indices = new ArrayList<Integer>();
            			

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:609:3: ( 'newattr' )?
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==37) ) {
                    alt10=1;
                }
                switch (alt10) {
                    case 1 :
                        // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:609:4: 'newattr'
                        {
                        match(input,37,FOLLOW_37_in_attrAssign510); 
                        newAttr = true;

                        }
                        break;

                }

                // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:610:3: ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] )
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==PERIOD) ) {
                    alt11=1;
                }
                else if ( ((LA11_0>=UP && LA11_0<=IDENT)) ) {
                    alt11=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 0, input);

                    throw nvae;
                }
                switch (alt11) {
                    case 1 :
                        // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:610:4: instanceQualifier[instName, indices, des]
                        {
                        pushFollow(FOLLOW_instanceQualifier_in_attrAssign521);
                        instanceQualifier(instName, indices, des);

                        state._fsp--;


                        }
                        break;
                    case 2 :
                        // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:610:48: arrayIndices[indices, instName, des]
                        {
                        pushFollow(FOLLOW_arrayIndices_in_attrAssign526);
                        arrayIndices(indices, instName, des);

                        state._fsp--;


                        }
                        break;

                }

                attrName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attrAssign534); 
                attrValue=(CommonTree)match(input,STRING,FOLLOW_STRING_in_attrAssign538); 

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:686:1: pinAssign[DesignNode des, String instName] : ^( EQUALS ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] ) pinName= IDENT ( sliceList[slices] | pinSlices[slices, $pinName.text, des, instName] ) concatenation[concats, slices.size(), des] ) ;
    public final void pinAssign(DesignNode des, String instName) throws RecognitionException {
        CommonTree pinName=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:687:2: ( ^( EQUALS ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] ) pinName= IDENT ( sliceList[slices] | pinSlices[slices, $pinName.text, des, instName] ) concatenation[concats, slices.size(), des] ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:687:4: ^( EQUALS ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] ) pinName= IDENT ( sliceList[slices] | pinSlices[slices, $pinName.text, des, instName] ) concatenation[concats, slices.size(), des] )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_pinAssign569); 

            	List<Integer> indices = new ArrayList<Integer>();
            				List<Integer> slices = new ArrayList<Integer>();
            				List<NetNode> concats = new ArrayList<NetNode>();
            			

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:696:3: ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] )
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==PERIOD) ) {
                    alt12=1;
                }
                else if ( ((LA12_0>=UP && LA12_0<=IDENT)) ) {
                    alt12=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 0, input);

                    throw nvae;
                }
                switch (alt12) {
                    case 1 :
                        // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:696:4: instanceQualifier[instName, indices, des]
                        {
                        pushFollow(FOLLOW_instanceQualifier_in_pinAssign594);
                        instanceQualifier(instName, indices, des);

                        state._fsp--;


                        }
                        break;
                    case 2 :
                        // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:696:48: arrayIndices[indices, instName, des]
                        {
                        pushFollow(FOLLOW_arrayIndices_in_pinAssign599);
                        arrayIndices(indices, instName, des);

                        state._fsp--;


                        }
                        break;

                }

                pinName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinAssign608); 
                // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:697:17: ( sliceList[slices] | pinSlices[slices, $pinName.text, des, instName] )
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==COMMA||(LA13_0>=LEFTBRACKET && LA13_0<=COLON)) ) {
                    alt13=1;
                }
                else if ( (LA13_0==IDENT||LA13_0==LEFTANGLE||LA13_0==38) ) {
                    alt13=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 0, input);

                    throw nvae;
                }
                switch (alt13) {
                    case 1 :
                        // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:697:18: sliceList[slices]
                        {
                        pushFollow(FOLLOW_sliceList_in_pinAssign611);
                        sliceList(slices);

                        state._fsp--;


                        }
                        break;
                    case 2 :
                        // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:697:38: pinSlices[slices, $pinName.text, des, instName]
                        {
                        pushFollow(FOLLOW_pinSlices_in_pinAssign616);
                        pinSlices(slices, (pinName!=null?pinName.getText():null), des, instName);

                        state._fsp--;


                        }
                        break;

                }

                pushFollow(FOLLOW_concatenation_in_pinAssign622);
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:720:1: netAssign[DesignNode des] : ^( EQUALS netName= IDENT ( sliceList[slices] | netSlices[slices, $netName.text, des] ) concatenation[concats, slices.size(), des] ) ;
    public final void netAssign(DesignNode des) throws RecognitionException {
        CommonTree netName=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:721:2: ( ^( EQUALS netName= IDENT ( sliceList[slices] | netSlices[slices, $netName.text, des] ) concatenation[concats, slices.size(), des] ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:721:4: ^( EQUALS netName= IDENT ( sliceList[slices] | netSlices[slices, $netName.text, des] ) concatenation[concats, slices.size(), des] )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_netAssign654); 

            	List<Integer> slices = new ArrayList<Integer>();
            				List<NetNode> concats = new ArrayList<NetNode>();
            			

            match(input, Token.DOWN, null); 
            netName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netAssign678); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:729:17: ( sliceList[slices] | netSlices[slices, $netName.text, des] )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==COMMA||(LA14_0>=LEFTBRACKET && LA14_0<=COLON)) ) {
                alt14=1;
            }
            else if ( (LA14_0==IDENT||LA14_0==LEFTANGLE||LA14_0==38) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:729:18: sliceList[slices]
                    {
                    pushFollow(FOLLOW_sliceList_in_netAssign681);
                    sliceList(slices);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:729:38: netSlices[slices, $netName.text, des]
                    {
                    pushFollow(FOLLOW_netSlices_in_netAssign686);
                    netSlices(slices, (netName!=null?netName.getText():null), des);

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_concatenation_in_netAssign692);
            concatenation(concats, slices.size(), des);

            state._fsp--;


            match(input, Token.UP, null); 
            	
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
            						reportError(netName, "invalid assignment width");
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
            						reportError(netName, "invalid assignment width");
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:766:1: concatenation[List<NetNode> concats, int assignWidth, DesignNode des] : ( (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* ) | ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) ) | ( 'open' ) ) ;
    public final void concatenation(List<NetNode> concats, int assignWidth, DesignNode des) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;
        CommonTree global=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:770:2: ( ( (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* ) | ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) ) | ( 'open' ) ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:771:4: ( (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* ) | ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) ) | ( 'open' ) )
            {
            List<Integer> slices = new ArrayList<Integer>();
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:773:3: ( (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* ) | ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) ) | ( 'open' ) )
            int alt19=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt19=1;
                }
                break;
            case LEFTANGLE:
                {
                alt19=2;
                }
                break;
            case 38:
                {
                alt19=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:773:4: (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* )
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:773:4: (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:773:5: first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )*
                    {
                    first=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenation744); 
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:773:17: ( sliceList[slices] | concatSlices[slices, $first.text, des] )
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==COMMA||(LA15_0>=LEFTBRACKET && LA15_0<=COLON)) ) {
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
                            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:773:18: sliceList[slices]
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation747);
                            sliceList(slices);

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:773:38: concatSlices[slices, $first.text, des]
                            {
                            pushFollow(FOLLOW_concatSlices_in_concatenation752);
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
                    						addError(first, "undeclared net");
                    					}
                    				}
                    			
                    				for (int i = 0; i < slices.size(); i++) {
                    					for (NetNode n : des.getAllNets((first!=null?first.getText():null))) {
                    						if (n.getIndex() == slices.get(i)) {
                    							concats.add(n);
                    						}
                    					}
                    				}

                    			
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:796:3: (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==IDENT) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:796:4: next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] )
                    	    {
                    	    next=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenation783); 
                    	    slices.clear();
                    	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:800:3: ( sliceList[slices] | concatSlices[slices, $next.text, des] )
                    	    int alt16=2;
                    	    int LA16_0 = input.LA(1);

                    	    if ( (LA16_0==COMMA||(LA16_0>=LEFTBRACKET && LA16_0<=COLON)) ) {
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
                    	            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:800:4: sliceList[slices]
                    	            {
                    	            pushFollow(FOLLOW_sliceList_in_concatenation807);
                    	            sliceList(slices);

                    	            state._fsp--;


                    	            }
                    	            break;
                    	        case 2 :
                    	            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:800:24: concatSlices[slices, $next.text, des]
                    	            {
                    	            pushFollow(FOLLOW_concatSlices_in_concatenation812);
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
                    	    break loop17;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:822:10: ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) )
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:822:10: ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:822:11: LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] )
                    {
                    match(input,LEFTANGLE,FOLLOW_LEFTANGLE_in_concatenation846); 
                    global=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenation850); 
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:822:34: ( sliceList[slices] | concatSlices[slices, $global.text, des] )
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==COMMA||(LA18_0>=LEFTBRACKET && LA18_0<=COLON)) ) {
                        alt18=1;
                    }
                    else if ( ((LA18_0>=UP && LA18_0<=IDENT)) ) {
                        alt18=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 0, input);

                        throw nvae;
                    }
                    switch (alt18) {
                        case 1 :
                            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:822:35: sliceList[slices]
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation853);
                            sliceList(slices);

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:822:55: concatSlices[slices, $global.text, des]
                            {
                            pushFollow(FOLLOW_concatSlices_in_concatenation858);
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
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:850:5: ( 'open' )
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:850:5: ( 'open' )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:850:6: 'open'
                    {
                    match(input,38,FOLLOW_38_in_concatenation890); 

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:872:1: instanceQualifier[String instName, List<Integer> indices, DesignNode des] : ^( PERIOD qualName= IDENT ( arrayList[indices] | arrayIndices[indices, instName, des] ) ) ;
    public final void instanceQualifier(String instName, List<Integer> indices, DesignNode des) throws RecognitionException {
        CommonTree qualName=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:884:2: ( ^( PERIOD qualName= IDENT ( arrayList[indices] | arrayIndices[indices, instName, des] ) ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:884:4: ^( PERIOD qualName= IDENT ( arrayList[indices] | arrayIndices[indices, instName, des] ) )
            {
            match(input,PERIOD,FOLLOW_PERIOD_in_instanceQualifier928); 

            match(input, Token.DOWN, null); 
            qualName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instanceQualifier932); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:884:28: ( arrayList[indices] | arrayIndices[indices, instName, des] )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==COMMA||LA20_0==COLON||LA20_0==LEFTPAREN) ) {
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
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:884:29: arrayList[indices]
                    {
                    pushFollow(FOLLOW_arrayList_in_instanceQualifier935);
                    arrayList(indices);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:884:50: arrayIndices[indices, instName, des]
                    {
                    pushFollow(FOLLOW_arrayIndices_in_instanceQualifier940);
                    arrayIndices(indices, instName, des);

                    state._fsp--;


                    }
                    break;

            }


            match(input, Token.UP, null); 
            	// check that the instance qualifier matches
            		    	if (!instName.equals((qualName!=null?qualName.getText():null))) {
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:895:1: arrayIndices[List<Integer> indices, String instName, DesignNode des] : ;
    public final void arrayIndices(List<Integer> indices, String instName, DesignNode des) throws RecognitionException {
        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:896:2: ()
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:896:4: 
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:899:1: pinSlices[List<Integer> slices, String pinName, DesignNode des, String instName] : ;
    public final void pinSlices(List<Integer> slices, String pinName, DesignNode des, String instName) throws RecognitionException {
        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:900:2: ()
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:900:4: 
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:906:1: netSlices[List<Integer> slices, String netName, DesignNode des] : ;
    public final void netSlices(List<Integer> slices, String netName, DesignNode des) throws RecognitionException {
        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:907:2: ()
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:907:4: 
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:912:1: concatSlices[List<Integer> slices, String netName, DesignNode des] : ;
    public final void concatSlices(List<Integer> slices, String netName, DesignNode des) throws RecognitionException {
        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:913:2: ()
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:913:4: 
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:916:1: arrayList[List<Integer> indices] : ( ^( COMMA LEFTPAREN first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTPAREN first= INTEGER last= INTEGER ) | ( LEFTPAREN single= INTEGER ) );
    public final void arrayList(List<Integer> indices) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;
        CommonTree last=null;
        CommonTree single=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:927:2: ( ^( COMMA LEFTPAREN first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTPAREN first= INTEGER last= INTEGER ) | ( LEFTPAREN single= INTEGER ) )
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
            case LEFTPAREN:
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
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:928:3: ^( COMMA LEFTPAREN first= INTEGER (next= INTEGER )* )
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_arrayList1036); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList1038); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1042); 
                    indices.add(Integer.parseInt((first!=null?first.getText():null)));
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:929:8: (next= INTEGER )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==INTEGER) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:929:9: next= INTEGER
                    	    {
                    	    next=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1057); 
                    	    indices.add(Integer.parseInt((next!=null?next.getText():null)));

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
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:932:5: ^( COLON LEFTPAREN first= INTEGER last= INTEGER )
                    {
                    match(input,COLON,FOLLOW_COLON_in_arrayList1092); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList1094); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1098); 
                    last=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1102); 
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
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:950:4: ( LEFTPAREN single= INTEGER )
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:950:4: ( LEFTPAREN single= INTEGER )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:950:5: LEFTPAREN single= INTEGER
                    {
                    match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList1135); 
                    single=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1139); 
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:953:1: sliceList[List<Integer> slices] : ( ^( COMMA LEFTBRACKET first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTBRACKET first= INTEGER last= INTEGER ) | ( LEFTBRACKET single= INTEGER ) );
    public final void sliceList(List<Integer> slices) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;
        CommonTree last=null;
        CommonTree single=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:964:2: ( ^( COMMA LEFTBRACKET first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTBRACKET first= INTEGER last= INTEGER ) | ( LEFTBRACKET single= INTEGER ) )
            int alt24=3;
            switch ( input.LA(1) ) {
            case COMMA:
                {
                alt24=1;
                }
                break;
            case COLON:
                {
                alt24=2;
                }
                break;
            case LEFTBRACKET:
                {
                alt24=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:965:3: ^( COMMA LEFTBRACKET first= INTEGER (next= INTEGER )* )
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_sliceList1166); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList1168); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1172); 
                    slices.add(Integer.parseInt((first!=null?first.getText():null)));
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:966:8: (next= INTEGER )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==INTEGER) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:966:9: next= INTEGER
                    	    {
                    	    next=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1188); 
                    	    slices.add(Integer.parseInt((next!=null?next.getText():null)));

                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:969:4: ^( COLON LEFTBRACKET first= INTEGER last= INTEGER )
                    {
                    match(input,COLON,FOLLOW_COLON_in_sliceList1223); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList1225); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1229); 
                    last=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1233); 
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
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:989:4: ( LEFTBRACKET single= INTEGER )
                    {
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:989:4: ( LEFTBRACKET single= INTEGER )
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:989:5: LEFTBRACKET single= INTEGER
                    {
                    match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList1265); 
                    single=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1269); 
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:993:1: pinList[List<String> pList] : first= ( PIN | INTEGER | IDENT ) (next= ( PIN | INTEGER | IDENT ) )* ;
    public final void pinList(List<String> pList) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:1004:2: (first= ( PIN | INTEGER | IDENT ) (next= ( PIN | INTEGER | IDENT ) )* )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:1004:4: first= ( PIN | INTEGER | IDENT ) (next= ( PIN | INTEGER | IDENT ) )*
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
            			
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:1015:7: (next= ( PIN | INTEGER | IDENT ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==IDENT||(LA25_0>=PIN && LA25_0<=INTEGER)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:1015:8: next= ( PIN | INTEGER | IDENT )
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
            	    break loop25;
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
            return "()* loopback of 580:3: ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )*";
        }
    }
 

    public static final BitSet FOLLOW_designDecl_in_sourceText61 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_designDecl76 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_designDecl80 = new BitSet(new long[]{0x00000004A0000000L});
    public static final BitSet FOLLOW_deviceDecl_in_designDecl104 = new BitSet(new long[]{0x00000004A0000000L});
    public static final BitSet FOLLOW_netDecl_in_designDecl109 = new BitSet(new long[]{0x00000004A0000000L});
    public static final BitSet FOLLOW_29_in_designDecl114 = new BitSet(new long[]{0x0000000800000048L});
    public static final BitSet FOLLOW_instDecl_in_designDecl117 = new BitSet(new long[]{0x0000000800000048L});
    public static final BitSet FOLLOW_netAssign_in_designDecl122 = new BitSet(new long[]{0x0000000800000048L});
    public static final BitSet FOLLOW_31_in_deviceDecl158 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl162 = new BitSet(new long[]{0x0000000300000008L});
    public static final BitSet FOLLOW_attributeDecl_in_deviceDecl189 = new BitSet(new long[]{0x0000000300000008L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl194 = new BitSet(new long[]{0x0000000300000008L});
    public static final BitSet FOLLOW_32_in_attributeDecl229 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_attributeDecl233 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_in_attributeDecl237 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_33_in_pinDecl274 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_sliceList_in_pinDecl297 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl303 = new BitSet(new long[]{0x0000000000006010L});
    public static final BitSet FOLLOW_pinList_in_pinDecl305 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_34_in_netDecl339 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_sliceList_in_netDecl362 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl368 = new BitSet(new long[]{0x0000000100000008L});
    public static final BitSet FOLLOW_attributeDecl_in_netDecl370 = new BitSet(new long[]{0x0000000100000008L});
    public static final BitSet FOLLOW_35_in_instDecl406 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arrayList_in_instDecl428 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instDecl434 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instDecl438 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_attrAssign_in_instDecl460 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_pinAssign_in_instDecl465 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_EQUALS_in_attrAssign486 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_37_in_attrAssign510 = new BitSet(new long[]{0x0000000000000110L});
    public static final BitSet FOLLOW_instanceQualifier_in_attrAssign521 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_arrayIndices_in_attrAssign526 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attrAssign534 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_in_attrAssign538 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssign569 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_instanceQualifier_in_pinAssign594 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_arrayIndices_in_pinAssign599 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinAssign608 = new BitSet(new long[]{0x0000004000068410L});
    public static final BitSet FOLLOW_sliceList_in_pinAssign611 = new BitSet(new long[]{0x0000004000068410L});
    public static final BitSet FOLLOW_pinSlices_in_pinAssign616 = new BitSet(new long[]{0x0000004000068410L});
    public static final BitSet FOLLOW_concatenation_in_pinAssign622 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUALS_in_netAssign654 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_netAssign678 = new BitSet(new long[]{0x0000004000068410L});
    public static final BitSet FOLLOW_sliceList_in_netAssign681 = new BitSet(new long[]{0x0000004000068410L});
    public static final BitSet FOLLOW_netSlices_in_netAssign686 = new BitSet(new long[]{0x0000004000068410L});
    public static final BitSet FOLLOW_concatenation_in_netAssign692 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENT_in_concatenation744 = new BitSet(new long[]{0x0000000000068010L});
    public static final BitSet FOLLOW_sliceList_in_concatenation747 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_concatSlices_in_concatenation752 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_IDENT_in_concatenation783 = new BitSet(new long[]{0x0000000000068010L});
    public static final BitSet FOLLOW_sliceList_in_concatenation807 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_concatSlices_in_concatenation812 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_LEFTANGLE_in_concatenation846 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation850 = new BitSet(new long[]{0x0000000000068000L});
    public static final BitSet FOLLOW_sliceList_in_concatenation853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_concatSlices_in_concatenation858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_concatenation890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_instanceQualifier928 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_instanceQualifier932 = new BitSet(new long[]{0x0000000000148008L});
    public static final BitSet FOLLOW_arrayList_in_instanceQualifier935 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_arrayIndices_in_instanceQualifier940 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMMA_in_arrayList1036 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList1038 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1042 = new BitSet(new long[]{0x0000000000004008L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1057 = new BitSet(new long[]{0x0000000000004008L});
    public static final BitSet FOLLOW_COLON_in_arrayList1092 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList1094 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1098 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1102 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList1135 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_sliceList1166 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList1168 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1172 = new BitSet(new long[]{0x0000000000004008L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1188 = new BitSet(new long[]{0x0000000000004008L});
    public static final BitSet FOLLOW_COLON_in_sliceList1223 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList1225 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1229 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1233 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList1265 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_pinList1295 = new BitSet(new long[]{0x0000000000006012L});
    public static final BitSet FOLLOW_set_in_pinList1334 = new BitSet(new long[]{0x0000000000006012L});

}