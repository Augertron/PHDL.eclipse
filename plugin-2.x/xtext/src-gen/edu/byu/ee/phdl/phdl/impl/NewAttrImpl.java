/**
 * <copyright>
 * </copyright>
 *

 */
package edu.byu.ee.phdl.phdl.impl;

import edu.byu.ee.phdl.phdl.NewAttr;
import edu.byu.ee.phdl.phdl.PhdlPackage;
import edu.byu.ee.phdl.phdl.Qualifier;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>New Attr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.NewAttrImpl#getQualifier <em>Qualifier</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.NewAttrImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.NewAttrImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NewAttrImpl extends InstanceElementImpl implements NewAttr
{
  /**
   * The cached value of the '{@link #getQualifier() <em>Qualifier</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualifier()
   * @generated
   * @ordered
   */
  protected Qualifier qualifier;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected static final String VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected String value = VALUE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NewAttrImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return PhdlPackage.Literals.NEW_ATTR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Qualifier getQualifier()
  {
    return qualifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetQualifier(Qualifier newQualifier, NotificationChain msgs)
  {
    Qualifier oldQualifier = qualifier;
    qualifier = newQualifier;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PhdlPackage.NEW_ATTR__QUALIFIER, oldQualifier, newQualifier);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQualifier(Qualifier newQualifier)
  {
    if (newQualifier != qualifier)
    {
      NotificationChain msgs = null;
      if (qualifier != null)
        msgs = ((InternalEObject)qualifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PhdlPackage.NEW_ATTR__QUALIFIER, null, msgs);
      if (newQualifier != null)
        msgs = ((InternalEObject)newQualifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PhdlPackage.NEW_ATTR__QUALIFIER, null, msgs);
      msgs = basicSetQualifier(newQualifier, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.NEW_ATTR__QUALIFIER, newQualifier, newQualifier));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.NEW_ATTR__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(String newValue)
  {
    String oldValue = value;
    value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.NEW_ATTR__VALUE, oldValue, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case PhdlPackage.NEW_ATTR__QUALIFIER:
        return basicSetQualifier(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case PhdlPackage.NEW_ATTR__QUALIFIER:
        return getQualifier();
      case PhdlPackage.NEW_ATTR__NAME:
        return getName();
      case PhdlPackage.NEW_ATTR__VALUE:
        return getValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case PhdlPackage.NEW_ATTR__QUALIFIER:
        setQualifier((Qualifier)newValue);
        return;
      case PhdlPackage.NEW_ATTR__NAME:
        setName((String)newValue);
        return;
      case PhdlPackage.NEW_ATTR__VALUE:
        setValue((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case PhdlPackage.NEW_ATTR__QUALIFIER:
        setQualifier((Qualifier)null);
        return;
      case PhdlPackage.NEW_ATTR__NAME:
        setName(NAME_EDEFAULT);
        return;
      case PhdlPackage.NEW_ATTR__VALUE:
        setValue(VALUE_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case PhdlPackage.NEW_ATTR__QUALIFIER:
        return qualifier != null;
      case PhdlPackage.NEW_ATTR__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case PhdlPackage.NEW_ATTR__VALUE:
        return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", value: ");
    result.append(value);
    result.append(')');
    return result.toString();
  }

} //NewAttrImpl
