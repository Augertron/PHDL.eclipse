package edu.byu.ee.phdl.ui.outline;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.xtext.ui.PluginImageHelper;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.actions.AbstractFilterOutlineContribution;

import com.google.inject.Inject;

public class FilterDevicesContribution extends AbstractFilterOutlineContribution {

	public static final String PREFERENCE_KEY = "ui.outline.filterDevices";

	@Inject
	private PluginImageHelper imageHelper;

	@Override
	protected boolean apply(IOutlineNode node) {
		return !(node.getText().toString().equals("Devices"));
	}

	@Override
	protected void configureAction(Action action) {
		action.setText("Filter device declarations");
		action.setDescription("Filter device declarations");
		action.setToolTipText("Filter device declarations");
		action.setImageDescriptor(ImageDescriptor.createFromImage(imageHelper.getImage("Device.gif")));
	}

	@Override
	public String getPreferenceKey() {
		return PREFERENCE_KEY;
	}

}
