package com.sydorchenko.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sydorchenko.command.util.Localizator;
import com.sydorchenko.dao.CourseManager;
import com.sydorchenko.dao.DBException;
import com.sydorchenko.entity.CourseStudent;
import com.sydorchenko.entity.User;

/**
 * Command of subscription to course.
 * 
 * @author Sydorchenko
 *
 */
public class SubscribeCommand implements Command {
	private static final long serialVersionUID = -1980815358817544615L;
	private static final Logger log = LogManager.getLogger(SubscribeCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DBException {
		log.debug("Subscribe Command starts");

		int courseId = Integer.parseInt(request.getParameter("course-id"));
		int studentId = Integer.parseInt(request.getParameter("student-id"));
		log.debug("Parameters are received.");

		String address = "controller?command=courseinfo&course-id=" + courseId;
		HttpSession session = request.getSession();
		User authorizedUser = (User) session.getAttribute("authorizedUser");

		CourseManager.getInstance().subscribeToCourse(courseId, studentId);
		List<CourseStudent> list = CourseManager.getInstance().getCoursesOfStudent(authorizedUser);
		session.setAttribute("fullList", list);
		log.debug("Substituted list of student's courses in session.");

		String message = Localizator.getLocalizedString(request, "subscribe.info_message");
		session.setAttribute("infoMessage", message);

		log.debug("Subscribe Command completed successfully");
		return address;
	}
}