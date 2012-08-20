package org.tsk.mng.webclient.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.tsk.mng.taskmanagement.common_elements.user.userfe.PermissionType;
import org.tsk.mng.taskmanagement.common_elements.user.userfe.UserFE;
import org.tsk.mng.taskmanagement.usermanagementservice.UserManagementService;
import org.tsk.mng.taskmanagement.usermanagementservice.UserManagementServicePortType;
import org.tsk.mng.taskmanagement.usermanagementwrapper.CreateUserTypeRequest;
import org.tsk.mng.webclient.tools.Consts;


/**
 * Servlet implementation class ServletUtils
 */
public class ServletBase extends HttpServlet {

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

	//TODO move this method to util class
	public UserFE createUserFEfromReqest(HttpServletRequest request)
			throws NullPointerException{

		if (request != null) {
			UserFE newUser = new UserFE();
			newUser.setMail(request.getParameter(Consts.MAIL_PARAM));
			newUser.setLastName(request.getParameter(Consts.LAST_NAME_PARAM));
			newUser.setFirstName(request.getParameter(Consts.FIRST_NAME_PARAM));
			newUser.setNickName(request.getParameter(Consts.NICK_NAME_PARAM));
			newUser.setPassword(request.getParameter(Consts.PASSWORD_PARAM));
			newUser.setPermission(PermissionType.valueOf(request.getParameter(Consts.PERMISSION_PARAM).toUpperCase()));

			return newUser;
		}

		throw new NullPointerException("HttpServletRequest is null");
	}

	/**
	 * 
	 * create CreateUserTypeRequest object with UserFE object within.
	 * 
	 * @param request
	 * @return
	 */
	public CreateUserTypeRequest createCreateUserTypeRequest(
			HttpServletRequest request) throws NullPointerException {

			CreateUserTypeRequest retValue = new CreateUserTypeRequest();
			retValue.setUser(createUserFEfromReqest(request));

			return retValue;
		}
	}