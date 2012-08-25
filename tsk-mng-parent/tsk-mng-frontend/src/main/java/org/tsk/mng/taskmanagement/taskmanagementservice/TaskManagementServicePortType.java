package org.tsk.mng.taskmanagement.taskmanagementservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.2
 * Sat Aug 25 22:21:54 IDT 2012
 * Generated source version: 2.2
 * 
 */
 
@WebService(targetNamespace = "http://mng.tsk.org/taskManagement/TaskManagementService/", name = "TaskManagementServicePortType")
@XmlSeeAlso({org.tsk.mng.taskmanagement.task_management_wrapper.ObjectFactory.class,org.tsk.mng.taskmanagement.common_elements.task.taskresult.ObjectFactory.class,org.tsk.mng.taskmanagement.common_elements.resultbase.ObjectFactory.class,org.tsk.mng.taskmanagement.common_elements.task.taskfe.ObjectFactory.class,org.tsk.mng.taskmanagement.common_elements.user.userresult.ObjectFactory.class,org.tsk.mng.taskmanagement.common_elements.opertaionresultstatus.ObjectFactory.class,org.tsk.mng.taskmanagement.header.soapheader.ObjectFactory.class,org.tsk.mng.taskmanagement.common_elements.user.userfe.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface TaskManagementServicePortType {

    @WebResult(name = "getUserTasksOperationElementResponse", targetNamespace = "http://mng.tsk.org/taskManagement/task_management_wrapper", partName = "getUserTasksResponse")
    @WebMethod(action = "updateTaskOperation")
    public org.tsk.mng.taskmanagement.common_elements.task.taskresult.TaskResult getUserTasksOperation(
        @WebParam(partName = "soapHeader", name = "userAuthInfo", targetNamespace = "http://mng.tsk.org/taskManagement/header/soapHeader", header = true)
        org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo soapHeader,
        @WebParam(partName = "getUserTasksRequest", name = "getUserTasksOperationElementRequest", targetNamespace = "http://mng.tsk.org/taskManagement/task_management_wrapper")
        org.tsk.mng.taskmanagement.task_management_wrapper.GetUserTasksTypeRequest getUserTasksRequest
    );

    @WebResult(name = "updateTaskOperationElemetResponse", targetNamespace = "http://mng.tsk.org/taskManagement/task_management_wrapper", partName = "updateTaskResponse")
    @WebMethod(action = "updateTaskOperation")
    public org.tsk.mng.taskmanagement.common_elements.task.taskresult.TaskResult updateTaskOperation(
        @WebParam(partName = "soapHeader", name = "userAuthInfo", targetNamespace = "http://mng.tsk.org/taskManagement/header/soapHeader", header = true)
        org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo soapHeader,
        @WebParam(partName = "updateTaskRequest", name = "updateTaskOperationElemetRequest", targetNamespace = "http://mng.tsk.org/taskManagement/task_management_wrapper")
        org.tsk.mng.taskmanagement.task_management_wrapper.UpdateTaskElemetRequest updateTaskRequest
    );

    @WebResult(name = "assignUserToTaskOperationElementResponse", targetNamespace = "http://mng.tsk.org/taskManagement/task_management_wrapper", partName = "assignUserToTaskResponse")
    @WebMethod(action = "assignUserToTaskOperation")
    public org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult assignUserToTaskOperation(
        @WebParam(partName = "soapHeader", name = "userAuthInfo", targetNamespace = "http://mng.tsk.org/taskManagement/header/soapHeader", header = true)
        org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo soapHeader,
        @WebParam(partName = "assignUserToTaskRequest", name = "assignUserToTaskOperationElementRequest", targetNamespace = "http://mng.tsk.org/taskManagement/task_management_wrapper")
        org.tsk.mng.taskmanagement.task_management_wrapper.AssignUserToTaskTypeRequest assignUserToTaskRequest
    );

    @WebResult(name = "addDependencyOperationElemetResponse", targetNamespace = "http://mng.tsk.org/taskManagement/task_management_wrapper", partName = "addDependencyResponse")
    @WebMethod(action = "addDependencyOperation")
    public org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult addDependencyOperation(
        @WebParam(partName = "soapHeader", name = "userAuthInfo", targetNamespace = "http://mng.tsk.org/taskManagement/header/soapHeader", header = true)
        org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo soapHeader,
        @WebParam(partName = "addDependencyRequest", name = "addDependencyOperationElemetRequest", targetNamespace = "http://mng.tsk.org/taskManagement/task_management_wrapper")
        org.tsk.mng.taskmanagement.task_management_wrapper.AddDependencyElemetRequest addDependencyRequest
    );

    @WebResult(name = "removeTaskFromUserOperationElementResponse", targetNamespace = "http://mng.tsk.org/taskManagement/task_management_wrapper", partName = "removeTaskFromUserResponse")
    @WebMethod(action = "removeTaskFromUserOperation")
    public org.tsk.mng.taskmanagement.common_elements.task.taskresult.TaskResult removeTaskFromUserOperation(
        @WebParam(partName = "soapHeader", name = "userAuthInfo", targetNamespace = "http://mng.tsk.org/taskManagement/header/soapHeader", header = true)
        org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo soapHeader,
        @WebParam(partName = "removeTaskFromUserRequest", name = "removeTaskFromUserOperationElementRequest", targetNamespace = "http://mng.tsk.org/taskManagement/task_management_wrapper")
        org.tsk.mng.taskmanagement.task_management_wrapper.RemoveTaskFromUserElementRequest removeTaskFromUserRequest
    );
}
