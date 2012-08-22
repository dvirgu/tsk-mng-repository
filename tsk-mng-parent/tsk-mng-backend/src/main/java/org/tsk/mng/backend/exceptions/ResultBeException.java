package org.tsk.mng.backend.exceptions;

/**
 * 
 * TODO
 * @author Dvir
 *
 */
public class ResultBeException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2123536315304621262L;

	
	
	public ResultBeException(String message) {
		super(message);
	}
	
	public ResultBeException(String message,Throwable exeption) {
		super(message,exeption);
	}
	
	
}
