// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g 2011-12-23 16:28:54

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
public class PhdlWalker2 extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SEMICOLON", "COLON", "COMMA", "PERIOD", "EQUALS", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "LANGLE", "RANGLE", "AMPERSAND", "DBLQUOTE", "DESIGN", "DEVICE", "SUBDESIGN", "INST", "SUBINST", "GROUP", "THIS", "OF", "NET", "ATTR", "NEWATTR", "BEGIN", "END", "COMBINE", "INCLUDE", "PIN", "INPIN", "OUTPIN", "IOPIN", "PWRPIN", "SUPPIN", "WIDTH_DECL", "DEVICE_DECL", "ATTR_DECL", "PIN_DECL", "PIN_LIST", "PIN_TYPE", "IDENT", "STRING", "INT", "D", "E", "S", "I", "G", "N", "V", "C", "U", "B", "T", "R", "O", "P", "H", "F", "A", "W", "M", "L", "DIGIT", "CHAR", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "INCLUDE_DECL", "J", "K", "Q", "X", "Y", "Z", "ID"
    };
    public static final int EOF=-1;
    public static final int SEMICOLON=4;
    public static final int COLON=5;
    public static final int COMMA=6;
    public static final int PERIOD=7;
    public static final int EQUALS=8;
    public static final int LPAREN=9;
    public static final int RPAREN=10;
    public static final int LBRACKET=11;
    public static final int RBRACKET=12;
    public static final int LBRACE=13;
    public static final int RBRACE=14;
    public static final int LANGLE=15;
    public static final int RANGLE=16;
    public static final int AMPERSAND=17;
    public static final int DBLQUOTE=18;
    public static final int DESIGN=19;
    public static final int DEVICE=20;
    public static final int SUBDESIGN=21;
    public static final int INST=22;
    public static final int SUBINST=23;
    public static final int GROUP=24;
    public static final int THIS=25;
    public static final int OF=26;
    public static final int NET=27;
    public static final int ATTR=28;
    public static final int NEWATTR=29;
    public static final int BEGIN=30;
    public static final int END=31;
    public static final int COMBINE=32;
    public static final int INCLUDE=33;
    public static final int PIN=34;
    public static final int INPIN=35;
    public static final int OUTPIN=36;
    public static final int IOPIN=37;
    public static final int PWRPIN=38;
    public static final int SUPPIN=39;
    public static final int WIDTH_DECL=40;
    public static final int DEVICE_DECL=41;
    public static final int ATTR_DECL=42;
    public static final int PIN_DECL=43;
    public static final int PIN_LIST=44;
    public static final int PIN_TYPE=45;
    public static final int IDENT=46;
    public static final int STRING=47;
    public static final int INT=48;
    public static final int D=49;
    public static final int E=50;
    public static final int S=51;
    public static final int I=52;
    public static final int G=53;
    public static final int N=54;
    public static final int V=55;
    public static final int C=56;
    public static final int U=57;
    public static final int B=58;
    public static final int T=59;
    public static final int R=60;
    public static final int O=61;
    public static final int P=62;
    public static final int H=63;
    public static final int F=64;
    public static final int A=65;
    public static final int W=66;
    public static final int M=67;
    public static final int L=68;
    public static final int DIGIT=69;
    public static final int CHAR=70;
    public static final int WHITESPACE=71;
    public static final int LINE_COMMENT=72;
    public static final int MULTILINE_COMMENT=73;
    public static final int INCLUDE_DECL=74;
    public static final int J=75;
    public static final int K=76;
    public static final int Q=77;
    public static final int X=78;
    public static final int Y=79;
    public static final int Z=80;
    public static final int ID=81;

    // delegates
    // delegators


        public PhdlWalker2(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public PhdlWalker2(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PhdlWalker2.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g"; }



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
    			if (d.getName().equals(name))
    				return d;
    		}
    		return null;
    	}
    	
    	/**
    	 * The set of all Devices is global to the project build
    	 */
    	private Set<DeviceNode> devices = new HashSet<DeviceNode>();
    	
    	public Set<DeviceNode> getDevices() {
    		return devices;
    	}
    	
    	public void setDevices(Set<DeviceNode> devices) {
    		this.devices = devices;
    	}
    	
    	private Set<SubDesignNode> designs = new HashSet<SubDesignNode>();
    	
    	/**
    	 * Sets to check for duplicates while processing everything
    	 */
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
    	 * Reports an error from a Node object and exits
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:221:1: sourceText : ( deviceDecl )+ ;
    public final void sourceText() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:222:2: ( ( deviceDecl )+ )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:222:4: ( deviceDecl )+
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:222:4: ( deviceDecl )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==DEVICE_DECL) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:222:5: deviceDecl
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_sourceText60);
            	    deviceDecl();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
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


    // $ANTLR start "deviceDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:225:1: deviceDecl : ^( DEVICE_DECL devName= ID ( attrDecl[dev] )* ( pinDecl[dev] )* ) ;
    public final void deviceDecl() throws RecognitionException {
        CommonTree devName=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:226:2: ( ^( DEVICE_DECL devName= ID ( attrDecl[dev] )* ( pinDecl[dev] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:226:4: ^( DEVICE_DECL devName= ID ( attrDecl[dev] )* ( pinDecl[dev] )* )
            {
            match(input,DEVICE_DECL,FOLLOW_DEVICE_DECL_in_deviceDecl75); 

            match(input, Token.DOWN, null); 
            devName=(CommonTree)match(input,ID,FOLLOW_ID_in_deviceDecl79); 
            	// make a new device node
            			DeviceNode dev = new DeviceNode((devName!=null?devName.getText():null));
            			dev.setLocation((devName!=null?devName.getLine():0), (devName!=null?devName.getCharPositionInLine():0), 
            					devName.getToken().getInputStream().getSourceName());
            					
            			if (!devices.add(dev)) 
            				addError(dev, "Duplicate device declaration");
            			
            			// clear these sets each time a device is processed
            			pinDecls.clear();
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:240:3: ( attrDecl[dev] )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==ATTR_DECL) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:240:3: attrDecl[dev]
            	    {
            	    pushFollow(FOLLOW_attrDecl_in_deviceDecl92);
            	    attrDecl(dev);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            	// report any missing required attributes
            			for (String s : reqAttrs) {
            				s = s.toUpperCase();
            				if (dev.getAttribute(s) == null)
            					addError(devName, "required attribute \"" + s + "\" missing in device");
            			}
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:250:3: ( pinDecl[dev] )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==PIN_DECL) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:250:3: pinDecl[dev]
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl109);
            	    pinDecl(dev);

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
    // $ANTLR end "deviceDecl"


    // $ANTLR start "attrDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:253:1: attrDecl[Attributable parent] : ^( ATTR_DECL attrName= IDENT attrValue= STRING ) ;
    public final void attrDecl(Attributable parent) throws RecognitionException {
        CommonTree attrName=null;
        CommonTree attrValue=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:254:2: ( ^( ATTR_DECL attrName= IDENT attrValue= STRING ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:254:4: ^( ATTR_DECL attrName= IDENT attrValue= STRING )
            {
            match(input,ATTR_DECL,FOLLOW_ATTR_DECL_in_attrDecl126); 

            match(input, Token.DOWN, null); 
            attrName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attrDecl130); 
            attrValue=(CommonTree)match(input,STRING,FOLLOW_STRING_in_attrDecl134); 

            match(input, Token.UP, null); 
            	// make a new attribute node, assign its parent, and log its location
            	   		AttributeNode a  = new AttributeNode(parent);
            	   		a.setName((attrName!=null?attrName.getText():null));
            			a.setValue((attrValue!=null?attrValue.getText():null));
            	   		a.setLocation((attrName!=null?attrName.getLine():0), (attrName!=null?attrName.getCharPositionInLine():0), 
            	   			attrName.getToken().getInputStream().getSourceName());
            	   			
            	   		// check for duplicate attributes while adding
            			if (!parent.addAttribute(a));
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
    // $ANTLR end "attrDecl"


    // $ANTLR start "pinDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:276:1: pinDecl[DeviceNode dev] : ^( PIN_DECL pinName= IDENT ( ( widthDecl )? ) pinList[pList] pinType ) ;
    public final void pinDecl(DeviceNode dev) throws RecognitionException {
        CommonTree pinName=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:277:2: ( ^( PIN_DECL pinName= IDENT ( ( widthDecl )? ) pinList[pList] pinType ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:277:4: ^( PIN_DECL pinName= IDENT ( ( widthDecl )? ) pinList[pList] pinType )
            {
            List<String> pList = new ArrayList<String>();
            boolean width = false;
            match(input,PIN_DECL,FOLLOW_PIN_DECL_in_pinDecl166); 

            match(input, Token.DOWN, null); 
            pinName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinDecl170); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:280:28: ( ( widthDecl )? )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:280:29: ( widthDecl )?
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:280:29: ( widthDecl )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==WIDTH_DECL) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:280:29: widthDecl
                    {
                    pushFollow(FOLLOW_widthDecl_in_pinDecl173);
                    widthDecl();

                    state._fsp--;


                    }
                    break;

            }

            width = true;

            }

            pushFollow(FOLLOW_pinList_in_pinDecl184);
            pinList(pList);

            state._fsp--;

            pushFollow(FOLLOW_pinType_in_pinDecl187);
            pinType();

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

    public static class widthDecl_return extends TreeRuleReturnScope {
        public int msb;
        public int lsb;
    };

    // $ANTLR start "widthDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:285:1: widthDecl returns [int msb, int lsb] : ^( WIDTH_DECL val1= INT val2= INT ) ;
    public final PhdlWalker2.widthDecl_return widthDecl() throws RecognitionException {
        PhdlWalker2.widthDecl_return retval = new PhdlWalker2.widthDecl_return();
        retval.start = input.LT(1);

        CommonTree val1=null;
        CommonTree val2=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:286:2: ( ^( WIDTH_DECL val1= INT val2= INT ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:286:4: ^( WIDTH_DECL val1= INT val2= INT )
            {
            match(input,WIDTH_DECL,FOLLOW_WIDTH_DECL_in_widthDecl205); 

            match(input, Token.DOWN, null); 
            val1=(CommonTree)match(input,INT,FOLLOW_INT_in_widthDecl209); 
            val2=(CommonTree)match(input,INT,FOLLOW_INT_in_widthDecl213); 

            match(input, Token.UP, null); 
            	retval.msb = Integer.parseInt((val1!=null?val1.getText():null));
            			retval.lsb = Integer.parseInt((val2!=null?val2.getText():null));
            		

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "widthDecl"


    // $ANTLR start "pinList"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:292:1: pinList[List<String> pList] : ^( PIN_LIST (num1= INT | num2= IDENT )+ ) ;
    public final void pinList(List<String> pList) throws RecognitionException {
        CommonTree num1=null;
        CommonTree num2=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:293:2: ( ^( PIN_LIST (num1= INT | num2= IDENT )+ ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:293:4: ^( PIN_LIST (num1= INT | num2= IDENT )+ )
            {
            match(input,PIN_LIST,FOLLOW_PIN_LIST_in_pinList231); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:294:2: (num1= INT | num2= IDENT )+
            int cnt5=0;
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==INT) ) {
                    alt5=1;
                }
                else if ( (LA5_0==IDENT) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:294:4: num1= INT
            	    {
            	    num1=(CommonTree)match(input,INT,FOLLOW_INT_in_pinList238); 
            	    pList.add((num1!=null?num1.getText():null));

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:295:4: num2= IDENT
            	    {
            	    num2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinList247); 
            	    pList.add((num2!=null?num2.getText():null));

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
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
    // $ANTLR end "pinList"


    // $ANTLR start "pinType"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:299:1: pinType returns [PinType type] : ^( PIN_TYPE ( PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN ) ) ;
    public final PinType pinType() throws RecognitionException {
        PinType type = null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:300:2: ( ^( PIN_TYPE ( PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN ) ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:300:4: ^( PIN_TYPE ( PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN ) )
            {
            match(input,PIN_TYPE,FOLLOW_PIN_TYPE_in_pinType271); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:301:2: ( PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN )
            int alt6=6;
            switch ( input.LA(1) ) {
            case PIN:
                {
                alt6=1;
                }
                break;
            case INPIN:
                {
                alt6=2;
                }
                break;
            case OUTPIN:
                {
                alt6=3;
                }
                break;
            case IOPIN:
                {
                alt6=4;
                }
                break;
            case PWRPIN:
                {
                alt6=5;
                }
                break;
            case SUPPIN:
                {
                alt6=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:301:4: PIN
                    {
                    match(input,PIN,FOLLOW_PIN_in_pinType277); 
                    type = PinType.PIN;

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:302:4: INPIN
                    {
                    match(input,INPIN,FOLLOW_INPIN_in_pinType285); 
                    type = PinType.INPIN;

                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:303:4: OUTPIN
                    {
                    match(input,OUTPIN,FOLLOW_OUTPIN_in_pinType292); 
                    type = PinType.OUTPIN;

                    }
                    break;
                case 4 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:304:4: IOPIN
                    {
                    match(input,IOPIN,FOLLOW_IOPIN_in_pinType299); 
                    type = PinType.IOPIN;

                    }
                    break;
                case 5 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:305:4: PWRPIN
                    {
                    match(input,PWRPIN,FOLLOW_PWRPIN_in_pinType306); 
                    type = PinType.PWRPIN;

                    }
                    break;
                case 6 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:306:4: SUPPIN
                    {
                    match(input,SUPPIN,FOLLOW_SUPPIN_in_pinType313); 
                    type = PinType.SUPPIN;

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
        return type;
    }
    // $ANTLR end "pinType"

    // Delegated rules


 

    public static final BitSet FOLLOW_deviceDecl_in_sourceText60 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_DEVICE_DECL_in_deviceDecl75 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_deviceDecl79 = new BitSet(new long[]{0x00000C0000000008L});
    public static final BitSet FOLLOW_attrDecl_in_deviceDecl92 = new BitSet(new long[]{0x00000C0000000008L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl109 = new BitSet(new long[]{0x0000080000000008L});
    public static final BitSet FOLLOW_ATTR_DECL_in_attrDecl126 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_attrDecl130 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_STRING_in_attrDecl134 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PIN_DECL_in_pinDecl166 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl170 = new BitSet(new long[]{0x0000110000000000L});
    public static final BitSet FOLLOW_widthDecl_in_pinDecl173 = new BitSet(new long[]{0x0000110000000000L});
    public static final BitSet FOLLOW_pinList_in_pinDecl184 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_pinType_in_pinDecl187 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WIDTH_DECL_in_widthDecl205 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_widthDecl209 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_INT_in_widthDecl213 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PIN_LIST_in_pinList231 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_pinList238 = new BitSet(new long[]{0x0001400000000008L});
    public static final BitSet FOLLOW_IDENT_in_pinList247 = new BitSet(new long[]{0x0001400000000008L});
    public static final BitSet FOLLOW_PIN_TYPE_in_pinType271 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PIN_in_pinType277 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INPIN_in_pinType285 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OUTPIN_in_pinType292 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IOPIN_in_pinType299 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PWRPIN_in_pinType306 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SUPPIN_in_pinType313 = new BitSet(new long[]{0x0000000000000008L});

}