
package org.tsk.mng.taskmanagement.common_elements.user.userresult;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.tsk.mng.taskmanagement.common_elements.opertaionresultstatus.OperationResultStatus;
import org.tsk.mng.taskmanagement.common_elements.user.userfe.UserFE;


/**
 * <p>Java class for userResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="userResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userReturnValues" type="{http://mng.tsk.org/taskManagement/common_elements/user/userFE}userFE" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "userResult", propOrder = {
    "userReturnValues",
    "resultStatus"
})
public class UserResult {

    protected List<UserFE> userReturnValues;
    @XmlElement(required = true)
    protected OperationResultStatus resultStatus;

    /**
     * Gets the value of the userReturnValues property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userReturnValues property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserReturnValues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserFE }
     * 
     * 
     */
    public List<UserFE> getUserReturnValues() {
        if (userReturnValues == null) {
            userReturnValues = new ArrayList<UserFE>();
        }
        return this.userReturnValues;
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
