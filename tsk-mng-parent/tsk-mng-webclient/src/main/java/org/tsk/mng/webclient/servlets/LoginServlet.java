package org.tsk.mng.webclient.servlets;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tsk.mng.webclient.tools.Const;



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

//	private static ClientService ss;	TODO
//	private static ClientPort port;		TODO
	
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

//		ss = new ClientService(ClientService.WSDL_LOCATION, ClientService.SERVICE); FIXME
//		port = ss.getClientPort();	FIXME

	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request,response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.getSession().removeAttribute(Const.CURRENT_USER_ATT);
		String redirectPageUri = Const.ERROR_LOGIN_PAGE; //Error Page. 

		String reqUserName = request.getParameter("userName");
		String reqPass = request.getParameter("password");

		//create new user from the web service object factory
		/*ObjectFactory objectFactory = new ObjectFactory();
		UserElementType user = objectFactory.createUserElementType();
		user.setUserName(reqUserName);
		user.setPassword(reqPass);*/	//FIXME
		
	//	user = port.login(user); // getting user from WebService API FIXME
		
		/*if (user != null) {
			//set the user
			request.getSession().setAttribute(Const.CURRENT_USER_ATT, user); 
			redirectPageUri = Const.SUCCESS_LOGIN_PAGE;
		}  FIXME*/

		response.sendRedirect(redirectPageUri);
	}
}
