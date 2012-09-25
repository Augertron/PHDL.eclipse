/**
 */
package edu.byu.ee.phdl.phdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port Assign</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.PortAssign#isCombined <em>Combined</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.PortAssign#getQualifier <em>Qualifier</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.PortAssign#getRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.byu.ee.phdl.phdl.PhdlPackage#getPortAssign()
 * @model
 * @generated
 */
public interface PortAssign extends SubInstanceElement, Assignable
{
  /**
   * Returns the value of the '<em><b>Combined</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Combined</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Combined</em>' attribute.
   * @see #setCombined(boolean)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getPortAssign_Combined()
   * @model
   * @generated
   */
  boolean isCombined();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.PortAssign#isCombined <em>Combined</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Combined</em>' attribute.
   * @see #isCombined()
   * @generated
   */
  void setCombined(boolean value);

  /**
   * Returns the value of the '<em><b>Qualifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Qualifier</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Qualifier</em>' containment reference.
   * @see #setQualifier(Qualifier)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getPortAssign_Qualifier()
   * @model containment="true"
   * @generated
   */
  Qualifier getQualifier();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.PortAssign#getQualifier <em>Qualifier</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Qualifier</em>' containment reference.
   * @see #getQualifier()
   * @generated
   */
  void setQualifier(Qualifier value);

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
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getPortAssign_Ref()
   * @model
   * @generated
   */
  ConnectionName getRef();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.PortAssign#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(ConnectionName value);

} // PortAssign
