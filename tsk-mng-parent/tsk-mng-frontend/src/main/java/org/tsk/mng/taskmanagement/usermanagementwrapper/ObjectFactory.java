
package org.tsk.mng.taskmanagement.usermanagementwrapper;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tsk.mng.taskmanagement.usermanagementwrapper package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _UpdateUserOperationElementResponse_QNAME = new QName("http://mng.tsk.org/taskManagement/UserManagementWrapper", "updateUserOperationElementResponse");
    private final static QName _DeleteUserOperationElementResponse_QNAME = new QName("http://mng.tsk.org/taskManagement/UserManagementWrapper", "deleteUserOperationElementResponse");
    private final static QName _ReadUserOperationElementResponse_QNAME = new QName("http://mng.tsk.org/taskManagement/UserManagementWrapper", "readUserOperationElementResponse");
    private final static QName _ReadUserOperationElementRequest_QNAME = new QName("http://mng.tsk.org/taskManagement/UserManagementWrapper", "readUserOperationElementRequest");
    private final static QName _UpdateUserOperationElementRequest_QNAME = new QName("http://mng.tsk.org/taskManagement/UserManagementWrapper", "updateUserOperationElementRequest");
    private final static QName _UpdateUserTypeRequest_QNAME = new QName("http://mng.tsk.org/taskManagement/UserManagementWrapper", "updateUserTypeRequest");
    private final static QName _CreateUserTypeRequest_QNAME = new QName("http://mng.tsk.org/taskManagement/UserManagementWrapper", "createUserTypeRequest");
    private final static QName _DeleteUserTypeRequest_QNAME = new QName("http://mng.tsk.org/taskManagement/UserManagementWrapper", "deleteUserTypeRequest");
    private final static QName _CreateUserOperationElementRequest_QNAME = new QName("http://mng.tsk.org/taskManagement/UserManagementWrapper", "createUserOperationElementRequest");
    private final static QName _AddSuperiorToUserOperationElementRequest_QNAME = new QName("http://mng.tsk.org/taskManagement/UserManagementWrapper", "addSuperiorToUserOperationElementRequest");
    private final static QName _AddSuperiorToUserOperationElementResponse_QNAME = new QName("http://mng.tsk.org/taskManagement/UserManagementWrapper", "addSuperiorToUserOperationElementResponse");
    private final static QName _DeleteUserOperationElementRequest_QNAME = new QName("http://mng.tsk.org/taskManagement/UserManagementWrapper", "deleteUserOperationElementRequest");
    private final static QName _AddSuperiorToUserTypeRequest_QNAME = new QName("http://mng.tsk.org/taskManagement/UserManagementWrapper", "addSuperiorToUserTypeRequest");
    private final static QName _ReadUserTypeRequest_QNAME = new QName("http://mng.tsk.org/taskManagement/UserManagementWrapper", "readUserTypeRequest");
    private final static QName _CreateUserOperationElementResponse_QNAME = new QName("http://mng.tsk.org/taskManagement/UserManagementWrapper", "createUserOperationElementResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tsk.mng.taskmanagement.usermanagementwrapper
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddSuperiorToUserTypeRequest }
     * 
     */
    public AddSuperiorToUserTypeRequest createAddSuperiorToUserTypeRequest() {
        return new AddSuperiorToUserTypeRequest();
    }

    /**
     * Create an instance of {@link CreateUserTypeRequest }
     * 
     */
    public CreateUserTypeRequest createCreateUserTypeRequest() {
        return new CreateUserTypeRequest();
    }

    /**
     * Create an instance of {@link ReadUserTypeRequest }
     * 
     */
    public ReadUserTypeRequest createReadUserTypeRequest() {
        return new ReadUserTypeRequest();
    }

    /**
     * Create an instance of {@link DeleteUserTypeRequest }
     * 
     */
    public DeleteUserTypeRequest createDeleteUserTypeRequest() {
        return new DeleteUserTypeRequest();
    }

    /**
     * Create an instance of {@link UpdateUserTypeRequest }
     * 
     */
    public UpdateUserTypeRequest createUpdateUserTypeRequest() {
        return new UpdateUserTypeRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/UserManagementWrapper", name = "updateUserOperationElementResponse")
    public JAXBElement<UserResult> createUpdateUserOperationElementResponse(UserResult value) {
        return new JAXBElement<UserResult>(_UpdateUserOperationElementResponse_QNAME, UserResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/UserManagementWrapper", name = "deleteUserOperationElementResponse")
    public JAXBElement<UserResult> createDeleteUserOperationElementResponse(UserResult value) {
        return new JAXBElement<UserResult>(_DeleteUserOperationElementResponse_QNAME, UserResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/UserManagementWrapper", name = "readUserOperationElementResponse")
    public JAXBElement<UserResult> createReadUserOperationElementResponse(UserResult value) {
        return new JAXBElement<UserResult>(_ReadUserOperationElementResponse_QNAME, UserResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadUserTypeRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/UserManagementWrapper", name = "readUserOperationElementRequest")
    public JAXBElement<ReadUserTypeRequest> createReadUserOperationElementRequest(ReadUserTypeRequest value) {
        return new JAXBElement<ReadUserTypeRequest>(_ReadUserOperationElementRequest_QNAME, ReadUserTypeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUserTypeRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/UserManagementWrapper", name = "updateUserOperationElementRequest")
    public JAXBElement<UpdateUserTypeRequest> createUpdateUserOperationElementRequest(UpdateUserTypeRequest value) {
        return new JAXBElement<UpdateUserTypeRequest>(_UpdateUserOperationElementRequest_QNAME, UpdateUserTypeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUserTypeRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/UserManagementWrapper", name = "updateUserTypeRequest")
    public JAXBElement<UpdateUserTypeRequest> createUpdateUserTypeRequest(UpdateUserTypeRequest value) {
        return new JAXBElement<UpdateUserTypeRequest>(_UpdateUserTypeRequest_QNAME, UpdateUserTypeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUserTypeRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/UserManagementWrapper", name = "createUserTypeRequest")
    public JAXBElement<CreateUserTypeRequest> createCreateUserTypeRequest(CreateUserTypeRequest value) {
        return new JAXBElement<CreateUserTypeRequest>(_CreateUserTypeRequest_QNAME, CreateUserTypeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserTypeRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/UserManagementWrapper", name = "deleteUserTypeRequest")
    public JAXBElement<DeleteUserTypeRequest> createDeleteUserTypeRequest(DeleteUserTypeRequest value) {
        return new JAXBElement<DeleteUserTypeRequest>(_DeleteUserTypeRequest_QNAME, DeleteUserTypeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUserTypeRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/UserManagementWrapper", name = "createUserOperationElementRequest")
    public JAXBElement<CreateUserTypeRequest> createCreateUserOperationElementRequest(CreateUserTypeRequest value) {
        return new JAXBElement<CreateUserTypeRequest>(_CreateUserOperationElementRequest_QNAME, CreateUserTypeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddSuperiorToUserTypeRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/UserManagementWrapper", name = "addSuperiorToUserOperationElementRequest")
    public JAXBElement<AddSuperiorToUserTypeRequest> createAddSuperiorToUserOperationElementRequest(AddSuperiorToUserTypeRequest value) {
        return new JAXBElement<AddSuperiorToUserTypeRequest>(_AddSuperiorToUserOperationElementRequest_QNAME, AddSuperiorToUserTypeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/UserManagementWrapper", name = "addSuperiorToUserOperationElementResponse")
    public JAXBElement<UserResult> createAddSuperiorToUserOperationElementResponse(UserResult value) {
        return new JAXBElement<UserResult>(_AddSuperiorToUserOperationElementResponse_QNAME, UserResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserTypeRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/UserManagementWrapper", name = "deleteUserOperationElementRequest")
    public JAXBElement<DeleteUserTypeRequest> createDeleteUserOperationElementRequest(DeleteUserTypeRequest value) {
        return new JAXBElement<DeleteUserTypeRequest>(_DeleteUserOperationElementRequest_QNAME, DeleteUserTypeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddSuperiorToUserTypeRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/UserManagementWrapper", name = "addSuperiorToUserTypeRequest")
    public JAXBElement<AddSuperiorToUserTypeRequest> createAddSuperiorToUserTypeRequest(AddSuperiorToUserTypeRequest value) {
        return new JAXBElement<AddSuperiorToUserTypeRequest>(_AddSuperiorToUserTypeRequest_QNAME, AddSuperiorToUserTypeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadUserTypeRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/UserManagementWrapper", name = "readUserTypeRequest")
    public JAXBElement<ReadUserTypeRequest> createReadUserTypeRequest(ReadUserTypeRequest value) {
        return new JAXBElement<ReadUserTypeRequest>(_ReadUserTypeRequest_QNAME, ReadUserTypeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/UserManagementWrapper", name = "createUserOperationElementResponse")
    public JAXBElement<UserResult> createCreateUserOperationElementResponse(UserResult value) {
        return new JAXBElement<UserResult>(_CreateUserOperationElementResponse_QNAME, UserResult.class, null, value);
    }

}
