package edu.byu.ee.phdl.ui.editor.autoedit;

import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;

public class PhdlAutoEditStrategyProvider extends DefaultAutoEditStrategyProvider {

	@Override
	protected void configure(IEditStrategyAcceptor acceptor) {
		configureIndentationEditStrategy(acceptor);
		// configureStringLiteral(acceptor);
		// configureParenthesis(acceptor);
		// configureSquareBrackets(acceptor);
		// configureCurlyBracesBlock(acceptor);
		configureMultilineComments(acceptor);
		configureCompoundBracesBlocks(acceptor);
	}
}
