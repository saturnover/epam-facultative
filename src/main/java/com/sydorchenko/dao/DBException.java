package com.sydorchenko.dao;

/**
 * Own exception, thrown instead of catched ones.
 * 
 * @author Sydorchenko
 *
 */
public class DBException extends Exception {
	private static final long serialVersionUID = 3460519532785425438L;

	public DBException(String message, Throwable cause) {
		super(message, cause);
	}

	public DBException(String message) {
		super(message);
	}
}
