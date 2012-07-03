/**
 * <copyright>
 * </copyright>
 *

 */
package edu.byu.ee.phdl.phdl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.Qualifier#getIndices <em>Indices</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.byu.ee.phdl.phdl.PhdlPackage#getQualifier()
 * @model
 * @generated
 */
public interface Qualifier extends EObject
{
  /**
   * Returns the value of the '<em><b>Indices</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Indices</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Indices</em>' containment reference.
   * @see #setIndices(Indices)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getQualifier_Indices()
   * @model containment="true"
   * @generated
   */
  Indices getIndices();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Qualifier#getIndices <em>Indices</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Indices</em>' containment reference.
   * @see #getIndices()
   * @generated
   */
  void setIndices(Indices value);

} // Qualifier
