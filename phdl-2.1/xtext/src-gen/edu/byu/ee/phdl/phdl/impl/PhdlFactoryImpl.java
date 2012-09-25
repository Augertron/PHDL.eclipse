/**
 */
package edu.byu.ee.phdl.phdl.impl;

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
import edu.byu.ee.phdl.phdl.PhdlFactory;
import edu.byu.ee.phdl.phdl.PhdlModel;
import edu.byu.ee.phdl.phdl.PhdlPackage;
import edu.byu.ee.phdl.phdl.Pin;
import edu.byu.ee.phdl.phdl.PinAssign;
import edu.byu.ee.phdl.phdl.PinType;
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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PhdlFactoryImpl extends EFactoryImpl implements PhdlFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PhdlFactory init()
  {
    try
    {
      PhdlFactory thePhdlFactory = (PhdlFactory)EPackage.Registry.INSTANCE.getEFactory("http://phdl.sf.net"); 
      if (thePhdlFactory != null)
      {
        return thePhdlFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new PhdlFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PhdlFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case PhdlPackage.PHDL_MODEL: return createPhdlModel();
      case PhdlPackage.PACKAGE: return createPackage();
      case PhdlPackage.IMPORT: return createImport();
      case PhdlPackage.DEVICE: return createDevice();
      case PhdlPackage.DEVICE_ELEMENT: return createDeviceElement();
      case PhdlPackage.ATTR: return createAttr();
      case PhdlPackage.PIN: return createPin();
      case PhdlPackage.INFO: return createInfo();
      case PhdlPackage.DESIGN: return createDesign();
      case PhdlPackage.DESIGN_ELEMENT: return createDesignElement();
      case PhdlPackage.CONNECTION: return createConnection();
      case PhdlPackage.NET_ELEMENT: return createNetElement();
      case PhdlPackage.PORT_ELEMENT: return createPortElement();
      case PhdlPackage.INSTANCE: return createInstance();
      case PhdlPackage.INSTANCE_ELEMENT: return createInstanceElement();
      case PhdlPackage.SUB_INSTANCE_ELEMENT: return createSubInstanceElement();
      case PhdlPackage.REF_ATTR: return createRefAttr();
      case PhdlPackage.PIN_ASSIGN: return createPinAssign();
      case PhdlPackage.SUB_ATTR: return createSubAttr();
      case PhdlPackage.REF_TAIL: return createRefTail();
      case PhdlPackage.PORT_ASSIGN: return createPortAssign();
      case PhdlPackage.CONNECTION_ASSIGN: return createConnectionAssign();
      case PhdlPackage.CONCATENATION: return createConcatenation();
      case PhdlPackage.CONNECTION_REF: return createConnectionRef();
      case PhdlPackage.CONNECTION_NAME: return createConnectionName();
      case PhdlPackage.INDICES: return createIndices();
      case PhdlPackage.SLICES: return createSlices();
      case PhdlPackage.VECTOR: return createVector();
      case PhdlPackage.ARRAY: return createArray();
      case PhdlPackage.QUALIFIER: return createQualifier();
      case PhdlPackage.REFERENCEABLE: return createReferenceable();
      case PhdlPackage.ASSIGNABLE: return createAssignable();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case PhdlPackage.PIN_TYPE:
        return createPinTypeFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case PhdlPackage.PIN_TYPE:
        return convertPinTypeToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PhdlModel createPhdlModel()
  {
    PhdlModelImpl phdlModel = new PhdlModelImpl();
    return phdlModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public edu.byu.ee.phdl.phdl.Package createPackage()
  {
    PackageImpl package_ = new PackageImpl();
    return package_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Import createImport()
  {
    ImportImpl import_ = new ImportImpl();
    return import_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Device createDevice()
  {
    DeviceImpl device = new DeviceImpl();
    return device;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DeviceElement createDeviceElement()
  {
    DeviceElementImpl deviceElement = new DeviceElementImpl();
    return deviceElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Attr createAttr()
  {
    AttrImpl attr = new AttrImpl();
    return attr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pin createPin()
  {
    PinImpl pin = new PinImpl();
    return pin;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Info createInfo()
  {
    InfoImpl info = new InfoImpl();
    return info;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Design createDesign()
  {
    DesignImpl design = new DesignImpl();
    return design;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DesignElement createDesignElement()
  {
    DesignElementImpl designElement = new DesignElementImpl();
    return designElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Connection createConnection()
  {
    ConnectionImpl connection = new ConnectionImpl();
    return connection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NetElement createNetElement()
  {
    NetElementImpl netElement = new NetElementImpl();
    return netElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PortElement createPortElement()
  {
    PortElementImpl portElement = new PortElementImpl();
    return portElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Instance createInstance()
  {
    InstanceImpl instance = new InstanceImpl();
    return instance;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InstanceElement createInstanceElement()
  {
    InstanceElementImpl instanceElement = new InstanceElementImpl();
    return instanceElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubInstanceElement createSubInstanceElement()
  {
    SubInstanceElementImpl subInstanceElement = new SubInstanceElementImpl();
    return subInstanceElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RefAttr createRefAttr()
  {
    RefAttrImpl refAttr = new RefAttrImpl();
    return refAttr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PinAssign createPinAssign()
  {
    PinAssignImpl pinAssign = new PinAssignImpl();
    return pinAssign;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubAttr createSubAttr()
  {
    SubAttrImpl subAttr = new SubAttrImpl();
    return subAttr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RefTail createRefTail()
  {
    RefTailImpl refTail = new RefTailImpl();
    return refTail;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PortAssign createPortAssign()
  {
    PortAssignImpl portAssign = new PortAssignImpl();
    return portAssign;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConnectionAssign createConnectionAssign()
  {
    ConnectionAssignImpl connectionAssign = new ConnectionAssignImpl();
    return connectionAssign;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Concatenation createConcatenation()
  {
    ConcatenationImpl concatenation = new ConcatenationImpl();
    return concatenation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConnectionRef createConnectionRef()
  {
    ConnectionRefImpl connectionRef = new ConnectionRefImpl();
    return connectionRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConnectionName createConnectionName()
  {
    ConnectionNameImpl connectionName = new ConnectionNameImpl();
    return connectionName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Indices createIndices()
  {
    IndicesImpl indices = new IndicesImpl();
    return indices;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Slices createSlices()
  {
    SlicesImpl slices = new SlicesImpl();
    return slices;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Vector createVector()
  {
    VectorImpl vector = new VectorImpl();
    return vector;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Array createArray()
  {
    ArrayImpl array = new ArrayImpl();
    return array;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Qualifier createQualifier()
  {
    QualifierImpl qualifier = new QualifierImpl();
    return qualifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Referenceable createReferenceable()
  {
    ReferenceableImpl referenceable = new ReferenceableImpl();
    return referenceable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Assignable createAssignable()
  {
    AssignableImpl assignable = new AssignableImpl();
    return assignable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PinType createPinTypeFromString(EDataType eDataType, String initialValue)
  {
    PinType result = PinType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertPinTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PhdlPackage getPhdlPackage()
  {
    return (PhdlPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static PhdlPackage getPackage()
  {
    return PhdlPackage.eINSTANCE;
  }

} //PhdlFactoryImpl
