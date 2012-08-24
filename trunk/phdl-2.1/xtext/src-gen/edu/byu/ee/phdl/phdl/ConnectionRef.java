/**
 */
package edu.byu.ee.phdl.phdl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.ConnectionRef#getRef <em>Ref</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.ConnectionRef#getSlices <em>Slices</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.byu.ee.phdl.phdl.PhdlPackage#getConnectionRef()
 * @model
 * @generated
 */
public interface ConnectionRef extends EObject
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(ConnectionName)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getConnectionRef_Ref()
   * @model
   * @generated
   */
  ConnectionName getRef();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.ConnectionRef#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(ConnectionName value);

  /**
   * Returns the value of the '<em><b>Slices</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Slices</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Slices</em>' containment reference.
   * @see #setSlices(Slices)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getConnectionRef_Slices()
   * @model containment="true"
   * @generated
   */
  Slices getSlices();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.ConnectionRef#getSlices <em>Slices</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Slices</em>' containment reference.
   * @see #getSlices()
   * @generated
   */
  void setSlices(Slices value);

} // ConnectionRef
