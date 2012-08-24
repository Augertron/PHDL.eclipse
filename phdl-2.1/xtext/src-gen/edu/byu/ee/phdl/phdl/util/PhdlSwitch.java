/**
 */
package edu.byu.ee.phdl.phdl.util;

import edu.byu.ee.phdl.phdl.Array;
import edu.byu.ee.phdl.phdl.Assignable;
import edu.byu.ee.phdl.phdl.Attr;
import edu.byu.ee.phdl.phdl.Concatenation;
import edu.byu.ee.phdl.phdl.Connection;
import edu.byu.ee.phdl.phdl.ConnectionAssign;
import edu.byu.ee.phdl.phdl.ConnectionName;
import edu.byu.ee.phdl.phdl.ConnectionRef;
import edu.byu.ee.phdl.phdl.Design;
import edu.byu.ee.phdl.phdl.DesignElement;
import edu.byu.ee.phdl.phdl.Device;
import edu.byu.ee.phdl.phdl.DeviceElement;
import edu.byu.ee.phdl.phdl.Import;
import edu.byu.ee.phdl.phdl.Indices;
import edu.byu.ee.phdl.phdl.Info;
import edu.byu.ee.phdl.phdl.Instance;
import edu.byu.ee.phdl.phdl.InstanceElement;
import edu.byu.ee.phdl.phdl.NetElement;
import edu.byu.ee.phdl.phdl.NewAttr;
import edu.byu.ee.phdl.phdl.PhdlModel;
import edu.byu.ee.phdl.phdl.PhdlPackage;
import edu.byu.ee.phdl.phdl.Pin;
import edu.byu.ee.phdl.phdl.PinAssign;
import edu.byu.ee.phdl.phdl.PortAssign;
import edu.byu.ee.phdl.phdl.PortElement;
import edu.byu.ee.phdl.phdl.Qualifier;
import edu.byu.ee.phdl.phdl.RefAttr;
import edu.byu.ee.phdl.phdl.RefTail;
import edu.byu.ee.phdl.phdl.Referenceable;
import edu.byu.ee.phdl.phdl.Slices;
import edu.byu.ee.phdl.phdl.SubAttr;
import edu.byu.ee.phdl.phdl.SubInstanceElement;
import edu.byu.ee.phdl.phdl.Vector;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see edu.byu.ee.phdl.phdl.PhdlPackage
 * @generated
 */
