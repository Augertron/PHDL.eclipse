/**
 * <copyright>
 * </copyright>
 *

 */
package edu.byu.ee.phdl.phdl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.Vector#getMsb <em>Msb</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Vector#isVector <em>Vector</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Vector#getLsb <em>Lsb</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.byu.ee.phdl.phdl.PhdlPackage#getVector()
 * @model
 * @generated
 */
public interface Vector extends EObject
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
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getVector_Msb()
   * @model
   * @generated
   */
  int getMsb();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Vector#getMsb <em>Msb</em>}' attribute.
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
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getVector_Vector()
   * @model
   * @generated
   */
  boolean isVector();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Vector#isVector <em>Vector</em>}' attribute.
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
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getVector_Lsb()
   * @model
   * @generated
   */
  int getLsb();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Vector#getLsb <em>Lsb</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lsb</em>' attribute.
   * @see #getLsb()
   * @generated
   */
  void setLsb(int value);

} // Vector
