package com.sydorchenko.command;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sydorchenko.command.util.DateUtil;
import com.sydorchenko.constant.PagesConst;
import com.sydorchenko.dao.CourseManager;
import com.sydorchenko.dao.DBException;
import com.sydorchenko.entity.Course;

public class CourseInfoCommand implements Command {
	private static final long serialVersionUID = 6998319261047909378L;
	private static final Logger log = LogManager.getLogger(CourseInfoCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DBException, AppException {
		log.debug("CourseInfo Command starts");
		String address = PagesConst.COURSEINFO;

		log.debug("Starting receiving parameters.");
		int courseId = Integer.parseInt(request.getParameter("course-id"));
		Course course = CourseManager.getInstance().getCourse(courseId);
		Date currentDate = DateUtil.getCurrentDate();
		log.debug("Parameters are received.");

		request.setAttribute("currentDate", currentDate);
		request.setAttribute("course", course);

		log.debug("CourseInfo Command completed successfully");
		return address;
	}
}
