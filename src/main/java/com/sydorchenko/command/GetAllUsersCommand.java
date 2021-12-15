package com.sydorchenko.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sydorchenko.command.util.Filtering;
import com.sydorchenko.command.util.Paginator;
import com.sydorchenko.command.util.Sorting;
import com.sydorchenko.constant.PagesConst;
import com.sydorchenko.dao.DBException;
import com.sydorchenko.dao.UserManager;
import com.sydorchenko.entity.User;

/**
 * Command of getting list of all users.
 * 
 * @author Sydorchenko
 *
 */
public class GetAllUsersCommand implements Command {
	private static final long serialVersionUID = -3960358366295189522L;
	private static final Logger log = LogManager.getLogger(GetAllUsersCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DBException {
		log.debug("GetAllUsers Command starts");
		String address = PagesConst.USERS;

		String tab = request.getParameter("tab");
		String sort = request.getParameter("sort");
		int page = Integer.parseInt(request.getParameter("page"));
		log.debug("Parameters are received.");

		List<User> users = getFilteredList(tab);
		users = sortList(sort, users);
		request = Paginator.setPagination(request, users, page);

		log.debug("GetAllUsers Command completed successfully");
		return address;
	}

	/**
	 * Getting filtered list of users according to given parameter.
	 * 
	 * @param tab
	 * @return Filtered list.
	 * @throws DBException
	 */
	private List<User> getFilteredList(String tab) throws DBException {
		List<User> list = UserManager.getInstance().getUsers();
		if (tab.equalsIgnoreCase("teachers")) {
			list = Filtering.filterTeachers(list);
			log.info("Received list of teachers.");
		} else if (tab.equalsIgnoreCase("students")) {
			list = Filtering.filterStudents(list);
			log.info("Received list of students.");
		}
		return list;
	}

	/**
	 * Sorting given list of users.
	 * 
	 * @param sort
	 * @param list
	 * @return Sorted list of users.
	 */
	private List<User> sortList(String sort, List<User> list) {
		if (sort.equalsIgnoreCase("za")) {
			log.debug("Sorting users by last name descending.");
			list = Sorting.sortUsers(Sorting.byNameDescending, list);
		} else {
			log.debug("Sorting users by last name ascending.");
			list = Sorting.sortUsers(Sorting.byNameAscending, list);
		}
		return list;
	}
}
