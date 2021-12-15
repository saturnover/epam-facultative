package com.sydorchenko.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sydorchenko.command.util.Filtering;
import com.sydorchenko.constant.PagesConst;
import com.sydorchenko.dao.CourseManager;
import com.sydorchenko.dao.DBException;
import com.sydorchenko.dao.UserManager;
import com.sydorchenko.entity.Course;
import com.sydorchenko.entity.User;

public class EditCourseOpenCommand implements Command {
	private static final long serialVersionUID = -8429233116277984794L;
	private static final Logger log = LogManager.getLogger(EditCourseOpenCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DBException {
		log.debug("EditCourseOpen Command starts");
		String address = PagesConst.EDITCOURSE;

		int courseId = Integer.parseInt(request.getParameter("course-id"));
		Course editCourse = CourseManager.getInstance().getCourse(courseId);
		log.debug("Course for editing is received.");

		List<User> teachers = UserManager.getInstance().getUsers();
		teachers = Filtering.filterTeachers(teachers);
		log.debug("List of teachers is received.");

		request.getSession().setAttribute("editCourse", editCourse);
		request.setAttribute("teachers", teachers);

		log.debug("EditCourseOpen Command completed successfully");
		return address;
	}
}
