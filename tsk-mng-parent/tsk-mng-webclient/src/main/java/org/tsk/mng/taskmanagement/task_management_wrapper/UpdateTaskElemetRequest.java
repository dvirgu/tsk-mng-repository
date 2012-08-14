
package org.tsk.mng.taskmanagement.task_management_wrapper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.tsk.mng.taskmanagement.common_elements.task.taskfe.TaskFE;


/**
 * <p>Java class for updateTaskElemetRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateTaskElemetRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="task" type="{http://mng.tsk.org/taskManagement/common_elements/task/taskFE}taskFE"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateTaskElemetRequest", propOrder = {
    "task"
})
public class UpdateTaskElemetRequest {

    @XmlElement(required = true)
    protected TaskFE task;

    /**
     * Gets the value of the task property.
     * 
     * @return
     *     possible object is
     *     {@link TaskFE }
     *     
     */
    public TaskFE getTask() {
        return task;
    }

    /**
     * Sets the value of the task property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskFE }
     *     
     */
    public void setTask(TaskFE value) {
        this.task = value;
    }

}
