/**
 */
package edu.byu.ee.phdl.phdl.impl;

import edu.byu.ee.phdl.phdl.PhdlPackage;
import edu.byu.ee.phdl.phdl.Pin;
import edu.byu.ee.phdl.phdl.PinType;
import edu.byu.ee.phdl.phdl.Vector;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pin</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.PinImpl#getType <em>Type</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.PinImpl#getVector <em>Vector</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.PinImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.PinImpl#getPinNames <em>Pin Names</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PinImpl extends DeviceElementImpl implements Pin
{
  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final PinType TYPE_EDEFAULT = PinType.PIN;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected PinType type = TYPE_EDEFAULT;

  /**
   * The cached value of the '{@link #getVector() <em>Vector</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVector()
   * @generated
   * @ordered
   */
  protected Vector vector;

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
   * The cached value of the '{@link #getPinNames() <em>Pin Names</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPinNames()
   * @generated
   * @ordered
   */
  protected EList<String> pinNames;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PinImpl()
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
    return PhdlPackage.Literals.PIN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PinType getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(PinType newType)
  {
    PinType oldType = type;
    type = newType == null ? TYPE_EDEFAULT : newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.PIN__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Vector getVector()
  {
    return vector;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVector(Vector newVector, NotificationChain msgs)
  {
    Vector oldVector = vector;
    vector = newVector;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PhdlPackage.PIN__VECTOR, oldVector, newVector);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVector(Vector newVector)
  {
    if (newVector != vector)
    {
      NotificationChain msgs = null;
      if (vector != null)
        msgs = ((InternalEObject)vector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PhdlPackage.PIN__VECTOR, null, msgs);
      if (newVector != null)
        msgs = ((InternalEObject)newVector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PhdlPackage.PIN__VECTOR, null, msgs);
      msgs = basicSetVector(newVector, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.PIN__VECTOR, newVector, newVector));
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
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.PIN__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getPinNames()
  {
    if (pinNames == null)
    {
      pinNames = new EDataTypeEList<String>(String.class, this, PhdlPackage.PIN__PIN_NAMES);
    }
    return pinNames;
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
      case PhdlPackage.PIN__VECTOR:
        return basicSetVector(null, msgs);
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
      case PhdlPackage.PIN__TYPE:
        return getType();
      case PhdlPackage.PIN__VECTOR:
        return getVector();
      case PhdlPackage.PIN__NAME:
        return getName();
      case PhdlPackage.PIN__PIN_NAMES:
        return getPinNames();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case PhdlPackage.PIN__TYPE:
        setType((PinType)newValue);
        return;
      case PhdlPackage.PIN__VECTOR:
        setVector((Vector)newValue);
        return;
      case PhdlPackage.PIN__NAME:
        setName((String)newValue);
        return;
      case PhdlPackage.PIN__PIN_NAMES:
        getPinNames().clear();
        getPinNames().addAll((Collection<? extends String>)newValue);
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
      case PhdlPackage.PIN__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case PhdlPackage.PIN__VECTOR:
        setVector((Vector)null);
        return;
      case PhdlPackage.PIN__NAME:
        setName(NAME_EDEFAULT);
        return;
      case PhdlPackage.PIN__PIN_NAMES:
        getPinNames().clear();
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
      case PhdlPackage.PIN__TYPE:
        return type != TYPE_EDEFAULT;
      case PhdlPackage.PIN__VECTOR:
        return vector != null;
      case PhdlPackage.PIN__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case PhdlPackage.PIN__PIN_NAMES:
        return pinNames != null && !pinNames.isEmpty();
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
    result.append(" (type: ");
    result.append(type);
    result.append(", name: ");
    result.append(name);
    result.append(", pinNames: ");
    result.append(pinNames);
    result.append(')');
    return result.toString();
  }

} //PinImpl
