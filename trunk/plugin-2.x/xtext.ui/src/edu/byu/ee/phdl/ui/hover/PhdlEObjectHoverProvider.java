package edu.byu.ee.phdl.ui.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;

import edu.byu.ee.phdl.phdl.Connection;
import edu.byu.ee.phdl.phdl.ConnectionName;

public class PhdlEObjectHoverProvider extends DefaultEObjectHoverProvider {

	@Override
	protected String getFirstLine(EObject o) {

		if (o instanceof ConnectionName) {
			ConnectionName n = (ConnectionName) o;
			Connection c = (Connection) n.eContainer();
			if (c.isNet())
				return "Net <b>" + getLabel(n) + "</b>";
			else
				return "Port <b>" + getLabel(n) + "</b>";
		}
		return super.getFirstLine(o);
	}
}
