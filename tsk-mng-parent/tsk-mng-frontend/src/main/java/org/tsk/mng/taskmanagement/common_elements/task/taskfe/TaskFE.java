
package org.tsk.mng.taskmanagement.common_elements.task.taskfe;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for taskFE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="taskFE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="taskId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="status" type="{http://mng.tsk.org/taskManagement/common_elements/task/taskFE}TaskStatusType"/>
 *         &lt;element name="descriptions" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deadLine" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="alert" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="owner" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dependentTasks" type="{http://mng.tsk.org/taskManagement/common_elements/task/taskFE}taskFE" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "taskFE", propOrder = {
    "taskId",
    "status",
    "descriptions",
    "deadLine",
    "alert",
    "owner",
    "dependentTasks"
})
public class TaskFE {

    protected int taskId;
    @XmlElement(required = true)
    protected TaskStatusType status;
    @XmlElement(required = true)
    protected String descriptions;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar deadLine;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar alert;
    @XmlElement(required = true)
    protected String owner;
    protected List<TaskFE> dependentTasks;

    /**
     * Gets the value of the taskId property.
     * 
     */
    public int getTaskId() {
        return taskId;
    }

    /**
     * Sets the value of the taskId property.
     * 
     */
    public void setTaskId(int value) {
        this.taskId = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link TaskStatusType }
     *     
     */
    public TaskStatusType getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskStatusType }
     *     
     */
    public void setStatus(TaskStatusType value) {
        this.status = value;
    }

    /**
     * Gets the value of the descriptions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescriptions() {
        return descriptions;
    }

    /**
     * Sets the value of the descriptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescriptions(String value) {
        this.descriptions = value;
    }

    /**
     * Gets the value of the deadLine property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDeadLine() {
        return deadLine;
    }

    /**
     * Sets the value of the deadLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDeadLine(XMLGregorianCalendar value) {
        this.deadLine = value;
    }

    /**
     * Gets the value of the alert property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAlert() {
        return alert;
    }

    /**
     * Sets the value of the alert property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAlert(XMLGregorianCalendar value) {
        this.alert = value;
    }

    /**
     * Gets the value of the owner property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the value of the owner property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwner(String value) {
        this.owner = value;
    }

    /**
     * Gets the value of the dependentTasks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dependentTasks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDependentTasks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaskFE }
     * 
     * 
     */
    public List<TaskFE> getDependentTasks() {
        if (dependentTasks == null) {
            dependentTasks = new ArrayList<TaskFE>();
        }
        return this.dependentTasks;
    }

    /**
     * Sets the value of the dependentTasks property.
     * 
     * @param dependentTasks
     *     allowed object is
     *     {@link TaskFE }
     *     
     */
    public void setDependentTasks(List<TaskFE> dependentTasks) {
        this.dependentTasks = dependentTasks;
    }

}
