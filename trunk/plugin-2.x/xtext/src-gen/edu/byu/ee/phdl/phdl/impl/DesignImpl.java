/**
 * <copyright>
 * </copyright>
 *

 */
package edu.byu.ee.phdl.phdl.impl;

import edu.byu.ee.phdl.phdl.Design;
import edu.byu.ee.phdl.phdl.DesignElement;
import edu.byu.ee.phdl.phdl.PhdlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Design</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.DesignImpl#isDesign <em>Design</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.DesignImpl#isSubdesign <em>Subdesign</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.DesignImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.DesignImpl#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DesignImpl extends MinimalEObjectImpl.Container implements Design
{
  /**
   * The default value of the '{@link #isDesign() <em>Design</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDesign()
   * @generated
   * @ordered
   */
  protected static final boolean DESIGN_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDesign() <em>Design</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDesign()
   * @generated
   * @ordered
   */
  protected boolean design = DESIGN_EDEFAULT;

  /**
   * The default value of the '{@link #isSubdesign() <em>Subdesign</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSubdesign()
   * @generated
   * @ordered
   */
  protected static final boolean SUBDESIGN_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSubdesign() <em>Subdesign</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSubdesign()
   * @generated
   * @ordered
   */
  protected boolean subdesign = SUBDESIGN_EDEFAULT;

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
   * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElements()
   * @generated
   * @ordered
   */
  protected EList<DesignElement> elements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DesignImpl()
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
    return PhdlPackage.Literals.DESIGN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isDesign()
  {
    return design;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDesign(boolean newDesign)
  {
    boolean oldDesign = design;
    design = newDesign;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.DESIGN__DESIGN, oldDesign, design));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSubdesign()
  {
    return subdesign;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSubdesign(boolean newSubdesign)
  {
    boolean oldSubdesign = subdesign;
    subdesign = newSubdesign;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.DESIGN__SUBDESIGN, oldSubdesign, subdesign));
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
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.DESIGN__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<DesignElement> getElements()
  {
    if (elements == null)
    {
      elements = new EObjectContainmentEList<DesignElement>(DesignElement.class, this, PhdlPackage.DESIGN__ELEMENTS);
    }
    return elements;
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
      case PhdlPackage.DESIGN__ELEMENTS:
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
      case PhdlPackage.DESIGN__DESIGN:
        return isDesign();
      case PhdlPackage.DESIGN__SUBDESIGN:
        return isSubdesign();
      case PhdlPackage.DESIGN__NAME:
        return getName();
      case PhdlPackage.DESIGN__ELEMENTS:
        return getElements();
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
      case PhdlPackage.DESIGN__DESIGN:
        setDesign((Boolean)newValue);
        return;
      case PhdlPackage.DESIGN__SUBDESIGN:
        setSubdesign((Boolean)newValue);
        return;
      case PhdlPackage.DESIGN__NAME:
        setName((String)newValue);
        return;
      case PhdlPackage.DESIGN__ELEMENTS:
        getElements().clear();
        getElements().addAll((Collection<? extends DesignElement>)newValue);
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
      case PhdlPackage.DESIGN__DESIGN:
        setDesign(DESIGN_EDEFAULT);
        return;
      case PhdlPackage.DESIGN__SUBDESIGN:
        setSubdesign(SUBDESIGN_EDEFAULT);
        return;
      case PhdlPackage.DESIGN__NAME:
        setName(NAME_EDEFAULT);
        return;
      case PhdlPackage.DESIGN__ELEMENTS:
        getElements().clear();
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
      case PhdlPackage.DESIGN__DESIGN:
        return design != DESIGN_EDEFAULT;
      case PhdlPackage.DESIGN__SUBDESIGN:
        return subdesign != SUBDESIGN_EDEFAULT;
      case PhdlPackage.DESIGN__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case PhdlPackage.DESIGN__ELEMENTS:
        return elements != null && !elements.isEmpty();
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
    result.append(" (design: ");
    result.append(design);
    result.append(", subdesign: ");
    result.append(subdesign);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //DesignImpl
