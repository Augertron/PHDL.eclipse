/**
 */
package edu.byu.ee.phdl.phdl.impl;

import edu.byu.ee.phdl.phdl.Indices;
import edu.byu.ee.phdl.phdl.PhdlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Indices</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.IndicesImpl#getMsb <em>Msb</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.IndicesImpl#isArray <em>Array</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.IndicesImpl#getLsb <em>Lsb</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.IndicesImpl#getIndices <em>Indices</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IndicesImpl extends MinimalEObjectImpl.Container implements Indices
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
   * The default value of the '{@link #isArray() <em>Array</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isArray()
   * @generated
   * @ordered
   */
  protected static final boolean ARRAY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isArray() <em>Array</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isArray()
   * @generated
   * @ordered
   */
  protected boolean array = ARRAY_EDEFAULT;

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
   * The cached value of the '{@link #getIndices() <em>Indices</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIndices()
   * @generated
   * @ordered
   */
  protected EList<Integer> indices;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IndicesImpl()
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
    return PhdlPackage.Literals.INDICES;
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
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.INDICES__MSB, oldMsb, msb));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isArray()
  {
    return array;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArray(boolean newArray)
  {
    boolean oldArray = array;
    array = newArray;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.INDICES__ARRAY, oldArray, array));
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
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.INDICES__LSB, oldLsb, lsb));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Integer> getIndices()
  {
    if (indices == null)
    {
      indices = new EDataTypeEList<Integer>(Integer.class, this, PhdlPackage.INDICES__INDICES);
    }
    return indices;
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
      case PhdlPackage.INDICES__MSB:
        return getMsb();
      case PhdlPackage.INDICES__ARRAY:
        return isArray();
      case PhdlPackage.INDICES__LSB:
        return getLsb();
      case PhdlPackage.INDICES__INDICES:
        return getIndices();
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
      case PhdlPackage.INDICES__MSB:
        setMsb((Integer)newValue);
        return;
      case PhdlPackage.INDICES__ARRAY:
        setArray((Boolean)newValue);
        return;
      case PhdlPackage.INDICES__LSB:
        setLsb((Integer)newValue);
        return;
      case PhdlPackage.INDICES__INDICES:
        getIndices().clear();
        getIndices().addAll((Collection<? extends Integer>)newValue);
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
      case PhdlPackage.INDICES__MSB:
        setMsb(MSB_EDEFAULT);
        return;
      case PhdlPackage.INDICES__ARRAY:
        setArray(ARRAY_EDEFAULT);
        return;
      case PhdlPackage.INDICES__LSB:
        setLsb(LSB_EDEFAULT);
        return;
      case PhdlPackage.INDICES__INDICES:
        getIndices().clear();
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
      case PhdlPackage.INDICES__MSB:
        return msb != MSB_EDEFAULT;
      case PhdlPackage.INDICES__ARRAY:
        return array != ARRAY_EDEFAULT;
      case PhdlPackage.INDICES__LSB:
        return lsb != LSB_EDEFAULT;
      case PhdlPackage.INDICES__INDICES:
        return indices != null && !indices.isEmpty();
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
    result.append(", array: ");
    result.append(array);
    result.append(", lsb: ");
    result.append(lsb);
    result.append(", indices: ");
    result.append(indices);
    result.append(')');
    return result.toString();
  }

} //IndicesImpl
