
package org.tsk.mng.taskmanagement.common_elements.task.taskresult;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.tsk.mng.taskmanagement.common_elements.resultbase.ResultBase;
import org.tsk.mng.taskmanagement.common_elements.task.taskfe.TaskFE;


/**
 * <p>Java class for taskResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="taskResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://mng.tsk.org/taskManagement/common_elements/resultBase}resultBase">
 *       &lt;sequence>
 *         &lt;element name="taskReturnValues" type="{http://mng.tsk.org/taskManagement/common_elements/task/taskFE}taskFE" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "taskResult", propOrder = {
    "taskReturnValues"
})
public class TaskResult
    extends ResultBase
{

    protected List<TaskFE> taskReturnValues;

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
     * Sets the value of the taskReturnValues property.
     * 
     * @param taskReturnValues
     *     allowed object is
     *     {@link TaskFE }
     *     
     */
    public void setTaskReturnValues(List<TaskFE> taskReturnValues) {
        this.taskReturnValues = taskReturnValues;
    }

}
