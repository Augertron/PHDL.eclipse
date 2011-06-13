package phdl;

public abstract class PHDLException extends Exception {

	/**
	 * The Serial Version UID for this class
	 */
	private static final long serialVersionUID = -7816636173565490476L;

	@Override
	public abstract String getMessage();

	public abstract String getExceptionType();

}
