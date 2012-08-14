
package org.tsk.mng.taskmanagement.common_elements.task.taskfe;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tsk.mng.taskmanagement.common_elements.task.taskfe package. 
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

    private final static QName _TaskFE_QNAME = new QName("http://mng.tsk.org/taskManagement/common_elements/task/taskFE", "taskFE");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tsk.mng.taskmanagement.common_elements.task.taskfe
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TaskFE }
     * 
     */
    public TaskFE createTaskFE() {
        return new TaskFE();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TaskFE }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/common_elements/task/taskFE", name = "taskFE")
    public JAXBElement<TaskFE> createTaskFE(TaskFE value) {
        return new JAXBElement<TaskFE>(_TaskFE_QNAME, TaskFE.class, null, value);
    }

}
