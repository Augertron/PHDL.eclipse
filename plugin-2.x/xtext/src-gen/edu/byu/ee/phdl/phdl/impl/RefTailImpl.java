/**
 * <copyright>
 * </copyright>
 *

 */
package edu.byu.ee.phdl.phdl.impl;

import edu.byu.ee.phdl.phdl.Indices;
import edu.byu.ee.phdl.phdl.PhdlPackage;
import edu.byu.ee.phdl.phdl.RefTail;
import edu.byu.ee.phdl.phdl.Referenceable;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ref Tail</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.RefTailImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.RefTailImpl#getRefIndices <em>Ref Indices</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.RefTailImpl#getTail <em>Tail</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RefTailImpl extends MinimalEObjectImpl.Container implements RefTail
{
  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected Referenceable ref;

  /**
   * The cached value of the '{@link #getRefIndices() <em>Ref Indices</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefIndices()
   * @generated
   * @ordered
   */
  protected Indices refIndices;

  /**
   * The cached value of the '{@link #getTail() <em>Tail</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTail()
   * @generated
   * @ordered
   */
  protected RefTail tail;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RefTailImpl()
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
    return PhdlPackage.Literals.REF_TAIL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Referenceable getRef()
  {
    if (ref != null && ref.eIsProxy())
    {
      InternalEObject oldRef = (InternalEObject)ref;
      ref = (Referenceable)eResolveProxy(oldRef);
      if (ref != oldRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PhdlPackage.REF_TAIL__REF, oldRef, ref));
      }
    }
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Referenceable basicGetRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef(Referenceable newRef)
  {
    Referenceable oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.REF_TAIL__REF, oldRef, ref));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Indices getRefIndices()
  {
    return refIndices;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRefIndices(Indices newRefIndices, NotificationChain msgs)
  {
    Indices oldRefIndices = refIndices;
    refIndices = newRefIndices;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PhdlPackage.REF_TAIL__REF_INDICES, oldRefIndices, newRefIndices);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRefIndices(Indices newRefIndices)
  {
    if (newRefIndices != refIndices)
    {
      NotificationChain msgs = null;
      if (refIndices != null)
        msgs = ((InternalEObject)refIndices).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PhdlPackage.REF_TAIL__REF_INDICES, null, msgs);
      if (newRefIndices != null)
        msgs = ((InternalEObject)newRefIndices).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PhdlPackage.REF_TAIL__REF_INDICES, null, msgs);
      msgs = basicSetRefIndices(newRefIndices, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.REF_TAIL__REF_INDICES, newRefIndices, newRefIndices));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RefTail getTail()
  {
    return tail;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTail(RefTail newTail, NotificationChain msgs)
  {
    RefTail oldTail = tail;
    tail = newTail;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PhdlPackage.REF_TAIL__TAIL, oldTail, newTail);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTail(RefTail newTail)
  {
    if (newTail != tail)
    {
      NotificationChain msgs = null;
      if (tail != null)
        msgs = ((InternalEObject)tail).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PhdlPackage.REF_TAIL__TAIL, null, msgs);
      if (newTail != null)
        msgs = ((InternalEObject)newTail).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PhdlPackage.REF_TAIL__TAIL, null, msgs);
      msgs = basicSetTail(newTail, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.REF_TAIL__TAIL, newTail, newTail));
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
      case PhdlPackage.REF_TAIL__REF_INDICES:
        return basicSetRefIndices(null, msgs);
      case PhdlPackage.REF_TAIL__TAIL:
        return basicSetTail(null, msgs);
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
      case PhdlPackage.REF_TAIL__REF:
        if (resolve) return getRef();
        return basicGetRef();
      case PhdlPackage.REF_TAIL__REF_INDICES:
        return getRefIndices();
      case PhdlPackage.REF_TAIL__TAIL:
        return getTail();
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
      case PhdlPackage.REF_TAIL__REF:
        setRef((Referenceable)newValue);
        return;
      case PhdlPackage.REF_TAIL__REF_INDICES:
        setRefIndices((Indices)newValue);
        return;
      case PhdlPackage.REF_TAIL__TAIL:
        setTail((RefTail)newValue);
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
      case PhdlPackage.REF_TAIL__REF:
        setRef((Referenceable)null);
        return;
      case PhdlPackage.REF_TAIL__REF_INDICES:
        setRefIndices((Indices)null);
        return;
      case PhdlPackage.REF_TAIL__TAIL:
        setTail((RefTail)null);
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
      case PhdlPackage.REF_TAIL__REF:
        return ref != null;
      case PhdlPackage.REF_TAIL__REF_INDICES:
        return refIndices != null;
      case PhdlPackage.REF_TAIL__TAIL:
        return tail != null;
    }
    return super.eIsSet(featureID);
  }

} //RefTailImpl
