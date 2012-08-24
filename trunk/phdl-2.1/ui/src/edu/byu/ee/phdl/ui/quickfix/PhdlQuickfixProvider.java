package edu.byu.ee.phdl.ui.quickfix;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;

import edu.byu.ee.phdl.phdl.Attr;
import edu.byu.ee.phdl.phdl.Concatenation;
import edu.byu.ee.phdl.phdl.Connection;
import edu.byu.ee.phdl.phdl.ConnectionAssign;
import edu.byu.ee.phdl.phdl.ConnectionName;
import edu.byu.ee.phdl.phdl.ConnectionRef;
import edu.byu.ee.phdl.phdl.Design;
import edu.byu.ee.phdl.phdl.Device;
import edu.byu.ee.phdl.phdl.Instance;
import edu.byu.ee.phdl.phdl.PhdlFactory;
import edu.byu.ee.phdl.phdl.Pin;
import edu.byu.ee.phdl.phdl.PinAssign;
import edu.byu.ee.phdl.phdl.PortAssign;
import edu.byu.ee.phdl.phdl.Vector;
import edu.byu.ee.phdl.utils.PhdlUtils;
import edu.byu.ee.phdl.validation.IssueCodes;

public class PhdlQuickfixProvider extends DefaultQuickfixProvider {

	@Inject
	IContainer.Manager containermanager;

	@Inject
	IResourceDescriptions resourceDescriptions;

