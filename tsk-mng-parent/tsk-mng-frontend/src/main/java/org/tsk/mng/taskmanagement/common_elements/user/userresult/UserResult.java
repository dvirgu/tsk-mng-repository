
package org.tsk.mng.taskmanagement.common_elements.user.userresult;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.tsk.mng.taskmanagement.common_elements.resultbase.ResultBase;
import org.tsk.mng.taskmanagement.common_elements.user.userfe.UserFE;


/**
 * <p>Java class for userResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="userResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://mng.tsk.org/taskManagement/common_elements/resultBase}resultBase">
 *       &lt;sequence>
 *         &lt;element name="userReturnValues" type="{http://mng.tsk.org/taskManagement/common_elements/user/userFE}userFE" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userResult", propOrder = {
    "userReturnValues"
})
public class UserResult
    extends ResultBase
{

    protected List<UserFE> userReturnValues;

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
     * Sets the value of the userReturnValues property.
     * 
     * @param userReturnValues
     *     allowed object is
     *     {@link UserFE }
     *     
     */
    public void setUserReturnValues(List<UserFE> userReturnValues) {
        this.userReturnValues = userReturnValues;
    }

}
