// $ANTLR 3.3 Nov 30, 2010 12:50:56 /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g 2011-07-27 10:32:49

/*
    Copyright (C) 2011  BYU Configurable Computing Lab

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

	package phdl.grammar;
	import java.util.TreeSet;
	import java.util.Set;
	import java.util.HashSet;
	import java.util.SortedSet;
	import java.util.List;
	import java.util.ArrayList;
	import java.util.regex.Pattern;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "SEMICOLON", "EQUALS", "STRING", "COMMA", "PERIOD", "AMPERSAND", "LEFTANGLE", "RIGHTANGLE", "LEFTBRACE", "INTEGER", "RIGHTBRACE", "LEFTBRACKET", "COLON", "RIGHTBRACKET", "LEFTPAREN", "RIGHTPAREN", "CHAR", "DIGIT", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "INCLUDE", "'design'", "'is'", "'begin'", "'end'", "'device'", "'attr'", "'pin'", "'net'", "'inst'", "'of'", "'newattr'", "'this'", "'open'"
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
    public static final int COMMA=8;
    public static final int PERIOD=9;
    public static final int AMPERSAND=10;
    public static final int LEFTANGLE=11;
    public static final int RIGHTANGLE=12;
    public static final int LEFTBRACE=13;
    public static final int INTEGER=14;
    public static final int RIGHTBRACE=15;
    public static final int LEFTBRACKET=16;
    public static final int COLON=17;
    public static final int RIGHTBRACKET=18;
    public static final int LEFTPAREN=19;
    public static final int RIGHTPAREN=20;
    public static final int CHAR=21;
    public static final int DIGIT=22;
    public static final int WHITESPACE=23;
    public static final int LINE_COMMENT=24;
    public static final int MULTILINE_COMMENT=25;
    public static final int INCLUDE=26;

    // delegates
    // delegators


        public PhdlWalker(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public PhdlWalker(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PhdlWalker.tokenNames; }
    public String getGrammarFileName() { return "/fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g"; }



    	/**
    	 * The set of required attributes
    	 */
    	private Set<String> reqAttrs = new HashSet<String>();
    	/**
    	 * The list of errors
    	 */
    	private List<String> errors = new ArrayList<String>();
    	/**
    	 * The list of warnings
    	 */
    	private List<String> warnings = new ArrayList<String>();
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
    	public List<String> getErrors() {
    		return errors;
    	}
    	
    	/**
    	 * Called to obtain the warnings if any exist after walking and processing the tree
    	 */
    	public List<String> getWarnings() {
    		return warnings;
    	}
    	
    	/**
    	 * Adds an error from a Node object
    	 */
    	private void addError(Node n, String message) {
    		String error = n.getFileName() + " line " + n.getLine() + ":" + n.getPosition() + " "
    			+ message + ": " + n.getName();
    		if (!errors.contains(error))
    			errors.add(error);
    	}

    	/**
    	 * Adds an error from a CommonTree object
    	 */
    	private void addError(CommonTree ct, String message) {
    		String error = ct.getToken().getInputStream().getSourceName() + " line " + ct.getLine()
    			+ ":" + ct.getCharPositionInLine() + " " + message + ": " + ct.getText();
    		if (!errors.contains(error))
    			errors.add(error);
    	}

    	/**
    	 * Reports an error from a Node object exits
    	 */
    	private void bailOut(Node n, String message) {
    		System.out.println("ERROR: " + n.getFileName() + " line " + n.getLine() + ":"
    			+ n.getPosition() + " " + message + ": " + n.getName());
    		System.exit(1);
    	}

    	/**
    	 * Reports an error from a CommonTree object and exits
    	 */
    	private void bailOut(CommonTree ct, String message) {
    		System.out.println("ERROR: " + ct.getToken().getInputStream().getSourceName() + " line "
    				+ ct.getLine() + ":" + ct.getCharPositionInLine() + " " + message + ": "
    				+ ct.getText());
    		System.exit(1);
    	}

    	/**
    	 * Adds a warning from a Node object
    	 */
    	private void addWarning(Node n, String message) {
    		String warning = n.getFileName() + " line " + n.getLine() + ":" + n.getPosition() + " "
    			+ message + ": " + n.getName();
    		if (!warnings.contains(warning))
    			warnings.add(warning);
    	}

    	/**
    	 * Adds a warning from a CommonTree object
    	 */
    	private void addWarning(CommonTree ct, String message) {
    		String warning = ct.getToken().getInputStream().getSourceName() + " line " + ct.getLine()
    			+ ":" + ct.getCharPositionInLine() + " " + message + ": " + ct.getText();
    		if (!warnings.contains(warning))
    			warnings.add(warning);
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
    	private void assignPins(int start, List<Integer> slices, List<NetNode> concats, InstanceNode inst, CommonTree pinNode) {
    		if (start == -1) {
    			// Non-arrayed instance
    			assignNonArrayed(slices, concats, inst, pinNode);
    		}
    		else {
    			// Arrayed instance
    			assignArrayed(start, slices, concats, inst, pinNode);
    		}
    	}
    	
    	/**
    	 * Helper method for assignPins for arrayed instances
    	 */
    	private void assignArrayed(int start, List<Integer> slices, List<NetNode> concats, InstanceNode inst, CommonTree pinNode) {
    		String pinName = pinNode.getText();
    		if (slices.isEmpty()) {	// Single-bit lval
    			// Grab one net from concats
    			PinNode p = inst.getPin(pinName);
    			setConcatToPin(p, concats.get(start), pinNode);
    		} else {	// Multi-bit lval
    			for (int i = 0; i < slices.size(); i++) {
    				PinNode p = inst.getPin(pinName + "[" + slices.get(i) + "]");
    				setConcatToPin(p, concats.get(i + start), pinNode);
    			}
    		}
    	}
    	
    	/**
    	 *
    	 */
    	private void setConcatToPin(PinNode p, NetNode n, CommonTree pinNode) {
    		if (p != null) {
    			if (p.hasNet()) {
    				addWarning(p, "pin " + p.getIndex() + " already assigned");
    			}
    			p.setNet(n);
    			if (n != null) {
    				n.addPin(p);
    			}
    		}
    		else {
    			addError(pinNode, "pin undelcared in device");
    		}
    	}
    	
    	/**
    	 * Helper method for assignPins for non-arrayed instances
    	 */
    	private void assignNonArrayed(List<Integer> slices, List<NetNode> concats, InstanceNode inst, CommonTree pinNode) {
    		String pinName = pinNode.getText();
    		if (slices.isEmpty()) {	// Single-bit lval
    			if (concats.size() == 1) {	// Single-bit rval
    				setConcatToPin(inst.getPin(pinName), concats.get(0), pinNode);
    			} else {	// Multi-bit rval, ERROR
    				bailOut(pinNode, "invalid assignment, left size is " 
    						+ slices.size() + " right size is " + concats.size());
    			}
    		} else {	// Multi-bit lval
    			if (concats.size() == slices.size()) {	// Verify same length
    				for (int i = 0; i < concats.size(); i++) {
    					PinNode p = inst.getPin(pinName + "[" + slices.get(i) + "]");
    					setConcatToPin(p, concats.get(i), pinNode);
    				}
    			} else {	// Invalid length, ERROR
    				bailOut(pinNode, "invalid assignment, left size is " 
    						+ slices.size() + " right size is " + concats.size());
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
        
        @Override
        protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow)
        		throws RecognitionException
    	{   
        	throw new MismatchedTokenException(ttype, input);
    	}  



    // $ANTLR start "sourceText"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:276:1: sourceText : ( designDecl )* ;
    public final void sourceText() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:283:2: ( ( designDecl )* )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:283:4: ( designDecl )*
            {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:283:4: ( designDecl )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==27) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:283:4: designDecl
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:286:1: designDecl : ^( 'design' desName= IDENT ( deviceDecl[des] | netDecl[des] )* 'begin' ( instDecl[des] | netAssign[des] )* (endName= IDENT )? ) ;
    public final void designDecl() throws RecognitionException {
        CommonTree desName=null;
        CommonTree endName=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:299:2: ( ^( 'design' desName= IDENT ( deviceDecl[des] | netDecl[des] )* 'begin' ( instDecl[des] | netAssign[des] )* (endName= IDENT )? ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:299:4: ^( 'design' desName= IDENT ( deviceDecl[des] | netDecl[des] )* 'begin' ( instDecl[des] | netAssign[des] )* (endName= IDENT )? )
            {
            match(input,27,FOLLOW_27_in_designDecl76); 

            match(input, Token.DOWN, null); 
            desName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_designDecl80); 
            	// make a new design based on the identifier and log its location
            				DesignNode des = new DesignNode();
            				des.setName((desName!=null?desName.getText():null));
            				des.setLocation((desName!=null?desName.getLine():0), (desName!=null?desName.getCharPositionInLine():0), 
            					desName.getToken().getInputStream().getSourceName());
            				
            				// clear these sets each time a design is processed
            				netDecls.clear();
            				instanceDecls.clear();
            			
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:314:3: ( deviceDecl[des] | netDecl[des] )*
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
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:314:4: deviceDecl[des]
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_designDecl104);
            	    deviceDecl(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:314:22: netDecl[des]
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
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:315:3: ( instDecl[des] | netAssign[des] )*
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
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:315:4: instDecl[des]
            	    {
            	    pushFollow(FOLLOW_instDecl_in_designDecl120);
            	    instDecl(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:315:20: netAssign[des]
            	    {
            	    pushFollow(FOLLOW_netAssign_in_designDecl125);
            	    netAssign(des);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:315:37: (endName= IDENT )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==IDENT) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:315:38: endName= IDENT
                    {
                    endName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_designDecl133); 

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
            				
            				Set<String> refDesSet = new HashSet<String>();
            				
            				// report any dangling pins in all instances
            				for (InstanceNode i : des.getInstances()) {
            					for (PinNode p : i.getPins()) {
            						if (!p.hasNet())
            							addError(i, "dangling pin " + p.getName() + " in instance");
            					}
            					if (i.getRefDes() != null) {
            						if (!i.getRefDes().equals("")) {
            							//System.out.println(i.getRefDes());
            							// report duplicate reference designators
            							if (!refDesSet.add(i.getRefDes())) {
            								//System.out.println(i.getRefDes());
            								addError(i, "duplicate reference designator in design");
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
    // $ANTLR end "designDecl"


    // $ANTLR start "deviceDecl"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:366:1: deviceDecl[DesignNode des] : ^( 'device' devName= IDENT ( attributeDecl[devices] | pinDecl[dev] )* (endName= IDENT )? ) ;
    public final void deviceDecl(DesignNode des) throws RecognitionException {
        CommonTree devName=null;
        CommonTree endName=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:378:2: ( ^( 'device' devName= IDENT ( attributeDecl[devices] | pinDecl[dev] )* (endName= IDENT )? ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:378:4: ^( 'device' devName= IDENT ( attributeDecl[devices] | pinDecl[dev] )* (endName= IDENT )? )
            {
            match(input,31,FOLLOW_31_in_deviceDecl170); 

            match(input, Token.DOWN, null); 
            devName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl174); 
            	// make a new device based on the identifier and log its location
            				DeviceNode dev = new DeviceNode(des);
            				dev.setName((devName!=null?devName.getText():null));
            				dev.setLocation((devName!=null?devName.getLine():0), (devName!=null?devName.getCharPositionInLine():0), 
            					devName.getToken().getInputStream().getSourceName());
            					
            				List<Attributable> devices = new ArrayList<Attributable>();
            				devices.add(dev);
            				
            				// clear these sets each time a device is processed
            				attrDecls.clear();
            				pinDecls.clear();
            			
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:396:3: ( attributeDecl[devices] | pinDecl[dev] )*
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
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:396:4: attributeDecl[devices]
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_deviceDecl201);
            	    attributeDecl(devices);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:396:29: pinDecl[dev]
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl206);
            	    pinDecl(dev);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:396:51: (endName= IDENT )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==IDENT) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:396:51: endName= IDENT
                    {
                    endName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl213); 

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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:419:1: attributeDecl[List<Attributable> parents] : ^( 'attr' attrName= IDENT attrValue= STRING ) ;
    public final void attributeDecl(List<Attributable> parents) throws RecognitionException {
        CommonTree attrName=null;
        CommonTree attrValue=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:431:2: ( ^( 'attr' attrName= IDENT attrValue= STRING ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:431:4: ^( 'attr' attrName= IDENT attrValue= STRING )
            {
            match(input,32,FOLLOW_32_in_attributeDecl246); 

            match(input, Token.DOWN, null); 
            attrName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attributeDecl250); 
            attrValue=(CommonTree)match(input,STRING,FOLLOW_STRING_in_attributeDecl254); 

            match(input, Token.UP, null); 
            	for (Attributable parent : parents) {
            		    		// make a new attribute node, assign its parent, and log its location
            		    		AttributeNode a  = new AttributeNode(parent);
            		    		a.setName((attrName!=null?attrName.getText():null));
            					a.setValue((attrValue!=null?attrValue.getText():null));
            		    		a.setLocation((attrName!=null?attrName.getLine():0), (attrName!=null?attrName.getCharPositionInLine():0), 
            		    			attrName.getToken().getInputStream().getSourceName());
            					parent.addAttribute(a);
            				}
            				// report any duplicate attribute declarations
            				if (!attrDecls.add((attrName!=null?attrName.getText():null).toUpperCase()))
            					addError(attrName, "duplicate attribute declaration");
            						
            				// check if the attribute is a refprefix attribute
            				if ((attrName!=null?attrName.getText():null).equals("REFPREFIX")) {
            					// check to see if refPrefix begins with a letter
            					if (!Pattern.compile("^[A-Z]").matcher((attrValue!=null?attrValue.getText():null)).find())
            						addError(attrName, "invalid refPrefix in device");
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
    // $ANTLR end "attributeDecl"


    // $ANTLR start "pinDecl"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:457:1: pinDecl[DeviceNode dev] : ^( 'pin' ( sliceList[sList] )? pinName= IDENT pinList[pList] ) ;
    public final void pinDecl(DeviceNode dev) throws RecognitionException {
        CommonTree pinName=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:475:2: ( ^( 'pin' ( sliceList[sList] )? pinName= IDENT pinList[pList] ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:475:4: ^( 'pin' ( sliceList[sList] )? pinName= IDENT pinList[pList] )
            {
            match(input,33,FOLLOW_33_in_pinDecl291); 

             	// sets to keep track of the slice and pin lists
            				List<Integer> sList = new ArrayList<Integer>(); 
            				List<String> pList = new ArrayList<String>();
            			

            match(input, Token.DOWN, null); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:484:3: ( sliceList[sList] )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==COMMA||(LA7_0>=LEFTBRACKET && LA7_0<=COLON)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:484:3: sliceList[sList]
                    {
                    pushFollow(FOLLOW_sliceList_in_pinDecl313);
                    sliceList(sList);

                    state._fsp--;


                    }
                    break;

            }

            pinName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinDecl319); 
            pushFollow(FOLLOW_pinList_in_pinDecl321);
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
            					newPin.setLocation((pinName!=null?pinName.getLine():0), (pinName!=null?pinName.getCharPositionInLine():0), 
            						pinName.getToken().getInputStream().getSourceName());
            	        		
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
            					newPin.setLocation((pinName!=null?pinName.getLine():0), (pinName!=null?pinName.getCharPositionInLine():0), 
            						pinName.getToken().getInputStream().getSourceName());
            					
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:540:1: netDecl[DesignNode des] : ^( 'net' ( sliceList[slices] )? firstName= IDENT ( COMMA nextName= IDENT )* ( attributeDecl[netNodes] )* (endName= IDENT )? ) ;
    public final void netDecl(DesignNode des) throws RecognitionException {
        CommonTree firstName=null;
        CommonTree nextName=null;
        CommonTree endName=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:549:2: ( ^( 'net' ( sliceList[slices] )? firstName= IDENT ( COMMA nextName= IDENT )* ( attributeDecl[netNodes] )* (endName= IDENT )? ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:549:4: ^( 'net' ( sliceList[slices] )? firstName= IDENT ( COMMA nextName= IDENT )* ( attributeDecl[netNodes] )* (endName= IDENT )? )
            {
            match(input,34,FOLLOW_34_in_netDecl355); 

            	List<Integer> slices = new ArrayList<Integer>();
            				List<Attributable> netNodes = new ArrayList<Attributable>();
            				attrDecls.clear();
            			

            match(input, Token.DOWN, null); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:558:3: ( sliceList[slices] )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==COMMA||(LA8_0>=LEFTBRACKET && LA8_0<=COLON)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:558:3: sliceList[slices]
                    {
                    pushFollow(FOLLOW_sliceList_in_netDecl378);
                    sliceList(slices);

                    state._fsp--;


                    }
                    break;

            }

            firstName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netDecl390); 
            	for (int i = 0; i < slices.size(); i++) {
            					NetNode newNet = new NetNode(des);
            					newNet.setName((firstName!=null?firstName.getText():null) + "[" + slices.get(i) + "]");
            					newNet.setLocation((firstName!=null?firstName.getLine():0), (firstName!=null?firstName.getCharPositionInLine():0), 
            						firstName.getToken().getInputStream().getSourceName());
            					netNodes.add(newNet);
            				}
            				
            				if (slices.isEmpty()) {
            					NetNode newNet = new NetNode(des);
            					newNet.setName((firstName!=null?firstName.getText():null));
            					newNet.setLocation((firstName!=null?firstName.getLine():0), (firstName!=null?firstName.getCharPositionInLine():0), 
            						firstName.getToken().getInputStream().getSourceName());
            					netNodes.add(newNet);
            				}
            			
            			
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:582:3: ( COMMA nextName= IDENT )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==COMMA) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:582:4: COMMA nextName= IDENT
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_netDecl420); 
            	    nextName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netDecl424); 
            	    	for (int i = 0; i < slices.size(); i++) {
            	    					NetNode newNet = new NetNode(des);
            	    					newNet.setName((nextName!=null?nextName.getText():null) + "[" + slices.get(i) + "]");
            	    					newNet.setLocation((nextName!=null?nextName.getLine():0), (nextName!=null?nextName.getCharPositionInLine():0), 
            	    						nextName.getToken().getInputStream().getSourceName());
            	    					netNodes.add(newNet);
            	    				}
            	    				
            	    				if (slices.isEmpty()) {
            	    					NetNode newNet = new NetNode(des);
            	    					newNet.setName((nextName!=null?nextName.getText():null));
            	    					newNet.setLocation((nextName!=null?nextName.getLine():0), (nextName!=null?nextName.getCharPositionInLine():0), 
            	    						nextName.getToken().getInputStream().getSourceName());
            	    					netNodes.add(newNet);
            	    				}
            	    			
            	    			

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:605:3: ( attributeDecl[netNodes] )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==32) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:605:3: attributeDecl[netNodes]
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_netDecl454);
            	    attributeDecl(netNodes);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:605:35: (endName= IDENT )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==IDENT) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:605:35: endName= IDENT
                    {
                    endName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netDecl460); 

                    }
                    break;

            }


            match(input, Token.UP, null); 
            	for (Attributable n : netNodes) {
            			
            					// check for duplicate net declarations
            					if(!des.addNet((NetNode) n))
            						addError(n, "duplicate net declaration");
            					
            					// check for overall duplicates based solely on the name of the net
            					if (!netDecls.add(n.getName()))
            						addError(n, "duplicate net declaration");
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


    // $ANTLR start "instDecl"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:622:1: instDecl[DesignNode des] : ^( 'inst' ( arrayList[indices] )? instName= IDENT devName= IDENT ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )* (endName= IDENT )? ) ;
    public final void instDecl(DesignNode des) throws RecognitionException {
        CommonTree instName=null;
        CommonTree devName=null;
        CommonTree endName=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:633:2: ( ^( 'inst' ( arrayList[indices] )? instName= IDENT devName= IDENT ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )* (endName= IDENT )? ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:633:4: ^( 'inst' ( arrayList[indices] )? instName= IDENT devName= IDENT ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )* (endName= IDENT )? )
            {
            match(input,35,FOLLOW_35_in_instDecl494); 

            	// Set of instance nodes to check for duplicates
            				List<InstanceNode> instNodes = new ArrayList<InstanceNode>();
            				// List of indices to be derived from the arrayList
            				List<Integer> indices = new ArrayList<Integer>();
            			

            match(input, Token.DOWN, null); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:643:3: ( arrayList[indices] )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==COMMA||LA12_0==COLON||LA12_0==LEFTPAREN) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:643:3: arrayList[indices]
                    {
                    pushFollow(FOLLOW_arrayList_in_instDecl516);
                    arrayList(indices);

                    state._fsp--;


                    }
                    break;

            }

            instName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl522); 
            devName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl526); 
            	// make as many instance nodes as there are indices
            				for (int j = 0; j < indices.size(); j++) {
            				
            					InstanceNode i = new InstanceNode(des);
            					i.setName((instName!=null?instName.getText():null) + "(" + indices.get(j) + ")");
            					i.setLocation((instName!=null?instName.getLine():0), (instName!=null?instName.getCharPositionInLine():0), 
            						instName.getToken().getInputStream().getSourceName());
            					
            					// find the corresponding device declaration
            					DeviceNode dev = des.getDevice((devName!=null?devName.getText():null));
            					if (dev != null) {
            						i.setDevice(dev);
            						// copy all of the attribute and pin nodes from the device definition
            						for (AttributeNode a: dev.getAttributes()) {
            							i.addAttribute(new AttributeNode(a, i));
            						}
            						for (PinNode pn: dev.getPins())
            							i.addPin(new PinNode(pn, i));
            						instNodes.add(i);
            					} else
            						bailOut(i, "instance references undeclared device");
            					
            				}
            				
            				// otherwise make only one instance node based on the instName
            				if (indices.isEmpty()) {
            					InstanceNode i = new InstanceNode(des);
            					i.setName((instName!=null?instName.getText():null));
            					i.setLocation((instName!=null?instName.getLine():0), (instName!=null?instName.getCharPositionInLine():0), 
            						instName.getToken().getInputStream().getSourceName());
            					
            					// find the corresponding device declaration
            					DeviceNode dev = des.getDevice((devName!=null?devName.getText():null));
            					if (dev != null) {
            						i.setDevice(dev);
            						// add all of the attribute and pin nodes from the device definition
            						for (AttributeNode a: dev.getAttributes())
            							i.addAttribute(new AttributeNode(a, i));
            						for (PinNode pn: dev.getPins())
            							i.addPin(new PinNode(pn, i));
            						instNodes.add(i);
            					} else
            						bailOut(i, "instance references undeclared device");
            							
            				}
            			
            				// check for duplicates
            				for (InstanceNode i : instNodes) {
            					if(!des.addInstance(i))
            						addError(i, "duplicate instance declaration");
            				}
            				
            				// check for overall duplicates based solely on the instName
            				if (!instanceDecls.add((instName!=null?instName.getText():null)))
            					addError(instName, "duplicate instance declaration");
            			
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:704:3: ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )*
            loop13:
            do {
                int alt13=3;
                alt13 = dfa13.predict(input);
                switch (alt13) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:704:4: attrAssign[des, $instName.text]
            	    {
            	    pushFollow(FOLLOW_attrAssign_in_instDecl548);
            	    attrAssign(des, (instName!=null?instName.getText():null));

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:704:38: pinAssign[des, $instName.text]
            	    {
            	    pushFollow(FOLLOW_pinAssign_in_instDecl553);
            	    pinAssign(des, (instName!=null?instName.getText():null));

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:704:78: (endName= IDENT )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==IDENT) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:704:78: endName= IDENT
                    {
                    endName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl560); 

                    }
                    break;

            }


            match(input, Token.UP, null); 
            	// check the optional trailing label on the design to see if it maches
            				if (endName != null) {
            					if (!(instName!=null?instName.getText():null).equals((endName!=null?endName.getText():null)))
            						addError(endName, "inst name " + (instName!=null?instName.getText():null) + " does not match");
            				}
            				
            				// obtain the device which the instance references
            				DeviceNode dev = des.getDevice((devName!=null?devName.getText():null));
            				String refPrefix = null;
            				if (dev != null) {
            					// obtain the reference prefix defined in the device
            					for (AttributeNode a : dev.getAttributes()) {
            						if (a.getName().equals("REFPREFIX"))
            							refPrefix = a.getValue();
            					}
            				}
            				
            				// assign the reference prefix and designator if it exists
            				for (InstanceNode i : des.getAllInstances((instName!=null?instName.getText():null))) {

            					for (AttributeNode a : i.getAttributes()) {
            						if (a.getName().equals("REFPREFIX"))
            							i.setRefPrefix(a.getValue());
            						if (a.getName().equals("REFDES"))
            							i.setRefDes(a.getValue());
            						if (a.getName().equals("PKG_TYPE"))
            							i.setFootprint(a.getValue());
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
    // $ANTLR end "instDecl"


    // $ANTLR start "attrAssign"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:740:1: attrAssign[DesignNode des, String instName] : ^( EQUALS ( 'newattr' )? ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] ) attrName= IDENT attrValue= STRING ) ;
    public final void attrAssign(DesignNode des, String instName) throws RecognitionException {
        CommonTree attrName=null;
        CommonTree attrValue=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:757:2: ( ^( EQUALS ( 'newattr' )? ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] ) attrName= IDENT attrValue= STRING ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:757:4: ^( EQUALS ( 'newattr' )? ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] ) attrName= IDENT attrValue= STRING )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_attrAssign594); 

            	// flag for a new attribute and a list of indices the attribute assignment applies to
            				boolean newAttr = false;
            				List<Integer> indices = new ArrayList<Integer>();
            			

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:766:3: ( 'newattr' )?
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==37) ) {
                    alt15=1;
                }
                switch (alt15) {
                    case 1 :
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:766:4: 'newattr'
                        {
                        match(input,37,FOLLOW_37_in_attrAssign618); 
                        newAttr = true;

                        }
                        break;

                }

                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:767:3: ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] )
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
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:767:4: instanceQualifier[instName, indices, des]
                        {
                        pushFollow(FOLLOW_instanceQualifier_in_attrAssign628);
                        instanceQualifier(instName, indices, des);

                        state._fsp--;


                        }
                        break;
                    case 2 :
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:767:48: arrayIndices[indices, instName, des]
                        {
                        pushFollow(FOLLOW_arrayIndices_in_attrAssign633);
                        arrayIndices(indices, instName, des);

                        state._fsp--;


                        }
                        break;

                }

                attrName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attrAssign641); 
                attrValue=(CommonTree)match(input,STRING,FOLLOW_STRING_in_attrAssign645); 

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
            							// check if the attribute is a refprefix attribute
            							if (a.getName().equals("REFPREFIX")) {
            								// check to see if refPrefix begins with a letter
            								if (!Pattern.compile("^[A-Z]").matcher((attrValue!=null?attrValue.getText():null)).find())
            									bailOut(attrValue, "invalid refPrefix value");
            							}
            							if (newAttr)
            								addWarning(attrName, "new attribute already declared in device");
            							// overwrite the attribute value
            							if (!a.overwrite((attrValue!=null?attrValue.getText():null)))
            								addWarning(attrName, "atribute already overwritten");
            						} else {
            							if ((attrName!=null?attrName.getText():null).toUpperCase().equals("REFDES")) {
            								AttributeNode newA = new AttributeNode(inst);
            								newA.setName((attrName!=null?attrName.getText():null));
            								newA.setValue((attrValue!=null?attrValue.getText():null));
            								newA.setLocation((attrName!=null?attrName.getLine():0), (attrName!=null?attrName.getCharPositionInLine():0), 
            									attrName.getToken().getInputStream().getSourceName());
            								inst.addAttribute(newA);
            							}
            							// the attribute doesn't exist
            							else if (newAttr) {
            								// make a new attribute if explicitly asked to do so
            								AttributeNode newA = new AttributeNode(inst);
            								newA.setName((attrName!=null?attrName.getText():null));
            								newA.setValue((attrValue!=null?attrValue.getText():null));
            								newA.setLocation((attrName!=null?attrName.getLine():0), (attrName!=null?attrName.getCharPositionInLine():0), 
            									attrName.getToken().getInputStream().getSourceName());
            								inst.addAttribute(newA);
            							} else {
            								if ((attrName!=null?attrName.getText():null).toUpperCase().equals("REFDES")) {
            									AttributeNode newA = new AttributeNode(inst);
            									newA.setName((attrName!=null?attrName.getText():null));
            									newA.setValue((attrValue!=null?attrValue.getText():null));
            									newA.setLocation((attrName!=null?attrName.getLine():0), (attrName!=null?attrName.getCharPositionInLine():0), 
            										attrName.getToken().getInputStream().getSourceName());
            									inst.addAttribute(newA);
            								} else {
            									// report that the attribute is undeclared
            									addError(attrName, "attribute undeclared in device");
            								}
            							}
            						}
            					} else {
            						// the instance node does not exist
            						addError(attrName, instName + "(" + indices.get(i) + ")" + 
            							" attribute undeclared");
            					}
            				}
            				// if the attribute is global
            				if (indices.isEmpty()) {
            					// for every instance node with this instance name
            					for (InstanceNode inst : des.getAllInstances(instName)) {
            						// find its attribute by the attribute name
            						AttributeNode a = inst.getAttribute((attrName!=null?attrName.getText():null));
            						if (a!=null) {
            							// check if the attribute is a refprefix attribute
            							if (a.getName().equals("REFPREFIX")) {
            								// check to see if refPrefix begins with a letter
            								if (!Pattern.compile("^[A-Z]").matcher((attrValue!=null?attrValue.getText():null)).find())
            									bailOut(attrValue, "invalid refPrefix value");
            							}
            							if (newAttr)
            								addWarning(attrName, "new attribute already declared in device");
            							// overwrite the attribute value
            							if(!a.overwrite((attrValue!=null?attrValue.getText():null)))
            								addWarning(attrName, "atribute already overwritten");
            						} else {
            							if ((attrName!=null?attrName.getText():null).toUpperCase().equals("REFDES")) {
            								AttributeNode newA = new AttributeNode(inst);
            								newA.setName((attrName!=null?attrName.getText():null));
            								newA.setValue((attrValue!=null?attrValue.getText():null));
            								newA.setLocation((attrName!=null?attrName.getLine():0), (attrName!=null?attrName.getCharPositionInLine():0), 
            									attrName.getToken().getInputStream().getSourceName());
            								inst.addAttribute(newA);
            							}
            							// the attribute doesn't exist
            							else if (newAttr) {
            								// make a new attribute if explicitly asked to do so
            								AttributeNode newA = new AttributeNode(inst);
            								newA.setName((attrName!=null?attrName.getText():null));
            								newA.setValue((attrValue!=null?attrValue.getText():null));
            								newA.setLocation((attrName!=null?attrName.getLine():0), (attrName!=null?attrName.getCharPositionInLine():0), 
            									attrName.getToken().getInputStream().getSourceName());
            								inst.addAttribute(newA);
            							} else {
            								// report that the attribute is undeclared
            								addError(attrName, instName + " attribute undeclared");
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:875:1: pinAssign[DesignNode des, String instName] : ^( EQUALS ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] ) pinName= IDENT ( sliceList[slices] | pinSlices[slices, $pinName.text, des, instName] ) concatenation[concats, assignWidth, des] ) ;
    public final void pinAssign(DesignNode des, String instName) throws RecognitionException {
        CommonTree pinName=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:876:2: ( ^( EQUALS ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] ) pinName= IDENT ( sliceList[slices] | pinSlices[slices, $pinName.text, des, instName] ) concatenation[concats, assignWidth, des] ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:876:4: ^( EQUALS ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] ) pinName= IDENT ( sliceList[slices] | pinSlices[slices, $pinName.text, des, instName] ) concatenation[concats, assignWidth, des] )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_pinAssign676); 

            	List<Integer> indices = new ArrayList<Integer>();
            				List<Integer> slices = new ArrayList<Integer>();
            				List<NetNode> concats = new ArrayList<NetNode>();
            			

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:884:3: ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] )
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==PERIOD) ) {
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
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:884:4: instanceQualifier[instName, indices, des]
                        {
                        pushFollow(FOLLOW_instanceQualifier_in_pinAssign697);
                        instanceQualifier(instName, indices, des);

                        state._fsp--;


                        }
                        break;
                    case 2 :
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:884:48: arrayIndices[indices, instName, des]
                        {
                        pushFollow(FOLLOW_arrayIndices_in_pinAssign702);
                        arrayIndices(indices, instName, des);

                        state._fsp--;


                        }
                        break;

                }

                pinName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinAssign711); 
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:885:17: ( sliceList[slices] | pinSlices[slices, $pinName.text, des, instName] )
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
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:885:18: sliceList[slices]
                        {
                        pushFollow(FOLLOW_sliceList_in_pinAssign714);
                        sliceList(slices);

                        state._fsp--;


                        }
                        break;
                    case 2 :
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:885:38: pinSlices[slices, $pinName.text, des, instName]
                        {
                        pushFollow(FOLLOW_pinSlices_in_pinAssign719);
                        pinSlices(slices, (pinName!=null?pinName.getText():null), des, instName);

                        state._fsp--;


                        }
                        break;

                }

                 int assignWidth = 0;
                		  if (slices.size() == 0 && indices.size() != 0) {assignWidth = indices.size();}
                		  if (slices.size() != 0 && indices.size() == 0) {assignWidth = slices.size();}
                		  if (slices.size() != 0 && indices.size() != 0) {assignWidth = indices.size() * slices.size();}
                		
                pushFollow(FOLLOW_concatenation_in_pinAssign730);
                concatenation(concats, assignWidth, des);

                state._fsp--;


                match(input, Token.UP, null); 
            }
            	
            				if (indices.size() != 0 && slices.size() != 0) {
            					if (indices.size() * slices.size() != concats.size()) {
            						// TODO Throw Error
            						// Arrayed and Sliced
            						bailOut(pinName, "Invalid assignment width, left = " + indices.size() * slices.size() + ", right = " + concats.size());
            					}
            				}
            				else if (slices.size() != 0) {
            					if (slices.size() != concats.size()) {
            						// TODO Throw Error
            						// Not Arrayed and Sliced
            						bailOut(pinName, "Invalid assignment width, left = " + slices.size() + ", right = " + concats.size());
            					}
            				}
            				else if (indices.size() != 0) {
            					if (indices.size() != concats.size()) {
            						// TODO Throw Error
            						// Arrayed and Not Sliced
            						bailOut(pinName, "Invalid assignment width, left = " + slices.size() + ", right = " + concats.size());
            					}
            				}
            			
            				// for all the indices in the array list
            				for (int j = 0; j < indices.size(); j++) {
            					// for all isntances with this pinName
            					for (InstanceNode inst : des.getAllInstances(instName)) {
            						// assign pins for only those whose index is in the list of indices
            						if(inst.getIndex() == indices.get(j)) {
            							int start;
            							if (slices.size() == 0) {
            								start = j;
            							} else {
            								start = j * slices.size();
            							}
            							assignPins(start, slices, concats, inst, pinName);
            						}
            					}
            				}
            				if (indices.isEmpty()) {
            					InstanceNode inst = des.getInstance(instName);
            					assignPins(-1,slices, concats, inst, pinName);
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:942:1: netAssign[DesignNode des] : ^( EQUALS netName= IDENT ( sliceList[slices] | netSlices[slices, $netName.text, des] ) concatenation[concats, slices.size(), des] ) ;
    public final void netAssign(DesignNode des) throws RecognitionException {
        CommonTree netName=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:943:2: ( ^( EQUALS netName= IDENT ( sliceList[slices] | netSlices[slices, $netName.text, des] ) concatenation[concats, slices.size(), des] ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:943:4: ^( EQUALS netName= IDENT ( sliceList[slices] | netSlices[slices, $netName.text, des] ) concatenation[concats, slices.size(), des] )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_netAssign762); 

            	List<Integer> slices = new ArrayList<Integer>();
            				List<NetNode> concats = new ArrayList<NetNode>();
            			

            match(input, Token.DOWN, null); 
            netName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netAssign786); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:951:17: ( sliceList[slices] | netSlices[slices, $netName.text, des] )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==COMMA||(LA19_0>=LEFTBRACKET && LA19_0<=COLON)) ) {
                alt19=1;
            }
            else if ( (LA19_0==IDENT||LA19_0==LEFTANGLE||LA19_0==39) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:951:18: sliceList[slices]
                    {
                    pushFollow(FOLLOW_sliceList_in_netAssign789);
                    sliceList(slices);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:951:38: netSlices[slices, $netName.text, des]
                    {
                    pushFollow(FOLLOW_netSlices_in_netAssign794);
                    netSlices(slices, (netName!=null?netName.getText():null), des);

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_concatenation_in_netAssign800);
            concatenation(concats, slices.size(), des);

            state._fsp--;


            match(input, Token.UP, null); 
            	if (concats.contains(des.getNet("open"))) {
            					bailOut(netName, "cannot assign open to a net");
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
            						bailOut(netName, "invalid assignment, left width is " 
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
            						bailOut(netName, "invalid assignment, left width is " 
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:992:1: concatenation[List<NetNode> concats, int assignWidth, DesignNode des] : ( (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* ) | ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) ) | ( 'open' ) ) ;
    public final void concatenation(List<NetNode> concats, int assignWidth, DesignNode des) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;
        CommonTree global=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:996:2: ( ( (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* ) | ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) ) | ( 'open' ) ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:997:4: ( (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* ) | ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) ) | ( 'open' ) )
            {
            List<Integer> slices = new ArrayList<Integer>();
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:999:3: ( (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* ) | ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) ) | ( 'open' ) )
            int alt24=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt24=1;
                }
                break;
            case LEFTANGLE:
                {
                alt24=2;
                }
                break;
            case 39:
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
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:999:4: (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* )
                    {
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:999:4: (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* )
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:999:5: first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )*
                    {
                    first=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenation852); 
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:999:17: ( sliceList[slices] | concatSlices[slices, $first.text, des] )
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
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:999:18: sliceList[slices]
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation855);
                            sliceList(slices);

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:999:38: concatSlices[slices, $first.text, des]
                            {
                            pushFollow(FOLLOW_concatSlices_in_concatenation860);
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
                    						bailOut(first, "undeclared net");
                    					}
                    				}
                    			
                    				for (int i = 0; i < slices.size(); i++) {
                    					List<NetNode> nets = des.getAllNets((first!=null?first.getText():null));
                    					if (!nets.isEmpty()) {
                    						for (NetNode n : nets) {
                    							if (n.getIndex() == slices.get(i))
                    								concats.add(n);
                    						}
                    					} else {
                    						bailOut(first, "undeclared net");
                    					}
                    				}
                    			
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1025:3: (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==IDENT) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1025:4: next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] )
                    	    {
                    	    next=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenation891); 
                    	    slices.clear();
                    	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1029:3: ( sliceList[slices] | concatSlices[slices, $next.text, des] )
                    	    int alt21=2;
                    	    int LA21_0 = input.LA(1);

                    	    if ( (LA21_0==COMMA||(LA21_0>=LEFTBRACKET && LA21_0<=COLON)) ) {
                    	        alt21=1;
                    	    }
                    	    else if ( ((LA21_0>=UP && LA21_0<=IDENT)) ) {
                    	        alt21=2;
                    	    }
                    	    else {
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 21, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt21) {
                    	        case 1 :
                    	            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1029:4: sliceList[slices]
                    	            {
                    	            pushFollow(FOLLOW_sliceList_in_concatenation915);
                    	            sliceList(slices);

                    	            state._fsp--;


                    	            }
                    	            break;
                    	        case 2 :
                    	            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1029:24: concatSlices[slices, $next.text, des]
                    	            {
                    	            pushFollow(FOLLOW_concatSlices_in_concatenation920);
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
                    	    						bailOut(next, "undeclared net");
                    	    					}
                    	    				}
                    	    				
                    	    				for (int i = 0; i < slices.size(); i++) {
                    	    					List<NetNode> nets = des.getAllNets((next!=null?next.getText():null));
                    	    					if (!nets.isEmpty()) {
                    	    						for (NetNode n : des.getAllNets((next!=null?next.getText():null))) {
                    	    							if (n.getIndex() == slices.get(i))
                    	    								concats.add(n);
                    	    						}
                    	    					} else {
                    	    						bailOut(next, "undeclared net");
                    	    					}
                    	    				}
                    	    			

                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1055:10: ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) )
                    {
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1055:10: ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) )
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1055:11: LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] )
                    {
                    match(input,LEFTANGLE,FOLLOW_LEFTANGLE_in_concatenation954); 
                    global=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenation958); 
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1055:34: ( sliceList[slices] | concatSlices[slices, $global.text, des] )
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==COMMA||(LA23_0>=LEFTBRACKET && LA23_0<=COLON)) ) {
                        alt23=1;
                    }
                    else if ( ((LA23_0>=UP && LA23_0<=IDENT)) ) {
                        alt23=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 23, 0, input);

                        throw nvae;
                    }
                    switch (alt23) {
                        case 1 :
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1055:35: sliceList[slices]
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation961);
                            sliceList(slices);

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1055:55: concatSlices[slices, $global.text, des]
                            {
                            pushFollow(FOLLOW_concatSlices_in_concatenation966);
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
                    						for (int i = 0; i < assignWidth; i++)
                    							concats.add(n);
                    					} else {
                    						bailOut(global, "undeclared net");
                    					}
                    				} else if(slices.isEmpty()) {
                    					NetNode n = des.getNet((global!=null?global.getText():null));
                    					if (n != null) {
                    						for (int i = 0; i < assignWidth; i++)
                    							concats.add(n);
                    					} else {
                    						bailOut(global, "undeclared net");
                    					}
                    				} else {
                    					bailOut(global, "assignment cannot replicate a net vector");
                    				}
                    			

                    }
                    break;
                case 3 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1081:5: ( 'open' )
                    {
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1081:5: ( 'open' )
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1081:6: 'open'
                    {
                    match(input,39,FOLLOW_39_in_concatenation998); 

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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1103:1: instanceQualifier[String instName, List<Integer> indices, DesignNode des] : ^( PERIOD (qualName= IDENT | ( 'this' ) ) ( arrayList[indices] | arrayIndices[indices, instName, des] ) ) ;
    public final void instanceQualifier(String instName, List<Integer> indices, DesignNode des) throws RecognitionException {
        CommonTree qualName=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1115:2: ( ^( PERIOD (qualName= IDENT | ( 'this' ) ) ( arrayList[indices] | arrayIndices[indices, instName, des] ) ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1115:4: ^( PERIOD (qualName= IDENT | ( 'this' ) ) ( arrayList[indices] | arrayIndices[indices, instName, des] ) )
            {
            boolean isThis = false;
            match(input,PERIOD,FOLLOW_PERIOD_in_instanceQualifier1040); 

            match(input, Token.DOWN, null); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1116:12: (qualName= IDENT | ( 'this' ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==IDENT) ) {
                alt25=1;
            }
            else if ( (LA25_0==38) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1116:13: qualName= IDENT
                    {
                    qualName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instanceQualifier1045); 

                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1116:30: ( 'this' )
                    {
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1116:30: ( 'this' )
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1116:31: 'this'
                    {
                    match(input,38,FOLLOW_38_in_instanceQualifier1050); 
                    isThis = true;

                    }


                    }
                    break;

            }

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1116:57: ( arrayList[indices] | arrayIndices[indices, instName, des] )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==COMMA||LA26_0==COLON||LA26_0==LEFTPAREN) ) {
                alt26=1;
            }
            else if ( ((LA26_0>=UP && LA26_0<=IDENT)) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1116:58: arrayList[indices]
                    {
                    pushFollow(FOLLOW_arrayList_in_instanceQualifier1057);
                    arrayList(indices);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1116:79: arrayIndices[indices, instName, des]
                    {
                    pushFollow(FOLLOW_arrayIndices_in_instanceQualifier1062);
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1129:1: arrayIndices[List<Integer> indices, String instName, DesignNode des] : ;
    public final void arrayIndices(List<Integer> indices, String instName, DesignNode des) throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1130:2: ()
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1130:4: 
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1133:1: pinSlices[List<Integer> slices, String pinName, DesignNode des, String instName] : ;
    public final void pinSlices(List<Integer> slices, String pinName, DesignNode des, String instName) throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1134:2: ()
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1134:4: 
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1140:1: netSlices[List<Integer> slices, String netName, DesignNode des] : ;
    public final void netSlices(List<Integer> slices, String netName, DesignNode des) throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1141:2: ()
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1141:4: 
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1146:1: concatSlices[List<Integer> slices, String netName, DesignNode des] : ;
    public final void concatSlices(List<Integer> slices, String netName, DesignNode des) throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1147:2: ()
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1147:4: 
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1150:1: arrayList[List<Integer> indices] : ( ^( COMMA LEFTPAREN first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTPAREN first= INTEGER last= INTEGER ) | ( LEFTPAREN single= INTEGER ) );
    public final void arrayList(List<Integer> indices) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;
        CommonTree last=null;
        CommonTree single=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1161:2: ( ^( COMMA LEFTPAREN first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTPAREN first= INTEGER last= INTEGER ) | ( LEFTPAREN single= INTEGER ) )
            int alt28=3;
            switch ( input.LA(1) ) {
            case COMMA:
                {
                alt28=1;
                }
                break;
            case COLON:
                {
                alt28=2;
                }
                break;
            case LEFTPAREN:
                {
                alt28=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1162:3: ^( COMMA LEFTPAREN first= INTEGER (next= INTEGER )* )
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_arrayList1156); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList1158); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1162); 
                    indices.add(Integer.parseInt((first!=null?first.getText():null)));
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1163:8: (next= INTEGER )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==INTEGER) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1163:9: next= INTEGER
                    	    {
                    	    next=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1177); 
                    	    indices.add(Integer.parseInt((next!=null?next.getText():null)));

                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1166:5: ^( COLON LEFTPAREN first= INTEGER last= INTEGER )
                    {
                    match(input,COLON,FOLLOW_COLON_in_arrayList1212); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList1214); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1218); 
                    last=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1222); 
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
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1184:4: ( LEFTPAREN single= INTEGER )
                    {
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1184:4: ( LEFTPAREN single= INTEGER )
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1184:5: LEFTPAREN single= INTEGER
                    {
                    match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList1255); 
                    single=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1259); 
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1187:1: sliceList[List<Integer> slices] : ( ^( COMMA LEFTBRACKET first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTBRACKET first= INTEGER last= INTEGER ) | ( LEFTBRACKET single= INTEGER ) );
    public final void sliceList(List<Integer> slices) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;
        CommonTree last=null;
        CommonTree single=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1198:2: ( ^( COMMA LEFTBRACKET first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTBRACKET first= INTEGER last= INTEGER ) | ( LEFTBRACKET single= INTEGER ) )
            int alt30=3;
            switch ( input.LA(1) ) {
            case COMMA:
                {
                alt30=1;
                }
                break;
            case COLON:
                {
                alt30=2;
                }
                break;
            case LEFTBRACKET:
                {
                alt30=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1199:3: ^( COMMA LEFTBRACKET first= INTEGER (next= INTEGER )* )
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_sliceList1286); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList1288); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1292); 
                    slices.add(Integer.parseInt((first!=null?first.getText():null)));
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1200:8: (next= INTEGER )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==INTEGER) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1200:9: next= INTEGER
                    	    {
                    	    next=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1308); 
                    	    slices.add(Integer.parseInt((next!=null?next.getText():null)));

                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1203:4: ^( COLON LEFTBRACKET first= INTEGER last= INTEGER )
                    {
                    match(input,COLON,FOLLOW_COLON_in_sliceList1343); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList1345); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1349); 
                    last=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1353); 
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
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1223:4: ( LEFTBRACKET single= INTEGER )
                    {
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1223:4: ( LEFTBRACKET single= INTEGER )
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1223:5: LEFTBRACKET single= INTEGER
                    {
                    match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList1385); 
                    single=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1389); 
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1227:1: pinList[List<String> pList] : first= ( INTEGER | IDENT ) (next= ( INTEGER | IDENT ) )* ;
    public final void pinList(List<String> pList) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1238:2: (first= ( INTEGER | IDENT ) (next= ( INTEGER | IDENT ) )* )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1238:4: first= ( INTEGER | IDENT ) (next= ( INTEGER | IDENT ) )*
            {
            first=(CommonTree)input.LT(1);
            if ( input.LA(1)==IDENT||input.LA(1)==INTEGER ) {
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
            			
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1249:7: (next= ( INTEGER | IDENT ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==IDENT||LA31_0==INTEGER) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlWalker.g:1249:8: next= ( INTEGER | IDENT )
            	    {
            	    next=(CommonTree)input.LT(1);
            	    if ( input.LA(1)==IDENT||input.LA(1)==INTEGER ) {
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
            	    break loop31;
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


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\32\uffff";
    static final String DFA13_eofS =
        "\32\uffff";
    static final String DFA13_minS =
        "\1\3\1\uffff\1\2\1\4\1\uffff\1\2\2\4\1\uffff\2\3\2\2\1\16\1\4\2"+
        "\23\1\3\2\16\1\3\1\16\4\3";
    static final String DFA13_maxS =
        "\1\6\1\uffff\1\2\1\45\1\uffff\1\2\1\47\1\46\1\uffff\2\23\2\2\1\16"+
        "\1\4\2\23\1\3\5\16\3\3";
    static final String DFA13_acceptS =
        "\1\uffff\1\3\2\uffff\1\1\3\uffff\1\2\21\uffff";
    static final String DFA13_specialS =
        "\32\uffff}>";
    static final String[] DFA13_transitionS = {
            "\2\1\1\uffff\1\2",
            "",
            "\1\3",
            "\1\6\4\uffff\1\5\33\uffff\1\4",
            "",
            "\1\7",
            "\1\10\2\uffff\1\4\1\10\2\uffff\1\10\4\uffff\2\10\25\uffff\1"+
            "\10",
            "\1\11\41\uffff\1\12",
            "",
            "\1\16\4\uffff\1\13\10\uffff\1\14\1\uffff\1\15",
            "\1\16\4\uffff\1\13\10\uffff\1\14\1\uffff\1\15",
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

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "()* loopback of 704:3: ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )*";
        }
    }
 

    public static final BitSet FOLLOW_designDecl_in_sourceText61 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_designDecl76 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_designDecl80 = new BitSet(new long[]{0x00000004A0000000L});
    public static final BitSet FOLLOW_deviceDecl_in_designDecl104 = new BitSet(new long[]{0x00000004A0000000L});
    public static final BitSet FOLLOW_netDecl_in_designDecl109 = new BitSet(new long[]{0x00000004A0000000L});
    public static final BitSet FOLLOW_29_in_designDecl114 = new BitSet(new long[]{0x0000000800000058L});
    public static final BitSet FOLLOW_instDecl_in_designDecl120 = new BitSet(new long[]{0x0000000800000058L});
    public static final BitSet FOLLOW_netAssign_in_designDecl125 = new BitSet(new long[]{0x0000000800000058L});
    public static final BitSet FOLLOW_IDENT_in_designDecl133 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_31_in_deviceDecl170 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl174 = new BitSet(new long[]{0x0000000300000018L});
    public static final BitSet FOLLOW_attributeDecl_in_deviceDecl201 = new BitSet(new long[]{0x0000000300000018L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl206 = new BitSet(new long[]{0x0000000300000018L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl213 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_32_in_attributeDecl246 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_attributeDecl250 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_in_attributeDecl254 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_33_in_pinDecl291 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_sliceList_in_pinDecl313 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl319 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_pinList_in_pinDecl321 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_34_in_netDecl355 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_sliceList_in_netDecl378 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl390 = new BitSet(new long[]{0x0000000100000118L});
    public static final BitSet FOLLOW_COMMA_in_netDecl420 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl424 = new BitSet(new long[]{0x0000000100000118L});
    public static final BitSet FOLLOW_attributeDecl_in_netDecl454 = new BitSet(new long[]{0x0000000100000018L});
    public static final BitSet FOLLOW_IDENT_in_netDecl460 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_35_in_instDecl494 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arrayList_in_instDecl516 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instDecl522 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instDecl526 = new BitSet(new long[]{0x0000000000000058L});
    public static final BitSet FOLLOW_attrAssign_in_instDecl548 = new BitSet(new long[]{0x0000000000000058L});
    public static final BitSet FOLLOW_pinAssign_in_instDecl553 = new BitSet(new long[]{0x0000000000000058L});
    public static final BitSet FOLLOW_IDENT_in_instDecl560 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUALS_in_attrAssign594 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_37_in_attrAssign618 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_instanceQualifier_in_attrAssign628 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_arrayIndices_in_attrAssign633 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attrAssign641 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_in_attrAssign645 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssign676 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_instanceQualifier_in_pinAssign697 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_arrayIndices_in_pinAssign702 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinAssign711 = new BitSet(new long[]{0x0000008000030910L});
    public static final BitSet FOLLOW_sliceList_in_pinAssign714 = new BitSet(new long[]{0x0000008000030910L});
    public static final BitSet FOLLOW_pinSlices_in_pinAssign719 = new BitSet(new long[]{0x0000008000030910L});
    public static final BitSet FOLLOW_concatenation_in_pinAssign730 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUALS_in_netAssign762 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_netAssign786 = new BitSet(new long[]{0x0000008000030910L});
    public static final BitSet FOLLOW_sliceList_in_netAssign789 = new BitSet(new long[]{0x0000008000030910L});
    public static final BitSet FOLLOW_netSlices_in_netAssign794 = new BitSet(new long[]{0x0000008000030910L});
    public static final BitSet FOLLOW_concatenation_in_netAssign800 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENT_in_concatenation852 = new BitSet(new long[]{0x0000000000030110L});
    public static final BitSet FOLLOW_sliceList_in_concatenation855 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_concatSlices_in_concatenation860 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_IDENT_in_concatenation891 = new BitSet(new long[]{0x0000000000030110L});
    public static final BitSet FOLLOW_sliceList_in_concatenation915 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_concatSlices_in_concatenation920 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_LEFTANGLE_in_concatenation954 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation958 = new BitSet(new long[]{0x0000000000030100L});
    public static final BitSet FOLLOW_sliceList_in_concatenation961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_concatSlices_in_concatenation966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_concatenation998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_instanceQualifier1040 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_instanceQualifier1045 = new BitSet(new long[]{0x00000000000A0108L});
    public static final BitSet FOLLOW_38_in_instanceQualifier1050 = new BitSet(new long[]{0x00000000000A0108L});
    public static final BitSet FOLLOW_arrayList_in_instanceQualifier1057 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_arrayIndices_in_instanceQualifier1062 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMMA_in_arrayList1156 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList1158 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1162 = new BitSet(new long[]{0x0000000000004008L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1177 = new BitSet(new long[]{0x0000000000004008L});
    public static final BitSet FOLLOW_COLON_in_arrayList1212 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList1214 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1218 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1222 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList1255 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_sliceList1286 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList1288 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1292 = new BitSet(new long[]{0x0000000000004008L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1308 = new BitSet(new long[]{0x0000000000004008L});
    public static final BitSet FOLLOW_COLON_in_sliceList1343 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList1345 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1349 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1353 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList1385 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_pinList1415 = new BitSet(new long[]{0x0000000000004012L});
    public static final BitSet FOLLOW_set_in_pinList1450 = new BitSet(new long[]{0x0000000000004012L});

}