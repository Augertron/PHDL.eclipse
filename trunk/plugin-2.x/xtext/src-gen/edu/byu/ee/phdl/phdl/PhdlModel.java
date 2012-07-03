/**
 * <copyright>
 * </copyright>
 *

 */
package edu.byu.ee.phdl.phdl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.PhdlModel#getImports <em>Imports</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.PhdlModel#getPackages <em>Packages</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.PhdlModel#getDevices <em>Devices</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.PhdlModel#getDesigns <em>Designs</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.byu.ee.phdl.phdl.PhdlPackage#getPhdlModel()
 * @model
 * @generated
 */
public interface PhdlModel extends EObject
{
  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
   * The list contents are of type {@link edu.byu.ee.phdl.phdl.Import}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imports</em>' containment reference list.
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getPhdlModel_Imports()
   * @model containment="true"
   * @generated
   */
  EList<Import> getImports();

  /**
   * Returns the value of the '<em><b>Packages</b></em>' containment reference list.
   * The list contents are of type {@link edu.byu.ee.phdl.phdl.Package}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Packages</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Packages</em>' containment reference list.
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getPhdlModel_Packages()
   * @model containment="true"
   * @generated
   */
  EList<edu.byu.ee.phdl.phdl.Package> getPackages();

  /**
   * Returns the value of the '<em><b>Devices</b></em>' containment reference list.
   * The list contents are of type {@link edu.byu.ee.phdl.phdl.Device}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Devices</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Devices</em>' containment reference list.
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getPhdlModel_Devices()
   * @model containment="true"
   * @generated
   */
  EList<Device> getDevices();

  /**
   * Returns the value of the '<em><b>Designs</b></em>' containment reference list.
   * The list contents are of type {@link edu.byu.ee.phdl.phdl.Design}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Designs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Designs</em>' containment reference list.
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getPhdlModel_Designs()
   * @model containment="true"
   * @generated
   */
  EList<Design> getDesigns();

} // PhdlModel
