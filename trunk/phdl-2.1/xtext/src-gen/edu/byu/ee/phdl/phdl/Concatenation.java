/**
 */
package edu.byu.ee.phdl.phdl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concatenation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.Concatenation#getConnections <em>Connections</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Concatenation#isReplicated <em>Replicated</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Concatenation#getReplicate <em>Replicate</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Concatenation#isOpen <em>Open</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.byu.ee.phdl.phdl.PhdlPackage#getConcatenation()
 * @model
 * @generated
 */
public interface Concatenation extends EObject
{
  /**
   * Returns the value of the '<em><b>Connections</b></em>' containment reference list.
   * The list contents are of type {@link edu.byu.ee.phdl.phdl.ConnectionRef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Connections</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Connections</em>' containment reference list.
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getConcatenation_Connections()
   * @model containment="true"
   * @generated
   */
  EList<ConnectionRef> getConnections();

  /**
   * Returns the value of the '<em><b>Replicated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Replicated</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Replicated</em>' attribute.
   * @see #setReplicated(boolean)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getConcatenation_Replicated()
   * @model
   * @generated
   */
  boolean isReplicated();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Concatenation#isReplicated <em>Replicated</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Replicated</em>' attribute.
   * @see #isReplicated()
   * @generated
   */
  void setReplicated(boolean value);

  /**
   * Returns the value of the '<em><b>Replicate</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Replicate</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Replicate</em>' containment reference.
   * @see #setReplicate(ConnectionRef)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getConcatenation_Replicate()
   * @model containment="true"
   * @generated
   */
  ConnectionRef getReplicate();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Concatenation#getReplicate <em>Replicate</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Replicate</em>' containment reference.
   * @see #getReplicate()
   * @generated
   */
  void setReplicate(ConnectionRef value);

  /**
   * Returns the value of the '<em><b>Open</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Open</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Open</em>' attribute.
   * @see #setOpen(boolean)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getConcatenation_Open()
   * @model
   * @generated
   */
  boolean isOpen();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Concatenation#isOpen <em>Open</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Open</em>' attribute.
   * @see #isOpen()
   * @generated
   */
  void setOpen(boolean value);

} // Concatenation
