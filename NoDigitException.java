
public class NoDigitException extends Exception {
	public NoDigitException(String message) {
		super(message);
	}
	
	public NoDigitException() {
		super("Password must contain at least one number");
	} 
}
