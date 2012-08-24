package org.tsk.mng.backend.exceptions;

/**
 * 
 * TODO complete this Class and add description
 * @author Dvir
 *
 */
public class OperationFailureException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2123536315304621262L;

	
	
	public OperationFailureException(String message) {
		super(message);
	}
	
	public OperationFailureException(String message,Throwable exeption) {
		super(message,exeption);
	}
	
	
}
