package com.sydorchenko.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sydorchenko.command.util.Localizator;
import com.sydorchenko.command.util.PasswordUtil;
import com.sydorchenko.constant.PagesConst;
import com.sydorchenko.dao.DBException;
import com.sydorchenko.dao.UserManager;
import com.sydorchenko.entity.Role;
import com.sydorchenko.entity.User;

/**
 * Login Command.
 * 
 * @author Sydorchenko
 *
 */
public class LoginCommand implements Command {
	private static final long serialVersionUID = 2822901439826606423L;
	private static final Logger log = LogManager.getLogger(LoginCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DBException {
		log.debug("LoginCommand starts");

		String login = request.getParameter("login");
		String password = request.getParameter("password");

		String address = PagesConst.INDEX;
		User user = UserManager.getInstance().getUser(login);

		if (!authorize(request, user, password)) {
			return address;
		}

		log.info("User " + login + " passed authorization.");
		address = "controller?command=myprofile&tab=now&sort=az&page=1";

		HttpSession session = request.getSession();
		session = setAttributes(user, session);

		log.info(login + " enters the system");
		log.debug("Login Command finishes");
		return address;
	}

	/**
	 * Checking authorization parameters.
	 * 
	 * @param request
	 * @param user
	 * @param password
	 * @return Boolean
	 */
	private boolean authorize(HttpServletRequest request, User user, String password) {
		if (user == null) {
			log.error("Wrong login. Not found user ");
			String message = Localizator.getLocalizedString(request, "login.wrong_login");
			request.getSession().setAttribute("errorLogin", message);
			return false;
		}
		log.trace("Found user by login " + user.getLogin());

		String salt = user.getSalt();
		String hashedSaltedPassword = PasswordUtil.hashSaltedPassword(password, salt);

		if (!user.getPassword().equals(hashedSaltedPassword)) {
			log.error("Password is wrong.");
			String message = Localizator.getLocalizedString(request, "login.wrong_password");
			request.getSession().setAttribute("errorLogin", message);
			return false;
		} else if (user.getStatus().equalsIgnoreCase("banned")) {
			log.error("Banned account.");
			String message = Localizator.getLocalizedString(request, "login.wrong_status");
			request.getSession().setAttribute("errorLogin", message);
			return false;
		}
		return true;
	}

	/**
	 * Setting session attributes.
	 * 
	 * @param user
	 * @param session
	 * @return session with attributes
	 * @throws DBException
	 */
	private HttpSession setAttributes(User user, HttpSession session) throws DBException {
		Role role = Role.getRole(user);
		session.setAttribute("authorizedUser", user);
		session.setAttribute("role", role);

		log.info("Role is " + role.getName());
		log.debug("Session attributes are set.");
		return session;
	}
}
