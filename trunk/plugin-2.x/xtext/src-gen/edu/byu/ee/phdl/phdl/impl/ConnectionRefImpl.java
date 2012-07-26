/**
 */
package edu.byu.ee.phdl.phdl.impl;

import edu.byu.ee.phdl.phdl.ConnectionName;
import edu.byu.ee.phdl.phdl.ConnectionRef;
import edu.byu.ee.phdl.phdl.PhdlPackage;
import edu.byu.ee.phdl.phdl.Slices;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.ConnectionRefImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.ConnectionRefImpl#getSlices <em>Slices</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectionRefImpl extends MinimalEObjectImpl.Container implements ConnectionRef
{
  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected ConnectionName ref;

  /**
   * The cached value of the '{@link #getSlices() <em>Slices</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSlices()
   * @generated
   * @ordered
   */
  protected Slices slices;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConnectionRefImpl()
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
    return PhdlPackage.Literals.CONNECTION_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConnectionName getRef()
  {
    if (ref != null && ref.eIsProxy())
    {
      InternalEObject oldRef = (InternalEObject)ref;
      ref = (ConnectionName)eResolveProxy(oldRef);
      if (ref != oldRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PhdlPackage.CONNECTION_REF__REF, oldRef, ref));
      }
    }
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConnectionName basicGetRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef(ConnectionName newRef)
  {
    ConnectionName oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.CONNECTION_REF__REF, oldRef, ref));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Slices getSlices()
  {
    return slices;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSlices(Slices newSlices, NotificationChain msgs)
  {
    Slices oldSlices = slices;
    slices = newSlices;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PhdlPackage.CONNECTION_REF__SLICES, oldSlices, newSlices);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSlices(Slices newSlices)
  {
    if (newSlices != slices)
    {
      NotificationChain msgs = null;
      if (slices != null)
        msgs = ((InternalEObject)slices).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PhdlPackage.CONNECTION_REF__SLICES, null, msgs);
      if (newSlices != null)
        msgs = ((InternalEObject)newSlices).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PhdlPackage.CONNECTION_REF__SLICES, null, msgs);
      msgs = basicSetSlices(newSlices, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.CONNECTION_REF__SLICES, newSlices, newSlices));
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
      case PhdlPackage.CONNECTION_REF__SLICES:
        return basicSetSlices(null, msgs);
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
      case PhdlPackage.CONNECTION_REF__REF:
        if (resolve) return getRef();
        return basicGetRef();
      case PhdlPackage.CONNECTION_REF__SLICES:
        return getSlices();
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
      case PhdlPackage.CONNECTION_REF__REF:
        setRef((ConnectionName)newValue);
        return;
      case PhdlPackage.CONNECTION_REF__SLICES:
        setSlices((Slices)newValue);
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
      case PhdlPackage.CONNECTION_REF__REF:
        setRef((ConnectionName)null);
        return;
      case PhdlPackage.CONNECTION_REF__SLICES:
        setSlices((Slices)null);
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
      case PhdlPackage.CONNECTION_REF__REF:
        return ref != null;
      case PhdlPackage.CONNECTION_REF__SLICES:
        return slices != null;
    }
    return super.eIsSet(featureID);
  }

} //ConnectionRefImpl
