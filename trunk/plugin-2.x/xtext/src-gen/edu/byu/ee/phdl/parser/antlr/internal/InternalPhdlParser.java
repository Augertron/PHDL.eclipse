package edu.byu.ee.phdl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import edu.byu.ee.phdl.services.PhdlGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPhdlParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_PINNUM", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'package'", "'{'", "'}'", "'import'", "';'", "'device'", "'attr'", "'='", "','", "'info'", "'design'", "'subdesign'", "'net'", "'port'", "'inst'", "'of'", "'subinst'", "'newattr'", "'combine'", "'('", "')'", "'.'", "'&'", "'<'", "'>'", "'open'", "':'", "'['", "']'", "'this'", "'*'", "'pin'", "'inpin'", "'outpin'", "'iopin'", "'pwrpin'", "'suppin'", "'ocpin'", "'oepin'", "'tripin'", "'passpin'", "'ncpin'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__51=51;
    public static final int T__16=16;
    public static final int T__52=52;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=9;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=5;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_PINNUM=7;
    public static final int RULE_WS=10;

    // delegates
    // delegators


        public InternalPhdlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPhdlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPhdlParser.tokenNames; }
    public String getGrammarFileName() { return "../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g"; }



     	private PhdlGrammarAccess grammarAccess;
     	
        public InternalPhdlParser(TokenStream input, PhdlGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "PhdlModel";	
       	}
       	
       	@Override
       	protected PhdlGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRulePhdlModel"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:68:1: entryRulePhdlModel returns [EObject current=null] : iv_rulePhdlModel= rulePhdlModel EOF ;
    public final EObject entryRulePhdlModel() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePhdlModel = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:69:2: (iv_rulePhdlModel= rulePhdlModel EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:70:2: iv_rulePhdlModel= rulePhdlModel EOF
            {
             newCompositeNode(grammarAccess.getPhdlModelRule()); 
            pushFollow(FOLLOW_rulePhdlModel_in_entryRulePhdlModel75);
            iv_rulePhdlModel=rulePhdlModel();

            state._fsp--;

             current =iv_rulePhdlModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePhdlModel85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePhdlModel"


    // $ANTLR start "rulePhdlModel"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:77:1: rulePhdlModel returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( ( (lv_packages_1_0= rulePackage ) ) | ( (lv_devices_2_0= ruleDevice ) ) | ( (lv_designs_3_0= ruleDesign ) ) )* ) ;
    public final EObject rulePhdlModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_packages_1_0 = null;

        EObject lv_devices_2_0 = null;

        EObject lv_designs_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:80:28: ( ( ( (lv_imports_0_0= ruleImport ) )* ( ( (lv_packages_1_0= rulePackage ) ) | ( (lv_devices_2_0= ruleDevice ) ) | ( (lv_designs_3_0= ruleDesign ) ) )* ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:81:1: ( ( (lv_imports_0_0= ruleImport ) )* ( ( (lv_packages_1_0= rulePackage ) ) | ( (lv_devices_2_0= ruleDevice ) ) | ( (lv_designs_3_0= ruleDesign ) ) )* )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:81:1: ( ( (lv_imports_0_0= ruleImport ) )* ( ( (lv_packages_1_0= rulePackage ) ) | ( (lv_devices_2_0= ruleDevice ) ) | ( (lv_designs_3_0= ruleDesign ) ) )* )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:81:2: ( (lv_imports_0_0= ruleImport ) )* ( ( (lv_packages_1_0= rulePackage ) ) | ( (lv_devices_2_0= ruleDevice ) ) | ( (lv_designs_3_0= ruleDesign ) ) )*
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:81:2: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:82:1: (lv_imports_0_0= ruleImport )
            	    {
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:82:1: (lv_imports_0_0= ruleImport )
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:83:3: lv_imports_0_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPhdlModelAccess().getImportsImportParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_rulePhdlModel131);
            	    lv_imports_0_0=ruleImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPhdlModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"imports",
            	            		lv_imports_0_0, 
            	            		"Import");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:99:3: ( ( (lv_packages_1_0= rulePackage ) ) | ( (lv_devices_2_0= ruleDevice ) ) | ( (lv_designs_3_0= ruleDesign ) ) )*
            loop2:
            do {
                int alt2=4;
                switch ( input.LA(1) ) {
                case 11:
                    {
                    alt2=1;
                    }
                    break;
                case 16:
                    {
                    alt2=2;
                    }
                    break;
                case 21:
                case 22:
                    {
                    alt2=3;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:99:4: ( (lv_packages_1_0= rulePackage ) )
            	    {
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:99:4: ( (lv_packages_1_0= rulePackage ) )
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:100:1: (lv_packages_1_0= rulePackage )
            	    {
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:100:1: (lv_packages_1_0= rulePackage )
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:101:3: lv_packages_1_0= rulePackage
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPhdlModelAccess().getPackagesPackageParserRuleCall_1_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePackage_in_rulePhdlModel154);
            	    lv_packages_1_0=rulePackage();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPhdlModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"packages",
            	            		lv_packages_1_0, 
            	            		"Package");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:118:6: ( (lv_devices_2_0= ruleDevice ) )
            	    {
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:118:6: ( (lv_devices_2_0= ruleDevice ) )
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:119:1: (lv_devices_2_0= ruleDevice )
            	    {
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:119:1: (lv_devices_2_0= ruleDevice )
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:120:3: lv_devices_2_0= ruleDevice
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPhdlModelAccess().getDevicesDeviceParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDevice_in_rulePhdlModel181);
            	    lv_devices_2_0=ruleDevice();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPhdlModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"devices",
            	            		lv_devices_2_0, 
            	            		"Device");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:137:6: ( (lv_designs_3_0= ruleDesign ) )
            	    {
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:137:6: ( (lv_designs_3_0= ruleDesign ) )
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:138:1: (lv_designs_3_0= ruleDesign )
            	    {
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:138:1: (lv_designs_3_0= ruleDesign )
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:139:3: lv_designs_3_0= ruleDesign
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPhdlModelAccess().getDesignsDesignParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDesign_in_rulePhdlModel208);
            	    lv_designs_3_0=ruleDesign();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPhdlModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"designs",
            	            		lv_designs_3_0, 
            	            		"Design");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePhdlModel"


    // $ANTLR start "entryRulePackage"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:163:1: entryRulePackage returns [EObject current=null] : iv_rulePackage= rulePackage EOF ;
    public final EObject entryRulePackage() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackage = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:164:2: (iv_rulePackage= rulePackage EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:165:2: iv_rulePackage= rulePackage EOF
            {
             newCompositeNode(grammarAccess.getPackageRule()); 
            pushFollow(FOLLOW_rulePackage_in_entryRulePackage246);
            iv_rulePackage=rulePackage();

            state._fsp--;

             current =iv_rulePackage; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePackage256); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePackage"


    // $ANTLR start "rulePackage"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:172:1: rulePackage returns [EObject current=null] : (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( ( (lv_devices_4_0= ruleDevice ) ) | ( (lv_designs_5_0= ruleDesign ) ) )* otherlv_6= '}' ) ;
    public final EObject rulePackage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        EObject lv_imports_3_0 = null;

        EObject lv_devices_4_0 = null;

        EObject lv_designs_5_0 = null;


         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:175:28: ( (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( ( (lv_devices_4_0= ruleDevice ) ) | ( (lv_designs_5_0= ruleDesign ) ) )* otherlv_6= '}' ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:176:1: (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( ( (lv_devices_4_0= ruleDevice ) ) | ( (lv_designs_5_0= ruleDesign ) ) )* otherlv_6= '}' )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:176:1: (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( ( (lv_devices_4_0= ruleDevice ) ) | ( (lv_designs_5_0= ruleDesign ) ) )* otherlv_6= '}' )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:176:3: otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( ( (lv_devices_4_0= ruleDevice ) ) | ( (lv_designs_5_0= ruleDesign ) ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_rulePackage293); 

                	newLeafNode(otherlv_0, grammarAccess.getPackageAccess().getPackageKeyword_0());
                
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:180:1: ( (lv_name_1_0= RULE_ID ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:181:1: (lv_name_1_0= RULE_ID )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:181:1: (lv_name_1_0= RULE_ID )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:182:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePackage310); 

            			newLeafNode(lv_name_1_0, grammarAccess.getPackageAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPackageRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_rulePackage327); 

                	newLeafNode(otherlv_2, grammarAccess.getPackageAccess().getLeftCurlyBracketKeyword_2());
                
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:202:1: ( (lv_imports_3_0= ruleImport ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:203:1: (lv_imports_3_0= ruleImport )
            	    {
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:203:1: (lv_imports_3_0= ruleImport )
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:204:3: lv_imports_3_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPackageAccess().getImportsImportParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_rulePackage348);
            	    lv_imports_3_0=ruleImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPackageRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"imports",
            	            		lv_imports_3_0, 
            	            		"Import");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:220:3: ( ( (lv_devices_4_0= ruleDevice ) ) | ( (lv_designs_5_0= ruleDesign ) ) )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    alt4=1;
                }
                else if ( ((LA4_0>=21 && LA4_0<=22)) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:220:4: ( (lv_devices_4_0= ruleDevice ) )
            	    {
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:220:4: ( (lv_devices_4_0= ruleDevice ) )
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:221:1: (lv_devices_4_0= ruleDevice )
            	    {
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:221:1: (lv_devices_4_0= ruleDevice )
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:222:3: lv_devices_4_0= ruleDevice
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPackageAccess().getDevicesDeviceParserRuleCall_4_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDevice_in_rulePackage371);
            	    lv_devices_4_0=ruleDevice();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPackageRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"devices",
            	            		lv_devices_4_0, 
            	            		"Device");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:239:6: ( (lv_designs_5_0= ruleDesign ) )
            	    {
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:239:6: ( (lv_designs_5_0= ruleDesign ) )
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:240:1: (lv_designs_5_0= ruleDesign )
            	    {
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:240:1: (lv_designs_5_0= ruleDesign )
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:241:3: lv_designs_5_0= ruleDesign
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPackageAccess().getDesignsDesignParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDesign_in_rulePackage398);
            	    lv_designs_5_0=ruleDesign();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPackageRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"designs",
            	            		lv_designs_5_0, 
            	            		"Design");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_6=(Token)match(input,13,FOLLOW_13_in_rulePackage412); 

                	newLeafNode(otherlv_6, grammarAccess.getPackageAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePackage"


    // $ANTLR start "entryRuleImport"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:269:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:270:2: (iv_ruleImport= ruleImport EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:271:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport448);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport458); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:278:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) otherlv_2= ';' ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:281:28: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) otherlv_2= ';' ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:282:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) otherlv_2= ';' )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:282:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) otherlv_2= ';' )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:282:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleImport495); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:286:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:287:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:287:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:288:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard
            {
             
            	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport516);
            lv_importedNamespace_1_0=ruleQualifiedNameWithWildCard();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getImportRule());
            	        }
                   		set(
                   			current, 
                   			"importedNamespace",
                    		lv_importedNamespace_1_0, 
                    		"QualifiedNameWithWildCard");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleImport528); 

                	newLeafNode(otherlv_2, grammarAccess.getImportAccess().getSemicolonKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleDevice"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:316:1: entryRuleDevice returns [EObject current=null] : iv_ruleDevice= ruleDevice EOF ;
    public final EObject entryRuleDevice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDevice = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:317:2: (iv_ruleDevice= ruleDevice EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:318:2: iv_ruleDevice= ruleDevice EOF
            {
             newCompositeNode(grammarAccess.getDeviceRule()); 
            pushFollow(FOLLOW_ruleDevice_in_entryRuleDevice564);
            iv_ruleDevice=ruleDevice();

            state._fsp--;

             current =iv_ruleDevice; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDevice574); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDevice"


    // $ANTLR start "ruleDevice"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:325:1: ruleDevice returns [EObject current=null] : (otherlv_0= 'device' ( (lv_name_1_0= rulePhdlID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleDeviceElement ) )* otherlv_4= '}' ) ;
    public final EObject ruleDevice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_elements_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:328:28: ( (otherlv_0= 'device' ( (lv_name_1_0= rulePhdlID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleDeviceElement ) )* otherlv_4= '}' ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:329:1: (otherlv_0= 'device' ( (lv_name_1_0= rulePhdlID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleDeviceElement ) )* otherlv_4= '}' )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:329:1: (otherlv_0= 'device' ( (lv_name_1_0= rulePhdlID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleDeviceElement ) )* otherlv_4= '}' )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:329:3: otherlv_0= 'device' ( (lv_name_1_0= rulePhdlID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleDeviceElement ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleDevice611); 

                	newLeafNode(otherlv_0, grammarAccess.getDeviceAccess().getDeviceKeyword_0());
                
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:333:1: ( (lv_name_1_0= rulePhdlID ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:334:1: (lv_name_1_0= rulePhdlID )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:334:1: (lv_name_1_0= rulePhdlID )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:335:3: lv_name_1_0= rulePhdlID
            {
             
            	        newCompositeNode(grammarAccess.getDeviceAccess().getNamePhdlIDParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_rulePhdlID_in_ruleDevice632);
            lv_name_1_0=rulePhdlID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDeviceRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"PhdlID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleDevice644); 

                	newLeafNode(otherlv_2, grammarAccess.getDeviceAccess().getLeftCurlyBracketKeyword_2());
                
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:355:1: ( (lv_elements_3_0= ruleDeviceElement ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==17||LA5_0==20||(LA5_0>=42 && LA5_0<=52)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:356:1: (lv_elements_3_0= ruleDeviceElement )
            	    {
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:356:1: (lv_elements_3_0= ruleDeviceElement )
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:357:3: lv_elements_3_0= ruleDeviceElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDeviceAccess().getElementsDeviceElementParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDeviceElement_in_ruleDevice665);
            	    lv_elements_3_0=ruleDeviceElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDeviceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_3_0, 
            	            		"DeviceElement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleDevice678); 

                	newLeafNode(otherlv_4, grammarAccess.getDeviceAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDevice"


    // $ANTLR start "entryRuleDeviceElement"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:385:1: entryRuleDeviceElement returns [EObject current=null] : iv_ruleDeviceElement= ruleDeviceElement EOF ;
    public final EObject entryRuleDeviceElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeviceElement = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:386:2: (iv_ruleDeviceElement= ruleDeviceElement EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:387:2: iv_ruleDeviceElement= ruleDeviceElement EOF
            {
             newCompositeNode(grammarAccess.getDeviceElementRule()); 
            pushFollow(FOLLOW_ruleDeviceElement_in_entryRuleDeviceElement714);
            iv_ruleDeviceElement=ruleDeviceElement();

            state._fsp--;

             current =iv_ruleDeviceElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeviceElement724); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeviceElement"


    // $ANTLR start "ruleDeviceElement"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:394:1: ruleDeviceElement returns [EObject current=null] : (this_Attr_0= ruleAttr | this_Pin_1= rulePin | this_Info_2= ruleInfo ) ;
    public final EObject ruleDeviceElement() throws RecognitionException {
        EObject current = null;

        EObject this_Attr_0 = null;

        EObject this_Pin_1 = null;

        EObject this_Info_2 = null;


         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:397:28: ( (this_Attr_0= ruleAttr | this_Pin_1= rulePin | this_Info_2= ruleInfo ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:398:1: (this_Attr_0= ruleAttr | this_Pin_1= rulePin | this_Info_2= ruleInfo )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:398:1: (this_Attr_0= ruleAttr | this_Pin_1= rulePin | this_Info_2= ruleInfo )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt6=1;
                }
                break;
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
                {
                alt6=2;
                }
                break;
            case 20:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:399:5: this_Attr_0= ruleAttr
                    {
                     
                            newCompositeNode(grammarAccess.getDeviceElementAccess().getAttrParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleAttr_in_ruleDeviceElement771);
                    this_Attr_0=ruleAttr();

                    state._fsp--;

                     
                            current = this_Attr_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:409:5: this_Pin_1= rulePin
                    {
                     
                            newCompositeNode(grammarAccess.getDeviceElementAccess().getPinParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_rulePin_in_ruleDeviceElement798);
                    this_Pin_1=rulePin();

                    state._fsp--;

                     
                            current = this_Pin_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:419:5: this_Info_2= ruleInfo
                    {
                     
                            newCompositeNode(grammarAccess.getDeviceElementAccess().getInfoParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleInfo_in_ruleDeviceElement825);
                    this_Info_2=ruleInfo();

                    state._fsp--;

                     
                            current = this_Info_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeviceElement"


    // $ANTLR start "entryRuleAttr"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:435:1: entryRuleAttr returns [EObject current=null] : iv_ruleAttr= ruleAttr EOF ;
    public final EObject entryRuleAttr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttr = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:436:2: (iv_ruleAttr= ruleAttr EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:437:2: iv_ruleAttr= ruleAttr EOF
            {
             newCompositeNode(grammarAccess.getAttrRule()); 
            pushFollow(FOLLOW_ruleAttr_in_entryRuleAttr860);
            iv_ruleAttr=ruleAttr();

            state._fsp--;

             current =iv_ruleAttr; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttr870); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttr"


    // $ANTLR start "ruleAttr"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:444:1: ruleAttr returns [EObject current=null] : (otherlv_0= 'attr' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) otherlv_4= ';' ) ;
    public final EObject ruleAttr() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:447:28: ( (otherlv_0= 'attr' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) otherlv_4= ';' ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:448:1: (otherlv_0= 'attr' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) otherlv_4= ';' )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:448:1: (otherlv_0= 'attr' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) otherlv_4= ';' )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:448:3: otherlv_0= 'attr' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleAttr907); 

                	newLeafNode(otherlv_0, grammarAccess.getAttrAccess().getAttrKeyword_0());
                
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:452:1: ( (lv_name_1_0= RULE_ID ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:453:1: (lv_name_1_0= RULE_ID )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:453:1: (lv_name_1_0= RULE_ID )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:454:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAttr924); 

            			newLeafNode(lv_name_1_0, grammarAccess.getAttrAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAttrRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleAttr941); 

                	newLeafNode(otherlv_2, grammarAccess.getAttrAccess().getEqualsSignKeyword_2());
                
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:474:1: ( (lv_value_3_0= RULE_STRING ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:475:1: (lv_value_3_0= RULE_STRING )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:475:1: (lv_value_3_0= RULE_STRING )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:476:3: lv_value_3_0= RULE_STRING
            {
            lv_value_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAttr958); 

            			newLeafNode(lv_value_3_0, grammarAccess.getAttrAccess().getValueSTRINGTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAttrRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_3_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleAttr975); 

                	newLeafNode(otherlv_4, grammarAccess.getAttrAccess().getSemicolonKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttr"


    // $ANTLR start "entryRulePin"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:504:1: entryRulePin returns [EObject current=null] : iv_rulePin= rulePin EOF ;
    public final EObject entryRulePin() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePin = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:505:2: (iv_rulePin= rulePin EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:506:2: iv_rulePin= rulePin EOF
            {
             newCompositeNode(grammarAccess.getPinRule()); 
            pushFollow(FOLLOW_rulePin_in_entryRulePin1011);
            iv_rulePin=rulePin();

            state._fsp--;

             current =iv_rulePin; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePin1021); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePin"


    // $ANTLR start "rulePin"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:513:1: rulePin returns [EObject current=null] : ( ( (lv_type_0_0= rulePinType ) ) ( (lv_vector_1_0= ruleVector ) ) ( (lv_name_2_0= rulePhdlID ) ) otherlv_3= '=' otherlv_4= '{' ( ( (lv_pinNames_5_0= rulePhdlID ) ) (otherlv_6= ',' ( (lv_pinNames_7_0= rulePhdlID ) ) )* )? otherlv_8= '}' otherlv_9= ';' ) ;
    public final EObject rulePin() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Enumerator lv_type_0_0 = null;

        EObject lv_vector_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_pinNames_5_0 = null;

        AntlrDatatypeRuleToken lv_pinNames_7_0 = null;


         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:516:28: ( ( ( (lv_type_0_0= rulePinType ) ) ( (lv_vector_1_0= ruleVector ) ) ( (lv_name_2_0= rulePhdlID ) ) otherlv_3= '=' otherlv_4= '{' ( ( (lv_pinNames_5_0= rulePhdlID ) ) (otherlv_6= ',' ( (lv_pinNames_7_0= rulePhdlID ) ) )* )? otherlv_8= '}' otherlv_9= ';' ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:517:1: ( ( (lv_type_0_0= rulePinType ) ) ( (lv_vector_1_0= ruleVector ) ) ( (lv_name_2_0= rulePhdlID ) ) otherlv_3= '=' otherlv_4= '{' ( ( (lv_pinNames_5_0= rulePhdlID ) ) (otherlv_6= ',' ( (lv_pinNames_7_0= rulePhdlID ) ) )* )? otherlv_8= '}' otherlv_9= ';' )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:517:1: ( ( (lv_type_0_0= rulePinType ) ) ( (lv_vector_1_0= ruleVector ) ) ( (lv_name_2_0= rulePhdlID ) ) otherlv_3= '=' otherlv_4= '{' ( ( (lv_pinNames_5_0= rulePhdlID ) ) (otherlv_6= ',' ( (lv_pinNames_7_0= rulePhdlID ) ) )* )? otherlv_8= '}' otherlv_9= ';' )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:517:2: ( (lv_type_0_0= rulePinType ) ) ( (lv_vector_1_0= ruleVector ) ) ( (lv_name_2_0= rulePhdlID ) ) otherlv_3= '=' otherlv_4= '{' ( ( (lv_pinNames_5_0= rulePhdlID ) ) (otherlv_6= ',' ( (lv_pinNames_7_0= rulePhdlID ) ) )* )? otherlv_8= '}' otherlv_9= ';'
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:517:2: ( (lv_type_0_0= rulePinType ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:518:1: (lv_type_0_0= rulePinType )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:518:1: (lv_type_0_0= rulePinType )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:519:3: lv_type_0_0= rulePinType
            {
             
            	        newCompositeNode(grammarAccess.getPinAccess().getTypePinTypeEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_rulePinType_in_rulePin1067);
            lv_type_0_0=rulePinType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPinRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_0_0, 
                    		"PinType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:535:2: ( (lv_vector_1_0= ruleVector ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:536:1: (lv_vector_1_0= ruleVector )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:536:1: (lv_vector_1_0= ruleVector )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:537:3: lv_vector_1_0= ruleVector
            {
             
            	        newCompositeNode(grammarAccess.getPinAccess().getVectorVectorParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleVector_in_rulePin1088);
            lv_vector_1_0=ruleVector();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPinRule());
            	        }
                   		set(
                   			current, 
                   			"vector",
                    		lv_vector_1_0, 
                    		"Vector");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:553:2: ( (lv_name_2_0= rulePhdlID ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:554:1: (lv_name_2_0= rulePhdlID )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:554:1: (lv_name_2_0= rulePhdlID )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:555:3: lv_name_2_0= rulePhdlID
            {
             
            	        newCompositeNode(grammarAccess.getPinAccess().getNamePhdlIDParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_rulePhdlID_in_rulePin1109);
            lv_name_2_0=rulePhdlID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPinRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"PhdlID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,18,FOLLOW_18_in_rulePin1121); 

                	newLeafNode(otherlv_3, grammarAccess.getPinAccess().getEqualsSignKeyword_3());
                
            otherlv_4=(Token)match(input,12,FOLLOW_12_in_rulePin1133); 

                	newLeafNode(otherlv_4, grammarAccess.getPinAccess().getLeftCurlyBracketKeyword_4());
                
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:579:1: ( ( (lv_pinNames_5_0= rulePhdlID ) ) (otherlv_6= ',' ( (lv_pinNames_7_0= rulePhdlID ) ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID||(LA8_0>=RULE_INT && LA8_0<=RULE_PINNUM)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:579:2: ( (lv_pinNames_5_0= rulePhdlID ) ) (otherlv_6= ',' ( (lv_pinNames_7_0= rulePhdlID ) ) )*
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:579:2: ( (lv_pinNames_5_0= rulePhdlID ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:580:1: (lv_pinNames_5_0= rulePhdlID )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:580:1: (lv_pinNames_5_0= rulePhdlID )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:581:3: lv_pinNames_5_0= rulePhdlID
                    {
                     
                    	        newCompositeNode(grammarAccess.getPinAccess().getPinNamesPhdlIDParserRuleCall_5_0_0()); 
                    	    
                    pushFollow(FOLLOW_rulePhdlID_in_rulePin1155);
                    lv_pinNames_5_0=rulePhdlID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPinRule());
                    	        }
                           		add(
                           			current, 
                           			"pinNames",
                            		lv_pinNames_5_0, 
                            		"PhdlID");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:597:2: (otherlv_6= ',' ( (lv_pinNames_7_0= rulePhdlID ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==19) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:597:4: otherlv_6= ',' ( (lv_pinNames_7_0= rulePhdlID ) )
                    	    {
                    	    otherlv_6=(Token)match(input,19,FOLLOW_19_in_rulePin1168); 

                    	        	newLeafNode(otherlv_6, grammarAccess.getPinAccess().getCommaKeyword_5_1_0());
                    	        
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:601:1: ( (lv_pinNames_7_0= rulePhdlID ) )
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:602:1: (lv_pinNames_7_0= rulePhdlID )
                    	    {
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:602:1: (lv_pinNames_7_0= rulePhdlID )
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:603:3: lv_pinNames_7_0= rulePhdlID
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getPinAccess().getPinNamesPhdlIDParserRuleCall_5_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePhdlID_in_rulePin1189);
                    	    lv_pinNames_7_0=rulePhdlID();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getPinRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"pinNames",
                    	            		lv_pinNames_7_0, 
                    	            		"PhdlID");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_8=(Token)match(input,13,FOLLOW_13_in_rulePin1205); 

                	newLeafNode(otherlv_8, grammarAccess.getPinAccess().getRightCurlyBracketKeyword_6());
                
            otherlv_9=(Token)match(input,15,FOLLOW_15_in_rulePin1217); 

                	newLeafNode(otherlv_9, grammarAccess.getPinAccess().getSemicolonKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePin"


    // $ANTLR start "entryRuleInfo"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:635:1: entryRuleInfo returns [EObject current=null] : iv_ruleInfo= ruleInfo EOF ;
    public final EObject entryRuleInfo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfo = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:636:2: (iv_ruleInfo= ruleInfo EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:637:2: iv_ruleInfo= ruleInfo EOF
            {
             newCompositeNode(grammarAccess.getInfoRule()); 
            pushFollow(FOLLOW_ruleInfo_in_entryRuleInfo1253);
            iv_ruleInfo=ruleInfo();

            state._fsp--;

             current =iv_ruleInfo; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInfo1263); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInfo"


    // $ANTLR start "ruleInfo"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:644:1: ruleInfo returns [EObject current=null] : (otherlv_0= 'info' otherlv_1= '{' ( (lv_info_2_0= RULE_STRING ) ) otherlv_3= '}' ) ;
    public final EObject ruleInfo() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_info_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:647:28: ( (otherlv_0= 'info' otherlv_1= '{' ( (lv_info_2_0= RULE_STRING ) ) otherlv_3= '}' ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:648:1: (otherlv_0= 'info' otherlv_1= '{' ( (lv_info_2_0= RULE_STRING ) ) otherlv_3= '}' )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:648:1: (otherlv_0= 'info' otherlv_1= '{' ( (lv_info_2_0= RULE_STRING ) ) otherlv_3= '}' )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:648:3: otherlv_0= 'info' otherlv_1= '{' ( (lv_info_2_0= RULE_STRING ) ) otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleInfo1300); 

                	newLeafNode(otherlv_0, grammarAccess.getInfoAccess().getInfoKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleInfo1312); 

                	newLeafNode(otherlv_1, grammarAccess.getInfoAccess().getLeftCurlyBracketKeyword_1());
                
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:656:1: ( (lv_info_2_0= RULE_STRING ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:657:1: (lv_info_2_0= RULE_STRING )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:657:1: (lv_info_2_0= RULE_STRING )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:658:3: lv_info_2_0= RULE_STRING
            {
            lv_info_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleInfo1329); 

            			newLeafNode(lv_info_2_0, grammarAccess.getInfoAccess().getInfoSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getInfoRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"info",
                    		lv_info_2_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleInfo1346); 

                	newLeafNode(otherlv_3, grammarAccess.getInfoAccess().getRightCurlyBracketKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInfo"


    // $ANTLR start "entryRuleDesign"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:686:1: entryRuleDesign returns [EObject current=null] : iv_ruleDesign= ruleDesign EOF ;
    public final EObject entryRuleDesign() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDesign = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:687:2: (iv_ruleDesign= ruleDesign EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:688:2: iv_ruleDesign= ruleDesign EOF
            {
             newCompositeNode(grammarAccess.getDesignRule()); 
            pushFollow(FOLLOW_ruleDesign_in_entryRuleDesign1382);
            iv_ruleDesign=ruleDesign();

            state._fsp--;

             current =iv_ruleDesign; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDesign1392); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDesign"


    // $ANTLR start "ruleDesign"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:695:1: ruleDesign returns [EObject current=null] : ( ( ( (lv_design_0_0= 'design' ) ) | ( (lv_subdesign_1_0= 'subdesign' ) ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_elements_4_0= ruleDesignElement ) )* otherlv_5= '}' ) ;
    public final EObject ruleDesign() throws RecognitionException {
        EObject current = null;

        Token lv_design_0_0=null;
        Token lv_subdesign_1_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_elements_4_0 = null;


         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:698:28: ( ( ( ( (lv_design_0_0= 'design' ) ) | ( (lv_subdesign_1_0= 'subdesign' ) ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_elements_4_0= ruleDesignElement ) )* otherlv_5= '}' ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:699:1: ( ( ( (lv_design_0_0= 'design' ) ) | ( (lv_subdesign_1_0= 'subdesign' ) ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_elements_4_0= ruleDesignElement ) )* otherlv_5= '}' )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:699:1: ( ( ( (lv_design_0_0= 'design' ) ) | ( (lv_subdesign_1_0= 'subdesign' ) ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_elements_4_0= ruleDesignElement ) )* otherlv_5= '}' )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:699:2: ( ( (lv_design_0_0= 'design' ) ) | ( (lv_subdesign_1_0= 'subdesign' ) ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_elements_4_0= ruleDesignElement ) )* otherlv_5= '}'
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:699:2: ( ( (lv_design_0_0= 'design' ) ) | ( (lv_subdesign_1_0= 'subdesign' ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==21) ) {
                alt9=1;
            }
            else if ( (LA9_0==22) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:699:3: ( (lv_design_0_0= 'design' ) )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:699:3: ( (lv_design_0_0= 'design' ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:700:1: (lv_design_0_0= 'design' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:700:1: (lv_design_0_0= 'design' )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:701:3: lv_design_0_0= 'design'
                    {
                    lv_design_0_0=(Token)match(input,21,FOLLOW_21_in_ruleDesign1436); 

                            newLeafNode(lv_design_0_0, grammarAccess.getDesignAccess().getDesignDesignKeyword_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDesignRule());
                    	        }
                           		setWithLastConsumed(current, "design", true, "design");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:715:6: ( (lv_subdesign_1_0= 'subdesign' ) )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:715:6: ( (lv_subdesign_1_0= 'subdesign' ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:716:1: (lv_subdesign_1_0= 'subdesign' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:716:1: (lv_subdesign_1_0= 'subdesign' )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:717:3: lv_subdesign_1_0= 'subdesign'
                    {
                    lv_subdesign_1_0=(Token)match(input,22,FOLLOW_22_in_ruleDesign1473); 

                            newLeafNode(lv_subdesign_1_0, grammarAccess.getDesignAccess().getSubdesignSubdesignKeyword_0_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDesignRule());
                    	        }
                           		setWithLastConsumed(current, "subdesign", true, "subdesign");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:730:3: ( (lv_name_2_0= RULE_ID ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:731:1: (lv_name_2_0= RULE_ID )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:731:1: (lv_name_2_0= RULE_ID )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:732:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDesign1504); 

            			newLeafNode(lv_name_2_0, grammarAccess.getDesignAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDesignRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleDesign1521); 

                	newLeafNode(otherlv_3, grammarAccess.getDesignAccess().getLeftCurlyBracketKeyword_2());
                
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:752:1: ( (lv_elements_4_0= ruleDesignElement ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID||(LA10_0>=RULE_INT && LA10_0<=RULE_PINNUM)||LA10_0==20||(LA10_0>=23 && LA10_0<=25)||LA10_0==27) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:753:1: (lv_elements_4_0= ruleDesignElement )
            	    {
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:753:1: (lv_elements_4_0= ruleDesignElement )
            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:754:3: lv_elements_4_0= ruleDesignElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDesignAccess().getElementsDesignElementParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDesignElement_in_ruleDesign1542);
            	    lv_elements_4_0=ruleDesignElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDesignRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_4_0, 
            	            		"DesignElement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleDesign1555); 

                	newLeafNode(otherlv_5, grammarAccess.getDesignAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDesign"


    // $ANTLR start "entryRuleDesignElement"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:782:1: entryRuleDesignElement returns [EObject current=null] : iv_ruleDesignElement= ruleDesignElement EOF ;
    public final EObject entryRuleDesignElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDesignElement = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:783:2: (iv_ruleDesignElement= ruleDesignElement EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:784:2: iv_ruleDesignElement= ruleDesignElement EOF
            {
             newCompositeNode(grammarAccess.getDesignElementRule()); 
            pushFollow(FOLLOW_ruleDesignElement_in_entryRuleDesignElement1591);
            iv_ruleDesignElement=ruleDesignElement();

            state._fsp--;

             current =iv_ruleDesignElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDesignElement1601); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDesignElement"


    // $ANTLR start "ruleDesignElement"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:791:1: ruleDesignElement returns [EObject current=null] : (this_Connection_0= ruleConnection | this_Instance_1= ruleInstance | this_ConnectionAssign_2= ruleConnectionAssign | this_Info_3= ruleInfo ) ;
    public final EObject ruleDesignElement() throws RecognitionException {
        EObject current = null;

        EObject this_Connection_0 = null;

        EObject this_Instance_1 = null;

        EObject this_ConnectionAssign_2 = null;

        EObject this_Info_3 = null;


         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:794:28: ( (this_Connection_0= ruleConnection | this_Instance_1= ruleInstance | this_ConnectionAssign_2= ruleConnectionAssign | this_Info_3= ruleInfo ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:795:1: (this_Connection_0= ruleConnection | this_Instance_1= ruleInstance | this_ConnectionAssign_2= ruleConnectionAssign | this_Info_3= ruleInfo )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:795:1: (this_Connection_0= ruleConnection | this_Instance_1= ruleInstance | this_ConnectionAssign_2= ruleConnectionAssign | this_Info_3= ruleInfo )
            int alt11=4;
            switch ( input.LA(1) ) {
            case 23:
            case 24:
                {
                alt11=1;
                }
                break;
            case 25:
            case 27:
                {
                alt11=2;
                }
                break;
            case RULE_ID:
            case RULE_INT:
            case RULE_PINNUM:
                {
                alt11=3;
                }
                break;
            case 20:
                {
                alt11=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:796:5: this_Connection_0= ruleConnection
                    {
                     
                            newCompositeNode(grammarAccess.getDesignElementAccess().getConnectionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleConnection_in_ruleDesignElement1648);
                    this_Connection_0=ruleConnection();

                    state._fsp--;

                     
                            current = this_Connection_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:806:5: this_Instance_1= ruleInstance
                    {
                     
                            newCompositeNode(grammarAccess.getDesignElementAccess().getInstanceParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleInstance_in_ruleDesignElement1675);
                    this_Instance_1=ruleInstance();

                    state._fsp--;

                     
                            current = this_Instance_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:816:5: this_ConnectionAssign_2= ruleConnectionAssign
                    {
                     
                            newCompositeNode(grammarAccess.getDesignElementAccess().getConnectionAssignParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleConnectionAssign_in_ruleDesignElement1702);
                    this_ConnectionAssign_2=ruleConnectionAssign();

                    state._fsp--;

                     
                            current = this_ConnectionAssign_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:826:5: this_Info_3= ruleInfo
                    {
                     
                            newCompositeNode(grammarAccess.getDesignElementAccess().getInfoParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleInfo_in_ruleDesignElement1729);
                    this_Info_3=ruleInfo();

                    state._fsp--;

                     
                            current = this_Info_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDesignElement"


    // $ANTLR start "entryRuleConnection"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:842:1: entryRuleConnection returns [EObject current=null] : iv_ruleConnection= ruleConnection EOF ;
    public final EObject entryRuleConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnection = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:843:2: (iv_ruleConnection= ruleConnection EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:844:2: iv_ruleConnection= ruleConnection EOF
            {
             newCompositeNode(grammarAccess.getConnectionRule()); 
            pushFollow(FOLLOW_ruleConnection_in_entryRuleConnection1764);
            iv_ruleConnection=ruleConnection();

            state._fsp--;

             current =iv_ruleConnection; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnection1774); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConnection"


    // $ANTLR start "ruleConnection"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:851:1: ruleConnection returns [EObject current=null] : ( ( ( (lv_net_0_0= 'net' ) ) ( (lv_vector_1_0= ruleVector ) ) ( (lv_names_2_0= ruleConnectionName ) ) (otherlv_3= ',' ( (lv_names_4_0= ruleConnectionName ) ) )* ( (otherlv_5= '{' ( (lv_elements_6_0= ruleNetElement ) )* otherlv_7= '}' ) | otherlv_8= ';' ) ) | ( ( (lv_port_9_0= 'port' ) ) ( (lv_vector_10_0= ruleVector ) ) ( (lv_names_11_0= ruleConnectionName ) ) (otherlv_12= ',' ( (lv_names_13_0= ruleConnectionName ) ) )* ( (otherlv_14= '{' ( (lv_elements_15_0= rulePortElement ) )* otherlv_16= '}' ) | otherlv_17= ';' ) ) ) ;
    public final EObject ruleConnection() throws RecognitionException {
        EObject current = null;

        Token lv_net_0_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_port_9_0=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        EObject lv_vector_1_0 = null;

        EObject lv_names_2_0 = null;

        EObject lv_names_4_0 = null;

        EObject lv_elements_6_0 = null;

        EObject lv_vector_10_0 = null;

        EObject lv_names_11_0 = null;

        EObject lv_names_13_0 = null;

        EObject lv_elements_15_0 = null;


         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:854:28: ( ( ( ( (lv_net_0_0= 'net' ) ) ( (lv_vector_1_0= ruleVector ) ) ( (lv_names_2_0= ruleConnectionName ) ) (otherlv_3= ',' ( (lv_names_4_0= ruleConnectionName ) ) )* ( (otherlv_5= '{' ( (lv_elements_6_0= ruleNetElement ) )* otherlv_7= '}' ) | otherlv_8= ';' ) ) | ( ( (lv_port_9_0= 'port' ) ) ( (lv_vector_10_0= ruleVector ) ) ( (lv_names_11_0= ruleConnectionName ) ) (otherlv_12= ',' ( (lv_names_13_0= ruleConnectionName ) ) )* ( (otherlv_14= '{' ( (lv_elements_15_0= rulePortElement ) )* otherlv_16= '}' ) | otherlv_17= ';' ) ) ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:855:1: ( ( ( (lv_net_0_0= 'net' ) ) ( (lv_vector_1_0= ruleVector ) ) ( (lv_names_2_0= ruleConnectionName ) ) (otherlv_3= ',' ( (lv_names_4_0= ruleConnectionName ) ) )* ( (otherlv_5= '{' ( (lv_elements_6_0= ruleNetElement ) )* otherlv_7= '}' ) | otherlv_8= ';' ) ) | ( ( (lv_port_9_0= 'port' ) ) ( (lv_vector_10_0= ruleVector ) ) ( (lv_names_11_0= ruleConnectionName ) ) (otherlv_12= ',' ( (lv_names_13_0= ruleConnectionName ) ) )* ( (otherlv_14= '{' ( (lv_elements_15_0= rulePortElement ) )* otherlv_16= '}' ) | otherlv_17= ';' ) ) )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:855:1: ( ( ( (lv_net_0_0= 'net' ) ) ( (lv_vector_1_0= ruleVector ) ) ( (lv_names_2_0= ruleConnectionName ) ) (otherlv_3= ',' ( (lv_names_4_0= ruleConnectionName ) ) )* ( (otherlv_5= '{' ( (lv_elements_6_0= ruleNetElement ) )* otherlv_7= '}' ) | otherlv_8= ';' ) ) | ( ( (lv_port_9_0= 'port' ) ) ( (lv_vector_10_0= ruleVector ) ) ( (lv_names_11_0= ruleConnectionName ) ) (otherlv_12= ',' ( (lv_names_13_0= ruleConnectionName ) ) )* ( (otherlv_14= '{' ( (lv_elements_15_0= rulePortElement ) )* otherlv_16= '}' ) | otherlv_17= ';' ) ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==23) ) {
                alt18=1;
            }
            else if ( (LA18_0==24) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:855:2: ( ( (lv_net_0_0= 'net' ) ) ( (lv_vector_1_0= ruleVector ) ) ( (lv_names_2_0= ruleConnectionName ) ) (otherlv_3= ',' ( (lv_names_4_0= ruleConnectionName ) ) )* ( (otherlv_5= '{' ( (lv_elements_6_0= ruleNetElement ) )* otherlv_7= '}' ) | otherlv_8= ';' ) )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:855:2: ( ( (lv_net_0_0= 'net' ) ) ( (lv_vector_1_0= ruleVector ) ) ( (lv_names_2_0= ruleConnectionName ) ) (otherlv_3= ',' ( (lv_names_4_0= ruleConnectionName ) ) )* ( (otherlv_5= '{' ( (lv_elements_6_0= ruleNetElement ) )* otherlv_7= '}' ) | otherlv_8= ';' ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:855:3: ( (lv_net_0_0= 'net' ) ) ( (lv_vector_1_0= ruleVector ) ) ( (lv_names_2_0= ruleConnectionName ) ) (otherlv_3= ',' ( (lv_names_4_0= ruleConnectionName ) ) )* ( (otherlv_5= '{' ( (lv_elements_6_0= ruleNetElement ) )* otherlv_7= '}' ) | otherlv_8= ';' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:855:3: ( (lv_net_0_0= 'net' ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:856:1: (lv_net_0_0= 'net' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:856:1: (lv_net_0_0= 'net' )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:857:3: lv_net_0_0= 'net'
                    {
                    lv_net_0_0=(Token)match(input,23,FOLLOW_23_in_ruleConnection1818); 

                            newLeafNode(lv_net_0_0, grammarAccess.getConnectionAccess().getNetNetKeyword_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConnectionRule());
                    	        }
                           		setWithLastConsumed(current, "net", true, "net");
                    	    

                    }


                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:870:2: ( (lv_vector_1_0= ruleVector ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:871:1: (lv_vector_1_0= ruleVector )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:871:1: (lv_vector_1_0= ruleVector )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:872:3: lv_vector_1_0= ruleVector
                    {
                     
                    	        newCompositeNode(grammarAccess.getConnectionAccess().getVectorVectorParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVector_in_ruleConnection1852);
                    lv_vector_1_0=ruleVector();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConnectionRule());
                    	        }
                           		set(
                           			current, 
                           			"vector",
                            		lv_vector_1_0, 
                            		"Vector");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:888:2: ( (lv_names_2_0= ruleConnectionName ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:889:1: (lv_names_2_0= ruleConnectionName )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:889:1: (lv_names_2_0= ruleConnectionName )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:890:3: lv_names_2_0= ruleConnectionName
                    {
                     
                    	        newCompositeNode(grammarAccess.getConnectionAccess().getNamesConnectionNameParserRuleCall_0_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleConnectionName_in_ruleConnection1873);
                    lv_names_2_0=ruleConnectionName();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConnectionRule());
                    	        }
                           		add(
                           			current, 
                           			"names",
                            		lv_names_2_0, 
                            		"ConnectionName");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:906:2: (otherlv_3= ',' ( (lv_names_4_0= ruleConnectionName ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==19) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:906:4: otherlv_3= ',' ( (lv_names_4_0= ruleConnectionName ) )
                    	    {
                    	    otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleConnection1886); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getConnectionAccess().getCommaKeyword_0_3_0());
                    	        
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:910:1: ( (lv_names_4_0= ruleConnectionName ) )
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:911:1: (lv_names_4_0= ruleConnectionName )
                    	    {
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:911:1: (lv_names_4_0= ruleConnectionName )
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:912:3: lv_names_4_0= ruleConnectionName
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getConnectionAccess().getNamesConnectionNameParserRuleCall_0_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleConnectionName_in_ruleConnection1907);
                    	    lv_names_4_0=ruleConnectionName();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getConnectionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"names",
                    	            		lv_names_4_0, 
                    	            		"ConnectionName");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:928:4: ( (otherlv_5= '{' ( (lv_elements_6_0= ruleNetElement ) )* otherlv_7= '}' ) | otherlv_8= ';' )
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==12) ) {
                        alt14=1;
                    }
                    else if ( (LA14_0==15) ) {
                        alt14=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 0, input);

                        throw nvae;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:928:5: (otherlv_5= '{' ( (lv_elements_6_0= ruleNetElement ) )* otherlv_7= '}' )
                            {
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:928:5: (otherlv_5= '{' ( (lv_elements_6_0= ruleNetElement ) )* otherlv_7= '}' )
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:928:7: otherlv_5= '{' ( (lv_elements_6_0= ruleNetElement ) )* otherlv_7= '}'
                            {
                            otherlv_5=(Token)match(input,12,FOLLOW_12_in_ruleConnection1923); 

                                	newLeafNode(otherlv_5, grammarAccess.getConnectionAccess().getLeftCurlyBracketKeyword_0_4_0_0());
                                
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:932:1: ( (lv_elements_6_0= ruleNetElement ) )*
                            loop13:
                            do {
                                int alt13=2;
                                int LA13_0 = input.LA(1);

                                if ( (LA13_0==17||LA13_0==20) ) {
                                    alt13=1;
                                }


                                switch (alt13) {
                            	case 1 :
                            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:933:1: (lv_elements_6_0= ruleNetElement )
                            	    {
                            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:933:1: (lv_elements_6_0= ruleNetElement )
                            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:934:3: lv_elements_6_0= ruleNetElement
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getConnectionAccess().getElementsNetElementParserRuleCall_0_4_0_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleNetElement_in_ruleConnection1944);
                            	    lv_elements_6_0=ruleNetElement();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getConnectionRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"elements",
                            	            		lv_elements_6_0, 
                            	            		"NetElement");
                            	    	        afterParserOrEnumRuleCall();
                            	    	    

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop13;
                                }
                            } while (true);

                            otherlv_7=(Token)match(input,13,FOLLOW_13_in_ruleConnection1957); 

                                	newLeafNode(otherlv_7, grammarAccess.getConnectionAccess().getRightCurlyBracketKeyword_0_4_0_2());
                                

                            }


                            }
                            break;
                        case 2 :
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:955:7: otherlv_8= ';'
                            {
                            otherlv_8=(Token)match(input,15,FOLLOW_15_in_ruleConnection1976); 

                                	newLeafNode(otherlv_8, grammarAccess.getConnectionAccess().getSemicolonKeyword_0_4_1());
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:960:6: ( ( (lv_port_9_0= 'port' ) ) ( (lv_vector_10_0= ruleVector ) ) ( (lv_names_11_0= ruleConnectionName ) ) (otherlv_12= ',' ( (lv_names_13_0= ruleConnectionName ) ) )* ( (otherlv_14= '{' ( (lv_elements_15_0= rulePortElement ) )* otherlv_16= '}' ) | otherlv_17= ';' ) )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:960:6: ( ( (lv_port_9_0= 'port' ) ) ( (lv_vector_10_0= ruleVector ) ) ( (lv_names_11_0= ruleConnectionName ) ) (otherlv_12= ',' ( (lv_names_13_0= ruleConnectionName ) ) )* ( (otherlv_14= '{' ( (lv_elements_15_0= rulePortElement ) )* otherlv_16= '}' ) | otherlv_17= ';' ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:960:7: ( (lv_port_9_0= 'port' ) ) ( (lv_vector_10_0= ruleVector ) ) ( (lv_names_11_0= ruleConnectionName ) ) (otherlv_12= ',' ( (lv_names_13_0= ruleConnectionName ) ) )* ( (otherlv_14= '{' ( (lv_elements_15_0= rulePortElement ) )* otherlv_16= '}' ) | otherlv_17= ';' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:960:7: ( (lv_port_9_0= 'port' ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:961:1: (lv_port_9_0= 'port' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:961:1: (lv_port_9_0= 'port' )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:962:3: lv_port_9_0= 'port'
                    {
                    lv_port_9_0=(Token)match(input,24,FOLLOW_24_in_ruleConnection2003); 

                            newLeafNode(lv_port_9_0, grammarAccess.getConnectionAccess().getPortPortKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConnectionRule());
                    	        }
                           		setWithLastConsumed(current, "port", true, "port");
                    	    

                    }


                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:975:2: ( (lv_vector_10_0= ruleVector ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:976:1: (lv_vector_10_0= ruleVector )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:976:1: (lv_vector_10_0= ruleVector )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:977:3: lv_vector_10_0= ruleVector
                    {
                     
                    	        newCompositeNode(grammarAccess.getConnectionAccess().getVectorVectorParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVector_in_ruleConnection2037);
                    lv_vector_10_0=ruleVector();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConnectionRule());
                    	        }
                           		set(
                           			current, 
                           			"vector",
                            		lv_vector_10_0, 
                            		"Vector");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:993:2: ( (lv_names_11_0= ruleConnectionName ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:994:1: (lv_names_11_0= ruleConnectionName )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:994:1: (lv_names_11_0= ruleConnectionName )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:995:3: lv_names_11_0= ruleConnectionName
                    {
                     
                    	        newCompositeNode(grammarAccess.getConnectionAccess().getNamesConnectionNameParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleConnectionName_in_ruleConnection2058);
                    lv_names_11_0=ruleConnectionName();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConnectionRule());
                    	        }
                           		add(
                           			current, 
                           			"names",
                            		lv_names_11_0, 
                            		"ConnectionName");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1011:2: (otherlv_12= ',' ( (lv_names_13_0= ruleConnectionName ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==19) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1011:4: otherlv_12= ',' ( (lv_names_13_0= ruleConnectionName ) )
                    	    {
                    	    otherlv_12=(Token)match(input,19,FOLLOW_19_in_ruleConnection2071); 

                    	        	newLeafNode(otherlv_12, grammarAccess.getConnectionAccess().getCommaKeyword_1_3_0());
                    	        
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1015:1: ( (lv_names_13_0= ruleConnectionName ) )
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1016:1: (lv_names_13_0= ruleConnectionName )
                    	    {
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1016:1: (lv_names_13_0= ruleConnectionName )
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1017:3: lv_names_13_0= ruleConnectionName
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getConnectionAccess().getNamesConnectionNameParserRuleCall_1_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleConnectionName_in_ruleConnection2092);
                    	    lv_names_13_0=ruleConnectionName();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getConnectionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"names",
                    	            		lv_names_13_0, 
                    	            		"ConnectionName");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1033:4: ( (otherlv_14= '{' ( (lv_elements_15_0= rulePortElement ) )* otherlv_16= '}' ) | otherlv_17= ';' )
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==12) ) {
                        alt17=1;
                    }
                    else if ( (LA17_0==15) ) {
                        alt17=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1033:5: (otherlv_14= '{' ( (lv_elements_15_0= rulePortElement ) )* otherlv_16= '}' )
                            {
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1033:5: (otherlv_14= '{' ( (lv_elements_15_0= rulePortElement ) )* otherlv_16= '}' )
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1033:7: otherlv_14= '{' ( (lv_elements_15_0= rulePortElement ) )* otherlv_16= '}'
                            {
                            otherlv_14=(Token)match(input,12,FOLLOW_12_in_ruleConnection2108); 

                                	newLeafNode(otherlv_14, grammarAccess.getConnectionAccess().getLeftCurlyBracketKeyword_1_4_0_0());
                                
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1037:1: ( (lv_elements_15_0= rulePortElement ) )*
                            loop16:
                            do {
                                int alt16=2;
                                int LA16_0 = input.LA(1);

                                if ( (LA16_0==20) ) {
                                    alt16=1;
                                }


                                switch (alt16) {
                            	case 1 :
                            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1038:1: (lv_elements_15_0= rulePortElement )
                            	    {
                            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1038:1: (lv_elements_15_0= rulePortElement )
                            	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1039:3: lv_elements_15_0= rulePortElement
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getConnectionAccess().getElementsPortElementParserRuleCall_1_4_0_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_rulePortElement_in_ruleConnection2129);
                            	    lv_elements_15_0=rulePortElement();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getConnectionRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"elements",
                            	            		lv_elements_15_0, 
                            	            		"PortElement");
                            	    	        afterParserOrEnumRuleCall();
                            	    	    

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop16;
                                }
                            } while (true);

                            otherlv_16=(Token)match(input,13,FOLLOW_13_in_ruleConnection2142); 

                                	newLeafNode(otherlv_16, grammarAccess.getConnectionAccess().getRightCurlyBracketKeyword_1_4_0_2());
                                

                            }


                            }
                            break;
                        case 2 :
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1060:7: otherlv_17= ';'
                            {
                            otherlv_17=(Token)match(input,15,FOLLOW_15_in_ruleConnection2161); 

                                	newLeafNode(otherlv_17, grammarAccess.getConnectionAccess().getSemicolonKeyword_1_4_1());
                                

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConnection"


    // $ANTLR start "entryRuleNetElement"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1072:1: entryRuleNetElement returns [EObject current=null] : iv_ruleNetElement= ruleNetElement EOF ;
    public final EObject entryRuleNetElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNetElement = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1073:2: (iv_ruleNetElement= ruleNetElement EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1074:2: iv_ruleNetElement= ruleNetElement EOF
            {
             newCompositeNode(grammarAccess.getNetElementRule()); 
            pushFollow(FOLLOW_ruleNetElement_in_entryRuleNetElement2199);
            iv_ruleNetElement=ruleNetElement();

            state._fsp--;

             current =iv_ruleNetElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNetElement2209); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNetElement"


    // $ANTLR start "ruleNetElement"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1081:1: ruleNetElement returns [EObject current=null] : (this_Attr_0= ruleAttr | this_Info_1= ruleInfo ) ;
    public final EObject ruleNetElement() throws RecognitionException {
        EObject current = null;

        EObject this_Attr_0 = null;

        EObject this_Info_1 = null;


         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1084:28: ( (this_Attr_0= ruleAttr | this_Info_1= ruleInfo ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1085:1: (this_Attr_0= ruleAttr | this_Info_1= ruleInfo )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1085:1: (this_Attr_0= ruleAttr | this_Info_1= ruleInfo )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==17) ) {
                alt19=1;
            }
            else if ( (LA19_0==20) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1086:5: this_Attr_0= ruleAttr
                    {
                     
                            newCompositeNode(grammarAccess.getNetElementAccess().getAttrParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleAttr_in_ruleNetElement2256);
                    this_Attr_0=ruleAttr();

                    state._fsp--;

                     
                            current = this_Attr_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1096:5: this_Info_1= ruleInfo
                    {
                     
                            newCompositeNode(grammarAccess.getNetElementAccess().getInfoParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleInfo_in_ruleNetElement2283);
                    this_Info_1=ruleInfo();

                    state._fsp--;

                     
                            current = this_Info_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNetElement"


    // $ANTLR start "entryRulePortElement"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1112:1: entryRulePortElement returns [EObject current=null] : iv_rulePortElement= rulePortElement EOF ;
    public final EObject entryRulePortElement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortElement = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1113:2: (iv_rulePortElement= rulePortElement EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1114:2: iv_rulePortElement= rulePortElement EOF
            {
             newCompositeNode(grammarAccess.getPortElementRule()); 
            pushFollow(FOLLOW_rulePortElement_in_entryRulePortElement2318);
            iv_rulePortElement=rulePortElement();

            state._fsp--;

             current =iv_rulePortElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePortElement2328); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePortElement"


    // $ANTLR start "rulePortElement"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1121:1: rulePortElement returns [EObject current=null] : this_Info_0= ruleInfo ;
    public final EObject rulePortElement() throws RecognitionException {
        EObject current = null;

        EObject this_Info_0 = null;


         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1124:28: (this_Info_0= ruleInfo )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1126:5: this_Info_0= ruleInfo
            {
             
                    newCompositeNode(grammarAccess.getPortElementAccess().getInfoParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleInfo_in_rulePortElement2374);
            this_Info_0=ruleInfo();

            state._fsp--;

             
                    current = this_Info_0; 
                    afterParserOrEnumRuleCall();
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePortElement"


    // $ANTLR start "entryRuleInstance"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1142:1: entryRuleInstance returns [EObject current=null] : iv_ruleInstance= ruleInstance EOF ;
    public final EObject entryRuleInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstance = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1143:2: (iv_ruleInstance= ruleInstance EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1144:2: iv_ruleInstance= ruleInstance EOF
            {
             newCompositeNode(grammarAccess.getInstanceRule()); 
            pushFollow(FOLLOW_ruleInstance_in_entryRuleInstance2408);
            iv_ruleInstance=ruleInstance();

            state._fsp--;

             current =iv_ruleInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstance2418); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInstance"


    // $ANTLR start "ruleInstance"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1151:1: ruleInstance returns [EObject current=null] : ( ( ( (lv_inst_0_0= 'inst' ) ) ( (lv_array_1_0= ruleArray ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( ( ruleQualifiedName ) ) otherlv_5= '{' ( (lv_elements_6_0= ruleInstanceElement ) )* otherlv_7= '}' ) | ( ( (lv_subInst_8_0= 'subinst' ) ) ( (lv_array_9_0= ruleArray ) ) ( (lv_name_10_0= RULE_ID ) ) otherlv_11= 'of' ( ( ruleQualifiedName ) ) ( (lv_prefix_13_0= RULE_STRING ) )? otherlv_14= '{' ( (lv_elements_15_0= ruleSubInstanceElement ) )* otherlv_16= '}' ) ) ;
    public final EObject ruleInstance() throws RecognitionException {
        EObject current = null;

        Token lv_inst_0_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_subInst_8_0=null;
        Token lv_name_10_0=null;
        Token otherlv_11=null;
        Token lv_prefix_13_0=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        EObject lv_array_1_0 = null;

        EObject lv_elements_6_0 = null;

        EObject lv_array_9_0 = null;

        EObject lv_elements_15_0 = null;


         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1154:28: ( ( ( ( (lv_inst_0_0= 'inst' ) ) ( (lv_array_1_0= ruleArray ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( ( ruleQualifiedName ) ) otherlv_5= '{' ( (lv_elements_6_0= ruleInstanceElement ) )* otherlv_7= '}' ) | ( ( (lv_subInst_8_0= 'subinst' ) ) ( (lv_array_9_0= ruleArray ) ) ( (lv_name_10_0= RULE_ID ) ) otherlv_11= 'of' ( ( ruleQualifiedName ) ) ( (lv_prefix_13_0= RULE_STRING ) )? otherlv_14= '{' ( (lv_elements_15_0= ruleSubInstanceElement ) )* otherlv_16= '}' ) ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1155:1: ( ( ( (lv_inst_0_0= 'inst' ) ) ( (lv_array_1_0= ruleArray ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( ( ruleQualifiedName ) ) otherlv_5= '{' ( (lv_elements_6_0= ruleInstanceElement ) )* otherlv_7= '}' ) | ( ( (lv_subInst_8_0= 'subinst' ) ) ( (lv_array_9_0= ruleArray ) ) ( (lv_name_10_0= RULE_ID ) ) otherlv_11= 'of' ( ( ruleQualifiedName ) ) ( (lv_prefix_13_0= RULE_STRING ) )? otherlv_14= '{' ( (lv_elements_15_0= ruleSubInstanceElement ) )* otherlv_16= '}' ) )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1155:1: ( ( ( (lv_inst_0_0= 'inst' ) ) ( (lv_array_1_0= ruleArray ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( ( ruleQualifiedName ) ) otherlv_5= '{' ( (lv_elements_6_0= ruleInstanceElement ) )* otherlv_7= '}' ) | ( ( (lv_subInst_8_0= 'subinst' ) ) ( (lv_array_9_0= ruleArray ) ) ( (lv_name_10_0= RULE_ID ) ) otherlv_11= 'of' ( ( ruleQualifiedName ) ) ( (lv_prefix_13_0= RULE_STRING ) )? otherlv_14= '{' ( (lv_elements_15_0= ruleSubInstanceElement ) )* otherlv_16= '}' ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==25) ) {
                alt23=1;
            }
            else if ( (LA23_0==27) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1155:2: ( ( (lv_inst_0_0= 'inst' ) ) ( (lv_array_1_0= ruleArray ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( ( ruleQualifiedName ) ) otherlv_5= '{' ( (lv_elements_6_0= ruleInstanceElement ) )* otherlv_7= '}' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1155:2: ( ( (lv_inst_0_0= 'inst' ) ) ( (lv_array_1_0= ruleArray ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( ( ruleQualifiedName ) ) otherlv_5= '{' ( (lv_elements_6_0= ruleInstanceElement ) )* otherlv_7= '}' )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1155:3: ( (lv_inst_0_0= 'inst' ) ) ( (lv_array_1_0= ruleArray ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( ( ruleQualifiedName ) ) otherlv_5= '{' ( (lv_elements_6_0= ruleInstanceElement ) )* otherlv_7= '}'
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1155:3: ( (lv_inst_0_0= 'inst' ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1156:1: (lv_inst_0_0= 'inst' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1156:1: (lv_inst_0_0= 'inst' )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1157:3: lv_inst_0_0= 'inst'
                    {
                    lv_inst_0_0=(Token)match(input,25,FOLLOW_25_in_ruleInstance2462); 

                            newLeafNode(lv_inst_0_0, grammarAccess.getInstanceAccess().getInstInstKeyword_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getInstanceRule());
                    	        }
                           		setWithLastConsumed(current, "inst", true, "inst");
                    	    

                    }


                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1170:2: ( (lv_array_1_0= ruleArray ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1171:1: (lv_array_1_0= ruleArray )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1171:1: (lv_array_1_0= ruleArray )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1172:3: lv_array_1_0= ruleArray
                    {
                     
                    	        newCompositeNode(grammarAccess.getInstanceAccess().getArrayArrayParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleArray_in_ruleInstance2496);
                    lv_array_1_0=ruleArray();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInstanceRule());
                    	        }
                           		set(
                           			current, 
                           			"array",
                            		lv_array_1_0, 
                            		"Array");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1188:2: ( (lv_name_2_0= RULE_ID ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1189:1: (lv_name_2_0= RULE_ID )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1189:1: (lv_name_2_0= RULE_ID )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1190:3: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInstance2513); 

                    			newLeafNode(lv_name_2_0, grammarAccess.getInstanceAccess().getNameIDTerminalRuleCall_0_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getInstanceRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_2_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleInstance2530); 

                        	newLeafNode(otherlv_3, grammarAccess.getInstanceAccess().getOfKeyword_0_3());
                        
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1210:1: ( ( ruleQualifiedName ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1211:1: ( ruleQualifiedName )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1211:1: ( ruleQualifiedName )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1212:3: ruleQualifiedName
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getInstanceAccess().getDeviceDeviceCrossReference_0_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleInstance2553);
                    ruleQualifiedName();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,12,FOLLOW_12_in_ruleInstance2565); 

                        	newLeafNode(otherlv_5, grammarAccess.getInstanceAccess().getLeftCurlyBracketKeyword_0_5());
                        
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1229:1: ( (lv_elements_6_0= ruleInstanceElement ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==RULE_ID||(LA20_0>=RULE_INT && LA20_0<=RULE_PINNUM)||LA20_0==20||(LA20_0>=28 && LA20_0<=29)||LA20_0==40) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1230:1: (lv_elements_6_0= ruleInstanceElement )
                    	    {
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1230:1: (lv_elements_6_0= ruleInstanceElement )
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1231:3: lv_elements_6_0= ruleInstanceElement
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getInstanceAccess().getElementsInstanceElementParserRuleCall_0_6_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleInstanceElement_in_ruleInstance2586);
                    	    lv_elements_6_0=ruleInstanceElement();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"elements",
                    	            		lv_elements_6_0, 
                    	            		"InstanceElement");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,13,FOLLOW_13_in_ruleInstance2599); 

                        	newLeafNode(otherlv_7, grammarAccess.getInstanceAccess().getRightCurlyBracketKeyword_0_7());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1252:6: ( ( (lv_subInst_8_0= 'subinst' ) ) ( (lv_array_9_0= ruleArray ) ) ( (lv_name_10_0= RULE_ID ) ) otherlv_11= 'of' ( ( ruleQualifiedName ) ) ( (lv_prefix_13_0= RULE_STRING ) )? otherlv_14= '{' ( (lv_elements_15_0= ruleSubInstanceElement ) )* otherlv_16= '}' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1252:6: ( ( (lv_subInst_8_0= 'subinst' ) ) ( (lv_array_9_0= ruleArray ) ) ( (lv_name_10_0= RULE_ID ) ) otherlv_11= 'of' ( ( ruleQualifiedName ) ) ( (lv_prefix_13_0= RULE_STRING ) )? otherlv_14= '{' ( (lv_elements_15_0= ruleSubInstanceElement ) )* otherlv_16= '}' )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1252:7: ( (lv_subInst_8_0= 'subinst' ) ) ( (lv_array_9_0= ruleArray ) ) ( (lv_name_10_0= RULE_ID ) ) otherlv_11= 'of' ( ( ruleQualifiedName ) ) ( (lv_prefix_13_0= RULE_STRING ) )? otherlv_14= '{' ( (lv_elements_15_0= ruleSubInstanceElement ) )* otherlv_16= '}'
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1252:7: ( (lv_subInst_8_0= 'subinst' ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1253:1: (lv_subInst_8_0= 'subinst' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1253:1: (lv_subInst_8_0= 'subinst' )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1254:3: lv_subInst_8_0= 'subinst'
                    {
                    lv_subInst_8_0=(Token)match(input,27,FOLLOW_27_in_ruleInstance2625); 

                            newLeafNode(lv_subInst_8_0, grammarAccess.getInstanceAccess().getSubInstSubinstKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getInstanceRule());
                    	        }
                           		setWithLastConsumed(current, "subInst", true, "subinst");
                    	    

                    }


                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1267:2: ( (lv_array_9_0= ruleArray ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1268:1: (lv_array_9_0= ruleArray )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1268:1: (lv_array_9_0= ruleArray )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1269:3: lv_array_9_0= ruleArray
                    {
                     
                    	        newCompositeNode(grammarAccess.getInstanceAccess().getArrayArrayParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleArray_in_ruleInstance2659);
                    lv_array_9_0=ruleArray();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInstanceRule());
                    	        }
                           		set(
                           			current, 
                           			"array",
                            		lv_array_9_0, 
                            		"Array");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1285:2: ( (lv_name_10_0= RULE_ID ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1286:1: (lv_name_10_0= RULE_ID )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1286:1: (lv_name_10_0= RULE_ID )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1287:3: lv_name_10_0= RULE_ID
                    {
                    lv_name_10_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInstance2676); 

                    			newLeafNode(lv_name_10_0, grammarAccess.getInstanceAccess().getNameIDTerminalRuleCall_1_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getInstanceRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_10_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_11=(Token)match(input,26,FOLLOW_26_in_ruleInstance2693); 

                        	newLeafNode(otherlv_11, grammarAccess.getInstanceAccess().getOfKeyword_1_3());
                        
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1307:1: ( ( ruleQualifiedName ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1308:1: ( ruleQualifiedName )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1308:1: ( ruleQualifiedName )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1309:3: ruleQualifiedName
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getInstanceAccess().getSubDesignDesignCrossReference_1_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleInstance2716);
                    ruleQualifiedName();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1322:2: ( (lv_prefix_13_0= RULE_STRING ) )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==RULE_STRING) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1323:1: (lv_prefix_13_0= RULE_STRING )
                            {
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1323:1: (lv_prefix_13_0= RULE_STRING )
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1324:3: lv_prefix_13_0= RULE_STRING
                            {
                            lv_prefix_13_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleInstance2733); 

                            			newLeafNode(lv_prefix_13_0, grammarAccess.getInstanceAccess().getPrefixSTRINGTerminalRuleCall_1_5_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getInstanceRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"prefix",
                                    		lv_prefix_13_0, 
                                    		"STRING");
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_14=(Token)match(input,12,FOLLOW_12_in_ruleInstance2751); 

                        	newLeafNode(otherlv_14, grammarAccess.getInstanceAccess().getLeftCurlyBracketKeyword_1_6());
                        
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1344:1: ( (lv_elements_15_0= ruleSubInstanceElement ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==RULE_ID||(LA22_0>=RULE_INT && LA22_0<=RULE_PINNUM)||LA22_0==17||LA22_0==20||LA22_0==29||LA22_0==40) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1345:1: (lv_elements_15_0= ruleSubInstanceElement )
                    	    {
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1345:1: (lv_elements_15_0= ruleSubInstanceElement )
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1346:3: lv_elements_15_0= ruleSubInstanceElement
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getInstanceAccess().getElementsSubInstanceElementParserRuleCall_1_7_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSubInstanceElement_in_ruleInstance2772);
                    	    lv_elements_15_0=ruleSubInstanceElement();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"elements",
                    	            		lv_elements_15_0, 
                    	            		"SubInstanceElement");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,13,FOLLOW_13_in_ruleInstance2785); 

                        	newLeafNode(otherlv_16, grammarAccess.getInstanceAccess().getRightCurlyBracketKeyword_1_8());
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInstance"


    // $ANTLR start "entryRuleInstanceElement"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1374:1: entryRuleInstanceElement returns [EObject current=null] : iv_ruleInstanceElement= ruleInstanceElement EOF ;
    public final EObject entryRuleInstanceElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceElement = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1375:2: (iv_ruleInstanceElement= ruleInstanceElement EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1376:2: iv_ruleInstanceElement= ruleInstanceElement EOF
            {
             newCompositeNode(grammarAccess.getInstanceElementRule()); 
            pushFollow(FOLLOW_ruleInstanceElement_in_entryRuleInstanceElement2822);
            iv_ruleInstanceElement=ruleInstanceElement();

            state._fsp--;

             current =iv_ruleInstanceElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstanceElement2832); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInstanceElement"


    // $ANTLR start "ruleInstanceElement"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1383:1: ruleInstanceElement returns [EObject current=null] : (this_NewAttr_0= ruleNewAttr | this_RefAttr_1= ruleRefAttr | this_PinAssign_2= rulePinAssign | this_Info_3= ruleInfo ) ;
    public final EObject ruleInstanceElement() throws RecognitionException {
        EObject current = null;

        EObject this_NewAttr_0 = null;

        EObject this_RefAttr_1 = null;

        EObject this_PinAssign_2 = null;

        EObject this_Info_3 = null;


         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1386:28: ( (this_NewAttr_0= ruleNewAttr | this_RefAttr_1= ruleRefAttr | this_PinAssign_2= rulePinAssign | this_Info_3= ruleInfo ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1387:1: (this_NewAttr_0= ruleNewAttr | this_RefAttr_1= ruleRefAttr | this_PinAssign_2= rulePinAssign | this_Info_3= ruleInfo )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1387:1: (this_NewAttr_0= ruleNewAttr | this_RefAttr_1= ruleRefAttr | this_PinAssign_2= rulePinAssign | this_Info_3= ruleInfo )
            int alt24=4;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1388:5: this_NewAttr_0= ruleNewAttr
                    {
                     
                            newCompositeNode(grammarAccess.getInstanceElementAccess().getNewAttrParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleNewAttr_in_ruleInstanceElement2879);
                    this_NewAttr_0=ruleNewAttr();

                    state._fsp--;

                     
                            current = this_NewAttr_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1398:5: this_RefAttr_1= ruleRefAttr
                    {
                     
                            newCompositeNode(grammarAccess.getInstanceElementAccess().getRefAttrParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleRefAttr_in_ruleInstanceElement2906);
                    this_RefAttr_1=ruleRefAttr();

                    state._fsp--;

                     
                            current = this_RefAttr_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1408:5: this_PinAssign_2= rulePinAssign
                    {
                     
                            newCompositeNode(grammarAccess.getInstanceElementAccess().getPinAssignParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_rulePinAssign_in_ruleInstanceElement2933);
                    this_PinAssign_2=rulePinAssign();

                    state._fsp--;

                     
                            current = this_PinAssign_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1418:5: this_Info_3= ruleInfo
                    {
                     
                            newCompositeNode(grammarAccess.getInstanceElementAccess().getInfoParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleInfo_in_ruleInstanceElement2960);
                    this_Info_3=ruleInfo();

                    state._fsp--;

                     
                            current = this_Info_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInstanceElement"


    // $ANTLR start "entryRuleSubInstanceElement"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1434:1: entryRuleSubInstanceElement returns [EObject current=null] : iv_ruleSubInstanceElement= ruleSubInstanceElement EOF ;
    public final EObject entryRuleSubInstanceElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubInstanceElement = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1435:2: (iv_ruleSubInstanceElement= ruleSubInstanceElement EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1436:2: iv_ruleSubInstanceElement= ruleSubInstanceElement EOF
            {
             newCompositeNode(grammarAccess.getSubInstanceElementRule()); 
            pushFollow(FOLLOW_ruleSubInstanceElement_in_entryRuleSubInstanceElement2995);
            iv_ruleSubInstanceElement=ruleSubInstanceElement();

            state._fsp--;

             current =iv_ruleSubInstanceElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubInstanceElement3005); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubInstanceElement"


    // $ANTLR start "ruleSubInstanceElement"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1443:1: ruleSubInstanceElement returns [EObject current=null] : (this_Attr_0= ruleAttr | this_SubAttr_1= ruleSubAttr | this_PortAssign_2= rulePortAssign | this_Info_3= ruleInfo ) ;
    public final EObject ruleSubInstanceElement() throws RecognitionException {
        EObject current = null;

        EObject this_Attr_0 = null;

        EObject this_SubAttr_1 = null;

        EObject this_PortAssign_2 = null;

        EObject this_Info_3 = null;


         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1446:28: ( (this_Attr_0= ruleAttr | this_SubAttr_1= ruleSubAttr | this_PortAssign_2= rulePortAssign | this_Info_3= ruleInfo ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1447:1: (this_Attr_0= ruleAttr | this_SubAttr_1= ruleSubAttr | this_PortAssign_2= rulePortAssign | this_Info_3= ruleInfo )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1447:1: (this_Attr_0= ruleAttr | this_SubAttr_1= ruleSubAttr | this_PortAssign_2= rulePortAssign | this_Info_3= ruleInfo )
            int alt25=4;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1448:5: this_Attr_0= ruleAttr
                    {
                     
                            newCompositeNode(grammarAccess.getSubInstanceElementAccess().getAttrParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleAttr_in_ruleSubInstanceElement3052);
                    this_Attr_0=ruleAttr();

                    state._fsp--;

                     
                            current = this_Attr_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1458:5: this_SubAttr_1= ruleSubAttr
                    {
                     
                            newCompositeNode(grammarAccess.getSubInstanceElementAccess().getSubAttrParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleSubAttr_in_ruleSubInstanceElement3079);
                    this_SubAttr_1=ruleSubAttr();

                    state._fsp--;

                     
                            current = this_SubAttr_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1468:5: this_PortAssign_2= rulePortAssign
                    {
                     
                            newCompositeNode(grammarAccess.getSubInstanceElementAccess().getPortAssignParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_rulePortAssign_in_ruleSubInstanceElement3106);
                    this_PortAssign_2=rulePortAssign();

                    state._fsp--;

                     
                            current = this_PortAssign_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1478:5: this_Info_3= ruleInfo
                    {
                     
                            newCompositeNode(grammarAccess.getSubInstanceElementAccess().getInfoParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleInfo_in_ruleSubInstanceElement3133);
                    this_Info_3=ruleInfo();

                    state._fsp--;

                     
                            current = this_Info_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubInstanceElement"


    // $ANTLR start "entryRuleRefAttr"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1494:1: entryRuleRefAttr returns [EObject current=null] : iv_ruleRefAttr= ruleRefAttr EOF ;
    public final EObject entryRuleRefAttr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefAttr = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1495:2: (iv_ruleRefAttr= ruleRefAttr EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1496:2: iv_ruleRefAttr= ruleRefAttr EOF
            {
             newCompositeNode(grammarAccess.getRefAttrRule()); 
            pushFollow(FOLLOW_ruleRefAttr_in_entryRuleRefAttr3168);
            iv_ruleRefAttr=ruleRefAttr();

            state._fsp--;

             current =iv_ruleRefAttr; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRefAttr3178); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRefAttr"


    // $ANTLR start "ruleRefAttr"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1503:1: ruleRefAttr returns [EObject current=null] : ( ( (lv_qualifier_0_0= ruleQualifier ) )? ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) otherlv_4= ';' ) ;
    public final EObject ruleRefAttr() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;
        Token otherlv_4=null;
        EObject lv_qualifier_0_0 = null;


         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1506:28: ( ( ( (lv_qualifier_0_0= ruleQualifier ) )? ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) otherlv_4= ';' ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1507:1: ( ( (lv_qualifier_0_0= ruleQualifier ) )? ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) otherlv_4= ';' )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1507:1: ( ( (lv_qualifier_0_0= ruleQualifier ) )? ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) otherlv_4= ';' )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1507:2: ( (lv_qualifier_0_0= ruleQualifier ) )? ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) otherlv_4= ';'
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1507:2: ( (lv_qualifier_0_0= ruleQualifier ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==40) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1508:1: (lv_qualifier_0_0= ruleQualifier )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1508:1: (lv_qualifier_0_0= ruleQualifier )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1509:3: lv_qualifier_0_0= ruleQualifier
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefAttrAccess().getQualifierQualifierParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifier_in_ruleRefAttr3224);
                    lv_qualifier_0_0=ruleQualifier();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRefAttrRule());
                    	        }
                           		set(
                           			current, 
                           			"qualifier",
                            		lv_qualifier_0_0, 
                            		"Qualifier");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1525:3: ( (otherlv_1= RULE_ID ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1526:1: (otherlv_1= RULE_ID )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1526:1: (otherlv_1= RULE_ID )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1527:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRefAttrRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRefAttr3245); 

            		newLeafNode(otherlv_1, grammarAccess.getRefAttrAccess().getRefAttrCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleRefAttr3257); 

                	newLeafNode(otherlv_2, grammarAccess.getRefAttrAccess().getEqualsSignKeyword_2());
                
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1542:1: ( (lv_value_3_0= RULE_STRING ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1543:1: (lv_value_3_0= RULE_STRING )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1543:1: (lv_value_3_0= RULE_STRING )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1544:3: lv_value_3_0= RULE_STRING
            {
            lv_value_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleRefAttr3274); 

            			newLeafNode(lv_value_3_0, grammarAccess.getRefAttrAccess().getValueSTRINGTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRefAttrRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_3_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleRefAttr3291); 

                	newLeafNode(otherlv_4, grammarAccess.getRefAttrAccess().getSemicolonKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRefAttr"


    // $ANTLR start "entryRuleNewAttr"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1572:1: entryRuleNewAttr returns [EObject current=null] : iv_ruleNewAttr= ruleNewAttr EOF ;
    public final EObject entryRuleNewAttr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNewAttr = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1573:2: (iv_ruleNewAttr= ruleNewAttr EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1574:2: iv_ruleNewAttr= ruleNewAttr EOF
            {
             newCompositeNode(grammarAccess.getNewAttrRule()); 
            pushFollow(FOLLOW_ruleNewAttr_in_entryRuleNewAttr3327);
            iv_ruleNewAttr=ruleNewAttr();

            state._fsp--;

             current =iv_ruleNewAttr; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNewAttr3337); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNewAttr"


    // $ANTLR start "ruleNewAttr"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1581:1: ruleNewAttr returns [EObject current=null] : (otherlv_0= 'newattr' ( (lv_qualifier_1_0= ruleQualifier ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_value_4_0= RULE_STRING ) ) otherlv_5= ';' ) ;
    public final EObject ruleNewAttr() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token lv_value_4_0=null;
        Token otherlv_5=null;
        EObject lv_qualifier_1_0 = null;


         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1584:28: ( (otherlv_0= 'newattr' ( (lv_qualifier_1_0= ruleQualifier ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_value_4_0= RULE_STRING ) ) otherlv_5= ';' ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1585:1: (otherlv_0= 'newattr' ( (lv_qualifier_1_0= ruleQualifier ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_value_4_0= RULE_STRING ) ) otherlv_5= ';' )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1585:1: (otherlv_0= 'newattr' ( (lv_qualifier_1_0= ruleQualifier ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_value_4_0= RULE_STRING ) ) otherlv_5= ';' )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1585:3: otherlv_0= 'newattr' ( (lv_qualifier_1_0= ruleQualifier ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_value_4_0= RULE_STRING ) ) otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleNewAttr3374); 

                	newLeafNode(otherlv_0, grammarAccess.getNewAttrAccess().getNewattrKeyword_0());
                
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1589:1: ( (lv_qualifier_1_0= ruleQualifier ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==40) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1590:1: (lv_qualifier_1_0= ruleQualifier )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1590:1: (lv_qualifier_1_0= ruleQualifier )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1591:3: lv_qualifier_1_0= ruleQualifier
                    {
                     
                    	        newCompositeNode(grammarAccess.getNewAttrAccess().getQualifierQualifierParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifier_in_ruleNewAttr3395);
                    lv_qualifier_1_0=ruleQualifier();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNewAttrRule());
                    	        }
                           		set(
                           			current, 
                           			"qualifier",
                            		lv_qualifier_1_0, 
                            		"Qualifier");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1607:3: ( (lv_name_2_0= RULE_ID ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1608:1: (lv_name_2_0= RULE_ID )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1608:1: (lv_name_2_0= RULE_ID )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1609:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNewAttr3413); 

            			newLeafNode(lv_name_2_0, grammarAccess.getNewAttrAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNewAttrRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleNewAttr3430); 

                	newLeafNode(otherlv_3, grammarAccess.getNewAttrAccess().getEqualsSignKeyword_3());
                
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1629:1: ( (lv_value_4_0= RULE_STRING ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1630:1: (lv_value_4_0= RULE_STRING )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1630:1: (lv_value_4_0= RULE_STRING )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1631:3: lv_value_4_0= RULE_STRING
            {
            lv_value_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNewAttr3447); 

            			newLeafNode(lv_value_4_0, grammarAccess.getNewAttrAccess().getValueSTRINGTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNewAttrRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_4_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleNewAttr3464); 

                	newLeafNode(otherlv_5, grammarAccess.getNewAttrAccess().getSemicolonKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNewAttr"


    // $ANTLR start "entryRulePinAssign"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1659:1: entryRulePinAssign returns [EObject current=null] : iv_rulePinAssign= rulePinAssign EOF ;
    public final EObject entryRulePinAssign() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePinAssign = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1660:2: (iv_rulePinAssign= rulePinAssign EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1661:2: iv_rulePinAssign= rulePinAssign EOF
            {
             newCompositeNode(grammarAccess.getPinAssignRule()); 
            pushFollow(FOLLOW_rulePinAssign_in_entryRulePinAssign3500);
            iv_rulePinAssign=rulePinAssign();

            state._fsp--;

             current =iv_rulePinAssign; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePinAssign3510); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePinAssign"


    // $ANTLR start "rulePinAssign"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1668:1: rulePinAssign returns [EObject current=null] : ( ( ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' ) | ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? ) ) otherlv_9= '=' ( (lv_concatenation_10_0= ruleConcatenation ) ) otherlv_11= ';' ) ;
    public final EObject rulePinAssign() throws RecognitionException {
        EObject current = null;

        Token lv_combined_0_0=null;
        Token otherlv_1=null;
        Token otherlv_5=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_qualifier_2_0 = null;

        EObject lv_slices_4_0 = null;

        EObject lv_qualifier_6_0 = null;

        EObject lv_slices_8_0 = null;

        EObject lv_concatenation_10_0 = null;


         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1671:28: ( ( ( ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' ) | ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? ) ) otherlv_9= '=' ( (lv_concatenation_10_0= ruleConcatenation ) ) otherlv_11= ';' ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1672:1: ( ( ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' ) | ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? ) ) otherlv_9= '=' ( (lv_concatenation_10_0= ruleConcatenation ) ) otherlv_11= ';' )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1672:1: ( ( ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' ) | ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? ) ) otherlv_9= '=' ( (lv_concatenation_10_0= ruleConcatenation ) ) otherlv_11= ';' )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1672:2: ( ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' ) | ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? ) ) otherlv_9= '=' ( (lv_concatenation_10_0= ruleConcatenation ) ) otherlv_11= ';'
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1672:2: ( ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' ) | ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==29) ) {
                alt32=1;
            }
            else if ( (LA32_0==RULE_ID||(LA32_0>=RULE_INT && LA32_0<=RULE_PINNUM)||LA32_0==40) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1672:3: ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1672:3: ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1672:4: ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')'
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1672:4: ( (lv_combined_0_0= 'combine' ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1673:1: (lv_combined_0_0= 'combine' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1673:1: (lv_combined_0_0= 'combine' )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1674:3: lv_combined_0_0= 'combine'
                    {
                    lv_combined_0_0=(Token)match(input,29,FOLLOW_29_in_rulePinAssign3555); 

                            newLeafNode(lv_combined_0_0, grammarAccess.getPinAssignAccess().getCombinedCombineKeyword_0_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPinAssignRule());
                    	        }
                           		setWithLastConsumed(current, "combined", true, "combine");
                    	    

                    }


                    }

                    otherlv_1=(Token)match(input,30,FOLLOW_30_in_rulePinAssign3580); 

                        	newLeafNode(otherlv_1, grammarAccess.getPinAssignAccess().getLeftParenthesisKeyword_0_0_1());
                        
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1691:1: ( (lv_qualifier_2_0= ruleQualifier ) )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==40) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1692:1: (lv_qualifier_2_0= ruleQualifier )
                            {
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1692:1: (lv_qualifier_2_0= ruleQualifier )
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1693:3: lv_qualifier_2_0= ruleQualifier
                            {
                             
                            	        newCompositeNode(grammarAccess.getPinAssignAccess().getQualifierQualifierParserRuleCall_0_0_2_0()); 
                            	    
                            pushFollow(FOLLOW_ruleQualifier_in_rulePinAssign3601);
                            lv_qualifier_2_0=ruleQualifier();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getPinAssignRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"qualifier",
                                    		lv_qualifier_2_0, 
                                    		"Qualifier");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1709:3: ( ( rulePhdlID ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1710:1: ( rulePhdlID )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1710:1: ( rulePhdlID )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1711:3: rulePhdlID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPinAssignRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getPinAssignAccess().getRefPinCrossReference_0_0_3_0()); 
                    	    
                    pushFollow(FOLLOW_rulePhdlID_in_rulePinAssign3625);
                    rulePhdlID();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1724:2: ( (lv_slices_4_0= ruleSlices ) )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==38) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1725:1: (lv_slices_4_0= ruleSlices )
                            {
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1725:1: (lv_slices_4_0= ruleSlices )
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1726:3: lv_slices_4_0= ruleSlices
                            {
                             
                            	        newCompositeNode(grammarAccess.getPinAssignAccess().getSlicesSlicesParserRuleCall_0_0_4_0()); 
                            	    
                            pushFollow(FOLLOW_ruleSlices_in_rulePinAssign3646);
                            lv_slices_4_0=ruleSlices();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getPinAssignRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"slices",
                                    		lv_slices_4_0, 
                                    		"Slices");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,31,FOLLOW_31_in_rulePinAssign3659); 

                        	newLeafNode(otherlv_5, grammarAccess.getPinAssignAccess().getRightParenthesisKeyword_0_0_5());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1747:6: ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1747:6: ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1747:7: ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )?
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1747:7: ( (lv_qualifier_6_0= ruleQualifier ) )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==40) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1748:1: (lv_qualifier_6_0= ruleQualifier )
                            {
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1748:1: (lv_qualifier_6_0= ruleQualifier )
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1749:3: lv_qualifier_6_0= ruleQualifier
                            {
                             
                            	        newCompositeNode(grammarAccess.getPinAssignAccess().getQualifierQualifierParserRuleCall_0_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleQualifier_in_rulePinAssign3688);
                            lv_qualifier_6_0=ruleQualifier();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getPinAssignRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"qualifier",
                                    		lv_qualifier_6_0, 
                                    		"Qualifier");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1765:3: ( ( rulePhdlID ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1766:1: ( rulePhdlID )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1766:1: ( rulePhdlID )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1767:3: rulePhdlID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPinAssignRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getPinAssignAccess().getRefPinCrossReference_0_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_rulePhdlID_in_rulePinAssign3712);
                    rulePhdlID();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1780:2: ( (lv_slices_8_0= ruleSlices ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==38) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1781:1: (lv_slices_8_0= ruleSlices )
                            {
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1781:1: (lv_slices_8_0= ruleSlices )
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1782:3: lv_slices_8_0= ruleSlices
                            {
                             
                            	        newCompositeNode(grammarAccess.getPinAssignAccess().getSlicesSlicesParserRuleCall_0_1_2_0()); 
                            	    
                            pushFollow(FOLLOW_ruleSlices_in_rulePinAssign3733);
                            lv_slices_8_0=ruleSlices();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getPinAssignRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"slices",
                                    		lv_slices_8_0, 
                                    		"Slices");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,18,FOLLOW_18_in_rulePinAssign3748); 

                	newLeafNode(otherlv_9, grammarAccess.getPinAssignAccess().getEqualsSignKeyword_1());
                
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1802:1: ( (lv_concatenation_10_0= ruleConcatenation ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1803:1: (lv_concatenation_10_0= ruleConcatenation )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1803:1: (lv_concatenation_10_0= ruleConcatenation )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1804:3: lv_concatenation_10_0= ruleConcatenation
            {
             
            	        newCompositeNode(grammarAccess.getPinAssignAccess().getConcatenationConcatenationParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleConcatenation_in_rulePinAssign3769);
            lv_concatenation_10_0=ruleConcatenation();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPinAssignRule());
            	        }
                   		set(
                   			current, 
                   			"concatenation",
                    		lv_concatenation_10_0, 
                    		"Concatenation");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_11=(Token)match(input,15,FOLLOW_15_in_rulePinAssign3781); 

                	newLeafNode(otherlv_11, grammarAccess.getPinAssignAccess().getSemicolonKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePinAssign"


    // $ANTLR start "entryRuleSubAttr"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1832:1: entryRuleSubAttr returns [EObject current=null] : iv_ruleSubAttr= ruleSubAttr EOF ;
    public final EObject entryRuleSubAttr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubAttr = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1833:2: (iv_ruleSubAttr= ruleSubAttr EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1834:2: iv_ruleSubAttr= ruleSubAttr EOF
            {
             newCompositeNode(grammarAccess.getSubAttrRule()); 
            pushFollow(FOLLOW_ruleSubAttr_in_entryRuleSubAttr3817);
            iv_ruleSubAttr=ruleSubAttr();

            state._fsp--;

             current =iv_ruleSubAttr; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubAttr3827); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubAttr"


    // $ANTLR start "ruleSubAttr"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1841:1: ruleSubAttr returns [EObject current=null] : ( ( (lv_qualifier_0_0= ruleQualifier ) )? ( ( (otherlv_1= RULE_ID ) ) ( (lv_refIndices_2_0= ruleIndices ) )? ) ( (lv_tail_3_0= ruleRefTail ) ) otherlv_4= '=' ( (lv_value_5_0= RULE_STRING ) ) otherlv_6= ';' ) ;
    public final EObject ruleSubAttr() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token lv_value_5_0=null;
        Token otherlv_6=null;
        EObject lv_qualifier_0_0 = null;

        EObject lv_refIndices_2_0 = null;

        EObject lv_tail_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1844:28: ( ( ( (lv_qualifier_0_0= ruleQualifier ) )? ( ( (otherlv_1= RULE_ID ) ) ( (lv_refIndices_2_0= ruleIndices ) )? ) ( (lv_tail_3_0= ruleRefTail ) ) otherlv_4= '=' ( (lv_value_5_0= RULE_STRING ) ) otherlv_6= ';' ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1845:1: ( ( (lv_qualifier_0_0= ruleQualifier ) )? ( ( (otherlv_1= RULE_ID ) ) ( (lv_refIndices_2_0= ruleIndices ) )? ) ( (lv_tail_3_0= ruleRefTail ) ) otherlv_4= '=' ( (lv_value_5_0= RULE_STRING ) ) otherlv_6= ';' )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1845:1: ( ( (lv_qualifier_0_0= ruleQualifier ) )? ( ( (otherlv_1= RULE_ID ) ) ( (lv_refIndices_2_0= ruleIndices ) )? ) ( (lv_tail_3_0= ruleRefTail ) ) otherlv_4= '=' ( (lv_value_5_0= RULE_STRING ) ) otherlv_6= ';' )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1845:2: ( (lv_qualifier_0_0= ruleQualifier ) )? ( ( (otherlv_1= RULE_ID ) ) ( (lv_refIndices_2_0= ruleIndices ) )? ) ( (lv_tail_3_0= ruleRefTail ) ) otherlv_4= '=' ( (lv_value_5_0= RULE_STRING ) ) otherlv_6= ';'
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1845:2: ( (lv_qualifier_0_0= ruleQualifier ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==40) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1846:1: (lv_qualifier_0_0= ruleQualifier )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1846:1: (lv_qualifier_0_0= ruleQualifier )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1847:3: lv_qualifier_0_0= ruleQualifier
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubAttrAccess().getQualifierQualifierParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifier_in_ruleSubAttr3873);
                    lv_qualifier_0_0=ruleQualifier();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSubAttrRule());
                    	        }
                           		set(
                           			current, 
                           			"qualifier",
                            		lv_qualifier_0_0, 
                            		"Qualifier");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1863:3: ( ( (otherlv_1= RULE_ID ) ) ( (lv_refIndices_2_0= ruleIndices ) )? )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1863:4: ( (otherlv_1= RULE_ID ) ) ( (lv_refIndices_2_0= ruleIndices ) )?
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1863:4: ( (otherlv_1= RULE_ID ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1864:1: (otherlv_1= RULE_ID )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1864:1: (otherlv_1= RULE_ID )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1865:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubAttrRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubAttr3895); 

            		newLeafNode(otherlv_1, grammarAccess.getSubAttrAccess().getRefReferenceableCrossReference_1_0_0()); 
            	

            }


            }

            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1876:2: ( (lv_refIndices_2_0= ruleIndices ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==30) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1877:1: (lv_refIndices_2_0= ruleIndices )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1877:1: (lv_refIndices_2_0= ruleIndices )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1878:3: lv_refIndices_2_0= ruleIndices
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubAttrAccess().getRefIndicesIndicesParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleIndices_in_ruleSubAttr3916);
                    lv_refIndices_2_0=ruleIndices();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSubAttrRule());
                    	        }
                           		set(
                           			current, 
                           			"refIndices",
                            		lv_refIndices_2_0, 
                            		"Indices");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }

            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1894:4: ( (lv_tail_3_0= ruleRefTail ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1895:1: (lv_tail_3_0= ruleRefTail )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1895:1: (lv_tail_3_0= ruleRefTail )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1896:3: lv_tail_3_0= ruleRefTail
            {
             
            	        newCompositeNode(grammarAccess.getSubAttrAccess().getTailRefTailParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleRefTail_in_ruleSubAttr3939);
            lv_tail_3_0=ruleRefTail();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSubAttrRule());
            	        }
                   		set(
                   			current, 
                   			"tail",
                    		lv_tail_3_0, 
                    		"RefTail");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleSubAttr3951); 

                	newLeafNode(otherlv_4, grammarAccess.getSubAttrAccess().getEqualsSignKeyword_3());
                
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1916:1: ( (lv_value_5_0= RULE_STRING ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1917:1: (lv_value_5_0= RULE_STRING )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1917:1: (lv_value_5_0= RULE_STRING )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1918:3: lv_value_5_0= RULE_STRING
            {
            lv_value_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSubAttr3968); 

            			newLeafNode(lv_value_5_0, grammarAccess.getSubAttrAccess().getValueSTRINGTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSubAttrRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_5_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleSubAttr3985); 

                	newLeafNode(otherlv_6, grammarAccess.getSubAttrAccess().getSemicolonKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubAttr"


    // $ANTLR start "entryRuleRefTail"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1946:1: entryRuleRefTail returns [EObject current=null] : iv_ruleRefTail= ruleRefTail EOF ;
    public final EObject entryRuleRefTail() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefTail = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1947:2: (iv_ruleRefTail= ruleRefTail EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1948:2: iv_ruleRefTail= ruleRefTail EOF
            {
             newCompositeNode(grammarAccess.getRefTailRule()); 
            pushFollow(FOLLOW_ruleRefTail_in_entryRuleRefTail4021);
            iv_ruleRefTail=ruleRefTail();

            state._fsp--;

             current =iv_ruleRefTail; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRefTail4031); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRefTail"


    // $ANTLR start "ruleRefTail"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1955:1: ruleRefTail returns [EObject current=null] : (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) ( (lv_refIndices_2_0= ruleIndices ) )? ( (lv_tail_3_0= ruleRefTail ) )? ) ;
    public final EObject ruleRefTail() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_refIndices_2_0 = null;

        EObject lv_tail_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1958:28: ( (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) ( (lv_refIndices_2_0= ruleIndices ) )? ( (lv_tail_3_0= ruleRefTail ) )? ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1959:1: (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) ( (lv_refIndices_2_0= ruleIndices ) )? ( (lv_tail_3_0= ruleRefTail ) )? )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1959:1: (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) ( (lv_refIndices_2_0= ruleIndices ) )? ( (lv_tail_3_0= ruleRefTail ) )? )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1959:3: otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) ( (lv_refIndices_2_0= ruleIndices ) )? ( (lv_tail_3_0= ruleRefTail ) )?
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleRefTail4068); 

                	newLeafNode(otherlv_0, grammarAccess.getRefTailAccess().getFullStopKeyword_0());
                
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1963:1: ( (otherlv_1= RULE_ID ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1964:1: (otherlv_1= RULE_ID )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1964:1: (otherlv_1= RULE_ID )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1965:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRefTailRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRefTail4088); 

            		newLeafNode(otherlv_1, grammarAccess.getRefTailAccess().getRefReferenceableCrossReference_1_0()); 
            	

            }


            }

            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1976:2: ( (lv_refIndices_2_0= ruleIndices ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==30) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1977:1: (lv_refIndices_2_0= ruleIndices )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1977:1: (lv_refIndices_2_0= ruleIndices )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1978:3: lv_refIndices_2_0= ruleIndices
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefTailAccess().getRefIndicesIndicesParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleIndices_in_ruleRefTail4109);
                    lv_refIndices_2_0=ruleIndices();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRefTailRule());
                    	        }
                           		set(
                           			current, 
                           			"refIndices",
                            		lv_refIndices_2_0, 
                            		"Indices");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1994:3: ( (lv_tail_3_0= ruleRefTail ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==32) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1995:1: (lv_tail_3_0= ruleRefTail )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1995:1: (lv_tail_3_0= ruleRefTail )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1996:3: lv_tail_3_0= ruleRefTail
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefTailAccess().getTailRefTailParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleRefTail_in_ruleRefTail4131);
                    lv_tail_3_0=ruleRefTail();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRefTailRule());
                    	        }
                           		set(
                           			current, 
                           			"tail",
                            		lv_tail_3_0, 
                            		"RefTail");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRefTail"


    // $ANTLR start "entryRulePortAssign"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2020:1: entryRulePortAssign returns [EObject current=null] : iv_rulePortAssign= rulePortAssign EOF ;
    public final EObject entryRulePortAssign() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortAssign = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2021:2: (iv_rulePortAssign= rulePortAssign EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2022:2: iv_rulePortAssign= rulePortAssign EOF
            {
             newCompositeNode(grammarAccess.getPortAssignRule()); 
            pushFollow(FOLLOW_rulePortAssign_in_entryRulePortAssign4168);
            iv_rulePortAssign=rulePortAssign();

            state._fsp--;

             current =iv_rulePortAssign; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePortAssign4178); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePortAssign"


    // $ANTLR start "rulePortAssign"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2029:1: rulePortAssign returns [EObject current=null] : ( ( ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' ) | ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? ) ) otherlv_9= '=' ( (lv_concatenation_10_0= ruleConcatenation ) ) otherlv_11= ';' ) ;
    public final EObject rulePortAssign() throws RecognitionException {
        EObject current = null;

        Token lv_combined_0_0=null;
        Token otherlv_1=null;
        Token otherlv_5=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_qualifier_2_0 = null;

        EObject lv_slices_4_0 = null;

        EObject lv_qualifier_6_0 = null;

        EObject lv_slices_8_0 = null;

        EObject lv_concatenation_10_0 = null;


         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2032:28: ( ( ( ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' ) | ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? ) ) otherlv_9= '=' ( (lv_concatenation_10_0= ruleConcatenation ) ) otherlv_11= ';' ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2033:1: ( ( ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' ) | ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? ) ) otherlv_9= '=' ( (lv_concatenation_10_0= ruleConcatenation ) ) otherlv_11= ';' )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2033:1: ( ( ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' ) | ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? ) ) otherlv_9= '=' ( (lv_concatenation_10_0= ruleConcatenation ) ) otherlv_11= ';' )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2033:2: ( ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' ) | ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? ) ) otherlv_9= '=' ( (lv_concatenation_10_0= ruleConcatenation ) ) otherlv_11= ';'
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2033:2: ( ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' ) | ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? ) )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==29) ) {
                alt41=1;
            }
            else if ( (LA41_0==RULE_ID||(LA41_0>=RULE_INT && LA41_0<=RULE_PINNUM)||LA41_0==40) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2033:3: ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2033:3: ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2033:4: ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')'
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2033:4: ( (lv_combined_0_0= 'combine' ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2034:1: (lv_combined_0_0= 'combine' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2034:1: (lv_combined_0_0= 'combine' )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2035:3: lv_combined_0_0= 'combine'
                    {
                    lv_combined_0_0=(Token)match(input,29,FOLLOW_29_in_rulePortAssign4223); 

                            newLeafNode(lv_combined_0_0, grammarAccess.getPortAssignAccess().getCombinedCombineKeyword_0_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPortAssignRule());
                    	        }
                           		setWithLastConsumed(current, "combined", true, "combine");
                    	    

                    }


                    }

                    otherlv_1=(Token)match(input,30,FOLLOW_30_in_rulePortAssign4248); 

                        	newLeafNode(otherlv_1, grammarAccess.getPortAssignAccess().getLeftParenthesisKeyword_0_0_1());
                        
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2052:1: ( (lv_qualifier_2_0= ruleQualifier ) )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==40) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2053:1: (lv_qualifier_2_0= ruleQualifier )
                            {
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2053:1: (lv_qualifier_2_0= ruleQualifier )
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2054:3: lv_qualifier_2_0= ruleQualifier
                            {
                             
                            	        newCompositeNode(grammarAccess.getPortAssignAccess().getQualifierQualifierParserRuleCall_0_0_2_0()); 
                            	    
                            pushFollow(FOLLOW_ruleQualifier_in_rulePortAssign4269);
                            lv_qualifier_2_0=ruleQualifier();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getPortAssignRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"qualifier",
                                    		lv_qualifier_2_0, 
                                    		"Qualifier");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2070:3: ( ( rulePhdlID ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2071:1: ( rulePhdlID )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2071:1: ( rulePhdlID )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2072:3: rulePhdlID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPortAssignRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getPortAssignAccess().getRefConnectionNameCrossReference_0_0_3_0()); 
                    	    
                    pushFollow(FOLLOW_rulePhdlID_in_rulePortAssign4293);
                    rulePhdlID();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2085:2: ( (lv_slices_4_0= ruleSlices ) )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==38) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2086:1: (lv_slices_4_0= ruleSlices )
                            {
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2086:1: (lv_slices_4_0= ruleSlices )
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2087:3: lv_slices_4_0= ruleSlices
                            {
                             
                            	        newCompositeNode(grammarAccess.getPortAssignAccess().getSlicesSlicesParserRuleCall_0_0_4_0()); 
                            	    
                            pushFollow(FOLLOW_ruleSlices_in_rulePortAssign4314);
                            lv_slices_4_0=ruleSlices();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getPortAssignRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"slices",
                                    		lv_slices_4_0, 
                                    		"Slices");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,31,FOLLOW_31_in_rulePortAssign4327); 

                        	newLeafNode(otherlv_5, grammarAccess.getPortAssignAccess().getRightParenthesisKeyword_0_0_5());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2108:6: ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2108:6: ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2108:7: ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )?
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2108:7: ( (lv_qualifier_6_0= ruleQualifier ) )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==40) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2109:1: (lv_qualifier_6_0= ruleQualifier )
                            {
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2109:1: (lv_qualifier_6_0= ruleQualifier )
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2110:3: lv_qualifier_6_0= ruleQualifier
                            {
                             
                            	        newCompositeNode(grammarAccess.getPortAssignAccess().getQualifierQualifierParserRuleCall_0_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleQualifier_in_rulePortAssign4356);
                            lv_qualifier_6_0=ruleQualifier();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getPortAssignRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"qualifier",
                                    		lv_qualifier_6_0, 
                                    		"Qualifier");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2126:3: ( ( rulePhdlID ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2127:1: ( rulePhdlID )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2127:1: ( rulePhdlID )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2128:3: rulePhdlID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPortAssignRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getPortAssignAccess().getRefConnectionNameCrossReference_0_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_rulePhdlID_in_rulePortAssign4380);
                    rulePhdlID();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2141:2: ( (lv_slices_8_0= ruleSlices ) )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==38) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2142:1: (lv_slices_8_0= ruleSlices )
                            {
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2142:1: (lv_slices_8_0= ruleSlices )
                            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2143:3: lv_slices_8_0= ruleSlices
                            {
                             
                            	        newCompositeNode(grammarAccess.getPortAssignAccess().getSlicesSlicesParserRuleCall_0_1_2_0()); 
                            	    
                            pushFollow(FOLLOW_ruleSlices_in_rulePortAssign4401);
                            lv_slices_8_0=ruleSlices();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getPortAssignRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"slices",
                                    		lv_slices_8_0, 
                                    		"Slices");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,18,FOLLOW_18_in_rulePortAssign4416); 

                	newLeafNode(otherlv_9, grammarAccess.getPortAssignAccess().getEqualsSignKeyword_1());
                
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2163:1: ( (lv_concatenation_10_0= ruleConcatenation ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2164:1: (lv_concatenation_10_0= ruleConcatenation )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2164:1: (lv_concatenation_10_0= ruleConcatenation )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2165:3: lv_concatenation_10_0= ruleConcatenation
            {
             
            	        newCompositeNode(grammarAccess.getPortAssignAccess().getConcatenationConcatenationParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleConcatenation_in_rulePortAssign4437);
            lv_concatenation_10_0=ruleConcatenation();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPortAssignRule());
            	        }
                   		set(
                   			current, 
                   			"concatenation",
                    		lv_concatenation_10_0, 
                    		"Concatenation");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_11=(Token)match(input,15,FOLLOW_15_in_rulePortAssign4449); 

                	newLeafNode(otherlv_11, grammarAccess.getPortAssignAccess().getSemicolonKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePortAssign"


    // $ANTLR start "entryRuleConnectionAssign"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2193:1: entryRuleConnectionAssign returns [EObject current=null] : iv_ruleConnectionAssign= ruleConnectionAssign EOF ;
    public final EObject entryRuleConnectionAssign() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnectionAssign = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2194:2: (iv_ruleConnectionAssign= ruleConnectionAssign EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2195:2: iv_ruleConnectionAssign= ruleConnectionAssign EOF
            {
             newCompositeNode(grammarAccess.getConnectionAssignRule()); 
            pushFollow(FOLLOW_ruleConnectionAssign_in_entryRuleConnectionAssign4485);
            iv_ruleConnectionAssign=ruleConnectionAssign();

            state._fsp--;

             current =iv_ruleConnectionAssign; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionAssign4495); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConnectionAssign"


    // $ANTLR start "ruleConnectionAssign"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2202:1: ruleConnectionAssign returns [EObject current=null] : ( ( ( rulePhdlID ) ) ( (lv_slices_1_0= ruleSlices ) )? otherlv_2= '=' ( (lv_concatenation_3_0= ruleConcatenation ) ) otherlv_4= ';' ) ;
    public final EObject ruleConnectionAssign() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_slices_1_0 = null;

        EObject lv_concatenation_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2205:28: ( ( ( ( rulePhdlID ) ) ( (lv_slices_1_0= ruleSlices ) )? otherlv_2= '=' ( (lv_concatenation_3_0= ruleConcatenation ) ) otherlv_4= ';' ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2206:1: ( ( ( rulePhdlID ) ) ( (lv_slices_1_0= ruleSlices ) )? otherlv_2= '=' ( (lv_concatenation_3_0= ruleConcatenation ) ) otherlv_4= ';' )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2206:1: ( ( ( rulePhdlID ) ) ( (lv_slices_1_0= ruleSlices ) )? otherlv_2= '=' ( (lv_concatenation_3_0= ruleConcatenation ) ) otherlv_4= ';' )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2206:2: ( ( rulePhdlID ) ) ( (lv_slices_1_0= ruleSlices ) )? otherlv_2= '=' ( (lv_concatenation_3_0= ruleConcatenation ) ) otherlv_4= ';'
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2206:2: ( ( rulePhdlID ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2207:1: ( rulePhdlID )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2207:1: ( rulePhdlID )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2208:3: rulePhdlID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionAssignRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionAssignAccess().getRefConnectionNameCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_rulePhdlID_in_ruleConnectionAssign4543);
            rulePhdlID();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2221:2: ( (lv_slices_1_0= ruleSlices ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==38) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2222:1: (lv_slices_1_0= ruleSlices )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2222:1: (lv_slices_1_0= ruleSlices )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2223:3: lv_slices_1_0= ruleSlices
                    {
                     
                    	        newCompositeNode(grammarAccess.getConnectionAssignAccess().getSlicesSlicesParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSlices_in_ruleConnectionAssign4564);
                    lv_slices_1_0=ruleSlices();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConnectionAssignRule());
                    	        }
                           		set(
                           			current, 
                           			"slices",
                            		lv_slices_1_0, 
                            		"Slices");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleConnectionAssign4577); 

                	newLeafNode(otherlv_2, grammarAccess.getConnectionAssignAccess().getEqualsSignKeyword_2());
                
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2243:1: ( (lv_concatenation_3_0= ruleConcatenation ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2244:1: (lv_concatenation_3_0= ruleConcatenation )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2244:1: (lv_concatenation_3_0= ruleConcatenation )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2245:3: lv_concatenation_3_0= ruleConcatenation
            {
             
            	        newCompositeNode(grammarAccess.getConnectionAssignAccess().getConcatenationConcatenationParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleConcatenation_in_ruleConnectionAssign4598);
            lv_concatenation_3_0=ruleConcatenation();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConnectionAssignRule());
            	        }
                   		set(
                   			current, 
                   			"concatenation",
                    		lv_concatenation_3_0, 
                    		"Concatenation");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleConnectionAssign4610); 

                	newLeafNode(otherlv_4, grammarAccess.getConnectionAssignAccess().getSemicolonKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConnectionAssign"


    // $ANTLR start "entryRuleConcatenation"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2273:1: entryRuleConcatenation returns [EObject current=null] : iv_ruleConcatenation= ruleConcatenation EOF ;
    public final EObject entryRuleConcatenation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcatenation = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2274:2: (iv_ruleConcatenation= ruleConcatenation EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2275:2: iv_ruleConcatenation= ruleConcatenation EOF
            {
             newCompositeNode(grammarAccess.getConcatenationRule()); 
            pushFollow(FOLLOW_ruleConcatenation_in_entryRuleConcatenation4646);
            iv_ruleConcatenation=ruleConcatenation();

            state._fsp--;

             current =iv_ruleConcatenation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConcatenation4656); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConcatenation"


    // $ANTLR start "ruleConcatenation"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2282:1: ruleConcatenation returns [EObject current=null] : ( ( ( (lv_connections_0_0= ruleConnectionRef ) ) (otherlv_1= '&' ( (lv_connections_2_0= ruleConnectionRef ) ) )* ) | ( ( (lv_replicated_3_0= '<' ) ) ( (lv_replicate_4_0= ruleConnectionRef ) ) otherlv_5= '>' ) | ( (lv_open_6_0= 'open' ) ) ) ;
    public final EObject ruleConcatenation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_replicated_3_0=null;
        Token otherlv_5=null;
        Token lv_open_6_0=null;
        EObject lv_connections_0_0 = null;

        EObject lv_connections_2_0 = null;

        EObject lv_replicate_4_0 = null;


         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2285:28: ( ( ( ( (lv_connections_0_0= ruleConnectionRef ) ) (otherlv_1= '&' ( (lv_connections_2_0= ruleConnectionRef ) ) )* ) | ( ( (lv_replicated_3_0= '<' ) ) ( (lv_replicate_4_0= ruleConnectionRef ) ) otherlv_5= '>' ) | ( (lv_open_6_0= 'open' ) ) ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2286:1: ( ( ( (lv_connections_0_0= ruleConnectionRef ) ) (otherlv_1= '&' ( (lv_connections_2_0= ruleConnectionRef ) ) )* ) | ( ( (lv_replicated_3_0= '<' ) ) ( (lv_replicate_4_0= ruleConnectionRef ) ) otherlv_5= '>' ) | ( (lv_open_6_0= 'open' ) ) )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2286:1: ( ( ( (lv_connections_0_0= ruleConnectionRef ) ) (otherlv_1= '&' ( (lv_connections_2_0= ruleConnectionRef ) ) )* ) | ( ( (lv_replicated_3_0= '<' ) ) ( (lv_replicate_4_0= ruleConnectionRef ) ) otherlv_5= '>' ) | ( (lv_open_6_0= 'open' ) ) )
            int alt44=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_INT:
            case RULE_PINNUM:
                {
                alt44=1;
                }
                break;
            case 34:
                {
                alt44=2;
                }
                break;
            case 36:
                {
                alt44=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2286:2: ( ( (lv_connections_0_0= ruleConnectionRef ) ) (otherlv_1= '&' ( (lv_connections_2_0= ruleConnectionRef ) ) )* )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2286:2: ( ( (lv_connections_0_0= ruleConnectionRef ) ) (otherlv_1= '&' ( (lv_connections_2_0= ruleConnectionRef ) ) )* )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2286:3: ( (lv_connections_0_0= ruleConnectionRef ) ) (otherlv_1= '&' ( (lv_connections_2_0= ruleConnectionRef ) ) )*
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2286:3: ( (lv_connections_0_0= ruleConnectionRef ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2287:1: (lv_connections_0_0= ruleConnectionRef )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2287:1: (lv_connections_0_0= ruleConnectionRef )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2288:3: lv_connections_0_0= ruleConnectionRef
                    {
                     
                    	        newCompositeNode(grammarAccess.getConcatenationAccess().getConnectionsConnectionRefParserRuleCall_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleConnectionRef_in_ruleConcatenation4703);
                    lv_connections_0_0=ruleConnectionRef();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConcatenationRule());
                    	        }
                           		add(
                           			current, 
                           			"connections",
                            		lv_connections_0_0, 
                            		"ConnectionRef");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2304:2: (otherlv_1= '&' ( (lv_connections_2_0= ruleConnectionRef ) ) )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==33) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2304:4: otherlv_1= '&' ( (lv_connections_2_0= ruleConnectionRef ) )
                    	    {
                    	    otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleConcatenation4716); 

                    	        	newLeafNode(otherlv_1, grammarAccess.getConcatenationAccess().getAmpersandKeyword_0_1_0());
                    	        
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2308:1: ( (lv_connections_2_0= ruleConnectionRef ) )
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2309:1: (lv_connections_2_0= ruleConnectionRef )
                    	    {
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2309:1: (lv_connections_2_0= ruleConnectionRef )
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2310:3: lv_connections_2_0= ruleConnectionRef
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getConcatenationAccess().getConnectionsConnectionRefParserRuleCall_0_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleConnectionRef_in_ruleConcatenation4737);
                    	    lv_connections_2_0=ruleConnectionRef();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getConcatenationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"connections",
                    	            		lv_connections_2_0, 
                    	            		"ConnectionRef");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop43;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2327:6: ( ( (lv_replicated_3_0= '<' ) ) ( (lv_replicate_4_0= ruleConnectionRef ) ) otherlv_5= '>' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2327:6: ( ( (lv_replicated_3_0= '<' ) ) ( (lv_replicate_4_0= ruleConnectionRef ) ) otherlv_5= '>' )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2327:7: ( (lv_replicated_3_0= '<' ) ) ( (lv_replicate_4_0= ruleConnectionRef ) ) otherlv_5= '>'
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2327:7: ( (lv_replicated_3_0= '<' ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2328:1: (lv_replicated_3_0= '<' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2328:1: (lv_replicated_3_0= '<' )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2329:3: lv_replicated_3_0= '<'
                    {
                    lv_replicated_3_0=(Token)match(input,34,FOLLOW_34_in_ruleConcatenation4765); 

                            newLeafNode(lv_replicated_3_0, grammarAccess.getConcatenationAccess().getReplicatedLessThanSignKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConcatenationRule());
                    	        }
                           		setWithLastConsumed(current, "replicated", true, "<");
                    	    

                    }


                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2342:2: ( (lv_replicate_4_0= ruleConnectionRef ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2343:1: (lv_replicate_4_0= ruleConnectionRef )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2343:1: (lv_replicate_4_0= ruleConnectionRef )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2344:3: lv_replicate_4_0= ruleConnectionRef
                    {
                     
                    	        newCompositeNode(grammarAccess.getConcatenationAccess().getReplicateConnectionRefParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleConnectionRef_in_ruleConcatenation4799);
                    lv_replicate_4_0=ruleConnectionRef();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConcatenationRule());
                    	        }
                           		set(
                           			current, 
                           			"replicate",
                            		lv_replicate_4_0, 
                            		"ConnectionRef");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,35,FOLLOW_35_in_ruleConcatenation4811); 

                        	newLeafNode(otherlv_5, grammarAccess.getConcatenationAccess().getGreaterThanSignKeyword_1_2());
                        

                    }


                    }
                    break;
                case 3 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2365:6: ( (lv_open_6_0= 'open' ) )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2365:6: ( (lv_open_6_0= 'open' ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2366:1: (lv_open_6_0= 'open' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2366:1: (lv_open_6_0= 'open' )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2367:3: lv_open_6_0= 'open'
                    {
                    lv_open_6_0=(Token)match(input,36,FOLLOW_36_in_ruleConcatenation4836); 

                            newLeafNode(lv_open_6_0, grammarAccess.getConcatenationAccess().getOpenOpenKeyword_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConcatenationRule());
                    	        }
                           		setWithLastConsumed(current, "open", true, "open");
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConcatenation"


    // $ANTLR start "entryRuleConnectionRef"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2388:1: entryRuleConnectionRef returns [EObject current=null] : iv_ruleConnectionRef= ruleConnectionRef EOF ;
    public final EObject entryRuleConnectionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnectionRef = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2389:2: (iv_ruleConnectionRef= ruleConnectionRef EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2390:2: iv_ruleConnectionRef= ruleConnectionRef EOF
            {
             newCompositeNode(grammarAccess.getConnectionRefRule()); 
            pushFollow(FOLLOW_ruleConnectionRef_in_entryRuleConnectionRef4885);
            iv_ruleConnectionRef=ruleConnectionRef();

            state._fsp--;

             current =iv_ruleConnectionRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionRef4895); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConnectionRef"


    // $ANTLR start "ruleConnectionRef"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2397:1: ruleConnectionRef returns [EObject current=null] : ( ( ( rulePhdlID ) ) ( (lv_slices_1_0= ruleSlices ) )? ) ;
    public final EObject ruleConnectionRef() throws RecognitionException {
        EObject current = null;

        EObject lv_slices_1_0 = null;


         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2400:28: ( ( ( ( rulePhdlID ) ) ( (lv_slices_1_0= ruleSlices ) )? ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2401:1: ( ( ( rulePhdlID ) ) ( (lv_slices_1_0= ruleSlices ) )? )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2401:1: ( ( ( rulePhdlID ) ) ( (lv_slices_1_0= ruleSlices ) )? )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2401:2: ( ( rulePhdlID ) ) ( (lv_slices_1_0= ruleSlices ) )?
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2401:2: ( ( rulePhdlID ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2402:1: ( rulePhdlID )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2402:1: ( rulePhdlID )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2403:3: rulePhdlID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionRefRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionRefAccess().getRefConnectionNameCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_rulePhdlID_in_ruleConnectionRef4943);
            rulePhdlID();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2416:2: ( (lv_slices_1_0= ruleSlices ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==38) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2417:1: (lv_slices_1_0= ruleSlices )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2417:1: (lv_slices_1_0= ruleSlices )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2418:3: lv_slices_1_0= ruleSlices
                    {
                     
                    	        newCompositeNode(grammarAccess.getConnectionRefAccess().getSlicesSlicesParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSlices_in_ruleConnectionRef4964);
                    lv_slices_1_0=ruleSlices();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConnectionRefRule());
                    	        }
                           		set(
                           			current, 
                           			"slices",
                            		lv_slices_1_0, 
                            		"Slices");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConnectionRef"


    // $ANTLR start "entryRuleConnectionName"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2442:1: entryRuleConnectionName returns [EObject current=null] : iv_ruleConnectionName= ruleConnectionName EOF ;
    public final EObject entryRuleConnectionName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnectionName = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2443:2: (iv_ruleConnectionName= ruleConnectionName EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2444:2: iv_ruleConnectionName= ruleConnectionName EOF
            {
             newCompositeNode(grammarAccess.getConnectionNameRule()); 
            pushFollow(FOLLOW_ruleConnectionName_in_entryRuleConnectionName5001);
            iv_ruleConnectionName=ruleConnectionName();

            state._fsp--;

             current =iv_ruleConnectionName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionName5011); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConnectionName"


    // $ANTLR start "ruleConnectionName"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2451:1: ruleConnectionName returns [EObject current=null] : ( (lv_name_0_0= rulePhdlID ) ) ;
    public final EObject ruleConnectionName() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2454:28: ( ( (lv_name_0_0= rulePhdlID ) ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2455:1: ( (lv_name_0_0= rulePhdlID ) )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2455:1: ( (lv_name_0_0= rulePhdlID ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2456:1: (lv_name_0_0= rulePhdlID )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2456:1: (lv_name_0_0= rulePhdlID )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2457:3: lv_name_0_0= rulePhdlID
            {
             
            	        newCompositeNode(grammarAccess.getConnectionNameAccess().getNamePhdlIDParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_rulePhdlID_in_ruleConnectionName5056);
            lv_name_0_0=rulePhdlID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConnectionNameRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"PhdlID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConnectionName"


    // $ANTLR start "entryRuleIndices"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2481:1: entryRuleIndices returns [EObject current=null] : iv_ruleIndices= ruleIndices EOF ;
    public final EObject entryRuleIndices() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndices = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2482:2: (iv_ruleIndices= ruleIndices EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2483:2: iv_ruleIndices= ruleIndices EOF
            {
             newCompositeNode(grammarAccess.getIndicesRule()); 
            pushFollow(FOLLOW_ruleIndices_in_entryRuleIndices5091);
            iv_ruleIndices=ruleIndices();

            state._fsp--;

             current =iv_ruleIndices; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIndices5101); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIndices"


    // $ANTLR start "ruleIndices"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2490:1: ruleIndices returns [EObject current=null] : (otherlv_0= '(' ( ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_array_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) ) | ( ( (lv_indices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_indices_6_0= RULE_INT ) ) )* ) ) otherlv_7= ')' ) ;
    public final EObject ruleIndices() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_msb_1_0=null;
        Token lv_array_2_0=null;
        Token lv_lsb_3_0=null;
        Token lv_indices_4_0=null;
        Token otherlv_5=null;
        Token lv_indices_6_0=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2493:28: ( (otherlv_0= '(' ( ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_array_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) ) | ( ( (lv_indices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_indices_6_0= RULE_INT ) ) )* ) ) otherlv_7= ')' ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2494:1: (otherlv_0= '(' ( ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_array_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) ) | ( ( (lv_indices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_indices_6_0= RULE_INT ) ) )* ) ) otherlv_7= ')' )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2494:1: (otherlv_0= '(' ( ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_array_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) ) | ( ( (lv_indices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_indices_6_0= RULE_INT ) ) )* ) ) otherlv_7= ')' )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2494:3: otherlv_0= '(' ( ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_array_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) ) | ( ( (lv_indices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_indices_6_0= RULE_INT ) ) )* ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleIndices5138); 

                	newLeafNode(otherlv_0, grammarAccess.getIndicesAccess().getLeftParenthesisKeyword_0());
                
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2498:1: ( ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_array_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) ) | ( ( (lv_indices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_indices_6_0= RULE_INT ) ) )* ) )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==RULE_INT) ) {
                int LA47_1 = input.LA(2);

                if ( (LA47_1==19||LA47_1==31) ) {
                    alt47=2;
                }
                else if ( (LA47_1==37) ) {
                    alt47=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2498:2: ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_array_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2498:2: ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_array_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2498:3: ( (lv_msb_1_0= RULE_INT ) ) ( (lv_array_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2498:3: ( (lv_msb_1_0= RULE_INT ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2499:1: (lv_msb_1_0= RULE_INT )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2499:1: (lv_msb_1_0= RULE_INT )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2500:3: lv_msb_1_0= RULE_INT
                    {
                    lv_msb_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIndices5157); 

                    			newLeafNode(lv_msb_1_0, grammarAccess.getIndicesAccess().getMsbINTTerminalRuleCall_1_0_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIndicesRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"msb",
                            		lv_msb_1_0, 
                            		"INT");
                    	    

                    }


                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2516:2: ( (lv_array_2_0= ':' ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2517:1: (lv_array_2_0= ':' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2517:1: (lv_array_2_0= ':' )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2518:3: lv_array_2_0= ':'
                    {
                    lv_array_2_0=(Token)match(input,37,FOLLOW_37_in_ruleIndices5180); 

                            newLeafNode(lv_array_2_0, grammarAccess.getIndicesAccess().getArrayColonKeyword_1_0_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIndicesRule());
                    	        }
                           		setWithLastConsumed(current, "array", true, ":");
                    	    

                    }


                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2531:2: ( (lv_lsb_3_0= RULE_INT ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2532:1: (lv_lsb_3_0= RULE_INT )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2532:1: (lv_lsb_3_0= RULE_INT )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2533:3: lv_lsb_3_0= RULE_INT
                    {
                    lv_lsb_3_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIndices5210); 

                    			newLeafNode(lv_lsb_3_0, grammarAccess.getIndicesAccess().getLsbINTTerminalRuleCall_1_0_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIndicesRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"lsb",
                            		lv_lsb_3_0, 
                            		"INT");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2550:6: ( ( (lv_indices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_indices_6_0= RULE_INT ) ) )* )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2550:6: ( ( (lv_indices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_indices_6_0= RULE_INT ) ) )* )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2550:7: ( (lv_indices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_indices_6_0= RULE_INT ) ) )*
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2550:7: ( (lv_indices_4_0= RULE_INT ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2551:1: (lv_indices_4_0= RULE_INT )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2551:1: (lv_indices_4_0= RULE_INT )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2552:3: lv_indices_4_0= RULE_INT
                    {
                    lv_indices_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIndices5240); 

                    			newLeafNode(lv_indices_4_0, grammarAccess.getIndicesAccess().getIndicesINTTerminalRuleCall_1_1_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIndicesRule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"indices",
                            		lv_indices_4_0, 
                            		"INT");
                    	    

                    }


                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2568:2: (otherlv_5= ',' ( (lv_indices_6_0= RULE_INT ) ) )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==19) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2568:4: otherlv_5= ',' ( (lv_indices_6_0= RULE_INT ) )
                    	    {
                    	    otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleIndices5258); 

                    	        	newLeafNode(otherlv_5, grammarAccess.getIndicesAccess().getCommaKeyword_1_1_1_0());
                    	        
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2572:1: ( (lv_indices_6_0= RULE_INT ) )
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2573:1: (lv_indices_6_0= RULE_INT )
                    	    {
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2573:1: (lv_indices_6_0= RULE_INT )
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2574:3: lv_indices_6_0= RULE_INT
                    	    {
                    	    lv_indices_6_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIndices5275); 

                    	    			newLeafNode(lv_indices_6_0, grammarAccess.getIndicesAccess().getIndicesINTTerminalRuleCall_1_1_1_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getIndicesRule());
                    	    	        }
                    	           		addWithLastConsumed(
                    	           			current, 
                    	           			"indices",
                    	            		lv_indices_6_0, 
                    	            		"INT");
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop46;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,31,FOLLOW_31_in_ruleIndices5296); 

                	newLeafNode(otherlv_7, grammarAccess.getIndicesAccess().getRightParenthesisKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIndices"


    // $ANTLR start "entryRuleSlices"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2602:1: entryRuleSlices returns [EObject current=null] : iv_ruleSlices= ruleSlices EOF ;
    public final EObject entryRuleSlices() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSlices = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2603:2: (iv_ruleSlices= ruleSlices EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2604:2: iv_ruleSlices= ruleSlices EOF
            {
             newCompositeNode(grammarAccess.getSlicesRule()); 
            pushFollow(FOLLOW_ruleSlices_in_entryRuleSlices5332);
            iv_ruleSlices=ruleSlices();

            state._fsp--;

             current =iv_ruleSlices; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSlices5342); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSlices"


    // $ANTLR start "ruleSlices"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2611:1: ruleSlices returns [EObject current=null] : (otherlv_0= '[' ( ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_vector_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) ) | ( ( (lv_slices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_slices_6_0= RULE_INT ) ) )* ) ) otherlv_7= ']' ) ;
    public final EObject ruleSlices() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_msb_1_0=null;
        Token lv_vector_2_0=null;
        Token lv_lsb_3_0=null;
        Token lv_slices_4_0=null;
        Token otherlv_5=null;
        Token lv_slices_6_0=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2614:28: ( (otherlv_0= '[' ( ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_vector_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) ) | ( ( (lv_slices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_slices_6_0= RULE_INT ) ) )* ) ) otherlv_7= ']' ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2615:1: (otherlv_0= '[' ( ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_vector_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) ) | ( ( (lv_slices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_slices_6_0= RULE_INT ) ) )* ) ) otherlv_7= ']' )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2615:1: (otherlv_0= '[' ( ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_vector_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) ) | ( ( (lv_slices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_slices_6_0= RULE_INT ) ) )* ) ) otherlv_7= ']' )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2615:3: otherlv_0= '[' ( ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_vector_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) ) | ( ( (lv_slices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_slices_6_0= RULE_INT ) ) )* ) ) otherlv_7= ']'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_38_in_ruleSlices5379); 

                	newLeafNode(otherlv_0, grammarAccess.getSlicesAccess().getLeftSquareBracketKeyword_0());
                
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2619:1: ( ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_vector_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) ) | ( ( (lv_slices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_slices_6_0= RULE_INT ) ) )* ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_INT) ) {
                int LA49_1 = input.LA(2);

                if ( (LA49_1==37) ) {
                    alt49=1;
                }
                else if ( (LA49_1==19||LA49_1==39) ) {
                    alt49=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2619:2: ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_vector_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2619:2: ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_vector_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2619:3: ( (lv_msb_1_0= RULE_INT ) ) ( (lv_vector_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2619:3: ( (lv_msb_1_0= RULE_INT ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2620:1: (lv_msb_1_0= RULE_INT )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2620:1: (lv_msb_1_0= RULE_INT )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2621:3: lv_msb_1_0= RULE_INT
                    {
                    lv_msb_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSlices5398); 

                    			newLeafNode(lv_msb_1_0, grammarAccess.getSlicesAccess().getMsbINTTerminalRuleCall_1_0_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSlicesRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"msb",
                            		lv_msb_1_0, 
                            		"INT");
                    	    

                    }


                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2637:2: ( (lv_vector_2_0= ':' ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2638:1: (lv_vector_2_0= ':' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2638:1: (lv_vector_2_0= ':' )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2639:3: lv_vector_2_0= ':'
                    {
                    lv_vector_2_0=(Token)match(input,37,FOLLOW_37_in_ruleSlices5421); 

                            newLeafNode(lv_vector_2_0, grammarAccess.getSlicesAccess().getVectorColonKeyword_1_0_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSlicesRule());
                    	        }
                           		setWithLastConsumed(current, "vector", true, ":");
                    	    

                    }


                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2652:2: ( (lv_lsb_3_0= RULE_INT ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2653:1: (lv_lsb_3_0= RULE_INT )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2653:1: (lv_lsb_3_0= RULE_INT )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2654:3: lv_lsb_3_0= RULE_INT
                    {
                    lv_lsb_3_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSlices5451); 

                    			newLeafNode(lv_lsb_3_0, grammarAccess.getSlicesAccess().getLsbINTTerminalRuleCall_1_0_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSlicesRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"lsb",
                            		lv_lsb_3_0, 
                            		"INT");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2671:6: ( ( (lv_slices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_slices_6_0= RULE_INT ) ) )* )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2671:6: ( ( (lv_slices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_slices_6_0= RULE_INT ) ) )* )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2671:7: ( (lv_slices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_slices_6_0= RULE_INT ) ) )*
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2671:7: ( (lv_slices_4_0= RULE_INT ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2672:1: (lv_slices_4_0= RULE_INT )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2672:1: (lv_slices_4_0= RULE_INT )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2673:3: lv_slices_4_0= RULE_INT
                    {
                    lv_slices_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSlices5481); 

                    			newLeafNode(lv_slices_4_0, grammarAccess.getSlicesAccess().getSlicesINTTerminalRuleCall_1_1_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSlicesRule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"slices",
                            		lv_slices_4_0, 
                            		"INT");
                    	    

                    }


                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2689:2: (otherlv_5= ',' ( (lv_slices_6_0= RULE_INT ) ) )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==19) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2689:4: otherlv_5= ',' ( (lv_slices_6_0= RULE_INT ) )
                    	    {
                    	    otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleSlices5499); 

                    	        	newLeafNode(otherlv_5, grammarAccess.getSlicesAccess().getCommaKeyword_1_1_1_0());
                    	        
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2693:1: ( (lv_slices_6_0= RULE_INT ) )
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2694:1: (lv_slices_6_0= RULE_INT )
                    	    {
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2694:1: (lv_slices_6_0= RULE_INT )
                    	    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2695:3: lv_slices_6_0= RULE_INT
                    	    {
                    	    lv_slices_6_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSlices5516); 

                    	    			newLeafNode(lv_slices_6_0, grammarAccess.getSlicesAccess().getSlicesINTTerminalRuleCall_1_1_1_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSlicesRule());
                    	    	        }
                    	           		addWithLastConsumed(
                    	           			current, 
                    	           			"slices",
                    	            		lv_slices_6_0, 
                    	            		"INT");
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop48;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,39,FOLLOW_39_in_ruleSlices5537); 

                	newLeafNode(otherlv_7, grammarAccess.getSlicesAccess().getRightSquareBracketKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSlices"


    // $ANTLR start "entryRuleVector"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2723:1: entryRuleVector returns [EObject current=null] : iv_ruleVector= ruleVector EOF ;
    public final EObject entryRuleVector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVector = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2724:2: (iv_ruleVector= ruleVector EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2725:2: iv_ruleVector= ruleVector EOF
            {
             newCompositeNode(grammarAccess.getVectorRule()); 
            pushFollow(FOLLOW_ruleVector_in_entryRuleVector5573);
            iv_ruleVector=ruleVector();

            state._fsp--;

             current =iv_ruleVector; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVector5583); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVector"


    // $ANTLR start "ruleVector"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2732:1: ruleVector returns [EObject current=null] : ( () (otherlv_1= '[' ( (lv_msb_2_0= RULE_INT ) ) ( (lv_vector_3_0= ':' ) ) ( (lv_lsb_4_0= RULE_INT ) ) otherlv_5= ']' )? ) ;
    public final EObject ruleVector() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_msb_2_0=null;
        Token lv_vector_3_0=null;
        Token lv_lsb_4_0=null;
        Token otherlv_5=null;

         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2735:28: ( ( () (otherlv_1= '[' ( (lv_msb_2_0= RULE_INT ) ) ( (lv_vector_3_0= ':' ) ) ( (lv_lsb_4_0= RULE_INT ) ) otherlv_5= ']' )? ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2736:1: ( () (otherlv_1= '[' ( (lv_msb_2_0= RULE_INT ) ) ( (lv_vector_3_0= ':' ) ) ( (lv_lsb_4_0= RULE_INT ) ) otherlv_5= ']' )? )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2736:1: ( () (otherlv_1= '[' ( (lv_msb_2_0= RULE_INT ) ) ( (lv_vector_3_0= ':' ) ) ( (lv_lsb_4_0= RULE_INT ) ) otherlv_5= ']' )? )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2736:2: () (otherlv_1= '[' ( (lv_msb_2_0= RULE_INT ) ) ( (lv_vector_3_0= ':' ) ) ( (lv_lsb_4_0= RULE_INT ) ) otherlv_5= ']' )?
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2736:2: ()
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2737:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getVectorAccess().getVectorAction_0(),
                        current);
                

            }

            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2742:2: (otherlv_1= '[' ( (lv_msb_2_0= RULE_INT ) ) ( (lv_vector_3_0= ':' ) ) ( (lv_lsb_4_0= RULE_INT ) ) otherlv_5= ']' )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==38) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2742:4: otherlv_1= '[' ( (lv_msb_2_0= RULE_INT ) ) ( (lv_vector_3_0= ':' ) ) ( (lv_lsb_4_0= RULE_INT ) ) otherlv_5= ']'
                    {
                    otherlv_1=(Token)match(input,38,FOLLOW_38_in_ruleVector5630); 

                        	newLeafNode(otherlv_1, grammarAccess.getVectorAccess().getLeftSquareBracketKeyword_1_0());
                        
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2746:1: ( (lv_msb_2_0= RULE_INT ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2747:1: (lv_msb_2_0= RULE_INT )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2747:1: (lv_msb_2_0= RULE_INT )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2748:3: lv_msb_2_0= RULE_INT
                    {
                    lv_msb_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVector5647); 

                    			newLeafNode(lv_msb_2_0, grammarAccess.getVectorAccess().getMsbINTTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVectorRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"msb",
                            		lv_msb_2_0, 
                            		"INT");
                    	    

                    }


                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2764:2: ( (lv_vector_3_0= ':' ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2765:1: (lv_vector_3_0= ':' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2765:1: (lv_vector_3_0= ':' )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2766:3: lv_vector_3_0= ':'
                    {
                    lv_vector_3_0=(Token)match(input,37,FOLLOW_37_in_ruleVector5670); 

                            newLeafNode(lv_vector_3_0, grammarAccess.getVectorAccess().getVectorColonKeyword_1_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVectorRule());
                    	        }
                           		setWithLastConsumed(current, "vector", true, ":");
                    	    

                    }


                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2779:2: ( (lv_lsb_4_0= RULE_INT ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2780:1: (lv_lsb_4_0= RULE_INT )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2780:1: (lv_lsb_4_0= RULE_INT )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2781:3: lv_lsb_4_0= RULE_INT
                    {
                    lv_lsb_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVector5700); 

                    			newLeafNode(lv_lsb_4_0, grammarAccess.getVectorAccess().getLsbINTTerminalRuleCall_1_3_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVectorRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"lsb",
                            		lv_lsb_4_0, 
                            		"INT");
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,39,FOLLOW_39_in_ruleVector5717); 

                        	newLeafNode(otherlv_5, grammarAccess.getVectorAccess().getRightSquareBracketKeyword_1_4());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVector"


    // $ANTLR start "entryRuleArray"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2809:1: entryRuleArray returns [EObject current=null] : iv_ruleArray= ruleArray EOF ;
    public final EObject entryRuleArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArray = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2810:2: (iv_ruleArray= ruleArray EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2811:2: iv_ruleArray= ruleArray EOF
            {
             newCompositeNode(grammarAccess.getArrayRule()); 
            pushFollow(FOLLOW_ruleArray_in_entryRuleArray5755);
            iv_ruleArray=ruleArray();

            state._fsp--;

             current =iv_ruleArray; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArray5765); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArray"


    // $ANTLR start "ruleArray"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2818:1: ruleArray returns [EObject current=null] : ( () (otherlv_1= '(' ( (lv_msb_2_0= RULE_INT ) ) ( (lv_array_3_0= ':' ) ) ( (lv_lsb_4_0= RULE_INT ) ) otherlv_5= ')' )? ) ;
    public final EObject ruleArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_msb_2_0=null;
        Token lv_array_3_0=null;
        Token lv_lsb_4_0=null;
        Token otherlv_5=null;

         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2821:28: ( ( () (otherlv_1= '(' ( (lv_msb_2_0= RULE_INT ) ) ( (lv_array_3_0= ':' ) ) ( (lv_lsb_4_0= RULE_INT ) ) otherlv_5= ')' )? ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2822:1: ( () (otherlv_1= '(' ( (lv_msb_2_0= RULE_INT ) ) ( (lv_array_3_0= ':' ) ) ( (lv_lsb_4_0= RULE_INT ) ) otherlv_5= ')' )? )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2822:1: ( () (otherlv_1= '(' ( (lv_msb_2_0= RULE_INT ) ) ( (lv_array_3_0= ':' ) ) ( (lv_lsb_4_0= RULE_INT ) ) otherlv_5= ')' )? )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2822:2: () (otherlv_1= '(' ( (lv_msb_2_0= RULE_INT ) ) ( (lv_array_3_0= ':' ) ) ( (lv_lsb_4_0= RULE_INT ) ) otherlv_5= ')' )?
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2822:2: ()
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2823:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getArrayAccess().getArrayAction_0(),
                        current);
                

            }

            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2828:2: (otherlv_1= '(' ( (lv_msb_2_0= RULE_INT ) ) ( (lv_array_3_0= ':' ) ) ( (lv_lsb_4_0= RULE_INT ) ) otherlv_5= ')' )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==30) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2828:4: otherlv_1= '(' ( (lv_msb_2_0= RULE_INT ) ) ( (lv_array_3_0= ':' ) ) ( (lv_lsb_4_0= RULE_INT ) ) otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,30,FOLLOW_30_in_ruleArray5812); 

                        	newLeafNode(otherlv_1, grammarAccess.getArrayAccess().getLeftParenthesisKeyword_1_0());
                        
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2832:1: ( (lv_msb_2_0= RULE_INT ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2833:1: (lv_msb_2_0= RULE_INT )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2833:1: (lv_msb_2_0= RULE_INT )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2834:3: lv_msb_2_0= RULE_INT
                    {
                    lv_msb_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleArray5829); 

                    			newLeafNode(lv_msb_2_0, grammarAccess.getArrayAccess().getMsbINTTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getArrayRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"msb",
                            		lv_msb_2_0, 
                            		"INT");
                    	    

                    }


                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2850:2: ( (lv_array_3_0= ':' ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2851:1: (lv_array_3_0= ':' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2851:1: (lv_array_3_0= ':' )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2852:3: lv_array_3_0= ':'
                    {
                    lv_array_3_0=(Token)match(input,37,FOLLOW_37_in_ruleArray5852); 

                            newLeafNode(lv_array_3_0, grammarAccess.getArrayAccess().getArrayColonKeyword_1_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getArrayRule());
                    	        }
                           		setWithLastConsumed(current, "array", true, ":");
                    	    

                    }


                    }

                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2865:2: ( (lv_lsb_4_0= RULE_INT ) )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2866:1: (lv_lsb_4_0= RULE_INT )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2866:1: (lv_lsb_4_0= RULE_INT )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2867:3: lv_lsb_4_0= RULE_INT
                    {
                    lv_lsb_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleArray5882); 

                    			newLeafNode(lv_lsb_4_0, grammarAccess.getArrayAccess().getLsbINTTerminalRuleCall_1_3_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getArrayRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"lsb",
                            		lv_lsb_4_0, 
                            		"INT");
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,31,FOLLOW_31_in_ruleArray5899); 

                        	newLeafNode(otherlv_5, grammarAccess.getArrayAccess().getRightParenthesisKeyword_1_4());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArray"


    // $ANTLR start "entryRuleQualifier"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2895:1: entryRuleQualifier returns [EObject current=null] : iv_ruleQualifier= ruleQualifier EOF ;
    public final EObject entryRuleQualifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifier = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2896:2: (iv_ruleQualifier= ruleQualifier EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2897:2: iv_ruleQualifier= ruleQualifier EOF
            {
             newCompositeNode(grammarAccess.getQualifierRule()); 
            pushFollow(FOLLOW_ruleQualifier_in_entryRuleQualifier5937);
            iv_ruleQualifier=ruleQualifier();

            state._fsp--;

             current =iv_ruleQualifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifier5947); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifier"


    // $ANTLR start "ruleQualifier"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2904:1: ruleQualifier returns [EObject current=null] : (otherlv_0= 'this' ( (lv_indices_1_0= ruleIndices ) ) otherlv_2= '.' ) ;
    public final EObject ruleQualifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_indices_1_0 = null;


         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2907:28: ( (otherlv_0= 'this' ( (lv_indices_1_0= ruleIndices ) ) otherlv_2= '.' ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2908:1: (otherlv_0= 'this' ( (lv_indices_1_0= ruleIndices ) ) otherlv_2= '.' )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2908:1: (otherlv_0= 'this' ( (lv_indices_1_0= ruleIndices ) ) otherlv_2= '.' )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2908:3: otherlv_0= 'this' ( (lv_indices_1_0= ruleIndices ) ) otherlv_2= '.'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_40_in_ruleQualifier5984); 

                	newLeafNode(otherlv_0, grammarAccess.getQualifierAccess().getThisKeyword_0());
                
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2912:1: ( (lv_indices_1_0= ruleIndices ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2913:1: (lv_indices_1_0= ruleIndices )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2913:1: (lv_indices_1_0= ruleIndices )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2914:3: lv_indices_1_0= ruleIndices
            {
             
            	        newCompositeNode(grammarAccess.getQualifierAccess().getIndicesIndicesParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleIndices_in_ruleQualifier6005);
            lv_indices_1_0=ruleIndices();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getQualifierRule());
            	        }
                   		set(
                   			current, 
                   			"indices",
                    		lv_indices_1_0, 
                    		"Indices");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,32,FOLLOW_32_in_ruleQualifier6017); 

                	newLeafNode(otherlv_2, grammarAccess.getQualifierAccess().getFullStopKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifier"


    // $ANTLR start "entryRuleQualifiedNameWithWildCard"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2946:1: entryRuleQualifiedNameWithWildCard returns [String current=null] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final String entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildCard = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2947:2: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2948:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard6058);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();

            state._fsp--;

             current =iv_ruleQualifiedNameWithWildCard.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard6069); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedNameWithWildCard"


    // $ANTLR start "ruleQualifiedNameWithWildCard"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2955:1: ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildCard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2958:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2959:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2959:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2960:5: this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )?
            {
             
                    newCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard6116);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2970:1: (kw= '.' kw= '*' )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==32) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2971:2: kw= '.' kw= '*'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleQualifiedNameWithWildCard6135); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopKeyword_1_0()); 
                        
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleQualifiedNameWithWildCard6148); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getQualifiedNameWithWildCardAccess().getAsteriskKeyword_1_1()); 
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedNameWithWildCard"


    // $ANTLR start "entryRuleQualifiedName"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2990:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2991:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2992:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName6191);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName6202); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2999:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_PhdlID_0= rulePhdlID (kw= '.' this_PhdlID_2= rulePhdlID )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_PhdlID_0 = null;

        AntlrDatatypeRuleToken this_PhdlID_2 = null;


         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3002:28: ( (this_PhdlID_0= rulePhdlID (kw= '.' this_PhdlID_2= rulePhdlID )? ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3003:1: (this_PhdlID_0= rulePhdlID (kw= '.' this_PhdlID_2= rulePhdlID )? )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3003:1: (this_PhdlID_0= rulePhdlID (kw= '.' this_PhdlID_2= rulePhdlID )? )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3004:5: this_PhdlID_0= rulePhdlID (kw= '.' this_PhdlID_2= rulePhdlID )?
            {
             
                    newCompositeNode(grammarAccess.getQualifiedNameAccess().getPhdlIDParserRuleCall_0()); 
                
            pushFollow(FOLLOW_rulePhdlID_in_ruleQualifiedName6249);
            this_PhdlID_0=rulePhdlID();

            state._fsp--;


            		current.merge(this_PhdlID_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3014:1: (kw= '.' this_PhdlID_2= rulePhdlID )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==32) ) {
                int LA53_1 = input.LA(2);

                if ( (LA53_1==RULE_ID||(LA53_1>=RULE_INT && LA53_1<=RULE_PINNUM)) ) {
                    alt53=1;
                }
            }
            switch (alt53) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3015:2: kw= '.' this_PhdlID_2= rulePhdlID
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleQualifiedName6268); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
                        
                     
                            newCompositeNode(grammarAccess.getQualifiedNameAccess().getPhdlIDParserRuleCall_1_1()); 
                        
                    pushFollow(FOLLOW_rulePhdlID_in_ruleQualifiedName6290);
                    this_PhdlID_2=rulePhdlID();

                    state._fsp--;


                    		current.merge(this_PhdlID_2);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRulePhdlID"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3039:1: entryRulePhdlID returns [String current=null] : iv_rulePhdlID= rulePhdlID EOF ;
    public final String entryRulePhdlID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePhdlID = null;


        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3040:2: (iv_rulePhdlID= rulePhdlID EOF )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3041:2: iv_rulePhdlID= rulePhdlID EOF
            {
             newCompositeNode(grammarAccess.getPhdlIDRule()); 
            pushFollow(FOLLOW_rulePhdlID_in_entryRulePhdlID6338);
            iv_rulePhdlID=rulePhdlID();

            state._fsp--;

             current =iv_rulePhdlID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePhdlID6349); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePhdlID"


    // $ANTLR start "rulePhdlID"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3048:1: rulePhdlID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | this_ID_1= RULE_ID | this_PINNUM_2= RULE_PINNUM ) ;
    public final AntlrDatatypeRuleToken rulePhdlID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token this_ID_1=null;
        Token this_PINNUM_2=null;

         enterRule(); 
            
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3051:28: ( (this_INT_0= RULE_INT | this_ID_1= RULE_ID | this_PINNUM_2= RULE_PINNUM ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3052:1: (this_INT_0= RULE_INT | this_ID_1= RULE_ID | this_PINNUM_2= RULE_PINNUM )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3052:1: (this_INT_0= RULE_INT | this_ID_1= RULE_ID | this_PINNUM_2= RULE_PINNUM )
            int alt54=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt54=1;
                }
                break;
            case RULE_ID:
                {
                alt54=2;
                }
                break;
            case RULE_PINNUM:
                {
                alt54=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3052:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_rulePhdlID6389); 

                    		current.merge(this_INT_0);
                        
                     
                        newLeafNode(this_INT_0, grammarAccess.getPhdlIDAccess().getINTTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3060:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePhdlID6415); 

                    		current.merge(this_ID_1);
                        
                     
                        newLeafNode(this_ID_1, grammarAccess.getPhdlIDAccess().getIDTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3068:10: this_PINNUM_2= RULE_PINNUM
                    {
                    this_PINNUM_2=(Token)match(input,RULE_PINNUM,FOLLOW_RULE_PINNUM_in_rulePhdlID6441); 

                    		current.merge(this_PINNUM_2);
                        
                     
                        newLeafNode(this_PINNUM_2, grammarAccess.getPhdlIDAccess().getPINNUMTerminalRuleCall_2()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePhdlID"


    // $ANTLR start "rulePinType"
    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3083:1: rulePinType returns [Enumerator current=null] : ( (enumLiteral_0= 'pin' ) | (enumLiteral_1= 'inpin' ) | (enumLiteral_2= 'outpin' ) | (enumLiteral_3= 'iopin' ) | (enumLiteral_4= 'pwrpin' ) | (enumLiteral_5= 'suppin' ) | (enumLiteral_6= 'ocpin' ) | (enumLiteral_7= 'oepin' ) | (enumLiteral_8= 'tripin' ) | (enumLiteral_9= 'passpin' ) | (enumLiteral_10= 'ncpin' ) ) ;
    public final Enumerator rulePinType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;

         enterRule(); 
        try {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3085:28: ( ( (enumLiteral_0= 'pin' ) | (enumLiteral_1= 'inpin' ) | (enumLiteral_2= 'outpin' ) | (enumLiteral_3= 'iopin' ) | (enumLiteral_4= 'pwrpin' ) | (enumLiteral_5= 'suppin' ) | (enumLiteral_6= 'ocpin' ) | (enumLiteral_7= 'oepin' ) | (enumLiteral_8= 'tripin' ) | (enumLiteral_9= 'passpin' ) | (enumLiteral_10= 'ncpin' ) ) )
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3086:1: ( (enumLiteral_0= 'pin' ) | (enumLiteral_1= 'inpin' ) | (enumLiteral_2= 'outpin' ) | (enumLiteral_3= 'iopin' ) | (enumLiteral_4= 'pwrpin' ) | (enumLiteral_5= 'suppin' ) | (enumLiteral_6= 'ocpin' ) | (enumLiteral_7= 'oepin' ) | (enumLiteral_8= 'tripin' ) | (enumLiteral_9= 'passpin' ) | (enumLiteral_10= 'ncpin' ) )
            {
            // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3086:1: ( (enumLiteral_0= 'pin' ) | (enumLiteral_1= 'inpin' ) | (enumLiteral_2= 'outpin' ) | (enumLiteral_3= 'iopin' ) | (enumLiteral_4= 'pwrpin' ) | (enumLiteral_5= 'suppin' ) | (enumLiteral_6= 'ocpin' ) | (enumLiteral_7= 'oepin' ) | (enumLiteral_8= 'tripin' ) | (enumLiteral_9= 'passpin' ) | (enumLiteral_10= 'ncpin' ) )
            int alt55=11;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt55=1;
                }
                break;
            case 43:
                {
                alt55=2;
                }
                break;
            case 44:
                {
                alt55=3;
                }
                break;
            case 45:
                {
                alt55=4;
                }
                break;
            case 46:
                {
                alt55=5;
                }
                break;
            case 47:
                {
                alt55=6;
                }
                break;
            case 48:
                {
                alt55=7;
                }
                break;
            case 49:
                {
                alt55=8;
                }
                break;
            case 50:
                {
                alt55=9;
                }
                break;
            case 51:
                {
                alt55=10;
                }
                break;
            case 52:
                {
                alt55=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3086:2: (enumLiteral_0= 'pin' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3086:2: (enumLiteral_0= 'pin' )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3086:4: enumLiteral_0= 'pin'
                    {
                    enumLiteral_0=(Token)match(input,42,FOLLOW_42_in_rulePinType6500); 

                            current = grammarAccess.getPinTypeAccess().getPinEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getPinTypeAccess().getPinEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3092:6: (enumLiteral_1= 'inpin' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3092:6: (enumLiteral_1= 'inpin' )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3092:8: enumLiteral_1= 'inpin'
                    {
                    enumLiteral_1=(Token)match(input,43,FOLLOW_43_in_rulePinType6517); 

                            current = grammarAccess.getPinTypeAccess().getInputEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getPinTypeAccess().getInputEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3098:6: (enumLiteral_2= 'outpin' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3098:6: (enumLiteral_2= 'outpin' )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3098:8: enumLiteral_2= 'outpin'
                    {
                    enumLiteral_2=(Token)match(input,44,FOLLOW_44_in_rulePinType6534); 

                            current = grammarAccess.getPinTypeAccess().getOutputEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getPinTypeAccess().getOutputEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3104:6: (enumLiteral_3= 'iopin' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3104:6: (enumLiteral_3= 'iopin' )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3104:8: enumLiteral_3= 'iopin'
                    {
                    enumLiteral_3=(Token)match(input,45,FOLLOW_45_in_rulePinType6551); 

                            current = grammarAccess.getPinTypeAccess().getInOutEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getPinTypeAccess().getInOutEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3110:6: (enumLiteral_4= 'pwrpin' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3110:6: (enumLiteral_4= 'pwrpin' )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3110:8: enumLiteral_4= 'pwrpin'
                    {
                    enumLiteral_4=(Token)match(input,46,FOLLOW_46_in_rulePinType6568); 

                            current = grammarAccess.getPinTypeAccess().getPowerEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getPinTypeAccess().getPowerEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3116:6: (enumLiteral_5= 'suppin' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3116:6: (enumLiteral_5= 'suppin' )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3116:8: enumLiteral_5= 'suppin'
                    {
                    enumLiteral_5=(Token)match(input,47,FOLLOW_47_in_rulePinType6585); 

                            current = grammarAccess.getPinTypeAccess().getSupplyEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getPinTypeAccess().getSupplyEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3122:6: (enumLiteral_6= 'ocpin' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3122:6: (enumLiteral_6= 'ocpin' )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3122:8: enumLiteral_6= 'ocpin'
                    {
                    enumLiteral_6=(Token)match(input,48,FOLLOW_48_in_rulePinType6602); 

                            current = grammarAccess.getPinTypeAccess().getOpenCollectorEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getPinTypeAccess().getOpenCollectorEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3128:6: (enumLiteral_7= 'oepin' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3128:6: (enumLiteral_7= 'oepin' )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3128:8: enumLiteral_7= 'oepin'
                    {
                    enumLiteral_7=(Token)match(input,49,FOLLOW_49_in_rulePinType6619); 

                            current = grammarAccess.getPinTypeAccess().getOpenEmitterEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_7, grammarAccess.getPinTypeAccess().getOpenEmitterEnumLiteralDeclaration_7()); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3134:6: (enumLiteral_8= 'tripin' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3134:6: (enumLiteral_8= 'tripin' )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3134:8: enumLiteral_8= 'tripin'
                    {
                    enumLiteral_8=(Token)match(input,50,FOLLOW_50_in_rulePinType6636); 

                            current = grammarAccess.getPinTypeAccess().getTristateEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_8, grammarAccess.getPinTypeAccess().getTristateEnumLiteralDeclaration_8()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3140:6: (enumLiteral_9= 'passpin' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3140:6: (enumLiteral_9= 'passpin' )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3140:8: enumLiteral_9= 'passpin'
                    {
                    enumLiteral_9=(Token)match(input,51,FOLLOW_51_in_rulePinType6653); 

                            current = grammarAccess.getPinTypeAccess().getPassiveEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_9, grammarAccess.getPinTypeAccess().getPassiveEnumLiteralDeclaration_9()); 
                        

                    }


                    }
                    break;
                case 11 :
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3146:6: (enumLiteral_10= 'ncpin' )
                    {
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3146:6: (enumLiteral_10= 'ncpin' )
                    // ../edu.byu.ee.phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3146:8: enumLiteral_10= 'ncpin'
                    {
                    enumLiteral_10=(Token)match(input,52,FOLLOW_52_in_rulePinType6670); 

                            current = grammarAccess.getPinTypeAccess().getNoConnectEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_10, grammarAccess.getPinTypeAccess().getNoConnectEnumLiteralDeclaration_10()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePinType"

    // Delegated rules


    protected DFA24 dfa24 = new DFA24(this);
    protected DFA25 dfa25 = new DFA25(this);
    static final String DFA24_eotS =
        "\20\uffff";
    static final String DFA24_eofS =
        "\20\uffff";
    static final String DFA24_minS =
        "\1\4\1\uffff\1\36\1\22\2\uffff\1\6\1\4\1\23\1\uffff\2\6\1\40\1"+
        "\37\1\23\1\4";
    static final String DFA24_maxS =
        "\1\50\1\uffff\1\36\1\46\2\uffff\1\6\1\44\1\45\1\uffff\2\6\1\40"+
        "\2\37\1\7";
    static final String DFA24_acceptS =
        "\1\uffff\1\1\2\uffff\1\3\1\4\3\uffff\1\2\6\uffff";
    static final String DFA24_specialS =
        "\20\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\3\1\uffff\2\4\14\uffff\1\5\7\uffff\1\1\1\4\12\uffff\1\2",
            "",
            "\1\6",
            "\1\7\23\uffff\1\4",
            "",
            "",
            "\1\10",
            "\1\4\1\11\2\4\32\uffff\1\4\1\uffff\1\4",
            "\1\13\13\uffff\1\14\5\uffff\1\12",
            "",
            "\1\15",
            "\1\16",
            "\1\17",
            "\1\14",
            "\1\13\13\uffff\1\14",
            "\1\3\1\uffff\2\4"
    };

    static final short[] DFA24_eot = DFA.unpackEncodedString(DFA24_eotS);
    static final short[] DFA24_eof = DFA.unpackEncodedString(DFA24_eofS);
    static final char[] DFA24_min = DFA.unpackEncodedStringToUnsignedChars(DFA24_minS);
    static final char[] DFA24_max = DFA.unpackEncodedStringToUnsignedChars(DFA24_maxS);
    static final short[] DFA24_accept = DFA.unpackEncodedString(DFA24_acceptS);
    static final short[] DFA24_special = DFA.unpackEncodedString(DFA24_specialS);
    static final short[][] DFA24_transition;

    static {
        int numStates = DFA24_transitionS.length;
        DFA24_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
        }
    }

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = DFA24_eot;
            this.eof = DFA24_eof;
            this.min = DFA24_min;
            this.max = DFA24_max;
            this.accept = DFA24_accept;
            this.special = DFA24_special;
            this.transition = DFA24_transition;
        }
        public String getDescription() {
            return "1387:1: (this_NewAttr_0= ruleNewAttr | this_RefAttr_1= ruleRefAttr | this_PinAssign_2= rulePinAssign | this_Info_3= ruleInfo )";
        }
    }
    static final String DFA25_eotS =
        "\17\uffff";
    static final String DFA25_eofS =
        "\17\uffff";
    static final String DFA25_minS =
        "\1\4\1\uffff\1\36\1\22\2\uffff\1\6\1\uffff\1\23\2\6\1\40\1\37\1"+
        "\23\1\4";
    static final String DFA25_maxS =
        "\1\50\1\uffff\1\36\1\46\2\uffff\1\6\1\uffff\1\45\2\6\1\40\2\37"+
        "\1\7";
    static final String DFA25_acceptS =
        "\1\uffff\1\1\2\uffff\1\3\1\4\1\uffff\1\2\7\uffff";
    static final String DFA25_specialS =
        "\17\uffff}>";
    static final String[] DFA25_transitionS = {
            "\1\3\1\uffff\2\4\11\uffff\1\1\2\uffff\1\5\10\uffff\1\4\12\uffff"+
            "\1\2",
            "",
            "\1\6",
            "\1\4\13\uffff\1\7\1\uffff\1\7\5\uffff\1\4",
            "",
            "",
            "\1\10",
            "",
            "\1\12\13\uffff\1\13\5\uffff\1\11",
            "\1\14",
            "\1\15",
            "\1\16",
            "\1\13",
            "\1\12\13\uffff\1\13",
            "\1\3\1\uffff\2\4"
    };

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "1447:1: (this_Attr_0= ruleAttr | this_SubAttr_1= ruleSubAttr | this_PortAssign_2= rulePortAssign | this_Info_3= ruleInfo )";
        }
    }
 

    public static final BitSet FOLLOW_rulePhdlModel_in_entryRulePhdlModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePhdlModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rulePhdlModel131 = new BitSet(new long[]{0x0000000000614802L});
    public static final BitSet FOLLOW_rulePackage_in_rulePhdlModel154 = new BitSet(new long[]{0x0000000000610802L});
    public static final BitSet FOLLOW_ruleDevice_in_rulePhdlModel181 = new BitSet(new long[]{0x0000000000610802L});
    public static final BitSet FOLLOW_ruleDesign_in_rulePhdlModel208 = new BitSet(new long[]{0x0000000000610802L});
    public static final BitSet FOLLOW_rulePackage_in_entryRulePackage246 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackage256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rulePackage293 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePackage310 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_rulePackage327 = new BitSet(new long[]{0x0000000000616800L});
    public static final BitSet FOLLOW_ruleImport_in_rulePackage348 = new BitSet(new long[]{0x0000000000616800L});
    public static final BitSet FOLLOW_ruleDevice_in_rulePackage371 = new BitSet(new long[]{0x0000000000612800L});
    public static final BitSet FOLLOW_ruleDesign_in_rulePackage398 = new BitSet(new long[]{0x0000000000612800L});
    public static final BitSet FOLLOW_13_in_rulePackage412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport448 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleImport495 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport516 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleImport528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDevice_in_entryRuleDevice564 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDevice574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleDevice611 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_rulePhdlID_in_ruleDevice632 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleDevice644 = new BitSet(new long[]{0x001FFC0000122000L});
    public static final BitSet FOLLOW_ruleDeviceElement_in_ruleDevice665 = new BitSet(new long[]{0x001FFC0000122000L});
    public static final BitSet FOLLOW_13_in_ruleDevice678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeviceElement_in_entryRuleDeviceElement714 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeviceElement724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttr_in_ruleDeviceElement771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePin_in_ruleDeviceElement798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInfo_in_ruleDeviceElement825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttr_in_entryRuleAttr860 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttr870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleAttr907 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAttr924 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleAttr941 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAttr958 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAttr975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePin_in_entryRulePin1011 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePin1021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePinType_in_rulePin1067 = new BitSet(new long[]{0x00000040000000D0L});
    public static final BitSet FOLLOW_ruleVector_in_rulePin1088 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_rulePhdlID_in_rulePin1109 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_rulePin1121 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_rulePin1133 = new BitSet(new long[]{0x00000000000020D0L});
    public static final BitSet FOLLOW_rulePhdlID_in_rulePin1155 = new BitSet(new long[]{0x0000000000082000L});
    public static final BitSet FOLLOW_19_in_rulePin1168 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_rulePhdlID_in_rulePin1189 = new BitSet(new long[]{0x0000000000082000L});
    public static final BitSet FOLLOW_13_in_rulePin1205 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rulePin1217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInfo_in_entryRuleInfo1253 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInfo1263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleInfo1300 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleInfo1312 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleInfo1329 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleInfo1346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDesign_in_entryRuleDesign1382 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDesign1392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleDesign1436 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_22_in_ruleDesign1473 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDesign1504 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleDesign1521 = new BitSet(new long[]{0x001FFC000B9220D0L});
    public static final BitSet FOLLOW_ruleDesignElement_in_ruleDesign1542 = new BitSet(new long[]{0x001FFC000B9220D0L});
    public static final BitSet FOLLOW_13_in_ruleDesign1555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDesignElement_in_entryRuleDesignElement1591 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDesignElement1601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnection_in_ruleDesignElement1648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstance_in_ruleDesignElement1675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionAssign_in_ruleDesignElement1702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInfo_in_ruleDesignElement1729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnection_in_entryRuleConnection1764 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnection1774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleConnection1818 = new BitSet(new long[]{0x00000040000000D0L});
    public static final BitSet FOLLOW_ruleVector_in_ruleConnection1852 = new BitSet(new long[]{0x00000040000000D0L});
    public static final BitSet FOLLOW_ruleConnectionName_in_ruleConnection1873 = new BitSet(new long[]{0x0000000000089000L});
    public static final BitSet FOLLOW_19_in_ruleConnection1886 = new BitSet(new long[]{0x00000040000000D0L});
    public static final BitSet FOLLOW_ruleConnectionName_in_ruleConnection1907 = new BitSet(new long[]{0x0000000000089000L});
    public static final BitSet FOLLOW_12_in_ruleConnection1923 = new BitSet(new long[]{0x001FFC0000122000L});
    public static final BitSet FOLLOW_ruleNetElement_in_ruleConnection1944 = new BitSet(new long[]{0x001FFC0000122000L});
    public static final BitSet FOLLOW_13_in_ruleConnection1957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleConnection1976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleConnection2003 = new BitSet(new long[]{0x00000040000000D0L});
    public static final BitSet FOLLOW_ruleVector_in_ruleConnection2037 = new BitSet(new long[]{0x00000040000000D0L});
    public static final BitSet FOLLOW_ruleConnectionName_in_ruleConnection2058 = new BitSet(new long[]{0x0000000000089000L});
    public static final BitSet FOLLOW_19_in_ruleConnection2071 = new BitSet(new long[]{0x00000040000000D0L});
    public static final BitSet FOLLOW_ruleConnectionName_in_ruleConnection2092 = new BitSet(new long[]{0x0000000000089000L});
    public static final BitSet FOLLOW_12_in_ruleConnection2108 = new BitSet(new long[]{0x001FFC0000122000L});
    public static final BitSet FOLLOW_rulePortElement_in_ruleConnection2129 = new BitSet(new long[]{0x001FFC0000122000L});
    public static final BitSet FOLLOW_13_in_ruleConnection2142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleConnection2161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNetElement_in_entryRuleNetElement2199 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNetElement2209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttr_in_ruleNetElement2256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInfo_in_ruleNetElement2283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortElement_in_entryRulePortElement2318 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePortElement2328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInfo_in_rulePortElement2374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstance_in_entryRuleInstance2408 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstance2418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleInstance2462 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_ruleArray_in_ruleInstance2496 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInstance2513 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleInstance2530 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleInstance2553 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleInstance2565 = new BitSet(new long[]{0x001FFD00301220D0L});
    public static final BitSet FOLLOW_ruleInstanceElement_in_ruleInstance2586 = new BitSet(new long[]{0x001FFD00301220D0L});
    public static final BitSet FOLLOW_13_in_ruleInstance2599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleInstance2625 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_ruleArray_in_ruleInstance2659 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInstance2676 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleInstance2693 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleInstance2716 = new BitSet(new long[]{0x0000000000001020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleInstance2733 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleInstance2751 = new BitSet(new long[]{0x001FFD00201220D0L});
    public static final BitSet FOLLOW_ruleSubInstanceElement_in_ruleInstance2772 = new BitSet(new long[]{0x001FFD00201220D0L});
    public static final BitSet FOLLOW_13_in_ruleInstance2785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstanceElement_in_entryRuleInstanceElement2822 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstanceElement2832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNewAttr_in_ruleInstanceElement2879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefAttr_in_ruleInstanceElement2906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePinAssign_in_ruleInstanceElement2933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInfo_in_ruleInstanceElement2960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubInstanceElement_in_entryRuleSubInstanceElement2995 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubInstanceElement3005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttr_in_ruleSubInstanceElement3052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubAttr_in_ruleSubInstanceElement3079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortAssign_in_ruleSubInstanceElement3106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInfo_in_ruleSubInstanceElement3133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefAttr_in_entryRuleRefAttr3168 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRefAttr3178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifier_in_ruleRefAttr3224 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRefAttr3245 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleRefAttr3257 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleRefAttr3274 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleRefAttr3291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNewAttr_in_entryRuleNewAttr3327 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNewAttr3337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleNewAttr3374 = new BitSet(new long[]{0x0000010000000010L});
    public static final BitSet FOLLOW_ruleQualifier_in_ruleNewAttr3395 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNewAttr3413 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleNewAttr3430 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNewAttr3447 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleNewAttr3464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePinAssign_in_entryRulePinAssign3500 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePinAssign3510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rulePinAssign3555 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_rulePinAssign3580 = new BitSet(new long[]{0x00000100000000D0L});
    public static final BitSet FOLLOW_ruleQualifier_in_rulePinAssign3601 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_rulePhdlID_in_rulePinAssign3625 = new BitSet(new long[]{0x0000004080000000L});
    public static final BitSet FOLLOW_ruleSlices_in_rulePinAssign3646 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_rulePinAssign3659 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ruleQualifier_in_rulePinAssign3688 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_rulePhdlID_in_rulePinAssign3712 = new BitSet(new long[]{0x0000004000040000L});
    public static final BitSet FOLLOW_ruleSlices_in_rulePinAssign3733 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_rulePinAssign3748 = new BitSet(new long[]{0x00000014000000D0L});
    public static final BitSet FOLLOW_ruleConcatenation_in_rulePinAssign3769 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rulePinAssign3781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubAttr_in_entryRuleSubAttr3817 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubAttr3827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifier_in_ruleSubAttr3873 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubAttr3895 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_ruleIndices_in_ruleSubAttr3916 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_ruleRefTail_in_ruleSubAttr3939 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleSubAttr3951 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSubAttr3968 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSubAttr3985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefTail_in_entryRuleRefTail4021 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRefTail4031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleRefTail4068 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRefTail4088 = new BitSet(new long[]{0x0000000140000002L});
    public static final BitSet FOLLOW_ruleIndices_in_ruleRefTail4109 = new BitSet(new long[]{0x0000000140000002L});
    public static final BitSet FOLLOW_ruleRefTail_in_ruleRefTail4131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortAssign_in_entryRulePortAssign4168 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePortAssign4178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rulePortAssign4223 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_rulePortAssign4248 = new BitSet(new long[]{0x00000100000000D0L});
    public static final BitSet FOLLOW_ruleQualifier_in_rulePortAssign4269 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_rulePhdlID_in_rulePortAssign4293 = new BitSet(new long[]{0x0000004080000000L});
    public static final BitSet FOLLOW_ruleSlices_in_rulePortAssign4314 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_rulePortAssign4327 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ruleQualifier_in_rulePortAssign4356 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_rulePhdlID_in_rulePortAssign4380 = new BitSet(new long[]{0x0000004000040000L});
    public static final BitSet FOLLOW_ruleSlices_in_rulePortAssign4401 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_rulePortAssign4416 = new BitSet(new long[]{0x00000014000000D0L});
    public static final BitSet FOLLOW_ruleConcatenation_in_rulePortAssign4437 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rulePortAssign4449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionAssign_in_entryRuleConnectionAssign4485 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionAssign4495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhdlID_in_ruleConnectionAssign4543 = new BitSet(new long[]{0x0000004000040000L});
    public static final BitSet FOLLOW_ruleSlices_in_ruleConnectionAssign4564 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleConnectionAssign4577 = new BitSet(new long[]{0x00000014000000D0L});
    public static final BitSet FOLLOW_ruleConcatenation_in_ruleConnectionAssign4598 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleConnectionAssign4610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcatenation_in_entryRuleConcatenation4646 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConcatenation4656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionRef_in_ruleConcatenation4703 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleConcatenation4716 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_ruleConnectionRef_in_ruleConcatenation4737 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_34_in_ruleConcatenation4765 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_ruleConnectionRef_in_ruleConcatenation4799 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleConcatenation4811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleConcatenation4836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionRef_in_entryRuleConnectionRef4885 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionRef4895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhdlID_in_ruleConnectionRef4943 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_ruleSlices_in_ruleConnectionRef4964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionName_in_entryRuleConnectionName5001 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionName5011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhdlID_in_ruleConnectionName5056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIndices_in_entryRuleIndices5091 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIndices5101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleIndices5138 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIndices5157 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleIndices5180 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIndices5210 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIndices5240 = new BitSet(new long[]{0x0000000080080000L});
    public static final BitSet FOLLOW_19_in_ruleIndices5258 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIndices5275 = new BitSet(new long[]{0x0000000080080000L});
    public static final BitSet FOLLOW_31_in_ruleIndices5296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSlices_in_entryRuleSlices5332 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSlices5342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleSlices5379 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSlices5398 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleSlices5421 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSlices5451 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSlices5481 = new BitSet(new long[]{0x0000008000080000L});
    public static final BitSet FOLLOW_19_in_ruleSlices5499 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSlices5516 = new BitSet(new long[]{0x0000008000080000L});
    public static final BitSet FOLLOW_39_in_ruleSlices5537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVector_in_entryRuleVector5573 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVector5583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleVector5630 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVector5647 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleVector5670 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVector5700 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleVector5717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArray_in_entryRuleArray5755 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArray5765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleArray5812 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleArray5829 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleArray5852 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleArray5882 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleArray5899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifier_in_entryRuleQualifier5937 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifier5947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleQualifier5984 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleIndices_in_ruleQualifier6005 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleQualifier6017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard6058 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard6069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard6116 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleQualifiedNameWithWildCard6135 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleQualifiedNameWithWildCard6148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName6191 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName6202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhdlID_in_ruleQualifiedName6249 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleQualifiedName6268 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_rulePhdlID_in_ruleQualifiedName6290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhdlID_in_entryRulePhdlID6338 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePhdlID6349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rulePhdlID6389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePhdlID6415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PINNUM_in_rulePhdlID6441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rulePinType6500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rulePinType6517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rulePinType6534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rulePinType6551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rulePinType6568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rulePinType6585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rulePinType6602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rulePinType6619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rulePinType6636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rulePinType6653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rulePinType6670 = new BitSet(new long[]{0x0000000000000002L});

}