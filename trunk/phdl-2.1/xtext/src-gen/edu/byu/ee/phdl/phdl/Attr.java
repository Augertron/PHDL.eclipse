/**
 */
package edu.byu.ee.phdl.phdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.Attr#getName <em>Name</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.Attr#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.byu.ee.phdl.phdl.PhdlPackage#getAttr()
 * @model
 * @generated
 */
public interface Attr extends DeviceElement, NetElement, InstanceElement, SubInstanceElement, Referenceable
{
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
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getAttr_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Attr#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

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
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getAttr_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Attr#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

} // Attr
