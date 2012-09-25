package edu.byu.ee.phdl.serializer;

import com.google.inject.Inject;
import edu.byu.ee.phdl.services.PhdlGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public abstract class AbstractPhdlSyntacticSequencer extends AbstractSyntacticSequencer {

	protected PhdlGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Connection_SemicolonKeyword_0_4_1_or___LeftCurlyBracketKeyword_0_4_0_0_RightCurlyBracketKeyword_0_4_0_2__;
	protected AbstractElementAlias match_Connection_SemicolonKeyword_1_4_1_or___LeftCurlyBracketKeyword_1_4_0_0_RightCurlyBracketKeyword_1_4_0_2__;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (PhdlGrammarAccess) access;
		match_Connection_SemicolonKeyword_0_4_1_or___LeftCurlyBracketKeyword_0_4_0_0_RightCurlyBracketKeyword_0_4_0_2__ = new AlternativeAlias(false, false, new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getConnectionAccess().getLeftCurlyBracketKeyword_0_4_0_0()), new TokenAlias(false, false, grammarAccess.getConnectionAccess().getRightCurlyBracketKeyword_0_4_0_2())), new TokenAlias(false, false, grammarAccess.getConnectionAccess().getSemicolonKeyword_0_4_1()));
		match_Connection_SemicolonKeyword_1_4_1_or___LeftCurlyBracketKeyword_1_4_0_0_RightCurlyBracketKeyword_1_4_0_2__ = new AlternativeAlias(false, false, new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getConnectionAccess().getLeftCurlyBracketKeyword_1_4_0_0()), new TokenAlias(false, false, grammarAccess.getConnectionAccess().getRightCurlyBracketKeyword_1_4_0_2())), new TokenAlias(false, false, grammarAccess.getConnectionAccess().getSemicolonKeyword_1_4_1()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_Connection_SemicolonKeyword_0_4_1_or___LeftCurlyBracketKeyword_0_4_0_0_RightCurlyBracketKeyword_0_4_0_2__.equals(syntax))
				emit_Connection_SemicolonKeyword_0_4_1_or___LeftCurlyBracketKeyword_0_4_0_0_RightCurlyBracketKeyword_0_4_0_2__(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Connection_SemicolonKeyword_1_4_1_or___LeftCurlyBracketKeyword_1_4_0_0_RightCurlyBracketKeyword_1_4_0_2__.equals(syntax))
				emit_Connection_SemicolonKeyword_1_4_1_or___LeftCurlyBracketKeyword_1_4_0_0_RightCurlyBracketKeyword_1_4_0_2__(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     ('{' '}') | ';'
	 */
	protected void emit_Connection_SemicolonKeyword_0_4_1_or___LeftCurlyBracketKeyword_0_4_0_0_RightCurlyBracketKeyword_0_4_0_2__(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';' | ('{' '}')
	 */
	protected void emit_Connection_SemicolonKeyword_1_4_1_or___LeftCurlyBracketKeyword_1_4_0_0_RightCurlyBracketKeyword_1_4_0_2__(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
