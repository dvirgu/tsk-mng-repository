
package org.tsk.mng.taskmanagement.usermanagementwrapper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.tsk.mng.taskmanagement.common_elements.user.userfe.UserFE;


/**
 * <p>Java class for createUserTypeRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createUserTypeRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
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
@XmlType(name = "createUserTypeRequest", propOrder = {
    "user"
})
public class CreateUserTypeRequest {

    @XmlElement(required = true)
    protected UserFE user;

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
