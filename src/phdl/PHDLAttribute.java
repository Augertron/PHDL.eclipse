package phdl;

public class PHDLAttribute {
	private String name;
	private String value;

	public PHDLAttribute(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}

}
