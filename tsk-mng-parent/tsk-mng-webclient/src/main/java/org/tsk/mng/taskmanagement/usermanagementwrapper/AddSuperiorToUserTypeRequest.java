
package org.tsk.mng.taskmanagement.usermanagementwrapper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.tsk.mng.taskmanagement.common_elements.task.taskfe.TaskFE;
import org.tsk.mng.taskmanagement.common_elements.user.userfe.UserFE;


/**
 * <p>Java class for addSuperiorToUserTypeRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addSuperiorToUserTypeRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="task" type="{http://mng.tsk.org/taskManagement/common_elements/task/taskFE}taskFE"/>
 *         &lt;element name="user" type="{http://mng.tsk.org/taskManagement/common_elements/user/userFE}userFE"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addSuperiorToUserTypeRequest", propOrder = {
    "task",
    "user"
})
public class AddSuperiorToUserTypeRequest {

    @XmlElement(required = true)
    protected TaskFE task;
    @XmlElement(required = true)
    protected UserFE user;

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

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link UserFE }
     *     
     */
    public UserFE getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserFE }
     *     
     */
    public void setUser(UserFE value) {
        this.user = value;
    }

}
