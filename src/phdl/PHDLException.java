package phdl;

public abstract class PHDLException extends Exception {

	@Override
	public abstract String getMessage();

	public abstract String getExceptionType();

}