public class PhdlSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static PhdlPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PhdlSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = PhdlPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case PhdlPackage.PHDL_MODEL:
      {
        PhdlModel phdlModel = (PhdlModel)theEObject;
        T result = casePhdlModel(phdlModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.PACKAGE:
      {
        edu.byu.ee.phdl.phdl.Package package_ = (edu.byu.ee.phdl.phdl.Package)theEObject;
        T result = casePackage(package_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.IMPORT:
      {
        Import import_ = (Import)theEObject;
        T result = caseImport(import_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.DEVICE:
      {
        Device device = (Device)theEObject;
        T result = caseDevice(device);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.DEVICE_ELEMENT:
      {
        DeviceElement deviceElement = (DeviceElement)theEObject;
        T result = caseDeviceElement(deviceElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.ATTR:
      {
        Attr attr = (Attr)theEObject;
        T result = caseAttr(attr);
        if (result == null) result = caseDeviceElement(attr);
        if (result == null) result = caseNetElement(attr);
        if (result == null) result = caseSubInstanceElement(attr);
        if (result == null) result = caseReferenceable(attr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.PIN:
      {
        Pin pin = (Pin)theEObject;
        T result = casePin(pin);
        if (result == null) result = caseDeviceElement(pin);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.INFO:
      {
        Info info = (Info)theEObject;
        T result = caseInfo(info);
        if (result == null) result = caseDeviceElement(info);
        if (result == null) result = caseDesignElement(info);
        if (result == null) result = caseNetElement(info);
        if (result == null) result = casePortElement(info);
        if (result == null) result = caseInstanceElement(info);
        if (result == null) result = caseSubInstanceElement(info);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.DESIGN:
      {
        Design design = (Design)theEObject;
        T result = caseDesign(design);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.DESIGN_ELEMENT:
      {
        DesignElement designElement = (DesignElement)theEObject;
        T result = caseDesignElement(designElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.CONNECTION:
      {
        Connection connection = (Connection)theEObject;
        T result = caseConnection(connection);
        if (result == null) result = caseDesignElement(connection);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.NET_ELEMENT:
      {
        NetElement netElement = (NetElement)theEObject;
        T result = caseNetElement(netElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.PORT_ELEMENT:
      {
        PortElement portElement = (PortElement)theEObject;
        T result = casePortElement(portElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.INSTANCE:
      {
        Instance instance = (Instance)theEObject;
        T result = caseInstance(instance);
        if (result == null) result = caseDesignElement(instance);
        if (result == null) result = caseReferenceable(instance);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.INSTANCE_ELEMENT:
      {
        InstanceElement instanceElement = (InstanceElement)theEObject;
        T result = caseInstanceElement(instanceElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.SUB_INSTANCE_ELEMENT:
      {
        SubInstanceElement subInstanceElement = (SubInstanceElement)theEObject;
        T result = caseSubInstanceElement(subInstanceElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.REF_ATTR:
      {
        RefAttr refAttr = (RefAttr)theEObject;
        T result = caseRefAttr(refAttr);
        if (result == null) result = caseInstanceElement(refAttr);
        if (result == null) result = caseReferenceable(refAttr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.NEW_ATTR:
      {
        NewAttr newAttr = (NewAttr)theEObject;
        T result = caseNewAttr(newAttr);
        if (result == null) result = caseInstanceElement(newAttr);
        if (result == null) result = caseReferenceable(newAttr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.PIN_ASSIGN:
      {
        PinAssign pinAssign = (PinAssign)theEObject;
        T result = casePinAssign(pinAssign);
        if (result == null) result = caseInstanceElement(pinAssign);
        if (result == null) result = caseAssignable(pinAssign);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.SUB_ATTR:
      {
        SubAttr subAttr = (SubAttr)theEObject;
        T result = caseSubAttr(subAttr);
        if (result == null) result = caseSubInstanceElement(subAttr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.REF_TAIL:
      {
        RefTail refTail = (RefTail)theEObject;
        T result = caseRefTail(refTail);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.PORT_ASSIGN:
      {
        PortAssign portAssign = (PortAssign)theEObject;
        T result = casePortAssign(portAssign);
        if (result == null) result = caseSubInstanceElement(portAssign);
        if (result == null) result = caseAssignable(portAssign);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.CONNECTION_ASSIGN:
      {
        ConnectionAssign connectionAssign = (ConnectionAssign)theEObject;
        T result = caseConnectionAssign(connectionAssign);
        if (result == null) result = caseDesignElement(connectionAssign);
        if (result == null) result = caseAssignable(connectionAssign);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.CONCATENATION:
      {
        Concatenation concatenation = (Concatenation)theEObject;
        T result = caseConcatenation(concatenation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.CONNECTION_REF:
      {
        ConnectionRef connectionRef = (ConnectionRef)theEObject;
        T result = caseConnectionRef(connectionRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.CONNECTION_NAME:
      {
        ConnectionName connectionName = (ConnectionName)theEObject;
        T result = caseConnectionName(connectionName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.INDICES:
      {
        Indices indices = (Indices)theEObject;
        T result = caseIndices(indices);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.SLICES:
      {
        Slices slices = (Slices)theEObject;
        T result = caseSlices(slices);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.VECTOR:
      {
        Vector vector = (Vector)theEObject;
        T result = caseVector(vector);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.ARRAY:
      {
        Array array = (Array)theEObject;
        T result = caseArray(array);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.QUALIFIER:
      {
        Qualifier qualifier = (Qualifier)theEObject;
        T result = caseQualifier(qualifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.REFERENCEABLE:
      {
        Referenceable referenceable = (Referenceable)theEObject;
        T result = caseReferenceable(referenceable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PhdlPackage.ASSIGNABLE:
      {
        Assignable assignable = (Assignable)theEObject;
        T result = caseAssignable(assignable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePhdlModel(PhdlModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Package</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Package</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePackage(edu.byu.ee.phdl.phdl.Package object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Import</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImport(Import object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Device</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Device</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDevice(Device object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Device Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Device Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeviceElement(DeviceElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttr(Attr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pin</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pin</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePin(Pin object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Info</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Info</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInfo(Info object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Design</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Design</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDesign(Design object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Design Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Design Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDesignElement(DesignElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Connection</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Connection</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConnection(Connection object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Net Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Net Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNetElement(NetElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Port Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Port Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePortElement(PortElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Instance</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Instance</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInstance(Instance object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Instance Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Instance Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInstanceElement(InstanceElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sub Instance Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sub Instance Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubInstanceElement(SubInstanceElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ref Attr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ref Attr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRefAttr(RefAttr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>New Attr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>New Attr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNewAttr(NewAttr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pin Assign</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pin Assign</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePinAssign(PinAssign object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sub Attr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sub Attr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubAttr(SubAttr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ref Tail</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ref Tail</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRefTail(RefTail object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Port Assign</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Port Assign</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePortAssign(PortAssign object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Connection Assign</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Connection Assign</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConnectionAssign(ConnectionAssign object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Concatenation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Concatenation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConcatenation(Concatenation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Connection Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Connection Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConnectionRef(ConnectionRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Connection Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Connection Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConnectionName(ConnectionName object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Indices</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Indices</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIndices(Indices object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Slices</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Slices</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSlices(Slices object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Vector</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Vector</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVector(Vector object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Array</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Array</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArray(Array object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Qualifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Qualifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQualifier(Qualifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Referenceable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Referenceable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReferenceable(Referenceable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Assignable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Assignable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssignable(Assignable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //PhdlSwitch
