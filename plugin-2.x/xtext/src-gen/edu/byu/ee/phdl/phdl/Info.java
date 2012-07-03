/**
 * <copyright>
 * </copyright>
 *

 */
package edu.byu.ee.phdl.phdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.Info#getInfo <em>Info</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.byu.ee.phdl.phdl.PhdlPackage#getInfo()
 * @model
 * @generated
 */
public interface Info extends DeviceElement, DesignElement, NetElement, PortElement, InstanceElement, SubInstanceElement
{
  /**
   * Returns the value of the '<em><b>Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Info</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Info</em>' attribute.
   * @see #setInfo(String)
   * @see edu.byu.ee.phdl.phdl.PhdlPackage#getInfo_Info()
   * @model
   * @generated
   */
  String getInfo();

  /**
   * Sets the value of the '{@link edu.byu.ee.phdl.phdl.Info#getInfo <em>Info</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Info</em>' attribute.
   * @see #getInfo()
   * @generated
   */
  void setInfo(String value);

} // Info
