
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package org.tsk.mng.taskmanagement.taskmanagementservice;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.2
 * Fri Aug 17 16:25:00 IDT 2012
 * Generated source version: 2.2
 * 
 */

@javax.jws.WebService(
                      serviceName = "TaskManagementService",
                      portName = "TaskManagementServicePort",
                      targetNamespace = "http://mng.tsk.org/taskManagement/TaskManagementService/",
                      wsdlLocation = "http://localhost:8080/TaskManagementService/services/TaskManagementService?wsdl",
                      endpointInterface = "org.tsk.mng.taskmanagement.taskmanagementservice.TaskManagementServicePortType")
                      
public class TaskManagementServicePortTypeImpl implements TaskManagementServicePortType {

    private static final Logger LOG = Logger.getLogger(TaskManagementServicePortTypeImpl.class.getName());

    /* (non-Javadoc)
     * @see org.tsk.mng.taskmanagement.taskmanagementservice.TaskManagementServicePortType#getUserTasksOperation(org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo  soapHeader ,)org.tsk.mng.taskmanagement.task_management_wrapper.GetUserTasksTypeRequest  getUserTasksRequest )*
     */
    public org.tsk.mng.taskmanagement.common_elements.task.taskresult.TaskResult getUserTasksOperation(org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo soapHeader,org.tsk.mng.taskmanagement.task_management_wrapper.GetUserTasksTypeRequest getUserTasksRequest) { 
        LOG.info("Executing operation getUserTasksOperation");
        System.out.println(soapHeader);
        System.out.println(getUserTasksRequest);
        try {
            org.tsk.mng.taskmanagement.common_elements.task.taskresult.TaskResult _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.tsk.mng.taskmanagement.taskmanagementservice.TaskManagementServicePortType#updateTaskOperation(org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo  soapHeader ,)org.tsk.mng.taskmanagement.task_management_wrapper.UpdateTaskElemetRequest  updateTaskRequest )*
     */
    public org.tsk.mng.taskmanagement.common_elements.task.taskresult.TaskResult updateTaskOperation(org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo soapHeader,org.tsk.mng.taskmanagement.task_management_wrapper.UpdateTaskElemetRequest updateTaskRequest) { 
        LOG.info("Executing operation updateTaskOperation");
        System.out.println(soapHeader);
        System.out.println(updateTaskRequest);
        try {
            org.tsk.mng.taskmanagement.common_elements.task.taskresult.TaskResult _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.tsk.mng.taskmanagement.taskmanagementservice.TaskManagementServicePortType#assignUserToTaskOperation(org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo  soapHeader ,)org.tsk.mng.taskmanagement.task_management_wrapper.AssignUserToTaskTypeRequest  assignUserToTaskRequest )*
     */
    public org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult assignUserToTaskOperation(org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo soapHeader,org.tsk.mng.taskmanagement.task_management_wrapper.AssignUserToTaskTypeRequest assignUserToTaskRequest) { 
        LOG.info("Executing operation assignUserToTaskOperation");
        System.out.println(soapHeader);
        System.out.println(assignUserToTaskRequest);
        try {
            org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.tsk.mng.taskmanagement.taskmanagementservice.TaskManagementServicePortType#addDependencyOperation(org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo  soapHeader ,)org.tsk.mng.taskmanagement.task_management_wrapper.AddDependencyElemetRequest  addDependencyRequest )*
     */
    public org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult addDependencyOperation(org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo soapHeader,org.tsk.mng.taskmanagement.task_management_wrapper.AddDependencyElemetRequest addDependencyRequest) { 
        LOG.info("Executing operation addDependencyOperation");
        System.out.println(soapHeader);
        System.out.println(addDependencyRequest);
        try {
            org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.tsk.mng.taskmanagement.taskmanagementservice.TaskManagementServicePortType#removeTaskFromUserOperation(org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo  soapHeader ,)org.tsk.mng.taskmanagement.task_management_wrapper.RemoveTaskFromUserElementRequest  removeTaskFromUserRequest )*
     */
    public org.tsk.mng.taskmanagement.common_elements.task.taskresult.TaskResult removeTaskFromUserOperation(org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo soapHeader,org.tsk.mng.taskmanagement.task_management_wrapper.RemoveTaskFromUserElementRequest removeTaskFromUserRequest) { 
        LOG.info("Executing operation removeTaskFromUserOperation");
        System.out.println(soapHeader);
        System.out.println(removeTaskFromUserRequest);
        try {
            org.tsk.mng.taskmanagement.common_elements.task.taskresult.TaskResult _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
