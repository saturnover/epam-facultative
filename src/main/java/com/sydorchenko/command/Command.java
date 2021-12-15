package com.sydorchenko.command;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sydorchenko.dao.DBException;

/**
 * The main interface of command pattern.
 * 
 * @author Sydorchenko
 *
 */
public interface Command extends Serializable {
	String execute(HttpServletRequest request, HttpServletResponse response) throws DBException, AppException;
}
