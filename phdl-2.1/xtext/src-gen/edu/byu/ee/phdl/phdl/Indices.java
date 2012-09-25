/**
 */
package edu.byu.ee.phdl.phdl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Indices</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.Indices#getMsb <em>Msb</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Indices#isArray <em>Array</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Indices#getLsb <em>Lsb</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Indices#getIndices <em>Indices</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.byu.ee.phdl.phdl.PhdlPackage#getIndices()
 * @model
 * @generated
 */
public interface Indices extends EObject
{
  /**
   * Returns the value of the '<em><b>Msb</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Msb</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Msb</em>' attribute.
   * @see #setMsb(int)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getIndices_Msb()
   * @model
   * @generated
   */
  int getMsb();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Indices#getMsb <em>Msb</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Msb</em>' attribute.
   * @see #getMsb()
   * @generated
   */
  void setMsb(int value);

  /**
   * Returns the value of the '<em><b>Array</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Array</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Array</em>' attribute.
   * @see #setArray(boolean)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getIndices_Array()
   * @model
   * @generated
   */
  boolean isArray();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Indices#isArray <em>Array</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Array</em>' attribute.
   * @see #isArray()
   * @generated
   */
  void setArray(boolean value);

  /**
   * Returns the value of the '<em><b>Lsb</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lsb</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lsb</em>' attribute.
   * @see #setLsb(int)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getIndices_Lsb()
   * @model
   * @generated
   */
  int getLsb();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Indices#getLsb <em>Lsb</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lsb</em>' attribute.
   * @see #getLsb()
   * @generated
   */
  void setLsb(int value);

  /**
   * Returns the value of the '<em><b>Indices</b></em>' attribute list.
   * The list contents are of type {@link java.lang.Integer}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Indices</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Indices</em>' attribute list.
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getIndices_Indices()
   * @model unique="false"
   * @generated
   */
  EList<Integer> getIndices();

} // Indices
