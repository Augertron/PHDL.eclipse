/**
 */
package edu.byu.ee.phdl.phdl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.Connection#isNet <em>Net</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Connection#getVector <em>Vector</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Connection#getNames <em>Names</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Connection#getElements <em>Elements</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Connection#isPort <em>Port</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.byu.ee.phdl.phdl.PhdlPackage#getConnection()
 * @model
 * @generated
 */
public interface Connection extends DesignElement
{
  /**
   * Returns the value of the '<em><b>Net</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Net</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Net</em>' attribute.
   * @see #setNet(boolean)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getConnection_Net()
   * @model
   * @generated
   */
  boolean isNet();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Connection#isNet <em>Net</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Net</em>' attribute.
   * @see #isNet()
   * @generated
   */
  void setNet(boolean value);

  /**
   * Returns the value of the '<em><b>Vector</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Vector</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Vector</em>' containment reference.
   * @see #setVector(Vector)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getConnection_Vector()
   * @model containment="true"
   * @generated
   */
  Vector getVector();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Connection#getVector <em>Vector</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Vector</em>' containment reference.
   * @see #getVector()
   * @generated
   */
  void setVector(Vector value);

  /**
   * Returns the value of the '<em><b>Names</b></em>' containment reference list.
   * The list contents are of type {@link edu.byu.ee.phdl.phdl.ConnectionName}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Names</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Names</em>' containment reference list.
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getConnection_Names()
   * @model containment="true"
   * @generated
   */
  EList<ConnectionName> getNames();

  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getConnection_Elements()
   * @model containment="true"
   * @generated
   */
  EList<EObject> getElements();

  /**
   * Returns the value of the '<em><b>Port</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Port</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Port</em>' attribute.
   * @see #setPort(boolean)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getConnection_Port()
   * @model
   * @generated
   */
  boolean isPort();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Connection#isPort <em>Port</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Port</em>' attribute.
   * @see #isPort()
   * @generated
   */
  void setPort(boolean value);

} // Connection
