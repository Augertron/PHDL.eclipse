/**
 */
package edu.byu.ee.phdl.phdl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.byu.ee.phdl.phdl.PhdlPackage
 * @generated
 */
public interface PhdlFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  PhdlFactory eINSTANCE = edu.byu.ee.phdl.phdl.impl.PhdlFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  PhdlModel createPhdlModel();

  /**
   * Returns a new object of class '<em>Package</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Package</em>'.
   * @generated
   */
  Package createPackage();

  /**
   * Returns a new object of class '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Import</em>'.
   * @generated
   */
  Import createImport();

  /**
   * Returns a new object of class '<em>Device</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Device</em>'.
   * @generated
   */
  Device createDevice();

  /**
   * Returns a new object of class '<em>Device Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Device Element</em>'.
   * @generated
   */
  DeviceElement createDeviceElement();

  /**
   * Returns a new object of class '<em>Attr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attr</em>'.
   * @generated
   */
  Attr createAttr();

  /**
   * Returns a new object of class '<em>Pin</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pin</em>'.
   * @generated
   */
  Pin createPin();

  /**
   * Returns a new object of class '<em>Info</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Info</em>'.
   * @generated
   */
  Info createInfo();

  /**
   * Returns a new object of class '<em>Design</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Design</em>'.
   * @generated
   */
  Design createDesign();

  /**
   * Returns a new object of class '<em>Design Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Design Element</em>'.
   * @generated
   */
  DesignElement createDesignElement();

  /**
   * Returns a new object of class '<em>Connection</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Connection</em>'.
   * @generated
   */
  Connection createConnection();

  /**
   * Returns a new object of class '<em>Net Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Net Element</em>'.
   * @generated
   */
  NetElement createNetElement();

  /**
   * Returns a new object of class '<em>Port Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Port Element</em>'.
   * @generated
   */
  PortElement createPortElement();

  /**
   * Returns a new object of class '<em>Instance</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Instance</em>'.
   * @generated
   */
  Instance createInstance();

  /**
   * Returns a new object of class '<em>Instance Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Instance Element</em>'.
   * @generated
   */
  InstanceElement createInstanceElement();

  /**
   * Returns a new object of class '<em>Sub Instance Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sub Instance Element</em>'.
   * @generated
   */
  SubInstanceElement createSubInstanceElement();

  /**
   * Returns a new object of class '<em>Ref Attr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ref Attr</em>'.
   * @generated
   */
  RefAttr createRefAttr();

  /**
   * Returns a new object of class '<em>New Attr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>New Attr</em>'.
   * @generated
   */
  NewAttr createNewAttr();

  /**
   * Returns a new object of class '<em>Pin Assign</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pin Assign</em>'.
   * @generated
   */
  PinAssign createPinAssign();

  /**
   * Returns a new object of class '<em>Sub Attr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sub Attr</em>'.
   * @generated
   */
  SubAttr createSubAttr();

  /**
   * Returns a new object of class '<em>Ref Tail</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ref Tail</em>'.
   * @generated
   */
  RefTail createRefTail();

  /**
   * Returns a new object of class '<em>Port Assign</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Port Assign</em>'.
   * @generated
   */
  PortAssign createPortAssign();

  /**
   * Returns a new object of class '<em>Connection Assign</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Connection Assign</em>'.
   * @generated
   */
  ConnectionAssign createConnectionAssign();

  /**
   * Returns a new object of class '<em>Concatenation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Concatenation</em>'.
   * @generated
   */
  Concatenation createConcatenation();

  /**
   * Returns a new object of class '<em>Connection Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Connection Ref</em>'.
   * @generated
   */
  ConnectionRef createConnectionRef();

  /**
   * Returns a new object of class '<em>Connection Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Connection Name</em>'.
   * @generated
   */
  ConnectionName createConnectionName();

  /**
   * Returns a new object of class '<em>Indices</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Indices</em>'.
   * @generated
   */
  Indices createIndices();

  /**
   * Returns a new object of class '<em>Slices</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Slices</em>'.
   * @generated
   */
  Slices createSlices();

  /**
   * Returns a new object of class '<em>Vector</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Vector</em>'.
   * @generated
   */
  Vector createVector();

  /**
   * Returns a new object of class '<em>Array</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Array</em>'.
   * @generated
   */
  Array createArray();

  /**
   * Returns a new object of class '<em>Qualifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Qualifier</em>'.
   * @generated
   */
  Qualifier createQualifier();

  /**
   * Returns a new object of class '<em>Referenceable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Referenceable</em>'.
   * @generated
   */
  Referenceable createReferenceable();

  /**
   * Returns a new object of class '<em>Assignable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assignable</em>'.
   * @generated
   */
  Assignable createAssignable();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  PhdlPackage getPhdlPackage();

} //PhdlFactory
