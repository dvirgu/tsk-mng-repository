package org.tsk.mng.webclient.servlets;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tsk.mng.webclient.tools.Const;
import org.tsk.mng.taskmanagement.common_elements.opertaionresultstatus.OperationResultStatus;
import org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult;
import org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo;
import org.tsk.mng.taskmanagement.usermanagementservice.UserManagementService;
import org.tsk.mng.taskmanagement.usermanagementservice.UserManagementServicePortType;
import org.tsk.mng.taskmanagement.usermanagementwrapper.ReadUserTypeRequest;


/**
 * Servlet implementation class MainServlet
 * 
 * @author Dvir
 * 
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Logger logger = Logger.getLogger(LoginServlet.class.getName());

	private static UserManagementServicePortType userService; // TODO should be on servletContext ?
//	private static TaskManagementServicePortType taskService;

	static {
		initClientWebService();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static void initClientWebService() {

		userService = new UserManagementService(
				UserManagementService.WSDL_LOCATION,
				UserManagementService.SERVICE).getUserManagementServicePort();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.getSession().removeAttribute(Const.CURRENT_USER_ATT);
		String redirectPageUri = Const.ERROR_LOGIN_PAGE; // Error Page.

		String reqUserName = request.getParameter("userName");
		String reqPass = request.getParameter("password");

		// create new authentication request
		UserAuthInfo authUserInfo = new UserAuthInfo();
		authUserInfo.setUserName(reqUserName);
		authUserInfo.setPassword(reqPass);
		
		//the user to request
		ReadUserTypeRequest userReq = new ReadUserTypeRequest();
		userReq.setUser(reqUserName);

		// getting user from WebService API
		 UserResult user = userService.readUserOperation(authUserInfo,userReq);

		 if (user.getResultStatus() == OperationResultStatus.SUCCSESSFUL) { //set the user
			 request.getSession().setAttribute(Const.CURRENT_USER_ATT, authUserInfo);
		 redirectPageUri = Const.SUCCESS_LOGIN_PAGE; }
		 

		response.sendRedirect(redirectPageUri);
	}
}
