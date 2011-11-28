// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g 2011-11-28 09:34:26

/*
    Copyright (C) 2011  Brigham Young University

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, version 3.

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "LEFTBRACE", "RIGHTBRACE", "EQUALS", "STRING", "SEMICOLON", "COMMA", "PERIOD", "AMPERSAND", "LEFTANGLE", "RIGHTANGLE", "INTEGER", "LEFTBRACKET", "COLON", "RIGHTBRACKET", "LEFTPAREN", "RIGHTPAREN", "CHAR", "DIGIT", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "INCLUDE", "'design'", "'device'", "'attr'", "'pin'", "'net'", "'inst'", "'of'", "'info'", "'group'", "'newattr'", "'each'", "'combine'", "'open'"
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
    public static final int LEFTBRACE=5;
    public static final int RIGHTBRACE=6;
    public static final int EQUALS=7;
    public static final int STRING=8;
    public static final int SEMICOLON=9;
    public static final int COMMA=10;
    public static final int PERIOD=11;
    public static final int AMPERSAND=12;
    public static final int LEFTANGLE=13;
    public static final int RIGHTANGLE=14;
    public static final int INTEGER=15;
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
    public String getGrammarFileName() { return "C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g"; }



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
    	private void assignPins(int start, List<Integer> slices, List<NetNode> concats, InstanceNode inst, CommonTree pinNode, boolean combine) {
    		if (start == -1) {
    			// Non-arrayed instance
    			assignNonArrayed(slices, concats, inst, pinNode);
    		}
    		else {
    			// Arrayed instance
    			if (combine)
    			 assignArrayedCombine(start, slices, concats, inst, pinNode);
    			else
    			 assignArrayedEach(slices, concats, inst, pinNode);
    		}
    	}
    	
    	/**
    	 * Helper method for assignPins for arrayed instances
    	 */
    	private void assignArrayedCombine(int start, List<Integer> slices, List<NetNode> concats, InstanceNode inst, CommonTree pinNode) {
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
       * Helper method for assignPins for arrayed instances
       */
      private void assignArrayedEach(List<Integer> slices, List<NetNode> concats, InstanceNode inst, CommonTree pinNode) {
        String pinName = pinNode.getText();
        if (slices.isEmpty()) { // Single-bit lval
          // Grab one net from concats
          PinNode p = inst.getPin(pinName);
          setConcatToPin(p, concats.get(0), pinNode);
        } else {  // Multi-bit lval
          for (int i = 0; i < slices.size(); i++) {
            PinNode p = inst.getPin(pinName + "[" + slices.get(i) + "]");
            setConcatToPin(p, concats.get(i), pinNode);
          }
        }
      }
    	
    	/**
    	 * forms the link between a pin node and net node in the design.
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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:294:1: sourceText : ( designDecl )* ;
    public final void sourceText() throws RecognitionException {
        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:301:2: ( ( designDecl )* )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:301:4: ( designDecl )*
            {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:301:4: ( designDecl )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==27) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:301:4: designDecl
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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:304:1: designDecl : ^( 'design' desName= IDENT ( deviceDecl[des] | netDecl[des] | infoStruct | instDecl[des, null] | netAssign[des] | groupStruct[des] )* ) ;
    public final void designDecl() throws RecognitionException {
        CommonTree desName=null;
        String infoStruct1 = null;


        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:317:2: ( ^( 'design' desName= IDENT ( deviceDecl[des] | netDecl[des] | infoStruct | instDecl[des, null] | netAssign[des] | groupStruct[des] )* ) )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:317:4: ^( 'design' desName= IDENT ( deviceDecl[des] | netDecl[des] | infoStruct | instDecl[des, null] | netAssign[des] | groupStruct[des] )* )
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
            			
            String info = "";
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:332:3: ( deviceDecl[des] | netDecl[des] | infoStruct | instDecl[des, null] | netAssign[des] | groupStruct[des] )*
            loop2:
            do {
                int alt2=7;
                switch ( input.LA(1) ) {
                case 28:
                    {
                    alt2=1;
                    }
                    break;
                case 31:
                    {
                    alt2=2;
                    }
                    break;
                case 34:
                    {
                    alt2=3;
                    }
                    break;
                case 32:
                    {
                    alt2=4;
                    }
                    break;
                case EQUALS:
                    {
                    alt2=5;
                    }
                    break;
                case 35:
                    {
                    alt2=6;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:332:4: deviceDecl[des]
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_designDecl105);
            	    deviceDecl(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:332:22: netDecl[des]
            	    {
            	    pushFollow(FOLLOW_netDecl_in_designDecl110);
            	    netDecl(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:332:37: infoStruct
            	    {
            	    pushFollow(FOLLOW_infoStruct_in_designDecl115);
            	    infoStruct1=infoStruct();

            	    state._fsp--;

            	    des.appendInfo(infoStruct1);

            	    }
            	    break;
            	case 4 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:332:87: instDecl[des, null]
            	    {
            	    pushFollow(FOLLOW_instDecl_in_designDecl121);
            	    instDecl(des, null);

            	    state._fsp--;


            	    }
            	    break;
            	case 5 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:332:109: netAssign[des]
            	    {
            	    pushFollow(FOLLOW_netAssign_in_designDecl126);
            	    netAssign(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 6 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:332:126: groupStruct[des]
            	    {
            	    pushFollow(FOLLOW_groupStruct_in_designDecl131);
            	    groupStruct(des);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
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
            				
            				Set<String> refDesSet = new HashSet<String>();
            				
            				// report any dangling pins in all instances
            				for (InstanceNode i : des.getInstances()) {
            					for (PinNode p : i.getPins()) {
            						if (!p.hasNet())
            							addError(i, "dangling pin " + p.getName() + " in instance");
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


    // $ANTLR start "infoStruct"
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:360:1: infoStruct returns [String value] : ^( 'info' string= STRING ) ;
    public final String infoStruct() throws RecognitionException {
        String value = null;

        CommonTree string=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:361:2: ( ^( 'info' string= STRING ) )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:361:5: ^( 'info' string= STRING )
            {
            match(input,34,FOLLOW_34_in_infoStruct168); 

            match(input, Token.DOWN, null); 
            string=(CommonTree)match(input,STRING,FOLLOW_STRING_in_infoStruct172); 
            value = (string!=null?string.getText():null);

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "infoStruct"


    // $ANTLR start "groupStruct"
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:364:1: groupStruct[DesignNode des] : ^( 'group' groupName= STRING ( instDecl[des, $groupName.text] | netAssign[des] )* ) ;
    public final void groupStruct(DesignNode des) throws RecognitionException {
        CommonTree groupName=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:365:2: ( ^( 'group' groupName= STRING ( instDecl[des, $groupName.text] | netAssign[des] )* ) )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:365:4: ^( 'group' groupName= STRING ( instDecl[des, $groupName.text] | netAssign[des] )* )
            {
            match(input,35,FOLLOW_35_in_groupStruct190); 

            match(input, Token.DOWN, null); 
            groupName=(CommonTree)match(input,STRING,FOLLOW_STRING_in_groupStruct194); 
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:365:31: ( instDecl[des, $groupName.text] | netAssign[des] )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==32) ) {
                    alt3=1;
                }
                else if ( (LA3_0==EQUALS) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:365:32: instDecl[des, $groupName.text]
            	    {
            	    pushFollow(FOLLOW_instDecl_in_groupStruct197);
            	    instDecl(des, (groupName!=null?groupName.getText():null));

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:365:65: netAssign[des]
            	    {
            	    pushFollow(FOLLOW_netAssign_in_groupStruct202);
            	    netAssign(des);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
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
    // $ANTLR end "groupStruct"


    // $ANTLR start "deviceDecl"
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:368:1: deviceDecl[DesignNode des] : ^( 'device' devName= IDENT ( attributeDecl[devices] | pinDecl[dev] )* ) ;
    public final void deviceDecl(DesignNode des) throws RecognitionException {
        CommonTree devName=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:380:2: ( ^( 'device' devName= IDENT ( attributeDecl[devices] | pinDecl[dev] )* ) )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:380:4: ^( 'device' devName= IDENT ( attributeDecl[devices] | pinDecl[dev] )* )
            {
            match(input,28,FOLLOW_28_in_deviceDecl223); 

            match(input, Token.DOWN, null); 
            devName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl227); 
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
            			
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:398:3: ( attributeDecl[devices] | pinDecl[dev] )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==29) ) {
                    alt4=1;
                }
                else if ( (LA4_0==30) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:398:4: attributeDecl[devices]
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_deviceDecl254);
            	    attributeDecl(devices);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:398:29: pinDecl[dev]
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl259);
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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:416:1: attributeDecl[List<Attributable> parents] : ^( 'attr' attrName= IDENT attrValue= STRING ) ;
    public final void attributeDecl(List<Attributable> parents) throws RecognitionException {
        CommonTree attrName=null;
        CommonTree attrValue=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:428:2: ( ^( 'attr' attrName= IDENT attrValue= STRING ) )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:428:4: ^( 'attr' attrName= IDENT attrValue= STRING )
            {
            match(input,29,FOLLOW_29_in_attributeDecl294); 

            match(input, Token.DOWN, null); 
            attrName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attributeDecl298); 
            attrValue=(CommonTree)match(input,STRING,FOLLOW_STRING_in_attributeDecl302); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:454:1: pinDecl[DeviceNode dev] : ^( 'pin' ( sliceList[sList] )? pinName= IDENT pinList[pList] ) ;
    public final void pinDecl(DeviceNode dev) throws RecognitionException {
        CommonTree pinName=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:472:2: ( ^( 'pin' ( sliceList[sList] )? pinName= IDENT pinList[pList] ) )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:472:4: ^( 'pin' ( sliceList[sList] )? pinName= IDENT pinList[pList] )
            {
            match(input,30,FOLLOW_30_in_pinDecl339); 

             	// sets to keep track of the slice and pin lists
            				List<Integer> sList = new ArrayList<Integer>(); 
            				List<String> pList = new ArrayList<String>();
            			

            match(input, Token.DOWN, null); 
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:481:3: ( sliceList[sList] )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==COMMA||(LA5_0>=LEFTBRACKET && LA5_0<=COLON)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:481:3: sliceList[sList]
                    {
                    pushFollow(FOLLOW_sliceList_in_pinDecl361);
                    sliceList(sList);

                    state._fsp--;


                    }
                    break;

            }

            pinName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinDecl367); 
            pushFollow(FOLLOW_pinList_in_pinDecl369);
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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:537:1: netDecl[DesignNode des] : ^( 'net' ( sliceList[slices] )? firstName= IDENT ( COMMA nextName= IDENT )* ( attributeDecl[netNodes] )* ) ;
    public final void netDecl(DesignNode des) throws RecognitionException {
        CommonTree firstName=null;
        CommonTree nextName=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:546:2: ( ^( 'net' ( sliceList[slices] )? firstName= IDENT ( COMMA nextName= IDENT )* ( attributeDecl[netNodes] )* ) )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:546:4: ^( 'net' ( sliceList[slices] )? firstName= IDENT ( COMMA nextName= IDENT )* ( attributeDecl[netNodes] )* )
            {
            match(input,31,FOLLOW_31_in_netDecl403); 

            	List<Integer> slices = new ArrayList<Integer>();
            				List<Attributable> netNodes = new ArrayList<Attributable>();
            				attrDecls.clear();
            			

            match(input, Token.DOWN, null); 
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:555:3: ( sliceList[slices] )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==COMMA||(LA6_0>=LEFTBRACKET && LA6_0<=COLON)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:555:3: sliceList[slices]
                    {
                    pushFollow(FOLLOW_sliceList_in_netDecl426);
                    sliceList(slices);

                    state._fsp--;


                    }
                    break;

            }

            firstName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netDecl438); 
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
            			
            			
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:579:3: ( COMMA nextName= IDENT )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==COMMA) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:579:4: COMMA nextName= IDENT
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_netDecl468); 
            	    nextName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netDecl472); 
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
            	    break loop7;
                }
            } while (true);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:602:3: ( attributeDecl[netNodes] )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==29) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:602:3: attributeDecl[netNodes]
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_netDecl502);
            	    attributeDecl(netNodes);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:619:1: instDecl[DesignNode des, String groupName] : ^( 'inst' ( arrayList[indices] )? instName= IDENT devName= IDENT ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] | infoStruct )* ) ;
    public final void instDecl(DesignNode des, String groupName) throws RecognitionException {
        CommonTree instName=null;
        CommonTree devName=null;
        String infoStruct2 = null;


        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:630:2: ( ^( 'inst' ( arrayList[indices] )? instName= IDENT devName= IDENT ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] | infoStruct )* ) )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:630:4: ^( 'inst' ( arrayList[indices] )? instName= IDENT devName= IDENT ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] | infoStruct )* )
            {
            match(input,32,FOLLOW_32_in_instDecl537); 

            	// Set of instance nodes to check for duplicates
            				List<InstanceNode> instNodes = new ArrayList<InstanceNode>();
            				// List of indices to be derived from the arrayList
            				List<Integer> indices = new ArrayList<Integer>();
            			

            match(input, Token.DOWN, null); 
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:640:3: ( arrayList[indices] )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==COMMA||LA9_0==COLON||LA9_0==LEFTPAREN) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:640:3: arrayList[indices]
                    {
                    pushFollow(FOLLOW_arrayList_in_instDecl559);
                    arrayList(indices);

                    state._fsp--;


                    }
                    break;

            }

            instName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl565); 
            devName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl569); 
            	// make as many instance nodes as there are indices
            				for (int j = 0; j < indices.size(); j++) {
            				
            					InstanceNode i = new InstanceNode(des);
            					i.setName((instName!=null?instName.getText():null) + "(" + indices.get(j) + ")");
            					i.setLocation((instName!=null?instName.getLine():0), (instName!=null?instName.getCharPositionInLine():0), 
            						instName.getToken().getInputStream().getSourceName());
            					i.setGroupName(groupName);
            					
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
            					i.setGroupName(groupName);
            					
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
            			
            String info = "";
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:703:3: ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] | infoStruct )*
            loop10:
            do {
                int alt10=4;
                alt10 = dfa10.predict(input);
                switch (alt10) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:703:4: attrAssign[des, $instName.text]
            	    {
            	    pushFollow(FOLLOW_attrAssign_in_instDecl594);
            	    attrAssign(des, (instName!=null?instName.getText():null));

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:703:38: pinAssign[des, $instName.text]
            	    {
            	    pushFollow(FOLLOW_pinAssign_in_instDecl599);
            	    pinAssign(des, (instName!=null?instName.getText():null));

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:703:71: infoStruct
            	    {
            	    pushFollow(FOLLOW_infoStruct_in_instDecl604);
            	    infoStruct2=infoStruct();

            	    state._fsp--;

            	    info += infoStruct2 + "\n";

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            match(input, Token.UP, null); 
            					
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
            					i.appendInfo(info);
            					for (AttributeNode a : i.getAttributes()) {
            						if (a.getName().equals("REFPREFIX"))
            							i.setRefPrefix(a.getValue());
            						if (a.getName().equals("PKG_TYPE"))
            							i.setFootprint(a.getValue());
            						if (a.getName().equals("REFDES"))
            							i.setRefDes(a.getValue());
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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:734:1: attrAssign[DesignNode des, String instName] : ^( EQUALS ( 'newattr' )? ( attributeQualifier[instName, indices, des] | arrayIndices[instName, indices, des] ) attrName= IDENT attrValue= STRING ) ;
    public final void attrAssign(DesignNode des, String instName) throws RecognitionException {
        CommonTree attrName=null;
        CommonTree attrValue=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:751:2: ( ^( EQUALS ( 'newattr' )? ( attributeQualifier[instName, indices, des] | arrayIndices[instName, indices, des] ) attrName= IDENT attrValue= STRING ) )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:751:4: ^( EQUALS ( 'newattr' )? ( attributeQualifier[instName, indices, des] | arrayIndices[instName, indices, des] ) attrName= IDENT attrValue= STRING )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_attrAssign641); 

            	// flag for a new attribute and a list of indices the attribute assignment applies to
            				boolean newAttr = false;
            				List<Integer> indices = new ArrayList<Integer>();
            			

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:760:3: ( 'newattr' )?
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==36) ) {
                    alt11=1;
                }
                switch (alt11) {
                    case 1 :
                        // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:760:4: 'newattr'
                        {
                        match(input,36,FOLLOW_36_in_attrAssign665); 
                        newAttr = true;

                        }
                        break;

                }

                // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:761:3: ( attributeQualifier[instName, indices, des] | arrayIndices[instName, indices, des] )
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
                        // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:761:4: attributeQualifier[instName, indices, des]
                        {
                        pushFollow(FOLLOW_attributeQualifier_in_attrAssign675);
                        attributeQualifier(instName, indices, des);

                        state._fsp--;


                        }
                        break;
                    case 2 :
                        // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:761:49: arrayIndices[instName, indices, des]
                        {
                        pushFollow(FOLLOW_arrayIndices_in_attrAssign680);
                        arrayIndices(instName, indices, des);

                        state._fsp--;


                        }
                        break;

                }

                attrName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attrAssign688); 
                attrValue=(CommonTree)match(input,STRING,FOLLOW_STRING_in_attrAssign692); 

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
            							if (newAttr) {
            								// make a new attribute if explicitly asked to do so
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
            					} else {
            						// the instance node does not exist
            						addError(attrName, instName + "(" + indices.get(i) + ")" + 
            							" attribute undeclared");
            					}
            				}
            				// if the instance is not arrayed
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
            							// the attribute doesn't exist
            							if (newAttr) {
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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:843:1: pinAssign[DesignNode des, String instName] : ^( EQUALS ( pinQualifier[instName, indices, des] | arrayIndices[instName, indices, des] ) pinName= IDENT ( sliceList[slices] | pinSlices[slices, $pinName.text, des, instName] ) concatenation[concats, assignWidth, des] ) ;
    public final void pinAssign(DesignNode des, String instName) throws RecognitionException {
        CommonTree pinName=null;
        boolean pinQualifier3 = false;


        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:844:2: ( ^( EQUALS ( pinQualifier[instName, indices, des] | arrayIndices[instName, indices, des] ) pinName= IDENT ( sliceList[slices] | pinSlices[slices, $pinName.text, des, instName] ) concatenation[concats, assignWidth, des] ) )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:844:4: ^( EQUALS ( pinQualifier[instName, indices, des] | arrayIndices[instName, indices, des] ) pinName= IDENT ( sliceList[slices] | pinSlices[slices, $pinName.text, des, instName] ) concatenation[concats, assignWidth, des] )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_pinAssign723); 

            	List<Integer> indices = new ArrayList<Integer>();
            				List<Integer> slices = new ArrayList<Integer>();
            				List<NetNode> concats = new ArrayList<NetNode>();
            			
            boolean combine = false;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:854:5: ( pinQualifier[instName, indices, des] | arrayIndices[instName, indices, des] )
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==PERIOD) ) {
                    alt13=1;
                }
                else if ( ((LA13_0>=UP && LA13_0<=IDENT)) ) {
                    alt13=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 0, input);

                    throw nvae;
                }
                switch (alt13) {
                    case 1 :
                        // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:854:6: pinQualifier[instName, indices, des]
                        {
                        pushFollow(FOLLOW_pinQualifier_in_pinAssign758);
                        pinQualifier3=pinQualifier(instName, indices, des);

                        state._fsp--;

                        combine = pinQualifier3;

                        }
                        break;
                    case 2 :
                        // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:854:80: arrayIndices[instName, indices, des]
                        {
                        pushFollow(FOLLOW_arrayIndices_in_pinAssign765);
                        arrayIndices(instName, indices, des);

                        state._fsp--;


                        }
                        break;

                }

                pinName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinAssign776); 
                // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:855:19: ( sliceList[slices] | pinSlices[slices, $pinName.text, des, instName] )
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==COMMA||(LA14_0>=LEFTBRACKET && LA14_0<=COLON)) ) {
                    alt14=1;
                }
                else if ( (LA14_0==IDENT||LA14_0==LEFTANGLE||LA14_0==39) ) {
                    alt14=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 0, input);

                    throw nvae;
                }
                switch (alt14) {
                    case 1 :
                        // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:855:20: sliceList[slices]
                        {
                        pushFollow(FOLLOW_sliceList_in_pinAssign779);
                        sliceList(slices);

                        state._fsp--;


                        }
                        break;
                    case 2 :
                        // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:855:40: pinSlices[slices, $pinName.text, des, instName]
                        {
                        pushFollow(FOLLOW_pinSlices_in_pinAssign784);
                        pinSlices(slices, (pinName!=null?pinName.getText():null), des, instName);

                        state._fsp--;


                        }
                        break;

                }

                	int assignWidth = 0;
                				if (slices.size() == 0 && indices.size() != 0) {assignWidth = indices.size();}
                				if (slices.size() != 0 && indices.size() == 0) {assignWidth = slices.size();}
                				if (slices.size() != 0 && indices.size() != 0 && combine) {assignWidth = indices.size() * slices.size();}
                				if (slices.size() != 0 && indices.size() != 0 && !combine) {assignWidth = slices.size();}
                			
                pushFollow(FOLLOW_concatenation_in_pinAssign802);
                concatenation(concats, assignWidth, des);

                state._fsp--;


                match(input, Token.UP, null); 
            }
            	  
            				if (indices.size() != 0 && slices.size() != 0) {
            					if (indices.size() * slices.size() != concats.size() && combine) {
            						// Arrayed and Sliced
            						bailOut(pinName, "Invalid assignment width, left = " + indices.size() * slices.size() + ", right = " + concats.size());
            					}
            					else if (slices.size() != concats.size() && !combine) {
            						bailOut(pinName, "Invalid assignment width, left = " + slices.size() + ", right = " + concats.size());
            					}
            				}
            				else if (slices.size() != 0) {
            					if (slices.size() != concats.size()) {
            						// Not Arrayed and Sliced
            						bailOut(pinName, "Invalid assignment width, left = " + slices.size() + ", right = " + concats.size());
            					}
            				}
            				else if (indices.size() != 0) {
            					// Arrayed and Not Sliced
            					if (concats.size() != 1 && !combine) {
            						bailOut(pinName, "Invalid assignment width, left = " + 1 + ", right = " + concats.size());
            					}
            					else if (combine && concats.size() != indices.size()) {
            						bailOut(pinName, "Invalid assignment width, left = " + indices.size() + ", right = " + concats.size());
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
            							assignPins(start, slices, concats, inst, pinName, combine);
            						}
            					}
            				}
            				if (indices.isEmpty()) {
            					InstanceNode inst = des.getInstance(instName);
            					assignPins(-1,slices, concats, inst, pinName, combine);
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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:918:1: netAssign[DesignNode des] : ^( EQUALS netName= IDENT ( sliceList[slices] | netSlices[slices, $netName.text, des] ) concatenation[concats, slices.size(), des] ) ;
    public final void netAssign(DesignNode des) throws RecognitionException {
        CommonTree netName=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:919:2: ( ^( EQUALS netName= IDENT ( sliceList[slices] | netSlices[slices, $netName.text, des] ) concatenation[concats, slices.size(), des] ) )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:919:4: ^( EQUALS netName= IDENT ( sliceList[slices] | netSlices[slices, $netName.text, des] ) concatenation[concats, slices.size(), des] )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_netAssign834); 

            	List<Integer> slices = new ArrayList<Integer>();
            				List<NetNode> concats = new ArrayList<NetNode>();
            			

            match(input, Token.DOWN, null); 
            netName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netAssign858); 
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:927:17: ( sliceList[slices] | netSlices[slices, $netName.text, des] )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==COMMA||(LA15_0>=LEFTBRACKET && LA15_0<=COLON)) ) {
                alt15=1;
            }
            else if ( (LA15_0==IDENT||LA15_0==LEFTANGLE||LA15_0==39) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:927:18: sliceList[slices]
                    {
                    pushFollow(FOLLOW_sliceList_in_netAssign861);
                    sliceList(slices);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:927:38: netSlices[slices, $netName.text, des]
                    {
                    pushFollow(FOLLOW_netSlices_in_netAssign866);
                    netSlices(slices, (netName!=null?netName.getText():null), des);

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_concatenation_in_netAssign872);
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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:968:1: concatenation[List<NetNode> concats, int assignWidth, DesignNode des] : ( (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* ) | ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) ) | ( 'open' ) ) ;
    public final void concatenation(List<NetNode> concats, int assignWidth, DesignNode des) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;
        CommonTree global=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:972:2: ( ( (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* ) | ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) ) | ( 'open' ) ) )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:973:4: ( (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* ) | ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) ) | ( 'open' ) )
            {
            List<Integer> slices = new ArrayList<Integer>();
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:975:3: ( (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* ) | ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) ) | ( 'open' ) )
            int alt20=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt20=1;
                }
                break;
            case LEFTANGLE:
                {
                alt20=2;
                }
                break;
            case 39:
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
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:975:4: (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* )
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:975:4: (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* )
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:975:5: first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )*
                    {
                    first=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenation924); 
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:975:17: ( sliceList[slices] | concatSlices[slices, $first.text, des] )
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
                            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:975:18: sliceList[slices]
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation927);
                            sliceList(slices);

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:975:38: concatSlices[slices, $first.text, des]
                            {
                            pushFollow(FOLLOW_concatSlices_in_concatenation932);
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
                    			
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1001:3: (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==IDENT) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1001:4: next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] )
                    	    {
                    	    next=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenation963); 
                    	    slices.clear();
                    	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1005:3: ( sliceList[slices] | concatSlices[slices, $next.text, des] )
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
                    	            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1005:4: sliceList[slices]
                    	            {
                    	            pushFollow(FOLLOW_sliceList_in_concatenation987);
                    	            sliceList(slices);

                    	            state._fsp--;


                    	            }
                    	            break;
                    	        case 2 :
                    	            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1005:24: concatSlices[slices, $next.text, des]
                    	            {
                    	            pushFollow(FOLLOW_concatSlices_in_concatenation992);
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
                    	    break loop18;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1031:10: ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) )
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1031:10: ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) )
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1031:11: LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] )
                    {
                    match(input,LEFTANGLE,FOLLOW_LEFTANGLE_in_concatenation1026); 
                    global=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenation1030); 
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1031:34: ( sliceList[slices] | concatSlices[slices, $global.text, des] )
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
                            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1031:35: sliceList[slices]
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation1033);
                            sliceList(slices);

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1031:55: concatSlices[slices, $global.text, des]
                            {
                            pushFollow(FOLLOW_concatSlices_in_concatenation1038);
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
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1057:5: ( 'open' )
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1057:5: ( 'open' )
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1057:6: 'open'
                    {
                    match(input,39,FOLLOW_39_in_concatenation1070); 

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


    // $ANTLR start "attributeQualifier"
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1079:1: attributeQualifier[String instName, List<Integer> indices, DesignNode des] : ^( PERIOD 'each' ( arrayList[indices] | arrayIndices[instName, indices, des] ) ) ;
    public final void attributeQualifier(String instName, List<Integer> indices, DesignNode des) throws RecognitionException {
        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1089:2: ( ^( PERIOD 'each' ( arrayList[indices] | arrayIndices[instName, indices, des] ) ) )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1089:4: ^( PERIOD 'each' ( arrayList[indices] | arrayIndices[instName, indices, des] ) )
            {
            match(input,PERIOD,FOLLOW_PERIOD_in_attributeQualifier1108); 

            match(input, Token.DOWN, null); 
            match(input,37,FOLLOW_37_in_attributeQualifier1110); 
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1089:20: ( arrayList[indices] | arrayIndices[instName, indices, des] )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==COMMA||LA21_0==COLON||LA21_0==LEFTPAREN) ) {
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
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1089:21: arrayList[indices]
                    {
                    pushFollow(FOLLOW_arrayList_in_attributeQualifier1113);
                    arrayList(indices);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1089:42: arrayIndices[instName, indices, des]
                    {
                    pushFollow(FOLLOW_arrayIndices_in_attributeQualifier1118);
                    arrayIndices(instName, indices, des);

                    state._fsp--;


                    }
                    break;

            }


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
    // $ANTLR end "attributeQualifier"


    // $ANTLR start "pinQualifier"
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1092:1: pinQualifier[String instName, List<Integer> indices, DesignNode des] returns [boolean combine] : ^( PERIOD ( 'each' | 'combine' ) ( arrayList[indices] | arrayIndices[instName, indices, des] ) ) ;
    public final boolean pinQualifier(String instName, List<Integer> indices, DesignNode des) throws RecognitionException {
        boolean combine = false;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1100:2: ( ^( PERIOD ( 'each' | 'combine' ) ( arrayList[indices] | arrayIndices[instName, indices, des] ) ) )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1100:4: ^( PERIOD ( 'each' | 'combine' ) ( arrayList[indices] | arrayIndices[instName, indices, des] ) )
            {
            combine = false;
            match(input,PERIOD,FOLLOW_PERIOD_in_pinQualifier1148); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1101:12: ( 'each' | 'combine' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==37) ) {
                alt22=1;
            }
            else if ( (LA22_0==38) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1101:13: 'each'
                    {
                    match(input,37,FOLLOW_37_in_pinQualifier1151); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1101:22: 'combine'
                    {
                    match(input,38,FOLLOW_38_in_pinQualifier1155); 
                    combine = true;

                    }
                    break;

            }

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1102:3: ( arrayList[indices] | arrayIndices[instName, indices, des] )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==COMMA||LA23_0==COLON||LA23_0==LEFTPAREN) ) {
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
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1102:4: arrayList[indices]
                    {
                    pushFollow(FOLLOW_arrayList_in_pinQualifier1164);
                    arrayList(indices);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1102:25: arrayIndices[instName, indices, des]
                    {
                    pushFollow(FOLLOW_arrayIndices_in_pinQualifier1169);
                    arrayIndices(instName, indices, des);

                    state._fsp--;


                    }
                    break;

            }


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return combine;
    }
    // $ANTLR end "pinQualifier"


    // $ANTLR start "arrayIndices"
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1105:1: arrayIndices[String instName, List<Integer> indices, DesignNode des] : ;
    public final void arrayIndices(String instName, List<Integer> indices, DesignNode des) throws RecognitionException {
        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1110:2: ()
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1110:4: 
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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1113:1: pinSlices[List<Integer> slices, String pinName, DesignNode des, String instName] : ;
    public final void pinSlices(List<Integer> slices, String pinName, DesignNode des, String instName) throws RecognitionException {
        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1117:2: ()
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1117:4: 
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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1123:1: netSlices[List<Integer> slices, String netName, DesignNode des] : ;
    public final void netSlices(List<Integer> slices, String netName, DesignNode des) throws RecognitionException {
        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1124:2: ()
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1124:4: 
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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1129:1: concatSlices[List<Integer> slices, String netName, DesignNode des] : ;
    public final void concatSlices(List<Integer> slices, String netName, DesignNode des) throws RecognitionException {
        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1130:2: ()
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1130:4: 
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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1133:1: arrayList[List<Integer> indices] : ( ^( COMMA LEFTPAREN first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTPAREN first= INTEGER last= INTEGER ) | ( LEFTPAREN single= INTEGER ) );
    public final void arrayList(List<Integer> indices) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;
        CommonTree last=null;
        CommonTree single=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1144:2: ( ^( COMMA LEFTPAREN first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTPAREN first= INTEGER last= INTEGER ) | ( LEFTPAREN single= INTEGER ) )
            int alt25=3;
            switch ( input.LA(1) ) {
            case COMMA:
                {
                alt25=1;
                }
                break;
            case COLON:
                {
                alt25=2;
                }
                break;
            case LEFTPAREN:
                {
                alt25=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1145:3: ^( COMMA LEFTPAREN first= INTEGER (next= INTEGER )* )
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_arrayList1245); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList1247); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1251); 
                    indices.add(Integer.parseInt((first!=null?first.getText():null)));
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1146:8: (next= INTEGER )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==INTEGER) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1146:9: next= INTEGER
                    	    {
                    	    next=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1266); 
                    	    indices.add(Integer.parseInt((next!=null?next.getText():null)));

                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1149:5: ^( COLON LEFTPAREN first= INTEGER last= INTEGER )
                    {
                    match(input,COLON,FOLLOW_COLON_in_arrayList1301); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList1303); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1307); 
                    last=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1311); 
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
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1167:4: ( LEFTPAREN single= INTEGER )
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1167:4: ( LEFTPAREN single= INTEGER )
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1167:5: LEFTPAREN single= INTEGER
                    {
                    match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList1344); 
                    single=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1348); 
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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1170:1: sliceList[List<Integer> slices] : ( ^( COMMA LEFTBRACKET first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTBRACKET first= INTEGER last= INTEGER ) | ( LEFTBRACKET single= INTEGER ) );
    public final void sliceList(List<Integer> slices) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;
        CommonTree last=null;
        CommonTree single=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1181:2: ( ^( COMMA LEFTBRACKET first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTBRACKET first= INTEGER last= INTEGER ) | ( LEFTBRACKET single= INTEGER ) )
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
            case LEFTBRACKET:
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
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1182:3: ^( COMMA LEFTBRACKET first= INTEGER (next= INTEGER )* )
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_sliceList1375); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList1377); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1381); 
                    slices.add(Integer.parseInt((first!=null?first.getText():null)));
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1183:8: (next= INTEGER )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==INTEGER) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1183:9: next= INTEGER
                    	    {
                    	    next=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1397); 
                    	    slices.add(Integer.parseInt((next!=null?next.getText():null)));

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
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1186:4: ^( COLON LEFTBRACKET first= INTEGER last= INTEGER )
                    {
                    match(input,COLON,FOLLOW_COLON_in_sliceList1432); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList1434); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1438); 
                    last=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1442); 
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
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1206:4: ( LEFTBRACKET single= INTEGER )
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1206:4: ( LEFTBRACKET single= INTEGER )
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1206:5: LEFTBRACKET single= INTEGER
                    {
                    match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList1474); 
                    single=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1478); 
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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1210:1: pinList[List<String> pList] : first= ( INTEGER | IDENT ) (next= ( INTEGER | IDENT ) )* ;
    public final void pinList(List<String> pList) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1221:2: (first= ( INTEGER | IDENT ) (next= ( INTEGER | IDENT ) )* )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1221:4: first= ( INTEGER | IDENT ) (next= ( INTEGER | IDENT ) )*
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
            			
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1232:7: (next= ( INTEGER | IDENT ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==IDENT||LA28_0==INTEGER) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1232:8: next= ( INTEGER | IDENT )
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
            	    break loop28;
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


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\32\uffff";
    static final String DFA10_eofS =
        "\32\uffff";
    static final String DFA10_minS =
        "\1\3\1\uffff\1\2\1\uffff\1\4\1\uffff\1\2\1\4\1\45\1\uffff\1\3\2"+
        "\2\1\17\1\4\2\23\1\3\2\17\1\3\1\17\4\3";
    static final String DFA10_maxS =
        "\1\42\1\uffff\1\2\1\uffff\1\44\1\uffff\1\2\1\47\1\46\1\uffff\1"+
        "\23\2\2\1\17\1\4\2\23\1\3\5\17\3\3";
    static final String DFA10_acceptS =
        "\1\uffff\1\4\1\uffff\1\3\1\uffff\1\1\3\uffff\1\2\20\uffff";
    static final String DFA10_specialS =
        "\32\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\1\3\uffff\1\2\32\uffff\1\3",
            "",
            "\1\4",
            "",
            "\1\7\6\uffff\1\6\30\uffff\1\5",
            "",
            "\1\10",
            "\1\11\3\uffff\1\5\1\uffff\1\11\2\uffff\1\11\2\uffff\2\11\25"+
            "\uffff\1\11",
            "\1\12\1\11",
            "",
            "\1\16\6\uffff\1\13\6\uffff\1\14\1\uffff\1\15",
            "\1\17",
            "\1\20",
            "\1\21",
            "\1\7",
            "\1\22",
            "\1\23",
            "\1\16",
            "\1\24",
            "\1\25",
            "\1\27\13\uffff\1\26",
            "\1\30",
            "\1\27\13\uffff\1\26",
            "\1\16",
            "\1\31",
            "\1\16"
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "()* loopback of 703:3: ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] | infoStruct )*";
        }
    }
 

    public static final BitSet FOLLOW_designDecl_in_sourceText61 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_designDecl76 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_designDecl80 = new BitSet(new long[]{0x0000000D90000088L});
    public static final BitSet FOLLOW_deviceDecl_in_designDecl105 = new BitSet(new long[]{0x0000000D90000088L});
    public static final BitSet FOLLOW_netDecl_in_designDecl110 = new BitSet(new long[]{0x0000000D90000088L});
    public static final BitSet FOLLOW_infoStruct_in_designDecl115 = new BitSet(new long[]{0x0000000D90000088L});
    public static final BitSet FOLLOW_instDecl_in_designDecl121 = new BitSet(new long[]{0x0000000D90000088L});
    public static final BitSet FOLLOW_netAssign_in_designDecl126 = new BitSet(new long[]{0x0000000D90000088L});
    public static final BitSet FOLLOW_groupStruct_in_designDecl131 = new BitSet(new long[]{0x0000000D90000088L});
    public static final BitSet FOLLOW_34_in_infoStruct168 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_infoStruct172 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_35_in_groupStruct190 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_groupStruct194 = new BitSet(new long[]{0x0000000100000088L});
    public static final BitSet FOLLOW_instDecl_in_groupStruct197 = new BitSet(new long[]{0x0000000100000088L});
    public static final BitSet FOLLOW_netAssign_in_groupStruct202 = new BitSet(new long[]{0x0000000100000088L});
    public static final BitSet FOLLOW_28_in_deviceDecl223 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl227 = new BitSet(new long[]{0x0000000060000008L});
    public static final BitSet FOLLOW_attributeDecl_in_deviceDecl254 = new BitSet(new long[]{0x0000000060000008L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl259 = new BitSet(new long[]{0x0000000060000008L});
    public static final BitSet FOLLOW_29_in_attributeDecl294 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_attributeDecl298 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_STRING_in_attributeDecl302 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_30_in_pinDecl339 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_sliceList_in_pinDecl361 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl367 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_pinList_in_pinDecl369 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_31_in_netDecl403 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_sliceList_in_netDecl426 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl438 = new BitSet(new long[]{0x0000000020000408L});
    public static final BitSet FOLLOW_COMMA_in_netDecl468 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl472 = new BitSet(new long[]{0x0000000020000408L});
    public static final BitSet FOLLOW_attributeDecl_in_netDecl502 = new BitSet(new long[]{0x0000000020000008L});
    public static final BitSet FOLLOW_32_in_instDecl537 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arrayList_in_instDecl559 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instDecl565 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instDecl569 = new BitSet(new long[]{0x0000000400000088L});
    public static final BitSet FOLLOW_attrAssign_in_instDecl594 = new BitSet(new long[]{0x0000000400000088L});
    public static final BitSet FOLLOW_pinAssign_in_instDecl599 = new BitSet(new long[]{0x0000000400000088L});
    public static final BitSet FOLLOW_infoStruct_in_instDecl604 = new BitSet(new long[]{0x0000000400000088L});
    public static final BitSet FOLLOW_EQUALS_in_attrAssign641 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_36_in_attrAssign665 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_attributeQualifier_in_attrAssign675 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_arrayIndices_in_attrAssign680 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attrAssign688 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_STRING_in_attrAssign692 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssign723 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_pinQualifier_in_pinAssign758 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_arrayIndices_in_pinAssign765 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinAssign776 = new BitSet(new long[]{0x0000008000032410L});
    public static final BitSet FOLLOW_sliceList_in_pinAssign779 = new BitSet(new long[]{0x0000008000032410L});
    public static final BitSet FOLLOW_pinSlices_in_pinAssign784 = new BitSet(new long[]{0x0000008000032410L});
    public static final BitSet FOLLOW_concatenation_in_pinAssign802 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUALS_in_netAssign834 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_netAssign858 = new BitSet(new long[]{0x0000008000032410L});
    public static final BitSet FOLLOW_sliceList_in_netAssign861 = new BitSet(new long[]{0x0000008000032410L});
    public static final BitSet FOLLOW_netSlices_in_netAssign866 = new BitSet(new long[]{0x0000008000032410L});
    public static final BitSet FOLLOW_concatenation_in_netAssign872 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENT_in_concatenation924 = new BitSet(new long[]{0x0000000000030410L});
    public static final BitSet FOLLOW_sliceList_in_concatenation927 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_concatSlices_in_concatenation932 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_IDENT_in_concatenation963 = new BitSet(new long[]{0x0000000000030410L});
    public static final BitSet FOLLOW_sliceList_in_concatenation987 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_concatSlices_in_concatenation992 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_LEFTANGLE_in_concatenation1026 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation1030 = new BitSet(new long[]{0x0000000000030400L});
    public static final BitSet FOLLOW_sliceList_in_concatenation1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_concatSlices_in_concatenation1038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_concatenation1070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_attributeQualifier1108 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_37_in_attributeQualifier1110 = new BitSet(new long[]{0x00000000000A0408L});
    public static final BitSet FOLLOW_arrayList_in_attributeQualifier1113 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_arrayIndices_in_attributeQualifier1118 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERIOD_in_pinQualifier1148 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_37_in_pinQualifier1151 = new BitSet(new long[]{0x00000000000A0408L});
    public static final BitSet FOLLOW_38_in_pinQualifier1155 = new BitSet(new long[]{0x00000000000A0408L});
    public static final BitSet FOLLOW_arrayList_in_pinQualifier1164 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_arrayIndices_in_pinQualifier1169 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMMA_in_arrayList1245 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList1247 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1251 = new BitSet(new long[]{0x0000000000008008L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1266 = new BitSet(new long[]{0x0000000000008008L});
    public static final BitSet FOLLOW_COLON_in_arrayList1301 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList1303 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1307 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1311 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList1344 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_sliceList1375 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList1377 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1381 = new BitSet(new long[]{0x0000000000008008L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1397 = new BitSet(new long[]{0x0000000000008008L});
    public static final BitSet FOLLOW_COLON_in_sliceList1432 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList1434 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1438 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1442 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList1474 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_pinList1504 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_set_in_pinList1539 = new BitSet(new long[]{0x0000000000008012L});

}