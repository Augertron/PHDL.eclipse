/**
 */
package edu.byu.ee.phdl.phdl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.byu.ee.phdl.phdl.PhdlFactory
 * @model kind="package"
 * @generated
 */
public interface PhdlPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "phdl";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://phdl.sf.net";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "phdl";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  PhdlPackage eINSTANCE = edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl.init();

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.PhdlModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.PhdlModelImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getPhdlModel()
   * @generated
   */
  int PHDL_MODEL = 0;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHDL_MODEL__IMPORTS = 0;

  /**
   * The feature id for the '<em><b>Packages</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHDL_MODEL__PACKAGES = 1;

  /**
   * The feature id for the '<em><b>Devices</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHDL_MODEL__DEVICES = 2;

  /**
   * The feature id for the '<em><b>Designs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHDL_MODEL__DESIGNS = 3;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHDL_MODEL_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.PackageImpl <em>Package</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.PackageImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getPackage()
   * @generated
   */
  int PACKAGE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE__NAME = 0;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE__IMPORTS = 1;

  /**
   * The feature id for the '<em><b>Devices</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE__DEVICES = 2;

  /**
   * The feature id for the '<em><b>Designs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE__DESIGNS = 3;

  /**
   * The number of structural features of the '<em>Package</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.ImportImpl <em>Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.ImportImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getImport()
   * @generated
   */
  int IMPORT = 2;

  /**
   * The feature id for the '<em><b>Imported Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT__IMPORTED_NAMESPACE = 0;

  /**
   * The number of structural features of the '<em>Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.DeviceImpl <em>Device</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.DeviceImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getDevice()
   * @generated
   */
  int DEVICE = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEVICE__NAME = 0;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEVICE__ELEMENTS = 1;

  /**
   * The number of structural features of the '<em>Device</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEVICE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.DeviceElementImpl <em>Device Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.DeviceElementImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getDeviceElement()
   * @generated
   */
  int DEVICE_ELEMENT = 4;

  /**
   * The number of structural features of the '<em>Device Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEVICE_ELEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.AttrImpl <em>Attr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.AttrImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getAttr()
   * @generated
   */
  int ATTR = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR__NAME = DEVICE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR__VALUE = DEVICE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Attr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_FEATURE_COUNT = DEVICE_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.PinImpl <em>Pin</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.PinImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getPin()
   * @generated
   */
  int PIN = 6;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PIN__TYPE = DEVICE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Vector</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PIN__VECTOR = DEVICE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PIN__NAME = DEVICE_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Pin Names</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PIN__PIN_NAMES = DEVICE_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Pin</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PIN_FEATURE_COUNT = DEVICE_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.InfoImpl <em>Info</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.InfoImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getInfo()
   * @generated
   */
  int INFO = 7;

  /**
   * The feature id for the '<em><b>Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFO__INFO = DEVICE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Info</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFO_FEATURE_COUNT = DEVICE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.DesignImpl <em>Design</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.DesignImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getDesign()
   * @generated
   */
  int DESIGN = 8;

  /**
   * The feature id for the '<em><b>Design</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESIGN__DESIGN = 0;

  /**
   * The feature id for the '<em><b>Subdesign</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESIGN__SUBDESIGN = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESIGN__NAME = 2;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESIGN__ELEMENTS = 3;

  /**
   * The number of structural features of the '<em>Design</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESIGN_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.DesignElementImpl <em>Design Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.DesignElementImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getDesignElement()
   * @generated
   */
  int DESIGN_ELEMENT = 9;

  /**
   * The number of structural features of the '<em>Design Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESIGN_ELEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.ConnectionImpl <em>Connection</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.ConnectionImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getConnection()
   * @generated
   */
  int CONNECTION = 10;

  /**
   * The feature id for the '<em><b>Net</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION__NET = DESIGN_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Vector</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION__VECTOR = DESIGN_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Names</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION__NAMES = DESIGN_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION__ELEMENTS = DESIGN_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Port</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION__PORT = DESIGN_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Connection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_FEATURE_COUNT = DESIGN_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.NetElementImpl <em>Net Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.NetElementImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getNetElement()
   * @generated
   */
  int NET_ELEMENT = 11;

  /**
   * The number of structural features of the '<em>Net Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NET_ELEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.PortElementImpl <em>Port Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.PortElementImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getPortElement()
   * @generated
   */
  int PORT_ELEMENT = 12;

  /**
   * The number of structural features of the '<em>Port Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_ELEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.InstanceImpl <em>Instance</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.InstanceImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getInstance()
   * @generated
   */
  int INSTANCE = 13;

  /**
   * The feature id for the '<em><b>Inst</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE__INST = DESIGN_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Array</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE__ARRAY = DESIGN_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE__NAME = DESIGN_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Device</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE__DEVICE = DESIGN_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE__ELEMENTS = DESIGN_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Sub Inst</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE__SUB_INST = DESIGN_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Sub Design</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE__SUB_DESIGN = DESIGN_ELEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Prefix</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE__PREFIX = DESIGN_ELEMENT_FEATURE_COUNT + 7;

  /**
   * The number of structural features of the '<em>Instance</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_FEATURE_COUNT = DESIGN_ELEMENT_FEATURE_COUNT + 8;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.InstanceElementImpl <em>Instance Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.InstanceElementImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getInstanceElement()
   * @generated
   */
  int INSTANCE_ELEMENT = 14;

  /**
   * The number of structural features of the '<em>Instance Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_ELEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.SubInstanceElementImpl <em>Sub Instance Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.SubInstanceElementImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getSubInstanceElement()
   * @generated
   */
  int SUB_INSTANCE_ELEMENT = 15;

  /**
   * The number of structural features of the '<em>Sub Instance Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_INSTANCE_ELEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.RefAttrImpl <em>Ref Attr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.RefAttrImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getRefAttr()
   * @generated
   */
  int REF_ATTR = 16;

  /**
   * The feature id for the '<em><b>Qualifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF_ATTR__QUALIFIER = INSTANCE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF_ATTR__REF = INSTANCE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF_ATTR__VALUE = INSTANCE_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Ref Attr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF_ATTR_FEATURE_COUNT = INSTANCE_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.NewAttrImpl <em>New Attr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.NewAttrImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getNewAttr()
   * @generated
   */
  int NEW_ATTR = 17;

  /**
   * The feature id for the '<em><b>Qualifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEW_ATTR__QUALIFIER = INSTANCE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEW_ATTR__NAME = INSTANCE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEW_ATTR__VALUE = INSTANCE_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>New Attr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEW_ATTR_FEATURE_COUNT = INSTANCE_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.PinAssignImpl <em>Pin Assign</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.PinAssignImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getPinAssign()
   * @generated
   */
  int PIN_ASSIGN = 18;

  /**
   * The feature id for the '<em><b>Slices</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PIN_ASSIGN__SLICES = INSTANCE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Concatenation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PIN_ASSIGN__CONCATENATION = INSTANCE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Combined</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PIN_ASSIGN__COMBINED = INSTANCE_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Qualifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PIN_ASSIGN__QUALIFIER = INSTANCE_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PIN_ASSIGN__REF = INSTANCE_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Pin Assign</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PIN_ASSIGN_FEATURE_COUNT = INSTANCE_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.SubAttrImpl <em>Sub Attr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.SubAttrImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getSubAttr()
   * @generated
   */
  int SUB_ATTR = 19;

  /**
   * The feature id for the '<em><b>Qualifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_ATTR__QUALIFIER = SUB_INSTANCE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_ATTR__REF = SUB_INSTANCE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Ref Indices</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_ATTR__REF_INDICES = SUB_INSTANCE_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Tail</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_ATTR__TAIL = SUB_INSTANCE_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_ATTR__VALUE = SUB_INSTANCE_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Sub Attr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_ATTR_FEATURE_COUNT = SUB_INSTANCE_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.RefTailImpl <em>Ref Tail</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.RefTailImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getRefTail()
   * @generated
   */
  int REF_TAIL = 20;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF_TAIL__REF = 0;

  /**
   * The feature id for the '<em><b>Ref Indices</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF_TAIL__REF_INDICES = 1;

  /**
   * The feature id for the '<em><b>Tail</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF_TAIL__TAIL = 2;

  /**
   * The number of structural features of the '<em>Ref Tail</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF_TAIL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.PortAssignImpl <em>Port Assign</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.PortAssignImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getPortAssign()
   * @generated
   */
  int PORT_ASSIGN = 21;

  /**
   * The feature id for the '<em><b>Slices</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_ASSIGN__SLICES = SUB_INSTANCE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Concatenation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_ASSIGN__CONCATENATION = SUB_INSTANCE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Combined</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_ASSIGN__COMBINED = SUB_INSTANCE_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Qualifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_ASSIGN__QUALIFIER = SUB_INSTANCE_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_ASSIGN__REF = SUB_INSTANCE_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Port Assign</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_ASSIGN_FEATURE_COUNT = SUB_INSTANCE_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.ConnectionAssignImpl <em>Connection Assign</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.ConnectionAssignImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getConnectionAssign()
   * @generated
   */
  int CONNECTION_ASSIGN = 22;

  /**
   * The feature id for the '<em><b>Slices</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_ASSIGN__SLICES = DESIGN_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Concatenation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_ASSIGN__CONCATENATION = DESIGN_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_ASSIGN__REF = DESIGN_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Connection Assign</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_ASSIGN_FEATURE_COUNT = DESIGN_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.ConcatenationImpl <em>Concatenation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.ConcatenationImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getConcatenation()
   * @generated
   */
  int CONCATENATION = 23;

  /**
   * The feature id for the '<em><b>Connections</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCATENATION__CONNECTIONS = 0;

  /**
   * The feature id for the '<em><b>Replicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCATENATION__REPLICATED = 1;

  /**
   * The feature id for the '<em><b>Replicate</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCATENATION__REPLICATE = 2;

  /**
   * The feature id for the '<em><b>Open</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCATENATION__OPEN = 3;

  /**
   * The number of structural features of the '<em>Concatenation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCATENATION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.ConnectionRefImpl <em>Connection Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.ConnectionRefImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getConnectionRef()
   * @generated
   */
  int CONNECTION_REF = 24;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_REF__REF = 0;

  /**
   * The feature id for the '<em><b>Slices</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_REF__SLICES = 1;

  /**
   * The number of structural features of the '<em>Connection Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_REF_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.ConnectionNameImpl <em>Connection Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.ConnectionNameImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getConnectionName()
   * @generated
   */
  int CONNECTION_NAME = 25;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_NAME__NAME = 0;

  /**
   * The number of structural features of the '<em>Connection Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_NAME_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.IndicesImpl <em>Indices</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.IndicesImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getIndices()
   * @generated
   */
  int INDICES = 26;

  /**
   * The feature id for the '<em><b>Msb</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDICES__MSB = 0;

  /**
   * The feature id for the '<em><b>Array</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDICES__ARRAY = 1;

  /**
   * The feature id for the '<em><b>Lsb</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDICES__LSB = 2;

  /**
   * The feature id for the '<em><b>Indices</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDICES__INDICES = 3;

  /**
   * The number of structural features of the '<em>Indices</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDICES_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.SlicesImpl <em>Slices</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.SlicesImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getSlices()
   * @generated
   */
  int SLICES = 27;

  /**
   * The feature id for the '<em><b>Msb</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLICES__MSB = 0;

  /**
   * The feature id for the '<em><b>Vector</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLICES__VECTOR = 1;

  /**
   * The feature id for the '<em><b>Lsb</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLICES__LSB = 2;

  /**
   * The feature id for the '<em><b>Slices</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLICES__SLICES = 3;

  /**
   * The number of structural features of the '<em>Slices</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLICES_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.VectorImpl <em>Vector</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.VectorImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getVector()
   * @generated
   */
  int VECTOR = 28;

  /**
   * The feature id for the '<em><b>Msb</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VECTOR__MSB = 0;

  /**
   * The feature id for the '<em><b>Vector</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VECTOR__VECTOR = 1;

  /**
   * The feature id for the '<em><b>Lsb</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VECTOR__LSB = 2;

  /**
   * The number of structural features of the '<em>Vector</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VECTOR_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.ArrayImpl <em>Array</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.ArrayImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getArray()
   * @generated
   */
  int ARRAY = 29;

  /**
   * The feature id for the '<em><b>Msb</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY__MSB = 0;

  /**
   * The feature id for the '<em><b>Array</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY__ARRAY = 1;

  /**
   * The feature id for the '<em><b>Lsb</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY__LSB = 2;

  /**
   * The number of structural features of the '<em>Array</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.QualifierImpl <em>Qualifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.QualifierImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getQualifier()
   * @generated
   */
  int QUALIFIER = 30;

  /**
   * The feature id for the '<em><b>Indices</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIER__INDICES = 0;

  /**
   * The number of structural features of the '<em>Qualifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.ReferenceableImpl <em>Referenceable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.ReferenceableImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getReferenceable()
   * @generated
   */
  int REFERENCEABLE = 31;

  /**
   * The number of structural features of the '<em>Referenceable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCEABLE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.impl.AssignableImpl <em>Assignable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.impl.AssignableImpl
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getAssignable()
   * @generated
   */
  int ASSIGNABLE = 32;

  /**
   * The feature id for the '<em><b>Slices</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNABLE__SLICES = 0;

  /**
   * The feature id for the '<em><b>Concatenation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNABLE__CONCATENATION = 1;

  /**
   * The number of structural features of the '<em>Assignable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNABLE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link edu.byu.ee.phdl.phdl.PinType <em>Pin Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.byu.ee.phdl.phdl.PinType
   * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getPinType()
   * @generated
   */
  int PIN_TYPE = 33;


  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.PhdlModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see edu.byu.ee.phdl.phdl.PhdlModel
   * @generated
   */
  EClass getPhdlModel();

  /**
   * Returns the meta object for the containment reference list '{@link edu.byu.ee.phdl.phdl.PhdlModel#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see edu.byu.ee.phdl.phdl.PhdlModel#getImports()
   * @see #getPhdlModel()
   * @generated
   */
  EReference getPhdlModel_Imports();

  /**
   * Returns the meta object for the containment reference list '{@link edu.byu.ee.phdl.phdl.PhdlModel#getPackages <em>Packages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Packages</em>'.
   * @see edu.byu.ee.phdl.phdl.PhdlModel#getPackages()
   * @see #getPhdlModel()
   * @generated
   */
  EReference getPhdlModel_Packages();

  /**
   * Returns the meta object for the containment reference list '{@link edu.byu.ee.phdl.phdl.PhdlModel#getDevices <em>Devices</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Devices</em>'.
   * @see edu.byu.ee.phdl.phdl.PhdlModel#getDevices()
   * @see #getPhdlModel()
   * @generated
   */
  EReference getPhdlModel_Devices();

  /**
   * Returns the meta object for the containment reference list '{@link edu.byu.ee.phdl.phdl.PhdlModel#getDesigns <em>Designs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Designs</em>'.
   * @see edu.byu.ee.phdl.phdl.PhdlModel#getDesigns()
   * @see #getPhdlModel()
   * @generated
   */
  EReference getPhdlModel_Designs();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.Package <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Package</em>'.
   * @see edu.byu.ee.phdl.phdl.Package
   * @generated
   */
  EClass getPackage();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Package#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.byu.ee.phdl.phdl.Package#getName()
   * @see #getPackage()
   * @generated
   */
  EAttribute getPackage_Name();

  /**
   * Returns the meta object for the containment reference list '{@link edu.byu.ee.phdl.phdl.Package#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see edu.byu.ee.phdl.phdl.Package#getImports()
   * @see #getPackage()
   * @generated
   */
  EReference getPackage_Imports();

  /**
   * Returns the meta object for the containment reference list '{@link edu.byu.ee.phdl.phdl.Package#getDevices <em>Devices</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Devices</em>'.
   * @see edu.byu.ee.phdl.phdl.Package#getDevices()
   * @see #getPackage()
   * @generated
   */
  EReference getPackage_Devices();

  /**
   * Returns the meta object for the containment reference list '{@link edu.byu.ee.phdl.phdl.Package#getDesigns <em>Designs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Designs</em>'.
   * @see edu.byu.ee.phdl.phdl.Package#getDesigns()
   * @see #getPackage()
   * @generated
   */
  EReference getPackage_Designs();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import</em>'.
   * @see edu.byu.ee.phdl.phdl.Import
   * @generated
   */
  EClass getImport();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Import#getImportedNamespace <em>Imported Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imported Namespace</em>'.
   * @see edu.byu.ee.phdl.phdl.Import#getImportedNamespace()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_ImportedNamespace();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.Device <em>Device</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Device</em>'.
   * @see edu.byu.ee.phdl.phdl.Device
   * @generated
   */
  EClass getDevice();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Device#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.byu.ee.phdl.phdl.Device#getName()
   * @see #getDevice()
   * @generated
   */
  EAttribute getDevice_Name();

  /**
   * Returns the meta object for the containment reference list '{@link edu.byu.ee.phdl.phdl.Device#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see edu.byu.ee.phdl.phdl.Device#getElements()
   * @see #getDevice()
   * @generated
   */
  EReference getDevice_Elements();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.DeviceElement <em>Device Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Device Element</em>'.
   * @see edu.byu.ee.phdl.phdl.DeviceElement
   * @generated
   */
  EClass getDeviceElement();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.Attr <em>Attr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attr</em>'.
   * @see edu.byu.ee.phdl.phdl.Attr
   * @generated
   */
  EClass getAttr();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Attr#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.byu.ee.phdl.phdl.Attr#getName()
   * @see #getAttr()
   * @generated
   */
  EAttribute getAttr_Name();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Attr#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see edu.byu.ee.phdl.phdl.Attr#getValue()
   * @see #getAttr()
   * @generated
   */
  EAttribute getAttr_Value();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.Pin <em>Pin</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pin</em>'.
   * @see edu.byu.ee.phdl.phdl.Pin
   * @generated
   */
  EClass getPin();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Pin#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see edu.byu.ee.phdl.phdl.Pin#getType()
   * @see #getPin()
   * @generated
   */
  EAttribute getPin_Type();

  /**
   * Returns the meta object for the containment reference '{@link edu.byu.ee.phdl.phdl.Pin#getVector <em>Vector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Vector</em>'.
   * @see edu.byu.ee.phdl.phdl.Pin#getVector()
   * @see #getPin()
   * @generated
   */
  EReference getPin_Vector();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Pin#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.byu.ee.phdl.phdl.Pin#getName()
   * @see #getPin()
   * @generated
   */
  EAttribute getPin_Name();

  /**
   * Returns the meta object for the attribute list '{@link edu.byu.ee.phdl.phdl.Pin#getPinNames <em>Pin Names</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Pin Names</em>'.
   * @see edu.byu.ee.phdl.phdl.Pin#getPinNames()
   * @see #getPin()
   * @generated
   */
  EAttribute getPin_PinNames();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.Info <em>Info</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Info</em>'.
   * @see edu.byu.ee.phdl.phdl.Info
   * @generated
   */
  EClass getInfo();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Info#getInfo <em>Info</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Info</em>'.
   * @see edu.byu.ee.phdl.phdl.Info#getInfo()
   * @see #getInfo()
   * @generated
   */
  EAttribute getInfo_Info();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.Design <em>Design</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Design</em>'.
   * @see edu.byu.ee.phdl.phdl.Design
   * @generated
   */
  EClass getDesign();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Design#isDesign <em>Design</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Design</em>'.
   * @see edu.byu.ee.phdl.phdl.Design#isDesign()
   * @see #getDesign()
   * @generated
   */
  EAttribute getDesign_Design();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Design#isSubdesign <em>Subdesign</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Subdesign</em>'.
   * @see edu.byu.ee.phdl.phdl.Design#isSubdesign()
   * @see #getDesign()
   * @generated
   */
  EAttribute getDesign_Subdesign();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Design#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.byu.ee.phdl.phdl.Design#getName()
   * @see #getDesign()
   * @generated
   */
  EAttribute getDesign_Name();

  /**
   * Returns the meta object for the containment reference list '{@link edu.byu.ee.phdl.phdl.Design#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see edu.byu.ee.phdl.phdl.Design#getElements()
   * @see #getDesign()
   * @generated
   */
  EReference getDesign_Elements();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.DesignElement <em>Design Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Design Element</em>'.
   * @see edu.byu.ee.phdl.phdl.DesignElement
   * @generated
   */
  EClass getDesignElement();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.Connection <em>Connection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Connection</em>'.
   * @see edu.byu.ee.phdl.phdl.Connection
   * @generated
   */
  EClass getConnection();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Connection#isNet <em>Net</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Net</em>'.
   * @see edu.byu.ee.phdl.phdl.Connection#isNet()
   * @see #getConnection()
   * @generated
   */
  EAttribute getConnection_Net();

  /**
   * Returns the meta object for the containment reference '{@link edu.byu.ee.phdl.phdl.Connection#getVector <em>Vector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Vector</em>'.
   * @see edu.byu.ee.phdl.phdl.Connection#getVector()
   * @see #getConnection()
   * @generated
   */
  EReference getConnection_Vector();

  /**
   * Returns the meta object for the containment reference list '{@link edu.byu.ee.phdl.phdl.Connection#getNames <em>Names</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Names</em>'.
   * @see edu.byu.ee.phdl.phdl.Connection#getNames()
   * @see #getConnection()
   * @generated
   */
  EReference getConnection_Names();

  /**
   * Returns the meta object for the containment reference list '{@link edu.byu.ee.phdl.phdl.Connection#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see edu.byu.ee.phdl.phdl.Connection#getElements()
   * @see #getConnection()
   * @generated
   */
  EReference getConnection_Elements();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Connection#isPort <em>Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Port</em>'.
   * @see edu.byu.ee.phdl.phdl.Connection#isPort()
   * @see #getConnection()
   * @generated
   */
  EAttribute getConnection_Port();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.NetElement <em>Net Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Net Element</em>'.
   * @see edu.byu.ee.phdl.phdl.NetElement
   * @generated
   */
  EClass getNetElement();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.PortElement <em>Port Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Port Element</em>'.
   * @see edu.byu.ee.phdl.phdl.PortElement
   * @generated
   */
  EClass getPortElement();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.Instance <em>Instance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Instance</em>'.
   * @see edu.byu.ee.phdl.phdl.Instance
   * @generated
   */
  EClass getInstance();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Instance#isInst <em>Inst</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Inst</em>'.
   * @see edu.byu.ee.phdl.phdl.Instance#isInst()
   * @see #getInstance()
   * @generated
   */
  EAttribute getInstance_Inst();

  /**
   * Returns the meta object for the containment reference '{@link edu.byu.ee.phdl.phdl.Instance#getArray <em>Array</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Array</em>'.
   * @see edu.byu.ee.phdl.phdl.Instance#getArray()
   * @see #getInstance()
   * @generated
   */
  EReference getInstance_Array();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Instance#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.byu.ee.phdl.phdl.Instance#getName()
   * @see #getInstance()
   * @generated
   */
  EAttribute getInstance_Name();

  /**
   * Returns the meta object for the reference '{@link edu.byu.ee.phdl.phdl.Instance#getDevice <em>Device</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Device</em>'.
   * @see edu.byu.ee.phdl.phdl.Instance#getDevice()
   * @see #getInstance()
   * @generated
   */
  EReference getInstance_Device();

  /**
   * Returns the meta object for the containment reference list '{@link edu.byu.ee.phdl.phdl.Instance#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see edu.byu.ee.phdl.phdl.Instance#getElements()
   * @see #getInstance()
   * @generated
   */
  EReference getInstance_Elements();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Instance#isSubInst <em>Sub Inst</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Sub Inst</em>'.
   * @see edu.byu.ee.phdl.phdl.Instance#isSubInst()
   * @see #getInstance()
   * @generated
   */
  EAttribute getInstance_SubInst();

  /**
   * Returns the meta object for the reference '{@link edu.byu.ee.phdl.phdl.Instance#getSubDesign <em>Sub Design</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Sub Design</em>'.
   * @see edu.byu.ee.phdl.phdl.Instance#getSubDesign()
   * @see #getInstance()
   * @generated
   */
  EReference getInstance_SubDesign();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Instance#getPrefix <em>Prefix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Prefix</em>'.
   * @see edu.byu.ee.phdl.phdl.Instance#getPrefix()
   * @see #getInstance()
   * @generated
   */
  EAttribute getInstance_Prefix();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.InstanceElement <em>Instance Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Instance Element</em>'.
   * @see edu.byu.ee.phdl.phdl.InstanceElement
   * @generated
   */
  EClass getInstanceElement();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.SubInstanceElement <em>Sub Instance Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sub Instance Element</em>'.
   * @see edu.byu.ee.phdl.phdl.SubInstanceElement
   * @generated
   */
  EClass getSubInstanceElement();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.RefAttr <em>Ref Attr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ref Attr</em>'.
   * @see edu.byu.ee.phdl.phdl.RefAttr
   * @generated
   */
  EClass getRefAttr();

  /**
   * Returns the meta object for the containment reference '{@link edu.byu.ee.phdl.phdl.RefAttr#getQualifier <em>Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Qualifier</em>'.
   * @see edu.byu.ee.phdl.phdl.RefAttr#getQualifier()
   * @see #getRefAttr()
   * @generated
   */
  EReference getRefAttr_Qualifier();

  /**
   * Returns the meta object for the reference '{@link edu.byu.ee.phdl.phdl.RefAttr#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see edu.byu.ee.phdl.phdl.RefAttr#getRef()
   * @see #getRefAttr()
   * @generated
   */
  EReference getRefAttr_Ref();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.RefAttr#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see edu.byu.ee.phdl.phdl.RefAttr#getValue()
   * @see #getRefAttr()
   * @generated
   */
  EAttribute getRefAttr_Value();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.NewAttr <em>New Attr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>New Attr</em>'.
   * @see edu.byu.ee.phdl.phdl.NewAttr
   * @generated
   */
  EClass getNewAttr();

  /**
   * Returns the meta object for the containment reference '{@link edu.byu.ee.phdl.phdl.NewAttr#getQualifier <em>Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Qualifier</em>'.
   * @see edu.byu.ee.phdl.phdl.NewAttr#getQualifier()
   * @see #getNewAttr()
   * @generated
   */
  EReference getNewAttr_Qualifier();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.NewAttr#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.byu.ee.phdl.phdl.NewAttr#getName()
   * @see #getNewAttr()
   * @generated
   */
  EAttribute getNewAttr_Name();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.NewAttr#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see edu.byu.ee.phdl.phdl.NewAttr#getValue()
   * @see #getNewAttr()
   * @generated
   */
  EAttribute getNewAttr_Value();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.PinAssign <em>Pin Assign</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pin Assign</em>'.
   * @see edu.byu.ee.phdl.phdl.PinAssign
   * @generated
   */
  EClass getPinAssign();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.PinAssign#isCombined <em>Combined</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Combined</em>'.
   * @see edu.byu.ee.phdl.phdl.PinAssign#isCombined()
   * @see #getPinAssign()
   * @generated
   */
  EAttribute getPinAssign_Combined();

  /**
   * Returns the meta object for the containment reference '{@link edu.byu.ee.phdl.phdl.PinAssign#getQualifier <em>Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Qualifier</em>'.
   * @see edu.byu.ee.phdl.phdl.PinAssign#getQualifier()
   * @see #getPinAssign()
   * @generated
   */
  EReference getPinAssign_Qualifier();

  /**
   * Returns the meta object for the reference '{@link edu.byu.ee.phdl.phdl.PinAssign#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see edu.byu.ee.phdl.phdl.PinAssign#getRef()
   * @see #getPinAssign()
   * @generated
   */
  EReference getPinAssign_Ref();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.SubAttr <em>Sub Attr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sub Attr</em>'.
   * @see edu.byu.ee.phdl.phdl.SubAttr
   * @generated
   */
  EClass getSubAttr();

  /**
   * Returns the meta object for the containment reference '{@link edu.byu.ee.phdl.phdl.SubAttr#getQualifier <em>Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Qualifier</em>'.
   * @see edu.byu.ee.phdl.phdl.SubAttr#getQualifier()
   * @see #getSubAttr()
   * @generated
   */
  EReference getSubAttr_Qualifier();

  /**
   * Returns the meta object for the reference '{@link edu.byu.ee.phdl.phdl.SubAttr#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see edu.byu.ee.phdl.phdl.SubAttr#getRef()
   * @see #getSubAttr()
   * @generated
   */
  EReference getSubAttr_Ref();

  /**
   * Returns the meta object for the containment reference '{@link edu.byu.ee.phdl.phdl.SubAttr#getRefIndices <em>Ref Indices</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ref Indices</em>'.
   * @see edu.byu.ee.phdl.phdl.SubAttr#getRefIndices()
   * @see #getSubAttr()
   * @generated
   */
  EReference getSubAttr_RefIndices();

  /**
   * Returns the meta object for the containment reference '{@link edu.byu.ee.phdl.phdl.SubAttr#getTail <em>Tail</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Tail</em>'.
   * @see edu.byu.ee.phdl.phdl.SubAttr#getTail()
   * @see #getSubAttr()
   * @generated
   */
  EReference getSubAttr_Tail();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.SubAttr#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see edu.byu.ee.phdl.phdl.SubAttr#getValue()
   * @see #getSubAttr()
   * @generated
   */
  EAttribute getSubAttr_Value();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.RefTail <em>Ref Tail</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ref Tail</em>'.
   * @see edu.byu.ee.phdl.phdl.RefTail
   * @generated
   */
  EClass getRefTail();

  /**
   * Returns the meta object for the reference '{@link edu.byu.ee.phdl.phdl.RefTail#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see edu.byu.ee.phdl.phdl.RefTail#getRef()
   * @see #getRefTail()
   * @generated
   */
  EReference getRefTail_Ref();

  /**
   * Returns the meta object for the containment reference '{@link edu.byu.ee.phdl.phdl.RefTail#getRefIndices <em>Ref Indices</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ref Indices</em>'.
   * @see edu.byu.ee.phdl.phdl.RefTail#getRefIndices()
   * @see #getRefTail()
   * @generated
   */
  EReference getRefTail_RefIndices();

  /**
   * Returns the meta object for the containment reference '{@link edu.byu.ee.phdl.phdl.RefTail#getTail <em>Tail</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Tail</em>'.
   * @see edu.byu.ee.phdl.phdl.RefTail#getTail()
   * @see #getRefTail()
   * @generated
   */
  EReference getRefTail_Tail();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.PortAssign <em>Port Assign</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Port Assign</em>'.
   * @see edu.byu.ee.phdl.phdl.PortAssign
   * @generated
   */
  EClass getPortAssign();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.PortAssign#isCombined <em>Combined</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Combined</em>'.
   * @see edu.byu.ee.phdl.phdl.PortAssign#isCombined()
   * @see #getPortAssign()
   * @generated
   */
  EAttribute getPortAssign_Combined();

  /**
   * Returns the meta object for the containment reference '{@link edu.byu.ee.phdl.phdl.PortAssign#getQualifier <em>Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Qualifier</em>'.
   * @see edu.byu.ee.phdl.phdl.PortAssign#getQualifier()
   * @see #getPortAssign()
   * @generated
   */
  EReference getPortAssign_Qualifier();

  /**
   * Returns the meta object for the reference '{@link edu.byu.ee.phdl.phdl.PortAssign#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see edu.byu.ee.phdl.phdl.PortAssign#getRef()
   * @see #getPortAssign()
   * @generated
   */
  EReference getPortAssign_Ref();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.ConnectionAssign <em>Connection Assign</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Connection Assign</em>'.
   * @see edu.byu.ee.phdl.phdl.ConnectionAssign
   * @generated
   */
  EClass getConnectionAssign();

  /**
   * Returns the meta object for the reference '{@link edu.byu.ee.phdl.phdl.ConnectionAssign#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see edu.byu.ee.phdl.phdl.ConnectionAssign#getRef()
   * @see #getConnectionAssign()
   * @generated
   */
  EReference getConnectionAssign_Ref();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.Concatenation <em>Concatenation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Concatenation</em>'.
   * @see edu.byu.ee.phdl.phdl.Concatenation
   * @generated
   */
  EClass getConcatenation();

  /**
   * Returns the meta object for the containment reference list '{@link edu.byu.ee.phdl.phdl.Concatenation#getConnections <em>Connections</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Connections</em>'.
   * @see edu.byu.ee.phdl.phdl.Concatenation#getConnections()
   * @see #getConcatenation()
   * @generated
   */
  EReference getConcatenation_Connections();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Concatenation#isReplicated <em>Replicated</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Replicated</em>'.
   * @see edu.byu.ee.phdl.phdl.Concatenation#isReplicated()
   * @see #getConcatenation()
   * @generated
   */
  EAttribute getConcatenation_Replicated();

  /**
   * Returns the meta object for the containment reference '{@link edu.byu.ee.phdl.phdl.Concatenation#getReplicate <em>Replicate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Replicate</em>'.
   * @see edu.byu.ee.phdl.phdl.Concatenation#getReplicate()
   * @see #getConcatenation()
   * @generated
   */
  EReference getConcatenation_Replicate();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Concatenation#isOpen <em>Open</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Open</em>'.
   * @see edu.byu.ee.phdl.phdl.Concatenation#isOpen()
   * @see #getConcatenation()
   * @generated
   */
  EAttribute getConcatenation_Open();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.ConnectionRef <em>Connection Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Connection Ref</em>'.
   * @see edu.byu.ee.phdl.phdl.ConnectionRef
   * @generated
   */
  EClass getConnectionRef();

  /**
   * Returns the meta object for the reference '{@link edu.byu.ee.phdl.phdl.ConnectionRef#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see edu.byu.ee.phdl.phdl.ConnectionRef#getRef()
   * @see #getConnectionRef()
   * @generated
   */
  EReference getConnectionRef_Ref();

  /**
   * Returns the meta object for the containment reference '{@link edu.byu.ee.phdl.phdl.ConnectionRef#getSlices <em>Slices</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Slices</em>'.
   * @see edu.byu.ee.phdl.phdl.ConnectionRef#getSlices()
   * @see #getConnectionRef()
   * @generated
   */
  EReference getConnectionRef_Slices();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.ConnectionName <em>Connection Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Connection Name</em>'.
   * @see edu.byu.ee.phdl.phdl.ConnectionName
   * @generated
   */
  EClass getConnectionName();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.ConnectionName#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.byu.ee.phdl.phdl.ConnectionName#getName()
   * @see #getConnectionName()
   * @generated
   */
  EAttribute getConnectionName_Name();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.Indices <em>Indices</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Indices</em>'.
   * @see edu.byu.ee.phdl.phdl.Indices
   * @generated
   */
  EClass getIndices();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Indices#getMsb <em>Msb</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Msb</em>'.
   * @see edu.byu.ee.phdl.phdl.Indices#getMsb()
   * @see #getIndices()
   * @generated
   */
  EAttribute getIndices_Msb();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Indices#isArray <em>Array</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Array</em>'.
   * @see edu.byu.ee.phdl.phdl.Indices#isArray()
   * @see #getIndices()
   * @generated
   */
  EAttribute getIndices_Array();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Indices#getLsb <em>Lsb</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lsb</em>'.
   * @see edu.byu.ee.phdl.phdl.Indices#getLsb()
   * @see #getIndices()
   * @generated
   */
  EAttribute getIndices_Lsb();

  /**
   * Returns the meta object for the attribute list '{@link edu.byu.ee.phdl.phdl.Indices#getIndices <em>Indices</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Indices</em>'.
   * @see edu.byu.ee.phdl.phdl.Indices#getIndices()
   * @see #getIndices()
   * @generated
   */
  EAttribute getIndices_Indices();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.Slices <em>Slices</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Slices</em>'.
   * @see edu.byu.ee.phdl.phdl.Slices
   * @generated
   */
  EClass getSlices();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Slices#getMsb <em>Msb</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Msb</em>'.
   * @see edu.byu.ee.phdl.phdl.Slices#getMsb()
   * @see #getSlices()
   * @generated
   */
  EAttribute getSlices_Msb();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Slices#isVector <em>Vector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Vector</em>'.
   * @see edu.byu.ee.phdl.phdl.Slices#isVector()
   * @see #getSlices()
   * @generated
   */
  EAttribute getSlices_Vector();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Slices#getLsb <em>Lsb</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lsb</em>'.
   * @see edu.byu.ee.phdl.phdl.Slices#getLsb()
   * @see #getSlices()
   * @generated
   */
  EAttribute getSlices_Lsb();

  /**
   * Returns the meta object for the attribute list '{@link edu.byu.ee.phdl.phdl.Slices#getSlices <em>Slices</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Slices</em>'.
   * @see edu.byu.ee.phdl.phdl.Slices#getSlices()
   * @see #getSlices()
   * @generated
   */
  EAttribute getSlices_Slices();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.Vector <em>Vector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Vector</em>'.
   * @see edu.byu.ee.phdl.phdl.Vector
   * @generated
   */
  EClass getVector();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Vector#getMsb <em>Msb</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Msb</em>'.
   * @see edu.byu.ee.phdl.phdl.Vector#getMsb()
   * @see #getVector()
   * @generated
   */
  EAttribute getVector_Msb();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Vector#isVector <em>Vector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Vector</em>'.
   * @see edu.byu.ee.phdl.phdl.Vector#isVector()
   * @see #getVector()
   * @generated
   */
  EAttribute getVector_Vector();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Vector#getLsb <em>Lsb</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lsb</em>'.
   * @see edu.byu.ee.phdl.phdl.Vector#getLsb()
   * @see #getVector()
   * @generated
   */
  EAttribute getVector_Lsb();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.Array <em>Array</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Array</em>'.
   * @see edu.byu.ee.phdl.phdl.Array
   * @generated
   */
  EClass getArray();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Array#getMsb <em>Msb</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Msb</em>'.
   * @see edu.byu.ee.phdl.phdl.Array#getMsb()
   * @see #getArray()
   * @generated
   */
  EAttribute getArray_Msb();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Array#isArray <em>Array</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Array</em>'.
   * @see edu.byu.ee.phdl.phdl.Array#isArray()
   * @see #getArray()
   * @generated
   */
  EAttribute getArray_Array();

  /**
   * Returns the meta object for the attribute '{@link edu.byu.ee.phdl.phdl.Array#getLsb <em>Lsb</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lsb</em>'.
   * @see edu.byu.ee.phdl.phdl.Array#getLsb()
   * @see #getArray()
   * @generated
   */
  EAttribute getArray_Lsb();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.Qualifier <em>Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Qualifier</em>'.
   * @see edu.byu.ee.phdl.phdl.Qualifier
   * @generated
   */
  EClass getQualifier();

  /**
   * Returns the meta object for the containment reference '{@link edu.byu.ee.phdl.phdl.Qualifier#getIndices <em>Indices</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Indices</em>'.
   * @see edu.byu.ee.phdl.phdl.Qualifier#getIndices()
   * @see #getQualifier()
   * @generated
   */
  EReference getQualifier_Indices();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.Referenceable <em>Referenceable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Referenceable</em>'.
   * @see edu.byu.ee.phdl.phdl.Referenceable
   * @generated
   */
  EClass getReferenceable();

  /**
   * Returns the meta object for class '{@link edu.byu.ee.phdl.phdl.Assignable <em>Assignable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assignable</em>'.
   * @see edu.byu.ee.phdl.phdl.Assignable
   * @generated
   */
  EClass getAssignable();

  /**
   * Returns the meta object for the containment reference '{@link edu.byu.ee.phdl.phdl.Assignable#getSlices <em>Slices</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Slices</em>'.
   * @see edu.byu.ee.phdl.phdl.Assignable#getSlices()
   * @see #getAssignable()
   * @generated
   */
  EReference getAssignable_Slices();

  /**
   * Returns the meta object for the containment reference '{@link edu.byu.ee.phdl.phdl.Assignable#getConcatenation <em>Concatenation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Concatenation</em>'.
   * @see edu.byu.ee.phdl.phdl.Assignable#getConcatenation()
   * @see #getAssignable()
   * @generated
   */
  EReference getAssignable_Concatenation();

  /**
   * Returns the meta object for enum '{@link edu.byu.ee.phdl.phdl.PinType <em>Pin Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Pin Type</em>'.
   * @see edu.byu.ee.phdl.phdl.PinType
   * @generated
   */
  EEnum getPinType();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  PhdlFactory getPhdlFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.PhdlModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.PhdlModelImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getPhdlModel()
     * @generated
     */
    EClass PHDL_MODEL = eINSTANCE.getPhdlModel();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PHDL_MODEL__IMPORTS = eINSTANCE.getPhdlModel_Imports();

    /**
     * The meta object literal for the '<em><b>Packages</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PHDL_MODEL__PACKAGES = eINSTANCE.getPhdlModel_Packages();

    /**
     * The meta object literal for the '<em><b>Devices</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PHDL_MODEL__DEVICES = eINSTANCE.getPhdlModel_Devices();

    /**
     * The meta object literal for the '<em><b>Designs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PHDL_MODEL__DESIGNS = eINSTANCE.getPhdlModel_Designs();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.PackageImpl <em>Package</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.PackageImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getPackage()
     * @generated
     */
    EClass PACKAGE = eINSTANCE.getPackage();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PACKAGE__NAME = eINSTANCE.getPackage_Name();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PACKAGE__IMPORTS = eINSTANCE.getPackage_Imports();

    /**
     * The meta object literal for the '<em><b>Devices</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PACKAGE__DEVICES = eINSTANCE.getPackage_Devices();

    /**
     * The meta object literal for the '<em><b>Designs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PACKAGE__DESIGNS = eINSTANCE.getPackage_Designs();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.ImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.ImportImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getImport()
     * @generated
     */
    EClass IMPORT = eINSTANCE.getImport();

    /**
     * The meta object literal for the '<em><b>Imported Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT__IMPORTED_NAMESPACE = eINSTANCE.getImport_ImportedNamespace();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.DeviceImpl <em>Device</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.DeviceImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getDevice()
     * @generated
     */
    EClass DEVICE = eINSTANCE.getDevice();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DEVICE__NAME = eINSTANCE.getDevice_Name();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEVICE__ELEMENTS = eINSTANCE.getDevice_Elements();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.DeviceElementImpl <em>Device Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.DeviceElementImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getDeviceElement()
     * @generated
     */
    EClass DEVICE_ELEMENT = eINSTANCE.getDeviceElement();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.AttrImpl <em>Attr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.AttrImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getAttr()
     * @generated
     */
    EClass ATTR = eINSTANCE.getAttr();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTR__NAME = eINSTANCE.getAttr_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTR__VALUE = eINSTANCE.getAttr_Value();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.PinImpl <em>Pin</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.PinImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getPin()
     * @generated
     */
    EClass PIN = eINSTANCE.getPin();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PIN__TYPE = eINSTANCE.getPin_Type();

    /**
     * The meta object literal for the '<em><b>Vector</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PIN__VECTOR = eINSTANCE.getPin_Vector();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PIN__NAME = eINSTANCE.getPin_Name();

    /**
     * The meta object literal for the '<em><b>Pin Names</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PIN__PIN_NAMES = eINSTANCE.getPin_PinNames();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.InfoImpl <em>Info</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.InfoImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getInfo()
     * @generated
     */
    EClass INFO = eINSTANCE.getInfo();

    /**
     * The meta object literal for the '<em><b>Info</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INFO__INFO = eINSTANCE.getInfo_Info();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.DesignImpl <em>Design</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.DesignImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getDesign()
     * @generated
     */
    EClass DESIGN = eINSTANCE.getDesign();

    /**
     * The meta object literal for the '<em><b>Design</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DESIGN__DESIGN = eINSTANCE.getDesign_Design();

    /**
     * The meta object literal for the '<em><b>Subdesign</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DESIGN__SUBDESIGN = eINSTANCE.getDesign_Subdesign();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DESIGN__NAME = eINSTANCE.getDesign_Name();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DESIGN__ELEMENTS = eINSTANCE.getDesign_Elements();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.DesignElementImpl <em>Design Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.DesignElementImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getDesignElement()
     * @generated
     */
    EClass DESIGN_ELEMENT = eINSTANCE.getDesignElement();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.ConnectionImpl <em>Connection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.ConnectionImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getConnection()
     * @generated
     */
    EClass CONNECTION = eINSTANCE.getConnection();

    /**
     * The meta object literal for the '<em><b>Net</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONNECTION__NET = eINSTANCE.getConnection_Net();

    /**
     * The meta object literal for the '<em><b>Vector</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONNECTION__VECTOR = eINSTANCE.getConnection_Vector();

    /**
     * The meta object literal for the '<em><b>Names</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONNECTION__NAMES = eINSTANCE.getConnection_Names();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONNECTION__ELEMENTS = eINSTANCE.getConnection_Elements();

    /**
     * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONNECTION__PORT = eINSTANCE.getConnection_Port();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.NetElementImpl <em>Net Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.NetElementImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getNetElement()
     * @generated
     */
    EClass NET_ELEMENT = eINSTANCE.getNetElement();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.PortElementImpl <em>Port Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.PortElementImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getPortElement()
     * @generated
     */
    EClass PORT_ELEMENT = eINSTANCE.getPortElement();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.InstanceImpl <em>Instance</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.InstanceImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getInstance()
     * @generated
     */
    EClass INSTANCE = eINSTANCE.getInstance();

    /**
     * The meta object literal for the '<em><b>Inst</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INSTANCE__INST = eINSTANCE.getInstance_Inst();

    /**
     * The meta object literal for the '<em><b>Array</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INSTANCE__ARRAY = eINSTANCE.getInstance_Array();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INSTANCE__NAME = eINSTANCE.getInstance_Name();

    /**
     * The meta object literal for the '<em><b>Device</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INSTANCE__DEVICE = eINSTANCE.getInstance_Device();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INSTANCE__ELEMENTS = eINSTANCE.getInstance_Elements();

    /**
     * The meta object literal for the '<em><b>Sub Inst</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INSTANCE__SUB_INST = eINSTANCE.getInstance_SubInst();

    /**
     * The meta object literal for the '<em><b>Sub Design</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INSTANCE__SUB_DESIGN = eINSTANCE.getInstance_SubDesign();

    /**
     * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INSTANCE__PREFIX = eINSTANCE.getInstance_Prefix();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.InstanceElementImpl <em>Instance Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.InstanceElementImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getInstanceElement()
     * @generated
     */
    EClass INSTANCE_ELEMENT = eINSTANCE.getInstanceElement();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.SubInstanceElementImpl <em>Sub Instance Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.SubInstanceElementImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getSubInstanceElement()
     * @generated
     */
    EClass SUB_INSTANCE_ELEMENT = eINSTANCE.getSubInstanceElement();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.RefAttrImpl <em>Ref Attr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.RefAttrImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getRefAttr()
     * @generated
     */
    EClass REF_ATTR = eINSTANCE.getRefAttr();

    /**
     * The meta object literal for the '<em><b>Qualifier</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REF_ATTR__QUALIFIER = eINSTANCE.getRefAttr_Qualifier();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REF_ATTR__REF = eINSTANCE.getRefAttr_Ref();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REF_ATTR__VALUE = eINSTANCE.getRefAttr_Value();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.NewAttrImpl <em>New Attr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.NewAttrImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getNewAttr()
     * @generated
     */
    EClass NEW_ATTR = eINSTANCE.getNewAttr();

    /**
     * The meta object literal for the '<em><b>Qualifier</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NEW_ATTR__QUALIFIER = eINSTANCE.getNewAttr_Qualifier();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NEW_ATTR__NAME = eINSTANCE.getNewAttr_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NEW_ATTR__VALUE = eINSTANCE.getNewAttr_Value();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.PinAssignImpl <em>Pin Assign</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.PinAssignImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getPinAssign()
     * @generated
     */
    EClass PIN_ASSIGN = eINSTANCE.getPinAssign();

    /**
     * The meta object literal for the '<em><b>Combined</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PIN_ASSIGN__COMBINED = eINSTANCE.getPinAssign_Combined();

    /**
     * The meta object literal for the '<em><b>Qualifier</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PIN_ASSIGN__QUALIFIER = eINSTANCE.getPinAssign_Qualifier();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PIN_ASSIGN__REF = eINSTANCE.getPinAssign_Ref();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.SubAttrImpl <em>Sub Attr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.SubAttrImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getSubAttr()
     * @generated
     */
    EClass SUB_ATTR = eINSTANCE.getSubAttr();

    /**
     * The meta object literal for the '<em><b>Qualifier</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUB_ATTR__QUALIFIER = eINSTANCE.getSubAttr_Qualifier();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUB_ATTR__REF = eINSTANCE.getSubAttr_Ref();

    /**
     * The meta object literal for the '<em><b>Ref Indices</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUB_ATTR__REF_INDICES = eINSTANCE.getSubAttr_RefIndices();

    /**
     * The meta object literal for the '<em><b>Tail</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUB_ATTR__TAIL = eINSTANCE.getSubAttr_Tail();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SUB_ATTR__VALUE = eINSTANCE.getSubAttr_Value();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.RefTailImpl <em>Ref Tail</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.RefTailImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getRefTail()
     * @generated
     */
    EClass REF_TAIL = eINSTANCE.getRefTail();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REF_TAIL__REF = eINSTANCE.getRefTail_Ref();

    /**
     * The meta object literal for the '<em><b>Ref Indices</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REF_TAIL__REF_INDICES = eINSTANCE.getRefTail_RefIndices();

    /**
     * The meta object literal for the '<em><b>Tail</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REF_TAIL__TAIL = eINSTANCE.getRefTail_Tail();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.PortAssignImpl <em>Port Assign</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.PortAssignImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getPortAssign()
     * @generated
     */
    EClass PORT_ASSIGN = eINSTANCE.getPortAssign();

    /**
     * The meta object literal for the '<em><b>Combined</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PORT_ASSIGN__COMBINED = eINSTANCE.getPortAssign_Combined();

    /**
     * The meta object literal for the '<em><b>Qualifier</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PORT_ASSIGN__QUALIFIER = eINSTANCE.getPortAssign_Qualifier();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PORT_ASSIGN__REF = eINSTANCE.getPortAssign_Ref();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.ConnectionAssignImpl <em>Connection Assign</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.ConnectionAssignImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getConnectionAssign()
     * @generated
     */
    EClass CONNECTION_ASSIGN = eINSTANCE.getConnectionAssign();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONNECTION_ASSIGN__REF = eINSTANCE.getConnectionAssign_Ref();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.ConcatenationImpl <em>Concatenation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.ConcatenationImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getConcatenation()
     * @generated
     */
    EClass CONCATENATION = eINSTANCE.getConcatenation();

    /**
     * The meta object literal for the '<em><b>Connections</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONCATENATION__CONNECTIONS = eINSTANCE.getConcatenation_Connections();

    /**
     * The meta object literal for the '<em><b>Replicated</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONCATENATION__REPLICATED = eINSTANCE.getConcatenation_Replicated();

    /**
     * The meta object literal for the '<em><b>Replicate</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONCATENATION__REPLICATE = eINSTANCE.getConcatenation_Replicate();

    /**
     * The meta object literal for the '<em><b>Open</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONCATENATION__OPEN = eINSTANCE.getConcatenation_Open();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.ConnectionRefImpl <em>Connection Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.ConnectionRefImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getConnectionRef()
     * @generated
     */
    EClass CONNECTION_REF = eINSTANCE.getConnectionRef();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONNECTION_REF__REF = eINSTANCE.getConnectionRef_Ref();

    /**
     * The meta object literal for the '<em><b>Slices</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONNECTION_REF__SLICES = eINSTANCE.getConnectionRef_Slices();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.ConnectionNameImpl <em>Connection Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.ConnectionNameImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getConnectionName()
     * @generated
     */
    EClass CONNECTION_NAME = eINSTANCE.getConnectionName();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONNECTION_NAME__NAME = eINSTANCE.getConnectionName_Name();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.IndicesImpl <em>Indices</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.IndicesImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getIndices()
     * @generated
     */
    EClass INDICES = eINSTANCE.getIndices();

    /**
     * The meta object literal for the '<em><b>Msb</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INDICES__MSB = eINSTANCE.getIndices_Msb();

    /**
     * The meta object literal for the '<em><b>Array</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INDICES__ARRAY = eINSTANCE.getIndices_Array();

    /**
     * The meta object literal for the '<em><b>Lsb</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INDICES__LSB = eINSTANCE.getIndices_Lsb();

    /**
     * The meta object literal for the '<em><b>Indices</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INDICES__INDICES = eINSTANCE.getIndices_Indices();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.SlicesImpl <em>Slices</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.SlicesImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getSlices()
     * @generated
     */
    EClass SLICES = eINSTANCE.getSlices();

    /**
     * The meta object literal for the '<em><b>Msb</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SLICES__MSB = eINSTANCE.getSlices_Msb();

    /**
     * The meta object literal for the '<em><b>Vector</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SLICES__VECTOR = eINSTANCE.getSlices_Vector();

    /**
     * The meta object literal for the '<em><b>Lsb</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SLICES__LSB = eINSTANCE.getSlices_Lsb();

    /**
     * The meta object literal for the '<em><b>Slices</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SLICES__SLICES = eINSTANCE.getSlices_Slices();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.VectorImpl <em>Vector</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.VectorImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getVector()
     * @generated
     */
    EClass VECTOR = eINSTANCE.getVector();

    /**
     * The meta object literal for the '<em><b>Msb</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VECTOR__MSB = eINSTANCE.getVector_Msb();

    /**
     * The meta object literal for the '<em><b>Vector</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VECTOR__VECTOR = eINSTANCE.getVector_Vector();

    /**
     * The meta object literal for the '<em><b>Lsb</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VECTOR__LSB = eINSTANCE.getVector_Lsb();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.ArrayImpl <em>Array</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.ArrayImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getArray()
     * @generated
     */
    EClass ARRAY = eINSTANCE.getArray();

    /**
     * The meta object literal for the '<em><b>Msb</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ARRAY__MSB = eINSTANCE.getArray_Msb();

    /**
     * The meta object literal for the '<em><b>Array</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ARRAY__ARRAY = eINSTANCE.getArray_Array();

    /**
     * The meta object literal for the '<em><b>Lsb</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ARRAY__LSB = eINSTANCE.getArray_Lsb();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.QualifierImpl <em>Qualifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.QualifierImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getQualifier()
     * @generated
     */
    EClass QUALIFIER = eINSTANCE.getQualifier();

    /**
     * The meta object literal for the '<em><b>Indices</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUALIFIER__INDICES = eINSTANCE.getQualifier_Indices();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.ReferenceableImpl <em>Referenceable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.ReferenceableImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getReferenceable()
     * @generated
     */
    EClass REFERENCEABLE = eINSTANCE.getReferenceable();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.impl.AssignableImpl <em>Assignable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.impl.AssignableImpl
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getAssignable()
     * @generated
     */
    EClass ASSIGNABLE = eINSTANCE.getAssignable();

    /**
     * The meta object literal for the '<em><b>Slices</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNABLE__SLICES = eINSTANCE.getAssignable_Slices();

    /**
     * The meta object literal for the '<em><b>Concatenation</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNABLE__CONCATENATION = eINSTANCE.getAssignable_Concatenation();

    /**
     * The meta object literal for the '{@link edu.byu.ee.phdl.phdl.PinType <em>Pin Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.byu.ee.phdl.phdl.PinType
     * @see edu.byu.ee.phdl.phdl.impl.PhdlPackageImpl#getPinType()
     * @generated
     */
    EEnum PIN_TYPE = eINSTANCE.getPinType();

  }

} //PhdlPackage
