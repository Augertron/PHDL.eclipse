// $ANTLR 3.3 Nov 30, 2010 12:50:56 D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g 2012-01-04 08:34:02

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SEMICOLON", "COLON", "COMMA", "PERIOD", "EQUALS", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "LANGLE", "RANGLE", "AMPERSAND", "DBLQUOTE", "DESIGN", "DEVICE", "SUBDESIGN", "INST", "SUBINST", "GROUP", "THIS", "OF", "NET", "ATTR", "NEWATTR", "BEGIN", "END", "COMBINE", "INCLUDE", "INFO", "PIN", "INPIN", "OUTPIN", "IOPIN", "PWRPIN", "SUPPIN", "WIDTH_DECL", "ARRAY_DECL", "DEVICE_DECL", "ATTR_DECL", "PIN_DECL", "PIN_LIST", "PIN_TYPE", "INFO_DECL", "NET_DECL", "NAME_DECL", "DESIGN_DECL", "INST_DECL", "ATTR_ASSIGN", "ATTR_QUAL", "PIN_ASSIGN", "LIST_ARRAY", "LIST_SLICE", "IDENT", "STRING", "INT", "PINNUM", "D", "E", "S", "I", "G", "N", "V", "C", "U", "B", "T", "R", "O", "P", "H", "F", "A", "W", "M", "L", "CHAR", "DIGIT", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "INCLUDE_DECL", "J", "K", "Q", "X", "Y", "Z"
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
    public static final int PIN=35;
    public static final int INPIN=36;
    public static final int OUTPIN=37;
    public static final int IOPIN=38;
    public static final int PWRPIN=39;
    public static final int SUPPIN=40;
    public static final int WIDTH_DECL=41;
    public static final int ARRAY_DECL=42;
    public static final int DEVICE_DECL=43;
    public static final int ATTR_DECL=44;
    public static final int PIN_DECL=45;
    public static final int PIN_LIST=46;
    public static final int PIN_TYPE=47;
    public static final int INFO_DECL=48;
    public static final int NET_DECL=49;
    public static final int NAME_DECL=50;
    public static final int DESIGN_DECL=51;
    public static final int INST_DECL=52;
    public static final int ATTR_ASSIGN=53;
    public static final int ATTR_QUAL=54;
    public static final int PIN_ASSIGN=55;
    public static final int LIST_ARRAY=56;
    public static final int LIST_SLICE=57;
    public static final int IDENT=58;
    public static final int STRING=59;
    public static final int INT=60;
    public static final int PINNUM=61;
    public static final int D=62;
    public static final int E=63;
    public static final int S=64;
    public static final int I=65;
    public static final int G=66;
    public static final int N=67;
    public static final int V=68;
    public static final int C=69;
    public static final int U=70;
    public static final int B=71;
    public static final int T=72;
    public static final int R=73;
    public static final int O=74;
    public static final int P=75;
    public static final int H=76;
    public static final int F=77;
    public static final int A=78;
    public static final int W=79;
    public static final int M=80;
    public static final int L=81;
    public static final int CHAR=82;
    public static final int DIGIT=83;
    public static final int WHITESPACE=84;
    public static final int LINE_COMMENT=85;
    public static final int MULTILINE_COMMENT=86;
    public static final int INCLUDE_DECL=87;
    public static final int J=88;
    public static final int K=89;
    public static final int Q=90;
    public static final int X=91;
    public static final int Y=92;
    public static final int Z=93;

    // delegates
    // delegators


        public PhdlWalker2(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public PhdlWalker2(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PhdlWalker2.tokenNames; }
    public String getGrammarFileName() { return "D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g"; }



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
    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:218:1: sourceText : ( deviceDecl | designDecl )+ ;
    public final void sourceText() throws RecognitionException {
        try {
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:219:2: ( ( deviceDecl | designDecl )+ )
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:219:4: ( deviceDecl | designDecl )+
            {
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:219:4: ( deviceDecl | designDecl )+
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
            	    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:219:5: deviceDecl
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_sourceText60);
            	    deviceDecl();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:219:18: designDecl
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
    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:222:1: deviceDecl : ^( DEVICE_DECL devName= IDENT ( infoDecl )* ( attrDecl[devs] )* ( pinDecl[dev] )* ) ;
    public final void deviceDecl() throws RecognitionException {
        CommonTree devName=null;

        try {
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:223:2: ( ^( DEVICE_DECL devName= IDENT ( infoDecl )* ( attrDecl[devs] )* ( pinDecl[dev] )* ) )
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:223:4: ^( DEVICE_DECL devName= IDENT ( infoDecl )* ( attrDecl[devs] )* ( pinDecl[dev] )* )
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
            		
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:240:3: ( infoDecl )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==INFO_DECL) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:240:3: infoDecl
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

            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:240:13: ( attrDecl[devs] )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==ATTR_DECL) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:240:13: attrDecl[devs]
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

            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:240:29: ( pinDecl[dev] )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==PIN_DECL) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:240:29: pinDecl[dev]
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
    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:250:1: attrDecl[List<Attributable> parents] : ^( ATTR_DECL attrName= IDENT attrValue= STRING ) ;
    public final void attrDecl(List<Attributable> parents) throws RecognitionException {
        CommonTree attrName=null;
        CommonTree attrValue=null;

        try {
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:251:2: ( ^( ATTR_DECL attrName= IDENT attrValue= STRING ) )
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:251:4: ^( ATTR_DECL attrName= IDENT attrValue= STRING )
            {
            match(input,ATTR_DECL,FOLLOW_ATTR_DECL_in_attrDecl128); 

            match(input, Token.DOWN, null); 
            attrName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attrDecl132); 
            attrValue=(CommonTree)match(input,STRING,FOLLOW_STRING_in_attrDecl136); 

            match(input, Token.UP, null); 
            	for (Attributable parent : parents) {
            				// make a new attribute node, assign its parent, and log its location
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
    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:274:1: pinDecl[Device dev] : ^( PIN_DECL pinName= IDENT pinType ( widthDecl )? pinList ) ;
    public final void pinDecl(Device dev) throws RecognitionException {
        CommonTree pinName=null;
        PhdlWalker2.widthDecl_return widthDecl1 = null;

        List<String> pinList2 = null;

        PinType pinType3 = null;


        try {
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:275:2: ( ^( PIN_DECL pinName= IDENT pinType ( widthDecl )? pinList ) )
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:275:4: ^( PIN_DECL pinName= IDENT pinType ( widthDecl )? pinList )
            {
            boolean hasWidth = false;
            match(input,PIN_DECL,FOLLOW_PIN_DECL_in_pinDecl164); 

            match(input, Token.DOWN, null); 
            pinName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinDecl168); 
            pushFollow(FOLLOW_pinType_in_pinDecl170);
            pinType3=pinType();

            state._fsp--;

            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:277:36: ( widthDecl )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==WIDTH_DECL) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:277:37: widthDecl
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
            					p.setPinNumber(pinList2.get(0));
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
            							p.setPinNumber(pinList2.get((widthDecl1!=null?widthDecl1.msb:0) - i));
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
            							p.setPinNumber(pinList2.get(i));
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
    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:345:1: designDecl : ^( DESIGN_DECL desName= IDENT ( infoDecl | netDecl[des] | instDecl[des, null] )* ) ;
    public final void designDecl() throws RecognitionException {
        CommonTree desName=null;

        try {
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:346:2: ( ^( DESIGN_DECL desName= IDENT ( infoDecl | netDecl[des] | instDecl[des, null] )* ) )
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:346:4: ^( DESIGN_DECL desName= IDENT ( infoDecl | netDecl[des] | instDecl[des, null] )* )
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
            		
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:356:2: ( infoDecl | netDecl[des] | instDecl[des, null] )*
            loop6:
            do {
                int alt6=4;
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

                }

                switch (alt6) {
            	case 1 :
            	    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:356:4: infoDecl
            	    {
            	    pushFollow(FOLLOW_infoDecl_in_designDecl213);
            	    infoDecl();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:357:4: netDecl[des]
            	    {
            	    pushFollow(FOLLOW_netDecl_in_designDecl218);
            	    netDecl(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:358:4: instDecl[des, null]
            	    {
            	    pushFollow(FOLLOW_instDecl_in_designDecl224);
            	    instDecl(des, null);

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
    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:362:1: netDecl[Design des] : ^( NET_DECL ( widthDecl )? (netName= IDENT )* ( attrDecl[nets] )* ) ;
    public final void netDecl(Design des) throws RecognitionException {
        CommonTree netName=null;
        PhdlWalker2.widthDecl_return widthDecl4 = null;


        try {
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:363:2: ( ^( NET_DECL ( widthDecl )? (netName= IDENT )* ( attrDecl[nets] )* ) )
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:363:4: ^( NET_DECL ( widthDecl )? (netName= IDENT )* ( attrDecl[nets] )* )
            {
            match(input,NET_DECL,FOLLOW_NET_DECL_in_netDecl244); 

            	boolean hasWidth = false;
            			List<Attributable> nets = new ArrayList<Attributable>();
            		

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:368:3: ( widthDecl )?
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==WIDTH_DECL) ) {
                    alt7=1;
                }
                switch (alt7) {
                    case 1 :
                        // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:368:4: widthDecl
                        {
                        pushFollow(FOLLOW_widthDecl_in_netDecl256);
                        widthDecl4=widthDecl();

                        state._fsp--;

                        hasWidth = true;

                        }
                        break;

                }

                // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:368:35: (netName= IDENT )*
                loop8:
                do {
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==IDENT) ) {
                        alt8=1;
                    }


                    switch (alt8) {
                	case 1 :
                	    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:368:36: netName= IDENT
                	    {
                	    netName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netDecl265); 
                	    	// make new nets for each name
                	    				if (!hasWidth || (widthDecl4!=null?widthDecl4.width:0) == 1) {
                	    					Net n = new Net(des);
                	    					n.setName((netName!=null?netName.getText():null));
                	    					setLocation(n, netName);
                	    					if (hasWidth)
                	    						n.setIndex((widthDecl4!=null?widthDecl4.msb:0));
                	    					if (!des.addNet(n) || !netNames.add((netName!=null?netName.getText():null))) 
                	    						addError(netName, "duplicate net declaration");
                	    					nets.add(n);
                	    				} else if ((widthDecl4!=null?widthDecl4.downto:false)) {
                	    					for (int i = (widthDecl4!=null?widthDecl4.msb:0); i >= (widthDecl4!=null?widthDecl4.lsb:0); i--) {
                	    						Net n = new Net(des);
                	    						n.setName((netName!=null?netName.getText():null));
                	    						setLocation(n, netName);
                	    						n.setIndex(i);
                	    						if (!des.addNet(n) || !netNames.add((netName!=null?netName.getText():null) + i)) 
                	    							addError(netName, "duplicate net declaration");
                	    						nets.add(n);
                	    					}
                	    				} else {
                	    					for (int i = (widthDecl4!=null?widthDecl4.msb:0); i <= (widthDecl4!=null?widthDecl4.lsb:0); i++) {
                	    						Net n = new Net(des);
                	    						n.setName((netName!=null?netName.getText():null));
                	    						setLocation(n, netName);
                	    						n.setIndex(i);
                	    						if (!des.addNet(n) || !netNames.add((netName!=null?netName.getText():null) + i)) 
                	    							addError(netName, "duplicate net declaration");
                	    						nets.add(n);
                	    					}
                	    				}
                	    			

                	    }
                	    break;

                	default :
                	    break loop8;
                    }
                } while (true);

                // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:404:3: ( attrDecl[nets] )*
                loop9:
                do {
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==ATTR_DECL) ) {
                        alt9=1;
                    }


                    switch (alt9) {
                	case 1 :
                	    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:404:3: attrDecl[nets]
                	    {
                	    pushFollow(FOLLOW_attrDecl_in_netDecl283);
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
    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:407:1: instDecl[Design des, String groupName] : ^( INST_DECL ( widthDecl )? instName= IDENT devName= IDENT ( infoDecl )* ( attrAssign[des, $instName.text] )* ) ;
    public final void instDecl(Design des, String groupName) throws RecognitionException {
        CommonTree instName=null;
        CommonTree devName=null;
        PhdlWalker2.widthDecl_return widthDecl5 = null;


        try {
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:408:2: ( ^( INST_DECL ( widthDecl )? instName= IDENT devName= IDENT ( infoDecl )* ( attrAssign[des, $instName.text] )* ) )
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:408:4: ^( INST_DECL ( widthDecl )? instName= IDENT devName= IDENT ( infoDecl )* ( attrAssign[des, $instName.text] )* )
            {
            boolean hasWidth = false;
            match(input,INST_DECL,FOLLOW_INST_DECL_in_instDecl304); 

            match(input, Token.DOWN, null); 
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:409:15: ( widthDecl )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==WIDTH_DECL) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:409:16: widthDecl
                    {
                    pushFollow(FOLLOW_widthDecl_in_instDecl307);
                    widthDecl5=widthDecl();

                    state._fsp--;

                    hasWidth = true;

                    }
                    break;

            }

            instName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl315); 
            devName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl319); 
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
            				if (!des.addInstance(i) || !instNames.add((instName!=null?instName.getText():null)))
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
            					if (!des.addInstance(i) || !instNames.add((instName!=null?instName.getText():null) + j))
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
            					if (!des.addInstance(i) || !instNames.add((instName!=null?instName.getText():null) + j))
            						addError(instName, "duplicate instance declaration");
            				}
            			}
            		
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:467:3: ( infoDecl )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==INFO_DECL) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:467:3: infoDecl
            	    {
            	    pushFollow(FOLLOW_infoDecl_in_instDecl333);
            	    infoDecl();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:467:13: ( attrAssign[des, $instName.text] )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==ATTR_ASSIGN) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:467:13: attrAssign[des, $instName.text]
            	    {
            	    pushFollow(FOLLOW_attrAssign_in_instDecl336);
            	    attrAssign(des, (instName!=null?instName.getText():null));

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
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
    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:470:1: attrAssign[Design des, String instName] : ^( ATTR_ASSIGN ( NEWATTR )? ( listDecl )? name= IDENT value= STRING ) ;
    public final void attrAssign(Design des, String instName) throws RecognitionException {
        CommonTree name=null;
        CommonTree value=null;

        boolean newAttr = false;
        try {
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:472:2: ( ^( ATTR_ASSIGN ( NEWATTR )? ( listDecl )? name= IDENT value= STRING ) )
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:472:4: ^( ATTR_ASSIGN ( NEWATTR )? ( listDecl )? name= IDENT value= STRING )
            {
            match(input,ATTR_ASSIGN,FOLLOW_ATTR_ASSIGN_in_attrAssign357); 

            match(input, Token.DOWN, null); 
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:472:18: ( NEWATTR )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==NEWATTR) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:472:19: NEWATTR
                    {
                    match(input,NEWATTR,FOLLOW_NEWATTR_in_attrAssign360); 
                    newAttr = true;

                    }
                    break;

            }

            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:472:47: ( listDecl )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=LIST_ARRAY && LA14_0<=LIST_SLICE)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:472:47: listDecl
                    {
                    pushFollow(FOLLOW_listDecl_in_attrAssign366);
                    listDecl();

                    state._fsp--;


                    }
                    break;

            }

            name=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attrAssign371); 
            value=(CommonTree)match(input,STRING,FOLLOW_STRING_in_attrAssign375); 

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
    // $ANTLR end "attrAssign"

    public static class listDecl_return extends TreeRuleReturnScope {
        public List<Integer> indices;
        public int msb;
        public int lsb;
        public boolean isArray;
    };

    // $ANTLR start "listDecl"
    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:475:1: listDecl returns [List<Integer> indices, int msb, int lsb, boolean isArray] : ( ^( LIST_ARRAY hi= INT lo= INT ) | ^( LIST_SLICE (index= INT )+ ) );
    public final PhdlWalker2.listDecl_return listDecl() throws RecognitionException {
        PhdlWalker2.listDecl_return retval = new PhdlWalker2.listDecl_return();
        retval.start = input.LT(1);

        CommonTree hi=null;
        CommonTree lo=null;
        CommonTree index=null;

        retval.indices = new ArrayList<Integer>();
        try {
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:477:2: ( ^( LIST_ARRAY hi= INT lo= INT ) | ^( LIST_SLICE (index= INT )+ ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==LIST_ARRAY) ) {
                alt16=1;
            }
            else if ( (LA16_0==LIST_SLICE) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:477:4: ^( LIST_ARRAY hi= INT lo= INT )
                    {
                    match(input,LIST_ARRAY,FOLLOW_LIST_ARRAY_in_listDecl397); 

                    match(input, Token.DOWN, null); 
                    hi=(CommonTree)match(input,INT,FOLLOW_INT_in_listDecl401); 
                    lo=(CommonTree)match(input,INT,FOLLOW_INT_in_listDecl405); 

                    match(input, Token.UP, null); 
                    	retval.msb = Integer.parseInt((hi!=null?hi.getText():null));
                    			retval.lsb = Integer.parseInt((lo!=null?lo.getText():null));
                    			retval.isArray = true;
                    		

                    }
                    break;
                case 2 :
                    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:482:4: ^( LIST_SLICE (index= INT )+ )
                    {
                    match(input,LIST_SLICE,FOLLOW_LIST_SLICE_in_listDecl416); 

                    match(input, Token.DOWN, null); 
                    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:482:17: (index= INT )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==INT) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:482:18: index= INT
                    	    {
                    	    index=(CommonTree)match(input,INT,FOLLOW_INT_in_listDecl421); 
                    	    retval.indices.add(Integer.parseInt((index!=null?index.getText():null)));

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt15 >= 1 ) break loop15;
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
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
        return retval;
    }
    // $ANTLR end "listDecl"

    public static class widthDecl_return extends TreeRuleReturnScope {
        public int msb;
        public int lsb;
        public int width;
        public boolean downto;
    };

    // $ANTLR start "widthDecl"
    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:486:1: widthDecl returns [int msb, int lsb, int width, boolean downto] : ^( WIDTH_DECL hi= INT lo= INT ) ;
    public final PhdlWalker2.widthDecl_return widthDecl() throws RecognitionException {
        PhdlWalker2.widthDecl_return retval = new PhdlWalker2.widthDecl_return();
        retval.start = input.LT(1);

        CommonTree hi=null;
        CommonTree lo=null;

        try {
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:487:2: ( ^( WIDTH_DECL hi= INT lo= INT ) )
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:487:4: ^( WIDTH_DECL hi= INT lo= INT )
            {
            match(input,WIDTH_DECL,FOLLOW_WIDTH_DECL_in_widthDecl445); 

            match(input, Token.DOWN, null); 
            hi=(CommonTree)match(input,INT,FOLLOW_INT_in_widthDecl449); 
            lo=(CommonTree)match(input,INT,FOLLOW_INT_in_widthDecl453); 

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
    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:495:1: pinList returns [List<String> list] : ^( PIN_LIST (num1= INT | num2= IDENT | num3= PINNUM )+ ) ;
    public final List<String> pinList() throws RecognitionException {
        List<String> list = null;

        CommonTree num1=null;
        CommonTree num2=null;
        CommonTree num3=null;

        list = new ArrayList<String>();
        try {
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:497:2: ( ^( PIN_LIST (num1= INT | num2= IDENT | num3= PINNUM )+ ) )
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:497:4: ^( PIN_LIST (num1= INT | num2= IDENT | num3= PINNUM )+ )
            {
            match(input,PIN_LIST,FOLLOW_PIN_LIST_in_pinList478); 

            match(input, Token.DOWN, null); 
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:498:2: (num1= INT | num2= IDENT | num3= PINNUM )+
            int cnt17=0;
            loop17:
            do {
                int alt17=4;
                switch ( input.LA(1) ) {
                case INT:
                    {
                    alt17=1;
                    }
                    break;
                case IDENT:
                    {
                    alt17=2;
                    }
                    break;
                case PINNUM:
                    {
                    alt17=3;
                    }
                    break;

                }

                switch (alt17) {
            	case 1 :
            	    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:498:4: num1= INT
            	    {
            	    num1=(CommonTree)match(input,INT,FOLLOW_INT_in_pinList485); 
            	    list.add((num1!=null?num1.getText():null));

            	    }
            	    break;
            	case 2 :
            	    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:499:4: num2= IDENT
            	    {
            	    num2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinList494); 
            	    list.add((num2!=null?num2.getText():null));

            	    }
            	    break;
            	case 3 :
            	    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:500:4: num3= PINNUM
            	    {
            	    num3=(CommonTree)match(input,PINNUM,FOLLOW_PINNUM_in_pinList503); 
            	    list.add((num3!=null?num3.getText():null));

            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
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
    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:504:1: pinType returns [PinType type] : ^( PIN_TYPE ( PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN ) ) ;
    public final PinType pinType() throws RecognitionException {
        PinType type = null;

        try {
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:505:2: ( ^( PIN_TYPE ( PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN ) ) )
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:505:4: ^( PIN_TYPE ( PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN ) )
            {
            match(input,PIN_TYPE,FOLLOW_PIN_TYPE_in_pinType527); 

            match(input, Token.DOWN, null); 
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:506:2: ( PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN )
            int alt18=6;
            switch ( input.LA(1) ) {
            case PIN:
                {
                alt18=1;
                }
                break;
            case INPIN:
                {
                alt18=2;
                }
                break;
            case OUTPIN:
                {
                alt18=3;
                }
                break;
            case IOPIN:
                {
                alt18=4;
                }
                break;
            case PWRPIN:
                {
                alt18=5;
                }
                break;
            case SUPPIN:
                {
                alt18=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:506:4: PIN
                    {
                    match(input,PIN,FOLLOW_PIN_in_pinType533); 
                    type = PinType.PIN;

                    }
                    break;
                case 2 :
                    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:507:4: INPIN
                    {
                    match(input,INPIN,FOLLOW_INPIN_in_pinType541); 
                    type = PinType.INPIN;

                    }
                    break;
                case 3 :
                    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:508:4: OUTPIN
                    {
                    match(input,OUTPIN,FOLLOW_OUTPIN_in_pinType548); 
                    type = PinType.OUTPIN;

                    }
                    break;
                case 4 :
                    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:509:4: IOPIN
                    {
                    match(input,IOPIN,FOLLOW_IOPIN_in_pinType555); 
                    type = PinType.IOPIN;

                    }
                    break;
                case 5 :
                    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:510:4: PWRPIN
                    {
                    match(input,PWRPIN,FOLLOW_PWRPIN_in_pinType562); 
                    type = PinType.PWRPIN;

                    }
                    break;
                case 6 :
                    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:511:4: SUPPIN
                    {
                    match(input,SUPPIN,FOLLOW_SUPPIN_in_pinType569); 
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
    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:514:1: infoDecl returns [String value] : ^( INFO_DECL (st= STRING )+ ) ;
    public final String infoDecl() throws RecognitionException {
        String value = null;

        CommonTree st=null;

        try {
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:515:2: ( ^( INFO_DECL (st= STRING )+ ) )
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:515:5: ^( INFO_DECL (st= STRING )+ )
            {
            match(input,INFO_DECL,FOLLOW_INFO_DECL_in_infoDecl591); 

            match(input, Token.DOWN, null); 
            // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:515:17: (st= STRING )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==STRING) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // D:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:515:18: st= STRING
            	    {
            	    st=(CommonTree)match(input,STRING,FOLLOW_STRING_in_infoDecl596); 
            	    value += (st!=null?st.getText():null);

            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
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


 

    public static final BitSet FOLLOW_deviceDecl_in_sourceText60 = new BitSet(new long[]{0x0008080000000002L});
    public static final BitSet FOLLOW_designDecl_in_sourceText64 = new BitSet(new long[]{0x0008080000000002L});
    public static final BitSet FOLLOW_DEVICE_DECL_in_deviceDecl79 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl83 = new BitSet(new long[]{0x0001300000000008L});
    public static final BitSet FOLLOW_infoDecl_in_deviceDecl96 = new BitSet(new long[]{0x0001300000000008L});
    public static final BitSet FOLLOW_attrDecl_in_deviceDecl99 = new BitSet(new long[]{0x0000300000000008L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl103 = new BitSet(new long[]{0x0000200000000008L});
    public static final BitSet FOLLOW_ATTR_DECL_in_attrDecl128 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_attrDecl132 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_STRING_in_attrDecl136 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PIN_DECL_in_pinDecl164 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl168 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_pinType_in_pinDecl170 = new BitSet(new long[]{0x0000420000000000L});
    public static final BitSet FOLLOW_widthDecl_in_pinDecl173 = new BitSet(new long[]{0x0000420000000000L});
    public static final BitSet FOLLOW_pinList_in_pinDecl179 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DESIGN_DECL_in_designDecl200 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_designDecl204 = new BitSet(new long[]{0x0013000000000008L});
    public static final BitSet FOLLOW_infoDecl_in_designDecl213 = new BitSet(new long[]{0x0013000000000008L});
    public static final BitSet FOLLOW_netDecl_in_designDecl218 = new BitSet(new long[]{0x0013000000000008L});
    public static final BitSet FOLLOW_instDecl_in_designDecl224 = new BitSet(new long[]{0x0013000000000008L});
    public static final BitSet FOLLOW_NET_DECL_in_netDecl244 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_widthDecl_in_netDecl256 = new BitSet(new long[]{0x0400100000000008L});
    public static final BitSet FOLLOW_IDENT_in_netDecl265 = new BitSet(new long[]{0x0400100000000008L});
    public static final BitSet FOLLOW_attrDecl_in_netDecl283 = new BitSet(new long[]{0x0000100000000008L});
    public static final BitSet FOLLOW_INST_DECL_in_instDecl304 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_widthDecl_in_instDecl307 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_IDENT_in_instDecl315 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_IDENT_in_instDecl319 = new BitSet(new long[]{0x0021000000000008L});
    public static final BitSet FOLLOW_infoDecl_in_instDecl333 = new BitSet(new long[]{0x0021000000000008L});
    public static final BitSet FOLLOW_attrAssign_in_instDecl336 = new BitSet(new long[]{0x0020000000000008L});
    public static final BitSet FOLLOW_ATTR_ASSIGN_in_attrAssign357 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NEWATTR_in_attrAssign360 = new BitSet(new long[]{0x0700000000000000L});
    public static final BitSet FOLLOW_listDecl_in_attrAssign366 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_IDENT_in_attrAssign371 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_STRING_in_attrAssign375 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIST_ARRAY_in_listDecl397 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_listDecl401 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_INT_in_listDecl405 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIST_SLICE_in_listDecl416 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_listDecl421 = new BitSet(new long[]{0x1000000000000008L});
    public static final BitSet FOLLOW_WIDTH_DECL_in_widthDecl445 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_widthDecl449 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_INT_in_widthDecl453 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PIN_LIST_in_pinList478 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_pinList485 = new BitSet(new long[]{0x3400000000000008L});
    public static final BitSet FOLLOW_IDENT_in_pinList494 = new BitSet(new long[]{0x3400000000000008L});
    public static final BitSet FOLLOW_PINNUM_in_pinList503 = new BitSet(new long[]{0x3400000000000008L});
    public static final BitSet FOLLOW_PIN_TYPE_in_pinType527 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PIN_in_pinType533 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INPIN_in_pinType541 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OUTPIN_in_pinType548 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IOPIN_in_pinType555 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PWRPIN_in_pinType562 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SUPPIN_in_pinType569 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INFO_DECL_in_infoDecl591 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_infoDecl596 = new BitSet(new long[]{0x0800000000000008L});

}