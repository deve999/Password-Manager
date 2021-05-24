
public class NoUpperAlphaException extends Exception {
	public NoUpperAlphaException(String message) {
		super(message);
	}
	
	public NoUpperAlphaException() {
		super("Password must contain at least one upper case letter");
	}
}
