package org.tsk.mng.webclient.tools;

public class Consts {
	
	/**
	 * Current Session Attributes
	 */
	public static final String CURRENT_USER_ATT ="currentUserAttribute";
	
	/**
	 * Pages Attributes
	 */
	public static final String WELCOME_PAGES = "/welcome";
	public static final String SIGNUP_PAGE = WELCOME_PAGES + "/signup.jsp";
	public static final String WELCOME_PAGE = WELCOME_PAGES + "/welcomePage.jsp";
	
	public static final String LOGIN_SERVICE_PAGES = WELCOME_PAGES + "/loginService";
	public static final String LOGIN_PAGE = LOGIN_SERVICE_PAGES + "/login.jsp";
	public static final String SUCCESS_LOGIN_PAGE = LOGIN_SERVICE_PAGES + "/loginSuccessResult.jsp";
	public static final String ERROR_LOGIN_PAGE = LOGIN_SERVICE_PAGES + "/loginFailResult.jsp";
	
	/**
	 * Servlet URL 
	 */
	public static final String SERVLET_ROUTER = "/MainServlet";
	public static final String SIGNUP_SERVLET_URL = WELCOME_PAGES + "/SignUp";
	public static final String LOGIN_SERVLET_URL = WELCOME_PAGES + "/Login";
	
	/**
	 * Services Attributes
	 */
	public static final String USER_SERVICE_PORT_ATT = "UserManagementService";

	
	/**
	 * SignUp Servlet Constants
	 */
	public static final String MAIL_PARAM = "mail";
	public static final String LAST_NAME_PARAM = "lastName";
	public static final String FIRST_NAME_PARAM = "firstName";
	public static final String NICK_NAME_PARAM = "nickName";
	public static final String PASSWORD_PARAM = "password";
	public static final String PERMISSION_PARAM = "permissions";
}

