package org.tsk.mng.webclient.servlets;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.tsk.mng.taskmanagement.common_elements.user.userfe.PermissionType;
import org.tsk.mng.taskmanagement.common_elements.user.userfe.UserFE;
import org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo;
import org.tsk.mng.taskmanagement.taskmanagementservice.TaskManagementService;
import org.tsk.mng.taskmanagement.taskmanagementservice.TaskManagementServicePortType;
import org.tsk.mng.taskmanagement.usermanagementservice.UserManagementService;
import org.tsk.mng.taskmanagement.usermanagementservice.UserManagementServicePortType;
import org.tsk.mng.taskmanagement.usermanagementwrapper.CreateUserTypeRequest;
import org.tsk.mng.webclient.tools.Consts;
import org.tsk.mng.webclient.tools.ObjectsFactoryWrapper;

/**
 * Servlet implementation class ServletUtils
 */
public abstract class ServletBase extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Logger logger = Logger.getLogger(ServletBase.class.getName());


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		doProcess(req, res);

		// super.doPost(req, res); TODO should be ?
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		doProcess(req, res);

		// super.doGet(req, res);TODO should be?
	}


	/**
	 * This method will call from doPost and doGet methods
	 * 
	 * @author Dvirgu
	 * @param request
	 * @param response
	 */
	public abstract void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException;

	// TODO should be synchronized
	public UserManagementServicePortType getUserManagementServicePort()
			throws ServletException {

		ServletContext sc = getServletContext();

		if (sc == null) {
			throw new ServletException("ServletContext is not available");
		}

		UserManagementServicePortType userServiceToRet = (UserManagementServicePortType)sc.getAttribute(Consts.USER_SERVICE_PORT_ATT);

		if (userServiceToRet != null) {
			return userServiceToRet;
		}

		userServiceToRet = initUserWebService();

		if (userServiceToRet != null) {
			sc.setAttribute(Consts.USER_SERVICE_PORT_ATT, userServiceToRet);
			return userServiceToRet;
		}

		throw new NullPointerException("Can't return TaskService");
		
	}

	public TaskManagementServicePortType getTaskManagementServicePort()
			throws ServletException {

		ServletContext sc = getServletContext();

		if (sc == null) {
			throw new ServletException("ServletContext is not available");
		}

		TaskManagementServicePortType taskServiceToRet = (TaskManagementServicePortType)sc.getAttribute(Consts.TASK_SERVICE_PORT_ATT);

		if (taskServiceToRet != null) {
			return taskServiceToRet;
		}

		taskServiceToRet = initTaskWebService();

		if (taskServiceToRet != null) {
			sc.setAttribute(Consts.TASK_SERVICE_PORT_ATT, taskServiceToRet);
			return taskServiceToRet;
		}

		throw new NullPointerException("Can't return TaskService");
	}


	private TaskManagementServicePortType initTaskWebService() {

		TaskManagementServicePortType taskService = null;

		try {
			taskService = new TaskManagementService(
					TaskManagementService.WSDL_LOCATION,
					TaskManagementService.SERVICE)
			.getTaskManagementServicePort();
		} catch (Exception e) {
			logger.warning(e.getMessage());
		}

		return taskService;
	}

	private UserManagementServicePortType initUserWebService() {

		UserManagementServicePortType userService = null;
		try {
			userService = new UserManagementService(
					UserManagementService.WSDL_LOCATION,
					UserManagementService.SERVICE)
			.getUserManagementServicePort();
		} catch (Exception e) {
			logger.warning(e.getMessage());
		}

		return userService;
	}

	protected UserFE getCurrentUser(HttpSession currentSession) {
		return (UserFE) currentSession.getAttribute(Consts.CURRENT_USER_ATT);
	}
	
	protected UserAuthInfo getCurrentUser(HttpServletRequest req) {
		
		UserAuthInfo reUser = null;
		
		UserFE currentUser = getCurrentUser(req.getSession());
		
		if (currentUser != null) {
			reUser = ObjectsFactoryWrapper.createUserAuthInfo(currentUser.getMail(), currentUser.getPassword());
		}
		
		return reUser;
	}
}