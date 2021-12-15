package com.sydorchenko.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sydorchenko.command.util.Localizator;
import com.sydorchenko.constant.PagesConst;
import com.sydorchenko.dao.CourseManager;
import com.sydorchenko.dao.DBException;

/**
 * Command removing course.
 * 
 * @author Sydorchenko
 *
 */
public class RemoveCourseCommand implements Command {
	private static final long serialVersionUID = 4891935027962930630L;
	private static final Logger log = LogManager.getLogger(RemoveCourseCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DBException {
		log.debug("RemoveCourse Command starts");
		String address = PagesConst.INDEX;

		int courseId = Integer.parseInt(request.getParameter("course-id"));
		log.debug("Parameters are received.");
		CourseManager.getInstance().removeCourse(courseId);

		String message = Localizator.getLocalizedString(request, "removecourse.info_message");
		request.getSession().setAttribute("infoMessage", message);

		log.debug("RemoveCourse Command completed successfully");
		return address;
	}
}
