/**
 * <copyright>
 * </copyright>
 *

 */
package edu.byu.ee.phdl.phdl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.Assignable#getSlices <em>Slices</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Assignable#getConcatenation <em>Concatenation</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.byu.ee.phdl.phdl.PhdlPackage#getAssignable()
 * @model
 * @generated
 */
public interface Assignable extends EObject
{
  /**
   * Returns the value of the '<em><b>Slices</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Slices</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Slices</em>' containment reference.
   * @see #setSlices(Slices)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getAssignable_Slices()
   * @model containment="true"
   * @generated
   */
  Slices getSlices();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Assignable#getSlices <em>Slices</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Slices</em>' containment reference.
   * @see #getSlices()
   * @generated
   */
  void setSlices(Slices value);

  /**
   * Returns the value of the '<em><b>Concatenation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Concatenation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Concatenation</em>' containment reference.
   * @see #setConcatenation(Concatenation)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getAssignable_Concatenation()
   * @model containment="true"
   * @generated
   */
  Concatenation getConcatenation();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Assignable#getConcatenation <em>Concatenation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Concatenation</em>' containment reference.
   * @see #getConcatenation()
   * @generated
   */
  void setConcatenation(Concatenation value);

} // Assignable
