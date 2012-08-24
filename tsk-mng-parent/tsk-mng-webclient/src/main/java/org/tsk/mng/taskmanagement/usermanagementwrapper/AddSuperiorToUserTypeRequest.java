
package org.tsk.mng.taskmanagement.usermanagementwrapper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
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
 *         &lt;element name="worker" type="{http://mng.tsk.org/taskManagement/common_elements/user/userFE}userFE"/>
 *         &lt;element name="superior" type="{http://mng.tsk.org/taskManagement/common_elements/user/userFE}userFE"/>
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
    "worker",
    "superior"
})
public class AddSuperiorToUserTypeRequest {

    @XmlElement(required = true)
    protected UserFE worker;
    @XmlElement(required = true)
    protected UserFE superior;

    /**
     * Gets the value of the worker property.
     * 
     * @return
     *     possible object is
     *     {@link UserFE }
     *     
     */
    public UserFE getWorker() {
        return worker;
    }

    /**
     * Sets the value of the worker property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserFE }
     *     
     */
    public void setWorker(UserFE value) {
        this.worker = value;
    }

    /**
     * Gets the value of the superior property.
     * 
     * @return
     *     possible object is
     *     {@link UserFE }
     *     
     */
    public UserFE getSuperior() {
        return superior;
    }

    /**
     * Sets the value of the superior property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserFE }
     *     
     */
    public void setSuperior(UserFE value) {
        this.superior = value;
    }

}
