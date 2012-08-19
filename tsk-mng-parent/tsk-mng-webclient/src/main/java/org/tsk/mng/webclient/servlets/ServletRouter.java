package org.tsk.mng.webclient.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tsk.mng.taskmanagement.common_elements.user.userfe.UserFE;
import org.tsk.mng.webclient.tools.Consts;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet(description = "Router of requests", urlPatterns = { Consts.SERVLET_ROUTER })
public class ServletRouter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletRouter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request,
			HttpServletResponse response) {

		UserFE currentUser = (UserFE)request.getSession().getAttribute(Consts.CURRENT_USER_ATT);

		try {

			String pageToDispach = Consts.LOGIN_PAGE;
			if (currentUser != null) {
				pageToDispach = Consts.WELCOME_PAGE;
			}

			getServletContext().getRequestDispatcher(pageToDispach).forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			//TODO loggers
		}
	}
}
