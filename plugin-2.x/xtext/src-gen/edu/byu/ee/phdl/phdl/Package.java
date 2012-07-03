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
 * A representation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.Package#getName <em>Name</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Package#getImports <em>Imports</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Package#getDevices <em>Devices</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Package#getDesigns <em>Designs</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.byu.ee.phdl.phdl.PhdlPackage#getPackage()
 * @model
 * @generated
 */
public interface Package extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getPackage_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Package#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

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
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getPackage_Imports()
   * @model containment="true"
   * @generated
   */
  EList<Import> getImports();

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
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getPackage_Devices()
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
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getPackage_Designs()
   * @model containment="true"
   * @generated
   */
  EList<Design> getDesigns();

} // Package
