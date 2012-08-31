package org.tsk.mng.webclient.servlets.filters;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tsk.mng.taskmanagement.common_elements.user.userfe.UserFE;
import org.tsk.mng.webclient.tools.Consts;


/**
 * Servlet Filter implementation class AuthorizationFilter
 */
@WebFilter(description = "cheking wheter the user is login", urlPatterns = { Consts.WELCOME_PAGES + "/*" })
public class AuthFilter implements Filter {

	private Logger logger = Logger.getLogger(AuthFilter.class.getName());

	/**
	 * Default constructor. 
	 */
	public AuthFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}




	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		
		String pageToDispach = doDispach((HttpServletRequest)request,(HttpServletResponse)response);

		if (pageToDispach != null) {
			logger.info("going to dispatch to the next servlet. Next Servlet : " + pageToDispach);
			request.getServletContext().getRequestDispatcher(pageToDispach).forward(request, response);
		} else {
			logger.info("pass the request along the his way...");
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}



	private String doDispach(HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("Checking whether authentication is not expire");

		String pageToDispach; 

		UserFE currentUser = (UserFE)request.getSession().getAttribute(Consts.CURRENT_USER_ATT);

		if (currentUser == null) {
			logger.info("The User dosen't exist in the session, authentication needed");
			pageToDispach = Consts.LOGIN_PAGE;	
		} else {
			pageToDispach = null;
			logger.info("The User : " + currentUser + " exists, no authentication needed");
		}

		return pageToDispach;

	}

}
