// $ANTLR 3.3 Nov 30, 2010 12:50:56 /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g 2012-03-02 10:02:59

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SEMICOLON", "COLON", "COMMA", "PERIOD", "EQUALS", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "LANGLE", "RANGLE", "AMPERSAND", "DBLQUOTE", "DESIGN", "DEVICE", "SUBDESIGN", "INST", "SUBINST", "GROUP", "THIS", "OF", "NET", "ATTR", "NEWATTR", "BEGIN", "END", "COMBINE", "INCLUDE", "INFO", "PORT", "OPEN", "PIN", "INPIN", "OUTPIN", "IOPIN", "PWRPIN", "SUPPIN", "DEVICE_DECL", "DESIGN_DECL", "SUBDESIGN_DECL", "ATTR_DECL", "PIN_DECL", "PORT_DECL", "NET_DECL", "INST_DECL", "SUBINST_DECL", "GROUP_DECL", "INFO_DECL", "ATTR_ASSIGN", "SUBATTR_ASSIGN", "PIN_ASSIGN", "PORT_ASSIGN", "CONNECT_ASSIGN", "CONCAT_LIST", "CONCAT_REPL", "CONCAT_OPEN", "WIDTH", "PIN_LIST", "PIN_TYPE", "BOUNDS", "INDICES", "OPERAND", "NAME", "IDENT", "STRING", "INT", "PINNUM", "D", "E", "S", "I", "G", "N", "V", "C", "U", "B", "T", "R", "O", "P", "H", "F", "A", "W", "M", "L", "J", "K", "Q", "X", "Y", "Z", "CHAR", "DIGIT", "ESC", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "INCLUDE_DECL"
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
    public static final int PIN_ASSIGN=56;
    public static final int PORT_ASSIGN=57;
    public static final int CONNECT_ASSIGN=58;
    public static final int CONCAT_LIST=59;
    public static final int CONCAT_REPL=60;
    public static final int CONCAT_OPEN=61;
    public static final int WIDTH=62;
    public static final int PIN_LIST=63;
    public static final int PIN_TYPE=64;
    public static final int BOUNDS=65;
    public static final int INDICES=66;
    public static final int OPERAND=67;
    public static final int NAME=68;
    public static final int IDENT=69;
    public static final int STRING=70;
    public static final int INT=71;
    public static final int PINNUM=72;
    public static final int D=73;
    public static final int E=74;
    public static final int S=75;
    public static final int I=76;
    public static final int G=77;
    public static final int N=78;
    public static final int V=79;
    public static final int C=80;
    public static final int U=81;
    public static final int B=82;
    public static final int T=83;
    public static final int R=84;
    public static final int O=85;
    public static final int P=86;
    public static final int H=87;
    public static final int F=88;
    public static final int A=89;
    public static final int W=90;
    public static final int M=91;
    public static final int L=92;
    public static final int J=93;
    public static final int K=94;
    public static final int Q=95;
    public static final int X=96;
    public static final int Y=97;
    public static final int Z=98;
    public static final int CHAR=99;
    public static final int DIGIT=100;
    public static final int ESC=101;
    public static final int WHITESPACE=102;
    public static final int LINE_COMMENT=103;
    public static final int MULTILINE_COMMENT=104;
    public static final int INCLUDE_DECL=105;

    // delegates
    // delegators


        public PhdlAST(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public PhdlAST(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PhdlAST.tokenNames; }
    public String getGrammarFileName() { return "/fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g"; }


    	
    	
    	/** The set of required attributes */
    	private Set<String> reqAttrs = new HashSet<String>();
    	
    	/** The list of errors */
    	private List<String> errors = new ArrayList<String>();
    	
    	/** The list of warnings */
    	private List<String> warnings = new ArrayList<String>();
    	
    	/** The set of all Devices is global to the project build */
    	private Set<Device> devices;
    	
    	/** The top level design */
    	private	Design topDesign;
    	
    	/** The set of subDesigns */
    	private Set<SubDesign> subDesigns;
    	
    	/** Sets to check for duplicates while processing everything */
    	private Set<String> pinNames = new HashSet<String>();
    	
    	/** port and net names */
    	private Set<String> conNames = new HashSet<String>();
    	
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
    	
    	public void setTopDesign(Design topDesign) {
    		this.topDesign = topDesign;
    	}
    	
    	public Set<SubDesign> getSubDesigns() {
    		return subDesigns;
    	}
    	
    	public void setSubDesigns(Set<SubDesign> subDesigns) {
    		this.subDesigns = subDesigns;
    	}
    	
    	public SubDesign getSubDesign(String name) {
    		for (SubDesign s : subDesigns) {
    			if (s.getName().equals(name))
    				return s;
    		}
    		return null;
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
    	
    	private void subInstAttr(SubInstance subInst, Stack<name_return> names, CommonTree attrName, CommonTree attrValue, boolean newAttr) {
    		
    		// the current name to reference either subinstances' or instances' attributes
    		name_return currName = names.pop();
    		
    		//System.out.println(currName.id.getText() + " " + attrName.getText() + " " + attrValue.getText());
    		
    		List<SubInstance> subInsts = new ArrayList<SubInstance>();
    		List<Instance> insts = new ArrayList<Instance>();
    		
    		// gather all relevant subinstances or instances
    		if (currName.indices == null) {
    			subInsts.addAll(subInst.getSubInstancesByName(currName.id.getText()));
    			insts.addAll(subInst.getInstancesByName(currName.id.getText()));
    		} else {
    			for (Integer i : currName.indices) {
    				SubInstance s = subInst.getSubInstance(currName.id.getText(), i);
    				if (s != null)
    					subInsts.add(s);
    				else {
    					Instance inst = subInst.getInstance(currName.id.getText(), i);
    					if (inst != null)
    						insts.add(inst);
    					else
    						bailOut(currName.id, "invalid subinstance or instance reference");
    				}
    			}
    		}
    			
    		// if both lists turn up empty, the current name does not reference a subinstance or instance
    		if (subInsts.isEmpty() && insts.isEmpty())
    			bailOut(currName.id, "subinstance or instance name does not exist in " + subInst.getName());
    		
    		// if the stack is empty, assign the attribute
    		if (names.isEmpty()) {
    			//System.out.println("the stack is empty:" + insts.size());
    			for (Instance i : insts) {
    				Attribute a = i.getAttribute(attrName.getText());
    				if (a != null) {
    					if (newAttr)
    						addError(attrName, "new attribute already declared");
    					if (!a.overwrite(attrValue.getText()))
    						addWarning(attrName, "attribute already overwritten");
    					setLocation(a, attrName);
    					//System.out.println(((Instance) a.getParent()).getParent().getName());
    				} else if (newAttr) {
    					Attribute newA = new Attribute(i, attrName.getText(), attrValue.getText());
    					setLocation(newA, attrName);
    					i.addAttribute(newA);
    				} else
    					addError(attrName, "undeclared attribute");
    				//System.out.print(i.getParent());
    			}
    		// otherwise go down a level of hierarchy to find the attribute to assign
    		} else {
    			if (subInsts.isEmpty())
    				bailOut(names.peek().id, "subinstance or instance name does not exist in " + subInst.getName());
    			for (SubInstance s : subInsts) {
    				//System.out.println("going down to: " + s.getNameIndex());
    				subInstAttr(s, names, attrName, attrValue, newAttr);
    				//System.out.println("coming up to: " + subInst.getNameIndex());
    			}
    		}
    		
    		names.push(currName);
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:305:1: sourceText : ( deviceDecl | designDecl )+ ;
    public final void sourceText() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:306:2: ( ( deviceDecl | designDecl )+ )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:306:4: ( deviceDecl | designDecl )+
            {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:306:4: ( deviceDecl | designDecl )+
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
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:306:5: deviceDecl
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_sourceText60);
            	    deviceDecl();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:306:18: designDecl
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:309:1: deviceDecl : ^( DEVICE_DECL devName= IDENT ( infoDecl )* ( attrDecl[devs] )* ( pinDecl[dev] )* ) ;
    public final void deviceDecl() throws RecognitionException {
        CommonTree devName=null;
        PhdlAST.infoDecl_return infoDecl1 = null;


        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:310:2: ( ^( DEVICE_DECL devName= IDENT ( infoDecl )* ( attrDecl[devs] )* ( pinDecl[dev] )* ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:310:4: ^( DEVICE_DECL devName= IDENT ( infoDecl )* ( attrDecl[devs] )* ( pinDecl[dev] )* )
            {
            match(input,DEVICE_DECL,FOLLOW_DEVICE_DECL_in_deviceDecl79); 

            match(input, Token.DOWN, null); 
            devName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl83); 
            	Device dev = new Device((devName!=null?devName.getText():null));
            			setLocation(dev, devName);
            			if (!devices.add(dev)) 
            				addError(devName, "Duplicate device declaration");
            			
            			// create a list with only one device
            			List<Attributable> devs = new ArrayList<Attributable>();
            			devs.add(dev);
            			
            			// clear the set of pin names that check for duplicates
            			pinNames.clear();
            		
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:325:3: ( infoDecl )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==INFO_DECL) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:325:4: infoDecl
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

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:327:3: ( attrDecl[devs] )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==ATTR_DECL) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:327:3: attrDecl[devs]
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

            	// report any missing required attributes
            			for(String s : reqAttrs) {
            				s = s.toUpperCase();
            				if(dev.getAttribute(s)==null)
            					addError(devName, "required attribute \"" + s + "\" missing in device");
            			}
            		
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:337:3: ( pinDecl[dev] )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==PIN_DECL) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:337:3: pinDecl[dev]
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl127);
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:342:1: attrDecl[List<Attributable> parents] : ^( ATTR_DECL attrName= IDENT attrValue= STRING ) ;
    public final void attrDecl(List<Attributable> parents) throws RecognitionException {
        CommonTree attrName=null;
        CommonTree attrValue=null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:343:2: ( ^( ATTR_DECL attrName= IDENT attrValue= STRING ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:343:4: ^( ATTR_DECL attrName= IDENT attrValue= STRING )
            {
            match(input,ATTR_DECL,FOLLOW_ATTR_DECL_in_attrDecl151); 

            match(input, Token.DOWN, null); 
            attrName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attrDecl155); 
            attrValue=(CommonTree)match(input,STRING,FOLLOW_STRING_in_attrDecl159); 

            match(input, Token.UP, null); 
            	for (Attributable p : parents) {
            				// make a new attribute node
            		   		Attribute a  = new Attribute(p, (attrName!=null?attrName.getText():null), (attrValue!=null?attrValue.getText():null));
            				setLocation(a, attrName);
            		   			
            		   		// check for duplicate attributes while adding
            				if (!p.addAttribute(a))
            					addError(attrName, "duplicate attribute declaration");
            					
            				// check if the attribute is a refprefix attribute
            				if (a.getName().equals("REFPREFIX")) {
            					// check to see if refPrefix begins with a letter
            					if (!Pattern.compile("^[A-Z,a-z]").matcher(a.getValue()).find())
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:364:1: pinDecl[Device dev] : ^( PIN_DECL pinName= IDENT pinType ( width )? pinList ) ;
    public final void pinDecl(Device dev) throws RecognitionException {
        CommonTree pinName=null;
        List<Integer> width2 = null;

        List<String> pinList3 = null;

        PinType pinType4 = null;


        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:365:2: ( ^( PIN_DECL pinName= IDENT pinType ( width )? pinList ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:365:4: ^( PIN_DECL pinName= IDENT pinType ( width )? pinList )
            {
            match(input,PIN_DECL,FOLLOW_PIN_DECL_in_pinDecl180); 

            match(input, Token.DOWN, null); 
            pinName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinDecl184); 
            pushFollow(FOLLOW_pinType_in_pinDecl186);
            pinType4=pinType();

            state._fsp--;

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:365:37: ( width )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==WIDTH) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:365:37: width
                    {
                    pushFollow(FOLLOW_width_in_pinDecl188);
                    width2=width();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_pinList_in_pinDecl191);
            pinList3=pinList();

            state._fsp--;


            match(input, Token.UP, null); 
            	// make a single pin if there is no width
            			if (width2 == null || width2.size() == 1) {
            				if (pinList3.size() != 1)
            					addError(pinName, "invalid pin list");
            				Pin p = new Pin(dev, (pinName!=null?pinName.getText():null), pinType4);
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
            					Pin p = new Pin(dev, (pinName!=null?pinName.getText():null), pinType4);
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:410:1: designDecl : ^( (desKeyword= DESIGN_DECL | SUBDESIGN_DECL ) (desName= IDENT ( groupDecl[des] | portDecl[des] | netDecl[des] | instDecl[des, null] | subInstDecl[des] | connectAssign[des] | ( infoDecl ) )* ) ) ;
    public final void designDecl() throws RecognitionException {
        CommonTree desKeyword=null;
        CommonTree desName=null;
        PhdlAST.infoDecl_return infoDecl5 = null;


        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:411:2: ( ^( (desKeyword= DESIGN_DECL | SUBDESIGN_DECL ) (desName= IDENT ( groupDecl[des] | portDecl[des] | netDecl[des] | instDecl[des, null] | subInstDecl[des] | connectAssign[des] | ( infoDecl ) )* ) ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:411:4: ^( (desKeyword= DESIGN_DECL | SUBDESIGN_DECL ) (desName= IDENT ( groupDecl[des] | portDecl[des] | netDecl[des] | instDecl[des, null] | subInstDecl[des] | connectAssign[des] | ( infoDecl ) )* ) )
            {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:411:6: (desKeyword= DESIGN_DECL | SUBDESIGN_DECL )
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
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:411:7: desKeyword= DESIGN_DECL
                    {
                    desKeyword=(CommonTree)match(input,DESIGN_DECL,FOLLOW_DESIGN_DECL_in_designDecl215); 

                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:411:32: SUBDESIGN_DECL
                    {
                    match(input,SUBDESIGN_DECL,FOLLOW_SUBDESIGN_DECL_in_designDecl219); 

                    }
                    break;

            }


            match(input, Token.DOWN, null); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:411:48: (desName= IDENT ( groupDecl[des] | portDecl[des] | netDecl[des] | instDecl[des, null] | subInstDecl[des] | connectAssign[des] | ( infoDecl ) )* )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:411:49: desName= IDENT ( groupDecl[des] | portDecl[des] | netDecl[des] | instDecl[des, null] | subInstDecl[des] | connectAssign[des] | ( infoDecl ) )*
            {
            desName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_designDecl225); 
            	// make a new design based on the identifier and log its location
            			DesignUnit des;
            			if (desKeyword != null) {
            				des = new Design((desName!=null?desName.getText():null));
            				if (topDesign == null)
            					topDesign = (Design) des;
            				else
            					bailOut(desName, "top level design already declared");
            			} else {
            				des = new SubDesign((desName!=null?desName.getText():null));
            				if (!subDesigns.add((SubDesign) des))
            					bailOut(desName, "duplicate subdesign declaration");
            			}

            			System.out.println("  -- Compiling: " + (desName!=null?desName.getText():null));
            			setLocation(des, desName);							
            				
            			// sets check for duplicate names within the scope of a design.
            			conNames.clear();
            			instNames.clear();
            		
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:435:2: ( groupDecl[des] | portDecl[des] | netDecl[des] | instDecl[des, null] | subInstDecl[des] | connectAssign[des] | ( infoDecl ) )*
            loop7:
            do {
                int alt7=8;
                switch ( input.LA(1) ) {
                case GROUP_DECL:
                    {
                    alt7=1;
                    }
                    break;
                case PORT_DECL:
                    {
                    alt7=2;
                    }
                    break;
                case NET_DECL:
                    {
                    alt7=3;
                    }
                    break;
                case INST_DECL:
                    {
                    alt7=4;
                    }
                    break;
                case SUBINST_DECL:
                    {
                    alt7=5;
                    }
                    break;
                case CONNECT_ASSIGN:
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
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:435:4: groupDecl[des]
            	    {
            	    pushFollow(FOLLOW_groupDecl_in_designDecl239);
            	    groupDecl(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:436:4: portDecl[des]
            	    {
            	    pushFollow(FOLLOW_portDecl_in_designDecl245);
            	    portDecl(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:437:4: netDecl[des]
            	    {
            	    pushFollow(FOLLOW_netDecl_in_designDecl252);
            	    netDecl(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 4 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:438:4: instDecl[des, null]
            	    {
            	    pushFollow(FOLLOW_instDecl_in_designDecl258);
            	    instDecl(des, null);

            	    state._fsp--;


            	    }
            	    break;
            	case 5 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:439:4: subInstDecl[des]
            	    {
            	    pushFollow(FOLLOW_subInstDecl_in_designDecl264);
            	    subInstDecl(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 6 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:440:4: connectAssign[des]
            	    {
            	    pushFollow(FOLLOW_connectAssign_in_designDecl270);
            	    connectAssign(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 7 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:441:4: ( infoDecl )
            	    {
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:441:4: ( infoDecl )
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:441:5: infoDecl
            	    {
            	    pushFollow(FOLLOW_infoDecl_in_designDecl277);
            	    infoDecl5=infoDecl();

            	    state._fsp--;

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


    // $ANTLR start "groupDecl"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:445:1: groupDecl[DesignUnit des] : ^( GROUP_DECL groupName= STRING ( portDecl[des] | netDecl[des] | instDecl[des, $groupName.text] | connectAssign[des] | ( infoDecl ) )* ) ;
    public final void groupDecl(DesignUnit des) throws RecognitionException {
        CommonTree groupName=null;
        PhdlAST.infoDecl_return infoDecl6 = null;


        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:446:2: ( ^( GROUP_DECL groupName= STRING ( portDecl[des] | netDecl[des] | instDecl[des, $groupName.text] | connectAssign[des] | ( infoDecl ) )* ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:446:4: ^( GROUP_DECL groupName= STRING ( portDecl[des] | netDecl[des] | instDecl[des, $groupName.text] | connectAssign[des] | ( infoDecl ) )* )
            {
            match(input,GROUP_DECL,FOLLOW_GROUP_DECL_in_groupDecl302); 

            match(input, Token.DOWN, null); 
            groupName=(CommonTree)match(input,STRING,FOLLOW_STRING_in_groupDecl306); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:447:2: ( portDecl[des] | netDecl[des] | instDecl[des, $groupName.text] | connectAssign[des] | ( infoDecl ) )*
            loop8:
            do {
                int alt8=6;
                switch ( input.LA(1) ) {
                case PORT_DECL:
                    {
                    alt8=1;
                    }
                    break;
                case NET_DECL:
                    {
                    alt8=2;
                    }
                    break;
                case INST_DECL:
                    {
                    alt8=3;
                    }
                    break;
                case CONNECT_ASSIGN:
                    {
                    alt8=4;
                    }
                    break;
                case INFO_DECL:
                    {
                    alt8=5;
                    }
                    break;

                }

                switch (alt8) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:447:4: portDecl[des]
            	    {
            	    pushFollow(FOLLOW_portDecl_in_groupDecl311);
            	    portDecl(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:448:4: netDecl[des]
            	    {
            	    pushFollow(FOLLOW_netDecl_in_groupDecl317);
            	    netDecl(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:449:4: instDecl[des, $groupName.text]
            	    {
            	    pushFollow(FOLLOW_instDecl_in_groupDecl323);
            	    instDecl(des, (groupName!=null?groupName.getText():null));

            	    state._fsp--;


            	    }
            	    break;
            	case 4 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:450:4: connectAssign[des]
            	    {
            	    pushFollow(FOLLOW_connectAssign_in_groupDecl329);
            	    connectAssign(des);

            	    state._fsp--;


            	    }
            	    break;
            	case 5 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:451:4: ( infoDecl )
            	    {
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:451:4: ( infoDecl )
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:451:5: infoDecl
            	    {
            	    pushFollow(FOLLOW_infoDecl_in_groupDecl336);
            	    infoDecl6=infoDecl();

            	    state._fsp--;

            	    des.appendInfo((infoDecl6!=null?infoDecl6.info:null).getText());

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:455:1: portDecl[DesignUnit subDes] : ^( PORT_DECL ( width )? (portName= IDENT )* ) ;
    public final void portDecl(DesignUnit subDes) throws RecognitionException {
        CommonTree portName=null;
        List<Integer> width7 = null;


        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:456:2: ( ^( PORT_DECL ( width )? (portName= IDENT )* ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:456:4: ^( PORT_DECL ( width )? (portName= IDENT )* )
            {
            match(input,PORT_DECL,FOLLOW_PORT_DECL_in_portDecl360); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:456:16: ( width )?
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==WIDTH) ) {
                    alt9=1;
                }
                switch (alt9) {
                    case 1 :
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:456:16: width
                        {
                        pushFollow(FOLLOW_width_in_portDecl362);
                        width7=width();

                        state._fsp--;


                        }
                        break;

                }

                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:456:23: (portName= IDENT )*
                loop10:
                do {
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==IDENT) ) {
                        alt10=1;
                    }


                    switch (alt10) {
                	case 1 :
                	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:456:24: portName= IDENT
                	    {
                	    portName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_portDecl368); 
                	    	// verify the port is not in a design
                	    				if (subDes instanceof Design)
                	    					bailOut(portName, "ports are only allowed in subdesigns");
                	    				if (width7 == null || width7.size() == 1) {
                	    					Port p = new Port(subDes, (portName!=null?portName.getText():null));
                	    					setLocation(p, portName);
                	    					if (width7 != null)
                	    						p.setIndex(width7.get(0));
                	    					if(!subDes.addConnection(p))
                	    						addError(portName, "duplicate port declaration");
                	    				} else {
                	    					for (int i = 0; i < width7.size(); i++) {
                	    						Port p = new Port(subDes, (portName!=null?portName.getText():null));
                	    						setLocation(p, portName);
                	    						p.setIndex(width7.get(i));
                	    						if (!subDes.addConnection(p))
                	    							addError(portName, "duplicate port declaration");
                	    					}
                	    				}
                	    				// check for duplicates based soley on the name of the port
                	    				if (!conNames.add((portName!=null?portName.getText():null)))
                	    					addError(portName, "duplicate port declaration");
                	    			

                	    }
                	    break;

                	default :
                	    break loop10;
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:484:1: netDecl[DesignUnit des] : ^( NET_DECL ( width )? (netName= IDENT )* ( attrDecl[nets] )* ) ;
    public final void netDecl(DesignUnit des) throws RecognitionException {
        CommonTree netName=null;
        List<Integer> width8 = null;


        List<Attributable> nets = new ArrayList<Attributable>();
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:486:2: ( ^( NET_DECL ( width )? (netName= IDENT )* ( attrDecl[nets] )* ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:486:4: ^( NET_DECL ( width )? (netName= IDENT )* ( attrDecl[nets] )* )
            {
            match(input,NET_DECL,FOLLOW_NET_DECL_in_netDecl399); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:486:15: ( width )?
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==WIDTH) ) {
                    alt11=1;
                }
                switch (alt11) {
                    case 1 :
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:486:15: width
                        {
                        pushFollow(FOLLOW_width_in_netDecl401);
                        width8=width();

                        state._fsp--;


                        }
                        break;

                }

                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:486:22: (netName= IDENT )*
                loop12:
                do {
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==IDENT) ) {
                        alt12=1;
                    }


                    switch (alt12) {
                	case 1 :
                	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:486:23: netName= IDENT
                	    {
                	    netName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_netDecl407); 
                	    	if (width8 == null || width8.size() == 1) {
                	    					Net n = new Net(des, (netName!=null?netName.getText():null));
                	    					setLocation(n, netName);
                	    					if (width8 != null)
                	    						n.setIndex(width8.get(0));
                	    					if (!des.addConnection(n)) 
                	    						addError(netName, "duplicate net declaration");
                	    					nets.add(n);
                	    				} else {
                	    					for (int i = 0; i < width8.size(); i++) {
                	    						Net n = new Net(des, (netName!=null?netName.getText():null));
                	    						setLocation(n, netName);
                	    						n.setIndex(width8.get(i));
                	    						if (!des.addConnection(n))
                	    							addError(netName, "duplicate net declaration");
                	    						nets.add(n);
                	    					}
                	    				}	
                	    					
                	    				// check for duplicates based soley on the name of the net
                	    				if (!conNames.add((netName!=null?netName.getText():null)))
                	    					addError(netName, "duplicate net declaration");
                	    			

                	    }
                	    break;

                	default :
                	    break loop12;
                    }
                } while (true);

                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:513:3: ( attrDecl[nets] )*
                loop13:
                do {
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==ATTR_DECL) ) {
                        alt13=1;
                    }


                    switch (alt13) {
                	case 1 :
                	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:513:3: attrDecl[nets]
                	    {
                	    pushFollow(FOLLOW_attrDecl_in_netDecl427);
                	    attrDecl(nets);

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop13;
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:516:1: instDecl[DesignUnit des, String groupName] : ^( INST_DECL ( width )? instName= IDENT devName= IDENT ( infoDecl )* ( attrAssign[des, $instName.text] )* ( pinAssign[des, $instName.text] )* ) ;
    public final void instDecl(DesignUnit des, String groupName) throws RecognitionException {
        CommonTree instName=null;
        CommonTree devName=null;
        List<Integer> width9 = null;

        PhdlAST.infoDecl_return infoDecl10 = null;


        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:517:2: ( ^( INST_DECL ( width )? instName= IDENT devName= IDENT ( infoDecl )* ( attrAssign[des, $instName.text] )* ( pinAssign[des, $instName.text] )* ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:517:4: ^( INST_DECL ( width )? instName= IDENT devName= IDENT ( infoDecl )* ( attrAssign[des, $instName.text] )* ( pinAssign[des, $instName.text] )* )
            {
            match(input,INST_DECL,FOLLOW_INST_DECL_in_instDecl444); 

            match(input, Token.DOWN, null); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:517:16: ( width )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==WIDTH) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:517:16: width
                    {
                    pushFollow(FOLLOW_width_in_instDecl446);
                    width9=width();

                    state._fsp--;


                    }
                    break;

            }

            instName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl451); 
            devName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_instDecl455); 
            	Device dev = getDevice((devName!=null?devName.getText():null));
            			if (dev == null)
            				bailOut(instName, "instance references undeclared device");
            			if (width9 == null || width9.size() == 1) {
            				Instance i = new Instance(des, dev, (instName!=null?instName.getText():null));
            				setLocation(i, instName);
            				i.setGroupName(groupName);
            				i.setInfo(dev.getInfo());
            				if (width9 != null)
            					i.setIndex(width9.get(0));
            				// check for duplicates
            				if (!des.addInstance(i))
            					addError(instName, "duplicate instance declaration");
            			
            			} else {
            				for (int j = 0; j < width9.size(); j ++) {
            					Instance i = new Instance(des, dev, (instName!=null?instName.getText():null));
            					setLocation(i, instName);
            					i.setGroupName(groupName);
            					i.setInfo(dev.getInfo());
            					i.setIndex(width9.get(j));
            					// check for duplicates
            					if (!des.addInstance(i))
            						addError(instName, "duplicate instance declaration");
            				}
            			} 
            		
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:547:3: ( infoDecl )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==INFO_DECL) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:547:4: infoDecl
            	    {
            	    pushFollow(FOLLOW_infoDecl_in_instDecl471);
            	    infoDecl10=infoDecl();

            	    state._fsp--;

            	    	List<Instance> insts = des.getInstancesByName((instName!=null?instName.getText():null));
            	    				if ((infoDecl10!=null?infoDecl10.indices:null) == null) {
            	    					for (Instance i : insts)
            	    						i.appendInfo(" " + (infoDecl10!=null?infoDecl10.info:null).getText());
            	    				} else {
            	    					// for all the indices in the array list declaration
            	    					for (Integer index : (infoDecl10!=null?infoDecl10.indices:null)) {
            	    						// search for the instance with this index
            	    						Instance i = null;
            	    						for (Instance inst : insts)
            	    							if (index == inst.getIndex()) 
            	    								i = inst;
            	    						
            	    						if (i != null) {
            	    							i.appendInfo(" " + (infoDecl10!=null?infoDecl10.info:null).getText());
            	    						// the instance referenced by the index doesn't exist
            	    						} else
            	    							addWarning((infoDecl10!=null?infoDecl10.info:null), "instance index (" + index + ") does not exist");
            	    					}
            	    				}
            	    			

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            	// check for duplicates based solely on the raw instance name
            				if (!instNames.add((instName!=null?instName.getText():null)))
            					addError(instName, "duplicate instance name exists in design unit");
            			
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:576:3: ( attrAssign[des, $instName.text] )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==ATTR_ASSIGN) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:576:3: attrAssign[des, $instName.text]
            	    {
            	    pushFollow(FOLLOW_attrAssign_in_instDecl497);
            	    attrAssign(des, (instName!=null?instName.getText():null));

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:576:36: ( pinAssign[des, $instName.text] )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==PIN_ASSIGN) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:576:36: pinAssign[des, $instName.text]
            	    {
            	    pushFollow(FOLLOW_pinAssign_in_instDecl501);
            	    pinAssign(des, (instName!=null?instName.getText():null));

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            	// assign the refprefix, refdes, package, and library if it exists
            				for (Instance i : des.getInstancesByName((instName!=null?instName.getText():null))) {
            					for (Attribute a : i.getAttributes()) {
            						if (a.getName().equals("REFPREFIX"))
            							i.setRefPrefix(a.getValue());
            						else if (a.getName().equals("REFDES"))
            							i.setRefDes(a.getValue());
            						else if (a.getName().equals("PACKAGE"))
            							i.setPackage(a.getValue());
            						else if (a.getName().equals("LIBRARY"))
            							i.setLibrary(a.getValue());
            					}
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
    // $ANTLR end "instDecl"


    // $ANTLR start "attrAssign"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:595:1: attrAssign[DesignUnit des, String instName] : ^( ATTR_ASSIGN ( NEWATTR )? ( qualifier )? attrName= IDENT attrValue= STRING ) ;
    public final void attrAssign(DesignUnit des, String instName) throws RecognitionException {
        CommonTree attrName=null;
        CommonTree attrValue=null;
        PhdlAST.qualifier_return qualifier11 = null;


        boolean newAttr = false;
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:597:2: ( ^( ATTR_ASSIGN ( NEWATTR )? ( qualifier )? attrName= IDENT attrValue= STRING ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:597:4: ^( ATTR_ASSIGN ( NEWATTR )? ( qualifier )? attrName= IDENT attrValue= STRING )
            {
            match(input,ATTR_ASSIGN,FOLLOW_ATTR_ASSIGN_in_attrAssign533); 

            match(input, Token.DOWN, null); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:597:18: ( NEWATTR )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==NEWATTR) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:597:19: NEWATTR
                    {
                    match(input,NEWATTR,FOLLOW_NEWATTR_in_attrAssign536); 
                    newAttr = true;

                    }
                    break;

            }

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:597:47: ( qualifier )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==THIS) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:597:47: qualifier
                    {
                    pushFollow(FOLLOW_qualifier_in_attrAssign542);
                    qualifier11=qualifier();

                    state._fsp--;


                    }
                    break;

            }

            attrName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_attrAssign547); 
            attrValue=(CommonTree)match(input,STRING,FOLLOW_STRING_in_attrAssign551); 

            match(input, Token.UP, null); 
            	// a list of all candidate instances from the design
            			List<Instance> insts = new ArrayList<Instance>();
            			if ((qualifier11!=null?qualifier11.indices:null) == null)
            				insts.addAll(des.getInstancesByName(instName));
            			else {
            				for (Integer i : (qualifier11!=null?qualifier11.indices:null)) {
            					Instance inst = des.getInstance(instName, i);
            					if (inst == null)
            						bailOut((qualifier11!=null?qualifier11.name:null), "invalid instance qualifier index (" + i + ")");
            					else
            						insts.add(inst);
            				}
            			}
            			
            			for (Instance i : insts) {
            				Attribute a = i.getAttribute((attrName!=null?attrName.getText():null));
            				if (a != null) {
            					if (newAttr)
            						addError(attrName, "new attribute already declared");
            					if (!a.overwrite((attrValue!=null?attrValue.getText():null)))
            						addWarning(attrName, "attribute already overwritten");
            					setLocation(a, attrName);
            				} else if (newAttr) {
            					Attribute newA = new Attribute(i, (attrName!=null?attrName.getText():null), (attrValue!=null?attrValue.getText():null));
            					setLocation(newA, attrName);
            					i.addAttribute(newA);
            				} else
            					addError(attrName, "undeclared attribute");
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:631:1: pinAssign[DesignUnit des, String instName] : ^( PIN_ASSIGN ( COMBINE )? ( qualifier )? operand concat[des] ) ;
    public final void pinAssign(DesignUnit des, String instName) throws RecognitionException {
        PhdlAST.qualifier_return qualifier12 = null;

        PhdlAST.operand_return operand13 = null;

        PhdlAST.concat_return concat14 = null;


        boolean isCombined = false;
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:633:2: ( ^( PIN_ASSIGN ( COMBINE )? ( qualifier )? operand concat[des] ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:633:4: ^( PIN_ASSIGN ( COMBINE )? ( qualifier )? operand concat[des] )
            {
            match(input,PIN_ASSIGN,FOLLOW_PIN_ASSIGN_in_pinAssign577); 

            match(input, Token.DOWN, null); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:633:17: ( COMBINE )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==COMBINE) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:633:18: COMBINE
                    {
                    match(input,COMBINE,FOLLOW_COMBINE_in_pinAssign580); 
                    isCombined = true;

                    }
                    break;

            }

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:633:49: ( qualifier )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==THIS) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:633:49: qualifier
                    {
                    pushFollow(FOLLOW_qualifier_in_pinAssign586);
                    qualifier12=qualifier();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_operand_in_pinAssign589);
            operand13=operand();

            state._fsp--;

            pushFollow(FOLLOW_concat_in_pinAssign591);
            concat14=concat(des);

            state._fsp--;


            match(input, Token.UP, null); 
            	// gather the relevant instances in a list
            			List<Instance> insts = new ArrayList<Instance>();
            			if ((qualifier12!=null?qualifier12.indices:null) == null)
            				insts.addAll(des.getInstancesByName(instName));
            			else {
            				for (Integer i : (qualifier12!=null?qualifier12.indices:null)) {
            					Instance inst = des.getInstance(instName, i);
            					if (inst == null)
            						bailOut((qualifier12!=null?qualifier12.name:null), "invalid instance qualifier index (" + i + ")");
            					else
            						insts.add(inst);
            				}
            			}
            			
            			// list of pins to assign connections to
            			List<Pin> pins = new ArrayList<Pin>();
            			
            			if (isCombined) {
            				if ((operand13!=null?operand13.indices:null) == null) {
            					// get all possible instances
            					for (Instance inst : insts)
            						pins.addAll(inst.getAllPins((operand13!=null?operand13.id:null).getText()));
            					if (pins.size() == 0)
            						bailOut((operand13!=null?operand13.id:null), "undeclared pin");
            				} else {
            					// get only those instances with the indices in the list
            					for (Instance inst : insts) {
            						for (Integer i : (operand13!=null?operand13.indices:null)) {
            							Pin p = inst.getPin((operand13!=null?operand13.id:null).getText(), i);
            							if (p == null)
            								bailOut((operand13!=null?operand13.id:null), "undeclared pin or invalid pin index [" + i + "]");
            							else
            								pins.add(p);
            						}
            					}
            				}

            				for (int i = 0; i < pins.size(); i++) {
            				
            					// check to see if the pin is already assigned
            					if (pins.get(i).isAssigned()) {
            						String index = (pins.get(i).hasIndex())?("index [" + pins.get(i).getIndex() + "]"):("pin");
            						bailOut((operand13!=null?operand13.id:null), index + " is already assigned");
            					} else if (pins.get(i).isOpen()) {
            						String index = (pins.get(i).hasIndex())?("index [" + pins.get(i).getIndex() + "]"):("pin");
            						bailOut((operand13!=null?operand13.id:null), index + " is already open");
            						
            					// assign the pin based on the flags
            					} else if ((concat14!=null?concat14.isReplicated:false)) {
            						pins.get(i).setAssignment((concat14!=null?concat14.cons:null).get(0));
            						(concat14!=null?concat14.cons:null).get(0).addPin(pins.get(i));
            					} else if ((concat14!=null?concat14.isOpen:false)) {
            						pins.get(i).setOpen(true);
            					} else {
            						// check for width mismatch
            						if (pins.size() != (concat14!=null?concat14.cons:null).size()) {
            							bailOut((operand13!=null?operand13.id:null), "pin assignment left size [" + pins.size() + 
            								"] does not match right size [" + (concat14!=null?concat14.cons:null).size() + "]");
            						} else {
            							pins.get(i).setAssignment((concat14!=null?concat14.cons:null).get(i));
            							(concat14!=null?concat14.cons:null).get(i).addPin(pins.get(i));
            						}
            					}
            				}
            				
            			// assignment is not a combine operation
            			} else {
            				for (Instance inst : insts) {
            					if ((operand13!=null?operand13.indices:null) == null) {
            						pins.addAll(inst.getAllPins((operand13!=null?operand13.id:null).getText()));
            						if (pins.size() == 0)
            							bailOut((operand13!=null?operand13.id:null), "undeclared pin");
            					} else {
            						for (Integer i : (operand13!=null?operand13.indices:null)) {
            							Pin p = inst.getPin((operand13!=null?operand13.id:null).getText(), i);
            							if (p == null)
            								bailOut((operand13!=null?operand13.id:null), "undeclared pin or invalid pin index [" + i + "]");
            							else
            								pins.add(p);
            						}
            					}
            					
            					for (int i = 0; i < pins.size(); i++) {
            					
            						// check to see if the pin is already assigned
            						if (pins.get(i).isAssigned()) {
            							String index = (pins.get(i).hasIndex())?("index [" + pins.get(i).getIndex() + "]"):("pin");
            							bailOut((operand13!=null?operand13.id:null), index + " is already assigned");
            						} else if (pins.get(i).isOpen()) {
            							String index = (pins.get(i).hasIndex())?("index [" + pins.get(i).getIndex() + "]"):("pin");
            							bailOut((operand13!=null?operand13.id:null), index + " is already open");
            							
            						// assign the pin based on the flags
            						} else if ((concat14!=null?concat14.isReplicated:false)) {
            							pins.get(i).setAssignment((concat14!=null?concat14.cons:null).get(0));
            							(concat14!=null?concat14.cons:null).get(0).addPin(pins.get(i));
            						} else if ((concat14!=null?concat14.isOpen:false)) {
            							pins.get(i).setOpen(true);
            						} else {
            							// check for width mismatch
            							if (pins.size() != (concat14!=null?concat14.cons:null).size()) {
            								bailOut((operand13!=null?operand13.id:null), "pin assignment left size [" + pins.size() + 
            									"] does not match right size [" + (concat14!=null?concat14.cons:null).size() + "]");
            							} else {
            								pins.get(i).setAssignment((concat14!=null?concat14.cons:null).get(i));
            								(concat14!=null?concat14.cons:null).get(i).addPin(pins.get(i));
            							}
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


    // $ANTLR start "subInstDecl"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:750:1: subInstDecl[DesignUnit des] : ^( SUBINST_DECL ( width )? instName= IDENT (refPrefix= STRING )? desName= IDENT ( infoDecl )* ( subAttrAssign[des, $instName] )* ( portAssign[des, $instName.text] )* ) ;
    public final void subInstDecl(DesignUnit des) throws RecognitionException {
        CommonTree instName=null;
        CommonTree refPrefix=null;
        CommonTree desName=null;
        List<Integer> width15 = null;

        PhdlAST.infoDecl_return infoDecl16 = null;


        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:751:2: ( ^( SUBINST_DECL ( width )? instName= IDENT (refPrefix= STRING )? desName= IDENT ( infoDecl )* ( subAttrAssign[des, $instName] )* ( portAssign[des, $instName.text] )* ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:751:4: ^( SUBINST_DECL ( width )? instName= IDENT (refPrefix= STRING )? desName= IDENT ( infoDecl )* ( subAttrAssign[des, $instName] )* ( portAssign[des, $instName.text] )* )
            {
            match(input,SUBINST_DECL,FOLLOW_SUBINST_DECL_in_subInstDecl611); 

            match(input, Token.DOWN, null); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:751:19: ( width )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==WIDTH) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:751:19: width
                    {
                    pushFollow(FOLLOW_width_in_subInstDecl613);
                    width15=width();

                    state._fsp--;


                    }
                    break;

            }

            instName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_subInstDecl618); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:751:50: (refPrefix= STRING )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==STRING) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:751:50: refPrefix= STRING
                    {
                    refPrefix=(CommonTree)match(input,STRING,FOLLOW_STRING_in_subInstDecl622); 

                    }
                    break;

            }

            desName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_subInstDecl627); 
            	SubDesign subDes = getSubDesign((desName!=null?desName.getText():null));
            			if (subDes == null)
            				bailOut(instName, "subdesign " + (desName!=null?desName.getText():null) + " is undeclared");
            			if (width15 == null || width15.size() == 1) {
            				SubInstance s = new SubInstance(des, subDes, (instName!=null?instName.getText():null));
            				setLocation(s, instName);
            				s.setRefPrefix((refPrefix!=null?refPrefix.getText():null));
            				if (width15 != null)
            					s.setIndex(width15.get(0));
            				
            				// check for duplicates
            				if (!des.addSubInst(s))
            					addError(instName, "duplicate subdesign instance declaration");
            			
            			} else {
            				for (int i = 0; i < width15.size(); i++) {
            					SubInstance s = new SubInstance(des, subDes, (instName!=null?instName.getText():null));
            					setLocation(s, instName);
            					s.setRefPrefix((refPrefix!=null?refPrefix.getText():null));
            					s.setIndex(width15.get(i));
            					// check for duplicates
            					if (!des.addSubInst(s))
            						addError(instName, "duplicate subdesign instance declaration");
            				}
            			} 
            		
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:780:3: ( infoDecl )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==INFO_DECL) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:780:4: infoDecl
            	    {
            	    pushFollow(FOLLOW_infoDecl_in_subInstDecl639);
            	    infoDecl16=infoDecl();

            	    state._fsp--;

            	    	List<SubInstance> subs = des.getSubInstances();
            	    				if ((infoDecl16!=null?infoDecl16.indices:null) == null) {
            	    					for (SubInstance s : subs)
            	    						s.appendInfo((infoDecl16!=null?infoDecl16.info:null).getText());
            	    				} else {
            	    					// iterate over the indices in the array list declaration
            	    					for (Integer index : (infoDecl16!=null?infoDecl16.indices:null)) {
            	    						// search for the instance with this index
            	    						SubInstance s = null;
            	    						for (SubInstance sub : subs)
            	    							if (index == sub.getIndex()) 
            	    								s = sub;
            	    						
            	    						if (s != null) {
            	    							s.appendInfo((infoDecl16!=null?infoDecl16.info:null).getText());
            	    						// the instance referenced by the index doesn't exist
            	    						} else
            	    							addWarning((infoDecl16!=null?infoDecl16.info:null), "subdesign instance index (" + index + 
            	    								") does not exist for information declaration");
            	    					}
            	    				}
            	    			

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            	// check for duplicates based solely on the raw instance name
            			if (!instNames.add((instName!=null?instName.getText():null)))
            				addError(instName, "duplicate instance name exists in design unit");
            		
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:810:3: ( subAttrAssign[des, $instName] )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==SUBATTR_ASSIGN) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:810:3: subAttrAssign[des, $instName]
            	    {
            	    pushFollow(FOLLOW_subAttrAssign_in_subInstDecl663);
            	    subAttrAssign(des, instName);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:811:3: ( portAssign[des, $instName.text] )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==PORT_ASSIGN) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:811:3: portAssign[des, $instName.text]
            	    {
            	    pushFollow(FOLLOW_portAssign_in_subInstDecl670);
            	    portAssign(des, (instName!=null?instName.getText():null));

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
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
    // $ANTLR end "subInstDecl"


    // $ANTLR start "subAttrAssign"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:814:1: subAttrAssign[DesignUnit des, CommonTree subInstName] : ^( SUBATTR_ASSIGN ( NEWATTR )? ( qualifier )? (id= name )+ attrName= IDENT attrValue= STRING ) ;
    public final void subAttrAssign(DesignUnit des, CommonTree subInstName) throws RecognitionException {
        CommonTree attrName=null;
        CommonTree attrValue=null;
        PhdlAST.name_return id = null;

        PhdlAST.qualifier_return qualifier17 = null;



        	boolean newAttr = false;
        	List<name_return> ids = new ArrayList<name_return>();

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:819:2: ( ^( SUBATTR_ASSIGN ( NEWATTR )? ( qualifier )? (id= name )+ attrName= IDENT attrValue= STRING ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:819:4: ^( SUBATTR_ASSIGN ( NEWATTR )? ( qualifier )? (id= name )+ attrName= IDENT attrValue= STRING )
            {
            match(input,SUBATTR_ASSIGN,FOLLOW_SUBATTR_ASSIGN_in_subAttrAssign691); 

            match(input, Token.DOWN, null); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:819:21: ( NEWATTR )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==NEWATTR) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:819:22: NEWATTR
                    {
                    match(input,NEWATTR,FOLLOW_NEWATTR_in_subAttrAssign694); 
                    newAttr = true;

                    }
                    break;

            }

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:819:50: ( qualifier )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==THIS) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:819:50: qualifier
                    {
                    pushFollow(FOLLOW_qualifier_in_subAttrAssign700);
                    qualifier17=qualifier();

                    state._fsp--;


                    }
                    break;

            }

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:819:61: (id= name )+
            int cnt29=0;
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==NAME) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:819:62: id= name
            	    {
            	    pushFollow(FOLLOW_name_in_subAttrAssign706);
            	    id=name();

            	    state._fsp--;

            	    ids.add(id);

            	    }
            	    break;

            	default :
            	    if ( cnt29 >= 1 ) break loop29;
                        EarlyExitException eee =
                            new EarlyExitException(29, input);
                        throw eee;
                }
                cnt29++;
            } while (true);

            attrName=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_subAttrAssign714); 
            attrValue=(CommonTree)match(input,STRING,FOLLOW_STRING_in_subAttrAssign718); 

            match(input, Token.UP, null); 
            	Stack<name_return> names = new Stack<name_return>();
            			for (int i = ids.size()-1; i >= 0; i--)
            				names.push(ids.get(i));
            		
            			// gather the relevant subdesign instances in a list
            			List<SubInstance> subInsts = new ArrayList<SubInstance>();
            			if ((qualifier17!=null?qualifier17.indices:null) == null) {
            				for (SubInstance subInst : des.getSubInstancesByName(subInstName.getText()))
            					subInsts.add(subInst);
            			} else {
            				for (Integer i : (qualifier17!=null?qualifier17.indices:null)) {
            					SubInstance subInst = des.getSubInstance(subInstName.getText(), i);
            					if (subInst == null)
            						bailOut((qualifier17!=null?qualifier17.name:null), "invalid subinstance qualifier index (" + i + ")");
            					else
            						subInsts.add(subInst);
            				}
            			}
            			
            			// call the recursive SubInstance attribute routine on each SubInstance
            			for (SubInstance subInst : subInsts)
            				subInstAttr(subInst, names, attrName, attrValue, newAttr);
            		

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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:845:1: portAssign[DesignUnit des, String subInstName] : ^( PORT_ASSIGN ( COMBINE )? ( qualifier )? operand concat[des] ) ;
    public final void portAssign(DesignUnit des, String subInstName) throws RecognitionException {
        PhdlAST.qualifier_return qualifier18 = null;

        PhdlAST.operand_return operand19 = null;

        PhdlAST.concat_return concat20 = null;


        boolean isCombined = false;
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:847:2: ( ^( PORT_ASSIGN ( COMBINE )? ( qualifier )? operand concat[des] ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:847:4: ^( PORT_ASSIGN ( COMBINE )? ( qualifier )? operand concat[des] )
            {
            match(input,PORT_ASSIGN,FOLLOW_PORT_ASSIGN_in_portAssign743); 

            match(input, Token.DOWN, null); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:847:18: ( COMBINE )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==COMBINE) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:847:19: COMBINE
                    {
                    match(input,COMBINE,FOLLOW_COMBINE_in_portAssign746); 
                    isCombined = true;

                    }
                    break;

            }

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:847:50: ( qualifier )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==THIS) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:847:50: qualifier
                    {
                    pushFollow(FOLLOW_qualifier_in_portAssign752);
                    qualifier18=qualifier();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_operand_in_portAssign755);
            operand19=operand();

            state._fsp--;

            pushFollow(FOLLOW_concat_in_portAssign757);
            concat20=concat(des);

            state._fsp--;


            match(input, Token.UP, null); 
            	// gather the relevant subdesign instances in a list
            			List<SubInstance> subInsts = new ArrayList<SubInstance>();
            			if ((qualifier18!=null?qualifier18.indices:null) == null)
            				subInsts.addAll(des.getSubInstancesByName(subInstName));
            			else {
            				for (Integer i : (qualifier18!=null?qualifier18.indices:null)) {
            					SubInstance subInst = des.getSubInstance(subInstName, i);
            					if (subInst == null)
            						bailOut((operand19!=null?operand19.id:null), "invalid instance qualifier index (" + i + ")");
            					else
            						subInsts.add(subInst);
            				}
            			}
            			
            			// list of ports to assign connections to
            			List<Port> ports = new ArrayList<Port>();
            			
            			
            			if (isCombined) {
            				if ((operand19!=null?operand19.indices:null) == null) {
            					// get all possible instances
            					for (SubInstance s : subInsts)
            						ports.addAll(s.getAllPorts((operand19!=null?operand19.id:null).getText()));
            					if (ports.size() == 0)
            						bailOut((operand19!=null?operand19.id:null), "undeclared port");
            				} else {
            					// get only those instances with the indices in the list
            					for (SubInstance s : subInsts) {
            						for (Integer i : (operand19!=null?operand19.indices:null)) {
            							Port p = s.getPort((operand19!=null?operand19.id:null).getText(), i);
            							if (p == null)
            								bailOut((operand19!=null?operand19.id:null), "undeclared port or invalid port index [" + i + "]");
            							else
            								ports.add(p);
            						}
            					}
            				}
            				for (int i = 0; i < ports.size(); i++) {
            					
            					// remap the port location
            					setLocation(ports.get(i), (operand19!=null?operand19.id:null));
            					
            					// check to see if the pin is already assigned
            					if (ports.get(i).isAssigned()) {
            						String index = (ports.get(i).hasIndex())?("index [" + ports.get(i).getIndex() + "]"):("port");
            						bailOut((operand19!=null?operand19.id:null), index + " is already assigned");
            					}
            					
            					// assign the port based on the flags
            					if ((concat20!=null?concat20.isReplicated:false)) {
            						ports.get(i).setAssignment((concat20!=null?concat20.cons:null).get(0));
            						(concat20!=null?concat20.cons:null).get(0).addConnection(ports.get(i));
            					} else if ((concat20!=null?concat20.isOpen:false)) {
            						addWarning((operand19!=null?operand19.id:null), "open port will isolate design hierarchy");
            					} else {
            						// check for width mismatch
            						if (ports.size() != (concat20!=null?concat20.cons:null).size()) {
            							bailOut((operand19!=null?operand19.id:null), "port assignment left size [" + ports.size() + 
            								"] does not match right size [" + (concat20!=null?concat20.cons:null).size() + "]");
            						} else {
            							ports.get(i).setAssignment((concat20!=null?concat20.cons:null).get(i));
            							(concat20!=null?concat20.cons:null).get(i).addConnection(ports.get(i));
            						}
            					}
            				}
            			} else {
            				for (SubInstance s : subInsts) {
            					if ((operand19!=null?operand19.indices:null) == null) {
            						ports.addAll(s.getAllPorts((operand19!=null?operand19.id:null).getText()));
            						if (ports.size() == 0)
            							bailOut((operand19!=null?operand19.id:null), "undeclared port");
            					} else {
            						for (Integer i : (operand19!=null?operand19.indices:null)) {
            							Port p = s.getPort((operand19!=null?operand19.id:null).getText(), i);
            							if (p == null)
            								bailOut((operand19!=null?operand19.id:null), "undeclared port or invalid port index [" + i + "]");
            							else
            								ports.add(p);
            						}
            					}
            					
            					for (int i = 0; i < ports.size(); i++) {
            						// remap the port location
            						setLocation(ports.get(i), (operand19!=null?operand19.id:null));
            						
            						// check to see if the pin is already assigned
            						if (ports.get(i).isAssigned()) {
            							String index = (ports.get(i).hasIndex())?("index [" + ports.get(i).getIndex() + "]"):("port");
            							bailOut((operand19!=null?operand19.id:null), index + " is already assigned");
            						}
            					
            						// assign the port based on the flags
            						if ((concat20!=null?concat20.isReplicated:false)) {
            							ports.get(i).setAssignment((concat20!=null?concat20.cons:null).get(0));
            							(concat20!=null?concat20.cons:null).get(0).addConnection(ports.get(i));
            						} else if ((concat20!=null?concat20.isOpen:false)) {
            							addWarning((operand19!=null?operand19.id:null), "open port will isolate design hierarchy");
            						} else {
            							// check for width mismatch
            							if (ports.size() != (concat20!=null?concat20.cons:null).size()) {
            								bailOut((operand19!=null?operand19.id:null), "port assignment left size [" + ports.size() + 
            									"] does not match right size [" + (concat20!=null?concat20.cons:null).size() + "]");
            							} else {
            								ports.get(i).setAssignment((concat20!=null?concat20.cons:null).get(i));
            								(concat20!=null?concat20.cons:null).get(i).addConnection(ports.get(i));
            							}
            						}
            					}

            					// clear the list in preparation for the next instance's ports
            					ports.clear();
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


    // $ANTLR start "connectAssign"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:965:1: connectAssign[DesignUnit des] : ^( CONNECT_ASSIGN operand concat[des] ) ;
    public final void connectAssign(DesignUnit des) throws RecognitionException {
        PhdlAST.concat_return concat21 = null;

        PhdlAST.operand_return operand22 = null;


        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:966:2: ( ^( CONNECT_ASSIGN operand concat[des] ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:966:4: ^( CONNECT_ASSIGN operand concat[des] )
            {
            match(input,CONNECT_ASSIGN,FOLLOW_CONNECT_ASSIGN_in_connectAssign780); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_operand_in_connectAssign782);
            operand22=operand();

            state._fsp--;

            pushFollow(FOLLOW_concat_in_connectAssign784);
            concat21=concat(des);

            state._fsp--;


            match(input, Token.UP, null); 
            	if ((concat21!=null?concat21.isOpen:false))
            				bailOut((operand22!=null?operand22.id:null), "connections cannot be open");
            				
            			// a list of connections on the left hand side
            			List<Connection> cons = new ArrayList<Connection>();
            			if ((operand22!=null?operand22.indices:null) == null) {
            				cons.addAll(des.getConnectionsByName((operand22!=null?operand22.id:null).getText()));
            			} else {
            				for (Integer i : (operand22!=null?operand22.indices:null)) {
            					Connection c = des.getConnection((operand22!=null?operand22.id:null).getText(), i);
            					if (c == null)
            						bailOut((operand22!=null?operand22.id:null), "undeclared connection or invalid index (" + i + ")");
            					else
            						cons.add(c);
            				}
            			}
            			
            			// check for assignment width mismatch
            			if (cons.size() != (concat21!=null?concat21.cons:null).size()) {
            				bailOut((operand22!=null?operand22.id:null), "assignment left size [" + cons.size() + 
            					"] does not match right size [" + (concat21!=null?concat21.cons:null).size() + "]");
            			}
            			
            			for (int i = 0; i < cons.size(); i++) {
            				if ((concat21!=null?concat21.isReplicated:false)) {
            					cons.get(i).addConnection((concat21!=null?concat21.cons:null).get(0));
            					(concat21!=null?concat21.cons:null).get(0).addConnection(cons.get(i));
            				} else {
            					cons.get(i).addConnection((concat21!=null?concat21.cons:null).get(i));
            					(concat21!=null?concat21.cons:null).get(i).addConnection(cons.get(i));
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
    // $ANTLR end "connectAssign"

    public static class concat_return extends TreeRuleReturnScope {
        public List<Connection> cons;
        public boolean isReplicated;
        public boolean isOpen;
    };

    // $ANTLR start "concat"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1003:1: concat[DesignUnit des] returns [List<Connection> cons, boolean isReplicated, boolean isOpen] : ( ^( CONCAT_LIST ( operand )* ) | ^( CONCAT_REPL operand ) | ^( CONCAT_OPEN ) );
    public final PhdlAST.concat_return concat(DesignUnit des) throws RecognitionException {
        PhdlAST.concat_return retval = new PhdlAST.concat_return();
        retval.start = input.LT(1);

        PhdlAST.operand_return operand23 = null;

        PhdlAST.operand_return operand24 = null;


        retval.cons = new ArrayList<Connection>();
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1015:2: ( ^( CONCAT_LIST ( operand )* ) | ^( CONCAT_REPL operand ) | ^( CONCAT_OPEN ) )
            int alt33=3;
            switch ( input.LA(1) ) {
            case CONCAT_LIST:
                {
                alt33=1;
                }
                break;
            case CONCAT_REPL:
                {
                alt33=2;
                }
                break;
            case CONCAT_OPEN:
                {
                alt33=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1015:4: ^( CONCAT_LIST ( operand )* )
                    {
                    match(input,CONCAT_LIST,FOLLOW_CONCAT_LIST_in_concat818); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1015:18: ( operand )*
                        loop32:
                        do {
                            int alt32=2;
                            int LA32_0 = input.LA(1);

                            if ( (LA32_0==OPERAND) ) {
                                alt32=1;
                            }


                            switch (alt32) {
                        	case 1 :
                        	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1015:19: operand
                        	    {
                        	    pushFollow(FOLLOW_operand_in_concat821);
                        	    operand23=operand();

                        	    state._fsp--;

                        	    	// for each operand, if no indices were specified, return all relevant connections from the design
                        	    				if ((operand23!=null?operand23.indices:null) == null) {
                        	    					List<Connection> connects = des.getConnectionsByName((operand23!=null?operand23.id:null).getText());
                        	    					if (connects.size() == 0)
                        	    						bailOut((operand23!=null?operand23.id:null), "undeclared connection");
                        	    					retval.cons.addAll(connects);
                        	    				
                        	    				// otherwise, only return connections with matching indices
                        	    				} else {
                        	    					for (int i = 0; i < (operand23!=null?operand23.indices:null).size(); i++) {
                        	    						Connection c = des.getConnection((operand23!=null?operand23.id:null).getText(), (operand23!=null?operand23.indices:null).get(i));
                        	    						if (c == null) {
                        	    							if (des.getConnectionsByName((operand23!=null?operand23.id:null).getText()).size() > 0)
                        	    								bailOut((operand23!=null?operand23.id:null), "invalid connection index [" + (operand23!=null?operand23.indices:null).get(i) + "]");
                        	    							else
                        	    								bailOut((operand23!=null?operand23.id:null), "undeclared connection");
                        	    						} else
                        	    							retval.cons.add(c);
                        	    					}
                        	    				}
                        	    			

                        	    }
                        	    break;

                        	default :
                        	    break loop32;
                            }
                        } while (true);


                        match(input, Token.UP, null); 
                    }

                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1040:4: ^( CONCAT_REPL operand )
                    {
                    match(input,CONCAT_REPL,FOLLOW_CONCAT_REPL_in_concat841); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_operand_in_concat843);
                    operand24=operand();

                    state._fsp--;

                    	retval.isReplicated = true;
                    				
                    				// if no indices were specified, return the relevant connection from the design
                    				if ((operand24!=null?operand24.indices:null) == null) {
                    					List<Connection> cons = des.getConnectionsByName((operand24!=null?operand24.id:null).getText());
                    					if (cons.size() == 0)
                    						bailOut((operand24!=null?operand24.id:null), "undeclared connection");
                    					if (cons.size() > 1)
                    						bailOut((operand24!=null?operand24.id:null), "assignment cannot replicate a an arrayed connection");
                    					retval.cons.add(cons.get(0));
                    					
                    				// otherwise, return the connection with the matching index
                    				} else {
                    					if ((operand24!=null?operand24.indices:null).size() != 1)
                    						bailOut((operand24!=null?operand24.id:null), "assignment cannot replicate an arrayed connection");
                    					Connection c = des.getConnection((operand24!=null?operand24.id:null).getText(), (operand24!=null?operand24.indices:null).get(0));
                    					if (c == null) {
                    						if (des.getConnectionsByName((operand24!=null?operand24.id:null).getText()).size() > 0)
                    							bailOut((operand24!=null?operand24.id:null), "invalid connection slice [" + (operand24!=null?operand24.indices:null).get(0) + "]");
                    						else	
                    							bailOut((operand24!=null?operand24.id:null), "undeclared connection");
                    					} else
                    						retval.cons.add(c);
                    				}
                    			

                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1069:4: ^( CONCAT_OPEN )
                    {
                    match(input,CONCAT_OPEN,FOLLOW_CONCAT_OPEN_in_concat863); 

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
    // $ANTLR end "concat"

    public static class operand_return extends TreeRuleReturnScope {
        public CommonTree id;
        public List<Integer> indices;
    };

    // $ANTLR start "operand"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1072:1: operand returns [CommonTree id, List<Integer> indices] : ^( OPERAND val= IDENT ( index )? ) ;
    public final PhdlAST.operand_return operand() throws RecognitionException {
        PhdlAST.operand_return retval = new PhdlAST.operand_return();
        retval.start = input.LT(1);

        CommonTree val=null;
        List<Integer> index25 = null;


        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1076:2: ( ^( OPERAND val= IDENT ( index )? ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1076:4: ^( OPERAND val= IDENT ( index )? )
            {
            match(input,OPERAND,FOLLOW_OPERAND_in_operand884); 

            match(input, Token.DOWN, null); 
            val=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_operand888); 
            retval.id = val;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1076:38: ( index )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=BOUNDS && LA34_0<=INDICES)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1076:39: index
                    {
                    pushFollow(FOLLOW_index_in_operand893);
                    index25=index();

                    state._fsp--;

                    retval.indices = index25;

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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1079:1: name returns [CommonTree id, List<Integer> indices] : ^( NAME val= IDENT ( index )? ) ;
    public final PhdlAST.name_return name() throws RecognitionException {
        PhdlAST.name_return retval = new PhdlAST.name_return();
        retval.start = input.LT(1);

        CommonTree val=null;
        List<Integer> index26 = null;


        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1083:2: ( ^( NAME val= IDENT ( index )? ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1083:4: ^( NAME val= IDENT ( index )? )
            {
            match(input,NAME,FOLLOW_NAME_in_name916); 

            match(input, Token.DOWN, null); 
            val=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_name920); 
            retval.id = val;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1083:35: ( index )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=BOUNDS && LA35_0<=INDICES)) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1083:36: index
                    {
                    pushFollow(FOLLOW_index_in_name925);
                    index26=index();

                    state._fsp--;

                    retval.indices = index26;

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

    public static class qualifier_return extends TreeRuleReturnScope {
        public List<Integer> indices;
        public CommonTree name;
    };

    // $ANTLR start "qualifier"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1086:1: qualifier returns [List<Integer> indices, CommonTree name] : ^(keyword= THIS ( index )? ) ;
    public final PhdlAST.qualifier_return qualifier() throws RecognitionException {
        PhdlAST.qualifier_return retval = new PhdlAST.qualifier_return();
        retval.start = input.LT(1);

        CommonTree keyword=null;
        List<Integer> index27 = null;


        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1087:2: ( ^(keyword= THIS ( index )? ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1087:4: ^(keyword= THIS ( index )? )
            {
            keyword=(CommonTree)match(input,THIS,FOLLOW_THIS_in_qualifier948); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1087:19: ( index )?
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>=BOUNDS && LA36_0<=INDICES)) ) {
                    alt36=1;
                }
                switch (alt36) {
                    case 1 :
                        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1087:19: index
                        {
                        pushFollow(FOLLOW_index_in_qualifier950);
                        index27=index();

                        state._fsp--;


                        }
                        break;

                }


                match(input, Token.UP, null); 
            }
            	retval.name = keyword;
            			retval.indices = index27;
            		

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
    // $ANTLR end "qualifier"


    // $ANTLR start "index"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1093:1: index returns [List<Integer> indices] : ( ^( BOUNDS hi= INT lo= INT ) | ^( INDICES (idx= INT )+ ) );
    public final List<Integer> index() throws RecognitionException {
        List<Integer> indices = null;

        CommonTree hi=null;
        CommonTree lo=null;
        CommonTree idx=null;

        indices = new ArrayList<Integer>();
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1100:2: ( ^( BOUNDS hi= INT lo= INT ) | ^( INDICES (idx= INT )+ ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==BOUNDS) ) {
                alt38=1;
            }
            else if ( (LA38_0==INDICES) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1100:4: ^( BOUNDS hi= INT lo= INT )
                    {
                    match(input,BOUNDS,FOLLOW_BOUNDS_in_index978); 

                    match(input, Token.DOWN, null); 
                    hi=(CommonTree)match(input,INT,FOLLOW_INT_in_index982); 
                    lo=(CommonTree)match(input,INT,FOLLOW_INT_in_index986); 

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
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1110:4: ^( INDICES (idx= INT )+ )
                    {
                    match(input,INDICES,FOLLOW_INDICES_in_index998); 

                    match(input, Token.DOWN, null); 
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1110:14: (idx= INT )+
                    int cnt37=0;
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==INT) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1110:15: idx= INT
                    	    {
                    	    idx=(CommonTree)match(input,INT,FOLLOW_INT_in_index1003); 
                    	    	if (indices.contains(Integer.parseInt((idx!=null?idx.getText():null))))
                    	    					bailOut(idx, "duplicate index");
                    	    				else
                    	    					indices.add(Integer.parseInt((idx!=null?idx.getText():null)));
                    	    			

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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1119:1: width returns [List<Integer> indices] : ^( WIDTH hi= INT lo= INT ) ;
    public final List<Integer> width() throws RecognitionException {
        List<Integer> indices = null;

        CommonTree hi=null;
        CommonTree lo=null;

        indices = new ArrayList<Integer>();
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1121:2: ( ^( WIDTH hi= INT lo= INT ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1121:4: ^( WIDTH hi= INT lo= INT )
            {
            match(input,WIDTH,FOLLOW_WIDTH_in_width1036); 

            match(input, Token.DOWN, null); 
            hi=(CommonTree)match(input,INT,FOLLOW_INT_in_width1040); 
            lo=(CommonTree)match(input,INT,FOLLOW_INT_in_width1044); 

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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1133:1: pinList returns [List<String> list] : ^( PIN_LIST (num1= INT | num2= IDENT | num3= PINNUM )+ ) ;
    public final List<String> pinList() throws RecognitionException {
        List<String> list = null;

        CommonTree num1=null;
        CommonTree num2=null;
        CommonTree num3=null;

        list = new ArrayList<String>();
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1135:2: ( ^( PIN_LIST (num1= INT | num2= IDENT | num3= PINNUM )+ ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1135:4: ^( PIN_LIST (num1= INT | num2= IDENT | num3= PINNUM )+ )
            {
            match(input,PIN_LIST,FOLLOW_PIN_LIST_in_pinList1069); 

            match(input, Token.DOWN, null); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1136:2: (num1= INT | num2= IDENT | num3= PINNUM )+
            int cnt39=0;
            loop39:
            do {
                int alt39=4;
                switch ( input.LA(1) ) {
                case INT:
                    {
                    alt39=1;
                    }
                    break;
                case IDENT:
                    {
                    alt39=2;
                    }
                    break;
                case PINNUM:
                    {
                    alt39=3;
                    }
                    break;

                }

                switch (alt39) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1136:4: num1= INT
            	    {
            	    num1=(CommonTree)match(input,INT,FOLLOW_INT_in_pinList1076); 
            	    list.add((num1!=null?num1.getText():null));

            	    }
            	    break;
            	case 2 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1137:4: num2= IDENT
            	    {
            	    num2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pinList1085); 
            	    list.add((num2!=null?num2.getText():null));

            	    }
            	    break;
            	case 3 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1138:4: num3= PINNUM
            	    {
            	    num3=(CommonTree)match(input,PINNUM,FOLLOW_PINNUM_in_pinList1094); 
            	    list.add((num3!=null?num3.getText():null));

            	    }
            	    break;

            	default :
            	    if ( cnt39 >= 1 ) break loop39;
                        EarlyExitException eee =
                            new EarlyExitException(39, input);
                        throw eee;
                }
                cnt39++;
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
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1142:1: pinType returns [PinType type] : ^( PIN_TYPE ( PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN ) ) ;
    public final PinType pinType() throws RecognitionException {
        PinType type = null;

        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1143:2: ( ^( PIN_TYPE ( PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN ) ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1143:4: ^( PIN_TYPE ( PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN ) )
            {
            match(input,PIN_TYPE,FOLLOW_PIN_TYPE_in_pinType1118); 

            match(input, Token.DOWN, null); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1144:2: ( PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN )
            int alt40=6;
            switch ( input.LA(1) ) {
            case PIN:
                {
                alt40=1;
                }
                break;
            case INPIN:
                {
                alt40=2;
                }
                break;
            case OUTPIN:
                {
                alt40=3;
                }
                break;
            case IOPIN:
                {
                alt40=4;
                }
                break;
            case PWRPIN:
                {
                alt40=5;
                }
                break;
            case SUPPIN:
                {
                alt40=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1144:4: PIN
                    {
                    match(input,PIN,FOLLOW_PIN_in_pinType1124); 
                    type = PinType.PIN;

                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1145:4: INPIN
                    {
                    match(input,INPIN,FOLLOW_INPIN_in_pinType1132); 
                    type = PinType.INPIN;

                    }
                    break;
                case 3 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1146:4: OUTPIN
                    {
                    match(input,OUTPIN,FOLLOW_OUTPIN_in_pinType1139); 
                    type = PinType.OUTPIN;

                    }
                    break;
                case 4 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1147:4: IOPIN
                    {
                    match(input,IOPIN,FOLLOW_IOPIN_in_pinType1146); 
                    type = PinType.IOPIN;

                    }
                    break;
                case 5 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1148:4: PWRPIN
                    {
                    match(input,PWRPIN,FOLLOW_PWRPIN_in_pinType1153); 
                    type = PinType.PWRPIN;

                    }
                    break;
                case 6 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1149:4: SUPPIN
                    {
                    match(input,SUPPIN,FOLLOW_SUPPIN_in_pinType1160); 
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
        public CommonTree name;
        public CommonTree info;
        public List<Integer> indices;
    };

    // $ANTLR start "infoDecl"
    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1152:1: infoDecl returns [CommonTree name, CommonTree info, List<Integer> indices] : ^( INFO_DECL ( qualifier )? (string= STRING )+ ) ;
    public final PhdlAST.infoDecl_return infoDecl() throws RecognitionException {
        PhdlAST.infoDecl_return retval = new PhdlAST.infoDecl_return();
        retval.start = input.LT(1);

        CommonTree string=null;
        PhdlAST.qualifier_return qualifier28 = null;


        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1153:2: ( ^( INFO_DECL ( qualifier )? (string= STRING )+ ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1153:5: ^( INFO_DECL ( qualifier )? (string= STRING )+ )
            {
            match(input,INFO_DECL,FOLLOW_INFO_DECL_in_infoDecl1182); 

            match(input, Token.DOWN, null); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1153:17: ( qualifier )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==THIS) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1153:17: qualifier
                    {
                    pushFollow(FOLLOW_qualifier_in_infoDecl1184);
                    qualifier28=qualifier();

                    state._fsp--;


                    }
                    break;

            }

            	
            			retval.indices = (qualifier28!=null?qualifier28.indices:null);
            			retval.name = (qualifier28!=null?qualifier28.name:null);
            		
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1158:3: (string= STRING )+
            int cnt42=0;
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==STRING) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/PhdlAST.g:1158:4: string= STRING
            	    {
            	    string=(CommonTree)match(input,STRING,FOLLOW_STRING_in_infoDecl1198); 
            	    retval.info = string;

            	    }
            	    break;

            	default :
            	    if ( cnt42 >= 1 ) break loop42;
                        EarlyExitException eee =
                            new EarlyExitException(42, input);
                        throw eee;
                }
                cnt42++;
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
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl127 = new BitSet(new long[]{0x0000800000000008L});
    public static final BitSet FOLLOW_ATTR_DECL_in_attrDecl151 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_attrDecl155 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_STRING_in_attrDecl159 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PIN_DECL_in_pinDecl180 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl184 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_pinType_in_pinDecl186 = new BitSet(new long[]{0xC000000000000000L});
    public static final BitSet FOLLOW_width_in_pinDecl188 = new BitSet(new long[]{0xC000000000000000L});
    public static final BitSet FOLLOW_pinList_in_pinDecl191 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DESIGN_DECL_in_designDecl215 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SUBDESIGN_DECL_in_designDecl219 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_designDecl225 = new BitSet(new long[]{0x043F000000000008L});
    public static final BitSet FOLLOW_groupDecl_in_designDecl239 = new BitSet(new long[]{0x043F000000000008L});
    public static final BitSet FOLLOW_portDecl_in_designDecl245 = new BitSet(new long[]{0x043F000000000008L});
    public static final BitSet FOLLOW_netDecl_in_designDecl252 = new BitSet(new long[]{0x043F000000000008L});
    public static final BitSet FOLLOW_instDecl_in_designDecl258 = new BitSet(new long[]{0x043F000000000008L});
    public static final BitSet FOLLOW_subInstDecl_in_designDecl264 = new BitSet(new long[]{0x043F000000000008L});
    public static final BitSet FOLLOW_connectAssign_in_designDecl270 = new BitSet(new long[]{0x043F000000000008L});
    public static final BitSet FOLLOW_infoDecl_in_designDecl277 = new BitSet(new long[]{0x043F000000000008L});
    public static final BitSet FOLLOW_GROUP_DECL_in_groupDecl302 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_groupDecl306 = new BitSet(new long[]{0x0427000000000008L});
    public static final BitSet FOLLOW_portDecl_in_groupDecl311 = new BitSet(new long[]{0x0427000000000008L});
    public static final BitSet FOLLOW_netDecl_in_groupDecl317 = new BitSet(new long[]{0x0427000000000008L});
    public static final BitSet FOLLOW_instDecl_in_groupDecl323 = new BitSet(new long[]{0x0427000000000008L});
    public static final BitSet FOLLOW_connectAssign_in_groupDecl329 = new BitSet(new long[]{0x0427000000000008L});
    public static final BitSet FOLLOW_infoDecl_in_groupDecl336 = new BitSet(new long[]{0x0427000000000008L});
    public static final BitSet FOLLOW_PORT_DECL_in_portDecl360 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_width_in_portDecl362 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_portDecl368 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000020L});
    public static final BitSet FOLLOW_NET_DECL_in_netDecl399 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_width_in_netDecl401 = new BitSet(new long[]{0x0000400000000008L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_netDecl407 = new BitSet(new long[]{0x0000400000000008L,0x0000000000000020L});
    public static final BitSet FOLLOW_attrDecl_in_netDecl427 = new BitSet(new long[]{0x0000400000000008L});
    public static final BitSet FOLLOW_INST_DECL_in_instDecl444 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_width_in_instDecl446 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_instDecl451 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_instDecl455 = new BitSet(new long[]{0x0160000000000008L});
    public static final BitSet FOLLOW_infoDecl_in_instDecl471 = new BitSet(new long[]{0x0160000000000008L});
    public static final BitSet FOLLOW_attrAssign_in_instDecl497 = new BitSet(new long[]{0x0140000000000008L});
    public static final BitSet FOLLOW_pinAssign_in_instDecl501 = new BitSet(new long[]{0x0100000000000008L});
    public static final BitSet FOLLOW_ATTR_ASSIGN_in_attrAssign533 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NEWATTR_in_attrAssign536 = new BitSet(new long[]{0x0000000002000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_qualifier_in_attrAssign542 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_attrAssign547 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_STRING_in_attrAssign551 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PIN_ASSIGN_in_pinAssign577 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_COMBINE_in_pinAssign580 = new BitSet(new long[]{0x0000000002000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_qualifier_in_pinAssign586 = new BitSet(new long[]{0x0000000002000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_operand_in_pinAssign589 = new BitSet(new long[]{0x3800000000000000L});
    public static final BitSet FOLLOW_concat_in_pinAssign591 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SUBINST_DECL_in_subInstDecl611 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_width_in_subInstDecl613 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_subInstDecl618 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
    public static final BitSet FOLLOW_STRING_in_subInstDecl622 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_subInstDecl627 = new BitSet(new long[]{0x02A0000000000008L});
    public static final BitSet FOLLOW_infoDecl_in_subInstDecl639 = new BitSet(new long[]{0x02A0000000000008L});
    public static final BitSet FOLLOW_subAttrAssign_in_subInstDecl663 = new BitSet(new long[]{0x0280000000000008L});
    public static final BitSet FOLLOW_portAssign_in_subInstDecl670 = new BitSet(new long[]{0x0200000000000008L});
    public static final BitSet FOLLOW_SUBATTR_ASSIGN_in_subAttrAssign691 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NEWATTR_in_subAttrAssign694 = new BitSet(new long[]{0x0000000002000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_qualifier_in_subAttrAssign700 = new BitSet(new long[]{0x0000000002000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_name_in_subAttrAssign706 = new BitSet(new long[]{0x0000000002000000L,0x0000000000000030L});
    public static final BitSet FOLLOW_IDENT_in_subAttrAssign714 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_STRING_in_subAttrAssign718 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PORT_ASSIGN_in_portAssign743 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_COMBINE_in_portAssign746 = new BitSet(new long[]{0x0000000002000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_qualifier_in_portAssign752 = new BitSet(new long[]{0x0000000002000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_operand_in_portAssign755 = new BitSet(new long[]{0x3800000000000000L});
    public static final BitSet FOLLOW_concat_in_portAssign757 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONNECT_ASSIGN_in_connectAssign780 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operand_in_connectAssign782 = new BitSet(new long[]{0x3800000000000000L});
    public static final BitSet FOLLOW_concat_in_connectAssign784 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONCAT_LIST_in_concat818 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operand_in_concat821 = new BitSet(new long[]{0x0000000002000008L,0x0000000000000008L});
    public static final BitSet FOLLOW_CONCAT_REPL_in_concat841 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operand_in_concat843 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONCAT_OPEN_in_concat863 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_OPERAND_in_operand884 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_operand888 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000006L});
    public static final BitSet FOLLOW_index_in_operand893 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NAME_in_name916 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_name920 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000006L});
    public static final BitSet FOLLOW_index_in_name925 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_THIS_in_qualifier948 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_index_in_qualifier950 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BOUNDS_in_index978 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_index982 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_INT_in_index986 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INDICES_in_index998 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_index1003 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000080L});
    public static final BitSet FOLLOW_WIDTH_in_width1036 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_width1040 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_INT_in_width1044 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PIN_LIST_in_pinList1069 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_pinList1076 = new BitSet(new long[]{0x0000000000000008L,0x00000000000001A0L});
    public static final BitSet FOLLOW_IDENT_in_pinList1085 = new BitSet(new long[]{0x0000000000000008L,0x00000000000001A0L});
    public static final BitSet FOLLOW_PINNUM_in_pinList1094 = new BitSet(new long[]{0x0000000000000008L,0x00000000000001A0L});
    public static final BitSet FOLLOW_PIN_TYPE_in_pinType1118 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PIN_in_pinType1124 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INPIN_in_pinType1132 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OUTPIN_in_pinType1139 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IOPIN_in_pinType1146 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PWRPIN_in_pinType1153 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SUPPIN_in_pinType1160 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INFO_DECL_in_infoDecl1182 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_qualifier_in_infoDecl1184 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_STRING_in_infoDecl1198 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000040L});

}