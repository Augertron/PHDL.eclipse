// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g 2011-07-08 16:50:30

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
    						addWarning(pinNode, "pin already assigned");
    					p.setNet(concats.get(0));
    					concats.get(0).addPin(p);
    				} else {
    					addError(pinNode, "pin undeclared in device");
    				}
    			} else {
    				addError(pinNode, "invalid assignment width");
    			}
    		} else {
    			if (concats.size() == slices.size()) {
    				// assign pins
    				for (int i = 0; i < concats.size(); i++) {
    					PinNode p = inst.getPin(pinName + "[" + slices.get(i) + "]");
    					if (p != null) { 
    						if (p.hasNet())
    							addWarning(pinNode, "pin already assigned");
    						p.setNet(concats.get(i));
    						concats.get(i).addPin(p);
    					} else {
    						addError(pinNode, "pin undeclared in device");
    					}
    				}
    			} else {
    				addError(pinNode, "invalid assignment width");
    			}
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:195:1: sourceText : ( designDecl )* ;
    public final void sourceText() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:202:2: ( ( designDecl )* )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:202:4: ( designDecl )*
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:202:4: ( designDecl )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==27) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:202:4: designDecl
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:205:1: designDecl : ^( 'design' name= IDENT ( deviceDecl[des] | netDecl[des] )* 'begin' ( instDecl[des] )* ) ;
    public final void designDecl() throws RecognitionException {
        CommonTree name=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:218:2: ( ^( 'design' name= IDENT ( deviceDecl[des] | netDecl[des] )* 'begin' ( instDecl[des] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:218:4: ^( 'design' name= IDENT ( deviceDecl[des] | netDecl[des] )* 'begin' ( instDecl[des] )* )
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
            			
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:232:3: ( deviceDecl[des] | netDecl[des] )*
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:232:4: deviceDecl[des]
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_designDecl104);
            	    deviceDecl(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:232:22: netDecl[des]
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:232:45: ( instDecl[des] )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==35) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:232:46: instDecl[des]
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
            					
            				// report any unused device declarations
            				for (DeviceNode dev : des.getDevices()) {
            					if (!des.isDeviceInstanced(dev)) {
            						addWarning(dev, "unused device declaration");
            					}
            				}
            				
            				// report any dangling pins in all instances
            				for (InstanceNode i : des.getInstances()) {
            					for (PinNode p : i.getPins()) {
            						if (!p.hasNet()) {
            							addError(i, "dangling pin " + p.getName() + " in instance");
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
    // $ANTLR end "designDecl"


    // $ANTLR start "deviceDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:258:1: deviceDecl[DesignNode des] : ^( 'device' name= IDENT ( attributeDecl[dev] | pinDecl[dev] )* ) ;
    public final void deviceDecl(DesignNode des) throws RecognitionException {
        CommonTree name=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:270:2: ( ^( 'device' name= IDENT ( attributeDecl[dev] | pinDecl[dev] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:270:4: ^( 'device' name= IDENT ( attributeDecl[dev] | pinDecl[dev] )* )
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
            			
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:284:3: ( attributeDecl[dev] | pinDecl[dev] )*
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
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:284:4: attributeDecl[dev]
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_deviceDecl184);
            	    attributeDecl(dev);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:284:25: pinDecl[dev]
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
            						addError(name, "required attribute \"" + s + "\" missing in device");
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:301:1: attributeDecl[Attributable dev] : ^( 'attr' name= IDENT value= STRING ) ;
    public final void attributeDecl(Attributable dev) throws RecognitionException {
        CommonTree name=null;
        CommonTree value=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:312:2: ( ^( 'attr' name= IDENT value= STRING ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:312:4: ^( 'attr' name= IDENT value= STRING )
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:329:1: pinDecl[DeviceNode dev] : ^( 'pin' ( sliceList[sList] )? name= IDENT pinList[pList] ) ;
    public final void pinDecl(DeviceNode dev) throws RecognitionException {
        CommonTree name=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:347:2: ( ^( 'pin' ( sliceList[sList] )? name= IDENT pinList[pList] ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:347:4: ^( 'pin' ( sliceList[sList] )? name= IDENT pinList[pList] )
            {
            match(input,33,FOLLOW_33_in_pinDecl269); 

             	// sets to keep track of the slice and pin lists
            				List<Integer> sList = new ArrayList<Integer>(); 
            				List<String> pList = new ArrayList<String>();
            			

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:356:3: ( sliceList[sList] )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==COMMA||(LA5_0>=LEFTBRACKET && LA5_0<=COLON)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:356:3: sliceList[sList]
                    {
                    pushFollow(FOLLOW_sliceList_in_pinDecl292);
                    sliceList(sList);

                    state._fsp--;


                    }
                    break;

            }

            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinDecl298); 
            pushFollow(FOLLOW_pinList_in_pinDecl300);
            pinList(pList);

            state._fsp--;


            match(input, Token.UP, null); 
            	// list sizes should only differ if there is no slice list, and the pin list has a size of 1
            				if (sList.size() != pList.size()) {
            					if (sList.size() == 0 && pList.size() != 1)
            						addError(name, "invalid pin list");
            					if (sList.size() != 0)
            						addError(name, "invalid pin list");
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
            						addError(name, "invalid pin list");
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
            						addError(name, "invalid pin list");
            					}
            					
            					// report any duplicate pin declarations
            					if (!dev.addPin(newPin))
            	            		addError(newPin, "duplicate pin declaration");
            				}
            				
            				// check for overall duplicates based solely on the name
            				if (!pinDecls.add((name!=null?name.getText():null)))
            					addError(name, "duplicate pin declaration");
            			

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:410:1: netDecl[DesignNode des] : ^( 'net' ( sliceList[slices] )? name= IDENT ( attributeDecl[n] )* ) ;
    public final void netDecl(DesignNode des) throws RecognitionException {
        CommonTree name=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:419:2: ( ^( 'net' ( sliceList[slices] )? name= IDENT ( attributeDecl[n] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:419:4: ^( 'net' ( sliceList[slices] )? name= IDENT ( attributeDecl[n] )* )
            {
            match(input,34,FOLLOW_34_in_netDecl334); 

            	// housekeeping
            				List<Integer> slices = new ArrayList<Integer>();
            				NetNode n = new NetNode(null);
            				attrDecls.clear();
            			

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:429:3: ( sliceList[slices] )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==COMMA||(LA6_0>=LEFTBRACKET && LA6_0<=COLON)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:429:3: sliceList[slices]
                    {
                    pushFollow(FOLLOW_sliceList_in_netDecl357);
                    sliceList(slices);

                    state._fsp--;


                    }
                    break;

            }

            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netDecl363); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:429:33: ( attributeDecl[n] )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==32) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:429:33: attributeDecl[n]
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:478:1: instDecl[DesignNode des] : ^( 'inst' ( arrayList[indices] )? instName= IDENT devName= IDENT ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )* ) ;
    public final void instDecl(DesignNode des) throws RecognitionException {
        CommonTree instName=null;
        CommonTree devName=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:489:2: ( ^( 'inst' ( arrayList[indices] )? instName= IDENT devName= IDENT ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:489:4: ^( 'inst' ( arrayList[indices] )? instName= IDENT devName= IDENT ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )* )
            {
            match(input,35,FOLLOW_35_in_instDecl401); 

            	// Set of instance nodes to check for duplicates
            				List<InstanceNode> instNodes = new ArrayList<InstanceNode>();
            				// List of indices to be derived from the arrayList
            				List<Integer> indices = new ArrayList<Integer>();
            			

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:499:3: ( arrayList[indices] )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==COMMA||LA8_0==COLON||LA8_0==LEFTPAREN) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:499:3: arrayList[indices]
                    {
                    pushFollow(FOLLOW_arrayList_in_instDecl423);
                    arrayList(indices);

                    state._fsp--;


                    }
                    break;

            }

            instName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl429); 
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
            			
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:557:3: ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )*
            loop9:
            do {
                int alt9=3;
                alt9 = dfa9.predict(input);
                switch (alt9) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:557:4: attrAssign[des, $instName.text]
            	    {
            	    pushFollow(FOLLOW_attrAssign_in_instDecl455);
            	    attrAssign(des, (instName!=null?instName.getText():null));

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:557:38: pinAssign[des, $instName.text]
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:560:1: attrAssign[DesignNode des, String instName] : ^( EQUALS ( 'newattr' )? ( instanceQualifier[instName, indices, des] | globalArray[indices, instName, des] ) name= IDENT value= STRING ) ;
    public final void attrAssign(DesignNode des, String instName) throws RecognitionException {
        CommonTree name=null;
        CommonTree value=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:577:2: ( ^( EQUALS ( 'newattr' )? ( instanceQualifier[instName, indices, des] | globalArray[indices, instName, des] ) name= IDENT value= STRING ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:577:4: ^( EQUALS ( 'newattr' )? ( instanceQualifier[instName, indices, des] | globalArray[indices, instName, des] ) name= IDENT value= STRING )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_attrAssign481); 

            	// flag for a new attribute and a list of indices the attribute assignment applies to
            				boolean newAttr = false;
            				List<Integer> indices = new ArrayList<Integer>();
            			

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:586:3: ( 'newattr' )?
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==37) ) {
                    alt10=1;
                }
                switch (alt10) {
                    case 1 :
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:586:4: 'newattr'
                        {
                        match(input,37,FOLLOW_37_in_attrAssign505); 
                        newAttr = true;

                        }
                        break;

                }

                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:586:35: ( instanceQualifier[instName, indices, des] | globalArray[indices, instName, des] )
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
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:586:36: instanceQualifier[instName, indices, des]
                        {
                        pushFollow(FOLLOW_instanceQualifier_in_attrAssign513);
                        instanceQualifier(instName, indices, des);

                        state._fsp--;


                        }
                        break;
                    case 2 :
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:586:80: globalArray[indices, instName, des]
                        {
                        pushFollow(FOLLOW_globalArray_in_attrAssign518);
                        globalArray(indices, instName, des);

                        state._fsp--;


                        }
                        break;

                }

                name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attrAssign526); 
                value=(CommonTree)match(input,STRING,FOLLOW_STRING_in_attrAssign530); 

                match(input, Token.UP, null); 
            }
            	// for every index in the instance qualifier array list
            				for(int i = 0; i < indices.size(); i++) {
            					// find the instance node in the design with the right index
            					InstanceNode inst = des.getInstance(instName + "(" + indices.get(i) + ")");
            					if(inst!=null){
            						// find its attribute by the name
            						AttributeNode a = inst.getAttribute((name!=null?name.getText():null));
            						if (a!=null) {
            							if(newAttr)
            								addWarning(name, "new attribute already declared in device");
            							// overwrite the attribute value
            							if(!a.overwrite((value!=null?value.getText():null)))
            								addWarning(name, "atribute already overwritten");
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
            								addError(name, "attribute undeclared in device");
            							}
            						}
            					} else {
            						// the instance node does not exist
            						addError(name, "instance " + instName + "(" + indices.get(i) + ")" + " is undeclared");
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
            								addWarning(name, "new attribute already declared in device");
            							// overwrite the attribute value
            							if(!a.overwrite((value!=null?value.getText():null)))
            								addWarning(name, "atribute already overwritten");
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
            								addError(name, "instance " + instName + " is undeclared");
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:655:1: pinAssign[DesignNode des, String instName] : ^( EQUALS ( instanceQualifier[instName, indices, des] | globalArray[indices, instName, des] ) name= IDENT ( sliceList[slices] | globalVector[slices, $name.text, des, instName] ) concatenation[concats, slices.size(), des] ) ;
    public final void pinAssign(DesignNode des, String instName) throws RecognitionException {
        CommonTree name=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:656:2: ( ^( EQUALS ( instanceQualifier[instName, indices, des] | globalArray[indices, instName, des] ) name= IDENT ( sliceList[slices] | globalVector[slices, $name.text, des, instName] ) concatenation[concats, slices.size(), des] ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:656:4: ^( EQUALS ( instanceQualifier[instName, indices, des] | globalArray[indices, instName, des] ) name= IDENT ( sliceList[slices] | globalVector[slices, $name.text, des, instName] ) concatenation[concats, slices.size(), des] )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_pinAssign562); 

            	List<Integer> indices = new ArrayList<Integer>();
            				List<Integer> slices = new ArrayList<Integer>();
            				List<NetNode> concats = new ArrayList<NetNode>();
            			

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:665:3: ( instanceQualifier[instName, indices, des] | globalArray[indices, instName, des] )
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
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:665:4: instanceQualifier[instName, indices, des]
                        {
                        pushFollow(FOLLOW_instanceQualifier_in_pinAssign587);
                        instanceQualifier(instName, indices, des);

                        state._fsp--;


                        }
                        break;
                    case 2 :
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:665:48: globalArray[indices, instName, des]
                        {
                        pushFollow(FOLLOW_globalArray_in_pinAssign592);
                        globalArray(indices, instName, des);

                        state._fsp--;


                        }
                        break;

                }

                name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinAssign601); 
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:666:14: ( sliceList[slices] | globalVector[slices, $name.text, des, instName] )
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
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:666:15: sliceList[slices]
                        {
                        pushFollow(FOLLOW_sliceList_in_pinAssign604);
                        sliceList(slices);

                        state._fsp--;


                        }
                        break;
                    case 2 :
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:666:35: globalVector[slices, $name.text, des, instName]
                        {
                        pushFollow(FOLLOW_globalVector_in_pinAssign609);
                        globalVector(slices, (name!=null?name.getText():null), des, instName);

                        state._fsp--;


                        }
                        break;

                }

                pushFollow(FOLLOW_concatenation_in_pinAssign615);
                concatenation(concats, slices.size(), des);

                state._fsp--;


                match(input, Token.UP, null); 
            }
            	
            				// for all the indices in the array list
            				for (int j = 0; j < indices.size(); j++) {
            					// for all isntances with this name
            					for (InstanceNode inst : des.getAllInstances(instName)) {
            						// assign pins for only those that 
            						if(inst.getIndex() == indices.get(j)) {
            							assignPins(slices, concats, inst, name);
            						}
            					}
            				}
            				if (indices.isEmpty()) {
            					InstanceNode inst = des.getInstance(instName);
            					assignPins(slices, concats, inst, name);
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:689:1: concatenation[List<NetNode> concats, int assignWidth, DesignNode des] : ( (first= IDENT ( sliceList[slices] | globalNet[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | globalNet[slices, $next.text, des] ) )* ) | ( LEFTANGLE global= IDENT ( sliceList[slices] | globalNet[slices, $global.text, des] ) ) | ( 'open' ) ) ;
    public final void concatenation(List<NetNode> concats, int assignWidth, DesignNode des) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;
        CommonTree global=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:693:2: ( ( (first= IDENT ( sliceList[slices] | globalNet[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | globalNet[slices, $next.text, des] ) )* ) | ( LEFTANGLE global= IDENT ( sliceList[slices] | globalNet[slices, $global.text, des] ) ) | ( 'open' ) ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:694:4: ( (first= IDENT ( sliceList[slices] | globalNet[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | globalNet[slices, $next.text, des] ) )* ) | ( LEFTANGLE global= IDENT ( sliceList[slices] | globalNet[slices, $global.text, des] ) ) | ( 'open' ) )
            {
            List<Integer> slices = new ArrayList<Integer>();
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:696:3: ( (first= IDENT ( sliceList[slices] | globalNet[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | globalNet[slices, $next.text, des] ) )* ) | ( LEFTANGLE global= IDENT ( sliceList[slices] | globalNet[slices, $global.text, des] ) ) | ( 'open' ) )
            int alt18=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt18=1;
                }
                break;
            case LEFTANGLE:
                {
                alt18=2;
                }
                break;
            case 38:
                {
                alt18=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:696:4: (first= IDENT ( sliceList[slices] | globalNet[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | globalNet[slices, $next.text, des] ) )* )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:696:4: (first= IDENT ( sliceList[slices] | globalNet[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | globalNet[slices, $next.text, des] ) )* )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:696:5: first= IDENT ( sliceList[slices] | globalNet[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | globalNet[slices, $next.text, des] ) )*
                    {
                    first=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenation664); 
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:696:17: ( sliceList[slices] | globalNet[slices, $first.text, des] )
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==COMMA||(LA14_0>=LEFTBRACKET && LA14_0<=COLON)) ) {
                        alt14=1;
                    }
                    else if ( ((LA14_0>=UP && LA14_0<=IDENT)) ) {
                        alt14=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 0, input);

                        throw nvae;
                    }
                    switch (alt14) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:696:18: sliceList[slices]
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation667);
                            sliceList(slices);

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:696:38: globalNet[slices, $first.text, des]
                            {
                            pushFollow(FOLLOW_globalNet_in_concatenation672);
                            globalNet(slices, (first!=null?first.getText():null), des);

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
                    					System.out.println("netName: " + (first!=null?first.getText():null));
                    					for (NetNode n : des.getAllNets((first!=null?first.getText():null))) {
                    						if (n.getIndex() == slices.get(i)) {
                    							concats.add(n);
                    						}
                    					}
                    				}

                    			
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:720:3: (next= IDENT ( sliceList[slices] | globalNet[slices, $next.text, des] ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==IDENT) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:720:4: next= IDENT ( sliceList[slices] | globalNet[slices, $next.text, des] )
                    	    {
                    	    next=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenation703); 
                    	    slices.clear();
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:724:3: ( sliceList[slices] | globalNet[slices, $next.text, des] )
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
                    	            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:724:4: sliceList[slices]
                    	            {
                    	            pushFollow(FOLLOW_sliceList_in_concatenation727);
                    	            sliceList(slices);

                    	            state._fsp--;


                    	            }
                    	            break;
                    	        case 2 :
                    	            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:724:24: globalNet[slices, $next.text, des]
                    	            {
                    	            pushFollow(FOLLOW_globalNet_in_concatenation732);
                    	            globalNet(slices, (next!=null?next.getText():null), des);

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
                    	    					for (NetNode n : des.getAllNets((first!=null?first.getText():null))) {
                    	    						if (n.getIndex() == slices.get(i)) {
                    	    							concats.add(n);
                    	    						}
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:746:10: ( LEFTANGLE global= IDENT ( sliceList[slices] | globalNet[slices, $global.text, des] ) )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:746:10: ( LEFTANGLE global= IDENT ( sliceList[slices] | globalNet[slices, $global.text, des] ) )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:746:11: LEFTANGLE global= IDENT ( sliceList[slices] | globalNet[slices, $global.text, des] )
                    {
                    match(input,LEFTANGLE,FOLLOW_LEFTANGLE_in_concatenation766); 
                    global=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenation770); 
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:746:34: ( sliceList[slices] | globalNet[slices, $global.text, des] )
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==COMMA||(LA17_0>=LEFTBRACKET && LA17_0<=COLON)) ) {
                        alt17=1;
                    }
                    else if ( ((LA17_0>=UP && LA17_0<=IDENT)) ) {
                        alt17=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;
                    }
                    switch (alt17) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:746:35: sliceList[slices]
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation773);
                            sliceList(slices);

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:746:55: globalNet[slices, $global.text, des]
                            {
                            pushFollow(FOLLOW_globalNet_in_concatenation778);
                            globalNet(slices, (global!=null?global.getText():null), des);

                            state._fsp--;


                            }
                            break;

                    }


                    }

                    	if (assignWidth==0) assignWidth++;
                    				if (slices.size()==1) {
                    					NetNode n = des.getNet((global!=null?global.getText():null) + "[" + slices.get(0) + "]");
                    					for (int i = 0; i < assignWidth; i++) {
                    						concats.add(n);
                    					}
                    				} else if(slices.isEmpty()) {
                    					NetNode n = des.getNet((global!=null?global.getText():null));
                    					for (int i = 0; i < assignWidth; i++) {
                    						concats.add(n);
                    					}
                    				} else {
                    					addError(global, "assignment cannot replicate a net vector");
                    				}
                    			

                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:766:5: ( 'open' )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:766:5: ( 'open' )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:766:6: 'open'
                    {
                    match(input,38,FOLLOW_38_in_concatenation810); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:788:1: instanceQualifier[String instName, List<Integer> indices, DesignNode des] : ^( PERIOD qualName= IDENT ( arrayList[indices] | globalArray[indices, instName, des] ) ) ;
    public final void instanceQualifier(String instName, List<Integer> indices, DesignNode des) throws RecognitionException {
        CommonTree qualName=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:800:2: ( ^( PERIOD qualName= IDENT ( arrayList[indices] | globalArray[indices, instName, des] ) ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:800:4: ^( PERIOD qualName= IDENT ( arrayList[indices] | globalArray[indices, instName, des] ) )
            {
            match(input,PERIOD,FOLLOW_PERIOD_in_instanceQualifier848); 

            match(input, Token.DOWN, null); 
            qualName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instanceQualifier852); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:800:28: ( arrayList[indices] | globalArray[indices, instName, des] )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==COMMA||LA19_0==COLON||LA19_0==LEFTPAREN) ) {
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:800:29: arrayList[indices]
                    {
                    pushFollow(FOLLOW_arrayList_in_instanceQualifier855);
                    arrayList(indices);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:800:50: globalArray[indices, instName, des]
                    {
                    pushFollow(FOLLOW_globalArray_in_instanceQualifier860);
                    globalArray(indices, instName, des);

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


    // $ANTLR start "globalArray"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:812:1: globalArray[List<Integer> indices, String instName, DesignNode des] : ;
    public final void globalArray(List<Integer> indices, String instName, DesignNode des) throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:813:2: ()
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:813:4: 
            {
            indices.addAll(des.getAllIndices(instName));

            }

        }
        finally {
        }
        return ;
    }
    // $ANTLR end "globalArray"


    // $ANTLR start "globalVector"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:816:1: globalVector[List<Integer> slices, String pinName, DesignNode des, String instName] : ;
    public final void globalVector(List<Integer> slices, String pinName, DesignNode des, String instName) throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:817:2: ()
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:817:4: 
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
    // $ANTLR end "globalVector"


    // $ANTLR start "globalNet"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:824:1: globalNet[List<Integer> slices, String netName, DesignNode des] : ;
    public final void globalNet(List<Integer> slices, String netName, DesignNode des) throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:825:2: ()
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:825:4: 
            {
            slices.addAll(des.getAllNetIndices(netName));

            }

        }
        finally {
        }
        return ;
    }
    // $ANTLR end "globalNet"


    // $ANTLR start "arrayList"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:828:1: arrayList[List<Integer> indices] : ( ^( COMMA LEFTPAREN first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTPAREN first= INTEGER last= INTEGER ) | ( LEFTPAREN single= INTEGER ) );
    public final void arrayList(List<Integer> indices) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;
        CommonTree last=null;
        CommonTree single=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:839:2: ( ^( COMMA LEFTPAREN first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTPAREN first= INTEGER last= INTEGER ) | ( LEFTPAREN single= INTEGER ) )
            int alt21=3;
            switch ( input.LA(1) ) {
            case COMMA:
                {
                alt21=1;
                }
                break;
            case COLON:
                {
                alt21=2;
                }
                break;
            case LEFTPAREN:
                {
                alt21=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:839:4: ^( COMMA LEFTPAREN first= INTEGER (next= INTEGER )* )
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_arrayList941); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList943); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList947); 
                    indices.add(Integer.parseInt((first!=null?first.getText():null)));
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:840:8: (next= INTEGER )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==INTEGER) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:840:9: next= INTEGER
                    	    {
                    	    next=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList962); 
                    	    indices.add(Integer.parseInt((next!=null?next.getText():null)));

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:842:5: ^( COLON LEFTPAREN first= INTEGER last= INTEGER )
                    {
                    match(input,COLON,FOLLOW_COLON_in_arrayList989); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList991); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList995); 
                    last=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList999); 
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:859:4: ( LEFTPAREN single= INTEGER )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:859:4: ( LEFTPAREN single= INTEGER )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:859:5: LEFTPAREN single= INTEGER
                    {
                    match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList1029); 
                    single=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1033); 
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:862:1: sliceList[List<Integer> slices] : ( ^( COMMA LEFTBRACKET first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTBRACKET first= INTEGER last= INTEGER ) | ( LEFTBRACKET single= INTEGER ) );
    public final void sliceList(List<Integer> slices) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;
        CommonTree last=null;
        CommonTree single=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:873:2: ( ^( COMMA LEFTBRACKET first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTBRACKET first= INTEGER last= INTEGER ) | ( LEFTBRACKET single= INTEGER ) )
            int alt23=3;
            switch ( input.LA(1) ) {
            case COMMA:
                {
                alt23=1;
                }
                break;
            case COLON:
                {
                alt23=2;
                }
                break;
            case LEFTBRACKET:
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:873:4: ^( COMMA LEFTBRACKET first= INTEGER (next= INTEGER )* )
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_sliceList1057); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList1059); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1063); 
                    slices.add(Integer.parseInt((first!=null?first.getText():null)));
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:874:8: (next= INTEGER )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==INTEGER) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:874:9: next= INTEGER
                    	    {
                    	    next=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1079); 
                    	    slices.add(Integer.parseInt((next!=null?next.getText():null)));

                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:876:4: ^( COLON LEFTBRACKET first= INTEGER last= INTEGER )
                    {
                    match(input,COLON,FOLLOW_COLON_in_sliceList1106); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList1108); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1112); 
                    last=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1116); 
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:895:4: ( LEFTBRACKET single= INTEGER )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:895:4: ( LEFTBRACKET single= INTEGER )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:895:5: LEFTBRACKET single= INTEGER
                    {
                    match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList1145); 
                    single=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1149); 
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:899:1: pinList[List<String> pList] : first= ( PIN | INTEGER | IDENT ) (next= ( PIN | INTEGER | IDENT ) )* ;
    public final void pinList(List<String> pList) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:910:2: (first= ( PIN | INTEGER | IDENT ) (next= ( PIN | INTEGER | IDENT ) )* )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:910:4: first= ( PIN | INTEGER | IDENT ) (next= ( PIN | INTEGER | IDENT ) )*
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
            					addError(first, "duplicate exists in pin list");
            				pList.add((first!=null?first.getText():null));
            			
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:921:7: (next= ( PIN | INTEGER | IDENT ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==IDENT||(LA24_0>=PIN && LA24_0<=INTEGER)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker.g:921:8: next= ( PIN | INTEGER | IDENT )
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
            	    					addError(first, "duplicate exists in pin list");
            	    				pList.add((next!=null?next.getText():null));
            	    			

            	    }
            	    break;

            	default :
            	    break loop24;
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
            return "()* loopback of 557:3: ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )*";
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
    public static final BitSet FOLLOW_sliceList_in_pinDecl292 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl298 = new BitSet(new long[]{0x0000000000006010L});
    public static final BitSet FOLLOW_pinList_in_pinDecl300 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_34_in_netDecl334 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_sliceList_in_netDecl357 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl363 = new BitSet(new long[]{0x0000000100000008L});
    public static final BitSet FOLLOW_attributeDecl_in_netDecl365 = new BitSet(new long[]{0x0000000100000008L});
    public static final BitSet FOLLOW_35_in_instDecl401 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arrayList_in_instDecl423 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instDecl429 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instDecl433 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_attrAssign_in_instDecl455 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_pinAssign_in_instDecl460 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_EQUALS_in_attrAssign481 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_37_in_attrAssign505 = new BitSet(new long[]{0x0000000000000110L});
    public static final BitSet FOLLOW_instanceQualifier_in_attrAssign513 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_globalArray_in_attrAssign518 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attrAssign526 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_in_attrAssign530 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssign562 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_instanceQualifier_in_pinAssign587 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_globalArray_in_pinAssign592 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinAssign601 = new BitSet(new long[]{0x0000004000068410L});
    public static final BitSet FOLLOW_sliceList_in_pinAssign604 = new BitSet(new long[]{0x0000004000068410L});
    public static final BitSet FOLLOW_globalVector_in_pinAssign609 = new BitSet(new long[]{0x0000004000068410L});
    public static final BitSet FOLLOW_concatenation_in_pinAssign615 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENT_in_concatenation664 = new BitSet(new long[]{0x0000000000068010L});
    public static final BitSet FOLLOW_sliceList_in_concatenation667 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_globalNet_in_concatenation672 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_IDENT_in_concatenation703 = new BitSet(new long[]{0x0000000000068010L});
    public static final BitSet FOLLOW_sliceList_in_concatenation727 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_globalNet_in_concatenation732 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_LEFTANGLE_in_concatenation766 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation770 = new BitSet(new long[]{0x0000000000068000L});
    public static final BitSet FOLLOW_sliceList_in_concatenation773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_globalNet_in_concatenation778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_concatenation810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_instanceQualifier848 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_instanceQualifier852 = new BitSet(new long[]{0x0000000000148008L});
    public static final BitSet FOLLOW_arrayList_in_instanceQualifier855 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_globalArray_in_instanceQualifier860 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMMA_in_arrayList941 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList943 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList947 = new BitSet(new long[]{0x0000000000004008L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList962 = new BitSet(new long[]{0x0000000000004008L});
    public static final BitSet FOLLOW_COLON_in_arrayList989 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList991 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList995 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList999 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList1029 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_sliceList1057 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList1059 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1063 = new BitSet(new long[]{0x0000000000004008L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1079 = new BitSet(new long[]{0x0000000000004008L});
    public static final BitSet FOLLOW_COLON_in_sliceList1106 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList1108 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1112 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1116 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList1145 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_pinList1175 = new BitSet(new long[]{0x0000000000006012L});
    public static final BitSet FOLLOW_set_in_pinList1214 = new BitSet(new long[]{0x0000000000006012L});

}