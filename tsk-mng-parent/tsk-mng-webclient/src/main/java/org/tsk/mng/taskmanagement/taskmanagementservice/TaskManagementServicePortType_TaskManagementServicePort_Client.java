
package org.tsk.mng.taskmanagement.taskmanagementservice;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.2
 * Thu Aug 30 19:33:17 IDT 2012
 * Generated source version: 2.2
 * 
 */

public final class TaskManagementServicePortType_TaskManagementServicePort_Client {

    private static final QName SERVICE_NAME = new QName("http://mng.tsk.org/taskManagement/TaskManagementService/", "TaskManagementService");

    private TaskManagementServicePortType_TaskManagementServicePort_Client() {
    }

    public static void main(String args[]) throws Exception {
        URL wsdlURL = TaskManagementService.WSDL_LOCATION;
        if (args.length > 0) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        TaskManagementService ss = new TaskManagementService(wsdlURL, SERVICE_NAME);
        TaskManagementServicePortType port = ss.getTaskManagementServicePort();  
        
        {
        System.out.println("Invoking getUserTasksOperation...");
        org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo _getUserTasksOperation_soapHeader = null;
        org.tsk.mng.taskmanagement.task_management_wrapper.GetUserTasksTypeRequest _getUserTasksOperation_getUserTasksRequest = null;
        org.tsk.mng.taskmanagement.common_elements.task.taskresult.TaskResult _getUserTasksOperation__return = port.getUserTasksOperation(_getUserTasksOperation_soapHeader, _getUserTasksOperation_getUserTasksRequest);
        System.out.println("getUserTasksOperation.result=" + _getUserTasksOperation__return);


        }
        {
        System.out.println("Invoking updateTaskOperation...");
        org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo _updateTaskOperation_soapHeader = null;
        org.tsk.mng.taskmanagement.task_management_wrapper.UpdateTaskElemetRequest _updateTaskOperation_updateTaskRequest = null;
        org.tsk.mng.taskmanagement.common_elements.task.taskresult.TaskResult _updateTaskOperation__return = port.updateTaskOperation(_updateTaskOperation_soapHeader, _updateTaskOperation_updateTaskRequest);
        System.out.println("updateTaskOperation.result=" + _updateTaskOperation__return);


        }
        {
        System.out.println("Invoking assignUserToTaskOperation...");
        org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo _assignUserToTaskOperation_soapHeader = null;
        org.tsk.mng.taskmanagement.task_management_wrapper.AssignUserToTaskTypeRequest _assignUserToTaskOperation_assignUserToTaskRequest = null;
        org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult _assignUserToTaskOperation__return = port.assignUserToTaskOperation(_assignUserToTaskOperation_soapHeader, _assignUserToTaskOperation_assignUserToTaskRequest);
        System.out.println("assignUserToTaskOperation.result=" + _assignUserToTaskOperation__return);


        }
        {
        System.out.println("Invoking addDependencyOperation...");
        org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo _addDependencyOperation_soapHeader = null;
        org.tsk.mng.taskmanagement.task_management_wrapper.AddDependencyElemetRequest _addDependencyOperation_addDependencyRequest = null;
        org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult _addDependencyOperation__return = port.addDependencyOperation(_addDependencyOperation_soapHeader, _addDependencyOperation_addDependencyRequest);
        System.out.println("addDependencyOperation.result=" + _addDependencyOperation__return);


        }
        {
        System.out.println("Invoking removeTaskFromUserOperation...");
        org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo _removeTaskFromUserOperation_soapHeader = null;
        org.tsk.mng.taskmanagement.task_management_wrapper.RemoveTaskFromUserElementRequest _removeTaskFromUserOperation_removeTaskFromUserRequest = null;
        org.tsk.mng.taskmanagement.common_elements.task.taskresult.TaskResult _removeTaskFromUserOperation__return = port.removeTaskFromUserOperation(_removeTaskFromUserOperation_soapHeader, _removeTaskFromUserOperation_removeTaskFromUserRequest);
        System.out.println("removeTaskFromUserOperation.result=" + _removeTaskFromUserOperation__return);


        }

        System.exit(0);
    }

}
