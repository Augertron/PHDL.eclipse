/**
 * <copyright>
 * </copyright>
 *

 */
package edu.byu.ee.phdl.phdl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Pin Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see edu.byu.ee.phdl.phdl.PhdlPackage#getPinType()
 * @model
 * @generated
 */
public enum PinType implements Enumerator
{
  /**
   * The '<em><b>Pin</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PIN_VALUE
   * @generated
   * @ordered
   */
  PIN(0, "Pin", "pin"),

  /**
   * The '<em><b>Input</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #INPUT_VALUE
   * @generated
   * @ordered
   */
  INPUT(1, "Input", "inpin"),

  /**
   * The '<em><b>Output</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #OUTPUT_VALUE
   * @generated
   * @ordered
   */
  OUTPUT(2, "Output", "outpin"),

  /**
   * The '<em><b>In Out</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IN_OUT_VALUE
   * @generated
   * @ordered
   */
  IN_OUT(3, "InOut", "iopin"),

  /**
   * The '<em><b>Power</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #POWER_VALUE
   * @generated
   * @ordered
   */
  POWER(4, "Power", "pwrpin"),

  /**
   * The '<em><b>Supply</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SUPPLY_VALUE
   * @generated
   * @ordered
   */
  SUPPLY(5, "Supply", "suppin"),

  /**
   * The '<em><b>Open Collector</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #OPEN_COLLECTOR_VALUE
   * @generated
   * @ordered
   */
  OPEN_COLLECTOR(6, "OpenCollector", "ocpin"),

  /**
   * The '<em><b>Open Emitter</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #OPEN_EMITTER_VALUE
   * @generated
   * @ordered
   */
  OPEN_EMITTER(7, "OpenEmitter", "oepin"),

  /**
   * The '<em><b>Tristate</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #TRISTATE_VALUE
   * @generated
   * @ordered
   */
  TRISTATE(8, "Tristate", "tripin"),

  /**
   * The '<em><b>Passive</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PASSIVE_VALUE
   * @generated
   * @ordered
   */
  PASSIVE(9, "Passive", "passpin"),

  /**
   * The '<em><b>No Connect</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NO_CONNECT_VALUE
   * @generated
   * @ordered
   */
  NO_CONNECT(10, "NoConnect", "ncpin");

  /**
   * The '<em><b>Pin</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Pin</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PIN
   * @model name="Pin" literal="pin"
   * @generated
   * @ordered
   */
  public static final int PIN_VALUE = 0;

  /**
   * The '<em><b>Input</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Input</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #INPUT
   * @model name="Input" literal="inpin"
   * @generated
   * @ordered
   */
  public static final int INPUT_VALUE = 1;

  /**
   * The '<em><b>Output</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Output</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #OUTPUT
   * @model name="Output" literal="outpin"
   * @generated
   * @ordered
   */
  public static final int OUTPUT_VALUE = 2;

  /**
   * The '<em><b>In Out</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>In Out</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IN_OUT
   * @model name="InOut" literal="iopin"
   * @generated
   * @ordered
   */
  public static final int IN_OUT_VALUE = 3;

  /**
   * The '<em><b>Power</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Power</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #POWER
   * @model name="Power" literal="pwrpin"
   * @generated
   * @ordered
   */
  public static final int POWER_VALUE = 4;

  /**
   * The '<em><b>Supply</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Supply</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SUPPLY
   * @model name="Supply" literal="suppin"
   * @generated
   * @ordered
   */
  public static final int SUPPLY_VALUE = 5;

  /**
   * The '<em><b>Open Collector</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Open Collector</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #OPEN_COLLECTOR
   * @model name="OpenCollector" literal="ocpin"
   * @generated
   * @ordered
   */
  public static final int OPEN_COLLECTOR_VALUE = 6;

  /**
   * The '<em><b>Open Emitter</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Open Emitter</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #OPEN_EMITTER
   * @model name="OpenEmitter" literal="oepin"
   * @generated
   * @ordered
   */
  public static final int OPEN_EMITTER_VALUE = 7;

  /**
   * The '<em><b>Tristate</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Tristate</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #TRISTATE
   * @model name="Tristate" literal="tripin"
   * @generated
   * @ordered
   */
  public static final int TRISTATE_VALUE = 8;

  /**
   * The '<em><b>Passive</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Passive</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PASSIVE
   * @model name="Passive" literal="passpin"
   * @generated
   * @ordered
   */
  public static final int PASSIVE_VALUE = 9;

  /**
   * The '<em><b>No Connect</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>No Connect</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #NO_CONNECT
   * @model name="NoConnect" literal="ncpin"
   * @generated
   * @ordered
   */
  public static final int NO_CONNECT_VALUE = 10;

  /**
   * An array of all the '<em><b>Pin Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final PinType[] VALUES_ARRAY =
    new PinType[]
    {
      PIN,
      INPUT,
      OUTPUT,
      IN_OUT,
      POWER,
      SUPPLY,
      OPEN_COLLECTOR,
      OPEN_EMITTER,
      TRISTATE,
      PASSIVE,
      NO_CONNECT,
    };

  /**
   * A public read-only list of all the '<em><b>Pin Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<PinType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Pin Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PinType get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      PinType result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Pin Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PinType getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      PinType result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Pin Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PinType get(int value)
  {
    switch (value)
    {
      case PIN_VALUE: return PIN;
      case INPUT_VALUE: return INPUT;
      case OUTPUT_VALUE: return OUTPUT;
      case IN_OUT_VALUE: return IN_OUT;
      case POWER_VALUE: return POWER;
      case SUPPLY_VALUE: return SUPPLY;
      case OPEN_COLLECTOR_VALUE: return OPEN_COLLECTOR;
      case OPEN_EMITTER_VALUE: return OPEN_EMITTER;
      case TRISTATE_VALUE: return TRISTATE;
      case PASSIVE_VALUE: return PASSIVE;
      case NO_CONNECT_VALUE: return NO_CONNECT;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private PinType(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
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
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //PinType
