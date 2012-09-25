/**
 */
package edu.byu.ee.phdl.phdl.impl;

import edu.byu.ee.phdl.phdl.Concatenation;
import edu.byu.ee.phdl.phdl.ConnectionRef;
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
 * An implementation of the model object '<em><b>Concatenation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.ConcatenationImpl#getConnections <em>Connections</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.ConcatenationImpl#isReplicated <em>Replicated</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.ConcatenationImpl#getReplicate <em>Replicate</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.ConcatenationImpl#isOpen <em>Open</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConcatenationImpl extends MinimalEObjectImpl.Container implements Concatenation
{
  /**
   * The cached value of the '{@link #getConnections() <em>Connections</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConnections()
   * @generated
   * @ordered
   */
  protected EList<ConnectionRef> connections;

  /**
   * The default value of the '{@link #isReplicated() <em>Replicated</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isReplicated()
   * @generated
   * @ordered
   */
  protected static final boolean REPLICATED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isReplicated() <em>Replicated</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isReplicated()
   * @generated
   * @ordered
   */
  protected boolean replicated = REPLICATED_EDEFAULT;

  /**
   * The cached value of the '{@link #getReplicate() <em>Replicate</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReplicate()
   * @generated
   * @ordered
   */
  protected ConnectionRef replicate;

  /**
   * The default value of the '{@link #isOpen() <em>Open</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOpen()
   * @generated
   * @ordered
   */
  protected static final boolean OPEN_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isOpen() <em>Open</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOpen()
   * @generated
   * @ordered
   */
  protected boolean open = OPEN_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConcatenationImpl()
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
    return PhdlPackage.Literals.CONCATENATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ConnectionRef> getConnections()
  {
    if (connections == null)
    {
      connections = new EObjectContainmentEList<ConnectionRef>(ConnectionRef.class, this, PhdlPackage.CONCATENATION__CONNECTIONS);
    }
    return connections;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isReplicated()
  {
    return replicated;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReplicated(boolean newReplicated)
  {
    boolean oldReplicated = replicated;
    replicated = newReplicated;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.CONCATENATION__REPLICATED, oldReplicated, replicated));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConnectionRef getReplicate()
  {
    return replicate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReplicate(ConnectionRef newReplicate, NotificationChain msgs)
  {
    ConnectionRef oldReplicate = replicate;
    replicate = newReplicate;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PhdlPackage.CONCATENATION__REPLICATE, oldReplicate, newReplicate);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReplicate(ConnectionRef newReplicate)
  {
    if (newReplicate != replicate)
    {
      NotificationChain msgs = null;
      if (replicate != null)
        msgs = ((InternalEObject)replicate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PhdlPackage.CONCATENATION__REPLICATE, null, msgs);
      if (newReplicate != null)
        msgs = ((InternalEObject)newReplicate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PhdlPackage.CONCATENATION__REPLICATE, null, msgs);
      msgs = basicSetReplicate(newReplicate, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.CONCATENATION__REPLICATE, newReplicate, newReplicate));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isOpen()
  {
    return open;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOpen(boolean newOpen)
  {
    boolean oldOpen = open;
    open = newOpen;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.CONCATENATION__OPEN, oldOpen, open));
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
      case PhdlPackage.CONCATENATION__CONNECTIONS:
        return ((InternalEList<?>)getConnections()).basicRemove(otherEnd, msgs);
      case PhdlPackage.CONCATENATION__REPLICATE:
        return basicSetReplicate(null, msgs);
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
      case PhdlPackage.CONCATENATION__CONNECTIONS:
        return getConnections();
      case PhdlPackage.CONCATENATION__REPLICATED:
        return isReplicated();
      case PhdlPackage.CONCATENATION__REPLICATE:
        return getReplicate();
      case PhdlPackage.CONCATENATION__OPEN:
        return isOpen();
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
      case PhdlPackage.CONCATENATION__CONNECTIONS:
        getConnections().clear();
        getConnections().addAll((Collection<? extends ConnectionRef>)newValue);
        return;
      case PhdlPackage.CONCATENATION__REPLICATED:
        setReplicated((Boolean)newValue);
        return;
      case PhdlPackage.CONCATENATION__REPLICATE:
        setReplicate((ConnectionRef)newValue);
        return;
      case PhdlPackage.CONCATENATION__OPEN:
        setOpen((Boolean)newValue);
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
      case PhdlPackage.CONCATENATION__CONNECTIONS:
        getConnections().clear();
        return;
      case PhdlPackage.CONCATENATION__REPLICATED:
        setReplicated(REPLICATED_EDEFAULT);
        return;
      case PhdlPackage.CONCATENATION__REPLICATE:
        setReplicate((ConnectionRef)null);
        return;
      case PhdlPackage.CONCATENATION__OPEN:
        setOpen(OPEN_EDEFAULT);
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
      case PhdlPackage.CONCATENATION__CONNECTIONS:
        return connections != null && !connections.isEmpty();
      case PhdlPackage.CONCATENATION__REPLICATED:
        return replicated != REPLICATED_EDEFAULT;
      case PhdlPackage.CONCATENATION__REPLICATE:
        return replicate != null;
      case PhdlPackage.CONCATENATION__OPEN:
        return open != OPEN_EDEFAULT;
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
    result.append(" (replicated: ");
    result.append(replicated);
    result.append(", open: ");
    result.append(open);
    result.append(')');
    return result.toString();
  }

} //ConcatenationImpl
