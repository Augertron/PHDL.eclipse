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
 * A representation of the model object '<em><b>Slices</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.Slices#getMsb <em>Msb</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Slices#isVector <em>Vector</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Slices#getLsb <em>Lsb</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Slices#getSlices <em>Slices</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.byu.ee.phdl.phdl.PhdlPackage#getSlices()
 * @model
 * @generated
 */
public interface Slices extends EObject
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
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getSlices_Msb()
   * @model
   * @generated
   */
  int getMsb();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Slices#getMsb <em>Msb</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Msb</em>' attribute.
   * @see #getMsb()
   * @generated
   */
  void setMsb(int value);

  /**
   * Returns the value of the '<em><b>Vector</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Vector</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Vector</em>' attribute.
   * @see #setVector(boolean)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getSlices_Vector()
   * @model
   * @generated
   */
  boolean isVector();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Slices#isVector <em>Vector</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Vector</em>' attribute.
   * @see #isVector()
   * @generated
   */
  void setVector(boolean value);

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
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getSlices_Lsb()
   * @model
   * @generated
   */
  int getLsb();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Slices#getLsb <em>Lsb</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lsb</em>' attribute.
   * @see #getLsb()
   * @generated
   */
  void setLsb(int value);

  /**
   * Returns the value of the '<em><b>Slices</b></em>' attribute list.
   * The list contents are of type {@link java.lang.Integer}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Slices</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Slices</em>' attribute list.
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getSlices_Slices()
   * @model unique="false"
   * @generated
   */
  EList<Integer> getSlices();

} // Slices
