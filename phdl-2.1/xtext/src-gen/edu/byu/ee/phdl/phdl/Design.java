/**
 */
package edu.byu.ee.phdl.phdl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Design</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.Design#isDesign <em>Design</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Design#isSubdesign <em>Subdesign</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Design#getName <em>Name</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Design#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.byu.ee.phdl.phdl.PhdlPackage#getDesign()
 * @model
 * @generated
 */
public interface Design extends EObject
{
  /**
   * Returns the value of the '<em><b>Design</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Design</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Design</em>' attribute.
   * @see #setDesign(boolean)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getDesign_Design()
   * @model
   * @generated
   */
  boolean isDesign();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Design#isDesign <em>Design</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Design</em>' attribute.
   * @see #isDesign()
   * @generated
   */
  void setDesign(boolean value);

  /**
   * Returns the value of the '<em><b>Subdesign</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Subdesign</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subdesign</em>' attribute.
   * @see #setSubdesign(boolean)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getDesign_Subdesign()
   * @model
   * @generated
   */
  boolean isSubdesign();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Design#isSubdesign <em>Subdesign</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Subdesign</em>' attribute.
   * @see #isSubdesign()
   * @generated
   */
  void setSubdesign(boolean value);

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
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getDesign_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Design#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link edu.byu.ee.phdl.phdl.DesignElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getDesign_Elements()
   * @model containment="true"
   * @generated
   */
  EList<DesignElement> getElements();

} // Design
