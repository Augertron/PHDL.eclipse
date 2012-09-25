/**
 */
package edu.byu.ee.phdl.phdl.impl;

import edu.byu.ee.phdl.phdl.Assignable;
import edu.byu.ee.phdl.phdl.Concatenation;
import edu.byu.ee.phdl.phdl.ConnectionAssign;
import edu.byu.ee.phdl.phdl.ConnectionName;
import edu.byu.ee.phdl.phdl.PhdlPackage;
import edu.byu.ee.phdl.phdl.Slices;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Assign</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.ConnectionAssignImpl#getSlices <em>Slices</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.ConnectionAssignImpl#getConcatenation <em>Concatenation</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.ConnectionAssignImpl#getRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectionAssignImpl extends DesignElementImpl implements ConnectionAssign
{
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
   * The cached value of the '{@link #getConcatenation() <em>Concatenation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConcatenation()
   * @generated
   * @ordered
   */
  protected Concatenation concatenation;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConnectionAssignImpl()
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
    return PhdlPackage.Literals.CONNECTION_ASSIGN;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PhdlPackage.CONNECTION_ASSIGN__SLICES, oldSlices, newSlices);
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
        msgs = ((InternalEObject)slices).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PhdlPackage.CONNECTION_ASSIGN__SLICES, null, msgs);
      if (newSlices != null)
        msgs = ((InternalEObject)newSlices).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PhdlPackage.CONNECTION_ASSIGN__SLICES, null, msgs);
      msgs = basicSetSlices(newSlices, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.CONNECTION_ASSIGN__SLICES, newSlices, newSlices));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Concatenation getConcatenation()
  {
    return concatenation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConcatenation(Concatenation newConcatenation, NotificationChain msgs)
  {
    Concatenation oldConcatenation = concatenation;
    concatenation = newConcatenation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PhdlPackage.CONNECTION_ASSIGN__CONCATENATION, oldConcatenation, newConcatenation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConcatenation(Concatenation newConcatenation)
  {
    if (newConcatenation != concatenation)
    {
      NotificationChain msgs = null;
      if (concatenation != null)
        msgs = ((InternalEObject)concatenation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PhdlPackage.CONNECTION_ASSIGN__CONCATENATION, null, msgs);
      if (newConcatenation != null)
        msgs = ((InternalEObject)newConcatenation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PhdlPackage.CONNECTION_ASSIGN__CONCATENATION, null, msgs);
      msgs = basicSetConcatenation(newConcatenation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.CONNECTION_ASSIGN__CONCATENATION, newConcatenation, newConcatenation));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PhdlPackage.CONNECTION_ASSIGN__REF, oldRef, ref));
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
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.CONNECTION_ASSIGN__REF, oldRef, ref));
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
      case PhdlPackage.CONNECTION_ASSIGN__SLICES:
        return basicSetSlices(null, msgs);
      case PhdlPackage.CONNECTION_ASSIGN__CONCATENATION:
        return basicSetConcatenation(null, msgs);
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
      case PhdlPackage.CONNECTION_ASSIGN__SLICES:
        return getSlices();
      case PhdlPackage.CONNECTION_ASSIGN__CONCATENATION:
        return getConcatenation();
      case PhdlPackage.CONNECTION_ASSIGN__REF:
        if (resolve) return getRef();
        return basicGetRef();
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
      case PhdlPackage.CONNECTION_ASSIGN__SLICES:
        setSlices((Slices)newValue);
        return;
      case PhdlPackage.CONNECTION_ASSIGN__CONCATENATION:
        setConcatenation((Concatenation)newValue);
        return;
      case PhdlPackage.CONNECTION_ASSIGN__REF:
        setRef((ConnectionName)newValue);
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
      case PhdlPackage.CONNECTION_ASSIGN__SLICES:
        setSlices((Slices)null);
        return;
      case PhdlPackage.CONNECTION_ASSIGN__CONCATENATION:
        setConcatenation((Concatenation)null);
        return;
      case PhdlPackage.CONNECTION_ASSIGN__REF:
        setRef((ConnectionName)null);
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
      case PhdlPackage.CONNECTION_ASSIGN__SLICES:
        return slices != null;
      case PhdlPackage.CONNECTION_ASSIGN__CONCATENATION:
        return concatenation != null;
      case PhdlPackage.CONNECTION_ASSIGN__REF:
        return ref != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
  {
    if (baseClass == Assignable.class)
    {
      switch (derivedFeatureID)
      {
        case PhdlPackage.CONNECTION_ASSIGN__SLICES: return PhdlPackage.ASSIGNABLE__SLICES;
        case PhdlPackage.CONNECTION_ASSIGN__CONCATENATION: return PhdlPackage.ASSIGNABLE__CONCATENATION;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
  {
    if (baseClass == Assignable.class)
    {
      switch (baseFeatureID)
      {
        case PhdlPackage.ASSIGNABLE__SLICES: return PhdlPackage.CONNECTION_ASSIGN__SLICES;
        case PhdlPackage.ASSIGNABLE__CONCATENATION: return PhdlPackage.CONNECTION_ASSIGN__CONCATENATION;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

} //ConnectionAssignImpl
