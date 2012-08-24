
package org.tsk.mng.taskmanagement.task_management_wrapper;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.tsk.mng.taskmanagement.common_elements.task.taskresult.TaskResult;
import org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tsk.mng.taskmanagement.task_management_wrapper package. 
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

    private final static QName _GetUserTasksOperationElementRequest_QNAME = new QName("http://mng.tsk.org/taskManagement/task_management_wrapper", "getUserTasksOperationElementRequest");
    private final static QName _AddDependencyOperationElemetResponse_QNAME = new QName("http://mng.tsk.org/taskManagement/task_management_wrapper", "addDependencyOperationElemetResponse");
    private final static QName _UpdateTaskOperationElemetRequest_QNAME = new QName("http://mng.tsk.org/taskManagement/task_management_wrapper", "updateTaskOperationElemetRequest");
    private final static QName _AddDependencyOperationElemetRequest_QNAME = new QName("http://mng.tsk.org/taskManagement/task_management_wrapper", "addDependencyOperationElemetRequest");
    private final static QName _AddDependencyElemetRequest_QNAME = new QName("http://mng.tsk.org/taskManagement/task_management_wrapper", "addDependencyElemetRequest");
    private final static QName _GetUserTasksTypeRequest_QNAME = new QName("http://mng.tsk.org/taskManagement/task_management_wrapper", "getUserTasksTypeRequest");
    private final static QName _UpdateTaskElemetRequest_QNAME = new QName("http://mng.tsk.org/taskManagement/task_management_wrapper", "updateTaskElemetRequest");
    private final static QName _GetUserTasksOperationElementResponse_QNAME = new QName("http://mng.tsk.org/taskManagement/task_management_wrapper", "getUserTasksOperationElementResponse");
    private final static QName _UpdateTaskOperationElemetResponse_QNAME = new QName("http://mng.tsk.org/taskManagement/task_management_wrapper", "updateTaskOperationElemetResponse");
    private final static QName _RemoveTaskFromUserElementRequest_QNAME = new QName("http://mng.tsk.org/taskManagement/task_management_wrapper", "removeTaskFromUserElementRequest");
    private final static QName _RemoveTaskFromUserOperationElementRequest_QNAME = new QName("http://mng.tsk.org/taskManagement/task_management_wrapper", "removeTaskFromUserOperationElementRequest");
    private final static QName _AssignUserToTaskOperationElementRequest_QNAME = new QName("http://mng.tsk.org/taskManagement/task_management_wrapper", "assignUserToTaskOperationElementRequest");
    private final static QName _AssignUserToTaskOperationElementResponse_QNAME = new QName("http://mng.tsk.org/taskManagement/task_management_wrapper", "assignUserToTaskOperationElementResponse");
    private final static QName _RemoveTaskFromUserOperationElementResponse_QNAME = new QName("http://mng.tsk.org/taskManagement/task_management_wrapper", "removeTaskFromUserOperationElementResponse");
    private final static QName _AssignUserToTaskTypeRequest_QNAME = new QName("http://mng.tsk.org/taskManagement/task_management_wrapper", "assignUserToTaskTypeRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tsk.mng.taskmanagement.task_management_wrapper
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddDependencyElemetRequest }
     * 
     */
    public AddDependencyElemetRequest createAddDependencyElemetRequest() {
        return new AddDependencyElemetRequest();
    }

    /**
     * Create an instance of {@link UpdateTaskElemetRequest }
     * 
     */
    public UpdateTaskElemetRequest createUpdateTaskElemetRequest() {
        return new UpdateTaskElemetRequest();
    }

    /**
     * Create an instance of {@link RemoveTaskFromUserElementRequest }
     * 
     */
    public RemoveTaskFromUserElementRequest createRemoveTaskFromUserElementRequest() {
        return new RemoveTaskFromUserElementRequest();
    }

    /**
     * Create an instance of {@link GetUserTasksTypeRequest }
     * 
     */
    public GetUserTasksTypeRequest createGetUserTasksTypeRequest() {
        return new GetUserTasksTypeRequest();
    }

    /**
     * Create an instance of {@link AssignUserToTaskTypeRequest }
     * 
     */
    public AssignUserToTaskTypeRequest createAssignUserToTaskTypeRequest() {
        return new AssignUserToTaskTypeRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserTasksTypeRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/task_management_wrapper", name = "getUserTasksOperationElementRequest")
    public JAXBElement<GetUserTasksTypeRequest> createGetUserTasksOperationElementRequest(GetUserTasksTypeRequest value) {
        return new JAXBElement<GetUserTasksTypeRequest>(_GetUserTasksOperationElementRequest_QNAME, GetUserTasksTypeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/task_management_wrapper", name = "addDependencyOperationElemetResponse")
    public JAXBElement<UserResult> createAddDependencyOperationElemetResponse(UserResult value) {
        return new JAXBElement<UserResult>(_AddDependencyOperationElemetResponse_QNAME, UserResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateTaskElemetRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/task_management_wrapper", name = "updateTaskOperationElemetRequest")
    public JAXBElement<UpdateTaskElemetRequest> createUpdateTaskOperationElemetRequest(UpdateTaskElemetRequest value) {
        return new JAXBElement<UpdateTaskElemetRequest>(_UpdateTaskOperationElemetRequest_QNAME, UpdateTaskElemetRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddDependencyElemetRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/task_management_wrapper", name = "addDependencyOperationElemetRequest")
    public JAXBElement<AddDependencyElemetRequest> createAddDependencyOperationElemetRequest(AddDependencyElemetRequest value) {
        return new JAXBElement<AddDependencyElemetRequest>(_AddDependencyOperationElemetRequest_QNAME, AddDependencyElemetRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddDependencyElemetRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/task_management_wrapper", name = "addDependencyElemetRequest")
    public JAXBElement<AddDependencyElemetRequest> createAddDependencyElemetRequest(AddDependencyElemetRequest value) {
        return new JAXBElement<AddDependencyElemetRequest>(_AddDependencyElemetRequest_QNAME, AddDependencyElemetRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserTasksTypeRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/task_management_wrapper", name = "getUserTasksTypeRequest")
    public JAXBElement<GetUserTasksTypeRequest> createGetUserTasksTypeRequest(GetUserTasksTypeRequest value) {
        return new JAXBElement<GetUserTasksTypeRequest>(_GetUserTasksTypeRequest_QNAME, GetUserTasksTypeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateTaskElemetRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/task_management_wrapper", name = "updateTaskElemetRequest")
    public JAXBElement<UpdateTaskElemetRequest> createUpdateTaskElemetRequest(UpdateTaskElemetRequest value) {
        return new JAXBElement<UpdateTaskElemetRequest>(_UpdateTaskElemetRequest_QNAME, UpdateTaskElemetRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TaskResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/task_management_wrapper", name = "getUserTasksOperationElementResponse")
    public JAXBElement<TaskResult> createGetUserTasksOperationElementResponse(TaskResult value) {
        return new JAXBElement<TaskResult>(_GetUserTasksOperationElementResponse_QNAME, TaskResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TaskResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/task_management_wrapper", name = "updateTaskOperationElemetResponse")
    public JAXBElement<TaskResult> createUpdateTaskOperationElemetResponse(TaskResult value) {
        return new JAXBElement<TaskResult>(_UpdateTaskOperationElemetResponse_QNAME, TaskResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveTaskFromUserElementRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/task_management_wrapper", name = "removeTaskFromUserElementRequest")
    public JAXBElement<RemoveTaskFromUserElementRequest> createRemoveTaskFromUserElementRequest(RemoveTaskFromUserElementRequest value) {
        return new JAXBElement<RemoveTaskFromUserElementRequest>(_RemoveTaskFromUserElementRequest_QNAME, RemoveTaskFromUserElementRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveTaskFromUserElementRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/task_management_wrapper", name = "removeTaskFromUserOperationElementRequest")
    public JAXBElement<RemoveTaskFromUserElementRequest> createRemoveTaskFromUserOperationElementRequest(RemoveTaskFromUserElementRequest value) {
        return new JAXBElement<RemoveTaskFromUserElementRequest>(_RemoveTaskFromUserOperationElementRequest_QNAME, RemoveTaskFromUserElementRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssignUserToTaskTypeRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/task_management_wrapper", name = "assignUserToTaskOperationElementRequest")
    public JAXBElement<AssignUserToTaskTypeRequest> createAssignUserToTaskOperationElementRequest(AssignUserToTaskTypeRequest value) {
        return new JAXBElement<AssignUserToTaskTypeRequest>(_AssignUserToTaskOperationElementRequest_QNAME, AssignUserToTaskTypeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/task_management_wrapper", name = "assignUserToTaskOperationElementResponse")
    public JAXBElement<UserResult> createAssignUserToTaskOperationElementResponse(UserResult value) {
        return new JAXBElement<UserResult>(_AssignUserToTaskOperationElementResponse_QNAME, UserResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TaskResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/task_management_wrapper", name = "removeTaskFromUserOperationElementResponse")
    public JAXBElement<TaskResult> createRemoveTaskFromUserOperationElementResponse(TaskResult value) {
        return new JAXBElement<TaskResult>(_RemoveTaskFromUserOperationElementResponse_QNAME, TaskResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssignUserToTaskTypeRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/task_management_wrapper", name = "assignUserToTaskTypeRequest")
    public JAXBElement<AssignUserToTaskTypeRequest> createAssignUserToTaskTypeRequest(AssignUserToTaskTypeRequest value) {
        return new JAXBElement<AssignUserToTaskTypeRequest>(_AssignUserToTaskTypeRequest_QNAME, AssignUserToTaskTypeRequest.class, null, value);
    }

}
