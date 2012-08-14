
package org.tsk.mng.taskmanagement.common_elements.task.taskresult;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.tsk.mng.taskmanagement.common_elements.opertaionresultstatus.OperationResultStatus;
import org.tsk.mng.taskmanagement.common_elements.task.taskfe.TaskFE;


/**
 * <p>Java class for taskResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="taskResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="taskReturnValues" type="{http://mng.tsk.org/taskManagement/common_elements/task/taskFE}taskFE" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="resultStatus" type="{http://mng.tsk.org/taskManagement/common_elements/opertaionResultStatus}OperationResultStatus"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "taskResult", propOrder = {
    "taskReturnValues",
    "resultStatus"
})
public class TaskResult {

    protected List<TaskFE> taskReturnValues;
    @XmlElement(required = true)
    protected OperationResultStatus resultStatus;

    /**
     * Gets the value of the taskReturnValues property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taskReturnValues property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaskReturnValues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaskFE }
     * 
     * 
     */
    public List<TaskFE> getTaskReturnValues() {
        if (taskReturnValues == null) {
            taskReturnValues = new ArrayList<TaskFE>();
        }
        return this.taskReturnValues;
    }

    /**
     * Gets the value of the resultStatus property.
     * 
     * @return
     *     possible object is
     *     {@link OperationResultStatus }
     *     
     */
    public OperationResultStatus getResultStatus() {
        return resultStatus;
    }

    /**
     * Sets the value of the resultStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationResultStatus }
     *     
     */
    public void setResultStatus(OperationResultStatus value) {
        this.resultStatus = value;
    }

}
