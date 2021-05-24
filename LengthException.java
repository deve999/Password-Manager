
public class LengthException extends Exception {
	public LengthException(String message) {
		super(message);
	}
	
	public LengthException() {
		super("Password needs to be at least 6 characters long");
	}
}
