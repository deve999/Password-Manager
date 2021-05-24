
public class NoSpecialCharacterException extends Exception {
	public NoSpecialCharacterException(String message) {
		super(message);
	}
	
	public NoSpecialCharacterException() {
		super("Password must contain a special character");
	}
}
