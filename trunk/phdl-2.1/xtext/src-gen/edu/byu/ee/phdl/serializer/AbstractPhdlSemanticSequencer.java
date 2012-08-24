package edu.byu.ee.phdl.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import edu.byu.ee.phdl.phdl.Array;
import edu.byu.ee.phdl.phdl.Attr;
import edu.byu.ee.phdl.phdl.Concatenation;
import edu.byu.ee.phdl.phdl.Connection;
import edu.byu.ee.phdl.phdl.ConnectionAssign;
import edu.byu.ee.phdl.phdl.ConnectionName;
import edu.byu.ee.phdl.phdl.ConnectionRef;
import edu.byu.ee.phdl.phdl.Design;
import edu.byu.ee.phdl.phdl.Device;
import edu.byu.ee.phdl.phdl.Import;
import edu.byu.ee.phdl.phdl.Indices;
import edu.byu.ee.phdl.phdl.Info;
import edu.byu.ee.phdl.phdl.Instance;
import edu.byu.ee.phdl.phdl.NewAttr;
import edu.byu.ee.phdl.phdl.PhdlModel;
import edu.byu.ee.phdl.phdl.PhdlPackage;
import edu.byu.ee.phdl.phdl.Pin;
import edu.byu.ee.phdl.phdl.PinAssign;
import edu.byu.ee.phdl.phdl.PortAssign;
import edu.byu.ee.phdl.phdl.Qualifier;
import edu.byu.ee.phdl.phdl.RefAttr;
import edu.byu.ee.phdl.phdl.RefTail;
import edu.byu.ee.phdl.phdl.Slices;
import edu.byu.ee.phdl.phdl.SubAttr;
import edu.byu.ee.phdl.phdl.Vector;
import edu.byu.ee.phdl.services.PhdlGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public abstract class AbstractPhdlSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private PhdlGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == PhdlPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case PhdlPackage.ARRAY:
				if(context == grammarAccess.getArrayRule()) {
					sequence_Array(context, (Array) semanticObject); 
					return; 
				}
				else break;
			case PhdlPackage.ATTR:
				if(context == grammarAccess.getAttrRule() ||
				   context == grammarAccess.getDeviceElementRule() ||
				   context == grammarAccess.getNetElementRule() ||
				   context == grammarAccess.getReferenceableRule() ||
				   context == grammarAccess.getSubInstanceElementRule()) {
					sequence_Attr(context, (Attr) semanticObject); 
					return; 
				}
				else break;
			case PhdlPackage.CONCATENATION:
				if(context == grammarAccess.getConcatenationRule()) {
					sequence_Concatenation(context, (Concatenation) semanticObject); 
					return; 
				}
				else break;
			case PhdlPackage.CONNECTION:
				if(context == grammarAccess.getConnectionRule() ||
				   context == grammarAccess.getDesignElementRule()) {
					sequence_Connection(context, (Connection) semanticObject); 
					return; 
				}
				else break;
			case PhdlPackage.CONNECTION_ASSIGN:
				if(context == grammarAccess.getAssignableRule() ||
				   context == grammarAccess.getConnectionAssignRule() ||
				   context == grammarAccess.getDesignElementRule()) {
					sequence_ConnectionAssign(context, (ConnectionAssign) semanticObject); 
					return; 
				}
				else break;
			case PhdlPackage.CONNECTION_NAME:
				if(context == grammarAccess.getConnectionNameRule()) {
					sequence_ConnectionName(context, (ConnectionName) semanticObject); 
					return; 
				}
				else break;
			case PhdlPackage.CONNECTION_REF:
				if(context == grammarAccess.getConnectionRefRule()) {
					sequence_ConnectionRef(context, (ConnectionRef) semanticObject); 
					return; 
				}
				else break;
			case PhdlPackage.DESIGN:
				if(context == grammarAccess.getDesignRule()) {
					sequence_Design(context, (Design) semanticObject); 
					return; 
				}
				else break;
			case PhdlPackage.DEVICE:
				if(context == grammarAccess.getDeviceRule()) {
					sequence_Device(context, (Device) semanticObject); 
					return; 
				}
				else break;
			case PhdlPackage.IMPORT:
				if(context == grammarAccess.getImportRule()) {
					sequence_Import(context, (Import) semanticObject); 
					return; 
				}
				else break;
			case PhdlPackage.INDICES:
				if(context == grammarAccess.getIndicesRule()) {
					sequence_Indices(context, (Indices) semanticObject); 
					return; 
				}
				else break;
			case PhdlPackage.INFO:
				if(context == grammarAccess.getDesignElementRule() ||
				   context == grammarAccess.getDeviceElementRule() ||
				   context == grammarAccess.getInfoRule() ||
				   context == grammarAccess.getInstanceElementRule() ||
				   context == grammarAccess.getNetElementRule() ||
				   context == grammarAccess.getPortElementRule() ||
				   context == grammarAccess.getSubInstanceElementRule()) {
					sequence_Info(context, (Info) semanticObject); 
					return; 
				}
				else break;
			case PhdlPackage.INSTANCE:
				if(context == grammarAccess.getDesignElementRule() ||
				   context == grammarAccess.getInstanceRule() ||
				   context == grammarAccess.getReferenceableRule()) {
					sequence_Instance(context, (Instance) semanticObject); 
					return; 
				}
				else break;
			case PhdlPackage.NEW_ATTR:
				if(context == grammarAccess.getInstanceElementRule() ||
				   context == grammarAccess.getNewAttrRule() ||
				   context == grammarAccess.getReferenceableRule()) {
					sequence_NewAttr(context, (NewAttr) semanticObject); 
					return; 
				}
				else break;
			case PhdlPackage.PACKAGE:
				if(context == grammarAccess.getPackageRule()) {
					sequence_Package(context, (edu.byu.ee.phdl.phdl.Package) semanticObject); 
					return; 
				}
				else break;
			case PhdlPackage.PHDL_MODEL:
				if(context == grammarAccess.getPhdlModelRule()) {
					sequence_PhdlModel(context, (PhdlModel) semanticObject); 
					return; 
				}
				else break;
			case PhdlPackage.PIN:
				if(context == grammarAccess.getDeviceElementRule() ||
				   context == grammarAccess.getPinRule()) {
					sequence_Pin(context, (Pin) semanticObject); 
					return; 
				}
				else break;
			case PhdlPackage.PIN_ASSIGN:
				if(context == grammarAccess.getAssignableRule() ||
				   context == grammarAccess.getInstanceElementRule() ||
				   context == grammarAccess.getPinAssignRule()) {
					sequence_PinAssign(context, (PinAssign) semanticObject); 
					return; 
				}
				else break;
			case PhdlPackage.PORT_ASSIGN:
				if(context == grammarAccess.getAssignableRule() ||
				   context == grammarAccess.getPortAssignRule() ||
				   context == grammarAccess.getSubInstanceElementRule()) {
					sequence_PortAssign(context, (PortAssign) semanticObject); 
					return; 
				}
				else break;
			case PhdlPackage.QUALIFIER:
				if(context == grammarAccess.getQualifierRule()) {
					sequence_Qualifier(context, (Qualifier) semanticObject); 
					return; 
				}
				else break;
			case PhdlPackage.REF_ATTR:
				if(context == grammarAccess.getInstanceElementRule() ||
				   context == grammarAccess.getRefAttrRule() ||
				   context == grammarAccess.getReferenceableRule()) {
					sequence_RefAttr(context, (RefAttr) semanticObject); 
					return; 
				}
				else break;
			case PhdlPackage.REF_TAIL:
				if(context == grammarAccess.getRefTailRule()) {
					sequence_RefTail(context, (RefTail) semanticObject); 
					return; 
				}
				else break;
			case PhdlPackage.SLICES:
				if(context == grammarAccess.getSlicesRule()) {
					sequence_Slices(context, (Slices) semanticObject); 
					return; 
				}
				else break;
			case PhdlPackage.SUB_ATTR:
				if(context == grammarAccess.getSubAttrRule() ||
				   context == grammarAccess.getSubInstanceElementRule()) {
					sequence_SubAttr(context, (SubAttr) semanticObject); 
					return; 
				}
				else break;
			case PhdlPackage.VECTOR:
				if(context == grammarAccess.getVectorRule()) {
					sequence_Vector(context, (Vector) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     ((msb=INT array?=':' lsb=INT)?)
	 */
	protected void sequence_Array(EObject context, Array semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID value=STRING)
	 */
	protected void sequence_Attr(EObject context, Attr semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, PhdlPackage.Literals.ATTR__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PhdlPackage.Literals.ATTR__NAME));
			if(transientValues.isValueTransient(semanticObject, PhdlPackage.Literals.ATTR__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PhdlPackage.Literals.ATTR__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAttrAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getAttrAccess().getValueSTRINGTerminalRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (connections+=ConnectionRef connections+=ConnectionRef*) | 
	 *         (connections+=ConnectionRef connections+=ConnectionRef*) | 
	 *         (replicated?='<' replicate=ConnectionRef) | 
	 *         (replicate=ConnectionRef replicated?='*') | 
	 *         open?='open'
	 *     )
	 */
	protected void sequence_Concatenation(EObject context, Concatenation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ref=[ConnectionName|PhdlID] slices=Slices? concatenation=Concatenation)
	 */
	protected void sequence_ConnectionAssign(EObject context, ConnectionAssign semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=PhdlID
	 */
	protected void sequence_ConnectionName(EObject context, ConnectionName semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, PhdlPackage.Literals.CONNECTION_NAME__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PhdlPackage.Literals.CONNECTION_NAME__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getConnectionNameAccess().getNamePhdlIDParserRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (ref=[ConnectionName|PhdlID] slices=Slices?)
	 */
	protected void sequence_ConnectionRef(EObject context, ConnectionRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (net?='net' vector=Vector names+=ConnectionName names+=ConnectionName* elements+=NetElement*) | 
	 *         (port?='port' vector=Vector names+=ConnectionName names+=ConnectionName* elements+=PortElement*)
	 *     )
	 */
	protected void sequence_Connection(EObject context, Connection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((design?='design' | subdesign?='subdesign') name=ID elements+=DesignElement*)
	 */
	protected void sequence_Design(EObject context, Design semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=PhdlID elements+=DeviceElement*)
	 */
	protected void sequence_Device(EObject context, Device semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     importedNamespace=QualifiedNameWithWildCard
	 */
	protected void sequence_Import(EObject context, Import semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, PhdlPackage.Literals.IMPORT__IMPORTED_NAMESPACE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PhdlPackage.Literals.IMPORT__IMPORTED_NAMESPACE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0(), semanticObject.getImportedNamespace());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ((msb=INT array?=':' lsb=INT) | (indices+=INT indices+=INT*))
	 */
	protected void sequence_Indices(EObject context, Indices semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     info=STRING
	 */
	protected void sequence_Info(EObject context, Info semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, PhdlPackage.Literals.INFO__INFO) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PhdlPackage.Literals.INFO__INFO));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getInfoAccess().getInfoSTRINGTerminalRuleCall_2_0(), semanticObject.getInfo());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (inst?='inst' array=Array name=ID device=[Device|QualifiedName] elements+=InstanceElement*) | 
	 *         (
	 *             subInst?='subinst' 
	 *             array=Array 
	 *             name=ID 
	 *             subDesign=[Design|QualifiedName] 
	 *             prefix=STRING? 
	 *             elements+=SubInstanceElement*
	 *         )
	 *     )
	 */
	protected void sequence_Instance(EObject context, Instance semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (qualifier=Qualifier? name=ID value=STRING)
	 */
	protected void sequence_NewAttr(EObject context, NewAttr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID imports+=Import* (devices+=Device | designs+=Design)*)
	 */
	protected void sequence_Package(EObject context, edu.byu.ee.phdl.phdl.Package semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (imports+=Import* (packages+=Package | devices+=Device | designs+=Design)*)
	 */
	protected void sequence_PhdlModel(EObject context, PhdlModel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         ((combined?='combine' qualifier=Qualifier? ref=[Pin|PhdlID] slices=Slices?) | (qualifier=Qualifier? ref=[Pin|PhdlID] slices=Slices?)) 
	 *         concatenation=Concatenation
	 *     )
	 */
	protected void sequence_PinAssign(EObject context, PinAssign semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=PinType vector=Vector name=PhdlID (pinNames+=PhdlID pinNames+=PhdlID*)?)
	 */
	protected void sequence_Pin(EObject context, Pin semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (
	 *             (combined?='combine' qualifier=Qualifier? ref=[ConnectionName|PhdlID] slices=Slices?) | 
	 *             (qualifier=Qualifier? ref=[ConnectionName|PhdlID] slices=Slices?)
	 *         ) 
	 *         concatenation=Concatenation
	 *     )
	 */
	protected void sequence_PortAssign(EObject context, PortAssign semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     indices=Indices
	 */
	protected void sequence_Qualifier(EObject context, Qualifier semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, PhdlPackage.Literals.QUALIFIER__INDICES) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PhdlPackage.Literals.QUALIFIER__INDICES));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getQualifierAccess().getIndicesIndicesParserRuleCall_1_0(), semanticObject.getIndices());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (qualifier=Qualifier? ref=[Attr|ID] value=STRING)
	 */
	protected void sequence_RefAttr(EObject context, RefAttr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ref=[Referenceable|ID] refIndices=Indices? tail=RefTail?)
	 */
	protected void sequence_RefTail(EObject context, RefTail semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((msb=INT vector?=':' lsb=INT) | (slices+=INT slices+=INT*))
	 */
	protected void sequence_Slices(EObject context, Slices semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (qualifier=Qualifier? ref=[Referenceable|ID] refIndices=Indices? tail=RefTail value=STRING)
	 */
	protected void sequence_SubAttr(EObject context, SubAttr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((msb=INT vector?=':' lsb=INT)?)
	 */
	protected void sequence_Vector(EObject context, Vector semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
