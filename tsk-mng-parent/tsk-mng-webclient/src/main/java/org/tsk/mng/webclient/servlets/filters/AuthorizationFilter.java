package org.tsk.mng.webclient.servlets.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.tsk.mng.taskmanagement.common_elements.user.userfe.UserFE;
import org.tsk.mng.webclient.tools.Consts;


/**
 * Servlet Filter implementation class AuthorizationFilter
 */
@WebFilter(description = "cheking authorization for each request", urlPatterns = { "/" })
public class AuthorizationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthorizationFilter() {
        // TODO Auto-generated constructor stub
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
	
		UserFE currentUser = (UserFE) request.getAttribute(Consts.CURRENT_USER_ATT);
		
		if (currentUser == null) {
			
			request.getServletContext()
				.getRequestDispatcher("index.jsp").forward(request, response);//TODO const it
		}		

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
