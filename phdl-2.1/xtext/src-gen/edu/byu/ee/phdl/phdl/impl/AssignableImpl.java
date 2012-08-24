/**
 */
package edu.byu.ee.phdl.phdl.impl;

import edu.byu.ee.phdl.phdl.Assignable;
import edu.byu.ee.phdl.phdl.Concatenation;
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
 * An implementation of the model object '<em><b>Assignable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.AssignableImpl#getSlices <em>Slices</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.AssignableImpl#getConcatenation <em>Concatenation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssignableImpl extends MinimalEObjectImpl.Container implements Assignable
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssignableImpl()
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
    return PhdlPackage.Literals.ASSIGNABLE;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PhdlPackage.ASSIGNABLE__SLICES, oldSlices, newSlices);
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
        msgs = ((InternalEObject)slices).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PhdlPackage.ASSIGNABLE__SLICES, null, msgs);
      if (newSlices != null)
        msgs = ((InternalEObject)newSlices).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PhdlPackage.ASSIGNABLE__SLICES, null, msgs);
      msgs = basicSetSlices(newSlices, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.ASSIGNABLE__SLICES, newSlices, newSlices));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PhdlPackage.ASSIGNABLE__CONCATENATION, oldConcatenation, newConcatenation);
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
        msgs = ((InternalEObject)concatenation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PhdlPackage.ASSIGNABLE__CONCATENATION, null, msgs);
      if (newConcatenation != null)
        msgs = ((InternalEObject)newConcatenation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PhdlPackage.ASSIGNABLE__CONCATENATION, null, msgs);
      msgs = basicSetConcatenation(newConcatenation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.ASSIGNABLE__CONCATENATION, newConcatenation, newConcatenation));
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
      case PhdlPackage.ASSIGNABLE__SLICES:
        return basicSetSlices(null, msgs);
      case PhdlPackage.ASSIGNABLE__CONCATENATION:
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
      case PhdlPackage.ASSIGNABLE__SLICES:
        return getSlices();
      case PhdlPackage.ASSIGNABLE__CONCATENATION:
        return getConcatenation();
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
      case PhdlPackage.ASSIGNABLE__SLICES:
        setSlices((Slices)newValue);
        return;
      case PhdlPackage.ASSIGNABLE__CONCATENATION:
        setConcatenation((Concatenation)newValue);
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
      case PhdlPackage.ASSIGNABLE__SLICES:
        setSlices((Slices)null);
        return;
      case PhdlPackage.ASSIGNABLE__CONCATENATION:
        setConcatenation((Concatenation)null);
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
      case PhdlPackage.ASSIGNABLE__SLICES:
        return slices != null;
      case PhdlPackage.ASSIGNABLE__CONCATENATION:
        return concatenation != null;
    }
    return super.eIsSet(featureID);
  }

} //AssignableImpl
