package org.tsk.mng.webclient.tools;

public final class Consts {
	
	/**
	 * Current Session Attributes
	 */
	public static final String CURRENT_USER_ATT ="currentUserAttribute";
	
	/**
	 * Pages Attributes
	 */
	public static final String LOGIN_SERVICE_PAGES = "/loginService";
	public static final String WELCOME_PAGES = LOGIN_SERVICE_PAGES + "/welcome";
	public static final String TASK_PAGES = WELCOME_PAGES + "/taskPages";
	
	public static final String LOGIN_PAGE = LOGIN_SERVICE_PAGES + "/loginPage.jsp";//TODO should be mapped too?
	public static final String SIGNUP_PAGE = WELCOME_PAGES + "/signup.jsp";
	public static final String WELCOME_PAGE = WELCOME_PAGES + "/welcomePage";
	public static final String MY_USERS_PAGE = WELCOME_PAGES + "/myUsers.jsp";
	public static final String MY_TASKS_PAGE = TASK_PAGES + "/tasksViewPage.jsp";
	public static final String ADD_TASK_PAGE = TASK_PAGES + "/addTaskPage.jsp";
	
	/**
	 * Servlet URL 
	 */
	public static final String SERVLET_DISPATCHER = "/MainServlet";
	public static final String SIGNUP_SERVLET_URL = WELCOME_PAGES + "/SignUp";
	public static final String TASKS_SERVLET = WELCOME_PAGES + "/Tasks";
	public static final String LOGIN_SERVLET_URL = LOGIN_SERVICE_PAGES + "/Login";
	public static final String LOGOUT_SERVLET_URL = LOGIN_SERVICE_PAGES + "/Logout";
	
	/**
	 * Services Attributes
	 */
	public static final String USER_SERVICE_PORT_ATT = "UserManagementService";
	public static final String TASK_SERVICE_PORT_ATT = "TaskManagementServiceAtt";
	public static final String USER_RESULT_STATUS_ATT = "userResultStatusAtt";
	public static final String SERVICE_RESULT_DESCRIPTION_ATT = "serviceDescriptionAtt";
	
	/**
	 * UserFE Constants
	 */
	public static final String MAIL_PARAM = "mail";
	public static final String LAST_NAME_PARAM = "lastName";
	public static final String FIRST_NAME_PARAM = "firstName";
	public static final String NICK_NAME_PARAM = "nickName";
	public static final String PASSWORD_PARAM = "password";
	public static final String PERMISSION_PARAM = "permissions";

	/**
	 * TaskFE Constants
	 */
	public static final String TASK_ID_PARAM = "taskID";
	public static final String STATUS_PARAM = "status";
	public static final String DESCRIPTIONS_PARAM = "descriptions";
	public static final String DEADLINE_PARAM = "deadline";
	public static final String ALERT_PARAM = "alert";
	public static final String TASK_OWNER_PARAM = "taskOwner";
	public static final String OPPERATION_TYPE_PARAM = "opperationType";
	public static final String FILE_UPLOAD_PARAMETER = "fileUpload";



}

