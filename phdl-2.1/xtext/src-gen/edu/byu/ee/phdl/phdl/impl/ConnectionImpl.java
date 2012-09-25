/**
 */
package edu.byu.ee.phdl.phdl.impl;

import edu.byu.ee.phdl.phdl.Connection;
import edu.byu.ee.phdl.phdl.ConnectionName;
import edu.byu.ee.phdl.phdl.PhdlPackage;
import edu.byu.ee.phdl.phdl.Vector;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.ConnectionImpl#isNet <em>Net</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.ConnectionImpl#getVector <em>Vector</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.ConnectionImpl#getNames <em>Names</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.ConnectionImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.ConnectionImpl#isPort <em>Port</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectionImpl extends DesignElementImpl implements Connection
{
  /**
   * The default value of the '{@link #isNet() <em>Net</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNet()
   * @generated
   * @ordered
   */
  protected static final boolean NET_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isNet() <em>Net</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNet()
   * @generated
   * @ordered
   */
  protected boolean net = NET_EDEFAULT;

  /**
   * The cached value of the '{@link #getVector() <em>Vector</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVector()
   * @generated
   * @ordered
   */
  protected Vector vector;

  /**
   * The cached value of the '{@link #getNames() <em>Names</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNames()
   * @generated
   * @ordered
   */
  protected EList<ConnectionName> names;

  /**
   * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElements()
   * @generated
   * @ordered
   */
  protected EList<EObject> elements;

  /**
   * The default value of the '{@link #isPort() <em>Port</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPort()
   * @generated
   * @ordered
   */
  protected static final boolean PORT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isPort() <em>Port</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPort()
   * @generated
   * @ordered
   */
  protected boolean port = PORT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConnectionImpl()
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
    return PhdlPackage.Literals.CONNECTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isNet()
  {
    return net;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNet(boolean newNet)
  {
    boolean oldNet = net;
    net = newNet;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.CONNECTION__NET, oldNet, net));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Vector getVector()
  {
    return vector;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVector(Vector newVector, NotificationChain msgs)
  {
    Vector oldVector = vector;
    vector = newVector;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PhdlPackage.CONNECTION__VECTOR, oldVector, newVector);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVector(Vector newVector)
  {
    if (newVector != vector)
    {
      NotificationChain msgs = null;
      if (vector != null)
        msgs = ((InternalEObject)vector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PhdlPackage.CONNECTION__VECTOR, null, msgs);
      if (newVector != null)
        msgs = ((InternalEObject)newVector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PhdlPackage.CONNECTION__VECTOR, null, msgs);
      msgs = basicSetVector(newVector, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.CONNECTION__VECTOR, newVector, newVector));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ConnectionName> getNames()
  {
    if (names == null)
    {
      names = new EObjectContainmentEList<ConnectionName>(ConnectionName.class, this, PhdlPackage.CONNECTION__NAMES);
    }
    return names;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EObject> getElements()
  {
    if (elements == null)
    {
      elements = new EObjectContainmentEList<EObject>(EObject.class, this, PhdlPackage.CONNECTION__ELEMENTS);
    }
    return elements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isPort()
  {
    return port;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPort(boolean newPort)
  {
    boolean oldPort = port;
    port = newPort;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.CONNECTION__PORT, oldPort, port));
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
      case PhdlPackage.CONNECTION__VECTOR:
        return basicSetVector(null, msgs);
      case PhdlPackage.CONNECTION__NAMES:
        return ((InternalEList<?>)getNames()).basicRemove(otherEnd, msgs);
      case PhdlPackage.CONNECTION__ELEMENTS:
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
      case PhdlPackage.CONNECTION__NET:
        return isNet();
      case PhdlPackage.CONNECTION__VECTOR:
        return getVector();
      case PhdlPackage.CONNECTION__NAMES:
        return getNames();
      case PhdlPackage.CONNECTION__ELEMENTS:
        return getElements();
      case PhdlPackage.CONNECTION__PORT:
        return isPort();
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
      case PhdlPackage.CONNECTION__NET:
        setNet((Boolean)newValue);
        return;
      case PhdlPackage.CONNECTION__VECTOR:
        setVector((Vector)newValue);
        return;
      case PhdlPackage.CONNECTION__NAMES:
        getNames().clear();
        getNames().addAll((Collection<? extends ConnectionName>)newValue);
        return;
      case PhdlPackage.CONNECTION__ELEMENTS:
        getElements().clear();
        getElements().addAll((Collection<? extends EObject>)newValue);
        return;
      case PhdlPackage.CONNECTION__PORT:
        setPort((Boolean)newValue);
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
      case PhdlPackage.CONNECTION__NET:
        setNet(NET_EDEFAULT);
        return;
      case PhdlPackage.CONNECTION__VECTOR:
        setVector((Vector)null);
        return;
      case PhdlPackage.CONNECTION__NAMES:
        getNames().clear();
        return;
      case PhdlPackage.CONNECTION__ELEMENTS:
        getElements().clear();
        return;
      case PhdlPackage.CONNECTION__PORT:
        setPort(PORT_EDEFAULT);
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
      case PhdlPackage.CONNECTION__NET:
        return net != NET_EDEFAULT;
      case PhdlPackage.CONNECTION__VECTOR:
        return vector != null;
      case PhdlPackage.CONNECTION__NAMES:
        return names != null && !names.isEmpty();
      case PhdlPackage.CONNECTION__ELEMENTS:
        return elements != null && !elements.isEmpty();
      case PhdlPackage.CONNECTION__PORT:
        return port != PORT_EDEFAULT;
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
    result.append(" (net: ");
    result.append(net);
    result.append(", port: ");
    result.append(port);
    result.append(')');
    return result.toString();
  }

} //ConnectionImpl
