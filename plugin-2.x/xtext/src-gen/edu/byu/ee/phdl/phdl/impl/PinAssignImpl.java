/**
 * <copyright>
 * </copyright>
 *

 */
package edu.byu.ee.phdl.phdl.impl;

import edu.byu.ee.phdl.phdl.Assignable;
import edu.byu.ee.phdl.phdl.Concatenation;
import edu.byu.ee.phdl.phdl.PhdlPackage;
import edu.byu.ee.phdl.phdl.Pin;
import edu.byu.ee.phdl.phdl.PinAssign;
import edu.byu.ee.phdl.phdl.Qualifier;
import edu.byu.ee.phdl.phdl.Slices;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pin Assign</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.PinAssignImpl#getSlices <em>Slices</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.PinAssignImpl#getConcatenation <em>Concatenation</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.PinAssignImpl#isCombined <em>Combined</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.PinAssignImpl#getQualifier <em>Qualifier</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.PinAssignImpl#getRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PinAssignImpl extends InstanceElementImpl implements PinAssign
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
   * The default value of the '{@link #isCombined() <em>Combined</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCombined()
   * @generated
   * @ordered
   */
  protected static final boolean COMBINED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isCombined() <em>Combined</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCombined()
   * @generated
   * @ordered
   */
  protected boolean combined = COMBINED_EDEFAULT;

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
   * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected Pin ref;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PinAssignImpl()
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
    return PhdlPackage.Literals.PIN_ASSIGN;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PhdlPackage.PIN_ASSIGN__SLICES, oldSlices, newSlices);
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
        msgs = ((InternalEObject)slices).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PhdlPackage.PIN_ASSIGN__SLICES, null, msgs);
      if (newSlices != null)
        msgs = ((InternalEObject)newSlices).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PhdlPackage.PIN_ASSIGN__SLICES, null, msgs);
      msgs = basicSetSlices(newSlices, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.PIN_ASSIGN__SLICES, newSlices, newSlices));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PhdlPackage.PIN_ASSIGN__CONCATENATION, oldConcatenation, newConcatenation);
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
        msgs = ((InternalEObject)concatenation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PhdlPackage.PIN_ASSIGN__CONCATENATION, null, msgs);
      if (newConcatenation != null)
        msgs = ((InternalEObject)newConcatenation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PhdlPackage.PIN_ASSIGN__CONCATENATION, null, msgs);
      msgs = basicSetConcatenation(newConcatenation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.PIN_ASSIGN__CONCATENATION, newConcatenation, newConcatenation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isCombined()
  {
    return combined;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCombined(boolean newCombined)
  {
    boolean oldCombined = combined;
    combined = newCombined;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.PIN_ASSIGN__COMBINED, oldCombined, combined));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PhdlPackage.PIN_ASSIGN__QUALIFIER, oldQualifier, newQualifier);
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
        msgs = ((InternalEObject)qualifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PhdlPackage.PIN_ASSIGN__QUALIFIER, null, msgs);
      if (newQualifier != null)
        msgs = ((InternalEObject)newQualifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PhdlPackage.PIN_ASSIGN__QUALIFIER, null, msgs);
      msgs = basicSetQualifier(newQualifier, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.PIN_ASSIGN__QUALIFIER, newQualifier, newQualifier));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pin getRef()
  {
    if (ref != null && ref.eIsProxy())
    {
      InternalEObject oldRef = (InternalEObject)ref;
      ref = (Pin)eResolveProxy(oldRef);
      if (ref != oldRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PhdlPackage.PIN_ASSIGN__REF, oldRef, ref));
      }
    }
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pin basicGetRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef(Pin newRef)
  {
    Pin oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.PIN_ASSIGN__REF, oldRef, ref));
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
      case PhdlPackage.PIN_ASSIGN__SLICES:
        return basicSetSlices(null, msgs);
      case PhdlPackage.PIN_ASSIGN__CONCATENATION:
        return basicSetConcatenation(null, msgs);
      case PhdlPackage.PIN_ASSIGN__QUALIFIER:
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
      case PhdlPackage.PIN_ASSIGN__SLICES:
        return getSlices();
      case PhdlPackage.PIN_ASSIGN__CONCATENATION:
        return getConcatenation();
      case PhdlPackage.PIN_ASSIGN__COMBINED:
        return isCombined();
      case PhdlPackage.PIN_ASSIGN__QUALIFIER:
        return getQualifier();
      case PhdlPackage.PIN_ASSIGN__REF:
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
      case PhdlPackage.PIN_ASSIGN__SLICES:
        setSlices((Slices)newValue);
        return;
      case PhdlPackage.PIN_ASSIGN__CONCATENATION:
        setConcatenation((Concatenation)newValue);
        return;
      case PhdlPackage.PIN_ASSIGN__COMBINED:
        setCombined((Boolean)newValue);
        return;
      case PhdlPackage.PIN_ASSIGN__QUALIFIER:
        setQualifier((Qualifier)newValue);
        return;
      case PhdlPackage.PIN_ASSIGN__REF:
        setRef((Pin)newValue);
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
      case PhdlPackage.PIN_ASSIGN__SLICES:
        setSlices((Slices)null);
        return;
      case PhdlPackage.PIN_ASSIGN__CONCATENATION:
        setConcatenation((Concatenation)null);
        return;
      case PhdlPackage.PIN_ASSIGN__COMBINED:
        setCombined(COMBINED_EDEFAULT);
        return;
      case PhdlPackage.PIN_ASSIGN__QUALIFIER:
        setQualifier((Qualifier)null);
        return;
      case PhdlPackage.PIN_ASSIGN__REF:
        setRef((Pin)null);
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
      case PhdlPackage.PIN_ASSIGN__SLICES:
        return slices != null;
      case PhdlPackage.PIN_ASSIGN__CONCATENATION:
        return concatenation != null;
      case PhdlPackage.PIN_ASSIGN__COMBINED:
        return combined != COMBINED_EDEFAULT;
      case PhdlPackage.PIN_ASSIGN__QUALIFIER:
        return qualifier != null;
      case PhdlPackage.PIN_ASSIGN__REF:
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
        case PhdlPackage.PIN_ASSIGN__SLICES: return PhdlPackage.ASSIGNABLE__SLICES;
        case PhdlPackage.PIN_ASSIGN__CONCATENATION: return PhdlPackage.ASSIGNABLE__CONCATENATION;
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
        case PhdlPackage.ASSIGNABLE__SLICES: return PhdlPackage.PIN_ASSIGN__SLICES;
        case PhdlPackage.ASSIGNABLE__CONCATENATION: return PhdlPackage.PIN_ASSIGN__CONCATENATION;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
    result.append(" (combined: ");
    result.append(combined);
    result.append(')');
    return result.toString();
  }

} //PinAssignImpl
