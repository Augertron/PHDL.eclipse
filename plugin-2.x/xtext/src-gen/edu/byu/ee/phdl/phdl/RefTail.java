/**
 */
package edu.byu.ee.phdl.phdl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ref Tail</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.RefTail#getRef <em>Ref</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.RefTail#getRefIndices <em>Ref Indices</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.RefTail#getTail <em>Tail</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.byu.ee.phdl.phdl.PhdlPackage#getRefTail()
 * @model
 * @generated
 */
public interface RefTail extends EObject
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
   * @see #setRef(Referenceable)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getRefTail_Ref()
   * @model
   * @generated
   */
  Referenceable getRef();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.RefTail#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(Referenceable value);

  /**
   * Returns the value of the '<em><b>Ref Indices</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref Indices</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref Indices</em>' containment reference.
   * @see #setRefIndices(Indices)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getRefTail_RefIndices()
   * @model containment="true"
   * @generated
   */
  Indices getRefIndices();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.RefTail#getRefIndices <em>Ref Indices</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref Indices</em>' containment reference.
   * @see #getRefIndices()
   * @generated
   */
  void setRefIndices(Indices value);

  /**
   * Returns the value of the '<em><b>Tail</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tail</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tail</em>' containment reference.
   * @see #setTail(RefTail)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getRefTail_Tail()
   * @model containment="true"
   * @generated
   */
  RefTail getTail();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.RefTail#getTail <em>Tail</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tail</em>' containment reference.
   * @see #getTail()
   * @generated
   */
  void setTail(RefTail value);

} // RefTail
