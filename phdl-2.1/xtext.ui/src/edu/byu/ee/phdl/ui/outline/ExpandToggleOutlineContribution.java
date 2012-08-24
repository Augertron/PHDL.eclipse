package edu.byu.ee.phdl.ui.outline;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.xtext.ui.PluginImageHelper;
import org.eclipse.xtext.ui.editor.outline.actions.AbstractToggleOutlineContribution;
import org.eclipse.xtext.ui.editor.outline.impl.OutlinePage;

import com.google.inject.Inject;

public class ExpandToggleOutlineContribution extends AbstractToggleOutlineContribution {

	public static final String PREFERENCE_KEY = "ui.outline.toggleOperations";

	private TreeViewer treeViewer;

	@Inject
	private PluginImageHelper imageHelper;

	@Override
	protected void configureAction(Action action) {
		action.setText("Expand All");
		action.setToolTipText("Expand All");
		action.setDescription("Expand All");
		action.setImageDescriptor(ImageDescriptor.createFromImage(imageHelper.getImage("ExpandAll.gif")));
	}

	@Override
	public void deregister(OutlinePage outlinePage) {
		super.deregister(outlinePage);
	}

	@Override
	public String getPreferenceKey() {
		return PREFERENCE_KEY;
	}

	@Override
	public void register(OutlinePage outlinePage) {
		super.register(outlinePage);
		treeViewer = outlinePage.getTreeViewer();
	}

	@Override
	protected void stateChanged(boolean newState) {
		if (!treeViewer.getTree().isDisposed()) {
			if (newState) {
				treeViewer.expandAll();
				getAction().setText("Collapse all");
				getAction().setToolTipText("Collapse all");
				getAction().setDescription("Collapse all");
				getAction()
					.setImageDescriptor(ImageDescriptor.createFromImage(imageHelper.getImage("CollapseAll.gif")));
			} else {
				treeViewer.collapseAll();
				getAction().setText("Expand all");
				getAction().setToolTipText("Expand all");
				getAction().setDescription("Expand all");
				getAction().setImageDescriptor(ImageDescriptor.createFromImage(imageHelper.getImage("ExpandAll.gif")));
			}
			treeViewer.refresh();
		}
	}
}
