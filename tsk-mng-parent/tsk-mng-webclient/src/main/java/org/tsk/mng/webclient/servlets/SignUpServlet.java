package org.tsk.mng.webclient.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.PortableInterceptor.SUCCESSFUL;
import org.tsk.mng.taskmanagement.common_elements.opertaionresultstatus.OperationResultStatus;
import org.tsk.mng.taskmanagement.common_elements.user.userfe.PermissionType;
import org.tsk.mng.taskmanagement.common_elements.user.userfe.UserFE;
import org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult;
import org.tsk.mng.taskmanagement.usermanagementservice.UserManagementServicePortType;
import org.tsk.mng.taskmanagement.usermanagementwrapper.CreateUserTypeRequest;
import org.tsk.mng.webclient.tools.Consts;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet(description = "Create a new user in the system", urlPatterns = { "/SignUp" })
public class SignUpServlet extends ClientServletBase {


	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpServlet() {
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

	/**
	 * This method will call from doPost and doGet methods
	 * 
	 * @author Dvirgu
	 * @param request
	 * @param response
	 */
	private void doProcess(HttpServletRequest request,HttpServletResponse response) {

		try {
			CreateUserTypeRequest newUserReq = new CreateUserTypeRequest();
			UserFE newUser = createUserFE(request);
			newUserReq.setUser(newUser);

			UserManagementServicePortType userService = getUserManagementServicePort();
			UserResult result = userService.createUserOperation(null, newUserReq);// soapHear parameter should be null cause is new user, authenticate isn't relevant here.
			
			if (result.getResultStatus() == OperationResultStatus.SUCCSESSFUL) {
				request.getSession().setAttribute(Consts.CURRENT_USER_ATT, result.getUserReturnValues().get(0));//FIXME change get(0)
				response.sendRedirect(Consts.SUCCESS_LOGIN_PAGE);
			}
			
		} catch (ServletException e) {
			e.printStackTrace();
			//TODO logger
		} catch (IOException e) {
			// TODO logger
			e.printStackTrace();
		}

	}

	private UserFE createUserFE(HttpServletRequest request) {

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


}
