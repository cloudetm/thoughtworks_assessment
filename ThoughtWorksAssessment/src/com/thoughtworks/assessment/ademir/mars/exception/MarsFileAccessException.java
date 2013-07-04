package com.thoughtworks.assessment.ademir.mars.exception;

/**
 * @author Ademir Constantino
 * 
 * EXCEPTION REFFERED TO FILE ACCESS AND I/O ERRORS
 */
public class MarsFileAccessException extends Exception {
	
	/**
	 * Default construction for this class expecting
	 * the message cause for the exception
	 * 
	 * @param cause Error message
	 */
	public MarsFileAccessException(String cause) {
		super(cause);
		System.out.println(cause);
	}

}
