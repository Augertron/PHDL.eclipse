/**
 * <copyright>
 * </copyright>
 *

 */
package edu.byu.ee.phdl.phdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub Attr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.SubAttr#getQualifier <em>Qualifier</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.SubAttr#getRef <em>Ref</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.SubAttr#getRefIndices <em>Ref Indices</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.SubAttr#getTail <em>Tail</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.SubAttr#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.byu.ee.phdl.phdl.PhdlPackage#getSubAttr()
 * @model
 * @generated
 */
public interface SubAttr extends SubInstanceElement
{
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
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getSubAttr_Qualifier()
   * @model containment="true"
   * @generated
   */
  Qualifier getQualifier();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.SubAttr#getQualifier <em>Qualifier</em>}' containment reference.
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
   * @see #setRef(Referenceable)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getSubAttr_Ref()
   * @model
   * @generated
   */
  Referenceable getRef();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.SubAttr#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(Referenceable value);

  /**
   * Returns the value of the '<em><b>Ref Indices</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref Indices</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref Indices</em>' containment reference.
   * @see #setRefIndices(Indices)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getSubAttr_RefIndices()
   * @model containment="true"
   * @generated
   */
  Indices getRefIndices();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.SubAttr#getRefIndices <em>Ref Indices</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref Indices</em>' containment reference.
   * @see #getRefIndices()
   * @generated
   */
  void setRefIndices(Indices value);

  /**
   * Returns the value of the '<em><b>Tail</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tail</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tail</em>' containment reference.
   * @see #setTail(RefTail)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getSubAttr_Tail()
   * @model containment="true"
   * @generated
   */
  RefTail getTail();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.SubAttr#getTail <em>Tail</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tail</em>' containment reference.
   * @see #getTail()
   * @generated
   */
  void setTail(RefTail value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getSubAttr_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.SubAttr#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

} // SubAttr
