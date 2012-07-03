package edu.byu.ee.phdl.ui.outline;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.xtext.ui.PluginImageHelper;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.actions.AbstractFilterOutlineContribution;

import com.google.inject.Inject;

public class FilterDesignsContribution extends AbstractFilterOutlineContribution {

	public static final String PREFERENCE_KEY = "ui.outline.filterDesigns";

	@Inject
	private PluginImageHelper imageHelper;

	@Override
	protected boolean apply(IOutlineNode node) {
		return !(node.getText().toString().equals("Designs"));
	}

	@Override
	protected void configureAction(Action action) {
		action.setText("Filter design declarations");
		action.setDescription("Filter design declarations");
		action.setToolTipText("Filter design declarations");
		action.setImageDescriptor(ImageDescriptor.createFromImage(imageHelper.getImage("Design.gif")));
	}

	@Override
	public String getPreferenceKey() {
		return PREFERENCE_KEY;
	}
}