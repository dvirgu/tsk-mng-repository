
package org.tsk.mng.taskmanagement.common_elements.task.taskresult;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tsk.mng.taskmanagement.common_elements.task.taskresult package. 
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

    private final static QName _TaskResult_QNAME = new QName("http://mng.tsk.org/taskManagement/common_elements/task/taskResult", "taskResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tsk.mng.taskmanagement.common_elements.task.taskresult
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TaskResult }
     * 
     */
    public TaskResult createTaskResult() {
        return new TaskResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TaskResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/common_elements/task/taskResult", name = "taskResult")
    public JAXBElement<TaskResult> createTaskResult(TaskResult value) {
        return new JAXBElement<TaskResult>(_TaskResult_QNAME, TaskResult.class, null, value);
    }

}
