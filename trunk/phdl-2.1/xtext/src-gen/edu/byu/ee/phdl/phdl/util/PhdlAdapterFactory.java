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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see edu.byu.ee.phdl.phdl.PhdlPackage
 * @generated
 */
public class PhdlAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static PhdlPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PhdlAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = PhdlPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PhdlSwitch<Adapter> modelSwitch =
    new PhdlSwitch<Adapter>()
    {
      @Override
      public Adapter casePhdlModel(PhdlModel object)
      {
        return createPhdlModelAdapter();
      }
      @Override
      public Adapter casePackage(edu.byu.ee.phdl.phdl.Package object)
      {
        return createPackageAdapter();
      }
      @Override
      public Adapter caseImport(Import object)
      {
        return createImportAdapter();
      }
      @Override
      public Adapter caseDevice(Device object)
      {
        return createDeviceAdapter();
      }
      @Override
      public Adapter caseDeviceElement(DeviceElement object)
      {
        return createDeviceElementAdapter();
      }
      @Override
      public Adapter caseAttr(Attr object)
      {
        return createAttrAdapter();
      }
      @Override
      public Adapter casePin(Pin object)
      {
        return createPinAdapter();
      }
      @Override
      public Adapter caseInfo(Info object)
      {
        return createInfoAdapter();
      }
      @Override
      public Adapter caseDesign(Design object)
      {
        return createDesignAdapter();
      }
      @Override
      public Adapter caseDesignElement(DesignElement object)
      {
        return createDesignElementAdapter();
      }
      @Override
      public Adapter caseConnection(Connection object)
      {
        return createConnectionAdapter();
      }
      @Override
      public Adapter caseNetElement(NetElement object)
      {
        return createNetElementAdapter();
      }
      @Override
      public Adapter casePortElement(PortElement object)
      {
        return createPortElementAdapter();
      }
      @Override
      public Adapter caseInstance(Instance object)
      {
        return createInstanceAdapter();
      }
      @Override
      public Adapter caseInstanceElement(InstanceElement object)
      {
        return createInstanceElementAdapter();
      }
      @Override
      public Adapter caseSubInstanceElement(SubInstanceElement object)
      {
        return createSubInstanceElementAdapter();
      }
      @Override
      public Adapter caseRefAttr(RefAttr object)
      {
        return createRefAttrAdapter();
      }
      @Override
      public Adapter caseNewAttr(NewAttr object)
      {
        return createNewAttrAdapter();
      }
      @Override
      public Adapter casePinAssign(PinAssign object)
      {
        return createPinAssignAdapter();
      }
      @Override
      public Adapter caseSubAttr(SubAttr object)
      {
        return createSubAttrAdapter();
      }
      @Override
      public Adapter caseRefTail(RefTail object)
      {
        return createRefTailAdapter();
      }
      @Override
      public Adapter casePortAssign(PortAssign object)
      {
        return createPortAssignAdapter();
      }
      @Override
      public Adapter caseConnectionAssign(ConnectionAssign object)
      {
        return createConnectionAssignAdapter();
      }
      @Override
      public Adapter caseConcatenation(Concatenation object)
      {
        return createConcatenationAdapter();
      }
      @Override
      public Adapter caseConnectionRef(ConnectionRef object)
      {
        return createConnectionRefAdapter();
      }
      @Override
      public Adapter caseConnectionName(ConnectionName object)
      {
        return createConnectionNameAdapter();
      }
      @Override
      public Adapter caseIndices(Indices object)
      {
        return createIndicesAdapter();
      }
      @Override
      public Adapter caseSlices(Slices object)
      {
        return createSlicesAdapter();
      }
      @Override
      public Adapter caseVector(Vector object)
      {
        return createVectorAdapter();
      }
      @Override
      public Adapter caseArray(Array object)
      {
        return createArrayAdapter();
      }
      @Override
      public Adapter caseQualifier(Qualifier object)
      {
        return createQualifierAdapter();
      }
      @Override
      public Adapter caseReferenceable(Referenceable object)
      {
        return createReferenceableAdapter();
      }
      @Override
      public Adapter caseAssignable(Assignable object)
      {
        return createAssignableAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.PhdlModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.PhdlModel
   * @generated
   */
  public Adapter createPhdlModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.Package <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.Package
   * @generated
   */
  public Adapter createPackageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.Import
   * @generated
   */
  public Adapter createImportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.Device <em>Device</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.Device
   * @generated
   */
  public Adapter createDeviceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.DeviceElement <em>Device Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.DeviceElement
   * @generated
   */
  public Adapter createDeviceElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.Attr <em>Attr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.Attr
   * @generated
   */
  public Adapter createAttrAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.Pin <em>Pin</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.Pin
   * @generated
   */
  public Adapter createPinAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.Info <em>Info</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.Info
   * @generated
   */
  public Adapter createInfoAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.Design <em>Design</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.Design
   * @generated
   */
  public Adapter createDesignAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.DesignElement <em>Design Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.DesignElement
   * @generated
   */
  public Adapter createDesignElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.Connection <em>Connection</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.Connection
   * @generated
   */
  public Adapter createConnectionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.NetElement <em>Net Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.NetElement
   * @generated
   */
  public Adapter createNetElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.PortElement <em>Port Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.PortElement
   * @generated
   */
  public Adapter createPortElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.Instance <em>Instance</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.Instance
   * @generated
   */
  public Adapter createInstanceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.InstanceElement <em>Instance Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.InstanceElement
   * @generated
   */
  public Adapter createInstanceElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.SubInstanceElement <em>Sub Instance Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.SubInstanceElement
   * @generated
   */
  public Adapter createSubInstanceElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.RefAttr <em>Ref Attr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.RefAttr
   * @generated
   */
  public Adapter createRefAttrAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.NewAttr <em>New Attr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.NewAttr
   * @generated
   */
  public Adapter createNewAttrAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.PinAssign <em>Pin Assign</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.PinAssign
   * @generated
   */
  public Adapter createPinAssignAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.SubAttr <em>Sub Attr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.SubAttr
   * @generated
   */
  public Adapter createSubAttrAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.RefTail <em>Ref Tail</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.RefTail
   * @generated
   */
  public Adapter createRefTailAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.PortAssign <em>Port Assign</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.PortAssign
   * @generated
   */
  public Adapter createPortAssignAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.ConnectionAssign <em>Connection Assign</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.ConnectionAssign
   * @generated
   */
  public Adapter createConnectionAssignAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.Concatenation <em>Concatenation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.Concatenation
   * @generated
   */
  public Adapter createConcatenationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.ConnectionRef <em>Connection Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.ConnectionRef
   * @generated
   */
  public Adapter createConnectionRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.ConnectionName <em>Connection Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.ConnectionName
   * @generated
   */
  public Adapter createConnectionNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.Indices <em>Indices</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.Indices
   * @generated
   */
  public Adapter createIndicesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.Slices <em>Slices</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.Slices
   * @generated
   */
  public Adapter createSlicesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.Vector <em>Vector</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.Vector
   * @generated
   */
  public Adapter createVectorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.Array <em>Array</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.Array
   * @generated
   */
  public Adapter createArrayAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.Qualifier <em>Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.Qualifier
   * @generated
   */
  public Adapter createQualifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.Referenceable <em>Referenceable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.Referenceable
   * @generated
   */
  public Adapter createReferenceableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.byu.ee.phdl.phdl.Assignable <em>Assignable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.byu.ee.phdl.phdl.Assignable
   * @generated
   */
  public Adapter createAssignableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //PhdlAdapterFactory
