
package org.tsk.mng.taskmanagement.common_elements.resultbase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.tsk.mng.taskmanagement.common_elements.opertaionresultstatus.OperationResultStatus;
import org.tsk.mng.taskmanagement.common_elements.task.taskresult.TaskResult;
import org.tsk.mng.taskmanagement.common_elements.user.userresult.UserResult;


/**
 * <p>Java class for resultBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="resultBase">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="resultDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "resultBase", propOrder = {
    "resultDescription",
    "resultStatus"
})
@XmlSeeAlso({
    TaskResult.class,
    UserResult.class
})
public class ResultBase {

    @XmlElement(required = true)
    protected String resultDescription;
    @XmlElement(required = true)
    protected OperationResultStatus resultStatus;

    /**
     * Gets the value of the resultDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultDescription() {
        return resultDescription;
    }

    /**
     * Sets the value of the resultDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultDescription(String value) {
        this.resultDescription = value;
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
