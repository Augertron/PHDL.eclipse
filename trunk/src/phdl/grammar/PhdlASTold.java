// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g 2012-01-06 22:47:02

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
public class PhdlASTold extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "LEFTBRACE", "RIGHTBRACE", "SEMICOLON", "EQUALS", "STRING", "COMMA", "LEFTPAREN", "RIGHTPAREN", "PERIOD", "AMPERSAND", "LEFTANGLE", "RIGHTANGLE", "INTEGER", "LEFTBRACKET", "COLON", "RIGHTBRACKET", "CHAR", "DIGIT", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "INCLUDE", "'design'", "'port'", "'device'", "'attr'", "'pin'", "'net'", "'inst'", "'of'", "'sub'", "'combine'", "'newattr'", "'this'", "'info'", "'group'", "'open'", "'each'"
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
    public static final int LEFTBRACE=5;
    public static final int RIGHTBRACE=6;
    public static final int SEMICOLON=7;
    public static final int EQUALS=8;
    public static final int STRING=9;
    public static final int COMMA=10;
    public static final int LEFTPAREN=11;
    public static final int RIGHTPAREN=12;
    public static final int PERIOD=13;
    public static final int AMPERSAND=14;
    public static final int LEFTANGLE=15;
    public static final int RIGHTANGLE=16;
    public static final int INTEGER=17;
    public static final int LEFTBRACKET=18;
    public static final int COLON=19;
    public static final int RIGHTBRACKET=20;
    public static final int CHAR=21;
    public static final int DIGIT=22;
    public static final int WHITESPACE=23;
    public static final int LINE_COMMENT=24;
    public static final int MULTILINE_COMMENT=25;
    public static final int INCLUDE=26;
    public static final int T__42=42;

    // delegates
    // delegators


        public PhdlASTold(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public PhdlASTold(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PhdlASTold.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g"; }



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
    	
    	public DesignNode getDesignNode(String name) {
        for (DesignNode d : designNodes) {
          if (d.getName().equals(name)) {
            return d;
          }
        }
        return null;
    	}
    	
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:303:1: sourceText : ( designDecl )* ;
    public final void sourceText() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:310:2: ( ( designDecl )* )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:310:4: ( designDecl )*
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:310:4: ( designDecl )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==27) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:310:4: designDecl
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:313:1: designDecl : ^( 'design' desName= IDENT ( deviceDecl[des] | netDecl[des] | infoStruct | instDecl[des, null] | netAssign[des] | groupStruct[des] | subDesignInstance[des] )* ) ;
    public final void designDecl() throws RecognitionException {
        CommonTree desName=null;
        String infoStruct1 = null;


        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:326:2: ( ^( 'design' desName= IDENT ( deviceDecl[des] | netDecl[des] | infoStruct | instDecl[des, null] | netAssign[des] | groupStruct[des] | subDesignInstance[des] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:326:4: ^( 'design' desName= IDENT ( deviceDecl[des] | netDecl[des] | infoStruct | instDecl[des, null] | netAssign[des] | groupStruct[des] | subDesignInstance[des] )* )
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:341:3: ( deviceDecl[des] | netDecl[des] | infoStruct | instDecl[des, null] | netAssign[des] | groupStruct[des] | subDesignInstance[des] )*
            loop2:
            do {
                int alt2=8;
                switch ( input.LA(1) ) {
                case 29:
                    {
                    alt2=1;
                    }
                    break;
                case 32:
                    {
                    alt2=2;
                    }
                    break;
                case 39:
                    {
                    alt2=3;
                    }
                    break;
                case 33:
                    {
                    alt2=4;
                    }
                    break;
                case EQUALS:
                    {
                    alt2=5;
                    }
                    break;
                case 40:
                    {
                    alt2=6;
                    }
                    break;
                case 35:
                    {
                    alt2=7;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:341:4: deviceDecl[des]
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_designDecl105);
            	    deviceDecl(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:341:22: netDecl[des]
            	    {
            	    pushFollow(FOLLOW_netDecl_in_designDecl110);
            	    netDecl(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:341:37: infoStruct
            	    {
            	    pushFollow(FOLLOW_infoStruct_in_designDecl115);
            	    infoStruct1=infoStruct();

            	    state._fsp--;

            	    des.appendInfo(infoStruct1);

            	    }
            	    break;
            	case 4 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:341:87: instDecl[des, null]
            	    {
            	    pushFollow(FOLLOW_instDecl_in_designDecl121);
            	    instDecl(des, null);

            	    state._fsp--;


            	    }
            	    break;
            	case 5 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:341:109: netAssign[des]
            	    {
            	    pushFollow(FOLLOW_netAssign_in_designDecl126);
            	    netAssign(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 6 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:341:126: groupStruct[des]
            	    {
            	    pushFollow(FOLLOW_groupStruct_in_designDecl131);
            	    groupStruct(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 7 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:341:145: subDesignInstance[des]
            	    {
            	    pushFollow(FOLLOW_subDesignInstance_in_designDecl136);
            	    subDesignInstance(des);

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


    // $ANTLR start "subDesignInstance"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:368:1: subDesignInstance[DesignNode des] : ^( 'sub' ( arrayList[indices] )? subDesName= IDENT desName= IDENT ) ;
    public final void subDesignInstance(DesignNode des) throws RecognitionException {
        CommonTree subDesName=null;
        CommonTree desName=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:369:3: ( ^( 'sub' ( arrayList[indices] )? subDesName= IDENT desName= IDENT ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:369:7: ^( 'sub' ( arrayList[indices] )? subDesName= IDENT desName= IDENT )
            {
            match(input,35,FOLLOW_35_in_subDesignInstance172); 

             // Set of instance nodes to check for duplicates
                    List<DesignNode> subDesignNodes = new ArrayList<DesignNode>();
                    // List of indices to be derived from the arrayList
                    List<Integer> indices = new ArrayList<Integer>();
                  

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:378:7: ( arrayList[indices] )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=COMMA && LA3_0<=LEFTPAREN)||LA3_0==COLON) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:378:7: arrayList[indices]
                    {
                    pushFollow(FOLLOW_arrayList_in_subDesignInstance210);
                    arrayList(indices);

                    state._fsp--;


                    }
                    break;

            }

            subDesName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_subDesignInstance216); 
            desName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_subDesignInstance220); 

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
    // $ANTLR end "subDesignInstance"


    // $ANTLR start "infoStruct"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:416:1: infoStruct returns [String value] : ^( 'info' string= STRING ) ;
    public final String infoStruct() throws RecognitionException {
        String value = null;

        CommonTree string=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:417:2: ( ^( 'info' string= STRING ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:417:5: ^( 'info' string= STRING )
            {
            match(input,39,FOLLOW_39_in_infoStruct268); 

            match(input, Token.DOWN, null); 
            string=(CommonTree)match(input,STRING,FOLLOW_STRING_in_infoStruct272); 
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:420:1: groupStruct[DesignNode des] : ^( 'group' groupName= STRING ( instDecl[des, $groupName.text] | netAssign[des] )* ) ;
    public final void groupStruct(DesignNode des) throws RecognitionException {
        CommonTree groupName=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:421:2: ( ^( 'group' groupName= STRING ( instDecl[des, $groupName.text] | netAssign[des] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:421:4: ^( 'group' groupName= STRING ( instDecl[des, $groupName.text] | netAssign[des] )* )
            {
            match(input,40,FOLLOW_40_in_groupStruct290); 

            match(input, Token.DOWN, null); 
            groupName=(CommonTree)match(input,STRING,FOLLOW_STRING_in_groupStruct294); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:421:31: ( instDecl[des, $groupName.text] | netAssign[des] )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==33) ) {
                    alt4=1;
                }
                else if ( (LA4_0==EQUALS) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:421:32: instDecl[des, $groupName.text]
            	    {
            	    pushFollow(FOLLOW_instDecl_in_groupStruct297);
            	    instDecl(des, (groupName!=null?groupName.getText():null));

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:421:65: netAssign[des]
            	    {
            	    pushFollow(FOLLOW_netAssign_in_groupStruct302);
            	    netAssign(des);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:424:1: deviceDecl[DesignNode des] : ^( 'device' devName= IDENT ( attributeDecl[devices] | pinDecl[dev] )* ) ;
    public final void deviceDecl(DesignNode des) throws RecognitionException {
        CommonTree devName=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:436:2: ( ^( 'device' devName= IDENT ( attributeDecl[devices] | pinDecl[dev] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:436:4: ^( 'device' devName= IDENT ( attributeDecl[devices] | pinDecl[dev] )* )
            {
            match(input,29,FOLLOW_29_in_deviceDecl323); 

            match(input, Token.DOWN, null); 
            devName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl327); 
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
            			
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:454:3: ( attributeDecl[devices] | pinDecl[dev] )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==30) ) {
                    alt5=1;
                }
                else if ( (LA5_0==31) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:454:4: attributeDecl[devices]
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_deviceDecl354);
            	    attributeDecl(devices);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:454:29: pinDecl[dev]
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl359);
            	    pinDecl(dev);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:472:1: attributeDecl[List<Attributable> parents] : ^( 'attr' attrName= IDENT attrValue= STRING ) ;
    public final void attributeDecl(List<Attributable> parents) throws RecognitionException {
        CommonTree attrName=null;
        CommonTree attrValue=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:484:2: ( ^( 'attr' attrName= IDENT attrValue= STRING ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:484:4: ^( 'attr' attrName= IDENT attrValue= STRING )
            {
            match(input,30,FOLLOW_30_in_attributeDecl394); 

            match(input, Token.DOWN, null); 
            attrName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attributeDecl398); 
            attrValue=(CommonTree)match(input,STRING,FOLLOW_STRING_in_attributeDecl402); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:510:1: pinDecl[DeviceNode dev] : ^( 'pin' ( sliceList[sList] )? pinName= IDENT pinList[pList] ) ;
    public final void pinDecl(DeviceNode dev) throws RecognitionException {
        CommonTree pinName=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:528:2: ( ^( 'pin' ( sliceList[sList] )? pinName= IDENT pinList[pList] ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:528:4: ^( 'pin' ( sliceList[sList] )? pinName= IDENT pinList[pList] )
            {
            match(input,31,FOLLOW_31_in_pinDecl439); 

             	// sets to keep track of the slice and pin lists
            				List<Integer> sList = new ArrayList<Integer>(); 
            				List<String> pList = new ArrayList<String>();
            			

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:537:3: ( sliceList[sList] )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==COMMA||(LA6_0>=LEFTBRACKET && LA6_0<=COLON)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:537:3: sliceList[sList]
                    {
                    pushFollow(FOLLOW_sliceList_in_pinDecl461);
                    sliceList(sList);

                    state._fsp--;


                    }
                    break;

            }

            pinName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinDecl467); 
            pushFollow(FOLLOW_pinList_in_pinDecl469);
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
            						newPin.setName(pList.get(i));
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
            						newPin.setName(pList.get(0));
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:593:1: netDecl[DesignNode des] : ^( 'net' ( sliceList[slices] )? firstName= IDENT ( COMMA nextName= IDENT )* ( attributeDecl[netNodes] )* ) ;
    public final void netDecl(DesignNode des) throws RecognitionException {
        CommonTree firstName=null;
        CommonTree nextName=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:602:2: ( ^( 'net' ( sliceList[slices] )? firstName= IDENT ( COMMA nextName= IDENT )* ( attributeDecl[netNodes] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:602:4: ^( 'net' ( sliceList[slices] )? firstName= IDENT ( COMMA nextName= IDENT )* ( attributeDecl[netNodes] )* )
            {
            match(input,32,FOLLOW_32_in_netDecl503); 

            	List<Integer> slices = new ArrayList<Integer>();
            				List<Attributable> netNodes = new ArrayList<Attributable>();
            				attrDecls.clear();
            			

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:611:3: ( sliceList[slices] )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==COMMA||(LA7_0>=LEFTBRACKET && LA7_0<=COLON)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:611:3: sliceList[slices]
                    {
                    pushFollow(FOLLOW_sliceList_in_netDecl526);
                    sliceList(slices);

                    state._fsp--;


                    }
                    break;

            }

            firstName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netDecl538); 
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
            			
            			
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:635:3: ( COMMA nextName= IDENT )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==COMMA) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:635:4: COMMA nextName= IDENT
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_netDecl568); 
            	    nextName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netDecl572); 
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
            	    break loop8;
                }
            } while (true);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:658:3: ( attributeDecl[netNodes] )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==30) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:658:3: attributeDecl[netNodes]
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_netDecl602);
            	    attributeDecl(netNodes);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:675:1: instDecl[DesignNode des, String groupName] : ^( 'inst' ( arrayList[indices] )? instName= IDENT devName= IDENT ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] | infoStruct )* ) ;
    public final void instDecl(DesignNode des, String groupName) throws RecognitionException {
        CommonTree instName=null;
        CommonTree devName=null;
        String infoStruct2 = null;


        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:686:2: ( ^( 'inst' ( arrayList[indices] )? instName= IDENT devName= IDENT ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] | infoStruct )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:686:4: ^( 'inst' ( arrayList[indices] )? instName= IDENT devName= IDENT ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] | infoStruct )* )
            {
            match(input,33,FOLLOW_33_in_instDecl637); 

            	// Set of instance nodes to check for duplicates
            				List<InstanceNode> instNodes = new ArrayList<InstanceNode>();
            				// List of indices to be derived from the arrayList
            				List<Integer> indices = new ArrayList<Integer>();
            			

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:696:3: ( arrayList[indices] )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=COMMA && LA10_0<=LEFTPAREN)||LA10_0==COLON) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:696:3: arrayList[indices]
                    {
                    pushFollow(FOLLOW_arrayList_in_instDecl659);
                    arrayList(indices);

                    state._fsp--;


                    }
                    break;

            }

            instName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl665); 
            devName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl669); 
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
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:759:3: ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] | infoStruct )*
            loop11:
            do {
                int alt11=4;
                alt11 = dfa11.predict(input);
                switch (alt11) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:759:4: attrAssign[des, $instName.text]
            	    {
            	    pushFollow(FOLLOW_attrAssign_in_instDecl694);
            	    attrAssign(des, (instName!=null?instName.getText():null));

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:759:38: pinAssign[des, $instName.text]
            	    {
            	    pushFollow(FOLLOW_pinAssign_in_instDecl699);
            	    pinAssign(des, (instName!=null?instName.getText():null));

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:759:71: infoStruct
            	    {
            	    pushFollow(FOLLOW_infoStruct_in_instDecl704);
            	    infoStruct2=infoStruct();

            	    state._fsp--;

            	    info += infoStruct2 + "\n";

            	    }
            	    break;

            	default :
            	    break loop11;
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:790:1: attrAssign[DesignNode des, String instName] : ^( EQUALS ( 'newattr' )? ( attributeQualifier[instName, indices, des] | arrayIndices[instName, indices, des] ) attrName= IDENT attrValue= STRING ) ;
    public final void attrAssign(DesignNode des, String instName) throws RecognitionException {
        CommonTree attrName=null;
        CommonTree attrValue=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:807:2: ( ^( EQUALS ( 'newattr' )? ( attributeQualifier[instName, indices, des] | arrayIndices[instName, indices, des] ) attrName= IDENT attrValue= STRING ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:807:4: ^( EQUALS ( 'newattr' )? ( attributeQualifier[instName, indices, des] | arrayIndices[instName, indices, des] ) attrName= IDENT attrValue= STRING )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_attrAssign741); 

            	// flag for a new attribute and a list of indices the attribute assignment applies to
            				boolean newAttr = false;
            				List<Integer> indices = new ArrayList<Integer>();
            			

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:816:3: ( 'newattr' )?
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==37) ) {
                    alt12=1;
                }
                switch (alt12) {
                    case 1 :
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:816:4: 'newattr'
                        {
                        match(input,37,FOLLOW_37_in_attrAssign765); 
                        newAttr = true;

                        }
                        break;

                }

                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:817:3: ( attributeQualifier[instName, indices, des] | arrayIndices[instName, indices, des] )
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
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:817:4: attributeQualifier[instName, indices, des]
                        {
                        pushFollow(FOLLOW_attributeQualifier_in_attrAssign775);
                        attributeQualifier(instName, indices, des);

                        state._fsp--;


                        }
                        break;
                    case 2 :
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:817:49: arrayIndices[instName, indices, des]
                        {
                        pushFollow(FOLLOW_arrayIndices_in_attrAssign780);
                        arrayIndices(instName, indices, des);

                        state._fsp--;


                        }
                        break;

                }

                attrName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attrAssign788); 
                attrValue=(CommonTree)match(input,STRING,FOLLOW_STRING_in_attrAssign792); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:899:1: pinAssign[DesignNode des, String instName] : ^( EQUALS ( pinQualifier[instName, indices, des] | arrayIndices[instName, indices, des] ) pinName= IDENT ( sliceList[slices] | pinSlices[slices, $pinName.text, des, instName] ) concatenation[concats, assignWidth, des] ) ;
    public final void pinAssign(DesignNode des, String instName) throws RecognitionException {
        CommonTree pinName=null;
        boolean pinQualifier3 = false;


        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:900:2: ( ^( EQUALS ( pinQualifier[instName, indices, des] | arrayIndices[instName, indices, des] ) pinName= IDENT ( sliceList[slices] | pinSlices[slices, $pinName.text, des, instName] ) concatenation[concats, assignWidth, des] ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:900:4: ^( EQUALS ( pinQualifier[instName, indices, des] | arrayIndices[instName, indices, des] ) pinName= IDENT ( sliceList[slices] | pinSlices[slices, $pinName.text, des, instName] ) concatenation[concats, assignWidth, des] )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_pinAssign823); 

            	List<Integer> indices = new ArrayList<Integer>();
            				List<Integer> slices = new ArrayList<Integer>();
            				List<NetNode> concats = new ArrayList<NetNode>();
            			
            boolean combine = false;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:910:5: ( pinQualifier[instName, indices, des] | arrayIndices[instName, indices, des] )
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==PERIOD) ) {
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
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:910:6: pinQualifier[instName, indices, des]
                        {
                        pushFollow(FOLLOW_pinQualifier_in_pinAssign858);
                        pinQualifier3=pinQualifier(instName, indices, des);

                        state._fsp--;

                        combine = pinQualifier3;

                        }
                        break;
                    case 2 :
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:910:80: arrayIndices[instName, indices, des]
                        {
                        pushFollow(FOLLOW_arrayIndices_in_pinAssign865);
                        arrayIndices(instName, indices, des);

                        state._fsp--;


                        }
                        break;

                }

                pinName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinAssign876); 
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:911:19: ( sliceList[slices] | pinSlices[slices, $pinName.text, des, instName] )
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==COMMA||(LA15_0>=LEFTBRACKET && LA15_0<=COLON)) ) {
                    alt15=1;
                }
                else if ( (LA15_0==IDENT||LA15_0==LEFTANGLE||LA15_0==41) ) {
                    alt15=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 0, input);

                    throw nvae;
                }
                switch (alt15) {
                    case 1 :
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:911:20: sliceList[slices]
                        {
                        pushFollow(FOLLOW_sliceList_in_pinAssign879);
                        sliceList(slices);

                        state._fsp--;


                        }
                        break;
                    case 2 :
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:911:40: pinSlices[slices, $pinName.text, des, instName]
                        {
                        pushFollow(FOLLOW_pinSlices_in_pinAssign884);
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
                			
                pushFollow(FOLLOW_concatenation_in_pinAssign902);
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
            						if(inst.findIndex() == indices.get(j)) {
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:974:1: netAssign[DesignNode des] : ^( EQUALS netName= IDENT ( sliceList[slices] | netSlices[slices, $netName.text, des] ) concatenation[concats, slices.size(), des] ) ;
    public final void netAssign(DesignNode des) throws RecognitionException {
        CommonTree netName=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:975:2: ( ^( EQUALS netName= IDENT ( sliceList[slices] | netSlices[slices, $netName.text, des] ) concatenation[concats, slices.size(), des] ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:975:4: ^( EQUALS netName= IDENT ( sliceList[slices] | netSlices[slices, $netName.text, des] ) concatenation[concats, slices.size(), des] )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_netAssign934); 

            	List<Integer> slices = new ArrayList<Integer>();
            				List<NetNode> concats = new ArrayList<NetNode>();
            			

            match(input, Token.DOWN, null); 
            netName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netAssign958); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:983:17: ( sliceList[slices] | netSlices[slices, $netName.text, des] )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==COMMA||(LA16_0>=LEFTBRACKET && LA16_0<=COLON)) ) {
                alt16=1;
            }
            else if ( (LA16_0==IDENT||LA16_0==LEFTANGLE||LA16_0==41) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:983:18: sliceList[slices]
                    {
                    pushFollow(FOLLOW_sliceList_in_netAssign961);
                    sliceList(slices);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:983:38: netSlices[slices, $netName.text, des]
                    {
                    pushFollow(FOLLOW_netSlices_in_netAssign966);
                    netSlices(slices, (netName!=null?netName.getText():null), des);

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_concatenation_in_netAssign972);
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1024:1: concatenation[List<NetNode> concats, int assignWidth, DesignNode des] : ( (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* ) | ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) ) | ( 'open' ) ) ;
    public final void concatenation(List<NetNode> concats, int assignWidth, DesignNode des) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;
        CommonTree global=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1028:2: ( ( (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* ) | ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) ) | ( 'open' ) ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1029:4: ( (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* ) | ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) ) | ( 'open' ) )
            {
            List<Integer> slices = new ArrayList<Integer>();
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1031:3: ( (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* ) | ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) ) | ( 'open' ) )
            int alt21=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt21=1;
                }
                break;
            case LEFTANGLE:
                {
                alt21=2;
                }
                break;
            case 41:
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1031:4: (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1031:4: (first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )* )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1031:5: first= IDENT ( sliceList[slices] | concatSlices[slices, $first.text, des] ) (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )*
                    {
                    first=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenation1024); 
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1031:17: ( sliceList[slices] | concatSlices[slices, $first.text, des] )
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
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1031:18: sliceList[slices]
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation1027);
                            sliceList(slices);

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1031:38: concatSlices[slices, $first.text, des]
                            {
                            pushFollow(FOLLOW_concatSlices_in_concatenation1032);
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
                    			
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1057:3: (next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==IDENT) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1057:4: next= IDENT ( sliceList[slices] | concatSlices[slices, $next.text, des] )
                    	    {
                    	    next=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenation1063); 
                    	    slices.clear();
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1061:3: ( sliceList[slices] | concatSlices[slices, $next.text, des] )
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
                    	            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1061:4: sliceList[slices]
                    	            {
                    	            pushFollow(FOLLOW_sliceList_in_concatenation1087);
                    	            sliceList(slices);

                    	            state._fsp--;


                    	            }
                    	            break;
                    	        case 2 :
                    	            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1061:24: concatSlices[slices, $next.text, des]
                    	            {
                    	            pushFollow(FOLLOW_concatSlices_in_concatenation1092);
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
                    	    break loop19;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1087:10: ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1087:10: ( LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] ) )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1087:11: LEFTANGLE global= IDENT ( sliceList[slices] | concatSlices[slices, $global.text, des] )
                    {
                    match(input,LEFTANGLE,FOLLOW_LEFTANGLE_in_concatenation1126); 
                    global=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_concatenation1130); 
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1087:34: ( sliceList[slices] | concatSlices[slices, $global.text, des] )
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
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1087:35: sliceList[slices]
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation1133);
                            sliceList(slices);

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1087:55: concatSlices[slices, $global.text, des]
                            {
                            pushFollow(FOLLOW_concatSlices_in_concatenation1138);
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1113:5: ( 'open' )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1113:5: ( 'open' )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1113:6: 'open'
                    {
                    match(input,41,FOLLOW_41_in_concatenation1170); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1135:1: attributeQualifier[String instName, List<Integer> indices, DesignNode des] : ^( PERIOD 'each' ( arrayList[indices] | arrayIndices[instName, indices, des] ) ) ;
    public final void attributeQualifier(String instName, List<Integer> indices, DesignNode des) throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1145:2: ( ^( PERIOD 'each' ( arrayList[indices] | arrayIndices[instName, indices, des] ) ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1145:4: ^( PERIOD 'each' ( arrayList[indices] | arrayIndices[instName, indices, des] ) )
            {
            match(input,PERIOD,FOLLOW_PERIOD_in_attributeQualifier1208); 

            match(input, Token.DOWN, null); 
            match(input,42,FOLLOW_42_in_attributeQualifier1210); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1145:20: ( arrayList[indices] | arrayIndices[instName, indices, des] )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=COMMA && LA22_0<=LEFTPAREN)||LA22_0==COLON) ) {
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1145:21: arrayList[indices]
                    {
                    pushFollow(FOLLOW_arrayList_in_attributeQualifier1213);
                    arrayList(indices);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1145:42: arrayIndices[instName, indices, des]
                    {
                    pushFollow(FOLLOW_arrayIndices_in_attributeQualifier1218);
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1148:1: pinQualifier[String instName, List<Integer> indices, DesignNode des] returns [boolean combine] : ^( PERIOD ( 'each' | 'combine' ) ( arrayList[indices] | arrayIndices[instName, indices, des] ) ) ;
    public final boolean pinQualifier(String instName, List<Integer> indices, DesignNode des) throws RecognitionException {
        boolean combine = false;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1156:2: ( ^( PERIOD ( 'each' | 'combine' ) ( arrayList[indices] | arrayIndices[instName, indices, des] ) ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1156:4: ^( PERIOD ( 'each' | 'combine' ) ( arrayList[indices] | arrayIndices[instName, indices, des] ) )
            {
            combine = false;
            match(input,PERIOD,FOLLOW_PERIOD_in_pinQualifier1248); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1157:12: ( 'each' | 'combine' )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==42) ) {
                alt23=1;
            }
            else if ( (LA23_0==36) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1157:13: 'each'
                    {
                    match(input,42,FOLLOW_42_in_pinQualifier1251); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1157:22: 'combine'
                    {
                    match(input,36,FOLLOW_36_in_pinQualifier1255); 
                    combine = true;

                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1158:3: ( arrayList[indices] | arrayIndices[instName, indices, des] )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=COMMA && LA24_0<=LEFTPAREN)||LA24_0==COLON) ) {
                alt24=1;
            }
            else if ( ((LA24_0>=UP && LA24_0<=IDENT)) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1158:4: arrayList[indices]
                    {
                    pushFollow(FOLLOW_arrayList_in_pinQualifier1264);
                    arrayList(indices);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1158:25: arrayIndices[instName, indices, des]
                    {
                    pushFollow(FOLLOW_arrayIndices_in_pinQualifier1269);
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1161:1: arrayIndices[String instName, List<Integer> indices, DesignNode des] : ;
    public final void arrayIndices(String instName, List<Integer> indices, DesignNode des) throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1166:2: ()
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1166:4: 
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1169:1: pinSlices[List<Integer> slices, String pinName, DesignNode des, String instName] : ;
    public final void pinSlices(List<Integer> slices, String pinName, DesignNode des, String instName) throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1173:2: ()
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1173:4: 
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1179:1: netSlices[List<Integer> slices, String netName, DesignNode des] : ;
    public final void netSlices(List<Integer> slices, String netName, DesignNode des) throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1180:2: ()
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1180:4: 
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1185:1: concatSlices[List<Integer> slices, String netName, DesignNode des] : ;
    public final void concatSlices(List<Integer> slices, String netName, DesignNode des) throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1186:2: ()
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1186:4: 
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1189:1: arrayList[List<Integer> indices] : ( ^( COMMA LEFTPAREN first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTPAREN first= INTEGER last= INTEGER ) | ( LEFTPAREN single= INTEGER ) );
    public final void arrayList(List<Integer> indices) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;
        CommonTree last=null;
        CommonTree single=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1200:2: ( ^( COMMA LEFTPAREN first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTPAREN first= INTEGER last= INTEGER ) | ( LEFTPAREN single= INTEGER ) )
            int alt26=3;
            switch ( input.LA(1) ) {
            case COMMA:
                {
                alt26=1;
                }
                break;
            case COLON:
                {
                alt26=2;
                }
                break;
            case LEFTPAREN:
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1201:3: ^( COMMA LEFTPAREN first= INTEGER (next= INTEGER )* )
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_arrayList1345); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList1347); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1351); 
                    indices.add(Integer.parseInt((first!=null?first.getText():null)));
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1202:8: (next= INTEGER )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==INTEGER) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1202:9: next= INTEGER
                    	    {
                    	    next=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1366); 
                    	    indices.add(Integer.parseInt((next!=null?next.getText():null)));

                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1205:5: ^( COLON LEFTPAREN first= INTEGER last= INTEGER )
                    {
                    match(input,COLON,FOLLOW_COLON_in_arrayList1401); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList1403); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1407); 
                    last=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1411); 
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1223:4: ( LEFTPAREN single= INTEGER )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1223:4: ( LEFTPAREN single= INTEGER )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1223:5: LEFTPAREN single= INTEGER
                    {
                    match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_arrayList1444); 
                    single=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList1448); 
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1226:1: sliceList[List<Integer> slices] : ( ^( COMMA LEFTBRACKET first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTBRACKET first= INTEGER last= INTEGER ) | ( LEFTBRACKET single= INTEGER ) );
    public final void sliceList(List<Integer> slices) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;
        CommonTree last=null;
        CommonTree single=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1237:2: ( ^( COMMA LEFTBRACKET first= INTEGER (next= INTEGER )* ) | ^( COLON LEFTBRACKET first= INTEGER last= INTEGER ) | ( LEFTBRACKET single= INTEGER ) )
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
            case LEFTBRACKET:
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1238:3: ^( COMMA LEFTBRACKET first= INTEGER (next= INTEGER )* )
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_sliceList1475); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList1477); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1481); 
                    slices.add(Integer.parseInt((first!=null?first.getText():null)));
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1239:8: (next= INTEGER )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==INTEGER) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1239:9: next= INTEGER
                    	    {
                    	    next=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1497); 
                    	    slices.add(Integer.parseInt((next!=null?next.getText():null)));

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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1242:4: ^( COLON LEFTBRACKET first= INTEGER last= INTEGER )
                    {
                    match(input,COLON,FOLLOW_COLON_in_sliceList1532); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList1534); 
                    first=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1538); 
                    last=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1542); 
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1262:4: ( LEFTBRACKET single= INTEGER )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1262:4: ( LEFTBRACKET single= INTEGER )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1262:5: LEFTBRACKET single= INTEGER
                    {
                    match(input,LEFTBRACKET,FOLLOW_LEFTBRACKET_in_sliceList1574); 
                    single=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList1578); 
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1266:1: pinList[List<String> pList] : first= ( INTEGER | IDENT ) (next= ( INTEGER | IDENT ) )* ;
    public final void pinList(List<String> pList) throws RecognitionException {
        CommonTree first=null;
        CommonTree next=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1277:2: (first= ( INTEGER | IDENT ) (next= ( INTEGER | IDENT ) )* )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1277:4: first= ( INTEGER | IDENT ) (next= ( INTEGER | IDENT ) )*
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
            			
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1288:7: (next= ( INTEGER | IDENT ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==IDENT||LA29_0==INTEGER) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlASTold.g:1288:8: next= ( INTEGER | IDENT )
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
            	    break loop29;
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


    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA11_eotS =
        "\32\uffff";
    static final String DFA11_eofS =
        "\32\uffff";
    static final String DFA11_minS =
        "\1\3\1\uffff\1\2\1\uffff\1\4\1\uffff\1\2\1\4\1\44\1\uffff\1\3\2"+
        "\2\1\21\1\4\2\13\1\3\2\21\1\3\1\21\4\3";
    static final String DFA11_maxS =
        "\1\47\1\uffff\1\2\1\uffff\1\45\1\uffff\1\2\1\51\1\52\1\uffff\1"+
        "\23\2\2\1\21\1\4\2\13\1\3\5\21\3\3";
    static final String DFA11_acceptS =
        "\1\uffff\1\4\1\uffff\1\3\1\uffff\1\1\3\uffff\1\2\20\uffff";
    static final String DFA11_specialS =
        "\32\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\1\4\uffff\1\2\36\uffff\1\3",
            "",
            "\1\4",
            "",
            "\1\7\10\uffff\1\6\27\uffff\1\5",
            "",
            "\1\10",
            "\1\11\4\uffff\1\5\1\11\4\uffff\1\11\2\uffff\2\11\25\uffff"+
            "\1\11",
            "\1\11\5\uffff\1\12",
            "",
            "\1\16\6\uffff\1\13\1\15\7\uffff\1\14",
            "\1\17",
            "\1\20",
            "\1\21",
            "\1\7",
            "\1\22",
            "\1\23",
            "\1\16",
            "\1\24",
            "\1\25",
            "\1\27\15\uffff\1\26",
            "\1\30",
            "\1\27\15\uffff\1\26",
            "\1\16",
            "\1\31",
            "\1\16"
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "()* loopback of 759:3: ( attrAssign[des, $instName.text] | pinAssign[des, $instName.text] | infoStruct )*";
        }
    }
 

    public static final BitSet FOLLOW_designDecl_in_sourceText61 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_designDecl76 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_designDecl80 = new BitSet(new long[]{0x0000018B20000108L});
    public static final BitSet FOLLOW_deviceDecl_in_designDecl105 = new BitSet(new long[]{0x0000018B20000108L});
    public static final BitSet FOLLOW_netDecl_in_designDecl110 = new BitSet(new long[]{0x0000018B20000108L});
    public static final BitSet FOLLOW_infoStruct_in_designDecl115 = new BitSet(new long[]{0x0000018B20000108L});
    public static final BitSet FOLLOW_instDecl_in_designDecl121 = new BitSet(new long[]{0x0000018B20000108L});
    public static final BitSet FOLLOW_netAssign_in_designDecl126 = new BitSet(new long[]{0x0000018B20000108L});
    public static final BitSet FOLLOW_groupStruct_in_designDecl131 = new BitSet(new long[]{0x0000018B20000108L});
    public static final BitSet FOLLOW_subDesignInstance_in_designDecl136 = new BitSet(new long[]{0x0000018B20000108L});
    public static final BitSet FOLLOW_35_in_subDesignInstance172 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arrayList_in_subDesignInstance210 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_subDesignInstance216 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_subDesignInstance220 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_39_in_infoStruct268 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_infoStruct272 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_40_in_groupStruct290 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_groupStruct294 = new BitSet(new long[]{0x0000000200000108L});
    public static final BitSet FOLLOW_instDecl_in_groupStruct297 = new BitSet(new long[]{0x0000000200000108L});
    public static final BitSet FOLLOW_netAssign_in_groupStruct302 = new BitSet(new long[]{0x0000000200000108L});
    public static final BitSet FOLLOW_29_in_deviceDecl323 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl327 = new BitSet(new long[]{0x00000000C0000008L});
    public static final BitSet FOLLOW_attributeDecl_in_deviceDecl354 = new BitSet(new long[]{0x00000000C0000008L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl359 = new BitSet(new long[]{0x00000000C0000008L});
    public static final BitSet FOLLOW_30_in_attributeDecl394 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_attributeDecl398 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_STRING_in_attributeDecl402 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_31_in_pinDecl439 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_sliceList_in_pinDecl461 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl467 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_pinList_in_pinDecl469 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_32_in_netDecl503 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_sliceList_in_netDecl526 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl538 = new BitSet(new long[]{0x0000000040000408L});
    public static final BitSet FOLLOW_COMMA_in_netDecl568 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl572 = new BitSet(new long[]{0x0000000040000408L});
    public static final BitSet FOLLOW_attributeDecl_in_netDecl602 = new BitSet(new long[]{0x0000000040000008L});
    public static final BitSet FOLLOW_33_in_instDecl637 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arrayList_in_instDecl659 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instDecl665 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instDecl669 = new BitSet(new long[]{0x0000008000000108L});
    public static final BitSet FOLLOW_attrAssign_in_instDecl694 = new BitSet(new long[]{0x0000008000000108L});
    public static final BitSet FOLLOW_pinAssign_in_instDecl699 = new BitSet(new long[]{0x0000008000000108L});
    public static final BitSet FOLLOW_infoStruct_in_instDecl704 = new BitSet(new long[]{0x0000008000000108L});
    public static final BitSet FOLLOW_EQUALS_in_attrAssign741 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_37_in_attrAssign765 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_attributeQualifier_in_attrAssign775 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_arrayIndices_in_attrAssign780 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attrAssign788 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_STRING_in_attrAssign792 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssign823 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_pinQualifier_in_pinAssign858 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_arrayIndices_in_pinAssign865 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinAssign876 = new BitSet(new long[]{0x00000200000C8410L});
    public static final BitSet FOLLOW_sliceList_in_pinAssign879 = new BitSet(new long[]{0x00000200000C8410L});
    public static final BitSet FOLLOW_pinSlices_in_pinAssign884 = new BitSet(new long[]{0x00000200000C8410L});
    public static final BitSet FOLLOW_concatenation_in_pinAssign902 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUALS_in_netAssign934 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_netAssign958 = new BitSet(new long[]{0x00000200000C8410L});
    public static final BitSet FOLLOW_sliceList_in_netAssign961 = new BitSet(new long[]{0x00000200000C8410L});
    public static final BitSet FOLLOW_netSlices_in_netAssign966 = new BitSet(new long[]{0x00000200000C8410L});
    public static final BitSet FOLLOW_concatenation_in_netAssign972 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENT_in_concatenation1024 = new BitSet(new long[]{0x00000000000C0410L});
    public static final BitSet FOLLOW_sliceList_in_concatenation1027 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_concatSlices_in_concatenation1032 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_IDENT_in_concatenation1063 = new BitSet(new long[]{0x00000000000C0410L});
    public static final BitSet FOLLOW_sliceList_in_concatenation1087 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_concatSlices_in_concatenation1092 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_LEFTANGLE_in_concatenation1126 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation1130 = new BitSet(new long[]{0x00000000000C0400L});
    public static final BitSet FOLLOW_sliceList_in_concatenation1133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_concatSlices_in_concatenation1138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_concatenation1170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_attributeQualifier1208 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_42_in_attributeQualifier1210 = new BitSet(new long[]{0x0000000000080C08L});
    public static final BitSet FOLLOW_arrayList_in_attributeQualifier1213 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_arrayIndices_in_attributeQualifier1218 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERIOD_in_pinQualifier1248 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_42_in_pinQualifier1251 = new BitSet(new long[]{0x0000000000080C08L});
    public static final BitSet FOLLOW_36_in_pinQualifier1255 = new BitSet(new long[]{0x0000000000080C08L});
    public static final BitSet FOLLOW_arrayList_in_pinQualifier1264 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_arrayIndices_in_pinQualifier1269 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMMA_in_arrayList1345 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList1347 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1351 = new BitSet(new long[]{0x0000000000020008L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1366 = new BitSet(new long[]{0x0000000000020008L});
    public static final BitSet FOLLOW_COLON_in_arrayList1401 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList1403 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1407 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1411 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LEFTPAREN_in_arrayList1444 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList1448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_sliceList1475 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList1477 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1481 = new BitSet(new long[]{0x0000000000020008L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1497 = new BitSet(new long[]{0x0000000000020008L});
    public static final BitSet FOLLOW_COLON_in_sliceList1532 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList1534 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1538 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1542 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LEFTBRACKET_in_sliceList1574 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList1578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_pinList1604 = new BitSet(new long[]{0x0000000000020012L});
    public static final BitSet FOLLOW_set_in_pinList1639 = new BitSet(new long[]{0x0000000000020012L});

}