package com.sydorchenko.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sydorchenko.command.util.Localizator;
import com.sydorchenko.constant.PagesConst;
import com.sydorchenko.entity.Role;

/**
 * Access Filter.
 * 
 * @author Sydorchenko
 *
 */
public class AccessFilter implements Filter {
	private static final Logger log = LogManager.getLogger(AccessFilter.class);
	private Map<String, List<String>> mapCommands = new HashMap<>();;
	private Map<String, List<String>> mapJsp = new HashMap<>();;
	private List<String> list;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.debug("Starting initialization Access Filter");
		list = asList(filterConfig.getInitParameter("guest-commands"));
		mapCommands.put("guest", list);
		list = asList(filterConfig.getInitParameter("guest-jsp"));
		mapJsp.put("guest", list);
		list = asList(filterConfig.getInitParameter("student-commands"));
		mapCommands.put("student", list);
		list = asList(filterConfig.getInitParameter("student-jsp"));
		mapJsp.put("student", list);
		list = asList(filterConfig.getInitParameter("teacher-commands"));
		mapCommands.put("teacher", list);
		list = asList(filterConfig.getInitParameter("teacher-jsp"));
		mapJsp.put("teacher", list);
		list = asList(filterConfig.getInitParameter("admin-commands"));
		mapCommands.put("admin", list);
		list = asList(filterConfig.getInitParameter("admin-jsp"));
		mapJsp.put("admin", list);
		log.debug("Finishing initialization Access Filter");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.debug("Starting Access Filter");
		if (checkAccess(request)) {
			log.debug("Finishing Access Filter");
			chain.doFilter(request, response);
		} else {
			String message = Localizator.getLocalizedString((HttpServletRequest) request, "accessfilter.error");
			request.setAttribute("errorMessage", message);
			log.error("Forwarding to error page.");
			request.getRequestDispatcher(PagesConst.ERROR).forward(request, response);
		}
	}

	/**
	 * Checking if access to requested command or page is allowed.
	 * 
	 * @param request
	 * @return boolean
	 */
	private boolean checkAccess(ServletRequest request) {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		String path = httpRequest.getServletPath();
		String command = request.getParameter("command");
		Role role = (Role) session.getAttribute("role");
		String roleStr = "";

		if (role == null) {
			roleStr = "guest";
		} else {
			roleStr = role.getName();
		}

		if (command != null && mapCommands.get(roleStr).contains(command)) {
			return true;
		} else if (command == null && mapJsp.get(roleStr).contains(path)) {
			return true;
		}
		return false;
	}

	/**
	 * Splits a string into tokens.
	 * 
	 * @param str
	 * @return An ArrayList of tokens from a given string.
	 */
	private List<String> asList(String str) {
		List<String> list = new ArrayList<>();
		StringTokenizer stk = new StringTokenizer(str);
		while (stk.hasMoreTokens()) {
			list.add(stk.nextToken());
		}
		return list;
	}
}
