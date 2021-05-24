import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.assertTrue;

import java.io.*;
public class PasswordCheckerUtility {
	
	/*
	 * Compares the equality of the passwords
	 * @Param password First password user types
	 * @Param password Second password user types that should be the same as the first
	 */
	public static void comparePasswords (String password, String passwordConfirm) throws UnmatchedException {
		if( !(password.equals(passwordConfirm)) )
			throw new UnmatchedException("Passwords do not match");	
	}
	
	public static boolean comparePasswordsWithReturn (String password, String passwordConfirm){
		if( !(password.equals(passwordConfirm)) )
			return false;
		else
			return true;
	}
	
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
		
		ArrayList<String> incorrectPasswords = new ArrayList<String>();
		for(String e : passwords) {
			try {
				if(!isValidPassword(e))
					passwords.add(e);
			} catch (NoUpperAlphaException e1) {
				incorrectPasswords.add(e + " - Password must contain at least one upper case letter");
			} catch (NoLowerAlphaException e1) {
				incorrectPasswords.add(e + " - Password must contain at least one lower case letter");
			} catch (NoDigitException e1) {
				incorrectPasswords.add(e + " - Password must contain at least one number");
			} catch (NoSpecialCharacterException e1) {
				incorrectPasswords.add(e  +" - Password must contain a special character");
			} catch (InvalidSequenceException e1) {
				incorrectPasswords.add(e + " - Password should not have more than 2"
						+ " characters repeated in sequence");
			} catch (LengthException e1) {
				incorrectPasswords.add(e + " - Password needs to be at least 6 characters long");			}
		}
		return incorrectPasswords;
		
	
}
	
	public static boolean hasBetweenSixAndNineChars(String password) {
		if(password.length() <= 9 && password.length() >= 6 )
			return true;
		else
			return false;
	}
	
	public static boolean hasDigit(String password) throws NoDigitException {
		boolean isDigit = false;
		for(int i = 0; i < password.length(); i++) {
			if(Character.isDigit(password.charAt(i))) {
				isDigit = true;
		}
		}
		if(!isDigit) {
			throw new NoDigitException("Password must contain at least one number");
		}
		else
			return isDigit;
		
	}
	
	
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		boolean isLowerCase = false;
		for(int i = 0; i < password.length(); i++) {
			if(Character.isLowerCase(password.charAt(i))) {
				isLowerCase = true;
		}
		}
		if(!isLowerCase) {
			throw new NoLowerAlphaException("Password must contain at least one lower case letter");
		}
		else
			return isLowerCase;
		
	}
	
	public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException{
		boolean charSequence = false;
		String holdSequence;
		
		for(int i = 0; i < password.length(); i++) 
			for(int z = 1; z < password.length(); z++)  {
					if(password.charAt(i) == password.charAt(z) && z - i == 2) {
							holdSequence = password.substring(i, z + 1);
							if(holdSequence.charAt(0) == holdSequence.charAt(1))
								charSequence = true;
					}
				}	
		
		if(charSequence) {
			throw new InvalidSequenceException("Password should not have more than 2"
					+ " characters repeated in sequence");
		}
		else
			return !charSequence;
	}

	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{
		boolean specialChar = false;
		char begin = 33;
		char end = 47;
		char begin2 = 58;
		char end2 = 64;
		char begin3 = 91;
		char end3 = 96;
		char begin4 = 123;
		char end4 = 127;
		
		for(int i = 0; i < password.length(); i++) {
			char passChar = password.charAt(i);
			if( (passChar >= begin && passChar <= end) || (passChar >= begin2 && passChar <= end2)
					|| (passChar >= begin3 && passChar <= end3) || (passChar >= begin4 && passChar <= end4)){
					specialChar = true;
		      }
		
		}
		if(!specialChar) {
			throw new NoSpecialCharacterException("Password must contain a special character");
		}
		else
			return specialChar;
	
}
	
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		boolean isLowerCase = false;
		for(int i = 0; i < password.length(); i++) {
			if(Character.isUpperCase(password.charAt(i))) {
				isLowerCase = true;
		}
		}
		if(!isLowerCase) {
			throw new NoUpperAlphaException("Password must contain at least one upper case letter");
		}
		else
			return isLowerCase;
		
	}
	

	public static boolean isValidLength(String password) throws LengthException {
		
		boolean isValidSize = false;
		if(password.length() >= 6)
			isValidSize = true;
		
		if(!isValidSize) {
			throw new LengthException("Password needs to be at least 6 characters long");
		}
		else 
			return isValidSize;
		
	}
	
	public static boolean isWeakPassword(String password) throws WeakPasswordException {
		
		if(hasBetweenSixAndNineChars(password)) {
			return true;
		}
		else
			return false;
		
	}
	
	public static boolean isValidPassword(String password) throws NoUpperAlphaException,
    NoLowerAlphaException,
    NoDigitException,
    NoSpecialCharacterException,
    InvalidSequenceException,
    LengthException{
		
		if(hasUpperAlpha(password) && hasSpecialChar(password) && hasLowerAlpha(password) && 
				hasDigit(password) && hasSameCharInSequence(password) && isValidLength(password)) {
			return true;
		}
		else 
			return false;
}

}