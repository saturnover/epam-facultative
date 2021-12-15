package com.sydorchenko.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sydorchenko.command.util.Filtering;
import com.sydorchenko.constant.PagesConst;
import com.sydorchenko.dao.DBException;
import com.sydorchenko.dao.UserManager;
import com.sydorchenko.entity.User;

public class CreateCourseOpenCommand implements Command {
	private static final long serialVersionUID = 6138766398997851453L;
	private static final Logger log = LogManager.getLogger(CreateCourseOpenCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DBException {
		log.debug("CreateCourseOpen Command starts");
		String address = PagesConst.CREATECOURSE;

		log.debug("Receiving teachers list.");
		List<User> teachers = UserManager.getInstance().getUsers();
		teachers = Filtering.filterTeachers(teachers);
		log.debug("Teachers list is received.");

		request.setAttribute("teachers", teachers);

		log.debug("CreateCourseOpen Command completed successfully");
		return address;
	}
}
