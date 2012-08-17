package org.tsk.mng.taskmanagement.usermanagementservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.2
 * Fri Aug 17 16:42:07 IDT 2012
 * Generated source version: 2.2
 * 
 */
 
@WebService(targetNamespace = "http://mng.tsk.org/taskManagement/UserManagementService/", name = "UserManagementServicePortType")
@XmlSeeAlso({org.tsk.mng.taskmanagement.common_elements.task.taskfe.ObjectFactory.class,org.tsk.mng.taskmanagement.common_elements.task.taskresult.ObjectFactory.class,org.tsk.mng.taskmanagement.common_elements.user.userresult.ObjectFactory.class,org.tsk.mng.taskmanagement.usermanagementwrapper.ObjectFactory.class,org.tsk.mng.taskmanagement.common_elements.opertaionresultstatus.ObjectFactory.class,org.tsk.mng.taskmanagement.header.soapheader.ObjectFactory.class,org.tsk.mng.taskmanagement.common_elements.user.userfe.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface UserManagementServicePortType {

    @WebResult(name = "addSuperiorToUserOperationElementResponse", targetNamespace = "http://mng.tsk.org/taskManagement/UserManagementWrapper", partName = "addSuperiorToUserResponse")
    @WebMethod(action = "addSuperiorToUserOperation")
    public org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult addSuperiorToUserOperation(
        @WebParam(partName = "soapHeader", name = "userAuthInfo", targetNamespace = "http://mng.tsk.org/taskManagement/header/soapHeader", header = true)
        org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo soapHeader,
        @WebParam(partName = "addSuperiorToUserRequest", name = "addSuperiorToUserOperationElementRequest", targetNamespace = "http://mng.tsk.org/taskManagement/UserManagementWrapper")
        org.tsk.mng.taskmanagement.usermanagementwrapper.AddSuperiorToUserTypeRequest addSuperiorToUserRequest
    );

    @WebResult(name = "createUserOperationElementResponse", targetNamespace = "http://mng.tsk.org/taskManagement/UserManagementWrapper", partName = "createUserResponse")
    @WebMethod(action = "createUserOperation")
    public org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult createUserOperation(
        @WebParam(partName = "soapHeader", name = "userAuthInfo", targetNamespace = "http://mng.tsk.org/taskManagement/header/soapHeader", header = true)
        org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo soapHeader,
        @WebParam(partName = "createUserRequest", name = "createUserOperationElementRequest", targetNamespace = "http://mng.tsk.org/taskManagement/UserManagementWrapper")
        org.tsk.mng.taskmanagement.usermanagementwrapper.CreateUserTypeRequest createUserRequest
    );

    @WebResult(name = "deleteUserOperationElementResponse", targetNamespace = "http://mng.tsk.org/taskManagement/UserManagementWrapper", partName = "deleteUserResponse")
    @WebMethod(action = "deleteUserOperation")
    public org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult deleteUserOperation(
        @WebParam(partName = "soapHeader", name = "userAuthInfo", targetNamespace = "http://mng.tsk.org/taskManagement/header/soapHeader", header = true)
        org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo soapHeader,
        @WebParam(partName = "deleteUserRequest", name = "deleteUserOperationElementRequest", targetNamespace = "http://mng.tsk.org/taskManagement/UserManagementWrapper")
        org.tsk.mng.taskmanagement.usermanagementwrapper.DeleteUserTypeRequest deleteUserRequest
    );

    @WebResult(name = "updateUserOperationElementResponse", targetNamespace = "http://mng.tsk.org/taskManagement/UserManagementWrapper", partName = "updateUserResponse")
    @WebMethod(action = "updateUserOperation")
    public org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult updateUserOperation(
        @WebParam(partName = "soapHeader", name = "userAuthInfo", targetNamespace = "http://mng.tsk.org/taskManagement/header/soapHeader", header = true)
        org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo soapHeader,
        @WebParam(partName = "updateUserRequest", name = "updateUserOperationElementRequest", targetNamespace = "http://mng.tsk.org/taskManagement/UserManagementWrapper")
        org.tsk.mng.taskmanagement.usermanagementwrapper.UpdateUserTypeRequest updateUserRequest
    );

    @WebResult(name = "readUserOperationElementResponse", targetNamespace = "http://mng.tsk.org/taskManagement/UserManagementWrapper", partName = "readUserResponse")
    @WebMethod(action = "readUserOperation")
    public org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult readUserOperation(
        @WebParam(partName = "soapHeader", name = "userAuthInfo", targetNamespace = "http://mng.tsk.org/taskManagement/header/soapHeader", header = true)
        org.tsk.mng.taskmanagement.header.soapheader.UserAuthInfo soapHeader,
        @WebParam(partName = "readUserRequest", name = "readUserOperationElementRequest", targetNamespace = "http://mng.tsk.org/taskManagement/UserManagementWrapper")
        org.tsk.mng.taskmanagement.usermanagementwrapper.ReadUserTypeRequest readUserRequest
    );
}
