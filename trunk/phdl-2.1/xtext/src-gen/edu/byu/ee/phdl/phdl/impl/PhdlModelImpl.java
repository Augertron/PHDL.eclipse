/**
 */
package edu.byu.ee.phdl.phdl.impl;

import edu.byu.ee.phdl.phdl.Design;
import edu.byu.ee.phdl.phdl.Device;
import edu.byu.ee.phdl.phdl.Import;
import edu.byu.ee.phdl.phdl.PhdlModel;
import edu.byu.ee.phdl.phdl.PhdlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.PhdlModelImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.PhdlModelImpl#getPackages <em>Packages</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.PhdlModelImpl#getDevices <em>Devices</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.PhdlModelImpl#getDesigns <em>Designs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PhdlModelImpl extends MinimalEObjectImpl.Container implements PhdlModel
{
  /**
   * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImports()
   * @generated
   * @ordered
   */
  protected EList<Import> imports;

  /**
   * The cached value of the '{@link #getPackages() <em>Packages</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPackages()
   * @generated
   * @ordered
   */
  protected EList<edu.byu.ee.phdl.phdl.Package> packages;

  /**
   * The cached value of the '{@link #getDevices() <em>Devices</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDevices()
   * @generated
   * @ordered
   */
  protected EList<Device> devices;

  /**
   * The cached value of the '{@link #getDesigns() <em>Designs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDesigns()
   * @generated
   * @ordered
   */
  protected EList<Design> designs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PhdlModelImpl()
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
    return PhdlPackage.Literals.PHDL_MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Import> getImports()
  {
    if (imports == null)
    {
      imports = new EObjectContainmentEList<Import>(Import.class, this, PhdlPackage.PHDL_MODEL__IMPORTS);
    }
    return imports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<edu.byu.ee.phdl.phdl.Package> getPackages()
  {
    if (packages == null)
    {
      packages = new EObjectContainmentEList<edu.byu.ee.phdl.phdl.Package>(edu.byu.ee.phdl.phdl.Package.class, this, PhdlPackage.PHDL_MODEL__PACKAGES);
    }
    return packages;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Device> getDevices()
  {
    if (devices == null)
    {
      devices = new EObjectContainmentEList<Device>(Device.class, this, PhdlPackage.PHDL_MODEL__DEVICES);
    }
    return devices;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Design> getDesigns()
  {
    if (designs == null)
    {
      designs = new EObjectContainmentEList<Design>(Design.class, this, PhdlPackage.PHDL_MODEL__DESIGNS);
    }
    return designs;
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
      case PhdlPackage.PHDL_MODEL__IMPORTS:
        return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
      case PhdlPackage.PHDL_MODEL__PACKAGES:
        return ((InternalEList<?>)getPackages()).basicRemove(otherEnd, msgs);
      case PhdlPackage.PHDL_MODEL__DEVICES:
        return ((InternalEList<?>)getDevices()).basicRemove(otherEnd, msgs);
      case PhdlPackage.PHDL_MODEL__DESIGNS:
        return ((InternalEList<?>)getDesigns()).basicRemove(otherEnd, msgs);
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
      case PhdlPackage.PHDL_MODEL__IMPORTS:
        return getImports();
      case PhdlPackage.PHDL_MODEL__PACKAGES:
        return getPackages();
      case PhdlPackage.PHDL_MODEL__DEVICES:
        return getDevices();
      case PhdlPackage.PHDL_MODEL__DESIGNS:
        return getDesigns();
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
      case PhdlPackage.PHDL_MODEL__IMPORTS:
        getImports().clear();
        getImports().addAll((Collection<? extends Import>)newValue);
        return;
      case PhdlPackage.PHDL_MODEL__PACKAGES:
        getPackages().clear();
        getPackages().addAll((Collection<? extends edu.byu.ee.phdl.phdl.Package>)newValue);
        return;
      case PhdlPackage.PHDL_MODEL__DEVICES:
        getDevices().clear();
        getDevices().addAll((Collection<? extends Device>)newValue);
        return;
      case PhdlPackage.PHDL_MODEL__DESIGNS:
        getDesigns().clear();
        getDesigns().addAll((Collection<? extends Design>)newValue);
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
      case PhdlPackage.PHDL_MODEL__IMPORTS:
        getImports().clear();
        return;
      case PhdlPackage.PHDL_MODEL__PACKAGES:
        getPackages().clear();
        return;
      case PhdlPackage.PHDL_MODEL__DEVICES:
        getDevices().clear();
        return;
      case PhdlPackage.PHDL_MODEL__DESIGNS:
        getDesigns().clear();
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
      case PhdlPackage.PHDL_MODEL__IMPORTS:
        return imports != null && !imports.isEmpty();
      case PhdlPackage.PHDL_MODEL__PACKAGES:
        return packages != null && !packages.isEmpty();
      case PhdlPackage.PHDL_MODEL__DEVICES:
        return devices != null && !devices.isEmpty();
      case PhdlPackage.PHDL_MODEL__DESIGNS:
        return designs != null && !designs.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //PhdlModelImpl