	@Fix(IssueCodes.ARRAY_NOT_DECLARED)
	public void fixArrayNotDeclared(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove vector slices", "Removes vector slices from object", null, new ISemanticModification() {
			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				if (element instanceof PinAssign) {
					((PinAssign) element).setSlices(null);
				} else if (element instanceof PortAssign) {
					((PortAssign) element).setSlices(null);
				} else if (element instanceof ConnectionAssign) {
					((ConnectionAssign) element).setSlices(null);
				} else if (element instanceof ConnectionRef) {
					((ConnectionRef) element).setSlices(null);
				}
			}
		});
	}

	@Fix(IssueCodes.ASSIGNMENT_WIDTH_MISMATCH)
	public void fixAssignmentWidth(final Issue issue, IssueResolutionAcceptor acceptor) {
		if (Integer.parseInt(issue.getData()[2]) == 1) {
			acceptor.accept(issue, "Replicate connection", "Replicates the connection", "Replicate.gif", new ISemanticModification() {
				@Override
				public void apply(EObject element, IModificationContext context) throws Exception {
					if (element instanceof Instance) {
						Instance instance = (Instance) element;
						if (instance.isInst()) {
							PinAssign pinAssign = (PinAssign) instance.getElements().get(Integer.parseInt(issue.getData()[0]));
							ConnectionRef conRef = pinAssign.getConcatenation().getConnections().get(0);
							Concatenation newConcatenation = PhdlFactory.eINSTANCE.createConcatenation();
							newConcatenation.setReplicate(conRef);
							newConcatenation.setReplicated(true);
							pinAssign.setConcatenation(newConcatenation);
						} else {
							PortAssign portAssign = (PortAssign) instance.getElements().get(Integer.parseInt(issue.getData()[0]));
							ConnectionRef conRef = portAssign.getConcatenation().getConnections().get(0);
							Concatenation newConcatenation = PhdlFactory.eINSTANCE.createConcatenation();
							newConcatenation.setReplicate(conRef);
							newConcatenation.setReplicated(true);
							portAssign.setConcatenation(newConcatenation);
						}
					} else if (element instanceof Design) {
						Design design = (Design) element;
						ConnectionAssign assign = (ConnectionAssign) design.getElements().get(Integer.parseInt(issue.getData()[0]));
						ConnectionRef conRef = assign.getConcatenation().getConnections().get(0);
						Concatenation newConcatenation = PhdlFactory.eINSTANCE.createConcatenation();
						newConcatenation.setReplicate(conRef);
						newConcatenation.setReplicated(true);
						assign.setConcatenation(newConcatenation);
					}
				}
			});
		}
	}

	@Fix(IssueCodes.NOT_UPPERCASE)
	public void fixCase(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Convert to UPPERCASE",
				"Convert '" + issue.getData()[0] + "' to '" + issue.getData()[0].toUpperCase() + "'", "Upcase.gif", new IModification() {
					@Override
					public void apply(IModificationContext context) throws BadLocationException {
						IXtextDocument document = context.getXtextDocument();
						String name = document.get(issue.getOffset(), issue.getLength());
						document.replace(issue.getOffset(), issue.getLength(), name.toUpperCase());
					}

				});
	}

	@Fix(IssueCodes.MISSING_CONNECTION_DECL)
	public void fixMissingConnectionDecl(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Declare net", "Adds a missing net declaration", "Net.gif", new ISemanticModification() {
			@Override
			public void apply(EObject element, IModificationContext context) throws BadLocationException {
				IXtextDocument document = context.getXtextDocument();

				Instance instance = (Instance) element.eContainer().eContainer().eContainer();
				Design design = (Design) instance.eContainer();
				ConnectionName connName = PhdlFactory.eINSTANCE.createConnectionName();
				Vector vector = PhdlFactory.eINSTANCE.createVector();
				connName.setName(issue.getData()[0]);
				Connection conn = PhdlFactory.eINSTANCE.createConnection();
				conn.getNames().add(connName);
				conn.setNet(true);
				conn.setVector(vector);
				design.getElements().add(design.getElements().indexOf(instance), conn);
				EcoreUtil2.resolveAll(element.eResource());
			}
		});

		acceptor.accept(issue, "Declare port", "Adds a missing port declaration", "Port.gif", new ISemanticModification() {
			@Override
			public void apply(EObject element, IModificationContext context) throws BadLocationException {

				// find the design container
				EObject design = element;
				while (!(design instanceof Design)) {
					design = design.eContainer();
				}

				// find the instance container
				EObject instance = element;
				while (!(instance instanceof Instance)) {
					instance = instance.eContainer();
				}

				ConnectionName connName = PhdlFactory.eINSTANCE.createConnectionName();
				connName.setName(issue.getData()[0]);
				Connection conn = PhdlFactory.eINSTANCE.createConnection();
				Vector vector = PhdlFactory.eINSTANCE.createVector();
				conn.getNames().add(connName);
				conn.setPort(true);
				conn.setVector(vector);
				((Design) design).getElements().add(((Design) design).getElements().indexOf(instance), conn);
			}
		});
		createLinkingIssueResolutions(issue, acceptor);
	}

	@Fix(IssueCodes.REQUIRED_ATTRIBUTE_MISSING)
	public void fixMissingRequiredAttribute(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add missing required attribute", "Add missing '" + issue.getData()[0] + "' required attribute.",
				"Attr.gif", new ISemanticModification() {
					@Override
					public void apply(EObject element, IModificationContext context) throws Exception {
						Device device = (Device) element;
						Attr attr = PhdlFactory.eINSTANCE.createAttr();
						attr.setName(issue.getData()[0].toUpperCase());
						if (!issue.getData()[0].equals("REFPREFIX"))
							attr.setValue("my" + issue.getData()[0]);
						else
							attr.setValue("R");
						device.getElements().add(attr);
					}
				});
	}

	@Fix(IssueCodes.INVALID_PIN_DECLARATION)
	public void fixPinDeclaration(final Issue issue, IssueResolutionAcceptor acceptor) {
		final int index = Integer.parseInt(issue.getData()[0]);
		final boolean isVector = Boolean.parseBoolean(issue.getData()[1]);
		final int width = Integer.parseInt(issue.getData()[2]);
		final int size = Integer.parseInt(issue.getData()[3]);

		if (!isVector) {
			if (size == 0) {
				acceptor.accept(issue, "Add missing pin list element", "Adds the missing pin list element", null,
						new ISemanticModification() {
							@Override
							public void apply(EObject element, IModificationContext context) throws Exception {
								Pin pin = (Pin) ((Device) element).getElements().get(index);
								pin.getPinNames().add(pin.getName());
							}
						});
				return;
			}
			acceptor.accept(issue, "Declare as vector", "Declares the pin as a vector", null, new ISemanticModification() {
				@Override
				public void apply(EObject element, IModificationContext context) throws Exception {
					Pin pin = (Pin) ((Device) element).getElements().get(index);
					pin.getVector().setVector(true);
					pin.getVector().setMsb(size - 1);
					pin.getVector().setLsb(0);
				}
			});
			acceptor.accept(issue, "Remove invalid pin list elements", "Removes invalid pin list elements", null,
					new ISemanticModification() {
						@Override
						public void apply(EObject element, IModificationContext context) throws Exception {
							Pin pin = (Pin) ((Device) element).getElements().get(index);
							for (int i = pin.getPinNames().size() - 1; i > 0; i--)
								pin.getPinNames().remove(i);
						}
					});
			return;
		}
		acceptor.accept(issue, "Change vector msb", "Changes vector msb to match pin list size", null, new ISemanticModification() {
			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				Pin pin = (Pin) ((Device) element).getElements().get(index);
				if (pin.getVector().getMsb() > pin.getVector().getLsb()) {
					pin.getVector().setMsb(pin.getVector().getLsb() + (size - 1));
				} else {
					int newMsb = pin.getVector().getLsb() - (size - 1);
					// the new msb may be negative, forcing a change of both msb and lsb
					if (newMsb >= 0) {
						pin.getVector().setMsb(newMsb);
					} else {
						pin.getVector().setMsb(0);
						pin.getVector().setLsb(size - 1);
					}
				}
			}
		});
		acceptor.accept(issue, "Change vector lsb", "Changes vector lsb to match pin list size", null, new ISemanticModification() {
			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				Pin pin = (Pin) ((Device) element).getElements().get(index);
				if (pin.getVector().getMsb() > pin.getVector().getLsb()) {
					int newLsb = pin.getVector().getMsb() - (size - 1);
					// the new lsb may be negative, forcing a change of both msb and lsb
					if (newLsb >= 0) {
						pin.getVector().setLsb(newLsb);
					} else {
						pin.getVector().setMsb(size - 1);
						pin.getVector().setLsb(0);
					}
				} else {
					pin.getVector().setLsb(pin.getVector().getMsb() + (size - 1));
				}
			}

		});
		if (width < size) {
			acceptor.accept(issue, "Remove invalid pin list elements", "Removes invalid pin list elements to match pin vector width", null,
					new ISemanticModification() {
						@Override
						public void apply(EObject element, IModificationContext context) throws Exception {
							Pin pin = (Pin) ((Device) element).getElements().get(index);
							for (int i = pin.getPinNames().size() - 1; i >= width; i--)
								pin.getPinNames().remove(i);
						}
					});
		} else {
			acceptor.accept(issue, "Generate new pin list from pin name and vector indices",
					"Generates new pin list elements from the pin name and vector if it exists", null, new ISemanticModification() {
						@Override
						public void apply(EObject element, IModificationContext context) throws Exception {
							Pin pin = (Pin) ((Device) element).getElements().get(index);
							pin.getPinNames().clear();
							for (Integer i : PhdlUtils.getIndices(pin.getVector().getMsb(), pin.getVector().getLsb())) {
								pin.getPinNames().add(pin.getName() + i);
							}
						}
					});

			acceptor.accept(issue, "Generate new pin list from only vector indices ",
					"Generates new pin list elements from the vector if it exists", null, new ISemanticModification() {
						@Override
						public void apply(EObject element, IModificationContext context) throws Exception {
							Pin pin = (Pin) ((Device) element).getElements().get(index);
							pin.getPinNames().clear();
							for (Integer i : PhdlUtils.getIndices(pin.getVector().getMsb(), pin.getVector().getLsb())) {
								pin.getPinNames().add(Integer.toString(i));
							}
						}
					});
		}
	}
}
