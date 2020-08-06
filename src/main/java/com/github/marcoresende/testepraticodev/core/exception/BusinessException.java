package com.github.marcoresende.testepraticodev.core.exception;

import java.text.MessageFormat;

public class BusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public BusinessException(String message) {
		super(message);
	}
	
	public BusinessException(String message, Object ... params) {
		super(MessageFormat.format(message, params));
	}
	
	public BusinessException(String message, Throwable cause) {
	    super(message, cause);
	}
	
	public BusinessException(String message, Throwable cause, Object ... params) {
	    super(MessageFormat.format(message, params), cause);
	}
	
	public BusinessException() {
	    super();
	}

}
