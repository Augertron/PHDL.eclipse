package edu.byu.ee.phdl.ui.linking;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;

import edu.byu.ee.phdl.phdl.ConnectionRef;
import edu.byu.ee.phdl.validation.IssueCodes;

public class PhdlLinkingDiagnosticMessageProvider extends LinkingDiagnosticMessageProvider {

	@Override
	public DiagnosticMessage getUnresolvedProxyMessage(final ILinkingDiagnosticContext context) {

		EObject object = context.getContext();
		if (object instanceof ConnectionRef) {
			return new DiagnosticMessage("Missing connection declaration", Severity.ERROR,
					IssueCodes.MISSING_CONNECTION_DECL, context.getLinkText());
		}
		return super.getUnresolvedProxyMessage(context);
	}
}
