package phdl.parser;

public class Error extends Element {

	private String message = "";

	public Error() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
