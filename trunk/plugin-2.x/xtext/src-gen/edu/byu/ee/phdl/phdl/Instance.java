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
 * A representation of the model object '<em><b>Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.Instance#isInst <em>Inst</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Instance#getArray <em>Array</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Instance#getName <em>Name</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Instance#getDevice <em>Device</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Instance#getElements <em>Elements</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Instance#isSubInst <em>Sub Inst</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Instance#getSubDesign <em>Sub Design</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Instance#getPrefix <em>Prefix</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.byu.ee.phdl.phdl.PhdlPackage#getInstance()
 * @model
 * @generated
 */
public interface Instance extends DesignElement, Referenceable
{
  /**
   * Returns the value of the '<em><b>Inst</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inst</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inst</em>' attribute.
   * @see #setInst(boolean)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getInstance_Inst()
   * @model
   * @generated
   */
  boolean isInst();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Instance#isInst <em>Inst</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Inst</em>' attribute.
   * @see #isInst()
   * @generated
   */
  void setInst(boolean value);

  /**
   * Returns the value of the '<em><b>Array</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Array</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Array</em>' containment reference.
   * @see #setArray(Array)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getInstance_Array()
   * @model containment="true"
   * @generated
   */
  Array getArray();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Instance#getArray <em>Array</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Array</em>' containment reference.
   * @see #getArray()
   * @generated
   */
  void setArray(Array value);

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
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getInstance_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Instance#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Device</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Device</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Device</em>' reference.
   * @see #setDevice(Device)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getInstance_Device()
   * @model
   * @generated
   */
  Device getDevice();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Instance#getDevice <em>Device</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Device</em>' reference.
   * @see #getDevice()
   * @generated
   */
  void setDevice(Device value);

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
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getInstance_Elements()
   * @model containment="true"
   * @generated
   */
  EList<EObject> getElements();

  /**
   * Returns the value of the '<em><b>Sub Inst</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub Inst</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub Inst</em>' attribute.
   * @see #setSubInst(boolean)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getInstance_SubInst()
   * @model
   * @generated
   */
  boolean isSubInst();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Instance#isSubInst <em>Sub Inst</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sub Inst</em>' attribute.
   * @see #isSubInst()
   * @generated
   */
  void setSubInst(boolean value);

  /**
   * Returns the value of the '<em><b>Sub Design</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub Design</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub Design</em>' reference.
   * @see #setSubDesign(Design)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getInstance_SubDesign()
   * @model
   * @generated
   */
  Design getSubDesign();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Instance#getSubDesign <em>Sub Design</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sub Design</em>' reference.
   * @see #getSubDesign()
   * @generated
   */
  void setSubDesign(Design value);

  /**
   * Returns the value of the '<em><b>Prefix</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Prefix</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Prefix</em>' attribute.
   * @see #setPrefix(String)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getInstance_Prefix()
   * @model
   * @generated
   */
  String getPrefix();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Instance#getPrefix <em>Prefix</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Prefix</em>' attribute.
   * @see #getPrefix()
   * @generated
   */
  void setPrefix(String value);

} // Instance
