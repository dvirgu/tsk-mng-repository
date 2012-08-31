package org.tsk.mng.webclient.tools;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.tsk.mng.taskmanagement.common_elements.task.taskfe.TaskFE;
import org.tsk.mng.taskmanagement.common_elements.task.taskfe.TaskStatusType;
import org.tsk.mng.taskmanagement.common_elements.user.userfe.PermissionType;
import org.tsk.mng.taskmanagement.common_elements.user.userfe.UserFE;
import org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo;
import org.tsk.mng.taskmanagement.task_management_wrapper.AddDependencyElemetRequest;
import org.tsk.mng.taskmanagement.task_management_wrapper.AssignUserToTaskTypeRequest;
import org.tsk.mng.taskmanagement.task_management_wrapper.GetUserTasksTypeRequest;
import org.tsk.mng.taskmanagement.task_management_wrapper.RemoveTaskFromUserElementRequest;
import org.tsk.mng.taskmanagement.task_management_wrapper.UpdateTaskElemetRequest;
import org.tsk.mng.taskmanagement.usermanagementwrapper.AddSuperiorToUserTypeRequest;
import org.tsk.mng.taskmanagement.usermanagementwrapper.CreateUserTypeRequest;
import org.tsk.mng.taskmanagement.usermanagementwrapper.DeleteUserTypeRequest;
import org.tsk.mng.taskmanagement.usermanagementwrapper.ReadUserTypeRequest;
import org.tsk.mng.taskmanagement.usermanagementwrapper.UpdateUserTypeRequest;




public class ObjectsFactoryWrapper {

	
	private static Logger logger = Logger.getLogger(ObjectsFactoryWrapper.class.getName());
	
	/**
	 * 
	 */
	private static org.tsk.mng.taskmanagement.usermanagementwrapper.ObjectFactory userManagementWrapperFactory;
	
	/**
	 * 
	 */
	private static org.tsk.mng.taskmanagement.task_management_wrapper.ObjectFactory taskManagementWrapperFactory; 
	
	
	/**
	 * 
	 */
	private static org.tsk.mng.taskmanagement.common_elements.user.userfe.ObjectFactory userFeFactory;
	
	
	/**
	 * 
	 */
	private static org.tsk.mng.taskmanagement.common_elements.task.taskfe.ObjectFactory taskFeFactory;
	
	/**
	 * 
	 */
	private static org.tsk.mng.taskmanagement.header.soapheader.ObjectFactory authInfoFactory;
	
	
	static {
		
		userFeFactory = new org.tsk.mng.taskmanagement.common_elements.user.userfe.ObjectFactory();
		
		taskFeFactory = new org.tsk.mng.taskmanagement.common_elements.task.taskfe.ObjectFactory();
		
		taskManagementWrapperFactory = new org.tsk.mng.taskmanagement.task_management_wrapper.ObjectFactory();
		
		userManagementWrapperFactory = new org.tsk.mng.taskmanagement.usermanagementwrapper.ObjectFactory();
		
		authInfoFactory = new org.tsk.mng.taskmanagement.header.soapheader.ObjectFactory();
	}
	
	
    /**
     * Create an instance of {@link AddSuperiorToUserTypeRequest }
     * with all the necessary  data within
     * 
     */
    public static AddSuperiorToUserTypeRequest createAddSuperiorToUserTypeRequest(UserFE worker, UserFE superior) {
    	AddSuperiorToUserTypeRequest retValue = userManagementWrapperFactory.createAddSuperiorToUserTypeRequest();
    	retValue.setSuperior(superior);
    	retValue.setWorker(worker);
    	
    	return retValue;
    }

    /**
     * Create an instance of {@link CreateUserTypeRequest }
     * 
     */
    public static CreateUserTypeRequest createCreateUserTypeRequest(UserFE user) {
        CreateUserTypeRequest retValue =  userManagementWrapperFactory.createCreateUserTypeRequest();
        retValue.setUser(user);
        
        return retValue;
    }

    /**
	 * create CreateUserTypeRequest object with UserFE object within.
	 * <p> the UserFe taken from the request parameters
	 * 
	 * @param request
	 * @return
	 */
	public static CreateUserTypeRequest createCreateUserTypeRequest(HttpServletRequest request)
			throws NullPointerException {

			return createCreateUserTypeRequest(createUserFEbyReqest(request));
		}

    /**
     * Create an instance of {@link ReadUserTypeRequest }
     * 
     */
    public static ReadUserTypeRequest createReadUserTypeRequest(String username) {
        ReadUserTypeRequest retValue = userManagementWrapperFactory.createReadUserTypeRequest();
        retValue.setUser(username);
        
        return retValue;
    }

