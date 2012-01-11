// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g 2012-01-11 10:07:26

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SEMICOLON", "COLON", "COMMA", "PERIOD", "EQUALS", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "LANGLE", "RANGLE", "AMPERSAND", "DBLQUOTE", "DESIGN", "DEVICE", "SUBDESIGN", "INST", "SUBINST", "GROUP", "THIS", "OF", "NET", "ATTR", "NEWATTR", "BEGIN", "END", "COMBINE", "INCLUDE", "INFO", "PORT", "OPEN", "PIN", "INPIN", "OUTPIN", "IOPIN", "PWRPIN", "SUPPIN", "DEVICE_DECL", "DESIGN_DECL", "SUBDESIGN_DECL", "ATTR_DECL", "PIN_DECL", "PORT_DECL", "NET_DECL", "INST_DECL", "SUBINST_DECL", "GROUP_DECL", "INFO_DECL", "ATTR_ASSIGN", "SUBATTR_ASSIGN", "CONNECT_ASSIGN", "NET_ASSIGN", "CONCAT_LIST", "CONCAT_REPL", "CONCAT_OPEN", "WIDTH", "PIN_LIST", "PIN_TYPE", "BOUNDS", "INDICES", "OPERAND", "NAME", "IDENT", "STRING", "INT", "PINNUM", "D", "E", "S", "I", "G", "N", "V", "C", "U", "B", "T", "R", "O", "P", "H", "F", "A", "W", "M", "L", "J", "K", "Q", "X", "Y", "Z", "CHAR", "DIGIT", "ESC", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "INCLUDE_DECL"
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
    public static final int OPEN=36;
    public static final int PIN=37;
    public static final int INPIN=38;
    public static final int OUTPIN=39;
    public static final int IOPIN=40;
    public static final int PWRPIN=41;
    public static final int SUPPIN=42;
    public static final int DEVICE_DECL=43;
    public static final int DESIGN_DECL=44;
    public static final int SUBDESIGN_DECL=45;
    public static final int ATTR_DECL=46;
    public static final int PIN_DECL=47;
    public static final int PORT_DECL=48;
    public static final int NET_DECL=49;
    public static final int INST_DECL=50;
    public static final int SUBINST_DECL=51;
    public static final int GROUP_DECL=52;
    public static final int INFO_DECL=53;
    public static final int ATTR_ASSIGN=54;
    public static final int SUBATTR_ASSIGN=55;
    public static final int CONNECT_ASSIGN=56;
    public static final int NET_ASSIGN=57;
    public static final int CONCAT_LIST=58;
    public static final int CONCAT_REPL=59;
    public static final int CONCAT_OPEN=60;
    public static final int WIDTH=61;
    public static final int PIN_LIST=62;
    public static final int PIN_TYPE=63;
    public static final int BOUNDS=64;
    public static final int INDICES=65;
    public static final int OPERAND=66;
    public static final int NAME=67;
    public static final int IDENT=68;
    public static final int STRING=69;
    public static final int INT=70;
    public static final int PINNUM=71;
    public static final int D=72;
    public static final int E=73;
    public static final int S=74;
    public static final int I=75;
    public static final int G=76;
    public static final int N=77;
    public static final int V=78;
    public static final int C=79;
    public static final int U=80;
    public static final int B=81;
    public static final int T=82;
    public static final int R=83;
    public static final int O=84;
    public static final int P=85;
    public static final int H=86;
    public static final int F=87;
    public static final int A=88;
    public static final int W=89;
    public static final int M=90;
    public static final int L=91;
    public static final int J=92;
    public static final int K=93;
    public static final int Q=94;
    public static final int X=95;
    public static final int Y=96;
    public static final int Z=97;
    public static final int CHAR=98;
    public static final int DIGIT=99;
    public static final int ESC=100;
    public static final int WHITESPACE=101;
    public static final int LINE_COMMENT=102;
    public static final int MULTILINE_COMMENT=103;
    public static final int INCLUDE_DECL=104;

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


    	
    	/** The list of errors */
    	private List<String> errors = new ArrayList<String>();
    	
    	/** The list of warnings */
    	private List<String> warnings = new ArrayList<String>();
    	
    	/** The set of all Devices is global to the project build */
    	private Set<Device> devices = new HashSet<Device>();
    	
    	/** The top level design */
    	private	Design topDesign;
    	
    	/** The set of subDesigns */
    	private Set<SubDesign> subDesigns = new HashSet<SubDesign>();
    	
    	/** Sets to check for duplicates while processing everything */
    	private Set<String> pinNames = new HashSet<String>();
    	private Set<String> netNames = new HashSet<String>();
    	private Set<String> portNames = new HashSet<String>();
    	
    	/** A set of any instanced names (instance or subdesign names) */
    	private Set<String> instNames = new HashSet<String>();
    	
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
    	
    	public Design getTopDesign() {
    		return topDesign;
    	}
    	
    	public void setTopDesign(Design des) {
    		this.topDesign = des;
    	}
    	
    	public Set<SubDesign> getSubDesigns() {
    		return subDesigns;
    	}
    	
    	public void setSubDesigns(Set<SubDesign> subDesigns) {
    		this.subDesigns = subDesigns;
    	}
    	
    	public SubDesign getSubDesignByName(String name) {
    		for (SubDesign s : subDesigns) {
    			if (s.getName().equals(name))
    				return s;
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:224:1: sourceText : ( deviceDecl | designDecl )+ ;
    public final void sourceText() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:225:2: ( ( deviceDecl | designDecl )+ )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:225:4: ( deviceDecl | designDecl )+
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:225:4: ( deviceDecl | designDecl )+
            int cnt1=0;
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==DEVICE_DECL) ) {
                    alt1=1;
                }
                else if ( ((LA1_0>=DESIGN_DECL && LA1_0<=SUBDESIGN_DECL)) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:225:5: deviceDecl
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_sourceText60);
            	    deviceDecl();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:225:18: designDecl
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:228:1: deviceDecl : ^( DEVICE_DECL devName= IDENT ( infoDecl )* ( attrDecl[devs] )* ( pinDecl[dev] )* ) ;
    public final void deviceDecl() throws RecognitionException {
        CommonTree devName=null;
        PhdlAST.infoDecl_return infoDecl1 = null;


        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:229:2: ( ^( DEVICE_DECL devName= IDENT ( infoDecl )* ( attrDecl[devs] )* ( pinDecl[dev] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:229:4: ^( DEVICE_DECL devName= IDENT ( infoDecl )* ( attrDecl[devs] )* ( pinDecl[dev] )* )
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
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:246:3: ( infoDecl )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==INFO_DECL) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:246:4: infoDecl
            	    {
            	    pushFollow(FOLLOW_infoDecl_in_deviceDecl97);
            	    infoDecl1=infoDecl();

            	    state._fsp--;

            	    dev.appendInfo((infoDecl1!=null?infoDecl1.info:null).getText());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:248:3: ( attrDecl[devs] )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==ATTR_DECL) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:248:3: attrDecl[devs]
            	    {
            	    pushFollow(FOLLOW_attrDecl_in_deviceDecl110);
            	    attrDecl(devs);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:248:19: ( pinDecl[dev] )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==PIN_DECL) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:248:19: pinDecl[dev]
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl114);
            	    pinDecl(dev);

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
    // $ANTLR end "deviceDecl"


    // $ANTLR start "attrDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:251:1: attrDecl[List<Attributable> parents] : ^( ATTR_DECL attrName= IDENT attrValue= STRING ) ;
    public final void attrDecl(List<Attributable> parents) throws RecognitionException {
        CommonTree attrName=null;
        CommonTree attrValue=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:252:2: ( ^( ATTR_DECL attrName= IDENT attrValue= STRING ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:252:4: ^( ATTR_DECL attrName= IDENT attrValue= STRING )
            {
            match(input,ATTR_DECL,FOLLOW_ATTR_DECL_in_attrDecl132); 

            match(input, Token.DOWN, null); 
            attrName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attrDecl136); 
            attrValue=(CommonTree)match(input,STRING,FOLLOW_STRING_in_attrDecl140); 

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:275:1: pinDecl[Device dev] : ^( PIN_DECL pinName= IDENT pinType ( width )? pinList ) ;
    public final void pinDecl(Device dev) throws RecognitionException {
        CommonTree pinName=null;
        List<Integer> width2 = null;

        List<String> pinList3 = null;

        PinType pinType4 = null;


        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:276:2: ( ^( PIN_DECL pinName= IDENT pinType ( width )? pinList ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:276:4: ^( PIN_DECL pinName= IDENT pinType ( width )? pinList )
            {
            match(input,PIN_DECL,FOLLOW_PIN_DECL_in_pinDecl161); 

            match(input, Token.DOWN, null); 
            pinName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinDecl165); 
            pushFollow(FOLLOW_pinType_in_pinDecl167);
            pinType4=pinType();

            state._fsp--;

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:276:37: ( width )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==WIDTH) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:276:37: width
                    {
                    pushFollow(FOLLOW_width_in_pinDecl169);
                    width2=width();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_pinList_in_pinDecl172);
            pinList3=pinList();

            state._fsp--;


            match(input, Token.UP, null); 
            	// make a single pin if there is no width
            			if (width2 == null || width2.size() == 1) {
            				if (pinList3.size() != 1)
            					addError(pinName, "invalid pin list");
            				Pin p = new Pin(dev);
            				p.setName((pinName!=null?pinName.getText():null));
            				p.setPinType(pinType4);
            				setLocation(p, pinName);
            				if (width2 != null) 
            					p.setIndex(width2.get(0));
            				// accessing the pinlist may throw an exception
            				try {
            					p.setPinMapping(pinList3.get(0));
            				} catch (IndexOutOfBoundsException e) {
            					addError(pinName, "invalid pin list");
            				}
            				// report any duplicate pin declarations
            				if (!dev.addPin(p))
            	           		addError(pinName, "duplicate pin declaration");
            			} else {
            				// make an array of pins based on the width parameters
            				if (width2.size() != pinList3.size())
            					addError(pinName, "invalid pin list");
            				for (int i = 0; i < width2.size(); i++) {
            					Pin p = new Pin(dev);
            					p.setName((pinName!=null?pinName.getText():null));
            					p.setPinType(pinType4);
            					setLocation(p, pinName);
            					p.setIndex(width2.get(i));
            					// accessing the pinlist may throw an exception
            					try {
            						p.setPinMapping(pinList3.get(i));
            					} catch (IndexOutOfBoundsException e) {
            						addError(pinName, "invalid pin list");
            					}
            					// report any duplicate pin declarations
            					if (!dev.addPin(p))
            						addError(pinName, "duplicate pin declaration");
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:325:1: designDecl : ^( (desKeyword= DESIGN_DECL | SUBDESIGN_DECL ) (desName= IDENT ( netDecl[des] | instDecl[des, null] | netAssign[des] | groupDecl[des] | subInstDecl[des] | portDecl[des] | ( infoDecl ) )* ) ) ;
    public final void designDecl() throws RecognitionException {
        CommonTree desKeyword=null;
        CommonTree desName=null;
        PhdlAST.infoDecl_return infoDecl5 = null;


        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:326:2: ( ^( (desKeyword= DESIGN_DECL | SUBDESIGN_DECL ) (desName= IDENT ( netDecl[des] | instDecl[des, null] | netAssign[des] | groupDecl[des] | subInstDecl[des] | portDecl[des] | ( infoDecl ) )* ) ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:326:4: ^( (desKeyword= DESIGN_DECL | SUBDESIGN_DECL ) (desName= IDENT ( netDecl[des] | instDecl[des, null] | netAssign[des] | groupDecl[des] | subInstDecl[des] | portDecl[des] | ( infoDecl ) )* ) )
            {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:326:6: (desKeyword= DESIGN_DECL | SUBDESIGN_DECL )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==DESIGN_DECL) ) {
                alt6=1;
            }
            else if ( (LA6_0==SUBDESIGN_DECL) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:326:7: desKeyword= DESIGN_DECL
                    {
                    desKeyword=(CommonTree)match(input,DESIGN_DECL,FOLLOW_DESIGN_DECL_in_designDecl196); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:326:32: SUBDESIGN_DECL
                    {
                    match(input,SUBDESIGN_DECL,FOLLOW_SUBDESIGN_DECL_in_designDecl200); 

                    }
                    break;

            }


            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:326:48: (desName= IDENT ( netDecl[des] | instDecl[des, null] | netAssign[des] | groupDecl[des] | subInstDecl[des] | portDecl[des] | ( infoDecl ) )* )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:326:49: desName= IDENT ( netDecl[des] | instDecl[des, null] | netAssign[des] | groupDecl[des] | subInstDecl[des] | portDecl[des] | ( infoDecl ) )*
            {
            desName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_designDecl206); 
            	// make a new design based on the identifier and log its location
            			DesignUnit des;
            			if (desKeyword != null) 	des = new Design();
            			else 							des = new SubDesign();
            			des.setName((desName!=null?desName.getText():null));
            			setLocation(des, desName);
            			if (desKeyword != null) {
            				if (topDesign == null)		topDesign = (Design) des;
            				else						bailOut(desName, "duplicate top level design");
            			} else
            											subDesigns.add((SubDesign)des);
            				
            			// sets check for duplicate names within the scope of a design.
            			netNames.clear();
            			portNames.clear();
            			instNames.clear();
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:346:2: ( netDecl[des] | instDecl[des, null] | netAssign[des] | groupDecl[des] | subInstDecl[des] | portDecl[des] | ( infoDecl ) )*
            loop7:
            do {
                int alt7=8;
                switch ( input.LA(1) ) {
                case NET_DECL:
                    {
                    alt7=1;
                    }
                    break;
                case INST_DECL:
                    {
                    alt7=2;
                    }
                    break;
                case NET_ASSIGN:
                    {
                    alt7=3;
                    }
                    break;
                case GROUP_DECL:
                    {
                    alt7=4;
                    }
                    break;
                case SUBINST_DECL:
                    {
                    alt7=5;
                    }
                    break;
                case PORT_DECL:
                    {
                    alt7=6;
                    }
                    break;
                case INFO_DECL:
                    {
                    alt7=7;
                    }
                    break;

                }

                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:346:4: netDecl[des]
            	    {
            	    pushFollow(FOLLOW_netDecl_in_designDecl220);
            	    netDecl(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:347:4: instDecl[des, null]
            	    {
            	    pushFollow(FOLLOW_instDecl_in_designDecl226);
            	    instDecl(des, null);

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:348:4: netAssign[des]
            	    {
            	    pushFollow(FOLLOW_netAssign_in_designDecl232);
            	    netAssign(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 4 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:349:4: groupDecl[des]
            	    {
            	    pushFollow(FOLLOW_groupDecl_in_designDecl238);
            	    groupDecl(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 5 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:350:4: subInstDecl[des]
            	    {
            	    pushFollow(FOLLOW_subInstDecl_in_designDecl244);
            	    subInstDecl(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 6 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:351:4: portDecl[des]
            	    {
            	    pushFollow(FOLLOW_portDecl_in_designDecl250);
            	    portDecl(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 7 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:352:4: ( infoDecl )
            	    {
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:352:4: ( infoDecl )
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:352:5: infoDecl
            	    {
            	    pushFollow(FOLLOW_infoDecl_in_designDecl258);
            	    infoDecl5=infoDecl();

            	    state._fsp--;

            	    	// append the info to the design
            	    				if ((infoDecl5!=null?infoDecl5.indices:null) != null)
            	    					addError((infoDecl5!=null?infoDecl5.info:null), "info in design cannot be qualified with an index");
            	    				else
            	    					des.appendInfo((infoDecl5!=null?infoDecl5.info:null).getText());
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


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
    // $ANTLR end "designDecl"


    // $ANTLR start "subInstDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:363:1: subInstDecl[DesignUnit des] : ^( SUBINST_DECL ( width )? instName= IDENT desName= IDENT ( infoDecl )* ( subAttrAssign )* ( portAssign[des, $instName.text] )* ) ;
    public final void subInstDecl(DesignUnit des) throws RecognitionException {
        CommonTree instName=null;
        CommonTree desName=null;
        List<Integer> width6 = null;

        PhdlAST.infoDecl_return infoDecl7 = null;


        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:364:2: ( ^( SUBINST_DECL ( width )? instName= IDENT desName= IDENT ( infoDecl )* ( subAttrAssign )* ( portAssign[des, $instName.text] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:364:4: ^( SUBINST_DECL ( width )? instName= IDENT desName= IDENT ( infoDecl )* ( subAttrAssign )* ( portAssign[des, $instName.text] )* )
            {
            match(input,SUBINST_DECL,FOLLOW_SUBINST_DECL_in_subInstDecl287); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:364:19: ( width )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==WIDTH) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:364:19: width
                    {
                    pushFollow(FOLLOW_width_in_subInstDecl289);
                    width6=width();

                    state._fsp--;


                    }
                    break;

            }

            instName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_subInstDecl294); 
            desName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_subInstDecl298); 
            	SubDesign subDes = getSubDesignByName((desName!=null?desName.getText():null));
            			if (subDes == null)
            				bailOut(instName, "subdesign " + (desName!=null?desName.getText():null) + " is undeclared");
            			if (width6 == null || width6.size() == 1) {
            				SubInstance s = new SubInstance(subDes);
            				s.setName((instName!=null?instName.getText():null));
            				s.setDesign(subDes);
            				setLocation(s, instName);
            				if (width6 != null)
            					s.setIndex(width6.get(0));
            				
            				// check for duplicates
            				if (!des.addSubInst(s))
            					addError(instName, "duplicate subdesign instance declaration");
            			
            			} else {
            				for (int j = 0; j < width6.size(); j ++) {
            					SubInstance s = new SubInstance(subDes);
            					s.setName((instName!=null?instName.getText():null));
            					s.setDesign(subDes);
            					setLocation(s, instName);
            					s.setIndex(width6.get(j));
            	
            					// check for duplicates
            					if (!des.addSubInst(s))
            						addError(instName, "duplicate subdesign instance declaration");
            				}
            			} 
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:396:3: ( infoDecl )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==INFO_DECL) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:396:4: infoDecl
            	    {
            	    pushFollow(FOLLOW_infoDecl_in_subInstDecl312);
            	    infoDecl7=infoDecl();

            	    state._fsp--;

            	    	List<SubInstance> subs = des.getSubInstances();
            	    				if ((infoDecl7!=null?infoDecl7.indices:null) == null) {
            	    					for (SubInstance s : subs)
            	    						s.appendInfo((infoDecl7!=null?infoDecl7.info:null).getText());
            	    				} else {
            	    					// iterate over the indices in the array list declaration
            	    					for (Integer index : (infoDecl7!=null?infoDecl7.indices:null)) {
            	    						// search for the instance with this index
            	    						SubInstance s = null;
            	    						for (SubInstance sub : subs)
            	    							if (index == sub.getIndex()) 
            	    								s = sub;
            	    						
            	    						if (s != null) {
            	    							s.appendInfo((infoDecl7!=null?infoDecl7.info:null).getText());
            	    						// the instance referenced by the index doesn't exist
            	    						} else
            	    							addWarning((infoDecl7!=null?infoDecl7.info:null), "subdesign instance index (" + index + 
            	    								") does not exist for information declaration");
            	    					}
            	    				}
            	    			

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:421:3: ( subAttrAssign )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==SUBATTR_ASSIGN) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:421:3: subAttrAssign
            	    {
            	    pushFollow(FOLLOW_subAttrAssign_in_subInstDecl330);
            	    subAttrAssign();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:421:18: ( portAssign[des, $instName.text] )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==CONNECT_ASSIGN) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:421:18: portAssign[des, $instName.text]
            	    {
            	    pushFollow(FOLLOW_portAssign_in_subInstDecl333);
            	    portAssign(des, (instName!=null?instName.getText():null));

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            match(input, Token.UP, null); 
            	// check for duplicates based solely on the raw instance name
            			if (!instNames.add((instName!=null?instName.getText():null)))
            				addError(instName, "duplicate instance name exists in design unit");
            		

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
    // $ANTLR end "subInstDecl"


    // $ANTLR start "subAttrAssign"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:430:1: subAttrAssign : ^( SUBATTR_ASSIGN ( NEWATTR )? ( index )? ( name )* IDENT STRING ) ;
    public final void subAttrAssign() throws RecognitionException {
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:431:2: ( ^( SUBATTR_ASSIGN ( NEWATTR )? ( index )? ( name )* IDENT STRING ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:431:4: ^( SUBATTR_ASSIGN ( NEWATTR )? ( index )? ( name )* IDENT STRING )
            {
            match(input,SUBATTR_ASSIGN,FOLLOW_SUBATTR_ASSIGN_in_subAttrAssign357); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:431:21: ( NEWATTR )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==NEWATTR) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:431:21: NEWATTR
                    {
                    match(input,NEWATTR,FOLLOW_NEWATTR_in_subAttrAssign359); 

                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:431:30: ( index )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=BOUNDS && LA13_0<=INDICES)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:431:30: index
                    {
                    pushFollow(FOLLOW_index_in_subAttrAssign362);
                    index();

                    state._fsp--;


                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:431:37: ( name )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==NAME) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:431:37: name
            	    {
            	    pushFollow(FOLLOW_name_in_subAttrAssign365);
            	    name();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            match(input,IDENT,FOLLOW_IDENT_in_subAttrAssign368); 
            match(input,STRING,FOLLOW_STRING_in_subAttrAssign370); 

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
    // $ANTLR end "subAttrAssign"


    // $ANTLR start "portAssign"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:433:1: portAssign[DesignUnit des, String subInstName] : ^( CONNECT_ASSIGN ( COMBINE )? ( index )? operand concatenation[des] ) ;
    public final void portAssign(DesignUnit des, String subInstName) throws RecognitionException {
        List<Integer> index8 = null;

        PhdlAST.operand_return operand9 = null;


        boolean isCombined = false;
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:435:2: ( ^( CONNECT_ASSIGN ( COMBINE )? ( index )? operand concatenation[des] ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:435:4: ^( CONNECT_ASSIGN ( COMBINE )? ( index )? operand concatenation[des] )
            {
            match(input,CONNECT_ASSIGN,FOLLOW_CONNECT_ASSIGN_in_portAssign389); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:435:21: ( COMBINE )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==COMBINE) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:435:22: COMBINE
                    {
                    match(input,COMBINE,FOLLOW_COMBINE_in_portAssign392); 
                    isCombined = true;

                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:435:53: ( index )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=BOUNDS && LA16_0<=INDICES)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:435:53: index
                    {
                    pushFollow(FOLLOW_index_in_portAssign398);
                    index8=index();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_operand_in_portAssign401);
            operand9=operand();

            state._fsp--;

            pushFollow(FOLLOW_concatenation_in_portAssign403);
            concatenation(des);

            state._fsp--;


            match(input, Token.UP, null); 
            	// check for duplicate qualifier indices
            			Set<Integer> indices = new HashSet<Integer>();
            			if (index8 != null) {
            				for (Integer i : index8)
            					if (!indices.add(i))
            						bailOut((operand9!=null?operand9.id:null), "duplicate instance qualifier index");
            			}

            			// gather the relevant subdesign instances in a list
            			List<SubInstance> subInsts = new ArrayList<SubInstance>();
            			if (index8 == null) {
            				for (SubInstance subInst : des.getSubInstancesByName(subInstName))
            					subInsts.add(subInst);
            			} else {
            				for (Integer i : index8) {
            					SubInstance subInst = des.getSubInstance(subInstName, i);
            					if (subInst == null)
            						bailOut((operand9!=null?operand9.id:null), "invalid instance qualifier index (" + i + ")");
            					else
            						subInsts.add(subInst);
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
    // $ANTLR end "portAssign"


    // $ANTLR start "groupDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:464:1: groupDecl[DesignUnit des] : ^( GROUP_DECL groupName= STRING ( infoDecl | portDecl[des] | netDecl[des] | instDecl[des, $groupName.text] | netAssign[des] )* ) ;
    public final void groupDecl(DesignUnit des) throws RecognitionException {
        CommonTree groupName=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:465:2: ( ^( GROUP_DECL groupName= STRING ( infoDecl | portDecl[des] | netDecl[des] | instDecl[des, $groupName.text] | netAssign[des] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:465:4: ^( GROUP_DECL groupName= STRING ( infoDecl | portDecl[des] | netDecl[des] | instDecl[des, $groupName.text] | netAssign[des] )* )
            {
            match(input,GROUP_DECL,FOLLOW_GROUP_DECL_in_groupDecl426); 

            match(input, Token.DOWN, null); 
            groupName=(CommonTree)match(input,STRING,FOLLOW_STRING_in_groupDecl430); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:466:2: ( infoDecl | portDecl[des] | netDecl[des] | instDecl[des, $groupName.text] | netAssign[des] )*
            loop17:
            do {
                int alt17=6;
                switch ( input.LA(1) ) {
                case INFO_DECL:
                    {
                    alt17=1;
                    }
                    break;
                case PORT_DECL:
                    {
                    alt17=2;
                    }
                    break;
                case NET_DECL:
                    {
                    alt17=3;
                    }
                    break;
                case INST_DECL:
                    {
                    alt17=4;
                    }
                    break;
                case NET_ASSIGN:
                    {
                    alt17=5;
                    }
                    break;

                }

                switch (alt17) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:466:4: infoDecl
            	    {
            	    pushFollow(FOLLOW_infoDecl_in_groupDecl436);
            	    infoDecl();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:467:4: portDecl[des]
            	    {
            	    pushFollow(FOLLOW_portDecl_in_groupDecl441);
            	    portDecl(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:468:4: netDecl[des]
            	    {
            	    pushFollow(FOLLOW_netDecl_in_groupDecl447);
            	    netDecl(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 4 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:469:4: instDecl[des, $groupName.text]
            	    {
            	    pushFollow(FOLLOW_instDecl_in_groupDecl453);
            	    instDecl(des, (groupName!=null?groupName.getText():null));

            	    state._fsp--;


            	    }
            	    break;
            	case 5 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:470:4: netAssign[des]
            	    {
            	    pushFollow(FOLLOW_netAssign_in_groupDecl459);
            	    netAssign(des);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // $ANTLR end "groupDecl"


    // $ANTLR start "portDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:474:1: portDecl[DesignUnit subDes] : ^( PORT_DECL ( width )? (portName= IDENT )* ) ;
    public final void portDecl(DesignUnit subDes) throws RecognitionException {
        CommonTree portName=null;
        List<Integer> width10 = null;


        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:475:2: ( ^( PORT_DECL ( width )? (portName= IDENT )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:475:4: ^( PORT_DECL ( width )? (portName= IDENT )* )
            {
            match(input,PORT_DECL,FOLLOW_PORT_DECL_in_portDecl479); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:475:16: ( width )?
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==WIDTH) ) {
                    alt18=1;
                }
                switch (alt18) {
                    case 1 :
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:475:16: width
                        {
                        pushFollow(FOLLOW_width_in_portDecl481);
                        width10=width();

                        state._fsp--;


                        }
                        break;

                }

                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:475:23: (portName= IDENT )*
                loop19:
                do {
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==IDENT) ) {
                        alt19=1;
                    }


                    switch (alt19) {
                	case 1 :
                	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:475:24: portName= IDENT
                	    {
                	    portName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_portDecl487); 
                	    	if (subDes instanceof Design)
                	    				bailOut(portName, "ports are only allowed in subdesigns");
                	    			if (width10 == null || width10.size() == 1) {
                	    				Port p = new Port(subDes);
                	    				p.setName((portName!=null?portName.getText():null));
                	    				setLocation(p, portName);
                	    				if (width10 != null)
                	    					p.setIndex(width10.get(0));
                	    				if(!subDes.addPort(p));
                	    					addError(portName, "duplicate port declaration");
                	    			} else {
                	    				for (int i = 0; i < width10.size(); i++) {
                	    					Port p = new Port(subDes);
                	    					p.setName((portName!=null?portName.getText():null));
                	    					p.setIndex(width10.get(i));
                	    					if (!subDes.addPort(p))
                	    						addError(portName, "duplicate port declaration");
                	    				}
                	    			}
                	    			// check for duplicates based soley on the name of the port
                	    			if (!portNames.add((portName!=null?portName.getText():null)))
                	    				addError(portName, "duplicate port declaration");
                	    		

                	    }
                	    break;

                	default :
                	    break loop19;
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
    // $ANTLR end "portDecl"


    // $ANTLR start "netDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:502:1: netDecl[DesignUnit des] : ^( NET_DECL ( width )? (netName= IDENT )* ( attrDecl[nets] )* ) ;
    public final void netDecl(DesignUnit des) throws RecognitionException {
        CommonTree netName=null;
        List<Integer> width11 = null;


        List<Attributable> nets = new ArrayList<Attributable>();
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:504:2: ( ^( NET_DECL ( width )? (netName= IDENT )* ( attrDecl[nets] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:504:4: ^( NET_DECL ( width )? (netName= IDENT )* ( attrDecl[nets] )* )
            {
            match(input,NET_DECL,FOLLOW_NET_DECL_in_netDecl515); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:504:15: ( width )?
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==WIDTH) ) {
                    alt20=1;
                }
                switch (alt20) {
                    case 1 :
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:504:15: width
                        {
                        pushFollow(FOLLOW_width_in_netDecl517);
                        width11=width();

                        state._fsp--;


                        }
                        break;

                }

                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:504:22: (netName= IDENT )*
                loop21:
                do {
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==IDENT) ) {
                        alt21=1;
                    }


                    switch (alt21) {
                	case 1 :
                	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:504:23: netName= IDENT
                	    {
                	    netName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netDecl523); 
                	    	// make new nets for each name
                	    				if (width11 == null || width11.size() == 1) {
                	    					Net n = new Net(des);
                	    					n.setName((netName!=null?netName.getText():null));
                	    					setLocation(n, netName);
                	    					if (width11 != null)
                	    						n.setIndex(width11.get(0));
                	    					if (!des.addNet(n)) 
                	    						addError(netName, "duplicate net declaration");
                	    					nets.add(n);
                	    				} else {
                	    					for (int i = 0; i < width11.size(); i++) {
                	    						Net n = new Net(des);
                	    						n.setName((netName!=null?netName.getText():null));
                	    						n.setIndex(width11.get(i));
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
                	    break loop21;
                    }
                } while (true);

                // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:533:3: ( attrDecl[nets] )*
                loop22:
                do {
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==ATTR_DECL) ) {
                        alt22=1;
                    }


                    switch (alt22) {
                	case 1 :
                	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:533:3: attrDecl[nets]
                	    {
                	    pushFollow(FOLLOW_attrDecl_in_netDecl543);
                	    attrDecl(nets);

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop22;
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:536:1: instDecl[DesignUnit des, String groupName] : ^( INST_DECL ( width )? instName= IDENT devName= IDENT ( infoDecl )* ( attrAssign[des, $instName.text] )* ( pinAssign[des, $instName.text] )* ) ;
    public final void instDecl(DesignUnit des, String groupName) throws RecognitionException {
        CommonTree instName=null;
        CommonTree devName=null;
        List<Integer> width12 = null;

        PhdlAST.infoDecl_return infoDecl13 = null;


        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:537:2: ( ^( INST_DECL ( width )? instName= IDENT devName= IDENT ( infoDecl )* ( attrAssign[des, $instName.text] )* ( pinAssign[des, $instName.text] )* ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:537:4: ^( INST_DECL ( width )? instName= IDENT devName= IDENT ( infoDecl )* ( attrAssign[des, $instName.text] )* ( pinAssign[des, $instName.text] )* )
            {
            match(input,INST_DECL,FOLLOW_INST_DECL_in_instDecl560); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:537:16: ( width )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==WIDTH) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:537:16: width
                    {
                    pushFollow(FOLLOW_width_in_instDecl562);
                    width12=width();

                    state._fsp--;


                    }
                    break;

            }

            instName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl567); 
            devName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl571); 
            	Device dev = getDevice((devName!=null?devName.getText():null));
            			if (dev == null)
            				bailOut(instName, "instance references undeclared device");
            			if (width12 == null || width12.size() == 1) {
            				Instance i = new Instance(des);
            				i.setName((instName!=null?instName.getText():null));
            				i.setDevice(dev);
            				setLocation(i, instName);
            				i.setGroupName(groupName);
            				if (width12 != null)
            					i.setIndex(width12.get(0));
            				// copy all of the attribute and pin nodes from the device
            				for (Attribute a: dev.getAttributes())
            					i.addAttribute(new Attribute(a, i));
            				for (Pin p: dev.getPins())
            					i.addPin(new Pin(p, i));
            				// check for duplicates
            				if (!des.addInstance(i))
            					addError(instName, "duplicate instance declaration");
            			
            			} else {
            				for (int j = 0; j < width12.size(); j ++) {
            					Instance i = new Instance(des);
            					i.setName((instName!=null?instName.getText():null));
            					i.setDevice(dev);
            					setLocation(i, instName);
            					i.setGroupName(groupName);
            					i.setIndex(width12.get(j));
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
            		
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:579:3: ( infoDecl )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==INFO_DECL) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:579:4: infoDecl
            	    {
            	    pushFollow(FOLLOW_infoDecl_in_instDecl587);
            	    infoDecl13=infoDecl();

            	    state._fsp--;

            	    	List<Instance> insts = des.getInstancesByName((instName!=null?instName.getText():null));
            	    				if ((infoDecl13!=null?infoDecl13.indices:null) == null) {
            	    					for (Instance i : insts)
            	    						i.appendInfo((infoDecl13!=null?infoDecl13.info:null).getText());
            	    				} else {
            	    					// iterate over the indices in the array list declaration
            	    					for (Integer index : (infoDecl13!=null?infoDecl13.indices:null)) {
            	    						// search for the instance with this index
            	    						Instance i = null;
            	    						for (Instance inst : insts)
            	    							if (index == inst.getIndex()) 
            	    								i = inst;
            	    						
            	    						if (i != null) {
            	    							i.appendInfo((infoDecl13!=null?infoDecl13.info:null).getText());
            	    						// the instance referenced by the index doesn't exist
            	    						} else
            	    							addWarning((infoDecl13!=null?infoDecl13.info:null), "instance index (" + index + ") does not exist");
            	    					}
            	    				}
            	    			

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:603:3: ( attrAssign[des, $instName.text] )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==ATTR_ASSIGN) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:603:3: attrAssign[des, $instName.text]
            	    {
            	    pushFollow(FOLLOW_attrAssign_in_instDecl605);
            	    attrAssign(des, (instName!=null?instName.getText():null));

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:603:36: ( pinAssign[des, $instName.text] )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==CONNECT_ASSIGN) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:603:36: pinAssign[des, $instName.text]
            	    {
            	    pushFollow(FOLLOW_pinAssign_in_instDecl609);
            	    pinAssign(des, (instName!=null?instName.getText():null));

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            match(input, Token.UP, null); 
            	// check for duplicates based solely on the raw instance name
            			if (!instNames.add((instName!=null?instName.getText():null)))
            				addError(instName, "duplicate instance name exists in design unit");
            		

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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:611:1: attrAssign[DesignUnit des, String instName] : ^( ATTR_ASSIGN ( NEWATTR )? ( index )? attrName= IDENT attrValue= STRING ) ;
    public final void attrAssign(DesignUnit des, String instName) throws RecognitionException {
        CommonTree attrName=null;
        CommonTree attrValue=null;
        List<Integer> index14 = null;


        boolean newAttr = false;
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:613:2: ( ^( ATTR_ASSIGN ( NEWATTR )? ( index )? attrName= IDENT attrValue= STRING ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:613:4: ^( ATTR_ASSIGN ( NEWATTR )? ( index )? attrName= IDENT attrValue= STRING )
            {
            match(input,ATTR_ASSIGN,FOLLOW_ATTR_ASSIGN_in_attrAssign637); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:613:18: ( NEWATTR )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==NEWATTR) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:613:19: NEWATTR
                    {
                    match(input,NEWATTR,FOLLOW_NEWATTR_in_attrAssign640); 
                    newAttr = true;

                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:613:47: ( index )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=BOUNDS && LA28_0<=INDICES)) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:613:47: index
                    {
                    pushFollow(FOLLOW_index_in_attrAssign646);
                    index14=index();

                    state._fsp--;


                    }
                    break;

            }

            attrName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attrAssign651); 
            attrValue=(CommonTree)match(input,STRING,FOLLOW_STRING_in_attrAssign655); 

            match(input, Token.UP, null); 
            	
            			// a list of all candidate instances from the design
            			List<Instance> insts = des.getInstancesByName(instName);
            			
            			// process all instances (global attribute)
            			if (index14 == null) {
            				for (Instance i : insts) {
            					Attribute a = i.getAttribute((attrName!=null?attrName.getText():null));
            					if (a != null) {
            						if (newAttr)
            							addError(attrName, "new attribute already declared");
            						if (!a.overwrite((attrValue!=null?attrValue.getText():null)))
            							addWarning(attrName, "attribute already overwritten");
            					} else if (newAttr) {
            						Attribute newA = new Attribute(i);
            						newA.setName((attrName!=null?attrName.getText():null));
            						newA.setValue((attrValue!=null?attrValue.getText():null));
            						setLocation(newA, attrName);
            						i.addAttribute(newA);
            					} else
            						addError(attrName, "undeclared attribute");
            				}
            			} else {
            				// iterate over the indices in the array list declaration
            				for (Integer index : index14) {
            					// search for the instance with this index
            					Instance inst = null;
            					for (Instance i : insts)
            						if (index == i.getIndex()) 
            							inst = i;
            					
            					if (inst != null) {
            						Attribute a = inst.getAttribute((attrName!=null?attrName.getText():null));
            						if (a != null) {
            							if (newAttr)
            								addError(attrName, "new attribute already declared");
            							if (!a.overwrite((attrValue!=null?attrValue.getText():null)))
            								addWarning(attrName, "attribute already overwritten");
            						} else if (newAttr) {
            							Attribute newA = new Attribute(inst);
            							newA.setName((attrName!=null?attrName.getText():null));
            							newA.setValue((attrValue!=null?attrValue.getText():null));
            							setLocation(newA, attrName);
            							inst.addAttribute(newA);
            						} else
            							addError(attrName, "undeclared attribute");
            					// the instance referenced by the index doesn't exist
            					} else
            						addError(attrName, "instance index (" + index + ") does not exist for attribute");
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:668:1: pinAssign[DesignUnit des, String instName] : ^( CONNECT_ASSIGN ( COMBINE )? ( index )? operand concatenation[des] ) ;
    public final void pinAssign(DesignUnit des, String instName) throws RecognitionException {
        List<Integer> index15 = null;

        PhdlAST.operand_return operand16 = null;

        PhdlAST.concatenation_return concatenation17 = null;


        boolean isCombined = false;
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:670:2: ( ^( CONNECT_ASSIGN ( COMBINE )? ( index )? operand concatenation[des] ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:670:4: ^( CONNECT_ASSIGN ( COMBINE )? ( index )? operand concatenation[des] )
            {
            match(input,CONNECT_ASSIGN,FOLLOW_CONNECT_ASSIGN_in_pinAssign678); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:670:21: ( COMBINE )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==COMBINE) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:670:22: COMBINE
                    {
                    match(input,COMBINE,FOLLOW_COMBINE_in_pinAssign681); 
                    isCombined = true;

                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:670:53: ( index )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=BOUNDS && LA30_0<=INDICES)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:670:53: index
                    {
                    pushFollow(FOLLOW_index_in_pinAssign687);
                    index15=index();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_operand_in_pinAssign690);
            operand16=operand();

            state._fsp--;

            pushFollow(FOLLOW_concatenation_in_pinAssign692);
            concatenation17=concatenation(des);

            state._fsp--;


            match(input, Token.UP, null); 
            	
            			// check for duplicate qualifier indices
            			Set<Integer> indices = new HashSet<Integer>();
            			if (index15 != null) {
            				for (Integer i : index15)
            					if (!indices.add(i))
            						bailOut((operand16!=null?operand16.id:null), "duplicate instance qualifier index");
            			}

            			// gather the relevant instances in a list
            			List<Instance> insts = new ArrayList<Instance>();
            			if (index15 == null) {
            				for (Instance inst : des.getInstancesByName(instName))
            					insts.add(inst);
            			} else {
            				for (Integer i : index15) {
            					Instance inst = des.getInstance(instName, i);
            					if (inst == null)
            						bailOut((operand16!=null?operand16.id:null), "invalid instance qualifier index (" + i + ")");
            					else
            						insts.add(inst);
            				}
            			}
            			
            			// list of pins to assign nets to
            			List<Pin> pins = new ArrayList<Pin>();
            			
            			if (isCombined) {
            				if ((operand16!=null?operand16.indices:null) == null) {
            					for (Instance inst : insts)
            						pins.addAll(inst.getAllPins((operand16!=null?operand16.id:null).getText()));
            					if (pins.size() == 0)
            						bailOut((operand16!=null?operand16.id:null), "undeclared pin");
            				} else {
            					for (Instance inst : insts) {
            						for (Integer i : (operand16!=null?operand16.indices:null)) {
            							Pin p = inst.getPin((operand16!=null?operand16.id:null).getText(), i);
            							if (p == null)
            								bailOut((operand16!=null?operand16.id:null), "undeclared pin or invalid pin slice [" + i + "]");
            							else
            								pins.add(p);
            						}
            					}
            				}

            				for (int i = 0; i < pins.size(); i++) {
            					if (pins.get(i).hasNet()) {
            						String index = (pins.get(i).getIndex() == -1)?("pin"):("slice [" + pins.get(i).getIndex() + "] of pin");
            						bailOut((operand16!=null?operand16.id:null), index + " is already assigned");
            					} else if (pins.get(i).isOpen()) {
            						String index = (pins.get(i).getIndex() == -1)?("pin"):("slice [" + pins.get(i).getIndex() + "] of pin");
            						bailOut((operand16!=null?operand16.id:null), index + " is already open");
            					} else if ((concatenation17!=null?concatenation17.isReplicated:false)) {
            						pins.get(i).setNet((concatenation17!=null?concatenation17.nets:null).get(0));
            						(concatenation17!=null?concatenation17.nets:null).get(0).addPin(pins.get(i));
            					} else if ((concatenation17!=null?concatenation17.isOpen:false)) {
            						pins.get(i).setOpen(true);
            					} else {
            						// check for width mismatch
            						if (pins.size() != (concatenation17!=null?concatenation17.nets:null).size()) {
            							bailOut((operand16!=null?operand16.id:null), "pin assignment left size [" + pins.size() + 
            								"] does not match right size [" + (concatenation17!=null?concatenation17.nets:null).size() + "]");
            						}	
            						pins.get(i).setNet((concatenation17!=null?concatenation17.nets:null).get(i));
            						(concatenation17!=null?concatenation17.nets:null).get(i).addPin(pins.get(i));
            					}
            				}
            				
            			// assignment is not a combine operation
            			} else {
            				for (Instance inst : insts) {
            					if ((operand16!=null?operand16.indices:null) == null) {
            						pins.addAll(inst.getAllPins((operand16!=null?operand16.id:null).getText()));
            						if (pins.size() == 0)
            							bailOut((operand16!=null?operand16.id:null), "undeclared pin");
            					} else {
            						for (Integer i : (operand16!=null?operand16.indices:null)) {
            							Pin p = inst.getPin((operand16!=null?operand16.id:null).getText(), i);
            							if (p == null)
            								bailOut((operand16!=null?operand16.id:null), "undeclared pin or invalid pin slice [" + i + "]");
            							else
            								pins.add(p);
            						}
            					}
            					
            					for (int i = 0; i < pins.size(); i++) {
            						if (pins.get(i).hasNet()) {
            							String index = (pins.get(i).getIndex() == -1)?("pin"):("slice [" + pins.get(i).getIndex() + "] of pin");
            							bailOut((operand16!=null?operand16.id:null), index + " is already assigned");
            						} else if (pins.get(i).isOpen()) {
            							String index = (pins.get(i).getIndex() == -1)?("pin"):("slice [" + pins.get(i).getIndex() + "] of pin");
            							bailOut((operand16!=null?operand16.id:null), index + " is already open");
            						} else if ((concatenation17!=null?concatenation17.isReplicated:false)) {
            							pins.get(i).setNet((concatenation17!=null?concatenation17.nets:null).get(0));
            							(concatenation17!=null?concatenation17.nets:null).get(0).addPin(pins.get(i));
            						} else if ((concatenation17!=null?concatenation17.isOpen:false)) {
            							pins.get(i).setOpen(true);
            						} else {
            							// check for width mismatch
            							if (pins.size() != (concatenation17!=null?concatenation17.nets:null).size()) {
            								bailOut((operand16!=null?operand16.id:null), "pin assignment left size [" + pins.size() + 
            									"] does not match right size [" + (concatenation17!=null?concatenation17.nets:null).size() + "]");
            							}	
            							pins.get(i).setNet((concatenation17!=null?concatenation17.nets:null).get(i));
            							(concatenation17!=null?concatenation17.nets:null).get(i).addPin(pins.get(i));
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:785:1: netAssign[DesignUnit des] : ^( NET_ASSIGN operand concatenation[des] ) ;
    public final void netAssign(DesignUnit des) throws RecognitionException {
        PhdlAST.concatenation_return concatenation18 = null;

        PhdlAST.operand_return operand19 = null;


        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:786:2: ( ^( NET_ASSIGN operand concatenation[des] ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:786:4: ^( NET_ASSIGN operand concatenation[des] )
            {
            match(input,NET_ASSIGN,FOLLOW_NET_ASSIGN_in_netAssign712); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_operand_in_netAssign714);
            operand19=operand();

            state._fsp--;

            pushFollow(FOLLOW_concatenation_in_netAssign716);
            concatenation18=concatenation(des);

            state._fsp--;


            match(input, Token.UP, null); 
            	if ((concatenation18!=null?concatenation18.isOpen:false))
            				bailOut((operand19!=null?operand19.id:null), "nets cannot be open");
            				
            			List<Net> nets = new ArrayList<Net>();
            			if ((operand19!=null?operand19.indices:null) == null) {
            				nets.addAll(des.getAllNetsByName((operand19!=null?operand19.id:null).getText()));
            			} else {
            				for (Integer i : (operand19!=null?operand19.indices:null)) {
            					Net n = des.getNet((operand19!=null?operand19.id:null).getText(), i);
            					if (n == null)
            						bailOut((operand19!=null?operand19.id:null), "undeclared net or invalid net index (" + i + ")");
            					else
            						nets.add(n);
            				}
            			}
            			
            			
            			for (int i = 0; i < nets.size(); i++) {
            				if ((concatenation18!=null?concatenation18.isReplicated:false)) {
            					nets.get(i).addNet((concatenation18!=null?concatenation18.nets:null).get(0));
            					(concatenation18!=null?concatenation18.nets:null).get(0).addNet(nets.get(i));
            				} else {
            					// check for assignment width mismatch
            					if (nets.size() != (concatenation18!=null?concatenation18.nets:null).size()) {
            						bailOut((operand19!=null?operand19.id:null), "net assignment left size [" + nets.size() + 
            							"] does not match right size [" + (concatenation18!=null?concatenation18.nets:null).size() + "]");
            					}
            					nets.get(i).addNet((concatenation18!=null?concatenation18.nets:null).get(i));
            					(concatenation18!=null?concatenation18.nets:null).get(i).addNet(nets.get(i));
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:822:1: concatenation[DesignUnit des] returns [List<Net> nets, boolean isReplicated, boolean isOpen] : ( ^( CONCAT_LIST ( operand )* ) | ^( CONCAT_REPL operand ) | ^( CONCAT_OPEN ) );
    public final PhdlAST.concatenation_return concatenation(DesignUnit des) throws RecognitionException {
        PhdlAST.concatenation_return retval = new PhdlAST.concatenation_return();
        retval.start = input.LT(1);

        PhdlAST.operand_return operand20 = null;

        PhdlAST.operand_return operand21 = null;


        retval.nets = new ArrayList<Net>();
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:834:2: ( ^( CONCAT_LIST ( operand )* ) | ^( CONCAT_REPL operand ) | ^( CONCAT_OPEN ) )
            int alt32=3;
            switch ( input.LA(1) ) {
            case CONCAT_LIST:
                {
                alt32=1;
                }
                break;
            case CONCAT_REPL:
                {
                alt32=2;
                }
                break;
            case CONCAT_OPEN:
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
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:834:4: ^( CONCAT_LIST ( operand )* )
                    {
                    match(input,CONCAT_LIST,FOLLOW_CONCAT_LIST_in_concatenation750); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:834:18: ( operand )*
                        loop31:
                        do {
                            int alt31=2;
                            int LA31_0 = input.LA(1);

                            if ( (LA31_0==OPERAND) ) {
                                alt31=1;
                            }


                            switch (alt31) {
                        	case 1 :
                        	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:834:19: operand
                        	    {
                        	    pushFollow(FOLLOW_operand_in_concatenation753);
                        	    operand20=operand();

                        	    state._fsp--;

                        	    	// for each operand, if no indices were specified, return all relevant nets from the design
                        	    				if ((operand20!=null?operand20.indices:null) == null) {
                        	    					retval.nets.addAll(des.getAllNetsByName((operand20!=null?operand20.id:null).getText()));
                        	    				
                        	    				// otherwise, only return nets with matching indices
                        	    				} else
                        	    					for (int i = 0; i < (operand20!=null?operand20.indices:null).size(); i++) {
                        	    						Net n = des.getNet((operand20!=null?operand20.id:null).getText(), (operand20!=null?operand20.indices:null).get(i));
                        	    						if (n == null) {
                        	    							if (des.getAllNetsByName((operand20!=null?operand20.id:null).getText()).size() > 0)
                        	    								bailOut((operand20!=null?operand20.id:null), "invalid net slice [" + (operand20!=null?operand20.indices:null).get(i) + "]");
                        	    							else
                        	    								bailOut((operand20!=null?operand20.id:null), "undeclared ned");
                        	    						} else
                        	    							retval.nets.add(n);
                        	    					}
                        	    			

                        	    }
                        	    break;

                        	default :
                        	    break loop31;
                            }
                        } while (true);


                        match(input, Token.UP, null); 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:855:4: ^( CONCAT_REPL operand )
                    {
                    match(input,CONCAT_REPL,FOLLOW_CONCAT_REPL_in_concatenation773); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_operand_in_concatenation775);
                    operand21=operand();

                    state._fsp--;

                    	retval.isReplicated = true;
                    				
                    				// if no indices were specified, return the relevant net from the design
                    				if ((operand21!=null?operand21.indices:null) == null) {
                    					List<Net> nets = des.getAllNetsByName((operand21!=null?operand21.id:null).getText());
                    					if (nets.size() > 1)
                    						bailOut((operand21!=null?operand21.id:null), "assignment cannot replicate a net vector");
                    					retval.nets.add(nets.get(0));
                    					
                    				// otherwise, return the net with the matching index
                    				} else {
                    					if ((operand21!=null?operand21.indices:null).size() != 1)
                    						bailOut((operand21!=null?operand21.id:null), "assignment cannot replicate a net vector");
                    					Net n = des.getNet((operand21!=null?operand21.id:null).getText(), (operand21!=null?operand21.indices:null).get(0));
                    					if (n == null) {
                    						if (des.getAllNetsByName((operand21!=null?operand21.id:null).getText()).size() > 0)
                    							bailOut((operand21!=null?operand21.id:null), "invalid net slice [" + (operand21!=null?operand21.indices:null).get(0) + "]");
                    						else	
                    							bailOut((operand21!=null?operand21.id:null), "undeclared net");
                    					} else
                    						retval.nets.add(n);
                    				}
                    			

                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:882:4: ^( CONCAT_OPEN )
                    {
                    match(input,CONCAT_OPEN,FOLLOW_CONCAT_OPEN_in_concatenation795); 

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
        public CommonTree id;
        public List<Integer> indices;
    };

    // $ANTLR start "operand"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:885:1: operand returns [CommonTree id, List<Integer> indices] : ^( OPERAND val= IDENT ( index )? ) ;
    public final PhdlAST.operand_return operand() throws RecognitionException {
        PhdlAST.operand_return retval = new PhdlAST.operand_return();
        retval.start = input.LT(1);

        CommonTree val=null;
        List<Integer> index22 = null;


        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:889:2: ( ^( OPERAND val= IDENT ( index )? ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:889:4: ^( OPERAND val= IDENT ( index )? )
            {
            match(input,OPERAND,FOLLOW_OPERAND_in_operand816); 

            match(input, Token.DOWN, null); 
            val=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_operand820); 
            retval.id = val;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:889:38: ( index )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=BOUNDS && LA33_0<=INDICES)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:889:39: index
                    {
                    pushFollow(FOLLOW_index_in_operand825);
                    index22=index();

                    state._fsp--;

                    retval.indices = index22;

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

    public static class name_return extends TreeRuleReturnScope {
        public CommonTree id;
        public List<Integer> indices;
    };

    // $ANTLR start "name"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:892:1: name returns [CommonTree id, List<Integer> indices] : ^( NAME val= IDENT ( index )? ) ;
    public final PhdlAST.name_return name() throws RecognitionException {
        PhdlAST.name_return retval = new PhdlAST.name_return();
        retval.start = input.LT(1);

        CommonTree val=null;
        List<Integer> index23 = null;


        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:896:2: ( ^( NAME val= IDENT ( index )? ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:896:4: ^( NAME val= IDENT ( index )? )
            {
            match(input,NAME,FOLLOW_NAME_in_name848); 

            match(input, Token.DOWN, null); 
            val=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_name852); 
            retval.id = val;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:896:35: ( index )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=BOUNDS && LA34_0<=INDICES)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:896:36: index
                    {
                    pushFollow(FOLLOW_index_in_name857);
                    index23=index();

                    state._fsp--;

                    retval.indices = index23;

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
    // $ANTLR end "name"


    // $ANTLR start "index"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:899:1: index returns [List<Integer> indices] : ( ^( BOUNDS hi= INT lo= INT ) | ^( INDICES (idx= INT )+ ) );
    public final List<Integer> index() throws RecognitionException {
        List<Integer> indices = null;

        CommonTree hi=null;
        CommonTree lo=null;
        CommonTree idx=null;

        indices = new ArrayList<Integer>();
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:906:2: ( ^( BOUNDS hi= INT lo= INT ) | ^( INDICES (idx= INT )+ ) )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==BOUNDS) ) {
                alt36=1;
            }
            else if ( (LA36_0==INDICES) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:906:4: ^( BOUNDS hi= INT lo= INT )
                    {
                    match(input,BOUNDS,FOLLOW_BOUNDS_in_index884); 

                    match(input, Token.DOWN, null); 
                    hi=(CommonTree)match(input,INT,FOLLOW_INT_in_index888); 
                    lo=(CommonTree)match(input,INT,FOLLOW_INT_in_index892); 

                    match(input, Token.UP, null); 
                    	int msb = Integer.parseInt((hi!=null?hi.getText():null));
                    			int lsb = Integer.parseInt((lo!=null?lo.getText():null));
                    			if (msb < lsb)
                    				for (int i = msb; i <= lsb; i++)
                    					indices.add(i);
                    			else
                    				for (int i = msb; i >= lsb; i--)
                    					indices.add(i);
                    		

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:916:4: ^( INDICES (idx= INT )+ )
                    {
                    match(input,INDICES,FOLLOW_INDICES_in_index903); 

                    match(input, Token.DOWN, null); 
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:916:14: (idx= INT )+
                    int cnt35=0;
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==INT) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:916:15: idx= INT
                    	    {
                    	    idx=(CommonTree)match(input,INT,FOLLOW_INT_in_index908); 
                    	    indices.add(Integer.parseInt((idx!=null?idx.getText():null)));

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt35 >= 1 ) break loop35;
                                EarlyExitException eee =
                                    new EarlyExitException(35, input);
                                throw eee;
                        }
                        cnt35++;
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
    // $ANTLR end "index"


    // $ANTLR start "width"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:919:1: width returns [List<Integer> indices] : ^( WIDTH hi= INT lo= INT ) ;
    public final List<Integer> width() throws RecognitionException {
        List<Integer> indices = null;

        CommonTree hi=null;
        CommonTree lo=null;

        indices = new ArrayList<Integer>();
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:921:2: ( ^( WIDTH hi= INT lo= INT ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:921:4: ^( WIDTH hi= INT lo= INT )
            {
            match(input,WIDTH,FOLLOW_WIDTH_in_width934); 

            match(input, Token.DOWN, null); 
            hi=(CommonTree)match(input,INT,FOLLOW_INT_in_width938); 
            lo=(CommonTree)match(input,INT,FOLLOW_INT_in_width942); 

            match(input, Token.UP, null); 
            	int msb = Integer.parseInt((hi!=null?hi.getText():null));
            			int lsb = Integer.parseInt((lo!=null?lo.getText():null));
            			if (msb < lsb)
            				for (int i = msb; i <= lsb; i++)
            					indices.add(i);
            			else
            				for (int i = msb; i >= lsb; i--)
            					indices.add(i);
            		

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
    // $ANTLR end "width"


    // $ANTLR start "pinList"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:933:1: pinList returns [List<String> list] : ^( PIN_LIST (num1= INT | num2= IDENT | num3= PINNUM )+ ) ;
    public final List<String> pinList() throws RecognitionException {
        List<String> list = null;

        CommonTree num1=null;
        CommonTree num2=null;
        CommonTree num3=null;

        list = new ArrayList<String>();
        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:935:2: ( ^( PIN_LIST (num1= INT | num2= IDENT | num3= PINNUM )+ ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:935:4: ^( PIN_LIST (num1= INT | num2= IDENT | num3= PINNUM )+ )
            {
            match(input,PIN_LIST,FOLLOW_PIN_LIST_in_pinList967); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:936:2: (num1= INT | num2= IDENT | num3= PINNUM )+
            int cnt37=0;
            loop37:
            do {
                int alt37=4;
                switch ( input.LA(1) ) {
                case INT:
                    {
                    alt37=1;
                    }
                    break;
                case IDENT:
                    {
                    alt37=2;
                    }
                    break;
                case PINNUM:
                    {
                    alt37=3;
                    }
                    break;

                }

                switch (alt37) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:936:4: num1= INT
            	    {
            	    num1=(CommonTree)match(input,INT,FOLLOW_INT_in_pinList974); 
            	    list.add((num1!=null?num1.getText():null));

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:937:4: num2= IDENT
            	    {
            	    num2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinList983); 
            	    list.add((num2!=null?num2.getText():null));

            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:938:4: num3= PINNUM
            	    {
            	    num3=(CommonTree)match(input,PINNUM,FOLLOW_PINNUM_in_pinList992); 
            	    list.add((num3!=null?num3.getText():null));

            	    }
            	    break;

            	default :
            	    if ( cnt37 >= 1 ) break loop37;
                        EarlyExitException eee =
                            new EarlyExitException(37, input);
                        throw eee;
                }
                cnt37++;
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
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:942:1: pinType returns [PinType type] : ^( PIN_TYPE ( PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN ) ) ;
    public final PinType pinType() throws RecognitionException {
        PinType type = null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:943:2: ( ^( PIN_TYPE ( PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN ) ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:943:4: ^( PIN_TYPE ( PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN ) )
            {
            match(input,PIN_TYPE,FOLLOW_PIN_TYPE_in_pinType1016); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:944:2: ( PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN )
            int alt38=6;
            switch ( input.LA(1) ) {
            case PIN:
                {
                alt38=1;
                }
                break;
            case INPIN:
                {
                alt38=2;
                }
                break;
            case OUTPIN:
                {
                alt38=3;
                }
                break;
            case IOPIN:
                {
                alt38=4;
                }
                break;
            case PWRPIN:
                {
                alt38=5;
                }
                break;
            case SUPPIN:
                {
                alt38=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:944:4: PIN
                    {
                    match(input,PIN,FOLLOW_PIN_in_pinType1022); 
                    type = PinType.PIN;

                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:945:4: INPIN
                    {
                    match(input,INPIN,FOLLOW_INPIN_in_pinType1030); 
                    type = PinType.INPIN;

                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:946:4: OUTPIN
                    {
                    match(input,OUTPIN,FOLLOW_OUTPIN_in_pinType1037); 
                    type = PinType.OUTPIN;

                    }
                    break;
                case 4 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:947:4: IOPIN
                    {
                    match(input,IOPIN,FOLLOW_IOPIN_in_pinType1044); 
                    type = PinType.IOPIN;

                    }
                    break;
                case 5 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:948:4: PWRPIN
                    {
                    match(input,PWRPIN,FOLLOW_PWRPIN_in_pinType1051); 
                    type = PinType.PWRPIN;

                    }
                    break;
                case 6 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:949:4: SUPPIN
                    {
                    match(input,SUPPIN,FOLLOW_SUPPIN_in_pinType1058); 
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

    public static class infoDecl_return extends TreeRuleReturnScope {
        public CommonTree info;
        public List<Integer> indices;
    };

    // $ANTLR start "infoDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:952:1: infoDecl returns [CommonTree info, List<Integer> indices] : ^( INFO_DECL ( index )? (st= STRING )+ ) ;
    public final PhdlAST.infoDecl_return infoDecl() throws RecognitionException {
        PhdlAST.infoDecl_return retval = new PhdlAST.infoDecl_return();
        retval.start = input.LT(1);

        CommonTree st=null;
        List<Integer> index24 = null;


        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:953:2: ( ^( INFO_DECL ( index )? (st= STRING )+ ) )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:953:5: ^( INFO_DECL ( index )? (st= STRING )+ )
            {
            match(input,INFO_DECL,FOLLOW_INFO_DECL_in_infoDecl1080); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:953:17: ( index )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=BOUNDS && LA39_0<=INDICES)) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:953:17: index
                    {
                    pushFollow(FOLLOW_index_in_infoDecl1082);
                    index24=index();

                    state._fsp--;


                    }
                    break;

            }

            retval.indices = index24;
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:954:3: (st= STRING )+
            int cnt40=0;
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==STRING) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\PhdlAST.g:954:4: st= STRING
            	    {
            	    st=(CommonTree)match(input,STRING,FOLLOW_STRING_in_infoDecl1093); 
            	    retval.info = st;

            	    }
            	    break;

            	default :
            	    if ( cnt40 >= 1 ) break loop40;
                        EarlyExitException eee =
                            new EarlyExitException(40, input);
                        throw eee;
                }
                cnt40++;
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
        return retval;
    }
    // $ANTLR end "infoDecl"

    // Delegated rules


 

    public static final BitSet FOLLOW_deviceDecl_in_sourceText60 = new BitSet(new long[]{0x0000380000000002L});
    public static final BitSet FOLLOW_designDecl_in_sourceText64 = new BitSet(new long[]{0x0000380000000002L});
    public static final BitSet FOLLOW_DEVICE_DECL_in_deviceDecl79 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl83 = new BitSet(new long[]{0x0020C00000000008L});
    public static final BitSet FOLLOW_infoDecl_in_deviceDecl97 = new BitSet(new long[]{0x0020C00000000008L});
    public static final BitSet FOLLOW_attrDecl_in_deviceDecl110 = new BitSet(new long[]{0x0000C00000000008L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl114 = new BitSet(new long[]{0x0000800000000008L});
    public static final BitSet FOLLOW_ATTR_DECL_in_attrDecl132 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_attrDecl136 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_STRING_in_attrDecl140 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PIN_DECL_in_pinDecl161 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl165 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_pinType_in_pinDecl167 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_width_in_pinDecl169 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_pinList_in_pinDecl172 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DESIGN_DECL_in_designDecl196 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SUBDESIGN_DECL_in_designDecl200 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_designDecl206 = new BitSet(new long[]{0x023F000000000008L});
    public static final BitSet FOLLOW_netDecl_in_designDecl220 = new BitSet(new long[]{0x023F000000000008L});
    public static final BitSet FOLLOW_instDecl_in_designDecl226 = new BitSet(new long[]{0x023F000000000008L});
    public static final BitSet FOLLOW_netAssign_in_designDecl232 = new BitSet(new long[]{0x023F000000000008L});
    public static final BitSet FOLLOW_groupDecl_in_designDecl238 = new BitSet(new long[]{0x023F000000000008L});
    public static final BitSet FOLLOW_subInstDecl_in_designDecl244 = new BitSet(new long[]{0x023F000000000008L});
    public static final BitSet FOLLOW_portDecl_in_designDecl250 = new BitSet(new long[]{0x023F000000000008L});
    public static final BitSet FOLLOW_infoDecl_in_designDecl258 = new BitSet(new long[]{0x023F000000000008L});
    public static final BitSet FOLLOW_SUBINST_DECL_in_subInstDecl287 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_width_in_subInstDecl289 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_subInstDecl294 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_subInstDecl298 = new BitSet(new long[]{0x01A0000000000008L});
    public static final BitSet FOLLOW_infoDecl_in_subInstDecl312 = new BitSet(new long[]{0x01A0000000000008L});
    public static final BitSet FOLLOW_subAttrAssign_in_subInstDecl330 = new BitSet(new long[]{0x0180000000000008L});
    public static final BitSet FOLLOW_portAssign_in_subInstDecl333 = new BitSet(new long[]{0x0100000000000008L});
    public static final BitSet FOLLOW_SUBATTR_ASSIGN_in_subAttrAssign357 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NEWATTR_in_subAttrAssign359 = new BitSet(new long[]{0x0000000000000000L,0x000000000000001BL});
    public static final BitSet FOLLOW_index_in_subAttrAssign362 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_name_in_subAttrAssign365 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_IDENT_in_subAttrAssign368 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_STRING_in_subAttrAssign370 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONNECT_ASSIGN_in_portAssign389 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_COMBINE_in_portAssign392 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_index_in_portAssign398 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_operand_in_portAssign401 = new BitSet(new long[]{0x1C00000000000000L});
    public static final BitSet FOLLOW_concatenation_in_portAssign403 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GROUP_DECL_in_groupDecl426 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_groupDecl430 = new BitSet(new long[]{0x0227000000000008L});
    public static final BitSet FOLLOW_infoDecl_in_groupDecl436 = new BitSet(new long[]{0x0227000000000008L});
    public static final BitSet FOLLOW_portDecl_in_groupDecl441 = new BitSet(new long[]{0x0227000000000008L});
    public static final BitSet FOLLOW_netDecl_in_groupDecl447 = new BitSet(new long[]{0x0227000000000008L});
    public static final BitSet FOLLOW_instDecl_in_groupDecl453 = new BitSet(new long[]{0x0227000000000008L});
    public static final BitSet FOLLOW_netAssign_in_groupDecl459 = new BitSet(new long[]{0x0227000000000008L});
    public static final BitSet FOLLOW_PORT_DECL_in_portDecl479 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_width_in_portDecl481 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_portDecl487 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000010L});
    public static final BitSet FOLLOW_NET_DECL_in_netDecl515 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_width_in_netDecl517 = new BitSet(new long[]{0x0000400000000008L,0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl523 = new BitSet(new long[]{0x0000400000000008L,0x0000000000000010L});
    public static final BitSet FOLLOW_attrDecl_in_netDecl543 = new BitSet(new long[]{0x0000400000000008L});
    public static final BitSet FOLLOW_INST_DECL_in_instDecl560 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_width_in_instDecl562 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instDecl567 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_instDecl571 = new BitSet(new long[]{0x0160000000000008L});
    public static final BitSet FOLLOW_infoDecl_in_instDecl587 = new BitSet(new long[]{0x0160000000000008L});
    public static final BitSet FOLLOW_attrAssign_in_instDecl605 = new BitSet(new long[]{0x0140000000000008L});
    public static final BitSet FOLLOW_pinAssign_in_instDecl609 = new BitSet(new long[]{0x0100000000000008L});
    public static final BitSet FOLLOW_ATTR_ASSIGN_in_attrAssign637 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NEWATTR_in_attrAssign640 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000013L});
    public static final BitSet FOLLOW_index_in_attrAssign646 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attrAssign651 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_STRING_in_attrAssign655 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONNECT_ASSIGN_in_pinAssign678 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_COMBINE_in_pinAssign681 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_index_in_pinAssign687 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_operand_in_pinAssign690 = new BitSet(new long[]{0x1C00000000000000L});
    public static final BitSet FOLLOW_concatenation_in_pinAssign692 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NET_ASSIGN_in_netAssign712 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operand_in_netAssign714 = new BitSet(new long[]{0x1C00000000000000L});
    public static final BitSet FOLLOW_concatenation_in_netAssign716 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONCAT_LIST_in_concatenation750 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operand_in_concatenation753 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000007L});
    public static final BitSet FOLLOW_CONCAT_REPL_in_concatenation773 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operand_in_concatenation775 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONCAT_OPEN_in_concatenation795 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_OPERAND_in_operand816 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_operand820 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000003L});
    public static final BitSet FOLLOW_index_in_operand825 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NAME_in_name848 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_name852 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000003L});
    public static final BitSet FOLLOW_index_in_name857 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BOUNDS_in_index884 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_index888 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_index892 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INDICES_in_index903 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_index908 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000040L});
    public static final BitSet FOLLOW_WIDTH_in_width934 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_width938 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_width942 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PIN_LIST_in_pinList967 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_pinList974 = new BitSet(new long[]{0x0000000000000008L,0x00000000000000D0L});
    public static final BitSet FOLLOW_IDENT_in_pinList983 = new BitSet(new long[]{0x0000000000000008L,0x00000000000000D0L});
    public static final BitSet FOLLOW_PINNUM_in_pinList992 = new BitSet(new long[]{0x0000000000000008L,0x00000000000000D0L});
    public static final BitSet FOLLOW_PIN_TYPE_in_pinType1016 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PIN_in_pinType1022 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INPIN_in_pinType1030 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OUTPIN_in_pinType1037 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IOPIN_in_pinType1044 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PWRPIN_in_pinType1051 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SUPPIN_in_pinType1058 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INFO_DECL_in_infoDecl1080 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_index_in_infoDecl1082 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_STRING_in_infoDecl1093 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000020L});

}