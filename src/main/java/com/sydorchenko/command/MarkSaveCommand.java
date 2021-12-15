package com.sydorchenko.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sydorchenko.command.util.Localizator;
import com.sydorchenko.dao.DBException;
import com.sydorchenko.dao.UserManager;

/**
 * Command of editing marks sheet.
 * 
 * @author Sydorchenko
 *
 */
public class MarkSaveCommand implements Command {
	private static final long serialVersionUID = -4568722989165113555L;
	private static final Logger log = LogManager.getLogger(MarkSaveCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DBException {
		log.debug("MarkSave Command starts");
		updateMarks(request);

		HttpSession session = request.getSession();
		session.removeAttribute("course");
		session.removeAttribute("studentsOfCourse");
		log.debug("Unused attributes are removed from session.");

		int courseId = Integer.parseInt(request.getParameter("course-id"));
		String address = "controller?command=courseinfo&course-id=" + courseId;

		String message = Localizator.getLocalizedString(request, "editmarks.info_message");
		session.setAttribute("infoMessage", message);

		log.debug("MarkSave Command completed successfully");
		return address;
	}

	/**
	 * Method of editing marks.
	 * 
	 * @param request
	 * @throws DBException
	 */
	private void updateMarks(HttpServletRequest request) throws DBException {
		log.info("Start editing marks.");

		int courseId = Integer.parseInt(request.getParameter("course-id"));
		String[] studentIds = request.getParameterValues("student-id");
		String[] marks = request.getParameterValues("mark");
		UserManager userManager = UserManager.getInstance();

		for (int i = 0; i < studentIds.length; i++) {
			int studentId = Integer.parseInt(studentIds[i]);
			int mark = Integer.parseInt(marks[i]);
			userManager.updateStudentsOfCourse(courseId, studentId, mark);
		}
		log.info("Marks were edited successfully.");
	}
}
