package org.tsk.mng.webclient.servlets;

import javax.servlet.annotation.WebServlet;
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