    /**
     * Create an instance of {@link UpdateUserTypeRequest }
     * 
     */
    public static UpdateUserTypeRequest createUpdateUserTypeRequest(UserFE userToUpdate) {
        UpdateUserTypeRequest retValue = userManagementWrapperFactory.createUpdateUserTypeRequest();
        retValue.setUser(userToUpdate);
        
        return retValue;
    }

    /**
     * Create an instance of {@link DeleteUserTypeRequest }
     * 
     */
    public static DeleteUserTypeRequest createDeleteUserTypeRequest(UserFE userToDelete) {
    	DeleteUserTypeRequest retValue = userManagementWrapperFactory.createDeleteUserTypeRequest();
    	retValue.setUser(userToDelete);
    	
    	return retValue;
    }
    
    /**
     * creating UserFE object from given request with Parameters of UserFE
     * 
     * @param request
     * @return
     * @throws NullPointerException
     */
	public static UserFE createUserFEbyReqest(HttpServletRequest request)
			throws NullPointerException{

		if (request != null) {
			UserFE newUser = userFeFactory.createUserFE();
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
     * Create an instance of {@link UserAuthInfo }
     * 
     */
    public static UserAuthInfo createUserAuthInfo(String username, String password) {
        UserAuthInfo retValue = authInfoFactory.createUserAuthInfo();
        retValue.setUserName(username);
        retValue.setPassword(password);
        
        return retValue;
    }

    /**
     * Create an instance of {@link RemoveTaskFromUserElementRequest }
     * 
     */
    public static RemoveTaskFromUserElementRequest createRemoveTaskFromUserElementRequest(TaskFE task, UserFE user) {
    	RemoveTaskFromUserElementRequest retValue = taskManagementWrapperFactory.createRemoveTaskFromUserElementRequest();
    	retValue.setTask(task);
    	retValue.setUser(user);
    	
    	return retValue;
    	
    }

    /**
     * Create an instance of {@link AddDependencyElemetRequest }
     * 
     */
    public static AddDependencyElemetRequest createAddDependencyElemetRequest(TaskFE dependedTask, TaskFE task) {
        AddDependencyElemetRequest retValue = taskManagementWrapperFactory.createAddDependencyElemetRequest();
        retValue.setDependedTask(dependedTask);
        retValue.setTask(task);
        
        return retValue;
    }

    /**
     * Create an instance of {@link AssignUserToTaskTypeRequest }
     * 
     */
    public static AssignUserToTaskTypeRequest createAssignUserToTaskTypeRequest(UserFE user, TaskFE task) {
        AssignUserToTaskTypeRequest retValue = taskManagementWrapperFactory.createAssignUserToTaskTypeRequest();
        retValue.setTask(task);
        retValue.setUser(user);
        
        return retValue;
    }

    /**
     * Create an instance of {@link GetUserTasksTypeRequest }
     * 
     */
    public static GetUserTasksTypeRequest createGetUserTasksTypeRequest(UserFE user) {
        GetUserTasksTypeRequest retValue = taskManagementWrapperFactory.createGetUserTasksTypeRequest();
        retValue.setUser(user);
        
        return retValue;
    }

    /**
     * Create an instance of {@link UpdateTaskElemetRequest }
     * 
     */
    public static UpdateTaskElemetRequest createUpdateTaskElemetRequest(TaskFE task) {
        UpdateTaskElemetRequest retValue = taskManagementWrapperFactory.createUpdateTaskElemetRequest();
        retValue.setTask(task);
        
        return retValue;
    }

	public static TaskFE createTaskFEbyRequest(HttpServletRequest request) {
		
		if (request != null) {
			TaskFE taskFE = taskFeFactory.createTaskFE();
			taskFE.setTaskId(Integer.valueOf(request.getParameter(Consts.TASK_ID_PARAM)));
			taskFE.setOwner(request.getParameter(Consts.TASK_OWNER_PARAM));
			taskFE.setStatus(TaskStatusType.valueOf(request.getParameter(Consts.STATUS_PARAM)));
			taskFE.setDescriptions(request.getParameter(Consts.DESCRIPTIONS_PARAM));
			taskFE.setDeadLine(xmlCalanderValueOf(request.getParameter(Consts.DEADLINE_PARAM)));
			taskFE.setAlert(xmlCalanderValueOf(request.getParameter(Consts.ALERT_PARAM)));
			
			taskFE.setDependentTasks(null);//TODO should be like that
			
			return taskFE;
		}

		throw new NullPointerException("HttpServletRequest is null");
	}
	
	public static XMLGregorianCalendar xmlCalanderValueOf(String dateToConvert) {
		
		XMLGregorianCalendar xgc = null;
		
		try {
			xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateToConvert);
			
		} catch (Exception e) {
			logger.warning(e.getMessage());
		} 
		
		return xgc;
	}
}
