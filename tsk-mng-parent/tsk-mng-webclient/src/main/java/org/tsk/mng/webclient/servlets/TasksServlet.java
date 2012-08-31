package org.tsk.mng.webclient.servlets;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.tsk.mng.taskmanagement.common_elements.opertaionresultstatus.OperationResultStatus;
import org.tsk.mng.taskmanagement.common_elements.task.taskfe.TaskFE;
import org.tsk.mng.taskmanagement.common_elements.user.userfe.UserFE;
import org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult;
import org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo;
import org.tsk.mng.taskmanagement.task_management_wrapper.AssignUserToTaskTypeRequest;
import org.tsk.mng.taskmanagement.taskmanagementservice.TaskManagementServicePortType;
import org.tsk.mng.taskmanagement.usermanagementservice.UserManagementServicePortType;
import org.tsk.mng.taskmanagement.usermanagementwrapper.ReadUserTypeRequest;
import org.tsk.mng.webclient.tools.Consts;
import org.tsk.mng.webclient.tools.ObjectsFactoryWrapper;

/**
 * Servlet implementation class TasksServlet
 */
@WebServlet(description = "Manage the requests about tasks", urlPatterns = { Consts.TASKS_SERVLET })
public class TasksServlet extends ServletBase {

	private static final long serialVersionUID = 1L;

	private Logger logger = Logger.getLogger(TasksServlet.class.getName());

	@Override
	public void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//TODO if (request.getParameter(Consts.OPPERATION_TYPE_PARAM).equals("addTask")) {

			TaskFE taskToAdd = ObjectsFactoryWrapper.createTaskFEbyRequest(request);
			doAddTask(request,taskToAdd);


	}

	/**
	 * getting TaskFE from XML file by parse it with JAXB unmarshal mythology
	 * 
	 * @param request
	 * @param xmlFilePath - should be absolute path to the XML file
	 */
	private void doAddTask(HttpServletRequest request,String xmlFilePath) {

		logger.info("doAddTask by JAXB");

		try {

			logger.info("trying to parse TaskFE from : " + xmlFilePath);
			File xmlFile = new File(xmlFilePath);
			JAXBContext jaxbContext = JAXBContext.newInstance(TaskFE.class);
			Unmarshaller jaxbUnmarsheller = jaxbContext.createUnmarshaller();

			TaskFE taskToAddFromXml = (TaskFE) jaxbUnmarsheller.unmarshal(xmlFile);
			logger.info("TaskFE parse has successcful");

			doAddTask(request, taskToAddFromXml);

		} catch (ServletException se) {
			logger.warning(se.getMessage());
		} catch (JAXBException jaxbE) {
			logger.warning(jaxbE.getMessage());
		}

	}

	/**
	 * 
	 * 
	 * @param request
	 * @param taskToAdd
	 * @throws ServletException
	 */
	private void doAddTask(HttpServletRequest request,TaskFE taskToAdd) throws ServletException {

		logger.info("doAddTask");

		TaskManagementServicePortType taskService = getTaskManagementServicePort();
		UserManagementServicePortType userService = getUserManagementServicePort();

		//creating authorization Info
		UserAuthInfo authInfo = getCurrentUser(request);

		//getting user by task owners
		ReadUserTypeRequest readUserRequest = ObjectsFactoryWrapper.createReadUserTypeRequest(taskToAdd.getOwner());
		UserResult userResult = userService.readUserOperation(authInfo, readUserRequest);//try to get user from service
		if (userResult.getUserReturnValues().size() == 1 && userResult.getResultStatus() == OperationResultStatus.SUCCESS) {

			UserFE userToAddTask = userResult.getUserReturnValues().get(0);

			//create request service object 
			AssignUserToTaskTypeRequest assignUserToTaskRequest = ObjectsFactoryWrapper.createAssignUserToTaskTypeRequest(userToAddTask, taskToAdd);

			//invoke service
			userResult = taskService.assignUserToTaskOperation(authInfo, assignUserToTaskRequest);

		}
		//set the result on the request as attribute
		request.setAttribute(Consts.USER_RESULT_STATUS_ATT, userResult);

		logger.info("Service Return : " + userResult.getResultDescription());

	}

	private void doRemoveTask(HttpServletRequest request) {

	}
}
