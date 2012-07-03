/**
 * <copyright>
 * </copyright>
 *

 */
package edu.byu.ee.phdl.phdl.impl;

import edu.byu.ee.phdl.phdl.PhdlPackage;
import edu.byu.ee.phdl.phdl.Slices;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Slices</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.SlicesImpl#getMsb <em>Msb</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.SlicesImpl#isVector <em>Vector</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.SlicesImpl#getLsb <em>Lsb</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.SlicesImpl#getSlices <em>Slices</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SlicesImpl extends MinimalEObjectImpl.Container implements Slices
{
  /**
   * The default value of the '{@link #getMsb() <em>Msb</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMsb()
   * @generated
   * @ordered
   */
  protected static final int MSB_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getMsb() <em>Msb</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMsb()
   * @generated
   * @ordered
   */
  protected int msb = MSB_EDEFAULT;

  /**
   * The default value of the '{@link #isVector() <em>Vector</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isVector()
   * @generated
   * @ordered
   */
  protected static final boolean VECTOR_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isVector() <em>Vector</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isVector()
   * @generated
   * @ordered
   */
  protected boolean vector = VECTOR_EDEFAULT;

  /**
   * The default value of the '{@link #getLsb() <em>Lsb</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLsb()
   * @generated
   * @ordered
   */
  protected static final int LSB_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getLsb() <em>Lsb</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLsb()
   * @generated
   * @ordered
   */
  protected int lsb = LSB_EDEFAULT;

  /**
   * The cached value of the '{@link #getSlices() <em>Slices</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSlices()
   * @generated
   * @ordered
   */
  protected EList<Integer> slices;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SlicesImpl()
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
    return PhdlPackage.Literals.SLICES;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getMsb()
  {
    return msb;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMsb(int newMsb)
  {
    int oldMsb = msb;
    msb = newMsb;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.SLICES__MSB, oldMsb, msb));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isVector()
  {
    return vector;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVector(boolean newVector)
  {
    boolean oldVector = vector;
    vector = newVector;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.SLICES__VECTOR, oldVector, vector));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getLsb()
  {
    return lsb;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLsb(int newLsb)
  {
    int oldLsb = lsb;
    lsb = newLsb;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.SLICES__LSB, oldLsb, lsb));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Integer> getSlices()
  {
    if (slices == null)
    {
      slices = new EDataTypeEList<Integer>(Integer.class, this, PhdlPackage.SLICES__SLICES);
    }
    return slices;
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
      case PhdlPackage.SLICES__MSB:
        return getMsb();
      case PhdlPackage.SLICES__VECTOR:
        return isVector();
      case PhdlPackage.SLICES__LSB:
        return getLsb();
      case PhdlPackage.SLICES__SLICES:
        return getSlices();
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
      case PhdlPackage.SLICES__MSB:
        setMsb((Integer)newValue);
        return;
      case PhdlPackage.SLICES__VECTOR:
        setVector((Boolean)newValue);
        return;
      case PhdlPackage.SLICES__LSB:
        setLsb((Integer)newValue);
        return;
      case PhdlPackage.SLICES__SLICES:
        getSlices().clear();
        getSlices().addAll((Collection<? extends Integer>)newValue);
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
      case PhdlPackage.SLICES__MSB:
        setMsb(MSB_EDEFAULT);
        return;
      case PhdlPackage.SLICES__VECTOR:
        setVector(VECTOR_EDEFAULT);
        return;
      case PhdlPackage.SLICES__LSB:
        setLsb(LSB_EDEFAULT);
        return;
      case PhdlPackage.SLICES__SLICES:
        getSlices().clear();
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
      case PhdlPackage.SLICES__MSB:
        return msb != MSB_EDEFAULT;
      case PhdlPackage.SLICES__VECTOR:
        return vector != VECTOR_EDEFAULT;
      case PhdlPackage.SLICES__LSB:
        return lsb != LSB_EDEFAULT;
      case PhdlPackage.SLICES__SLICES:
        return slices != null && !slices.isEmpty();
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
    result.append(" (msb: ");
    result.append(msb);
    result.append(", vector: ");
    result.append(vector);
    result.append(", lsb: ");
    result.append(lsb);
    result.append(", slices: ");
    result.append(slices);
    result.append(')');
    return result.toString();
  }

} //SlicesImpl
