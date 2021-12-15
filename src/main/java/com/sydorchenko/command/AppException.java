package com.sydorchenko.command;

/**
 * Own exception, thrown instead of catched ones.
 * 
 * @author Sydorchenko
 *
 */
public class AppException extends Exception {
	private static final long serialVersionUID = 3460519532785425438L;

	public AppException(String message, Throwable cause) {
		super(message, cause);
	}

	public AppException(String message) {
		super(message);
	}
}
