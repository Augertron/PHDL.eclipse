/**
 */
package edu.byu.ee.phdl.phdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection Assign</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.ConnectionAssign#getRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.byu.ee.phdl.phdl.PhdlPackage#getConnectionAssign()
 * @model
 * @generated
 */
public interface ConnectionAssign extends DesignElement, Assignable
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
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getConnectionAssign_Ref()
   * @model
   * @generated
   */
  ConnectionName getRef();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.ConnectionAssign#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(ConnectionName value);

} // ConnectionAssign
