/**
 * <copyright>
 * </copyright>
 *

 */
package edu.byu.ee.phdl.phdl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pin</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.Pin#getType <em>Type</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Pin#getVector <em>Vector</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Pin#getName <em>Name</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Pin#getPinNames <em>Pin Names</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.byu.ee.phdl.phdl.PhdlPackage#getPin()
 * @model
 * @generated
 */
public interface Pin extends DeviceElement
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link edu.byu.ee.phdl.phdl.PinType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see edu.byu.ee.phdl.phdl.PinType
   * @see #setType(PinType)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getPin_Type()
   * @model
   * @generated
   */
  PinType getType();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Pin#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see edu.byu.ee.phdl.phdl.PinType
   * @see #getType()
   * @generated
   */
  void setType(PinType value);

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
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getPin_Vector()
   * @model containment="true"
   * @generated
   */
  Vector getVector();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Pin#getVector <em>Vector</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Vector</em>' containment reference.
   * @see #getVector()
   * @generated
   */
  void setVector(Vector value);

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
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getPin_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Pin#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Pin Names</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pin Names</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pin Names</em>' attribute list.
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getPin_PinNames()
   * @model unique="false"
   * @generated
   */
  EList<String> getPinNames();

} // Pin
