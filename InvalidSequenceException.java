
public class InvalidSequenceException extends Exception {
	public InvalidSequenceException(String message) {
		super(message);
	}
	
	public InvalidSequenceException() {
		super("Password should not have more than 2"
				+ " characters repeated in sequence");
	}

}
