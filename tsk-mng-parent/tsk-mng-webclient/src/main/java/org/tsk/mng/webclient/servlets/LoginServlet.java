package org.tsk.mng.webclient.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tsk.mng.webclient.tools.Consts;
import org.tsk.mng.webclient.tools.ObjectsFactoryWrapper;
import org.tsk.mng.taskmanagement.common_elements.opertaionresultstatus.OperationResultStatus;
import org.tsk.mng.taskmanagement.common_elements.task.taskfe.TaskFE;
import org.tsk.mng.taskmanagement.common_elements.task.taskfe.TaskStatusType;
import org.tsk.mng.taskmanagement.common_elements.user.userfe.PermissionType;
import org.tsk.mng.taskmanagement.common_elements.user.userfe.UserFE;
import org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult;
import org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo;
import org.tsk.mng.taskmanagement.usermanagementservice.UserManagementServicePortType;
import org.tsk.mng.taskmanagement.usermanagementwrapper.ReadUserTypeRequest;


/**
 * Servlet implementation class MainServlet
 * 
 * @author Dvir
 * 
 */
@WebServlet(Consts.LOGIN_SERVLET_URL)
public class LoginServlet extends ServletBase {

	private static final long serialVersionUID = 1L;

	private Logger logger = Logger.getLogger(LoginServlet.class.getName());


	@Override
	public void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//TODO change the logic of the this method

		String reqUserName = request.getParameter("userName");
		String reqPass = request.getParameter("password");

		// create new authentication request
		UserAuthInfo authUserInfo = ObjectsFactoryWrapper.createUserAuthInfo(reqUserName, reqPass);

		//the user to request
		ReadUserTypeRequest userReq = ObjectsFactoryWrapper.createReadUserTypeRequest(reqUserName);

		// getting user from WebService API
		UserManagementServicePortType userService = getUserManagementServicePort();
		UserResult user = userService.readUserOperation(authUserInfo,userReq);

		
		String dispachPageUri;
		if (user.getResultStatus() == OperationResultStatus.SUCCESS) { //set the user
			request.getSession().setAttribute(Consts.CURRENT_USER_ATT, user.getUserReturnValues().get(0)); //FIXME change it getIndex
			dispachPageUri = Consts.WELCOME_PAGE; 
			response.sendRedirect(request.getContextPath() + dispachPageUri);
		} else {
			request.setAttribute(Consts.SERVICE_RESULT_DESCRIPTION_ATT, user.getResultDescription());
			dispachPageUri = Consts.LOGIN_PAGE;
			getServletContext().getRequestDispatcher(dispachPageUri).forward(request, response);
		}
		
		
	}
}
