package com.sydorchenko.entity;

import java.io.Serializable;

/**
 * Linking entity for courses and students class.
 * 
 * @author Sydorchenko
 *
 */
public class CourseStudent implements Serializable {
	private static final long serialVersionUID = -503199715071019318L;

	private Course course;
	private User student;
	private int mark;

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return course.getTitle();
	}
}
