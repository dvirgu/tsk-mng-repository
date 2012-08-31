package org.tsk.mng.webclient.servlets;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.tsk.mng.taskmanagement.common_elements.opertaionresultstatus.OperationResultStatus;
import org.tsk.mng.taskmanagement.common_elements.task.taskfe.TaskFE;
import org.tsk.mng.taskmanagement.common_elements.user.userfe.UserFE;
import org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult;
import org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo;
import org.tsk.mng.taskmanagement.task_management_wrapper.AssignUserToTaskTypeRequest;
import org.tsk.mng.taskmanagement.taskmanagementservice.TaskManagementServicePortType;
import org.tsk.mng.taskmanagement.usermanagementservice.UserManagementServicePortType;
import org.tsk.mng.taskmanagement.usermanagementwrapper.ReadUserTypeRequest;
import org.tsk.mng.taskmanagement.usermanagementwrapper.UpdateUserTypeRequest;
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

		try {

			if (request.getParameter(Consts.TASK_ID_PARAM) == null) {
				//add tasks by JAXB
				doAddTask(request);
			}

			//add tasks by form
			TaskFE taskToAdd = ObjectsFactoryWrapper.createTaskFEbyRequest(request);
			doAddTask(request, taskToAdd);


		} catch (Exception e) {
			logger.warning(e.getMessage());
		}

	}


	/**
	 * getting TaskFE from XML file by parse it with JAXB unmarshal mythology
	 * 
	 * @param request
	 * @param xmlFilePath - should be absolute path to the XML file
	 * @throws JAXBException 
	 * @throws FileUploadException 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void doAddTask(HttpServletRequest request)
			throws IOException, FileUploadException, JAXBException, ServletException {

		logger.info("doAddTask by JAXB");

		File xmlFilePath = uploadMultipleFile(request);

		logger.info("trying to parse TaskFE from : " + xmlFilePath);
		
		JAXBContext jaxbContext = JAXBContext.newInstance(UserFE.class);
		Unmarshaller jaxbUnmarsheller = jaxbContext.createUnmarshaller();

		UserFE userWithTasks = (UserFE) jaxbUnmarsheller.unmarshal(xmlFilePath);
		logger.info("TaskFE has parsed successcful");
		
		//more than one task on the file
		if (userWithTasks.getTasks().size() > 1) {
			logger.info("more than one task was found");
			doAddTasks(request, userWithTasks);
			
		} else if (userWithTasks.getTasks().size() == 1) {//exactly one task in the file
			logger.info("only one task was found");
			doAddTask(request,userWithTasks.getTasks().get(0));
		}
	}




	/**
	 * adds new tasks by using update user service method
	 * 
	 * @param request
	 * @param userWithTasks
	 * @throws ServletException
	 */
	private void doAddTasks(HttpServletRequest request, UserFE userWithTasks) throws ServletException {

		logger.info("doAddTasks");

		UserManagementServicePortType userService = getUserManagementServicePort();

		//getting current user for authorization
		UserAuthInfo authInfo = getCurrentUser(request);

		//since we have more than one Task we update user with all his new tasks
		UpdateUserTypeRequest updateUserRequest = ObjectsFactoryWrapper.createUpdateUserTypeRequest(userWithTasks);
		UserResult result = userService.updateUserOperation(authInfo, updateUserRequest);

		request.setAttribute(Consts.SERVICE_RESULT_DESCRIPTION_ATT, result.getResultDescription());

		logger.info("set reuslt : " + result.getResultDescription());
	}


	/**
	 * 
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws FileUploadException
	 * @throws JAXBException
	 */
	private File uploadMultipleFile(HttpServletRequest request)
			throws IOException, FileUploadException, JAXBException {

		logger.info("trying to upload file");
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if (isMultipart) {
			
			FileItemFactory factory = new DiskFileItemFactory();    
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			try {             
			
				List items = upload.parseRequest(request);     
				Iterator iterator = items.iterator();       
				while (iterator.hasNext()) {  
					FileItem item = (FileItem) iterator.next();                 
					if (!item.isFormField()) {                        
						String fileName = item.getName();                        
						String root = getServletContext().getRealPath("/");               
						File path = new File(root + "/uploads");                  
						if (!path.exists()) {                           
							boolean status = path.mkdirs();                     
						}                   
						File uploadedFile = new File(path + "/" + fileName);        
						System.out.println(uploadedFile.getAbsolutePath());                
						item.write(uploadedFile);
						logger.info("returning " + 	uploadedFile);
						return uploadedFile;
					
					}             
				} 
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}


	/**
	 * 
	 * 
	 * @param request
	 * @param taskToAdd
	 * @throws ServletException
	 */
	private void doAddTask(HttpServletRequest request, TaskFE taskToAdd)
			throws ServletException {

		logger.info("doAddTask");

		TaskManagementServicePortType taskService = getTaskManagementServicePort();
		UserManagementServicePortType userService = getUserManagementServicePort();

		// creating authorization Info
		UserAuthInfo authInfo = getCurrentUser(request);

		// getting user by task owners
		ReadUserTypeRequest readUserRequest = ObjectsFactoryWrapper.createReadUserTypeRequest(taskToAdd.getOwner());
		UserResult userResult = userService.readUserOperation(authInfo,readUserRequest);// try to get user from service

		if (userResult.getUserReturnValues().size() == 1 && userResult.getResultStatus() == OperationResultStatus.SUCCESS) {

			UserFE userToAddTask = userResult.getUserReturnValues().get(0);

			// create request service object
			AssignUserToTaskTypeRequest assignUserToTaskRequest = ObjectsFactoryWrapper.createAssignUserToTaskTypeRequest(userToAddTask, taskToAdd);

			// invoke service
			userResult = taskService.assignUserToTaskOperation(authInfo,assignUserToTaskRequest);

		}
		// set the result on the request as attribute
		request.setAttribute(Consts.SERVICE_RESULT_DESCRIPTION_ATT, userResult.getResultDescription());

		logger.info("Service Return : " + userResult.getResultDescription());
	}

}
