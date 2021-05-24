
public class WeakPasswordException extends Exception {
	public WeakPasswordException(String message) {
		super(message);
	}
	
	public WeakPasswordException() {
		super("Password is weak");
	}
}
