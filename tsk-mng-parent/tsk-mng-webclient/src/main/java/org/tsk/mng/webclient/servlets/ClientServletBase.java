package org.tsk.mng.webclient.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.tsk.mng.taskmanagement.usermanagementservice.UserManagementService;
import org.tsk.mng.taskmanagement.usermanagementservice.UserManagementServicePortType;
import org.tsk.mng.webclient.tools.Consts;


/**
 * Servlet implementation class ServletUtils
 */
public class ClientServletBase extends HttpServlet {

	private static final long serialVersionUID = 1L;

	//TODO add logger

	//	private static TaskManagementServicePortType taskService;

	//TODO should be synchronized
	public UserManagementServicePortType getUserManagementServicePort() throws ServletException {

		ServletContext sc = getServletContext();

		if (sc != null) {
			UserManagementServicePortType userServiceToRet = (UserManagementServicePortType) sc.getAttribute(Consts.USER_SERVICE_PORT_ATT);
			if (userServiceToRet != null) {
				return userServiceToRet;
			} else {
				return initClientWebService();
			}
		}

		throw new ServletException("ServletContext is not available");
	}

	private UserManagementServicePortType initClientWebService() {

		UserManagementServicePortType userService = null;
		try {
			userService = new UserManagementService(
					UserManagementService.WSDL_LOCATION,
					UserManagementService.SERVICE).getUserManagementServicePort();
		} catch (Exception e) {
			e.printStackTrace(); //TODO logger
		}

		return userService;
	}

}
