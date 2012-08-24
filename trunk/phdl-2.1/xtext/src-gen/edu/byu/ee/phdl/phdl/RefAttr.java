/**
 */
package edu.byu.ee.phdl.phdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ref Attr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.RefAttr#getQualifier <em>Qualifier</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.RefAttr#getRef <em>Ref</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.RefAttr#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.byu.ee.phdl.phdl.PhdlPackage#getRefAttr()
 * @model
 * @generated
 */
public interface RefAttr extends InstanceElement, Referenceable
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
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getRefAttr_Qualifier()
   * @model containment="true"
   * @generated
   */
  Qualifier getQualifier();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.RefAttr#getQualifier <em>Qualifier</em>}' containment reference.
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
   * @see #setRef(Attr)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getRefAttr_Ref()
   * @model
   * @generated
   */
  Attr getRef();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.RefAttr#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(Attr value);

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
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getRefAttr_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.RefAttr#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

} // RefAttr
