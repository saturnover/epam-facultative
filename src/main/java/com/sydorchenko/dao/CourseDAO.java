package com.sydorchenko.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.NavigableSet;

import com.sydorchenko.entity.Course;
import com.sydorchenko.entity.CourseStudent;
import com.sydorchenko.entity.User;

/**
 * Interface which defines methods for CourseDAO implementations.
 * 
 * @author Sydorchenko
 *
 */
public interface CourseDAO {
	NavigableSet<String> getThemes(Connection con) throws SQLException;

	Course getCourse(Connection con, int id) throws SQLException;

	List<Course> getCourses(Connection con) throws SQLException;

	List<Course> getCoursesByTeacher(Connection con, int teacherId) throws SQLException;

	List<CourseStudent> getCoursesOfStudent(Connection con, User student) throws SQLException;

	void subscribeToCourse(Connection con, int courseId, int studentId) throws SQLException;

	void removeCourse(Connection con, int id) throws SQLException;

	void updateCourse(Connection con, Course course) throws SQLException;

	void createCourse(Connection con, Course course) throws SQLException;
}
