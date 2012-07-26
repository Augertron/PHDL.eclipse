/**
 */
package edu.byu.ee.phdl.phdl.impl;

import edu.byu.ee.phdl.phdl.Array;
import edu.byu.ee.phdl.phdl.Design;
import edu.byu.ee.phdl.phdl.Device;
import edu.byu.ee.phdl.phdl.Instance;
import edu.byu.ee.phdl.phdl.PhdlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.InstanceImpl#isInst <em>Inst</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.InstanceImpl#getArray <em>Array</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.InstanceImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.InstanceImpl#getDevice <em>Device</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.InstanceImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.InstanceImpl#isSubInst <em>Sub Inst</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.InstanceImpl#getSubDesign <em>Sub Design</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.InstanceImpl#getPrefix <em>Prefix</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InstanceImpl extends DesignElementImpl implements Instance
{
  /**
   * The default value of the '{@link #isInst() <em>Inst</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isInst()
   * @generated
   * @ordered
   */
  protected static final boolean INST_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isInst() <em>Inst</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isInst()
   * @generated
   * @ordered
   */
  protected boolean inst = INST_EDEFAULT;

  /**
   * The cached value of the '{@link #getArray() <em>Array</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArray()
   * @generated
   * @ordered
   */
  protected Array array;

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
   * The cached value of the '{@link #getDevice() <em>Device</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDevice()
   * @generated
   * @ordered
   */
  protected Device device;

  /**
   * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElements()
   * @generated
   * @ordered
   */
  protected EList<EObject> elements;

  /**
   * The default value of the '{@link #isSubInst() <em>Sub Inst</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSubInst()
   * @generated
   * @ordered
   */
  protected static final boolean SUB_INST_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSubInst() <em>Sub Inst</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSubInst()
   * @generated
   * @ordered
   */
  protected boolean subInst = SUB_INST_EDEFAULT;

  /**
   * The cached value of the '{@link #getSubDesign() <em>Sub Design</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubDesign()
   * @generated
   * @ordered
   */
  protected Design subDesign;

  /**
   * The default value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrefix()
   * @generated
   * @ordered
   */
  protected static final String PREFIX_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrefix()
   * @generated
   * @ordered
   */
  protected String prefix = PREFIX_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InstanceImpl()
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
    return PhdlPackage.Literals.INSTANCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isInst()
  {
    return inst;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInst(boolean newInst)
  {
    boolean oldInst = inst;
    inst = newInst;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.INSTANCE__INST, oldInst, inst));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Array getArray()
  {
    return array;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetArray(Array newArray, NotificationChain msgs)
  {
    Array oldArray = array;
    array = newArray;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PhdlPackage.INSTANCE__ARRAY, oldArray, newArray);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArray(Array newArray)
  {
    if (newArray != array)
    {
      NotificationChain msgs = null;
      if (array != null)
        msgs = ((InternalEObject)array).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PhdlPackage.INSTANCE__ARRAY, null, msgs);
      if (newArray != null)
        msgs = ((InternalEObject)newArray).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PhdlPackage.INSTANCE__ARRAY, null, msgs);
      msgs = basicSetArray(newArray, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.INSTANCE__ARRAY, newArray, newArray));
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
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.INSTANCE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Device getDevice()
  {
    if (device != null && device.eIsProxy())
    {
      InternalEObject oldDevice = (InternalEObject)device;
      device = (Device)eResolveProxy(oldDevice);
      if (device != oldDevice)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PhdlPackage.INSTANCE__DEVICE, oldDevice, device));
      }
    }
    return device;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Device basicGetDevice()
  {
    return device;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDevice(Device newDevice)
  {
    Device oldDevice = device;
    device = newDevice;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.INSTANCE__DEVICE, oldDevice, device));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EObject> getElements()
  {
    if (elements == null)
    {
      elements = new EObjectContainmentEList<EObject>(EObject.class, this, PhdlPackage.INSTANCE__ELEMENTS);
    }
    return elements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSubInst()
  {
    return subInst;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSubInst(boolean newSubInst)
  {
    boolean oldSubInst = subInst;
    subInst = newSubInst;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.INSTANCE__SUB_INST, oldSubInst, subInst));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Design getSubDesign()
  {
    if (subDesign != null && subDesign.eIsProxy())
    {
      InternalEObject oldSubDesign = (InternalEObject)subDesign;
      subDesign = (Design)eResolveProxy(oldSubDesign);
      if (subDesign != oldSubDesign)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PhdlPackage.INSTANCE__SUB_DESIGN, oldSubDesign, subDesign));
      }
    }
    return subDesign;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Design basicGetSubDesign()
  {
    return subDesign;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSubDesign(Design newSubDesign)
  {
    Design oldSubDesign = subDesign;
    subDesign = newSubDesign;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.INSTANCE__SUB_DESIGN, oldSubDesign, subDesign));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPrefix()
  {
    return prefix;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrefix(String newPrefix)
  {
    String oldPrefix = prefix;
    prefix = newPrefix;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.INSTANCE__PREFIX, oldPrefix, prefix));
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
      case PhdlPackage.INSTANCE__ARRAY:
        return basicSetArray(null, msgs);
      case PhdlPackage.INSTANCE__ELEMENTS:
        return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
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
      case PhdlPackage.INSTANCE__INST:
        return isInst();
      case PhdlPackage.INSTANCE__ARRAY:
        return getArray();
      case PhdlPackage.INSTANCE__NAME:
        return getName();
      case PhdlPackage.INSTANCE__DEVICE:
        if (resolve) return getDevice();
        return basicGetDevice();
      case PhdlPackage.INSTANCE__ELEMENTS:
        return getElements();
      case PhdlPackage.INSTANCE__SUB_INST:
        return isSubInst();
      case PhdlPackage.INSTANCE__SUB_DESIGN:
        if (resolve) return getSubDesign();
        return basicGetSubDesign();
      case PhdlPackage.INSTANCE__PREFIX:
        return getPrefix();
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
      case PhdlPackage.INSTANCE__INST:
        setInst((Boolean)newValue);
        return;
      case PhdlPackage.INSTANCE__ARRAY:
        setArray((Array)newValue);
        return;
      case PhdlPackage.INSTANCE__NAME:
        setName((String)newValue);
        return;
      case PhdlPackage.INSTANCE__DEVICE:
        setDevice((Device)newValue);
        return;
      case PhdlPackage.INSTANCE__ELEMENTS:
        getElements().clear();
        getElements().addAll((Collection<? extends EObject>)newValue);
        return;
      case PhdlPackage.INSTANCE__SUB_INST:
        setSubInst((Boolean)newValue);
        return;
      case PhdlPackage.INSTANCE__SUB_DESIGN:
        setSubDesign((Design)newValue);
        return;
      case PhdlPackage.INSTANCE__PREFIX:
        setPrefix((String)newValue);
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
      case PhdlPackage.INSTANCE__INST:
        setInst(INST_EDEFAULT);
        return;
      case PhdlPackage.INSTANCE__ARRAY:
        setArray((Array)null);
        return;
      case PhdlPackage.INSTANCE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case PhdlPackage.INSTANCE__DEVICE:
        setDevice((Device)null);
        return;
      case PhdlPackage.INSTANCE__ELEMENTS:
        getElements().clear();
        return;
      case PhdlPackage.INSTANCE__SUB_INST:
        setSubInst(SUB_INST_EDEFAULT);
        return;
      case PhdlPackage.INSTANCE__SUB_DESIGN:
        setSubDesign((Design)null);
        return;
      case PhdlPackage.INSTANCE__PREFIX:
        setPrefix(PREFIX_EDEFAULT);
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
      case PhdlPackage.INSTANCE__INST:
        return inst != INST_EDEFAULT;
      case PhdlPackage.INSTANCE__ARRAY:
        return array != null;
      case PhdlPackage.INSTANCE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case PhdlPackage.INSTANCE__DEVICE:
        return device != null;
      case PhdlPackage.INSTANCE__ELEMENTS:
        return elements != null && !elements.isEmpty();
      case PhdlPackage.INSTANCE__SUB_INST:
        return subInst != SUB_INST_EDEFAULT;
      case PhdlPackage.INSTANCE__SUB_DESIGN:
        return subDesign != null;
      case PhdlPackage.INSTANCE__PREFIX:
        return PREFIX_EDEFAULT == null ? prefix != null : !PREFIX_EDEFAULT.equals(prefix);
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
    result.append(" (inst: ");
    result.append(inst);
    result.append(", name: ");
    result.append(name);
    result.append(", subInst: ");
    result.append(subInst);
    result.append(", prefix: ");
    result.append(prefix);
    result.append(')');
    return result.toString();
  }

} //InstanceImpl
