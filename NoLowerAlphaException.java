
public class NoLowerAlphaException extends Exception {
	public NoLowerAlphaException(String message) {
		super(message);
	}
	
	public NoLowerAlphaException() {
		super("Password must contain at least one lower case letter");
	}
}
