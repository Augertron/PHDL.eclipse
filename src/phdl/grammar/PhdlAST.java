// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g 2012-01-09 01:25:05

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
public class PhdlAST extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SEMICOLON", "COLON", "COMMA", "PERIOD", "EQUALS", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "LANGLE", "RANGLE", "AMPERSAND", "DBLQUOTE", "DESIGN", "DEVICE", "SUBDESIGN", "INST", "SUBINST", "GROUP", "THIS", "OF", "NET", "ATTR", "NEWATTR", "BEGIN", "END", "COMBINE", "INCLUDE", "INFO", "PORT", "PIN", "INPIN", "OUTPIN", "IOPIN", "PWRPIN", "SUPPIN", "DESIGN_DECL", "DEVICE_DECL", "WIDTH_DECL", "NET_DECL", "GROUP_DECL", "INST_DECL", "ATTR_DECL", "PIN_DECL", "PORT_DECL", "INDEX_DECL", "SUBINST_DECL", "SUBATTR_ASSIGN", "PIN_LIST", "PIN_TYPE", "INFO_DECL", "ATTR_ASSIGN", "PIN_ASSIGN", "NET_ASSIGN", "PORT_ASSIGN", "ATTR_QUAL", "BOUNDS", "INDICES", "OPERAND", "NAME", "CONCAT_LIST", "CONCAT_REPL", "OPEN", "IDENT", "STRING", "INT", "PINNUM", "SUB", "D", "E", "S", "I", "G", "N", "V", "C", "U", "B", "T", "R", "O", "P", "H", "F", "A", "W", "M", "L", "CHAR", "DIGIT", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "INCLUDE_DECL", "J", "K", "Q", "X", "Y", "Z"
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
    public static final int INFO=34;
    public static final int PORT=35;
    public static final int PIN=36;
    public static final int INPIN=37;
    public static final int OUTPIN=38;
    public static final int IOPIN=39;
    public static final int PWRPIN=40;
    public static final int SUPPIN=41;
    public static final int DESIGN_DECL=42;
    public static final int DEVICE_DECL=43;
    public static final int WIDTH_DECL=44;
    public static final int NET_DECL=45;
    public static final int GROUP_DECL=46;
    public static final int INST_DECL=47;
    public static final int ATTR_DECL=48;
    public static final int PIN_DECL=49;
    public static final int PORT_DECL=50;
    public static final int INDEX_DECL=51;
    public static final int SUBINST_DECL=52;
    public static final int SUBATTR_ASSIGN=53;
    public static final int PIN_LIST=54;
    public static final int PIN_TYPE=55;
    public static final int INFO_DECL=56;
    public static final int ATTR_ASSIGN=57;
    public static final int PIN_ASSIGN=58;
    public static final int NET_ASSIGN=59;
    public static final int PORT_ASSIGN=60;
    public static final int ATTR_QUAL=61;
    public static final int BOUNDS=62;
    public static final int INDICES=63;
    public static final int OPERAND=64;
    public static final int NAME=65;
    public static final int CONCAT_LIST=66;
    public static final int CONCAT_REPL=67;
    public static final int OPEN=68;
    public static final int IDENT=69;
    public static final int STRING=70;
    public static final int INT=71;
    public static final int PINNUM=72;
    public static final int SUB=73;
    public static final int D=74;
    public static final int E=75;
    public static final int S=76;
    public static final int I=77;
    public static final int G=78;
    public static final int N=79;
    public static final int V=80;
    public static final int C=81;
    public static final int U=82;
    public static final int B=83;
    public static final int T=84;
    public static final int R=85;
    public static final int O=86;
    public static final int P=87;
    public static final int H=88;
    public static final int F=89;
    public static final int A=90;
    public static final int W=91;
    public static final int M=92;
    public static final int L=93;
    public static final int CHAR=94;
    public static final int DIGIT=95;
    public static final int WHITESPACE=96;
    public static final int LINE_COMMENT=97;
    public static final int MULTILINE_COMMENT=98;
    public static final int INCLUDE_DECL=99;
    public static final int J=100;
    public static final int K=101;
    public static final int Q=102;
    public static final int X=103;
    public static final int Y=104;
    public static final int Z=105;

    // delegates
    // delegators


        public PhdlAST(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public PhdlAST(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PhdlAST.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g"; }



    	/** The set of required attributes */
    	private Set<String> reqAttrs = new HashSet<String>();
    	/** The list of errors */
    	private List<String> errors = new ArrayList<String>();
    	/** The list of warnings */
    	private List<String> warnings = new ArrayList<String>();
    	/** * The set of processed design nodes  */
    	private Set<Design> designs = new HashSet<Design>();
    	/** The set of all Devices is global to the project build */
    	private Set<Device> devices = new HashSet<Device>();
    	/** Sets to check for duplicates while processing everything */
    	private Set<String> pinNames = new HashSet<String>();
    	private Set<String> netNames = new HashSet<String>();
    	private Set<String> instNames = new HashSet<String>();
    	
    	private Set<SubDesign> subDesigns = new HashSet<SubDesign>();
    	
    	public Design getDesign(String name) {
    		for (Design d : designs) {
    			if (d.getName().equals(name))
    				return d;
    		}
    		return null;
    	}
    	
    	public Set<Device> getDevices() {
    		return devices;
    	}
    	
    	public void setDevices(Set<Device> devices) {
    		this.devices = devices;
    	}
    	
    	public Device getDevice(String name) {
    		for (Device d : devices) {
    			if (d.getName().equals(name))
    				return d;
    		}
    		return null;
    	}
    		
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
    	public Set<Design> getDesigns() {
    		return designs;
    	}
    	
    	/**
    	 * Called on the walker object to pass in a set of required attributes
    	 */
    	public void setRequiredAttributes(Set<String> reqAttrs) {
    		this.reqAttrs.addAll(reqAttrs);
    	}
    	
    	private void setLocation(Node n, CommonTree ct) {
    		n.setLocation(ct.getLine(), ct.getCharPositionInLine(), 
    			ct.getToken().getInputStream().getSourceName());
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:218:1: sourceText : ( deviceDecl | designDecl )+ ;
    public final void sourceText() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:219:2: ( ( deviceDecl | designDecl )+ )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:219:4: ( deviceDecl | designDecl )+
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:219:4: ( deviceDecl | designDecl )+
            int cnt1=0;
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==DEVICE_DECL) ) {
                    alt1=1;
                }
                else if ( (LA1_0==DESIGN_DECL) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:219:5: deviceDecl
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_sourceText60);
            	    deviceDecl();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:219:18: designDecl
            	    {
            	    pushFollow(FOLLOW_designDecl_in_sourceText64);
            	    designDecl();

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:222:1: deviceDecl : ^( DEVICE_DECL devName= IDENT ( infoDecl )* ( attrDecl[devs] )* ( pinDecl[dev] )* ) ;
    public final void deviceDecl() throws RecognitionException {
        CommonTree devName=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:223:2: ( ^( DEVICE_DECL devName= IDENT ( infoDecl )* ( attrDecl[devs] )* ( pinDecl[dev] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:223:4: ^( DEVICE_DECL devName= IDENT ( infoDecl )* ( attrDecl[devs] )* ( pinDecl[dev] )* )
            {
            match(input,DEVICE_DECL,FOLLOW_DEVICE_DECL_in_deviceDecl79); 

            match(input, Token.DOWN, null); 
            devName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl83); 
            	// make a new device node
            			Device dev = new Device((devName!=null?devName.getText():null));
            			setLocation(dev, devName);
            			// check for duplicate device declarations
            			if (!devices.add(dev)) 
            				addError(devName, "Duplicate device declaration");
            			
            			// create a list with only one device
            			List<Attributable> devs = new ArrayList<Attributable>();
            			devs.add(dev);
            			
            			// clear these sets each time a device is processed
            			pinNames.clear();
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:240:3: ( infoDecl )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==INFO_DECL) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:240:3: infoDecl
            	    {
            	    pushFollow(FOLLOW_infoDecl_in_deviceDecl96);
            	    infoDecl();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:240:13: ( attrDecl[devs] )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==ATTR_DECL) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:240:13: attrDecl[devs]
            	    {
            	    pushFollow(FOLLOW_attrDecl_in_deviceDecl99);
            	    attrDecl(devs);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:240:29: ( pinDecl[dev] )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==PIN_DECL) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:240:29: pinDecl[dev]
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl103);
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
            			for (String s : reqAttrs) {
            				if (dev.getAttribute(s) == null)
            					addError(devName, "required attribute \"" + s + "\" missing in device");
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
    // $ANTLR end "deviceDecl"


    // $ANTLR start "attrDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:250:1: attrDecl[List<Attributable> parents] : ^( ATTR_DECL attrName= IDENT attrValue= STRING ) ;
    public final void attrDecl(List<Attributable> parents) throws RecognitionException {
        CommonTree attrName=null;
        CommonTree attrValue=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:251:2: ( ^( ATTR_DECL attrName= IDENT attrValue= STRING ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:251:4: ^( ATTR_DECL attrName= IDENT attrValue= STRING )
            {
            match(input,ATTR_DECL,FOLLOW_ATTR_DECL_in_attrDecl128); 

            match(input, Token.DOWN, null); 
            attrName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attrDecl132); 
            attrValue=(CommonTree)match(input,STRING,FOLLOW_STRING_in_attrDecl136); 

            match(input, Token.UP, null); 
            	for (Attributable parent : parents) {
            				// make a new attribute node
            		   		Attribute a  = new Attribute(parent);
            		   		a.setName((attrName!=null?attrName.getText():null));
            				a.setValue((attrValue!=null?attrValue.getText():null));
            				setLocation(a, attrName);
            		   			
            		   		// check for duplicate attributes while adding
            				if (!parent.addAttribute(a))
            					addError(attrName, "duplicate attribute declaration");
            					
            				// check if the attribute is a refprefix attribute
            				if (a.getName().equals("REFPREFIX")) {
            					// check to see if refPrefix begins with a letter
            					if (!Pattern.compile("^[A-Z]").matcher(a.getValue()).find())
            						addError(attrName, "invalid refPrefix in device");
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
    // $ANTLR end "attrDecl"


    // $ANTLR start "pinDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:274:1: pinDecl[Device dev] : ^( PIN_DECL pinName= IDENT pinType ( widthDecl )? pinList ) ;
    public final void pinDecl(Device dev) throws RecognitionException {
        CommonTree pinName=null;
        PhdlAST.widthDecl_return widthDecl1 = null;

        List<String> pinList2 = null;

        PinType pinType3 = null;


        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:275:2: ( ^( PIN_DECL pinName= IDENT pinType ( widthDecl )? pinList ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:275:4: ^( PIN_DECL pinName= IDENT pinType ( widthDecl )? pinList )
            {
            boolean hasWidth = false;
            match(input,PIN_DECL,FOLLOW_PIN_DECL_in_pinDecl164); 

            match(input, Token.DOWN, null); 
            pinName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinDecl168); 
            pushFollow(FOLLOW_pinType_in_pinDecl170);
            pinType3=pinType();

            state._fsp--;

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:277:36: ( widthDecl )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==WIDTH_DECL) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:277:37: widthDecl
                    {
                    pushFollow(FOLLOW_widthDecl_in_pinDecl173);
                    widthDecl1=widthDecl();

                    state._fsp--;

                    hasWidth = true;

                    }
                    break;

            }

            pushFollow(FOLLOW_pinList_in_pinDecl179);
            pinList2=pinList();

            state._fsp--;


            match(input, Token.UP, null); 
            	// make a single pin if there is no width
            			if (!hasWidth || (widthDecl1!=null?widthDecl1.width:0) == 1) {
            				if (pinList2.size() != 1)
            					addError(pinName, "invalid pin list");
            				Pin p = new Pin(dev);
            				p.setName((pinName!=null?pinName.getText():null));
            				p.setPinType(pinType3);
            				setLocation(p, pinName);
            				if (hasWidth) p.setIndex((widthDecl1!=null?widthDecl1.msb:0));
            				// accessing the pinlist may throw an exception
            				try {
            					p.setPinMapping(pinList2.get(0));
            				} catch (IndexOutOfBoundsException e) {
            					addError(pinName, "invalid pin list");
            				}
            				// report any duplicate pin declarations
            				if (!dev.addPin(p))
            	           		addError(pinName, "duplicate pin declaration");
            			} else {
            				// make an array of pins based on the width parameters
            				if ((widthDecl1!=null?widthDecl1.width:0) != pinList2.size())
            					addError(pinName, "invalid pin list");
            				if ((widthDecl1!=null?widthDecl1.downto:false)) {
            					// make array of pins for msb > lsb
            					for (int i = (widthDecl1!=null?widthDecl1.msb:0); i >= (widthDecl1!=null?widthDecl1.lsb:0); i--) {
            						Pin p = new Pin(dev);
            						p.setName((pinName!=null?pinName.getText():null));
            						p.setPinType(pinType3);
            						setLocation(p, pinName);
            						p.setIndex(i);
            						// accessing the pinlist may throw an exception
            						try {
            							p.setPinMapping(pinList2.get((widthDecl1!=null?widthDecl1.msb:0) - i));
            						} catch (IndexOutOfBoundsException e) {
            							addError(pinName, "invalid pin list");
            						}
            						// report any duplicate pin declarations
            						if (!dev.addPin(p))
            			           		addError(pinName, "duplicate pin declaration");
            					}
            				} else {
            					// make array of pins for msb < lsb
            					for (int i = (widthDecl1!=null?widthDecl1.msb:0); i <= (widthDecl1!=null?widthDecl1.lsb:0); i++) {
            						Pin p = new Pin(dev);
            						p.setName((pinName!=null?pinName.getText():null));
            						p.setPinType(pinType3);
            						setLocation(p, pinName);
            						p.setIndex(i);
            						// accessing the pinlist may throw an exception
            						try {
            							p.setPinMapping(pinList2.get(i));
            						} catch (IndexOutOfBoundsException e) {
            							addError(pinName, "invalid pin list");
            						}
            						// report any duplicate pin declarations
            						if (!dev.addPin(p))
            			           		addError(pinName, "duplicate pin declaration");
            					}
            				}
            				// check for overall duplicates based solely on the name
            				if (!pinNames.add((pinName!=null?pinName.getText():null)))
            					addError(pinName, "duplicate pin declaration");
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
    // $ANTLR end "pinDecl"


    // $ANTLR start "designDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:345:1: designDecl : ^( DESIGN_DECL desName= IDENT ( infoDecl | netDecl[des] | instDecl[des, null] | netAssign[des] )* ) ;
    public final void designDecl() throws RecognitionException {
        CommonTree desName=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:346:2: ( ^( DESIGN_DECL desName= IDENT ( infoDecl | netDecl[des] | instDecl[des, null] | netAssign[des] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:346:4: ^( DESIGN_DECL desName= IDENT ( infoDecl | netDecl[des] | instDecl[des, null] | netAssign[des] )* )
            {
            match(input,DESIGN_DECL,FOLLOW_DESIGN_DECL_in_designDecl200); 

            match(input, Token.DOWN, null); 
            desName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_designDecl204); 
            	// make a new design based on the identifier and log its location
            			Design des = new Design();
            			des.setName((desName!=null?desName.getText():null));
            			setLocation(des, desName);
            			
            			netNames.clear();
            			instNames.clear();
            			designs.add(des);
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:356:2: ( infoDecl | netDecl[des] | instDecl[des, null] | netAssign[des] )*
            loop6:
            do {
                int alt6=5;
                switch ( input.LA(1) ) {
                case INFO_DECL:
                    {
                    alt6=1;
                    }
                    break;
                case NET_DECL:
                    {
                    alt6=2;
                    }
                    break;
                case INST_DECL:
                    {
                    alt6=3;
                    }
                    break;
                case NET_ASSIGN:
                    {
                    alt6=4;
                    }
                    break;

                }

                switch (alt6) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:356:4: infoDecl
            	    {
            	    pushFollow(FOLLOW_infoDecl_in_designDecl213);
            	    infoDecl();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:357:4: netDecl[des]
            	    {
            	    pushFollow(FOLLOW_netDecl_in_designDecl218);
            	    netDecl(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:358:4: instDecl[des, null]
            	    {
            	    pushFollow(FOLLOW_instDecl_in_designDecl224);
            	    instDecl(des, null);

            	    state._fsp--;


            	    }
            	    break;
            	case 4 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:359:4: netAssign[des]
            	    {
            	    pushFollow(FOLLOW_netAssign_in_designDecl230);
            	    netAssign(des);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
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
    // $ANTLR end "designDecl"


    // $ANTLR start "netDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:363:1: netDecl[Design des] : ^( NET_DECL ( widthDecl )? (netName= IDENT )* ( attrDecl[nets] )* ) ;
    public final void netDecl(Design des) throws RecognitionException {
        CommonTree netName=null;
        PhdlAST.widthDecl_return widthDecl4 = null;


        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:364:2: ( ^( NET_DECL ( widthDecl )? (netName= IDENT )* ( attrDecl[nets] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:364:4: ^( NET_DECL ( widthDecl )? (netName= IDENT )* ( attrDecl[nets] )* )
            {
            match(input,NET_DECL,FOLLOW_NET_DECL_in_netDecl250); 

            	boolean hasWidth = false;
            			List<Attributable> nets = new ArrayList<Attributable>();
            		

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:370:3: ( widthDecl )?
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==WIDTH_DECL) ) {
                    alt7=1;
                }
                switch (alt7) {
                    case 1 :
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:370:4: widthDecl
                        {
                        pushFollow(FOLLOW_widthDecl_in_netDecl263);
                        widthDecl4=widthDecl();

                        state._fsp--;

                        hasWidth = true;

                        }
                        break;

                }

                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:370:35: (netName= IDENT )*
                loop8:
                do {
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==IDENT) ) {
                        alt8=1;
                    }


                    switch (alt8) {
                	case 1 :
                	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:370:36: netName= IDENT
                	    {
                	    netName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netDecl272); 
                	    	// make new nets for each name
                	    				if (!hasWidth || (widthDecl4!=null?widthDecl4.width:0) == 1) {
                	    					Net n = new Net(des);
                	    					n.setName((netName!=null?netName.getText():null));
                	    					setLocation(n, netName);
                	    					if (hasWidth)
                	    						n.setIndex((widthDecl4!=null?widthDecl4.msb:0));
                	    					if (!des.addNet(n)) 
                	    						addError(netName, "duplicate net declaration");
                	    					nets.add(n);
                	    				} else if ((widthDecl4!=null?widthDecl4.downto:false)) {
                	    					for (int i = (widthDecl4!=null?widthDecl4.msb:0); i >= (widthDecl4!=null?widthDecl4.lsb:0); i--) {
                	    						Net n = new Net(des);
                	    						n.setName((netName!=null?netName.getText():null));
                	    						setLocation(n, netName);
                	    						n.setIndex(i);
                	    						if (!des.addNet(n)) 
                	    							addError(netName, "duplicate net declaration");
                	    						nets.add(n);
                	    					}
                	    				} else {
                	    					for (int i = (widthDecl4!=null?widthDecl4.msb:0); i <= (widthDecl4!=null?widthDecl4.lsb:0); i++) {
                	    						Net n = new Net(des);
                	    						n.setName((netName!=null?netName.getText():null));
                	    						setLocation(n, netName);
                	    						n.setIndex(i);
                	    						if (!des.addNet(n)) 
                	    							addError(netName, "duplicate net declaration");
                	    						nets.add(n);
                	    					}
                	    				}
                	    				// check for duplicates based soley on the name of the net
                	    				if (!netNames.add((netName!=null?netName.getText():null)))
                	    					addError(netName, "duplicate net declaration");
                	    			

                	    }
                	    break;

                	default :
                	    break loop8;
                    }
                } while (true);

                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:409:3: ( attrDecl[nets] )*
                loop9:
                do {
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==ATTR_DECL) ) {
                        alt9=1;
                    }


                    switch (alt9) {
                	case 1 :
                	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:409:3: attrDecl[nets]
                	    {
                	    pushFollow(FOLLOW_attrDecl_in_netDecl290);
                	    attrDecl(nets);

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:412:1: instDecl[Design des, String groupName] : ^( INST_DECL ( widthDecl )? instName= IDENT devName= IDENT ( infoDecl )* ( attrAssign[des, $instName.text] )* ( pinAssign[des, $instName.text] )* ) ;
    public final void instDecl(Design des, String groupName) throws RecognitionException {
        CommonTree instName=null;
        CommonTree devName=null;
        PhdlAST.widthDecl_return widthDecl5 = null;


        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:413:2: ( ^( INST_DECL ( widthDecl )? instName= IDENT devName= IDENT ( infoDecl )* ( attrAssign[des, $instName.text] )* ( pinAssign[des, $instName.text] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:413:4: ^( INST_DECL ( widthDecl )? instName= IDENT devName= IDENT ( infoDecl )* ( attrAssign[des, $instName.text] )* ( pinAssign[des, $instName.text] )* )
            {
            boolean hasWidth = false;
            match(input,INST_DECL,FOLLOW_INST_DECL_in_instDecl314); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:415:15: ( widthDecl )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==WIDTH_DECL) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:415:16: widthDecl
                    {
                    pushFollow(FOLLOW_widthDecl_in_instDecl317);
                    widthDecl5=widthDecl();

                    state._fsp--;

                    hasWidth = true;

                    }
                    break;

            }

            instName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl325); 
            devName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl329); 
            	Device dev = getDevice((devName!=null?devName.getText():null));
            			if (dev == null)
            				bailOut(instName, "instance references undeclared device");
            			if (!hasWidth || (widthDecl5!=null?widthDecl5.width:0) == 1) {
            				Instance i = new Instance(des);
            				i.setName((instName!=null?instName.getText():null));
            				i.setDevice(dev);
            				setLocation(i, instName);
            				i.setGroupName(groupName);
            				if (hasWidth)
            					i.setIndex((widthDecl5!=null?widthDecl5.msb:0));
            				// copy all of the attribute and pin nodes from the device
            				for (Attribute a: dev.getAttributes())
            					i.addAttribute(new Attribute(a, i));
            				for (Pin p: dev.getPins())
            					i.addPin(new Pin(p, i));
            				// check for duplicates
            				if (!des.addInstance(i))
            					addError(instName, "duplicate instance declaration");
            			} else if ((widthDecl5!=null?widthDecl5.downto:false)) {
            				for (int j = (widthDecl5!=null?widthDecl5.msb:0); j >= (widthDecl5!=null?widthDecl5.lsb:0); j--) {
            					Instance i = new Instance(des);
            					i.setName((instName!=null?instName.getText():null));
            					i.setDevice(dev);
            					setLocation(i, instName);
            					i.setGroupName(groupName);
            					i.setIndex(j);
            					// copy all of the attribute and pin nodes from the device
            					for (Attribute a: dev.getAttributes())
            						i.addAttribute(new Attribute(a, i));
            					for (Pin p: dev.getPins())
            						i.addPin(new Pin(p, i));
            					// check for duplicates
            					if (!des.addInstance(i))
            						addError(instName, "duplicate instance declaration");
            				}
            			} else {
            				for (int j = (widthDecl5!=null?widthDecl5.msb:0); j <= (widthDecl5!=null?widthDecl5.lsb:0); j++) {
            					Instance i = new Instance(des);
            					i.setName((instName!=null?instName.getText():null));
            					i.setDevice(dev);
            					setLocation(i, instName);
            					i.setGroupName(groupName);
            					i.setIndex(j);
            					// copy all of the attribute and pin nodes from the device
            					for (Attribute a: dev.getAttributes())
            						i.addAttribute(new Attribute(a, i));
            					for (Pin p: dev.getPins())
            						i.addPin(new Pin(p, i));
            					// check for duplicates
            					if (!des.addInstance(i))
            						addError(instName, "duplicate instance declaration");
            				}
            			}
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:473:3: ( infoDecl )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==INFO_DECL) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:473:3: infoDecl
            	    {
            	    pushFollow(FOLLOW_infoDecl_in_instDecl343);
            	    infoDecl();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:473:13: ( attrAssign[des, $instName.text] )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==ATTR_ASSIGN) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:473:13: attrAssign[des, $instName.text]
            	    {
            	    pushFollow(FOLLOW_attrAssign_in_instDecl346);
            	    attrAssign(des, (instName!=null?instName.getText():null));

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:473:46: ( pinAssign[des, $instName.text] )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==PIN_ASSIGN) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:473:46: pinAssign[des, $instName.text]
            	    {
            	    pushFollow(FOLLOW_pinAssign_in_instDecl350);
            	    pinAssign(des, (instName!=null?instName.getText():null));

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            match(input, Token.UP, null); 
            	// check for duplicates based solely on the raw instance name
            			if (!instNames.add((instName!=null?instName.getText():null)))
            				addError(instName, "duplicate instance declaration");
            		

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:481:1: attrAssign[Design des, String instName] : ^( ATTR_ASSIGN ( NEWATTR )? ( indexDecl )? name= IDENT value= STRING ) ;
    public final void attrAssign(Design des, String instName) throws RecognitionException {
        CommonTree name=null;
        CommonTree value=null;
        List<Integer> indexDecl6 = null;


        boolean newAttr = false; boolean hasList = false;
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:483:2: ( ^( ATTR_ASSIGN ( NEWATTR )? ( indexDecl )? name= IDENT value= STRING ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:483:4: ^( ATTR_ASSIGN ( NEWATTR )? ( indexDecl )? name= IDENT value= STRING )
            {
            match(input,ATTR_ASSIGN,FOLLOW_ATTR_ASSIGN_in_attrAssign378); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:483:18: ( NEWATTR )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==NEWATTR) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:483:19: NEWATTR
                    {
                    match(input,NEWATTR,FOLLOW_NEWATTR_in_attrAssign381); 
                    newAttr = true;

                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:483:47: ( indexDecl )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=BOUNDS && LA15_0<=INDICES)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:483:48: indexDecl
                    {
                    pushFollow(FOLLOW_indexDecl_in_attrAssign388);
                    indexDecl6=indexDecl();

                    state._fsp--;

                    hasList = true;

                    }
                    break;

            }

            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attrAssign396); 
            value=(CommonTree)match(input,STRING,FOLLOW_STRING_in_attrAssign400); 

            match(input, Token.UP, null); 
            	
            			List<Instance> instances = des.getInstances(instName);
            			
            			// reference only those instances in the list
            			if (hasList) {
            				// iterate over the indices in the array list declaration
            				for (Integer index : indexDecl6) {
            					// search for the instance with this index
            					Instance inst = null;
            					for (Instance i : instances)
            						if (index == i.getIndex()) inst = i;
            					
            					if (inst != null) {
            						Attribute a = inst.getAttribute((name!=null?name.getText():null));
            						if (a != null) {
            							if (newAttr)
            								addError(name, "new attribute already declared");
            							if (!a.overwrite((value!=null?value.getText():null)))
            								addWarning(name, "attribute already overwritten");
            						} else if (newAttr) {
            							Attribute newA = new Attribute(inst);
            							newA.setName((name!=null?name.getText():null));
            							newA.setValue((value!=null?value.getText():null));
            							setLocation(newA, name);
            							inst.addAttribute(newA);
            						} else
            							addError(name, "undeclared attribute");
            					// the instance referenced by the index doesn't exist
            					} else
            						addError(name, "instance index (" + index + ") does not exist for attribute");
            				}
            			
            			// otherwise reference all instances with this instance name
            			} else {
            				for (Instance i : instances) {
            					// process all instances (global attribute)
            					Attribute a = i.getAttribute((name!=null?name.getText():null));
            					if (a != null) {
            						if (newAttr)
            							addError(name, "new attribute already declared");
            						if (!a.overwrite((value!=null?value.getText():null)))
            							addWarning(name, "attribute already overwritten");
            					} else if (newAttr) {
            						Attribute newA = new Attribute(i);
            						newA.setName((name!=null?name.getText():null));
            						newA.setValue((value!=null?value.getText():null));
            						setLocation(newA, name);
            						i.addAttribute(newA);
            					} else
            						addError(name, "undeclared attribute");
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:539:1: pinAssign[Design des, String instName] : ^( PIN_ASSIGN ( COMBINE )? ( indexDecl )? operand concatenation[des] ) ;
    public final void pinAssign(Design des, String instName) throws RecognitionException {
        List<Integer> indexDecl7 = null;

        PhdlAST.operand_return operand8 = null;

        PhdlAST.concatenation_return concatenation9 = null;


        boolean isCombined = false;
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:541:2: ( ^( PIN_ASSIGN ( COMBINE )? ( indexDecl )? operand concatenation[des] ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:541:4: ^( PIN_ASSIGN ( COMBINE )? ( indexDecl )? operand concatenation[des] )
            {
            match(input,PIN_ASSIGN,FOLLOW_PIN_ASSIGN_in_pinAssign423); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:541:17: ( COMBINE )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==COMBINE) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:541:18: COMBINE
                    {
                    match(input,COMBINE,FOLLOW_COMBINE_in_pinAssign426); 
                    isCombined = true;

                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:541:49: ( indexDecl )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=BOUNDS && LA17_0<=INDICES)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:541:49: indexDecl
                    {
                    pushFollow(FOLLOW_indexDecl_in_pinAssign432);
                    indexDecl7=indexDecl();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_operand_in_pinAssign435);
            operand8=operand();

            state._fsp--;

            pushFollow(FOLLOW_concatenation_in_pinAssign437);
            concatenation9=concatenation(des);

            state._fsp--;


            match(input, Token.UP, null); 
            	
            			// check for duplicate qualifier indices
            			Set<Integer> indices = new HashSet<Integer>();
            			if (indexDecl7 != null) {
            				for (Integer i : indexDecl7)
            					if (!indices.add(i))
            						bailOut((operand8!=null?operand8.name:null), "duplicate instance qualifier index");
            			}

            			// gather the relevant instances in a list
            			List<Instance> insts = new ArrayList<Instance>();
            			if (indexDecl7 == null) {
            				for (Instance i : des.getInstances(instName))
            					insts.add(i);
            			} else {
            				for (Integer i : indexDecl7) {
            					Instance inst = des.getInstance(instName, i);
            					if (inst == null)
            						bailOut((operand8!=null?operand8.name:null), "invalid instance qualifier index");
            					else
            						insts.add(inst);
            				}
            			}
            			
            			// list of pins to assign nets to
            			List<Pin> pins = new ArrayList<Pin>();
            			
            			if (isCombined) {
            				if ((operand8!=null?operand8.indices:null) == null) {
            					for (Instance i : insts)
            						pins.addAll(i.getAllPins((operand8!=null?operand8.name:null).getText()));
            					if (pins.size() == 0)
            						bailOut((operand8!=null?operand8.name:null), "undeclared pin");
            				} else {
            					for (Instance inst : insts) {
            						for (Integer i : (operand8!=null?operand8.indices:null)) {
            							Pin p = inst.getPin((operand8!=null?operand8.name:null).getText(), i);
            							if (p == null)
            								bailOut((operand8!=null?operand8.name:null), "undeclared pin or invalid pin slice [" + i + "]");
            							else
            								pins.add(p);
            						}
            					}
            				}

            				for (int i = 0; i < pins.size(); i++) {
            					if (pins.get(i).hasNet()) {
            						String index = (pins.get(i).getIndex() == -1)?("pin"):("slice [" + pins.get(i).getIndex() + "] of pin");
            						bailOut((operand8!=null?operand8.name:null), index + " is already assigned");
            					} else if (pins.get(i).isOpen()) {
            						String index = (pins.get(i).getIndex() == -1)?("pin"):("slice [" + pins.get(i).getIndex() + "] of pin");
            						bailOut((operand8!=null?operand8.name:null), index + " is already open");
            					} else if ((concatenation9!=null?concatenation9.isReplicated:false)) {
            						pins.get(i).setNet((concatenation9!=null?concatenation9.nets:null).get(0));
            						(concatenation9!=null?concatenation9.nets:null).get(0).addPin(pins.get(i));
            					} else if ((concatenation9!=null?concatenation9.isOpen:false)) {
            						pins.get(i).setOpen(true);
            					} else {
            						// check for width mismatch
            						if (pins.size() != (concatenation9!=null?concatenation9.nets:null).size()) {
            							bailOut((operand8!=null?operand8.name:null), "pin assignment left size [" + pins.size() + 
            								"] does not match right size [" + (concatenation9!=null?concatenation9.nets:null).size() + "]");
            						}	
            						pins.get(i).setNet((concatenation9!=null?concatenation9.nets:null).get(i));
            						(concatenation9!=null?concatenation9.nets:null).get(i).addPin(pins.get(i));
            					}
            				}
            				
            			// assignment is not a combine operation
            			} else {
            				for (Instance inst : insts) {
            					if ((operand8!=null?operand8.indices:null) == null) {
            						pins.addAll(inst.getAllPins((operand8!=null?operand8.name:null).getText()));
            						if (pins.size() == 0)
            							bailOut((operand8!=null?operand8.name:null), "undeclared pin");
            					} else {
            						for (Integer i : (operand8!=null?operand8.indices:null)) {
            							Pin p = inst.getPin((operand8!=null?operand8.name:null).getText(), i);
            							if (p == null)
            								bailOut((operand8!=null?operand8.name:null), "undeclared pin or invalid pin slice [" + i + "]");
            							else
            								pins.add(p);
            						}
            					}
            					
            					for (int i = 0; i < pins.size(); i++) {
            						if (pins.get(i).hasNet()) {
            							String index = (pins.get(i).getIndex() == -1)?("pin"):("slice [" + pins.get(i).getIndex() + "] of pin");
            							bailOut((operand8!=null?operand8.name:null), index + " is already assigned");
            						} else if (pins.get(i).isOpen()) {
            							String index = (pins.get(i).getIndex() == -1)?("pin"):("slice [" + pins.get(i).getIndex() + "] of pin");
            							bailOut((operand8!=null?operand8.name:null), index + " is already open");
            						} else if ((concatenation9!=null?concatenation9.isReplicated:false)) {
            							pins.get(i).setNet((concatenation9!=null?concatenation9.nets:null).get(0));
            							(concatenation9!=null?concatenation9.nets:null).get(0).addPin(pins.get(i));
            						} else if ((concatenation9!=null?concatenation9.isOpen:false)) {
            							pins.get(i).setOpen(true);
            						} else {
            							// check for width mismatch
            							if (pins.size() != (concatenation9!=null?concatenation9.nets:null).size()) {
            								bailOut((operand8!=null?operand8.name:null), "pin assignment left size [" + pins.size() + 
            									"] does not match right size [" + (concatenation9!=null?concatenation9.nets:null).size() + "]");
            							}	
            							pins.get(i).setNet((concatenation9!=null?concatenation9.nets:null).get(i));
            							(concatenation9!=null?concatenation9.nets:null).get(i).addPin(pins.get(i));
            						}
            					}
            					// clear the list in preparation for the next instance's pins
            					pins.clear();
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


    // $ANTLR start "netAssign"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:656:1: netAssign[Design des] : ^( NET_ASSIGN operand concatenation[des] ) ;
    public final void netAssign(Design des) throws RecognitionException {
        PhdlAST.concatenation_return concatenation10 = null;

        PhdlAST.operand_return operand11 = null;


        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:657:2: ( ^( NET_ASSIGN operand concatenation[des] ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:657:4: ^( NET_ASSIGN operand concatenation[des] )
            {
            match(input,NET_ASSIGN,FOLLOW_NET_ASSIGN_in_netAssign457); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_operand_in_netAssign459);
            operand11=operand();

            state._fsp--;

            pushFollow(FOLLOW_concatenation_in_netAssign461);
            concatenation10=concatenation(des);

            state._fsp--;


            match(input, Token.UP, null); 
            	if ((concatenation10!=null?concatenation10.isOpen:false))
            				bailOut((operand11!=null?operand11.name:null), "nets cannot be open");
            				
            			List<Net> nets = new ArrayList<Net>();
            			if ((operand11!=null?operand11.indices:null) == null) {
            				nets.addAll(des.getAllNets((operand11!=null?operand11.name:null).getText()));
            			} else {
            				for (Integer i : (operand11!=null?operand11.indices:null)) {
            					Net n = des.getNet((operand11!=null?operand11.name:null).getText(), i);
            					if (n == null)
            						bailOut((operand11!=null?operand11.name:null), "undeclared net or invalid net index (" + i + ")");
            					else
            						nets.add(n);
            				}
            			}
            			
            			
            			for (int i = 0; i < nets.size(); i++) {
            				if ((concatenation10!=null?concatenation10.isReplicated:false)) {
            					nets.get(i).addNet((concatenation10!=null?concatenation10.nets:null).get(0));
            					(concatenation10!=null?concatenation10.nets:null).get(0).addNet(nets.get(i));
            				} else {
            					// check for assignment width mismatch
            					if (nets.size() != (concatenation10!=null?concatenation10.nets:null).size()) {
            						bailOut((operand11!=null?operand11.name:null), "net assignment left size [" + nets.size() + 
            							"] does not match right size [" + (concatenation10!=null?concatenation10.nets:null).size() + "]");
            					}
            					nets.get(i).addNet((concatenation10!=null?concatenation10.nets:null).get(i));
            					(concatenation10!=null?concatenation10.nets:null).get(i).addNet(nets.get(i));
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

    public static class concatenation_return extends TreeRuleReturnScope {
        public List<Net> nets;
        public boolean isReplicated;
        public boolean isOpen;
    };

    // $ANTLR start "concatenation"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:693:1: concatenation[Design des] returns [List<Net> nets, boolean isReplicated, boolean isOpen] : ( ^( CONCAT_LIST ( operand )* ) | ^( CONCAT_REPL operand ) | ^( OPEN ) );
    public final PhdlAST.concatenation_return concatenation(Design des) throws RecognitionException {
        PhdlAST.concatenation_return retval = new PhdlAST.concatenation_return();
        retval.start = input.LT(1);

        PhdlAST.operand_return operand12 = null;

        PhdlAST.operand_return operand13 = null;


        retval.nets = new ArrayList<Net>();
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:696:2: ( ^( CONCAT_LIST ( operand )* ) | ^( CONCAT_REPL operand ) | ^( OPEN ) )
            int alt19=3;
            switch ( input.LA(1) ) {
            case CONCAT_LIST:
                {
                alt19=1;
                }
                break;
            case CONCAT_REPL:
                {
                alt19=2;
                }
                break;
            case OPEN:
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:696:4: ^( CONCAT_LIST ( operand )* )
                    {
                    match(input,CONCAT_LIST,FOLLOW_CONCAT_LIST_in_concatenation493); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:696:18: ( operand )*
                        loop18:
                        do {
                            int alt18=2;
                            int LA18_0 = input.LA(1);

                            if ( (LA18_0==OPERAND) ) {
                                alt18=1;
                            }


                            switch (alt18) {
                        	case 1 :
                        	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:696:19: operand
                        	    {
                        	    pushFollow(FOLLOW_operand_in_concatenation496);
                        	    operand12=operand();

                        	    state._fsp--;

                        	    	if ((operand12!=null?operand12.indices:null) != null) {
                        	    					for (int i = 0; i < (operand12!=null?operand12.indices:null).size(); i++) {
                        	    						Net n = des.getNet((operand12!=null?operand12.name:null).getText(), (operand12!=null?operand12.indices:null).get(i));
                        	    						if (n == null) {
                        	    							if (des.getAllNets((operand12!=null?operand12.name:null).getText()).size() > 0)
                        	    								bailOut((operand12!=null?operand12.name:null), "invalid net slice [" + (operand12!=null?operand12.indices:null).get(i) + "]");
                        	    							else
                        	    								bailOut((operand12!=null?operand12.name:null), "undeclared ned");
                        	    						} else
                        	    							retval.nets.add(n);
                        	    					}
                        	    				} else
                        	    					retval.nets.addAll(des.getAllNets((operand12!=null?operand12.name:null).getText()));
                        	    			

                        	    }
                        	    break;

                        	default :
                        	    break loop18;
                            }
                        } while (true);


                        match(input, Token.UP, null); 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:713:4: ^( CONCAT_REPL operand )
                    {
                    match(input,CONCAT_REPL,FOLLOW_CONCAT_REPL_in_concatenation514); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_operand_in_concatenation516);
                    operand13=operand();

                    state._fsp--;

                    	retval.isReplicated = true;
                    				// search based on name only (no index)
                    				if ((operand13!=null?operand13.indices:null) == null) {
                    					List<Net> nets = des.getAllNets((operand13!=null?operand13.name:null).getText());
                    					if (nets.size() > 1)
                    						bailOut((operand13!=null?operand13.name:null), "assignment cannot replicate a net vector");
                    					retval.nets.add(nets.get(0));
                    				} else {
                    				// search based on name and index
                    					if ((operand13!=null?operand13.indices:null).size() != 1)
                    						bailOut((operand13!=null?operand13.name:null), "assignment cannot replicate a net vector");
                    					Net n = des.getNet((operand13!=null?operand13.name:null).getText(), (operand13!=null?operand13.indices:null).get(0));
                    					if (n == null) {
                    						if (des.getAllNets((operand13!=null?operand13.name:null).getText()).size() > 0)
                    							bailOut((operand13!=null?operand13.name:null), "invalid net slice [" + (operand13!=null?operand13.indices:null).get(0) + "]");
                    						else	
                    							bailOut((operand13!=null?operand13.name:null), "undeclared net");
                    					} else
                    						retval.nets.add(n);
                    				}
                    			

                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:737:4: ^( OPEN )
                    {
                    match(input,OPEN,FOLLOW_OPEN_in_concatenation534); 

                    retval.isOpen = true;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        match(input, Token.UP, null); 
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
        return retval;
    }
    // $ANTLR end "concatenation"

    public static class operand_return extends TreeRuleReturnScope {
        public CommonTree name;
        public List<Integer> indices;
    };

    // $ANTLR start "operand"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:740:1: operand returns [CommonTree name, List<Integer> indices] : ^( OPERAND id= IDENT ( indexDecl )? ) ;
    public final PhdlAST.operand_return operand() throws RecognitionException {
        PhdlAST.operand_return retval = new PhdlAST.operand_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        List<Integer> indexDecl14 = null;


        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:741:2: ( ^( OPERAND id= IDENT ( indexDecl )? ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:741:4: ^( OPERAND id= IDENT ( indexDecl )? )
            {
            match(input,OPERAND,FOLLOW_OPERAND_in_operand553); 

            match(input, Token.DOWN, null); 
            id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_operand557); 
            retval.name = id;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:741:38: ( indexDecl )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=BOUNDS && LA20_0<=INDICES)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:741:39: indexDecl
                    {
                    pushFollow(FOLLOW_indexDecl_in_operand562);
                    indexDecl14=indexDecl();

                    state._fsp--;

                    retval.indices = indexDecl14;

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
        return retval;
    }
    // $ANTLR end "operand"


    // $ANTLR start "indexDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:744:1: indexDecl returns [List<Integer> indices] : ( ^( BOUNDS hi= INT lo= INT ) | ^( INDICES (index= INT )+ ) );
    public final List<Integer> indexDecl() throws RecognitionException {
        List<Integer> indices = null;

        CommonTree hi=null;
        CommonTree lo=null;
        CommonTree index=null;

        indices = new ArrayList<Integer>();
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:746:2: ( ^( BOUNDS hi= INT lo= INT ) | ^( INDICES (index= INT )+ ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==BOUNDS) ) {
                alt22=1;
            }
            else if ( (LA22_0==INDICES) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:746:4: ^( BOUNDS hi= INT lo= INT )
                    {
                    match(input,BOUNDS,FOLLOW_BOUNDS_in_indexDecl588); 

                    match(input, Token.DOWN, null); 
                    hi=(CommonTree)match(input,INT,FOLLOW_INT_in_indexDecl592); 
                    lo=(CommonTree)match(input,INT,FOLLOW_INT_in_indexDecl596); 

                    match(input, Token.UP, null); 
                    	int msb = Integer.parseInt((hi!=null?hi.getText():null));
                    			int lsb = Integer.parseInt((lo!=null?lo.getText():null));
                    			if (msb < lsb) {
                    				for (int i = msb; i <= lsb; i++)
                    					indices.add(i);
                    			} else {
                    				for (int i = msb; i >= lsb; i--)
                    					indices.add(i);
                    			}
                    		

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:757:4: ^( INDICES (index= INT )+ )
                    {
                    match(input,INDICES,FOLLOW_INDICES_in_indexDecl607); 

                    match(input, Token.DOWN, null); 
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:757:14: (index= INT )+
                    int cnt21=0;
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==INT) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:757:15: index= INT
                    	    {
                    	    index=(CommonTree)match(input,INT,FOLLOW_INT_in_indexDecl612); 
                    	    indices.add(Integer.parseInt((index!=null?index.getText():null)));

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt21 >= 1 ) break loop21;
                                EarlyExitException eee =
                                    new EarlyExitException(21, input);
                                throw eee;
                        }
                        cnt21++;
                    } while (true);


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
        return indices;
    }
    // $ANTLR end "indexDecl"

    public static class widthDecl_return extends TreeRuleReturnScope {
        public int msb;
        public int lsb;
        public int width;
        public boolean downto;
    };

    // $ANTLR start "widthDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:760:1: widthDecl returns [int msb, int lsb, int width, boolean downto] : ^( WIDTH_DECL hi= INT lo= INT ) ;
    public final PhdlAST.widthDecl_return widthDecl() throws RecognitionException {
        PhdlAST.widthDecl_return retval = new PhdlAST.widthDecl_return();
        retval.start = input.LT(1);

        CommonTree hi=null;
        CommonTree lo=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:761:2: ( ^( WIDTH_DECL hi= INT lo= INT ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:761:4: ^( WIDTH_DECL hi= INT lo= INT )
            {
            match(input,WIDTH_DECL,FOLLOW_WIDTH_DECL_in_widthDecl633); 

            match(input, Token.DOWN, null); 
            hi=(CommonTree)match(input,INT,FOLLOW_INT_in_widthDecl637); 
            lo=(CommonTree)match(input,INT,FOLLOW_INT_in_widthDecl641); 

            match(input, Token.UP, null); 
            	retval.msb = Integer.parseInt((hi!=null?hi.getText():null));
            			retval.lsb = Integer.parseInt((lo!=null?lo.getText():null));
            			retval.width = Math.abs(retval.msb - retval.lsb) + 1;
            			retval.downto = (retval.msb > retval.lsb)? true: false;
            		

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:769:1: pinList returns [List<String> list] : ^( PIN_LIST (num1= INT | num2= IDENT | num3= PINNUM )+ ) ;
    public final List<String> pinList() throws RecognitionException {
        List<String> list = null;

        CommonTree num1=null;
        CommonTree num2=null;
        CommonTree num3=null;

        list = new ArrayList<String>();
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:771:2: ( ^( PIN_LIST (num1= INT | num2= IDENT | num3= PINNUM )+ ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:771:4: ^( PIN_LIST (num1= INT | num2= IDENT | num3= PINNUM )+ )
            {
            match(input,PIN_LIST,FOLLOW_PIN_LIST_in_pinList666); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:772:2: (num1= INT | num2= IDENT | num3= PINNUM )+
            int cnt23=0;
            loop23:
            do {
                int alt23=4;
                switch ( input.LA(1) ) {
                case INT:
                    {
                    alt23=1;
                    }
                    break;
                case IDENT:
                    {
                    alt23=2;
                    }
                    break;
                case PINNUM:
                    {
                    alt23=3;
                    }
                    break;

                }

                switch (alt23) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:772:4: num1= INT
            	    {
            	    num1=(CommonTree)match(input,INT,FOLLOW_INT_in_pinList673); 
            	    list.add((num1!=null?num1.getText():null));

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:773:4: num2= IDENT
            	    {
            	    num2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinList682); 
            	    list.add((num2!=null?num2.getText():null));

            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:774:4: num3= PINNUM
            	    {
            	    num3=(CommonTree)match(input,PINNUM,FOLLOW_PINNUM_in_pinList691); 
            	    list.add((num3!=null?num3.getText():null));

            	    }
            	    break;

            	default :
            	    if ( cnt23 >= 1 ) break loop23;
                        EarlyExitException eee =
                            new EarlyExitException(23, input);
                        throw eee;
                }
                cnt23++;
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
        return list;
    }
    // $ANTLR end "pinList"


    // $ANTLR start "pinType"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:778:1: pinType returns [PinType type] : ^( PIN_TYPE ( PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN ) ) ;
    public final PinType pinType() throws RecognitionException {
        PinType type = null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:779:2: ( ^( PIN_TYPE ( PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN ) ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:779:4: ^( PIN_TYPE ( PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN ) )
            {
            match(input,PIN_TYPE,FOLLOW_PIN_TYPE_in_pinType715); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:780:2: ( PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN )
            int alt24=6;
            switch ( input.LA(1) ) {
            case PIN:
                {
                alt24=1;
                }
                break;
            case INPIN:
                {
                alt24=2;
                }
                break;
            case OUTPIN:
                {
                alt24=3;
                }
                break;
            case IOPIN:
                {
                alt24=4;
                }
                break;
            case PWRPIN:
                {
                alt24=5;
                }
                break;
            case SUPPIN:
                {
                alt24=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:780:4: PIN
                    {
                    match(input,PIN,FOLLOW_PIN_in_pinType721); 
                    type = PinType.PIN;

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:781:4: INPIN
                    {
                    match(input,INPIN,FOLLOW_INPIN_in_pinType729); 
                    type = PinType.INPIN;

                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:782:4: OUTPIN
                    {
                    match(input,OUTPIN,FOLLOW_OUTPIN_in_pinType736); 
                    type = PinType.OUTPIN;

                    }
                    break;
                case 4 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:783:4: IOPIN
                    {
                    match(input,IOPIN,FOLLOW_IOPIN_in_pinType743); 
                    type = PinType.IOPIN;

                    }
                    break;
                case 5 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:784:4: PWRPIN
                    {
                    match(input,PWRPIN,FOLLOW_PWRPIN_in_pinType750); 
                    type = PinType.PWRPIN;

                    }
                    break;
                case 6 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:785:4: SUPPIN
                    {
                    match(input,SUPPIN,FOLLOW_SUPPIN_in_pinType757); 
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


    // $ANTLR start "infoDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:788:1: infoDecl returns [String value] : ^( INFO_DECL (st= STRING )+ ) ;
    public final String infoDecl() throws RecognitionException {
        String value = null;

        CommonTree st=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:789:2: ( ^( INFO_DECL (st= STRING )+ ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:789:5: ^( INFO_DECL (st= STRING )+ )
            {
            match(input,INFO_DECL,FOLLOW_INFO_DECL_in_infoDecl779); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:789:17: (st= STRING )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==STRING) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:789:18: st= STRING
            	    {
            	    st=(CommonTree)match(input,STRING,FOLLOW_STRING_in_infoDecl784); 
            	    value += (st!=null?st.getText():null);

            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
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
        return value;
    }
    // $ANTLR end "infoDecl"

    // Delegated rules


 

    public static final BitSet FOLLOW_deviceDecl_in_sourceText60 = new BitSet(new long[]{0x00000C0000000002L});
    public static final BitSet FOLLOW_designDecl_in_sourceText64 = new BitSet(new long[]{0x00000C0000000002L});
    public static final BitSet FOLLOW_DEVICE_DECL_in_deviceDecl79 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl83 = new BitSet(new long[]{0x0103000000000008L});
    public static final BitSet FOLLOW_infoDecl_in_deviceDecl96 = new BitSet(new long[]{0x0103000000000008L});
    public static final BitSet FOLLOW_attrDecl_in_deviceDecl99 = new BitSet(new long[]{0x0003000000000008L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl103 = new BitSet(new long[]{0x0002000000000008L});
    public static final BitSet FOLLOW_ATTR_DECL_in_attrDecl128 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_attrDecl132 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_STRING_in_attrDecl136 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PIN_DECL_in_pinDecl164 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl168 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_pinType_in_pinDecl170 = new BitSet(new long[]{0x0040100000000000L});
    public static final BitSet FOLLOW_widthDecl_in_pinDecl173 = new BitSet(new long[]{0x0040100000000000L});
    public static final BitSet FOLLOW_pinList_in_pinDecl179 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DESIGN_DECL_in_designDecl200 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_designDecl204 = new BitSet(new long[]{0x0900A00000000008L});
    public static final BitSet FOLLOW_infoDecl_in_designDecl213 = new BitSet(new long[]{0x0900A00000000008L});
    public static final BitSet FOLLOW_netDecl_in_designDecl218 = new BitSet(new long[]{0x0900A00000000008L});
    public static final BitSet FOLLOW_instDecl_in_designDecl224 = new BitSet(new long[]{0x0900A00000000008L});
    public static final BitSet FOLLOW_netAssign_in_designDecl230 = new BitSet(new long[]{0x0900A00000000008L});
    public static final BitSet FOLLOW_NET_DECL_in_netDecl250 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_widthDecl_in_netDecl263 = new BitSet(new long[]{0x0001000000000008L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_netDecl272 = new BitSet(new long[]{0x0001000000000008L,0x0000000000000020L});
    public static final BitSet FOLLOW_attrDecl_in_netDecl290 = new BitSet(new long[]{0x0001000000000008L});
    public static final BitSet FOLLOW_INST_DECL_in_instDecl314 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_widthDecl_in_instDecl317 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_instDecl325 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_instDecl329 = new BitSet(new long[]{0x0700000000000008L});
    public static final BitSet FOLLOW_infoDecl_in_instDecl343 = new BitSet(new long[]{0x0700000000000008L});
    public static final BitSet FOLLOW_attrAssign_in_instDecl346 = new BitSet(new long[]{0x0600000000000008L});
    public static final BitSet FOLLOW_pinAssign_in_instDecl350 = new BitSet(new long[]{0x0400000000000008L});
    public static final BitSet FOLLOW_ATTR_ASSIGN_in_attrAssign378 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NEWATTR_in_attrAssign381 = new BitSet(new long[]{0xC000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_indexDecl_in_attrAssign388 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_attrAssign396 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_STRING_in_attrAssign400 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PIN_ASSIGN_in_pinAssign423 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_COMBINE_in_pinAssign426 = new BitSet(new long[]{0xC000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_indexDecl_in_pinAssign432 = new BitSet(new long[]{0xC000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_operand_in_pinAssign435 = new BitSet(new long[]{0x0000000000000000L,0x000000000000001CL});
    public static final BitSet FOLLOW_concatenation_in_pinAssign437 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NET_ASSIGN_in_netAssign457 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operand_in_netAssign459 = new BitSet(new long[]{0x0000000000000000L,0x000000000000001CL});
    public static final BitSet FOLLOW_concatenation_in_netAssign461 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONCAT_LIST_in_concatenation493 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operand_in_concatenation496 = new BitSet(new long[]{0xC000000000000008L,0x0000000000000001L});
    public static final BitSet FOLLOW_CONCAT_REPL_in_concatenation514 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operand_in_concatenation516 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OPEN_in_concatenation534 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_OPERAND_in_operand553 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_operand557 = new BitSet(new long[]{0xC000000000000008L});
    public static final BitSet FOLLOW_indexDecl_in_operand562 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BOUNDS_in_indexDecl588 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_indexDecl592 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_INT_in_indexDecl596 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INDICES_in_indexDecl607 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_indexDecl612 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000080L});
    public static final BitSet FOLLOW_WIDTH_DECL_in_widthDecl633 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_widthDecl637 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_INT_in_widthDecl641 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PIN_LIST_in_pinList666 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_pinList673 = new BitSet(new long[]{0x0000000000000008L,0x00000000000001A0L});
    public static final BitSet FOLLOW_IDENT_in_pinList682 = new BitSet(new long[]{0x0000000000000008L,0x00000000000001A0L});
    public static final BitSet FOLLOW_PINNUM_in_pinList691 = new BitSet(new long[]{0x0000000000000008L,0x00000000000001A0L});
    public static final BitSet FOLLOW_PIN_TYPE_in_pinType715 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PIN_in_pinType721 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INPIN_in_pinType729 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OUTPIN_in_pinType736 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IOPIN_in_pinType743 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PWRPIN_in_pinType750 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SUPPIN_in_pinType757 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INFO_DECL_in_infoDecl779 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_infoDecl784 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000040L});

}