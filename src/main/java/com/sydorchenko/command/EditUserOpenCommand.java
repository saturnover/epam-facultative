package com.sydorchenko.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sydorchenko.constant.PagesConst;
import com.sydorchenko.dao.DBException;
import com.sydorchenko.dao.UserManager;
import com.sydorchenko.entity.User;

public class EditUserOpenCommand implements Command {
	private static final long serialVersionUID = 4504872704501401413L;
	private static final Logger log = LogManager.getLogger(EditUserOpenCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DBException {
		log.debug("EditUserOpenCommand Command starts");
		String address = PagesConst.EDITUSER;

		int id = Integer.parseInt(request.getParameter("id"));
		User editUser = UserManager.getInstance().getUser(id);
		log.debug("Instance of user for edit is received.");

		request.getSession().setAttribute("editUser", editUser);
		log.debug("EditUserOpen Command completed successfully");
		return address;
	}
}
