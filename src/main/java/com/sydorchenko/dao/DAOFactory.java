package com.sydorchenko.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sydorchenko.dao.mysql.MySqlDAOFactory;

/**
 * Abstract class for DAO factory.
 * 
 * @author Sydorchenko
 *
 */
public abstract class DAOFactory {
	private static final Logger log = LogManager.getLogger(DAOFactory.class);
	public static final String MYSQL = "MySQL";

	public static DAOFactory getDAOFactory(String name) throws IllegalArgumentException {
		if (MYSQL.equalsIgnoreCase(name)) {
			log.info("Database type is MySQL");
			return MySqlDAOFactory.getInstance();
		}
		log.error("Incorrect database type was provided");
		throw new IllegalArgumentException("Wrong factory name");
	}

	public abstract UserDAO getUserDAO();

	public abstract CourseDAO getCourseDAO();

	public abstract Connection getConnection() throws SQLException;
}
