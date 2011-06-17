package phdl.designer;

public class UndrivenPinException extends PHDLException {

	/**
	 * The Serial Version UID for this class
	 */
	private static final long serialVersionUID = 8096832829702218019L;

	int lineNum;
	String instName;

	public UndrivenPinException() {
		super();
		lineNum = -1;
		instName = null;
	}

	public UndrivenPinException(int lineNum) {
		super();
		this.lineNum = lineNum;
		this.instName = null;
	}

	public UndrivenPinException(int lineNum, String instName) {
		super();
		this.lineNum = lineNum;
		this.instName = instName;
	}

	@Override
	public String getMessage() {
		String myString = "";
		if (lineNum == -1) {
			myString = "A pin is not being driven";
		} else if (instName == null) {
			myString = "Pin on line " + lineNum + " is not being driven";
		} else {
			myString = instName + "'s pin on line " + lineNum
					+ " is not being driven";
		}
		return myString;
	}

	@Override
	public String getExceptionType() {
		return "UndrivenPinException";
	}
}
