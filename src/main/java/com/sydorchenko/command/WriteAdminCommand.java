package com.sydorchenko.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sydorchenko.command.util.Localizator;
import com.sydorchenko.command.util.MessageSender;
import com.sydorchenko.constant.AdminConst;
import com.sydorchenko.constant.PagesConst;

/**
 * Command of sending email to admin.
 * 
 * @author Sydorchenko
 *
 */
public class WriteAdminCommand implements Command {
	private static final long serialVersionUID = -243068662469929912L;
	private static final Logger log = LogManager.getLogger(WriteAdminCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("Write Admin Command starts");
		String address = PagesConst.CONTACT;

		log.debug("Starting getting parameters for sending email.");
		String name = request.getParameter("name");
		String from = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");

		String to = AdminConst.ADMIN_EMAIL;
		String sendMessage = "Name: " + name + System.lineSeparator() + "Email: " + from + System.lineSeparator()
				+ message;
		log.debug("All parameters are received.");

		MessageSender.sendMessage(to, subject, sendMessage);
		String infoMessage = Localizator.getLocalizedString(request, "write_admin.info_message");
		request.getSession().setAttribute("report", infoMessage);

		log.debug("Write Admin Command completed successfully");
		return address;
	}
}
