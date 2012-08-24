package org.tsk.mng.webclient.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.tsk.mng.webclient.tools.Consts;

/**
 * Servlet implementation class Logout
 */
@WebServlet(Consts.LOGOUT_SERVLET_URL)
public class Logout extends ServletBase {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Logout() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response) {
		//TODO logger

		try {
			HttpSession httpSession = request.getSession();

			if (httpSession != null) {
				httpSession.removeAttribute(Consts.CURRENT_USER_ATT);
			}

			getServletContext().getRequestDispatcher(Consts.LOGIN_PAGE).forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			//TODO logger and change this acting
		}


	}
}
