package com.sydorchenko.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.sydorchenko.entity.Course;
import com.sydorchenko.entity.CourseStudent;
import com.sydorchenko.entity.User;

/**
 * Interface which defines methods for UserDAO implementations.
 * 
 * @author Sydorchenko
 *
 */
public interface UserDAO {
	User getUser(Connection con, String login) throws SQLException;

	User getUser(Connection con, int id) throws SQLException;

	List<User> getUsers(Connection con) throws SQLException;

	List<CourseStudent> getStudentsOfCourse(Connection con, Course course) throws SQLException;

	void updateStudentsOfCourse(Connection con, int courseId, int studentId, int mark) throws SQLException;

	void updateUser(Connection con, User user) throws SQLException;

	void register(Connection con, User user) throws SQLException;
}
