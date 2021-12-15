package com.sydorchenko.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Encoding Filter.
 * 
 * @author Sydorchenko
 *
 */
public class EncodingFilter implements Filter {
	private static final Logger log = LogManager.getLogger(EncodingFilter.class);
	private String encoding;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.debug("Starting initialization Encoding Filter");
		encoding = filterConfig.getInitParameter("encoding");
		log.debug("Ending initialization Encoding Filter");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.debug("Starting Encoding Filter");
		request.setCharacterEncoding(encoding);
		log.debug("Finishing Encoding Filter");
		chain.doFilter(request, response);
	}
}
