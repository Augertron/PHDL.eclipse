package phdl;
/**
 *	PHDLAttribute
 *	A class that stores a name and value.
 *
 *	For example the line of code: 'tolerance = "5%";'
 *  would translate to name = "tolerance" and value = "5%"
 *  
 *  @author		Richard Black and Brad Riching
 *  @version	0.1
 */
public class PHDLAttribute {
	/**
	 *	Contains the attribute's name 
	 */
	private String name;
	/**
	 *	Contains the attribute's value 
	 */
	private String value;

	/**
	 *	Default Constructor
	 *
	 *	Sets the name and value of the attribute
	 *
	 *	@param name	the name of the new attribute
	 *	@param name the value of the new attribute
	 */
	public PHDLAttribute(String name, String value) {
		this.name = name;
		this.value = value;
	}

	/**
	 * Returns the name of the attribute
	 * 
	 * Attribute name accessor method
	 * 
	 * @return 	a string representation of the attribute's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the attribute
	 * 
	 * Attribute name mutator method
	 * 
	 * @param name	the new name of attribute
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the value of the attribute
	 * 
	 * Attribute value accessor method
	 * 
	 * @return	a string representation of the current
	 * 			value of the attribute
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Changes the current value of the attribute
	 * 
	 * Attribute value mutator method
	 * 
	 * @param value	the new value of the attribute
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	/**
	 * Creates a hash code for use in hash data structures
	 * 
	 * hashCode method to make attributes compatible with hashMaps
	 * and hashSets
	 * 
	 * @return	an integer representing a hash code
	 */
	public int hashCode() {
		return name.hashCode();
	}

}
