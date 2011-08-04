// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g 2011-08-03 18:58:59

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "SEMICOLON", "EQUALS", "STRING", "COMMA", "PERIOD", "AMPERSAND", "LEFTANGLE", "RIGHTANGLE", "LEFTBRACE", "INTEGER", "RIGHTBRACE", "LEFTBRACKET", "COLON", "RIGHTBRACKET", "LEFTPAREN", "RIGHTPAREN", "CHAR", "DIGIT", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "INCLUDE", "'design'", "'is'", "'begin'", "'end'", "'device'", "'attr'", "'pin'", "'net'", "'inst'", "'of'", "'info'", "'group'", "'newattr'", "'this'", "'open'"
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
    public static final int T__40=40;
    public static final int T__41=41;
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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:276:1: sourceText : ( designDecl )* ;
    public final void sourceText() throws RecognitionException {
        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:283:2: ( ( designDecl )* )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:283:4: ( designDecl )*
            {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:283:4: ( designDecl )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==27) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:283:4: designDecl
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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:286:1: designDecl : ^( 'design' desName= IDENT ( deviceDecl[des] | netDecl[des] | infoStruct[des, info] )* 'begin' ( instDecl[des, null] | netAssign[des] | groupStruct[des] )* (endName= IDENT )? ) ;
    public final void designDecl() throws RecognitionException {
        CommonTree desName=null;
        CommonTree endName=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:299:2: ( ^( 'design' desName= IDENT ( deviceDecl[des] | netDecl[des] | infoStruct[des, info] )* 'begin' ( instDecl[des, null] | netAssign[des] | groupStruct[des] )* (endName= IDENT )? ) )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:299:4: ^( 'design' desName= IDENT ( deviceDecl[des] | netDecl[des] | infoStruct[des, info] )* 'begin' ( instDecl[des, null] | netAssign[des] | groupStruct[des] )* (endName= IDENT )? )
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
            			
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:314:3: ( deviceDecl[des] | netDecl[des] | infoStruct[des, info] )*
            loop2:
            do {
                int alt2=4;
                switch ( input.LA(1) ) {
                case 31:
                    {
                    alt2=1;
                    }
                    break;
                case 34:
                    {
                    alt2=2;
                    }
                    break;
                case 37:
                    {
                    alt2=3;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:314:4: deviceDecl[des]
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_designDecl104);
            	    deviceDecl(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:314:22: netDecl[des]
            	    {
            	    pushFollow(FOLLOW_netDecl_in_designDecl109);
            	    netDecl(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:314:37: infoStruct[des, info]
            	    {
            	    String info = "";
            	    pushFollow(FOLLOW_infoStruct_in_designDecl116);
            	    infoStruct(des, info);

            	    state._fsp--;

            	    des.appendInfo(info);

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match(input,29,FOLLOW_29_in_designDecl123); 
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:315:3: ( instDecl[des, null] | netAssign[des] | groupStruct[des] )*
            loop3:
            do {
                int alt3=4;
                switch ( input.LA(1) ) {
                case 35:
                    {
                    alt3=1;
                    }
                    break;
                case EQUALS:
                    {
                    alt3=2;
                    }
                    break;
                case 38:
                    {
                    alt3=3;
                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:315:4: instDecl[des, null]
            	    {
            	    pushFollow(FOLLOW_instDecl_in_designDecl129);
            	    instDecl(des, null);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:315:26: netAssign[des]
            	    {
            	    pushFollow(FOLLOW_netAssign_in_designDecl134);
            	    netAssign(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:315:43: groupStruct[des]
            	    {
            	    pushFollow(FOLLOW_groupStruct_in_designDecl139);
            	    groupStruct(des);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:315:62: (endName= IDENT )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==IDENT) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:315:63: endName= IDENT
                    {
                    endName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_designDecl147); 

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


    // $ANTLR start "infoStruct"
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:358:1: infoStruct[Node des, String value] : ^( 'info' string= STRING ) ;
    public final void infoStruct(Node des, String value) throws RecognitionException {
        CommonTree string=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:359:2: ( ^( 'info' string= STRING ) )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:359:5: ^( 'info' string= STRING )
            {
            match(input,37,FOLLOW_37_in_infoStruct181); 

            match(input, Token.DOWN, null); 
            string=(CommonTree)match(input,STRING,FOLLOW_STRING_in_infoStruct185); 
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
        return ;
    }
    // $ANTLR end "infoStruct"


    // $ANTLR start "groupStruct"
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:362:1: groupStruct[DesignNode des] : ^( 'group' groupName= STRING ( instDecl[des, $groupName.text] | netAssign[des] )* (endName= STRING )? ) ;
    public final void groupStruct(DesignNode des) throws RecognitionException {
        CommonTree groupName=null;
        CommonTree endName=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:363:2: ( ^( 'group' groupName= STRING ( instDecl[des, $groupName.text] | netAssign[des] )* (endName= STRING )? ) )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:363:4: ^( 'group' groupName= STRING ( instDecl[des, $groupName.text] | netAssign[des] )* (endName= STRING )? )
            {
            match(input,38,FOLLOW_38_in_groupStruct203); 

            match(input, Token.DOWN, null); 
            groupName=(CommonTree)match(input,STRING,FOLLOW_STRING_in_groupStruct207); 
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:363:31: ( instDecl[des, $groupName.text] | netAssign[des] )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==35) ) {
                    alt5=1;
                }
                else if ( (LA5_0==EQUALS) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:363:32: instDecl[des, $groupName.text]
            	    {
            	    pushFollow(FOLLOW_instDecl_in_groupStruct210);
            	    instDecl(des, (groupName!=null?groupName.getText():null));

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:363:65: netAssign[des]
            	    {
            	    pushFollow(FOLLOW_netAssign_in_groupStruct215);
            	    netAssign(des);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:363:82: (endName= STRING )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==STRING) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:363:83: endName= STRING
                    {
                    endName=(CommonTree)match(input,STRING,FOLLOW_STRING_in_groupStruct223); 

                    }
                    break;

            }


            match(input, Token.UP, null); 
            	if (endName != null) {
            				if (!(groupName!=null?groupName.getText():null).equals((endName!=null?endName.getText():null)))
            					addError(endName, "group name " + (groupName!=null?groupName.getText():null) + " does not match");
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
    // $ANTLR end "groupStruct"


    // $ANTLR start "deviceDecl"
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:374:1: deviceDecl[DesignNode des] : ^( 'device' devName= IDENT ( attributeDecl[devices] | pinDecl[dev] )* (endName= IDENT )? ) ;
    public final void deviceDecl(DesignNode des) throws RecognitionException {
        CommonTree devName=null;
        CommonTree endName=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:386:2: ( ^( 'device' devName= IDENT ( attributeDecl[devices] | pinDecl[dev] )* (endName= IDENT )? ) )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:386:4: ^( 'device' devName= IDENT ( attributeDecl[devices] | pinDecl[dev] )* (endName= IDENT )? )
            {
            match(input,31,FOLLOW_31_in_deviceDecl255); 

            match(input, Token.DOWN, null); 
            devName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl259); 
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
            			
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:404:3: ( attributeDecl[devices] | pinDecl[dev] )*
            loop7:
            do {
                int alt7=3;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==32) ) {
                    alt7=1;
                }
                else if ( (LA7_0==33) ) {
                    alt7=2;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:404:4: attributeDecl[devices]
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_deviceDecl286);
            	    attributeDecl(devices);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:404:29: pinDecl[dev]
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl291);
            	    pinDecl(dev);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:404:51: (endName= IDENT )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==IDENT) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:404:51: endName= IDENT
                    {
                    endName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl298); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:427:1: attributeDecl[List<Attributable> parents] : ^( 'attr' attrName= IDENT attrValue= STRING ) ;
    public final void attributeDecl(List<Attributable> parents) throws RecognitionException {
        CommonTree attrName=null;
        CommonTree attrValue=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:439:2: ( ^( 'attr' attrName= IDENT attrValue= STRING ) )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:439:4: ^( 'attr' attrName= IDENT attrValue= STRING )
            {
            match(input,32,FOLLOW_32_in_attributeDecl331); 

            match(input, Token.DOWN, null); 
            attrName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attributeDecl335); 
            attrValue=(CommonTree)match(input,STRING,FOLLOW_STRING_in_attributeDecl339); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:465:1: pinDecl[DeviceNode dev] : ^( 'pin' ( sliceList[sList] )? pinName= IDENT pinList[pList] ) ;
    public final void pinDecl(DeviceNode dev) throws RecognitionException {
        CommonTree pinName=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:483:2: ( ^( 'pin' ( sliceList[sList] )? pinName= IDENT pinList[pList] ) )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:483:4: ^( 'pin' ( sliceList[sList] )? pinName= IDENT pinList[pList] )
            {
            match(input,33,FOLLOW_33_in_pinDecl376); 

             	// sets to keep track of the slice and pin lists
            				List<Integer> sList = new ArrayList<Integer>(); 
            				List<String> pList = new ArrayList<String>();
            			

            match(input, Token.DOWN, null); 
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:492:3: ( sliceList[sList] )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==COMMA||(LA9_0>=LEFTBRACKET && LA9_0<=COLON)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:492:3: sliceList[sList]
                    {
                    pushFollow(FOLLOW_sliceList_in_pinDecl398);
                    sliceList(sList);

                    state._fsp--;


                    }
                    break;

            }

            pinName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinDecl404); 
            pushFollow(FOLLOW_pinList_in_pinDecl406);
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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:548:1: netDecl[DesignNode des] : ^( 'net' ( sliceList[slices] )? firstName= IDENT ( COMMA nextName= IDENT )* ( attributeDecl[netNodes] )* (endName= IDENT )? ) ;
    public final void netDecl(DesignNode des) throws RecognitionException {
        CommonTree firstName=null;
        CommonTree nextName=null;
        CommonTree endName=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:557:2: ( ^( 'net' ( sliceList[slices] )? firstName= IDENT ( COMMA nextName= IDENT )* ( attributeDecl[netNodes] )* (endName= IDENT )? ) )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:557:4: ^( 'net' ( sliceList[slices] )? firstName= IDENT ( COMMA nextName= IDENT )* ( attributeDecl[netNodes] )* (endName= IDENT )? )
            {
            match(input,34,FOLLOW_34_in_netDecl440); 

            	List<Integer> slices = new ArrayList<Integer>();
            				List<Attributable> netNodes = new ArrayList<Attributable>();
            				attrDecls.clear();
            			

            match(input, Token.DOWN, null); 
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:566:3: ( sliceList[slices] )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==COMMA||(LA10_0>=LEFTBRACKET && LA10_0<=COLON)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:566:3: sliceList[slices]
                    {
                    pushFollow(FOLLOW_sliceList_in_netDecl463);
                    sliceList(slices);

                    state._fsp--;


                    }
                    break;

            }

            firstName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netDecl475); 
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
            			
            			
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:590:3: ( COMMA nextName= IDENT )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==COMMA) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:590:4: COMMA nextName= IDENT
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_netDecl505); 
            	    nextName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netDecl509); 
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
            	    break loop11;
                }
            } while (true);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:613:3: ( attributeDecl[netNodes] )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==32) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:613:3: attributeDecl[netNodes]
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_netDecl539);
            	    attributeDecl(netNodes);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:613:35: (endName= IDENT )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==IDENT) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:613:35: endName= IDENT
                    {
                    endName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netDecl545); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:630:1: instDecl[DesignNode des, String groupName] : ^( 'inst' ( arrayList[indices] )? instName= IDENT devName= IDENT ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )* (endName= IDENT )? ) ;
    public final void instDecl(DesignNode des, String groupName) throws RecognitionException {
        CommonTree instName=null;
        CommonTree devName=null;
        CommonTree endName=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:641:2: ( ^( 'inst' ( arrayList[indices] )? instName= IDENT devName= IDENT ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )* (endName= IDENT )? ) )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:641:4: ^( 'inst' ( arrayList[indices] )? instName= IDENT devName= IDENT ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )* (endName= IDENT )? )
            {
            match(input,35,FOLLOW_35_in_instDecl579); 

            	// Set of instance nodes to check for duplicates
            				List<InstanceNode> instNodes = new ArrayList<InstanceNode>();
            				// List of indices to be derived from the arrayList
            				List<Integer> indices = new ArrayList<Integer>();
            			

            match(input, Token.DOWN, null); 
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:651:3: ( arrayList[indices] )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==COMMA||LA14_0==COLON||LA14_0==LEFTPAREN) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:651:3: arrayList[indices]
                    {
                    pushFollow(FOLLOW_arrayList_in_instDecl601);
                    arrayList(indices);

                    state._fsp--;


                    }
                    break;

            }

            instName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl607); 
            devName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl611); 
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
            			
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:714:3: ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )*
            loop15:
            do {
                int alt15=3;
                alt15 = dfa15.predict(input);
                switch (alt15) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:714:4: attrAssign[des, $instName.text]
            	    {
            	    pushFollow(FOLLOW_attrAssign_in_instDecl633);
            	    attrAssign(des, (instName!=null?instName.getText():null));

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:714:38: pinAssign[des, $instName.text]
            	    {
            	    pushFollow(FOLLOW_pinAssign_in_instDecl638);
            	    pinAssign(des, (instName!=null?instName.getText():null));

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:714:78: (endName= IDENT )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==IDENT) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:714:78: endName= IDENT
                    {
                    endName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl645); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:750:1: attrAssign[DesignNode des, String instName] : ^( EQUALS ( 'newattr' )? ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] ) attrName= IDENT attrValue= STRING ) ;
    public final void attrAssign(DesignNode des, String instName) throws RecognitionException {
        CommonTree attrName=null;
        CommonTree attrValue=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:767:2: ( ^( EQUALS ( 'newattr' )? ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] ) attrName= IDENT attrValue= STRING ) )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:767:4: ^( EQUALS ( 'newattr' )? ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] ) attrName= IDENT attrValue= STRING )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_attrAssign679); 

            	// flag for a new attribute and a list of indices the attribute assignment applies to
            				boolean newAttr = false;
            				List<Integer> indices = new ArrayList<Integer>();
            			

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:776:3: ( 'newattr' )?
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==39) ) {
                    alt17=1;
                }
                switch (alt17) {
                    case 1 :
                        // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:776:4: 'newattr'
                        {
                        match(input,39,FOLLOW_39_in_attrAssign703); 
                        newAttr = true;

                        }
                        break;

                }

                // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:777:3: ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] )
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==PERIOD) ) {
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
                        // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:777:4: instanceQualifier[instName, indices, des]
                        {
                        pushFollow(FOLLOW_instanceQualifier_in_attrAssign713);
                        instanceQualifier(instName, indices, des);

                        state._fsp--;


                        }
                        break;
                    case 2 :
                        // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:777:48: arrayIndices[indices, instName, des]
                        {
                        pushFollow(FOLLOW_arrayIndices_in_attrAssign718);
                        arrayIndices(indices, instName, des);

                        state._fsp--;


                        }
                        break;

                }

                attrName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attrAssign726); 
                attrValue=(CommonTree)match(input,STRING,FOLLOW_STRING_in_attrAssign730); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:885:1: pinAssign[DesignNode des, String instName] : ^( EQUALS ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] ) pinName= IDENT ( sliceList[slices] | pinSlices[slices, $pinName.text, des, instName] ) concatenation[concats, assignWidth, des] ) ;
    public final void pinAssign(DesignNode des, String instName) throws RecognitionException {
        CommonTree pinName=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:886:2: ( ^( EQUALS ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] ) pinName= IDENT ( sliceList[slices] | pinSlices[slices, $pinName.text, des, instName] ) concatenation[concats, assignWidth, des] ) )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:886:4: ^( EQUALS ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] ) pinName= IDENT ( sliceList[slices] | pinSlices[slices, $pinName.text, des, instName] ) concatenation[concats, assignWidth, des] )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_pinAssign761); 

            	List<Integer> indices = new ArrayList<Integer>();
            				List<Integer> slices = new ArrayList<Integer>();
            				List<NetNode> concats = new ArrayList<NetNode>();
            			

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:894:3: ( instanceQualifier[instName, indices, des] | arrayIndices[indices, instName, des] )
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==PERIOD) ) {
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
                        // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:894:4: instanceQualifier[instName, indices, des]
                        {
                        pushFollow(FOLLOW_instanceQualifier_in_pinAssign782);
                        instanceQualifier(instName, indices, des);

                        state._fsp--;


                        }
                        break;
                    case 2 :
                        // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:894:48: arrayIndices[indices, instName, des]
                        {
                        pushFollow(FOLLOW_arrayIndices_in_pinAssign787);
                        arrayIndices(indices, instName, des);

                        state._fsp--;


                        }
                        break;

                }

                pinName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinAssign796); 
                // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:895:17: ( sliceList[slices] | pinSlices[slices, $pinName.text, des, instName] )
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==COMMA||(LA20_0>=LEFTBRACKET && LA20_0<=COLON)) ) {
                    alt20=1;
                }
                else if ( (LA20_0==IDENT||LA20_0==LEFTANGLE||LA20_0==41) ) {
                    alt20=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 0, input);

                    throw nvae;
                }
                switch (alt20) {
                    case 1 :
                        // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:895:18: sliceList[slices]
                        {
                        pushFollow(FOLLOW_sliceList_in_pinAssign799);
                        sliceList(slices);

                        state._fsp--;


                        }
                        break;
                    case 2 :
                        // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:895:38: pinSlices[slices, $pinName.text, des, instName]
                        {
                        pushFollow(FOLLOW_pinSlices_in_pinAssign804);
                        pinSlices(slices, (pinName!=null?pinName.getText():null), des, instName);

                        state._fsp--;


                        }
                        break;

                }

                 int assignWidth = 0;
                		  if (slices.size() == 0 && indices.size() != 0) {assignWidth = indices.size();}
                		  if (slices.size() != 0 && indices.size() == 0) {assignWidth = slices.size();}
                		  if (slices.size() != 0 && indices.size() != 0) {assignWidth = indices.size() * slices.size();}
                		
                pushFollow(FOLLOW_concatenation_in_pinAssign815);
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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:952:1: netAssign[DesignNode des] : ^( EQUALS netName= IDENT ( sliceList[slices] | netSlices[slices, $netName.text, des] ) concatenation[concats, slices.size(), des] ) ;
    public final void netAssign(DesignNode des) throws RecognitionException {
        CommonTree netName=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:953:2: ( ^( EQUALS netName= IDENT ( sliceList[slices] | netSlices[slices, $netName.text, des] ) concatenation[concats, slices.size(), des] ) )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:953:4: ^( EQUALS netName= IDENT ( sliceList[slices] | netSlices[slices, $netName.text, des] ) concatenation[concats, slices.size(), des] )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_netAssign847); 

            	List<Integer> slices = new ArrayList<Integer>();
            				List<NetNode> concats = new ArrayList<NetNode>();
            			

            match(input, Token.DOWN, null); 
            netName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netAssign871); 
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:961:17: ( sliceList[slices] | netSlices[slices, $netName.text, des] )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==COMMA||(LA21_0>=LEFTBRACKET && LA21_0<=COLON)) ) {
                alt21=1;
            }
            else if ( (LA21_0==IDENT||LA21_0==LEFTANGLE||LA21_0==41) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:961:18: sliceList[slices]
                    {
                    pushFollow(FOLLOW_sliceList_in_netAssign874);
                    sliceList(slices);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:961:38: netSlices[slices, $netName.text, des]
                    {
                    pushFollow(FOLLOW_netSlices_in_netAssign879);
                    netSlices(slices, (netName!=null?netName.getText():null), des);

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_concatenation_in_netAssign885);
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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1002:1: concatenation[List<NetNode> concats, int assignWidth, DesignNode des] : ( (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* ) | ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) ) | ( 'open' ) ) ;
    public final void concatenation(List<NetNode> concats, int assignWidth, DesignNode des) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;
        CommonTree global=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1006:2: ( ( (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* ) | ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) ) | ( 'open' ) ) )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1007:4: ( (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* ) | ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) ) | ( 'open' ) )
            {
            List<Integer> slices = new ArrayList<Integer>();
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1009:3: ( (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* ) | ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) ) | ( 'open' ) )
            int alt26=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt26=1;
                }
                break;
            case LEFTANGLE:
                {
                alt26=2;
                }
                break;
            case 41:
                {
                alt26=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1009:4: (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* )
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1009:4: (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* )
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1009:5: first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )*
                    {
                    first=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenation937); 
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1009:17: ( sliceList[slices] | concatSlices[slices, $first.text, des] )
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
                            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1009:18: sliceList[slices]
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation940);
                            sliceList(slices);

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1009:38: concatSlices[slices, $first.text, des]
                            {
                            pushFollow(FOLLOW_concatSlices_in_concatenation945);
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
                    			
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1035:3: (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==IDENT) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1035:4: next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] )
                    	    {
                    	    next=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenation976); 
                    	    slices.clear();
                    	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1039:3: ( sliceList[slices] | concatSlices[slices, $next.text, des] )
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
                    	            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1039:4: sliceList[slices]
                    	            {
                    	            pushFollow(FOLLOW_sliceList_in_concatenation1000);
                    	            sliceList(slices);

                    	            state._fsp--;


                    	            }
                    	            break;
                    	        case 2 :
                    	            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1039:24: concatSlices[slices, $next.text, des]
                    	            {
                    	            pushFollow(FOLLOW_concatSlices_in_concatenation1005);
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
                    	    break loop24;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1065:10: ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) )
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1065:10: ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) )
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1065:11: LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] )
                    {
                    match(input,LEFTANGLE,FOLLOW_LEFTANGLE_in_concatenation1039); 
                    global=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenation1043); 
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1065:34: ( sliceList[slices] | concatSlices[slices, $global.text, des] )
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==COMMA||(LA25_0>=LEFTBRACKET && LA25_0<=COLON)) ) {
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
                            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1065:35: sliceList[slices]
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation1046);
                            sliceList(slices);

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1065:55: concatSlices[slices, $global.text, des]
                            {
                            pushFollow(FOLLOW_concatSlices_in_concatenation1051);
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
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1091:5: ( 'open' )
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1091:5: ( 'open' )
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1091:6: 'open'
                    {
                    match(input,41,FOLLOW_41_in_concatenation1083); 

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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1113:1: instanceQualifier[String instName, List<Integer> indices, DesignNode des] : ^( PERIOD (qualName= IDENT | ( 'this' ) ) ( arrayList[indices] | arrayIndices[indices, instName, des] ) ) ;
    public final void instanceQualifier(String instName, List<Integer> indices, DesignNode des) throws RecognitionException {
        CommonTree qualName=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1125:2: ( ^( PERIOD (qualName= IDENT | ( 'this' ) ) ( arrayList[indices] | arrayIndices[indices, instName, des] ) ) )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1125:4: ^( PERIOD (qualName= IDENT | ( 'this' ) ) ( arrayList[indices] | arrayIndices[indices, instName, des] ) )
            {
            boolean isThis = false;
            match(input,PERIOD,FOLLOW_PERIOD_in_instanceQualifier1125); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1126:12: (qualName= IDENT | ( 'this' ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==IDENT) ) {
                alt27=1;
            }
            else if ( (LA27_0==40) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1126:13: qualName= IDENT
                    {
                    qualName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instanceQualifier1130); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1126:30: ( 'this' )
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1126:30: ( 'this' )
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1126:31: 'this'
                    {
                    match(input,40,FOLLOW_40_in_instanceQualifier1135); 
                    isThis = true;

                    }


                    }
                    break;

            }

            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1126:57: ( arrayList[indices] | arrayIndices[indices, instName, des] )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==COMMA||LA28_0==COLON||LA28_0==LEFTPAREN) ) {
                alt28=1;
            }
            else if ( ((LA28_0>=UP && LA28_0<=IDENT)) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1126:58: arrayList[indices]
                    {
                    pushFollow(FOLLOW_arrayList_in_instanceQualifier1142);
                    arrayList(indices);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1126:79: arrayIndices[indices, instName, des]
                    {
                    pushFollow(FOLLOW_arrayIndices_in_instanceQualifier1147);
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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1139:1: arrayIndices[List<Integer> indices, String instName, DesignNode des] : ;
    public final void arrayIndices(List<Integer> indices, String instName, DesignNode des) throws RecognitionException {
        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1140:2: ()
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1140:4: 
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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1143:1: pinSlices[List<Integer> slices, String pinName, DesignNode des, String instName] : ;
    public final void pinSlices(List<Integer> slices, String pinName, DesignNode des, String instName) throws RecognitionException {
        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1144:2: ()
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1144:4: 
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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1150:1: netSlices[List<Integer> slices, String netName, DesignNode des] : ;
    public final void netSlices(List<Integer> slices, String netName, DesignNode des) throws RecognitionException {
        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1151:2: ()
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1151:4: 
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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1156:1: concatSlices[List<Integer> slices, String netName, DesignNode des] : ;
    public final void concatSlices(List<Integer> slices, String netName, DesignNode des) throws RecognitionException {
        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1157:2: ()
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1157:4: 
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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1160:1: arrayList[List<Integer> indices] : ( ^( COMMA LEFTPAREN first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTPAREN first= INTEGER last= INTEGER ) | ( LEFTPAREN single= INTEGER ) );
    public final void arrayList(List<Integer> indices) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;
        CommonTree last=null;
        CommonTree single=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1171:2: ( ^( COMMA LEFTPAREN first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTPAREN first= INTEGER last= INTEGER ) | ( LEFTPAREN single= INTEGER ) )
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
            case LEFTPAREN:
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
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1172:3: ^( COMMA LEFTPAREN first= INTEGER (next= INTEGER )* )
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_arrayList1241); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList1243); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1247); 
                    indices.add(Integer.parseInt((first!=null?first.getText():null)));
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1173:8: (next= INTEGER )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==INTEGER) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1173:9: next= INTEGER
                    	    {
                    	    next=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1262); 
                    	    indices.add(Integer.parseInt((next!=null?next.getText():null)));

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
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1176:5: ^( COLON LEFTPAREN first= INTEGER last= INTEGER )
                    {
                    match(input,COLON,FOLLOW_COLON_in_arrayList1297); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList1299); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1303); 
                    last=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1307); 
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
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1194:4: ( LEFTPAREN single= INTEGER )
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1194:4: ( LEFTPAREN single= INTEGER )
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1194:5: LEFTPAREN single= INTEGER
                    {
                    match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList1340); 
                    single=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1344); 
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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1197:1: sliceList[List<Integer> slices] : ( ^( COMMA LEFTBRACKET first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTBRACKET first= INTEGER last= INTEGER ) | ( LEFTBRACKET single= INTEGER ) );
    public final void sliceList(List<Integer> slices) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;
        CommonTree last=null;
        CommonTree single=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1208:2: ( ^( COMMA LEFTBRACKET first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTBRACKET first= INTEGER last= INTEGER ) | ( LEFTBRACKET single= INTEGER ) )
            int alt32=3;
            switch ( input.LA(1) ) {
            case COMMA:
                {
                alt32=1;
                }
                break;
            case COLON:
                {
                alt32=2;
                }
                break;
            case LEFTBRACKET:
                {
                alt32=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1209:3: ^( COMMA LEFTBRACKET first= INTEGER (next= INTEGER )* )
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_sliceList1371); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList1373); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1377); 
                    slices.add(Integer.parseInt((first!=null?first.getText():null)));
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1210:8: (next= INTEGER )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==INTEGER) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1210:9: next= INTEGER
                    	    {
                    	    next=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1393); 
                    	    slices.add(Integer.parseInt((next!=null?next.getText():null)));

                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1213:4: ^( COLON LEFTBRACKET first= INTEGER last= INTEGER )
                    {
                    match(input,COLON,FOLLOW_COLON_in_sliceList1428); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList1430); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1434); 
                    last=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1438); 
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
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1233:4: ( LEFTBRACKET single= INTEGER )
                    {
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1233:4: ( LEFTBRACKET single= INTEGER )
                    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1233:5: LEFTBRACKET single= INTEGER
                    {
                    match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList1470); 
                    single=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1474); 
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
    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1237:1: pinList[List<String> pList] : first= ( INTEGER | IDENT ) (next= ( INTEGER | IDENT ) )* ;
    public final void pinList(List<String> pList) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;

        try {
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1248:2: (first= ( INTEGER | IDENT ) (next= ( INTEGER | IDENT ) )* )
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1248:4: first= ( INTEGER | IDENT ) (next= ( INTEGER | IDENT ) )*
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
            			
            // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1259:7: (next= ( INTEGER | IDENT ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==IDENT||LA33_0==INTEGER) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // C:\\Users\\RichardAllen\\workspace\\PHDLCompiler\\src\\phdl\\grammar\\PhdlWalker.g:1259:8: next= ( INTEGER | IDENT )
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
            	    break loop33;
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


    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA15_eotS =
        "\32\uffff";
    static final String DFA15_eofS =
        "\32\uffff";
    static final String DFA15_minS =
        "\1\3\1\uffff\1\2\1\4\1\uffff\1\2\2\4\1\uffff\2\3\2\2\1\16\1\4\2"+
        "\23\1\3\2\16\1\3\1\16\4\3";
    static final String DFA15_maxS =
        "\1\6\1\uffff\1\2\1\47\1\uffff\1\2\1\51\1\50\1\uffff\2\23\2\2\1"+
        "\16\1\4\2\23\1\3\5\16\3\3";
    static final String DFA15_acceptS =
        "\1\uffff\1\3\2\uffff\1\1\3\uffff\1\2\21\uffff";
    static final String DFA15_specialS =
        "\32\uffff}>";
    static final String[] DFA15_transitionS = {
            "\2\1\1\uffff\1\2",
            "",
            "\1\3",
            "\1\6\4\uffff\1\5\35\uffff\1\4",
            "",
            "\1\7",
            "\1\10\2\uffff\1\4\1\10\2\uffff\1\10\4\uffff\2\10\27\uffff"+
            "\1\10",
            "\1\11\43\uffff\1\12",
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

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "()* loopback of 714:3: ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] )*";
        }
    }
 

    public static final BitSet FOLLOW_designDecl_in_sourceText61 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_designDecl76 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_designDecl80 = new BitSet(new long[]{0x00000024A0000000L});
    public static final BitSet FOLLOW_deviceDecl_in_designDecl104 = new BitSet(new long[]{0x00000024A0000000L});
    public static final BitSet FOLLOW_netDecl_in_designDecl109 = new BitSet(new long[]{0x00000024A0000000L});
    public static final BitSet FOLLOW_infoStruct_in_designDecl116 = new BitSet(new long[]{0x00000024A0000000L});
    public static final BitSet FOLLOW_29_in_designDecl123 = new BitSet(new long[]{0x0000004800000058L});
    public static final BitSet FOLLOW_instDecl_in_designDecl129 = new BitSet(new long[]{0x0000004800000058L});
    public static final BitSet FOLLOW_netAssign_in_designDecl134 = new BitSet(new long[]{0x0000004800000058L});
    public static final BitSet FOLLOW_groupStruct_in_designDecl139 = new BitSet(new long[]{0x0000004800000058L});
    public static final BitSet FOLLOW_IDENT_in_designDecl147 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_37_in_infoStruct181 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_infoStruct185 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_38_in_groupStruct203 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_groupStruct207 = new BitSet(new long[]{0x00000008000000C8L});
    public static final BitSet FOLLOW_instDecl_in_groupStruct210 = new BitSet(new long[]{0x00000008000000C8L});
    public static final BitSet FOLLOW_netAssign_in_groupStruct215 = new BitSet(new long[]{0x00000008000000C8L});
    public static final BitSet FOLLOW_STRING_in_groupStruct223 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_31_in_deviceDecl255 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl259 = new BitSet(new long[]{0x0000000300000018L});
    public static final BitSet FOLLOW_attributeDecl_in_deviceDecl286 = new BitSet(new long[]{0x0000000300000018L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl291 = new BitSet(new long[]{0x0000000300000018L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl298 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_32_in_attributeDecl331 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_attributeDecl335 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_in_attributeDecl339 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_33_in_pinDecl376 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_sliceList_in_pinDecl398 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl404 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_pinList_in_pinDecl406 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_34_in_netDecl440 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_sliceList_in_netDecl463 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl475 = new BitSet(new long[]{0x0000000100000118L});
    public static final BitSet FOLLOW_COMMA_in_netDecl505 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl509 = new BitSet(new long[]{0x0000000100000118L});
    public static final BitSet FOLLOW_attributeDecl_in_netDecl539 = new BitSet(new long[]{0x0000000100000018L});
    public static final BitSet FOLLOW_IDENT_in_netDecl545 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_35_in_instDecl579 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arrayList_in_instDecl601 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instDecl607 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instDecl611 = new BitSet(new long[]{0x0000000000000058L});
    public static final BitSet FOLLOW_attrAssign_in_instDecl633 = new BitSet(new long[]{0x0000000000000058L});
    public static final BitSet FOLLOW_pinAssign_in_instDecl638 = new BitSet(new long[]{0x0000000000000058L});
    public static final BitSet FOLLOW_IDENT_in_instDecl645 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUALS_in_attrAssign679 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_39_in_attrAssign703 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_instanceQualifier_in_attrAssign713 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_arrayIndices_in_attrAssign718 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attrAssign726 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_in_attrAssign730 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssign761 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_instanceQualifier_in_pinAssign782 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_arrayIndices_in_pinAssign787 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinAssign796 = new BitSet(new long[]{0x0000020000030910L});
    public static final BitSet FOLLOW_sliceList_in_pinAssign799 = new BitSet(new long[]{0x0000020000030910L});
    public static final BitSet FOLLOW_pinSlices_in_pinAssign804 = new BitSet(new long[]{0x0000020000030910L});
    public static final BitSet FOLLOW_concatenation_in_pinAssign815 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUALS_in_netAssign847 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_netAssign871 = new BitSet(new long[]{0x0000020000030910L});
    public static final BitSet FOLLOW_sliceList_in_netAssign874 = new BitSet(new long[]{0x0000020000030910L});
    public static final BitSet FOLLOW_netSlices_in_netAssign879 = new BitSet(new long[]{0x0000020000030910L});
    public static final BitSet FOLLOW_concatenation_in_netAssign885 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENT_in_concatenation937 = new BitSet(new long[]{0x0000000000030110L});
    public static final BitSet FOLLOW_sliceList_in_concatenation940 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_concatSlices_in_concatenation945 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_IDENT_in_concatenation976 = new BitSet(new long[]{0x0000000000030110L});
    public static final BitSet FOLLOW_sliceList_in_concatenation1000 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_concatSlices_in_concatenation1005 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_LEFTANGLE_in_concatenation1039 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation1043 = new BitSet(new long[]{0x0000000000030100L});
    public static final BitSet FOLLOW_sliceList_in_concatenation1046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_concatSlices_in_concatenation1051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_concatenation1083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_instanceQualifier1125 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_instanceQualifier1130 = new BitSet(new long[]{0x00000000000A0108L});
    public static final BitSet FOLLOW_40_in_instanceQualifier1135 = new BitSet(new long[]{0x00000000000A0108L});
    public static final BitSet FOLLOW_arrayList_in_instanceQualifier1142 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_arrayIndices_in_instanceQualifier1147 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMMA_in_arrayList1241 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList1243 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1247 = new BitSet(new long[]{0x0000000000004008L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1262 = new BitSet(new long[]{0x0000000000004008L});
    public static final BitSet FOLLOW_COLON_in_arrayList1297 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList1299 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1303 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1307 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList1340 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_sliceList1371 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList1373 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1377 = new BitSet(new long[]{0x0000000000004008L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1393 = new BitSet(new long[]{0x0000000000004008L});
    public static final BitSet FOLLOW_COLON_in_sliceList1428 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList1430 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1434 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1438 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList1470 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_pinList1500 = new BitSet(new long[]{0x0000000000004012L});
    public static final BitSet FOLLOW_set_in_pinList1535 = new BitSet(new long[]{0x0000000000004012L});

}