// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g 2012-01-02 15:28:41

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SEMICOLON", "COLON", "COMMA", "PERIOD", "EQUALS", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "LANGLE", "RANGLE", "AMPERSAND", "DBLQUOTE", "DESIGN", "DEVICE", "SUBDESIGN", "INST", "SUBINST", "GROUP", "THIS", "OF", "NET", "ATTR", "NEWATTR", "BEGIN", "END", "COMBINE", "INCLUDE", "PIN", "INPIN", "OUTPIN", "IOPIN", "PWRPIN", "SUPPIN", "WIDTH_DECL", "DEVICE_DECL", "ATTR_DECL", "PIN_DECL", "PIN_LIST", "PIN_TYPE", "IDENT", "STRING", "INT", "PINNUM", "D", "E", "S", "I", "G", "N", "V", "C", "U", "B", "T", "R", "O", "P", "H", "F", "A", "W", "M", "L", "CHAR", "DIGIT", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "INCLUDE_DECL", "J", "K", "Q", "X", "Y", "Z"
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
    public static final int PINNUM=49;
    public static final int D=50;
    public static final int E=51;
    public static final int S=52;
    public static final int I=53;
    public static final int G=54;
    public static final int N=55;
    public static final int V=56;
    public static final int C=57;
    public static final int U=58;
    public static final int B=59;
    public static final int T=60;
    public static final int R=61;
    public static final int O=62;
    public static final int P=63;
    public static final int H=64;
    public static final int F=65;
    public static final int A=66;
    public static final int W=67;
    public static final int M=68;
    public static final int L=69;
    public static final int CHAR=70;
    public static final int DIGIT=71;
    public static final int WHITESPACE=72;
    public static final int LINE_COMMENT=73;
    public static final int MULTILINE_COMMENT=74;
    public static final int INCLUDE_DECL=75;
    public static final int J=76;
    public static final int K=77;
    public static final int Q=78;
    public static final int X=79;
    public static final int Y=80;
    public static final int Z=81;

    // delegates
    // delegators


        public PhdlWalker2(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public PhdlWalker2(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PhdlWalker2.tokenNames; }
    public String getGrammarFileName() { return "C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g"; }



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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:205:1: sourceText : ( deviceDecl )+ ;
    public final void sourceText() throws RecognitionException {
        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:206:2: ( ( deviceDecl )+ )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:206:4: ( deviceDecl )+
            {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:206:4: ( deviceDecl )+
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
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:206:5: deviceDecl
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:209:1: deviceDecl : ^( DEVICE_DECL devName= IDENT ( attrDecl[dev] | pinDecl[dev] )* ) ;
    public final void deviceDecl() throws RecognitionException {
        CommonTree devName=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:210:2: ( ^( DEVICE_DECL devName= IDENT ( attrDecl[dev] | pinDecl[dev] )* ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:210:4: ^( DEVICE_DECL devName= IDENT ( attrDecl[dev] | pinDecl[dev] )* )
            {
            match(input,DEVICE_DECL,FOLLOW_DEVICE_DECL_in_deviceDecl75); 

            match(input, Token.DOWN, null); 
            devName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl79); 
            	// make a new device node
            			Device dev = new Device((devName!=null?devName.getText():null));
            			dev.setLocation((devName!=null?devName.getLine():0), (devName!=null?devName.getCharPositionInLine():0), 
            					devName.getToken().getInputStream().getSourceName());
            			// check for duplicate device declarations
            			if (!devices.add(dev)) 
            				addError(devName, "Duplicate device declaration");
            			
            			// clear these sets each time a device is processed
            			pinNames.clear();
            		
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:224:3: ( attrDecl[dev] | pinDecl[dev] )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==ATTR_DECL) ) {
                    alt2=1;
                }
                else if ( (LA2_0==PIN_DECL) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:224:4: attrDecl[dev]
            	    {
            	    pushFollow(FOLLOW_attrDecl_in_deviceDecl93);
            	    attrDecl(dev);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:224:20: pinDecl[dev]
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl98);
            	    pinDecl(dev);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            match(input, Token.UP, null); 
            	// report any missing required attributes
            			for (String s : reqAttrs) {
            				s = s.toUpperCase();
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:235:1: attrDecl[Attributable parent] : ^( ATTR_DECL attrName= IDENT attrValue= STRING ) ;
    public final void attrDecl(Attributable parent) throws RecognitionException {
        CommonTree attrName=null;
        CommonTree attrValue=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:236:2: ( ^( ATTR_DECL attrName= IDENT attrValue= STRING ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:236:4: ^( ATTR_DECL attrName= IDENT attrValue= STRING )
            {
            match(input,ATTR_DECL,FOLLOW_ATTR_DECL_in_attrDecl124); 

            match(input, Token.DOWN, null); 
            attrName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attrDecl128); 
            attrValue=(CommonTree)match(input,STRING,FOLLOW_STRING_in_attrDecl132); 

            match(input, Token.UP, null); 
            	// make a new attribute node, assign its parent, and log its location
            	   		Attribute a  = new Attribute(parent);
            	   		a.setName((attrName!=null?attrName.getText():null));
            			a.setValue((attrValue!=null?attrValue.getText():null));
            	   		a.setLocation((attrName!=null?attrName.getLine():0), (attrName!=null?attrName.getCharPositionInLine():0), 
            	   			attrName.getToken().getInputStream().getSourceName());
            	   			
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:258:1: pinDecl[Device dev] : ^( PIN_DECL pinName= IDENT pinType ( widthDecl )? pinList ) ;
    public final void pinDecl(Device dev) throws RecognitionException {
        CommonTree pinName=null;
        PhdlWalker2.widthDecl_return widthDecl1 = null;

        List<String> pinList2 = null;

        PinType pinType3 = null;


        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:259:2: ( ^( PIN_DECL pinName= IDENT pinType ( widthDecl )? pinList ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:259:4: ^( PIN_DECL pinName= IDENT pinType ( widthDecl )? pinList )
            {
            boolean hasWidth = false;
            match(input,PIN_DECL,FOLLOW_PIN_DECL_in_pinDecl160); 

            match(input, Token.DOWN, null); 
            pinName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinDecl164); 
            pushFollow(FOLLOW_pinType_in_pinDecl166);
            pinType3=pinType();

            state._fsp--;

            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:261:36: ( widthDecl )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==WIDTH_DECL) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:261:37: widthDecl
                    {
                    pushFollow(FOLLOW_widthDecl_in_pinDecl169);
                    widthDecl1=widthDecl();

                    state._fsp--;

                    hasWidth = true;

                    }
                    break;

            }

            pushFollow(FOLLOW_pinList_in_pinDecl175);
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
            				p.setLocation((pinName!=null?pinName.getLine():0), (pinName!=null?pinName.getCharPositionInLine():0), 
            					pinName.getToken().getInputStream().getSourceName());
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
            						p.setLocation((pinName!=null?pinName.getLine():0), (pinName!=null?pinName.getCharPositionInLine():0),
            							pinName.getToken().getInputStream().getSourceName());
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
            						p.setLocation((pinName!=null?pinName.getLine():0), (pinName!=null?pinName.getCharPositionInLine():0),
            							pinName.getToken().getInputStream().getSourceName());
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

    public static class widthDecl_return extends TreeRuleReturnScope {
        public int msb;
        public int lsb;
        public int width;
        public boolean downto;
    };

    // $ANTLR start "widthDecl"
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:332:1: widthDecl returns [int msb, int lsb, int width, boolean downto] : ^( WIDTH_DECL hi= INT lo= INT ) ;
    public final PhdlWalker2.widthDecl_return widthDecl() throws RecognitionException {
        PhdlWalker2.widthDecl_return retval = new PhdlWalker2.widthDecl_return();
        retval.start = input.LT(1);

        CommonTree hi=null;
        CommonTree lo=null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:333:2: ( ^( WIDTH_DECL hi= INT lo= INT ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:333:4: ^( WIDTH_DECL hi= INT lo= INT )
            {
            match(input,WIDTH_DECL,FOLLOW_WIDTH_DECL_in_widthDecl200); 

            match(input, Token.DOWN, null); 
            hi=(CommonTree)match(input,INT,FOLLOW_INT_in_widthDecl204); 
            lo=(CommonTree)match(input,INT,FOLLOW_INT_in_widthDecl208); 

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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:341:1: pinList returns [List<String> list] : ^( PIN_LIST (num1= INT | num2= IDENT | num3= PINNUM )+ ) ;
    public final List<String> pinList() throws RecognitionException {
        List<String> list = null;

        CommonTree num1=null;
        CommonTree num2=null;
        CommonTree num3=null;

        list = new ArrayList<String>();
        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:343:2: ( ^( PIN_LIST (num1= INT | num2= IDENT | num3= PINNUM )+ ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:343:4: ^( PIN_LIST (num1= INT | num2= IDENT | num3= PINNUM )+ )
            {
            match(input,PIN_LIST,FOLLOW_PIN_LIST_in_pinList233); 

            match(input, Token.DOWN, null); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:344:2: (num1= INT | num2= IDENT | num3= PINNUM )+
            int cnt4=0;
            loop4:
            do {
                int alt4=4;
                switch ( input.LA(1) ) {
                case INT:
                    {
                    alt4=1;
                    }
                    break;
                case IDENT:
                    {
                    alt4=2;
                    }
                    break;
                case PINNUM:
                    {
                    alt4=3;
                    }
                    break;

                }

                switch (alt4) {
            	case 1 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:344:4: num1= INT
            	    {
            	    num1=(CommonTree)match(input,INT,FOLLOW_INT_in_pinList240); 
            	    list.add((num1!=null?num1.getText():null));

            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:345:4: num2= IDENT
            	    {
            	    num2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinList249); 
            	    list.add((num2!=null?num2.getText():null));

            	    }
            	    break;
            	case 3 :
            	    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:346:4: num3= PINNUM
            	    {
            	    num3=(CommonTree)match(input,PINNUM,FOLLOW_PINNUM_in_pinList258); 
            	    list.add((num3!=null?num3.getText():null));

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
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
    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:350:1: pinType returns [PinType type] : ^( PIN_TYPE ( PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN ) ) ;
    public final PinType pinType() throws RecognitionException {
        PinType type = null;

        try {
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:351:2: ( ^( PIN_TYPE ( PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN ) ) )
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:351:4: ^( PIN_TYPE ( PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN ) )
            {
            match(input,PIN_TYPE,FOLLOW_PIN_TYPE_in_pinType282); 

            match(input, Token.DOWN, null); 
            // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:352:2: ( PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN )
            int alt5=6;
            switch ( input.LA(1) ) {
            case PIN:
                {
                alt5=1;
                }
                break;
            case INPIN:
                {
                alt5=2;
                }
                break;
            case OUTPIN:
                {
                alt5=3;
                }
                break;
            case IOPIN:
                {
                alt5=4;
                }
                break;
            case PWRPIN:
                {
                alt5=5;
                }
                break;
            case SUPPIN:
                {
                alt5=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:352:4: PIN
                    {
                    match(input,PIN,FOLLOW_PIN_in_pinType288); 
                    type = PinType.PIN;

                    }
                    break;
                case 2 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:353:4: INPIN
                    {
                    match(input,INPIN,FOLLOW_INPIN_in_pinType296); 
                    type = PinType.INPIN;

                    }
                    break;
                case 3 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:354:4: OUTPIN
                    {
                    match(input,OUTPIN,FOLLOW_OUTPIN_in_pinType303); 
                    type = PinType.OUTPIN;

                    }
                    break;
                case 4 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:355:4: IOPIN
                    {
                    match(input,IOPIN,FOLLOW_IOPIN_in_pinType310); 
                    type = PinType.IOPIN;

                    }
                    break;
                case 5 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:356:4: PWRPIN
                    {
                    match(input,PWRPIN,FOLLOW_PWRPIN_in_pinType317); 
                    type = PinType.PWRPIN;

                    }
                    break;
                case 6 :
                    // C:\\work\\phdl\\src\\phdl\\grammar\\PhdlWalker2.g:357:4: SUPPIN
                    {
                    match(input,SUPPIN,FOLLOW_SUPPIN_in_pinType324); 
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
    public static final BitSet FOLLOW_IDENT_in_deviceDecl79 = new BitSet(new long[]{0x00000C0000000008L});
    public static final BitSet FOLLOW_attrDecl_in_deviceDecl93 = new BitSet(new long[]{0x00000C0000000008L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl98 = new BitSet(new long[]{0x00000C0000000008L});
    public static final BitSet FOLLOW_ATTR_DECL_in_attrDecl124 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_attrDecl128 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_STRING_in_attrDecl132 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PIN_DECL_in_pinDecl160 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl164 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_pinType_in_pinDecl166 = new BitSet(new long[]{0x0000110000000000L});
    public static final BitSet FOLLOW_widthDecl_in_pinDecl169 = new BitSet(new long[]{0x0000110000000000L});
    public static final BitSet FOLLOW_pinList_in_pinDecl175 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WIDTH_DECL_in_widthDecl200 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_widthDecl204 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_INT_in_widthDecl208 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PIN_LIST_in_pinList233 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_pinList240 = new BitSet(new long[]{0x0003400000000008L});
    public static final BitSet FOLLOW_IDENT_in_pinList249 = new BitSet(new long[]{0x0003400000000008L});
    public static final BitSet FOLLOW_PINNUM_in_pinList258 = new BitSet(new long[]{0x0003400000000008L});
    public static final BitSet FOLLOW_PIN_TYPE_in_pinType282 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PIN_in_pinType288 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INPIN_in_pinType296 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OUTPIN_in_pinType303 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IOPIN_in_pinType310 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PWRPIN_in_pinType317 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SUPPIN_in_pinType324 = new BitSet(new long[]{0x0000000000000008L});

}