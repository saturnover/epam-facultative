package com.sydorchenko.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sydorchenko.constant.PagesConst;
import com.sydorchenko.dao.DBException;
import com.sydorchenko.dao.UserManager;
import com.sydorchenko.entity.Course;
import com.sydorchenko.entity.CourseStudent;

/**
 * Command of opening marks sheet.
 * 
 * @author Sydorchenko
 *
 */
public class MarkOpenCommand implements Command {
	private static final long serialVersionUID = 1813362212281413887L;
	private static final Logger log = LogManager.getLogger(MarkOpenCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DBException {
		log.debug("MarkOpen Command starts");

		String address = PagesConst.MARKSHEET;
		HttpSession session = request.getSession();
		Course course = (Course) session.getAttribute("course");
		List<CourseStudent> studentsOfCourse = UserManager.getInstance().getStudentsOfCourse(course);
		log.debug("List of students of course is received.");

		session.setAttribute("studentsOfCourse", studentsOfCourse);
		log.debug("MarkOpen Command completed successfully");

		return address;
	}
}
