package org.tsk.mng.webclient.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tsk.mng.taskmanagement.common_elements.opertaionresultstatus.OperationResultStatus;
import org.tsk.mng.taskmanagement.common_elements.user.userfe.UserFE;
import org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult;
import org.tsk.mng.taskmanagement.usermanagementservice.UserManagementServicePortType;
import org.tsk.mng.taskmanagement.usermanagementwrapper.CreateUserTypeRequest;
import org.tsk.mng.webclient.tools.Consts;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet(description = "Create a new user in the system", urlPatterns = {Consts.SIGNUP_SERVLET_URL})
public class SignUpServlet extends ServletBase {


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
			UserManagementServicePortType userService = getUserManagementServicePort();
			CreateUserTypeRequest newUserReq = createCreateUserTypeRequest(request);
			UserResult result = userService.createUserOperation(null, newUserReq);// soapHear parameter should be null cause is new user, authenticate isn't relevant here.

			
			if (result.getUserReturnValues().size() > 1) {
				throw new RuntimeException("more than one user doesn't supported yet");//TODO support more than one user in sign
			}
			
			String pageDispatch = Consts.ERROR_LOGIN_PAGE;;
			
			if (result.getResultStatus() == OperationResultStatus.SUCCESS) {
				UserFE userSignupResult = result.getUserReturnValues().get(0);//should be one user if result is successful
				if (userSignupResult != null) {
					request.getSession().setAttribute(Consts.CURRENT_USER_ATT, userSignupResult);
					pageDispatch = Consts.WELCOME_PAGE;
				}
			}
			
			getServletContext().getRequestDispatcher(pageDispatch).forward(request, response);
			
		} catch (ServletException e) {
			e.printStackTrace();
			//TODO logger
		} catch (Exception e) {
			// TODO logger
			e.printStackTrace();
		}
	}
	




}
